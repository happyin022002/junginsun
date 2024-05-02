/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FmsCsulSlpVO.java
*@FileTitle : FmsCsulSlpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.22
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.02.22 손진환 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
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

public class FmsCsulSlpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FmsCsulSlpVO> models = new ArrayList<FmsCsulSlpVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String orgSlpSeqNo = null;
	/* Column Info */
	private String fletSrcTpCd = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String stlFlg = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdEffDt = null;
	/* Column Info */
	private String orgSlpSerNo = null;
	/* Column Info */
	private String apSlpTpCd = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String oaInvDt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String orgSlpTpCd = null;
	/* Column Info */
	private String apSlpSerNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String oaLocCd = null;
	/* Column Info */
	private String apSlpOfcCd = null;
	/* Column Info */
	private String apSlpSeqNo = null;
	/* Column Info */
	private String acctItmSeq = null;
	/* Column Info */
	private String lsgGrNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Column Info */
	private String slpLocCd = null;
	/* Column Info */
	private String orgSlpFuncCd = null;
	/* Column Info */
	private String trnsCurrCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String orgIssDt = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String pairSlpFuncCd = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String pairSlpIssDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String slpKeyNo = null;
	/* Column Info */
	private String vatFlg = null;
	/* Column Info */
	private String apSlpIssDt = null;
	/* Column Info */
	private String trnsAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String apSlpFuncCd = null;
	/* Column Info */
	private String vvdExpDt = null;
	/* Column Info */
	private String pairSlpSerNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String atchFileOaLnkId = null;
	/* Column Info */
	private String pairSlpSeqNo = null;
	/* Column Info */
	private String orgSlpOfcCd = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String toInvNo = null;
	/* Column Info */
	private String pairSlpOfcCd = null;
	/* Column Info */
	private String pairSlpTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FmsCsulSlpVO() {}

	public FmsCsulSlpVO(String ibflag, String pagerows, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo, String slpSeqNo, String acctCd, String ctrCd, String slpLocCd, String csrCurrCd, String csrAmt, String csrDesc, String vndrSeq, String custCntCd, String custSeq, String trnsCurrCd, String trnsAmt, String vatFlg, String stlFlg, String invSeq, String fletSrcTpCd, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String orgSlpTpCd, String orgSlpFuncCd, String orgSlpOfcCd, String orgIssDt, String orgSlpSerNo, String orgSlpSeqNo, String lsgGrNo, String toInvNo, String apSlpTpCd, String apSlpFuncCd, String apSlpOfcCd, String apSlpIssDt, String apSlpSerNo, String apSlpSeqNo, String slpKeyNo, String vvdEffDt, String vvdExpDt, String creUsrId, String creDt, String updUsrId, String updDt, String acctItmSeq, String oaLocCd, String oaInvDt, String atchFileOaLnkId, String pairSlpTpCd, String pairSlpFuncCd, String pairSlpOfcCd, String pairSlpIssDt, String pairSlpSerNo, String pairSlpSeqNo) {
		this.vslCd = vslCd;
		this.orgSlpSeqNo = orgSlpSeqNo;
		this.fletSrcTpCd = fletSrcTpCd;
		this.slpFuncCd = slpFuncCd;
		this.stlFlg = stlFlg;
		this.csrDesc = csrDesc;
		this.csrCurrCd = csrCurrCd;
		this.pagerows = pagerows;
		this.vvdEffDt = vvdEffDt;
		this.orgSlpSerNo = orgSlpSerNo;
		this.apSlpTpCd = apSlpTpCd;
		this.slpTpCd = slpTpCd;
		this.oaInvDt = oaInvDt;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.orgSlpTpCd = orgSlpTpCd;
		this.apSlpSerNo = apSlpSerNo;
		this.skdVoyNo = skdVoyNo;
		this.slpSeqNo = slpSeqNo;
		this.oaLocCd = oaLocCd;
		this.apSlpOfcCd = apSlpOfcCd;
		this.apSlpSeqNo = apSlpSeqNo;
		this.acctItmSeq = acctItmSeq;
		this.lsgGrNo = lsgGrNo;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.slpSerNo = slpSerNo;
		this.slpLocCd = slpLocCd;
		this.orgSlpFuncCd = orgSlpFuncCd;
		this.trnsCurrCd = trnsCurrCd;
		this.creDt = creDt;
		this.orgIssDt = orgIssDt;
		this.invSeq = invSeq;
		this.pairSlpFuncCd = pairSlpFuncCd;
		this.revDirCd = revDirCd;
		this.pairSlpIssDt = pairSlpIssDt;
		this.ibflag = ibflag;
		this.ctrCd = ctrCd;
		this.acctCd = acctCd;
		this.slpKeyNo = slpKeyNo;
		this.vatFlg = vatFlg;
		this.apSlpIssDt = apSlpIssDt;
		this.trnsAmt = trnsAmt;
		this.updDt = updDt;
		this.apSlpFuncCd = apSlpFuncCd;
		this.vvdExpDt = vvdExpDt;
		this.pairSlpSerNo = pairSlpSerNo;
		this.custSeq = custSeq;
		this.slpOfcCd = slpOfcCd;
		this.slpIssDt = slpIssDt;
		this.skdDirCd = skdDirCd;
		this.atchFileOaLnkId = atchFileOaLnkId;
		this.pairSlpSeqNo = pairSlpSeqNo;
		this.orgSlpOfcCd = orgSlpOfcCd;
		this.csrAmt = csrAmt;
		this.toInvNo = toInvNo;
		this.pairSlpOfcCd = pairSlpOfcCd;
		this.pairSlpTpCd = pairSlpTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("org_slp_seq_no", getOrgSlpSeqNo());
		this.hashColumns.put("flet_src_tp_cd", getFletSrcTpCd());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("stl_flg", getStlFlg());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_eff_dt", getVvdEffDt());
		this.hashColumns.put("org_slp_ser_no", getOrgSlpSerNo());
		this.hashColumns.put("ap_slp_tp_cd", getApSlpTpCd());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("oa_inv_dt", getOaInvDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("org_slp_tp_cd", getOrgSlpTpCd());
		this.hashColumns.put("ap_slp_ser_no", getApSlpSerNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("oa_loc_cd", getOaLocCd());
		this.hashColumns.put("ap_slp_ofc_cd", getApSlpOfcCd());
		this.hashColumns.put("ap_slp_seq_no", getApSlpSeqNo());
		this.hashColumns.put("acct_itm_seq", getAcctItmSeq());
		this.hashColumns.put("lsg_gr_no", getLsgGrNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		this.hashColumns.put("org_slp_func_cd", getOrgSlpFuncCd());
		this.hashColumns.put("trns_curr_cd", getTrnsCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("org_iss_dt", getOrgIssDt());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("pair_slp_func_cd", getPairSlpFuncCd());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("pair_slp_iss_dt", getPairSlpIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("slp_key_no", getSlpKeyNo());
		this.hashColumns.put("vat_flg", getVatFlg());
		this.hashColumns.put("ap_slp_iss_dt", getApSlpIssDt());
		this.hashColumns.put("trns_amt", getTrnsAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ap_slp_func_cd", getApSlpFuncCd());
		this.hashColumns.put("vvd_exp_dt", getVvdExpDt());
		this.hashColumns.put("pair_slp_ser_no", getPairSlpSerNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("atch_file_oa_lnk_id", getAtchFileOaLnkId());
		this.hashColumns.put("pair_slp_seq_no", getPairSlpSeqNo());
		this.hashColumns.put("org_slp_ofc_cd", getOrgSlpOfcCd());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("to_inv_no", getToInvNo());
		this.hashColumns.put("pair_slp_ofc_cd", getPairSlpOfcCd());
		this.hashColumns.put("pair_slp_tp_cd", getPairSlpTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("org_slp_seq_no", "orgSlpSeqNo");
		this.hashFields.put("flet_src_tp_cd", "fletSrcTpCd");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("stl_flg", "stlFlg");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_eff_dt", "vvdEffDt");
		this.hashFields.put("org_slp_ser_no", "orgSlpSerNo");
		this.hashFields.put("ap_slp_tp_cd", "apSlpTpCd");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("oa_inv_dt", "oaInvDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("org_slp_tp_cd", "orgSlpTpCd");
		this.hashFields.put("ap_slp_ser_no", "apSlpSerNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("oa_loc_cd", "oaLocCd");
		this.hashFields.put("ap_slp_ofc_cd", "apSlpOfcCd");
		this.hashFields.put("ap_slp_seq_no", "apSlpSeqNo");
		this.hashFields.put("acct_itm_seq", "acctItmSeq");
		this.hashFields.put("lsg_gr_no", "lsgGrNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
		this.hashFields.put("org_slp_func_cd", "orgSlpFuncCd");
		this.hashFields.put("trns_curr_cd", "trnsCurrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("org_iss_dt", "orgIssDt");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("pair_slp_func_cd", "pairSlpFuncCd");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("pair_slp_iss_dt", "pairSlpIssDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("slp_key_no", "slpKeyNo");
		this.hashFields.put("vat_flg", "vatFlg");
		this.hashFields.put("ap_slp_iss_dt", "apSlpIssDt");
		this.hashFields.put("trns_amt", "trnsAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ap_slp_func_cd", "apSlpFuncCd");
		this.hashFields.put("vvd_exp_dt", "vvdExpDt");
		this.hashFields.put("pair_slp_ser_no", "pairSlpSerNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("atch_file_oa_lnk_id", "atchFileOaLnkId");
		this.hashFields.put("pair_slp_seq_no", "pairSlpSeqNo");
		this.hashFields.put("org_slp_ofc_cd", "orgSlpOfcCd");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("to_inv_no", "toInvNo");
		this.hashFields.put("pair_slp_ofc_cd", "pairSlpOfcCd");
		this.hashFields.put("pair_slp_tp_cd", "pairSlpTpCd");
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
	 * @return orgSlpSeqNo
	 */
	public String getOrgSlpSeqNo() {
		return this.orgSlpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return fletSrcTpCd
	 */
	public String getFletSrcTpCd() {
		return this.fletSrcTpCd;
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
	 * @return csrDesc
	 */
	public String getCsrDesc() {
		return this.csrDesc;
	}
	
	/**
	 * Column Info
	 * @return csrCurrCd
	 */
	public String getCsrCurrCd() {
		return this.csrCurrCd;
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
	 * @return vvdEffDt
	 */
	public String getVvdEffDt() {
		return this.vvdEffDt;
	}
	
	/**
	 * Column Info
	 * @return orgSlpSerNo
	 */
	public String getOrgSlpSerNo() {
		return this.orgSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @return apSlpTpCd
	 */
	public String getApSlpTpCd() {
		return this.apSlpTpCd;
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
	 * @return oaInvDt
	 */
	public String getOaInvDt() {
		return this.oaInvDt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return orgSlpTpCd
	 */
	public String getOrgSlpTpCd() {
		return this.orgSlpTpCd;
	}
	
	/**
	 * Column Info
	 * @return apSlpSerNo
	 */
	public String getApSlpSerNo() {
		return this.apSlpSerNo;
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
	 * @return slpSeqNo
	 */
	public String getSlpSeqNo() {
		return this.slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return oaLocCd
	 */
	public String getOaLocCd() {
		return this.oaLocCd;
	}
	
	/**
	 * Column Info
	 * @return apSlpOfcCd
	 */
	public String getApSlpOfcCd() {
		return this.apSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return apSlpSeqNo
	 */
	public String getApSlpSeqNo() {
		return this.apSlpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return acctItmSeq
	 */
	public String getAcctItmSeq() {
		return this.acctItmSeq;
	}
	
	/**
	 * Column Info
	 * @return lsgGrNo
	 */
	public String getLsgGrNo() {
		return this.lsgGrNo;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return slpLocCd
	 */
	public String getSlpLocCd() {
		return this.slpLocCd;
	}
	
	/**
	 * Column Info
	 * @return orgSlpFuncCd
	 */
	public String getOrgSlpFuncCd() {
		return this.orgSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return trnsCurrCd
	 */
	public String getTrnsCurrCd() {
		return this.trnsCurrCd;
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
	 * @return orgIssDt
	 */
	public String getOrgIssDt() {
		return this.orgIssDt;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return pairSlpFuncCd
	 */
	public String getPairSlpFuncCd() {
		return this.pairSlpFuncCd;
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
	 * @return pairSlpIssDt
	 */
	public String getPairSlpIssDt() {
		return this.pairSlpIssDt;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return slpKeyNo
	 */
	public String getSlpKeyNo() {
		return this.slpKeyNo;
	}
	
	/**
	 * Column Info
	 * @return vatFlg
	 */
	public String getVatFlg() {
		return this.vatFlg;
	}
	
	/**
	 * Column Info
	 * @return apSlpIssDt
	 */
	public String getApSlpIssDt() {
		return this.apSlpIssDt;
	}
	
	/**
	 * Column Info
	 * @return trnsAmt
	 */
	public String getTrnsAmt() {
		return this.trnsAmt;
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
	 * @return apSlpFuncCd
	 */
	public String getApSlpFuncCd() {
		return this.apSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return vvdExpDt
	 */
	public String getVvdExpDt() {
		return this.vvdExpDt;
	}
	
	/**
	 * Column Info
	 * @return pairSlpSerNo
	 */
	public String getPairSlpSerNo() {
		return this.pairSlpSerNo;
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
	 * @return slpOfcCd
	 */
	public String getSlpOfcCd() {
		return this.slpOfcCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return atchFileOaLnkId
	 */
	public String getAtchFileOaLnkId() {
		return this.atchFileOaLnkId;
	}
	
	/**
	 * Column Info
	 * @return pairSlpSeqNo
	 */
	public String getPairSlpSeqNo() {
		return this.pairSlpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return orgSlpOfcCd
	 */
	public String getOrgSlpOfcCd() {
		return this.orgSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return csrAmt
	 */
	public String getCsrAmt() {
		return this.csrAmt;
	}
	
	/**
	 * Column Info
	 * @return toInvNo
	 */
	public String getToInvNo() {
		return this.toInvNo;
	}
	
	/**
	 * Column Info
	 * @return pairSlpOfcCd
	 */
	public String getPairSlpOfcCd() {
		return this.pairSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return pairSlpTpCd
	 */
	public String getPairSlpTpCd() {
		return this.pairSlpTpCd;
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
	 * @param orgSlpSeqNo
	 */
	public void setOrgSlpSeqNo(String orgSlpSeqNo) {
		this.orgSlpSeqNo = orgSlpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param fletSrcTpCd
	 */
	public void setFletSrcTpCd(String fletSrcTpCd) {
		this.fletSrcTpCd = fletSrcTpCd;
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
	 * @param csrDesc
	 */
	public void setCsrDesc(String csrDesc) {
		this.csrDesc = csrDesc;
	}
	
	/**
	 * Column Info
	 * @param csrCurrCd
	 */
	public void setCsrCurrCd(String csrCurrCd) {
		this.csrCurrCd = csrCurrCd;
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
	 * @param vvdEffDt
	 */
	public void setVvdEffDt(String vvdEffDt) {
		this.vvdEffDt = vvdEffDt;
	}
	
	/**
	 * Column Info
	 * @param orgSlpSerNo
	 */
	public void setOrgSlpSerNo(String orgSlpSerNo) {
		this.orgSlpSerNo = orgSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @param apSlpTpCd
	 */
	public void setApSlpTpCd(String apSlpTpCd) {
		this.apSlpTpCd = apSlpTpCd;
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
	 * @param oaInvDt
	 */
	public void setOaInvDt(String oaInvDt) {
		this.oaInvDt = oaInvDt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param orgSlpTpCd
	 */
	public void setOrgSlpTpCd(String orgSlpTpCd) {
		this.orgSlpTpCd = orgSlpTpCd;
	}
	
	/**
	 * Column Info
	 * @param apSlpSerNo
	 */
	public void setApSlpSerNo(String apSlpSerNo) {
		this.apSlpSerNo = apSlpSerNo;
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
	 * @param slpSeqNo
	 */
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param oaLocCd
	 */
	public void setOaLocCd(String oaLocCd) {
		this.oaLocCd = oaLocCd;
	}
	
	/**
	 * Column Info
	 * @param apSlpOfcCd
	 */
	public void setApSlpOfcCd(String apSlpOfcCd) {
		this.apSlpOfcCd = apSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param apSlpSeqNo
	 */
	public void setApSlpSeqNo(String apSlpSeqNo) {
		this.apSlpSeqNo = apSlpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param acctItmSeq
	 */
	public void setAcctItmSeq(String acctItmSeq) {
		this.acctItmSeq = acctItmSeq;
	}
	
	/**
	 * Column Info
	 * @param lsgGrNo
	 */
	public void setLsgGrNo(String lsgGrNo) {
		this.lsgGrNo = lsgGrNo;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param slpLocCd
	 */
	public void setSlpLocCd(String slpLocCd) {
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * Column Info
	 * @param orgSlpFuncCd
	 */
	public void setOrgSlpFuncCd(String orgSlpFuncCd) {
		this.orgSlpFuncCd = orgSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param trnsCurrCd
	 */
	public void setTrnsCurrCd(String trnsCurrCd) {
		this.trnsCurrCd = trnsCurrCd;
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
	 * @param orgIssDt
	 */
	public void setOrgIssDt(String orgIssDt) {
		this.orgIssDt = orgIssDt;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param pairSlpFuncCd
	 */
	public void setPairSlpFuncCd(String pairSlpFuncCd) {
		this.pairSlpFuncCd = pairSlpFuncCd;
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
	 * @param pairSlpIssDt
	 */
	public void setPairSlpIssDt(String pairSlpIssDt) {
		this.pairSlpIssDt = pairSlpIssDt;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param slpKeyNo
	 */
	public void setSlpKeyNo(String slpKeyNo) {
		this.slpKeyNo = slpKeyNo;
	}
	
	/**
	 * Column Info
	 * @param vatFlg
	 */
	public void setVatFlg(String vatFlg) {
		this.vatFlg = vatFlg;
	}
	
	/**
	 * Column Info
	 * @param apSlpIssDt
	 */
	public void setApSlpIssDt(String apSlpIssDt) {
		this.apSlpIssDt = apSlpIssDt;
	}
	
	/**
	 * Column Info
	 * @param trnsAmt
	 */
	public void setTrnsAmt(String trnsAmt) {
		this.trnsAmt = trnsAmt;
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
	 * @param apSlpFuncCd
	 */
	public void setApSlpFuncCd(String apSlpFuncCd) {
		this.apSlpFuncCd = apSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param vvdExpDt
	 */
	public void setVvdExpDt(String vvdExpDt) {
		this.vvdExpDt = vvdExpDt;
	}
	
	/**
	 * Column Info
	 * @param pairSlpSerNo
	 */
	public void setPairSlpSerNo(String pairSlpSerNo) {
		this.pairSlpSerNo = pairSlpSerNo;
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
	 * @param slpOfcCd
	 */
	public void setSlpOfcCd(String slpOfcCd) {
		this.slpOfcCd = slpOfcCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param atchFileOaLnkId
	 */
	public void setAtchFileOaLnkId(String atchFileOaLnkId) {
		this.atchFileOaLnkId = atchFileOaLnkId;
	}
	
	/**
	 * Column Info
	 * @param pairSlpSeqNo
	 */
	public void setPairSlpSeqNo(String pairSlpSeqNo) {
		this.pairSlpSeqNo = pairSlpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param orgSlpOfcCd
	 */
	public void setOrgSlpOfcCd(String orgSlpOfcCd) {
		this.orgSlpOfcCd = orgSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param csrAmt
	 */
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
	}
	
	/**
	 * Column Info
	 * @param toInvNo
	 */
	public void setToInvNo(String toInvNo) {
		this.toInvNo = toInvNo;
	}
	
	/**
	 * Column Info
	 * @param pairSlpOfcCd
	 */
	public void setPairSlpOfcCd(String pairSlpOfcCd) {
		this.pairSlpOfcCd = pairSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param pairSlpTpCd
	 */
	public void setPairSlpTpCd(String pairSlpTpCd) {
		this.pairSlpTpCd = pairSlpTpCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setOrgSlpSeqNo(JSPUtil.getParameter(request, prefix + "org_slp_seq_no", ""));
		setFletSrcTpCd(JSPUtil.getParameter(request, prefix + "flet_src_tp_cd", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, prefix + "slp_func_cd", ""));
		setStlFlg(JSPUtil.getParameter(request, prefix + "stl_flg", ""));
		setCsrDesc(JSPUtil.getParameter(request, prefix + "csr_desc", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, prefix + "csr_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvdEffDt(JSPUtil.getParameter(request, prefix + "vvd_eff_dt", ""));
		setOrgSlpSerNo(JSPUtil.getParameter(request, prefix + "org_slp_ser_no", ""));
		setApSlpTpCd(JSPUtil.getParameter(request, prefix + "ap_slp_tp_cd", ""));
		setSlpTpCd(JSPUtil.getParameter(request, prefix + "slp_tp_cd", ""));
		setOaInvDt(JSPUtil.getParameter(request, prefix + "oa_inv_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOrgSlpTpCd(JSPUtil.getParameter(request, prefix + "org_slp_tp_cd", ""));
		setApSlpSerNo(JSPUtil.getParameter(request, prefix + "ap_slp_ser_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, prefix + "slp_seq_no", ""));
		setOaLocCd(JSPUtil.getParameter(request, prefix + "oa_loc_cd", ""));
		setApSlpOfcCd(JSPUtil.getParameter(request, prefix + "ap_slp_ofc_cd", ""));
		setApSlpSeqNo(JSPUtil.getParameter(request, prefix + "ap_slp_seq_no", ""));
		setAcctItmSeq(JSPUtil.getParameter(request, prefix + "acct_itm_seq", ""));
		setLsgGrNo(JSPUtil.getParameter(request, prefix + "lsg_gr_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setSlpSerNo(JSPUtil.getParameter(request, prefix + "slp_ser_no", ""));
		setSlpLocCd(JSPUtil.getParameter(request, prefix + "slp_loc_cd", ""));
		setOrgSlpFuncCd(JSPUtil.getParameter(request, prefix + "org_slp_func_cd", ""));
		setTrnsCurrCd(JSPUtil.getParameter(request, prefix + "trns_curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setOrgIssDt(JSPUtil.getParameter(request, prefix + "org_iss_dt", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setPairSlpFuncCd(JSPUtil.getParameter(request, prefix + "pair_slp_func_cd", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setPairSlpIssDt(JSPUtil.getParameter(request, prefix + "pair_slp_iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrCd(JSPUtil.getParameter(request, prefix + "ctr_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setSlpKeyNo(JSPUtil.getParameter(request, prefix + "slp_key_no", ""));
		setVatFlg(JSPUtil.getParameter(request, prefix + "vat_flg", ""));
		setApSlpIssDt(JSPUtil.getParameter(request, prefix + "ap_slp_iss_dt", ""));
		setTrnsAmt(JSPUtil.getParameter(request, prefix + "trns_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setApSlpFuncCd(JSPUtil.getParameter(request, prefix + "ap_slp_func_cd", ""));
		setVvdExpDt(JSPUtil.getParameter(request, prefix + "vvd_exp_dt", ""));
		setPairSlpSerNo(JSPUtil.getParameter(request, prefix + "pair_slp_ser_no", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, prefix + "slp_ofc_cd", ""));
		setSlpIssDt(JSPUtil.getParameter(request, prefix + "slp_iss_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setAtchFileOaLnkId(JSPUtil.getParameter(request, prefix + "atch_file_oa_lnk_id", ""));
		setPairSlpSeqNo(JSPUtil.getParameter(request, prefix + "pair_slp_seq_no", ""));
		setOrgSlpOfcCd(JSPUtil.getParameter(request, prefix + "org_slp_ofc_cd", ""));
		setCsrAmt(JSPUtil.getParameter(request, prefix + "csr_amt", ""));
		setToInvNo(JSPUtil.getParameter(request, prefix + "to_inv_no", ""));
		setPairSlpOfcCd(JSPUtil.getParameter(request, prefix + "pair_slp_ofc_cd", ""));
		setPairSlpTpCd(JSPUtil.getParameter(request, prefix + "pair_slp_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FmsCsulSlpVO[]
	 */
	public FmsCsulSlpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FmsCsulSlpVO[]
	 */
	public FmsCsulSlpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FmsCsulSlpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] orgSlpSeqNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_seq_no", length));
			String[] fletSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_src_tp_cd", length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] stlFlg = (JSPUtil.getParameter(request, prefix	+ "stl_flg", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdEffDt = (JSPUtil.getParameter(request, prefix	+ "vvd_eff_dt", length));
			String[] orgSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_ser_no", length));
			String[] apSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "ap_slp_tp_cd", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] oaInvDt = (JSPUtil.getParameter(request, prefix	+ "oa_inv_dt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] orgSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_tp_cd", length));
			String[] apSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "ap_slp_ser_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no", length));
			String[] oaLocCd = (JSPUtil.getParameter(request, prefix	+ "oa_loc_cd", length));
			String[] apSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_slp_ofc_cd", length));
			String[] apSlpSeqNo = (JSPUtil.getParameter(request, prefix	+ "ap_slp_seq_no", length));
			String[] acctItmSeq = (JSPUtil.getParameter(request, prefix	+ "acct_itm_seq", length));
			String[] lsgGrNo = (JSPUtil.getParameter(request, prefix	+ "lsg_gr_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			String[] orgSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_func_cd", length));
			String[] trnsCurrCd = (JSPUtil.getParameter(request, prefix	+ "trns_curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] orgIssDt = (JSPUtil.getParameter(request, prefix	+ "org_iss_dt", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] pairSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "pair_slp_func_cd", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] pairSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "pair_slp_iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] slpKeyNo = (JSPUtil.getParameter(request, prefix	+ "slp_key_no", length));
			String[] vatFlg = (JSPUtil.getParameter(request, prefix	+ "vat_flg", length));
			String[] apSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "ap_slp_iss_dt", length));
			String[] trnsAmt = (JSPUtil.getParameter(request, prefix	+ "trns_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] apSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "ap_slp_func_cd", length));
			String[] vvdExpDt = (JSPUtil.getParameter(request, prefix	+ "vvd_exp_dt", length));
			String[] pairSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "pair_slp_ser_no", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] atchFileOaLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_oa_lnk_id", length));
			String[] pairSlpSeqNo = (JSPUtil.getParameter(request, prefix	+ "pair_slp_seq_no", length));
			String[] orgSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_ofc_cd", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] toInvNo = (JSPUtil.getParameter(request, prefix	+ "to_inv_no", length));
			String[] pairSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "pair_slp_ofc_cd", length));
			String[] pairSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "pair_slp_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new FmsCsulSlpVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (orgSlpSeqNo[i] != null)
					model.setOrgSlpSeqNo(orgSlpSeqNo[i]);
				if (fletSrcTpCd[i] != null)
					model.setFletSrcTpCd(fletSrcTpCd[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (stlFlg[i] != null)
					model.setStlFlg(stlFlg[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdEffDt[i] != null)
					model.setVvdEffDt(vvdEffDt[i]);
				if (orgSlpSerNo[i] != null)
					model.setOrgSlpSerNo(orgSlpSerNo[i]);
				if (apSlpTpCd[i] != null)
					model.setApSlpTpCd(apSlpTpCd[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (oaInvDt[i] != null)
					model.setOaInvDt(oaInvDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (orgSlpTpCd[i] != null)
					model.setOrgSlpTpCd(orgSlpTpCd[i]);
				if (apSlpSerNo[i] != null)
					model.setApSlpSerNo(apSlpSerNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (oaLocCd[i] != null)
					model.setOaLocCd(oaLocCd[i]);
				if (apSlpOfcCd[i] != null)
					model.setApSlpOfcCd(apSlpOfcCd[i]);
				if (apSlpSeqNo[i] != null)
					model.setApSlpSeqNo(apSlpSeqNo[i]);
				if (acctItmSeq[i] != null)
					model.setAcctItmSeq(acctItmSeq[i]);
				if (lsgGrNo[i] != null)
					model.setLsgGrNo(lsgGrNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				if (orgSlpFuncCd[i] != null)
					model.setOrgSlpFuncCd(orgSlpFuncCd[i]);
				if (trnsCurrCd[i] != null)
					model.setTrnsCurrCd(trnsCurrCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (orgIssDt[i] != null)
					model.setOrgIssDt(orgIssDt[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (pairSlpFuncCd[i] != null)
					model.setPairSlpFuncCd(pairSlpFuncCd[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (pairSlpIssDt[i] != null)
					model.setPairSlpIssDt(pairSlpIssDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (slpKeyNo[i] != null)
					model.setSlpKeyNo(slpKeyNo[i]);
				if (vatFlg[i] != null)
					model.setVatFlg(vatFlg[i]);
				if (apSlpIssDt[i] != null)
					model.setApSlpIssDt(apSlpIssDt[i]);
				if (trnsAmt[i] != null)
					model.setTrnsAmt(trnsAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (apSlpFuncCd[i] != null)
					model.setApSlpFuncCd(apSlpFuncCd[i]);
				if (vvdExpDt[i] != null)
					model.setVvdExpDt(vvdExpDt[i]);
				if (pairSlpSerNo[i] != null)
					model.setPairSlpSerNo(pairSlpSerNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (atchFileOaLnkId[i] != null)
					model.setAtchFileOaLnkId(atchFileOaLnkId[i]);
				if (pairSlpSeqNo[i] != null)
					model.setPairSlpSeqNo(pairSlpSeqNo[i]);
				if (orgSlpOfcCd[i] != null)
					model.setOrgSlpOfcCd(orgSlpOfcCd[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (toInvNo[i] != null)
					model.setToInvNo(toInvNo[i]);
				if (pairSlpOfcCd[i] != null)
					model.setPairSlpOfcCd(pairSlpOfcCd[i]);
				if (pairSlpTpCd[i] != null)
					model.setPairSlpTpCd(pairSlpTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFmsCsulSlpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FmsCsulSlpVO[]
	 */
	public FmsCsulSlpVO[] getFmsCsulSlpVOs(){
		FmsCsulSlpVO[] vos = (FmsCsulSlpVO[])models.toArray(new FmsCsulSlpVO[models.size()]);
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
		this.orgSlpSeqNo = this.orgSlpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletSrcTpCd = this.fletSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg = this.stlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdEffDt = this.vvdEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpSerNo = this.orgSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpTpCd = this.apSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaInvDt = this.oaInvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpTpCd = this.orgSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpSerNo = this.apSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaLocCd = this.oaLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpOfcCd = this.apSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpSeqNo = this.apSlpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmSeq = this.acctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsgGrNo = this.lsgGrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpFuncCd = this.orgSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsCurrCd = this.trnsCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgIssDt = this.orgIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairSlpFuncCd = this.pairSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairSlpIssDt = this.pairSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpKeyNo = this.slpKeyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatFlg = this.vatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpIssDt = this.apSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsAmt = this.trnsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpFuncCd = this.apSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdExpDt = this.vvdExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairSlpSerNo = this.pairSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileOaLnkId = this.atchFileOaLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairSlpSeqNo = this.pairSlpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpOfcCd = this.orgSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo = this.toInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairSlpOfcCd = this.pairSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairSlpTpCd = this.pairSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
