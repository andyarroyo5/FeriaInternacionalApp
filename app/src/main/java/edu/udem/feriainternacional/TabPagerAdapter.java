package edu.udem.feriainternacional;

/**
 * Created by andrea on 12/02/17.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import edu.udem.feriainternacional.CulturaFeed.CulturaFeedFragment;
import edu.udem.feriainternacional.EventoFeed.EventoFeedFragment;
import edu.udem.feriainternacional.HomeFeed.HomeFeedFragment;
import edu.udem.feriainternacional.Perfil.PerfilFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {

            case 0:
                return  new EventoFeedFragment();

            case 1:
                return  new CulturaFeedFragment();

            case 2:
                return  new PerfilFragment();

            // si la posición recibida no se corresponde a ninguna sección
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Evento";
            case 1:
                return "Cultura";
            case 2:
                return "Perfil";
        }
        return null;
    }
}