/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgmtInfoVO.java
*@FileTitle : AgmtInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.21
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.21 김봉균
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgmtInfoVO extends AbstractValueObject {  

	private static final long serialVersionUID = 1L;

	private Collection<AgmtInfoVO> models = new ArrayList<AgmtInfoVO>();

	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String porAr = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String ddctTrs = null;
	/* Column Info */
	private String payFxComm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnAgmtSeq = null;
	/* Column Info */
	private String polFinc = null;
	/* Column Info */
	private String tsSaDt = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String maxSpclCmpnSeq = null;
	/* Column Info */
	private String rteu = null;
	/* Column Info */
	private String tsRevDirCd = null;
	/* Column Info */
	private String ofcCurrCd = null;
	/* Column Info */
	private String chnAgnCd = null;
	/* Column Info */
	private String acTpCd = null;
	/* Column Info */
	private String fdrgDdctDestFlg = null;
	/* Column Info */
	private String feu = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String bkgChgRtCount = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String commRt = null;
	/* Column Info */
	private String commFxAmt = null;
	/* Column Info */
	private String porFinc = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String tsRlaneCd = null;
	/* Column Info */
	private String ppdCrntSpclAmt = null;
	/* Column Info */
	private String hlgDdctOrgFlg = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cltChgAmt = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String rnk1 = null;
	/* Column Info */
	private String oftPayTermCd = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String ttlRevAmt = null;
	/* Column Info */
	private String polAr = null;
	/* Column Info */
	private String ppdPayCrntAmt = null;
	/* Column Info */
	private String tsLoc = null;
	/* Column Info */
	private String cnObAr = null;
	/* Column Info */
	private String ddctChg = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String commPayTermCd = null;
	/* Column Info */
	private String comm = null;
	/* Column Info */
	private String maxAcSeq = null;
	/* Column Info */
	private String ddctSpcl = null;
	/* Column Info */
	private String usdFxComm = null;
	/* Column Info */
	private String usdFxComm2 = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String cnObFinc = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String tsVslCd = null;
	/* Column Info */
	private String delFinc = null;
	/* Column Info */
	private String ppdCrntAmt = null;
	/* Column Info */
	private String revMon = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String agnInfoSeq = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String tsSkdDirCd = null;
	/* Column Info */
	private String tsAr = null;
	/* Column Info */
	private String agmtCurrCd = null;
	/* Column Info */
	private String fdrgDdctOrgFlg = null;
	/* Column Info */
	private String fxRealAmt = null;
	/* Column Info */
	private String matCntChg = null;
	/* Column Info */
	private String dupChkCnt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ofcChrCd = null;
	/* Column Info */
	private String bkgAr = null;
	/* Column Info */
	private String ppdChgAmt = null;
	/* Column Info */
	private String podFinc = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String apCtrCd = null;
	/* Column Info */
	private String commRev = null;
	/* Column Info */
	private String cltOfrtAmt = null;
	/* Column Info */
	private String tsSkdVoyNo = null;
	/* Column Info */
	private String revDivCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String agnAgmtNo = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgOfc = null;
	/* Column Info */
	private String saDt = null;
	/* Column Info */
	private String usdLoclXchRt = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String rbox = null;
	/* Column Info */
	private String cnIbAr = null;
	/* Column Info */
	private String payXchRt = null;
	/* Column Info */
	private String payXchRt2 = null;
	/* Column Info */
	private String rfeu = null;
	/* Column Info */
	private String sumMatCnt = null;
	/* Column Info */
	private String tsSlanCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String podAr = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String tsFinc = null;
	/* Column Info */
	private String commAmt = null;
	/* Column Info */
	private String ppdOfrtAmt = null;
	/* Column Info */
	private String xchRtDivLvl = null;
	/* Column Info */
	private String cnIbFinc = null;
	/* Column Info */
	private String box = null;
	/* Column Info */
	private String delAr = null;
	/* Column Info */
	private String hlgDdctDestFlg = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String ctrtAr = null;
	/* Column Info */
	private String commOfcCd = null;
	/* Column Info */
	private String mhFlg = null;
	/* Column Info */
	private String diffCurrFlg = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public AgmtInfoVO() {}

	public AgmtInfoVO(String ibflag, String pagerows, String agnCd, String agnAgmtNo, String ioBndCd, String acTpCd, String agnAgmtSeq, String matCntChg, String hlgDdctOrgFlg, String hlgDdctDestFlg, String fdrgDdctOrgFlg, String fdrgDdctDestFlg, String fullMtyCd, String agmtCurrCd, String commFxAmt, String commPayTermCd, String revDivCd, String commRt, String arOfcCd, String ofcCurrCd, String xchRtDivLvl, String ofcChrCd, String vndrCntCd, String vndrSeq, String agnInfoSeq, String rhqCd, String sumMatCnt, String rnk1, String dupChkCnt, String tsSaDt, String tsLoc, String tsSlanCd, String tsRlaneCd, String tsVslCd, String tsSkdVoyNo, String tsSkdDirCd, String tsRevDirCd, String bkgNo, String port, String vslCd, String skdVoyNo, String skdDirCd, String svcScpCd, String saDt, String chnAgnCd, String revMon, String bkgCreDt, String rtAplyDt, String maxAcSeq, String maxSpclCmpnSeq, String ppdCrntSpclAmt, String commRev, String ddctSpcl, String ddctChg, String ddctTrs, String commAmt, String ppdCrntAmt, String ppdPayCrntAmt, String usdLoclXchRt, String usdFxComm2, String comm, String bdrFlg, String ttlRevAmt, String apOfcCd, String apCtrCd, String slanCd, String rlaneCd, String revDirCd, String payXchRt, String payXchRt2,String ppdOfrtAmt, String ppdChgAmt, String cltOfrtAmt, String cltChgAmt, String box, String teu, String feu, String rbox, String rteu, String rfeu, String usrId, String fxRealAmt, String usdFxComm, String payFxComm, String oftPayTermCd, String bkgChgRtCount, String bkgOfc, String bkgAr, String porFinc, String porAr, String polFinc, String polAr, String podFinc, String podAr, String delFinc, String delAr, String cltOfcCd, String vslPrePstCd, String tsFinc, String tsAr, String cnObFinc, String cnObAr, String cnIbFinc, String cnIbAr, String ctrtAr, String ctrtOfcCd, String commOfcCd, String mhFlg, String diffCurrFlg) {
		this.svcScpCd = svcScpCd;
		this.porAr = porAr;
		this.cltOfcCd = cltOfcCd;
		this.ddctTrs = ddctTrs;
		this.payFxComm = payFxComm;
		this.pagerows = pagerows;
		this.agnAgmtSeq = agnAgmtSeq;
		this.polFinc = polFinc;
		this.tsSaDt = tsSaDt;
		this.bkgCreDt = bkgCreDt;
		this.maxSpclCmpnSeq = maxSpclCmpnSeq;
		this.rteu = rteu;
		this.tsRevDirCd = tsRevDirCd;
		this.ofcCurrCd = ofcCurrCd;
		this.chnAgnCd = chnAgnCd;
		this.acTpCd = acTpCd;
		this.fdrgDdctDestFlg = fdrgDdctDestFlg;
		this.feu = feu;
		this.apOfcCd = apOfcCd;
		this.bkgChgRtCount = bkgChgRtCount;
		this.rhqCd = rhqCd;
		this.commRt = commRt;
		this.commFxAmt = commFxAmt;
		this.porFinc = porFinc;
		this.skdVoyNo = skdVoyNo;
		this.tsRlaneCd = tsRlaneCd;
		this.ppdCrntSpclAmt = ppdCrntSpclAmt;
		this.hlgDdctOrgFlg = hlgDdctOrgFlg;
		this.bkgNo = bkgNo;
		this.cltChgAmt = cltChgAmt;
		this.fullMtyCd = fullMtyCd;
		this.rnk1 = rnk1;
		this.oftPayTermCd = oftPayTermCd;
		this.port = port;
		this.ttlRevAmt = ttlRevAmt;
		this.polAr = polAr;
		this.ppdPayCrntAmt = ppdPayCrntAmt;
		this.tsLoc = tsLoc;
		this.cnObAr = cnObAr;
		this.ddctChg = ddctChg;
		this.usrId = usrId;
		this.commPayTermCd = commPayTermCd;
		this.comm = comm;
		this.maxAcSeq = maxAcSeq;
		this.ddctSpcl = ddctSpcl;
		this.usdFxComm = usdFxComm;
		this.usdFxComm2 = usdFxComm2;
		this.arOfcCd = arOfcCd;
		this.cnObFinc = cnObFinc;
		this.slanCd = slanCd;
		this.tsVslCd = tsVslCd;
		this.delFinc = delFinc;
		this.ppdCrntAmt = ppdCrntAmt;
		this.revMon = revMon;
		this.vslCd = vslCd;
		this.vndrCntCd = vndrCntCd;
		this.agnInfoSeq = agnInfoSeq;
		this.rtAplyDt = rtAplyDt;
		this.rlaneCd = rlaneCd;
		this.tsSkdDirCd = tsSkdDirCd;
		this.tsAr = tsAr;
		this.agmtCurrCd = agmtCurrCd;
		this.fdrgDdctOrgFlg = fdrgDdctOrgFlg;
		this.fxRealAmt = fxRealAmt;
		this.matCntChg = matCntChg;
		this.dupChkCnt = dupChkCnt;
		this.vndrSeq = vndrSeq;
		this.ofcChrCd = ofcChrCd;
		this.bkgAr = bkgAr;
		this.ppdChgAmt = ppdChgAmt;
		this.podFinc = podFinc;
		this.teu = teu;
		this.apCtrCd = apCtrCd;
		this.commRev = commRev;
		this.cltOfrtAmt = cltOfrtAmt;
		this.tsSkdVoyNo = tsSkdVoyNo;
		this.revDivCd = revDivCd;
		this.bdrFlg = bdrFlg;
		this.agnAgmtNo = agnAgmtNo;
		this.agnCd = agnCd;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.bkgOfc = bkgOfc;
		this.saDt = saDt;
		this.usdLoclXchRt = usdLoclXchRt;
		this.vslPrePstCd = vslPrePstCd;
		this.rbox = rbox;
		this.cnIbAr = cnIbAr;
		this.payXchRt = payXchRt;
		this.payXchRt2 = payXchRt2;
		this.rfeu = rfeu;
		this.sumMatCnt = sumMatCnt;
		this.tsSlanCd = tsSlanCd;
		this.ioBndCd = ioBndCd;
		this.podAr = podAr;
		this.skdDirCd = skdDirCd;
		this.tsFinc = tsFinc;
		this.commAmt = commAmt;
		this.ppdOfrtAmt = ppdOfrtAmt;
		this.xchRtDivLvl = xchRtDivLvl;
		this.cnIbFinc = cnIbFinc;
		this.box = box;
		this.delAr = delAr;
		this.hlgDdctDestFlg = hlgDdctDestFlg;
		this.ctrtOfcCd = ctrtOfcCd;
		this.ctrtAr = ctrtAr;
		this.commOfcCd = commOfcCd;
		this.mhFlg = mhFlg;
		this.diffCurrFlg = diffCurrFlg;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("por_ar", getPorAr());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("ddct_trs", getDdctTrs());
		this.hashColumns.put("pay_fx_comm", getPayFxComm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_agmt_seq", getAgnAgmtSeq());
		this.hashColumns.put("pol_finc", getPolFinc());
		this.hashColumns.put("ts_sa_dt", getTsSaDt());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("max_spcl_cmpn_seq", getMaxSpclCmpnSeq());
		this.hashColumns.put("rteu", getRteu());
		this.hashColumns.put("ts_rev_dir_cd", getTsRevDirCd());
		this.hashColumns.put("ofc_curr_cd", getOfcCurrCd());
		this.hashColumns.put("chn_agn_cd", getChnAgnCd());
		this.hashColumns.put("ac_tp_cd", getAcTpCd());
		this.hashColumns.put("fdrg_ddct_dest_flg", getFdrgDdctDestFlg());
		this.hashColumns.put("feu", getFeu());
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());
		this.hashColumns.put("bkg_chg_rt_count", getBkgChgRtCount());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("comm_rt", getCommRt());
		this.hashColumns.put("comm_fx_amt", getCommFxAmt());
		this.hashColumns.put("por_finc", getPorFinc());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ts_rlane_cd", getTsRlaneCd());
		this.hashColumns.put("ppd_crnt_spcl_amt", getPpdCrntSpclAmt());
		this.hashColumns.put("hlg_ddct_org_flg", getHlgDdctOrgFlg());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("clt_chg_amt", getCltChgAmt());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("rnk1", getRnk1());
		this.hashColumns.put("oft_pay_term_cd", getOftPayTermCd());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("ttl_rev_amt", getTtlRevAmt());
		this.hashColumns.put("pol_ar", getPolAr());
		this.hashColumns.put("ppd_pay_crnt_amt", getPpdPayCrntAmt());
		this.hashColumns.put("ts_loc", getTsLoc());
		this.hashColumns.put("cn_ob_ar", getCnObAr());
		this.hashColumns.put("ddct_chg", getDdctChg());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("comm_pay_term_cd", getCommPayTermCd());
		this.hashColumns.put("comm", getComm());
		this.hashColumns.put("max_ac_seq", getMaxAcSeq());
		this.hashColumns.put("ddct_spcl", getDdctSpcl());
		this.hashColumns.put("usd_fx_comm", getUsdFxComm());
		this.hashColumns.put("usd_fx_comm2", getUsdFxComm2());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("cn_ob_finc", getCnObFinc());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("ts_vsl_cd", getTsVslCd());
		this.hashColumns.put("del_finc", getDelFinc());
		this.hashColumns.put("ppd_crnt_amt", getPpdCrntAmt());
		this.hashColumns.put("rev_mon", getRevMon());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("agn_info_seq", getAgnInfoSeq());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ts_skd_dir_cd", getTsSkdDirCd());
		this.hashColumns.put("ts_ar", getTsAr());
		this.hashColumns.put("agmt_curr_cd", getAgmtCurrCd());
		this.hashColumns.put("fdrg_ddct_org_flg", getFdrgDdctOrgFlg());
		this.hashColumns.put("fx_real_amt", getFxRealAmt());
		this.hashColumns.put("mat_cnt_chg", getMatCntChg());
		this.hashColumns.put("dup_chk_cnt", getDupChkCnt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ofc_chr_cd", getOfcChrCd());
		this.hashColumns.put("bkg_ar", getBkgAr());
		this.hashColumns.put("ppd_chg_amt", getPpdChgAmt());
		this.hashColumns.put("pod_finc", getPodFinc());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("ap_ctr_cd", getApCtrCd());
		this.hashColumns.put("comm_rev", getCommRev());
		this.hashColumns.put("clt_ofrt_amt", getCltOfrtAmt());
		this.hashColumns.put("ts_skd_voy_no", getTsSkdVoyNo());
		this.hashColumns.put("rev_div_cd", getRevDivCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("agn_agmt_no", getAgnAgmtNo());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_ofc", getBkgOfc());
		this.hashColumns.put("sa_dt", getSaDt());
		this.hashColumns.put("usd_locl_xch_rt", getUsdLoclXchRt());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("rbox", getRbox());
		this.hashColumns.put("cn_ib_ar", getCnIbAr());
		this.hashColumns.put("pay_xch_rt", getPayXchRt());
		this.hashColumns.put("pay_xch_rt2", getPayXchRt2());
		this.hashColumns.put("rfeu", getRfeu());
		this.hashColumns.put("sum_mat_cnt", getSumMatCnt());
		this.hashColumns.put("ts_slan_cd", getTsSlanCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pod_ar", getPodAr());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ts_finc", getTsFinc());
		this.hashColumns.put("comm_amt", getCommAmt());
		this.hashColumns.put("ppd_ofrt_amt", getPpdOfrtAmt());
		this.hashColumns.put("xch_rt_div_lvl", getXchRtDivLvl());
		this.hashColumns.put("cn_ib_finc", getCnIbFinc());
		this.hashColumns.put("box", getBox());
		this.hashColumns.put("del_ar", getDelAr());
		this.hashColumns.put("hlg_ddct_dest_flg", getHlgDdctDestFlg());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("ctrt_ar", getCtrtAr());
		this.hashColumns.put("comm_ofc_cd", getCommOfcCd());
		this.hashColumns.put("mh_flg", getMhFlg());
		this.hashColumns.put("diff_curr_flg", getDiffCurrFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("por_ar", "porAr");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("ddct_trs", "ddctTrs");
		this.hashFields.put("pay_fx_comm", "payFxComm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_agmt_seq", "agnAgmtSeq");
		this.hashFields.put("pol_finc", "polFinc");
		this.hashFields.put("ts_sa_dt", "tsSaDt");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("max_spcl_cmpn_seq", "maxSpclCmpnSeq");
		this.hashFields.put("rteu", "rteu");
		this.hashFields.put("ts_rev_dir_cd", "tsRevDirCd");
		this.hashFields.put("ofc_curr_cd", "ofcCurrCd");
		this.hashFields.put("chn_agn_cd", "chnAgnCd");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("fdrg_ddct_dest_flg", "fdrgDdctDestFlg");
		this.hashFields.put("feu", "feu");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("bkg_chg_rt_count", "bkgChgRtCount");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("comm_rt", "commRt");
		this.hashFields.put("comm_fx_amt", "commFxAmt");
		this.hashFields.put("por_finc", "porFinc");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ts_rlane_cd", "tsRlaneCd");
		this.hashFields.put("ppd_crnt_spcl_amt", "ppdCrntSpclAmt");
		this.hashFields.put("hlg_ddct_org_flg", "hlgDdctOrgFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("clt_chg_amt", "cltChgAmt");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("rnk1", "rnk1");
		this.hashFields.put("oft_pay_term_cd", "oftPayTermCd");
		this.hashFields.put("port", "port");
		this.hashFields.put("ttl_rev_amt", "ttlRevAmt");
		this.hashFields.put("pol_ar", "polAr");
		this.hashFields.put("ppd_pay_crnt_amt", "ppdPayCrntAmt");
		this.hashFields.put("ts_loc", "tsLoc");
		this.hashFields.put("cn_ob_ar", "cnObAr");
		this.hashFields.put("ddct_chg", "ddctChg");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("comm_pay_term_cd", "commPayTermCd");
		this.hashFields.put("comm", "comm");
		this.hashFields.put("max_ac_seq", "maxAcSeq");
		this.hashFields.put("ddct_spcl", "ddctSpcl");
		this.hashFields.put("usd_fx_comm", "usdFxComm");
		this.hashFields.put("usd_fx_comm2", "usdFxComm2");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cn_ob_finc", "cnObFinc");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("ts_vsl_cd", "tsVslCd");
		this.hashFields.put("del_finc", "delFinc");
		this.hashFields.put("ppd_crnt_amt", "ppdCrntAmt");
		this.hashFields.put("rev_mon", "revMon");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("agn_info_seq", "agnInfoSeq");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ts_skd_dir_cd", "tsSkdDirCd");
		this.hashFields.put("ts_ar", "tsAr");
		this.hashFields.put("agmt_curr_cd", "agmtCurrCd");
		this.hashFields.put("fdrg_ddct_org_flg", "fdrgDdctOrgFlg");
		this.hashFields.put("fx_real_amt", "fxRealAmt");
		this.hashFields.put("mat_cnt_chg", "matCntChg");
		this.hashFields.put("dup_chk_cnt", "dupChkCnt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ofc_chr_cd", "ofcChrCd");
		this.hashFields.put("bkg_ar", "bkgAr");
		this.hashFields.put("ppd_chg_amt", "ppdChgAmt");
		this.hashFields.put("pod_finc", "podFinc");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("ap_ctr_cd", "apCtrCd");
		this.hashFields.put("comm_rev", "commRev");
		this.hashFields.put("clt_ofrt_amt", "cltOfrtAmt");
		this.hashFields.put("ts_skd_voy_no", "tsSkdVoyNo");
		this.hashFields.put("rev_div_cd", "revDivCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("agn_agmt_no", "agnAgmtNo");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_ofc", "bkgOfc");
		this.hashFields.put("sa_dt", "saDt");
		this.hashFields.put("usd_locl_xch_rt", "usdLoclXchRt");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("rbox", "rbox");
		this.hashFields.put("cn_ib_ar", "cnIbAr");
		this.hashFields.put("pay_xch_rt", "payXchRt");
		this.hashFields.put("pay_xch_rt2", "payXchRt2");
		this.hashFields.put("rfeu", "rfeu");
		this.hashFields.put("sum_mat_cnt", "sumMatCnt");
		this.hashFields.put("ts_slan_cd", "tsSlanCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pod_ar", "podAr");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ts_finc", "tsFinc");
		this.hashFields.put("comm_amt", "commAmt");
		this.hashFields.put("ppd_ofrt_amt", "ppdOfrtAmt");
		this.hashFields.put("xch_rt_div_lvl", "xchRtDivLvl");
		this.hashFields.put("cn_ib_finc", "cnIbFinc");
		this.hashFields.put("box", "box");
		this.hashFields.put("del_ar", "delAr");
		this.hashFields.put("hlg_ddct_dest_flg", "hlgDdctDestFlg");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("ctrt_ar", "ctrtAr");
		this.hashFields.put("comm_ofc_cd", "commOfcCd");
		this.hashFields.put("mh_flg", "mhFlg");
		this.hashFields.put("diff_curr_flg", "diffCurrFlg");
		return this.hashFields;
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
	 * @return porAr
	 */
	public String getPorAr() {
		return this.porAr;
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
	 * @return ddctTrs
	 */
	public String getDdctTrs() {
		return this.ddctTrs;
	}

	/**
	 * Column Info
	 * @return payFxComm
	 */
	public String getPayFxComm() {
		return this.payFxComm;
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
	 * @return agnAgmtSeq
	 */
	public String getAgnAgmtSeq() {
		return this.agnAgmtSeq;
	}

	/**
	 * Column Info
	 * @return polFinc
	 */
	public String getPolFinc() {
		return this.polFinc;
	}

	/**
	 * Column Info
	 * @return tsSaDt
	 */
	public String getTsSaDt() {
		return this.tsSaDt;
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
	 * @return maxSpclCmpnSeq
	 */
	public String getMaxSpclCmpnSeq() {
		return this.maxSpclCmpnSeq;
	}

	/**
	 * Column Info
	 * @return rteu
	 */
	public String getRteu() {
		return this.rteu;
	}

	/**
	 * Column Info
	 * @return tsRevDirCd
	 */
	public String getTsRevDirCd() {
		return this.tsRevDirCd;
	}

	/**
	 * Column Info
	 * @return ofcCurrCd
	 */
	public String getOfcCurrCd() {
		return this.ofcCurrCd;
	}

	/**
	 * Column Info
	 * @return chnAgnCd
	 */
	public String getChnAgnCd() {
		return this.chnAgnCd;
	}

	/**
	 * Column Info
	 * @return acTpCd
	 */
	public String getAcTpCd() {
		return this.acTpCd;
	}

	/**
	 * Column Info
	 * @return fdrgDdctDestFlg
	 */
	public String getFdrgDdctDestFlg() {
		return this.fdrgDdctDestFlg;
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
	 * @return apOfcCd
	 */
	public String getApOfcCd() {
		return this.apOfcCd;
	}

	/**
	 * Column Info
	 * @return bkgChgRtCount
	 */
	public String getBkgChgRtCount() {
		return this.bkgChgRtCount;
	}

	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}

	/**
	 * Column Info
	 * @return commRt
	 */
	public String getCommRt() {
		return this.commRt;
	}

	/**
	 * Column Info
	 * @return commFxAmt
	 */
	public String getCommFxAmt() {
		return this.commFxAmt;
	}

	/**
	 * Column Info
	 * @return porFinc
	 */
	public String getPorFinc() {
		return this.porFinc;
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
	 * @return tsRlaneCd
	 */
	public String getTsRlaneCd() {
		return this.tsRlaneCd;
	}

	/**
	 * Column Info
	 * @return ppdCrntSpclAmt
	 */
	public String getPpdCrntSpclAmt() {
		return this.ppdCrntSpclAmt;
	}

	/**
	 * Column Info
	 * @return hlgDdctOrgFlg
	 */
	public String getHlgDdctOrgFlg() {
		return this.hlgDdctOrgFlg;
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
	 * @return cltChgAmt
	 */
	public String getCltChgAmt() {
		return this.cltChgAmt;
	}

	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}

	/**
	 * Column Info
	 * @return rnk1
	 */
	public String getRnk1() {
		return this.rnk1;
	}

	/**
	 * Column Info
	 * @return oftPayTermCd
	 */
	public String getOftPayTermCd() {
		return this.oftPayTermCd;
	}

	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}

	/**
	 * Column Info
	 * @return ttlRevAmt
	 */
	public String getTtlRevAmt() {
		return this.ttlRevAmt;
	}

	/**
	 * Column Info
	 * @return polAr
	 */
	public String getPolAr() {
		return this.polAr;
	}

	/**
	 * Column Info
	 * @return ppdPayCrntAmt
	 */
	public String getPpdPayCrntAmt() {
		return this.ppdPayCrntAmt;
	}

	/**
	 * Column Info
	 * @return tsLoc
	 */
	public String getTsLoc() {
		return this.tsLoc;
	}

	/**
	 * Column Info
	 * @return cnObAr
	 */
	public String getCnObAr() {
		return this.cnObAr;
	}

	/**
	 * Column Info
	 * @return ddctChg
	 */
	public String getDdctChg() {
		return this.ddctChg;
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
	 * @return commPayTermCd
	 */
	public String getCommPayTermCd() {
		return this.commPayTermCd;
	}

	/**
	 * Column Info
	 * @return comm
	 */
	public String getComm() {
		return this.comm;
	}

	/**
	 * Column Info
	 * @return maxAcSeq
	 */
	public String getMaxAcSeq() {
		return this.maxAcSeq;
	}

	/**
	 * Column Info
	 * @return ddctSpcl
	 */
	public String getDdctSpcl() {
		return this.ddctSpcl;
	}

	/**
	 * Column Info
	 * @return usdFxComm
	 */
	public String getUsdFxComm() {
		return this.usdFxComm;
	}
	
	/**
	 * Column Info
	 * @return usdFxComm2
	 */
	public String getUsdFxComm2() {
		return this.usdFxComm2;
	}

	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}

	/**
	 * Column Info
	 * @return cnObFinc
	 */
	public String getCnObFinc() {
		return this.cnObFinc;
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
	 * @return tsVslCd
	 */
	public String getTsVslCd() {
		return this.tsVslCd;
	}

	/**
	 * Column Info
	 * @return delFinc
	 */
	public String getDelFinc() {
		return this.delFinc;
	}

	/**
	 * Column Info
	 * @return ppdCrntAmt
	 */
	public String getPpdCrntAmt() {
		return this.ppdCrntAmt;
	}

	/**
	 * Column Info
	 * @return revMon
	 */
	public String getRevMon() {
		return this.revMon;
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
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}

	/**
	 * Column Info
	 * @return agnInfoSeq
	 */
	public String getAgnInfoSeq() {
		return this.agnInfoSeq;
	}

	/**
	 * Column Info
	 * @return rtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
	}

	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}

	/**
	 * Column Info
	 * @return tsSkdDirCd
	 */
	public String getTsSkdDirCd() {
		return this.tsSkdDirCd;
	}

	/**
	 * Column Info
	 * @return tsAr
	 */
	public String getTsAr() {
		return this.tsAr;
	}

	/**
	 * Column Info
	 * @return agmtCurrCd
	 */
	public String getAgmtCurrCd() {
		return this.agmtCurrCd;
	}

	/**
	 * Column Info
	 * @return fdrgDdctOrgFlg
	 */
	public String getFdrgDdctOrgFlg() {
		return this.fdrgDdctOrgFlg;
	}

	/**
	 * Column Info
	 * @return fxRealAmt
	 */
	public String getFxRealAmt() {
		return this.fxRealAmt;
	}

	/**
	 * Column Info
	 * @return matCntChg
	 */
	public String getMatCntChg() {
		return this.matCntChg;
	}

	/**
	 * Column Info
	 * @return dupChkCnt
	 */
	public String getDupChkCnt() {
		return this.dupChkCnt;
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
	 * @return ofcChrCd
	 */
	public String getOfcChrCd() {
		return this.ofcChrCd;
	}

	/**
	 * Column Info
	 * @return bkgAr
	 */
	public String getBkgAr() {
		return this.bkgAr;
	}

	/**
	 * Column Info
	 * @return ppdChgAmt
	 */
	public String getPpdChgAmt() {
		return this.ppdChgAmt;
	}

	/**
	 * Column Info
	 * @return podFinc
	 */
	public String getPodFinc() {
		return this.podFinc;
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
	 * @return apCtrCd
	 */
	public String getApCtrCd() {
		return this.apCtrCd;
	}

	/**
	 * Column Info
	 * @return commRev
	 */
	public String getCommRev() {
		return this.commRev;
	}

	/**
	 * Column Info
	 * @return cltOfrtAmt
	 */
	public String getCltOfrtAmt() {
		return this.cltOfrtAmt;
	}

	/**
	 * Column Info
	 * @return tsSkdVoyNo
	 */
	public String getTsSkdVoyNo() {
		return this.tsSkdVoyNo;
	}

	/**
	 * Column Info
	 * @return revDivCd
	 */
	public String getRevDivCd() {
		return this.revDivCd;
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
	 * @return agnAgmtNo
	 */
	public String getAgnAgmtNo() {
		return this.agnAgmtNo;
	}

	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}

	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
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
	 * @return bkgOfc
	 */
	public String getBkgOfc() {
		return this.bkgOfc;
	}

	/**
	 * Column Info
	 * @return saDt
	 */
	public String getSaDt() {
		return this.saDt;
	}

	/**
	 * Column Info
	 * @return usdLoclXchRt
	 */
	public String getUsdLoclXchRt() {
		return this.usdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
	}

	/**
	 * Column Info
	 * @return rbox
	 */
	public String getRbox() {
		return this.rbox;
	}

	/**
	 * Column Info
	 * @return cnIbAr
	 */
	public String getCnIbAr() {
		return this.cnIbAr;
	}

	/**
	 * Column Info
	 * @return payXchRt
	 */
	public String getPayXchRt() {
		return this.payXchRt;
	}
	
	/**
	 * Column Info
	 * @return payXchRt2
	 */
	public String getPayXchRt2() {
		return this.payXchRt2;
	}

	/**
	 * Column Info
	 * @return rfeu
	 */
	public String getRfeu() {
		return this.rfeu;
	}

	/**
	 * Column Info
	 * @return sumMatCnt
	 */
	public String getSumMatCnt() {
		return this.sumMatCnt;
	}

	/**
	 * Column Info
	 * @return tsSlanCd
	 */
	public String getTsSlanCd() {
		return this.tsSlanCd;
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
	 * @return podAr
	 */
	public String getPodAr() {
		return this.podAr;
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
	 * @return tsFinc
	 */
	public String getTsFinc() {
		return this.tsFinc;
	}

	/**
	 * Column Info
	 * @return commAmt
	 */
	public String getCommAmt() {
		return this.commAmt;
	}

	/**
	 * Column Info
	 * @return ppdOfrtAmt
	 */
	public String getPpdOfrtAmt() {
		return this.ppdOfrtAmt;
	}

	/**
	 * Column Info
	 * @return xchRtDivLvl
	 */
	public String getXchRtDivLvl() {
		return this.xchRtDivLvl;
	}

	/**
	 * Column Info
	 * @return cnIbFinc
	 */
	public String getCnIbFinc() {
		return this.cnIbFinc;
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
	 * @return delAr
	 */
	public String getDelAr() {
		return this.delAr;
	}

	/**
	 * Column Info
	 * @return hlgDdctDestFlg
	 */
	public String getHlgDdctDestFlg() {
		return this.hlgDdctDestFlg;
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
	 * @return ctrtAr
	 */
	public String getCtrtAr() {
		return this.ctrtAr;
	}
	
	/**
	 * Column Info
	 * @return commOfcCd
	 */
	public String getCommOfcCd() {
		return this.commOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mhFlg
	 */
	public String getMhFlg() {
		return this.mhFlg;
	}
	
	/**
	 * Column Info
	 * @return diffCurrFlg
	 */
	public String getDiffCurrFlg() {
		return this.diffCurrFlg;
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
	 * @param porAr
	 */
	public void setPorAr(String porAr) {
		this.porAr = porAr;
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
	 * @param ddctTrs
	 */
	public void setDdctTrs(String ddctTrs) {
		this.ddctTrs = ddctTrs;
	}

	/**
	 * Column Info
	 * @param payFxComm
	 */
	public void setPayFxComm(String payFxComm) {
		this.payFxComm = payFxComm;
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
	 * @param agnAgmtSeq
	 */
	public void setAgnAgmtSeq(String agnAgmtSeq) {
		this.agnAgmtSeq = agnAgmtSeq;
	}

	/**
	 * Column Info
	 * @param polFinc
	 */
	public void setPolFinc(String polFinc) {
		this.polFinc = polFinc;
	}

	/**
	 * Column Info
	 * @param tsSaDt
	 */
	public void setTsSaDt(String tsSaDt) {
		this.tsSaDt = tsSaDt;
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
	 * @param maxSpclCmpnSeq
	 */
	public void setMaxSpclCmpnSeq(String maxSpclCmpnSeq) {
		this.maxSpclCmpnSeq = maxSpclCmpnSeq;
	}

	/**
	 * Column Info
	 * @param rteu
	 */
	public void setRteu(String rteu) {
		this.rteu = rteu;
	}

	/**
	 * Column Info
	 * @param tsRevDirCd
	 */
	public void setTsRevDirCd(String tsRevDirCd) {
		this.tsRevDirCd = tsRevDirCd;
	}

	/**
	 * Column Info
	 * @param ofcCurrCd
	 */
	public void setOfcCurrCd(String ofcCurrCd) {
		this.ofcCurrCd = ofcCurrCd;
	}

	/**
	 * Column Info
	 * @param chnAgnCd
	 */
	public void setChnAgnCd(String chnAgnCd) {
		this.chnAgnCd = chnAgnCd;
	}

	/**
	 * Column Info
	 * @param acTpCd
	 */
	public void setAcTpCd(String acTpCd) {
		this.acTpCd = acTpCd;
	}

	/**
	 * Column Info
	 * @param fdrgDdctDestFlg
	 */
	public void setFdrgDdctDestFlg(String fdrgDdctDestFlg) {
		this.fdrgDdctDestFlg = fdrgDdctDestFlg;
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
	 * @param apOfcCd
	 */
	public void setApOfcCd(String apOfcCd) {
		this.apOfcCd = apOfcCd;
	}

	/**
	 * Column Info
	 * @param bkgChgRtCount
	 */
	public void setBkgChgRtCount(String bkgChgRtCount) {
		this.bkgChgRtCount = bkgChgRtCount;
	}

	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}

	/**
	 * Column Info
	 * @param commRt
	 */
	public void setCommRt(String commRt) {
		this.commRt = commRt;
	}

	/**
	 * Column Info
	 * @param commFxAmt
	 */
	public void setCommFxAmt(String commFxAmt) {
		this.commFxAmt = commFxAmt;
	}

	/**
	 * Column Info
	 * @param porFinc
	 */
	public void setPorFinc(String porFinc) {
		this.porFinc = porFinc;
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
	 * @param tsRlaneCd
	 */
	public void setTsRlaneCd(String tsRlaneCd) {
		this.tsRlaneCd = tsRlaneCd;
	}

	/**
	 * Column Info
	 * @param ppdCrntSpclAmt
	 */
	public void setPpdCrntSpclAmt(String ppdCrntSpclAmt) {
		this.ppdCrntSpclAmt = ppdCrntSpclAmt;
	}

	/**
	 * Column Info
	 * @param hlgDdctOrgFlg
	 */
	public void setHlgDdctOrgFlg(String hlgDdctOrgFlg) {
		this.hlgDdctOrgFlg = hlgDdctOrgFlg;
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
	 * @param cltChgAmt
	 */
	public void setCltChgAmt(String cltChgAmt) {
		this.cltChgAmt = cltChgAmt;
	}

	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}

	/**
	 * Column Info
	 * @param rnk1
	 */
	public void setRnk1(String rnk1) {
		this.rnk1 = rnk1;
	}

	/**
	 * Column Info
	 * @param oftPayTermCd
	 */
	public void setOftPayTermCd(String oftPayTermCd) {
		this.oftPayTermCd = oftPayTermCd;
	}

	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * Column Info
	 * @param ttlRevAmt
	 */
	public void setTtlRevAmt(String ttlRevAmt) {
		this.ttlRevAmt = ttlRevAmt;
	}

	/**
	 * Column Info
	 * @param polAr
	 */
	public void setPolAr(String polAr) {
		this.polAr = polAr;
	}

	/**
	 * Column Info
	 * @param ppdPayCrntAmt
	 */
	public void setPpdPayCrntAmt(String ppdPayCrntAmt) {
		this.ppdPayCrntAmt = ppdPayCrntAmt;
	}

	/**
	 * Column Info
	 * @param tsLoc
	 */
	public void setTsLoc(String tsLoc) {
		this.tsLoc = tsLoc;
	}

	/**
	 * Column Info
	 * @param cnObAr
	 */
	public void setCnObAr(String cnObAr) {
		this.cnObAr = cnObAr;
	}

	/**
	 * Column Info
	 * @param ddctChg
	 */
	public void setDdctChg(String ddctChg) {
		this.ddctChg = ddctChg;
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
	 * @param commPayTermCd
	 */
	public void setCommPayTermCd(String commPayTermCd) {
		this.commPayTermCd = commPayTermCd;
	}

	/**
	 * Column Info
	 * @param comm
	 */
	public void setComm(String comm) {
		this.comm = comm;
	}

	/**
	 * Column Info
	 * @param maxAcSeq
	 */
	public void setMaxAcSeq(String maxAcSeq) {
		this.maxAcSeq = maxAcSeq;
	}

	/**
	 * Column Info
	 * @param ddctSpcl
	 */
	public void setDdctSpcl(String ddctSpcl) {
		this.ddctSpcl = ddctSpcl;
	}

	/**
	 * Column Info
	 * @param usdFxComm
	 */
	public void setUsdFxComm(String usdFxComm) {
		this.usdFxComm = usdFxComm;
	}
	
	/**
	 * Column Info
	 * @param usdFxComm2
	 */
	public void setUsdFxComm2(String usdFxComm2) {
		this.usdFxComm2 = usdFxComm2;
	}

	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	/**
	 * Column Info
	 * @param cnObFinc
	 */
	public void setCnObFinc(String cnObFinc) {
		this.cnObFinc = cnObFinc;
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
	 * @param tsVslCd
	 */
	public void setTsVslCd(String tsVslCd) {
		this.tsVslCd = tsVslCd;
	}

	/**
	 * Column Info
	 * @param delFinc
	 */
	public void setDelFinc(String delFinc) {
		this.delFinc = delFinc;
	}

	/**
	 * Column Info
	 * @param ppdCrntAmt
	 */
	public void setPpdCrntAmt(String ppdCrntAmt) {
		this.ppdCrntAmt = ppdCrntAmt;
	}

	/**
	 * Column Info
	 * @param revMon
	 */
	public void setRevMon(String revMon) {
		this.revMon = revMon;
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
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}

	/**
	 * Column Info
	 * @param agnInfoSeq
	 */
	public void setAgnInfoSeq(String agnInfoSeq) {
		this.agnInfoSeq = agnInfoSeq;
	}

	/**
	 * Column Info
	 * @param rtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
	}

	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}

	/**
	 * Column Info
	 * @param tsSkdDirCd
	 */
	public void setTsSkdDirCd(String tsSkdDirCd) {
		this.tsSkdDirCd = tsSkdDirCd;
	}

	/**
	 * Column Info
	 * @param tsAr
	 */
	public void setTsAr(String tsAr) {
		this.tsAr = tsAr;
	}

	/**
	 * Column Info
	 * @param agmtCurrCd
	 */
	public void setAgmtCurrCd(String agmtCurrCd) {
		this.agmtCurrCd = agmtCurrCd;
	}

	/**
	 * Column Info
	 * @param fdrgDdctOrgFlg
	 */
	public void setFdrgDdctOrgFlg(String fdrgDdctOrgFlg) {
		this.fdrgDdctOrgFlg = fdrgDdctOrgFlg;
	}

	/**
	 * Column Info
	 * @param fxRealAmt
	 */
	public void setFxRealAmt(String fxRealAmt) {
		this.fxRealAmt = fxRealAmt;
	}

	/**
	 * Column Info
	 * @param matCntChg
	 */
	public void setMatCntChg(String matCntChg) {
		this.matCntChg = matCntChg;
	}

	/**
	 * Column Info
	 * @param dupChkCnt
	 */
	public void setDupChkCnt(String dupChkCnt) {
		this.dupChkCnt = dupChkCnt;
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
	 * @param ofcChrCd
	 */
	public void setOfcChrCd(String ofcChrCd) {
		this.ofcChrCd = ofcChrCd;
	}

	/**
	 * Column Info
	 * @param bkgAr
	 */
	public void setBkgAr(String bkgAr) {
		this.bkgAr = bkgAr;
	}

	/**
	 * Column Info
	 * @param ppdChgAmt
	 */
	public void setPpdChgAmt(String ppdChgAmt) {
		this.ppdChgAmt = ppdChgAmt;
	}

	/**
	 * Column Info
	 * @param podFinc
	 */
	public void setPodFinc(String podFinc) {
		this.podFinc = podFinc;
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
	 * @param apCtrCd
	 */
	public void setApCtrCd(String apCtrCd) {
		this.apCtrCd = apCtrCd;
	}

	/**
	 * Column Info
	 * @param commRev
	 */
	public void setCommRev(String commRev) {
		this.commRev = commRev;
	}

	/**
	 * Column Info
	 * @param cltOfrtAmt
	 */
	public void setCltOfrtAmt(String cltOfrtAmt) {
		this.cltOfrtAmt = cltOfrtAmt;
	}

	/**
	 * Column Info
	 * @param tsSkdVoyNo
	 */
	public void setTsSkdVoyNo(String tsSkdVoyNo) {
		this.tsSkdVoyNo = tsSkdVoyNo;
	}

	/**
	 * Column Info
	 * @param revDivCd
	 */
	public void setRevDivCd(String revDivCd) {
		this.revDivCd = revDivCd;
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
	 * @param agnAgmtNo
	 */
	public void setAgnAgmtNo(String agnAgmtNo) {
		this.agnAgmtNo = agnAgmtNo;
	}

	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}

	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
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
	 * @param bkgOfc
	 */
	public void setBkgOfc(String bkgOfc) {
		this.bkgOfc = bkgOfc;
	}

	/**
	 * Column Info
	 * @param saDt
	 */
	public void setSaDt(String saDt) {
		this.saDt = saDt;
	}

	/**
	 * Column Info
	 * @param usdLoclXchRt
	 */
	public void setUsdLoclXchRt(String usdLoclXchRt) {
		this.usdLoclXchRt = usdLoclXchRt;
	}

	/**
	 * Column Info
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
	}

	/**
	 * Column Info
	 * @param rbox
	 */
	public void setRbox(String rbox) {
		this.rbox = rbox;
	}

	/**
	 * Column Info
	 * @param cnIbAr
	 */
	public void setCnIbAr(String cnIbAr) {
		this.cnIbAr = cnIbAr;
	}

	/**
	 * Column Info
	 * @param payXchRt
	 */
	public void setPayXchRt(String payXchRt) {
		this.payXchRt = payXchRt;
	}
	
	/**
	 * Column Info
	 * @param payXchRt2
	 */
	public void setPayXchRt2(String payXchRt2) {
		this.payXchRt2 = payXchRt2;
	}

	/**
	 * Column Info
	 * @param rfeu
	 */
	public void setRfeu(String rfeu) {
		this.rfeu = rfeu;
	}

	/**
	 * Column Info
	 * @param sumMatCnt
	 */
	public void setSumMatCnt(String sumMatCnt) {
		this.sumMatCnt = sumMatCnt;
	}

	/**
	 * Column Info
	 * @param tsSlanCd
	 */
	public void setTsSlanCd(String tsSlanCd) {
		this.tsSlanCd = tsSlanCd;
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
	 * @param podAr
	 */
	public void setPodAr(String podAr) {
		this.podAr = podAr;
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
	 * @param tsFinc
	 */
	public void setTsFinc(String tsFinc) {
		this.tsFinc = tsFinc;
	}

	/**
	 * Column Info
	 * @param commAmt
	 */
	public void setCommAmt(String commAmt) {
		this.commAmt = commAmt;
	}

	/**
	 * Column Info
	 * @param ppdOfrtAmt
	 */
	public void setPpdOfrtAmt(String ppdOfrtAmt) {
		this.ppdOfrtAmt = ppdOfrtAmt;
	}

	/**
	 * Column Info
	 * @param xchRtDivLvl
	 */
	public void setXchRtDivLvl(String xchRtDivLvl) {
		this.xchRtDivLvl = xchRtDivLvl;
	}

	/**
	 * Column Info
	 * @param cnIbFinc
	 */
	public void setCnIbFinc(String cnIbFinc) {
		this.cnIbFinc = cnIbFinc;
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
	 * @param delAr
	 */
	public void setDelAr(String delAr) {
		this.delAr = delAr;
	}

	/**
	 * Column Info
	 * @param hlgDdctDestFlg
	 */
	public void setHlgDdctDestFlg(String hlgDdctDestFlg) {
		this.hlgDdctDestFlg = hlgDdctDestFlg;
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
	 * @param ctrtAr
	 */
	public void setCtrtAr(String ctrtAr) {
		this.ctrtAr = ctrtAr;
	}
	
	/**
	 * Column Info
	 * @param commOfcCd
	 */
	public void setCommOfcCd(String commOfcCd) {
		this.commOfcCd = commOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mhFlg
	 */
	public void setMhFlg(String mhFlg) {
		this.mhFlg = mhFlg;
	}
	
	/**
	 * Column Info
	 * @param diffCurrFlg
	 */
	public void setDiffCurrFlg(String diffCurrFlg) {
		this.diffCurrFlg = diffCurrFlg;
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
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPorAr(JSPUtil.getParameter(request, prefix + "por_ar", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setDdctTrs(JSPUtil.getParameter(request, prefix + "ddct_trs", ""));
		setPayFxComm(JSPUtil.getParameter(request, prefix + "pay_fx_comm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnAgmtSeq(JSPUtil.getParameter(request, prefix + "agn_agmt_seq", ""));
		setPolFinc(JSPUtil.getParameter(request, prefix + "pol_finc", ""));
		setTsSaDt(JSPUtil.getParameter(request, prefix + "ts_sa_dt", ""));
		setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
		setMaxSpclCmpnSeq(JSPUtil.getParameter(request, prefix + "max_spcl_cmpn_seq", ""));
		setRteu(JSPUtil.getParameter(request, prefix + "rteu", ""));
		setTsRevDirCd(JSPUtil.getParameter(request, prefix + "ts_rev_dir_cd", ""));
		setOfcCurrCd(JSPUtil.getParameter(request, prefix + "ofc_curr_cd", ""));
		setChnAgnCd(JSPUtil.getParameter(request, prefix + "chn_agn_cd", ""));
		setAcTpCd(JSPUtil.getParameter(request, prefix + "ac_tp_cd", ""));
		setFdrgDdctDestFlg(JSPUtil.getParameter(request, prefix + "fdrg_ddct_dest_flg", ""));
		setFeu(JSPUtil.getParameter(request, prefix + "feu", ""));
		setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
		setBkgChgRtCount(JSPUtil.getParameter(request, prefix + "bkg_chg_rt_count", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setCommRt(JSPUtil.getParameter(request, prefix + "comm_rt", ""));
		setCommFxAmt(JSPUtil.getParameter(request, prefix + "comm_fx_amt", ""));
		setPorFinc(JSPUtil.getParameter(request, prefix + "por_finc", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setTsRlaneCd(JSPUtil.getParameter(request, prefix + "ts_rlane_cd", ""));
		setPpdCrntSpclAmt(JSPUtil.getParameter(request, prefix + "ppd_crnt_spcl_amt", ""));
		setHlgDdctOrgFlg(JSPUtil.getParameter(request, prefix + "hlg_ddct_org_flg", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCltChgAmt(JSPUtil.getParameter(request, prefix + "clt_chg_amt", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setRnk1(JSPUtil.getParameter(request, prefix + "rnk1", ""));
		setOftPayTermCd(JSPUtil.getParameter(request, prefix + "oft_pay_term_cd", ""));
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setTtlRevAmt(JSPUtil.getParameter(request, prefix + "ttl_rev_amt", ""));
		setPolAr(JSPUtil.getParameter(request, prefix + "pol_ar", ""));
		setPpdPayCrntAmt(JSPUtil.getParameter(request, prefix + "ppd_pay_crnt_amt", ""));
		setTsLoc(JSPUtil.getParameter(request, prefix + "ts_loc", ""));
		setCnObAr(JSPUtil.getParameter(request, prefix + "cn_ob_ar", ""));
		setDdctChg(JSPUtil.getParameter(request, prefix + "ddct_chg", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCommPayTermCd(JSPUtil.getParameter(request, prefix + "comm_pay_term_cd", ""));
		setComm(JSPUtil.getParameter(request, prefix + "comm", ""));
		setMaxAcSeq(JSPUtil.getParameter(request, prefix + "max_ac_seq", ""));
		setDdctSpcl(JSPUtil.getParameter(request, prefix + "ddct_spcl", ""));
		setUsdFxComm(JSPUtil.getParameter(request, prefix + "usd_fx_comm", ""));
		setUsdFxComm2(JSPUtil.getParameter(request, prefix + "usd_fx_comm2", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setCnObFinc(JSPUtil.getParameter(request, prefix + "cn_ob_finc", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setTsVslCd(JSPUtil.getParameter(request, prefix + "ts_vsl_cd", ""));
		setDelFinc(JSPUtil.getParameter(request, prefix + "del_finc", ""));
		setPpdCrntAmt(JSPUtil.getParameter(request, prefix + "ppd_crnt_amt", ""));
		setRevMon(JSPUtil.getParameter(request, prefix + "rev_mon", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setAgnInfoSeq(JSPUtil.getParameter(request, prefix + "agn_info_seq", ""));
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setTsSkdDirCd(JSPUtil.getParameter(request, prefix + "ts_skd_dir_cd", ""));
		setTsAr(JSPUtil.getParameter(request, prefix + "ts_ar", ""));
		setAgmtCurrCd(JSPUtil.getParameter(request, prefix + "agmt_curr_cd", ""));
		setFdrgDdctOrgFlg(JSPUtil.getParameter(request, prefix + "fdrg_ddct_org_flg", ""));
		setFxRealAmt(JSPUtil.getParameter(request, prefix + "fx_real_amt", ""));
		setMatCntChg(JSPUtil.getParameter(request, prefix + "mat_cnt_chg", ""));
		setDupChkCnt(JSPUtil.getParameter(request, prefix + "dup_chk_cnt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setOfcChrCd(JSPUtil.getParameter(request, prefix + "ofc_chr_cd", ""));
		setBkgAr(JSPUtil.getParameter(request, prefix + "bkg_ar", ""));
		setPpdChgAmt(JSPUtil.getParameter(request, prefix + "ppd_chg_amt", ""));
		setPodFinc(JSPUtil.getParameter(request, prefix + "pod_finc", ""));
		setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
		setApCtrCd(JSPUtil.getParameter(request, prefix + "ap_ctr_cd", ""));
		setCommRev(JSPUtil.getParameter(request, prefix + "comm_rev", ""));
		setCltOfrtAmt(JSPUtil.getParameter(request, prefix + "clt_ofrt_amt", ""));
		setTsSkdVoyNo(JSPUtil.getParameter(request, prefix + "ts_skd_voy_no", ""));
		setRevDivCd(JSPUtil.getParameter(request, prefix + "rev_div_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setAgnAgmtNo(JSPUtil.getParameter(request, prefix + "agn_agmt_no", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgOfc(JSPUtil.getParameter(request, prefix + "bkg_ofc", ""));
		setSaDt(JSPUtil.getParameter(request, prefix + "sa_dt", ""));
		setUsdLoclXchRt(JSPUtil.getParameter(request, prefix + "usd_locl_xch_rt", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
		setRbox(JSPUtil.getParameter(request, prefix + "rbox", ""));
		setCnIbAr(JSPUtil.getParameter(request, prefix + "cn_ib_ar", ""));
		setPayXchRt(JSPUtil.getParameter(request, prefix + "pay_xch_rt", ""));
		setPayXchRt2(JSPUtil.getParameter(request, prefix + "pay_xch_rt2", ""));
		setRfeu(JSPUtil.getParameter(request, prefix + "rfeu", ""));
		setSumMatCnt(JSPUtil.getParameter(request, prefix + "sum_mat_cnt", ""));
		setTsSlanCd(JSPUtil.getParameter(request, prefix + "ts_slan_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPodAr(JSPUtil.getParameter(request, prefix + "pod_ar", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setTsFinc(JSPUtil.getParameter(request, prefix + "ts_finc", ""));
		setCommAmt(JSPUtil.getParameter(request, prefix + "comm_amt", ""));
		setPpdOfrtAmt(JSPUtil.getParameter(request, prefix + "ppd_ofrt_amt", ""));
		setXchRtDivLvl(JSPUtil.getParameter(request, prefix + "xch_rt_div_lvl", ""));
		setCnIbFinc(JSPUtil.getParameter(request, prefix + "cn_ib_finc", ""));
		setBox(JSPUtil.getParameter(request, prefix + "box", ""));
		setDelAr(JSPUtil.getParameter(request, prefix + "del_ar", ""));
		setHlgDdctDestFlg(JSPUtil.getParameter(request, prefix + "hlg_ddct_dest_flg", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setCtrtAr(JSPUtil.getParameter(request, prefix + "ctrt_ar", ""));
		setCommOfcCd(JSPUtil.getParameter(request, prefix + "comm_ofc_cd", ""));
		setMhFlg(JSPUtil.getParameter(request, prefix + "mh_flg", ""));
		setDiffCurrFlg(JSPUtil.getParameter(request, prefix + "diff_curr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgmtInfoVO[]
	 */
	public AgmtInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AgmtInfoVO[]
	 */
	public AgmtInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgmtInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] porAr = (JSPUtil.getParameter(request, prefix	+ "por_ar", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] ddctTrs = (JSPUtil.getParameter(request, prefix	+ "ddct_trs", length));
			String[] payFxComm = (JSPUtil.getParameter(request, prefix	+ "pay_fx_comm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_seq", length));
			String[] polFinc = (JSPUtil.getParameter(request, prefix	+ "pol_finc", length));
			String[] tsSaDt = (JSPUtil.getParameter(request, prefix	+ "ts_sa_dt", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] maxSpclCmpnSeq = (JSPUtil.getParameter(request, prefix	+ "max_spcl_cmpn_seq", length));
			String[] rteu = (JSPUtil.getParameter(request, prefix	+ "rteu", length));
			String[] tsRevDirCd = (JSPUtil.getParameter(request, prefix	+ "ts_rev_dir_cd", length));
			String[] ofcCurrCd = (JSPUtil.getParameter(request, prefix	+ "ofc_curr_cd", length));
			String[] chnAgnCd = (JSPUtil.getParameter(request, prefix	+ "chn_agn_cd", length));
			String[] acTpCd = (JSPUtil.getParameter(request, prefix	+ "ac_tp_cd", length));
			String[] fdrgDdctDestFlg = (JSPUtil.getParameter(request, prefix	+ "fdrg_ddct_dest_flg", length));
			String[] feu = (JSPUtil.getParameter(request, prefix	+ "feu", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] bkgChgRtCount = (JSPUtil.getParameter(request, prefix	+ "bkg_chg_rt_count", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] commRt = (JSPUtil.getParameter(request, prefix	+ "comm_rt", length));
			String[] commFxAmt = (JSPUtil.getParameter(request, prefix	+ "comm_fx_amt", length));
			String[] porFinc = (JSPUtil.getParameter(request, prefix	+ "por_finc", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] tsRlaneCd = (JSPUtil.getParameter(request, prefix	+ "ts_rlane_cd", length));
			String[] ppdCrntSpclAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_crnt_spcl_amt", length));
			String[] hlgDdctOrgFlg = (JSPUtil.getParameter(request, prefix	+ "hlg_ddct_org_flg", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cltChgAmt = (JSPUtil.getParameter(request, prefix	+ "clt_chg_amt", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] rnk1 = (JSPUtil.getParameter(request, prefix	+ "rnk1", length));
			String[] oftPayTermCd = (JSPUtil.getParameter(request, prefix	+ "oft_pay_term_cd", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] ttlRevAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_rev_amt", length));
			String[] polAr = (JSPUtil.getParameter(request, prefix	+ "pol_ar", length));
			String[] ppdPayCrntAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_pay_crnt_amt", length));
			String[] tsLoc = (JSPUtil.getParameter(request, prefix	+ "ts_loc", length));
			String[] cnObAr = (JSPUtil.getParameter(request, prefix	+ "cn_ob_ar", length));
			String[] ddctChg = (JSPUtil.getParameter(request, prefix	+ "ddct_chg", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] commPayTermCd = (JSPUtil.getParameter(request, prefix	+ "comm_pay_term_cd", length));
			String[] comm = (JSPUtil.getParameter(request, prefix	+ "comm", length));
			String[] maxAcSeq = (JSPUtil.getParameter(request, prefix	+ "max_ac_seq", length));
			String[] ddctSpcl = (JSPUtil.getParameter(request, prefix	+ "ddct_spcl", length));
			String[] usdFxComm = (JSPUtil.getParameter(request, prefix	+ "usd_fx_comm", length));
			String[] usdFxComm2 = (JSPUtil.getParameter(request, prefix	+ "usd_fx_comm2", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] cnObFinc = (JSPUtil.getParameter(request, prefix	+ "cn_ob_finc", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] tsVslCd = (JSPUtil.getParameter(request, prefix	+ "ts_vsl_cd", length));
			String[] delFinc = (JSPUtil.getParameter(request, prefix	+ "del_finc", length));
			String[] ppdCrntAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_crnt_amt", length));
			String[] revMon = (JSPUtil.getParameter(request, prefix	+ "rev_mon", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] agnInfoSeq = (JSPUtil.getParameter(request, prefix	+ "agn_info_seq", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] tsSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "ts_skd_dir_cd", length));
			String[] tsAr = (JSPUtil.getParameter(request, prefix	+ "ts_ar", length));
			String[] agmtCurrCd = (JSPUtil.getParameter(request, prefix	+ "agmt_curr_cd", length));
			String[] fdrgDdctOrgFlg = (JSPUtil.getParameter(request, prefix	+ "fdrg_ddct_org_flg", length));
			String[] fxRealAmt = (JSPUtil.getParameter(request, prefix	+ "fx_real_amt", length));
			String[] matCntChg = (JSPUtil.getParameter(request, prefix	+ "mat_cnt_chg", length));
			String[] dupChkCnt = (JSPUtil.getParameter(request, prefix	+ "dup_chk_cnt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ofcChrCd = (JSPUtil.getParameter(request, prefix	+ "ofc_chr_cd", length));
			String[] bkgAr = (JSPUtil.getParameter(request, prefix	+ "bkg_ar", length));
			String[] ppdChgAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_chg_amt", length));
			String[] podFinc = (JSPUtil.getParameter(request, prefix	+ "pod_finc", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] apCtrCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctr_cd", length));
			String[] commRev = (JSPUtil.getParameter(request, prefix	+ "comm_rev", length));
			String[] cltOfrtAmt = (JSPUtil.getParameter(request, prefix	+ "clt_ofrt_amt", length));
			String[] tsSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "ts_skd_voy_no", length));
			String[] revDivCd = (JSPUtil.getParameter(request, prefix	+ "rev_div_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] agnAgmtNo = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_no", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgOfc = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc", length));
			String[] saDt = (JSPUtil.getParameter(request, prefix	+ "sa_dt", length));
			String[] usdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_locl_xch_rt", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] rbox = (JSPUtil.getParameter(request, prefix	+ "rbox", length));
			String[] cnIbAr = (JSPUtil.getParameter(request, prefix	+ "cn_ib_ar", length));
			String[] payXchRt = (JSPUtil.getParameter(request, prefix	+ "pay_xch_rt", length));
			String[] payXchRt2 = (JSPUtil.getParameter(request, prefix	+ "pay_xch_rt2", length));
			String[] rfeu = (JSPUtil.getParameter(request, prefix	+ "rfeu", length));
			String[] sumMatCnt = (JSPUtil.getParameter(request, prefix	+ "sum_mat_cnt", length));
			String[] tsSlanCd = (JSPUtil.getParameter(request, prefix	+ "ts_slan_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] podAr = (JSPUtil.getParameter(request, prefix	+ "pod_ar", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] tsFinc = (JSPUtil.getParameter(request, prefix	+ "ts_finc", length));
			String[] commAmt = (JSPUtil.getParameter(request, prefix	+ "comm_amt", length));
			String[] ppdOfrtAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_ofrt_amt", length));
			String[] xchRtDivLvl = (JSPUtil.getParameter(request, prefix	+ "xch_rt_div_lvl", length));
			String[] cnIbFinc = (JSPUtil.getParameter(request, prefix	+ "cn_ib_finc", length));
			String[] box = (JSPUtil.getParameter(request, prefix	+ "box", length));
			String[] delAr = (JSPUtil.getParameter(request, prefix	+ "del_ar", length));
			String[] hlgDdctDestFlg = (JSPUtil.getParameter(request, prefix	+ "hlg_ddct_dest_flg", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] ctrtAr = (JSPUtil.getParameter(request, prefix	+ "ctrt_ar", length));
			String[] commOfcCd = (JSPUtil.getParameter(request, prefix	+ "comm_ofc_cd", length));
			String[] mhFlg = (JSPUtil.getParameter(request, prefix	+ "mh_flg", length));
			String[] diffCurrFlg = (JSPUtil.getParameter(request, prefix	+ "diff_curr_flg", length));

			for (int i = 0; i < length; i++) {
				model = new AgmtInfoVO();
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (porAr[i] != null)
					model.setPorAr(porAr[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (ddctTrs[i] != null)
					model.setDdctTrs(ddctTrs[i]);
				if (payFxComm[i] != null)
					model.setPayFxComm(payFxComm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnAgmtSeq[i] != null)
					model.setAgnAgmtSeq(agnAgmtSeq[i]);
				if (polFinc[i] != null)
					model.setPolFinc(polFinc[i]);
				if (tsSaDt[i] != null)
					model.setTsSaDt(tsSaDt[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (maxSpclCmpnSeq[i] != null)
					model.setMaxSpclCmpnSeq(maxSpclCmpnSeq[i]);
				if (rteu[i] != null)
					model.setRteu(rteu[i]);
				if (tsRevDirCd[i] != null)
					model.setTsRevDirCd(tsRevDirCd[i]);
				if (ofcCurrCd[i] != null)
					model.setOfcCurrCd(ofcCurrCd[i]);
				if (chnAgnCd[i] != null)
					model.setChnAgnCd(chnAgnCd[i]);
				if (acTpCd[i] != null)
					model.setAcTpCd(acTpCd[i]);
				if (fdrgDdctDestFlg[i] != null)
					model.setFdrgDdctDestFlg(fdrgDdctDestFlg[i]);
				if (feu[i] != null)
					model.setFeu(feu[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (bkgChgRtCount[i] != null)
					model.setBkgChgRtCount(bkgChgRtCount[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (commRt[i] != null)
					model.setCommRt(commRt[i]);
				if (commFxAmt[i] != null)
					model.setCommFxAmt(commFxAmt[i]);
				if (porFinc[i] != null)
					model.setPorFinc(porFinc[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (tsRlaneCd[i] != null)
					model.setTsRlaneCd(tsRlaneCd[i]);
				if (ppdCrntSpclAmt[i] != null)
					model.setPpdCrntSpclAmt(ppdCrntSpclAmt[i]);
				if (hlgDdctOrgFlg[i] != null)
					model.setHlgDdctOrgFlg(hlgDdctOrgFlg[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cltChgAmt[i] != null)
					model.setCltChgAmt(cltChgAmt[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (rnk1[i] != null)
					model.setRnk1(rnk1[i]);
				if (oftPayTermCd[i] != null)
					model.setOftPayTermCd(oftPayTermCd[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (ttlRevAmt[i] != null)
					model.setTtlRevAmt(ttlRevAmt[i]);
				if (polAr[i] != null)
					model.setPolAr(polAr[i]);
				if (ppdPayCrntAmt[i] != null)
					model.setPpdPayCrntAmt(ppdPayCrntAmt[i]);
				if (tsLoc[i] != null)
					model.setTsLoc(tsLoc[i]);
				if (cnObAr[i] != null)
					model.setCnObAr(cnObAr[i]);
				if (ddctChg[i] != null)
					model.setDdctChg(ddctChg[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (commPayTermCd[i] != null)
					model.setCommPayTermCd(commPayTermCd[i]);
				if (comm[i] != null)
					model.setComm(comm[i]);
				if (maxAcSeq[i] != null)
					model.setMaxAcSeq(maxAcSeq[i]);
				if (ddctSpcl[i] != null)
					model.setDdctSpcl(ddctSpcl[i]);
				if (usdFxComm[i] != null)
					model.setUsdFxComm(usdFxComm[i]);
				if (usdFxComm2[i] != null)
					model.setUsdFxComm2(usdFxComm2[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (cnObFinc[i] != null)
					model.setCnObFinc(cnObFinc[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (tsVslCd[i] != null)
					model.setTsVslCd(tsVslCd[i]);
				if (delFinc[i] != null)
					model.setDelFinc(delFinc[i]);
				if (ppdCrntAmt[i] != null)
					model.setPpdCrntAmt(ppdCrntAmt[i]);
				if (revMon[i] != null)
					model.setRevMon(revMon[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (agnInfoSeq[i] != null)
					model.setAgnInfoSeq(agnInfoSeq[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (tsSkdDirCd[i] != null)
					model.setTsSkdDirCd(tsSkdDirCd[i]);
				if (tsAr[i] != null)
					model.setTsAr(tsAr[i]);
				if (agmtCurrCd[i] != null)
					model.setAgmtCurrCd(agmtCurrCd[i]);
				if (fdrgDdctOrgFlg[i] != null)
					model.setFdrgDdctOrgFlg(fdrgDdctOrgFlg[i]);
				if (fxRealAmt[i] != null)
					model.setFxRealAmt(fxRealAmt[i]);
				if (matCntChg[i] != null)
					model.setMatCntChg(matCntChg[i]);
				if (dupChkCnt[i] != null)
					model.setDupChkCnt(dupChkCnt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ofcChrCd[i] != null)
					model.setOfcChrCd(ofcChrCd[i]);
				if (bkgAr[i] != null)
					model.setBkgAr(bkgAr[i]);
				if (ppdChgAmt[i] != null)
					model.setPpdChgAmt(ppdChgAmt[i]);
				if (podFinc[i] != null)
					model.setPodFinc(podFinc[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (apCtrCd[i] != null)
					model.setApCtrCd(apCtrCd[i]);
				if (commRev[i] != null)
					model.setCommRev(commRev[i]);
				if (cltOfrtAmt[i] != null)
					model.setCltOfrtAmt(cltOfrtAmt[i]);
				if (tsSkdVoyNo[i] != null)
					model.setTsSkdVoyNo(tsSkdVoyNo[i]);
				if (revDivCd[i] != null)
					model.setRevDivCd(revDivCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (agnAgmtNo[i] != null)
					model.setAgnAgmtNo(agnAgmtNo[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgOfc[i] != null)
					model.setBkgOfc(bkgOfc[i]);
				if (saDt[i] != null)
					model.setSaDt(saDt[i]);
				if (usdLoclXchRt[i] != null)
					model.setUsdLoclXchRt(usdLoclXchRt[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (rbox[i] != null)
					model.setRbox(rbox[i]);
				if (cnIbAr[i] != null)
					model.setCnIbAr(cnIbAr[i]);
				if (payXchRt[i] != null)
					model.setPayXchRt(payXchRt[i]);
				if (payXchRt2[i] != null)
					model.setPayXchRt2(payXchRt2[i]);
				if (rfeu[i] != null)
					model.setRfeu(rfeu[i]);
				if (sumMatCnt[i] != null)
					model.setSumMatCnt(sumMatCnt[i]);
				if (tsSlanCd[i] != null)
					model.setTsSlanCd(tsSlanCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (podAr[i] != null)
					model.setPodAr(podAr[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (tsFinc[i] != null)
					model.setTsFinc(tsFinc[i]);
				if (commAmt[i] != null)
					model.setCommAmt(commAmt[i]);
				if (ppdOfrtAmt[i] != null)
					model.setPpdOfrtAmt(ppdOfrtAmt[i]);
				if (xchRtDivLvl[i] != null)
					model.setXchRtDivLvl(xchRtDivLvl[i]);
				if (cnIbFinc[i] != null)
					model.setCnIbFinc(cnIbFinc[i]);
				if (box[i] != null)
					model.setBox(box[i]);
				if (delAr[i] != null)
					model.setDelAr(delAr[i]);
				if (hlgDdctDestFlg[i] != null)
					model.setHlgDdctDestFlg(hlgDdctDestFlg[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (ctrtAr[i] != null)
					model.setCtrtAr(ctrtAr[i]);
				if (commOfcCd[i] != null)
					model.setCommOfcCd(commOfcCd[i]);
				if (mhFlg[i] != null)
					model.setMhFlg(mhFlg[i]);
				if (diffCurrFlg[i] != null)
					model.setDiffCurrFlg(diffCurrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgmtInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgmtInfoVO[]
	 */
	public AgmtInfoVO[] getAgmtInfoVOs(){
		AgmtInfoVO[] vos = (AgmtInfoVO[])models.toArray(new AgmtInfoVO[models.size()]);
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
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAr = this.porAr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctTrs = this.ddctTrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payFxComm = this.payFxComm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtSeq = this.agnAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFinc = this.polFinc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsSaDt = this.tsSaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSpclCmpnSeq = this.maxSpclCmpnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rteu = this.rteu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsRevDirCd = this.tsRevDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCurrCd = this.ofcCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnAgnCd = this.chnAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd = this.acTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrgDdctDestFlg = this.fdrgDdctDestFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feu = this.feu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd = this.apOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgChgRtCount = this.bkgChgRtCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commRt = this.commRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commFxAmt = this.commFxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porFinc = this.porFinc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsRlaneCd = this.tsRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdCrntSpclAmt = this.ppdCrntSpclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hlgDdctOrgFlg = this.hlgDdctOrgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltChgAmt = this.cltChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnk1 = this.rnk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftPayTermCd = this.oftPayTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlRevAmt = this.ttlRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAr = this.polAr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdPayCrntAmt = this.ppdPayCrntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsLoc = this.tsLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnObAr = this.cnObAr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctChg = this.ddctChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commPayTermCd = this.commPayTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comm = this.comm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxAcSeq = this.maxAcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctSpcl = this.ddctSpcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdFxComm = this.usdFxComm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdFxComm2 = this.usdFxComm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnObFinc = this.cnObFinc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVslCd = this.tsVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFinc = this.delFinc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdCrntAmt = this.ppdCrntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revMon = this.revMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnInfoSeq = this.agnInfoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsSkdDirCd = this.tsSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsAr = this.tsAr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCurrCd = this.agmtCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrgDdctOrgFlg = this.fdrgDdctOrgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxRealAmt = this.fxRealAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matCntChg = this.matCntChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupChkCnt = this.dupChkCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcChrCd = this.ofcChrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAr = this.bkgAr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdChgAmt = this.ppdChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFinc = this.podFinc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCtrCd = this.apCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commRev = this.commRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfrtAmt = this.cltOfrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsSkdVoyNo = this.tsSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDivCd = this.revDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtNo = this.agnAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfc = this.bkgOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saDt = this.saDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLoclXchRt = this.usdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rbox = this.rbox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnIbAr = this.cnIbAr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payXchRt = this.payXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payXchRt2 = this.payXchRt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfeu = this.rfeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumMatCnt = this.sumMatCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsSlanCd = this.tsSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAr = this.podAr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsFinc = this.tsFinc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commAmt = this.commAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdOfrtAmt = this.ppdOfrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtDivLvl = this.xchRtDivLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnIbFinc = this.cnIbFinc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.box = this.box .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAr = this.delAr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hlgDdctDestFlg = this.hlgDdctDestFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtAr = this.ctrtAr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commOfcCd = this.commOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mhFlg = this.mhFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffCurrFlg = this.diffCurrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
