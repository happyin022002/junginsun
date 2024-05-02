/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SamsungInvoiceEDIVO.java
 *@FileTitle : SamsungInvoiceEDIVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 박정진
 *@LastVersion : 1.0
 * 2009.10.05 박정진 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SamsungInvoiceEDIVO {

	private static final long serialVersionUID = 1L;

	private List<SamsungMSGVO> samsungMSGList = null;

	private SamsungInvoiceEDIHeaderVO samsungInvoiceEDIHeader = null;

	private List<SamsungEDIBLChargeVO> SamsungEDIBLChargeList = null;

	public List<SamsungMSGVO> getSamsungMSGList() {
		return samsungMSGList;
	}
	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public void setSamsungMSGList(List<SamsungMSGVO> samsungMSGList) {
		this.samsungMSGList = samsungMSGList;
	}

	public SamsungInvoiceEDIHeaderVO getSamsungInvoiceEDIHeader() {
		return samsungInvoiceEDIHeader;
	}

	public void setSamsungInvoiceEDIHeader(SamsungInvoiceEDIHeaderVO samsungInvoiceEDIHeader) {
		this.samsungInvoiceEDIHeader = samsungInvoiceEDIHeader;
	}

	public List<SamsungEDIBLChargeVO> getSamsungEDIBLChargeList() {
		return SamsungEDIBLChargeList;
	}

	public void setSamsungEDIBLChargeList(List<SamsungEDIBLChargeVO> samsungEDIBLChargeList) {
		SamsungEDIBLChargeList = samsungEDIBLChargeList;
	}
}
