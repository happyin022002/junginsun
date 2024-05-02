/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TriPropParamVO.java
*@FileTitle : TriPropParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.triproposal.triproposal.vo;

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

public class TriPropParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TriPropParamVO> models = new ArrayList<TriPropParamVO>();
	
	/* Column Info */
	private String srchTrfNo = null;
	/* Column Info */
	private String srchTrfPfxCd = null;
	/* Column Info */
	private String srchTriRqstOfcCd = null;
	/* Column Info */
	private String srchPropStsCd = null;
	/* Column Info */
	private String srchCurrCd = null;
	/* Column Info */
	private String srchCmdtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srchAccDt = null;
	/* Column Info */
	private String srchTaaNo = null;
	/* Column Info */
	private String srchPrcCgoTpCd = null;
	/* Column Info */
	private String srchTriPropNo = null;
	/* Column Info */
	private String srchAcsDt = null;
	/* Column Info */
	private String srchIsGriAppl = null;
	/* Column Info */
	private String srchEffDt = null;
	/* Column Info */
	private String srchTriAproOfcCd = null;
	/* Column Info */
	private String srchAction = null;
	/* Column Info */
	private String srchOrgRoutViaPortNm = null;
	/* Column Info */
	private String srchTriNo = null;
	/* Column Info */
	private String srchGriEffDt = null;
	/* Column Info */
	private String srchExpDt = null;
	/* Column Info */
	private String srchDestRoutPntLocNm = null;
	/* Column Info */
	private String srchOrgRoutPntLocNm = null;
	/* Column Info */
	private String srchRatUtCd = null;
	/* Column Info */
	private String srchDestRoutViaPortNm = null;
	/* Column Info */
	private String srchNoteCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TriPropParamVO() {}

	public TriPropParamVO(String ibflag, String pagerows, String srchTriPropNo, String srchTrfPfxCd, String srchTrfNo, String srchTriNo, String srchCmdtCd, String srchOrgRoutPntLocNm, String srchOrgRoutViaPortNm, String srchDestRoutViaPortNm, String srchDestRoutPntLocNm, String srchPropStsCd, String srchTriRqstOfcCd, String srchTriAproOfcCd, String srchIsGriAppl, String srchRatUtCd, String srchPrcCgoTpCd, String srchCurrCd, String srchEffDt, String srchExpDt, String srchAcsDt, String srchTaaNo, String srchAction, String srchGriEffDt, String srchAccDt, String srchNoteCtnt) {
		this.srchTrfNo = srchTrfNo;
		this.srchTrfPfxCd = srchTrfPfxCd;
		this.srchTriRqstOfcCd = srchTriRqstOfcCd;
		this.srchPropStsCd = srchPropStsCd;
		this.srchCurrCd = srchCurrCd;
		this.srchCmdtCd = srchCmdtCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.srchAccDt = srchAccDt;
		this.srchTaaNo = srchTaaNo;
		this.srchPrcCgoTpCd = srchPrcCgoTpCd;
		this.srchTriPropNo = srchTriPropNo;
		this.srchAcsDt = srchAcsDt;
		this.srchIsGriAppl = srchIsGriAppl;
		this.srchEffDt = srchEffDt;
		this.srchTriAproOfcCd = srchTriAproOfcCd;
		this.srchAction = srchAction;
		this.srchOrgRoutViaPortNm = srchOrgRoutViaPortNm;
		this.srchTriNo = srchTriNo;
		this.srchGriEffDt = srchGriEffDt;
		this.srchExpDt = srchExpDt;
		this.srchDestRoutPntLocNm = srchDestRoutPntLocNm;
		this.srchOrgRoutPntLocNm = srchOrgRoutPntLocNm;
		this.srchRatUtCd = srchRatUtCd;
		this.srchDestRoutViaPortNm = srchDestRoutViaPortNm;
		this.srchNoteCtnt = srchNoteCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("srch_trf_no", getSrchTrfNo());
		this.hashColumns.put("srch_trf_pfx_cd", getSrchTrfPfxCd());
		this.hashColumns.put("srch_tri_rqst_ofc_cd", getSrchTriRqstOfcCd());
		this.hashColumns.put("srch_prop_sts_cd", getSrchPropStsCd());
		this.hashColumns.put("srch_curr_cd", getSrchCurrCd());
		this.hashColumns.put("srch_cmdt_cd", getSrchCmdtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("srch_acc_dt", getSrchAccDt());
		this.hashColumns.put("srch_taa_no", getSrchTaaNo());
		this.hashColumns.put("srch_prc_cgo_tp_cd", getSrchPrcCgoTpCd());
		this.hashColumns.put("srch_tri_prop_no", getSrchTriPropNo());
		this.hashColumns.put("srch_acs_dt", getSrchAcsDt());
		this.hashColumns.put("srch_is_gri_appl", getSrchIsGriAppl());
		this.hashColumns.put("srch_eff_dt", getSrchEffDt());
		this.hashColumns.put("srch_tri_apro_ofc_cd", getSrchTriAproOfcCd());
		this.hashColumns.put("srch_action", getSrchAction());
		this.hashColumns.put("srch_org_rout_via_port_nm", getSrchOrgRoutViaPortNm());
		this.hashColumns.put("srch_tri_no", getSrchTriNo());
		this.hashColumns.put("srch_gri_eff_dt", getSrchGriEffDt());
		this.hashColumns.put("srch_exp_dt", getSrchExpDt());
		this.hashColumns.put("srch_dest_rout_pnt_loc_nm", getSrchDestRoutPntLocNm());
		this.hashColumns.put("srch_org_rout_pnt_loc_nm", getSrchOrgRoutPntLocNm());
		this.hashColumns.put("srch_rat_ut_cd", getSrchRatUtCd());
		this.hashColumns.put("srch_dest_rout_via_port_nm", getSrchDestRoutViaPortNm());
		this.hashColumns.put("srch_note_ctnt", getSrchNoteCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("srch_trf_no", "srchTrfNo");
		this.hashFields.put("srch_trf_pfx_cd", "srchTrfPfxCd");
		this.hashFields.put("srch_tri_rqst_ofc_cd", "srchTriRqstOfcCd");
		this.hashFields.put("srch_prop_sts_cd", "srchPropStsCd");
		this.hashFields.put("srch_curr_cd", "srchCurrCd");
		this.hashFields.put("srch_cmdt_cd", "srchCmdtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("srch_acc_dt", "srchAccDt");
		this.hashFields.put("srch_taa_no", "srchTaaNo");
		this.hashFields.put("srch_prc_cgo_tp_cd", "srchPrcCgoTpCd");
		this.hashFields.put("srch_tri_prop_no", "srchTriPropNo");
		this.hashFields.put("srch_acs_dt", "srchAcsDt");
		this.hashFields.put("srch_is_gri_appl", "srchIsGriAppl");
		this.hashFields.put("srch_eff_dt", "srchEffDt");
		this.hashFields.put("srch_tri_apro_ofc_cd", "srchTriAproOfcCd");
		this.hashFields.put("srch_action", "srchAction");
		this.hashFields.put("srch_org_rout_via_port_nm", "srchOrgRoutViaPortNm");
		this.hashFields.put("srch_tri_no", "srchTriNo");
		this.hashFields.put("srch_gri_eff_dt", "srchGriEffDt");
		this.hashFields.put("srch_exp_dt", "srchExpDt");
		this.hashFields.put("srch_dest_rout_pnt_loc_nm", "srchDestRoutPntLocNm");
		this.hashFields.put("srch_org_rout_pnt_loc_nm", "srchOrgRoutPntLocNm");
		this.hashFields.put("srch_rat_ut_cd", "srchRatUtCd");
		this.hashFields.put("srch_dest_rout_via_port_nm", "srchDestRoutViaPortNm");
		this.hashFields.put("srch_note_ctnt", "srchNoteCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return srchTrfNo
	 */
	public String getSrchTrfNo() {
		return this.srchTrfNo;
	}
	
	/**
	 * Column Info
	 * @return srchTrfPfxCd
	 */
	public String getSrchTrfPfxCd() {
		return this.srchTrfPfxCd;
	}
	
	/**
	 * Column Info
	 * @return srchTriRqstOfcCd
	 */
	public String getSrchTriRqstOfcCd() {
		return this.srchTriRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return srchPropStsCd
	 */
	public String getSrchPropStsCd() {
		return this.srchPropStsCd;
	}
	
	/**
	 * Column Info
	 * @return srchCurrCd
	 */
	public String getSrchCurrCd() {
		return this.srchCurrCd;
	}
	
	/**
	 * Column Info
	 * @return srchCmdtCd
	 */
	public String getSrchCmdtCd() {
		return this.srchCmdtCd;
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
	 * @return srchAccDt
	 */
	public String getSrchAccDt() {
		return this.srchAccDt;
	}
	
	/**
	 * Column Info
	 * @return srchTaaNo
	 */
	public String getSrchTaaNo() {
		return this.srchTaaNo;
	}
	
	/**
	 * Column Info
	 * @return srchPrcCgoTpCd
	 */
	public String getSrchPrcCgoTpCd() {
		return this.srchPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return srchTriPropNo
	 */
	public String getSrchTriPropNo() {
		return this.srchTriPropNo;
	}
	
	/**
	 * Column Info
	 * @return srchAcsDt
	 */
	public String getSrchAcsDt() {
		return this.srchAcsDt;
	}
	
	/**
	 * Column Info
	 * @return srchIsGriAppl
	 */
	public String getSrchIsGriAppl() {
		return this.srchIsGriAppl;
	}
	
	/**
	 * Column Info
	 * @return srchEffDt
	 */
	public String getSrchEffDt() {
		return this.srchEffDt;
	}
	
	/**
	 * Column Info
	 * @return srchTriAproOfcCd
	 */
	public String getSrchTriAproOfcCd() {
		return this.srchTriAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return srchAction
	 */
	public String getSrchAction() {
		return this.srchAction;
	}
	
	/**
	 * Column Info
	 * @return srchOrgRoutViaPortNm
	 */
	public String getSrchOrgRoutViaPortNm() {
		return this.srchOrgRoutViaPortNm;
	}
	
	/**
	 * Column Info
	 * @return srchTriNo
	 */
	public String getSrchTriNo() {
		return this.srchTriNo;
	}
	
	/**
	 * Column Info
	 * @return srchGriEffDt
	 */
	public String getSrchGriEffDt() {
		return this.srchGriEffDt;
	}
	
	/**
	 * Column Info
	 * @return srchExpDt
	 */
	public String getSrchExpDt() {
		return this.srchExpDt;
	}
	
	/**
	 * Column Info
	 * @return srchDestRoutPntLocNm
	 */
	public String getSrchDestRoutPntLocNm() {
		return this.srchDestRoutPntLocNm;
	}
	
	/**
	 * Column Info
	 * @return srchOrgRoutPntLocNm
	 */
	public String getSrchOrgRoutPntLocNm() {
		return this.srchOrgRoutPntLocNm;
	}
	
	/**
	 * Column Info
	 * @return srchRatUtCd
	 */
	public String getSrchRatUtCd() {
		return this.srchRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return srchDestRoutViaPortNm
	 */
	public String getSrchDestRoutViaPortNm() {
		return this.srchDestRoutViaPortNm;
	}
	
	/**
	 * Column Info
	 * @return srchNoteCtnt
	 */
	public String getSrchNoteCtnt() {
		return this.srchNoteCtnt;
	}
	

	/**
	 * Column Info
	 * @param srchTrfNo
	 */
	public void setSrchTrfNo(String srchTrfNo) {
		this.srchTrfNo = srchTrfNo;
	}
	
	/**
	 * Column Info
	 * @param srchTrfPfxCd
	 */
	public void setSrchTrfPfxCd(String srchTrfPfxCd) {
		this.srchTrfPfxCd = srchTrfPfxCd;
	}
	
	/**
	 * Column Info
	 * @param srchTriRqstOfcCd
	 */
	public void setSrchTriRqstOfcCd(String srchTriRqstOfcCd) {
		this.srchTriRqstOfcCd = srchTriRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param srchPropStsCd
	 */
	public void setSrchPropStsCd(String srchPropStsCd) {
		this.srchPropStsCd = srchPropStsCd;
	}
	
	/**
	 * Column Info
	 * @param srchCurrCd
	 */
	public void setSrchCurrCd(String srchCurrCd) {
		this.srchCurrCd = srchCurrCd;
	}
	
	/**
	 * Column Info
	 * @param srchCmdtCd
	 */
	public void setSrchCmdtCd(String srchCmdtCd) {
		this.srchCmdtCd = srchCmdtCd;
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
	 * @param srchAccDt
	 */
	public void setSrchAccDt(String srchAccDt) {
		this.srchAccDt = srchAccDt;
	}
	
	/**
	 * Column Info
	 * @param srchTaaNo
	 */
	public void setSrchTaaNo(String srchTaaNo) {
		this.srchTaaNo = srchTaaNo;
	}
	
	/**
	 * Column Info
	 * @param srchPrcCgoTpCd
	 */
	public void setSrchPrcCgoTpCd(String srchPrcCgoTpCd) {
		this.srchPrcCgoTpCd = srchPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param srchTriPropNo
	 */
	public void setSrchTriPropNo(String srchTriPropNo) {
		this.srchTriPropNo = srchTriPropNo;
	}
	
	/**
	 * Column Info
	 * @param srchAcsDt
	 */
	public void setSrchAcsDt(String srchAcsDt) {
		this.srchAcsDt = srchAcsDt;
	}
	
	/**
	 * Column Info
	 * @param srchIsGriAppl
	 */
	public void setSrchIsGriAppl(String srchIsGriAppl) {
		this.srchIsGriAppl = srchIsGriAppl;
	}
	
	/**
	 * Column Info
	 * @param srchEffDt
	 */
	public void setSrchEffDt(String srchEffDt) {
		this.srchEffDt = srchEffDt;
	}
	
	/**
	 * Column Info
	 * @param srchTriAproOfcCd
	 */
	public void setSrchTriAproOfcCd(String srchTriAproOfcCd) {
		this.srchTriAproOfcCd = srchTriAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param srchAction
	 */
	public void setSrchAction(String srchAction) {
		this.srchAction = srchAction;
	}
	
	/**
	 * Column Info
	 * @param srchOrgRoutViaPortNm
	 */
	public void setSrchOrgRoutViaPortNm(String srchOrgRoutViaPortNm) {
		this.srchOrgRoutViaPortNm = srchOrgRoutViaPortNm;
	}
	
	/**
	 * Column Info
	 * @param srchTriNo
	 */
	public void setSrchTriNo(String srchTriNo) {
		this.srchTriNo = srchTriNo;
	}
	
	/**
	 * Column Info
	 * @param srchGriEffDt
	 */
	public void setSrchGriEffDt(String srchGriEffDt) {
		this.srchGriEffDt = srchGriEffDt;
	}
	
	/**
	 * Column Info
	 * @param srchExpDt
	 */
	public void setSrchExpDt(String srchExpDt) {
		this.srchExpDt = srchExpDt;
	}
	
	/**
	 * Column Info
	 * @param srchDestRoutPntLocNm
	 */
	public void setSrchDestRoutPntLocNm(String srchDestRoutPntLocNm) {
		this.srchDestRoutPntLocNm = srchDestRoutPntLocNm;
	}
	
	/**
	 * Column Info
	 * @param srchOrgRoutPntLocNm
	 */
	public void setSrchOrgRoutPntLocNm(String srchOrgRoutPntLocNm) {
		this.srchOrgRoutPntLocNm = srchOrgRoutPntLocNm;
	}
	
	/**
	 * Column Info
	 * @param srchRatUtCd
	 */
	public void setSrchRatUtCd(String srchRatUtCd) {
		this.srchRatUtCd = srchRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param srchDestRoutViaPortNm
	 */
	public void setSrchDestRoutViaPortNm(String srchDestRoutViaPortNm) {
		this.srchDestRoutViaPortNm = srchDestRoutViaPortNm;
	}
	
	/**
	 * Column Info
	 * @param srchNoteCtnt
	 */
	public void setSrchNoteCtnt(String srchNoteCtnt) {
		this.srchNoteCtnt = srchNoteCtnt;
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
		setSrchTrfNo(JSPUtil.getParameter(request, prefix + "srch_trf_no", ""));
		setSrchTrfPfxCd(JSPUtil.getParameter(request, prefix + "srch_trf_pfx_cd", ""));
		setSrchTriRqstOfcCd(JSPUtil.getParameter(request, prefix + "srch_tri_rqst_ofc_cd", ""));
		setSrchPropStsCd(JSPUtil.getParameter(request, prefix + "srch_prop_sts_cd", ""));
		setSrchCurrCd(JSPUtil.getParameter(request, prefix + "srch_curr_cd", ""));
		setSrchCmdtCd(JSPUtil.getParameter(request, prefix + "srch_cmdt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrchAccDt(JSPUtil.getParameter(request, prefix + "srch_acc_dt", ""));
		setSrchTaaNo(JSPUtil.getParameter(request, prefix + "srch_taa_no", ""));
		setSrchPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "srch_prc_cgo_tp_cd", ""));
		setSrchTriPropNo(JSPUtil.getParameter(request, prefix + "srch_tri_prop_no", ""));
		setSrchAcsDt(JSPUtil.getParameter(request, prefix + "srch_acs_dt", ""));
		setSrchIsGriAppl(JSPUtil.getParameter(request, prefix + "srch_is_gri_appl", ""));
		setSrchEffDt(JSPUtil.getParameter(request, prefix + "srch_eff_dt", ""));
		setSrchTriAproOfcCd(JSPUtil.getParameter(request, prefix + "srch_tri_apro_ofc_cd", ""));
		setSrchAction(JSPUtil.getParameter(request, prefix + "srch_action", ""));
		setSrchOrgRoutViaPortNm(JSPUtil.getParameter(request, prefix + "srch_org_rout_via_port_nm", ""));
		setSrchTriNo(JSPUtil.getParameter(request, prefix + "srch_tri_no", ""));
		setSrchGriEffDt(JSPUtil.getParameter(request, prefix + "srch_gri_eff_dt", ""));
		setSrchExpDt(JSPUtil.getParameter(request, prefix + "srch_exp_dt", ""));
		setSrchDestRoutPntLocNm(JSPUtil.getParameter(request, prefix + "srch_dest_rout_pnt_loc_nm", ""));
		setSrchOrgRoutPntLocNm(JSPUtil.getParameter(request, prefix + "srch_org_rout_pnt_loc_nm", ""));
		setSrchRatUtCd(JSPUtil.getParameter(request, prefix + "srch_rat_ut_cd", ""));
		setSrchDestRoutViaPortNm(JSPUtil.getParameter(request, prefix + "srch_dest_rout_via_port_nm", ""));
		setSrchNoteCtnt(JSPUtil.getParameter(request, prefix + "srch_note_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TriPropParamVO[]
	 */
	public TriPropParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TriPropParamVO[]
	 */
	public TriPropParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TriPropParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] srchTrfNo = (JSPUtil.getParameter(request, prefix	+ "srch_trf_no", length));
			String[] srchTrfPfxCd = (JSPUtil.getParameter(request, prefix	+ "srch_trf_pfx_cd", length));
			String[] srchTriRqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "srch_tri_rqst_ofc_cd", length));
			String[] srchPropStsCd = (JSPUtil.getParameter(request, prefix	+ "srch_prop_sts_cd", length));
			String[] srchCurrCd = (JSPUtil.getParameter(request, prefix	+ "srch_curr_cd", length));
			String[] srchCmdtCd = (JSPUtil.getParameter(request, prefix	+ "srch_cmdt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srchAccDt = (JSPUtil.getParameter(request, prefix	+ "srch_acc_dt", length));
			String[] srchTaaNo = (JSPUtil.getParameter(request, prefix	+ "srch_taa_no", length));
			String[] srchPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "srch_prc_cgo_tp_cd", length));
			String[] srchTriPropNo = (JSPUtil.getParameter(request, prefix	+ "srch_tri_prop_no", length));
			String[] srchAcsDt = (JSPUtil.getParameter(request, prefix	+ "srch_acs_dt", length));
			String[] srchIsGriAppl = (JSPUtil.getParameter(request, prefix	+ "srch_is_gri_appl", length));
			String[] srchEffDt = (JSPUtil.getParameter(request, prefix	+ "srch_eff_dt", length));
			String[] srchTriAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "srch_tri_apro_ofc_cd", length));
			String[] srchAction = (JSPUtil.getParameter(request, prefix	+ "srch_action", length));
			String[] srchOrgRoutViaPortNm = (JSPUtil.getParameter(request, prefix	+ "srch_org_rout_via_port_nm", length));
			String[] srchTriNo = (JSPUtil.getParameter(request, prefix	+ "srch_tri_no", length));
			String[] srchGriEffDt = (JSPUtil.getParameter(request, prefix	+ "srch_gri_eff_dt", length));
			String[] srchExpDt = (JSPUtil.getParameter(request, prefix	+ "srch_exp_dt", length));
			String[] srchDestRoutPntLocNm = (JSPUtil.getParameter(request, prefix	+ "srch_dest_rout_pnt_loc_nm", length));
			String[] srchOrgRoutPntLocNm = (JSPUtil.getParameter(request, prefix	+ "srch_org_rout_pnt_loc_nm", length));
			String[] srchRatUtCd = (JSPUtil.getParameter(request, prefix	+ "srch_rat_ut_cd", length));
			String[] srchDestRoutViaPortNm = (JSPUtil.getParameter(request, prefix	+ "srch_dest_rout_via_port_nm", length));
			String[] srchNoteCtnt = (JSPUtil.getParameter(request, prefix	+ "srch_note_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new TriPropParamVO();
				if (srchTrfNo[i] != null)
					model.setSrchTrfNo(srchTrfNo[i]);
				if (srchTrfPfxCd[i] != null)
					model.setSrchTrfPfxCd(srchTrfPfxCd[i]);
				if (srchTriRqstOfcCd[i] != null)
					model.setSrchTriRqstOfcCd(srchTriRqstOfcCd[i]);
				if (srchPropStsCd[i] != null)
					model.setSrchPropStsCd(srchPropStsCd[i]);
				if (srchCurrCd[i] != null)
					model.setSrchCurrCd(srchCurrCd[i]);
				if (srchCmdtCd[i] != null)
					model.setSrchCmdtCd(srchCmdtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srchAccDt[i] != null)
					model.setSrchAccDt(srchAccDt[i]);
				if (srchTaaNo[i] != null)
					model.setSrchTaaNo(srchTaaNo[i]);
				if (srchPrcCgoTpCd[i] != null)
					model.setSrchPrcCgoTpCd(srchPrcCgoTpCd[i]);
				if (srchTriPropNo[i] != null)
					model.setSrchTriPropNo(srchTriPropNo[i]);
				if (srchAcsDt[i] != null)
					model.setSrchAcsDt(srchAcsDt[i]);
				if (srchIsGriAppl[i] != null)
					model.setSrchIsGriAppl(srchIsGriAppl[i]);
				if (srchEffDt[i] != null)
					model.setSrchEffDt(srchEffDt[i]);
				if (srchTriAproOfcCd[i] != null)
					model.setSrchTriAproOfcCd(srchTriAproOfcCd[i]);
				if (srchAction[i] != null)
					model.setSrchAction(srchAction[i]);
				if (srchOrgRoutViaPortNm[i] != null)
					model.setSrchOrgRoutViaPortNm(srchOrgRoutViaPortNm[i]);
				if (srchTriNo[i] != null)
					model.setSrchTriNo(srchTriNo[i]);
				if (srchGriEffDt[i] != null)
					model.setSrchGriEffDt(srchGriEffDt[i]);
				if (srchExpDt[i] != null)
					model.setSrchExpDt(srchExpDt[i]);
				if (srchDestRoutPntLocNm[i] != null)
					model.setSrchDestRoutPntLocNm(srchDestRoutPntLocNm[i]);
				if (srchOrgRoutPntLocNm[i] != null)
					model.setSrchOrgRoutPntLocNm(srchOrgRoutPntLocNm[i]);
				if (srchRatUtCd[i] != null)
					model.setSrchRatUtCd(srchRatUtCd[i]);
				if (srchDestRoutViaPortNm[i] != null)
					model.setSrchDestRoutViaPortNm(srchDestRoutViaPortNm[i]);
				if (srchNoteCtnt[i] != null)
					model.setSrchNoteCtnt(srchNoteCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTriPropParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TriPropParamVO[]
	 */
	public TriPropParamVO[] getTriPropParamVOs(){
		TriPropParamVO[] vos = (TriPropParamVO[])models.toArray(new TriPropParamVO[models.size()]);
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
		this.srchTrfNo = this.srchTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchTrfPfxCd = this.srchTrfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchTriRqstOfcCd = this.srchTriRqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchPropStsCd = this.srchPropStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchCurrCd = this.srchCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchCmdtCd = this.srchCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchAccDt = this.srchAccDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchTaaNo = this.srchTaaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchPrcCgoTpCd = this.srchPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchTriPropNo = this.srchTriPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchAcsDt = this.srchAcsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchIsGriAppl = this.srchIsGriAppl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchEffDt = this.srchEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchTriAproOfcCd = this.srchTriAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchAction = this.srchAction .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchOrgRoutViaPortNm = this.srchOrgRoutViaPortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchTriNo = this.srchTriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchGriEffDt = this.srchGriEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchExpDt = this.srchExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchDestRoutPntLocNm = this.srchDestRoutPntLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchOrgRoutPntLocNm = this.srchOrgRoutPntLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchRatUtCd = this.srchRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchDestRoutViaPortNm = this.srchDestRoutViaPortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchNoteCtnt = this.srchNoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
