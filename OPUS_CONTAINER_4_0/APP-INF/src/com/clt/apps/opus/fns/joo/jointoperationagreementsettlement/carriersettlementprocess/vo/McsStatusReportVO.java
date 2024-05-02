/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : McsStatusReportVO.java
*@FileTitle : McsStatusReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.26
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.10.26 김영오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class McsStatusReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<McsStatusReportVO> models = new ArrayList<McsStatusReportVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String joCrrCd2 = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String usdamountChk = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String acctYrmon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eStlLoclAmt = null;
	/* Column Info */
	private String stlLoclAmt = null;
	/* Column Info */
	private String joStlItmCd2 = null;
	/* Column Info */
	private String rStlLoclAmt = null;
	/* Column Info */
	private String stlCmbSeq = null;
	/* Column Info */
	private String summarydetail = null;
	/* Column Info */
	private String rStlLoclAmtTeu = null;
	/* Column Info */
	private String rStlLoclAmtPrice = null;
	/* Column Info */
	private String rStlLoclAmtAmt = null;
	/* Column Info */
	private String eStlLoclAmtTeu = null;
	/* Column Info */
	private String eStlLoclAmtPrice = null;
	/* Column Info */
	private String eStlLoclAmtAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public McsStatusReportVO() {}

	public McsStatusReportVO(String ibflag, String pagerows, String vslCd, String csrNo, String revYrmon, String loclCurrCd, String skdVoyNo, String joCrrCd2, String rlaneCd, String usdamountChk, String skdDirCd, String joStlItmCd2, String revDirCd, String acctYrmon, String eStlLoclAmt, String stlLoclAmt, String rStlLoclAmt, String stlCmbSeq, String summarydetail, String rStlLoclAmtTeu, String rStlLoclAmtPrice, String rStlLoclAmtAmt, String eStlLoclAmtTeu, String eStlLoclAmtPrice, String eStlLoclAmtAmt) {
		this.vslCd = vslCd;
		this.csrNo = csrNo;
		this.revYrmon = revYrmon;
		this.loclCurrCd = loclCurrCd;
		this.skdVoyNo = skdVoyNo;
		this.joCrrCd2 = joCrrCd2;
		this.rlaneCd = rlaneCd;
		this.usdamountChk = usdamountChk;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.revDirCd = revDirCd;
		this.acctYrmon = acctYrmon;
		this.ibflag = ibflag;
		this.eStlLoclAmt = eStlLoclAmt;
		this.stlLoclAmt = stlLoclAmt;
		this.joStlItmCd2 = joStlItmCd2;
		this.rStlLoclAmt = rStlLoclAmt;
		this.stlCmbSeq = stlCmbSeq;
		this.summarydetail = summarydetail;
		this.rStlLoclAmtTeu = rStlLoclAmtTeu;
		this.rStlLoclAmtPrice = rStlLoclAmtPrice;
		this.rStlLoclAmtAmt = rStlLoclAmtAmt;
		this.eStlLoclAmtTeu = eStlLoclAmtTeu;
		this.eStlLoclAmtPrice = eStlLoclAmtPrice;
		this.eStlLoclAmtAmt = eStlLoclAmtAmt;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("jo_crr_cd2", getJoCrrCd2());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("usdamount_chk", getUsdamountChk());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("e_stl_locl_amt", getEStlLoclAmt());
		this.hashColumns.put("stl_locl_amt", getStlLoclAmt());
		this.hashColumns.put("jo_stl_itm_cd2", getJoStlItmCd2());
		this.hashColumns.put("r_stl_locl_amt", getRStlLoclAmt());
		this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
		this.hashColumns.put("summarydetail", getSummaryDetail());
		this.hashColumns.put("r_stl_locl_amt_teu", getrStlLoclAmtTeu());
		this.hashColumns.put("r_stl_locl_amt_price", getrStlLoclAmtPrice());
		this.hashColumns.put("r_stl_locl_amt_amt", getrStlLoclAmtAmt());
		this.hashColumns.put("e_stl_locl_amt_teu", geteStlLoclAmtTeu());
		this.hashColumns.put("e_stl_locl_amt_price", geteStlLoclAmtPrice());
		this.hashColumns.put("e_stl_locl_amt_amt", geteStlLoclAmtAmt());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("jo_crr_cd2", "joCrrCd2");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("usdamount_chk", "usdamountChk");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("e_stl_locl_amt", "eStlLoclAmt");
		this.hashFields.put("stl_locl_amt", "stlLoclAmt");
		this.hashFields.put("jo_stl_itm_cd2", "joStlItmCd2");
		this.hashFields.put("r_stl_locl_amt", "rStlLoclAmt");
		this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
		
		this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
		
		this.hashFields.put("summarydetail", "summarydetail");
		this.hashFields.put("r_stl_locl_amt_teu", "rStlLoclAmtTeu");
		this.hashFields.put("r_stl_locl_amt_price", "rStlLoclAmtPrice");
		this.hashFields.put("r_stl_locl_amt_amt", "rStlLoclAmtAmt");
		this.hashFields.put("e_stl_locl_amt_teu", "eStlLoclAmtTeu");
		this.hashFields.put("e_stl_locl_amt_price", "eStlLoclAmtPrice");
		this.hashFields.put("e_stl_locl_amt_amt", "eStlLoclAmtAmt");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd2
	 */
	public String getJoCrrCd2() {
		return this.joCrrCd2;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return usdamountChk
	 */
	public String getUsdamountChk() {
		return this.usdamountChk;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
	}
	
	/**
	 * Column Info
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
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
	 * @return eStlLoclAmt
	 */
	public String getEStlLoclAmt() {
		return this.eStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return stlLoclAmt
	 */
	public String getStlLoclAmt() {
		return this.stlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return joStlItmCd2
	 */
	public String getJoStlItmCd2() {
		return this.joStlItmCd2;
	}
	
	/**
	 * Column Info
	 * @return rStlLoclAmt
	 */
	public String getRStlLoclAmt() {
		return this.rStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return stlCmbSeq
	 */
	public String getStlCmbSeq() {
		return this.stlCmbSeq;
	}
	
	
	/**
	 * Column Info
	 * @return summarydetail
	 */
	public String getSummaryDetail() {
		return this.summarydetail;
	}

	
	/**
	 * Column Info
	 * @return rStlLoclAmtTeu
	 */
	public String getrStlLoclAmtTeu() {
		return this.rStlLoclAmtTeu;
	}

	/**
	 * Column Info
	 * @return rStlLoclAmtPrice
	 */
	public String getrStlLoclAmtPrice() {
		return this.rStlLoclAmtPrice;
	}

	/**
	 * Column Info
	 * @return rStlLoclAmtAmt
	 */
	public String getrStlLoclAmtAmt() {
		return this.rStlLoclAmtAmt;
	}

	/**
	 * Column Info
	 * @return eStlLoclAmtTeu
	 */
	public String geteStlLoclAmtTeu() {
		return this.eStlLoclAmtTeu;
	}

	/**
	 * Column Info
	 * @return eStlLoclAmtPrice
	 */
	public String geteStlLoclAmtPrice() {
		return this.eStlLoclAmtPrice;
	}

	/**
	 * Column Info
	 * @return eStlLoclAmtAmt
	 */
	public String geteStlLoclAmtAmt() {
		return this.eStlLoclAmtAmt;
	}

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd2
	 */
	public void setJoCrrCd2(String joCrrCd2) {
		this.joCrrCd2 = joCrrCd2;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param usdamountChk
	 */
	public void setUsdamountChk(String usdamountChk) {
		this.usdamountChk = usdamountChk;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
	}
	
	/**
	 * Column Info
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
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
	 * @param eStlLoclAmt
	 */
	public void setEStlLoclAmt(String eStlLoclAmt) {
		this.eStlLoclAmt = eStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param stlLoclAmt
	 */
	public void setStlLoclAmt(String stlLoclAmt) {
		this.stlLoclAmt = stlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param joStlItmCd2
	 */
	public void setJoStlItmCd2(String joStlItmCd2) {
		this.joStlItmCd2 = joStlItmCd2;
	}
	
	/**
	 * Column Info
	 * @param rStlLoclAmt
	 */
	public void setRStlLoclAmt(String rStlLoclAmt) {
		this.rStlLoclAmt = rStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param stlCmbSeq
	 */
	public void setStlCmbSeq(String stlCmbSeq) {
		this.stlCmbSeq = stlCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return summarydetail
	 */
	public void setSummaryDetail(String summarydetail) {
		this.summarydetail = summarydetail;
	}

	/**
	 * Column Info
	 * @return rStlLoclAmtTeu
	 */
	public void setrStlLoclAmtTeu(String rStlLoclAmtTeu) {
		this.rStlLoclAmtTeu = rStlLoclAmtTeu;
	}

	/**
	 * Column Info
	 * @return rStlLoclAmtPrice
	 */
	public void setrStlLoclAmtPrice(String rStlLoclAmtPrice) {
		this.rStlLoclAmtPrice = rStlLoclAmtPrice;
	}

	/**
	 * Column Info
	 * @return rStlLoclAmtAmt
	 */
	public void setrStlLoclAmtAmt(String rStlLoclAmtAmt) {
		this.rStlLoclAmtAmt = rStlLoclAmtAmt;
	}

	/**
	 * Column Info
	 * @return eStlLoclAmtTeu
	 */
	public void seteStlLoclAmtTeu(String eStlLoclAmtTeu) {
		this.eStlLoclAmtTeu = eStlLoclAmtTeu;
	}

	/**
	 * Column Info
	 * @return eStlLoclAmtPrice
	 */
	public void seteStlLoclAmtPrice(String eStlLoclAmtPrice) {
		this.eStlLoclAmtPrice = eStlLoclAmtPrice;
	}

	/**
	 * Column Info
	 * @return eStlLoclAmtAmt
	 */
	public void seteStlLoclAmtAmt(String eStlLoclAmtAmt) {
		this.eStlLoclAmtAmt = eStlLoclAmtAmt;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setJoCrrCd2(JSPUtil.getParameter(request, prefix + "jo_crr_cd2", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setUsdamountChk(JSPUtil.getParameter(request, prefix + "usdamount_chk", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEStlLoclAmt(JSPUtil.getParameter(request, prefix + "e_stl_locl_amt", ""));
		setStlLoclAmt(JSPUtil.getParameter(request, prefix + "stl_locl_amt", ""));
		setJoStlItmCd2(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd2", ""));
		setRStlLoclAmt(JSPUtil.getParameter(request, prefix + "r_stl_locl_amt", ""));
		setStlCmbSeq(JSPUtil.getParameter(request, prefix + "stl_cmb_seq", ""));
		setSummaryDetail(JSPUtil.getParameter(request, prefix + "summarydetail", ""));
		seteStlLoclAmtTeu(JSPUtil.getParameter(request, prefix + "r_stl_locl_amt_teu", ""));
		setrStlLoclAmtPrice(JSPUtil.getParameter(request, prefix + "r_stl_locl_amt_price", ""));
		setrStlLoclAmtAmt(JSPUtil.getParameter(request, prefix + "r_stl_locl_amt_amt", ""));
		seteStlLoclAmtTeu(JSPUtil.getParameter(request, prefix + "e_stl_locl_amt_teu", ""));
		seteStlLoclAmtPrice(JSPUtil.getParameter(request, prefix + "e_stl_locl_amt_price", ""));
		seteStlLoclAmtAmt(JSPUtil.getParameter(request, prefix + "e_stl_locl_amt_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return McsStatusReportVO[]
	 */
	public McsStatusReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return McsStatusReportVO[]
	 */
	public McsStatusReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		McsStatusReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] joCrrCd2 = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd2", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] usdamountChk = (JSPUtil.getParameter(request, prefix	+ "usdamount_chk", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "e_stl_locl_amt", length));
			String[] stlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "stl_locl_amt", length));
			String[] joStlItmCd2 = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd2", length));
			String[] rStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "r_stl_locl_amt", length));
			String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix	+ "stl_cmb_seq", length));
			String[] summarydetail = (JSPUtil.getParameter(request, prefix	+ "summarydetail", length));
			String[] rStlLoclAmtTeu = (JSPUtil.getParameter(request, prefix	+ "r_stl_locl_amt_teu", length));
			String[] rStlLoclAmtPrice = (JSPUtil.getParameter(request, prefix	+ "r_stl_locl_amt_price", length));
			String[] rStlLoclAmtAmt = (JSPUtil.getParameter(request, prefix	+ "r_stl_locl_amt_amt", length));
			String[] eStlLoclAmtTeu = (JSPUtil.getParameter(request, prefix	+ "e_stl_locl_amt_teu", length));
			String[] eStlLoclAmtPrice = (JSPUtil.getParameter(request, prefix	+ "e_stl_locl_amt_price", length));
			String[] eStlLoclAmtAmt = (JSPUtil.getParameter(request, prefix	+ "e_stl_locl_amt_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new McsStatusReportVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (joCrrCd2[i] != null)
					model.setJoCrrCd2(joCrrCd2[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (usdamountChk[i] != null)
					model.setUsdamountChk(usdamountChk[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eStlLoclAmt[i] != null)
					model.setEStlLoclAmt(eStlLoclAmt[i]);
				if (stlLoclAmt[i] != null)
					model.setStlLoclAmt(stlLoclAmt[i]);
				if (joStlItmCd2[i] != null)
					model.setJoStlItmCd2(joStlItmCd2[i]);
				if (rStlLoclAmt[i] != null)
					model.setRStlLoclAmt(rStlLoclAmt[i]);
				if (stlCmbSeq[i] != null)
					model.setStlCmbSeq(stlCmbSeq[i]);
				if (summarydetail[i] != null)
					model.setSummaryDetail(summarydetail[i]);
				if (rStlLoclAmtTeu[i] != null)
					model.setrStlLoclAmtTeu(rStlLoclAmtTeu[i]);
				if (rStlLoclAmtPrice[i] != null)
					model.setrStlLoclAmtPrice(rStlLoclAmtPrice[i]);
				if (rStlLoclAmtAmt[i] != null)
					model.setrStlLoclAmtAmt(rStlLoclAmtAmt[i]);
				if (eStlLoclAmtTeu[i] != null)
					model.seteStlLoclAmtTeu(eStlLoclAmtTeu[i]);
				if (eStlLoclAmtPrice[i] != null)
					model.seteStlLoclAmtPrice(eStlLoclAmtPrice[i]);
				if (eStlLoclAmtAmt[i] != null)
					model.seteStlLoclAmtAmt(eStlLoclAmtAmt[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMcsStatusReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return McsStatusReportVO[]
	 */
	public McsStatusReportVO[] getMcsStatusReportVOs(){
		McsStatusReportVO[] vos = (McsStatusReportVO[])models.toArray(new McsStatusReportVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd2 = this.joCrrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdamountChk = this.usdamountChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eStlLoclAmt = this.eStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlLoclAmt = this.stlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCd2 = this.joStlItmCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rStlLoclAmt = this.rStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCmbSeq = this.stlCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.summarydetail = this.summarydetail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rStlLoclAmtTeu = this.rStlLoclAmtTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rStlLoclAmtPrice = this.rStlLoclAmtPrice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rStlLoclAmtAmt = this.rStlLoclAmtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eStlLoclAmtTeu = this.eStlLoclAmtTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eStlLoclAmtPrice = this.eStlLoclAmtPrice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eStlLoclAmtAmt = this.eStlLoclAmtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		
	}
}
