package dataProviders;

import org.testng.annotations.DataProvider;

public class JSONPlaceholderDataProviders {

    @DataProvider
    public Object[][] userEmails() {
        Object[][] data = new Object[3][2];

        data[0][0] = 8;
        data[0][1] = "Sherwood@rosamond.me";
        data[1][0] = 3;
        data[1][1] = "Nathan@yesenia.net";
        data[2][0] = 5;
        data[2][1] = "Lucio_Hettinger@annie.ca";

        return data;
    }
}
