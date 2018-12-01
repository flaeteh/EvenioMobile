package tehtuble.com.eveniomobile.Model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Registration {


    public void registerUser(EditText name, EditText email, EditText studNum, EditText password,
                             String role, FirebaseAuth auth, Context context) {
        String et_name = name.getText().toString().trim();
        String et_email = email.getText().toString().trim();
        String et_password = password.getText().toString().trim();
        String et_studNum = studNum.getText().toString().trim();
        String et_role = role;

        if (et_name.isEmpty()) {
            name.setError("First Name is Required!");
            name.requestFocus();
            return;
        }

        if (et_email.isEmpty()) {
            email.setError("First Name is Required!");
            email.requestFocus();
            return;
        }

        if (et_studNum.isEmpty()) {
            studNum.setError("First Name is Required!");
            studNum.requestFocus();
            return;
        }

        if (et_password.isEmpty()) {
            password.setError("First Name is Required!");
            password.requestFocus();
            return;
        }

        if (et_role.isEmpty()) {
            Toast.makeText(context, "Please select a user role", Toast.LENGTH_LONG).show();
            return;
        }

        userAndEmailAuth(et_email, et_password, context, auth, et_name, et_studNum, et_role);

    }

    private void userAndEmailAuth(final String email, String password,
                                  final Context context, final FirebaseAuth auth,
                                  final String name, final String studNum,
                                  final String role) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            Users user = new Users(name, email, studNum, role);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(auth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        Toast.makeText(context, "Registration is Successful!", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(context, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                        } else {
                            Toast.makeText(context, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }


}
