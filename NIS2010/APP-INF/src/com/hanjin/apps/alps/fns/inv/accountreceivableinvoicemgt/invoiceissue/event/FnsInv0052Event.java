/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0052Event.java
*@FileTitle : (Korea) Terminal GIRO Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.09.23 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORGiroListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORInvoiceVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0052HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private KORInvoiceVO kORInvoiceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private KORInvoiceVO[] kORInvoiceVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private KORGiroListVO korGiroListVO = null;
	
	private String blNo = null;
	
	private String issDt = null;
	
	private String ofcCd = null;
	
	private String pageType = null;

	public FnsInv0052Event(){}
	
	public void setKORInvoiceVO(KORInvoiceVO kORInvoiceVO){
		this. kORInvoiceVO = kORInvoiceVO;
	}

	public void setKORInvoiceVOS(KORInvoiceVO[] kORInvoiceVOs){
		this. kORInvoiceVOs = kORInvoiceVOs;
	}

	public KORInvoiceVO getKORInvoiceVO(){
		return kORInvoiceVO;
	}

	public KORInvoiceVO[] getKORInvoiceVOS(){
		return kORInvoiceVOs;
	}

	public KORGiroListVO getKorGiroListVO() {
		return korGiroListVO;
	}

	public void setKorGiroListVO(KORGiroListVO korGiroListVO) {
		this.korGiroListVO = korGiroListVO;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getIssDt() {
		return issDt;
	}

	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

}