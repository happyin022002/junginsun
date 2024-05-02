/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FmsOwnrAcctSlpVO.java
*@FileTitle : FmsOwnrAcctSlpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.03.07 손진환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.ownersaccount.vo;

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
 * @author 손진환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FmsOwnrAcctSlpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FmsOwnrAcctSlpVO> models = new ArrayList<FmsOwnrAcctSlpVO>();
	
	/* Column Info */
	private String csrSlpFlg = null;
	/* Column Info */
	private String apCxlFlg = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String stlFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String oaStlStsCd = null;
	/* Column Info */
	private String rvsAcctCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String n2ndAmt = null;
	/* Column Info */
	private String n1stAmt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String fletPpayRltCd = null;
	/* Column Info */
	private String n1stCurrCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rvsAcctItmSeq = null;
	/* Column Info */
	private String manHrFlg = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String csulSlpOfcCd = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String apDesc = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String fletRctFlg = null;
	/* Column Info */
	private String csulSlpIssDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String loclXchRtAmt = null;
	/* Column Info */
	private String csulSlpSerNo = null;
	/* Column Info */
	private String n2ndCurrCd = null;
	/* Column Info */
	private String csulSlpFuncCd = null;
	/* Column Info */
	private String csulSlpTpCd = null;
	/* Column Info */
	private String slpSerNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FmsOwnrAcctSlpVO() {}

	public FmsOwnrAcctSlpVO(String ibflag, String pagerows, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo, String slpSeqNo, String fletPpayRltCd, String acctCd, String ctrCd, String effDt, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String n1stCurrCd, String n1stAmt, String n2ndCurrCd, String n2ndAmt, String loclXchRtAmt, String apDesc, String csrSlpFlg, String manHrFlg, String stlFlg, String rvsAcctCd, String rvsAcctItmSeq, String csulSlpTpCd, String csulSlpFuncCd, String csulSlpOfcCd, String csulSlpIssDt, String csulSlpSerNo, String creUsrId, String creDt, String updUsrId, String updDt, String fletRctFlg, String apCxlFlg, String oaStlStsCd) {
		this.csrSlpFlg = csrSlpFlg;
		this.apCxlFlg = apCxlFlg;
		this.vslCd = vslCd;
		this.slpFuncCd = slpFuncCd;
		this.stlFlg = stlFlg;
		this.creDt = creDt;
		this.oaStlStsCd = oaStlStsCd;
		this.rvsAcctCd = rvsAcctCd;
		this.pagerows = pagerows;
		this.revDirCd = revDirCd;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.ctrCd = ctrCd;
		this.n2ndAmt = n2ndAmt;
		this.n1stAmt = n1stAmt;
		this.acctCd = acctCd;
		this.slpTpCd = slpTpCd;
		this.fletPpayRltCd = fletPpayRltCd;
		this.n1stCurrCd = n1stCurrCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.rvsAcctItmSeq = rvsAcctItmSeq;
		this.manHrFlg = manHrFlg;
		this.skdVoyNo = skdVoyNo;
		this.csulSlpOfcCd = csulSlpOfcCd;
		this.slpSeqNo = slpSeqNo;
		this.apDesc = apDesc;
		this.slpIssDt = slpIssDt;
		this.slpOfcCd = slpOfcCd;
		this.skdDirCd = skdDirCd;
		this.fletRctFlg = fletRctFlg;
		this.csulSlpIssDt = csulSlpIssDt;
		this.creUsrId = creUsrId;
		this.loclXchRtAmt = loclXchRtAmt;
		this.csulSlpSerNo = csulSlpSerNo;
		this.n2ndCurrCd = n2ndCurrCd;
		this.csulSlpFuncCd = csulSlpFuncCd;
		this.csulSlpTpCd = csulSlpTpCd;
		this.slpSerNo = slpSerNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_slp_flg", getCsrSlpFlg());
		this.hashColumns.put("ap_cxl_flg", getApCxlFlg());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("stl_flg", getStlFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("oa_stl_sts_cd", getOaStlStsCd());
		this.hashColumns.put("rvs_acct_cd", getRvsAcctCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("n2nd_amt", getN2ndAmt());
		this.hashColumns.put("n1st_amt", getN1stAmt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("flet_ppay_rlt_cd", getFletPpayRltCd());
		this.hashColumns.put("n1st_curr_cd", getN1stCurrCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rvs_acct_itm_seq", getRvsAcctItmSeq());
		this.hashColumns.put("man_hr_flg", getManHrFlg());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("csul_slp_ofc_cd", getCsulSlpOfcCd());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("ap_desc", getApDesc());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("flet_rct_flg", getFletRctFlg());
		this.hashColumns.put("csul_slp_iss_dt", getCsulSlpIssDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("locl_xch_rt_amt", getLoclXchRtAmt());
		this.hashColumns.put("csul_slp_ser_no", getCsulSlpSerNo());
		this.hashColumns.put("n2nd_curr_cd", getN2ndCurrCd());
		this.hashColumns.put("csul_slp_func_cd", getCsulSlpFuncCd());
		this.hashColumns.put("csul_slp_tp_cd", getCsulSlpTpCd());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("csr_slp_flg", "csrSlpFlg");
		this.hashFields.put("ap_cxl_flg", "apCxlFlg");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("stl_flg", "stlFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("oa_stl_sts_cd", "oaStlStsCd");
		this.hashFields.put("rvs_acct_cd", "rvsAcctCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("n2nd_amt", "n2ndAmt");
		this.hashFields.put("n1st_amt", "n1stAmt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("flet_ppay_rlt_cd", "fletPpayRltCd");
		this.hashFields.put("n1st_curr_cd", "n1stCurrCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rvs_acct_itm_seq", "rvsAcctItmSeq");
		this.hashFields.put("man_hr_flg", "manHrFlg");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("csul_slp_ofc_cd", "csulSlpOfcCd");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("ap_desc", "apDesc");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("flet_rct_flg", "fletRctFlg");
		this.hashFields.put("csul_slp_iss_dt", "csulSlpIssDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("locl_xch_rt_amt", "loclXchRtAmt");
		this.hashFields.put("csul_slp_ser_no", "csulSlpSerNo");
		this.hashFields.put("n2nd_curr_cd", "n2ndCurrCd");
		this.hashFields.put("csul_slp_func_cd", "csulSlpFuncCd");
		this.hashFields.put("csul_slp_tp_cd", "csulSlpTpCd");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return csrSlpFlg
	 */
	public String getCsrSlpFlg() {
		return this.csrSlpFlg;
	}
	
	/**
	 * Column Info
	 * @return apCxlFlg
	 */
	public String getApCxlFlg() {
		return this.apCxlFlg;
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
	 * @return stlFlg
	 */
	public String getStlFlg() {
		return this.stlFlg;
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
	 * @return oaStlStsCd
	 */
	public String getOaStlStsCd() {
		return this.oaStlStsCd;
	}
	
	/**
	 * Column Info
	 * @return rvsAcctCd
	 */
	public String getRvsAcctCd() {
		return this.rvsAcctCd;
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
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return this.ctrCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndAmt
	 */
	public String getN2ndAmt() {
		return this.n2ndAmt;
	}
	
	/**
	 * Column Info
	 * @return n1stAmt
	 */
	public String getN1stAmt() {
		return this.n1stAmt;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
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
	 * @return fletPpayRltCd
	 */
	public String getFletPpayRltCd() {
		return this.fletPpayRltCd;
	}
	
	/**
	 * Column Info
	 * @return n1stCurrCd
	 */
	public String getN1stCurrCd() {
		return this.n1stCurrCd;
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
	 * @return rvsAcctItmSeq
	 */
	public String getRvsAcctItmSeq() {
		return this.rvsAcctItmSeq;
	}
	
	/**
	 * Column Info
	 * @return manHrFlg
	 */
	public String getManHrFlg() {
		return this.manHrFlg;
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
	 * @return csulSlpOfcCd
	 */
	public String getCsulSlpOfcCd() {
		return this.csulSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return slpSeqNo
	 */
	public String getSlpSeqNo() {
		return this.slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return apDesc
	 */
	public String getApDesc() {
		return this.apDesc;
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
	 * @return fletRctFlg
	 */
	public String getFletRctFlg() {
		return this.fletRctFlg;
	}
	
	/**
	 * Column Info
	 * @return csulSlpIssDt
	 */
	public String getCsulSlpIssDt() {
		return this.csulSlpIssDt;
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
	 * @return loclXchRtAmt
	 */
	public String getLoclXchRtAmt() {
		return this.loclXchRtAmt;
	}
	
	/**
	 * Column Info
	 * @return csulSlpSerNo
	 */
	public String getCsulSlpSerNo() {
		return this.csulSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @return n2ndCurrCd
	 */
	public String getN2ndCurrCd() {
		return this.n2ndCurrCd;
	}
	
	/**
	 * Column Info
	 * @return csulSlpFuncCd
	 */
	public String getCsulSlpFuncCd() {
		return this.csulSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return csulSlpTpCd
	 */
	public String getCsulSlpTpCd() {
		return this.csulSlpTpCd;
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
	 * @param csrSlpFlg
	 */
	public void setCsrSlpFlg(String csrSlpFlg) {
		this.csrSlpFlg = csrSlpFlg;
	}
	
	/**
	 * Column Info
	 * @param apCxlFlg
	 */
	public void setApCxlFlg(String apCxlFlg) {
		this.apCxlFlg = apCxlFlg;
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
	 * @param stlFlg
	 */
	public void setStlFlg(String stlFlg) {
		this.stlFlg = stlFlg;
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
	 * @param oaStlStsCd
	 */
	public void setOaStlStsCd(String oaStlStsCd) {
		this.oaStlStsCd = oaStlStsCd;
	}
	
	/**
	 * Column Info
	 * @param rvsAcctCd
	 */
	public void setRvsAcctCd(String rvsAcctCd) {
		this.rvsAcctCd = rvsAcctCd;
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
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param ctrCd
	 */
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndAmt
	 */
	public void setN2ndAmt(String n2ndAmt) {
		this.n2ndAmt = n2ndAmt;
	}
	
	/**
	 * Column Info
	 * @param n1stAmt
	 */
	public void setN1stAmt(String n1stAmt) {
		this.n1stAmt = n1stAmt;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
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
	 * @param fletPpayRltCd
	 */
	public void setFletPpayRltCd(String fletPpayRltCd) {
		this.fletPpayRltCd = fletPpayRltCd;
	}
	
	/**
	 * Column Info
	 * @param n1stCurrCd
	 */
	public void setN1stCurrCd(String n1stCurrCd) {
		this.n1stCurrCd = n1stCurrCd;
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
	 * @param rvsAcctItmSeq
	 */
	public void setRvsAcctItmSeq(String rvsAcctItmSeq) {
		this.rvsAcctItmSeq = rvsAcctItmSeq;
	}
	
	/**
	 * Column Info
	 * @param manHrFlg
	 */
	public void setManHrFlg(String manHrFlg) {
		this.manHrFlg = manHrFlg;
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
	 * @param csulSlpOfcCd
	 */
	public void setCsulSlpOfcCd(String csulSlpOfcCd) {
		this.csulSlpOfcCd = csulSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param slpSeqNo
	 */
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param apDesc
	 */
	public void setApDesc(String apDesc) {
		this.apDesc = apDesc;
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
	 * @param fletRctFlg
	 */
	public void setFletRctFlg(String fletRctFlg) {
		this.fletRctFlg = fletRctFlg;
	}
	
	/**
	 * Column Info
	 * @param csulSlpIssDt
	 */
	public void setCsulSlpIssDt(String csulSlpIssDt) {
		this.csulSlpIssDt = csulSlpIssDt;
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
	 * @param loclXchRtAmt
	 */
	public void setLoclXchRtAmt(String loclXchRtAmt) {
		this.loclXchRtAmt = loclXchRtAmt;
	}
	
	/**
	 * Column Info
	 * @param csulSlpSerNo
	 */
	public void setCsulSlpSerNo(String csulSlpSerNo) {
		this.csulSlpSerNo = csulSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @param n2ndCurrCd
	 */
	public void setN2ndCurrCd(String n2ndCurrCd) {
		this.n2ndCurrCd = n2ndCurrCd;
	}
	
	/**
	 * Column Info
	 * @param csulSlpFuncCd
	 */
	public void setCsulSlpFuncCd(String csulSlpFuncCd) {
		this.csulSlpFuncCd = csulSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param csulSlpTpCd
	 */
	public void setCsulSlpTpCd(String csulSlpTpCd) {
		this.csulSlpTpCd = csulSlpTpCd;
	}
	
	/**
	 * Column Info
	 * @param slpSerNo
	 */
	public void setSlpSerNo(String slpSerNo) {
		this.slpSerNo = slpSerNo;
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
		setCsrSlpFlg(JSPUtil.getParameter(request, prefix + "csr_slp_flg", ""));
		setApCxlFlg(JSPUtil.getParameter(request, prefix + "ap_cxl_flg", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, prefix + "slp_func_cd", ""));
		setStlFlg(JSPUtil.getParameter(request, prefix + "stl_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setOaStlStsCd(JSPUtil.getParameter(request, prefix + "oa_stl_sts_cd", ""));
		setRvsAcctCd(JSPUtil.getParameter(request, prefix + "rvs_acct_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrCd(JSPUtil.getParameter(request, prefix + "ctr_cd", ""));
		setN2ndAmt(JSPUtil.getParameter(request, prefix + "n2nd_amt", ""));
		setN1stAmt(JSPUtil.getParameter(request, prefix + "n1st_amt", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setSlpTpCd(JSPUtil.getParameter(request, prefix + "slp_tp_cd", ""));
		setFletPpayRltCd(JSPUtil.getParameter(request, prefix + "flet_ppay_rlt_cd", ""));
		setN1stCurrCd(JSPUtil.getParameter(request, prefix + "n1st_curr_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRvsAcctItmSeq(JSPUtil.getParameter(request, prefix + "rvs_acct_itm_seq", ""));
		setManHrFlg(JSPUtil.getParameter(request, prefix + "man_hr_flg", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCsulSlpOfcCd(JSPUtil.getParameter(request, prefix + "csul_slp_ofc_cd", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, prefix + "slp_seq_no", ""));
		setApDesc(JSPUtil.getParameter(request, prefix + "ap_desc", ""));
		setSlpIssDt(JSPUtil.getParameter(request, prefix + "slp_iss_dt", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, prefix + "slp_ofc_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setFletRctFlg(JSPUtil.getParameter(request, prefix + "flet_rct_flg", ""));
		setCsulSlpIssDt(JSPUtil.getParameter(request, prefix + "csul_slp_iss_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setLoclXchRtAmt(JSPUtil.getParameter(request, prefix + "locl_xch_rt_amt", ""));
		setCsulSlpSerNo(JSPUtil.getParameter(request, prefix + "csul_slp_ser_no", ""));
		setN2ndCurrCd(JSPUtil.getParameter(request, prefix + "n2nd_curr_cd", ""));
		setCsulSlpFuncCd(JSPUtil.getParameter(request, prefix + "csul_slp_func_cd", ""));
		setCsulSlpTpCd(JSPUtil.getParameter(request, prefix + "csul_slp_tp_cd", ""));
		setSlpSerNo(JSPUtil.getParameter(request, prefix + "slp_ser_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FmsOwnrAcctSlpVO[]
	 */
	public FmsOwnrAcctSlpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FmsOwnrAcctSlpVO[]
	 */
	public FmsOwnrAcctSlpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FmsOwnrAcctSlpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] csrSlpFlg = (JSPUtil.getParameter(request, prefix	+ "csr_slp_flg", length));
			String[] apCxlFlg = (JSPUtil.getParameter(request, prefix	+ "ap_cxl_flg", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] stlFlg = (JSPUtil.getParameter(request, prefix	+ "stl_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] oaStlStsCd = (JSPUtil.getParameter(request, prefix	+ "oa_stl_sts_cd", length));
			String[] rvsAcctCd = (JSPUtil.getParameter(request, prefix	+ "rvs_acct_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] n2ndAmt = (JSPUtil.getParameter(request, prefix	+ "n2nd_amt", length));
			String[] n1stAmt = (JSPUtil.getParameter(request, prefix	+ "n1st_amt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] fletPpayRltCd = (JSPUtil.getParameter(request, prefix	+ "flet_ppay_rlt_cd", length));
			String[] n1stCurrCd = (JSPUtil.getParameter(request, prefix	+ "n1st_curr_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rvsAcctItmSeq = (JSPUtil.getParameter(request, prefix	+ "rvs_acct_itm_seq", length));
			String[] manHrFlg = (JSPUtil.getParameter(request, prefix	+ "man_hr_flg", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] csulSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "csul_slp_ofc_cd", length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no", length));
			String[] apDesc = (JSPUtil.getParameter(request, prefix	+ "ap_desc", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] fletRctFlg = (JSPUtil.getParameter(request, prefix	+ "flet_rct_flg", length));
			String[] csulSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "csul_slp_iss_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] loclXchRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_xch_rt_amt", length));
			String[] csulSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "csul_slp_ser_no", length));
			String[] n2ndCurrCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_curr_cd", length));
			String[] csulSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "csul_slp_func_cd", length));
			String[] csulSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "csul_slp_tp_cd", length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new FmsOwnrAcctSlpVO();
				if (csrSlpFlg[i] != null)
					model.setCsrSlpFlg(csrSlpFlg[i]);
				if (apCxlFlg[i] != null)
					model.setApCxlFlg(apCxlFlg[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (stlFlg[i] != null)
					model.setStlFlg(stlFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (oaStlStsCd[i] != null)
					model.setOaStlStsCd(oaStlStsCd[i]);
				if (rvsAcctCd[i] != null)
					model.setRvsAcctCd(rvsAcctCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (n2ndAmt[i] != null)
					model.setN2ndAmt(n2ndAmt[i]);
				if (n1stAmt[i] != null)
					model.setN1stAmt(n1stAmt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (fletPpayRltCd[i] != null)
					model.setFletPpayRltCd(fletPpayRltCd[i]);
				if (n1stCurrCd[i] != null)
					model.setN1stCurrCd(n1stCurrCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rvsAcctItmSeq[i] != null)
					model.setRvsAcctItmSeq(rvsAcctItmSeq[i]);
				if (manHrFlg[i] != null)
					model.setManHrFlg(manHrFlg[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (csulSlpOfcCd[i] != null)
					model.setCsulSlpOfcCd(csulSlpOfcCd[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (apDesc[i] != null)
					model.setApDesc(apDesc[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (fletRctFlg[i] != null)
					model.setFletRctFlg(fletRctFlg[i]);
				if (csulSlpIssDt[i] != null)
					model.setCsulSlpIssDt(csulSlpIssDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (loclXchRtAmt[i] != null)
					model.setLoclXchRtAmt(loclXchRtAmt[i]);
				if (csulSlpSerNo[i] != null)
					model.setCsulSlpSerNo(csulSlpSerNo[i]);
				if (n2ndCurrCd[i] != null)
					model.setN2ndCurrCd(n2ndCurrCd[i]);
				if (csulSlpFuncCd[i] != null)
					model.setCsulSlpFuncCd(csulSlpFuncCd[i]);
				if (csulSlpTpCd[i] != null)
					model.setCsulSlpTpCd(csulSlpTpCd[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFmsOwnrAcctSlpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FmsOwnrAcctSlpVO[]
	 */
	public FmsOwnrAcctSlpVO[] getFmsOwnrAcctSlpVOs(){
		FmsOwnrAcctSlpVO[] vos = (FmsOwnrAcctSlpVO[])models.toArray(new FmsOwnrAcctSlpVO[models.size()]);
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
		this.csrSlpFlg = this.csrSlpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCxlFlg = this.apCxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg = this.stlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaStlStsCd = this.oaStlStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsAcctCd = this.rvsAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndAmt = this.n2ndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAmt = this.n1stAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletPpayRltCd = this.fletPpayRltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCurrCd = this.n1stCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsAcctItmSeq = this.rvsAcctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manHrFlg = this.manHrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csulSlpOfcCd = this.csulSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc = this.apDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletRctFlg = this.fletRctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csulSlpIssDt = this.csulSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclXchRtAmt = this.loclXchRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csulSlpSerNo = this.csulSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndCurrCd = this.n2ndCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csulSlpFuncCd = this.csulSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csulSlpTpCd = this.csulSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
