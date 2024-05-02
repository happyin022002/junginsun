/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInviiceListByVesselVO.java
*@FileTitle : ARInviiceListByVesselVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.01 한동훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 한동훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInvoiceListByVesselMultiVO{

	//다중조회 처리를 위한          
	
	private ARInvoiceListByVesselVO aRInvoiceListByVesselVO = null;	
	
	private List<ARInvoiceListByVesselVO> listARInvoiceListByVesselVO = null;	
	
	private String invXchRt = null;
	
	private String saDate = null;

	public ARInvoiceListByVesselVO getARInvoiceListByVesselVO() {
		return aRInvoiceListByVesselVO;
	}

	public void setARInvoiceListByVesselVO(
			ARInvoiceListByVesselVO invoiceListByVesselVO) {
		aRInvoiceListByVesselVO = invoiceListByVesselVO;
	}

	public List<ARInvoiceListByVesselVO> getListARInvoiceListByVesselVO() {
		return listARInvoiceListByVesselVO;
	}

	public void setListARInvoiceListByVesselVO(
			List<ARInvoiceListByVesselVO> listARInvoiceListByVesselVO) {
		this.listARInvoiceListByVesselVO = listARInvoiceListByVesselVO;
	}
	
	
	public String getInvXchRt() {
		return invXchRt;
	}

	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}

	public String getSaDate() {
		return saDate;
	}

	public void setSaDate(String saDate) {
		this.saDate = saDate;
	}


}
