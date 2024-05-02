/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_023Event.java
 *@FileTitle : W/O 발행화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-21
 *@LastModifier : poong_yeon
 *@LastVersion : 1.0 
 * 2006-11-21 poong_yeon
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.WoIssueListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ESD_TRS_023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * @author poong_yeon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0023Event extends EventSupport {

	private static final long serialVersionUID = 121174236460395671L;

	private String localTotAmt;
	private String localCurrCd;
	private String formUsrOfcCd;
	private String formCreUsrId;
	private String trspSoOfcCtyCd;
	private String trspSoSeq;
	private String spTpCd;
	private String wyTpCd;
	private String vndrCd;
	private String wtrRcvTerm;
	private String wtrDeTerm;
	private String custCntCd;
	private String custSeq;
	private String basisDt;
	private String woRadio;
	private String dtRadio;
	private String fmdate;
	private String todate;
	private String comboSvcProvider;
	private String woNo;
	private String trsBndCd;
	private String trsCostMdCd;
	private String trsMdCd;
	private String defalutCurr;
	private String trsSoTpCd;
	private String fmNod;
	private String toNod;
	private String dorNod;
	private String viaNod;
	private String tvvdNo;
	private String fvvdNo;
	private String fVvdRadio;
	private String bkgNo;
	private String blNo;
	private String eqRadio;
	private String eqNo;
	private String soNo;
	private String mtyRfrnNo;
	private String woPrvGrpSeq;
	private String woIssNo;
	private String woIssStsCd;
	private String dorArrDt;
	private String dorArrTm;
	private String dorPstCd;
	private String fmLccCd;
	private String toLccCd;
	private String eccCd;
	private String inputOffice;
	private String copNo;
	private String ruoh;
	private String cgoTpCd;
	private String eqTpszCd;

	private String initTrspSoOfcCtyCd;
	private String initTrspSoSeq;

	private String trsSubStsCdN;
	private String trsSubStsCd = "";

	private String spclCgCntrTpCd;

	private String trsChgTpCd;
	private String userId;
	private String copFlg;
	private String cntrSltNo;
	private String cnmvStsCd;
	private String crntYdCd;

	private String srcKeepFlg;
	private String keepSoNos;

	private TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs = null;
	private WoIssueListVO[] woIssueListVOs = null;
	private WoIssueListVO woIssueListVO = null;

	@SuppressWarnings("rawtypes")
	private Collection trsTrspSvcOrds = null;

	@SuppressWarnings("rawtypes")
	private Collection surchargeVOs = null;

	@SuppressWarnings("rawtypes")
	private Collection workOrderIssueVOs = null;

	@SuppressWarnings("rawtypes")
	private HashMap hashParam = new HashMap();

	private TrsTrspSvcOrdVO trsTrspSvcOrd;

	public EsdTrs0023Event() {
	}

	/**
	 * @param trsTrspSvcOrd
	 * @param trsTrspSvcOrds
	 */
	@SuppressWarnings("rawtypes")
	public EsdTrs0023Event(TrsTrspSvcOrdVO trsTrspSvcOrd, Collection trsTrspSvcOrds) {
		this.trsTrspSvcOrd = trsTrspSvcOrd;
		this.trsTrspSvcOrds = trsTrspSvcOrds;
	}

	public WoIssueListVO[] getWoIssueListVOs() {
		WoIssueListVO[] rtnVOs = null;
		if (this.woIssueListVOs != null) {
			rtnVOs = Arrays.copyOf(woIssueListVOs, woIssueListVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setWoIssueListVOs(WoIssueListVO[] WoIssueListVOs) {
		if (WoIssueListVOs != null) {
			WoIssueListVO[] tmpVOs = Arrays.copyOf(WoIssueListVOs, WoIssueListVOs.length);
			this.woIssueListVOs = tmpVOs;
		} // end if
	}

	public WoIssueListVO getWoIssueListVO() {
		return woIssueListVO;
	}

	public void setWoIssueListVO(WoIssueListVO woIssueListVO) {
		this.woIssueListVO = woIssueListVO;
	}

	public TrsTrspSvcOrdVO[] getTrsTrspSvcOrdVOs() {
		TrsTrspSvcOrdVO[] rtnVOs = null;
		if (this.trsTrspSvcOrdVOs != null) {
			rtnVOs = Arrays.copyOf(trsTrspSvcOrdVOs, trsTrspSvcOrdVOs.length);
		}
		return rtnVOs;
	}

	public void setTrsTrspSvcOrdVOs(TrsTrspSvcOrdVO[] TrsTrspSvcOrdVOs) {
		if (TrsTrspSvcOrdVOs != null) {
			TrsTrspSvcOrdVO[] tmpVOs = Arrays.copyOf(TrsTrspSvcOrdVOs, TrsTrspSvcOrdVOs.length);
			this.trsTrspSvcOrdVOs = tmpVOs;
		}
	}

	public String getInitTrspSoOfcCtyCd() {
		return initTrspSoOfcCtyCd;
	}

	public void setInitTrspSoOfcCtyCd(String initTrspSoOfcCtyCd) {
		this.initTrspSoOfcCtyCd = initTrspSoOfcCtyCd;
	}

	public String getInitTrspSoSeq() {
		return initTrspSoSeq;
	}

	public void setInitTrspSoSeq(String initTrspSoSeq) {
		this.initTrspSoSeq = initTrspSoSeq;
	}

	public void setSpclCgCntrTpCd(String spclCgCntrTpCd) {
		this.spclCgCntrTpCd = spclCgCntrTpCd;
	}

	public String getSpclCgCntrTpCd() {
		return spclCgCntrTpCd;
	}

	public void setWoIssStsCd(String woIssStsCd) {
		this.woIssStsCd = woIssStsCd;
	}

	public String getWoIssStsCd() {
		return woIssStsCd;
	}

	public void setDorArrDt(String dorArrDt) {
		this.dorArrDt = dorArrDt;
	}

	public String getDorArrDt() {
		return dorArrDt;
	}

	public void setDorArrTm(String dorArrTm) {
		this.dorArrTm = dorArrTm;
	}

	public String getDorArrTm() {
		return dorArrTm;
	}

	public void setDorPstCd(String dorPstCd) {
		this.dorPstCd = dorPstCd;
	}

	public String getDorPstCd() {
		return dorPstCd;
	}

	public void setFmLccCd(String fmLccCd) {
		this.fmLccCd = fmLccCd;
	}

	public String getFmLccCd() {
		return fmLccCd;
	}

	public void setToLccCd(String toLccCd) {
		this.toLccCd = toLccCd;
	}

	public String getToLccCd() {
		return toLccCd;
	}

	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}

	public String getEccCd() {
		return eccCd;
	}

	public void setInputOffice(String inputOffice) {
		this.inputOffice = inputOffice;
	}

	public String getInputOffice() {
		return inputOffice;
	}

	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	public String getCopNo() {
		return copNo;
	}

	public void setRuoh(String ruoh) {
		this.ruoh = ruoh;
	}

	public String getRuoh() {
		return ruoh;
	}

	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}

	public String getCgoTpCd() {
		return cgoTpCd;
	}

	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}

	public String getEqTpszCd() {
		return eqTpszCd;
	}

	public void setLocalTotAmt(String localTotAmt) {
		this.localTotAmt = localTotAmt;
	}

	public String getLocalTotAmt() {
		return localTotAmt;
	}

	public void setLocalCurrCd(String localCurrCd) {
		this.localCurrCd = localCurrCd;
	}

	public String getLocalCurrCd() {
		return localCurrCd;
	}

	public void setWoPrvGrpSeq(String woPrvGrpSeq) {
		this.woPrvGrpSeq = woPrvGrpSeq;
	}

	public String getWoPrvGrpSeq() {
		return woPrvGrpSeq;
	}

	public void setWoIssNo(String woIssNo) {
		this.woIssNo = woIssNo;
	}

	public String getWoIssNo() {
		return woIssNo;
	}

	public void setFormUsrOfcCd(String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
	}

	public String getFormUsrOfcCd() {
		return formUsrOfcCd;
	}

	public void setFormCreUsrId(String formCreUsrId) {
		this.formCreUsrId = formCreUsrId;
	}

	public String getFormCreUsrId() {
		return formCreUsrId;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	public String getCustCntCd() {
		return custCntCd;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	public String getCustSeq() {
		return custSeq;
	}

	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}

	public String getTrspSoOfcCtyCd() {
		return trspSoOfcCtyCd;
	}

	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}

	public String getTrspSoSeq() {
		return trspSoSeq;
	}

	public void setWyTpCd(String wyTpCd) {
		this.wyTpCd = wyTpCd;
	}

	public String getWyTpCd() {
		return wyTpCd;
	}

	public void setSpTpCd(String spTpCd) {
		this.spTpCd = spTpCd;
	}

	public String getSpTpCd() {
		return spTpCd;
	}

	public void setVndrCd(String vndrCd) {
		this.vndrCd = vndrCd;
	}

	public String getVndrCd() {
		return vndrCd;
	}

	public void setWtrRcvTerm(String wtrRcvTerm) {
		this.wtrRcvTerm = wtrRcvTerm;
	}

	public String getWtrRcvTerm() {
		return wtrRcvTerm;
	}

	public void setWtrDeTerm(String wtrDeTerm) {
		this.wtrDeTerm = wtrDeTerm;
	}

	public String getWtrDeTerm() {
		return wtrDeTerm;
	}

	public void setBasisDt(String basisDt) {
		this.basisDt = basisDt;
	}

	public String getBasisDt() {
		return basisDt;
	}

	public String getEventName() {
		return "EsdTrs0023Event";
	}

	public String toString() {
		return "EsdTrs0023Event";
	}

	public TrsTrspSvcOrdVO getTrsTrspSvcOrd() {
		return trsTrspSvcOrd;
	}

	public void setTrsTrspSvcOrd(TrsTrspSvcOrdVO trsTrspSvcOrd) {
		this.trsTrspSvcOrd = trsTrspSvcOrd;
	}

	@SuppressWarnings("rawtypes")
	public Collection getTrsTrspSvcOrds() {
		return trsTrspSvcOrds;
	}

	@SuppressWarnings("rawtypes")
	public Collection getSurchargeVOs() {
		return surchargeVOs;
	}

	@SuppressWarnings("rawtypes")
	public HashMap getHashParam() {
		return hashParam;
	}

	@SuppressWarnings("rawtypes")
	public Collection getWorkOrderIssueVOs() {
		return this.workOrderIssueVOs;
	}

	@SuppressWarnings("rawtypes")
	public void setWorkOrderIssueVOs(Collection workOrderIssueVOsValue) {
		this.workOrderIssueVOs = workOrderIssueVOsValue;
	}

	@SuppressWarnings("rawtypes")
	public void setHashParam(HashMap hashParamValue) {
		this.hashParam = hashParamValue;
	}

	@SuppressWarnings("rawtypes")
	public void setSurchargeVOs(Collection surchargeVOsValue) {
		this.surchargeVOs = surchargeVOsValue;
	}

	public void setWoRadio(String woRadio) {
		this.woRadio = woRadio;
	}

	public String getWoRadio() {
		return woRadio;
	}

	public void setDtRadio(String dtRadio) {
		this.dtRadio = dtRadio;
	}

	public String getDtRadio() {
		return dtRadio;
	}

	public void setFmdate(String fmdate) {
		this.fmdate = fmdate;
	}

	public String getFmdate() {
		return fmdate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getTodate() {
		return todate;
	}

	public void setComboSvcProvider(String comboSvcProvider) {
		this.comboSvcProvider = comboSvcProvider;
	}

	public String getComboSvcProvider() {
		return comboSvcProvider;
	}

	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}

	public String getWoNo() {
		return woNo;
	}

	public void setTrsBndCd(String trsBndCd) {
		this.trsBndCd = trsBndCd;
	}

	public String getTrsBndCd() {
		return trsBndCd;
	}

	public void setTrsCostMdCd(String trsCostMdCd) {
		this.trsCostMdCd = trsCostMdCd;
	}

	public String getTrsCostMdCd() {
		return trsCostMdCd;
	}

	public void setTrsMdCd(String trsMdCd) {
		this.trsMdCd = trsMdCd;
	}

	public String getTrsMdCd() {
		return trsMdCd;
	}

	public void setDefalutCurr(String defalutCurr) {
		this.defalutCurr = defalutCurr;
	}

	public String getDefalutCurr() {
		return defalutCurr;
	}

	public void setTrsSoTpCd(String trsSoTpCd) {
		this.trsSoTpCd = trsSoTpCd;
	}

	public String getTrsSoTpCd() {
		return trsSoTpCd;
	}

	public void setFmNod(String fmNod) {
		this.fmNod = fmNod;
	}

	public String getFmNod() {
		return fmNod;
	}

	public void setToNod(String toNod) {
		this.toNod = toNod;
	}

	public String getToNod() {
		return toNod;
	}

	public void setDorNod(String dorNod) {
		this.dorNod = dorNod;
	}

	public String getDorNod() {
		return dorNod;
	}

	public void setViaNod(String viaNod) {
		this.viaNod = viaNod;
	}

	public String getViaNod() {
		return viaNod;
	}

	public void setTvvdNo(String tvvdNo) {
		this.tvvdNo = tvvdNo;
	}

	public String getTvvdNo() {
		return tvvdNo;
	}

	public void setFvvdNo(String fvvdNo) {
		this.fvvdNo = fvvdNo;
	}

	public String getFvvdNo() {
		return fvvdNo;
	}

	public void setFVvdRadio(String fVvdRadio) {
		this.fVvdRadio = fVvdRadio;
	}

	public String getFVvdRadio() {
		return fVvdRadio;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setEqRadio(String eqRadio) {
		this.eqRadio = eqRadio;
	}

	public String getEqRadio() {
		return eqRadio;
	}

	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}

	public String getEqNo() {
		return eqNo;
	}

	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}

	public String getSoNo() {
		return soNo;
	}

	public void setMtyRfrnNo(String mtyRfrnNo) {
		this.mtyRfrnNo = mtyRfrnNo;
	}

	public String getMtyRfrnNo() {
		return mtyRfrnNo;
	}

	public String getTrsSubStsCdN() {
		return trsSubStsCdN;
	}

	public void setTrsSubStsCdN(String trsSubStsCdN) {
		this.trsSubStsCdN = trsSubStsCdN;
	}

	public String getTrsSubStsCd() {
		return trsSubStsCd;
	}

	public void setTrsSubStsCd(String trsSubStsCd) {
		this.trsSubStsCd = trsSubStsCd;
	}

	public String getTrsChgTpCd() {
		return trsChgTpCd;
	}

	public void setTrsChgTpCd(String trsChgTpCd) {
		this.trsChgTpCd = trsChgTpCd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCopFlg() {
		return copFlg;
	}

	public void setCopFlg(String copFlg) {
		this.copFlg = copFlg;
	}

	public String getCntrSltNo() {
		return cntrSltNo;
	}

	public void setCntrSltNo(String cntrSltNo) {
		this.cntrSltNo = cntrSltNo;
	}

	public String getCnmvStsCd() {
		return cnmvStsCd;
	}

	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}

	public String getCrntYdCd() {
		return crntYdCd;
	}

	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}

	public String getSrcKeepFlg() {
		return srcKeepFlg;
	}

	public void setSrcKeepFlg(String srcKeepFlg) {
		this.srcKeepFlg = srcKeepFlg;
	}

	public String getKeepSoNos() {
		return keepSoNos;
	}

	public void setKeepSoNos(String keepSoNos) {
		this.keepSoNos = keepSoNos;
	}
}
