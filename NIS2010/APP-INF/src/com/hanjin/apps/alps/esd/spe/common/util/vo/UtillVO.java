/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UtillVO.java
*@FileTitle : UtillVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.26
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.26 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.spe.common.util.vo;

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
 * @author 백형인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UtillVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UtillVO> models = new ArrayList<UtillVO>();
	
	/* Column Info */
	private String isflag = null;
	/* Column Info */
	private String egRhqCd = null;
	/* Column Info */
	private String fCtrtOfcCd = null;
	/* Column Info */
	private String spSeq = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String spCateCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String egNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sCtrtOfcCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String codeNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String codeKey = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sEgOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sTmlCd = null;
	/* Column Info */
	private String sSpCateCd = null;
	/* Column Info */
	private String sEgRhqCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String egOfcCd = null;
	/* Column Info */
	private String sRegGp = null;
	/* Column Info */
	private String codeCd = null;
	/* Column Info */
	private String egId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UtillVO() {}

	public UtillVO(String ibflag, String pagerows, String sEgRhqCd, String sEgOfcCd, String sSpCateCd, String egId, String egNm, String egRhqCd, String egOfcCd, String spCateCd, String ctrtOfcCd, String codeKey, String codeCd, String codeNm, String creUsrId, String updUsrId, String isflag, String sRegGp, String sCtrtOfcCd, String fCtrtOfcCd, String spSeq, String vndrSeq, String vndrNm, String usrId, String usrNm, String ofcCd, String sTmlCd, String tmlCd) {
		this.isflag = isflag;
		this.egRhqCd = egRhqCd;
		this.fCtrtOfcCd = fCtrtOfcCd;
		this.spSeq = spSeq;
		this.tmlCd = tmlCd;
		this.spCateCd = spCateCd;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.egNm = egNm;
		this.ibflag = ibflag;
		this.sCtrtOfcCd = sCtrtOfcCd;
		this.usrId = usrId;
		this.usrNm = usrNm;
		this.ctrtOfcCd = ctrtOfcCd;
		this.codeNm = codeNm;
		this.updUsrId = updUsrId;
		this.codeKey = codeKey;
		this.ofcCd = ofcCd;
		this.sEgOfcCd = sEgOfcCd;
		this.creUsrId = creUsrId;
		this.sTmlCd = sTmlCd;
		this.sSpCateCd = sSpCateCd;
		this.sEgRhqCd = sEgRhqCd;
		this.vndrSeq = vndrSeq;
		this.egOfcCd = egOfcCd;
		this.sRegGp = sRegGp;
		this.codeCd = codeCd;
		this.egId = egId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("isflag", getIsflag());
		this.hashColumns.put("eg_rhq_cd", getEgRhqCd());
		this.hashColumns.put("f_ctrt_ofc_cd", getFCtrtOfcCd());
		this.hashColumns.put("sp_seq", getSpSeq());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("sp_cate_cd", getSpCateCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("eg_nm", getEgNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_ctrt_ofc_cd", getSCtrtOfcCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("code_nm", getCodeNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("code_key", getCodeKey());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("s_eg_ofc_cd", getSEgOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("s_tml_cd", getSTmlCd());
		this.hashColumns.put("s_sp_cate_cd", getSSpCateCd());
		this.hashColumns.put("s_eg_rhq_cd", getSEgRhqCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("eg_ofc_cd", getEgOfcCd());
		this.hashColumns.put("s_reg_gp", getSRegGp());
		this.hashColumns.put("code_cd", getCodeCd());
		this.hashColumns.put("eg_id", getEgId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("isflag", "isflag");
		this.hashFields.put("eg_rhq_cd", "egRhqCd");
		this.hashFields.put("f_ctrt_ofc_cd", "fCtrtOfcCd");
		this.hashFields.put("sp_seq", "spSeq");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("sp_cate_cd", "spCateCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("eg_nm", "egNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_ctrt_ofc_cd", "sCtrtOfcCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("code_nm", "codeNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("code_key", "codeKey");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("s_eg_ofc_cd", "sEgOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("s_tml_cd", "sTmlCd");
		this.hashFields.put("s_sp_cate_cd", "sSpCateCd");
		this.hashFields.put("s_eg_rhq_cd", "sEgRhqCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("eg_ofc_cd", "egOfcCd");
		this.hashFields.put("s_reg_gp", "sRegGp");
		this.hashFields.put("code_cd", "codeCd");
		this.hashFields.put("eg_id", "egId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return isflag
	 */
	public String getIsflag() {
		return this.isflag;
	}
	
	/**
	 * Column Info
	 * @return egRhqCd
	 */
	public String getEgRhqCd() {
		return this.egRhqCd;
	}
	
	/**
	 * Column Info
	 * @return fCtrtOfcCd
	 */
	public String getFCtrtOfcCd() {
		return this.fCtrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return spSeq
	 */
	public String getSpSeq() {
		return this.spSeq;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return spCateCd
	 */
	public String getSpCateCd() {
		return this.spCateCd;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return egNm
	 */
	public String getEgNm() {
		return this.egNm;
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
	 * @return sCtrtOfcCd
	 */
	public String getSCtrtOfcCd() {
		return this.sCtrtOfcCd;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
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
	 * @return codeNm
	 */
	public String getCodeNm() {
		return this.codeNm;
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
	 * @return codeKey
	 */
	public String getCodeKey() {
		return this.codeKey;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return sEgOfcCd
	 */
	public String getSEgOfcCd() {
		return this.sEgOfcCd;
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
	 * @return sTmlCd
	 */
	public String getSTmlCd() {
		return this.sTmlCd;
	}
	
	/**
	 * Column Info
	 * @return sSpCateCd
	 */
	public String getSSpCateCd() {
		return this.sSpCateCd;
	}
	
	/**
	 * Column Info
	 * @return sEgRhqCd
	 */
	public String getSEgRhqCd() {
		return this.sEgRhqCd;
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
	 * @return egOfcCd
	 */
	public String getEgOfcCd() {
		return this.egOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sRegGp
	 */
	public String getSRegGp() {
		return this.sRegGp;
	}
	
	/**
	 * Column Info
	 * @return codeCd
	 */
	public String getCodeCd() {
		return this.codeCd;
	}
	
	/**
	 * Column Info
	 * @return egId
	 */
	public String getEgId() {
		return this.egId;
	}
	

	/**
	 * Column Info
	 * @param isflag
	 */
	public void setIsflag(String isflag) {
		this.isflag = isflag;
	}
	
	/**
	 * Column Info
	 * @param egRhqCd
	 */
	public void setEgRhqCd(String egRhqCd) {
		this.egRhqCd = egRhqCd;
	}
	
	/**
	 * Column Info
	 * @param fCtrtOfcCd
	 */
	public void setFCtrtOfcCd(String fCtrtOfcCd) {
		this.fCtrtOfcCd = fCtrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param spSeq
	 */
	public void setSpSeq(String spSeq) {
		this.spSeq = spSeq;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param spCateCd
	 */
	public void setSpCateCd(String spCateCd) {
		this.spCateCd = spCateCd;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param egNm
	 */
	public void setEgNm(String egNm) {
		this.egNm = egNm;
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
	 * @param sCtrtOfcCd
	 */
	public void setSCtrtOfcCd(String sCtrtOfcCd) {
		this.sCtrtOfcCd = sCtrtOfcCd;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * @param codeNm
	 */
	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
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
	 * @param codeKey
	 */
	public void setCodeKey(String codeKey) {
		this.codeKey = codeKey;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param sEgOfcCd
	 */
	public void setSEgOfcCd(String sEgOfcCd) {
		this.sEgOfcCd = sEgOfcCd;
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
	 * @param sTmlCd
	 */
	public void setSTmlCd(String sTmlCd) {
		this.sTmlCd = sTmlCd;
	}
	
	/**
	 * Column Info
	 * @param sSpCateCd
	 */
	public void setSSpCateCd(String sSpCateCd) {
		this.sSpCateCd = sSpCateCd;
	}
	
	/**
	 * Column Info
	 * @param sEgRhqCd
	 */
	public void setSEgRhqCd(String sEgRhqCd) {
		this.sEgRhqCd = sEgRhqCd;
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
	 * @param egOfcCd
	 */
	public void setEgOfcCd(String egOfcCd) {
		this.egOfcCd = egOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sRegGp
	 */
	public void setSRegGp(String sRegGp) {
		this.sRegGp = sRegGp;
	}
	
	/**
	 * Column Info
	 * @param codeCd
	 */
	public void setCodeCd(String codeCd) {
		this.codeCd = codeCd;
	}
	
	/**
	 * Column Info
	 * @param egId
	 */
	public void setEgId(String egId) {
		this.egId = egId;
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
		setIsflag(JSPUtil.getParameter(request, prefix + "isflag", ""));
		setEgRhqCd(JSPUtil.getParameter(request, prefix + "eg_rhq_cd", ""));
		setFCtrtOfcCd(JSPUtil.getParameter(request, prefix + "f_ctrt_ofc_cd", ""));
		setSpSeq(JSPUtil.getParameter(request, prefix + "sp_seq", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setSpCateCd(JSPUtil.getParameter(request, prefix + "sp_cate_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setEgNm(JSPUtil.getParameter(request, prefix + "eg_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSCtrtOfcCd(JSPUtil.getParameter(request, prefix + "s_ctrt_ofc_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setCodeNm(JSPUtil.getParameter(request, prefix + "code_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCodeKey(JSPUtil.getParameter(request, prefix + "code_key", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setSEgOfcCd(JSPUtil.getParameter(request, prefix + "s_eg_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSTmlCd(JSPUtil.getParameter(request, prefix + "s_tml_cd", ""));
		setSSpCateCd(JSPUtil.getParameter(request, prefix + "s_sp_cate_cd", ""));
		setSEgRhqCd(JSPUtil.getParameter(request, prefix + "s_eg_rhq_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setEgOfcCd(JSPUtil.getParameter(request, prefix + "eg_ofc_cd", ""));
		setSRegGp(JSPUtil.getParameter(request, prefix + "s_reg_gp", ""));
		setCodeCd(JSPUtil.getParameter(request, prefix + "code_cd", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UtillVO[]
	 */
	public UtillVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UtillVO[]
	 */
	public UtillVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UtillVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] isflag = (JSPUtil.getParameter(request, prefix	+ "isflag", length));
			String[] egRhqCd = (JSPUtil.getParameter(request, prefix	+ "eg_rhq_cd", length));
			String[] fCtrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ctrt_ofc_cd", length));
			String[] spSeq = (JSPUtil.getParameter(request, prefix	+ "sp_seq", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] spCateCd = (JSPUtil.getParameter(request, prefix	+ "sp_cate_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] egNm = (JSPUtil.getParameter(request, prefix	+ "eg_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sCtrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ctrt_ofc_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] codeNm = (JSPUtil.getParameter(request, prefix	+ "code_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] codeKey = (JSPUtil.getParameter(request, prefix	+ "code_key", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] sEgOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sTmlCd = (JSPUtil.getParameter(request, prefix	+ "s_tml_cd", length));
			String[] sSpCateCd = (JSPUtil.getParameter(request, prefix	+ "s_sp_cate_cd", length));
			String[] sEgRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_rhq_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] egOfcCd = (JSPUtil.getParameter(request, prefix	+ "eg_ofc_cd", length));
			String[] sRegGp = (JSPUtil.getParameter(request, prefix	+ "s_reg_gp", length));
			String[] codeCd = (JSPUtil.getParameter(request, prefix	+ "code_cd", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new UtillVO();
				if (isflag[i] != null)
					model.setIsflag(isflag[i]);
				if (egRhqCd[i] != null)
					model.setEgRhqCd(egRhqCd[i]);
				if (fCtrtOfcCd[i] != null)
					model.setFCtrtOfcCd(fCtrtOfcCd[i]);
				if (spSeq[i] != null)
					model.setSpSeq(spSeq[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (spCateCd[i] != null)
					model.setSpCateCd(spCateCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (egNm[i] != null)
					model.setEgNm(egNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sCtrtOfcCd[i] != null)
					model.setSCtrtOfcCd(sCtrtOfcCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (codeNm[i] != null)
					model.setCodeNm(codeNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (codeKey[i] != null)
					model.setCodeKey(codeKey[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (sEgOfcCd[i] != null)
					model.setSEgOfcCd(sEgOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sTmlCd[i] != null)
					model.setSTmlCd(sTmlCd[i]);
				if (sSpCateCd[i] != null)
					model.setSSpCateCd(sSpCateCd[i]);
				if (sEgRhqCd[i] != null)
					model.setSEgRhqCd(sEgRhqCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (egOfcCd[i] != null)
					model.setEgOfcCd(egOfcCd[i]);
				if (sRegGp[i] != null)
					model.setSRegGp(sRegGp[i]);
				if (codeCd[i] != null)
					model.setCodeCd(codeCd[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUtillVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UtillVO[]
	 */
	public UtillVO[] getUtillVOs(){
		UtillVO[] vos = (UtillVO[])models.toArray(new UtillVO[models.size()]);
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
		this.isflag = this.isflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egRhqCd = this.egRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCtrtOfcCd = this.fCtrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spSeq = this.spSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCateCd = this.spCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egNm = this.egNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCtrtOfcCd = this.sCtrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeNm = this.codeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeKey = this.codeKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgOfcCd = this.sEgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTmlCd = this.sTmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSpCateCd = this.sSpCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgRhqCd = this.sEgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egOfcCd = this.egOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRegGp = this.sRegGp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeCd = this.codeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
