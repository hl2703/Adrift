package sg.edu.np.adrift;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class SelectAdapter extends RecyclerView.Adapter<SelectViewHolder> {

    ArrayList<selectObject> data ;

    //default 4 parts

    public SelectAdapter(ArrayList<selectObject> input){
        data=input;
    }

    public SelectViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View item;

        item = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);



        return new SelectViewHolder(item);
    }

    public void onBindViewHolder(SelectViewHolder holder, int position){
       selectObject listObjects = data.get(position);


           holder.image.setImageResource(listObjects.getImage());
           holder.txt.setText(listObjects.getText1());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//link to different activities based on position
                if (position == 0) {
                    Intent intent = new Intent(holder.txt.getContext(), MusicActivity.class);
                    intent.putExtra("Name", listObjects.getText1()); //send info to new activity in a map

                    holder.txt.getContext().startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(holder.txt.getContext(), MusicActivity2.class);
                    intent.putExtra("Name", listObjects.getText1());
                    holder.txt.getContext().startActivity(intent);
                }

                else if (position == 2) {
                    Intent intent = new Intent(holder.txt.getContext(), MusicActivity3.class);
                    intent.putExtra("Name", listObjects.getText1());
                    holder.txt.getContext().startActivity(intent);
                }
            }
        });



    }

    public int getItemCount(){
    return data.size();
    }
    @Override
    public int getItemViewType(int position){
        position = position%2;
        if (position == 0){
            return 0;
        }
        else{
            return 1;
        }
    }
}
