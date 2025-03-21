package seedu.address.testutil;

import java.util.Arrays;
import java.util.Optional;

import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Preference;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";

    private Name name;
    private Phone phone;
    private Optional<Tag> tag;
    private Preference preference;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        tag = Optional.empty();
        preference = new Preference();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        tag = personToCopy.getTag();
        preference = personToCopy.getPreference();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tag} into a {@code Optional<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTag(String tag) {
        if (tag.isBlank()) {
            this.tag = Optional.empty();
        } else if (Tag.isValidTagName(tag)) {
            this.tag = Optional.of(new Tag(tag));
        }
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Preference} of the {@code Person} that we are building.
     */
    public PersonBuilder withPreference(String... preference) {
        this.preference = new Preference(Arrays.asList(preference));
        return this;
    }

    public Person build() {
        return new Person(name, phone, tag, preference);
    }

}
