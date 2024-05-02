/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BasicResponse.java
*@FileTitle : Basic Event Response
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.RailBillingIWSProxy;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy의 Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @version 1.0
 * @since J2EE 1.4
 */
public class BasicResponse implements java.io.Serializable {
	/**
	 * 
	 */
	public BasicResponse() {
		super();
	}
	private String	a1Flag	= "FakeFlag1";

	/**
	 * @return Returns the a1Flag.
	 */
	public String getA1Flag() {
		return a1Flag;
	}

	/**
	 * @param flag The a1Flag to set.
	 */
	public void setA1Flag(String flag) {
		a1Flag = flag;
	}

	

}
