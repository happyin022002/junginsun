/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WoIssueListVO.java
*@FileTitle : WoIssueListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2016.06.24 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최종혁
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
	private String poVatScgRt = null;
	/* Column Info */
	private String trspAgmtRtTpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3ptyBzcCustSeq = null;
	/* Column Info */
	private String poFuelScgRt = null;
	/* Column Info */
	private String poUsdCurrTotAmt = null;
	/* Column Info */
	private String cntFlg = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String mtyRrFlg = null;
	/* Column Info */
	private String troCfmUsrId = null;
	/* Column Info */
	private String trspCostDtlModNm = null;
	/* Column Info */
	private String actCustCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String negoAmt = null;
	/* Column Info */
	private String n3ptyBzcDesc = null;
	/* Column Info */
	private String fctryNm = null;
	/* Column Info */
	private String scgVatAmt = null;
	/* Column Info */
	private String poAgmtUpdDt = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String poCustNomiTrkrIndCd = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String fmLocValue = null;
	/* Column Info */
	private String fmYardValue = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String trspAgmtWyTpCd = null;
	/* Column Info */
	private String deliTimeHms = null;
	/* Column Info */
	private String trspRjctRsnCd = null;
	/* Column Info */
	private String lstNodPlnDt = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String fuelScgAmt = null;
	/* Column Info */
	private String trspSpCngRsnRmk = null;
	/* Column Info */
	private String n3ptyBilFlg = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String n1stNodPlnDt = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String n1stNodPlnTm = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String ttlDist = null;
	/* Column Info */
	private String cntrKgsWgt = null;
	/* Column Info */
	private String bundlingNo = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String soCreNm = null;
	/* Column Info */
	private String spclCgoCntrTpCd = null;
	/* Column Info */
	private String trspAgmtRtTpCd = null;
	/* Column Info */
	private String hzdMtrlFlg = null;
	/* Column Info */
	private String dorNodPlnDt = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String trspSoCmbTpNm = null;
	/* Column Info */
	private String woBlNoIssFlg = null;
	/* Column Info */
	private String woRmk = null;
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String surchargeKey = null;
	/* Column Info */
	private String fdrVvd = null;
	/* Column Info */
	private String costActGrpCd = null;
	/* Column Info */
	private String vgmFlg = null;
	/* Column Info */
	private String wgtMeasUtCd = null;
	/* Column Info */
	private String troCfmOfcCd = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String toYardValue = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mcntrBdlSeq = null;
	/* Column Info */
	private String ctrtTpCd = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dorYardValue = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String poAgmtRtSeq = null;
	/* Column Info */
	private String presetVndrSeq = null;
	/* Column Info */
	private String etcAddAmt = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String poWayType = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String spType = null;
	/* Column Info */
	private String bkgTroNo = null;
	/* Column Info */
	private String poScg3Rt = null;
	/* Column Info */
	private String rejectedCheck = null;
	/* Column Info */
	private String appoTimeDt = null;
	/* Column Info */
	private String obVvdCd = null;
	/* Column Info */
	private String trspSoCmbSeq = null;
	/* Column Info */
	private String vgmWgtUtCd = null;
	/* Column Info */
	private String ctrtTpFlg = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String poLocalCurrTotAmt = null;
	/* Column Info */
	private String orgCurrCd = null;
	/* Column Info */
	private String poScg1Rt = null;
	/* Column Info */
	private String lnkDistDivCd = null;
	/* Column Info */
	private String dorPstCd = null;
	/* Column Info */
	private String trspFrstFlg = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String trspSoTpNm = null;
	/* Column Info */
	private String tollFeeAmt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String poCustNomiTrkrFlg = null;
	/* Column Info */
	private String cgoTpNm = null;
	/* Column Info */
	private String trspSoCmbTpCd = null;
	/* Column Info */
	private String poBasicRt = null;
	/* Column Info */
	private String woRjctDt = null;
	/* Column Info */
	private String poWtrRcvTermCd = null;
	/* Column Info */
	private String woTotAmt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bundlingFlg = null;
	/* Column Info */
	private String cancelCheck = null;
	/* Column Info */
	private String distance = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String n3ptyBzcCustCntCd = null;
	/* Column Info */
	private String poTrspAgmtRtTpNm = null;
	/* Column Info */
	private String agmtMorCnddtAplyFlg = null;
	/* Column Info */
	private String viaYardValue = null;
	/* Column Info */
	private String shprCustNm = null;
	/* Column Info */
	private String poWtrDeTermCd = null;
	/* Column Info */
	private String poOverWgtScgRt = null;
	/* Column Info */
	private String mcntrBdlGrpSeq = null;
	/* Column Info */
	private String bzcAmt = null;
	/* Column Info */
	private String n3ptyBzcOfcCd = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String custCntCdSeq = null;
	/* Column Info */
	private String distanceUom = null;
	/* Column Info */
	private String toLocValue = null;
	/* Column Info */
	private String cneeCustNm = null;
	/* Column Info */
	private String viaLocValue = null;
	/* Column Info */
	private String woCreNm = null;
	/* Column Info */
	private String woRjctIndct = null;
	/* Column Info */
	private String n3ptyBzcAmt = null;
	/* Column Info */
	private String ovwtTriAxlFlg = null;
	/* Column Info */
	private String dtnUseFlg = null;
	/* Column Info */
	private String troCnfm = null;
	/* Column Info */
	private String n3ptyBzcVndrSeq = null;
	/* Column Info */
	private String trspCrrModNm = null;
	/* Column Info */
	private String dorDeAddr = null;
	/* Column Info */
	private String woIssueDt = null;
	/* Column Info */
	private String poTrspAgmtSeq = null;
	/* Column Info */
	private String lstNodPlnTm = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String poScg2Rt = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String cntcPsonFaxNo = null;
	/* Column Info */
	private String poTrspAgmtRtTpCd = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String poTrspAgmtOfcCtyCd = null;
	/* Column Info */
	private String mltStopDeFlg = null;
	/* Column Info */
	private String trspSoTpCd = null;
	/* Column Info */
	private String revCurrCd = null;
	/* Column Info */
	private String defaultSpFlg = null;
	/* Column Info */
	private String trspDfltVndrFlg = null;
	/* Column Info */
	private String poCustSeq = null;
	/* Column Info */
	private String cntcPsonPhnNo = null;
	/* Column Info */
	private String soCreDt = null;
	/* Column Info */
	private String cntrLbsWgt = null;
	/* Column Info */
	private String poSpType = null;
	/* Column Info */
	private String bkgspe = null;
	/* Column Info */
	private String deliTimeDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String trspSoOfcCtyCdSeq = null;
	/* Column Info */
	private String poCfmFlg = null;
	/* Column Info */
	private String ctrtCnt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String poRtnMsg = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String trspSpCngRsnCd = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String trspRqstBkgFlg = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String n3ptyBzcCurrCd = null;
	/* Column Info */
	private String poCustCntCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String poCustCntCdSeq = null;
	/* Column Info */
	private String negoRmk = null;
	/* Column Info */
	private String woEdiUseFlg = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String moreCandidates = null;
	/* Column Info */
	private String spclInstrRmk = null;
	/* Column Info */
	private String revenue = null;
	/* Column Info */
	private String appoTimeHms = null;
	/* Column Info */
	private String woTotAmtUsd = null;
	/* Column Info */
	private String dorNodPlnTm = null;
	/* Column Info */
	private String orgNegoAmt = null;
	/* Column Info */
	private String troCfmUpdDt = null;
	/* Column Info */
	private String poRtnCd = null;
	/* Column Info */
	private String poLocalCurrCd = null;
	/* Column Info */
	private String dorLocValue = null;
	/* Column Info */
	private String ntfyCustNm = null;
	/* Column Info */
	private String trspWoOfcCtyCdSeq = null;
	/* Column Info */
	private String custNomiTrkrFlg = null;
	
	private String blckStwg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public WoIssueListVO() {}

	public WoIssueListVO(String ibflag, String pagerows, String vgmWgtUtCd, String ibVvdCd, String n3ptyBzcTpCd, String troCfmUpdTm, String ctrtTpFlg, String cgoTpCd, String poLocalCurrTotAmt, String poVatScgRt, String orgCurrCd, String poScg1Rt, String lnkDistDivCd, String trspAgmtRtTpNm, String n3ptyBzcCustSeq, String dorPstCd, String poFuelScgRt, String tVvd, String trspFrstFlg, String trspSoTpNm, String poUsdCurrTotAmt, String tollFeeAmt, String custCntCd, String poCustNomiTrkrFlg, String cgoTpNm, String cntFlg, String cntrWgt, String trspSoCmbTpCd, String mtyRrFlg, String troCfmUsrId, String trspCostDtlModNm, String poBasicRt, String woRjctDt, String actCustCd, String eqTpszCd, String poWtrRcvTermCd, String woTotAmt, String negoAmt, String bkgNo, String n3ptyBzcDesc, String fctryNm, String bundlingFlg, String cancelCheck, String poAgmtUpdDt, String distance, String interRmk, String cmdtCd, String poCustNomiTrkrIndCd, String agmtMorCnddtAplyFlg, String poTrspAgmtRtTpNm, String n3ptyBzcCustCntCd, String bkgQty, String dorNodCd, String fmYardValue, String fmLocValue, String trspCrrModCd, String viaYardValue, String poWtrDeTermCd, String shprCustNm, String deliTimeHms, String trspAgmtWyTpCd, String trspRjctRsnCd, String lstNodPlnDt, String poOverWgtScgRt, String mcntrBdlGrpSeq, String eqKndCd, String bzcAmt, String trspSpCngRsnRmk, String trspWoOfcCtyCd, String fuelScgAmt, String n3ptyBzcOfcCd, String fmNodCd, String custCntCdSeq, String n3ptyBilFlg, String toLocValue, String distanceUom, String woCreNm, String viaLocValue, String cneeCustNm, String costActGrpSeq, String woRjctIndct, String n1stNodPlnDt, String viaNodCd, String n3ptyBzcAmt, String n1stNodPlnTm, String cntrKgsWgt, String ttlDist, String toNodCd, String ovwtTriAxlFlg, String troCnfm, String dtnUseFlg, String trspCrrModNm, String bundlingNo, String n3ptyBzcVndrSeq, String trspSoSeq, String dorDeAddr, String copNo, String woIssueDt, String poTrspAgmtSeq, String lstNodPlnTm, String soCreNm, String blNo, String spclCgoCntrTpCd, String trspAgmtRtTpCd, String poScg2Rt, String vndrNm, String ctrtNo, String hzdMtrlFlg, String cntcPsonFaxNo, String poTrspAgmtRtTpCd, String dorNodPlnDt, String trspCostDtlModCd, String poTrspAgmtOfcCtyCd, String mltStopDeFlg, String scNo, String wgtUtCd, String trspSoCmbTpNm, String woBlNoIssFlg, String trspSoTpCd, String revCurrCd, String woRmk, String defaultSpFlg, String trspWoSeq, String trspDfltVndrFlg, String surchargeKey, String fdrVvd, String poCustSeq, String cntcPsonPhnNo, String soCreDt, String cntrLbsWgt, String poSpType, String bkgspe, String deliTimeDt, String costActGrpCd, String vndrSeq, String wgtMeasUtCd, String trspSoOfcCtyCdSeq, String troCfmOfcCd, String poCfmFlg, String contiCd, String ctrtCnt, String currCd, String poRtnMsg, String toYardValue, String creDt, String refId, String trspSpCngRsnCd, String mcntrBdlSeq, String ctrtTpCd, String vgmWgt, String trspRqstBkgFlg, String trspSoOfcCtyCd, String lane, String n3ptyBzcCurrCd, String rfaNo, String poCustCntCd, String eqNo, String poCustCntCdSeq, String negoRmk, String woEdiUseFlg, String dorYardValue, String creOfcCd, String cntcPsonNm, String poAgmtRtSeq, String moreCandidates, String spclInstrRmk, String presetVndrSeq, String revenue, String etcAddAmt, String appoTimeHms, String woTotAmtUsd, String trspBndCd, String poWayType, String troSeq, String dorNodPlnTm, String custSeq, String spType, String orgNegoAmt, String troCfmUpdDt, String bkgTroNo, String poRtnCd, String poScg3Rt, String rejectedCheck, String appoTimeDt, String obVvdCd, String poLocalCurrCd, String dorLocValue, String ntfyCustNm, String trspWoOfcCtyCdSeq, String trspSoCmbSeq, String custNomiTrkrFlg, String scgVatAmt, String vgmFlg, String blckStwg) {
		this.ibVvdCd = ibVvdCd;
		this.n3ptyBzcTpCd = n3ptyBzcTpCd;
		this.troCfmUpdTm = troCfmUpdTm;
		this.poVatScgRt = poVatScgRt;
		this.trspAgmtRtTpNm = trspAgmtRtTpNm;
		this.pagerows = pagerows;
		this.n3ptyBzcCustSeq = n3ptyBzcCustSeq;
		this.poFuelScgRt = poFuelScgRt;
		this.poUsdCurrTotAmt = poUsdCurrTotAmt;
		this.cntFlg = cntFlg;
		this.cntrWgt = cntrWgt;
		this.mtyRrFlg = mtyRrFlg;
		this.troCfmUsrId = troCfmUsrId;
		this.trspCostDtlModNm = trspCostDtlModNm;
		this.actCustCd = actCustCd;
		this.eqTpszCd = eqTpszCd;
		this.negoAmt = negoAmt;
		this.n3ptyBzcDesc = n3ptyBzcDesc;
		this.fctryNm = fctryNm;
		this.scgVatAmt = scgVatAmt;
		this.poAgmtUpdDt = poAgmtUpdDt;
		this.interRmk = interRmk;
		this.bkgQty = bkgQty;
		this.poCustNomiTrkrIndCd = poCustNomiTrkrIndCd;
		this.dorNodCd = dorNodCd;
		this.fmLocValue = fmLocValue;
		this.fmYardValue = fmYardValue;
		this.trspCrrModCd = trspCrrModCd;
		this.trspAgmtWyTpCd = trspAgmtWyTpCd;
		this.deliTimeHms = deliTimeHms;
		this.trspRjctRsnCd = trspRjctRsnCd;
		this.lstNodPlnDt = lstNodPlnDt;
		this.eqKndCd = eqKndCd;
		this.fuelScgAmt = fuelScgAmt;
		this.trspSpCngRsnRmk = trspSpCngRsnRmk;
		this.n3ptyBilFlg = n3ptyBilFlg;
		this.costActGrpSeq = costActGrpSeq;
		this.n1stNodPlnDt = n1stNodPlnDt;
		this.viaNodCd = viaNodCd;
		this.n1stNodPlnTm = n1stNodPlnTm;
		this.toNodCd = toNodCd;
		this.ttlDist = ttlDist;
		this.cntrKgsWgt = cntrKgsWgt;
		this.bundlingNo = bundlingNo;
		this.trspSoSeq = trspSoSeq;
		this.copNo = copNo;
		this.soCreNm = soCreNm;
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
		this.trspAgmtRtTpCd = trspAgmtRtTpCd;
		this.hzdMtrlFlg = hzdMtrlFlg;
		this.dorNodPlnDt = dorNodPlnDt;
		this.scNo = scNo;
		this.wgtUtCd = wgtUtCd;
		this.trspSoCmbTpNm = trspSoCmbTpNm;
		this.woBlNoIssFlg = woBlNoIssFlg;
		this.woRmk = woRmk;
		this.trspWoSeq = trspWoSeq;
		this.surchargeKey = surchargeKey;
		this.fdrVvd = fdrVvd;
		this.costActGrpCd = costActGrpCd;
		this.vgmFlg = vgmFlg;
		this.wgtMeasUtCd = wgtMeasUtCd;
		this.troCfmOfcCd = troCfmOfcCd;
		this.contiCd = contiCd;
		this.toYardValue = toYardValue;
		this.creDt = creDt;
		this.mcntrBdlSeq = mcntrBdlSeq;
		this.ctrtTpCd = ctrtTpCd;
		this.lane = lane;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.dorYardValue = dorYardValue;
		this.cntcPsonNm = cntcPsonNm;
		this.poAgmtRtSeq = poAgmtRtSeq;
		this.presetVndrSeq = presetVndrSeq;
		this.etcAddAmt = etcAddAmt;
		this.trspBndCd = trspBndCd;
		this.poWayType = poWayType;
		this.troSeq = troSeq;
		this.custSeq = custSeq;
		this.spType = spType;
		this.bkgTroNo = bkgTroNo;
		this.poScg3Rt = poScg3Rt;
		this.rejectedCheck = rejectedCheck;
		this.appoTimeDt = appoTimeDt;
		this.obVvdCd = obVvdCd;
		this.trspSoCmbSeq = trspSoCmbSeq;
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.ctrtTpFlg = ctrtTpFlg;
		this.cgoTpCd = cgoTpCd;
		this.poLocalCurrTotAmt = poLocalCurrTotAmt;
		this.orgCurrCd = orgCurrCd;
		this.poScg1Rt = poScg1Rt;
		this.lnkDistDivCd = lnkDistDivCd;
		this.dorPstCd = dorPstCd;
		this.trspFrstFlg = trspFrstFlg;
		this.tVvd = tVvd;
		this.trspSoTpNm = trspSoTpNm;
		this.tollFeeAmt = tollFeeAmt;
		this.custCntCd = custCntCd;
		this.poCustNomiTrkrFlg = poCustNomiTrkrFlg;
		this.cgoTpNm = cgoTpNm;
		this.trspSoCmbTpCd = trspSoCmbTpCd;
		this.poBasicRt = poBasicRt;
		this.woRjctDt = woRjctDt;
		this.poWtrRcvTermCd = poWtrRcvTermCd;
		this.woTotAmt = woTotAmt;
		this.bkgNo = bkgNo;
		this.bundlingFlg = bundlingFlg;
		this.cancelCheck = cancelCheck;
		this.distance = distance;
		this.cmdtCd = cmdtCd;
		this.n3ptyBzcCustCntCd = n3ptyBzcCustCntCd;
		this.poTrspAgmtRtTpNm = poTrspAgmtRtTpNm;
		this.agmtMorCnddtAplyFlg = agmtMorCnddtAplyFlg;
		this.viaYardValue = viaYardValue;
		this.shprCustNm = shprCustNm;
		this.poWtrDeTermCd = poWtrDeTermCd;
		this.poOverWgtScgRt = poOverWgtScgRt;
		this.mcntrBdlGrpSeq = mcntrBdlGrpSeq;
		this.bzcAmt = bzcAmt;
		this.n3ptyBzcOfcCd = n3ptyBzcOfcCd;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.fmNodCd = fmNodCd;
		this.custCntCdSeq = custCntCdSeq;
		this.distanceUom = distanceUom;
		this.toLocValue = toLocValue;
		this.cneeCustNm = cneeCustNm;
		this.viaLocValue = viaLocValue;
		this.woCreNm = woCreNm;
		this.woRjctIndct = woRjctIndct;
		this.n3ptyBzcAmt = n3ptyBzcAmt;
		this.ovwtTriAxlFlg = ovwtTriAxlFlg;
		this.dtnUseFlg = dtnUseFlg;
		this.troCnfm = troCnfm;
		this.n3ptyBzcVndrSeq = n3ptyBzcVndrSeq;
		this.trspCrrModNm = trspCrrModNm;
		this.dorDeAddr = dorDeAddr;
		this.woIssueDt = woIssueDt;
		this.poTrspAgmtSeq = poTrspAgmtSeq;
		this.lstNodPlnTm = lstNodPlnTm;
		this.blNo = blNo;
		this.poScg2Rt = poScg2Rt;
		this.vndrNm = vndrNm;
		this.ctrtNo = ctrtNo;
		this.cntcPsonFaxNo = cntcPsonFaxNo;
		this.poTrspAgmtRtTpCd = poTrspAgmtRtTpCd;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.poTrspAgmtOfcCtyCd = poTrspAgmtOfcCtyCd;
		this.mltStopDeFlg = mltStopDeFlg;
		this.trspSoTpCd = trspSoTpCd;
		this.revCurrCd = revCurrCd;
		this.defaultSpFlg = defaultSpFlg;
		this.trspDfltVndrFlg = trspDfltVndrFlg;
		this.poCustSeq = poCustSeq;
		this.cntcPsonPhnNo = cntcPsonPhnNo;
		this.soCreDt = soCreDt;
		this.cntrLbsWgt = cntrLbsWgt;
		this.poSpType = poSpType;
		this.bkgspe = bkgspe;
		this.deliTimeDt = deliTimeDt;
		this.vndrSeq = vndrSeq;
		this.trspSoOfcCtyCdSeq = trspSoOfcCtyCdSeq;
		this.poCfmFlg = poCfmFlg;
		this.ctrtCnt = ctrtCnt;
		this.currCd = currCd;
		this.poRtnMsg = poRtnMsg;
		this.refId = refId;
		this.trspSpCngRsnCd = trspSpCngRsnCd;
		this.vgmWgt = vgmWgt;
		this.trspRqstBkgFlg = trspRqstBkgFlg;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.n3ptyBzcCurrCd = n3ptyBzcCurrCd;
		this.poCustCntCd = poCustCntCd;
		this.eqNo = eqNo;
		this.poCustCntCdSeq = poCustCntCdSeq;
		this.negoRmk = negoRmk;
		this.woEdiUseFlg = woEdiUseFlg;
		this.creOfcCd = creOfcCd;
		this.moreCandidates = moreCandidates;
		this.spclInstrRmk = spclInstrRmk;
		this.revenue = revenue;
		this.appoTimeHms = appoTimeHms;
		this.woTotAmtUsd = woTotAmtUsd;
		this.dorNodPlnTm = dorNodPlnTm;
		this.orgNegoAmt = orgNegoAmt;
		this.troCfmUpdDt = troCfmUpdDt;
		this.poRtnCd = poRtnCd;
		this.poLocalCurrCd = poLocalCurrCd;
		this.dorLocValue = dorLocValue;
		this.ntfyCustNm = ntfyCustNm;
		this.trspWoOfcCtyCdSeq = trspWoOfcCtyCdSeq;
		this.custNomiTrkrFlg = custNomiTrkrFlg;
		this.blckStwg = blckStwg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ib_vvd_cd", getIbVvdCd());
		this.hashColumns.put("n3pty_bzc_tp_cd", getN3ptyBzcTpCd());
		this.hashColumns.put("tro_cfm_upd_tm", getTroCfmUpdTm());
		this.hashColumns.put("po_vat_scg_rt", getPoVatScgRt());
		this.hashColumns.put("trsp_agmt_rt_tp_nm", getTrspAgmtRtTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3pty_bzc_cust_seq", getN3ptyBzcCustSeq());
		this.hashColumns.put("po_fuel_scg_rt", getPoFuelScgRt());
		this.hashColumns.put("po_usd_curr_tot_amt", getPoUsdCurrTotAmt());
		this.hashColumns.put("cnt_flg", getCntFlg());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("mty_rr_flg", getMtyRrFlg());
		this.hashColumns.put("tro_cfm_usr_id", getTroCfmUsrId());
		this.hashColumns.put("trsp_cost_dtl_mod_nm", getTrspCostDtlModNm());
		this.hashColumns.put("act_cust_cd", getActCustCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("nego_amt", getNegoAmt());
		this.hashColumns.put("n3pty_bzc_desc", getN3ptyBzcDesc());
		this.hashColumns.put("fctry_nm", getFctryNm());
		this.hashColumns.put("scg_vat_amt", getScgVatAmt());
		this.hashColumns.put("po_agmt_upd_dt", getPoAgmtUpdDt());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("po_cust_nomi_trkr_ind_cd", getPoCustNomiTrkrIndCd());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("fm_loc_value", getFmLocValue());
		this.hashColumns.put("fm_yard_value", getFmYardValue());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("trsp_agmt_wy_tp_cd", getTrspAgmtWyTpCd());
		this.hashColumns.put("deli_time_hms", getDeliTimeHms());
		this.hashColumns.put("trsp_rjct_rsn_cd", getTrspRjctRsnCd());
		this.hashColumns.put("lst_nod_pln_dt", getLstNodPlnDt());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("fuel_scg_amt", getFuelScgAmt());
		this.hashColumns.put("trsp_sp_cng_rsn_rmk", getTrspSpCngRsnRmk());
		this.hashColumns.put("n3pty_bil_flg", getN3ptyBilFlg());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("n1st_nod_pln_dt", getN1stNodPlnDt());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("n1st_nod_pln_tm", getN1stNodPlnTm());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("ttl_dist", getTtlDist());
		this.hashColumns.put("cntr_kgs_wgt", getCntrKgsWgt());
		this.hashColumns.put("bundling_no", getBundlingNo());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("so_cre_nm", getSoCreNm());
		this.hashColumns.put("spcl_cgo_cntr_tp_cd", getSpclCgoCntrTpCd());
		this.hashColumns.put("trsp_agmt_rt_tp_cd", getTrspAgmtRtTpCd());
		this.hashColumns.put("hzd_mtrl_flg", getHzdMtrlFlg());
		this.hashColumns.put("dor_nod_pln_dt", getDorNodPlnDt());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("trsp_so_cmb_tp_nm", getTrspSoCmbTpNm());
		this.hashColumns.put("wo_bl_no_iss_flg", getWoBlNoIssFlg());
		this.hashColumns.put("wo_rmk", getWoRmk());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("surcharge_key", getSurchargeKey());
		this.hashColumns.put("fdr_vvd", getFdrVvd());
		this.hashColumns.put("cost_act_grp_cd", getCostActGrpCd());
		this.hashColumns.put("vgm_flg", getVgmFlg());
		this.hashColumns.put("wgt_meas_ut_cd", getWgtMeasUtCd());
		this.hashColumns.put("tro_cfm_ofc_cd", getTroCfmOfcCd());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("to_yard_value", getToYardValue());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mcntr_bdl_seq", getMcntrBdlSeq());
		this.hashColumns.put("ctrt_tp_cd", getCtrtTpCd());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dor_yard_value", getDorYardValue());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("po_agmt_rt_seq", getPoAgmtRtSeq());
		this.hashColumns.put("preset_vndr_seq", getPresetVndrSeq());
		this.hashColumns.put("etc_add_amt", getEtcAddAmt());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("po_way_type", getPoWayType());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("sp_type", getSpType());
		this.hashColumns.put("bkg_tro_no", getBkgTroNo());
		this.hashColumns.put("po_scg3_rt", getPoScg3Rt());
		this.hashColumns.put("rejected_check", getRejectedCheck());
		this.hashColumns.put("appo_time_dt", getAppoTimeDt());
		this.hashColumns.put("ob_vvd_cd", getObVvdCd());
		this.hashColumns.put("trsp_so_cmb_seq", getTrspSoCmbSeq());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("ctrt_tp_flg", getCtrtTpFlg());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("po_local_curr_tot_amt", getPoLocalCurrTotAmt());
		this.hashColumns.put("org_curr_cd", getOrgCurrCd());
		this.hashColumns.put("po_scg1_rt", getPoScg1Rt());
		this.hashColumns.put("lnk_dist_div_cd", getLnkDistDivCd());
		this.hashColumns.put("dor_pst_cd", getDorPstCd());
		this.hashColumns.put("trsp_frst_flg", getTrspFrstFlg());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("trsp_so_tp_nm", getTrspSoTpNm());
		this.hashColumns.put("toll_fee_amt", getTollFeeAmt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("po_cust_nomi_trkr_flg", getPoCustNomiTrkrFlg());
		this.hashColumns.put("cgo_tp_nm", getCgoTpNm());
		this.hashColumns.put("trsp_so_cmb_tp_cd", getTrspSoCmbTpCd());
		this.hashColumns.put("po_basic_rt", getPoBasicRt());
		this.hashColumns.put("wo_rjct_dt", getWoRjctDt());
		this.hashColumns.put("po_wtr_rcv_term_cd", getPoWtrRcvTermCd());
		this.hashColumns.put("wo_tot_amt", getWoTotAmt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bundling_flg", getBundlingFlg());
		this.hashColumns.put("cancel_check", getCancelCheck());
		this.hashColumns.put("distance", getDistance());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("n3pty_bzc_cust_cnt_cd", getN3ptyBzcCustCntCd());
		this.hashColumns.put("po_trsp_agmt_rt_tp_nm", getPoTrspAgmtRtTpNm());
		this.hashColumns.put("agmt_mor_cnddt_aply_flg", getAgmtMorCnddtAplyFlg());
		this.hashColumns.put("via_yard_value", getViaYardValue());
		this.hashColumns.put("shpr_cust_nm", getShprCustNm());
		this.hashColumns.put("po_wtr_de_term_cd", getPoWtrDeTermCd());
		this.hashColumns.put("po_over_wgt_scg_rt", getPoOverWgtScgRt());
		this.hashColumns.put("mcntr_bdl_grp_seq", getMcntrBdlGrpSeq());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("n3pty_bzc_ofc_cd", getN3ptyBzcOfcCd());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("cust_cnt_cd_seq", getCustCntCdSeq());
		this.hashColumns.put("distance_uom", getDistanceUom());
		this.hashColumns.put("to_loc_value", getToLocValue());
		this.hashColumns.put("cnee_cust_nm", getCneeCustNm());
		this.hashColumns.put("via_loc_value", getViaLocValue());
		this.hashColumns.put("wo_cre_nm", getWoCreNm());
		this.hashColumns.put("wo_rjct_indct", getWoRjctIndct());
		this.hashColumns.put("n3pty_bzc_amt", getN3ptyBzcAmt());
		this.hashColumns.put("ovwt_tri_axl_flg", getOvwtTriAxlFlg());
		this.hashColumns.put("dtn_use_flg", getDtnUseFlg());
		this.hashColumns.put("tro_cnfm", getTroCnfm());
		this.hashColumns.put("n3pty_bzc_vndr_seq", getN3ptyBzcVndrSeq());
		this.hashColumns.put("trsp_crr_mod_nm", getTrspCrrModNm());
		this.hashColumns.put("dor_de_addr", getDorDeAddr());
		this.hashColumns.put("wo_issue_dt", getWoIssueDt());
		this.hashColumns.put("po_trsp_agmt_seq", getPoTrspAgmtSeq());
		this.hashColumns.put("lst_nod_pln_tm", getLstNodPlnTm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("po_scg2_rt", getPoScg2Rt());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("cntc_pson_fax_no", getCntcPsonFaxNo());
		this.hashColumns.put("po_trsp_agmt_rt_tp_cd", getPoTrspAgmtRtTpCd());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("po_trsp_agmt_ofc_cty_cd", getPoTrspAgmtOfcCtyCd());
		this.hashColumns.put("mlt_stop_de_flg", getMltStopDeFlg());
		this.hashColumns.put("trsp_so_tp_cd", getTrspSoTpCd());
		this.hashColumns.put("rev_curr_cd", getRevCurrCd());
		this.hashColumns.put("default_sp_flg", getDefaultSpFlg());
		this.hashColumns.put("trsp_dflt_vndr_flg", getTrspDfltVndrFlg());
		this.hashColumns.put("po_cust_seq", getPoCustSeq());
		this.hashColumns.put("cntc_pson_phn_no", getCntcPsonPhnNo());
		this.hashColumns.put("so_cre_dt", getSoCreDt());
		this.hashColumns.put("cntr_lbs_wgt", getCntrLbsWgt());
		this.hashColumns.put("po_sp_type", getPoSpType());
		this.hashColumns.put("bkgspe", getBkgspe());
		this.hashColumns.put("deli_time_dt", getDeliTimeDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("trsp_so_ofc_cty_cd_seq", getTrspSoOfcCtyCdSeq());
		this.hashColumns.put("po_cfm_flg", getPoCfmFlg());
		this.hashColumns.put("ctrt_cnt", getCtrtCnt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("po_rtn_msg", getPoRtnMsg());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("trsp_sp_cng_rsn_cd", getTrspSpCngRsnCd());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("trsp_rqst_bkg_flg", getTrspRqstBkgFlg());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("n3pty_bzc_curr_cd", getN3ptyBzcCurrCd());
		this.hashColumns.put("po_cust_cnt_cd", getPoCustCntCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("po_cust_cnt_cd_seq", getPoCustCntCdSeq());
		this.hashColumns.put("nego_rmk", getNegoRmk());
		this.hashColumns.put("wo_edi_use_flg", getWoEdiUseFlg());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("more_candidates", getMoreCandidates());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("revenue", getRevenue());
		this.hashColumns.put("appo_time_hms", getAppoTimeHms());
		this.hashColumns.put("wo_tot_amt_usd", getWoTotAmtUsd());
		this.hashColumns.put("dor_nod_pln_tm", getDorNodPlnTm());
		this.hashColumns.put("org_nego_amt", getOrgNegoAmt());
		this.hashColumns.put("tro_cfm_upd_dt", getTroCfmUpdDt());
		this.hashColumns.put("po_rtn_cd", getPoRtnCd());
		this.hashColumns.put("po_local_curr_cd", getPoLocalCurrCd());
		this.hashColumns.put("dor_loc_value", getDorLocValue());
		this.hashColumns.put("ntfy_cust_nm", getNtfyCustNm());
		this.hashColumns.put("trsp_wo_ofc_cty_cd_seq", getTrspWoOfcCtyCdSeq());
		this.hashColumns.put("cust_nomi_trkr_flg", getCustNomiTrkrFlg());
		this.hashColumns.put("blck_stwg", getBlckStwg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ib_vvd_cd", "ibVvdCd");
		this.hashFields.put("n3pty_bzc_tp_cd", "n3ptyBzcTpCd");
		this.hashFields.put("tro_cfm_upd_tm", "troCfmUpdTm");
		this.hashFields.put("po_vat_scg_rt", "poVatScgRt");
		this.hashFields.put("trsp_agmt_rt_tp_nm", "trspAgmtRtTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_bzc_cust_seq", "n3ptyBzcCustSeq");
		this.hashFields.put("po_fuel_scg_rt", "poFuelScgRt");
		this.hashFields.put("po_usd_curr_tot_amt", "poUsdCurrTotAmt");
		this.hashFields.put("cnt_flg", "cntFlg");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("mty_rr_flg", "mtyRrFlg");
		this.hashFields.put("tro_cfm_usr_id", "troCfmUsrId");
		this.hashFields.put("trsp_cost_dtl_mod_nm", "trspCostDtlModNm");
		this.hashFields.put("act_cust_cd", "actCustCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("nego_amt", "negoAmt");
		this.hashFields.put("n3pty_bzc_desc", "n3ptyBzcDesc");
		this.hashFields.put("fctry_nm", "fctryNm");
		this.hashFields.put("scg_vat_amt", "scgVatAmt");
		this.hashFields.put("po_agmt_upd_dt", "poAgmtUpdDt");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("po_cust_nomi_trkr_ind_cd", "poCustNomiTrkrIndCd");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("fm_loc_value", "fmLocValue");
		this.hashFields.put("fm_yard_value", "fmYardValue");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("trsp_agmt_wy_tp_cd", "trspAgmtWyTpCd");
		this.hashFields.put("deli_time_hms", "deliTimeHms");
		this.hashFields.put("trsp_rjct_rsn_cd", "trspRjctRsnCd");
		this.hashFields.put("lst_nod_pln_dt", "lstNodPlnDt");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("fuel_scg_amt", "fuelScgAmt");
		this.hashFields.put("trsp_sp_cng_rsn_rmk", "trspSpCngRsnRmk");
		this.hashFields.put("n3pty_bil_flg", "n3ptyBilFlg");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("n1st_nod_pln_dt", "n1stNodPlnDt");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("n1st_nod_pln_tm", "n1stNodPlnTm");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("ttl_dist", "ttlDist");
		this.hashFields.put("cntr_kgs_wgt", "cntrKgsWgt");
		this.hashFields.put("bundling_no", "bundlingNo");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("so_cre_nm", "soCreNm");
		this.hashFields.put("spcl_cgo_cntr_tp_cd", "spclCgoCntrTpCd");
		this.hashFields.put("trsp_agmt_rt_tp_cd", "trspAgmtRtTpCd");
		this.hashFields.put("hzd_mtrl_flg", "hzdMtrlFlg");
		this.hashFields.put("dor_nod_pln_dt", "dorNodPlnDt");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("trsp_so_cmb_tp_nm", "trspSoCmbTpNm");
		this.hashFields.put("wo_bl_no_iss_flg", "woBlNoIssFlg");
		this.hashFields.put("wo_rmk", "woRmk");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("surcharge_key", "surchargeKey");
		this.hashFields.put("fdr_vvd", "fdrVvd");
		this.hashFields.put("cost_act_grp_cd", "costActGrpCd");
		this.hashFields.put("vgm_flg", "vgmFlg");
		this.hashFields.put("wgt_meas_ut_cd", "wgtMeasUtCd");
		this.hashFields.put("tro_cfm_ofc_cd", "troCfmOfcCd");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("to_yard_value", "toYardValue");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mcntr_bdl_seq", "mcntrBdlSeq");
		this.hashFields.put("ctrt_tp_cd", "ctrtTpCd");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dor_yard_value", "dorYardValue");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("po_agmt_rt_seq", "poAgmtRtSeq");
		this.hashFields.put("preset_vndr_seq", "presetVndrSeq");
		this.hashFields.put("etc_add_amt", "etcAddAmt");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("po_way_type", "poWayType");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("sp_type", "spType");
		this.hashFields.put("bkg_tro_no", "bkgTroNo");
		this.hashFields.put("po_scg3_rt", "poScg3Rt");
		this.hashFields.put("rejected_check", "rejectedCheck");
		this.hashFields.put("appo_time_dt", "appoTimeDt");
		this.hashFields.put("ob_vvd_cd", "obVvdCd");
		this.hashFields.put("trsp_so_cmb_seq", "trspSoCmbSeq");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("ctrt_tp_flg", "ctrtTpFlg");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("po_local_curr_tot_amt", "poLocalCurrTotAmt");
		this.hashFields.put("org_curr_cd", "orgCurrCd");
		this.hashFields.put("po_scg1_rt", "poScg1Rt");
		this.hashFields.put("lnk_dist_div_cd", "lnkDistDivCd");
		this.hashFields.put("dor_pst_cd", "dorPstCd");
		this.hashFields.put("trsp_frst_flg", "trspFrstFlg");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("trsp_so_tp_nm", "trspSoTpNm");
		this.hashFields.put("toll_fee_amt", "tollFeeAmt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("po_cust_nomi_trkr_flg", "poCustNomiTrkrFlg");
		this.hashFields.put("cgo_tp_nm", "cgoTpNm");
		this.hashFields.put("trsp_so_cmb_tp_cd", "trspSoCmbTpCd");
		this.hashFields.put("po_basic_rt", "poBasicRt");
		this.hashFields.put("wo_rjct_dt", "woRjctDt");
		this.hashFields.put("po_wtr_rcv_term_cd", "poWtrRcvTermCd");
		this.hashFields.put("wo_tot_amt", "woTotAmt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bundling_flg", "bundlingFlg");
		this.hashFields.put("cancel_check", "cancelCheck");
		this.hashFields.put("distance", "distance");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("n3pty_bzc_cust_cnt_cd", "n3ptyBzcCustCntCd");
		this.hashFields.put("po_trsp_agmt_rt_tp_nm", "poTrspAgmtRtTpNm");
		this.hashFields.put("agmt_mor_cnddt_aply_flg", "agmtMorCnddtAplyFlg");
		this.hashFields.put("via_yard_value", "viaYardValue");
		this.hashFields.put("shpr_cust_nm", "shprCustNm");
		this.hashFields.put("po_wtr_de_term_cd", "poWtrDeTermCd");
		this.hashFields.put("po_over_wgt_scg_rt", "poOverWgtScgRt");
		this.hashFields.put("mcntr_bdl_grp_seq", "mcntrBdlGrpSeq");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("n3pty_bzc_ofc_cd", "n3ptyBzcOfcCd");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("cust_cnt_cd_seq", "custCntCdSeq");
		this.hashFields.put("distance_uom", "distanceUom");
		this.hashFields.put("to_loc_value", "toLocValue");
		this.hashFields.put("cnee_cust_nm", "cneeCustNm");
		this.hashFields.put("via_loc_value", "viaLocValue");
		this.hashFields.put("wo_cre_nm", "woCreNm");
		this.hashFields.put("wo_rjct_indct", "woRjctIndct");
		this.hashFields.put("n3pty_bzc_amt", "n3ptyBzcAmt");
		this.hashFields.put("ovwt_tri_axl_flg", "ovwtTriAxlFlg");
		this.hashFields.put("dtn_use_flg", "dtnUseFlg");
		this.hashFields.put("tro_cnfm", "troCnfm");
		this.hashFields.put("n3pty_bzc_vndr_seq", "n3ptyBzcVndrSeq");
		this.hashFields.put("trsp_crr_mod_nm", "trspCrrModNm");
		this.hashFields.put("dor_de_addr", "dorDeAddr");
		this.hashFields.put("wo_issue_dt", "woIssueDt");
		this.hashFields.put("po_trsp_agmt_seq", "poTrspAgmtSeq");
		this.hashFields.put("lst_nod_pln_tm", "lstNodPlnTm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("po_scg2_rt", "poScg2Rt");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("cntc_pson_fax_no", "cntcPsonFaxNo");
		this.hashFields.put("po_trsp_agmt_rt_tp_cd", "poTrspAgmtRtTpCd");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("po_trsp_agmt_ofc_cty_cd", "poTrspAgmtOfcCtyCd");
		this.hashFields.put("mlt_stop_de_flg", "mltStopDeFlg");
		this.hashFields.put("trsp_so_tp_cd", "trspSoTpCd");
		this.hashFields.put("rev_curr_cd", "revCurrCd");
		this.hashFields.put("default_sp_flg", "defaultSpFlg");
		this.hashFields.put("trsp_dflt_vndr_flg", "trspDfltVndrFlg");
		this.hashFields.put("po_cust_seq", "poCustSeq");
		this.hashFields.put("cntc_pson_phn_no", "cntcPsonPhnNo");
		this.hashFields.put("so_cre_dt", "soCreDt");
		this.hashFields.put("cntr_lbs_wgt", "cntrLbsWgt");
		this.hashFields.put("po_sp_type", "poSpType");
		this.hashFields.put("bkgspe", "bkgspe");
		this.hashFields.put("deli_time_dt", "deliTimeDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("trsp_so_ofc_cty_cd_seq", "trspSoOfcCtyCdSeq");
		this.hashFields.put("po_cfm_flg", "poCfmFlg");
		this.hashFields.put("ctrt_cnt", "ctrtCnt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("po_rtn_msg", "poRtnMsg");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("trsp_sp_cng_rsn_cd", "trspSpCngRsnCd");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("trsp_rqst_bkg_flg", "trspRqstBkgFlg");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("n3pty_bzc_curr_cd", "n3ptyBzcCurrCd");
		this.hashFields.put("po_cust_cnt_cd", "poCustCntCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("po_cust_cnt_cd_seq", "poCustCntCdSeq");
		this.hashFields.put("nego_rmk", "negoRmk");
		this.hashFields.put("wo_edi_use_flg", "woEdiUseFlg");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("more_candidates", "moreCandidates");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("revenue", "revenue");
		this.hashFields.put("appo_time_hms", "appoTimeHms");
		this.hashFields.put("wo_tot_amt_usd", "woTotAmtUsd");
		this.hashFields.put("dor_nod_pln_tm", "dorNodPlnTm");
		this.hashFields.put("org_nego_amt", "orgNegoAmt");
		this.hashFields.put("tro_cfm_upd_dt", "troCfmUpdDt");
		this.hashFields.put("po_rtn_cd", "poRtnCd");
		this.hashFields.put("po_local_curr_cd", "poLocalCurrCd");
		this.hashFields.put("dor_loc_value", "dorLocValue");
		this.hashFields.put("ntfy_cust_nm", "ntfyCustNm");
		this.hashFields.put("trsp_wo_ofc_cty_cd_seq", "trspWoOfcCtyCdSeq");
		this.hashFields.put("cust_nomi_trkr_flg", "custNomiTrkrFlg");
		this.hashFields.put("blck_stwg", "blckStwg");
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
	 * @return poVatScgRt
	 */
	public String getPoVatScgRt() {
		return this.poVatScgRt;
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
	 * @return poFuelScgRt
	 */
	public String getPoFuelScgRt() {
		return this.poFuelScgRt;
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
	 * @return cntFlg
	 */
	public String getCntFlg() {
		return this.cntFlg;
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
	 * @return mtyRrFlg
	 */
	public String getMtyRrFlg() {
		return this.mtyRrFlg;
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
	 * @return trspCostDtlModNm
	 */
	public String getTrspCostDtlModNm() {
		return this.trspCostDtlModNm;
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
	 * @return scgVatAmt
	 */
	public String getScgVatAmt() {
		return this.scgVatAmt;
	}
	
	/**
	 * Column Info
	 * @return poAgmtUpdDt
	 */
	public String getPoAgmtUpdDt() {
		return this.poAgmtUpdDt;
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
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
	}
	
	/**
	 * Column Info
	 * @return poCustNomiTrkrIndCd
	 */
	public String getPoCustNomiTrkrIndCd() {
		return this.poCustNomiTrkrIndCd;
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
	 * @return fmLocValue
	 */
	public String getFmLocValue() {
		return this.fmLocValue;
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
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
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
	 * @return deliTimeHms
	 */
	public String getDeliTimeHms() {
		return this.deliTimeHms;
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
	 * @return fuelScgAmt
	 */
	public String getFuelScgAmt() {
		return this.fuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @return trspSpCngRsnRmk
	 */
	public String getTrspSpCngRsnRmk() {
		return this.trspSpCngRsnRmk;
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
	 * @return costActGrpSeq
	 */
	public String getCostActGrpSeq() {
		return this.costActGrpSeq;
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
	 * @return ttlDist
	 */
	public String getTtlDist() {
		return this.ttlDist;
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
	 * @return bundlingNo
	 */
	public String getBundlingNo() {
		return this.bundlingNo;
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
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
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
	 * @return spclCgoCntrTpCd
	 */
	public String getSpclCgoCntrTpCd() {
		return this.spclCgoCntrTpCd;
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
	 * @return hzdMtrlFlg
	 */
	public String getHzdMtrlFlg() {
		return this.hzdMtrlFlg;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return woRmk
	 */
	public String getWoRmk() {
		return this.woRmk;
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
	 * @return surchargeKey
	 */
	public String getSurchargeKey() {
		return this.surchargeKey;
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
	 * @return costActGrpCd
	 */
	public String getCostActGrpCd() {
		return this.costActGrpCd;
	}
	
	/**
	 * Column Info
	 * @return vgmFlg
	 */
	public String getVgmFlg() {
		return this.vgmFlg;
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
	 * @return troCfmOfcCd
	 */
	public String getTroCfmOfcCd() {
		return this.troCfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return mcntrBdlSeq
	 */
	public String getMcntrBdlSeq() {
		return this.mcntrBdlSeq;
	}
	
	/**
	 * Column Info
	 * @return ctrtTpCd
	 */
	public String getCtrtTpCd() {
		return this.ctrtTpCd;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return dorYardValue
	 */
	public String getDorYardValue() {
		return this.dorYardValue;
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
	 * @return poAgmtRtSeq
	 */
	public String getPoAgmtRtSeq() {
		return this.poAgmtRtSeq;
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
	 * @return etcAddAmt
	 */
	public String getEtcAddAmt() {
		return this.etcAddAmt;
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
	 * @return bkgTroNo
	 */
	public String getBkgTroNo() {
		return this.bkgTroNo;
	}
	
	/**
	 * Column Info
	 * @return poScg3Rt
	 */
	public String getPoScg3Rt() {
		return this.poScg3Rt;
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
	 * @return appoTimeDt
	 */
	public String getAppoTimeDt() {
		return this.appoTimeDt;
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
	 * @return trspSoCmbSeq
	 */
	public String getTrspSoCmbSeq() {
		return this.trspSoCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUtCd
	 */
	public String getVgmWgtUtCd() {
		return this.vgmWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtTpFlg
	 */
	public String getCtrtTpFlg() {
		return this.ctrtTpFlg;
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
	 * @return orgCurrCd
	 */
	public String getOrgCurrCd() {
		return this.orgCurrCd;
	}
	
	/**
	 * Column Info
	 * @return poScg1Rt
	 */
	public String getPoScg1Rt() {
		return this.poScg1Rt;
	}
	
	/**
	 * Column Info
	 * @return lnkDistDivCd
	 */
	public String getLnkDistDivCd() {
		return this.lnkDistDivCd;
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
	 * @return trspFrstFlg
	 */
	public String getTrspFrstFlg() {
		return this.trspFrstFlg;
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
	 * @return trspSoTpNm
	 */
	public String getTrspSoTpNm() {
		return this.trspSoTpNm;
	}
	
	/**
	 * Column Info
	 * @return tollFeeAmt
	 */
	public String getTollFeeAmt() {
		return this.tollFeeAmt;
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
	 * @return trspSoCmbTpCd
	 */
	public String getTrspSoCmbTpCd() {
		return this.trspSoCmbTpCd;
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
	 * @return poWtrRcvTermCd
	 */
	public String getPoWtrRcvTermCd() {
		return this.poWtrRcvTermCd;
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
	 * @return bundlingFlg
	 */
	public String getBundlingFlg() {
		return this.bundlingFlg;
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
	 * @return distance
	 */
	public String getDistance() {
		return this.distance;
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
	 * @return n3ptyBzcCustCntCd
	 */
	public String getN3ptyBzcCustCntCd() {
		return this.n3ptyBzcCustCntCd;
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
	 * @return agmtMorCnddtAplyFlg
	 */
	public String getAgmtMorCnddtAplyFlg() {
		return this.agmtMorCnddtAplyFlg;
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
	 * @return poWtrDeTermCd
	 */
	public String getPoWtrDeTermCd() {
		return this.poWtrDeTermCd;
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
	 * @return mcntrBdlGrpSeq
	 */
	public String getMcntrBdlGrpSeq() {
		return this.mcntrBdlGrpSeq;
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
	 * @return n3ptyBzcOfcCd
	 */
	public String getN3ptyBzcOfcCd() {
		return this.n3ptyBzcOfcCd;
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
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
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
	 * @return distanceUom
	 */
	public String getDistanceUom() {
		return this.distanceUom;
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
	 * @return cneeCustNm
	 */
	public String getCneeCustNm() {
		return this.cneeCustNm;
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
	 * @return woCreNm
	 */
	public String getWoCreNm() {
		return this.woCreNm;
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
	 * @return n3ptyBzcAmt
	 */
	public String getN3ptyBzcAmt() {
		return this.n3ptyBzcAmt;
	}
	
	/**
	 * Column Info
	 * @return ovwtTriAxlFlg
	 */
	public String getOvwtTriAxlFlg() {
		return this.ovwtTriAxlFlg;
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
	 * @return troCnfm
	 */
	public String getTroCnfm() {
		return this.troCnfm;
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
	 * @return trspCrrModNm
	 */
	public String getTrspCrrModNm() {
		return this.trspCrrModNm;
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
	 * @return woIssueDt
	 */
	public String getWoIssueDt() {
		return this.woIssueDt;
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
	 * @return lstNodPlnTm
	 */
	public String getLstNodPlnTm() {
		return this.lstNodPlnTm;
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
	 * @return poScg2Rt
	 */
	public String getPoScg2Rt() {
		return this.poScg2Rt;
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
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
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
	 * @return poTrspAgmtRtTpCd
	 */
	public String getPoTrspAgmtRtTpCd() {
		return this.poTrspAgmtRtTpCd;
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
	 * @return soCreDt
	 */
	public String getSoCreDt() {
		return this.soCreDt;
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
	 * @return deliTimeDt
	 */
	public String getDeliTimeDt() {
		return this.deliTimeDt;
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
	 * @return trspSoOfcCtyCdSeq
	 */
	public String getTrspSoOfcCtyCdSeq() {
		return this.trspSoOfcCtyCdSeq;
	}
	
	/**
	 * Column Info
	 * @return poCfmFlg
	 */
	public String getPoCfmFlg() {
		return this.poCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtCnt
	 */
	public String getCtrtCnt() {
		return this.ctrtCnt;
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
	 * @return trspSpCngRsnCd
	 */
	public String getTrspSpCngRsnCd() {
		return this.trspSpCngRsnCd;
	}
	
	/**
	 * Column Info
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
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
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
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
	 * @return negoRmk
	 */
	public String getNegoRmk() {
		return this.negoRmk;
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
	 * @return appoTimeHms
	 */
	public String getAppoTimeHms() {
		return this.appoTimeHms;
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
	 * @return dorNodPlnTm
	 */
	public String getDorNodPlnTm() {
		return this.dorNodPlnTm;
	}
	
	/**
	 * Column Info
	 * @return orgNegoAmt
	 */
	public String getOrgNegoAmt() {
		return this.orgNegoAmt;
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
	 * @return poLocalCurrCd
	 */
	public String getPoLocalCurrCd() {
		return this.poLocalCurrCd;
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
	 * @return ntfyCustNm
	 */
	public String getNtfyCustNm() {
		return this.ntfyCustNm;
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
	 * @return custNomiTrkrFlg
	 */
	public String getCustNomiTrkrFlg() {
		return this.custNomiTrkrFlg;
	}
	
    public String getBlckStwg() {
        return blckStwg;
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
	 * @param poVatScgRt
	 */
	public void setPoVatScgRt(String poVatScgRt) {
		this.poVatScgRt = poVatScgRt;
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
	 * @param poFuelScgRt
	 */
	public void setPoFuelScgRt(String poFuelScgRt) {
		this.poFuelScgRt = poFuelScgRt;
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
	 * @param cntFlg
	 */
	public void setCntFlg(String cntFlg) {
		this.cntFlg = cntFlg;
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
	 * @param mtyRrFlg
	 */
	public void setMtyRrFlg(String mtyRrFlg) {
		this.mtyRrFlg = mtyRrFlg;
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
	 * @param trspCostDtlModNm
	 */
	public void setTrspCostDtlModNm(String trspCostDtlModNm) {
		this.trspCostDtlModNm = trspCostDtlModNm;
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
	 * @param scgVatAmt
	 */
	public void setScgVatAmt(String scgVatAmt) {
		this.scgVatAmt = scgVatAmt;
	}
	
	/**
	 * Column Info
	 * @param poAgmtUpdDt
	 */
	public void setPoAgmtUpdDt(String poAgmtUpdDt) {
		this.poAgmtUpdDt = poAgmtUpdDt;
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
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}
	
	/**
	 * Column Info
	 * @param poCustNomiTrkrIndCd
	 */
	public void setPoCustNomiTrkrIndCd(String poCustNomiTrkrIndCd) {
		this.poCustNomiTrkrIndCd = poCustNomiTrkrIndCd;
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
	 * @param fmLocValue
	 */
	public void setFmLocValue(String fmLocValue) {
		this.fmLocValue = fmLocValue;
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
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
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
	 * @param deliTimeHms
	 */
	public void setDeliTimeHms(String deliTimeHms) {
		this.deliTimeHms = deliTimeHms;
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
	 * @param fuelScgAmt
	 */
	public void setFuelScgAmt(String fuelScgAmt) {
		this.fuelScgAmt = fuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @param trspSpCngRsnRmk
	 */
	public void setTrspSpCngRsnRmk(String trspSpCngRsnRmk) {
		this.trspSpCngRsnRmk = trspSpCngRsnRmk;
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
	 * @param costActGrpSeq
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
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
	 * @param ttlDist
	 */
	public void setTtlDist(String ttlDist) {
		this.ttlDist = ttlDist;
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
	 * @param bundlingNo
	 */
	public void setBundlingNo(String bundlingNo) {
		this.bundlingNo = bundlingNo;
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
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
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
	 * @param spclCgoCntrTpCd
	 */
	public void setSpclCgoCntrTpCd(String spclCgoCntrTpCd) {
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
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
	 * @param hzdMtrlFlg
	 */
	public void setHzdMtrlFlg(String hzdMtrlFlg) {
		this.hzdMtrlFlg = hzdMtrlFlg;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param woRmk
	 */
	public void setWoRmk(String woRmk) {
		this.woRmk = woRmk;
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
	 * @param surchargeKey
	 */
	public void setSurchargeKey(String surchargeKey) {
		this.surchargeKey = surchargeKey;
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
	 * @param costActGrpCd
	 */
	public void setCostActGrpCd(String costActGrpCd) {
		this.costActGrpCd = costActGrpCd;
	}
	
	/**
	 * Column Info
	 * @param vgmFlg
	 */
	public void setVgmFlg(String vgmFlg) {
		this.vgmFlg = vgmFlg;
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
	 * @param troCfmOfcCd
	 */
	public void setTroCfmOfcCd(String troCfmOfcCd) {
		this.troCfmOfcCd = troCfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param mcntrBdlSeq
	 */
	public void setMcntrBdlSeq(String mcntrBdlSeq) {
		this.mcntrBdlSeq = mcntrBdlSeq;
	}
	
	/**
	 * Column Info
	 * @param ctrtTpCd
	 */
	public void setCtrtTpCd(String ctrtTpCd) {
		this.ctrtTpCd = ctrtTpCd;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param dorYardValue
	 */
	public void setDorYardValue(String dorYardValue) {
		this.dorYardValue = dorYardValue;
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
	 * @param poAgmtRtSeq
	 */
	public void setPoAgmtRtSeq(String poAgmtRtSeq) {
		this.poAgmtRtSeq = poAgmtRtSeq;
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
	 * @param etcAddAmt
	 */
	public void setEtcAddAmt(String etcAddAmt) {
		this.etcAddAmt = etcAddAmt;
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
	 * @param bkgTroNo
	 */
	public void setBkgTroNo(String bkgTroNo) {
		this.bkgTroNo = bkgTroNo;
	}
	
	/**
	 * Column Info
	 * @param poScg3Rt
	 */
	public void setPoScg3Rt(String poScg3Rt) {
		this.poScg3Rt = poScg3Rt;
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
	 * @param appoTimeDt
	 */
	public void setAppoTimeDt(String appoTimeDt) {
		this.appoTimeDt = appoTimeDt;
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
	 * @param trspSoCmbSeq
	 */
	public void setTrspSoCmbSeq(String trspSoCmbSeq) {
		this.trspSoCmbSeq = trspSoCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtTpFlg
	 */
	public void setCtrtTpFlg(String ctrtTpFlg) {
		this.ctrtTpFlg = ctrtTpFlg;
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
	 * @param orgCurrCd
	 */
	public void setOrgCurrCd(String orgCurrCd) {
		this.orgCurrCd = orgCurrCd;
	}
	
	/**
	 * Column Info
	 * @param poScg1Rt
	 */
	public void setPoScg1Rt(String poScg1Rt) {
		this.poScg1Rt = poScg1Rt;
	}
	
	/**
	 * Column Info
	 * @param lnkDistDivCd
	 */
	public void setLnkDistDivCd(String lnkDistDivCd) {
		this.lnkDistDivCd = lnkDistDivCd;
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
	 * @param trspFrstFlg
	 */
	public void setTrspFrstFlg(String trspFrstFlg) {
		this.trspFrstFlg = trspFrstFlg;
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
	 * @param trspSoTpNm
	 */
	public void setTrspSoTpNm(String trspSoTpNm) {
		this.trspSoTpNm = trspSoTpNm;
	}
	
	/**
	 * Column Info
	 * @param tollFeeAmt
	 */
	public void setTollFeeAmt(String tollFeeAmt) {
		this.tollFeeAmt = tollFeeAmt;
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
	 * @param trspSoCmbTpCd
	 */
	public void setTrspSoCmbTpCd(String trspSoCmbTpCd) {
		this.trspSoCmbTpCd = trspSoCmbTpCd;
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
	 * @param poWtrRcvTermCd
	 */
	public void setPoWtrRcvTermCd(String poWtrRcvTermCd) {
		this.poWtrRcvTermCd = poWtrRcvTermCd;
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
	 * @param bundlingFlg
	 */
	public void setBundlingFlg(String bundlingFlg) {
		this.bundlingFlg = bundlingFlg;
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
	 * @param distance
	 */
	public void setDistance(String distance) {
		this.distance = distance;
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
	 * @param n3ptyBzcCustCntCd
	 */
	public void setN3ptyBzcCustCntCd(String n3ptyBzcCustCntCd) {
		this.n3ptyBzcCustCntCd = n3ptyBzcCustCntCd;
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
	 * @param agmtMorCnddtAplyFlg
	 */
	public void setAgmtMorCnddtAplyFlg(String agmtMorCnddtAplyFlg) {
		this.agmtMorCnddtAplyFlg = agmtMorCnddtAplyFlg;
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
	 * @param poWtrDeTermCd
	 */
	public void setPoWtrDeTermCd(String poWtrDeTermCd) {
		this.poWtrDeTermCd = poWtrDeTermCd;
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
	 * @param mcntrBdlGrpSeq
	 */
	public void setMcntrBdlGrpSeq(String mcntrBdlGrpSeq) {
		this.mcntrBdlGrpSeq = mcntrBdlGrpSeq;
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
	 * @param n3ptyBzcOfcCd
	 */
	public void setN3ptyBzcOfcCd(String n3ptyBzcOfcCd) {
		this.n3ptyBzcOfcCd = n3ptyBzcOfcCd;
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
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
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
	 * @param distanceUom
	 */
	public void setDistanceUom(String distanceUom) {
		this.distanceUom = distanceUom;
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
	 * @param cneeCustNm
	 */
	public void setCneeCustNm(String cneeCustNm) {
		this.cneeCustNm = cneeCustNm;
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
	 * @param woCreNm
	 */
	public void setWoCreNm(String woCreNm) {
		this.woCreNm = woCreNm;
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
	 * @param n3ptyBzcAmt
	 */
	public void setN3ptyBzcAmt(String n3ptyBzcAmt) {
		this.n3ptyBzcAmt = n3ptyBzcAmt;
	}
	
	/**
	 * Column Info
	 * @param ovwtTriAxlFlg
	 */
	public void setOvwtTriAxlFlg(String ovwtTriAxlFlg) {
		this.ovwtTriAxlFlg = ovwtTriAxlFlg;
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
	 * @param troCnfm
	 */
	public void setTroCnfm(String troCnfm) {
		this.troCnfm = troCnfm;
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
	 * @param trspCrrModNm
	 */
	public void setTrspCrrModNm(String trspCrrModNm) {
		this.trspCrrModNm = trspCrrModNm;
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
	 * @param woIssueDt
	 */
	public void setWoIssueDt(String woIssueDt) {
		this.woIssueDt = woIssueDt;
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
	 * @param lstNodPlnTm
	 */
	public void setLstNodPlnTm(String lstNodPlnTm) {
		this.lstNodPlnTm = lstNodPlnTm;
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
	 * @param poScg2Rt
	 */
	public void setPoScg2Rt(String poScg2Rt) {
		this.poScg2Rt = poScg2Rt;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
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
	 * @param poTrspAgmtRtTpCd
	 */
	public void setPoTrspAgmtRtTpCd(String poTrspAgmtRtTpCd) {
		this.poTrspAgmtRtTpCd = poTrspAgmtRtTpCd;
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
	 * @param soCreDt
	 */
	public void setSoCreDt(String soCreDt) {
		this.soCreDt = soCreDt;
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
	 * @param deliTimeDt
	 */
	public void setDeliTimeDt(String deliTimeDt) {
		this.deliTimeDt = deliTimeDt;
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
	 * @param trspSoOfcCtyCdSeq
	 */
	public void setTrspSoOfcCtyCdSeq(String trspSoOfcCtyCdSeq) {
		this.trspSoOfcCtyCdSeq = trspSoOfcCtyCdSeq;
	}
	
	/**
	 * Column Info
	 * @param poCfmFlg
	 */
	public void setPoCfmFlg(String poCfmFlg) {
		this.poCfmFlg = poCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtCnt
	 */
	public void setCtrtCnt(String ctrtCnt) {
		this.ctrtCnt = ctrtCnt;
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
	 * @param trspSpCngRsnCd
	 */
	public void setTrspSpCngRsnCd(String trspSpCngRsnCd) {
		this.trspSpCngRsnCd = trspSpCngRsnCd;
	}
	
	/**
	 * Column Info
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
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
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
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
	 * @param negoRmk
	 */
	public void setNegoRmk(String negoRmk) {
		this.negoRmk = negoRmk;
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
	 * @param appoTimeHms
	 */
	public void setAppoTimeHms(String appoTimeHms) {
		this.appoTimeHms = appoTimeHms;
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
	 * @param dorNodPlnTm
	 */
	public void setDorNodPlnTm(String dorNodPlnTm) {
		this.dorNodPlnTm = dorNodPlnTm;
	}
	
	/**
	 * Column Info
	 * @param orgNegoAmt
	 */
	public void setOrgNegoAmt(String orgNegoAmt) {
		this.orgNegoAmt = orgNegoAmt;
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
	 * @param poLocalCurrCd
	 */
	public void setPoLocalCurrCd(String poLocalCurrCd) {
		this.poLocalCurrCd = poLocalCurrCd;
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
	 * @param ntfyCustNm
	 */
	public void setNtfyCustNm(String ntfyCustNm) {
		this.ntfyCustNm = ntfyCustNm;
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
	
    public void setBlckStwg(String blckStwg) {
        this.blckStwg = blckStwg;
    }	
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbVvdCd(JSPUtil.getParameter(request, prefix + "ib_vvd_cd", ""));
		setN3ptyBzcTpCd(JSPUtil.getParameter(request, prefix + "n3pty_bzc_tp_cd", ""));
		setTroCfmUpdTm(JSPUtil.getParameter(request, prefix + "tro_cfm_upd_tm", ""));
		setPoVatScgRt(JSPUtil.getParameter(request, prefix + "po_vat_scg_rt", ""));
		setTrspAgmtRtTpNm(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN3ptyBzcCustSeq(JSPUtil.getParameter(request, prefix + "n3pty_bzc_cust_seq", ""));
		setPoFuelScgRt(JSPUtil.getParameter(request, prefix + "po_fuel_scg_rt", ""));
		setPoUsdCurrTotAmt(JSPUtil.getParameter(request, prefix + "po_usd_curr_tot_amt", ""));
		setCntFlg(JSPUtil.getParameter(request, prefix + "cnt_flg", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setMtyRrFlg(JSPUtil.getParameter(request, prefix + "mty_rr_flg", ""));
		setTroCfmUsrId(JSPUtil.getParameter(request, prefix + "tro_cfm_usr_id", ""));
		setTrspCostDtlModNm(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_nm", ""));
		setActCustCd(JSPUtil.getParameter(request, prefix + "act_cust_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setNegoAmt(JSPUtil.getParameter(request, prefix + "nego_amt", ""));
		setN3ptyBzcDesc(JSPUtil.getParameter(request, prefix + "n3pty_bzc_desc", ""));
		setFctryNm(JSPUtil.getParameter(request, prefix + "fctry_nm", ""));
		setScgVatAmt(JSPUtil.getParameter(request, prefix + "scg_vat_amt", ""));
		setPoAgmtUpdDt(JSPUtil.getParameter(request, prefix + "po_agmt_upd_dt", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setBkgQty(JSPUtil.getParameter(request, prefix + "bkg_qty", ""));
		setPoCustNomiTrkrIndCd(JSPUtil.getParameter(request, prefix + "po_cust_nomi_trkr_ind_cd", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setFmLocValue(JSPUtil.getParameter(request, prefix + "fm_loc_value", ""));
		setFmYardValue(JSPUtil.getParameter(request, prefix + "fm_yard_value", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setTrspAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_wy_tp_cd", ""));
		setDeliTimeHms(JSPUtil.getParameter(request, prefix + "deli_time_hms", ""));
		setTrspRjctRsnCd(JSPUtil.getParameter(request, prefix + "trsp_rjct_rsn_cd", ""));
		setLstNodPlnDt(JSPUtil.getParameter(request, prefix + "lst_nod_pln_dt", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setFuelScgAmt(JSPUtil.getParameter(request, prefix + "fuel_scg_amt", ""));
		setTrspSpCngRsnRmk(JSPUtil.getParameter(request, prefix + "trsp_sp_cng_rsn_rmk", ""));
		setN3ptyBilFlg(JSPUtil.getParameter(request, prefix + "n3pty_bil_flg", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, prefix + "cost_act_grp_seq", ""));
		setN1stNodPlnDt(JSPUtil.getParameter(request, prefix + "n1st_nod_pln_dt", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setN1stNodPlnTm(JSPUtil.getParameter(request, prefix + "n1st_nod_pln_tm", ""));
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setTtlDist(JSPUtil.getParameter(request, prefix + "ttl_dist", ""));
		setCntrKgsWgt(JSPUtil.getParameter(request, prefix + "cntr_kgs_wgt", ""));
		setBundlingNo(JSPUtil.getParameter(request, prefix + "bundling_no", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setSoCreNm(JSPUtil.getParameter(request, prefix + "so_cre_nm", ""));
		setSpclCgoCntrTpCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cntr_tp_cd", ""));
		setTrspAgmtRtTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_cd", ""));
		setHzdMtrlFlg(JSPUtil.getParameter(request, prefix + "hzd_mtrl_flg", ""));
		setDorNodPlnDt(JSPUtil.getParameter(request, prefix + "dor_nod_pln_dt", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setTrspSoCmbTpNm(JSPUtil.getParameter(request, prefix + "trsp_so_cmb_tp_nm", ""));
		setWoBlNoIssFlg(JSPUtil.getParameter(request, prefix + "wo_bl_no_iss_flg", ""));
		setWoRmk(JSPUtil.getParameter(request, prefix + "wo_rmk", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, prefix + "trsp_wo_seq", ""));
		setSurchargeKey(JSPUtil.getParameter(request, prefix + "surcharge_key", ""));
		setFdrVvd(JSPUtil.getParameter(request, prefix + "fdr_vvd", ""));
		setCostActGrpCd(JSPUtil.getParameter(request, prefix + "cost_act_grp_cd", ""));
		setVgmFlg(JSPUtil.getParameter(request, prefix + "vgm_flg", ""));
		setWgtMeasUtCd(JSPUtil.getParameter(request, prefix + "wgt_meas_ut_cd", ""));
		setTroCfmOfcCd(JSPUtil.getParameter(request, prefix + "tro_cfm_ofc_cd", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setToYardValue(JSPUtil.getParameter(request, prefix + "to_yard_value", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMcntrBdlSeq(JSPUtil.getParameter(request, prefix + "mcntr_bdl_seq", ""));
		setCtrtTpCd(JSPUtil.getParameter(request, prefix + "ctrt_tp_cd", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDorYardValue(JSPUtil.getParameter(request, prefix + "dor_yard_value", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setPoAgmtRtSeq(JSPUtil.getParameter(request, prefix + "po_agmt_rt_seq", ""));
		setPresetVndrSeq(JSPUtil.getParameter(request, prefix + "preset_vndr_seq", ""));
		setEtcAddAmt(JSPUtil.getParameter(request, prefix + "etc_add_amt", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setPoWayType(JSPUtil.getParameter(request, prefix + "po_way_type", ""));
		setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSpType(JSPUtil.getParameter(request, prefix + "sp_type", ""));
		setBkgTroNo(JSPUtil.getParameter(request, prefix + "bkg_tro_no", ""));
		setPoScg3Rt(JSPUtil.getParameter(request, prefix + "po_scg3_rt", ""));
		setRejectedCheck(JSPUtil.getParameter(request, prefix + "rejected_check", ""));
		setAppoTimeDt(JSPUtil.getParameter(request, prefix + "appo_time_dt", ""));
		setObVvdCd(JSPUtil.getParameter(request, prefix + "ob_vvd_cd", ""));
		setTrspSoCmbSeq(JSPUtil.getParameter(request, prefix + "trsp_so_cmb_seq", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setCtrtTpFlg(JSPUtil.getParameter(request, prefix + "ctrt_tp_flg", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setPoLocalCurrTotAmt(JSPUtil.getParameter(request, prefix + "po_local_curr_tot_amt", ""));
		setOrgCurrCd(JSPUtil.getParameter(request, prefix + "org_curr_cd", ""));
		setPoScg1Rt(JSPUtil.getParameter(request, prefix + "po_scg1_rt", ""));
		setLnkDistDivCd(JSPUtil.getParameter(request, prefix + "lnk_dist_div_cd", ""));
		setDorPstCd(JSPUtil.getParameter(request, prefix + "dor_pst_cd", ""));
		setTrspFrstFlg(JSPUtil.getParameter(request, prefix + "trsp_frst_flg", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setTrspSoTpNm(JSPUtil.getParameter(request, prefix + "trsp_so_tp_nm", ""));
		setTollFeeAmt(JSPUtil.getParameter(request, prefix + "toll_fee_amt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setPoCustNomiTrkrFlg(JSPUtil.getParameter(request, prefix + "po_cust_nomi_trkr_flg", ""));
		setCgoTpNm(JSPUtil.getParameter(request, prefix + "cgo_tp_nm", ""));
		setTrspSoCmbTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_cmb_tp_cd", ""));
		setPoBasicRt(JSPUtil.getParameter(request, prefix + "po_basic_rt", ""));
		setWoRjctDt(JSPUtil.getParameter(request, prefix + "wo_rjct_dt", ""));
		setPoWtrRcvTermCd(JSPUtil.getParameter(request, prefix + "po_wtr_rcv_term_cd", ""));
		setWoTotAmt(JSPUtil.getParameter(request, prefix + "wo_tot_amt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBundlingFlg(JSPUtil.getParameter(request, prefix + "bundling_flg", ""));
		setCancelCheck(JSPUtil.getParameter(request, prefix + "cancel_check", ""));
		setDistance(JSPUtil.getParameter(request, prefix + "distance", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setN3ptyBzcCustCntCd(JSPUtil.getParameter(request, prefix + "n3pty_bzc_cust_cnt_cd", ""));
		setPoTrspAgmtRtTpNm(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_rt_tp_nm", ""));
		setAgmtMorCnddtAplyFlg(JSPUtil.getParameter(request, prefix + "agmt_mor_cnddt_aply_flg", ""));
		setViaYardValue(JSPUtil.getParameter(request, prefix + "via_yard_value", ""));
		setShprCustNm(JSPUtil.getParameter(request, prefix + "shpr_cust_nm", ""));
		setPoWtrDeTermCd(JSPUtil.getParameter(request, prefix + "po_wtr_de_term_cd", ""));
		setPoOverWgtScgRt(JSPUtil.getParameter(request, prefix + "po_over_wgt_scg_rt", ""));
		setMcntrBdlGrpSeq(JSPUtil.getParameter(request, prefix + "mcntr_bdl_grp_seq", ""));
		setBzcAmt(JSPUtil.getParameter(request, prefix + "bzc_amt", ""));
		setN3ptyBzcOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_bzc_ofc_cd", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setCustCntCdSeq(JSPUtil.getParameter(request, prefix + "cust_cnt_cd_seq", ""));
		setDistanceUom(JSPUtil.getParameter(request, prefix + "distance_uom", ""));
		setToLocValue(JSPUtil.getParameter(request, prefix + "to_loc_value", ""));
		setCneeCustNm(JSPUtil.getParameter(request, prefix + "cnee_cust_nm", ""));
		setViaLocValue(JSPUtil.getParameter(request, prefix + "via_loc_value", ""));
		setWoCreNm(JSPUtil.getParameter(request, prefix + "wo_cre_nm", ""));
		setWoRjctIndct(JSPUtil.getParameter(request, prefix + "wo_rjct_indct", ""));
		setN3ptyBzcAmt(JSPUtil.getParameter(request, prefix + "n3pty_bzc_amt", ""));
		setOvwtTriAxlFlg(JSPUtil.getParameter(request, prefix + "ovwt_tri_axl_flg", ""));
		setDtnUseFlg(JSPUtil.getParameter(request, prefix + "dtn_use_flg", ""));
		setTroCnfm(JSPUtil.getParameter(request, prefix + "tro_cnfm", ""));
		setN3ptyBzcVndrSeq(JSPUtil.getParameter(request, prefix + "n3pty_bzc_vndr_seq", ""));
		setTrspCrrModNm(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_nm", ""));
		setDorDeAddr(JSPUtil.getParameter(request, prefix + "dor_de_addr", ""));
		setWoIssueDt(JSPUtil.getParameter(request, prefix + "wo_issue_dt", ""));
		setPoTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_seq", ""));
		setLstNodPlnTm(JSPUtil.getParameter(request, prefix + "lst_nod_pln_tm", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPoScg2Rt(JSPUtil.getParameter(request, prefix + "po_scg2_rt", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setCntcPsonFaxNo(JSPUtil.getParameter(request, prefix + "cntc_pson_fax_no", ""));
		setPoTrspAgmtRtTpCd(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_rt_tp_cd", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
		setPoTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_ofc_cty_cd", ""));
		setMltStopDeFlg(JSPUtil.getParameter(request, prefix + "mlt_stop_de_flg", ""));
		setTrspSoTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_tp_cd", ""));
		setRevCurrCd(JSPUtil.getParameter(request, prefix + "rev_curr_cd", ""));
		setDefaultSpFlg(JSPUtil.getParameter(request, prefix + "default_sp_flg", ""));
		setTrspDfltVndrFlg(JSPUtil.getParameter(request, prefix + "trsp_dflt_vndr_flg", ""));
		setPoCustSeq(JSPUtil.getParameter(request, prefix + "po_cust_seq", ""));
		setCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "cntc_pson_phn_no", ""));
		setSoCreDt(JSPUtil.getParameter(request, prefix + "so_cre_dt", ""));
		setCntrLbsWgt(JSPUtil.getParameter(request, prefix + "cntr_lbs_wgt", ""));
		setPoSpType(JSPUtil.getParameter(request, prefix + "po_sp_type", ""));
		setBkgspe(JSPUtil.getParameter(request, prefix + "bkgspe", ""));
		setDeliTimeDt(JSPUtil.getParameter(request, prefix + "deli_time_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setTrspSoOfcCtyCdSeq(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd_seq", ""));
		setPoCfmFlg(JSPUtil.getParameter(request, prefix + "po_cfm_flg", ""));
		setCtrtCnt(JSPUtil.getParameter(request, prefix + "ctrt_cnt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPoRtnMsg(JSPUtil.getParameter(request, prefix + "po_rtn_msg", ""));
		setRefId(JSPUtil.getParameter(request, prefix + "ref_id", ""));
		setTrspSpCngRsnCd(JSPUtil.getParameter(request, prefix + "trsp_sp_cng_rsn_cd", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setTrspRqstBkgFlg(JSPUtil.getParameter(request, prefix + "trsp_rqst_bkg_flg", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setN3ptyBzcCurrCd(JSPUtil.getParameter(request, prefix + "n3pty_bzc_curr_cd", ""));
		setPoCustCntCd(JSPUtil.getParameter(request, prefix + "po_cust_cnt_cd", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setPoCustCntCdSeq(JSPUtil.getParameter(request, prefix + "po_cust_cnt_cd_seq", ""));
		setNegoRmk(JSPUtil.getParameter(request, prefix + "nego_rmk", ""));
		setWoEdiUseFlg(JSPUtil.getParameter(request, prefix + "wo_edi_use_flg", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setMoreCandidates(JSPUtil.getParameter(request, prefix + "more_candidates", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, prefix + "spcl_instr_rmk", ""));
		setRevenue(JSPUtil.getParameter(request, prefix + "revenue", ""));
		setAppoTimeHms(JSPUtil.getParameter(request, prefix + "appo_time_hms", ""));
		setWoTotAmtUsd(JSPUtil.getParameter(request, prefix + "wo_tot_amt_usd", ""));
		setDorNodPlnTm(JSPUtil.getParameter(request, prefix + "dor_nod_pln_tm", ""));
		setOrgNegoAmt(JSPUtil.getParameter(request, prefix + "org_nego_amt", ""));
		setTroCfmUpdDt(JSPUtil.getParameter(request, prefix + "tro_cfm_upd_dt", ""));
		setPoRtnCd(JSPUtil.getParameter(request, prefix + "po_rtn_cd", ""));
		setPoLocalCurrCd(JSPUtil.getParameter(request, prefix + "po_local_curr_cd", ""));
		setDorLocValue(JSPUtil.getParameter(request, prefix + "dor_loc_value", ""));
		setNtfyCustNm(JSPUtil.getParameter(request, prefix + "ntfy_cust_nm", ""));
		setTrspWoOfcCtyCdSeq(JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd_seq", ""));
		setCustNomiTrkrFlg(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_flg", ""));
		setBlckStwg(JSPUtil.getParameter(request, prefix + "blck_stwg", ""));
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
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibVvdCd = (JSPUtil.getParameter(request, prefix	+ "ib_vvd_cd", length));
			String[] n3ptyBzcTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_tp_cd", length));
			String[] troCfmUpdTm = (JSPUtil.getParameter(request, prefix	+ "tro_cfm_upd_tm", length));
			String[] poVatScgRt = (JSPUtil.getParameter(request, prefix	+ "po_vat_scg_rt", length));
			String[] trspAgmtRtTpNm = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_rt_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3ptyBzcCustSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_cust_seq", length));
			String[] poFuelScgRt = (JSPUtil.getParameter(request, prefix	+ "po_fuel_scg_rt", length));
			String[] poUsdCurrTotAmt = (JSPUtil.getParameter(request, prefix	+ "po_usd_curr_tot_amt", length));
			String[] cntFlg = (JSPUtil.getParameter(request, prefix	+ "cnt_flg", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] mtyRrFlg = (JSPUtil.getParameter(request, prefix	+ "mty_rr_flg", length));
			String[] troCfmUsrId = (JSPUtil.getParameter(request, prefix	+ "tro_cfm_usr_id", length));
			String[] trspCostDtlModNm = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_nm", length));
			String[] actCustCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] negoAmt = (JSPUtil.getParameter(request, prefix	+ "nego_amt", length));
			String[] n3ptyBzcDesc = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_desc", length));
			String[] fctryNm = (JSPUtil.getParameter(request, prefix	+ "fctry_nm", length));
			String[] scgVatAmt = (JSPUtil.getParameter(request, prefix	+ "scg_vat_amt", length));
			String[] poAgmtUpdDt = (JSPUtil.getParameter(request, prefix	+ "po_agmt_upd_dt", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] poCustNomiTrkrIndCd = (JSPUtil.getParameter(request, prefix	+ "po_cust_nomi_trkr_ind_cd", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] fmLocValue = (JSPUtil.getParameter(request, prefix	+ "fm_loc_value", length));
			String[] fmYardValue = (JSPUtil.getParameter(request, prefix	+ "fm_yard_value", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] trspAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_wy_tp_cd", length));
			String[] deliTimeHms = (JSPUtil.getParameter(request, prefix	+ "deli_time_hms", length));
			String[] trspRjctRsnCd = (JSPUtil.getParameter(request, prefix	+ "trsp_rjct_rsn_cd", length));
			String[] lstNodPlnDt = (JSPUtil.getParameter(request, prefix	+ "lst_nod_pln_dt", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] fuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "fuel_scg_amt", length));
			String[] trspSpCngRsnRmk = (JSPUtil.getParameter(request, prefix	+ "trsp_sp_cng_rsn_rmk", length));
			String[] n3ptyBilFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_flg", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_seq", length));
			String[] n1stNodPlnDt = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_pln_dt", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] n1stNodPlnTm = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_pln_tm", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] ttlDist = (JSPUtil.getParameter(request, prefix	+ "ttl_dist", length));
			String[] cntrKgsWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_kgs_wgt", length));
			String[] bundlingNo = (JSPUtil.getParameter(request, prefix	+ "bundling_no", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] soCreNm = (JSPUtil.getParameter(request, prefix	+ "so_cre_nm", length));
			String[] spclCgoCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cntr_tp_cd", length));
			String[] trspAgmtRtTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_rt_tp_cd", length));
			String[] hzdMtrlFlg = (JSPUtil.getParameter(request, prefix	+ "hzd_mtrl_flg", length));
			String[] dorNodPlnDt = (JSPUtil.getParameter(request, prefix	+ "dor_nod_pln_dt", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] trspSoCmbTpNm = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_tp_nm", length));
			String[] woBlNoIssFlg = (JSPUtil.getParameter(request, prefix	+ "wo_bl_no_iss_flg", length));
			String[] woRmk = (JSPUtil.getParameter(request, prefix	+ "wo_rmk", length));
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] surchargeKey = (JSPUtil.getParameter(request, prefix	+ "surcharge_key", length));
			String[] fdrVvd = (JSPUtil.getParameter(request, prefix	+ "fdr_vvd", length));
			String[] costActGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_cd", length));
			String[] vgmFlg = (JSPUtil.getParameter(request, prefix	+ "vgm_flg", length));
			String[] wgtMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_meas_ut_cd", length));
			String[] troCfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "tro_cfm_ofc_cd", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] toYardValue = (JSPUtil.getParameter(request, prefix	+ "to_yard_value", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mcntrBdlSeq = (JSPUtil.getParameter(request, prefix	+ "mcntr_bdl_seq", length));
			String[] ctrtTpCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_tp_cd", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dorYardValue = (JSPUtil.getParameter(request, prefix	+ "dor_yard_value", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] poAgmtRtSeq = (JSPUtil.getParameter(request, prefix	+ "po_agmt_rt_seq", length));
			String[] presetVndrSeq = (JSPUtil.getParameter(request, prefix	+ "preset_vndr_seq", length));
			String[] etcAddAmt = (JSPUtil.getParameter(request, prefix	+ "etc_add_amt", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] poWayType = (JSPUtil.getParameter(request, prefix	+ "po_way_type", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] spType = (JSPUtil.getParameter(request, prefix	+ "sp_type", length));
			String[] bkgTroNo = (JSPUtil.getParameter(request, prefix	+ "bkg_tro_no", length));
			String[] poScg3Rt = (JSPUtil.getParameter(request, prefix	+ "po_scg3_rt", length));
			String[] rejectedCheck = (JSPUtil.getParameter(request, prefix	+ "rejected_check", length));
			String[] appoTimeDt = (JSPUtil.getParameter(request, prefix	+ "appo_time_dt", length));
			String[] obVvdCd = (JSPUtil.getParameter(request, prefix	+ "ob_vvd_cd", length));
			String[] trspSoCmbSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_seq", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
			String[] ctrtTpFlg = (JSPUtil.getParameter(request, prefix	+ "ctrt_tp_flg", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] poLocalCurrTotAmt = (JSPUtil.getParameter(request, prefix	+ "po_local_curr_tot_amt", length));
			String[] orgCurrCd = (JSPUtil.getParameter(request, prefix	+ "org_curr_cd", length));
			String[] poScg1Rt = (JSPUtil.getParameter(request, prefix	+ "po_scg1_rt", length));
			String[] lnkDistDivCd = (JSPUtil.getParameter(request, prefix	+ "lnk_dist_div_cd", length));
			String[] dorPstCd = (JSPUtil.getParameter(request, prefix	+ "dor_pst_cd", length));
			String[] trspFrstFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_frst_flg", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] trspSoTpNm = (JSPUtil.getParameter(request, prefix	+ "trsp_so_tp_nm", length));
			String[] tollFeeAmt = (JSPUtil.getParameter(request, prefix	+ "toll_fee_amt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] poCustNomiTrkrFlg = (JSPUtil.getParameter(request, prefix	+ "po_cust_nomi_trkr_flg", length));
			String[] cgoTpNm = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_nm", length));
			String[] trspSoCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_tp_cd", length));
			String[] poBasicRt = (JSPUtil.getParameter(request, prefix	+ "po_basic_rt", length));
			String[] woRjctDt = (JSPUtil.getParameter(request, prefix	+ "wo_rjct_dt", length));
			String[] poWtrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "po_wtr_rcv_term_cd", length));
			String[] woTotAmt = (JSPUtil.getParameter(request, prefix	+ "wo_tot_amt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bundlingFlg = (JSPUtil.getParameter(request, prefix	+ "bundling_flg", length));
			String[] cancelCheck = (JSPUtil.getParameter(request, prefix	+ "cancel_check", length));
			String[] distance = (JSPUtil.getParameter(request, prefix	+ "distance", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] n3ptyBzcCustCntCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_cust_cnt_cd", length));
			String[] poTrspAgmtRtTpNm = (JSPUtil.getParameter(request, prefix	+ "po_trsp_agmt_rt_tp_nm", length));
			String[] agmtMorCnddtAplyFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_mor_cnddt_aply_flg", length));
			String[] viaYardValue = (JSPUtil.getParameter(request, prefix	+ "via_yard_value", length));
			String[] shprCustNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_nm", length));
			String[] poWtrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "po_wtr_de_term_cd", length));
			String[] poOverWgtScgRt = (JSPUtil.getParameter(request, prefix	+ "po_over_wgt_scg_rt", length));
			String[] mcntrBdlGrpSeq = (JSPUtil.getParameter(request, prefix	+ "mcntr_bdl_grp_seq", length));
			String[] bzcAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_amt", length));
			String[] n3ptyBzcOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_ofc_cd", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] custCntCdSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd_seq", length));
			String[] distanceUom = (JSPUtil.getParameter(request, prefix	+ "distance_uom", length));
			String[] toLocValue = (JSPUtil.getParameter(request, prefix	+ "to_loc_value", length));
			String[] cneeCustNm = (JSPUtil.getParameter(request, prefix	+ "cnee_cust_nm", length));
			String[] viaLocValue = (JSPUtil.getParameter(request, prefix	+ "via_loc_value", length));
			String[] woCreNm = (JSPUtil.getParameter(request, prefix	+ "wo_cre_nm", length));
			String[] woRjctIndct = (JSPUtil.getParameter(request, prefix	+ "wo_rjct_indct", length));
			String[] n3ptyBzcAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_amt", length));
			String[] ovwtTriAxlFlg = (JSPUtil.getParameter(request, prefix	+ "ovwt_tri_axl_flg", length));
			String[] dtnUseFlg = (JSPUtil.getParameter(request, prefix	+ "dtn_use_flg", length));
			String[] troCnfm = (JSPUtil.getParameter(request, prefix	+ "tro_cnfm", length));
			String[] n3ptyBzcVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_vndr_seq", length));
			String[] trspCrrModNm = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_nm", length));
			String[] dorDeAddr = (JSPUtil.getParameter(request, prefix	+ "dor_de_addr", length));
			String[] woIssueDt = (JSPUtil.getParameter(request, prefix	+ "wo_issue_dt", length));
			String[] poTrspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "po_trsp_agmt_seq", length));
			String[] lstNodPlnTm = (JSPUtil.getParameter(request, prefix	+ "lst_nod_pln_tm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] poScg2Rt = (JSPUtil.getParameter(request, prefix	+ "po_scg2_rt", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] cntcPsonFaxNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_fax_no", length));
			String[] poTrspAgmtRtTpCd = (JSPUtil.getParameter(request, prefix	+ "po_trsp_agmt_rt_tp_cd", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] poTrspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "po_trsp_agmt_ofc_cty_cd", length));
			String[] mltStopDeFlg = (JSPUtil.getParameter(request, prefix	+ "mlt_stop_de_flg", length));
			String[] trspSoTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_tp_cd", length));
			String[] revCurrCd = (JSPUtil.getParameter(request, prefix	+ "rev_curr_cd", length));
			String[] defaultSpFlg = (JSPUtil.getParameter(request, prefix	+ "default_sp_flg", length));
			String[] trspDfltVndrFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_dflt_vndr_flg", length));
			String[] poCustSeq = (JSPUtil.getParameter(request, prefix	+ "po_cust_seq", length));
			String[] cntcPsonPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_phn_no", length));
			String[] soCreDt = (JSPUtil.getParameter(request, prefix	+ "so_cre_dt", length));
			String[] cntrLbsWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_lbs_wgt", length));
			String[] poSpType = (JSPUtil.getParameter(request, prefix	+ "po_sp_type", length));
			String[] bkgspe = (JSPUtil.getParameter(request, prefix	+ "bkgspe", length));
			String[] deliTimeDt = (JSPUtil.getParameter(request, prefix	+ "deli_time_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] trspSoOfcCtyCdSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd_seq", length));
			String[] poCfmFlg = (JSPUtil.getParameter(request, prefix	+ "po_cfm_flg", length));
			String[] ctrtCnt = (JSPUtil.getParameter(request, prefix	+ "ctrt_cnt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] poRtnMsg = (JSPUtil.getParameter(request, prefix	+ "po_rtn_msg", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] trspSpCngRsnCd = (JSPUtil.getParameter(request, prefix	+ "trsp_sp_cng_rsn_cd", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] trspRqstBkgFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_rqst_bkg_flg", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] n3ptyBzcCurrCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_curr_cd", length));
			String[] poCustCntCd = (JSPUtil.getParameter(request, prefix	+ "po_cust_cnt_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] poCustCntCdSeq = (JSPUtil.getParameter(request, prefix	+ "po_cust_cnt_cd_seq", length));
			String[] negoRmk = (JSPUtil.getParameter(request, prefix	+ "nego_rmk", length));
			String[] woEdiUseFlg = (JSPUtil.getParameter(request, prefix	+ "wo_edi_use_flg", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] moreCandidates = (JSPUtil.getParameter(request, prefix	+ "more_candidates", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_instr_rmk", length));
			String[] revenue = (JSPUtil.getParameter(request, prefix	+ "revenue", length));
			String[] appoTimeHms = (JSPUtil.getParameter(request, prefix	+ "appo_time_hms", length));
			String[] woTotAmtUsd = (JSPUtil.getParameter(request, prefix	+ "wo_tot_amt_usd", length));
			String[] dorNodPlnTm = (JSPUtil.getParameter(request, prefix	+ "dor_nod_pln_tm", length));
			String[] orgNegoAmt = (JSPUtil.getParameter(request, prefix	+ "org_nego_amt", length));
			String[] troCfmUpdDt = (JSPUtil.getParameter(request, prefix	+ "tro_cfm_upd_dt", length));
			String[] poRtnCd = (JSPUtil.getParameter(request, prefix	+ "po_rtn_cd", length));
			String[] poLocalCurrCd = (JSPUtil.getParameter(request, prefix	+ "po_local_curr_cd", length));
			String[] dorLocValue = (JSPUtil.getParameter(request, prefix	+ "dor_loc_value", length));
			String[] ntfyCustNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_cust_nm", length));
			String[] trspWoOfcCtyCdSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd_seq", length));
			String[] custNomiTrkrFlg = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_flg", length));
			String[] blckStwg = (JSPUtil.getParameter(request, prefix	+ "blck_stwg", length));
			
			for (int i = 0; i < length; i++) {
				model = new WoIssueListVO();
				if (ibVvdCd[i] != null)
					model.setIbVvdCd(ibVvdCd[i]);
				if (n3ptyBzcTpCd[i] != null)
					model.setN3ptyBzcTpCd(n3ptyBzcTpCd[i]);
				if (troCfmUpdTm[i] != null)
					model.setTroCfmUpdTm(troCfmUpdTm[i]);
				if (poVatScgRt[i] != null)
					model.setPoVatScgRt(poVatScgRt[i]);
				if (trspAgmtRtTpNm[i] != null)
					model.setTrspAgmtRtTpNm(trspAgmtRtTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3ptyBzcCustSeq[i] != null)
					model.setN3ptyBzcCustSeq(n3ptyBzcCustSeq[i]);
				if (poFuelScgRt[i] != null)
					model.setPoFuelScgRt(poFuelScgRt[i]);
				if (poUsdCurrTotAmt[i] != null)
					model.setPoUsdCurrTotAmt(poUsdCurrTotAmt[i]);
				if (cntFlg[i] != null)
					model.setCntFlg(cntFlg[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (mtyRrFlg[i] != null)
					model.setMtyRrFlg(mtyRrFlg[i]);
				if (troCfmUsrId[i] != null)
					model.setTroCfmUsrId(troCfmUsrId[i]);
				if (trspCostDtlModNm[i] != null)
					model.setTrspCostDtlModNm(trspCostDtlModNm[i]);
				if (actCustCd[i] != null)
					model.setActCustCd(actCustCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (negoAmt[i] != null)
					model.setNegoAmt(negoAmt[i]);
				if (n3ptyBzcDesc[i] != null)
					model.setN3ptyBzcDesc(n3ptyBzcDesc[i]);
				if (fctryNm[i] != null)
					model.setFctryNm(fctryNm[i]);
				if (scgVatAmt[i] != null)
					model.setScgVatAmt(scgVatAmt[i]);
				if (poAgmtUpdDt[i] != null)
					model.setPoAgmtUpdDt(poAgmtUpdDt[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (poCustNomiTrkrIndCd[i] != null)
					model.setPoCustNomiTrkrIndCd(poCustNomiTrkrIndCd[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (fmLocValue[i] != null)
					model.setFmLocValue(fmLocValue[i]);
				if (fmYardValue[i] != null)
					model.setFmYardValue(fmYardValue[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (trspAgmtWyTpCd[i] != null)
					model.setTrspAgmtWyTpCd(trspAgmtWyTpCd[i]);
				if (deliTimeHms[i] != null)
					model.setDeliTimeHms(deliTimeHms[i]);
				if (trspRjctRsnCd[i] != null)
					model.setTrspRjctRsnCd(trspRjctRsnCd[i]);
				if (lstNodPlnDt[i] != null)
					model.setLstNodPlnDt(lstNodPlnDt[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (fuelScgAmt[i] != null)
					model.setFuelScgAmt(fuelScgAmt[i]);
				if (trspSpCngRsnRmk[i] != null)
					model.setTrspSpCngRsnRmk(trspSpCngRsnRmk[i]);
				if (n3ptyBilFlg[i] != null)
					model.setN3ptyBilFlg(n3ptyBilFlg[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (n1stNodPlnDt[i] != null)
					model.setN1stNodPlnDt(n1stNodPlnDt[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (n1stNodPlnTm[i] != null)
					model.setN1stNodPlnTm(n1stNodPlnTm[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (ttlDist[i] != null)
					model.setTtlDist(ttlDist[i]);
				if (cntrKgsWgt[i] != null)
					model.setCntrKgsWgt(cntrKgsWgt[i]);
				if (bundlingNo[i] != null)
					model.setBundlingNo(bundlingNo[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (soCreNm[i] != null)
					model.setSoCreNm(soCreNm[i]);
				if (spclCgoCntrTpCd[i] != null)
					model.setSpclCgoCntrTpCd(spclCgoCntrTpCd[i]);
				if (trspAgmtRtTpCd[i] != null)
					model.setTrspAgmtRtTpCd(trspAgmtRtTpCd[i]);
				if (hzdMtrlFlg[i] != null)
					model.setHzdMtrlFlg(hzdMtrlFlg[i]);
				if (dorNodPlnDt[i] != null)
					model.setDorNodPlnDt(dorNodPlnDt[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (trspSoCmbTpNm[i] != null)
					model.setTrspSoCmbTpNm(trspSoCmbTpNm[i]);
				if (woBlNoIssFlg[i] != null)
					model.setWoBlNoIssFlg(woBlNoIssFlg[i]);
				if (woRmk[i] != null)
					model.setWoRmk(woRmk[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (surchargeKey[i] != null)
					model.setSurchargeKey(surchargeKey[i]);
				if (fdrVvd[i] != null)
					model.setFdrVvd(fdrVvd[i]);
				if (costActGrpCd[i] != null)
					model.setCostActGrpCd(costActGrpCd[i]);
				if (vgmFlg[i] != null)
					model.setVgmFlg(vgmFlg[i]);
				if (wgtMeasUtCd[i] != null)
					model.setWgtMeasUtCd(wgtMeasUtCd[i]);
				if (troCfmOfcCd[i] != null)
					model.setTroCfmOfcCd(troCfmOfcCd[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (toYardValue[i] != null)
					model.setToYardValue(toYardValue[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mcntrBdlSeq[i] != null)
					model.setMcntrBdlSeq(mcntrBdlSeq[i]);
				if (ctrtTpCd[i] != null)
					model.setCtrtTpCd(ctrtTpCd[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dorYardValue[i] != null)
					model.setDorYardValue(dorYardValue[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (poAgmtRtSeq[i] != null)
					model.setPoAgmtRtSeq(poAgmtRtSeq[i]);
				if (presetVndrSeq[i] != null)
					model.setPresetVndrSeq(presetVndrSeq[i]);
				if (etcAddAmt[i] != null)
					model.setEtcAddAmt(etcAddAmt[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (poWayType[i] != null)
					model.setPoWayType(poWayType[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (spType[i] != null)
					model.setSpType(spType[i]);
				if (bkgTroNo[i] != null)
					model.setBkgTroNo(bkgTroNo[i]);
				if (poScg3Rt[i] != null)
					model.setPoScg3Rt(poScg3Rt[i]);
				if (rejectedCheck[i] != null)
					model.setRejectedCheck(rejectedCheck[i]);
				if (appoTimeDt[i] != null)
					model.setAppoTimeDt(appoTimeDt[i]);
				if (obVvdCd[i] != null)
					model.setObVvdCd(obVvdCd[i]);
				if (trspSoCmbSeq[i] != null)
					model.setTrspSoCmbSeq(trspSoCmbSeq[i]);
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				if (ctrtTpFlg[i] != null)
					model.setCtrtTpFlg(ctrtTpFlg[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (poLocalCurrTotAmt[i] != null)
					model.setPoLocalCurrTotAmt(poLocalCurrTotAmt[i]);
				if (orgCurrCd[i] != null)
					model.setOrgCurrCd(orgCurrCd[i]);
				if (poScg1Rt[i] != null)
					model.setPoScg1Rt(poScg1Rt[i]);
				if (lnkDistDivCd[i] != null)
					model.setLnkDistDivCd(lnkDistDivCd[i]);
				if (dorPstCd[i] != null)
					model.setDorPstCd(dorPstCd[i]);
				if (trspFrstFlg[i] != null)
					model.setTrspFrstFlg(trspFrstFlg[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (trspSoTpNm[i] != null)
					model.setTrspSoTpNm(trspSoTpNm[i]);
				if (tollFeeAmt[i] != null)
					model.setTollFeeAmt(tollFeeAmt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (poCustNomiTrkrFlg[i] != null)
					model.setPoCustNomiTrkrFlg(poCustNomiTrkrFlg[i]);
				if (cgoTpNm[i] != null)
					model.setCgoTpNm(cgoTpNm[i]);
				if (trspSoCmbTpCd[i] != null)
					model.setTrspSoCmbTpCd(trspSoCmbTpCd[i]);
				if (poBasicRt[i] != null)
					model.setPoBasicRt(poBasicRt[i]);
				if (woRjctDt[i] != null)
					model.setWoRjctDt(woRjctDt[i]);
				if (poWtrRcvTermCd[i] != null)
					model.setPoWtrRcvTermCd(poWtrRcvTermCd[i]);
				if (woTotAmt[i] != null)
					model.setWoTotAmt(woTotAmt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bundlingFlg[i] != null)
					model.setBundlingFlg(bundlingFlg[i]);
				if (cancelCheck[i] != null)
					model.setCancelCheck(cancelCheck[i]);
				if (distance[i] != null)
					model.setDistance(distance[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (n3ptyBzcCustCntCd[i] != null)
					model.setN3ptyBzcCustCntCd(n3ptyBzcCustCntCd[i]);
				if (poTrspAgmtRtTpNm[i] != null)
					model.setPoTrspAgmtRtTpNm(poTrspAgmtRtTpNm[i]);
				if (agmtMorCnddtAplyFlg[i] != null)
					model.setAgmtMorCnddtAplyFlg(agmtMorCnddtAplyFlg[i]);
				if (viaYardValue[i] != null)
					model.setViaYardValue(viaYardValue[i]);
				if (shprCustNm[i] != null)
					model.setShprCustNm(shprCustNm[i]);
				if (poWtrDeTermCd[i] != null)
					model.setPoWtrDeTermCd(poWtrDeTermCd[i]);
				if (poOverWgtScgRt[i] != null)
					model.setPoOverWgtScgRt(poOverWgtScgRt[i]);
				if (mcntrBdlGrpSeq[i] != null)
					model.setMcntrBdlGrpSeq(mcntrBdlGrpSeq[i]);
				if (bzcAmt[i] != null)
					model.setBzcAmt(bzcAmt[i]);
				if (n3ptyBzcOfcCd[i] != null)
					model.setN3ptyBzcOfcCd(n3ptyBzcOfcCd[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (custCntCdSeq[i] != null)
					model.setCustCntCdSeq(custCntCdSeq[i]);
				if (distanceUom[i] != null)
					model.setDistanceUom(distanceUom[i]);
				if (toLocValue[i] != null)
					model.setToLocValue(toLocValue[i]);
				if (cneeCustNm[i] != null)
					model.setCneeCustNm(cneeCustNm[i]);
				if (viaLocValue[i] != null)
					model.setViaLocValue(viaLocValue[i]);
				if (woCreNm[i] != null)
					model.setWoCreNm(woCreNm[i]);
				if (woRjctIndct[i] != null)
					model.setWoRjctIndct(woRjctIndct[i]);
				if (n3ptyBzcAmt[i] != null)
					model.setN3ptyBzcAmt(n3ptyBzcAmt[i]);
				if (ovwtTriAxlFlg[i] != null)
					model.setOvwtTriAxlFlg(ovwtTriAxlFlg[i]);
				if (dtnUseFlg[i] != null)
					model.setDtnUseFlg(dtnUseFlg[i]);
				if (troCnfm[i] != null)
					model.setTroCnfm(troCnfm[i]);
				if (n3ptyBzcVndrSeq[i] != null)
					model.setN3ptyBzcVndrSeq(n3ptyBzcVndrSeq[i]);
				if (trspCrrModNm[i] != null)
					model.setTrspCrrModNm(trspCrrModNm[i]);
				if (dorDeAddr[i] != null)
					model.setDorDeAddr(dorDeAddr[i]);
				if (woIssueDt[i] != null)
					model.setWoIssueDt(woIssueDt[i]);
				if (poTrspAgmtSeq[i] != null)
					model.setPoTrspAgmtSeq(poTrspAgmtSeq[i]);
				if (lstNodPlnTm[i] != null)
					model.setLstNodPlnTm(lstNodPlnTm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (poScg2Rt[i] != null)
					model.setPoScg2Rt(poScg2Rt[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (cntcPsonFaxNo[i] != null)
					model.setCntcPsonFaxNo(cntcPsonFaxNo[i]);
				if (poTrspAgmtRtTpCd[i] != null)
					model.setPoTrspAgmtRtTpCd(poTrspAgmtRtTpCd[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (poTrspAgmtOfcCtyCd[i] != null)
					model.setPoTrspAgmtOfcCtyCd(poTrspAgmtOfcCtyCd[i]);
				if (mltStopDeFlg[i] != null)
					model.setMltStopDeFlg(mltStopDeFlg[i]);
				if (trspSoTpCd[i] != null)
					model.setTrspSoTpCd(trspSoTpCd[i]);
				if (revCurrCd[i] != null)
					model.setRevCurrCd(revCurrCd[i]);
				if (defaultSpFlg[i] != null)
					model.setDefaultSpFlg(defaultSpFlg[i]);
				if (trspDfltVndrFlg[i] != null)
					model.setTrspDfltVndrFlg(trspDfltVndrFlg[i]);
				if (poCustSeq[i] != null)
					model.setPoCustSeq(poCustSeq[i]);
				if (cntcPsonPhnNo[i] != null)
					model.setCntcPsonPhnNo(cntcPsonPhnNo[i]);
				if (soCreDt[i] != null)
					model.setSoCreDt(soCreDt[i]);
				if (cntrLbsWgt[i] != null)
					model.setCntrLbsWgt(cntrLbsWgt[i]);
				if (poSpType[i] != null)
					model.setPoSpType(poSpType[i]);
				if (bkgspe[i] != null)
					model.setBkgspe(bkgspe[i]);
				if (deliTimeDt[i] != null)
					model.setDeliTimeDt(deliTimeDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (trspSoOfcCtyCdSeq[i] != null)
					model.setTrspSoOfcCtyCdSeq(trspSoOfcCtyCdSeq[i]);
				if (poCfmFlg[i] != null)
					model.setPoCfmFlg(poCfmFlg[i]);
				if (ctrtCnt[i] != null)
					model.setCtrtCnt(ctrtCnt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (poRtnMsg[i] != null)
					model.setPoRtnMsg(poRtnMsg[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (trspSpCngRsnCd[i] != null)
					model.setTrspSpCngRsnCd(trspSpCngRsnCd[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (trspRqstBkgFlg[i] != null)
					model.setTrspRqstBkgFlg(trspRqstBkgFlg[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (n3ptyBzcCurrCd[i] != null)
					model.setN3ptyBzcCurrCd(n3ptyBzcCurrCd[i]);
				if (poCustCntCd[i] != null)
					model.setPoCustCntCd(poCustCntCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (poCustCntCdSeq[i] != null)
					model.setPoCustCntCdSeq(poCustCntCdSeq[i]);
				if (negoRmk[i] != null)
					model.setNegoRmk(negoRmk[i]);
				if (woEdiUseFlg[i] != null)
					model.setWoEdiUseFlg(woEdiUseFlg[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (moreCandidates[i] != null)
					model.setMoreCandidates(moreCandidates[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (revenue[i] != null)
					model.setRevenue(revenue[i]);
				if (appoTimeHms[i] != null)
					model.setAppoTimeHms(appoTimeHms[i]);
				if (woTotAmtUsd[i] != null)
					model.setWoTotAmtUsd(woTotAmtUsd[i]);
				if (dorNodPlnTm[i] != null)
					model.setDorNodPlnTm(dorNodPlnTm[i]);
				if (orgNegoAmt[i] != null)
					model.setOrgNegoAmt(orgNegoAmt[i]);
				if (troCfmUpdDt[i] != null)
					model.setTroCfmUpdDt(troCfmUpdDt[i]);
				if (poRtnCd[i] != null)
					model.setPoRtnCd(poRtnCd[i]);
				if (poLocalCurrCd[i] != null)
					model.setPoLocalCurrCd(poLocalCurrCd[i]);
				if (dorLocValue[i] != null)
					model.setDorLocValue(dorLocValue[i]);
				if (ntfyCustNm[i] != null)
					model.setNtfyCustNm(ntfyCustNm[i]);
				if (trspWoOfcCtyCdSeq[i] != null)
					model.setTrspWoOfcCtyCdSeq(trspWoOfcCtyCdSeq[i]);
				if (custNomiTrkrFlg[i] != null)
					model.setCustNomiTrkrFlg(custNomiTrkrFlg[i]);
				if (blckStwg[i] != null)
					model.setBlckStwg(blckStwg[i]);
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
	public WoIssueListVO[] getWoIssueListVOs(){
		WoIssueListVO[] vos = (WoIssueListVO[])models.toArray(new WoIssueListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ibVvdCd = this.ibVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcTpCd = this.n3ptyBzcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmUpdTm = this.troCfmUpdTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poVatScgRt = this.poVatScgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtTpNm = this.trspAgmtRtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcCustSeq = this.n3ptyBzcCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poFuelScgRt = this.poFuelScgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poUsdCurrTotAmt = this.poUsdCurrTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntFlg = this.cntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRrFlg = this.mtyRrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmUsrId = this.troCfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModNm = this.trspCostDtlModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCd = this.actCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoAmt = this.negoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcDesc = this.n3ptyBzcDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctryNm = this.fctryNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgVatAmt = this.scgVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poAgmtUpdDt = this.poAgmtUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustNomiTrkrIndCd = this.poCustNomiTrkrIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocValue = this.fmLocValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYardValue = this.fmYardValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtWyTpCd = this.trspAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deliTimeHms = this.deliTimeHms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRjctRsnCd = this.trspRjctRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstNodPlnDt = this.lstNodPlnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelScgAmt = this.fuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSpCngRsnRmk = this.trspSpCngRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilFlg = this.n3ptyBilFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodPlnDt = this.n1stNodPlnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodPlnTm = this.n1stNodPlnTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDist = this.ttlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrKgsWgt = this.cntrKgsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bundlingNo = this.bundlingNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreNm = this.soCreNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCntrTpCd = this.spclCgoCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtTpCd = this.trspAgmtRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdMtrlFlg = this.hzdMtrlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodPlnDt = this.dorNodPlnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbTpNm = this.trspSoCmbTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woBlNoIssFlg = this.woBlNoIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woRmk = this.woRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq = this.trspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surchargeKey = this.surchargeKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVvd = this.fdrVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpCd = this.costActGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmFlg = this.vgmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtMeasUtCd = this.wgtMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmOfcCd = this.troCfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYardValue = this.toYardValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrBdlSeq = this.mcntrBdlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtTpCd = this.ctrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorYardValue = this.dorYardValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poAgmtRtSeq = this.poAgmtRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.presetVndrSeq = this.presetVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcAddAmt = this.etcAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poWayType = this.poWayType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spType = this.spType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTroNo = this.bkgTroNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poScg3Rt = this.poScg3Rt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejectedCheck = this.rejectedCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appoTimeDt = this.appoTimeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obVvdCd = this.obVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbSeq = this.trspSoCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtTpFlg = this.ctrtTpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poLocalCurrTotAmt = this.poLocalCurrTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCurrCd = this.orgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poScg1Rt = this.poScg1Rt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDistDivCd = this.lnkDistDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorPstCd = this.dorPstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspFrstFlg = this.trspFrstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpNm = this.trspSoTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tollFeeAmt = this.tollFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustNomiTrkrFlg = this.poCustNomiTrkrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpNm = this.cgoTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbTpCd = this.trspSoCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poBasicRt = this.poBasicRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woRjctDt = this.woRjctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poWtrRcvTermCd = this.poWtrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTotAmt = this.woTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bundlingFlg = this.bundlingFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cancelCheck = this.cancelCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distance = this.distance .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcCustCntCd = this.n3ptyBzcCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtRtTpNm = this.poTrspAgmtRtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtMorCnddtAplyFlg = this.agmtMorCnddtAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaYardValue = this.viaYardValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustNm = this.shprCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poWtrDeTermCd = this.poWtrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poOverWgtScgRt = this.poOverWgtScgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrBdlGrpSeq = this.mcntrBdlGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt = this.bzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcOfcCd = this.n3ptyBzcOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCdSeq = this.custCntCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distanceUom = this.distanceUom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocValue = this.toLocValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCustNm = this.cneeCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaLocValue = this.viaLocValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCreNm = this.woCreNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woRjctIndct = this.woRjctIndct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcAmt = this.n3ptyBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovwtTriAxlFlg = this.ovwtTriAxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtnUseFlg = this.dtnUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCnfm = this.troCnfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcVndrSeq = this.n3ptyBzcVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModNm = this.trspCrrModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorDeAddr = this.dorDeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssueDt = this.woIssueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtSeq = this.poTrspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstNodPlnTm = this.lstNodPlnTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poScg2Rt = this.poScg2Rt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonFaxNo = this.cntcPsonFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtRtTpCd = this.poTrspAgmtRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtOfcCtyCd = this.poTrspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltStopDeFlg = this.mltStopDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpCd = this.trspSoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCurrCd = this.revCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.defaultSpFlg = this.defaultSpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDfltVndrFlg = this.trspDfltVndrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustSeq = this.poCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonPhnNo = this.cntcPsonPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreDt = this.soCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLbsWgt = this.cntrLbsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poSpType = this.poSpType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgspe = this.bkgspe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deliTimeDt = this.deliTimeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCdSeq = this.trspSoOfcCtyCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCfmFlg = this.poCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCnt = this.ctrtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poRtnMsg = this.poRtnMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSpCngRsnCd = this.trspSpCngRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRqstBkgFlg = this.trspRqstBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcCurrCd = this.n3ptyBzcCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustCntCd = this.poCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustCntCdSeq = this.poCustCntCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoRmk = this.negoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woEdiUseFlg = this.woEdiUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.moreCandidates = this.moreCandidates .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revenue = this.revenue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appoTimeHms = this.appoTimeHms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTotAmtUsd = this.woTotAmtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodPlnTm = this.dorNodPlnTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgNegoAmt = this.orgNegoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmUpdDt = this.troCfmUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poRtnCd = this.poRtnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poLocalCurrCd = this.poLocalCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorLocValue = this.dorLocValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCustNm = this.ntfyCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCdSeq = this.trspWoOfcCtyCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrFlg = this.custNomiTrkrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwg = this.blckStwg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
