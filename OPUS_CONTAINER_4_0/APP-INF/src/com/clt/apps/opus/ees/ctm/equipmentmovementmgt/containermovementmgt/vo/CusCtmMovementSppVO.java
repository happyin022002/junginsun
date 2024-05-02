/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CusCtmMovementSppVO.java
 *@FileTitle : CusCtmMovementSppVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.8.19
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * --------------------------------------------------------
 * History
 * 2014.8.19 이은섭   webservice 요청으로 인해 [CusCtmMovementVO] 웹서비스 용으로 생성
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

import java.io.Serializable;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author 김상수
 * @since J2EE 1.6
 */

public class CusCtmMovementSppVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Column Info */
	private String crntSkdVoyNo = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String gmtDt = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String mvmtInpTpCd = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String mvmtTrspModCd = null;
	/* Column Info */
	private String mvmtEdiMsgSeq = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String ctrtSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mtyRepoVlRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String substRuleCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntrActCd = null;
	/* Column Info */
	private String cntrXchCd = null;
	/* Column Info */
	private String cntrId = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String mvmtEdiTpCd = null;
	/* Column Info */
	private String cntrHngrBarAtchKnt = null;
	/* Column Info */
	private String cntrRfubFlg = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String inpYdCd = null;
	/* Column Info */
	private String mvmtEdiMsgAreaCd = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String ctmUiYn = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String updLoclDt = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String spclCgoFlg = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String mvmtEdiMsgYrmondy = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String pType2 = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String trnkVslCd = null;
	/* Column Info */
	private String pType1 = null;
	/* Column Info */
	private String cntrDispFlg = null;
	/* Column Info */
	private String ctrtOfcCtyCd = null;
	/* Column Info */
	private String trnkSkdVoyNo = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String lstrmCd = null;
	/* Column Info */
	private String cnmvLvlNo = null;
	/* Column Info */
	private String checkDigit = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String xxlink = null;
	/* Column Info */
	private String cntrSvrId = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Column Info */
	private String bbulkFlg = null;
	/* Column Info */
	private String trnkSkdDirCd = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* Column Info */
	private String cnmvSplitNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgKnt = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String newFlg = null;
	/* Column Info */
	private String cntrStsSeq = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String inlndTrspLicNo = null;
	/* Column Info */
	private String crntSkdDirCd = null;
	/* Column Info */
	private String preStsFlg = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String cntrHngrRckFlg = null;
	/* Column Info */
	private String obCntrFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String cnmvCoCd = null;
	/* Column Info */
	private String crntVslCd = null;
	/* Column Info */
	private String woNo = null;

	public String getCrntSkdVoyNo() {
		return crntSkdVoyNo;
	}

	public void setCrntSkdVoyNo(String crntSkdVoyNo) {
		this.crntSkdVoyNo = crntSkdVoyNo;
	}

	public String getBkgCgoTpCd() {
		return bkgCgoTpCd;
	}

	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}

	public String getMvmtEdiMsgTpId() {
		return mvmtEdiMsgTpId;
	}

	public void setMvmtEdiMsgTpId(String mvmtEdiMsgTpId) {
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
	}

	public String getGmtDt() {
		return gmtDt;
	}

	public void setGmtDt(String gmtDt) {
		this.gmtDt = gmtDt;
	}

	public String getCnmvSeq() {
		return cnmvSeq;
	}

	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
	}

	public String getMvmtInpTpCd() {
		return mvmtInpTpCd;
	}

	public void setMvmtInpTpCd(String mvmtInpTpCd) {
		this.mvmtInpTpCd = mvmtInpTpCd;
	}

	public String getChssNo() {
		return chssNo;
	}

	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}

	public String getMvmtTrspModCd() {
		return mvmtTrspModCd;
	}

	public void setMvmtTrspModCd(String mvmtTrspModCd) {
		this.mvmtTrspModCd = mvmtTrspModCd;
	}

	public String getMvmtEdiMsgSeq() {
		return mvmtEdiMsgSeq;
	}

	public void setMvmtEdiMsgSeq(String mvmtEdiMsgSeq) {
		this.mvmtEdiMsgSeq = mvmtEdiMsgSeq;
	}

	public String getDestYdCd() {
		return destYdCd;
	}

	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
	}

	public String getCtrtSeq() {
		return ctrtSeq;
	}

	public void setCtrtSeq(String ctrtSeq) {
		this.ctrtSeq = ctrtSeq;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getMtyRepoVlRmk() {
		return mtyRepoVlRmk;
	}

	public void setMtyRepoVlRmk(String mtyRepoVlRmk) {
		this.mtyRepoVlRmk = mtyRepoVlRmk;
	}

	public String getPagerows() {
		return pagerows;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public String getSubstRuleCd() {
		return substRuleCd;
	}

	public void setSubstRuleCd(String substRuleCd) {
		this.substRuleCd = substRuleCd;
	}

	public String getPolCd() {
		return polCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	public String getVvdCd() {
		return vvdCd;
	}

	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	public String getCntrActCd() {
		return cntrActCd;
	}

	public void setCntrActCd(String cntrActCd) {
		this.cntrActCd = cntrActCd;
	}

	public String getCntrXchCd() {
		return cntrXchCd;
	}

	public void setCntrXchCd(String cntrXchCd) {
		this.cntrXchCd = cntrXchCd;
	}

	public String getCntrId() {
		return cntrId;
	}

	public void setCntrId(String cntrId) {
		this.cntrId = cntrId;
	}

	public String getCntrTpszCd() {
		return cntrTpszCd;
	}

	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	public String getMvmtEdiTpCd() {
		return mvmtEdiTpCd;
	}

	public void setMvmtEdiTpCd(String mvmtEdiTpCd) {
		this.mvmtEdiTpCd = mvmtEdiTpCd;
	}

	public String getCntrHngrBarAtchKnt() {
		return cntrHngrBarAtchKnt;
	}

	public void setCntrHngrBarAtchKnt(String cntrHngrBarAtchKnt) {
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
	}

	public String getCntrRfubFlg() {
		return cntrRfubFlg;
	}

	public void setCntrRfubFlg(String cntrRfubFlg) {
		this.cntrRfubFlg = cntrRfubFlg;
	}

	public String getLstmCd() {
		return lstmCd;
	}

	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getEvntDt() {
		return evntDt;
	}

	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}

	public String getInpYdCd() {
		return inpYdCd;
	}

	public void setInpYdCd(String inpYdCd) {
		this.inpYdCd = inpYdCd;
	}

	public String getMvmtEdiMsgAreaCd() {
		return mvmtEdiMsgAreaCd;
	}

	public void setMvmtEdiMsgAreaCd(String mvmtEdiMsgAreaCd) {
		this.mvmtEdiMsgAreaCd = mvmtEdiMsgAreaCd;
	}

	public String getCallSgnNo() {
		return callSgnNo;
	}

	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}

	public String getCtmUiYn() {
		return ctmUiYn;
	}

	public void setCtmUiYn(String ctmUiYn) {
		this.ctmUiYn = ctmUiYn;
	}

	public String getWblNo() {
		return wblNo;
	}

	public void setWblNo(String wblNo) {
		this.wblNo = wblNo;
	}

	public String getUpdLoclDt() {
		return updLoclDt;
	}

	public void setUpdLoclDt(String updLoclDt) {
		this.updLoclDt = updLoclDt;
	}

	public String getCnmvEvntDt() {
		return cnmvEvntDt;
	}

	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
	}

	public String getSpclCgoFlg() {
		return spclCgoFlg;
	}

	public void setSpclCgoFlg(String spclCgoFlg) {
		this.spclCgoFlg = spclCgoFlg;
	}

	public String getMvmtCreTpCd() {
		return mvmtCreTpCd;
	}

	public void setMvmtCreTpCd(String mvmtCreTpCd) {
		this.mvmtCreTpCd = mvmtCreTpCd;
	}

	public String getAciacDivCd() {
		return aciacDivCd;
	}

	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}

	public String getCnmvIdNo() {
		return cnmvIdNo;
	}

	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
	}

	public String getPodCd() {
		return podCd;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getLloydNo() {
		return lloydNo;
	}

	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}

	public String getMvmtEdiMsgYrmondy() {
		return mvmtEdiMsgYrmondy;
	}

	public void setMvmtEdiMsgYrmondy(String mvmtEdiMsgYrmondy) {
		this.mvmtEdiMsgYrmondy = mvmtEdiMsgYrmondy;
	}

	public String getCnmvRmk() {
		return cnmvRmk;
	}

	public void setCnmvRmk(String cnmvRmk) {
		this.cnmvRmk = cnmvRmk;
	}

	public String getCreLoclDt() {
		return creLoclDt;
	}

	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getpType2() {
		return pType2;
	}

	public void setpType2(String pType2) {
		this.pType2 = pType2;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getTrnkVslCd() {
		return trnkVslCd;
	}

	public void setTrnkVslCd(String trnkVslCd) {
		this.trnkVslCd = trnkVslCd;
	}

	public String getpType1() {
		return pType1;
	}

	public void setpType1(String pType1) {
		this.pType1 = pType1;
	}

	public String getCntrDispFlg() {
		return cntrDispFlg;
	}

	public void setCntrDispFlg(String cntrDispFlg) {
		this.cntrDispFlg = cntrDispFlg;
	}

	public String getCtrtOfcCtyCd() {
		return ctrtOfcCtyCd;
	}

	public void setCtrtOfcCtyCd(String ctrtOfcCtyCd) {
		this.ctrtOfcCtyCd = ctrtOfcCtyCd;
	}

	public String getTrnkSkdVoyNo() {
		return trnkSkdVoyNo;
	}

	public void setTrnkSkdVoyNo(String trnkSkdVoyNo) {
		this.trnkSkdVoyNo = trnkSkdVoyNo;
	}

	public String getPkupNo() {
		return pkupNo;
	}

	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}

	public String getCnmvCycNo() {
		return cnmvCycNo;
	}

	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
	}

	public String getLstrmCd() {
		return lstrmCd;
	}

	public void setLstrmCd(String lstrmCd) {
		this.lstrmCd = lstrmCd;
	}

	public String getCnmvLvlNo() {
		return cnmvLvlNo;
	}

	public void setCnmvLvlNo(String cnmvLvlNo) {
		this.cnmvLvlNo = cnmvLvlNo;
	}

	public String getCheckDigit() {
		return checkDigit;
	}

	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getBkgRcvTermCd() {
		return bkgRcvTermCd;
	}

	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
	}

	public String getXxlink() {
		return xxlink;
	}

	public void setXxlink(String xxlink) {
		this.xxlink = xxlink;
	}

	public String getCntrSvrId() {
		return cntrSvrId;
	}

	public void setCntrSvrId(String cntrSvrId) {
		this.cntrSvrId = cntrSvrId;
	}

	public String getFcntrFlg() {
		return fcntrFlg;
	}

	public void setFcntrFlg(String fcntrFlg) {
		this.fcntrFlg = fcntrFlg;
	}

	public String getBbulkFlg() {
		return bbulkFlg;
	}

	public void setBbulkFlg(String bbulkFlg) {
		this.bbulkFlg = bbulkFlg;
	}

	public String getTrnkSkdDirCd() {
		return trnkSkdDirCd;
	}

	public void setTrnkSkdDirCd(String trnkSkdDirCd) {
		this.trnkSkdDirCd = trnkSkdDirCd;
	}

	public String getCntrDmgFlg() {
		return cntrDmgFlg;
	}

	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
	}

	public String getCnmvSplitNo() {
		return cnmvSplitNo;
	}

	public void setCnmvSplitNo(String cnmvSplitNo) {
		this.cnmvSplitNo = cnmvSplitNo;
	}

	public String getIbflag() {
		return ibflag;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public String getBkgKnt() {
		return bkgKnt;
	}

	public void setBkgKnt(String bkgKnt) {
		this.bkgKnt = bkgKnt;
	}

	public String getUsrNm() {
		return usrNm;
	}

	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	public String getNewFlg() {
		return newFlg;
	}

	public void setNewFlg(String newFlg) {
		this.newFlg = newFlg;
	}

	public String getCntrStsSeq() {
		return cntrStsSeq;
	}

	public void setCntrStsSeq(String cntrStsSeq) {
		this.cntrStsSeq = cntrStsSeq;
	}

	public String getBkgNoSplit() {
		return bkgNoSplit;
	}

	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}

	public String getInlndTrspLicNo() {
		return inlndTrspLicNo;
	}

	public void setInlndTrspLicNo(String inlndTrspLicNo) {
		this.inlndTrspLicNo = inlndTrspLicNo;
	}

	public String getCrntSkdDirCd() {
		return crntSkdDirCd;
	}

	public void setCrntSkdDirCd(String crntSkdDirCd) {
		this.crntSkdDirCd = crntSkdDirCd;
	}

	public String getPreStsFlg() {
		return preStsFlg;
	}

	public void setPreStsFlg(String preStsFlg) {
		this.preStsFlg = preStsFlg;
	}

	public String getOrgYdCd() {
		return orgYdCd;
	}

	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}

	public String getMgstNo() {
		return mgstNo;
	}

	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
	}

	public String getCntrHngrRckFlg() {
		return cntrHngrRckFlg;
	}

	public void setCntrHngrRckFlg(String cntrHngrRckFlg) {
		this.cntrHngrRckFlg = cntrHngrRckFlg;
	}

	public String getObCntrFlg() {
		return obCntrFlg;
	}

	public void setObCntrFlg(String obCntrFlg) {
		this.obCntrFlg = obCntrFlg;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getMvmtStsCd() {
		return mvmtStsCd;
	}

	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getCntrSealNo() {
		return cntrSealNo;
	}

	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}

	public String getImdtExtFlg() {
		return imdtExtFlg;
	}

	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}

	public String getCnmvYr() {
		return cnmvYr;
	}

	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}

	public String getCnmvCoCd() {
		return cnmvCoCd;
	}

	public void setCnmvCoCd(String cnmvCoCd) {
		this.cnmvCoCd = cnmvCoCd;
	}

	public String getCrntVslCd() {
		return crntVslCd;
	}

	public void setCrntVslCd(String crntVslCd) {
		this.crntVslCd = crntVslCd;
	}

	public String getWoNo() {
		return woNo;
	}

	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
}
