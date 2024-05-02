/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg9425Event.java
*@FileTitle : Empty REPO BKG Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.30 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.cancellationmessage.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * 
 * @author c9014850
 * @see EsmBkg0620Event 참조
 * @since J2EE 1.6
 */
public class EsmBkg0620Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String bkgNo;
	private String type;
	
	public String getBkgNo() {
		return bkgNo;
	}
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}