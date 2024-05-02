/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlCntrInfoReportOutVO.java
*@FileTitle : BlCntrInfoReportOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
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
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlCntrInfoReportOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlCntrInfoReportOutVO> models = new ArrayList<BlCntrInfoReportOutVO>();
	
	/* Column Info */
	private String delAta = null;
	/* Column Info */
	private String sumWgtLbs = null;
	/* Column Info */
	private String trunkPolAta = null;
	/* Column Info */
	private String oblIssDt = null;
	/* Column Info */
	private String cntrSz = null;
	/* Column Info */
	private String srdOfc = null;
	/* Column Info */
	private String cntCntr = null;
	/* Column Info */
	private String xptLicNo = null;
	/* Column Info */
	private String hamoCdDesc = null;
	/* Column Info */
	private String postVsl = null;
	/* Column Info */
	private String hlgTp = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* Column Info */
	private String destTrnsSvcModCd = null;
	/* Column Info */
	private String ibFrhFlg = null;
	/* Column Info */
	private String cptTtlAmt = null;
	/* Column Info */
	private String grsWgtUtCd = null;
	/* Column Info */
	private String cmdtHsCd = null;
	/* Column Info */
	private String exMvmtRefNo = null;
	/* Column Info */
	private String captOfc = null;
	/* Column Info */
	private String podAtaIcDt = null;
	/* Column Info */
	private String oblIssOfcCd = null;
	/* Column Info */
	private String cstmsUsrRdy = null;
	/* Column Info */
	private String cstmsReq = null;
	/* Column Info */
	private String lastPod = null;
	/* Column Info */
	private String obXchRtDt = null;
	/* Column Info */
	private String sumGrsWgtKgs = null;
	/* Column Info */
	private String finalDestNm = null;
	/* Column Info */
	private String troi = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String srdDt = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String vvd3 = null;
	/* Column Info */
	private String cntBl = null;
	/* Column Info */
	private String post1Vvd = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String shCustNm = null;
	/* Column Info */
	private String vvd4 = null;
	/* Column Info */
	private String trunkPolEta = null;
	/* Column Info */
	private String lastVvd = null;
	/* Column Info */
	private String sumNetMeaCbm = null;
	/* Column Info */
	private String lastPodEtb = null;
	/* Column Info */
	private String n1stPodEta = null;
	/* Column Info */
	private String pre3PodCd = null;
	/* Column Info */
	private String lastPodEta = null;
	/* Column Info */
	private String n1stPodEtd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String cntrSts = null;
	/* Column Info */
	private String ntWgtQty = null;
	/* Column Info */
	private String disLastVvd = null;
	/* Column Info */
	private String scacCd = null;
	/* Column Info */
	private String trunkPodCd = null;
	/* Column Info */
	private String obSlsRgnCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String pre2PolCd = null;
	/* Column Info */
	private String nfCustNm = null;
	/* Column Info */
	private String postVvd = null;
	/* Column Info */
	private String sumGrsMeaCbm = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String lastPodAta = null;
	/* Column Info */
	private String delNm = null;
	/* Column Info */
	private String pre4PolCd = null;
	/* Column Info */
	private String trunkPodEtd = null;
	/* Column Info */
	private String blSlanCd = null;
	/* Column Info */
	private String trunkPodEta = null;
	/* Column Info */
	private String oblRlseFlg = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String trunkVsl = null;
	/* Column Info */
	private String shCntcPsonNm = null;
	/* Column Info */
	private String cnCustNm = null;
	/* Column Info */
	private String cntBkg = null;
	/* Column Info */
	private String clrBy = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cntPck = null;
	/* Column Info */
	private String oblInetPrnDt = null;
	/* Column Info */
	private String trunkPolCd = null;
	/* Column Info */
	private String tsPort2 = null;
	/* Column Info */
	private String tsPort3 = null;
	/* Column Info */
	private String pre1Vvd = null;
	/* Column Info */
	private String firstVsl = null;
	/* Column Info */
	private String cgoNature = null;
	/* Column Info */
	private String tsPort1 = null;
	/* Column Info */
	private String polNm = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String ntWgtUtCd = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String pre4PodCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String obVvd1 = null;
	/* Column Info */
	private String trfCd = null;
	/* Column Info */
	private String pre3PolCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String n1stPodAtd = null;
	/* Column Info */
	private String preVvd = null;
	/* Column Info */
	private String pre1PodCd = null;
	/* Column Info */
	private String post4Vvd = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String cstmsDecl = null;
	/* Column Info */
	private String actTotWgt = null;
	/* Column Info */
	private String ibXchRtDt = null;
	/* Column Info */
	private String ntMeasQty = null;
	/* Column Info */
	private String ibCtrlOfc = null;
	/* Column Info */
	private String hblNo = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String colCurrCd = null;
	/* Column Info */
	private String tareWgt = null;
	/* Column Info */
	private String cctTtlAmt = null;
	/* Column Info */
	private String ffCntcPsonNm = null;
	/* Column Info */
	private String anCustNm = null;
	/* Column Info */
	private String ibdTrspTpCd = null;
	/* Column Info */
	private String ibdTrspNo = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String finalPodEta = null;
	/* Column Info */
	private String delCntCd = null;
	/* Column Info */
	private String cstmsSysRdy = null;
	/* Column Info */
	private String trunkSlanCd = null;
	/* Column Info */
	private String finalPodEtd = null;
	/* Column Info */
	private String bkgIssOfcCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String tvvd = null;
	/* Column Info */
	private String blVvd = null;
	/* Column Info */
	private String rdTerm = null;
	/* Column Info */
	private String rlseStsCd = null;
	/* Column Info */
	private String porNm = null;
	/* Column Info */
	private String trafMod = null;
	/* Column Info */
	private String pre3Vvd = null;
	/* Column Info */
	private String n3rdNtfyPty = null;
	/* Column Info */
	private String post3Vvd = null;
	/* Column Info */
	private String blObrdDt = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String trunkPodAta = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String siDt = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String orgTrnsSvcModCd = null;
	/* Column Info */
	private String docUsrId = null;
	/* Column Info */
	private String firstPolCutoffDt = null;
	/* Column Info */
	private String preCurrCd = null;
	/* Column Info */
	private String trunkVvd = null;
	/* Column Info */
	private String n1stPod = null;
	/* Column Info */
	private String nvoccCoScacCd = null;
	/* Column Info */
	private String polEtd = null;
	/* Column Info */
	private String crd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oblInetFlg = null;
	/* Column Info */
	private String ffCustNm = null;
	/* Column Info */
	private String lastVsl = null;
	/* Column Info */
	private String sumWgtTon = null;
	/* Column Info */
	private String shCntcNum = null;
	/* Column Info */
	private String trunkVslNm = null;
	/* Column Info */
	private String krCstmsCustTpCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String crn = null;
	/* Column Info */
	private String preVsl = null;
	/* Column Info */
	private String pre2Vvd = null;
	/* Column Info */
	private String porCntCd = null;
	/* Column Info */
	private String mvmtRefNo = null;
	/* Column Info */
	private String finalPolEtd = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String finalPolEta = null;
	/* Column Info */
	private String stCmdtNm = null;
	/* Column Info */
	private String fwCntcNum = null;
	/* Column Info */
	private String pre2PodCd = null;
	/* Column Info */
	private String n1stPolEta = null;
	/* Column Info */
	private String n1stPolEtb = null;
	/* Column Info */
	private String sumPpdAmt = null;
	/* Column Info */
	private String n1stPolEtd = null;
	/* Column Info */
	private String cgoRlseSts = null;
	/* Column Info */
	private String delEta = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String scacNm = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String sumCctAmt = null;
	/* Column Info */
	private String ntMeasUtCd = null;
	/* Column Info */
	private String pre1PolCd = null;
	/* Column Info */
	private String cntrTp = null;
	/* Column Info */
	private String post2Vvd = null;
	/* Column Info */
	private String blPrtDt = null;
	/* Column Info */
	private String pre4Vvd = null;
	/* Column Info */
	private String sumNetWgtKgs = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String podEtb = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BlCntrInfoReportOutVO() {}

	public BlCntrInfoReportOutVO(String ibflag, String pagerows, String rnum, String cstmsDecl, String cstmsReq, String cstmsSysRdy, String cstmsUsrRdy, String cntBkg, String cntBl, String cntCntr, String cntPck, String sumWgtTon, String sumGrsWgtKgs, String sumNetWgtKgs, String sumWgtLbs, String sumGrsMeaCbm, String sumNetMeaCbm, String sumCctAmt, String sumPpdAmt, String docUsrId, String blNo, String blPrtDt, String bkgStsCd, String srdDt, String blTpCd, String krCstmsCustTpCd, String bkgNo, String captOfc, String crd, String cgoRlseSts, String scacNm, String clrBy, String oblInetPrnDt, String oblIssDt, String hblNo, String nvoccCoScacCd, String blObrdDt, String oblRlseFlg, String splitFlg, String oblIssOfcCd, String bkgIssOfcCd, String obSlsOfcCd, String obSlsRgnCd, String obSrepCd, String scacCd, String siDt, String srdOfc, String cmdtNm, String cgoNature, String actWgt, String measUtCd, String grsWgt, String grsWgtUtCd, String cmdtHsCd, String hamoCdDesc, String ntMeasQty, String ntMeasUtCd, String ntWgtQty, String ntWgtUtCd, String pckQty, String pckTpCd, String stCmdtNm, String tareWgt, String actTotWgt, String colCurrCd, String cctTtlAmt, String ibXchRtDt, String obXchRtDt, String preCurrCd, String cptTtlAmt, String cntrNo, String cntrSz, String cntrSts, String cntrTp, String cntrSealNo, String nfCustNm, String anCustNm, String n3rdNtfyPty, String cnCustNm, String ffCustNm, String ffCntcPsonNm, String fwCntcNum, String oblInetFlg, String shCustNm, String shCntcPsonNm, String shCntcNum, String rlseStsCd, String ibCtrlOfc, String troi, String ibFrhFlg, String trfCd, String ibdTrspTpCd, String crn, String xptLicNo, String mvmtRefNo, String ibdTrspNo, String n1stPodEta, String n1stPodEtd, String n1stPolEta, String n1stPolEtd, String vvd1, String vvd2, String vvd3, String vvd4, String lastPodAta, String trunkPodAta, String n1stPodAtd, String trunkPolAta, String skdDirCd, String blSlanCd, String vslCd, String skdVoyNo, String blVvd, String n1stPolEtb, String lastPodEtb, String blckStwgCd, String delAta, String delCd, String delCntCd, String delEta, String delNm, String destTrnsSvcModCd, String n1stPod, String finalDestNm, String finalPodEta, String finalPodEtd, String finalPolEta, String finalPolEtd, String lastVvd, String slanCd, String disLastVvd, String obVvd1, String hlgTp, String orgTrnsSvcModCd, String bkgPodCd, String lastPod, String lastVsl, String podAtaIcDt, String podCd, String lastPodEta, String podEtb, String podNm, String bkgPolCd, String firstVsl, String polCd, String firstPolCutoffDt, String polEtd, String polNm, String porCd, String porCntCd, String porNm, String post1Vvd, String post2Vvd, String post3Vvd, String post4Vvd, String pstRlyPortCd, String postVsl, String postVvd, String pre1PodCd, String pre1PolCd, String pre1Vvd, String pre2PodCd, String pre2PolCd, String pre2Vvd, String pre3PodCd, String pre3PolCd, String pre3Vvd, String pre4PodCd, String pre4PolCd, String pre4Vvd, String preRlyPortCd, String preVsl, String preVvd, String rdTerm, String tsPort1, String tsPort2, String tsPort3, String tvvd, String trdCd, String trafMod, String trunkSlanCd, String trunkPodCd, String trunkPodEta, String trunkPodEtd, String trunkPolCd, String trunkPolEta, String trunkVsl, String trunkVvd, String trunkVslNm, String exMvmtRefNo) {
		this.delAta = delAta;
		this.sumWgtLbs = sumWgtLbs;
		this.trunkPolAta = trunkPolAta;
		this.oblIssDt = oblIssDt;
		this.cntrSz = cntrSz;
		this.srdOfc = srdOfc;
		this.cntCntr = cntCntr;
		this.xptLicNo = xptLicNo;
		this.hamoCdDesc = hamoCdDesc;
		this.postVsl = postVsl;
		this.hlgTp = hlgTp;
		this.pagerows = pagerows;
		this.obSrepCd = obSrepCd;
		this.bkgPodCd = bkgPodCd;
		this.destTrnsSvcModCd = destTrnsSvcModCd;
		this.ibFrhFlg = ibFrhFlg;
		this.cptTtlAmt = cptTtlAmt;
		this.grsWgtUtCd = grsWgtUtCd;
		this.cmdtHsCd = cmdtHsCd;
		this.exMvmtRefNo = exMvmtRefNo;
		this.captOfc = captOfc;
		this.podAtaIcDt = podAtaIcDt;
		this.oblIssOfcCd = oblIssOfcCd;
		this.cstmsUsrRdy = cstmsUsrRdy;
		this.cstmsReq = cstmsReq;
		this.lastPod = lastPod;
		this.obXchRtDt = obXchRtDt;
		this.sumGrsWgtKgs = sumGrsWgtKgs;
		this.finalDestNm = finalDestNm;
		this.troi = troi;
		this.skdVoyNo = skdVoyNo;
		this.srdDt = srdDt;
		this.vvd2 = vvd2;
		this.vvd3 = vvd3;
		this.cntBl = cntBl;
		this.post1Vvd = post1Vvd;
		this.vvd1 = vvd1;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.shCustNm = shCustNm;
		this.vvd4 = vvd4;
		this.trunkPolEta = trunkPolEta;
		this.lastVvd = lastVvd;
		this.sumNetMeaCbm = sumNetMeaCbm;
		this.lastPodEtb = lastPodEtb;
		this.n1stPodEta = n1stPodEta;
		this.pre3PodCd = pre3PodCd;
		this.lastPodEta = lastPodEta;
		this.n1stPodEtd = n1stPodEtd;
		this.bkgStsCd = bkgStsCd;
		this.cntrSts = cntrSts;
		this.ntWgtQty = ntWgtQty;
		this.disLastVvd = disLastVvd;
		this.scacCd = scacCd;
		this.trunkPodCd = trunkPodCd;
		this.obSlsRgnCd = obSlsRgnCd;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.pre2PolCd = pre2PolCd;
		this.nfCustNm = nfCustNm;
		this.postVvd = postVvd;
		this.sumGrsMeaCbm = sumGrsMeaCbm;
		this.podNm = podNm;
		this.lastPodAta = lastPodAta;
		this.delNm = delNm;
		this.pre4PolCd = pre4PolCd;
		this.trunkPodEtd = trunkPodEtd;
		this.blSlanCd = blSlanCd;
		this.trunkPodEta = trunkPodEta;
		this.oblRlseFlg = oblRlseFlg;
		this.slanCd = slanCd;
		this.cntrNo = cntrNo;
		this.trunkVsl = trunkVsl;
		this.shCntcPsonNm = shCntcPsonNm;
		this.cnCustNm = cnCustNm;
		this.cntBkg = cntBkg;
		this.clrBy = clrBy;
		this.vslCd = vslCd;
		this.cntPck = cntPck;
		this.oblInetPrnDt = oblInetPrnDt;
		this.trunkPolCd = trunkPolCd;
		this.tsPort2 = tsPort2;
		this.tsPort3 = tsPort3;
		this.pre1Vvd = pre1Vvd;
		this.firstVsl = firstVsl;
		this.cgoNature = cgoNature;
		this.tsPort1 = tsPort1;
		this.polNm = polNm;
		this.trdCd = trdCd;
		this.ntWgtUtCd = ntWgtUtCd;
		this.blckStwgCd = blckStwgCd;
		this.pre4PodCd = pre4PodCd;
		this.blNo = blNo;
		this.obVvd1 = obVvd1;
		this.trfCd = trfCd;
		this.pre3PolCd = pre3PolCd;
		this.polCd = polCd;
		this.n1stPodAtd = n1stPodAtd;
		this.preVvd = preVvd;
		this.pre1PodCd = pre1PodCd;
		this.post4Vvd = post4Vvd;
		this.rnum = rnum;
		this.cstmsDecl = cstmsDecl;
		this.actTotWgt = actTotWgt;
		this.ibXchRtDt = ibXchRtDt;
		this.ntMeasQty = ntMeasQty;
		this.ibCtrlOfc = ibCtrlOfc;
		this.hblNo = hblNo;
		this.obSlsOfcCd = obSlsOfcCd;
		this.colCurrCd = colCurrCd;
		this.tareWgt = tareWgt;
		this.cctTtlAmt = cctTtlAmt;
		this.ffCntcPsonNm = ffCntcPsonNm;
		this.anCustNm = anCustNm;
		this.ibdTrspTpCd = ibdTrspTpCd;
		this.ibdTrspNo = ibdTrspNo;
		this.preRlyPortCd = preRlyPortCd;
		this.finalPodEta = finalPodEta;
		this.delCntCd = delCntCd;
		this.cstmsSysRdy = cstmsSysRdy;
		this.trunkSlanCd = trunkSlanCd;
		this.finalPodEtd = finalPodEtd;
		this.bkgIssOfcCd = bkgIssOfcCd;
		this.delCd = delCd;
		this.tvvd = tvvd;
		this.blVvd = blVvd;
		this.rdTerm = rdTerm;
		this.rlseStsCd = rlseStsCd;
		this.porNm = porNm;
		this.trafMod = trafMod;
		this.pre3Vvd = pre3Vvd;
		this.n3rdNtfyPty = n3rdNtfyPty;
		this.post3Vvd = post3Vvd;
		this.blObrdDt = blObrdDt;
		this.pstRlyPortCd = pstRlyPortCd;
		this.trunkPodAta = trunkPodAta;
		this.grsWgt = grsWgt;
		this.porCd = porCd;
		this.siDt = siDt;
		this.splitFlg = splitFlg;
		this.orgTrnsSvcModCd = orgTrnsSvcModCd;
		this.docUsrId = docUsrId;
		this.firstPolCutoffDt = firstPolCutoffDt;
		this.preCurrCd = preCurrCd;
		this.trunkVvd = trunkVvd;
		this.n1stPod = n1stPod;
		this.nvoccCoScacCd = nvoccCoScacCd;
		this.polEtd = polEtd;
		this.crd = crd;
		this.ibflag = ibflag;
		this.oblInetFlg = oblInetFlg;
		this.ffCustNm = ffCustNm;
		this.lastVsl = lastVsl;
		this.sumWgtTon = sumWgtTon;
		this.shCntcNum = shCntcNum;
		this.trunkVslNm = trunkVslNm;
		this.krCstmsCustTpCd = krCstmsCustTpCd;
		this.pckQty = pckQty;
		this.crn = crn;
		this.preVsl = preVsl;
		this.pre2Vvd = pre2Vvd;
		this.porCntCd = porCntCd;
		this.mvmtRefNo = mvmtRefNo;
		this.finalPolEtd = finalPolEtd;
		this.bkgPolCd = bkgPolCd;
		this.finalPolEta = finalPolEta;
		this.stCmdtNm = stCmdtNm;
		this.fwCntcNum = fwCntcNum;
		this.pre2PodCd = pre2PodCd;
		this.n1stPolEta = n1stPolEta;
		this.n1stPolEtb = n1stPolEtb;
		this.sumPpdAmt = sumPpdAmt;
		this.n1stPolEtd = n1stPolEtd;
		this.cgoRlseSts = cgoRlseSts;
		this.delEta = delEta;
		this.skdDirCd = skdDirCd;
		this.cmdtNm = cmdtNm;
		this.scacNm = scacNm;
		this.blTpCd = blTpCd;
		this.actWgt = actWgt;
		this.sumCctAmt = sumCctAmt;
		this.ntMeasUtCd = ntMeasUtCd;
		this.pre1PolCd = pre1PolCd;
		this.cntrTp = cntrTp;
		this.post2Vvd = post2Vvd;
		this.blPrtDt = blPrtDt;
		this.pre4Vvd = pre4Vvd;
		this.sumNetWgtKgs = sumNetWgtKgs;
		this.cntrSealNo = cntrSealNo;
		this.podEtb = podEtb;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("del_ata", getDelAta());
		this.hashColumns.put("sum_wgt_lbs", getSumWgtLbs());
		this.hashColumns.put("trunk_pol_ata", getTrunkPolAta());
		this.hashColumns.put("obl_iss_dt", getOblIssDt());
		this.hashColumns.put("cntr_sz", getCntrSz());
		this.hashColumns.put("srd_ofc", getSrdOfc());
		this.hashColumns.put("cnt_cntr", getCntCntr());
		this.hashColumns.put("xpt_lic_no", getXptLicNo());
		this.hashColumns.put("hamo_cd_desc", getHamoCdDesc());
		this.hashColumns.put("post_vsl", getPostVsl());
		this.hashColumns.put("hlg_tp", getHlgTp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("dest_trns_svc_mod_cd", getDestTrnsSvcModCd());
		this.hashColumns.put("ib_frh_flg", getIbFrhFlg());
		this.hashColumns.put("cpt_ttl_amt", getCptTtlAmt());
		this.hashColumns.put("grs_wgt_ut_cd", getGrsWgtUtCd());
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
		this.hashColumns.put("ex_mvmt_ref_no", getExMvmtRefNo());
		this.hashColumns.put("capt_ofc", getCaptOfc());
		this.hashColumns.put("pod_ata_ic_dt", getPodAtaIcDt());
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());
		this.hashColumns.put("cstms_usr_rdy", getCstmsUsrRdy());
		this.hashColumns.put("cstms_req", getCstmsReq());
		this.hashColumns.put("last_pod", getLastPod());
		this.hashColumns.put("ob_xch_rt_dt", getObXchRtDt());
		this.hashColumns.put("sum_grs_wgt_kgs", getSumGrsWgtKgs());
		this.hashColumns.put("final_dest_nm", getFinalDestNm());
		this.hashColumns.put("troi", getTroi());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("srd_dt", getSrdDt());
		this.hashColumns.put("vvd_2", getVvd2());
		this.hashColumns.put("vvd_3", getVvd3());
		this.hashColumns.put("cnt_bl", getCntBl());
		this.hashColumns.put("post1_vvd", getPost1Vvd());
		this.hashColumns.put("vvd_1", getVvd1());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sh_cust_nm", getShCustNm());
		this.hashColumns.put("vvd_4", getVvd4());
		this.hashColumns.put("trunk_pol_eta", getTrunkPolEta());
		this.hashColumns.put("last_vvd", getLastVvd());
		this.hashColumns.put("sum_net_mea_cbm", getSumNetMeaCbm());
		this.hashColumns.put("last_pod_etb", getLastPodEtb());
		this.hashColumns.put("n1st_pod_eta", getN1stPodEta());
		this.hashColumns.put("pre3_pod_cd", getPre3PodCd());
		this.hashColumns.put("last_pod_eta", getLastPodEta());
		this.hashColumns.put("n1st_pod_etd", getN1stPodEtd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("cntr_sts", getCntrSts());
		this.hashColumns.put("nt_wgt_qty", getNtWgtQty());
		this.hashColumns.put("dis_last_vvd", getDisLastVvd());
		this.hashColumns.put("scac_cd", getScacCd());
		this.hashColumns.put("trunk_pod_cd", getTrunkPodCd());
		this.hashColumns.put("ob_sls_rgn_cd", getObSlsRgnCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("pre2_pol_cd", getPre2PolCd());
		this.hashColumns.put("nf_cust_nm", getNfCustNm());
		this.hashColumns.put("post_vvd", getPostVvd());
		this.hashColumns.put("sum_grs_mea_cbm", getSumGrsMeaCbm());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("last_pod_ata", getLastPodAta());
		this.hashColumns.put("del_nm", getDelNm());
		this.hashColumns.put("pre4_pol_cd", getPre4PolCd());
		this.hashColumns.put("trunk_pod_etd", getTrunkPodEtd());
		this.hashColumns.put("bl_slan_cd", getBlSlanCd());
		this.hashColumns.put("trunk_pod_eta", getTrunkPodEta());
		this.hashColumns.put("obl_rlse_flg", getOblRlseFlg());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("trunk_vsl", getTrunkVsl());
		this.hashColumns.put("sh_cntc_pson_nm", getShCntcPsonNm());
		this.hashColumns.put("cn_cust_nm", getCnCustNm());
		this.hashColumns.put("cnt_bkg", getCntBkg());
		this.hashColumns.put("clr_by", getClrBy());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cnt_pck", getCntPck());
		this.hashColumns.put("obl_inet_prn_dt", getOblInetPrnDt());
		this.hashColumns.put("trunk_pol_cd", getTrunkPolCd());
		this.hashColumns.put("ts_port2", getTsPort2());
		this.hashColumns.put("ts_port3", getTsPort3());
		this.hashColumns.put("pre1_vvd", getPre1Vvd());
		this.hashColumns.put("first_vsl", getFirstVsl());
		this.hashColumns.put("cgo_nature", getCgoNature());
		this.hashColumns.put("ts_port1", getTsPort1());
		this.hashColumns.put("pol_nm", getPolNm());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("nt_wgt_ut_cd", getNtWgtUtCd());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("pre4_pod_cd", getPre4PodCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ob_vvd_1", getObVvd1());
		this.hashColumns.put("trf_cd", getTrfCd());
		this.hashColumns.put("pre3_pol_cd", getPre3PolCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("n1st_pod_atd", getN1stPodAtd());
		this.hashColumns.put("pre_vvd", getPreVvd());
		this.hashColumns.put("pre1_pod_cd", getPre1PodCd());
		this.hashColumns.put("post4_vvd", getPost4Vvd());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("cstms_decl", getCstmsDecl());
		this.hashColumns.put("act_tot_wgt", getActTotWgt());
		this.hashColumns.put("ib_xch_rt_dt", getIbXchRtDt());
		this.hashColumns.put("nt_meas_qty", getNtMeasQty());
		this.hashColumns.put("ib_ctrl_ofc", getIbCtrlOfc());
		this.hashColumns.put("hbl_no", getHblNo());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("col_curr_cd", getColCurrCd());
		this.hashColumns.put("tare_wgt", getTareWgt());
		this.hashColumns.put("cct_ttl_amt", getCctTtlAmt());
		this.hashColumns.put("ff_cntc_pson_nm", getFfCntcPsonNm());
		this.hashColumns.put("an_cust_nm", getAnCustNm());
		this.hashColumns.put("ibd_trsp_tp_cd", getIbdTrspTpCd());
		this.hashColumns.put("ibd_trsp_no", getIbdTrspNo());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("final_pod_eta", getFinalPodEta());
		this.hashColumns.put("del_cnt_cd", getDelCntCd());
		this.hashColumns.put("cstms_sys_rdy", getCstmsSysRdy());
		this.hashColumns.put("trunk_slan_cd", getTrunkSlanCd());
		this.hashColumns.put("final_pod_etd", getFinalPodEtd());
		this.hashColumns.put("bkg_iss_ofc_cd", getBkgIssOfcCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("tvvd", getTvvd());
		this.hashColumns.put("bl_vvd", getBlVvd());
		this.hashColumns.put("rd_term", getRdTerm());
		this.hashColumns.put("rlse_sts_cd", getRlseStsCd());
		this.hashColumns.put("por_nm", getPorNm());
		this.hashColumns.put("traf_mod", getTrafMod());
		this.hashColumns.put("pre3_vvd", getPre3Vvd());
		this.hashColumns.put("n3rd_ntfy_pty", getN3rdNtfyPty());
		this.hashColumns.put("post3_vvd", getPost3Vvd());
		this.hashColumns.put("bl_obrd_dt", getBlObrdDt());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("trunk_pod_ata", getTrunkPodAta());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("si_dt", getSiDt());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("org_trns_svc_mod_cd", getOrgTrnsSvcModCd());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("first_pol_cutoff_dt", getFirstPolCutoffDt());
		this.hashColumns.put("pre_curr_cd", getPreCurrCd());
		this.hashColumns.put("trunk_vvd", getTrunkVvd());
		this.hashColumns.put("n1st_pod", getN1stPod());
		this.hashColumns.put("nvocc_co_scac_cd", getNvoccCoScacCd());
		this.hashColumns.put("pol_etd", getPolEtd());
		this.hashColumns.put("crd", getCrd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("obl_inet_flg", getOblInetFlg());
		this.hashColumns.put("ff_cust_nm", getFfCustNm());
		this.hashColumns.put("last_vsl", getLastVsl());
		this.hashColumns.put("sum_wgt_ton", getSumWgtTon());
		this.hashColumns.put("sh_cntc_num", getShCntcNum());
		this.hashColumns.put("trunk_vsl_nm", getTrunkVslNm());
		this.hashColumns.put("kr_cstms_cust_tp_cd", getKrCstmsCustTpCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("crn", getCrn());
		this.hashColumns.put("pre_vsl", getPreVsl());
		this.hashColumns.put("pre2_vvd", getPre2Vvd());
		this.hashColumns.put("por_cnt_cd", getPorCntCd());
		this.hashColumns.put("mvmt_ref_no", getMvmtRefNo());
		this.hashColumns.put("final_pol_etd", getFinalPolEtd());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("final_pol_eta", getFinalPolEta());
		this.hashColumns.put("st_cmdt_nm", getStCmdtNm());
		this.hashColumns.put("fw_cntc_num", getFwCntcNum());
		this.hashColumns.put("pre2_pod_cd", getPre2PodCd());
		this.hashColumns.put("n1st_pol_eta", getN1stPolEta());
		this.hashColumns.put("n1st_pol_etb", getN1stPolEtb());
		this.hashColumns.put("sum_ppd_amt", getSumPpdAmt());
		this.hashColumns.put("n1st_pol_etd", getN1stPolEtd());
		this.hashColumns.put("cgo_rlse_sts", getCgoRlseSts());
		this.hashColumns.put("del_eta", getDelEta());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("scac_nm", getScacNm());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("sum_cct_amt", getSumCctAmt());
		this.hashColumns.put("nt_meas_ut_cd", getNtMeasUtCd());
		this.hashColumns.put("pre1_pol_cd", getPre1PolCd());
		this.hashColumns.put("cntr_tp", getCntrTp());
		this.hashColumns.put("post2_vvd", getPost2Vvd());
		this.hashColumns.put("bl_prt_dt", getBlPrtDt());
		this.hashColumns.put("pre4_vvd", getPre4Vvd());
		this.hashColumns.put("sum_net_wgt_kgs", getSumNetWgtKgs());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("pod_etb", getPodEtb());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("del_ata", "delAta");
		this.hashFields.put("sum_wgt_lbs", "sumWgtLbs");
		this.hashFields.put("trunk_pol_ata", "trunkPolAta");
		this.hashFields.put("obl_iss_dt", "oblIssDt");
		this.hashFields.put("cntr_sz", "cntrSz");
		this.hashFields.put("srd_ofc", "srdOfc");
		this.hashFields.put("cnt_cntr", "cntCntr");
		this.hashFields.put("xpt_lic_no", "xptLicNo");
		this.hashFields.put("hamo_cd_desc", "hamoCdDesc");
		this.hashFields.put("post_vsl", "postVsl");
		this.hashFields.put("hlg_tp", "hlgTp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("dest_trns_svc_mod_cd", "destTrnsSvcModCd");
		this.hashFields.put("ib_frh_flg", "ibFrhFlg");
		this.hashFields.put("cpt_ttl_amt", "cptTtlAmt");
		this.hashFields.put("grs_wgt_ut_cd", "grsWgtUtCd");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("ex_mvmt_ref_no", "exMvmtRefNo");
		this.hashFields.put("capt_ofc", "captOfc");
		this.hashFields.put("pod_ata_ic_dt", "podAtaIcDt");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		this.hashFields.put("cstms_usr_rdy", "cstmsUsrRdy");
		this.hashFields.put("cstms_req", "cstmsReq");
		this.hashFields.put("last_pod", "lastPod");
		this.hashFields.put("ob_xch_rt_dt", "obXchRtDt");
		this.hashFields.put("sum_grs_wgt_kgs", "sumGrsWgtKgs");
		this.hashFields.put("final_dest_nm", "finalDestNm");
		this.hashFields.put("troi", "troi");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("srd_dt", "srdDt");
		this.hashFields.put("vvd_2", "vvd2");
		this.hashFields.put("vvd_3", "vvd3");
		this.hashFields.put("cnt_bl", "cntBl");
		this.hashFields.put("post1_vvd", "post1Vvd");
		this.hashFields.put("vvd_1", "vvd1");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sh_cust_nm", "shCustNm");
		this.hashFields.put("vvd_4", "vvd4");
		this.hashFields.put("trunk_pol_eta", "trunkPolEta");
		this.hashFields.put("last_vvd", "lastVvd");
		this.hashFields.put("sum_net_mea_cbm", "sumNetMeaCbm");
		this.hashFields.put("last_pod_etb", "lastPodEtb");
		this.hashFields.put("n1st_pod_eta", "n1stPodEta");
		this.hashFields.put("pre3_pod_cd", "pre3PodCd");
		this.hashFields.put("last_pod_eta", "lastPodEta");
		this.hashFields.put("n1st_pod_etd", "n1stPodEtd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("cntr_sts", "cntrSts");
		this.hashFields.put("nt_wgt_qty", "ntWgtQty");
		this.hashFields.put("dis_last_vvd", "disLastVvd");
		this.hashFields.put("scac_cd", "scacCd");
		this.hashFields.put("trunk_pod_cd", "trunkPodCd");
		this.hashFields.put("ob_sls_rgn_cd", "obSlsRgnCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("pre2_pol_cd", "pre2PolCd");
		this.hashFields.put("nf_cust_nm", "nfCustNm");
		this.hashFields.put("post_vvd", "postVvd");
		this.hashFields.put("sum_grs_mea_cbm", "sumGrsMeaCbm");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("last_pod_ata", "lastPodAta");
		this.hashFields.put("del_nm", "delNm");
		this.hashFields.put("pre4_pol_cd", "pre4PolCd");
		this.hashFields.put("trunk_pod_etd", "trunkPodEtd");
		this.hashFields.put("bl_slan_cd", "blSlanCd");
		this.hashFields.put("trunk_pod_eta", "trunkPodEta");
		this.hashFields.put("obl_rlse_flg", "oblRlseFlg");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("trunk_vsl", "trunkVsl");
		this.hashFields.put("sh_cntc_pson_nm", "shCntcPsonNm");
		this.hashFields.put("cn_cust_nm", "cnCustNm");
		this.hashFields.put("cnt_bkg", "cntBkg");
		this.hashFields.put("clr_by", "clrBy");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cnt_pck", "cntPck");
		this.hashFields.put("obl_inet_prn_dt", "oblInetPrnDt");
		this.hashFields.put("trunk_pol_cd", "trunkPolCd");
		this.hashFields.put("ts_port2", "tsPort2");
		this.hashFields.put("ts_port3", "tsPort3");
		this.hashFields.put("pre1_vvd", "pre1Vvd");
		this.hashFields.put("first_vsl", "firstVsl");
		this.hashFields.put("cgo_nature", "cgoNature");
		this.hashFields.put("ts_port1", "tsPort1");
		this.hashFields.put("pol_nm", "polNm");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("nt_wgt_ut_cd", "ntWgtUtCd");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("pre4_pod_cd", "pre4PodCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ob_vvd_1", "obVvd1");
		this.hashFields.put("trf_cd", "trfCd");
		this.hashFields.put("pre3_pol_cd", "pre3PolCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("n1st_pod_atd", "n1stPodAtd");
		this.hashFields.put("pre_vvd", "preVvd");
		this.hashFields.put("pre1_pod_cd", "pre1PodCd");
		this.hashFields.put("post4_vvd", "post4Vvd");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("cstms_decl", "cstmsDecl");
		this.hashFields.put("act_tot_wgt", "actTotWgt");
		this.hashFields.put("ib_xch_rt_dt", "ibXchRtDt");
		this.hashFields.put("nt_meas_qty", "ntMeasQty");
		this.hashFields.put("ib_ctrl_ofc", "ibCtrlOfc");
		this.hashFields.put("hbl_no", "hblNo");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("col_curr_cd", "colCurrCd");
		this.hashFields.put("tare_wgt", "tareWgt");
		this.hashFields.put("cct_ttl_amt", "cctTtlAmt");
		this.hashFields.put("ff_cntc_pson_nm", "ffCntcPsonNm");
		this.hashFields.put("an_cust_nm", "anCustNm");
		this.hashFields.put("ibd_trsp_tp_cd", "ibdTrspTpCd");
		this.hashFields.put("ibd_trsp_no", "ibdTrspNo");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("final_pod_eta", "finalPodEta");
		this.hashFields.put("del_cnt_cd", "delCntCd");
		this.hashFields.put("cstms_sys_rdy", "cstmsSysRdy");
		this.hashFields.put("trunk_slan_cd", "trunkSlanCd");
		this.hashFields.put("final_pod_etd", "finalPodEtd");
		this.hashFields.put("bkg_iss_ofc_cd", "bkgIssOfcCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("bl_vvd", "blVvd");
		this.hashFields.put("rd_term", "rdTerm");
		this.hashFields.put("rlse_sts_cd", "rlseStsCd");
		this.hashFields.put("por_nm", "porNm");
		this.hashFields.put("traf_mod", "trafMod");
		this.hashFields.put("pre3_vvd", "pre3Vvd");
		this.hashFields.put("n3rd_ntfy_pty", "n3rdNtfyPty");
		this.hashFields.put("post3_vvd", "post3Vvd");
		this.hashFields.put("bl_obrd_dt", "blObrdDt");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("trunk_pod_ata", "trunkPodAta");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("si_dt", "siDt");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("org_trns_svc_mod_cd", "orgTrnsSvcModCd");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("first_pol_cutoff_dt", "firstPolCutoffDt");
		this.hashFields.put("pre_curr_cd", "preCurrCd");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		this.hashFields.put("n1st_pod", "n1stPod");
		this.hashFields.put("nvocc_co_scac_cd", "nvoccCoScacCd");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("crd", "crd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("obl_inet_flg", "oblInetFlg");
		this.hashFields.put("ff_cust_nm", "ffCustNm");
		this.hashFields.put("last_vsl", "lastVsl");
		this.hashFields.put("sum_wgt_ton", "sumWgtTon");
		this.hashFields.put("sh_cntc_num", "shCntcNum");
		this.hashFields.put("trunk_vsl_nm", "trunkVslNm");
		this.hashFields.put("kr_cstms_cust_tp_cd", "krCstmsCustTpCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("crn", "crn");
		this.hashFields.put("pre_vsl", "preVsl");
		this.hashFields.put("pre2_vvd", "pre2Vvd");
		this.hashFields.put("por_cnt_cd", "porCntCd");
		this.hashFields.put("mvmt_ref_no", "mvmtRefNo");
		this.hashFields.put("final_pol_etd", "finalPolEtd");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("final_pol_eta", "finalPolEta");
		this.hashFields.put("st_cmdt_nm", "stCmdtNm");
		this.hashFields.put("fw_cntc_num", "fwCntcNum");
		this.hashFields.put("pre2_pod_cd", "pre2PodCd");
		this.hashFields.put("n1st_pol_eta", "n1stPolEta");
		this.hashFields.put("n1st_pol_etb", "n1stPolEtb");
		this.hashFields.put("sum_ppd_amt", "sumPpdAmt");
		this.hashFields.put("n1st_pol_etd", "n1stPolEtd");
		this.hashFields.put("cgo_rlse_sts", "cgoRlseSts");
		this.hashFields.put("del_eta", "delEta");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("scac_nm", "scacNm");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("sum_cct_amt", "sumCctAmt");
		this.hashFields.put("nt_meas_ut_cd", "ntMeasUtCd");
		this.hashFields.put("pre1_pol_cd", "pre1PolCd");
		this.hashFields.put("cntr_tp", "cntrTp");
		this.hashFields.put("post2_vvd", "post2Vvd");
		this.hashFields.put("bl_prt_dt", "blPrtDt");
		this.hashFields.put("pre4_vvd", "pre4Vvd");
		this.hashFields.put("sum_net_wgt_kgs", "sumNetWgtKgs");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("pod_etb", "podEtb");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return delAta
	 */
	public String getDelAta() {
		return this.delAta;
	}
	
	/**
	 * Column Info
	 * @return sumWgtLbs
	 */
	public String getSumWgtLbs() {
		return this.sumWgtLbs;
	}
	
	/**
	 * Column Info
	 * @return trunkPolAta
	 */
	public String getTrunkPolAta() {
		return this.trunkPolAta;
	}
	
	/**
	 * Column Info
	 * @return oblIssDt
	 */
	public String getOblIssDt() {
		return this.oblIssDt;
	}
	
	/**
	 * Column Info
	 * @return cntrSz
	 */
	public String getCntrSz() {
		return this.cntrSz;
	}
	
	/**
	 * Column Info
	 * @return srdOfc
	 */
	public String getSrdOfc() {
		return this.srdOfc;
	}
	
	/**
	 * Column Info
	 * @return cntCntr
	 */
	public String getCntCntr() {
		return this.cntCntr;
	}
	
	/**
	 * Column Info
	 * @return xptLicNo
	 */
	public String getXptLicNo() {
		return this.xptLicNo;
	}
	
	/**
	 * Column Info
	 * @return hamoCdDesc
	 */
	public String getHamoCdDesc() {
		return this.hamoCdDesc;
	}
	
	/**
	 * Column Info
	 * @return postVsl
	 */
	public String getPostVsl() {
		return this.postVsl;
	}
	
	/**
	 * Column Info
	 * @return hlgTp
	 */
	public String getHlgTp() {
		return this.hlgTp;
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
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
	}
	
	/**
	 * Column Info
	 * @return destTrnsSvcModCd
	 */
	public String getDestTrnsSvcModCd() {
		return this.destTrnsSvcModCd;
	}
	
	/**
	 * Column Info
	 * @return ibFrhFlg
	 */
	public String getIbFrhFlg() {
		return this.ibFrhFlg;
	}
	
	/**
	 * Column Info
	 * @return cptTtlAmt
	 */
	public String getCptTtlAmt() {
		return this.cptTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return grsWgtUtCd
	 */
	public String getGrsWgtUtCd() {
		return this.grsWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtHsCd
	 */
	public String getCmdtHsCd() {
		return this.cmdtHsCd;
	}
	
	/**
	 * Column Info
	 * @return exMvmtRefNo
	 */
	public String getExMvmtRefNo() {
		return this.exMvmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return captOfc
	 */
	public String getCaptOfc() {
		return this.captOfc;
	}
	
	/**
	 * Column Info
	 * @return podAtaIcDt
	 */
	public String getPodAtaIcDt() {
		return this.podAtaIcDt;
	}
	
	/**
	 * Column Info
	 * @return oblIssOfcCd
	 */
	public String getOblIssOfcCd() {
		return this.oblIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsUsrRdy
	 */
	public String getCstmsUsrRdy() {
		return this.cstmsUsrRdy;
	}
	
	/**
	 * Column Info
	 * @return cstmsReq
	 */
	public String getCstmsReq() {
		return this.cstmsReq;
	}
	
	/**
	 * Column Info
	 * @return lastPod
	 */
	public String getLastPod() {
		return this.lastPod;
	}
	
	/**
	 * Column Info
	 * @return obXchRtDt
	 */
	public String getObXchRtDt() {
		return this.obXchRtDt;
	}
	
	/**
	 * Column Info
	 * @return sumGrsWgtKgs
	 */
	public String getSumGrsWgtKgs() {
		return this.sumGrsWgtKgs;
	}
	
	/**
	 * Column Info
	 * @return finalDestNm
	 */
	public String getFinalDestNm() {
		return this.finalDestNm;
	}
	
	/**
	 * Column Info
	 * @return troi
	 */
	public String getTroi() {
		return this.troi;
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
	 * @return srdDt
	 */
	public String getSrdDt() {
		return this.srdDt;
	}
	
	/**
	 * Column Info
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
	}
	
	/**
	 * Column Info
	 * @return vvd3
	 */
	public String getVvd3() {
		return this.vvd3;
	}
	
	/**
	 * Column Info
	 * @return cntBl
	 */
	public String getCntBl() {
		return this.cntBl;
	}
	
	/**
	 * Column Info
	 * @return post1Vvd
	 */
	public String getPost1Vvd() {
		return this.post1Vvd;
	}
	
	/**
	 * Column Info
	 * @return vvd1
	 */
	public String getVvd1() {
		return this.vvd1;
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
	 * @return shCustNm
	 */
	public String getShCustNm() {
		return this.shCustNm;
	}
	
	/**
	 * Column Info
	 * @return vvd4
	 */
	public String getVvd4() {
		return this.vvd4;
	}
	
	/**
	 * Column Info
	 * @return trunkPolEta
	 */
	public String getTrunkPolEta() {
		return this.trunkPolEta;
	}
	
	/**
	 * Column Info
	 * @return lastVvd
	 */
	public String getLastVvd() {
		return this.lastVvd;
	}
	
	/**
	 * Column Info
	 * @return sumNetMeaCbm
	 */
	public String getSumNetMeaCbm() {
		return this.sumNetMeaCbm;
	}
	
	/**
	 * Column Info
	 * @return lastPodEtb
	 */
	public String getLastPodEtb() {
		return this.lastPodEtb;
	}
	
	/**
	 * Column Info
	 * @return n1stPodEta
	 */
	public String getN1stPodEta() {
		return this.n1stPodEta;
	}
	
	/**
	 * Column Info
	 * @return pre3PodCd
	 */
	public String getPre3PodCd() {
		return this.pre3PodCd;
	}
	
	/**
	 * Column Info
	 * @return lastPodEta
	 */
	public String getLastPodEta() {
		return this.lastPodEta;
	}
	
	/**
	 * Column Info
	 * @return n1stPodEtd
	 */
	public String getN1stPodEtd() {
		return this.n1stPodEtd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return cntrSts
	 */
	public String getCntrSts() {
		return this.cntrSts;
	}
	
	/**
	 * Column Info
	 * @return ntWgtQty
	 */
	public String getNtWgtQty() {
		return this.ntWgtQty;
	}
	
	/**
	 * Column Info
	 * @return disLastVvd
	 */
	public String getDisLastVvd() {
		return this.disLastVvd;
	}
	
	/**
	 * Column Info
	 * @return scacCd
	 */
	public String getScacCd() {
		return this.scacCd;
	}
	
	/**
	 * Column Info
	 * @return trunkPodCd
	 */
	public String getTrunkPodCd() {
		return this.trunkPodCd;
	}
	
	/**
	 * Column Info
	 * @return obSlsRgnCd
	 */
	public String getObSlsRgnCd() {
		return this.obSlsRgnCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return pre2PolCd
	 */
	public String getPre2PolCd() {
		return this.pre2PolCd;
	}
	
	/**
	 * Column Info
	 * @return nfCustNm
	 */
	public String getNfCustNm() {
		return this.nfCustNm;
	}
	
	/**
	 * Column Info
	 * @return postVvd
	 */
	public String getPostVvd() {
		return this.postVvd;
	}
	
	/**
	 * Column Info
	 * @return sumGrsMeaCbm
	 */
	public String getSumGrsMeaCbm() {
		return this.sumGrsMeaCbm;
	}
	
	/**
	 * Column Info
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}
	
	/**
	 * Column Info
	 * @return lastPodAta
	 */
	public String getLastPodAta() {
		return this.lastPodAta;
	}
	
	/**
	 * Column Info
	 * @return delNm
	 */
	public String getDelNm() {
		return this.delNm;
	}
	
	/**
	 * Column Info
	 * @return pre4PolCd
	 */
	public String getPre4PolCd() {
		return this.pre4PolCd;
	}
	
	/**
	 * Column Info
	 * @return trunkPodEtd
	 */
	public String getTrunkPodEtd() {
		return this.trunkPodEtd;
	}
	
	/**
	 * Column Info
	 * @return blSlanCd
	 */
	public String getBlSlanCd() {
		return this.blSlanCd;
	}
	
	/**
	 * Column Info
	 * @return trunkPodEta
	 */
	public String getTrunkPodEta() {
		return this.trunkPodEta;
	}
	
	/**
	 * Column Info
	 * @return oblRlseFlg
	 */
	public String getOblRlseFlg() {
		return this.oblRlseFlg;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return trunkVsl
	 */
	public String getTrunkVsl() {
		return this.trunkVsl;
	}
	
	/**
	 * Column Info
	 * @return shCntcPsonNm
	 */
	public String getShCntcPsonNm() {
		return this.shCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return cnCustNm
	 */
	public String getCnCustNm() {
		return this.cnCustNm;
	}
	
	/**
	 * Column Info
	 * @return cntBkg
	 */
	public String getCntBkg() {
		return this.cntBkg;
	}
	
	/**
	 * Column Info
	 * @return clrBy
	 */
	public String getClrBy() {
		return this.clrBy;
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
	 * @return cntPck
	 */
	public String getCntPck() {
		return this.cntPck;
	}
	
	/**
	 * Column Info
	 * @return oblInetPrnDt
	 */
	public String getOblInetPrnDt() {
		return this.oblInetPrnDt;
	}
	
	/**
	 * Column Info
	 * @return trunkPolCd
	 */
	public String getTrunkPolCd() {
		return this.trunkPolCd;
	}
	
	/**
	 * Column Info
	 * @return tsPort2
	 */
	public String getTsPort2() {
		return this.tsPort2;
	}
	
	/**
	 * Column Info
	 * @return tsPort3
	 */
	public String getTsPort3() {
		return this.tsPort3;
	}
	
	/**
	 * Column Info
	 * @return pre1Vvd
	 */
	public String getPre1Vvd() {
		return this.pre1Vvd;
	}
	
	/**
	 * Column Info
	 * @return firstVsl
	 */
	public String getFirstVsl() {
		return this.firstVsl;
	}
	
	/**
	 * Column Info
	 * @return cgoNature
	 */
	public String getCgoNature() {
		return this.cgoNature;
	}
	
	/**
	 * Column Info
	 * @return tsPort1
	 */
	public String getTsPort1() {
		return this.tsPort1;
	}
	
	/**
	 * Column Info
	 * @return polNm
	 */
	public String getPolNm() {
		return this.polNm;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return ntWgtUtCd
	 */
	public String getNtWgtUtCd() {
		return this.ntWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return blckStwgCd
	 */
	public String getBlckStwgCd() {
		return this.blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @return pre4PodCd
	 */
	public String getPre4PodCd() {
		return this.pre4PodCd;
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
	 * @return obVvd1
	 */
	public String getObVvd1() {
		return this.obVvd1;
	}
	
	/**
	 * Column Info
	 * @return trfCd
	 */
	public String getTrfCd() {
		return this.trfCd;
	}
	
	/**
	 * Column Info
	 * @return pre3PolCd
	 */
	public String getPre3PolCd() {
		return this.pre3PolCd;
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
	 * @return n1stPodAtd
	 */
	public String getN1stPodAtd() {
		return this.n1stPodAtd;
	}
	
	/**
	 * Column Info
	 * @return preVvd
	 */
	public String getPreVvd() {
		return this.preVvd;
	}
	
	/**
	 * Column Info
	 * @return pre1PodCd
	 */
	public String getPre1PodCd() {
		return this.pre1PodCd;
	}
	
	/**
	 * Column Info
	 * @return post4Vvd
	 */
	public String getPost4Vvd() {
		return this.post4Vvd;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return cstmsDecl
	 */
	public String getCstmsDecl() {
		return this.cstmsDecl;
	}
	
	/**
	 * Column Info
	 * @return actTotWgt
	 */
	public String getActTotWgt() {
		return this.actTotWgt;
	}
	
	/**
	 * Column Info
	 * @return ibXchRtDt
	 */
	public String getIbXchRtDt() {
		return this.ibXchRtDt;
	}
	
	/**
	 * Column Info
	 * @return ntMeasQty
	 */
	public String getNtMeasQty() {
		return this.ntMeasQty;
	}
	
	/**
	 * Column Info
	 * @return ibCtrlOfc
	 */
	public String getIbCtrlOfc() {
		return this.ibCtrlOfc;
	}
	
	/**
	 * Column Info
	 * @return hblNo
	 */
	public String getHblNo() {
		return this.hblNo;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return colCurrCd
	 */
	public String getColCurrCd() {
		return this.colCurrCd;
	}
	
	/**
	 * Column Info
	 * @return tareWgt
	 */
	public String getTareWgt() {
		return this.tareWgt;
	}
	
	/**
	 * Column Info
	 * @return cctTtlAmt
	 */
	public String getCctTtlAmt() {
		return this.cctTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return ffCntcPsonNm
	 */
	public String getFfCntcPsonNm() {
		return this.ffCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return anCustNm
	 */
	public String getAnCustNm() {
		return this.anCustNm;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspTpCd
	 */
	public String getIbdTrspTpCd() {
		return this.ibdTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspNo
	 */
	public String getIbdTrspNo() {
		return this.ibdTrspNo;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return finalPodEta
	 */
	public String getFinalPodEta() {
		return this.finalPodEta;
	}
	
	/**
	 * Column Info
	 * @return delCntCd
	 */
	public String getDelCntCd() {
		return this.delCntCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsSysRdy
	 */
	public String getCstmsSysRdy() {
		return this.cstmsSysRdy;
	}
	
	/**
	 * Column Info
	 * @return trunkSlanCd
	 */
	public String getTrunkSlanCd() {
		return this.trunkSlanCd;
	}
	
	/**
	 * Column Info
	 * @return finalPodEtd
	 */
	public String getFinalPodEtd() {
		return this.finalPodEtd;
	}
	
	/**
	 * Column Info
	 * @return bkgIssOfcCd
	 */
	public String getBkgIssOfcCd() {
		return this.bkgIssOfcCd;
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
	 * @return tvvd
	 */
	public String getTvvd() {
		return this.tvvd;
	}
	
	/**
	 * Column Info
	 * @return blVvd
	 */
	public String getBlVvd() {
		return this.blVvd;
	}
	
	/**
	 * Column Info
	 * @return rdTerm
	 */
	public String getRdTerm() {
		return this.rdTerm;
	}
	
	/**
	 * Column Info
	 * @return rlseStsCd
	 */
	public String getRlseStsCd() {
		return this.rlseStsCd;
	}
	
	/**
	 * Column Info
	 * @return porNm
	 */
	public String getPorNm() {
		return this.porNm;
	}
	
	/**
	 * Column Info
	 * @return trafMod
	 */
	public String getTrafMod() {
		return this.trafMod;
	}
	
	/**
	 * Column Info
	 * @return pre3Vvd
	 */
	public String getPre3Vvd() {
		return this.pre3Vvd;
	}
	
	/**
	 * Column Info
	 * @return n3rdNtfyPty
	 */
	public String getN3rdNtfyPty() {
		return this.n3rdNtfyPty;
	}
	
	/**
	 * Column Info
	 * @return post3Vvd
	 */
	public String getPost3Vvd() {
		return this.post3Vvd;
	}
	
	/**
	 * Column Info
	 * @return blObrdDt
	 */
	public String getBlObrdDt() {
		return this.blObrdDt;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return trunkPodAta
	 */
	public String getTrunkPodAta() {
		return this.trunkPodAta;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
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
	 * @return siDt
	 */
	public String getSiDt() {
		return this.siDt;
	}
	
	/**
	 * Column Info
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
	}
	
	/**
	 * Column Info
	 * @return orgTrnsSvcModCd
	 */
	public String getOrgTrnsSvcModCd() {
		return this.orgTrnsSvcModCd;
	}
	
	/**
	 * Column Info
	 * @return docUsrId
	 */
	public String getDocUsrId() {
		return this.docUsrId;
	}
	
	/**
	 * Column Info
	 * @return firstPolCutoffDt
	 */
	public String getFirstPolCutoffDt() {
		return this.firstPolCutoffDt;
	}
	
	/**
	 * Column Info
	 * @return preCurrCd
	 */
	public String getPreCurrCd() {
		return this.preCurrCd;
	}
	
	/**
	 * Column Info
	 * @return trunkVvd
	 */
	public String getTrunkVvd() {
		return this.trunkVvd;
	}
	
	/**
	 * Column Info
	 * @return n1stPod
	 */
	public String getN1stPod() {
		return this.n1stPod;
	}
	
	/**
	 * Column Info
	 * @return nvoccCoScacCd
	 */
	public String getNvoccCoScacCd() {
		return this.nvoccCoScacCd;
	}
	
	/**
	 * Column Info
	 * @return polEtd
	 */
	public String getPolEtd() {
		return this.polEtd;
	}
	
	/**
	 * Column Info
	 * @return crd
	 */
	public String getCrd() {
		return this.crd;
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
	 * @return oblInetFlg
	 */
	public String getOblInetFlg() {
		return this.oblInetFlg;
	}
	
	/**
	 * Column Info
	 * @return ffCustNm
	 */
	public String getFfCustNm() {
		return this.ffCustNm;
	}
	
	/**
	 * Column Info
	 * @return lastVsl
	 */
	public String getLastVsl() {
		return this.lastVsl;
	}
	
	/**
	 * Column Info
	 * @return sumWgtTon
	 */
	public String getSumWgtTon() {
		return this.sumWgtTon;
	}
	
	/**
	 * Column Info
	 * @return shCntcNum
	 */
	public String getShCntcNum() {
		return this.shCntcNum;
	}
	
	/**
	 * Column Info
	 * @return trunkVslNm
	 */
	public String getTrunkVslNm() {
		return this.trunkVslNm;
	}
	
	/**
	 * Column Info
	 * @return krCstmsCustTpCd
	 */
	public String getKrCstmsCustTpCd() {
		return this.krCstmsCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return crn
	 */
	public String getCrn() {
		return this.crn;
	}
	
	/**
	 * Column Info
	 * @return preVsl
	 */
	public String getPreVsl() {
		return this.preVsl;
	}
	
	/**
	 * Column Info
	 * @return pre2Vvd
	 */
	public String getPre2Vvd() {
		return this.pre2Vvd;
	}
	
	/**
	 * Column Info
	 * @return porCntCd
	 */
	public String getPorCntCd() {
		return this.porCntCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtRefNo
	 */
	public String getMvmtRefNo() {
		return this.mvmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return finalPolEtd
	 */
	public String getFinalPolEtd() {
		return this.finalPolEtd;
	}
	
	/**
	 * Column Info
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @return finalPolEta
	 */
	public String getFinalPolEta() {
		return this.finalPolEta;
	}
	
	/**
	 * Column Info
	 * @return stCmdtNm
	 */
	public String getStCmdtNm() {
		return this.stCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return fwCntcNum
	 */
	public String getFwCntcNum() {
		return this.fwCntcNum;
	}
	
	/**
	 * Column Info
	 * @return pre2PodCd
	 */
	public String getPre2PodCd() {
		return this.pre2PodCd;
	}
	
	/**
	 * Column Info
	 * @return n1stPolEta
	 */
	public String getN1stPolEta() {
		return this.n1stPolEta;
	}
	
	/**
	 * Column Info
	 * @return n1stPolEtb
	 */
	public String getN1stPolEtb() {
		return this.n1stPolEtb;
	}
	
	/**
	 * Column Info
	 * @return sumPpdAmt
	 */
	public String getSumPpdAmt() {
		return this.sumPpdAmt;
	}
	
	/**
	 * Column Info
	 * @return n1stPolEtd
	 */
	public String getN1stPolEtd() {
		return this.n1stPolEtd;
	}
	
	/**
	 * Column Info
	 * @return cgoRlseSts
	 */
	public String getCgoRlseSts() {
		return this.cgoRlseSts;
	}
	
	/**
	 * Column Info
	 * @return delEta
	 */
	public String getDelEta() {
		return this.delEta;
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
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return scacNm
	 */
	public String getScacNm() {
		return this.scacNm;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Column Info
	 * @return sumCctAmt
	 */
	public String getSumCctAmt() {
		return this.sumCctAmt;
	}
	
	/**
	 * Column Info
	 * @return ntMeasUtCd
	 */
	public String getNtMeasUtCd() {
		return this.ntMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return pre1PolCd
	 */
	public String getPre1PolCd() {
		return this.pre1PolCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTp
	 */
	public String getCntrTp() {
		return this.cntrTp;
	}
	
	/**
	 * Column Info
	 * @return post2Vvd
	 */
	public String getPost2Vvd() {
		return this.post2Vvd;
	}
	
	/**
	 * Column Info
	 * @return blPrtDt
	 */
	public String getBlPrtDt() {
		return this.blPrtDt;
	}
	
	/**
	 * Column Info
	 * @return pre4Vvd
	 */
	public String getPre4Vvd() {
		return this.pre4Vvd;
	}
	
	/**
	 * Column Info
	 * @return sumNetWgtKgs
	 */
	public String getSumNetWgtKgs() {
		return this.sumNetWgtKgs;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return podEtb
	 */
	public String getPodEtb() {
		return this.podEtb;
	}
	

	/**
	 * Column Info
	 * @param delAta
	 */
	public void setDelAta(String delAta) {
		this.delAta = delAta;
	}
	
	/**
	 * Column Info
	 * @param sumWgtLbs
	 */
	public void setSumWgtLbs(String sumWgtLbs) {
		this.sumWgtLbs = sumWgtLbs;
	}
	
	/**
	 * Column Info
	 * @param trunkPolAta
	 */
	public void setTrunkPolAta(String trunkPolAta) {
		this.trunkPolAta = trunkPolAta;
	}
	
	/**
	 * Column Info
	 * @param oblIssDt
	 */
	public void setOblIssDt(String oblIssDt) {
		this.oblIssDt = oblIssDt;
	}
	
	/**
	 * Column Info
	 * @param cntrSz
	 */
	public void setCntrSz(String cntrSz) {
		this.cntrSz = cntrSz;
	}
	
	/**
	 * Column Info
	 * @param srdOfc
	 */
	public void setSrdOfc(String srdOfc) {
		this.srdOfc = srdOfc;
	}
	
	/**
	 * Column Info
	 * @param cntCntr
	 */
	public void setCntCntr(String cntCntr) {
		this.cntCntr = cntCntr;
	}
	
	/**
	 * Column Info
	 * @param xptLicNo
	 */
	public void setXptLicNo(String xptLicNo) {
		this.xptLicNo = xptLicNo;
	}
	
	/**
	 * Column Info
	 * @param hamoCdDesc
	 */
	public void setHamoCdDesc(String hamoCdDesc) {
		this.hamoCdDesc = hamoCdDesc;
	}
	
	/**
	 * Column Info
	 * @param postVsl
	 */
	public void setPostVsl(String postVsl) {
		this.postVsl = postVsl;
	}
	
	/**
	 * Column Info
	 * @param hlgTp
	 */
	public void setHlgTp(String hlgTp) {
		this.hlgTp = hlgTp;
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
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
	}
	
	/**
	 * Column Info
	 * @param destTrnsSvcModCd
	 */
	public void setDestTrnsSvcModCd(String destTrnsSvcModCd) {
		this.destTrnsSvcModCd = destTrnsSvcModCd;
	}
	
	/**
	 * Column Info
	 * @param ibFrhFlg
	 */
	public void setIbFrhFlg(String ibFrhFlg) {
		this.ibFrhFlg = ibFrhFlg;
	}
	
	/**
	 * Column Info
	 * @param cptTtlAmt
	 */
	public void setCptTtlAmt(String cptTtlAmt) {
		this.cptTtlAmt = cptTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param grsWgtUtCd
	 */
	public void setGrsWgtUtCd(String grsWgtUtCd) {
		this.grsWgtUtCd = grsWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtHsCd
	 */
	public void setCmdtHsCd(String cmdtHsCd) {
		this.cmdtHsCd = cmdtHsCd;
	}
	
	/**
	 * Column Info
	 * @param exMvmtRefNo
	 */
	public void setExMvmtRefNo(String exMvmtRefNo) {
		this.exMvmtRefNo = exMvmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param captOfc
	 */
	public void setCaptOfc(String captOfc) {
		this.captOfc = captOfc;
	}
	
	/**
	 * Column Info
	 * @param podAtaIcDt
	 */
	public void setPodAtaIcDt(String podAtaIcDt) {
		this.podAtaIcDt = podAtaIcDt;
	}
	
	/**
	 * Column Info
	 * @param oblIssOfcCd
	 */
	public void setOblIssOfcCd(String oblIssOfcCd) {
		this.oblIssOfcCd = oblIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsUsrRdy
	 */
	public void setCstmsUsrRdy(String cstmsUsrRdy) {
		this.cstmsUsrRdy = cstmsUsrRdy;
	}
	
	/**
	 * Column Info
	 * @param cstmsReq
	 */
	public void setCstmsReq(String cstmsReq) {
		this.cstmsReq = cstmsReq;
	}
	
	/**
	 * Column Info
	 * @param lastPod
	 */
	public void setLastPod(String lastPod) {
		this.lastPod = lastPod;
	}
	
	/**
	 * Column Info
	 * @param obXchRtDt
	 */
	public void setObXchRtDt(String obXchRtDt) {
		this.obXchRtDt = obXchRtDt;
	}
	
	/**
	 * Column Info
	 * @param sumGrsWgtKgs
	 */
	public void setSumGrsWgtKgs(String sumGrsWgtKgs) {
		this.sumGrsWgtKgs = sumGrsWgtKgs;
	}
	
	/**
	 * Column Info
	 * @param finalDestNm
	 */
	public void setFinalDestNm(String finalDestNm) {
		this.finalDestNm = finalDestNm;
	}
	
	/**
	 * Column Info
	 * @param troi
	 */
	public void setTroi(String troi) {
		this.troi = troi;
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
	 * @param srdDt
	 */
	public void setSrdDt(String srdDt) {
		this.srdDt = srdDt;
	}
	
	/**
	 * Column Info
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}
	
	/**
	 * Column Info
	 * @param vvd3
	 */
	public void setVvd3(String vvd3) {
		this.vvd3 = vvd3;
	}
	
	/**
	 * Column Info
	 * @param cntBl
	 */
	public void setCntBl(String cntBl) {
		this.cntBl = cntBl;
	}
	
	/**
	 * Column Info
	 * @param post1Vvd
	 */
	public void setPost1Vvd(String post1Vvd) {
		this.post1Vvd = post1Vvd;
	}
	
	/**
	 * Column Info
	 * @param vvd1
	 */
	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
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
	 * @param shCustNm
	 */
	public void setShCustNm(String shCustNm) {
		this.shCustNm = shCustNm;
	}
	
	/**
	 * Column Info
	 * @param vvd4
	 */
	public void setVvd4(String vvd4) {
		this.vvd4 = vvd4;
	}
	
	/**
	 * Column Info
	 * @param trunkPolEta
	 */
	public void setTrunkPolEta(String trunkPolEta) {
		this.trunkPolEta = trunkPolEta;
	}
	
	/**
	 * Column Info
	 * @param lastVvd
	 */
	public void setLastVvd(String lastVvd) {
		this.lastVvd = lastVvd;
	}
	
	/**
	 * Column Info
	 * @param sumNetMeaCbm
	 */
	public void setSumNetMeaCbm(String sumNetMeaCbm) {
		this.sumNetMeaCbm = sumNetMeaCbm;
	}
	
	/**
	 * Column Info
	 * @param lastPodEtb
	 */
	public void setLastPodEtb(String lastPodEtb) {
		this.lastPodEtb = lastPodEtb;
	}
	
	/**
	 * Column Info
	 * @param n1stPodEta
	 */
	public void setN1stPodEta(String n1stPodEta) {
		this.n1stPodEta = n1stPodEta;
	}
	
	/**
	 * Column Info
	 * @param pre3PodCd
	 */
	public void setPre3PodCd(String pre3PodCd) {
		this.pre3PodCd = pre3PodCd;
	}
	
	/**
	 * Column Info
	 * @param lastPodEta
	 */
	public void setLastPodEta(String lastPodEta) {
		this.lastPodEta = lastPodEta;
	}
	
	/**
	 * Column Info
	 * @param n1stPodEtd
	 */
	public void setN1stPodEtd(String n1stPodEtd) {
		this.n1stPodEtd = n1stPodEtd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param cntrSts
	 */
	public void setCntrSts(String cntrSts) {
		this.cntrSts = cntrSts;
	}
	
	/**
	 * Column Info
	 * @param ntWgtQty
	 */
	public void setNtWgtQty(String ntWgtQty) {
		this.ntWgtQty = ntWgtQty;
	}
	
	/**
	 * Column Info
	 * @param disLastVvd
	 */
	public void setDisLastVvd(String disLastVvd) {
		this.disLastVvd = disLastVvd;
	}
	
	/**
	 * Column Info
	 * @param scacCd
	 */
	public void setScacCd(String scacCd) {
		this.scacCd = scacCd;
	}
	
	/**
	 * Column Info
	 * @param trunkPodCd
	 */
	public void setTrunkPodCd(String trunkPodCd) {
		this.trunkPodCd = trunkPodCd;
	}
	
	/**
	 * Column Info
	 * @param obSlsRgnCd
	 */
	public void setObSlsRgnCd(String obSlsRgnCd) {
		this.obSlsRgnCd = obSlsRgnCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param pre2PolCd
	 */
	public void setPre2PolCd(String pre2PolCd) {
		this.pre2PolCd = pre2PolCd;
	}
	
	/**
	 * Column Info
	 * @param nfCustNm
	 */
	public void setNfCustNm(String nfCustNm) {
		this.nfCustNm = nfCustNm;
	}
	
	/**
	 * Column Info
	 * @param postVvd
	 */
	public void setPostVvd(String postVvd) {
		this.postVvd = postVvd;
	}
	
	/**
	 * Column Info
	 * @param sumGrsMeaCbm
	 */
	public void setSumGrsMeaCbm(String sumGrsMeaCbm) {
		this.sumGrsMeaCbm = sumGrsMeaCbm;
	}
	
	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param lastPodAta
	 */
	public void setLastPodAta(String lastPodAta) {
		this.lastPodAta = lastPodAta;
	}
	
	/**
	 * Column Info
	 * @param delNm
	 */
	public void setDelNm(String delNm) {
		this.delNm = delNm;
	}
	
	/**
	 * Column Info
	 * @param pre4PolCd
	 */
	public void setPre4PolCd(String pre4PolCd) {
		this.pre4PolCd = pre4PolCd;
	}
	
	/**
	 * Column Info
	 * @param trunkPodEtd
	 */
	public void setTrunkPodEtd(String trunkPodEtd) {
		this.trunkPodEtd = trunkPodEtd;
	}
	
	/**
	 * Column Info
	 * @param blSlanCd
	 */
	public void setBlSlanCd(String blSlanCd) {
		this.blSlanCd = blSlanCd;
	}
	
	/**
	 * Column Info
	 * @param trunkPodEta
	 */
	public void setTrunkPodEta(String trunkPodEta) {
		this.trunkPodEta = trunkPodEta;
	}
	
	/**
	 * Column Info
	 * @param oblRlseFlg
	 */
	public void setOblRlseFlg(String oblRlseFlg) {
		this.oblRlseFlg = oblRlseFlg;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param trunkVsl
	 */
	public void setTrunkVsl(String trunkVsl) {
		this.trunkVsl = trunkVsl;
	}
	
	/**
	 * Column Info
	 * @param shCntcPsonNm
	 */
	public void setShCntcPsonNm(String shCntcPsonNm) {
		this.shCntcPsonNm = shCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param cnCustNm
	 */
	public void setCnCustNm(String cnCustNm) {
		this.cnCustNm = cnCustNm;
	}
	
	/**
	 * Column Info
	 * @param cntBkg
	 */
	public void setCntBkg(String cntBkg) {
		this.cntBkg = cntBkg;
	}
	
	/**
	 * Column Info
	 * @param clrBy
	 */
	public void setClrBy(String clrBy) {
		this.clrBy = clrBy;
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
	 * @param cntPck
	 */
	public void setCntPck(String cntPck) {
		this.cntPck = cntPck;
	}
	
	/**
	 * Column Info
	 * @param oblInetPrnDt
	 */
	public void setOblInetPrnDt(String oblInetPrnDt) {
		this.oblInetPrnDt = oblInetPrnDt;
	}
	
	/**
	 * Column Info
	 * @param trunkPolCd
	 */
	public void setTrunkPolCd(String trunkPolCd) {
		this.trunkPolCd = trunkPolCd;
	}
	
	/**
	 * Column Info
	 * @param tsPort2
	 */
	public void setTsPort2(String tsPort2) {
		this.tsPort2 = tsPort2;
	}
	
	/**
	 * Column Info
	 * @param tsPort3
	 */
	public void setTsPort3(String tsPort3) {
		this.tsPort3 = tsPort3;
	}
	
	/**
	 * Column Info
	 * @param pre1Vvd
	 */
	public void setPre1Vvd(String pre1Vvd) {
		this.pre1Vvd = pre1Vvd;
	}
	
	/**
	 * Column Info
	 * @param firstVsl
	 */
	public void setFirstVsl(String firstVsl) {
		this.firstVsl = firstVsl;
	}
	
	/**
	 * Column Info
	 * @param cgoNature
	 */
	public void setCgoNature(String cgoNature) {
		this.cgoNature = cgoNature;
	}
	
	/**
	 * Column Info
	 * @param tsPort1
	 */
	public void setTsPort1(String tsPort1) {
		this.tsPort1 = tsPort1;
	}
	
	/**
	 * Column Info
	 * @param polNm
	 */
	public void setPolNm(String polNm) {
		this.polNm = polNm;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param ntWgtUtCd
	 */
	public void setNtWgtUtCd(String ntWgtUtCd) {
		this.ntWgtUtCd = ntWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param blckStwgCd
	 */
	public void setBlckStwgCd(String blckStwgCd) {
		this.blckStwgCd = blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @param pre4PodCd
	 */
	public void setPre4PodCd(String pre4PodCd) {
		this.pre4PodCd = pre4PodCd;
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
	 * @param obVvd1
	 */
	public void setObVvd1(String obVvd1) {
		this.obVvd1 = obVvd1;
	}
	
	/**
	 * Column Info
	 * @param trfCd
	 */
	public void setTrfCd(String trfCd) {
		this.trfCd = trfCd;
	}
	
	/**
	 * Column Info
	 * @param pre3PolCd
	 */
	public void setPre3PolCd(String pre3PolCd) {
		this.pre3PolCd = pre3PolCd;
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
	 * @param n1stPodAtd
	 */
	public void setN1stPodAtd(String n1stPodAtd) {
		this.n1stPodAtd = n1stPodAtd;
	}
	
	/**
	 * Column Info
	 * @param preVvd
	 */
	public void setPreVvd(String preVvd) {
		this.preVvd = preVvd;
	}
	
	/**
	 * Column Info
	 * @param pre1PodCd
	 */
	public void setPre1PodCd(String pre1PodCd) {
		this.pre1PodCd = pre1PodCd;
	}
	
	/**
	 * Column Info
	 * @param post4Vvd
	 */
	public void setPost4Vvd(String post4Vvd) {
		this.post4Vvd = post4Vvd;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param cstmsDecl
	 */
	public void setCstmsDecl(String cstmsDecl) {
		this.cstmsDecl = cstmsDecl;
	}
	
	/**
	 * Column Info
	 * @param actTotWgt
	 */
	public void setActTotWgt(String actTotWgt) {
		this.actTotWgt = actTotWgt;
	}
	
	/**
	 * Column Info
	 * @param ibXchRtDt
	 */
	public void setIbXchRtDt(String ibXchRtDt) {
		this.ibXchRtDt = ibXchRtDt;
	}
	
	/**
	 * Column Info
	 * @param ntMeasQty
	 */
	public void setNtMeasQty(String ntMeasQty) {
		this.ntMeasQty = ntMeasQty;
	}
	
	/**
	 * Column Info
	 * @param ibCtrlOfc
	 */
	public void setIbCtrlOfc(String ibCtrlOfc) {
		this.ibCtrlOfc = ibCtrlOfc;
	}
	
	/**
	 * Column Info
	 * @param hblNo
	 */
	public void setHblNo(String hblNo) {
		this.hblNo = hblNo;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param colCurrCd
	 */
	public void setColCurrCd(String colCurrCd) {
		this.colCurrCd = colCurrCd;
	}
	
	/**
	 * Column Info
	 * @param tareWgt
	 */
	public void setTareWgt(String tareWgt) {
		this.tareWgt = tareWgt;
	}
	
	/**
	 * Column Info
	 * @param cctTtlAmt
	 */
	public void setCctTtlAmt(String cctTtlAmt) {
		this.cctTtlAmt = cctTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param ffCntcPsonNm
	 */
	public void setFfCntcPsonNm(String ffCntcPsonNm) {
		this.ffCntcPsonNm = ffCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param anCustNm
	 */
	public void setAnCustNm(String anCustNm) {
		this.anCustNm = anCustNm;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspTpCd
	 */
	public void setIbdTrspTpCd(String ibdTrspTpCd) {
		this.ibdTrspTpCd = ibdTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspNo
	 */
	public void setIbdTrspNo(String ibdTrspNo) {
		this.ibdTrspNo = ibdTrspNo;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param finalPodEta
	 */
	public void setFinalPodEta(String finalPodEta) {
		this.finalPodEta = finalPodEta;
	}
	
	/**
	 * Column Info
	 * @param delCntCd
	 */
	public void setDelCntCd(String delCntCd) {
		this.delCntCd = delCntCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsSysRdy
	 */
	public void setCstmsSysRdy(String cstmsSysRdy) {
		this.cstmsSysRdy = cstmsSysRdy;
	}
	
	/**
	 * Column Info
	 * @param trunkSlanCd
	 */
	public void setTrunkSlanCd(String trunkSlanCd) {
		this.trunkSlanCd = trunkSlanCd;
	}
	
	/**
	 * Column Info
	 * @param finalPodEtd
	 */
	public void setFinalPodEtd(String finalPodEtd) {
		this.finalPodEtd = finalPodEtd;
	}
	
	/**
	 * Column Info
	 * @param bkgIssOfcCd
	 */
	public void setBkgIssOfcCd(String bkgIssOfcCd) {
		this.bkgIssOfcCd = bkgIssOfcCd;
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
	 * @param tvvd
	 */
	public void setTvvd(String tvvd) {
		this.tvvd = tvvd;
	}
	
	/**
	 * Column Info
	 * @param blVvd
	 */
	public void setBlVvd(String blVvd) {
		this.blVvd = blVvd;
	}
	
	/**
	 * Column Info
	 * @param rdTerm
	 */
	public void setRdTerm(String rdTerm) {
		this.rdTerm = rdTerm;
	}
	
	/**
	 * Column Info
	 * @param rlseStsCd
	 */
	public void setRlseStsCd(String rlseStsCd) {
		this.rlseStsCd = rlseStsCd;
	}
	
	/**
	 * Column Info
	 * @param porNm
	 */
	public void setPorNm(String porNm) {
		this.porNm = porNm;
	}
	
	/**
	 * Column Info
	 * @param trafMod
	 */
	public void setTrafMod(String trafMod) {
		this.trafMod = trafMod;
	}
	
	/**
	 * Column Info
	 * @param pre3Vvd
	 */
	public void setPre3Vvd(String pre3Vvd) {
		this.pre3Vvd = pre3Vvd;
	}
	
	/**
	 * Column Info
	 * @param n3rdNtfyPty
	 */
	public void setN3rdNtfyPty(String n3rdNtfyPty) {
		this.n3rdNtfyPty = n3rdNtfyPty;
	}
	
	/**
	 * Column Info
	 * @param post3Vvd
	 */
	public void setPost3Vvd(String post3Vvd) {
		this.post3Vvd = post3Vvd;
	}
	
	/**
	 * Column Info
	 * @param blObrdDt
	 */
	public void setBlObrdDt(String blObrdDt) {
		this.blObrdDt = blObrdDt;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param trunkPodAta
	 */
	public void setTrunkPodAta(String trunkPodAta) {
		this.trunkPodAta = trunkPodAta;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
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
	 * @param siDt
	 */
	public void setSiDt(String siDt) {
		this.siDt = siDt;
	}
	
	/**
	 * Column Info
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}
	
	/**
	 * Column Info
	 * @param orgTrnsSvcModCd
	 */
	public void setOrgTrnsSvcModCd(String orgTrnsSvcModCd) {
		this.orgTrnsSvcModCd = orgTrnsSvcModCd;
	}
	
	/**
	 * Column Info
	 * @param docUsrId
	 */
	public void setDocUsrId(String docUsrId) {
		this.docUsrId = docUsrId;
	}
	
	/**
	 * Column Info
	 * @param firstPolCutoffDt
	 */
	public void setFirstPolCutoffDt(String firstPolCutoffDt) {
		this.firstPolCutoffDt = firstPolCutoffDt;
	}
	
	/**
	 * Column Info
	 * @param preCurrCd
	 */
	public void setPreCurrCd(String preCurrCd) {
		this.preCurrCd = preCurrCd;
	}
	
	/**
	 * Column Info
	 * @param trunkVvd
	 */
	public void setTrunkVvd(String trunkVvd) {
		this.trunkVvd = trunkVvd;
	}
	
	/**
	 * Column Info
	 * @param n1stPod
	 */
	public void setN1stPod(String n1stPod) {
		this.n1stPod = n1stPod;
	}
	
	/**
	 * Column Info
	 * @param nvoccCoScacCd
	 */
	public void setNvoccCoScacCd(String nvoccCoScacCd) {
		this.nvoccCoScacCd = nvoccCoScacCd;
	}
	
	/**
	 * Column Info
	 * @param polEtd
	 */
	public void setPolEtd(String polEtd) {
		this.polEtd = polEtd;
	}
	
	/**
	 * Column Info
	 * @param crd
	 */
	public void setCrd(String crd) {
		this.crd = crd;
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
	 * @param oblInetFlg
	 */
	public void setOblInetFlg(String oblInetFlg) {
		this.oblInetFlg = oblInetFlg;
	}
	
	/**
	 * Column Info
	 * @param ffCustNm
	 */
	public void setFfCustNm(String ffCustNm) {
		this.ffCustNm = ffCustNm;
	}
	
	/**
	 * Column Info
	 * @param lastVsl
	 */
	public void setLastVsl(String lastVsl) {
		this.lastVsl = lastVsl;
	}
	
	/**
	 * Column Info
	 * @param sumWgtTon
	 */
	public void setSumWgtTon(String sumWgtTon) {
		this.sumWgtTon = sumWgtTon;
	}
	
	/**
	 * Column Info
	 * @param shCntcNum
	 */
	public void setShCntcNum(String shCntcNum) {
		this.shCntcNum = shCntcNum;
	}
	
	/**
	 * Column Info
	 * @param trunkVslNm
	 */
	public void setTrunkVslNm(String trunkVslNm) {
		this.trunkVslNm = trunkVslNm;
	}
	
	/**
	 * Column Info
	 * @param krCstmsCustTpCd
	 */
	public void setKrCstmsCustTpCd(String krCstmsCustTpCd) {
		this.krCstmsCustTpCd = krCstmsCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param crn
	 */
	public void setCrn(String crn) {
		this.crn = crn;
	}
	
	/**
	 * Column Info
	 * @param preVsl
	 */
	public void setPreVsl(String preVsl) {
		this.preVsl = preVsl;
	}
	
	/**
	 * Column Info
	 * @param pre2Vvd
	 */
	public void setPre2Vvd(String pre2Vvd) {
		this.pre2Vvd = pre2Vvd;
	}
	
	/**
	 * Column Info
	 * @param porCntCd
	 */
	public void setPorCntCd(String porCntCd) {
		this.porCntCd = porCntCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtRefNo
	 */
	public void setMvmtRefNo(String mvmtRefNo) {
		this.mvmtRefNo = mvmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param finalPolEtd
	 */
	public void setFinalPolEtd(String finalPolEtd) {
		this.finalPolEtd = finalPolEtd;
	}
	
	/**
	 * Column Info
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @param finalPolEta
	 */
	public void setFinalPolEta(String finalPolEta) {
		this.finalPolEta = finalPolEta;
	}
	
	/**
	 * Column Info
	 * @param stCmdtNm
	 */
	public void setStCmdtNm(String stCmdtNm) {
		this.stCmdtNm = stCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param fwCntcNum
	 */
	public void setFwCntcNum(String fwCntcNum) {
		this.fwCntcNum = fwCntcNum;
	}
	
	/**
	 * Column Info
	 * @param pre2PodCd
	 */
	public void setPre2PodCd(String pre2PodCd) {
		this.pre2PodCd = pre2PodCd;
	}
	
	/**
	 * Column Info
	 * @param n1stPolEta
	 */
	public void setN1stPolEta(String n1stPolEta) {
		this.n1stPolEta = n1stPolEta;
	}
	
	/**
	 * Column Info
	 * @param n1stPolEtb
	 */
	public void setN1stPolEtb(String n1stPolEtb) {
		this.n1stPolEtb = n1stPolEtb;
	}
	
	/**
	 * Column Info
	 * @param sumPpdAmt
	 */
	public void setSumPpdAmt(String sumPpdAmt) {
		this.sumPpdAmt = sumPpdAmt;
	}
	
	/**
	 * Column Info
	 * @param n1stPolEtd
	 */
	public void setN1stPolEtd(String n1stPolEtd) {
		this.n1stPolEtd = n1stPolEtd;
	}
	
	/**
	 * Column Info
	 * @param cgoRlseSts
	 */
	public void setCgoRlseSts(String cgoRlseSts) {
		this.cgoRlseSts = cgoRlseSts;
	}
	
	/**
	 * Column Info
	 * @param delEta
	 */
	public void setDelEta(String delEta) {
		this.delEta = delEta;
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
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param scacNm
	 */
	public void setScacNm(String scacNm) {
		this.scacNm = scacNm;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}
	
	/**
	 * Column Info
	 * @param sumCctAmt
	 */
	public void setSumCctAmt(String sumCctAmt) {
		this.sumCctAmt = sumCctAmt;
	}
	
	/**
	 * Column Info
	 * @param ntMeasUtCd
	 */
	public void setNtMeasUtCd(String ntMeasUtCd) {
		this.ntMeasUtCd = ntMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param pre1PolCd
	 */
	public void setPre1PolCd(String pre1PolCd) {
		this.pre1PolCd = pre1PolCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTp
	 */
	public void setCntrTp(String cntrTp) {
		this.cntrTp = cntrTp;
	}
	
	/**
	 * Column Info
	 * @param post2Vvd
	 */
	public void setPost2Vvd(String post2Vvd) {
		this.post2Vvd = post2Vvd;
	}
	
	/**
	 * Column Info
	 * @param blPrtDt
	 */
	public void setBlPrtDt(String blPrtDt) {
		this.blPrtDt = blPrtDt;
	}
	
	/**
	 * Column Info
	 * @param pre4Vvd
	 */
	public void setPre4Vvd(String pre4Vvd) {
		this.pre4Vvd = pre4Vvd;
	}
	
	/**
	 * Column Info
	 * @param sumNetWgtKgs
	 */
	public void setSumNetWgtKgs(String sumNetWgtKgs) {
		this.sumNetWgtKgs = sumNetWgtKgs;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param podEtb
	 */
	public void setPodEtb(String podEtb) {
		this.podEtb = podEtb;
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
		setDelAta(JSPUtil.getParameter(request, prefix + "del_ata", ""));
		setSumWgtLbs(JSPUtil.getParameter(request, prefix + "sum_wgt_lbs", ""));
		setTrunkPolAta(JSPUtil.getParameter(request, prefix + "trunk_pol_ata", ""));
		setOblIssDt(JSPUtil.getParameter(request, prefix + "obl_iss_dt", ""));
		setCntrSz(JSPUtil.getParameter(request, prefix + "cntr_sz", ""));
		setSrdOfc(JSPUtil.getParameter(request, prefix + "srd_ofc", ""));
		setCntCntr(JSPUtil.getParameter(request, prefix + "cnt_cntr", ""));
		setXptLicNo(JSPUtil.getParameter(request, prefix + "xpt_lic_no", ""));
		setHamoCdDesc(JSPUtil.getParameter(request, prefix + "hamo_cd_desc", ""));
		setPostVsl(JSPUtil.getParameter(request, prefix + "post_vsl", ""));
		setHlgTp(JSPUtil.getParameter(request, prefix + "hlg_tp", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
		setDestTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "dest_trns_svc_mod_cd", ""));
		setIbFrhFlg(JSPUtil.getParameter(request, prefix + "ib_frh_flg", ""));
		setCptTtlAmt(JSPUtil.getParameter(request, prefix + "cpt_ttl_amt", ""));
		setGrsWgtUtCd(JSPUtil.getParameter(request, prefix + "grs_wgt_ut_cd", ""));
		setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
		setExMvmtRefNo(JSPUtil.getParameter(request, prefix + "ex_mvmt_ref_no", ""));
		setCaptOfc(JSPUtil.getParameter(request, prefix + "capt_ofc", ""));
		setPodAtaIcDt(JSPUtil.getParameter(request, prefix + "pod_ata_ic_dt", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request, prefix + "obl_iss_ofc_cd", ""));
		setCstmsUsrRdy(JSPUtil.getParameter(request, prefix + "cstms_usr_rdy", ""));
		setCstmsReq(JSPUtil.getParameter(request, prefix + "cstms_req", ""));
		setLastPod(JSPUtil.getParameter(request, prefix + "last_pod", ""));
		setObXchRtDt(JSPUtil.getParameter(request, prefix + "ob_xch_rt_dt", ""));
		setSumGrsWgtKgs(JSPUtil.getParameter(request, prefix + "sum_grs_wgt_kgs", ""));
		setFinalDestNm(JSPUtil.getParameter(request, prefix + "final_dest_nm", ""));
		setTroi(JSPUtil.getParameter(request, prefix + "troi", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSrdDt(JSPUtil.getParameter(request, prefix + "srd_dt", ""));
		setVvd2(JSPUtil.getParameter(request, prefix + "vvd_2", ""));
		setVvd3(JSPUtil.getParameter(request, prefix + "vvd_3", ""));
		setCntBl(JSPUtil.getParameter(request, prefix + "cnt_bl", ""));
		setPost1Vvd(JSPUtil.getParameter(request, prefix + "post1_vvd", ""));
		setVvd1(JSPUtil.getParameter(request, prefix + "vvd_1", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setShCustNm(JSPUtil.getParameter(request, prefix + "sh_cust_nm", ""));
		setVvd4(JSPUtil.getParameter(request, prefix + "vvd_4", ""));
		setTrunkPolEta(JSPUtil.getParameter(request, prefix + "trunk_pol_eta", ""));
		setLastVvd(JSPUtil.getParameter(request, prefix + "last_vvd", ""));
		setSumNetMeaCbm(JSPUtil.getParameter(request, prefix + "sum_net_mea_cbm", ""));
		setLastPodEtb(JSPUtil.getParameter(request, prefix + "last_pod_etb", ""));
		setN1stPodEta(JSPUtil.getParameter(request, prefix + "n1st_pod_eta", ""));
		setPre3PodCd(JSPUtil.getParameter(request, prefix + "pre3_pod_cd", ""));
		setLastPodEta(JSPUtil.getParameter(request, prefix + "last_pod_eta", ""));
		setN1stPodEtd(JSPUtil.getParameter(request, prefix + "n1st_pod_etd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setCntrSts(JSPUtil.getParameter(request, prefix + "cntr_sts", ""));
		setNtWgtQty(JSPUtil.getParameter(request, prefix + "nt_wgt_qty", ""));
		setDisLastVvd(JSPUtil.getParameter(request, prefix + "dis_last_vvd", ""));
		setScacCd(JSPUtil.getParameter(request, prefix + "scac_cd", ""));
		setTrunkPodCd(JSPUtil.getParameter(request, prefix + "trunk_pod_cd", ""));
		setObSlsRgnCd(JSPUtil.getParameter(request, prefix + "ob_sls_rgn_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setPre2PolCd(JSPUtil.getParameter(request, prefix + "pre2_pol_cd", ""));
		setNfCustNm(JSPUtil.getParameter(request, prefix + "nf_cust_nm", ""));
		setPostVvd(JSPUtil.getParameter(request, prefix + "post_vvd", ""));
		setSumGrsMeaCbm(JSPUtil.getParameter(request, prefix + "sum_grs_mea_cbm", ""));
		setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
		setLastPodAta(JSPUtil.getParameter(request, prefix + "last_pod_ata", ""));
		setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
		setPre4PolCd(JSPUtil.getParameter(request, prefix + "pre4_pol_cd", ""));
		setTrunkPodEtd(JSPUtil.getParameter(request, prefix + "trunk_pod_etd", ""));
		setBlSlanCd(JSPUtil.getParameter(request, prefix + "bl_slan_cd", ""));
		setTrunkPodEta(JSPUtil.getParameter(request, prefix + "trunk_pod_eta", ""));
		setOblRlseFlg(JSPUtil.getParameter(request, prefix + "obl_rlse_flg", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setTrunkVsl(JSPUtil.getParameter(request, prefix + "trunk_vsl", ""));
		setShCntcPsonNm(JSPUtil.getParameter(request, prefix + "sh_cntc_pson_nm", ""));
		setCnCustNm(JSPUtil.getParameter(request, prefix + "cn_cust_nm", ""));
		setCntBkg(JSPUtil.getParameter(request, prefix + "cnt_bkg", ""));
		setClrBy(JSPUtil.getParameter(request, prefix + "clr_by", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCntPck(JSPUtil.getParameter(request, prefix + "cnt_pck", ""));
		setOblInetPrnDt(JSPUtil.getParameter(request, prefix + "obl_inet_prn_dt", ""));
		setTrunkPolCd(JSPUtil.getParameter(request, prefix + "trunk_pol_cd", ""));
		setTsPort2(JSPUtil.getParameter(request, prefix + "ts_port2", ""));
		setTsPort3(JSPUtil.getParameter(request, prefix + "ts_port3", ""));
		setPre1Vvd(JSPUtil.getParameter(request, prefix + "pre1_vvd", ""));
		setFirstVsl(JSPUtil.getParameter(request, prefix + "first_vsl", ""));
		setCgoNature(JSPUtil.getParameter(request, prefix + "cgo_nature", ""));
		setTsPort1(JSPUtil.getParameter(request, prefix + "ts_port1", ""));
		setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setNtWgtUtCd(JSPUtil.getParameter(request, prefix + "nt_wgt_ut_cd", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setPre4PodCd(JSPUtil.getParameter(request, prefix + "pre4_pod_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setObVvd1(JSPUtil.getParameter(request, prefix + "ob_vvd_1", ""));
		setTrfCd(JSPUtil.getParameter(request, prefix + "trf_cd", ""));
		setPre3PolCd(JSPUtil.getParameter(request, prefix + "pre3_pol_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setN1stPodAtd(JSPUtil.getParameter(request, prefix + "n1st_pod_atd", ""));
		setPreVvd(JSPUtil.getParameter(request, prefix + "pre_vvd", ""));
		setPre1PodCd(JSPUtil.getParameter(request, prefix + "pre1_pod_cd", ""));
		setPost4Vvd(JSPUtil.getParameter(request, prefix + "post4_vvd", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setCstmsDecl(JSPUtil.getParameter(request, prefix + "cstms_decl", ""));
		setActTotWgt(JSPUtil.getParameter(request, prefix + "act_tot_wgt", ""));
		setIbXchRtDt(JSPUtil.getParameter(request, prefix + "ib_xch_rt_dt", ""));
		setNtMeasQty(JSPUtil.getParameter(request, prefix + "nt_meas_qty", ""));
		setIbCtrlOfc(JSPUtil.getParameter(request, prefix + "ib_ctrl_ofc", ""));
		setHblNo(JSPUtil.getParameter(request, prefix + "hbl_no", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setColCurrCd(JSPUtil.getParameter(request, prefix + "col_curr_cd", ""));
		setTareWgt(JSPUtil.getParameter(request, prefix + "tare_wgt", ""));
		setCctTtlAmt(JSPUtil.getParameter(request, prefix + "cct_ttl_amt", ""));
		setFfCntcPsonNm(JSPUtil.getParameter(request, prefix + "ff_cntc_pson_nm", ""));
		setAnCustNm(JSPUtil.getParameter(request, prefix + "an_cust_nm", ""));
		setIbdTrspTpCd(JSPUtil.getParameter(request, prefix + "ibd_trsp_tp_cd", ""));
		setIbdTrspNo(JSPUtil.getParameter(request, prefix + "ibd_trsp_no", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", ""));
		setFinalPodEta(JSPUtil.getParameter(request, prefix + "final_pod_eta", ""));
		setDelCntCd(JSPUtil.getParameter(request, prefix + "del_cnt_cd", ""));
		setCstmsSysRdy(JSPUtil.getParameter(request, prefix + "cstms_sys_rdy", ""));
		setTrunkSlanCd(JSPUtil.getParameter(request, prefix + "trunk_slan_cd", ""));
		setFinalPodEtd(JSPUtil.getParameter(request, prefix + "final_pod_etd", ""));
		setBkgIssOfcCd(JSPUtil.getParameter(request, prefix + "bkg_iss_ofc_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setTvvd(JSPUtil.getParameter(request, prefix + "tvvd", ""));
		setBlVvd(JSPUtil.getParameter(request, prefix + "bl_vvd", ""));
		setRdTerm(JSPUtil.getParameter(request, prefix + "rd_term", ""));
		setRlseStsCd(JSPUtil.getParameter(request, prefix + "rlse_sts_cd", ""));
		setPorNm(JSPUtil.getParameter(request, prefix + "por_nm", ""));
		setTrafMod(JSPUtil.getParameter(request, prefix + "traf_mod", ""));
		setPre3Vvd(JSPUtil.getParameter(request, prefix + "pre3_vvd", ""));
		setN3rdNtfyPty(JSPUtil.getParameter(request, prefix + "n3rd_ntfy_pty", ""));
		setPost3Vvd(JSPUtil.getParameter(request, prefix + "post3_vvd", ""));
		setBlObrdDt(JSPUtil.getParameter(request, prefix + "bl_obrd_dt", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, prefix + "pst_rly_port_cd", ""));
		setTrunkPodAta(JSPUtil.getParameter(request, prefix + "trunk_pod_ata", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setSiDt(JSPUtil.getParameter(request, prefix + "si_dt", ""));
		setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
		setOrgTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "org_trns_svc_mod_cd", ""));
		setDocUsrId(JSPUtil.getParameter(request, prefix + "doc_usr_id", ""));
		setFirstPolCutoffDt(JSPUtil.getParameter(request, prefix + "first_pol_cutoff_dt", ""));
		setPreCurrCd(JSPUtil.getParameter(request, prefix + "pre_curr_cd", ""));
		setTrunkVvd(JSPUtil.getParameter(request, prefix + "trunk_vvd", ""));
		setN1stPod(JSPUtil.getParameter(request, prefix + "n1st_pod", ""));
		setNvoccCoScacCd(JSPUtil.getParameter(request, prefix + "nvocc_co_scac_cd", ""));
		setPolEtd(JSPUtil.getParameter(request, prefix + "pol_etd", ""));
		setCrd(JSPUtil.getParameter(request, prefix + "crd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOblInetFlg(JSPUtil.getParameter(request, prefix + "obl_inet_flg", ""));
		setFfCustNm(JSPUtil.getParameter(request, prefix + "ff_cust_nm", ""));
		setLastVsl(JSPUtil.getParameter(request, prefix + "last_vsl", ""));
		setSumWgtTon(JSPUtil.getParameter(request, prefix + "sum_wgt_ton", ""));
		setShCntcNum(JSPUtil.getParameter(request, prefix + "sh_cntc_num", ""));
		setTrunkVslNm(JSPUtil.getParameter(request, prefix + "trunk_vsl_nm", ""));
		setKrCstmsCustTpCd(JSPUtil.getParameter(request, prefix + "kr_cstms_cust_tp_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setCrn(JSPUtil.getParameter(request, prefix + "crn", ""));
		setPreVsl(JSPUtil.getParameter(request, prefix + "pre_vsl", ""));
		setPre2Vvd(JSPUtil.getParameter(request, prefix + "pre2_vvd", ""));
		setPorCntCd(JSPUtil.getParameter(request, prefix + "por_cnt_cd", ""));
		setMvmtRefNo(JSPUtil.getParameter(request, prefix + "mvmt_ref_no", ""));
		setFinalPolEtd(JSPUtil.getParameter(request, prefix + "final_pol_etd", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setFinalPolEta(JSPUtil.getParameter(request, prefix + "final_pol_eta", ""));
		setStCmdtNm(JSPUtil.getParameter(request, prefix + "st_cmdt_nm", ""));
		setFwCntcNum(JSPUtil.getParameter(request, prefix + "fw_cntc_num", ""));
		setPre2PodCd(JSPUtil.getParameter(request, prefix + "pre2_pod_cd", ""));
		setN1stPolEta(JSPUtil.getParameter(request, prefix + "n1st_pol_eta", ""));
		setN1stPolEtb(JSPUtil.getParameter(request, prefix + "n1st_pol_etb", ""));
		setSumPpdAmt(JSPUtil.getParameter(request, prefix + "sum_ppd_amt", ""));
		setN1stPolEtd(JSPUtil.getParameter(request, prefix + "n1st_pol_etd", ""));
		setCgoRlseSts(JSPUtil.getParameter(request, prefix + "cgo_rlse_sts", ""));
		setDelEta(JSPUtil.getParameter(request, prefix + "del_eta", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setScacNm(JSPUtil.getParameter(request, prefix + "scac_nm", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setSumCctAmt(JSPUtil.getParameter(request, prefix + "sum_cct_amt", ""));
		setNtMeasUtCd(JSPUtil.getParameter(request, prefix + "nt_meas_ut_cd", ""));
		setPre1PolCd(JSPUtil.getParameter(request, prefix + "pre1_pol_cd", ""));
		setCntrTp(JSPUtil.getParameter(request, prefix + "cntr_tp", ""));
		setPost2Vvd(JSPUtil.getParameter(request, prefix + "post2_vvd", ""));
		setBlPrtDt(JSPUtil.getParameter(request, prefix + "bl_prt_dt", ""));
		setPre4Vvd(JSPUtil.getParameter(request, prefix + "pre4_vvd", ""));
		setSumNetWgtKgs(JSPUtil.getParameter(request, prefix + "sum_net_wgt_kgs", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setPodEtb(JSPUtil.getParameter(request, prefix + "pod_etb", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlCntrInfoReportOutVO[]
	 */
	public BlCntrInfoReportOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlCntrInfoReportOutVO[]
	 */
	public BlCntrInfoReportOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlCntrInfoReportOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] delAta = (JSPUtil.getParameter(request, prefix	+ "del_ata", length));
			String[] sumWgtLbs = (JSPUtil.getParameter(request, prefix	+ "sum_wgt_lbs", length));
			String[] trunkPolAta = (JSPUtil.getParameter(request, prefix	+ "trunk_pol_ata", length));
			String[] oblIssDt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt", length));
			String[] cntrSz = (JSPUtil.getParameter(request, prefix	+ "cntr_sz", length));
			String[] srdOfc = (JSPUtil.getParameter(request, prefix	+ "srd_ofc", length));
			String[] cntCntr = (JSPUtil.getParameter(request, prefix	+ "cnt_cntr", length));
			String[] xptLicNo = (JSPUtil.getParameter(request, prefix	+ "xpt_lic_no", length));
			String[] hamoCdDesc = (JSPUtil.getParameter(request, prefix	+ "hamo_cd_desc", length));
			String[] postVsl = (JSPUtil.getParameter(request, prefix	+ "post_vsl", length));
			String[] hlgTp = (JSPUtil.getParameter(request, prefix	+ "hlg_tp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] destTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_svc_mod_cd", length));
			String[] ibFrhFlg = (JSPUtil.getParameter(request, prefix	+ "ib_frh_flg", length));
			String[] cptTtlAmt = (JSPUtil.getParameter(request, prefix	+ "cpt_ttl_amt", length));
			String[] grsWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "grs_wgt_ut_cd", length));
			String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd", length));
			String[] exMvmtRefNo = (JSPUtil.getParameter(request, prefix	+ "ex_mvmt_ref_no", length));
			String[] captOfc = (JSPUtil.getParameter(request, prefix	+ "capt_ofc", length));
			String[] podAtaIcDt = (JSPUtil.getParameter(request, prefix	+ "pod_ata_ic_dt", length));
			String[] oblIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_ofc_cd", length));
			String[] cstmsUsrRdy = (JSPUtil.getParameter(request, prefix	+ "cstms_usr_rdy", length));
			String[] cstmsReq = (JSPUtil.getParameter(request, prefix	+ "cstms_req", length));
			String[] lastPod = (JSPUtil.getParameter(request, prefix	+ "last_pod", length));
			String[] obXchRtDt = (JSPUtil.getParameter(request, prefix	+ "ob_xch_rt_dt", length));
			String[] sumGrsWgtKgs = (JSPUtil.getParameter(request, prefix	+ "sum_grs_wgt_kgs", length));
			String[] finalDestNm = (JSPUtil.getParameter(request, prefix	+ "final_dest_nm", length));
			String[] troi = (JSPUtil.getParameter(request, prefix	+ "troi", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] srdDt = (JSPUtil.getParameter(request, prefix	+ "srd_dt", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd_2", length));
			String[] vvd3 = (JSPUtil.getParameter(request, prefix	+ "vvd_3", length));
			String[] cntBl = (JSPUtil.getParameter(request, prefix	+ "cnt_bl", length));
			String[] post1Vvd = (JSPUtil.getParameter(request, prefix	+ "post1_vvd", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd_1", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] shCustNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_nm", length));
			String[] vvd4 = (JSPUtil.getParameter(request, prefix	+ "vvd_4", length));
			String[] trunkPolEta = (JSPUtil.getParameter(request, prefix	+ "trunk_pol_eta", length));
			String[] lastVvd = (JSPUtil.getParameter(request, prefix	+ "last_vvd", length));
			String[] sumNetMeaCbm = (JSPUtil.getParameter(request, prefix	+ "sum_net_mea_cbm", length));
			String[] lastPodEtb = (JSPUtil.getParameter(request, prefix	+ "last_pod_etb", length));
			String[] n1stPodEta = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_eta", length));
			String[] pre3PodCd = (JSPUtil.getParameter(request, prefix	+ "pre3_pod_cd", length));
			String[] lastPodEta = (JSPUtil.getParameter(request, prefix	+ "last_pod_eta", length));
			String[] n1stPodEtd = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_etd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] cntrSts = (JSPUtil.getParameter(request, prefix	+ "cntr_sts", length));
			String[] ntWgtQty = (JSPUtil.getParameter(request, prefix	+ "nt_wgt_qty", length));
			String[] disLastVvd = (JSPUtil.getParameter(request, prefix	+ "dis_last_vvd", length));
			String[] scacCd = (JSPUtil.getParameter(request, prefix	+ "scac_cd", length));
			String[] trunkPodCd = (JSPUtil.getParameter(request, prefix	+ "trunk_pod_cd", length));
			String[] obSlsRgnCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_rgn_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] pre2PolCd = (JSPUtil.getParameter(request, prefix	+ "pre2_pol_cd", length));
			String[] nfCustNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_nm", length));
			String[] postVvd = (JSPUtil.getParameter(request, prefix	+ "post_vvd", length));
			String[] sumGrsMeaCbm = (JSPUtil.getParameter(request, prefix	+ "sum_grs_mea_cbm", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] lastPodAta = (JSPUtil.getParameter(request, prefix	+ "last_pod_ata", length));
			String[] delNm = (JSPUtil.getParameter(request, prefix	+ "del_nm", length));
			String[] pre4PolCd = (JSPUtil.getParameter(request, prefix	+ "pre4_pol_cd", length));
			String[] trunkPodEtd = (JSPUtil.getParameter(request, prefix	+ "trunk_pod_etd", length));
			String[] blSlanCd = (JSPUtil.getParameter(request, prefix	+ "bl_slan_cd", length));
			String[] trunkPodEta = (JSPUtil.getParameter(request, prefix	+ "trunk_pod_eta", length));
			String[] oblRlseFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rlse_flg", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] trunkVsl = (JSPUtil.getParameter(request, prefix	+ "trunk_vsl", length));
			String[] shCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "sh_cntc_pson_nm", length));
			String[] cnCustNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_nm", length));
			String[] cntBkg = (JSPUtil.getParameter(request, prefix	+ "cnt_bkg", length));
			String[] clrBy = (JSPUtil.getParameter(request, prefix	+ "clr_by", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cntPck = (JSPUtil.getParameter(request, prefix	+ "cnt_pck", length));
			String[] oblInetPrnDt = (JSPUtil.getParameter(request, prefix	+ "obl_inet_prn_dt", length));
			String[] trunkPolCd = (JSPUtil.getParameter(request, prefix	+ "trunk_pol_cd", length));
			String[] tsPort2 = (JSPUtil.getParameter(request, prefix	+ "ts_port2", length));
			String[] tsPort3 = (JSPUtil.getParameter(request, prefix	+ "ts_port3", length));
			String[] pre1Vvd = (JSPUtil.getParameter(request, prefix	+ "pre1_vvd", length));
			String[] firstVsl = (JSPUtil.getParameter(request, prefix	+ "first_vsl", length));
			String[] cgoNature = (JSPUtil.getParameter(request, prefix	+ "cgo_nature", length));
			String[] tsPort1 = (JSPUtil.getParameter(request, prefix	+ "ts_port1", length));
			String[] polNm = (JSPUtil.getParameter(request, prefix	+ "pol_nm", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] ntWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "nt_wgt_ut_cd", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] pre4PodCd = (JSPUtil.getParameter(request, prefix	+ "pre4_pod_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] obVvd1 = (JSPUtil.getParameter(request, prefix	+ "ob_vvd_1", length));
			String[] trfCd = (JSPUtil.getParameter(request, prefix	+ "trf_cd", length));
			String[] pre3PolCd = (JSPUtil.getParameter(request, prefix	+ "pre3_pol_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] n1stPodAtd = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_atd", length));
			String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd", length));
			String[] pre1PodCd = (JSPUtil.getParameter(request, prefix	+ "pre1_pod_cd", length));
			String[] post4Vvd = (JSPUtil.getParameter(request, prefix	+ "post4_vvd", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] cstmsDecl = (JSPUtil.getParameter(request, prefix	+ "cstms_decl", length));
			String[] actTotWgt = (JSPUtil.getParameter(request, prefix	+ "act_tot_wgt", length));
			String[] ibXchRtDt = (JSPUtil.getParameter(request, prefix	+ "ib_xch_rt_dt", length));
			String[] ntMeasQty = (JSPUtil.getParameter(request, prefix	+ "nt_meas_qty", length));
			String[] ibCtrlOfc = (JSPUtil.getParameter(request, prefix	+ "ib_ctrl_ofc", length));
			String[] hblNo = (JSPUtil.getParameter(request, prefix	+ "hbl_no", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] colCurrCd = (JSPUtil.getParameter(request, prefix	+ "col_curr_cd", length));
			String[] tareWgt = (JSPUtil.getParameter(request, prefix	+ "tare_wgt", length));
			String[] cctTtlAmt = (JSPUtil.getParameter(request, prefix	+ "cct_ttl_amt", length));
			String[] ffCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "ff_cntc_pson_nm", length));
			String[] anCustNm = (JSPUtil.getParameter(request, prefix	+ "an_cust_nm", length));
			String[] ibdTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_tp_cd", length));
			String[] ibdTrspNo = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_no", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] finalPodEta = (JSPUtil.getParameter(request, prefix	+ "final_pod_eta", length));
			String[] delCntCd = (JSPUtil.getParameter(request, prefix	+ "del_cnt_cd", length));
			String[] cstmsSysRdy = (JSPUtil.getParameter(request, prefix	+ "cstms_sys_rdy", length));
			String[] trunkSlanCd = (JSPUtil.getParameter(request, prefix	+ "trunk_slan_cd", length));
			String[] finalPodEtd = (JSPUtil.getParameter(request, prefix	+ "final_pod_etd", length));
			String[] bkgIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_iss_ofc_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] tvvd = (JSPUtil.getParameter(request, prefix	+ "tvvd", length));
			String[] blVvd = (JSPUtil.getParameter(request, prefix	+ "bl_vvd", length));
			String[] rdTerm = (JSPUtil.getParameter(request, prefix	+ "rd_term", length));
			String[] rlseStsCd = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_cd", length));
			String[] porNm = (JSPUtil.getParameter(request, prefix	+ "por_nm", length));
			String[] trafMod = (JSPUtil.getParameter(request, prefix	+ "traf_mod", length));
			String[] pre3Vvd = (JSPUtil.getParameter(request, prefix	+ "pre3_vvd", length));
			String[] n3rdNtfyPty = (JSPUtil.getParameter(request, prefix	+ "n3rd_ntfy_pty", length));
			String[] post3Vvd = (JSPUtil.getParameter(request, prefix	+ "post3_vvd", length));
			String[] blObrdDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] trunkPodAta = (JSPUtil.getParameter(request, prefix	+ "trunk_pod_ata", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] siDt = (JSPUtil.getParameter(request, prefix	+ "si_dt", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] orgTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "org_trns_svc_mod_cd", length));
			String[] docUsrId = (JSPUtil.getParameter(request, prefix	+ "doc_usr_id", length));
			String[] firstPolCutoffDt = (JSPUtil.getParameter(request, prefix	+ "first_pol_cutoff_dt", length));
			String[] preCurrCd = (JSPUtil.getParameter(request, prefix	+ "pre_curr_cd", length));
			String[] trunkVvd = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd", length));
			String[] n1stPod = (JSPUtil.getParameter(request, prefix	+ "n1st_pod", length));
			String[] nvoccCoScacCd = (JSPUtil.getParameter(request, prefix	+ "nvocc_co_scac_cd", length));
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));
			String[] crd = (JSPUtil.getParameter(request, prefix	+ "crd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oblInetFlg = (JSPUtil.getParameter(request, prefix	+ "obl_inet_flg", length));
			String[] ffCustNm = (JSPUtil.getParameter(request, prefix	+ "ff_cust_nm", length));
			String[] lastVsl = (JSPUtil.getParameter(request, prefix	+ "last_vsl", length));
			String[] sumWgtTon = (JSPUtil.getParameter(request, prefix	+ "sum_wgt_ton", length));
			String[] shCntcNum = (JSPUtil.getParameter(request, prefix	+ "sh_cntc_num", length));
			String[] trunkVslNm = (JSPUtil.getParameter(request, prefix	+ "trunk_vsl_nm", length));
			String[] krCstmsCustTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_cust_tp_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] crn = (JSPUtil.getParameter(request, prefix	+ "crn", length));
			String[] preVsl = (JSPUtil.getParameter(request, prefix	+ "pre_vsl", length));
			String[] pre2Vvd = (JSPUtil.getParameter(request, prefix	+ "pre2_vvd", length));
			String[] porCntCd = (JSPUtil.getParameter(request, prefix	+ "por_cnt_cd", length));
			String[] mvmtRefNo = (JSPUtil.getParameter(request, prefix	+ "mvmt_ref_no", length));
			String[] finalPolEtd = (JSPUtil.getParameter(request, prefix	+ "final_pol_etd", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] finalPolEta = (JSPUtil.getParameter(request, prefix	+ "final_pol_eta", length));
			String[] stCmdtNm = (JSPUtil.getParameter(request, prefix	+ "st_cmdt_nm", length));
			String[] fwCntcNum = (JSPUtil.getParameter(request, prefix	+ "fw_cntc_num", length));
			String[] pre2PodCd = (JSPUtil.getParameter(request, prefix	+ "pre2_pod_cd", length));
			String[] n1stPolEta = (JSPUtil.getParameter(request, prefix	+ "n1st_pol_eta", length));
			String[] n1stPolEtb = (JSPUtil.getParameter(request, prefix	+ "n1st_pol_etb", length));
			String[] sumPpdAmt = (JSPUtil.getParameter(request, prefix	+ "sum_ppd_amt", length));
			String[] n1stPolEtd = (JSPUtil.getParameter(request, prefix	+ "n1st_pol_etd", length));
			String[] cgoRlseSts = (JSPUtil.getParameter(request, prefix	+ "cgo_rlse_sts", length));
			String[] delEta = (JSPUtil.getParameter(request, prefix	+ "del_eta", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] scacNm = (JSPUtil.getParameter(request, prefix	+ "scac_nm", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] sumCctAmt = (JSPUtil.getParameter(request, prefix	+ "sum_cct_amt", length));
			String[] ntMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "nt_meas_ut_cd", length));
			String[] pre1PolCd = (JSPUtil.getParameter(request, prefix	+ "pre1_pol_cd", length));
			String[] cntrTp = (JSPUtil.getParameter(request, prefix	+ "cntr_tp", length));
			String[] post2Vvd = (JSPUtil.getParameter(request, prefix	+ "post2_vvd", length));
			String[] blPrtDt = (JSPUtil.getParameter(request, prefix	+ "bl_prt_dt", length));
			String[] pre4Vvd = (JSPUtil.getParameter(request, prefix	+ "pre4_vvd", length));
			String[] sumNetWgtKgs = (JSPUtil.getParameter(request, prefix	+ "sum_net_wgt_kgs", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] podEtb = (JSPUtil.getParameter(request, prefix	+ "pod_etb", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlCntrInfoReportOutVO();
				if (delAta[i] != null)
					model.setDelAta(delAta[i]);
				if (sumWgtLbs[i] != null)
					model.setSumWgtLbs(sumWgtLbs[i]);
				if (trunkPolAta[i] != null)
					model.setTrunkPolAta(trunkPolAta[i]);
				if (oblIssDt[i] != null)
					model.setOblIssDt(oblIssDt[i]);
				if (cntrSz[i] != null)
					model.setCntrSz(cntrSz[i]);
				if (srdOfc[i] != null)
					model.setSrdOfc(srdOfc[i]);
				if (cntCntr[i] != null)
					model.setCntCntr(cntCntr[i]);
				if (xptLicNo[i] != null)
					model.setXptLicNo(xptLicNo[i]);
				if (hamoCdDesc[i] != null)
					model.setHamoCdDesc(hamoCdDesc[i]);
				if (postVsl[i] != null)
					model.setPostVsl(postVsl[i]);
				if (hlgTp[i] != null)
					model.setHlgTp(hlgTp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (destTrnsSvcModCd[i] != null)
					model.setDestTrnsSvcModCd(destTrnsSvcModCd[i]);
				if (ibFrhFlg[i] != null)
					model.setIbFrhFlg(ibFrhFlg[i]);
				if (cptTtlAmt[i] != null)
					model.setCptTtlAmt(cptTtlAmt[i]);
				if (grsWgtUtCd[i] != null)
					model.setGrsWgtUtCd(grsWgtUtCd[i]);
				if (cmdtHsCd[i] != null)
					model.setCmdtHsCd(cmdtHsCd[i]);
				if (exMvmtRefNo[i] != null)
					model.setExMvmtRefNo(exMvmtRefNo[i]);
				if (captOfc[i] != null)
					model.setCaptOfc(captOfc[i]);
				if (podAtaIcDt[i] != null)
					model.setPodAtaIcDt(podAtaIcDt[i]);
				if (oblIssOfcCd[i] != null)
					model.setOblIssOfcCd(oblIssOfcCd[i]);
				if (cstmsUsrRdy[i] != null)
					model.setCstmsUsrRdy(cstmsUsrRdy[i]);
				if (cstmsReq[i] != null)
					model.setCstmsReq(cstmsReq[i]);
				if (lastPod[i] != null)
					model.setLastPod(lastPod[i]);
				if (obXchRtDt[i] != null)
					model.setObXchRtDt(obXchRtDt[i]);
				if (sumGrsWgtKgs[i] != null)
					model.setSumGrsWgtKgs(sumGrsWgtKgs[i]);
				if (finalDestNm[i] != null)
					model.setFinalDestNm(finalDestNm[i]);
				if (troi[i] != null)
					model.setTroi(troi[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (srdDt[i] != null)
					model.setSrdDt(srdDt[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (vvd3[i] != null)
					model.setVvd3(vvd3[i]);
				if (cntBl[i] != null)
					model.setCntBl(cntBl[i]);
				if (post1Vvd[i] != null)
					model.setPost1Vvd(post1Vvd[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (shCustNm[i] != null)
					model.setShCustNm(shCustNm[i]);
				if (vvd4[i] != null)
					model.setVvd4(vvd4[i]);
				if (trunkPolEta[i] != null)
					model.setTrunkPolEta(trunkPolEta[i]);
				if (lastVvd[i] != null)
					model.setLastVvd(lastVvd[i]);
				if (sumNetMeaCbm[i] != null)
					model.setSumNetMeaCbm(sumNetMeaCbm[i]);
				if (lastPodEtb[i] != null)
					model.setLastPodEtb(lastPodEtb[i]);
				if (n1stPodEta[i] != null)
					model.setN1stPodEta(n1stPodEta[i]);
				if (pre3PodCd[i] != null)
					model.setPre3PodCd(pre3PodCd[i]);
				if (lastPodEta[i] != null)
					model.setLastPodEta(lastPodEta[i]);
				if (n1stPodEtd[i] != null)
					model.setN1stPodEtd(n1stPodEtd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (cntrSts[i] != null)
					model.setCntrSts(cntrSts[i]);
				if (ntWgtQty[i] != null)
					model.setNtWgtQty(ntWgtQty[i]);
				if (disLastVvd[i] != null)
					model.setDisLastVvd(disLastVvd[i]);
				if (scacCd[i] != null)
					model.setScacCd(scacCd[i]);
				if (trunkPodCd[i] != null)
					model.setTrunkPodCd(trunkPodCd[i]);
				if (obSlsRgnCd[i] != null)
					model.setObSlsRgnCd(obSlsRgnCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (pre2PolCd[i] != null)
					model.setPre2PolCd(pre2PolCd[i]);
				if (nfCustNm[i] != null)
					model.setNfCustNm(nfCustNm[i]);
				if (postVvd[i] != null)
					model.setPostVvd(postVvd[i]);
				if (sumGrsMeaCbm[i] != null)
					model.setSumGrsMeaCbm(sumGrsMeaCbm[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (lastPodAta[i] != null)
					model.setLastPodAta(lastPodAta[i]);
				if (delNm[i] != null)
					model.setDelNm(delNm[i]);
				if (pre4PolCd[i] != null)
					model.setPre4PolCd(pre4PolCd[i]);
				if (trunkPodEtd[i] != null)
					model.setTrunkPodEtd(trunkPodEtd[i]);
				if (blSlanCd[i] != null)
					model.setBlSlanCd(blSlanCd[i]);
				if (trunkPodEta[i] != null)
					model.setTrunkPodEta(trunkPodEta[i]);
				if (oblRlseFlg[i] != null)
					model.setOblRlseFlg(oblRlseFlg[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (trunkVsl[i] != null)
					model.setTrunkVsl(trunkVsl[i]);
				if (shCntcPsonNm[i] != null)
					model.setShCntcPsonNm(shCntcPsonNm[i]);
				if (cnCustNm[i] != null)
					model.setCnCustNm(cnCustNm[i]);
				if (cntBkg[i] != null)
					model.setCntBkg(cntBkg[i]);
				if (clrBy[i] != null)
					model.setClrBy(clrBy[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cntPck[i] != null)
					model.setCntPck(cntPck[i]);
				if (oblInetPrnDt[i] != null)
					model.setOblInetPrnDt(oblInetPrnDt[i]);
				if (trunkPolCd[i] != null)
					model.setTrunkPolCd(trunkPolCd[i]);
				if (tsPort2[i] != null)
					model.setTsPort2(tsPort2[i]);
				if (tsPort3[i] != null)
					model.setTsPort3(tsPort3[i]);
				if (pre1Vvd[i] != null)
					model.setPre1Vvd(pre1Vvd[i]);
				if (firstVsl[i] != null)
					model.setFirstVsl(firstVsl[i]);
				if (cgoNature[i] != null)
					model.setCgoNature(cgoNature[i]);
				if (tsPort1[i] != null)
					model.setTsPort1(tsPort1[i]);
				if (polNm[i] != null)
					model.setPolNm(polNm[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (ntWgtUtCd[i] != null)
					model.setNtWgtUtCd(ntWgtUtCd[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (pre4PodCd[i] != null)
					model.setPre4PodCd(pre4PodCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (obVvd1[i] != null)
					model.setObVvd1(obVvd1[i]);
				if (trfCd[i] != null)
					model.setTrfCd(trfCd[i]);
				if (pre3PolCd[i] != null)
					model.setPre3PolCd(pre3PolCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (n1stPodAtd[i] != null)
					model.setN1stPodAtd(n1stPodAtd[i]);
				if (preVvd[i] != null)
					model.setPreVvd(preVvd[i]);
				if (pre1PodCd[i] != null)
					model.setPre1PodCd(pre1PodCd[i]);
				if (post4Vvd[i] != null)
					model.setPost4Vvd(post4Vvd[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (cstmsDecl[i] != null)
					model.setCstmsDecl(cstmsDecl[i]);
				if (actTotWgt[i] != null)
					model.setActTotWgt(actTotWgt[i]);
				if (ibXchRtDt[i] != null)
					model.setIbXchRtDt(ibXchRtDt[i]);
				if (ntMeasQty[i] != null)
					model.setNtMeasQty(ntMeasQty[i]);
				if (ibCtrlOfc[i] != null)
					model.setIbCtrlOfc(ibCtrlOfc[i]);
				if (hblNo[i] != null)
					model.setHblNo(hblNo[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (colCurrCd[i] != null)
					model.setColCurrCd(colCurrCd[i]);
				if (tareWgt[i] != null)
					model.setTareWgt(tareWgt[i]);
				if (cctTtlAmt[i] != null)
					model.setCctTtlAmt(cctTtlAmt[i]);
				if (ffCntcPsonNm[i] != null)
					model.setFfCntcPsonNm(ffCntcPsonNm[i]);
				if (anCustNm[i] != null)
					model.setAnCustNm(anCustNm[i]);
				if (ibdTrspTpCd[i] != null)
					model.setIbdTrspTpCd(ibdTrspTpCd[i]);
				if (ibdTrspNo[i] != null)
					model.setIbdTrspNo(ibdTrspNo[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (finalPodEta[i] != null)
					model.setFinalPodEta(finalPodEta[i]);
				if (delCntCd[i] != null)
					model.setDelCntCd(delCntCd[i]);
				if (cstmsSysRdy[i] != null)
					model.setCstmsSysRdy(cstmsSysRdy[i]);
				if (trunkSlanCd[i] != null)
					model.setTrunkSlanCd(trunkSlanCd[i]);
				if (finalPodEtd[i] != null)
					model.setFinalPodEtd(finalPodEtd[i]);
				if (bkgIssOfcCd[i] != null)
					model.setBkgIssOfcCd(bkgIssOfcCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (tvvd[i] != null)
					model.setTvvd(tvvd[i]);
				if (blVvd[i] != null)
					model.setBlVvd(blVvd[i]);
				if (rdTerm[i] != null)
					model.setRdTerm(rdTerm[i]);
				if (rlseStsCd[i] != null)
					model.setRlseStsCd(rlseStsCd[i]);
				if (porNm[i] != null)
					model.setPorNm(porNm[i]);
				if (trafMod[i] != null)
					model.setTrafMod(trafMod[i]);
				if (pre3Vvd[i] != null)
					model.setPre3Vvd(pre3Vvd[i]);
				if (n3rdNtfyPty[i] != null)
					model.setN3rdNtfyPty(n3rdNtfyPty[i]);
				if (post3Vvd[i] != null)
					model.setPost3Vvd(post3Vvd[i]);
				if (blObrdDt[i] != null)
					model.setBlObrdDt(blObrdDt[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (trunkPodAta[i] != null)
					model.setTrunkPodAta(trunkPodAta[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (siDt[i] != null)
					model.setSiDt(siDt[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (orgTrnsSvcModCd[i] != null)
					model.setOrgTrnsSvcModCd(orgTrnsSvcModCd[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (firstPolCutoffDt[i] != null)
					model.setFirstPolCutoffDt(firstPolCutoffDt[i]);
				if (preCurrCd[i] != null)
					model.setPreCurrCd(preCurrCd[i]);
				if (trunkVvd[i] != null)
					model.setTrunkVvd(trunkVvd[i]);
				if (n1stPod[i] != null)
					model.setN1stPod(n1stPod[i]);
				if (nvoccCoScacCd[i] != null)
					model.setNvoccCoScacCd(nvoccCoScacCd[i]);
				if (polEtd[i] != null)
					model.setPolEtd(polEtd[i]);
				if (crd[i] != null)
					model.setCrd(crd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oblInetFlg[i] != null)
					model.setOblInetFlg(oblInetFlg[i]);
				if (ffCustNm[i] != null)
					model.setFfCustNm(ffCustNm[i]);
				if (lastVsl[i] != null)
					model.setLastVsl(lastVsl[i]);
				if (sumWgtTon[i] != null)
					model.setSumWgtTon(sumWgtTon[i]);
				if (shCntcNum[i] != null)
					model.setShCntcNum(shCntcNum[i]);
				if (trunkVslNm[i] != null)
					model.setTrunkVslNm(trunkVslNm[i]);
				if (krCstmsCustTpCd[i] != null)
					model.setKrCstmsCustTpCd(krCstmsCustTpCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (crn[i] != null)
					model.setCrn(crn[i]);
				if (preVsl[i] != null)
					model.setPreVsl(preVsl[i]);
				if (pre2Vvd[i] != null)
					model.setPre2Vvd(pre2Vvd[i]);
				if (porCntCd[i] != null)
					model.setPorCntCd(porCntCd[i]);
				if (mvmtRefNo[i] != null)
					model.setMvmtRefNo(mvmtRefNo[i]);
				if (finalPolEtd[i] != null)
					model.setFinalPolEtd(finalPolEtd[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (finalPolEta[i] != null)
					model.setFinalPolEta(finalPolEta[i]);
				if (stCmdtNm[i] != null)
					model.setStCmdtNm(stCmdtNm[i]);
				if (fwCntcNum[i] != null)
					model.setFwCntcNum(fwCntcNum[i]);
				if (pre2PodCd[i] != null)
					model.setPre2PodCd(pre2PodCd[i]);
				if (n1stPolEta[i] != null)
					model.setN1stPolEta(n1stPolEta[i]);
				if (n1stPolEtb[i] != null)
					model.setN1stPolEtb(n1stPolEtb[i]);
				if (sumPpdAmt[i] != null)
					model.setSumPpdAmt(sumPpdAmt[i]);
				if (n1stPolEtd[i] != null)
					model.setN1stPolEtd(n1stPolEtd[i]);
				if (cgoRlseSts[i] != null)
					model.setCgoRlseSts(cgoRlseSts[i]);
				if (delEta[i] != null)
					model.setDelEta(delEta[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (scacNm[i] != null)
					model.setScacNm(scacNm[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (sumCctAmt[i] != null)
					model.setSumCctAmt(sumCctAmt[i]);
				if (ntMeasUtCd[i] != null)
					model.setNtMeasUtCd(ntMeasUtCd[i]);
				if (pre1PolCd[i] != null)
					model.setPre1PolCd(pre1PolCd[i]);
				if (cntrTp[i] != null)
					model.setCntrTp(cntrTp[i]);
				if (post2Vvd[i] != null)
					model.setPost2Vvd(post2Vvd[i]);
				if (blPrtDt[i] != null)
					model.setBlPrtDt(blPrtDt[i]);
				if (pre4Vvd[i] != null)
					model.setPre4Vvd(pre4Vvd[i]);
				if (sumNetWgtKgs[i] != null)
					model.setSumNetWgtKgs(sumNetWgtKgs[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (podEtb[i] != null)
					model.setPodEtb(podEtb[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlCntrInfoReportOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlCntrInfoReportOutVO[]
	 */
	public BlCntrInfoReportOutVO[] getBlCntrInfoReportOutVOs(){
		BlCntrInfoReportOutVO[] vos = (BlCntrInfoReportOutVO[])models.toArray(new BlCntrInfoReportOutVO[models.size()]);
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
		this.delAta = this.delAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumWgtLbs = this.sumWgtLbs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPolAta = this.trunkPolAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDt = this.oblIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSz = this.cntrSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srdOfc = this.srdOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCntr = this.cntCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptLicNo = this.xptLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hamoCdDesc = this.hamoCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postVsl = this.postVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hlgTp = this.hlgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsSvcModCd = this.destTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibFrhFlg = this.ibFrhFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cptTtlAmt = this.cptTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgtUtCd = this.grsWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd = this.cmdtHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exMvmtRefNo = this.exMvmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.captOfc = this.captOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtaIcDt = this.podAtaIcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd = this.oblIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsUsrRdy = this.cstmsUsrRdy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsReq = this.cstmsReq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPod = this.lastPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obXchRtDt = this.obXchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumGrsWgtKgs = this.sumGrsWgtKgs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalDestNm = this.finalDestNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troi = this.troi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srdDt = this.srdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 = this.vvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntBl = this.cntBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.post1Vvd = this.post1Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustNm = this.shCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4 = this.vvd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPolEta = this.trunkPolEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastVvd = this.lastVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumNetMeaCbm = this.sumNetMeaCbm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPodEtb = this.lastPodEtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPodEta = this.n1stPodEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre3PodCd = this.pre3PodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPodEta = this.lastPodEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPodEtd = this.n1stPodEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSts = this.cntrSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntWgtQty = this.ntWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disLastVvd = this.disLastVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scacCd = this.scacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPodCd = this.trunkPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsRgnCd = this.obSlsRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre2PolCd = this.pre2PolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustNm = this.nfCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postVvd = this.postVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumGrsMeaCbm = this.sumGrsMeaCbm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPodAta = this.lastPodAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNm = this.delNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre4PolCd = this.pre4PolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPodEtd = this.trunkPodEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSlanCd = this.blSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPodEta = this.trunkPodEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRlseFlg = this.oblRlseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVsl = this.trunkVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCntcPsonNm = this.shCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustNm = this.cnCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntBkg = this.cntBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clrBy = this.clrBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntPck = this.cntPck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblInetPrnDt = this.oblInetPrnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPolCd = this.trunkPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPort2 = this.tsPort2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPort3 = this.tsPort3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre1Vvd = this.pre1Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstVsl = this.firstVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoNature = this.cgoNature .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPort1 = this.tsPort1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNm = this.polNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntWgtUtCd = this.ntWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre4PodCd = this.pre4PodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obVvd1 = this.obVvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCd = this.trfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre3PolCd = this.pre3PolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPodAtd = this.n1stPodAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre1PodCd = this.pre1PodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.post4Vvd = this.post4Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDecl = this.cstmsDecl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actTotWgt = this.actTotWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibXchRtDt = this.ibXchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntMeasQty = this.ntMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCtrlOfc = this.ibCtrlOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblNo = this.hblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colCurrCd = this.colCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tareWgt = this.tareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctTtlAmt = this.cctTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntcPsonNm = this.ffCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustNm = this.anCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspTpCd = this.ibdTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspNo = this.ibdTrspNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalPodEta = this.finalPodEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntCd = this.delCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsSysRdy = this.cstmsSysRdy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkSlanCd = this.trunkSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalPodEtd = this.finalPodEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIssOfcCd = this.bkgIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvd = this.tvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blVvd = this.blVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdTerm = this.rdTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsCd = this.rlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNm = this.porNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trafMod = this.trafMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre3Vvd = this.pre3Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdNtfyPty = this.n3rdNtfyPty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.post3Vvd = this.post3Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDt = this.blObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPodAta = this.trunkPodAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siDt = this.siDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrnsSvcModCd = this.orgTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstPolCutoffDt = this.firstPolCutoffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCurrCd = this.preCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd = this.trunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPod = this.n1stPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccCoScacCd = this.nvoccCoScacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crd = this.crd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblInetFlg = this.oblInetFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustNm = this.ffCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastVsl = this.lastVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumWgtTon = this.sumWgtTon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCntcNum = this.shCntcNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVslNm = this.trunkVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsCustTpCd = this.krCstmsCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crn = this.crn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVsl = this.preVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre2Vvd = this.pre2Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCntCd = this.porCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtRefNo = this.mvmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalPolEtd = this.finalPolEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalPolEta = this.finalPolEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stCmdtNm = this.stCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwCntcNum = this.fwCntcNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre2PodCd = this.pre2PodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPolEta = this.n1stPolEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPolEtb = this.n1stPolEtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumPpdAmt = this.sumPpdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPolEtd = this.n1stPolEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoRlseSts = this.cgoRlseSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEta = this.delEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scacNm = this.scacNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCctAmt = this.sumCctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntMeasUtCd = this.ntMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre1PolCd = this.pre1PolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTp = this.cntrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.post2Vvd = this.post2Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPrtDt = this.blPrtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre4Vvd = this.pre4Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumNetWgtKgs = this.sumNetWgtKgs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtb = this.podEtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
