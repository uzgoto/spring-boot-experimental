package org.uzgoto.experimental.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeUtils {

  public static ZonedDateTime jstNow() {
    return ZonedDateTime.now(ZoneId.of("UTC+09:00"));
  }
  public static ZonedDateTime utcNow() {
    return ZonedDateTime.now(ZoneId.of("UTC"));
  }
}
