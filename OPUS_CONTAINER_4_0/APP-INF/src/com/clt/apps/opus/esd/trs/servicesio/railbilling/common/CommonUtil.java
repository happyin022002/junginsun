/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonUtil.java
*@FileTitle : Common Util
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.common;

import com.clt.apps.opus.esd.trs.servicesio.railbilling.RailBillingIWSProxy;

/**
 * WebService Common Util Class<br>
 * - RailBillingIWSProxy의 Common Util Class<br>
 * - RailBilling에서 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @version 1.0
 * @since J2EE 1.4
 */
public class CommonUtil {
	/**
	 * 
	 */
	public CommonUtil() {
		super();
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @return
	 */
	public static String getBkgSplit(String bkgNo) {
		String bkgSplit = "";
		if(bkgNo.length() == 11) bkgSplit = "  ";
		else if(bkgNo.length() == 13) bkgSplit = bkgNo.substring(11);
		return bkgSplit;
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @return
	 */
	public static String getBkg(String bkgNo) {
		String bkg = "";
		if(bkgNo.length() == 11) bkg = bkgNo;
		else if(bkgNo.length() == 13) bkg = bkgNo.substring(0,11);
		return bkg;
	}
}
