package tehtuble.com.eveniomobile.Model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class UserProfile {


    public void getUserProfile(DatabaseReference profileReference, final TextView name, final TextView email, final TextView studNum){

        profileReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String username = dataSnapshot.child("name").getValue().toString();
                    String userEmail = dataSnapshot.child("email").getValue().toString();
                    String studentNum = dataSnapshot.child("idNum").getValue().toString();

                    name.setText(username);
                    email.setText(userEmail);
                    studNum.setText(studentNum);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
