/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BRKGCommDetailHistorybyBLVO.java
*@FileTitle : BRKGCommDetailHistorybyBLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.10.08 이호진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo;

import java.lang.reflect.Field;
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
 * @author 이호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BRKGCommDetailHistorybyBLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BRKGCommDetailHistorybyBLVO> models = new ArrayList<BRKGCommDetailHistorybyBLVO>();
	
	/* Column Info */
	private String brogSeq = null;
	/* Column Info */
	private String commProcStsCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String agmtCustSeq = null;
	/* Column Info */
	private String actCommAble = null;
	/* Column Info */
	private String brogTeuRt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actIfCommAmt = null;
	/* Column Info */
	private String brogIfDt = null;
	/* Column Info */
	private String actCommAmt = null;
	/* Column Info */
	private String bkgRfQty = null;
	/* Column Info */
	private String bkgBxQty = null;
	/* Column Info */
	private String brogRfRt = null;
	/* Column Info */
	private String commProcRsltRsn = null;
	/* Column Info */
	private String brogFeuRt = null;
	/* Column Info */
	private String agmtRtSeq = null;
	/* Column Info */
	private String cntrCommAmt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String brogBxRt = null;
	/* Column Info */
	private String agmtCntCd = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String brogBkgRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BRKGCommDetailHistorybyBLVO() {}

	public BRKGCommDetailHistorybyBLVO(String ibflag, String pagerows, String brogSeq, String actCommAble, String brogBkgRt, String actCommAmt, String bkgBxQty, String brogBxRt, String bkgTeuQty, String brogTeuRt, String bkgFeuQty, String brogFeuRt, String bkgRfQty, String brogRfRt, String cntrCommAmt, String actIfCommAmt, String creDt, String commProcStsCd, String commProcRsltRsn, String brogIfDt, String agmtCntCd, String agmtCustSeq, String agmtRtSeq, String bkgNo, String blNo) {
		this.brogSeq = brogSeq;
		this.commProcStsCd = commProcStsCd;
		this.creDt = creDt;
		this.agmtCustSeq = agmtCustSeq;
		this.actCommAble = actCommAble;
		this.brogTeuRt = brogTeuRt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.bkgFeuQty = bkgFeuQty;
		this.ibflag = ibflag;
		this.actIfCommAmt = actIfCommAmt;
		this.brogIfDt = brogIfDt;
		this.actCommAmt = actCommAmt;
		this.bkgRfQty = bkgRfQty;
		this.bkgBxQty = bkgBxQty;
		this.brogRfRt = brogRfRt;
		this.commProcRsltRsn = commProcRsltRsn;
		this.brogFeuRt = brogFeuRt;
		this.agmtRtSeq = agmtRtSeq;
		this.cntrCommAmt = cntrCommAmt;
		this.bkgNo = bkgNo;
		this.brogBxRt = brogBxRt;
		this.agmtCntCd = agmtCntCd;
		this.bkgTeuQty = bkgTeuQty;
		this.brogBkgRt = brogBkgRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("brog_seq", getBrogSeq());
		this.hashColumns.put("comm_proc_sts_cd", getCommProcStsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("agmt_cust_seq", getAgmtCustSeq());
		this.hashColumns.put("act_comm_able", getActCommAble());
		this.hashColumns.put("brog_teu_rt", getBrogTeuRt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_if_comm_amt", getActIfCommAmt());
		this.hashColumns.put("brog_if_dt", getBrogIfDt());
		this.hashColumns.put("act_comm_amt", getActCommAmt());
		this.hashColumns.put("bkg_rf_qty", getBkgRfQty());
		this.hashColumns.put("bkg_bx_qty", getBkgBxQty());
		this.hashColumns.put("brog_rf_rt", getBrogRfRt());
		this.hashColumns.put("comm_proc_rslt_rsn", getCommProcRsltRsn());
		this.hashColumns.put("brog_feu_rt", getBrogFeuRt());
		this.hashColumns.put("agmt_rt_seq", getAgmtRtSeq());
		this.hashColumns.put("cntr_comm_amt", getCntrCommAmt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("brog_bx_rt", getBrogBxRt());
		this.hashColumns.put("agmt_cnt_cd", getAgmtCntCd());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("brog_bkg_rt", getBrogBkgRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("brog_seq", "brogSeq");
		this.hashFields.put("comm_proc_sts_cd", "commProcStsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("agmt_cust_seq", "agmtCustSeq");
		this.hashFields.put("act_comm_able", "actCommAble");
		this.hashFields.put("brog_teu_rt", "brogTeuRt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_if_comm_amt", "actIfCommAmt");
		this.hashFields.put("brog_if_dt", "brogIfDt");
		this.hashFields.put("act_comm_amt", "actCommAmt");
		this.hashFields.put("bkg_rf_qty", "bkgRfQty");
		this.hashFields.put("bkg_bx_qty", "bkgBxQty");
		this.hashFields.put("brog_rf_rt", "brogRfRt");
		this.hashFields.put("comm_proc_rslt_rsn", "commProcRsltRsn");
		this.hashFields.put("brog_feu_rt", "brogFeuRt");
		this.hashFields.put("agmt_rt_seq", "agmtRtSeq");
		this.hashFields.put("cntr_comm_amt", "cntrCommAmt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("brog_bx_rt", "brogBxRt");
		this.hashFields.put("agmt_cnt_cd", "agmtCntCd");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("brog_bkg_rt", "brogBkgRt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return brogSeq
	 */
	public String getBrogSeq() {
		return this.brogSeq;
	}
	
	/**
	 * Column Info
	 * @return commProcStsCd
	 */
	public String getCommProcStsCd() {
		return this.commProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return agmtCustSeq
	 */
	public String getAgmtCustSeq() {
		return this.agmtCustSeq;
	}
	
	/**
	 * Column Info
	 * @return actCommAble
	 */
	public String getActCommAble() {
		return this.actCommAble;
	}
	
	/**
	 * Column Info
	 * @return brogTeuRt
	 */
	public String getBrogTeuRt() {
		return this.brogTeuRt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return bkgFeuQty
	 */
	public String getBkgFeuQty() {
		return this.bkgFeuQty;
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
	 * @return actIfCommAmt
	 */
	public String getActIfCommAmt() {
		return this.actIfCommAmt;
	}
	
	/**
	 * Column Info
	 * @return brogIfDt
	 */
	public String getBrogIfDt() {
		return this.brogIfDt;
	}
	
	/**
	 * Column Info
	 * @return actCommAmt
	 */
	public String getActCommAmt() {
		return this.actCommAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgRfQty
	 */
	public String getBkgRfQty() {
		return this.bkgRfQty;
	}
	
	/**
	 * Column Info
	 * @return bkgBxQty
	 */
	public String getBkgBxQty() {
		return this.bkgBxQty;
	}
	
	/**
	 * Column Info
	 * @return brogRfRt
	 */
	public String getBrogRfRt() {
		return this.brogRfRt;
	}
	
	/**
	 * Column Info
	 * @return commProcRsltRsn
	 */
	public String getCommProcRsltRsn() {
		return this.commProcRsltRsn;
	}
	
	/**
	 * Column Info
	 * @return brogFeuRt
	 */
	public String getBrogFeuRt() {
		return this.brogFeuRt;
	}
	
	/**
	 * Column Info
	 * @return agmtRtSeq
	 */
	public String getAgmtRtSeq() {
		return this.agmtRtSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrCommAmt
	 */
	public String getCntrCommAmt() {
		return this.cntrCommAmt;
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
	 * @return brogBxRt
	 */
	public String getBrogBxRt() {
		return this.brogBxRt;
	}
	
	/**
	 * Column Info
	 * @return agmtCntCd
	 */
	public String getAgmtCntCd() {
		return this.agmtCntCd;
	}
	
	/**
	 * Column Info
	 * @return bkgTeuQty
	 */
	public String getBkgTeuQty() {
		return this.bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @return brogBkgRt
	 */
	public String getBrogBkgRt() {
		return this.brogBkgRt;
	}
	

	/**
	 * Column Info
	 * @param brogSeq
	 */
	public void setBrogSeq(String brogSeq) {
		this.brogSeq = brogSeq;
	}
	
	/**
	 * Column Info
	 * @param commProcStsCd
	 */
	public void setCommProcStsCd(String commProcStsCd) {
		this.commProcStsCd = commProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param agmtCustSeq
	 */
	public void setAgmtCustSeq(String agmtCustSeq) {
		this.agmtCustSeq = agmtCustSeq;
	}
	
	/**
	 * Column Info
	 * @param actCommAble
	 */
	public void setActCommAble(String actCommAble) {
		this.actCommAble = actCommAble;
	}
	
	/**
	 * Column Info
	 * @param brogTeuRt
	 */
	public void setBrogTeuRt(String brogTeuRt) {
		this.brogTeuRt = brogTeuRt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param bkgFeuQty
	 */
	public void setBkgFeuQty(String bkgFeuQty) {
		this.bkgFeuQty = bkgFeuQty;
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
	 * @param actIfCommAmt
	 */
	public void setActIfCommAmt(String actIfCommAmt) {
		this.actIfCommAmt = actIfCommAmt;
	}
	
	/**
	 * Column Info
	 * @param brogIfDt
	 */
	public void setBrogIfDt(String brogIfDt) {
		this.brogIfDt = brogIfDt;
	}
	
	/**
	 * Column Info
	 * @param actCommAmt
	 */
	public void setActCommAmt(String actCommAmt) {
		this.actCommAmt = actCommAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgRfQty
	 */
	public void setBkgRfQty(String bkgRfQty) {
		this.bkgRfQty = bkgRfQty;
	}
	
	/**
	 * Column Info
	 * @param bkgBxQty
	 */
	public void setBkgBxQty(String bkgBxQty) {
		this.bkgBxQty = bkgBxQty;
	}
	
	/**
	 * Column Info
	 * @param brogRfRt
	 */
	public void setBrogRfRt(String brogRfRt) {
		this.brogRfRt = brogRfRt;
	}
	
	/**
	 * Column Info
	 * @param commProcRsltRsn
	 */
	public void setCommProcRsltRsn(String commProcRsltRsn) {
		this.commProcRsltRsn = commProcRsltRsn;
	}
	
	/**
	 * Column Info
	 * @param brogFeuRt
	 */
	public void setBrogFeuRt(String brogFeuRt) {
		this.brogFeuRt = brogFeuRt;
	}
	
	/**
	 * Column Info
	 * @param agmtRtSeq
	 */
	public void setAgmtRtSeq(String agmtRtSeq) {
		this.agmtRtSeq = agmtRtSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrCommAmt
	 */
	public void setCntrCommAmt(String cntrCommAmt) {
		this.cntrCommAmt = cntrCommAmt;
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
	 * @param brogBxRt
	 */
	public void setBrogBxRt(String brogBxRt) {
		this.brogBxRt = brogBxRt;
	}
	
	/**
	 * Column Info
	 * @param agmtCntCd
	 */
	public void setAgmtCntCd(String agmtCntCd) {
		this.agmtCntCd = agmtCntCd;
	}
	
	/**
	 * Column Info
	 * @param bkgTeuQty
	 */
	public void setBkgTeuQty(String bkgTeuQty) {
		this.bkgTeuQty = bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @param brogBkgRt
	 */
	public void setBrogBkgRt(String brogBkgRt) {
		this.brogBkgRt = brogBkgRt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBrogSeq(JSPUtil.getParameter(request, "brog_seq", ""));
		setCommProcStsCd(JSPUtil.getParameter(request, "comm_proc_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAgmtCustSeq(JSPUtil.getParameter(request, "agmt_cust_seq", ""));
		setActCommAble(JSPUtil.getParameter(request, "act_comm_able", ""));
		setBrogTeuRt(JSPUtil.getParameter(request, "brog_teu_rt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, "bkg_feu_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActIfCommAmt(JSPUtil.getParameter(request, "act_if_comm_amt", ""));
		setBrogIfDt(JSPUtil.getParameter(request, "brog_if_dt", ""));
		setActCommAmt(JSPUtil.getParameter(request, "act_comm_amt", ""));
		setBkgRfQty(JSPUtil.getParameter(request, "bkg_rf_qty", ""));
		setBkgBxQty(JSPUtil.getParameter(request, "bkg_bx_qty", ""));
		setBrogRfRt(JSPUtil.getParameter(request, "brog_rf_rt", ""));
		setCommProcRsltRsn(JSPUtil.getParameter(request, "comm_proc_rslt_rsn", ""));
		setBrogFeuRt(JSPUtil.getParameter(request, "brog_feu_rt", ""));
		setAgmtRtSeq(JSPUtil.getParameter(request, "agmt_rt_seq", ""));
		setCntrCommAmt(JSPUtil.getParameter(request, "cntr_comm_amt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBrogBxRt(JSPUtil.getParameter(request, "brog_bx_rt", ""));
		setAgmtCntCd(JSPUtil.getParameter(request, "agmt_cnt_cd", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, "bkg_teu_qty", ""));
		setBrogBkgRt(JSPUtil.getParameter(request, "brog_bkg_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BRKGCommDetailHistorybyBLVO[]
	 */
	public BRKGCommDetailHistorybyBLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BRKGCommDetailHistorybyBLVO[]
	 */
	public BRKGCommDetailHistorybyBLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BRKGCommDetailHistorybyBLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] brogSeq = (JSPUtil.getParameter(request, prefix	+ "brog_seq", length));
			String[] commProcStsCd = (JSPUtil.getParameter(request, prefix	+ "comm_proc_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] agmtCustSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_cust_seq", length));
			String[] actCommAble = (JSPUtil.getParameter(request, prefix	+ "act_comm_able", length));
			String[] brogTeuRt = (JSPUtil.getParameter(request, prefix	+ "brog_teu_rt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actIfCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_if_comm_amt", length));
			String[] brogIfDt = (JSPUtil.getParameter(request, prefix	+ "brog_if_dt", length));
			String[] actCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_comm_amt", length));
			String[] bkgRfQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_qty", length));
			String[] bkgBxQty = (JSPUtil.getParameter(request, prefix	+ "bkg_bx_qty", length));
			String[] brogRfRt = (JSPUtil.getParameter(request, prefix	+ "brog_rf_rt", length));
			String[] commProcRsltRsn = (JSPUtil.getParameter(request, prefix	+ "comm_proc_rslt_rsn", length));
			String[] brogFeuRt = (JSPUtil.getParameter(request, prefix	+ "brog_feu_rt", length));
			String[] agmtRtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_rt_seq", length));
			String[] cntrCommAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_comm_amt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] brogBxRt = (JSPUtil.getParameter(request, prefix	+ "brog_bx_rt", length));
			String[] agmtCntCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cnt_cd", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] brogBkgRt = (JSPUtil.getParameter(request, prefix	+ "brog_bkg_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BRKGCommDetailHistorybyBLVO();
				if (brogSeq[i] != null)
					model.setBrogSeq(brogSeq[i]);
				if (commProcStsCd[i] != null)
					model.setCommProcStsCd(commProcStsCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (agmtCustSeq[i] != null)
					model.setAgmtCustSeq(agmtCustSeq[i]);
				if (actCommAble[i] != null)
					model.setActCommAble(actCommAble[i]);
				if (brogTeuRt[i] != null)
					model.setBrogTeuRt(brogTeuRt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actIfCommAmt[i] != null)
					model.setActIfCommAmt(actIfCommAmt[i]);
				if (brogIfDt[i] != null)
					model.setBrogIfDt(brogIfDt[i]);
				if (actCommAmt[i] != null)
					model.setActCommAmt(actCommAmt[i]);
				if (bkgRfQty[i] != null)
					model.setBkgRfQty(bkgRfQty[i]);
				if (bkgBxQty[i] != null)
					model.setBkgBxQty(bkgBxQty[i]);
				if (brogRfRt[i] != null)
					model.setBrogRfRt(brogRfRt[i]);
				if (commProcRsltRsn[i] != null)
					model.setCommProcRsltRsn(commProcRsltRsn[i]);
				if (brogFeuRt[i] != null)
					model.setBrogFeuRt(brogFeuRt[i]);
				if (agmtRtSeq[i] != null)
					model.setAgmtRtSeq(agmtRtSeq[i]);
				if (cntrCommAmt[i] != null)
					model.setCntrCommAmt(cntrCommAmt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (brogBxRt[i] != null)
					model.setBrogBxRt(brogBxRt[i]);
				if (agmtCntCd[i] != null)
					model.setAgmtCntCd(agmtCntCd[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (brogBkgRt[i] != null)
					model.setBrogBkgRt(brogBkgRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBRKGCommDetailHistorybyBLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BRKGCommDetailHistorybyBLVO[]
	 */
	public BRKGCommDetailHistorybyBLVO[] getBRKGCommDetailHistorybyBLVOs(){
		BRKGCommDetailHistorybyBLVO[] vos = (BRKGCommDetailHistorybyBLVO[])models.toArray(new BRKGCommDetailHistorybyBLVO[models.size()]);
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
		this.brogSeq = this.brogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commProcStsCd = this.commProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCustSeq = this.agmtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAble = this.actCommAble .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogTeuRt = this.brogTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actIfCommAmt = this.actIfCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogIfDt = this.brogIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAmt = this.actCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfQty = this.bkgRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBxQty = this.bkgBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogRfRt = this.brogRfRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commProcRsltRsn = this.commProcRsltRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogFeuRt = this.brogFeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRtSeq = this.agmtRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCommAmt = this.cntrCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogBxRt = this.brogBxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCntCd = this.agmtCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogBkgRt = this.brogBkgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
