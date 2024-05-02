/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0100Event.java
*@FileTitle : VVD Ex.Rate Creation by S/A Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.07.07 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDPortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDandPortListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.InvVvdXchRtVO;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;
import java.util.List;

/**
 * FNS_INV_0100 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0100HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0100HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0100Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvVvdXchRtVO invVvdXchRtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvVvdXchRtVO[] invVvdXchRtVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchVVDPortVO searchVVDPortVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchVVDPortVO[] searchVVDPortVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VVDandPortListVO vvdAndPortListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<VVDandPortListVO> vvdAndPortListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VVDExrateVO vvdExrateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private  List<VVDExrateVO>  vvdExrateVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ExchangeRateVO exchangeRateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ExchangeRateVO[] exchangeRateVOs = null;
	
	
	private String svrId = "";
	
	private String ofcCd = "";
	
	private String triYn = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCurrencyVO mdmCurrencyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCurrencyVO[] mdmCurrencyVOs = null;
	
	private String pageType = null;	


	public FnsInv0100Event(){}
	
	public void setInvVvdXchRtVO(InvVvdXchRtVO invVvdXchRtVO){
		this. invVvdXchRtVO = invVvdXchRtVO;
	}

	public void setInvVvdXchRtVOS(InvVvdXchRtVO[] invVvdXchRtVOs){
		this. invVvdXchRtVOs = invVvdXchRtVOs;
	}

	public InvVvdXchRtVO getInvVvdXchRtVO(){
		return invVvdXchRtVO;
	}

	public InvVvdXchRtVO[] getInvVvdXchRtVOS(){
		return invVvdXchRtVOs;
	}
	
	

	/**
	 * @return the searchVVDPortVO
	 */
	public SearchVVDPortVO getSearchVVDPortVO() {
		return searchVVDPortVO;
	}

	/**
	 * @param searchVVDPortVO the searchVVDPortVO to set
	 */
	public void setSearchVVDPortVO(SearchVVDPortVO searchVVDPortVO) {
		this.searchVVDPortVO = searchVVDPortVO;
	}

	/**
	 * @return the searchVVDPortVOs
	 */
	public SearchVVDPortVO[] getSearchVVDPortVOs() {
		return searchVVDPortVOs;
	}

	/**
	 * @param searchVVDPortVOs the searchVVDPortVOs to set
	 */
	public void setSearchVVDPortVOs(SearchVVDPortVO[] searchVVDPortVOs) {
		this.searchVVDPortVOs = searchVVDPortVOs;
	}

	
	
	
	/**
	 * @return the vvdAndPortListVOs
	 */
	public List<VVDandPortListVO> getVvdAndPortListVOs() {
		return vvdAndPortListVOs;
	}

	/**
	 * @param vvdAndPortListVOs the vvdAndPortListVOs to set
	 */
	public void setVvdAndPortListVOs(List<VVDandPortListVO> vvdAndPortListVOs) {
		this.vvdAndPortListVOs = vvdAndPortListVOs;
	}

	/**
	 * @return the vvdExrateVOs
	 */
	public List<VVDExrateVO> getVvdExrateVOs() {
		return vvdExrateVOs;
	}

	/**
	 * @param vvdExrateVOs the vvdExrateVOs to set
	 */
	public void setVvdExrateVOs(List<VVDExrateVO> vvdExrateVOs) {
		this.vvdExrateVOs = vvdExrateVOs;
	}

	/**
	 * @return the vvdAndPortListVO
	 */
	public VVDandPortListVO getVvdAndPortListVO() {
		return vvdAndPortListVO;
	}

	/**
	 * @param vvdAndPortListVO the vvdAndPortListVO to set
	 */
	public void setVvdAndPortListVO(VVDandPortListVO vvdAndPortListVO) {
		this.vvdAndPortListVO = vvdAndPortListVO;
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
	
	/**
	 * @return the triYn
	 */
	public String getTriYn() {
		return triYn;
	}

	/**
	 * @param triYn the triYn to set
	 */
	public void setTriYn(String triYn) {
		this.triYn = triYn;
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
	 * @return the mdmCurrencyVO
	 */
	public MdmCurrencyVO getMdmCurrencyVO() {
		return mdmCurrencyVO;
	}

	/**
	 * @param mdmCurrencyVO the mdmCurrencyVO to set
	 */
	public void setMdmCurrencyVO(MdmCurrencyVO mdmCurrencyVO) {
		this.mdmCurrencyVO = mdmCurrencyVO;
	}

	/**
	 * @return the mdmCurrencyVOs
	 */
	public MdmCurrencyVO[] getMdmCurrencyVOs() {
		return mdmCurrencyVOs;
	}

	/**
	 * @param mdmCurrencyVOs the mdmCurrencyVOs to set
	 */
	public void setMdmCurrencyVOs(MdmCurrencyVO[] mdmCurrencyVOs) {
		this.mdmCurrencyVOs = mdmCurrencyVOs;
	}

	/**
	 * @return the pageType
	 */
	public String getPageType() {
		return pageType;
	}

	/**
	 * @param pageType the pageType to set
	 */
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	
	
}