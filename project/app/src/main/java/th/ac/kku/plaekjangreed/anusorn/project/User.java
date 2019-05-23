package th.ac.kku.plaekjangreed.anusorn.project;

import android.widget.Toast;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class User {

    public  String username ;
    public String email;

    public User(){

    }

    public User(String username,String email){
        this.username = username ;
        this.email = email;
    }

    @Exclude
    public Map<String,Object> toMap(){
        HashMap<String,Object> result = new HashMap<>();
        result.put("username",username);
        result.put("email",email);
        return  result;
    }

}
