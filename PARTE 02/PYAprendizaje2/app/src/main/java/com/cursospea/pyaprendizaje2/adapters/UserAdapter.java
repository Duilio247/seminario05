package com.cursospea.pyaprendizaje2.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cursospea.pyaprendizaje2.R;
import com.cursospea.pyaprendizaje2.model.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    private Context context;
    private List<User> users;

    public UserAdapter(Context context, List<User> users) {
        super(context, 0, users);
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        }

        User currentUser = users.get(position);

        TextView nameTextView = listItemView.findViewById(R.id.user_name);
        TextView professionTextView = listItemView.findViewById(R.id.user_profession);
        TextView emailTextView = listItemView.findViewById(R.id.user_email);
        TextView phoneTextView = listItemView.findViewById(R.id.user_phone); // Aquí sigue el ID viejo "user_age"
        ImageView avatarImageView = listItemView.findViewById(R.id.user_avatar);

        nameTextView.setText(currentUser.getName());
        professionTextView.setText("Prof. " + currentUser.getProfession());
        emailTextView.setText("E-mail: " + currentUser.getEmail());
        phoneTextView.setText("Tel: " + currentUser.getPhone());

        if (currentUser.getAvatarUri() != null && !currentUser.getAvatarUri().isEmpty()) {
            avatarImageView.setImageURI(Uri.parse(currentUser.getAvatarUri()));
        } else {
            avatarImageView.setImageResource(R.drawable.default_avatar);
        }

        return listItemView;
    }
}
