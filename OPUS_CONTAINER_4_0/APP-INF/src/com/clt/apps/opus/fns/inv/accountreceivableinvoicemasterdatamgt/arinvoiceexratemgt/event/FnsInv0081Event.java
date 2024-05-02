/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0081Event.java
*@FileTitle : Ex. Rate Entry by Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CheckReturnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CustDailyExRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchExRateVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.InvCustAndDlyXchRtVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;


/**
 * FNS_INV_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0008HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0081Event extends EventSupport {

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

	
	public FnsInv0081Event(){}
	
	public void setSearchExRateVO(SearchExRateVO searchExRateVO){
		this. searchExRateVO = searchExRateVO;
	}

	public void setSearchExRateVOS(SearchExRateVO[] searchExRateVOs){
		if (searchExRateVOs != null) {
			SearchExRateVO[] tmpVOs = new SearchExRateVO[searchExRateVOs.length];
			System.arraycopy(searchExRateVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchExRateVOs = tmpVOs;
		}
	}

	public void setInvCustAndDlyXchRtVO(InvCustAndDlyXchRtVO invCustAndDlyXchRtVO){
		this. invCustAndDlyXchRtVO = invCustAndDlyXchRtVO;
	}

	public void setInvCustAndDlyXchRtVOS(InvCustAndDlyXchRtVO[] invCustAndDlyXchRtVOs){
		if (invCustAndDlyXchRtVOs != null) {
			InvCustAndDlyXchRtVO[] tmpVOs = new InvCustAndDlyXchRtVO[invCustAndDlyXchRtVOs.length];
			System.arraycopy(invCustAndDlyXchRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invCustAndDlyXchRtVOs = tmpVOs;
		}
	}

	public SearchExRateVO getSearchExRateVO(){
		return searchExRateVO;
	}

	public SearchExRateVO[] getSearchExRateVOS(){
		SearchExRateVO[] rtnVOs = null;
		if (this.searchExRateVOs != null) {
			rtnVOs = new SearchExRateVO[searchExRateVOs.length];
			System.arraycopy(searchExRateVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public InvCustAndDlyXchRtVO getInvCustAndDlyXchRtVO(){
		return invCustAndDlyXchRtVO;
	}

	public InvCustAndDlyXchRtVO[] getInvCustAndDlyXchRtVOS(){
		InvCustAndDlyXchRtVO[] rtnVOs = null;
		if (this.invCustAndDlyXchRtVOs != null) {
			rtnVOs = new InvCustAndDlyXchRtVO[invCustAndDlyXchRtVOs.length];
			System.arraycopy(invCustAndDlyXchRtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public CheckReturnVO getCheckReturnVO() {
		return checkReturnVO;
	}

	public void setCheckReturnVO(CheckReturnVO checkReturnVO) {
		this.checkReturnVO = checkReturnVO;
	}

	public CheckReturnVO[] getCheckReturnVOs() {
		CheckReturnVO[] rtnVOs = null;
		if (this.checkReturnVOs != null) {
			rtnVOs = new CheckReturnVO[checkReturnVOs.length];
			System.arraycopy(checkReturnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setCheckReturnVOs(CheckReturnVO[] checkReturnVOs) {
		if (checkReturnVOs != null) {
			CheckReturnVO[] tmpVOs = new CheckReturnVO[checkReturnVOs.length];
			System.arraycopy(checkReturnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.checkReturnVOs = tmpVOs;
		}
	}


	public CustDailyExRateVO getCustDailyExRateVO() {
		return custDailyExRateVO;
	}

	public void setCustDailyExRateVO(CustDailyExRateVO custDailyExRateVO) {
		this.custDailyExRateVO = custDailyExRateVO;
	}

	public CustDailyExRateVO[] getCustDailyExRateVOs() {
		CustDailyExRateVO[] rtnVOs = null;
		if (this.custDailyExRateVOs != null) {
			rtnVOs = new CustDailyExRateVO[custDailyExRateVOs.length];
			System.arraycopy(custDailyExRateVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setCustDailyExRateVOs(CustDailyExRateVO[] custDailyExRateVOs) {
		if (custDailyExRateVOs != null) {
			CustDailyExRateVO[] tmpVOs = new CustDailyExRateVO[custDailyExRateVOs.length];
			System.arraycopy(custDailyExRateVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.custDailyExRateVOs = tmpVOs;
		}
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
		MdmCurrencyVO[] rtnVOs = null;
		if (this.mdmCurrencyVOs != null) {
			rtnVOs = new MdmCurrencyVO[mdmCurrencyVOs.length];
			System.arraycopy(mdmCurrencyVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setMdmCurrencyVOs(MdmCurrencyVO[] mdmCurrencyVOs) {
		if (mdmCurrencyVOs != null) {
			MdmCurrencyVO[] tmpVOs = new MdmCurrencyVO[mdmCurrencyVOs.length];
			System.arraycopy(mdmCurrencyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmCurrencyVOs = tmpVOs;
		}
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
		ExchangeRateVO[] rtnVOs = null;
		if (this.exchangeRateVOs != null) {
			rtnVOs = new ExchangeRateVO[exchangeRateVOs.length];
			System.arraycopy(exchangeRateVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param exchangeRateVOs the exchangeRateVOs to set
	 */
	public void setExchangeRateVOs(ExchangeRateVO[] exchangeRateVOs) {
		if (exchangeRateVOs != null) {
			ExchangeRateVO[] tmpVOs = new ExchangeRateVO[exchangeRateVOs.length];
			System.arraycopy(exchangeRateVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.exchangeRateVOs = tmpVOs;
		}
	}
}