/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : StatusReportOutVO.java
*@FileTitle : StatusReportOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.13
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.04.13 박만건 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.10.30 문동선 [CHM-201220937] [BKG] [Booking Status Report] diff_remark, diff_remark_detail 컬럼 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject 
 */
public class StatusReportOutVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<StatusReportOutVO> models = new ArrayList<StatusReportOutVO>();

    /* Column Info */
    private String actCustCode = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String obSrepCd = null;

    /* Column Info */
    private String rowsPerPage = null;

    /* Column Info */
    private String destTrnsSvcModCd = null;

    /* Column Info */
    private String ctrtOfcCd = null;

    /* Column Info */
    private String rdTotalR9 = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String bkgCreDt = null;

    /* Column Info */
    private String stwgCd = null;

    /* Column Info */
    private String rdTotalR4 = null;

    /* Column Info */
    private String rdTotalR5 = null;

    /* Column Info */
    private String siFlg = null;

    /* Column Info */
    private String rdTotalR2 = null;

    /* Column Info */
    private String totalCnt = null;

    /* Column Info */
    private String bkgOfcCd = null;

    /* Column Info */
    private String feu = null;

    /* Column Info */
    private String orderbyTitleSql = null;

    /* Column Info */
    private String interRemark = null;

    /* Column Info */
    private String bkgCtrlOfcCd = null;

    /* Column Info */
    private String caedNo = null;

    /* Column Info */
    private String sAddr = null;

    /* Column Info */
    private String post1Vvd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String rdTotalZ2 = null;

    /* Column Info */
    private String trunkPod = null;

    /* Column Info */
    private String rdTotalZ4 = null;

    /* Column Info */
    private String ctrtSrepCd = null;

    /* Column Info */
    private String actualPod = null;

    /* Column Info */
    private String pc = null;

    /* Column Info */
    private String rcFlg = null;

    /* Column Info */
    private String trunkPol = null;

    /* Column Info */
    private String itnFlg = null;

    /* Column Info */
    private String actualPol = null;

    /* Column Info */
    private String totalTeu = null;

    /* Column Info */
    private String bkgActwgtQty = null;

    /* Column Info */
    private String pre3PodCd = null;

    /* Column Info */
    private String post3PodCd = null;

    /* Column Info */
    private String rdCgoFlg = null;

    /* Column Info */
    private String bkgStsCd = null;

    /* Column Info */
    private String consignee = null;

    /* Column Info */
    private String fdGrdFlg = null;

    /* Column Info */
    private String aesNo = null;

    /* Column Info */
    private String bkgClzFlg = null;

    /* Column Info */
    private String caedFlg = null;

    /* Column Info */
    private String contact = null;

    /* Column Info */
    private String interRmk = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String totalWgt = null;

    /* Column Info */
    private String rdTotalP4 = null;

    /* Column Info */
    private String pckTpCd = null;

    /* Column Info */
    private String rdTotalP2 = null;

    /* Column Info */
    private String pre2PolCd = null;

    /* Column Info */
    private String porNodCd = null;

    /* Column Info */
    private String antyName = null;

    /* Column Info */
    private String totalMea = null;

    /* Column Info */
    private String shipper = null;

    /* Column Info */
    private String pre4PolCd = null;

    /* Column Info */
    private String remarkDetail = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String taaNo = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String rdTotalQ2 = null;

    /* Column Info */
    private String lastOrderby = null;

    /* Column Info */
    private String rdTotalQ4 = null;

    /* Column Info */
    private String rep = null;

    /* Column Info */
    private String ntfy = null;

    /* Column Info */
    private String interRemarkDetail = null;

    /* Column Info */
    private String remark = null;

    /* Column Info */
    private String pre1Vvd = null;

    /* Column Info */
    private String totalBkg = null;

    /* Column Info */
    private String tel = null;

    /* Column Info */
    private String cAddr = null;

    /* Column Info */
    private String rdTotalF2 = null;

    /* Column Info */
    private String blckStwgCd = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String pre4PodCd = null;

    /* Column Info */
    private String pre3PolCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String currPage = null;

    /* Column Info */
    private String rnum = null;

    /* Column Info */
    private String post4Vvd = null;

    /* Column Info */
    private String pre1PodCd = null;

    /* Column Info */
    private String post1PodCd = null;

    /* Column Info */
    private String scNo = null;

    /* Column Info */
    private String obSlsOfcCd = null;

    /* Column Info */
    private String delNodCd = null;

    /* Column Info */
    private String actCustName = null;

    /* Column Info */
    private String totalFeu = null;

    /* Column Info */
    private String awkCgoFlg = null;

    /* Column Info */
    private String frtTermCd = null;

    /* Column Info */
    private String fnlDestCd = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String rdTotalO2 = null;

    /* Column Info */
    private String rdTotalO4 = null;

    /* Column Info */
    private String pre3Vvd = null;

    /* Column Info */
    private String rdTotalF4 = null;

    /* Column Info */
    private String ntfyName = null;

    /* Column Info */
    private String rdTotalF5 = null;

    /* Column Info */
    private String totalBl = null;

    /* Column Info */
    private String post3Vvd = null;

    /* Column Info */
    private String orderby = null;

    /* Column Info */
    private String teu = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String chgTermCd = null;

    /* Column Info */
    private String shprName = null;

    /* Column Info */
    private String orgTrnsSvcModCd = null;

    /* Column Info */
    private String docUsrId = null;

    /* Column Info */
    private String bdrFlg = null;

    /* Column Info */
    private String eqCtrlOfcCd = null;

    /* Column Info */
    private String trunkVvd = null;

    /* Column Info */
    private String itnType = null;

    /* Column Info */
    private String eqSubstFlg = null;

    /* Column Info */
    private String hotDeFlg = null;

    /* Column Info */
    private String bkgMeaQty = null;

    /* Column Info */
    private String rfaNo = null;

    /* Column Info */
    private String rateChkSts = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String cstmsDesc = null;

    /* Column Info */
    private String bbCgoFlg = null;

    /* Column Info */
    private String dcgoFlg = null;

    /* Column Info */
    private String exptName = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String pre2Vvd = null;

    /* Column Info */
    private String orderbyTitle = null;

    /* Column Info */
    private String ffdr = null;

    /* Column Info */
    private String shpCallNo = null;

    /* Column Info */
    private String cntcPsonEml = null;

    /* Column Info */
    private String exterRemark = null;

    /* Column Info */
    private String nAddr = null;

    /* Column Info */
    private String rdTotalT2 = null;

    /* Column Info */
    private String rdTotalT4 = null;

    /* Column Info */
    private String pre2PodCd = null;

    /* Column Info */
    private String post2PodCd = null;

    /* Column Info */
    private String cmdtNm = null;

    /* Column Info */
    private String rdTotalD4 = null;

    /* Column Info */
    private String socFlg = null;

    /* Column Info */
    private String rdTotalD5 = null;

    /* Column Info */
    private String caedType = null;

    /* Column Info */
    private String deTermCd = null;

    /* Column Info */
    private String pre1PolCd = null;

    /* Column Info */
    private String rdTotalD2 = null;

    /* Column Info */
    private String post2Vvd = null;

    /* Column Info */
    private String commodity = null;

    /* Column Info */
    private String cneeName = null;

    /* Column Info */
    private String pre4Vvd = null;

    /* Column Info */
    private String rdTotalD7 = null;

    /* Column Info */
    private String hngrFlg = null;

    /* Column Info */
    private String orderbyCnt = null;

    /* Column Info */
    private String ffdrName = null;

    /* Column Info */
    private String chgInterRemark = null;

    /* Column Info */
    private String chgXterRemark = null;

    /* Column Info */
    private String chgInterRemarkDetail = null;

    /* Column Info */
    private String chgXterRemarkDetail = null;

    /* Column Info */
    private String rdTotalO5 = null;

    /* Column Info */
    private String ofcTeamCd = null;

    /* Column Info */
    private String sailDt = null;

    /* Column Info */
    private String alocStsCd = null;

    /* Column Info */
    private String siCntcPsonPhnNo = null;

    /* Column Info */
    private String siCntcPsonEml = null;

    /* Column Info */
    private String nonRtStsCd = null;

    /* Column Info */
    private String etbDt = null;

    /* Column Info */
    private String svcScpCd = null;

    /* Column Info */
    private String preContrat = null;

    /* Column Info */
    private String nowContrat = null;

    /* Column Info */
    private String rtroKndCdNm = null;

    /* Column Info */
    private String costWk = null;

    /* Column Info */
    private String activityTeu = null;

    /* Column Info */
    private String activityFeu = null;

    /* Column Info */
    private String mtyPkupYdCd = null;

    /* Column Info */
    private String mtyPkupDt = null;

    /* Column Info */
    private String dgCmdtDesc = null;

    /* Column Info */
    private String aCmdtDesc = null;

    /* Column Info */
    private String bCmdtDesc = null;

    /* Column Info */
    private String rdTotalO7 = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public StatusReportOutVO() {
    }

    public StatusReportOutVO(String ibflag, String pagerows, String bkgStsCd, String siFlg, String bkgNo, String shprName, String porCd, String rep, String teu, String bkgMeaQty, String pckTpCd, String dcgoFlg, String rcFlg, String fdGrdFlg, String itnFlg, String caedFlg, String bkgOfcCd, String ctrtOfcCd, String obSlsOfcCd, String remark, String exterRemark, String interRemark, String interRemarkDetail, String scNo, String bdrFlg, String blNo, String cneeName, String delCd, String commodity, String feu, String bkgActwgtQty, String rcvTermCd, String deTermCd, String awkCgoFlg, String bbCgoFlg, String pc, String itnType, String caedType, String docUsrId, String ctrtSrepCd, String obSrepCd, String rfaNo, String rateChkSts, String trunkVvd, String orgTrnsSvcModCd, String destTrnsSvcModCd, String porNodCd, String fnlDestCd, String slanCd, String bkgCreDt, String cmdtCd, String polCd, String podCd, String shipper, String consignee, String stwgCd, String blckStwgCd, String delNodCd, String ntfy, String ffdr, String pre1Vvd, String pre2Vvd, String pre3Vvd, String pre4Vvd, String post1Vvd, String post2Vvd, String post3Vvd, String post4Vvd, String pre1PolCd, String pre2PolCd, String pre3PolCd, String pre4PolCd, String pre1PodCd, String pre2PodCd, String pre3PodCd, String pre4PodCd, String post1PodCd, String post2PodCd, String post3PodCd, String bkgClzFlg, String ntfyName, String antyName, String ffdrName, String exptName, String hngrFlg, String socFlg, String eqSubstFlg, String rdCgoFlg, String trunkPol, String trunkPod, String hotDeFlg, String bkgCtrlOfcCd, String eqCtrlOfcCd, String cntrTpszCd, String cntrNo, String aesNo, String caedNo, String remarkDetail, String shpCallNo, String vslEngNm, String pckQty, String orderbyTitleSql, String orderbyTitle, String orderbyCnt, String lastOrderby, String orderby, String rowsPerPage, String currPage, String rnum, String contact, String tel, String actualPol, String actualPod, String totalBkg, String totalBl, String totalTeu, String totalFeu, String totalWgt, String totalMea, String rdTotalD2, String rdTotalQ4, String rdTotalD4, String rdTotalR2, String rdTotalD5, String rdTotalR4, String rdTotalD7, String rdTotalR5, String rdTotalF2, String rdTotalT2, String rdTotalF4, String rdTotalT4, String rdTotalF5, String rdTotalP2, String rdTotalO2, String rdTotalP4, String rdTotalO4, String rdTotalZ4, String rdTotalQ2, String rdTotalZ2, String rdTotalR9, String frtTermCd, String chgTermCd, String cmdtNm, String interRmk, String taaNo, String cntcPsonEml, String sAddr, String cAddr, String nAddr, String cstmsDesc, String actCustCode, String actCustName, String totalCnt, String chgInterRemark, String chgInterRemarkDetail, String chgXterRemark, String chgXterRemarkDetail, String rdTotalO5, String ofcTeamCd, String sailDt, String alocStsCd, String siCntcPsonPhnNo, String siCntcPsonEml, String nonRtStsCd, String etbDt, String svcScpCd, String preCcontrat, String nowCcontrat, String rtroKndCdNm, String costWk, String activityTeu, String activityFeu, String mtyPkupYdCd, String mtyPkupDt, String dgCmdtDesc, String aCmdtDesc, String bCmdtDesc, String rdTotalO7) {
        this.actCustCode = actCustCode;
        this.pagerows = pagerows;
        this.obSrepCd = obSrepCd;
        this.rowsPerPage = rowsPerPage;
        this.destTrnsSvcModCd = destTrnsSvcModCd;
        this.ctrtOfcCd = ctrtOfcCd;
        this.rdTotalR9 = rdTotalR9;
        this.cntrTpszCd = cntrTpszCd;
        this.bkgCreDt = bkgCreDt;
        this.stwgCd = stwgCd;
        this.rdTotalR4 = rdTotalR4;
        this.rdTotalR5 = rdTotalR5;
        this.siFlg = siFlg;
        this.rdTotalR2 = rdTotalR2;
        this.totalCnt = totalCnt;
        this.bkgOfcCd = bkgOfcCd;
        this.feu = feu;
        this.orderbyTitleSql = orderbyTitleSql;
        this.interRemark = interRemark;
        this.bkgCtrlOfcCd = bkgCtrlOfcCd;
        this.caedNo = caedNo;
        this.sAddr = sAddr;
        this.post1Vvd = post1Vvd;
        this.podCd = podCd;
        this.bkgNo = bkgNo;
        this.rdTotalZ2 = rdTotalZ2;
        this.trunkPod = trunkPod;
        this.rdTotalZ4 = rdTotalZ4;
        this.ctrtSrepCd = ctrtSrepCd;
        this.actualPod = actualPod;
        this.pc = pc;
        this.rcFlg = rcFlg;
        this.trunkPol = trunkPol;
        this.itnFlg = itnFlg;
        this.actualPol = actualPol;
        this.totalTeu = totalTeu;
        this.bkgActwgtQty = bkgActwgtQty;
        this.pre3PodCd = pre3PodCd;
        this.post3PodCd = post3PodCd;
        this.rdCgoFlg = rdCgoFlg;
        this.bkgStsCd = bkgStsCd;
        this.consignee = consignee;
        this.fdGrdFlg = fdGrdFlg;
        this.aesNo = aesNo;
        this.bkgClzFlg = bkgClzFlg;
        this.caedFlg = caedFlg;
        this.contact = contact;
        this.interRmk = interRmk;
        this.cmdtCd = cmdtCd;
        this.totalWgt = totalWgt;
        this.rdTotalP4 = rdTotalP4;
        this.pckTpCd = pckTpCd;
        this.rdTotalP2 = rdTotalP2;
        this.pre2PolCd = pre2PolCd;
        this.porNodCd = porNodCd;
        this.antyName = antyName;
        this.totalMea = totalMea;
        this.shipper = shipper;
        this.pre4PolCd = pre4PolCd;
        this.remarkDetail = remarkDetail;
        this.slanCd = slanCd;
        this.taaNo = taaNo;
        this.cntrNo = cntrNo;
        this.rdTotalQ2 = rdTotalQ2;
        this.lastOrderby = lastOrderby;
        this.rdTotalQ4 = rdTotalQ4;
        this.rep = rep;
        this.ntfy = ntfy;
        this.interRemarkDetail = interRemarkDetail;
        this.remark = remark;
        this.pre1Vvd = pre1Vvd;
        this.totalBkg = totalBkg;
        this.tel = tel;
        this.cAddr = cAddr;
        this.rdTotalF2 = rdTotalF2;
        this.blckStwgCd = blckStwgCd;
        this.blNo = blNo;
        this.pre4PodCd = pre4PodCd;
        this.pre3PolCd = pre3PolCd;
        this.polCd = polCd;
        this.currPage = currPage;
        this.rnum = rnum;
        this.post4Vvd = post4Vvd;
        this.pre1PodCd = pre1PodCd;
        this.post1PodCd = post1PodCd;
        this.scNo = scNo;
        this.obSlsOfcCd = obSlsOfcCd;
        this.delNodCd = delNodCd;
        this.actCustName = actCustName;
        this.totalFeu = totalFeu;
        this.awkCgoFlg = awkCgoFlg;
        this.frtTermCd = frtTermCd;
        this.fnlDestCd = fnlDestCd;
        this.delCd = delCd;
        this.rdTotalO2 = rdTotalO2;
        this.rdTotalO4 = rdTotalO4;
        this.pre3Vvd = pre3Vvd;
        this.rdTotalF4 = rdTotalF4;
        this.ntfyName = ntfyName;
        this.rdTotalF5 = rdTotalF5;
        this.totalBl = totalBl;
        this.post3Vvd = post3Vvd;
        this.orderby = orderby;
        this.teu = teu;
        this.porCd = porCd;
        this.chgTermCd = chgTermCd;
        this.shprName = shprName;
        this.orgTrnsSvcModCd = orgTrnsSvcModCd;
        this.docUsrId = docUsrId;
        this.bdrFlg = bdrFlg;
        this.eqCtrlOfcCd = eqCtrlOfcCd;
        this.trunkVvd = trunkVvd;
        this.itnType = itnType;
        this.eqSubstFlg = eqSubstFlg;
        this.hotDeFlg = hotDeFlg;
        this.bkgMeaQty = bkgMeaQty;
        this.rfaNo = rfaNo;
        this.rateChkSts = rateChkSts;
        this.ibflag = ibflag;
        this.vslEngNm = vslEngNm;
        this.cstmsDesc = cstmsDesc;
        this.bbCgoFlg = bbCgoFlg;
        this.dcgoFlg = dcgoFlg;
        this.exptName = exptName;
        this.pckQty = pckQty;
        this.rcvTermCd = rcvTermCd;
        this.pre2Vvd = pre2Vvd;
        this.orderbyTitle = orderbyTitle;
        this.ffdr = ffdr;
        this.shpCallNo = shpCallNo;
        this.cntcPsonEml = cntcPsonEml;
        this.exterRemark = exterRemark;
        this.nAddr = nAddr;
        this.rdTotalT2 = rdTotalT2;
        this.rdTotalT4 = rdTotalT4;
        this.pre2PodCd = pre2PodCd;
        this.post2PodCd = post2PodCd;
        this.cmdtNm = cmdtNm;
        this.rdTotalD4 = rdTotalD4;
        this.socFlg = socFlg;
        this.rdTotalD5 = rdTotalD5;
        this.caedType = caedType;
        this.deTermCd = deTermCd;
        this.pre1PolCd = pre1PolCd;
        this.rdTotalD2 = rdTotalD2;
        this.post2Vvd = post2Vvd;
        this.commodity = commodity;
        this.cneeName = cneeName;
        this.pre4Vvd = pre4Vvd;
        this.rdTotalD7 = rdTotalD7;
        this.hngrFlg = hngrFlg;
        this.orderbyCnt = orderbyCnt;
        this.ffdrName = ffdrName;
        this.chgInterRemark = chgInterRemark;
        this.chgInterRemarkDetail = chgInterRemarkDetail;
        this.chgXterRemark = chgXterRemark;
        this.chgXterRemarkDetail = chgXterRemarkDetail;
        this.rdTotalO5 = rdTotalO5;
        this.ofcTeamCd = ofcTeamCd;
        this.sailDt = sailDt;
        this.alocStsCd = alocStsCd;
        this.siCntcPsonPhnNo = siCntcPsonPhnNo;
        this.siCntcPsonEml = siCntcPsonEml;
        this.nonRtStsCd = nonRtStsCd;
        this.etbDt = etbDt;
        this.svcScpCd = svcScpCd;
        this.preContrat = preContrat;
        this.nowContrat = nowContrat;
        this.rtroKndCdNm = rtroKndCdNm;
        this.costWk = costWk;
        this.activityTeu = activityTeu;
        this.activityFeu = activityFeu;
        this.mtyPkupYdCd = mtyPkupYdCd;
        this.mtyPkupDt = mtyPkupDt;
        this.dgCmdtDesc = dgCmdtDesc;
        this.aCmdtDesc = aCmdtDesc;
        this.bCmdtDesc = bCmdtDesc;
        this.rdTotalO7 = rdTotalO7;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("act_cust_code", getActCustCode());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ob_srep_cd", getObSrepCd());
        this.hashColumns.put("rows_per_page", getRowsPerPage());
        this.hashColumns.put("dest_trns_svc_mod_cd", getDestTrnsSvcModCd());
        this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
        this.hashColumns.put("rd_total_r9", getRdTotalR9());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
        this.hashColumns.put("stwg_cd", getStwgCd());
        this.hashColumns.put("rd_total_r4", getRdTotalR4());
        this.hashColumns.put("rd_total_r5", getRdTotalR5());
        this.hashColumns.put("si_flg", getSiFlg());
        this.hashColumns.put("rd_total_r2", getRdTotalR2());
        this.hashColumns.put("total_cnt", getTotalCnt());
        this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
        this.hashColumns.put("feu", getFeu());
        this.hashColumns.put("orderby_title_sql", getOrderbyTitleSql());
        this.hashColumns.put("inter_remark", getInterRemark());
        this.hashColumns.put("bkg_ctrl_ofc_cd", getBkgCtrlOfcCd());
        this.hashColumns.put("caed_no", getCaedNo());
        this.hashColumns.put("s_addr", getSAddr());
        this.hashColumns.put("post_1_vvd", getPost1Vvd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("rd_total_z2", getRdTotalZ2());
        this.hashColumns.put("trunk_pod", getTrunkPod());
        this.hashColumns.put("rd_total_z4", getRdTotalZ4());
        this.hashColumns.put("ctrt_srep_cd", getCtrtSrepCd());
        this.hashColumns.put("actual_pod", getActualPod());
        this.hashColumns.put("pc", getPc());
        this.hashColumns.put("rc_flg", getRcFlg());
        this.hashColumns.put("trunk_pol", getTrunkPol());
        this.hashColumns.put("itn_flg", getItnFlg());
        this.hashColumns.put("actual_pol", getActualPol());
        this.hashColumns.put("total_teu", getTotalTeu());
        this.hashColumns.put("bkg_actwgt_qty", getBkgActwgtQty());
        this.hashColumns.put("pre_3_pod_cd", getPre3PodCd());
        this.hashColumns.put("post_3_pod_cd", getPost3PodCd());
        this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("consignee", getConsignee());
        this.hashColumns.put("fd_grd_flg", getFdGrdFlg());
        this.hashColumns.put("aes_no", getAesNo());
        this.hashColumns.put("bkg_clz_flg", getBkgClzFlg());
        this.hashColumns.put("caed_flg", getCaedFlg());
        this.hashColumns.put("contact", getContact());
        this.hashColumns.put("inter_rmk", getInterRmk());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("total_wgt", getTotalWgt());
        this.hashColumns.put("rd_total_p4", getRdTotalP4());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("rd_total_p2", getRdTotalP2());
        this.hashColumns.put("pre_2_pol_cd", getPre2PolCd());
        this.hashColumns.put("por_nod_cd", getPorNodCd());
        this.hashColumns.put("anty_name", getAntyName());
        this.hashColumns.put("total_mea", getTotalMea());
        this.hashColumns.put("shipper", getShipper());
        this.hashColumns.put("pre_4_pol_cd", getPre4PolCd());
        this.hashColumns.put("remark_detail", getRemarkDetail());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("taa_no", getTaaNo());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("rd_total_q2", getRdTotalQ2());
        this.hashColumns.put("last_orderby", getLastOrderby());
        this.hashColumns.put("rd_total_q4", getRdTotalQ4());
        this.hashColumns.put("rep", getRep());
        this.hashColumns.put("ntfy", getNtfy());
        this.hashColumns.put("inter_remark_detail", getInterRemarkDetail());
        this.hashColumns.put("remark", getRemark());
        this.hashColumns.put("pre_1_vvd", getPre1Vvd());
        this.hashColumns.put("total_bkg", getTotalBkg());
        this.hashColumns.put("tel", getTel());
        this.hashColumns.put("c_addr", getCAddr());
        this.hashColumns.put("rd_total_f2", getRdTotalF2());
        this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pre_4_pod_cd", getPre4PodCd());
        this.hashColumns.put("pre_3_pol_cd", getPre3PolCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("curr_page", getCurrPage());
        this.hashColumns.put("rnum", getRnum());
        this.hashColumns.put("post_4_vvd", getPost4Vvd());
        this.hashColumns.put("pre_1_pod_cd", getPre1PodCd());
        this.hashColumns.put("post_1_pod_cd", getPost1PodCd());
        this.hashColumns.put("sc_no", getScNo());
        this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
        this.hashColumns.put("del_nod_cd", getDelNodCd());
        this.hashColumns.put("act_cust_name", getActCustName());
        this.hashColumns.put("total_feu", getTotalFeu());
        this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
        this.hashColumns.put("frt_term_cd", getFrtTermCd());
        this.hashColumns.put("fnl_dest_cd", getFnlDestCd());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("rd_total_o2", getRdTotalO2());
        this.hashColumns.put("rd_total_o4", getRdTotalO4());
        this.hashColumns.put("pre_3_vvd", getPre3Vvd());
        this.hashColumns.put("rd_total_f4", getRdTotalF4());
        this.hashColumns.put("ntfy_name", getNtfyName());
        this.hashColumns.put("rd_total_f5", getRdTotalF5());
        this.hashColumns.put("total_bl", getTotalBl());
        this.hashColumns.put("post_3_vvd", getPost3Vvd());
        this.hashColumns.put("orderby", getOrderby());
        this.hashColumns.put("teu", getTeu());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("chg_term_cd", getChgTermCd());
        this.hashColumns.put("shpr_name", getShprName());
        this.hashColumns.put("org_trns_svc_mod_cd", getOrgTrnsSvcModCd());
        this.hashColumns.put("doc_usr_id", getDocUsrId());
        this.hashColumns.put("bdr_flg", getBdrFlg());
        this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
        this.hashColumns.put("trunk_vvd", getTrunkVvd());
        this.hashColumns.put("itn_type", getItnType());
        this.hashColumns.put("eq_subst_flg", getEqSubstFlg());
        this.hashColumns.put("hot_de_flg", getHotDeFlg());
        this.hashColumns.put("bkg_mea_qty", getBkgMeaQty());
        this.hashColumns.put("rfa_no", getRfaNo());
        this.hashColumns.put("rate_chk_sts", getRateChkSts());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("cstms_desc", getCstmsDesc());
        this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
        this.hashColumns.put("dcgo_flg", getDcgoFlg());
        this.hashColumns.put("expt_name", getExptName());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("pre_2_vvd", getPre2Vvd());
        this.hashColumns.put("orderby_title", getOrderbyTitle());
        this.hashColumns.put("ffdr", getFfdr());
        this.hashColumns.put("shp_call_no", getShpCallNo());
        this.hashColumns.put("cntc_pson_eml", getCntcPsonEml());
        this.hashColumns.put("exter_remark", getExterRemark());
        this.hashColumns.put("n_addr", getNAddr());
        this.hashColumns.put("rd_total_t2", getRdTotalT2());
        this.hashColumns.put("rd_total_t4", getRdTotalT4());
        this.hashColumns.put("pre_2_pod_cd", getPre2PodCd());
        this.hashColumns.put("post_2_pod_cd", getPost2PodCd());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("rd_total_d4", getRdTotalD4());
        this.hashColumns.put("soc_flg", getSocFlg());
        this.hashColumns.put("rd_total_d5", getRdTotalD5());
        this.hashColumns.put("caed_type", getCaedType());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("pre_1_pol_cd", getPre1PolCd());
        this.hashColumns.put("rd_total_d2", getRdTotalD2());
        this.hashColumns.put("post_2_vvd", getPost2Vvd());
        this.hashColumns.put("commodity", getCommodity());
        this.hashColumns.put("cnee_name", getCneeName());
        this.hashColumns.put("pre_4_vvd", getPre4Vvd());
        this.hashColumns.put("rd_total_d7", getRdTotalD7());
        this.hashColumns.put("hngr_flg", getHngrFlg());
        this.hashColumns.put("orderby_cnt", getOrderbyCnt());
        this.hashColumns.put("ffdr_name", getFfdrName());
        this.hashColumns.put("chg_inter_remark", getChgInterRemark());
        this.hashColumns.put("chg_inter_remark_detail", getChgInterRemarkDetail());
        this.hashColumns.put("chg_xter_remark", getChgXterRemark());
        this.hashColumns.put("chg_xter_remark_detail", getChgXterRemarkDetail());
        this.hashColumns.put("rd_total_o5", getRdTotalO5());
        this.hashColumns.put("ofc_team_cd", getOfcTeamCd());
        this.hashColumns.put("sail_dt", getSailDt());
        this.hashColumns.put("aloc_sts_cd", getAlocStsCd());
        this.hashColumns.put("si_cntc_pson_phn_no", getSiCntcPsonPhnNo());
        this.hashColumns.put("si_cntc_pson_eml", getSiCntcPsonEml());
        this.hashColumns.put("non_rt_sts_cd", getNonRtStsCd());
        this.hashColumns.put("etb_dt", getEtbDt());
        this.hashColumns.put("svc_scp_cd", getSvcScpCd());
        this.hashColumns.put("pre_contrat", getPreContrat());
        this.hashColumns.put("now_contrat", getNowContrat());
        this.hashColumns.put("rtro_knd_cd_nm", getRtroKndCdNm());
        this.hashColumns.put("cost_wk", getCostWk());
        this.hashColumns.put("activity_teu", getActivityTeu());
        this.hashColumns.put("activity_feu", getActivityFeu());
        this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
        this.hashColumns.put("mty_pkup_dt", getMtyPkupDt());
        this.hashColumns.put("dg_cmdt_desc", getDgCmdtDesc());
        this.hashColumns.put("a_cmdt_desc", getACmdtDesc());
        this.hashColumns.put("b_cmdt_desc", getBCmdtDesc());
        this.hashColumns.put("rd_total_o7", getRdTotalO7());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("act_cust_code", "actCustCode");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ob_srep_cd", "obSrepCd");
        this.hashFields.put("rows_per_page", "rowsPerPage");
        this.hashFields.put("dest_trns_svc_mod_cd", "destTrnsSvcModCd");
        this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
        this.hashFields.put("rd_total_r9", "rdTotalR9");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("bkg_cre_dt", "bkgCreDt");
        this.hashFields.put("stwg_cd", "stwgCd");
        this.hashFields.put("rd_total_r4", "rdTotalR4");
        this.hashFields.put("rd_total_r5", "rdTotalR5");
        this.hashFields.put("si_flg", "siFlg");
        this.hashFields.put("rd_total_r2", "rdTotalR2");
        this.hashFields.put("total_cnt", "totalCnt");
        this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
        this.hashFields.put("feu", "feu");
        this.hashFields.put("orderby_title_sql", "orderbyTitleSql");
        this.hashFields.put("inter_remark", "interRemark");
        this.hashFields.put("bkg_ctrl_ofc_cd", "bkgCtrlOfcCd");
        this.hashFields.put("caed_no", "caedNo");
        this.hashFields.put("s_addr", "sAddr");
        this.hashFields.put("post_1_vvd", "post1Vvd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("rd_total_z2", "rdTotalZ2");
        this.hashFields.put("trunk_pod", "trunkPod");
        this.hashFields.put("rd_total_z4", "rdTotalZ4");
        this.hashFields.put("ctrt_srep_cd", "ctrtSrepCd");
        this.hashFields.put("actual_pod", "actualPod");
        this.hashFields.put("pc", "pc");
        this.hashFields.put("rc_flg", "rcFlg");
        this.hashFields.put("trunk_pol", "trunkPol");
        this.hashFields.put("itn_flg", "itnFlg");
        this.hashFields.put("actual_pol", "actualPol");
        this.hashFields.put("total_teu", "totalTeu");
        this.hashFields.put("bkg_actwgt_qty", "bkgActwgtQty");
        this.hashFields.put("pre_3_pod_cd", "pre3PodCd");
        this.hashFields.put("post_3_pod_cd", "post3PodCd");
        this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("consignee", "consignee");
        this.hashFields.put("fd_grd_flg", "fdGrdFlg");
        this.hashFields.put("aes_no", "aesNo");
        this.hashFields.put("bkg_clz_flg", "bkgClzFlg");
        this.hashFields.put("caed_flg", "caedFlg");
        this.hashFields.put("contact", "contact");
        this.hashFields.put("inter_rmk", "interRmk");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("total_wgt", "totalWgt");
        this.hashFields.put("rd_total_p4", "rdTotalP4");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("rd_total_p2", "rdTotalP2");
        this.hashFields.put("pre_2_pol_cd", "pre2PolCd");
        this.hashFields.put("por_nod_cd", "porNodCd");
        this.hashFields.put("anty_name", "antyName");
        this.hashFields.put("total_mea", "totalMea");
        this.hashFields.put("shipper", "shipper");
        this.hashFields.put("pre_4_pol_cd", "pre4PolCd");
        this.hashFields.put("remark_detail", "remarkDetail");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("taa_no", "taaNo");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("rd_total_q2", "rdTotalQ2");
        this.hashFields.put("last_orderby", "lastOrderby");
        this.hashFields.put("rd_total_q4", "rdTotalQ4");
        this.hashFields.put("rep", "rep");
        this.hashFields.put("ntfy", "ntfy");
        this.hashFields.put("inter_remark_detail", "interRemarkDetail");
        this.hashFields.put("remark", "remark");
        this.hashFields.put("pre_1_vvd", "pre1Vvd");
        this.hashFields.put("total_bkg", "totalBkg");
        this.hashFields.put("tel", "tel");
        this.hashFields.put("c_addr", "cAddr");
        this.hashFields.put("rd_total_f2", "rdTotalF2");
        this.hashFields.put("blck_stwg_cd", "blckStwgCd");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pre_4_pod_cd", "pre4PodCd");
        this.hashFields.put("pre_3_pol_cd", "pre3PolCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("curr_page", "currPage");
        this.hashFields.put("rnum", "rnum");
        this.hashFields.put("post_4_vvd", "post4Vvd");
        this.hashFields.put("pre_1_pod_cd", "pre1PodCd");
        this.hashFields.put("post_1_pod_cd", "post1PodCd");
        this.hashFields.put("sc_no", "scNo");
        this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
        this.hashFields.put("del_nod_cd", "delNodCd");
        this.hashFields.put("act_cust_name", "actCustName");
        this.hashFields.put("total_feu", "totalFeu");
        this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
        this.hashFields.put("frt_term_cd", "frtTermCd");
        this.hashFields.put("fnl_dest_cd", "fnlDestCd");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("rd_total_o2", "rdTotalO2");
        this.hashFields.put("rd_total_o4", "rdTotalO4");
        this.hashFields.put("pre_3_vvd", "pre3Vvd");
        this.hashFields.put("rd_total_f4", "rdTotalF4");
        this.hashFields.put("ntfy_name", "ntfyName");
        this.hashFields.put("rd_total_f5", "rdTotalF5");
        this.hashFields.put("total_bl", "totalBl");
        this.hashFields.put("post_3_vvd", "post3Vvd");
        this.hashFields.put("orderby", "orderby");
        this.hashFields.put("teu", "teu");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("chg_term_cd", "chgTermCd");
        this.hashFields.put("shpr_name", "shprName");
        this.hashFields.put("org_trns_svc_mod_cd", "orgTrnsSvcModCd");
        this.hashFields.put("doc_usr_id", "docUsrId");
        this.hashFields.put("bdr_flg", "bdrFlg");
        this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
        this.hashFields.put("trunk_vvd", "trunkVvd");
        this.hashFields.put("itn_type", "itnType");
        this.hashFields.put("eq_subst_flg", "eqSubstFlg");
        this.hashFields.put("hot_de_flg", "hotDeFlg");
        this.hashFields.put("bkg_mea_qty", "bkgMeaQty");
        this.hashFields.put("rfa_no", "rfaNo");
        this.hashFields.put("rate_chk_sts", "rateChkSts");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("cstms_desc", "cstmsDesc");
        this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
        this.hashFields.put("dcgo_flg", "dcgoFlg");
        this.hashFields.put("expt_name", "exptName");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("pre_2_vvd", "pre2Vvd");
        this.hashFields.put("orderby_title", "orderbyTitle");
        this.hashFields.put("ffdr", "ffdr");
        this.hashFields.put("shp_call_no", "shpCallNo");
        this.hashFields.put("cntc_pson_eml", "cntcPsonEml");
        this.hashFields.put("exter_remark", "exterRemark");
        this.hashFields.put("n_addr", "nAddr");
        this.hashFields.put("rd_total_t2", "rdTotalT2");
        this.hashFields.put("rd_total_t4", "rdTotalT4");
        this.hashFields.put("pre_2_pod_cd", "pre2PodCd");
        this.hashFields.put("post_2_pod_cd", "post2PodCd");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("rd_total_d4", "rdTotalD4");
        this.hashFields.put("soc_flg", "socFlg");
        this.hashFields.put("rd_total_d5", "rdTotalD5");
        this.hashFields.put("caed_type", "caedType");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("pre_1_pol_cd", "pre1PolCd");
        this.hashFields.put("rd_total_d2", "rdTotalD2");
        this.hashFields.put("post_2_vvd", "post2Vvd");
        this.hashFields.put("commodity", "commodity");
        this.hashFields.put("cnee_name", "cneeName");
        this.hashFields.put("pre_4_vvd", "pre4Vvd");
        this.hashFields.put("rd_total_d7", "rdTotalD7");
        this.hashFields.put("hngr_flg", "hngrFlg");
        this.hashFields.put("orderby_cnt", "orderbyCnt");
        this.hashFields.put("ffdr_name", "ffdrName");
        this.hashFields.put("chg_inter_remark", "chgInterRemark");
        this.hashFields.put("chg_inter_remark_detail", "chgInterRemarkDetail");
        this.hashFields.put("chg_xter_remark", "chgXterRemark");
        this.hashFields.put("chg_xter_remark_detail", "chgXterRemarkDetail");
        this.hashFields.put("rd_total_o5", "rdTotalO5");
        this.hashFields.put("ofc_team_cd", "ofcTeamCd");
        this.hashFields.put("sail_dt", "sailDt");
        this.hashFields.put("aloc_sts_cd", "alocStsCd");
        this.hashFields.put("si_cntc_pson_phn_no", "siCntcPsonPhnNo");
        this.hashFields.put("si_cntc_pson_eml", "siCntcPsonEml");
        this.hashFields.put("non_rt_sts_cd", "nonRtStsCd");
        this.hashFields.put("etb_dt", "etbDt");
        this.hashFields.put("svc_scp_cd", "svcScpCd");
        this.hashFields.put("pre_contrat", "preContrat");
        this.hashFields.put("now_contrat", "nowContrat");
        this.hashFields.put("rtro_knd_cd_nm", "rtroKndCdNm");
        this.hashFields.put("cost_wk", "costWk");
        this.hashFields.put("activity_teu", "activityTeu");
        this.hashFields.put("activity_feu", "activityFeu");
        this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
        this.hashFields.put("mty_pkup_dt", "mtyPkupDt");
        this.hashFields.put("dg_cmdt_desc", "dgCmdtDesc");
        this.hashFields.put("a_cmdt_desc", "aCmdtDesc");
        this.hashFields.put("b_cmdt_desc", "bCmdtDesc");
        this.hashFields.put("rd_total_o7", "rdTotalO7");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return actCustCode
	 */
    public String getActCustCode() {
        return this.actCustCode;
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
	 * @return rowsPerPage
	 */
    public String getRowsPerPage() {
        return this.rowsPerPage;
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
	 * @return ctrtOfcCd
	 */
    public String getCtrtOfcCd() {
        return this.ctrtOfcCd;
    }

    /**
	 * Column Info
	 * @return rdTotalR9
	 */
    public String getRdTotalR9() {
        return this.rdTotalR9;
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
	 * @return bkgCreDt
	 */
    public String getBkgCreDt() {
        return this.bkgCreDt;
    }

    /**
	 * Column Info
	 * @return stwgCd
	 */
    public String getStwgCd() {
        return this.stwgCd;
    }

    /**
	 * Column Info
	 * @return rdTotalR4
	 */
    public String getRdTotalR4() {
        return this.rdTotalR4;
    }

    /**
	 * Column Info
	 * @return rdTotalR5
	 */
    public String getRdTotalR5() {
        return this.rdTotalR5;
    }

    /**
	 * Column Info
	 * @return siFlg
	 */
    public String getSiFlg() {
        return this.siFlg;
    }

    /**
	 * Column Info
	 * @return rdTotalR2
	 */
    public String getRdTotalR2() {
        return this.rdTotalR2;
    }

    /**
	 * Column Info
	 * @return totalCnt
	 */
    public String getTotalCnt() {
        return this.totalCnt;
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
	 * @return feu
	 */
    public String getFeu() {
        return this.feu;
    }

    /**
	 * Column Info
	 * @return orderbyTitleSql
	 */
    public String getOrderbyTitleSql() {
        return this.orderbyTitleSql;
    }

    /**
	 * Column Info
	 * @return interRemark
	 */
    public String getInterRemark() {
        return this.interRemark;
    }

    /**
	 * Column Info
	 * @return bkgCtrlOfcCd
	 */
    public String getBkgCtrlOfcCd() {
        return this.bkgCtrlOfcCd;
    }

    /**
	 * Column Info
	 * @return caedNo
	 */
    public String getCaedNo() {
        return this.caedNo;
    }

    /**
	 * Column Info
	 * @return sAddr
	 */
    public String getSAddr() {
        return this.sAddr;
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
	 * @return rdTotalZ2
	 */
    public String getRdTotalZ2() {
        return this.rdTotalZ2;
    }

    /**
	 * Column Info
	 * @return trunkPod
	 */
    public String getTrunkPod() {
        return this.trunkPod;
    }

    /**
	 * Column Info
	 * @return rdTotalZ4
	 */
    public String getRdTotalZ4() {
        return this.rdTotalZ4;
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
	 * @return actualPod
	 */
    public String getActualPod() {
        return this.actualPod;
    }

    /**
	 * Column Info
	 * @return pc
	 */
    public String getPc() {
        return this.pc;
    }

    /**
	 * Column Info
	 * @return rcFlg
	 */
    public String getRcFlg() {
        return this.rcFlg;
    }

    /**
	 * Column Info
	 * @return trunkPol
	 */
    public String getTrunkPol() {
        return this.trunkPol;
    }

    /**
	 * Column Info
	 * @return itnFlg
	 */
    public String getItnFlg() {
        return this.itnFlg;
    }

    /**
	 * Column Info
	 * @return actualPol
	 */
    public String getActualPol() {
        return this.actualPol;
    }

    /**
	 * Column Info
	 * @return totalTeu
	 */
    public String getTotalTeu() {
        return this.totalTeu;
    }

    /**
	 * Column Info
	 * @return bkgActwgtQty
	 */
    public String getBkgActwgtQty() {
        return this.bkgActwgtQty;
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
	 * @return post3PodCd
	 */
    public String getPost3PodCd() {
        return this.post3PodCd;
    }

    /**
	 * Column Info
	 * @return rdCgoFlg
	 */
    public String getRdCgoFlg() {
        return this.rdCgoFlg;
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
	 * @return consignee
	 */
    public String getConsignee() {
        return this.consignee;
    }

    /**
	 * Column Info
	 * @return fdGrdFlg
	 */
    public String getFdGrdFlg() {
        return this.fdGrdFlg;
    }

    /**
	 * Column Info
	 * @return aesNo
	 */
    public String getAesNo() {
        return this.aesNo;
    }

    /**
	 * Column Info
	 * @return bkgClzFlg
	 */
    public String getBkgClzFlg() {
        return this.bkgClzFlg;
    }

    /**
	 * Column Info
	 * @return caedFlg
	 */
    public String getCaedFlg() {
        return this.caedFlg;
    }

    /**
	 * Column Info
	 * @return contact
	 */
    public String getContact() {
        return this.contact;
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
	 * @return totalWgt
	 */
    public String getTotalWgt() {
        return this.totalWgt;
    }

    /**
	 * Column Info
	 * @return rdTotalP4
	 */
    public String getRdTotalP4() {
        return this.rdTotalP4;
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
	 * @return rdTotalP2
	 */
    public String getRdTotalP2() {
        return this.rdTotalP2;
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
	 * @return porNodCd
	 */
    public String getPorNodCd() {
        return this.porNodCd;
    }

    /**
	 * Column Info
	 * @return antyName
	 */
    public String getAntyName() {
        return this.antyName;
    }

    /**
	 * Column Info
	 * @return totalMea
	 */
    public String getTotalMea() {
        return this.totalMea;
    }

    /**
	 * Column Info
	 * @return shipper
	 */
    public String getShipper() {
        return this.shipper;
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
	 * @return remarkDetail
	 */
    public String getRemarkDetail() {
        return this.remarkDetail;
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
	 * @return taaNo
	 */
    public String getTaaNo() {
        return this.taaNo;
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
	 * @return rdTotalQ2
	 */
    public String getRdTotalQ2() {
        return this.rdTotalQ2;
    }

    /**
	 * Column Info
	 * @return lastOrderby
	 */
    public String getLastOrderby() {
        return this.lastOrderby;
    }

    /**
	 * Column Info
	 * @return rdTotalQ4
	 */
    public String getRdTotalQ4() {
        return this.rdTotalQ4;
    }

    /**
	 * Column Info
	 * @return rep
	 */
    public String getRep() {
        return this.rep;
    }

    /**
	 * Column Info
	 * @return ntfy
	 */
    public String getNtfy() {
        return this.ntfy;
    }

    /**
	 * Column Info
	 * @return interRemarkDetail
	 */
    public String getInterRemarkDetail() {
        return this.interRemarkDetail;
    }

    /**
	 * Column Info
	 * @return remark
	 */
    public String getRemark() {
        return this.remark;
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
	 * @return totalBkg
	 */
    public String getTotalBkg() {
        return this.totalBkg;
    }

    /**
	 * Column Info
	 * @return tel
	 */
    public String getTel() {
        return this.tel;
    }

    /**
	 * Column Info
	 * @return cAddr
	 */
    public String getCAddr() {
        return this.cAddr;
    }

    /**
	 * Column Info
	 * @return rdTotalF2
	 */
    public String getRdTotalF2() {
        return this.rdTotalF2;
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
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
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
	 * @return currPage
	 */
    public String getCurrPage() {
        return this.currPage;
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
	 * @return post4Vvd
	 */
    public String getPost4Vvd() {
        return this.post4Vvd;
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
	 * @return post1PodCd
	 */
    public String getPost1PodCd() {
        return this.post1PodCd;
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
	 * @return obSlsOfcCd
	 */
    public String getObSlsOfcCd() {
        return this.obSlsOfcCd;
    }

    /**
	 * Column Info
	 * @return delNodCd
	 */
    public String getDelNodCd() {
        return this.delNodCd;
    }

    /**
	 * Column Info
	 * @return actCustName
	 */
    public String getActCustName() {
        return this.actCustName;
    }

    /**
	 * Column Info
	 * @return totalFeu
	 */
    public String getTotalFeu() {
        return this.totalFeu;
    }

    /**
	 * Column Info
	 * @return awkCgoFlg
	 */
    public String getAwkCgoFlg() {
        return this.awkCgoFlg;
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
	 * @return fnlDestCd
	 */
    public String getFnlDestCd() {
        return this.fnlDestCd;
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
	 * @return rdTotalO2
	 */
    public String getRdTotalO2() {
        return this.rdTotalO2;
    }

    /**
	 * Column Info
	 * @return rdTotalO4
	 */
    public String getRdTotalO4() {
        return this.rdTotalO4;
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
	 * @return rdTotalF4
	 */
    public String getRdTotalF4() {
        return this.rdTotalF4;
    }

    /**
	 * Column Info
	 * @return ntfyName
	 */
    public String getNtfyName() {
        return this.ntfyName;
    }

    /**
	 * Column Info
	 * @return rdTotalF5
	 */
    public String getRdTotalF5() {
        return this.rdTotalF5;
    }

    /**
	 * Column Info
	 * @return totalBl
	 */
    public String getTotalBl() {
        return this.totalBl;
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
	 * @return orderby
	 */
    public String getOrderby() {
        return this.orderby;
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
	 * @return porCd
	 */
    public String getPorCd() {
        return this.porCd;
    }

    /**
	 * Column Info
	 * @return chgTermCd
	 */
    public String getChgTermCd() {
        return this.chgTermCd;
    }

    /**
	 * Column Info
	 * @return shprName
	 */
    public String getShprName() {
        return this.shprName;
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
	 * @return bdrFlg
	 */
    public String getBdrFlg() {
        return this.bdrFlg;
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
	 * @return trunkVvd
	 */
    public String getTrunkVvd() {
        return this.trunkVvd;
    }

    /**
	 * Column Info
	 * @return itnType
	 */
    public String getItnType() {
        return this.itnType;
    }

    /**
	 * Column Info
	 * @return eqSubstFlg
	 */
    public String getEqSubstFlg() {
        return this.eqSubstFlg;
    }

    /**
	 * Column Info
	 * @return hotDeFlg
	 */
    public String getHotDeFlg() {
        return this.hotDeFlg;
    }

    /**
	 * Column Info
	 * @return bkgMeaQty
	 */
    public String getBkgMeaQty() {
        return this.bkgMeaQty;
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
	 * @return rateChkSts
	 */
    public String getRateChkSts() {
        return this.rateChkSts;
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
	 * @return vslEngNm
	 */
    public String getVslEngNm() {
        return this.vslEngNm;
    }

    /**
	 * Column Info
	 * @return cstmsDesc
	 */
    public String getCstmsDesc() {
        return this.cstmsDesc;
    }

    /**
	 * Column Info
	 * @return bbCgoFlg
	 */
    public String getBbCgoFlg() {
        return this.bbCgoFlg;
    }

    /**
	 * Column Info
	 * @return dcgoFlg
	 */
    public String getDcgoFlg() {
        return this.dcgoFlg;
    }

    /**
	 * Column Info
	 * @return exptName
	 */
    public String getExptName() {
        return this.exptName;
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
	 * @return rcvTermCd
	 */
    public String getRcvTermCd() {
        return this.rcvTermCd;
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
	 * @return orderbyTitle
	 */
    public String getOrderbyTitle() {
        return this.orderbyTitle;
    }

    /**
	 * Column Info
	 * @return ffdr
	 */
    public String getFfdr() {
        return this.ffdr;
    }

    /**
	 * Column Info
	 * @return shpCallNo
	 */
    public String getShpCallNo() {
        return this.shpCallNo;
    }

    /**
	 * Column Info
	 * @return cntcPsonEml
	 */
    public String getCntcPsonEml() {
        return this.cntcPsonEml;
    }

    /**
	 * Column Info
	 * @return exterRemark
	 */
    public String getExterRemark() {
        return this.exterRemark;
    }

    /**
	 * Column Info
	 * @return nAddr
	 */
    public String getNAddr() {
        return this.nAddr;
    }

    /**
	 * Column Info
	 * @return rdTotalT2
	 */
    public String getRdTotalT2() {
        return this.rdTotalT2;
    }

    /**
	 * Column Info
	 * @return rdTotalT4
	 */
    public String getRdTotalT4() {
        return this.rdTotalT4;
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
	 * @return post2PodCd
	 */
    public String getPost2PodCd() {
        return this.post2PodCd;
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
	 * @return rdTotalD4
	 */
    public String getRdTotalD4() {
        return this.rdTotalD4;
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
	 * @return rdTotalD5
	 */
    public String getRdTotalD5() {
        return this.rdTotalD5;
    }

    /**
	 * Column Info
	 * @return caedType
	 */
    public String getCaedType() {
        return this.caedType;
    }

    /**
	 * Column Info
	 * @return deTermCd
	 */
    public String getDeTermCd() {
        return this.deTermCd;
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
	 * @return rdTotalD2
	 */
    public String getRdTotalD2() {
        return this.rdTotalD2;
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
	 * @return commodity
	 */
    public String getCommodity() {
        return this.commodity;
    }

    /**
	 * Column Info
	 * @return cneeName
	 */
    public String getCneeName() {
        return this.cneeName;
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
	 * @return rdTotalD7
	 */
    public String getRdTotalD7() {
        return this.rdTotalD7;
    }

    /**
	 * Column Info
	 * @return hngrFlg
	 */
    public String getHngrFlg() {
        return this.hngrFlg;
    }

    /**
	 * Column Info
	 * @return orderbyCnt
	 */
    public String getOrderbyCnt() {
        return this.orderbyCnt;
    }

    /**
	 * Column Info
	 * @return ffdrName
	 */
    public String getFfdrName() {
        return this.ffdrName;
    }

    /**
	 * Column Info
	 * @return chgInterRemark
	 */
    public String getChgInterRemark() {
        return chgInterRemark;
    }

    /**
	 * Column Info
	 * @return chgXterRemark
	 */
    public String getChgXterRemark() {
        return chgXterRemark;
    }

    /**
	 * Column Info
	 * @return chgInterRemarkDetail
	 */
    public String getChgInterRemarkDetail() {
        return chgInterRemarkDetail;
    }

    /**
	 * Column Info
	 * @return chgXterRemarkDetail
	 */
    public String getChgXterRemarkDetail() {
        return chgXterRemarkDetail;
    }

    /**
	 * Column Info
	 * @return rdTotalO5
	 */
    public String getRdTotalO5() {
        return this.rdTotalO5;
    }

    /**
	 * Column Info
	 * @return ofcTeamCd
	 */
    public String getOfcTeamCd() {
        return this.ofcTeamCd;
    }

    /**
	 * Column Info
	 * @return sailDt
	 */
    public String getSailDt() {
        return this.sailDt;
    }

    /**
	 * Column Info
	 * @return alocStsCd
	 */
    public String getAlocStsCd() {
        return this.alocStsCd;
    }

    /**
	 * Column Info
	 * @return siCntcPsonPhnNo
	 */
    public String getSiCntcPsonPhnNo() {
        return this.siCntcPsonPhnNo;
    }

    /**
	 * Column Info
	 * @return siCntcPsonEml
	 */
    public String getSiCntcPsonEml() {
        return this.siCntcPsonEml;
    }

    /**
	 * Column Info
	 * @return nonRtStsCd
	 */
    public String getNonRtStsCd() {
        return this.nonRtStsCd;
    }

    /**
	 * Column Info
	 * @return etbDt
	 */
    public String getEtbDt() {
        return this.etbDt;
    }

    /**
	 * Column Info
	 * @return svcScpCd
	 */
    public String getSvcScpCd() {
        return this.svcScpCd;
    }

    /**
	 * Column Info
	 * @return preContrat
	 */
    public String getPreContrat() {
        return this.preContrat;
    }

    /**
	 * Column Info
	 * @return nowContrat
	 */
    public String getNowContrat() {
        return this.nowContrat;
    }

    /**
	 * Column Info
	 * @param costWk
	 */
    public String getCostWk() {
        return this.costWk;
    }

    /**
	 * Column Info
	 * @param activityTeu
	 */
    public String getActivityTeu() {
        return this.activityTeu;
    }

    /**
	 * Column Info
	 * @param activityFeu
	 */
    public String getActivityFeu() {
        return this.activityFeu;
    }

    /**
	 * Column Info
	 * @param rtroKndCdNm
	 */
    public String getRtroKndCdNm() {
        return this.rtroKndCdNm;
    }

    public String getMtyPkupYdCd() {
        return mtyPkupYdCd;
    }

    public String getMtyPkupDt() {
        return mtyPkupDt;
    }

    public void setMtyPkupDt(String mtyPkupDt) {
        this.mtyPkupDt = mtyPkupDt;
    }

    public void setMtyPkupYdCd(String mtyPkupYdCd) {
        this.mtyPkupYdCd = mtyPkupYdCd;
    }

    /**
	 * Column Info
	 * @param actCustCode
	 */
    public void setActCustCode(String actCustCode) {
        this.actCustCode = actCustCode;
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
	 * @param rowsPerPage
	 */
    public void setRowsPerPage(String rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
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
	 * @param ctrtOfcCd
	 */
    public void setCtrtOfcCd(String ctrtOfcCd) {
        this.ctrtOfcCd = ctrtOfcCd;
    }

    /**
	 * Column Info
	 * @param rdTotalR9
	 */
    public void setRdTotalR9(String rdTotalR9) {
        this.rdTotalR9 = rdTotalR9;
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
	 * @param bkgCreDt
	 */
    public void setBkgCreDt(String bkgCreDt) {
        this.bkgCreDt = bkgCreDt;
    }

    /**
	 * Column Info
	 * @param stwgCd
	 */
    public void setStwgCd(String stwgCd) {
        this.stwgCd = stwgCd;
    }

    /**
	 * Column Info
	 * @param rdTotalR4
	 */
    public void setRdTotalR4(String rdTotalR4) {
        this.rdTotalR4 = rdTotalR4;
    }

    /**
	 * Column Info
	 * @param rdTotalR5
	 */
    public void setRdTotalR5(String rdTotalR5) {
        this.rdTotalR5 = rdTotalR5;
    }

    /**
	 * Column Info
	 * @param siFlg
	 */
    public void setSiFlg(String siFlg) {
        this.siFlg = siFlg;
    }

    /**
	 * Column Info
	 * @param rdTotalR2
	 */
    public void setRdTotalR2(String rdTotalR2) {
        this.rdTotalR2 = rdTotalR2;
    }

    /**
	 * Column Info
	 * @param totalCnt
	 */
    public void setTotalCnt(String totalCnt) {
        this.totalCnt = totalCnt;
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
	 * @param feu
	 */
    public void setFeu(String feu) {
        this.feu = feu;
    }

    /**
	 * Column Info
	 * @param orderbyTitleSql
	 */
    public void setOrderbyTitleSql(String orderbyTitleSql) {
        this.orderbyTitleSql = orderbyTitleSql;
    }

    /**
	 * Column Info
	 * @param interRemark
	 */
    public void setInterRemark(String interRemark) {
        this.interRemark = interRemark;
    }

    /**
	 * Column Info
	 * @param bkgCtrlOfcCd
	 */
    public void setBkgCtrlOfcCd(String bkgCtrlOfcCd) {
        this.bkgCtrlOfcCd = bkgCtrlOfcCd;
    }

    /**
	 * Column Info
	 * @param caedNo
	 */
    public void setCaedNo(String caedNo) {
        this.caedNo = caedNo;
    }

    /**
	 * Column Info
	 * @param sAddr
	 */
    public void setSAddr(String sAddr) {
        this.sAddr = sAddr;
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
	 * @param rdTotalZ2
	 */
    public void setRdTotalZ2(String rdTotalZ2) {
        this.rdTotalZ2 = rdTotalZ2;
    }

    /**
	 * Column Info
	 * @param trunkPod
	 */
    public void setTrunkPod(String trunkPod) {
        this.trunkPod = trunkPod;
    }

    /**
	 * Column Info
	 * @param rdTotalZ4
	 */
    public void setRdTotalZ4(String rdTotalZ4) {
        this.rdTotalZ4 = rdTotalZ4;
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
	 * @param actualPod
	 */
    public void setActualPod(String actualPod) {
        this.actualPod = actualPod;
    }

    /**
	 * Column Info
	 * @param pc
	 */
    public void setPc(String pc) {
        this.pc = pc;
    }

    /**
	 * Column Info
	 * @param rcFlg
	 */
    public void setRcFlg(String rcFlg) {
        this.rcFlg = rcFlg;
    }

    /**
	 * Column Info
	 * @param trunkPol
	 */
    public void setTrunkPol(String trunkPol) {
        this.trunkPol = trunkPol;
    }

    /**
	 * Column Info
	 * @param itnFlg
	 */
    public void setItnFlg(String itnFlg) {
        this.itnFlg = itnFlg;
    }

    /**
	 * Column Info
	 * @param actualPol
	 */
    public void setActualPol(String actualPol) {
        this.actualPol = actualPol;
    }

    /**
	 * Column Info
	 * @param totalTeu
	 */
    public void setTotalTeu(String totalTeu) {
        this.totalTeu = totalTeu;
    }

    /**
	 * Column Info
	 * @param bkgActwgtQty
	 */
    public void setBkgActwgtQty(String bkgActwgtQty) {
        this.bkgActwgtQty = bkgActwgtQty;
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
	 * @param post3PodCd
	 */
    public void setPost3PodCd(String post3PodCd) {
        this.post3PodCd = post3PodCd;
    }

    /**
	 * Column Info
	 * @param rdCgoFlg
	 */
    public void setRdCgoFlg(String rdCgoFlg) {
        this.rdCgoFlg = rdCgoFlg;
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
	 * @param consignee
	 */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /**
	 * Column Info
	 * @param fdGrdFlg
	 */
    public void setFdGrdFlg(String fdGrdFlg) {
        this.fdGrdFlg = fdGrdFlg;
    }

    /**
	 * Column Info
	 * @param aesNo
	 */
    public void setAesNo(String aesNo) {
        this.aesNo = aesNo;
    }

    /**
	 * Column Info
	 * @param bkgClzFlg
	 */
    public void setBkgClzFlg(String bkgClzFlg) {
        this.bkgClzFlg = bkgClzFlg;
    }

    /**
	 * Column Info
	 * @param caedFlg
	 */
    public void setCaedFlg(String caedFlg) {
        this.caedFlg = caedFlg;
    }

    /**
	 * Column Info
	 * @param contact
	 */
    public void setContact(String contact) {
        this.contact = contact;
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
	 * @param totalWgt
	 */
    public void setTotalWgt(String totalWgt) {
        this.totalWgt = totalWgt;
    }

    /**
	 * Column Info
	 * @param rdTotalP4
	 */
    public void setRdTotalP4(String rdTotalP4) {
        this.rdTotalP4 = rdTotalP4;
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
	 * @param rdTotalP2
	 */
    public void setRdTotalP2(String rdTotalP2) {
        this.rdTotalP2 = rdTotalP2;
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
	 * @param porNodCd
	 */
    public void setPorNodCd(String porNodCd) {
        this.porNodCd = porNodCd;
    }

    /**
	 * Column Info
	 * @param antyName
	 */
    public void setAntyName(String antyName) {
        this.antyName = antyName;
    }

    /**
	 * Column Info
	 * @param totalMea
	 */
    public void setTotalMea(String totalMea) {
        this.totalMea = totalMea;
    }

    /**
	 * Column Info
	 * @param shipper
	 */
    public void setShipper(String shipper) {
        this.shipper = shipper;
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
	 * @param remarkDetail
	 */
    public void setRemarkDetail(String remarkDetail) {
        this.remarkDetail = remarkDetail;
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
	 * @param taaNo
	 */
    public void setTaaNo(String taaNo) {
        this.taaNo = taaNo;
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
	 * @param rdTotalQ2
	 */
    public void setRdTotalQ2(String rdTotalQ2) {
        this.rdTotalQ2 = rdTotalQ2;
    }

    /**
	 * Column Info
	 * @param lastOrderby
	 */
    public void setLastOrderby(String lastOrderby) {
        this.lastOrderby = lastOrderby;
    }

    /**
	 * Column Info
	 * @param rdTotalQ4
	 */
    public void setRdTotalQ4(String rdTotalQ4) {
        this.rdTotalQ4 = rdTotalQ4;
    }

    /**
	 * Column Info
	 * @param rep
	 */
    public void setRep(String rep) {
        this.rep = rep;
    }

    /**
	 * Column Info
	 * @param ntfy
	 */
    public void setNtfy(String ntfy) {
        this.ntfy = ntfy;
    }

    /**
	 * Column Info
	 * @param interRemarkDetail
	 */
    public void setInterRemarkDetail(String interRemarkDetail) {
        this.interRemarkDetail = interRemarkDetail;
    }

    /**
	 * Column Info
	 * @param remark
	 */
    public void setRemark(String remark) {
        this.remark = remark;
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
	 * @param totalBkg
	 */
    public void setTotalBkg(String totalBkg) {
        this.totalBkg = totalBkg;
    }

    /**
	 * Column Info
	 * @param tel
	 */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
	 * Column Info
	 * @param cAddr
	 */
    public void setCAddr(String cAddr) {
        this.cAddr = cAddr;
    }

    /**
	 * Column Info
	 * @param rdTotalF2
	 */
    public void setRdTotalF2(String rdTotalF2) {
        this.rdTotalF2 = rdTotalF2;
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
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
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
	 * @param currPage
	 */
    public void setCurrPage(String currPage) {
        this.currPage = currPage;
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
	 * @param post4Vvd
	 */
    public void setPost4Vvd(String post4Vvd) {
        this.post4Vvd = post4Vvd;
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
	 * @param post1PodCd
	 */
    public void setPost1PodCd(String post1PodCd) {
        this.post1PodCd = post1PodCd;
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
	 * @param obSlsOfcCd
	 */
    public void setObSlsOfcCd(String obSlsOfcCd) {
        this.obSlsOfcCd = obSlsOfcCd;
    }

    /**
	 * Column Info
	 * @param delNodCd
	 */
    public void setDelNodCd(String delNodCd) {
        this.delNodCd = delNodCd;
    }

    /**
	 * Column Info
	 * @param actCustName
	 */
    public void setActCustName(String actCustName) {
        this.actCustName = actCustName;
    }

    /**
	 * Column Info
	 * @param totalFeu
	 */
    public void setTotalFeu(String totalFeu) {
        this.totalFeu = totalFeu;
    }

    /**
	 * Column Info
	 * @param awkCgoFlg
	 */
    public void setAwkCgoFlg(String awkCgoFlg) {
        this.awkCgoFlg = awkCgoFlg;
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
	 * @param fnlDestCd
	 */
    public void setFnlDestCd(String fnlDestCd) {
        this.fnlDestCd = fnlDestCd;
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
	 * @param rdTotalO2
	 */
    public void setRdTotalO2(String rdTotalO2) {
        this.rdTotalO2 = rdTotalO2;
    }

    /**
	 * Column Info
	 * @param rdTotalO4
	 */
    public void setRdTotalO4(String rdTotalO4) {
        this.rdTotalO4 = rdTotalO4;
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
	 * @param rdTotalF4
	 */
    public void setRdTotalF4(String rdTotalF4) {
        this.rdTotalF4 = rdTotalF4;
    }

    /**
	 * Column Info
	 * @param ntfyName
	 */
    public void setNtfyName(String ntfyName) {
        this.ntfyName = ntfyName;
    }

    /**
	 * Column Info
	 * @param rdTotalF5
	 */
    public void setRdTotalF5(String rdTotalF5) {
        this.rdTotalF5 = rdTotalF5;
    }

    /**
	 * Column Info
	 * @param totalBl
	 */
    public void setTotalBl(String totalBl) {
        this.totalBl = totalBl;
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
	 * @param orderby
	 */
    public void setOrderby(String orderby) {
        this.orderby = orderby;
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
	 * @param porCd
	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Column Info
	 * @param chgTermCd
	 */
    public void setChgTermCd(String chgTermCd) {
        this.chgTermCd = chgTermCd;
    }

    /**
	 * Column Info
	 * @param shprName
	 */
    public void setShprName(String shprName) {
        this.shprName = shprName;
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
	 * @param bdrFlg
	 */
    public void setBdrFlg(String bdrFlg) {
        this.bdrFlg = bdrFlg;
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
	 * @param trunkVvd
	 */
    public void setTrunkVvd(String trunkVvd) {
        this.trunkVvd = trunkVvd;
    }

    /**
	 * Column Info
	 * @param itnType
	 */
    public void setItnType(String itnType) {
        this.itnType = itnType;
    }

    /**
	 * Column Info
	 * @param eqSubstFlg
	 */
    public void setEqSubstFlg(String eqSubstFlg) {
        this.eqSubstFlg = eqSubstFlg;
    }

    /**
	 * Column Info
	 * @param hotDeFlg
	 */
    public void setHotDeFlg(String hotDeFlg) {
        this.hotDeFlg = hotDeFlg;
    }

    /**
	 * Column Info
	 * @param bkgMeaQty
	 */
    public void setBkgMeaQty(String bkgMeaQty) {
        this.bkgMeaQty = bkgMeaQty;
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
	 * @param rateChkSts
	 */
    public void setRateChkSts(String rateChkSts) {
        this.rateChkSts = rateChkSts;
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
	 * @param vslEngNm
	 */
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    /**
	 * Column Info
	 * @param cstmsDesc
	 */
    public void setCstmsDesc(String cstmsDesc) {
        this.cstmsDesc = cstmsDesc;
    }

    /**
	 * Column Info
	 * @param bbCgoFlg
	 */
    public void setBbCgoFlg(String bbCgoFlg) {
        this.bbCgoFlg = bbCgoFlg;
    }

    /**
	 * Column Info
	 * @param dcgoFlg
	 */
    public void setDcgoFlg(String dcgoFlg) {
        this.dcgoFlg = dcgoFlg;
    }

    /**
	 * Column Info
	 * @param exptName
	 */
    public void setExptName(String exptName) {
        this.exptName = exptName;
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
	 * @param rcvTermCd
	 */
    public void setRcvTermCd(String rcvTermCd) {
        this.rcvTermCd = rcvTermCd;
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
	 * @param orderbyTitle
	 */
    public void setOrderbyTitle(String orderbyTitle) {
        this.orderbyTitle = orderbyTitle;
    }

    /**
	 * Column Info
	 * @param ffdr
	 */
    public void setFfdr(String ffdr) {
        this.ffdr = ffdr;
    }

    /**
	 * Column Info
	 * @param shpCallNo
	 */
    public void setShpCallNo(String shpCallNo) {
        this.shpCallNo = shpCallNo;
    }

    /**
	 * Column Info
	 * @param cntcPsonEml
	 */
    public void setCntcPsonEml(String cntcPsonEml) {
        this.cntcPsonEml = cntcPsonEml;
    }

    /**
	 * Column Info
	 * @param exterRemark
	 */
    public void setExterRemark(String exterRemark) {
        this.exterRemark = exterRemark;
    }

    /**
	 * Column Info
	 * @param nAddr
	 */
    public void setNAddr(String nAddr) {
        this.nAddr = nAddr;
    }

    /**
	 * Column Info
	 * @param rdTotalT2
	 */
    public void setRdTotalT2(String rdTotalT2) {
        this.rdTotalT2 = rdTotalT2;
    }

    /**
	 * Column Info
	 * @param rdTotalT4
	 */
    public void setRdTotalT4(String rdTotalT4) {
        this.rdTotalT4 = rdTotalT4;
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
	 * @param post2PodCd
	 */
    public void setPost2PodCd(String post2PodCd) {
        this.post2PodCd = post2PodCd;
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
	 * @param rdTotalD4
	 */
    public void setRdTotalD4(String rdTotalD4) {
        this.rdTotalD4 = rdTotalD4;
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
	 * @param rdTotalD5
	 */
    public void setRdTotalD5(String rdTotalD5) {
        this.rdTotalD5 = rdTotalD5;
    }

    /**
	 * Column Info
	 * @param caedType
	 */
    public void setCaedType(String caedType) {
        this.caedType = caedType;
    }

    /**
	 * Column Info
	 * @param deTermCd
	 */
    public void setDeTermCd(String deTermCd) {
        this.deTermCd = deTermCd;
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
	 * @param rdTotalD2
	 */
    public void setRdTotalD2(String rdTotalD2) {
        this.rdTotalD2 = rdTotalD2;
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
	 * @param commodity
	 */
    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    /**
	 * Column Info
	 * @param cneeName
	 */
    public void setCneeName(String cneeName) {
        this.cneeName = cneeName;
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
	 * @param rdTotalD7
	 */
    public void setRdTotalD7(String rdTotalD7) {
        this.rdTotalD7 = rdTotalD7;
    }

    /**
	 * Column Info
	 * @param hngrFlg
	 */
    public void setHngrFlg(String hngrFlg) {
        this.hngrFlg = hngrFlg;
    }

    /**
	 * Column Info
	 * @param orderbyCnt
	 */
    public void setOrderbyCnt(String orderbyCnt) {
        this.orderbyCnt = orderbyCnt;
    }

    /**
	 * Column Info
	 * @param ffdrName
	 */
    public void setFfdrName(String ffdrName) {
        this.ffdrName = ffdrName;
    }

    /**
	 * Column Info
	 * @param chgInterRemark
	 */
    public void setChgInterRemark(String chgInterRemark) {
        this.chgInterRemark = chgInterRemark;
    }

    /**
	 * Column Info
	 * @param chgXterRemark
	 */
    public void setChgXterRemark(String chgXterRemark) {
        this.chgXterRemark = chgXterRemark;
    }

    /**
	 * Column Info
	 * @param chgInterRemarkDetail
	 */
    public void setChgInterRemarkDetail(String chgInterRemarkDetail) {
        this.chgInterRemarkDetail = chgInterRemarkDetail;
    }

    /**
	 * Column Info
	 * @param chgXterRemarkDetail
	 */
    public void setChgXterRemarkDetail(String chgXterRemarkDetail) {
        this.chgXterRemarkDetail = chgXterRemarkDetail;
    }

    /**
	 * Column Info
	 * @param rdTotalO5
	 */
    public void setRdTotalO5(String rdTotalO5) {
        this.rdTotalO5 = rdTotalO5;
    }

    /**
	 * Column Info
	 * @param ofcTeamCd
	 */
    public void setOfcTeamCd(String ofcTeamCd) {
        this.ofcTeamCd = ofcTeamCd;
    }

    /**
	 * Column Info
	 * @param sailDt
	 */
    public void setSailDt(String sailDt) {
        this.sailDt = sailDt;
    }

    /**
	 * Column Info
	 * @param alocStsCd
	 */
    public void setAlocStsCd(String alocStsCd) {
        this.alocStsCd = alocStsCd;
    }

    /**
	 * Column Info
	 * @param siCntcPsonPhnNo
	 */
    public void setSiCntcPsonPhnNo(String siCntcPsonPhnNo) {
        this.siCntcPsonPhnNo = siCntcPsonPhnNo;
    }

    /**
	 * Column Info
	 * @param siCntcPsonEml
	 */
    public void setSiCntcPsonEml(String siCntcPsonEml) {
        this.siCntcPsonEml = siCntcPsonEml;
    }

    /**
	 * Column Info
	 * @param nonRtStsCd
	 */
    public void setNonRtStsCd(String nonRtStsCd) {
        this.nonRtStsCd = nonRtStsCd;
    }

    /**
	 * Column Info
	 * @param etbDt
	 */
    public void setEtbDt(String etbDt) {
        this.etbDt = etbDt;
    }

    /**
	 * Column Info
	 * @param svcScpCd
	 */
    public void setSvcScpCd(String svcScpCd) {
        this.svcScpCd = svcScpCd;
    }

    /**
	 * Column Info
	 * @param preContrat
	 */
    public void setPreContrat(String preContrat) {
        this.preContrat = preContrat;
    }

    /**
	 * Column Info
	 * @param nowContrat
	 */
    public void setNowContrat(String nowContrat) {
        this.nowContrat = nowContrat;
    }

    /**
	 * Column Info
	 * @param rtroKndCdNm
	 */
    public void setRtroKndCdNm(String rtroKndCdNm) {
        this.rtroKndCdNm = rtroKndCdNm;
    }

    /**
	 * Column Info
	 * @param costWk
	 */
    public void setCostWk(String costWk) {
        this.costWk = costWk;
    }

    /**
	 * Column Info
	 * @param activityFeu
	 */
    public void setActivityTeu(String activityTeu) {
        this.activityTeu = activityTeu;
    }

    /**
	 * Column Info
	 * @param activityFeu
	 */
    public void setActivityFeu(String activityFeu) {
        this.activityFeu = activityFeu;
    }

    public void setDgCmdtDesc(String dgCmdtDesc) {
        this.dgCmdtDesc = dgCmdtDesc;
    }

    public String getDgCmdtDesc() {
        return this.getACmdtDesc() + this.getBCmdtDesc();
    }

    public void setACmdtDesc(String aCmdtDesc) {
        this.aCmdtDesc = aCmdtDesc;
    }

    public String getACmdtDesc() {
        return this.aCmdtDesc;
    }

    public void setBCmdtDesc(String bCmdtDesc) {
        this.bCmdtDesc = bCmdtDesc;
    }

    public String getBCmdtDesc() {
        return this.bCmdtDesc;
    }

    public void setRdTotalO7(String rdTotalO7) {
        this.rdTotalO7 = rdTotalO7;
    }

    public String getRdTotalO7() {
        return this.rdTotalO7;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setActCustCode(JSPUtil.getParameter(request, prefix + "act_cust_code", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
        setRowsPerPage(JSPUtil.getParameter(request, prefix + "rows_per_page", ""));
        setDestTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "dest_trns_svc_mod_cd", ""));
        setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
        setRdTotalR9(JSPUtil.getParameter(request, prefix + "rd_total_r9", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
        setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
        setRdTotalR4(JSPUtil.getParameter(request, prefix + "rd_total_r4", ""));
        setRdTotalR5(JSPUtil.getParameter(request, prefix + "rd_total_r5", ""));
        setSiFlg(JSPUtil.getParameter(request, prefix + "si_flg", ""));
        setRdTotalR2(JSPUtil.getParameter(request, prefix + "rd_total_r2", ""));
        setTotalCnt(JSPUtil.getParameter(request, prefix + "total_cnt", ""));
        setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
        setFeu(JSPUtil.getParameter(request, prefix + "feu", ""));
        setOrderbyTitleSql(JSPUtil.getParameter(request, prefix + "orderby_title_sql", ""));
        setInterRemark(JSPUtil.getParameter(request, prefix + "inter_remark", ""));
        setBkgCtrlOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ctrl_ofc_cd", ""));
        setCaedNo(JSPUtil.getParameter(request, prefix + "caed_no", ""));
        setSAddr(JSPUtil.getParameter(request, prefix + "s_addr", ""));
        setPost1Vvd(JSPUtil.getParameter(request, prefix + "post_1_vvd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setRdTotalZ2(JSPUtil.getParameter(request, prefix + "rd_total_z2", ""));
        setTrunkPod(JSPUtil.getParameter(request, prefix + "trunk_pod", ""));
        setRdTotalZ4(JSPUtil.getParameter(request, prefix + "rd_total_z4", ""));
        setCtrtSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_srep_cd", ""));
        setActualPod(JSPUtil.getParameter(request, prefix + "actual_pod", ""));
        setPc(JSPUtil.getParameter(request, prefix + "pc", ""));
        setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
        setTrunkPol(JSPUtil.getParameter(request, prefix + "trunk_pol", ""));
        setItnFlg(JSPUtil.getParameter(request, prefix + "itn_flg", ""));
        setActualPol(JSPUtil.getParameter(request, prefix + "actual_pol", ""));
        setTotalTeu(JSPUtil.getParameter(request, prefix + "total_teu", ""));
        setBkgActwgtQty(JSPUtil.getParameter(request, prefix + "bkg_actwgt_qty", ""));
        setPre3PodCd(JSPUtil.getParameter(request, prefix + "pre_3_pod_cd", ""));
        setPost3PodCd(JSPUtil.getParameter(request, prefix + "post_3_pod_cd", ""));
        setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
        setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
        setConsignee(JSPUtil.getParameter(request, prefix + "consignee", ""));
        setFdGrdFlg(JSPUtil.getParameter(request, prefix + "fd_grd_flg", ""));
        setAesNo(JSPUtil.getParameter(request, prefix + "aes_no", ""));
        setBkgClzFlg(JSPUtil.getParameter(request, prefix + "bkg_clz_flg", ""));
        setCaedFlg(JSPUtil.getParameter(request, prefix + "caed_flg", ""));
        setContact(JSPUtil.getParameter(request, prefix + "contact", ""));
        setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setTotalWgt(JSPUtil.getParameter(request, prefix + "total_wgt", ""));
        setRdTotalP4(JSPUtil.getParameter(request, prefix + "rd_total_p4", ""));
        setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
        setRdTotalP2(JSPUtil.getParameter(request, prefix + "rd_total_p2", ""));
        setPre2PolCd(JSPUtil.getParameter(request, prefix + "pre_2_pol_cd", ""));
        setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
        setAntyName(JSPUtil.getParameter(request, prefix + "anty_name", ""));
        setTotalMea(JSPUtil.getParameter(request, prefix + "total_mea", ""));
        setShipper(JSPUtil.getParameter(request, prefix + "shipper", ""));
        setPre4PolCd(JSPUtil.getParameter(request, prefix + "pre_4_pol_cd", ""));
        setRemarkDetail(JSPUtil.getParameter(request, prefix + "remark_detail", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setRdTotalQ2(JSPUtil.getParameter(request, prefix + "rd_total_q2", ""));
        setLastOrderby(JSPUtil.getParameter(request, prefix + "last_orderby", ""));
        setRdTotalQ4(JSPUtil.getParameter(request, prefix + "rd_total_q4", ""));
        setRep(JSPUtil.getParameter(request, prefix + "rep", ""));
        setNtfy(JSPUtil.getParameter(request, prefix + "ntfy", ""));
        setInterRemarkDetail(JSPUtil.getParameter(request, prefix + "inter_remark_detail", ""));
        setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
        setPre1Vvd(JSPUtil.getParameter(request, prefix + "pre_1_vvd", ""));
        setTotalBkg(JSPUtil.getParameter(request, prefix + "total_bkg", ""));
        setTel(JSPUtil.getParameter(request, prefix + "tel", ""));
        setCAddr(JSPUtil.getParameter(request, prefix + "c_addr", ""));
        setRdTotalF2(JSPUtil.getParameter(request, prefix + "rd_total_f2", ""));
        setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setPre4PodCd(JSPUtil.getParameter(request, prefix + "pre_4_pod_cd", ""));
        setPre3PolCd(JSPUtil.getParameter(request, prefix + "pre_3_pol_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setCurrPage(JSPUtil.getParameter(request, prefix + "curr_page", ""));
        setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
        setPost4Vvd(JSPUtil.getParameter(request, prefix + "post_4_vvd", ""));
        setPre1PodCd(JSPUtil.getParameter(request, prefix + "pre_1_pod_cd", ""));
        setPost1PodCd(JSPUtil.getParameter(request, prefix + "post_1_pod_cd", ""));
        setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
        setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
        setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
        setActCustName(JSPUtil.getParameter(request, prefix + "act_cust_name", ""));
        setTotalFeu(JSPUtil.getParameter(request, prefix + "total_feu", ""));
        setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
        setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
        setFnlDestCd(JSPUtil.getParameter(request, prefix + "fnl_dest_cd", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setRdTotalO2(JSPUtil.getParameter(request, prefix + "rd_total_o2", ""));
        setRdTotalO4(JSPUtil.getParameter(request, prefix + "rd_total_o4", ""));
        setPre3Vvd(JSPUtil.getParameter(request, prefix + "pre_3_vvd", ""));
        setRdTotalF4(JSPUtil.getParameter(request, prefix + "rd_total_f4", ""));
        setNtfyName(JSPUtil.getParameter(request, prefix + "ntfy_name", ""));
        setRdTotalF5(JSPUtil.getParameter(request, prefix + "rd_total_f5", ""));
        setTotalBl(JSPUtil.getParameter(request, prefix + "total_bl", ""));
        setPost3Vvd(JSPUtil.getParameter(request, prefix + "post_3_vvd", ""));
        setOrderby(JSPUtil.getParameter(request, prefix + "orderby", ""));
        setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setChgTermCd(JSPUtil.getParameter(request, prefix + "chg_term_cd", ""));
        setShprName(JSPUtil.getParameter(request, prefix + "shpr_name", ""));
        setOrgTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "org_trns_svc_mod_cd", ""));
        setDocUsrId(JSPUtil.getParameter(request, prefix + "doc_usr_id", ""));
        setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
        setEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", ""));
        setTrunkVvd(JSPUtil.getParameter(request, prefix + "trunk_vvd", ""));
        setItnType(JSPUtil.getParameter(request, prefix + "itn_type", ""));
        setEqSubstFlg(JSPUtil.getParameter(request, prefix + "eq_subst_flg", ""));
        setHotDeFlg(JSPUtil.getParameter(request, prefix + "hot_de_flg", ""));
        setBkgMeaQty(JSPUtil.getParameter(request, prefix + "bkg_mea_qty", ""));
        setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
        setRateChkSts(JSPUtil.getParameter(request, prefix + "rate_chk_sts", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
        setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
        setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
        setExptName(JSPUtil.getParameter(request, prefix + "expt_name", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setPre2Vvd(JSPUtil.getParameter(request, prefix + "pre_2_vvd", ""));
        setOrderbyTitle(JSPUtil.getParameter(request, prefix + "orderby_title", ""));
        setFfdr(JSPUtil.getParameter(request, prefix + "ffdr", ""));
        setShpCallNo(JSPUtil.getParameter(request, prefix + "shp_call_no", ""));
        setCntcPsonEml(JSPUtil.getParameter(request, prefix + "cntc_pson_eml", ""));
        setExterRemark(JSPUtil.getParameter(request, prefix + "exter_remark", ""));
        setNAddr(JSPUtil.getParameter(request, prefix + "n_addr", ""));
        setRdTotalT2(JSPUtil.getParameter(request, prefix + "rd_total_t2", ""));
        setRdTotalT4(JSPUtil.getParameter(request, prefix + "rd_total_t4", ""));
        setPre2PodCd(JSPUtil.getParameter(request, prefix + "pre_2_pod_cd", ""));
        setPost2PodCd(JSPUtil.getParameter(request, prefix + "post_2_pod_cd", ""));
        setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
        setRdTotalD4(JSPUtil.getParameter(request, prefix + "rd_total_d4", ""));
        setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
        setRdTotalD5(JSPUtil.getParameter(request, prefix + "rd_total_d5", ""));
        setCaedType(JSPUtil.getParameter(request, prefix + "caed_type", ""));
        setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
        setPre1PolCd(JSPUtil.getParameter(request, prefix + "pre_1_pol_cd", ""));
        setRdTotalD2(JSPUtil.getParameter(request, prefix + "rd_total_d2", ""));
        setPost2Vvd(JSPUtil.getParameter(request, prefix + "post_2_vvd", ""));
        setCommodity(JSPUtil.getParameter(request, prefix + "commodity", ""));
        setCneeName(JSPUtil.getParameter(request, prefix + "cnee_name", ""));
        setPre4Vvd(JSPUtil.getParameter(request, prefix + "pre_4_vvd", ""));
        setRdTotalD7(JSPUtil.getParameter(request, prefix + "rd_total_d7", ""));
        setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
        setOrderbyCnt(JSPUtil.getParameter(request, prefix + "orderby_cnt", ""));
        setFfdrName(JSPUtil.getParameter(request, prefix + "ffdr_name", ""));
        setChgInterRemark(JSPUtil.getParameter(request, prefix + "chg_inter_remark", ""));
        setChgInterRemarkDetail(JSPUtil.getParameter(request, prefix + "chg_inter_remark_detail", ""));
        setChgXterRemark(JSPUtil.getParameter(request, prefix + "chg_xter_remark", ""));
        setChgXterRemarkDetail(JSPUtil.getParameter(request, prefix + "chg_xter_remark_detail", ""));
        setRdTotalO5(JSPUtil.getParameter(request, prefix + "rd_total_o5", ""));
        setOfcTeamCd(JSPUtil.getParameter(request, prefix + "ofc_team_cd", ""));
        setSailDt(JSPUtil.getParameter(request, prefix + "sail_dt", ""));
        setAlocStsCd(JSPUtil.getParameter(request, prefix + "aloc_sts_cd", ""));
        setSiCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "si_cntc_pson_phn_no", ""));
        setSiCntcPsonEml(JSPUtil.getParameter(request, prefix + "si_cntc_pson_eml", ""));
        setNonRtStsCd(JSPUtil.getParameter(request, prefix + "non_rt_sts_cd", ""));
        setEtbDt(JSPUtil.getParameter(request, prefix + "etb_dt", ""));
        setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
        setPreContrat(JSPUtil.getParameter(request, prefix + "pre_contrat", ""));
        setNowContrat(JSPUtil.getParameter(request, prefix + "now_contrat", ""));
        setRtroKndCdNm(JSPUtil.getParameter(request, prefix + "rtro_knd_cd_nm", ""));
        setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
        setActivityTeu(JSPUtil.getParameter(request, prefix + "activity_teu", ""));
        setActivityFeu(JSPUtil.getParameter(request, prefix + "activity_feu", ""));
        setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
        setMtyPkupDt(JSPUtil.getParameter(request, prefix + "mty_pkup_dt", ""));
        setDgCmdtDesc(JSPUtil.getParameter(request, prefix + "dg_cmdt_desc", ""));
        setACmdtDesc(JSPUtil.getParameter(request, prefix + "a_cmdt_desc", ""));
        setBCmdtDesc(JSPUtil.getParameter(request, prefix + "b_cmdt_desc", ""));
        setRdTotalO7(JSPUtil.getParameter(request, prefix + "rd_total_o7", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StatusReportOutVO[]
	 */
    public StatusReportOutVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StatusReportOutVO[]
	 */
    public StatusReportOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        StatusReportOutVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] actCustCode = (JSPUtil.getParameter(request, prefix + "act_cust_code", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] obSrepCd = (JSPUtil.getParameter(request, prefix + "ob_srep_cd", length));
            String[] rowsPerPage = (JSPUtil.getParameter(request, prefix + "rows_per_page", length));
            String[] destTrnsSvcModCd = (JSPUtil.getParameter(request, prefix + "dest_trns_svc_mod_cd", length));
            String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", length));
            String[] rdTotalR9 = (JSPUtil.getParameter(request, prefix + "rd_total_r9", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] bkgCreDt = (JSPUtil.getParameter(request, prefix + "bkg_cre_dt", length));
            String[] stwgCd = (JSPUtil.getParameter(request, prefix + "stwg_cd", length));
            String[] rdTotalR4 = (JSPUtil.getParameter(request, prefix + "rd_total_r4", length));
            String[] rdTotalR5 = (JSPUtil.getParameter(request, prefix + "rd_total_r5", length));
            String[] siFlg = (JSPUtil.getParameter(request, prefix + "si_flg", length));
            String[] rdTotalR2 = (JSPUtil.getParameter(request, prefix + "rd_total_r2", length));
            String[] totalCnt = (JSPUtil.getParameter(request, prefix + "total_cnt", length));
            String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", length));
            String[] feu = (JSPUtil.getParameter(request, prefix + "feu", length));
            String[] orderbyTitleSql = (JSPUtil.getParameter(request, prefix + "orderby_title_sql", length));
            String[] interRemark = (JSPUtil.getParameter(request, prefix + "inter_remark", length));
            String[] bkgCtrlOfcCd = (JSPUtil.getParameter(request, prefix + "bkg_ctrl_ofc_cd", length));
            String[] caedNo = (JSPUtil.getParameter(request, prefix + "caed_no", length));
            String[] sAddr = (JSPUtil.getParameter(request, prefix + "s_addr", length));
            String[] post1Vvd = (JSPUtil.getParameter(request, prefix + "post_1_vvd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] rdTotalZ2 = (JSPUtil.getParameter(request, prefix + "rd_total_z2", length));
            String[] trunkPod = (JSPUtil.getParameter(request, prefix + "trunk_pod", length));
            String[] rdTotalZ4 = (JSPUtil.getParameter(request, prefix + "rd_total_z4", length));
            String[] ctrtSrepCd = (JSPUtil.getParameter(request, prefix + "ctrt_srep_cd", length));
            String[] actualPod = (JSPUtil.getParameter(request, prefix + "actual_pod", length));
            String[] pc = (JSPUtil.getParameter(request, prefix + "pc", length));
            String[] rcFlg = (JSPUtil.getParameter(request, prefix + "rc_flg", length));
            String[] trunkPol = (JSPUtil.getParameter(request, prefix + "trunk_pol", length));
            String[] itnFlg = (JSPUtil.getParameter(request, prefix + "itn_flg", length));
            String[] actualPol = (JSPUtil.getParameter(request, prefix + "actual_pol", length));
            String[] totalTeu = (JSPUtil.getParameter(request, prefix + "total_teu", length));
            String[] bkgActwgtQty = (JSPUtil.getParameter(request, prefix + "bkg_actwgt_qty", length));
            String[] pre3PodCd = (JSPUtil.getParameter(request, prefix + "pre_3_pod_cd", length));
            String[] post3PodCd = (JSPUtil.getParameter(request, prefix + "post_3_pod_cd", length));
            String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix + "rd_cgo_flg", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] consignee = (JSPUtil.getParameter(request, prefix + "consignee", length));
            String[] fdGrdFlg = (JSPUtil.getParameter(request, prefix + "fd_grd_flg", length));
            String[] aesNo = (JSPUtil.getParameter(request, prefix + "aes_no", length));
            String[] bkgClzFlg = (JSPUtil.getParameter(request, prefix + "bkg_clz_flg", length));
            String[] caedFlg = (JSPUtil.getParameter(request, prefix + "caed_flg", length));
            String[] contact = (JSPUtil.getParameter(request, prefix + "contact", length));
            String[] interRmk = (JSPUtil.getParameter(request, prefix + "inter_rmk", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] totalWgt = (JSPUtil.getParameter(request, prefix + "total_wgt", length));
            String[] rdTotalP4 = (JSPUtil.getParameter(request, prefix + "rd_total_p4", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] rdTotalP2 = (JSPUtil.getParameter(request, prefix + "rd_total_p2", length));
            String[] pre2PolCd = (JSPUtil.getParameter(request, prefix + "pre_2_pol_cd", length));
            String[] porNodCd = (JSPUtil.getParameter(request, prefix + "por_nod_cd", length));
            String[] antyName = (JSPUtil.getParameter(request, prefix + "anty_name", length));
            String[] totalMea = (JSPUtil.getParameter(request, prefix + "total_mea", length));
            String[] shipper = (JSPUtil.getParameter(request, prefix + "shipper", length));
            String[] pre4PolCd = (JSPUtil.getParameter(request, prefix + "pre_4_pol_cd", length));
            String[] remarkDetail = (JSPUtil.getParameter(request, prefix + "remark_detail", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] taaNo = (JSPUtil.getParameter(request, prefix + "taa_no", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] rdTotalQ2 = (JSPUtil.getParameter(request, prefix + "rd_total_q2", length));
            String[] lastOrderby = (JSPUtil.getParameter(request, prefix + "last_orderby", length));
            String[] rdTotalQ4 = (JSPUtil.getParameter(request, prefix + "rd_total_q4", length));
            String[] rep = (JSPUtil.getParameter(request, prefix + "rep", length));
            String[] ntfy = (JSPUtil.getParameter(request, prefix + "ntfy", length));
            String[] interRemarkDetail = (JSPUtil.getParameter(request, prefix + "inter_remark_detail", length));
            String[] remark = (JSPUtil.getParameter(request, prefix + "remark", length));
            String[] pre1Vvd = (JSPUtil.getParameter(request, prefix + "pre_1_vvd", length));
            String[] totalBkg = (JSPUtil.getParameter(request, prefix + "total_bkg", length));
            String[] tel = (JSPUtil.getParameter(request, prefix + "tel", length));
            String[] cAddr = (JSPUtil.getParameter(request, prefix + "c_addr", length));
            String[] rdTotalF2 = (JSPUtil.getParameter(request, prefix + "rd_total_f2", length));
            String[] blckStwgCd = (JSPUtil.getParameter(request, prefix + "blck_stwg_cd", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pre4PodCd = (JSPUtil.getParameter(request, prefix + "pre_4_pod_cd", length));
            String[] pre3PolCd = (JSPUtil.getParameter(request, prefix + "pre_3_pol_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] currPage = (JSPUtil.getParameter(request, prefix + "curr_page", length));
            String[] rnum = (JSPUtil.getParameter(request, prefix + "rnum", length));
            String[] post4Vvd = (JSPUtil.getParameter(request, prefix + "post_4_vvd", length));
            String[] pre1PodCd = (JSPUtil.getParameter(request, prefix + "pre_1_pod_cd", length));
            String[] post1PodCd = (JSPUtil.getParameter(request, prefix + "post_1_pod_cd", length));
            String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
            String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", length));
            String[] delNodCd = (JSPUtil.getParameter(request, prefix + "del_nod_cd", length));
            String[] actCustName = (JSPUtil.getParameter(request, prefix + "act_cust_name", length));
            String[] totalFeu = (JSPUtil.getParameter(request, prefix + "total_feu", length));
            String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg", length));
            String[] frtTermCd = (JSPUtil.getParameter(request, prefix + "frt_term_cd", length));
            String[] fnlDestCd = (JSPUtil.getParameter(request, prefix + "fnl_dest_cd", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] rdTotalO2 = (JSPUtil.getParameter(request, prefix + "rd_total_o2", length));
            String[] rdTotalO4 = (JSPUtil.getParameter(request, prefix + "rd_total_o4", length));
            String[] pre3Vvd = (JSPUtil.getParameter(request, prefix + "pre_3_vvd", length));
            String[] rdTotalF4 = (JSPUtil.getParameter(request, prefix + "rd_total_f4", length));
            String[] ntfyName = (JSPUtil.getParameter(request, prefix + "ntfy_name", length));
            String[] rdTotalF5 = (JSPUtil.getParameter(request, prefix + "rd_total_f5", length));
            String[] totalBl = (JSPUtil.getParameter(request, prefix + "total_bl", length));
            String[] post3Vvd = (JSPUtil.getParameter(request, prefix + "post_3_vvd", length));
            String[] orderby = (JSPUtil.getParameter(request, prefix + "orderby", length));
            String[] teu = (JSPUtil.getParameter(request, prefix + "teu", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] chgTermCd = (JSPUtil.getParameter(request, prefix + "chg_term_cd", length));
            String[] shprName = (JSPUtil.getParameter(request, prefix + "shpr_name", length));
            String[] orgTrnsSvcModCd = (JSPUtil.getParameter(request, prefix + "org_trns_svc_mod_cd", length));
            String[] docUsrId = (JSPUtil.getParameter(request, prefix + "doc_usr_id", length));
            String[] bdrFlg = (JSPUtil.getParameter(request, prefix + "bdr_flg", length));
            String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", length));
            String[] trunkVvd = (JSPUtil.getParameter(request, prefix + "trunk_vvd", length));
            String[] itnType = (JSPUtil.getParameter(request, prefix + "itn_type", length));
            String[] eqSubstFlg = (JSPUtil.getParameter(request, prefix + "eq_subst_flg", length));
            String[] hotDeFlg = (JSPUtil.getParameter(request, prefix + "hot_de_flg", length));
            String[] bkgMeaQty = (JSPUtil.getParameter(request, prefix + "bkg_mea_qty", length));
            String[] rfaNo = (JSPUtil.getParameter(request, prefix + "rfa_no", length));
            String[] rateChkSts = (JSPUtil.getParameter(request, prefix + "rate_chk_sts", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] cstmsDesc = (JSPUtil.getParameter(request, prefix + "cstms_desc", length));
            String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix + "bb_cgo_flg", length));
            String[] dcgoFlg = (JSPUtil.getParameter(request, prefix + "dcgo_flg", length));
            String[] exptName = (JSPUtil.getParameter(request, prefix + "expt_name", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] pre2Vvd = (JSPUtil.getParameter(request, prefix + "pre_2_vvd", length));
            String[] orderbyTitle = (JSPUtil.getParameter(request, prefix + "orderby_title", length));
            String[] ffdr = (JSPUtil.getParameter(request, prefix + "ffdr", length));
            String[] shpCallNo = (JSPUtil.getParameter(request, prefix + "shp_call_no", length));
            String[] cntcPsonEml = (JSPUtil.getParameter(request, prefix + "cntc_pson_eml", length));
            String[] exterRemark = (JSPUtil.getParameter(request, prefix + "exter_remark", length));
            String[] nAddr = (JSPUtil.getParameter(request, prefix + "n_addr", length));
            String[] rdTotalT2 = (JSPUtil.getParameter(request, prefix + "rd_total_t2", length));
            String[] rdTotalT4 = (JSPUtil.getParameter(request, prefix + "rd_total_t4", length));
            String[] pre2PodCd = (JSPUtil.getParameter(request, prefix + "pre_2_pod_cd", length));
            String[] post2PodCd = (JSPUtil.getParameter(request, prefix + "post_2_pod_cd", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] rdTotalD4 = (JSPUtil.getParameter(request, prefix + "rd_total_d4", length));
            String[] socFlg = (JSPUtil.getParameter(request, prefix + "soc_flg", length));
            String[] rdTotalD5 = (JSPUtil.getParameter(request, prefix + "rd_total_d5", length));
            String[] caedType = (JSPUtil.getParameter(request, prefix + "caed_type", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] pre1PolCd = (JSPUtil.getParameter(request, prefix + "pre_1_pol_cd", length));
            String[] rdTotalD2 = (JSPUtil.getParameter(request, prefix + "rd_total_d2", length));
            String[] post2Vvd = (JSPUtil.getParameter(request, prefix + "post_2_vvd", length));
            String[] commodity = (JSPUtil.getParameter(request, prefix + "commodity", length));
            String[] cneeName = (JSPUtil.getParameter(request, prefix + "cnee_name", length));
            String[] pre4Vvd = (JSPUtil.getParameter(request, prefix + "pre_4_vvd", length));
            String[] rdTotalD7 = (JSPUtil.getParameter(request, prefix + "rd_total_d7", length));
            String[] hngrFlg = (JSPUtil.getParameter(request, prefix + "hngr_flg", length));
            String[] orderbyCnt = (JSPUtil.getParameter(request, prefix + "orderby_cnt", length));
            String[] ffdrName = (JSPUtil.getParameter(request, prefix + "ffdr_name", length));
            String[] chgInterRemark = (JSPUtil.getParameter(request, prefix + "chg_inter_remark", length));
            String[] chgInterRemarkDetail = (JSPUtil.getParameter(request, prefix + "chg_inter_remark_detail", length));
            String[] chgXterRemark = (JSPUtil.getParameter(request, prefix + "chg_Xter_remark", length));
            String[] chgXterRemarkDetail = (JSPUtil.getParameter(request, prefix + "chg_Xter_remark_detail", length));
            String[] rdTotalO5 = (JSPUtil.getParameter(request, prefix + "rd_total_o5", length));
            String[] ofcTeamCd = (JSPUtil.getParameter(request, prefix + "ofc_team_cd", length));
            String[] sailDt = (JSPUtil.getParameter(request, prefix + "sail_dt", length));
            String[] alocStsCd = (JSPUtil.getParameter(request, prefix + "aloc_sts_cd", length));
            String[] siCntcPsonPhnNo = (JSPUtil.getParameter(request, prefix + "si_cntc_pson_phn_no", length));
            String[] siCntcPsonEml = (JSPUtil.getParameter(request, prefix + "si_cntc_pson_eml", length));
            String[] nonRtStsCd = (JSPUtil.getParameter(request, prefix + "non_rt_sts_cd", length));
            String[] etbDt = (JSPUtil.getParameter(request, prefix + "etb_dt", length));
            String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd", length));
            String[] preContrat = (JSPUtil.getParameter(request, prefix + "pre_contrat", length));
            String[] nowContrat = (JSPUtil.getParameter(request, prefix + "now_contrat", length));
            String[] rtroKndCdNm = (JSPUtil.getParameter(request, prefix + "rtro_knd_cd_nm", length));
            String[] costWk = (JSPUtil.getParameter(request, prefix + "cost_wk", length));
            String[] activityTeu = (JSPUtil.getParameter(request, prefix + "activity_teu", length));
            String[] activityFeu = (JSPUtil.getParameter(request, prefix + "activity_feu", length));
            String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", length));
            String[] mtyPkupDt = (JSPUtil.getParameter(request, prefix + "mty_pkup_dt", length));
            String[] dgCmdtDesc = (JSPUtil.getParameter(request, prefix + "dg_cmdt_desc", length));
            String[] aCmdtDesc = (JSPUtil.getParameter(request, prefix + "a_cmdt_desc", length));
            String[] bCmdtDesc = (JSPUtil.getParameter(request, prefix + "b_cmdt_desc", length));
            String[] rdTotalO7 = (JSPUtil.getParameter(request, prefix + "rd_total_o7", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new StatusReportOutVO();
                if (actCustCode[i] != null)
                    model.setActCustCode(actCustCode[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (obSrepCd[i] != null)
                    model.setObSrepCd(obSrepCd[i]);
                if (rowsPerPage[i] != null)
                    model.setRowsPerPage(rowsPerPage[i]);
                if (destTrnsSvcModCd[i] != null)
                    model.setDestTrnsSvcModCd(destTrnsSvcModCd[i]);
                if (ctrtOfcCd[i] != null)
                    model.setCtrtOfcCd(ctrtOfcCd[i]);
                if (rdTotalR9[i] != null)
                    model.setRdTotalR9(rdTotalR9[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (bkgCreDt[i] != null)
                    model.setBkgCreDt(bkgCreDt[i]);
                if (stwgCd[i] != null)
                    model.setStwgCd(stwgCd[i]);
                if (rdTotalR4[i] != null)
                    model.setRdTotalR4(rdTotalR4[i]);
                if (rdTotalR5[i] != null)
                    model.setRdTotalR5(rdTotalR5[i]);
                if (siFlg[i] != null)
                    model.setSiFlg(siFlg[i]);
                if (rdTotalR2[i] != null)
                    model.setRdTotalR2(rdTotalR2[i]);
                if (totalCnt[i] != null)
                    model.setTotalCnt(totalCnt[i]);
                if (bkgOfcCd[i] != null)
                    model.setBkgOfcCd(bkgOfcCd[i]);
                if (feu[i] != null)
                    model.setFeu(feu[i]);
                if (orderbyTitleSql[i] != null)
                    model.setOrderbyTitleSql(orderbyTitleSql[i]);
                if (interRemark[i] != null)
                    model.setInterRemark(interRemark[i]);
                if (bkgCtrlOfcCd[i] != null)
                    model.setBkgCtrlOfcCd(bkgCtrlOfcCd[i]);
                if (caedNo[i] != null)
                    model.setCaedNo(caedNo[i]);
                if (sAddr[i] != null)
                    model.setSAddr(sAddr[i]);
                if (post1Vvd[i] != null)
                    model.setPost1Vvd(post1Vvd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (rdTotalZ2[i] != null)
                    model.setRdTotalZ2(rdTotalZ2[i]);
                if (trunkPod[i] != null)
                    model.setTrunkPod(trunkPod[i]);
                if (rdTotalZ4[i] != null)
                    model.setRdTotalZ4(rdTotalZ4[i]);
                if (ctrtSrepCd[i] != null)
                    model.setCtrtSrepCd(ctrtSrepCd[i]);
                if (actualPod[i] != null)
                    model.setActualPod(actualPod[i]);
                if (pc[i] != null)
                    model.setPc(pc[i]);
                if (rcFlg[i] != null)
                    model.setRcFlg(rcFlg[i]);
                if (trunkPol[i] != null)
                    model.setTrunkPol(trunkPol[i]);
                if (itnFlg[i] != null)
                    model.setItnFlg(itnFlg[i]);
                if (actualPol[i] != null)
                    model.setActualPol(actualPol[i]);
                if (totalTeu[i] != null)
                    model.setTotalTeu(totalTeu[i]);
                if (bkgActwgtQty[i] != null)
                    model.setBkgActwgtQty(bkgActwgtQty[i]);
                if (pre3PodCd[i] != null)
                    model.setPre3PodCd(pre3PodCd[i]);
                if (post3PodCd[i] != null)
                    model.setPost3PodCd(post3PodCd[i]);
                if (rdCgoFlg[i] != null)
                    model.setRdCgoFlg(rdCgoFlg[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (consignee[i] != null)
                    model.setConsignee(consignee[i]);
                if (fdGrdFlg[i] != null)
                    model.setFdGrdFlg(fdGrdFlg[i]);
                if (aesNo[i] != null)
                    model.setAesNo(aesNo[i]);
                if (bkgClzFlg[i] != null)
                    model.setBkgClzFlg(bkgClzFlg[i]);
                if (caedFlg[i] != null)
                    model.setCaedFlg(caedFlg[i]);
                if (contact[i] != null)
                    model.setContact(contact[i]);
                if (interRmk[i] != null)
                    model.setInterRmk(interRmk[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (totalWgt[i] != null)
                    model.setTotalWgt(totalWgt[i]);
                if (rdTotalP4[i] != null)
                    model.setRdTotalP4(rdTotalP4[i]);
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (rdTotalP2[i] != null)
                    model.setRdTotalP2(rdTotalP2[i]);
                if (pre2PolCd[i] != null)
                    model.setPre2PolCd(pre2PolCd[i]);
                if (porNodCd[i] != null)
                    model.setPorNodCd(porNodCd[i]);
                if (antyName[i] != null)
                    model.setAntyName(antyName[i]);
                if (totalMea[i] != null)
                    model.setTotalMea(totalMea[i]);
                if (shipper[i] != null)
                    model.setShipper(shipper[i]);
                if (pre4PolCd[i] != null)
                    model.setPre4PolCd(pre4PolCd[i]);
                if (remarkDetail[i] != null)
                    model.setRemarkDetail(remarkDetail[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (taaNo[i] != null)
                    model.setTaaNo(taaNo[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (rdTotalQ2[i] != null)
                    model.setRdTotalQ2(rdTotalQ2[i]);
                if (lastOrderby[i] != null)
                    model.setLastOrderby(lastOrderby[i]);
                if (rdTotalQ4[i] != null)
                    model.setRdTotalQ4(rdTotalQ4[i]);
                if (rep[i] != null)
                    model.setRep(rep[i]);
                if (ntfy[i] != null)
                    model.setNtfy(ntfy[i]);
                if (interRemarkDetail[i] != null)
                    model.setInterRemarkDetail(interRemarkDetail[i]);
                if (remark[i] != null)
                    model.setRemark(remark[i]);
                if (pre1Vvd[i] != null)
                    model.setPre1Vvd(pre1Vvd[i]);
                if (totalBkg[i] != null)
                    model.setTotalBkg(totalBkg[i]);
                if (tel[i] != null)
                    model.setTel(tel[i]);
                if (cAddr[i] != null)
                    model.setCAddr(cAddr[i]);
                if (rdTotalF2[i] != null)
                    model.setRdTotalF2(rdTotalF2[i]);
                if (blckStwgCd[i] != null)
                    model.setBlckStwgCd(blckStwgCd[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pre4PodCd[i] != null)
                    model.setPre4PodCd(pre4PodCd[i]);
                if (pre3PolCd[i] != null)
                    model.setPre3PolCd(pre3PolCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (currPage[i] != null)
                    model.setCurrPage(currPage[i]);
                if (rnum[i] != null)
                    model.setRnum(rnum[i]);
                if (post4Vvd[i] != null)
                    model.setPost4Vvd(post4Vvd[i]);
                if (pre1PodCd[i] != null)
                    model.setPre1PodCd(pre1PodCd[i]);
                if (post1PodCd[i] != null)
                    model.setPost1PodCd(post1PodCd[i]);
                if (scNo[i] != null)
                    model.setScNo(scNo[i]);
                if (obSlsOfcCd[i] != null)
                    model.setObSlsOfcCd(obSlsOfcCd[i]);
                if (delNodCd[i] != null)
                    model.setDelNodCd(delNodCd[i]);
                if (actCustName[i] != null)
                    model.setActCustName(actCustName[i]);
                if (totalFeu[i] != null)
                    model.setTotalFeu(totalFeu[i]);
                if (awkCgoFlg[i] != null)
                    model.setAwkCgoFlg(awkCgoFlg[i]);
                if (frtTermCd[i] != null)
                    model.setFrtTermCd(frtTermCd[i]);
                if (fnlDestCd[i] != null)
                    model.setFnlDestCd(fnlDestCd[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (rdTotalO2[i] != null)
                    model.setRdTotalO2(rdTotalO2[i]);
                if (rdTotalO4[i] != null)
                    model.setRdTotalO4(rdTotalO4[i]);
                if (pre3Vvd[i] != null)
                    model.setPre3Vvd(pre3Vvd[i]);
                if (rdTotalF4[i] != null)
                    model.setRdTotalF4(rdTotalF4[i]);
                if (ntfyName[i] != null)
                    model.setNtfyName(ntfyName[i]);
                if (rdTotalF5[i] != null)
                    model.setRdTotalF5(rdTotalF5[i]);
                if (totalBl[i] != null)
                    model.setTotalBl(totalBl[i]);
                if (post3Vvd[i] != null)
                    model.setPost3Vvd(post3Vvd[i]);
                if (orderby[i] != null)
                    model.setOrderby(orderby[i]);
                if (teu[i] != null)
                    model.setTeu(teu[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (chgTermCd[i] != null)
                    model.setChgTermCd(chgTermCd[i]);
                if (shprName[i] != null)
                    model.setShprName(shprName[i]);
                if (orgTrnsSvcModCd[i] != null)
                    model.setOrgTrnsSvcModCd(orgTrnsSvcModCd[i]);
                if (docUsrId[i] != null)
                    model.setDocUsrId(docUsrId[i]);
                if (bdrFlg[i] != null)
                    model.setBdrFlg(bdrFlg[i]);
                if (eqCtrlOfcCd[i] != null)
                    model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
                if (trunkVvd[i] != null)
                    model.setTrunkVvd(trunkVvd[i]);
                if (itnType[i] != null)
                    model.setItnType(itnType[i]);
                if (eqSubstFlg[i] != null)
                    model.setEqSubstFlg(eqSubstFlg[i]);
                if (hotDeFlg[i] != null)
                    model.setHotDeFlg(hotDeFlg[i]);
                if (bkgMeaQty[i] != null)
                    model.setBkgMeaQty(bkgMeaQty[i]);
                if (rfaNo[i] != null)
                    model.setRfaNo(rfaNo[i]);
                if (rateChkSts[i] != null)
                    model.setRateChkSts(rateChkSts[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (cstmsDesc[i] != null)
                    model.setCstmsDesc(cstmsDesc[i]);
                if (bbCgoFlg[i] != null)
                    model.setBbCgoFlg(bbCgoFlg[i]);
                if (dcgoFlg[i] != null)
                    model.setDcgoFlg(dcgoFlg[i]);
                if (exptName[i] != null)
                    model.setExptName(exptName[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (pre2Vvd[i] != null)
                    model.setPre2Vvd(pre2Vvd[i]);
                if (orderbyTitle[i] != null)
                    model.setOrderbyTitle(orderbyTitle[i]);
                if (ffdr[i] != null)
                    model.setFfdr(ffdr[i]);
                if (shpCallNo[i] != null)
                    model.setShpCallNo(shpCallNo[i]);
                if (cntcPsonEml[i] != null)
                    model.setCntcPsonEml(cntcPsonEml[i]);
                if (exterRemark[i] != null)
                    model.setExterRemark(exterRemark[i]);
                if (nAddr[i] != null)
                    model.setNAddr(nAddr[i]);
                if (rdTotalT2[i] != null)
                    model.setRdTotalT2(rdTotalT2[i]);
                if (rdTotalT4[i] != null)
                    model.setRdTotalT4(rdTotalT4[i]);
                if (pre2PodCd[i] != null)
                    model.setPre2PodCd(pre2PodCd[i]);
                if (post2PodCd[i] != null)
                    model.setPost2PodCd(post2PodCd[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (rdTotalD4[i] != null)
                    model.setRdTotalD4(rdTotalD4[i]);
                if (socFlg[i] != null)
                    model.setSocFlg(socFlg[i]);
                if (rdTotalD5[i] != null)
                    model.setRdTotalD5(rdTotalD5[i]);
                if (caedType[i] != null)
                    model.setCaedType(caedType[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (pre1PolCd[i] != null)
                    model.setPre1PolCd(pre1PolCd[i]);
                if (rdTotalD2[i] != null)
                    model.setRdTotalD2(rdTotalD2[i]);
                if (post2Vvd[i] != null)
                    model.setPost2Vvd(post2Vvd[i]);
                if (commodity[i] != null)
                    model.setCommodity(commodity[i]);
                if (cneeName[i] != null)
                    model.setCneeName(cneeName[i]);
                if (pre4Vvd[i] != null)
                    model.setPre4Vvd(pre4Vvd[i]);
                if (rdTotalD7[i] != null)
                    model.setRdTotalD7(rdTotalD7[i]);
                if (hngrFlg[i] != null)
                    model.setHngrFlg(hngrFlg[i]);
                if (orderbyCnt[i] != null)
                    model.setOrderbyCnt(orderbyCnt[i]);
                if (ffdrName[i] != null)
                    model.setFfdrName(ffdrName[i]);
                if (chgInterRemark[i] != null)
                    model.setChgInterRemark(chgInterRemark[i]);
                if (chgInterRemarkDetail[i] != null)
                    model.setChgInterRemarkDetail(chgInterRemarkDetail[i]);
                if (chgXterRemark[i] != null)
                    model.setChgXterRemark(chgXterRemark[i]);
                if (chgXterRemarkDetail[i] != null)
                    model.setChgXterRemarkDetail(chgXterRemarkDetail[i]);
                if (rdTotalO5[i] != null)
                    model.setRdTotalO5(rdTotalO5[i]);
                if (ofcTeamCd[i] != null)
                    model.setOfcTeamCd(ofcTeamCd[i]);
                if (sailDt[i] != null)
                    model.setSailDt(sailDt[i]);
                if (alocStsCd[i] != null)
                    model.setAlocStsCd(alocStsCd[i]);
                if (siCntcPsonPhnNo[i] != null)
                    model.setSiCntcPsonPhnNo(siCntcPsonPhnNo[i]);
                if (siCntcPsonEml[i] != null)
                    model.setSiCntcPsonEml(siCntcPsonEml[i]);
                if (nonRtStsCd[i] != null)
                    model.setNonRtStsCd(nonRtStsCd[i]);
                if (etbDt[i] != null)
                    model.setEtbDt(etbDt[i]);
                if (svcScpCd[i] != null)
                    model.setSvcScpCd(svcScpCd[i]);
                if (preContrat[i] != null)
                    model.setPreContrat(preContrat[i]);
                if (nowContrat[i] != null)
                    model.setNowContrat(nowContrat[i]);
                if (rtroKndCdNm[i] != null)
                    model.setRtroKndCdNm(rtroKndCdNm[i]);
                if (costWk[i] != null)
                    model.setCostWk(costWk[i]);
                if (activityTeu[i] != null)
                    model.setActivityTeu(activityTeu[i]);
                if (activityFeu[i] != null)
                    model.setActivityFeu(activityFeu[i]);
                if (mtyPkupYdCd[i] != null)
                    model.setMtyPkupYdCd(mtyPkupYdCd[i]);
                if (mtyPkupDt[i] != null)
                    model.setMtyPkupDt(mtyPkupDt[i]);
                if (dgCmdtDesc[i] != null)
                    model.setDgCmdtDesc(dgCmdtDesc[i]);
                if (aCmdtDesc[i] != null)
                    model.setACmdtDesc(aCmdtDesc[i]);
                if (bCmdtDesc[i] != null)
                    model.setBCmdtDesc(bCmdtDesc[i]);
                if (rdTotalO7[i] != null) 
		    		model.setRdTotalO7(rdTotalO7[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getStatusReportOutVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return StatusReportOutVO[]
	 */
    public StatusReportOutVO[] getStatusReportOutVOs() {
        StatusReportOutVO[] vos = (StatusReportOutVO[]) models.toArray(new StatusReportOutVO[models.size()]);
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
        this.actCustCode = this.actCustCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obSrepCd = this.obSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowsPerPage = this.rowsPerPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.destTrnsSvcModCd = this.destTrnsSvcModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtOfcCd = this.ctrtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalR9 = this.rdTotalR9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCreDt = this.bkgCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgCd = this.stwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalR4 = this.rdTotalR4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalR5 = this.rdTotalR5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siFlg = this.siFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalR2 = this.rdTotalR2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalCnt = this.totalCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgOfcCd = this.bkgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.feu = this.feu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orderbyTitleSql = this.orderbyTitleSql.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.interRemark = this.interRemark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCtrlOfcCd = this.bkgCtrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caedNo = this.caedNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sAddr = this.sAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post1Vvd = this.post1Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalZ2 = this.rdTotalZ2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trunkPod = this.trunkPod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalZ4 = this.rdTotalZ4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtSrepCd = this.ctrtSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actualPod = this.actualPod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pc = this.pc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trunkPol = this.trunkPol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.itnFlg = this.itnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actualPol = this.actualPol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalTeu = this.totalTeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgActwgtQty = this.bkgActwgtQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre3PodCd = this.pre3PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post3PodCd = this.post3PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCgoFlg = this.rdCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.consignee = this.consignee.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fdGrdFlg = this.fdGrdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aesNo = this.aesNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgClzFlg = this.bkgClzFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caedFlg = this.caedFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.contact = this.contact.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.interRmk = this.interRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalWgt = this.totalWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalP4 = this.rdTotalP4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalP2 = this.rdTotalP2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre2PolCd = this.pre2PolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porNodCd = this.porNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.antyName = this.antyName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalMea = this.totalMea.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shipper = this.shipper.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre4PolCd = this.pre4PolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.remarkDetail = this.remarkDetail.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taaNo = this.taaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalQ2 = this.rdTotalQ2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lastOrderby = this.lastOrderby.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalQ4 = this.rdTotalQ4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rep = this.rep.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfy = this.ntfy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.interRemarkDetail = this.interRemarkDetail.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.remark = this.remark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre1Vvd = this.pre1Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalBkg = this.totalBkg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tel = this.tel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cAddr = this.cAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalF2 = this.rdTotalF2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blckStwgCd = this.blckStwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre4PodCd = this.pre4PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre3PolCd = this.pre3PolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currPage = this.currPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rnum = this.rnum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post4Vvd = this.post4Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre1PodCd = this.pre1PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post1PodCd = this.post1PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obSlsOfcCd = this.obSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delNodCd = this.delNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actCustName = this.actCustName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalFeu = this.totalFeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtTermCd = this.frtTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlDestCd = this.fnlDestCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalO2 = this.rdTotalO2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalO4 = this.rdTotalO4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre3Vvd = this.pre3Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalF4 = this.rdTotalF4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyName = this.ntfyName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalF5 = this.rdTotalF5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalBl = this.totalBl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post3Vvd = this.post3Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orderby = this.orderby.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.teu = this.teu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgTermCd = this.chgTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprName = this.shprName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgTrnsSvcModCd = this.orgTrnsSvcModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docUsrId = this.docUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdrFlg = this.bdrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqCtrlOfcCd = this.eqCtrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trunkVvd = this.trunkVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.itnType = this.itnType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSubstFlg = this.eqSubstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hotDeFlg = this.hotDeFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgMeaQty = this.bkgMeaQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rateChkSts = this.rateChkSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsDesc = this.cstmsDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoFlg = this.bbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoFlg = this.dcgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.exptName = this.exptName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre2Vvd = this.pre2Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orderbyTitle = this.orderbyTitle.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffdr = this.ffdr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpCallNo = this.shpCallNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcPsonEml = this.cntcPsonEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.exterRemark = this.exterRemark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nAddr = this.nAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalT2 = this.rdTotalT2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalT4 = this.rdTotalT4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre2PodCd = this.pre2PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post2PodCd = this.post2PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalD4 = this.rdTotalD4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.socFlg = this.socFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalD5 = this.rdTotalD5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caedType = this.caedType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre1PolCd = this.pre1PolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalD2 = this.rdTotalD2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post2Vvd = this.post2Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.commodity = this.commodity.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeName = this.cneeName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre4Vvd = this.pre4Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalD7 = this.rdTotalD7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hngrFlg = this.hngrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orderbyCnt = this.orderbyCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffdrName = this.ffdrName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgInterRemark = this.chgInterRemark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgInterRemarkDetail = this.chgInterRemarkDetail.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgInterRemark = this.chgInterRemark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgInterRemarkDetail = this.chgInterRemarkDetail.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalO5 = this.rdTotalO5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcTeamCd = this.ofcTeamCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sailDt = this.sailDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.alocStsCd = this.alocStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siCntcPsonPhnNo = this.siCntcPsonPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siCntcPsonEml = this.siCntcPsonEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nonRtStsCd = this.nonRtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etbDt = this.etbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preContrat = this.preContrat.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nowContrat = this.nowContrat.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtroKndCdNm = this.rtroKndCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costWk = this.costWk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.activityTeu = this.activityTeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.activityFeu = this.activityFeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupYdCd = this.mtyPkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupDt = this.mtyPkupDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgCmdtDesc = this.dgCmdtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aCmdtDesc = this.aCmdtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bCmdtDesc = this.bCmdtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalO7 = this.rdTotalO7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
