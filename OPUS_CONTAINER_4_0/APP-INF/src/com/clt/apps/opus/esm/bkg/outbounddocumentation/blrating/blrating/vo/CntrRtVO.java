/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRtVO.java
*@FileTitle : CntrRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.11.10 김영출 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 김영출
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrRtVO> models = new ArrayList<CntrRtVO>();
	
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String n3ptyCustSeq = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cgoCateCd = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String n3ptyCustCntCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String n3ptyRcvOfcCd = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String cntrRtSeq = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String frtInclXcldDivCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String imdgClssCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrRtVO() {}

	public CntrRtVO(String ibflag, String pagerows, String bkgNo, String cntrRtSeq, String cntrNo, String cntrTpszCd, String chgCd, String currCd, String chgUtAmt, String ratAsQty, String bkgQty, String ratUtCd, String chgAmt, String frtInclXcldDivCd, String frtTermCd, String n3ptyRcvOfcCd, String n3ptyCustCntCd, String n3ptyCustSeq, String cgoCateCd, String rcvTermCd, String deTermCd, String imdgClssCd, String dpSeq, String creUsrId, String updUsrId) {
		this.dpSeq = dpSeq;
		this.currCd = currCd;
		this.n3ptyCustSeq = n3ptyCustSeq;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cgoCateCd = cgoCateCd;
		this.bkgQty = bkgQty;
		this.chgAmt = chgAmt;
		this.cntrTpszCd = cntrTpszCd;
		this.n3ptyCustCntCd = n3ptyCustCntCd;
		this.rcvTermCd = rcvTermCd;
		this.updUsrId = updUsrId;
		this.chgUtAmt = chgUtAmt;
		this.n3ptyRcvOfcCd = n3ptyRcvOfcCd;
		this.frtTermCd = frtTermCd;
		this.cntrRtSeq = cntrRtSeq;
		this.ratUtCd = ratUtCd;
		this.frtInclXcldDivCd = frtInclXcldDivCd;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.cntrNo = cntrNo;
		this.ratAsQty = ratAsQty;
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("n3pty_cust_seq", getN3ptyCustSeq());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cgo_cate_cd", getCgoCateCd());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("n3pty_cust_cnt_cd", getN3ptyCustCntCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("n3pty_rcv_ofc_cd", getN3ptyRcvOfcCd());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("cntr_rt_seq", getCntrRtSeq());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("frt_incl_xcld_div_cd", getFrtInclXcldDivCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("n3pty_cust_seq", "n3ptyCustSeq");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cgo_cate_cd", "cgoCateCd");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("n3pty_cust_cnt_cd", "n3ptyCustCntCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("n3pty_rcv_ofc_cd", "n3ptyRcvOfcCd");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("cntr_rt_seq", "cntrRtSeq");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("frt_incl_xcld_div_cd", "frtInclXcldDivCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
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
	 * @return n3ptyCustSeq
	 */
	public String getN3ptyCustSeq() {
		return this.n3ptyCustSeq;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return cgoCateCd
	 */
	public String getCgoCateCd() {
		return this.cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
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
	 * @return n3ptyCustCntCd
	 */
	public String getN3ptyCustCntCd() {
		return this.n3ptyCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return chgUtAmt
	 */
	public String getChgUtAmt() {
		return this.chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyRcvOfcCd
	 */
	public String getN3ptyRcvOfcCd() {
		return this.n3ptyRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @return cntrRtSeq
	 */
	public String getCntrRtSeq() {
		return this.cntrRtSeq;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return frtInclXcldDivCd
	 */
	public String getFrtInclXcldDivCd() {
		return this.frtInclXcldDivCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	

	/**
	 * Column Info
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
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
	 * @param n3ptyCustSeq
	 */
	public void setN3ptyCustSeq(String n3ptyCustSeq) {
		this.n3ptyCustSeq = n3ptyCustSeq;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param cgoCateCd
	 */
	public void setCgoCateCd(String cgoCateCd) {
		this.cgoCateCd = cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
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
	 * @param n3ptyCustCntCd
	 */
	public void setN3ptyCustCntCd(String n3ptyCustCntCd) {
		this.n3ptyCustCntCd = n3ptyCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param chgUtAmt
	 */
	public void setChgUtAmt(String chgUtAmt) {
		this.chgUtAmt = chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyRcvOfcCd
	 */
	public void setN3ptyRcvOfcCd(String n3ptyRcvOfcCd) {
		this.n3ptyRcvOfcCd = n3ptyRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param cntrRtSeq
	 */
	public void setCntrRtSeq(String cntrRtSeq) {
		this.cntrRtSeq = cntrRtSeq;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param frtInclXcldDivCd
	 */
	public void setFrtInclXcldDivCd(String frtInclXcldDivCd) {
		this.frtInclXcldDivCd = frtInclXcldDivCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDpSeq(JSPUtil.getParameter(request, "dp_seq", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setN3ptyCustSeq(JSPUtil.getParameter(request, "n3pty_cust_seq", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCgoCateCd(JSPUtil.getParameter(request, "cgo_cate_cd", ""));
		setBkgQty(JSPUtil.getParameter(request, "bkg_qty", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setN3ptyCustCntCd(JSPUtil.getParameter(request, "n3pty_cust_cnt_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setChgUtAmt(JSPUtil.getParameter(request, "chg_ut_amt", ""));
		setN3ptyRcvOfcCd(JSPUtil.getParameter(request, "n3pty_rcv_ofc_cd", ""));
		setFrtTermCd(JSPUtil.getParameter(request, "frt_term_cd", ""));
		setCntrRtSeq(JSPUtil.getParameter(request, "cntr_rt_seq", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setFrtInclXcldDivCd(JSPUtil.getParameter(request, "frt_incl_xcld_div_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setRatAsQty(JSPUtil.getParameter(request, "rat_as_qty", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrRtVO[]
	 */
	public CntrRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrRtVO[]
	 */
	public CntrRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] n3ptyCustSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_cust_seq", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cgoCateCd = (JSPUtil.getParameter(request, prefix	+ "cgo_cate_cd", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] n3ptyCustCntCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cust_cnt_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] n3ptyRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_rcv_ofc_cd", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] cntrRtSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_rt_seq", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] frtInclXcldDivCd = (JSPUtil.getParameter(request, prefix	+ "frt_incl_xcld_div_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrRtVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (n3ptyCustSeq[i] != null)
					model.setN3ptyCustSeq(n3ptyCustSeq[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cgoCateCd[i] != null)
					model.setCgoCateCd(cgoCateCd[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (n3ptyCustCntCd[i] != null)
					model.setN3ptyCustCntCd(n3ptyCustCntCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (n3ptyRcvOfcCd[i] != null)
					model.setN3ptyRcvOfcCd(n3ptyRcvOfcCd[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (cntrRtSeq[i] != null)
					model.setCntrRtSeq(cntrRtSeq[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (frtInclXcldDivCd[i] != null)
					model.setFrtInclXcldDivCd(frtInclXcldDivCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrRtVO[]
	 */
	public CntrRtVO[] getCntrRtVOs(){
		CntrRtVO[] vos = (CntrRtVO[])models.toArray(new CntrRtVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCustSeq = this.n3ptyCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCateCd = this.cgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCustCntCd = this.n3ptyCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyRcvOfcCd = this.n3ptyRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtSeq = this.cntrRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtInclXcldDivCd = this.frtInclXcldDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
