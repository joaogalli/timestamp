package br.com.sovi.timestamp.ui.group;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.widget.Toast;

import br.com.sovi.timestamp.domain.Group;

/**
 * Created by Joao on 23/10/2016.
 */

public class GroupPresenter {

    private GroupActivity groupActivity;

    public GroupPresenter(GroupActivity groupActivity) {
        this.groupActivity = groupActivity;
    }

    public Cursor findAllTimestamps() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{Group.ID,Group.NAME});
        matrixCursor.addRow(new Object[]{1L, "Timestamp 1"});
        matrixCursor.addRow(new Object[]{2L, "Timestamp 2"});
        matrixCursor.addRow(new Object[]{3L, "Timestamp 3"});
        return matrixCursor;
    }

    public void addTimestamp(long groupId) {
        Toast.makeText(groupActivity, "Add timestamp", Toast.LENGTH_SHORT).show();
    }

    public void removeLastTimestamp(long groupId) {
        Toast.makeText(groupActivity, "Removed last timestamp", Toast.LENGTH_SHORT).show();
    }
}
