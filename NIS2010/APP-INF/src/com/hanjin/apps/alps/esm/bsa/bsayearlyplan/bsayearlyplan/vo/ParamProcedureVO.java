/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ParamProcedureVO.java
*@FileTitle : ParamProcedureVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.01.25 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ParamProcedureVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ParamProcedureVO> models = new ArrayList<ParamProcedureVO>();
	
	/* Column Info */
	private String pErrorCode = null;
	/* Column Info */
	private String pFmWk = null;
	/* Column Info */
	private String pDirCd = null;
	/* Column Info */
	private String inDuration = null;
	/* Column Info */
	private String inTrdCd = null;
	/* Column Info */
	private String inRlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pErrMsg = null;
	/* Column Info */
	private String inYear = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pToWk = null;
	/* Column Info */
	private String pErrCd = null;
	/* Column Info */
	private String inFmWk = null;
	/* Column Info */
	private String pErrorMsg = null;
	/* Column Info */
	private String inUserId = null;
	/* Column Info */
	private String pVslCd = null;
	/* Column Info */
	private String pUsrId = null;
	/* Column Info */
	private String inSkdVoyNo = null;
	/* Column Info */
	private String inIocCd = null;
	/* Column Info */
	private String inVslCd = null;
	/* Column Info */
	private String pSkdVoyNo = null;
	/* Column Info */
	private String inDirCd = null;
	/* Column Info */
	private String pYear = null;
	/* Column Info */
	private String pIocCd = null;
	/* Column Info */
	private String pRlaneCd = null;
	/* Column Info */
	private String pTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ParamProcedureVO() {}

	public ParamProcedureVO(String ibflag, String pagerows, String inDirCd, String inDuration, String inFmWk, String inIocCd, String inRlaneCd, String inSkdVoyNo, String inTrdCd, String inUserId, String inVslCd, String inYear, String pDirCd, String pErrCd, String pErrMsg, String pErrorCode, String pErrorMsg, String pFmWk, String pIocCd, String pRlaneCd, String pSkdVoyNo, String pToWk, String pTrdCd, String pUsrId, String pVslCd, String pYear) {
		this.pErrorCode = pErrorCode;
		this.pFmWk = pFmWk;
		this.pDirCd = pDirCd;
		this.inDuration = inDuration;
		this.inTrdCd = inTrdCd;
		this.inRlaneCd = inRlaneCd;
		this.pagerows = pagerows;
		this.pErrMsg = pErrMsg;
		this.inYear = inYear;
		this.ibflag = ibflag;
		this.pToWk = pToWk;
		this.pErrCd = pErrCd;
		this.inFmWk = inFmWk;
		this.pErrorMsg = pErrorMsg;
		this.inUserId = inUserId;
		this.pVslCd = pVslCd;
		this.pUsrId = pUsrId;
		this.inSkdVoyNo = inSkdVoyNo;
		this.inIocCd = inIocCd;
		this.inVslCd = inVslCd;
		this.pSkdVoyNo = pSkdVoyNo;
		this.inDirCd = inDirCd;
		this.pYear = pYear;
		this.pIocCd = pIocCd;
		this.pRlaneCd = pRlaneCd;
		this.pTrdCd = pTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p_error_code", getPErrorCode());
		this.hashColumns.put("p_fm_wk", getPFmWk());
		this.hashColumns.put("p_dir_cd", getPDirCd());
		this.hashColumns.put("in_duration", getInDuration());
		this.hashColumns.put("in_trd_cd", getInTrdCd());
		this.hashColumns.put("in_rlane_cd", getInRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_err_msg", getPErrMsg());
		this.hashColumns.put("in_year", getInYear());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_to_wk", getPToWk());
		this.hashColumns.put("p_err_cd", getPErrCd());
		this.hashColumns.put("in_fm_wk", getInFmWk());
		this.hashColumns.put("p_error_msg", getPErrorMsg());
		this.hashColumns.put("in_user_id", getInUserId());
		this.hashColumns.put("p_vsl_cd", getPVslCd());
		this.hashColumns.put("p_usr_id", getPUsrId());
		this.hashColumns.put("in_skd_voy_no", getInSkdVoyNo());
		this.hashColumns.put("in_ioc_cd", getInIocCd());
		this.hashColumns.put("in_vsl_cd", getInVslCd());
		this.hashColumns.put("p_skd_voy_no", getPSkdVoyNo());
		this.hashColumns.put("in_dir_cd", getInDirCd());
		this.hashColumns.put("p_year", getPYear());
		this.hashColumns.put("p_ioc_cd", getPIocCd());
		this.hashColumns.put("p_rlane_cd", getPRlaneCd());
		this.hashColumns.put("p_trd_cd", getPTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p_error_code", "pErrorCode");
		this.hashFields.put("p_fm_wk", "pFmWk");
		this.hashFields.put("p_dir_cd", "pDirCd");
		this.hashFields.put("in_duration", "inDuration");
		this.hashFields.put("in_trd_cd", "inTrdCd");
		this.hashFields.put("in_rlane_cd", "inRlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_err_msg", "pErrMsg");
		this.hashFields.put("in_year", "inYear");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_to_wk", "pToWk");
		this.hashFields.put("p_err_cd", "pErrCd");
		this.hashFields.put("in_fm_wk", "inFmWk");
		this.hashFields.put("p_error_msg", "pErrorMsg");
		this.hashFields.put("in_user_id", "inUserId");
		this.hashFields.put("p_vsl_cd", "pVslCd");
		this.hashFields.put("p_usr_id", "pUsrId");
		this.hashFields.put("in_skd_voy_no", "inSkdVoyNo");
		this.hashFields.put("in_ioc_cd", "inIocCd");
		this.hashFields.put("in_vsl_cd", "inVslCd");
		this.hashFields.put("p_skd_voy_no", "pSkdVoyNo");
		this.hashFields.put("in_dir_cd", "inDirCd");
		this.hashFields.put("p_year", "pYear");
		this.hashFields.put("p_ioc_cd", "pIocCd");
		this.hashFields.put("p_rlane_cd", "pRlaneCd");
		this.hashFields.put("p_trd_cd", "pTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pErrorCode
	 */
	public String getPErrorCode() {
		return this.pErrorCode;
	}
	
	/**
	 * Column Info
	 * @return pFmWk
	 */
	public String getPFmWk() {
		return this.pFmWk;
	}
	
	/**
	 * Column Info
	 * @return pDirCd
	 */
	public String getPDirCd() {
		return this.pDirCd;
	}
	
	/**
	 * Column Info
	 * @return inDuration
	 */
	public String getInDuration() {
		return this.inDuration;
	}
	
	/**
	 * Column Info
	 * @return inTrdCd
	 */
	public String getInTrdCd() {
		return this.inTrdCd;
	}
	
	/**
	 * Column Info
	 * @return inRlaneCd
	 */
	public String getInRlaneCd() {
		return this.inRlaneCd;
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
	 * @return pErrMsg
	 */
	public String getPErrMsg() {
		return this.pErrMsg;
	}
	
	/**
	 * Column Info
	 * @return inYear
	 */
	public String getInYear() {
		return this.inYear;
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
	 * @return pToWk
	 */
	public String getPToWk() {
		return this.pToWk;
	}
	
	/**
	 * Column Info
	 * @return pErrCd
	 */
	public String getPErrCd() {
		return this.pErrCd;
	}
	
	/**
	 * Column Info
	 * @return inFmWk
	 */
	public String getInFmWk() {
		return this.inFmWk;
	}
	
	/**
	 * Column Info
	 * @return pErrorMsg
	 */
	public String getPErrorMsg() {
		return this.pErrorMsg;
	}
	
	/**
	 * Column Info
	 * @return inUserId
	 */
	public String getInUserId() {
		return this.inUserId;
	}
	
	/**
	 * Column Info
	 * @return pVslCd
	 */
	public String getPVslCd() {
		return this.pVslCd;
	}
	
	/**
	 * Column Info
	 * @return pUsrId
	 */
	public String getPUsrId() {
		return this.pUsrId;
	}
	
	/**
	 * Column Info
	 * @return inSkdVoyNo
	 */
	public String getInSkdVoyNo() {
		return this.inSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return inIocCd
	 */
	public String getInIocCd() {
		return this.inIocCd;
	}
	
	/**
	 * Column Info
	 * @return inVslCd
	 */
	public String getInVslCd() {
		return this.inVslCd;
	}
	
	/**
	 * Column Info
	 * @return pSkdVoyNo
	 */
	public String getPSkdVoyNo() {
		return this.pSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return inDirCd
	 */
	public String getInDirCd() {
		return this.inDirCd;
	}
	
	/**
	 * Column Info
	 * @return pYear
	 */
	public String getPYear() {
		return this.pYear;
	}
	
	/**
	 * Column Info
	 * @return pIocCd
	 */
	public String getPIocCd() {
		return this.pIocCd;
	}
	
	/**
	 * Column Info
	 * @return pRlaneCd
	 */
	public String getPRlaneCd() {
		return this.pRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return pTrdCd
	 */
	public String getPTrdCd() {
		return this.pTrdCd;
	}
	

	/**
	 * Column Info
	 * @param pErrorCode
	 */
	public void setPErrorCode(String pErrorCode) {
		this.pErrorCode = pErrorCode;
	}
	
	/**
	 * Column Info
	 * @param pFmWk
	 */
	public void setPFmWk(String pFmWk) {
		this.pFmWk = pFmWk;
	}
	
	/**
	 * Column Info
	 * @param pDirCd
	 */
	public void setPDirCd(String pDirCd) {
		this.pDirCd = pDirCd;
	}
	
	/**
	 * Column Info
	 * @param inDuration
	 */
	public void setInDuration(String inDuration) {
		this.inDuration = inDuration;
	}
	
	/**
	 * Column Info
	 * @param inTrdCd
	 */
	public void setInTrdCd(String inTrdCd) {
		this.inTrdCd = inTrdCd;
	}
	
	/**
	 * Column Info
	 * @param inRlaneCd
	 */
	public void setInRlaneCd(String inRlaneCd) {
		this.inRlaneCd = inRlaneCd;
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
	 * @param pErrMsg
	 */
	public void setPErrMsg(String pErrMsg) {
		this.pErrMsg = pErrMsg;
	}
	
	/**
	 * Column Info
	 * @param inYear
	 */
	public void setInYear(String inYear) {
		this.inYear = inYear;
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
	 * @param pToWk
	 */
	public void setPToWk(String pToWk) {
		this.pToWk = pToWk;
	}
	
	/**
	 * Column Info
	 * @param pErrCd
	 */
	public void setPErrCd(String pErrCd) {
		this.pErrCd = pErrCd;
	}
	
	/**
	 * Column Info
	 * @param inFmWk
	 */
	public void setInFmWk(String inFmWk) {
		this.inFmWk = inFmWk;
	}
	
	/**
	 * Column Info
	 * @param pErrorMsg
	 */
	public void setPErrorMsg(String pErrorMsg) {
		this.pErrorMsg = pErrorMsg;
	}
	
	/**
	 * Column Info
	 * @param inUserId
	 */
	public void setInUserId(String inUserId) {
		this.inUserId = inUserId;
	}
	
	/**
	 * Column Info
	 * @param pVslCd
	 */
	public void setPVslCd(String pVslCd) {
		this.pVslCd = pVslCd;
	}
	
	/**
	 * Column Info
	 * @param pUsrId
	 */
	public void setPUsrId(String pUsrId) {
		this.pUsrId = pUsrId;
	}
	
	/**
	 * Column Info
	 * @param inSkdVoyNo
	 */
	public void setInSkdVoyNo(String inSkdVoyNo) {
		this.inSkdVoyNo = inSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param inIocCd
	 */
	public void setInIocCd(String inIocCd) {
		this.inIocCd = inIocCd;
	}
	
	/**
	 * Column Info
	 * @param inVslCd
	 */
	public void setInVslCd(String inVslCd) {
		this.inVslCd = inVslCd;
	}
	
	/**
	 * Column Info
	 * @param pSkdVoyNo
	 */
	public void setPSkdVoyNo(String pSkdVoyNo) {
		this.pSkdVoyNo = pSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param inDirCd
	 */
	public void setInDirCd(String inDirCd) {
		this.inDirCd = inDirCd;
	}
	
	/**
	 * Column Info
	 * @param pYear
	 */
	public void setPYear(String pYear) {
		this.pYear = pYear;
	}
	
	/**
	 * Column Info
	 * @param pIocCd
	 */
	public void setPIocCd(String pIocCd) {
		this.pIocCd = pIocCd;
	}
	
	/**
	 * Column Info
	 * @param pRlaneCd
	 */
	public void setPRlaneCd(String pRlaneCd) {
		this.pRlaneCd = pRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param pTrdCd
	 */
	public void setPTrdCd(String pTrdCd) {
		this.pTrdCd = pTrdCd;
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
		setPErrorCode(JSPUtil.getParameter(request, prefix + "p_error_code", ""));
		setPFmWk(JSPUtil.getParameter(request, prefix + "p_fm_wk", ""));
		setPDirCd(JSPUtil.getParameter(request, prefix + "p_dir_cd", ""));
		setInDuration(JSPUtil.getParameter(request, prefix + "in_duration", ""));
		setInTrdCd(JSPUtil.getParameter(request, prefix + "in_trd_cd", ""));
		setInRlaneCd(JSPUtil.getParameter(request, prefix + "in_rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPErrMsg(JSPUtil.getParameter(request, prefix + "p_err_msg", ""));
		setInYear(JSPUtil.getParameter(request, prefix + "in_year", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPToWk(JSPUtil.getParameter(request, prefix + "p_to_wk", ""));
		setPErrCd(JSPUtil.getParameter(request, prefix + "p_err_cd", ""));
		setInFmWk(JSPUtil.getParameter(request, prefix + "in_fm_wk", ""));
		setPErrorMsg(JSPUtil.getParameter(request, prefix + "p_error_msg", ""));
		setInUserId(JSPUtil.getParameter(request, prefix + "in_user_id", ""));
		setPVslCd(JSPUtil.getParameter(request, prefix + "p_vsl_cd", ""));
		setPUsrId(JSPUtil.getParameter(request, prefix + "p_usr_id", ""));
		setInSkdVoyNo(JSPUtil.getParameter(request, prefix + "in_skd_voy_no", ""));
		setInIocCd(JSPUtil.getParameter(request, prefix + "in_ioc_cd", ""));
		setInVslCd(JSPUtil.getParameter(request, prefix + "in_vsl_cd", ""));
		setPSkdVoyNo(JSPUtil.getParameter(request, prefix + "p_skd_voy_no", ""));
		setInDirCd(JSPUtil.getParameter(request, prefix + "in_dir_cd", ""));
		setPYear(JSPUtil.getParameter(request, prefix + "p_year", ""));
		setPIocCd(JSPUtil.getParameter(request, prefix + "p_ioc_cd", ""));
		setPRlaneCd(JSPUtil.getParameter(request, prefix + "p_rlane_cd", ""));
		setPTrdCd(JSPUtil.getParameter(request, prefix + "p_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ParamProcedureVO[]
	 */
	public ParamProcedureVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ParamProcedureVO[]
	 */
	public ParamProcedureVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ParamProcedureVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pErrorCode = (JSPUtil.getParameter(request, prefix	+ "p_error_code", length));
			String[] pFmWk = (JSPUtil.getParameter(request, prefix	+ "p_fm_wk", length));
			String[] pDirCd = (JSPUtil.getParameter(request, prefix	+ "p_dir_cd", length));
			String[] inDuration = (JSPUtil.getParameter(request, prefix	+ "in_duration", length));
			String[] inTrdCd = (JSPUtil.getParameter(request, prefix	+ "in_trd_cd", length));
			String[] inRlaneCd = (JSPUtil.getParameter(request, prefix	+ "in_rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pErrMsg = (JSPUtil.getParameter(request, prefix	+ "p_err_msg", length));
			String[] inYear = (JSPUtil.getParameter(request, prefix	+ "in_year", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pToWk = (JSPUtil.getParameter(request, prefix	+ "p_to_wk", length));
			String[] pErrCd = (JSPUtil.getParameter(request, prefix	+ "p_err_cd", length));
			String[] inFmWk = (JSPUtil.getParameter(request, prefix	+ "in_fm_wk", length));
			String[] pErrorMsg = (JSPUtil.getParameter(request, prefix	+ "p_error_msg", length));
			String[] inUserId = (JSPUtil.getParameter(request, prefix	+ "in_user_id", length));
			String[] pVslCd = (JSPUtil.getParameter(request, prefix	+ "p_vsl_cd", length));
			String[] pUsrId = (JSPUtil.getParameter(request, prefix	+ "p_usr_id", length));
			String[] inSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "in_skd_voy_no", length));
			String[] inIocCd = (JSPUtil.getParameter(request, prefix	+ "in_ioc_cd", length));
			String[] inVslCd = (JSPUtil.getParameter(request, prefix	+ "in_vsl_cd", length));
			String[] pSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "p_skd_voy_no", length));
			String[] inDirCd = (JSPUtil.getParameter(request, prefix	+ "in_dir_cd", length));
			String[] pYear = (JSPUtil.getParameter(request, prefix	+ "p_year", length));
			String[] pIocCd = (JSPUtil.getParameter(request, prefix	+ "p_ioc_cd", length));
			String[] pRlaneCd = (JSPUtil.getParameter(request, prefix	+ "p_rlane_cd", length));
			String[] pTrdCd = (JSPUtil.getParameter(request, prefix	+ "p_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ParamProcedureVO();
				if (pErrorCode[i] != null)
					model.setPErrorCode(pErrorCode[i]);
				if (pFmWk[i] != null)
					model.setPFmWk(pFmWk[i]);
				if (pDirCd[i] != null)
					model.setPDirCd(pDirCd[i]);
				if (inDuration[i] != null)
					model.setInDuration(inDuration[i]);
				if (inTrdCd[i] != null)
					model.setInTrdCd(inTrdCd[i]);
				if (inRlaneCd[i] != null)
					model.setInRlaneCd(inRlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pErrMsg[i] != null)
					model.setPErrMsg(pErrMsg[i]);
				if (inYear[i] != null)
					model.setInYear(inYear[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pToWk[i] != null)
					model.setPToWk(pToWk[i]);
				if (pErrCd[i] != null)
					model.setPErrCd(pErrCd[i]);
				if (inFmWk[i] != null)
					model.setInFmWk(inFmWk[i]);
				if (pErrorMsg[i] != null)
					model.setPErrorMsg(pErrorMsg[i]);
				if (inUserId[i] != null)
					model.setInUserId(inUserId[i]);
				if (pVslCd[i] != null)
					model.setPVslCd(pVslCd[i]);
				if (pUsrId[i] != null)
					model.setPUsrId(pUsrId[i]);
				if (inSkdVoyNo[i] != null)
					model.setInSkdVoyNo(inSkdVoyNo[i]);
				if (inIocCd[i] != null)
					model.setInIocCd(inIocCd[i]);
				if (inVslCd[i] != null)
					model.setInVslCd(inVslCd[i]);
				if (pSkdVoyNo[i] != null)
					model.setPSkdVoyNo(pSkdVoyNo[i]);
				if (inDirCd[i] != null)
					model.setInDirCd(inDirCd[i]);
				if (pYear[i] != null)
					model.setPYear(pYear[i]);
				if (pIocCd[i] != null)
					model.setPIocCd(pIocCd[i]);
				if (pRlaneCd[i] != null)
					model.setPRlaneCd(pRlaneCd[i]);
				if (pTrdCd[i] != null)
					model.setPTrdCd(pTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getParamProcedureVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ParamProcedureVO[]
	 */
	public ParamProcedureVO[] getParamProcedureVOs(){
		ParamProcedureVO[] vos = (ParamProcedureVO[])models.toArray(new ParamProcedureVO[models.size()]);
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
		this.pErrorCode = this.pErrorCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFmWk = this.pFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDirCd = this.pDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDuration = this.inDuration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTrdCd = this.inTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inRlaneCd = this.inRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pErrMsg = this.pErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inYear = this.inYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pToWk = this.pToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pErrCd = this.pErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inFmWk = this.inFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pErrorMsg = this.pErrorMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inUserId = this.inUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVslCd = this.pVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pUsrId = this.pUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdVoyNo = this.inSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inIocCd = this.inIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslCd = this.inVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSkdVoyNo = this.pSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDirCd = this.inDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYear = this.pYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIocCd = this.pIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pRlaneCd = this.pRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pTrdCd = this.pTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
