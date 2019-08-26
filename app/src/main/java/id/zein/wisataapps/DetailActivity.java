package id.zein.wisataapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



    public class DetailActivity extends AppCompatActivity {

        private TextView tvTitle, tvDesc;
        private ImageView ivImage;
        private ImageButton ibBack;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.detail_activity);
            setTitle("Description");

            tvTitle = findViewById(R.id.text_name);
            tvDesc = findViewById(R.id.text_desc);
            ivImage = findViewById(R.id.image);
            ibBack = findViewById(R.id.btn_back);
            tvTitle.setText(getIntent().getStringExtra("title"));
            tvDesc.setText(getIntent().getIntExtra("desc", 0));
            ivImage.setImageResource(getIntent().getIntExtra("image", 0));

            ibBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    finishAffinity();
                }
            });
        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            Intent intent = new Intent(DetailActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finishAffinity();
        }
    }
