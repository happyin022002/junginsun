/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0241Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event;


import com.clt.framework.support.layer.event.EventSupport;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementInvoiceListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementApplyListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementUnapplyListVO;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CLT
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0241Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String invSeq = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SapCommonVO sapCommonVO = null;
	/** Table Value Object Multi Data 처리 */
	private SapCommonVO[] sapCommonVOs = null;	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO = null;
	/** Table Value Object Multi Data 처리 */
	private PrepaymentSettlementInvoiceListVO[] prepaymentSettlementInvoiceListVOs = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PrepaymentSettlementApplyListVO prepaymentSettlementApplyListVO = null;
	/** Table Value Object Multi Data 처리 */
	private PrepaymentSettlementApplyListVO[] prepaymentSettlementApplyListVOs = null;	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PrepaymentSettlementUnapplyListVO prepaymentSettlementUnapplyListVO = null;
	/** Table Value Object Multi Data 처리 */
	private PrepaymentSettlementUnapplyListVO[] prepaymentSettlementUnapplyListVOs = null;
	

	public StmSap0241Event() {}


	public String getInvSeq() {
		return invSeq;
	}


	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}


	public SapCommonVO getSapCommonVO() {
		return sapCommonVO;
	}


	public void setSapCommonVO(SapCommonVO sapCommonVO) {
		this.sapCommonVO = sapCommonVO;
	}


	public SapCommonVO[] getSapCommonVOs() {
		SapCommonVO[] rtnVOs = null;
		if(this.sapCommonVOs != null) {
			rtnVOs = new SapCommonVO[sapCommonVOs.length];
			System.arraycopy(sapCommonVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSapCommonVOs(SapCommonVO[] sapCommonVOs) {
		if(sapCommonVOs != null) {
			SapCommonVO[] tmpVOs = new SapCommonVO[sapCommonVOs.length];
			System.arraycopy(sapCommonVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.sapCommonVOs = tmpVOs;
		}
	}


	public PrepaymentSettlementInvoiceListVO getPrepaymentSettlementInvoiceListVO() {
		return prepaymentSettlementInvoiceListVO;
	}


	public void setPrepaymentSettlementInvoiceListVO(
			PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO) {
		this.prepaymentSettlementInvoiceListVO = prepaymentSettlementInvoiceListVO;
	}


	public PrepaymentSettlementInvoiceListVO[] getPrepaymentSettlementInvoiceListVOs() {
		PrepaymentSettlementInvoiceListVO[] rtnVOs = null;
		if (this.prepaymentSettlementInvoiceListVOs != null) {
			rtnVOs = new PrepaymentSettlementInvoiceListVO[prepaymentSettlementInvoiceListVOs.length];
			System.arraycopy(prepaymentSettlementInvoiceListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setPrepaymentSettlementInvoiceListVOs(PrepaymentSettlementInvoiceListVO[] prepaymentSettlementInvoiceListVOs){
		if(prepaymentSettlementInvoiceListVOs != null){
			PrepaymentSettlementInvoiceListVO[] tmpVOs = new PrepaymentSettlementInvoiceListVO[prepaymentSettlementInvoiceListVOs.length];
			System.arraycopy(prepaymentSettlementInvoiceListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.prepaymentSettlementInvoiceListVOs = tmpVOs;
		}
	}


	public PrepaymentSettlementApplyListVO getPrepaymentSettlementApplyListVO() {
		return prepaymentSettlementApplyListVO;
	}


	public void setPrepaymentSettlementApplyListVO(
			PrepaymentSettlementApplyListVO prepaymentSettlementApplyListVO) {
		this.prepaymentSettlementApplyListVO = prepaymentSettlementApplyListVO;
	}


	public PrepaymentSettlementApplyListVO[] getPrepaymentSettlementApplyListVOs() {
		PrepaymentSettlementApplyListVO[] rtnVOs = null;
		if(this.prepaymentSettlementApplyListVOs != null) {
			rtnVOs = new PrepaymentSettlementApplyListVO[prepaymentSettlementApplyListVOs.length];
			System.arraycopy(prepaymentSettlementApplyListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setPrepaymentSettlementApplyListVOs(PrepaymentSettlementApplyListVO[] prepaymentSettlementApplyListVOs) {
		if(prepaymentSettlementApplyListVOs != null) {
			PrepaymentSettlementApplyListVO[] tmpVOs = new PrepaymentSettlementApplyListVO[prepaymentSettlementApplyListVOs.length];
			System.arraycopy(prepaymentSettlementApplyListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.prepaymentSettlementApplyListVOs = tmpVOs;
		}
	}


	public PrepaymentSettlementUnapplyListVO getPrepaymentSettlementUnapplyListVO() {
		return prepaymentSettlementUnapplyListVO;
	}


	public void setPrepaymentSettlementUnapplyListVO(
			PrepaymentSettlementUnapplyListVO prepaymentSettlementUnapplyListVO) {
		this.prepaymentSettlementUnapplyListVO = prepaymentSettlementUnapplyListVO;
	}


	public PrepaymentSettlementUnapplyListVO[] getPrepaymentSettlementUnapplyListVOs() {
		PrepaymentSettlementUnapplyListVO[] rtnVOs = null;
		if(this.prepaymentSettlementUnapplyListVOs != null) {
			rtnVOs = new PrepaymentSettlementUnapplyListVO[prepaymentSettlementUnapplyListVOs.length];
			System.arraycopy(prepaymentSettlementUnapplyListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setPrepaymentSettlementUnapplyListVOs( PrepaymentSettlementUnapplyListVO[] prepaymentSettlementUnapplyListVOs) {
		if(prepaymentSettlementUnapplyListVOs != null) {
			PrepaymentSettlementUnapplyListVO[] tmpVOs = new PrepaymentSettlementUnapplyListVO[prepaymentSettlementUnapplyListVOs.length];
			System.arraycopy(prepaymentSettlementUnapplyListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.prepaymentSettlementUnapplyListVOs = tmpVOs;
		}
	}

}