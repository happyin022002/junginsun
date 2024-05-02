/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0038Event.java
*@FileTitle : (N.China) Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CHNIssuedInvoiceListVO;


/**
 * FNS_INV_0038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0038HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0038Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String blNo = null;
	
	private String ofcCd = null;
	
	private String curCd = null;
	
	private String chnInv = null;

	private String pageType = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHNIssuedInvoiceListVO cHNIssuedInvoiceListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHNIssuedInvoiceListVO[] cHNIssuedInvoiceListVOs = null;

	public FnsInv0038Event(){}
	
	public void setCHNIssuedInvoiceListVO(CHNIssuedInvoiceListVO cHNIssuedInvoiceListVO){
		this. cHNIssuedInvoiceListVO = cHNIssuedInvoiceListVO;
	}

	public void setCHNIssuedInvoiceListVOS(CHNIssuedInvoiceListVO[] cHNIssuedInvoiceListVOs){
		this. cHNIssuedInvoiceListVOs = cHNIssuedInvoiceListVOs;
	}

	public CHNIssuedInvoiceListVO getCHNIssuedInvoiceListVO(){
		return cHNIssuedInvoiceListVO;
	}

	public CHNIssuedInvoiceListVO[] getCHNIssuedInvoiceListVOS(){
		return cHNIssuedInvoiceListVOs;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getCurCd() {
		return curCd;
	}

	public void setCurCd(String curCd) {
		this.curCd = curCd;
	}

	public String getChnInv() {
		return chnInv;
	}

	public void setChnInv(String chnInv) {
		this.chnInv = chnInv;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	
}