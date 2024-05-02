/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchStatusListVO.java
*@FileTitle : SearchStatusListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.04.23 정행룡 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo;

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

public class SearchStatusListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchStatusListVO> models = new ArrayList<SearchStatusListVO>();
	
	/* Column Info */
	private String clmStlDt = null;
	/* Column Info */
	private String insurRcvrUsdAmt = null;
	/* Column Info */
	private String csClzDt = null;
	/* Column Info */
	private String lablPtyRcvrUsdAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fmalClmRcvDt = null;
	/* Column Info */
	private String clmtClmPtyNm = null;
	/* Column Info */
	private String deftClmPtyNm = null;
	/* Column Info */
	private String lablPtyFileUsdAmt = null;
	/* Column Info */
	private String lablPtyClmPtyNm = null;
	/* Column Info */
	private String clmStlUsdAmt = null;
	/* Column Info */
	private String ddctUsdAmt = null;
	/* Column Info */
	private String dwClmTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String insurFileUsdAmt = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String hdlrUsrNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String lablPtyRcvrDt = null;
	/* Column Info */
	private String lablPtyFileDt = null;
	/* Column Info */
	private String lablPtyTmBarDt = null;
	/* Column Info */
	private String dwClmRefVvdNo = null;
	/* Column Info */
	private String litDt = null;
	/* Column Info */
	private String insurFileDt = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String inciOccrDt = null;
	/* Column Info */
	private String clmUsdAmt = null;
	/* Column Info */
	private String arbtDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String tmBarDt = null;
	/* Column Info */
	private String dwCoCd = null;
	/* Column Info */
	private String dwClmStsCd = null;
	/* Column Info */
	private String prlmClmNtfyDt = null;
	/* Column Info */
	private String dwClmAttDefTpCd = null;
	/* Column Info */
	private String inciPlcTpCd = null;
	/* Column Info */
	private String insurRcvrDt = null;
	/* Column Info */
	private String insurClmPtyNm = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String dwClmNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchStatusListVO() {}

	public SearchStatusListVO(String ibflag, String pagerows, String dwClmNo, String dwClmTpCd, String dwCoCd, String dwClmRefVvdNo, String vslEngNm, String inciPlcTpCd, String inciOccrDt, String creOfcCd, String hdlrOfcCd, String hdlrUsrNm, String tmBarDt, String litDt, String dwClmStsCd, String dwClmAttDefTpCd, String prlmClmNtfyDt, String csClzDt, String arbtDt, String clmtClmPtyNm, String insurClmPtyNm, String ddctUsdAmt, String deftClmPtyNm, String lablPtyClmPtyNm, String lablPtyTmBarDt, String fmalClmRcvDt, String clmUsdAmt, String clmStlDt, String clmStlUsdAmt, String lablPtyFileDt, String lablPtyFileUsdAmt, String lablPtyRcvrDt, String lablPtyRcvrUsdAmt, String insurFileDt, String insurFileUsdAmt, String insurRcvrDt, String insurRcvrUsdAmt, String creUsrId, String creDt, String updUsrId, String updDt, String creUsrNm, String invAmt) {
		this.clmStlDt = clmStlDt;
		this.insurRcvrUsdAmt = insurRcvrUsdAmt;
		this.csClzDt = csClzDt;
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
		this.creDt = creDt;
		this.fmalClmRcvDt = fmalClmRcvDt;
		this.clmtClmPtyNm = clmtClmPtyNm;
		this.deftClmPtyNm = deftClmPtyNm;
		this.lablPtyFileUsdAmt = lablPtyFileUsdAmt;
		this.lablPtyClmPtyNm = lablPtyClmPtyNm;
		this.clmStlUsdAmt = clmStlUsdAmt;
		this.ddctUsdAmt = ddctUsdAmt;
		this.dwClmTpCd = dwClmTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.insurFileUsdAmt = insurFileUsdAmt;
		this.creOfcCd = creOfcCd;
		this.invAmt = invAmt;
		this.hdlrUsrNm = hdlrUsrNm;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.lablPtyRcvrDt = lablPtyRcvrDt;
		this.lablPtyFileDt = lablPtyFileDt;
		this.lablPtyTmBarDt = lablPtyTmBarDt;
		this.dwClmRefVvdNo = dwClmRefVvdNo;
		this.litDt = litDt;
		this.insurFileDt = insurFileDt;
		this.creUsrNm = creUsrNm;
		this.inciOccrDt = inciOccrDt;
		this.clmUsdAmt = clmUsdAmt;
		this.arbtDt = arbtDt;
		this.creUsrId = creUsrId;
		this.tmBarDt = tmBarDt;
		this.dwCoCd = dwCoCd;
		this.dwClmStsCd = dwClmStsCd;
		this.prlmClmNtfyDt = prlmClmNtfyDt;
		this.dwClmAttDefTpCd = dwClmAttDefTpCd;
		this.inciPlcTpCd = inciPlcTpCd;
		this.insurRcvrDt = insurRcvrDt;
		this.insurClmPtyNm = insurClmPtyNm;
		this.hdlrOfcCd = hdlrOfcCd;
		this.dwClmNo = dwClmNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("clm_stl_dt", getClmStlDt());
		this.hashColumns.put("insur_rcvr_usd_amt", getInsurRcvrUsdAmt());
		this.hashColumns.put("cs_clz_dt", getCsClzDt());
		this.hashColumns.put("labl_pty_rcvr_usd_amt", getLablPtyRcvrUsdAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("fmal_clm_rcv_dt", getFmalClmRcvDt());
		this.hashColumns.put("clmt_clm_pty_nm", getClmtClmPtyNm());
		this.hashColumns.put("deft_clm_pty_nm", getDeftClmPtyNm());
		this.hashColumns.put("labl_pty_file_usd_amt", getLablPtyFileUsdAmt());
		this.hashColumns.put("labl_pty_clm_pty_nm", getLablPtyClmPtyNm());
		this.hashColumns.put("clm_stl_usd_amt", getClmStlUsdAmt());
		this.hashColumns.put("ddct_usd_amt", getDdctUsdAmt());
		this.hashColumns.put("dw_clm_tp_cd", getDwClmTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("insur_file_usd_amt", getInsurFileUsdAmt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("hdlr_usr_nm", getHdlrUsrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("labl_pty_rcvr_dt", getLablPtyRcvrDt());
		this.hashColumns.put("labl_pty_file_dt", getLablPtyFileDt());
		this.hashColumns.put("labl_pty_tm_bar_dt", getLablPtyTmBarDt());
		this.hashColumns.put("dw_clm_ref_vvd_no", getDwClmRefVvdNo());
		this.hashColumns.put("lit_dt", getLitDt());
		this.hashColumns.put("insur_file_dt", getInsurFileDt());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("inci_occr_dt", getInciOccrDt());
		this.hashColumns.put("clm_usd_amt", getClmUsdAmt());
		this.hashColumns.put("arbt_dt", getArbtDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("tm_bar_dt", getTmBarDt());
		this.hashColumns.put("dw_co_cd", getDwCoCd());
		this.hashColumns.put("dw_clm_sts_cd", getDwClmStsCd());
		this.hashColumns.put("prlm_clm_ntfy_dt", getPrlmClmNtfyDt());
		this.hashColumns.put("dw_clm_att_def_tp_cd", getDwClmAttDefTpCd());
		this.hashColumns.put("inci_plc_tp_cd", getInciPlcTpCd());
		this.hashColumns.put("insur_rcvr_dt", getInsurRcvrDt());
		this.hashColumns.put("insur_clm_pty_nm", getInsurClmPtyNm());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("dw_clm_no", getDwClmNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("clm_stl_dt", "clmStlDt");
		this.hashFields.put("insur_rcvr_usd_amt", "insurRcvrUsdAmt");
		this.hashFields.put("cs_clz_dt", "csClzDt");
		this.hashFields.put("labl_pty_rcvr_usd_amt", "lablPtyRcvrUsdAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fmal_clm_rcv_dt", "fmalClmRcvDt");
		this.hashFields.put("clmt_clm_pty_nm", "clmtClmPtyNm");
		this.hashFields.put("deft_clm_pty_nm", "deftClmPtyNm");
		this.hashFields.put("labl_pty_file_usd_amt", "lablPtyFileUsdAmt");
		this.hashFields.put("labl_pty_clm_pty_nm", "lablPtyClmPtyNm");
		this.hashFields.put("clm_stl_usd_amt", "clmStlUsdAmt");
		this.hashFields.put("ddct_usd_amt", "ddctUsdAmt");
		this.hashFields.put("dw_clm_tp_cd", "dwClmTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("insur_file_usd_amt", "insurFileUsdAmt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("hdlr_usr_nm", "hdlrUsrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("labl_pty_rcvr_dt", "lablPtyRcvrDt");
		this.hashFields.put("labl_pty_file_dt", "lablPtyFileDt");
		this.hashFields.put("labl_pty_tm_bar_dt", "lablPtyTmBarDt");
		this.hashFields.put("dw_clm_ref_vvd_no", "dwClmRefVvdNo");
		this.hashFields.put("lit_dt", "litDt");
		this.hashFields.put("insur_file_dt", "insurFileDt");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("inci_occr_dt", "inciOccrDt");
		this.hashFields.put("clm_usd_amt", "clmUsdAmt");
		this.hashFields.put("arbt_dt", "arbtDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("tm_bar_dt", "tmBarDt");
		this.hashFields.put("dw_co_cd", "dwCoCd");
		this.hashFields.put("dw_clm_sts_cd", "dwClmStsCd");
		this.hashFields.put("prlm_clm_ntfy_dt", "prlmClmNtfyDt");
		this.hashFields.put("dw_clm_att_def_tp_cd", "dwClmAttDefTpCd");
		this.hashFields.put("inci_plc_tp_cd", "inciPlcTpCd");
		this.hashFields.put("insur_rcvr_dt", "insurRcvrDt");
		this.hashFields.put("insur_clm_pty_nm", "insurClmPtyNm");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("dw_clm_no", "dwClmNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return clmStlDt
	 */
	public String getClmStlDt() {
		return this.clmStlDt;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrUsdAmt
	 */
	public String getInsurRcvrUsdAmt() {
		return this.insurRcvrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return csClzDt
	 */
	public String getCsClzDt() {
		return this.csClzDt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrUsdAmt
	 */
	public String getLablPtyRcvrUsdAmt() {
		return this.lablPtyRcvrUsdAmt;
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
	 * @return fmalClmRcvDt
	 */
	public String getFmalClmRcvDt() {
		return this.fmalClmRcvDt;
	}
	
	/**
	 * Column Info
	 * @return clmtClmPtyNm
	 */
	public String getClmtClmPtyNm() {
		return this.clmtClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @return deftClmPtyNm
	 */
	public String getDeftClmPtyNm() {
		return this.deftClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @return lablPtyFileUsdAmt
	 */
	public String getLablPtyFileUsdAmt() {
		return this.lablPtyFileUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyClmPtyNm
	 */
	public String getLablPtyClmPtyNm() {
		return this.lablPtyClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @return clmStlUsdAmt
	 */
	public String getClmStlUsdAmt() {
		return this.clmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return ddctUsdAmt
	 */
	public String getDdctUsdAmt() {
		return this.ddctUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return dwClmTpCd
	 */
	public String getDwClmTpCd() {
		return this.dwClmTpCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return insurFileUsdAmt
	 */
	public String getInsurFileUsdAmt() {
		return this.insurFileUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return hdlrUsrNm
	 */
	public String getHdlrUsrNm() {
		return this.hdlrUsrNm;
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
	 * @return lablPtyRcvrDt
	 */
	public String getLablPtyRcvrDt() {
		return this.lablPtyRcvrDt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyFileDt
	 */
	public String getLablPtyFileDt() {
		return this.lablPtyFileDt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyTmBarDt
	 */
	public String getLablPtyTmBarDt() {
		return this.lablPtyTmBarDt;
	}
	
	/**
	 * Column Info
	 * @return dwClmRefVvdNo
	 */
	public String getDwClmRefVvdNo() {
		return this.dwClmRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return litDt
	 */
	public String getLitDt() {
		return this.litDt;
	}
	
	/**
	 * Column Info
	 * @return insurFileDt
	 */
	public String getInsurFileDt() {
		return this.insurFileDt;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return inciOccrDt
	 */
	public String getInciOccrDt() {
		return this.inciOccrDt;
	}
	
	/**
	 * Column Info
	 * @return clmUsdAmt
	 */
	public String getClmUsdAmt() {
		return this.clmUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return arbtDt
	 */
	public String getArbtDt() {
		return this.arbtDt;
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
	 * @return tmBarDt
	 */
	public String getTmBarDt() {
		return this.tmBarDt;
	}
	
	/**
	 * Column Info
	 * @return dwCoCd
	 */
	public String getDwCoCd() {
		return this.dwCoCd;
	}
	
	/**
	 * Column Info
	 * @return dwClmStsCd
	 */
	public String getDwClmStsCd() {
		return this.dwClmStsCd;
	}
	
	/**
	 * Column Info
	 * @return prlmClmNtfyDt
	 */
	public String getPrlmClmNtfyDt() {
		return this.prlmClmNtfyDt;
	}
	
	/**
	 * Column Info
	 * @return dwClmAttDefTpCd
	 */
	public String getDwClmAttDefTpCd() {
		return this.dwClmAttDefTpCd;
	}
	
	/**
	 * Column Info
	 * @return inciPlcTpCd
	 */
	public String getInciPlcTpCd() {
		return this.inciPlcTpCd;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrDt
	 */
	public String getInsurRcvrDt() {
		return this.insurRcvrDt;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyNm
	 */
	public String getInsurClmPtyNm() {
		return this.insurClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dwClmNo
	 */
	public String getDwClmNo() {
		return this.dwClmNo;
	}
	

	/**
	 * Column Info
	 * @param clmStlDt
	 */
	public void setClmStlDt(String clmStlDt) {
		this.clmStlDt = clmStlDt;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrUsdAmt
	 */
	public void setInsurRcvrUsdAmt(String insurRcvrUsdAmt) {
		this.insurRcvrUsdAmt = insurRcvrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param csClzDt
	 */
	public void setCsClzDt(String csClzDt) {
		this.csClzDt = csClzDt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrUsdAmt
	 */
	public void setLablPtyRcvrUsdAmt(String lablPtyRcvrUsdAmt) {
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
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
	 * @param fmalClmRcvDt
	 */
	public void setFmalClmRcvDt(String fmalClmRcvDt) {
		this.fmalClmRcvDt = fmalClmRcvDt;
	}
	
	/**
	 * Column Info
	 * @param clmtClmPtyNm
	 */
	public void setClmtClmPtyNm(String clmtClmPtyNm) {
		this.clmtClmPtyNm = clmtClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @param deftClmPtyNm
	 */
	public void setDeftClmPtyNm(String deftClmPtyNm) {
		this.deftClmPtyNm = deftClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @param lablPtyFileUsdAmt
	 */
	public void setLablPtyFileUsdAmt(String lablPtyFileUsdAmt) {
		this.lablPtyFileUsdAmt = lablPtyFileUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyClmPtyNm
	 */
	public void setLablPtyClmPtyNm(String lablPtyClmPtyNm) {
		this.lablPtyClmPtyNm = lablPtyClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @param clmStlUsdAmt
	 */
	public void setClmStlUsdAmt(String clmStlUsdAmt) {
		this.clmStlUsdAmt = clmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param ddctUsdAmt
	 */
	public void setDdctUsdAmt(String ddctUsdAmt) {
		this.ddctUsdAmt = ddctUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param dwClmTpCd
	 */
	public void setDwClmTpCd(String dwClmTpCd) {
		this.dwClmTpCd = dwClmTpCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param insurFileUsdAmt
	 */
	public void setInsurFileUsdAmt(String insurFileUsdAmt) {
		this.insurFileUsdAmt = insurFileUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param hdlrUsrNm
	 */
	public void setHdlrUsrNm(String hdlrUsrNm) {
		this.hdlrUsrNm = hdlrUsrNm;
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
	 * @param lablPtyRcvrDt
	 */
	public void setLablPtyRcvrDt(String lablPtyRcvrDt) {
		this.lablPtyRcvrDt = lablPtyRcvrDt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyFileDt
	 */
	public void setLablPtyFileDt(String lablPtyFileDt) {
		this.lablPtyFileDt = lablPtyFileDt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyTmBarDt
	 */
	public void setLablPtyTmBarDt(String lablPtyTmBarDt) {
		this.lablPtyTmBarDt = lablPtyTmBarDt;
	}
	
	/**
	 * Column Info
	 * @param dwClmRefVvdNo
	 */
	public void setDwClmRefVvdNo(String dwClmRefVvdNo) {
		this.dwClmRefVvdNo = dwClmRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param litDt
	 */
	public void setLitDt(String litDt) {
		this.litDt = litDt;
	}
	
	/**
	 * Column Info
	 * @param insurFileDt
	 */
	public void setInsurFileDt(String insurFileDt) {
		this.insurFileDt = insurFileDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param inciOccrDt
	 */
	public void setInciOccrDt(String inciOccrDt) {
		this.inciOccrDt = inciOccrDt;
	}
	
	/**
	 * Column Info
	 * @param clmUsdAmt
	 */
	public void setClmUsdAmt(String clmUsdAmt) {
		this.clmUsdAmt = clmUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param arbtDt
	 */
	public void setArbtDt(String arbtDt) {
		this.arbtDt = arbtDt;
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
	 * @param tmBarDt
	 */
	public void setTmBarDt(String tmBarDt) {
		this.tmBarDt = tmBarDt;
	}
	
	/**
	 * Column Info
	 * @param dwCoCd
	 */
	public void setDwCoCd(String dwCoCd) {
		this.dwCoCd = dwCoCd;
	}
	
	/**
	 * Column Info
	 * @param dwClmStsCd
	 */
	public void setDwClmStsCd(String dwClmStsCd) {
		this.dwClmStsCd = dwClmStsCd;
	}
	
	/**
	 * Column Info
	 * @param prlmClmNtfyDt
	 */
	public void setPrlmClmNtfyDt(String prlmClmNtfyDt) {
		this.prlmClmNtfyDt = prlmClmNtfyDt;
	}
	
	/**
	 * Column Info
	 * @param dwClmAttDefTpCd
	 */
	public void setDwClmAttDefTpCd(String dwClmAttDefTpCd) {
		this.dwClmAttDefTpCd = dwClmAttDefTpCd;
	}
	
	/**
	 * Column Info
	 * @param inciPlcTpCd
	 */
	public void setInciPlcTpCd(String inciPlcTpCd) {
		this.inciPlcTpCd = inciPlcTpCd;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrDt
	 */
	public void setInsurRcvrDt(String insurRcvrDt) {
		this.insurRcvrDt = insurRcvrDt;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyNm
	 */
	public void setInsurClmPtyNm(String insurClmPtyNm) {
		this.insurClmPtyNm = insurClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dwClmNo
	 */
	public void setDwClmNo(String dwClmNo) {
		this.dwClmNo = dwClmNo;
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
		setClmStlDt(JSPUtil.getParameter(request, prefix + "clm_stl_dt", ""));
		setInsurRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "insur_rcvr_usd_amt", ""));
		setCsClzDt(JSPUtil.getParameter(request, prefix + "cs_clz_dt", ""));
		setLablPtyRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_usd_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFmalClmRcvDt(JSPUtil.getParameter(request, prefix + "fmal_clm_rcv_dt", ""));
		setClmtClmPtyNm(JSPUtil.getParameter(request, prefix + "clmt_clm_pty_nm", ""));
		setDeftClmPtyNm(JSPUtil.getParameter(request, prefix + "deft_clm_pty_nm", ""));
		setLablPtyFileUsdAmt(JSPUtil.getParameter(request, prefix + "labl_pty_file_usd_amt", ""));
		setLablPtyClmPtyNm(JSPUtil.getParameter(request, prefix + "labl_pty_clm_pty_nm", ""));
		setClmStlUsdAmt(JSPUtil.getParameter(request, prefix + "clm_stl_usd_amt", ""));
		setDdctUsdAmt(JSPUtil.getParameter(request, prefix + "ddct_usd_amt", ""));
		setDwClmTpCd(JSPUtil.getParameter(request, prefix + "dw_clm_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setInsurFileUsdAmt(JSPUtil.getParameter(request, prefix + "insur_file_usd_amt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setHdlrUsrNm(JSPUtil.getParameter(request, prefix + "hdlr_usr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setLablPtyRcvrDt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_dt", ""));
		setLablPtyFileDt(JSPUtil.getParameter(request, prefix + "labl_pty_file_dt", ""));
		setLablPtyTmBarDt(JSPUtil.getParameter(request, prefix + "labl_pty_tm_bar_dt", ""));
		setDwClmRefVvdNo(JSPUtil.getParameter(request, prefix + "dw_clm_ref_vvd_no", ""));
		setLitDt(JSPUtil.getParameter(request, prefix + "lit_dt", ""));
		setInsurFileDt(JSPUtil.getParameter(request, prefix + "insur_file_dt", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setInciOccrDt(JSPUtil.getParameter(request, prefix + "inci_occr_dt", ""));
		setClmUsdAmt(JSPUtil.getParameter(request, prefix + "clm_usd_amt", ""));
		setArbtDt(JSPUtil.getParameter(request, prefix + "arbt_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTmBarDt(JSPUtil.getParameter(request, prefix + "tm_bar_dt", ""));
		setDwCoCd(JSPUtil.getParameter(request, prefix + "dw_co_cd", ""));
		setDwClmStsCd(JSPUtil.getParameter(request, prefix + "dw_clm_sts_cd", ""));
		setPrlmClmNtfyDt(JSPUtil.getParameter(request, prefix + "prlm_clm_ntfy_dt", ""));
		setDwClmAttDefTpCd(JSPUtil.getParameter(request, prefix + "dw_clm_att_def_tp_cd", ""));
		setInciPlcTpCd(JSPUtil.getParameter(request, prefix + "inci_plc_tp_cd", ""));
		setInsurRcvrDt(JSPUtil.getParameter(request, prefix + "insur_rcvr_dt", ""));
		setInsurClmPtyNm(JSPUtil.getParameter(request, prefix + "insur_clm_pty_nm", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
		setDwClmNo(JSPUtil.getParameter(request, prefix + "dw_clm_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchStatusListVO[]
	 */
	public SearchStatusListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchStatusListVO[]
	 */
	public SearchStatusListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchStatusListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] clmStlDt = (JSPUtil.getParameter(request, prefix	+ "clm_stl_dt", length));
			String[] insurRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_usd_amt", length));
			String[] csClzDt = (JSPUtil.getParameter(request, prefix	+ "cs_clz_dt", length));
			String[] lablPtyRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_usd_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fmalClmRcvDt = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_dt", length));
			String[] clmtClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_pty_nm", length));
			String[] deftClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "deft_clm_pty_nm", length));
			String[] lablPtyFileUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_file_usd_amt", length));
			String[] lablPtyClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "labl_pty_clm_pty_nm", length));
			String[] clmStlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "clm_stl_usd_amt", length));
			String[] ddctUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_usd_amt", length));
			String[] dwClmTpCd = (JSPUtil.getParameter(request, prefix	+ "dw_clm_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] insurFileUsdAmt = (JSPUtil.getParameter(request, prefix	+ "insur_file_usd_amt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] hdlrUsrNm = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] lablPtyRcvrDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_dt", length));
			String[] lablPtyFileDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_file_dt", length));
			String[] lablPtyTmBarDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_tm_bar_dt", length));
			String[] dwClmRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "dw_clm_ref_vvd_no", length));
			String[] litDt = (JSPUtil.getParameter(request, prefix	+ "lit_dt", length));
			String[] insurFileDt = (JSPUtil.getParameter(request, prefix	+ "insur_file_dt", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] inciOccrDt = (JSPUtil.getParameter(request, prefix	+ "inci_occr_dt", length));
			String[] clmUsdAmt = (JSPUtil.getParameter(request, prefix	+ "clm_usd_amt", length));
			String[] arbtDt = (JSPUtil.getParameter(request, prefix	+ "arbt_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] tmBarDt = (JSPUtil.getParameter(request, prefix	+ "tm_bar_dt", length));
			String[] dwCoCd = (JSPUtil.getParameter(request, prefix	+ "dw_co_cd", length));
			String[] dwClmStsCd = (JSPUtil.getParameter(request, prefix	+ "dw_clm_sts_cd", length));
			String[] prlmClmNtfyDt = (JSPUtil.getParameter(request, prefix	+ "prlm_clm_ntfy_dt", length));
			String[] dwClmAttDefTpCd = (JSPUtil.getParameter(request, prefix	+ "dw_clm_att_def_tp_cd", length));
			String[] inciPlcTpCd = (JSPUtil.getParameter(request, prefix	+ "inci_plc_tp_cd", length));
			String[] insurRcvrDt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_dt", length));
			String[] insurClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_nm", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] dwClmNo = (JSPUtil.getParameter(request, prefix	+ "dw_clm_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchStatusListVO();
				if (clmStlDt[i] != null)
					model.setClmStlDt(clmStlDt[i]);
				if (insurRcvrUsdAmt[i] != null)
					model.setInsurRcvrUsdAmt(insurRcvrUsdAmt[i]);
				if (csClzDt[i] != null)
					model.setCsClzDt(csClzDt[i]);
				if (lablPtyRcvrUsdAmt[i] != null)
					model.setLablPtyRcvrUsdAmt(lablPtyRcvrUsdAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fmalClmRcvDt[i] != null)
					model.setFmalClmRcvDt(fmalClmRcvDt[i]);
				if (clmtClmPtyNm[i] != null)
					model.setClmtClmPtyNm(clmtClmPtyNm[i]);
				if (deftClmPtyNm[i] != null)
					model.setDeftClmPtyNm(deftClmPtyNm[i]);
				if (lablPtyFileUsdAmt[i] != null)
					model.setLablPtyFileUsdAmt(lablPtyFileUsdAmt[i]);
				if (lablPtyClmPtyNm[i] != null)
					model.setLablPtyClmPtyNm(lablPtyClmPtyNm[i]);
				if (clmStlUsdAmt[i] != null)
					model.setClmStlUsdAmt(clmStlUsdAmt[i]);
				if (ddctUsdAmt[i] != null)
					model.setDdctUsdAmt(ddctUsdAmt[i]);
				if (dwClmTpCd[i] != null)
					model.setDwClmTpCd(dwClmTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (insurFileUsdAmt[i] != null)
					model.setInsurFileUsdAmt(insurFileUsdAmt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (hdlrUsrNm[i] != null)
					model.setHdlrUsrNm(hdlrUsrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (lablPtyRcvrDt[i] != null)
					model.setLablPtyRcvrDt(lablPtyRcvrDt[i]);
				if (lablPtyFileDt[i] != null)
					model.setLablPtyFileDt(lablPtyFileDt[i]);
				if (lablPtyTmBarDt[i] != null)
					model.setLablPtyTmBarDt(lablPtyTmBarDt[i]);
				if (dwClmRefVvdNo[i] != null)
					model.setDwClmRefVvdNo(dwClmRefVvdNo[i]);
				if (litDt[i] != null)
					model.setLitDt(litDt[i]);
				if (insurFileDt[i] != null)
					model.setInsurFileDt(insurFileDt[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (inciOccrDt[i] != null)
					model.setInciOccrDt(inciOccrDt[i]);
				if (clmUsdAmt[i] != null)
					model.setClmUsdAmt(clmUsdAmt[i]);
				if (arbtDt[i] != null)
					model.setArbtDt(arbtDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (tmBarDt[i] != null)
					model.setTmBarDt(tmBarDt[i]);
				if (dwCoCd[i] != null)
					model.setDwCoCd(dwCoCd[i]);
				if (dwClmStsCd[i] != null)
					model.setDwClmStsCd(dwClmStsCd[i]);
				if (prlmClmNtfyDt[i] != null)
					model.setPrlmClmNtfyDt(prlmClmNtfyDt[i]);
				if (dwClmAttDefTpCd[i] != null)
					model.setDwClmAttDefTpCd(dwClmAttDefTpCd[i]);
				if (inciPlcTpCd[i] != null)
					model.setInciPlcTpCd(inciPlcTpCd[i]);
				if (insurRcvrDt[i] != null)
					model.setInsurRcvrDt(insurRcvrDt[i]);
				if (insurClmPtyNm[i] != null)
					model.setInsurClmPtyNm(insurClmPtyNm[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (dwClmNo[i] != null)
					model.setDwClmNo(dwClmNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchStatusListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchStatusListVO[]
	 */
	public SearchStatusListVO[] getSearchStatusListVOs(){
		SearchStatusListVO[] vos = (SearchStatusListVO[])models.toArray(new SearchStatusListVO[models.size()]);
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
		this.clmStlDt = this.clmStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrUsdAmt = this.insurRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzDt = this.csClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrUsdAmt = this.lablPtyRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvDt = this.fmalClmRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmPtyNm = this.clmtClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftClmPtyNm = this.deftClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyFileUsdAmt = this.lablPtyFileUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyClmPtyNm = this.lablPtyClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlUsdAmt = this.clmStlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctUsdAmt = this.ddctUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmTpCd = this.dwClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurFileUsdAmt = this.insurFileUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrNm = this.hdlrUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrDt = this.lablPtyRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyFileDt = this.lablPtyFileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyTmBarDt = this.lablPtyTmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmRefVvdNo = this.dwClmRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.litDt = this.litDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurFileDt = this.insurFileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciOccrDt = this.inciOccrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmUsdAmt = this.clmUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arbtDt = this.arbtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmBarDt = this.tmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwCoCd = this.dwCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmStsCd = this.dwClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prlmClmNtfyDt = this.prlmClmNtfyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmAttDefTpCd = this.dwClmAttDefTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciPlcTpCd = this.inciPlcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrDt = this.insurRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNm = this.insurClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmNo = this.dwClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
