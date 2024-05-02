/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : HMEnumeration.java
*@FileTitle : Enumeration 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2007-04-12
*@LastModifier : common team
*@LastVersion : 1.0
* 2007-04-12 common team
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esd.trs.servicesio.common.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * To change the template for this generated type comment go to<br>
 * Window - Preferences - Java - Code Style - Code Templates<br>
 * 이부분은 단지 Enumeration type 으로 리턴받기 위하여 hashmap을 enumeration 을 구현한 타입으로 변환하여 리턴해주는 classs<br>
 * 
 * @author user
 * @see  참조
 * @since J2EE 1.4
 */
public class HashMapEnumeration extends LinkedHashMap {
	
	/**
	 * Enumeration 생성자
	 * 
	 * @return
	 */
	public Enumeration elements(  )
	{
		return new HMEnumeration(this);
	}

}


