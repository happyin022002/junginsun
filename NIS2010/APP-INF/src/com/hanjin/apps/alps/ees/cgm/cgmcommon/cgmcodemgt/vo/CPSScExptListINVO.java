/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CPSScExptListINVO.java
*@FileTitle : CPSScExptListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.30
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.04.30 이영헌 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo;

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
 * @author 이영헌
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CPSScExptListINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CPSScExptListINVO> models = new ArrayList<CPSScExptListINVO>();
	
	/* Column Info */
	private String chkEffYrmon = null;
	/* Column Info */
	private String delflg = null;
	/* Column Info */
	private String chkScNo = null;
	/* Column Info */
	private String insflg = null;
	/* Column Info */
	private String err3 = null;
	/* Column Info */
	private String err4 = null;
	/* Column Info */
	private String err1 = null;
	/* Column Info */
	private String err2 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String scCustTpCd = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String updflg = null;
	/* Column Info */
	private String usaScExptRmk = null;
	/* Column Info */
	private String chkCustCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String chkLocCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String dup = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String effYrmon = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CPSScExptListINVO() {}

	public CPSScExptListINVO(String ibflag, String pagerows, String creOfcCd, String rhqCd, String ctrtOfcCd, String custGrpId, String custGrpNm, String custCntCd, String custSeq, String custCd, String custLglEngNm, String scCustTpCd, String effYrmon, String scNo, String locCd, String sccCd, String usaScExptRmk, String dup, String chkCustCd, String chkScNo, String chkEffYrmon, String chkLocCd, String creUsrId, String updUsrId, String err1, String err2, String err3, String err4, String insflg, String updflg, String delflg) {
		this.chkEffYrmon = chkEffYrmon;
		this.delflg = delflg;
		this.chkScNo = chkScNo;
		this.insflg = insflg;
		this.err3 = err3;
		this.err4 = err4;
		this.err1 = err1;
		this.err2 = err2;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.scCustTpCd = scCustTpCd;
		this.custGrpNm = custGrpNm;
		this.ctrtOfcCd = ctrtOfcCd;
		this.creOfcCd = creOfcCd;
		this.scNo = scNo;
		this.updflg = updflg;
		this.usaScExptRmk = usaScExptRmk;
		this.chkCustCd = chkCustCd;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.custGrpId = custGrpId;
		this.rhqCd = rhqCd;
		this.custSeq = custSeq;
		this.chkLocCd = chkLocCd;
		this.custLglEngNm = custLglEngNm;
		this.dup = dup;
		this.creUsrId = creUsrId;
		this.sccCd = sccCd;
		this.custCd = custCd;
		this.effYrmon = effYrmon;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chk_eff_yrmon", getChkEffYrmon());
		this.hashColumns.put("delflg", getDelflg());
		this.hashColumns.put("chk_sc_no", getChkScNo());
		this.hashColumns.put("insflg", getInsflg());
		this.hashColumns.put("err3", getErr3());
		this.hashColumns.put("err4", getErr4());
		this.hashColumns.put("err1", getErr1());
		this.hashColumns.put("err2", getErr2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("sc_cust_tp_cd", getScCustTpCd());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("updflg", getUpdflg());
		this.hashColumns.put("usa_sc_expt_rmk", getUsaScExptRmk());
		this.hashColumns.put("chk_cust_cd", getChkCustCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("chk_loc_cd", getChkLocCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("dup", getDup());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("eff_yrmon", getEffYrmon());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chk_eff_yrmon", "chkEffYrmon");
		this.hashFields.put("delflg", "delflg");
		this.hashFields.put("chk_sc_no", "chkScNo");
		this.hashFields.put("insflg", "insflg");
		this.hashFields.put("err3", "err3");
		this.hashFields.put("err4", "err4");
		this.hashFields.put("err1", "err1");
		this.hashFields.put("err2", "err2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("sc_cust_tp_cd", "scCustTpCd");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("updflg", "updflg");
		this.hashFields.put("usa_sc_expt_rmk", "usaScExptRmk");
		this.hashFields.put("chk_cust_cd", "chkCustCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("chk_loc_cd", "chkLocCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("dup", "dup");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("eff_yrmon", "effYrmon");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chkEffYrmon
	 */
	public String getChkEffYrmon() {
		return this.chkEffYrmon;
	}
	
	/**
	 * Column Info
	 * @return delflg
	 */
	public String getDelflg() {
		return this.delflg;
	}
	
	/**
	 * Column Info
	 * @return chkScNo
	 */
	public String getChkScNo() {
		return this.chkScNo;
	}
	
	/**
	 * Column Info
	 * @return insflg
	 */
	public String getInsflg() {
		return this.insflg;
	}
	
	/**
	 * Column Info
	 * @return err3
	 */
	public String getErr3() {
		return this.err3;
	}
	
	/**
	 * Column Info
	 * @return err4
	 */
	public String getErr4() {
		return this.err4;
	}
	
	/**
	 * Column Info
	 * @return err1
	 */
	public String getErr1() {
		return this.err1;
	}
	
	/**
	 * Column Info
	 * @return err2
	 */
	public String getErr2() {
		return this.err2;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return scCustTpCd
	 */
	public String getScCustTpCd() {
		return this.scCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return custGrpNm
	 */
	public String getCustGrpNm() {
		return this.custGrpNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return updflg
	 */
	public String getUpdflg() {
		return this.updflg;
	}
	
	/**
	 * Column Info
	 * @return usaScExptRmk
	 */
	public String getUsaScExptRmk() {
		return this.usaScExptRmk;
	}
	
	/**
	 * Column Info
	 * @return chkCustCd
	 */
	public String getChkCustCd() {
		return this.chkCustCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return chkLocCd
	 */
	public String getChkLocCd() {
		return this.chkLocCd;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return dup
	 */
	public String getDup() {
		return this.dup;
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
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return effYrmon
	 */
	public String getEffYrmon() {
		return this.effYrmon;
	}
	

	/**
	 * Column Info
	 * @param chkEffYrmon
	 */
	public void setChkEffYrmon(String chkEffYrmon) {
		this.chkEffYrmon = chkEffYrmon;
	}
	
	/**
	 * Column Info
	 * @param delflg
	 */
	public void setDelflg(String delflg) {
		this.delflg = delflg;
	}
	
	/**
	 * Column Info
	 * @param chkScNo
	 */
	public void setChkScNo(String chkScNo) {
		this.chkScNo = chkScNo;
	}
	
	/**
	 * Column Info
	 * @param insflg
	 */
	public void setInsflg(String insflg) {
		this.insflg = insflg;
	}
	
	/**
	 * Column Info
	 * @param err3
	 */
	public void setErr3(String err3) {
		this.err3 = err3;
	}
	
	/**
	 * Column Info
	 * @param err4
	 */
	public void setErr4(String err4) {
		this.err4 = err4;
	}
	
	/**
	 * Column Info
	 * @param err1
	 */
	public void setErr1(String err1) {
		this.err1 = err1;
	}
	
	/**
	 * Column Info
	 * @param err2
	 */
	public void setErr2(String err2) {
		this.err2 = err2;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param scCustTpCd
	 */
	public void setScCustTpCd(String scCustTpCd) {
		this.scCustTpCd = scCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param custGrpNm
	 */
	public void setCustGrpNm(String custGrpNm) {
		this.custGrpNm = custGrpNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param updflg
	 */
	public void setUpdflg(String updflg) {
		this.updflg = updflg;
	}
	
	/**
	 * Column Info
	 * @param usaScExptRmk
	 */
	public void setUsaScExptRmk(String usaScExptRmk) {
		this.usaScExptRmk = usaScExptRmk;
	}
	
	/**
	 * Column Info
	 * @param chkCustCd
	 */
	public void setChkCustCd(String chkCustCd) {
		this.chkCustCd = chkCustCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param chkLocCd
	 */
	public void setChkLocCd(String chkLocCd) {
		this.chkLocCd = chkLocCd;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param dup
	 */
	public void setDup(String dup) {
		this.dup = dup;
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
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param effYrmon
	 */
	public void setEffYrmon(String effYrmon) {
		this.effYrmon = effYrmon;
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
		setChkEffYrmon(JSPUtil.getParameter(request, prefix + "chk_eff_yrmon", ""));
		setDelflg(JSPUtil.getParameter(request, prefix + "delflg", ""));
		setChkScNo(JSPUtil.getParameter(request, prefix + "chk_sc_no", ""));
		setInsflg(JSPUtil.getParameter(request, prefix + "insflg", ""));
		setErr3(JSPUtil.getParameter(request, prefix + "err3", ""));
		setErr4(JSPUtil.getParameter(request, prefix + "err4", ""));
		setErr1(JSPUtil.getParameter(request, prefix + "err1", ""));
		setErr2(JSPUtil.getParameter(request, prefix + "err2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setScCustTpCd(JSPUtil.getParameter(request, prefix + "sc_cust_tp_cd", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setUpdflg(JSPUtil.getParameter(request, prefix + "updflg", ""));
		setUsaScExptRmk(JSPUtil.getParameter(request, prefix + "usa_sc_expt_rmk", ""));
		setChkCustCd(JSPUtil.getParameter(request, prefix + "chk_cust_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setChkLocCd(JSPUtil.getParameter(request, prefix + "chk_loc_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setDup(JSPUtil.getParameter(request, prefix + "dup", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setEffYrmon(JSPUtil.getParameter(request, prefix + "eff_yrmon", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CPSScExptListINVO[]
	 */
	public CPSScExptListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CPSScExptListINVO[]
	 */
	public CPSScExptListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CPSScExptListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chkEffYrmon = (JSPUtil.getParameter(request, prefix	+ "chk_eff_yrmon", length));
			String[] delflg = (JSPUtil.getParameter(request, prefix	+ "delflg", length));
			String[] chkScNo = (JSPUtil.getParameter(request, prefix	+ "chk_sc_no", length));
			String[] insflg = (JSPUtil.getParameter(request, prefix	+ "insflg", length));
			String[] err3 = (JSPUtil.getParameter(request, prefix	+ "err3", length));
			String[] err4 = (JSPUtil.getParameter(request, prefix	+ "err4", length));
			String[] err1 = (JSPUtil.getParameter(request, prefix	+ "err1", length));
			String[] err2 = (JSPUtil.getParameter(request, prefix	+ "err2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] scCustTpCd = (JSPUtil.getParameter(request, prefix	+ "sc_cust_tp_cd", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] updflg = (JSPUtil.getParameter(request, prefix	+ "updflg", length));
			String[] usaScExptRmk = (JSPUtil.getParameter(request, prefix	+ "usa_sc_expt_rmk", length));
			String[] chkCustCd = (JSPUtil.getParameter(request, prefix	+ "chk_cust_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] chkLocCd = (JSPUtil.getParameter(request, prefix	+ "chk_loc_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] dup = (JSPUtil.getParameter(request, prefix	+ "dup", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] effYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_yrmon", length));
			
			for (int i = 0; i < length; i++) {
				model = new CPSScExptListINVO();
				if (chkEffYrmon[i] != null)
					model.setChkEffYrmon(chkEffYrmon[i]);
				if (delflg[i] != null)
					model.setDelflg(delflg[i]);
				if (chkScNo[i] != null)
					model.setChkScNo(chkScNo[i]);
				if (insflg[i] != null)
					model.setInsflg(insflg[i]);
				if (err3[i] != null)
					model.setErr3(err3[i]);
				if (err4[i] != null)
					model.setErr4(err4[i]);
				if (err1[i] != null)
					model.setErr1(err1[i]);
				if (err2[i] != null)
					model.setErr2(err2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (scCustTpCd[i] != null)
					model.setScCustTpCd(scCustTpCd[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (updflg[i] != null)
					model.setUpdflg(updflg[i]);
				if (usaScExptRmk[i] != null)
					model.setUsaScExptRmk(usaScExptRmk[i]);
				if (chkCustCd[i] != null)
					model.setChkCustCd(chkCustCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (chkLocCd[i] != null)
					model.setChkLocCd(chkLocCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (dup[i] != null)
					model.setDup(dup[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (effYrmon[i] != null)
					model.setEffYrmon(effYrmon[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCPSScExptListINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CPSScExptListINVO[]
	 */
	public CPSScExptListINVO[] getCPSScExptListINVOs(){
		CPSScExptListINVO[] vos = (CPSScExptListINVO[])models.toArray(new CPSScExptListINVO[models.size()]);
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
		this.chkEffYrmon = this.chkEffYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delflg = this.delflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkScNo = this.chkScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insflg = this.insflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.err3 = this.err3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.err4 = this.err4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.err1 = this.err1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.err2 = this.err2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scCustTpCd = this.scCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updflg = this.updflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaScExptRmk = this.usaScExptRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCustCd = this.chkCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkLocCd = this.chkLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dup = this.dup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effYrmon = this.effYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
