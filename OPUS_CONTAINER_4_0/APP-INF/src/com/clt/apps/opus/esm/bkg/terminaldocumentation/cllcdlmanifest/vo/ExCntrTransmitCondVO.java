/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExCntrTransmitCondVO.java
*@FileTitle : ExCntrTransmitCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.04
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExCntrTransmitCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ExCntrTransmitCondVO> models = new ArrayList<ExCntrTransmitCondVO>();

	/* Column Info */
	private String formBkgNo = null;
	/* Column Info */
	private String formTmnlBrthCd = null;
	/* Column Info */
	private String inSpecialFlag = null;
	/* Column Info */
	private String formGrsWgt = null;
	/* Column Info */
	private String formHaulMode = null;
	/* Column Info */
	private String formCodeOpr = null;
	/* Column Info */
	private String inCrYard = null;
	/* Column Info */
	private String inCrVslname = null;
	/* Column Info */
	private String formTranMode = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inCntrNo = null;
	/* Column Info */
	private String inCheckGubun = null;
	/* Column Info */
	private String formTermPod = null;
	/* Column Info */
	private String formTermVvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inCrEdateStart = null;
	/* Column Info */
	private String inCrEdateEnd = null;
	/* Column Info */
	private String formTermPol = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String formFwrdAgnCd = null;
	/* Column Info */
	private String inDcgoSeq = null;
	/* Column Info */
	private String inPodCd = null;
	/* Column Info */
	private String formNykVvd = null;
	private String creUsrId = null;
	private String updUsrId = null;
	private String formNykPol = null;
	private String formCntrType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ExCntrTransmitCondVO() {}

	public ExCntrTransmitCondVO(String ibflag, String pagerows, String inCntrNo, String inCrYard,
			String inCrVslname, String inCheckGubun, String formBkgNo, String inCrEdateStart, String inDcgoSeq,
			String inCrEdateEnd, String formTermPol, String inVvdCd, String inSpecialFlag, String inPodCd,
			String formTermVvd, String formCodeOpr, String formTermPod, String formFwrdAgnCd, String formTmnlBrthCd,
			String formHaulMode, String formTranMode, String formGrsWgt, String formNykVvd, String creUsrId, String updUsrId,
			String formNykPol, String formCntrType) {
		this.formBkgNo = formBkgNo;
		this.formTmnlBrthCd = formTmnlBrthCd;
		this.inSpecialFlag = inSpecialFlag;
		this.formGrsWgt = formGrsWgt;
		this.formHaulMode = formHaulMode;
		this.formCodeOpr = formCodeOpr;
		this.inCrYard = inCrYard;
		this.inCrVslname = inCrVslname;
		this.formTranMode = formTranMode;
		this.pagerows = pagerows;
		this.inCntrNo = inCntrNo;
		this.inCheckGubun = inCheckGubun;
		this.formTermPod = formTermPod;
		this.formTermVvd = formTermVvd;
		this.ibflag = ibflag;
		this.inCrEdateStart = inCrEdateStart;
		this.inCrEdateEnd = inCrEdateEnd;
		this.formTermPol = formTermPol;
		this.inVvdCd = inVvdCd;
		this.formFwrdAgnCd = formFwrdAgnCd;
		this.inDcgoSeq = inDcgoSeq;
		this.inPodCd = inPodCd;
		this.formNykVvd = formNykVvd;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.formNykPol = formNykPol;
		this.formCntrType = formCntrType;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("form_bkg_no", getFormBkgNo());
		this.hashColumns.put("form_tmnl_brth_cd", getFormTmnlBrthCd());
		this.hashColumns.put("in_special_flag", getInSpecialFlag());
		this.hashColumns.put("form_grs_wgt", getFormGrsWgt());
		this.hashColumns.put("form_haul_mode", getFormHaulMode());
		this.hashColumns.put("form_code_opr", getFormCodeOpr());
		this.hashColumns.put("in_cr_yard", getInCrYard());
		this.hashColumns.put("in_cr_vslname", getInCrVslname());
		this.hashColumns.put("form_tran_mode", getFormTranMode());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_cntr_no", getInCntrNo());
		this.hashColumns.put("in_check_gubun", getInCheckGubun());
		this.hashColumns.put("form_term_pod", getFormTermPod());
		this.hashColumns.put("form_term_vvd", getFormTermVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_cr_edate_start", getInCrEdateStart());
		this.hashColumns.put("in_cr_edate_end", getInCrEdateEnd());
		this.hashColumns.put("form_term_pol", getFormTermPol());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("form_fwrd_agn_cd", getFormFwrdAgnCd());
		this.hashColumns.put("in_dcgo_seq", getInDcgoSeq());
		this.hashColumns.put("in_pod_cd", getInPodCd());
		this.hashColumns.put("form_nyk_vvd", getFormNykVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("form_nyk_pol", getFormNykPol());
		this.hashColumns.put("form_cntr_type", getFormCntrType());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("form_bkg_no", "formBkgNo");
		this.hashFields.put("form_tmnl_brth_cd", "formTmnlBrthCd");
		this.hashFields.put("in_special_flag", "inSpecialFlag");
		this.hashFields.put("form_grs_wgt", "formGrsWgt");
		this.hashFields.put("form_haul_mode", "formHaulMode");
		this.hashFields.put("form_code_opr", "formCodeOpr");
		this.hashFields.put("in_cr_yard", "inCrYard");
		this.hashFields.put("in_cr_vslname", "inCrVslname");
		this.hashFields.put("form_tran_mode", "formTranMode");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_cntr_no", "inCntrNo");
		this.hashFields.put("in_check_gubun", "inCheckGubun");
		this.hashFields.put("form_term_pod", "formTermPod");
		this.hashFields.put("form_term_vvd", "formTermVvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_cr_edate_start", "inCrEdateStart");
		this.hashFields.put("in_cr_edate_end", "inCrEdateEnd");
		this.hashFields.put("form_term_pol", "formTermPol");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("form_fwrd_agn_cd", "formFwrdAgnCd");
		this.hashFields.put("in_dcgo_seq", "inDcgoSeq");
		this.hashFields.put("in_pod_cd", "inPodCd");
		this.hashFields.put("form_nyk_vvd", "formNykVvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("form_nyk_pol", "formNykPol");
		this.hashFields.put("form_cntr_type", "formCntrType");
		return this.hashFields;
	}



	public String getFormCntrType() {
		return formCntrType;
	}

	public void setFormCntrType(String formCntrType) {
		this.formCntrType = formCntrType;
	}

	public String getFormNykPol() {
		return formNykPol;
	}

	public void setFormNykPol(String formNykPol) {
		this.formNykPol = formNykPol;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * @return formBkgNo
	 */
	public String getFormBkgNo() {
		return this.formBkgNo;
	}

	/**
	 * Column Info
	 * @return formTmnlBrthCd
	 */
	public String getFormTmnlBrthCd() {
		return this.formTmnlBrthCd;
	}

	/**
	 * Column Info
	 * @return inSpecialFlag
	 */
	public String getInSpecialFlag() {
		return this.inSpecialFlag;
	}

	/**
	 * Column Info
	 * @return formGrsWgt
	 */
	public String getFormGrsWgt() {
		return this.formGrsWgt;
	}

	/**
	 * Column Info
	 * @return formHaulMode
	 */
	public String getFormHaulMode() {
		return this.formHaulMode;
	}

	/**
	 * Column Info
	 * @return formCodeOpr
	 */
	public String getFormCodeOpr() {
		return this.formCodeOpr;
	}

	/**
	 * Column Info
	 * @return inCrYard
	 */
	public String getInCrYard() {
		return this.inCrYard;
	}

	/**
	 * Column Info
	 * @return inCrVslname
	 */
	public String getInCrVslname() {
		return this.inCrVslname;
	}

	/**
	 * Column Info
	 * @return formTranMode
	 */
	public String getFormTranMode() {
		return this.formTranMode;
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
	 * @return inCntrNo
	 */
	public String getInCntrNo() {
		return this.inCntrNo;
	}

	/**
	 * Column Info
	 * @return inCheckGubun
	 */
	public String getInCheckGubun() {
		return this.inCheckGubun;
	}

	/**
	 * Column Info
	 * @return formTermPod
	 */
	public String getFormTermPod() {
		return this.formTermPod;
	}

	/**
	 * Column Info
	 * @return formTermVvd
	 */
	public String getFormTermVvd() {
		return this.formTermVvd;
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
	 * @return inCrEdateStart
	 */
	public String getInCrEdateStart() {
		return this.inCrEdateStart;
	}

	/**
	 * Column Info
	 * @return inCrEdateEnd
	 */
	public String getInCrEdateEnd() {
		return this.inCrEdateEnd;
	}

	/**
	 * Column Info
	 * @return formTermPol
	 */
	public String getFormTermPol() {
		return this.formTermPol;
	}

	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}

	/**
	 * Column Info
	 * @return formFwrdAgnCd
	 */
	public String getFormFwrdAgnCd() {
		return this.formFwrdAgnCd;
	}

	/**
	 * Column Info
	 * @return inDcgoSeq
	 */
	public String getInDcgoSeq() {
		return this.inDcgoSeq;
	}

	/**
	 * Column Info
	 * @return inPodCd
	 */
	public String getInPodCd() {
		return this.inPodCd;
	}

	/**
	 * Column Info
	 * @return formNykVvd
	 */
	public String getFormNykVvd() {
		return this.formNykVvd;
	}


	/**
	 * Column Info
	 * @param formBkgNo
	 */
	public void setFormBkgNo(String formBkgNo) {
		this.formBkgNo = formBkgNo;
	}

	/**
	 * Column Info
	 * @param formTmnlBrthCd
	 */
	public void setFormTmnlBrthCd(String formTmnlBrthCd) {
		this.formTmnlBrthCd = formTmnlBrthCd;
	}

	/**
	 * Column Info
	 * @param inSpecialFlag
	 */
	public void setInSpecialFlag(String inSpecialFlag) {
		this.inSpecialFlag = inSpecialFlag;
	}

	/**
	 * Column Info
	 * @param formGrsWgt
	 */
	public void setFormGrsWgt(String formGrsWgt) {
		this.formGrsWgt = formGrsWgt;
	}

	/**
	 * Column Info
	 * @param formHaulMode
	 */
	public void setFormHaulMode(String formHaulMode) {
		this.formHaulMode = formHaulMode;
	}

	/**
	 * Column Info
	 * @param formCodeOpr
	 */
	public void setFormCodeOpr(String formCodeOpr) {
		this.formCodeOpr = formCodeOpr;
	}

	/**
	 * Column Info
	 * @param inCrYard
	 */
	public void setInCrYard(String inCrYard) {
		this.inCrYard = inCrYard;
	}

	/**
	 * Column Info
	 * @param inCrVslname
	 */
	public void setInCrVslname(String inCrVslname) {
		this.inCrVslname = inCrVslname;
	}

	/**
	 * Column Info
	 * @param formTranMode
	 */
	public void setFormTranMode(String formTranMode) {
		this.formTranMode = formTranMode;
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
	 * @param inCntrNo
	 */
	public void setInCntrNo(String inCntrNo) {
		this.inCntrNo = inCntrNo;
	}

	/**
	 * Column Info
	 * @param inCheckGubun
	 */
	public void setInCheckGubun(String inCheckGubun) {
		this.inCheckGubun = inCheckGubun;
	}

	/**
	 * Column Info
	 * @param formTermPod
	 */
	public void setFormTermPod(String formTermPod) {
		this.formTermPod = formTermPod;
	}

	/**
	 * Column Info
	 * @param formTermVvd
	 */
	public void setFormTermVvd(String formTermVvd) {
		this.formTermVvd = formTermVvd;
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
	 * @param inCrEdateStart
	 */
	public void setInCrEdateStart(String inCrEdateStart) {
		this.inCrEdateStart = inCrEdateStart;
	}

	/**
	 * Column Info
	 * @param inCrEdateEnd
	 */
	public void setInCrEdateEnd(String inCrEdateEnd) {
		this.inCrEdateEnd = inCrEdateEnd;
	}

	/**
	 * Column Info
	 * @param formTermPol
	 */
	public void setFormTermPol(String formTermPol) {
		this.formTermPol = formTermPol;
	}

	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}

	/**
	 * Column Info
	 * @param formFwrdAgnCd
	 */
	public void setFormFwrdAgnCd(String formFwrdAgnCd) {
		this.formFwrdAgnCd = formFwrdAgnCd;
	}

	/**
	 * Column Info
	 * @param inDcgoSeq
	 */
	public void setInDcgoSeq(String inDcgoSeq) {
		this.inDcgoSeq = inDcgoSeq;
	}

	/**
	 * Column Info
	 * @param inPodCd
	 */
	public void setInPodCd(String inPodCd) {
		this.inPodCd = inPodCd;
	}

	/**
	 * Column Info
	 * @param formNykVvd
	 */
	public void setFormNykVvd(String formNykVvd) {
		this.formNykVvd = formNykVvd;
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
		setFormBkgNo(JSPUtil.getParameter(request, prefix + "form_bkg_no", ""));
		setFormTmnlBrthCd(JSPUtil.getParameter(request, prefix + "form_tmnl_brth_cd", ""));
		setInSpecialFlag(JSPUtil.getParameter(request, prefix + "in_special_flag", ""));
		setFormGrsWgt(JSPUtil.getParameter(request, prefix + "form_grs_wgt", ""));
		setFormHaulMode(JSPUtil.getParameter(request, prefix + "form_haul_mode", ""));
		setFormCodeOpr(JSPUtil.getParameter(request, prefix + "form_code_opr", ""));
		setInCrYard(JSPUtil.getParameter(request, prefix + "in_cr_yard", ""));
		setInCrVslname(JSPUtil.getParameter(request, prefix + "in_cr_vslname", ""));
		setFormTranMode(JSPUtil.getParameter(request, prefix + "form_tran_mode", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInCntrNo(JSPUtil.getParameter(request, prefix + "in_cntr_no", ""));
		setInCheckGubun(JSPUtil.getParameter(request, prefix + "in_check_gubun", ""));
		setFormTermPod(JSPUtil.getParameter(request, prefix + "form_term_pod", ""));
		setFormTermVvd(JSPUtil.getParameter(request, prefix + "form_term_vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInCrEdateStart(JSPUtil.getParameter(request, prefix + "in_cr_edate_start", ""));
		setInCrEdateEnd(JSPUtil.getParameter(request, prefix + "in_cr_edate_end", ""));
		setFormTermPol(JSPUtil.getParameter(request, prefix + "form_term_pol", ""));
		setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
		setFormFwrdAgnCd(JSPUtil.getParameter(request, prefix + "form_fwrd_agn_cd", ""));
		setInDcgoSeq(JSPUtil.getParameter(request, prefix + "in_dcgo_seq", ""));
		setInPodCd(JSPUtil.getParameter(request, prefix + "in_pod_cd", ""));
		setFormNykVvd(JSPUtil.getParameter(request, prefix + "form_nyk_vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFormNykPol(JSPUtil.getParameter(request, prefix + "form_nyk_pol", ""));
		setFormCntrType(JSPUtil.getParameter(request, prefix + "form_cntr_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExCntrTransmitCondVO[]
	 */
	public ExCntrTransmitCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ExCntrTransmitCondVO[]
	 */
	public ExCntrTransmitCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExCntrTransmitCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] formBkgNo = (JSPUtil.getParameter(request, prefix	+ "form_bkg_no", length));
			String[] formTmnlBrthCd = (JSPUtil.getParameter(request, prefix	+ "form_tmnl_brth_cd", length));
			String[] inSpecialFlag = (JSPUtil.getParameter(request, prefix	+ "in_special_flag", length));
			String[] formGrsWgt = (JSPUtil.getParameter(request, prefix	+ "form_grs_wgt", length));
			String[] formHaulMode = (JSPUtil.getParameter(request, prefix	+ "form_haul_mode", length));
			String[] formCodeOpr = (JSPUtil.getParameter(request, prefix	+ "form_code_opr", length));
			String[] inCrYard = (JSPUtil.getParameter(request, prefix	+ "in_cr_yard", length));
			String[] inCrVslname = (JSPUtil.getParameter(request, prefix	+ "in_cr_vslname", length));
			String[] formTranMode = (JSPUtil.getParameter(request, prefix	+ "form_tran_mode", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inCntrNo = (JSPUtil.getParameter(request, prefix	+ "in_cntr_no", length));
			String[] inCheckGubun = (JSPUtil.getParameter(request, prefix	+ "in_check_gubun", length));
			String[] formTermPod = (JSPUtil.getParameter(request, prefix	+ "form_term_pod", length));
			String[] formTermVvd = (JSPUtil.getParameter(request, prefix	+ "form_term_vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inCrEdateStart = (JSPUtil.getParameter(request, prefix	+ "in_cr_edate_start", length));
			String[] inCrEdateEnd = (JSPUtil.getParameter(request, prefix	+ "in_cr_edate_end", length));
			String[] formTermPol = (JSPUtil.getParameter(request, prefix	+ "form_term_pol", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] formFwrdAgnCd = (JSPUtil.getParameter(request, prefix	+ "form_fwrd_agn_cd", length));
			String[] inDcgoSeq = (JSPUtil.getParameter(request, prefix	+ "in_dcgo_seq", length));
			String[] inPodCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd", length));
			String[] formNykVvd = (JSPUtil.getParameter(request, prefix	+ "form_nyk_vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] formNykPol = (JSPUtil.getParameter(request, prefix	+ "form_nyk_pol", length));
			String[] formCntrType = (JSPUtil.getParameter(request, prefix	+ "form_cntr_type", length));

			for (int i = 0; i < length; i++) {
				model = new ExCntrTransmitCondVO();
				if (formBkgNo[i] != null)
					model.setFormBkgNo(formBkgNo[i]);
				if (formTmnlBrthCd[i] != null)
					model.setFormTmnlBrthCd(formTmnlBrthCd[i]);
				if (inSpecialFlag[i] != null)
					model.setInSpecialFlag(inSpecialFlag[i]);
				if (formGrsWgt[i] != null)
					model.setFormGrsWgt(formGrsWgt[i]);
				if (formHaulMode[i] != null)
					model.setFormHaulMode(formHaulMode[i]);
				if (formCodeOpr[i] != null)
					model.setFormCodeOpr(formCodeOpr[i]);
				if (inCrYard[i] != null)
					model.setInCrYard(inCrYard[i]);
				if (inCrVslname[i] != null)
					model.setInCrVslname(inCrVslname[i]);
				if (formTranMode[i] != null)
					model.setFormTranMode(formTranMode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inCntrNo[i] != null)
					model.setInCntrNo(inCntrNo[i]);
				if (inCheckGubun[i] != null)
					model.setInCheckGubun(inCheckGubun[i]);
				if (formTermPod[i] != null)
					model.setFormTermPod(formTermPod[i]);
				if (formTermVvd[i] != null)
					model.setFormTermVvd(formTermVvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inCrEdateStart[i] != null)
					model.setInCrEdateStart(inCrEdateStart[i]);
				if (inCrEdateEnd[i] != null)
					model.setInCrEdateEnd(inCrEdateEnd[i]);
				if (formTermPol[i] != null)
					model.setFormTermPol(formTermPol[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (formFwrdAgnCd[i] != null)
					model.setFormFwrdAgnCd(formFwrdAgnCd[i]);
				if (inDcgoSeq[i] != null)
					model.setInDcgoSeq(inDcgoSeq[i]);
				if (inPodCd[i] != null)
					model.setInPodCd(inPodCd[i]);
				if (formNykVvd[i] != null)
					model.setFormNykVvd(formNykVvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (formNykPol[i] != null)
					model.setFormNykPol(updUsrId[i]);
				if (formCntrType[i] != null)
					model.setFormCntrType(formCntrType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExCntrTransmitCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExCntrTransmitCondVO[]
	 */
	public ExCntrTransmitCondVO[] getExCntrTransmitCondVOs(){
		ExCntrTransmitCondVO[] vos = (ExCntrTransmitCondVO[])models.toArray(new ExCntrTransmitCondVO[models.size()]);
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
		this.formBkgNo = this.formBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formTmnlBrthCd = this.formTmnlBrthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSpecialFlag = this.inSpecialFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formGrsWgt = this.formGrsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formHaulMode = this.formHaulMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formCodeOpr = this.formCodeOpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCrYard = this.inCrYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCrVslname = this.inCrVslname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formTranMode = this.formTranMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrNo = this.inCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCheckGubun = this.inCheckGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formTermPod = this.formTermPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formTermVvd = this.formTermVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCrEdateStart = this.inCrEdateStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCrEdateEnd = this.inCrEdateEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formTermPol = this.formTermPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formFwrdAgnCd = this.formFwrdAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDcgoSeq = this.inDcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCd = this.inPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formNykVvd = this.formNykVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formNykPol = this.formNykPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formCntrType = this.formCntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
