/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdTrs0086Event.java
*@FileTitle : CNT(Customer Nominated Trucker) Registration.
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : JEON JEE YE
*@LastVersion : 1.0
* 2014.06.11 JEON JEE YE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esd.trs.codemanage.cnt.vo.SearchCntRgstVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_086 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_086HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 전지예
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0086Event extends EventSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 검색 값
	private String sDtDivCd = null;
	private String sFmDt = null;
	private String sToDt = null;
	private String sEffDt = null;
	private String sCtrtNo = null;
	private String sDispStsCd = "";
	private String sCustSeq = null;
	private String sVndrSeq = null;
	private String sDestNodCd = null;
	
	// Grid 선택 값
	private String prcCtrtTpCd =null;
	private String prcCtrtNo = null;
	private String vndrSeq = null;
	private String ioBndCd  = null;
	private String orgNodCd = null;
	private String orgNodYard = null;
	private String destNodCd = null;
	private String destNodYard = null;
	private String cntrTpszCd = null;
	private String custNomiTrkrBzcAmt = null;
	private String custNomiTrkrFuelAmt = null;
	private String costDesc = null;
	private String mtyPkupRtnYdCd = null;
	private String usaEdiCd 	=  "";
	
	private SearchCntRgstVO searchCntRgstVO = null;
	private SearchCntRgstVO[] searchCntRgstVOs = null;

	public String getMtyPkupRtnYdCd() {
		return mtyPkupRtnYdCd;
	}

	public void setMtyPkupRtnYdCd(String mtyPkupRtnYdCd) {
		this.mtyPkupRtnYdCd = mtyPkupRtnYdCd;
	}

	public String getsDtDivCd() {
		return sDtDivCd;
	}

	public void setsDtDivCd(String sDtDivCd) {
		this.sDtDivCd = sDtDivCd;
	}

	public String getsFmDt() {
		return sFmDt;
	}

	public void setsFmDt(String sFmDt) {
		this.sFmDt = sFmDt;
	}

	public String getsToDt() {
		return sToDt;
	}

	public void setsToDt(String sToDt) {
		this.sToDt = sToDt;
	}

	public String getsEffDt() {
		return sEffDt;
	}

	public void setsEffDt(String sEffDt) {
		this.sEffDt = sEffDt;
	}

	public String getsCtrtNo() {
		return sCtrtNo;
	}

	public void setsCtrtNo(String sCtrtNo) {
		this.sCtrtNo = sCtrtNo;
	}

	public String getsDispStsCd() {
		return sDispStsCd;
	}

	public void setsDispStsCd(String sDispStsCd) {
		this.sDispStsCd = sDispStsCd;
	}

	public String getsCustSeq() {
		return sCustSeq;
	}

	public void setsCustSeq(String sCustSeq) {
		this.sCustSeq = sCustSeq;
	}

	public String getsVndrSeq() {
		return sVndrSeq;
	}

	public void setsVndrSeq(String sVndrSeq) {
		this.sVndrSeq = sVndrSeq;
	}

	public String getPrcCtrtTpCd() {
		return prcCtrtTpCd;
	}

	public void setPrcCtrtTpCd(String prcCtrtTpCd) {
		this.prcCtrtTpCd = prcCtrtTpCd;
	}

	public String getPrcCtrtNo() {
		return prcCtrtNo;
	}

	public void setPrcCtrtNo(String prcCtrtNo) {
		this.prcCtrtNo = prcCtrtNo;
	}
	
	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getIoBndCd() {
		return ioBndCd;
	}

	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	public String getOrgNodCd() {
		return orgNodCd;
	}

	public void setOrgNodCd(String orgNodCd) {
		this.orgNodCd = orgNodCd;
	}

	public String getOrgNodYard() {
		return orgNodYard;
	}

	public void setOrgNodYard(String orgNodYard) {
		this.orgNodYard = orgNodYard;
	}

	public String getDestNodCd() {
		return destNodCd;
	}

	public void setDestNodCd(String destNodCd) {
		this.destNodCd = destNodCd;
	}

	public String getDestNodYard() {
		return destNodYard;
	}

	public void setDestNodYard(String destNodYard) {
		this.destNodYard = destNodYard;
	}

	public String getCntrTpszCd() {
		return cntrTpszCd;
	}

	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	public String getCustNomiTrkrBzcAmt() {
		return custNomiTrkrBzcAmt;
	}

	public void setCustNomiTrkrBzcAmt(String custNomiTrkrBzcAmt) {
		this.custNomiTrkrBzcAmt = custNomiTrkrBzcAmt;
	}

	public String getCustNomiTrkrFuelAmt() {
		return custNomiTrkrFuelAmt;
	}

	public void setCustNomiTrkrFuelAmt(String custNomiTrkrFuelAmt) {
		this.custNomiTrkrFuelAmt = custNomiTrkrFuelAmt;
	}

	public String getCostDesc() {
		return costDesc;
	}

	
	
	public String getUsaEdiCd() {
		return usaEdiCd;
	}

	public void setUsaEdiCd(String usaEdiCd) {
		this.usaEdiCd = usaEdiCd;
	}

	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}

	public SearchCntRgstVO getSearchCntRgstVO() {
		return searchCntRgstVO;
	}

	public String getsDestNodCd() {
		return sDestNodCd;
	}

	public void setsDestNodCd(String sDestNodCd) {
		this.sDestNodCd = sDestNodCd;
	}

	public void setSearchCntRgstVO(SearchCntRgstVO searchCntRgstVO) {
		this.searchCntRgstVO = searchCntRgstVO;
	}

	public SearchCntRgstVO[] getSearchCntRgstVOs() {
		SearchCntRgstVO[] rtnVOs = null;
		if (this.searchCntRgstVOs != null) {
			rtnVOs = Arrays.copyOf(searchCntRgstVOs, searchCntRgstVOs.length);
		}
		return rtnVOs;  //return searchCntRgstVOs;
	}

	public void setSearchCntRgstVOs(SearchCntRgstVO[] searchCntRgstVOs) {
		if(searchCntRgstVOs != null){
			SearchCntRgstVO[] tmpVOs = Arrays.copyOf(searchCntRgstVOs, searchCntRgstVOs.length);
			this.searchCntRgstVOs = tmpVOs;  //this.searchCntRgstVOs = searchCntRgstVOs;
		}
	}

	public EsdTrs0086Event(){}
	
	public String getEventName() {
		return "EsdTrs0086Event";
	}

	public String toString() {
		return "EsdTrs0086Event";
	}
	
}

