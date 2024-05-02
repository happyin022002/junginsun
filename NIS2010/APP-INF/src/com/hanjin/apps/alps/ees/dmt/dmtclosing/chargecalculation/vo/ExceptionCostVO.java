/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ExceptionCostVO.java
*@FileTitle : ExceptionCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.09
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.10.09 KIM HYUN HWA 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

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
 * @author KIM HYUN HWA
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExceptionCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExceptionCostVO> models = new ArrayList<ExceptionCostVO>();
	
	/* Column Info */
	private String bzcTrfCurrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String expRtAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String dmdtBzcFtEndDt = null;
	/* Column Info */
	private String exptCostAmt = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String exptFtEndDt = null;
	/* Column Info */
	private String exptDys = null;
	/* Column Info */
	private String cntrCostStkAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExceptionCostVO() {}

	public ExceptionCostVO(String ibflag, String pagerows, String dmdtBzcFtEndDt, String exptFtEndDt, String toMvmtDt, String exptDys, String exptCostAmt, String bzcTrfCurrCd, String currCd, String expRtAmt, String cntrCostStkAmt) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		this.ibflag = ibflag;
		this.expRtAmt = expRtAmt;
		this.currCd = currCd;
		this.dmdtBzcFtEndDt = dmdtBzcFtEndDt;
		this.exptCostAmt = exptCostAmt;
		this.toMvmtDt = toMvmtDt;
		this.exptFtEndDt = exptFtEndDt;
		this.exptDys = exptDys;
		this.cntrCostStkAmt = cntrCostStkAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("exp_rt_amt", getExpRtAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("dmdt_bzc_ft_end_dt", getDmdtBzcFtEndDt());
		this.hashColumns.put("expt_cost_amt", getExptCostAmt());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("expt_ft_end_dt", getExptFtEndDt());
		this.hashColumns.put("expt_dys", getExptDys());
		this.hashColumns.put("cntr_cost_stk_amt", getCntrCostStkAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("exp_rt_amt", "expRtAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("dmdt_bzc_ft_end_dt", "dmdtBzcFtEndDt");
		this.hashFields.put("expt_cost_amt", "exptCostAmt");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("expt_ft_end_dt", "exptFtEndDt");
		this.hashFields.put("expt_dys", "exptDys");
		this.hashFields.put("cntr_cost_stk_amt", "cntrCostStkAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfCurrCd
	 */
	public String getBzcTrfCurrCd() {
		return this.bzcTrfCurrCd;
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
	 * @return expRtAmt
	 */
	public String getExpRtAmt() {
		return this.expRtAmt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtBzcFtEndDt
	 */
	public String getDmdtBzcFtEndDt() {
		return this.dmdtBzcFtEndDt;
	}
	
	/**
	 * Column Info
	 * @return exptCostAmt
	 */
	public String getExptCostAmt() {
		return this.exptCostAmt;
	}
	
	/**
	 * Column Info
	 * @return toMvmtDt
	 */
	public String getToMvmtDt() {
		return this.toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return exptFtEndDt
	 */
	public String getExptFtEndDt() {
		return this.exptFtEndDt;
	}
	
	/**
	 * Column Info
	 * @return exptDys
	 */
	public String getExptDys() {
		return this.exptDys;
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
	 * @return cntrCostStkAmt
	 */
	public String getCntrCostStkAmt() {
		return this.cntrCostStkAmt;
	}

	/**
	 * Column Info
	 * @param cntrCostStkAmt
	 */
	public void setCntrCostStkAmt(String cntrCostStkAmt) {
		this.cntrCostStkAmt = cntrCostStkAmt;
	}

	/**
	 * Column Info
	 * @param bzcTrfCurrCd
	 */
	public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
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
	 * @param expRtAmt
	 */
	public void setExpRtAmt(String expRtAmt) {
		this.expRtAmt = expRtAmt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtBzcFtEndDt
	 */
	public void setDmdtBzcFtEndDt(String dmdtBzcFtEndDt) {
		this.dmdtBzcFtEndDt = dmdtBzcFtEndDt;
	}
	
	/**
	 * Column Info
	 * @param exptCostAmt
	 */
	public void setExptCostAmt(String exptCostAmt) {
		this.exptCostAmt = exptCostAmt;
	}
	
	/**
	 * Column Info
	 * @param toMvmtDt
	 */
	public void setToMvmtDt(String toMvmtDt) {
		this.toMvmtDt = toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param exptFtEndDt
	 */
	public void setExptFtEndDt(String exptFtEndDt) {
		this.exptFtEndDt = exptFtEndDt;
	}
	
	/**
	 * Column Info
	 * @param exptDys
	 */
	public void setExptDys(String exptDys) {
		this.exptDys = exptDys;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setBzcTrfCurrCd(JSPUtil.getParameter(request, prefix + "bzc_trf_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExpRtAmt(JSPUtil.getParameter(request, prefix + "exp_rt_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDmdtBzcFtEndDt(JSPUtil.getParameter(request, prefix + "dmdt_bzc_ft_end_dt", ""));
		setExptCostAmt(JSPUtil.getParameter(request, prefix + "expt_cost_amt", ""));
		setToMvmtDt(JSPUtil.getParameter(request, prefix + "to_mvmt_dt", ""));
		setExptFtEndDt(JSPUtil.getParameter(request, prefix + "expt_ft_end_dt", ""));
		setExptDys(JSPUtil.getParameter(request, prefix + "expt_dys", ""));
		setCntrCostStkAmt(JSPUtil.getParameter(request, prefix + "cntr_cost_stk_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExceptionCostVO[]
	 */
	public ExceptionCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExceptionCostVO[]
	 */
	public ExceptionCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExceptionCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_curr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] expRtAmt = (JSPUtil.getParameter(request, prefix	+ "exp_rt_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] dmdtBzcFtEndDt = (JSPUtil.getParameter(request, prefix	+ "dmdt_bzc_ft_end_dt", length));
			String[] exptCostAmt = (JSPUtil.getParameter(request, prefix	+ "expt_cost_amt", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] exptFtEndDt = (JSPUtil.getParameter(request, prefix	+ "expt_ft_end_dt", length));
			String[] exptDys = (JSPUtil.getParameter(request, prefix	+ "expt_dys", length));
			String[] cntrCostStkAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_cost_stk_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExceptionCostVO();
				if (bzcTrfCurrCd[i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (expRtAmt[i] != null)
					model.setExpRtAmt(expRtAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (dmdtBzcFtEndDt[i] != null)
					model.setDmdtBzcFtEndDt(dmdtBzcFtEndDt[i]);
				if (exptCostAmt[i] != null)
					model.setExptCostAmt(exptCostAmt[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (exptFtEndDt[i] != null)
					model.setExptFtEndDt(exptFtEndDt[i]);
				if (exptDys[i] != null)
					model.setExptDys(exptDys[i]);
				if (cntrCostStkAmt[i] != null)
					model.setCntrCostStkAmt(cntrCostStkAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExceptionCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExceptionCostVO[]
	 */
	public ExceptionCostVO[] getExceptionCostVOs(){
		ExceptionCostVO[] vos = (ExceptionCostVO[])models.toArray(new ExceptionCostVO[models.size()]);
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
		this.bzcTrfCurrCd = this.bzcTrfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expRtAmt = this.expRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBzcFtEndDt = this.dmdtBzcFtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptCostAmt = this.exptCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptFtEndDt = this.exptFtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptDys = this.exptDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCostStkAmt = this.cntrCostStkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
