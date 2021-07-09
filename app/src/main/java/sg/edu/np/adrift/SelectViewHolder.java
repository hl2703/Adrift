package sg.edu.np.adrift;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SelectViewHolder extends RecyclerView.ViewHolder {

    TextView txt;
    ImageView image;
    public SelectViewHolder(View itemView) {
        super(itemView);
        txt = itemView.findViewById(R.id.myText);
        image = itemView.findViewById(R.id.imageView);
    }


}
