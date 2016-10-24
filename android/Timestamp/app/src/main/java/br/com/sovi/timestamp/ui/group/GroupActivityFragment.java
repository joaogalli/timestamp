package br.com.sovi.timestamp.ui.group;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import br.com.sovi.timestamp.R;
import br.com.sovi.timestamp.domain.Group;

/**
 * A placeholder fragment containing a simple view.
 */
public class GroupActivityFragment extends Fragment {

    private GroupPresenter presenter;

    private ListView listView;

    private ResourceCursorAdapter adapter;

    public GroupActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = ((GroupActivity) getActivity()).getPresenter();

        View view = inflater.inflate(R.layout.fragment_group, container, false);

        listView = (ListView) view.findViewById(R.id.timestampList);
        listView.setEmptyView(view.findViewById(R.id.emptyView));

        adapter = new ResourceCursorAdapter(getContext(), R.layout.group_row, null, false) {
            @Override
            public void bindView(View view, Context context, final Cursor cursor) {
                TextView textView = (TextView) view.findViewById(R.id.timestampNameTextView);
                textView.setText(cursor.getString(cursor.getColumnIndex(Group.NAME)));

                Button addButton = (Button) view.findViewById(R.id.addButton);
                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        presenter.addTimestamp(cursor.getLong(cursor.getColumnIndex(Group.ID)));
                    }
                });

                Button removeButton = (Button) view.findViewById(R.id.removeButton);
                removeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        presenter.removeLastTimestamp(cursor.getLong(cursor.getColumnIndex(Group.ID)));
                    }
                });
            }
        };

        listView.setAdapter(adapter);

        adapter.swapCursor(presenter.findAllTimestamps());

        return view;
    }
}
