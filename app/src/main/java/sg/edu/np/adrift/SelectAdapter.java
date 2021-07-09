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

       //if(position==0) {
           holder.image.setImageResource(listObjects.getImage());
           holder.txt.setText(listObjects.getText1());
       //}

       //else{
          // holder.image.setImageResource(listObjects.getImage());
       //}
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(holder.txt.getContext(), MusicActivity.class);

                intent.putExtra("index",position);
                holder.txt.getContext().startActivity(intent);
*/


                if (position == 0) {
                    Intent intent = new Intent(holder.txt.getContext(), MusicActivity.class);
                    intent.putExtra("Name", listObjects.getText1()); //send info to new activity in a map

                    //intent.putExtra("index","0");
                    //intent.putExtra("music",R.raw.forest);
                    holder.txt.getContext().startActivity(intent);

                   /* File audio = new File("/res//raw/forest.mp3");
                    Intent intent2 = new Intent(Intent.ACTION_SEND).setType("audio/*");
                    intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(audio));
                    holder.txt.getContext().startActivity(Intent.createChooser(intent, "music"));*/
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
               // Log.d("Debug", "Image clicked");

                /*new AlertDialog.Builder(holder.txt.getContext())
                        .setTitle("Profile")
                        .setMessage("hello")
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent viewProfile = new Intent(holder.txt.getContext(), MainActivity.class);
                                viewProfile.putExtra("id", position);
                                holder.txt.getContext().startActivity(viewProfile);
                            }
                        })
                        .setNegativeButton("Close", null)
                        .show();

            }
        });*/



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
