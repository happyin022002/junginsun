/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommCalcHistoryVO.java
*@FileTitle : AGNCommCalcHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.07.09 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AGNCommCalcHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AGNCommCalcHistoryVO> models = new ArrayList<AGNCommCalcHistoryVO>();

	/* Column Info */
	private String calcNo = null;
	/* Column Info */
	private String crntRevAmt = null;
	/* Column Info */
	private String ddctTrspAmt = null;
	/* Column Info */
	private String commVvd = null;
	/* Column Info */
	private String ddctChgAmt = null;
	/* Column Info */
	private String evtTp = null;
	/* Column Info */
	private String evtDt = null;
	/* Column Info */
	private String bkgCnt = null;
	/* Column Info */
	private String calcSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String evtGmtDt = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnAgmtNo = null;
	/* Column Info */
	private String agnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String acSeq = null;
	/* Column Info */
	private String crntAmt = null;
	/* Column Info */
	private String ddctSpclCmpnAmt = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String acStsCd = null;
	/* Column Info */
	private String acTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public AGNCommCalcHistoryVO() {}

	public AGNCommCalcHistoryVO(String ibflag, String pagerows, String bkgNo, String evtDt, String evtGmtDt, String evtTp, String agnCd, String agnAgmtNo, String commVvd, String ioBndCd, String sailArrDt, String acTpCd, String calcSeq, String acStsCd, String ifAmt, String crntAmt, String bkgCnt, String crntRevAmt, String ddctChgAmt, String ddctTrspAmt, String ddctSpclCmpnAmt, String acSeq, String calcNo) {
		this.calcNo = calcNo;
		this.crntRevAmt = crntRevAmt;
		this.ddctTrspAmt = ddctTrspAmt;
		this.commVvd = commVvd;
		this.ddctChgAmt = ddctChgAmt;
		this.evtTp = evtTp;
		this.evtDt = evtDt;
		this.bkgCnt = bkgCnt;
		this.calcSeq = calcSeq;
		this.ioBndCd = ioBndCd;
		this.evtGmtDt = evtGmtDt;
		this.sailArrDt = sailArrDt;
		this.pagerows = pagerows;
		this.agnAgmtNo = agnAgmtNo;
		this.agnCd = agnCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.acSeq = acSeq;
		this.crntAmt = crntAmt;
		this.ddctSpclCmpnAmt = ddctSpclCmpnAmt;
		this.ifAmt = ifAmt;
		this.acStsCd = acStsCd;
		this.acTpCd = acTpCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("calc_no", getCalcNo());
		this.hashColumns.put("crnt_rev_amt", getCrntRevAmt());
		this.hashColumns.put("ddct_trsp_amt", getDdctTrspAmt());
		this.hashColumns.put("comm_vvd", getCommVvd());
		this.hashColumns.put("ddct_chg_amt", getDdctChgAmt());
		this.hashColumns.put("evt_tp", getEvtTp());
		this.hashColumns.put("evt_dt", getEvtDt());
		this.hashColumns.put("bkg_cnt", getBkgCnt());
		this.hashColumns.put("calc_seq", getCalcSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("evt_gmt_dt", getEvtGmtDt());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_agmt_no", getAgnAgmtNo());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ac_seq", getAcSeq());
		this.hashColumns.put("crnt_amt", getCrntAmt());
		this.hashColumns.put("ddct_spcl_cmpn_amt", getDdctSpclCmpnAmt());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("ac_sts_cd", getAcStsCd());
		this.hashColumns.put("ac_tp_cd", getAcTpCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("calc_no", "calcNo");
		this.hashFields.put("crnt_rev_amt", "crntRevAmt");
		this.hashFields.put("ddct_trsp_amt", "ddctTrspAmt");
		this.hashFields.put("comm_vvd", "commVvd");
		this.hashFields.put("ddct_chg_amt", "ddctChgAmt");
		this.hashFields.put("evt_tp", "evtTp");
		this.hashFields.put("evt_dt", "evtDt");
		this.hashFields.put("bkg_cnt", "bkgCnt");
		this.hashFields.put("calc_seq", "calcSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("evt_gmt_dt", "evtGmtDt");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_agmt_no", "agnAgmtNo");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ac_seq", "acSeq");
		this.hashFields.put("crnt_amt", "crntAmt");
		this.hashFields.put("ddct_spcl_cmpn_amt", "ddctSpclCmpnAmt");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("ac_sts_cd", "acStsCd");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return calcNo
	 */
	public String getCalcNo() {
		return this.calcNo;
	}

	/**
	 * Column Info
	 * @return crntRevAmt
	 */
	public String getCrntRevAmt() {
		return this.crntRevAmt;
	}

	/**
	 * Column Info
	 * @return ddctTrspAmt
	 */
	public String getDdctTrspAmt() {
		return this.ddctTrspAmt;
	}

	/**
	 * Column Info
	 * @return commVvd
	 */
	public String getCommVvd() {
		return this.commVvd;
	}

	/**
	 * Column Info
	 * @return ddctChgAmt
	 */
	public String getDdctChgAmt() {
		return this.ddctChgAmt;
	}

	/**
	 * Column Info
	 * @return evtTp
	 */
	public String getEvtTp() {
		return this.evtTp;
	}

	/**
	 * Column Info
	 * @return evtDt
	 */
	public String getEvtDt() {
		return this.evtDt;
	}

	/**
	 * Column Info
	 * @return bkgCnt
	 */
	public String getBkgCnt() {
		return this.bkgCnt;
	}

	/**
	 * Column Info
	 * @return calcSeq
	 */
	public String getCalcSeq() {
		return this.calcSeq;
	}

	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}

	/**
	 * Column Info
	 * @return evtGmtDt
	 */
	public String getEvtGmtDt() {
		return this.evtGmtDt;
	}

	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
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
	 * @return agnAgmtNo
	 */
	public String getAgnAgmtNo() {
		return this.agnAgmtNo;
	}

	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return acSeq
	 */
	public String getAcSeq() {
		return this.acSeq;
	}

	/**
	 * Column Info
	 * @return crntAmt
	 */
	public String getCrntAmt() {
		return this.crntAmt;
	}

	/**
	 * Column Info
	 * @return ddctSpclCmpnAmt
	 */
	public String getDdctSpclCmpnAmt() {
		return this.ddctSpclCmpnAmt;
	}

	/**
	 * Column Info
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
	}

	/**
	 * Column Info
	 * @return acStsCd
	 */
	public String getAcStsCd() {
		return this.acStsCd;
	}

	/**
	 * Column Info
	 * @return acTpCd
	 */
	public String getAcTpCd() {
		return this.acTpCd;
	}


	/**
	 * Column Info
	 * @param calcNo
	 */
	public void setCalcNo(String calcNo) {
		this.calcNo = calcNo;
	}

	/**
	 * Column Info
	 * @param crntRevAmt
	 */
	public void setCrntRevAmt(String crntRevAmt) {
		this.crntRevAmt = crntRevAmt;
	}

	/**
	 * Column Info
	 * @param ddctTrspAmt
	 */
	public void setDdctTrspAmt(String ddctTrspAmt) {
		this.ddctTrspAmt = ddctTrspAmt;
	}

	/**
	 * Column Info
	 * @param commVvd
	 */
	public void setCommVvd(String commVvd) {
		this.commVvd = commVvd;
	}

	/**
	 * Column Info
	 * @param ddctChgAmt
	 */
	public void setDdctChgAmt(String ddctChgAmt) {
		this.ddctChgAmt = ddctChgAmt;
	}

	/**
	 * Column Info
	 * @param evtTp
	 */
	public void setEvtTp(String evtTp) {
		this.evtTp = evtTp;
	}

	/**
	 * Column Info
	 * @param evtDt
	 */
	public void setEvtDt(String evtDt) {
		this.evtDt = evtDt;
	}

	/**
	 * Column Info
	 * @param bkgCnt
	 */
	public void setBkgCnt(String bkgCnt) {
		this.bkgCnt = bkgCnt;
	}

	/**
	 * Column Info
	 * @param calcSeq
	 */
	public void setCalcSeq(String calcSeq) {
		this.calcSeq = calcSeq;
	}

	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * Column Info
	 * @param evtGmtDt
	 */
	public void setEvtGmtDt(String evtGmtDt) {
		this.evtGmtDt = evtGmtDt;
	}

	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
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
	 * @param agnAgmtNo
	 */
	public void setAgnAgmtNo(String agnAgmtNo) {
		this.agnAgmtNo = agnAgmtNo;
	}

	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param acSeq
	 */
	public void setAcSeq(String acSeq) {
		this.acSeq = acSeq;
	}

	/**
	 * Column Info
	 * @param crntAmt
	 */
	public void setCrntAmt(String crntAmt) {
		this.crntAmt = crntAmt;
	}

	/**
	 * Column Info
	 * @param ddctSpclCmpnAmt
	 */
	public void setDdctSpclCmpnAmt(String ddctSpclCmpnAmt) {
		this.ddctSpclCmpnAmt = ddctSpclCmpnAmt;
	}

	/**
	 * Column Info
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
	}

	/**
	 * Column Info
	 * @param acStsCd
	 */
	public void setAcStsCd(String acStsCd) {
		this.acStsCd = acStsCd;
	}

	/**
	 * Column Info
	 * @param acTpCd
	 */
	public void setAcTpCd(String acTpCd) {
		this.acTpCd = acTpCd;
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
		setCalcNo(JSPUtil.getParameter(request, prefix + "calc_no", ""));
		setCrntRevAmt(JSPUtil.getParameter(request, prefix + "crnt_rev_amt", ""));
		setDdctTrspAmt(JSPUtil.getParameter(request, prefix + "ddct_trsp_amt", ""));
		setCommVvd(JSPUtil.getParameter(request, prefix + "comm_vvd", ""));
		setDdctChgAmt(JSPUtil.getParameter(request, prefix + "ddct_chg_amt", ""));
		setEvtTp(JSPUtil.getParameter(request, prefix + "evt_tp", ""));
		setEvtDt(JSPUtil.getParameter(request, prefix + "evt_dt", ""));
		setBkgCnt(JSPUtil.getParameter(request, prefix + "bkg_cnt", ""));
		setCalcSeq(JSPUtil.getParameter(request, prefix + "calc_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setEvtGmtDt(JSPUtil.getParameter(request, prefix + "evt_gmt_dt", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnAgmtNo(JSPUtil.getParameter(request, prefix + "agn_agmt_no", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setAcSeq(JSPUtil.getParameter(request, prefix + "ac_seq", ""));
		setCrntAmt(JSPUtil.getParameter(request, prefix + "crnt_amt", ""));
		setDdctSpclCmpnAmt(JSPUtil.getParameter(request, prefix + "ddct_spcl_cmpn_amt", ""));
		setIfAmt(JSPUtil.getParameter(request, prefix + "if_amt", ""));
		setAcStsCd(JSPUtil.getParameter(request, prefix + "ac_sts_cd", ""));
		setAcTpCd(JSPUtil.getParameter(request, prefix + "ac_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGNCommCalcHistoryVO[]
	 */
	public AGNCommCalcHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AGNCommCalcHistoryVO[]
	 */
	public AGNCommCalcHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AGNCommCalcHistoryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] calcNo = (JSPUtil.getParameter(request, prefix	+ "calc_no", length));
			String[] crntRevAmt = (JSPUtil.getParameter(request, prefix	+ "crnt_rev_amt", length));
			String[] ddctTrspAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_trsp_amt", length));
			String[] commVvd = (JSPUtil.getParameter(request, prefix	+ "comm_vvd", length));
			String[] ddctChgAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_chg_amt", length));
			String[] evtTp = (JSPUtil.getParameter(request, prefix	+ "evt_tp", length));
			String[] evtDt = (JSPUtil.getParameter(request, prefix	+ "evt_dt", length));
			String[] bkgCnt = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt", length));
			String[] calcSeq = (JSPUtil.getParameter(request, prefix	+ "calc_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] evtGmtDt = (JSPUtil.getParameter(request, prefix	+ "evt_gmt_dt", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnAgmtNo = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_no", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] acSeq = (JSPUtil.getParameter(request, prefix	+ "ac_seq", length));
			String[] crntAmt = (JSPUtil.getParameter(request, prefix	+ "crnt_amt", length));
			String[] ddctSpclCmpnAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_spcl_cmpn_amt", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] acStsCd = (JSPUtil.getParameter(request, prefix	+ "ac_sts_cd", length));
			String[] acTpCd = (JSPUtil.getParameter(request, prefix	+ "ac_tp_cd", length));

			for (int i = 0; i < length; i++) {
				model = new AGNCommCalcHistoryVO();
				if (calcNo[i] != null)
					model.setCalcNo(calcNo[i]);
				if (crntRevAmt[i] != null)
					model.setCrntRevAmt(crntRevAmt[i]);
				if (ddctTrspAmt[i] != null)
					model.setDdctTrspAmt(ddctTrspAmt[i]);
				if (commVvd[i] != null)
					model.setCommVvd(commVvd[i]);
				if (ddctChgAmt[i] != null)
					model.setDdctChgAmt(ddctChgAmt[i]);
				if (evtTp[i] != null)
					model.setEvtTp(evtTp[i]);
				if (evtDt[i] != null)
					model.setEvtDt(evtDt[i]);
				if (bkgCnt[i] != null)
					model.setBkgCnt(bkgCnt[i]);
				if (calcSeq[i] != null)
					model.setCalcSeq(calcSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (evtGmtDt[i] != null)
					model.setEvtGmtDt(evtGmtDt[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnAgmtNo[i] != null)
					model.setAgnAgmtNo(agnAgmtNo[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (acSeq[i] != null)
					model.setAcSeq(acSeq[i]);
				if (crntAmt[i] != null)
					model.setCrntAmt(crntAmt[i]);
				if (ddctSpclCmpnAmt[i] != null)
					model.setDdctSpclCmpnAmt(ddctSpclCmpnAmt[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (acStsCd[i] != null)
					model.setAcStsCd(acStsCd[i]);
				if (acTpCd[i] != null)
					model.setAcTpCd(acTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAGNCommCalcHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AGNCommCalcHistoryVO[]
	 */
	public AGNCommCalcHistoryVO[] getAGNCommCalcHistoryVOs(){
		AGNCommCalcHistoryVO[] vos = (AGNCommCalcHistoryVO[])models.toArray(new AGNCommCalcHistoryVO[models.size()]);
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
		this.calcNo = this.calcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntRevAmt = this.crntRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctTrspAmt = this.ddctTrspAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commVvd = this.commVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctChgAmt = this.ddctChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evtTp = this.evtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evtDt = this.evtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCnt = this.bkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcSeq = this.calcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evtGmtDt = this.evtGmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtNo = this.agnAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acSeq = this.acSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntAmt = this.crntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctSpclCmpnAmt = this.ddctSpclCmpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acStsCd = this.acStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd = this.acTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
