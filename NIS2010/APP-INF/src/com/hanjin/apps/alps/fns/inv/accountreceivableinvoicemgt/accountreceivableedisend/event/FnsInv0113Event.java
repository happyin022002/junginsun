/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0113Event.java
*@FileTitle : EDI Glovis Submission
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.25
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.08.09 이석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FNS_INV_0113HTMLAction;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.GlovisInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.GlovisInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;

 
/**
 * FNS_INV_0113 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0113HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이석준
 * @see FNS_INV_0113HTMLAction 참조
 * @since J2EE 1.6
 */ 
 
public class FnsInv0113Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private GlovisInputVO glovisInputVO = null;
	
	/* 다건 처리 (저장,send) */
	private GlovisInvoiceEdiVO[] glovisInvoiceEdiVOs = null;

	private String btnFlag ="";// EDI Send 버튼 선택 유무
	
	/**
	 * @param 
	 * @return String
	 */
	public String getBtnflag() {
		return btnFlag;
	}
	/**
	 * @param String btnFlag 
	 * @return void
	 */
	public void setBtnflag(String btnFlag) {
		this.btnFlag = btnFlag;
	}
	/**
	 * @param 
	 * @return GlovisInputVO
	 */
	public GlovisInputVO getGlovisInputVO() {
		return glovisInputVO;
	}
	/**
	 * @param GlovisInputVO glovisInputVO
	 * @return void
	 */
	public void setGlovisInputVO(GlovisInputVO glovisInputVO) {
		this.glovisInputVO = glovisInputVO;
	}
	/**
	 * @param 
	 * @return GlovisInvoiceEdiVO[]
	 */
	public GlovisInvoiceEdiVO[] getGlovisInvoiceEdiVOs() {
		return glovisInvoiceEdiVOs;
	}
	/**
	 * @param GlovisInvoiceEdiVO[] glovisInvoiceEdiVOs
	 * @return void
	 */
	public void setGlovisInvoiceEdiVOs(GlovisInvoiceEdiVO[] glovisInvoiceEdiVOs) {
		this.glovisInvoiceEdiVOs = glovisInvoiceEdiVOs;
	}

	
}