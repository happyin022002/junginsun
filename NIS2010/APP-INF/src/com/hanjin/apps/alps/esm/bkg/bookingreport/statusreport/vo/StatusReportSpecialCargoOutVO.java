/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : StatusReportSpecialCargoOutVO.java
*@FileTitle : StatusReportSpecialCargoOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.13
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.04.13 박만건 
* 1.0 Creation
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
public class StatusReportSpecialCargoOutVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<StatusReportSpecialCargoOutVO> models = new ArrayList<StatusReportSpecialCargoOutVO>();

    /* Column Info */
    private String destSvcRoute = null;

    /* Column Info */
    private String p4 = null;

    /* Column Info */
    private String p2 = null;

    /* Column Info */
    private String pwrSplCblFlg = null;

    /* Column Info */
    private String no = null;

    /* Column Info */
    private String spclCgoAuthKnt = null;

    /* Column Info */
    private String z4 = null;

    /* Column Info */
    private String z2 = null;

    /* Column Info */
    private String post3PolCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String obSrepCd = null;

    /* Column Info */
    private String rowsPerPage = null;

    /* Column Info */
    private String destTrnsSvcModCd = null;

    /* Column Info */
    private String dimWdt = null;

    /* Column Info */
    private String ctrlAtmsFlg = null;

    /* Column Info */
    private String rdTotalR9 = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String bkgCreDt = null;

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
    private String imdgUnNo = null;

    /* Column Info */
    private String bkgOfcCd = null;

    /* Column Info */
    private String feu = null;

    /* Column Info */
    private String q2 = null;

    /* Column Info */
    private String orderbyTitleSql = null;

    /* Column Info */
    private String q4 = null;

    /* Column Info */
    private String dimHgt = null;

    /* Column Info */
    private String post3PodCd = null;

    /* Column Info */
    private String post1PolCd = null;

    /* Column Info */
    private String post1Vvd = null;

    /* Column Info */
    private String ovrRtLen = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String rdTotalZ2 = null;

    /* Column Info */
    private String rowSeq = null;

    /* Column Info */
    private String rdTotalZ4 = null;

    /* Column Info */
    private String rcFlg = null;

    /* Column Info */
    private String ovrFwrdLen = null;

    /* Column Info */
    private String imdgClssCd = null;

    /* Column Info */
    private String totalTeu = null;

    /* Column Info */
    private String emerCntcPhnNoCtnt = null;

    /* Column Info */
    private String imdgPckGrpCd = null;

    /* Column Info */
    private String rdCgoFlg = null;

    /* Column Info */
    private String pre3PodCd = null;

    /* Column Info */
    private String flshPntCdoTemp = null;

    /* Column Info */
    private String consignee = null;

    /* Column Info */
    private String bkgClzFlg = null;

    /* Column Info */
    private String ovrVoidSltQty = null;

    /* Column Info */
    private String contact = null;

    /* Column Info */
    private String bkgStf = null;

    /* Column Info */
    private String spclCgoAproCd = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String totalWgt = null;

    /* Column Info */
    private String rdTotalP4 = null;

    /* Column Info */
    private String pckTpCd = null;

    /* Column Info */
    private String f2 = null;

    /* Column Info */
    private String f5 = null;

    /* Column Info */
    private String rdTotalP2 = null;

    /* Column Info */
    private String post2PodCd = null;

    /* Column Info */
    private String f4 = null;

    /* Column Info */
    private String dgCntrSeq = null;

    /* Column Info */
    private String pre2PolCd = null;

    /* Column Info */
    private String o2 = null;

    /* Column Info */
    private String o4 = null;

    /* Column Info */
    private String antyName = null;

    /* Column Info */
    private String totalMea = null;

    /* Column Info */
    private String shipper = null;

    /* Column Info */
    private String pre4PolCd = null;

    /* Column Info */
    private String fdoTemp = null;

    /* Column Info */
    private String ovrLfLen = null;

    /* Column Info */
    private String remarkDetail = null;

    /* Column Info */
    private String post4PolCd = null;

    /* Column Info */
    private String humidNo = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String bstFlg = null;

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
    private String humidCtrlFlg = null;

    /* Column Info */
    private String ntfy = null;

    /* Column Info */
    private String post1PodCd = null;

    /* Column Info */
    private String remark = null;

    /* Column Info */
    private String pre1Vvd = null;

    /* Column Info */
    private String totalBkg = null;

    /* Column Info */
    private String tel = null;

    /* Column Info */
    private String rdTotalF2 = null;

    /* Column Info */
    private String d5 = null;

    /* Column Info */
    private String d4 = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String pre4PodCd = null;

    /* Column Info */
    private String d7 = null;

    /* Column Info */
    private String pre3PolCd = null;

    /* Column Info */
    private String d2 = null;

    /* Column Info */
    private String ovrHgt = null;

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
    private String bbCmdt = null;

    /* Column Info */
    private String custToOrdFlg = null;

    /* Column Info */
    private String obSlsOfcCd = null;

    /* Column Info */
    private String post4PodCd = null;

    /* Column Info */
    private String cgoSeq = null;

    /* Column Info */
    private String totalFeu = null;

    /* Column Info */
    private String consigneeName = null;

    /* Column Info */
    private String awkCgoFlg = null;

    /* Column Info */
    private String netWgt = null;

    /* Column Info */
    private String pkg = null;

    /* Column Info */
    private String bkgCnt = null;

    /* Column Info */
    private String rdTotalO2 = null;

    /* Column Info */
    private String cntrVentTpCd = null;

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
    private String t4 = null;

    /* Column Info */
    private String totalBl = null;

    /* Column Info */
    private String post3Vvd = null;

    /* Column Info */
    private String rfCmdt = null;

    /* Column Info */
    private String orderby = null;

    /* Column Info */
    private String modiAtmsFlg = null;

    /* Column Info */
    private String teu = null;

    /* Column Info */
    private String cntrVolQty = null;

    /* Column Info */
    private String grsWgt = null;

    /* Column Info */
    private String splitFlg = null;

    /* Column Info */
    private String t2 = null;

    /* Column Info */
    private String shprName = null;

    /* Column Info */
    private String dgCmdt = null;

    /* Column Info */
    private String orgTrnsSvcModCd = null;

    /* Column Info */
    private String bdrFlg = null;

    /* Column Info */
    private String trunkVvd = null;

    /* Column Info */
    private String stowage = null;

    /* Column Info */
    private String hotDeFlg = null;

    /* Column Info */
    private String eqSubstFlg = null;

    /* Column Info */
    private String bkgMeaQty = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String dimLen = null;

    /* Column Info */
    private String bbCgoFlg = null;

    /* Column Info */
    private String dcgoFlg = null;

    /* Column Info */
    private String measQty = null;

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
    private String orgSvcRoute = null;

    /* Column Info */
    private String rdTotalT2 = null;

    /* Column Info */
    private String rdTotalT4 = null;

    /* Column Info */
    private String pre2PodCd = null;

    /* Column Info */
    private String rdTotalD4 = null;

    /* Column Info */
    private String socFlg = null;

    /* Column Info */
    private String rdTotalD5 = null;

    /* Column Info */
    private String deTermCd = null;

    /* Column Info */
    private String akrepCmdt = null;

    /* Column Info */
    private String pre1PolCd = null;

    /* Column Info */
    private String rdTotalD2 = null;

    /* Column Info */
    private String vltgNo = null;

    /* Column Info */
    private String post2Vvd = null;

    /* Column Info */
    private String cdoTemp = null;

    /* Column Info */
    private String commodity = null;

    /* Column Info */
    private String ovrBkwdLen = null;

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
    private String prpShpNm = null;

    /* Column Info */
    private String r2 = null;

    /* Column Info */
    private String post2PolCd = null;

    /* Column Info */
    private String blCnt = null;

    /* Column Info */
    private String r4 = null;

    /* Column Info */
    private String r5 = null;

    /* Column Info */
    private String o5 = null;

    /* Column Info */
    private String rdTotalO5 = null;

    /* Column Info */
    private String atfcAtmsFlg = null;

    /* Column Info */
    private String o7 = null;

    /* Column Info */
    private String rdTotalO7 = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public StatusReportSpecialCargoOutVO() {
    }

    public StatusReportSpecialCargoOutVO(String ibflag, String pagerows, String akrepCmdt, String antyName, String awkCgoFlg, String bbCgoFlg, String bbCmdt, String bdrFlg, String bkgClzFlg, String bkgCreDt, String bkgMeaQty, String bkgNo, String bkgOfcCd, String bkgStf, String blNo, String bstFlg, String cdoTemp, String cmdtCd, String cntrNo, String cntrTpszCd, String cntrVentTpCd, String commodity, String consignee, String consigneeName, String ctrlAtmsFlg, String custToOrdFlg, String dcgoFlg, String destSvcRoute, String destTrnsSvcModCd, String deTermCd, String dgCntrSeq, String dimHgt, String dimLen, String dimWdt, String emerCntcPhnNoCtnt, String eqSubstFlg, String exptName, String fdoTemp, String ffdr, String ffdrName, String flshPntCdoTemp, String grsWgt, String hngrFlg, String hotDeFlg, String humidCtrlFlg, String humidNo, String imdgClssCd, String imdgPckGrpCd, String imdgUnNo, String measQty, String modiAtmsFlg, String netWgt, String ntfy, String ntfyName, String obSlsOfcCd, String obSrepCd, String orgSvcRoute, String orgTrnsSvcModCd, String ovrBkwdLen, String ovrFwrdLen, String ovrHgt, String ovrLfLen, String ovrRtLen, String ovrVoidSltQty, String pckQty, String pckTpCd, String pkg, String podCd, String polCd, String post1PodCd, String post1PolCd, String post1Vvd, String post2PodCd, String post2PolCd, String post2Vvd, String post3PodCd, String post3PolCd, String post3Vvd, String post4PodCd, String post4PolCd, String post4Vvd, String pre1PodCd, String pre1PolCd, String pre1Vvd, String pre2PodCd, String pre2PolCd, String pre2Vvd, String pre3PodCd, String pre3PolCd, String pre3Vvd, String pre4PodCd, String pre4PolCd, String pre4Vvd, String prpShpNm, String pwrSplCblFlg, String rcvTermCd, String rcFlg, String rdCgoFlg, String remark, String remarkDetail, String rep, String rfCmdt, String shipper, String shprName, String siFlg, String slanCd, String socFlg, String spclCgoAproCd, String spclCgoAuthKnt, String splitFlg, String trunkVvd, String vltgNo, String orderbyTitleSql, String orderbyTitle, String totalCnt, String orderbyCnt, String lastOrderby, String orderby, String rowsPerPage, String currPage, String rnum, String contact, String tel, String totalBkg, String totalBl, String totalTeu, String totalFeu, String totalWgt, String totalMea, String rdTotalD2, String rdTotalQ4, String rdTotalD4, String rdTotalR2, String rdTotalD5, String rdTotalR4, String rdTotalD7, String rdTotalR5, String rdTotalF2, String rdTotalT2, String rdTotalF4, String rdTotalT4, String rdTotalF5, String rdTotalP2, String rdTotalO2, String rdTotalP4, String rdTotalO4, String rdTotalZ4, String rdTotalQ2, String rdTotalZ2, String rdTotalR9, String rdTotalO5, String d2, String q4, String d4, String r2, String d5, String r4, String d7, String r5, String f2, String t2, String f4, String t4, String f5, String p2, String o2, String p4, String o4, String z4, String q2, String z2, String o5, String teu, String feu, String bkgCnt, String blCnt, String no, String rowSeq, String cntrVolQty, String stowage, String cgoSeq, String dgCmdt, String atfcAtmsFlg, String o7, String rdTotalO7) {
        this.destSvcRoute = destSvcRoute;
        this.p4 = p4;
        this.p2 = p2;
        this.pwrSplCblFlg = pwrSplCblFlg;
        this.no = no;
        this.spclCgoAuthKnt = spclCgoAuthKnt;
        this.z4 = z4;
        this.z2 = z2;
        this.post3PolCd = post3PolCd;
        this.pagerows = pagerows;
        this.obSrepCd = obSrepCd;
        this.rowsPerPage = rowsPerPage;
        this.destTrnsSvcModCd = destTrnsSvcModCd;
        this.dimWdt = dimWdt;
        this.ctrlAtmsFlg = ctrlAtmsFlg;
        this.rdTotalR9 = rdTotalR9;
        this.cntrTpszCd = cntrTpszCd;
        this.bkgCreDt = bkgCreDt;
        this.rdTotalR4 = rdTotalR4;
        this.rdTotalR5 = rdTotalR5;
        this.siFlg = siFlg;
        this.rdTotalR2 = rdTotalR2;
        this.totalCnt = totalCnt;
        this.imdgUnNo = imdgUnNo;
        this.bkgOfcCd = bkgOfcCd;
        this.feu = feu;
        this.q2 = q2;
        this.orderbyTitleSql = orderbyTitleSql;
        this.q4 = q4;
        this.dimHgt = dimHgt;
        this.post3PodCd = post3PodCd;
        this.post1PolCd = post1PolCd;
        this.post1Vvd = post1Vvd;
        this.ovrRtLen = ovrRtLen;
        this.podCd = podCd;
        this.bkgNo = bkgNo;
        this.rdTotalZ2 = rdTotalZ2;
        this.rowSeq = rowSeq;
        this.rdTotalZ4 = rdTotalZ4;
        this.rcFlg = rcFlg;
        this.ovrFwrdLen = ovrFwrdLen;
        this.imdgClssCd = imdgClssCd;
        this.totalTeu = totalTeu;
        this.emerCntcPhnNoCtnt = emerCntcPhnNoCtnt;
        this.imdgPckGrpCd = imdgPckGrpCd;
        this.rdCgoFlg = rdCgoFlg;
        this.pre3PodCd = pre3PodCd;
        this.flshPntCdoTemp = flshPntCdoTemp;
        this.consignee = consignee;
        this.bkgClzFlg = bkgClzFlg;
        this.ovrVoidSltQty = ovrVoidSltQty;
        this.contact = contact;
        this.bkgStf = bkgStf;
        this.spclCgoAproCd = spclCgoAproCd;
        this.cmdtCd = cmdtCd;
        this.totalWgt = totalWgt;
        this.rdTotalP4 = rdTotalP4;
        this.pckTpCd = pckTpCd;
        this.f2 = f2;
        this.f5 = f5;
        this.rdTotalP2 = rdTotalP2;
        this.post2PodCd = post2PodCd;
        this.f4 = f4;
        this.dgCntrSeq = dgCntrSeq;
        this.pre2PolCd = pre2PolCd;
        this.o2 = o2;
        this.o4 = o4;
        this.antyName = antyName;
        this.totalMea = totalMea;
        this.shipper = shipper;
        this.pre4PolCd = pre4PolCd;
        this.fdoTemp = fdoTemp;
        this.ovrLfLen = ovrLfLen;
        this.remarkDetail = remarkDetail;
        this.post4PolCd = post4PolCd;
        this.humidNo = humidNo;
        this.slanCd = slanCd;
        this.bstFlg = bstFlg;
        this.cntrNo = cntrNo;
        this.rdTotalQ2 = rdTotalQ2;
        this.lastOrderby = lastOrderby;
        this.rdTotalQ4 = rdTotalQ4;
        this.rep = rep;
        this.humidCtrlFlg = humidCtrlFlg;
        this.ntfy = ntfy;
        this.post1PodCd = post1PodCd;
        this.remark = remark;
        this.pre1Vvd = pre1Vvd;
        this.totalBkg = totalBkg;
        this.tel = tel;
        this.rdTotalF2 = rdTotalF2;
        this.d5 = d5;
        this.d4 = d4;
        this.blNo = blNo;
        this.pre4PodCd = pre4PodCd;
        this.d7 = d7;
        this.pre3PolCd = pre3PolCd;
        this.d2 = d2;
        this.ovrHgt = ovrHgt;
        this.polCd = polCd;
        this.currPage = currPage;
        this.rnum = rnum;
        this.post4Vvd = post4Vvd;
        this.pre1PodCd = pre1PodCd;
        this.bbCmdt = bbCmdt;
        this.custToOrdFlg = custToOrdFlg;
        this.obSlsOfcCd = obSlsOfcCd;
        this.post4PodCd = post4PodCd;
        this.cgoSeq = cgoSeq;
        this.totalFeu = totalFeu;
        this.consigneeName = consigneeName;
        this.awkCgoFlg = awkCgoFlg;
        this.netWgt = netWgt;
        this.pkg = pkg;
        this.bkgCnt = bkgCnt;
        this.rdTotalO2 = rdTotalO2;
        this.cntrVentTpCd = cntrVentTpCd;
        this.rdTotalO4 = rdTotalO4;
        this.pre3Vvd = pre3Vvd;
        this.rdTotalF4 = rdTotalF4;
        this.ntfyName = ntfyName;
        this.rdTotalF5 = rdTotalF5;
        this.t4 = t4;
        this.totalBl = totalBl;
        this.post3Vvd = post3Vvd;
        this.rfCmdt = rfCmdt;
        this.orderby = orderby;
        this.modiAtmsFlg = modiAtmsFlg;
        this.teu = teu;
        this.cntrVolQty = cntrVolQty;
        this.grsWgt = grsWgt;
        this.splitFlg = splitFlg;
        this.t2 = t2;
        this.shprName = shprName;
        this.dgCmdt = dgCmdt;
        this.orgTrnsSvcModCd = orgTrnsSvcModCd;
        this.bdrFlg = bdrFlg;
        this.trunkVvd = trunkVvd;
        this.stowage = stowage;
        this.hotDeFlg = hotDeFlg;
        this.eqSubstFlg = eqSubstFlg;
        this.bkgMeaQty = bkgMeaQty;
        this.ibflag = ibflag;
        this.dimLen = dimLen;
        this.bbCgoFlg = bbCgoFlg;
        this.dcgoFlg = dcgoFlg;
        this.measQty = measQty;
        this.exptName = exptName;
        this.pckQty = pckQty;
        this.rcvTermCd = rcvTermCd;
        this.pre2Vvd = pre2Vvd;
        this.orderbyTitle = orderbyTitle;
        this.ffdr = ffdr;
        this.orgSvcRoute = orgSvcRoute;
        this.rdTotalT2 = rdTotalT2;
        this.rdTotalT4 = rdTotalT4;
        this.pre2PodCd = pre2PodCd;
        this.rdTotalD4 = rdTotalD4;
        this.socFlg = socFlg;
        this.rdTotalD5 = rdTotalD5;
        this.deTermCd = deTermCd;
        this.akrepCmdt = akrepCmdt;
        this.pre1PolCd = pre1PolCd;
        this.rdTotalD2 = rdTotalD2;
        this.vltgNo = vltgNo;
        this.post2Vvd = post2Vvd;
        this.cdoTemp = cdoTemp;
        this.commodity = commodity;
        this.ovrBkwdLen = ovrBkwdLen;
        this.pre4Vvd = pre4Vvd;
        this.rdTotalD7 = rdTotalD7;
        this.hngrFlg = hngrFlg;
        this.orderbyCnt = orderbyCnt;
        this.ffdrName = ffdrName;
        this.prpShpNm = prpShpNm;
        this.r2 = r2;
        this.post2PolCd = post2PolCd;
        this.blCnt = blCnt;
        this.r4 = r4;
        this.r5 = r5;
        this.o5 = o5;
        this.rdTotalO5 = rdTotalO5;
        this.atfcAtmsFlg = atfcAtmsFlg;
        this.o7 = o7;
        this.rdTotalO7 = rdTotalO7;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("dest_svc_route", getDestSvcRoute());
        this.hashColumns.put("p4", getP4());
        this.hashColumns.put("p2", getP2());
        this.hashColumns.put("pwr_spl_cbl_flg", getPwrSplCblFlg());
        this.hashColumns.put("no", getNo());
        this.hashColumns.put("spcl_cgo_auth_knt", getSpclCgoAuthKnt());
        this.hashColumns.put("z4", getZ4());
        this.hashColumns.put("z2", getZ2());
        this.hashColumns.put("post_3_pol_cd", getPost3PolCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ob_srep_cd", getObSrepCd());
        this.hashColumns.put("rows_per_page", getRowsPerPage());
        this.hashColumns.put("dest_trns_svc_mod_cd", getDestTrnsSvcModCd());
        this.hashColumns.put("dim_wdt", getDimWdt());
        this.hashColumns.put("ctrl_atms_flg", getCtrlAtmsFlg());
        this.hashColumns.put("rd_total_r9", getRdTotalR9());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
        this.hashColumns.put("rd_total_r4", getRdTotalR4());
        this.hashColumns.put("rd_total_r5", getRdTotalR5());
        this.hashColumns.put("si_flg", getSiFlg());
        this.hashColumns.put("rd_total_r2", getRdTotalR2());
        this.hashColumns.put("total_cnt", getTotalCnt());
        this.hashColumns.put("imdg_un_no", getImdgUnNo());
        this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
        this.hashColumns.put("feu", getFeu());
        this.hashColumns.put("q2", getQ2());
        this.hashColumns.put("orderby_title_sql", getOrderbyTitleSql());
        this.hashColumns.put("q4", getQ4());
        this.hashColumns.put("dim_hgt", getDimHgt());
        this.hashColumns.put("post_3_pod_cd", getPost3PodCd());
        this.hashColumns.put("post_1_pol_cd", getPost1PolCd());
        this.hashColumns.put("post_1_vvd", getPost1Vvd());
        this.hashColumns.put("ovr_rt_len", getOvrRtLen());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("rd_total_z2", getRdTotalZ2());
        this.hashColumns.put("row_seq", getRowSeq());
        this.hashColumns.put("rd_total_z4", getRdTotalZ4());
        this.hashColumns.put("rc_flg", getRcFlg());
        this.hashColumns.put("ovr_fwrd_len", getOvrFwrdLen());
        this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
        this.hashColumns.put("total_teu", getTotalTeu());
        this.hashColumns.put("emer_cntc_phn_no_ctnt", getEmerCntcPhnNoCtnt());
        this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
        this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
        this.hashColumns.put("pre_3_pod_cd", getPre3PodCd());
        this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
        this.hashColumns.put("consignee", getConsignee());
        this.hashColumns.put("bkg_clz_flg", getBkgClzFlg());
        this.hashColumns.put("ovr_void_slt_qty", getOvrVoidSltQty());
        this.hashColumns.put("contact", getContact());
        this.hashColumns.put("bkg_stf", getBkgStf());
        this.hashColumns.put("spcl_cgo_apro_cd", getSpclCgoAproCd());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("total_wgt", getTotalWgt());
        this.hashColumns.put("rd_total_p4", getRdTotalP4());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("f2", getF2());
        this.hashColumns.put("f5", getF5());
        this.hashColumns.put("rd_total_p2", getRdTotalP2());
        this.hashColumns.put("post_2_pod_cd", getPost2PodCd());
        this.hashColumns.put("f4", getF4());
        this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());
        this.hashColumns.put("pre_2_pol_cd", getPre2PolCd());
        this.hashColumns.put("o2", getO2());
        this.hashColumns.put("o4", getO4());
        this.hashColumns.put("anty_name", getAntyName());
        this.hashColumns.put("total_mea", getTotalMea());
        this.hashColumns.put("shipper", getShipper());
        this.hashColumns.put("pre_4_pol_cd", getPre4PolCd());
        this.hashColumns.put("fdo_temp", getFdoTemp());
        this.hashColumns.put("ovr_lf_len", getOvrLfLen());
        this.hashColumns.put("remark_detail", getRemarkDetail());
        this.hashColumns.put("post_4_pol_cd", getPost4PolCd());
        this.hashColumns.put("humid_no", getHumidNo());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("bst_flg", getBstFlg());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("rd_total_q2", getRdTotalQ2());
        this.hashColumns.put("last_orderby", getLastOrderby());
        this.hashColumns.put("rd_total_q4", getRdTotalQ4());
        this.hashColumns.put("rep", getRep());
        this.hashColumns.put("humid_ctrl_flg", getHumidCtrlFlg());
        this.hashColumns.put("ntfy", getNtfy());
        this.hashColumns.put("post_1_pod_cd", getPost1PodCd());
        this.hashColumns.put("remark", getRemark());
        this.hashColumns.put("pre_1_vvd", getPre1Vvd());
        this.hashColumns.put("total_bkg", getTotalBkg());
        this.hashColumns.put("tel", getTel());
        this.hashColumns.put("rd_total_f2", getRdTotalF2());
        this.hashColumns.put("d5", getD5());
        this.hashColumns.put("d4", getD4());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pre_4_pod_cd", getPre4PodCd());
        this.hashColumns.put("d7", getD7());
        this.hashColumns.put("pre_3_pol_cd", getPre3PolCd());
        this.hashColumns.put("d2", getD2());
        this.hashColumns.put("ovr_hgt", getOvrHgt());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("curr_page", getCurrPage());
        this.hashColumns.put("rnum", getRnum());
        this.hashColumns.put("post_4_vvd", getPost4Vvd());
        this.hashColumns.put("pre_1_pod_cd", getPre1PodCd());
        this.hashColumns.put("bb_cmdt", getBbCmdt());
        this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());
        this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
        this.hashColumns.put("post_4_pod_cd", getPost4PodCd());
        this.hashColumns.put("cgo_seq", getCgoSeq());
        this.hashColumns.put("total_feu", getTotalFeu());
        this.hashColumns.put("consignee_name", getConsigneeName());
        this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
        this.hashColumns.put("net_wgt", getNetWgt());
        this.hashColumns.put("pkg", getPkg());
        this.hashColumns.put("bkg_cnt", getBkgCnt());
        this.hashColumns.put("rd_total_o2", getRdTotalO2());
        this.hashColumns.put("cntr_vent_tp_cd", getCntrVentTpCd());
        this.hashColumns.put("rd_total_o4", getRdTotalO4());
        this.hashColumns.put("pre_3_vvd", getPre3Vvd());
        this.hashColumns.put("rd_total_f4", getRdTotalF4());
        this.hashColumns.put("ntfy_name", getNtfyName());
        this.hashColumns.put("rd_total_f5", getRdTotalF5());
        this.hashColumns.put("t4", getT4());
        this.hashColumns.put("total_bl", getTotalBl());
        this.hashColumns.put("post_3_vvd", getPost3Vvd());
        this.hashColumns.put("rf_cmdt", getRfCmdt());
        this.hashColumns.put("orderby", getOrderby());
        this.hashColumns.put("modi_atms_flg", getModiAtmsFlg());
        this.hashColumns.put("teu", getTeu());
        this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
        this.hashColumns.put("grs_wgt", getGrsWgt());
        this.hashColumns.put("split_flg", getSplitFlg());
        this.hashColumns.put("t2", getT2());
        this.hashColumns.put("shpr_name", getShprName());
        this.hashColumns.put("dg_cmdt", getDgCmdt());
        this.hashColumns.put("org_trns_svc_mod_cd", getOrgTrnsSvcModCd());
        this.hashColumns.put("bdr_flg", getBdrFlg());
        this.hashColumns.put("trunk_vvd", getTrunkVvd());
        this.hashColumns.put("stowage", getStowage());
        this.hashColumns.put("hot_de_flg", getHotDeFlg());
        this.hashColumns.put("eq_subst_flg", getEqSubstFlg());
        this.hashColumns.put("bkg_mea_qty", getBkgMeaQty());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("dim_len", getDimLen());
        this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
        this.hashColumns.put("dcgo_flg", getDcgoFlg());
        this.hashColumns.put("meas_qty", getMeasQty());
        this.hashColumns.put("expt_name", getExptName());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("pre_2_vvd", getPre2Vvd());
        this.hashColumns.put("orderby_title", getOrderbyTitle());
        this.hashColumns.put("ffdr", getFfdr());
        this.hashColumns.put("org_svc_route", getOrgSvcRoute());
        this.hashColumns.put("rd_total_t2", getRdTotalT2());
        this.hashColumns.put("rd_total_t4", getRdTotalT4());
        this.hashColumns.put("pre_2_pod_cd", getPre2PodCd());
        this.hashColumns.put("rd_total_d4", getRdTotalD4());
        this.hashColumns.put("soc_flg", getSocFlg());
        this.hashColumns.put("rd_total_d5", getRdTotalD5());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("akrep_cmdt", getAkrepCmdt());
        this.hashColumns.put("pre_1_pol_cd", getPre1PolCd());
        this.hashColumns.put("rd_total_d2", getRdTotalD2());
        this.hashColumns.put("vltg_no", getVltgNo());
        this.hashColumns.put("post_2_vvd", getPost2Vvd());
        this.hashColumns.put("cdo_temp", getCdoTemp());
        this.hashColumns.put("commodity", getCommodity());
        this.hashColumns.put("ovr_bkwd_len", getOvrBkwdLen());
        this.hashColumns.put("pre_4_vvd", getPre4Vvd());
        this.hashColumns.put("rd_total_d7", getRdTotalD7());
        this.hashColumns.put("hngr_flg", getHngrFlg());
        this.hashColumns.put("orderby_cnt", getOrderbyCnt());
        this.hashColumns.put("ffdr_name", getFfdrName());
        this.hashColumns.put("prp_shp_nm", getPrpShpNm());
        this.hashColumns.put("r2", getR2());
        this.hashColumns.put("post_2_pol_cd", getPost2PolCd());
        this.hashColumns.put("bl_cnt", getBlCnt());
        this.hashColumns.put("r4", getR4());
        this.hashColumns.put("r5", getR5());
        this.hashColumns.put("o5", getO5());
        this.hashColumns.put("rd_total_o5", getRdTotalO5());
        this.hashColumns.put("atfc_atms_flg", getAtfcAtmsFlg());
        this.hashColumns.put("o7", getO7());
        this.hashColumns.put("rd_total_o7", getRdTotalO7());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("dest_svc_route", "destSvcRoute");
        this.hashFields.put("p4", "p4");
        this.hashFields.put("p2", "p2");
        this.hashFields.put("pwr_spl_cbl_flg", "pwrSplCblFlg");
        this.hashFields.put("no", "no");
        this.hashFields.put("spcl_cgo_auth_knt", "spclCgoAuthKnt");
        this.hashFields.put("z4", "z4");
        this.hashFields.put("z2", "z2");
        this.hashFields.put("post_3_pol_cd", "post3PolCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ob_srep_cd", "obSrepCd");
        this.hashFields.put("rows_per_page", "rowsPerPage");
        this.hashFields.put("dest_trns_svc_mod_cd", "destTrnsSvcModCd");
        this.hashFields.put("dim_wdt", "dimWdt");
        this.hashFields.put("ctrl_atms_flg", "ctrlAtmsFlg");
        this.hashFields.put("rd_total_r9", "rdTotalR9");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("bkg_cre_dt", "bkgCreDt");
        this.hashFields.put("rd_total_r4", "rdTotalR4");
        this.hashFields.put("rd_total_r5", "rdTotalR5");
        this.hashFields.put("si_flg", "siFlg");
        this.hashFields.put("rd_total_r2", "rdTotalR2");
        this.hashFields.put("total_cnt", "totalCnt");
        this.hashFields.put("imdg_un_no", "imdgUnNo");
        this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
        this.hashFields.put("feu", "feu");
        this.hashFields.put("q2", "q2");
        this.hashFields.put("orderby_title_sql", "orderbyTitleSql");
        this.hashFields.put("q4", "q4");
        this.hashFields.put("dim_hgt", "dimHgt");
        this.hashFields.put("post_3_pod_cd", "post3PodCd");
        this.hashFields.put("post_1_pol_cd", "post1PolCd");
        this.hashFields.put("post_1_vvd", "post1Vvd");
        this.hashFields.put("ovr_rt_len", "ovrRtLen");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("rd_total_z2", "rdTotalZ2");
        this.hashFields.put("row_seq", "rowSeq");
        this.hashFields.put("rd_total_z4", "rdTotalZ4");
        this.hashFields.put("rc_flg", "rcFlg");
        this.hashFields.put("ovr_fwrd_len", "ovrFwrdLen");
        this.hashFields.put("imdg_clss_cd", "imdgClssCd");
        this.hashFields.put("total_teu", "totalTeu");
        this.hashFields.put("emer_cntc_phn_no_ctnt", "emerCntcPhnNoCtnt");
        this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
        this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
        this.hashFields.put("pre_3_pod_cd", "pre3PodCd");
        this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
        this.hashFields.put("consignee", "consignee");
        this.hashFields.put("bkg_clz_flg", "bkgClzFlg");
        this.hashFields.put("ovr_void_slt_qty", "ovrVoidSltQty");
        this.hashFields.put("contact", "contact");
        this.hashFields.put("bkg_stf", "bkgStf");
        this.hashFields.put("spcl_cgo_apro_cd", "spclCgoAproCd");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("total_wgt", "totalWgt");
        this.hashFields.put("rd_total_p4", "rdTotalP4");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("f2", "f2");
        this.hashFields.put("f5", "f5");
        this.hashFields.put("rd_total_p2", "rdTotalP2");
        this.hashFields.put("post_2_pod_cd", "post2PodCd");
        this.hashFields.put("f4", "f4");
        this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
        this.hashFields.put("pre_2_pol_cd", "pre2PolCd");
        this.hashFields.put("o2", "o2");
        this.hashFields.put("o4", "o4");
        this.hashFields.put("anty_name", "antyName");
        this.hashFields.put("total_mea", "totalMea");
        this.hashFields.put("shipper", "shipper");
        this.hashFields.put("pre_4_pol_cd", "pre4PolCd");
        this.hashFields.put("fdo_temp", "fdoTemp");
        this.hashFields.put("ovr_lf_len", "ovrLfLen");
        this.hashFields.put("remark_detail", "remarkDetail");
        this.hashFields.put("post_4_pol_cd", "post4PolCd");
        this.hashFields.put("humid_no", "humidNo");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("bst_flg", "bstFlg");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("rd_total_q2", "rdTotalQ2");
        this.hashFields.put("last_orderby", "lastOrderby");
        this.hashFields.put("rd_total_q4", "rdTotalQ4");
        this.hashFields.put("rep", "rep");
        this.hashFields.put("humid_ctrl_flg", "humidCtrlFlg");
        this.hashFields.put("ntfy", "ntfy");
        this.hashFields.put("post_1_pod_cd", "post1PodCd");
        this.hashFields.put("remark", "remark");
        this.hashFields.put("pre_1_vvd", "pre1Vvd");
        this.hashFields.put("total_bkg", "totalBkg");
        this.hashFields.put("tel", "tel");
        this.hashFields.put("rd_total_f2", "rdTotalF2");
        this.hashFields.put("d5", "d5");
        this.hashFields.put("d4", "d4");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pre_4_pod_cd", "pre4PodCd");
        this.hashFields.put("d7", "d7");
        this.hashFields.put("pre_3_pol_cd", "pre3PolCd");
        this.hashFields.put("d2", "d2");
        this.hashFields.put("ovr_hgt", "ovrHgt");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("curr_page", "currPage");
        this.hashFields.put("rnum", "rnum");
        this.hashFields.put("post_4_vvd", "post4Vvd");
        this.hashFields.put("pre_1_pod_cd", "pre1PodCd");
        this.hashFields.put("bb_cmdt", "bbCmdt");
        this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
        this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
        this.hashFields.put("post_4_pod_cd", "post4PodCd");
        this.hashFields.put("cgo_seq", "cgoSeq");
        this.hashFields.put("total_feu", "totalFeu");
        this.hashFields.put("consignee_name", "consigneeName");
        this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
        this.hashFields.put("net_wgt", "netWgt");
        this.hashFields.put("pkg", "pkg");
        this.hashFields.put("bkg_cnt", "bkgCnt");
        this.hashFields.put("rd_total_o2", "rdTotalO2");
        this.hashFields.put("cntr_vent_tp_cd", "cntrVentTpCd");
        this.hashFields.put("rd_total_o4", "rdTotalO4");
        this.hashFields.put("pre_3_vvd", "pre3Vvd");
        this.hashFields.put("rd_total_f4", "rdTotalF4");
        this.hashFields.put("ntfy_name", "ntfyName");
        this.hashFields.put("rd_total_f5", "rdTotalF5");
        this.hashFields.put("t4", "t4");
        this.hashFields.put("total_bl", "totalBl");
        this.hashFields.put("post_3_vvd", "post3Vvd");
        this.hashFields.put("rf_cmdt", "rfCmdt");
        this.hashFields.put("orderby", "orderby");
        this.hashFields.put("modi_atms_flg", "modiAtmsFlg");
        this.hashFields.put("teu", "teu");
        this.hashFields.put("cntr_vol_qty", "cntrVolQty");
        this.hashFields.put("grs_wgt", "grsWgt");
        this.hashFields.put("split_flg", "splitFlg");
        this.hashFields.put("t2", "t2");
        this.hashFields.put("shpr_name", "shprName");
        this.hashFields.put("dg_cmdt", "dgCmdt");
        this.hashFields.put("org_trns_svc_mod_cd", "orgTrnsSvcModCd");
        this.hashFields.put("bdr_flg", "bdrFlg");
        this.hashFields.put("trunk_vvd", "trunkVvd");
        this.hashFields.put("stowage", "stowage");
        this.hashFields.put("hot_de_flg", "hotDeFlg");
        this.hashFields.put("eq_subst_flg", "eqSubstFlg");
        this.hashFields.put("bkg_mea_qty", "bkgMeaQty");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("dim_len", "dimLen");
        this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
        this.hashFields.put("dcgo_flg", "dcgoFlg");
        this.hashFields.put("meas_qty", "measQty");
        this.hashFields.put("expt_name", "exptName");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("pre_2_vvd", "pre2Vvd");
        this.hashFields.put("orderby_title", "orderbyTitle");
        this.hashFields.put("ffdr", "ffdr");
        this.hashFields.put("org_svc_route", "orgSvcRoute");
        this.hashFields.put("rd_total_t2", "rdTotalT2");
        this.hashFields.put("rd_total_t4", "rdTotalT4");
        this.hashFields.put("pre_2_pod_cd", "pre2PodCd");
        this.hashFields.put("rd_total_d4", "rdTotalD4");
        this.hashFields.put("soc_flg", "socFlg");
        this.hashFields.put("rd_total_d5", "rdTotalD5");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("akrep_cmdt", "akrepCmdt");
        this.hashFields.put("pre_1_pol_cd", "pre1PolCd");
        this.hashFields.put("rd_total_d2", "rdTotalD2");
        this.hashFields.put("vltg_no", "vltgNo");
        this.hashFields.put("post_2_vvd", "post2Vvd");
        this.hashFields.put("cdo_temp", "cdoTemp");
        this.hashFields.put("commodity", "commodity");
        this.hashFields.put("ovr_bkwd_len", "ovrBkwdLen");
        this.hashFields.put("pre_4_vvd", "pre4Vvd");
        this.hashFields.put("rd_total_d7", "rdTotalD7");
        this.hashFields.put("hngr_flg", "hngrFlg");
        this.hashFields.put("orderby_cnt", "orderbyCnt");
        this.hashFields.put("ffdr_name", "ffdrName");
        this.hashFields.put("prp_shp_nm", "prpShpNm");
        this.hashFields.put("r2", "r2");
        this.hashFields.put("post_2_pol_cd", "post2PolCd");
        this.hashFields.put("bl_cnt", "blCnt");
        this.hashFields.put("r4", "r4");
        this.hashFields.put("r5", "r5");
        this.hashFields.put("o5", "o5");
        this.hashFields.put("rd_total_o5", "rdTotalO5");
        this.hashFields.put("atfc_atms_flg", "atfcAtmsFlg");
        this.hashFields.put("o7", "o7");
        this.hashFields.put("rd_total_o7", "rdTotalO7");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return destSvcRoute
	 */
    public String getDestSvcRoute() {
        return this.destSvcRoute;
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
	 * @return p2
	 */
    public String getP2() {
        return this.p2;
    }

    /**
	 * Column Info
	 * @return pwrSplCblFlg
	 */
    public String getPwrSplCblFlg() {
        return this.pwrSplCblFlg;
    }

    /**
	 * Column Info
	 * @return no
	 */
    public String getNo() {
        return this.no;
    }

    /**
	 * Column Info
	 * @return spclCgoAuthKnt
	 */
    public String getSpclCgoAuthKnt() {
        return this.spclCgoAuthKnt;
    }

    /**
	 * Column Info
	 * @return z4
	 */
    public String getZ4() {
        return this.z4;
    }

    /**
	 * Column Info
	 * @return z2
	 */
    public String getZ2() {
        return this.z2;
    }

    /**
	 * Column Info
	 * @return post3PolCd
	 */
    public String getPost3PolCd() {
        return this.post3PolCd;
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
	 * @return dimWdt
	 */
    public String getDimWdt() {
        return this.dimWdt;
    }

    /**
	 * Column Info
	 * @return ctrlAtmsFlg
	 */
    public String getCtrlAtmsFlg() {
        return this.ctrlAtmsFlg;
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
	 * @return imdgUnNo
	 */
    public String getImdgUnNo() {
        return this.imdgUnNo;
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
	 * @return q2
	 */
    public String getQ2() {
        return this.q2;
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
	 * @return q4
	 */
    public String getQ4() {
        return this.q4;
    }

    /**
	 * Column Info
	 * @return dimHgt
	 */
    public String getDimHgt() {
        return this.dimHgt;
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
	 * @return post1PolCd
	 */
    public String getPost1PolCd() {
        return this.post1PolCd;
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
	 * @return ovrRtLen
	 */
    public String getOvrRtLen() {
        return this.ovrRtLen;
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
	 * @return rowSeq
	 */
    public String getRowSeq() {
        return this.rowSeq;
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
	 * @return rcFlg
	 */
    public String getRcFlg() {
        return this.rcFlg;
    }

    /**
	 * Column Info
	 * @return ovrFwrdLen
	 */
    public String getOvrFwrdLen() {
        return this.ovrFwrdLen;
    }

    /**
	 * Column Info
	 * @return imdgClssCd
	 */
    public String getImdgClssCd() {
        return this.imdgClssCd;
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
	 * @return emerCntcPhnNoCtnt
	 */
    public String getEmerCntcPhnNoCtnt() {
        return this.emerCntcPhnNoCtnt;
    }

    /**
	 * Column Info
	 * @return imdgPckGrpCd
	 */
    public String getImdgPckGrpCd() {
        return this.imdgPckGrpCd;
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
	 * @return pre3PodCd
	 */
    public String getPre3PodCd() {
        return this.pre3PodCd;
    }

    /**
	 * Column Info
	 * @return flshPntCdoTemp
	 */
    public String getFlshPntCdoTemp() {
        return this.flshPntCdoTemp;
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
	 * @return bkgClzFlg
	 */
    public String getBkgClzFlg() {
        return this.bkgClzFlg;
    }

    /**
	 * Column Info
	 * @return ovrVoidSltQty
	 */
    public String getOvrVoidSltQty() {
        return this.ovrVoidSltQty;
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
	 * @return bkgStf
	 */
    public String getBkgStf() {
        return this.bkgStf;
    }

    /**
	 * Column Info
	 * @return spclCgoAproCd
	 */
    public String getSpclCgoAproCd() {
        return this.spclCgoAproCd;
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
	 * @return f2
	 */
    public String getF2() {
        return this.f2;
    }

    /**
	 * Column Info
	 * @return f5
	 */
    public String getF5() {
        return this.f5;
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
	 * @return post2PodCd
	 */
    public String getPost2PodCd() {
        return this.post2PodCd;
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
	 * @return dgCntrSeq
	 */
    public String getDgCntrSeq() {
        return this.dgCntrSeq;
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
	 * @return fdoTemp
	 */
    public String getFdoTemp() {
        return this.fdoTemp;
    }

    /**
	 * Column Info
	 * @return ovrLfLen
	 */
    public String getOvrLfLen() {
        return this.ovrLfLen;
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
	 * @return post4PolCd
	 */
    public String getPost4PolCd() {
        return this.post4PolCd;
    }

    /**
	 * Column Info
	 * @return humidNo
	 */
    public String getHumidNo() {
        return this.humidNo;
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
	 * @return bstFlg
	 */
    public String getBstFlg() {
        return this.bstFlg;
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
	 * @return humidCtrlFlg
	 */
    public String getHumidCtrlFlg() {
        return this.humidCtrlFlg;
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
	 * @return post1PodCd
	 */
    public String getPost1PodCd() {
        return this.post1PodCd;
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
	 * @return rdTotalF2
	 */
    public String getRdTotalF2() {
        return this.rdTotalF2;
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
	 * @return d4
	 */
    public String getD4() {
        return this.d4;
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
	 * @return d7
	 */
    public String getD7() {
        return this.d7;
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
	 * @return d2
	 */
    public String getD2() {
        return this.d2;
    }

    /**
	 * Column Info
	 * @return ovrHgt
	 */
    public String getOvrHgt() {
        return this.ovrHgt;
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
	 * @return bbCmdt
	 */
    public String getBbCmdt() {
        return this.bbCmdt;
    }

    /**
	 * Column Info
	 * @return custToOrdFlg
	 */
    public String getCustToOrdFlg() {
        return this.custToOrdFlg;
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
	 * @return post4PodCd
	 */
    public String getPost4PodCd() {
        return this.post4PodCd;
    }

    /**
	 * Column Info
	 * @return cgoSeq
	 */
    public String getCgoSeq() {
        return this.cgoSeq;
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
	 * @return consigneeName
	 */
    public String getConsigneeName() {
        return this.consigneeName;
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
	 * @return netWgt
	 */
    public String getNetWgt() {
        return this.netWgt;
    }

    /**
	 * Column Info
	 * @return pkg
	 */
    public String getPkg() {
        return this.pkg;
    }

    /**
	 * Column Info
	 * @return bkgCnt
	 */
    public String getBkgCnt() {
        return this.bkgCnt;
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
	 * @return cntrVentTpCd
	 */
    public String getCntrVentTpCd() {
        return this.cntrVentTpCd;
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
	 * @return t4
	 */
    public String getT4() {
        return this.t4;
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
	 * @return rfCmdt
	 */
    public String getRfCmdt() {
        return this.rfCmdt;
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
	 * @return modiAtmsFlg
	 */
    public String getModiAtmsFlg() {
        return this.modiAtmsFlg;
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
	 * @return cntrVolQty
	 */
    public String getCntrVolQty() {
        return this.cntrVolQty;
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
	 * @return splitFlg
	 */
    public String getSplitFlg() {
        return this.splitFlg;
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
	 * @return shprName
	 */
    public String getShprName() {
        return this.shprName;
    }

    /**
	 * Column Info
	 * @return dgCmdt
	 */
    public String getDgCmdt() {
        return this.dgCmdt;
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
	 * @return bdrFlg
	 */
    public String getBdrFlg() {
        return this.bdrFlg;
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
	 * @return stowage
	 */
    public String getStowage() {
        return this.stowage;
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
	 * @return eqSubstFlg
	 */
    public String getEqSubstFlg() {
        return this.eqSubstFlg;
    }

    /**
	 * Column Info
	 * @return bkgMeaQty
	 */
    public String getBkgMeaQty() {
        return this.bkgMeaQty;
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
	 * @return dimLen
	 */
    public String getDimLen() {
        return this.dimLen;
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
	 * @return measQty
	 */
    public String getMeasQty() {
        return this.measQty;
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
	 * @return orgSvcRoute
	 */
    public String getOrgSvcRoute() {
        return this.orgSvcRoute;
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
	 * @return deTermCd
	 */
    public String getDeTermCd() {
        return this.deTermCd;
    }

    /**
	 * Column Info
	 * @return akrepCmdt
	 */
    public String getAkrepCmdt() {
        return this.akrepCmdt;
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
	 * @return vltgNo
	 */
    public String getVltgNo() {
        return this.vltgNo;
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
	 * @return cdoTemp
	 */
    public String getCdoTemp() {
        return this.cdoTemp;
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
	 * @return ovrBkwdLen
	 */
    public String getOvrBkwdLen() {
        return this.ovrBkwdLen;
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
	 * @return prpShpNm
	 */
    public String getPrpShpNm() {
        return this.prpShpNm;
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
	 * @return post2PolCd
	 */
    public String getPost2PolCd() {
        return this.post2PolCd;
    }

    /**
	 * Column Info
	 * @return blCnt
	 */
    public String getBlCnt() {
        return this.blCnt;
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
	 * @return r5
	 */
    public String getR5() {
        return this.r5;
    }

    /**
	 * Column Info
	 * @return o5
	 */
    public String getO5() {
        return this.o5;
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
	 * @return atfcAtmsFlg
	 */
    public String getAtfcAtmsFlg() {
        return this.atfcAtmsFlg;
    }

    /**
	 * Column Info
	 * @param destSvcRoute
	 */
    public void setDestSvcRoute(String destSvcRoute) {
        this.destSvcRoute = destSvcRoute;
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
	 * @param p2
	 */
    public void setP2(String p2) {
        this.p2 = p2;
    }

    /**
	 * Column Info
	 * @param pwrSplCblFlg
	 */
    public void setPwrSplCblFlg(String pwrSplCblFlg) {
        this.pwrSplCblFlg = pwrSplCblFlg;
    }

    /**
	 * Column Info
	 * @param no
	 */
    public void setNo(String no) {
        this.no = no;
    }

    /**
	 * Column Info
	 * @param spclCgoAuthKnt
	 */
    public void setSpclCgoAuthKnt(String spclCgoAuthKnt) {
        this.spclCgoAuthKnt = spclCgoAuthKnt;
    }

    /**
	 * Column Info
	 * @param z4
	 */
    public void setZ4(String z4) {
        this.z4 = z4;
    }

    /**
	 * Column Info
	 * @param z2
	 */
    public void setZ2(String z2) {
        this.z2 = z2;
    }

    /**
	 * Column Info
	 * @param post3PolCd
	 */
    public void setPost3PolCd(String post3PolCd) {
        this.post3PolCd = post3PolCd;
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
	 * @param dimWdt
	 */
    public void setDimWdt(String dimWdt) {
        this.dimWdt = dimWdt;
    }

    /**
	 * Column Info
	 * @param ctrlAtmsFlg
	 */
    public void setCtrlAtmsFlg(String ctrlAtmsFlg) {
        this.ctrlAtmsFlg = ctrlAtmsFlg;
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
	 * @param imdgUnNo
	 */
    public void setImdgUnNo(String imdgUnNo) {
        this.imdgUnNo = imdgUnNo;
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
	 * @param q2
	 */
    public void setQ2(String q2) {
        this.q2 = q2;
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
	 * @param q4
	 */
    public void setQ4(String q4) {
        this.q4 = q4;
    }

    /**
	 * Column Info
	 * @param dimHgt
	 */
    public void setDimHgt(String dimHgt) {
        this.dimHgt = dimHgt;
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
	 * @param post1PolCd
	 */
    public void setPost1PolCd(String post1PolCd) {
        this.post1PolCd = post1PolCd;
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
	 * @param ovrRtLen
	 */
    public void setOvrRtLen(String ovrRtLen) {
        this.ovrRtLen = ovrRtLen;
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
	 * @param rowSeq
	 */
    public void setRowSeq(String rowSeq) {
        this.rowSeq = rowSeq;
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
	 * @param rcFlg
	 */
    public void setRcFlg(String rcFlg) {
        this.rcFlg = rcFlg;
    }

    /**
	 * Column Info
	 * @param ovrFwrdLen
	 */
    public void setOvrFwrdLen(String ovrFwrdLen) {
        this.ovrFwrdLen = ovrFwrdLen;
    }

    /**
	 * Column Info
	 * @param imdgClssCd
	 */
    public void setImdgClssCd(String imdgClssCd) {
        this.imdgClssCd = imdgClssCd;
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
	 * @param emerCntcPhnNoCtnt
	 */
    public void setEmerCntcPhnNoCtnt(String emerCntcPhnNoCtnt) {
        this.emerCntcPhnNoCtnt = emerCntcPhnNoCtnt;
    }

    /**
	 * Column Info
	 * @param imdgPckGrpCd
	 */
    public void setImdgPckGrpCd(String imdgPckGrpCd) {
        this.imdgPckGrpCd = imdgPckGrpCd;
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
	 * @param pre3PodCd
	 */
    public void setPre3PodCd(String pre3PodCd) {
        this.pre3PodCd = pre3PodCd;
    }

    /**
	 * Column Info
	 * @param flshPntCdoTemp
	 */
    public void setFlshPntCdoTemp(String flshPntCdoTemp) {
        this.flshPntCdoTemp = flshPntCdoTemp;
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
	 * @param bkgClzFlg
	 */
    public void setBkgClzFlg(String bkgClzFlg) {
        this.bkgClzFlg = bkgClzFlg;
    }

    /**
	 * Column Info
	 * @param ovrVoidSltQty
	 */
    public void setOvrVoidSltQty(String ovrVoidSltQty) {
        this.ovrVoidSltQty = ovrVoidSltQty;
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
	 * @param bkgStf
	 */
    public void setBkgStf(String bkgStf) {
        this.bkgStf = bkgStf;
    }

    /**
	 * Column Info
	 * @param spclCgoAproCd
	 */
    public void setSpclCgoAproCd(String spclCgoAproCd) {
        this.spclCgoAproCd = spclCgoAproCd;
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
	 * @param f2
	 */
    public void setF2(String f2) {
        this.f2 = f2;
    }

    /**
	 * Column Info
	 * @param f5
	 */
    public void setF5(String f5) {
        this.f5 = f5;
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
	 * @param post2PodCd
	 */
    public void setPost2PodCd(String post2PodCd) {
        this.post2PodCd = post2PodCd;
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
	 * @param dgCntrSeq
	 */
    public void setDgCntrSeq(String dgCntrSeq) {
        this.dgCntrSeq = dgCntrSeq;
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
	 * @param fdoTemp
	 */
    public void setFdoTemp(String fdoTemp) {
        this.fdoTemp = fdoTemp;
    }

    /**
	 * Column Info
	 * @param ovrLfLen
	 */
    public void setOvrLfLen(String ovrLfLen) {
        this.ovrLfLen = ovrLfLen;
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
	 * @param post4PolCd
	 */
    public void setPost4PolCd(String post4PolCd) {
        this.post4PolCd = post4PolCd;
    }

    /**
	 * Column Info
	 * @param humidNo
	 */
    public void setHumidNo(String humidNo) {
        this.humidNo = humidNo;
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
	 * @param bstFlg
	 */
    public void setBstFlg(String bstFlg) {
        this.bstFlg = bstFlg;
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
	 * @param humidCtrlFlg
	 */
    public void setHumidCtrlFlg(String humidCtrlFlg) {
        this.humidCtrlFlg = humidCtrlFlg;
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
	 * @param post1PodCd
	 */
    public void setPost1PodCd(String post1PodCd) {
        this.post1PodCd = post1PodCd;
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
	 * @param rdTotalF2
	 */
    public void setRdTotalF2(String rdTotalF2) {
        this.rdTotalF2 = rdTotalF2;
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
	 * @param d4
	 */
    public void setD4(String d4) {
        this.d4 = d4;
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
	 * @param d7
	 */
    public void setD7(String d7) {
        this.d7 = d7;
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
	 * @param d2
	 */
    public void setD2(String d2) {
        this.d2 = d2;
    }

    /**
	 * Column Info
	 * @param ovrHgt
	 */
    public void setOvrHgt(String ovrHgt) {
        this.ovrHgt = ovrHgt;
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
	 * @param bbCmdt
	 */
    public void setBbCmdt(String bbCmdt) {
        this.bbCmdt = bbCmdt;
    }

    /**
	 * Column Info
	 * @param custToOrdFlg
	 */
    public void setCustToOrdFlg(String custToOrdFlg) {
        this.custToOrdFlg = custToOrdFlg;
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
	 * @param post4PodCd
	 */
    public void setPost4PodCd(String post4PodCd) {
        this.post4PodCd = post4PodCd;
    }

    /**
	 * Column Info
	 * @param cgoSeq
	 */
    public void setCgoSeq(String cgoSeq) {
        this.cgoSeq = cgoSeq;
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
	 * @param consigneeName
	 */
    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
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
	 * @param netWgt
	 */
    public void setNetWgt(String netWgt) {
        this.netWgt = netWgt;
    }

    /**
	 * Column Info
	 * @param pkg
	 */
    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    /**
	 * Column Info
	 * @param bkgCnt
	 */
    public void setBkgCnt(String bkgCnt) {
        this.bkgCnt = bkgCnt;
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
	 * @param cntrVentTpCd
	 */
    public void setCntrVentTpCd(String cntrVentTpCd) {
        this.cntrVentTpCd = cntrVentTpCd;
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
	 * @param t4
	 */
    public void setT4(String t4) {
        this.t4 = t4;
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
	 * @param rfCmdt
	 */
    public void setRfCmdt(String rfCmdt) {
        this.rfCmdt = rfCmdt;
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
	 * @param modiAtmsFlg
	 */
    public void setModiAtmsFlg(String modiAtmsFlg) {
        this.modiAtmsFlg = modiAtmsFlg;
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
	 * @param cntrVolQty
	 */
    public void setCntrVolQty(String cntrVolQty) {
        this.cntrVolQty = cntrVolQty;
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
	 * @param splitFlg
	 */
    public void setSplitFlg(String splitFlg) {
        this.splitFlg = splitFlg;
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
	 * @param shprName
	 */
    public void setShprName(String shprName) {
        this.shprName = shprName;
    }

    /**
	 * Column Info
	 * @param dgCmdt
	 */
    public void setDgCmdt(String dgCmdt) {
        this.dgCmdt = dgCmdt;
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
	 * @param bdrFlg
	 */
    public void setBdrFlg(String bdrFlg) {
        this.bdrFlg = bdrFlg;
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
	 * @param stowage
	 */
    public void setStowage(String stowage) {
        this.stowage = stowage;
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
	 * @param eqSubstFlg
	 */
    public void setEqSubstFlg(String eqSubstFlg) {
        this.eqSubstFlg = eqSubstFlg;
    }

    /**
	 * Column Info
	 * @param bkgMeaQty
	 */
    public void setBkgMeaQty(String bkgMeaQty) {
        this.bkgMeaQty = bkgMeaQty;
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
	 * @param dimLen
	 */
    public void setDimLen(String dimLen) {
        this.dimLen = dimLen;
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
	 * @param measQty
	 */
    public void setMeasQty(String measQty) {
        this.measQty = measQty;
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
	 * @param orgSvcRoute
	 */
    public void setOrgSvcRoute(String orgSvcRoute) {
        this.orgSvcRoute = orgSvcRoute;
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
	 * @param deTermCd
	 */
    public void setDeTermCd(String deTermCd) {
        this.deTermCd = deTermCd;
    }

    /**
	 * Column Info
	 * @param akrepCmdt
	 */
    public void setAkrepCmdt(String akrepCmdt) {
        this.akrepCmdt = akrepCmdt;
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
	 * @param vltgNo
	 */
    public void setVltgNo(String vltgNo) {
        this.vltgNo = vltgNo;
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
	 * @param cdoTemp
	 */
    public void setCdoTemp(String cdoTemp) {
        this.cdoTemp = cdoTemp;
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
	 * @param ovrBkwdLen
	 */
    public void setOvrBkwdLen(String ovrBkwdLen) {
        this.ovrBkwdLen = ovrBkwdLen;
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
	 * @param prpShpNm
	 */
    public void setPrpShpNm(String prpShpNm) {
        this.prpShpNm = prpShpNm;
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
	 * @param post2PolCd
	 */
    public void setPost2PolCd(String post2PolCd) {
        this.post2PolCd = post2PolCd;
    }

    /**
	 * Column Info
	 * @param blCnt
	 */
    public void setBlCnt(String blCnt) {
        this.blCnt = blCnt;
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
	 * @param r5
	 */
    public void setR5(String r5) {
        this.r5 = r5;
    }

    /**
	 * Column Info
	 * @param o5
	 */
    public void setO5(String o5) {
        this.o5 = o5;
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
	 * @param atfcAtmsFlg
	 */
    public void setAtfcAtmsFlg(String atfcAtmsFlg) {
        this.atfcAtmsFlg = atfcAtmsFlg;
    }

    public void setO7(String o7) {
        this.o7 = o7;
    }

    public String getO7() {
        return this.o7;
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
        setDestSvcRoute(JSPUtil.getParameter(request, prefix + "dest_svc_route", ""));
        setP4(JSPUtil.getParameter(request, prefix + "p4", ""));
        setP2(JSPUtil.getParameter(request, prefix + "p2", ""));
        setPwrSplCblFlg(JSPUtil.getParameter(request, prefix + "pwr_spl_cbl_flg", ""));
        setNo(JSPUtil.getParameter(request, prefix + "no", ""));
        setSpclCgoAuthKnt(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_knt", ""));
        setZ4(JSPUtil.getParameter(request, prefix + "z4", ""));
        setZ2(JSPUtil.getParameter(request, prefix + "z2", ""));
        setPost3PolCd(JSPUtil.getParameter(request, prefix + "post_3_pol_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
        setRowsPerPage(JSPUtil.getParameter(request, prefix + "rows_per_page", ""));
        setDestTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "dest_trns_svc_mod_cd", ""));
        setDimWdt(JSPUtil.getParameter(request, prefix + "dim_wdt", ""));
        setCtrlAtmsFlg(JSPUtil.getParameter(request, prefix + "ctrl_atms_flg", ""));
        setRdTotalR9(JSPUtil.getParameter(request, prefix + "rd_total_r9", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
        setRdTotalR4(JSPUtil.getParameter(request, prefix + "rd_total_r4", ""));
        setRdTotalR5(JSPUtil.getParameter(request, prefix + "rd_total_r5", ""));
        setSiFlg(JSPUtil.getParameter(request, prefix + "si_flg", ""));
        setRdTotalR2(JSPUtil.getParameter(request, prefix + "rd_total_r2", ""));
        setTotalCnt(JSPUtil.getParameter(request, prefix + "total_cnt", ""));
        setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
        setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
        setFeu(JSPUtil.getParameter(request, prefix + "feu", ""));
        setQ2(JSPUtil.getParameter(request, prefix + "q2", ""));
        setOrderbyTitleSql(JSPUtil.getParameter(request, prefix + "orderby_title_sql", ""));
        setQ4(JSPUtil.getParameter(request, prefix + "q4", ""));
        setDimHgt(JSPUtil.getParameter(request, prefix + "dim_hgt", ""));
        setPost3PodCd(JSPUtil.getParameter(request, prefix + "post_3_pod_cd", ""));
        setPost1PolCd(JSPUtil.getParameter(request, prefix + "post_1_pol_cd", ""));
        setPost1Vvd(JSPUtil.getParameter(request, prefix + "post_1_vvd", ""));
        setOvrRtLen(JSPUtil.getParameter(request, prefix + "ovr_rt_len", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setRdTotalZ2(JSPUtil.getParameter(request, prefix + "rd_total_z2", ""));
        setRowSeq(JSPUtil.getParameter(request, prefix + "row_seq", ""));
        setRdTotalZ4(JSPUtil.getParameter(request, prefix + "rd_total_z4", ""));
        setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
        setOvrFwrdLen(JSPUtil.getParameter(request, prefix + "ovr_fwrd_len", ""));
        setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
        setTotalTeu(JSPUtil.getParameter(request, prefix + "total_teu", ""));
        setEmerCntcPhnNoCtnt(JSPUtil.getParameter(request, prefix + "emer_cntc_phn_no_ctnt", ""));
        setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
        setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
        setPre3PodCd(JSPUtil.getParameter(request, prefix + "pre_3_pod_cd", ""));
        setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
        setConsignee(JSPUtil.getParameter(request, prefix + "consignee", ""));
        setBkgClzFlg(JSPUtil.getParameter(request, prefix + "bkg_clz_flg", ""));
        setOvrVoidSltQty(JSPUtil.getParameter(request, prefix + "ovr_void_slt_qty", ""));
        setContact(JSPUtil.getParameter(request, prefix + "contact", ""));
        setBkgStf(JSPUtil.getParameter(request, prefix + "bkg_stf", ""));
        setSpclCgoAproCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_cd", ""));
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setTotalWgt(JSPUtil.getParameter(request, prefix + "total_wgt", ""));
        setRdTotalP4(JSPUtil.getParameter(request, prefix + "rd_total_p4", ""));
        setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
        setF2(JSPUtil.getParameter(request, prefix + "f2", ""));
        setF5(JSPUtil.getParameter(request, prefix + "f5", ""));
        setRdTotalP2(JSPUtil.getParameter(request, prefix + "rd_total_p2", ""));
        setPost2PodCd(JSPUtil.getParameter(request, prefix + "post_2_pod_cd", ""));
        setF4(JSPUtil.getParameter(request, prefix + "f4", ""));
        setDgCntrSeq(JSPUtil.getParameter(request, prefix + "dg_cntr_seq", ""));
        setPre2PolCd(JSPUtil.getParameter(request, prefix + "pre_2_pol_cd", ""));
        setO2(JSPUtil.getParameter(request, prefix + "o2", ""));
        setO4(JSPUtil.getParameter(request, prefix + "o4", ""));
        setAntyName(JSPUtil.getParameter(request, prefix + "anty_name", ""));
        setTotalMea(JSPUtil.getParameter(request, prefix + "total_mea", ""));
        setShipper(JSPUtil.getParameter(request, prefix + "shipper", ""));
        setPre4PolCd(JSPUtil.getParameter(request, prefix + "pre_4_pol_cd", ""));
        setFdoTemp(JSPUtil.getParameter(request, prefix + "fdo_temp", ""));
        setOvrLfLen(JSPUtil.getParameter(request, prefix + "ovr_lf_len", ""));
        setRemarkDetail(JSPUtil.getParameter(request, prefix + "remark_detail", ""));
        setPost4PolCd(JSPUtil.getParameter(request, prefix + "post_4_pol_cd", ""));
        setHumidNo(JSPUtil.getParameter(request, prefix + "humid_no", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setBstFlg(JSPUtil.getParameter(request, prefix + "bst_flg", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setRdTotalQ2(JSPUtil.getParameter(request, prefix + "rd_total_q2", ""));
        setLastOrderby(JSPUtil.getParameter(request, prefix + "last_orderby", ""));
        setRdTotalQ4(JSPUtil.getParameter(request, prefix + "rd_total_q4", ""));
        setRep(JSPUtil.getParameter(request, prefix + "rep", ""));
        setHumidCtrlFlg(JSPUtil.getParameter(request, prefix + "humid_ctrl_flg", ""));
        setNtfy(JSPUtil.getParameter(request, prefix + "ntfy", ""));
        setPost1PodCd(JSPUtil.getParameter(request, prefix + "post_1_pod_cd", ""));
        setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
        setPre1Vvd(JSPUtil.getParameter(request, prefix + "pre_1_vvd", ""));
        setTotalBkg(JSPUtil.getParameter(request, prefix + "total_bkg", ""));
        setTel(JSPUtil.getParameter(request, prefix + "tel", ""));
        setRdTotalF2(JSPUtil.getParameter(request, prefix + "rd_total_f2", ""));
        setD5(JSPUtil.getParameter(request, prefix + "d5", ""));
        setD4(JSPUtil.getParameter(request, prefix + "d4", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setPre4PodCd(JSPUtil.getParameter(request, prefix + "pre_4_pod_cd", ""));
        setD7(JSPUtil.getParameter(request, prefix + "d7", ""));
        setPre3PolCd(JSPUtil.getParameter(request, prefix + "pre_3_pol_cd", ""));
        setD2(JSPUtil.getParameter(request, prefix + "d2", ""));
        setOvrHgt(JSPUtil.getParameter(request, prefix + "ovr_hgt", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setCurrPage(JSPUtil.getParameter(request, prefix + "curr_page", ""));
        setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
        setPost4Vvd(JSPUtil.getParameter(request, prefix + "post_4_vvd", ""));
        setPre1PodCd(JSPUtil.getParameter(request, prefix + "pre_1_pod_cd", ""));
        setBbCmdt(JSPUtil.getParameter(request, prefix + "bb_cmdt", ""));
        setCustToOrdFlg(JSPUtil.getParameter(request, prefix + "cust_to_ord_flg", ""));
        setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
        setPost4PodCd(JSPUtil.getParameter(request, prefix + "post_4_pod_cd", ""));
        setCgoSeq(JSPUtil.getParameter(request, prefix + "cgo_seq", ""));
        setTotalFeu(JSPUtil.getParameter(request, prefix + "total_feu", ""));
        setConsigneeName(JSPUtil.getParameter(request, prefix + "consignee_name", ""));
        setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
        setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
        setPkg(JSPUtil.getParameter(request, prefix + "pkg", ""));
        setBkgCnt(JSPUtil.getParameter(request, prefix + "bkg_cnt", ""));
        setRdTotalO2(JSPUtil.getParameter(request, prefix + "rd_total_o2", ""));
        setCntrVentTpCd(JSPUtil.getParameter(request, prefix + "cntr_vent_tp_cd", ""));
        setRdTotalO4(JSPUtil.getParameter(request, prefix + "rd_total_o4", ""));
        setPre3Vvd(JSPUtil.getParameter(request, prefix + "pre_3_vvd", ""));
        setRdTotalF4(JSPUtil.getParameter(request, prefix + "rd_total_f4", ""));
        setNtfyName(JSPUtil.getParameter(request, prefix + "ntfy_name", ""));
        setRdTotalF5(JSPUtil.getParameter(request, prefix + "rd_total_f5", ""));
        setT4(JSPUtil.getParameter(request, prefix + "t4", ""));
        setTotalBl(JSPUtil.getParameter(request, prefix + "total_bl", ""));
        setPost3Vvd(JSPUtil.getParameter(request, prefix + "post_3_vvd", ""));
        setRfCmdt(JSPUtil.getParameter(request, prefix + "rf_cmdt", ""));
        setOrderby(JSPUtil.getParameter(request, prefix + "orderby", ""));
        setModiAtmsFlg(JSPUtil.getParameter(request, prefix + "modi_atms_flg", ""));
        setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
        setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
        setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
        setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
        setT2(JSPUtil.getParameter(request, prefix + "t2", ""));
        setShprName(JSPUtil.getParameter(request, prefix + "shpr_name", ""));
        setDgCmdt(JSPUtil.getParameter(request, prefix + "dg_cmdt", ""));
        setOrgTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "org_trns_svc_mod_cd", ""));
        setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
        setTrunkVvd(JSPUtil.getParameter(request, prefix + "trunk_vvd", ""));
        setStowage(JSPUtil.getParameter(request, prefix + "stowage", ""));
        setHotDeFlg(JSPUtil.getParameter(request, prefix + "hot_de_flg", ""));
        setEqSubstFlg(JSPUtil.getParameter(request, prefix + "eq_subst_flg", ""));
        setBkgMeaQty(JSPUtil.getParameter(request, prefix + "bkg_mea_qty", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setDimLen(JSPUtil.getParameter(request, prefix + "dim_len", ""));
        setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
        setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
        setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
        setExptName(JSPUtil.getParameter(request, prefix + "expt_name", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setPre2Vvd(JSPUtil.getParameter(request, prefix + "pre_2_vvd", ""));
        setOrderbyTitle(JSPUtil.getParameter(request, prefix + "orderby_title", ""));
        setFfdr(JSPUtil.getParameter(request, prefix + "ffdr", ""));
        setOrgSvcRoute(JSPUtil.getParameter(request, prefix + "org_svc_route", ""));
        setRdTotalT2(JSPUtil.getParameter(request, prefix + "rd_total_t2", ""));
        setRdTotalT4(JSPUtil.getParameter(request, prefix + "rd_total_t4", ""));
        setPre2PodCd(JSPUtil.getParameter(request, prefix + "pre_2_pod_cd", ""));
        setRdTotalD4(JSPUtil.getParameter(request, prefix + "rd_total_d4", ""));
        setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
        setRdTotalD5(JSPUtil.getParameter(request, prefix + "rd_total_d5", ""));
        setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
        setAkrepCmdt(JSPUtil.getParameter(request, prefix + "akrep_cmdt", ""));
        setPre1PolCd(JSPUtil.getParameter(request, prefix + "pre_1_pol_cd", ""));
        setRdTotalD2(JSPUtil.getParameter(request, prefix + "rd_total_d2", ""));
        setVltgNo(JSPUtil.getParameter(request, prefix + "vltg_no", ""));
        setPost2Vvd(JSPUtil.getParameter(request, prefix + "post_2_vvd", ""));
        setCdoTemp(JSPUtil.getParameter(request, prefix + "cdo_temp", ""));
        setCommodity(JSPUtil.getParameter(request, prefix + "commodity", ""));
        setOvrBkwdLen(JSPUtil.getParameter(request, prefix + "ovr_bkwd_len", ""));
        setPre4Vvd(JSPUtil.getParameter(request, prefix + "pre_4_vvd", ""));
        setRdTotalD7(JSPUtil.getParameter(request, prefix + "rd_total_d7", ""));
        setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
        setOrderbyCnt(JSPUtil.getParameter(request, prefix + "orderby_cnt", ""));
        setFfdrName(JSPUtil.getParameter(request, prefix + "ffdr_name", ""));
        setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
        setR2(JSPUtil.getParameter(request, prefix + "r2", ""));
        setPost2PolCd(JSPUtil.getParameter(request, prefix + "post_2_pol_cd", ""));
        setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
        setR4(JSPUtil.getParameter(request, prefix + "r4", ""));
        setR5(JSPUtil.getParameter(request, prefix + "r5", ""));
        setO5(JSPUtil.getParameter(request, prefix + "o5", ""));
        setRdTotalO5(JSPUtil.getParameter(request, prefix + "rd_total_o5", ""));
        setAtfcAtmsFlg(JSPUtil.getParameter(request, prefix + "atfc_atms_flg", ""));
        setO7(JSPUtil.getParameter(request, prefix + "o7", ""));
        setRdTotalO7(JSPUtil.getParameter(request, prefix + "rd_total_o7", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StatusReportSpecialCargoOutVO[]
	 */
    public StatusReportSpecialCargoOutVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StatusReportSpecialCargoOutVO[]
	 */
    public StatusReportSpecialCargoOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        StatusReportSpecialCargoOutVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] destSvcRoute = (JSPUtil.getParameter(request, prefix + "dest_svc_route", length));
            String[] p4 = (JSPUtil.getParameter(request, prefix + "p4", length));
            String[] p2 = (JSPUtil.getParameter(request, prefix + "p2", length));
            String[] pwrSplCblFlg = (JSPUtil.getParameter(request, prefix + "pwr_spl_cbl_flg", length));
            String[] no = (JSPUtil.getParameter(request, prefix + "no", length));
            String[] spclCgoAuthKnt = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_knt", length));
            String[] z4 = (JSPUtil.getParameter(request, prefix + "z4", length));
            String[] z2 = (JSPUtil.getParameter(request, prefix + "z2", length));
            String[] post3PolCd = (JSPUtil.getParameter(request, prefix + "post_3_pol_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] obSrepCd = (JSPUtil.getParameter(request, prefix + "ob_srep_cd", length));
            String[] rowsPerPage = (JSPUtil.getParameter(request, prefix + "rows_per_page", length));
            String[] destTrnsSvcModCd = (JSPUtil.getParameter(request, prefix + "dest_trns_svc_mod_cd", length));
            String[] dimWdt = (JSPUtil.getParameter(request, prefix + "dim_wdt", length));
            String[] ctrlAtmsFlg = (JSPUtil.getParameter(request, prefix + "ctrl_atms_flg", length));
            String[] rdTotalR9 = (JSPUtil.getParameter(request, prefix + "rd_total_r9", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] bkgCreDt = (JSPUtil.getParameter(request, prefix + "bkg_cre_dt", length));
            String[] rdTotalR4 = (JSPUtil.getParameter(request, prefix + "rd_total_r4", length));
            String[] rdTotalR5 = (JSPUtil.getParameter(request, prefix + "rd_total_r5", length));
            String[] siFlg = (JSPUtil.getParameter(request, prefix + "si_flg", length));
            String[] rdTotalR2 = (JSPUtil.getParameter(request, prefix + "rd_total_r2", length));
            String[] totalCnt = (JSPUtil.getParameter(request, prefix + "total_cnt", length));
            String[] imdgUnNo = (JSPUtil.getParameter(request, prefix + "imdg_un_no", length));
            String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", length));
            String[] feu = (JSPUtil.getParameter(request, prefix + "feu", length));
            String[] q2 = (JSPUtil.getParameter(request, prefix + "q2", length));
            String[] orderbyTitleSql = (JSPUtil.getParameter(request, prefix + "orderby_title_sql", length));
            String[] q4 = (JSPUtil.getParameter(request, prefix + "q4", length));
            String[] dimHgt = (JSPUtil.getParameter(request, prefix + "dim_hgt", length));
            String[] post3PodCd = (JSPUtil.getParameter(request, prefix + "post_3_pod_cd", length));
            String[] post1PolCd = (JSPUtil.getParameter(request, prefix + "post_1_pol_cd", length));
            String[] post1Vvd = (JSPUtil.getParameter(request, prefix + "post_1_vvd", length));
            String[] ovrRtLen = (JSPUtil.getParameter(request, prefix + "ovr_rt_len", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] rdTotalZ2 = (JSPUtil.getParameter(request, prefix + "rd_total_z2", length));
            String[] rowSeq = (JSPUtil.getParameter(request, prefix + "row_seq", length));
            String[] rdTotalZ4 = (JSPUtil.getParameter(request, prefix + "rd_total_z4", length));
            String[] rcFlg = (JSPUtil.getParameter(request, prefix + "rc_flg", length));
            String[] ovrFwrdLen = (JSPUtil.getParameter(request, prefix + "ovr_fwrd_len", length));
            String[] imdgClssCd = (JSPUtil.getParameter(request, prefix + "imdg_clss_cd", length));
            String[] totalTeu = (JSPUtil.getParameter(request, prefix + "total_teu", length));
            String[] emerCntcPhnNoCtnt = (JSPUtil.getParameter(request, prefix + "emer_cntc_phn_no_ctnt", length));
            String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", length));
            String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix + "rd_cgo_flg", length));
            String[] pre3PodCd = (JSPUtil.getParameter(request, prefix + "pre_3_pod_cd", length));
            String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", length));
            String[] consignee = (JSPUtil.getParameter(request, prefix + "consignee", length));
            String[] bkgClzFlg = (JSPUtil.getParameter(request, prefix + "bkg_clz_flg", length));
            String[] ovrVoidSltQty = (JSPUtil.getParameter(request, prefix + "ovr_void_slt_qty", length));
            String[] contact = (JSPUtil.getParameter(request, prefix + "contact", length));
            String[] bkgStf = (JSPUtil.getParameter(request, prefix + "bkg_stf", length));
            String[] spclCgoAproCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_cd", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] totalWgt = (JSPUtil.getParameter(request, prefix + "total_wgt", length));
            String[] rdTotalP4 = (JSPUtil.getParameter(request, prefix + "rd_total_p4", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] f2 = (JSPUtil.getParameter(request, prefix + "f2", length));
            String[] f5 = (JSPUtil.getParameter(request, prefix + "f5", length));
            String[] rdTotalP2 = (JSPUtil.getParameter(request, prefix + "rd_total_p2", length));
            String[] post2PodCd = (JSPUtil.getParameter(request, prefix + "post_2_pod_cd", length));
            String[] f4 = (JSPUtil.getParameter(request, prefix + "f4", length));
            String[] dgCntrSeq = (JSPUtil.getParameter(request, prefix + "dg_cntr_seq", length));
            String[] pre2PolCd = (JSPUtil.getParameter(request, prefix + "pre_2_pol_cd", length));
            String[] o2 = (JSPUtil.getParameter(request, prefix + "o2", length));
            String[] o4 = (JSPUtil.getParameter(request, prefix + "o4", length));
            String[] antyName = (JSPUtil.getParameter(request, prefix + "anty_name", length));
            String[] totalMea = (JSPUtil.getParameter(request, prefix + "total_mea", length));
            String[] shipper = (JSPUtil.getParameter(request, prefix + "shipper", length));
            String[] pre4PolCd = (JSPUtil.getParameter(request, prefix + "pre_4_pol_cd", length));
            String[] fdoTemp = (JSPUtil.getParameter(request, prefix + "fdo_temp", length));
            String[] ovrLfLen = (JSPUtil.getParameter(request, prefix + "ovr_lf_len", length));
            String[] remarkDetail = (JSPUtil.getParameter(request, prefix + "remark_detail", length));
            String[] post4PolCd = (JSPUtil.getParameter(request, prefix + "post_4_pol_cd", length));
            String[] humidNo = (JSPUtil.getParameter(request, prefix + "humid_no", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] bstFlg = (JSPUtil.getParameter(request, prefix + "bst_flg", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] rdTotalQ2 = (JSPUtil.getParameter(request, prefix + "rd_total_q2", length));
            String[] lastOrderby = (JSPUtil.getParameter(request, prefix + "last_orderby", length));
            String[] rdTotalQ4 = (JSPUtil.getParameter(request, prefix + "rd_total_q4", length));
            String[] rep = (JSPUtil.getParameter(request, prefix + "rep", length));
            String[] humidCtrlFlg = (JSPUtil.getParameter(request, prefix + "humid_ctrl_flg", length));
            String[] ntfy = (JSPUtil.getParameter(request, prefix + "ntfy", length));
            String[] post1PodCd = (JSPUtil.getParameter(request, prefix + "post_1_pod_cd", length));
            String[] remark = (JSPUtil.getParameter(request, prefix + "remark", length));
            String[] pre1Vvd = (JSPUtil.getParameter(request, prefix + "pre_1_vvd", length));
            String[] totalBkg = (JSPUtil.getParameter(request, prefix + "total_bkg", length));
            String[] tel = (JSPUtil.getParameter(request, prefix + "tel", length));
            String[] rdTotalF2 = (JSPUtil.getParameter(request, prefix + "rd_total_f2", length));
            String[] d5 = (JSPUtil.getParameter(request, prefix + "d5", length));
            String[] d4 = (JSPUtil.getParameter(request, prefix + "d4", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pre4PodCd = (JSPUtil.getParameter(request, prefix + "pre_4_pod_cd", length));
            String[] d7 = (JSPUtil.getParameter(request, prefix + "d7", length));
            String[] pre3PolCd = (JSPUtil.getParameter(request, prefix + "pre_3_pol_cd", length));
            String[] d2 = (JSPUtil.getParameter(request, prefix + "d2", length));
            String[] ovrHgt = (JSPUtil.getParameter(request, prefix + "ovr_hgt", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] currPage = (JSPUtil.getParameter(request, prefix + "curr_page", length));
            String[] rnum = (JSPUtil.getParameter(request, prefix + "rnum", length));
            String[] post4Vvd = (JSPUtil.getParameter(request, prefix + "post_4_vvd", length));
            String[] pre1PodCd = (JSPUtil.getParameter(request, prefix + "pre_1_pod_cd", length));
            String[] bbCmdt = (JSPUtil.getParameter(request, prefix + "bb_cmdt", length));
            String[] custToOrdFlg = (JSPUtil.getParameter(request, prefix + "cust_to_ord_flg", length));
            String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", length));
            String[] post4PodCd = (JSPUtil.getParameter(request, prefix + "post_4_pod_cd", length));
            String[] cgoSeq = (JSPUtil.getParameter(request, prefix + "cgo_seq", length));
            String[] totalFeu = (JSPUtil.getParameter(request, prefix + "total_feu", length));
            String[] consigneeName = (JSPUtil.getParameter(request, prefix + "consignee_name", length));
            String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg", length));
            String[] netWgt = (JSPUtil.getParameter(request, prefix + "net_wgt", length));
            String[] pkg = (JSPUtil.getParameter(request, prefix + "pkg", length));
            String[] bkgCnt = (JSPUtil.getParameter(request, prefix + "bkg_cnt", length));
            String[] rdTotalO2 = (JSPUtil.getParameter(request, prefix + "rd_total_o2", length));
            String[] cntrVentTpCd = (JSPUtil.getParameter(request, prefix + "cntr_vent_tp_cd", length));
            String[] rdTotalO4 = (JSPUtil.getParameter(request, prefix + "rd_total_o4", length));
            String[] pre3Vvd = (JSPUtil.getParameter(request, prefix + "pre_3_vvd", length));
            String[] rdTotalF4 = (JSPUtil.getParameter(request, prefix + "rd_total_f4", length));
            String[] ntfyName = (JSPUtil.getParameter(request, prefix + "ntfy_name", length));
            String[] rdTotalF5 = (JSPUtil.getParameter(request, prefix + "rd_total_f5", length));
            String[] t4 = (JSPUtil.getParameter(request, prefix + "t4", length));
            String[] totalBl = (JSPUtil.getParameter(request, prefix + "total_bl", length));
            String[] post3Vvd = (JSPUtil.getParameter(request, prefix + "post_3_vvd", length));
            String[] rfCmdt = (JSPUtil.getParameter(request, prefix + "rf_cmdt", length));
            String[] orderby = (JSPUtil.getParameter(request, prefix + "orderby", length));
            String[] modiAtmsFlg = (JSPUtil.getParameter(request, prefix + "modi_atms_flg", length));
            String[] teu = (JSPUtil.getParameter(request, prefix + "teu", length));
            String[] cntrVolQty = (JSPUtil.getParameter(request, prefix + "cntr_vol_qty", length));
            String[] grsWgt = (JSPUtil.getParameter(request, prefix + "grs_wgt", length));
            String[] splitFlg = (JSPUtil.getParameter(request, prefix + "split_flg", length));
            String[] t2 = (JSPUtil.getParameter(request, prefix + "t2", length));
            String[] shprName = (JSPUtil.getParameter(request, prefix + "shpr_name", length));
            String[] dgCmdt = (JSPUtil.getParameter(request, prefix + "dg_cmdt", length));
            String[] orgTrnsSvcModCd = (JSPUtil.getParameter(request, prefix + "org_trns_svc_mod_cd", length));
            String[] bdrFlg = (JSPUtil.getParameter(request, prefix + "bdr_flg", length));
            String[] trunkVvd = (JSPUtil.getParameter(request, prefix + "trunk_vvd", length));
            String[] stowage = (JSPUtil.getParameter(request, prefix + "stowage", length));
            String[] hotDeFlg = (JSPUtil.getParameter(request, prefix + "hot_de_flg", length));
            String[] eqSubstFlg = (JSPUtil.getParameter(request, prefix + "eq_subst_flg", length));
            String[] bkgMeaQty = (JSPUtil.getParameter(request, prefix + "bkg_mea_qty", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] dimLen = (JSPUtil.getParameter(request, prefix + "dim_len", length));
            String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix + "bb_cgo_flg", length));
            String[] dcgoFlg = (JSPUtil.getParameter(request, prefix + "dcgo_flg", length));
            String[] measQty = (JSPUtil.getParameter(request, prefix + "meas_qty", length));
            String[] exptName = (JSPUtil.getParameter(request, prefix + "expt_name", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] pre2Vvd = (JSPUtil.getParameter(request, prefix + "pre_2_vvd", length));
            String[] orderbyTitle = (JSPUtil.getParameter(request, prefix + "orderby_title", length));
            String[] ffdr = (JSPUtil.getParameter(request, prefix + "ffdr", length));
            String[] orgSvcRoute = (JSPUtil.getParameter(request, prefix + "org_svc_route", length));
            String[] rdTotalT2 = (JSPUtil.getParameter(request, prefix + "rd_total_t2", length));
            String[] rdTotalT4 = (JSPUtil.getParameter(request, prefix + "rd_total_t4", length));
            String[] pre2PodCd = (JSPUtil.getParameter(request, prefix + "pre_2_pod_cd", length));
            String[] rdTotalD4 = (JSPUtil.getParameter(request, prefix + "rd_total_d4", length));
            String[] socFlg = (JSPUtil.getParameter(request, prefix + "soc_flg", length));
            String[] rdTotalD5 = (JSPUtil.getParameter(request, prefix + "rd_total_d5", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] akrepCmdt = (JSPUtil.getParameter(request, prefix + "akrep_cmdt", length));
            String[] pre1PolCd = (JSPUtil.getParameter(request, prefix + "pre_1_pol_cd", length));
            String[] rdTotalD2 = (JSPUtil.getParameter(request, prefix + "rd_total_d2", length));
            String[] vltgNo = (JSPUtil.getParameter(request, prefix + "vltg_no", length));
            String[] post2Vvd = (JSPUtil.getParameter(request, prefix + "post_2_vvd", length));
            String[] cdoTemp = (JSPUtil.getParameter(request, prefix + "cdo_temp", length));
            String[] commodity = (JSPUtil.getParameter(request, prefix + "commodity", length));
            String[] ovrBkwdLen = (JSPUtil.getParameter(request, prefix + "ovr_bkwd_len", length));
            String[] pre4Vvd = (JSPUtil.getParameter(request, prefix + "pre_4_vvd", length));
            String[] rdTotalD7 = (JSPUtil.getParameter(request, prefix + "rd_total_d7", length));
            String[] hngrFlg = (JSPUtil.getParameter(request, prefix + "hngr_flg", length));
            String[] orderbyCnt = (JSPUtil.getParameter(request, prefix + "orderby_cnt", length));
            String[] ffdrName = (JSPUtil.getParameter(request, prefix + "ffdr_name", length));
            String[] prpShpNm = (JSPUtil.getParameter(request, prefix + "prp_shp_nm", length));
            String[] r2 = (JSPUtil.getParameter(request, prefix + "r2", length));
            String[] post2PolCd = (JSPUtil.getParameter(request, prefix + "post_2_pol_cd", length));
            String[] blCnt = (JSPUtil.getParameter(request, prefix + "bl_cnt", length));
            String[] r4 = (JSPUtil.getParameter(request, prefix + "r4", length));
            String[] r5 = (JSPUtil.getParameter(request, prefix + "r5", length));
            String[] o5 = (JSPUtil.getParameter(request, prefix + "o5", length));
            String[] rdTotalO5 = (JSPUtil.getParameter(request, prefix + "rd_total_o5", length));
            String[] atfcAtmsFlg = (JSPUtil.getParameter(request, prefix + "atfc_atms_flg", length));
            String[] o7 = (JSPUtil.getParameter(request, prefix + "o7", length));
            String[] rdTotalO7 = (JSPUtil.getParameter(request, prefix + "rd_total_o7", length));
            for (int i = 0; i < length; i++) {
                model = new StatusReportSpecialCargoOutVO();
                if (destSvcRoute[i] != null)
                    model.setDestSvcRoute(destSvcRoute[i]);
                if (p4[i] != null)
                    model.setP4(p4[i]);
                if (p2[i] != null)
                    model.setP2(p2[i]);
                if (pwrSplCblFlg[i] != null)
                    model.setPwrSplCblFlg(pwrSplCblFlg[i]);
                if (no[i] != null)
                    model.setNo(no[i]);
                if (spclCgoAuthKnt[i] != null)
                    model.setSpclCgoAuthKnt(spclCgoAuthKnt[i]);
                if (z4[i] != null)
                    model.setZ4(z4[i]);
                if (z2[i] != null)
                    model.setZ2(z2[i]);
                if (post3PolCd[i] != null)
                    model.setPost3PolCd(post3PolCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (obSrepCd[i] != null)
                    model.setObSrepCd(obSrepCd[i]);
                if (rowsPerPage[i] != null)
                    model.setRowsPerPage(rowsPerPage[i]);
                if (destTrnsSvcModCd[i] != null)
                    model.setDestTrnsSvcModCd(destTrnsSvcModCd[i]);
                if (dimWdt[i] != null)
                    model.setDimWdt(dimWdt[i]);
                if (ctrlAtmsFlg[i] != null)
                    model.setCtrlAtmsFlg(ctrlAtmsFlg[i]);
                if (rdTotalR9[i] != null)
                    model.setRdTotalR9(rdTotalR9[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (bkgCreDt[i] != null)
                    model.setBkgCreDt(bkgCreDt[i]);
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
                if (imdgUnNo[i] != null)
                    model.setImdgUnNo(imdgUnNo[i]);
                if (bkgOfcCd[i] != null)
                    model.setBkgOfcCd(bkgOfcCd[i]);
                if (feu[i] != null)
                    model.setFeu(feu[i]);
                if (q2[i] != null)
                    model.setQ2(q2[i]);
                if (orderbyTitleSql[i] != null)
                    model.setOrderbyTitleSql(orderbyTitleSql[i]);
                if (q4[i] != null)
                    model.setQ4(q4[i]);
                if (dimHgt[i] != null)
                    model.setDimHgt(dimHgt[i]);
                if (post3PodCd[i] != null)
                    model.setPost3PodCd(post3PodCd[i]);
                if (post1PolCd[i] != null)
                    model.setPost1PolCd(post1PolCd[i]);
                if (post1Vvd[i] != null)
                    model.setPost1Vvd(post1Vvd[i]);
                if (ovrRtLen[i] != null)
                    model.setOvrRtLen(ovrRtLen[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (rdTotalZ2[i] != null)
                    model.setRdTotalZ2(rdTotalZ2[i]);
                if (rowSeq[i] != null)
                    model.setRowSeq(rowSeq[i]);
                if (rdTotalZ4[i] != null)
                    model.setRdTotalZ4(rdTotalZ4[i]);
                if (rcFlg[i] != null)
                    model.setRcFlg(rcFlg[i]);
                if (ovrFwrdLen[i] != null)
                    model.setOvrFwrdLen(ovrFwrdLen[i]);
                if (imdgClssCd[i] != null)
                    model.setImdgClssCd(imdgClssCd[i]);
                if (totalTeu[i] != null)
                    model.setTotalTeu(totalTeu[i]);
                if (emerCntcPhnNoCtnt[i] != null)
                    model.setEmerCntcPhnNoCtnt(emerCntcPhnNoCtnt[i]);
                if (imdgPckGrpCd[i] != null)
                    model.setImdgPckGrpCd(imdgPckGrpCd[i]);
                if (rdCgoFlg[i] != null)
                    model.setRdCgoFlg(rdCgoFlg[i]);
                if (pre3PodCd[i] != null)
                    model.setPre3PodCd(pre3PodCd[i]);
                if (flshPntCdoTemp[i] != null)
                    model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
                if (consignee[i] != null)
                    model.setConsignee(consignee[i]);
                if (bkgClzFlg[i] != null)
                    model.setBkgClzFlg(bkgClzFlg[i]);
                if (ovrVoidSltQty[i] != null)
                    model.setOvrVoidSltQty(ovrVoidSltQty[i]);
                if (contact[i] != null)
                    model.setContact(contact[i]);
                if (bkgStf[i] != null)
                    model.setBkgStf(bkgStf[i]);
                if (spclCgoAproCd[i] != null)
                    model.setSpclCgoAproCd(spclCgoAproCd[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (totalWgt[i] != null)
                    model.setTotalWgt(totalWgt[i]);
                if (rdTotalP4[i] != null)
                    model.setRdTotalP4(rdTotalP4[i]);
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (f2[i] != null)
                    model.setF2(f2[i]);
                if (f5[i] != null)
                    model.setF5(f5[i]);
                if (rdTotalP2[i] != null)
                    model.setRdTotalP2(rdTotalP2[i]);
                if (post2PodCd[i] != null)
                    model.setPost2PodCd(post2PodCd[i]);
                if (f4[i] != null)
                    model.setF4(f4[i]);
                if (dgCntrSeq[i] != null)
                    model.setDgCntrSeq(dgCntrSeq[i]);
                if (pre2PolCd[i] != null)
                    model.setPre2PolCd(pre2PolCd[i]);
                if (o2[i] != null)
                    model.setO2(o2[i]);
                if (o4[i] != null)
                    model.setO4(o4[i]);
                if (antyName[i] != null)
                    model.setAntyName(antyName[i]);
                if (totalMea[i] != null)
                    model.setTotalMea(totalMea[i]);
                if (shipper[i] != null)
                    model.setShipper(shipper[i]);
                if (pre4PolCd[i] != null)
                    model.setPre4PolCd(pre4PolCd[i]);
                if (fdoTemp[i] != null)
                    model.setFdoTemp(fdoTemp[i]);
                if (ovrLfLen[i] != null)
                    model.setOvrLfLen(ovrLfLen[i]);
                if (remarkDetail[i] != null)
                    model.setRemarkDetail(remarkDetail[i]);
                if (post4PolCd[i] != null)
                    model.setPost4PolCd(post4PolCd[i]);
                if (humidNo[i] != null)
                    model.setHumidNo(humidNo[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (bstFlg[i] != null)
                    model.setBstFlg(bstFlg[i]);
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
                if (humidCtrlFlg[i] != null)
                    model.setHumidCtrlFlg(humidCtrlFlg[i]);
                if (ntfy[i] != null)
                    model.setNtfy(ntfy[i]);
                if (post1PodCd[i] != null)
                    model.setPost1PodCd(post1PodCd[i]);
                if (remark[i] != null)
                    model.setRemark(remark[i]);
                if (pre1Vvd[i] != null)
                    model.setPre1Vvd(pre1Vvd[i]);
                if (totalBkg[i] != null)
                    model.setTotalBkg(totalBkg[i]);
                if (tel[i] != null)
                    model.setTel(tel[i]);
                if (rdTotalF2[i] != null)
                    model.setRdTotalF2(rdTotalF2[i]);
                if (d5[i] != null)
                    model.setD5(d5[i]);
                if (d4[i] != null)
                    model.setD4(d4[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pre4PodCd[i] != null)
                    model.setPre4PodCd(pre4PodCd[i]);
                if (d7[i] != null)
                    model.setD7(d7[i]);
                if (pre3PolCd[i] != null)
                    model.setPre3PolCd(pre3PolCd[i]);
                if (d2[i] != null)
                    model.setD2(d2[i]);
                if (ovrHgt[i] != null)
                    model.setOvrHgt(ovrHgt[i]);
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
                if (bbCmdt[i] != null)
                    model.setBbCmdt(bbCmdt[i]);
                if (custToOrdFlg[i] != null)
                    model.setCustToOrdFlg(custToOrdFlg[i]);
                if (obSlsOfcCd[i] != null)
                    model.setObSlsOfcCd(obSlsOfcCd[i]);
                if (post4PodCd[i] != null)
                    model.setPost4PodCd(post4PodCd[i]);
                if (cgoSeq[i] != null)
                    model.setCgoSeq(cgoSeq[i]);
                if (totalFeu[i] != null)
                    model.setTotalFeu(totalFeu[i]);
                if (consigneeName[i] != null)
                    model.setConsigneeName(consigneeName[i]);
                if (awkCgoFlg[i] != null)
                    model.setAwkCgoFlg(awkCgoFlg[i]);
                if (netWgt[i] != null)
                    model.setNetWgt(netWgt[i]);
                if (pkg[i] != null)
                    model.setPkg(pkg[i]);
                if (bkgCnt[i] != null)
                    model.setBkgCnt(bkgCnt[i]);
                if (rdTotalO2[i] != null)
                    model.setRdTotalO2(rdTotalO2[i]);
                if (cntrVentTpCd[i] != null)
                    model.setCntrVentTpCd(cntrVentTpCd[i]);
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
                if (t4[i] != null)
                    model.setT4(t4[i]);
                if (totalBl[i] != null)
                    model.setTotalBl(totalBl[i]);
                if (post3Vvd[i] != null)
                    model.setPost3Vvd(post3Vvd[i]);
                if (rfCmdt[i] != null)
                    model.setRfCmdt(rfCmdt[i]);
                if (orderby[i] != null)
                    model.setOrderby(orderby[i]);
                if (modiAtmsFlg[i] != null)
                    model.setModiAtmsFlg(modiAtmsFlg[i]);
                if (teu[i] != null)
                    model.setTeu(teu[i]);
                if (cntrVolQty[i] != null)
                    model.setCntrVolQty(cntrVolQty[i]);
                if (grsWgt[i] != null)
                    model.setGrsWgt(grsWgt[i]);
                if (splitFlg[i] != null)
                    model.setSplitFlg(splitFlg[i]);
                if (t2[i] != null)
                    model.setT2(t2[i]);
                if (shprName[i] != null)
                    model.setShprName(shprName[i]);
                if (dgCmdt[i] != null)
                    model.setDgCmdt(dgCmdt[i]);
                if (orgTrnsSvcModCd[i] != null)
                    model.setOrgTrnsSvcModCd(orgTrnsSvcModCd[i]);
                if (bdrFlg[i] != null)
                    model.setBdrFlg(bdrFlg[i]);
                if (trunkVvd[i] != null)
                    model.setTrunkVvd(trunkVvd[i]);
                if (stowage[i] != null)
                    model.setStowage(stowage[i]);
                if (hotDeFlg[i] != null)
                    model.setHotDeFlg(hotDeFlg[i]);
                if (eqSubstFlg[i] != null)
                    model.setEqSubstFlg(eqSubstFlg[i]);
                if (bkgMeaQty[i] != null)
                    model.setBkgMeaQty(bkgMeaQty[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (dimLen[i] != null)
                    model.setDimLen(dimLen[i]);
                if (bbCgoFlg[i] != null)
                    model.setBbCgoFlg(bbCgoFlg[i]);
                if (dcgoFlg[i] != null)
                    model.setDcgoFlg(dcgoFlg[i]);
                if (measQty[i] != null)
                    model.setMeasQty(measQty[i]);
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
                if (orgSvcRoute[i] != null)
                    model.setOrgSvcRoute(orgSvcRoute[i]);
                if (rdTotalT2[i] != null)
                    model.setRdTotalT2(rdTotalT2[i]);
                if (rdTotalT4[i] != null)
                    model.setRdTotalT4(rdTotalT4[i]);
                if (pre2PodCd[i] != null)
                    model.setPre2PodCd(pre2PodCd[i]);
                if (rdTotalD4[i] != null)
                    model.setRdTotalD4(rdTotalD4[i]);
                if (socFlg[i] != null)
                    model.setSocFlg(socFlg[i]);
                if (rdTotalD5[i] != null)
                    model.setRdTotalD5(rdTotalD5[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (akrepCmdt[i] != null)
                    model.setAkrepCmdt(akrepCmdt[i]);
                if (pre1PolCd[i] != null)
                    model.setPre1PolCd(pre1PolCd[i]);
                if (rdTotalD2[i] != null)
                    model.setRdTotalD2(rdTotalD2[i]);
                if (vltgNo[i] != null)
                    model.setVltgNo(vltgNo[i]);
                if (post2Vvd[i] != null)
                    model.setPost2Vvd(post2Vvd[i]);
                if (cdoTemp[i] != null)
                    model.setCdoTemp(cdoTemp[i]);
                if (commodity[i] != null)
                    model.setCommodity(commodity[i]);
                if (ovrBkwdLen[i] != null)
                    model.setOvrBkwdLen(ovrBkwdLen[i]);
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
                if (prpShpNm[i] != null)
                    model.setPrpShpNm(prpShpNm[i]);
                if (r2[i] != null)
                    model.setR2(r2[i]);
                if (post2PolCd[i] != null)
                    model.setPost2PolCd(post2PolCd[i]);
                if (blCnt[i] != null)
                    model.setBlCnt(blCnt[i]);
                if (r4[i] != null)
                    model.setR4(r4[i]);
                if (r5[i] != null)
                    model.setR5(r5[i]);
                if (o5[i] != null)
                    model.setO5(o5[i]);
                if (rdTotalO5[i] != null)
                    model.setRdTotalO5(rdTotalO5[i]);
                if (atfcAtmsFlg[i] != null)
                    model.setAtfcAtmsFlg(atfcAtmsFlg[i]);
                if (o7[i] != null)
                    model.setO7(o7[i]);
                if (rdTotalO7[i] != null)
                    model.setRdTotalO7(rdTotalO7[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getStatusReportSpecialCargoOutVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return StatusReportSpecialCargoOutVO[]
	 */
    public StatusReportSpecialCargoOutVO[] getStatusReportSpecialCargoOutVOs() {
        StatusReportSpecialCargoOutVO[] vos = (StatusReportSpecialCargoOutVO[]) models.toArray(new StatusReportSpecialCargoOutVO[models.size()]);
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
        this.destSvcRoute = this.destSvcRoute.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.p4 = this.p4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.p2 = this.p2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pwrSplCblFlg = this.pwrSplCblFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.no = this.no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthKnt = this.spclCgoAuthKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.z4 = this.z4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.z2 = this.z2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post3PolCd = this.post3PolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obSrepCd = this.obSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowsPerPage = this.rowsPerPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.destTrnsSvcModCd = this.destTrnsSvcModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dimWdt = this.dimWdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrlAtmsFlg = this.ctrlAtmsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalR9 = this.rdTotalR9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCreDt = this.bkgCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalR4 = this.rdTotalR4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalR5 = this.rdTotalR5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siFlg = this.siFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalR2 = this.rdTotalR2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalCnt = this.totalCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNo = this.imdgUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgOfcCd = this.bkgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.feu = this.feu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.q2 = this.q2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orderbyTitleSql = this.orderbyTitleSql.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.q4 = this.q4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dimHgt = this.dimHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post3PodCd = this.post3PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post1PolCd = this.post1PolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post1Vvd = this.post1Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrRtLen = this.ovrRtLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalZ2 = this.rdTotalZ2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowSeq = this.rowSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalZ4 = this.rdTotalZ4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrFwrdLen = this.ovrFwrdLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgClssCd = this.imdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalTeu = this.totalTeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerCntcPhnNoCtnt = this.emerCntcPhnNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgPckGrpCd = this.imdgPckGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCgoFlg = this.rdCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre3PodCd = this.pre3PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flshPntCdoTemp = this.flshPntCdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.consignee = this.consignee.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgClzFlg = this.bkgClzFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrVoidSltQty = this.ovrVoidSltQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.contact = this.contact.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStf = this.bkgStf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAproCd = this.spclCgoAproCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalWgt = this.totalWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalP4 = this.rdTotalP4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.f2 = this.f2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.f5 = this.f5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalP2 = this.rdTotalP2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post2PodCd = this.post2PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.f4 = this.f4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgCntrSeq = this.dgCntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre2PolCd = this.pre2PolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.o2 = this.o2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.o4 = this.o4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.antyName = this.antyName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalMea = this.totalMea.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shipper = this.shipper.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre4PolCd = this.pre4PolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fdoTemp = this.fdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrLfLen = this.ovrLfLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.remarkDetail = this.remarkDetail.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post4PolCd = this.post4PolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.humidNo = this.humidNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bstFlg = this.bstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalQ2 = this.rdTotalQ2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lastOrderby = this.lastOrderby.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalQ4 = this.rdTotalQ4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rep = this.rep.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.humidCtrlFlg = this.humidCtrlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfy = this.ntfy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post1PodCd = this.post1PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.remark = this.remark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre1Vvd = this.pre1Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalBkg = this.totalBkg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tel = this.tel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalF2 = this.rdTotalF2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d5 = this.d5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d4 = this.d4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre4PodCd = this.pre4PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d7 = this.d7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre3PolCd = this.pre3PolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d2 = this.d2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrHgt = this.ovrHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currPage = this.currPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rnum = this.rnum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post4Vvd = this.post4Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre1PodCd = this.pre1PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCmdt = this.bbCmdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custToOrdFlg = this.custToOrdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obSlsOfcCd = this.obSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post4PodCd = this.post4PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoSeq = this.cgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalFeu = this.totalFeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.consigneeName = this.consigneeName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netWgt = this.netWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pkg = this.pkg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCnt = this.bkgCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalO2 = this.rdTotalO2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrVentTpCd = this.cntrVentTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalO4 = this.rdTotalO4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre3Vvd = this.pre3Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalF4 = this.rdTotalF4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyName = this.ntfyName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalF5 = this.rdTotalF5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.t4 = this.t4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalBl = this.totalBl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post3Vvd = this.post3Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfCmdt = this.rfCmdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orderby = this.orderby.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiAtmsFlg = this.modiAtmsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.teu = this.teu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrVolQty = this.cntrVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgt = this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.splitFlg = this.splitFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.t2 = this.t2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprName = this.shprName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgCmdt = this.dgCmdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgTrnsSvcModCd = this.orgTrnsSvcModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdrFlg = this.bdrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trunkVvd = this.trunkVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stowage = this.stowage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hotDeFlg = this.hotDeFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSubstFlg = this.eqSubstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgMeaQty = this.bkgMeaQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dimLen = this.dimLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoFlg = this.bbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoFlg = this.dcgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measQty = this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.exptName = this.exptName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre2Vvd = this.pre2Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orderbyTitle = this.orderbyTitle.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffdr = this.ffdr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgSvcRoute = this.orgSvcRoute.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalT2 = this.rdTotalT2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalT4 = this.rdTotalT4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre2PodCd = this.pre2PodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalD4 = this.rdTotalD4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.socFlg = this.socFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalD5 = this.rdTotalD5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.akrepCmdt = this.akrepCmdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre1PolCd = this.pre1PolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalD2 = this.rdTotalD2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vltgNo = this.vltgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post2Vvd = this.post2Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cdoTemp = this.cdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.commodity = this.commodity.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrBkwdLen = this.ovrBkwdLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre4Vvd = this.pre4Vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalD7 = this.rdTotalD7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hngrFlg = this.hngrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orderbyCnt = this.orderbyCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffdrName = this.ffdrName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prpShpNm = this.prpShpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r2 = this.r2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post2PolCd = this.post2PolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blCnt = this.blCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r4 = this.r4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r5 = this.r5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.o5 = this.o5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalO5 = this.rdTotalO5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.atfcAtmsFlg = this.atfcAtmsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.o7 = this.o7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotalO7 = this.rdTotalO7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
