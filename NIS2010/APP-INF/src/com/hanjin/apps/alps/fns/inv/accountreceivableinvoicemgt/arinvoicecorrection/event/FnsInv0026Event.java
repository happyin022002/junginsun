/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0026Event.java
*@FileTitle : Invoice Update by User ID
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.29 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceListByVesselVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvByVVDVO;


/**
 * FNS_INV_0026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0026HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0026Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInvoiceListByVesselVO aRInvoiceListByVesselVO = null;
	
	private String arIfNo = "";
	
	private String updUsrId = "";
	
	private String pageType = null;	
	
	public InvByVVDVO getInvByVVDVo() {
		return invByVVDVo;
	}

	public void setInvByVVDVo(InvByVVDVO invByVVDVo) {
		this.invByVVDVo = invByVVDVo;
	}

	private InvByVVDVO invByVVDVo = null;


	/** Table Value Object Multi Data 처리 */
	private ARInvoiceListByVesselVO[] aRInvoiceListByVesselVOs = null;

	public FnsInv0026Event(){}
	
	public void setARInvoiceListByVesselVO(ARInvoiceListByVesselVO aRInvoiceListByVesselVO){
		this. aRInvoiceListByVesselVO = aRInvoiceListByVesselVO;
	}

	public void setARInvoiceListByVesselVOS(ARInvoiceListByVesselVO[] aRInvoiceListByVesselVOs){
		this. aRInvoiceListByVesselVOs = aRInvoiceListByVesselVOs;
	}

	public ARInvoiceListByVesselVO getARInvoiceListByVesselVO(){
		return aRInvoiceListByVesselVO;
	}

	public ARInvoiceListByVesselVO[] getARInvoiceListByVesselVOS(){
		return aRInvoiceListByVesselVOs;
	}

	public String getArIfNo() {
		return arIfNo;
	}

	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}


}