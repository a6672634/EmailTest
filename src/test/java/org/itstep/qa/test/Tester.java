package org.itstep.qa.test;

import org.testng.annotations.DataProvider;

public class Tester {

    @DataProvider(name="user[email]")

    public Object[][] dataProvider(){
        return new Object[][]{
                {"ads@hh.dm"},
                {" adasd@sss"},
                {" @sss.off"},
                {"(*^)_mail.ru"},
                {"fsfgsgsgs@.com"},
                {" fsfgsgsgs@.com"},
                {" fsfgsgsgs@. com"},
                {" fsfgsgsgs @ . com"},
                {""},
                {" "},
                {"sqlinj/index1.php?id=1'"},
                {"%3C%68%31%3E%54%68%69%73%20%69%73%20%61%20%74%65%73%74%"},
                {"<h1>This is a test</h1><p class=”some class”>some conte 2 nt</p>’"},

        };
    }
}
