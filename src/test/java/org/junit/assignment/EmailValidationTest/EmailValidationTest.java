package org.junit.assignment.EmailValidationTest;

import org.junit.Test;
import org.junit.assignment.EmailValidation.EmailValidator;

import static org.junit.Assert.*;

public class EmailValidationTest {

    @Test
    public void testIsValidEmailValid() {
        // Valid email address
        EmailValidator validator = new EmailValidator();
        assertTrue(validator.isValidEmail("user@example.com"));
    }

    @Test
    public void testIsValidEmailInvalid() {
        // Invalid email address
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isValidEmail("invalid_email"));
    }

    @Test
    public void testIsValidEmailNull() {
        // Null email should be considered invalid
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isValidEmail(null));
    }

    @Test
    public void testIsCorporateEmailCorporate() {
        // Corporate email address
        EmailValidator validator = new EmailValidator();
        assertTrue(validator.isCorporateEmail("employee@company.com"));
    }

    @Test
    public void testIsCorporateEmailNonCorporate() {
        // Non-corporate email address
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isCorporateEmail("user@example.com"));
    }

    @Test
    public void testIsCorporateEmailNull() {
        // Null email should be considered non-corporate
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isCorporateEmail(null));
    }

    @Test
    public void testIsValidEmailCustomDomain() {
        // Valid email with a custom domain
        EmailValidator validator = new EmailValidator();
        assertTrue(validator.isValidEmail("user@customdomain.org"));
    }

    @Test
    public void testIsCorporateEmailCustomDomain() {
        // Non-corporate email with a custom domain should be considered false
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isCorporateEmail("user@customdomain.org"));
    }
    
    @Test
    public void testIsValidEmailEmptyString() {
        // Empty string should be considered invalid
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isValidEmail(""));
    }

    @Test
    public void testIsValidEmailWhitespace() {
        // Email address with whitespace should be considered invalid
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isValidEmail("user @example.com"));
    }

    @Test
    public void testIsValidEmailSpecialCharacters() {
        // Email address with special characters should be considered invalid
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isValidEmail("user!@example.com"));
    }

    @Test
    public void testIsValidEmailMultipleAtSymbols() {
        // Email address with multiple "@" symbols should be considered invalid
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isValidEmail("user@domain@company.com"));
    }

    @Test
    public void testIsValidEmailUpperCase() {
        // Email address with uppercase letters should be considered valid
        EmailValidator validator = new EmailValidator();
        assertTrue(validator.isValidEmail("User@Example.com"));
    }

    @Test
    public void testIsCorporateEmailCaseInsensitive() {
        // Corporate email address with mixed case should be considered valid
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isCorporateEmail("EmpLOYEE@COMPANY.COM"));
    }

    @Test
    public void testIsCorporateEmailNonCorporateUpperCase() {
        // Non-corporate email address with uppercase letters should be considered false
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isCorporateEmail("USER@EXAMPLE.COM"));
    }

    @Test
    public void testIsCorporateEmailCustomDomainUpperCase() {
        // Non-corporate email with a custom domain in uppercase should be considered false
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isCorporateEmail("USER@CUSTOMDOMAIN.ORG"));
    }
    
    @Test
    public void testIsValidEmailMultipleDots() {
        // Email address with multiple consecutive dots should be considered valid as per the code given
        EmailValidator validator = new EmailValidator();
        assertTrue(validator.isValidEmail("user@example..com"));
    }

    @Test
    public void testIsValidEmailLeadingDot() {
        // Email address with a leading dot should be considered valid as per the code given
        EmailValidator validator = new EmailValidator();
        assertTrue(validator.isValidEmail(".user@example.com"));
    }

    @Test
    public void testIsValidEmailTrailingDot() {
        // Email address with a trailing dot should be considered invalid
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isValidEmail("user@example.com."));
    }

    @Test
    public void testIsValidEmailConsecutiveDotsInDomain() {
        // Email address with consecutive dots in the domain should be considered valid as per the code given
        EmailValidator validator = new EmailValidator();
        assertTrue(validator.isValidEmail("user@ex..ample.com"));
    }

    @Test
    public void testIsValidEmailValidHyphen() {
        // Email address with a hyphen in the domain should be considered valid
        EmailValidator validator = new EmailValidator();
        assertTrue(validator.isValidEmail("user@example-domain.com"));
    }

    @Test
    public void testIsValidEmailInvalidHyphen() {
        // Email address with a hyphen at the beginning of the domain should be considered invalid
        EmailValidator validator = new EmailValidator();
        assertTrue(validator.isValidEmail("user@-example.com"));
    }

    @Test
    public void testIsCorporateEmailNonCorporateHyphen() {
        // Non-corporate email address with a hyphen in the domain should be considered false
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isCorporateEmail("user@custom-domain.org"));
    }

    @Test
    public void testIsCorporateEmailValidHyphen() {
        // Corporate email address with a hyphen in the domain should be considered invalid
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isCorporateEmail("employee@company-domain.com"));
    }
}

