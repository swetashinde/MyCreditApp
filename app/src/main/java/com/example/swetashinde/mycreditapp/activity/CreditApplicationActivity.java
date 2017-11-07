package com.example.swetashinde.mycreditapp.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.swetashinde.mycreditapp.R;
import com.example.swetashinde.mycreditapp.adapters.MyViewPagerSmartAdapter;
import com.example.swetashinde.mycreditapp.adapters.SmartFragmentStatePagerAdapter;
import com.example.swetashinde.mycreditapp.fragments.EmploymentInfoDetails;
import com.example.swetashinde.mycreditapp.fragments.EmploymentInfoType;
import com.example.swetashinde.mycreditapp.fragments.OtherIncomeDetail;
import com.example.swetashinde.mycreditapp.fragments.OtherIncomeQuestion;
import com.example.swetashinde.mycreditapp.fragments.PersonalInfoContact;
import com.example.swetashinde.mycreditapp.fragments.PersonalInfoName;
import com.example.swetashinde.mycreditapp.fragments.PrevEmploymentInfoDetails;
import com.example.swetashinde.mycreditapp.fragments.PrevEmploymentInfoType;
import com.example.swetashinde.mycreditapp.fragments.PrevResidenceInfoAddress;
import com.example.swetashinde.mycreditapp.fragments.PrevResidenceInfoDetails;
import com.example.swetashinde.mycreditapp.fragments.PrevResidenceInfoType;
import com.example.swetashinde.mycreditapp.fragments.ResidenceInfoAddress;
import com.example.swetashinde.mycreditapp.fragments.ResidenceInfoDetails;
import com.example.swetashinde.mycreditapp.fragments.ResidenceInfoType;
import com.example.swetashinde.mycreditapp.fragments.RetirementInfo;
import com.example.swetashinde.mycreditapp.fragments.Review;
import com.example.swetashinde.mycreditapp.fragments.SSN;

import static com.example.swetashinde.mycreditapp.R.id.amvMenu;

public class CreditApplicationActivity extends AppCompatActivity implements
        EmploymentInfoDetails.OnFragmentInteractionListener,
        EmploymentInfoType.OnFragmentInteractionListener,
        OtherIncomeDetail.OnFragmentInteractionListener,
        OtherIncomeQuestion.OnFragmentInteractionListener,
        PersonalInfoContact.OnFragmentInteractionListener,
        PersonalInfoName.OnFragmentInteractionListener,
        PrevEmploymentInfoDetails.OnFragmentInteractionListener,
        PrevEmploymentInfoType.OnFragmentInteractionListener,
        PrevResidenceInfoAddress.OnFragmentInteractionListener,
        PrevResidenceInfoDetails.OnFragmentInteractionListener,
        PrevResidenceInfoType.OnFragmentInteractionListener,
        ResidenceInfoDetails.OnFragmentInteractionListener,
        ResidenceInfoAddress.OnFragmentInteractionListener,
        ResidenceInfoType.OnFragmentInteractionListener,
        Review.OnFragmentInteractionListener,
        SSN.OnFragmentInteractionListener, RetirementInfo.OnFragmentInteractionListener

{


    @BindView(R.id.vpPager)
    ViewPager viewPager;
    @BindView(R.id.my_toolbar) Toolbar myToolbar;
    SmartFragmentStatePagerAdapter myViewPagerSmartAdapter;
    @BindView(amvMenu) ActionMenuView actionMenuView;
    //@BindView(R.id.spinner) Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_application);
        ButterKnife.bind(this);

        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(null);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionMenuView.setOnMenuItemClickListener(new ActionMenuView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return onOptionsItemSelected(menuItem);
            }
        });


        myViewPagerSmartAdapter = new MyViewPagerSmartAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myViewPagerSmartAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            float sumPositionAndPositionOffset;
            boolean scrollRight = false;

            @Override public void onPageScrolled(int position, float positionOffset,
                int positionOffsetPixels) {

                if(position+positionOffset > sumPositionAndPositionOffset){
                    //swipe right to left
                    scrollRight = true;
                }else{
                    //swipe left to right
                    scrollRight = false;
                }

                sumPositionAndPositionOffset = position + positionOffset;

            }

            @Override public void onPageSelected(int position) {

                //add the skip logic ...
                if(position == 10 && scrollRight){
                    viewPager.setCurrentItem(14,true);
                }

            }

            @Override public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setOffscreenPageLimit(2);

        //this.spinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Menu actionMenu = actionMenuView.getMenu();
        getMenuInflater().inflate(R.menu.menu, actionMenuView.getMenu());

        MenuItem item = actionMenu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.credit_navigation_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Do your actions here
        return true;
    }

    @Override
    public void onSSNFragmentInteraction(Uri uri) {

    }

    @Override
    public void onReviewFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPersonalInfoNameFragmentInteraction(Uri uri) {

    }

    @Override
    public void onOtherIncomeDetailFragmentInteraction(Uri uri) {

    }

    @Override
    public void onResidenceIndoTypeFragmentInteraction(Uri uri) {

    }

    @Override
    public void onEmploymentInfoTypeFragmentInteraction(Uri uri) {

    }

    @Override
    public void onOtherIncomeQuestionFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPersonalInfoContactFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onResidenceIndoAddressFragmentInteraction(Uri uri) {

    }

    @Override
    public void onResidenceInfoDetailsFragmentInteraction(Uri uri) {

    }

    @Override
    public void onEmploymentInfoDetailsFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPrevResidenceInfoTypeFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPrevResidenceIndoAddressFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPrevResidenceInfoDetailsFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPrevEmploymentInfoDetailsFragmentInteraction(Uri uri) {

    }

    @Override public void onRetirementFragmentInteraction(Uri uri) {

    }


}
