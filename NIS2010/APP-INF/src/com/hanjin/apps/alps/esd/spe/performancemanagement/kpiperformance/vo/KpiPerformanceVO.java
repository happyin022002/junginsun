/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KpiPerformanceVO.java
*@FileTitle : KpiPerformanceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.18 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.vo;

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

public class KpiPerformanceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KpiPerformanceVO> models = new ArrayList<KpiPerformanceVO>();
	
	/* Column Info */
	private String sepRto = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String score = null;
	/* Column Info */
	private String novRto = null;
	/* Column Info */
	private String spSeq = null;
	/* Column Info */
	private String febRto = null;
	/* Column Info */
	private String kpiTgtRto = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String egNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String modifiyYn = null;
	/* Column Info */
	private String octRto = null;
	/* Column Info */
	private String evSvcCateCd = null;
	/* Column Info */
	private String sEvSvcCateCd = null;
	/* Column Info */
	private String decRto = null;
	/* Column Info */
	private String junRto = null;
	/* Column Info */
	private String kpiWgtRto = null;
	/* Column Info */
	private String evYr = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String evSvcCateNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String spKpiTpCd = null;
	/* Column Info */
	private String spKpiNm = null;
	/* Column Info */
	private String sSpSeq = null;
	/* Column Info */
	private String spKpiTpNm = null;
	/* Column Info */
	private String augRto = null;
	/* Column Info */
	private String mayRto = null;
	/* Column Info */
	private String aprRto = null;
	/* Column Info */
	private String janRto = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sEvYr = null;
	/* Column Info */
	private String sEgOfcCd = null;
	/* Column Info */
	private String marRto = null;
	/* Column Info */
	private String rsltScreRto = null;
	/* Column Info */
	private String spKpiId = null;
	/* Column Info */
	private String spNm = null;
	/* Column Info */
	private String julRto = null;
	/* Column Info */
	private String sEgRhqCd = null;
	/* Column Info */
	private String hasSaved = null;
	/* Column Info */
	private String egId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public KpiPerformanceVO() {}

	public KpiPerformanceVO(String ibflag, String pagerows, String sepRto, String score, String creDt, String novRto, String spSeq, String kpiTgtRto, String febRto, String egNm, String octRto, String evSvcCateCd, String sEvSvcCateCd, String decRto, String junRto, String kpiWgtRto, String evYr, String updUsrId, String evSvcCateNm, String updDt, String spKpiTpCd, String spKpiNm, String sSpSeq, String spKpiTpNm, String augRto, String mayRto, String sEgOfcCd, String sEvYr, String creUsrId, String janRto, String aprRto, String marRto, String spNm, String spKpiId, String sEgRhqCd, String julRto, String hasSaved, String egId, String modifiyYn, String rsltScreRto) {
		this.sepRto = sepRto;
		this.creDt = creDt;
		this.score = score;
		this.novRto = novRto;
		this.spSeq = spSeq;
		this.febRto = febRto;
		this.kpiTgtRto = kpiTgtRto;
		this.pagerows = pagerows;
		this.egNm = egNm;
		this.ibflag = ibflag;
		this.modifiyYn = modifiyYn;
		this.octRto = octRto;
		this.evSvcCateCd = evSvcCateCd;
		this.sEvSvcCateCd = sEvSvcCateCd;
		this.decRto = decRto;
		this.junRto = junRto;
		this.kpiWgtRto = kpiWgtRto;
		this.evYr = evYr;
		this.updUsrId = updUsrId;
		this.evSvcCateNm = evSvcCateNm;
		this.updDt = updDt;
		this.spKpiTpCd = spKpiTpCd;
		this.spKpiNm = spKpiNm;
		this.sSpSeq = sSpSeq;
		this.spKpiTpNm = spKpiTpNm;
		this.augRto = augRto;
		this.mayRto = mayRto;
		this.aprRto = aprRto;
		this.janRto = janRto;
		this.creUsrId = creUsrId;
		this.sEvYr = sEvYr;
		this.sEgOfcCd = sEgOfcCd;
		this.marRto = marRto;
		this.rsltScreRto = rsltScreRto;
		this.spKpiId = spKpiId;
		this.spNm = spNm;
		this.julRto = julRto;
		this.sEgRhqCd = sEgRhqCd;
		this.hasSaved = hasSaved;
		this.egId = egId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sep_rto", getSepRto());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("score", getScore());
		this.hashColumns.put("nov_rto", getNovRto());
		this.hashColumns.put("sp_seq", getSpSeq());
		this.hashColumns.put("feb_rto", getFebRto());
		this.hashColumns.put("kpi_tgt_rto", getKpiTgtRto());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eg_nm", getEgNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("modifiy_yn", getModifiyYn());
		this.hashColumns.put("oct_rto", getOctRto());
		this.hashColumns.put("ev_svc_cate_cd", getEvSvcCateCd());
		this.hashColumns.put("s_ev_svc_cate_cd", getSEvSvcCateCd());
		this.hashColumns.put("dec_rto", getDecRto());
		this.hashColumns.put("jun_rto", getJunRto());
		this.hashColumns.put("kpi_wgt_rto", getKpiWgtRto());
		this.hashColumns.put("ev_yr", getEvYr());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ev_svc_cate_nm", getEvSvcCateNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sp_kpi_tp_cd", getSpKpiTpCd());
		this.hashColumns.put("sp_kpi_nm", getSpKpiNm());
		this.hashColumns.put("s_sp_seq", getSSpSeq());
		this.hashColumns.put("sp_kpi_tp_nm", getSpKpiTpNm());
		this.hashColumns.put("aug_rto", getAugRto());
		this.hashColumns.put("may_rto", getMayRto());
		this.hashColumns.put("apr_rto", getAprRto());
		this.hashColumns.put("jan_rto", getJanRto());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("s_ev_yr", getSEvYr());
		this.hashColumns.put("s_eg_ofc_cd", getSEgOfcCd());
		this.hashColumns.put("mar_rto", getMarRto());
		this.hashColumns.put("rslt_scre_rto", getRsltScreRto());
		this.hashColumns.put("sp_kpi_id", getSpKpiId());
		this.hashColumns.put("sp_nm", getSpNm());
		this.hashColumns.put("jul_rto", getJulRto());
		this.hashColumns.put("s_eg_rhq_cd", getSEgRhqCd());
		this.hashColumns.put("has_saved", getHasSaved());
		this.hashColumns.put("eg_id", getEgId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sep_rto", "sepRto");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("score", "score");
		this.hashFields.put("nov_rto", "novRto");
		this.hashFields.put("sp_seq", "spSeq");
		this.hashFields.put("feb_rto", "febRto");
		this.hashFields.put("kpi_tgt_rto", "kpiTgtRto");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eg_nm", "egNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("modifiy_yn", "modifiyYn");
		this.hashFields.put("oct_rto", "octRto");
		this.hashFields.put("ev_svc_cate_cd", "evSvcCateCd");
		this.hashFields.put("s_ev_svc_cate_cd", "sEvSvcCateCd");
		this.hashFields.put("dec_rto", "decRto");
		this.hashFields.put("jun_rto", "junRto");
		this.hashFields.put("kpi_wgt_rto", "kpiWgtRto");
		this.hashFields.put("ev_yr", "evYr");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ev_svc_cate_nm", "evSvcCateNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sp_kpi_tp_cd", "spKpiTpCd");
		this.hashFields.put("sp_kpi_nm", "spKpiNm");
		this.hashFields.put("s_sp_seq", "sSpSeq");
		this.hashFields.put("sp_kpi_tp_nm", "spKpiTpNm");
		this.hashFields.put("aug_rto", "augRto");
		this.hashFields.put("may_rto", "mayRto");
		this.hashFields.put("apr_rto", "aprRto");
		this.hashFields.put("jan_rto", "janRto");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("s_ev_yr", "sEvYr");
		this.hashFields.put("s_eg_ofc_cd", "sEgOfcCd");
		this.hashFields.put("mar_rto", "marRto");
		this.hashFields.put("rslt_scre_rto", "rsltScreRto");
		this.hashFields.put("sp_kpi_id", "spKpiId");
		this.hashFields.put("sp_nm", "spNm");
		this.hashFields.put("jul_rto", "julRto");
		this.hashFields.put("s_eg_rhq_cd", "sEgRhqCd");
		this.hashFields.put("has_saved", "hasSaved");
		this.hashFields.put("eg_id", "egId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sepRto
	 */
	public String getSepRto() {
		return this.sepRto;
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
	 * @return score
	 */
	public String getScore() {
		return this.score;
	}
	
	/**
	 * Column Info
	 * @return novRto
	 */
	public String getNovRto() {
		return this.novRto;
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
	 * @return febRto
	 */
	public String getFebRto() {
		return this.febRto;
	}
	
	/**
	 * Column Info
	 * @return kpiTgtRto
	 */
	public String getKpiTgtRto() {
		return this.kpiTgtRto;
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
	 * @return modifiyYn
	 */
	public String getModifiyYn() {
		return this.modifiyYn;
	}
	
	/**
	 * Column Info
	 * @return octRto
	 */
	public String getOctRto() {
		return this.octRto;
	}
	
	/**
	 * Column Info
	 * @return evSvcCateCd
	 */
	public String getEvSvcCateCd() {
		return this.evSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return sEvSvcCateCd
	 */
	public String getSEvSvcCateCd() {
		return this.sEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return decRto
	 */
	public String getDecRto() {
		return this.decRto;
	}
	
	/**
	 * Column Info
	 * @return junRto
	 */
	public String getJunRto() {
		return this.junRto;
	}
	
	/**
	 * Column Info
	 * @return kpiWgtRto
	 */
	public String getKpiWgtRto() {
		return this.kpiWgtRto;
	}
	
	/**
	 * Column Info
	 * @return evYr
	 */
	public String getEvYr() {
		return this.evYr;
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
	 * @return evSvcCateNm
	 */
	public String getEvSvcCateNm() {
		return this.evSvcCateNm;
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
	 * @return spKpiTpCd
	 */
	public String getSpKpiTpCd() {
		return this.spKpiTpCd;
	}
	
	/**
	 * Column Info
	 * @return spKpiNm
	 */
	public String getSpKpiNm() {
		return this.spKpiNm;
	}
	
	/**
	 * Column Info
	 * @return sSpSeq
	 */
	public String getSSpSeq() {
		return this.sSpSeq;
	}
	
	/**
	 * Column Info
	 * @return spKpiTpNm
	 */
	public String getSpKpiTpNm() {
		return this.spKpiTpNm;
	}
	
	/**
	 * Column Info
	 * @return augRto
	 */
	public String getAugRto() {
		return this.augRto;
	}
	
	/**
	 * Column Info
	 * @return mayRto
	 */
	public String getMayRto() {
		return this.mayRto;
	}
	
	/**
	 * Column Info
	 * @return aprRto
	 */
	public String getAprRto() {
		return this.aprRto;
	}
	
	/**
	 * Column Info
	 * @return janRto
	 */
	public String getJanRto() {
		return this.janRto;
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
	 * @return sEvYr
	 */
	public String getSEvYr() {
		return this.sEvYr;
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
	 * @return marRto
	 */
	public String getMarRto() {
		return this.marRto;
	}
	
	/**
	 * Column Info
	 * @return rsltScreRto
	 */
	public String getRsltScreRto() {
		return this.rsltScreRto;
	}
	
	/**
	 * Column Info
	 * @return spKpiId
	 */
	public String getSpKpiId() {
		return this.spKpiId;
	}
	
	/**
	 * Column Info
	 * @return spNm
	 */
	public String getSpNm() {
		return this.spNm;
	}
	
	/**
	 * Column Info
	 * @return julRto
	 */
	public String getJulRto() {
		return this.julRto;
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
	 * @return hasSaved
	 */
	public String getHasSaved() {
		return this.hasSaved;
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
	 * @param sepRto
	 */
	public void setSepRto(String sepRto) {
		this.sepRto = sepRto;
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
	 * @param score
	 */
	public void setScore(String score) {
		this.score = score;
	}
	
	/**
	 * Column Info
	 * @param novRto
	 */
	public void setNovRto(String novRto) {
		this.novRto = novRto;
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
	 * @param febRto
	 */
	public void setFebRto(String febRto) {
		this.febRto = febRto;
	}
	
	/**
	 * Column Info
	 * @param kpiTgtRto
	 */
	public void setKpiTgtRto(String kpiTgtRto) {
		this.kpiTgtRto = kpiTgtRto;
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
	 * @param modifiyYn
	 */
	public void setModifiyYn(String modifiyYn) {
		this.modifiyYn = modifiyYn;
	}
	
	/**
	 * Column Info
	 * @param octRto
	 */
	public void setOctRto(String octRto) {
		this.octRto = octRto;
	}
	
	/**
	 * Column Info
	 * @param evSvcCateCd
	 */
	public void setEvSvcCateCd(String evSvcCateCd) {
		this.evSvcCateCd = evSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param sEvSvcCateCd
	 */
	public void setSEvSvcCateCd(String sEvSvcCateCd) {
		this.sEvSvcCateCd = sEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param decRto
	 */
	public void setDecRto(String decRto) {
		this.decRto = decRto;
	}
	
	/**
	 * Column Info
	 * @param junRto
	 */
	public void setJunRto(String junRto) {
		this.junRto = junRto;
	}
	
	/**
	 * Column Info
	 * @param kpiWgtRto
	 */
	public void setKpiWgtRto(String kpiWgtRto) {
		this.kpiWgtRto = kpiWgtRto;
	}
	
	/**
	 * Column Info
	 * @param evYr
	 */
	public void setEvYr(String evYr) {
		this.evYr = evYr;
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
	 * @param evSvcCateNm
	 */
	public void setEvSvcCateNm(String evSvcCateNm) {
		this.evSvcCateNm = evSvcCateNm;
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
	 * @param spKpiTpCd
	 */
	public void setSpKpiTpCd(String spKpiTpCd) {
		this.spKpiTpCd = spKpiTpCd;
	}
	
	/**
	 * Column Info
	 * @param spKpiNm
	 */
	public void setSpKpiNm(String spKpiNm) {
		this.spKpiNm = spKpiNm;
	}
	
	/**
	 * Column Info
	 * @param sSpSeq
	 */
	public void setSSpSeq(String sSpSeq) {
		this.sSpSeq = sSpSeq;
	}
	
	/**
	 * Column Info
	 * @param spKpiTpNm
	 */
	public void setSpKpiTpNm(String spKpiTpNm) {
		this.spKpiTpNm = spKpiTpNm;
	}
	
	/**
	 * Column Info
	 * @param augRto
	 */
	public void setAugRto(String augRto) {
		this.augRto = augRto;
	}
	
	/**
	 * Column Info
	 * @param mayRto
	 */
	public void setMayRto(String mayRto) {
		this.mayRto = mayRto;
	}
	
	/**
	 * Column Info
	 * @param aprRto
	 */
	public void setAprRto(String aprRto) {
		this.aprRto = aprRto;
	}
	
	/**
	 * Column Info
	 * @param janRto
	 */
	public void setJanRto(String janRto) {
		this.janRto = janRto;
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
	 * @param sEvYr
	 */
	public void setSEvYr(String sEvYr) {
		this.sEvYr = sEvYr;
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
	 * @param marRto
	 */
	public void setMarRto(String marRto) {
		this.marRto = marRto;
	}
	
	/**
	 * Column Info
	 * @param rsltScreRto
	 */
	public void setRsltScreRto(String rsltScreRto) {
		this.rsltScreRto = rsltScreRto;
	}
	
	/**
	 * Column Info
	 * @param spKpiId
	 */
	public void setSpKpiId(String spKpiId) {
		this.spKpiId = spKpiId;
	}
	
	/**
	 * Column Info
	 * @param spNm
	 */
	public void setSpNm(String spNm) {
		this.spNm = spNm;
	}
	
	/**
	 * Column Info
	 * @param julRto
	 */
	public void setJulRto(String julRto) {
		this.julRto = julRto;
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
	 * @param hasSaved
	 */
	public void setHasSaved(String hasSaved) {
		this.hasSaved = hasSaved;
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
		setSepRto(JSPUtil.getParameter(request, prefix + "sep_rto", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setScore(JSPUtil.getParameter(request, prefix + "score", ""));
		setNovRto(JSPUtil.getParameter(request, prefix + "nov_rto", ""));
		setSpSeq(JSPUtil.getParameter(request, prefix + "sp_seq", ""));
		setFebRto(JSPUtil.getParameter(request, prefix + "feb_rto", ""));
		setKpiTgtRto(JSPUtil.getParameter(request, prefix + "kpi_tgt_rto", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEgNm(JSPUtil.getParameter(request, prefix + "eg_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setModifiyYn(JSPUtil.getParameter(request, prefix + "modifiy_yn", ""));
		setOctRto(JSPUtil.getParameter(request, prefix + "oct_rto", ""));
		setEvSvcCateCd(JSPUtil.getParameter(request, prefix + "ev_svc_cate_cd", ""));
		setSEvSvcCateCd(JSPUtil.getParameter(request, prefix + "s_ev_svc_cate_cd", ""));
		setDecRto(JSPUtil.getParameter(request, prefix + "dec_rto", ""));
		setJunRto(JSPUtil.getParameter(request, prefix + "jun_rto", ""));
		setKpiWgtRto(JSPUtil.getParameter(request, prefix + "kpi_wgt_rto", ""));
		setEvYr(JSPUtil.getParameter(request, prefix + "ev_yr", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEvSvcCateNm(JSPUtil.getParameter(request, prefix + "ev_svc_cate_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSpKpiTpCd(JSPUtil.getParameter(request, prefix + "sp_kpi_tp_cd", ""));
		setSpKpiNm(JSPUtil.getParameter(request, prefix + "sp_kpi_nm", ""));
		setSSpSeq(JSPUtil.getParameter(request, prefix + "s_sp_seq", ""));
		setSpKpiTpNm(JSPUtil.getParameter(request, prefix + "sp_kpi_tp_nm", ""));
		setAugRto(JSPUtil.getParameter(request, prefix + "aug_rto", ""));
		setMayRto(JSPUtil.getParameter(request, prefix + "may_rto", ""));
		setAprRto(JSPUtil.getParameter(request, prefix + "apr_rto", ""));
		setJanRto(JSPUtil.getParameter(request, prefix + "jan_rto", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSEvYr(JSPUtil.getParameter(request, prefix + "s_ev_yr", ""));
		setSEgOfcCd(JSPUtil.getParameter(request, prefix + "s_eg_ofc_cd", ""));
		setMarRto(JSPUtil.getParameter(request, prefix + "mar_rto", ""));
		setRsltScreRto(JSPUtil.getParameter(request, prefix + "rslt_scre_rto", ""));
		setSpKpiId(JSPUtil.getParameter(request, prefix + "sp_kpi_id", ""));
		setSpNm(JSPUtil.getParameter(request, prefix + "sp_nm", ""));
		setJulRto(JSPUtil.getParameter(request, prefix + "jul_rto", ""));
		setSEgRhqCd(JSPUtil.getParameter(request, prefix + "s_eg_rhq_cd", ""));
		setHasSaved(JSPUtil.getParameter(request, prefix + "has_saved", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KpiPerformanceVO[]
	 */
	public KpiPerformanceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KpiPerformanceVO[]
	 */
	public KpiPerformanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KpiPerformanceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sepRto = (JSPUtil.getParameter(request, prefix	+ "sep_rto", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] score = (JSPUtil.getParameter(request, prefix	+ "score", length));
			String[] novRto = (JSPUtil.getParameter(request, prefix	+ "nov_rto", length));
			String[] spSeq = (JSPUtil.getParameter(request, prefix	+ "sp_seq", length));
			String[] febRto = (JSPUtil.getParameter(request, prefix	+ "feb_rto", length));
			String[] kpiTgtRto = (JSPUtil.getParameter(request, prefix	+ "kpi_tgt_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] egNm = (JSPUtil.getParameter(request, prefix	+ "eg_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] modifiyYn = (JSPUtil.getParameter(request, prefix	+ "modifiy_yn", length));
			String[] octRto = (JSPUtil.getParameter(request, prefix	+ "oct_rto", length));
			String[] evSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "ev_svc_cate_cd", length));
			String[] sEvSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "s_ev_svc_cate_cd", length));
			String[] decRto = (JSPUtil.getParameter(request, prefix	+ "dec_rto", length));
			String[] junRto = (JSPUtil.getParameter(request, prefix	+ "jun_rto", length));
			String[] kpiWgtRto = (JSPUtil.getParameter(request, prefix	+ "kpi_wgt_rto", length));
			String[] evYr = (JSPUtil.getParameter(request, prefix	+ "ev_yr", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] evSvcCateNm = (JSPUtil.getParameter(request, prefix	+ "ev_svc_cate_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] spKpiTpCd = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_tp_cd", length));
			String[] spKpiNm = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_nm", length));
			String[] sSpSeq = (JSPUtil.getParameter(request, prefix	+ "s_sp_seq", length));
			String[] spKpiTpNm = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_tp_nm", length));
			String[] augRto = (JSPUtil.getParameter(request, prefix	+ "aug_rto", length));
			String[] mayRto = (JSPUtil.getParameter(request, prefix	+ "may_rto", length));
			String[] aprRto = (JSPUtil.getParameter(request, prefix	+ "apr_rto", length));
			String[] janRto = (JSPUtil.getParameter(request, prefix	+ "jan_rto", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sEvYr = (JSPUtil.getParameter(request, prefix	+ "s_ev_yr", length));
			String[] sEgOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_ofc_cd", length));
			String[] marRto = (JSPUtil.getParameter(request, prefix	+ "mar_rto", length));
			String[] rsltScreRto = (JSPUtil.getParameter(request, prefix	+ "rslt_scre_rto", length));
			String[] spKpiId = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_id", length));
			String[] spNm = (JSPUtil.getParameter(request, prefix	+ "sp_nm", length));
			String[] julRto = (JSPUtil.getParameter(request, prefix	+ "jul_rto", length));
			String[] sEgRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_rhq_cd", length));
			String[] hasSaved = (JSPUtil.getParameter(request, prefix	+ "has_saved", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new KpiPerformanceVO();
				if (sepRto[i] != null)
					model.setSepRto(sepRto[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (score[i] != null)
					model.setScore(score[i]);
				if (novRto[i] != null)
					model.setNovRto(novRto[i]);
				if (spSeq[i] != null)
					model.setSpSeq(spSeq[i]);
				if (febRto[i] != null)
					model.setFebRto(febRto[i]);
				if (kpiTgtRto[i] != null)
					model.setKpiTgtRto(kpiTgtRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (egNm[i] != null)
					model.setEgNm(egNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (modifiyYn[i] != null)
					model.setModifiyYn(modifiyYn[i]);
				if (octRto[i] != null)
					model.setOctRto(octRto[i]);
				if (evSvcCateCd[i] != null)
					model.setEvSvcCateCd(evSvcCateCd[i]);
				if (sEvSvcCateCd[i] != null)
					model.setSEvSvcCateCd(sEvSvcCateCd[i]);
				if (decRto[i] != null)
					model.setDecRto(decRto[i]);
				if (junRto[i] != null)
					model.setJunRto(junRto[i]);
				if (kpiWgtRto[i] != null)
					model.setKpiWgtRto(kpiWgtRto[i]);
				if (evYr[i] != null)
					model.setEvYr(evYr[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (evSvcCateNm[i] != null)
					model.setEvSvcCateNm(evSvcCateNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (spKpiTpCd[i] != null)
					model.setSpKpiTpCd(spKpiTpCd[i]);
				if (spKpiNm[i] != null)
					model.setSpKpiNm(spKpiNm[i]);
				if (sSpSeq[i] != null)
					model.setSSpSeq(sSpSeq[i]);
				if (spKpiTpNm[i] != null)
					model.setSpKpiTpNm(spKpiTpNm[i]);
				if (augRto[i] != null)
					model.setAugRto(augRto[i]);
				if (mayRto[i] != null)
					model.setMayRto(mayRto[i]);
				if (aprRto[i] != null)
					model.setAprRto(aprRto[i]);
				if (janRto[i] != null)
					model.setJanRto(janRto[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sEvYr[i] != null)
					model.setSEvYr(sEvYr[i]);
				if (sEgOfcCd[i] != null)
					model.setSEgOfcCd(sEgOfcCd[i]);
				if (marRto[i] != null)
					model.setMarRto(marRto[i]);
				if (rsltScreRto[i] != null)
					model.setRsltScreRto(rsltScreRto[i]);
				if (spKpiId[i] != null)
					model.setSpKpiId(spKpiId[i]);
				if (spNm[i] != null)
					model.setSpNm(spNm[i]);
				if (julRto[i] != null)
					model.setJulRto(julRto[i]);
				if (sEgRhqCd[i] != null)
					model.setSEgRhqCd(sEgRhqCd[i]);
				if (hasSaved[i] != null)
					model.setHasSaved(hasSaved[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKpiPerformanceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KpiPerformanceVO[]
	 */
	public KpiPerformanceVO[] getKpiPerformanceVOs(){
		KpiPerformanceVO[] vos = (KpiPerformanceVO[])models.toArray(new KpiPerformanceVO[models.size()]);
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
		this.sepRto = this.sepRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.score = this.score .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.novRto = this.novRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spSeq = this.spSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.febRto = this.febRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiTgtRto = this.kpiTgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egNm = this.egNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modifiyYn = this.modifiyYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.octRto = this.octRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evSvcCateCd = this.evSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvSvcCateCd = this.sEvSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.decRto = this.decRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.junRto = this.junRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiWgtRto = this.kpiWgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evYr = this.evYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evSvcCateNm = this.evSvcCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spKpiTpCd = this.spKpiTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spKpiNm = this.spKpiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSpSeq = this.sSpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spKpiTpNm = this.spKpiTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.augRto = this.augRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mayRto = this.mayRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aprRto = this.aprRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.janRto = this.janRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvYr = this.sEvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgOfcCd = this.sEgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.marRto = this.marRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltScreRto = this.rsltScreRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spKpiId = this.spKpiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spNm = this.spNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.julRto = this.julRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgRhqCd = this.sEgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hasSaved = this.hasSaved .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
