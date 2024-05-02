/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0013Event.java
*@FileTitle : Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.19 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CreditCustomerVO;


/**
 * FNS_INV_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0013HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	private String frmCustCntCd = null;
	private String frmCustSeq = null;
	private String frmCustRgstNo = null;
	


	public String getFrmCustCntCd() {
		return frmCustCntCd;
	}

	public void setFrmCustCntCd(String frmCustCntCd) {
		this.frmCustCntCd = frmCustCntCd;
	}

	public String getFrmCustSeq() {
		return frmCustSeq;
	}

	public void setFrmCustSeq(String frmCustSeq) {
		this.frmCustSeq = frmCustSeq;
	}

	public String getFrmCustRgstNo() {
		return frmCustRgstNo;
	}

	public void setFrmCustRgstNo(String frmCustRgstNo) {
		this.frmCustRgstNo = frmCustRgstNo;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CreditCustomerVO mdmCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CreditCustomerVO[] mdmCustomerVOs = null;

	public FnsInv0013Event(){}
	
	public void setMdmCustomerVO(CreditCustomerVO mdmCustomerVO){
		this. mdmCustomerVO = mdmCustomerVO;
	}

	public void setMdmCustomerVOS(CreditCustomerVO[] mdmCustomerVOs){
		this. mdmCustomerVOs = mdmCustomerVOs;
	}

	public CreditCustomerVO getMdmCustomerVO(){
		return mdmCustomerVO;
	}

	public CreditCustomerVO[] getMdmCustomerVOS(){
		return mdmCustomerVOs;
	}

}