package com.chcovid19project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.chcovid19project.MedicalStoresActivity;
import com.chcovid19project.OrphanageSupport.FreeFoodActivity;
import com.chcovid19project.TollNumbersActivity;
import com.bumptech.glide.Glide;

import com.chcovid19project.CoronaActivity;
import com.chcovid19project.FAQsActivity;
import com.chcovid19project.HomeTreamentActivity;
import com.chcovid19project.HospitalAdmissionActivity;
import com.chcovid19project.Models.Jsons;
import com.chcovid19project.MyHealthStatusActivity;
import com.chcovid19project.OnlineDoctorsActivity;
import com.chcovid19project.OnlineEducationActivity;
import com.chcovid19project.OrphanageSupportActivity;
import com.chcovid19project.R;
import com.chcovid19project.TestLabsActivity;
import com.chcovid19project.TweetsActivity;
import com.chcovid19project.VolunteersActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ImageViewHolder> {

    private Context mContext;
    private int[] Image;
    private String[] Title;
    private DatabaseReference mJsonDatabase;

    public MainAdapter(Context context, String[] titles, int[] images) {
        mContext = context;
        Image = images;
        Title = titles;
        mJsonDatabase = FirebaseDatabase.getInstance().getReference().child("Jsons");
        mJsonDatabase.keepSynced(true);
    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_grid_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {

        holder.Title.setText(Title[position]);
        Glide.with(mContext)
                .load(Image[position])
                .into(holder.Image);
        mJsonDatabase = FirebaseDatabase.getInstance().getReference().child("Jsons");
        mJsonDatabase.keepSynced(true);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mJsonDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        final Jsons jsons = dataSnapshot.getValue(Jsons.class);
                        switch (holder.getAdapterPosition()) {
                            case 0:
                                Intent coronaintent = new Intent(mContext, CoronaActivity.class);
                                coronaintent.putExtra("url", jsons.getCorona());
                                mContext.startActivity(coronaintent);
                                break;
                            case 1:
                                Intent hometreatmentintent = new Intent(mContext, HomeTreamentActivity.class);
                                hometreatmentintent.putExtra("image_url", jsons.getHome_treatment_images());
                                hometreatmentintent.putExtra("link_url", jsons.getHome_treatment_links());
                                mContext.startActivity(hometreatmentintent);
                                break;

                            case 2:
                                Intent tollnumbersintent = new Intent(mContext, TollNumbersActivity.class);
                                tollnumbersintent.putExtra("url", jsons.getToll_numbers());
                                mContext.startActivity(tollnumbersintent);
                                break;

                            case 3:
                                Intent myhealthstatusintent = new Intent(mContext, MyHealthStatusActivity.class);
                                mContext.startActivity(myhealthstatusintent);
                                break;

                            case 4:
                                Intent medicalstoresintent = new Intent(mContext, MedicalStoresActivity.class);
                                mContext.startActivity(medicalstoresintent);
                                break;
                            case 5:
                                Intent onlinedoctorintent = new Intent(mContext, OnlineDoctorsActivity.class);
                                mContext.startActivity(onlinedoctorintent);
                                break;
                            case 6:
                                Intent hospitaladmissionintent = new Intent(mContext, HospitalAdmissionActivity.class);
                                mContext.startActivity(hospitaladmissionintent);
                                break;

                            case 7:
                                Intent volunteersintent = new Intent(mContext, VolunteersActivity.class);
                                mContext.startActivity(volunteersintent);
                                break;
                            case 8:
                                Intent freefoodintent = new Intent(mContext, FreeFoodActivity.class);
                                mContext.startActivity(freefoodintent);
                                break;

                            case 9:
                                Intent testlabsintent = new Intent(mContext, TestLabsActivity.class);
                                testlabsintent.putExtra("url", jsons.getLab_test());
                                mContext.startActivity(testlabsintent);
                                break;

                            case 10:
                                Intent orphanagesupportintent = new Intent(mContext, OrphanageSupportActivity.class);
                                orphanagesupportintent.putExtra("url", jsons.getHomes());
                                mContext.startActivity(orphanagesupportintent);
                                break;

                            case 11:
                                Intent epassintent = new Intent(Intent.ACTION_VIEW);
                                epassintent.setData(Uri.parse(jsons.getEpass()));
                                mContext.startActivity(epassintent);
                                break;

                            case 12:
                                Intent donateintent = new Intent(Intent.ACTION_VIEW);
                                donateintent.setData(Uri.parse(jsons.getDonate()));
                                mContext.startActivity(donateintent);
                                break;

                            case 13:
                                Intent foreignintent = new Intent(Intent.ACTION_VIEW);
                                foreignintent.setData(Uri.parse(jsons.getForeign()));
                                mContext.startActivity(foreignintent);
                                break;

                            case 14:
                                Intent migrantintent = new Intent(Intent.ACTION_VIEW);
                                migrantintent.setData(Uri.parse(jsons.getMigrant()));
                                mContext.startActivity(migrantintent);
                                break;
                            case 15:
                                Intent quaratineintent = new Intent(Intent.ACTION_VIEW);
                                quaratineintent.setData(Uri.parse(jsons.getQuarantined()));
                                mContext.startActivity(quaratineintent);
                                break;
                            case 16:
                                Intent drugstoreintent = new Intent(Intent.ACTION_VIEW);
                                drugstoreintent.setData(Uri.parse(jsons.getDrug_stores()));
                                mContext.startActivity(drugstoreintent);
                                break;
                            case 17:
                                Intent utilityserviceintent = new Intent(Intent.ACTION_VIEW);
                                utilityserviceintent.setData(Uri.parse(jsons.getUtility_service()));
                                mContext.startActivity(utilityserviceintent);
                                break;
                            case 18:
                                Intent essentialserviceintent = new Intent(Intent.ACTION_VIEW);
                                essentialserviceintent.setData(Uri.parse(jsons.getEssential_service()));
                                mContext.startActivity(essentialserviceintent);
                                break;
                            case 19:
                                Intent educationintent = new Intent(mContext, OnlineEducationActivity.class);
                                educationintent.putExtra("cbse",jsons.getCbse());
                                educationintent.putExtra("vc",jsons.getVocational_education());
                                mContext.startActivity(educationintent);
                                break;

                            case 20:
                                Intent intent20 = new Intent(Intent.ACTION_VIEW);
                                intent20.setData(Uri.parse(jsons.getGo()));
                                mContext.startActivity(intent20);
                                break;

                            case 21:
                                Intent tweetintent = new Intent(mContext, TweetsActivity.class);
                                tweetintent.putExtra("url", jsons.getTweets());
                                mContext.startActivity(tweetintent);
                                break;
                            case 22:
                                Intent faqintent = new Intent(mContext, FAQsActivity.class);
                                faqintent.putExtra("url", jsons.getFaq());
                                mContext.startActivity(faqintent);
                                break;

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



    }

    @Override
    public int getItemCount() {
        return Title.length;
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView Title;
        public ImageView Image;
        public ImageViewHolder(View itemView) {
            super(itemView);

            Title = itemView.findViewById(R.id.label);
            Image = itemView.findViewById(R.id.image);
        }
    }
}