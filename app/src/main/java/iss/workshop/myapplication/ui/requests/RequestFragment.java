package iss.workshop.myapplication.ui.requests;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import iss.workshop.myapplication.R;
import iss.workshop.myapplication.model.Contact;
import iss.workshop.myapplication.model.Request;

public class RequestFragment extends Fragment {

    private RequestViewModel requestViewModel;
    ArrayList<Request> RequestList = new ArrayList<>();
    RecyclerView recyclerView;
    private JSONObject jsonObjectForREQUEST;
    private String webServiceMessage = "Fail";
    private JSONArray jsonArrayResDataForREQUEST;
    RequestAdapter adapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new GetFlightAsync().execute();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        requestViewModel =
//                ViewModelProviders.of(this).get(RequestViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_request, container, false);
//
//        // final TextView textView = root.findViewById(R.id.text_req);
//        recyclerView = (RecyclerView) root.findViewById(R.id.rvContacts);
//        adapter = new RequestAdapter(RequestList);
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//      return root;

            requestViewModel =
                    ViewModelProviders.of(this).get(RequestViewModel.class);
            View root = inflater.inflate(R.layout.fragment_request, container, false);
            // final TextView textView = root.findViewById(R.id.text_req);
            recyclerView = (RecyclerView) root.findViewById(R.id.rvContacts);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter = new RequestAdapter(RequestList);
            recyclerView.setAdapter(adapter);
            new GetFlightAsync().execute();
            //adapter.notifyDataSetChanged();
            return root;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void setUpRecyclerView() {
        adapter = new RequestAdapter(RequestList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    public class GetFlightAsync extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i("onPreExecute","onPreExecute");
        }

        @Override
        protected String doInBackground(Void... voids) {
            String url = "http://192.168.1.89:82/request/getTop5Request";

            RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
            JsonArrayRequest objectRequest = new JsonArrayRequest(
                    com.android.volley.Request.Method.GET,
                    url, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            webServiceMessage = "Success";
                            jsonArrayResDataForREQUEST = response;
                            if (webServiceMessage.equals("Success")) {
                                RequestList.clear();
                                for (int i = 0; i < jsonArrayResDataForREQUEST.length(); i++) {
                                    try {
                                        jsonObjectForREQUEST = jsonArrayResDataForREQUEST.getJSONObject(i);
                                        Request r=new Request();
                                        RequestList.add(r.ConvertModelObject(jsonObjectForREQUEST));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                               // setUpRecyclerView();

                            }

                        }

                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("Req", String.valueOf(error));
                            webServiceMessage = "fail";
                        }
                    }

            );
            requestQueue.add(objectRequest);
            return webServiceMessage;
        }

        @Override
        protected void onPostExecute(String result) {
            adapter.notifyDataSetChanged();
        }



    }
}



