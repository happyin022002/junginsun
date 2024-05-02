/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EGAndBEMappingVO.java
*@FileTitle : EGAndBEMappingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.23
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.23 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.vo;

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

public class EGAndBEMappingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EGAndBEMappingVO> models = new ArrayList<EGAndBEMappingVO>();
	
	/* Column Info */
	private String spName = null;
	/* Column Info */
	private String isflag = null;
	/* Column Info */
	private String gSpSeq = null;
	/* Column Info */
	private String sChkUnmap = null;
	/* Column Info */
	private String speYrmon = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String spSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String spBzcEgSeq = null;
	/* Column Info */
	private String egNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String evrUsrNm = null;
	/* Column Info */
	private String gEgId = null;
	/* Column Info */
	private String bzcEvGrdNm = null;
	/* Column Info */
	private String sEvSvcCateCd = null;
	/* Column Info */
	private String bzcEvGrdCd = null;
	/* Column Info */
	private String evYr = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sChkAll = null;
	/* Column Info */
	private String gEvYr = null;
	/* Column Info */
	private String sEgOfcCd = null;
	/* Column Info */
	private String sEvYr = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sChkMap = null;
	/* Column Info */
	private String sEgRhqCd = null;
	/* Column Info */
	private String evDt = null;
	/* Column Info */
	private String evrUsrId = null;
	/* Column Info */
	private String egId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EGAndBEMappingVO() {}

	public EGAndBEMappingVO(String ibflag, String pagerows, String egId, String egNm, String spSeq, String spName, String evYr, String bzcEvGrdCd, String bzcEvGrdNm, String evrUsrId, String evrUsrNm, String evDt, String sEgRhqCd, String sEgOfcCd, String sEvSvcCateCd, String sChkAll, String sChkMap, String sChkUnmap, String sEvYr, String speYrmon, String creUsrId, String creDt, String updUsrId, String updDt, String spBzcEgSeq, String gEgId, String gSpSeq, String gEvYr, String isflag) {
		this.spName = spName;
		this.isflag = isflag;
		this.gSpSeq = gSpSeq;
		this.sChkUnmap = sChkUnmap;
		this.speYrmon = speYrmon;
		this.creDt = creDt;
		this.spSeq = spSeq;
		this.pagerows = pagerows;
		this.spBzcEgSeq = spBzcEgSeq;
		this.egNm = egNm;
		this.ibflag = ibflag;
		this.evrUsrNm = evrUsrNm;
		this.gEgId = gEgId;
		this.bzcEvGrdNm = bzcEvGrdNm;
		this.sEvSvcCateCd = sEvSvcCateCd;
		this.bzcEvGrdCd = bzcEvGrdCd;
		this.evYr = evYr;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.sChkAll = sChkAll;
		this.gEvYr = gEvYr;
		this.sEgOfcCd = sEgOfcCd;
		this.sEvYr = sEvYr;
		this.creUsrId = creUsrId;
		this.sChkMap = sChkMap;
		this.sEgRhqCd = sEgRhqCd;
		this.evDt = evDt;
		this.evrUsrId = evrUsrId;
		this.egId = egId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sp_name", getSpName());
		this.hashColumns.put("isflag", getIsflag());
		this.hashColumns.put("g_sp_seq", getGSpSeq());
		this.hashColumns.put("s_chk_unmap", getSChkUnmap());
		this.hashColumns.put("spe_yrmon", getSpeYrmon());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sp_seq", getSpSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sp_bzc_eg_seq", getSpBzcEgSeq());
		this.hashColumns.put("eg_nm", getEgNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("evr_usr_nm", getEvrUsrNm());
		this.hashColumns.put("g_eg_id", getGEgId());
		this.hashColumns.put("bzc_ev_grd_nm", getBzcEvGrdNm());
		this.hashColumns.put("s_ev_svc_cate_cd", getSEvSvcCateCd());
		this.hashColumns.put("bzc_ev_grd_cd", getBzcEvGrdCd());
		this.hashColumns.put("ev_yr", getEvYr());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("s_chk_all", getSChkAll());
		this.hashColumns.put("g_ev_yr", getGEvYr());
		this.hashColumns.put("s_eg_ofc_cd", getSEgOfcCd());
		this.hashColumns.put("s_ev_yr", getSEvYr());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("s_chk_map", getSChkMap());
		this.hashColumns.put("s_eg_rhq_cd", getSEgRhqCd());
		this.hashColumns.put("ev_dt", getEvDt());
		this.hashColumns.put("evr_usr_id", getEvrUsrId());
		this.hashColumns.put("eg_id", getEgId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sp_name", "spName");
		this.hashFields.put("isflag", "isflag");
		this.hashFields.put("g_sp_seq", "gSpSeq");
		this.hashFields.put("s_chk_unmap", "sChkUnmap");
		this.hashFields.put("spe_yrmon", "speYrmon");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sp_seq", "spSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sp_bzc_eg_seq", "spBzcEgSeq");
		this.hashFields.put("eg_nm", "egNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("evr_usr_nm", "evrUsrNm");
		this.hashFields.put("g_eg_id", "gEgId");
		this.hashFields.put("bzc_ev_grd_nm", "bzcEvGrdNm");
		this.hashFields.put("s_ev_svc_cate_cd", "sEvSvcCateCd");
		this.hashFields.put("bzc_ev_grd_cd", "bzcEvGrdCd");
		this.hashFields.put("ev_yr", "evYr");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("s_chk_all", "sChkAll");
		this.hashFields.put("g_ev_yr", "gEvYr");
		this.hashFields.put("s_eg_ofc_cd", "sEgOfcCd");
		this.hashFields.put("s_ev_yr", "sEvYr");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("s_chk_map", "sChkMap");
		this.hashFields.put("s_eg_rhq_cd", "sEgRhqCd");
		this.hashFields.put("ev_dt", "evDt");
		this.hashFields.put("evr_usr_id", "evrUsrId");
		this.hashFields.put("eg_id", "egId");
		return this.hashFields;
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
	 * @return gSpSeq
	 */
	public String getGSpSeq() {
		return this.gSpSeq;
	}
	
	/**
	 * Column Info
	 * @return sChkUnmap
	 */
	public String getSChkUnmap() {
		return this.sChkUnmap;
	}
	
	/**
	 * Column Info
	 * @return speYrmon
	 */
	public String getSpeYrmon() {
		return this.speYrmon;
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
	 * @return spSeq
	 */
	public String getSpSeq() {
		return this.spSeq;
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
	 * @return spBzcEgSeq
	 */
	public String getSpBzcEgSeq() {
		return this.spBzcEgSeq;
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
	 * @return evrUsrNm
	 */
	public String getEvrUsrNm() {
		return this.evrUsrNm;
	}
	
	/**
	 * Column Info
	 * @return gEgId
	 */
	public String getGEgId() {
		return this.gEgId;
	}
	
	/**
	 * Column Info
	 * @return bzcEvGrdNm
	 */
	public String getBzcEvGrdNm() {
		return this.bzcEvGrdNm;
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
	 * @return bzcEvGrdCd
	 */
	public String getBzcEvGrdCd() {
		return this.bzcEvGrdCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return sChkAll
	 */
	public String getSChkAll() {
		return this.sChkAll;
	}
	
	/**
	 * Column Info
	 * @return gEvYr
	 */
	public String getGEvYr() {
		return this.gEvYr;
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
	 * @return sEvYr
	 */
	public String getSEvYr() {
		return this.sEvYr;
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
	 * @return sChkMap
	 */
	public String getSChkMap() {
		return this.sChkMap;
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
	 * @return evDt
	 */
	public String getEvDt() {
		return this.evDt;
	}
	
	/**
	 * Column Info
	 * @return evrUsrId
	 */
	public String getEvrUsrId() {
		return this.evrUsrId;
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
	 * @param gSpSeq
	 */
	public void setGSpSeq(String gSpSeq) {
		this.gSpSeq = gSpSeq;
	}
	
	/**
	 * Column Info
	 * @param sChkUnmap
	 */
	public void setSChkUnmap(String sChkUnmap) {
		this.sChkUnmap = sChkUnmap;
	}
	
	/**
	 * Column Info
	 * @param speYrmon
	 */
	public void setSpeYrmon(String speYrmon) {
		this.speYrmon = speYrmon;
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
	 * @param spSeq
	 */
	public void setSpSeq(String spSeq) {
		this.spSeq = spSeq;
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
	 * @param spBzcEgSeq
	 */
	public void setSpBzcEgSeq(String spBzcEgSeq) {
		this.spBzcEgSeq = spBzcEgSeq;
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
	 * @param evrUsrNm
	 */
	public void setEvrUsrNm(String evrUsrNm) {
		this.evrUsrNm = evrUsrNm;
	}
	
	/**
	 * Column Info
	 * @param gEgId
	 */
	public void setGEgId(String gEgId) {
		this.gEgId = gEgId;
	}
	
	/**
	 * Column Info
	 * @param bzcEvGrdNm
	 */
	public void setBzcEvGrdNm(String bzcEvGrdNm) {
		this.bzcEvGrdNm = bzcEvGrdNm;
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
	 * @param bzcEvGrdCd
	 */
	public void setBzcEvGrdCd(String bzcEvGrdCd) {
		this.bzcEvGrdCd = bzcEvGrdCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param sChkAll
	 */
	public void setSChkAll(String sChkAll) {
		this.sChkAll = sChkAll;
	}
	
	/**
	 * Column Info
	 * @param gEvYr
	 */
	public void setGEvYr(String gEvYr) {
		this.gEvYr = gEvYr;
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
	 * @param sEvYr
	 */
	public void setSEvYr(String sEvYr) {
		this.sEvYr = sEvYr;
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
	 * @param sChkMap
	 */
	public void setSChkMap(String sChkMap) {
		this.sChkMap = sChkMap;
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
	 * @param evDt
	 */
	public void setEvDt(String evDt) {
		this.evDt = evDt;
	}
	
	/**
	 * Column Info
	 * @param evrUsrId
	 */
	public void setEvrUsrId(String evrUsrId) {
		this.evrUsrId = evrUsrId;
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
		setSpName(JSPUtil.getParameter(request, prefix + "sp_name", ""));
		setIsflag(JSPUtil.getParameter(request, prefix + "isflag", ""));
		setGSpSeq(JSPUtil.getParameter(request, prefix + "g_sp_seq", ""));
		setSChkUnmap(JSPUtil.getParameter(request, prefix + "s_chk_unmap", ""));
		setSpeYrmon(JSPUtil.getParameter(request, prefix + "spe_yrmon", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSpSeq(JSPUtil.getParameter(request, prefix + "sp_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSpBzcEgSeq(JSPUtil.getParameter(request, prefix + "sp_bzc_eg_seq", ""));
		setEgNm(JSPUtil.getParameter(request, prefix + "eg_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEvrUsrNm(JSPUtil.getParameter(request, prefix + "evr_usr_nm", ""));
		setGEgId(JSPUtil.getParameter(request, prefix + "g_eg_id", ""));
		setBzcEvGrdNm(JSPUtil.getParameter(request, prefix + "bzc_ev_grd_nm", ""));
		setSEvSvcCateCd(JSPUtil.getParameter(request, prefix + "s_ev_svc_cate_cd", ""));
		setBzcEvGrdCd(JSPUtil.getParameter(request, prefix + "bzc_ev_grd_cd", ""));
		setEvYr(JSPUtil.getParameter(request, prefix + "ev_yr", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSChkAll(JSPUtil.getParameter(request, prefix + "s_chk_all", ""));
		setGEvYr(JSPUtil.getParameter(request, prefix + "g_ev_yr", ""));
		setSEgOfcCd(JSPUtil.getParameter(request, prefix + "s_eg_ofc_cd", ""));
		setSEvYr(JSPUtil.getParameter(request, prefix + "s_ev_yr", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSChkMap(JSPUtil.getParameter(request, prefix + "s_chk_map", ""));
		setSEgRhqCd(JSPUtil.getParameter(request, prefix + "s_eg_rhq_cd", ""));
		setEvDt(JSPUtil.getParameter(request, prefix + "ev_dt", ""));
		setEvrUsrId(JSPUtil.getParameter(request, prefix + "evr_usr_id", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EGAndBEMappingVO[]
	 */
	public EGAndBEMappingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EGAndBEMappingVO[]
	 */
	public EGAndBEMappingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EGAndBEMappingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] spName = (JSPUtil.getParameter(request, prefix	+ "sp_name", length));
			String[] isflag = (JSPUtil.getParameter(request, prefix	+ "isflag", length));
			String[] gSpSeq = (JSPUtil.getParameter(request, prefix	+ "g_sp_seq", length));
			String[] sChkUnmap = (JSPUtil.getParameter(request, prefix	+ "s_chk_unmap", length));
			String[] speYrmon = (JSPUtil.getParameter(request, prefix	+ "spe_yrmon", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] spSeq = (JSPUtil.getParameter(request, prefix	+ "sp_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] spBzcEgSeq = (JSPUtil.getParameter(request, prefix	+ "sp_bzc_eg_seq", length));
			String[] egNm = (JSPUtil.getParameter(request, prefix	+ "eg_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] evrUsrNm = (JSPUtil.getParameter(request, prefix	+ "evr_usr_nm", length));
			String[] gEgId = (JSPUtil.getParameter(request, prefix	+ "g_eg_id", length));
			String[] bzcEvGrdNm = (JSPUtil.getParameter(request, prefix	+ "bzc_ev_grd_nm", length));
			String[] sEvSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "s_ev_svc_cate_cd", length));
			String[] bzcEvGrdCd = (JSPUtil.getParameter(request, prefix	+ "bzc_ev_grd_cd", length));
			String[] evYr = (JSPUtil.getParameter(request, prefix	+ "ev_yr", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] sChkAll = (JSPUtil.getParameter(request, prefix	+ "s_chk_all", length));
			String[] gEvYr = (JSPUtil.getParameter(request, prefix	+ "g_ev_yr", length));
			String[] sEgOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_ofc_cd", length));
			String[] sEvYr = (JSPUtil.getParameter(request, prefix	+ "s_ev_yr", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sChkMap = (JSPUtil.getParameter(request, prefix	+ "s_chk_map", length));
			String[] sEgRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_rhq_cd", length));
			String[] evDt = (JSPUtil.getParameter(request, prefix	+ "ev_dt", length));
			String[] evrUsrId = (JSPUtil.getParameter(request, prefix	+ "evr_usr_id", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new EGAndBEMappingVO();
				if (spName[i] != null)
					model.setSpName(spName[i]);
				if (isflag[i] != null)
					model.setIsflag(isflag[i]);
				if (gSpSeq[i] != null)
					model.setGSpSeq(gSpSeq[i]);
				if (sChkUnmap[i] != null)
					model.setSChkUnmap(sChkUnmap[i]);
				if (speYrmon[i] != null)
					model.setSpeYrmon(speYrmon[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (spSeq[i] != null)
					model.setSpSeq(spSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (spBzcEgSeq[i] != null)
					model.setSpBzcEgSeq(spBzcEgSeq[i]);
				if (egNm[i] != null)
					model.setEgNm(egNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (evrUsrNm[i] != null)
					model.setEvrUsrNm(evrUsrNm[i]);
				if (gEgId[i] != null)
					model.setGEgId(gEgId[i]);
				if (bzcEvGrdNm[i] != null)
					model.setBzcEvGrdNm(bzcEvGrdNm[i]);
				if (sEvSvcCateCd[i] != null)
					model.setSEvSvcCateCd(sEvSvcCateCd[i]);
				if (bzcEvGrdCd[i] != null)
					model.setBzcEvGrdCd(bzcEvGrdCd[i]);
				if (evYr[i] != null)
					model.setEvYr(evYr[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sChkAll[i] != null)
					model.setSChkAll(sChkAll[i]);
				if (gEvYr[i] != null)
					model.setGEvYr(gEvYr[i]);
				if (sEgOfcCd[i] != null)
					model.setSEgOfcCd(sEgOfcCd[i]);
				if (sEvYr[i] != null)
					model.setSEvYr(sEvYr[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sChkMap[i] != null)
					model.setSChkMap(sChkMap[i]);
				if (sEgRhqCd[i] != null)
					model.setSEgRhqCd(sEgRhqCd[i]);
				if (evDt[i] != null)
					model.setEvDt(evDt[i]);
				if (evrUsrId[i] != null)
					model.setEvrUsrId(evrUsrId[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEGAndBEMappingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EGAndBEMappingVO[]
	 */
	public EGAndBEMappingVO[] getEGAndBEMappingVOs(){
		EGAndBEMappingVO[] vos = (EGAndBEMappingVO[])models.toArray(new EGAndBEMappingVO[models.size()]);
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
		this.spName = this.spName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isflag = this.isflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gSpSeq = this.gSpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChkUnmap = this.sChkUnmap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.speYrmon = this.speYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spSeq = this.spSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spBzcEgSeq = this.spBzcEgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egNm = this.egNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evrUsrNm = this.evrUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gEgId = this.gEgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcEvGrdNm = this.bzcEvGrdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvSvcCateCd = this.sEvSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcEvGrdCd = this.bzcEvGrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evYr = this.evYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChkAll = this.sChkAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gEvYr = this.gEvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgOfcCd = this.sEgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvYr = this.sEvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChkMap = this.sChkMap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgRhqCd = this.sEgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evDt = this.evDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evrUsrId = this.evrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
