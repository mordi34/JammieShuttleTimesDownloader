package jammieshuttletimesdownloader;

import static jammieshuttletimesdownloader.HomeScreen.getPath;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Mordechai
 */
public class Downloader
{

    private Map<String, String> routes = new HashMap<>();

    public Downloader()
    {
        routes.put("Hiddingh Hall", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/10_hiddingh_weekwkndph.pdf");
        routes.put("Hiddingh Hall Vacation", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/vac/10_hiddingh.pdf");
        routes.put("Claremont", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/1_claremont_weeksatph.pdf");
        routes.put("Claremont Vacation", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/vac/1_claremont.pdf");
        routes.put("Tugwell", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/4_tugwell_weekwkndph.pdf");
        routes.put("Forest Hill", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/5_forest_hill.pdf");
        routes.put("Sandown", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/3_sandown_week.pdf");
        routes.put("Groote Schuur Res.", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/3a_groote_schuur_res.pdf");
        routes.put("Bremner", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/4b_bremner.pdf");
        routes.put("Rochester", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/7a_rochester_weeksat.pdf");
        routes.put("Clarinus", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/6_clarinus.pdf");
        routes.put("Mowbray", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/8_mowbray.pdf");
        routes.put("Liesbeeck", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/9_liesbeek_weeksat.pdf");
        routes.put("Obz Square (via Medical school)", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/9c_obz_sq.pdf");
        routes.put("Medschool", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/9c_medschool.pdf");
        routes.put("Residence loop Weekday", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/9b_residence_loop.pdf");
        routes.put("Residence loop Saturday", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/9b_residence_loop_sat.pdf");
        routes.put("Residence loop Sunday", "https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/9b_residence_loop_sun.pdf");

    }

    public void downloadRoute(String route)
    {
        download(routes.get(route), route);
    }

    public String[] getRoutes()
    {
        String[] returnArr = new String[routes.size()];
        Arrays.sort(routes.keySet().toArray(returnArr));
        return returnArr;
    }

    private void download(String url, String saveName)
    {
        if (url != null)
          {
            try
              {
                URL website = new URL(url);
                ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                FileOutputStream fos = new FileOutputStream(getPath(saveName));
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                fos.close();
              } catch (MalformedURLException | FileNotFoundException e)
              {
                System.out.println("Error retriving data: " + e);
              } catch (IOException ex)
              {
                System.out.println("Error retriving data: " + ex);
              }
          } else
          {
            System.out.println("No such route. Route: " + saveName);
          }

    }
}//class
