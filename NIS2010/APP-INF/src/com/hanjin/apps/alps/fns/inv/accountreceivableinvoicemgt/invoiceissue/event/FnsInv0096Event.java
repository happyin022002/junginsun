/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0096Event.java
*@FileTitle : N.China Invoice Re-Issue
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
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CHNReissuedInvoiceListVO;


/**
 * FNS_INV_0096 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0096HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0096HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0096Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String blNo = null;
	
	private String ofcCd = null;
	
	private String curCd = null;
	
	private String chnInv = null;
	
	private String pageType = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHNReissuedInvoiceListVO cHNReissuedInvoiceListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHNReissuedInvoiceListVO[] cHNReissuedInvoiceListVOs = null;

	public FnsInv0096Event(){}
	
	public void setCHNReissuedInvoiceListVO(CHNReissuedInvoiceListVO cHNReissuedInvoiceListVO){
		this. cHNReissuedInvoiceListVO = cHNReissuedInvoiceListVO;
	}

	public void setCHNReissuedInvoiceListVOS(CHNReissuedInvoiceListVO[] cHNReissuedInvoiceListVOs){
		this. cHNReissuedInvoiceListVOs = cHNReissuedInvoiceListVOs;
	}

	public CHNReissuedInvoiceListVO getCHNReissuedInvoiceListVO(){
		return cHNReissuedInvoiceListVO;
	}

	public CHNReissuedInvoiceListVO[] getCHNReissuedInvoiceListVOS(){
		return cHNReissuedInvoiceListVOs;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getCurCd() {
		return curCd;
	}

	public void setCurCd(String curCd) {
		this.curCd = curCd;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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