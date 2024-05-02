/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TesTmlAgmtHdrVO.java
*@FileTitle : TesTmlAgmtHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.20  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesTmlAgmtHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesTmlAgmtHdrVO> models = new ArrayList<TesTmlAgmtHdrVO>();
	
	/* Column Info */
	private String tmlAgmtStsCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String agmtVerN2ndNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tmlAgmtVerNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String agmtCfmUsrNm = null;
	/* Column Info */
	private String agmtRmk = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String tmlAgmtOfcCtyCd = null;
	/* Column Info */
	private String agmtCfmUsrId = null;
	/* Column Info */
	private String agmtVerN1stNo = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String agmtCfmDt = null;
	/* Column Info */
	private String agmtCfmFlg = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String tmlAgmtSeq = null;
	/* Column Info */
	private String autoXtdFlg = null;
	/* Column Info */
	private String agmtAproDt = null;
	/* Column Info */
	private String loclUpdDt = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String agmtDocNo = null;
	/* Column Info */
	private String agmtDocDesc = null;
	/* Column Info */
	private String agmtDocEffFmDt = null;
	/* Column Info */
	private String agmtDocEffToDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesTmlAgmtHdrVO() {}

	
	public TesTmlAgmtHdrVO(String ibflag, String pagerows, String updDt, String tmlAgmtStsCd, String tmlAgmtOfcCtyCd, String deltFlg, String loclCreDt, String creDt, String agmtVerN1stNo, String agmtVerN2ndNo, String tmlAgmtVerNo, String creUsrId, String ydCd, String creOfcCd, String ctrtOfcCd, String vndrSeq, String tmlAgmtSeq, String agmtRmk, String effFmDt, String autoXtdFlg, String agmtAproDt, String loclUpdDt, String effToDt, String updUsrId, String agmtCfmDt, String agmtCfmUsrId, String agmtCfmUsrNm, String agmtCfmFlg
			, String agmtDocNo, String agmtDocDesc, String agmtDocEffFmDt, String agmtDocEffToDt
			) {
		this.tmlAgmtStsCd = tmlAgmtStsCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.agmtVerN2ndNo = agmtVerN2ndNo;
		this.pagerows = pagerows;
		this.tmlAgmtVerNo = tmlAgmtVerNo;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.agmtCfmUsrNm = agmtCfmUsrNm;
		this.agmtRmk = agmtRmk;
		this.effFmDt = effFmDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.tmlAgmtOfcCtyCd = tmlAgmtOfcCtyCd;
		this.agmtCfmUsrId = agmtCfmUsrId;
		this.agmtVerN1stNo = agmtVerN1stNo;
		this.loclCreDt = loclCreDt;
		this.creUsrId = creUsrId;
		this.ydCd = ydCd;
		this.agmtCfmDt = agmtCfmDt;
		this.agmtCfmFlg = agmtCfmFlg;
		this.vndrSeq = vndrSeq;
		this.tmlAgmtSeq = tmlAgmtSeq;
		this.autoXtdFlg = autoXtdFlg;
		this.agmtAproDt = agmtAproDt;
		this.loclUpdDt = loclUpdDt;
		this.effToDt = effToDt;
		this.agmtDocNo = agmtDocNo;
		this.agmtDocDesc = agmtDocDesc;
		this.agmtDocEffFmDt = agmtDocEffFmDt;
		this.agmtDocEffToDt = agmtDocEffToDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tml_agmt_sts_cd", getTmlAgmtStsCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("agmt_ver_n2nd_no", getAgmtVerN2ndNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tml_agmt_ver_no", getTmlAgmtVerNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("agmt_cfm_usr_nm", getAgmtCfmUsrNm());
		this.hashColumns.put("agmt_rmk", getAgmtRmk());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tml_agmt_ofc_cty_cd", getTmlAgmtOfcCtyCd());
		this.hashColumns.put("agmt_cfm_usr_id", getAgmtCfmUsrId());
		this.hashColumns.put("agmt_ver_n1st_no", getAgmtVerN1stNo());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("agmt_cfm_dt", getAgmtCfmDt());
		this.hashColumns.put("agmt_cfm_flg", getAgmtCfmFlg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("tml_agmt_seq", getTmlAgmtSeq());
		this.hashColumns.put("auto_xtd_flg", getAutoXtdFlg());
		this.hashColumns.put("agmt_apro_dt", getAgmtAproDt());
		this.hashColumns.put("locl_upd_dt", getLoclUpdDt());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("agmt_doc_no", getAgmtDocNo());
		this.hashColumns.put("agmt_doc_desc", getAgmtDocDesc());
		this.hashColumns.put("agmt_doc_eff_fm_dt", getAgmtDocEffFmDt());
		this.hashColumns.put("agmt_doc_eff_to_dt", getAgmtDocEffToDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tml_agmt_sts_cd", "tmlAgmtStsCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("agmt_ver_n2nd_no", "agmtVerN2ndNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tml_agmt_ver_no", "tmlAgmtVerNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("agmt_cfm_usr_nm", "agmtCfmUsrNm");
		this.hashFields.put("agmt_rmk", "agmtRmk");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tml_agmt_ofc_cty_cd", "tmlAgmtOfcCtyCd");
		this.hashFields.put("agmt_cfm_usr_id", "agmtCfmUsrId");
		this.hashFields.put("agmt_ver_n1st_no", "agmtVerN1stNo");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("agmt_cfm_dt", "agmtCfmDt");
		this.hashFields.put("agmt_cfm_flg", "agmtCfmFlg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("tml_agmt_seq", "tmlAgmtSeq");
		this.hashFields.put("auto_xtd_flg", "autoXtdFlg");
		this.hashFields.put("agmt_apro_dt", "agmtAproDt");
		this.hashFields.put("locl_upd_dt", "loclUpdDt");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("agmt_doc_no", "agmtDocNo");
		this.hashFields.put("agmt_doc_desc", "agmtDocDesc");
		this.hashFields.put("agmt_doc_eff_fm_dt", "agmtDocEffFmDt");
		this.hashFields.put("agmt_doc_eff_to_dt", "agmtDocEffToDt");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tmlAgmtStsCd
	 */
	public String getTmlAgmtStsCd() {
		return this.tmlAgmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return agmtVerN2ndNo
	 */
	public String getAgmtVerN2ndNo() {
		return this.agmtVerN2ndNo;
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
	 * @return tmlAgmtVerNo
	 */
	public String getTmlAgmtVerNo() {
		return this.tmlAgmtVerNo;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return agmtCfmUsrNm
	 */
	public String getAgmtCfmUsrNm() {
		return this.agmtCfmUsrNm;
	}
	
	/**
	 * Column Info
	 * @return agmtRmk
	 */
	public String getAgmtRmk() {
		return this.agmtRmk;
	}
	
	/**
	 * Column Info
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
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
	 * @return tmlAgmtOfcCtyCd
	 */
	public String getTmlAgmtOfcCtyCd() {
		return this.tmlAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return agmtCfmUsrId
	 */
	public String getAgmtCfmUsrId() {
		return this.agmtCfmUsrId;
	}
	
	/**
	 * Column Info
	 * @return agmtVerN1stNo
	 */
	public String getAgmtVerN1stNo() {
		return this.agmtVerN1stNo;
	}
	
	/**
	 * Column Info
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return agmtCfmDt
	 */
	public String getAgmtCfmDt() {
		return this.agmtCfmDt;
	}
	
	/**
	 * Column Info
	 * @return agmtCfmFlg
	 */
	public String getAgmtCfmFlg() {
		return this.agmtCfmFlg;
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
	 * @return tmlAgmtSeq
	 */
	public String getTmlAgmtSeq() {
		return this.tmlAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return autoXtdFlg
	 */
	public String getAutoXtdFlg() {
		return this.autoXtdFlg;
	}
	
	/**
	 * Column Info
	 * @return agmtAproDt
	 */
	public String getAgmtAproDt() {
		return this.agmtAproDt;
	}
	
	/**
	 * Column Info
	 * @return loclUpdDt
	 */
	public String getLoclUpdDt() {
		return this.loclUpdDt;
	}
	
	/**
	 * Column Info
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
	}

	/**
	 * Column Info
	 * @return agmtDocNo
	 */
	public String getAgmtDocNo() {
		return this.agmtDocNo;
	}

	/**
	 * Column Info
	 * @return agmtDocDesc
	 */
	public String getAgmtDocDesc() {
		return this.agmtDocDesc;
	}
	
	/**
	 * Column Info
	 * @return agmtDocEffFmDt
	 */
	public String getAgmtDocEffFmDt() {
		return this.agmtDocEffFmDt;
	}
	
	/**
	 * Column Info
	 * @return agmtDocEffToDt
	 */
	public String getAgmtDocEffToDt() {
		return this.agmtDocEffToDt;
	}

	/**
	 * Column Info
	 * @param tmlAgmtStsCd
	 */
	public void setTmlAgmtStsCd(String tmlAgmtStsCd) {
		this.tmlAgmtStsCd = tmlAgmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param agmtVerN2ndNo
	 */
	public void setAgmtVerN2ndNo(String agmtVerN2ndNo) {
		this.agmtVerN2ndNo = agmtVerN2ndNo;
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
	 * @param tmlAgmtVerNo
	 */
	public void setTmlAgmtVerNo(String tmlAgmtVerNo) {
		this.tmlAgmtVerNo = tmlAgmtVerNo;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param agmtCfmUsrNm
	 */
	public void setAgmtCfmUsrNm(String agmtCfmUsrNm) {
		this.agmtCfmUsrNm = agmtCfmUsrNm;
	}
	
	/**
	 * Column Info
	 * @param agmtRmk
	 */
	public void setAgmtRmk(String agmtRmk) {
		this.agmtRmk = agmtRmk;
	}
	
	/**
	 * Column Info
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
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
	 * @param tmlAgmtOfcCtyCd
	 */
	public void setTmlAgmtOfcCtyCd(String tmlAgmtOfcCtyCd) {
		this.tmlAgmtOfcCtyCd = tmlAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param agmtCfmUsrId
	 */
	public void setAgmtCfmUsrId(String agmtCfmUsrId) {
		this.agmtCfmUsrId = agmtCfmUsrId;
	}
	
	/**
	 * Column Info
	 * @param agmtVerN1stNo
	 */
	public void setAgmtVerN1stNo(String agmtVerN1stNo) {
		this.agmtVerN1stNo = agmtVerN1stNo;
	}
	
	/**
	 * Column Info
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param agmtCfmDt
	 */
	public void setAgmtCfmDt(String agmtCfmDt) {
		this.agmtCfmDt = agmtCfmDt;
	}
	
	/**
	 * Column Info
	 * @param agmtCfmFlg
	 */
	public void setAgmtCfmFlg(String agmtCfmFlg) {
		this.agmtCfmFlg = agmtCfmFlg;
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
	 * @param tmlAgmtSeq
	 */
	public void setTmlAgmtSeq(String tmlAgmtSeq) {
		this.tmlAgmtSeq = tmlAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param autoXtdFlg
	 */
	public void setAutoXtdFlg(String autoXtdFlg) {
		this.autoXtdFlg = autoXtdFlg;
	}
	
	/**
	 * Column Info
	 * @param agmtAproDt
	 */
	public void setAgmtAproDt(String agmtAproDt) {
		this.agmtAproDt = agmtAproDt;
	}
	
	/**
	 * Column Info
	 * @param loclUpdDt
	 */
	public void setLoclUpdDt(String loclUpdDt) {
		this.loclUpdDt = loclUpdDt;
	}
	
	/**
	 * Column Info
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
	}
	
	
	/**
	 * Column Info
	 * @param agmtDocNo
	 */
	public void setAgmtDocNo(String agmtDocNo) {
		this.agmtDocNo = agmtDocNo;
	}
	
	/**
	 * Column Info
	 * @param agmtDocDesc
	 */
	public void setAgmtDocDesc(String agmtDocDesc) {
		this.agmtDocDesc = agmtDocDesc;
	}
	
	/**
	 * Column Info
	 * @param agmtDocEffFmDt
	 */
	public void setAgmtDocEffFmDt(String agmtDocEffFmDt) {
		this.agmtDocEffFmDt = agmtDocEffFmDt;
	}
	
	/**
	 * Column Info
	 * @param agmtDocEffToDt
	 */
	public void setAgmtDocEffToDt(String agmtDocEffToDt) {
		this.agmtDocEffToDt = agmtDocEffToDt;
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
		setTmlAgmtStsCd(JSPUtil.getParameter(request, prefix + "tml_agmt_sts_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAgmtVerN2ndNo(JSPUtil.getParameter(request, prefix + "agmt_ver_n2nd_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTmlAgmtVerNo(JSPUtil.getParameter(request, prefix + "tml_agmt_ver_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setAgmtCfmUsrNm(JSPUtil.getParameter(request, prefix + "agmt_cfm_usr_nm", ""));
		setAgmtRmk(JSPUtil.getParameter(request, prefix + "agmt_rmk", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTmlAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "tml_agmt_ofc_cty_cd", ""));
		setAgmtCfmUsrId(JSPUtil.getParameter(request, prefix + "agmt_cfm_usr_id", ""));
		setAgmtVerN1stNo(JSPUtil.getParameter(request, prefix + "agmt_ver_n1st_no", ""));
		setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setAgmtCfmDt(JSPUtil.getParameter(request, prefix + "agmt_cfm_dt", ""));
		setAgmtCfmFlg(JSPUtil.getParameter(request, prefix + "agmt_cfm_flg", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setTmlAgmtSeq(JSPUtil.getParameter(request, prefix + "tml_agmt_seq", ""));
		setAutoXtdFlg(JSPUtil.getParameter(request, prefix + "auto_xtd_flg", ""));
		setAgmtAproDt(JSPUtil.getParameter(request, prefix + "agmt_apro_dt", ""));
		setLoclUpdDt(JSPUtil.getParameter(request, prefix + "locl_upd_dt", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setAgmtDocNo(JSPUtil.getParameter(request, prefix + "agmt_doc_no", ""));
		setAgmtDocDesc(JSPUtil.getParameter(request, prefix + "agmt_doc_desc", ""));
		setAgmtDocEffFmDt(JSPUtil.getParameter(request, prefix + "agmt_doc_eff_fm_dt", ""));
		setAgmtDocEffToDt(JSPUtil.getParameter(request, prefix + "agmt_doc_eff_to_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesTmlAgmtHdrVO[]
	 */
	public TesTmlAgmtHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesTmlAgmtHdrVO[]
	 */
	public TesTmlAgmtHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesTmlAgmtHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tmlAgmtStsCd = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_sts_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] agmtVerN2ndNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_n2nd_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tmlAgmtVerNo = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_ver_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] agmtCfmUsrNm = (JSPUtil.getParameter(request, prefix	+ "agmt_cfm_usr_nm", length));
			String[] agmtRmk = (JSPUtil.getParameter(request, prefix	+ "agmt_rmk", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] tmlAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_ofc_cty_cd", length));
			String[] agmtCfmUsrId = (JSPUtil.getParameter(request, prefix	+ "agmt_cfm_usr_id", length));
			String[] agmtVerN1stNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_n1st_no", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] agmtCfmDt = (JSPUtil.getParameter(request, prefix	+ "agmt_cfm_dt", length));
			String[] agmtCfmFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_cfm_flg", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] tmlAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_seq", length));
			String[] autoXtdFlg = (JSPUtil.getParameter(request, prefix	+ "auto_xtd_flg", length));
			String[] agmtAproDt = (JSPUtil.getParameter(request, prefix	+ "agmt_apro_dt", length));
			String[] loclUpdDt = (JSPUtil.getParameter(request, prefix	+ "locl_upd_dt", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] agmtDocNo = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_no", length));
			String[] agmtDocDesc = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_desc", length));
			String[] agmtDocEffFmDt = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_eff_fm_dt", length));
			String[] agmtDocEffToDt = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_eff_to_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesTmlAgmtHdrVO();
				if (tmlAgmtStsCd[i] != null)
					model.setTmlAgmtStsCd(tmlAgmtStsCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (agmtVerN2ndNo[i] != null)
					model.setAgmtVerN2ndNo(agmtVerN2ndNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tmlAgmtVerNo[i] != null)
					model.setTmlAgmtVerNo(tmlAgmtVerNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (agmtCfmUsrNm[i] != null)
					model.setAgmtCfmUsrNm(agmtCfmUsrNm[i]);
				if (agmtRmk[i] != null)
					model.setAgmtRmk(agmtRmk[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (tmlAgmtOfcCtyCd[i] != null)
					model.setTmlAgmtOfcCtyCd(tmlAgmtOfcCtyCd[i]);
				if (agmtCfmUsrId[i] != null)
					model.setAgmtCfmUsrId(agmtCfmUsrId[i]);
				if (agmtVerN1stNo[i] != null)
					model.setAgmtVerN1stNo(agmtVerN1stNo[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (agmtCfmDt[i] != null)
					model.setAgmtCfmDt(agmtCfmDt[i]);
				if (agmtCfmFlg[i] != null)
					model.setAgmtCfmFlg(agmtCfmFlg[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (tmlAgmtSeq[i] != null)
					model.setTmlAgmtSeq(tmlAgmtSeq[i]);
				if (autoXtdFlg[i] != null)
					model.setAutoXtdFlg(autoXtdFlg[i]);
				if (agmtAproDt[i] != null)
					model.setAgmtAproDt(agmtAproDt[i]);
				if (loclUpdDt[i] != null)
					model.setLoclUpdDt(loclUpdDt[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (agmtDocNo[i] != null) 
					model.setAgmtDocNo(agmtDocNo[i]);
				if (agmtDocDesc[i] != null)
					model.setAgmtDocDesc(agmtDocDesc[i]);
				if (agmtDocEffFmDt[i] != null)
					model.setAgmtDocEffFmDt(agmtDocEffFmDt[i]);
				if (agmtDocEffToDt[i] != null)
					model.setAgmtDocEffToDt(agmtDocEffToDt[i]);
			
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesTmlAgmtHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesTmlAgmtHdrVO[]
	 */
	public TesTmlAgmtHdrVO[] getTesTmlAgmtHdrVOs(){
		TesTmlAgmtHdrVO[] vos = (TesTmlAgmtHdrVO[])models.toArray(new TesTmlAgmtHdrVO[models.size()]);
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
		this.tmlAgmtStsCd = this.tmlAgmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerN2ndNo = this.agmtVerN2ndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtVerNo = this.tmlAgmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCfmUsrNm = this.agmtCfmUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRmk = this.agmtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtOfcCtyCd = this.tmlAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCfmUsrId = this.agmtCfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerN1stNo = this.agmtVerN1stNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCfmDt = this.agmtCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCfmFlg = this.agmtCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtSeq = this.tmlAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoXtdFlg = this.autoXtdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtAproDt = this.agmtAproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclUpdDt = this.loclUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocNo = this.agmtDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocDesc = this.agmtDocDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocEffFmDt = this.agmtDocEffFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocEffToDt = this.agmtDocEffToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
