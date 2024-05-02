/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltUnmatchBLListbyAuditorVO.java
*@FileTitle : RsltUnmatchBLListbyAuditorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.02.03 김대호 
* 1.0 Creation
* 2012.04.26 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

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
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltUnmatchBLListbyAuditorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltUnmatchBLListbyAuditorVO> models = new ArrayList<RsltUnmatchBLListbyAuditorVO>();
	
	
	/* Column Info */
	private String errorLapse = null;//추가
	/* Column Info */
	private String rctOfcCd = null;
	/* Column Info */
	private String bdrStatusCd = null;
	/* Column Info */
	private String n1stUmchFndDt = null;
	/* Column Info */
	private String raterId = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String lstUmchFndDt = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String revAudStlKndNm = null;
	/* Column Info */
	private String ctrtTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String rdnNo = null;
	/* Column Info */
	private String rtAplyDtFrom = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revAudStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String umchRsnRmk = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String bkgContract = null;
	/* Column Info */
	private String contractNo = null;
	/* Column Info */
	private String autoRatFlg = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String rctRhqCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rgnGrpAvcRmk = null;
	/* Column Info */
    private String revAudAmt = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String umchBkgSeq = null;
	/* Column Info */
	private String revAudTpNm = null;
	/* Column Info */
	private String diffUsdAmt = null;
	/* Column Info */
	private String revAudTpCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String umchE = null;
	/* Column Info */
	private String rtAplyDtTo = null;
	/* Column Info */
	private String umchF = null;
	/* Column Info */
	private String umchG = null;
	/* Column Info */
	private String umchTpCd = null;
	/* Column Info */
	private String revAudStsNm = null;
	/* Column Info */
	private String revAudStlKndCd = null;
	/* Column Info */
	private String umchA = null;
	/* Column Info */
	private String umchAl = null;
	/* Column Info */
	private String umchAll = null;
	/* Column Info */
	private String auditSeqCd = null;
	/* Column Info */
	private String umchB = null;
	/* Column Info */
	private String umchC = null;
	/* Column Info */
	private String umchD = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String contiCd2 = null;
	/* Column Info */
	private String rdnStatus = null;
	/* Column Info */
	private String errChg = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String dtType = null;
	/* Column Info */
	private String bdrDt = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String polEtd = null;
	/* Column Info */
	private String portClzDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String gso = null;
	/* Column Info */
	private String stlPrd = null;
	/* Column Info */
	private String stlUsrId = null;
	/* Column Info */
	private String errUmchTpCd = null;
	/* Column Info */
	private String mnlStlTpCd = null;
	/* Column Info */
	private String mnlStlTp = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String rqstMnlStlTpCd = null;
	/* Column Info */
	private String mnlStlRqstFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltUnmatchBLListbyAuditorVO() {}

	public RsltUnmatchBLListbyAuditorVO(String polEtd, String errorLapse, String ibflag,String umchAl,String umchAll, String pagerows, String bkgNo, String umchBkgSeq, String rtAplyDt, String rctRhqCd, String bkgOfcCd, String vvdCd, String blNo, String scRfaNo, String ctrtTpCd, String umchA, String umchB, String umchC, String umchD, String umchE, String umchF, String umchG, String bkgContract, String diffUsdAmt, String rdnNo, String revAudStsCd, String revAudStsNm, String revAudStlKndCd, String revAudStlKndNm, String umchRsnRmk, String rgnGrpAvcRmk, String revAudAmt, String raterId, String bkgCtrtTpCd, String autoRatFlg, String n1stUmchFndDt, String lstUmchFndDt, String revAudTpCd, String revAudTpNm, String updDt, String updUsrId, String bdrFlg, String rtAplyDtFrom, String rtAplyDtTo, String umchTpCd, String auditSeqCd, String rctOfcCd, String bdrStatusCd, String contractNo, String contiCd, String contiCd2, String rdnStatus, String errChg, String chgCd,String dtType, String bdrDt,String srepCd, String portClzDt, String svcScpCd, String gso, String stlPrd, String stlUsrId, String errUmchTpCd, String mnlStlTpCd, String mnlStlTp, String porCd, String polCd, String podCd, String delCd, String mnlStlRqstFlg, String rqstMnlStlTpCd) {
		this.polEtd = polEtd;
		this.errorLapse=errorLapse;//추가
		this.rctOfcCd = rctOfcCd;
		this.bdrStatusCd = bdrStatusCd;
		this.n1stUmchFndDt = n1stUmchFndDt;
		this.raterId = raterId;
		this.bdrFlg = bdrFlg;
		this.lstUmchFndDt = lstUmchFndDt;
		this.rtAplyDt = rtAplyDt;
		this.revAudStlKndNm = revAudStlKndNm;
		this.ctrtTpCd = ctrtTpCd;
		this.blNo = blNo;
		this.rdnNo = rdnNo;
		this.rtAplyDtFrom = rtAplyDtFrom;
		this.pagerows = pagerows;
		this.revAudStsCd = revAudStsCd;
		this.ibflag = ibflag;
		this.umchRsnRmk = umchRsnRmk;
		this.vvdCd = vvdCd;
		this.bkgContract = bkgContract;
		this.contractNo = contractNo;
		this.autoRatFlg = autoRatFlg;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.rctRhqCd = rctRhqCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.rgnGrpAvcRmk = rgnGrpAvcRmk;
		this.revAudAmt = revAudAmt;
		this.bkgOfcCd = bkgOfcCd;
		this.umchBkgSeq = umchBkgSeq;
		this.revAudTpNm = revAudTpNm;
		this.diffUsdAmt = diffUsdAmt;
		this.revAudTpCd = revAudTpCd;
		this.bkgNo = bkgNo;
		this.scRfaNo = scRfaNo;
		this.umchE = umchE;
		this.umchG = umchG;
		this.rtAplyDtTo = rtAplyDtTo;
		this.umchF = umchF;
		this.umchTpCd = umchTpCd;
		this.revAudStsNm = revAudStsNm;
		this.revAudStlKndCd = revAudStlKndCd;
		this.umchA = umchA;
		this.umchAl = umchAl;
		this.umchAll = umchAll;
		this.auditSeqCd = auditSeqCd;
		this.umchB = umchB;
		this.umchC = umchC;
		this.umchD = umchD;
		this.contiCd = contiCd;
		this.contiCd2 = contiCd2;
		this.rdnStatus = rdnStatus;
		this.errChg = errChg;
		this.chgCd = chgCd;
		this.dtType = dtType;
		this.bdrDt = bdrDt;
		this.srepCd = srepCd;
		this.portClzDt = portClzDt;
		this.svcScpCd = svcScpCd;
		this.gso = gso;
		this.stlPrd = stlPrd;
		this.stlUsrId = stlUsrId;
		this.errUmchTpCd = errUmchTpCd;
		this.mnlStlTpCd = mnlStlTpCd;
		this.mnlStlTp = mnlStlTp;
		this.porCd = porCd;
		this.polCd = polCd;
		this.podCd = podCd;
		this.delCd = delCd;
		
		this.rqstMnlStlTpCd = rqstMnlStlTpCd;
		this.mnlStlRqstFlg = mnlStlRqstFlg;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pol_etd", getPolEtd());//추가
		this.hashColumns.put("error_lapse", getErrorLapse());//추가
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());
		this.hashColumns.put("bdr_status_cd", getBdrStatusCd());
		this.hashColumns.put("n1st_umch_fnd_dt", getN1stUmchFndDt());
		this.hashColumns.put("rater_id", getRaterId());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("lst_umch_fnd_dt", getLstUmchFndDt());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("rev_aud_stl_knd_nm", getRevAudStlKndNm());
		this.hashColumns.put("ctrt_tp_cd", getCtrtTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("rdn_no", getRdnNo());
		this.hashColumns.put("rt_aply_dt_from", getRtAplyDtFrom());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_aud_sts_cd", getRevAudStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("umch_rsn_rmk", getUmchRsnRmk());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("bkg_contract", getBkgContract());
		this.hashColumns.put("contract_no", getContractNo());
		this.hashColumns.put("auto_rat_flg", getAutoRatFlg());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("rct_rhq_cd", getRctRhqCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rgn_grp_avc_rmk", getRgnGrpAvcRmk());
		this.hashColumns.put("rev_aud_amt", getRevAudAmt());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("umch_bkg_seq", getUmchBkgSeq());
		this.hashColumns.put("rev_aud_tp_nm", getRevAudTpNm());
		this.hashColumns.put("diff_usd_amt", getDiffUsdAmt());
		this.hashColumns.put("rev_aud_tp_cd", getRevAudTpCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("umch_e", getUmchE());
		this.hashColumns.put("umch_g", getUmchG());
		this.hashColumns.put("rt_aply_dt_to", getRtAplyDtTo());
		this.hashColumns.put("umch_f", getUmchF());
		this.hashColumns.put("umch_tp_cd", getUmchTpCd());
		this.hashColumns.put("rev_aud_sts_nm", getRevAudStsNm());
		this.hashColumns.put("rev_aud_stl_knd_cd", getRevAudStlKndCd());
		this.hashColumns.put("umch_a", getUmchA());
		this.hashColumns.put("umch_al", getUmchAl());
		this.hashColumns.put("umch_all", getUmchAll());
		
		this.hashColumns.put("audit_seq_cd", getAuditSeqCd());
		this.hashColumns.put("umch_b", getUmchB());
		this.hashColumns.put("umch_c", getUmchC());
		this.hashColumns.put("umch_d", getUmchD());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("conti_cd2", getContiCd2());
		this.hashColumns.put("rdn_status", getRdnStatus());
		this.hashColumns.put("err_chg", getErrChg());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("dt_type", getDtType());
		this.hashColumns.put("bdr_dt", getBdrDt());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("port_clz_dt", getPortClzDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("gso", getGso());
		this.hashColumns.put("stl_prd", getStlPrd());
		this.hashColumns.put("stl_usr_id", getStlUsrId());
		this.hashColumns.put("err_umch_tp_cd", getErrUmchTpCd());
		this.hashColumns.put("mnl_stl_tp_cd", getMnlStlTpCd());
		this.hashColumns.put("mnl_stl_tp", getMnlStlTp());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("del_cd", getDelCd());
		
		this.hashColumns.put("rqst_mnl_stl_tp_cd", getRqstMnlStlTpCd());
		this.hashColumns.put("mnl_stl_rqst_flg", getMnlStlRqstFlg());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		
		this.hashFields.put("pol_etd", "polEtd");//추가
		this.hashFields.put("error_lapse", "errorLapse");//추가
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("bdr_status_cd", "bdrStatusCd");
		this.hashFields.put("n1st_umch_fnd_dt", "n1stUmchFndDt");
		this.hashFields.put("rater_id", "raterId");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("lst_umch_fnd_dt", "lstUmchFndDt");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("rev_aud_stl_knd_nm", "revAudStlKndNm");
		this.hashFields.put("ctrt_tp_cd", "ctrtTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("rdn_no", "rdnNo");
		this.hashFields.put("rt_aply_dt_from", "rtAplyDtFrom");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_aud_sts_cd", "revAudStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("umch_rsn_rmk", "umchRsnRmk");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bkg_contract", "bkgContract");
		this.hashFields.put("contract_no", "contractNo");
		this.hashFields.put("auto_rat_flg", "autoRatFlg");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("rct_rhq_cd", "rctRhqCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rgn_grp_avc_rmk", "rgnGrpAvcRmk");
		this.hashFields.put("rev_aud_amt", "revAudAmt");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("umch_bkg_seq", "umchBkgSeq");
		this.hashFields.put("rev_aud_tp_nm", "revAudTpNm");
		this.hashFields.put("diff_usd_amt", "diffUsdAmt");
		this.hashFields.put("rev_aud_tp_cd", "revAudTpCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("umch_e", "umchE");
		this.hashFields.put("umch_g", "umchG");
		this.hashFields.put("rt_aply_dt_to", "rtAplyDtTo");
		this.hashFields.put("umch_f", "umchF");
		this.hashFields.put("umch_tp_cd", "umchTpCd");
		this.hashFields.put("rev_aud_sts_nm", "revAudStsNm");
		this.hashFields.put("rev_aud_stl_knd_cd", "revAudStlKndCd");
		this.hashFields.put("umch_a", "umchA");
		this.hashFields.put("umch_al", "umchAl");
		this.hashFields.put("umch_all", "umchAll");
		
		this.hashFields.put("audit_seq_cd", "auditSeqCd");
		this.hashFields.put("umch_b", "umchB");
		this.hashFields.put("umch_c", "umchC");
		this.hashFields.put("umch_d", "umchD");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("conti_cd2", "contiCd2");
		this.hashFields.put("rdn_status", "rdnStatus");
		this.hashFields.put("err_chg", "errChg");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("dt_type", "dtType");
		this.hashFields.put("bdr_dt", "bdrDt");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("port_clz_dt", "portClzDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("gso", "gso");
		this.hashFields.put("stl_prd", "stlPrd");
		this.hashFields.put("stl_usr_id", "stlUsrId");
		this.hashFields.put("err_umch_tp_cd", "errUmchTpCd");
		this.hashFields.put("mnl_stl_tp_cd", "mnlStlTpCd");
		this.hashFields.put("mnl_stl_tp", "mnlStlTp");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("del_cd", "delCd");
		
		this.hashFields.put("rqst_mnl_stl_tp_cd", "rqstMnlStlTpCd");
		this.hashFields.put("mnl_stl_rqst_flg", "mnlStlRqstFlg");
		return this.hashFields;
	}
	/**
	 * Column Info
	 * @return rctOfcCd
	 */
	public String getPolEtd() {    //추가
		return this.polEtd;    
	}
	/**
	 * Column Info
	 * @return rctOfcCd
	 */
	public String getErrorLapse() {    //추가
		return this.errorLapse;    
	}
	/**
	 * Column Info
	 * @return rctOfcCd
	 */
	public String getRctOfcCd() {
		return this.rctOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bdrStatusCd
	 */
	public String getBdrStatusCd() {
		return this.bdrStatusCd;
	}
	
	/**
	 * Column Info
	 * @return n1stUmchFndDt
	 */
	public String getN1stUmchFndDt() {
		return this.n1stUmchFndDt;
	}
	
	/**
	 * Column Info
	 * @return raterId
	 */
	public String getRaterId() {
		return this.raterId;
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
	 * @return lstUmchFndDt
	 */
	public String getLstUmchFndDt() {
		return this.lstUmchFndDt;
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
	 * @return revAudStlKndNm
	 */
	public String getRevAudStlKndNm() {
		return this.revAudStlKndNm;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return rdnNo
	 */
	public String getRdnNo() {
		return this.rdnNo;
	}
	
	/**
	 * Column Info
	 * @return rtAplyDtFrom
	 */
	public String getRtAplyDtFrom() {
		return this.rtAplyDtFrom;
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
	 * @return revAudStsCd
	 */
	public String getRevAudStsCd() {
		return this.revAudStsCd;
	}
	
	/**
	 * Column Info
	 * @return rqstMnlStlTpCd
	 */
	public String getRqstMnlStlTpCd() {
		return this.rqstMnlStlTpCd;
	}
	/**
	 * Column Info
	 * @return mnlStlRqstFlg
	 */
	public String getMnlStlRqstFlg() {
		return this.mnlStlRqstFlg;
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
	 * @return umchRsnRmk
	 */
	public String getUmchRsnRmk() {
		return this.umchRsnRmk;
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
	 * @return bkgContract
	 */
	public String getBkgContract() {
		return this.bkgContract;
	}
	
	/**
	 * Column Info
	 * @return contractNo
	 */
	public String getContractNo() {
		return this.contractNo;
	}
	
	/**
	 * Column Info
	 * @return autoRatFlg
	 */
	public String getAutoRatFlg() {
		return this.autoRatFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return rctRhqCd
	 */
	public String getRctRhqCd() {
		return this.rctRhqCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return rgnGrpAvcRmk
	 */
	public String getRgnGrpAvcRmk() {
		return this.rgnGrpAvcRmk;
	}
	
	/**
     * Column Info
     * @return revAudAmt
     */
    public String getRevAudAmt() {
        return this.revAudAmt;
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
	 * @return umchBkgSeq
	 */
	public String getUmchBkgSeq() {
		return this.umchBkgSeq;
	}
	
	/**
	 * Column Info
	 * @return revAudTpNm
	 */
	public String getRevAudTpNm() {
		return this.revAudTpNm;
	}
	
	/**
	 * Column Info
	 * @return diffUsdAmt
	 */
	public String getDiffUsdAmt() {
		return this.diffUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return revAudTpCd
	 */
	public String getRevAudTpCd() {
		return this.revAudTpCd;
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
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
	}
	
	/**
	 * Column Info
	 * @return umchE
	 */
	public String getUmchE() {
		return this.umchE;
	}
	
	/**
	 * Column Info
	 * @return umchG
	 */
	public String getUmchG() {
		return this.umchG;
	}
	
	/**
	 * Column Info
	 * @return rtAplyDtTo
	 */
	public String getRtAplyDtTo() {
		return this.rtAplyDtTo;
	}
	
	/**
	 * Column Info
	 * @return umchF
	 */
	public String getUmchF() {
		return this.umchF;
	}
	
	/**
	 * Column Info
	 * @return umchTpCd
	 */
	public String getUmchTpCd() {
		return this.umchTpCd;
	}
	
	/**
	 * Column Info
	 * @return revAudStsNm
	 */
	public String getRevAudStsNm() {
		return this.revAudStsNm;
	}
	
	/**
	 * Column Info
	 * @return revAudStlKndCd
	 */
	public String getRevAudStlKndCd() {
		return this.revAudStlKndCd;
	}
	
	/**
	 * Column Info
	 * @return umchA
	 */
	public String getUmchA() {
		return this.umchA;
	}
	/**
	 * Column Info
	 * @return umchAl
	 */
	public String getUmchAl() {
		return this.umchAl;
	}
	/**
	 * Column Info
	 * @return umchAll
	 */
	public String getUmchAll() {
		return this.umchAll;
	}
	
	/**
	 * Column Info
	 * @return auditSeqCd
	 */
	public String getAuditSeqCd() {
		return this.auditSeqCd;
	}
	
	/**
	 * Column Info
	 * @return umchB
	 */
	public String getUmchB() {
		return this.umchB;
	}
	
	/**
	 * Column Info
	 * @return umchC
	 */
	public String getUmchC() {
		return this.umchC;
	}
	
	/**
	 * Column Info
	 * @return umchD
	 */
	public String getUmchD() {
		return this.umchD;
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
	 * @return contiCd2
	 */
	public String getContiCd2() {
		return this.contiCd2;
	}	
	
	/**
	 * Column Info
	 * @return rdnStatus
	 */
	public String getRdnStatus() {
		return this.rdnStatus;
	}
	
	/**
	 * Column Info
	 * @return errChg
	 */
	public String getErrChg() {
		return this.errChg;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}	
	/**
	 * Column Info
	 * @return dtType
	 */
	public String getDtType() {
		return this.dtType;
	}
	/**
	 * Column Info
	 * @return dtType
	 */
	public String getBdrDt() {
		return this.bdrDt;
	}
	/**
	 * Column Info
	 * @return dtType
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	/**
	 * Column Info
	 * @return portClzDt
	 */	
	public String getPortClzDt() {
		return portClzDt;
	}
	/**
	 * Column Info
	 * @return svcScpCd
	 */	
	public String getSvcScpCd() {
		return svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return gso
	 */	
	public String getGso() {
		return gso;
	}
	
	/**
	 * Column Info
	 * @return stlPrd
	 */	
	public String getStlPrd() {
		return stlPrd;
	}
	
	/**
	 * Column Info
	 * @return stlUsrId
	 */	
	public String getStlUsrId() {
		return stlUsrId;
	}
	
	/**
	 * Column Info
	 * @return errUmchTpCd
	 */
	public String getErrUmchTpCd() {
		return this.errUmchTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnlStlTpCd
	 */
	public String getMnlStlTpCd() {
		return this.mnlStlTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnlStlTp
	 */
	public String getMnlStlTp() {
		return this.mnlStlTp;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}

	/**
	 * Column Info
	 * @param rctOfcCd
	 */
	public void setPolEtd(String polEtd) { //추가
		this.polEtd = polEtd;
	}
	/**
	 * Column Info
	 * @param rctOfcCd
	 */
	public void setErrorLapse(String errorLapse) { //추가
		this.errorLapse = errorLapse;
	}

	/**
	 * Column Info
	 * @param rctOfcCd
	 */
	public void setRctOfcCd(String rctOfcCd) {
		this.rctOfcCd = rctOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bdrStatusCd
	 */
	public void setBdrStatusCd(String bdrStatusCd) {
		this.bdrStatusCd = bdrStatusCd;
	}
	
	/**
	 * Column Info
	 * @param n1stUmchFndDt
	 */
	public void setN1stUmchFndDt(String n1stUmchFndDt) {
		this.n1stUmchFndDt = n1stUmchFndDt;
	}
	
	/**
	 * Column Info
	 * @param raterId
	 */
	public void setRaterId(String raterId) {
		this.raterId = raterId;
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
	 * @param lstUmchFndDt
	 */
	public void setLstUmchFndDt(String lstUmchFndDt) {
		this.lstUmchFndDt = lstUmchFndDt;
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
	 * @param revAudStlKndNm
	 */
	public void setRevAudStlKndNm(String revAudStlKndNm) {
		this.revAudStlKndNm = revAudStlKndNm;
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
	 * @param rqstMnlStlTpCd
	 */
	public void setRqstMnlStlTpCd(String rqstMnlStlTpCd) {
		this.rqstMnlStlTpCd = rqstMnlStlTpCd;
	}
	/**
	 * Column Info
	 * @param mnlStlRqstFlg
	 */
	public void setMnlStlRqstFlg(String mnlStlRqstFlg) {
		this.mnlStlRqstFlg = mnlStlRqstFlg;
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
	 * @param rdnNo
	 */
	public void setRdnNo(String rdnNo) {
		this.rdnNo = rdnNo;
	}
	
	/**
	 * Column Info
	 * @param rtAplyDtFrom
	 */
	public void setRtAplyDtFrom(String rtAplyDtFrom) {
		this.rtAplyDtFrom = rtAplyDtFrom;
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
	 * @param revAudStsCd
	 */
	public void setRevAudStsCd(String revAudStsCd) {
		this.revAudStsCd = revAudStsCd;
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
	 * @param umchRsnRmk
	 */
	public void setUmchRsnRmk(String umchRsnRmk) {
		this.umchRsnRmk = umchRsnRmk;
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
	 * @param bkgContract
	 */
	public void setBkgContract(String bkgContract) {
		this.bkgContract = bkgContract;
	}
	
	/**
	 * Column Info
	 * @param contractNo
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	/**
	 * Column Info
	 * @param autoRatFlg
	 */
	public void setAutoRatFlg(String autoRatFlg) {
		this.autoRatFlg = autoRatFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param rctRhqCd
	 */
	public void setRctRhqCd(String rctRhqCd) {
		this.rctRhqCd = rctRhqCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param rgnGrpAvcRmk
	 */
	public void setRgnGrpAvcRmk(String rgnGrpAvcRmk) {
		this.rgnGrpAvcRmk = rgnGrpAvcRmk;
	}
	
	/**
     * Column Info
     * @param revAudAmt
     */
    public void setRevAudAmt(String revAudAmt) {
        this.revAudAmt = revAudAmt;
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
	 * @param umchBkgSeq
	 */
	public void setUmchBkgSeq(String umchBkgSeq) {
		this.umchBkgSeq = umchBkgSeq;
	}
	
	/**
	 * Column Info
	 * @param revAudTpNm
	 */
	public void setRevAudTpNm(String revAudTpNm) {
		this.revAudTpNm = revAudTpNm;
	}
	
	/**
	 * Column Info
	 * @param diffUsdAmt
	 */
	public void setDiffUsdAmt(String diffUsdAmt) {
		this.diffUsdAmt = diffUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param revAudTpCd
	 */
	public void setRevAudTpCd(String revAudTpCd) {
		this.revAudTpCd = revAudTpCd;
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
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}
	
	/**
	 * Column Info
	 * @param umchE
	 */
	public void setUmchE(String umchE) {
		this.umchE = umchE;
	}
	
	/**
	 * Column Info
	 * @param umchG
	 */
	public void setUmchG(String umchG) {
		this.umchG = umchG;
	}
	
	/**
	 * Column Info
	 * @param rtAplyDtTo
	 */
	public void setRtAplyDtTo(String rtAplyDtTo) {
		this.rtAplyDtTo = rtAplyDtTo;
	}
	
	/**
	 * Column Info
	 * @param umchF
	 */
	public void setUmchF(String umchF) {
		this.umchF = umchF;
	}
	
	/**
	 * Column Info
	 * @param umchTpCd
	 */
	public void setUmchTpCd(String umchTpCd) {
		this.umchTpCd = umchTpCd;
	}
	
	/**
	 * Column Info
	 * @param revAudStsNm
	 */
	public void setRevAudStsNm(String revAudStsNm) {
		this.revAudStsNm = revAudStsNm;
	}
	
	/**
	 * Column Info
	 * @param revAudStlKndCd
	 */
	public void setRevAudStlKndCd(String revAudStlKndCd) {
		this.revAudStlKndCd = revAudStlKndCd;
	}
	
	/**
	 * Column Info
	 * @param umchA
	 */
	public void setUmchA(String umchA) {
		this.umchA = umchA;
	}

	/**
	 * Column Info
	 * @param umchA
	 */
	public void setUmchAl(String umchAl) {
		this.umchAl = umchAl;
	}

	/**
	 * Column Info
	 * @param umchA
	 */
	public void setUmchAll(String umchAll) {
		this.umchAll = umchAll;
	}
	/**
	 * Column Info
	 * @param auditSeqCd
	 */
	public void setAuditSeqCd(String auditSeqCd) {
		this.auditSeqCd = auditSeqCd;
	}
	
	/**
	 * Column Info
	 * @param umchB
	 */
	public void setUmchB(String umchB) {
		this.umchB = umchB;
	}
	
	/**
	 * Column Info
	 * @param umchC
	 */
	public void setUmchC(String umchC) {
		this.umchC = umchC;
	}
	
	/**
	 * Column Info
	 * @param umchD
	 */
	public void setUmchD(String umchD) {
		this.umchD = umchD;
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
	 * @param contiCd2
	 */
	public void setContiCd2(String contiCd2) {
		this.contiCd2 = contiCd2;
	}
	
	/**
	 * Column Info
	 * @param rdnStatus
	 */
	public void setRdnStatus(String rdnStatus) {
		this.rdnStatus = rdnStatus;
	}
	
	/**
	 * Column Info
	 * @param errChg
	 */
	public void setErrChg(String errChg) {
		this.errChg = errChg;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	/**
	 * Column Info
	 * @param dtType
	 */
	public void setDtType(String dtType) {
		this.dtType = dtType;
	}
	/**
	 * Column Info
	 * @param dtType
	 */
	public void setBdrDt(String bdrDt) {
		this.bdrDt = bdrDt;
	}
	/**
	 * Column Info
	 * @param dtType
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	/**
	 * Column Info
	 * @return portClzDt
	 */
	public void setPortClzDt(String portClzDt) {
		this.portClzDt = portClzDt;
	}
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	/**
	 * Column Info
	 * @return gso
	 */
	public void setGso(String gso) {
		this.gso = gso;
	}
	/**
	 * Column Info
	 * @return stlPrd
	 */
	public void setStlPrd(String stlPrd) {
		this.stlPrd = stlPrd;
	}
	/**
	 * Column Info
	 * @return stlUsrId
	 */
	public void setStlUsrId(String stlUsrId) {
		this.stlUsrId = stlUsrId;
	}
	
	/**
	 * Column Info
	 * @param errUmchTpCd
	 */
	public void setErrUmchTpCd(String errUmchTpCd) {
		this.errUmchTpCd = errUmchTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnlStlTpCd
	 */
	public void setMnlStlTpCd(String mnlStlTpCd) {
		this.mnlStlTpCd = mnlStlTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnlStlTp
	 */
	public void setMnlStlTp(String mnlStlTp) {
		this.mnlStlTp = mnlStlTp;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
		setPolEtd(JSPUtil.getParameter(request, prefix + "pol_etd", "")); //추가
		setErrorLapse(JSPUtil.getParameter(request, prefix + "error_lapse", "")); //추가
		setRctOfcCd(JSPUtil.getParameter(request, prefix + "rct_ofc_cd", ""));
		setBdrStatusCd(JSPUtil.getParameter(request, prefix + "bdr_status_cd", ""));
		setN1stUmchFndDt(JSPUtil.getParameter(request, prefix + "n1st_umch_fnd_dt", ""));
		setRaterId(JSPUtil.getParameter(request, prefix + "rater_id", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setLstUmchFndDt(JSPUtil.getParameter(request, prefix + "lst_umch_fnd_dt", ""));
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setRevAudStlKndNm(JSPUtil.getParameter(request, prefix + "rev_aud_stl_knd_nm", ""));
		setCtrtTpCd(JSPUtil.getParameter(request, prefix + "ctrt_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setRdnNo(JSPUtil.getParameter(request, prefix + "rdn_no", ""));
		setRtAplyDtFrom(JSPUtil.getParameter(request, prefix + "rt_aply_dt_from", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRevAudStsCd(JSPUtil.getParameter(request, prefix + "rev_aud_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUmchRsnRmk(JSPUtil.getParameter(request, prefix + "umch_rsn_rmk", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setBkgContract(JSPUtil.getParameter(request, prefix + "bkg_contract", ""));
		setContractNo(JSPUtil.getParameter(request, prefix + "contract_no", ""));
		setAutoRatFlg(JSPUtil.getParameter(request, prefix + "auto_rat_flg", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setRctRhqCd(JSPUtil.getParameter(request, prefix + "rct_rhq_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRgnGrpAvcRmk(JSPUtil.getParameter(request, prefix + "rgn_grp_avc_rmk", ""));
		setRevAudAmt(JSPUtil.getParameter(request, prefix + "rev_aud_amt", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setUmchBkgSeq(JSPUtil.getParameter(request, prefix + "umch_bkg_seq", ""));
		setRevAudTpNm(JSPUtil.getParameter(request, prefix + "rev_aud_tp_nm", ""));
		setDiffUsdAmt(JSPUtil.getParameter(request, prefix + "diff_usd_amt", ""));
		setRevAudTpCd(JSPUtil.getParameter(request, prefix + "rev_aud_tp_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
		setUmchE(JSPUtil.getParameter(request, prefix + "umch_e", ""));
		setUmchG(JSPUtil.getParameter(request, prefix + "umch_g", ""));
		setRtAplyDtTo(JSPUtil.getParameter(request, prefix + "rt_aply_dt_to", ""));
		setUmchF(JSPUtil.getParameter(request, prefix + "umch_f", ""));
		setUmchTpCd(JSPUtil.getParameter(request, prefix + "umch_tp_cd", ""));
		setRevAudStsNm(JSPUtil.getParameter(request, prefix + "rev_aud_sts_nm", ""));
		setRevAudStlKndCd(JSPUtil.getParameter(request, prefix + "rev_aud_stl_knd_cd", ""));
		setUmchA(JSPUtil.getParameter(request, prefix + "umch_a", ""));
		setUmchAl(JSPUtil.getParameter(request, prefix + "umch_al", ""));
		setUmchAll(JSPUtil.getParameter(request, prefix + "umch_all", ""));
		
		setAuditSeqCd(JSPUtil.getParameter(request, prefix + "audit_seq_cd", ""));
		setUmchB(JSPUtil.getParameter(request, prefix + "umch_b", ""));
		setUmchC(JSPUtil.getParameter(request, prefix + "umch_c", ""));
		setUmchD(JSPUtil.getParameter(request, prefix + "umch_d", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setContiCd2(JSPUtil.getParameter(request, prefix + "conti_cd2", ""));
		setRdnStatus(JSPUtil.getParameter(request, prefix + "rdn_status", ""));
		setErrChg(JSPUtil.getParameter(request, prefix + "err_chg", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setDtType(JSPUtil.getParameter(request, prefix + "dt_type", ""));
		setBdrDt(JSPUtil.getParameter(request, prefix + "bdr_dt", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPortClzDt(JSPUtil.getParameter(request, prefix + "port_clz_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setGso(JSPUtil.getParameter(request, prefix + "gso", ""));
		setStlPrd(JSPUtil.getParameter(request, prefix + "stl_prd", ""));
		setStlUsrId(JSPUtil.getParameter(request, prefix + "stl_usr_id", ""));
		setErrUmchTpCd(JSPUtil.getParameter(request, prefix + "err_umch_tp_cd", ""));
		setMnlStlTpCd(JSPUtil.getParameter(request, prefix + "mnl_stl_tp_cd", ""));
		setMnlStlTp(JSPUtil.getParameter(request, "mnl_stl_tp", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		
		setRqstMnlStlTpCd(JSPUtil.getParameter(request, prefix + "rqst_mnl_stl_tp_cd", ""));
		setMnlStlRqstFlg(JSPUtil.getParameter(request, prefix + "mnl_stl_rqst_flg", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltUnmatchBLListbyAuditorVO[]
	 */
	public RsltUnmatchBLListbyAuditorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltUnmatchBLListbyAuditorVO[]
	 */
	public RsltUnmatchBLListbyAuditorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltUnmatchBLListbyAuditorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));//추가
			String[] errorLapse = (JSPUtil.getParameter(request, prefix	+ "error_lapse", length));//추가
			String[] rctOfcCd = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_cd", length));
			String[] bdrStatusCd = (JSPUtil.getParameter(request, prefix	+ "bdr_status_cd", length));
			String[] n1stUmchFndDt = (JSPUtil.getParameter(request, prefix	+ "n1st_umch_fnd_dt", length));
			String[] raterId = (JSPUtil.getParameter(request, prefix	+ "rater_id", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] lstUmchFndDt = (JSPUtil.getParameter(request, prefix	+ "lst_umch_fnd_dt", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] revAudStlKndNm = (JSPUtil.getParameter(request, prefix	+ "rev_aud_stl_knd_nm", length));
			String[] ctrtTpCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] rdnNo = (JSPUtil.getParameter(request, prefix	+ "rdn_no", length));
			String[] rtAplyDtFrom = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt_from", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revAudStsCd = (JSPUtil.getParameter(request, prefix	+ "rev_aud_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] umchRsnRmk = (JSPUtil.getParameter(request, prefix	+ "umch_rsn_rmk", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] bkgContract = (JSPUtil.getParameter(request, prefix	+ "bkg_contract", length));
			String[] contractNo = (JSPUtil.getParameter(request, prefix	+ "contract_no", length));
			String[] autoRatFlg = (JSPUtil.getParameter(request, prefix	+ "auto_rat_flg", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] rctRhqCd = (JSPUtil.getParameter(request, prefix	+ "rct_rhq_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rgnGrpAvcRmk = (JSPUtil.getParameter(request, prefix	+ "rgn_grp_avc_rmk", length));
			String[] revAudAmt = (JSPUtil.getParameter(request, prefix    + "rev_aud_amt", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] umchBkgSeq = (JSPUtil.getParameter(request, prefix	+ "umch_bkg_seq", length));
			String[] revAudTpNm = (JSPUtil.getParameter(request, prefix	+ "rev_aud_tp_nm", length));
			String[] diffUsdAmt = (JSPUtil.getParameter(request, prefix	+ "diff_usd_amt", length));
			String[] revAudTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_aud_tp_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] umchE = (JSPUtil.getParameter(request, prefix	+ "umch_e", length));
			String[] umchG = (JSPUtil.getParameter(request, prefix	+ "umch_g", length));
			String[] rtAplyDtTo = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt_to", length));
			String[] umchF = (JSPUtil.getParameter(request, prefix	+ "umch_f", length));
			String[] umchTpCd = (JSPUtil.getParameter(request, prefix	+ "umch_tp_cd", length));
			String[] revAudStsNm = (JSPUtil.getParameter(request, prefix	+ "rev_aud_sts_nm", length));
			String[] revAudStlKndCd = (JSPUtil.getParameter(request, prefix	+ "rev_aud_stl_knd_cd", length));
			String[] umchA = (JSPUtil.getParameter(request, prefix	+ "umch_a", length));
			String[] umchAl = (JSPUtil.getParameter(request, prefix	+ "umch_al", length));
			String[] umchAll = (JSPUtil.getParameter(request, prefix	+ "umch_all", length));
			
			String[] auditSeqCd = (JSPUtil.getParameter(request, prefix	+ "audit_seq_cd", length));
			String[] umchB = (JSPUtil.getParameter(request, prefix	+ "umch_b", length));
			String[] umchC = (JSPUtil.getParameter(request, prefix	+ "umch_c", length));
			String[] umchD = (JSPUtil.getParameter(request, prefix	+ "umch_d", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] contiCd2 = (JSPUtil.getParameter(request, prefix	+ "conti_cd2", length));
			String[] rdnStatus = (JSPUtil.getParameter(request, prefix	+ "rdn_status", length));
			String[] errChg = (JSPUtil.getParameter(request, prefix	+ "err_chg", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] dtType = (JSPUtil.getParameter(request, prefix	+ "dt_type", length));
			String[] bdrDt = (JSPUtil.getParameter(request, prefix	+ "bdr_dt", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] portClzDt = (JSPUtil.getParameter(request, prefix	+ "port_clz_dt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] gso = (JSPUtil.getParameter(request, prefix	+ "gso", length));
			String[] stlPrd = (JSPUtil.getParameter(request, prefix	+ "stl_prd", length));
			String[] stlUsrId = (JSPUtil.getParameter(request, prefix	+ "stl_usr_id", length));
			String[] errUmchTpCd = (JSPUtil.getParameter(request, prefix	+ "err_umch_tp_cd", length));
			String[] mnlStlTpCd = (JSPUtil.getParameter(request, prefix	+ "mnl_stl_tp_cd", length));
			String[] mnlStlTp = (JSPUtil.getParameter(request, prefix	+ "mnl_stl_tp", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			
			String[] rqstMnlStlTpCd = (JSPUtil.getParameter(request, prefix	+ "rqst_mnl_stl_tp_cd", length));
			String[] mnlStlRqstFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_stl_rqst_flg", length));
			/* Add a field line, do not delete */
			for (int i = 0; i < length; i++) {
				model = new RsltUnmatchBLListbyAuditorVO();
				if (polEtd[i] != null) //추가
					model.setPolEtd(polEtd[i]);
				if (errorLapse[i] != null) //추가
					model.setErrorLapse(errorLapse[i]);
				if (rctOfcCd[i] != null)
					model.setRctOfcCd(rctOfcCd[i]);
				if (bdrStatusCd[i] != null)
					model.setBdrStatusCd(bdrStatusCd[i]);
				if (n1stUmchFndDt[i] != null)
					model.setN1stUmchFndDt(n1stUmchFndDt[i]);
				if (raterId[i] != null)
					model.setRaterId(raterId[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (lstUmchFndDt[i] != null)
					model.setLstUmchFndDt(lstUmchFndDt[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (revAudStlKndNm[i] != null)
					model.setRevAudStlKndNm(revAudStlKndNm[i]);
				if (ctrtTpCd[i] != null)
					model.setCtrtTpCd(ctrtTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (rdnNo[i] != null)
					model.setRdnNo(rdnNo[i]);
				if (rtAplyDtFrom[i] != null)
					model.setRtAplyDtFrom(rtAplyDtFrom[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revAudStsCd[i] != null)
					model.setRevAudStsCd(revAudStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (umchRsnRmk[i] != null)
					model.setUmchRsnRmk(umchRsnRmk[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (bkgContract[i] != null)
					model.setBkgContract(bkgContract[i]);
				if (contractNo[i] != null)
					model.setContractNo(contractNo[i]);
				if (autoRatFlg[i] != null)
					model.setAutoRatFlg(autoRatFlg[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (rctRhqCd[i] != null)
					model.setRctRhqCd(rctRhqCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rgnGrpAvcRmk[i] != null)
					model.setRgnGrpAvcRmk(rgnGrpAvcRmk[i]);
				if (revAudAmt[i] != null)
                    model.setRevAudAmt(revAudAmt[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (umchBkgSeq[i] != null)
					model.setUmchBkgSeq(umchBkgSeq[i]);
				if (revAudTpNm[i] != null)
					model.setRevAudTpNm(revAudTpNm[i]);
				if (diffUsdAmt[i] != null)
					model.setDiffUsdAmt(diffUsdAmt[i]);
				if (revAudTpCd[i] != null)
					model.setRevAudTpCd(revAudTpCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (umchE[i] != null)
					model.setUmchE(umchE[i]);
				if (umchG[i] != null)
					model.setUmchG(umchG[i]);
				if (rtAplyDtTo[i] != null)
					model.setRtAplyDtTo(rtAplyDtTo[i]);
				if (umchF[i] != null)
					model.setUmchF(umchF[i]);
				if (umchTpCd[i] != null)
					model.setUmchTpCd(umchTpCd[i]);
				if (revAudStsNm[i] != null)
					model.setRevAudStsNm(revAudStsNm[i]);
				if (revAudStlKndCd[i] != null)
					model.setRevAudStlKndCd(revAudStlKndCd[i]);
				if (umchA[i] != null)
					model.setUmchA(umchA[i]);
				if (umchAl[i] != null)
					model.setUmchAl(umchAl[i]);
				if (umchAll[i] != null)
					model.setUmchAll(umchAll[i]);
				
				if (auditSeqCd[i] != null)
					model.setAuditSeqCd(auditSeqCd[i]);
				if (umchB[i] != null)
					model.setUmchB(umchB[i]);
				if (umchC[i] != null)
					model.setUmchC(umchC[i]);
				if (umchD[i] != null)
					model.setUmchD(umchD[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (contiCd2[i] != null)
					model.setContiCd2(contiCd2[i]);
				if (rdnStatus[i] !=null)
					model.setRdnStatus(rdnStatus[i]);
				if (errChg[i] !=null)
					model.setErrChg(errChg[i]);
				if (chgCd[i] !=null)
					model.setChgCd(chgCd[i]);
				if (dtType[i] != null)
					model.setDtType(dtType[i]);
				if (bdrDt[i] != null)
					model.setBdrDt(bdrDt[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (portClzDt[i] != null)
					model.setPortClzDt(portClzDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (gso[i] != null)
					model.setGso(gso[i]);
				if (stlPrd[i] != null)
					model.setStlPrd(stlPrd[i]);
				if (stlUsrId[i] != null)
					model.setStlUsrId(stlUsrId[i]);
				if (errUmchTpCd[i] != null)
					model.setErrUmchTpCd(errUmchTpCd[i]);
				if (mnlStlTpCd[i] != null)
					model.setMnlStlTpCd(mnlStlTpCd[i]);
				if (mnlStlTp[i] != null)
					model.setMnlStlTp(mnlStlTp[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (rqstMnlStlTpCd[i] != null)
					model.setRqstMnlStlTpCd(rqstMnlStlTpCd[i]);
				if (mnlStlRqstFlg[i] != null)
					model.setMnlStlRqstFlg(mnlStlRqstFlg[i]);
				/* Add a Method line, do not delete */ 
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltUnmatchBLListbyAuditorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltUnmatchBLListbyAuditorVO[]
	 */
	public RsltUnmatchBLListbyAuditorVO[] getRsltUnmatchBLListbyAuditorVOs(){
		RsltUnmatchBLListbyAuditorVO[] vos = (RsltUnmatchBLListbyAuditorVO[])models.toArray(new RsltUnmatchBLListbyAuditorVO[models.size()]);
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
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");//추가
		this.errorLapse = this.errorLapse .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");//추가
		this.rctOfcCd = this.rctOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrStatusCd = this.bdrStatusCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stUmchFndDt = this.n1stUmchFndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raterId = this.raterId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstUmchFndDt = this.lstUmchFndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudStlKndNm = this.revAudStlKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtTpCd = this.ctrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnNo = this.rdnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDtFrom = this.rtAplyDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudStsCd = this.revAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchRsnRmk = this.umchRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgContract = this.bkgContract .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractNo = this.contractNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatFlg = this.autoRatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctRhqCd = this.rctRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnGrpAvcRmk = this.rgnGrpAvcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudAmt = this.revAudAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchBkgSeq = this.umchBkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudTpNm = this.revAudTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffUsdAmt = this.diffUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudTpCd = this.revAudTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchE = this.umchE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchG = this.umchG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDtTo = this.rtAplyDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchF = this.umchF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchTpCd = this.umchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudStsNm = this.revAudStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudStlKndCd = this.revAudStlKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchA = this.umchA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchAl = this.umchAl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchAll = this.umchAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.auditSeqCd = this.auditSeqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchB = this.umchB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchC = this.umchC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchD = this.umchD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd2 = this.contiCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnStatus = this.rdnStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errChg = this.errChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtType = this.dtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrDt = this.bdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portClzDt = this.portClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gso = this.gso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlPrd = this.stlPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlUsrId = this.stlUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlStlTpCd = this.mnlStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlStlTp = this.mnlStlTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.rqstMnlStlTpCd = this.rqstMnlStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlStlRqstFlg = this.mnlStlRqstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
