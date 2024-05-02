/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OutBdMvntStsNtcListSumVO.java
*@FileTitle : OutBdMvntStsNtcListSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.15
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.02.15 조정민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 조정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OutBdMvntStsNtcListSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OutBdMvntStsNtcListSumVO> models = new ArrayList<OutBdMvntStsNtcListSumVO>();
	
	/* Column Info */
	private String tmlGiSts = null;
	/* Column Info */
	private String sumMvmtOp = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String sumSnsUnsnt = null;
	/* Column Info */
	private String sumSnsSnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sumMvmtOc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String sumMvmtOthr = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String sumMvmtMty = null;
	/* Column Info */
	private String sumTrnsSt = null;
	/* Column Info */
	private String sumMvmtVl = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String sumTrnsHjt = null;
	/* Column Info */
	private String sumEmlUnsnt = null;
	/* Column Info */
	private String ntcExp = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String sumTrnsShut = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String sumEmlSnt = null;
	/* Column Info */
	private String trnsMode = null;
	/* Column Info */
	private String sumCntr = null;
	/* Column Info */
	private String sumMvmtEntn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OutBdMvntStsNtcListSumVO() {}

	public OutBdMvntStsNtcListSumVO(String ibflag, String pagerows, String sumCntr, String cntrTpszCd, String sumMvmtOp, String sumMvmtOc, String sumMvmtEntn, String sumMvmtVl, String sumMvmtMty, String sumMvmtOthr, String sumTrnsSt, String sumTrnsHjt, String sumTrnsShut, String sumEmlSnt, String sumEmlUnsnt, String sumSnsSnt, String sumSnsUnsnt, String vvd, String polCd, String polYdCd, String bkgCgoTpCd, String rcvTermCd, String deTermCd, String trnsMode, String ntcExp, String tmlGiSts) {
		this.tmlGiSts = tmlGiSts;
		this.sumMvmtOp = sumMvmtOp;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.sumSnsUnsnt = sumSnsUnsnt;
		this.sumSnsSnt = sumSnsSnt;
		this.pagerows = pagerows;
		this.sumMvmtOc = sumMvmtOc;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.sumMvmtOthr = sumMvmtOthr;
		this.cntrTpszCd = cntrTpszCd;
		this.sumMvmtMty = sumMvmtMty;
		this.sumTrnsSt = sumTrnsSt;
		this.sumMvmtVl = sumMvmtVl;
		this.rcvTermCd = rcvTermCd;
		this.sumTrnsHjt = sumTrnsHjt;
		this.sumEmlUnsnt = sumEmlUnsnt;
		this.ntcExp = ntcExp;
		this.vvd = vvd;
		this.deTermCd = deTermCd;
		this.sumTrnsShut = sumTrnsShut;
		this.polYdCd = polYdCd;
		this.sumEmlSnt = sumEmlSnt;
		this.trnsMode = trnsMode;
		this.sumCntr = sumCntr;
		this.sumMvmtEntn = sumMvmtEntn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tml_gi_sts", getTmlGiSts());
		this.hashColumns.put("sum_mvmt_op", getSumMvmtOp());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("sum_sns_unsnt", getSumSnsUnsnt());
		this.hashColumns.put("sum_sns_snt", getSumSnsSnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sum_mvmt_oc", getSumMvmtOc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sum_mvmt_othr", getSumMvmtOthr());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("sum_mvmt_mty", getSumMvmtMty());
		this.hashColumns.put("sum_trns_st", getSumTrnsSt());
		this.hashColumns.put("sum_mvmt_vl", getSumMvmtVl());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("sum_trns_hjt", getSumTrnsHjt());
		this.hashColumns.put("sum_eml_unsnt", getSumEmlUnsnt());
		this.hashColumns.put("ntc_exp", getNtcExp());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("sum_trns_shut", getSumTrnsShut());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("sum_eml_snt", getSumEmlSnt());
		this.hashColumns.put("trns_mode", getTrnsMode());
		this.hashColumns.put("sum_cntr", getSumCntr());
		this.hashColumns.put("sum_mvmt_entn", getSumMvmtEntn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tml_gi_sts", "tmlGiSts");
		this.hashFields.put("sum_mvmt_op", "sumMvmtOp");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("sum_sns_unsnt", "sumSnsUnsnt");
		this.hashFields.put("sum_sns_snt", "sumSnsSnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sum_mvmt_oc", "sumMvmtOc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sum_mvmt_othr", "sumMvmtOthr");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("sum_mvmt_mty", "sumMvmtMty");
		this.hashFields.put("sum_trns_st", "sumTrnsSt");
		this.hashFields.put("sum_mvmt_vl", "sumMvmtVl");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("sum_trns_hjt", "sumTrnsHjt");
		this.hashFields.put("sum_eml_unsnt", "sumEmlUnsnt");
		this.hashFields.put("ntc_exp", "ntcExp");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("sum_trns_shut", "sumTrnsShut");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("sum_eml_snt", "sumEmlSnt");
		this.hashFields.put("trns_mode", "trnsMode");
		this.hashFields.put("sum_cntr", "sumCntr");
		this.hashFields.put("sum_mvmt_entn", "sumMvmtEntn");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tmlGiSts
	 */
	public String getTmlGiSts() {
		return this.tmlGiSts;
	}
	
	/**
	 * Column Info
	 * @return sumMvmtOp
	 */
	public String getSumMvmtOp() {
		return this.sumMvmtOp;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return sumSnsUnsnt
	 */
	public String getSumSnsUnsnt() {
		return this.sumSnsUnsnt;
	}
	
	/**
	 * Column Info
	 * @return sumSnsSnt
	 */
	public String getSumSnsSnt() {
		return this.sumSnsSnt;
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
	 * @return sumMvmtOc
	 */
	public String getSumMvmtOc() {
		return this.sumMvmtOc;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return sumMvmtOthr
	 */
	public String getSumMvmtOthr() {
		return this.sumMvmtOthr;
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
	 * @return sumMvmtMty
	 */
	public String getSumMvmtMty() {
		return this.sumMvmtMty;
	}
	
	/**
	 * Column Info
	 * @return sumTrnsSt
	 */
	public String getSumTrnsSt() {
		return this.sumTrnsSt;
	}
	
	/**
	 * Column Info
	 * @return sumMvmtVl
	 */
	public String getSumMvmtVl() {
		return this.sumMvmtVl;
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
	 * @return sumTrnsHjt
	 */
	public String getSumTrnsHjt() {
		return this.sumTrnsHjt;
	}
	
	/**
	 * Column Info
	 * @return sumEmlUnsnt
	 */
	public String getSumEmlUnsnt() {
		return this.sumEmlUnsnt;
	}
	
	/**
	 * Column Info
	 * @return ntcExp
	 */
	public String getNtcExp() {
		return this.ntcExp;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return sumTrnsShut
	 */
	public String getSumTrnsShut() {
		return this.sumTrnsShut;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return sumEmlSnt
	 */
	public String getSumEmlSnt() {
		return this.sumEmlSnt;
	}
	
	/**
	 * Column Info
	 * @return trnsMode
	 */
	public String getTrnsMode() {
		return this.trnsMode;
	}
	
	/**
	 * Column Info
	 * @return sumCntr
	 */
	public String getSumCntr() {
		return this.sumCntr;
	}
	
	/**
	 * Column Info
	 * @return sumMvmtEntn
	 */
	public String getSumMvmtEntn() {
		return this.sumMvmtEntn;
	}
	

	/**
	 * Column Info
	 * @param tmlGiSts
	 */
	public void setTmlGiSts(String tmlGiSts) {
		this.tmlGiSts = tmlGiSts;
	}
	
	/**
	 * Column Info
	 * @param sumMvmtOp
	 */
	public void setSumMvmtOp(String sumMvmtOp) {
		this.sumMvmtOp = sumMvmtOp;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param sumSnsUnsnt
	 */
	public void setSumSnsUnsnt(String sumSnsUnsnt) {
		this.sumSnsUnsnt = sumSnsUnsnt;
	}
	
	/**
	 * Column Info
	 * @param sumSnsSnt
	 */
	public void setSumSnsSnt(String sumSnsSnt) {
		this.sumSnsSnt = sumSnsSnt;
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
	 * @param sumMvmtOc
	 */
	public void setSumMvmtOc(String sumMvmtOc) {
		this.sumMvmtOc = sumMvmtOc;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param sumMvmtOthr
	 */
	public void setSumMvmtOthr(String sumMvmtOthr) {
		this.sumMvmtOthr = sumMvmtOthr;
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
	 * @param sumMvmtMty
	 */
	public void setSumMvmtMty(String sumMvmtMty) {
		this.sumMvmtMty = sumMvmtMty;
	}
	
	/**
	 * Column Info
	 * @param sumTrnsSt
	 */
	public void setSumTrnsSt(String sumTrnsSt) {
		this.sumTrnsSt = sumTrnsSt;
	}
	
	/**
	 * Column Info
	 * @param sumMvmtVl
	 */
	public void setSumMvmtVl(String sumMvmtVl) {
		this.sumMvmtVl = sumMvmtVl;
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
	 * @param sumTrnsHjt
	 */
	public void setSumTrnsHjt(String sumTrnsHjt) {
		this.sumTrnsHjt = sumTrnsHjt;
	}
	
	/**
	 * Column Info
	 * @param sumEmlUnsnt
	 */
	public void setSumEmlUnsnt(String sumEmlUnsnt) {
		this.sumEmlUnsnt = sumEmlUnsnt;
	}
	
	/**
	 * Column Info
	 * @param ntcExp
	 */
	public void setNtcExp(String ntcExp) {
		this.ntcExp = ntcExp;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param sumTrnsShut
	 */
	public void setSumTrnsShut(String sumTrnsShut) {
		this.sumTrnsShut = sumTrnsShut;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param sumEmlSnt
	 */
	public void setSumEmlSnt(String sumEmlSnt) {
		this.sumEmlSnt = sumEmlSnt;
	}
	
	/**
	 * Column Info
	 * @param trnsMode
	 */
	public void setTrnsMode(String trnsMode) {
		this.trnsMode = trnsMode;
	}
	
	/**
	 * Column Info
	 * @param sumCntr
	 */
	public void setSumCntr(String sumCntr) {
		this.sumCntr = sumCntr;
	}
	
	/**
	 * Column Info
	 * @param sumMvmtEntn
	 */
	public void setSumMvmtEntn(String sumMvmtEntn) {
		this.sumMvmtEntn = sumMvmtEntn;
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
		setTmlGiSts(JSPUtil.getParameter(request, prefix + "tml_gi_sts", ""));
		setSumMvmtOp(JSPUtil.getParameter(request, prefix + "sum_mvmt_op", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setSumSnsUnsnt(JSPUtil.getParameter(request, prefix + "sum_sns_unsnt", ""));
		setSumSnsSnt(JSPUtil.getParameter(request, prefix + "sum_sns_snt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSumMvmtOc(JSPUtil.getParameter(request, prefix + "sum_mvmt_oc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setSumMvmtOthr(JSPUtil.getParameter(request, prefix + "sum_mvmt_othr", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setSumMvmtMty(JSPUtil.getParameter(request, prefix + "sum_mvmt_mty", ""));
		setSumTrnsSt(JSPUtil.getParameter(request, prefix + "sum_trns_st", ""));
		setSumMvmtVl(JSPUtil.getParameter(request, prefix + "sum_mvmt_vl", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setSumTrnsHjt(JSPUtil.getParameter(request, prefix + "sum_trns_hjt", ""));
		setSumEmlUnsnt(JSPUtil.getParameter(request, prefix + "sum_eml_unsnt", ""));
		setNtcExp(JSPUtil.getParameter(request, prefix + "ntc_exp", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setSumTrnsShut(JSPUtil.getParameter(request, prefix + "sum_trns_shut", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setSumEmlSnt(JSPUtil.getParameter(request, prefix + "sum_eml_snt", ""));
		setTrnsMode(JSPUtil.getParameter(request, prefix + "trns_mode", ""));
		setSumCntr(JSPUtil.getParameter(request, prefix + "sum_cntr", ""));
		setSumMvmtEntn(JSPUtil.getParameter(request, prefix + "sum_mvmt_entn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OutBdMvntStsNtcListSumVO[]
	 */
	public OutBdMvntStsNtcListSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OutBdMvntStsNtcListSumVO[]
	 */
	public OutBdMvntStsNtcListSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OutBdMvntStsNtcListSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tmlGiSts = (JSPUtil.getParameter(request, prefix	+ "tml_gi_sts", length));
			String[] sumMvmtOp = (JSPUtil.getParameter(request, prefix	+ "sum_mvmt_op", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] sumSnsUnsnt = (JSPUtil.getParameter(request, prefix	+ "sum_sns_unsnt", length));
			String[] sumSnsSnt = (JSPUtil.getParameter(request, prefix	+ "sum_sns_snt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sumMvmtOc = (JSPUtil.getParameter(request, prefix	+ "sum_mvmt_oc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] sumMvmtOthr = (JSPUtil.getParameter(request, prefix	+ "sum_mvmt_othr", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] sumMvmtMty = (JSPUtil.getParameter(request, prefix	+ "sum_mvmt_mty", length));
			String[] sumTrnsSt = (JSPUtil.getParameter(request, prefix	+ "sum_trns_st", length));
			String[] sumMvmtVl = (JSPUtil.getParameter(request, prefix	+ "sum_mvmt_vl", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] sumTrnsHjt = (JSPUtil.getParameter(request, prefix	+ "sum_trns_hjt", length));
			String[] sumEmlUnsnt = (JSPUtil.getParameter(request, prefix	+ "sum_eml_unsnt", length));
			String[] ntcExp = (JSPUtil.getParameter(request, prefix	+ "ntc_exp", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] sumTrnsShut = (JSPUtil.getParameter(request, prefix	+ "sum_trns_shut", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] sumEmlSnt = (JSPUtil.getParameter(request, prefix	+ "sum_eml_snt", length));
			String[] trnsMode = (JSPUtil.getParameter(request, prefix	+ "trns_mode", length));
			String[] sumCntr = (JSPUtil.getParameter(request, prefix	+ "sum_cntr", length));
			String[] sumMvmtEntn = (JSPUtil.getParameter(request, prefix	+ "sum_mvmt_entn", length));
			
			for (int i = 0; i < length; i++) {
				model = new OutBdMvntStsNtcListSumVO();
				if (tmlGiSts[i] != null)
					model.setTmlGiSts(tmlGiSts[i]);
				if (sumMvmtOp[i] != null)
					model.setSumMvmtOp(sumMvmtOp[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (sumSnsUnsnt[i] != null)
					model.setSumSnsUnsnt(sumSnsUnsnt[i]);
				if (sumSnsSnt[i] != null)
					model.setSumSnsSnt(sumSnsSnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sumMvmtOc[i] != null)
					model.setSumMvmtOc(sumMvmtOc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (sumMvmtOthr[i] != null)
					model.setSumMvmtOthr(sumMvmtOthr[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (sumMvmtMty[i] != null)
					model.setSumMvmtMty(sumMvmtMty[i]);
				if (sumTrnsSt[i] != null)
					model.setSumTrnsSt(sumTrnsSt[i]);
				if (sumMvmtVl[i] != null)
					model.setSumMvmtVl(sumMvmtVl[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (sumTrnsHjt[i] != null)
					model.setSumTrnsHjt(sumTrnsHjt[i]);
				if (sumEmlUnsnt[i] != null)
					model.setSumEmlUnsnt(sumEmlUnsnt[i]);
				if (ntcExp[i] != null)
					model.setNtcExp(ntcExp[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (sumTrnsShut[i] != null)
					model.setSumTrnsShut(sumTrnsShut[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (sumEmlSnt[i] != null)
					model.setSumEmlSnt(sumEmlSnt[i]);
				if (trnsMode[i] != null)
					model.setTrnsMode(trnsMode[i]);
				if (sumCntr[i] != null)
					model.setSumCntr(sumCntr[i]);
				if (sumMvmtEntn[i] != null)
					model.setSumMvmtEntn(sumMvmtEntn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOutBdMvntStsNtcListSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OutBdMvntStsNtcListSumVO[]
	 */
	public OutBdMvntStsNtcListSumVO[] getOutBdMvntStsNtcListSumVOs(){
		OutBdMvntStsNtcListSumVO[] vos = (OutBdMvntStsNtcListSumVO[])models.toArray(new OutBdMvntStsNtcListSumVO[models.size()]);
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
		this.tmlGiSts = this.tmlGiSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumMvmtOp = this.sumMvmtOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumSnsUnsnt = this.sumSnsUnsnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumSnsSnt = this.sumSnsSnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumMvmtOc = this.sumMvmtOc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumMvmtOthr = this.sumMvmtOthr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumMvmtMty = this.sumMvmtMty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTrnsSt = this.sumTrnsSt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumMvmtVl = this.sumMvmtVl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTrnsHjt = this.sumTrnsHjt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumEmlUnsnt = this.sumEmlUnsnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcExp = this.ntcExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTrnsShut = this.sumTrnsShut .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumEmlSnt = this.sumEmlSnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsMode = this.trnsMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCntr = this.sumCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumMvmtEntn = this.sumMvmtEntn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
