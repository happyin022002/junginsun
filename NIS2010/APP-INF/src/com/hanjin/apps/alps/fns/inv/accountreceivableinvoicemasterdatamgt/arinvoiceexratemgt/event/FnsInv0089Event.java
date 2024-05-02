/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0089Event.java
*@FileTitle : Ex Rate Entry by Cusomtomer - Multi Cust
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CustDailyExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.MultiCustomerVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.InvCustAndDlyXchRtVO;


/**
 * FNS_INV_0089 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0089HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0089HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0089Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvCustAndDlyXchRtVO invCustAndDlyXchRtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvCustAndDlyXchRtVO[] invCustAndDlyXchRtVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustDailyExRateVO custDailyExRateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustDailyExRateVO[] custDailyExRateVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MultiCustomerVO multiCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MultiCustomerVO[] multiCustomerVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ExchangeRateVO exchangeRateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ExchangeRateVO[] exchangeRateVOs = null;
	
	/** customer code  */
	private String custCndCd = null;
	
	/** customer Seq  */
	private String custSeq = null;
	
	/** month  */
	private String mon = null;
	
	public FnsInv0089Event(){}
	
	public void setInvCustAndDlyXchRtVO(InvCustAndDlyXchRtVO invCustAndDlyXchRtVO){
		this. invCustAndDlyXchRtVO = invCustAndDlyXchRtVO;
	}

	public void setInvCustAndDlyXchRtVOS(InvCustAndDlyXchRtVO[] invCustAndDlyXchRtVOs){
		this. invCustAndDlyXchRtVOs = invCustAndDlyXchRtVOs;
	}

	public InvCustAndDlyXchRtVO getInvCustAndDlyXchRtVO(){
		return invCustAndDlyXchRtVO;
	}

	public InvCustAndDlyXchRtVO[] getInvCustAndDlyXchRtVOS(){
		return invCustAndDlyXchRtVOs;
	}

	/**
	 * @return the custDailyExRateVO
	 */
	public CustDailyExRateVO getCustDailyExRateVO() {
		return custDailyExRateVO;
	}

	/**
	 * @param custDailyExRateVO the custDailyExRateVO to set
	 */
	public void setCustDailyExRateVO(CustDailyExRateVO custDailyExRateVO) {
		this.custDailyExRateVO = custDailyExRateVO;
	}

	/**
	 * @return the custDailyExRateVOs
	 */
	public CustDailyExRateVO[] getCustDailyExRateVOs() {
		return custDailyExRateVOs;
	}

	/**
	 * @param custDailyExRateVOs the custDailyExRateVOs to set
	 */
	public void setCustDailyExRateVOs(CustDailyExRateVO[] custDailyExRateVOs) {
		this.custDailyExRateVOs = custDailyExRateVOs;
	}
	
	/**
	 * @return the custCndCd
	 */
	public String getCustCndCd() {
		return custCndCd;
	}

	/**
	 * @param custCndCd the custCndCd to set
	 */
	public void setCustCndCd(String custCndCd) {
		this.custCndCd = custCndCd;
	}

	/**
	 * @return the custSeq
	 */
	public String getCustSeq() {
		return custSeq;
	}

	/**
	 * @param custSeq the custSeq to set
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * @return the mon
	 */
	public String getMon() {
		return mon;
	}

	/**
	 * @param mon the mon to set
	 */
	public void setMon(String mon) {
		this.mon = mon;
	}

	/**
	 * @return the multiCustomerVO
	 */
	public MultiCustomerVO getMultiCustomerVO() {
		return multiCustomerVO;
	}

	/**
	 * @param multiCustomerVO the multiCustomerVO to set
	 */
	public void setMultiCustomerVO(MultiCustomerVO multiCustomerVO) {
		this.multiCustomerVO = multiCustomerVO;
	}

	/**
	 * @return the multiCustomerVOs
	 */
	public MultiCustomerVO[] getMultiCustomerVOs() {
		return multiCustomerVOs;
	}

	/**
	 * @param multiCustomerVOs the multiCustomerVOs to set
	 */
	public void setMultiCustomerVOs(MultiCustomerVO[] multiCustomerVOs) {
		this.multiCustomerVOs = multiCustomerVOs;
	}
	
	
	/**
	 * @return the exchangeRateVO
	 */
	public ExchangeRateVO getExchangeRateVO() {
		return exchangeRateVO;
	}

	/**
	 * @param exchangeRateVO the exchangeRateVO to set
	 */
	public void setExchangeRateVO(ExchangeRateVO exchangeRateVO) {
		this.exchangeRateVO = exchangeRateVO;
	}

	/**
	 * @return the exchangeRateVOs
	 */
	public ExchangeRateVO[] getExchangeRateVOs() {
		return exchangeRateVOs;
	}

	/**
	 * @param exchangeRateVOs the exchangeRateVOs to set
	 */
	public void setExchangeRateVOs(ExchangeRateVO[] exchangeRateVOs) {
		this.exchangeRateVOs = exchangeRateVOs;
	}	

}