/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SingleTransportationVO.java
*@FileTitle : SingleTransportationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.08
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.09.08 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo;

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
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SingleTransportationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SingleTransportationVO> models = new ArrayList<SingleTransportationVO>();
	
	/* Column Info */
	private String toNodCd2 = null;
	/* Column Info */
	private String ibVvdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prePullFlg = null;
	/* Column Info */
	private String fdrVslCd = null;
	/* Column Info */
	private String ibdCstmsClrLocCd = null;
	/* Column Info */
	private String actCustAddrSeq = null;
	/* Column Info */
	private String lstFreeDtHms = null;
	/* Column Info */
	private String cntFlg = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String troCfmUsrId = null;
	/* Column Info */
	private String troLodRefNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cgorOrgBlRcvrIndFlg = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String negoAmt = null;
	/* Column Info */
	private String fctryNm = null;
	/* Column Info */
	private String shprSeq = null;
	/* Column Info */
	private String dorNodYard2 = null;
	/* Column Info */
	private String cmdtName = null;
	/* Column Info */
	private String uplnSoFlg = null;
	/* Column Info */
	private String toNodYard = null;
	/* Column Info */
	private String fmNodCd2 = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String cgorCstmsAcptReIndFlg = null;
	/* Column Info */
	private String fmNodYard = null;
	/* Column Info */
	private String trspRqstOrdSeq = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String railCreDt = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String trspRqstOrdRevAmt = null;
	/* Column Info */
	private String lstFreeDt = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String trnsRqstUsrId = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String lstNodPlnDt = null;
	/* Column Info */
	private String podContiCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String lseCntrFlg = null;
	/* Column Info */
	private String fuelScgAmt = null;
	/* Column Info */
	private String n3ptyBilFlg = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String n1stNodPlnDt = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String cgorFrtPayIndFlg = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String ifSysKndCd = null;
	/* Column Info */
	private String cmbSoRltStsFlg = null;
	/* Column Info */
	private String actGrpCd = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String cntrKgsWgt = null;
	/* Column Info */
	private String ttlDist = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String spclCgoCntrTpCd = null;
	/* Column Info */
	private String woIssKnt = null;
	/* Column Info */
	private String blNoChk = null;
	/* Column Info */
	private String rplnUmchFlg = null;
	/* Column Info */
	private String dorNodPlnDt = null;
	/* Column Info */
	private String cstmsClrNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String trspCrrModCd2 = null;
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String trunkvvd = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String trspMtyRqstDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String costActGrpCd = null;
	/* Column Info */
	private String wgtMeasUtCd = null;
	/* Column Info */
	private String troCfmOfcCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String splIssRsn = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trspSoStsNm = null;
	/* Column Info */
	private String avalDtHms = null;
	/* Column Info */
	private String fdrSkdDirCd = null;
	/* Column Info */
	private String trspMtyCostModCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spotBidDueDtHms = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String trspSoCmbSrtNo = null;
	/* Column Info */
	private String railCmbThruTpCd = null;
	/* Column Info */
	private String etcAddAmt = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String bkgEdiRefNo = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String feedervvd = null;
	/* Column Info */
	private String trspNxtPortCd = null;
	/* Column Info */
	private String refSeq = null;
	/* Column Info */
	private String obVvdCd = null;
	/* Column Info */
	private String chssMgstTrspTpCd = null;
	/* Column Info */
	private String trspSoCmbSeq = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String lstNodPlnDtHms = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* Column Info */
	private String lnkDistDivCd = null;
	/* Column Info */
	private String dorPstCd = null;
	/* Column Info */
	private String railToNodCd = null;
	/* Column Info */
	private String subEqTpszCd = null;
	/* Column Info */
	private String n1stNodPlnDtHms = null;
	/* Column Info */
	private String bkgRcvdeTermCd = null;
	/* Column Info */
	private String trnsRqstOfcCd = null;
	/* Column Info */
	private String toNodYard2 = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String troSubSeq = null;
	/* Column Info */
	private String trspSoCmbTpCd = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String cntrPkupNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String trspCostDtlModSep = null;
	/* Column Info */
	private String dorArrDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String viaNodCd2 = null;
	/* Column Info */
	private String woIssStsCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String dorSvcTpCd = null;
	/* Column Info */
	private String trspSoStsCd = null;
	/* Column Info */
	private String shprCustNm = null;
	/* Column Info */
	private String cntrSubFlg = null;
	/* Column Info */
	private String dorNodCd2 = null;
	/* Column Info */
	private String troCfmRevAmt = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String bzcAmt = null;
	/* Column Info */
	private String mstLclCd = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String viaNodYard2 = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String cneeCustNm = null;
	/* Column Info */
	private String exSepData = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String lstmExpFlg = null;
	/* Column Info */
	private String troRepCmdtCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String dorNodYardNm = null;
	/* Column Info */
	private String lstLocCd = null;
	/* Column Info */
	private String cntrPkupYdCd = null;
	/* Column Info */
	private String dorDeAddr = null;
	/* Column Info */
	private String dorNodPlnDtHms = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String fdrSkdVoyNo = null;
	/* Column Info */
	private String cngRsnDesc = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String trspRqstOrdBndCd = null;
	/* Column Info */
	private String cntcPsonFaxNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String mltStopDeFlg = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String trspSoTpCd = null;
	/* Column Info */
	private String revCurrCd = null;
	/* Column Info */
	private String ownrCoCd = null;
	/* Column Info */
	private String dorNodYard = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cntcPsonPhnNo = null;
	/* Column Info */
	private String cntrLbsWgt = null;
	/* Column Info */
	private String trnsRqstRsn = null;
	/* Column Info */
	private String viaNodYard = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ctrtCnt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String fmLocContiCd = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String spotBidFlg = null;
	/* Column Info */
	private String trspRqstBkgFlg = null;
	/* Column Info */
	private String orgToYdCd = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String fmNodYard2 = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String repoRefNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String spotBidNo = null;
	/* Column Info */
	private String cbstatus = null;
	/* Column Info */
	private String spclInstrRmk = null;
	/* Column Info */
	private String ovrWgtScgAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String troCfmUpdDt1 = null;
	/* Column Info */
	private String troCfmUpdDt2 = null;
	/* Column Info */
	private String trspPurpRsn = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String cneeSeq = null;
	/* Column Info */
	private String spotBidDueDt = null;
	/* Column Info */
	private String avalDt = null;
	/* Column Info */
	private String repoRefSeq = null;
	/* Column Info */
	private String ntfyCustNm = null;
	/* Column Info */
	private String custNomiTrkrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SingleTransportationVO() {}

	public SingleTransportationVO(String ibflag, String pagerows, String toNodCd2, String ibVvdCd, String prePullFlg, String fdrVslCd, String ibdCstmsClrLocCd, String actCustAddrSeq, String lstFreeDtHms, String cntFlg, String cntrWgt, String troCfmUsrId, String troLodRefNo, String cgorOrgBlRcvrIndFlg, String skdVoyNo, String eqTpszCd, String negoAmt, String fctryNm, String shprSeq, String dorNodYard2, String cmdtName, String uplnSoFlg, String toNodYard, String fmNodCd2, String plnYrwk, String cgorCstmsAcptReIndFlg, String fmNodYard, String trspRqstOrdSeq, String interRmk, String railCreDt, String dorNodCd, String actCustCntCd, String trspRqstOrdRevAmt, String lstFreeDt, String trspCrrModCd, String trnsRqstUsrId, String bkgNoSplit, String lstNodPlnDt, String podContiCd, String eqKndCd, String lseCntrFlg, String fuelScgAmt, String n3ptyBilFlg, String costActGrpSeq, String n1stNodPlnDt, String lgsCostCd, String cgorFrtPayIndFlg, String viaNodCd, String ifSysKndCd, String cmbSoRltStsFlg, String actGrpCd, String repCmdtCd, String toNodCd, String ttlDist, String cntrKgsWgt, String trspSoSeq, String copNo, String spclCgoCntrTpCd, String rplnUmchFlg, String blNoChk, String woIssKnt, String dorNodPlnDt, String cstmsClrNo, String scNo, String blNoTp, String trspCrrModCd2, String trspWoSeq, String trunkvvd, String ctrlOfcCd, String trspMtyRqstDt, String costActGrpCd, String creUsrId, String wgtMeasUtCd, String troCfmOfcCd, String porCd, String contiCd, String splIssRsn, String creDt, String trspSoStsNm, String avalDtHms, String fdrSkdDirCd, String rfaNo, String trspMtyCostModCd, String spotBidDueDtHms, String cntcPsonNm, String trspSoCmbSrtNo, String railCmbThruTpCd, String etcAddAmt, String trspBndCd, String bkgEdiRefNo, String troSeq, String custSeq, String feedervvd, String trspNxtPortCd, String refSeq, String obVvdCd, String chssMgstTrspTpCd, String trspSoCmbSeq, String bkgCgoTpCd, String lstNodPlnDtHms, String cgoTpCd, String cneeCntCd, String lnkDistDivCd, String dorPstCd, String railToNodCd, String subEqTpszCd, String n1stNodPlnDtHms, String bkgRcvdeTermCd, String trnsRqstOfcCd, String toNodYard2, String custCntCd, String updUsrId, String troSubSeq, String trspSoCmbTpCd, String shprCntCd, String cntrPkupNo, String podCd, String bkgNo, String trspCostDtlModSep, String dorArrDt, String deltFlg, String viaNodCd2, String woIssStsCd, String cmdtCd, String dorSvcTpCd, String trspSoStsCd, String shprCustNm, String cntrSubFlg, String dorNodCd2, String troCfmRevAmt, String actCustSeq, String bzcAmt, String mstLclCd, String trspWoOfcCtyCd, String viaNodYard2, String fmNodCd, String slanCd, String cneeCustNm, String exSepData, String imdtExtFlg, String lstmExpFlg, String troRepCmdtCd, String vslCd, String dorNodYardNm, String lstLocCd, String cntrPkupYdCd, String dorDeAddr, String dorNodPlnDtHms, String blNo, String fdrSkdVoyNo, String cngRsnDesc, String ctrtNo, String trspRqstOrdBndCd, String cntcPsonFaxNo, String polCd, String trspCostDtlModCd, String mltStopDeFlg, String lstmCd, String trspSoTpCd, String revCurrCd, String ownrCoCd, String dorNodYard, String delCd, String cntcPsonPhnNo, String cntrLbsWgt, String trnsRqstRsn, String viaNodYard, String vndrSeq, String ctrtCnt, String currCd, String fmLocContiCd, String refId, String spotBidFlg, String spotBidNo, String trspRqstBkgFlg, String orgToYdCd, String trspSoOfcCtyCd, String fmNodYard2, String eqNo, String repoRefNo, String creOfcCd, String cbstatus, String spclInstrRmk, String ovrWgtScgAmt, String updDt, String troCfmUpdDt1, String troCfmUpdDt2, String trspPurpRsn, String skdDirCd, String repoPlnId, String cneeSeq, String spotBidDueDt, String avalDt, String repoRefSeq, String ntfyCustNm, String custNomiTrkrFlg) {
		this.toNodCd2 = toNodCd2;
		this.ibVvdCd = ibVvdCd;
		this.pagerows = pagerows;
		this.prePullFlg = prePullFlg;
		this.fdrVslCd = fdrVslCd;
		this.ibdCstmsClrLocCd = ibdCstmsClrLocCd;
		this.actCustAddrSeq = actCustAddrSeq;
		this.lstFreeDtHms = lstFreeDtHms;
		this.cntFlg = cntFlg;
		this.cntrWgt = cntrWgt;
		this.troCfmUsrId = troCfmUsrId;
		this.troLodRefNo = troLodRefNo;
		this.skdVoyNo = skdVoyNo;
		this.cgorOrgBlRcvrIndFlg = cgorOrgBlRcvrIndFlg;
		this.eqTpszCd = eqTpszCd;
		this.negoAmt = negoAmt;
		this.fctryNm = fctryNm;
		this.shprSeq = shprSeq;
		this.dorNodYard2 = dorNodYard2;
		this.cmdtName = cmdtName;
		this.uplnSoFlg = uplnSoFlg;
		this.toNodYard = toNodYard;
		this.fmNodCd2 = fmNodCd2;
		this.plnYrwk = plnYrwk;
		this.cgorCstmsAcptReIndFlg = cgorCstmsAcptReIndFlg;
		this.fmNodYard = fmNodYard;
		this.trspRqstOrdSeq = trspRqstOrdSeq;
		this.interRmk = interRmk;
		this.railCreDt = railCreDt;
		this.dorNodCd = dorNodCd;
		this.actCustCntCd = actCustCntCd;
		this.trspRqstOrdRevAmt = trspRqstOrdRevAmt;
		this.lstFreeDt = lstFreeDt;
		this.trspCrrModCd = trspCrrModCd;
		this.trnsRqstUsrId = trnsRqstUsrId;
		this.bkgNoSplit = bkgNoSplit;
		this.lstNodPlnDt = lstNodPlnDt;
		this.podContiCd = podContiCd;
		this.eqKndCd = eqKndCd;
		this.lseCntrFlg = lseCntrFlg;
		this.fuelScgAmt = fuelScgAmt;
		this.n3ptyBilFlg = n3ptyBilFlg;
		this.costActGrpSeq = costActGrpSeq;
		this.n1stNodPlnDt = n1stNodPlnDt;
		this.lgsCostCd = lgsCostCd;
		this.cgorFrtPayIndFlg = cgorFrtPayIndFlg;
		this.viaNodCd = viaNodCd;
		this.ifSysKndCd = ifSysKndCd;
		this.cmbSoRltStsFlg = cmbSoRltStsFlg;
		this.actGrpCd = actGrpCd;
		this.repCmdtCd = repCmdtCd;
		this.cntrKgsWgt = cntrKgsWgt;
		this.ttlDist = ttlDist;
		this.toNodCd = toNodCd;
		this.trspSoSeq = trspSoSeq;
		this.copNo = copNo;
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
		this.woIssKnt = woIssKnt;
		this.blNoChk = blNoChk;
		this.rplnUmchFlg = rplnUmchFlg;
		this.dorNodPlnDt = dorNodPlnDt;
		this.cstmsClrNo = cstmsClrNo;
		this.scNo = scNo;
		this.blNoTp = blNoTp;
		this.trspCrrModCd2 = trspCrrModCd2;
		this.trspWoSeq = trspWoSeq;
		this.trunkvvd = trunkvvd;
		this.ctrlOfcCd = ctrlOfcCd;
		this.trspMtyRqstDt = trspMtyRqstDt;
		this.creUsrId = creUsrId;
		this.costActGrpCd = costActGrpCd;
		this.wgtMeasUtCd = wgtMeasUtCd;
		this.troCfmOfcCd = troCfmOfcCd;
		this.porCd = porCd;
		this.contiCd = contiCd;
		this.splIssRsn = splIssRsn;
		this.creDt = creDt;
		this.trspSoStsNm = trspSoStsNm;
		this.avalDtHms = avalDtHms;
		this.fdrSkdDirCd = fdrSkdDirCd;
		this.trspMtyCostModCd = trspMtyCostModCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.spotBidDueDtHms = spotBidDueDtHms;
		this.cntcPsonNm = cntcPsonNm;
		this.trspSoCmbSrtNo = trspSoCmbSrtNo;
		this.railCmbThruTpCd = railCmbThruTpCd;
		this.etcAddAmt = etcAddAmt;
		this.trspBndCd = trspBndCd;
		this.bkgEdiRefNo = bkgEdiRefNo;
		this.troSeq = troSeq;
		this.custSeq = custSeq;
		this.feedervvd = feedervvd;
		this.trspNxtPortCd = trspNxtPortCd;
		this.refSeq = refSeq;
		this.obVvdCd = obVvdCd;
		this.chssMgstTrspTpCd = chssMgstTrspTpCd;
		this.trspSoCmbSeq = trspSoCmbSeq;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.lstNodPlnDtHms = lstNodPlnDtHms;
		this.cgoTpCd = cgoTpCd;
		this.cneeCntCd = cneeCntCd;
		this.lnkDistDivCd = lnkDistDivCd;
		this.dorPstCd = dorPstCd;
		this.railToNodCd = railToNodCd;
		this.subEqTpszCd = subEqTpszCd;
		this.n1stNodPlnDtHms = n1stNodPlnDtHms;
		this.bkgRcvdeTermCd = bkgRcvdeTermCd;
		this.trnsRqstOfcCd = trnsRqstOfcCd;
		this.toNodYard2 = toNodYard2;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.troSubSeq = troSubSeq;
		this.trspSoCmbTpCd = trspSoCmbTpCd;
		this.shprCntCd = shprCntCd;
		this.cntrPkupNo = cntrPkupNo;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.trspCostDtlModSep = trspCostDtlModSep;
		this.dorArrDt = dorArrDt;
		this.deltFlg = deltFlg;
		this.viaNodCd2 = viaNodCd2;
		this.woIssStsCd = woIssStsCd;
		this.cmdtCd = cmdtCd;
		this.dorSvcTpCd = dorSvcTpCd;
		this.trspSoStsCd = trspSoStsCd;
		this.shprCustNm = shprCustNm;
		this.cntrSubFlg = cntrSubFlg;
		this.dorNodCd2 = dorNodCd2;
		this.troCfmRevAmt = troCfmRevAmt;
		this.actCustSeq = actCustSeq;
		this.bzcAmt = bzcAmt;
		this.mstLclCd = mstLclCd;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.viaNodYard2 = viaNodYard2;
		this.fmNodCd = fmNodCd;
		this.slanCd = slanCd;
		this.cneeCustNm = cneeCustNm;
		this.exSepData = exSepData;
		this.imdtExtFlg = imdtExtFlg;
		this.lstmExpFlg = lstmExpFlg;
		this.troRepCmdtCd = troRepCmdtCd;
		this.vslCd = vslCd;
		this.dorNodYardNm = dorNodYardNm;
		this.lstLocCd = lstLocCd;
		this.cntrPkupYdCd = cntrPkupYdCd;
		this.dorDeAddr = dorDeAddr;
		this.dorNodPlnDtHms = dorNodPlnDtHms;
		this.blNo = blNo;
		this.fdrSkdVoyNo = fdrSkdVoyNo;
		this.cngRsnDesc = cngRsnDesc;
		this.ctrtNo = ctrtNo;
		this.trspRqstOrdBndCd = trspRqstOrdBndCd;
		this.cntcPsonFaxNo = cntcPsonFaxNo;
		this.polCd = polCd;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.mltStopDeFlg = mltStopDeFlg;
		this.lstmCd = lstmCd;
		this.trspSoTpCd = trspSoTpCd;
		this.revCurrCd = revCurrCd;
		this.ownrCoCd = ownrCoCd;
		this.dorNodYard = dorNodYard;
		this.delCd = delCd;
		this.cntcPsonPhnNo = cntcPsonPhnNo;
		this.cntrLbsWgt = cntrLbsWgt;
		this.trnsRqstRsn = trnsRqstRsn;
		this.viaNodYard = viaNodYard;
		this.vndrSeq = vndrSeq;
		this.ctrtCnt = ctrtCnt;
		this.currCd = currCd;
		this.fmLocContiCd = fmLocContiCd;
		this.refId = refId;
		this.spotBidFlg = spotBidFlg;
		this.trspRqstBkgFlg = trspRqstBkgFlg;
		this.orgToYdCd = orgToYdCd;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.fmNodYard2 = fmNodYard2;
		this.eqNo = eqNo;
		this.repoRefNo = repoRefNo;
		this.creOfcCd = creOfcCd;
		this.spotBidNo = spotBidNo;
		this.cbstatus = cbstatus;
		this.spclInstrRmk = spclInstrRmk;
		this.ovrWgtScgAmt = ovrWgtScgAmt;
		this.updDt = updDt;
		this.troCfmUpdDt1 = troCfmUpdDt1;
		this.troCfmUpdDt2 = troCfmUpdDt2;
		this.trspPurpRsn = trspPurpRsn;
		this.skdDirCd = skdDirCd;
		this.repoPlnId = repoPlnId;
		this.cneeSeq = cneeSeq;
		this.spotBidDueDt = spotBidDueDt;
		this.avalDt = avalDt;
		this.repoRefSeq = repoRefSeq;
		this.ntfyCustNm = ntfyCustNm;
		this.custNomiTrkrFlg = custNomiTrkrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd2", getToNodCd2());
		this.hashColumns.put("ib_vvd_cd", getIbVvdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pre_pull_flg", getPrePullFlg());
		this.hashColumns.put("fdr_vsl_cd", getFdrVslCd());
		this.hashColumns.put("ibd_cstms_clr_loc_cd", getIbdCstmsClrLocCd());
		this.hashColumns.put("act_cust_addr_seq", getActCustAddrSeq());
		this.hashColumns.put("lst_free_dt_hms", getLstFreeDtHms());
		this.hashColumns.put("cnt_flg", getCntFlg());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("tro_cfm_usr_id", getTroCfmUsrId());
		this.hashColumns.put("tro_lod_ref_no", getTroLodRefNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cgor_org_bl_rcvr_ind_flg", getCgorOrgBlRcvrIndFlg());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("nego_amt", getNegoAmt());
		this.hashColumns.put("fctry_nm", getFctryNm());
		this.hashColumns.put("shpr_seq", getShprSeq());
		this.hashColumns.put("dor_nod_yard2", getDorNodYard2());
		this.hashColumns.put("cmdt_name", getCmdtName());
		this.hashColumns.put("upln_so_flg", getUplnSoFlg());
		this.hashColumns.put("to_nod_yard", getToNodYard());
		this.hashColumns.put("fm_nod_cd2", getFmNodCd2());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("cgor_cstms_acpt_re_ind_flg", getCgorCstmsAcptReIndFlg());
		this.hashColumns.put("fm_nod_yard", getFmNodYard());
		this.hashColumns.put("trsp_rqst_ord_seq", getTrspRqstOrdSeq());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("rail_cre_dt", getRailCreDt());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("trsp_rqst_ord_rev_amt", getTrspRqstOrdRevAmt());
		this.hashColumns.put("lst_free_dt", getLstFreeDt());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("trns_rqst_usr_id", getTrnsRqstUsrId());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("lst_nod_pln_dt", getLstNodPlnDt());
		this.hashColumns.put("pod_conti_cd", getPodContiCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("lse_cntr_flg", getLseCntrFlg());
		this.hashColumns.put("fuel_scg_amt", getFuelScgAmt());
		this.hashColumns.put("n3pty_bil_flg", getN3ptyBilFlg());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("n1st_nod_pln_dt", getN1stNodPlnDt());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("cgor_frt_pay_ind_flg", getCgorFrtPayIndFlg());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("if_sys_knd_cd", getIfSysKndCd());
		this.hashColumns.put("cmb_so_rlt_sts_flg", getCmbSoRltStsFlg());
		this.hashColumns.put("act_grp_cd", getActGrpCd());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("cntr_kgs_wgt", getCntrKgsWgt());
		this.hashColumns.put("ttl_dist", getTtlDist());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("spcl_cgo_cntr_tp_cd", getSpclCgoCntrTpCd());
		this.hashColumns.put("wo_iss_knt", getWoIssKnt());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("rpln_umch_flg", getRplnUmchFlg());
		this.hashColumns.put("dor_nod_pln_dt", getDorNodPlnDt());
		this.hashColumns.put("cstms_clr_no", getCstmsClrNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("trsp_crr_mod_cd2", getTrspCrrModCd2());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("trunkvvd", getTrunkvvd());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("trsp_mty_rqst_dt", getTrspMtyRqstDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cost_act_grp_cd", getCostActGrpCd());
		this.hashColumns.put("wgt_meas_ut_cd", getWgtMeasUtCd());
		this.hashColumns.put("tro_cfm_ofc_cd", getTroCfmOfcCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("spl_iss_rsn", getSplIssRsn());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trsp_so_sts_nm", getTrspSoStsNm());
		this.hashColumns.put("aval_dt_hms", getAvalDtHms());
		this.hashColumns.put("fdr_skd_dir_cd", getFdrSkdDirCd());
		this.hashColumns.put("trsp_mty_cost_mod_cd", getTrspMtyCostModCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spot_bid_due_dt_hms", getSpotBidDueDtHms());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("trsp_so_cmb_srt_no", getTrspSoCmbSrtNo());
		this.hashColumns.put("rail_cmb_thru_tp_cd", getRailCmbThruTpCd());
		this.hashColumns.put("etc_add_amt", getEtcAddAmt());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("bkg_edi_ref_no", getBkgEdiRefNo());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("feedervvd", getFeedervvd());
		this.hashColumns.put("trsp_nxt_port_cd", getTrspNxtPortCd());
		this.hashColumns.put("ref_seq", getRefSeq());
		this.hashColumns.put("ob_vvd_cd", getObVvdCd());
		this.hashColumns.put("chss_mgst_trsp_tp_cd", getChssMgstTrspTpCd());
		this.hashColumns.put("trsp_so_cmb_seq", getTrspSoCmbSeq());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("lst_nod_pln_dt_hms", getLstNodPlnDtHms());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("lnk_dist_div_cd", getLnkDistDivCd());
		this.hashColumns.put("dor_pst_cd", getDorPstCd());
		this.hashColumns.put("rail_to_nod_cd", getRailToNodCd());
		this.hashColumns.put("sub_eq_tpsz_cd", getSubEqTpszCd());
		this.hashColumns.put("n1st_nod_pln_dt_hms", getN1stNodPlnDtHms());
		this.hashColumns.put("bkg_rcvde_term_cd", getBkgRcvdeTermCd());
		this.hashColumns.put("trns_rqst_ofc_cd", getTrnsRqstOfcCd());
		this.hashColumns.put("to_nod_yard2", getToNodYard2());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("tro_sub_seq", getTroSubSeq());
		this.hashColumns.put("trsp_so_cmb_tp_cd", getTrspSoCmbTpCd());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("cntr_pkup_no", getCntrPkupNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("trsp_cost_dtl_mod_sep", getTrspCostDtlModSep());
		this.hashColumns.put("dor_arr_dt", getDorArrDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("via_nod_cd2", getViaNodCd2());
		this.hashColumns.put("wo_iss_sts_cd", getWoIssStsCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("dor_svc_tp_cd", getDorSvcTpCd());
		this.hashColumns.put("trsp_so_sts_cd", getTrspSoStsCd());
		this.hashColumns.put("shpr_cust_nm", getShprCustNm());
		this.hashColumns.put("cntr_sub_flg", getCntrSubFlg());
		this.hashColumns.put("dor_nod_cd2", getDorNodCd2());
		this.hashColumns.put("tro_cfm_rev_amt", getTroCfmRevAmt());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("mst_lcl_cd", getMstLclCd());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("via_nod_yard2", getViaNodYard2());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cnee_cust_nm", getCneeCustNm());
		this.hashColumns.put("ex_sep_data", getExSepData());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("lstm_exp_flg", getLstmExpFlg());
		this.hashColumns.put("tro_rep_cmdt_cd", getTroRepCmdtCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dor_nod_yard_nm", getDorNodYardNm());
		this.hashColumns.put("lst_loc_cd", getLstLocCd());
		this.hashColumns.put("cntr_pkup_yd_cd", getCntrPkupYdCd());
		this.hashColumns.put("dor_de_addr", getDorDeAddr());
		this.hashColumns.put("dor_nod_pln_dt_hms", getDorNodPlnDtHms());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("fdr_skd_voy_no", getFdrSkdVoyNo());
		this.hashColumns.put("cng_rsn_desc", getCngRsnDesc());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("trsp_rqst_ord_bnd_cd", getTrspRqstOrdBndCd());
		this.hashColumns.put("cntc_pson_fax_no", getCntcPsonFaxNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("mlt_stop_de_flg", getMltStopDeFlg());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("trsp_so_tp_cd", getTrspSoTpCd());
		this.hashColumns.put("rev_curr_cd", getRevCurrCd());
		this.hashColumns.put("ownr_co_cd", getOwnrCoCd());
		this.hashColumns.put("dor_nod_yard", getDorNodYard());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cntc_pson_phn_no", getCntcPsonPhnNo());
		this.hashColumns.put("cntr_lbs_wgt", getCntrLbsWgt());
		this.hashColumns.put("trns_rqst_rsn", getTrnsRqstRsn());
		this.hashColumns.put("via_nod_yard", getViaNodYard());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ctrt_cnt", getCtrtCnt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("fm_loc_conti_cd", getFmLocContiCd());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("spot_bid_flg", getSpotBidFlg());
		this.hashColumns.put("trsp_rqst_bkg_flg", getTrspRqstBkgFlg());
		this.hashColumns.put("org_to_yd_cd", getOrgToYdCd());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("fm_nod_yard2", getFmNodYard2());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("repo_ref_no", getRepoRefNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("spot_bid_no", getSpotBidNo());
		this.hashColumns.put("cbstatus", getCbstatus());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("ovr_wgt_scg_amt", getOvrWgtScgAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tro_cfm_upd_dt1", getTroCfmUpdDt1());
		this.hashColumns.put("tro_cfm_upd_dt2", getTroCfmUpdDt2());
		this.hashColumns.put("trsp_purp_rsn", getTrspPurpRsn());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("cnee_seq", getCneeSeq());
		this.hashColumns.put("spot_bid_due_dt", getSpotBidDueDt());
		this.hashColumns.put("aval_dt", getAvalDt());
		this.hashColumns.put("repo_ref_seq", getRepoRefSeq());
		this.hashColumns.put("ntfy_cust_nm", getNtfyCustNm());
		this.hashColumns.put("cust_nomi_trkr_flg", getCustNomiTrkrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd2", "toNodCd2");
		this.hashFields.put("ib_vvd_cd", "ibVvdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pre_pull_flg", "prePullFlg");
		this.hashFields.put("fdr_vsl_cd", "fdrVslCd");
		this.hashFields.put("ibd_cstms_clr_loc_cd", "ibdCstmsClrLocCd");
		this.hashFields.put("act_cust_addr_seq", "actCustAddrSeq");
		this.hashFields.put("lst_free_dt_hms", "lstFreeDtHms");
		this.hashFields.put("cnt_flg", "cntFlg");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("tro_cfm_usr_id", "troCfmUsrId");
		this.hashFields.put("tro_lod_ref_no", "troLodRefNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cgor_org_bl_rcvr_ind_flg", "cgorOrgBlRcvrIndFlg");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("nego_amt", "negoAmt");
		this.hashFields.put("fctry_nm", "fctryNm");
		this.hashFields.put("shpr_seq", "shprSeq");
		this.hashFields.put("dor_nod_yard2", "dorNodYard2");
		this.hashFields.put("cmdt_name", "cmdtName");
		this.hashFields.put("upln_so_flg", "uplnSoFlg");
		this.hashFields.put("to_nod_yard", "toNodYard");
		this.hashFields.put("fm_nod_cd2", "fmNodCd2");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("cgor_cstms_acpt_re_ind_flg", "cgorCstmsAcptReIndFlg");
		this.hashFields.put("fm_nod_yard", "fmNodYard");
		this.hashFields.put("trsp_rqst_ord_seq", "trspRqstOrdSeq");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("rail_cre_dt", "railCreDt");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("trsp_rqst_ord_rev_amt", "trspRqstOrdRevAmt");
		this.hashFields.put("lst_free_dt", "lstFreeDt");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("trns_rqst_usr_id", "trnsRqstUsrId");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("lst_nod_pln_dt", "lstNodPlnDt");
		this.hashFields.put("pod_conti_cd", "podContiCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("lse_cntr_flg", "lseCntrFlg");
		this.hashFields.put("fuel_scg_amt", "fuelScgAmt");
		this.hashFields.put("n3pty_bil_flg", "n3ptyBilFlg");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("n1st_nod_pln_dt", "n1stNodPlnDt");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("cgor_frt_pay_ind_flg", "cgorFrtPayIndFlg");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("if_sys_knd_cd", "ifSysKndCd");
		this.hashFields.put("cmb_so_rlt_sts_flg", "cmbSoRltStsFlg");
		this.hashFields.put("act_grp_cd", "actGrpCd");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("cntr_kgs_wgt", "cntrKgsWgt");
		this.hashFields.put("ttl_dist", "ttlDist");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("spcl_cgo_cntr_tp_cd", "spclCgoCntrTpCd");
		this.hashFields.put("wo_iss_knt", "woIssKnt");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("rpln_umch_flg", "rplnUmchFlg");
		this.hashFields.put("dor_nod_pln_dt", "dorNodPlnDt");
		this.hashFields.put("cstms_clr_no", "cstmsClrNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("trsp_crr_mod_cd2", "trspCrrModCd2");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("trunkvvd", "trunkvvd");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("trsp_mty_rqst_dt", "trspMtyRqstDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cost_act_grp_cd", "costActGrpCd");
		this.hashFields.put("wgt_meas_ut_cd", "wgtMeasUtCd");
		this.hashFields.put("tro_cfm_ofc_cd", "troCfmOfcCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("spl_iss_rsn", "splIssRsn");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trsp_so_sts_nm", "trspSoStsNm");
		this.hashFields.put("aval_dt_hms", "avalDtHms");
		this.hashFields.put("fdr_skd_dir_cd", "fdrSkdDirCd");
		this.hashFields.put("trsp_mty_cost_mod_cd", "trspMtyCostModCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spot_bid_due_dt_hms", "spotBidDueDtHms");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("trsp_so_cmb_srt_no", "trspSoCmbSrtNo");
		this.hashFields.put("rail_cmb_thru_tp_cd", "railCmbThruTpCd");
		this.hashFields.put("etc_add_amt", "etcAddAmt");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("bkg_edi_ref_no", "bkgEdiRefNo");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("feedervvd", "feedervvd");
		this.hashFields.put("trsp_nxt_port_cd", "trspNxtPortCd");
		this.hashFields.put("ref_seq", "refSeq");
		this.hashFields.put("ob_vvd_cd", "obVvdCd");
		this.hashFields.put("chss_mgst_trsp_tp_cd", "chssMgstTrspTpCd");
		this.hashFields.put("trsp_so_cmb_seq", "trspSoCmbSeq");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("lst_nod_pln_dt_hms", "lstNodPlnDtHms");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("lnk_dist_div_cd", "lnkDistDivCd");
		this.hashFields.put("dor_pst_cd", "dorPstCd");
		this.hashFields.put("rail_to_nod_cd", "railToNodCd");
		this.hashFields.put("sub_eq_tpsz_cd", "subEqTpszCd");
		this.hashFields.put("n1st_nod_pln_dt_hms", "n1stNodPlnDtHms");
		this.hashFields.put("bkg_rcvde_term_cd", "bkgRcvdeTermCd");
		this.hashFields.put("trns_rqst_ofc_cd", "trnsRqstOfcCd");
		this.hashFields.put("to_nod_yard2", "toNodYard2");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("tro_sub_seq", "troSubSeq");
		this.hashFields.put("trsp_so_cmb_tp_cd", "trspSoCmbTpCd");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("cntr_pkup_no", "cntrPkupNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("trsp_cost_dtl_mod_sep", "trspCostDtlModSep");
		this.hashFields.put("dor_arr_dt", "dorArrDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("via_nod_cd2", "viaNodCd2");
		this.hashFields.put("wo_iss_sts_cd", "woIssStsCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("dor_svc_tp_cd", "dorSvcTpCd");
		this.hashFields.put("trsp_so_sts_cd", "trspSoStsCd");
		this.hashFields.put("shpr_cust_nm", "shprCustNm");
		this.hashFields.put("cntr_sub_flg", "cntrSubFlg");
		this.hashFields.put("dor_nod_cd2", "dorNodCd2");
		this.hashFields.put("tro_cfm_rev_amt", "troCfmRevAmt");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("mst_lcl_cd", "mstLclCd");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("via_nod_yard2", "viaNodYard2");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cnee_cust_nm", "cneeCustNm");
		this.hashFields.put("ex_sep_data", "exSepData");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("lstm_exp_flg", "lstmExpFlg");
		this.hashFields.put("tro_rep_cmdt_cd", "troRepCmdtCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dor_nod_yard_nm", "dorNodYardNm");
		this.hashFields.put("lst_loc_cd", "lstLocCd");
		this.hashFields.put("cntr_pkup_yd_cd", "cntrPkupYdCd");
		this.hashFields.put("dor_de_addr", "dorDeAddr");
		this.hashFields.put("dor_nod_pln_dt_hms", "dorNodPlnDtHms");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("fdr_skd_voy_no", "fdrSkdVoyNo");
		this.hashFields.put("cng_rsn_desc", "cngRsnDesc");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("trsp_rqst_ord_bnd_cd", "trspRqstOrdBndCd");
		this.hashFields.put("cntc_pson_fax_no", "cntcPsonFaxNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("mlt_stop_de_flg", "mltStopDeFlg");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("trsp_so_tp_cd", "trspSoTpCd");
		this.hashFields.put("rev_curr_cd", "revCurrCd");
		this.hashFields.put("ownr_co_cd", "ownrCoCd");
		this.hashFields.put("dor_nod_yard", "dorNodYard");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cntc_pson_phn_no", "cntcPsonPhnNo");
		this.hashFields.put("cntr_lbs_wgt", "cntrLbsWgt");
		this.hashFields.put("trns_rqst_rsn", "trnsRqstRsn");
		this.hashFields.put("via_nod_yard", "viaNodYard");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ctrt_cnt", "ctrtCnt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("fm_loc_conti_cd", "fmLocContiCd");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("spot_bid_flg", "spotBidFlg");
		this.hashFields.put("trsp_rqst_bkg_flg", "trspRqstBkgFlg");
		this.hashFields.put("org_to_yd_cd", "orgToYdCd");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("fm_nod_yard2", "fmNodYard2");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("repo_ref_no", "repoRefNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("spot_bid_no", "spotBidNo");
		this.hashFields.put("cbstatus", "cbstatus");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("ovr_wgt_scg_amt", "ovrWgtScgAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tro_cfm_upd_dt1", "troCfmUpdDt1");
		this.hashFields.put("tro_cfm_upd_dt2", "troCfmUpdDt2");
		this.hashFields.put("trsp_purp_rsn", "trspPurpRsn");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("cnee_seq", "cneeSeq");
		this.hashFields.put("spot_bid_due_dt", "spotBidDueDt");
		this.hashFields.put("aval_dt", "avalDt");
		this.hashFields.put("repo_ref_seq", "repoRefSeq");
		this.hashFields.put("ntfy_cust_nm", "ntfyCustNm");
		this.hashFields.put("cust_nomi_trkr_flg", "custNomiTrkrFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd2
	 */
	public String getToNodCd2() {
		return this.toNodCd2;
	}
	
	/**
	 * Column Info
	 * @return ibVvdCd
	 */
	public String getIbVvdCd() {
		return this.ibVvdCd;
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
	 * @return prePullFlg
	 */
	public String getPrePullFlg() {
		return this.prePullFlg;
	}
	
	/**
	 * Column Info
	 * @return fdrVslCd
	 */
	public String getFdrVslCd() {
		return this.fdrVslCd;
	}
	
	/**
	 * Column Info
	 * @return ibdCstmsClrLocCd
	 */
	public String getIbdCstmsClrLocCd() {
		return this.ibdCstmsClrLocCd;
	}
	
	/**
	 * Column Info
	 * @return actCustAddrSeq
	 */
	public String getActCustAddrSeq() {
		return this.actCustAddrSeq;
	}
	
	/**
	 * Column Info
	 * @return lstFreeDtHms
	 */
	public String getLstFreeDtHms() {
		return this.lstFreeDtHms;
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
	 * @return troCfmUsrId
	 */
	public String getTroCfmUsrId() {
		return this.troCfmUsrId;
	}
	
	/**
	 * Column Info
	 * @return troLodRefNo
	 */
	public String getTroLodRefNo() {
		return this.troLodRefNo;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return cgorOrgBlRcvrIndFlg
	 */
	public String getCgorOrgBlRcvrIndFlg() {
		return this.cgorOrgBlRcvrIndFlg;
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
	 * @return fctryNm
	 */
	public String getFctryNm() {
		return this.fctryNm;
	}
	
	/**
	 * Column Info
	 * @return shprSeq
	 */
	public String getShprSeq() {
		return this.shprSeq;
	}
	
	/**
	 * Column Info
	 * @return dorNodYard2
	 */
	public String getDorNodYard2() {
		return this.dorNodYard2;
	}
	
	/**
	 * Column Info
	 * @return cmdtName
	 */
	public String getCmdtName() {
		return this.cmdtName;
	}
	
	/**
	 * Column Info
	 * @return uplnSoFlg
	 */
	public String getUplnSoFlg() {
		return this.uplnSoFlg;
	}
	
	/**
	 * Column Info
	 * @return toNodYard
	 */
	public String getToNodYard() {
		return this.toNodYard;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd2
	 */
	public String getFmNodCd2() {
		return this.fmNodCd2;
	}
	
	/**
	 * Column Info
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return cgorCstmsAcptReIndFlg
	 */
	public String getCgorCstmsAcptReIndFlg() {
		return this.cgorCstmsAcptReIndFlg;
	}
	
	/**
	 * Column Info
	 * @return fmNodYard
	 */
	public String getFmNodYard() {
		return this.fmNodYard;
	}
	
	/**
	 * Column Info
	 * @return trspRqstOrdSeq
	 */
	public String getTrspRqstOrdSeq() {
		return this.trspRqstOrdSeq;
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
	 * @return railCreDt
	 */
	public String getRailCreDt() {
		return this.railCreDt;
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
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return trspRqstOrdRevAmt
	 */
	public String getTrspRqstOrdRevAmt() {
		return this.trspRqstOrdRevAmt;
	}
	
	/**
	 * Column Info
	 * @return lstFreeDt
	 */
	public String getLstFreeDt() {
		return this.lstFreeDt;
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
	 * @return trnsRqstUsrId
	 */
	public String getTrnsRqstUsrId() {
		return this.trnsRqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
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
	 * @return podContiCd
	 */
	public String getPodContiCd() {
		return this.podContiCd;
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
	 * @return lseCntrFlg
	 */
	public String getLseCntrFlg() {
		return this.lseCntrFlg;
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
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return cgorFrtPayIndFlg
	 */
	public String getCgorFrtPayIndFlg() {
		return this.cgorFrtPayIndFlg;
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
	 * @return ifSysKndCd
	 */
	public String getIfSysKndCd() {
		return this.ifSysKndCd;
	}
	
	/**
	 * Column Info
	 * @return cmbSoRltStsFlg
	 */
	public String getCmbSoRltStsFlg() {
		return this.cmbSoRltStsFlg;
	}
	
	/**
	 * Column Info
	 * @return actGrpCd
	 */
	public String getActGrpCd() {
		return this.actGrpCd;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
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
	 * @return ttlDist
	 */
	public String getTtlDist() {
		return this.ttlDist;
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
	 * @return spclCgoCntrTpCd
	 */
	public String getSpclCgoCntrTpCd() {
		return this.spclCgoCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return woIssKnt
	 */
	public String getWoIssKnt() {
		return this.woIssKnt;
	}
	
	/**
	 * Column Info
	 * @return blNoChk
	 */
	public String getBlNoChk() {
		return this.blNoChk;
	}
	
	/**
	 * Column Info
	 * @return rplnUmchFlg
	 */
	public String getRplnUmchFlg() {
		return this.rplnUmchFlg;
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
	 * @return cstmsClrNo
	 */
	public String getCstmsClrNo() {
		return this.cstmsClrNo;
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
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd2
	 */
	public String getTrspCrrModCd2() {
		return this.trspCrrModCd2;
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
	 * @return trunkvvd
	 */
	public String getTrunkvvd() {
		return this.trunkvvd;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trspMtyRqstDt
	 */
	public String getTrspMtyRqstDt() {
		return this.trspMtyRqstDt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return splIssRsn
	 */
	public String getSplIssRsn() {
		return this.splIssRsn;
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
	 * @return trspSoStsNm
	 */
	public String getTrspSoStsNm() {
		return this.trspSoStsNm;
	}
	
	/**
	 * Column Info
	 * @return avalDtHms
	 */
	public String getAvalDtHms() {
		return this.avalDtHms;
	}
	
	/**
	 * Column Info
	 * @return fdrSkdDirCd
	 */
	public String getFdrSkdDirCd() {
		return this.fdrSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return trspMtyCostModCd
	 */
	public String getTrspMtyCostModCd() {
		return this.trspMtyCostModCd;
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
	 * @return spotBidDueDtHms
	 */
	public String getSpotBidDueDtHms() {
		return this.spotBidDueDtHms;
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
	 * @return trspSoCmbSrtNo
	 */
	public String getTrspSoCmbSrtNo() {
		return this.trspSoCmbSrtNo;
	}
	
	/**
	 * Column Info
	 * @return railCmbThruTpCd
	 */
	public String getRailCmbThruTpCd() {
		return this.railCmbThruTpCd;
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
	 * @return bkgEdiRefNo
	 */
	public String getBkgEdiRefNo() {
		return this.bkgEdiRefNo;
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
	 * @return feedervvd
	 */
	public String getFeedervvd() {
		return this.feedervvd;
	}
	
	/**
	 * Column Info
	 * @return trspNxtPortCd
	 */
	public String getTrspNxtPortCd() {
		return this.trspNxtPortCd;
	}
	
	/**
	 * Column Info
	 * @return refSeq
	 */
	public String getRefSeq() {
		return this.refSeq;
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
	 * @return chssMgstTrspTpCd
	 */
	public String getChssMgstTrspTpCd() {
		return this.chssMgstTrspTpCd;
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
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return lstNodPlnDtHms
	 */
	public String getLstNodPlnDtHms() {
		return this.lstNodPlnDtHms;
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
	 * @return cneeCntCd
	 */
	public String getCneeCntCd() {
		return this.cneeCntCd;
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
	 * @return railToNodCd
	 */
	public String getRailToNodCd() {
		return this.railToNodCd;
	}
	
	/**
	 * Column Info
	 * @return subEqTpszCd
	 */
	public String getSubEqTpszCd() {
		return this.subEqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return n1stNodPlnDtHms
	 */
	public String getN1stNodPlnDtHms() {
		return this.n1stNodPlnDtHms;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvdeTermCd
	 */
	public String getBkgRcvdeTermCd() {
		return this.bkgRcvdeTermCd;
	}
	
	/**
	 * Column Info
	 * @return trnsRqstOfcCd
	 */
	public String getTrnsRqstOfcCd() {
		return this.trnsRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return toNodYard2
	 */
	public String getToNodYard2() {
		return this.toNodYard2;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return troSubSeq
	 */
	public String getTroSubSeq() {
		return this.troSubSeq;
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
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}
	
	/**
	 * Column Info
	 * @return cntrPkupNo
	 */
	public String getCntrPkupNo() {
		return this.cntrPkupNo;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return trspCostDtlModSep
	 */
	public String getTrspCostDtlModSep() {
		return this.trspCostDtlModSep;
	}
	
	/**
	 * Column Info
	 * @return dorArrDt
	 */
	public String getDorArrDt() {
		return this.dorArrDt;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return viaNodCd2
	 */
	public String getViaNodCd2() {
		return this.viaNodCd2;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return dorSvcTpCd
	 */
	public String getDorSvcTpCd() {
		return this.dorSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoStsCd
	 */
	public String getTrspSoStsCd() {
		return this.trspSoStsCd;
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
	 * @return cntrSubFlg
	 */
	public String getCntrSubFlg() {
		return this.cntrSubFlg;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd2
	 */
	public String getDorNodCd2() {
		return this.dorNodCd2;
	}
	
	/**
	 * Column Info
	 * @return troCfmRevAmt
	 */
	public String getTroCfmRevAmt() {
		return this.troCfmRevAmt;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
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
	 * @return mstLclCd
	 */
	public String getMstLclCd() {
		return this.mstLclCd;
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
	 * @return viaNodYard2
	 */
	public String getViaNodYard2() {
		return this.viaNodYard2;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @return exSepData
	 */
	public String getExSepData() {
		return this.exSepData;
	}
	
	/**
	 * Column Info
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @return lstmExpFlg
	 */
	public String getLstmExpFlg() {
		return this.lstmExpFlg;
	}
	
	/**
	 * Column Info
	 * @return troRepCmdtCd
	 */
	public String getTroRepCmdtCd() {
		return this.troRepCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return dorNodYardNm
	 */
	public String getDorNodYardNm() {
		return this.dorNodYardNm;
	}
	
	/**
	 * Column Info
	 * @return lstLocCd
	 */
	public String getLstLocCd() {
		return this.lstLocCd;
	}
	
	/**
	 * Column Info
	 * @return cntrPkupYdCd
	 */
	public String getCntrPkupYdCd() {
		return this.cntrPkupYdCd;
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
	 * @return dorNodPlnDtHms
	 */
	public String getDorNodPlnDtHms() {
		return this.dorNodPlnDtHms;
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
	 * @return fdrSkdVoyNo
	 */
	public String getFdrSkdVoyNo() {
		return this.fdrSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return cngRsnDesc
	 */
	public String getCngRsnDesc() {
		return this.cngRsnDesc;
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
	 * @return trspRqstOrdBndCd
	 */
	public String getTrspRqstOrdBndCd() {
		return this.trspRqstOrdBndCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return mltStopDeFlg
	 */
	public String getMltStopDeFlg() {
		return this.mltStopDeFlg;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return ownrCoCd
	 */
	public String getOwnrCoCd() {
		return this.ownrCoCd;
	}
	
	/**
	 * Column Info
	 * @return dorNodYard
	 */
	public String getDorNodYard() {
		return this.dorNodYard;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return trnsRqstRsn
	 */
	public String getTrnsRqstRsn() {
		return this.trnsRqstRsn;
	}
	
	/**
	 * Column Info
	 * @return viaNodYard
	 */
	public String getViaNodYard() {
		return this.viaNodYard;
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
	 * @return fmLocContiCd
	 */
	public String getFmLocContiCd() {
		return this.fmLocContiCd;
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
	 * @return spotBidFlg
	 */
	public String getSpotBidFlg() {
		return this.spotBidFlg;
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
	 * @return orgToYdCd
	 */
	public String getOrgToYdCd() {
		return this.orgToYdCd;
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
	 * @return fmNodYard2
	 */
	public String getFmNodYard2() {
		return this.fmNodYard2;
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
	 * @return repoRefNo
	 */
	public String getRepoRefNo() {
		return this.repoRefNo;
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
	 * @return spotBidNo
	 */
	public String getSpotBidNo() {
		return this.spotBidNo;
	}
	
	/**
	 * Column Info
	 * @return cbstatus
	 */
	public String getCbstatus() {
		return this.cbstatus;
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
	 * @return ovrWgtScgAmt
	 */
	public String getOvrWgtScgAmt() {
		return this.ovrWgtScgAmt;
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
	 * @return troCfmUpdDt1
	 */
	public String getTroCfmUpdDt1() {
		return this.troCfmUpdDt1;
	}
	
	/**
	 * Column Info
	 * @return troCfmUpdDt2
	 */
	public String getTroCfmUpdDt2() {
		return this.troCfmUpdDt2;
	}
	
	/**
	 * Column Info
	 * @return trspPurpRsn
	 */
	public String getTrspPurpRsn() {
		return this.trspPurpRsn;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
	}
	
	/**
	 * Column Info
	 * @return cneeSeq
	 */
	public String getCneeSeq() {
		return this.cneeSeq;
	}
	
	/**
	 * Column Info
	 * @return spotBidDueDt
	 */
	public String getSpotBidDueDt() {
		return this.spotBidDueDt;
	}
	
	/**
	 * Column Info
	 * @return avalDt
	 */
	public String getAvalDt() {
		return this.avalDt;
	}
	
	/**
	 * Column Info
	 * @return repoRefSeq
	 */
	public String getRepoRefSeq() {
		return this.repoRefSeq;
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
	 * @return custNomiTrkrFlg
	 */
	public String getCustNomiTrkrFlg() {
		return this.custNomiTrkrFlg;
	}
	

	/**
	 * Column Info
	 * @param toNodCd2
	 */
	public void setToNodCd2(String toNodCd2) {
		this.toNodCd2 = toNodCd2;
	}
	
	/**
	 * Column Info
	 * @param ibVvdCd
	 */
	public void setIbVvdCd(String ibVvdCd) {
		this.ibVvdCd = ibVvdCd;
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
	 * @param prePullFlg
	 */
	public void setPrePullFlg(String prePullFlg) {
		this.prePullFlg = prePullFlg;
	}
	
	/**
	 * Column Info
	 * @param fdrVslCd
	 */
	public void setFdrVslCd(String fdrVslCd) {
		this.fdrVslCd = fdrVslCd;
	}
	
	/**
	 * Column Info
	 * @param ibdCstmsClrLocCd
	 */
	public void setIbdCstmsClrLocCd(String ibdCstmsClrLocCd) {
		this.ibdCstmsClrLocCd = ibdCstmsClrLocCd;
	}
	
	/**
	 * Column Info
	 * @param actCustAddrSeq
	 */
	public void setActCustAddrSeq(String actCustAddrSeq) {
		this.actCustAddrSeq = actCustAddrSeq;
	}
	
	/**
	 * Column Info
	 * @param lstFreeDtHms
	 */
	public void setLstFreeDtHms(String lstFreeDtHms) {
		this.lstFreeDtHms = lstFreeDtHms;
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
	 * @param troCfmUsrId
	 */
	public void setTroCfmUsrId(String troCfmUsrId) {
		this.troCfmUsrId = troCfmUsrId;
	}
	
	/**
	 * Column Info
	 * @param troLodRefNo
	 */
	public void setTroLodRefNo(String troLodRefNo) {
		this.troLodRefNo = troLodRefNo;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param cgorOrgBlRcvrIndFlg
	 */
	public void setCgorOrgBlRcvrIndFlg(String cgorOrgBlRcvrIndFlg) {
		this.cgorOrgBlRcvrIndFlg = cgorOrgBlRcvrIndFlg;
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
	 * @param fctryNm
	 */
	public void setFctryNm(String fctryNm) {
		this.fctryNm = fctryNm;
	}
	
	/**
	 * Column Info
	 * @param shprSeq
	 */
	public void setShprSeq(String shprSeq) {
		this.shprSeq = shprSeq;
	}
	
	/**
	 * Column Info
	 * @param dorNodYard2
	 */
	public void setDorNodYard2(String dorNodYard2) {
		this.dorNodYard2 = dorNodYard2;
	}
	
	/**
	 * Column Info
	 * @param cmdtName
	 */
	public void setCmdtName(String cmdtName) {
		this.cmdtName = cmdtName;
	}
	
	/**
	 * Column Info
	 * @param uplnSoFlg
	 */
	public void setUplnSoFlg(String uplnSoFlg) {
		this.uplnSoFlg = uplnSoFlg;
	}
	
	/**
	 * Column Info
	 * @param toNodYard
	 */
	public void setToNodYard(String toNodYard) {
		this.toNodYard = toNodYard;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd2
	 */
	public void setFmNodCd2(String fmNodCd2) {
		this.fmNodCd2 = fmNodCd2;
	}
	
	/**
	 * Column Info
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param cgorCstmsAcptReIndFlg
	 */
	public void setCgorCstmsAcptReIndFlg(String cgorCstmsAcptReIndFlg) {
		this.cgorCstmsAcptReIndFlg = cgorCstmsAcptReIndFlg;
	}
	
	/**
	 * Column Info
	 * @param fmNodYard
	 */
	public void setFmNodYard(String fmNodYard) {
		this.fmNodYard = fmNodYard;
	}
	
	/**
	 * Column Info
	 * @param trspRqstOrdSeq
	 */
	public void setTrspRqstOrdSeq(String trspRqstOrdSeq) {
		this.trspRqstOrdSeq = trspRqstOrdSeq;
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
	 * @param railCreDt
	 */
	public void setRailCreDt(String railCreDt) {
		this.railCreDt = railCreDt;
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
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param trspRqstOrdRevAmt
	 */
	public void setTrspRqstOrdRevAmt(String trspRqstOrdRevAmt) {
		this.trspRqstOrdRevAmt = trspRqstOrdRevAmt;
	}
	
	/**
	 * Column Info
	 * @param lstFreeDt
	 */
	public void setLstFreeDt(String lstFreeDt) {
		this.lstFreeDt = lstFreeDt;
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
	 * @param trnsRqstUsrId
	 */
	public void setTrnsRqstUsrId(String trnsRqstUsrId) {
		this.trnsRqstUsrId = trnsRqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
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
	 * @param podContiCd
	 */
	public void setPodContiCd(String podContiCd) {
		this.podContiCd = podContiCd;
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
	 * @param lseCntrFlg
	 */
	public void setLseCntrFlg(String lseCntrFlg) {
		this.lseCntrFlg = lseCntrFlg;
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
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param cgorFrtPayIndFlg
	 */
	public void setCgorFrtPayIndFlg(String cgorFrtPayIndFlg) {
		this.cgorFrtPayIndFlg = cgorFrtPayIndFlg;
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
	 * @param ifSysKndCd
	 */
	public void setIfSysKndCd(String ifSysKndCd) {
		this.ifSysKndCd = ifSysKndCd;
	}
	
	/**
	 * Column Info
	 * @param cmbSoRltStsFlg
	 */
	public void setCmbSoRltStsFlg(String cmbSoRltStsFlg) {
		this.cmbSoRltStsFlg = cmbSoRltStsFlg;
	}
	
	/**
	 * Column Info
	 * @param actGrpCd
	 */
	public void setActGrpCd(String actGrpCd) {
		this.actGrpCd = actGrpCd;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
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
	 * @param ttlDist
	 */
	public void setTtlDist(String ttlDist) {
		this.ttlDist = ttlDist;
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
	 * @param spclCgoCntrTpCd
	 */
	public void setSpclCgoCntrTpCd(String spclCgoCntrTpCd) {
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param woIssKnt
	 */
	public void setWoIssKnt(String woIssKnt) {
		this.woIssKnt = woIssKnt;
	}
	
	/**
	 * Column Info
	 * @param blNoChk
	 */
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
	}
	
	/**
	 * Column Info
	 * @param rplnUmchFlg
	 */
	public void setRplnUmchFlg(String rplnUmchFlg) {
		this.rplnUmchFlg = rplnUmchFlg;
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
	 * @param cstmsClrNo
	 */
	public void setCstmsClrNo(String cstmsClrNo) {
		this.cstmsClrNo = cstmsClrNo;
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
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd2
	 */
	public void setTrspCrrModCd2(String trspCrrModCd2) {
		this.trspCrrModCd2 = trspCrrModCd2;
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
	 * @param trunkvvd
	 */
	public void setTrunkvvd(String trunkvvd) {
		this.trunkvvd = trunkvvd;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trspMtyRqstDt
	 */
	public void setTrspMtyRqstDt(String trspMtyRqstDt) {
		this.trspMtyRqstDt = trspMtyRqstDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param splIssRsn
	 */
	public void setSplIssRsn(String splIssRsn) {
		this.splIssRsn = splIssRsn;
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
	 * @param trspSoStsNm
	 */
	public void setTrspSoStsNm(String trspSoStsNm) {
		this.trspSoStsNm = trspSoStsNm;
	}
	
	/**
	 * Column Info
	 * @param avalDtHms
	 */
	public void setAvalDtHms(String avalDtHms) {
		this.avalDtHms = avalDtHms;
	}
	
	/**
	 * Column Info
	 * @param fdrSkdDirCd
	 */
	public void setFdrSkdDirCd(String fdrSkdDirCd) {
		this.fdrSkdDirCd = fdrSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param trspMtyCostModCd
	 */
	public void setTrspMtyCostModCd(String trspMtyCostModCd) {
		this.trspMtyCostModCd = trspMtyCostModCd;
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
	 * @param spotBidDueDtHms
	 */
	public void setSpotBidDueDtHms(String spotBidDueDtHms) {
		this.spotBidDueDtHms = spotBidDueDtHms;
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
	 * @param trspSoCmbSrtNo
	 */
	public void setTrspSoCmbSrtNo(String trspSoCmbSrtNo) {
		this.trspSoCmbSrtNo = trspSoCmbSrtNo;
	}
	
	/**
	 * Column Info
	 * @param railCmbThruTpCd
	 */
	public void setRailCmbThruTpCd(String railCmbThruTpCd) {
		this.railCmbThruTpCd = railCmbThruTpCd;
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
	 * @param bkgEdiRefNo
	 */
	public void setBkgEdiRefNo(String bkgEdiRefNo) {
		this.bkgEdiRefNo = bkgEdiRefNo;
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
	 * @param feedervvd
	 */
	public void setFeedervvd(String feedervvd) {
		this.feedervvd = feedervvd;
	}
	
	/**
	 * Column Info
	 * @param trspNxtPortCd
	 */
	public void setTrspNxtPortCd(String trspNxtPortCd) {
		this.trspNxtPortCd = trspNxtPortCd;
	}
	
	/**
	 * Column Info
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
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
	 * @param chssMgstTrspTpCd
	 */
	public void setChssMgstTrspTpCd(String chssMgstTrspTpCd) {
		this.chssMgstTrspTpCd = chssMgstTrspTpCd;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param lstNodPlnDtHms
	 */
	public void setLstNodPlnDtHms(String lstNodPlnDtHms) {
		this.lstNodPlnDtHms = lstNodPlnDtHms;
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
	 * @param cneeCntCd
	 */
	public void setCneeCntCd(String cneeCntCd) {
		this.cneeCntCd = cneeCntCd;
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
	 * @param railToNodCd
	 */
	public void setRailToNodCd(String railToNodCd) {
		this.railToNodCd = railToNodCd;
	}
	
	/**
	 * Column Info
	 * @param subEqTpszCd
	 */
	public void setSubEqTpszCd(String subEqTpszCd) {
		this.subEqTpszCd = subEqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param n1stNodPlnDtHms
	 */
	public void setN1stNodPlnDtHms(String n1stNodPlnDtHms) {
		this.n1stNodPlnDtHms = n1stNodPlnDtHms;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvdeTermCd
	 */
	public void setBkgRcvdeTermCd(String bkgRcvdeTermCd) {
		this.bkgRcvdeTermCd = bkgRcvdeTermCd;
	}
	
	/**
	 * Column Info
	 * @param trnsRqstOfcCd
	 */
	public void setTrnsRqstOfcCd(String trnsRqstOfcCd) {
		this.trnsRqstOfcCd = trnsRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param toNodYard2
	 */
	public void setToNodYard2(String toNodYard2) {
		this.toNodYard2 = toNodYard2;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param troSubSeq
	 */
	public void setTroSubSeq(String troSubSeq) {
		this.troSubSeq = troSubSeq;
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
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}
	
	/**
	 * Column Info
	 * @param cntrPkupNo
	 */
	public void setCntrPkupNo(String cntrPkupNo) {
		this.cntrPkupNo = cntrPkupNo;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param trspCostDtlModSep
	 */
	public void setTrspCostDtlModSep(String trspCostDtlModSep) {
		this.trspCostDtlModSep = trspCostDtlModSep;
	}
	
	/**
	 * Column Info
	 * @param dorArrDt
	 */
	public void setDorArrDt(String dorArrDt) {
		this.dorArrDt = dorArrDt;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param viaNodCd2
	 */
	public void setViaNodCd2(String viaNodCd2) {
		this.viaNodCd2 = viaNodCd2;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param dorSvcTpCd
	 */
	public void setDorSvcTpCd(String dorSvcTpCd) {
		this.dorSvcTpCd = dorSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoStsCd
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
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
	 * @param cntrSubFlg
	 */
	public void setCntrSubFlg(String cntrSubFlg) {
		this.cntrSubFlg = cntrSubFlg;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd2
	 */
	public void setDorNodCd2(String dorNodCd2) {
		this.dorNodCd2 = dorNodCd2;
	}
	
	/**
	 * Column Info
	 * @param troCfmRevAmt
	 */
	public void setTroCfmRevAmt(String troCfmRevAmt) {
		this.troCfmRevAmt = troCfmRevAmt;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
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
	 * @param mstLclCd
	 */
	public void setMstLclCd(String mstLclCd) {
		this.mstLclCd = mstLclCd;
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
	 * @param viaNodYard2
	 */
	public void setViaNodYard2(String viaNodYard2) {
		this.viaNodYard2 = viaNodYard2;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
	 * @param exSepData
	 */
	public void setExSepData(String exSepData) {
		this.exSepData = exSepData;
	}
	
	/**
	 * Column Info
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @param lstmExpFlg
	 */
	public void setLstmExpFlg(String lstmExpFlg) {
		this.lstmExpFlg = lstmExpFlg;
	}
	
	/**
	 * Column Info
	 * @param troRepCmdtCd
	 */
	public void setTroRepCmdtCd(String troRepCmdtCd) {
		this.troRepCmdtCd = troRepCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param dorNodYardNm
	 */
	public void setDorNodYardNm(String dorNodYardNm) {
		this.dorNodYardNm = dorNodYardNm;
	}
	
	/**
	 * Column Info
	 * @param lstLocCd
	 */
	public void setLstLocCd(String lstLocCd) {
		this.lstLocCd = lstLocCd;
	}
	
	/**
	 * Column Info
	 * @param cntrPkupYdCd
	 */
	public void setCntrPkupYdCd(String cntrPkupYdCd) {
		this.cntrPkupYdCd = cntrPkupYdCd;
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
	 * @param dorNodPlnDtHms
	 */
	public void setDorNodPlnDtHms(String dorNodPlnDtHms) {
		this.dorNodPlnDtHms = dorNodPlnDtHms;
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
	 * @param fdrSkdVoyNo
	 */
	public void setFdrSkdVoyNo(String fdrSkdVoyNo) {
		this.fdrSkdVoyNo = fdrSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param cngRsnDesc
	 */
	public void setCngRsnDesc(String cngRsnDesc) {
		this.cngRsnDesc = cngRsnDesc;
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
	 * @param trspRqstOrdBndCd
	 */
	public void setTrspRqstOrdBndCd(String trspRqstOrdBndCd) {
		this.trspRqstOrdBndCd = trspRqstOrdBndCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param mltStopDeFlg
	 */
	public void setMltStopDeFlg(String mltStopDeFlg) {
		this.mltStopDeFlg = mltStopDeFlg;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param ownrCoCd
	 */
	public void setOwnrCoCd(String ownrCoCd) {
		this.ownrCoCd = ownrCoCd;
	}
	
	/**
	 * Column Info
	 * @param dorNodYard
	 */
	public void setDorNodYard(String dorNodYard) {
		this.dorNodYard = dorNodYard;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param trnsRqstRsn
	 */
	public void setTrnsRqstRsn(String trnsRqstRsn) {
		this.trnsRqstRsn = trnsRqstRsn;
	}
	
	/**
	 * Column Info
	 * @param viaNodYard
	 */
	public void setViaNodYard(String viaNodYard) {
		this.viaNodYard = viaNodYard;
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
	 * @param fmLocContiCd
	 */
	public void setFmLocContiCd(String fmLocContiCd) {
		this.fmLocContiCd = fmLocContiCd;
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
	 * @param spotBidFlg
	 */
	public void setSpotBidFlg(String spotBidFlg) {
		this.spotBidFlg = spotBidFlg;
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
	 * @param orgToYdCd
	 */
	public void setOrgToYdCd(String orgToYdCd) {
		this.orgToYdCd = orgToYdCd;
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
	 * @param fmNodYard2
	 */
	public void setFmNodYard2(String fmNodYard2) {
		this.fmNodYard2 = fmNodYard2;
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
	 * @param repoRefNo
	 */
	public void setRepoRefNo(String repoRefNo) {
		this.repoRefNo = repoRefNo;
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
	 * @param spotBidNo
	 */
	public void setSpotBidNo(String spotBidNo) {
		this.spotBidNo = spotBidNo;
	}
	
	/**
	 * Column Info
	 * @param cbstatus
	 */
	public void setCbstatus(String cbstatus) {
		this.cbstatus = cbstatus;
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
	 * @param ovrWgtScgAmt
	 */
	public void setOvrWgtScgAmt(String ovrWgtScgAmt) {
		this.ovrWgtScgAmt = ovrWgtScgAmt;
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
	 * @param troCfmUpdDt1
	 */
	public void setTroCfmUpdDt1(String troCfmUpdDt1) {
		this.troCfmUpdDt1 = troCfmUpdDt1;
	}
	
	/**
	 * Column Info
	 * @param troCfmUpdDt2
	 */
	public void setTroCfmUpdDt2(String troCfmUpdDt2) {
		this.troCfmUpdDt2 = troCfmUpdDt2;
	}
	
	/**
	 * Column Info
	 * @param trspPurpRsn
	 */
	public void setTrspPurpRsn(String trspPurpRsn) {
		this.trspPurpRsn = trspPurpRsn;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}
	
	/**
	 * Column Info
	 * @param cneeSeq
	 */
	public void setCneeSeq(String cneeSeq) {
		this.cneeSeq = cneeSeq;
	}
	
	/**
	 * Column Info
	 * @param spotBidDueDt
	 */
	public void setSpotBidDueDt(String spotBidDueDt) {
		this.spotBidDueDt = spotBidDueDt;
	}
	
	/**
	 * Column Info
	 * @param avalDt
	 */
	public void setAvalDt(String avalDt) {
		this.avalDt = avalDt;
	}
	
	/**
	 * Column Info
	 * @param repoRefSeq
	 */
	public void setRepoRefSeq(String repoRefSeq) {
		this.repoRefSeq = repoRefSeq;
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
	 * @param custNomiTrkrFlg
	 */
	public void setCustNomiTrkrFlg(String custNomiTrkrFlg) {
		this.custNomiTrkrFlg = custNomiTrkrFlg;
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
		setToNodCd2(JSPUtil.getParameter(request, prefix + "to_nod_cd2", ""));
		setIbVvdCd(JSPUtil.getParameter(request, prefix + "ib_vvd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrePullFlg(JSPUtil.getParameter(request, prefix + "pre_pull_flg", ""));
		setFdrVslCd(JSPUtil.getParameter(request, prefix + "fdr_vsl_cd", ""));
		setIbdCstmsClrLocCd(JSPUtil.getParameter(request, prefix + "ibd_cstms_clr_loc_cd", ""));
		setActCustAddrSeq(JSPUtil.getParameter(request, prefix + "act_cust_addr_seq", ""));
		setLstFreeDtHms(JSPUtil.getParameter(request, prefix + "lst_free_dt_hms", ""));
		setCntFlg(JSPUtil.getParameter(request, prefix + "cnt_flg", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setTroCfmUsrId(JSPUtil.getParameter(request, prefix + "tro_cfm_usr_id", ""));
		setTroLodRefNo(JSPUtil.getParameter(request, prefix + "tro_lod_ref_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCgorOrgBlRcvrIndFlg(JSPUtil.getParameter(request, prefix + "cgor_org_bl_rcvr_ind_flg", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setNegoAmt(JSPUtil.getParameter(request, prefix + "nego_amt", ""));
		setFctryNm(JSPUtil.getParameter(request, prefix + "fctry_nm", ""));
		setShprSeq(JSPUtil.getParameter(request, prefix + "shpr_seq", ""));
		setDorNodYard2(JSPUtil.getParameter(request, prefix + "dor_nod_yard2", ""));
		setCmdtName(JSPUtil.getParameter(request, prefix + "cmdt_name", ""));
		setUplnSoFlg(JSPUtil.getParameter(request, prefix + "upln_so_flg", ""));
		setToNodYard(JSPUtil.getParameter(request, prefix + "to_nod_yard", ""));
		setFmNodCd2(JSPUtil.getParameter(request, prefix + "fm_nod_cd2", ""));
		setPlnYrwk(JSPUtil.getParameter(request, prefix + "pln_yrwk", ""));
		setCgorCstmsAcptReIndFlg(JSPUtil.getParameter(request, prefix + "cgor_cstms_acpt_re_ind_flg", ""));
		setFmNodYard(JSPUtil.getParameter(request, prefix + "fm_nod_yard", ""));
		setTrspRqstOrdSeq(JSPUtil.getParameter(request, prefix + "trsp_rqst_ord_seq", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setRailCreDt(JSPUtil.getParameter(request, prefix + "rail_cre_dt", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setActCustCntCd(JSPUtil.getParameter(request, prefix + "act_cust_cnt_cd", ""));
		setTrspRqstOrdRevAmt(JSPUtil.getParameter(request, prefix + "trsp_rqst_ord_rev_amt", ""));
		setLstFreeDt(JSPUtil.getParameter(request, prefix + "lst_free_dt", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setTrnsRqstUsrId(JSPUtil.getParameter(request, prefix + "trns_rqst_usr_id", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, prefix + "bkg_no_split", ""));
		setLstNodPlnDt(JSPUtil.getParameter(request, prefix + "lst_nod_pln_dt", ""));
		setPodContiCd(JSPUtil.getParameter(request, prefix + "pod_conti_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setLseCntrFlg(JSPUtil.getParameter(request, prefix + "lse_cntr_flg", ""));
		setFuelScgAmt(JSPUtil.getParameter(request, prefix + "fuel_scg_amt", ""));
		setN3ptyBilFlg(JSPUtil.getParameter(request, prefix + "n3pty_bil_flg", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, prefix + "cost_act_grp_seq", ""));
		setN1stNodPlnDt(JSPUtil.getParameter(request, prefix + "n1st_nod_pln_dt", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setCgorFrtPayIndFlg(JSPUtil.getParameter(request, prefix + "cgor_frt_pay_ind_flg", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setIfSysKndCd(JSPUtil.getParameter(request, prefix + "if_sys_knd_cd", ""));
		setCmbSoRltStsFlg(JSPUtil.getParameter(request, prefix + "cmb_so_rlt_sts_flg", ""));
		setActGrpCd(JSPUtil.getParameter(request, prefix + "act_grp_cd", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
		setCntrKgsWgt(JSPUtil.getParameter(request, prefix + "cntr_kgs_wgt", ""));
		setTtlDist(JSPUtil.getParameter(request, prefix + "ttl_dist", ""));
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setSpclCgoCntrTpCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cntr_tp_cd", ""));
		setWoIssKnt(JSPUtil.getParameter(request, prefix + "wo_iss_knt", ""));
		setBlNoChk(JSPUtil.getParameter(request, prefix + "bl_no_chk", ""));
		setRplnUmchFlg(JSPUtil.getParameter(request, prefix + "rpln_umch_flg", ""));
		setDorNodPlnDt(JSPUtil.getParameter(request, prefix + "dor_nod_pln_dt", ""));
		setCstmsClrNo(JSPUtil.getParameter(request, prefix + "cstms_clr_no", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setBlNoTp(JSPUtil.getParameter(request, prefix + "bl_no_tp", ""));
		setTrspCrrModCd2(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd2", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, prefix + "trsp_wo_seq", ""));
		setTrunkvvd(JSPUtil.getParameter(request, prefix + "trunkvvd", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setTrspMtyRqstDt(JSPUtil.getParameter(request, prefix + "trsp_mty_rqst_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCostActGrpCd(JSPUtil.getParameter(request, prefix + "cost_act_grp_cd", ""));
		setWgtMeasUtCd(JSPUtil.getParameter(request, prefix + "wgt_meas_ut_cd", ""));
		setTroCfmOfcCd(JSPUtil.getParameter(request, prefix + "tro_cfm_ofc_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setSplIssRsn(JSPUtil.getParameter(request, prefix + "spl_iss_rsn", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrspSoStsNm(JSPUtil.getParameter(request, prefix + "trsp_so_sts_nm", ""));
		setAvalDtHms(JSPUtil.getParameter(request, prefix + "aval_dt_hms", ""));
		setFdrSkdDirCd(JSPUtil.getParameter(request, prefix + "fdr_skd_dir_cd", ""));
		setTrspMtyCostModCd(JSPUtil.getParameter(request, prefix + "trsp_mty_cost_mod_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSpotBidDueDtHms(JSPUtil.getParameter(request, prefix + "spot_bid_due_dt_hms", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setTrspSoCmbSrtNo(JSPUtil.getParameter(request, prefix + "trsp_so_cmb_srt_no", ""));
		setRailCmbThruTpCd(JSPUtil.getParameter(request, prefix + "rail_cmb_thru_tp_cd", ""));
		setEtcAddAmt(JSPUtil.getParameter(request, prefix + "etc_add_amt", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setBkgEdiRefNo(JSPUtil.getParameter(request, prefix + "bkg_edi_ref_no", ""));
		setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setFeedervvd(JSPUtil.getParameter(request, prefix + "feedervvd", ""));
		setTrspNxtPortCd(JSPUtil.getParameter(request, prefix + "trsp_nxt_port_cd", ""));
		setRefSeq(JSPUtil.getParameter(request, prefix + "ref_seq", ""));
		setObVvdCd(JSPUtil.getParameter(request, prefix + "ob_vvd_cd", ""));
		setChssMgstTrspTpCd(JSPUtil.getParameter(request, prefix + "chss_mgst_trsp_tp_cd", ""));
		setTrspSoCmbSeq(JSPUtil.getParameter(request, prefix + "trsp_so_cmb_seq", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setLstNodPlnDtHms(JSPUtil.getParameter(request, prefix + "lst_nod_pln_dt_hms", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setCneeCntCd(JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", ""));
		setLnkDistDivCd(JSPUtil.getParameter(request, prefix + "lnk_dist_div_cd", ""));
		setDorPstCd(JSPUtil.getParameter(request, prefix + "dor_pst_cd", ""));
		setRailToNodCd(JSPUtil.getParameter(request, prefix + "rail_to_nod_cd", ""));
		setSubEqTpszCd(JSPUtil.getParameter(request, prefix + "sub_eq_tpsz_cd", ""));
		setN1stNodPlnDtHms(JSPUtil.getParameter(request, prefix + "n1st_nod_pln_dt_hms", ""));
		setBkgRcvdeTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcvde_term_cd", ""));
		setTrnsRqstOfcCd(JSPUtil.getParameter(request, prefix + "trns_rqst_ofc_cd", ""));
		setToNodYard2(JSPUtil.getParameter(request, prefix + "to_nod_yard2", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setTroSubSeq(JSPUtil.getParameter(request, prefix + "tro_sub_seq", ""));
		setTrspSoCmbTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_cmb_tp_cd", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setCntrPkupNo(JSPUtil.getParameter(request, prefix + "cntr_pkup_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTrspCostDtlModSep(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_sep", ""));
		setDorArrDt(JSPUtil.getParameter(request, prefix + "dor_arr_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setViaNodCd2(JSPUtil.getParameter(request, prefix + "via_nod_cd2", ""));
		setWoIssStsCd(JSPUtil.getParameter(request, prefix + "wo_iss_sts_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setDorSvcTpCd(JSPUtil.getParameter(request, prefix + "dor_svc_tp_cd", ""));
		setTrspSoStsCd(JSPUtil.getParameter(request, prefix + "trsp_so_sts_cd", ""));
		setShprCustNm(JSPUtil.getParameter(request, prefix + "shpr_cust_nm", ""));
		setCntrSubFlg(JSPUtil.getParameter(request, prefix + "cntr_sub_flg", ""));
		setDorNodCd2(JSPUtil.getParameter(request, prefix + "dor_nod_cd2", ""));
		setTroCfmRevAmt(JSPUtil.getParameter(request, prefix + "tro_cfm_rev_amt", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setBzcAmt(JSPUtil.getParameter(request, prefix + "bzc_amt", ""));
		setMstLclCd(JSPUtil.getParameter(request, prefix + "mst_lcl_cd", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd", ""));
		setViaNodYard2(JSPUtil.getParameter(request, prefix + "via_nod_yard2", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCneeCustNm(JSPUtil.getParameter(request, prefix + "cnee_cust_nm", ""));
		setExSepData(JSPUtil.getParameter(request, prefix + "ex_sep_data", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, prefix + "imdt_ext_flg", ""));
		setLstmExpFlg(JSPUtil.getParameter(request, prefix + "lstm_exp_flg", ""));
		setTroRepCmdtCd(JSPUtil.getParameter(request, prefix + "tro_rep_cmdt_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setDorNodYardNm(JSPUtil.getParameter(request, prefix + "dor_nod_yard_nm", ""));
		setLstLocCd(JSPUtil.getParameter(request, prefix + "lst_loc_cd", ""));
		setCntrPkupYdCd(JSPUtil.getParameter(request, prefix + "cntr_pkup_yd_cd", ""));
		setDorDeAddr(JSPUtil.getParameter(request, prefix + "dor_de_addr", ""));
		setDorNodPlnDtHms(JSPUtil.getParameter(request, prefix + "dor_nod_pln_dt_hms", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setFdrSkdVoyNo(JSPUtil.getParameter(request, prefix + "fdr_skd_voy_no", ""));
		setCngRsnDesc(JSPUtil.getParameter(request, prefix + "cng_rsn_desc", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setTrspRqstOrdBndCd(JSPUtil.getParameter(request, prefix + "trsp_rqst_ord_bnd_cd", ""));
		setCntcPsonFaxNo(JSPUtil.getParameter(request, prefix + "cntc_pson_fax_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
		setMltStopDeFlg(JSPUtil.getParameter(request, prefix + "mlt_stop_de_flg", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setTrspSoTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_tp_cd", ""));
		setRevCurrCd(JSPUtil.getParameter(request, prefix + "rev_curr_cd", ""));
		setOwnrCoCd(JSPUtil.getParameter(request, prefix + "ownr_co_cd", ""));
		setDorNodYard(JSPUtil.getParameter(request, prefix + "dor_nod_yard", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "cntc_pson_phn_no", ""));
		setCntrLbsWgt(JSPUtil.getParameter(request, prefix + "cntr_lbs_wgt", ""));
		setTrnsRqstRsn(JSPUtil.getParameter(request, prefix + "trns_rqst_rsn", ""));
		setViaNodYard(JSPUtil.getParameter(request, prefix + "via_nod_yard", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCtrtCnt(JSPUtil.getParameter(request, prefix + "ctrt_cnt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFmLocContiCd(JSPUtil.getParameter(request, prefix + "fm_loc_conti_cd", ""));
		setRefId(JSPUtil.getParameter(request, prefix + "ref_id", ""));
		setSpotBidFlg(JSPUtil.getParameter(request, prefix + "spot_bid_flg", ""));
		setTrspRqstBkgFlg(JSPUtil.getParameter(request, prefix + "trsp_rqst_bkg_flg", ""));
		setOrgToYdCd(JSPUtil.getParameter(request, prefix + "org_to_yd_cd", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setFmNodYard2(JSPUtil.getParameter(request, prefix + "fm_nod_yard2", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setRepoRefNo(JSPUtil.getParameter(request, prefix + "repo_ref_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setSpotBidNo(JSPUtil.getParameter(request, prefix + "spot_bid_no", ""));
		setCbstatus(JSPUtil.getParameter(request, prefix + "cbstatus", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, prefix + "spcl_instr_rmk", ""));
		setOvrWgtScgAmt(JSPUtil.getParameter(request, prefix + "ovr_wgt_scg_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTroCfmUpdDt1(JSPUtil.getParameter(request, prefix + "tro_cfm_upd_dt1", ""));
		setTroCfmUpdDt2(JSPUtil.getParameter(request, prefix + "tro_cfm_upd_dt2", ""));
		setTrspPurpRsn(JSPUtil.getParameter(request, prefix + "trsp_purp_rsn", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setRepoPlnId(JSPUtil.getParameter(request, prefix + "repo_pln_id", ""));
		setCneeSeq(JSPUtil.getParameter(request, prefix + "cnee_seq", ""));
		setSpotBidDueDt(JSPUtil.getParameter(request, prefix + "spot_bid_due_dt", ""));
		setAvalDt(JSPUtil.getParameter(request, prefix + "aval_dt", ""));
		setRepoRefSeq(JSPUtil.getParameter(request, prefix + "repo_ref_seq", ""));
		setNtfyCustNm(JSPUtil.getParameter(request, prefix + "ntfy_cust_nm", ""));
		setCustNomiTrkrFlg(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SingleTransportationVO[]
	 */
	public SingleTransportationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SingleTransportationVO[]
	 */
	public SingleTransportationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SingleTransportationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd2 = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd2", length));
			String[] ibVvdCd = (JSPUtil.getParameter(request, prefix	+ "ib_vvd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prePullFlg = (JSPUtil.getParameter(request, prefix	+ "pre_pull_flg", length));
			String[] fdrVslCd = (JSPUtil.getParameter(request, prefix	+ "fdr_vsl_cd", length));
			String[] ibdCstmsClrLocCd = (JSPUtil.getParameter(request, prefix	+ "ibd_cstms_clr_loc_cd", length));
			String[] actCustAddrSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_addr_seq", length));
			String[] lstFreeDtHms = (JSPUtil.getParameter(request, prefix	+ "lst_free_dt_hms", length));
			String[] cntFlg = (JSPUtil.getParameter(request, prefix	+ "cnt_flg", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] troCfmUsrId = (JSPUtil.getParameter(request, prefix	+ "tro_cfm_usr_id", length));
			String[] troLodRefNo = (JSPUtil.getParameter(request, prefix	+ "tro_lod_ref_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cgorOrgBlRcvrIndFlg = (JSPUtil.getParameter(request, prefix	+ "cgor_org_bl_rcvr_ind_flg", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] negoAmt = (JSPUtil.getParameter(request, prefix	+ "nego_amt", length));
			String[] fctryNm = (JSPUtil.getParameter(request, prefix	+ "fctry_nm", length));
			String[] shprSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_seq", length));
			String[] dorNodYard2 = (JSPUtil.getParameter(request, prefix	+ "dor_nod_yard2", length));
			String[] cmdtName = (JSPUtil.getParameter(request, prefix	+ "cmdt_name", length));
			String[] uplnSoFlg = (JSPUtil.getParameter(request, prefix	+ "upln_so_flg", length));
			String[] toNodYard = (JSPUtil.getParameter(request, prefix	+ "to_nod_yard", length));
			String[] fmNodCd2 = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd2", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] cgorCstmsAcptReIndFlg = (JSPUtil.getParameter(request, prefix	+ "cgor_cstms_acpt_re_ind_flg", length));
			String[] fmNodYard = (JSPUtil.getParameter(request, prefix	+ "fm_nod_yard", length));
			String[] trspRqstOrdSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_rqst_ord_seq", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] railCreDt = (JSPUtil.getParameter(request, prefix	+ "rail_cre_dt", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] trspRqstOrdRevAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_rqst_ord_rev_amt", length));
			String[] lstFreeDt = (JSPUtil.getParameter(request, prefix	+ "lst_free_dt", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] trnsRqstUsrId = (JSPUtil.getParameter(request, prefix	+ "trns_rqst_usr_id", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] lstNodPlnDt = (JSPUtil.getParameter(request, prefix	+ "lst_nod_pln_dt", length));
			String[] podContiCd = (JSPUtil.getParameter(request, prefix	+ "pod_conti_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] lseCntrFlg = (JSPUtil.getParameter(request, prefix	+ "lse_cntr_flg", length));
			String[] fuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "fuel_scg_amt", length));
			String[] n3ptyBilFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_flg", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_seq", length));
			String[] n1stNodPlnDt = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_pln_dt", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] cgorFrtPayIndFlg = (JSPUtil.getParameter(request, prefix	+ "cgor_frt_pay_ind_flg", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] ifSysKndCd = (JSPUtil.getParameter(request, prefix	+ "if_sys_knd_cd", length));
			String[] cmbSoRltStsFlg = (JSPUtil.getParameter(request, prefix	+ "cmb_so_rlt_sts_flg", length));
			String[] actGrpCd = (JSPUtil.getParameter(request, prefix	+ "act_grp_cd", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] cntrKgsWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_kgs_wgt", length));
			String[] ttlDist = (JSPUtil.getParameter(request, prefix	+ "ttl_dist", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] spclCgoCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cntr_tp_cd", length));
			String[] woIssKnt = (JSPUtil.getParameter(request, prefix	+ "wo_iss_knt", length));
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk", length));
			String[] rplnUmchFlg = (JSPUtil.getParameter(request, prefix	+ "rpln_umch_flg", length));
			String[] dorNodPlnDt = (JSPUtil.getParameter(request, prefix	+ "dor_nod_pln_dt", length));
			String[] cstmsClrNo = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] trspCrrModCd2 = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd2", length));
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] trunkvvd = (JSPUtil.getParameter(request, prefix	+ "trunkvvd", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] trspMtyRqstDt = (JSPUtil.getParameter(request, prefix	+ "trsp_mty_rqst_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] costActGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_cd", length));
			String[] wgtMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_meas_ut_cd", length));
			String[] troCfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "tro_cfm_ofc_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] splIssRsn = (JSPUtil.getParameter(request, prefix	+ "spl_iss_rsn", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trspSoStsNm = (JSPUtil.getParameter(request, prefix	+ "trsp_so_sts_nm", length));
			String[] avalDtHms = (JSPUtil.getParameter(request, prefix	+ "aval_dt_hms", length));
			String[] fdrSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "fdr_skd_dir_cd", length));
			String[] trspMtyCostModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mty_cost_mod_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spotBidDueDtHms = (JSPUtil.getParameter(request, prefix	+ "spot_bid_due_dt_hms", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] trspSoCmbSrtNo = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_srt_no", length));
			String[] railCmbThruTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_cmb_thru_tp_cd", length));
			String[] etcAddAmt = (JSPUtil.getParameter(request, prefix	+ "etc_add_amt", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] bkgEdiRefNo = (JSPUtil.getParameter(request, prefix	+ "bkg_edi_ref_no", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] feedervvd = (JSPUtil.getParameter(request, prefix	+ "feedervvd", length));
			String[] trspNxtPortCd = (JSPUtil.getParameter(request, prefix	+ "trsp_nxt_port_cd", length));
			String[] refSeq = (JSPUtil.getParameter(request, prefix	+ "ref_seq", length));
			String[] obVvdCd = (JSPUtil.getParameter(request, prefix	+ "ob_vvd_cd", length));
			String[] chssMgstTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "chss_mgst_trsp_tp_cd", length));
			String[] trspSoCmbSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_seq", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] lstNodPlnDtHms = (JSPUtil.getParameter(request, prefix	+ "lst_nod_pln_dt_hms", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] lnkDistDivCd = (JSPUtil.getParameter(request, prefix	+ "lnk_dist_div_cd", length));
			String[] dorPstCd = (JSPUtil.getParameter(request, prefix	+ "dor_pst_cd", length));
			String[] railToNodCd = (JSPUtil.getParameter(request, prefix	+ "rail_to_nod_cd", length));
			String[] subEqTpszCd = (JSPUtil.getParameter(request, prefix	+ "sub_eq_tpsz_cd", length));
			String[] n1stNodPlnDtHms = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_pln_dt_hms", length));
			String[] bkgRcvdeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcvde_term_cd", length));
			String[] trnsRqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "trns_rqst_ofc_cd", length));
			String[] toNodYard2 = (JSPUtil.getParameter(request, prefix	+ "to_nod_yard2", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] troSubSeq = (JSPUtil.getParameter(request, prefix	+ "tro_sub_seq", length));
			String[] trspSoCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_tp_cd", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] cntrPkupNo = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] trspCostDtlModSep = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_sep", length));
			String[] dorArrDt = (JSPUtil.getParameter(request, prefix	+ "dor_arr_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] viaNodCd2 = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd2", length));
			String[] woIssStsCd = (JSPUtil.getParameter(request, prefix	+ "wo_iss_sts_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] dorSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "dor_svc_tp_cd", length));
			String[] trspSoStsCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_sts_cd", length));
			String[] shprCustNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_nm", length));
			String[] cntrSubFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_sub_flg", length));
			String[] dorNodCd2 = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd2", length));
			String[] troCfmRevAmt = (JSPUtil.getParameter(request, prefix	+ "tro_cfm_rev_amt", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] bzcAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_amt", length));
			String[] mstLclCd = (JSPUtil.getParameter(request, prefix	+ "mst_lcl_cd", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] viaNodYard2 = (JSPUtil.getParameter(request, prefix	+ "via_nod_yard2", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] cneeCustNm = (JSPUtil.getParameter(request, prefix	+ "cnee_cust_nm", length));
			String[] exSepData = (JSPUtil.getParameter(request, prefix	+ "ex_sep_data", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] lstmExpFlg = (JSPUtil.getParameter(request, prefix	+ "lstm_exp_flg", length));
			String[] troRepCmdtCd = (JSPUtil.getParameter(request, prefix	+ "tro_rep_cmdt_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] dorNodYardNm = (JSPUtil.getParameter(request, prefix	+ "dor_nod_yard_nm", length));
			String[] lstLocCd = (JSPUtil.getParameter(request, prefix	+ "lst_loc_cd", length));
			String[] cntrPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_yd_cd", length));
			String[] dorDeAddr = (JSPUtil.getParameter(request, prefix	+ "dor_de_addr", length));
			String[] dorNodPlnDtHms = (JSPUtil.getParameter(request, prefix	+ "dor_nod_pln_dt_hms", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] fdrSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "fdr_skd_voy_no", length));
			String[] cngRsnDesc = (JSPUtil.getParameter(request, prefix	+ "cng_rsn_desc", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] trspRqstOrdBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_rqst_ord_bnd_cd", length));
			String[] cntcPsonFaxNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_fax_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] mltStopDeFlg = (JSPUtil.getParameter(request, prefix	+ "mlt_stop_de_flg", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] trspSoTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_tp_cd", length));
			String[] revCurrCd = (JSPUtil.getParameter(request, prefix	+ "rev_curr_cd", length));
			String[] ownrCoCd = (JSPUtil.getParameter(request, prefix	+ "ownr_co_cd", length));
			String[] dorNodYard = (JSPUtil.getParameter(request, prefix	+ "dor_nod_yard", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cntcPsonPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_phn_no", length));
			String[] cntrLbsWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_lbs_wgt", length));
			String[] trnsRqstRsn = (JSPUtil.getParameter(request, prefix	+ "trns_rqst_rsn", length));
			String[] viaNodYard = (JSPUtil.getParameter(request, prefix	+ "via_nod_yard", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ctrtCnt = (JSPUtil.getParameter(request, prefix	+ "ctrt_cnt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] fmLocContiCd = (JSPUtil.getParameter(request, prefix	+ "fm_loc_conti_cd", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] spotBidFlg = (JSPUtil.getParameter(request, prefix	+ "spot_bid_flg", length));
			String[] trspRqstBkgFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_rqst_bkg_flg", length));
			String[] orgToYdCd = (JSPUtil.getParameter(request, prefix	+ "org_to_yd_cd", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] fmNodYard2 = (JSPUtil.getParameter(request, prefix	+ "fm_nod_yard2", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] repoRefNo = (JSPUtil.getParameter(request, prefix	+ "repo_ref_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] spotBidNo = (JSPUtil.getParameter(request, prefix	+ "spot_bid_no", length));
			String[] cbstatus = (JSPUtil.getParameter(request, prefix	+ "cbstatus", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_instr_rmk", length));
			String[] ovrWgtScgAmt = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_scg_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] troCfmUpdDt1 = (JSPUtil.getParameter(request, prefix	+ "tro_cfm_upd_dt1", length));
			String[] troCfmUpdDt2 = (JSPUtil.getParameter(request, prefix	+ "tro_cfm_upd_dt2", length));
			String[] trspPurpRsn = (JSPUtil.getParameter(request, prefix	+ "trsp_purp_rsn", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] cneeSeq = (JSPUtil.getParameter(request, prefix	+ "cnee_seq", length));
			String[] spotBidDueDt = (JSPUtil.getParameter(request, prefix	+ "spot_bid_due_dt", length));
			String[] avalDt = (JSPUtil.getParameter(request, prefix	+ "aval_dt", length));
			String[] repoRefSeq = (JSPUtil.getParameter(request, prefix	+ "repo_ref_seq", length));
			String[] ntfyCustNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_cust_nm", length));
			String[] custNomiTrkrFlg = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SingleTransportationVO();
				if (toNodCd2[i] != null)
					model.setToNodCd2(toNodCd2[i]);
				if (ibVvdCd[i] != null)
					model.setIbVvdCd(ibVvdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prePullFlg[i] != null)
					model.setPrePullFlg(prePullFlg[i]);
				if (fdrVslCd[i] != null)
					model.setFdrVslCd(fdrVslCd[i]);
				if (ibdCstmsClrLocCd[i] != null)
					model.setIbdCstmsClrLocCd(ibdCstmsClrLocCd[i]);
				if (actCustAddrSeq[i] != null)
					model.setActCustAddrSeq(actCustAddrSeq[i]);
				if (lstFreeDtHms[i] != null)
					model.setLstFreeDtHms(lstFreeDtHms[i]);
				if (cntFlg[i] != null)
					model.setCntFlg(cntFlg[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (troCfmUsrId[i] != null)
					model.setTroCfmUsrId(troCfmUsrId[i]);
				if (troLodRefNo[i] != null)
					model.setTroLodRefNo(troLodRefNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cgorOrgBlRcvrIndFlg[i] != null)
					model.setCgorOrgBlRcvrIndFlg(cgorOrgBlRcvrIndFlg[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (negoAmt[i] != null)
					model.setNegoAmt(negoAmt[i]);
				if (fctryNm[i] != null)
					model.setFctryNm(fctryNm[i]);
				if (shprSeq[i] != null)
					model.setShprSeq(shprSeq[i]);
				if (dorNodYard2[i] != null)
					model.setDorNodYard2(dorNodYard2[i]);
				if (cmdtName[i] != null)
					model.setCmdtName(cmdtName[i]);
				if (uplnSoFlg[i] != null)
					model.setUplnSoFlg(uplnSoFlg[i]);
				if (toNodYard[i] != null)
					model.setToNodYard(toNodYard[i]);
				if (fmNodCd2[i] != null)
					model.setFmNodCd2(fmNodCd2[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (cgorCstmsAcptReIndFlg[i] != null)
					model.setCgorCstmsAcptReIndFlg(cgorCstmsAcptReIndFlg[i]);
				if (fmNodYard[i] != null)
					model.setFmNodYard(fmNodYard[i]);
				if (trspRqstOrdSeq[i] != null)
					model.setTrspRqstOrdSeq(trspRqstOrdSeq[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (railCreDt[i] != null)
					model.setRailCreDt(railCreDt[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (trspRqstOrdRevAmt[i] != null)
					model.setTrspRqstOrdRevAmt(trspRqstOrdRevAmt[i]);
				if (lstFreeDt[i] != null)
					model.setLstFreeDt(lstFreeDt[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (trnsRqstUsrId[i] != null)
					model.setTrnsRqstUsrId(trnsRqstUsrId[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (lstNodPlnDt[i] != null)
					model.setLstNodPlnDt(lstNodPlnDt[i]);
				if (podContiCd[i] != null)
					model.setPodContiCd(podContiCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (lseCntrFlg[i] != null)
					model.setLseCntrFlg(lseCntrFlg[i]);
				if (fuelScgAmt[i] != null)
					model.setFuelScgAmt(fuelScgAmt[i]);
				if (n3ptyBilFlg[i] != null)
					model.setN3ptyBilFlg(n3ptyBilFlg[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (n1stNodPlnDt[i] != null)
					model.setN1stNodPlnDt(n1stNodPlnDt[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (cgorFrtPayIndFlg[i] != null)
					model.setCgorFrtPayIndFlg(cgorFrtPayIndFlg[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (ifSysKndCd[i] != null)
					model.setIfSysKndCd(ifSysKndCd[i]);
				if (cmbSoRltStsFlg[i] != null)
					model.setCmbSoRltStsFlg(cmbSoRltStsFlg[i]);
				if (actGrpCd[i] != null)
					model.setActGrpCd(actGrpCd[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (cntrKgsWgt[i] != null)
					model.setCntrKgsWgt(cntrKgsWgt[i]);
				if (ttlDist[i] != null)
					model.setTtlDist(ttlDist[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (spclCgoCntrTpCd[i] != null)
					model.setSpclCgoCntrTpCd(spclCgoCntrTpCd[i]);
				if (woIssKnt[i] != null)
					model.setWoIssKnt(woIssKnt[i]);
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (rplnUmchFlg[i] != null)
					model.setRplnUmchFlg(rplnUmchFlg[i]);
				if (dorNodPlnDt[i] != null)
					model.setDorNodPlnDt(dorNodPlnDt[i]);
				if (cstmsClrNo[i] != null)
					model.setCstmsClrNo(cstmsClrNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (trspCrrModCd2[i] != null)
					model.setTrspCrrModCd2(trspCrrModCd2[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (trunkvvd[i] != null)
					model.setTrunkvvd(trunkvvd[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (trspMtyRqstDt[i] != null)
					model.setTrspMtyRqstDt(trspMtyRqstDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (costActGrpCd[i] != null)
					model.setCostActGrpCd(costActGrpCd[i]);
				if (wgtMeasUtCd[i] != null)
					model.setWgtMeasUtCd(wgtMeasUtCd[i]);
				if (troCfmOfcCd[i] != null)
					model.setTroCfmOfcCd(troCfmOfcCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (splIssRsn[i] != null)
					model.setSplIssRsn(splIssRsn[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trspSoStsNm[i] != null)
					model.setTrspSoStsNm(trspSoStsNm[i]);
				if (avalDtHms[i] != null)
					model.setAvalDtHms(avalDtHms[i]);
				if (fdrSkdDirCd[i] != null)
					model.setFdrSkdDirCd(fdrSkdDirCd[i]);
				if (trspMtyCostModCd[i] != null)
					model.setTrspMtyCostModCd(trspMtyCostModCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spotBidDueDtHms[i] != null)
					model.setSpotBidDueDtHms(spotBidDueDtHms[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (trspSoCmbSrtNo[i] != null)
					model.setTrspSoCmbSrtNo(trspSoCmbSrtNo[i]);
				if (railCmbThruTpCd[i] != null)
					model.setRailCmbThruTpCd(railCmbThruTpCd[i]);
				if (etcAddAmt[i] != null)
					model.setEtcAddAmt(etcAddAmt[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (bkgEdiRefNo[i] != null)
					model.setBkgEdiRefNo(bkgEdiRefNo[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (feedervvd[i] != null)
					model.setFeedervvd(feedervvd[i]);
				if (trspNxtPortCd[i] != null)
					model.setTrspNxtPortCd(trspNxtPortCd[i]);
				if (refSeq[i] != null)
					model.setRefSeq(refSeq[i]);
				if (obVvdCd[i] != null)
					model.setObVvdCd(obVvdCd[i]);
				if (chssMgstTrspTpCd[i] != null)
					model.setChssMgstTrspTpCd(chssMgstTrspTpCd[i]);
				if (trspSoCmbSeq[i] != null)
					model.setTrspSoCmbSeq(trspSoCmbSeq[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (lstNodPlnDtHms[i] != null)
					model.setLstNodPlnDtHms(lstNodPlnDtHms[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (lnkDistDivCd[i] != null)
					model.setLnkDistDivCd(lnkDistDivCd[i]);
				if (dorPstCd[i] != null)
					model.setDorPstCd(dorPstCd[i]);
				if (railToNodCd[i] != null)
					model.setRailToNodCd(railToNodCd[i]);
				if (subEqTpszCd[i] != null)
					model.setSubEqTpszCd(subEqTpszCd[i]);
				if (n1stNodPlnDtHms[i] != null)
					model.setN1stNodPlnDtHms(n1stNodPlnDtHms[i]);
				if (bkgRcvdeTermCd[i] != null)
					model.setBkgRcvdeTermCd(bkgRcvdeTermCd[i]);
				if (trnsRqstOfcCd[i] != null)
					model.setTrnsRqstOfcCd(trnsRqstOfcCd[i]);
				if (toNodYard2[i] != null)
					model.setToNodYard2(toNodYard2[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (troSubSeq[i] != null)
					model.setTroSubSeq(troSubSeq[i]);
				if (trspSoCmbTpCd[i] != null)
					model.setTrspSoCmbTpCd(trspSoCmbTpCd[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (cntrPkupNo[i] != null)
					model.setCntrPkupNo(cntrPkupNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (trspCostDtlModSep[i] != null)
					model.setTrspCostDtlModSep(trspCostDtlModSep[i]);
				if (dorArrDt[i] != null)
					model.setDorArrDt(dorArrDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (viaNodCd2[i] != null)
					model.setViaNodCd2(viaNodCd2[i]);
				if (woIssStsCd[i] != null)
					model.setWoIssStsCd(woIssStsCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (dorSvcTpCd[i] != null)
					model.setDorSvcTpCd(dorSvcTpCd[i]);
				if (trspSoStsCd[i] != null)
					model.setTrspSoStsCd(trspSoStsCd[i]);
				if (shprCustNm[i] != null)
					model.setShprCustNm(shprCustNm[i]);
				if (cntrSubFlg[i] != null)
					model.setCntrSubFlg(cntrSubFlg[i]);
				if (dorNodCd2[i] != null)
					model.setDorNodCd2(dorNodCd2[i]);
				if (troCfmRevAmt[i] != null)
					model.setTroCfmRevAmt(troCfmRevAmt[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (bzcAmt[i] != null)
					model.setBzcAmt(bzcAmt[i]);
				if (mstLclCd[i] != null)
					model.setMstLclCd(mstLclCd[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (viaNodYard2[i] != null)
					model.setViaNodYard2(viaNodYard2[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (cneeCustNm[i] != null)
					model.setCneeCustNm(cneeCustNm[i]);
				if (exSepData[i] != null)
					model.setExSepData(exSepData[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (lstmExpFlg[i] != null)
					model.setLstmExpFlg(lstmExpFlg[i]);
				if (troRepCmdtCd[i] != null)
					model.setTroRepCmdtCd(troRepCmdtCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (dorNodYardNm[i] != null)
					model.setDorNodYardNm(dorNodYardNm[i]);
				if (lstLocCd[i] != null)
					model.setLstLocCd(lstLocCd[i]);
				if (cntrPkupYdCd[i] != null)
					model.setCntrPkupYdCd(cntrPkupYdCd[i]);
				if (dorDeAddr[i] != null)
					model.setDorDeAddr(dorDeAddr[i]);
				if (dorNodPlnDtHms[i] != null)
					model.setDorNodPlnDtHms(dorNodPlnDtHms[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (fdrSkdVoyNo[i] != null)
					model.setFdrSkdVoyNo(fdrSkdVoyNo[i]);
				if (cngRsnDesc[i] != null)
					model.setCngRsnDesc(cngRsnDesc[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (trspRqstOrdBndCd[i] != null)
					model.setTrspRqstOrdBndCd(trspRqstOrdBndCd[i]);
				if (cntcPsonFaxNo[i] != null)
					model.setCntcPsonFaxNo(cntcPsonFaxNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (mltStopDeFlg[i] != null)
					model.setMltStopDeFlg(mltStopDeFlg[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (trspSoTpCd[i] != null)
					model.setTrspSoTpCd(trspSoTpCd[i]);
				if (revCurrCd[i] != null)
					model.setRevCurrCd(revCurrCd[i]);
				if (ownrCoCd[i] != null)
					model.setOwnrCoCd(ownrCoCd[i]);
				if (dorNodYard[i] != null)
					model.setDorNodYard(dorNodYard[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cntcPsonPhnNo[i] != null)
					model.setCntcPsonPhnNo(cntcPsonPhnNo[i]);
				if (cntrLbsWgt[i] != null)
					model.setCntrLbsWgt(cntrLbsWgt[i]);
				if (trnsRqstRsn[i] != null)
					model.setTrnsRqstRsn(trnsRqstRsn[i]);
				if (viaNodYard[i] != null)
					model.setViaNodYard(viaNodYard[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ctrtCnt[i] != null)
					model.setCtrtCnt(ctrtCnt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (fmLocContiCd[i] != null)
					model.setFmLocContiCd(fmLocContiCd[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (spotBidFlg[i] != null)
					model.setSpotBidFlg(spotBidFlg[i]);
				if (trspRqstBkgFlg[i] != null)
					model.setTrspRqstBkgFlg(trspRqstBkgFlg[i]);
				if (orgToYdCd[i] != null)
					model.setOrgToYdCd(orgToYdCd[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (fmNodYard2[i] != null)
					model.setFmNodYard2(fmNodYard2[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (repoRefNo[i] != null)
					model.setRepoRefNo(repoRefNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (spotBidNo[i] != null)
					model.setSpotBidNo(spotBidNo[i]);
				if (cbstatus[i] != null)
					model.setCbstatus(cbstatus[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (ovrWgtScgAmt[i] != null)
					model.setOvrWgtScgAmt(ovrWgtScgAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (troCfmUpdDt1[i] != null)
					model.setTroCfmUpdDt1(troCfmUpdDt1[i]);
				if (troCfmUpdDt2[i] != null)
					model.setTroCfmUpdDt2(troCfmUpdDt2[i]);
				if (trspPurpRsn[i] != null)
					model.setTrspPurpRsn(trspPurpRsn[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (cneeSeq[i] != null)
					model.setCneeSeq(cneeSeq[i]);
				if (spotBidDueDt[i] != null)
					model.setSpotBidDueDt(spotBidDueDt[i]);
				if (avalDt[i] != null)
					model.setAvalDt(avalDt[i]);
				if (repoRefSeq[i] != null)
					model.setRepoRefSeq(repoRefSeq[i]);
				if (ntfyCustNm[i] != null)
					model.setNtfyCustNm(ntfyCustNm[i]);
				if (custNomiTrkrFlg[i] != null)
					model.setCustNomiTrkrFlg(custNomiTrkrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSingleTransportationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SingleTransportationVO[]
	 */
	public SingleTransportationVO[] getSingleTransportationVOs(){
		SingleTransportationVO[] vos = (SingleTransportationVO[])models.toArray(new SingleTransportationVO[models.size()]);
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
		this.toNodCd2 = this.toNodCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibVvdCd = this.ibVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePullFlg = this.prePullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVslCd = this.fdrVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdCstmsClrLocCd = this.ibdCstmsClrLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustAddrSeq = this.actCustAddrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFreeDtHms = this.lstFreeDtHms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntFlg = this.cntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmUsrId = this.troCfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troLodRefNo = this.troLodRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorOrgBlRcvrIndFlg = this.cgorOrgBlRcvrIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoAmt = this.negoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctryNm = this.fctryNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSeq = this.shprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodYard2 = this.dorNodYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtName = this.cmdtName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uplnSoFlg = this.uplnSoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodYard = this.toNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd2 = this.fmNodCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorCstmsAcptReIndFlg = this.cgorCstmsAcptReIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodYard = this.fmNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRqstOrdSeq = this.trspRqstOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCreDt = this.railCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRqstOrdRevAmt = this.trspRqstOrdRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFreeDt = this.lstFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsRqstUsrId = this.trnsRqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstNodPlnDt = this.lstNodPlnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podContiCd = this.podContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseCntrFlg = this.lseCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelScgAmt = this.fuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilFlg = this.n3ptyBilFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodPlnDt = this.n1stNodPlnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorFrtPayIndFlg = this.cgorFrtPayIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSysKndCd = this.ifSysKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbSoRltStsFlg = this.cmbSoRltStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actGrpCd = this.actGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrKgsWgt = this.cntrKgsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDist = this.ttlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCntrTpCd = this.spclCgoCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssKnt = this.woIssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplnUmchFlg = this.rplnUmchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodPlnDt = this.dorNodPlnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrNo = this.cstmsClrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd2 = this.trspCrrModCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq = this.trspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkvvd = this.trunkvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMtyRqstDt = this.trspMtyRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpCd = this.costActGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtMeasUtCd = this.wgtMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmOfcCd = this.troCfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splIssRsn = this.splIssRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoStsNm = this.trspSoStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avalDtHms = this.avalDtHms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrSkdDirCd = this.fdrSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMtyCostModCd = this.trspMtyCostModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidDueDtHms = this.spotBidDueDtHms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbSrtNo = this.trspSoCmbSrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCmbThruTpCd = this.railCmbThruTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcAddAmt = this.etcAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgEdiRefNo = this.bkgEdiRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feedervvd = this.feedervvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspNxtPortCd = this.trspNxtPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSeq = this.refSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obVvdCd = this.obVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMgstTrspTpCd = this.chssMgstTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbSeq = this.trspSoCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstNodPlnDtHms = this.lstNodPlnDtHms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDistDivCd = this.lnkDistDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorPstCd = this.dorPstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railToNodCd = this.railToNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subEqTpszCd = this.subEqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodPlnDtHms = this.n1stNodPlnDtHms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvdeTermCd = this.bkgRcvdeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsRqstOfcCd = this.trnsRqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodYard2 = this.toNodYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSubSeq = this.troSubSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbTpCd = this.trspSoCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupNo = this.cntrPkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModSep = this.trspCostDtlModSep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorArrDt = this.dorArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd2 = this.viaNodCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssStsCd = this.woIssStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorSvcTpCd = this.dorSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoStsCd = this.trspSoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustNm = this.shprCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSubFlg = this.cntrSubFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd2 = this.dorNodCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmRevAmt = this.troCfmRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt = this.bzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstLclCd = this.mstLclCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodYard2 = this.viaNodYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCustNm = this.cneeCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exSepData = this.exSepData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmExpFlg = this.lstmExpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troRepCmdtCd = this.troRepCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodYardNm = this.dorNodYardNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLocCd = this.lstLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupYdCd = this.cntrPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorDeAddr = this.dorDeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodPlnDtHms = this.dorNodPlnDtHms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrSkdVoyNo = this.fdrSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngRsnDesc = this.cngRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRqstOrdBndCd = this.trspRqstOrdBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonFaxNo = this.cntcPsonFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltStopDeFlg = this.mltStopDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpCd = this.trspSoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCurrCd = this.revCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrCoCd = this.ownrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodYard = this.dorNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonPhnNo = this.cntcPsonPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLbsWgt = this.cntrLbsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsRqstRsn = this.trnsRqstRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodYard = this.viaNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCnt = this.ctrtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocContiCd = this.fmLocContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidFlg = this.spotBidFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRqstBkgFlg = this.trspRqstBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgToYdCd = this.orgToYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodYard2 = this.fmNodYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoRefNo = this.repoRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidNo = this.spotBidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbstatus = this.cbstatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtScgAmt = this.ovrWgtScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmUpdDt1 = this.troCfmUpdDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmUpdDt2 = this.troCfmUpdDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspPurpRsn = this.trspPurpRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeSeq = this.cneeSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidDueDt = this.spotBidDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avalDt = this.avalDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoRefSeq = this.repoRefSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCustNm = this.ntfyCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrFlg = this.custNomiTrkrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
