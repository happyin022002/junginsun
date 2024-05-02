/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ExceptionCostParmVO.java
*@FileTitle : ExceptionCostParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.10.16 KIM HYUN HWA 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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

public class ExceptionCostParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExceptionCostParmVO> models = new ArrayList<ExceptionCostParmVO>();
	
	/* Column Info */
	private String adjRt = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String ydExptCostSeq = null;
	/* Column Info */
	private String dmdtTrfAplyTpCd = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String adjCurrCd = null;
	/* Column Info */
	private String bzcCurrCd = null;
	/* Column Info */
	private String bzcRt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String dmdtBzcFtEndDt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String exptFtEndDt = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String termCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExceptionCostParmVO() {}

	public ExceptionCostParmVO(String ibflag, String pagerows, String cntrNo, String cntrCycNo, String dmdtTrfCd, String dmdtChgLocDivCd, String chgSeq, String dmdtBzcFtEndDt, String exptFtEndDt, String ydCd, String ydExptCostSeq, String cntrTpszCd, String toMvmtDt, String bzcCurrCd, String bzcRt, String adjCurrCd, String adjRt, String dmdtTrfAplyTpCd, String etaDt, String fmMvmtDt, String termCd) {
		this.adjRt = adjRt;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.cntrCycNo = cntrCycNo;
		this.etaDt = etaDt;
		this.ydExptCostSeq = ydExptCostSeq;
		this.dmdtTrfAplyTpCd = dmdtTrfAplyTpCd;
		this.chgSeq = chgSeq;
		this.adjCurrCd = adjCurrCd;
		this.bzcCurrCd = bzcCurrCd;
		this.bzcRt = bzcRt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.dmdtBzcFtEndDt = dmdtBzcFtEndDt;
		this.cntrTpszCd = cntrTpszCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.exptFtEndDt = exptFtEndDt;
		this.toMvmtDt = toMvmtDt;
		this.fmMvmtDt = fmMvmtDt;
		this.termCd = termCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("adj_rt", getAdjRt());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("yd_expt_cost_seq", getYdExptCostSeq());
		this.hashColumns.put("dmdt_trf_aply_tp_cd", getDmdtTrfAplyTpCd());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("adj_curr_cd", getAdjCurrCd());
		this.hashColumns.put("bzc_curr_cd", getBzcCurrCd());
		this.hashColumns.put("bzc_rt", getBzcRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dmdt_bzc_ft_end_dt", getDmdtBzcFtEndDt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("expt_ft_end_dt", getExptFtEndDt());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("term_cd", getTermCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("adj_rt", "adjRt");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("yd_expt_cost_seq", "ydExptCostSeq");
		this.hashFields.put("dmdt_trf_aply_tp_cd", "dmdtTrfAplyTpCd");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("adj_curr_cd", "adjCurrCd");
		this.hashFields.put("bzc_curr_cd", "bzcCurrCd");
		this.hashFields.put("bzc_rt", "bzcRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dmdt_bzc_ft_end_dt", "dmdtBzcFtEndDt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("expt_ft_end_dt", "exptFtEndDt");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("term_cd", "termCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return adjRt
	 */
	public String getAdjRt() {
		return this.adjRt;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return cntrCycNo
	 */
	public String getCntrCycNo() {
		return this.cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return ydExptCostSeq
	 */
	public String getYdExptCostSeq() {
		return this.ydExptCostSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfAplyTpCd
	 */
	public String getDmdtTrfAplyTpCd() {
		return this.dmdtTrfAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return adjCurrCd
	 */
	public String getAdjCurrCd() {
		return this.adjCurrCd;
	}
	
	/**
	 * Column Info
	 * @return bzcCurrCd
	 */
	public String getBzcCurrCd() {
		return this.bzcCurrCd;
	}
	
	/**
	 * Column Info
	 * @return bzcRt
	 */
	public String getBzcRt() {
		return this.bzcRt;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return dmdtBzcFtEndDt
	 */
	public String getDmdtBzcFtEndDt() {
		return this.dmdtBzcFtEndDt;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
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
	 * @return toMvmtDt
	 */
	public String getToMvmtDt() {
		return this.toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtDt
	 */
	public String getFmMvmtDt() {
		return fmMvmtDt;
	}
	/**
	 * Column Info
	 * @return termCd
	 */
	public String getTermCd() {
		return termCd;
	}
	
	/**
	 * Column Info
	 * @param adjRt
	 */
	public void setAdjRt(String adjRt) {
		this.adjRt = adjRt;
	}

	/**
	 * Column Info
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param cntrCycNo
	 */
	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param ydExptCostSeq
	 */
	public void setYdExptCostSeq(String ydExptCostSeq) {
		this.ydExptCostSeq = ydExptCostSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfAplyTpCd
	 */
	public void setDmdtTrfAplyTpCd(String dmdtTrfAplyTpCd) {
		this.dmdtTrfAplyTpCd = dmdtTrfAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param adjCurrCd
	 */
	public void setAdjCurrCd(String adjCurrCd) {
		this.adjCurrCd = adjCurrCd;
	}
	
	/**
	 * Column Info
	 * @param bzcCurrCd
	 */
	public void setBzcCurrCd(String bzcCurrCd) {
		this.bzcCurrCd = bzcCurrCd;
	}
	
	/**
	 * Column Info
	 * @param bzcRt
	 */
	public void setBzcRt(String bzcRt) {
		this.bzcRt = bzcRt;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param dmdtBzcFtEndDt
	 */
	public void setDmdtBzcFtEndDt(String dmdtBzcFtEndDt) {
		this.dmdtBzcFtEndDt = dmdtBzcFtEndDt;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
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
	 * @param toMvmtDt
	 */
	public void setToMvmtDt(String toMvmtDt) {
		this.toMvmtDt = toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtDt
	 */
	public void setFmMvmtDt(String fmMvmtDt) {
		this.fmMvmtDt = fmMvmtDt;
	}
	/**
	 * Column Info
	 * @param termCd
	 */
	public void setTermCd(String termCd) {
		this.termCd = termCd;
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
		setAdjRt(JSPUtil.getParameter(request, prefix + "adj_rt", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
		setCntrCycNo(JSPUtil.getParameter(request, prefix + "cntr_cyc_no", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setYdExptCostSeq(JSPUtil.getParameter(request, prefix + "yd_expt_cost_seq", ""));
		setDmdtTrfAplyTpCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_aply_tp_cd", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setAdjCurrCd(JSPUtil.getParameter(request, prefix + "adj_curr_cd", ""));
		setBzcCurrCd(JSPUtil.getParameter(request, prefix + "bzc_curr_cd", ""));
		setBzcRt(JSPUtil.getParameter(request, prefix + "bzc_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setDmdtBzcFtEndDt(JSPUtil.getParameter(request, prefix + "dmdt_bzc_ft_end_dt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setExptFtEndDt(JSPUtil.getParameter(request, prefix + "expt_ft_end_dt", ""));
		setToMvmtDt(JSPUtil.getParameter(request, prefix + "to_mvmt_dt", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
		setTermCd(JSPUtil.getParameter(request, prefix + "term_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExceptionCostParmVO[]
	 */
	public ExceptionCostParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExceptionCostParmVO[]
	 */
	public ExceptionCostParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExceptionCostParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] adjRt = (JSPUtil.getParameter(request, prefix	+ "adj_rt", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] ydExptCostSeq = (JSPUtil.getParameter(request, prefix	+ "yd_expt_cost_seq", length));
			String[] dmdtTrfAplyTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_aply_tp_cd", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] adjCurrCd = (JSPUtil.getParameter(request, prefix	+ "adj_curr_cd", length));
			String[] bzcCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_curr_cd", length));
			String[] bzcRt = (JSPUtil.getParameter(request, prefix	+ "bzc_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] dmdtBzcFtEndDt = (JSPUtil.getParameter(request, prefix	+ "dmdt_bzc_ft_end_dt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] exptFtEndDt = (JSPUtil.getParameter(request, prefix	+ "expt_ft_end_dt", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] termCd = (JSPUtil.getParameter(request, prefix	+ "term_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExceptionCostParmVO();
				if (adjRt[i] != null)
					model.setAdjRt(adjRt[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (ydExptCostSeq[i] != null)
					model.setYdExptCostSeq(ydExptCostSeq[i]);
				if (dmdtTrfAplyTpCd[i] != null)
					model.setDmdtTrfAplyTpCd(dmdtTrfAplyTpCd[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (adjCurrCd[i] != null)
					model.setAdjCurrCd(adjCurrCd[i]);
				if (bzcCurrCd[i] != null)
					model.setBzcCurrCd(bzcCurrCd[i]);
				if (bzcRt[i] != null)
					model.setBzcRt(bzcRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (dmdtBzcFtEndDt[i] != null)
					model.setDmdtBzcFtEndDt(dmdtBzcFtEndDt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (exptFtEndDt[i] != null)
					model.setExptFtEndDt(exptFtEndDt[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (termCd[i] != null)
					model.setTermCd(termCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExceptionCostParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExceptionCostParmVO[]
	 */
	public ExceptionCostParmVO[] getExceptionCostParmVOs(){
		ExceptionCostParmVO[] vos = (ExceptionCostParmVO[])models.toArray(new ExceptionCostParmVO[models.size()]);
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
		this.adjRt = this.adjRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydExptCostSeq = this.ydExptCostSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfAplyTpCd = this.dmdtTrfAplyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjCurrCd = this.adjCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcCurrCd = this.bzcCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcRt = this.bzcRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBzcFtEndDt = this.dmdtBzcFtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptFtEndDt = this.exptFtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCd = this.termCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
