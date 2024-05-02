/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SlipProcessVO.java
*@FileTitle : SlipProcessVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.27 박희동 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SlipProcessVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SlipProcessVO> models = new ArrayList<SlipProcessVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String finJoStlItmCd = null;
	/* Column Info */
	private String drAcctCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String slpDesc = null;
	/* Column Info */
	private String joStlItmCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String crLocCd = null;
	/* Column Info */
	private String custVndrEngNm = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String arApDivCd = null;
	/* Column Info */
	private String totAmount = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String csrTpCd = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String slpIssInterCoCd = null;
	/* Column Info */
	private String custVndrSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String custVndrRgstNo = null;
	/* Column Info */
	private String chkLocCd = null;
	/* Column Info */
	private String custVndrKorNm = null;
	/* Column Info */
	private String issuerId = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String bsaSltPrc = null;
	/* Column Info */
	private String chkCtrCd = null;
	/* Column Info */
	private String drLocCd = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Column Info */
	private String stlCmbSeq = null;
	/* Column Info */
	private String aproStep = null;
	/* Column Info */
	private String bsaQty = null;
	/* Column Info */
	private String crCtrCd = null;
	/* Column Info */
	private String evidTpCd = null;
	/* Column Info */
	private String vvdCxlFlg = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String stlLoclAmt = null;
	/* Column Info */
	private String slpIssRgnCd = null;
	/* Column Info */
	private String stlVvdSeq = null;
	/* Column Info */
	private String keyNo = null;
	/* Column Info */
	private String stlSeq = null;
	/* Column Info */
	private String drCrCd = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String issuerNm = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String custVndrCntCd = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String crAcctCd = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String drCtrCd = null;
	/* Column Info */
	private String slpIssOfcCd = null;
	/* Column Info */
	private String csrOffstNo = null;
	/* Column Info */
	private String agmtDocNo = null;
	/* Column Info */
	private String agmtDocDesc = null;
	/* Column Info */
	private String aproFlg = null;
	/* Column Info */
	private String cxlFlg = null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SlipProcessVO() {}

	public SlipProcessVO(String ibflag, String pagerows, String acctYrmon, String stlVvdSeq, String stlSeq, String joCrrCd, String stlCmbSeq, String reDivrCd, String custVndrSeq, String custVndrCntCd, String custVndrEngNm, String custVndrKorNm, String custVndrRgstNo, String slpIssInterCoCd, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo, String issuerId, String issuerNm, String csrDesc, String loclCurrCd, String stlLoclAmt, String evidTpCd, String csrTpCd, String revYrmon, String effDt, String rqstDt, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String rlaneCd, String drCtrCd, String crCtrCd, String drLocCd, String crLocCd, String chkCtrCd, String chkLocCd, String drAcctCd, String crAcctCd, String slpDesc, String vvdCxlFlg, String totAmount, String drCrCd, String keyNo, String arApDivCd, String slpIssRgnCd, String csrOffstNo, String slpIssOfcCd, String joStlItmCd, String finJoStlItmCd, String bsaQty, String bsaSltPrc, String aproStep, String agmtDocNo, String agmtDocDesc, String aproFlg, String cxlFlg) {
		this.vslCd = vslCd;
		this.slpFuncCd = slpFuncCd;
		this.csrDesc = csrDesc;
		this.finJoStlItmCd = finJoStlItmCd;
		this.drAcctCd = drAcctCd;
		this.rlaneCd = rlaneCd;
		this.slpDesc = slpDesc;
		this.joStlItmCd = joStlItmCd;
		this.pagerows = pagerows;
		this.crLocCd = crLocCd;
		this.custVndrEngNm = custVndrEngNm;
		this.effDt = effDt;
		this.arApDivCd = arApDivCd;
		this.totAmount = totAmount;
		this.slpTpCd = slpTpCd;
		this.csrTpCd = csrTpCd;
		this.revYrmon = revYrmon;
		this.loclCurrCd = loclCurrCd;
		this.slpIssInterCoCd = slpIssInterCoCd;
		this.custVndrSeq = custVndrSeq;
		this.skdVoyNo = skdVoyNo;
		this.custVndrRgstNo = custVndrRgstNo;
		this.chkLocCd = chkLocCd;
		this.custVndrKorNm = custVndrKorNm;
		this.issuerId = issuerId;
		this.acctYrmon = acctYrmon;
		this.bsaSltPrc = bsaSltPrc;
		this.chkCtrCd = chkCtrCd;
		this.drLocCd = drLocCd;
		this.slpSerNo = slpSerNo;
		this.stlCmbSeq = stlCmbSeq;
		this.aproStep = aproStep;
		this.bsaQty = bsaQty;
		this.crCtrCd = crCtrCd;
		this.evidTpCd = evidTpCd;
		this.vvdCxlFlg = vvdCxlFlg;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.stlLoclAmt = stlLoclAmt;
		this.slpIssRgnCd = slpIssRgnCd;
		this.stlVvdSeq = stlVvdSeq;
		this.keyNo = keyNo;
		this.stlSeq = stlSeq;
		this.drCrCd = drCrCd;
		this.rqstDt = rqstDt;
		this.issuerNm = issuerNm;
		this.joCrrCd = joCrrCd;
		this.custVndrCntCd = custVndrCntCd;
		this.slpIssDt = slpIssDt;
		this.slpOfcCd = slpOfcCd;
		this.skdDirCd = skdDirCd;
		this.crAcctCd = crAcctCd;
		this.reDivrCd = reDivrCd;
		this.drCtrCd = drCtrCd;
		this.slpIssOfcCd = slpIssOfcCd;
		this.csrOffstNo = csrOffstNo;
		this.agmtDocNo = agmtDocNo;
		this.agmtDocDesc = agmtDocDesc;
		this.aproFlg = aproFlg;
		this.cxlFlg = cxlFlg;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("fin_jo_stl_itm_cd", getFinJoStlItmCd());
		this.hashColumns.put("dr_acct_cd", getDrAcctCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("slp_desc", getSlpDesc());
		this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cr_loc_cd", getCrLocCd());
		this.hashColumns.put("cust_vndr_eng_nm", getCustVndrEngNm());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ar_ap_div_cd", getArApDivCd());
		this.hashColumns.put("tot_amount", getTotAmount());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("csr_tp_cd", getCsrTpCd());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("slp_iss_inter_co_cd", getSlpIssInterCoCd());
		this.hashColumns.put("cust_vndr_seq", getCustVndrSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cust_vndr_rgst_no", getCustVndrRgstNo());
		this.hashColumns.put("chk_loc_cd", getChkLocCd());
		this.hashColumns.put("cust_vndr_kor_nm", getCustVndrKorNm());
		this.hashColumns.put("issuer_id", getIssuerId());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("bsa_slt_prc", getBsaSltPrc());
		this.hashColumns.put("chk_ctr_cd", getChkCtrCd());
		this.hashColumns.put("dr_loc_cd", getDrLocCd());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
		this.hashColumns.put("apro_step", getAproStep());
		this.hashColumns.put("bsa_qty", getBsaQty());
		this.hashColumns.put("cr_ctr_cd", getCrCtrCd());
		this.hashColumns.put("evid_tp_cd", getEvidTpCd());
		this.hashColumns.put("vvd_cxl_flg", getVvdCxlFlg());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("stl_locl_amt", getStlLoclAmt());
		this.hashColumns.put("slp_iss_rgn_cd", getSlpIssRgnCd());
		this.hashColumns.put("stl_vvd_seq", getStlVvdSeq());
		this.hashColumns.put("key_no", getKeyNo());
		this.hashColumns.put("stl_seq", getStlSeq());
		this.hashColumns.put("dr_cr_cd", getDrCrCd());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("issuer_nm", getIssuerNm());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("cust_vndr_cnt_cd", getCustVndrCntCd());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cr_acct_cd", getCrAcctCd());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("dr_ctr_cd", getDrCtrCd());
		this.hashColumns.put("slp_iss_ofc_cd", getSlpIssOfcCd());
		this.hashColumns.put("csr_offst_no", getCsrOffstNo());
		this.hashColumns.put("agmt_doc_no", getAgmtDocNo());
		this.hashColumns.put("agmt_doc_desc", getAgmtDocDesc());		
		this.hashColumns.put("apro_flg", getAproFlg());
		this.hashColumns.put("cxl_flg", getCxlFlg());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("fin_jo_stl_itm_cd", "finJoStlItmCd");
		this.hashFields.put("dr_acct_cd", "drAcctCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("slp_desc", "slpDesc");
		this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cr_loc_cd", "crLocCd");
		this.hashFields.put("cust_vndr_eng_nm", "custVndrEngNm");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ar_ap_div_cd", "arApDivCd");
		this.hashFields.put("tot_amount", "totAmount");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("csr_tp_cd", "csrTpCd");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("slp_iss_inter_co_cd", "slpIssInterCoCd");
		this.hashFields.put("cust_vndr_seq", "custVndrSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cust_vndr_rgst_no", "custVndrRgstNo");
		this.hashFields.put("chk_loc_cd", "chkLocCd");
		this.hashFields.put("cust_vndr_kor_nm", "custVndrKorNm");
		this.hashFields.put("issuer_id", "issuerId");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("bsa_slt_prc", "bsaSltPrc");
		this.hashFields.put("chk_ctr_cd", "chkCtrCd");
		this.hashFields.put("dr_loc_cd", "drLocCd");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
		this.hashFields.put("apro_step", "aproStep");
		this.hashFields.put("bsa_qty", "bsaQty");
		this.hashFields.put("cr_ctr_cd", "crCtrCd");
		this.hashFields.put("evid_tp_cd", "evidTpCd");
		this.hashFields.put("vvd_cxl_flg", "vvdCxlFlg");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("stl_locl_amt", "stlLoclAmt");
		this.hashFields.put("slp_iss_rgn_cd", "slpIssRgnCd");
		this.hashFields.put("stl_vvd_seq", "stlVvdSeq");
		this.hashFields.put("key_no", "keyNo");
		this.hashFields.put("stl_seq", "stlSeq");
		this.hashFields.put("dr_cr_cd", "drCrCd");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("issuer_nm", "issuerNm");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("cust_vndr_cnt_cd", "custVndrCntCd");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cr_acct_cd", "crAcctCd");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("dr_ctr_cd", "drCtrCd");
		this.hashFields.put("slp_iss_ofc_cd", "slpIssOfcCd");
		this.hashFields.put("csr_offst_no", "csrOffstNo");
		this.hashFields.put("agmt_doc_no", "agmtDocNo");
		this.hashFields.put("agmt_doc_desc", "agmtDocDesc");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("cxl_flg", "cxlFlg");		
		return this.hashFields;
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
	 * @return slpFuncCd
	 */
	public String getSlpFuncCd() {
		return this.slpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return csrDesc
	 */
	public String getCsrDesc() {
		return this.csrDesc;
	}
	
	/**
	 * Column Info
	 * @return finJoStlItmCd
	 */
	public String getFinJoStlItmCd() {
		return this.finJoStlItmCd;
	}
	
	/**
	 * Column Info
	 * @return drAcctCd
	 */
	public String getDrAcctCd() {
		return this.drAcctCd;
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
	 * @return slpDesc
	 */
	public String getSlpDesc() {
		return this.slpDesc;
	}
	
	/**
	 * Column Info
	 * @return joStlItmCd
	 */
	public String getJoStlItmCd() {
		return this.joStlItmCd;
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
	 * @return crLocCd
	 */
	public String getCrLocCd() {
		return this.crLocCd;
	}
	
	/**
	 * Column Info
	 * @return custVndrEngNm
	 */
	public String getCustVndrEngNm() {
		return this.custVndrEngNm;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return arApDivCd
	 */
	public String getArApDivCd() {
		return this.arApDivCd;
	}
	
	/**
	 * Column Info
	 * @return totAmount
	 */
	public String getTotAmount() {
		return this.totAmount;
	}
	
	/**
	 * Column Info
	 * @return slpTpCd
	 */
	public String getSlpTpCd() {
		return this.slpTpCd;
	}
	
	/**
	 * Column Info
	 * @return csrTpCd
	 */
	public String getCsrTpCd() {
		return this.csrTpCd;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return slpIssInterCoCd
	 */
	public String getSlpIssInterCoCd() {
		return this.slpIssInterCoCd;
	}
	
	/**
	 * Column Info
	 * @return custVndrSeq
	 */
	public String getCustVndrSeq() {
		return this.custVndrSeq;
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
	 * @return custVndrRgstNo
	 */
	public String getCustVndrRgstNo() {
		return this.custVndrRgstNo;
	}
	
	/**
	 * Column Info
	 * @return chkLocCd
	 */
	public String getChkLocCd() {
		return this.chkLocCd;
	}
	
	/**
	 * Column Info
	 * @return custVndrKorNm
	 */
	public String getCustVndrKorNm() {
		return this.custVndrKorNm;
	}
	
	/**
	 * Column Info
	 * @return issuerId
	 */
	public String getIssuerId() {
		return this.issuerId;
	}
	
	/**
	 * Column Info
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
	}
	
	/**
	 * Column Info
	 * @return bsaSltPrc
	 */
	public String getBsaSltPrc() {
		return this.bsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return chkCtrCd
	 */
	public String getChkCtrCd() {
		return this.chkCtrCd;
	}
	
	/**
	 * Column Info
	 * @return drLocCd
	 */
	public String getDrLocCd() {
		return this.drLocCd;
	}
	
	/**
	 * Column Info
	 * @return slpSerNo
	 */
	public String getSlpSerNo() {
		return this.slpSerNo;
	}
	
	/**
	 * Column Info
	 * @return stlCmbSeq
	 */
	public String getStlCmbSeq() {
		return this.stlCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return aproStep
	 */
	public String getAproStep() {
		return this.aproStep;
	}
	
	/**
	 * Column Info
	 * @return bsaQty
	 */
	public String getBsaQty() {
		return this.bsaQty;
	}
	
	/**
	 * Column Info
	 * @return crCtrCd
	 */
	public String getCrCtrCd() {
		return this.crCtrCd;
	}
	
	/**
	 * Column Info
	 * @return evidTpCd
	 */
	public String getEvidTpCd() {
		return this.evidTpCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCxlFlg
	 */
	public String getVvdCxlFlg() {
		return this.vvdCxlFlg;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return stlLoclAmt
	 */
	public String getStlLoclAmt() {
		return this.stlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return slpIssRgnCd
	 */
	public String getSlpIssRgnCd() {
		return this.slpIssRgnCd;
	}
	
	/**
	 * Column Info
	 * @return stlVvdSeq
	 */
	public String getStlVvdSeq() {
		return this.stlVvdSeq;
	}
	
	/**
	 * Column Info
	 * @return keyNo
	 */
	public String getKeyNo() {
		return this.keyNo;
	}
	
	/**
	 * Column Info
	 * @return stlSeq
	 */
	public String getStlSeq() {
		return this.stlSeq;
	}
	
	/**
	 * Column Info
	 * @return drCrCd
	 */
	public String getDrCrCd() {
		return this.drCrCd;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return issuerNm
	 */
	public String getIssuerNm() {
		return this.issuerNm;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return custVndrCntCd
	 */
	public String getCustVndrCntCd() {
		return this.custVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return slpIssDt
	 */
	public String getSlpIssDt() {
		return this.slpIssDt;
	}
	
	/**
	 * Column Info
	 * @return slpOfcCd
	 */
	public String getSlpOfcCd() {
		return this.slpOfcCd;
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
	 * @return crAcctCd
	 */
	public String getCrAcctCd() {
		return this.crAcctCd;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return drCtrCd
	 */
	public String getDrCtrCd() {
		return this.drCtrCd;
	}
	
	/**
	 * Column Info
	 * @return slpIssOfcCd
	 */
	public String getSlpIssOfcCd() {
		return this.slpIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return csrOffstNo
	 */
	public String getCsrOffstNo() {
		return this.csrOffstNo;
	}
	
	/**
	 * Column Info
	 * @return agmtDocNo
	 */
	public String getAgmtDocNo() {
		return this.agmtDocNo;
	}

	/**
	 * Column Info
	 * @return agmtDocDesc
	 */
	public String getAgmtDocDesc() {
		return this.agmtDocDesc;
	}
	
	/**
	 * Column Info
	 * @return aproFlg
	 */
	public String getAproFlg() {
		return this.aproFlg;
	}

	/**
	 * Column Info
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
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
	 * @param slpFuncCd
	 */
	public void setSlpFuncCd(String slpFuncCd) {
		this.slpFuncCd = slpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param csrDesc
	 */
	public void setCsrDesc(String csrDesc) {
		this.csrDesc = csrDesc;
	}
	
	/**
	 * Column Info
	 * @param finJoStlItmCd
	 */
	public void setFinJoStlItmCd(String finJoStlItmCd) {
		this.finJoStlItmCd = finJoStlItmCd;
	}
	
	/**
	 * Column Info
	 * @param drAcctCd
	 */
	public void setDrAcctCd(String drAcctCd) {
		this.drAcctCd = drAcctCd;
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
	 * @param slpDesc
	 */
	public void setSlpDesc(String slpDesc) {
		this.slpDesc = slpDesc;
	}
	
	/**
	 * Column Info
	 * @param joStlItmCd
	 */
	public void setJoStlItmCd(String joStlItmCd) {
		this.joStlItmCd = joStlItmCd;
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
	 * @param crLocCd
	 */
	public void setCrLocCd(String crLocCd) {
		this.crLocCd = crLocCd;
	}
	
	/**
	 * Column Info
	 * @param custVndrEngNm
	 */
	public void setCustVndrEngNm(String custVndrEngNm) {
		this.custVndrEngNm = custVndrEngNm;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param arApDivCd
	 */
	public void setArApDivCd(String arApDivCd) {
		this.arApDivCd = arApDivCd;
	}
	
	/**
	 * Column Info
	 * @param totAmount
	 */
	public void setTotAmount(String totAmount) {
		this.totAmount = totAmount;
	}
	
	/**
	 * Column Info
	 * @param slpTpCd
	 */
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
	}
	
	/**
	 * Column Info
	 * @param csrTpCd
	 */
	public void setCsrTpCd(String csrTpCd) {
		this.csrTpCd = csrTpCd;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param slpIssInterCoCd
	 */
	public void setSlpIssInterCoCd(String slpIssInterCoCd) {
		this.slpIssInterCoCd = slpIssInterCoCd;
	}
	
	/**
	 * Column Info
	 * @param custVndrSeq
	 */
	public void setCustVndrSeq(String custVndrSeq) {
		this.custVndrSeq = custVndrSeq;
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
	 * @param custVndrRgstNo
	 */
	public void setCustVndrRgstNo(String custVndrRgstNo) {
		this.custVndrRgstNo = custVndrRgstNo;
	}
	
	/**
	 * Column Info
	 * @param chkLocCd
	 */
	public void setChkLocCd(String chkLocCd) {
		this.chkLocCd = chkLocCd;
	}
	
	/**
	 * Column Info
	 * @param custVndrKorNm
	 */
	public void setCustVndrKorNm(String custVndrKorNm) {
		this.custVndrKorNm = custVndrKorNm;
	}
	
	/**
	 * Column Info
	 * @param issuerId
	 */
	public void setIssuerId(String issuerId) {
		this.issuerId = issuerId;
	}
	
	/**
	 * Column Info
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
	}
	
	/**
	 * Column Info
	 * @param bsaSltPrc
	 */
	public void setBsaSltPrc(String bsaSltPrc) {
		this.bsaSltPrc = bsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param chkCtrCd
	 */
	public void setChkCtrCd(String chkCtrCd) {
		this.chkCtrCd = chkCtrCd;
	}
	
	/**
	 * Column Info
	 * @param drLocCd
	 */
	public void setDrLocCd(String drLocCd) {
		this.drLocCd = drLocCd;
	}
	
	/**
	 * Column Info
	 * @param slpSerNo
	 */
	public void setSlpSerNo(String slpSerNo) {
		this.slpSerNo = slpSerNo;
	}
	
	/**
	 * Column Info
	 * @param stlCmbSeq
	 */
	public void setStlCmbSeq(String stlCmbSeq) {
		this.stlCmbSeq = stlCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param aproStep
	 */
	public void setAproStep(String aproStep) {
		this.aproStep = aproStep;
	}
	
	/**
	 * Column Info
	 * @param bsaQty
	 */
	public void setBsaQty(String bsaQty) {
		this.bsaQty = bsaQty;
	}
	
	/**
	 * Column Info
	 * @param crCtrCd
	 */
	public void setCrCtrCd(String crCtrCd) {
		this.crCtrCd = crCtrCd;
	}
	
	/**
	 * Column Info
	 * @param evidTpCd
	 */
	public void setEvidTpCd(String evidTpCd) {
		this.evidTpCd = evidTpCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCxlFlg
	 */
	public void setVvdCxlFlg(String vvdCxlFlg) {
		this.vvdCxlFlg = vvdCxlFlg;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param stlLoclAmt
	 */
	public void setStlLoclAmt(String stlLoclAmt) {
		this.stlLoclAmt = stlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param slpIssRgnCd
	 */
	public void setSlpIssRgnCd(String slpIssRgnCd) {
		this.slpIssRgnCd = slpIssRgnCd;
	}
	
	/**
	 * Column Info
	 * @param stlVvdSeq
	 */
	public void setStlVvdSeq(String stlVvdSeq) {
		this.stlVvdSeq = stlVvdSeq;
	}
	
	/**
	 * Column Info
	 * @param keyNo
	 */
	public void setKeyNo(String keyNo) {
		this.keyNo = keyNo;
	}
	
	/**
	 * Column Info
	 * @param stlSeq
	 */
	public void setStlSeq(String stlSeq) {
		this.stlSeq = stlSeq;
	}
	
	/**
	 * Column Info
	 * @param drCrCd
	 */
	public void setDrCrCd(String drCrCd) {
		this.drCrCd = drCrCd;
	}
	
	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param issuerNm
	 */
	public void setIssuerNm(String issuerNm) {
		this.issuerNm = issuerNm;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param custVndrCntCd
	 */
	public void setCustVndrCntCd(String custVndrCntCd) {
		this.custVndrCntCd = custVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param slpIssDt
	 */
	public void setSlpIssDt(String slpIssDt) {
		this.slpIssDt = slpIssDt;
	}
	
	/**
	 * Column Info
	 * @param slpOfcCd
	 */
	public void setSlpOfcCd(String slpOfcCd) {
		this.slpOfcCd = slpOfcCd;
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
	 * @param crAcctCd
	 */
	public void setCrAcctCd(String crAcctCd) {
		this.crAcctCd = crAcctCd;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param drCtrCd
	 */
	public void setDrCtrCd(String drCtrCd) {
		this.drCtrCd = drCtrCd;
	}
	
	/**
	 * Column Info
	 * @param slpIssOfcCd
	 */
	public void setSlpIssOfcCd(String slpIssOfcCd) {
		this.slpIssOfcCd = slpIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param csrOffstNo
	 */
	public void setCsrOffstNo(String csrOffstNo) {
		this.csrOffstNo = csrOffstNo;
	}

	/**
	 * Column Info
	 * @param agmtDocNo
	 */
	public void setAgmtDocNo(String agmtDocNo) {
		this.agmtDocNo = agmtDocNo;
	}

	/**
	 * Column Info
	 * @param agmtDocDesc
	 */
	public void setAgmtDocDesc(String agmtDocDesc) {
		this.agmtDocDesc = agmtDocDesc;
	}
	
	/**
	 * Column Info
	 * @param aproFlg
	 */
	public void setAproFlg(String aproFlg) {
		this.aproFlg = aproFlg;
	}
	
	/**
	 * Column Info
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
	}	
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, "slp_func_cd", ""));
		setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
		setFinJoStlItmCd(JSPUtil.getParameter(request, "fin_jo_stl_itm_cd", ""));
		setDrAcctCd(JSPUtil.getParameter(request, "dr_acct_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setSlpDesc(JSPUtil.getParameter(request, "slp_desc", ""));
		setJoStlItmCd(JSPUtil.getParameter(request, "jo_stl_itm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCrLocCd(JSPUtil.getParameter(request, "cr_loc_cd", ""));
		setCustVndrEngNm(JSPUtil.getParameter(request, "cust_vndr_eng_nm", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setArApDivCd(JSPUtil.getParameter(request, "ar_ap_div_cd", ""));
		setTotAmount(JSPUtil.getParameter(request, "tot_amount", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setCsrTpCd(JSPUtil.getParameter(request, "csr_tp_cd", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setSlpIssInterCoCd(JSPUtil.getParameter(request, "slp_iss_inter_co_cd", ""));
		setCustVndrSeq(JSPUtil.getParameter(request, "cust_vndr_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setCustVndrRgstNo(JSPUtil.getParameter(request, "cust_vndr_rgst_no", ""));
		setChkLocCd(JSPUtil.getParameter(request, "chk_loc_cd", ""));
		setCustVndrKorNm(JSPUtil.getParameter(request, "cust_vndr_kor_nm", ""));
		setIssuerId(JSPUtil.getParameter(request, "issuer_id", ""));
		setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
		setBsaSltPrc(JSPUtil.getParameter(request, "bsa_slt_prc", ""));
		setChkCtrCd(JSPUtil.getParameter(request, "chk_ctr_cd", ""));
		setDrLocCd(JSPUtil.getParameter(request, "dr_loc_cd", ""));
		setSlpSerNo(JSPUtil.getParameter(request, "slp_ser_no", ""));
		setStlCmbSeq(JSPUtil.getParameter(request, "stl_cmb_seq", ""));
		setAproStep(JSPUtil.getParameter(request, "apro_step", ""));
		setBsaQty(JSPUtil.getParameter(request, "bsa_qty", ""));
		setCrCtrCd(JSPUtil.getParameter(request, "cr_ctr_cd", ""));
		setEvidTpCd(JSPUtil.getParameter(request, "evid_tp_cd", ""));
		setVvdCxlFlg(JSPUtil.getParameter(request, "vvd_cxl_flg", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setStlLoclAmt(JSPUtil.getParameter(request, "stl_locl_amt", ""));
		setSlpIssRgnCd(JSPUtil.getParameter(request, "slp_iss_rgn_cd", ""));
		setStlVvdSeq(JSPUtil.getParameter(request, "stl_vvd_seq", ""));
		setKeyNo(JSPUtil.getParameter(request, "key_no", ""));
		setStlSeq(JSPUtil.getParameter(request, "stl_seq", ""));
		setDrCrCd(JSPUtil.getParameter(request, "dr_cr_cd", ""));
		setRqstDt(JSPUtil.getParameter(request, "rqst_dt", ""));
		setIssuerNm(JSPUtil.getParameter(request, "issuer_nm", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setCustVndrCntCd(JSPUtil.getParameter(request, "cust_vndr_cnt_cd", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setCrAcctCd(JSPUtil.getParameter(request, "cr_acct_cd", ""));
		setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
		setDrCtrCd(JSPUtil.getParameter(request, "dr_ctr_cd", ""));
		setSlpIssOfcCd(JSPUtil.getParameter(request, "slp_iss_ofc_cd", ""));
		setCsrOffstNo(JSPUtil.getParameter(request, "csr_offst_no", ""));
		setAgmtDocNo(JSPUtil.getParameter(request, "agmt_doc_no", ""));
		setAgmtDocDesc(JSPUtil.getParameter(request, "agmt_doc_desc", ""));
		setAproFlg(JSPUtil.getParameter(request, "apro_flg", ""));
		setCxlFlg(JSPUtil.getParameter(request, "cxl_flg", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SlipProcessVO[]
	 */
	public SlipProcessVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SlipProcessVO[]
	 */
	public SlipProcessVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SlipProcessVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] finJoStlItmCd = (JSPUtil.getParameter(request, prefix	+ "fin_jo_stl_itm_cd", length));
			String[] drAcctCd = (JSPUtil.getParameter(request, prefix	+ "dr_acct_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] slpDesc = (JSPUtil.getParameter(request, prefix	+ "slp_desc", length));
			String[] joStlItmCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] crLocCd = (JSPUtil.getParameter(request, prefix	+ "cr_loc_cd", length));
			String[] custVndrEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_vndr_eng_nm", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] arApDivCd = (JSPUtil.getParameter(request, prefix	+ "ar_ap_div_cd", length));
			String[] totAmount = (JSPUtil.getParameter(request, prefix	+ "tot_amount", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] csrTpCd = (JSPUtil.getParameter(request, prefix	+ "csr_tp_cd", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] slpIssInterCoCd = (JSPUtil.getParameter(request, prefix	+ "slp_iss_inter_co_cd", length));
			String[] custVndrSeq = (JSPUtil.getParameter(request, prefix	+ "cust_vndr_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] custVndrRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_vndr_rgst_no", length));
			String[] chkLocCd = (JSPUtil.getParameter(request, prefix	+ "chk_loc_cd", length));
			String[] custVndrKorNm = (JSPUtil.getParameter(request, prefix	+ "cust_vndr_kor_nm", length));
			String[] issuerId = (JSPUtil.getParameter(request, prefix	+ "issuer_id", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] bsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "bsa_slt_prc", length));
			String[] chkCtrCd = (JSPUtil.getParameter(request, prefix	+ "chk_ctr_cd", length));
			String[] drLocCd = (JSPUtil.getParameter(request, prefix	+ "dr_loc_cd", length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no", length));
			String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix	+ "stl_cmb_seq", length));
			String[] aproStep = (JSPUtil.getParameter(request, prefix	+ "apro_step", length));
			String[] bsaQty = (JSPUtil.getParameter(request, prefix	+ "bsa_qty", length));
			String[] crCtrCd = (JSPUtil.getParameter(request, prefix	+ "cr_ctr_cd", length));
			String[] evidTpCd = (JSPUtil.getParameter(request, prefix	+ "evid_tp_cd", length));
			String[] vvdCxlFlg = (JSPUtil.getParameter(request, prefix	+ "vvd_cxl_flg", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] stlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "stl_locl_amt", length));
			String[] slpIssRgnCd = (JSPUtil.getParameter(request, prefix	+ "slp_iss_rgn_cd", length));
			String[] stlVvdSeq = (JSPUtil.getParameter(request, prefix	+ "stl_vvd_seq", length));
			String[] keyNo = (JSPUtil.getParameter(request, prefix	+ "key_no", length));
			String[] stlSeq = (JSPUtil.getParameter(request, prefix	+ "stl_seq", length));
			String[] drCrCd = (JSPUtil.getParameter(request, prefix	+ "dr_cr_cd", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] issuerNm = (JSPUtil.getParameter(request, prefix	+ "issuer_nm", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] custVndrCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_vndr_cnt_cd", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] crAcctCd = (JSPUtil.getParameter(request, prefix	+ "cr_acct_cd", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] drCtrCd = (JSPUtil.getParameter(request, prefix	+ "dr_ctr_cd", length));
			String[] slpIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_iss_ofc_cd", length));
			String[] csrOffstNo = (JSPUtil.getParameter(request, prefix	+ "csr_offst_no", length));
			String[] agmtDocNo = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_no", length));
			String[] agmtDocDesc = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_desc", length));
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));			
			
			for (int i = 0; i < length; i++) {
				model = new SlipProcessVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (finJoStlItmCd[i] != null)
					model.setFinJoStlItmCd(finJoStlItmCd[i]);
				if (drAcctCd[i] != null)
					model.setDrAcctCd(drAcctCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (slpDesc[i] != null)
					model.setSlpDesc(slpDesc[i]);
				if (joStlItmCd[i] != null)
					model.setJoStlItmCd(joStlItmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (crLocCd[i] != null)
					model.setCrLocCd(crLocCd[i]);
				if (custVndrEngNm[i] != null)
					model.setCustVndrEngNm(custVndrEngNm[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (arApDivCd[i] != null)
					model.setArApDivCd(arApDivCd[i]);
				if (totAmount[i] != null)
					model.setTotAmount(totAmount[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (csrTpCd[i] != null)
					model.setCsrTpCd(csrTpCd[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (slpIssInterCoCd[i] != null)
					model.setSlpIssInterCoCd(slpIssInterCoCd[i]);
				if (custVndrSeq[i] != null)
					model.setCustVndrSeq(custVndrSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (custVndrRgstNo[i] != null)
					model.setCustVndrRgstNo(custVndrRgstNo[i]);
				if (chkLocCd[i] != null)
					model.setChkLocCd(chkLocCd[i]);
				if (custVndrKorNm[i] != null)
					model.setCustVndrKorNm(custVndrKorNm[i]);
				if (issuerId[i] != null)
					model.setIssuerId(issuerId[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (bsaSltPrc[i] != null)
					model.setBsaSltPrc(bsaSltPrc[i]);
				if (chkCtrCd[i] != null)
					model.setChkCtrCd(chkCtrCd[i]);
				if (drLocCd[i] != null)
					model.setDrLocCd(drLocCd[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (stlCmbSeq[i] != null)
					model.setStlCmbSeq(stlCmbSeq[i]);
				if (aproStep[i] != null)
					model.setAproStep(aproStep[i]);
				if (bsaQty[i] != null)
					model.setBsaQty(bsaQty[i]);
				if (crCtrCd[i] != null)
					model.setCrCtrCd(crCtrCd[i]);
				if (evidTpCd[i] != null)
					model.setEvidTpCd(evidTpCd[i]);
				if (vvdCxlFlg[i] != null)
					model.setVvdCxlFlg(vvdCxlFlg[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (stlLoclAmt[i] != null)
					model.setStlLoclAmt(stlLoclAmt[i]);
				if (slpIssRgnCd[i] != null)
					model.setSlpIssRgnCd(slpIssRgnCd[i]);
				if (stlVvdSeq[i] != null)
					model.setStlVvdSeq(stlVvdSeq[i]);
				if (keyNo[i] != null)
					model.setKeyNo(keyNo[i]);
				if (stlSeq[i] != null)
					model.setStlSeq(stlSeq[i]);
				if (drCrCd[i] != null)
					model.setDrCrCd(drCrCd[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (issuerNm[i] != null)
					model.setIssuerNm(issuerNm[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (custVndrCntCd[i] != null)
					model.setCustVndrCntCd(custVndrCntCd[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (crAcctCd[i] != null)
					model.setCrAcctCd(crAcctCd[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (drCtrCd[i] != null)
					model.setDrCtrCd(drCtrCd[i]);
				if (slpIssOfcCd[i] != null)
					model.setSlpIssOfcCd(slpIssOfcCd[i]);
				if (csrOffstNo[i] != null)
					model.setCsrOffstNo(csrOffstNo[i]);
				if (agmtDocNo[i] != null)
					model.setAgmtDocNo(agmtDocNo[i]);
				if (agmtDocDesc[i] != null)
					model.setAgmtDocDesc(agmtDocDesc[i]);
				if (aproFlg[i] != null)
					model.setAproFlg(aproFlg[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSlipProcessVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SlipProcessVO[]
	 */
	public SlipProcessVO[] getSlipProcessVOs(){
		SlipProcessVO[] vos = (SlipProcessVO[])models.toArray(new SlipProcessVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finJoStlItmCd = this.finJoStlItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drAcctCd = this.drAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpDesc = this.slpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCd = this.joStlItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crLocCd = this.crLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custVndrEngNm = this.custVndrEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arApDivCd = this.arApDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmount = this.totAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrTpCd = this.csrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssInterCoCd = this.slpIssInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custVndrSeq = this.custVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custVndrRgstNo = this.custVndrRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkLocCd = this.chkLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custVndrKorNm = this.custVndrKorNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issuerId = this.issuerId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSltPrc = this.bsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCtrCd = this.chkCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drLocCd = this.drLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCmbSeq = this.stlCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproStep = this.aproStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaQty = this.bsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCtrCd = this.crCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evidTpCd = this.evidTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCxlFlg = this.vvdCxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlLoclAmt = this.stlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssRgnCd = this.slpIssRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlVvdSeq = this.stlVvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyNo = this.keyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlSeq = this.stlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drCrCd = this.drCrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issuerNm = this.issuerNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custVndrCntCd = this.custVndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAcctCd = this.crAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drCtrCd = this.drCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssOfcCd = this.slpIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrOffstNo = this.csrOffstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocNo = this.agmtDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocDesc = this.agmtDocDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
