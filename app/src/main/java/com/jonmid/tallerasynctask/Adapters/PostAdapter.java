package com.jonmid.tallerasynctask.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonmid.tallerasynctask.Models.Post;
import com.jonmid.tallerasynctask.R;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

    List<Post> myPost = new ArrayList<>();
    Context context;

    public PostAdapter(List<Post> myPost, Context context) {
        this.myPost = myPost;
        this.context = context;
    }

    @Override
    //Vincular mi vista (item.xml) con la vista principal (activity_main.xml)
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inyecta mi layout (item.xml) en la vista pricipal
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item , parent , false);

        //Crea un objeto de la subclase para manejr y asignar los componentes del layout (item.xml)
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Lanza la vista en mi layout principal (activity_main)

        //Establecer el valor de mi TextView con el valor del JSON
        holder.myText.setText(myPost.get(position).getTitle());
        holder.myBody.setText(myPost.get(position).getBody());

    }

    @Override
    //Cuenta todos los items de la lista
    public int getItemCount() {
        return myPost.size();
    }

    //Permite administrar mi vista en el RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView myImage;
        TextView myText;
        TextView myBody;

        //Constructor de mi subclase
        public ViewHolder(View item)  {
            super(item);
            myImage = (ImageView) item.findViewById(R.id.logo);
            myText = (TextView) item.findViewById(R.id.txt_item);
            myBody = (TextView) item.findViewById(R.id.txt_body);
        }
    }
}
