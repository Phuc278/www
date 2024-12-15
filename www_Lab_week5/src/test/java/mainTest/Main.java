package mainTest;

import com.neovisionaries.i18n.*;

public class Main {
    public static void main(String[] args) {
        // List all the country codes.
        System.out.println(CountryCode.getByCode("UA").getName());

//// List all the language codes.
//        for (LanguageCode code : LanguageCode.values())
//        {
//            System.out.format("[%s] %s\n", code, code.getName());
//        }
//
//// List all the locale codes.
//        for (LocaleCode code : LocaleCode.values())
//        {
//            String language = code.getLanguage().getName();
//            String country  = code.getCountry() != null
//                    ? code.getCountry().getName() : null;
//
//            System.out.format("[%s] %s, %s\n", code, language, country);
//        }
//
//// List all the script codes.
//        for (ScriptCode code : ScriptCode.values())
//        {
//            System.out.format("[%s] %03d %s\n", code, code.getNumeric(), code.getName());
//        }
//
//// List all the currency codes.
//        for (CurrencyCode code : CurrencyCode.values())
//        {
//            System.out.format("[%s] %03d %s\n", code, code.getNumeric(), code.getName());
//        }
//
    }
}
