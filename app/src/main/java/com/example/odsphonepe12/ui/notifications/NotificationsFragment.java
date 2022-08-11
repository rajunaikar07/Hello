package com.example.odsphonepe12.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odsphonepe12.R;
import com.example.odsphonepe12.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    ModelClass modelClass;
    List<ModelClass> modelClassList=new ArrayList<>();


    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        binding=FragmentNotificationsBinding.inflate(inflater,container,false);
        View root=binding.getRoot();
        recyclerView=root.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        userAdapter=new UserAdapter(getContext(),modelClassList);
        recyclerView.setAdapter(userAdapter);

        LoadData();
        return root;
    }

    private void LoadData() {
        modelClass = new ModelClass(R.drawable.ic_baseline_arrow_outward_24,R.drawable.sbank,"2 mins ago","Paid To","Raju","RS:500","Debited from");
        modelClassList.add(modelClass);
        modelClass = new ModelClass(R.drawable.ic_baseline_call_received_24,R.drawable.abank,"1 days ago","Received from","karuna","RS:2500","Credited to");
        modelClassList.add(modelClass);
        modelClass = new ModelClass(R.drawable.ic_baseline_arrow_outward_24,R.drawable.sbank,"2 days ago","Paid To","Tamanna","RS:5500","Debited from");
        modelClassList.add(modelClass);
        modelClass = new ModelClass(R.drawable.ic_baseline_call_received_24,R.drawable.sbank,"4 days ago","Received from","sai","RS:500","Credited to");
        modelClassList.add(modelClass);
        modelClass = new ModelClass(R.drawable.ic_baseline_arrow_outward_24,R.drawable.abank," 4 days ago","Paid To","ram","RS:200","Debited from");
        modelClassList.add(modelClass);
        modelClass = new ModelClass(R.drawable.ic_baseline_arrow_outward_24,R.drawable.abank,"5 days ago","Paid To","sanjay","RS:220","Debited from");
        modelClassList.add(modelClass);
        modelClass = new ModelClass(R.drawable.ic_baseline_arrow_outward_24,R.drawable.abank,"7 days ago","Paid To","ruksana","RS:500","Debited from");
        modelClassList.add(modelClass);
        modelClass = new ModelClass(R.drawable.ic_baseline_call_received_24,R.drawable.sbank,"7 days ago","Received from","Anand","RS:1000","Credited to");
        modelClassList.add(modelClass);
        modelClass = new ModelClass(R.drawable.ic_baseline_arrow_outward_24,R.drawable.sbank,"8 days ago","Paid To","Naziya","RS:5000","Debited from");
        modelClassList.add(modelClass);
        modelClass = new ModelClass(R.drawable.ic_baseline_call_received_24,R.drawable.sbank,"8 days ago","Received from","Harish","RS:300","Credited from");
        modelClassList.add(modelClass);
        modelClass = new ModelClass(R.drawable.ic_baseline_arrow_outward_24,R.drawable.sbank,"9 days ago","Paid To","Lakshmi","RS:100","Debited from");
        modelClassList.add(modelClass);
        modelClass = new ModelClass(R.drawable.ic_baseline_arrow_outward_24,R.drawable.abank,"9 days ago","Paid To","Aishwarya","RS:10000","Credited from");
        modelClassList.add(modelClass);
    }







    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}