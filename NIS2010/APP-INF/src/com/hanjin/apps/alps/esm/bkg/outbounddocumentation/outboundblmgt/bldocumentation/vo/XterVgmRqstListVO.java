/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : XterVgmRqstListVO.java
*@FileTitle : XterVgmRqstListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XterVgmRqstListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XterVgmRqstListVO> models = new ArrayList<XterVgmRqstListVO>();
	
	/* Column Info */
	private String vgmWgtUtCd = null;
	/* Column Info */
	private String smtNm = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String vgmUpldStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String xterVgmSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String smtEml = null;
	/* Column Info */
	private String smtPhnNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String xterRqstViaCd = null;
	/* Column Info */
	private String upldDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rjctRsnRmk = null;
	/* Column Info */
	private String custId = null;
	/* Column Info */
	private String upldUsrId = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String xterSndrId = null;
	/* Column Info */
	private String vgmMzdTpCd = null;
	/* Column Info */
	private String xterSiRefNo = null;
	/* Column Info */
	private String vgmDtmnDt = null;
	/* Column Info */
	private String vgmVrfyDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String upldGdt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String xterVgmRqstNo = null;
	/* Column Info */
	private String vgmVrfySigCtnt = null;
	/* Column Info */
	private String xterBkgRqstRefNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public XterVgmRqstListVO() {}

	public XterVgmRqstListVO(String ibflag, String pagerows, String xterSndrId, String xterVgmRqstNo, String xterVgmSeq, String bkgNo, String cntrNo, String rqstDt, String xterRqstViaCd, String custId, String vgmUpldStsCd, String upldUsrId, String upldDt, String upldGdt, String vgmWgt, String vgmWgtUtCd, String vgmVrfyDt, String vgmDtmnDt, String vgmMzdTpCd, String smtNm, String smtEml, String smtPhnNo, String vgmVrfySigCtnt, String xterBkgRqstRefNo, String xterSiRefNo, String rjctRsnRmk, String updUsrId, String updDt) {
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.smtNm = smtNm;
		this.vgmWgt = vgmWgt;
		this.vgmUpldStsCd = vgmUpldStsCd;
		this.pagerows = pagerows;
		this.xterVgmSeq = xterVgmSeq;
		this.ibflag = ibflag;
		this.smtEml = smtEml;
		this.smtPhnNo = smtPhnNo;
		this.updUsrId = updUsrId;
		this.xterRqstViaCd = xterRqstViaCd;
		this.upldDt = upldDt;
		this.updDt = updDt;
		this.rjctRsnRmk = rjctRsnRmk;
		this.custId = custId;
		this.upldUsrId = upldUsrId;
		this.rqstDt = rqstDt;
		this.xterSndrId = xterSndrId;
		this.vgmMzdTpCd = vgmMzdTpCd;
		this.xterSiRefNo = xterSiRefNo;
		this.vgmDtmnDt = vgmDtmnDt;
		this.vgmVrfyDt = vgmVrfyDt;
		this.bkgNo = bkgNo;
		this.upldGdt = upldGdt;
		this.cntrNo = cntrNo;
		this.xterVgmRqstNo = xterVgmRqstNo;
		this.vgmVrfySigCtnt = vgmVrfySigCtnt;
		this.xterBkgRqstRefNo = xterBkgRqstRefNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("smt_nm", getSmtNm());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("vgm_upld_sts_cd", getVgmUpldStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("xter_vgm_seq", getXterVgmSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("smt_eml", getSmtEml());
		this.hashColumns.put("smt_phn_no", getSmtPhnNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("xter_rqst_via_cd", getXterRqstViaCd());
		this.hashColumns.put("upld_dt", getUpldDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rjct_rsn_rmk", getRjctRsnRmk());
		this.hashColumns.put("cust_id", getCustId());
		this.hashColumns.put("upld_usr_id", getUpldUsrId());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());
		this.hashColumns.put("xter_si_ref_no", getXterSiRefNo());
		this.hashColumns.put("vgm_dtmn_dt", getVgmDtmnDt());
		this.hashColumns.put("vgm_vrfy_dt", getVgmVrfyDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("upld_gdt", getUpldGdt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("xter_vgm_rqst_no", getXterVgmRqstNo());
		this.hashColumns.put("vgm_vrfy_sig_ctnt", getVgmVrfySigCtnt());
		this.hashColumns.put("xter_bkg_rqst_ref_no", getXterBkgRqstRefNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("smt_nm", "smtNm");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("vgm_upld_sts_cd", "vgmUpldStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("xter_vgm_seq", "xterVgmSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("smt_eml", "smtEml");
		this.hashFields.put("smt_phn_no", "smtPhnNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("xter_rqst_via_cd", "xterRqstViaCd");
		this.hashFields.put("upld_dt", "upldDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rjct_rsn_rmk", "rjctRsnRmk");
		this.hashFields.put("cust_id", "custId");
		this.hashFields.put("upld_usr_id", "upldUsrId");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
		this.hashFields.put("xter_si_ref_no", "xterSiRefNo");
		this.hashFields.put("vgm_dtmn_dt", "vgmDtmnDt");
		this.hashFields.put("vgm_vrfy_dt", "vgmVrfyDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("upld_gdt", "upldGdt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("xter_vgm_rqst_no", "xterVgmRqstNo");
		this.hashFields.put("vgm_vrfy_sig_ctnt", "vgmVrfySigCtnt");
		this.hashFields.put("xter_bkg_rqst_ref_no", "xterBkgRqstRefNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUtCd
	 */
	public String getVgmWgtUtCd() {
		return this.vgmWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return smtNm
	 */
	public String getSmtNm() {
		return this.smtNm;
	}
	
	/**
	 * Column Info
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
	}
	
	/**
	 * Column Info
	 * @return vgmUpldStsCd
	 */
	public String getVgmUpldStsCd() {
		return this.vgmUpldStsCd;
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
	 * @return xterVgmSeq
	 */
	public String getXterVgmSeq() {
		return this.xterVgmSeq;
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
	 * @return smtEml
	 */
	public String getSmtEml() {
		return this.smtEml;
	}
	
	/**
	 * Column Info
	 * @return smtPhnNo
	 */
	public String getSmtPhnNo() {
		return this.smtPhnNo;
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
	 * @return xterRqstViaCd
	 */
	public String getXterRqstViaCd() {
		return this.xterRqstViaCd;
	}
	
	/**
	 * Column Info
	 * @return upldDt
	 */
	public String getUpldDt() {
		return this.upldDt;
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
	 * @return rjctRsnRmk
	 */
	public String getRjctRsnRmk() {
		return this.rjctRsnRmk;
	}
	
	/**
	 * Column Info
	 * @return custId
	 */
	public String getCustId() {
		return this.custId;
	}
	
	/**
	 * Column Info
	 * @return upldUsrId
	 */
	public String getUpldUsrId() {
		return this.upldUsrId;
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
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
	}
	
	/**
	 * Column Info
	 * @return vgmMzdTpCd
	 */
	public String getVgmMzdTpCd() {
		return this.vgmMzdTpCd;
	}
	
	/**
	 * Column Info
	 * @return xterSiRefNo
	 */
	public String getXterSiRefNo() {
		return this.xterSiRefNo;
	}
	
	/**
	 * Column Info
	 * @return vgmDtmnDt
	 */
	public String getVgmDtmnDt() {
		return this.vgmDtmnDt;
	}
	
	/**
	 * Column Info
	 * @return vgmVrfyDt
	 */
	public String getVgmVrfyDt() {
		return this.vgmVrfyDt;
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
	 * @return upldGdt
	 */
	public String getUpldGdt() {
		return this.upldGdt;
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
	 * @return xterVgmRqstNo
	 */
	public String getXterVgmRqstNo() {
		return this.xterVgmRqstNo;
	}
	
	/**
	 * Column Info
	 * @return vgmVrfySigCtnt
	 */
	public String getVgmVrfySigCtnt() {
		return this.vgmVrfySigCtnt;
	}
	
	/**
	 * Column Info
	 * @return xterBkgRqstRefNo
	 */
	public String getXterBkgRqstRefNo() {
		return this.xterBkgRqstRefNo;
	}
	

	/**
	 * Column Info
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param smtNm
	 */
	public void setSmtNm(String smtNm) {
		this.smtNm = smtNm;
	}
	
	/**
	 * Column Info
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
	}
	
	/**
	 * Column Info
	 * @param vgmUpldStsCd
	 */
	public void setVgmUpldStsCd(String vgmUpldStsCd) {
		this.vgmUpldStsCd = vgmUpldStsCd;
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
	 * @param xterVgmSeq
	 */
	public void setXterVgmSeq(String xterVgmSeq) {
		this.xterVgmSeq = xterVgmSeq;
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
	 * @param smtEml
	 */
	public void setSmtEml(String smtEml) {
		this.smtEml = smtEml;
	}
	
	/**
	 * Column Info
	 * @param smtPhnNo
	 */
	public void setSmtPhnNo(String smtPhnNo) {
		this.smtPhnNo = smtPhnNo;
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
	 * @param xterRqstViaCd
	 */
	public void setXterRqstViaCd(String xterRqstViaCd) {
		this.xterRqstViaCd = xterRqstViaCd;
	}
	
	/**
	 * Column Info
	 * @param upldDt
	 */
	public void setUpldDt(String upldDt) {
		this.upldDt = upldDt;
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
	 * @param rjctRsnRmk
	 */
	public void setRjctRsnRmk(String rjctRsnRmk) {
		this.rjctRsnRmk = rjctRsnRmk;
	}
	
	/**
	 * Column Info
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	/**
	 * Column Info
	 * @param upldUsrId
	 */
	public void setUpldUsrId(String upldUsrId) {
		this.upldUsrId = upldUsrId;
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
	 * @param xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
	}
	
	/**
	 * Column Info
	 * @param vgmMzdTpCd
	 */
	public void setVgmMzdTpCd(String vgmMzdTpCd) {
		this.vgmMzdTpCd = vgmMzdTpCd;
	}
	
	/**
	 * Column Info
	 * @param xterSiRefNo
	 */
	public void setXterSiRefNo(String xterSiRefNo) {
		this.xterSiRefNo = xterSiRefNo;
	}
	
	/**
	 * Column Info
	 * @param vgmDtmnDt
	 */
	public void setVgmDtmnDt(String vgmDtmnDt) {
		this.vgmDtmnDt = vgmDtmnDt;
	}
	
	/**
	 * Column Info
	 * @param vgmVrfyDt
	 */
	public void setVgmVrfyDt(String vgmVrfyDt) {
		this.vgmVrfyDt = vgmVrfyDt;
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
	 * @param upldGdt
	 */
	public void setUpldGdt(String upldGdt) {
		this.upldGdt = upldGdt;
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
	 * @param xterVgmRqstNo
	 */
	public void setXterVgmRqstNo(String xterVgmRqstNo) {
		this.xterVgmRqstNo = xterVgmRqstNo;
	}
	
	/**
	 * Column Info
	 * @param vgmVrfySigCtnt
	 */
	public void setVgmVrfySigCtnt(String vgmVrfySigCtnt) {
		this.vgmVrfySigCtnt = vgmVrfySigCtnt;
	}
	
	/**
	 * Column Info
	 * @param xterBkgRqstRefNo
	 */
	public void setXterBkgRqstRefNo(String xterBkgRqstRefNo) {
		this.xterBkgRqstRefNo = xterBkgRqstRefNo;
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
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setSmtNm(JSPUtil.getParameter(request, prefix + "smt_nm", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setVgmUpldStsCd(JSPUtil.getParameter(request, prefix + "vgm_upld_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setXterVgmSeq(JSPUtil.getParameter(request, prefix + "xter_vgm_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSmtEml(JSPUtil.getParameter(request, prefix + "smt_eml", ""));
		setSmtPhnNo(JSPUtil.getParameter(request, prefix + "smt_phn_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setXterRqstViaCd(JSPUtil.getParameter(request, prefix + "xter_rqst_via_cd", ""));
		setUpldDt(JSPUtil.getParameter(request, prefix + "upld_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRjctRsnRmk(JSPUtil.getParameter(request, prefix + "rjct_rsn_rmk", ""));
		setCustId(JSPUtil.getParameter(request, prefix + "cust_id", ""));
		setUpldUsrId(JSPUtil.getParameter(request, prefix + "upld_usr_id", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
		setVgmMzdTpCd(JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", ""));
		setXterSiRefNo(JSPUtil.getParameter(request, prefix + "xter_si_ref_no", ""));
		setVgmDtmnDt(JSPUtil.getParameter(request, prefix + "vgm_dtmn_dt", ""));
		setVgmVrfyDt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setUpldGdt(JSPUtil.getParameter(request, prefix + "upld_gdt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setXterVgmRqstNo(JSPUtil.getParameter(request, prefix + "xter_vgm_rqst_no", ""));
		setVgmVrfySigCtnt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_sig_ctnt", ""));
		setXterBkgRqstRefNo(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_ref_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterVgmRqstListVO[]
	 */
	public XterVgmRqstListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XterVgmRqstListVO[]
	 */
	public XterVgmRqstListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterVgmRqstListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
			String[] smtNm = (JSPUtil.getParameter(request, prefix	+ "smt_nm", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] vgmUpldStsCd = (JSPUtil.getParameter(request, prefix	+ "vgm_upld_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] xterVgmSeq = (JSPUtil.getParameter(request, prefix	+ "xter_vgm_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] smtEml = (JSPUtil.getParameter(request, prefix	+ "smt_eml", length));
			String[] smtPhnNo = (JSPUtil.getParameter(request, prefix	+ "smt_phn_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] xterRqstViaCd = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_via_cd", length));
			String[] upldDt = (JSPUtil.getParameter(request, prefix	+ "upld_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rjctRsnRmk = (JSPUtil.getParameter(request, prefix	+ "rjct_rsn_rmk", length));
			String[] custId = (JSPUtil.getParameter(request, prefix	+ "cust_id", length));
			String[] upldUsrId = (JSPUtil.getParameter(request, prefix	+ "upld_usr_id", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_mzd_tp_cd", length));
			String[] xterSiRefNo = (JSPUtil.getParameter(request, prefix	+ "xter_si_ref_no", length));
			String[] vgmDtmnDt = (JSPUtil.getParameter(request, prefix	+ "vgm_dtmn_dt", length));
			String[] vgmVrfyDt = (JSPUtil.getParameter(request, prefix	+ "vgm_vrfy_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] upldGdt = (JSPUtil.getParameter(request, prefix	+ "upld_gdt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] xterVgmRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_vgm_rqst_no", length));
			String[] vgmVrfySigCtnt = (JSPUtil.getParameter(request, prefix	+ "vgm_vrfy_sig_ctnt", length));
			String[] xterBkgRqstRefNo = (JSPUtil.getParameter(request, prefix	+ "xter_bkg_rqst_ref_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new XterVgmRqstListVO();
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				if (smtNm[i] != null)
					model.setSmtNm(smtNm[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (vgmUpldStsCd[i] != null)
					model.setVgmUpldStsCd(vgmUpldStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (xterVgmSeq[i] != null)
					model.setXterVgmSeq(xterVgmSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (smtEml[i] != null)
					model.setSmtEml(smtEml[i]);
				if (smtPhnNo[i] != null)
					model.setSmtPhnNo(smtPhnNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (xterRqstViaCd[i] != null)
					model.setXterRqstViaCd(xterRqstViaCd[i]);
				if (upldDt[i] != null)
					model.setUpldDt(upldDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rjctRsnRmk[i] != null)
					model.setRjctRsnRmk(rjctRsnRmk[i]);
				if (custId[i] != null)
					model.setCustId(custId[i]);
				if (upldUsrId[i] != null)
					model.setUpldUsrId(upldUsrId[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (vgmMzdTpCd[i] != null)
					model.setVgmMzdTpCd(vgmMzdTpCd[i]);
				if (xterSiRefNo[i] != null)
					model.setXterSiRefNo(xterSiRefNo[i]);
				if (vgmDtmnDt[i] != null)
					model.setVgmDtmnDt(vgmDtmnDt[i]);
				if (vgmVrfyDt[i] != null)
					model.setVgmVrfyDt(vgmVrfyDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (upldGdt[i] != null)
					model.setUpldGdt(upldGdt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (xterVgmRqstNo[i] != null)
					model.setXterVgmRqstNo(xterVgmRqstNo[i]);
				if (vgmVrfySigCtnt[i] != null)
					model.setVgmVrfySigCtnt(vgmVrfySigCtnt[i]);
				if (xterBkgRqstRefNo[i] != null)
					model.setXterBkgRqstRefNo(xterBkgRqstRefNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterVgmRqstListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterVgmRqstListVO[]
	 */
	public XterVgmRqstListVO[] getXterVgmRqstListVOs(){
		XterVgmRqstListVO[] vos = (XterVgmRqstListVO[])models.toArray(new XterVgmRqstListVO[models.size()]);
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
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtNm = this.smtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmUpldStsCd = this.vgmUpldStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmSeq = this.xterVgmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtEml = this.smtEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtPhnNo = this.smtPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstViaCd = this.xterRqstViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upldDt = this.upldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctRsnRmk = this.rjctRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custId = this.custId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upldUsrId = this.upldUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMzdTpCd = this.vgmMzdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSiRefNo = this.xterSiRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDtmnDt = this.vgmDtmnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfyDt = this.vgmVrfyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upldGdt = this.upldGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmRqstNo = this.xterVgmRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfySigCtnt = this.vgmVrfySigCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBkgRqstRefNo = this.xterBkgRqstRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
