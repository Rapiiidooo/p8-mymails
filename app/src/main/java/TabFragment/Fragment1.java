package TabFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.paris8.rapido.slide_menu.MyWebView;
import com.paris8.rapido.slide_menu.R;
/**
 * Created by Rapido on 12/11/2016.
 */

public class Fragment1 extends Fragment {

    private Button gmailButton;
    private Button outlookButton;
    private Button yahooButton;
    private Button autreButton;
    View v;

    @Override
    public View onCreateView(final LayoutInflater inflater, final @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment2_layout, container, false);

        gmailButton = (Button) v.findViewById(R.id.gmailButton);
        outlookButton = (Button) v.findViewById(R.id.outlookButton);
        yahooButton = (Button) v.findViewById(R.id.yahooButton);
        autreButton = (Button) v.findViewById(R.id.autreButton);

        gmailButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Fragment1.this.getActivity(), MyWebView.class));
            }
        });


        outlookButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Fragment1.this.getActivity(), MyWebView.class));
            }
        });

        return v;
    }
}
