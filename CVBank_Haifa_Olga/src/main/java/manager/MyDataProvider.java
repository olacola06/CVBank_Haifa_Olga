package manager;

import models.Cv;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> dataForCv(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Cv.builder().name("Pasha").position("Expert").birthday("12/01/1968").country("Israel")
                .city("haifa").phone("036485478").email("pavel@mail.ru").startYear("1985").endYear("1990")
                .companyName("Neokor").companyLocation("Ramot").companyUrl("www.neokor.com").build()});
        list.add(new Object[]{Cv.builder().name("Ivan").position("Worker").birthday("6/10/1983").country("Cyprus")
                .city("Paphos").phone("426485478").email("ivan@mail.cu").startYear("1999").endYear("2005")
                .companyName("NeoCyp").companyLocation("Larnaca").companyUrl("www.neoCyp.com").build()});
        list.add(new Object[]{Cv.builder().name("John").position("CEO").birthday("28/07/1955").country("UK")
                .city("London").phone("05556485478").email("john@gmail.uk").startYear("1979").endYear("1984")
                .companyName("NeoLon").companyLocation("Manchester").companyUrl("www.neolon.com").build()});
        list.add(new Object[]{Cv.builder().name("Haim").position("Bookkeeper").birthday("3/12/1978").country("Israel")
                .city("Netania").phone("085585478").email("haim@mail.co.il").startYear("2000").endYear("2006")
                .companyName("NeoNet").companyLocation("Ramat Gan").companyUrl("www.neonet.com").build()});
        return list.iterator();
    }
}
