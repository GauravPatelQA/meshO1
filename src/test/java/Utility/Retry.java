package Utility;

import com.aventstack.extentreports.Status;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    int limit =3;
    int counter=0;
    @Override
    public boolean retry(ITestResult result) {
        if(counter<limit){
            counter++;
            Listners.extentTest.log(Status.INFO,result.getMethod().getMethodName());
            return true;
        }

        return false;
    }


}
