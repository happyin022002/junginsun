/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CniCgoClmCtrtVO.java
*@FileTitle : CniCgoClmCtrtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.10.23 정행룡 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo;

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
 * @author 정행룡
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CniCgoClmCtrtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CniCgoClmCtrtVO> models = new ArrayList<CniCgoClmCtrtVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String n2ndPstTsDt = null;
	/* Column Info */
	private String trnkRefVvdNo = null;
	/* Column Info */
	private String n3rdPreRefVvdNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String clmOfrtAmt = null;
	/* Column Info */
	private String deDt = null;
	/* Column Info */
	private String n1stPstRefVvdNo = null;
	/* Column Info */
	private String clmCgoTpCd = null;
	/* Column Info */
	private String n1stPreTsLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3rdPreTsDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String crrTermCd = null;
	/* Column Info */
	private String n2ndPstRefVvdNo = null;
	/* Column Info */
	private String n3rdPstTsDt = null;
	/* Column Info */
	private String n1stPstTsDt = null;
	/* Column Info */
	private String n2ndPreTsDt = null;
	/* Column Info */
	private String n3rdPstRefVvdNo = null;
	/* Column Info */
	private String n2ndPreTsLocCd = null;
	/* Column Info */
	private String clmOfrtTermCd = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n3rdRefVvdNo = null;
	/* Column Info */
	private String n1stPreTsDt = null;
	/* Column Info */
	private String n1stPstTsLocCd = null;
	/* Column Info */
	private String dchgDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String clmOfrtFlg = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String n2ndPreRefVvdNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String lodgDt = null;
	/* Column Info */
	private String rctDt = null;
	/* Column Info */
	private String n1stPreRefVvdNo = null;
	/* Column Info */
	private String n3rdPreTsLocCd = null;
	/* Column Info */
	private String n2ndPstTsLocCd = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String n3rdPstTsLocCd = null;
	/* Column Info */
	private String cgoQltyDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CniCgoClmCtrtVO() {}

	public CniCgoClmCtrtVO(String ibflag, String pagerows, String cgoClmNo, String trnkRefVvdNo, String clmCgoTpCd, String shprNm, String cneeNm, String ntfyNm, String cgoQltyDesc, String crrTermCd, String clmOfrtAmt, String clmOfrtTermCd, String clmOfrtFlg, String porCd, String rctDt, String polCd, String lodgDt, String podCd, String dchgDt, String delCd, String deDt, String n1stPreRefVvdNo, String n2ndPreRefVvdNo, String n3rdPreRefVvdNo, String n1stPreTsLocCd, String n1stPreTsDt, String n2ndPreTsLocCd, String n2ndPreTsDt, String n3rdPreTsLocCd, String n3rdPreTsDt, String n1stPstRefVvdNo, String n2ndPstRefVvdNo, String n3rdPstRefVvdNo, String n1stPstTsLocCd, String n1stPstTsDt, String n2ndPstTsLocCd, String n2ndPstTsDt, String n3rdPstTsLocCd, String n3rdPstTsDt, String repCmdtCd, String n3rdRefVvdNo, String slanCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.porCd = porCd;
		this.n2ndPstTsDt = n2ndPstTsDt;
		this.trnkRefVvdNo = trnkRefVvdNo;
		this.n3rdPreRefVvdNo = n3rdPreRefVvdNo;
		this.creDt = creDt;
		this.clmOfrtAmt = clmOfrtAmt;
		this.deDt = deDt;
		this.n1stPstRefVvdNo = n1stPstRefVvdNo;
		this.clmCgoTpCd = clmCgoTpCd;
		this.n1stPreTsLocCd = n1stPreTsLocCd;
		this.pagerows = pagerows;
		this.n3rdPreTsDt = n3rdPreTsDt;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.crrTermCd = crrTermCd;
		this.n2ndPstRefVvdNo = n2ndPstRefVvdNo;
		this.n3rdPstTsDt = n3rdPstTsDt;
		this.n1stPstTsDt = n1stPstTsDt;
		this.n2ndPreTsDt = n2ndPreTsDt;
		this.n3rdPstRefVvdNo = n3rdPstRefVvdNo;
		this.n2ndPreTsLocCd = n2ndPreTsLocCd;
		this.clmOfrtTermCd = clmOfrtTermCd;
		this.cgoClmNo = cgoClmNo;
		this.shprNm = shprNm;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.n3rdRefVvdNo = n3rdRefVvdNo;
		this.n1stPreTsDt = n1stPreTsDt;
		this.n1stPstTsLocCd = n1stPstTsLocCd;
		this.dchgDt = dchgDt;
		this.delCd = delCd;
		this.ntfyNm = ntfyNm;
		this.clmOfrtFlg = clmOfrtFlg;
		this.podCd = podCd;
		this.n2ndPreRefVvdNo = n2ndPreRefVvdNo;
		this.creUsrId = creUsrId;
		this.cneeNm = cneeNm;
		this.slanCd = slanCd;
		this.lodgDt = lodgDt;
		this.rctDt = rctDt;
		this.n1stPreRefVvdNo = n1stPreRefVvdNo;
		this.n3rdPreTsLocCd = n3rdPreTsLocCd;
		this.n2ndPstTsLocCd = n2ndPstTsLocCd;
		this.repCmdtCd = repCmdtCd;
		this.n3rdPstTsLocCd = n3rdPstTsLocCd;
		this.cgoQltyDesc = cgoQltyDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("n2nd_pst_ts_dt", getN2ndPstTsDt());
		this.hashColumns.put("trnk_ref_vvd_no", getTrnkRefVvdNo());
		this.hashColumns.put("n3rd_pre_ref_vvd_no", getN3rdPreRefVvdNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("clm_ofrt_amt", getClmOfrtAmt());
		this.hashColumns.put("de_dt", getDeDt());
		this.hashColumns.put("n1st_pst_ref_vvd_no", getN1stPstRefVvdNo());
		this.hashColumns.put("clm_cgo_tp_cd", getClmCgoTpCd());
		this.hashColumns.put("n1st_pre_ts_loc_cd", getN1stPreTsLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3rd_pre_ts_dt", getN3rdPreTsDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("crr_term_cd", getCrrTermCd());
		this.hashColumns.put("n2nd_pst_ref_vvd_no", getN2ndPstRefVvdNo());
		this.hashColumns.put("n3rd_pst_ts_dt", getN3rdPstTsDt());
		this.hashColumns.put("n1st_pst_ts_dt", getN1stPstTsDt());
		this.hashColumns.put("n2nd_pre_ts_dt", getN2ndPreTsDt());
		this.hashColumns.put("n3rd_pst_ref_vvd_no", getN3rdPstRefVvdNo());
		this.hashColumns.put("n2nd_pre_ts_loc_cd", getN2ndPreTsLocCd());
		this.hashColumns.put("clm_ofrt_term_cd", getClmOfrtTermCd());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n3rd_ref_vvd_no", getN3rdRefVvdNo());
		this.hashColumns.put("n1st_pre_ts_dt", getN1stPreTsDt());
		this.hashColumns.put("n1st_pst_ts_loc_cd", getN1stPstTsLocCd());
		this.hashColumns.put("dchg_dt", getDchgDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("clm_ofrt_flg", getClmOfrtFlg());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("n2nd_pre_ref_vvd_no", getN2ndPreRefVvdNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("lodg_dt", getLodgDt());
		this.hashColumns.put("rct_dt", getRctDt());
		this.hashColumns.put("n1st_pre_ref_vvd_no", getN1stPreRefVvdNo());
		this.hashColumns.put("n3rd_pre_ts_loc_cd", getN3rdPreTsLocCd());
		this.hashColumns.put("n2nd_pst_ts_loc_cd", getN2ndPstTsLocCd());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("n3rd_pst_ts_loc_cd", getN3rdPstTsLocCd());
		this.hashColumns.put("cgo_qlty_desc", getCgoQltyDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("n2nd_pst_ts_dt", "n2ndPstTsDt");
		this.hashFields.put("trnk_ref_vvd_no", "trnkRefVvdNo");
		this.hashFields.put("n3rd_pre_ref_vvd_no", "n3rdPreRefVvdNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("clm_ofrt_amt", "clmOfrtAmt");
		this.hashFields.put("de_dt", "deDt");
		this.hashFields.put("n1st_pst_ref_vvd_no", "n1stPstRefVvdNo");
		this.hashFields.put("clm_cgo_tp_cd", "clmCgoTpCd");
		this.hashFields.put("n1st_pre_ts_loc_cd", "n1stPreTsLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3rd_pre_ts_dt", "n3rdPreTsDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("crr_term_cd", "crrTermCd");
		this.hashFields.put("n2nd_pst_ref_vvd_no", "n2ndPstRefVvdNo");
		this.hashFields.put("n3rd_pst_ts_dt", "n3rdPstTsDt");
		this.hashFields.put("n1st_pst_ts_dt", "n1stPstTsDt");
		this.hashFields.put("n2nd_pre_ts_dt", "n2ndPreTsDt");
		this.hashFields.put("n3rd_pst_ref_vvd_no", "n3rdPstRefVvdNo");
		this.hashFields.put("n2nd_pre_ts_loc_cd", "n2ndPreTsLocCd");
		this.hashFields.put("clm_ofrt_term_cd", "clmOfrtTermCd");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n3rd_ref_vvd_no", "n3rdRefVvdNo");
		this.hashFields.put("n1st_pre_ts_dt", "n1stPreTsDt");
		this.hashFields.put("n1st_pst_ts_loc_cd", "n1stPstTsLocCd");
		this.hashFields.put("dchg_dt", "dchgDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("clm_ofrt_flg", "clmOfrtFlg");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("n2nd_pre_ref_vvd_no", "n2ndPreRefVvdNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("lodg_dt", "lodgDt");
		this.hashFields.put("rct_dt", "rctDt");
		this.hashFields.put("n1st_pre_ref_vvd_no", "n1stPreRefVvdNo");
		this.hashFields.put("n3rd_pre_ts_loc_cd", "n3rdPreTsLocCd");
		this.hashFields.put("n2nd_pst_ts_loc_cd", "n2ndPstTsLocCd");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("n3rd_pst_ts_loc_cd", "n3rdPstTsLocCd");
		this.hashFields.put("cgo_qlty_desc", "cgoQltyDesc");
		return this.hashFields;
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
	 * @return n2ndPstTsDt
	 */
	public String getN2ndPstTsDt() {
		return this.n2ndPstTsDt;
	}
	
	/**
	 * Column Info
	 * @return trnkRefVvdNo
	 */
	public String getTrnkRefVvdNo() {
		return this.trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return n3rdPreRefVvdNo
	 */
	public String getN3rdPreRefVvdNo() {
		return this.n3rdPreRefVvdNo;
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
	 * @return clmOfrtAmt
	 */
	public String getClmOfrtAmt() {
		return this.clmOfrtAmt;
	}
	
	/**
	 * Column Info
	 * @return deDt
	 */
	public String getDeDt() {
		return this.deDt;
	}
	
	/**
	 * Column Info
	 * @return n1stPstRefVvdNo
	 */
	public String getN1stPstRefVvdNo() {
		return this.n1stPstRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return clmCgoTpCd
	 */
	public String getClmCgoTpCd() {
		return this.clmCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return n1stPreTsLocCd
	 */
	public String getN1stPreTsLocCd() {
		return this.n1stPreTsLocCd;
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
	 * @return n3rdPreTsDt
	 */
	public String getN3rdPreTsDt() {
		return this.n3rdPreTsDt;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return crrTermCd
	 */
	public String getCrrTermCd() {
		return this.crrTermCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndPstRefVvdNo
	 */
	public String getN2ndPstRefVvdNo() {
		return this.n2ndPstRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return n3rdPstTsDt
	 */
	public String getN3rdPstTsDt() {
		return this.n3rdPstTsDt;
	}
	
	/**
	 * Column Info
	 * @return n1stPstTsDt
	 */
	public String getN1stPstTsDt() {
		return this.n1stPstTsDt;
	}
	
	/**
	 * Column Info
	 * @return n2ndPreTsDt
	 */
	public String getN2ndPreTsDt() {
		return this.n2ndPreTsDt;
	}
	
	/**
	 * Column Info
	 * @return n3rdPstRefVvdNo
	 */
	public String getN3rdPstRefVvdNo() {
		return this.n3rdPstRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return n2ndPreTsLocCd
	 */
	public String getN2ndPreTsLocCd() {
		return this.n2ndPreTsLocCd;
	}
	
	/**
	 * Column Info
	 * @return clmOfrtTermCd
	 */
	public String getClmOfrtTermCd() {
		return this.clmOfrtTermCd;
	}
	
	/**
	 * Column Info
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
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
	 * @return n3rdRefVvdNo
	 */
	public String getN3rdRefVvdNo() {
		return this.n3rdRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return n1stPreTsDt
	 */
	public String getN1stPreTsDt() {
		return this.n1stPreTsDt;
	}
	
	/**
	 * Column Info
	 * @return n1stPstTsLocCd
	 */
	public String getN1stPstTsLocCd() {
		return this.n1stPstTsLocCd;
	}
	
	/**
	 * Column Info
	 * @return dchgDt
	 */
	public String getDchgDt() {
		return this.dchgDt;
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
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 * Column Info
	 * @return clmOfrtFlg
	 */
	public String getClmOfrtFlg() {
		return this.clmOfrtFlg;
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
	 * @return n2ndPreRefVvdNo
	 */
	public String getN2ndPreRefVvdNo() {
		return this.n2ndPreRefVvdNo;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
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
	 * @return lodgDt
	 */
	public String getLodgDt() {
		return this.lodgDt;
	}
	
	/**
	 * Column Info
	 * @return rctDt
	 */
	public String getRctDt() {
		return this.rctDt;
	}
	
	/**
	 * Column Info
	 * @return n1stPreRefVvdNo
	 */
	public String getN1stPreRefVvdNo() {
		return this.n1stPreRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return n3rdPreTsLocCd
	 */
	public String getN3rdPreTsLocCd() {
		return this.n3rdPreTsLocCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndPstTsLocCd
	 */
	public String getN2ndPstTsLocCd() {
		return this.n2ndPstTsLocCd;
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
	 * @return n3rdPstTsLocCd
	 */
	public String getN3rdPstTsLocCd() {
		return this.n3rdPstTsLocCd;
	}
	
	/**
	 * Column Info
	 * @return cgoQltyDesc
	 */
	public String getCgoQltyDesc() {
		return this.cgoQltyDesc;
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
	 * @param n2ndPstTsDt
	 */
	public void setN2ndPstTsDt(String n2ndPstTsDt) {
		this.n2ndPstTsDt = n2ndPstTsDt;
	}
	
	/**
	 * Column Info
	 * @param trnkRefVvdNo
	 */
	public void setTrnkRefVvdNo(String trnkRefVvdNo) {
		this.trnkRefVvdNo = trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param n3rdPreRefVvdNo
	 */
	public void setN3rdPreRefVvdNo(String n3rdPreRefVvdNo) {
		this.n3rdPreRefVvdNo = n3rdPreRefVvdNo;
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
	 * @param clmOfrtAmt
	 */
	public void setClmOfrtAmt(String clmOfrtAmt) {
		this.clmOfrtAmt = clmOfrtAmt;
	}
	
	/**
	 * Column Info
	 * @param deDt
	 */
	public void setDeDt(String deDt) {
		this.deDt = deDt;
	}
	
	/**
	 * Column Info
	 * @param n1stPstRefVvdNo
	 */
	public void setN1stPstRefVvdNo(String n1stPstRefVvdNo) {
		this.n1stPstRefVvdNo = n1stPstRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param clmCgoTpCd
	 */
	public void setClmCgoTpCd(String clmCgoTpCd) {
		this.clmCgoTpCd = clmCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param n1stPreTsLocCd
	 */
	public void setN1stPreTsLocCd(String n1stPreTsLocCd) {
		this.n1stPreTsLocCd = n1stPreTsLocCd;
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
	 * @param n3rdPreTsDt
	 */
	public void setN3rdPreTsDt(String n3rdPreTsDt) {
		this.n3rdPreTsDt = n3rdPreTsDt;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param crrTermCd
	 */
	public void setCrrTermCd(String crrTermCd) {
		this.crrTermCd = crrTermCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndPstRefVvdNo
	 */
	public void setN2ndPstRefVvdNo(String n2ndPstRefVvdNo) {
		this.n2ndPstRefVvdNo = n2ndPstRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param n3rdPstTsDt
	 */
	public void setN3rdPstTsDt(String n3rdPstTsDt) {
		this.n3rdPstTsDt = n3rdPstTsDt;
	}
	
	/**
	 * Column Info
	 * @param n1stPstTsDt
	 */
	public void setN1stPstTsDt(String n1stPstTsDt) {
		this.n1stPstTsDt = n1stPstTsDt;
	}
	
	/**
	 * Column Info
	 * @param n2ndPreTsDt
	 */
	public void setN2ndPreTsDt(String n2ndPreTsDt) {
		this.n2ndPreTsDt = n2ndPreTsDt;
	}
	
	/**
	 * Column Info
	 * @param n3rdPstRefVvdNo
	 */
	public void setN3rdPstRefVvdNo(String n3rdPstRefVvdNo) {
		this.n3rdPstRefVvdNo = n3rdPstRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param n2ndPreTsLocCd
	 */
	public void setN2ndPreTsLocCd(String n2ndPreTsLocCd) {
		this.n2ndPreTsLocCd = n2ndPreTsLocCd;
	}
	
	/**
	 * Column Info
	 * @param clmOfrtTermCd
	 */
	public void setClmOfrtTermCd(String clmOfrtTermCd) {
		this.clmOfrtTermCd = clmOfrtTermCd;
	}
	
	/**
	 * Column Info
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
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
	 * @param n3rdRefVvdNo
	 */
	public void setN3rdRefVvdNo(String n3rdRefVvdNo) {
		this.n3rdRefVvdNo = n3rdRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param n1stPreTsDt
	 */
	public void setN1stPreTsDt(String n1stPreTsDt) {
		this.n1stPreTsDt = n1stPreTsDt;
	}
	
	/**
	 * Column Info
	 * @param n1stPstTsLocCd
	 */
	public void setN1stPstTsLocCd(String n1stPstTsLocCd) {
		this.n1stPstTsLocCd = n1stPstTsLocCd;
	}
	
	/**
	 * Column Info
	 * @param dchgDt
	 */
	public void setDchgDt(String dchgDt) {
		this.dchgDt = dchgDt;
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
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * Column Info
	 * @param clmOfrtFlg
	 */
	public void setClmOfrtFlg(String clmOfrtFlg) {
		this.clmOfrtFlg = clmOfrtFlg;
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
	 * @param n2ndPreRefVvdNo
	 */
	public void setN2ndPreRefVvdNo(String n2ndPreRefVvdNo) {
		this.n2ndPreRefVvdNo = n2ndPreRefVvdNo;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
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
	 * @param lodgDt
	 */
	public void setLodgDt(String lodgDt) {
		this.lodgDt = lodgDt;
	}
	
	/**
	 * Column Info
	 * @param rctDt
	 */
	public void setRctDt(String rctDt) {
		this.rctDt = rctDt;
	}
	
	/**
	 * Column Info
	 * @param n1stPreRefVvdNo
	 */
	public void setN1stPreRefVvdNo(String n1stPreRefVvdNo) {
		this.n1stPreRefVvdNo = n1stPreRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param n3rdPreTsLocCd
	 */
	public void setN3rdPreTsLocCd(String n3rdPreTsLocCd) {
		this.n3rdPreTsLocCd = n3rdPreTsLocCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndPstTsLocCd
	 */
	public void setN2ndPstTsLocCd(String n2ndPstTsLocCd) {
		this.n2ndPstTsLocCd = n2ndPstTsLocCd;
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
	 * @param n3rdPstTsLocCd
	 */
	public void setN3rdPstTsLocCd(String n3rdPstTsLocCd) {
		this.n3rdPstTsLocCd = n3rdPstTsLocCd;
	}
	
	/**
	 * Column Info
	 * @param cgoQltyDesc
	 */
	public void setCgoQltyDesc(String cgoQltyDesc) {
		this.cgoQltyDesc = cgoQltyDesc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setN2ndPstTsDt(JSPUtil.getParameter(request, "n2nd_pst_ts_dt", ""));
		setTrnkRefVvdNo(JSPUtil.getParameter(request, "trnk_ref_vvd_no", ""));
		setN3rdPreRefVvdNo(JSPUtil.getParameter(request, "n3rd_pre_ref_vvd_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setClmOfrtAmt(JSPUtil.getParameter(request, "clm_ofrt_amt", ""));
		setDeDt(JSPUtil.getParameter(request, "de_dt", ""));
		setN1stPstRefVvdNo(JSPUtil.getParameter(request, "n1st_pst_ref_vvd_no", ""));
		setClmCgoTpCd(JSPUtil.getParameter(request, "clm_cgo_tp_cd", ""));
		setN1stPreTsLocCd(JSPUtil.getParameter(request, "n1st_pre_ts_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setN3rdPreTsDt(JSPUtil.getParameter(request, "n3rd_pre_ts_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCrrTermCd(JSPUtil.getParameter(request, "crr_term_cd", ""));
		setN2ndPstRefVvdNo(JSPUtil.getParameter(request, "n2nd_pst_ref_vvd_no", ""));
		setN3rdPstTsDt(JSPUtil.getParameter(request, "n3rd_pst_ts_dt", ""));
		setN1stPstTsDt(JSPUtil.getParameter(request, "n1st_pst_ts_dt", ""));
		setN2ndPreTsDt(JSPUtil.getParameter(request, "n2nd_pre_ts_dt", ""));
		setN3rdPstRefVvdNo(JSPUtil.getParameter(request, "n3rd_pst_ref_vvd_no", ""));
		setN2ndPreTsLocCd(JSPUtil.getParameter(request, "n2nd_pre_ts_loc_cd", ""));
		setClmOfrtTermCd(JSPUtil.getParameter(request, "clm_ofrt_term_cd", ""));
		setCgoClmNo(JSPUtil.getParameter(request, "cgo_clm_no", ""));
		setShprNm(JSPUtil.getParameter(request, "shpr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setN3rdRefVvdNo(JSPUtil.getParameter(request, "n3rd_ref_vvd_no", ""));
		setN1stPreTsDt(JSPUtil.getParameter(request, "n1st_pre_ts_dt", ""));
		setN1stPstTsLocCd(JSPUtil.getParameter(request, "n1st_pst_ts_loc_cd", ""));
		setDchgDt(JSPUtil.getParameter(request, "dchg_dt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setNtfyNm(JSPUtil.getParameter(request, "ntfy_nm", ""));
		setClmOfrtFlg(JSPUtil.getParameter(request, "clm_ofrt_flg", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setN2ndPreRefVvdNo(JSPUtil.getParameter(request, "n2nd_pre_ref_vvd_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCneeNm(JSPUtil.getParameter(request, "cnee_nm", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setLodgDt(JSPUtil.getParameter(request, "lodg_dt", ""));
		setRctDt(JSPUtil.getParameter(request, "rct_dt", ""));
		setN1stPreRefVvdNo(JSPUtil.getParameter(request, "n1st_pre_ref_vvd_no", ""));
		setN3rdPreTsLocCd(JSPUtil.getParameter(request, "n3rd_pre_ts_loc_cd", ""));
		setN2ndPstTsLocCd(JSPUtil.getParameter(request, "n2nd_pst_ts_loc_cd", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
		setN3rdPstTsLocCd(JSPUtil.getParameter(request, "n3rd_pst_ts_loc_cd", ""));
		setCgoQltyDesc(JSPUtil.getParameter(request, "cgo_qlty_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CniCgoClmCtrtVO[]
	 */
	public CniCgoClmCtrtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CniCgoClmCtrtVO[]
	 */
	public CniCgoClmCtrtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CniCgoClmCtrtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] n2ndPstTsDt = (JSPUtil.getParameter(request, prefix	+ "n2nd_pst_ts_dt", length));
			String[] trnkRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "trnk_ref_vvd_no", length));
			String[] n3rdPreRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n3rd_pre_ref_vvd_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] clmOfrtAmt = (JSPUtil.getParameter(request, prefix	+ "clm_ofrt_amt", length));
			String[] deDt = (JSPUtil.getParameter(request, prefix	+ "de_dt", length));
			String[] n1stPstRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n1st_pst_ref_vvd_no", length));
			String[] clmCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "clm_cgo_tp_cd", length));
			String[] n1stPreTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pre_ts_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3rdPreTsDt = (JSPUtil.getParameter(request, prefix	+ "n3rd_pre_ts_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] crrTermCd = (JSPUtil.getParameter(request, prefix	+ "crr_term_cd", length));
			String[] n2ndPstRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n2nd_pst_ref_vvd_no", length));
			String[] n3rdPstTsDt = (JSPUtil.getParameter(request, prefix	+ "n3rd_pst_ts_dt", length));
			String[] n1stPstTsDt = (JSPUtil.getParameter(request, prefix	+ "n1st_pst_ts_dt", length));
			String[] n2ndPreTsDt = (JSPUtil.getParameter(request, prefix	+ "n2nd_pre_ts_dt", length));
			String[] n3rdPstRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n3rd_pst_ref_vvd_no", length));
			String[] n2ndPreTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pre_ts_loc_cd", length));
			String[] clmOfrtTermCd = (JSPUtil.getParameter(request, prefix	+ "clm_ofrt_term_cd", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n3rdRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n3rd_ref_vvd_no", length));
			String[] n1stPreTsDt = (JSPUtil.getParameter(request, prefix	+ "n1st_pre_ts_dt", length));
			String[] n1stPstTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pst_ts_loc_cd", length));
			String[] dchgDt = (JSPUtil.getParameter(request, prefix	+ "dchg_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] clmOfrtFlg = (JSPUtil.getParameter(request, prefix	+ "clm_ofrt_flg", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] n2ndPreRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n2nd_pre_ref_vvd_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] lodgDt = (JSPUtil.getParameter(request, prefix	+ "lodg_dt", length));
			String[] rctDt = (JSPUtil.getParameter(request, prefix	+ "rct_dt", length));
			String[] n1stPreRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n1st_pre_ref_vvd_no", length));
			String[] n3rdPreTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pre_ts_loc_cd", length));
			String[] n2ndPstTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pst_ts_loc_cd", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] n3rdPstTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pst_ts_loc_cd", length));
			String[] cgoQltyDesc = (JSPUtil.getParameter(request, prefix	+ "cgo_qlty_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new CniCgoClmCtrtVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (n2ndPstTsDt[i] != null)
					model.setN2ndPstTsDt(n2ndPstTsDt[i]);
				if (trnkRefVvdNo[i] != null)
					model.setTrnkRefVvdNo(trnkRefVvdNo[i]);
				if (n3rdPreRefVvdNo[i] != null)
					model.setN3rdPreRefVvdNo(n3rdPreRefVvdNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (clmOfrtAmt[i] != null)
					model.setClmOfrtAmt(clmOfrtAmt[i]);
				if (deDt[i] != null)
					model.setDeDt(deDt[i]);
				if (n1stPstRefVvdNo[i] != null)
					model.setN1stPstRefVvdNo(n1stPstRefVvdNo[i]);
				if (clmCgoTpCd[i] != null)
					model.setClmCgoTpCd(clmCgoTpCd[i]);
				if (n1stPreTsLocCd[i] != null)
					model.setN1stPreTsLocCd(n1stPreTsLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3rdPreTsDt[i] != null)
					model.setN3rdPreTsDt(n3rdPreTsDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (crrTermCd[i] != null)
					model.setCrrTermCd(crrTermCd[i]);
				if (n2ndPstRefVvdNo[i] != null)
					model.setN2ndPstRefVvdNo(n2ndPstRefVvdNo[i]);
				if (n3rdPstTsDt[i] != null)
					model.setN3rdPstTsDt(n3rdPstTsDt[i]);
				if (n1stPstTsDt[i] != null)
					model.setN1stPstTsDt(n1stPstTsDt[i]);
				if (n2ndPreTsDt[i] != null)
					model.setN2ndPreTsDt(n2ndPreTsDt[i]);
				if (n3rdPstRefVvdNo[i] != null)
					model.setN3rdPstRefVvdNo(n3rdPstRefVvdNo[i]);
				if (n2ndPreTsLocCd[i] != null)
					model.setN2ndPreTsLocCd(n2ndPreTsLocCd[i]);
				if (clmOfrtTermCd[i] != null)
					model.setClmOfrtTermCd(clmOfrtTermCd[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n3rdRefVvdNo[i] != null)
					model.setN3rdRefVvdNo(n3rdRefVvdNo[i]);
				if (n1stPreTsDt[i] != null)
					model.setN1stPreTsDt(n1stPreTsDt[i]);
				if (n1stPstTsLocCd[i] != null)
					model.setN1stPstTsLocCd(n1stPstTsLocCd[i]);
				if (dchgDt[i] != null)
					model.setDchgDt(dchgDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (clmOfrtFlg[i] != null)
					model.setClmOfrtFlg(clmOfrtFlg[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (n2ndPreRefVvdNo[i] != null)
					model.setN2ndPreRefVvdNo(n2ndPreRefVvdNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (lodgDt[i] != null)
					model.setLodgDt(lodgDt[i]);
				if (rctDt[i] != null)
					model.setRctDt(rctDt[i]);
				if (n1stPreRefVvdNo[i] != null)
					model.setN1stPreRefVvdNo(n1stPreRefVvdNo[i]);
				if (n3rdPreTsLocCd[i] != null)
					model.setN3rdPreTsLocCd(n3rdPreTsLocCd[i]);
				if (n2ndPstTsLocCd[i] != null)
					model.setN2ndPstTsLocCd(n2ndPstTsLocCd[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (n3rdPstTsLocCd[i] != null)
					model.setN3rdPstTsLocCd(n3rdPstTsLocCd[i]);
				if (cgoQltyDesc[i] != null)
					model.setCgoQltyDesc(cgoQltyDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCniCgoClmCtrtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CniCgoClmCtrtVO[]
	 */
	public CniCgoClmCtrtVO[] getCniCgoClmCtrtVOs(){
		CniCgoClmCtrtVO[] vos = (CniCgoClmCtrtVO[])models.toArray(new CniCgoClmCtrtVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPstTsDt = this.n2ndPstTsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkRefVvdNo = this.trnkRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPreRefVvdNo = this.n3rdPreRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmOfrtAmt = this.clmOfrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deDt = this.deDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPstRefVvdNo = this.n1stPstRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCgoTpCd = this.clmCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPreTsLocCd = this.n1stPreTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPreTsDt = this.n3rdPreTsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrTermCd = this.crrTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPstRefVvdNo = this.n2ndPstRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPstTsDt = this.n3rdPstTsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPstTsDt = this.n1stPstTsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPreTsDt = this.n2ndPreTsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPstRefVvdNo = this.n3rdPstRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPreTsLocCd = this.n2ndPreTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmOfrtTermCd = this.clmOfrtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdRefVvdNo = this.n3rdRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPreTsDt = this.n1stPreTsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPstTsLocCd = this.n1stPstTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgDt = this.dchgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmOfrtFlg = this.clmOfrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPreRefVvdNo = this.n2ndPreRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodgDt = this.lodgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDt = this.rctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPreRefVvdNo = this.n1stPreRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPreTsLocCd = this.n3rdPreTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPstTsLocCd = this.n2ndPstTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPstTsLocCd = this.n3rdPstTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoQltyDesc = this.cgoQltyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
