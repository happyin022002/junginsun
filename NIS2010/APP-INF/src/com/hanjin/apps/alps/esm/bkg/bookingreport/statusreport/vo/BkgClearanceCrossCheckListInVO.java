/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgClearanceCrossCheckListINVO.java
*@FileTitle : BkgClearanceCrossCheckListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.27  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgClearanceCrossCheckListInVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgClearanceCrossCheckListInVO> models = new ArrayList<BkgClearanceCrossCheckListInVO>();

    /* Column Info */
    private String bkgCgoTpCd = null;

    /* Column Info */
    private String denseRank = null;

    /* Column Info */
    private String via = null;

    /* Column Info */
    private String totalCharge = null;

    /* Column Info */
    private String por = null;

    /* Column Info */
    private String totalCfm = null;

    /* Column Info */
    private String totalBkgF = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String rowsPerPage = null;

    /* Column Info */
    private String pBkgOfcCd = null;

    /* Column Info */
    private String ff = null;

    /* Column Info */
    private String pol = null;

    /* Column Info */
    private String totalBkgT = null;

    /* Column Info */
    private String totalCnt = null;

    /* Column Info */
    private String pDcgoFlg = null;

    /* Column Info */
    private String pPolCd = null;

    /* Column Info */
    private String pod = null;

    /* Column Info */
    private String pCustSeq = null;

    /* Column Info */
    private String pEqType = null;

    /* Column Info */
    private String pCnmvStsCd = null;

    /* Column Info */
    private String receiving = null;

    /* Column Info */
    private String pBkgStsCd = null;

    /* Column Info */
    private String statusComplete = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String dpcsRate = null;

    /* Column Info */
    private String pNoGood = null;

    /* Column Info */
    private String qtyCntr = null;

    /* Column Info */
    private String shipperCode = null;

    /* Column Info */
    private String rowsPerBkg = null;

    /* Column Info */
    private String pDelConti = null;

    /* Column Info */
    private String bkgStsCd = null;

    /* Column Info */
    private String consignee = null;

    /* Column Info */
    private String ctrRnum = null;

    /* Column Info */
    private String apprval = null;

    /* Column Info */
    private String totalIssue = null;

    /* Column Info */
    private String pRcvTermCd = null;

    /* Column Info */
    private String md = null;

    /* Column Info */
    private String bdr = null;

    /* Column Info */
    private String qtyBkg = null;

    /* Column Info */
    private String del = null;

    /* Column Info */
    private String totalCtrlT = null;

    /* Column Info */
    private String pDeTermCd = null;

    /* Column Info */
    private String dpcsF = null;

    /* Column Info */
    private String pPolYdCd = null;

    /* Column Info */
    private String porNodCd = null;

    /* Column Info */
    private String dpcsBlProof = null;

    /* Column Info */
    private String peb = null;

    /* Column Info */
    private String dpcsI = null;

    /* Column Info */
    private String firm = null;

    /* Column Info */
    private String shipper = null;

    /* Column Info */
    private String cntrCfmFlg = null;

    /* Column Info */
    private String totalCtrlF = null;

    /* Column Info */
    private String hitchmentYn = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String pRcFlg = null;

    /* Column Info */
    private String totalVl = null;

    /* Column Info */
    private String dpcsR = null;

    /* Column Info */
    private String broker = null;

    /* Column Info */
    private String pOblIssOfcCd = null;

    /* Column Info */
    private String dpcsQ = null;

    /* Column Info */
    private String elNo = null;

    /* Column Info */
    private String totalBkg = null;

    /* Column Info */
    private String pCustCntCd = null;

    /* Column Info */
    private String totalReceiving = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String pObSlsOfcCd = null;

    /* Column Info */
    private String pCtrtOfcCd = null;

    /* Column Info */
    private String pCtrtSrepCd = null;

    /* Column Info */
    private String currPage = null;

    /* Column Info */
    private String statusOpen = null;

    /* Column Info */
    private String rnum = null;

    /* Column Info */
    private String delNodCd = null;

    /* Column Info */
    private String obSlsOfcCd = null;

    /* Column Info */
    private String ctrtOfcCd = null;

    /* Column Info */
    private String aesYn = null;

    /* Column Info */
    private String st = null;

    /* Column Info */
    private String sz = null;

    /* Column Info */
    private String pVvd = null;

    /* Column Info */
    private String pDpcsFlg = null;

    /* Column Info */
    private String aes = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String tvvd = null;

    /* Column Info */
    private String pkg = null;

    /* Column Info */
    private String pAwkCgoFlg = null;

    /* Column Info */
    private String pBbCgoFlg = null;

    /* Column Info */
    private String pSiFlg = null;

    /* Column Info */
    private String cm = null;

    /* Column Info */
    private String taxId = null;

    /* Column Info */
    private String totalBl = null;

    /* Column Info */
    private String pObSrepCd = null;

    /* Column Info */
    private String pCustNm = null;

    /* Column Info */
    private String weight = null;

    /* Column Info */
    private String pApodLt = null;

    /* Column Info */
    private String dde = null;

    /* Column Info */
    private String totalApprval = null;

    /* Column Info */
    private String issue = null;

    /* Column Info */
    private String measuere = null;

    /* Column Info */
    private String specialR = null;

    /* Column Info */
    private String dpcsTtl = null;

    /* Column Info */
    private String vol = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String pOfcCd = null;

    /* Column Info */
    private String seal = null;

    /* Column Info */
    private String caed = null;

    /* Column Info */
    private String pDelCd = null;

    /* Column Info */
    private String pBdrFlg = null;

    /* Column Info */
    private String specialD = null;

    /* Column Info */
    private String specialA = null;

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String specialB = null;

    /* Column Info */
    private String bkgOfcNo = null;

    /* Column Info */
    private String totalCm = null;

    /* Column Info */
    private String dpcsSts = null;

    /* Column Info */
    private String pDocUsrId = null;

    /* Column Info */
    private String dpcsQa = null;

    /* Column Info */
    private String denseRank2 = null;

    /* Column Info */
    private String pPolLt = null;

    /* Column Info */
    private String pBkgCustTpCd = null;

    /* Column Info */
    private String deTermCd = null;

    /* Column Info */
    private String pZoneCd = null;

    /* Column Info */
    private String statusPending = null;

    /* Column Info */
    private String dpcsInput = null;

    /* Column Info */
    private String charge = null;

    /* Column Info */
    private String totalMd = null;

    /* Column Info */
    private String pPorCd = null;

    /* Column Info */
    private String pApodCd = null;

    /* Column Info */
    private String entrClssTpCd = null;

    /* Column Info */
    private String custTp = null;

    /* Column Info */
    private String multiVvd = null;

    /* Column Info */
    private String polEtdFrDt = null;

    /* Column Info */
    private String polEtdToDt = null;

    /* Column Info */
    private String keyVvd = null;

    /* Column Info */
    private String scNo = null;

    /* Column Info */
    private String cntrCheck = null;

    /* Column Info */
    private String chkDupVvd = null;

    /* Column Info */
    private String ffdr = null;

    /* Column Info */
    private String cntrWgt = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String pSocCgoFlg = null;

    /* Column Info */
    private String pSireadyFlg = null;

    /* Column Info */
    private String sireadyFlg = null;

    /* Column Info */
    private String lOfcSub = null;

    /* Column Info */
    private String cOfcSub = null;

    /* Column Info */
    private String measQty = null;

    /* Column Info */
    private String eventYard = null;

    /* Column Info */
    private String eventDt = null;

    /* Column Info */
    private String cntrCfmId = null;

    /* Column Info */
    private String vgmWgt = null;

    /* Column Info */
    private String vgmWgtUtCd = null;

    /* Column Info */
    private String totalVgmCnt = null;

    /* Column Info */
    private String vgmFlg = null;

    /* Column Info */
    private String totalCntrCnt = null;

    /* Column Info */
    private String totalNoVgmCnt = null;

    /* Column Info */
    private String vgmVrfySigCtnt = null;

    /* Column Info */
    private String vgmMzdTpCd = null;

    /* Column Info */
    private String blckStwgCd = null;

    /* Column Info */
    private String obSrepCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgClearanceCrossCheckListInVO() {
    }

    public BkgClearanceCrossCheckListInVO(String ibflag, String pagrows, String denseRank, String denseRank2, String aesYn, String pkg, String podCd, String qtyBkg, String qtyCntr, String rcvTermCd, String receiving, String rnum, String rowsPerPage, String shipper, String consignee, String specialA, String specialB, String specialD, String specialR, String st, String sz, String totalApprval, String totalBkg, String totalBkgF, String totalBkgT, String totalBl, String totalCfm, String totalCharge, String totalCm, String totalCnt, String totalCtrlF, String totalCtrlT, String totalIssue, String totalMd, String totalReceiving, String totalVl, String via, String vol, String weight, String aes, String apprval, String bdr, String bkgCgoTpCd, String bkgNo, String bkgStsCd, String blNo, String charge, String cm, String cntrCfmFlg, String cntrNo, String ctrRnum, String currPage, String deTermCd, String delCd, String ff, String firm, String issue, String md, String measuere, String obSlsOfcCd, String ctrtOfcCd, String pApodCd, String pApodLt, String pAwkCgoFlg, String pBbCgoFlg, String pBdrFlg, String pBkgCustTpCd, String pBkgOfcCd, String pBkgStsCd, String pCnmvStsCd, String pCustCntCd, String pCustNm, String pCustSeq, String pDcgoFlg, String pDeTermCd, String pDelCd, String pDocUsrId, String pEqType, String pNoGood, String pObSlsOfcCd, String pObSrepCd, String pCtrtOfcCd, String pCtrtSrepCd, String pOblIssOfcCd, String pOfcCd, String pPolCd, String pPolLt, String pPolYdCd, String pPorCd, String pRcFlg, String pRcvTermCd, String pSiFlg, String pVvd, String pZoneCd, String elNo, String dde, String peb, String caed, String seal, String taxId, String rowsPerBkg, String shipperCode, String por, String pol, String pod, String del, String porNodCd, String delNodCd, String broker, String bkgOfcNo, String hitchmentYn, String tvvd, String pDpcsFlg, String dpcsI, String dpcsR, String dpcsQ, String dpcsF, String dpcsSts, String dpcsTtl, String dpcsInput, String dpcsRate, String dpcsQa, String dpcsBlProof, String statusComplete, String statusPending, String statusOpen, String pDelConti, String entrClssTpCd, String custTp, String multiVvd, String polEtdFrDt, String polEtdToDt, String keyVvd, String scNo, String cntrCheck, String chkDupVvd, String ffdr, String cntrWgt, String wgtUtCd, String pSocCgoFlg, String pSireadyFlg, String sireadyFlg, String lOfcSub, String cOfcSub, String measQty, String eventYard, String eventDt, String cntrCfmId, String vgmWgt, String vgmWgtUtCd, String totalVgmCnt, String vgmFlg, String totalCntrCnt, String totalNoVgmCnt, String vgmVrfySigCtnt, String vgmMzdTpCd, String blckStwgCd, String obSrepCd) {
        this.bkgCgoTpCd = bkgCgoTpCd;
        this.denseRank = denseRank;
        this.via = via;
        this.totalCharge = totalCharge;
        this.por = por;
        this.totalCfm = totalCfm;
        this.totalBkgF = totalBkgF;
        this.pagerows = pagerows;
        this.rowsPerPage = rowsPerPage;
        this.pBkgOfcCd = pBkgOfcCd;
        this.ff = ff;
        this.pol = pol;
        this.totalBkgT = totalBkgT;
        this.totalCnt = totalCnt;
        this.pDcgoFlg = pDcgoFlg;
        this.pPolCd = pPolCd;
        this.pod = pod;
        this.pCustSeq = pCustSeq;
        this.pEqType = pEqType;
        this.pCnmvStsCd = pCnmvStsCd;
        this.receiving = receiving;
        this.pBkgStsCd = pBkgStsCd;
        this.statusComplete = statusComplete;
        this.podCd = podCd;
        this.bkgNo = bkgNo;
        this.dpcsRate = dpcsRate;
        this.pNoGood = pNoGood;
        this.qtyCntr = qtyCntr;
        this.shipperCode = shipperCode;
        this.rowsPerBkg = rowsPerBkg;
        this.pDelConti = pDelConti;
        this.bkgStsCd = bkgStsCd;
        this.consignee = consignee;
        this.ctrRnum = ctrRnum;
        this.apprval = apprval;
        this.totalIssue = totalIssue;
        this.pRcvTermCd = pRcvTermCd;
        this.md = md;
        this.bdr = bdr;
        this.qtyBkg = qtyBkg;
        this.del = del;
        this.totalCtrlT = totalCtrlT;
        this.pDeTermCd = pDeTermCd;
        this.dpcsF = dpcsF;
        this.pPolYdCd = pPolYdCd;
        this.porNodCd = porNodCd;
        this.dpcsBlProof = dpcsBlProof;
        this.peb = peb;
        this.dpcsI = dpcsI;
        this.firm = firm;
        this.shipper = shipper;
        this.cntrCfmFlg = cntrCfmFlg;
        this.totalCtrlF = totalCtrlF;
        this.hitchmentYn = hitchmentYn;
        this.cntrNo = cntrNo;
        this.pRcFlg = pRcFlg;
        this.totalVl = totalVl;
        this.dpcsR = dpcsR;
        this.broker = broker;
        this.pOblIssOfcCd = pOblIssOfcCd;
        this.dpcsQ = dpcsQ;
        this.elNo = elNo;
        this.totalBkg = totalBkg;
        this.pCustCntCd = pCustCntCd;
        this.totalReceiving = totalReceiving;
        this.blNo = blNo;
        this.pObSlsOfcCd = pObSlsOfcCd;
        this.pCtrtOfcCd = pCtrtOfcCd;
        this.pCtrtSrepCd = pCtrtSrepCd;
        this.currPage = currPage;
        this.statusOpen = statusOpen;
        this.rnum = rnum;
        this.delNodCd = delNodCd;
        this.obSlsOfcCd = obSlsOfcCd;
        this.ctrtOfcCd = ctrtOfcCd;
        this.aesYn = aesYn;
        this.st = st;
        this.sz = sz;
        this.pVvd = pVvd;
        this.pDpcsFlg = pDpcsFlg;
        this.aes = aes;
        this.delCd = delCd;
        this.tvvd = tvvd;
        this.pkg = pkg;
        this.pAwkCgoFlg = pAwkCgoFlg;
        this.pBbCgoFlg = pBbCgoFlg;
        this.pSiFlg = pSiFlg;
        this.cm = cm;
        this.taxId = taxId;
        this.totalBl = totalBl;
        this.pObSrepCd = pObSrepCd;
        this.pCustNm = pCustNm;
        this.weight = weight;
        this.pApodLt = pApodLt;
        this.dde = dde;
        this.totalApprval = totalApprval;
        this.issue = issue;
        this.measuere = measuere;
        this.specialR = specialR;
        this.dpcsTtl = dpcsTtl;
        this.vol = vol;
        this.ibflag = ibflag;
        this.pOfcCd = pOfcCd;
        this.seal = seal;
        this.caed = caed;
        this.pDelCd = pDelCd;
        this.pBdrFlg = pBdrFlg;
        this.specialD = specialD;
        this.specialA = specialA;
        this.rcvTermCd = rcvTermCd;
        this.specialB = specialB;
        this.bkgOfcNo = bkgOfcNo;
        this.totalCm = totalCm;
        this.dpcsSts = dpcsSts;
        this.pDocUsrId = pDocUsrId;
        this.dpcsQa = dpcsQa;
        this.denseRank2 = denseRank2;
        this.pPolLt = pPolLt;
        this.pBkgCustTpCd = pBkgCustTpCd;
        this.deTermCd = deTermCd;
        this.pZoneCd = pZoneCd;
        this.statusPending = statusPending;
        this.dpcsInput = dpcsInput;
        this.charge = charge;
        this.totalMd = totalMd;
        this.pPorCd = pPorCd;
        this.pApodCd = pApodCd;
        this.entrClssTpCd = entrClssTpCd;
        this.custTp = custTp;
        this.multiVvd = multiVvd;
        this.polEtdFrDt = polEtdFrDt;
        this.polEtdToDt = polEtdToDt;
        this.keyVvd = keyVvd;
        this.scNo = scNo;
        this.cntrCheck = cntrCheck;
        this.chkDupVvd = chkDupVvd;
        this.ffdr = ffdr;
        this.cntrWgt = cntrWgt;
        this.wgtUtCd = wgtUtCd;
        this.pSocCgoFlg = pSocCgoFlg;
        this.pSireadyFlg = pSireadyFlg;
        this.sireadyFlg = sireadyFlg;
        this.lOfcSub = lOfcSub;
        this.cOfcSub = cOfcSub;
        this.measQty = measQty;
        this.eventYard = eventYard;
        this.eventDt = eventDt;
        this.cntrCfmId = cntrCfmId;
        this.vgmWgt = vgmWgt;
        this.vgmWgtUtCd = vgmWgtUtCd;
        this.totalVgmCnt = totalVgmCnt;
        this.vgmFlg = vgmFlg;
        this.totalCntrCnt = totalCntrCnt;
        this.totalNoVgmCnt = totalNoVgmCnt;
        this.vgmVrfySigCtnt = vgmVrfySigCtnt;
        this.vgmMzdTpCd = vgmMzdTpCd;
        this.blckStwgCd = blckStwgCd;
        this.obSrepCd = obSrepCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
        this.hashColumns.put("dense_rank", getDenseRank());
        this.hashColumns.put("via", getVia());
        this.hashColumns.put("total_charge", getTotalCharge());
        this.hashColumns.put("por", getPor());
        this.hashColumns.put("total_cfm", getTotalCfm());
        this.hashColumns.put("total_bkg_f", getTotalBkgF());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("rows_per_page", getRowsPerPage());
        this.hashColumns.put("p_bkg_ofc_cd", getPBkgOfcCd());
        this.hashColumns.put("ff", getFf());
        this.hashColumns.put("pol", getPol());
        this.hashColumns.put("total_bkg_t", getTotalBkgT());
        this.hashColumns.put("total_cnt", getTotalCnt());
        this.hashColumns.put("p_dcgo_flg", getPDcgoFlg());
        this.hashColumns.put("p_pol_cd", getPPolCd());
        this.hashColumns.put("pod", getPod());
        this.hashColumns.put("p_cust_seq", getPCustSeq());
        this.hashColumns.put("p_eq_type", getPEqType());
        this.hashColumns.put("p_cnmv_sts_cd", getPCnmvStsCd());
        this.hashColumns.put("receiving", getReceiving());
        this.hashColumns.put("p_bkg_sts_cd", getPBkgStsCd());
        this.hashColumns.put("status_complete", getStatusComplete());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("dpcs_rate", getDpcsRate());
        this.hashColumns.put("p_no_good", getPNoGood());
        this.hashColumns.put("qty_cntr", getQtyCntr());
        this.hashColumns.put("shipper_code", getShipperCode());
        this.hashColumns.put("rows_per_bkg", getRowsPerBkg());
        this.hashColumns.put("p_del_conti", getPDelConti());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("consignee", getConsignee());
        this.hashColumns.put("ctr_rnum", getCtrRnum());
        this.hashColumns.put("apprval", getApprval());
        this.hashColumns.put("total_issue", getTotalIssue());
        this.hashColumns.put("p_rcv_term_cd", getPRcvTermCd());
        this.hashColumns.put("md", getMd());
        this.hashColumns.put("bdr", getBdr());
        this.hashColumns.put("qty_bkg", getQtyBkg());
        this.hashColumns.put("del", getDel());
        this.hashColumns.put("total_ctrl_t", getTotalCtrlT());
        this.hashColumns.put("p_de_term_cd", getPDeTermCd());
        this.hashColumns.put("dpcs_f", getDpcsF());
        this.hashColumns.put("p_pol_yd_cd", getPPolYdCd());
        this.hashColumns.put("por_nod_cd", getPorNodCd());
        this.hashColumns.put("dpcs_bl_proof", getDpcsBlProof());
        this.hashColumns.put("peb", getPeb());
        this.hashColumns.put("dpcs_i", getDpcsI());
        this.hashColumns.put("firm", getFirm());
        this.hashColumns.put("shipper", getShipper());
        this.hashColumns.put("cntr_cfm_flg", getCntrCfmFlg());
        this.hashColumns.put("total_ctrl_f", getTotalCtrlF());
        this.hashColumns.put("hitchment_yn", getHitchmentYn());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("p_rc_flg", getPRcFlg());
        this.hashColumns.put("total_vl", getTotalVl());
        this.hashColumns.put("dpcs_r", getDpcsR());
        this.hashColumns.put("broker", getBroker());
        this.hashColumns.put("p_obl_iss_ofc_cd", getPOblIssOfcCd());
        this.hashColumns.put("dpcs_q", getDpcsQ());
        this.hashColumns.put("el_no", getElNo());
        this.hashColumns.put("total_bkg", getTotalBkg());
        this.hashColumns.put("p_cust_cnt_cd", getPCustCntCd());
        this.hashColumns.put("total_receiving", getTotalReceiving());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("p_ob_sls_ofc_cd", getPObSlsOfcCd());
        this.hashColumns.put("p_ctrt_ofc_cd", getPCtrtOfcCd());
        this.hashColumns.put("p_ctrt_srep_cd", getPCtrtSrepCd());
        this.hashColumns.put("curr_page", getCurrPage());
        this.hashColumns.put("status_open", getStatusOpen());
        this.hashColumns.put("rnum", getRnum());
        this.hashColumns.put("del_nod_cd", getDelNodCd());
        this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
        this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
        this.hashColumns.put("aes_yn", getAesYn());
        this.hashColumns.put("st", getSt());
        this.hashColumns.put("sz", getSz());
        this.hashColumns.put("p_vvd", getPVvd());
        this.hashColumns.put("p_dpcs_flg", getPDpcsFlg());
        this.hashColumns.put("aes", getAes());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("tvvd", getTvvd());
        this.hashColumns.put("pkg", getPkg());
        this.hashColumns.put("p_awk_cgo_flg", getPAwkCgoFlg());
        this.hashColumns.put("p_bb_cgo_flg", getPBbCgoFlg());
        this.hashColumns.put("p_si_flg", getPSiFlg());
        this.hashColumns.put("cm", getCm());
        this.hashColumns.put("tax_id", getTaxId());
        this.hashColumns.put("total_bl", getTotalBl());
        this.hashColumns.put("p_ob_srep_cd", getPObSrepCd());
        this.hashColumns.put("p_cust_nm", getPCustNm());
        this.hashColumns.put("weight", getWeight());
        this.hashColumns.put("p_apod_lt", getPApodLt());
        this.hashColumns.put("dde", getDde());
        this.hashColumns.put("total_apprval", getTotalApprval());
        this.hashColumns.put("issue", getIssue());
        this.hashColumns.put("measuere", getMeasuere());
        this.hashColumns.put("special_r", getSpecialR());
        this.hashColumns.put("dpcs_ttl", getDpcsTtl());
        this.hashColumns.put("vol", getVol());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("p_ofc_cd", getPOfcCd());
        this.hashColumns.put("seal", getSeal());
        this.hashColumns.put("caed", getCaed());
        this.hashColumns.put("p_del_cd", getPDelCd());
        this.hashColumns.put("p_bdr_flg", getPBdrFlg());
        this.hashColumns.put("special_d", getSpecialD());
        this.hashColumns.put("special_a", getSpecialA());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("special_b", getSpecialB());
        this.hashColumns.put("bkg_ofc_no", getBkgOfcNo());
        this.hashColumns.put("total_cm", getTotalCm());
        this.hashColumns.put("dpcs_sts", getDpcsSts());
        this.hashColumns.put("p_doc_usr_id", getPDocUsrId());
        this.hashColumns.put("dpcs_qa", getDpcsQa());
        this.hashColumns.put("dense_rank2", getDenseRank2());
        this.hashColumns.put("p_pol_lt", getPPolLt());
        this.hashColumns.put("p_bkg_cust_tp_cd", getPBkgCustTpCd());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("p_zone_cd", getPZoneCd());
        this.hashColumns.put("status_pending", getStatusPending());
        this.hashColumns.put("dpcs_input", getDpcsInput());
        this.hashColumns.put("charge", getCharge());
        this.hashColumns.put("total_md", getTotalMd());
        this.hashColumns.put("p_por_cd", getPPorCd());
        this.hashColumns.put("p_apod_cd", getPApodCd());
        this.hashColumns.put("entr_clss_tp_cd", getEntrClssTpCd());
        this.hashColumns.put("cust_tp", getCustTp());
        this.hashColumns.put("multi_vvd", getMultiVvd());
        this.hashColumns.put("pol_etd_fr_dt", getPolEtdFrDt());
        this.hashColumns.put("pol_etd_to_dt", getPolEtdToDt());
        this.hashColumns.put("key_vvd", getKeyVvd());
        this.hashColumns.put("sc_no", getScNo());
        this.hashColumns.put("cntr_check", getCntrCheck());
        this.hashColumns.put("chk_dup_vvd", getChkDupVvd());
        this.hashColumns.put("ffdr", getFfdr());
        this.hashColumns.put("cntr_wgt", getCntrWgt());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("p_soc_cgo_flg", getPSocCgoFlg());
        this.hashColumns.put("p_si_ready_flg", getPSireadyFlg());
        this.hashColumns.put("si_ready_flg", getSireadyFlg());
        this.hashColumns.put("l_ofc_sub", getLOfcSub());
        this.hashColumns.put("c_ofc_sub", getCOfcSub());
        this.hashColumns.put("meas_qty", getMeasQty());
        this.hashColumns.put("event_yard", getEventYard());
        this.hashColumns.put("event_dt", getEventDt());
        this.hashColumns.put("cntr_cfm_id", getCntrCfmId());
        this.hashColumns.put("vgm_wgt", getVgmWgt());
        this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
        this.hashColumns.put("total_vgm_cnt", getTotalVgmCnt());
        this.hashColumns.put("vgm_flg", getVgmFlg());
        this.hashColumns.put("total_cntr_cnt", getTotalCntrCnt());
        this.hashColumns.put("total_no_vgm_cnt", getTotalNoVgmCnt());
        this.hashColumns.put("vgm_vrfy_sig_ctnt", getVgmVrfySigCtnt());
        this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());
        this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
        this.hashColumns.put("ob_srep_cd", getObSrepCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
        this.hashFields.put("dense_rank", "denseRank");
        this.hashFields.put("via", "via");
        this.hashFields.put("total_charge", "totalCharge");
        this.hashFields.put("por", "por");
        this.hashFields.put("total_cfm", "totalCfm");
        this.hashFields.put("total_bkg_f", "totalBkgF");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("rows_per_page", "rowsPerPage");
        this.hashFields.put("p_bkg_ofc_cd", "pBkgOfcCd");
        this.hashFields.put("ff", "ff");
        this.hashFields.put("pol", "pol");
        this.hashFields.put("total_bkg_t", "totalBkgT");
        this.hashFields.put("total_cnt", "totalCnt");
        this.hashFields.put("p_dcgo_flg", "pDcgoFlg");
        this.hashFields.put("p_pol_cd", "pPolCd");
        this.hashFields.put("pod", "pod");
        this.hashFields.put("p_cust_seq", "pCustSeq");
        this.hashFields.put("p_eq_type", "pEqType");
        this.hashFields.put("p_cnmv_sts_cd", "pCnmvStsCd");
        this.hashFields.put("receiving", "receiving");
        this.hashFields.put("p_bkg_sts_cd", "pBkgStsCd");
        this.hashFields.put("status_complete", "statusComplete");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("dpcs_rate", "dpcsRate");
        this.hashFields.put("p_no_good", "pNoGood");
        this.hashFields.put("qty_cntr", "qtyCntr");
        this.hashFields.put("shipper_code", "shipperCode");
        this.hashFields.put("rows_per_bkg", "rowsPerBkg");
        this.hashFields.put("p_del_conti", "pDelConti");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("consignee", "consignee");
        this.hashFields.put("ctr_rnum", "ctrRnum");
        this.hashFields.put("apprval", "apprval");
        this.hashFields.put("total_issue", "totalIssue");
        this.hashFields.put("p_rcv_term_cd", "pRcvTermCd");
        this.hashFields.put("md", "md");
        this.hashFields.put("bdr", "bdr");
        this.hashFields.put("qty_bkg", "qtyBkg");
        this.hashFields.put("del", "del");
        this.hashFields.put("total_ctrl_t", "totalCtrlT");
        this.hashFields.put("p_de_term_cd", "pDeTermCd");
        this.hashFields.put("dpcs_f", "dpcsF");
        this.hashFields.put("p_pol_yd_cd", "pPolYdCd");
        this.hashFields.put("por_nod_cd", "porNodCd");
        this.hashFields.put("dpcs_bl_proof", "dpcsBlProof");
        this.hashFields.put("peb", "peb");
        this.hashFields.put("dpcs_i", "dpcsI");
        this.hashFields.put("firm", "firm");
        this.hashFields.put("shipper", "shipper");
        this.hashFields.put("cntr_cfm_flg", "cntrCfmFlg");
        this.hashFields.put("total_ctrl_f", "totalCtrlF");
        this.hashFields.put("hitchment_yn", "hitchmentYn");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("p_rc_flg", "pRcFlg");
        this.hashFields.put("total_vl", "totalVl");
        this.hashFields.put("dpcs_r", "dpcsR");
        this.hashFields.put("broker", "broker");
        this.hashFields.put("p_obl_iss_ofc_cd", "pOblIssOfcCd");
        this.hashFields.put("dpcs_q", "dpcsQ");
        this.hashFields.put("el_no", "elNo");
        this.hashFields.put("total_bkg", "totalBkg");
        this.hashFields.put("p_cust_cnt_cd", "pCustCntCd");
        this.hashFields.put("total_receiving", "totalReceiving");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("p_ob_sls_ofc_cd", "pObSlsOfcCd");
        this.hashFields.put("p_ctrt_ofc_cd", "pCtrtOfcCd");
        this.hashFields.put("p_ctrt_srep_cd", "pCtrtSrepCd");
        this.hashFields.put("curr_page", "currPage");
        this.hashFields.put("status_open", "statusOpen");
        this.hashFields.put("rnum", "rnum");
        this.hashFields.put("del_nod_cd", "delNodCd");
        this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
        this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
        this.hashFields.put("aes_yn", "aesYn");
        this.hashFields.put("st", "st");
        this.hashFields.put("sz", "sz");
        this.hashFields.put("p_vvd", "pVvd");
        this.hashFields.put("p_dpcs_flg", "pDpcsFlg");
        this.hashFields.put("aes", "aes");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("tvvd", "tvvd");
        this.hashFields.put("pkg", "pkg");
        this.hashFields.put("p_awk_cgo_flg", "pAwkCgoFlg");
        this.hashFields.put("p_bb_cgo_flg", "pBbCgoFlg");
        this.hashFields.put("p_si_flg", "pSiFlg");
        this.hashFields.put("cm", "cm");
        this.hashFields.put("tax_id", "taxId");
        this.hashFields.put("total_bl", "totalBl");
        this.hashFields.put("p_ob_srep_cd", "pObSrepCd");
        this.hashFields.put("p_cust_nm", "pCustNm");
        this.hashFields.put("weight", "weight");
        this.hashFields.put("p_apod_lt", "pApodLt");
        this.hashFields.put("dde", "dde");
        this.hashFields.put("total_apprval", "totalApprval");
        this.hashFields.put("issue", "issue");
        this.hashFields.put("measuere", "measuere");
        this.hashFields.put("special_r", "specialR");
        this.hashFields.put("dpcs_ttl", "dpcsTtl");
        this.hashFields.put("vol", "vol");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("p_ofc_cd", "pOfcCd");
        this.hashFields.put("seal", "seal");
        this.hashFields.put("caed", "caed");
        this.hashFields.put("p_del_cd", "pDelCd");
        this.hashFields.put("p_bdr_flg", "pBdrFlg");
        this.hashFields.put("special_d", "specialD");
        this.hashFields.put("special_a", "specialA");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("special_b", "specialB");
        this.hashFields.put("bkg_ofc_no", "bkgOfcNo");
        this.hashFields.put("total_cm", "totalCm");
        this.hashFields.put("dpcs_sts", "dpcsSts");
        this.hashFields.put("p_doc_usr_id", "pDocUsrId");
        this.hashFields.put("dpcs_qa", "dpcsQa");
        this.hashFields.put("dense_rank2", "denseRank2");
        this.hashFields.put("p_pol_lt", "pPolLt");
        this.hashFields.put("p_bkg_cust_tp_cd", "pBkgCustTpCd");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("p_zone_cd", "pZoneCd");
        this.hashFields.put("status_pending", "statusPending");
        this.hashFields.put("dpcs_input", "dpcsInput");
        this.hashFields.put("charge", "charge");
        this.hashFields.put("total_md", "totalMd");
        this.hashFields.put("p_por_cd", "pPorCd");
        this.hashFields.put("p_apod_cd", "pApodCd");
        this.hashFields.put("entr_clss_tp_cd", "entrClssTpCd");
        this.hashFields.put("cust_tp", "custTp");
        this.hashFields.put("multi_vvd", "multiVvd");
        this.hashFields.put("pol_etd_fr_dt", "polEtdFrDt");
        this.hashFields.put("pol_etd_to_dt", "polEtdToDt");
        this.hashFields.put("key_vvd", "keyVvd");
        this.hashFields.put("sc_no", "scNo");
        this.hashFields.put("cntr_check", "cntrCheck");
        this.hashFields.put("chk_dup_vvd", "chkDupVvd");
        this.hashFields.put("ffdr", "ffdr");
        this.hashFields.put("cntr_wgt", "cntrWgt");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("p_soc_cgo_flg", "pSocCgoFlg");
        this.hashFields.put("p_si_ready_flg", "pSireadyFlg");
        this.hashFields.put("si_ready_flg", "sireadyFlg");
        this.hashFields.put("l_ofc_sub", "lOfcSub");
        this.hashFields.put("c_ofc_sub", "cOfcSub");
        this.hashFields.put("meas_qty", "measQty");
        this.hashFields.put("event_yard", "eventYard");
        this.hashFields.put("event_dt", "eventDt");
        this.hashFields.put("cntr_cfm_id", "cntrCfmId");
        this.hashFields.put("vgm_wgt", "vgmWgt");
        this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
        this.hashFields.put("total_vgm_cnt", "totalVgmCnt");
        this.hashFields.put("vgm_flg", "vgmFlg");
        this.hashFields.put("total_cntr_cnt", "totalCntrCnt");
        this.hashFields.put("total_no_vgm_cnt", "totalNoVgmCnt");
        this.hashFields.put("vgm_vrfy_sig_ctnt", "vgmVrfySigCtnt");
        this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
        this.hashFields.put("blck_stwg_cd", "blckStwgCd");
        this.hashFields.put("ob_srep_cd", "obSrepCd");
        return this.hashFields;
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
	 * @return denseRank
	 */
    public String getDenseRank() {
        return this.denseRank;
    }

    /**
	 * Column Info
	 * @return via
	 */
    public String getVia() {
        return this.via;
    }

    /**
	 * Column Info
	 * @return totalCharge
	 */
    public String getTotalCharge() {
        return this.totalCharge;
    }

    /**
	 * Column Info
	 * @return por
	 */
    public String getPor() {
        return this.por;
    }

    /**
	 * Column Info
	 * @return totalCfm
	 */
    public String getTotalCfm() {
        return this.totalCfm;
    }

    /**
	 * Column Info
	 * @return totalBkgF
	 */
    public String getTotalBkgF() {
        return this.totalBkgF;
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
	 * @return rowsPerPage
	 */
    public String getRowsPerPage() {
        return this.rowsPerPage;
    }

    /**
	 * Column Info
	 * @return pBkgOfcCd
	 */
    public String getPBkgOfcCd() {
        return this.pBkgOfcCd;
    }

    /**
	 * Column Info
	 * @return ff
	 */
    public String getFf() {
        return this.ff;
    }

    /**
	 * Column Info
	 * @return pol
	 */
    public String getPol() {
        return this.pol;
    }

    /**
	 * Column Info
	 * @return totalBkgT
	 */
    public String getTotalBkgT() {
        return this.totalBkgT;
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
	 * @return pDcgoFlg
	 */
    public String getPDcgoFlg() {
        return this.pDcgoFlg;
    }

    /**
	 * Column Info
	 * @return pPolCd
	 */
    public String getPPolCd() {
        return this.pPolCd;
    }

    /**
	 * Column Info
	 * @return pod
	 */
    public String getPod() {
        return this.pod;
    }

    /**
	 * Column Info
	 * @return pCustSeq
	 */
    public String getPCustSeq() {
        return this.pCustSeq;
    }

    /**
	 * Column Info
	 * @return pEqType
	 */
    public String getPEqType() {
        return this.pEqType;
    }

    /**
	 * Column Info
	 * @return pCnmvStsCd
	 */
    public String getPCnmvStsCd() {
        return this.pCnmvStsCd;
    }

    /**
	 * Column Info
	 * @return receiving
	 */
    public String getReceiving() {
        return this.receiving;
    }

    /**
	 * Column Info
	 * @return pBkgStsCd
	 */
    public String getPBkgStsCd() {
        return this.pBkgStsCd;
    }

    /**
	 * Column Info
	 * @return statusComplete
	 */
    public String getStatusComplete() {
        return this.statusComplete;
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
	 * @return dpcsRate
	 */
    public String getDpcsRate() {
        return this.dpcsRate;
    }

    /**
	 * Column Info
	 * @return pNoGood
	 */
    public String getPNoGood() {
        return this.pNoGood;
    }

    /**
	 * Column Info
	 * @return qtyCntr
	 */
    public String getQtyCntr() {
        return this.qtyCntr;
    }

    /**
	 * Column Info
	 * @return shipperCode
	 */
    public String getShipperCode() {
        return this.shipperCode;
    }

    /**
	 * Column Info
	 * @return rowsPerBkg
	 */
    public String getRowsPerBkg() {
        return this.rowsPerBkg;
    }

    /**
	 * Column Info
	 * @return pDelConti
	 */
    public String getPDelConti() {
        return this.pDelConti;
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
	 * @return ctrRnum
	 */
    public String getCtrRnum() {
        return this.ctrRnum;
    }

    /**
	 * Column Info
	 * @return apprval
	 */
    public String getApprval() {
        return this.apprval;
    }

    /**
	 * Column Info
	 * @return totalIssue
	 */
    public String getTotalIssue() {
        return this.totalIssue;
    }

    /**
	 * Column Info
	 * @return pRcvTermCd
	 */
    public String getPRcvTermCd() {
        return this.pRcvTermCd;
    }

    /**
	 * Column Info
	 * @return md
	 */
    public String getMd() {
        return this.md;
    }

    /**
	 * Column Info
	 * @return bdr
	 */
    public String getBdr() {
        return this.bdr;
    }

    /**
	 * Column Info
	 * @return qtyBkg
	 */
    public String getQtyBkg() {
        return this.qtyBkg;
    }

    /**
	 * Column Info
	 * @return del
	 */
    public String getDel() {
        return this.del;
    }

    /**
	 * Column Info
	 * @return totalCtrlT
	 */
    public String getTotalCtrlT() {
        return this.totalCtrlT;
    }

    /**
	 * Column Info
	 * @return pDeTermCd
	 */
    public String getPDeTermCd() {
        return this.pDeTermCd;
    }

    /**
	 * Column Info
	 * @return dpcsF
	 */
    public String getDpcsF() {
        return this.dpcsF;
    }

    /**
	 * Column Info
	 * @return pPolYdCd
	 */
    public String getPPolYdCd() {
        return this.pPolYdCd;
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
	 * @return dpcsBlProof
	 */
    public String getDpcsBlProof() {
        return this.dpcsBlProof;
    }

    /**
	 * Column Info
	 * @return peb
	 */
    public String getPeb() {
        return this.peb;
    }

    /**
	 * Column Info
	 * @return dpcsI
	 */
    public String getDpcsI() {
        return this.dpcsI;
    }

    /**
	 * Column Info
	 * @return firm
	 */
    public String getFirm() {
        return this.firm;
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
	 * @return cntrCfmFlg
	 */
    public String getCntrCfmFlg() {
        return this.cntrCfmFlg;
    }

    /**
	 * Column Info
	 * @return totalCtrlF
	 */
    public String getTotalCtrlF() {
        return this.totalCtrlF;
    }

    /**
	 * Column Info
	 * @return hitchmentYn
	 */
    public String getHitchmentYn() {
        return this.hitchmentYn;
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
	 * @return pRcFlg
	 */
    public String getPRcFlg() {
        return this.pRcFlg;
    }

    /**
	 * Column Info
	 * @return totalVl
	 */
    public String getTotalVl() {
        return this.totalVl;
    }

    /**
	 * Column Info
	 * @return dpcsR
	 */
    public String getDpcsR() {
        return this.dpcsR;
    }

    /**
	 * Column Info
	 * @return broker
	 */
    public String getBroker() {
        return this.broker;
    }

    /**
	 * Column Info
	 * @return pOblIssOfcCd
	 */
    public String getPOblIssOfcCd() {
        return this.pOblIssOfcCd;
    }

    /**
	 * Column Info
	 * @return dpcsQ
	 */
    public String getDpcsQ() {
        return this.dpcsQ;
    }

    /**
	 * Column Info
	 * @return elNo
	 */
    public String getElNo() {
        return this.elNo;
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
	 * @return pCustCntCd
	 */
    public String getPCustCntCd() {
        return this.pCustCntCd;
    }

    /**
	 * Column Info
	 * @return totalReceiving
	 */
    public String getTotalReceiving() {
        return this.totalReceiving;
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
	 * @return pObSlsOfcCd
	 */
    public String getPObSlsOfcCd() {
        return this.pObSlsOfcCd;
    }

    /**
	 * Column Info
	 * @return pCtrtOfcCd
	 */
    public String getPCtrtOfcCd() {
        return this.pCtrtOfcCd;
    }

    /**
	 * Column Info
	 * @return pCtrtSrepCd
	 */
    public String getPCtrtSrepCd() {
        return this.pCtrtSrepCd;
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
	 * @return statusOpen
	 */
    public String getStatusOpen() {
        return this.statusOpen;
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
	 * @return delNodCd
	 */
    public String getDelNodCd() {
        return this.delNodCd;
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
	 * @return ctrtOfcCd
	 */
    public String getCtrtOfcCd() {
        return this.ctrtOfcCd;
    }

    /**
	 * Column Info
	 * @return aesYn
	 */
    public String getAesYn() {
        return this.aesYn;
    }

    /**
	 * Column Info
	 * @return st
	 */
    public String getSt() {
        return this.st;
    }

    /**
	 * Column Info
	 * @return sz
	 */
    public String getSz() {
        return this.sz;
    }

    /**
	 * Column Info
	 * @return pVvd
	 */
    public String getPVvd() {
        return this.pVvd;
    }

    /**
	 * Column Info
	 * @return pDpcsFlg
	 */
    public String getPDpcsFlg() {
        return this.pDpcsFlg;
    }

    /**
	 * Column Info
	 * @return aes
	 */
    public String getAes() {
        return this.aes;
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
	 * @return pkg
	 */
    public String getPkg() {
        return this.pkg;
    }

    /**
	 * Column Info
	 * @return pAwkCgoFlg
	 */
    public String getPAwkCgoFlg() {
        return this.pAwkCgoFlg;
    }

    /**
	 * Column Info
	 * @return pBbCgoFlg
	 */
    public String getPBbCgoFlg() {
        return this.pBbCgoFlg;
    }

    /**
	 * Column Info
	 * @return pSiFlg
	 */
    public String getPSiFlg() {
        return this.pSiFlg;
    }

    /**
	 * Column Info
	 * @return cm
	 */
    public String getCm() {
        return this.cm;
    }

    /**
	 * Column Info
	 * @return taxId
	 */
    public String getTaxId() {
        return this.taxId;
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
	 * @return pObSrepCd
	 */
    public String getPObSrepCd() {
        return this.pObSrepCd;
    }

    /**
	 * Column Info
	 * @return pCustNm
	 */
    public String getPCustNm() {
        return this.pCustNm;
    }

    /**
	 * Column Info
	 * @return weight
	 */
    public String getWeight() {
        return this.weight;
    }

    /**
	 * Column Info
	 * @return pApodLt
	 */
    public String getPApodLt() {
        return this.pApodLt;
    }

    /**
	 * Column Info
	 * @return dde
	 */
    public String getDde() {
        return this.dde;
    }

    /**
	 * Column Info
	 * @return totalApprval
	 */
    public String getTotalApprval() {
        return this.totalApprval;
    }

    /**
	 * Column Info
	 * @return issue
	 */
    public String getIssue() {
        return this.issue;
    }

    /**
	 * Column Info
	 * @return measuere
	 */
    public String getMeasuere() {
        return this.measuere;
    }

    /**
	 * Column Info
	 * @return specialR
	 */
    public String getSpecialR() {
        return this.specialR;
    }

    /**
	 * Column Info
	 * @return dpcsTtl
	 */
    public String getDpcsTtl() {
        return this.dpcsTtl;
    }

    /**
	 * Column Info
	 * @return vol
	 */
    public String getVol() {
        return this.vol;
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
	 * @return pOfcCd
	 */
    public String getPOfcCd() {
        return this.pOfcCd;
    }

    /**
	 * Column Info
	 * @return seal
	 */
    public String getSeal() {
        return this.seal;
    }

    /**
	 * Column Info
	 * @return caed
	 */
    public String getCaed() {
        return this.caed;
    }

    /**
	 * Column Info
	 * @return pDelCd
	 */
    public String getPDelCd() {
        return this.pDelCd;
    }

    /**
	 * Column Info
	 * @return pBdrFlg
	 */
    public String getPBdrFlg() {
        return this.pBdrFlg;
    }

    /**
	 * Column Info
	 * @return specialD
	 */
    public String getSpecialD() {
        return this.specialD;
    }

    /**
	 * Column Info
	 * @return specialA
	 */
    public String getSpecialA() {
        return this.specialA;
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
	 * @return specialB
	 */
    public String getSpecialB() {
        return this.specialB;
    }

    /**
	 * Column Info
	 * @return bkgOfcNo
	 */
    public String getBkgOfcNo() {
        return this.bkgOfcNo;
    }

    /**
	 * Column Info
	 * @return totalCm
	 */
    public String getTotalCm() {
        return this.totalCm;
    }

    /**
	 * Column Info
	 * @return dpcsSts
	 */
    public String getDpcsSts() {
        return this.dpcsSts;
    }

    /**
	 * Column Info
	 * @return pDocUsrId
	 */
    public String getPDocUsrId() {
        return this.pDocUsrId;
    }

    /**
	 * Column Info
	 * @return dpcsQa
	 */
    public String getDpcsQa() {
        return this.dpcsQa;
    }

    /**
	 * Column Info
	 * @return denseRank2
	 */
    public String getDenseRank2() {
        return this.denseRank2;
    }

    /**
	 * Column Info
	 * @return pPolLt
	 */
    public String getPPolLt() {
        return this.pPolLt;
    }

    /**
	 * Column Info
	 * @return pBkgCustTpCd
	 */
    public String getPBkgCustTpCd() {
        return this.pBkgCustTpCd;
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
	 * @return pZoneCd
	 */
    public String getPZoneCd() {
        return this.pZoneCd;
    }

    /**
	 * Column Info
	 * @return statusPending
	 */
    public String getStatusPending() {
        return this.statusPending;
    }

    /**
	 * Column Info
	 * @return dpcsInput
	 */
    public String getDpcsInput() {
        return this.dpcsInput;
    }

    /**
	 * Column Info
	 * @return charge
	 */
    public String getCharge() {
        return this.charge;
    }

    /**
	 * Column Info
	 * @return totalMd
	 */
    public String getTotalMd() {
        return this.totalMd;
    }

    /**
	 * Column Info
	 * @return pPorCd
	 */
    public String getPPorCd() {
        return this.pPorCd;
    }

    /**
	 * Column Info
	 * @return pApodCd
	 */
    public String getPApodCd() {
        return this.pApodCd;
    }

    /**
	 * Column Info
	 * @return entrClssTpCd
	 */
    public String getEntrClssTpCd() {
        return this.entrClssTpCd;
    }

    /**
	 * Column Info
	 * @return custTp
	 */
    public String getCustTp() {
        return this.custTp;
    }

    /**
	 * Column Info
	 * @return multiVvd
	 */
    public String getMultiVvd() {
        return this.multiVvd;
    }

    /**
	 * Column Info
	 * @return polEtdFrDt
	 */
    public String getPolEtdFrDt() {
        return this.polEtdFrDt;
    }

    /**
	 * Column Info
	 * @return polEtdToDt
	 */
    public String getPolEtdToDt() {
        return this.polEtdToDt;
    }

    /**
	 * Column Info
	 * @return keyVvd
	 */
    public String getKeyVvd() {
        return this.keyVvd;
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
	 * @return cntrCheck
	 */
    public String getCntrCheck() {
        return this.cntrCheck;
    }

    /**
	 * Column Info
	 * @return chkDupVvd
	 */
    public String getChkDupVvd() {
        return this.chkDupVvd;
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
	 * @return lOfcSub
	 */
    public String getLOfcSub() {
        return this.lOfcSub;
    }

    /**
	 * Column Info
	 * @return cOfcSub
	 */
    public String getCOfcSub() {
        return this.cOfcSub;
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
	 * @return eventYard
	 */
    public String getEventYard() {
        return this.eventYard;
    }

    /**
	 * Column Info
	 * @return eventDt
	 */
    public String getEventDt() {
        return this.eventDt;
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
	 * @param denseRank
	 */
    public void setDenseRank(String denseRank) {
        this.denseRank = denseRank;
    }

    /**
	 * Column Info
	 * @param via
	 */
    public void setVia(String via) {
        this.via = via;
    }

    /**
	 * Column Info
	 * @param totalCharge
	 */
    public void setTotalCharge(String totalCharge) {
        this.totalCharge = totalCharge;
    }

    /**
	 * Column Info
	 * @param por
	 */
    public void setPor(String por) {
        this.por = por;
    }

    /**
	 * Column Info
	 * @param totalCfm
	 */
    public void setTotalCfm(String totalCfm) {
        this.totalCfm = totalCfm;
    }

    /**
	 * Column Info
	 * @param totalBkgF
	 */
    public void setTotalBkgF(String totalBkgF) {
        this.totalBkgF = totalBkgF;
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
	 * @param rowsPerPage
	 */
    public void setRowsPerPage(String rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    /**
	 * Column Info
	 * @param pBkgOfcCd
	 */
    public void setPBkgOfcCd(String pBkgOfcCd) {
        this.pBkgOfcCd = pBkgOfcCd;
    }

    /**
	 * Column Info
	 * @param ff
	 */
    public void setFf(String ff) {
        this.ff = ff;
    }

    /**
	 * Column Info
	 * @param pol
	 */
    public void setPol(String pol) {
        this.pol = pol;
    }

    /**
	 * Column Info
	 * @param totalBkgT
	 */
    public void setTotalBkgT(String totalBkgT) {
        this.totalBkgT = totalBkgT;
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
	 * @param pDcgoFlg
	 */
    public void setPDcgoFlg(String pDcgoFlg) {
        this.pDcgoFlg = pDcgoFlg;
    }

    /**
	 * Column Info
	 * @param pPolCd
	 */
    public void setPPolCd(String pPolCd) {
        this.pPolCd = pPolCd;
    }

    /**
	 * Column Info
	 * @param pod
	 */
    public void setPod(String pod) {
        this.pod = pod;
    }

    /**
	 * Column Info
	 * @param pCustSeq
	 */
    public void setPCustSeq(String pCustSeq) {
        this.pCustSeq = pCustSeq;
    }

    /**
	 * Column Info
	 * @param pEqType
	 */
    public void setPEqType(String pEqType) {
        this.pEqType = pEqType;
    }

    /**
	 * Column Info
	 * @param pCnmvStsCd
	 */
    public void setPCnmvStsCd(String pCnmvStsCd) {
        this.pCnmvStsCd = pCnmvStsCd;
    }

    /**
	 * Column Info
	 * @param receiving
	 */
    public void setReceiving(String receiving) {
        this.receiving = receiving;
    }

    /**
	 * Column Info
	 * @param pBkgStsCd
	 */
    public void setPBkgStsCd(String pBkgStsCd) {
        this.pBkgStsCd = pBkgStsCd;
    }

    /**
	 * Column Info
	 * @param statusComplete
	 */
    public void setStatusComplete(String statusComplete) {
        this.statusComplete = statusComplete;
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
	 * @param dpcsRate
	 */
    public void setDpcsRate(String dpcsRate) {
        this.dpcsRate = dpcsRate;
    }

    /**
	 * Column Info
	 * @param pNoGood
	 */
    public void setPNoGood(String pNoGood) {
        this.pNoGood = pNoGood;
    }

    /**
	 * Column Info
	 * @param qtyCntr
	 */
    public void setQtyCntr(String qtyCntr) {
        this.qtyCntr = qtyCntr;
    }

    /**
	 * Column Info
	 * @param shipperCode
	 */
    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    /**
	 * Column Info
	 * @param rowsPerBkg
	 */
    public void setRowsPerBkg(String rowsPerBkg) {
        this.rowsPerBkg = rowsPerBkg;
    }

    /**
	 * Column Info
	 * @param pDelConti
	 */
    public void setPDelConti(String pDelConti) {
        this.pDelConti = pDelConti;
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
	 * @param ctrRnum
	 */
    public void setCtrRnum(String ctrRnum) {
        this.ctrRnum = ctrRnum;
    }

    /**
	 * Column Info
	 * @param apprval
	 */
    public void setApprval(String apprval) {
        this.apprval = apprval;
    }

    /**
	 * Column Info
	 * @param totalIssue
	 */
    public void setTotalIssue(String totalIssue) {
        this.totalIssue = totalIssue;
    }

    /**
	 * Column Info
	 * @param pRcvTermCd
	 */
    public void setPRcvTermCd(String pRcvTermCd) {
        this.pRcvTermCd = pRcvTermCd;
    }

    /**
	 * Column Info
	 * @param md
	 */
    public void setMd(String md) {
        this.md = md;
    }

    /**
	 * Column Info
	 * @param bdr
	 */
    public void setBdr(String bdr) {
        this.bdr = bdr;
    }

    /**
	 * Column Info
	 * @param qtyBkg
	 */
    public void setQtyBkg(String qtyBkg) {
        this.qtyBkg = qtyBkg;
    }

    /**
	 * Column Info
	 * @param del
	 */
    public void setDel(String del) {
        this.del = del;
    }

    /**
	 * Column Info
	 * @param totalCtrlT
	 */
    public void setTotalCtrlT(String totalCtrlT) {
        this.totalCtrlT = totalCtrlT;
    }

    /**
	 * Column Info
	 * @param pDeTermCd
	 */
    public void setPDeTermCd(String pDeTermCd) {
        this.pDeTermCd = pDeTermCd;
    }

    /**
	 * Column Info
	 * @param dpcsF
	 */
    public void setDpcsF(String dpcsF) {
        this.dpcsF = dpcsF;
    }

    /**
	 * Column Info
	 * @param pPolYdCd
	 */
    public void setPPolYdCd(String pPolYdCd) {
        this.pPolYdCd = pPolYdCd;
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
	 * @param dpcsBlProof
	 */
    public void setDpcsBlProof(String dpcsBlProof) {
        this.dpcsBlProof = dpcsBlProof;
    }

    /**
	 * Column Info
	 * @param peb
	 */
    public void setPeb(String peb) {
        this.peb = peb;
    }

    /**
	 * Column Info
	 * @param dpcsI
	 */
    public void setDpcsI(String dpcsI) {
        this.dpcsI = dpcsI;
    }

    /**
	 * Column Info
	 * @param firm
	 */
    public void setFirm(String firm) {
        this.firm = firm;
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
	 * @param cntrCfmFlg
	 */
    public void setCntrCfmFlg(String cntrCfmFlg) {
        this.cntrCfmFlg = cntrCfmFlg;
    }

    /**
	 * Column Info
	 * @param totalCtrlF
	 */
    public void setTotalCtrlF(String totalCtrlF) {
        this.totalCtrlF = totalCtrlF;
    }

    /**
	 * Column Info
	 * @param hitchmentYn
	 */
    public void setHitchmentYn(String hitchmentYn) {
        this.hitchmentYn = hitchmentYn;
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
	 * @param pRcFlg
	 */
    public void setPRcFlg(String pRcFlg) {
        this.pRcFlg = pRcFlg;
    }

    /**
	 * Column Info
	 * @param totalVl
	 */
    public void setTotalVl(String totalVl) {
        this.totalVl = totalVl;
    }

    /**
	 * Column Info
	 * @param dpcsR
	 */
    public void setDpcsR(String dpcsR) {
        this.dpcsR = dpcsR;
    }

    /**
	 * Column Info
	 * @param broker
	 */
    public void setBroker(String broker) {
        this.broker = broker;
    }

    /**
	 * Column Info
	 * @param pOblIssOfcCd
	 */
    public void setPOblIssOfcCd(String pOblIssOfcCd) {
        this.pOblIssOfcCd = pOblIssOfcCd;
    }

    /**
	 * Column Info
	 * @param dpcsQ
	 */
    public void setDpcsQ(String dpcsQ) {
        this.dpcsQ = dpcsQ;
    }

    /**
	 * Column Info
	 * @param elNo
	 */
    public void setElNo(String elNo) {
        this.elNo = elNo;
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
	 * @param pCustCntCd
	 */
    public void setPCustCntCd(String pCustCntCd) {
        this.pCustCntCd = pCustCntCd;
    }

    /**
	 * Column Info
	 * @param totalReceiving
	 */
    public void setTotalReceiving(String totalReceiving) {
        this.totalReceiving = totalReceiving;
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
	 * @param pObSlsOfcCd
	 */
    public void setPObSlsOfcCd(String pObSlsOfcCd) {
        this.pObSlsOfcCd = pObSlsOfcCd;
    }

    /**
	 * Column Info
	 * @param pCtrtOfcCd
	 */
    public void setPCtrtOfcCd(String pCtrtOfcCd) {
        this.pCtrtOfcCd = pCtrtOfcCd;
    }

    /**
	 * Column Info
	 * @param pCtrtSrepCd
	 */
    public void setPCtrtSrepCd(String pCtrtSrepCd) {
        this.pCtrtSrepCd = pCtrtSrepCd;
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
	 * @param statusOpen
	 */
    public void setStatusOpen(String statusOpen) {
        this.statusOpen = statusOpen;
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
	 * @param delNodCd
	 */
    public void setDelNodCd(String delNodCd) {
        this.delNodCd = delNodCd;
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
	 * @param ctrtOfcCd
	 */
    public void setCtrtOfcCd(String ctrtOfcCd) {
        this.ctrtOfcCd = ctrtOfcCd;
    }

    /**
	 * Column Info
	 * @param aesYn
	 */
    public void setAesYn(String aesYn) {
        this.aesYn = aesYn;
    }

    /**
	 * Column Info
	 * @param st
	 */
    public void setSt(String st) {
        this.st = st;
    }

    /**
	 * Column Info
	 * @param sz
	 */
    public void setSz(String sz) {
        this.sz = sz;
    }

    /**
	 * Column Info
	 * @param pVvd
	 */
    public void setPVvd(String pVvd) {
        this.pVvd = pVvd;
    }

    /**
	 * Column Info
	 * @param pDpcsFlg
	 */
    public void setPDpcsFlg(String pDpcsFlg) {
        this.pDpcsFlg = pDpcsFlg;
    }

    /**
	 * Column Info
	 * @param aes
	 */
    public void setAes(String aes) {
        this.aes = aes;
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
	 * @param pkg
	 */
    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    /**
	 * Column Info
	 * @param pAwkCgoFlg
	 */
    public void setPAwkCgoFlg(String pAwkCgoFlg) {
        this.pAwkCgoFlg = pAwkCgoFlg;
    }

    /**
	 * Column Info
	 * @param pBbCgoFlg
	 */
    public void setPBbCgoFlg(String pBbCgoFlg) {
        this.pBbCgoFlg = pBbCgoFlg;
    }

    /**
	 * Column Info
	 * @param pSiFlg
	 */
    public void setPSiFlg(String pSiFlg) {
        this.pSiFlg = pSiFlg;
    }

    /**
	 * Column Info
	 * @param cm
	 */
    public void setCm(String cm) {
        this.cm = cm;
    }

    /**
	 * Column Info
	 * @param taxId
	 */
    public void setTaxId(String taxId) {
        this.taxId = taxId;
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
	 * @param pObSrepCd
	 */
    public void setPObSrepCd(String pObSrepCd) {
        this.pObSrepCd = pObSrepCd;
    }

    /**
	 * Column Info
	 * @param pCustNm
	 */
    public void setPCustNm(String pCustNm) {
        this.pCustNm = pCustNm;
    }

    /**
	 * Column Info
	 * @param weight
	 */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
	 * Column Info
	 * @param pApodLt
	 */
    public void setPApodLt(String pApodLt) {
        this.pApodLt = pApodLt;
    }

    /**
	 * Column Info
	 * @param dde
	 */
    public void setDde(String dde) {
        this.dde = dde;
    }

    /**
	 * Column Info
	 * @param totalApprval
	 */
    public void setTotalApprval(String totalApprval) {
        this.totalApprval = totalApprval;
    }

    /**
	 * Column Info
	 * @param issue
	 */
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
	 * Column Info
	 * @param measuere
	 */
    public void setMeasuere(String measuere) {
        this.measuere = measuere;
    }

    /**
	 * Column Info
	 * @param specialR
	 */
    public void setSpecialR(String specialR) {
        this.specialR = specialR;
    }

    /**
	 * Column Info
	 * @param dpcsTtl
	 */
    public void setDpcsTtl(String dpcsTtl) {
        this.dpcsTtl = dpcsTtl;
    }

    /**
	 * Column Info
	 * @param vol
	 */
    public void setVol(String vol) {
        this.vol = vol;
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
	 * @param pOfcCd
	 */
    public void setPOfcCd(String pOfcCd) {
        this.pOfcCd = pOfcCd;
    }

    /**
	 * Column Info
	 * @param seal
	 */
    public void setSeal(String seal) {
        this.seal = seal;
    }

    /**
	 * Column Info
	 * @param caed
	 */
    public void setCaed(String caed) {
        this.caed = caed;
    }

    /**
	 * Column Info
	 * @param pDelCd
	 */
    public void setPDelCd(String pDelCd) {
        this.pDelCd = pDelCd;
    }

    /**
	 * Column Info
	 * @param pBdrFlg
	 */
    public void setPBdrFlg(String pBdrFlg) {
        this.pBdrFlg = pBdrFlg;
    }

    /**
	 * Column Info
	 * @param specialD
	 */
    public void setSpecialD(String specialD) {
        this.specialD = specialD;
    }

    /**
	 * Column Info
	 * @param specialA
	 */
    public void setSpecialA(String specialA) {
        this.specialA = specialA;
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
	 * @param specialB
	 */
    public void setSpecialB(String specialB) {
        this.specialB = specialB;
    }

    /**
	 * Column Info
	 * @param bkgOfcNo
	 */
    public void setBkgOfcNo(String bkgOfcNo) {
        this.bkgOfcNo = bkgOfcNo;
    }

    /**
	 * Column Info
	 * @param totalCm
	 */
    public void setTotalCm(String totalCm) {
        this.totalCm = totalCm;
    }

    /**
	 * Column Info
	 * @param dpcsSts
	 */
    public void setDpcsSts(String dpcsSts) {
        this.dpcsSts = dpcsSts;
    }

    /**
	 * Column Info
	 * @param pDocUsrId
	 */
    public void setPDocUsrId(String pDocUsrId) {
        this.pDocUsrId = pDocUsrId;
    }

    /**
	 * Column Info
	 * @param dpcsQa
	 */
    public void setDpcsQa(String dpcsQa) {
        this.dpcsQa = dpcsQa;
    }

    /**
	 * Column Info
	 * @param denseRank2
	 */
    public void setDenseRank2(String denseRank2) {
        this.denseRank2 = denseRank2;
    }

    /**
	 * Column Info
	 * @param pPolLt
	 */
    public void setPPolLt(String pPolLt) {
        this.pPolLt = pPolLt;
    }

    /**
	 * Column Info
	 * @param pBkgCustTpCd
	 */
    public void setPBkgCustTpCd(String pBkgCustTpCd) {
        this.pBkgCustTpCd = pBkgCustTpCd;
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
	 * @param pZoneCd
	 */
    public void setPZoneCd(String pZoneCd) {
        this.pZoneCd = pZoneCd;
    }

    /**
	 * Column Info
	 * @param statusPending
	 */
    public void setStatusPending(String statusPending) {
        this.statusPending = statusPending;
    }

    /**
	 * Column Info
	 * @param dpcsInput
	 */
    public void setDpcsInput(String dpcsInput) {
        this.dpcsInput = dpcsInput;
    }

    /**
	 * Column Info
	 * @param charge
	 */
    public void setCharge(String charge) {
        this.charge = charge;
    }

    /**
	 * Column Info
	 * @param totalMd
	 */
    public void setTotalMd(String totalMd) {
        this.totalMd = totalMd;
    }

    /**
	 * Column Info
	 * @param pPorCd
	 */
    public void setPPorCd(String pPorCd) {
        this.pPorCd = pPorCd;
    }

    /**
	 * Column Info
	 * @param pApodCd
	 */
    public void setPApodCd(String pApodCd) {
        this.pApodCd = pApodCd;
    }

    /**
	 * Column Info
	 * @param entrClssTpCd
	 */
    public void setEntrClssTpCd(String entrClssTpCd) {
        this.entrClssTpCd = entrClssTpCd;
    }

    /**
	 * Column Info
	 * @param custTp
	 */
    public void setCustTp(String custTp) {
        this.custTp = custTp;
    }

    /**
	 * Column Info
	 * @param multiVvd
	 */
    public void setMultiVvd(String multiVvd) {
        this.multiVvd = multiVvd;
    }

    /**
	 * Column Info
	 * @param polEtdFrDt
	 */
    public void setPolEtdFrDt(String polEtdFrDt) {
        this.polEtdFrDt = polEtdFrDt;
    }

    /**
	 * Column Info
	 * @param polEtdToDt
	 */
    public void setPolEtdToDt(String polEtdToDt) {
        this.polEtdToDt = polEtdToDt;
    }

    /**
	 * Column Info
	 * @param keyVvd
	 */
    public void setKeyVvd(String keyVvd) {
        this.keyVvd = keyVvd;
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
	 * @param cntrCheck
	 */
    public void setCntrCheck(String cntrCheck) {
        this.cntrCheck = cntrCheck;
    }

    /**
	 * Column Info
	 * @param chkDupVvd
	 */
    public void setChkDupVvd(String chkDupVvd) {
        this.chkDupVvd = chkDupVvd;
    }

    /**
	 * Column Info
	 * @param ffdr
	 */
    public void setFfdr(String ffdr) {
        this.ffdr = ffdr;
    }

    /**
	 * @return the cntrWgt
	 */
    public String getCntrWgt() {
        return cntrWgt;
    }

    /**
	 * @param cntrWgt the cntrWgt to set
	 */
    public void setCntrWgt(String cntrWgt) {
        this.cntrWgt = cntrWgt;
    }

    /**
	 * @return the wgtUtCd
	 */
    public String getWgtUtCd() {
        return wgtUtCd;
    }

    /**
	 * @return the pSocCgoFlg
	 */
    public String getPSocCgoFlg() {
        return pSocCgoFlg;
    }

    /**
	 * @return the pSireadyFlg
	 */
    public String getPSireadyFlg() {
        return pSireadyFlg;
    }

    /**
	 * @return the sireadyFlg
	 */
    public String getSireadyFlg() {
        return sireadyFlg;
    }

    /**
	 * @param wgtUtCd the wgtUtCd to set
	 */
    public void setWgtUtCd(String wgtUtCd) {
        this.wgtUtCd = wgtUtCd;
    }

    /**
	 * @param pSocCgoFlg the pSocCgoFlg to set
	 */
    public void setPSocCgoFlg(String pSocCgoFlg) {
        this.pSocCgoFlg = pSocCgoFlg;
    }

    /**
	 * @param pSireadyFlg the pSireadyFlg to set
	 */
    public void setPSireadyFlg(String pSireadyFlg) {
        this.pSireadyFlg = pSireadyFlg;
    }

    /**
	 * @param sireadyFlg the sireadyFlg to set
	 */
    public void setSireadyFlg(String sireadyFlg) {
        this.sireadyFlg = sireadyFlg;
    }

    /**
	 * @param lOfcSub the lOfcSub to set
	 */
    public void setLOfcSub(String lOfcSub) {
        this.lOfcSub = lOfcSub;
    }

    /**
	 * @param cOfcSub the cOfcSub to set
	 */
    public void setCOfcSub(String cOfcSub) {
        this.cOfcSub = cOfcSub;
    }

    /**
	 * @param measQty 
	 */
    public void setMeasQty(String measQty) {
        this.measQty = measQty;
    }

    /**
	 * @param eventYard 
	 */
    public void setEventYard(String eventYard) {
        this.eventYard = eventYard;
    }

    /**
	 * @param eventDt 
	 */
    public void setEventDt(String eventDt) {
        this.eventDt = eventDt;
    }

    /**
	 * @return the cntrCfmId
	 */
    public String getCntrCfmId() {
        return cntrCfmId;
    }

    /**
	 * @param cntrCfmId 
	 */
    public void setCntrCfmId(String cntrCfmId) {
        this.cntrCfmId = cntrCfmId;
    }

    public String getVgmWgt() {
        return vgmWgt;
    }

    public void setVgmWgt(String vgmWgt) {
        this.vgmWgt = vgmWgt;
    }

    public String getVgmWgtUtCd() {
        return vgmWgtUtCd;
    }

    public void setVgmWgtUtCd(String vgmWgtUtCd) {
        this.vgmWgtUtCd = vgmWgtUtCd;
    }

    public String getTotalVgmCnt() {
        return totalVgmCnt;
    }

    public void setTotalVgmCnt(String totalVgmCnt) {
        this.totalVgmCnt = totalVgmCnt;
    }

    public String getVgmFlg() {
        return vgmFlg;
    }

    public void setVgmFlg(String vgmFlg) {
        this.vgmFlg = vgmFlg;
    }

    public String getTotalCntrCnt() {
        return totalCntrCnt;
    }

    public void setTotalCntrCnt(String totalCntrCnt) {
        this.totalCntrCnt = totalCntrCnt;
    }

    public String getTotalNoVgmCnt() {
        return totalNoVgmCnt;
    }

    public void setTotalNoVgmCnt(String totalNoVgmCnt) {
        this.totalNoVgmCnt = totalNoVgmCnt;
    }

    public String getVgmVrfySigCtnt() {
        return vgmVrfySigCtnt;
    }

    public void setVgmVrfySigCtnt(String vgmVrfySigCtnt) {
        this.vgmVrfySigCtnt = vgmVrfySigCtnt;
    }

    public String getVgmMzdTpCd() {
        return vgmMzdTpCd;
    }

    public void setVgmMzdTpCd(String vgmMzdTpCd) {
        this.vgmMzdTpCd = vgmMzdTpCd;
    }

    public void setBlckStwgCd(String blckStwgCd) {
        this.blckStwgCd = blckStwgCd;
    }

    public String getBlckStwgCd() {
        return this.blckStwgCd;
    }

    public void setObSrepCd(String obSrepCd) {
        this.obSrepCd = obSrepCd;
    }

    public String getObSrepCd() {
        return this.obSrepCd;
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
        setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
        setDenseRank(JSPUtil.getParameter(request, prefix + "dense_rank", ""));
        setVia(JSPUtil.getParameter(request, prefix + "via", ""));
        setTotalCharge(JSPUtil.getParameter(request, prefix + "total_charge", ""));
        setPor(JSPUtil.getParameter(request, prefix + "por", ""));
        setTotalCfm(JSPUtil.getParameter(request, prefix + "total_cfm", ""));
        setTotalBkgF(JSPUtil.getParameter(request, prefix + "total_bkg_f", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setRowsPerPage(JSPUtil.getParameter(request, prefix + "rows_per_page", ""));
        setPBkgOfcCd(JSPUtil.getParameter(request, prefix + "p_bkg_ofc_cd", ""));
        setFf(JSPUtil.getParameter(request, prefix + "ff", ""));
        setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
        setTotalBkgT(JSPUtil.getParameter(request, prefix + "total_bkg_t", ""));
        setTotalCnt(JSPUtil.getParameter(request, prefix + "total_cnt", ""));
        setPDcgoFlg(JSPUtil.getParameter(request, prefix + "p_dcgo_flg", ""));
        setPPolCd(JSPUtil.getParameter(request, prefix + "p_pol_cd", ""));
        setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
        setPCustSeq(JSPUtil.getParameter(request, prefix + "p_cust_seq", ""));
        setPEqType(JSPUtil.getParameter(request, prefix + "p_eq_type", ""));
        setPCnmvStsCd(JSPUtil.getParameter(request, prefix + "p_cnmv_sts_cd", ""));
        setReceiving(JSPUtil.getParameter(request, prefix + "receiving", ""));
        setPBkgStsCd(JSPUtil.getParameter(request, prefix + "p_bkg_sts_cd", ""));
        setStatusComplete(JSPUtil.getParameter(request, prefix + "status_complete", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setDpcsRate(JSPUtil.getParameter(request, prefix + "dpcs_rate", ""));
        setPNoGood(JSPUtil.getParameter(request, prefix + "p_no_good", ""));
        setQtyCntr(JSPUtil.getParameter(request, prefix + "qty_cntr", ""));
        setShipperCode(JSPUtil.getParameter(request, prefix + "shipper_code", ""));
        setRowsPerBkg(JSPUtil.getParameter(request, prefix + "rows_per_bkg", ""));
        setPDelConti(JSPUtil.getParameter(request, prefix + "p_del_conti", ""));
        setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
        setConsignee(JSPUtil.getParameter(request, prefix + "consignee", ""));
        setCtrRnum(JSPUtil.getParameter(request, prefix + "ctr_rnum", ""));
        setApprval(JSPUtil.getParameter(request, prefix + "apprval", ""));
        setTotalIssue(JSPUtil.getParameter(request, prefix + "total_issue", ""));
        setPRcvTermCd(JSPUtil.getParameter(request, prefix + "p_rcv_term_cd", ""));
        setMd(JSPUtil.getParameter(request, prefix + "md", ""));
        setBdr(JSPUtil.getParameter(request, prefix + "bdr", ""));
        setQtyBkg(JSPUtil.getParameter(request, prefix + "qty_bkg", ""));
        setDel(JSPUtil.getParameter(request, prefix + "del", ""));
        setTotalCtrlT(JSPUtil.getParameter(request, prefix + "total_ctrl_t", ""));
        setPDeTermCd(JSPUtil.getParameter(request, prefix + "p_de_term_cd", ""));
        setDpcsF(JSPUtil.getParameter(request, prefix + "dpcs_f", ""));
        setPPolYdCd(JSPUtil.getParameter(request, prefix + "p_pol_yd_cd", ""));
        setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
        setDpcsBlProof(JSPUtil.getParameter(request, prefix + "dpcs_bl_proof", ""));
        setPeb(JSPUtil.getParameter(request, prefix + "peb", ""));
        setDpcsI(JSPUtil.getParameter(request, prefix + "dpcs_i", ""));
        setFirm(JSPUtil.getParameter(request, prefix + "firm", ""));
        setShipper(JSPUtil.getParameter(request, prefix + "shipper", ""));
        setCntrCfmFlg(JSPUtil.getParameter(request, prefix + "cntr_cfm_flg", ""));
        setTotalCtrlF(JSPUtil.getParameter(request, prefix + "total_ctrl_f", ""));
        setHitchmentYn(JSPUtil.getParameter(request, prefix + "hitchment_yn", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setPRcFlg(JSPUtil.getParameter(request, prefix + "p_rc_flg", ""));
        setTotalVl(JSPUtil.getParameter(request, prefix + "total_vl", ""));
        setDpcsR(JSPUtil.getParameter(request, prefix + "dpcs_r", ""));
        setBroker(JSPUtil.getParameter(request, prefix + "broker", ""));
        setPOblIssOfcCd(JSPUtil.getParameter(request, prefix + "p_obl_iss_ofc_cd", ""));
        setDpcsQ(JSPUtil.getParameter(request, prefix + "dpcs_q", ""));
        setElNo(JSPUtil.getParameter(request, prefix + "el_no", ""));
        setTotalBkg(JSPUtil.getParameter(request, prefix + "total_bkg", ""));
        setPCustCntCd(JSPUtil.getParameter(request, prefix + "p_cust_cnt_cd", ""));
        setTotalReceiving(JSPUtil.getParameter(request, prefix + "total_receiving", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setPObSlsOfcCd(JSPUtil.getParameter(request, prefix + "p_ob_sls_ofc_cd", ""));
        setPCtrtOfcCd(JSPUtil.getParameter(request, prefix + "p_ctrt_ofc_cd", ""));
        setPCtrtSrepCd(JSPUtil.getParameter(request, prefix + "p_ctrt_srep_cd", ""));
        setCurrPage(JSPUtil.getParameter(request, prefix + "curr_page", ""));
        setStatusOpen(JSPUtil.getParameter(request, prefix + "status_open", ""));
        setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
        setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
        setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
        setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
        setAesYn(JSPUtil.getParameter(request, prefix + "aes_yn", ""));
        setSt(JSPUtil.getParameter(request, prefix + "st", ""));
        setSz(JSPUtil.getParameter(request, prefix + "sz", ""));
        setPVvd(JSPUtil.getParameter(request, prefix + "p_vvd", ""));
        setPDpcsFlg(JSPUtil.getParameter(request, prefix + "p_dpcs_flg", ""));
        setAes(JSPUtil.getParameter(request, prefix + "aes", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setTvvd(JSPUtil.getParameter(request, prefix + "tvvd", ""));
        setPkg(JSPUtil.getParameter(request, prefix + "pkg", ""));
        setPAwkCgoFlg(JSPUtil.getParameter(request, prefix + "p_awk_cgo_flg", ""));
        setPBbCgoFlg(JSPUtil.getParameter(request, prefix + "p_bb_cgo_flg", ""));
        setPSiFlg(JSPUtil.getParameter(request, prefix + "p_si_flg", ""));
        setCm(JSPUtil.getParameter(request, prefix + "cm", ""));
        setTaxId(JSPUtil.getParameter(request, prefix + "tax_id", ""));
        setTotalBl(JSPUtil.getParameter(request, prefix + "total_bl", ""));
        setPObSrepCd(JSPUtil.getParameter(request, prefix + "p_ob_srep_cd", ""));
        setPCustNm(JSPUtil.getParameter(request, prefix + "p_cust_nm", ""));
        setWeight(JSPUtil.getParameter(request, prefix + "weight", ""));
        setPApodLt(JSPUtil.getParameter(request, prefix + "p_apod_lt", ""));
        setDde(JSPUtil.getParameter(request, prefix + "dde", ""));
        setTotalApprval(JSPUtil.getParameter(request, prefix + "total_apprval", ""));
        setIssue(JSPUtil.getParameter(request, prefix + "issue", ""));
        setMeasuere(JSPUtil.getParameter(request, prefix + "measuere", ""));
        setSpecialR(JSPUtil.getParameter(request, prefix + "special_r", ""));
        setDpcsTtl(JSPUtil.getParameter(request, prefix + "dpcs_ttl", ""));
        setVol(JSPUtil.getParameter(request, prefix + "vol", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPOfcCd(JSPUtil.getParameter(request, prefix + "p_ofc_cd", ""));
        setSeal(JSPUtil.getParameter(request, prefix + "seal", ""));
        setCaed(JSPUtil.getParameter(request, prefix + "caed", ""));
        setPDelCd(JSPUtil.getParameter(request, prefix + "p_del_cd", ""));
        setPBdrFlg(JSPUtil.getParameter(request, prefix + "p_bdr_flg", ""));
        setSpecialD(JSPUtil.getParameter(request, prefix + "special_d", ""));
        setSpecialA(JSPUtil.getParameter(request, prefix + "special_a", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setSpecialB(JSPUtil.getParameter(request, prefix + "special_b", ""));
        setBkgOfcNo(JSPUtil.getParameter(request, prefix + "bkg_ofc_no", ""));
        setTotalCm(JSPUtil.getParameter(request, prefix + "total_cm", ""));
        setDpcsSts(JSPUtil.getParameter(request, prefix + "dpcs_sts", ""));
        setPDocUsrId(JSPUtil.getParameter(request, prefix + "p_doc_usr_id", ""));
        setDpcsQa(JSPUtil.getParameter(request, prefix + "dpcs_qa", ""));
        setDenseRank2(JSPUtil.getParameter(request, prefix + "dense_rank2", ""));
        setPPolLt(JSPUtil.getParameter(request, prefix + "p_pol_lt", ""));
        setPBkgCustTpCd(JSPUtil.getParameter(request, prefix + "p_bkg_cust_tp_cd", ""));
        setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
        setPZoneCd(JSPUtil.getParameter(request, prefix + "p_zone_cd", ""));
        setStatusPending(JSPUtil.getParameter(request, prefix + "status_pending", ""));
        setDpcsInput(JSPUtil.getParameter(request, prefix + "dpcs_input", ""));
        setCharge(JSPUtil.getParameter(request, prefix + "charge", ""));
        setTotalMd(JSPUtil.getParameter(request, prefix + "total_md", ""));
        setPPorCd(JSPUtil.getParameter(request, prefix + "p_por_cd", ""));
        setPApodCd(JSPUtil.getParameter(request, prefix + "p_apod_cd", ""));
        setEntrClssTpCd(JSPUtil.getParameter(request, prefix + "entr_clss_tp_cd", ""));
        setCustTp(JSPUtil.getParameter(request, prefix + "cust_tp", ""));
        setMultiVvd(JSPUtil.getParameter(request, prefix + "multi_vvd", ""));
        setPolEtdFrDt(JSPUtil.getParameter(request, prefix + "pol_etd_fr_dt", ""));
        setPolEtdToDt(JSPUtil.getParameter(request, prefix + "pol_etd_to_dt", ""));
        setKeyVvd(JSPUtil.getParameter(request, prefix + "key_vvd", ""));
        setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
        setCntrCheck(JSPUtil.getParameter(request, prefix + "cntr_check", ""));
        setChkDupVvd(JSPUtil.getParameter(request, prefix + "chk_dup_vvd", ""));
        setFfdr(JSPUtil.getParameter(request, prefix + "ffdr", ""));
        setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setPSocCgoFlg(JSPUtil.getParameter(request, prefix + "p_soc_cgo_flg", ""));
        setPSireadyFlg(JSPUtil.getParameter(request, prefix + "p_si_ready_flg", ""));
        setSireadyFlg(JSPUtil.getParameter(request, prefix + "si_ready_flg", ""));
        setLOfcSub(JSPUtil.getParameter(request, prefix + "l_ofc_sub", ""));
        setCOfcSub(JSPUtil.getParameter(request, prefix + "c_ofc_sub", ""));
        setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
        setEventYard(JSPUtil.getParameter(request, prefix + "event_yard", ""));
        setEventDt(JSPUtil.getParameter(request, prefix + "event_dt", ""));
        setCntrCfmId(JSPUtil.getParameter(request, prefix + "cntr_cfm_id", ""));
        setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
        setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
        setTotalVgmCnt(JSPUtil.getParameter(request, prefix + "total_vgm_cnt", ""));
        setVgmFlg(JSPUtil.getParameter(request, prefix + "vgm_flg", ""));
        setTotalCntrCnt(JSPUtil.getParameter(request, prefix + "total_cntr_cnt", ""));
        setTotalNoVgmCnt(JSPUtil.getParameter(request, prefix + "total_no_vgm_cnt", ""));
        setVgmVrfySigCtnt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_sig_ctnt", ""));
        setVgmMzdTpCd(JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", ""));
        setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
        setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgClearanceCrossCheckListInVO[]
	 */
    public BkgClearanceCrossCheckListInVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgClearanceCrossCheckListInVO[]
	 */
    public BkgClearanceCrossCheckListInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgClearanceCrossCheckListInVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", length));
            String[] denseRank = (JSPUtil.getParameter(request, prefix + "dense_rank", length));
            String[] via = (JSPUtil.getParameter(request, prefix + "via", length));
            String[] totalCharge = (JSPUtil.getParameter(request, prefix + "total_charge", length));
            String[] por = (JSPUtil.getParameter(request, prefix + "por", length));
            String[] totalCfm = (JSPUtil.getParameter(request, prefix + "total_cfm", length));
            String[] totalBkgF = (JSPUtil.getParameter(request, prefix + "total_bkg_f", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] rowsPerPage = (JSPUtil.getParameter(request, prefix + "rows_per_page", length));
            String[] pBkgOfcCd = (JSPUtil.getParameter(request, prefix + "p_bkg_ofc_cd", length));
            String[] ff = (JSPUtil.getParameter(request, prefix + "ff", length));
            String[] pol = (JSPUtil.getParameter(request, prefix + "pol", length));
            String[] totalBkgT = (JSPUtil.getParameter(request, prefix + "total_bkg_t", length));
            String[] totalCnt = (JSPUtil.getParameter(request, prefix + "total_cnt", length));
            String[] pDcgoFlg = (JSPUtil.getParameter(request, prefix + "p_dcgo_flg", length));
            String[] pPolCd = (JSPUtil.getParameter(request, prefix + "p_pol_cd", length));
            String[] pod = (JSPUtil.getParameter(request, prefix + "pod", length));
            String[] pCustSeq = (JSPUtil.getParameter(request, prefix + "p_cust_seq", length));
            String[] pEqType = (JSPUtil.getParameter(request, prefix + "p_eq_type", length));
            String[] pCnmvStsCd = (JSPUtil.getParameter(request, prefix + "p_cnmv_sts_cd", length));
            String[] receiving = (JSPUtil.getParameter(request, prefix + "receiving", length));
            String[] pBkgStsCd = (JSPUtil.getParameter(request, prefix + "p_bkg_sts_cd", length));
            String[] statusComplete = (JSPUtil.getParameter(request, prefix + "status_complete", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] dpcsRate = (JSPUtil.getParameter(request, prefix + "dpcs_rate", length));
            String[] pNoGood = (JSPUtil.getParameter(request, prefix + "p_no_good", length));
            String[] qtyCntr = (JSPUtil.getParameter(request, prefix + "qty_cntr", length));
            String[] shipperCode = (JSPUtil.getParameter(request, prefix + "shipper_code", length));
            String[] rowsPerBkg = (JSPUtil.getParameter(request, prefix + "rows_per_bkg", length));
            String[] pDelConti = (JSPUtil.getParameter(request, prefix + "p_del_conti", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] consignee = (JSPUtil.getParameter(request, prefix + "consignee", length));
            String[] ctrRnum = (JSPUtil.getParameter(request, prefix + "ctr_rnum", length));
            String[] apprval = (JSPUtil.getParameter(request, prefix + "apprval", length));
            String[] totalIssue = (JSPUtil.getParameter(request, prefix + "total_issue", length));
            String[] pRcvTermCd = (JSPUtil.getParameter(request, prefix + "p_rcv_term_cd", length));
            String[] md = (JSPUtil.getParameter(request, prefix + "md", length));
            String[] bdr = (JSPUtil.getParameter(request, prefix + "bdr", length));
            String[] qtyBkg = (JSPUtil.getParameter(request, prefix + "qty_bkg", length));
            String[] del = (JSPUtil.getParameter(request, prefix + "del", length));
            String[] totalCtrlT = (JSPUtil.getParameter(request, prefix + "total_ctrl_t", length));
            String[] pDeTermCd = (JSPUtil.getParameter(request, prefix + "p_de_term_cd", length));
            String[] dpcsF = (JSPUtil.getParameter(request, prefix + "dpcs_f", length));
            String[] pPolYdCd = (JSPUtil.getParameter(request, prefix + "p_pol_yd_cd", length));
            String[] porNodCd = (JSPUtil.getParameter(request, prefix + "por_nod_cd", length));
            String[] dpcsBlProof = (JSPUtil.getParameter(request, prefix + "dpcs_bl_proof", length));
            String[] peb = (JSPUtil.getParameter(request, prefix + "peb", length));
            String[] dpcsI = (JSPUtil.getParameter(request, prefix + "dpcs_i", length));
            String[] firm = (JSPUtil.getParameter(request, prefix + "firm", length));
            String[] shipper = (JSPUtil.getParameter(request, prefix + "shipper", length));
            String[] cntrCfmFlg = (JSPUtil.getParameter(request, prefix + "cntr_cfm_flg", length));
            String[] totalCtrlF = (JSPUtil.getParameter(request, prefix + "total_ctrl_f", length));
            String[] hitchmentYn = (JSPUtil.getParameter(request, prefix + "hitchment_yn", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] pRcFlg = (JSPUtil.getParameter(request, prefix + "p_rc_flg", length));
            String[] totalVl = (JSPUtil.getParameter(request, prefix + "total_vl", length));
            String[] dpcsR = (JSPUtil.getParameter(request, prefix + "dpcs_r", length));
            String[] broker = (JSPUtil.getParameter(request, prefix + "broker", length));
            String[] pOblIssOfcCd = (JSPUtil.getParameter(request, prefix + "p_obl_iss_ofc_cd", length));
            String[] dpcsQ = (JSPUtil.getParameter(request, prefix + "dpcs_q", length));
            String[] elNo = (JSPUtil.getParameter(request, prefix + "el_no", length));
            String[] totalBkg = (JSPUtil.getParameter(request, prefix + "total_bkg", length));
            String[] pCustCntCd = (JSPUtil.getParameter(request, prefix + "p_cust_cnt_cd", length));
            String[] totalReceiving = (JSPUtil.getParameter(request, prefix + "total_receiving", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pObSlsOfcCd = (JSPUtil.getParameter(request, prefix + "p_ob_sls_ofc_cd", length));
            String[] pCtrtOfcCd = (JSPUtil.getParameter(request, prefix + "p_ctrt_ofc_cd", length));
            String[] pCtrtSrepCd = (JSPUtil.getParameter(request, prefix + "p_ctrt_srep_cd", length));
            String[] currPage = (JSPUtil.getParameter(request, prefix + "curr_page", length));
            String[] statusOpen = (JSPUtil.getParameter(request, prefix + "status_open", length));
            String[] rnum = (JSPUtil.getParameter(request, prefix + "rnum", length));
            String[] delNodCd = (JSPUtil.getParameter(request, prefix + "del_nod_cd", length));
            String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", length));
            String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", length));
            String[] aesYn = (JSPUtil.getParameter(request, prefix + "aes_yn", length));
            String[] st = (JSPUtil.getParameter(request, prefix + "st", length));
            String[] sz = (JSPUtil.getParameter(request, prefix + "sz", length));
            String[] pVvd = (JSPUtil.getParameter(request, prefix + "p_vvd", length));
            String[] pDpcsFlg = (JSPUtil.getParameter(request, prefix + "p_dpcs_flg", length));
            String[] aes = (JSPUtil.getParameter(request, prefix + "aes", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] tvvd = (JSPUtil.getParameter(request, prefix + "tvvd", length));
            String[] pkg = (JSPUtil.getParameter(request, prefix + "pkg", length));
            String[] pAwkCgoFlg = (JSPUtil.getParameter(request, prefix + "p_awk_cgo_flg", length));
            String[] pBbCgoFlg = (JSPUtil.getParameter(request, prefix + "p_bb_cgo_flg", length));
            String[] pSiFlg = (JSPUtil.getParameter(request, prefix + "p_si_flg", length));
            String[] cm = (JSPUtil.getParameter(request, prefix + "cm", length));
            String[] taxId = (JSPUtil.getParameter(request, prefix + "tax_id", length));
            String[] totalBl = (JSPUtil.getParameter(request, prefix + "total_bl", length));
            String[] pObSrepCd = (JSPUtil.getParameter(request, prefix + "p_ob_srep_cd", length));
            String[] pCustNm = (JSPUtil.getParameter(request, prefix + "p_cust_nm", length));
            String[] weight = (JSPUtil.getParameter(request, prefix + "weight", length));
            String[] pApodLt = (JSPUtil.getParameter(request, prefix + "p_apod_lt", length));
            String[] dde = (JSPUtil.getParameter(request, prefix + "dde", length));
            String[] totalApprval = (JSPUtil.getParameter(request, prefix + "total_apprval", length));
            String[] issue = (JSPUtil.getParameter(request, prefix + "issue", length));
            String[] measuere = (JSPUtil.getParameter(request, prefix + "measuere", length));
            String[] specialR = (JSPUtil.getParameter(request, prefix + "special_r", length));
            String[] dpcsTtl = (JSPUtil.getParameter(request, prefix + "dpcs_ttl", length));
            String[] vol = (JSPUtil.getParameter(request, prefix + "vol", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pOfcCd = (JSPUtil.getParameter(request, prefix + "p_ofc_cd", length));
            String[] seal = (JSPUtil.getParameter(request, prefix + "seal", length));
            String[] caed = (JSPUtil.getParameter(request, prefix + "caed", length));
            String[] pDelCd = (JSPUtil.getParameter(request, prefix + "p_del_cd", length));
            String[] pBdrFlg = (JSPUtil.getParameter(request, prefix + "p_bdr_flg", length));
            String[] specialD = (JSPUtil.getParameter(request, prefix + "special_d", length));
            String[] specialA = (JSPUtil.getParameter(request, prefix + "special_a", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] specialB = (JSPUtil.getParameter(request, prefix + "special_b", length));
            String[] bkgOfcNo = (JSPUtil.getParameter(request, prefix + "bkg_ofc_no", length));
            String[] totalCm = (JSPUtil.getParameter(request, prefix + "total_cm", length));
            String[] dpcsSts = (JSPUtil.getParameter(request, prefix + "dpcs_sts", length));
            String[] pDocUsrId = (JSPUtil.getParameter(request, prefix + "p_doc_usr_id", length));
            String[] dpcsQa = (JSPUtil.getParameter(request, prefix + "dpcs_qa", length));
            String[] denseRank2 = (JSPUtil.getParameter(request, prefix + "dense_rank2", length));
            String[] pPolLt = (JSPUtil.getParameter(request, prefix + "p_pol_lt", length));
            String[] pBkgCustTpCd = (JSPUtil.getParameter(request, prefix + "p_bkg_cust_tp_cd", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] pZoneCd = (JSPUtil.getParameter(request, prefix + "p_zone_cd", length));
            String[] statusPending = (JSPUtil.getParameter(request, prefix + "status_pending", length));
            String[] dpcsInput = (JSPUtil.getParameter(request, prefix + "dpcs_input", length));
            String[] charge = (JSPUtil.getParameter(request, prefix + "charge", length));
            String[] totalMd = (JSPUtil.getParameter(request, prefix + "total_md", length));
            String[] pPorCd = (JSPUtil.getParameter(request, prefix + "p_por_cd", length));
            String[] pApodCd = (JSPUtil.getParameter(request, prefix + "p_apod_cd", length));
            String[] entrClssTpCd = (JSPUtil.getParameter(request, prefix + "entr_clss_tp_cd", length));
            String[] custTp = (JSPUtil.getParameter(request, prefix + "cust_tp", length));
            String[] multiVvd = (JSPUtil.getParameter(request, prefix + "multi_vvd", length));
            String[] polEtdFrDt = (JSPUtil.getParameter(request, prefix + "pol_etd_fr_dt", length));
            String[] polEtdToDt = (JSPUtil.getParameter(request, prefix + "pol_etd_to_dt", length));
            String[] keyVvd = (JSPUtil.getParameter(request, prefix + "key_vvd", length));
            String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
            String[] cntrCheck = (JSPUtil.getParameter(request, prefix + "cntr_check", length));
            String[] chkDupVvd = (JSPUtil.getParameter(request, prefix + "chk_dup_vvd", length));
            String[] ffdr = (JSPUtil.getParameter(request, prefix + "ffdr", length));
            String[] cntrWgt = (JSPUtil.getParameter(request, prefix + "cntr_wgt", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] pSocCgoFlg = (JSPUtil.getParameter(request, prefix + "p_soc_cgo_flg", length));
            String[] pSireadyFlg = (JSPUtil.getParameter(request, prefix + "p_si_ready_flg", length));
            String[] sireadyFlg = (JSPUtil.getParameter(request, prefix + "si_ready_flg", length));
            String[] lOfcSub = (JSPUtil.getParameter(request, prefix + "l_ofc_sub", length));
            String[] cOfcSub = (JSPUtil.getParameter(request, prefix + "c_ofc_sub", length));
            String[] measQty = (JSPUtil.getParameter(request, prefix + "meas_qty", length));
            String[] eventYard = (JSPUtil.getParameter(request, prefix + "event_yard", length));
            String[] eventDt = (JSPUtil.getParameter(request, prefix + "event_dt", length));
            String[] cntrCfmId = (JSPUtil.getParameter(request, prefix + "cntr_cfm_id", length));
            String[] vgmWgt = (JSPUtil.getParameter(request, prefix + "vgm_wgt", length));
            String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", length));
            String[] totalVgmCnt = (JSPUtil.getParameter(request, prefix + "total_vgm_cnt", length));
            String[] vgmFlg = (JSPUtil.getParameter(request, prefix + "vgm_flg", length));
            String[] totalCntrCnt = (JSPUtil.getParameter(request, prefix + "total_cntr_cnt", length));
            String[] totalNoVgmCnt = (JSPUtil.getParameter(request, prefix + "total_no_vgm_cnt", length));
            String[] vgmVrfySigCtnt = (JSPUtil.getParameter(request, prefix + "vgm_vrfy_sig_ctnt", length));
            String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", length));
            for (int i = 0; i < length; i++) {
                model = new BkgClearanceCrossCheckListInVO();
                if (bkgCgoTpCd[i] != null)
                    model.setBkgCgoTpCd(bkgCgoTpCd[i]);
                if (denseRank[i] != null)
                    model.setDenseRank(denseRank[i]);
                if (via[i] != null)
                    model.setVia(via[i]);
                if (totalCharge[i] != null)
                    model.setTotalCharge(totalCharge[i]);
                if (por[i] != null)
                    model.setPor(por[i]);
                if (totalCfm[i] != null)
                    model.setTotalCfm(totalCfm[i]);
                if (totalBkgF[i] != null)
                    model.setTotalBkgF(totalBkgF[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (rowsPerPage[i] != null)
                    model.setRowsPerPage(rowsPerPage[i]);
                if (pBkgOfcCd[i] != null)
                    model.setPBkgOfcCd(pBkgOfcCd[i]);
                if (ff[i] != null)
                    model.setFf(ff[i]);
                if (pol[i] != null)
                    model.setPol(pol[i]);
                if (totalBkgT[i] != null)
                    model.setTotalBkgT(totalBkgT[i]);
                if (totalCnt[i] != null)
                    model.setTotalCnt(totalCnt[i]);
                if (pDcgoFlg[i] != null)
                    model.setPDcgoFlg(pDcgoFlg[i]);
                if (pPolCd[i] != null)
                    model.setPPolCd(pPolCd[i]);
                if (pod[i] != null)
                    model.setPod(pod[i]);
                if (pCustSeq[i] != null)
                    model.setPCustSeq(pCustSeq[i]);
                if (pEqType[i] != null)
                    model.setPEqType(pEqType[i]);
                if (pCnmvStsCd[i] != null)
                    model.setPCnmvStsCd(pCnmvStsCd[i]);
                if (receiving[i] != null)
                    model.setReceiving(receiving[i]);
                if (pBkgStsCd[i] != null)
                    model.setPBkgStsCd(pBkgStsCd[i]);
                if (statusComplete[i] != null)
                    model.setStatusComplete(statusComplete[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (dpcsRate[i] != null)
                    model.setDpcsRate(dpcsRate[i]);
                if (pNoGood[i] != null)
                    model.setPNoGood(pNoGood[i]);
                if (qtyCntr[i] != null)
                    model.setQtyCntr(qtyCntr[i]);
                if (shipperCode[i] != null)
                    model.setShipperCode(shipperCode[i]);
                if (rowsPerBkg[i] != null)
                    model.setRowsPerBkg(rowsPerBkg[i]);
                if (pDelConti[i] != null)
                    model.setPDelConti(pDelConti[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (consignee[i] != null)
                    model.setConsignee(consignee[i]);
                if (ctrRnum[i] != null)
                    model.setCtrRnum(ctrRnum[i]);
                if (apprval[i] != null)
                    model.setApprval(apprval[i]);
                if (totalIssue[i] != null)
                    model.setTotalIssue(totalIssue[i]);
                if (pRcvTermCd[i] != null)
                    model.setPRcvTermCd(pRcvTermCd[i]);
                if (md[i] != null)
                    model.setMd(md[i]);
                if (bdr[i] != null)
                    model.setBdr(bdr[i]);
                if (qtyBkg[i] != null)
                    model.setQtyBkg(qtyBkg[i]);
                if (del[i] != null)
                    model.setDel(del[i]);
                if (totalCtrlT[i] != null)
                    model.setTotalCtrlT(totalCtrlT[i]);
                if (pDeTermCd[i] != null)
                    model.setPDeTermCd(pDeTermCd[i]);
                if (dpcsF[i] != null)
                    model.setDpcsF(dpcsF[i]);
                if (pPolYdCd[i] != null)
                    model.setPPolYdCd(pPolYdCd[i]);
                if (porNodCd[i] != null)
                    model.setPorNodCd(porNodCd[i]);
                if (dpcsBlProof[i] != null)
                    model.setDpcsBlProof(dpcsBlProof[i]);
                if (peb[i] != null)
                    model.setPeb(peb[i]);
                if (dpcsI[i] != null)
                    model.setDpcsI(dpcsI[i]);
                if (firm[i] != null)
                    model.setFirm(firm[i]);
                if (shipper[i] != null)
                    model.setShipper(shipper[i]);
                if (cntrCfmFlg[i] != null)
                    model.setCntrCfmFlg(cntrCfmFlg[i]);
                if (totalCtrlF[i] != null)
                    model.setTotalCtrlF(totalCtrlF[i]);
                if (hitchmentYn[i] != null)
                    model.setHitchmentYn(hitchmentYn[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (pRcFlg[i] != null)
                    model.setPRcFlg(pRcFlg[i]);
                if (totalVl[i] != null)
                    model.setTotalVl(totalVl[i]);
                if (dpcsR[i] != null)
                    model.setDpcsR(dpcsR[i]);
                if (broker[i] != null)
                    model.setBroker(broker[i]);
                if (pOblIssOfcCd[i] != null)
                    model.setPOblIssOfcCd(pOblIssOfcCd[i]);
                if (dpcsQ[i] != null)
                    model.setDpcsQ(dpcsQ[i]);
                if (elNo[i] != null)
                    model.setElNo(elNo[i]);
                if (totalBkg[i] != null)
                    model.setTotalBkg(totalBkg[i]);
                if (pCustCntCd[i] != null)
                    model.setPCustCntCd(pCustCntCd[i]);
                if (totalReceiving[i] != null)
                    model.setTotalReceiving(totalReceiving[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pObSlsOfcCd[i] != null)
                    model.setPObSlsOfcCd(pObSlsOfcCd[i]);
                if (pCtrtOfcCd[i] != null)
                    model.setPCtrtOfcCd(pCtrtOfcCd[i]);
                if (pCtrtSrepCd[i] != null)
                    model.setPCtrtSrepCd(pCtrtSrepCd[i]);
                if (currPage[i] != null)
                    model.setCurrPage(currPage[i]);
                if (statusOpen[i] != null)
                    model.setStatusOpen(statusOpen[i]);
                if (rnum[i] != null)
                    model.setRnum(rnum[i]);
                if (delNodCd[i] != null)
                    model.setDelNodCd(delNodCd[i]);
                if (obSlsOfcCd[i] != null)
                    model.setObSlsOfcCd(obSlsOfcCd[i]);
                if (ctrtOfcCd[i] != null)
                    model.setCtrtOfcCd(ctrtOfcCd[i]);
                if (aesYn[i] != null)
                    model.setAesYn(aesYn[i]);
                if (st[i] != null)
                    model.setSt(st[i]);
                if (sz[i] != null)
                    model.setSz(sz[i]);
                if (pVvd[i] != null)
                    model.setPVvd(pVvd[i]);
                if (pDpcsFlg[i] != null)
                    model.setPDpcsFlg(pDpcsFlg[i]);
                if (aes[i] != null)
                    model.setAes(aes[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (tvvd[i] != null)
                    model.setTvvd(tvvd[i]);
                if (pkg[i] != null)
                    model.setPkg(pkg[i]);
                if (pAwkCgoFlg[i] != null)
                    model.setPAwkCgoFlg(pAwkCgoFlg[i]);
                if (pBbCgoFlg[i] != null)
                    model.setPBbCgoFlg(pBbCgoFlg[i]);
                if (pSiFlg[i] != null)
                    model.setPSiFlg(pSiFlg[i]);
                if (cm[i] != null)
                    model.setCm(cm[i]);
                if (taxId[i] != null)
                    model.setTaxId(taxId[i]);
                if (totalBl[i] != null)
                    model.setTotalBl(totalBl[i]);
                if (pObSrepCd[i] != null)
                    model.setPObSrepCd(pObSrepCd[i]);
                if (pCustNm[i] != null)
                    model.setPCustNm(pCustNm[i]);
                if (weight[i] != null)
                    model.setWeight(weight[i]);
                if (pApodLt[i] != null)
                    model.setPApodLt(pApodLt[i]);
                if (dde[i] != null)
                    model.setDde(dde[i]);
                if (totalApprval[i] != null)
                    model.setTotalApprval(totalApprval[i]);
                if (issue[i] != null)
                    model.setIssue(issue[i]);
                if (measuere[i] != null)
                    model.setMeasuere(measuere[i]);
                if (specialR[i] != null)
                    model.setSpecialR(specialR[i]);
                if (dpcsTtl[i] != null)
                    model.setDpcsTtl(dpcsTtl[i]);
                if (vol[i] != null)
                    model.setVol(vol[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pOfcCd[i] != null)
                    model.setPOfcCd(pOfcCd[i]);
                if (seal[i] != null)
                    model.setSeal(seal[i]);
                if (caed[i] != null)
                    model.setCaed(caed[i]);
                if (pDelCd[i] != null)
                    model.setPDelCd(pDelCd[i]);
                if (pBdrFlg[i] != null)
                    model.setPBdrFlg(pBdrFlg[i]);
                if (specialD[i] != null)
                    model.setSpecialD(specialD[i]);
                if (specialA[i] != null)
                    model.setSpecialA(specialA[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (specialB[i] != null)
                    model.setSpecialB(specialB[i]);
                if (bkgOfcNo[i] != null)
                    model.setBkgOfcNo(bkgOfcNo[i]);
                if (totalCm[i] != null)
                    model.setTotalCm(totalCm[i]);
                if (dpcsSts[i] != null)
                    model.setDpcsSts(dpcsSts[i]);
                if (pDocUsrId[i] != null)
                    model.setPDocUsrId(pDocUsrId[i]);
                if (dpcsQa[i] != null)
                    model.setDpcsQa(dpcsQa[i]);
                if (denseRank2[i] != null)
                    model.setDenseRank2(denseRank2[i]);
                if (pPolLt[i] != null)
                    model.setPPolLt(pPolLt[i]);
                if (pBkgCustTpCd[i] != null)
                    model.setPBkgCustTpCd(pBkgCustTpCd[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (pZoneCd[i] != null)
                    model.setPZoneCd(pZoneCd[i]);
                if (statusPending[i] != null)
                    model.setStatusPending(statusPending[i]);
                if (dpcsInput[i] != null)
                    model.setDpcsInput(dpcsInput[i]);
                if (charge[i] != null)
                    model.setCharge(charge[i]);
                if (totalMd[i] != null)
                    model.setTotalMd(totalMd[i]);
                if (pPorCd[i] != null)
                    model.setPPorCd(pPorCd[i]);
                if (pApodCd[i] != null)
                    model.setPApodCd(pApodCd[i]);
                if (entrClssTpCd[i] != null)
                    model.setEntrClssTpCd(entrClssTpCd[i]);
                if (custTp[i] != null)
                    model.setCustTp(custTp[i]);
                if (multiVvd[i] != null)
                    model.setMultiVvd(multiVvd[i]);
                if (polEtdFrDt[i] != null)
                    model.setPolEtdFrDt(polEtdFrDt[i]);
                if (polEtdToDt[i] != null)
                    model.setPolEtdToDt(polEtdToDt[i]);
                if (keyVvd[i] != null)
                    model.setKeyVvd(keyVvd[i]);
                if (scNo[i] != null)
                    model.setScNo(scNo[i]);
                if (cntrCheck[i] != null)
                    model.setCntrCheck(cntrCheck[i]);
                if (chkDupVvd[i] != null)
                    model.setChkDupVvd(chkDupVvd[i]);
                if (ffdr[i] != null)
                    model.setFfdr(ffdr[i]);
                if (cntrWgt[i] != null)
                    model.setCntrWgt(cntrWgt[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (pSocCgoFlg[i] != null)
                    model.setPSocCgoFlg(pSocCgoFlg[i]);
                if (pSireadyFlg[i] != null)
                    model.setPSireadyFlg(pSireadyFlg[i]);
                if (sireadyFlg[i] != null)
                    model.setSireadyFlg(sireadyFlg[i]);
                if (lOfcSub[i] != null)
                    model.setLOfcSub(lOfcSub[i]);
                if (cOfcSub[i] != null)
                    model.setCOfcSub(cOfcSub[i]);
                if (measQty[i] != null)
                    model.setMeasQty(measQty[i]);
                if (eventYard[i] != null)
                    model.setEventYard(eventYard[i]);
                if (eventDt[i] != null)
                    model.setEventDt(eventDt[i]);
                if (cntrCfmId[i] != null)
                    model.setCntrCfmId(cntrCfmId[i]);
                if (vgmWgt[i] != null)
                    model.setVgmWgt(vgmWgt[i]);
                if (vgmWgtUtCd[i] != null)
                    model.setVgmWgtUtCd(vgmWgtUtCd[i]);
                if (totalVgmCnt[i] != null)
                    model.setTotalVgmCnt(totalVgmCnt[i]);
                if (vgmFlg[i] != null)
                    model.setVgmFlg(vgmFlg[i]);
                if (totalCntrCnt[i] != null)
                    model.setTotalCntrCnt(totalCntrCnt[i]);
                if (totalNoVgmCnt[i] != null)
                    model.setTotalNoVgmCnt(totalNoVgmCnt[i]);
                if (vgmVrfySigCtnt[i] != null)
                    model.setVgmVrfySigCtnt(vgmVrfySigCtnt[i]);
                if (vgmMzdTpCd[i] != null)
                    model.setVgmMzdTpCd(vgmMzdTpCd[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgClearanceCrossCheckListInVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgClearanceCrossCheckListInVO[]
	 */
    public BkgClearanceCrossCheckListInVO[] getBkgClearanceCrossCheckListInVOs() {
        BkgClearanceCrossCheckListInVO[] vos = (BkgClearanceCrossCheckListInVO[]) models.toArray(new BkgClearanceCrossCheckListInVO[models.size()]);
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
        this.bkgCgoTpCd = this.bkgCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.denseRank = this.denseRank.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.via = this.via.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalCharge = this.totalCharge.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.por = this.por.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalCfm = this.totalCfm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalBkgF = this.totalBkgF.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowsPerPage = this.rowsPerPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pBkgOfcCd = this.pBkgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ff = this.ff.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pol = this.pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalBkgT = this.totalBkgT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalCnt = this.totalCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pDcgoFlg = this.pDcgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pPolCd = this.pPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pod = this.pod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pCustSeq = this.pCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pEqType = this.pEqType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pCnmvStsCd = this.pCnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.receiving = this.receiving.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pBkgStsCd = this.pBkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.statusComplete = this.statusComplete.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpcsRate = this.dpcsRate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pNoGood = this.pNoGood.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.qtyCntr = this.qtyCntr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shipperCode = this.shipperCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowsPerBkg = this.rowsPerBkg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pDelConti = this.pDelConti.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.consignee = this.consignee.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrRnum = this.ctrRnum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apprval = this.apprval.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalIssue = this.totalIssue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pRcvTermCd = this.pRcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.md = this.md.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdr = this.bdr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.qtyBkg = this.qtyBkg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.del = this.del.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalCtrlT = this.totalCtrlT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pDeTermCd = this.pDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpcsF = this.dpcsF.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pPolYdCd = this.pPolYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porNodCd = this.porNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpcsBlProof = this.dpcsBlProof.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.peb = this.peb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpcsI = this.dpcsI.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.firm = this.firm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shipper = this.shipper.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCfmFlg = this.cntrCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalCtrlF = this.totalCtrlF.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hitchmentYn = this.hitchmentYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pRcFlg = this.pRcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalVl = this.totalVl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpcsR = this.dpcsR.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.broker = this.broker.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pOblIssOfcCd = this.pOblIssOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpcsQ = this.dpcsQ.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.elNo = this.elNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalBkg = this.totalBkg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pCustCntCd = this.pCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalReceiving = this.totalReceiving.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pObSlsOfcCd = this.pObSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pCtrtOfcCd = this.pCtrtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pCtrtSrepCd = this.pCtrtSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currPage = this.currPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.statusOpen = this.statusOpen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rnum = this.rnum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delNodCd = this.delNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obSlsOfcCd = this.obSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtOfcCd = this.ctrtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aesYn = this.aesYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.st = this.st.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sz = this.sz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pVvd = this.pVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pDpcsFlg = this.pDpcsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aes = this.aes.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tvvd = this.tvvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pkg = this.pkg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pAwkCgoFlg = this.pAwkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pBbCgoFlg = this.pBbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pSiFlg = this.pSiFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cm = this.cm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxId = this.taxId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalBl = this.totalBl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pObSrepCd = this.pObSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pCustNm = this.pCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.weight = this.weight.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pApodLt = this.pApodLt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dde = this.dde.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalApprval = this.totalApprval.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issue = this.issue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measuere = this.measuere.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.specialR = this.specialR.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpcsTtl = this.dpcsTtl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vol = this.vol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pOfcCd = this.pOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seal = this.seal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caed = this.caed.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pDelCd = this.pDelCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pBdrFlg = this.pBdrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.specialD = this.specialD.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.specialA = this.specialA.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.specialB = this.specialB.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgOfcNo = this.bkgOfcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalCm = this.totalCm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpcsSts = this.dpcsSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pDocUsrId = this.pDocUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpcsQa = this.dpcsQa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.denseRank2 = this.denseRank2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pPolLt = this.pPolLt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pBkgCustTpCd = this.pBkgCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pZoneCd = this.pZoneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.statusPending = this.statusPending.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpcsInput = this.dpcsInput.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.charge = this.charge.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalMd = this.totalMd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pPorCd = this.pPorCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pApodCd = this.pApodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.entrClssTpCd = this.entrClssTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custTp = this.custTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.multiVvd = this.multiVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polEtdFrDt = this.polEtdFrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polEtdToDt = this.polEtdToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyVvd = this.keyVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCheck = this.cntrCheck.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDupVvd = this.chkDupVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffdr = this.ffdr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrWgt = this.cntrWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pSocCgoFlg = this.pSocCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pSireadyFlg = this.pSireadyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sireadyFlg = this.sireadyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lOfcSub = this.lOfcSub.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cOfcSub = this.cOfcSub.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measQty = this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eventYard = this.eventYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eventDt = this.eventDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCfmId = this.cntrCfmId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmWgt = this.vgmWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmWgtUtCd = this.vgmWgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalVgmCnt = this.totalVgmCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmFlg = this.vgmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalCntrCnt = this.totalCntrCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalNoVgmCnt = this.totalNoVgmCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmVrfySigCtnt = this.vgmVrfySigCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmMzdTpCd = this.vgmMzdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blckStwgCd = this.blckStwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obSrepCd = this.obSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
