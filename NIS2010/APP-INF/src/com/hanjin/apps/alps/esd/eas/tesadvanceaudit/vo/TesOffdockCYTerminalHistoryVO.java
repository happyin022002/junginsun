/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesOffdockCYTerminalHistoryVO.java
*@FileTitle : TesOffdockCYTerminalHistoryVO
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

public class TesOffdockCYTerminalHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesOffdockCYTerminalHistoryVO> models = new ArrayList<TesOffdockCYTerminalHistoryVO>();
	
	/* Column Info */
	private String n3ptyFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String rvisVolQty = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String ctrtRt = null;
	/* Column Info */
	private String calcRmk = null;
	/* Column Info */
	private String toPrdDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tmlCalcIndCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String calcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String volTrUtCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String fmPrdDt = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String calcVolQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesOffdockCYTerminalHistoryVO() {}

	public TesOffdockCYTerminalHistoryVO(String ibflag, String pagerows, String ydCd, String vndrSeq, String invNo, String issDt, String fmPrdDt, String toPrdDt, String tmlCalcIndCd, String calcTpCd, String lgsCostCd, String cntrTpszCd, String calcVolQty, String rcFlg, String revYrmon, String rvisVolQty, String volTrUtCd, String ctrtRt, String currCd, String invXchRt, String invAmt, String calcRmk, String n3ptyFlg) {
		this.n3ptyFlg = n3ptyFlg;
		this.currCd = currCd;
		this.rvisVolQty = rvisVolQty;
		this.revYrmon = revYrmon;
		this.ctrtRt = ctrtRt;
		this.calcRmk = calcRmk;
		this.toPrdDt = toPrdDt;
		this.pagerows = pagerows;
		this.tmlCalcIndCd = tmlCalcIndCd;
		this.invNo = invNo;
		this.issDt = issDt;
		this.calcTpCd = calcTpCd;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.volTrUtCd = volTrUtCd;
		this.vndrSeq = vndrSeq;
		this.lgsCostCd = lgsCostCd;
		this.cntrTpszCd = cntrTpszCd;
		this.invAmt = invAmt;
		this.rcFlg = rcFlg;
		this.fmPrdDt = fmPrdDt;
		this.invXchRt = invXchRt;
		this.calcVolQty = calcVolQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rvis_vol_qty", getRvisVolQty());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("ctrt_rt", getCtrtRt());
		this.hashColumns.put("calc_rmk", getCalcRmk());
		this.hashColumns.put("to_prd_dt", getToPrdDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tml_calc_ind_cd", getTmlCalcIndCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vol_tr_ut_cd", getVolTrUtCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("calc_vol_qty", getCalcVolQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rvis_vol_qty", "rvisVolQty");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("ctrt_rt", "ctrtRt");
		this.hashFields.put("calc_rmk", "calcRmk");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tml_calc_ind_cd", "tmlCalcIndCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vol_tr_ut_cd", "volTrUtCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("calc_vol_qty", "calcVolQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n3ptyFlg
	 */
	public String getN3ptyFlg() {
		return this.n3ptyFlg;
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
	 * @return rvisVolQty
	 */
	public String getRvisVolQty() {
		return this.rvisVolQty;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
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
	 * @return toPrdDt
	 */
	public String getToPrdDt() {
		return this.toPrdDt;
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
	 * @return tmlCalcIndCd
	 */
	public String getTmlCalcIndCd() {
		return this.tmlCalcIndCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
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
	 * @return calcVolQty
	 */
	public String getCalcVolQty() {
		return this.calcVolQty;
	}
	

	/**
	 * Column Info
	 * @param n3ptyFlg
	 */
	public void setN3ptyFlg(String n3ptyFlg) {
		this.n3ptyFlg = n3ptyFlg;
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
	 * @param rvisVolQty
	 */
	public void setRvisVolQty(String rvisVolQty) {
		this.rvisVolQty = rvisVolQty;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
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
	 * @param toPrdDt
	 */
	public void setToPrdDt(String toPrdDt) {
		this.toPrdDt = toPrdDt;
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
	 * @param tmlCalcIndCd
	 */
	public void setTmlCalcIndCd(String tmlCalcIndCd) {
		this.tmlCalcIndCd = tmlCalcIndCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
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
	 * Column Info
	 * @param calcVolQty
	 */
	public void setCalcVolQty(String calcVolQty) {
		this.calcVolQty = calcVolQty;
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
		setN3ptyFlg(JSPUtil.getParameter(request, prefix + "n3pty_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setRvisVolQty(JSPUtil.getParameter(request, prefix + "rvis_vol_qty", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setCtrtRt(JSPUtil.getParameter(request, prefix + "ctrt_rt", ""));
		setCalcRmk(JSPUtil.getParameter(request, prefix + "calc_rmk", ""));
		setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTmlCalcIndCd(JSPUtil.getParameter(request, prefix + "tml_calc_ind_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setCalcTpCd(JSPUtil.getParameter(request, prefix + "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVolTrUtCd(JSPUtil.getParameter(request, prefix + "vol_tr_ut_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setCalcVolQty(JSPUtil.getParameter(request, prefix + "calc_vol_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesOffdockCYTerminalHistoryVO[]
	 */
	public TesOffdockCYTerminalHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesOffdockCYTerminalHistoryVO[]
	 */
	public TesOffdockCYTerminalHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesOffdockCYTerminalHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] rvisVolQty = (JSPUtil.getParameter(request, prefix	+ "rvis_vol_qty", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] ctrtRt = (JSPUtil.getParameter(request, prefix	+ "ctrt_rt", length));
			String[] calcRmk = (JSPUtil.getParameter(request, prefix	+ "calc_rmk", length));
			String[] toPrdDt = (JSPUtil.getParameter(request, prefix	+ "to_prd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tmlCalcIndCd = (JSPUtil.getParameter(request, prefix	+ "tml_calc_ind_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] calcTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] volTrUtCd = (JSPUtil.getParameter(request, prefix	+ "vol_tr_ut_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] fmPrdDt = (JSPUtil.getParameter(request, prefix	+ "fm_prd_dt", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] calcVolQty = (JSPUtil.getParameter(request, prefix	+ "calc_vol_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesOffdockCYTerminalHistoryVO();
				if (n3ptyFlg[i] != null)
					model.setN3ptyFlg(n3ptyFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (rvisVolQty[i] != null)
					model.setRvisVolQty(rvisVolQty[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (ctrtRt[i] != null)
					model.setCtrtRt(ctrtRt[i]);
				if (calcRmk[i] != null)
					model.setCalcRmk(calcRmk[i]);
				if (toPrdDt[i] != null)
					model.setToPrdDt(toPrdDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tmlCalcIndCd[i] != null)
					model.setTmlCalcIndCd(tmlCalcIndCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (calcTpCd[i] != null)
					model.setCalcTpCd(calcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (volTrUtCd[i] != null)
					model.setVolTrUtCd(volTrUtCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (fmPrdDt[i] != null)
					model.setFmPrdDt(fmPrdDt[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (calcVolQty[i] != null)
					model.setCalcVolQty(calcVolQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesOffdockCYTerminalHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesOffdockCYTerminalHistoryVO[]
	 */
	public TesOffdockCYTerminalHistoryVO[] getTesOffdockCYTerminalHistoryVOs(){
		TesOffdockCYTerminalHistoryVO[] vos = (TesOffdockCYTerminalHistoryVO[])models.toArray(new TesOffdockCYTerminalHistoryVO[models.size()]);
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
		this.n3ptyFlg = this.n3ptyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisVolQty = this.rvisVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRt = this.ctrtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcRmk = this.calcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt = this.toPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCalcIndCd = this.tmlCalcIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd = this.calcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTrUtCd = this.volTrUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt = this.fmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcVolQty = this.calcVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
