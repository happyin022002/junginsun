/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ArDataInqVO.java
*@FileTitle : ArDataInqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.27
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.10.27 김영오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArDataInqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArDataInqVO> models = new ArrayList<ArDataInqVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cbOfcCd = null;
	/* Column Info */
	private String joBilNo = null;
	/* Column Info */
	private String tranNo = null;
	/* Column Info */
	private String stlUsdAmt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String joStlItmCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String stlLoclAmt = null;
	/* Column Info */
	private String yrmonType = null;
	/* Column Info */
	private String yrmonFr = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String joCrrCd2 = null;
	/* Column Info */
	private String sumYn = null;
	/* Column Info */
	private String yrmonTo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String csrLoclAmt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String joCrrCdNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArDataInqVO() {}

	public ArDataInqVO(String ibflag, String pagerows, String vslCd, String joBilNo, String cbOfcCd, String tranNo, String stlUsdAmt, String rlaneCd, String joStlItmCd, String revDirCd, String stlLoclAmt, String yrmonType, String yrmonFr, String revYrmon, String loclCurrCd, String skdVoyNo, String joCrrCd, String joCrrCd2, String sumYn, String yrmonTo, String skdDirCd, String csrLoclAmt, String vvd, String acctYrmon, String reDivrCd, String joCrrCdNm) {
		this.vslCd = vslCd;
		this.cbOfcCd = cbOfcCd;
		this.joBilNo = joBilNo;
		this.tranNo = tranNo;
		this.stlUsdAmt = stlUsdAmt;
		this.rlaneCd = rlaneCd;
		this.joStlItmCd = joStlItmCd;
		this.pagerows = pagerows;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.stlLoclAmt = stlLoclAmt;
		this.yrmonType = yrmonType;
		this.yrmonFr = yrmonFr;
		this.revYrmon = revYrmon;
		this.loclCurrCd = loclCurrCd;
		this.skdVoyNo = skdVoyNo;
		this.joCrrCd = joCrrCd;
		this.joCrrCd2 = joCrrCd2;
		this.sumYn = sumYn;
		this.yrmonTo = yrmonTo;
		this.skdDirCd = skdDirCd;
		this.csrLoclAmt = csrLoclAmt;
		this.vvd = vvd;
		this.acctYrmon = acctYrmon;
		this.reDivrCd = reDivrCd;
		this.joCrrCdNm = joCrrCdNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cb_ofc_cd", getCbOfcCd());
		this.hashColumns.put("jo_bil_no", getJoBilNo());
		this.hashColumns.put("tran_no", getTranNo());
		this.hashColumns.put("stl_usd_amt", getStlUsdAmt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("stl_locl_amt", getStlLoclAmt());
		this.hashColumns.put("yrmon_type", getYrmonType());
		this.hashColumns.put("yrmon_fr", getYrmonFr());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("jo_crr_cd2", getJoCrrCd2());
		this.hashColumns.put("sum_yn", getSumYn());
		this.hashColumns.put("yrmon_to", getYrmonTo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("csr_locl_amt", getCsrLoclAmt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("jo_crr_cd_nm", getJoCrrCdNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cb_ofc_cd", "cbOfcCd");
		this.hashFields.put("jo_bil_no", "joBilNo");
		this.hashFields.put("tran_no", "tranNo");
		this.hashFields.put("stl_usd_amt", "stlUsdAmt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("stl_locl_amt", "stlLoclAmt");
		this.hashFields.put("yrmon_type", "yrmonType");
		this.hashFields.put("yrmon_fr", "yrmonFr");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("jo_crr_cd2", "joCrrCd2");
		this.hashFields.put("sum_yn", "sumYn");
		this.hashFields.put("yrmon_to", "yrmonTo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("csr_locl_amt", "csrLoclAmt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("jo_crr_cd_nm", "joCrrCdNm");
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
	 * @return cbOfcCd
	 */
	public String getCbOfcCd() {
		return this.cbOfcCd;
	}
	
	/**
	 * Column Info
	 * @return joBilNo
	 */
	public String getJoBilNo() {
		return this.joBilNo;
	}
	
	/**
	 * Column Info
	 * @return tranNo
	 */
	public String getTranNo() {
		return this.tranNo;
	}
	
	/**
	 * Column Info
	 * @return stlUsdAmt
	 */
	public String getStlUsdAmt() {
		return this.stlUsdAmt;
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
	 * @return joStlItmCd
	 */
	public String getJoStlItmCd() {
		return this.joStlItmCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return yrmonType
	 */
	public String getYrmonType() {
		return this.yrmonType;
	}
	
	/**
	 * Column Info
	 * @return yrmonFr
	 */
	public String getYrmonFr() {
		return this.yrmonFr;
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
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
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
	 * @return sumYn
	 */
	public String getSumYn() {
		return this.sumYn;
	}
	
	/**
	 * Column Info
	 * @return yrmonTo
	 */
	public String getYrmonTo() {
		return this.yrmonTo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return csrLoclAmt
	 */
	public String getCsrLoclAmt() {
		return this.csrLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return joCrrCdNm
	 */
	public String getJoCrrCdNm() {
		return this.joCrrCdNm;
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
	 * @param cbOfcCd
	 */
	public void setCbOfcCd(String cbOfcCd) {
		this.cbOfcCd = cbOfcCd;
	}
	
	/**
	 * Column Info
	 * @param joBilNo
	 */
	public void setJoBilNo(String joBilNo) {
		this.joBilNo = joBilNo;
	}
	
	/**
	 * Column Info
	 * @param tranNo
	 */
	public void setTranNo(String tranNo) {
		this.tranNo = tranNo;
	}
	
	/**
	 * Column Info
	 * @param stlUsdAmt
	 */
	public void setStlUsdAmt(String stlUsdAmt) {
		this.stlUsdAmt = stlUsdAmt;
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
	 * @param joStlItmCd
	 */
	public void setJoStlItmCd(String joStlItmCd) {
		this.joStlItmCd = joStlItmCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param yrmonType
	 */
	public void setYrmonType(String yrmonType) {
		this.yrmonType = yrmonType;
	}
	
	/**
	 * Column Info
	 * @param yrmonFr
	 */
	public void setYrmonFr(String yrmonFr) {
		this.yrmonFr = yrmonFr;
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
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
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
	 * @param sumYn
	 */
	public void setSumYn(String sumYn) {
		this.sumYn = sumYn;
	}
	
	/**
	 * Column Info
	 * @param yrmonTo
	 */
	public void setYrmonTo(String yrmonTo) {
		this.yrmonTo = yrmonTo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param csrLoclAmt
	 */
	public void setCsrLoclAmt(String csrLoclAmt) {
		this.csrLoclAmt = csrLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param joCrrCdNm
	 */
	public void setJoCrrCdNm(String joCrrCdNm) {
		this.joCrrCdNm = joCrrCdNm;
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
		setCbOfcCd(JSPUtil.getParameter(request, prefix + "cb_ofc_cd", ""));
		setJoBilNo(JSPUtil.getParameter(request, prefix + "jo_bil_no", ""));
		setTranNo(JSPUtil.getParameter(request, prefix + "tran_no", ""));
		setStlUsdAmt(JSPUtil.getParameter(request, prefix + "stl_usd_amt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setJoStlItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setStlLoclAmt(JSPUtil.getParameter(request, prefix + "stl_locl_amt", ""));
		setYrmonType(JSPUtil.getParameter(request, prefix + "yrmon_type", ""));
		setYrmonFr(JSPUtil.getParameter(request, prefix + "yrmon_fr", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setJoCrrCd2(JSPUtil.getParameter(request, prefix + "jo_crr_cd2", ""));
		setSumYn(JSPUtil.getParameter(request, prefix + "sum_yn", ""));
		setYrmonTo(JSPUtil.getParameter(request, prefix + "yrmon_to", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCsrLoclAmt(JSPUtil.getParameter(request, prefix + "csr_locl_amt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setJoCrrCdNm(JSPUtil.getParameter(request, prefix + "jo_crr_cd_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArDataInqVO[]
	 */
	public ArDataInqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArDataInqVO[]
	 */
	public ArDataInqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArDataInqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cbOfcCd = (JSPUtil.getParameter(request, prefix	+ "cb_ofc_cd", length));
			String[] joBilNo = (JSPUtil.getParameter(request, prefix	+ "jo_bil_no", length));
			String[] tranNo = (JSPUtil.getParameter(request, prefix	+ "tran_no", length));
			String[] stlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "stl_usd_amt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] joStlItmCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] stlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "stl_locl_amt", length));
			String[] yrmonType = (JSPUtil.getParameter(request, prefix	+ "yrmon_type", length));
			String[] yrmonFr = (JSPUtil.getParameter(request, prefix	+ "yrmon_fr", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] joCrrCd2 = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd2", length));
			String[] sumYn = (JSPUtil.getParameter(request, prefix	+ "sum_yn", length));
			String[] yrmonTo = (JSPUtil.getParameter(request, prefix	+ "yrmon_to", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] csrLoclAmt = (JSPUtil.getParameter(request, prefix	+ "csr_locl_amt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] joCrrCdNm = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArDataInqVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cbOfcCd[i] != null)
					model.setCbOfcCd(cbOfcCd[i]);
				if (joBilNo[i] != null)
					model.setJoBilNo(joBilNo[i]);
				if (tranNo[i] != null)
					model.setTranNo(tranNo[i]);
				if (stlUsdAmt[i] != null)
					model.setStlUsdAmt(stlUsdAmt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (joStlItmCd[i] != null)
					model.setJoStlItmCd(joStlItmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (stlLoclAmt[i] != null)
					model.setStlLoclAmt(stlLoclAmt[i]);
				if (yrmonType[i] != null)
					model.setYrmonType(yrmonType[i]);
				if (yrmonFr[i] != null)
					model.setYrmonFr(yrmonFr[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (joCrrCd2[i] != null)
					model.setJoCrrCd2(joCrrCd2[i]);
				if (sumYn[i] != null)
					model.setSumYn(sumYn[i]);
				if (yrmonTo[i] != null)
					model.setYrmonTo(yrmonTo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (csrLoclAmt[i] != null)
					model.setCsrLoclAmt(csrLoclAmt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (joCrrCdNm[i] != null)
					model.setJoCrrCdNm(joCrrCdNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArDataInqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArDataInqVO[]
	 */
	public ArDataInqVO[] getArDataInqVOs(){
		ArDataInqVO[] vos = (ArDataInqVO[])models.toArray(new ArDataInqVO[models.size()]);
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
		this.cbOfcCd = this.cbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBilNo = this.joBilNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tranNo = this.tranNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlUsdAmt = this.stlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCd = this.joStlItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlLoclAmt = this.stlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmonType = this.yrmonType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmonFr = this.yrmonFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd2 = this.joCrrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumYn = this.sumYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmonTo = this.yrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrLoclAmt = this.csrLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCdNm = this.joCrrCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
