package example.android.contextmenusample;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;




public class ContextMenuSampleActivity extends Activity {

	List<String> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_context_menu_sample);

		list = new ArrayList<String>();
		list.add("�I��1");
		list.add("�I��2");
		list.add("�I��3");

		ListAdapter adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_checked,
				list);

		ListView listView = (ListView) findViewById(R.id.lv_item);
		listView.setAdapter(adapter);

		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

		listView.setMultiChoiceModeListener(new ListViewChoiceListener());
	}

	class ListViewChoiceListener implements MultiChoiceModeListener {


		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			ListView listView = (ListView) findViewById(R.id.lv_item);
			TextView textView = (TextView) findViewById(R.id.tv_message);

			SparseBooleanArray list = listView.getCheckedItemPositions();
			String selectedItem = "(�I�����ꂽ�A�C�e��:";
			for (int i = 0; i < list.size(); i++) {
				selectedItem += " " + listView.getItemAtPosition(list.keyAt(i));
			}
			selectedItem += ")";


			textView.setText("�R���e�L�X�g���j���[�őI��:" + item.getTitle() + selectedItem);
			mode.finish();

			return true;
		}

		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			MenuInflater inflater = mode.getMenuInflater();
			inflater.inflate(R.menu.context_menu_sample, menu);

			return true;
		}

		public void onDestroyActionMode(ActionMode mode) {
			// TODO �����������ꂽ���\�b�h�E�X�^�u

		}

		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			return false;
		}

		public void onItemCheckedStateChanged(ActionMode mode, int menu,
				long arg2, boolean arg3) {
			// TODO �����������ꂽ���\�b�h�E�X�^�u

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.context_menu_sample, menu);
		return true;
	}

}
