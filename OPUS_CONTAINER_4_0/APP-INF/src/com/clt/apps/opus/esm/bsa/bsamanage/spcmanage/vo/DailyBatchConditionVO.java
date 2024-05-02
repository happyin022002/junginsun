/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DailyBatchConditionVO.java
*@FileTitle : DailyBatchConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.11.23 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DailyBatchConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DailyBatchConditionVO> models = new ArrayList<DailyBatchConditionVO>();
	
	/* Column Info */
	private String pVslCd = null;
	/* Column Info */
	private String pDirCd = null;
	/* Column Info */
	private String pStep = null;
	/* Column Info */
	private String pBsa = null;
	/* Column Info */
	private String pDuration = null;
	/* Column Info */
	private String pSkdVoyNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pErrMsg = null;
	/* Column Info */
	private String pOnlyStep = null;
	/* Column Info */
	private String pYear = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pErrCd = null;
	/* Column Info */
	private String pIocCd = null;
	/* Column Info */
	private String pUserId = null;
	/* Column Info */
	private String pWeek = null;
	/* Column Info */
	private String pRlaneCd = null;
	/* Column Info */
	private String pTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DailyBatchConditionVO() {}

	public DailyBatchConditionVO(String ibflag, String pagerows, String pYear, String pWeek, String pDuration, String pStep, String pOnlyStep, String pBsa, String pTrdCd, String pRlaneCd, String pIocCd, String pVslCd, String pSkdVoyNo, String pDirCd, String pUserId, String pErrCd, String pErrMsg) {
		this.pVslCd = pVslCd;
		this.pDirCd = pDirCd;
		this.pStep = pStep;
		this.pBsa = pBsa;
		this.pDuration = pDuration;
		this.pSkdVoyNo = pSkdVoyNo;
		this.pagerows = pagerows;
		this.pErrMsg = pErrMsg;
		this.pOnlyStep = pOnlyStep;
		this.pYear = pYear;
		this.ibflag = ibflag;
		this.pErrCd = pErrCd;
		this.pIocCd = pIocCd;
		this.pUserId = pUserId;
		this.pWeek = pWeek;
		this.pRlaneCd = pRlaneCd;
		this.pTrdCd = pTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p_vsl_cd", getPVslCd());
		this.hashColumns.put("p_dir_cd", getPDirCd());
		this.hashColumns.put("p_step", getPStep());
		this.hashColumns.put("p_bsa", getPBsa());
		this.hashColumns.put("p_duration", getPDuration());
		this.hashColumns.put("p_skd_voy_no", getPSkdVoyNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_err_msg", getPErrMsg());
		this.hashColumns.put("p_only_step", getPOnlyStep());
		this.hashColumns.put("p_year", getPYear());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_err_cd", getPErrCd());
		this.hashColumns.put("p_ioc_cd", getPIocCd());
		this.hashColumns.put("p_user_id", getPUserId());
		this.hashColumns.put("p_week", getPWeek());
		this.hashColumns.put("p_rlane_cd", getPRlaneCd());
		this.hashColumns.put("p_trd_cd", getPTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p_vsl_cd", "pVslCd");
		this.hashFields.put("p_dir_cd", "pDirCd");
		this.hashFields.put("p_step", "pStep");
		this.hashFields.put("p_bsa", "pBsa");
		this.hashFields.put("p_duration", "pDuration");
		this.hashFields.put("p_skd_voy_no", "pSkdVoyNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_err_msg", "pErrMsg");
		this.hashFields.put("p_only_step", "pOnlyStep");
		this.hashFields.put("p_year", "pYear");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_err_cd", "pErrCd");
		this.hashFields.put("p_ioc_cd", "pIocCd");
		this.hashFields.put("p_user_id", "pUserId");
		this.hashFields.put("p_week", "pWeek");
		this.hashFields.put("p_rlane_cd", "pRlaneCd");
		this.hashFields.put("p_trd_cd", "pTrdCd");
		return this.hashFields;
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
	 * @return pDirCd
	 */
	public String getPDirCd() {
		return this.pDirCd;
	}
	
	/**
	 * Column Info
	 * @return pStep
	 */
	public String getPStep() {
		return this.pStep;
	}
	
	/**
	 * Column Info
	 * @return pBsa
	 */
	public String getPBsa() {
		return this.pBsa;
	}
	
	/**
	 * Column Info
	 * @return pDuration
	 */
	public String getPDuration() {
		return this.pDuration;
	}
	
	/**
	 * Column Info
	 * @return pSkdVoyNo
	 */
	public String getPSkdVoyNo() {
		return this.pSkdVoyNo;
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
	 * @return pOnlyStep
	 */
	public String getPOnlyStep() {
		return this.pOnlyStep;
	}
	
	/**
	 * Column Info
	 * @return pYear
	 */
	public String getPYear() {
		return this.pYear;
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
	 * @return pErrCd
	 */
	public String getPErrCd() {
		return this.pErrCd;
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
	 * @return pUserId
	 */
	public String getPUserId() {
		return this.pUserId;
	}
	
	/**
	 * Column Info
	 * @return pWeek
	 */
	public String getPWeek() {
		return this.pWeek;
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
	 * @param pVslCd
	 */
	public void setPVslCd(String pVslCd) {
		this.pVslCd = pVslCd;
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
	 * @param pStep
	 */
	public void setPStep(String pStep) {
		this.pStep = pStep;
	}
	
	/**
	 * Column Info
	 * @param pBsa
	 */
	public void setPBsa(String pBsa) {
		this.pBsa = pBsa;
	}
	
	/**
	 * Column Info
	 * @param pDuration
	 */
	public void setPDuration(String pDuration) {
		this.pDuration = pDuration;
	}
	
	/**
	 * Column Info
	 * @param pSkdVoyNo
	 */
	public void setPSkdVoyNo(String pSkdVoyNo) {
		this.pSkdVoyNo = pSkdVoyNo;
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
	 * @param pOnlyStep
	 */
	public void setPOnlyStep(String pOnlyStep) {
		this.pOnlyStep = pOnlyStep;
	}
	
	/**
	 * Column Info
	 * @param pYear
	 */
	public void setPYear(String pYear) {
		this.pYear = pYear;
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
	 * @param pErrCd
	 */
	public void setPErrCd(String pErrCd) {
		this.pErrCd = pErrCd;
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
	 * @param pUserId
	 */
	public void setPUserId(String pUserId) {
		this.pUserId = pUserId;
	}
	
	/**
	 * Column Info
	 * @param pWeek
	 */
	public void setPWeek(String pWeek) {
		this.pWeek = pWeek;
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
		setPVslCd(JSPUtil.getParameter(request, "p_vsl_cd", ""));
		setPDirCd(JSPUtil.getParameter(request, "p_dir_cd", ""));
		setPStep(JSPUtil.getParameter(request, "p_step", ""));
		setPBsa(JSPUtil.getParameter(request, "p_bsa", ""));
		setPDuration(JSPUtil.getParameter(request, "p_duration", ""));
		setPSkdVoyNo(JSPUtil.getParameter(request, "p_skd_voy_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPErrMsg(JSPUtil.getParameter(request, "p_err_msg", ""));
		setPOnlyStep(JSPUtil.getParameter(request, "p_only_step", ""));
		setPYear(JSPUtil.getParameter(request, "p_year", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPErrCd(JSPUtil.getParameter(request, "p_err_cd", ""));
		setPIocCd(JSPUtil.getParameter(request, "p_ioc_cd", ""));
		setPUserId(JSPUtil.getParameter(request, "p_user_id", ""));
		setPWeek(JSPUtil.getParameter(request, "p_week", ""));
		setPRlaneCd(JSPUtil.getParameter(request, "p_rlane_cd", ""));
		setPTrdCd(JSPUtil.getParameter(request, "p_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DailyBatchConditionVO[]
	 */
	public DailyBatchConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DailyBatchConditionVO[]
	 */
	public DailyBatchConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DailyBatchConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pVslCd = (JSPUtil.getParameter(request, prefix	+ "p_vsl_cd", length));
			String[] pDirCd = (JSPUtil.getParameter(request, prefix	+ "p_dir_cd", length));
			String[] pStep = (JSPUtil.getParameter(request, prefix	+ "p_step", length));
			String[] pBsa = (JSPUtil.getParameter(request, prefix	+ "p_bsa", length));
			String[] pDuration = (JSPUtil.getParameter(request, prefix	+ "p_duration", length));
			String[] pSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "p_skd_voy_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pErrMsg = (JSPUtil.getParameter(request, prefix	+ "p_err_msg", length));
			String[] pOnlyStep = (JSPUtil.getParameter(request, prefix	+ "p_only_step", length));
			String[] pYear = (JSPUtil.getParameter(request, prefix	+ "p_year", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pErrCd = (JSPUtil.getParameter(request, prefix	+ "p_err_cd", length));
			String[] pIocCd = (JSPUtil.getParameter(request, prefix	+ "p_ioc_cd", length));
			String[] pUserId = (JSPUtil.getParameter(request, prefix	+ "p_user_id", length));
			String[] pWeek = (JSPUtil.getParameter(request, prefix	+ "p_week", length));
			String[] pRlaneCd = (JSPUtil.getParameter(request, prefix	+ "p_rlane_cd", length));
			String[] pTrdCd = (JSPUtil.getParameter(request, prefix	+ "p_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DailyBatchConditionVO();
				if (pVslCd[i] != null)
					model.setPVslCd(pVslCd[i]);
				if (pDirCd[i] != null)
					model.setPDirCd(pDirCd[i]);
				if (pStep[i] != null)
					model.setPStep(pStep[i]);
				if (pBsa[i] != null)
					model.setPBsa(pBsa[i]);
				if (pDuration[i] != null)
					model.setPDuration(pDuration[i]);
				if (pSkdVoyNo[i] != null)
					model.setPSkdVoyNo(pSkdVoyNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pErrMsg[i] != null)
					model.setPErrMsg(pErrMsg[i]);
				if (pOnlyStep[i] != null)
					model.setPOnlyStep(pOnlyStep[i]);
				if (pYear[i] != null)
					model.setPYear(pYear[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pErrCd[i] != null)
					model.setPErrCd(pErrCd[i]);
				if (pIocCd[i] != null)
					model.setPIocCd(pIocCd[i]);
				if (pUserId[i] != null)
					model.setPUserId(pUserId[i]);
				if (pWeek[i] != null)
					model.setPWeek(pWeek[i]);
				if (pRlaneCd[i] != null)
					model.setPRlaneCd(pRlaneCd[i]);
				if (pTrdCd[i] != null)
					model.setPTrdCd(pTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDailyBatchConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DailyBatchConditionVO[]
	 */
	public DailyBatchConditionVO[] getDailyBatchConditionVOs(){
		DailyBatchConditionVO[] vos = (DailyBatchConditionVO[])models.toArray(new DailyBatchConditionVO[models.size()]);
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
		this.pVslCd = this.pVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDirCd = this.pDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pStep = this.pStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBsa = this.pBsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDuration = this.pDuration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSkdVoyNo = this.pSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pErrMsg = this.pErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pOnlyStep = this.pOnlyStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYear = this.pYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pErrCd = this.pErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIocCd = this.pIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pUserId = this.pUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pWeek = this.pWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pRlaneCd = this.pRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pTrdCd = this.pTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
