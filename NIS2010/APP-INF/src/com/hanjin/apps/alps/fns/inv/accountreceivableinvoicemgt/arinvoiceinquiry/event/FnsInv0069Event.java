/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0069Event.java
*@FileTitle : (India)Inquiry for GST Collected in Other Offices
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.08.10 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.GSTChargeListVO;


/**
 * FNS_INV_0069 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0069HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0069HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0069Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 조회 조건 */
	private String dateOption = null;
	
	private String fromDate = null;
	
	private String toDate = null;
	
	private String rhq = null;
	
	/** Table Value Object Multi Data 처리 */
	private GSTChargeListVO[] gSTChargeListVOs = null;

	public FnsInv0069Event(){}
	
	public void setGSTChargeListVOS(GSTChargeListVO[] gSTChargeListVOs){
		this. gSTChargeListVOs = gSTChargeListVOs;
	}

	public GSTChargeListVO[] getGSTChargeListVOS(){
		return gSTChargeListVOs;
	}

	public String getDateOption() {
		return dateOption;
	}

	public void setDateOption(String dateOption) {
		this.dateOption = dateOption;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getRhq() {
		return rhq;
	}

	public void setRhq(String rhq) {
		this.rhq = rhq;
	}

}