package com.litongjava.tio.web.hello.stat;

import com.litongjava.tio.utils.time.Time;

public interface IpStatDuration {
  public static final Long DURATION_1 = Time.MINUTE_1 * 5;
  public static final Long[] IPSTAT_DURATIONS = new Long[] { DURATION_1 };
}