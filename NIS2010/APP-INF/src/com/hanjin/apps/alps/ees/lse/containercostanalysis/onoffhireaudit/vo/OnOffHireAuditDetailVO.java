/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OnOffHireAuditDetailVO.java
*@FileTitle : OnOffHireAuditDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2010.02.16 진준성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.vo;

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
 * @author 진준성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OnOffHireAuditDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OnOffHireAuditDetailVO> models = new ArrayList<OnOffHireAuditDetailVO>();
	
	/* Column Info */
	private String offhLocCd = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String searchStdt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String auditType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bilToDt = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String lOffhLocCd = null;
	/* Column Info */
	private String audVerSeq = null;
	/* Column Info */
	private String offhDt = null;
	/* Column Info */
	private String onfHirStsCd = null;
	/* Column Info */
	private String lrOffhLocCd = null;
	/* Column Info */
	private String lrOnhLocCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String lrOnhDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String auditRemark = null;
	/* Column Info */
	private String lrOffhDt = null;
	/* Column Info */
	private String lOnhLocCd = null;
	/* Column Info */
	private String bilFmDt = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String searchEnddt = null;
	/* Column Info */
	private String hOffhDt = null;
	/* Column Info */
	private String hOnhDt = null;
	/* Column Info */
	private String lOnhDt = null;
	/* Column Info */
	private String onhLocCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String lOffhDt = null;
	/* Column Info */
	private String hOnhLocCd = null;
	/* Column Info */
	private String hOffhLocCd = null;
	/* Column Info */
	private String lseAudTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OnOffHireAuditDetailVO() {}

	public OnOffHireAuditDetailVO(String ibflag, String pagerows, String offhLocCd, String searchStdt, String onhDt, String auditType, String cntrTpszCd, String agmtCtyCd, String bilToDt, String lOffhLocCd, String offhDt, String audVerSeq, String onfHirStsCd, String lrOffhLocCd, String lrOnhLocCd, String lstmCd, String lrOnhDt, String updUsrId, String lrOffhDt, String lOnhLocCd, String bilFmDt, String agmtSeq, String agmtNo, String searchEnddt, String hOffhDt, String hOnhDt, String onhLocCd, String lOnhDt, String creUsrId, String cntrNo, String vndrSeq, String hOnhLocCd, String lOffhDt, String refNo, String hOffhLocCd, String lseAudTpCd, String auditRemark) {
		this.offhLocCd = offhLocCd;
		this.onhDt = onhDt;
		this.searchStdt = searchStdt;
		this.pagerows = pagerows;
		this.auditType = auditType;
		this.ibflag = ibflag;
		this.bilToDt = bilToDt;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrTpszCd = cntrTpszCd;
		this.lOffhLocCd = lOffhLocCd;
		this.audVerSeq = audVerSeq;
		this.offhDt = offhDt;
		this.onfHirStsCd = onfHirStsCd;
		this.lrOffhLocCd = lrOffhLocCd;
		this.lrOnhLocCd = lrOnhLocCd;
		this.lstmCd = lstmCd;
		this.lrOnhDt = lrOnhDt;
		this.updUsrId = updUsrId;
		this.auditRemark = auditRemark;
		this.lrOffhDt = lrOffhDt;
		this.lOnhLocCd = lOnhLocCd;
		this.bilFmDt = bilFmDt;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.searchEnddt = searchEnddt;
		this.hOffhDt = hOffhDt;
		this.hOnhDt = hOnhDt;
		this.lOnhDt = lOnhDt;
		this.onhLocCd = onhLocCd;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.cntrNo = cntrNo;
		this.refNo = refNo;
		this.lOffhDt = lOffhDt;
		this.hOnhLocCd = hOnhLocCd;
		this.hOffhLocCd = hOffhLocCd;
		this.lseAudTpCd = lseAudTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("offh_loc_cd", getOffhLocCd());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("search_stdt", getSearchStdt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("audit_type", getAuditType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bil_to_dt", getBilToDt());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("l_offh_loc_cd", getLOffhLocCd());
		this.hashColumns.put("aud_ver_seq", getAudVerSeq());
		this.hashColumns.put("offh_dt", getOffhDt());
		this.hashColumns.put("onf_hir_sts_cd", getOnfHirStsCd());
		this.hashColumns.put("lr_offh_loc_cd", getLrOffhLocCd());
		this.hashColumns.put("lr_onh_loc_cd", getLrOnhLocCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("lr_onh_dt", getLrOnhDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("audit_remark", getAuditRemark());
		this.hashColumns.put("lr_offh_dt", getLrOffhDt());
		this.hashColumns.put("l_onh_loc_cd", getLOnhLocCd());
		this.hashColumns.put("bil_fm_dt", getBilFmDt());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("search_enddt", getSearchEnddt());
		this.hashColumns.put("h_offh_dt", getHOffhDt());
		this.hashColumns.put("h_onh_dt", getHOnhDt());
		this.hashColumns.put("l_onh_dt", getLOnhDt());
		this.hashColumns.put("onh_loc_cd", getOnhLocCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("l_offh_dt", getLOffhDt());
		this.hashColumns.put("h_onh_loc_cd", getHOnhLocCd());
		this.hashColumns.put("h_offh_loc_cd", getHOffhLocCd());
		this.hashColumns.put("lse_aud_tp_cd", getLseAudTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("offh_loc_cd", "offhLocCd");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("search_stdt", "searchStdt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("audit_type", "auditType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bil_to_dt", "bilToDt");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("l_offh_loc_cd", "lOffhLocCd");
		this.hashFields.put("aud_ver_seq", "audVerSeq");
		this.hashFields.put("offh_dt", "offhDt");
		this.hashFields.put("onf_hir_sts_cd", "onfHirStsCd");
		this.hashFields.put("lr_offh_loc_cd", "lrOffhLocCd");
		this.hashFields.put("lr_onh_loc_cd", "lrOnhLocCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("lr_onh_dt", "lrOnhDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("audit_remark", "auditRemark");
		this.hashFields.put("lr_offh_dt", "lrOffhDt");
		this.hashFields.put("l_onh_loc_cd", "lOnhLocCd");
		this.hashFields.put("bil_fm_dt", "bilFmDt");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("search_enddt", "searchEnddt");
		this.hashFields.put("h_offh_dt", "hOffhDt");
		this.hashFields.put("h_onh_dt", "hOnhDt");
		this.hashFields.put("l_onh_dt", "lOnhDt");
		this.hashFields.put("onh_loc_cd", "onhLocCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("l_offh_dt", "lOffhDt");
		this.hashFields.put("h_onh_loc_cd", "hOnhLocCd");
		this.hashFields.put("h_offh_loc_cd", "hOffhLocCd");
		this.hashFields.put("lse_aud_tp_cd", "lseAudTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return offhLocCd
	 */
	public String getOffhLocCd() {
		return this.offhLocCd;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
	}
	
	/**
	 * Column Info
	 * @return searchStdt
	 */
	public String getSearchStdt() {
		return this.searchStdt;
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
	 * @return auditType
	 */
	public String getAuditType() {
		return this.auditType;
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
	 * @return bilToDt
	 */
	public String getBilToDt() {
		return this.bilToDt;
	}
	
	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
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
	 * @return lOffhLocCd
	 */
	public String getLOffhLocCd() {
		return this.lOffhLocCd;
	}
	
	/**
	 * Column Info
	 * @return audVerSeq
	 */
	public String getAudVerSeq() {
		return this.audVerSeq;
	}
	
	/**
	 * Column Info
	 * @return offhDt
	 */
	public String getOffhDt() {
		return this.offhDt;
	}
	
	/**
	 * Column Info
	 * @return onfHirStsCd
	 */
	public String getOnfHirStsCd() {
		return this.onfHirStsCd;
	}
	
	/**
	 * Column Info
	 * @return lrOffhLocCd
	 */
	public String getLrOffhLocCd() {
		return this.lrOffhLocCd;
	}
	
	/**
	 * Column Info
	 * @return lrOnhLocCd
	 */
	public String getLrOnhLocCd() {
		return this.lrOnhLocCd;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return lrOnhDt
	 */
	public String getLrOnhDt() {
		return this.lrOnhDt;
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
	 * @return auditRemark
	 */
	public String getAuditRemark() {
		return this.auditRemark;
	}
	
	/**
	 * Column Info
	 * @return lrOffhDt
	 */
	public String getLrOffhDt() {
		return this.lrOffhDt;
	}
	
	/**
	 * Column Info
	 * @return lOnhLocCd
	 */
	public String getLOnhLocCd() {
		return this.lOnhLocCd;
	}
	
	/**
	 * Column Info
	 * @return bilFmDt
	 */
	public String getBilFmDt() {
		return this.bilFmDt;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return searchEnddt
	 */
	public String getSearchEnddt() {
		return this.searchEnddt;
	}
	
	/**
	 * Column Info
	 * @return hOffhDt
	 */
	public String getHOffhDt() {
		return this.hOffhDt;
	}
	
	/**
	 * Column Info
	 * @return hOnhDt
	 */
	public String getHOnhDt() {
		return this.hOnhDt;
	}
	
	/**
	 * Column Info
	 * @return lOnhDt
	 */
	public String getLOnhDt() {
		return this.lOnhDt;
	}
	
	/**
	 * Column Info
	 * @return onhLocCd
	 */
	public String getOnhLocCd() {
		return this.onhLocCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return lOffhDt
	 */
	public String getLOffhDt() {
		return this.lOffhDt;
	}
	
	/**
	 * Column Info
	 * @return hOnhLocCd
	 */
	public String getHOnhLocCd() {
		return this.hOnhLocCd;
	}
	
	/**
	 * Column Info
	 * @return hOffhLocCd
	 */
	public String getHOffhLocCd() {
		return this.hOffhLocCd;
	}
	
	/**
	 * Column Info
	 * @return lseAudTpCd
	 */
	public String getLseAudTpCd() {
		return this.lseAudTpCd;
	}
	

	/**
	 * Column Info
	 * @param offhLocCd
	 */
	public void setOffhLocCd(String offhLocCd) {
		this.offhLocCd = offhLocCd;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
	}
	
	/**
	 * Column Info
	 * @param searchStdt
	 */
	public void setSearchStdt(String searchStdt) {
		this.searchStdt = searchStdt;
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
	 * @param auditType
	 */
	public void setAuditType(String auditType) {
		this.auditType = auditType;
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
	 * @param bilToDt
	 */
	public void setBilToDt(String bilToDt) {
		this.bilToDt = bilToDt;
	}
	
	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
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
	 * @param lOffhLocCd
	 */
	public void setLOffhLocCd(String lOffhLocCd) {
		this.lOffhLocCd = lOffhLocCd;
	}
	
	/**
	 * Column Info
	 * @param audVerSeq
	 */
	public void setAudVerSeq(String audVerSeq) {
		this.audVerSeq = audVerSeq;
	}
	
	/**
	 * Column Info
	 * @param offhDt
	 */
	public void setOffhDt(String offhDt) {
		this.offhDt = offhDt;
	}
	
	/**
	 * Column Info
	 * @param onfHirStsCd
	 */
	public void setOnfHirStsCd(String onfHirStsCd) {
		this.onfHirStsCd = onfHirStsCd;
	}
	
	/**
	 * Column Info
	 * @param lrOffhLocCd
	 */
	public void setLrOffhLocCd(String lrOffhLocCd) {
		this.lrOffhLocCd = lrOffhLocCd;
	}
	
	/**
	 * Column Info
	 * @param lrOnhLocCd
	 */
	public void setLrOnhLocCd(String lrOnhLocCd) {
		this.lrOnhLocCd = lrOnhLocCd;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param lrOnhDt
	 */
	public void setLrOnhDt(String lrOnhDt) {
		this.lrOnhDt = lrOnhDt;
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
	 * @param auditRemark
	 */
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
	
	/**
	 * Column Info
	 * @param lrOffhDt
	 */
	public void setLrOffhDt(String lrOffhDt) {
		this.lrOffhDt = lrOffhDt;
	}
	
	/**
	 * Column Info
	 * @param lOnhLocCd
	 */
	public void setLOnhLocCd(String lOnhLocCd) {
		this.lOnhLocCd = lOnhLocCd;
	}
	
	/**
	 * Column Info
	 * @param bilFmDt
	 */
	public void setBilFmDt(String bilFmDt) {
		this.bilFmDt = bilFmDt;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param searchEnddt
	 */
	public void setSearchEnddt(String searchEnddt) {
		this.searchEnddt = searchEnddt;
	}
	
	/**
	 * Column Info
	 * @param hOffhDt
	 */
	public void setHOffhDt(String hOffhDt) {
		this.hOffhDt = hOffhDt;
	}
	
	/**
	 * Column Info
	 * @param hOnhDt
	 */
	public void setHOnhDt(String hOnhDt) {
		this.hOnhDt = hOnhDt;
	}
	
	/**
	 * Column Info
	 * @param lOnhDt
	 */
	public void setLOnhDt(String lOnhDt) {
		this.lOnhDt = lOnhDt;
	}
	
	/**
	 * Column Info
	 * @param onhLocCd
	 */
	public void setOnhLocCd(String onhLocCd) {
		this.onhLocCd = onhLocCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param lOffhDt
	 */
	public void setLOffhDt(String lOffhDt) {
		this.lOffhDt = lOffhDt;
	}
	
	/**
	 * Column Info
	 * @param hOnhLocCd
	 */
	public void setHOnhLocCd(String hOnhLocCd) {
		this.hOnhLocCd = hOnhLocCd;
	}
	
	/**
	 * Column Info
	 * @param hOffhLocCd
	 */
	public void setHOffhLocCd(String hOffhLocCd) {
		this.hOffhLocCd = hOffhLocCd;
	}
	
	/**
	 * Column Info
	 * @param lseAudTpCd
	 */
	public void setLseAudTpCd(String lseAudTpCd) {
		this.lseAudTpCd = lseAudTpCd;
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
		setOffhLocCd(JSPUtil.getParameter(request, prefix + "offh_loc_cd", ""));
		setOnhDt(JSPUtil.getParameter(request, prefix + "onh_dt", ""));
		setSearchStdt(JSPUtil.getParameter(request, prefix + "search_stdt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAuditType(JSPUtil.getParameter(request, prefix + "audit_type", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBilToDt(JSPUtil.getParameter(request, prefix + "bil_to_dt", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, prefix + "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setLOffhLocCd(JSPUtil.getParameter(request, prefix + "l_offh_loc_cd", ""));
		setAudVerSeq(JSPUtil.getParameter(request, prefix + "aud_ver_seq", ""));
		setOffhDt(JSPUtil.getParameter(request, prefix + "offh_dt", ""));
		setOnfHirStsCd(JSPUtil.getParameter(request, prefix + "onf_hir_sts_cd", ""));
		setLrOffhLocCd(JSPUtil.getParameter(request, prefix + "lr_offh_loc_cd", ""));
		setLrOnhLocCd(JSPUtil.getParameter(request, prefix + "lr_onh_loc_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setLrOnhDt(JSPUtil.getParameter(request, prefix + "lr_onh_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAuditRemark(JSPUtil.getParameter(request, prefix + "audit_remark", ""));
		setLrOffhDt(JSPUtil.getParameter(request, prefix + "lr_offh_dt", ""));
		setLOnhLocCd(JSPUtil.getParameter(request, prefix + "l_onh_loc_cd", ""));
		setBilFmDt(JSPUtil.getParameter(request, prefix + "bil_fm_dt", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setSearchEnddt(JSPUtil.getParameter(request, prefix + "search_enddt", ""));
		setHOffhDt(JSPUtil.getParameter(request, prefix + "h_offh_dt", ""));
		setHOnhDt(JSPUtil.getParameter(request, prefix + "h_onh_dt", ""));
		setLOnhDt(JSPUtil.getParameter(request, prefix + "l_onh_dt", ""));
		setOnhLocCd(JSPUtil.getParameter(request, prefix + "onh_loc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setLOffhDt(JSPUtil.getParameter(request, prefix + "l_offh_dt", ""));
		setHOnhLocCd(JSPUtil.getParameter(request, prefix + "h_onh_loc_cd", ""));
		setHOffhLocCd(JSPUtil.getParameter(request, prefix + "h_offh_loc_cd", ""));
		setLseAudTpCd(JSPUtil.getParameter(request, prefix + "lse_aud_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OnOffHireAuditDetailVO[]
	 */
	public OnOffHireAuditDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OnOffHireAuditDetailVO[]
	 */
	public OnOffHireAuditDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OnOffHireAuditDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] offhLocCd = (JSPUtil.getParameter(request, prefix	+ "offh_loc_cd", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] searchStdt = (JSPUtil.getParameter(request, prefix	+ "search_stdt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] auditType = (JSPUtil.getParameter(request, prefix	+ "audit_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bilToDt = (JSPUtil.getParameter(request, prefix	+ "bil_to_dt", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] lOffhLocCd = (JSPUtil.getParameter(request, prefix	+ "l_offh_loc_cd", length));
			String[] audVerSeq = (JSPUtil.getParameter(request, prefix	+ "aud_ver_seq", length));
			String[] offhDt = (JSPUtil.getParameter(request, prefix	+ "offh_dt", length));
			String[] onfHirStsCd = (JSPUtil.getParameter(request, prefix	+ "onf_hir_sts_cd", length));
			String[] lrOffhLocCd = (JSPUtil.getParameter(request, prefix	+ "lr_offh_loc_cd", length));
			String[] lrOnhLocCd = (JSPUtil.getParameter(request, prefix	+ "lr_onh_loc_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] lrOnhDt = (JSPUtil.getParameter(request, prefix	+ "lr_onh_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] auditRemark = (JSPUtil.getParameter(request, prefix	+ "audit_remark", length));
			String[] lrOffhDt = (JSPUtil.getParameter(request, prefix	+ "lr_offh_dt", length));
			String[] lOnhLocCd = (JSPUtil.getParameter(request, prefix	+ "l_onh_loc_cd", length));
			String[] bilFmDt = (JSPUtil.getParameter(request, prefix	+ "bil_fm_dt", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] searchEnddt = (JSPUtil.getParameter(request, prefix	+ "search_enddt", length));
			String[] hOffhDt = (JSPUtil.getParameter(request, prefix	+ "h_offh_dt", length));
			String[] hOnhDt = (JSPUtil.getParameter(request, prefix	+ "h_onh_dt", length));
			String[] lOnhDt = (JSPUtil.getParameter(request, prefix	+ "l_onh_dt", length));
			String[] onhLocCd = (JSPUtil.getParameter(request, prefix	+ "onh_loc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] lOffhDt = (JSPUtil.getParameter(request, prefix	+ "l_offh_dt", length));
			String[] hOnhLocCd = (JSPUtil.getParameter(request, prefix	+ "h_onh_loc_cd", length));
			String[] hOffhLocCd = (JSPUtil.getParameter(request, prefix	+ "h_offh_loc_cd", length));
			String[] lseAudTpCd = (JSPUtil.getParameter(request, prefix	+ "lse_aud_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OnOffHireAuditDetailVO();
				if (offhLocCd[i] != null)
					model.setOffhLocCd(offhLocCd[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (searchStdt[i] != null)
					model.setSearchStdt(searchStdt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (auditType[i] != null)
					model.setAuditType(auditType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bilToDt[i] != null)
					model.setBilToDt(bilToDt[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (lOffhLocCd[i] != null)
					model.setLOffhLocCd(lOffhLocCd[i]);
				if (audVerSeq[i] != null)
					model.setAudVerSeq(audVerSeq[i]);
				if (offhDt[i] != null)
					model.setOffhDt(offhDt[i]);
				if (onfHirStsCd[i] != null)
					model.setOnfHirStsCd(onfHirStsCd[i]);
				if (lrOffhLocCd[i] != null)
					model.setLrOffhLocCd(lrOffhLocCd[i]);
				if (lrOnhLocCd[i] != null)
					model.setLrOnhLocCd(lrOnhLocCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (lrOnhDt[i] != null)
					model.setLrOnhDt(lrOnhDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (auditRemark[i] != null)
					model.setAuditRemark(auditRemark[i]);
				if (lrOffhDt[i] != null)
					model.setLrOffhDt(lrOffhDt[i]);
				if (lOnhLocCd[i] != null)
					model.setLOnhLocCd(lOnhLocCd[i]);
				if (bilFmDt[i] != null)
					model.setBilFmDt(bilFmDt[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (searchEnddt[i] != null)
					model.setSearchEnddt(searchEnddt[i]);
				if (hOffhDt[i] != null)
					model.setHOffhDt(hOffhDt[i]);
				if (hOnhDt[i] != null)
					model.setHOnhDt(hOnhDt[i]);
				if (lOnhDt[i] != null)
					model.setLOnhDt(lOnhDt[i]);
				if (onhLocCd[i] != null)
					model.setOnhLocCd(onhLocCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (lOffhDt[i] != null)
					model.setLOffhDt(lOffhDt[i]);
				if (hOnhLocCd[i] != null)
					model.setHOnhLocCd(hOnhLocCd[i]);
				if (hOffhLocCd[i] != null)
					model.setHOffhLocCd(hOffhLocCd[i]);
				if (lseAudTpCd[i] != null)
					model.setLseAudTpCd(lseAudTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOnOffHireAuditDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OnOffHireAuditDetailVO[]
	 */
	public OnOffHireAuditDetailVO[] getOnOffHireAuditDetailVOs(){
		OnOffHireAuditDetailVO[] vos = (OnOffHireAuditDetailVO[])models.toArray(new OnOffHireAuditDetailVO[models.size()]);
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
		this.offhLocCd = this.offhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchStdt = this.searchStdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.auditType = this.auditType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToDt = this.bilToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lOffhLocCd = this.lOffhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audVerSeq = this.audVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDt = this.offhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onfHirStsCd = this.onfHirStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lrOffhLocCd = this.lrOffhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lrOnhLocCd = this.lrOnhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lrOnhDt = this.lrOnhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.auditRemark = this.auditRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lrOffhDt = this.lrOffhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lOnhLocCd = this.lOnhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilFmDt = this.bilFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchEnddt = this.searchEnddt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hOffhDt = this.hOffhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hOnhDt = this.hOnhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lOnhDt = this.lOnhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhLocCd = this.onhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lOffhDt = this.lOffhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hOnhLocCd = this.hOnhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hOffhLocCd = this.hOffhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseAudTpCd = this.lseAudTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
