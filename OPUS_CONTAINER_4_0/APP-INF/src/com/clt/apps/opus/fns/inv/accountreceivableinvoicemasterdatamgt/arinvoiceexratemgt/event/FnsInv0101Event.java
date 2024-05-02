/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0101Event.java
*@FileTitle : VVD Ex.Rate Creation by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.07.07 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDExRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.InvVvdXchRtVO;


/**
 * FNS_INV_0101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0101HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0101Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvVvdXchRtVO invVvdXchRtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvVvdXchRtVO[] invVvdXchRtVOs = null;
	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchVVDExRateVO searchVVDExRateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchVVDExRateVO[] searchVVDExRateVOs = null;
	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ExchangeRateVO exchangeRateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ExchangeRateVO[] exchangeRateVOs = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VVDExrateVO vvdExrateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VVDExrateVO[] vvdExrateVOs = null;
	
	private String svrId = "";
	
	private String ofcCd = "";
	
	private String fromCurrCd	= null;
	
	private String toCurrCd	= null;
	
	private String effDt	= null; 
	
	private String vvd	= null; 
	
	private String port = null;
	
	private String bnd	= null;

	public FnsInv0101Event(){}
	
	public void setInvVvdXchRtVO(InvVvdXchRtVO invVvdXchRtVO){
		this. invVvdXchRtVO = invVvdXchRtVO;
	}

	public void setInvVvdXchRtVOS(InvVvdXchRtVO[] invVvdXchRtVOs){
		if (invVvdXchRtVOs != null) {
			InvVvdXchRtVO[] tmpVOs = new InvVvdXchRtVO[invVvdXchRtVOs.length];
			System.arraycopy(invVvdXchRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invVvdXchRtVOs = tmpVOs;
		}
	}

	public InvVvdXchRtVO getInvVvdXchRtVO(){
		return invVvdXchRtVO;
	}

	public InvVvdXchRtVO[] getInvVvdXchRtVOS(){
		InvVvdXchRtVO[] rtnVOs = null;
		if (this.invVvdXchRtVOs != null) {
			rtnVOs = new InvVvdXchRtVO[invVvdXchRtVOs.length];
			System.arraycopy(invVvdXchRtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @return the searchVVDExRateVO
	 */
	public SearchVVDExRateVO getSearchVVDExRateVO() {
		return searchVVDExRateVO;
	}

	/**
	 * @param searchVVDExRateVO the searchVVDExRateVO to set
	 */
	public void setSearchVVDExRateVO(SearchVVDExRateVO searchVVDExRateVO) {
		this.searchVVDExRateVO = searchVVDExRateVO;
	}

	/**
	 * @return the searchVVDExRateVOs
	 */
	public SearchVVDExRateVO[] getSearchVVDExRateVOs() {
		SearchVVDExRateVO[] rtnVOs = null;
		if (this.searchVVDExRateVOs != null) {
			rtnVOs = new SearchVVDExRateVO[searchVVDExRateVOs.length];
			System.arraycopy(searchVVDExRateVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param searchVVDExRateVOs the searchVVDExRateVOs to set
	 */
	public void setSearchVVDExRateVOs(SearchVVDExRateVO[] searchVVDExRateVOs) {
		if (searchVVDExRateVOs != null) {
			SearchVVDExRateVO[] tmpVOs = new SearchVVDExRateVO[searchVVDExRateVOs.length];
			System.arraycopy(searchVVDExRateVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchVVDExRateVOs = tmpVOs;
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

	
	
	/**
	 * @return the vvdExrateVO
	 */
	public VVDExrateVO getVvdExrateVO() {
		return vvdExrateVO;
	}

	/**
	 * @param vvdExrateVO the vvdExrateVO to set
	 */
	public void setVvdExrateVO(VVDExrateVO vvdExrateVO) {
		this.vvdExrateVO = vvdExrateVO;
	}

	/**
	 * @return the vvdExrateVOs
	 */
	public VVDExrateVO[] getVvdExrateVOs() {
		VVDExrateVO[] rtnVOs = null;
		if (this.vvdExrateVOs != null) {
			rtnVOs = new VVDExrateVO[vvdExrateVOs.length];
			System.arraycopy(vvdExrateVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param vvdExrateVOs the vvdExrateVOs to set
	 */
	public void setVvdExrateVOs(VVDExrateVO[] vvdExrateVOs) {
		if (vvdExrateVOs != null) {
			VVDExrateVO[] tmpVOs = new VVDExrateVO[vvdExrateVOs.length];
			System.arraycopy(vvdExrateVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vvdExrateVOs = tmpVOs;
		}
	}

	/**
	 * @return the svrId
	 */
	public String getSvrId() {
		return svrId;
	}

	/**
	 * @param svrId the svrId to set
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	
	/**
	 * @return the fromCurrCd
	 */
	public String getFromCurrCd() {
		return fromCurrCd;
	}

	/**
	 * @param fromCurrCd the fromCurrCd to set
	 */
	public void setFromCurrCd(String fromCurrCd) {
		this.fromCurrCd = fromCurrCd;
	}

	/**
	 * @return the toCurrCd
	 */
	public String getToCurrCd() {
		return toCurrCd;
	}

	/**
	 * @param toCurrCd the toCurrCd to set
	 */
	public void setToCurrCd(String toCurrCd) {
		this.toCurrCd = toCurrCd;
	}

	/**
	 * @return the effDt
	 */
	public String getEffDt() {
		return effDt;
	}

	/**
	 * @param effDt the effDt to set
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

	/**
	 * @return the vvd
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd the vvd to set
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @return the bnd
	 */
	public String getBnd() {
		return bnd;
	}

	/**
	 * @param bnd the bnd to set
	 */
	public void setBnd(String bnd) {
		this.bnd = bnd;
	}
	

}