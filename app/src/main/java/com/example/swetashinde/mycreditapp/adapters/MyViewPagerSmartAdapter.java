package com.example.swetashinde.mycreditapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import com.example.swetashinde.mycreditapp.activity.models.Page;
import com.example.swetashinde.mycreditapp.fragments.EmploymentInfoDetails;
import com.example.swetashinde.mycreditapp.fragments.EmploymentInfoType;
import com.example.swetashinde.mycreditapp.fragments.OtherIncomeDetail;
import com.example.swetashinde.mycreditapp.fragments.OtherIncomeQuestion;
import com.example.swetashinde.mycreditapp.fragments.PersonalInfoContact;
import com.example.swetashinde.mycreditapp.fragments.PersonalInfoName;
import com.example.swetashinde.mycreditapp.fragments.ResidenceInfoAddress;
import com.example.swetashinde.mycreditapp.fragments.ResidenceInfoDetails;
import com.example.swetashinde.mycreditapp.fragments.ResidenceInfoType;
import com.example.swetashinde.mycreditapp.fragments.RetirementInfo;
import com.example.swetashinde.mycreditapp.fragments.Review;
import com.example.swetashinde.mycreditapp.fragments.SSN;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by swetashinde on 10/13/17.
 */

public class MyViewPagerSmartAdapter extends SmartFragmentStatePagerAdapter {

    private static final String TAG = MyViewPagerSmartAdapter.class.getCanonicalName();
    private static int NUM_ITEMS = 15;
    List<Page> pages = new ArrayList<>();

    public MyViewPagerSmartAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        initializePages();
    }


    public void initializePages(){


        Page personalInfoNamePage        = new Page(0,1,false,PersonalInfoName.class);
        pages.add(personalInfoNamePage);

        Page personalInfoContactPage     = new Page(1,2,false,PersonalInfoContact.class);
        pages.add(personalInfoContactPage);

        Page residenceInfoTypePage       = new Page(2,3,false,ResidenceInfoType.class);
        pages.add(residenceInfoTypePage);

        Page currentResidenceAddPage     = new Page(3,4,false,ResidenceInfoAddress.class);
        pages.add(currentResidenceAddPage);

        Page currentResidenceDetailsPage = new Page(4,5,false,ResidenceInfoDetails.class);
        pages.add(currentResidenceDetailsPage);

        //skippable
        Page prevResidenceAddPage        = new Page(5,7,true,ResidenceInfoAddress.class,true);    // this page can be skipped
        pages.add(prevResidenceAddPage);

        //skippable
        Page prevResidenceDetailsPage    = new Page(6,7,true,ResidenceInfoDetails.class,true); // this page can be skipped
        pages.add(prevResidenceDetailsPage);

        Page employmentTypePage          = new Page(7,8,false,EmploymentInfoType.class);
        pages.add(employmentTypePage);



        //skippable
        Page employmentDetailsPage       = new Page(8,10,true,EmploymentInfoDetails.class);
        pages.add(employmentDetailsPage);


        Page prevEmploymentDetailPage    =  new Page(9,11,true,EmploymentInfoDetails.class,true);
        pages.add(prevEmploymentDetailPage);


        Page retirementPage              =  new Page(10,11,true, RetirementInfo.class);
        pages.add(retirementPage);



        Page otherIncomeQuestionPage     = new Page(11,12,false,OtherIncomeQuestion.class);
        pages.add(otherIncomeQuestionPage);

        Page otherIncomeDetailPage       = new Page(12,13,true,OtherIncomeDetail.class);
        pages.add(otherIncomeDetailPage);


        Page ssnIdentificationPage       = new Page(13,14,false,SSN.class);
        pages.add(ssnIdentificationPage);


        Page reviewPage                  = new Page(14,-1,false,Review.class);
        pages.add(reviewPage);



    }

    @Override
    public Fragment getItem(int position) {



        Page p = pages.get(position);
        Log.v(TAG,"page number is "+p.getPageNumber());

        Class clazz = p.getFragmentClass();
        Log.v(TAG,"page class  is "+p.getFragmentClass().getCanonicalName());

        try {

            //calling static method using reflection ...
            Fragment f = (Fragment) clazz.newInstance();

            return f;


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


       /*
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return PersonalInfoName.newInstance("first", "Applicant");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return PersonalInfoContact.newInstance("second", "Applicant");
            case 2: // Fragment # 1 - This will show SecondFragment
                return ResidenceInfoType.newInstance("third", "Applicant");
            case 3: // Fragment # 0 - This will show FirstFragment
                return ResidenceInfoAddress.newInstance("first", "Applicant");

            case 4: // Fragment # 0 - This will show FirstFragment
                return ResidenceInfoDetails.newInstance("first", "Applicant");

              case 5: // Fragment # 0 - This will show FirstFragment
                return EmploymentInfoType.newInstance("first", "Applicant");

            case 6: // Fragment # 0 - This will show FirstFragment
                return EmploymentInfoDetails.newInstance("first", "Applicant");


            case 7: // Fragment # 0 - This will show FirstFragment
                return OtherIncomeQuestion.newInstance("first", "Applicant");

            case 8: // Fragment # 0 - This will show FirstFragment
                return OtherIncomeDetail.newInstance("first", "Applicant");

            case 9: // Fragment # 0 - This will show FirstFragment
                return SSN.newInstance("first", "Applicant");

            case 10: // Fragment # 0 - This will show FirstFragment
                return Review.newInstance("first", "Review");



            default:
                return null;
        }*/

       return null;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}
