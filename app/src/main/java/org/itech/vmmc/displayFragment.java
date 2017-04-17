package org.itech.vmmc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.   
 * Activities that contain this fragment must implement the
 * {@link DisplayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DisplayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayFragment extends Fragment implements AbsListView.OnItemClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";
    public static String LOG = "gnr";
    public String displayType = "";
    public IndexParts indexParts = new IndexParts("");
    public DisplayParts displayParts = new DisplayParts("");
    List<Booking> bookings = new ArrayList<Booking>();
    List<Person> persons = new ArrayList<Person>();
    List<Client> clients = new ArrayList<Client>();

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mListener != null) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.

            displayParts = new DisplayParts(mAdapter.getItem(position).toString());
            Log.d(LOG, "DisplayFragment onItemClick: " + displayType + " " + mAdapter.getItem(position).toString());
            Log.d(LOG, "DisplayFragment displayParts: " + displayParts.get_first_name() + " " + displayParts.get_last_name() + " " + displayParts.get_national_id() + " " + displayParts.get_phone());


            Fragment fragment;
            if (displayType == "displayBooking") {
                fragment = EditBookingFragment.newInstance("editBooking", displayParts.get_first_name() + " " + displayParts.get_last_name() + ":" + displayParts.get_national_id() + ":" + displayParts.get_phone() + ":" + displayParts.get_projected_date());
                getFragmentManager().beginTransaction().replace(R.id.container, fragment, EditBookingFragment.TAG).addToBackStack("EditBooking").commit();

            } else if (displayType == "displayPerson") {
                fragment = EditPersonFragment.newInstance("editPerson", displayParts.get_first_name() + " " + displayParts.get_last_name() + ":" + displayParts.get_national_id() + ":" + displayParts.get_phone());
                getFragmentManager().beginTransaction().replace(R.id.container, fragment, EditPersonFragment.TAG).addToBackStack("EditPerson").commit();

            } else if (displayType == "displayClient") {
                Log.d(LOG, "DisplayFragment editClient: " + displayParts.get_first_name() + " " + displayParts.get_last_name() + " " + displayParts.get_national_id() + " " + displayParts.get_phone());
                fragment = EditClientFragment.newInstance("editClient", displayParts.get_first_name() + " " + displayParts.get_last_name() + ":" + displayParts.get_national_id() + ":" + displayParts.get_phone());
                getFragmentManager().beginTransaction().replace(R.id.container, fragment, EditClientFragment.TAG).addToBackStack("EditClient").commit();
            }
        }
    }

    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    public static String TAG = "DisplayTag";
    public DBHelper dbHelp;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private AbsListView mListView;
    private ListAdapter mAdapter;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
     * @return A new instance of fragment DisplayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DisplayFragment newInstance(String display, String displayParams) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString("display", display);
        args.putString("displayParams", displayParams);
        fragment.setArguments(args);
        return fragment;
    }

    public DisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("display");
            mParam2 = getArguments().getString("displayParams");
            Log.d(LOG, "DisplayFragment onCreate param1: " + mParam1.toString());
            Log.d(LOG, "DisplayFragment onCreate param2:>" + mParam2.toString() + "<");
        }

        displayType = mParam1.toString();
//        indexParts = new IndexParts(mParam2.toString());
        DBHelper dbHelp = new DBHelper(getActivity());
        this.dbHelp = dbHelp;

//        Log.d(LOG, "DisplayFragment onCreate first_name: " + indexParts.get_first_name());
//        Log.d(LOG, "DisplayFragment onCreate last_name: " + indexParts.get_last_name());

        if (displayType == "displayBooking" ) {
            bookings = dbHelp.getAllBookings();
            String[] _stringArray = new String[bookings.size()];
            int i = 0;
            for (Booking _rec : bookings) {
                _stringArray[i] =
                        _rec.get_first_name() + " " + _rec.get_last_name() + ", " + _rec.get_national_id() + ", " + _rec.get_phone() + ", " + _rec.get_projected_date();
                i++;
            }
            mAdapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, android.R.id.text1, _stringArray);

        } else if (displayType == "displayPerson") {
            persons = dbHelp.getAllPersons();
            String[] _stringArray = new String[persons.size()];
            int i = 0;
            for (Person _rec : persons) {
                _stringArray[i] =
                        _rec.get_first_name() + " " + _rec.get_last_name() + ", " + _rec.get_national_id() + ", " + _rec.get_phone();
                i++;
            }
            mAdapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, android.R.id.text1, _stringArray);

        } else if (displayType == "displayClient") {
            clients = dbHelp.getAllClients();
            String[] _stringArray = new String[clients.size()];
            int i = 0;
            for (Client _rec : clients) {
                _stringArray[i] =
                        _rec.get_first_name() + " " + _rec.get_last_name() + ", " + _rec.get_national_id() + ", " + _rec.get_phone();
                i++;
            }
            mAdapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, android.R.id.text1, _stringArray);

        } else if (displayType == "") {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recent, container, false);

        getActivity().setTitle(getResources().getString(R.string.displayTitle));

        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(int position);
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}