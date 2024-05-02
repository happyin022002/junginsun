/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SaelsPerformanceReportOutVO.java
*@FileTitle : SaelsPerformanceReportOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.04.19 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SaelsPerformanceReportOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SaelsPerformanceReportOutVO> models = new ArrayList<SaelsPerformanceReportOutVO>();
	
	/* Column Info */
	private String revO4 = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String p4 = null;
	/* Column Info */
	private String nonRev = null;
	/* Column Info */
	private String p2 = null;
	/* Column Info */
	private String tac = null;
	/* Column Info */
	private String revO2 = null;
	/* Column Info */
	private String feuGross = null;
	/* Column Info */
	private String ibWkPodCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnnfCd = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String subTotBaf = null;
	/* Column Info */
	private String rpb = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String totD2 = null;
	/* Column Info */
	private String eqRpb = null;
	/* Column Info */
	private String totD4 = null;
	/* Column Info */
	private String bkgPod = null;
	/* Column Info */
	private String totD5 = null;
	/* Column Info */
	private String totRth = null;
	/* Column Info */
	private String repAcctNm = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String subTotCaf = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String totNonRev = null;
	/* Column Info */
	private String tot40 = null;
	/* Column Info */
	private String feu = null;
	/* Column Info */
	private String totBaf = null;
	/* Column Info */
	private String q2 = null;
	/* Column Info */
	private String firstVvd = null;
	/* Column Info */
	private String q4 = null;
	/* Column Info */
	private String subTotOft = null;
	/* Column Info */
	private String gso = null;
	/* Column Info */
	private String baf = null;
	/* Column Info */
	private String revF4 = null;
	/* Column Info */
	private String revRd2 = null;
	/* Column Info */
	private String totTtl = null;
	/* Column Info */
	private String revRd4 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rgnCnt = null;
	/* Column Info */
	private String revF2 = null;
	/* Column Info */
	private String ctrtSrepCd = null;
	/* Column Info */
	private String slsWk = null;
	/* Column Info */
	private String totS2 = null;
	/* Column Info */
	private String totS4 = null;
	/* Column Info */
	private String rOther = null;
	/* Column Info */
	private String subTotNet = null;
	/* Column Info */
	private String blObrdWk = null;
	/* Column Info */
	private String subTotD2 = null;
	/* Column Info */
	private String teuTtl = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String revQ4 = null;
	/* Column Info */
	private String revQ2 = null;
	/* Column Info */
	private String voidTeu = null;
	/* Column Info */
	private String net = null;
	/* Column Info */
	private String subTotD5 = null;
	/* Column Info */
	private String teuGross = null;
	/* Column Info */
	private String subTotD4 = null;
	/* Column Info */
	private String subTot20 = null;
	/* Column Info */
	private String cnnfNm = null;
	/* Column Info */
	private String totMisc = null;
	/* Column Info */
	private String totRd2 = null;
	/* Column Info */
	private String subTotTtl = null;
	/* Column Info */
	private String subTotGross = null;
	/* Column Info */
	private String totRd4 = null;
	/* Column Info */
	private String totR4 = null;
	/* Column Info */
	private String f2 = null;
	/* Column Info */
	private String totR2 = null;
	/* Column Info */
	private String ofcCnt = null;
	/* Column Info */
	private String subTotRth = null;
	/* Column Info */
	private String f4 = null;
	/* Column Info */
	private String voidSlot = null;
	/* Column Info */
	private String ibSlsOfcCd = null;
	/* Column Info */
	private String o2 = null;
	/* Column Info */
	private String o4 = null;
	/* Column Info */
	private String revP2 = null;
	/* Column Info */
	private String revP4 = null;
	/* Column Info */
	private String ttl = null;
	/* Column Info */
	private String repKnd = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String subTotTac = null;
	/* Column Info */
	private String voidFeu = null;
	/* Column Info */
	private String totDth = null;
	/* Column Info */
	private String doc = null;
	/* Column Info */
	private String totGross = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String subTotR4 = null;
	/* Column Info */
	private String subTotR2 = null;
	/* Column Info */
	private String totVoidTeu = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String subTot40 = null;
	/* Column Info */
	private String revR4 = null;
	/* Column Info */
	private String d2 = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ibsOfcNt = null;
	/* Column Info */
	private String revR2 = null;
	/* Column Info */
	private String oth = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String orgSvc = null;
	/* Column Info */
	private String dth = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String obSrepNm = null;
	/* Column Info */
	private String subTotDoc = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String subTotS2 = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String subTotRd4 = null;
	/* Column Info */
	private String totSlo = null;
	/* Column Info */
	private String subTotS4 = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String subTotRd2 = null;
	/* Column Info */
	private String rd4 = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String rd2 = null;
	/* Column Info */
	private String dstSvc = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String subTotSlo = null;
	/* Column Info */
	private String totOth = null;
	/* Column Info */
	private String blObrdDt = null;
	/* Column Info */
	private String t4 = null;
	/* Column Info */
	private String subTotDth = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String voidRpb = null;
	/* Column Info */
	private String totSum = null;
	/* Column Info */
	private String grpBy = null;
	/* Column Info */
	private String totCaf = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String t2 = null;
	/* Column Info */
	private String gross = null;
	/* Column Info */
	private String subTotVoidFeu = null;
	/* Column Info */
	private String totVoidFeu = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String subTotNonRev = null;
	/* Column Info */
	private String subTotMisc = null;
	/* Column Info */
	private String totNet = null;
	/* Column Info */
	private String revT4 = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String revT2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totDoc = null;
	/* Column Info */
	private String totFeu = null;
	/* Column Info */
	private String subTotFeu = null;
	/* Column Info */
	private String ibWk = null;
	/* Column Info */
	private String caf = null;
	/* Column Info */
	private String s4 = null;
	/* Column Info */
	private String s2 = null;
	/* Column Info */
	private String totTac = null;
	/* Column Info */
	private String revD4 = null;
	/* Column Info */
	private String revD2 = null;
	/* Column Info */
	private String subTotVoidTeu = null;
	/* Column Info */
	private String repCustCd = null;
	/* Column Info */
	private String oft = null;
	/* Column Info */
	private String totTeu = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String io = null;
	/* Column Info */
	private String tot20 = null;
	/* Column Info */
	private String totNonNet = null;
	/* Column Info */
	private String misc = null;
	/* Column Info */
	private String subTotOth = null;
	/* Column Info */
	private String totOft = null;
	/* Column Info */
	private String subTotTeu = null;
	/* Column Info */
	private String box = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String subTotNonNet = null;
	/* Column Info */
	private String r4 = null;
	/* Column Info */
	private String nonNet = null;
	/* Column Info */
	private String r5 = null;
	/* Column Info */
	private String revD5 = null;
	/* Column Info */
	private String revR5 = null;
	/* Column Info */
	private String d7 = null;
	/* Column Info */
	private String revD7 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SaelsPerformanceReportOutVO() {}

	public SaelsPerformanceReportOutVO(String ibflag, String pagerows, String vvd, String bkgPod, String slanCd, String porCd, String polCd, String podCd, String delCd, String teu, String feu, String voidTeu, String voidFeu, String ttl, String gross, String net, String nonNet, String misc, String nonRev, String teuGross, String feuGross, String repKnd, String grpBy, String voidRpb, String eqRpb, String voidSlot, String oft, String baf, String caf, String oth, String dth, String doc, String tac, String rOther, String d2, String d4, String d5, String r2, String r4, String s2, String s4, String rd2, String rd4, String slsRhqCd, String slsRgnOfcCd, String obSlsOfcCd, String rgnCnt, String ofcCnt, String repCmdtCd, String repCmdtNm, String custCntCd, String custSeq, String custNm, String custGrpId, String obSrepCd, String obSrepNm, String eqCtrlOfcCd, String subTotTeu, String subTotFeu, String subTotTtl, String subTotVoidTeu, String subTotVoidFeu, String subTotGross, String subTotNet, String subTotNonNet, String subTotMisc, String subTotNonRev, String subTotOth, String subTot20, String subTot40, String subTotSlo, String subTotOft, String subTotBaf, String subTotCaf, String subTotDth, String subTotDoc, String subTotTac, String subTotRth, String subTotD2, String subTotD4, String subTotD5, String subTotR2, String subTotR4, String subTotS2, String subTotS4, String subTotRd2, String subTotRd4, String totTeu, String totFeu, String totTtl, String totVoidTeu, String totVoidFeu, String totGross, String totNet, String totNonNet, String totMisc, String totNonRev, String totOth, String tot20, String tot40, String totSlo, String totOft, String totBaf, String totCaf, String totDth, String totDoc, String totTac, String totRth, String totD2, String totD4, String totD5, String totR2, String totR4, String totS2, String totS4, String totRd2, String totRd4, String bkgNo, String blNo, String slsYrmon, String slsWk, String io, String teuTtl, String totSum, String rpb, String bkgCgoTpCd, String f2, String f4, String o2, String o4, String p2, String p4, String t2, String t4, String q2, String q4, String revD2, String revD4, String revR2, String revR4, String revRd2, String revRd4, String revF2, String revF4, String revO2, String revO4, String revP2, String revP4, String revT2, String revT4, String revQ2, String revQ4, String box, String frtTermCd, String firstVvd, String blObrdDt, String blObrdWk, String ibsOfcNt, String ibSlsOfcCd, String orgSvc, String dstSvc, String cnnfCd, String cnnfNm, String repCustCd, String repAcctNm, String rhq, String gso, String revDirCd, String rfaNo, String scNo, String ctrtOfcCd, String ctrtSrepCd, String bkgOfcCd, String ibWkPodCd, String ibWk, String r5, String revD5, String revR5, String d7, String revD7) {
		this.revO4 = revO4;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.p4 = p4;
		this.nonRev = nonRev;
		this.p2 = p2;
		this.tac = tac;
		this.revO2 = revO2;
		this.feuGross = feuGross;
		this.ibWkPodCd = ibWkPodCd;
		this.pagerows = pagerows;
		this.cnnfCd = cnnfCd;
		this.obSrepCd = obSrepCd;
		this.subTotBaf = subTotBaf;
		this.rpb = rpb;
		this.ctrtOfcCd = ctrtOfcCd;
		this.totD2 = totD2;
		this.eqRpb = eqRpb;
		this.totD4 = totD4;
		this.bkgPod = bkgPod;
		this.totD5 = totD5;
		this.totRth = totRth;
		this.repAcctNm = repAcctNm;
		this.custCntCd = custCntCd;
		this.rhq = rhq;
		this.subTotCaf = subTotCaf;
		this.bkgOfcCd = bkgOfcCd;
		this.totNonRev = totNonRev;
		this.tot40 = tot40;
		this.feu = feu;
		this.totBaf = totBaf;
		this.q2 = q2;
		this.firstVvd = firstVvd;
		this.q4 = q4;
		this.subTotOft = subTotOft;
		this.gso = gso;
		this.baf = baf;
		this.revF4 = revF4;
		this.revRd2 = revRd2;
		this.totTtl = totTtl;
		this.revRd4 = revRd4;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.rgnCnt = rgnCnt;
		this.revF2 = revF2;
		this.ctrtSrepCd = ctrtSrepCd;
		this.slsWk = slsWk;
		this.totS2 = totS2;
		this.totS4 = totS4;
		this.rOther = rOther;
		this.subTotNet = subTotNet;
		this.blObrdWk = blObrdWk;
		this.subTotD2 = subTotD2;
		this.teuTtl = teuTtl;
		this.custNm = custNm;
		this.revQ4 = revQ4;
		this.revQ2 = revQ2;
		this.voidTeu = voidTeu;
		this.net = net;
		this.subTotD5 = subTotD5;
		this.teuGross = teuGross;
		this.subTotD4 = subTotD4;
		this.subTot20 = subTot20;
		this.cnnfNm = cnnfNm;
		this.totMisc = totMisc;
		this.totRd2 = totRd2;
		this.subTotTtl = subTotTtl;
		this.subTotGross = subTotGross;
		this.totRd4 = totRd4;
		this.totR4 = totR4;
		this.f2 = f2;
		this.totR2 = totR2;
		this.ofcCnt = ofcCnt;
		this.subTotRth = subTotRth;
		this.f4 = f4;
		this.voidSlot = voidSlot;
		this.ibSlsOfcCd = ibSlsOfcCd;
		this.o2 = o2;
		this.o4 = o4;
		this.revP2 = revP2;
		this.revP4 = revP4;
		this.ttl = ttl;
		this.repKnd = repKnd;
		this.slsYrmon = slsYrmon;
		this.slanCd = slanCd;
		this.subTotTac = subTotTac;
		this.voidFeu = voidFeu;
		this.totDth = totDth;
		this.doc = doc;
		this.totGross = totGross;
		this.repCmdtCd = repCmdtCd;
		this.subTotR4 = subTotR4;
		this.subTotR2 = subTotR2;
		this.totVoidTeu = totVoidTeu;
		this.d5 = d5;
		this.blNo = blNo;
		this.d4 = d4;
		this.subTot40 = subTot40;
		this.revR4 = revR4;
		this.d2 = d2;
		this.polCd = polCd;
		this.ibsOfcNt = ibsOfcNt;
		this.revR2 = revR2;
		this.oth = oth;
		this.scNo = scNo;
		this.orgSvc = orgSvc;
		this.dth = dth;
		this.obSlsOfcCd = obSlsOfcCd;
		this.obSrepNm = obSrepNm;
		this.subTotDoc = subTotDoc;
		this.custGrpId = custGrpId;
		this.subTotS2 = subTotS2;
		this.repCmdtNm = repCmdtNm;
		this.subTotRd4 = subTotRd4;
		this.totSlo = totSlo;
		this.subTotS4 = subTotS4;
		this.frtTermCd = frtTermCd;
		this.delCd = delCd;
		this.subTotRd2 = subTotRd2;
		this.rd4 = rd4;
		this.slsRhqCd = slsRhqCd;
		this.rd2 = rd2;
		this.dstSvc = dstSvc;
		this.vvd = vvd;
		this.subTotSlo = subTotSlo;
		this.totOth = totOth;
		this.blObrdDt = blObrdDt;
		this.t4 = t4;
		this.subTotDth = subTotDth;
		this.teu = teu;
		this.voidRpb = voidRpb;
		this.totSum = totSum;
		this.grpBy = grpBy;
		this.totCaf = totCaf;
		this.porCd = porCd;
		this.t2 = t2;
		this.gross = gross;
		this.subTotVoidFeu = subTotVoidFeu;
		this.totVoidFeu = totVoidFeu;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.subTotNonRev = subTotNonRev;
		this.subTotMisc = subTotMisc;
		this.totNet = totNet;
		this.revT4 = revT4;
		this.rfaNo = rfaNo;
		this.revDirCd = revDirCd;
		this.revT2 = revT2;
		this.ibflag = ibflag;
		this.totDoc = totDoc;
		this.totFeu = totFeu;
		this.subTotFeu = subTotFeu;
		this.ibWk = ibWk;
		this.caf = caf;
		this.s4 = s4;
		this.s2 = s2;
		this.totTac = totTac;
		this.revD4 = revD4;
		this.revD2 = revD2;
		this.subTotVoidTeu = subTotVoidTeu;
		this.repCustCd = repCustCd;
		this.oft = oft;
		this.totTeu = totTeu;
		this.custSeq = custSeq;
		this.io = io;
		this.tot20 = tot20;
		this.totNonNet = totNonNet;
		this.misc = misc;
		this.subTotOth = subTotOth;
		this.totOft = totOft;
		this.subTotTeu = subTotTeu;
		this.box = box;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.r2 = r2;
		this.subTotNonNet = subTotNonNet;
		this.r4 = r4;
		this.nonNet = nonNet;
		this.r5 = r5;
		this.revD5 = revD5;
		this.revR5 = revR5;
		this.d7 = d7;
		this.revD7 = revD7;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev_o4", getRevO4());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("p4", getP4());
		this.hashColumns.put("non_rev", getNonRev());
		this.hashColumns.put("p2", getP2());
		this.hashColumns.put("tac", getTac());
		this.hashColumns.put("rev_o2", getRevO2());
		this.hashColumns.put("feu_gross", getFeuGross());
		this.hashColumns.put("ib_wk_pod_cd", getIbWkPodCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnnf_cd", getCnnfCd());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("sub_tot_baf", getSubTotBaf());
		this.hashColumns.put("rpb", getRpb());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("tot_d2", getTotD2());
		this.hashColumns.put("eq_rpb", getEqRpb());
		this.hashColumns.put("tot_d4", getTotD4());
		this.hashColumns.put("bkg_pod", getBkgPod());
		this.hashColumns.put("tot_d5", getTotD5());
		this.hashColumns.put("tot_rth", getTotRth());
		this.hashColumns.put("rep_acct_nm", getRepAcctNm());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("sub_tot_caf", getSubTotCaf());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("tot_non_rev", getTotNonRev());
		this.hashColumns.put("tot_40", getTot40());
		this.hashColumns.put("feu", getFeu());
		this.hashColumns.put("tot_baf", getTotBaf());
		this.hashColumns.put("q2", getQ2());
		this.hashColumns.put("first_vvd", getFirstVvd());
		this.hashColumns.put("q4", getQ4());
		this.hashColumns.put("sub_tot_oft", getSubTotOft());
		this.hashColumns.put("gso", getGso());
		this.hashColumns.put("baf", getBaf());
		this.hashColumns.put("rev_f4", getRevF4());
		this.hashColumns.put("rev_rd2", getRevRd2());
		this.hashColumns.put("tot_ttl", getTotTtl());
		this.hashColumns.put("rev_rd4", getRevRd4());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rgn_cnt", getRgnCnt());
		this.hashColumns.put("rev_f2", getRevF2());
		this.hashColumns.put("ctrt_srep_cd", getCtrtSrepCd());
		this.hashColumns.put("sls_wk", getSlsWk());
		this.hashColumns.put("tot_s2", getTotS2());
		this.hashColumns.put("tot_s4", getTotS4());
		this.hashColumns.put("r_other", getROther());
		this.hashColumns.put("sub_tot_net", getSubTotNet());
		this.hashColumns.put("bl_obrd_wk", getBlObrdWk());
		this.hashColumns.put("sub_tot_d2", getSubTotD2());
		this.hashColumns.put("teu_ttl", getTeuTtl());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("rev_q4", getRevQ4());
		this.hashColumns.put("rev_q2", getRevQ2());
		this.hashColumns.put("void_teu", getVoidTeu());
		this.hashColumns.put("net", getNet());
		this.hashColumns.put("sub_tot_d5", getSubTotD5());
		this.hashColumns.put("teu_gross", getTeuGross());
		this.hashColumns.put("sub_tot_d4", getSubTotD4());
		this.hashColumns.put("sub_tot_20", getSubTot20());
		this.hashColumns.put("cnnf_nm", getCnnfNm());
		this.hashColumns.put("tot_misc", getTotMisc());
		this.hashColumns.put("tot_rd2", getTotRd2());
		this.hashColumns.put("sub_tot_ttl", getSubTotTtl());
		this.hashColumns.put("sub_tot_gross", getSubTotGross());
		this.hashColumns.put("tot_rd4", getTotRd4());
		this.hashColumns.put("tot_r4", getTotR4());
		this.hashColumns.put("f2", getF2());
		this.hashColumns.put("tot_r2", getTotR2());
		this.hashColumns.put("ofc_cnt", getOfcCnt());
		this.hashColumns.put("sub_tot_rth", getSubTotRth());
		this.hashColumns.put("f4", getF4());
		this.hashColumns.put("void_slot", getVoidSlot());
		this.hashColumns.put("ib_sls_ofc_cd", getIbSlsOfcCd());
		this.hashColumns.put("o2", getO2());
		this.hashColumns.put("o4", getO4());
		this.hashColumns.put("rev_p2", getRevP2());
		this.hashColumns.put("rev_p4", getRevP4());
		this.hashColumns.put("ttl", getTtl());
		this.hashColumns.put("rep_knd", getRepKnd());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("sub_tot_tac", getSubTotTac());
		this.hashColumns.put("void_feu", getVoidFeu());
		this.hashColumns.put("tot_dth", getTotDth());
		this.hashColumns.put("doc", getDoc());
		this.hashColumns.put("tot_gross", getTotGross());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("sub_tot_r4", getSubTotR4());
		this.hashColumns.put("sub_tot_r2", getSubTotR2());
		this.hashColumns.put("tot_void_teu", getTotVoidTeu());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("sub_tot_40", getSubTot40());
		this.hashColumns.put("rev_r4", getRevR4());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibs_ofc_nt", getIbsOfcNt());
		this.hashColumns.put("rev_r2", getRevR2());
		this.hashColumns.put("oth", getOth());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("org_svc", getOrgSvc());
		this.hashColumns.put("dth", getDth());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("ob_srep_nm", getObSrepNm());
		this.hashColumns.put("sub_tot_doc", getSubTotDoc());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("sub_tot_s2", getSubTotS2());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("sub_tot_rd4", getSubTotRd4());
		this.hashColumns.put("tot_slo", getTotSlo());
		this.hashColumns.put("sub_tot_s4", getSubTotS4());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("sub_tot_rd2", getSubTotRd2());
		this.hashColumns.put("rd4", getRd4());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("rd2", getRd2());
		this.hashColumns.put("dst_svc", getDstSvc());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("sub_tot_slo", getSubTotSlo());
		this.hashColumns.put("tot_oth", getTotOth());
		this.hashColumns.put("bl_obrd_dt", getBlObrdDt());
		this.hashColumns.put("t4", getT4());
		this.hashColumns.put("sub_tot_dth", getSubTotDth());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("void_rpb", getVoidRpb());
		this.hashColumns.put("tot_sum", getTotSum());
		this.hashColumns.put("grp_by", getGrpBy());
		this.hashColumns.put("tot_caf", getTotCaf());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("t2", getT2());
		this.hashColumns.put("gross", getGross());
		this.hashColumns.put("sub_tot_void_feu", getSubTotVoidFeu());
		this.hashColumns.put("tot_void_feu", getTotVoidFeu());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("sub_tot_non_rev", getSubTotNonRev());
		this.hashColumns.put("sub_tot_misc", getSubTotMisc());
		this.hashColumns.put("tot_net", getTotNet());
		this.hashColumns.put("rev_t4", getRevT4());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("rev_t2", getRevT2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tot_doc", getTotDoc());
		this.hashColumns.put("tot_feu", getTotFeu());
		this.hashColumns.put("sub_tot_feu", getSubTotFeu());
		this.hashColumns.put("ib_wk", getIbWk());
		this.hashColumns.put("caf", getCaf());
		this.hashColumns.put("s4", getS4());
		this.hashColumns.put("s2", getS2());
		this.hashColumns.put("tot_tac", getTotTac());
		this.hashColumns.put("rev_d4", getRevD4());
		this.hashColumns.put("rev_d2", getRevD2());
		this.hashColumns.put("sub_tot_void_teu", getSubTotVoidTeu());
		this.hashColumns.put("rep_cust_cd", getRepCustCd());
		this.hashColumns.put("oft", getOft());
		this.hashColumns.put("tot_teu", getTotTeu());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("io", getIo());
		this.hashColumns.put("tot_20", getTot20());
		this.hashColumns.put("tot_non_net", getTotNonNet());
		this.hashColumns.put("misc", getMisc());
		this.hashColumns.put("sub_tot_oth", getSubTotOth());
		this.hashColumns.put("tot_oft", getTotOft());
		this.hashColumns.put("sub_tot_teu", getSubTotTeu());
		this.hashColumns.put("box", getBox());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("sub_tot_non_net", getSubTotNonNet());
		this.hashColumns.put("r4", getR4());
		this.hashColumns.put("non_net", getNonNet());
		this.hashColumns.put("r5", getR5());
		this.hashColumns.put("rev_d5", getRevD5());
		this.hashColumns.put("rev_r5", getRevR5());
		this.hashColumns.put("d7", getD7());
		this.hashColumns.put("rev_d7", getRevD7());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev_o4", "revO4");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("p4", "p4");
		this.hashFields.put("non_rev", "nonRev");
		this.hashFields.put("p2", "p2");
		this.hashFields.put("tac", "tac");
		this.hashFields.put("rev_o2", "revO2");
		this.hashFields.put("feu_gross", "feuGross");
		this.hashFields.put("ib_wk_pod_cd", "ibWkPodCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnnf_cd", "cnnfCd");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("sub_tot_baf", "subTotBaf");
		this.hashFields.put("rpb", "rpb");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("tot_d2", "totD2");
		this.hashFields.put("eq_rpb", "eqRpb");
		this.hashFields.put("tot_d4", "totD4");
		this.hashFields.put("bkg_pod", "bkgPod");
		this.hashFields.put("tot_d5", "totD5");
		this.hashFields.put("tot_rth", "totRth");
		this.hashFields.put("rep_acct_nm", "repAcctNm");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("sub_tot_caf", "subTotCaf");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("tot_non_rev", "totNonRev");
		this.hashFields.put("tot_40", "tot40");
		this.hashFields.put("feu", "feu");
		this.hashFields.put("tot_baf", "totBaf");
		this.hashFields.put("q2", "q2");
		this.hashFields.put("first_vvd", "firstVvd");
		this.hashFields.put("q4", "q4");
		this.hashFields.put("sub_tot_oft", "subTotOft");
		this.hashFields.put("gso", "gso");
		this.hashFields.put("baf", "baf");
		this.hashFields.put("rev_f4", "revF4");
		this.hashFields.put("rev_rd2", "revRd2");
		this.hashFields.put("tot_ttl", "totTtl");
		this.hashFields.put("rev_rd4", "revRd4");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rgn_cnt", "rgnCnt");
		this.hashFields.put("rev_f2", "revF2");
		this.hashFields.put("ctrt_srep_cd", "ctrtSrepCd");
		this.hashFields.put("sls_wk", "slsWk");
		this.hashFields.put("tot_s2", "totS2");
		this.hashFields.put("tot_s4", "totS4");
		this.hashFields.put("r_other", "rOther");
		this.hashFields.put("sub_tot_net", "subTotNet");
		this.hashFields.put("bl_obrd_wk", "blObrdWk");
		this.hashFields.put("sub_tot_d2", "subTotD2");
		this.hashFields.put("teu_ttl", "teuTtl");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("rev_q4", "revQ4");
		this.hashFields.put("rev_q2", "revQ2");
		this.hashFields.put("void_teu", "voidTeu");
		this.hashFields.put("net", "net");
		this.hashFields.put("sub_tot_d5", "subTotD5");
		this.hashFields.put("teu_gross", "teuGross");
		this.hashFields.put("sub_tot_d4", "subTotD4");
		this.hashFields.put("sub_tot_20", "subTot20");
		this.hashFields.put("cnnf_nm", "cnnfNm");
		this.hashFields.put("tot_misc", "totMisc");
		this.hashFields.put("tot_rd2", "totRd2");
		this.hashFields.put("sub_tot_ttl", "subTotTtl");
		this.hashFields.put("sub_tot_gross", "subTotGross");
		this.hashFields.put("tot_rd4", "totRd4");
		this.hashFields.put("tot_r4", "totR4");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("tot_r2", "totR2");
		this.hashFields.put("ofc_cnt", "ofcCnt");
		this.hashFields.put("sub_tot_rth", "subTotRth");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("void_slot", "voidSlot");
		this.hashFields.put("ib_sls_ofc_cd", "ibSlsOfcCd");
		this.hashFields.put("o2", "o2");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("rev_p2", "revP2");
		this.hashFields.put("rev_p4", "revP4");
		this.hashFields.put("ttl", "ttl");
		this.hashFields.put("rep_knd", "repKnd");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("sub_tot_tac", "subTotTac");
		this.hashFields.put("void_feu", "voidFeu");
		this.hashFields.put("tot_dth", "totDth");
		this.hashFields.put("doc", "doc");
		this.hashFields.put("tot_gross", "totGross");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("sub_tot_r4", "subTotR4");
		this.hashFields.put("sub_tot_r2", "subTotR2");
		this.hashFields.put("tot_void_teu", "totVoidTeu");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("sub_tot_40", "subTot40");
		this.hashFields.put("rev_r4", "revR4");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibs_ofc_nt", "ibsOfcNt");
		this.hashFields.put("rev_r2", "revR2");
		this.hashFields.put("oth", "oth");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("org_svc", "orgSvc");
		this.hashFields.put("dth", "dth");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("ob_srep_nm", "obSrepNm");
		this.hashFields.put("sub_tot_doc", "subTotDoc");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("sub_tot_s2", "subTotS2");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("sub_tot_rd4", "subTotRd4");
		this.hashFields.put("tot_slo", "totSlo");
		this.hashFields.put("sub_tot_s4", "subTotS4");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("sub_tot_rd2", "subTotRd2");
		this.hashFields.put("rd4", "rd4");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("rd2", "rd2");
		this.hashFields.put("dst_svc", "dstSvc");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("sub_tot_slo", "subTotSlo");
		this.hashFields.put("tot_oth", "totOth");
		this.hashFields.put("bl_obrd_dt", "blObrdDt");
		this.hashFields.put("t4", "t4");
		this.hashFields.put("sub_tot_dth", "subTotDth");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("void_rpb", "voidRpb");
		this.hashFields.put("tot_sum", "totSum");
		this.hashFields.put("grp_by", "grpBy");
		this.hashFields.put("tot_caf", "totCaf");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("t2", "t2");
		this.hashFields.put("gross", "gross");
		this.hashFields.put("sub_tot_void_feu", "subTotVoidFeu");
		this.hashFields.put("tot_void_feu", "totVoidFeu");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("sub_tot_non_rev", "subTotNonRev");
		this.hashFields.put("sub_tot_misc", "subTotMisc");
		this.hashFields.put("tot_net", "totNet");
		this.hashFields.put("rev_t4", "revT4");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("rev_t2", "revT2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tot_doc", "totDoc");
		this.hashFields.put("tot_feu", "totFeu");
		this.hashFields.put("sub_tot_feu", "subTotFeu");
		this.hashFields.put("ib_wk", "ibWk");
		this.hashFields.put("caf", "caf");
		this.hashFields.put("s4", "s4");
		this.hashFields.put("s2", "s2");
		this.hashFields.put("tot_tac", "totTac");
		this.hashFields.put("rev_d4", "revD4");
		this.hashFields.put("rev_d2", "revD2");
		this.hashFields.put("sub_tot_void_teu", "subTotVoidTeu");
		this.hashFields.put("rep_cust_cd", "repCustCd");
		this.hashFields.put("oft", "oft");
		this.hashFields.put("tot_teu", "totTeu");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("io", "io");
		this.hashFields.put("tot_20", "tot20");
		this.hashFields.put("tot_non_net", "totNonNet");
		this.hashFields.put("misc", "misc");
		this.hashFields.put("sub_tot_oth", "subTotOth");
		this.hashFields.put("tot_oft", "totOft");
		this.hashFields.put("sub_tot_teu", "subTotTeu");
		this.hashFields.put("box", "box");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("sub_tot_non_net", "subTotNonNet");
		this.hashFields.put("r4", "r4");
		this.hashFields.put("non_net", "nonNet");
		this.hashFields.put("r5", "r5");
		this.hashFields.put("rev_d5", "revD5");
		this.hashFields.put("rev_r5", "revR5");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("rev_d7", "revD7");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return revO4
	 */
	public String getRevO4() {
		return this.revO4;
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
	 * @return p4
	 */
	public String getP4() {
		return this.p4;
	}
	
	/**
	 * Column Info
	 * @return nonRev
	 */
	public String getNonRev() {
		return this.nonRev;
	}
	
	/**
	 * Column Info
	 * @return p2
	 */
	public String getP2() {
		return this.p2;
	}
	
	/**
	 * Column Info
	 * @return tac
	 */
	public String getTac() {
		return this.tac;
	}
	
	/**
	 * Column Info
	 * @return revO2
	 */
	public String getRevO2() {
		return this.revO2;
	}
	
	/**
	 * Column Info
	 * @return feuGross
	 */
	public String getFeuGross() {
		return this.feuGross;
	}
	
	/**
	 * Column Info
	 * @return ibWkPodCd
	 */
	public String getIbWkPodCd() {
		return this.ibWkPodCd;
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
	 * @return cnnfCd
	 */
	public String getCnnfCd() {
		return this.cnnfCd;
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
	 * @return subTotBaf
	 */
	public String getSubTotBaf() {
		return this.subTotBaf;
	}
	
	/**
	 * Column Info
	 * @return rpb
	 */
	public String getRpb() {
		return this.rpb;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return totD2
	 */
	public String getTotD2() {
		return this.totD2;
	}
	
	/**
	 * Column Info
	 * @return eqRpb
	 */
	public String getEqRpb() {
		return this.eqRpb;
	}
	
	/**
	 * Column Info
	 * @return totD4
	 */
	public String getTotD4() {
		return this.totD4;
	}
	
	/**
	 * Column Info
	 * @return bkgPod
	 */
	public String getBkgPod() {
		return this.bkgPod;
	}
	
	/**
	 * Column Info
	 * @return totD5
	 */
	public String getTotD5() {
		return this.totD5;
	}
	
	/**
	 * Column Info
	 * @return totRth
	 */
	public String getTotRth() {
		return this.totRth;
	}
	
	/**
	 * Column Info
	 * @return repAcctNm
	 */
	public String getRepAcctNm() {
		return this.repAcctNm;
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
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return subTotCaf
	 */
	public String getSubTotCaf() {
		return this.subTotCaf;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return totNonRev
	 */
	public String getTotNonRev() {
		return this.totNonRev;
	}
	
	/**
	 * Column Info
	 * @return tot40
	 */
	public String getTot40() {
		return this.tot40;
	}
	
	/**
	 * Column Info
	 * @return feu
	 */
	public String getFeu() {
		return this.feu;
	}
	
	/**
	 * Column Info
	 * @return totBaf
	 */
	public String getTotBaf() {
		return this.totBaf;
	}
	
	/**
	 * Column Info
	 * @return q2
	 */
	public String getQ2() {
		return this.q2;
	}
	
	/**
	 * Column Info
	 * @return firstVvd
	 */
	public String getFirstVvd() {
		return this.firstVvd;
	}
	
	/**
	 * Column Info
	 * @return q4
	 */
	public String getQ4() {
		return this.q4;
	}
	
	/**
	 * Column Info
	 * @return subTotOft
	 */
	public String getSubTotOft() {
		return this.subTotOft;
	}
	
	/**
	 * Column Info
	 * @return gso
	 */
	public String getGso() {
		return this.gso;
	}
	
	/**
	 * Column Info
	 * @return baf
	 */
	public String getBaf() {
		return this.baf;
	}
	
	/**
	 * Column Info
	 * @return revF4
	 */
	public String getRevF4() {
		return this.revF4;
	}
	
	/**
	 * Column Info
	 * @return revRd2
	 */
	public String getRevRd2() {
		return this.revRd2;
	}
	
	/**
	 * Column Info
	 * @return totTtl
	 */
	public String getTotTtl() {
		return this.totTtl;
	}
	
	/**
	 * Column Info
	 * @return revRd4
	 */
	public String getRevRd4() {
		return this.revRd4;
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
	 * @return rgnCnt
	 */
	public String getRgnCnt() {
		return this.rgnCnt;
	}
	
	/**
	 * Column Info
	 * @return revF2
	 */
	public String getRevF2() {
		return this.revF2;
	}
	
	/**
	 * Column Info
	 * @return ctrtSrepCd
	 */
	public String getCtrtSrepCd() {
		return this.ctrtSrepCd;
	}
	
	/**
	 * Column Info
	 * @return slsWk
	 */
	public String getSlsWk() {
		return this.slsWk;
	}
	
	/**
	 * Column Info
	 * @return totS2
	 */
	public String getTotS2() {
		return this.totS2;
	}
	
	/**
	 * Column Info
	 * @return totS4
	 */
	public String getTotS4() {
		return this.totS4;
	}
	
	/**
	 * Column Info
	 * @return rOther
	 */
	public String getROther() {
		return this.rOther;
	}
	
	/**
	 * Column Info
	 * @return subTotNet
	 */
	public String getSubTotNet() {
		return this.subTotNet;
	}
	
	/**
	 * Column Info
	 * @return blObrdWk
	 */
	public String getBlObrdWk() {
		return this.blObrdWk;
	}
	
	/**
	 * Column Info
	 * @return subTotD2
	 */
	public String getSubTotD2() {
		return this.subTotD2;
	}
	
	/**
	 * Column Info
	 * @return teuTtl
	 */
	public String getTeuTtl() {
		return this.teuTtl;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return revQ4
	 */
	public String getRevQ4() {
		return this.revQ4;
	}
	
	/**
	 * Column Info
	 * @return revQ2
	 */
	public String getRevQ2() {
		return this.revQ2;
	}
	
	/**
	 * Column Info
	 * @return voidTeu
	 */
	public String getVoidTeu() {
		return this.voidTeu;
	}
	
	/**
	 * Column Info
	 * @return net
	 */
	public String getNet() {
		return this.net;
	}
	
	/**
	 * Column Info
	 * @return subTotD5
	 */
	public String getSubTotD5() {
		return this.subTotD5;
	}
	
	/**
	 * Column Info
	 * @return teuGross
	 */
	public String getTeuGross() {
		return this.teuGross;
	}
	
	/**
	 * Column Info
	 * @return subTotD4
	 */
	public String getSubTotD4() {
		return this.subTotD4;
	}
	
	/**
	 * Column Info
	 * @return subTot20
	 */
	public String getSubTot20() {
		return this.subTot20;
	}
	
	/**
	 * Column Info
	 * @return cnnfNm
	 */
	public String getCnnfNm() {
		return this.cnnfNm;
	}
	
	/**
	 * Column Info
	 * @return totMisc
	 */
	public String getTotMisc() {
		return this.totMisc;
	}
	
	/**
	 * Column Info
	 * @return totRd2
	 */
	public String getTotRd2() {
		return this.totRd2;
	}
	
	/**
	 * Column Info
	 * @return subTotTtl
	 */
	public String getSubTotTtl() {
		return this.subTotTtl;
	}
	
	/**
	 * Column Info
	 * @return subTotGross
	 */
	public String getSubTotGross() {
		return this.subTotGross;
	}
	
	/**
	 * Column Info
	 * @return totRd4
	 */
	public String getTotRd4() {
		return this.totRd4;
	}
	
	/**
	 * Column Info
	 * @return totR4
	 */
	public String getTotR4() {
		return this.totR4;
	}
	
	/**
	 * Column Info
	 * @return f2
	 */
	public String getF2() {
		return this.f2;
	}
	
	/**
	 * Column Info
	 * @return totR2
	 */
	public String getTotR2() {
		return this.totR2;
	}
	
	/**
	 * Column Info
	 * @return ofcCnt
	 */
	public String getOfcCnt() {
		return this.ofcCnt;
	}
	
	/**
	 * Column Info
	 * @return subTotRth
	 */
	public String getSubTotRth() {
		return this.subTotRth;
	}
	
	/**
	 * Column Info
	 * @return f4
	 */
	public String getF4() {
		return this.f4;
	}
	
	/**
	 * Column Info
	 * @return voidSlot
	 */
	public String getVoidSlot() {
		return this.voidSlot;
	}
	
	/**
	 * Column Info
	 * @return ibSlsOfcCd
	 */
	public String getIbSlsOfcCd() {
		return this.ibSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return o2
	 */
	public String getO2() {
		return this.o2;
	}
	
	/**
	 * Column Info
	 * @return o4
	 */
	public String getO4() {
		return this.o4;
	}
	
	/**
	 * Column Info
	 * @return revP2
	 */
	public String getRevP2() {
		return this.revP2;
	}
	
	/**
	 * Column Info
	 * @return revP4
	 */
	public String getRevP4() {
		return this.revP4;
	}
	
	/**
	 * Column Info
	 * @return ttl
	 */
	public String getTtl() {
		return this.ttl;
	}
	
	/**
	 * Column Info
	 * @return repKnd
	 */
	public String getRepKnd() {
		return this.repKnd;
	}
	
	/**
	 * Column Info
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
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
	 * @return subTotTac
	 */
	public String getSubTotTac() {
		return this.subTotTac;
	}
	
	/**
	 * Column Info
	 * @return voidFeu
	 */
	public String getVoidFeu() {
		return this.voidFeu;
	}
	
	/**
	 * Column Info
	 * @return totDth
	 */
	public String getTotDth() {
		return this.totDth;
	}
	
	/**
	 * Column Info
	 * @return doc
	 */
	public String getDoc() {
		return this.doc;
	}
	
	/**
	 * Column Info
	 * @return totGross
	 */
	public String getTotGross() {
		return this.totGross;
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
	 * @return subTotR4
	 */
	public String getSubTotR4() {
		return this.subTotR4;
	}
	
	/**
	 * Column Info
	 * @return subTotR2
	 */
	public String getSubTotR2() {
		return this.subTotR2;
	}
	
	/**
	 * Column Info
	 * @return totVoidTeu
	 */
	public String getTotVoidTeu() {
		return this.totVoidTeu;
	}
	
	/**
	 * Column Info
	 * @return d5
	 */
	public String getD5() {
		return this.d5;
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
	 * @return d4
	 */
	public String getD4() {
		return this.d4;
	}
	
	/**
	 * Column Info
	 * @return subTot40
	 */
	public String getSubTot40() {
		return this.subTot40;
	}
	
	/**
	 * Column Info
	 * @return revR4
	 */
	public String getRevR4() {
		return this.revR4;
	}
	
	/**
	 * Column Info
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
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
	 * @return ibsOfcNt
	 */
	public String getIbsOfcNt() {
		return this.ibsOfcNt;
	}
	
	/**
	 * Column Info
	 * @return revR2
	 */
	public String getRevR2() {
		return this.revR2;
	}
	
	/**
	 * Column Info
	 * @return oth
	 */
	public String getOth() {
		return this.oth;
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
	 * @return orgSvc
	 */
	public String getOrgSvc() {
		return this.orgSvc;
	}
	
	/**
	 * Column Info
	 * @return dth
	 */
	public String getDth() {
		return this.dth;
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
	 * @return obSrepNm
	 */
	public String getObSrepNm() {
		return this.obSrepNm;
	}
	
	/**
	 * Column Info
	 * @return subTotDoc
	 */
	public String getSubTotDoc() {
		return this.subTotDoc;
	}
	
	/**
	 * Column Info
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
	}
	
	/**
	 * Column Info
	 * @return subTotS2
	 */
	public String getSubTotS2() {
		return this.subTotS2;
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
	 * @return subTotRd4
	 */
	public String getSubTotRd4() {
		return this.subTotRd4;
	}
	
	/**
	 * Column Info
	 * @return totSlo
	 */
	public String getTotSlo() {
		return this.totSlo;
	}
	
	/**
	 * Column Info
	 * @return subTotS4
	 */
	public String getSubTotS4() {
		return this.subTotS4;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
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
	 * @return subTotRd2
	 */
	public String getSubTotRd2() {
		return this.subTotRd2;
	}
	
	/**
	 * Column Info
	 * @return rd4
	 */
	public String getRd4() {
		return this.rd4;
	}
	
	/**
	 * Column Info
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @return rd2
	 */
	public String getRd2() {
		return this.rd2;
	}
	
	/**
	 * Column Info
	 * @return dstSvc
	 */
	public String getDstSvc() {
		return this.dstSvc;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return subTotSlo
	 */
	public String getSubTotSlo() {
		return this.subTotSlo;
	}
	
	/**
	 * Column Info
	 * @return totOth
	 */
	public String getTotOth() {
		return this.totOth;
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
	 * @return t4
	 */
	public String getT4() {
		return this.t4;
	}
	
	/**
	 * Column Info
	 * @return subTotDth
	 */
	public String getSubTotDth() {
		return this.subTotDth;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return voidRpb
	 */
	public String getVoidRpb() {
		return this.voidRpb;
	}
	
	/**
	 * Column Info
	 * @return totSum
	 */
	public String getTotSum() {
		return this.totSum;
	}
	
	/**
	 * Column Info
	 * @return grpBy
	 */
	public String getGrpBy() {
		return this.grpBy;
	}
	
	/**
	 * Column Info
	 * @return totCaf
	 */
	public String getTotCaf() {
		return this.totCaf;
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
	 * @return t2
	 */
	public String getT2() {
		return this.t2;
	}
	
	/**
	 * Column Info
	 * @return gross
	 */
	public String getGross() {
		return this.gross;
	}
	
	/**
	 * Column Info
	 * @return subTotVoidFeu
	 */
	public String getSubTotVoidFeu() {
		return this.subTotVoidFeu;
	}
	
	/**
	 * Column Info
	 * @return totVoidFeu
	 */
	public String getTotVoidFeu() {
		return this.totVoidFeu;
	}
	
	/**
	 * Column Info
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return subTotNonRev
	 */
	public String getSubTotNonRev() {
		return this.subTotNonRev;
	}
	
	/**
	 * Column Info
	 * @return subTotMisc
	 */
	public String getSubTotMisc() {
		return this.subTotMisc;
	}
	
	/**
	 * Column Info
	 * @return totNet
	 */
	public String getTotNet() {
		return this.totNet;
	}
	
	/**
	 * Column Info
	 * @return revT4
	 */
	public String getRevT4() {
		return this.revT4;
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
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
	}
	
	/**
	 * Column Info
	 * @return revT2
	 */
	public String getRevT2() {
		return this.revT2;
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
	 * @return totDoc
	 */
	public String getTotDoc() {
		return this.totDoc;
	}
	
	/**
	 * Column Info
	 * @return totFeu
	 */
	public String getTotFeu() {
		return this.totFeu;
	}
	
	/**
	 * Column Info
	 * @return subTotFeu
	 */
	public String getSubTotFeu() {
		return this.subTotFeu;
	}
	
	/**
	 * Column Info
	 * @return ibWk
	 */
	public String getIbWk() {
		return this.ibWk;
	}
	
	/**
	 * Column Info
	 * @return caf
	 */
	public String getCaf() {
		return this.caf;
	}
	
	/**
	 * Column Info
	 * @return s4
	 */
	public String getS4() {
		return this.s4;
	}
	
	/**
	 * Column Info
	 * @return s2
	 */
	public String getS2() {
		return this.s2;
	}
	
	/**
	 * Column Info
	 * @return totTac
	 */
	public String getTotTac() {
		return this.totTac;
	}
	
	/**
	 * Column Info
	 * @return revD4
	 */
	public String getRevD4() {
		return this.revD4;
	}
	
	/**
	 * Column Info
	 * @return revD2
	 */
	public String getRevD2() {
		return this.revD2;
	}
	
	/**
	 * Column Info
	 * @return subTotVoidTeu
	 */
	public String getSubTotVoidTeu() {
		return this.subTotVoidTeu;
	}
	
	/**
	 * Column Info
	 * @return repCustCd
	 */
	public String getRepCustCd() {
		return this.repCustCd;
	}
	
	/**
	 * Column Info
	 * @return oft
	 */
	public String getOft() {
		return this.oft;
	}
	
	/**
	 * Column Info
	 * @return totTeu
	 */
	public String getTotTeu() {
		return this.totTeu;
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
	 * @return io
	 */
	public String getIo() {
		return this.io;
	}
	
	/**
	 * Column Info
	 * @return tot20
	 */
	public String getTot20() {
		return this.tot20;
	}
	
	/**
	 * Column Info
	 * @return totNonNet
	 */
	public String getTotNonNet() {
		return this.totNonNet;
	}
	
	/**
	 * Column Info
	 * @return misc
	 */
	public String getMisc() {
		return this.misc;
	}
	
	/**
	 * Column Info
	 * @return subTotOth
	 */
	public String getSubTotOth() {
		return this.subTotOth;
	}
	
	/**
	 * Column Info
	 * @return totOft
	 */
	public String getTotOft() {
		return this.totOft;
	}
	
	/**
	 * Column Info
	 * @return subTotTeu
	 */
	public String getSubTotTeu() {
		return this.subTotTeu;
	}
	
	/**
	 * Column Info
	 * @return box
	 */
	public String getBox() {
		return this.box;
	}
	
	/**
	 * Column Info
	 * @return slsRgnOfcCd
	 */
	public String getSlsRgnOfcCd() {
		return this.slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return r2
	 */
	public String getR2() {
		return this.r2;
	}
	
	/**
	 * Column Info
	 * @return subTotNonNet
	 */
	public String getSubTotNonNet() {
		return this.subTotNonNet;
	}
	
	/**
	 * Column Info
	 * @return r4
	 */
	public String getR4() {
		return this.r4;
	}
	
	/**
	 * Column Info
	 * @return nonNet
	 */
	public String getNonNet() {
		return this.nonNet;
	}
	
	/**
	 * Column Info
	 * @return r5
	 */
	public String getR5() {
		return this.r5;
	}
	
	/**
	 * Column Info
	 * @return revD5
	 */
	public String getRevD5() {
		return this.revD5;
	}
	
	/**
	 * Column Info
	 * @return revR5
	 */
	public String getRevR5() {
		return this.revR5;
	}
	
	/**
	 * Column Info
	 * @return d7
	 */
	public String getD7() {
		return this.d7;
	}
	
	/**
	 * Column Info
	 * @return revD7
	 */
	public String getRevD7() {
		return this.revD7;
	}
	

	/**
	 * Column Info
	 * @param revO4
	 */
	public void setRevO4(String revO4) {
		this.revO4 = revO4;
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
	 * @param p4
	 */
	public void setP4(String p4) {
		this.p4 = p4;
	}
	
	/**
	 * Column Info
	 * @param nonRev
	 */
	public void setNonRev(String nonRev) {
		this.nonRev = nonRev;
	}
	
	/**
	 * Column Info
	 * @param p2
	 */
	public void setP2(String p2) {
		this.p2 = p2;
	}
	
	/**
	 * Column Info
	 * @param tac
	 */
	public void setTac(String tac) {
		this.tac = tac;
	}
	
	/**
	 * Column Info
	 * @param revO2
	 */
	public void setRevO2(String revO2) {
		this.revO2 = revO2;
	}
	
	/**
	 * Column Info
	 * @param feuGross
	 */
	public void setFeuGross(String feuGross) {
		this.feuGross = feuGross;
	}
	
	/**
	 * Column Info
	 * @param ibWkPodCd
	 */
	public void setIbWkPodCd(String ibWkPodCd) {
		this.ibWkPodCd = ibWkPodCd;
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
	 * @param cnnfCd
	 */
	public void setCnnfCd(String cnnfCd) {
		this.cnnfCd = cnnfCd;
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
	 * @param subTotBaf
	 */
	public void setSubTotBaf(String subTotBaf) {
		this.subTotBaf = subTotBaf;
	}
	
	/**
	 * Column Info
	 * @param rpb
	 */
	public void setRpb(String rpb) {
		this.rpb = rpb;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param totD2
	 */
	public void setTotD2(String totD2) {
		this.totD2 = totD2;
	}
	
	/**
	 * Column Info
	 * @param eqRpb
	 */
	public void setEqRpb(String eqRpb) {
		this.eqRpb = eqRpb;
	}
	
	/**
	 * Column Info
	 * @param totD4
	 */
	public void setTotD4(String totD4) {
		this.totD4 = totD4;
	}
	
	/**
	 * Column Info
	 * @param bkgPod
	 */
	public void setBkgPod(String bkgPod) {
		this.bkgPod = bkgPod;
	}
	
	/**
	 * Column Info
	 * @param totD5
	 */
	public void setTotD5(String totD5) {
		this.totD5 = totD5;
	}
	
	/**
	 * Column Info
	 * @param totRth
	 */
	public void setTotRth(String totRth) {
		this.totRth = totRth;
	}
	
	/**
	 * Column Info
	 * @param repAcctNm
	 */
	public void setRepAcctNm(String repAcctNm) {
		this.repAcctNm = repAcctNm;
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
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param subTotCaf
	 */
	public void setSubTotCaf(String subTotCaf) {
		this.subTotCaf = subTotCaf;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param totNonRev
	 */
	public void setTotNonRev(String totNonRev) {
		this.totNonRev = totNonRev;
	}
	
	/**
	 * Column Info
	 * @param tot40
	 */
	public void setTot40(String tot40) {
		this.tot40 = tot40;
	}
	
	/**
	 * Column Info
	 * @param feu
	 */
	public void setFeu(String feu) {
		this.feu = feu;
	}
	
	/**
	 * Column Info
	 * @param totBaf
	 */
	public void setTotBaf(String totBaf) {
		this.totBaf = totBaf;
	}
	
	/**
	 * Column Info
	 * @param q2
	 */
	public void setQ2(String q2) {
		this.q2 = q2;
	}
	
	/**
	 * Column Info
	 * @param firstVvd
	 */
	public void setFirstVvd(String firstVvd) {
		this.firstVvd = firstVvd;
	}
	
	/**
	 * Column Info
	 * @param q4
	 */
	public void setQ4(String q4) {
		this.q4 = q4;
	}
	
	/**
	 * Column Info
	 * @param subTotOft
	 */
	public void setSubTotOft(String subTotOft) {
		this.subTotOft = subTotOft;
	}
	
	/**
	 * Column Info
	 * @param gso
	 */
	public void setGso(String gso) {
		this.gso = gso;
	}
	
	/**
	 * Column Info
	 * @param baf
	 */
	public void setBaf(String baf) {
		this.baf = baf;
	}
	
	/**
	 * Column Info
	 * @param revF4
	 */
	public void setRevF4(String revF4) {
		this.revF4 = revF4;
	}
	
	/**
	 * Column Info
	 * @param revRd2
	 */
	public void setRevRd2(String revRd2) {
		this.revRd2 = revRd2;
	}
	
	/**
	 * Column Info
	 * @param totTtl
	 */
	public void setTotTtl(String totTtl) {
		this.totTtl = totTtl;
	}
	
	/**
	 * Column Info
	 * @param revRd4
	 */
	public void setRevRd4(String revRd4) {
		this.revRd4 = revRd4;
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
	 * @param rgnCnt
	 */
	public void setRgnCnt(String rgnCnt) {
		this.rgnCnt = rgnCnt;
	}
	
	/**
	 * Column Info
	 * @param revF2
	 */
	public void setRevF2(String revF2) {
		this.revF2 = revF2;
	}
	
	/**
	 * Column Info
	 * @param ctrtSrepCd
	 */
	public void setCtrtSrepCd(String ctrtSrepCd) {
		this.ctrtSrepCd = ctrtSrepCd;
	}
	
	/**
	 * Column Info
	 * @param slsWk
	 */
	public void setSlsWk(String slsWk) {
		this.slsWk = slsWk;
	}
	
	/**
	 * Column Info
	 * @param totS2
	 */
	public void setTotS2(String totS2) {
		this.totS2 = totS2;
	}
	
	/**
	 * Column Info
	 * @param totS4
	 */
	public void setTotS4(String totS4) {
		this.totS4 = totS4;
	}
	
	/**
	 * Column Info
	 * @param rOther
	 */
	public void setROther(String rOther) {
		this.rOther = rOther;
	}
	
	/**
	 * Column Info
	 * @param subTotNet
	 */
	public void setSubTotNet(String subTotNet) {
		this.subTotNet = subTotNet;
	}
	
	/**
	 * Column Info
	 * @param blObrdWk
	 */
	public void setBlObrdWk(String blObrdWk) {
		this.blObrdWk = blObrdWk;
	}
	
	/**
	 * Column Info
	 * @param subTotD2
	 */
	public void setSubTotD2(String subTotD2) {
		this.subTotD2 = subTotD2;
	}
	
	/**
	 * Column Info
	 * @param teuTtl
	 */
	public void setTeuTtl(String teuTtl) {
		this.teuTtl = teuTtl;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param revQ4
	 */
	public void setRevQ4(String revQ4) {
		this.revQ4 = revQ4;
	}
	
	/**
	 * Column Info
	 * @param revQ2
	 */
	public void setRevQ2(String revQ2) {
		this.revQ2 = revQ2;
	}
	
	/**
	 * Column Info
	 * @param voidTeu
	 */
	public void setVoidTeu(String voidTeu) {
		this.voidTeu = voidTeu;
	}
	
	/**
	 * Column Info
	 * @param net
	 */
	public void setNet(String net) {
		this.net = net;
	}
	
	/**
	 * Column Info
	 * @param subTotD5
	 */
	public void setSubTotD5(String subTotD5) {
		this.subTotD5 = subTotD5;
	}
	
	/**
	 * Column Info
	 * @param teuGross
	 */
	public void setTeuGross(String teuGross) {
		this.teuGross = teuGross;
	}
	
	/**
	 * Column Info
	 * @param subTotD4
	 */
	public void setSubTotD4(String subTotD4) {
		this.subTotD4 = subTotD4;
	}
	
	/**
	 * Column Info
	 * @param subTot20
	 */
	public void setSubTot20(String subTot20) {
		this.subTot20 = subTot20;
	}
	
	/**
	 * Column Info
	 * @param cnnfNm
	 */
	public void setCnnfNm(String cnnfNm) {
		this.cnnfNm = cnnfNm;
	}
	
	/**
	 * Column Info
	 * @param totMisc
	 */
	public void setTotMisc(String totMisc) {
		this.totMisc = totMisc;
	}
	
	/**
	 * Column Info
	 * @param totRd2
	 */
	public void setTotRd2(String totRd2) {
		this.totRd2 = totRd2;
	}
	
	/**
	 * Column Info
	 * @param subTotTtl
	 */
	public void setSubTotTtl(String subTotTtl) {
		this.subTotTtl = subTotTtl;
	}
	
	/**
	 * Column Info
	 * @param subTotGross
	 */
	public void setSubTotGross(String subTotGross) {
		this.subTotGross = subTotGross;
	}
	
	/**
	 * Column Info
	 * @param totRd4
	 */
	public void setTotRd4(String totRd4) {
		this.totRd4 = totRd4;
	}
	
	/**
	 * Column Info
	 * @param totR4
	 */
	public void setTotR4(String totR4) {
		this.totR4 = totR4;
	}
	
	/**
	 * Column Info
	 * @param f2
	 */
	public void setF2(String f2) {
		this.f2 = f2;
	}
	
	/**
	 * Column Info
	 * @param totR2
	 */
	public void setTotR2(String totR2) {
		this.totR2 = totR2;
	}
	
	/**
	 * Column Info
	 * @param ofcCnt
	 */
	public void setOfcCnt(String ofcCnt) {
		this.ofcCnt = ofcCnt;
	}
	
	/**
	 * Column Info
	 * @param subTotRth
	 */
	public void setSubTotRth(String subTotRth) {
		this.subTotRth = subTotRth;
	}
	
	/**
	 * Column Info
	 * @param f4
	 */
	public void setF4(String f4) {
		this.f4 = f4;
	}
	
	/**
	 * Column Info
	 * @param voidSlot
	 */
	public void setVoidSlot(String voidSlot) {
		this.voidSlot = voidSlot;
	}
	
	/**
	 * Column Info
	 * @param ibSlsOfcCd
	 */
	public void setIbSlsOfcCd(String ibSlsOfcCd) {
		this.ibSlsOfcCd = ibSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param o2
	 */
	public void setO2(String o2) {
		this.o2 = o2;
	}
	
	/**
	 * Column Info
	 * @param o4
	 */
	public void setO4(String o4) {
		this.o4 = o4;
	}
	
	/**
	 * Column Info
	 * @param revP2
	 */
	public void setRevP2(String revP2) {
		this.revP2 = revP2;
	}
	
	/**
	 * Column Info
	 * @param revP4
	 */
	public void setRevP4(String revP4) {
		this.revP4 = revP4;
	}
	
	/**
	 * Column Info
	 * @param ttl
	 */
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	
	/**
	 * Column Info
	 * @param repKnd
	 */
	public void setRepKnd(String repKnd) {
		this.repKnd = repKnd;
	}
	
	/**
	 * Column Info
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
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
	 * @param subTotTac
	 */
	public void setSubTotTac(String subTotTac) {
		this.subTotTac = subTotTac;
	}
	
	/**
	 * Column Info
	 * @param voidFeu
	 */
	public void setVoidFeu(String voidFeu) {
		this.voidFeu = voidFeu;
	}
	
	/**
	 * Column Info
	 * @param totDth
	 */
	public void setTotDth(String totDth) {
		this.totDth = totDth;
	}
	
	/**
	 * Column Info
	 * @param doc
	 */
	public void setDoc(String doc) {
		this.doc = doc;
	}
	
	/**
	 * Column Info
	 * @param totGross
	 */
	public void setTotGross(String totGross) {
		this.totGross = totGross;
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
	 * @param subTotR4
	 */
	public void setSubTotR4(String subTotR4) {
		this.subTotR4 = subTotR4;
	}
	
	/**
	 * Column Info
	 * @param subTotR2
	 */
	public void setSubTotR2(String subTotR2) {
		this.subTotR2 = subTotR2;
	}
	
	/**
	 * Column Info
	 * @param totVoidTeu
	 */
	public void setTotVoidTeu(String totVoidTeu) {
		this.totVoidTeu = totVoidTeu;
	}
	
	/**
	 * Column Info
	 * @param d5
	 */
	public void setD5(String d5) {
		this.d5 = d5;
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
	 * @param d4
	 */
	public void setD4(String d4) {
		this.d4 = d4;
	}
	
	/**
	 * Column Info
	 * @param subTot40
	 */
	public void setSubTot40(String subTot40) {
		this.subTot40 = subTot40;
	}
	
	/**
	 * Column Info
	 * @param revR4
	 */
	public void setRevR4(String revR4) {
		this.revR4 = revR4;
	}
	
	/**
	 * Column Info
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
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
	 * @param ibsOfcNt
	 */
	public void setIbsOfcNt(String ibsOfcNt) {
		this.ibsOfcNt = ibsOfcNt;
	}
	
	/**
	 * Column Info
	 * @param revR2
	 */
	public void setRevR2(String revR2) {
		this.revR2 = revR2;
	}
	
	/**
	 * Column Info
	 * @param oth
	 */
	public void setOth(String oth) {
		this.oth = oth;
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
	 * @param orgSvc
	 */
	public void setOrgSvc(String orgSvc) {
		this.orgSvc = orgSvc;
	}
	
	/**
	 * Column Info
	 * @param dth
	 */
	public void setDth(String dth) {
		this.dth = dth;
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
	 * @param obSrepNm
	 */
	public void setObSrepNm(String obSrepNm) {
		this.obSrepNm = obSrepNm;
	}
	
	/**
	 * Column Info
	 * @param subTotDoc
	 */
	public void setSubTotDoc(String subTotDoc) {
		this.subTotDoc = subTotDoc;
	}
	
	/**
	 * Column Info
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
	}
	
	/**
	 * Column Info
	 * @param subTotS2
	 */
	public void setSubTotS2(String subTotS2) {
		this.subTotS2 = subTotS2;
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
	 * @param subTotRd4
	 */
	public void setSubTotRd4(String subTotRd4) {
		this.subTotRd4 = subTotRd4;
	}
	
	/**
	 * Column Info
	 * @param totSlo
	 */
	public void setTotSlo(String totSlo) {
		this.totSlo = totSlo;
	}
	
	/**
	 * Column Info
	 * @param subTotS4
	 */
	public void setSubTotS4(String subTotS4) {
		this.subTotS4 = subTotS4;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
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
	 * @param subTotRd2
	 */
	public void setSubTotRd2(String subTotRd2) {
		this.subTotRd2 = subTotRd2;
	}
	
	/**
	 * Column Info
	 * @param rd4
	 */
	public void setRd4(String rd4) {
		this.rd4 = rd4;
	}
	
	/**
	 * Column Info
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @param rd2
	 */
	public void setRd2(String rd2) {
		this.rd2 = rd2;
	}
	
	/**
	 * Column Info
	 * @param dstSvc
	 */
	public void setDstSvc(String dstSvc) {
		this.dstSvc = dstSvc;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param subTotSlo
	 */
	public void setSubTotSlo(String subTotSlo) {
		this.subTotSlo = subTotSlo;
	}
	
	/**
	 * Column Info
	 * @param totOth
	 */
	public void setTotOth(String totOth) {
		this.totOth = totOth;
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
	 * @param t4
	 */
	public void setT4(String t4) {
		this.t4 = t4;
	}
	
	/**
	 * Column Info
	 * @param subTotDth
	 */
	public void setSubTotDth(String subTotDth) {
		this.subTotDth = subTotDth;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param voidRpb
	 */
	public void setVoidRpb(String voidRpb) {
		this.voidRpb = voidRpb;
	}
	
	/**
	 * Column Info
	 * @param totSum
	 */
	public void setTotSum(String totSum) {
		this.totSum = totSum;
	}
	
	/**
	 * Column Info
	 * @param grpBy
	 */
	public void setGrpBy(String grpBy) {
		this.grpBy = grpBy;
	}
	
	/**
	 * Column Info
	 * @param totCaf
	 */
	public void setTotCaf(String totCaf) {
		this.totCaf = totCaf;
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
	 * @param t2
	 */
	public void setT2(String t2) {
		this.t2 = t2;
	}
	
	/**
	 * Column Info
	 * @param gross
	 */
	public void setGross(String gross) {
		this.gross = gross;
	}
	
	/**
	 * Column Info
	 * @param subTotVoidFeu
	 */
	public void setSubTotVoidFeu(String subTotVoidFeu) {
		this.subTotVoidFeu = subTotVoidFeu;
	}
	
	/**
	 * Column Info
	 * @param totVoidFeu
	 */
	public void setTotVoidFeu(String totVoidFeu) {
		this.totVoidFeu = totVoidFeu;
	}
	
	/**
	 * Column Info
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param subTotNonRev
	 */
	public void setSubTotNonRev(String subTotNonRev) {
		this.subTotNonRev = subTotNonRev;
	}
	
	/**
	 * Column Info
	 * @param subTotMisc
	 */
	public void setSubTotMisc(String subTotMisc) {
		this.subTotMisc = subTotMisc;
	}
	
	/**
	 * Column Info
	 * @param totNet
	 */
	public void setTotNet(String totNet) {
		this.totNet = totNet;
	}
	
	/**
	 * Column Info
	 * @param revT4
	 */
	public void setRevT4(String revT4) {
		this.revT4 = revT4;
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
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
	}
	
	/**
	 * Column Info
	 * @param revT2
	 */
	public void setRevT2(String revT2) {
		this.revT2 = revT2;
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
	 * @param totDoc
	 */
	public void setTotDoc(String totDoc) {
		this.totDoc = totDoc;
	}
	
	/**
	 * Column Info
	 * @param totFeu
	 */
	public void setTotFeu(String totFeu) {
		this.totFeu = totFeu;
	}
	
	/**
	 * Column Info
	 * @param subTotFeu
	 */
	public void setSubTotFeu(String subTotFeu) {
		this.subTotFeu = subTotFeu;
	}
	
	/**
	 * Column Info
	 * @param ibWk
	 */
	public void setIbWk(String ibWk) {
		this.ibWk = ibWk;
	}
	
	/**
	 * Column Info
	 * @param caf
	 */
	public void setCaf(String caf) {
		this.caf = caf;
	}
	
	/**
	 * Column Info
	 * @param s4
	 */
	public void setS4(String s4) {
		this.s4 = s4;
	}
	
	/**
	 * Column Info
	 * @param s2
	 */
	public void setS2(String s2) {
		this.s2 = s2;
	}
	
	/**
	 * Column Info
	 * @param totTac
	 */
	public void setTotTac(String totTac) {
		this.totTac = totTac;
	}
	
	/**
	 * Column Info
	 * @param revD4
	 */
	public void setRevD4(String revD4) {
		this.revD4 = revD4;
	}
	
	/**
	 * Column Info
	 * @param revD2
	 */
	public void setRevD2(String revD2) {
		this.revD2 = revD2;
	}
	
	/**
	 * Column Info
	 * @param subTotVoidTeu
	 */
	public void setSubTotVoidTeu(String subTotVoidTeu) {
		this.subTotVoidTeu = subTotVoidTeu;
	}
	
	/**
	 * Column Info
	 * @param repCustCd
	 */
	public void setRepCustCd(String repCustCd) {
		this.repCustCd = repCustCd;
	}
	
	/**
	 * Column Info
	 * @param oft
	 */
	public void setOft(String oft) {
		this.oft = oft;
	}
	
	/**
	 * Column Info
	 * @param totTeu
	 */
	public void setTotTeu(String totTeu) {
		this.totTeu = totTeu;
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
	 * @param io
	 */
	public void setIo(String io) {
		this.io = io;
	}
	
	/**
	 * Column Info
	 * @param tot20
	 */
	public void setTot20(String tot20) {
		this.tot20 = tot20;
	}
	
	/**
	 * Column Info
	 * @param totNonNet
	 */
	public void setTotNonNet(String totNonNet) {
		this.totNonNet = totNonNet;
	}
	
	/**
	 * Column Info
	 * @param misc
	 */
	public void setMisc(String misc) {
		this.misc = misc;
	}
	
	/**
	 * Column Info
	 * @param subTotOth
	 */
	public void setSubTotOth(String subTotOth) {
		this.subTotOth = subTotOth;
	}
	
	/**
	 * Column Info
	 * @param totOft
	 */
	public void setTotOft(String totOft) {
		this.totOft = totOft;
	}
	
	/**
	 * Column Info
	 * @param subTotTeu
	 */
	public void setSubTotTeu(String subTotTeu) {
		this.subTotTeu = subTotTeu;
	}
	
	/**
	 * Column Info
	 * @param box
	 */
	public void setBox(String box) {
		this.box = box;
	}
	
	/**
	 * Column Info
	 * @param slsRgnOfcCd
	 */
	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param r2
	 */
	public void setR2(String r2) {
		this.r2 = r2;
	}
	
	/**
	 * Column Info
	 * @param subTotNonNet
	 */
	public void setSubTotNonNet(String subTotNonNet) {
		this.subTotNonNet = subTotNonNet;
	}
	
	/**
	 * Column Info
	 * @param r4
	 */
	public void setR4(String r4) {
		this.r4 = r4;
	}
	
	/**
	 * Column Info
	 * @param nonNet
	 */
	public void setNonNet(String nonNet) {
		this.nonNet = nonNet;
	}
	
	/**
	 * Column Info
	 * @param r5
	 */
	public void setR5(String r5) {
		this.r5 = r5;
	}
	
	/**
	 * Column Info
	 * @param revD5
	 */
	public void setRevD5(String revD5) {
		this.revD5 = revD5;
	}
	
	/**
	 * Column Info
	 * @param revR5
	 */
	public void setRevR5(String revR5) {
		this.revR5 = revR5;
	}
	
	/**
	 * Column Info
	 * @param d7
	 */
	public void setD7(String d7) {
		this.d7 = d7;
	}
	
	/**
	 * Column Info
	 * @param revD7
	 */
	public void setRevD7(String revD7) {
		this.revD7 = revD7;
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
		setRevO4(JSPUtil.getParameter(request, prefix + "rev_o4", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setP4(JSPUtil.getParameter(request, prefix + "p4", ""));
		setNonRev(JSPUtil.getParameter(request, prefix + "non_rev", ""));
		setP2(JSPUtil.getParameter(request, prefix + "p2", ""));
		setTac(JSPUtil.getParameter(request, prefix + "tac", ""));
		setRevO2(JSPUtil.getParameter(request, prefix + "rev_o2", ""));
		setFeuGross(JSPUtil.getParameter(request, prefix + "feu_gross", ""));
		setIbWkPodCd(JSPUtil.getParameter(request, prefix + "ib_wk_pod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCnnfCd(JSPUtil.getParameter(request, prefix + "cnnf_cd", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setSubTotBaf(JSPUtil.getParameter(request, prefix + "sub_tot_baf", ""));
		setRpb(JSPUtil.getParameter(request, prefix + "rpb", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setTotD2(JSPUtil.getParameter(request, prefix + "tot_d2", ""));
		setEqRpb(JSPUtil.getParameter(request, prefix + "eq_rpb", ""));
		setTotD4(JSPUtil.getParameter(request, prefix + "tot_d4", ""));
		setBkgPod(JSPUtil.getParameter(request, prefix + "bkg_pod", ""));
		setTotD5(JSPUtil.getParameter(request, prefix + "tot_d5", ""));
		setTotRth(JSPUtil.getParameter(request, prefix + "tot_rth", ""));
		setRepAcctNm(JSPUtil.getParameter(request, prefix + "rep_acct_nm", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setSubTotCaf(JSPUtil.getParameter(request, prefix + "sub_tot_caf", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setTotNonRev(JSPUtil.getParameter(request, prefix + "tot_non_rev", ""));
		setTot40(JSPUtil.getParameter(request, prefix + "tot_40", ""));
		setFeu(JSPUtil.getParameter(request, prefix + "feu", ""));
		setTotBaf(JSPUtil.getParameter(request, prefix + "tot_baf", ""));
		setQ2(JSPUtil.getParameter(request, prefix + "q2", ""));
		setFirstVvd(JSPUtil.getParameter(request, prefix + "first_vvd", ""));
		setQ4(JSPUtil.getParameter(request, prefix + "q4", ""));
		setSubTotOft(JSPUtil.getParameter(request, prefix + "sub_tot_oft", ""));
		setGso(JSPUtil.getParameter(request, prefix + "gso", ""));
		setBaf(JSPUtil.getParameter(request, prefix + "baf", ""));
		setRevF4(JSPUtil.getParameter(request, prefix + "rev_f4", ""));
		setRevRd2(JSPUtil.getParameter(request, prefix + "rev_rd2", ""));
		setTotTtl(JSPUtil.getParameter(request, prefix + "tot_ttl", ""));
		setRevRd4(JSPUtil.getParameter(request, prefix + "rev_rd4", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRgnCnt(JSPUtil.getParameter(request, prefix + "rgn_cnt", ""));
		setRevF2(JSPUtil.getParameter(request, prefix + "rev_f2", ""));
		setCtrtSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_srep_cd", ""));
		setSlsWk(JSPUtil.getParameter(request, prefix + "sls_wk", ""));
		setTotS2(JSPUtil.getParameter(request, prefix + "tot_s2", ""));
		setTotS4(JSPUtil.getParameter(request, prefix + "tot_s4", ""));
		setROther(JSPUtil.getParameter(request, prefix + "r_other", ""));
		setSubTotNet(JSPUtil.getParameter(request, prefix + "sub_tot_net", ""));
		setBlObrdWk(JSPUtil.getParameter(request, prefix + "bl_obrd_wk", ""));
		setSubTotD2(JSPUtil.getParameter(request, prefix + "sub_tot_d2", ""));
		setTeuTtl(JSPUtil.getParameter(request, prefix + "teu_ttl", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setRevQ4(JSPUtil.getParameter(request, prefix + "rev_q4", ""));
		setRevQ2(JSPUtil.getParameter(request, prefix + "rev_q2", ""));
		setVoidTeu(JSPUtil.getParameter(request, prefix + "void_teu", ""));
		setNet(JSPUtil.getParameter(request, prefix + "net", ""));
		setSubTotD5(JSPUtil.getParameter(request, prefix + "sub_tot_d5", ""));
		setTeuGross(JSPUtil.getParameter(request, prefix + "teu_gross", ""));
		setSubTotD4(JSPUtil.getParameter(request, prefix + "sub_tot_d4", ""));
		setSubTot20(JSPUtil.getParameter(request, prefix + "sub_tot_20", ""));
		setCnnfNm(JSPUtil.getParameter(request, prefix + "cnnf_nm", ""));
		setTotMisc(JSPUtil.getParameter(request, prefix + "tot_misc", ""));
		setTotRd2(JSPUtil.getParameter(request, prefix + "tot_rd2", ""));
		setSubTotTtl(JSPUtil.getParameter(request, prefix + "sub_tot_ttl", ""));
		setSubTotGross(JSPUtil.getParameter(request, prefix + "sub_tot_gross", ""));
		setTotRd4(JSPUtil.getParameter(request, prefix + "tot_rd4", ""));
		setTotR4(JSPUtil.getParameter(request, prefix + "tot_r4", ""));
		setF2(JSPUtil.getParameter(request, prefix + "f2", ""));
		setTotR2(JSPUtil.getParameter(request, prefix + "tot_r2", ""));
		setOfcCnt(JSPUtil.getParameter(request, prefix + "ofc_cnt", ""));
		setSubTotRth(JSPUtil.getParameter(request, prefix + "sub_tot_rth", ""));
		setF4(JSPUtil.getParameter(request, prefix + "f4", ""));
		setVoidSlot(JSPUtil.getParameter(request, prefix + "void_slot", ""));
		setIbSlsOfcCd(JSPUtil.getParameter(request, prefix + "ib_sls_ofc_cd", ""));
		setO2(JSPUtil.getParameter(request, prefix + "o2", ""));
		setO4(JSPUtil.getParameter(request, prefix + "o4", ""));
		setRevP2(JSPUtil.getParameter(request, prefix + "rev_p2", ""));
		setRevP4(JSPUtil.getParameter(request, prefix + "rev_p4", ""));
		setTtl(JSPUtil.getParameter(request, prefix + "ttl", ""));
		setRepKnd(JSPUtil.getParameter(request, prefix + "rep_knd", ""));
		setSlsYrmon(JSPUtil.getParameter(request, prefix + "sls_yrmon", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setSubTotTac(JSPUtil.getParameter(request, prefix + "sub_tot_tac", ""));
		setVoidFeu(JSPUtil.getParameter(request, prefix + "void_feu", ""));
		setTotDth(JSPUtil.getParameter(request, prefix + "tot_dth", ""));
		setDoc(JSPUtil.getParameter(request, prefix + "doc", ""));
		setTotGross(JSPUtil.getParameter(request, prefix + "tot_gross", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
		setSubTotR4(JSPUtil.getParameter(request, prefix + "sub_tot_r4", ""));
		setSubTotR2(JSPUtil.getParameter(request, prefix + "sub_tot_r2", ""));
		setTotVoidTeu(JSPUtil.getParameter(request, prefix + "tot_void_teu", ""));
		setD5(JSPUtil.getParameter(request, prefix + "d5", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setD4(JSPUtil.getParameter(request, prefix + "d4", ""));
		setSubTot40(JSPUtil.getParameter(request, prefix + "sub_tot_40", ""));
		setRevR4(JSPUtil.getParameter(request, prefix + "rev_r4", ""));
		setD2(JSPUtil.getParameter(request, prefix + "d2", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbsOfcNt(JSPUtil.getParameter(request, prefix + "ibs_ofc_nt", ""));
		setRevR2(JSPUtil.getParameter(request, prefix + "rev_r2", ""));
		setOth(JSPUtil.getParameter(request, prefix + "oth", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setOrgSvc(JSPUtil.getParameter(request, prefix + "org_svc", ""));
		setDth(JSPUtil.getParameter(request, prefix + "dth", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setObSrepNm(JSPUtil.getParameter(request, prefix + "ob_srep_nm", ""));
		setSubTotDoc(JSPUtil.getParameter(request, prefix + "sub_tot_doc", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setSubTotS2(JSPUtil.getParameter(request, prefix + "sub_tot_s2", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, prefix + "rep_cmdt_nm", ""));
		setSubTotRd4(JSPUtil.getParameter(request, prefix + "sub_tot_rd4", ""));
		setTotSlo(JSPUtil.getParameter(request, prefix + "tot_slo", ""));
		setSubTotS4(JSPUtil.getParameter(request, prefix + "sub_tot_s4", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSubTotRd2(JSPUtil.getParameter(request, prefix + "sub_tot_rd2", ""));
		setRd4(JSPUtil.getParameter(request, prefix + "rd4", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setRd2(JSPUtil.getParameter(request, prefix + "rd2", ""));
		setDstSvc(JSPUtil.getParameter(request, prefix + "dst_svc", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSubTotSlo(JSPUtil.getParameter(request, prefix + "sub_tot_slo", ""));
		setTotOth(JSPUtil.getParameter(request, prefix + "tot_oth", ""));
		setBlObrdDt(JSPUtil.getParameter(request, prefix + "bl_obrd_dt", ""));
		setT4(JSPUtil.getParameter(request, prefix + "t4", ""));
		setSubTotDth(JSPUtil.getParameter(request, prefix + "sub_tot_dth", ""));
		setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
		setVoidRpb(JSPUtil.getParameter(request, prefix + "void_rpb", ""));
		setTotSum(JSPUtil.getParameter(request, prefix + "tot_sum", ""));
		setGrpBy(JSPUtil.getParameter(request, prefix + "grp_by", ""));
		setTotCaf(JSPUtil.getParameter(request, prefix + "tot_caf", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setT2(JSPUtil.getParameter(request, prefix + "t2", ""));
		setGross(JSPUtil.getParameter(request, prefix + "gross", ""));
		setSubTotVoidFeu(JSPUtil.getParameter(request, prefix + "sub_tot_void_feu", ""));
		setTotVoidFeu(JSPUtil.getParameter(request, prefix + "tot_void_feu", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", ""));
		setSubTotNonRev(JSPUtil.getParameter(request, prefix + "sub_tot_non_rev", ""));
		setSubTotMisc(JSPUtil.getParameter(request, prefix + "sub_tot_misc", ""));
		setTotNet(JSPUtil.getParameter(request, prefix + "tot_net", ""));
		setRevT4(JSPUtil.getParameter(request, prefix + "rev_t4", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setRevT2(JSPUtil.getParameter(request, prefix + "rev_t2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotDoc(JSPUtil.getParameter(request, prefix + "tot_doc", ""));
		setTotFeu(JSPUtil.getParameter(request, prefix + "tot_feu", ""));
		setSubTotFeu(JSPUtil.getParameter(request, prefix + "sub_tot_feu", ""));
		setIbWk(JSPUtil.getParameter(request, prefix + "ib_wk", ""));
		setCaf(JSPUtil.getParameter(request, prefix + "caf", ""));
		setS4(JSPUtil.getParameter(request, prefix + "s4", ""));
		setS2(JSPUtil.getParameter(request, prefix + "s2", ""));
		setTotTac(JSPUtil.getParameter(request, prefix + "tot_tac", ""));
		setRevD4(JSPUtil.getParameter(request, prefix + "rev_d4", ""));
		setRevD2(JSPUtil.getParameter(request, prefix + "rev_d2", ""));
		setSubTotVoidTeu(JSPUtil.getParameter(request, prefix + "sub_tot_void_teu", ""));
		setRepCustCd(JSPUtil.getParameter(request, prefix + "rep_cust_cd", ""));
		setOft(JSPUtil.getParameter(request, prefix + "oft", ""));
		setTotTeu(JSPUtil.getParameter(request, prefix + "tot_teu", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setIo(JSPUtil.getParameter(request, prefix + "io", ""));
		setTot20(JSPUtil.getParameter(request, prefix + "tot_20", ""));
		setTotNonNet(JSPUtil.getParameter(request, prefix + "tot_non_net", ""));
		setMisc(JSPUtil.getParameter(request, prefix + "misc", ""));
		setSubTotOth(JSPUtil.getParameter(request, prefix + "sub_tot_oth", ""));
		setTotOft(JSPUtil.getParameter(request, prefix + "tot_oft", ""));
		setSubTotTeu(JSPUtil.getParameter(request, prefix + "sub_tot_teu", ""));
		setBox(JSPUtil.getParameter(request, prefix + "box", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
		setR2(JSPUtil.getParameter(request, prefix + "r2", ""));
		setSubTotNonNet(JSPUtil.getParameter(request, prefix + "sub_tot_non_net", ""));
		setR4(JSPUtil.getParameter(request, prefix + "r4", ""));
		setNonNet(JSPUtil.getParameter(request, prefix + "non_net", ""));
		setR5(JSPUtil.getParameter(request, prefix + "r5", ""));
		setRevD5(JSPUtil.getParameter(request, prefix + "rev_d5", ""));
		setRevR5(JSPUtil.getParameter(request, prefix + "rev_r5", ""));
		setD7(JSPUtil.getParameter(request, prefix + "d7", ""));
		setRevD7(JSPUtil.getParameter(request, prefix + "rev_d7", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SaelsPerformanceReportOutVO[]
	 */
	public SaelsPerformanceReportOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SaelsPerformanceReportOutVO[]
	 */
	public SaelsPerformanceReportOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SaelsPerformanceReportOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] revO4 = (JSPUtil.getParameter(request, prefix	+ "rev_o4", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] p4 = (JSPUtil.getParameter(request, prefix	+ "p4", length));
			String[] nonRev = (JSPUtil.getParameter(request, prefix	+ "non_rev", length));
			String[] p2 = (JSPUtil.getParameter(request, prefix	+ "p2", length));
			String[] tac = (JSPUtil.getParameter(request, prefix	+ "tac", length));
			String[] revO2 = (JSPUtil.getParameter(request, prefix	+ "rev_o2", length));
			String[] feuGross = (JSPUtil.getParameter(request, prefix	+ "feu_gross", length));
			String[] ibWkPodCd = (JSPUtil.getParameter(request, prefix	+ "ib_wk_pod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnnfCd = (JSPUtil.getParameter(request, prefix	+ "cnnf_cd", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] subTotBaf = (JSPUtil.getParameter(request, prefix	+ "sub_tot_baf", length));
			String[] rpb = (JSPUtil.getParameter(request, prefix	+ "rpb", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] totD2 = (JSPUtil.getParameter(request, prefix	+ "tot_d2", length));
			String[] eqRpb = (JSPUtil.getParameter(request, prefix	+ "eq_rpb", length));
			String[] totD4 = (JSPUtil.getParameter(request, prefix	+ "tot_d4", length));
			String[] bkgPod = (JSPUtil.getParameter(request, prefix	+ "bkg_pod", length));
			String[] totD5 = (JSPUtil.getParameter(request, prefix	+ "tot_d5", length));
			String[] totRth = (JSPUtil.getParameter(request, prefix	+ "tot_rth", length));
			String[] repAcctNm = (JSPUtil.getParameter(request, prefix	+ "rep_acct_nm", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] subTotCaf = (JSPUtil.getParameter(request, prefix	+ "sub_tot_caf", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] totNonRev = (JSPUtil.getParameter(request, prefix	+ "tot_non_rev", length));
			String[] tot40 = (JSPUtil.getParameter(request, prefix	+ "tot_40", length));
			String[] feu = (JSPUtil.getParameter(request, prefix	+ "feu", length));
			String[] totBaf = (JSPUtil.getParameter(request, prefix	+ "tot_baf", length));
			String[] q2 = (JSPUtil.getParameter(request, prefix	+ "q2", length));
			String[] firstVvd = (JSPUtil.getParameter(request, prefix	+ "first_vvd", length));
			String[] q4 = (JSPUtil.getParameter(request, prefix	+ "q4", length));
			String[] subTotOft = (JSPUtil.getParameter(request, prefix	+ "sub_tot_oft", length));
			String[] gso = (JSPUtil.getParameter(request, prefix	+ "gso", length));
			String[] baf = (JSPUtil.getParameter(request, prefix	+ "baf", length));
			String[] revF4 = (JSPUtil.getParameter(request, prefix	+ "rev_f4", length));
			String[] revRd2 = (JSPUtil.getParameter(request, prefix	+ "rev_rd2", length));
			String[] totTtl = (JSPUtil.getParameter(request, prefix	+ "tot_ttl", length));
			String[] revRd4 = (JSPUtil.getParameter(request, prefix	+ "rev_rd4", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rgnCnt = (JSPUtil.getParameter(request, prefix	+ "rgn_cnt", length));
			String[] revF2 = (JSPUtil.getParameter(request, prefix	+ "rev_f2", length));
			String[] ctrtSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_srep_cd", length));
			String[] slsWk = (JSPUtil.getParameter(request, prefix	+ "sls_wk", length));
			String[] totS2 = (JSPUtil.getParameter(request, prefix	+ "tot_s2", length));
			String[] totS4 = (JSPUtil.getParameter(request, prefix	+ "tot_s4", length));
			String[] rOther = (JSPUtil.getParameter(request, prefix	+ "r_other", length));
			String[] subTotNet = (JSPUtil.getParameter(request, prefix	+ "sub_tot_net", length));
			String[] blObrdWk = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_wk", length));
			String[] subTotD2 = (JSPUtil.getParameter(request, prefix	+ "sub_tot_d2", length));
			String[] teuTtl = (JSPUtil.getParameter(request, prefix	+ "teu_ttl", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] revQ4 = (JSPUtil.getParameter(request, prefix	+ "rev_q4", length));
			String[] revQ2 = (JSPUtil.getParameter(request, prefix	+ "rev_q2", length));
			String[] voidTeu = (JSPUtil.getParameter(request, prefix	+ "void_teu", length));
			String[] net = (JSPUtil.getParameter(request, prefix	+ "net", length));
			String[] subTotD5 = (JSPUtil.getParameter(request, prefix	+ "sub_tot_d5", length));
			String[] teuGross = (JSPUtil.getParameter(request, prefix	+ "teu_gross", length));
			String[] subTotD4 = (JSPUtil.getParameter(request, prefix	+ "sub_tot_d4", length));
			String[] subTot20 = (JSPUtil.getParameter(request, prefix	+ "sub_tot_20", length));
			String[] cnnfNm = (JSPUtil.getParameter(request, prefix	+ "cnnf_nm", length));
			String[] totMisc = (JSPUtil.getParameter(request, prefix	+ "tot_misc", length));
			String[] totRd2 = (JSPUtil.getParameter(request, prefix	+ "tot_rd2", length));
			String[] subTotTtl = (JSPUtil.getParameter(request, prefix	+ "sub_tot_ttl", length));
			String[] subTotGross = (JSPUtil.getParameter(request, prefix	+ "sub_tot_gross", length));
			String[] totRd4 = (JSPUtil.getParameter(request, prefix	+ "tot_rd4", length));
			String[] totR4 = (JSPUtil.getParameter(request, prefix	+ "tot_r4", length));
			String[] f2 = (JSPUtil.getParameter(request, prefix	+ "f2", length));
			String[] totR2 = (JSPUtil.getParameter(request, prefix	+ "tot_r2", length));
			String[] ofcCnt = (JSPUtil.getParameter(request, prefix	+ "ofc_cnt", length));
			String[] subTotRth = (JSPUtil.getParameter(request, prefix	+ "sub_tot_rth", length));
			String[] f4 = (JSPUtil.getParameter(request, prefix	+ "f4", length));
			String[] voidSlot = (JSPUtil.getParameter(request, prefix	+ "void_slot", length));
			String[] ibSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ib_sls_ofc_cd", length));
			String[] o2 = (JSPUtil.getParameter(request, prefix	+ "o2", length));
			String[] o4 = (JSPUtil.getParameter(request, prefix	+ "o4", length));
			String[] revP2 = (JSPUtil.getParameter(request, prefix	+ "rev_p2", length));
			String[] revP4 = (JSPUtil.getParameter(request, prefix	+ "rev_p4", length));
			String[] ttl = (JSPUtil.getParameter(request, prefix	+ "ttl", length));
			String[] repKnd = (JSPUtil.getParameter(request, prefix	+ "rep_knd", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] subTotTac = (JSPUtil.getParameter(request, prefix	+ "sub_tot_tac", length));
			String[] voidFeu = (JSPUtil.getParameter(request, prefix	+ "void_feu", length));
			String[] totDth = (JSPUtil.getParameter(request, prefix	+ "tot_dth", length));
			String[] doc = (JSPUtil.getParameter(request, prefix	+ "doc", length));
			String[] totGross = (JSPUtil.getParameter(request, prefix	+ "tot_gross", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] subTotR4 = (JSPUtil.getParameter(request, prefix	+ "sub_tot_r4", length));
			String[] subTotR2 = (JSPUtil.getParameter(request, prefix	+ "sub_tot_r2", length));
			String[] totVoidTeu = (JSPUtil.getParameter(request, prefix	+ "tot_void_teu", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] subTot40 = (JSPUtil.getParameter(request, prefix	+ "sub_tot_40", length));
			String[] revR4 = (JSPUtil.getParameter(request, prefix	+ "rev_r4", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibsOfcNt = (JSPUtil.getParameter(request, prefix	+ "ibs_ofc_nt", length));
			String[] revR2 = (JSPUtil.getParameter(request, prefix	+ "rev_r2", length));
			String[] oth = (JSPUtil.getParameter(request, prefix	+ "oth", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] orgSvc = (JSPUtil.getParameter(request, prefix	+ "org_svc", length));
			String[] dth = (JSPUtil.getParameter(request, prefix	+ "dth", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] obSrepNm = (JSPUtil.getParameter(request, prefix	+ "ob_srep_nm", length));
			String[] subTotDoc = (JSPUtil.getParameter(request, prefix	+ "sub_tot_doc", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] subTotS2 = (JSPUtil.getParameter(request, prefix	+ "sub_tot_s2", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] subTotRd4 = (JSPUtil.getParameter(request, prefix	+ "sub_tot_rd4", length));
			String[] totSlo = (JSPUtil.getParameter(request, prefix	+ "tot_slo", length));
			String[] subTotS4 = (JSPUtil.getParameter(request, prefix	+ "sub_tot_s4", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] subTotRd2 = (JSPUtil.getParameter(request, prefix	+ "sub_tot_rd2", length));
			String[] rd4 = (JSPUtil.getParameter(request, prefix	+ "rd4", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] rd2 = (JSPUtil.getParameter(request, prefix	+ "rd2", length));
			String[] dstSvc = (JSPUtil.getParameter(request, prefix	+ "dst_svc", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] subTotSlo = (JSPUtil.getParameter(request, prefix	+ "sub_tot_slo", length));
			String[] totOth = (JSPUtil.getParameter(request, prefix	+ "tot_oth", length));
			String[] blObrdDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt", length));
			String[] t4 = (JSPUtil.getParameter(request, prefix	+ "t4", length));
			String[] subTotDth = (JSPUtil.getParameter(request, prefix	+ "sub_tot_dth", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] voidRpb = (JSPUtil.getParameter(request, prefix	+ "void_rpb", length));
			String[] totSum = (JSPUtil.getParameter(request, prefix	+ "tot_sum", length));
			String[] grpBy = (JSPUtil.getParameter(request, prefix	+ "grp_by", length));
			String[] totCaf = (JSPUtil.getParameter(request, prefix	+ "tot_caf", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] t2 = (JSPUtil.getParameter(request, prefix	+ "t2", length));
			String[] gross = (JSPUtil.getParameter(request, prefix	+ "gross", length));
			String[] subTotVoidFeu = (JSPUtil.getParameter(request, prefix	+ "sub_tot_void_feu", length));
			String[] totVoidFeu = (JSPUtil.getParameter(request, prefix	+ "tot_void_feu", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] subTotNonRev = (JSPUtil.getParameter(request, prefix	+ "sub_tot_non_rev", length));
			String[] subTotMisc = (JSPUtil.getParameter(request, prefix	+ "sub_tot_misc", length));
			String[] totNet = (JSPUtil.getParameter(request, prefix	+ "tot_net", length));
			String[] revT4 = (JSPUtil.getParameter(request, prefix	+ "rev_t4", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] revT2 = (JSPUtil.getParameter(request, prefix	+ "rev_t2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totDoc = (JSPUtil.getParameter(request, prefix	+ "tot_doc", length));
			String[] totFeu = (JSPUtil.getParameter(request, prefix	+ "tot_feu", length));
			String[] subTotFeu = (JSPUtil.getParameter(request, prefix	+ "sub_tot_feu", length));
			String[] ibWk = (JSPUtil.getParameter(request, prefix	+ "ib_wk", length));
			String[] caf = (JSPUtil.getParameter(request, prefix	+ "caf", length));
			String[] s4 = (JSPUtil.getParameter(request, prefix	+ "s4", length));
			String[] s2 = (JSPUtil.getParameter(request, prefix	+ "s2", length));
			String[] totTac = (JSPUtil.getParameter(request, prefix	+ "tot_tac", length));
			String[] revD4 = (JSPUtil.getParameter(request, prefix	+ "rev_d4", length));
			String[] revD2 = (JSPUtil.getParameter(request, prefix	+ "rev_d2", length));
			String[] subTotVoidTeu = (JSPUtil.getParameter(request, prefix	+ "sub_tot_void_teu", length));
			String[] repCustCd = (JSPUtil.getParameter(request, prefix	+ "rep_cust_cd", length));
			String[] oft = (JSPUtil.getParameter(request, prefix	+ "oft", length));
			String[] totTeu = (JSPUtil.getParameter(request, prefix	+ "tot_teu", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] io = (JSPUtil.getParameter(request, prefix	+ "io", length));
			String[] tot20 = (JSPUtil.getParameter(request, prefix	+ "tot_20", length));
			String[] totNonNet = (JSPUtil.getParameter(request, prefix	+ "tot_non_net", length));
			String[] misc = (JSPUtil.getParameter(request, prefix	+ "misc", length));
			String[] subTotOth = (JSPUtil.getParameter(request, prefix	+ "sub_tot_oth", length));
			String[] totOft = (JSPUtil.getParameter(request, prefix	+ "tot_oft", length));
			String[] subTotTeu = (JSPUtil.getParameter(request, prefix	+ "sub_tot_teu", length));
			String[] box = (JSPUtil.getParameter(request, prefix	+ "box", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2", length));
			String[] subTotNonNet = (JSPUtil.getParameter(request, prefix	+ "sub_tot_non_net", length));
			String[] r4 = (JSPUtil.getParameter(request, prefix	+ "r4", length));
			String[] nonNet = (JSPUtil.getParameter(request, prefix	+ "non_net", length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5", length));
			String[] revD5 = (JSPUtil.getParameter(request, prefix	+ "rev_d5", length));
			String[] revR5 = (JSPUtil.getParameter(request, prefix	+ "rev_r5", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d7", length));
			String[] revD7 = (JSPUtil.getParameter(request, prefix	+ "rev_d7", length));
			
			for (int i = 0; i < length; i++) {
				model = new SaelsPerformanceReportOutVO();
				if (revO4[i] != null)
					model.setRevO4(revO4[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (p4[i] != null)
					model.setP4(p4[i]);
				if (nonRev[i] != null)
					model.setNonRev(nonRev[i]);
				if (p2[i] != null)
					model.setP2(p2[i]);
				if (tac[i] != null)
					model.setTac(tac[i]);
				if (revO2[i] != null)
					model.setRevO2(revO2[i]);
				if (feuGross[i] != null)
					model.setFeuGross(feuGross[i]);
				if (ibWkPodCd[i] != null)
					model.setIbWkPodCd(ibWkPodCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnnfCd[i] != null)
					model.setCnnfCd(cnnfCd[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (subTotBaf[i] != null)
					model.setSubTotBaf(subTotBaf[i]);
				if (rpb[i] != null)
					model.setRpb(rpb[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (totD2[i] != null)
					model.setTotD2(totD2[i]);
				if (eqRpb[i] != null)
					model.setEqRpb(eqRpb[i]);
				if (totD4[i] != null)
					model.setTotD4(totD4[i]);
				if (bkgPod[i] != null)
					model.setBkgPod(bkgPod[i]);
				if (totD5[i] != null)
					model.setTotD5(totD5[i]);
				if (totRth[i] != null)
					model.setTotRth(totRth[i]);
				if (repAcctNm[i] != null)
					model.setRepAcctNm(repAcctNm[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (subTotCaf[i] != null)
					model.setSubTotCaf(subTotCaf[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (totNonRev[i] != null)
					model.setTotNonRev(totNonRev[i]);
				if (tot40[i] != null)
					model.setTot40(tot40[i]);
				if (feu[i] != null)
					model.setFeu(feu[i]);
				if (totBaf[i] != null)
					model.setTotBaf(totBaf[i]);
				if (q2[i] != null)
					model.setQ2(q2[i]);
				if (firstVvd[i] != null)
					model.setFirstVvd(firstVvd[i]);
				if (q4[i] != null)
					model.setQ4(q4[i]);
				if (subTotOft[i] != null)
					model.setSubTotOft(subTotOft[i]);
				if (gso[i] != null)
					model.setGso(gso[i]);
				if (baf[i] != null)
					model.setBaf(baf[i]);
				if (revF4[i] != null)
					model.setRevF4(revF4[i]);
				if (revRd2[i] != null)
					model.setRevRd2(revRd2[i]);
				if (totTtl[i] != null)
					model.setTotTtl(totTtl[i]);
				if (revRd4[i] != null)
					model.setRevRd4(revRd4[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rgnCnt[i] != null)
					model.setRgnCnt(rgnCnt[i]);
				if (revF2[i] != null)
					model.setRevF2(revF2[i]);
				if (ctrtSrepCd[i] != null)
					model.setCtrtSrepCd(ctrtSrepCd[i]);
				if (slsWk[i] != null)
					model.setSlsWk(slsWk[i]);
				if (totS2[i] != null)
					model.setTotS2(totS2[i]);
				if (totS4[i] != null)
					model.setTotS4(totS4[i]);
				if (rOther[i] != null)
					model.setROther(rOther[i]);
				if (subTotNet[i] != null)
					model.setSubTotNet(subTotNet[i]);
				if (blObrdWk[i] != null)
					model.setBlObrdWk(blObrdWk[i]);
				if (subTotD2[i] != null)
					model.setSubTotD2(subTotD2[i]);
				if (teuTtl[i] != null)
					model.setTeuTtl(teuTtl[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (revQ4[i] != null)
					model.setRevQ4(revQ4[i]);
				if (revQ2[i] != null)
					model.setRevQ2(revQ2[i]);
				if (voidTeu[i] != null)
					model.setVoidTeu(voidTeu[i]);
				if (net[i] != null)
					model.setNet(net[i]);
				if (subTotD5[i] != null)
					model.setSubTotD5(subTotD5[i]);
				if (teuGross[i] != null)
					model.setTeuGross(teuGross[i]);
				if (subTotD4[i] != null)
					model.setSubTotD4(subTotD4[i]);
				if (subTot20[i] != null)
					model.setSubTot20(subTot20[i]);
				if (cnnfNm[i] != null)
					model.setCnnfNm(cnnfNm[i]);
				if (totMisc[i] != null)
					model.setTotMisc(totMisc[i]);
				if (totRd2[i] != null)
					model.setTotRd2(totRd2[i]);
				if (subTotTtl[i] != null)
					model.setSubTotTtl(subTotTtl[i]);
				if (subTotGross[i] != null)
					model.setSubTotGross(subTotGross[i]);
				if (totRd4[i] != null)
					model.setTotRd4(totRd4[i]);
				if (totR4[i] != null)
					model.setTotR4(totR4[i]);
				if (f2[i] != null)
					model.setF2(f2[i]);
				if (totR2[i] != null)
					model.setTotR2(totR2[i]);
				if (ofcCnt[i] != null)
					model.setOfcCnt(ofcCnt[i]);
				if (subTotRth[i] != null)
					model.setSubTotRth(subTotRth[i]);
				if (f4[i] != null)
					model.setF4(f4[i]);
				if (voidSlot[i] != null)
					model.setVoidSlot(voidSlot[i]);
				if (ibSlsOfcCd[i] != null)
					model.setIbSlsOfcCd(ibSlsOfcCd[i]);
				if (o2[i] != null)
					model.setO2(o2[i]);
				if (o4[i] != null)
					model.setO4(o4[i]);
				if (revP2[i] != null)
					model.setRevP2(revP2[i]);
				if (revP4[i] != null)
					model.setRevP4(revP4[i]);
				if (ttl[i] != null)
					model.setTtl(ttl[i]);
				if (repKnd[i] != null)
					model.setRepKnd(repKnd[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (subTotTac[i] != null)
					model.setSubTotTac(subTotTac[i]);
				if (voidFeu[i] != null)
					model.setVoidFeu(voidFeu[i]);
				if (totDth[i] != null)
					model.setTotDth(totDth[i]);
				if (doc[i] != null)
					model.setDoc(doc[i]);
				if (totGross[i] != null)
					model.setTotGross(totGross[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (subTotR4[i] != null)
					model.setSubTotR4(subTotR4[i]);
				if (subTotR2[i] != null)
					model.setSubTotR2(subTotR2[i]);
				if (totVoidTeu[i] != null)
					model.setTotVoidTeu(totVoidTeu[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (subTot40[i] != null)
					model.setSubTot40(subTot40[i]);
				if (revR4[i] != null)
					model.setRevR4(revR4[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibsOfcNt[i] != null)
					model.setIbsOfcNt(ibsOfcNt[i]);
				if (revR2[i] != null)
					model.setRevR2(revR2[i]);
				if (oth[i] != null)
					model.setOth(oth[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (orgSvc[i] != null)
					model.setOrgSvc(orgSvc[i]);
				if (dth[i] != null)
					model.setDth(dth[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (obSrepNm[i] != null)
					model.setObSrepNm(obSrepNm[i]);
				if (subTotDoc[i] != null)
					model.setSubTotDoc(subTotDoc[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (subTotS2[i] != null)
					model.setSubTotS2(subTotS2[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (subTotRd4[i] != null)
					model.setSubTotRd4(subTotRd4[i]);
				if (totSlo[i] != null)
					model.setTotSlo(totSlo[i]);
				if (subTotS4[i] != null)
					model.setSubTotS4(subTotS4[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (subTotRd2[i] != null)
					model.setSubTotRd2(subTotRd2[i]);
				if (rd4[i] != null)
					model.setRd4(rd4[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (rd2[i] != null)
					model.setRd2(rd2[i]);
				if (dstSvc[i] != null)
					model.setDstSvc(dstSvc[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (subTotSlo[i] != null)
					model.setSubTotSlo(subTotSlo[i]);
				if (totOth[i] != null)
					model.setTotOth(totOth[i]);
				if (blObrdDt[i] != null)
					model.setBlObrdDt(blObrdDt[i]);
				if (t4[i] != null)
					model.setT4(t4[i]);
				if (subTotDth[i] != null)
					model.setSubTotDth(subTotDth[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (voidRpb[i] != null)
					model.setVoidRpb(voidRpb[i]);
				if (totSum[i] != null)
					model.setTotSum(totSum[i]);
				if (grpBy[i] != null)
					model.setGrpBy(grpBy[i]);
				if (totCaf[i] != null)
					model.setTotCaf(totCaf[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (t2[i] != null)
					model.setT2(t2[i]);
				if (gross[i] != null)
					model.setGross(gross[i]);
				if (subTotVoidFeu[i] != null)
					model.setSubTotVoidFeu(subTotVoidFeu[i]);
				if (totVoidFeu[i] != null)
					model.setTotVoidFeu(totVoidFeu[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (subTotNonRev[i] != null)
					model.setSubTotNonRev(subTotNonRev[i]);
				if (subTotMisc[i] != null)
					model.setSubTotMisc(subTotMisc[i]);
				if (totNet[i] != null)
					model.setTotNet(totNet[i]);
				if (revT4[i] != null)
					model.setRevT4(revT4[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (revT2[i] != null)
					model.setRevT2(revT2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totDoc[i] != null)
					model.setTotDoc(totDoc[i]);
				if (totFeu[i] != null)
					model.setTotFeu(totFeu[i]);
				if (subTotFeu[i] != null)
					model.setSubTotFeu(subTotFeu[i]);
				if (ibWk[i] != null)
					model.setIbWk(ibWk[i]);
				if (caf[i] != null)
					model.setCaf(caf[i]);
				if (s4[i] != null)
					model.setS4(s4[i]);
				if (s2[i] != null)
					model.setS2(s2[i]);
				if (totTac[i] != null)
					model.setTotTac(totTac[i]);
				if (revD4[i] != null)
					model.setRevD4(revD4[i]);
				if (revD2[i] != null)
					model.setRevD2(revD2[i]);
				if (subTotVoidTeu[i] != null)
					model.setSubTotVoidTeu(subTotVoidTeu[i]);
				if (repCustCd[i] != null)
					model.setRepCustCd(repCustCd[i]);
				if (oft[i] != null)
					model.setOft(oft[i]);
				if (totTeu[i] != null)
					model.setTotTeu(totTeu[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (io[i] != null)
					model.setIo(io[i]);
				if (tot20[i] != null)
					model.setTot20(tot20[i]);
				if (totNonNet[i] != null)
					model.setTotNonNet(totNonNet[i]);
				if (misc[i] != null)
					model.setMisc(misc[i]);
				if (subTotOth[i] != null)
					model.setSubTotOth(subTotOth[i]);
				if (totOft[i] != null)
					model.setTotOft(totOft[i]);
				if (subTotTeu[i] != null)
					model.setSubTotTeu(subTotTeu[i]);
				if (box[i] != null)
					model.setBox(box[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (subTotNonNet[i] != null)
					model.setSubTotNonNet(subTotNonNet[i]);
				if (r4[i] != null)
					model.setR4(r4[i]);
				if (nonNet[i] != null)
					model.setNonNet(nonNet[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				if (revD5[i] != null)
					model.setRevD5(revD5[i]);
				if (revR5[i] != null)
					model.setRevR5(revR5[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (revD7[i] != null)
					model.setRevD7(revD7[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSaelsPerformanceReportOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SaelsPerformanceReportOutVO[]
	 */
	public SaelsPerformanceReportOutVO[] getSaelsPerformanceReportOutVOs(){
		SaelsPerformanceReportOutVO[] vos = (SaelsPerformanceReportOutVO[])models.toArray(new SaelsPerformanceReportOutVO[models.size()]);
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
		this.revO4 = this.revO4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p4 = this.p4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonRev = this.nonRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2 = this.p2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tac = this.tac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revO2 = this.revO2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feuGross = this.feuGross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibWkPodCd = this.ibWkPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnnfCd = this.cnnfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotBaf = this.subTotBaf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rpb = this.rpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totD2 = this.totD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRpb = this.eqRpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totD4 = this.totD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPod = this.bkgPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totD5 = this.totD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totRth = this.totRth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repAcctNm = this.repAcctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotCaf = this.subTotCaf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totNonRev = this.totNonRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot40 = this.tot40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feu = this.feu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBaf = this.totBaf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.q2 = this.q2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstVvd = this.firstVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.q4 = this.q4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotOft = this.subTotOft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gso = this.gso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.baf = this.baf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revF4 = this.revF4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revRd2 = this.revRd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTtl = this.totTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revRd4 = this.revRd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCnt = this.rgnCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revF2 = this.revF2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSrepCd = this.ctrtSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsWk = this.slsWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totS2 = this.totS2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totS4 = this.totS4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rOther = this.rOther .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotNet = this.subTotNet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdWk = this.blObrdWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotD2 = this.subTotD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuTtl = this.teuTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revQ4 = this.revQ4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revQ2 = this.revQ2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voidTeu = this.voidTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.net = this.net .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotD5 = this.subTotD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuGross = this.teuGross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotD4 = this.subTotD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTot20 = this.subTot20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnnfNm = this.cnnfNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totMisc = this.totMisc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totRd2 = this.totRd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotTtl = this.subTotTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotGross = this.subTotGross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totRd4 = this.totRd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totR4 = this.totR4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 = this.f2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totR2 = this.totR2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCnt = this.ofcCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotRth = this.subTotRth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 = this.f4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voidSlot = this.voidSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSlsOfcCd = this.ibSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2 = this.o2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4 = this.o4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revP2 = this.revP2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revP4 = this.revP4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl = this.ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repKnd = this.repKnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotTac = this.subTotTac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voidFeu = this.voidFeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totDth = this.totDth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doc = this.doc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totGross = this.totGross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotR4 = this.subTotR4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotR2 = this.subTotR2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totVoidTeu = this.totVoidTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTot40 = this.subTot40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revR4 = this.revR4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibsOfcNt = this.ibsOfcNt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revR2 = this.revR2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oth = this.oth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSvc = this.orgSvc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dth = this.dth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepNm = this.obSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotDoc = this.subTotDoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotS2 = this.subTotS2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotRd4 = this.subTotRd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSlo = this.totSlo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotS4 = this.subTotS4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotRd2 = this.subTotRd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rd4 = this.rd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rd2 = this.rd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstSvc = this.dstSvc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotSlo = this.subTotSlo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOth = this.totOth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDt = this.blObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t4 = this.t4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotDth = this.subTotDth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voidRpb = this.voidRpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSum = this.totSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpBy = this.grpBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCaf = this.totCaf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t2 = this.t2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gross = this.gross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotVoidFeu = this.subTotVoidFeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totVoidFeu = this.totVoidFeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotNonRev = this.subTotNonRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotMisc = this.subTotMisc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totNet = this.totNet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revT4 = this.revT4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revT2 = this.revT2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totDoc = this.totDoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totFeu = this.totFeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotFeu = this.subTotFeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibWk = this.ibWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caf = this.caf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4 = this.s4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2 = this.s2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTac = this.totTac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revD4 = this.revD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revD2 = this.revD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotVoidTeu = this.subTotVoidTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustCd = this.repCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oft = this.oft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTeu = this.totTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.io = this.io .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot20 = this.tot20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totNonNet = this.totNonNet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misc = this.misc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotOth = this.subTotOth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOft = this.totOft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotTeu = this.subTotTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.box = this.box .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotNonNet = this.subTotNonNet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4 = this.r4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonNet = this.nonNet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revD5 = this.revD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revR5 = this.revR5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revD7 = this.revD7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
