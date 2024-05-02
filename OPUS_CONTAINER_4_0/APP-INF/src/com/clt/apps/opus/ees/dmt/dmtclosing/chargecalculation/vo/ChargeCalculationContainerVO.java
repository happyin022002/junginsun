/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeCalculationContainerVO.java
*@FileTitle : ChargeCalculationContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.04.29 황효근 
* 2011.07.20 Kim Hyun Hwa
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeCalculationContainerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeCalculationContainerVO> models = new ArrayList<ChargeCalculationContainerVO>();
	
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String corrRmk = null;
	/* Column Info */
	private String dulTpExptFlg = null;
	/* Column Info */
	private String webCreDt = null;
	/* Column Info */
	private String ofcTrnsFlg = null;
	/* Column Info */
	private String aftExptDcAmt = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String aftExptAdjSeq = null;
	/* Column Info */
	private String dmdtTrfAplyTpCd = null;
	/* Column Info */
	private String demFtEndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String shipperNm = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String arActNm = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String payerCd = null;
	/* Column Info */
	private String aftExptAproNo = null;
	/* Column Info */
	private String rlseOfc = null;
	/* Column Info */
	private String calcDt = null;
	/* Column Info */
	private String partialMark = null;
	/* Column Info */
	private String arCurrCd = null;
	/* Column Info */
	private String svcProvdrNm = null;
	/* Column Info */
	private String dmdtChgStsDesc = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String arActCd = null;
	/* Column Info */
	private String ftCmncDt = null;
	/* Column Info */
	private String mvmtUmchSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String webCreUsrId = null;
	/* Column Info */
	private String rollOvr = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String cntrInvAmt = null;
	/* Column Info */
	private String detFtEndDt = null;
	/* Column Info */
	private String toMvmtYr = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String rfaExptMapgSeq = null;
	/* Column Info */
	private String payerNm = null;
	/* Column Info */
	private String webNtfyPicNm = null;
	/* Column Info */
	private String rfaExptVerSeq = null;
	/* Column Info */
	private String webIndFlg = null;
	/* Column Info */
	private String chgType = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String fmMvmtStsCd = null;
	/* Column Info */
	private String invChgAmt = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String dmdtInvNo = null;
	/* Column Info */
	private String fmMvmtSeq = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String ntfyCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String toMvmtSplitNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String fmMvmtSplitNo = null;
	/* Column Info */
	private String invDtlSeq = null;
	/* Column Info */
	private String rdTermCd = null;
	/* Column Info */
	private String orgChgAmt = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bzcTrfCurrCd = null;
	/* Column Info */
	private String fmMvmtYr = null;
	/* Column Info */
	private String dmdtChgDeltRsnCd = null;
	/* Column Info */
	private String scExptVerSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mtDt = null;
	/* Column Info */
	private String fxFtOvrDys = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rfaExptDarNo = null;
	/* Column Info */
	private String shipperCd = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String toMvmtSeq = null;
	/* Column Info */
	private String xcldFlgs = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String detFtOvrDys = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String rlseDt = null;
	/* Column Info */
	private String li = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String dO = null;
	/* Column Info */
	private String acust = null;
	/* Column Info */
	private String cxlBkgChgFlg = null;
	/* Column Info */
	private String ch = null;
	/* Column Info */
	private String dmdtBkgCgoTpCd = null;
	/* Column Info */
	private String bzcTrfSeq = null;
	/* Column Info */
	private String dmdtArIfCd = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String graceEndDt = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String scRfaExptAmt = null;
	/* Column Info */
	private String rfaExptAproNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String bilAmt = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actCntCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String rfaRqstDtlSeq = null;
	/* Column Info */
	private String bzcTrfGrpSeq = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String webNtfyPicTelcmNo = null;
	/* Column Info */
	private String ofcRhqCd = null;
	/* Column Info */
	private String fmMvmtYdCd = null;
	/* Column Info */
	private String toMvmtStsCd = null;
	/* Column Info */
	private String dmdtCntrTpCd = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String scExptGrpSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String svcProvdrCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String cfmOfcCd = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String webMtyDt = null;
	/* Column Info */
	private String webCancelFlg = null;
	/* Column Info */
	private String orgFtOvrDys = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String bkgDeTermCd = null;
	/* Column Info */
	private String toMvmtYdCd = null;
	/* Column Info */
	private String genBal = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String deltSeq = null;
	/* Column Info */
	private String deltRsnDesc = null;
	/* Column Info */
	private String dmdtDeltRqstStsCd = null;  
	/* Column Info */
	private String exptCntrTeuKnt = null;
	/* Column Info */
	private String incurCntrTeuKnt = null;
	/* Column Info */
	private String incurAmt = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String exptCostAmt = null;
	/* Column Info */
	private String exptQty = null;
	/* Column Info */
	private String incurQty = null;
	/* Column Info */
	private String exptDys = null;
	/* Column Info */
	private String bkgCntrTeu = null;
	/* Column Info */
	private String arIfDt = null;
	/* Column Info */
	private String opBkgNo = null;
	/* Column Info */
	private String uclmFlg = null;
	/* Column Number */
	private String bzcDmdtDeTermCd = null;
	/* Column Number */
	private String bzcDmdtDeTermNm = null;
	/* Column Number */
	private String notCreBalFlg = null;
	/* Column Number */
	private String ovrDue = null;
	/* Column Info */
	private String bzcTrfAplyDt = null;
	/* Column Info */
	private String scRfaExptAplyDt = null;
	/* Column Number */
	private String fmMvmtDtTime = null;
	/* Column Number */
	private String toMvmtDtTime = null;
		
	/* Column Info */
	private String ctrtCustNm = null;
	/* Column Info */
	private String ctrtCustCd = null;
	/* Column Info */
	private String ctrtSrepCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String ibSrepCd = null;
	/* Column Info */
	private String ibSlsOfcCd = null;
	/* Column Info */
	private String svcScpCd = null;
		
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeCalculationContainerVO() {}

	public ChargeCalculationContainerVO(String ibflag, String pagerows, String svrId, String dmdtChgStsCd, String cntrNo, String cntrTpszCd, String fmMvmtYdCd, String toMvmtYdCd, String fmMvmtStsCd, String toMvmtStsCd, String dmdtTrfCd, String ftDys, String fxFtOvrDys, String orgFtOvrDys, String fmMvmtDt, String toMvmtDt, String ftCmncDt, String ftEndDt, String bzcTrfCurrCd, String orgChgAmt, String scRfaExptAmt, String aftExptDcAmt, String bilAmt, String bkgNo, String blNo, String vvdCd, String lane, String porCd, String polCd, String podCd, String delCd, String bkgRcvTermCd, String bkgDeTermCd, String scNo, String rfaNo, String acust, String chgType, String chgSeq, String socFlg, String li, String ch, String dO, String rlseOfc, String cltOfcCd, String ofcTrnsFlg, String rollOvr, String webIndFlg, String cntrCycNo, String dmdtChgLocDivCd, String ofcCd, String ofcRhqCd, String payerCd, String payerNm, String shipperCd, String shipperNm, String cneeCd, String cneeNm, String ntfyCd, String ntfyNm, String arActCd, String arActNm, String svcProvdrCd, String svcProvdrNm, String arCurrCd, String dmdtChgStsDesc, String dmdtInvNo, String issDt, String invChgAmt, String dmdtArIfCd, String webCreDt, String webMtyDt, String webNtfyPicNm, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String preRlyPortCd, String pstRlyPortCd, String rdTermCd, String cmdtCd, String cmdtNm, String repCmdtCd, String repCmdtNm, String slsOfcCd, String dmdtCntrTpCd, String dmdtBkgCgoTpCd, String dmdtTrfAplyTpCd, String bzcTrfSeq, String bzcTrfGrpSeq, String rfaExptDarNo, String rfaExptMapgSeq, String rfaExptVerSeq, String rfaRqstDtlSeq, String scExptVerSeq, String scExptGrpSeq, String xcldFlgs, String corrRmk, String mtDt, String cntrInvAmt, String dmdtChgDeltRsnCd, String usrId, String invDtlSeq, String partialMark, String mvmtUmchSeq, String fmMvmtYr, String fmMvmtSeq, String fmMvmtSplitNo, String toMvmtYr, String toMvmtSeq, String toMvmtSplitNo, String rfaExptAproNo, String aftExptAproNo, String aftExptDarNo, String aftExptAdjSeq, String cfmDt, String cfmUsrId, String cfmOfcCd, String creDt, String creUsrId, String calcDt, String webCreUsrId, String webNtfyPicTelcmNo, String custCntCd, String actCustSeq, String creOfcCd, String rlseDt, String custSeq, String actCntCd, String vslCd, String skdVoyNo, String skdDirCd, String ioBndCd, String webCancelFlg, String seq, String cnt, String graceEndDt, String invXchRt, String invCurrCd, String demFtEndDt, String detFtEndDt, String detFtOvrDys, String dulTpExptFlg, String cxlBkgChgFlg, String genBal, String rqstUsrId, String rqstOfcCd, String rqstDt, String deltSeq, String deltRsnDesc, String dmdtDeltRqstStsCd, String bkgQty, String incurQty, String incurCntrTeuKnt, String exptQty, String exptCntrTeuKnt, String incurAmt, String exptDys, String exptCostAmt, String bkgCntrTeu, String arIfDt, String opBkgNo, String uclmFlg, String bzcDmdtDeTermCd, String bzcDmdtDeTermNm, String notCreBalFlg, String ovrDue, String bzcTrfAplyDt, String scRfaExptAplyDt, String fmMvmtDtTime, String toMvmtDtTime
			, String ctrtCustNm, String ctrtCustCd, String ctrtSrepCd, String ctrtOfcCd, String obSrepCd, String obSlsOfcCd, String ibSrepCd, String ibSlsOfcCd, String svcScpCd) {
		this.cneeCd = cneeCd;
		this.corrRmk = corrRmk;
		this.dulTpExptFlg = dulTpExptFlg;
		this.webCreDt = webCreDt;
		this.ofcTrnsFlg = ofcTrnsFlg;
		this.aftExptDcAmt = aftExptDcAmt;
		this.cltOfcCd = cltOfcCd;
		this.aftExptAdjSeq = aftExptAdjSeq;
		this.dmdtTrfAplyTpCd = dmdtTrfAplyTpCd;
		this.demFtEndDt = demFtEndDt;
		this.pagerows = pagerows;
		this.vvdCd = vvdCd;
		this.shipperNm = shipperNm;
		this.cntrTpszCd = cntrTpszCd;
		this.slsOfcCd = slsOfcCd;
		this.arActNm = arActNm;
		this.invXchRt = invXchRt;
		this.custCntCd = custCntCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.payerCd = payerCd;
		this.aftExptAproNo = aftExptAproNo;
		this.rlseOfc = rlseOfc;
		this.calcDt = calcDt;
		this.partialMark = partialMark;
		this.arCurrCd = arCurrCd;
		this.svcProvdrNm = svcProvdrNm;
		this.dmdtChgStsDesc = dmdtChgStsDesc;
		this.skdVoyNo = skdVoyNo;
		this.arActCd = arActCd;
		this.ftCmncDt = ftCmncDt;
		this.mvmtUmchSeq = mvmtUmchSeq;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.fmMvmtDt = fmMvmtDt;
		this.webCreUsrId = webCreUsrId;
		this.rollOvr = rollOvr;
		this.cntrCycNo = cntrCycNo;
		this.cntrInvAmt = cntrInvAmt;
		this.detFtEndDt = detFtEndDt;
		this.toMvmtYr = toMvmtYr;
		this.issDt = issDt;
		this.aftExptDarNo = aftExptDarNo;
		this.dmdtChgStsCd = dmdtChgStsCd;
		this.usrId = usrId;
		this.cmdtCd = cmdtCd;
		this.rfaExptMapgSeq = rfaExptMapgSeq;
		this.payerNm = payerNm;
		this.webNtfyPicNm = webNtfyPicNm;
		this.rfaExptVerSeq = rfaExptVerSeq;
		this.webIndFlg = webIndFlg;
		this.chgType = chgType;
		this.cnt = cnt;
		this.fmMvmtStsCd = fmMvmtStsCd;
		this.invChgAmt = invChgAmt;
		this.actCustSeq = actCustSeq;
		this.dmdtInvNo = dmdtInvNo;
		this.fmMvmtSeq = fmMvmtSeq;
		this.ntfyNm = ntfyNm;
		this.ntfyCd = ntfyCd;
		this.ofcCd = ofcCd;
		this.cneeNm = cneeNm;
		this.toMvmtSplitNo = toMvmtSplitNo;
		this.cntrNo = cntrNo;
		this.fmMvmtSplitNo = fmMvmtSplitNo;
		this.invDtlSeq = invDtlSeq;
		this.rdTermCd = rdTermCd;
		this.orgChgAmt = orgChgAmt;
		this.repCmdtCd = repCmdtCd;
		this.vslCd = vslCd;
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		this.fmMvmtYr = fmMvmtYr;
		this.dmdtChgDeltRsnCd = dmdtChgDeltRsnCd;
		this.scExptVerSeq = scExptVerSeq;
		this.blNo = blNo;
		this.mtDt = mtDt;
		this.fxFtOvrDys = fxFtOvrDys;
		this.polCd = polCd;
		this.scNo = scNo;
		this.rfaExptDarNo = rfaExptDarNo;
		this.shipperCd = shipperCd;
		this.cfmUsrId = cfmUsrId;
		this.toMvmtSeq = toMvmtSeq;
		this.xcldFlgs = xcldFlgs;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.detFtOvrDys = detFtOvrDys;
		this.vpsEtdDt = vpsEtdDt;
		this.preRlyPortCd = preRlyPortCd;
		this.repCmdtNm = repCmdtNm;
		this.cfmDt = cfmDt;
		this.delCd = delCd;
		this.rlseDt = rlseDt;
		this.li = li;
		this.creUsrId = creUsrId;
		this.dO = dO;
		this.acust = acust;
		this.cxlBkgChgFlg = cxlBkgChgFlg;
		this.ch = ch;
		this.dmdtBkgCgoTpCd = dmdtBkgCgoTpCd;
		this.bzcTrfSeq = bzcTrfSeq;
		this.dmdtArIfCd = dmdtArIfCd;
		this.pstRlyPortCd = pstRlyPortCd;
		this.graceEndDt = graceEndDt;
		this.porCd = porCd;
		this.vpsEtbDt = vpsEtbDt;
		this.scRfaExptAmt = scRfaExptAmt;
		this.rfaExptAproNo = rfaExptAproNo;
		this.creDt = creDt;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.chgSeq = chgSeq;
		this.bilAmt = bilAmt;
		this.vpsEtaDt = vpsEtaDt;
		this.lane = lane;
		this.rfaNo = rfaNo;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.actCntCd = actCntCd;
		this.creOfcCd = creOfcCd;
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
		this.bzcTrfGrpSeq = bzcTrfGrpSeq;
		this.ftEndDt = ftEndDt;
		this.toMvmtDt = toMvmtDt;
		this.webNtfyPicTelcmNo = webNtfyPicTelcmNo;
		this.ofcRhqCd = ofcRhqCd;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.toMvmtStsCd = toMvmtStsCd;
		this.dmdtCntrTpCd = dmdtCntrTpCd;
		this.invCurrCd = invCurrCd;
		this.ioBndCd = ioBndCd;
		this.custSeq = custSeq;
		this.scExptGrpSeq = scExptGrpSeq;
		this.skdDirCd = skdDirCd;
		this.svcProvdrCd = svcProvdrCd;
		this.cmdtNm = cmdtNm;
		this.socFlg = socFlg;
		this.cfmOfcCd = cfmOfcCd;
		this.ftDys = ftDys;
		this.webMtyDt = webMtyDt;
		this.webCancelFlg = webCancelFlg;
		this.orgFtOvrDys = orgFtOvrDys;
		this.seq = seq;
		this.bkgDeTermCd = bkgDeTermCd;
		this.toMvmtYdCd = toMvmtYdCd;
		this.genBal = genBal;
		this.rqstUsrId = rqstUsrId;
		this.rqstDt = rqstDt;
		this.rqstOfcCd = rqstOfcCd;
		this.deltSeq = deltSeq; 
		this.deltRsnDesc = deltRsnDesc;
		this.dmdtDeltRqstStsCd = dmdtDeltRqstStsCd;
		this.exptCntrTeuKnt = exptCntrTeuKnt;
		this.incurCntrTeuKnt = incurCntrTeuKnt;
		this.incurAmt = incurAmt;
		this.bkgQty = bkgQty;
		this.exptCostAmt = exptCostAmt;
		this.exptQty = exptQty;
		this.incurQty = incurQty;
		this.exptDys = exptDys;
		this.bkgCntrTeu = bkgCntrTeu;
		this.arIfDt = arIfDt;
		this.opBkgNo = opBkgNo;
		this.uclmFlg = uclmFlg;
		this.bzcDmdtDeTermCd = bzcDmdtDeTermCd;
		this.bzcDmdtDeTermNm = bzcDmdtDeTermNm;
		this.notCreBalFlg = notCreBalFlg;
		this.ovrDue = ovrDue;
		this.bzcTrfAplyDt = bzcTrfAplyDt;
		this.scRfaExptAplyDt = scRfaExptAplyDt;
		this.fmMvmtDtTime = fmMvmtDtTime;
		this.toMvmtDtTime = toMvmtDtTime;
		
		this.ctrtCustNm = ctrtCustNm;
		this.ctrtCustCd = ctrtCustCd;
		this.ctrtSrepCd = ctrtSrepCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.obSrepCd = obSrepCd;
		this.obSlsOfcCd = obSlsOfcCd;
		this.ibSrepCd = ibSrepCd;
		this.ibSlsOfcCd = ibSlsOfcCd;
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("corr_rmk", getCorrRmk());
		this.hashColumns.put("dul_tp_expt_flg", getDulTpExptFlg());
		this.hashColumns.put("web_cre_dt", getWebCreDt());
		this.hashColumns.put("ofc_trns_flg", getOfcTrnsFlg());
		this.hashColumns.put("aft_expt_dc_amt", getAftExptDcAmt());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("aft_expt_adj_seq", getAftExptAdjSeq());
		this.hashColumns.put("dmdt_trf_aply_tp_cd", getDmdtTrfAplyTpCd());
		this.hashColumns.put("dem_ft_end_dt", getDemFtEndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("shipper_nm", getShipperNm());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("ar_act_nm", getArActNm());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("payer_cd", getPayerCd());
		this.hashColumns.put("aft_expt_apro_no", getAftExptAproNo());
		this.hashColumns.put("rlse_ofc", getRlseOfc());
		this.hashColumns.put("calc_dt", getCalcDt());
		this.hashColumns.put("partial_mark", getPartialMark());
		this.hashColumns.put("ar_curr_cd", getArCurrCd());
		this.hashColumns.put("svc_provdr_nm", getSvcProvdrNm());
		this.hashColumns.put("dmdt_chg_sts_desc", getDmdtChgStsDesc());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ar_act_cd", getArActCd());
		this.hashColumns.put("ft_cmnc_dt", getFtCmncDt());
		this.hashColumns.put("mvmt_umch_seq", getMvmtUmchSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("web_cre_usr_id", getWebCreUsrId());
		this.hashColumns.put("roll_ovr", getRollOvr());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("cntr_inv_amt", getCntrInvAmt());
		this.hashColumns.put("det_ft_end_dt", getDetFtEndDt());
		this.hashColumns.put("to_mvmt_yr", getToMvmtYr());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("rfa_expt_mapg_seq", getRfaExptMapgSeq());
		this.hashColumns.put("payer_nm", getPayerNm());
		this.hashColumns.put("web_ntfy_pic_nm", getWebNtfyPicNm());
		this.hashColumns.put("rfa_expt_ver_seq", getRfaExptVerSeq());
		this.hashColumns.put("web_ind_flg", getWebIndFlg());
		this.hashColumns.put("chg_type", getChgType());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
		this.hashColumns.put("inv_chg_amt", getInvChgAmt());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
		this.hashColumns.put("fm_mvmt_seq", getFmMvmtSeq());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("ntfy_cd", getNtfyCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("to_mvmt_split_no", getToMvmtSplitNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("fm_mvmt_split_no", getFmMvmtSplitNo());
		this.hashColumns.put("inv_dtl_seq", getInvDtlSeq());
		this.hashColumns.put("rd_term_cd", getRdTermCd());
		this.hashColumns.put("org_chg_amt", getOrgChgAmt());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
		this.hashColumns.put("fm_mvmt_yr", getFmMvmtYr());
		this.hashColumns.put("dmdt_chg_delt_rsn_cd", getDmdtChgDeltRsnCd());
		this.hashColumns.put("sc_expt_ver_seq", getScExptVerSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mt_dt", getMtDt());
		this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rfa_expt_dar_no", getRfaExptDarNo());
		this.hashColumns.put("shipper_cd", getShipperCd());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("to_mvmt_seq", getToMvmtSeq());
		this.hashColumns.put("xcld_flgs", getXcldFlgs());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("det_ft_ovr_dys", getDetFtOvrDys());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("rlse_dt", getRlseDt());
		this.hashColumns.put("li", getLi());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("d_o", getDO());
		this.hashColumns.put("acust", getAcust());
		this.hashColumns.put("cxl_bkg_chg_flg", getCxlBkgChgFlg());
		this.hashColumns.put("ch", getCh());
		this.hashColumns.put("dmdt_bkg_cgo_tp_cd", getDmdtBkgCgoTpCd());
		this.hashColumns.put("bzc_trf_seq", getBzcTrfSeq());
		this.hashColumns.put("dmdt_ar_if_cd", getDmdtArIfCd());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("grace_end_dt", getGraceEndDt());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("sc_rfa_expt_amt", getScRfaExptAmt());
		this.hashColumns.put("rfa_expt_apro_no", getRfaExptAproNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_cnt_cd", getActCntCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("rfa_rqst_dtl_seq", getRfaRqstDtlSeq());
		this.hashColumns.put("bzc_trf_grp_seq", getBzcTrfGrpSeq());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("web_ntfy_pic_telcm_no", getWebNtfyPicTelcmNo());
		this.hashColumns.put("ofc_rhq_cd", getOfcRhqCd());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("to_mvmt_sts_cd", getToMvmtStsCd());
		this.hashColumns.put("dmdt_cntr_tp_cd", getDmdtCntrTpCd());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("sc_expt_grp_seq", getScExptGrpSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("svc_provdr_cd", getSvcProvdrCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("cfm_ofc_cd", getCfmOfcCd());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("web_mty_dt", getWebMtyDt());
		this.hashColumns.put("web_cancel_flg", getWebCancelFlg());
		this.hashColumns.put("org_ft_ovr_dys", getOrgFtOvrDys());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("to_mvmt_yd_cd", getToMvmtYdCd());
		this.hashColumns.put("gen_bal", getGenBal());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("delt_seq", getDeltSeq());
		this.hashColumns.put("delt_rsn_desc", getDeltRsnDesc());
		this.hashColumns.put("dmdt_delt_rqst_sts_cd", getDmdtDeltRqstStsCd());
		this.hashColumns.put("expt_cntr_teu_knt", getExptCntrTeuKnt());
		this.hashColumns.put("incur_cntr_teu_knt", getIncurCntrTeuKnt());
		this.hashColumns.put("incur_amt", getIncurAmt());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("expt_cost_amt", getExptCostAmt());
		this.hashColumns.put("expt_qty", getExptQty());
		this.hashColumns.put("incur_qty", getIncurQty());
		this.hashColumns.put("expt_dys", getExptDys());
		this.hashColumns.put("bkg_cntr_teu", getBkgCntrTeu());
		this.hashColumns.put("ar_if_dt", getArIfDt());
		this.hashColumns.put("op_bkg_no", getOpBkgNo());
		this.hashColumns.put("uclm_flg", getUclmFlg());
		this.hashColumns.put("bzc_dmdt_de_term_cd", getBzcDmdtDeTermCd());
		this.hashColumns.put("bzc_dmdt_de_term_nm", getBzcDmdtDeTermNm());
		this.hashColumns.put("not_cre_bal_flg", getNotCreBalFlg());
		this.hashColumns.put("ovr_due", getOvrDue());
		this.hashColumns.put("bzc_trf_aply_dt", getBzcTrfAplyDt());
		this.hashColumns.put("sc_rfa_expt_aply_dt", getScRfaExptAplyDt());
		this.hashColumns.put("fm_mvmt_dt_time", getFmMvmtDtTime());
		this.hashColumns.put("to_mvmt_dt_time", getToMvmtDtTime());
		
		this.hashColumns.put("ctrt_cust_nm", getCtrtCustNm());
		this.hashColumns.put("ctrt_cust_cd", getCtrtCustCd());
		this.hashColumns.put("ctrt_srep_cd", getCtrtSrepCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("ib_srep_cd", getIbSrepCd());
		this.hashColumns.put("ib_sls_ofc_cd", getIbSlsOfcCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("corr_rmk", "corrRmk");
		this.hashFields.put("dul_tp_expt_flg", "dulTpExptFlg");
		this.hashFields.put("web_cre_dt", "webCreDt");
		this.hashFields.put("ofc_trns_flg", "ofcTrnsFlg");
		this.hashFields.put("aft_expt_dc_amt", "aftExptDcAmt");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("aft_expt_adj_seq", "aftExptAdjSeq");
		this.hashFields.put("dmdt_trf_aply_tp_cd", "dmdtTrfAplyTpCd");
		this.hashFields.put("dem_ft_end_dt", "demFtEndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("shipper_nm", "shipperNm");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("ar_act_nm", "arActNm");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("payer_cd", "payerCd");
		this.hashFields.put("aft_expt_apro_no", "aftExptAproNo");
		this.hashFields.put("rlse_ofc", "rlseOfc");
		this.hashFields.put("calc_dt", "calcDt");
		this.hashFields.put("partial_mark", "partialMark");
		this.hashFields.put("ar_curr_cd", "arCurrCd");
		this.hashFields.put("svc_provdr_nm", "svcProvdrNm");
		this.hashFields.put("dmdt_chg_sts_desc", "dmdtChgStsDesc");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ar_act_cd", "arActCd");
		this.hashFields.put("ft_cmnc_dt", "ftCmncDt");
		this.hashFields.put("mvmt_umch_seq", "mvmtUmchSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("web_cre_usr_id", "webCreUsrId");
		this.hashFields.put("roll_ovr", "rollOvr");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("cntr_inv_amt", "cntrInvAmt");
		this.hashFields.put("det_ft_end_dt", "detFtEndDt");
		this.hashFields.put("to_mvmt_yr", "toMvmtYr");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("rfa_expt_mapg_seq", "rfaExptMapgSeq");
		this.hashFields.put("payer_nm", "payerNm");
		this.hashFields.put("web_ntfy_pic_nm", "webNtfyPicNm");
		this.hashFields.put("rfa_expt_ver_seq", "rfaExptVerSeq");
		this.hashFields.put("web_ind_flg", "webIndFlg");
		this.hashFields.put("chg_type", "chgType");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
		this.hashFields.put("inv_chg_amt", "invChgAmt");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
		this.hashFields.put("fm_mvmt_seq", "fmMvmtSeq");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("ntfy_cd", "ntfyCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("to_mvmt_split_no", "toMvmtSplitNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("fm_mvmt_split_no", "fmMvmtSplitNo");
		this.hashFields.put("inv_dtl_seq", "invDtlSeq");
		this.hashFields.put("rd_term_cd", "rdTermCd");
		this.hashFields.put("org_chg_amt", "orgChgAmt");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
		this.hashFields.put("fm_mvmt_yr", "fmMvmtYr");
		this.hashFields.put("dmdt_chg_delt_rsn_cd", "dmdtChgDeltRsnCd");
		this.hashFields.put("sc_expt_ver_seq", "scExptVerSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mt_dt", "mtDt");
		this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rfa_expt_dar_no", "rfaExptDarNo");
		this.hashFields.put("shipper_cd", "shipperCd");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("to_mvmt_seq", "toMvmtSeq");
		this.hashFields.put("xcld_flgs", "xcldFlgs");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("det_ft_ovr_dys", "detFtOvrDys");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("rlse_dt", "rlseDt");
		this.hashFields.put("li", "li");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("d_o", "dO");
		this.hashFields.put("acust", "acust");
		this.hashFields.put("cxl_bkg_chg_flg", "cxlBkgChgFlg");
		this.hashFields.put("ch", "ch");
		this.hashFields.put("dmdt_bkg_cgo_tp_cd", "dmdtBkgCgoTpCd");
		this.hashFields.put("bzc_trf_seq", "bzcTrfSeq");
		this.hashFields.put("dmdt_ar_if_cd", "dmdtArIfCd");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("grace_end_dt", "graceEndDt");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("sc_rfa_expt_amt", "scRfaExptAmt");
		this.hashFields.put("rfa_expt_apro_no", "rfaExptAproNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_cnt_cd", "actCntCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("rfa_rqst_dtl_seq", "rfaRqstDtlSeq");
		this.hashFields.put("bzc_trf_grp_seq", "bzcTrfGrpSeq");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("web_ntfy_pic_telcm_no", "webNtfyPicTelcmNo");
		this.hashFields.put("ofc_rhq_cd", "ofcRhqCd");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("to_mvmt_sts_cd", "toMvmtStsCd");
		this.hashFields.put("dmdt_cntr_tp_cd", "dmdtCntrTpCd");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("sc_expt_grp_seq", "scExptGrpSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("svc_provdr_cd", "svcProvdrCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("cfm_ofc_cd", "cfmOfcCd");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("web_mty_dt", "webMtyDt");
		this.hashFields.put("web_cancel_flg", "webCancelFlg");
		this.hashFields.put("org_ft_ovr_dys", "orgFtOvrDys");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("to_mvmt_yd_cd", "toMvmtYdCd");
		this.hashFields.put("gen_bal", "genBal");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");	
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("delt_seq", "deltSeq");
		this.hashFields.put("delt_rsn_desc", "deltRsnDesc");
		this.hashFields.put("dmdt_delt_rqst_sts_cd", "dmdtDeltRqstStsCd");
		this.hashFields.put("expt_cntr_teu_knt", "exptCntrTeuKnt");
		this.hashFields.put("incur_cntr_teu_knt", "incurCntrTeuKnt");
		this.hashFields.put("incur_amt", "incurAmt");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("expt_cost_amt", "exptCostAmt");
		this.hashFields.put("expt_qty", "exptQty");
		this.hashFields.put("incur_qty", "incurQty");
		this.hashFields.put("expt_dys", "exptDys");
		this.hashFields.put("bkg_cntr_teu", "bkgCntrTeu");
		this.hashFields.put("ar_if_dt", "arIfDt");
		this.hashFields.put("op_bkg_no", "opBkgNo");
		this.hashFields.put("uclm_flg", "uclmFlg");
		this.hashFields.put("bzc_dmdt_de_term_cd", "bzcDmdtDeTermCd");
		this.hashFields.put("bzc_dmdt_de_term_nm", "bzcDmdtDeTermNm");
		this.hashFields.put("not_cre_bal_flg", "notCreBalFlg");
		this.hashFields.put("ovr_due", "ovrDue");
		this.hashFields.put("bzc_trf_aply_dt", "bzcTrfAplyDt");
		this.hashFields.put("sc_rfa_expt_aply_dt", "scRfaExptAplyDt");
		this.hashFields.put("fm_mvmt_dt_time", "fmMvmtDtTime");
		this.hashFields.put("to_mvmt_dt_time", "toMvmtDtTime");

		this.hashFields.put("ctrt_cust_nm", "ctrtCustNm");
		this.hashFields.put("ctrt_cust_cd", "ctrtCustCd");
		this.hashFields.put("ctrt_srep_cd", "ctrtSrepCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("ib_srep_cd", "ibSrepCd");
		this.hashFields.put("ib_sls_ofc_cd", "ibSlsOfcCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cneeCd
	 */
	public String getCneeCd() {
		return this.cneeCd;
	}
	
	/**
	 * Column Info
	 * @return corrRmk
	 */
	public String getCorrRmk() {
		return this.corrRmk;
	}
	
	/**
	 * Column Info
	 * @return dulTpExptFlg
	 */
	public String getDulTpExptFlg() {
		return this.dulTpExptFlg;
	}
	
	/**
	 * Column Info
	 * @return webCreDt
	 */
	public String getWebCreDt() {
		return this.webCreDt;
	}
	
	/**
	 * Column Info
	 * @return ofcTrnsFlg
	 */
	public String getOfcTrnsFlg() {
		return this.ofcTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @return aftExptDcAmt
	 */
	public String getAftExptDcAmt() {
		return this.aftExptDcAmt;
	}
	
	/**
	 * Column Info
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return aftExptAdjSeq
	 */
	public String getAftExptAdjSeq() {
		return this.aftExptAdjSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfAplyTpCd
	 */
	public String getDmdtTrfAplyTpCd() {
		return this.dmdtTrfAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @return demFtEndDt
	 */
	public String getDemFtEndDt() {
		return this.demFtEndDt;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return shipperNm
	 */
	public String getShipperNm() {
		return this.shipperNm;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return arActNm
	 */
	public String getArActNm() {
		return this.arActNm;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
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
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return payerCd
	 */
	public String getPayerCd() {
		return this.payerCd;
	}
	
	/**
	 * Column Info
	 * @return aftExptAproNo
	 */
	public String getAftExptAproNo() {
		return this.aftExptAproNo;
	}
	
	/**
	 * Column Info
	 * @return rlseOfc
	 */
	public String getRlseOfc() {
		return this.rlseOfc;
	}
	
	/**
	 * Column Info
	 * @return calcDt
	 */
	public String getCalcDt() {
		return this.calcDt;
	}
	
	/**
	 * Column Info
	 * @return partialMark
	 */
	public String getPartialMark() {
		return this.partialMark;
	}
	
	/**
	 * Column Info
	 * @return arCurrCd
	 */
	public String getArCurrCd() {
		return this.arCurrCd;
	}
	
	/**
	 * Column Info
	 * @return svcProvdrNm
	 */
	public String getSvcProvdrNm() {
		return this.svcProvdrNm;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgStsDesc
	 */
	public String getDmdtChgStsDesc() {
		return this.dmdtChgStsDesc;
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
	 * @return arActCd
	 */
	public String getArActCd() {
		return this.arActCd;
	}
	
	/**
	 * Column Info
	 * @return ftCmncDt
	 */
	public String getFtCmncDt() {
		return this.ftCmncDt;
	}
	
	/**
	 * Column Info
	 * @return mvmtUmchSeq
	 */
	public String getMvmtUmchSeq() {
		return this.mvmtUmchSeq;
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
	 * @return fmMvmtDt
	 */
	public String getFmMvmtDt() {
		return this.fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return webCreUsrId
	 */
	public String getWebCreUsrId() {
		return this.webCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return rollOvr
	 */
	public String getRollOvr() {
		return this.rollOvr;
	}
	
	/**
	 * Column Info
	 * @return cntrCycNo
	 */
	public String getCntrCycNo() {
		return this.cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @return cntrInvAmt
	 */
	public String getCntrInvAmt() {
		return this.cntrInvAmt;
	}
	
	/**
	 * Column Info
	 * @return detFtEndDt
	 */
	public String getDetFtEndDt() {
		return this.detFtEndDt;
	}
	
	/**
	 * Column Info
	 * @return toMvmtYr
	 */
	public String getToMvmtYr() {
		return this.toMvmtYr;
	}
	
	/**
	 * Column Info
	 * @return bzcDmdtDeTermCd
	 */
	public String getBzcDmdtDeTermCd() {
		return this.bzcDmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return bzcDmdtDeTermNm
	 */
	public String getBzcDmdtDeTermNm() {
		return this.bzcDmdtDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return notCreBalFlg
	 */
	public String getNotCreBalFlg() {
		return this.notCreBalFlg;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
	}
	
	/**
	 * Column Info
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgStsCd
	 */
	public String getDmdtChgStsCd() {
		return this.dmdtChgStsCd;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return rfaExptMapgSeq
	 */
	public String getRfaExptMapgSeq() {
		return this.rfaExptMapgSeq;
	}
	
	/**
	 * Column Info
	 * @return payerNm
	 */
	public String getPayerNm() {
		return this.payerNm;
	}
	
	/**
	 * Column Info
	 * @return webNtfyPicNm
	 */
	public String getWebNtfyPicNm() {
		return this.webNtfyPicNm;
	}
	
	/**
	 * Column Info
	 * @return rfaExptVerSeq
	 */
	public String getRfaExptVerSeq() {
		return this.rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return webIndFlg
	 */
	public String getWebIndFlg() {
		return this.webIndFlg;
	}
	
	/**
	 * Column Info
	 * @return chgType
	 */
	public String getChgType() {
		return this.chgType;
	}
	
	/**
	 * Column Info
	 * @return cnt
	 */
	public String getCnt() {
		return this.cnt;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtStsCd
	 */
	public String getFmMvmtStsCd() {
		return this.fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return invChgAmt
	 */
	public String getInvChgAmt() {
		return this.invChgAmt;
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
	 * @return dmdtInvNo
	 */
	public String getDmdtInvNo() {
		return this.dmdtInvNo;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtSeq
	 */
	public String getFmMvmtSeq() {
		return this.fmMvmtSeq;
	}
	
	/**
	 * Column Info
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 * Column Info
	 * @return ntfyCd
	 */
	public String getNtfyCd() {
		return this.ntfyCd;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return toMvmtSplitNo
	 */
	public String getToMvmtSplitNo() {
		return this.toMvmtSplitNo;
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
	 * @return fmMvmtSplitNo
	 */
	public String getFmMvmtSplitNo() {
		return this.fmMvmtSplitNo;
	}
	
	/**
	 * Column Info
	 * @return invDtlSeq
	 */
	public String getInvDtlSeq() {
		return this.invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return rdTermCd
	 */
	public String getRdTermCd() {
		return this.rdTermCd;
	}
	
	/**
	 * Column Info
	 * @return orgChgAmt
	 */
	public String getOrgChgAmt() {
		return this.orgChgAmt;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfCurrCd
	 */
	public String getBzcTrfCurrCd() {
		return this.bzcTrfCurrCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtYr
	 */
	public String getFmMvmtYr() {
		return this.fmMvmtYr;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgDeltRsnCd
	 */
	public String getDmdtChgDeltRsnCd() {
		return this.dmdtChgDeltRsnCd;
	}
	
	/**
	 * Column Info
	 * @return scExptVerSeq
	 */
	public String getScExptVerSeq() {
		return this.scExptVerSeq;
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
	 * @return mtDt
	 */
	public String getMtDt() {
		return this.mtDt;
	}
	
	/**
	 * Column Info
	 * @return fxFtOvrDys
	 */
	public String getFxFtOvrDys() {
		return this.fxFtOvrDys;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return rfaExptDarNo
	 */
	public String getRfaExptDarNo() {
		return this.rfaExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return shipperCd
	 */
	public String getShipperCd() {
		return this.shipperCd;
	}
	
	/**
	 * Column Info
	 * @return cfmUsrId
	 */
	public String getCfmUsrId() {
		return this.cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @return toMvmtSeq
	 */
	public String getToMvmtSeq() {
		return this.toMvmtSeq;
	}
	
	/**
	 * Column Info
	 * @return xcldFlgs
	 */
	public String getXcldFlgs() {
		return this.xcldFlgs;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return detFtOvrDys
	 */
	public String getDetFtOvrDys() {
		return this.detFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @return arIfDt
	 */
	public String getArIfDt() {
		return this.arIfDt;
	}
	
	/**
	 * Column Info
	 * @return opBkgNo
	 */
	public String getOpBkgNo() {
		return this.opBkgNo;
	}
	
	/**
	 * Column Info
	 * @return uclmFlg
	 */
	public String getUclmFlg() {
		return this.uclmFlg;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
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
	 * @return repCmdtNm
	 */
	public String getRepCmdtNm() {
		return this.repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
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
	 * @return rlseDt
	 */
	public String getRlseDt() {
		return this.rlseDt;
	}
	
	/**
	 * Column Info
	 * @return li
	 */
	public String getLi() {
		return this.li;
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
	 * @return dO
	 */
	public String getDO() {
		return this.dO;
	}
	
	/**
	 * Column Info
	 * @return acust
	 */
	public String getAcust() {
		return this.acust;
	}
	
	/**
	 * Column Info
	 * @return cxlBkgChgFlg
	 */
	public String getCxlBkgChgFlg() {
		return this.cxlBkgChgFlg;
	}
	
	/**
	 * Column Info
	 * @return ch
	 */
	public String getCh() {
		return this.ch;
	}
	
	/**
	 * Column Info
	 * @return dmdtBkgCgoTpCd
	 */
	public String getDmdtBkgCgoTpCd() {
		return this.dmdtBkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfSeq
	 */
	public String getBzcTrfSeq() {
		return this.bzcTrfSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtArIfCd
	 */
	public String getDmdtArIfCd() {
		return this.dmdtArIfCd;
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
	 * @return graceEndDt
	 */
	public String getGraceEndDt() {
		return this.graceEndDt;
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
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return scRfaExptAmt
	 */
	public String getScRfaExptAmt() {
		return this.scRfaExptAmt;
	}
	
	/**
	 * Column Info
	 * @return rfaExptAproNo
	 */
	public String getRfaExptAproNo() {
		return this.rfaExptAproNo;
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
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return actCntCd
	 */
	public String getActCntCd() {
		return this.actCntCd;
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
	 * @return rfaRqstDtlSeq
	 */
	public String getRfaRqstDtlSeq() {
		return this.rfaRqstDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfGrpSeq
	 */
	public String getBzcTrfGrpSeq() {
		return this.bzcTrfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return ftEndDt
	 */
	public String getFtEndDt() {
		return this.ftEndDt;
	}
	
	/**
	 * Column Info
	 * @return toMvmtDt
	 */
	public String getToMvmtDt() {
		return this.toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return webNtfyPicTelcmNo
	 */
	public String getWebNtfyPicTelcmNo() {
		return this.webNtfyPicTelcmNo;
	}
	
	/**
	 * Column Info
	 * @return ofcRhqCd
	 */
	public String getOfcRhqCd() {
		return this.ofcRhqCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtYdCd
	 */
	public String getFmMvmtYdCd() {
		return this.fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return toMvmtStsCd
	 */
	public String getToMvmtStsCd() {
		return this.toMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpCd
	 */
	public String getDmdtCntrTpCd() {
		return this.dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return scExptGrpSeq
	 */
	public String getScExptGrpSeq() {
		return this.scExptGrpSeq;
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
	 * @return svcProvdrCd
	 */
	public String getSvcProvdrCd() {
		return this.svcProvdrCd;
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
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return cfmOfcCd
	 */
	public String getCfmOfcCd() {
		return this.cfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ftDys
	 */
	public String getFtDys() {
		return this.ftDys;
	}
	
	/**
	 * Column Info
	 * @return webMtyDt
	 */
	public String getWebMtyDt() {
		return this.webMtyDt;
	}
	
	/**
	 * Column Info
	 * @return webCancelFlg
	 */
	public String getWebCancelFlg() {
		return this.webCancelFlg;
	}
	
	/**
	 * Column Info
	 * @return orgFtOvrDys
	 */
	public String getOrgFtOvrDys() {
		return this.orgFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return bkgDeTermCd
	 */
	public String getBkgDeTermCd() {
		return this.bkgDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return toMvmtYdCd
	 */
	public String getToMvmtYdCd() {
		return this.toMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return genBal
	 */	
	public String getGenBal() {
		return genBal;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */	
	public String getRqstDt() {
		return rqstDt;
	}


	/**
	 * Column Info
	 * @return rqstUsrId
	 */	
	public String getRqstUsrId() {
		return rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */	
	public String getRqstOfcCd() {
		return rqstOfcCd;
	}

	/**
	 * Column Info
	 * @return deltSeq
	 */	
	public String getDeltSeq() {
		return deltSeq;
	}

	/**
	 * Column Info
	 * @return deltRsnDesc
	 */	
	public String getDeltRsnDesc() {
		return deltRsnDesc;
	}
	
	/**
	 * Column Info
	 * @return ovrDue
	 */	
	public String getOvrDue() {
		return ovrDue;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeltRqstStsCd
	 */	
	public String getDmdtDeltRqstStsCd() {
		return dmdtDeltRqstStsCd;
	}

	public String getExptCntrTeuKnt() {
		return exptCntrTeuKnt;
	}
	public String getIncurCntrTeuKnt() {
		return incurCntrTeuKnt;
	}
	public String getIncurAmt() {
		return incurAmt;
	}
	public String getBkgQty() {
		return bkgQty;
	}
	public String getExptCostAmt() {
		return exptCostAmt;
	}
	public String getExptQty() {
		return exptQty;
	}
	public String getIncurQty() {
		return incurQty;
	}
	public String getExptDys() {
		return exptDys;
	}
	
	
	public String getBkgCntrTeu() {
		return bkgCntrTeu;
	}

	/**
	 * Column Info
	 * @return bzcTrfAplyDt
	 */
	public String getBzcTrfAplyDt() {
		return bzcTrfAplyDt;
	}
	
	/**
	 * Column Info
	 * @return scRfaExptAplyDt
	 */
	public String getScRfaExptAplyDt() {
		return scRfaExptAplyDt;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtDtTime
	 */
	public String getFmMvmtDtTime() {
		return fmMvmtDtTime;
	}
	
	/**
	 * Column Info
	 * @return toMvmtDtTime
	 */
	public String getToMvmtDtTime() {
		return toMvmtDtTime;
	}

	/**
	 * Column Info
	 * @return the ctrtCustNm
	 */
	public String getCtrtCustNm() {
		return ctrtCustNm;
	}

	/**
	 * Column Info
	 * @return the ctrtCustCd
	 */
	public String getCtrtCustCd() {
		return ctrtCustCd;
	}

	/**
	 * Column Info
	 * @return the ctrtSrepCd
	 */
	public String getCtrtSrepCd() {
		return ctrtSrepCd;
	}

	/**
	 * Column Info
	 * @return the ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return ctrtOfcCd;
	}

	/**
	 * Column Info
	 * @return the obSrepCd
	 */
	public String getObSrepCd() {
		return obSrepCd;
	}

	/**
	 * Column Info
	 * @return the obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return obSlsOfcCd;
	}

	/**
	 * Column Info
	 * @return the ibSlsOfcCd
	 */
	public String getIbSlsOfcCd() {
		return ibSlsOfcCd;
	}

	/**
	 * Column Info
	 * @return the svcScpCd
	 */
	public String getSvcScpCd() {
		return svcScpCd;
	}

	/**
	 * Column Info
	 * @param ctrtCustNm the ctrtCustNm to set
	 */
	public void setCtrtCustNm(String ctrtCustNm) {
		this.ctrtCustNm = ctrtCustNm;
	}

	/**
	 * Column Info
	 * @param ctrtCustCd the ctrtCustCd to set
	 */
	public void setCtrtCustCd(String ctrtCustCd) {
		this.ctrtCustCd = ctrtCustCd;
	}

	/**
	 * Column Info
	 * @param svcScpCd the svcScpCd to set
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}

	/**
	 * Column Info
	 * @param ibSlsOfcCd the ibSlsOfcCd to set
	 */
	public void setIbSlsOfcCd(String ibSlsOfcCd) {
		this.ibSlsOfcCd = ibSlsOfcCd;
	}

	/**
	 * Column Info
	 * @param ctrtSrepCd the ctrtSrepCd to set
	 */
	public void setCtrtSrepCd(String ctrtSrepCd) {
		this.ctrtSrepCd = ctrtSrepCd;
	}

	/**
	 * Column Info
	 * @param ctrtOfcCd the ctrtOfcCd to set
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}

	/**
	 * Column Info
	 * @param obSrepCd the obSrepCd to set
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}

	/**
	 * Column Info
	 * @param obSlsOfcCd the obSlsOfcCd to set
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cneeCd
	 */
	public void setCneeCd(String cneeCd) {
		this.cneeCd = cneeCd;
	}
	
	/**
	 * Column Info
	 * @param corrRmk
	 */
	public void setCorrRmk(String corrRmk) {
		this.corrRmk = corrRmk;
	}
	
	/**
	 * Column Info
	 * @param dulTpExptFlg
	 */
	public void setDulTpExptFlg(String dulTpExptFlg) {
		this.dulTpExptFlg = dulTpExptFlg;
	}
	
	/**
	 * Column Info
	 * @param webCreDt
	 */
	public void setWebCreDt(String webCreDt) {
		this.webCreDt = webCreDt;
	}
	
	/**
	 * Column Info
	 * @param ofcTrnsFlg
	 */
	public void setOfcTrnsFlg(String ofcTrnsFlg) {
		this.ofcTrnsFlg = ofcTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @param aftExptDcAmt
	 */
	public void setAftExptDcAmt(String aftExptDcAmt) {
		this.aftExptDcAmt = aftExptDcAmt;
	}
	
	/**
	 * Column Info
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param aftExptAdjSeq
	 */
	public void setAftExptAdjSeq(String aftExptAdjSeq) {
		this.aftExptAdjSeq = aftExptAdjSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfAplyTpCd
	 */
	public void setDmdtTrfAplyTpCd(String dmdtTrfAplyTpCd) {
		this.dmdtTrfAplyTpCd = dmdtTrfAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @param demFtEndDt
	 */
	public void setDemFtEndDt(String demFtEndDt) {
		this.demFtEndDt = demFtEndDt;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param shipperNm
	 */
	public void setShipperNm(String shipperNm) {
		this.shipperNm = shipperNm;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param arActNm
	 */
	public void setArActNm(String arActNm) {
		this.arActNm = arActNm;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
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
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param payerCd
	 */
	public void setPayerCd(String payerCd) {
		this.payerCd = payerCd;
	}
	
	/**
	 * Column Info
	 * @param aftExptAproNo
	 */
	public void setAftExptAproNo(String aftExptAproNo) {
		this.aftExptAproNo = aftExptAproNo;
	}
	
	/**
	 * Column Info
	 * @param rlseOfc
	 */
	public void setRlseOfc(String rlseOfc) {
		this.rlseOfc = rlseOfc;
	}
	
	/**
	 * Column Info
	 * @param calcDt
	 */
	public void setCalcDt(String calcDt) {
		this.calcDt = calcDt;
	}
	
	/**
	 * Column Info
	 * @param partialMark
	 */
	public void setPartialMark(String partialMark) {
		this.partialMark = partialMark;
	}
	
	/**
	 * Column Info
	 * @param arCurrCd
	 */
	public void setArCurrCd(String arCurrCd) {
		this.arCurrCd = arCurrCd;
	}
	
	/**
	 * Column Info
	 * @param svcProvdrNm
	 */
	public void setSvcProvdrNm(String svcProvdrNm) {
		this.svcProvdrNm = svcProvdrNm;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgStsDesc
	 */
	public void setDmdtChgStsDesc(String dmdtChgStsDesc) {
		this.dmdtChgStsDesc = dmdtChgStsDesc;
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
	 * @param arActCd
	 */
	public void setArActCd(String arActCd) {
		this.arActCd = arActCd;
	}
	
	/**
	 * Column Info
	 * @param ftCmncDt
	 */
	public void setFtCmncDt(String ftCmncDt) {
		this.ftCmncDt = ftCmncDt;
	}
	
	/**
	 * Column Info
	 * @param mvmtUmchSeq
	 */
	public void setMvmtUmchSeq(String mvmtUmchSeq) {
		this.mvmtUmchSeq = mvmtUmchSeq;
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
	 * @param fmMvmtDt
	 */
	public void setFmMvmtDt(String fmMvmtDt) {
		this.fmMvmtDt = fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param webCreUsrId
	 */
	public void setWebCreUsrId(String webCreUsrId) {
		this.webCreUsrId = webCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param rollOvr
	 */
	public void setRollOvr(String rollOvr) {
		this.rollOvr = rollOvr;
	}
	
	/**
	 * Column Info
	 * @param cntrCycNo
	 */
	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @param cntrInvAmt
	 */
	public void setCntrInvAmt(String cntrInvAmt) {
		this.cntrInvAmt = cntrInvAmt;
	}
	
	/**
	 * Column Info
	 * @param detFtEndDt
	 */
	public void setDetFtEndDt(String detFtEndDt) {
		this.detFtEndDt = detFtEndDt;
	}
	
	/**
	 * Column Info
	 * @param toMvmtYr
	 */
	public void setToMvmtYr(String toMvmtYr) {
		this.toMvmtYr = toMvmtYr;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	
	/**
	 * Column Info
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgStsCd
	 */
	public void setDmdtChgStsCd(String dmdtChgStsCd) {
		this.dmdtChgStsCd = dmdtChgStsCd;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param rfaExptMapgSeq
	 */
	public void setRfaExptMapgSeq(String rfaExptMapgSeq) {
		this.rfaExptMapgSeq = rfaExptMapgSeq;
	}
	
	/**
	 * Column Info
	 * @param payerNm
	 */
	public void setPayerNm(String payerNm) {
		this.payerNm = payerNm;
	}
	
	/**
	 * Column Info
	 * @param webNtfyPicNm
	 */
	public void setWebNtfyPicNm(String webNtfyPicNm) {
		this.webNtfyPicNm = webNtfyPicNm;
	}
	
	/**
	 * Column Info
	 * @param rfaExptVerSeq
	 */
	public void setRfaExptVerSeq(String rfaExptVerSeq) {
		this.rfaExptVerSeq = rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param webIndFlg
	 */
	public void setWebIndFlg(String webIndFlg) {
		this.webIndFlg = webIndFlg;
	}
	
	/**
	 * Column Info
	 * @param chgType
	 */
	public void setChgType(String chgType) {
		this.chgType = chgType;
	}
	
	/**
	 * Column Info
	 * @param cnt
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtStsCd
	 */
	public void setFmMvmtStsCd(String fmMvmtStsCd) {
		this.fmMvmtStsCd = fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param invChgAmt
	 */
	public void setInvChgAmt(String invChgAmt) {
		this.invChgAmt = invChgAmt;
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
	 * @param dmdtInvNo
	 */
	public void setDmdtInvNo(String dmdtInvNo) {
		this.dmdtInvNo = dmdtInvNo;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtSeq
	 */
	public void setFmMvmtSeq(String fmMvmtSeq) {
		this.fmMvmtSeq = fmMvmtSeq;
	}
	
	/**
	 * Column Info
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * Column Info
	 * @param ntfyCd
	 */
	public void setNtfyCd(String ntfyCd) {
		this.ntfyCd = ntfyCd;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param toMvmtSplitNo
	 */
	public void setToMvmtSplitNo(String toMvmtSplitNo) {
		this.toMvmtSplitNo = toMvmtSplitNo;
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
	 * @param fmMvmtSplitNo
	 */
	public void setFmMvmtSplitNo(String fmMvmtSplitNo) {
		this.fmMvmtSplitNo = fmMvmtSplitNo;
	}
	
	/**
	 * Column Info
	 * @param invDtlSeq
	 */
	public void setInvDtlSeq(String invDtlSeq) {
		this.invDtlSeq = invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param rdTermCd
	 */
	public void setRdTermCd(String rdTermCd) {
		this.rdTermCd = rdTermCd;
	}
	
	/**
	 * Column Info
	 * @param orgChgAmt
	 */
	public void setOrgChgAmt(String orgChgAmt) {
		this.orgChgAmt = orgChgAmt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfCurrCd
	 */
	public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtYr
	 */
	public void setFmMvmtYr(String fmMvmtYr) {
		this.fmMvmtYr = fmMvmtYr;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgDeltRsnCd
	 */
	public void setDmdtChgDeltRsnCd(String dmdtChgDeltRsnCd) {
		this.dmdtChgDeltRsnCd = dmdtChgDeltRsnCd;
	}
	
	/**
	 * Column Info
	 * @param scExptVerSeq
	 */
	public void setScExptVerSeq(String scExptVerSeq) {
		this.scExptVerSeq = scExptVerSeq;
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
	 * @param mtDt
	 */
	public void setMtDt(String mtDt) {
		this.mtDt = mtDt;
	}
	
	/**
	 * Column Info
	 * @param fxFtOvrDys
	 */
	public void setFxFtOvrDys(String fxFtOvrDys) {
		this.fxFtOvrDys = fxFtOvrDys;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param rfaExptDarNo
	 */
	public void setRfaExptDarNo(String rfaExptDarNo) {
		this.rfaExptDarNo = rfaExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param shipperCd
	 */
	public void setShipperCd(String shipperCd) {
		this.shipperCd = shipperCd;
	}
	
	/**
	 * Column Info
	 * @param cfmUsrId
	 */
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @param toMvmtSeq
	 */
	public void setToMvmtSeq(String toMvmtSeq) {
		this.toMvmtSeq = toMvmtSeq;
	}
	
	/**
	 * Column Info
	 * @param xcldFlgs
	 */
	public void setXcldFlgs(String xcldFlgs) {
		this.xcldFlgs = xcldFlgs;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param detFtOvrDys
	 */
	public void setDetFtOvrDys(String detFtOvrDys) {
		this.detFtOvrDys = detFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
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
	 * @param repCmdtNm
	 */
	public void setRepCmdtNm(String repCmdtNm) {
		this.repCmdtNm = repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
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
	 * @param rlseDt
	 */
	public void setRlseDt(String rlseDt) {
		this.rlseDt = rlseDt;
	}
	
	/**
	 * Column Info
	 * @param li
	 */
	public void setLi(String li) {
		this.li = li;
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
	 * @param dO
	 */
	public void setDO(String dO) {
		this.dO = dO;
	}
	
	/**
	 * Column Info
	 * @param acust
	 */
	public void setAcust(String acust) {
		this.acust = acust;
	}
	
	/**
	 * Column Info
	 * @param cxlBkgChgFlg
	 */
	public void setCxlBkgChgFlg(String cxlBkgChgFlg) {
		this.cxlBkgChgFlg = cxlBkgChgFlg;
	}
	
	/**
	 * Column Info
	 * @param ch
	 */
	public void setCh(String ch) {
		this.ch = ch;
	}
	
	/**
	 * Column Info
	 * @param dmdtBkgCgoTpCd
	 */
	public void setDmdtBkgCgoTpCd(String dmdtBkgCgoTpCd) {
		this.dmdtBkgCgoTpCd = dmdtBkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfSeq
	 */
	public void setBzcTrfSeq(String bzcTrfSeq) {
		this.bzcTrfSeq = bzcTrfSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtArIfCd
	 */
	public void setDmdtArIfCd(String dmdtArIfCd) {
		this.dmdtArIfCd = dmdtArIfCd;
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
	 * @param graceEndDt
	 */
	public void setGraceEndDt(String graceEndDt) {
		this.graceEndDt = graceEndDt;
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
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param scRfaExptAmt
	 */
	public void setScRfaExptAmt(String scRfaExptAmt) {
		this.scRfaExptAmt = scRfaExptAmt;
	}
	
	/**
	 * Column Info
	 * @param rfaExptAproNo
	 */
	public void setRfaExptAproNo(String rfaExptAproNo) {
		this.rfaExptAproNo = rfaExptAproNo;
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
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param actCntCd
	 */
	public void setActCntCd(String actCntCd) {
		this.actCntCd = actCntCd;
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
	 * @param rfaRqstDtlSeq
	 */
	public void setRfaRqstDtlSeq(String rfaRqstDtlSeq) {
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfGrpSeq
	 */
	public void setBzcTrfGrpSeq(String bzcTrfGrpSeq) {
		this.bzcTrfGrpSeq = bzcTrfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param ftEndDt
	 */
	public void setFtEndDt(String ftEndDt) {
		this.ftEndDt = ftEndDt;
	}
	
	/**
	 * Column Info
	 * @param toMvmtDt
	 */
	public void setToMvmtDt(String toMvmtDt) {
		this.toMvmtDt = toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param webNtfyPicTelcmNo
	 */
	public void setWebNtfyPicTelcmNo(String webNtfyPicTelcmNo) {
		this.webNtfyPicTelcmNo = webNtfyPicTelcmNo;
	}
	
	/**
	 * Column Info
	 * @param ofcRhqCd
	 */
	public void setOfcRhqCd(String ofcRhqCd) {
		this.ofcRhqCd = ofcRhqCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtYdCd
	 */
	public void setFmMvmtYdCd(String fmMvmtYdCd) {
		this.fmMvmtYdCd = fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param toMvmtStsCd
	 */
	public void setToMvmtStsCd(String toMvmtStsCd) {
		this.toMvmtStsCd = toMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpCd
	 */
	public void setDmdtCntrTpCd(String dmdtCntrTpCd) {
		this.dmdtCntrTpCd = dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param scExptGrpSeq
	 */
	public void setScExptGrpSeq(String scExptGrpSeq) {
		this.scExptGrpSeq = scExptGrpSeq;
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
	 * @param svcProvdrCd
	 */
	public void setSvcProvdrCd(String svcProvdrCd) {
		this.svcProvdrCd = svcProvdrCd;
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
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param cfmOfcCd
	 */
	public void setCfmOfcCd(String cfmOfcCd) {
		this.cfmOfcCd = cfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ftDys
	 */
	public void setFtDys(String ftDys) {
		this.ftDys = ftDys;
	}
	
	/**
	 * Column Info
	 * @param webMtyDt
	 */
	public void setWebMtyDt(String webMtyDt) {
		this.webMtyDt = webMtyDt;
	}
	
	/**
	 * Column Info
	 * @param webCancelFlg
	 */
	public void setWebCancelFlg(String webCancelFlg) {
		this.webCancelFlg = webCancelFlg;
	}
	
	/**
	 * Column Info
	 * @param orgFtOvrDys
	 */
	public void setOrgFtOvrDys(String orgFtOvrDys) {
		this.orgFtOvrDys = orgFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param bkgDeTermCd
	 */
	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param toMvmtYdCd
	 */
	public void setToMvmtYdCd(String toMvmtYdCd) {
		this.toMvmtYdCd = toMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return genBal
	 */	
	public void setGenBal(String genBal) {
		this.genBal = genBal;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */	
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	/**
	 * Column Info
	 * @return rqstUsrId
	 */	
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}

	/**
	 * Column Info
	 * @return rqstOfcCd
	 */	
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return deltSeq
	 */	
	public void setDeltSeq(String deltSeq) {
		this.deltSeq = deltSeq;
	}
	
	/**
	 * Column Info
	 * @return deltRsnDesc
	 */	
	public void setDeltRsnDesc(String deltRsnDesc) {
		this.deltRsnDesc = deltRsnDesc;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeltRqstStsCd
	 */
	public void setDmdtDeltRqstStsCd(String dmdtDeltRqstStsCd) {
		this.dmdtDeltRqstStsCd = dmdtDeltRqstStsCd;
	}
	
	public void setExptCntrTeuKnt(String exptCntrTeuKnt) {
		this.exptCntrTeuKnt = exptCntrTeuKnt;
	}

	public void setIncurCntrTeuKnt(String incurCntrTeuKnt) {
		this.incurCntrTeuKnt = incurCntrTeuKnt;
	}

	public void setIncurAmt(String incurAmt) {
		this.incurAmt = incurAmt;
	}

	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}

	public void setExptCostAmt(String exptCostAmt) {
		this.exptCostAmt = exptCostAmt;
	}

	public void setExptQty(String exptQty) {
		this.exptQty = exptQty;
	}

	public void setIncurQty(String incurQty) {
		this.incurQty = incurQty;
	}

	public void setExptDys(String exptDys) {
		this.exptDys = exptDys;
	}
		
    public void setBkgCntrTeu(String bkgCntrTeu) {
		this.bkgCntrTeu = bkgCntrTeu;
	}
    
	/**
	 * Column Info
	 * @return arIfDt
	 */	
	public void setArIfDt(String arIfDt) {
		this.arIfDt = arIfDt;
	}

	/**
	 * Column Info
	 * @return opBkgNo
	 */	
	public void setOpBkgNo(String opBkgNo) {
		this.opBkgNo = opBkgNo;
	}
		
	/**
	 * Column Info
	 * @return uclmFlg
	 */	
	public void setUclmFlg(String uclmFlg) {
		this.uclmFlg = uclmFlg;
	}
	
	/**
	 * Column Info
	 * @param bzcDmdtDeTermCd
	 */
	public void setBzcDmdtDeTermCd(String bzcDmdtDeTermCd) {
		this.bzcDmdtDeTermCd = bzcDmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param bzcDmdtDeTermNm
	 */
	public void setBzcDmdtDeTermNm(String bzcDmdtDeTermNm) {
		this.bzcDmdtDeTermNm = bzcDmdtDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param notCreBalFlg
	 */
	public void setNotCreBalFlg(String notCreBalFlg) {
		this.notCreBalFlg = notCreBalFlg;
	}
	
	/**
	 * Column Info
	 * @param ovrDue
	 */
	public void setOvrDue(String ovrDue) {
		this.ovrDue = ovrDue;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfAplyDt
	 */
	public void setBzcTrfAplyDt(String bzcTrfAplyDt) {
		this.bzcTrfAplyDt = bzcTrfAplyDt;
	}
	
	/**
	 * Column Info
	 * @return scRfaExptAplyDt
	 */
	public void setScRfaExptAplyDt(String scRfaExptAplyDt) {
		this.scRfaExptAplyDt = scRfaExptAplyDt;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtDtTime
	 */
	public void setFmMvmtDtTime(String fmMvmtDtTime) {
		this.fmMvmtDtTime = fmMvmtDtTime;
	}
	
	/**
	 * Column Info
	 * @return toMvmtDtTime
	 */
	public void setToMvmtDtTime(String toMvmtDtTime) {
		this.toMvmtDtTime = toMvmtDtTime;
	}

	public String getIbSrepCd() {
		return ibSrepCd;
	}

	public void setIbSrepCd(String ibSrepCd) {
		this.ibSrepCd = ibSrepCd;
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
		setCneeCd(JSPUtil.getParameter(request, prefix + "cnee_cd", ""));
//		setCorrRmk(JSPUtil.getParameter(request, prefix + "corr_rmk", ""));
		setCorrRmk(request.getParameter(prefix + "corr_rmk"));
		setDulTpExptFlg(JSPUtil.getParameter(request, prefix + "dul_tp_expt_flg", ""));
		setWebCreDt(JSPUtil.getParameter(request, prefix + "web_cre_dt", ""));
		setOfcTrnsFlg(JSPUtil.getParameter(request, prefix + "ofc_trns_flg", ""));
		setAftExptDcAmt(JSPUtil.getParameter(request, prefix + "aft_expt_dc_amt", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setAftExptAdjSeq(JSPUtil.getParameter(request, prefix + "aft_expt_adj_seq", ""));
		setDmdtTrfAplyTpCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_aply_tp_cd", ""));
		setDemFtEndDt(JSPUtil.getParameter(request, prefix + "dem_ft_end_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setShipperNm(JSPUtil.getParameter(request, prefix + "shipper_nm", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setArActNm(JSPUtil.getParameter(request, prefix + "ar_act_nm", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setPayerCd(JSPUtil.getParameter(request, prefix + "payer_cd", ""));
		setAftExptAproNo(JSPUtil.getParameter(request, prefix + "aft_expt_apro_no", ""));
		setRlseOfc(JSPUtil.getParameter(request, prefix + "rlse_ofc", ""));
		setCalcDt(JSPUtil.getParameter(request, prefix + "calc_dt", ""));
		setPartialMark(JSPUtil.getParameter(request, prefix + "partial_mark", ""));
		setArCurrCd(JSPUtil.getParameter(request, prefix + "ar_curr_cd", ""));
		setSvcProvdrNm(JSPUtil.getParameter(request, prefix + "svc_provdr_nm", ""));
		setDmdtChgStsDesc(JSPUtil.getParameter(request, prefix + "dmdt_chg_sts_desc", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setArActCd(JSPUtil.getParameter(request, prefix + "ar_act_cd", ""));
		setFtCmncDt(JSPUtil.getParameter(request, prefix + "ft_cmnc_dt", ""));
		setMvmtUmchSeq(JSPUtil.getParameter(request, prefix + "mvmt_umch_seq", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
		setWebCreUsrId(JSPUtil.getParameter(request, prefix + "web_cre_usr_id", ""));
		setRollOvr(JSPUtil.getParameter(request, prefix + "roll_ovr", ""));
		setCntrCycNo(JSPUtil.getParameter(request, prefix + "cntr_cyc_no", ""));
		setCntrInvAmt(JSPUtil.getParameter(request, prefix + "cntr_inv_amt", ""));
		setDetFtEndDt(JSPUtil.getParameter(request, prefix + "det_ft_end_dt", ""));
		setToMvmtYr(JSPUtil.getParameter(request, prefix + "to_mvmt_yr", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_sts_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setRfaExptMapgSeq(JSPUtil.getParameter(request, prefix + "rfa_expt_mapg_seq", ""));
		setPayerNm(JSPUtil.getParameter(request, prefix + "payer_nm", ""));
		setWebNtfyPicNm(JSPUtil.getParameter(request, prefix + "web_ntfy_pic_nm", ""));
		setRfaExptVerSeq(JSPUtil.getParameter(request, prefix + "rfa_expt_ver_seq", ""));
		setWebIndFlg(JSPUtil.getParameter(request, prefix + "web_ind_flg", ""));
		setChgType(JSPUtil.getParameter(request, prefix + "chg_type", ""));
		setCnt(JSPUtil.getParameter(request, prefix + "cnt", ""));
		setFmMvmtStsCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_sts_cd", ""));
		setInvChgAmt(JSPUtil.getParameter(request, prefix + "inv_chg_amt", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setDmdtInvNo(JSPUtil.getParameter(request, prefix + "dmdt_inv_no", ""));
		setFmMvmtSeq(JSPUtil.getParameter(request, prefix + "fm_mvmt_seq", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setNtfyCd(JSPUtil.getParameter(request, prefix + "ntfy_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setToMvmtSplitNo(JSPUtil.getParameter(request, prefix + "to_mvmt_split_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setFmMvmtSplitNo(JSPUtil.getParameter(request, prefix + "fm_mvmt_split_no", ""));
		setInvDtlSeq(JSPUtil.getParameter(request, prefix + "inv_dtl_seq", ""));
		setRdTermCd(JSPUtil.getParameter(request, prefix + "rd_term_cd", ""));
		setOrgChgAmt(JSPUtil.getParameter(request, prefix + "org_chg_amt", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setBzcTrfCurrCd(JSPUtil.getParameter(request, prefix + "bzc_trf_curr_cd", ""));
		setFmMvmtYr(JSPUtil.getParameter(request, prefix + "fm_mvmt_yr", ""));
		setDmdtChgDeltRsnCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_delt_rsn_cd", ""));
		setScExptVerSeq(JSPUtil.getParameter(request, prefix + "sc_expt_ver_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setMtDt(JSPUtil.getParameter(request, prefix + "mt_dt", ""));
		setFxFtOvrDys(JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setRfaExptDarNo(JSPUtil.getParameter(request, prefix + "rfa_expt_dar_no", ""));
		setShipperCd(JSPUtil.getParameter(request, prefix + "shipper_cd", ""));
		setCfmUsrId(JSPUtil.getParameter(request, prefix + "cfm_usr_id", ""));
		setToMvmtSeq(JSPUtil.getParameter(request, prefix + "to_mvmt_seq", ""));
		setXcldFlgs(JSPUtil.getParameter(request, prefix + "xcld_flgs", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
		setDetFtOvrDys(JSPUtil.getParameter(request, prefix + "det_ft_ovr_dys", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, prefix + "rep_cmdt_nm", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setRlseDt(JSPUtil.getParameter(request, prefix + "rlse_dt", ""));
		setLi(JSPUtil.getParameter(request, prefix + "li", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDO(JSPUtil.getParameter(request, prefix + "d_o", ""));
		setAcust(JSPUtil.getParameter(request, prefix + "acust", ""));
		setCxlBkgChgFlg(JSPUtil.getParameter(request, prefix + "cxl_bkg_chg_flg", ""));
		setCh(JSPUtil.getParameter(request, prefix + "ch", ""));
		setDmdtBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "dmdt_bkg_cgo_tp_cd", ""));
		setBzcTrfSeq(JSPUtil.getParameter(request, prefix + "bzc_trf_seq", ""));
		setDmdtArIfCd(JSPUtil.getParameter(request, prefix + "dmdt_ar_if_cd", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, prefix + "pst_rly_port_cd", ""));
		setGraceEndDt(JSPUtil.getParameter(request, prefix + "grace_end_dt", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setScRfaExptAmt(JSPUtil.getParameter(request, prefix + "sc_rfa_expt_amt", ""));
		setRfaExptAproNo(JSPUtil.getParameter(request, prefix + "rfa_expt_apro_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActCntCd(JSPUtil.getParameter(request, prefix + "act_cnt_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setRfaRqstDtlSeq(JSPUtil.getParameter(request, prefix + "rfa_rqst_dtl_seq", ""));
		setBzcTrfGrpSeq(JSPUtil.getParameter(request, prefix + "bzc_trf_grp_seq", ""));
		setFtEndDt(JSPUtil.getParameter(request, prefix + "ft_end_dt", ""));
		setToMvmtDt(JSPUtil.getParameter(request, prefix + "to_mvmt_dt", ""));
		setWebNtfyPicTelcmNo(JSPUtil.getParameter(request, prefix + "web_ntfy_pic_telcm_no", ""));
		setOfcRhqCd(JSPUtil.getParameter(request, prefix + "ofc_rhq_cd", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", ""));
		setToMvmtStsCd(JSPUtil.getParameter(request, prefix + "to_mvmt_sts_cd", ""));
		setDmdtCntrTpCd(JSPUtil.getParameter(request, prefix + "dmdt_cntr_tp_cd", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setScExptGrpSeq(JSPUtil.getParameter(request, prefix + "sc_expt_grp_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setSvcProvdrCd(JSPUtil.getParameter(request, prefix + "svc_provdr_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setCfmOfcCd(JSPUtil.getParameter(request, prefix + "cfm_ofc_cd", ""));
		setFtDys(JSPUtil.getParameter(request, prefix + "ft_dys", ""));
		setWebMtyDt(JSPUtil.getParameter(request, prefix + "web_mty_dt", ""));
		setWebCancelFlg(JSPUtil.getParameter(request, prefix + "web_cancel_flg", ""));
		setOrgFtOvrDys(JSPUtil.getParameter(request, prefix + "org_ft_ovr_dys", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", ""));
		setToMvmtYdCd(JSPUtil.getParameter(request, prefix + "to_mvmt_yd_cd", ""));
		setGenBal(JSPUtil.getParameter(request, prefix + "gen_bal", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setDeltSeq(JSPUtil.getParameter(request, prefix + "delt_seq", ""));	
		setDeltRsnDesc(JSPUtil.getParameter(request, prefix + "delt_rsn_desc", ""));
		setDmdtDeltRqstStsCd(JSPUtil.getParameter(request, prefix + "dmdt_delt_rqst_sts_cd", ""));
		setExptCntrTeuKnt(JSPUtil.getParameter(request, prefix + "expt_cntr_teu_knt", ""));
		setIncurCntrTeuKnt(JSPUtil.getParameter(request, prefix + "incur_cntr_teu_knt", ""));
		setIncurAmt(JSPUtil.getParameter(request, prefix + "incur_amt", ""));
		setBkgQty(JSPUtil.getParameter(request, prefix + "bkg_qty", ""));
		setExptCostAmt(JSPUtil.getParameter(request, prefix + "expt_cost_amt", ""));
		setExptQty(JSPUtil.getParameter(request, prefix + "expt_qty", ""));
		setIncurQty(JSPUtil.getParameter(request, prefix + "incur_qty", ""));
		setExptDys(JSPUtil.getParameter(request, prefix + "expt_dys", ""));
		setBkgCntrTeu(JSPUtil.getParameter(request, prefix + "bkg_cntr_teu", ""));
		setArIfDt(JSPUtil.getParameter(request, prefix + "ar_if_dt", ""));
		setOpBkgNo(JSPUtil.getParameter(request, prefix + "op_bkg_no", ""));
		setUclmFlg(JSPUtil.getParameter(request, prefix + "uclm_flg", ""));
		setBzcDmdtDeTermCd(JSPUtil.getParameter(request, prefix + "bzc_dmdt_de_term_cd", ""));
		setBzcDmdtDeTermNm(JSPUtil.getParameter(request, prefix + "bzc_dmdt_de_term_nm", ""));
		setNotCreBalFlg(JSPUtil.getParameter(request, prefix + "not_cre_bal_flg", ""));
		setOvrDue(JSPUtil.getParameter(request, prefix + "ovr_due", ""));
		setBzcTrfAplyDt(JSPUtil.getParameter(request, prefix + "bzc_trf_aply_dt", ""));
		setScRfaExptAplyDt(JSPUtil.getParameter(request, prefix + "sc_rfa_expt_aply_dt", ""));
		setFmMvmtDtTime(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt_time", ""));
		setToMvmtDtTime(JSPUtil.getParameter(request, prefix + "to_mvmt_dt_time", ""));
		
		setCtrtCustNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_nm", ""));
		setCtrtCustCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cd", ""));
		setCtrtSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_srep_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setIbSrepCd(JSPUtil.getParameter(request, prefix + "ib_srep_cd", ""));
		setIbSlsOfcCd(JSPUtil.getParameter(request, prefix + "ib_sls_ofc_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
	
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeCalculationContainerVO[]
	 */
	public ChargeCalculationContainerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeCalculationContainerVO[]
	 */
	public ChargeCalculationContainerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeCalculationContainerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] corrRmk = (JSPUtil.getParameter(request, prefix	+ "corr_rmk", length));
			String[] dulTpExptFlg = (JSPUtil.getParameter(request, prefix	+ "dul_tp_expt_flg", length));
			String[] webCreDt = (JSPUtil.getParameter(request, prefix	+ "web_cre_dt", length));
			String[] ofcTrnsFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_trns_flg", length));
			String[] aftExptDcAmt = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dc_amt", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] aftExptAdjSeq = (JSPUtil.getParameter(request, prefix	+ "aft_expt_adj_seq", length));
			String[] dmdtTrfAplyTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_aply_tp_cd", length));
			String[] demFtEndDt = (JSPUtil.getParameter(request, prefix	+ "dem_ft_end_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] shipperNm = (JSPUtil.getParameter(request, prefix	+ "shipper_nm", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] arActNm = (JSPUtil.getParameter(request, prefix	+ "ar_act_nm", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] payerCd = (JSPUtil.getParameter(request, prefix	+ "payer_cd", length));
			String[] aftExptAproNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_apro_no", length));
			String[] rlseOfc = (JSPUtil.getParameter(request, prefix	+ "rlse_ofc", length));
			String[] calcDt = (JSPUtil.getParameter(request, prefix	+ "calc_dt", length));
			String[] partialMark = (JSPUtil.getParameter(request, prefix	+ "partial_mark", length));
			String[] arCurrCd = (JSPUtil.getParameter(request, prefix	+ "ar_curr_cd", length));
			String[] svcProvdrNm = (JSPUtil.getParameter(request, prefix	+ "svc_provdr_nm", length));
			String[] dmdtChgStsDesc = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_desc", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] arActCd = (JSPUtil.getParameter(request, prefix	+ "ar_act_cd", length));
			String[] ftCmncDt = (JSPUtil.getParameter(request, prefix	+ "ft_cmnc_dt", length));
			String[] mvmtUmchSeq = (JSPUtil.getParameter(request, prefix	+ "mvmt_umch_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] webCreUsrId = (JSPUtil.getParameter(request, prefix	+ "web_cre_usr_id", length));
			String[] rollOvr = (JSPUtil.getParameter(request, prefix	+ "roll_ovr", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] cntrInvAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_inv_amt", length));
			String[] detFtEndDt = (JSPUtil.getParameter(request, prefix	+ "det_ft_end_dt", length));
			String[] toMvmtYr = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yr", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] rfaExptMapgSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_mapg_seq", length));
			String[] payerNm = (JSPUtil.getParameter(request, prefix	+ "payer_nm", length));
			String[] webNtfyPicNm = (JSPUtil.getParameter(request, prefix	+ "web_ntfy_pic_nm", length));
			String[] rfaExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_ver_seq", length));
			String[] webIndFlg = (JSPUtil.getParameter(request, prefix	+ "web_ind_flg", length));
			String[] chgType = (JSPUtil.getParameter(request, prefix	+ "chg_type", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));
			String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_sts_cd", length));
			String[] invChgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_chg_amt", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_no", length));
			String[] fmMvmtSeq = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_seq", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] ntfyCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] toMvmtSplitNo = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_split_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] fmMvmtSplitNo = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_split_no", length));
			String[] invDtlSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_seq", length));
			String[] rdTermCd = (JSPUtil.getParameter(request, prefix	+ "rd_term_cd", length));
			String[] orgChgAmt = (JSPUtil.getParameter(request, prefix	+ "org_chg_amt", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_curr_cd", length));
			String[] fmMvmtYr = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yr", length));
			String[] dmdtChgDeltRsnCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_delt_rsn_cd", length));
			String[] scExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_ver_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mtDt = (JSPUtil.getParameter(request, prefix	+ "mt_dt", length));
			String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "fx_ft_ovr_dys", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rfaExptDarNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_dar_no", length));
			String[] shipperCd = (JSPUtil.getParameter(request, prefix	+ "shipper_cd", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] toMvmtSeq = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_seq", length));
			String[] xcldFlgs = (JSPUtil.getParameter(request, prefix	+ "xcld_flgs", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] detFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "det_ft_ovr_dys", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] rlseDt = (JSPUtil.getParameter(request, prefix	+ "rlse_dt", length));
			String[] li = (JSPUtil.getParameter(request, prefix	+ "li", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dO = (JSPUtil.getParameter(request, prefix	+ "d_o", length));
			String[] acust = (JSPUtil.getParameter(request, prefix	+ "acust", length));
			String[] cxlBkgChgFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_bkg_chg_flg", length));
			String[] ch = (JSPUtil.getParameter(request, prefix	+ "ch", length));
			String[] dmdtBkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_bkg_cgo_tp_cd", length));
			String[] bzcTrfSeq = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_seq", length));
			String[] dmdtArIfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ar_if_cd", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] graceEndDt = (JSPUtil.getParameter(request, prefix	+ "grace_end_dt", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] scRfaExptAmt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_amt", length));
			String[] rfaExptAproNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_apro_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cnt_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] rfaRqstDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_rqst_dtl_seq", length));
			String[] bzcTrfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_grp_seq", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] webNtfyPicTelcmNo = (JSPUtil.getParameter(request, prefix	+ "web_ntfy_pic_telcm_no", length));
			String[] ofcRhqCd = (JSPUtil.getParameter(request, prefix	+ "ofc_rhq_cd", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] toMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_sts_cd", length));
			String[] dmdtCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_cd", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] scExptGrpSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_grp_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] svcProvdrCd = (JSPUtil.getParameter(request, prefix	+ "svc_provdr_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] cfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "cfm_ofc_cd", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] webMtyDt = (JSPUtil.getParameter(request, prefix	+ "web_mty_dt", length));
			String[] webCancelFlg = (JSPUtil.getParameter(request, prefix	+ "web_cancel_flg", length));
			String[] orgFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "org_ft_ovr_dys", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			String[] toMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yd_cd", length));
			String[] genBal = (JSPUtil.getParameter(request, prefix	+ "gen_bal", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] deltSeq = (JSPUtil.getParameter(request, prefix	+ "delt_seq", length));			
			String[] deltRsnDesc = (JSPUtil.getParameter(request, prefix	+ "delt_rsn_desc", length));
			String[] dmdtDeltRqstStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_delt_rqst_sts_cd", length));
			String[] exptCntrTeuKnt = (JSPUtil.getParameter(request, prefix	+ "expt_cntr_teu_knt", length));
			String[] incurCntrTeuKnt = (JSPUtil.getParameter(request, prefix	+ "incur_cntr_teu_knt", length));
			String[] incurAmt = (JSPUtil.getParameter(request, prefix	+ "incur_amt", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] exptCostAmt = (JSPUtil.getParameter(request, prefix	+ "expt_cost_amt", length));
			String[] exptQty = (JSPUtil.getParameter(request, prefix	+ "expt_qty", length));
			String[] incurQty = (JSPUtil.getParameter(request, prefix	+ "incur_qty", length));
			String[] exptDys = (JSPUtil.getParameter(request, prefix	+ "expt_dys", length));
			String[] bkgCntrTeu = (JSPUtil.getParameter(request, prefix	+ "bkg_cntr_teu", length));
			String[] arIfDt = (JSPUtil.getParameter(request, prefix	+ "ar_if_dt", length));
			String[] opBkgNo = (JSPUtil.getParameter(request, prefix	+ "op_bkg_no", length));
			String[] uclmFlg = (JSPUtil.getParameter(request, prefix	+ "uclm_flg", length));
			String[] bzcDmdtDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bzc_dmdt_de_term_cd", length));
			String[] bzcDmdtDeTermNm = (JSPUtil.getParameter(request, prefix	+ "bzc_dmdt_de_term_nm", length));
			String[] notCreBalFlg = (JSPUtil.getParameter(request, prefix	+ "not_cre_bal_flg", length));
			String[] ovrDue = (JSPUtil.getParameter(request, prefix	+ "ovr_due", length));
			String[] bzcTrfAplyDt = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_aply_dt", length));
			String[] scRfaExptAplyDt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_aply_dt", length));
			String[] fmMvmtDtTime = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt_time", length));
			String[] toMvmtDtTime = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt_time", length));
			
			String[] ctrtCustNm = (JSPUtil.getParameter(request, prefix + "ctrt_cust_nm", length));
			String[] ctrtCustCd = (JSPUtil.getParameter(request, prefix + "ctrt_cust_cd", length));
			String[] ctrtSrepCd = (JSPUtil.getParameter(request, prefix + "ctrt_srep_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix + "ob_srep_cd", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", length));
			String[] ibSrepCd = (JSPUtil.getParameter(request, prefix + "ib_srep_cd", length));
			String[] ibSlsOfcCd = (JSPUtil.getParameter(request, prefix + "ib_sls_ofc_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeCalculationContainerVO();
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (corrRmk[i] != null)
					model.setCorrRmk(corrRmk[i]);
				if (dulTpExptFlg[i] != null)
					model.setDulTpExptFlg(dulTpExptFlg[i]);
				if (webCreDt[i] != null)
					model.setWebCreDt(webCreDt[i]);
				if (ofcTrnsFlg[i] != null)
					model.setOfcTrnsFlg(ofcTrnsFlg[i]);
				if (aftExptDcAmt[i] != null)
					model.setAftExptDcAmt(aftExptDcAmt[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (aftExptAdjSeq[i] != null)
					model.setAftExptAdjSeq(aftExptAdjSeq[i]);
				if (dmdtTrfAplyTpCd[i] != null)
					model.setDmdtTrfAplyTpCd(dmdtTrfAplyTpCd[i]);
				if (demFtEndDt[i] != null)
					model.setDemFtEndDt(demFtEndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (shipperNm[i] != null)
					model.setShipperNm(shipperNm[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (arActNm[i] != null)
					model.setArActNm(arActNm[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (payerCd[i] != null)
					model.setPayerCd(payerCd[i]);
				if (aftExptAproNo[i] != null)
					model.setAftExptAproNo(aftExptAproNo[i]);
				if (rlseOfc[i] != null)
					model.setRlseOfc(rlseOfc[i]);
				if (calcDt[i] != null)
					model.setCalcDt(calcDt[i]);
				if (partialMark[i] != null)
					model.setPartialMark(partialMark[i]);
				if (arCurrCd[i] != null)
					model.setArCurrCd(arCurrCd[i]);
				if (svcProvdrNm[i] != null)
					model.setSvcProvdrNm(svcProvdrNm[i]);
				if (dmdtChgStsDesc[i] != null)
					model.setDmdtChgStsDesc(dmdtChgStsDesc[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (arActCd[i] != null)
					model.setArActCd(arActCd[i]);
				if (ftCmncDt[i] != null)
					model.setFtCmncDt(ftCmncDt[i]);
				if (mvmtUmchSeq[i] != null)
					model.setMvmtUmchSeq(mvmtUmchSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (webCreUsrId[i] != null)
					model.setWebCreUsrId(webCreUsrId[i]);
				if (rollOvr[i] != null)
					model.setRollOvr(rollOvr[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (cntrInvAmt[i] != null)
					model.setCntrInvAmt(cntrInvAmt[i]);
				if (detFtEndDt[i] != null)
					model.setDetFtEndDt(detFtEndDt[i]);
				if (toMvmtYr[i] != null)
					model.setToMvmtYr(toMvmtYr[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (rfaExptMapgSeq[i] != null)
					model.setRfaExptMapgSeq(rfaExptMapgSeq[i]);
				if (payerNm[i] != null)
					model.setPayerNm(payerNm[i]);
				if (webNtfyPicNm[i] != null)
					model.setWebNtfyPicNm(webNtfyPicNm[i]);
				if (rfaExptVerSeq[i] != null)
					model.setRfaExptVerSeq(rfaExptVerSeq[i]);
				if (webIndFlg[i] != null)
					model.setWebIndFlg(webIndFlg[i]);
				if (chgType[i] != null)
					model.setChgType(chgType[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				if (fmMvmtStsCd[i] != null)
					model.setFmMvmtStsCd(fmMvmtStsCd[i]);
				if (invChgAmt[i] != null)
					model.setInvChgAmt(invChgAmt[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (dmdtInvNo[i] != null)
					model.setDmdtInvNo(dmdtInvNo[i]);
				if (fmMvmtSeq[i] != null)
					model.setFmMvmtSeq(fmMvmtSeq[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (ntfyCd[i] != null)
					model.setNtfyCd(ntfyCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (toMvmtSplitNo[i] != null)
					model.setToMvmtSplitNo(toMvmtSplitNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (fmMvmtSplitNo[i] != null)
					model.setFmMvmtSplitNo(fmMvmtSplitNo[i]);
				if (invDtlSeq[i] != null)
					model.setInvDtlSeq(invDtlSeq[i]);
				if (rdTermCd[i] != null)
					model.setRdTermCd(rdTermCd[i]);
				if (orgChgAmt[i] != null)
					model.setOrgChgAmt(orgChgAmt[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bzcTrfCurrCd[i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				if (fmMvmtYr[i] != null)
					model.setFmMvmtYr(fmMvmtYr[i]);
				if (dmdtChgDeltRsnCd[i] != null)
					model.setDmdtChgDeltRsnCd(dmdtChgDeltRsnCd[i]);
				if (scExptVerSeq[i] != null)
					model.setScExptVerSeq(scExptVerSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mtDt[i] != null)
					model.setMtDt(mtDt[i]);
				if (fxFtOvrDys[i] != null)
					model.setFxFtOvrDys(fxFtOvrDys[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rfaExptDarNo[i] != null)
					model.setRfaExptDarNo(rfaExptDarNo[i]);
				if (shipperCd[i] != null)
					model.setShipperCd(shipperCd[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (toMvmtSeq[i] != null)
					model.setToMvmtSeq(toMvmtSeq[i]);
				if (xcldFlgs[i] != null)
					model.setXcldFlgs(xcldFlgs[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (detFtOvrDys[i] != null)
					model.setDetFtOvrDys(detFtOvrDys[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (rlseDt[i] != null)
					model.setRlseDt(rlseDt[i]);
				if (li[i] != null)
					model.setLi(li[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dO[i] != null)
					model.setDO(dO[i]);
				if (acust[i] != null)
					model.setAcust(acust[i]);
				if (cxlBkgChgFlg[i] != null)
					model.setCxlBkgChgFlg(cxlBkgChgFlg[i]);
				if (ch[i] != null)
					model.setCh(ch[i]);
				if (dmdtBkgCgoTpCd[i] != null)
					model.setDmdtBkgCgoTpCd(dmdtBkgCgoTpCd[i]);
				if (bzcTrfSeq[i] != null)
					model.setBzcTrfSeq(bzcTrfSeq[i]);
				if (dmdtArIfCd[i] != null)
					model.setDmdtArIfCd(dmdtArIfCd[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (graceEndDt[i] != null)
					model.setGraceEndDt(graceEndDt[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (scRfaExptAmt[i] != null)
					model.setScRfaExptAmt(scRfaExptAmt[i]);
				if (rfaExptAproNo[i] != null)
					model.setRfaExptAproNo(rfaExptAproNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actCntCd[i] != null)
					model.setActCntCd(actCntCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (rfaRqstDtlSeq[i] != null)
					model.setRfaRqstDtlSeq(rfaRqstDtlSeq[i]);
				if (bzcTrfGrpSeq[i] != null)
					model.setBzcTrfGrpSeq(bzcTrfGrpSeq[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (webNtfyPicTelcmNo[i] != null)
					model.setWebNtfyPicTelcmNo(webNtfyPicTelcmNo[i]);
				if (ofcRhqCd[i] != null)
					model.setOfcRhqCd(ofcRhqCd[i]);
				if (fmMvmtYdCd[i] != null)
					model.setFmMvmtYdCd(fmMvmtYdCd[i]);
				if (toMvmtStsCd[i] != null)
					model.setToMvmtStsCd(toMvmtStsCd[i]);
				if (dmdtCntrTpCd[i] != null)
					model.setDmdtCntrTpCd(dmdtCntrTpCd[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (scExptGrpSeq[i] != null)
					model.setScExptGrpSeq(scExptGrpSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (svcProvdrCd[i] != null)
					model.setSvcProvdrCd(svcProvdrCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (cfmOfcCd[i] != null)
					model.setCfmOfcCd(cfmOfcCd[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (webMtyDt[i] != null)
					model.setWebMtyDt(webMtyDt[i]);
				if (webCancelFlg[i] != null)
					model.setWebCancelFlg(webCancelFlg[i]);
				if (orgFtOvrDys[i] != null)
					model.setOrgFtOvrDys(orgFtOvrDys[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				if (toMvmtYdCd[i] != null)
					model.setToMvmtYdCd(toMvmtYdCd[i]);
				if (genBal[i] != null)
					model.setGenBal(genBal[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (deltSeq[i] != null)
					model.setDeltSeq(deltSeq[i]);
				if (deltRsnDesc[i] != null)
					model.setDeltRsnDesc(deltRsnDesc[i]);
				if (dmdtDeltRqstStsCd[i] != null)
					model.setDmdtDeltRqstStsCd(dmdtDeltRqstStsCd[i]);
				if (exptCntrTeuKnt[i] != null)
					model.setExptCntrTeuKnt(exptCntrTeuKnt[i]);
				if (incurCntrTeuKnt[i] != null)
					model.setIncurCntrTeuKnt(incurCntrTeuKnt[i]);
				if (incurAmt[i] != null)
					model.setIncurAmt(incurAmt[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (exptCostAmt[i] != null)
					model.setExptCostAmt(exptCostAmt[i]);
				if (exptQty[i] != null)
					model.setExptQty(exptQty[i]);
				if (incurQty[i] != null)
					model.setIncurQty(incurQty[i]);
				if (exptDys[i] != null)
					model.setExptDys(exptDys[i]);
				if (bkgCntrTeu[i] != null)
					model.setBkgCntrTeu(bkgCntrTeu[i]);
				if (arIfDt[i] != null)
					model.setArIfDt(arIfDt[i]);
				if (opBkgNo[i] != null)
					model.setOpBkgNo(opBkgNo[i]);
				if (uclmFlg[i] != null)
					model.setUclmFlg(uclmFlg[i]);
				if (bzcDmdtDeTermCd[i] != null)
					model.setBzcDmdtDeTermCd(bzcDmdtDeTermCd[i]);
				if (bzcDmdtDeTermNm[i] != null)
					model.setBzcDmdtDeTermNm(bzcDmdtDeTermNm[i]);
				if (notCreBalFlg[i] != null)
					model.setNotCreBalFlg(notCreBalFlg[i]);
				if (ovrDue[i] != null)
					model.setOvrDue(ovrDue[i]);
				if (bzcTrfAplyDt[i] != null)
					model.setBzcTrfAplyDt(bzcTrfAplyDt[i]);
				if (scRfaExptAplyDt[i] != null)
					model.setScRfaExptAplyDt(scRfaExptAplyDt[i]);
				if (fmMvmtDtTime[i] != null)
					model.setFmMvmtDtTime(fmMvmtDtTime[i]);
				if (toMvmtDtTime[i] != null)
					model.setToMvmtDtTime(toMvmtDtTime[i]);
				
				if (ctrtCustNm[i] != null)
					model.setCtrtCustNm(ctrtCustNm[i]);
				if (ctrtCustCd[i] != null)
					model.setCtrtCustCd(ctrtCustCd[i]);
				if (ctrtSrepCd[i] != null)
					model.setCtrtSrepCd(ctrtSrepCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (ibSrepCd[i] != null)
					model.setIbSrepCd(ibSrepCd[i]);
				if (ibSlsOfcCd[i] != null)
					model.setIbSlsOfcCd(ibSlsOfcCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
					
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeCalculationContainerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeCalculationContainerVO[]
	 */
	public ChargeCalculationContainerVO[] getChargeCalculationContainerVOs(){
		ChargeCalculationContainerVO[] vos = (ChargeCalculationContainerVO[])models.toArray(new ChargeCalculationContainerVO[models.size()]);
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
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRmk = this.corrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dulTpExptFlg = this.dulTpExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webCreDt = this.webCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTrnsFlg = this.ofcTrnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDcAmt = this.aftExptDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAdjSeq = this.aftExptAdjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfAplyTpCd = this.dmdtTrfAplyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demFtEndDt = this.demFtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperNm = this.shipperNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arActNm = this.arActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerCd = this.payerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAproNo = this.aftExptAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseOfc = this.rlseOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcDt = this.calcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partialMark = this.partialMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCurrCd = this.arCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcProvdrNm = this.svcProvdrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsDesc = this.dmdtChgStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arActCd = this.arActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftCmncDt = this.ftCmncDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtUmchSeq = this.mvmtUmchSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webCreUsrId = this.webCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rollOvr = this.rollOvr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrInvAmt = this.cntrInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detFtEndDt = this.detFtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYr = this.toMvmtYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptMapgSeq = this.rfaExptMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerNm = this.payerNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webNtfyPicNm = this.webNtfyPicNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptVerSeq = this.rfaExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webIndFlg = this.webIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgType = this.chgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtStsCd = this.fmMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChgAmt = this.invChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvNo = this.dmdtInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtSeq = this.fmMvmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCd = this.ntfyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtSplitNo = this.toMvmtSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtSplitNo = this.fmMvmtSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlSeq = this.invDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdTermCd = this.rdTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgChgAmt = this.orgChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfCurrCd = this.bzcTrfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYr = this.fmMvmtYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgDeltRsnCd = this.dmdtChgDeltRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptVerSeq = this.scExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtDt = this.mtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxFtOvrDys = this.fxFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptDarNo = this.rfaExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCd = this.shipperCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtSeq = this.toMvmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldFlgs = this.xcldFlgs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detFtOvrDys = this.detFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseDt = this.rlseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.li = this.li .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dO = this.dO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acust = this.acust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlBkgChgFlg = this.cxlBkgChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ch = this.ch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBkgCgoTpCd = this.dmdtBkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfSeq = this.bzcTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtArIfCd = this.dmdtArIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.graceEndDt = this.graceEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptAmt = this.scRfaExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptAproNo = this.rfaExptAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCntCd = this.actCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaRqstDtlSeq = this.rfaRqstDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfGrpSeq = this.bzcTrfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webNtfyPicTelcmNo = this.webNtfyPicTelcmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRhqCd = this.ofcRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtStsCd = this.toMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpCd = this.dmdtCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptGrpSeq = this.scExptGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcProvdrCd = this.svcProvdrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmOfcCd = this.cfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webMtyDt = this.webMtyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webCancelFlg = this.webCancelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFtOvrDys = this.orgFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYdCd = this.toMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genBal = this.genBal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltSeq = this.deltSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltRsnDesc = this.deltRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeltRqstStsCd = this.dmdtDeltRqstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptCntrTeuKnt = this.exptCntrTeuKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incurCntrTeuKnt = this.incurCntrTeuKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incurAmt = this.incurAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptCostAmt = this.exptCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptQty = this.exptQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incurQty = this.incurQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptDys = this.exptDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntrTeu = this.bkgCntrTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfDt = this.arIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opBkgNo = this.opBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmFlg = this.uclmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcDmdtDeTermCd = this.bzcDmdtDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcDmdtDeTermNm = this.bzcDmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notCreBalFlg = this.notCreBalFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDue = this.ovrDue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfAplyDt = this.bzcTrfAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptAplyDt = this.scRfaExptAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDtTime = this.fmMvmtDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDtTime = this.toMvmtDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.ctrtCustNm = this.ctrtCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCd = this.ctrtCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSrepCd = this.ctrtSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSrepCd = this.ibSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSlsOfcCd = this.ibSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}