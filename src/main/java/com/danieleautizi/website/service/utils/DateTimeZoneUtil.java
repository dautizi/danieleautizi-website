package com.danieleautizi.website.service.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

/**
 * DateTime Zone Util. Get and convert date by specific time zone.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateTimeZoneUtil {

    private static Clock clock = Clock.systemUTC();


    /**
     * Always returns UTC-time, independently of the timezone on the server.
     *
     * @return the date right now
     */
    public static Date utcNow() {

        return Date.from(Instant.now(clock));
    }

    /**
     * Always returns UTC-time, independently of the timezone on the server.
     *
     * @return the date right now
     */
    public static Date utcNowNoSeconds() {

        return Date.from(Instant.now(clock)
                                .truncatedTo(ChronoUnit.MINUTES));
    }

    /**
     * Convert a ZonedDate time to a UTC Date.
     *
     * @param zdt A ZonedDateTime
     * @return the same Date in UTC zone
     */
    public static Date toUtcDate(final ZonedDateTime zdt) {

        if (zdt == null) {
            return null;
        }
        return Date.from(zdt.toLocalDateTime()
                            .toInstant(zdt.getOffset()));
    }

    /**
     * Convert a date to the ISO formatted UTC String
     *
     * @param date - date to convert
     * @return the same Date in UTC zone
     */
    public static String toIsoString(final Date date) {

        if (date == null) {
            return null;
        }
        return ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of(ZoneOffset.UTC.getId()))
                            .format(DateTimeFormatter.ISO_INSTANT);
    }

    /**
     * Always returns UTC-time as LocalDateTime, independently of the timezone on the server.
     *
     * @return LocalDateTime the date right now
     */
    public static LocalDateTime utcLocalDateTimeNow() {

        return utcZonedDateTimeNow().toLocalDateTime();
    }

    /**
     * Return a ZonedDateTime with the UTC as offset
     *
     * @return A ZonedDateTime with UTC as offset
     */
    public static ZonedDateTime utcZonedDateTimeNow() {

        return zonedLocalDateTimeNow(ZoneOffset.UTC);
    }

    /**
     * Return a LocalDateTime with the given ZoneOffset
     *
     * @param offset Zone offset
     * @return A LocalDateTime with an offset
     */
    public static ZonedDateTime zonedLocalDateTimeNow(final ZoneOffset offset) {

        return ZonedDateTime.ofInstant(Instant.now(clock), offset);
    }

    /**
     * Return a LocalDateTime displayed in the right timezone.
     *
     * @param date the date
     * @param accountTimeZone the zone
     * @return a corrent LocalDateTime
     */
    public static LocalDateTime getLocalDateTime(final Date date, final String accountTimeZone) {

        return date == null
                ? null
                : LocalDateTime.ofInstant(date.toInstant(), getUniqueTimezone(accountTimeZone));
    }

    /**
     * Get a ZonedDateTime in the account time zone
     *
     * @param date
     * @param accountTimeZone
     * @return
     */
    public static ZonedDateTime getZonedDateTime(final Date date, final String accountTimeZone) {

        return date == null
                ? null
                : ZonedDateTime.ofInstant(date.toInstant(), getUniqueTimezone(accountTimeZone));
    }

    /**
     * Convert Account Time Zone to Java 8 time zone.
     *
     * @param accountTimeZone time zone of the account.
     * @return ZoneId object.
     */
    public static ZoneId getUniqueTimezone(final String accountTimeZone) {

        if (accountTimeZone == null) {
            return ZoneId.of("UTC");
        }
        /**
         * Java 8 deprecated short time zones ids like EST etc...
         *
         * If some account has such Time Zone it should be checked. In case an account is using a deprecated zone name
         * (EST etc) then the map will replace that zone with a more specific and unique time zone.
         *
         * @see <a href="http://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html#SHORT_IDS">SHORT_IDS</a>
         */
        String timeZone = accountTimeZone;
        if (ZoneId.SHORT_IDS.containsKey(accountTimeZone)) {
            timeZone = ZoneId.SHORT_IDS.get(accountTimeZone);
        }
        return ZoneId.of(timeZone);
    }

    /**
     * Helper method to get 'now' and lock the time in place.
     * <p>
     * <b>Only for use in tests!!! Otherwise boom!</b>
     *
     * @return
     */
    public static LocalDateTime getNowAndFixClock() {

        LOG.error("Call to getNowAndFixClock() from DateTimeZoneUtil that fix the time. This should NEVER be used in application code, and is for testing ONLY!");

        val localDateTime = utcLocalDateTimeNow();
        useFixedClockAt(localDateTime);
        return localDateTime;
    }

    /**
     * Helper method to get 'now' and lock the time in place.
     * <p>
     * <b>Only for use in tests!!! Otherwise boom!</b>
     *
     * @return
     */
    public static ZonedDateTime getUtcZonedNowAndFixClock() {

        LOG.error("Call to getUtcZonedNowAndFixClock() from DateTimeZoneUtil that fix the time. This should NEVER be used in application code, and is for testing ONLY!");

        val utcZonedDateTime = utcZonedDateTimeNow();
        useFixedClockAt(utcZonedDateTime.toLocalDateTime());
        return utcZonedDateTime;
    }

    /**
     * Helper method to lock the time in place to the given timestamp.
     * <p>
     * <b>Only for use in tests!!! Otherwise boom!</b>
     *
     * @return
     */
    public static void fixClockAt(final ZonedDateTime timestamp) {

        useFixedClockAt(timestamp.toLocalDateTime());
    }

    private static void useFixedClockAt(final LocalDateTime localDateTime) {

        clock = Clock.fixed(localDateTime.toInstant(ZoneOffset.UTC), ZoneOffset.UTC);
    }


    /**
     * Validates that String follows ISO Date standard
     *
     * @param date - Date value
     * @return Boolean value if successfully parsed or not
     */
    public static boolean isDateValid(final String date) {

        if (date == null || "".equals(date)) {
            return false;
        }

        try {
            DateTimeFormatter.ISO_DATE.parse(date);
        } catch (DateTimeParseException ex) {
            return false;
        }

        return true;
    }

    public static Date fromZonedDateTimeToDate(final ZonedDateTime zonedDateTime) {

        return Optional.ofNullable(zonedDateTime)
                       .map(zdt -> Date.from(zdt.toLocalDateTime()
                                                .toInstant(zdt.getOffset())))
                       .orElse(null);
    }


    public static String convertDate(final ZonedDateTime date) {

        return Optional.ofNullable(date)
                       .map(DateTimeFormatter.ISO_LOCAL_DATE_TIME::format)
                       .orElse(null);
    }

    public static String convertDate(final Date date, final String zoneId) {

        if (date == null) {
            return null;
        }

        val zonedDateTime = getZonedDateTime(date, zoneId);

        return Optional.ofNullable(zonedDateTime)
                       .map(DateTimeFormatter.ISO_OFFSET_DATE_TIME::format)
                       .orElse(null);
    }
}
