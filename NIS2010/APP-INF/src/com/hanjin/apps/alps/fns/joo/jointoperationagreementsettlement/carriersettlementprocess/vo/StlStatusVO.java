/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StlStatusVO.java
*@FileTitle : StlStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.17
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.11.17 박희동 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StlStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StlStatusVO> models = new ArrayList<StlStatusVO>();
	
	/* Column Info */
	private String eJooSlpAmt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String eJooCmbAmt = null;
	/* Column Info */
	private String joStlItmCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rCoaBsaAmt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String eJooCmbBgcolorYn = null;
	/* Column Info */
	private String rJooCmbAmt = null;
	/* Column Info */
	private String eCoaBsaAmt = null;
	/* Column Info */
	private String eJooSlpBgcolorYn = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String rJooCmbBgcolorYn = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String rJooSlpBgcolorYn = null;
	/* Column Info */
	private String joUnstlStsRmk = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String rJooSlpAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public StlStatusVO() {}

	public StlStatusVO(String ibflag, String pagerows, String trdCd, String rlaneCd, String joCrrCd, String vvd, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String revYrmon, String acctYrmon, String joStlItmCd, String joUnstlStsRmk, String usrId, String rCoaBsaAmt, String rJooCmbAmt, String rJooSlpAmt, String rJooCmbBgcolorYn, String rJooSlpBgcolorYn, String eCoaBsaAmt, String eJooCmbAmt, String eJooSlpAmt, String eJooCmbBgcolorYn, String eJooSlpBgcolorYn) {
		this.eJooSlpAmt = eJooSlpAmt;
		this.vslCd = vslCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.eJooCmbAmt = eJooCmbAmt;
		this.joStlItmCd = joStlItmCd;
		this.pagerows = pagerows;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.rCoaBsaAmt = rCoaBsaAmt;
		this.usrId = usrId;
		this.eJooCmbBgcolorYn = eJooCmbBgcolorYn;
		this.rJooCmbAmt = rJooCmbAmt;
		this.eCoaBsaAmt = eCoaBsaAmt;
		this.eJooSlpBgcolorYn = eJooSlpBgcolorYn;
		this.revYrmon = revYrmon;
		this.rJooCmbBgcolorYn = rJooCmbBgcolorYn;
		this.skdVoyNo = skdVoyNo;
		this.joCrrCd = joCrrCd;
		this.rJooSlpBgcolorYn = rJooSlpBgcolorYn;
		this.joUnstlStsRmk = joUnstlStsRmk;
		this.skdDirCd = skdDirCd;
		this.vvd = vvd;
		this.acctYrmon = acctYrmon;
		this.rJooSlpAmt = rJooSlpAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("e_joo_slp_amt", getEJooSlpAmt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("e_joo_cmb_amt", getEJooCmbAmt());
		this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("r_coa_bsa_amt", getRCoaBsaAmt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("e_joo_cmb_bgcolor_yn", getEJooCmbBgcolorYn());
		this.hashColumns.put("r_joo_cmb_amt", getRJooCmbAmt());
		this.hashColumns.put("e_coa_bsa_amt", getECoaBsaAmt());
		this.hashColumns.put("e_joo_slp_bgcolor_yn", getEJooSlpBgcolorYn());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("r_joo_cmb_bgcolor_yn", getRJooCmbBgcolorYn());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("r_joo_slp_bgcolor_yn", getRJooSlpBgcolorYn());
		this.hashColumns.put("jo_unstl_sts_rmk", getJoUnstlStsRmk());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("r_joo_slp_amt", getRJooSlpAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("e_joo_slp_amt", "eJooSlpAmt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("e_joo_cmb_amt", "eJooCmbAmt");
		this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("r_coa_bsa_amt", "rCoaBsaAmt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("e_joo_cmb_bgcolor_yn", "eJooCmbBgcolorYn");
		this.hashFields.put("r_joo_cmb_amt", "rJooCmbAmt");
		this.hashFields.put("e_coa_bsa_amt", "eCoaBsaAmt");
		this.hashFields.put("e_joo_slp_bgcolor_yn", "eJooSlpBgcolorYn");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("r_joo_cmb_bgcolor_yn", "rJooCmbBgcolorYn");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("r_joo_slp_bgcolor_yn", "rJooSlpBgcolorYn");
		this.hashFields.put("jo_unstl_sts_rmk", "joUnstlStsRmk");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("r_joo_slp_amt", "rJooSlpAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eJooSlpAmt
	 */
	public String getEJooSlpAmt() {
		return this.eJooSlpAmt;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return eJooCmbAmt
	 */
	public String getEJooCmbAmt() {
		return this.eJooCmbAmt;
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
	 * @return rCoaBsaAmt
	 */
	public String getRCoaBsaAmt() {
		return this.rCoaBsaAmt;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return eJooCmbBgcolorYn
	 */
	public String getEJooCmbBgcolorYn() {
		return this.eJooCmbBgcolorYn;
	}
	
	/**
	 * Column Info
	 * @return rJooCmbAmt
	 */
	public String getRJooCmbAmt() {
		return this.rJooCmbAmt;
	}
	
	/**
	 * Column Info
	 * @return eCoaBsaAmt
	 */
	public String getECoaBsaAmt() {
		return this.eCoaBsaAmt;
	}
	
	/**
	 * Column Info
	 * @return eJooSlpBgcolorYn
	 */
	public String getEJooSlpBgcolorYn() {
		return this.eJooSlpBgcolorYn;
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
	 * @return rJooCmbBgcolorYn
	 */
	public String getRJooCmbBgcolorYn() {
		return this.rJooCmbBgcolorYn;
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
	 * @return rJooSlpBgcolorYn
	 */
	public String getRJooSlpBgcolorYn() {
		return this.rJooSlpBgcolorYn;
	}
	
	/**
	 * Column Info
	 * @return joUnstlStsRmk
	 */
	public String getJoUnstlStsRmk() {
		return this.joUnstlStsRmk;
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
	 * @return rJooSlpAmt
	 */
	public String getRJooSlpAmt() {
		return this.rJooSlpAmt;
	}
	

	/**
	 * Column Info
	 * @param eJooSlpAmt
	 */
	public void setEJooSlpAmt(String eJooSlpAmt) {
		this.eJooSlpAmt = eJooSlpAmt;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param eJooCmbAmt
	 */
	public void setEJooCmbAmt(String eJooCmbAmt) {
		this.eJooCmbAmt = eJooCmbAmt;
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
	 * @param rCoaBsaAmt
	 */
	public void setRCoaBsaAmt(String rCoaBsaAmt) {
		this.rCoaBsaAmt = rCoaBsaAmt;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param eJooCmbBgcolorYn
	 */
	public void setEJooCmbBgcolorYn(String eJooCmbBgcolorYn) {
		this.eJooCmbBgcolorYn = eJooCmbBgcolorYn;
	}
	
	/**
	 * Column Info
	 * @param rJooCmbAmt
	 */
	public void setRJooCmbAmt(String rJooCmbAmt) {
		this.rJooCmbAmt = rJooCmbAmt;
	}
	
	/**
	 * Column Info
	 * @param eCoaBsaAmt
	 */
	public void setECoaBsaAmt(String eCoaBsaAmt) {
		this.eCoaBsaAmt = eCoaBsaAmt;
	}
	
	/**
	 * Column Info
	 * @param eJooSlpBgcolorYn
	 */
	public void setEJooSlpBgcolorYn(String eJooSlpBgcolorYn) {
		this.eJooSlpBgcolorYn = eJooSlpBgcolorYn;
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
	 * @param rJooCmbBgcolorYn
	 */
	public void setRJooCmbBgcolorYn(String rJooCmbBgcolorYn) {
		this.rJooCmbBgcolorYn = rJooCmbBgcolorYn;
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
	 * @param rJooSlpBgcolorYn
	 */
	public void setRJooSlpBgcolorYn(String rJooSlpBgcolorYn) {
		this.rJooSlpBgcolorYn = rJooSlpBgcolorYn;
	}
	
	/**
	 * Column Info
	 * @param joUnstlStsRmk
	 */
	public void setJoUnstlStsRmk(String joUnstlStsRmk) {
		this.joUnstlStsRmk = joUnstlStsRmk;
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
	 * @param rJooSlpAmt
	 */
	public void setRJooSlpAmt(String rJooSlpAmt) {
		this.rJooSlpAmt = rJooSlpAmt;
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
		setEJooSlpAmt(JSPUtil.getParameter(request, prefix + "e_joo_slp_amt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setEJooCmbAmt(JSPUtil.getParameter(request, prefix + "e_joo_cmb_amt", ""));
		setJoStlItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRCoaBsaAmt(JSPUtil.getParameter(request, prefix + "r_coa_bsa_amt", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setEJooCmbBgcolorYn(JSPUtil.getParameter(request, prefix + "e_joo_cmb_bgcolor_yn", ""));
		setRJooCmbAmt(JSPUtil.getParameter(request, prefix + "r_joo_cmb_amt", ""));
		setECoaBsaAmt(JSPUtil.getParameter(request, prefix + "e_coa_bsa_amt", ""));
		setEJooSlpBgcolorYn(JSPUtil.getParameter(request, prefix + "e_joo_slp_bgcolor_yn", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setRJooCmbBgcolorYn(JSPUtil.getParameter(request, prefix + "r_joo_cmb_bgcolor_yn", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setRJooSlpBgcolorYn(JSPUtil.getParameter(request, prefix + "r_joo_slp_bgcolor_yn", ""));
		setJoUnstlStsRmk(JSPUtil.getParameter(request, prefix + "jo_unstl_sts_rmk", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));
		setRJooSlpAmt(JSPUtil.getParameter(request, prefix + "r_joo_slp_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StlStatusVO[]
	 */
	public StlStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StlStatusVO[]
	 */
	public StlStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StlStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eJooSlpAmt = (JSPUtil.getParameter(request, prefix	+ "e_joo_slp_amt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] eJooCmbAmt = (JSPUtil.getParameter(request, prefix	+ "e_joo_cmb_amt", length));
			String[] joStlItmCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rCoaBsaAmt = (JSPUtil.getParameter(request, prefix	+ "r_coa_bsa_amt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] eJooCmbBgcolorYn = (JSPUtil.getParameter(request, prefix	+ "e_joo_cmb_bgcolor_yn", length));
			String[] rJooCmbAmt = (JSPUtil.getParameter(request, prefix	+ "r_joo_cmb_amt", length));
			String[] eCoaBsaAmt = (JSPUtil.getParameter(request, prefix	+ "e_coa_bsa_amt", length));
			String[] eJooSlpBgcolorYn = (JSPUtil.getParameter(request, prefix	+ "e_joo_slp_bgcolor_yn", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] rJooCmbBgcolorYn = (JSPUtil.getParameter(request, prefix	+ "r_joo_cmb_bgcolor_yn", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] rJooSlpBgcolorYn = (JSPUtil.getParameter(request, prefix	+ "r_joo_slp_bgcolor_yn", length));
			String[] joUnstlStsRmk = (JSPUtil.getParameter(request, prefix	+ "jo_unstl_sts_rmk", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] rJooSlpAmt = (JSPUtil.getParameter(request, prefix	+ "r_joo_slp_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new StlStatusVO();
				if (eJooSlpAmt[i] != null)
					model.setEJooSlpAmt(eJooSlpAmt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (eJooCmbAmt[i] != null)
					model.setEJooCmbAmt(eJooCmbAmt[i]);
				if (joStlItmCd[i] != null)
					model.setJoStlItmCd(joStlItmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rCoaBsaAmt[i] != null)
					model.setRCoaBsaAmt(rCoaBsaAmt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (eJooCmbBgcolorYn[i] != null)
					model.setEJooCmbBgcolorYn(eJooCmbBgcolorYn[i]);
				if (rJooCmbAmt[i] != null)
					model.setRJooCmbAmt(rJooCmbAmt[i]);
				if (eCoaBsaAmt[i] != null)
					model.setECoaBsaAmt(eCoaBsaAmt[i]);
				if (eJooSlpBgcolorYn[i] != null)
					model.setEJooSlpBgcolorYn(eJooSlpBgcolorYn[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (rJooCmbBgcolorYn[i] != null)
					model.setRJooCmbBgcolorYn(rJooCmbBgcolorYn[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (rJooSlpBgcolorYn[i] != null)
					model.setRJooSlpBgcolorYn(rJooSlpBgcolorYn[i]);
				if (joUnstlStsRmk[i] != null)
					model.setJoUnstlStsRmk(joUnstlStsRmk[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (rJooSlpAmt[i] != null)
					model.setRJooSlpAmt(rJooSlpAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStlStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StlStatusVO[]
	 */
	public StlStatusVO[] getStlStatusVOs(){
		StlStatusVO[] vos = (StlStatusVO[])models.toArray(new StlStatusVO[models.size()]);
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
		this.eJooSlpAmt = this.eJooSlpAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eJooCmbAmt = this.eJooCmbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCd = this.joStlItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rCoaBsaAmt = this.rCoaBsaAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eJooCmbBgcolorYn = this.eJooCmbBgcolorYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rJooCmbAmt = this.rJooCmbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eCoaBsaAmt = this.eCoaBsaAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eJooSlpBgcolorYn = this.eJooSlpBgcolorYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rJooCmbBgcolorYn = this.rJooCmbBgcolorYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rJooSlpBgcolorYn = this.rJooSlpBgcolorYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joUnstlStsRmk = this.joUnstlStsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rJooSlpAmt = this.rJooSlpAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
