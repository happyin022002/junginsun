/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchTerminalAgreeementSummaryListVO.java
*@FileTitle : SearchTerminalAgreeementSummaryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 이 용 호
*@LastVersion : 1.0
* 2014.10.30 이 용 호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo;

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
 * @author 이 용 호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTerminalAgreeementSummaryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTerminalAgreeementSummaryListVO> models = new ArrayList<SearchTerminalAgreeementSummaryListVO>();
	
	/* Column Info */
	private String agmtDocNo = null;
	/* Column Info */
	private String gwContYn = null;
	/* Column Info */
	private String agmtCfmFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String tmlAgmtStsCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String verNo = null;
	/* Column Info */
	private String tmlAgmtVerNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String agmtCfmUsrNm = null;
	/* Column Info */
	private String agmtDocDesc = null;
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
	private String agmtNo = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String agmtDocEffFmDt = null;
	/* Column Info */
	private String agmtCfmDt = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String tmlAgmtSeq = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String agmtDocEffToDt = null;
	/* Column Info */
	private String autoXtdFlg = null;
	/* Column Info */
	private String agmtAproDt = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String updUsrNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchTerminalAgreeementSummaryListVO() {}

	public SearchTerminalAgreeementSummaryListVO(String ibflag, String pagerows, String tmlAgmtOfcCtyCd, String tmlAgmtSeq, String agmtNo, String tmlAgmtVerNo, String verNo, String ydCd, String vndrSeq, String ydNm, String vndrLglEngNm, String effFmDt, String effToDt, String autoXtdFlg, String ctrtOfcCd, String currCd, String creDt, String creUsrId, String creUsrNm, String updDt, String updUsrId, String updUsrNm, String deltFlg, String tmlAgmtStsCd, String creOfcCd, String agmtAproDt, String agmtCfmDt, String agmtCfmFlg, String agmtCfmUsrNm, String agmtCfmUsrId, String gwContYn, String agmtDocNo, String agmtDocDesc, String agmtDocEffFmDt, String agmtDocEffToDt) {
		this.agmtDocNo = agmtDocNo;
		this.gwContYn = gwContYn;
		this.agmtCfmFlg = agmtCfmFlg;
		this.currCd = currCd;
		this.tmlAgmtStsCd = tmlAgmtStsCd;
		this.deltFlg = deltFlg;
		this.vndrLglEngNm = vndrLglEngNm;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.verNo = verNo;
		this.tmlAgmtVerNo = tmlAgmtVerNo;
		this.ibflag = ibflag;
		this.ctrtOfcCd = ctrtOfcCd;
		this.creOfcCd = creOfcCd;
		this.agmtCfmUsrNm = agmtCfmUsrNm;
		this.agmtDocDesc = agmtDocDesc;
		this.effFmDt = effFmDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.tmlAgmtOfcCtyCd = tmlAgmtOfcCtyCd;
		this.agmtCfmUsrId = agmtCfmUsrId;
		this.agmtNo = agmtNo;
		this.creUsrNm = creUsrNm;
		this.creUsrId = creUsrId;
		this.agmtDocEffFmDt = agmtDocEffFmDt;
		this.agmtCfmDt = agmtCfmDt;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.tmlAgmtSeq = tmlAgmtSeq;
		this.ydNm = ydNm;
		this.agmtDocEffToDt = agmtDocEffToDt;
		this.autoXtdFlg = autoXtdFlg;
		this.agmtAproDt = agmtAproDt;
		this.effToDt = effToDt;
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_doc_no", getAgmtDocNo());
		this.hashColumns.put("gw_cont_yn", getGwContYn());
		this.hashColumns.put("agmt_cfm_flg", getAgmtCfmFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("tml_agmt_sts_cd", getTmlAgmtStsCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ver_no", getVerNo());
		this.hashColumns.put("tml_agmt_ver_no", getTmlAgmtVerNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("agmt_cfm_usr_nm", getAgmtCfmUsrNm());
		this.hashColumns.put("agmt_doc_desc", getAgmtDocDesc());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tml_agmt_ofc_cty_cd", getTmlAgmtOfcCtyCd());
		this.hashColumns.put("agmt_cfm_usr_id", getAgmtCfmUsrId());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("agmt_doc_eff_fm_dt", getAgmtDocEffFmDt());
		this.hashColumns.put("agmt_cfm_dt", getAgmtCfmDt());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("tml_agmt_seq", getTmlAgmtSeq());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("agmt_doc_eff_to_dt", getAgmtDocEffToDt());
		this.hashColumns.put("auto_xtd_flg", getAutoXtdFlg());
		this.hashColumns.put("agmt_apro_dt", getAgmtAproDt());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_doc_no", "agmtDocNo");
		this.hashFields.put("gw_cont_yn", "gwContYn");
		this.hashFields.put("agmt_cfm_flg", "agmtCfmFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("tml_agmt_sts_cd", "tmlAgmtStsCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ver_no", "verNo");
		this.hashFields.put("tml_agmt_ver_no", "tmlAgmtVerNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("agmt_cfm_usr_nm", "agmtCfmUsrNm");
		this.hashFields.put("agmt_doc_desc", "agmtDocDesc");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tml_agmt_ofc_cty_cd", "tmlAgmtOfcCtyCd");
		this.hashFields.put("agmt_cfm_usr_id", "agmtCfmUsrId");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("agmt_doc_eff_fm_dt", "agmtDocEffFmDt");
		this.hashFields.put("agmt_cfm_dt", "agmtCfmDt");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("tml_agmt_seq", "tmlAgmtSeq");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("agmt_doc_eff_to_dt", "agmtDocEffToDt");
		this.hashFields.put("auto_xtd_flg", "autoXtdFlg");
		this.hashFields.put("agmt_apro_dt", "agmtAproDt");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		return this.hashFields;
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
	 * @return gwContYn
	 */
	public String getGwContYn() {
		return this.gwContYn;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return verNo
	 */
	public String getVerNo() {
		return this.verNo;
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
	 * @return agmtCfmUsrNm
	 */
	public String getAgmtCfmUsrNm() {
		return this.agmtCfmUsrNm;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
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
	 * @return agmtDocEffFmDt
	 */
	public String getAgmtDocEffFmDt() {
		return this.agmtDocEffFmDt;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
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
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
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
	 * @param gwContYn
	 */
	public void setGwContYn(String gwContYn) {
		this.gwContYn = gwContYn;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param verNo
	 */
	public void setVerNo(String verNo) {
		this.verNo = verNo;
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
	 * @param agmtCfmUsrNm
	 */
	public void setAgmtCfmUsrNm(String agmtCfmUsrNm) {
		this.agmtCfmUsrNm = agmtCfmUsrNm;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
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
	 * @param agmtDocEffFmDt
	 */
	public void setAgmtDocEffFmDt(String agmtDocEffFmDt) {
		this.agmtDocEffFmDt = agmtDocEffFmDt;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param agmtDocEffToDt
	 */
	public void setAgmtDocEffToDt(String agmtDocEffToDt) {
		this.agmtDocEffToDt = agmtDocEffToDt;
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
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
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
		setAgmtDocNo(JSPUtil.getParameter(request, prefix + "agmt_doc_no", ""));
		setGwContYn(JSPUtil.getParameter(request, prefix + "gw_cont_yn", ""));
		setAgmtCfmFlg(JSPUtil.getParameter(request, prefix + "agmt_cfm_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTmlAgmtStsCd(JSPUtil.getParameter(request, prefix + "tml_agmt_sts_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVerNo(JSPUtil.getParameter(request, prefix + "ver_no", ""));
		setTmlAgmtVerNo(JSPUtil.getParameter(request, prefix + "tml_agmt_ver_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setAgmtCfmUsrNm(JSPUtil.getParameter(request, prefix + "agmt_cfm_usr_nm", ""));
		setAgmtDocDesc(JSPUtil.getParameter(request, prefix + "agmt_doc_desc", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTmlAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "tml_agmt_ofc_cty_cd", ""));
		setAgmtCfmUsrId(JSPUtil.getParameter(request, prefix + "agmt_cfm_usr_id", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAgmtDocEffFmDt(JSPUtil.getParameter(request, prefix + "agmt_doc_eff_fm_dt", ""));
		setAgmtCfmDt(JSPUtil.getParameter(request, prefix + "agmt_cfm_dt", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setTmlAgmtSeq(JSPUtil.getParameter(request, prefix + "tml_agmt_seq", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setAgmtDocEffToDt(JSPUtil.getParameter(request, prefix + "agmt_doc_eff_to_dt", ""));
		setAutoXtdFlg(JSPUtil.getParameter(request, prefix + "auto_xtd_flg", ""));
		setAgmtAproDt(JSPUtil.getParameter(request, prefix + "agmt_apro_dt", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTerminalAgreeementSummaryListVO[]
	 */
	public SearchTerminalAgreeementSummaryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTerminalAgreeementSummaryListVO[]
	 */
	public SearchTerminalAgreeementSummaryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTerminalAgreeementSummaryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtDocNo = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_no", length));
			String[] gwContYn = (JSPUtil.getParameter(request, prefix	+ "gw_cont_yn", length));
			String[] agmtCfmFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_cfm_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] tmlAgmtStsCd = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_sts_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] verNo = (JSPUtil.getParameter(request, prefix	+ "ver_no", length));
			String[] tmlAgmtVerNo = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_ver_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] agmtCfmUsrNm = (JSPUtil.getParameter(request, prefix	+ "agmt_cfm_usr_nm", length));
			String[] agmtDocDesc = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_desc", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] tmlAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_ofc_cty_cd", length));
			String[] agmtCfmUsrId = (JSPUtil.getParameter(request, prefix	+ "agmt_cfm_usr_id", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] agmtDocEffFmDt = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_eff_fm_dt", length));
			String[] agmtCfmDt = (JSPUtil.getParameter(request, prefix	+ "agmt_cfm_dt", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] tmlAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_seq", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] agmtDocEffToDt = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_eff_to_dt", length));
			String[] autoXtdFlg = (JSPUtil.getParameter(request, prefix	+ "auto_xtd_flg", length));
			String[] agmtAproDt = (JSPUtil.getParameter(request, prefix	+ "agmt_apro_dt", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTerminalAgreeementSummaryListVO();
				if (agmtDocNo[i] != null)
					model.setAgmtDocNo(agmtDocNo[i]);
				if (gwContYn[i] != null)
					model.setGwContYn(gwContYn[i]);
				if (agmtCfmFlg[i] != null)
					model.setAgmtCfmFlg(agmtCfmFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (tmlAgmtStsCd[i] != null)
					model.setTmlAgmtStsCd(tmlAgmtStsCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (verNo[i] != null)
					model.setVerNo(verNo[i]);
				if (tmlAgmtVerNo[i] != null)
					model.setTmlAgmtVerNo(tmlAgmtVerNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (agmtCfmUsrNm[i] != null)
					model.setAgmtCfmUsrNm(agmtCfmUsrNm[i]);
				if (agmtDocDesc[i] != null)
					model.setAgmtDocDesc(agmtDocDesc[i]);
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
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (agmtDocEffFmDt[i] != null)
					model.setAgmtDocEffFmDt(agmtDocEffFmDt[i]);
				if (agmtCfmDt[i] != null)
					model.setAgmtCfmDt(agmtCfmDt[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (tmlAgmtSeq[i] != null)
					model.setTmlAgmtSeq(tmlAgmtSeq[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (agmtDocEffToDt[i] != null)
					model.setAgmtDocEffToDt(agmtDocEffToDt[i]);
				if (autoXtdFlg[i] != null)
					model.setAutoXtdFlg(autoXtdFlg[i]);
				if (agmtAproDt[i] != null)
					model.setAgmtAproDt(agmtAproDt[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTerminalAgreeementSummaryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTerminalAgreeementSummaryListVO[]
	 */
	public SearchTerminalAgreeementSummaryListVO[] getSearchTerminalAgreeementSummaryListVOs(){
		SearchTerminalAgreeementSummaryListVO[] vos = (SearchTerminalAgreeementSummaryListVO[])models.toArray(new SearchTerminalAgreeementSummaryListVO[models.size()]);
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
		this.agmtDocNo = this.agmtDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwContYn = this.gwContYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCfmFlg = this.agmtCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtStsCd = this.tmlAgmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verNo = this.verNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtVerNo = this.tmlAgmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCfmUsrNm = this.agmtCfmUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocDesc = this.agmtDocDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtOfcCtyCd = this.tmlAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCfmUsrId = this.agmtCfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocEffFmDt = this.agmtDocEffFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCfmDt = this.agmtCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtSeq = this.tmlAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocEffToDt = this.agmtDocEffToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoXtdFlg = this.autoXtdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtAproDt = this.agmtAproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
