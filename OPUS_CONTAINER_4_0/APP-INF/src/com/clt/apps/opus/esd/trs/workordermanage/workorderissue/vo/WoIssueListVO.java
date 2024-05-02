/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : WoIssueListVO.java
 *@FileTitle : WoIssueListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.02
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.12.02  
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class WoIssueListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<WoIssueListVO> models = new ArrayList<WoIssueListVO>();

	/* Column Info */
	private String ibVvdCd = null;
	/* Column Info */
	private String n3ptyBzcTpCd = null;
	/* Column Info */
	private String troCfmUpdTm = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String poLocalCurrTotAmt = null;
	/* Column Info */
	private String cngCateCd = null;
	/* Column Info */
	private String trspAgmtRtTpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3ptyBzcCustSeq = null;
	/* Column Info */
	private String dorPstCd = null;
	/* Column Info */
	private String poFuelScgRt = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String trspFrstFlg = null;
	/* Column Info */
	private String trspSoTpNm = null;
	/* Column Info */
	private String poUsdCurrTotAmt = null;
	/* Column Info */
	private String woIssued = null;
	/* Column Info */
	private String nowReadVal = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String poCustNomiTrkrFlg = null;
	/* Column Info */
	private String cgoTpNm = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String trspSoCmbTpCd = null;
	/* Column Info */
	private String troCfmUsrId = null;
	/* Column Info */
	private String mtyRrFlg = null;
	/* Column Info */
	private String trspCostDtlModNm = null;
	/* Column Info */
	private String poBasicRt = null;
	/* Column Info */
	private String woRjctDt = null;
	/* Column Info */
	private String actCustCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String negoAmt = null;
	/* Column Info */
	private String woTotAmt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String n3ptyBzcDesc = null;
	/* Column Info */
	private String fctryNm = null;
	/* Column Info */
	private String loclUpdDt = null;
	/* Column Info */
	private String cancelCheck = null;
	/* Column Info */
	private String woIssStsCd = null;
	/* Column Info */
	private String distance = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String poTrspAgmtRtTpNm = null;
	/* Column Info */
	private String n3ptyBzcCustCntCd = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String fmYardValue = null;
	/* Column Info */
	private String fmLocValue = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String viaYardValue = null;
	/* Column Info */
	private String shprCustNm = null;
	/* Column Info */
	private String trspAgmtWyTpCd = null;
	/* Column Info */
	private String trspRjctRsnCd = null;
	/* Column Info */
	private String poOverWgtScgRt = null;
	/* Column Info */
	private String lstNodPlnDt = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String bzcAmt = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String fuelScgAmt = null;
	/* Column Info */
	private String n3ptyBzcOfcCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String custCntCdSeq = null;
	/* Column Info */
	private String n3ptyBilFlg = null;
	/* Column Info */
	private String toLocValue = null;
	/* Column Info */
	private String distanceUom = null;
	/* Column Info */
	private String woCreNm = null;
	/* Column Info */
	private String viaLocValue = null;
	/* Column Info */
	private String cneeCustNm = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String woRjctIndct = null;
	/* Column Info */
	private String n1stNodPlnDt = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String n3ptyBzcAmt = null;
	/* Column Info */
	private String n1stNodPlnTm = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String cntrKgsWgt = null;
	/* Column Info */
	private String colNm = null;
	/* Column Info */
	private String troCnfm = null;
	/* Column Info */
	private String dtnUseFlg = null;
	/* Column Info */
	private String trspCrrModNm = null;
	/* Column Info */
	private String bundlingNo = null;
	/* Column Info */
	private String n3ptyBzcVndrSeq = null;
	/* Column Info */
	private String trsSubStsCd = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String dorDeAddr = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String woIssueDt = null;
	/* Column Info */
	private String soCreNm = null;
	/* Column Info */
	private String lstNodPlnTm = null;
	/* Column Info */
	private String poTrspAgmtSeq = null;
	/* Column Info */
	private String spclCgoCntrTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String trspAgmtRtTpCd = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String cntcPsonFaxNo = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String dorNodPlnDt = null;
	/* Column Info */
	private String poTrspAgmtRtTpCd = null;
	/* Column Info */
	private String poTrspAgmtOfcCtyCd = null;
	/* Column Info */
	private String mltStopDeFlg = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String trspSoCmbTpNm = null;
	/* Column Info */
	private String woBlNoIssFlg = null;
	/* Column Info */
	private String trspSoTpCd = null;
	/* Column Info */
	private String revCurrCd = null;
	/* Column Info */
	private String woRmk = null;
	/* Column Info */
	private String defaultSpFlg = null;
	/* Column Info */
	private String trspDfltVndrFlg = null;
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String fdrVvd = null;
	/* Column Info */
	private String surchargeKey = null;
	/* Column Info */
	private String poCustSeq = null;
	/* Column Info */
	private String cntcPsonPhnNo = null;
	/* Column Info */
	private String cntrLbsWgt = null;
	/* Column Info */
	private String soCreDt = null;
	/* Column Info */
	private String poSpType = null;
	/* Column Info */
	private String bkgspe = null;
	/* Column Info */
	private String costActGrpCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String wgtMeasUtCd = null;
	/* Column Info */
	private String trspSoOfcCtyCdSeq = null;
	/* Column Info */
	private String troCfmOfcCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String poRtnMsg = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String toYardValue = null;
	/* Column Info */
	private String trspRqstBkgFlg = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String n3ptyBzcCurrCd = null;
	/* Column Info */
	private String poCustCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String poCustCntCdSeq = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String dorYardValue = null;
	/* Column Info */
	private String woEdiUseFlg = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String moreCandidates = null;
	/* Column Info */
	private String spclInstrRmk = null;
	/* Column Info */
	private String revenue = null;
	/* Column Info */
	private String presetVndrSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String etcAddAmt = null;
	/* Column Info */
	private String woTotAmtUsd = null;
	/* Column Info */
	private String cngCateSubCd = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String poWayType = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String dorNodPlnTm = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String spType = null;
	/* Column Info */
	private String troCfmUpdDt = null;
	/* Column Info */
	private String poRtnCd = null;
	/* Column Info */
	private String bkgTroNo = null;
	/* Column Info */
	private String previousVal = null;
	/* Column Info */
	private String rejectedCheck = null;
	/* Column Info */
	private String obVvdCd = null;
	/* Column Info */
	private String poLocalCurrCd = null;
	/* Column Info */
	private String ntfyCustNm = null;
	/* Column Info */
	private String dorLocValue = null;
	/* Column Info */
	private String trspSoCmbSeq = null;
	/* Column Info */
	private String trspWoOfcCtyCdSeq = null;
	/* Column Info */
	private String custNomiTrkrFlg = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String cngIndFlg = null;
	/* Column Info */
	private String rCct = null;
	/* Column Info */
	private String tCct = null;

	/* Column Info */
	private String kgsNetWgt = null;
	/* Column Info */
	private String kgsTareWgt = null;
	/* Column Info */
	private String kgsGrossWgt = null;
	/* Column Info */
	private String lbsNetWgt = null;
	/* Column Info */
	private String lbsTareWgt = null;
	/* Column Info */
	private String lbsGrossWgt = null;
	/* Column Info */
	private String cngIndFlgImg = null;
	/* Column Info */
	private String vndrCm = null;
	/* Column Info */
	private String vndrCmImg = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String copFlg = null;
	/* Column Info */
	private String copEqNo = null;
	/* Column Info */
	private String interRmkImg = null;
	/* Column Info */
	private String cgoFrtRcvIndFlg = null;
	/* Column Info */
	private String cgoOblRcvIndFlg = null;
	/* Column Info */
	private String cgoCstmsClrIndFlg = null;
	/* Column Info */
	private String cntrPkupNo = null;
	/* Column Info */
	private String foFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bkgStsCdNm = null;
	/* Column Info */
	private String pwrSplCblFlg = null;
	/* Column Info */
	private String cntrSltNo = null;
	/* Column Info */
	private String rvnMptCntr = null;
	/* Column Info */
	private String doHldFlg = null;
	/* Column Info */
	private String fmNodCdNm = null;
	/* Column Info */
	private String viaNodCdNm = null;
	/* Column Info */
	private String toNodCdNm = null;
	/* Column Info */
	private String dorNodCdNm = null;

	/* Column Info */
	private String porCdNm = null;
	/* Column Info */
	private String polCdNm = null;
	/* Column Info */
	private String podCdNm = null;
	/* Column Info */
	private String delCdNm = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String scgIndCd = null;
	/* Column Info */
	private String vgmKgsWgt = null;
	/* Column Info */
	private String vgmLbsWgt = null;
	/* Column Info */
	private String ibcheck = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public WoIssueListVO() {
	}

	public WoIssueListVO(String ibflag, String pagerows, String ibVvdCd, String n3ptyBzcTpCd, String troCfmUpdTm, String cgoTpCd, String poLocalCurrTotAmt, String trspAgmtRtTpNm, String dorPstCd,
			String n3ptyBzcCustSeq, String trspFrstFlg, String tVvd, String poFuelScgRt, String trspSoTpNm, String poUsdCurrTotAmt, String custCntCd, String poCustNomiTrkrFlg, String cgoTpNm,
			String cntrWgt, String trspSoCmbTpCd, String troCfmUsrId, String mtyRrFlg, String trspCostDtlModNm, String poBasicRt, String woRjctDt, String actCustCd, String eqTpszCd, String woTotAmt,
			String negoAmt, String bkgNo, String n3ptyBzcDesc, String fctryNm, String cancelCheck, String distance, String interRmk, String cmdtCd, String bkgQty, String n3ptyBzcCustCntCd,
			String poTrspAgmtRtTpNm, String dorNodCd, String fmLocValue, String fmYardValue, String trspCrrModCd, String viaYardValue, String shprCustNm, String trspAgmtWyTpCd, String trspRjctRsnCd,
			String lstNodPlnDt, String poOverWgtScgRt, String bzcAmt, String trspWoOfcCtyCd, String fuelScgAmt, String n3ptyBzcOfcCd, String fmNodCd, String custCntCdSeq, String n3ptyBilFlg,
			String toLocValue, String distanceUom, String woCreNm, String viaLocValue, String cneeCustNm, String costActGrpSeq, String woRjctIndct, String n1stNodPlnDt, String viaNodCd,
			String n3ptyBzcAmt, String eqKndCd, String n1stNodPlnTm, String toNodCd, String cntrKgsWgt, String troCnfm, String dtnUseFlg, String trspCrrModNm, String bundlingNo,
			String n3ptyBzcVndrSeq, String trspSoSeq, String dorDeAddr, String copNo, String woIssueDt, String soCreNm, String lstNodPlnTm, String poTrspAgmtSeq, String spclCgoCntrTpCd, String blNo,
			String trspAgmtRtTpCd, String vndrNm, String cntcPsonFaxNo, String trspCostDtlModCd, String dorNodPlnDt, String poTrspAgmtRtTpCd, String poTrspAgmtOfcCtyCd, String mltStopDeFlg,
			String wgtUtCd, String trspSoCmbTpNm, String woBlNoIssFlg, String trspSoTpCd, String revCurrCd, String woRmk, String defaultSpFlg, String trspWoSeq, String trspDfltVndrFlg,
			String surchargeKey, String fdrVvd, String poCustSeq, String cntcPsonPhnNo, String soCreDt, String cntrLbsWgt, String poSpType, String bkgspe, String costActGrpCd, String vndrSeq,
			String wgtMeasUtCd, String trspSoOfcCtyCdSeq, String troCfmOfcCd, String currCd, String poRtnMsg, String toYardValue, String creDt, String refId, String trspRqstBkgFlg,
			String trspSoOfcCtyCd, String lane, String n3ptyBzcCurrCd, String poCustCntCd, String eqNo, String poCustCntCdSeq, String woEdiUseFlg, String dorYardValue, String creOfcCd,
			String cntcPsonNm, String moreCandidates, String spclInstrRmk, String presetVndrSeq, String revenue, String etcAddAmt, String woTotAmtUsd, String trspBndCd, String poWayType,
			String troSeq, String dorNodPlnTm, String custSeq, String spType, String troCfmUpdDt, String bkgTroNo, String poRtnCd, String rejectedCheck, String obVvdCd, String poLocalCurrCd,
			String dorLocValue, String ntfyCustNm, String trspWoOfcCtyCdSeq, String trspSoCmbSeq, String custNomiTrkrFlg, String woIssued, String trsSubStsCd, String woIssStsCd, String cngCateCd,
			String cngCateSubCd, String colNm, String nowReadVal, String previousVal, String usrNm, String ofcCd, String updUsrId, String loclUpdDt, String updDt, String eccCd, String cngIndFlg,
			String rCct, String tCct, String kgsNetWgt, String kgsTareWgt, String kgsGrossWgt, String lbsNetWgt, String lbsTareWgt, String lbsGrossWgt, String cngIndFlgImg, String vndrCm,
			String vndrCmImg, String cnmvStsCd, String crntYdCd, String cnmvDt, String copFlg, String copEqNo, String interRmkImg, String cgoFrtRcvIndFlg, String cgoOblRcvIndFlg,
			String cgoCstmsClrIndFlg, String cntrPkupNo, String foFlg, String bkgStsCd, String bkgStsCdNm, String pwrSplCblFlg, String cntrSltNo, String rvnMptCntr, String doHldFlg, String fmNodCdNm,
			String viaNodCdNm, String toNodCdNm, String dorNodCdNm, String porCdNm, String polCdNm, String podCdNm, String delCdNm, String contiCd, String scgIndCd, String vgmKgsWgt,
			String vgmLbsWgt, String ibcheck) {
		this.ibVvdCd = ibVvdCd;
		this.n3ptyBzcTpCd = n3ptyBzcTpCd;
		this.troCfmUpdTm = troCfmUpdTm;
		this.cgoTpCd = cgoTpCd;
		this.poLocalCurrTotAmt = poLocalCurrTotAmt;
		this.cngCateCd = cngCateCd;
		this.trspAgmtRtTpNm = trspAgmtRtTpNm;
		this.pagerows = pagerows;
		this.n3ptyBzcCustSeq = n3ptyBzcCustSeq;
		this.dorPstCd = dorPstCd;
		this.poFuelScgRt = poFuelScgRt;
		this.tVvd = tVvd;
		this.trspFrstFlg = trspFrstFlg;
		this.trspSoTpNm = trspSoTpNm;
		this.poUsdCurrTotAmt = poUsdCurrTotAmt;
		this.woIssued = woIssued;
		this.nowReadVal = nowReadVal;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.poCustNomiTrkrFlg = poCustNomiTrkrFlg;
		this.cgoTpNm = cgoTpNm;
		this.cntrWgt = cntrWgt;
		this.trspSoCmbTpCd = trspSoCmbTpCd;
		this.troCfmUsrId = troCfmUsrId;
		this.mtyRrFlg = mtyRrFlg;
		this.trspCostDtlModNm = trspCostDtlModNm;
		this.poBasicRt = poBasicRt;
		this.woRjctDt = woRjctDt;
		this.actCustCd = actCustCd;
		this.eqTpszCd = eqTpszCd;
		this.negoAmt = negoAmt;
		this.woTotAmt = woTotAmt;
		this.bkgNo = bkgNo;
		this.n3ptyBzcDesc = n3ptyBzcDesc;
		this.fctryNm = fctryNm;
		this.loclUpdDt = loclUpdDt;
		this.cancelCheck = cancelCheck;
		this.woIssStsCd = woIssStsCd;
		this.distance = distance;
		this.interRmk = interRmk;
		this.cmdtCd = cmdtCd;
		this.poTrspAgmtRtTpNm = poTrspAgmtRtTpNm;
		this.n3ptyBzcCustCntCd = n3ptyBzcCustCntCd;
		this.bkgQty = bkgQty;
		this.dorNodCd = dorNodCd;
		this.fmYardValue = fmYardValue;
		this.fmLocValue = fmLocValue;
		this.trspCrrModCd = trspCrrModCd;
		this.viaYardValue = viaYardValue;
		this.shprCustNm = shprCustNm;
		this.trspAgmtWyTpCd = trspAgmtWyTpCd;
		this.trspRjctRsnCd = trspRjctRsnCd;
		this.poOverWgtScgRt = poOverWgtScgRt;
		this.lstNodPlnDt = lstNodPlnDt;
		this.eqKndCd = eqKndCd;
		this.bzcAmt = bzcAmt;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.fuelScgAmt = fuelScgAmt;
		this.n3ptyBzcOfcCd = n3ptyBzcOfcCd;
		this.fmNodCd = fmNodCd;
		this.ofcCd = ofcCd;
		this.custCntCdSeq = custCntCdSeq;
		this.n3ptyBilFlg = n3ptyBilFlg;
		this.toLocValue = toLocValue;
		this.distanceUom = distanceUom;
		this.woCreNm = woCreNm;
		this.viaLocValue = viaLocValue;
		this.cneeCustNm = cneeCustNm;
		this.costActGrpSeq = costActGrpSeq;
		this.woRjctIndct = woRjctIndct;
		this.n1stNodPlnDt = n1stNodPlnDt;
		this.viaNodCd = viaNodCd;
		this.n3ptyBzcAmt = n3ptyBzcAmt;
		this.n1stNodPlnTm = n1stNodPlnTm;
		this.toNodCd = toNodCd;
		this.cntrKgsWgt = cntrKgsWgt;
		this.colNm = colNm;
		this.troCnfm = troCnfm;
		this.dtnUseFlg = dtnUseFlg;
		this.trspCrrModNm = trspCrrModNm;
		this.bundlingNo = bundlingNo;
		this.n3ptyBzcVndrSeq = n3ptyBzcVndrSeq;
		this.trsSubStsCd = trsSubStsCd;
		this.trspSoSeq = trspSoSeq;
		this.dorDeAddr = dorDeAddr;
		this.copNo = copNo;
		this.woIssueDt = woIssueDt;
		this.soCreNm = soCreNm;
		this.lstNodPlnTm = lstNodPlnTm;
		this.poTrspAgmtSeq = poTrspAgmtSeq;
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
		this.blNo = blNo;
		this.trspAgmtRtTpCd = trspAgmtRtTpCd;
		this.vndrNm = vndrNm;
		this.cntcPsonFaxNo = cntcPsonFaxNo;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.dorNodPlnDt = dorNodPlnDt;
		this.poTrspAgmtRtTpCd = poTrspAgmtRtTpCd;
		this.poTrspAgmtOfcCtyCd = poTrspAgmtOfcCtyCd;
		this.mltStopDeFlg = mltStopDeFlg;
		this.wgtUtCd = wgtUtCd;
		this.trspSoCmbTpNm = trspSoCmbTpNm;
		this.woBlNoIssFlg = woBlNoIssFlg;
		this.trspSoTpCd = trspSoTpCd;
		this.revCurrCd = revCurrCd;
		this.woRmk = woRmk;
		this.defaultSpFlg = defaultSpFlg;
		this.trspDfltVndrFlg = trspDfltVndrFlg;
		this.trspWoSeq = trspWoSeq;
		this.fdrVvd = fdrVvd;
		this.surchargeKey = surchargeKey;
		this.poCustSeq = poCustSeq;
		this.cntcPsonPhnNo = cntcPsonPhnNo;
		this.cntrLbsWgt = cntrLbsWgt;
		this.soCreDt = soCreDt;
		this.poSpType = poSpType;
		this.bkgspe = bkgspe;
		this.costActGrpCd = costActGrpCd;
		this.vndrSeq = vndrSeq;
		this.wgtMeasUtCd = wgtMeasUtCd;
		this.trspSoOfcCtyCdSeq = trspSoOfcCtyCdSeq;
		this.troCfmOfcCd = troCfmOfcCd;
		this.currCd = currCd;
		this.poRtnMsg = poRtnMsg;
		this.refId = refId;
		this.creDt = creDt;
		this.toYardValue = toYardValue;
		this.trspRqstBkgFlg = trspRqstBkgFlg;
		this.lane = lane;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.n3ptyBzcCurrCd = n3ptyBzcCurrCd;
		this.poCustCntCd = poCustCntCd;
		this.ibflag = ibflag;
		this.poCustCntCdSeq = poCustCntCdSeq;
		this.eqNo = eqNo;
		this.usrNm = usrNm;
		this.dorYardValue = dorYardValue;
		this.woEdiUseFlg = woEdiUseFlg;
		this.cntcPsonNm = cntcPsonNm;
		this.creOfcCd = creOfcCd;
		this.moreCandidates = moreCandidates;
		this.spclInstrRmk = spclInstrRmk;
		this.revenue = revenue;
		this.presetVndrSeq = presetVndrSeq;
		this.updDt = updDt;
		this.etcAddAmt = etcAddAmt;
		this.woTotAmtUsd = woTotAmtUsd;
		this.cngCateSubCd = cngCateSubCd;
		this.trspBndCd = trspBndCd;
		this.poWayType = poWayType;
		this.troSeq = troSeq;
		this.dorNodPlnTm = dorNodPlnTm;
		this.custSeq = custSeq;
		this.spType = spType;
		this.troCfmUpdDt = troCfmUpdDt;
		this.poRtnCd = poRtnCd;
		this.bkgTroNo = bkgTroNo;
		this.previousVal = previousVal;
		this.rejectedCheck = rejectedCheck;
		this.obVvdCd = obVvdCd;
		this.poLocalCurrCd = poLocalCurrCd;
		this.ntfyCustNm = ntfyCustNm;
		this.dorLocValue = dorLocValue;
		this.trspSoCmbSeq = trspSoCmbSeq;
		this.trspWoOfcCtyCdSeq = trspWoOfcCtyCdSeq;
		this.custNomiTrkrFlg = custNomiTrkrFlg;
		this.eccCd = eccCd;
		this.cngIndFlg = cngIndFlg;
		this.rCct = rCct;
		this.tCct = tCct;
		this.kgsNetWgt = kgsNetWgt;
		this.kgsTareWgt = kgsTareWgt;
		this.kgsGrossWgt = kgsGrossWgt;
		this.lbsNetWgt = lbsNetWgt;
		this.lbsTareWgt = lbsTareWgt;
		this.lbsGrossWgt = lbsGrossWgt;
		this.cngIndFlgImg = cngIndFlgImg;
		this.vndrCm = vndrCm;
		this.vndrCmImg = vndrCmImg;
		this.cnmvStsCd = cnmvStsCd;
		this.crntYdCd = crntYdCd;
		this.cnmvDt = cnmvDt;
		this.copFlg = copFlg;
		this.copEqNo = copEqNo;
		this.interRmkImg = interRmkImg;
		this.cgoFrtRcvIndFlg = cgoFrtRcvIndFlg;
		this.cgoOblRcvIndFlg = cgoOblRcvIndFlg;
		this.cgoCstmsClrIndFlg = cgoCstmsClrIndFlg;
		this.cntrPkupNo = cntrPkupNo;
		this.foFlg = foFlg;
		this.bkgStsCd = bkgStsCd;
		this.bkgStsCdNm = bkgStsCdNm;
		this.pwrSplCblFlg = pwrSplCblFlg;
		this.cntrSltNo = cntrSltNo;
		this.rvnMptCntr = rvnMptCntr;
		this.doHldFlg = doHldFlg;
		this.fmNodCdNm = fmNodCdNm;
		this.viaNodCdNm = viaNodCdNm;
		this.toNodCdNm = toNodCdNm;
		this.dorNodCdNm = dorNodCdNm;
		this.porCdNm = porCdNm;
		this.polCdNm = polCdNm;
		this.podCdNm = podCdNm;
		this.delCdNm = delCdNm;
		this.contiCd = contiCd;
		this.scgIndCd = scgIndCd;
		this.vgmKgsWgt = vgmKgsWgt;
		this.vgmLbsWgt = vgmLbsWgt;
		this.ibcheck = ibcheck;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("ib_vvd_cd", getIbVvdCd());
		this.hashColumns.put("n3pty_bzc_tp_cd", getN3ptyBzcTpCd());
		this.hashColumns.put("tro_cfm_upd_tm", getTroCfmUpdTm());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("po_local_curr_tot_amt", getPoLocalCurrTotAmt());
		this.hashColumns.put("cng_cate_cd", getCngCateCd());
		this.hashColumns.put("trsp_agmt_rt_tp_nm", getTrspAgmtRtTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3pty_bzc_cust_seq", getN3ptyBzcCustSeq());
		this.hashColumns.put("dor_pst_cd", getDorPstCd());
		this.hashColumns.put("po_fuel_scg_rt", getPoFuelScgRt());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("trsp_frst_flg", getTrspFrstFlg());
		this.hashColumns.put("trsp_so_tp_nm", getTrspSoTpNm());
		this.hashColumns.put("po_usd_curr_tot_amt", getPoUsdCurrTotAmt());
		this.hashColumns.put("wo_issued", getWoIssued());
		this.hashColumns.put("now_read_val", getNowReadVal());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("po_cust_nomi_trkr_flg", getPoCustNomiTrkrFlg());
		this.hashColumns.put("cgo_tp_nm", getCgoTpNm());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("trsp_so_cmb_tp_cd", getTrspSoCmbTpCd());
		this.hashColumns.put("tro_cfm_usr_id", getTroCfmUsrId());
		this.hashColumns.put("mty_rr_flg", getMtyRrFlg());
		this.hashColumns.put("trsp_cost_dtl_mod_nm", getTrspCostDtlModNm());
		this.hashColumns.put("po_basic_rt", getPoBasicRt());
		this.hashColumns.put("wo_rjct_dt", getWoRjctDt());
		this.hashColumns.put("act_cust_cd", getActCustCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("nego_amt", getNegoAmt());
		this.hashColumns.put("wo_tot_amt", getWoTotAmt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("n3pty_bzc_desc", getN3ptyBzcDesc());
		this.hashColumns.put("fctry_nm", getFctryNm());
		this.hashColumns.put("locl_upd_dt", getLoclUpdDt());
		this.hashColumns.put("cancel_check", getCancelCheck());
		this.hashColumns.put("wo_iss_sts_cd", getWoIssStsCd());
		this.hashColumns.put("distance", getDistance());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("po_trsp_agmt_rt_tp_nm", getPoTrspAgmtRtTpNm());
		this.hashColumns.put("n3pty_bzc_cust_cnt_cd", getN3ptyBzcCustCntCd());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("fm_yard_value", getFmYardValue());
		this.hashColumns.put("fm_loc_value", getFmLocValue());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("via_yard_value", getViaYardValue());
		this.hashColumns.put("shpr_cust_nm", getShprCustNm());
		this.hashColumns.put("trsp_agmt_wy_tp_cd", getTrspAgmtWyTpCd());
		this.hashColumns.put("trsp_rjct_rsn_cd", getTrspRjctRsnCd());
		this.hashColumns.put("po_over_wgt_scg_rt", getPoOverWgtScgRt());
		this.hashColumns.put("lst_nod_pln_dt", getLstNodPlnDt());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("fuel_scg_amt", getFuelScgAmt());
		this.hashColumns.put("n3pty_bzc_ofc_cd", getN3ptyBzcOfcCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cust_cnt_cd_seq", getCustCntCdSeq());
		this.hashColumns.put("n3pty_bil_flg", getN3ptyBilFlg());
		this.hashColumns.put("to_loc_value", getToLocValue());
		this.hashColumns.put("distance_uom", getDistanceUom());
		this.hashColumns.put("wo_cre_nm", getWoCreNm());
		this.hashColumns.put("via_loc_value", getViaLocValue());
		this.hashColumns.put("cnee_cust_nm", getCneeCustNm());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("wo_rjct_indct", getWoRjctIndct());
		this.hashColumns.put("n1st_nod_pln_dt", getN1stNodPlnDt());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("n3pty_bzc_amt", getN3ptyBzcAmt());
		this.hashColumns.put("n1st_nod_pln_tm", getN1stNodPlnTm());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("cntr_kgs_wgt", getCntrKgsWgt());
		this.hashColumns.put("col_nm", getColNm());
		this.hashColumns.put("tro_cnfm", getTroCnfm());
		this.hashColumns.put("dtn_use_flg", getDtnUseFlg());
		this.hashColumns.put("trsp_crr_mod_nm", getTrspCrrModNm());
		this.hashColumns.put("bundling_no", getBundlingNo());
		this.hashColumns.put("n3pty_bzc_vndr_seq", getN3ptyBzcVndrSeq());
		this.hashColumns.put("trs_sub_sts_cd", getTrsSubStsCd());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("dor_de_addr", getDorDeAddr());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("wo_issue_dt", getWoIssueDt());
		this.hashColumns.put("so_cre_nm", getSoCreNm());
		this.hashColumns.put("lst_nod_pln_tm", getLstNodPlnTm());
		this.hashColumns.put("po_trsp_agmt_seq", getPoTrspAgmtSeq());
		this.hashColumns.put("spcl_cgo_cntr_tp_cd", getSpclCgoCntrTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("trsp_agmt_rt_tp_cd", getTrspAgmtRtTpCd());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("cntc_pson_fax_no", getCntcPsonFaxNo());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("dor_nod_pln_dt", getDorNodPlnDt());
		this.hashColumns.put("po_trsp_agmt_rt_tp_cd", getPoTrspAgmtRtTpCd());
		this.hashColumns.put("po_trsp_agmt_ofc_cty_cd", getPoTrspAgmtOfcCtyCd());
		this.hashColumns.put("mlt_stop_de_flg", getMltStopDeFlg());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("trsp_so_cmb_tp_nm", getTrspSoCmbTpNm());
		this.hashColumns.put("wo_bl_no_iss_flg", getWoBlNoIssFlg());
		this.hashColumns.put("trsp_so_tp_cd", getTrspSoTpCd());
		this.hashColumns.put("rev_curr_cd", getRevCurrCd());
		this.hashColumns.put("wo_rmk", getWoRmk());
		this.hashColumns.put("default_sp_flg", getDefaultSpFlg());
		this.hashColumns.put("trsp_dflt_vndr_flg", getTrspDfltVndrFlg());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("fdr_vvd", getFdrVvd());
		this.hashColumns.put("surcharge_key", getSurchargeKey());
		this.hashColumns.put("po_cust_seq", getPoCustSeq());
		this.hashColumns.put("cntc_pson_phn_no", getCntcPsonPhnNo());
		this.hashColumns.put("cntr_lbs_wgt", getCntrLbsWgt());
		this.hashColumns.put("so_cre_dt", getSoCreDt());
		this.hashColumns.put("po_sp_type", getPoSpType());
		this.hashColumns.put("bkgspe", getBkgspe());
		this.hashColumns.put("cost_act_grp_cd", getCostActGrpCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("wgt_meas_ut_cd", getWgtMeasUtCd());
		this.hashColumns.put("trsp_so_ofc_cty_cd_seq", getTrspSoOfcCtyCdSeq());
		this.hashColumns.put("tro_cfm_ofc_cd", getTroCfmOfcCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("po_rtn_msg", getPoRtnMsg());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("to_yard_value", getToYardValue());
		this.hashColumns.put("trsp_rqst_bkg_flg", getTrspRqstBkgFlg());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("n3pty_bzc_curr_cd", getN3ptyBzcCurrCd());
		this.hashColumns.put("po_cust_cnt_cd", getPoCustCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("po_cust_cnt_cd_seq", getPoCustCntCdSeq());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("dor_yard_value", getDorYardValue());
		this.hashColumns.put("wo_edi_use_flg", getWoEdiUseFlg());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("more_candidates", getMoreCandidates());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("revenue", getRevenue());
		this.hashColumns.put("preset_vndr_seq", getPresetVndrSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("etc_add_amt", getEtcAddAmt());
		this.hashColumns.put("wo_tot_amt_usd", getWoTotAmtUsd());
		this.hashColumns.put("cng_cate_sub_cd", getCngCateSubCd());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("po_way_type", getPoWayType());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("dor_nod_pln_tm", getDorNodPlnTm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("sp_type", getSpType());
		this.hashColumns.put("tro_cfm_upd_dt", getTroCfmUpdDt());
		this.hashColumns.put("po_rtn_cd", getPoRtnCd());
		this.hashColumns.put("bkg_tro_no", getBkgTroNo());
		this.hashColumns.put("previous_val", getPreviousVal());
		this.hashColumns.put("rejected_check", getRejectedCheck());
		this.hashColumns.put("ob_vvd_cd", getObVvdCd());
		this.hashColumns.put("po_local_curr_cd", getPoLocalCurrCd());
		this.hashColumns.put("ntfy_cust_nm", getNtfyCustNm());
		this.hashColumns.put("dor_loc_value", getDorLocValue());
		this.hashColumns.put("trsp_so_cmb_seq", getTrspSoCmbSeq());
		this.hashColumns.put("trsp_wo_ofc_cty_cd_seq", getTrspWoOfcCtyCdSeq());
		this.hashColumns.put("cust_nomi_trkr_flg", getCustNomiTrkrFlg());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("cng_ind_flg", getCngIndFlg());
		this.hashColumns.put("r_cct", getrCct());
		this.hashColumns.put("t_cct", gettCct());
		this.hashColumns.put("kgs_net_wgt", getKgsNetWgt());
		this.hashColumns.put("kgs_tare_wgt", getKgsTareWgt());
		this.hashColumns.put("kgs_gross_wgt", getKgsGrossWgt());
		this.hashColumns.put("lbs_net_wgt", getLbsNetWgt());
		this.hashColumns.put("lbs_tare_wgt", getLbsTareWgt());
		this.hashColumns.put("lbs_gross_wgt", getLbsGrossWgt());
		this.hashColumns.put("cng_ind_flg_img", getCngIndFlgImg());
		this.hashColumns.put("vndr_cm", getVndrCm());
		this.hashColumns.put("vndr_cm_img", getVndrCmImg());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("cop_flg", getCopFlg());
		this.hashColumns.put("cop_eq_no", getCopEqNo());
		this.hashColumns.put("inter_rmk_img", getInterRmkImg());
		this.hashColumns.put("cgo_frt_rcv_ind_flg", getCgoFrtRcvIndFlg());
		this.hashColumns.put("cgo_obl_rcv_ind_flg", getCgoOblRcvIndFlg());
		this.hashColumns.put("cgo_cstms_clr_ind_flg", getCgoCstmsClrIndFlg());
		this.hashColumns.put("cntr_pkup_no", getCntrPkupNo());
		this.hashColumns.put("fo_flg", getFoFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bkg_sts_cd_nm", getBkgStsCdNm());
		this.hashColumns.put("pwr_spl_cbl_flg", getPwrSplCblFlg());
		this.hashColumns.put("cntr_slt_no", getCntrSltNo());
		this.hashColumns.put("rvn_mpt_cntr", getRvnMptCntr());
		this.hashColumns.put("do_hld_flg", getDoHldFlg());
		this.hashColumns.put("fm_nod_cd_nm", getFmNodCdNm());
		this.hashColumns.put("via_nod_cd_nm", getViaNodCdNm());
		this.hashColumns.put("to_nod_cd_nm", getToNodCdNm());
		this.hashColumns.put("dor_nod_cd_nm", getDorNodCdNm());
		this.hashColumns.put("por_cd_nm", getPorCdNm());
		this.hashColumns.put("pol_cd_nm", getPolCdNm());
		this.hashColumns.put("pod_cd_nm", getPodCdNm());
		this.hashColumns.put("del_cd_nm", getDelCdNm());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("scg_ind_cd", getScgIndCd());
		this.hashColumns.put("vgm_kgs_wgt", getVgmKgsWgt());
		this.hashColumns.put("vgm_lbs_wgt", getVgmLbsWgt());
		this.hashColumns.put("ibcheck", getIbcheck());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("ib_vvd_cd", "ibVvdCd");
		this.hashFields.put("n3pty_bzc_tp_cd", "n3ptyBzcTpCd");
		this.hashFields.put("tro_cfm_upd_tm", "troCfmUpdTm");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("po_local_curr_tot_amt", "poLocalCurrTotAmt");
		this.hashFields.put("cng_cate_cd", "cngCateCd");
		this.hashFields.put("trsp_agmt_rt_tp_nm", "trspAgmtRtTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_bzc_cust_seq", "n3ptyBzcCustSeq");
		this.hashFields.put("dor_pst_cd", "dorPstCd");
		this.hashFields.put("po_fuel_scg_rt", "poFuelScgRt");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("trsp_frst_flg", "trspFrstFlg");
		this.hashFields.put("trsp_so_tp_nm", "trspSoTpNm");
		this.hashFields.put("po_usd_curr_tot_amt", "poUsdCurrTotAmt");
		this.hashFields.put("wo_issued", "woIssued");
		this.hashFields.put("now_read_val", "nowReadVal");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("po_cust_nomi_trkr_flg", "poCustNomiTrkrFlg");
		this.hashFields.put("cgo_tp_nm", "cgoTpNm");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("trsp_so_cmb_tp_cd", "trspSoCmbTpCd");
		this.hashFields.put("tro_cfm_usr_id", "troCfmUsrId");
		this.hashFields.put("mty_rr_flg", "mtyRrFlg");
		this.hashFields.put("trsp_cost_dtl_mod_nm", "trspCostDtlModNm");
		this.hashFields.put("po_basic_rt", "poBasicRt");
		this.hashFields.put("wo_rjct_dt", "woRjctDt");
		this.hashFields.put("act_cust_cd", "actCustCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("nego_amt", "negoAmt");
		this.hashFields.put("wo_tot_amt", "woTotAmt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("n3pty_bzc_desc", "n3ptyBzcDesc");
		this.hashFields.put("fctry_nm", "fctryNm");
		this.hashFields.put("locl_upd_dt", "loclUpdDt");
		this.hashFields.put("cancel_check", "cancelCheck");
		this.hashFields.put("wo_iss_sts_cd", "woIssStsCd");
		this.hashFields.put("distance", "distance");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("po_trsp_agmt_rt_tp_nm", "poTrspAgmtRtTpNm");
		this.hashFields.put("n3pty_bzc_cust_cnt_cd", "n3ptyBzcCustCntCd");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("fm_yard_value", "fmYardValue");
		this.hashFields.put("fm_loc_value", "fmLocValue");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("via_yard_value", "viaYardValue");
		this.hashFields.put("shpr_cust_nm", "shprCustNm");
		this.hashFields.put("trsp_agmt_wy_tp_cd", "trspAgmtWyTpCd");
		this.hashFields.put("trsp_rjct_rsn_cd", "trspRjctRsnCd");
		this.hashFields.put("po_over_wgt_scg_rt", "poOverWgtScgRt");
		this.hashFields.put("lst_nod_pln_dt", "lstNodPlnDt");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("fuel_scg_amt", "fuelScgAmt");
		this.hashFields.put("n3pty_bzc_ofc_cd", "n3ptyBzcOfcCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cust_cnt_cd_seq", "custCntCdSeq");
		this.hashFields.put("n3pty_bil_flg", "n3ptyBilFlg");
		this.hashFields.put("to_loc_value", "toLocValue");
		this.hashFields.put("distance_uom", "distanceUom");
		this.hashFields.put("wo_cre_nm", "woCreNm");
		this.hashFields.put("via_loc_value", "viaLocValue");
		this.hashFields.put("cnee_cust_nm", "cneeCustNm");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("wo_rjct_indct", "woRjctIndct");
		this.hashFields.put("n1st_nod_pln_dt", "n1stNodPlnDt");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("n3pty_bzc_amt", "n3ptyBzcAmt");
		this.hashFields.put("n1st_nod_pln_tm", "n1stNodPlnTm");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("cntr_kgs_wgt", "cntrKgsWgt");
		this.hashFields.put("col_nm", "colNm");
		this.hashFields.put("tro_cnfm", "troCnfm");
		this.hashFields.put("dtn_use_flg", "dtnUseFlg");
		this.hashFields.put("trsp_crr_mod_nm", "trspCrrModNm");
		this.hashFields.put("bundling_no", "bundlingNo");
		this.hashFields.put("n3pty_bzc_vndr_seq", "n3ptyBzcVndrSeq");
		this.hashFields.put("trs_sub_sts_cd", "trsSubStsCd");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("dor_de_addr", "dorDeAddr");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("wo_issue_dt", "woIssueDt");
		this.hashFields.put("so_cre_nm", "soCreNm");
		this.hashFields.put("lst_nod_pln_tm", "lstNodPlnTm");
		this.hashFields.put("po_trsp_agmt_seq", "poTrspAgmtSeq");
		this.hashFields.put("spcl_cgo_cntr_tp_cd", "spclCgoCntrTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("trsp_agmt_rt_tp_cd", "trspAgmtRtTpCd");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("cntc_pson_fax_no", "cntcPsonFaxNo");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("dor_nod_pln_dt", "dorNodPlnDt");
		this.hashFields.put("po_trsp_agmt_rt_tp_cd", "poTrspAgmtRtTpCd");
		this.hashFields.put("po_trsp_agmt_ofc_cty_cd", "poTrspAgmtOfcCtyCd");
		this.hashFields.put("mlt_stop_de_flg", "mltStopDeFlg");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("trsp_so_cmb_tp_nm", "trspSoCmbTpNm");
		this.hashFields.put("wo_bl_no_iss_flg", "woBlNoIssFlg");
		this.hashFields.put("trsp_so_tp_cd", "trspSoTpCd");
		this.hashFields.put("rev_curr_cd", "revCurrCd");
		this.hashFields.put("wo_rmk", "woRmk");
		this.hashFields.put("default_sp_flg", "defaultSpFlg");
		this.hashFields.put("trsp_dflt_vndr_flg", "trspDfltVndrFlg");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("fdr_vvd", "fdrVvd");
		this.hashFields.put("surcharge_key", "surchargeKey");
		this.hashFields.put("po_cust_seq", "poCustSeq");
		this.hashFields.put("cntc_pson_phn_no", "cntcPsonPhnNo");
		this.hashFields.put("cntr_lbs_wgt", "cntrLbsWgt");
		this.hashFields.put("so_cre_dt", "soCreDt");
		this.hashFields.put("po_sp_type", "poSpType");
		this.hashFields.put("bkgspe", "bkgspe");
		this.hashFields.put("cost_act_grp_cd", "costActGrpCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("wgt_meas_ut_cd", "wgtMeasUtCd");
		this.hashFields.put("trsp_so_ofc_cty_cd_seq", "trspSoOfcCtyCdSeq");
		this.hashFields.put("tro_cfm_ofc_cd", "troCfmOfcCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("po_rtn_msg", "poRtnMsg");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("to_yard_value", "toYardValue");
		this.hashFields.put("trsp_rqst_bkg_flg", "trspRqstBkgFlg");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("n3pty_bzc_curr_cd", "n3ptyBzcCurrCd");
		this.hashFields.put("po_cust_cnt_cd", "poCustCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("po_cust_cnt_cd_seq", "poCustCntCdSeq");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("dor_yard_value", "dorYardValue");
		this.hashFields.put("wo_edi_use_flg", "woEdiUseFlg");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("more_candidates", "moreCandidates");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("revenue", "revenue");
		this.hashFields.put("preset_vndr_seq", "presetVndrSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("etc_add_amt", "etcAddAmt");
		this.hashFields.put("wo_tot_amt_usd", "woTotAmtUsd");
		this.hashFields.put("cng_cate_sub_cd", "cngCateSubCd");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("po_way_type", "poWayType");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("dor_nod_pln_tm", "dorNodPlnTm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("sp_type", "spType");
		this.hashFields.put("tro_cfm_upd_dt", "troCfmUpdDt");
		this.hashFields.put("po_rtn_cd", "poRtnCd");
		this.hashFields.put("bkg_tro_no", "bkgTroNo");
		this.hashFields.put("previous_val", "previousVal");
		this.hashFields.put("rejected_check", "rejectedCheck");
		this.hashFields.put("ob_vvd_cd", "obVvdCd");
		this.hashFields.put("po_local_curr_cd", "poLocalCurrCd");
		this.hashFields.put("ntfy_cust_nm", "ntfyCustNm");
		this.hashFields.put("dor_loc_value", "dorLocValue");
		this.hashFields.put("trsp_so_cmb_seq", "trspSoCmbSeq");
		this.hashFields.put("trsp_wo_ofc_cty_cd_seq", "trspWoOfcCtyCdSeq");
		this.hashFields.put("cust_nomi_trkr_flg", "custNomiTrkrFlg");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("cng_ind_flg", "cngIndFlg");
		this.hashFields.put("r_cct", "rCct");
		this.hashFields.put("t_cct", "tCct");
		this.hashFields.put("kgs_net_wgt", "kgsNetWgt");
		this.hashFields.put("kgs_tare_wgt", "kgsTareWgt");
		this.hashFields.put("kgs_gross_wgt", "kgsGrossWgt");
		this.hashFields.put("lbs_net_wgt", "lbsNetWgt");
		this.hashFields.put("lbs_tare_wgt", "lbsTareWgt");
		this.hashFields.put("lbs_gross_wgt", "lbsGrossWgt");
		this.hashFields.put("cng_ind_flg_img", "cngIndFlgImg");
		this.hashFields.put("vndr_cm", "vndrCm");
		this.hashFields.put("vndr_cm_img", "vndrCmImg");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("cop_flg", "copFlg");
		this.hashFields.put("cop_eq_no", "copEqNo");
		this.hashFields.put("inter_rmk_img", "interRmkImg");
		this.hashFields.put("cgo_frt_rcv_ind_flg", "cgoFrtRcvIndFlg");
		this.hashFields.put("cgo_obl_rcv_ind_flg", "cgoOblRcvIndFlg");
		this.hashFields.put("cgo_cstms_clr_ind_flg", "cgoCstmsClrIndFlg");
		this.hashFields.put("cntr_pkup_no", "cntrPkupNo");
		this.hashFields.put("fo_flg", "foFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bkg_sts_cd_nm", "bkgStsCdNm");
		this.hashFields.put("pwr_spl_cbl_flg", "pwrSplCblFlg");
		this.hashFields.put("cntr_slt_no", "cntrSltNo");
		this.hashFields.put("rvn_mpt_cntr", "rvnMptCntr");
		this.hashFields.put("do_hld_flg", "doHldFlg");
		this.hashFields.put("fm_nod_cd_nm", "fmNodCdNm");
		this.hashFields.put("via_nod_cd_nm", "viaNodCdNm");
		this.hashFields.put("to_nod_cd_nm", "toNodCdNm");
		this.hashFields.put("dor_nod_cd_nm", "dorNodCdNm");
		this.hashFields.put("por_cd_nm", "porCdNm");
		this.hashFields.put("pol_cd_nm", "polCdNm");
		this.hashFields.put("pod_cd_nm", "podCdNm");
		this.hashFields.put("del_cd_nm", "delCdNm");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("scg_ind_cd", "scgIndCd");
		this.hashFields.put("vgm_kgs_wgt", "vgmKgsWgt");
		this.hashFields.put("vgm_lbs_wgt", "vgmLbsWgt");
		this.hashFields.put("ibcheck", "ibcheck");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ibVvdCd
	 */
	public String getIbVvdCd() {
		return this.ibVvdCd;
	}

	/**
	 * Column Info
	 * @return n3ptyBzcTpCd
	 */
	public String getN3ptyBzcTpCd() {
		return this.n3ptyBzcTpCd;
	}

	/**
	 * Column Info
	 * @return troCfmUpdTm
	 */
	public String getTroCfmUpdTm() {
		return this.troCfmUpdTm;
	}

	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}

	/**
	 * Column Info
	 * @return poLocalCurrTotAmt
	 */
	public String getPoLocalCurrTotAmt() {
		return this.poLocalCurrTotAmt;
	}

	/**
	 * Column Info
	 * @return cngCateCd
	 */
	public String getCngCateCd() {
		return this.cngCateCd;
	}

	/**
	 * Column Info
	 * @return trspAgmtRtTpNm
	 */
	public String getTrspAgmtRtTpNm() {
		return this.trspAgmtRtTpNm;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * @return n3ptyBzcCustSeq
	 */
	public String getN3ptyBzcCustSeq() {
		return this.n3ptyBzcCustSeq;
	}

	/**
	 * Column Info
	 * @return dorPstCd
	 */
	public String getDorPstCd() {
		return this.dorPstCd;
	}

	/**
	 * Column Info
	 * @return poFuelScgRt
	 */
	public String getPoFuelScgRt() {
		return this.poFuelScgRt;
	}

	/**
	 * Column Info
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}

	/**
	 * Column Info
	 * @return trspFrstFlg
	 */
	public String getTrspFrstFlg() {
		return this.trspFrstFlg;
	}

	/**
	 * Column Info
	 * @return trspSoTpNm
	 */
	public String getTrspSoTpNm() {
		return this.trspSoTpNm;
	}

	/**
	 * Column Info
	 * @return poUsdCurrTotAmt
	 */
	public String getPoUsdCurrTotAmt() {
		return this.poUsdCurrTotAmt;
	}

	/**
	 * Column Info
	 * @return woIssued
	 */
	public String getWoIssued() {
		return this.woIssued;
	}

	/**
	 * Column Info
	 * @return nowReadVal
	 */
	public String getNowReadVal() {
		return this.nowReadVal;
	}

	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}

	/**
	 * Column Info
	 * @return poCustNomiTrkrFlg
	 */
	public String getPoCustNomiTrkrFlg() {
		return this.poCustNomiTrkrFlg;
	}

	/**
	 * Column Info
	 * @return cgoTpNm
	 */
	public String getCgoTpNm() {
		return this.cgoTpNm;
	}

	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}

	/**
	 * Column Info
	 * @return trspSoCmbTpCd
	 */
	public String getTrspSoCmbTpCd() {
		return this.trspSoCmbTpCd;
	}

	/**
	 * Column Info
	 * @return troCfmUsrId
	 */
	public String getTroCfmUsrId() {
		return this.troCfmUsrId;
	}

	/**
	 * Column Info
	 * @return mtyRrFlg
	 */
	public String getMtyRrFlg() {
		return this.mtyRrFlg;
	}

	/**
	 * Column Info
	 * @return trspCostDtlModNm
	 */
	public String getTrspCostDtlModNm() {
		return this.trspCostDtlModNm;
	}

	/**
	 * Column Info
	 * @return poBasicRt
	 */
	public String getPoBasicRt() {
		return this.poBasicRt;
	}

	/**
	 * Column Info
	 * @return woRjctDt
	 */
	public String getWoRjctDt() {
		return this.woRjctDt;
	}

	/**
	 * Column Info
	 * @return actCustCd
	 */
	public String getActCustCd() {
		return this.actCustCd;
	}

	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}

	/**
	 * Column Info
	 * @return negoAmt
	 */
	public String getNegoAmt() {
		return this.negoAmt;
	}

	/**
	 * Column Info
	 * @return woTotAmt
	 */
	public String getWoTotAmt() {
		return this.woTotAmt;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return n3ptyBzcDesc
	 */
	public String getN3ptyBzcDesc() {
		return this.n3ptyBzcDesc;
	}

	/**
	 * Column Info
	 * @return fctryNm
	 */
	public String getFctryNm() {
		return this.fctryNm;
	}

	/**
	 * Column Info
	 * @return loclUpdDt
	 */
	public String getLoclUpdDt() {
		return this.loclUpdDt;
	}

	/**
	 * Column Info
	 * @return cancelCheck
	 */
	public String getCancelCheck() {
		return this.cancelCheck;
	}

	/**
	 * Column Info
	 * @return woIssStsCd
	 */
	public String getWoIssStsCd() {
		return this.woIssStsCd;
	}

	/**
	 * Column Info
	 * @return distance
	 */
	public String getDistance() {
		return this.distance;
	}

	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}

	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}

	/**
	 * Column Info
	 * @return poTrspAgmtRtTpNm
	 */
	public String getPoTrspAgmtRtTpNm() {
		return this.poTrspAgmtRtTpNm;
	}

	/**
	 * Column Info
	 * @return n3ptyBzcCustCntCd
	 */
	public String getN3ptyBzcCustCntCd() {
		return this.n3ptyBzcCustCntCd;
	}

	/**
	 * Column Info
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
	}

	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}

	/**
	 * Column Info
	 * @return fmYardValue
	 */
	public String getFmYardValue() {
		return this.fmYardValue;
	}

	/**
	 * Column Info
	 * @return fmLocValue
	 */
	public String getFmLocValue() {
		return this.fmLocValue;
	}

	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}

	/**
	 * Column Info
	 * @return viaYardValue
	 */
	public String getViaYardValue() {
		return this.viaYardValue;
	}

	/**
	 * Column Info
	 * @return shprCustNm
	 */
	public String getShprCustNm() {
		return this.shprCustNm;
	}

	/**
	 * Column Info
	 * @return trspAgmtWyTpCd
	 */
	public String getTrspAgmtWyTpCd() {
		return this.trspAgmtWyTpCd;
	}

	/**
	 * Column Info
	 * @return trspRjctRsnCd
	 */
	public String getTrspRjctRsnCd() {
		return this.trspRjctRsnCd;
	}

	/**
	 * Column Info
	 * @return poOverWgtScgRt
	 */
	public String getPoOverWgtScgRt() {
		return this.poOverWgtScgRt;
	}

	/**
	 * Column Info
	 * @return lstNodPlnDt
	 */
	public String getLstNodPlnDt() {
		return this.lstNodPlnDt;
	}

	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}

	/**
	 * Column Info
	 * @return bzcAmt
	 */
	public String getBzcAmt() {
		return this.bzcAmt;
	}

	/**
	 * Column Info
	 * @return trspWoOfcCtyCd
	 */
	public String getTrspWoOfcCtyCd() {
		return this.trspWoOfcCtyCd;
	}

	/**
	 * Column Info
	 * @return fuelScgAmt
	 */
	public String getFuelScgAmt() {
		return this.fuelScgAmt;
	}

	/**
	 * Column Info
	 * @return n3ptyBzcOfcCd
	 */
	public String getN3ptyBzcOfcCd() {
		return this.n3ptyBzcOfcCd;
	}

	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}

	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}

	/**
	 * Column Info
	 * @return custCntCdSeq
	 */
	public String getCustCntCdSeq() {
		return this.custCntCdSeq;
	}

	/**
	 * Column Info
	 * @return n3ptyBilFlg
	 */
	public String getN3ptyBilFlg() {
		return this.n3ptyBilFlg;
	}

	/**
	 * Column Info
	 * @return toLocValue
	 */
	public String getToLocValue() {
		return this.toLocValue;
	}

	/**
	 * Column Info
	 * @return distanceUom
	 */
	public String getDistanceUom() {
		return this.distanceUom;
	}

	/**
	 * Column Info
	 * @return woCreNm
	 */
	public String getWoCreNm() {
		return this.woCreNm;
	}

	/**
	 * Column Info
	 * @return viaLocValue
	 */
	public String getViaLocValue() {
		return this.viaLocValue;
	}

	/**
	 * Column Info
	 * @return cneeCustNm
	 */
	public String getCneeCustNm() {
		return this.cneeCustNm;
	}

	/**
	 * Column Info
	 * @return costActGrpSeq
	 */
	public String getCostActGrpSeq() {
		return this.costActGrpSeq;
	}

	/**
	 * Column Info
	 * @return woRjctIndct
	 */
	public String getWoRjctIndct() {
		return this.woRjctIndct;
	}

	/**
	 * Column Info
	 * @return n1stNodPlnDt
	 */
	public String getN1stNodPlnDt() {
		return this.n1stNodPlnDt;
	}

	/**
	 * Column Info
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}

	/**
	 * Column Info
	 * @return n3ptyBzcAmt
	 */
	public String getN3ptyBzcAmt() {
		return this.n3ptyBzcAmt;
	}

	/**
	 * Column Info
	 * @return n1stNodPlnTm
	 */
	public String getN1stNodPlnTm() {
		return this.n1stNodPlnTm;
	}

	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}

	/**
	 * Column Info
	 * @return cntrKgsWgt
	 */
	public String getCntrKgsWgt() {
		return this.cntrKgsWgt;
	}

	/**
	 * Column Info
	 * @return colNm
	 */
	public String getColNm() {
		return this.colNm;
	}

	/**
	 * Column Info
	 * @return troCnfm
	 */
	public String getTroCnfm() {
		return this.troCnfm;
	}

	/**
	 * Column Info
	 * @return dtnUseFlg
	 */
	public String getDtnUseFlg() {
		return this.dtnUseFlg;
	}

	/**
	 * Column Info
	 * @return trspCrrModNm
	 */
	public String getTrspCrrModNm() {
		return this.trspCrrModNm;
	}

	/**
	 * Column Info
	 * @return bundlingNo
	 */
	public String getBundlingNo() {
		return this.bundlingNo;
	}

	/**
	 * Column Info
	 * @return n3ptyBzcVndrSeq
	 */
	public String getN3ptyBzcVndrSeq() {
		return this.n3ptyBzcVndrSeq;
	}

	/**
	 * Column Info
	 * @return trsSubStsCd
	 */
	public String getTrsSubStsCd() {
		return this.trsSubStsCd;
	}

	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}

	/**
	 * Column Info
	 * @return dorDeAddr
	 */
	public String getDorDeAddr() {
		return this.dorDeAddr;
	}

	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}

	/**
	 * Column Info
	 * @return woIssueDt
	 */
	public String getWoIssueDt() {
		return this.woIssueDt;
	}

	/**
	 * Column Info
	 * @return soCreNm
	 */
	public String getSoCreNm() {
		return this.soCreNm;
	}

	/**
	 * Column Info
	 * @return lstNodPlnTm
	 */
	public String getLstNodPlnTm() {
		return this.lstNodPlnTm;
	}

	/**
	 * Column Info
	 * @return poTrspAgmtSeq
	 */
	public String getPoTrspAgmtSeq() {
		return this.poTrspAgmtSeq;
	}

	/**
	 * Column Info
	 * @return spclCgoCntrTpCd
	 */
	public String getSpclCgoCntrTpCd() {
		return this.spclCgoCntrTpCd;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return trspAgmtRtTpCd
	 */
	public String getTrspAgmtRtTpCd() {
		return this.trspAgmtRtTpCd;
	}

	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}

	/**
	 * Column Info
	 * @return cntcPsonFaxNo
	 */
	public String getCntcPsonFaxNo() {
		return this.cntcPsonFaxNo;
	}

	/**
	 * Column Info
	 * @return trspCostDtlModCd
	 */
	public String getTrspCostDtlModCd() {
		return this.trspCostDtlModCd;
	}

	/**
	 * Column Info
	 * @return dorNodPlnDt
	 */
	public String getDorNodPlnDt() {
		return this.dorNodPlnDt;
	}

	/**
	 * Column Info
	 * @return poTrspAgmtRtTpCd
	 */
	public String getPoTrspAgmtRtTpCd() {
		return this.poTrspAgmtRtTpCd;
	}

	/**
	 * Column Info
	 * @return poTrspAgmtOfcCtyCd
	 */
	public String getPoTrspAgmtOfcCtyCd() {
		return this.poTrspAgmtOfcCtyCd;
	}

	/**
	 * Column Info
	 * @return mltStopDeFlg
	 */
	public String getMltStopDeFlg() {
		return this.mltStopDeFlg;
	}

	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}

	/**
	 * Column Info
	 * @return trspSoCmbTpNm
	 */
	public String getTrspSoCmbTpNm() {
		return this.trspSoCmbTpNm;
	}

	/**
	 * Column Info
	 * @return woBlNoIssFlg
	 */
	public String getWoBlNoIssFlg() {
		return this.woBlNoIssFlg;
	}

	/**
	 * Column Info
	 * @return trspSoTpCd
	 */
	public String getTrspSoTpCd() {
		return this.trspSoTpCd;
	}

	/**
	 * Column Info
	 * @return revCurrCd
	 */
	public String getRevCurrCd() {
		return this.revCurrCd;
	}

	/**
	 * Column Info
	 * @return woRmk
	 */
	public String getWoRmk() {
		return this.woRmk;
	}

	/**
	 * Column Info
	 * @return defaultSpFlg
	 */
	public String getDefaultSpFlg() {
		return this.defaultSpFlg;
	}

	/**
	 * Column Info
	 * @return trspDfltVndrFlg
	 */
	public String getTrspDfltVndrFlg() {
		return this.trspDfltVndrFlg;
	}

	/**
	 * Column Info
	 * @return trspWoSeq
	 */
	public String getTrspWoSeq() {
		return this.trspWoSeq;
	}

	/**
	 * Column Info
	 * @return fdrVvd
	 */
	public String getFdrVvd() {
		return this.fdrVvd;
	}

	/**
	 * Column Info
	 * @return surchargeKey
	 */
	public String getSurchargeKey() {
		return this.surchargeKey;
	}

	/**
	 * Column Info
	 * @return poCustSeq
	 */
	public String getPoCustSeq() {
		return this.poCustSeq;
	}

	/**
	 * Column Info
	 * @return cntcPsonPhnNo
	 */
	public String getCntcPsonPhnNo() {
		return this.cntcPsonPhnNo;
	}

	/**
	 * Column Info
	 * @return cntrLbsWgt
	 */
	public String getCntrLbsWgt() {
		return this.cntrLbsWgt;
	}

	/**
	 * Column Info
	 * @return soCreDt
	 */
	public String getSoCreDt() {
		return this.soCreDt;
	}

	/**
	 * Column Info
	 * @return poSpType
	 */
	public String getPoSpType() {
		return this.poSpType;
	}

	/**
	 * Column Info
	 * @return bkgspe
	 */
	public String getBkgspe() {
		return this.bkgspe;
	}

	/**
	 * Column Info
	 * @return costActGrpCd
	 */
	public String getCostActGrpCd() {
		return this.costActGrpCd;
	}

	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}

	/**
	 * Column Info
	 * @return wgtMeasUtCd
	 */
	public String getWgtMeasUtCd() {
		return this.wgtMeasUtCd;
	}

	/**
	 * Column Info
	 * @return trspSoOfcCtyCdSeq
	 */
	public String getTrspSoOfcCtyCdSeq() {
		return this.trspSoOfcCtyCdSeq;
	}

	/**
	 * Column Info
	 * @return troCfmOfcCd
	 */
	public String getTroCfmOfcCd() {
		return this.troCfmOfcCd;
	}

	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}

	/**
	 * Column Info
	 * @return poRtnMsg
	 */
	public String getPoRtnMsg() {
		return this.poRtnMsg;
	}

	/**
	 * Column Info
	 * @return refId
	 */
	public String getRefId() {
		return this.refId;
	}

	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}

	/**
	 * Column Info
	 * @return toYardValue
	 */
	public String getToYardValue() {
		return this.toYardValue;
	}

	/**
	 * Column Info
	 * @return trspRqstBkgFlg
	 */
	public String getTrspRqstBkgFlg() {
		return this.trspRqstBkgFlg;
	}

	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}

	/**
	 * Column Info
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}

	/**
	 * Column Info
	 * @return n3ptyBzcCurrCd
	 */
	public String getN3ptyBzcCurrCd() {
		return this.n3ptyBzcCurrCd;
	}

	/**
	 * Column Info
	 * @return poCustCntCd
	 */
	public String getPoCustCntCd() {
		return this.poCustCntCd;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * @return poCustCntCdSeq
	 */
	public String getPoCustCntCdSeq() {
		return this.poCustCntCdSeq;
	}

	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}

	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}

	/**
	 * Column Info
	 * @return dorYardValue
	 */
	public String getDorYardValue() {
		return this.dorYardValue;
	}

	/**
	 * Column Info
	 * @return woEdiUseFlg
	 */
	public String getWoEdiUseFlg() {
		return this.woEdiUseFlg;
	}

	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}

	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}

	/**
	 * Column Info
	 * @return moreCandidates
	 */
	public String getMoreCandidates() {
		return this.moreCandidates;
	}

	/**
	 * Column Info
	 * @return spclInstrRmk
	 */
	public String getSpclInstrRmk() {
		return this.spclInstrRmk;
	}

	/**
	 * Column Info
	 * @return revenue
	 */
	public String getRevenue() {
		return this.revenue;
	}

	/**
	 * Column Info
	 * @return presetVndrSeq
	 */
	public String getPresetVndrSeq() {
		return this.presetVndrSeq;
	}

	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * @return etcAddAmt
	 */
	public String getEtcAddAmt() {
		return this.etcAddAmt;
	}

	/**
	 * Column Info
	 * @return woTotAmtUsd
	 */
	public String getWoTotAmtUsd() {
		return this.woTotAmtUsd;
	}

	/**
	 * Column Info
	 * @return cngCateSubCd
	 */
	public String getCngCateSubCd() {
		return this.cngCateSubCd;
	}

	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}

	/**
	 * Column Info
	 * @return poWayType
	 */
	public String getPoWayType() {
		return this.poWayType;
	}

	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
	}

	/**
	 * Column Info
	 * @return dorNodPlnTm
	 */
	public String getDorNodPlnTm() {
		return this.dorNodPlnTm;
	}

	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}

	/**
	 * Column Info
	 * @return spType
	 */
	public String getSpType() {
		return this.spType;
	}

	/**
	 * Column Info
	 * @return troCfmUpdDt
	 */
	public String getTroCfmUpdDt() {
		return this.troCfmUpdDt;
	}

	/**
	 * Column Info
	 * @return poRtnCd
	 */
	public String getPoRtnCd() {
		return this.poRtnCd;
	}

	/**
	 * Column Info
	 * @return bkgTroNo
	 */
	public String getBkgTroNo() {
		return this.bkgTroNo;
	}

	/**
	 * Column Info
	 * @return previousVal
	 */
	public String getPreviousVal() {
		return this.previousVal;
	}

	/**
	 * Column Info
	 * @return rejectedCheck
	 */
	public String getRejectedCheck() {
		return this.rejectedCheck;
	}

	/**
	 * Column Info
	 * @return obVvdCd
	 */
	public String getObVvdCd() {
		return this.obVvdCd;
	}

	/**
	 * Column Info
	 * @return poLocalCurrCd
	 */
	public String getPoLocalCurrCd() {
		return this.poLocalCurrCd;
	}

	/**
	 * Column Info
	 * @return ntfyCustNm
	 */
	public String getNtfyCustNm() {
		return this.ntfyCustNm;
	}

	/**
	 * Column Info
	 * @return dorLocValue
	 */
	public String getDorLocValue() {
		return this.dorLocValue;
	}

	/**
	 * Column Info
	 * @return trspSoCmbSeq
	 */
	public String getTrspSoCmbSeq() {
		return this.trspSoCmbSeq;
	}

	/**
	 * Column Info
	 * @return trspWoOfcCtyCdSeq
	 */
	public String getTrspWoOfcCtyCdSeq() {
		return this.trspWoOfcCtyCdSeq;
	}

	/**
	 * Column Info
	 * @return pwrSplCblFlg
	 */
	public String getPwrSplCblFlg() {
		return pwrSplCblFlg;
	}

	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}

	/**
	 * Column Info
	 * @return custNomiTrkrFlg
	 */
	public String getCustNomiTrkrFlg() {
		return this.custNomiTrkrFlg;
	}

	/**
	 * Column Info
	 * @return cntrSltNo
	 */
	public String getCntrSltNo() {
		return cntrSltNo;
	}

	/**
	 * Column Info
	 * @return doHldFlg
	 */
	public String getDoHldFlg() {
		return doHldFlg;
	}

	/**
	 * Column Info
	 * @param ibVvdCd
	 */
	public void setIbVvdCd(String ibVvdCd) {
		this.ibVvdCd = ibVvdCd;
	}

	/**
	 * Column Info
	 * @param n3ptyBzcTpCd
	 */
	public void setN3ptyBzcTpCd(String n3ptyBzcTpCd) {
		this.n3ptyBzcTpCd = n3ptyBzcTpCd;
	}

	/**
	 * Column Info
	 * @param troCfmUpdTm
	 */
	public void setTroCfmUpdTm(String troCfmUpdTm) {
		this.troCfmUpdTm = troCfmUpdTm;
	}

	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}

	/**
	 * Column Info
	 * @param poLocalCurrTotAmt
	 */
	public void setPoLocalCurrTotAmt(String poLocalCurrTotAmt) {
		this.poLocalCurrTotAmt = poLocalCurrTotAmt;
	}

	/**
	 * Column Info
	 * @param cngCateCd
	 */
	public void setCngCateCd(String cngCateCd) {
		this.cngCateCd = cngCateCd;
	}

	/**
	 * Column Info
	 * @param trspAgmtRtTpNm
	 */
	public void setTrspAgmtRtTpNm(String trspAgmtRtTpNm) {
		this.trspAgmtRtTpNm = trspAgmtRtTpNm;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * @param n3ptyBzcCustSeq
	 */
	public void setN3ptyBzcCustSeq(String n3ptyBzcCustSeq) {
		this.n3ptyBzcCustSeq = n3ptyBzcCustSeq;
	}

	/**
	 * Column Info
	 * @param dorPstCd
	 */
	public void setDorPstCd(String dorPstCd) {
		this.dorPstCd = dorPstCd;
	}

	/**
	 * Column Info
	 * @param poFuelScgRt
	 */
	public void setPoFuelScgRt(String poFuelScgRt) {
		this.poFuelScgRt = poFuelScgRt;
	}

	/**
	 * Column Info
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}

	/**
	 * Column Info
	 * @param trspFrstFlg
	 */
	public void setTrspFrstFlg(String trspFrstFlg) {
		this.trspFrstFlg = trspFrstFlg;
	}

	/**
	 * Column Info
	 * @param trspSoTpNm
	 */
	public void setTrspSoTpNm(String trspSoTpNm) {
		this.trspSoTpNm = trspSoTpNm;
	}

	/**
	 * Column Info
	 * @param poUsdCurrTotAmt
	 */
	public void setPoUsdCurrTotAmt(String poUsdCurrTotAmt) {
		this.poUsdCurrTotAmt = poUsdCurrTotAmt;
	}

	/**
	 * Column Info
	 * @param woIssued
	 */
	public void setWoIssued(String woIssued) {
		this.woIssued = woIssued;
	}

	/**
	 * Column Info
	 * @param nowReadVal
	 */
	public void setNowReadVal(String nowReadVal) {
		this.nowReadVal = nowReadVal;
	}

	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * Column Info
	 * @param poCustNomiTrkrFlg
	 */
	public void setPoCustNomiTrkrFlg(String poCustNomiTrkrFlg) {
		this.poCustNomiTrkrFlg = poCustNomiTrkrFlg;
	}

	/**
	 * Column Info
	 * @param cgoTpNm
	 */
	public void setCgoTpNm(String cgoTpNm) {
		this.cgoTpNm = cgoTpNm;
	}

	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}

	/**
	 * Column Info
	 * @param trspSoCmbTpCd
	 */
	public void setTrspSoCmbTpCd(String trspSoCmbTpCd) {
		this.trspSoCmbTpCd = trspSoCmbTpCd;
	}

	/**
	 * Column Info
	 * @param troCfmUsrId
	 */
	public void setTroCfmUsrId(String troCfmUsrId) {
		this.troCfmUsrId = troCfmUsrId;
	}

	/**
	 * Column Info
	 * @param mtyRrFlg
	 */
	public void setMtyRrFlg(String mtyRrFlg) {
		this.mtyRrFlg = mtyRrFlg;
	}

	/**
	 * Column Info
	 * @param trspCostDtlModNm
	 */
	public void setTrspCostDtlModNm(String trspCostDtlModNm) {
		this.trspCostDtlModNm = trspCostDtlModNm;
	}

	/**
	 * Column Info
	 * @param poBasicRt
	 */
	public void setPoBasicRt(String poBasicRt) {
		this.poBasicRt = poBasicRt;
	}

	/**
	 * Column Info
	 * @param woRjctDt
	 */
	public void setWoRjctDt(String woRjctDt) {
		this.woRjctDt = woRjctDt;
	}

	/**
	 * Column Info
	 * @param actCustCd
	 */
	public void setActCustCd(String actCustCd) {
		this.actCustCd = actCustCd;
	}

	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}

	/**
	 * Column Info
	 * @param negoAmt
	 */
	public void setNegoAmt(String negoAmt) {
		this.negoAmt = negoAmt;
	}

	/**
	 * Column Info
	 * @param woTotAmt
	 */
	public void setWoTotAmt(String woTotAmt) {
		this.woTotAmt = woTotAmt;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param n3ptyBzcDesc
	 */
	public void setN3ptyBzcDesc(String n3ptyBzcDesc) {
		this.n3ptyBzcDesc = n3ptyBzcDesc;
	}

	/**
	 * Column Info
	 * @param fctryNm
	 */
	public void setFctryNm(String fctryNm) {
		this.fctryNm = fctryNm;
	}

	/**
	 * Column Info
	 * @param loclUpdDt
	 */
	public void setLoclUpdDt(String loclUpdDt) {
		this.loclUpdDt = loclUpdDt;
	}

	/**
	 * Column Info
	 * @param cancelCheck
	 */
	public void setCancelCheck(String cancelCheck) {
		this.cancelCheck = cancelCheck;
	}

	/**
	 * Column Info
	 * @param woIssStsCd
	 */
	public void setWoIssStsCd(String woIssStsCd) {
		this.woIssStsCd = woIssStsCd;
	}

	/**
	 * Column Info
	 * @param distance
	 */
	public void setDistance(String distance) {
		this.distance = distance;
	}

	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}

	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	/**
	 * Column Info
	 * @param poTrspAgmtRtTpNm
	 */
	public void setPoTrspAgmtRtTpNm(String poTrspAgmtRtTpNm) {
		this.poTrspAgmtRtTpNm = poTrspAgmtRtTpNm;
	}

	/**
	 * Column Info
	 * @param n3ptyBzcCustCntCd
	 */
	public void setN3ptyBzcCustCntCd(String n3ptyBzcCustCntCd) {
		this.n3ptyBzcCustCntCd = n3ptyBzcCustCntCd;
	}

	/**
	 * Column Info
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}

	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}

	/**
	 * Column Info
	 * @param fmYardValue
	 */
	public void setFmYardValue(String fmYardValue) {
		this.fmYardValue = fmYardValue;
	}

	/**
	 * Column Info
	 * @param fmLocValue
	 */
	public void setFmLocValue(String fmLocValue) {
		this.fmLocValue = fmLocValue;
	}

	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}

	/**
	 * Column Info
	 * @param viaYardValue
	 */
	public void setViaYardValue(String viaYardValue) {
		this.viaYardValue = viaYardValue;
	}

	/**
	 * Column Info
	 * @param shprCustNm
	 */
	public void setShprCustNm(String shprCustNm) {
		this.shprCustNm = shprCustNm;
	}

	/**
	 * Column Info
	 * @param trspAgmtWyTpCd
	 */
	public void setTrspAgmtWyTpCd(String trspAgmtWyTpCd) {
		this.trspAgmtWyTpCd = trspAgmtWyTpCd;
	}

	/**
	 * Column Info
	 * @param trspRjctRsnCd
	 */
	public void setTrspRjctRsnCd(String trspRjctRsnCd) {
		this.trspRjctRsnCd = trspRjctRsnCd;
	}

	/**
	 * Column Info
	 * @param poOverWgtScgRt
	 */
	public void setPoOverWgtScgRt(String poOverWgtScgRt) {
		this.poOverWgtScgRt = poOverWgtScgRt;
	}

	/**
	 * Column Info
	 * @param lstNodPlnDt
	 */
	public void setLstNodPlnDt(String lstNodPlnDt) {
		this.lstNodPlnDt = lstNodPlnDt;
	}

	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}

	/**
	 * Column Info
	 * @param bzcAmt
	 */
	public void setBzcAmt(String bzcAmt) {
		this.bzcAmt = bzcAmt;
	}

	/**
	 * Column Info
	 * @param trspWoOfcCtyCd
	 */
	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
	}

	/**
	 * Column Info
	 * @param fuelScgAmt
	 */
	public void setFuelScgAmt(String fuelScgAmt) {
		this.fuelScgAmt = fuelScgAmt;
	}

	/**
	 * Column Info
	 * @param n3ptyBzcOfcCd
	 */
	public void setN3ptyBzcOfcCd(String n3ptyBzcOfcCd) {
		this.n3ptyBzcOfcCd = n3ptyBzcOfcCd;
	}

	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}

	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * Column Info
	 * @param custCntCdSeq
	 */
	public void setCustCntCdSeq(String custCntCdSeq) {
		this.custCntCdSeq = custCntCdSeq;
	}

	/**
	 * Column Info
	 * @param n3ptyBilFlg
	 */
	public void setN3ptyBilFlg(String n3ptyBilFlg) {
		this.n3ptyBilFlg = n3ptyBilFlg;
	}

	/**
	 * Column Info
	 * @param toLocValue
	 */
	public void setToLocValue(String toLocValue) {
		this.toLocValue = toLocValue;
	}

	/**
	 * Column Info
	 * @param distanceUom
	 */
	public void setDistanceUom(String distanceUom) {
		this.distanceUom = distanceUom;
	}

	/**
	 * Column Info
	 * @param woCreNm
	 */
	public void setWoCreNm(String woCreNm) {
		this.woCreNm = woCreNm;
	}

	/**
	 * Column Info
	 * @param viaLocValue
	 */
	public void setViaLocValue(String viaLocValue) {
		this.viaLocValue = viaLocValue;
	}

	/**
	 * Column Info
	 * @param cneeCustNm
	 */
	public void setCneeCustNm(String cneeCustNm) {
		this.cneeCustNm = cneeCustNm;
	}

	/**
	 * Column Info
	 * @param costActGrpSeq
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}

	/**
	 * Column Info
	 * @param woRjctIndct
	 */
	public void setWoRjctIndct(String woRjctIndct) {
		this.woRjctIndct = woRjctIndct;
	}

	/**
	 * Column Info
	 * @param n1stNodPlnDt
	 */
	public void setN1stNodPlnDt(String n1stNodPlnDt) {
		this.n1stNodPlnDt = n1stNodPlnDt;
	}

	/**
	 * Column Info
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}

	/**
	 * Column Info
	 * @param n3ptyBzcAmt
	 */
	public void setN3ptyBzcAmt(String n3ptyBzcAmt) {
		this.n3ptyBzcAmt = n3ptyBzcAmt;
	}

	/**
	 * Column Info
	 * @param n1stNodPlnTm
	 */
	public void setN1stNodPlnTm(String n1stNodPlnTm) {
		this.n1stNodPlnTm = n1stNodPlnTm;
	}

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}

	/**
	 * Column Info
	 * @param cntrKgsWgt
	 */
	public void setCntrKgsWgt(String cntrKgsWgt) {
		this.cntrKgsWgt = cntrKgsWgt;
	}

	/**
	 * Column Info
	 * @param colNm
	 */
	public void setColNm(String colNm) {
		this.colNm = colNm;
	}

	/**
	 * Column Info
	 * @param troCnfm
	 */
	public void setTroCnfm(String troCnfm) {
		this.troCnfm = troCnfm;
	}

	/**
	 * Column Info
	 * @param dtnUseFlg
	 */
	public void setDtnUseFlg(String dtnUseFlg) {
		this.dtnUseFlg = dtnUseFlg;
	}

	/**
	 * Column Info
	 * @param trspCrrModNm
	 */
	public void setTrspCrrModNm(String trspCrrModNm) {
		this.trspCrrModNm = trspCrrModNm;
	}

	/**
	 * Column Info
	 * @param bundlingNo
	 */
	public void setBundlingNo(String bundlingNo) {
		this.bundlingNo = bundlingNo;
	}

	/**
	 * Column Info
	 * @param n3ptyBzcVndrSeq
	 */
	public void setN3ptyBzcVndrSeq(String n3ptyBzcVndrSeq) {
		this.n3ptyBzcVndrSeq = n3ptyBzcVndrSeq;
	}

	/**
	 * Column Info
	 * @param trsSubStsCd
	 */
	public void setTrsSubStsCd(String trsSubStsCd) {
		this.trsSubStsCd = trsSubStsCd;
	}

	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}

	/**
	 * Column Info
	 * @param dorDeAddr
	 */
	public void setDorDeAddr(String dorDeAddr) {
		this.dorDeAddr = dorDeAddr;
	}

	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	/**
	 * Column Info
	 * @param woIssueDt
	 */
	public void setWoIssueDt(String woIssueDt) {
		this.woIssueDt = woIssueDt;
	}

	/**
	 * Column Info
	 * @param soCreNm
	 */
	public void setSoCreNm(String soCreNm) {
		this.soCreNm = soCreNm;
	}

	/**
	 * Column Info
	 * @param lstNodPlnTm
	 */
	public void setLstNodPlnTm(String lstNodPlnTm) {
		this.lstNodPlnTm = lstNodPlnTm;
	}

	/**
	 * Column Info
	 * @param poTrspAgmtSeq
	 */
	public void setPoTrspAgmtSeq(String poTrspAgmtSeq) {
		this.poTrspAgmtSeq = poTrspAgmtSeq;
	}

	/**
	 * Column Info
	 * @param spclCgoCntrTpCd
	 */
	public void setSpclCgoCntrTpCd(String spclCgoCntrTpCd) {
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param trspAgmtRtTpCd
	 */
	public void setTrspAgmtRtTpCd(String trspAgmtRtTpCd) {
		this.trspAgmtRtTpCd = trspAgmtRtTpCd;
	}

	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}

	/**
	 * Column Info
	 * @param cntcPsonFaxNo
	 */
	public void setCntcPsonFaxNo(String cntcPsonFaxNo) {
		this.cntcPsonFaxNo = cntcPsonFaxNo;
	}

	/**
	 * Column Info
	 * @param trspCostDtlModCd
	 */
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}

	/**
	 * Column Info
	 * @param dorNodPlnDt
	 */
	public void setDorNodPlnDt(String dorNodPlnDt) {
		this.dorNodPlnDt = dorNodPlnDt;
	}

	/**
	 * Column Info
	 * @param poTrspAgmtRtTpCd
	 */
	public void setPoTrspAgmtRtTpCd(String poTrspAgmtRtTpCd) {
		this.poTrspAgmtRtTpCd = poTrspAgmtRtTpCd;
	}

	/**
	 * Column Info
	 * @param poTrspAgmtOfcCtyCd
	 */
	public void setPoTrspAgmtOfcCtyCd(String poTrspAgmtOfcCtyCd) {
		this.poTrspAgmtOfcCtyCd = poTrspAgmtOfcCtyCd;
	}

	/**
	 * Column Info
	 * @param mltStopDeFlg
	 */
	public void setMltStopDeFlg(String mltStopDeFlg) {
		this.mltStopDeFlg = mltStopDeFlg;
	}

	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}

	/**
	 * Column Info
	 * @param trspSoCmbTpNm
	 */
	public void setTrspSoCmbTpNm(String trspSoCmbTpNm) {
		this.trspSoCmbTpNm = trspSoCmbTpNm;
	}

	/**
	 * Column Info
	 * @param woBlNoIssFlg
	 */
	public void setWoBlNoIssFlg(String woBlNoIssFlg) {
		this.woBlNoIssFlg = woBlNoIssFlg;
	}

	/**
	 * Column Info
	 * @param trspSoTpCd
	 */
	public void setTrspSoTpCd(String trspSoTpCd) {
		this.trspSoTpCd = trspSoTpCd;
	}

	/**
	 * Column Info
	 * @param revCurrCd
	 */
	public void setRevCurrCd(String revCurrCd) {
		this.revCurrCd = revCurrCd;
	}

	/**
	 * Column Info
	 * @param woRmk
	 */
	public void setWoRmk(String woRmk) {
		this.woRmk = woRmk;
	}

	/**
	 * Column Info
	 * @param defaultSpFlg
	 */
	public void setDefaultSpFlg(String defaultSpFlg) {
		this.defaultSpFlg = defaultSpFlg;
	}

	/**
	 * Column Info
	 * @param trspDfltVndrFlg
	 */
	public void setTrspDfltVndrFlg(String trspDfltVndrFlg) {
		this.trspDfltVndrFlg = trspDfltVndrFlg;
	}

	/**
	 * Column Info
	 * @param trspWoSeq
	 */
	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}

	/**
	 * Column Info
	 * @param fdrVvd
	 */
	public void setFdrVvd(String fdrVvd) {
		this.fdrVvd = fdrVvd;
	}

	/**
	 * Column Info
	 * @param surchargeKey
	 */
	public void setSurchargeKey(String surchargeKey) {
		this.surchargeKey = surchargeKey;
	}

	/**
	 * Column Info
	 * @param poCustSeq
	 */
	public void setPoCustSeq(String poCustSeq) {
		this.poCustSeq = poCustSeq;
	}

	/**
	 * Column Info
	 * @param cntcPsonPhnNo
	 */
	public void setCntcPsonPhnNo(String cntcPsonPhnNo) {
		this.cntcPsonPhnNo = cntcPsonPhnNo;
	}

	/**
	 * Column Info
	 * @param cntrLbsWgt
	 */
	public void setCntrLbsWgt(String cntrLbsWgt) {
		this.cntrLbsWgt = cntrLbsWgt;
	}

	/**
	 * Column Info
	 * @param soCreDt
	 */
	public void setSoCreDt(String soCreDt) {
		this.soCreDt = soCreDt;
	}

	/**
	 * Column Info
	 * @param poSpType
	 */
	public void setPoSpType(String poSpType) {
		this.poSpType = poSpType;
	}

	/**
	 * Column Info
	 * @param bkgspe
	 */
	public void setBkgspe(String bkgspe) {
		this.bkgspe = bkgspe;
	}

	/**
	 * Column Info
	 * @param costActGrpCd
	 */
	public void setCostActGrpCd(String costActGrpCd) {
		this.costActGrpCd = costActGrpCd;
	}

	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	/**
	 * Column Info
	 * @param wgtMeasUtCd
	 */
	public void setWgtMeasUtCd(String wgtMeasUtCd) {
		this.wgtMeasUtCd = wgtMeasUtCd;
	}

	/**
	 * Column Info
	 * @param trspSoOfcCtyCdSeq
	 */
	public void setTrspSoOfcCtyCdSeq(String trspSoOfcCtyCdSeq) {
		this.trspSoOfcCtyCdSeq = trspSoOfcCtyCdSeq;
	}

	/**
	 * Column Info
	 * @param troCfmOfcCd
	 */
	public void setTroCfmOfcCd(String troCfmOfcCd) {
		this.troCfmOfcCd = troCfmOfcCd;
	}

	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	/**
	 * Column Info
	 * @param poRtnMsg
	 */
	public void setPoRtnMsg(String poRtnMsg) {
		this.poRtnMsg = poRtnMsg;
	}

	/**
	 * Column Info
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}

	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * Column Info
	 * @param toYardValue
	 */
	public void setToYardValue(String toYardValue) {
		this.toYardValue = toYardValue;
	}

	/**
	 * Column Info
	 * @param trspRqstBkgFlg
	 */
	public void setTrspRqstBkgFlg(String trspRqstBkgFlg) {
		this.trspRqstBkgFlg = trspRqstBkgFlg;
	}

	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}

	/**
	 * Column Info
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}

	/**
	 * Column Info
	 * @param n3ptyBzcCurrCd
	 */
	public void setN3ptyBzcCurrCd(String n3ptyBzcCurrCd) {
		this.n3ptyBzcCurrCd = n3ptyBzcCurrCd;
	}

	/**
	 * Column Info
	 * @param poCustCntCd
	 */
	public void setPoCustCntCd(String poCustCntCd) {
		this.poCustCntCd = poCustCntCd;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * @param poCustCntCdSeq
	 */
	public void setPoCustCntCdSeq(String poCustCntCdSeq) {
		this.poCustCntCdSeq = poCustCntCdSeq;
	}

	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}

	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}

	/**
	 * Column Info
	 * @param dorYardValue
	 */
	public void setDorYardValue(String dorYardValue) {
		this.dorYardValue = dorYardValue;
	}

	/**
	 * Column Info
	 * @param woEdiUseFlg
	 */
	public void setWoEdiUseFlg(String woEdiUseFlg) {
		this.woEdiUseFlg = woEdiUseFlg;
	}

	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}

	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	/**
	 * Column Info
	 * @param moreCandidates
	 */
	public void setMoreCandidates(String moreCandidates) {
		this.moreCandidates = moreCandidates;
	}

	/**
	 * Column Info
	 * @param spclInstrRmk
	 */
	public void setSpclInstrRmk(String spclInstrRmk) {
		this.spclInstrRmk = spclInstrRmk;
	}

	/**
	 * Column Info
	 * @param revenue
	 */
	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	/**
	 * Column Info
	 * @param presetVndrSeq
	 */
	public void setPresetVndrSeq(String presetVndrSeq) {
		this.presetVndrSeq = presetVndrSeq;
	}

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * @param etcAddAmt
	 */
	public void setEtcAddAmt(String etcAddAmt) {
		this.etcAddAmt = etcAddAmt;
	}

	/**
	 * Column Info
	 * @param woTotAmtUsd
	 */
	public void setWoTotAmtUsd(String woTotAmtUsd) {
		this.woTotAmtUsd = woTotAmtUsd;
	}

	/**
	 * Column Info
	 * @param cngCateSubCd
	 */
	public void setCngCateSubCd(String cngCateSubCd) {
		this.cngCateSubCd = cngCateSubCd;
	}

	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}

	/**
	 * Column Info
	 * @param poWayType
	 */
	public void setPoWayType(String poWayType) {
		this.poWayType = poWayType;
	}

	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}

	/**
	 * Column Info
	 * @param dorNodPlnTm
	 */
	public void setDorNodPlnTm(String dorNodPlnTm) {
		this.dorNodPlnTm = dorNodPlnTm;
	}

	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * Column Info
	 * @param spType
	 */
	public void setSpType(String spType) {
		this.spType = spType;
	}

	/**
	 * Column Info
	 * @param troCfmUpdDt
	 */
	public void setTroCfmUpdDt(String troCfmUpdDt) {
		this.troCfmUpdDt = troCfmUpdDt;
	}

	/**
	 * Column Info
	 * @param poRtnCd
	 */
	public void setPoRtnCd(String poRtnCd) {
		this.poRtnCd = poRtnCd;
	}

	/**
	 * Column Info
	 * @param bkgTroNo
	 */
	public void setBkgTroNo(String bkgTroNo) {
		this.bkgTroNo = bkgTroNo;
	}

	/**
	 * Column Info
	 * @param previousVal
	 */
	public void setPreviousVal(String previousVal) {
		this.previousVal = previousVal;
	}

	/**
	 * Column Info
	 * @param rejectedCheck
	 */
	public void setRejectedCheck(String rejectedCheck) {
		this.rejectedCheck = rejectedCheck;
	}

	/**
	 * Column Info
	 * @param obVvdCd
	 */
	public void setObVvdCd(String obVvdCd) {
		this.obVvdCd = obVvdCd;
	}

	/**
	 * Column Info
	 * @param poLocalCurrCd
	 */
	public void setPoLocalCurrCd(String poLocalCurrCd) {
		this.poLocalCurrCd = poLocalCurrCd;
	}

	/**
	 * Column Info
	 * @param ntfyCustNm
	 */
	public void setNtfyCustNm(String ntfyCustNm) {
		this.ntfyCustNm = ntfyCustNm;
	}

	/**
	 * Column Info
	 * @param dorLocValue
	 */
	public void setDorLocValue(String dorLocValue) {
		this.dorLocValue = dorLocValue;
	}

	/**
	 * Column Info
	 * @param trspSoCmbSeq
	 */
	public void setTrspSoCmbSeq(String trspSoCmbSeq) {
		this.trspSoCmbSeq = trspSoCmbSeq;
	}

	/**
	 * Column Info
	 * @param trspWoOfcCtyCdSeq
	 */
	public void setTrspWoOfcCtyCdSeq(String trspWoOfcCtyCdSeq) {
		this.trspWoOfcCtyCdSeq = trspWoOfcCtyCdSeq;
	}

	/**
	 * Column Info
	 * @param custNomiTrkrFlg
	 */
	public void setCustNomiTrkrFlg(String custNomiTrkrFlg) {
		this.custNomiTrkrFlg = custNomiTrkrFlg;
	}

	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}

	/**
	 * @return
	 */
	public String getKgsNetWgt() {
		return kgsNetWgt;
	}

	/**
	 * @param kgsNetWgt
	 */
	public void setKgsNetWgt(String kgsNetWgt) {
		this.kgsNetWgt = kgsNetWgt;
	}

	/**
	 * @return
	 */
	public String getKgsTareWgt() {
		return kgsTareWgt;
	}

	/**
	 * @param kgsTareWgt
	 */
	public void setKgsTareWgt(String kgsTareWgt) {
		this.kgsTareWgt = kgsTareWgt;
	}

	/**
	 * @return
	 */
	public String getKgsGrossWgt() {
		return kgsGrossWgt;
	}

	/**
	 * @param kgsGrossWgt
	 */
	public void setKgsGrossWgt(String kgsGrossWgt) {
		this.kgsGrossWgt = kgsGrossWgt;
	}

	/**
	 * @return
	 */
	public String getLbsNetWgt() {
		return lbsNetWgt;
	}

	/**
	 * @param lbsNetWgt
	 */
	public void setLbsNetWgt(String lbsNetWgt) {
		this.lbsNetWgt = lbsNetWgt;
	}

	/**
	 * @return
	 */
	public String getLbsTareWgt() {
		return lbsTareWgt;
	}

	/**
	 * @param lbsTareWgt
	 */
	public void setLbsTareWgt(String lbsTareWgt) {
		this.lbsTareWgt = lbsTareWgt;
	}

	/**
	 * @return
	 */
	public String getLbsGrossWgt() {
		return lbsGrossWgt;
	}

	/**
	 * @param lbsGrossWgt
	 */
	public void setLbsGrossWgt(String lbsGrossWgt) {
		this.lbsGrossWgt = lbsGrossWgt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request, "");
	}

	/**
	 * Column Info
	 * @return cngIndFlg
	 */
	public String getCngIndFlg() {
		return cngIndFlg;
	}

	/**
	 * Column Info
	 * @param cngIndFlg
	 */
	public void setCngIndFlg(String cngIndFlg) {
		this.cngIndFlg = cngIndFlg;
	}

	/**
	 * Column Info
	 * @return rCct
	 */
	public String getrCct() {
		return rCct;
	}

	/**
	 * Column Info
	 * @param rCct
	 */
	public void setrCct(String rCct) {
		this.rCct = rCct;
	}

	/**
	 * Column Info
	 * @return tCct
	 */
	public String gettCct() {
		return tCct;
	}

	/**
	 * Column Info
	 * @param tCct
	 */
	public void settCct(String tCct) {
		this.tCct = tCct;
	}

	/**
	 * @return
	 */
	public String getCngIndFlgImg() {
		return cngIndFlgImg;
	}

	/**
	 * @param cngIndFlgImg
	 */
	public void setCngIndFlgImg(String cngIndFlgImg) {
		this.cngIndFlgImg = cngIndFlgImg;
	}

	/**
	 * @return
	 */
	public String getVndrCm() {
		return vndrCm;
	}

	/**
	 * @param vndrCm
	 */
	public void setVndrCm(String vndrCm) {
		this.vndrCm = vndrCm;
	}

	/**
	 * @return
	 */
	public String getVndrCmImg() {
		return vndrCmImg;
	}

	/**
	 * @param vndrCmImg
	 */
	public void setVndrCmImg(String vndrCmImg) {
		this.vndrCmImg = vndrCmImg;
	}

	/**
	 * @return
	 */
	public String getCnmvStsCd() {
		return cnmvStsCd;
	}

	/**
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}

	/**
	 * @return
	 */
	public String getCrntYdCd() {
		return crntYdCd;
	}

	/**
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}

	/**
	 * @return
	 */
	public String getCnmvDt() {
		return cnmvDt;
	}

	/**
	 * @param cnmvDt
	 */
	public void setCnmvDt(String cnmvDt) {
		this.cnmvDt = cnmvDt;
	}

	/**
	 * @return
	 */
	public String getCopFlg() {
		return copFlg;
	}

	/**
	 * @param copFlg
	 */
	public void setCopFlg(String copFlg) {
		this.copFlg = copFlg;
	}

	/**
	 * @return
	 */
	public String getCopEqNo() {
		return copEqNo;
	}

	/**
	 * @param copEqNo
	 */
	public void setCopEqNo(String copEqNo) {
		this.copEqNo = copEqNo;
	}

	/**
	 * @return
	 */
	public String getInterRmkImg() {
		return interRmkImg;
	}

	/**
	 * @param interRmkImg
	 */
	public void setInterRmkImg(String interRmkImg) {
		this.interRmkImg = interRmkImg;
	}

	/**
	 * @return
	 */
	public String getCgoFrtRcvIndFlg() {
		return cgoFrtRcvIndFlg;
	}

	/**
	 * @param cgoFrtRcvIndFlg
	 */
	public void setCgoFrtRcvIndFlg(String cgoFrtRcvIndFlg) {
		this.cgoFrtRcvIndFlg = cgoFrtRcvIndFlg;
	}

	/**
	 * @return
	 */
	public String getCgoOblRcvIndFlg() {
		return cgoOblRcvIndFlg;
	}

	/**
	 * @param cgoOblRcvIndFlg
	 */
	public void setCgoOblRcvIndFlg(String cgoOblRcvIndFlg) {
		this.cgoOblRcvIndFlg = cgoOblRcvIndFlg;
	}

	/**
	 * @return
	 */
	public String getCgoCstmsClrIndFlg() {
		return cgoCstmsClrIndFlg;
	}

	/**
	 * @param cgoCstmsClrIndFlg
	 */
	public void setCgoCstmsClrIndFlg(String cgoCstmsClrIndFlg) {
		this.cgoCstmsClrIndFlg = cgoCstmsClrIndFlg;
	}

	/**
	 * @return
	 */
	public String getCntrPkupNo() {
		return cntrPkupNo;
	}

	/**
	 * @param cntrPkupNo
	 */
	public void setCntrPkupNo(String cntrPkupNo) {
		this.cntrPkupNo = cntrPkupNo;
	}

	/**
	 * @return
	 */
	public String getFoFlg() {
		return foFlg;
	}

	/**
	 * @param foFlg
	 */
	public void setFoFlg(String foFlg) {
		this.foFlg = foFlg;
	}

	/**
	 * @return
	 */
	public String getBkgStsCd() {
		return bkgStsCd;
	}

	/**
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}

	/**
	 * @return
	 */
	public String getBkgStsCdNm() {
		return bkgStsCdNm;
	}

	/**
	 * @param bkgStsCdNm
	 */
	public void setBkgStsCdNm(String bkgStsCdNm) {
		this.bkgStsCdNm = bkgStsCdNm;
	}

	/**
	 * @param pwrSplCblFlg
	 */
	public void setPwrSplCblFlg(String pwrSplCblFlg) {
		this.pwrSplCblFlg = pwrSplCblFlg;
	}

	/**
	 * @param cntrSltNo
	 */
	public void setCntrSltNo(String cntrSltNo) {
		this.cntrSltNo = cntrSltNo;
	}

	/**
	 * @return rvnMptCntr
	 */
	public String getRvnMptCntr() {
		return rvnMptCntr;
	}

	/**
	 * @param rvnMptCntr
	 */
	public void setRvnMptCntr(String rvnMptCntr) {
		this.rvnMptCntr = rvnMptCntr;
	}

	/**
	 * @param doHldFlg
	 */
	public void setDoHldFlg(String doHldFlg) {
		this.doHldFlg = doHldFlg;
	}

	public Collection<WoIssueListVO> getModels() {
		return models;
	}

	public void setModels(Collection<WoIssueListVO> models) {
		this.models = models;
	}

	public String gettVvd() {
		return tVvd;
	}

	public void settVvd(String tVvd) {
		this.tVvd = tVvd;
	}

	public String getFmNodCdNm() {
		return fmNodCdNm;
	}

	public void setFmNodCdNm(String fmNodCdNm) {
		this.fmNodCdNm = fmNodCdNm;
	}

	public String getViaNodCdNm() {
		return viaNodCdNm;
	}

	public void setViaNodCdNm(String viaNodCdNm) {
		this.viaNodCdNm = viaNodCdNm;
	}

	public String getToNodCdNm() {
		return toNodCdNm;
	}

	public void setToNodCdNm(String toNodCdNm) {
		this.toNodCdNm = toNodCdNm;
	}

	public String getDorNodCdNm() {
		return dorNodCdNm;
	}

	public void setDorNodCdNm(String dorNodCdNm) {
		this.dorNodCdNm = dorNodCdNm;
	}

	public String getPorCdNm() {
		return porCdNm;
	}

	public void setPorCdNm(String porCdNm) {
		this.porCdNm = porCdNm;
	}

	public String getPolCdNm() {
		return polCdNm;
	}

	public void setPolCdNm(String polCdNm) {
		this.polCdNm = polCdNm;
	}

	public String getPodCdNm() {
		return podCdNm;
	}

	public void setPodCdNm(String podCdNm) {
		this.podCdNm = podCdNm;
	}

	public String getDelCdNm() {
		return delCdNm;
	}

	public void setDelCdNm(String delCdNm) {
		this.delCdNm = delCdNm;
	}

	public String getContiCd() {
		return contiCd;
	}

	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}

	public String getScgIndCd() {
		return scgIndCd;
	}

	public void setScgIndCd(String scgIndCd) {
		this.scgIndCd = scgIndCd;
	}

	public String getVgmKgsWgt() {
		return vgmKgsWgt;
	}

	public void setVgmKgsWgt(String vgmKgsWgt) {
		this.vgmKgsWgt = vgmKgsWgt;
	}

	public String getVgmLbsWgt() {
		return vgmLbsWgt;
	}

	public void setVgmLbsWgt(String vgmLbsWgt) {
		this.vgmLbsWgt = vgmLbsWgt;
	}

	public String getIbcheck() {
		return ibcheck;
	}

	public void setIbcheck(String ibcheck) {
		this.ibcheck = ibcheck;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbVvdCd(JSPUtil.getParameter(request, prefix + "ib_vvd_cd", ""));
		setN3ptyBzcTpCd(JSPUtil.getParameter(request, prefix + "n3pty_bzc_tp_cd", ""));
		setTroCfmUpdTm(JSPUtil.getParameter(request, prefix + "tro_cfm_upd_tm", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setPoLocalCurrTotAmt(JSPUtil.getParameter(request, prefix + "po_local_curr_tot_amt", ""));
		setCngCateCd(JSPUtil.getParameter(request, prefix + "cng_cate_cd", ""));
		setTrspAgmtRtTpNm(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN3ptyBzcCustSeq(JSPUtil.getParameter(request, prefix + "n3pty_bzc_cust_seq", ""));
		setDorPstCd(JSPUtil.getParameter(request, prefix + "dor_pst_cd", ""));
		setPoFuelScgRt(JSPUtil.getParameter(request, prefix + "po_fuel_scg_rt", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setTrspFrstFlg(JSPUtil.getParameter(request, prefix + "trsp_frst_flg", ""));
		setTrspSoTpNm(JSPUtil.getParameter(request, prefix + "trsp_so_tp_nm", ""));
		setPoUsdCurrTotAmt(JSPUtil.getParameter(request, prefix + "po_usd_curr_tot_amt", ""));
		setWoIssued(JSPUtil.getParameter(request, prefix + "wo_issued", ""));
		setNowReadVal(JSPUtil.getParameter(request, prefix + "now_read_val", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setPoCustNomiTrkrFlg(JSPUtil.getParameter(request, prefix + "po_cust_nomi_trkr_flg", ""));
		setCgoTpNm(JSPUtil.getParameter(request, prefix + "cgo_tp_nm", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setTrspSoCmbTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_cmb_tp_cd", ""));
		setTroCfmUsrId(JSPUtil.getParameter(request, prefix + "tro_cfm_usr_id", ""));
		setMtyRrFlg(JSPUtil.getParameter(request, prefix + "mty_rr_flg", ""));
		setTrspCostDtlModNm(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_nm", ""));
		setPoBasicRt(JSPUtil.getParameter(request, prefix + "po_basic_rt", ""));
		setWoRjctDt(JSPUtil.getParameter(request, prefix + "wo_rjct_dt", ""));
		setActCustCd(JSPUtil.getParameter(request, prefix + "act_cust_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setNegoAmt(JSPUtil.getParameter(request, prefix + "nego_amt", ""));
		setWoTotAmt(JSPUtil.getParameter(request, prefix + "wo_tot_amt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setN3ptyBzcDesc(JSPUtil.getParameter(request, prefix + "n3pty_bzc_desc", ""));
		setFctryNm(JSPUtil.getParameter(request, prefix + "fctry_nm", ""));
		setLoclUpdDt(JSPUtil.getParameter(request, prefix + "locl_upd_dt", ""));
		setCancelCheck(JSPUtil.getParameter(request, prefix + "cancel_check", ""));
		setWoIssStsCd(JSPUtil.getParameter(request, prefix + "wo_iss_sts_cd", ""));
		setDistance(JSPUtil.getParameter(request, prefix + "distance", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setPoTrspAgmtRtTpNm(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_rt_tp_nm", ""));
		setN3ptyBzcCustCntCd(JSPUtil.getParameter(request, prefix + "n3pty_bzc_cust_cnt_cd", ""));
		setBkgQty(JSPUtil.getParameter(request, prefix + "bkg_qty", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setFmYardValue(JSPUtil.getParameter(request, prefix + "fm_yard_value", ""));
		setFmLocValue(JSPUtil.getParameter(request, prefix + "fm_loc_value", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setViaYardValue(JSPUtil.getParameter(request, prefix + "via_yard_value", ""));
		setShprCustNm(JSPUtil.getParameter(request, prefix + "shpr_cust_nm", ""));
		setTrspAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_wy_tp_cd", ""));
		setTrspRjctRsnCd(JSPUtil.getParameter(request, prefix + "trsp_rjct_rsn_cd", ""));
		setPoOverWgtScgRt(JSPUtil.getParameter(request, prefix + "po_over_wgt_scg_rt", ""));
		setLstNodPlnDt(JSPUtil.getParameter(request, prefix + "lst_nod_pln_dt", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setBzcAmt(JSPUtil.getParameter(request, prefix + "bzc_amt", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd", ""));
		setFuelScgAmt(JSPUtil.getParameter(request, prefix + "fuel_scg_amt", ""));
		setN3ptyBzcOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_bzc_ofc_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCustCntCdSeq(JSPUtil.getParameter(request, prefix + "cust_cnt_cd_seq", ""));
		setN3ptyBilFlg(JSPUtil.getParameter(request, prefix + "n3pty_bil_flg", ""));
		setToLocValue(JSPUtil.getParameter(request, prefix + "to_loc_value", ""));
		setDistanceUom(JSPUtil.getParameter(request, prefix + "distance_uom", ""));
		setWoCreNm(JSPUtil.getParameter(request, prefix + "wo_cre_nm", ""));
		setViaLocValue(JSPUtil.getParameter(request, prefix + "via_loc_value", ""));
		setCneeCustNm(JSPUtil.getParameter(request, prefix + "cnee_cust_nm", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, prefix + "cost_act_grp_seq", ""));
		setWoRjctIndct(JSPUtil.getParameter(request, prefix + "wo_rjct_indct", ""));
		setN1stNodPlnDt(JSPUtil.getParameter(request, prefix + "n1st_nod_pln_dt", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setN3ptyBzcAmt(JSPUtil.getParameter(request, prefix + "n3pty_bzc_amt", ""));
		setN1stNodPlnTm(JSPUtil.getParameter(request, prefix + "n1st_nod_pln_tm", ""));
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setCntrKgsWgt(JSPUtil.getParameter(request, prefix + "cntr_kgs_wgt", ""));
		setColNm(JSPUtil.getParameter(request, prefix + "col_nm", ""));
		setTroCnfm(JSPUtil.getParameter(request, prefix + "tro_cnfm", ""));
		setDtnUseFlg(JSPUtil.getParameter(request, prefix + "dtn_use_flg", ""));
		setTrspCrrModNm(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_nm", ""));
		setBundlingNo(JSPUtil.getParameter(request, prefix + "bundling_no", ""));
		setN3ptyBzcVndrSeq(JSPUtil.getParameter(request, prefix + "n3pty_bzc_vndr_seq", ""));
		setTrsSubStsCd(JSPUtil.getParameter(request, prefix + "trs_sub_sts_cd", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setDorDeAddr(JSPUtil.getParameter(request, prefix + "dor_de_addr", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setWoIssueDt(JSPUtil.getParameter(request, prefix + "wo_issue_dt", ""));
		setSoCreNm(JSPUtil.getParameter(request, prefix + "so_cre_nm", ""));
		setLstNodPlnTm(JSPUtil.getParameter(request, prefix + "lst_nod_pln_tm", ""));
		setPoTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_seq", ""));
		setSpclCgoCntrTpCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cntr_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setTrspAgmtRtTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_cd", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setCntcPsonFaxNo(JSPUtil.getParameter(request, prefix + "cntc_pson_fax_no", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
		setDorNodPlnDt(JSPUtil.getParameter(request, prefix + "dor_nod_pln_dt", ""));
		setPoTrspAgmtRtTpCd(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_rt_tp_cd", ""));
		setPoTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_ofc_cty_cd", ""));
		setMltStopDeFlg(JSPUtil.getParameter(request, prefix + "mlt_stop_de_flg", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setTrspSoCmbTpNm(JSPUtil.getParameter(request, prefix + "trsp_so_cmb_tp_nm", ""));
		setWoBlNoIssFlg(JSPUtil.getParameter(request, prefix + "wo_bl_no_iss_flg", ""));
		setTrspSoTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_tp_cd", ""));
		setRevCurrCd(JSPUtil.getParameter(request, prefix + "rev_curr_cd", ""));
		setWoRmk(JSPUtil.getParameter(request, prefix + "wo_rmk", ""));
		setDefaultSpFlg(JSPUtil.getParameter(request, prefix + "default_sp_flg", ""));
		setTrspDfltVndrFlg(JSPUtil.getParameter(request, prefix + "trsp_dflt_vndr_flg", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, prefix + "trsp_wo_seq", ""));
		setFdrVvd(JSPUtil.getParameter(request, prefix + "fdr_vvd", ""));
		setSurchargeKey(JSPUtil.getParameter(request, prefix + "surcharge_key", ""));
		setPoCustSeq(JSPUtil.getParameter(request, prefix + "po_cust_seq", ""));
		setCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "cntc_pson_phn_no", ""));
		setCntrLbsWgt(JSPUtil.getParameter(request, prefix + "cntr_lbs_wgt", ""));
		setSoCreDt(JSPUtil.getParameter(request, prefix + "so_cre_dt", ""));
		setPoSpType(JSPUtil.getParameter(request, prefix + "po_sp_type", ""));
		setBkgspe(JSPUtil.getParameter(request, prefix + "bkgspe", ""));
		setCostActGrpCd(JSPUtil.getParameter(request, prefix + "cost_act_grp_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setWgtMeasUtCd(JSPUtil.getParameter(request, prefix + "wgt_meas_ut_cd", ""));
		setTrspSoOfcCtyCdSeq(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd_seq", ""));
		setTroCfmOfcCd(JSPUtil.getParameter(request, prefix + "tro_cfm_ofc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPoRtnMsg(JSPUtil.getParameter(request, prefix + "po_rtn_msg", ""));
		setRefId(JSPUtil.getParameter(request, prefix + "ref_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setToYardValue(JSPUtil.getParameter(request, prefix + "to_yard_value", ""));
		setTrspRqstBkgFlg(JSPUtil.getParameter(request, prefix + "trsp_rqst_bkg_flg", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setN3ptyBzcCurrCd(JSPUtil.getParameter(request, prefix + "n3pty_bzc_curr_cd", ""));
		setPoCustCntCd(JSPUtil.getParameter(request, prefix + "po_cust_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPoCustCntCdSeq(JSPUtil.getParameter(request, prefix + "po_cust_cnt_cd_seq", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setDorYardValue(JSPUtil.getParameter(request, prefix + "dor_yard_value", ""));
		setWoEdiUseFlg(JSPUtil.getParameter(request, prefix + "wo_edi_use_flg", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setMoreCandidates(JSPUtil.getParameter(request, prefix + "more_candidates", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, prefix + "spcl_instr_rmk", ""));
		setRevenue(JSPUtil.getParameter(request, prefix + "revenue", ""));
		setPresetVndrSeq(JSPUtil.getParameter(request, prefix + "preset_vndr_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setEtcAddAmt(JSPUtil.getParameter(request, prefix + "etc_add_amt", ""));
		setWoTotAmtUsd(JSPUtil.getParameter(request, prefix + "wo_tot_amt_usd", ""));
		setCngCateSubCd(JSPUtil.getParameter(request, prefix + "cng_cate_sub_cd", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setPoWayType(JSPUtil.getParameter(request, prefix + "po_way_type", ""));
		setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
		setDorNodPlnTm(JSPUtil.getParameter(request, prefix + "dor_nod_pln_tm", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSpType(JSPUtil.getParameter(request, prefix + "sp_type", ""));
		setTroCfmUpdDt(JSPUtil.getParameter(request, prefix + "tro_cfm_upd_dt", ""));
		setPoRtnCd(JSPUtil.getParameter(request, prefix + "po_rtn_cd", ""));
		setBkgTroNo(JSPUtil.getParameter(request, prefix + "bkg_tro_no", ""));
		setPreviousVal(JSPUtil.getParameter(request, prefix + "previous_val", ""));
		setRejectedCheck(JSPUtil.getParameter(request, prefix + "rejected_check", ""));
		setObVvdCd(JSPUtil.getParameter(request, prefix + "ob_vvd_cd", ""));
		setPoLocalCurrCd(JSPUtil.getParameter(request, prefix + "po_local_curr_cd", ""));
		setNtfyCustNm(JSPUtil.getParameter(request, prefix + "ntfy_cust_nm", ""));
		setDorLocValue(JSPUtil.getParameter(request, prefix + "dor_loc_value", ""));
		setTrspSoCmbSeq(JSPUtil.getParameter(request, prefix + "trsp_so_cmb_seq", ""));
		setTrspWoOfcCtyCdSeq(JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd_seq", ""));
		setCustNomiTrkrFlg(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_flg", ""));
		setEccCd(JSPUtil.getParameter(request, prefix + "ecc_cd", ""));
		setCngIndFlg(JSPUtil.getParameter(request, prefix + "cng_ind_flg", ""));
		setrCct(JSPUtil.getParameter(request, prefix + "r_cct", ""));
		settCct(JSPUtil.getParameter(request, prefix + "t_cct", ""));
		setKgsNetWgt(JSPUtil.getParameter(request, prefix + "kgs_net_wgt", ""));
		setKgsTareWgt(JSPUtil.getParameter(request, prefix + "kgs_tare_wgt", ""));
		setKgsGrossWgt(JSPUtil.getParameter(request, prefix + "kgs_gross_wgt", ""));
		setLbsNetWgt(JSPUtil.getParameter(request, prefix + "lbs_net_wgt", ""));
		setLbsTareWgt(JSPUtil.getParameter(request, prefix + "lbs_tare_wgt", ""));
		setLbsGrossWgt(JSPUtil.getParameter(request, prefix + "lbs_gross_wgt", ""));
		setCngIndFlgImg(JSPUtil.getParameter(request, prefix + "cng_ind_flg_img", ""));
		setVndrCm(JSPUtil.getParameter(request, prefix + "vndr_cm", ""));
		setVndrCmImg(JSPUtil.getParameter(request, prefix + "vndr_cm_img", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request, prefix + "crnt_yd_cd", ""));
		setCnmvDt(JSPUtil.getParameter(request, prefix + "cnmv_dt", ""));
		setCopFlg(JSPUtil.getParameter(request, prefix + "cop_flg", ""));
		setCopEqNo(JSPUtil.getParameter(request, prefix + "cop_eq_no", ""));
		setInterRmkImg(JSPUtil.getParameter(request, prefix + "inter_rmk_img", ""));
		setCgoFrtRcvIndFlg(JSPUtil.getParameter(request, prefix + "cgo_frt_rcv_ind_flg", ""));
		setCgoOblRcvIndFlg(JSPUtil.getParameter(request, prefix + "cgo_obl_rcv_ind_flg", ""));
		setCgoCstmsClrIndFlg(JSPUtil.getParameter(request, prefix + "cgo_cstms_clr_ind_flg", ""));
		setCntrPkupNo(JSPUtil.getParameter(request, prefix + "cntr_pkup_no", ""));
		setFoFlg(JSPUtil.getParameter(request, prefix + "fo_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setBkgStsCdNm(JSPUtil.getParameter(request, prefix + "bkg_sts_cd_nm", ""));
		setPwrSplCblFlg(JSPUtil.getParameter(request, prefix + "pwr_spl_cbl_flg", ""));
		setCntrSltNo(JSPUtil.getParameter(request, prefix + "cntr_slt_no", ""));
		setRvnMptCntr(JSPUtil.getParameter(request, prefix + "rvn_mpt_cntr", ""));
		setDoHldFlg(JSPUtil.getParameter(request, prefix + "do_hld_flg", ""));
		setFmNodCdNm(JSPUtil.getParameter(request, prefix + "fm_nod_cd_nm", ""));
		setViaNodCdNm(JSPUtil.getParameter(request, prefix + "via_nod_cd_nm", ""));
		setToNodCdNm(JSPUtil.getParameter(request, prefix + "to_nod_cd_nm", ""));
		setDorNodCdNm(JSPUtil.getParameter(request, prefix + "dor_nod_cd_nm", ""));
		setPorCdNm(JSPUtil.getParameter(request, prefix + "por_cd_nm", ""));
		setPolCdNm(JSPUtil.getParameter(request, prefix + "pol_cd_nm", ""));
		setPodCdNm(JSPUtil.getParameter(request, prefix + "pod_cd_nm", ""));
		setDelCdNm(JSPUtil.getParameter(request, prefix + "del_cd_nm", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setScgIndCd(JSPUtil.getParameter(request, prefix + "scg_ind_cd", ""));
		setVgmKgsWgt(JSPUtil.getParameter(request, prefix + "vgm_kgs_wgt", ""));
		setVgmLbsWgt(JSPUtil.getParameter(request, prefix + "vgm_lbs_wgt", ""));
		setIbcheck(JSPUtil.getParameter(request, prefix + "ibcheck", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WoIssueListVO[]
	 */
	public WoIssueListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return WoIssueListVO[]
	 */
	public WoIssueListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		WoIssueListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibVvdCd = (JSPUtil.getParameter(request, prefix + "ib_vvd_cd", length));
			String[] n3ptyBzcTpCd = (JSPUtil.getParameter(request, prefix + "n3pty_bzc_tp_cd", length));
			String[] troCfmUpdTm = (JSPUtil.getParameter(request, prefix + "tro_cfm_upd_tm", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix + "cgo_tp_cd", length));
			String[] poLocalCurrTotAmt = (JSPUtil.getParameter(request, prefix + "po_local_curr_tot_amt", length));
			String[] cngCateCd = (JSPUtil.getParameter(request, prefix + "cng_cate_cd", length));
			String[] trspAgmtRtTpNm = (JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] n3ptyBzcCustSeq = (JSPUtil.getParameter(request, prefix + "n3pty_bzc_cust_seq", length));
			String[] dorPstCd = (JSPUtil.getParameter(request, prefix + "dor_pst_cd", length));
			String[] poFuelScgRt = (JSPUtil.getParameter(request, prefix + "po_fuel_scg_rt", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix + "t_vvd", length));
			String[] trspFrstFlg = (JSPUtil.getParameter(request, prefix + "trsp_frst_flg", length));
			String[] trspSoTpNm = (JSPUtil.getParameter(request, prefix + "trsp_so_tp_nm", length));
			String[] poUsdCurrTotAmt = (JSPUtil.getParameter(request, prefix + "po_usd_curr_tot_amt", length));
			String[] woIssued = (JSPUtil.getParameter(request, prefix + "wo_issued", length));
			String[] nowReadVal = (JSPUtil.getParameter(request, prefix + "now_read_val", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
			String[] poCustNomiTrkrFlg = (JSPUtil.getParameter(request, prefix + "po_cust_nomi_trkr_flg", length));
			String[] cgoTpNm = (JSPUtil.getParameter(request, prefix + "cgo_tp_nm", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix + "cntr_wgt", length));
			String[] trspSoCmbTpCd = (JSPUtil.getParameter(request, prefix + "trsp_so_cmb_tp_cd", length));
			String[] troCfmUsrId = (JSPUtil.getParameter(request, prefix + "tro_cfm_usr_id", length));
			String[] mtyRrFlg = (JSPUtil.getParameter(request, prefix + "mty_rr_flg", length));
			String[] trspCostDtlModNm = (JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_nm", length));
			String[] poBasicRt = (JSPUtil.getParameter(request, prefix + "po_basic_rt", length));
			String[] woRjctDt = (JSPUtil.getParameter(request, prefix + "wo_rjct_dt", length));
			String[] actCustCd = (JSPUtil.getParameter(request, prefix + "act_cust_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", length));
			String[] negoAmt = (JSPUtil.getParameter(request, prefix + "nego_amt", length));
			String[] woTotAmt = (JSPUtil.getParameter(request, prefix + "wo_tot_amt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
			String[] n3ptyBzcDesc = (JSPUtil.getParameter(request, prefix + "n3pty_bzc_desc", length));
			String[] fctryNm = (JSPUtil.getParameter(request, prefix + "fctry_nm", length));
			String[] loclUpdDt = (JSPUtil.getParameter(request, prefix + "locl_upd_dt", length));
			String[] cancelCheck = (JSPUtil.getParameter(request, prefix + "cancel_check", length));
			String[] woIssStsCd = (JSPUtil.getParameter(request, prefix + "wo_iss_sts_cd", length));
			String[] distance = (JSPUtil.getParameter(request, prefix + "distance", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix + "inter_rmk", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
			String[] poTrspAgmtRtTpNm = (JSPUtil.getParameter(request, prefix + "po_trsp_agmt_rt_tp_nm", length));
			String[] n3ptyBzcCustCntCd = (JSPUtil.getParameter(request, prefix + "n3pty_bzc_cust_cnt_cd", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix + "bkg_qty", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix + "dor_nod_cd", length));
			String[] fmYardValue = (JSPUtil.getParameter(request, prefix + "fm_yard_value", length));
			String[] fmLocValue = (JSPUtil.getParameter(request, prefix + "fm_loc_value", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", length));
			String[] viaYardValue = (JSPUtil.getParameter(request, prefix + "via_yard_value", length));
			String[] shprCustNm = (JSPUtil.getParameter(request, prefix + "shpr_cust_nm", length));
			String[] trspAgmtWyTpCd = (JSPUtil.getParameter(request, prefix + "trsp_agmt_wy_tp_cd", length));
			String[] trspRjctRsnCd = (JSPUtil.getParameter(request, prefix + "trsp_rjct_rsn_cd", length));
			String[] poOverWgtScgRt = (JSPUtil.getParameter(request, prefix + "po_over_wgt_scg_rt", length));
			String[] lstNodPlnDt = (JSPUtil.getParameter(request, prefix + "lst_nod_pln_dt", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix + "eq_knd_cd", length));
			String[] bzcAmt = (JSPUtil.getParameter(request, prefix + "bzc_amt", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd", length));
			String[] fuelScgAmt = (JSPUtil.getParameter(request, prefix + "fuel_scg_amt", length));
			String[] n3ptyBzcOfcCd = (JSPUtil.getParameter(request, prefix + "n3pty_bzc_ofc_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix + "fm_nod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
			String[] custCntCdSeq = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd_seq", length));
			String[] n3ptyBilFlg = (JSPUtil.getParameter(request, prefix + "n3pty_bil_flg", length));
			String[] toLocValue = (JSPUtil.getParameter(request, prefix + "to_loc_value", length));
			String[] distanceUom = (JSPUtil.getParameter(request, prefix + "distance_uom", length));
			String[] woCreNm = (JSPUtil.getParameter(request, prefix + "wo_cre_nm", length));
			String[] viaLocValue = (JSPUtil.getParameter(request, prefix + "via_loc_value", length));
			String[] cneeCustNm = (JSPUtil.getParameter(request, prefix + "cnee_cust_nm", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix + "cost_act_grp_seq", length));
			String[] woRjctIndct = (JSPUtil.getParameter(request, prefix + "wo_rjct_indct", length));
			String[] n1stNodPlnDt = (JSPUtil.getParameter(request, prefix + "n1st_nod_pln_dt", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix + "via_nod_cd", length));
			String[] n3ptyBzcAmt = (JSPUtil.getParameter(request, prefix + "n3pty_bzc_amt", length));
			String[] n1stNodPlnTm = (JSPUtil.getParameter(request, prefix + "n1st_nod_pln_tm", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix + "to_nod_cd", length));
			String[] cntrKgsWgt = (JSPUtil.getParameter(request, prefix + "cntr_kgs_wgt", length));
			String[] colNm = (JSPUtil.getParameter(request, prefix + "col_nm", length));
			String[] troCnfm = (JSPUtil.getParameter(request, prefix + "tro_cnfm", length));
			String[] dtnUseFlg = (JSPUtil.getParameter(request, prefix + "dtn_use_flg", length));
			String[] trspCrrModNm = (JSPUtil.getParameter(request, prefix + "trsp_crr_mod_nm", length));
			String[] bundlingNo = (JSPUtil.getParameter(request, prefix + "bundling_no", length));
			String[] n3ptyBzcVndrSeq = (JSPUtil.getParameter(request, prefix + "n3pty_bzc_vndr_seq", length));
			String[] trsSubStsCd = (JSPUtil.getParameter(request, prefix + "trs_sub_sts_cd", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix + "trsp_so_seq", length));
			String[] dorDeAddr = (JSPUtil.getParameter(request, prefix + "dor_de_addr", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix + "cop_no", length));
			String[] woIssueDt = (JSPUtil.getParameter(request, prefix + "wo_issue_dt", length));
			String[] soCreNm = (JSPUtil.getParameter(request, prefix + "so_cre_nm", length));
			String[] lstNodPlnTm = (JSPUtil.getParameter(request, prefix + "lst_nod_pln_tm", length));
			String[] poTrspAgmtSeq = (JSPUtil.getParameter(request, prefix + "po_trsp_agmt_seq", length));
			String[] spclCgoCntrTpCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_cntr_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
			String[] trspAgmtRtTpCd = (JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_cd", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix + "vndr_nm", length));
			String[] cntcPsonFaxNo = (JSPUtil.getParameter(request, prefix + "cntc_pson_fax_no", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", length));
			String[] dorNodPlnDt = (JSPUtil.getParameter(request, prefix + "dor_nod_pln_dt", length));
			String[] poTrspAgmtRtTpCd = (JSPUtil.getParameter(request, prefix + "po_trsp_agmt_rt_tp_cd", length));
			String[] poTrspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix + "po_trsp_agmt_ofc_cty_cd", length));
			String[] mltStopDeFlg = (JSPUtil.getParameter(request, prefix + "mlt_stop_de_flg", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
			String[] trspSoCmbTpNm = (JSPUtil.getParameter(request, prefix + "trsp_so_cmb_tp_nm", length));
			String[] woBlNoIssFlg = (JSPUtil.getParameter(request, prefix + "wo_bl_no_iss_flg", length));
			String[] trspSoTpCd = (JSPUtil.getParameter(request, prefix + "trsp_so_tp_cd", length));
			String[] revCurrCd = (JSPUtil.getParameter(request, prefix + "rev_curr_cd", length));
			String[] woRmk = (JSPUtil.getParameter(request, prefix + "wo_rmk", length));
			String[] defaultSpFlg = (JSPUtil.getParameter(request, prefix + "default_sp_flg", length));
			String[] trspDfltVndrFlg = (JSPUtil.getParameter(request, prefix + "trsp_dflt_vndr_flg", length));
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix + "trsp_wo_seq", length));
			String[] fdrVvd = (JSPUtil.getParameter(request, prefix + "fdr_vvd", length));
			String[] surchargeKey = (JSPUtil.getParameter(request, prefix + "surcharge_key", length));
			String[] poCustSeq = (JSPUtil.getParameter(request, prefix + "po_cust_seq", length));
			String[] cntcPsonPhnNo = (JSPUtil.getParameter(request, prefix + "cntc_pson_phn_no", length));
			String[] cntrLbsWgt = (JSPUtil.getParameter(request, prefix + "cntr_lbs_wgt", length));
			String[] soCreDt = (JSPUtil.getParameter(request, prefix + "so_cre_dt", length));
			String[] poSpType = (JSPUtil.getParameter(request, prefix + "po_sp_type", length));
			String[] bkgspe = (JSPUtil.getParameter(request, prefix + "bkgspe", length));
			String[] costActGrpCd = (JSPUtil.getParameter(request, prefix + "cost_act_grp_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
			String[] wgtMeasUtCd = (JSPUtil.getParameter(request, prefix + "wgt_meas_ut_cd", length));
			String[] trspSoOfcCtyCdSeq = (JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd_seq", length));
			String[] troCfmOfcCd = (JSPUtil.getParameter(request, prefix + "tro_cfm_ofc_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
			String[] poRtnMsg = (JSPUtil.getParameter(request, prefix + "po_rtn_msg", length));
			String[] refId = (JSPUtil.getParameter(request, prefix + "ref_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
			String[] toYardValue = (JSPUtil.getParameter(request, prefix + "to_yard_value", length));
			String[] trspRqstBkgFlg = (JSPUtil.getParameter(request, prefix + "trsp_rqst_bkg_flg", length));
			String[] lane = (JSPUtil.getParameter(request, prefix + "lane", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", length));
			String[] n3ptyBzcCurrCd = (JSPUtil.getParameter(request, prefix + "n3pty_bzc_curr_cd", length));
			String[] poCustCntCd = (JSPUtil.getParameter(request, prefix + "po_cust_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] poCustCntCdSeq = (JSPUtil.getParameter(request, prefix + "po_cust_cnt_cd_seq", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix + "eq_no", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix + "usr_nm", length));
			String[] dorYardValue = (JSPUtil.getParameter(request, prefix + "dor_yard_value", length));
			String[] woEdiUseFlg = (JSPUtil.getParameter(request, prefix + "wo_edi_use_flg", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix + "cntc_pson_nm", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
			String[] moreCandidates = (JSPUtil.getParameter(request, prefix + "more_candidates", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix + "spcl_instr_rmk", length));
			String[] revenue = (JSPUtil.getParameter(request, prefix + "revenue", length));
			String[] presetVndrSeq = (JSPUtil.getParameter(request, prefix + "preset_vndr_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
			String[] etcAddAmt = (JSPUtil.getParameter(request, prefix + "etc_add_amt", length));
			String[] woTotAmtUsd = (JSPUtil.getParameter(request, prefix + "wo_tot_amt_usd", length));
			String[] cngCateSubCd = (JSPUtil.getParameter(request, prefix + "cng_cate_sub_cd", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", length));
			String[] poWayType = (JSPUtil.getParameter(request, prefix + "po_way_type", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix + "tro_seq", length));
			String[] dorNodPlnTm = (JSPUtil.getParameter(request, prefix + "dor_nod_pln_tm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
			String[] spType = (JSPUtil.getParameter(request, prefix + "sp_type", length));
			String[] troCfmUpdDt = (JSPUtil.getParameter(request, prefix + "tro_cfm_upd_dt", length));
			String[] poRtnCd = (JSPUtil.getParameter(request, prefix + "po_rtn_cd", length));
			String[] bkgTroNo = (JSPUtil.getParameter(request, prefix + "bkg_tro_no", length));
			String[] previousVal = (JSPUtil.getParameter(request, prefix + "previous_val", length));
			String[] rejectedCheck = (JSPUtil.getParameter(request, prefix + "rejected_check", length));
			String[] obVvdCd = (JSPUtil.getParameter(request, prefix + "ob_vvd_cd", length));
			String[] poLocalCurrCd = (JSPUtil.getParameter(request, prefix + "po_local_curr_cd", length));
			String[] ntfyCustNm = (JSPUtil.getParameter(request, prefix + "ntfy_cust_nm", length));
			String[] dorLocValue = (JSPUtil.getParameter(request, prefix + "dor_loc_value", length));
			String[] trspSoCmbSeq = (JSPUtil.getParameter(request, prefix + "trsp_so_cmb_seq", length));
			String[] trspWoOfcCtyCdSeq = (JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd_seq", length));
			String[] custNomiTrkrFlg = (JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_flg", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix + "ecc_cd", length));
			String[] cngIndFlg = (JSPUtil.getParameter(request, prefix + "cng_ind_flg", length));
			String[] rCct = (JSPUtil.getParameter(request, prefix + "r_cct", length));
			String[] tCct = (JSPUtil.getParameter(request, prefix + "t_cct", length));
			String[] kgsNetWgt = (JSPUtil.getParameter(request, prefix + "kgs_net_wgt", length));
			String[] kgsTareWgt = (JSPUtil.getParameter(request, prefix + "kgs_tare_wgt", length));
			String[] kgsGrossWgt = (JSPUtil.getParameter(request, prefix + "kgs_gross_wgt", length));
			String[] lbsNetWgt = (JSPUtil.getParameter(request, prefix + "lbs_net_wgt", length));
			String[] lbsTareWgt = (JSPUtil.getParameter(request, prefix + "lbs_tare_wgt", length));
			String[] lbsGrossWgt = (JSPUtil.getParameter(request, prefix + "lbs_gross_wgt", length));
			String[] cngIndFlgImg = (JSPUtil.getParameter(request, prefix + "cng_ind_flg_img", length));
			String[] vndrCm = (JSPUtil.getParameter(request, prefix + "vndr_cm", length));
			String[] vndrCmImg = (JSPUtil.getParameter(request, prefix + "vndr_cm_img", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix + "crnt_yd_cd", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix + "cnmv_dt", length));
			String[] copFlg = (JSPUtil.getParameter(request, prefix + "cop_flg", length));
			String[] copEqNo = (JSPUtil.getParameter(request, prefix + "cop_eq_no", length));
			String[] interRmkImg = (JSPUtil.getParameter(request, prefix + "inter_rmk_img", length));
			String[] cgoFrtRcvIndFlg = (JSPUtil.getParameter(request, prefix + "cgo_frt_rcv_ind_flg", length));
			String[] cgoOblRcvIndFlg = (JSPUtil.getParameter(request, prefix + "cgo_obl_rcv_ind_flg", length));
			String[] cgoCstmsClrIndFlg = (JSPUtil.getParameter(request, prefix + "cgo_cstms_clr_ind_flg", length));
			String[] cntrPkupNo = (JSPUtil.getParameter(request, prefix + "cntr_pkup_no", length));
			String[] foFlg = (JSPUtil.getParameter(request, prefix + "fo_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
			String[] bkgStsCdNm = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd_nm", length));
			String[] pwrSplCblFlg = (JSPUtil.getParameter(request, prefix + "pwr_spl_cbl_flg", length));
			String[] cntrSltNo = (JSPUtil.getParameter(request, prefix + "cntr_slt_no", length));
			String[] rvnMptCntr = (JSPUtil.getParameter(request, prefix + "rvn_mpt_cntr", length));
			String[] doHldFlg = (JSPUtil.getParameter(request, prefix + "do_hld_flg", length));
			String[] fmNodCdNm = (JSPUtil.getParameter(request, prefix + "fm_nod_cd_nm", length));
			String[] viaNodCdNm = (JSPUtil.getParameter(request, prefix + "via_nod_cd_nm", length));
			String[] toNodCdNm = (JSPUtil.getParameter(request, prefix + "to_nod_cd_nm", length));
			String[] dorNodCdNm = (JSPUtil.getParameter(request, prefix + "dor_nod_cd_nm", length));
			String[] porCdNm = (JSPUtil.getParameter(request, prefix + "por_cd_nm", length));
			String[] polCdNm = (JSPUtil.getParameter(request, prefix + "pol_cd_nm", length));
			String[] podCdNm = (JSPUtil.getParameter(request, prefix + "pod_cd_nm", length));
			String[] delCdNm = (JSPUtil.getParameter(request, prefix + "del_cd_nm", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix + "conti_cd", length));
			String[] scgIndCd = (JSPUtil.getParameter(request, prefix + "scg_ind_cd", length));
			String[] vgmKgsWgt = (JSPUtil.getParameter(request, prefix + "vgm_kgs_wgt", length));
			String[] vgmLbsWgt = (JSPUtil.getParameter(request, prefix + "vgm_lbs_wgt", length));
			String[] ibcheck = (JSPUtil.getParameter(request, prefix + "ibcheck", length));

			for (int i = 0; i < length; i++) {
				model = new WoIssueListVO();
				if (ibVvdCd[i] != null)
					model.setIbVvdCd(ibVvdCd[i]);
				if (n3ptyBzcTpCd[i] != null)
					model.setN3ptyBzcTpCd(n3ptyBzcTpCd[i]);
				if (troCfmUpdTm[i] != null)
					model.setTroCfmUpdTm(troCfmUpdTm[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (poLocalCurrTotAmt[i] != null)
					model.setPoLocalCurrTotAmt(poLocalCurrTotAmt[i]);
				if (cngCateCd[i] != null)
					model.setCngCateCd(cngCateCd[i]);
				if (trspAgmtRtTpNm[i] != null)
					model.setTrspAgmtRtTpNm(trspAgmtRtTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3ptyBzcCustSeq[i] != null)
					model.setN3ptyBzcCustSeq(n3ptyBzcCustSeq[i]);
				if (dorPstCd[i] != null)
					model.setDorPstCd(dorPstCd[i]);
				if (poFuelScgRt[i] != null)
					model.setPoFuelScgRt(poFuelScgRt[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (trspFrstFlg[i] != null)
					model.setTrspFrstFlg(trspFrstFlg[i]);
				if (trspSoTpNm[i] != null)
					model.setTrspSoTpNm(trspSoTpNm[i]);
				if (poUsdCurrTotAmt[i] != null)
					model.setPoUsdCurrTotAmt(poUsdCurrTotAmt[i]);
				if (woIssued[i] != null)
					model.setWoIssued(woIssued[i]);
				if (nowReadVal[i] != null)
					model.setNowReadVal(nowReadVal[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (poCustNomiTrkrFlg[i] != null)
					model.setPoCustNomiTrkrFlg(poCustNomiTrkrFlg[i]);
				if (cgoTpNm[i] != null)
					model.setCgoTpNm(cgoTpNm[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (trspSoCmbTpCd[i] != null)
					model.setTrspSoCmbTpCd(trspSoCmbTpCd[i]);
				if (troCfmUsrId[i] != null)
					model.setTroCfmUsrId(troCfmUsrId[i]);
				if (mtyRrFlg[i] != null)
					model.setMtyRrFlg(mtyRrFlg[i]);
				if (trspCostDtlModNm[i] != null)
					model.setTrspCostDtlModNm(trspCostDtlModNm[i]);
				if (poBasicRt[i] != null)
					model.setPoBasicRt(poBasicRt[i]);
				if (woRjctDt[i] != null)
					model.setWoRjctDt(woRjctDt[i]);
				if (actCustCd[i] != null)
					model.setActCustCd(actCustCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (negoAmt[i] != null)
					model.setNegoAmt(negoAmt[i]);
				if (woTotAmt[i] != null)
					model.setWoTotAmt(woTotAmt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (n3ptyBzcDesc[i] != null)
					model.setN3ptyBzcDesc(n3ptyBzcDesc[i]);
				if (fctryNm[i] != null)
					model.setFctryNm(fctryNm[i]);
				if (loclUpdDt[i] != null)
					model.setLoclUpdDt(loclUpdDt[i]);
				if (cancelCheck[i] != null)
					model.setCancelCheck(cancelCheck[i]);
				if (woIssStsCd[i] != null)
					model.setWoIssStsCd(woIssStsCd[i]);
				if (distance[i] != null)
					model.setDistance(distance[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (poTrspAgmtRtTpNm[i] != null)
					model.setPoTrspAgmtRtTpNm(poTrspAgmtRtTpNm[i]);
				if (n3ptyBzcCustCntCd[i] != null)
					model.setN3ptyBzcCustCntCd(n3ptyBzcCustCntCd[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (fmYardValue[i] != null)
					model.setFmYardValue(fmYardValue[i]);
				if (fmLocValue[i] != null)
					model.setFmLocValue(fmLocValue[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (viaYardValue[i] != null)
					model.setViaYardValue(viaYardValue[i]);
				if (shprCustNm[i] != null)
					model.setShprCustNm(shprCustNm[i]);
				if (trspAgmtWyTpCd[i] != null)
					model.setTrspAgmtWyTpCd(trspAgmtWyTpCd[i]);
				if (trspRjctRsnCd[i] != null)
					model.setTrspRjctRsnCd(trspRjctRsnCd[i]);
				if (poOverWgtScgRt[i] != null)
					model.setPoOverWgtScgRt(poOverWgtScgRt[i]);
				if (lstNodPlnDt[i] != null)
					model.setLstNodPlnDt(lstNodPlnDt[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (bzcAmt[i] != null)
					model.setBzcAmt(bzcAmt[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (fuelScgAmt[i] != null)
					model.setFuelScgAmt(fuelScgAmt[i]);
				if (n3ptyBzcOfcCd[i] != null)
					model.setN3ptyBzcOfcCd(n3ptyBzcOfcCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (custCntCdSeq[i] != null)
					model.setCustCntCdSeq(custCntCdSeq[i]);
				if (n3ptyBilFlg[i] != null)
					model.setN3ptyBilFlg(n3ptyBilFlg[i]);
				if (toLocValue[i] != null)
					model.setToLocValue(toLocValue[i]);
				if (distanceUom[i] != null)
					model.setDistanceUom(distanceUom[i]);
				if (woCreNm[i] != null)
					model.setWoCreNm(woCreNm[i]);
				if (viaLocValue[i] != null)
					model.setViaLocValue(viaLocValue[i]);
				if (cneeCustNm[i] != null)
					model.setCneeCustNm(cneeCustNm[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (woRjctIndct[i] != null)
					model.setWoRjctIndct(woRjctIndct[i]);
				if (n1stNodPlnDt[i] != null)
					model.setN1stNodPlnDt(n1stNodPlnDt[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (n3ptyBzcAmt[i] != null)
					model.setN3ptyBzcAmt(n3ptyBzcAmt[i]);
				if (n1stNodPlnTm[i] != null)
					model.setN1stNodPlnTm(n1stNodPlnTm[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (cntrKgsWgt[i] != null)
					model.setCntrKgsWgt(cntrKgsWgt[i]);
				if (colNm[i] != null)
					model.setColNm(colNm[i]);
				if (troCnfm[i] != null)
					model.setTroCnfm(troCnfm[i]);
				if (dtnUseFlg[i] != null)
					model.setDtnUseFlg(dtnUseFlg[i]);
				if (trspCrrModNm[i] != null)
					model.setTrspCrrModNm(trspCrrModNm[i]);
				if (bundlingNo[i] != null)
					model.setBundlingNo(bundlingNo[i]);
				if (n3ptyBzcVndrSeq[i] != null)
					model.setN3ptyBzcVndrSeq(n3ptyBzcVndrSeq[i]);
				if (trsSubStsCd[i] != null)
					model.setTrsSubStsCd(trsSubStsCd[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (dorDeAddr[i] != null)
					model.setDorDeAddr(dorDeAddr[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (woIssueDt[i] != null)
					model.setWoIssueDt(woIssueDt[i]);
				if (soCreNm[i] != null)
					model.setSoCreNm(soCreNm[i]);
				if (lstNodPlnTm[i] != null)
					model.setLstNodPlnTm(lstNodPlnTm[i]);
				if (poTrspAgmtSeq[i] != null)
					model.setPoTrspAgmtSeq(poTrspAgmtSeq[i]);
				if (spclCgoCntrTpCd[i] != null)
					model.setSpclCgoCntrTpCd(spclCgoCntrTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (trspAgmtRtTpCd[i] != null)
					model.setTrspAgmtRtTpCd(trspAgmtRtTpCd[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (cntcPsonFaxNo[i] != null)
					model.setCntcPsonFaxNo(cntcPsonFaxNo[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (dorNodPlnDt[i] != null)
					model.setDorNodPlnDt(dorNodPlnDt[i]);
				if (poTrspAgmtRtTpCd[i] != null)
					model.setPoTrspAgmtRtTpCd(poTrspAgmtRtTpCd[i]);
				if (poTrspAgmtOfcCtyCd[i] != null)
					model.setPoTrspAgmtOfcCtyCd(poTrspAgmtOfcCtyCd[i]);
				if (mltStopDeFlg[i] != null)
					model.setMltStopDeFlg(mltStopDeFlg[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (trspSoCmbTpNm[i] != null)
					model.setTrspSoCmbTpNm(trspSoCmbTpNm[i]);
				if (woBlNoIssFlg[i] != null)
					model.setWoBlNoIssFlg(woBlNoIssFlg[i]);
				if (trspSoTpCd[i] != null)
					model.setTrspSoTpCd(trspSoTpCd[i]);
				if (revCurrCd[i] != null)
					model.setRevCurrCd(revCurrCd[i]);
				if (woRmk[i] != null)
					model.setWoRmk(woRmk[i]);
				if (defaultSpFlg[i] != null)
					model.setDefaultSpFlg(defaultSpFlg[i]);
				if (trspDfltVndrFlg[i] != null)
					model.setTrspDfltVndrFlg(trspDfltVndrFlg[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (fdrVvd[i] != null)
					model.setFdrVvd(fdrVvd[i]);
				if (surchargeKey[i] != null)
					model.setSurchargeKey(surchargeKey[i]);
				if (poCustSeq[i] != null)
					model.setPoCustSeq(poCustSeq[i]);
				if (cntcPsonPhnNo[i] != null)
					model.setCntcPsonPhnNo(cntcPsonPhnNo[i]);
				if (cntrLbsWgt[i] != null)
					model.setCntrLbsWgt(cntrLbsWgt[i]);
				if (soCreDt[i] != null)
					model.setSoCreDt(soCreDt[i]);
				if (poSpType[i] != null)
					model.setPoSpType(poSpType[i]);
				if (bkgspe[i] != null)
					model.setBkgspe(bkgspe[i]);
				if (costActGrpCd[i] != null)
					model.setCostActGrpCd(costActGrpCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (wgtMeasUtCd[i] != null)
					model.setWgtMeasUtCd(wgtMeasUtCd[i]);
				if (trspSoOfcCtyCdSeq[i] != null)
					model.setTrspSoOfcCtyCdSeq(trspSoOfcCtyCdSeq[i]);
				if (troCfmOfcCd[i] != null)
					model.setTroCfmOfcCd(troCfmOfcCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (poRtnMsg[i] != null)
					model.setPoRtnMsg(poRtnMsg[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (toYardValue[i] != null)
					model.setToYardValue(toYardValue[i]);
				if (trspRqstBkgFlg[i] != null)
					model.setTrspRqstBkgFlg(trspRqstBkgFlg[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (n3ptyBzcCurrCd[i] != null)
					model.setN3ptyBzcCurrCd(n3ptyBzcCurrCd[i]);
				if (poCustCntCd[i] != null)
					model.setPoCustCntCd(poCustCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (poCustCntCdSeq[i] != null)
					model.setPoCustCntCdSeq(poCustCntCdSeq[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (dorYardValue[i] != null)
					model.setDorYardValue(dorYardValue[i]);
				if (woEdiUseFlg[i] != null)
					model.setWoEdiUseFlg(woEdiUseFlg[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (moreCandidates[i] != null)
					model.setMoreCandidates(moreCandidates[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (revenue[i] != null)
					model.setRevenue(revenue[i]);
				if (presetVndrSeq[i] != null)
					model.setPresetVndrSeq(presetVndrSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (etcAddAmt[i] != null)
					model.setEtcAddAmt(etcAddAmt[i]);
				if (woTotAmtUsd[i] != null)
					model.setWoTotAmtUsd(woTotAmtUsd[i]);
				if (cngCateSubCd[i] != null)
					model.setCngCateSubCd(cngCateSubCd[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (poWayType[i] != null)
					model.setPoWayType(poWayType[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (dorNodPlnTm[i] != null)
					model.setDorNodPlnTm(dorNodPlnTm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (spType[i] != null)
					model.setSpType(spType[i]);
				if (troCfmUpdDt[i] != null)
					model.setTroCfmUpdDt(troCfmUpdDt[i]);
				if (poRtnCd[i] != null)
					model.setPoRtnCd(poRtnCd[i]);
				if (bkgTroNo[i] != null)
					model.setBkgTroNo(bkgTroNo[i]);
				if (previousVal[i] != null)
					model.setPreviousVal(previousVal[i]);
				if (rejectedCheck[i] != null)
					model.setRejectedCheck(rejectedCheck[i]);
				if (obVvdCd[i] != null)
					model.setObVvdCd(obVvdCd[i]);
				if (poLocalCurrCd[i] != null)
					model.setPoLocalCurrCd(poLocalCurrCd[i]);
				if (ntfyCustNm[i] != null)
					model.setNtfyCustNm(ntfyCustNm[i]);
				if (dorLocValue[i] != null)
					model.setDorLocValue(dorLocValue[i]);
				if (trspSoCmbSeq[i] != null)
					model.setTrspSoCmbSeq(trspSoCmbSeq[i]);
				if (trspWoOfcCtyCdSeq[i] != null)
					model.setTrspWoOfcCtyCdSeq(trspWoOfcCtyCdSeq[i]);
				if (custNomiTrkrFlg[i] != null)
					model.setCustNomiTrkrFlg(custNomiTrkrFlg[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (cngIndFlg[i] != null)
					model.setCngIndFlg(cngIndFlg[i]);
				if (rCct[i] != null)
					model.setrCct(rCct[i]);
				if (tCct[i] != null)
					model.settCct(tCct[i]);
				if (kgsNetWgt[i] != null)
					model.setKgsNetWgt(kgsNetWgt[i]);
				if (kgsTareWgt[i] != null)
					model.setKgsTareWgt(kgsTareWgt[i]);
				if (kgsGrossWgt[i] != null)
					model.setKgsGrossWgt(kgsGrossWgt[i]);
				if (lbsNetWgt[i] != null)
					model.setLbsNetWgt(lbsNetWgt[i]);
				if (lbsTareWgt[i] != null)
					model.setLbsTareWgt(lbsTareWgt[i]);
				if (lbsGrossWgt[i] != null)
					model.setLbsGrossWgt(lbsGrossWgt[i]);
				if (cngIndFlgImg[i] != null)
					model.setCngIndFlgImg(cngIndFlgImg[i]);
				if (vndrCm[i] != null)
					model.setVndrCm(vndrCm[i]);
				if (vndrCmImg[i] != null)
					model.setVndrCmImg(vndrCmImg[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (copFlg[i] != null)
					model.setCopFlg(copFlg[i]);
				if (copEqNo[i] != null)
					model.setCopEqNo(copEqNo[i]);
				if (interRmkImg[i] != null)
					model.setInterRmkImg(interRmkImg[i]);
				if (cgoFrtRcvIndFlg[i] != null)
					model.setCgoFrtRcvIndFlg(cgoFrtRcvIndFlg[i]);
				if (cgoOblRcvIndFlg[i] != null)
					model.setCgoOblRcvIndFlg(cgoOblRcvIndFlg[i]);
				if (cgoCstmsClrIndFlg[i] != null)
					model.setCgoCstmsClrIndFlg(cgoCstmsClrIndFlg[i]);
				if (cntrPkupNo[i] != null)
					model.setCntrPkupNo(cntrPkupNo[i]);
				if (foFlg[i] != null)
					model.setFoFlg(foFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bkgStsCdNm[i] != null)
					model.setBkgStsCdNm(bkgStsCdNm[i]);
				if (pwrSplCblFlg[i] != null)
					model.setPwrSplCblFlg(pwrSplCblFlg[i]);
				if (cntrSltNo[i] != null)
					model.setCntrSltNo(cntrSltNo[i]);
				if (rvnMptCntr[i] != null)
					model.setRvnMptCntr(rvnMptCntr[i]);
				if (doHldFlg[i] != null)
					model.setDoHldFlg(doHldFlg[i]);
				if (fmNodCdNm[i] != null)
					model.setFmNodCdNm(fmNodCdNm[i]);
				if (viaNodCdNm[i] != null)
					model.setViaNodCdNm(viaNodCdNm[i]);
				if (toNodCdNm[i] != null)
					model.setToNodCdNm(toNodCdNm[i]);
				if (dorNodCdNm[i] != null)
					model.setDorNodCdNm(dorNodCdNm[i]);
				if (porCdNm[i] != null)
					model.setPorCdNm(porCdNm[i]);
				if (polCdNm[i] != null)
					model.setPolCdNm(polCdNm[i]);
				if (podCdNm[i] != null)
					model.setPodCdNm(podCdNm[i]);
				if (delCdNm[i] != null)
					model.setDelCdNm(delCdNm[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (scgIndCd[i] != null)
					model.setScgIndCd(scgIndCd[i]);
				if (vgmKgsWgt[i] != null)
					model.setVgmKgsWgt(vgmKgsWgt[i]);
				if (vgmLbsWgt[i] != null)
					model.setVgmLbsWgt(vgmLbsWgt[i]);
				if (ibcheck[i] != null)
					model.setIbcheck(ibcheck[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getWoIssueListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return WoIssueListVO[]
	 */
	public WoIssueListVO[] getWoIssueListVOs() {
		WoIssueListVO[] vos = (WoIssueListVO[]) models.toArray(new WoIssueListVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.ibVvdCd = this.ibVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcTpCd = this.n3ptyBzcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmUpdTm = this.troCfmUpdTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poLocalCurrTotAmt = this.poLocalCurrTotAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngCateCd = this.cngCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtTpNm = this.trspAgmtRtTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcCustSeq = this.n3ptyBzcCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorPstCd = this.dorPstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poFuelScgRt = this.poFuelScgRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspFrstFlg = this.trspFrstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpNm = this.trspSoTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poUsdCurrTotAmt = this.poUsdCurrTotAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssued = this.woIssued.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nowReadVal = this.nowReadVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustNomiTrkrFlg = this.poCustNomiTrkrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpNm = this.cgoTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbTpCd = this.trspSoCmbTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmUsrId = this.troCfmUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRrFlg = this.mtyRrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModNm = this.trspCostDtlModNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poBasicRt = this.poBasicRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woRjctDt = this.woRjctDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCd = this.actCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoAmt = this.negoAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTotAmt = this.woTotAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcDesc = this.n3ptyBzcDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctryNm = this.fctryNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclUpdDt = this.loclUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cancelCheck = this.cancelCheck.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssStsCd = this.woIssStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distance = this.distance.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtRtTpNm = this.poTrspAgmtRtTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcCustCntCd = this.n3ptyBzcCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYardValue = this.fmYardValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocValue = this.fmLocValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaYardValue = this.viaYardValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustNm = this.shprCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtWyTpCd = this.trspAgmtWyTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRjctRsnCd = this.trspRjctRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poOverWgtScgRt = this.poOverWgtScgRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstNodPlnDt = this.lstNodPlnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt = this.bzcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelScgAmt = this.fuelScgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcOfcCd = this.n3ptyBzcOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCdSeq = this.custCntCdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilFlg = this.n3ptyBilFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocValue = this.toLocValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distanceUom = this.distanceUom.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCreNm = this.woCreNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaLocValue = this.viaLocValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCustNm = this.cneeCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woRjctIndct = this.woRjctIndct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodPlnDt = this.n1stNodPlnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcAmt = this.n3ptyBzcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodPlnTm = this.n1stNodPlnTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrKgsWgt = this.cntrKgsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNm = this.colNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCnfm = this.troCnfm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtnUseFlg = this.dtnUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModNm = this.trspCrrModNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bundlingNo = this.bundlingNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcVndrSeq = this.n3ptyBzcVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsSubStsCd = this.trsSubStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorDeAddr = this.dorDeAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssueDt = this.woIssueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreNm = this.soCreNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstNodPlnTm = this.lstNodPlnTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtSeq = this.poTrspAgmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCntrTpCd = this.spclCgoCntrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtTpCd = this.trspAgmtRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonFaxNo = this.cntcPsonFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodPlnDt = this.dorNodPlnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtRtTpCd = this.poTrspAgmtRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtOfcCtyCd = this.poTrspAgmtOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltStopDeFlg = this.mltStopDeFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbTpNm = this.trspSoCmbTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woBlNoIssFlg = this.woBlNoIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpCd = this.trspSoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCurrCd = this.revCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woRmk = this.woRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.defaultSpFlg = this.defaultSpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDfltVndrFlg = this.trspDfltVndrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq = this.trspWoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVvd = this.fdrVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surchargeKey = this.surchargeKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustSeq = this.poCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonPhnNo = this.cntcPsonPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLbsWgt = this.cntrLbsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreDt = this.soCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poSpType = this.poSpType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgspe = this.bkgspe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpCd = this.costActGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtMeasUtCd = this.wgtMeasUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCdSeq = this.trspSoOfcCtyCdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmOfcCd = this.troCfmOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poRtnMsg = this.poRtnMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYardValue = this.toYardValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRqstBkgFlg = this.trspRqstBkgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcCurrCd = this.n3ptyBzcCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustCntCd = this.poCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustCntCdSeq = this.poCustCntCdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorYardValue = this.dorYardValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woEdiUseFlg = this.woEdiUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.moreCandidates = this.moreCandidates.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revenue = this.revenue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.presetVndrSeq = this.presetVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcAddAmt = this.etcAddAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTotAmtUsd = this.woTotAmtUsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngCateSubCd = this.cngCateSubCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poWayType = this.poWayType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodPlnTm = this.dorNodPlnTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spType = this.spType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmUpdDt = this.troCfmUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poRtnCd = this.poRtnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTroNo = this.bkgTroNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.previousVal = this.previousVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejectedCheck = this.rejectedCheck.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obVvdCd = this.obVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poLocalCurrCd = this.poLocalCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCustNm = this.ntfyCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorLocValue = this.dorLocValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbSeq = this.trspSoCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCdSeq = this.trspWoOfcCtyCdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrFlg = this.custNomiTrkrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngIndFlg = this.cngIndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rCct = this.rCct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCct = this.tCct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kgsNetWgt = this.kgsNetWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kgsTareWgt = this.kgsTareWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kgsGrossWgt = this.kgsGrossWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbsNetWgt = this.lbsNetWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbsTareWgt = this.lbsTareWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbsGrossWgt = this.lbsGrossWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngIndFlgImg = this.cngIndFlgImg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCm = this.vndrCm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCmImg = this.vndrCmImg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copFlg = this.copFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copEqNo = this.copEqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmkImg = this.interRmkImg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoFrtRcvIndFlg = this.cgoFrtRcvIndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoOblRcvIndFlg = this.cgoOblRcvIndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCstmsClrIndFlg = this.cgoCstmsClrIndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupNo = this.cntrPkupNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foFlg = this.foFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCdNm = this.bkgStsCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pwrSplCblFlg = this.pwrSplCblFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSltNo = this.cntrSltNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvnMptCntr = this.rvnMptCntr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doHldFlg = this.doHldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCdNm = this.fmNodCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCdNm = this.viaNodCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCdNm = this.toNodCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCdNm = this.dorNodCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCdNm = this.porCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCdNm = this.polCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCdNm = this.podCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCdNm = this.delCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgIndCd = this.scgIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmKgsWgt = this.vgmKgsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmLbsWgt = this.vgmLbsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcheck = this.ibcheck.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}