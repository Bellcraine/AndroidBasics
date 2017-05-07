package at.technikumwien.birthdaynotifier.ui.main.model.data;

import com.google.auto.value.AutoValue;

import java.util.Date;

import at.technikumwien.birthdaynotifier.ui.main.util.Utils;

/**
 * Created by Bellacraine on 05.05.2017.
 */

@AutoValue
public abstract class Contact {


    public abstract long id();
    public abstract String name();
    public abstract Date birthday();

    public static Contact create(long id, String name, Date birthday) {
        return new AutoValue_Contact (id, name, birthday);
    }

    public String getFormattedBirthday(Date birthday) {
        return Utils.formatBirthday(birthday());
    }
}
