/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomAplyOfcPartnerVO.java
*@FileTitle : CustomAplyOfcPartnerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.10.09 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomAplyOfcPartnerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomAplyOfcPartnerVO> models = new ArrayList<CustomAplyOfcPartnerVO>();
	
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String spPtalId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String agmtOfcTpCd = null;
	/* Column Info */
	private String mnrPrnrLoclLangNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrPrnrCreSeq = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String aplyOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String mnrPrnrKndCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String mnrPrnrStsCd = null;
	/* Column Info */
	private String mnrPrnrLglEngNm = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String mnrPrnrTpCd = null;
	/* Column Info */
	private String ediId = null;
	/* Column Info */
	private String payTermDys = null;
	/* Column Info */
	private String trsmModCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String mnrPrnrEml = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String agmtVerNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomAplyOfcPartnerVO() {}

	public CustomAplyOfcPartnerVO(String ibflag, String pagerows, String updDt, String creUsrId, String agmtSeq, String agmtOfcCtyCd, String creDt, String aplyOfcCd, String agmtOfcTpCd, String agmtVerNo, String updUsrId, String trsmModCd, String ediId, String spPtalId, String phnNo, String faxNo, String mnrPrnrEml, String ctrlOfcCd, String mnrGrpTpCd, String mnrPrnrTpCd, String mnrPrnrKndCd, String mnrPrnrStsCd, String mnrPrnrSeq, String payTermDys, String effDt, String expDt, String mnrPrnrLglEngNm, String mnrPrnrLoclLangNm, String mnrPrnrCreSeq) {
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.spPtalId = spPtalId;
		this.creDt = creDt;
		this.agmtOfcTpCd = agmtOfcTpCd;
		this.mnrPrnrLoclLangNm = mnrPrnrLoclLangNm;
		this.pagerows = pagerows;
		this.mnrPrnrCreSeq = mnrPrnrCreSeq;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.expDt = expDt;
		this.aplyOfcCd = aplyOfcCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.phnNo = phnNo;
		this.mnrPrnrKndCd = mnrPrnrKndCd;
		this.agmtSeq = agmtSeq;
		this.mnrPrnrStsCd = mnrPrnrStsCd;
		this.mnrPrnrLglEngNm = mnrPrnrLglEngNm;
		this.ctrlOfcCd = ctrlOfcCd;
		this.mnrPrnrTpCd = mnrPrnrTpCd;
		this.ediId = ediId;
		this.payTermDys = payTermDys;
		this.trsmModCd = trsmModCd;
		this.creUsrId = creUsrId;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.mnrPrnrEml = mnrPrnrEml;
		this.faxNo = faxNo;
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("sp_ptal_id", getSpPtalId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("agmt_ofc_tp_cd", getAgmtOfcTpCd());
		this.hashColumns.put("mnr_prnr_locl_lang_nm", getMnrPrnrLoclLangNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_prnr_cre_seq", getMnrPrnrCreSeq());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("aply_ofc_cd", getAplyOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("mnr_prnr_knd_cd", getMnrPrnrKndCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("mnr_prnr_sts_cd", getMnrPrnrStsCd());
		this.hashColumns.put("mnr_prnr_lgl_eng_nm", getMnrPrnrLglEngNm());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("mnr_prnr_tp_cd", getMnrPrnrTpCd());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("pay_term_dys", getPayTermDys());
		this.hashColumns.put("trsm_mod_cd", getTrsmModCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("mnr_prnr_eml", getMnrPrnrEml());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("sp_ptal_id", "spPtalId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("agmt_ofc_tp_cd", "agmtOfcTpCd");
		this.hashFields.put("mnr_prnr_locl_lang_nm", "mnrPrnrLoclLangNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_prnr_cre_seq", "mnrPrnrCreSeq");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("aply_ofc_cd", "aplyOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("mnr_prnr_knd_cd", "mnrPrnrKndCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("mnr_prnr_sts_cd", "mnrPrnrStsCd");
		this.hashFields.put("mnr_prnr_lgl_eng_nm", "mnrPrnrLglEngNm");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("mnr_prnr_tp_cd", "mnrPrnrTpCd");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("pay_term_dys", "payTermDys");
		this.hashFields.put("trsm_mod_cd", "trsmModCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("mnr_prnr_eml", "mnrPrnrEml");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return spPtalId
	 */
	public String getSpPtalId() {
		return this.spPtalId;
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
	 * @return agmtOfcTpCd
	 */
	public String getAgmtOfcTpCd() {
		return this.agmtOfcTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrLoclLangNm
	 */
	public String getMnrPrnrLoclLangNm() {
		return this.mnrPrnrLoclLangNm;
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
	 * @return mnrPrnrCreSeq
	 */
	public String getMnrPrnrCreSeq() {
		return this.mnrPrnrCreSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrSeq
	 */
	public String getMnrPrnrSeq() {
		return this.mnrPrnrSeq;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return aplyOfcCd
	 */
	public String getAplyOfcCd() {
		return this.aplyOfcCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrKndCd
	 */
	public String getMnrPrnrKndCd() {
		return this.mnrPrnrKndCd;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrStsCd
	 */
	public String getMnrPrnrStsCd() {
		return this.mnrPrnrStsCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrLglEngNm
	 */
	public String getMnrPrnrLglEngNm() {
		return this.mnrPrnrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrTpCd
	 */
	public String getMnrPrnrTpCd() {
		return this.mnrPrnrTpCd;
	}
	
	/**
	 * Column Info
	 * @return ediId
	 */
	public String getEdiId() {
		return this.ediId;
	}
	
	/**
	 * Column Info
	 * @return payTermDys
	 */
	public String getPayTermDys() {
		return this.payTermDys;
	}
	
	/**
	 * Column Info
	 * @return trsmModCd
	 */
	public String getTrsmModCd() {
		return this.trsmModCd;
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
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrEml
	 */
	public String getMnrPrnrEml() {
		return this.mnrPrnrEml;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
	}
	

	/**
	 * Column Info
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param spPtalId
	 */
	public void setSpPtalId(String spPtalId) {
		this.spPtalId = spPtalId;
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
	 * @param agmtOfcTpCd
	 */
	public void setAgmtOfcTpCd(String agmtOfcTpCd) {
		this.agmtOfcTpCd = agmtOfcTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrLoclLangNm
	 */
	public void setMnrPrnrLoclLangNm(String mnrPrnrLoclLangNm) {
		this.mnrPrnrLoclLangNm = mnrPrnrLoclLangNm;
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
	 * @param mnrPrnrCreSeq
	 */
	public void setMnrPrnrCreSeq(String mnrPrnrCreSeq) {
		this.mnrPrnrCreSeq = mnrPrnrCreSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrSeq
	 */
	public void setMnrPrnrSeq(String mnrPrnrSeq) {
		this.mnrPrnrSeq = mnrPrnrSeq;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param aplyOfcCd
	 */
	public void setAplyOfcCd(String aplyOfcCd) {
		this.aplyOfcCd = aplyOfcCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrKndCd
	 */
	public void setMnrPrnrKndCd(String mnrPrnrKndCd) {
		this.mnrPrnrKndCd = mnrPrnrKndCd;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrStsCd
	 */
	public void setMnrPrnrStsCd(String mnrPrnrStsCd) {
		this.mnrPrnrStsCd = mnrPrnrStsCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrLglEngNm
	 */
	public void setMnrPrnrLglEngNm(String mnrPrnrLglEngNm) {
		this.mnrPrnrLglEngNm = mnrPrnrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrTpCd
	 */
	public void setMnrPrnrTpCd(String mnrPrnrTpCd) {
		this.mnrPrnrTpCd = mnrPrnrTpCd;
	}
	
	/**
	 * Column Info
	 * @param ediId
	 */
	public void setEdiId(String ediId) {
		this.ediId = ediId;
	}
	
	/**
	 * Column Info
	 * @param payTermDys
	 */
	public void setPayTermDys(String payTermDys) {
		this.payTermDys = payTermDys;
	}
	
	/**
	 * Column Info
	 * @param trsmModCd
	 */
	public void setTrsmModCd(String trsmModCd) {
		this.trsmModCd = trsmModCd;
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
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrEml
	 */
	public void setMnrPrnrEml(String mnrPrnrEml) {
		this.mnrPrnrEml = mnrPrnrEml;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMnrGrpTpCd(JSPUtil.getParameter(request, "mnr_grp_tp_cd", ""));
		setSpPtalId(JSPUtil.getParameter(request, "sp_ptal_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAgmtOfcTpCd(JSPUtil.getParameter(request, "agmt_ofc_tp_cd", ""));
		setMnrPrnrLoclLangNm(JSPUtil.getParameter(request, "mnr_prnr_locl_lang_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMnrPrnrCreSeq(JSPUtil.getParameter(request, "mnr_prnr_cre_seq", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, "mnr_prnr_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setAplyOfcCd(JSPUtil.getParameter(request, "aply_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setMnrPrnrKndCd(JSPUtil.getParameter(request, "mnr_prnr_knd_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setMnrPrnrStsCd(JSPUtil.getParameter(request, "mnr_prnr_sts_cd", ""));
		setMnrPrnrLglEngNm(JSPUtil.getParameter(request, "mnr_prnr_lgl_eng_nm", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setMnrPrnrTpCd(JSPUtil.getParameter(request, "mnr_prnr_tp_cd", ""));
		setEdiId(JSPUtil.getParameter(request, "edi_id", ""));
		setPayTermDys(JSPUtil.getParameter(request, "pay_term_dys", ""));
		setTrsmModCd(JSPUtil.getParameter(request, "trsm_mod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setMnrPrnrEml(JSPUtil.getParameter(request, "mnr_prnr_eml", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomAplyOfcPartnerVO[]
	 */
	public CustomAplyOfcPartnerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomAplyOfcPartnerVO[]
	 */
	public CustomAplyOfcPartnerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomAplyOfcPartnerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] spPtalId = (JSPUtil.getParameter(request, prefix	+ "sp_ptal_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] agmtOfcTpCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_tp_cd", length));
			String[] mnrPrnrLoclLangNm = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_locl_lang_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrPrnrCreSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cre_seq", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] aplyOfcCd = (JSPUtil.getParameter(request, prefix	+ "aply_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] mnrPrnrKndCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_knd_cd", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] mnrPrnrStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_sts_cd", length));
			String[] mnrPrnrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_lgl_eng_nm", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] mnrPrnrTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_tp_cd", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] payTermDys = (JSPUtil.getParameter(request, prefix	+ "pay_term_dys", length));
			String[] trsmModCd = (JSPUtil.getParameter(request, prefix	+ "trsm_mod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] mnrPrnrEml = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_eml", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomAplyOfcPartnerVO();
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (spPtalId[i] != null)
					model.setSpPtalId(spPtalId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (agmtOfcTpCd[i] != null)
					model.setAgmtOfcTpCd(agmtOfcTpCd[i]);
				if (mnrPrnrLoclLangNm[i] != null)
					model.setMnrPrnrLoclLangNm(mnrPrnrLoclLangNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrPrnrCreSeq[i] != null)
					model.setMnrPrnrCreSeq(mnrPrnrCreSeq[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (aplyOfcCd[i] != null)
					model.setAplyOfcCd(aplyOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (mnrPrnrKndCd[i] != null)
					model.setMnrPrnrKndCd(mnrPrnrKndCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (mnrPrnrStsCd[i] != null)
					model.setMnrPrnrStsCd(mnrPrnrStsCd[i]);
				if (mnrPrnrLglEngNm[i] != null)
					model.setMnrPrnrLglEngNm(mnrPrnrLglEngNm[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (mnrPrnrTpCd[i] != null)
					model.setMnrPrnrTpCd(mnrPrnrTpCd[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (payTermDys[i] != null)
					model.setPayTermDys(payTermDys[i]);
				if (trsmModCd[i] != null)
					model.setTrsmModCd(trsmModCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (mnrPrnrEml[i] != null)
					model.setMnrPrnrEml(mnrPrnrEml[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomAplyOfcPartnerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomAplyOfcPartnerVO[]
	 */
	public CustomAplyOfcPartnerVO[] getCustomAplyOfcPartnerVOs(){
		CustomAplyOfcPartnerVO[] vos = (CustomAplyOfcPartnerVO[])models.toArray(new CustomAplyOfcPartnerVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spPtalId = this.spPtalId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcTpCd = this.agmtOfcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrLoclLangNm = this.mnrPrnrLoclLangNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCreSeq = this.mnrPrnrCreSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyOfcCd = this.aplyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrKndCd = this.mnrPrnrKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrStsCd = this.mnrPrnrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrLglEngNm = this.mnrPrnrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrTpCd = this.mnrPrnrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermDys = this.payTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmModCd = this.trsmModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrEml = this.mnrPrnrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
