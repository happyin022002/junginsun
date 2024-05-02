/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchOffhireExpensesListVO.java
*@FileTitle : SearchOffhireExpensesListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.20
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.03.20 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOffhireExpensesListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOffhireExpensesListVO> models = new ArrayList<SearchOffhireExpensesListVO>();
	
	/* Column Info */
	private String atchFileFletLnkId = null;
	/* Column Info */
	private String atchFileFletLnk = null;	
	/* Column Info */
	private String vnorOffhTpCd = null;
	/* Column Info */
	private String vnorOffhKndCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vnorItmSeq = null;
	/* Column Info */
	private String vnorItmUtCd = null;
	/* Column Info */
	private String vnorOffhToDtHm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String fletIssTpCd = null;
	/* Column Info */
	private String vnorItmVal = null;
	/* Column Info */
	private String crChkFlg = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vnorItmRsltCd = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String vnorOffhFmDt = null;
	/* Column Info */
	private String vnorOffhToDt = null;
	/* Column Info */
	private String vnorItmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String atchFileOpKnt = null;
	/* Column Info */
	private String vnorItmProcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vnorItmFletAddCd = null;
	/* Column Info */
	private String vnorFmPortCd = null;
	/* Column Info */
	private String vnorMnItmFlg = null;
	/* Column Info */
	private String vnorVslStsCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vnorItmOfcCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String atchFileFletKnt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vnorToPortCd = null;
	/* Column Info */
	private String vnorSeq = null;
	/* Column Info */
	private String invDtlSeq = null;
	/* Column Info */
	private String vnorItmRmk = null;
	/* Column Info */
	private String vnorOffhFmDtHm = null;
	/* Column Info */
	private String atchFileOpLnkId = null;
	/* Column Info */
	private String atchFileOpLnk = null;	
	/* Column Info */
	private String vnorOffhInd = null;
	/* Column Info */
	private String vnorItmFletRmk = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchOffhireExpensesListVO() {}

	public SearchOffhireExpensesListVO(String ibflag, String pagerows, String vslCd, String vnorSeq, String vnorOffhFmDt, String vnorOffhToDt, String crChkFlg, String skdVoyNo, String skdDirCd, String vnorOffhKndCd, String vnorOffhTpCd, String vnorVslStsCd, String vnorFmPortCd, String vnorToPortCd, String creUsrId, String creDt, String updUsrId, String updDt, String vnorItmSeq, String vnorMnItmFlg, String vnorItmCd, String vnorItmOfcCd, String vnorItmUtCd, String vnorItmVal, String vnorItmRmk, String atchFileOpLnkId, String atchFileOpLnk, String atchFileOpKnt, String atchFileFletLnkId, String atchFileFletKnt, String vnorItmFletAddCd, String vnorItmProcCd, String vnorItmRsltCd, String fletCtrtNo, String fletIssTpCd, String invSeq, String invDtlSeq, String vvd, String vnorOffhFmDtHm, String vnorOffhToDtHm, String vnorOffhInd, String atchFileFletLnk, String vnorItmFletRmk) {
		this.atchFileFletLnkId = atchFileFletLnkId;
		this.atchFileFletLnk = atchFileFletLnk;		
		this.vnorOffhTpCd = vnorOffhTpCd;
		this.vnorOffhKndCd = vnorOffhKndCd;
		this.vslCd = vslCd;
		this.vnorItmSeq = vnorItmSeq;
		this.vnorItmUtCd = vnorItmUtCd;
		this.vnorOffhToDtHm = vnorOffhToDtHm;
		this.creDt = creDt;
		this.invSeq = invSeq;
		this.fletIssTpCd = fletIssTpCd;
		this.vnorItmVal = vnorItmVal;
		this.crChkFlg = crChkFlg;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
		this.vnorItmRsltCd = vnorItmRsltCd;
		this.ibflag = ibflag;
		this.vnorOffhFmDt = vnorOffhFmDt;
		this.vnorOffhToDt = vnorOffhToDt;
		this.vnorItmCd = vnorItmCd;
		this.updUsrId = updUsrId;
		this.atchFileOpKnt = atchFileOpKnt;
		this.vnorItmProcCd = vnorItmProcCd;
		this.updDt = updDt;
		this.vnorItmFletAddCd = vnorItmFletAddCd;
		this.vnorFmPortCd = vnorFmPortCd;
		this.vnorMnItmFlg = vnorMnItmFlg;
		this.vnorVslStsCd = vnorVslStsCd;
		this.skdVoyNo = skdVoyNo;
		this.vnorItmOfcCd = vnorItmOfcCd;
		this.skdDirCd = skdDirCd;
		this.atchFileFletKnt = atchFileFletKnt;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.vnorToPortCd = vnorToPortCd;
		this.vnorSeq = vnorSeq;
		this.invDtlSeq = invDtlSeq;
		this.vnorItmRmk = vnorItmRmk;
		this.vnorOffhFmDtHm = vnorOffhFmDtHm;
		this.atchFileOpLnkId = atchFileOpLnkId;
		this.atchFileOpLnk = atchFileOpLnk;		
		this.vnorOffhInd = vnorOffhInd;		
		this.vnorItmFletRmk = vnorItmFletRmk;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("atch_file_flet_lnk_id", getAtchFileFletLnkId());
		this.hashColumns.put("atch_file_flet_lnk", getAtchFileFletLnk());				
		this.hashColumns.put("vnor_offh_tp_cd", getVnorOffhTpCd());
		this.hashColumns.put("vnor_offh_knd_cd", getVnorOffhKndCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vnor_itm_seq", getVnorItmSeq());
		this.hashColumns.put("vnor_itm_ut_cd", getVnorItmUtCd());
		this.hashColumns.put("vnor_offh_to_dt_hm", getVnorOffhToDtHm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("flet_iss_tp_cd", getFletIssTpCd());
		this.hashColumns.put("vnor_itm_val", getVnorItmVal());
		this.hashColumns.put("cr_chk_flg", getCrChkFlg());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vnor_itm_rslt_cd", getVnorItmRsltCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vnor_offh_fm_dt", getVnorOffhFmDt());
		this.hashColumns.put("vnor_offh_to_dt", getVnorOffhToDt());
		this.hashColumns.put("vnor_itm_cd", getVnorItmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("atch_file_op_knt", getAtchFileOpKnt());
		this.hashColumns.put("vnor_itm_proc_cd", getVnorItmProcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vnor_itm_flet_add_cd", getVnorItmFletAddCd());
		this.hashColumns.put("vnor_fm_port_cd", getVnorFmPortCd());
		this.hashColumns.put("vnor_mn_itm_flg", getVnorMnItmFlg());
		this.hashColumns.put("vnor_vsl_sts_cd", getVnorVslStsCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vnor_itm_ofc_cd", getVnorItmOfcCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("atch_file_flet_knt", getAtchFileFletKnt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vnor_to_port_cd", getVnorToPortCd());
		this.hashColumns.put("vnor_seq", getVnorSeq());
		this.hashColumns.put("inv_dtl_seq", getInvDtlSeq());
		this.hashColumns.put("vnor_itm_rmk", getVnorItmRmk());
		this.hashColumns.put("vnor_offh_fm_dt_hm", getVnorOffhFmDtHm());
		this.hashColumns.put("atch_file_op_lnk_id", getAtchFileOpLnkId());
		this.hashColumns.put("atch_file_op_lnk", getAtchFileOpLnk());		
		this.hashColumns.put("vnor_offh_ind", getVnorOffhInd());
		this.hashColumns.put("vnor_itm_flet_rmk", getVnorItmFletRmk());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("atch_file_flet_lnk_id", "atchFileFletLnkId");
		this.hashFields.put("atch_file_flet_lnk", "atchFileFletLnk");		
		this.hashFields.put("vnor_offh_tp_cd", "vnorOffhTpCd");
		this.hashFields.put("vnor_offh_knd_cd", "vnorOffhKndCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vnor_itm_seq", "vnorItmSeq");
		this.hashFields.put("vnor_itm_ut_cd", "vnorItmUtCd");
		this.hashFields.put("vnor_offh_to_dt_hm", "vnorOffhToDtHm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("flet_iss_tp_cd", "fletIssTpCd");
		this.hashFields.put("vnor_itm_val", "vnorItmVal");
		this.hashFields.put("cr_chk_flg", "crChkFlg");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vnor_itm_rslt_cd", "vnorItmRsltCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vnor_offh_fm_dt", "vnorOffhFmDt");
		this.hashFields.put("vnor_offh_to_dt", "vnorOffhToDt");
		this.hashFields.put("vnor_itm_cd", "vnorItmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("atch_file_op_knt", "atchFileOpKnt");
		this.hashFields.put("vnor_itm_proc_cd", "vnorItmProcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vnor_itm_flet_add_cd", "vnorItmFletAddCd");
		this.hashFields.put("vnor_fm_port_cd", "vnorFmPortCd");
		this.hashFields.put("vnor_mn_itm_flg", "vnorMnItmFlg");
		this.hashFields.put("vnor_vsl_sts_cd", "vnorVslStsCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vnor_itm_ofc_cd", "vnorItmOfcCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("atch_file_flet_knt", "atchFileFletKnt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vnor_to_port_cd", "vnorToPortCd");
		this.hashFields.put("vnor_seq", "vnorSeq");
		this.hashFields.put("inv_dtl_seq", "invDtlSeq");
		this.hashFields.put("vnor_itm_rmk", "vnorItmRmk");
		this.hashFields.put("vnor_offh_fm_dt_hm", "vnorOffhFmDtHm");
		this.hashFields.put("atch_file_op_lnk_id", "atchFileOpLnkId");
		this.hashFields.put("atch_file_op_lnk", "atchFileOpLnk");		
		this.hashFields.put("vnor_offh_ind", "vnorOffhInd");
		this.hashFields.put("vnor_itm_flet_rmk", "vnorItmFletRmk");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return atchFileFletLnkId
	 */
	public String getAtchFileFletLnkId() {
		return this.atchFileFletLnkId;
	}
	
	/**
	 * Column Info
	 * @return atchFileFletLnk
	 */
	public String getAtchFileFletLnk() {
		return this.atchFileFletLnk;
	}	
	
	/**
	 * Column Info
	 * @return vnorOffhTpCd
	 */
	public String getVnorOffhTpCd() {
		return this.vnorOffhTpCd;
	}
	
	/**
	 * Column Info
	 * @return vnorOffhKndCd
	 */
	public String getVnorOffhKndCd() {
		return this.vnorOffhKndCd;
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
	 * @return vnorItmSeq
	 */
	public String getVnorItmSeq() {
		return this.vnorItmSeq;
	}
	
	/**
	 * Column Info
	 * @return vnorItmUtCd
	 */
	public String getVnorItmUtCd() {
		return this.vnorItmUtCd;
	}
	
	/**
	 * Column Info
	 * @return vnorOffhToDtHm
	 */
	public String getVnorOffhToDtHm() {
		return this.vnorOffhToDtHm;
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
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return fletIssTpCd
	 */
	public String getFletIssTpCd() {
		return this.fletIssTpCd;
	}
	
	/**
	 * Column Info
	 * @return vnorItmVal
	 */
	public String getVnorItmVal() {
		return this.vnorItmVal;
	}
	
	/**
	 * Column Info
	 * @return crChkFlg
	 */
	public String getCrChkFlg() {
		return this.crChkFlg;
	}
	
	/**
	 * Column Info
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
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
	 * @return vnorItmRsltCd
	 */
	public String getVnorItmRsltCd() {
		return this.vnorItmRsltCd;
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
	 * @return vnorOffhFmDt
	 */
	public String getVnorOffhFmDt() {
		return this.vnorOffhFmDt;
	}
	
	/**
	 * Column Info
	 * @return vnorOffhToDt
	 */
	public String getVnorOffhToDt() {
		return this.vnorOffhToDt;
	}
	
	/**
	 * Column Info
	 * @return vnorItmCd
	 */
	public String getVnorItmCd() {
		return this.vnorItmCd;
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
	 * @return atchFileOpKnt
	 */
	public String getAtchFileOpKnt() {
		return this.atchFileOpKnt;
	}
	
	/**
	 * Column Info
	 * @return vnorItmProcCd
	 */
	public String getVnorItmProcCd() {
		return this.vnorItmProcCd;
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
	 * @return vnorItmFletAddCd
	 */
	public String getVnorItmFletAddCd() {
		return this.vnorItmFletAddCd;
	}
	
	/**
	 * Column Info
	 * @return vnorFmPortCd
	 */
	public String getVnorFmPortCd() {
		return this.vnorFmPortCd;
	}
	
	/**
	 * Column Info
	 * @return vnorMnItmFlg
	 */
	public String getVnorMnItmFlg() {
		return this.vnorMnItmFlg;
	}
	
	/**
	 * Column Info
	 * @return vnorVslStsCd
	 */
	public String getVnorVslStsCd() {
		return this.vnorVslStsCd;
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
	 * @return vnorItmOfcCd
	 */
	public String getVnorItmOfcCd() {
		return this.vnorItmOfcCd;
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
	 * @return atchFileFletKnt
	 */
	public String getAtchFileFletKnt() {
		return this.atchFileFletKnt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return vnorToPortCd
	 */
	public String getVnorToPortCd() {
		return this.vnorToPortCd;
	}
	
	/**
	 * Column Info
	 * @return vnorSeq
	 */
	public String getVnorSeq() {
		return this.vnorSeq;
	}
	
	/**
	 * Column Info
	 * @return invDtlSeq
	 */
	public String getInvDtlSeq() {
		return this.invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return vnorItmRmk
	 */
	public String getVnorItmRmk() {
		return this.vnorItmRmk;
	}
	
	/**
	 * Column Info
	 * @return vnorOffhFmDtHm
	 */
	public String getVnorOffhFmDtHm() {
		return this.vnorOffhFmDtHm;
	}
	
	/**
	 * Column Info
	 * @return atchFileOpLnkId
	 */
	public String getAtchFileOpLnkId() {
		return this.atchFileOpLnkId;
	}
	
	/**
	 * Column Info
	 * @return atchFileOpLnk
	 */
	public String getAtchFileOpLnk() {
		return this.atchFileOpLnk;
	}	
	
	/**
	 * Column Info
	 * @return vnorOffhInd
	 */
	public String getVnorOffhInd() {
		return this.vnorOffhInd;
	}
	
	/**
	 * Column Info
	 * @return vnorItmFletRmk
	 */
	public String getVnorItmFletRmk() {
		return vnorItmFletRmk;
	}

	/**
	 * Column Info
	 * @param atchFileFletLnkId
	 */
	public void setAtchFileFletLnkId(String atchFileFletLnkId) {
		this.atchFileFletLnkId = atchFileFletLnkId;
	}

	/**
	 * Column Info
	 * @param atchFileFletLnk
	 */
	public void setAtchFileFletLnk(String atchFileFletLnk) {
		this.atchFileFletLnk = atchFileFletLnk;
	}
	
	/**
	 * Column Info
	 * @param vnorOffhTpCd
	 */
	public void setVnorOffhTpCd(String vnorOffhTpCd) {
		this.vnorOffhTpCd = vnorOffhTpCd;
	}
	
	/**
	 * Column Info
	 * @param vnorOffhKndCd
	 */
	public void setVnorOffhKndCd(String vnorOffhKndCd) {
		this.vnorOffhKndCd = vnorOffhKndCd;
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
	 * @param vnorItmSeq
	 */
	public void setVnorItmSeq(String vnorItmSeq) {
		this.vnorItmSeq = vnorItmSeq;
	}
	
	/**
	 * Column Info
	 * @param vnorItmUtCd
	 */
	public void setVnorItmUtCd(String vnorItmUtCd) {
		this.vnorItmUtCd = vnorItmUtCd;
	}
	
	/**
	 * Column Info
	 * @param vnorOffhToDtHm
	 */
	public void setVnorOffhToDtHm(String vnorOffhToDtHm) {
		this.vnorOffhToDtHm = vnorOffhToDtHm;
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
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param fletIssTpCd
	 */
	public void setFletIssTpCd(String fletIssTpCd) {
		this.fletIssTpCd = fletIssTpCd;
	}
	
	/**
	 * Column Info
	 * @param vnorItmVal
	 */
	public void setVnorItmVal(String vnorItmVal) {
		this.vnorItmVal = vnorItmVal;
	}
	
	/**
	 * Column Info
	 * @param crChkFlg
	 */
	public void setCrChkFlg(String crChkFlg) {
		this.crChkFlg = crChkFlg;
	}
	
	/**
	 * Column Info
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
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
	 * @param vnorItmRsltCd
	 */
	public void setVnorItmRsltCd(String vnorItmRsltCd) {
		this.vnorItmRsltCd = vnorItmRsltCd;
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
	 * @param vnorOffhFmDt
	 */
	public void setVnorOffhFmDt(String vnorOffhFmDt) {
		this.vnorOffhFmDt = vnorOffhFmDt;
	}
	
	/**
	 * Column Info
	 * @param vnorOffhToDt
	 */
	public void setVnorOffhToDt(String vnorOffhToDt) {
		this.vnorOffhToDt = vnorOffhToDt;
	}
	
	/**
	 * Column Info
	 * @param vnorItmCd
	 */
	public void setVnorItmCd(String vnorItmCd) {
		this.vnorItmCd = vnorItmCd;
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
	 * @param atchFileOpKnt
	 */
	public void setAtchFileOpKnt(String atchFileOpKnt) {
		this.atchFileOpKnt = atchFileOpKnt;
	}
	
	/**
	 * Column Info
	 * @param vnorItmProcCd
	 */
	public void setVnorItmProcCd(String vnorItmProcCd) {
		this.vnorItmProcCd = vnorItmProcCd;
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
	 * @param vnorItmFletAddCd
	 */
	public void setVnorItmFletAddCd(String vnorItmFletAddCd) {
		this.vnorItmFletAddCd = vnorItmFletAddCd;
	}
	
	/**
	 * Column Info
	 * @param vnorFmPortCd
	 */
	public void setVnorFmPortCd(String vnorFmPortCd) {
		this.vnorFmPortCd = vnorFmPortCd;
	}
	
	/**
	 * Column Info
	 * @param vnorMnItmFlg
	 */
	public void setVnorMnItmFlg(String vnorMnItmFlg) {
		this.vnorMnItmFlg = vnorMnItmFlg;
	}
	
	/**
	 * Column Info
	 * @param vnorVslStsCd
	 */
	public void setVnorVslStsCd(String vnorVslStsCd) {
		this.vnorVslStsCd = vnorVslStsCd;
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
	 * @param vnorItmOfcCd
	 */
	public void setVnorItmOfcCd(String vnorItmOfcCd) {
		this.vnorItmOfcCd = vnorItmOfcCd;
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
	 * @param atchFileFletKnt
	 */
	public void setAtchFileFletKnt(String atchFileFletKnt) {
		this.atchFileFletKnt = atchFileFletKnt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param vnorToPortCd
	 */
	public void setVnorToPortCd(String vnorToPortCd) {
		this.vnorToPortCd = vnorToPortCd;
	}
	
	/**
	 * Column Info
	 * @param vnorSeq
	 */
	public void setVnorSeq(String vnorSeq) {
		this.vnorSeq = vnorSeq;
	}
	
	/**
	 * Column Info
	 * @param invDtlSeq
	 */
	public void setInvDtlSeq(String invDtlSeq) {
		this.invDtlSeq = invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param vnorItmRmk
	 */
	public void setVnorItmRmk(String vnorItmRmk) {
		this.vnorItmRmk = vnorItmRmk;
	}
	
	/**
	 * Column Info
	 * @param vnorOffhFmDtHm
	 */
	public void setVnorOffhFmDtHm(String vnorOffhFmDtHm) {
		this.vnorOffhFmDtHm = vnorOffhFmDtHm;
	}
	
	/**
	 * Column Info
	 * @param atchFileOpLnkId
	 */
	public void setAtchFileOpLnkId(String atchFileOpLnkId) {
		this.atchFileOpLnkId = atchFileOpLnkId;
	}
	
	/**
	 * Column Info
	 * @param atchFileOpLnk
	 */
	public void setAtchFileOpLnk(String atchFileOpLnk) {
		this.atchFileOpLnkId = atchFileOpLnk;
	}	
	
	/**
	 * Column Info
	 * @param vnorOffhInd
	 */
	public void setVnorOffhInd(String vnorOffhInd) {
		this.vnorOffhInd = vnorOffhInd;
	}
	
	/**
	 * Column Info
	 * @param vnorItmFletRmk
	 */
	public void setVnorItmFletRmk(String vnorItmFletRmk) {
		this.vnorItmFletRmk = vnorItmFletRmk;
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
		setAtchFileFletLnkId(JSPUtil.getParameter(request, prefix + "atch_file_flet_lnk_id", ""));
		setAtchFileFletLnk(JSPUtil.getParameter(request, prefix + "atch_file_flet_lnk", ""));
		setVnorOffhTpCd(JSPUtil.getParameter(request, prefix + "vnor_offh_tp_cd", ""));
		setVnorOffhKndCd(JSPUtil.getParameter(request, prefix + "vnor_offh_knd_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVnorItmSeq(JSPUtil.getParameter(request, prefix + "vnor_itm_seq", ""));
		setVnorItmUtCd(JSPUtil.getParameter(request, prefix + "vnor_itm_ut_cd", ""));
		setVnorOffhToDtHm(JSPUtil.getParameter(request, prefix + "vnor_offh_to_dt_hm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setFletIssTpCd(JSPUtil.getParameter(request, prefix + "flet_iss_tp_cd", ""));
		setVnorItmVal(JSPUtil.getParameter(request, prefix + "vnor_itm_val", ""));
		setCrChkFlg(JSPUtil.getParameter(request, prefix + "cr_chk_flg", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, prefix + "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVnorItmRsltCd(JSPUtil.getParameter(request, prefix + "vnor_itm_rslt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVnorOffhFmDt(JSPUtil.getParameter(request, prefix + "vnor_offh_fm_dt", ""));
		setVnorOffhToDt(JSPUtil.getParameter(request, prefix + "vnor_offh_to_dt", ""));
		setVnorItmCd(JSPUtil.getParameter(request, prefix + "vnor_itm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAtchFileOpKnt(JSPUtil.getParameter(request, prefix + "atch_file_op_knt", ""));
		setVnorItmProcCd(JSPUtil.getParameter(request, prefix + "vnor_itm_proc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setVnorItmFletAddCd(JSPUtil.getParameter(request, prefix + "vnor_itm_flet_add_cd", ""));
		setVnorFmPortCd(JSPUtil.getParameter(request, prefix + "vnor_fm_port_cd", ""));
		setVnorMnItmFlg(JSPUtil.getParameter(request, prefix + "vnor_mn_itm_flg", ""));
		setVnorVslStsCd(JSPUtil.getParameter(request, prefix + "vnor_vsl_sts_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVnorItmOfcCd(JSPUtil.getParameter(request, prefix + "vnor_itm_ofc_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setAtchFileFletKnt(JSPUtil.getParameter(request, prefix + "atch_file_flet_knt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVnorToPortCd(JSPUtil.getParameter(request, prefix + "vnor_to_port_cd", ""));
		setVnorSeq(JSPUtil.getParameter(request, prefix + "vnor_seq", ""));
		setInvDtlSeq(JSPUtil.getParameter(request, prefix + "inv_dtl_seq", ""));
		setVnorItmRmk(JSPUtil.getParameter(request, prefix + "vnor_itm_rmk", ""));
		setVnorOffhFmDtHm(JSPUtil.getParameter(request, prefix + "vnor_offh_fm_dt_hm", ""));
		setAtchFileOpLnkId(JSPUtil.getParameter(request, prefix + "atch_file_op_lnk_id", ""));
		setAtchFileOpLnk(JSPUtil.getParameter(request, prefix + "atch_file_op_lnk", ""));
		setVnorOffhInd(JSPUtil.getParameter(request, prefix + "vnor_offh_ind", ""));
		setVnorItmFletRmk(JSPUtil.getParameter(request, prefix + "vnor_itm_flet_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOffhireExpensesListVO[]
	 */
	public SearchOffhireExpensesListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOffhireExpensesListVO[]
	 */
	public SearchOffhireExpensesListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOffhireExpensesListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] atchFileFletLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_flet_lnk_id", length));
			String[] atchFileFletLnk = (JSPUtil.getParameter(request, prefix	+ "atch_file_flet_lnk", length));
			String[] vnorOffhTpCd = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_tp_cd", length));
			String[] vnorOffhKndCd = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_knd_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vnorItmSeq = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_seq", length));
			String[] vnorItmUtCd = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_ut_cd", length));
			String[] vnorOffhToDtHm = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_to_dt_hm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] fletIssTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_iss_tp_cd", length));
			String[] vnorItmVal = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_val", length));
			String[] crChkFlg = (JSPUtil.getParameter(request, prefix	+ "cr_chk_flg", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vnorItmRsltCd = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_rslt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vnorOffhFmDt = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_fm_dt", length));
			String[] vnorOffhToDt = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_to_dt", length));
			String[] vnorItmCd = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] atchFileOpKnt = (JSPUtil.getParameter(request, prefix	+ "atch_file_op_knt", length));
			String[] vnorItmProcCd = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_proc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vnorItmFletAddCd = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_flet_add_cd", length));
			String[] vnorFmPortCd = (JSPUtil.getParameter(request, prefix	+ "vnor_fm_port_cd", length));
			String[] vnorMnItmFlg = (JSPUtil.getParameter(request, prefix	+ "vnor_mn_itm_flg", length));
			String[] vnorVslStsCd = (JSPUtil.getParameter(request, prefix	+ "vnor_vsl_sts_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vnorItmOfcCd = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_ofc_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] atchFileFletKnt = (JSPUtil.getParameter(request, prefix	+ "atch_file_flet_knt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vnorToPortCd = (JSPUtil.getParameter(request, prefix	+ "vnor_to_port_cd", length));
			String[] vnorSeq = (JSPUtil.getParameter(request, prefix	+ "vnor_seq", length));
			String[] invDtlSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_seq", length));
			String[] vnorItmRmk = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_rmk", length));
			String[] vnorOffhFmDtHm = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_fm_dt_hm", length));
			String[] atchFileOpLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_op_lnk_id", length));
			String[] atchFileOpLnk = (JSPUtil.getParameter(request, prefix	+ "atch_file_op_lnk", length));
			String[] vnorOffhInd = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_ind", length));			
			String[] vnorItmFletRmk = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_flet_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOffhireExpensesListVO();
				if (atchFileFletLnkId[i] != null)
					model.setAtchFileFletLnkId(atchFileFletLnkId[i]);
				if (atchFileFletLnk[i] != null)
					model.setAtchFileFletLnk(atchFileFletLnk[i]);				
				if (vnorOffhTpCd[i] != null)
					model.setVnorOffhTpCd(vnorOffhTpCd[i]);
				if (vnorOffhKndCd[i] != null)
					model.setVnorOffhKndCd(vnorOffhKndCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vnorItmSeq[i] != null)
					model.setVnorItmSeq(vnorItmSeq[i]);
				if (vnorItmUtCd[i] != null)
					model.setVnorItmUtCd(vnorItmUtCd[i]);
				if (vnorOffhToDtHm[i] != null)
					model.setVnorOffhToDtHm(vnorOffhToDtHm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (fletIssTpCd[i] != null)
					model.setFletIssTpCd(fletIssTpCd[i]);
				if (vnorItmVal[i] != null)
					model.setVnorItmVal(vnorItmVal[i]);
				if (crChkFlg[i] != null)
					model.setCrChkFlg(crChkFlg[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vnorItmRsltCd[i] != null)
					model.setVnorItmRsltCd(vnorItmRsltCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vnorOffhFmDt[i] != null)
					model.setVnorOffhFmDt(vnorOffhFmDt[i]);
				if (vnorOffhToDt[i] != null)
					model.setVnorOffhToDt(vnorOffhToDt[i]);
				if (vnorItmCd[i] != null)
					model.setVnorItmCd(vnorItmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (atchFileOpKnt[i] != null)
					model.setAtchFileOpKnt(atchFileOpKnt[i]);
				if (vnorItmProcCd[i] != null)
					model.setVnorItmProcCd(vnorItmProcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vnorItmFletAddCd[i] != null)
					model.setVnorItmFletAddCd(vnorItmFletAddCd[i]);
				if (vnorFmPortCd[i] != null)
					model.setVnorFmPortCd(vnorFmPortCd[i]);
				if (vnorMnItmFlg[i] != null)
					model.setVnorMnItmFlg(vnorMnItmFlg[i]);
				if (vnorVslStsCd[i] != null)
					model.setVnorVslStsCd(vnorVslStsCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vnorItmOfcCd[i] != null)
					model.setVnorItmOfcCd(vnorItmOfcCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (atchFileFletKnt[i] != null)
					model.setAtchFileFletKnt(atchFileFletKnt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vnorToPortCd[i] != null)
					model.setVnorToPortCd(vnorToPortCd[i]);
				if (vnorSeq[i] != null)
					model.setVnorSeq(vnorSeq[i]);
				if (invDtlSeq[i] != null)
					model.setInvDtlSeq(invDtlSeq[i]);
				if (vnorItmRmk[i] != null)
					model.setVnorItmRmk(vnorItmRmk[i]);
				if (vnorOffhFmDtHm[i] != null)
					model.setVnorOffhFmDtHm(vnorOffhFmDtHm[i]);
				if (atchFileOpLnkId[i] != null)
					model.setAtchFileOpLnkId(atchFileOpLnkId[i]);
				if (atchFileOpLnk[i] != null)
					model.setAtchFileOpLnk(atchFileOpLnk[i]);				
				if (vnorOffhInd[i] != null)
					model.setVnorOffhInd(vnorOffhInd[i]);
				if (vnorItmFletRmk[i] != null)
					model.setVnorItmFletRmk(vnorItmFletRmk[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOffhireExpensesListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOffhireExpensesListVO[]
	 */
	public SearchOffhireExpensesListVO[] getSearchOffhireExpensesListVOs(){
		SearchOffhireExpensesListVO[] vos = (SearchOffhireExpensesListVO[])models.toArray(new SearchOffhireExpensesListVO[models.size()]);
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
	public void onDataFormat(){
		this.atchFileFletLnkId = this.atchFileFletLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileFletLnk = this.atchFileFletLnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorOffhTpCd = this.vnorOffhTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorOffhKndCd = this.vnorOffhKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmSeq = this.vnorItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmUtCd = this.vnorItmUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorOffhToDtHm = this.vnorOffhToDtHm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletIssTpCd = this.fletIssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmVal = this.vnorItmVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crChkFlg = this.crChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmRsltCd = this.vnorItmRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorOffhFmDt = this.vnorOffhFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorOffhToDt = this.vnorOffhToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmCd = this.vnorItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileOpKnt = this.atchFileOpKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmProcCd = this.vnorItmProcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmFletAddCd = this.vnorItmFletAddCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorFmPortCd = this.vnorFmPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorMnItmFlg = this.vnorMnItmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorVslStsCd = this.vnorVslStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmOfcCd = this.vnorItmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileFletKnt = this.atchFileFletKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorToPortCd = this.vnorToPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorSeq = this.vnorSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlSeq = this.invDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmRmk = this.vnorItmRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorOffhFmDtHm = this.vnorOffhFmDtHm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileOpLnkId = this.atchFileOpLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileOpLnk = this.atchFileOpLnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.vnorOffhInd = this.vnorOffhInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmFletRmk = this.vnorItmFletRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
