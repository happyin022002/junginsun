/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProcedureParamVO.java
*@FileTitle : ProcedureParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.26
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.02.26 이행지 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.common.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이행지
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ProcedureParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ProcedureParamVO> models = new ArrayList<ProcedureParamVO>();
	
	/* Column Info */
	private String inAllFlg = null;
	/* Column Info */
	private String inToMon = null;
	/* Column Info */
	private String inToWk = null;
	/* Column Info */
	private String inSkdVoyNo = null;
	/* Column Info */
	private String inInd = null;
	/* Column Info */
	private String inIocCd = null;
	/* Column Info */
	private String outErrMsg = null;
	/* Column Info */
	private String inDuration = null;
	/* Column Info */
	private String inVslCd = null;
	/* Column Info */
	private String inYr = null;
	/* Column Info */
	private String inRlaneCd = null;
	/* Column Info */
	private String inTrdCd = null;
	/* Column Info */
	private String inMonOrWk = null;
	/* Column Info */
	private String outErrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inDirCd = null;
	/* Column Info */
	private String inLogLvl = null;
	/* Column Info */
	private String inStndCostCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inFmWk = null;
	/* Column Info */
	private String inUserId = null;
	/* Column Info */
	private String inFmStep = null;
	/* Column Info */
	private String inFmMon = null;
	/* Column Info */
	private String inMssChkFlg = null;
	
	private Map<String, Object> resultMap = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ProcedureParamVO() {}

	public ProcedureParamVO(String ibflag, String pagerows, String inYr, String inFmMon, String inToMon, String inFmWk, String inToWk, String inDuration, String inMonOrWk, String inFmStep, String inAllFlg, String inInd, String inMssChkFlg, String inTrdCd, String inRlaneCd, String inIocCd, String inVslCd, String inSkdVoyNo, String inDirCd, String inStndCostCd, String inUserId, String inLogLvl, String outErrCd, String outErrMsg) {
		this.inAllFlg = inAllFlg;
		this.inToMon = inToMon;
		this.inToWk = inToWk;
		this.inSkdVoyNo = inSkdVoyNo;
		this.inInd = inInd;
		this.inIocCd = inIocCd;
		this.outErrMsg = outErrMsg;
		this.inDuration = inDuration;
		this.inVslCd = inVslCd;
		this.inYr = inYr;
		this.inRlaneCd = inRlaneCd;
		this.inTrdCd = inTrdCd;
		this.inMonOrWk = inMonOrWk;
		this.outErrCd = outErrCd;
		this.pagerows = pagerows;
		this.inDirCd = inDirCd;
		this.inLogLvl = inLogLvl;
		this.inStndCostCd = inStndCostCd;
		this.ibflag = ibflag;
		this.inFmWk = inFmWk;
		this.inUserId = inUserId;
		this.inFmStep = inFmStep;
		this.inFmMon = inFmMon;
		this.inMssChkFlg = inMssChkFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_all_flg", getInAllFlg());
		this.hashColumns.put("in_to_mon", getInToMon());
		this.hashColumns.put("in_to_wk", getInToWk());
		this.hashColumns.put("in_skd_voy_no", getInSkdVoyNo());
		this.hashColumns.put("in_ind", getInInd());
		this.hashColumns.put("in_ioc_cd", getInIocCd());
		this.hashColumns.put("out_err_msg", getOutErrMsg());
		this.hashColumns.put("in_duration", getInDuration());
		this.hashColumns.put("in_vsl_cd", getInVslCd());
		this.hashColumns.put("in_yr", getInYr());
		this.hashColumns.put("in_rlane_cd", getInRlaneCd());
		this.hashColumns.put("in_trd_cd", getInTrdCd());
		this.hashColumns.put("in_mon_or_wk", getInMonOrWk());
		this.hashColumns.put("out_err_cd", getOutErrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_dir_cd", getInDirCd());
		this.hashColumns.put("in_log_lvl", getInLogLvl());
		this.hashColumns.put("in_stnd_cost_cd", getInStndCostCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_fm_wk", getInFmWk());
		this.hashColumns.put("in_user_id", getInUserId());
		this.hashColumns.put("in_fm_step", getInFmStep());
		this.hashColumns.put("in_fm_mon", getInFmMon());
		this.hashColumns.put("in_mss_chk_flg", getInMssChkFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_all_flg", "inAllFlg");
		this.hashFields.put("in_to_mon", "inToMon");
		this.hashFields.put("in_to_wk", "inToWk");
		this.hashFields.put("in_skd_voy_no", "inSkdVoyNo");
		this.hashFields.put("in_ind", "inInd");
		this.hashFields.put("in_ioc_cd", "inIocCd");
		this.hashFields.put("out_err_msg", "outErrMsg");
		this.hashFields.put("in_duration", "inDuration");
		this.hashFields.put("in_vsl_cd", "inVslCd");
		this.hashFields.put("in_yr", "inYr");
		this.hashFields.put("in_rlane_cd", "inRlaneCd");
		this.hashFields.put("in_trd_cd", "inTrdCd");
		this.hashFields.put("in_mon_or_wk", "inMonOrWk");
		this.hashFields.put("out_err_cd", "outErrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_dir_cd", "inDirCd");
		this.hashFields.put("in_log_lvl", "inLogLvl");
		this.hashFields.put("in_stnd_cost_cd", "inStndCostCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_fm_wk", "inFmWk");
		this.hashFields.put("in_user_id", "inUserId");
		this.hashFields.put("in_fm_step", "inFmStep");
		this.hashFields.put("in_fm_mon", "inFmMon");
		this.hashFields.put("in_mss_chk_flg", "inMssChkFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inAllFlg
	 */
	public String getInAllFlg() {
		return this.inAllFlg;
	}
	
	/**
	 * Column Info
	 * @return inToMon
	 */
	public String getInToMon() {
		return this.inToMon;
	}
	
	/**
	 * Column Info
	 * @return inToWk
	 */
	public String getInToWk() {
		return this.inToWk;
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
	 * @return inInd
	 */
	public String getInInd() {
		return this.inInd;
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
	 * @return outErrMsg
	 */
	public String getOutErrMsg() {
		return this.outErrMsg;
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
	 * @return inVslCd
	 */
	public String getInVslCd() {
		return this.inVslCd;
	}
	
	/**
	 * Column Info
	 * @return inYr
	 */
	public String getInYr() {
		return this.inYr;
	}
	
	/**
	 * Column Info
	 * @return inRlaneCd
	 */
	public String getInRlaneCd() {
		return this.inRlaneCd;
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
	 * @return inMonOrWk
	 */
	public String getInMonOrWk() {
		return this.inMonOrWk;
	}
	
	/**
	 * Column Info
	 * @return outErrCd
	 */
	public String getOutErrCd() {
		return this.outErrCd;
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
	 * @return inDirCd
	 */
	public String getInDirCd() {
		return this.inDirCd;
	}
	
	/**
	 * Column Info
	 * @return inLogLvl
	 */
	public String getInLogLvl() {
		return this.inLogLvl;
	}
	
	/**
	 * Column Info
	 * @return inStndCostCd
	 */
	public String getInStndCostCd() {
		return this.inStndCostCd;
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
	 * @return inFmWk
	 */
	public String getInFmWk() {
		return this.inFmWk;
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
	 * @return inFmStep
	 */
	public String getInFmStep() {
		return this.inFmStep;
	}
	
	/**
	 * Column Info
	 * @return inFmMon
	 */
	public String getInFmMon() {
		return this.inFmMon;
	}
	
	/**
	 * Column Info
	 * @return inMssChkFlg
	 */
	public String getInMssChkFlg() {
		return this.inMssChkFlg;
	}
	

	/**
	 * Column Info
	 * @param inAllFlg
	 */
	public void setInAllFlg(String inAllFlg) {
		this.inAllFlg = inAllFlg;
	}
	
	/**
	 * Column Info
	 * @param inToMon
	 */
	public void setInToMon(String inToMon) {
		this.inToMon = inToMon;
	}
	
	/**
	 * Column Info
	 * @param inToWk
	 */
	public void setInToWk(String inToWk) {
		this.inToWk = inToWk;
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
	 * @param inInd
	 */
	public void setInInd(String inInd) {
		this.inInd = inInd;
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
	 * @param outErrMsg
	 */
	public void setOutErrMsg(String outErrMsg) {
		this.outErrMsg = outErrMsg;
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
	 * @param inVslCd
	 */
	public void setInVslCd(String inVslCd) {
		this.inVslCd = inVslCd;
	}
	
	/**
	 * Column Info
	 * @param inYr
	 */
	public void setInYr(String inYr) {
		this.inYr = inYr;
	}
	
	/**
	 * Column Info
	 * @param inRlaneCd
	 */
	public void setInRlaneCd(String inRlaneCd) {
		this.inRlaneCd = inRlaneCd;
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
	 * @param inMonOrWk
	 */
	public void setInMonOrWk(String inMonOrWk) {
		this.inMonOrWk = inMonOrWk;
	}
	
	/**
	 * Column Info
	 * @param outErrCd
	 */
	public void setOutErrCd(String outErrCd) {
		this.outErrCd = outErrCd;
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
	 * @param inDirCd
	 */
	public void setInDirCd(String inDirCd) {
		this.inDirCd = inDirCd;
	}
	
	/**
	 * Column Info
	 * @param inLogLvl
	 */
	public void setInLogLvl(String inLogLvl) {
		this.inLogLvl = inLogLvl;
	}
	
	/**
	 * Column Info
	 * @param inStndCostCd
	 */
	public void setInStndCostCd(String inStndCostCd) {
		this.inStndCostCd = inStndCostCd;
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
	 * @param inFmWk
	 */
	public void setInFmWk(String inFmWk) {
		this.inFmWk = inFmWk;
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
	 * @param inFmStep
	 */
	public void setInFmStep(String inFmStep) {
		this.inFmStep = inFmStep;
	}
	
	/**
	 * Column Info
	 * @param inFmMon
	 */
	public void setInFmMon(String inFmMon) {
		this.inFmMon = inFmMon;
	}
	
	/**
	 * Column Info
	 * @param inMssChkFlg
	 */
	public void setInMssChkFlg(String inMssChkFlg) {
		this.inMssChkFlg = inMssChkFlg;
	}
	
	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
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
		setInAllFlg(JSPUtil.getParameter(request, prefix + "in_all_flg", ""));
		setInToMon(JSPUtil.getParameter(request, prefix + "in_to_mon", ""));
		setInToWk(JSPUtil.getParameter(request, prefix + "in_to_wk", ""));
		setInSkdVoyNo(JSPUtil.getParameter(request, prefix + "in_skd_voy_no", ""));
		setInInd(JSPUtil.getParameter(request, prefix + "in_ind", ""));
		setInIocCd(JSPUtil.getParameter(request, prefix + "in_ioc_cd", ""));
		setOutErrMsg(JSPUtil.getParameter(request, prefix + "out_err_msg", ""));
		setInDuration(JSPUtil.getParameter(request, prefix + "in_duration", ""));
		setInVslCd(JSPUtil.getParameter(request, prefix + "in_vsl_cd", ""));
		setInYr(JSPUtil.getParameter(request, prefix + "in_yr", ""));
		setInRlaneCd(JSPUtil.getParameter(request, prefix + "in_rlane_cd", ""));
		setInTrdCd(JSPUtil.getParameter(request, prefix + "in_trd_cd", ""));
		setInMonOrWk(JSPUtil.getParameter(request, prefix + "in_mon_or_wk", ""));
		setOutErrCd(JSPUtil.getParameter(request, prefix + "out_err_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInDirCd(JSPUtil.getParameter(request, prefix + "in_dir_cd", ""));
		setInLogLvl(JSPUtil.getParameter(request, prefix + "in_log_lvl", ""));
		setInStndCostCd(JSPUtil.getParameter(request, prefix + "in_stnd_cost_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInFmWk(JSPUtil.getParameter(request, prefix + "in_fm_wk", ""));
		setInUserId(JSPUtil.getParameter(request, prefix + "in_user_id", ""));
		setInFmStep(JSPUtil.getParameter(request, prefix + "in_fm_step", ""));
		setInFmMon(JSPUtil.getParameter(request, prefix + "in_fm_mon", ""));
		setInMssChkFlg(JSPUtil.getParameter(request, prefix + "in_mss_chk_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ProcedureParamVO[]
	 */
	public ProcedureParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ProcedureParamVO[]
	 */
	public ProcedureParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ProcedureParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inAllFlg = (JSPUtil.getParameter(request, prefix	+ "in_all_flg", length));
			String[] inToMon = (JSPUtil.getParameter(request, prefix	+ "in_to_mon", length));
			String[] inToWk = (JSPUtil.getParameter(request, prefix	+ "in_to_wk", length));
			String[] inSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "in_skd_voy_no", length));
			String[] inInd = (JSPUtil.getParameter(request, prefix	+ "in_ind", length));
			String[] inIocCd = (JSPUtil.getParameter(request, prefix	+ "in_ioc_cd", length));
			String[] outErrMsg = (JSPUtil.getParameter(request, prefix	+ "out_err_msg", length));
			String[] inDuration = (JSPUtil.getParameter(request, prefix	+ "in_duration", length));
			String[] inVslCd = (JSPUtil.getParameter(request, prefix	+ "in_vsl_cd", length));
			String[] inYr = (JSPUtil.getParameter(request, prefix	+ "in_yr", length));
			String[] inRlaneCd = (JSPUtil.getParameter(request, prefix	+ "in_rlane_cd", length));
			String[] inTrdCd = (JSPUtil.getParameter(request, prefix	+ "in_trd_cd", length));
			String[] inMonOrWk = (JSPUtil.getParameter(request, prefix	+ "in_mon_or_wk", length));
			String[] outErrCd = (JSPUtil.getParameter(request, prefix	+ "out_err_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inDirCd = (JSPUtil.getParameter(request, prefix	+ "in_dir_cd", length));
			String[] inLogLvl = (JSPUtil.getParameter(request, prefix	+ "in_log_lvl", length));
			String[] inStndCostCd = (JSPUtil.getParameter(request, prefix	+ "in_stnd_cost_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inFmWk = (JSPUtil.getParameter(request, prefix	+ "in_fm_wk", length));
			String[] inUserId = (JSPUtil.getParameter(request, prefix	+ "in_user_id", length));
			String[] inFmStep = (JSPUtil.getParameter(request, prefix	+ "in_fm_step", length));
			String[] inFmMon = (JSPUtil.getParameter(request, prefix	+ "in_fm_mon", length));
			String[] inMssChkFlg = (JSPUtil.getParameter(request, prefix	+ "in_mss_chk_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ProcedureParamVO();
				if (inAllFlg[i] != null)
					model.setInAllFlg(inAllFlg[i]);
				if (inToMon[i] != null)
					model.setInToMon(inToMon[i]);
				if (inToWk[i] != null)
					model.setInToWk(inToWk[i]);
				if (inSkdVoyNo[i] != null)
					model.setInSkdVoyNo(inSkdVoyNo[i]);
				if (inInd[i] != null)
					model.setInInd(inInd[i]);
				if (inIocCd[i] != null)
					model.setInIocCd(inIocCd[i]);
				if (outErrMsg[i] != null)
					model.setOutErrMsg(outErrMsg[i]);
				if (inDuration[i] != null)
					model.setInDuration(inDuration[i]);
				if (inVslCd[i] != null)
					model.setInVslCd(inVslCd[i]);
				if (inYr[i] != null)
					model.setInYr(inYr[i]);
				if (inRlaneCd[i] != null)
					model.setInRlaneCd(inRlaneCd[i]);
				if (inTrdCd[i] != null)
					model.setInTrdCd(inTrdCd[i]);
				if (inMonOrWk[i] != null)
					model.setInMonOrWk(inMonOrWk[i]);
				if (outErrCd[i] != null)
					model.setOutErrCd(outErrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inDirCd[i] != null)
					model.setInDirCd(inDirCd[i]);
				if (inLogLvl[i] != null)
					model.setInLogLvl(inLogLvl[i]);
				if (inStndCostCd[i] != null)
					model.setInStndCostCd(inStndCostCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inFmWk[i] != null)
					model.setInFmWk(inFmWk[i]);
				if (inUserId[i] != null)
					model.setInUserId(inUserId[i]);
				if (inFmStep[i] != null)
					model.setInFmStep(inFmStep[i]);
				if (inFmMon[i] != null)
					model.setInFmMon(inFmMon[i]);
				if (inMssChkFlg[i] != null)
					model.setInMssChkFlg(inMssChkFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getProcedureParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ProcedureParamVO[]
	 */
	public ProcedureParamVO[] getProcedureParamVOs(){
		ProcedureParamVO[] vos = (ProcedureParamVO[])models.toArray(new ProcedureParamVO[models.size()]);
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
		this.inAllFlg = this.inAllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inToMon = this.inToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inToWk = this.inToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdVoyNo = this.inSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inInd = this.inInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inIocCd = this.inIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outErrMsg = this.outErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDuration = this.inDuration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslCd = this.inVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inYr = this.inYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inRlaneCd = this.inRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTrdCd = this.inTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inMonOrWk = this.inMonOrWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outErrCd = this.outErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDirCd = this.inDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inLogLvl = this.inLogLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inStndCostCd = this.inStndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inFmWk = this.inFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inUserId = this.inUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inFmStep = this.inFmStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inFmMon = this.inFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inMssChkFlg = this.inMssChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
