/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar1006Event.java
*@FileTitle : Outstanding Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event;

import java.util.List;

import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterByEmailFaxVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableOutstandingSC로 실행요청<br>
 * - AccountReceivableOutstandingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar1006Event 참조
 * @since J2EE 1.4
 */

public class StmSar1006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String kind2  = "";  //오른쪽 마우스 source-Generate Getters and Setters
	
	private String rdName = null;
	
	public String getKind2() {
		return kind2;
	}
	public void setKind2(String kind2) {
		this.kind2 = kind2;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PaymentRequestLetterVO paymentRequestLetterVO = null;
	
	public String getRdName() {
		return rdName;
	}
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}
	public PaymentRequestLetterByEmailFaxVO getPaymentRequestLetterByEmailFaxVO() {
		return paymentRequestLetterByEmailFaxVO;
	}
	public void setPaymentRequestLetterByEmailFaxVO(
			PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO) {
		this.paymentRequestLetterByEmailFaxVO = paymentRequestLetterByEmailFaxVO;
	}
	public List<String> getKeys() {
		return keys;
	}
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	private PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO = null;
	
	private List<String> keys = null;
	
	public StmSar1006Event(){}
		
	public PaymentRequestLetterVO getPaymentRequestLetterVO() {
		return paymentRequestLetterVO;
	}
	
	public void setPaymentRequestLetterVO(PaymentRequestLetterVO paymentRequestLetterVO) {
		this.paymentRequestLetterVO = paymentRequestLetterVO;		
	}
	
	
}