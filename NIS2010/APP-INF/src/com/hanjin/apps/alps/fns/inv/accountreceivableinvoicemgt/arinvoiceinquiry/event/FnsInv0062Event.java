/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0062Event.java
*@FileTitle : (Spain) Invoice Download for EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2011.10.26 권   민 [CHM-201114097] (Spain) Invoice Download for EDI
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.SpainInvoiceEDIListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0062 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0062HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0062HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0062Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String fmInvNo = null;
	/* Column Info */
	private String toInvNo = null;
	/* Column Info */
	private String pageType = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpainInvoiceEDIListVO spainInvoiceEDIListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpainInvoiceEDIListVO[] spainInvoiceEDIListVOs = null;

	public FnsInv0062Event(){}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getIssDt() {
		return issDt;
	}

	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}

	public String getFmInvNo() {
		return fmInvNo;
	}

	public void setFmInvNo(String fmInvNo) {
		this.fmInvNo = fmInvNo;
	}

	public String getToInvNo() {
		return toInvNo;
	}

	public void setToInvNo(String toInvNo) {
		this.toInvNo = toInvNo;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public void setSpainInvoiceListVO(SpainInvoiceEDIListVO spainInvoiceEDIListVO){
		this.spainInvoiceEDIListVO = spainInvoiceEDIListVO;
	}

	public void setSpainInvoiceListVOS(SpainInvoiceEDIListVO[] spainInvoiceEDIListVOs){
		this.spainInvoiceEDIListVOs = spainInvoiceEDIListVOs;
	}

	public SpainInvoiceEDIListVO getSpainInvoiceEDIListVO(){
		return spainInvoiceEDIListVO;
	}

	public SpainInvoiceEDIListVO[] getSpainInvoiceEDIListVOS(){
		return spainInvoiceEDIListVOs;
	}

}