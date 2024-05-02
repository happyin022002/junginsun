/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0008Event.java
*@FileTitle : Ex. Rate Entry by Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CheckReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CustDailyExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchExRateVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.InvCustAndDlyXchRtVO;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;


/**
 * FNS_INV_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0008HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchExRateVO searchExRateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchExRateVO[] searchExRateVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvCustAndDlyXchRtVO invCustAndDlyXchRtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvCustAndDlyXchRtVO[] invCustAndDlyXchRtVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CheckReturnVO checkReturnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CheckReturnVO[] checkReturnVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustDailyExRateVO custDailyExRateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustDailyExRateVO[] custDailyExRateVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCurrencyVO mdmCurrencyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCurrencyVO[] mdmCurrencyVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ExchangeRateVO exchangeRateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ExchangeRateVO[] exchangeRateVOs = null;
	
	private String pageType = null;	

	
	public FnsInv0008Event(){}
	
	public void setSearchExRateVO(SearchExRateVO searchExRateVO){
		this. searchExRateVO = searchExRateVO;
	}

	public void setSearchExRateVOS(SearchExRateVO[] searchExRateVOs){
		this. searchExRateVOs = searchExRateVOs;
	}

	public void setInvCustAndDlyXchRtVO(InvCustAndDlyXchRtVO invCustAndDlyXchRtVO){
		this. invCustAndDlyXchRtVO = invCustAndDlyXchRtVO;
	}

	public void setInvCustAndDlyXchRtVOS(InvCustAndDlyXchRtVO[] invCustAndDlyXchRtVOs){
		this. invCustAndDlyXchRtVOs = invCustAndDlyXchRtVOs;
	}

	public SearchExRateVO getSearchExRateVO(){
		return searchExRateVO;
	}

	public SearchExRateVO[] getSearchExRateVOS(){
		return searchExRateVOs;
	}

	public InvCustAndDlyXchRtVO getInvCustAndDlyXchRtVO(){
		return invCustAndDlyXchRtVO;
	}

	public InvCustAndDlyXchRtVO[] getInvCustAndDlyXchRtVOS(){
		return invCustAndDlyXchRtVOs;
	}

	public CheckReturnVO getCheckReturnVO() {
		return checkReturnVO;
	}

	public void setCheckReturnVO(CheckReturnVO checkReturnVO) {
		this.checkReturnVO = checkReturnVO;
	}

	public CheckReturnVO[] getCheckReturnVOs() {
		return checkReturnVOs;
	}

	public void setCheckReturnVOs(CheckReturnVO[] checkReturnVOs) {
		this.checkReturnVOs = checkReturnVOs;
	}


	public CustDailyExRateVO getCustDailyExRateVO() {
		return custDailyExRateVO;
	}

	public void setCustDailyExRateVO(CustDailyExRateVO custDailyExRateVO) {
		this.custDailyExRateVO = custDailyExRateVO;
	}

	public CustDailyExRateVO[] getCustDailyExRateVOs() {
		return custDailyExRateVOs;
	}

	public void setCustDailyExRateVOs(CustDailyExRateVO[] custDailyExRateVOs) {
		this.custDailyExRateVOs = custDailyExRateVOs;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public MdmCurrencyVO getMdmCurrencyVO() {
		return mdmCurrencyVO;
	}

	public void setMdmCurrencyVO(MdmCurrencyVO mdmCurrencyVO) {
		this.mdmCurrencyVO = mdmCurrencyVO;
	}

	public MdmCurrencyVO[] getMdmCurrencyVOs() {
		return mdmCurrencyVOs;
	}

	public void setMdmCurrencyVOs(MdmCurrencyVO[] mdmCurrencyVOs) {
		this.mdmCurrencyVOs = mdmCurrencyVOs;
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