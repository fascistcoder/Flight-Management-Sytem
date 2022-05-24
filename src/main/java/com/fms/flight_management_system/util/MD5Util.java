package com.fms.flight_management_system.util;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 23/05/22
 */
@Component
public class MD5Util {
	public String generateMD5(String input){
		return DigestUtils.md5DigestAsHex(input.toLowerCase().getBytes());
	}

}
