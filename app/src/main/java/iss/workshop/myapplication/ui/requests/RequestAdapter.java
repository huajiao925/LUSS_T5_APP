package iss.workshop.myapplication.ui.requests;

        import android.app.Activity;
        import android.content.Context;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentTransaction;
        import androidx.recyclerview.widget.RecyclerView;

        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonArrayRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.List;

        import iss.workshop.myapplication.R;
        import iss.workshop.myapplication.model.Request;

public class RequestAdapter extends
        RecyclerView.Adapter<RequestAdapter.ViewHolder> {
    private List<Request> mRequests;

    public RequestAdapter(ArrayList<Request> requestList){
        this.mRequests=requestList;

    }

    public void updateDataRequestRecycler(ArrayList<Request> viewModels) {
        mRequests.clear();
        mRequests.addAll(viewModels);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.req_list_view_item,viewGroup,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       // holder.nameTextView.setText(mRequests.get(position).RequestBy);
        holder.nameTextView.setText("Wai");

        holder.layoutClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              System.out.println("Press!!!!!");
//                Intent intent = new Intent(activity, DetailActivity.class);
//                intent.putExtra("flight_no", flightNoList.get(position));
//                activity.startActivity(intent);
//                activity.finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRequests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView pointTextView;
        public LinearLayout layoutClick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.user_name_text);
            layoutClick = itemView.findViewById(R.id.rowClick);
        }

    }
}