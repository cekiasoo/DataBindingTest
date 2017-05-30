package com.ce.advanced.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ce.advanced.R;
import com.ce.advanced.bean.User2;
import com.ce.advanced.databinding.FragmentUserBinding;
import com.ce.advanced.event.UserFragmentPresenter;
import com.ce.advanced.recycler.UserAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UsersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UsersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsersFragment extends Fragment implements UserFragmentPresenter.OnUserAddListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private FragmentUserBinding mUsersBinding;

//    private UserAdapter mUserAdapter;

    private UserAdapter mUserAdapter;

    public UsersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UsersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UsersFragment newInstance(String param1, String param2) {
        UsersFragment fragment = new UsersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        mUsersBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false);
        return mUsersBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        /*mUserAdapter = new UserAdapter(getContext(), getData());
        mUsersBinding.setAdapter(mUserAdapter);*/
        mUserAdapter = new UserAdapter(getContext(), getData());
        mUsersBinding.setLayoutManager(new LinearLayoutManager(getContext()));
        mUsersBinding.setAdapter2(mUserAdapter);
        UserFragmentPresenter _Presenter = new UserFragmentPresenter();
        _Presenter.setOnUserAddListener(this);
        mUsersBinding.setPresenter(_Presenter);
    }

    private List<User2> getData() {
        List<User2> _Users = new ArrayList<>();
        _Users.add(new User2("Java", "1"));
        _Users.add(new User2("C", "2"));
        _Users.add(new User2("C++", "3"));
        _Users.add(new User2("Python", "4"));
        _Users.add(new User2("C#", "5"));
        _Users.add(new User2(".NET", "6"));
        _Users.add(new User2("JavaScript", "7"));
        _Users.add(new User2("Assembly", "8"));
        _Users.add(new User2("PHP", "9"));
        _Users.add(new User2("Perl", "10"));
        _Users.add(new User2("Ruby", "11"));
        _Users.add(new User2("VB", "12"));
        _Users.add(new User2("Swift", "13"));
        _Users.add(new User2("R", "14"));
        _Users.add(new User2("Objective-C", "15"));
        return _Users;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mUsersBinding.toolbar);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onUserAdd() {
        List<User2> _Users = getData();
        mUserAdapter.addItem(0, _Users.get(new Random().nextInt(_Users.size())));
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
