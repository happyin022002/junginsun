/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesOffdockCYFreePoolHistoryVO.java
*@FileTitle : TesOffdockCYFreePoolHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.16
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.06.16 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesOffdockCYFreePoolHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesOffdockCYFreePoolHistoryVO> models = new ArrayList<TesOffdockCYFreePoolHistoryVO>();
	
	/* Column Info */
	private String ovrVolQty = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ctrtRt = null;
	/* Column Info */
	private String calcRmk = null;
	/* Column Info */
	private String stkVolQty = null;
	/* Column Info */
	private String toPrdDt = null;
	/* Column Info */
	private String diffVolQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String calcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fpTeuQty = null;
	/* Column Info */
	private String fpCalcPrdCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String volTrUtCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String invVolQty = null;
	/* Column Info */
	private String stoDysIndCd = null;
	/* Column Info */
	private String wrkDt = null;
	/* Column Info */
	private String fmPrdDt = null;
	/* Column Info */
	private String invXchRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesOffdockCYFreePoolHistoryVO() {}

	public TesOffdockCYFreePoolHistoryVO(String ibflag, String pagerows, String ydCd, String vndrSeq, String invNo, String issDt, String fmPrdDt, String toPrdDt, String stoDysIndCd, String calcTpCd, String lgsCostCd, String fpCalcPrdCd, String wrkDt, String stkVolQty, String invVolQty, String diffVolQty, String fpTeuQty, String ovrVolQty, String volTrUtCd, String ctrtRt, String currCd, String invXchRt, String invAmt, String calcRmk) {
		this.ovrVolQty = ovrVolQty;
		this.currCd = currCd;
		this.ctrtRt = ctrtRt;
		this.calcRmk = calcRmk;
		this.stkVolQty = stkVolQty;
		this.toPrdDt = toPrdDt;
		this.diffVolQty = diffVolQty;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.issDt = issDt;
		this.calcTpCd = calcTpCd;
		this.ibflag = ibflag;
		this.fpTeuQty = fpTeuQty;
		this.fpCalcPrdCd = fpCalcPrdCd;
		this.ydCd = ydCd;
		this.volTrUtCd = volTrUtCd;
		this.vndrSeq = vndrSeq;
		this.lgsCostCd = lgsCostCd;
		this.invAmt = invAmt;
		this.invVolQty = invVolQty;
		this.stoDysIndCd = stoDysIndCd;
		this.wrkDt = wrkDt;
		this.fmPrdDt = fmPrdDt;
		this.invXchRt = invXchRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ovr_vol_qty", getOvrVolQty());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ctrt_rt", getCtrtRt());
		this.hashColumns.put("calc_rmk", getCalcRmk());
		this.hashColumns.put("stk_vol_qty", getStkVolQty());
		this.hashColumns.put("to_prd_dt", getToPrdDt());
		this.hashColumns.put("diff_vol_qty", getDiffVolQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fp_teu_qty", getFpTeuQty());
		this.hashColumns.put("fp_calc_prd_cd", getFpCalcPrdCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vol_tr_ut_cd", getVolTrUtCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("inv_vol_qty", getInvVolQty());
		this.hashColumns.put("sto_dys_ind_cd", getStoDysIndCd());
		this.hashColumns.put("wrk_dt", getWrkDt());
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ovr_vol_qty", "ovrVolQty");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ctrt_rt", "ctrtRt");
		this.hashFields.put("calc_rmk", "calcRmk");
		this.hashFields.put("stk_vol_qty", "stkVolQty");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("diff_vol_qty", "diffVolQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fp_teu_qty", "fpTeuQty");
		this.hashFields.put("fp_calc_prd_cd", "fpCalcPrdCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vol_tr_ut_cd", "volTrUtCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("inv_vol_qty", "invVolQty");
		this.hashFields.put("sto_dys_ind_cd", "stoDysIndCd");
		this.hashFields.put("wrk_dt", "wrkDt");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ovrVolQty
	 */
	public String getOvrVolQty() {
		return this.ovrVolQty;
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
	 * @return ctrtRt
	 */
	public String getCtrtRt() {
		return this.ctrtRt;
	}
	
	/**
	 * Column Info
	 * @return calcRmk
	 */
	public String getCalcRmk() {
		return this.calcRmk;
	}
	
	/**
	 * Column Info
	 * @return stkVolQty
	 */
	public String getStkVolQty() {
		return this.stkVolQty;
	}
	
	/**
	 * Column Info
	 * @return toPrdDt
	 */
	public String getToPrdDt() {
		return this.toPrdDt;
	}
	
	/**
	 * Column Info
	 * @return diffVolQty
	 */
	public String getDiffVolQty() {
		return this.diffVolQty;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
	}
	
	/**
	 * Column Info
	 * @return calcTpCd
	 */
	public String getCalcTpCd() {
		return this.calcTpCd;
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
	 * @return fpTeuQty
	 */
	public String getFpTeuQty() {
		return this.fpTeuQty;
	}
	
	/**
	 * Column Info
	 * @return fpCalcPrdCd
	 */
	public String getFpCalcPrdCd() {
		return this.fpCalcPrdCd;
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
	 * @return volTrUtCd
	 */
	public String getVolTrUtCd() {
		return this.volTrUtCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
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
	 * @return invVolQty
	 */
	public String getInvVolQty() {
		return this.invVolQty;
	}
	
	/**
	 * Column Info
	 * @return stoDysIndCd
	 */
	public String getStoDysIndCd() {
		return this.stoDysIndCd;
	}
	
	/**
	 * Column Info
	 * @return wrkDt
	 */
	public String getWrkDt() {
		return this.wrkDt;
	}
	
	/**
	 * Column Info
	 * @return fmPrdDt
	 */
	public String getFmPrdDt() {
		return this.fmPrdDt;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	

	/**
	 * Column Info
	 * @param ovrVolQty
	 */
	public void setOvrVolQty(String ovrVolQty) {
		this.ovrVolQty = ovrVolQty;
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
	 * @param ctrtRt
	 */
	public void setCtrtRt(String ctrtRt) {
		this.ctrtRt = ctrtRt;
	}
	
	/**
	 * Column Info
	 * @param calcRmk
	 */
	public void setCalcRmk(String calcRmk) {
		this.calcRmk = calcRmk;
	}
	
	/**
	 * Column Info
	 * @param stkVolQty
	 */
	public void setStkVolQty(String stkVolQty) {
		this.stkVolQty = stkVolQty;
	}
	
	/**
	 * Column Info
	 * @param toPrdDt
	 */
	public void setToPrdDt(String toPrdDt) {
		this.toPrdDt = toPrdDt;
	}
	
	/**
	 * Column Info
	 * @param diffVolQty
	 */
	public void setDiffVolQty(String diffVolQty) {
		this.diffVolQty = diffVolQty;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	
	/**
	 * Column Info
	 * @param calcTpCd
	 */
	public void setCalcTpCd(String calcTpCd) {
		this.calcTpCd = calcTpCd;
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
	 * @param fpTeuQty
	 */
	public void setFpTeuQty(String fpTeuQty) {
		this.fpTeuQty = fpTeuQty;
	}
	
	/**
	 * Column Info
	 * @param fpCalcPrdCd
	 */
	public void setFpCalcPrdCd(String fpCalcPrdCd) {
		this.fpCalcPrdCd = fpCalcPrdCd;
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
	 * @param volTrUtCd
	 */
	public void setVolTrUtCd(String volTrUtCd) {
		this.volTrUtCd = volTrUtCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
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
	 * @param invVolQty
	 */
	public void setInvVolQty(String invVolQty) {
		this.invVolQty = invVolQty;
	}
	
	/**
	 * Column Info
	 * @param stoDysIndCd
	 */
	public void setStoDysIndCd(String stoDysIndCd) {
		this.stoDysIndCd = stoDysIndCd;
	}
	
	/**
	 * Column Info
	 * @param wrkDt
	 */
	public void setWrkDt(String wrkDt) {
		this.wrkDt = wrkDt;
	}
	
	/**
	 * Column Info
	 * @param fmPrdDt
	 */
	public void setFmPrdDt(String fmPrdDt) {
		this.fmPrdDt = fmPrdDt;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
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
		setOvrVolQty(JSPUtil.getParameter(request, prefix + "ovr_vol_qty", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCtrtRt(JSPUtil.getParameter(request, prefix + "ctrt_rt", ""));
		setCalcRmk(JSPUtil.getParameter(request, prefix + "calc_rmk", ""));
		setStkVolQty(JSPUtil.getParameter(request, prefix + "stk_vol_qty", ""));
		setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
		setDiffVolQty(JSPUtil.getParameter(request, prefix + "diff_vol_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setCalcTpCd(JSPUtil.getParameter(request, prefix + "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFpTeuQty(JSPUtil.getParameter(request, prefix + "fp_teu_qty", ""));
		setFpCalcPrdCd(JSPUtil.getParameter(request, prefix + "fp_calc_prd_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVolTrUtCd(JSPUtil.getParameter(request, prefix + "vol_tr_ut_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setInvVolQty(JSPUtil.getParameter(request, prefix + "inv_vol_qty", ""));
		setStoDysIndCd(JSPUtil.getParameter(request, prefix + "sto_dys_ind_cd", ""));
		setWrkDt(JSPUtil.getParameter(request, prefix + "wrk_dt", ""));
		setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesOffdockCYFreePoolHistoryVO[]
	 */
	public TesOffdockCYFreePoolHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesOffdockCYFreePoolHistoryVO[]
	 */
	public TesOffdockCYFreePoolHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesOffdockCYFreePoolHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ovrVolQty = (JSPUtil.getParameter(request, prefix	+ "ovr_vol_qty", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ctrtRt = (JSPUtil.getParameter(request, prefix	+ "ctrt_rt", length));
			String[] calcRmk = (JSPUtil.getParameter(request, prefix	+ "calc_rmk", length));
			String[] stkVolQty = (JSPUtil.getParameter(request, prefix	+ "stk_vol_qty", length));
			String[] toPrdDt = (JSPUtil.getParameter(request, prefix	+ "to_prd_dt", length));
			String[] diffVolQty = (JSPUtil.getParameter(request, prefix	+ "diff_vol_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] calcTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fpTeuQty = (JSPUtil.getParameter(request, prefix	+ "fp_teu_qty", length));
			String[] fpCalcPrdCd = (JSPUtil.getParameter(request, prefix	+ "fp_calc_prd_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] volTrUtCd = (JSPUtil.getParameter(request, prefix	+ "vol_tr_ut_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] invVolQty = (JSPUtil.getParameter(request, prefix	+ "inv_vol_qty", length));
			String[] stoDysIndCd = (JSPUtil.getParameter(request, prefix	+ "sto_dys_ind_cd", length));
			String[] wrkDt = (JSPUtil.getParameter(request, prefix	+ "wrk_dt", length));
			String[] fmPrdDt = (JSPUtil.getParameter(request, prefix	+ "fm_prd_dt", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesOffdockCYFreePoolHistoryVO();
				if (ovrVolQty[i] != null)
					model.setOvrVolQty(ovrVolQty[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ctrtRt[i] != null)
					model.setCtrtRt(ctrtRt[i]);
				if (calcRmk[i] != null)
					model.setCalcRmk(calcRmk[i]);
				if (stkVolQty[i] != null)
					model.setStkVolQty(stkVolQty[i]);
				if (toPrdDt[i] != null)
					model.setToPrdDt(toPrdDt[i]);
				if (diffVolQty[i] != null)
					model.setDiffVolQty(diffVolQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (calcTpCd[i] != null)
					model.setCalcTpCd(calcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fpTeuQty[i] != null)
					model.setFpTeuQty(fpTeuQty[i]);
				if (fpCalcPrdCd[i] != null)
					model.setFpCalcPrdCd(fpCalcPrdCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (volTrUtCd[i] != null)
					model.setVolTrUtCd(volTrUtCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (invVolQty[i] != null)
					model.setInvVolQty(invVolQty[i]);
				if (stoDysIndCd[i] != null)
					model.setStoDysIndCd(stoDysIndCd[i]);
				if (wrkDt[i] != null)
					model.setWrkDt(wrkDt[i]);
				if (fmPrdDt[i] != null)
					model.setFmPrdDt(fmPrdDt[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesOffdockCYFreePoolHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesOffdockCYFreePoolHistoryVO[]
	 */
	public TesOffdockCYFreePoolHistoryVO[] getTesOffdockCYFreePoolHistoryVOs(){
		TesOffdockCYFreePoolHistoryVO[] vos = (TesOffdockCYFreePoolHistoryVO[])models.toArray(new TesOffdockCYFreePoolHistoryVO[models.size()]);
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
		this.ovrVolQty = this.ovrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRt = this.ctrtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcRmk = this.calcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkVolQty = this.stkVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt = this.toPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffVolQty = this.diffVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd = this.calcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fpTeuQty = this.fpTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fpCalcPrdCd = this.fpCalcPrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTrUtCd = this.volTrUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVolQty = this.invVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoDysIndCd = this.stoDysIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkDt = this.wrkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt = this.fmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
