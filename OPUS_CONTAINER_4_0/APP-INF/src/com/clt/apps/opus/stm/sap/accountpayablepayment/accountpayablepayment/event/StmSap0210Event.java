/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0210Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event;


import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchSelectedListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountPayablePaymentSC로 실행요청<br>
 * - AccountPayablePaymentSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author ORKIM
 * @see StmSap0210Event 참조
 * @since J2EE 1.6
 */
public class StmSap0210Event extends EventSupport {
	
	private SapCommonVO sapCommonVO = null;
	private SapCommonVO[] sapCommonVOs = null;
	
	private PaymentBatchCondVO paymentBatchCondVO = null;
	private PaymentBatchCondVO[] paymentBatchCondVOs = null;
	
	private PaymentBatchListVO paymentBatchListVO = null;
	private PaymentBatchListVO[] paymentBatchListVOs = null;
	
	private PaymentBatchSelectedListVO paymentBatchSelectedListVO = null;
	private PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs = null;
	
	String payBatSeq = null;
	String payBatNm = null;
	String invNo = null;
	String functionalCurrency = null;
	
	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	private static final long serialVersionUID = 1L;

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

	public PaymentBatchCondVO getPaymentBatchCondVO() {
		return paymentBatchCondVO;
	}

	public void setPaymentBatchCondVO(PaymentBatchCondVO paymentBatchCondVO) {
		this.paymentBatchCondVO = paymentBatchCondVO;
	}

	public PaymentBatchCondVO[] getPaymentBatchCondVOs() {
		PaymentBatchCondVO[] rtnVOs = null;
		if(this.paymentBatchCondVOs != null) {
			rtnVOs = new PaymentBatchCondVO[paymentBatchCondVOs.length];
			System.arraycopy(paymentBatchCondVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}

	public void setPaymentBatchCondVOs(PaymentBatchCondVO[] paymentBatchCondVOs) {
		if(paymentBatchCondVOs != null) {
			PaymentBatchCondVO[] tmpVOs = new PaymentBatchCondVO[paymentBatchCondVOs.length];
			System.arraycopy(paymentBatchCondVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.paymentBatchCondVOs = tmpVOs;
		}

	}

	public PaymentBatchListVO getPaymentBatchListVO() {
		return paymentBatchListVO;
	}

	public void setPaymentBatchListVO(PaymentBatchListVO paymentBatchListVO) {
		this.paymentBatchListVO = paymentBatchListVO;
	}

	public PaymentBatchListVO[] getPaymentBatchListVOs() {
		PaymentBatchListVO[] rtnVOs = null;
		if(this.paymentBatchListVOs != null) {
			rtnVOs = new PaymentBatchListVO[paymentBatchListVOs.length];
			System.arraycopy(paymentBatchListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPaymentBatchListVOs(PaymentBatchListVO[] paymentBatchListVOs) {
		if(paymentBatchListVOs != null) {
			PaymentBatchListVO[] tmpVOs = new PaymentBatchListVO[paymentBatchListVOs.length];
			System.arraycopy(paymentBatchListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.paymentBatchListVOs = tmpVOs;
		}
	}

	public PaymentBatchSelectedListVO getPaymentBatchSelectedListVO() {
		return paymentBatchSelectedListVO;
	}

	public void setPaymentBatchSelectedListVO(PaymentBatchSelectedListVO paymentBatchSelectedListVO) {
		this.paymentBatchSelectedListVO = paymentBatchSelectedListVO;
	}

	public PaymentBatchSelectedListVO[] getPaymentBatchSelectedListVOs() {
		PaymentBatchSelectedListVO[] rtnVOs = null;
		if(this.paymentBatchSelectedListVOs != null) {
			rtnVOs = new PaymentBatchSelectedListVO[paymentBatchSelectedListVOs.length];
			System.arraycopy(paymentBatchSelectedListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}

	public void setPaymentBatchSelectedListVOs(PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs) {
		if(paymentBatchSelectedListVOs != null) {
			PaymentBatchSelectedListVO[] tmpVOs = new PaymentBatchSelectedListVO[paymentBatchSelectedListVOs.length];
			System.arraycopy(paymentBatchSelectedListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.paymentBatchSelectedListVOs = tmpVOs;
		}
	}

	public String getPayBatSeq() {
		return payBatSeq;
	}

	public void setPayBatSeq(String payBatSeq) {
		this.payBatSeq = payBatSeq;
	}

	public String getPayBatNm() {
		return payBatNm;
	}

	public void setPayBatNm(String payBatNm) {
		this.payBatNm = payBatNm;
	}

	public String getFunctionalCurrency() {
		return functionalCurrency;
	}

	public void setFunctionalCurrency(String functionalCurrency) {
		this.functionalCurrency = functionalCurrency;
	}

}