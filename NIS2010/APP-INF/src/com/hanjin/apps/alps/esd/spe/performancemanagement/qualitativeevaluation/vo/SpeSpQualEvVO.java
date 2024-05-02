/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpeSpQualEvVO.java
*@FileTitle : SpeSpQualEvVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.02
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.04.02 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.vo;

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

public class SpeSpQualEvVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpeSpQualEvVO> models = new ArrayList<SpeSpQualEvVO>();
	
	/* Column Info */
	private String n1stEvGrdCtnt = null;
	/* Column Info */
	private String spName = null;
	/* Column Info */
	private String isflag = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String evWgtRsltRt = null;
	/* Column Info */
	private String gradeB = null;
	/* Column Info */
	private String gradeA = null;
	/* Column Info */
	private String sEgId = null;
	/* Column Info */
	private String spSeq = null;
	/* Column Info */
	private String sEgSvcCateCd = null;
	/* Column Info */
	private String gradeC = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String evSvcCateCd = null;
	/* Column Info */
	private String sEvSvcCateCd = null;
	/* Column Info */
	private String evYr = null;
	/* Column Info */
	private String n3rdEvGrdCtnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String evGrdChkCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sEvMon = null;
	/* Column Info */
	private String sSpSeq = null;
	/* Column Info */
	private String evMon = null;
	/* Column Info */
	private String evFctrCtnt = null;
	/* Column Info */
	private String evAreaCtnt = null;
	/* Column Info */
	private String evWgtRt = null;
	/* Column Info */
	private String sEvYr = null;
	/* Column Info */
	private String sSpKpiId = null;
	/* Column Info */
	private String sEgOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String spQualEvSeq = null;
	/* Column Info */
	private String qualEvSeq = null;
	/* Column Info */
	private String avgscore = null;
	/* Column Info */
	private String spKpiId = null;
	/* Column Info */
	private String sEgRhqCd = null;
	/* Column Info */
	private String egId = null;
	/* Column Info */
	private String n2ndEvGrdCtnt = null;
	/* Column Info */
	private String egSvcCateCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpeSpQualEvVO() {}

	public SpeSpQualEvVO(String ibflag, String pagerows, String n1stEvGrdCtnt, String n2ndEvGrdCtnt, String n3rdEvGrdCtnt, String gradeB, String evWgtRsltRt, String creDt, String gradeA, String spSeq, String spName, String gradeC, String evSvcCateCd, String evYr, String updUsrId, String evGrdChkCd, String updDt, String evMon, String evFctrCtnt, String evAreaCtnt, String evWgtRt, String creUsrId, String spQualEvSeq, String qualEvSeq, String spKpiId, String egId, String isflag, String egSvcCateCd, String sEgRhqCd, String sEgOfcCd, String sEgSvcCateCd, String sSpKpiId, String sEvYr, String sEvMon, String sSpSeq, String sEvSvcCateCd, String sEgId, String avgscore) {
		this.n1stEvGrdCtnt = n1stEvGrdCtnt;
		this.spName = spName;
		this.isflag = isflag;
		this.creDt = creDt;
		this.evWgtRsltRt = evWgtRsltRt;
		this.gradeB = gradeB;
		this.gradeA = gradeA;
		this.sEgId = sEgId;
		this.spSeq = spSeq;
		this.sEgSvcCateCd = sEgSvcCateCd;
		this.gradeC = gradeC;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.evSvcCateCd = evSvcCateCd;
		this.sEvSvcCateCd = sEvSvcCateCd;
		this.evYr = evYr;
		this.n3rdEvGrdCtnt = n3rdEvGrdCtnt;
		this.updUsrId = updUsrId;
		this.evGrdChkCd = evGrdChkCd;
		this.updDt = updDt;
		this.sEvMon = sEvMon;
		this.sSpSeq = sSpSeq;
		this.evMon = evMon;
		this.evFctrCtnt = evFctrCtnt;
		this.evAreaCtnt = evAreaCtnt;
		this.evWgtRt = evWgtRt;
		this.sEvYr = sEvYr;
		this.sSpKpiId = sSpKpiId;
		this.sEgOfcCd = sEgOfcCd;
		this.creUsrId = creUsrId;
		this.spQualEvSeq = spQualEvSeq;
		this.qualEvSeq = qualEvSeq;
		this.avgscore = avgscore;
		this.spKpiId = spKpiId;
		this.sEgRhqCd = sEgRhqCd;
		this.egId = egId;
		this.n2ndEvGrdCtnt = n2ndEvGrdCtnt;
		this.egSvcCateCd = egSvcCateCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n1st_ev_grd_ctnt", getN1stEvGrdCtnt());
		this.hashColumns.put("sp_name", getSpName());
		this.hashColumns.put("isflag", getIsflag());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ev_wgt_rslt_rt", getEvWgtRsltRt());
		this.hashColumns.put("grade_b", getGradeB());
		this.hashColumns.put("grade_a", getGradeA());
		this.hashColumns.put("s_eg_id", getSEgId());
		this.hashColumns.put("sp_seq", getSpSeq());
		this.hashColumns.put("s_eg_svc_cate_cd", getSEgSvcCateCd());
		this.hashColumns.put("grade_c", getGradeC());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ev_svc_cate_cd", getEvSvcCateCd());
		this.hashColumns.put("s_ev_svc_cate_cd", getSEvSvcCateCd());
		this.hashColumns.put("ev_yr", getEvYr());
		this.hashColumns.put("n3rd_ev_grd_ctnt", getN3rdEvGrdCtnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ev_grd_chk_cd", getEvGrdChkCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("s_ev_mon", getSEvMon());
		this.hashColumns.put("s_sp_seq", getSSpSeq());
		this.hashColumns.put("ev_mon", getEvMon());
		this.hashColumns.put("ev_fctr_ctnt", getEvFctrCtnt());
		this.hashColumns.put("ev_area_ctnt", getEvAreaCtnt());
		this.hashColumns.put("ev_wgt_rt", getEvWgtRt());
		this.hashColumns.put("s_ev_yr", getSEvYr());
		this.hashColumns.put("s_sp_kpi_id", getSSpKpiId());
		this.hashColumns.put("s_eg_ofc_cd", getSEgOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("sp_qual_ev_seq", getSpQualEvSeq());
		this.hashColumns.put("qual_ev_seq", getQualEvSeq());
		this.hashColumns.put("avgscore", getAvgscore());
		this.hashColumns.put("sp_kpi_id", getSpKpiId());
		this.hashColumns.put("s_eg_rhq_cd", getSEgRhqCd());
		this.hashColumns.put("eg_id", getEgId());
		this.hashColumns.put("n2nd_ev_grd_ctnt", getN2ndEvGrdCtnt());
		this.hashColumns.put("eg_svc_cate_cd", getEgSvcCateCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n1st_ev_grd_ctnt", "n1stEvGrdCtnt");
		this.hashFields.put("sp_name", "spName");
		this.hashFields.put("isflag", "isflag");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ev_wgt_rslt_rt", "evWgtRsltRt");
		this.hashFields.put("grade_b", "gradeB");
		this.hashFields.put("grade_a", "gradeA");
		this.hashFields.put("s_eg_id", "sEgId");
		this.hashFields.put("sp_seq", "spSeq");
		this.hashFields.put("s_eg_svc_cate_cd", "sEgSvcCateCd");
		this.hashFields.put("grade_c", "gradeC");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ev_svc_cate_cd", "evSvcCateCd");
		this.hashFields.put("s_ev_svc_cate_cd", "sEvSvcCateCd");
		this.hashFields.put("ev_yr", "evYr");
		this.hashFields.put("n3rd_ev_grd_ctnt", "n3rdEvGrdCtnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ev_grd_chk_cd", "evGrdChkCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("s_ev_mon", "sEvMon");
		this.hashFields.put("s_sp_seq", "sSpSeq");
		this.hashFields.put("ev_mon", "evMon");
		this.hashFields.put("ev_fctr_ctnt", "evFctrCtnt");
		this.hashFields.put("ev_area_ctnt", "evAreaCtnt");
		this.hashFields.put("ev_wgt_rt", "evWgtRt");
		this.hashFields.put("s_ev_yr", "sEvYr");
		this.hashFields.put("s_sp_kpi_id", "sSpKpiId");
		this.hashFields.put("s_eg_ofc_cd", "sEgOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("sp_qual_ev_seq", "spQualEvSeq");
		this.hashFields.put("qual_ev_seq", "qualEvSeq");
		this.hashFields.put("avgscore", "avgscore");
		this.hashFields.put("sp_kpi_id", "spKpiId");
		this.hashFields.put("s_eg_rhq_cd", "sEgRhqCd");
		this.hashFields.put("eg_id", "egId");
		this.hashFields.put("n2nd_ev_grd_ctnt", "n2ndEvGrdCtnt");
		this.hashFields.put("eg_svc_cate_cd", "egSvcCateCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n1stEvGrdCtnt
	 */
	public String getN1stEvGrdCtnt() {
		return this.n1stEvGrdCtnt;
	}
	
	/**
	 * Column Info
	 * @return spName
	 */
	public String getSpName() {
		return this.spName;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return evWgtRsltRt
	 */
	public String getEvWgtRsltRt() {
		return this.evWgtRsltRt;
	}
	
	/**
	 * Column Info
	 * @return gradeB
	 */
	public String getGradeB() {
		return this.gradeB;
	}
	
	/**
	 * Column Info
	 * @return gradeA
	 */
	public String getGradeA() {
		return this.gradeA;
	}
	
	/**
	 * Column Info
	 * @return sEgId
	 */
	public String getSEgId() {
		return this.sEgId;
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
	 * @return sEgSvcCateCd
	 */
	public String getSEgSvcCateCd() {
		return this.sEgSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return gradeC
	 */
	public String getGradeC() {
		return this.gradeC;
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
	 * @return evYr
	 */
	public String getEvYr() {
		return this.evYr;
	}
	
	/**
	 * Column Info
	 * @return n3rdEvGrdCtnt
	 */
	public String getN3rdEvGrdCtnt() {
		return this.n3rdEvGrdCtnt;
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
	 * @return evGrdChkCd
	 */
	public String getEvGrdChkCd() {
		return this.evGrdChkCd;
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
	 * @return sEvMon
	 */
	public String getSEvMon() {
		return this.sEvMon;
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
	 * @return evMon
	 */
	public String getEvMon() {
		return this.evMon;
	}
	
	/**
	 * Column Info
	 * @return evFctrCtnt
	 */
	public String getEvFctrCtnt() {
		return this.evFctrCtnt;
	}
	
	/**
	 * Column Info
	 * @return evAreaCtnt
	 */
	public String getEvAreaCtnt() {
		return this.evAreaCtnt;
	}
	
	/**
	 * Column Info
	 * @return evWgtRt
	 */
	public String getEvWgtRt() {
		return this.evWgtRt;
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
	 * @return sSpKpiId
	 */
	public String getSSpKpiId() {
		return this.sSpKpiId;
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
	 * @return spQualEvSeq
	 */
	public String getSpQualEvSeq() {
		return this.spQualEvSeq;
	}
	
	/**
	 * Column Info
	 * @return qualEvSeq
	 */
	public String getQualEvSeq() {
		return this.qualEvSeq;
	}
	
	/**
	 * Column Info
	 * @return avgscore
	 */
	public String getAvgscore() {
		return this.avgscore;
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
	 * @return sEgRhqCd
	 */
	public String getSEgRhqCd() {
		return this.sEgRhqCd;
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
	 * @return n2ndEvGrdCtnt
	 */
	public String getN2ndEvGrdCtnt() {
		return this.n2ndEvGrdCtnt;
	}
	
	/**
	 * Column Info
	 * @return egSvcCateCd
	 */
	public String getEgSvcCateCd() {
		return this.egSvcCateCd;
	}
	

	/**
	 * Column Info
	 * @param n1stEvGrdCtnt
	 */
	public void setN1stEvGrdCtnt(String n1stEvGrdCtnt) {
		this.n1stEvGrdCtnt = n1stEvGrdCtnt;
	}
	
	/**
	 * Column Info
	 * @param spName
	 */
	public void setSpName(String spName) {
		this.spName = spName;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param evWgtRsltRt
	 */
	public void setEvWgtRsltRt(String evWgtRsltRt) {
		this.evWgtRsltRt = evWgtRsltRt;
	}
	
	/**
	 * Column Info
	 * @param gradeB
	 */
	public void setGradeB(String gradeB) {
		this.gradeB = gradeB;
	}
	
	/**
	 * Column Info
	 * @param gradeA
	 */
	public void setGradeA(String gradeA) {
		this.gradeA = gradeA;
	}
	
	/**
	 * Column Info
	 * @param sEgId
	 */
	public void setSEgId(String sEgId) {
		this.sEgId = sEgId;
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
	 * @param sEgSvcCateCd
	 */
	public void setSEgSvcCateCd(String sEgSvcCateCd) {
		this.sEgSvcCateCd = sEgSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param gradeC
	 */
	public void setGradeC(String gradeC) {
		this.gradeC = gradeC;
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
	 * @param evYr
	 */
	public void setEvYr(String evYr) {
		this.evYr = evYr;
	}
	
	/**
	 * Column Info
	 * @param n3rdEvGrdCtnt
	 */
	public void setN3rdEvGrdCtnt(String n3rdEvGrdCtnt) {
		this.n3rdEvGrdCtnt = n3rdEvGrdCtnt;
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
	 * @param evGrdChkCd
	 */
	public void setEvGrdChkCd(String evGrdChkCd) {
		this.evGrdChkCd = evGrdChkCd;
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
	 * @param sEvMon
	 */
	public void setSEvMon(String sEvMon) {
		this.sEvMon = sEvMon;
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
	 * @param evMon
	 */
	public void setEvMon(String evMon) {
		this.evMon = evMon;
	}
	
	/**
	 * Column Info
	 * @param evFctrCtnt
	 */
	public void setEvFctrCtnt(String evFctrCtnt) {
		this.evFctrCtnt = evFctrCtnt;
	}
	
	/**
	 * Column Info
	 * @param evAreaCtnt
	 */
	public void setEvAreaCtnt(String evAreaCtnt) {
		this.evAreaCtnt = evAreaCtnt;
	}
	
	/**
	 * Column Info
	 * @param evWgtRt
	 */
	public void setEvWgtRt(String evWgtRt) {
		this.evWgtRt = evWgtRt;
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
	 * @param sSpKpiId
	 */
	public void setSSpKpiId(String sSpKpiId) {
		this.sSpKpiId = sSpKpiId;
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
	 * @param spQualEvSeq
	 */
	public void setSpQualEvSeq(String spQualEvSeq) {
		this.spQualEvSeq = spQualEvSeq;
	}
	
	/**
	 * Column Info
	 * @param qualEvSeq
	 */
	public void setQualEvSeq(String qualEvSeq) {
		this.qualEvSeq = qualEvSeq;
	}
	
	/**
	 * Column Info
	 * @param avgscore
	 */
	public void setAvgscore(String avgscore) {
		this.avgscore = avgscore;
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
	 * @param sEgRhqCd
	 */
	public void setSEgRhqCd(String sEgRhqCd) {
		this.sEgRhqCd = sEgRhqCd;
	}
	
	/**
	 * Column Info
	 * @param egId
	 */
	public void setEgId(String egId) {
		this.egId = egId;
	}
	
	/**
	 * Column Info
	 * @param n2ndEvGrdCtnt
	 */
	public void setN2ndEvGrdCtnt(String n2ndEvGrdCtnt) {
		this.n2ndEvGrdCtnt = n2ndEvGrdCtnt;
	}
	
	/**
	 * Column Info
	 * @param egSvcCateCd
	 */
	public void setEgSvcCateCd(String egSvcCateCd) {
		this.egSvcCateCd = egSvcCateCd;
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
		setN1stEvGrdCtnt(JSPUtil.getParameter(request, prefix + "n1st_ev_grd_ctnt", ""));
		setSpName(JSPUtil.getParameter(request, prefix + "sp_name", ""));
		setIsflag(JSPUtil.getParameter(request, prefix + "isflag", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEvWgtRsltRt(JSPUtil.getParameter(request, prefix + "ev_wgt_rslt_rt", ""));
		setGradeB(JSPUtil.getParameter(request, prefix + "grade_b", ""));
		setGradeA(JSPUtil.getParameter(request, prefix + "grade_a", ""));
		setSEgId(JSPUtil.getParameter(request, prefix + "s_eg_id", ""));
		setSpSeq(JSPUtil.getParameter(request, prefix + "sp_seq", ""));
		setSEgSvcCateCd(JSPUtil.getParameter(request, prefix + "s_eg_svc_cate_cd", ""));
		setGradeC(JSPUtil.getParameter(request, prefix + "grade_c", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEvSvcCateCd(JSPUtil.getParameter(request, prefix + "ev_svc_cate_cd", ""));
		setSEvSvcCateCd(JSPUtil.getParameter(request, prefix + "s_ev_svc_cate_cd", ""));
		setEvYr(JSPUtil.getParameter(request, prefix + "ev_yr", ""));
		setN3rdEvGrdCtnt(JSPUtil.getParameter(request, prefix + "n3rd_ev_grd_ctnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEvGrdChkCd(JSPUtil.getParameter(request, prefix + "ev_grd_chk_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSEvMon(JSPUtil.getParameter(request, prefix + "s_ev_mon", ""));
		setSSpSeq(JSPUtil.getParameter(request, prefix + "s_sp_seq", ""));
		setEvMon(JSPUtil.getParameter(request, prefix + "ev_mon", ""));
		setEvFctrCtnt(JSPUtil.getParameter(request, prefix + "ev_fctr_ctnt", ""));
		setEvAreaCtnt(JSPUtil.getParameter(request, prefix + "ev_area_ctnt", ""));
		setEvWgtRt(JSPUtil.getParameter(request, prefix + "ev_wgt_rt", ""));
		setSEvYr(JSPUtil.getParameter(request, prefix + "s_ev_yr", ""));
		setSSpKpiId(JSPUtil.getParameter(request, prefix + "s_sp_kpi_id", ""));
		setSEgOfcCd(JSPUtil.getParameter(request, prefix + "s_eg_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSpQualEvSeq(JSPUtil.getParameter(request, prefix + "sp_qual_ev_seq", ""));
		setQualEvSeq(JSPUtil.getParameter(request, prefix + "qual_ev_seq", ""));
		setAvgscore(JSPUtil.getParameter(request, prefix + "avgscore", ""));
		setSpKpiId(JSPUtil.getParameter(request, prefix + "sp_kpi_id", ""));
		setSEgRhqCd(JSPUtil.getParameter(request, prefix + "s_eg_rhq_cd", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
		setN2ndEvGrdCtnt(JSPUtil.getParameter(request, prefix + "n2nd_ev_grd_ctnt", ""));
		setEgSvcCateCd(JSPUtil.getParameter(request, prefix + "eg_svc_cate_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpeSpQualEvVO[]
	 */
	public SpeSpQualEvVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpeSpQualEvVO[]
	 */
	public SpeSpQualEvVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpeSpQualEvVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n1stEvGrdCtnt = (JSPUtil.getParameter(request, prefix	+ "n1st_ev_grd_ctnt", length));
			String[] spName = (JSPUtil.getParameter(request, prefix	+ "sp_name", length));
			String[] isflag = (JSPUtil.getParameter(request, prefix	+ "isflag", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] evWgtRsltRt = (JSPUtil.getParameter(request, prefix	+ "ev_wgt_rslt_rt", length));
			String[] gradeB = (JSPUtil.getParameter(request, prefix	+ "grade_b", length));
			String[] gradeA = (JSPUtil.getParameter(request, prefix	+ "grade_a", length));
			String[] sEgId = (JSPUtil.getParameter(request, prefix	+ "s_eg_id", length));
			String[] spSeq = (JSPUtil.getParameter(request, prefix	+ "sp_seq", length));
			String[] sEgSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_svc_cate_cd", length));
			String[] gradeC = (JSPUtil.getParameter(request, prefix	+ "grade_c", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] evSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "ev_svc_cate_cd", length));
			String[] sEvSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "s_ev_svc_cate_cd", length));
			String[] evYr = (JSPUtil.getParameter(request, prefix	+ "ev_yr", length));
			String[] n3rdEvGrdCtnt = (JSPUtil.getParameter(request, prefix	+ "n3rd_ev_grd_ctnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] evGrdChkCd = (JSPUtil.getParameter(request, prefix	+ "ev_grd_chk_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] sEvMon = (JSPUtil.getParameter(request, prefix	+ "s_ev_mon", length));
			String[] sSpSeq = (JSPUtil.getParameter(request, prefix	+ "s_sp_seq", length));
			String[] evMon = (JSPUtil.getParameter(request, prefix	+ "ev_mon", length));
			String[] evFctrCtnt = (JSPUtil.getParameter(request, prefix	+ "ev_fctr_ctnt", length));
			String[] evAreaCtnt = (JSPUtil.getParameter(request, prefix	+ "ev_area_ctnt", length));
			String[] evWgtRt = (JSPUtil.getParameter(request, prefix	+ "ev_wgt_rt", length));
			String[] sEvYr = (JSPUtil.getParameter(request, prefix	+ "s_ev_yr", length));
			String[] sSpKpiId = (JSPUtil.getParameter(request, prefix	+ "s_sp_kpi_id", length));
			String[] sEgOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] spQualEvSeq = (JSPUtil.getParameter(request, prefix	+ "sp_qual_ev_seq", length));
			String[] qualEvSeq = (JSPUtil.getParameter(request, prefix	+ "qual_ev_seq", length));
			String[] avgscore = (JSPUtil.getParameter(request, prefix	+ "avgscore", length));
			String[] spKpiId = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_id", length));
			String[] sEgRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_rhq_cd", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			String[] n2ndEvGrdCtnt = (JSPUtil.getParameter(request, prefix	+ "n2nd_ev_grd_ctnt", length));
			String[] egSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "eg_svc_cate_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpeSpQualEvVO();
				if (n1stEvGrdCtnt[i] != null)
					model.setN1stEvGrdCtnt(n1stEvGrdCtnt[i]);
				if (spName[i] != null)
					model.setSpName(spName[i]);
				if (isflag[i] != null)
					model.setIsflag(isflag[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (evWgtRsltRt[i] != null)
					model.setEvWgtRsltRt(evWgtRsltRt[i]);
				if (gradeB[i] != null)
					model.setGradeB(gradeB[i]);
				if (gradeA[i] != null)
					model.setGradeA(gradeA[i]);
				if (sEgId[i] != null)
					model.setSEgId(sEgId[i]);
				if (spSeq[i] != null)
					model.setSpSeq(spSeq[i]);
				if (sEgSvcCateCd[i] != null)
					model.setSEgSvcCateCd(sEgSvcCateCd[i]);
				if (gradeC[i] != null)
					model.setGradeC(gradeC[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (evSvcCateCd[i] != null)
					model.setEvSvcCateCd(evSvcCateCd[i]);
				if (sEvSvcCateCd[i] != null)
					model.setSEvSvcCateCd(sEvSvcCateCd[i]);
				if (evYr[i] != null)
					model.setEvYr(evYr[i]);
				if (n3rdEvGrdCtnt[i] != null)
					model.setN3rdEvGrdCtnt(n3rdEvGrdCtnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (evGrdChkCd[i] != null)
					model.setEvGrdChkCd(evGrdChkCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sEvMon[i] != null)
					model.setSEvMon(sEvMon[i]);
				if (sSpSeq[i] != null)
					model.setSSpSeq(sSpSeq[i]);
				if (evMon[i] != null)
					model.setEvMon(evMon[i]);
				if (evFctrCtnt[i] != null)
					model.setEvFctrCtnt(evFctrCtnt[i]);
				if (evAreaCtnt[i] != null)
					model.setEvAreaCtnt(evAreaCtnt[i]);
				if (evWgtRt[i] != null)
					model.setEvWgtRt(evWgtRt[i]);
				if (sEvYr[i] != null)
					model.setSEvYr(sEvYr[i]);
				if (sSpKpiId[i] != null)
					model.setSSpKpiId(sSpKpiId[i]);
				if (sEgOfcCd[i] != null)
					model.setSEgOfcCd(sEgOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (spQualEvSeq[i] != null)
					model.setSpQualEvSeq(spQualEvSeq[i]);
				if (qualEvSeq[i] != null)
					model.setQualEvSeq(qualEvSeq[i]);
				if (avgscore[i] != null)
					model.setAvgscore(avgscore[i]);
				if (spKpiId[i] != null)
					model.setSpKpiId(spKpiId[i]);
				if (sEgRhqCd[i] != null)
					model.setSEgRhqCd(sEgRhqCd[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				if (n2ndEvGrdCtnt[i] != null)
					model.setN2ndEvGrdCtnt(n2ndEvGrdCtnt[i]);
				if (egSvcCateCd[i] != null)
					model.setEgSvcCateCd(egSvcCateCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpeSpQualEvVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpeSpQualEvVO[]
	 */
	public SpeSpQualEvVO[] getSpeSpQualEvVOs(){
		SpeSpQualEvVO[] vos = (SpeSpQualEvVO[])models.toArray(new SpeSpQualEvVO[models.size()]);
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
		this.n1stEvGrdCtnt = this.n1stEvGrdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spName = this.spName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isflag = this.isflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evWgtRsltRt = this.evWgtRsltRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gradeB = this.gradeB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gradeA = this.gradeA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgId = this.sEgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spSeq = this.spSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgSvcCateCd = this.sEgSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gradeC = this.gradeC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evSvcCateCd = this.evSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvSvcCateCd = this.sEvSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evYr = this.evYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdEvGrdCtnt = this.n3rdEvGrdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evGrdChkCd = this.evGrdChkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvMon = this.sEvMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSpSeq = this.sSpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evMon = this.evMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evFctrCtnt = this.evFctrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evAreaCtnt = this.evAreaCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evWgtRt = this.evWgtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvYr = this.sEvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSpKpiId = this.sSpKpiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgOfcCd = this.sEgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spQualEvSeq = this.spQualEvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qualEvSeq = this.qualEvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgscore = this.avgscore .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spKpiId = this.spKpiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgRhqCd = this.sEgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndEvGrdCtnt = this.n2ndEvGrdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egSvcCateCd = this.egSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
