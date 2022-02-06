package com.jumiaproject.phonevalidator.testclasses;

import com.jumiaproject.phonevalidator.enums.ValidationStateEnum;
import com.jumiaproject.phonevalidator.validator.PhoneValidatorFactory;
import com.jumiaproject.phonevalidator.validator.validators.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.Assert;

@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CountryCodeValidatorStrategyTest {

    private final String VALID_MOZAMBIQUE_PHONE_NUMBER = "(258) 846565883";
    private final String VALID_ETHIOPIA_PHONE_NUMBER = "(251) 914701723";
    private final String VALID_CAMEROON_PHONE_NUMBER = "(237) 697151594";
    private final String VALID_MOROCCO_PHONE_NUMBER = "(212) 691933626";
    private final String VALID_UGANDA_PHONE_NUMBER = "(256) 714660221";

    @Autowired
    PhoneValidatorFactory validatorFactory;

    @Test
    public void shouldReturnAllCorrectValidators() {

        Assert.assertEquals(validatorFactory.create(VALID_MOZAMBIQUE_PHONE_NUMBER).getClass(), MozambiquePhoneValidatorStrategy.class);
        Assert.assertEquals(validatorFactory.create(VALID_UGANDA_PHONE_NUMBER).getClass(), UgandaPhoneValidatorStrategy.class);
        Assert.assertEquals(validatorFactory.create(VALID_MOROCCO_PHONE_NUMBER).getClass(), MoroccoPhoneValidatorStrategy.class);
        Assert.assertEquals(validatorFactory.create(VALID_CAMEROON_PHONE_NUMBER).getClass(), CameroonPhoneValidatorStrategy.class);
        Assert.assertEquals(validatorFactory.create(VALID_ETHIOPIA_PHONE_NUMBER).getClass(), EthiopiaPhoneValidatorStrategy.class);

    }

    @Test
    public void shouldValidateAllPhoneNumbers () {

        Assert.assertEquals(validatorFactory.create(VALID_MOZAMBIQUE_PHONE_NUMBER).validate(VALID_MOZAMBIQUE_PHONE_NUMBER),
                ValidationStateEnum.VALID);
        Assert.assertEquals(validatorFactory.create(VALID_UGANDA_PHONE_NUMBER).validate(VALID_UGANDA_PHONE_NUMBER),
                ValidationStateEnum.VALID);
        Assert.assertEquals(validatorFactory.create(VALID_MOROCCO_PHONE_NUMBER).validate(VALID_MOROCCO_PHONE_NUMBER),
                ValidationStateEnum.VALID);
        Assert.assertEquals(validatorFactory.create(VALID_ETHIOPIA_PHONE_NUMBER).validate(VALID_ETHIOPIA_PHONE_NUMBER),
                ValidationStateEnum.VALID);
        Assert.assertEquals(validatorFactory.create(VALID_CAMEROON_PHONE_NUMBER).validate(VALID_CAMEROON_PHONE_NUMBER),
                ValidationStateEnum.VALID);
    }

}
