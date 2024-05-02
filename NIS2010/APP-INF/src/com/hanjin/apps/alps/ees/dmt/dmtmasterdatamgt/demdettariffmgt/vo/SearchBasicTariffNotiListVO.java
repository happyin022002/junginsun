/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchBasicTariffNotiListVO.java
*@FileTitle : SearchBasicTariffNotiListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */ 

public class SearchBasicTariffNotiListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBasicTariffNotiListVO> models = new ArrayList<SearchBasicTariffNotiListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String orgDest = null;
	/* Column Info */
	private String dmdtCntrTpNm = null;
	/* Column Info */
	private String cycNoti = null;
	/* Column Info */
	private String picTeam = null;
	/* Column Info */
	private String dmdtCntrTpCd = null;
	/* Column Info */
	private String dmdtCgoTpNm = null;
	/* Column Info */
	private String sysAreaGrpId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trfMngUsrId = null;
	/* Column Info */
	private String dmdtDeTermNm = null;
	/* Column Info */
	private String dmdtDeTermCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String dmdtCgoTpCd = null;
	/* Column Info */
	private String trfGrpSeq = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String trfSeq = null;
	/* Column Info */
	private String covrg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String trfMngUsrNm = null;
	/* Column Info */
	private String exist = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchBasicTariffNotiListVO() {}

	public SearchBasicTariffNotiListVO(String ibflag, String pagerows, String covrg, String dmdtTrfCd, String orgDest, String dmdtDeTermCd, String dmdtDeTermNm, String dmdtCntrTpNm, String dmdtCgoTpNm, String expDt, String picTeam, String trfMngUsrId, String updDt, String updUsrNm, String updOfcCd, String cycNoti, String sysAreaGrpId, String trfSeq, String trfGrpSeq, String dmdtCntrTpCd, String dmdtCgoTpCd, String effDt, String updUsrId, String trfMngUsrNm, String exist) {
		this.updDt = updDt;
		this.orgDest = orgDest;
		this.dmdtCntrTpNm = dmdtCntrTpNm;
		this.cycNoti = cycNoti;
		this.picTeam = picTeam;
		this.dmdtCntrTpCd = dmdtCntrTpCd;
		this.dmdtCgoTpNm = dmdtCgoTpNm;
		this.sysAreaGrpId = sysAreaGrpId;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.trfMngUsrId = trfMngUsrId;
		this.dmdtDeTermNm = dmdtDeTermNm;
		this.dmdtDeTermCd = dmdtDeTermCd;
		this.expDt = expDt;
		this.dmdtCgoTpCd = dmdtCgoTpCd;
		this.trfGrpSeq = trfGrpSeq;
		this.updUsrNm = updUsrNm;
		this.updOfcCd = updOfcCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.trfSeq = trfSeq;
		this.covrg = covrg;
		this.updUsrId = updUsrId;
		this.trfMngUsrNm = trfMngUsrNm;
		this.exist = exist;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("org_dest", getOrgDest());
		this.hashColumns.put("dmdt_cntr_tp_nm", getDmdtCntrTpNm());
		this.hashColumns.put("cyc_noti", getCycNoti());
		this.hashColumns.put("pic_team", getPicTeam());
		this.hashColumns.put("dmdt_cntr_tp_cd", getDmdtCntrTpCd());
		this.hashColumns.put("dmdt_cgo_tp_nm", getDmdtCgoTpNm());
		this.hashColumns.put("sys_area_grp_id", getSysAreaGrpId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trf_mng_usr_id", getTrfMngUsrId());
		this.hashColumns.put("dmdt_de_term_nm", getDmdtDeTermNm());
		this.hashColumns.put("dmdt_de_term_cd", getDmdtDeTermCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("dmdt_cgo_tp_cd", getDmdtCgoTpCd());
		this.hashColumns.put("trf_grp_seq", getTrfGrpSeq());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("trf_seq", getTrfSeq());
		this.hashColumns.put("covrg", getCovrg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("trf_mng_usr_nm", getTrfMngUsrNm());
		this.hashColumns.put("exist", getExist());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("org_dest", "orgDest");
		this.hashFields.put("dmdt_cntr_tp_nm", "dmdtCntrTpNm");
		this.hashFields.put("cyc_noti", "cycNoti");
		this.hashFields.put("pic_team", "picTeam");
		this.hashFields.put("dmdt_cntr_tp_cd", "dmdtCntrTpCd");
		this.hashFields.put("dmdt_cgo_tp_nm", "dmdtCgoTpNm");
		this.hashFields.put("sys_area_grp_id", "sysAreaGrpId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trf_mng_usr_id", "trfMngUsrId");
		this.hashFields.put("dmdt_de_term_nm", "dmdtDeTermNm");
		this.hashFields.put("dmdt_de_term_cd", "dmdtDeTermCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("dmdt_cgo_tp_cd", "dmdtCgoTpCd");
		this.hashFields.put("trf_grp_seq", "trfGrpSeq");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("trf_seq", "trfSeq");
		this.hashFields.put("covrg", "covrg");
		this.hashFields.put("covrg", "covrg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("trf_mng_usr_nm", "trfMngUsrNm");
		this.hashFields.put("exist", "exist");
		
		return this.hashFields;
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
	 * @return orgDest
	 */
	public String getOrgDest() {
		return this.orgDest;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpNm
	 */
	public String getDmdtCntrTpNm() {
		return this.dmdtCntrTpNm;
	}
	
	/**
	 * Column Info
	 * @return cycNoti
	 */
	public String getCycNoti() {
		return this.cycNoti;
	}
	
	/**
	 * Column Info
	 * @return picTeam
	 */
	public String getPicTeam() {
		return this.picTeam;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpCd
	 */
	public String getDmdtCntrTpCd() {
		return this.dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtCgoTpNm
	 */
	public String getDmdtCgoTpNm() {
		return this.dmdtCgoTpNm;
	}
	
	/**
	 * Column Info
	 * @return sysAreaGrpId
	 */
	public String getSysAreaGrpId() {
		return this.sysAreaGrpId;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return trfMngUsrId
	 */
	public String getTrfMngUsrId() {
		return this.trfMngUsrId;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeTermNm
	 */
	public String getDmdtDeTermNm() {
		return this.dmdtDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeTermCd
	 */
	public String getDmdtDeTermCd() {
		return this.dmdtDeTermCd;
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
	 * @return dmdtCgoTpCd
	 */
	public String getDmdtCgoTpCd() {
		return this.dmdtCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return trfGrpSeq
	 */
	public String getTrfGrpSeq() {
		return this.trfGrpSeq;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return trfSeq
	 */
	public String getTrfSeq() {
		return this.trfSeq;
	}
	
	/**
	 * Column Info
	 * @return covrg
	 */
	public String getCovrg() {
		return this.covrg;
	}
	
	/**
	 * Column Info
	 * @return exist
	 */
	public String getExist() {
		return this.exist;
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
	 * @param orgDest
	 */
	public void setOrgDest(String orgDest) {
		this.orgDest = orgDest;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpNm
	 */
	public void setDmdtCntrTpNm(String dmdtCntrTpNm) {
		this.dmdtCntrTpNm = dmdtCntrTpNm;
	}
	
	/**
	 * Column Info
	 * @param cycNoti
	 */
	public void setCycNoti(String cycNoti) {
		this.cycNoti = cycNoti;
	}
	
	/**
	 * Column Info
	 * @param picTeam
	 */
	public void setPicTeam(String picTeam) {
		this.picTeam = picTeam;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpCd
	 */
	public void setDmdtCntrTpCd(String dmdtCntrTpCd) {
		this.dmdtCntrTpCd = dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCgoTpNm
	 */
	public void setDmdtCgoTpNm(String dmdtCgoTpNm) {
		this.dmdtCgoTpNm = dmdtCgoTpNm;
	}
	
	/**
	 * Column Info
	 * @param sysAreaGrpId
	 */
	public void setSysAreaGrpId(String sysAreaGrpId) {
		this.sysAreaGrpId = sysAreaGrpId;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param trfMngUsrId
	 */
	public void setTrfMngUsrId(String trfMngUsrId) {
		this.trfMngUsrId = trfMngUsrId;
	}
	
	/**
	 * Column Info
	 * @param dmdtDeTermNm
	 */
	public void setDmdtDeTermNm(String dmdtDeTermNm) {
		this.dmdtDeTermNm = dmdtDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param dmdtDeTermCd
	 */
	public void setDmdtDeTermCd(String dmdtDeTermCd) {
		this.dmdtDeTermCd = dmdtDeTermCd;
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
	 * @param dmdtCgoTpCd
	 */
	public void setDmdtCgoTpCd(String dmdtCgoTpCd) {
		this.dmdtCgoTpCd = dmdtCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param trfGrpSeq
	 */
	public void setTrfGrpSeq(String trfGrpSeq) {
		this.trfGrpSeq = trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param trfSeq
	 */
	public void setTrfSeq(String trfSeq) {
		this.trfSeq = trfSeq;
	}
	
	/**
	 * Column Info
	 * @param covrg
	 */
	public void setCovrg(String covrg) {
		this.covrg = covrg;
	}
	
	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getTrfMngUsrNm() {
		return trfMngUsrNm;
	}

	public void setTrfMngUsrNm(String trfMngUsrNm) {
		this.trfMngUsrNm = trfMngUsrNm;
	}

	/**
	 * Column Info
	 * @param exist
	 */
	public void setExist(String exist) {
		this.exist = exist;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setOrgDest(JSPUtil.getParameter(request, prefix + "org_dest", ""));
		setDmdtCntrTpNm(JSPUtil.getParameter(request, prefix + "dmdt_cntr_tp_nm", ""));
		setCycNoti(JSPUtil.getParameter(request, prefix + "cyc_noti", ""));
		setPicTeam(JSPUtil.getParameter(request, prefix + "pic_team", ""));
		setDmdtCntrTpCd(JSPUtil.getParameter(request, prefix + "dmdt_cntr_tp_cd", ""));
		setDmdtCgoTpNm(JSPUtil.getParameter(request, prefix + "dmdt_cgo_tp_nm", ""));
		setSysAreaGrpId(JSPUtil.getParameter(request, prefix + "sys_area_grp_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrfMngUsrId(JSPUtil.getParameter(request, prefix + "trf_mng_usr_id", ""));
		setDmdtDeTermNm(JSPUtil.getParameter(request, prefix + "dmdt_de_term_nm", ""));
		setDmdtDeTermCd(JSPUtil.getParameter(request, prefix + "dmdt_de_term_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setDmdtCgoTpCd(JSPUtil.getParameter(request, prefix + "dmdt_cgo_tp_cd", ""));
		setTrfGrpSeq(JSPUtil.getParameter(request, prefix + "trf_grp_seq", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setTrfSeq(JSPUtil.getParameter(request, prefix + "trf_seq", ""));
		setCovrg(JSPUtil.getParameter(request, prefix + "covrg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setTrfMngUsrNm(JSPUtil.getParameter(request, prefix + "trf_mng_usr_nm", ""));
		setExist(JSPUtil.getParameter(request, prefix + "exist", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBasicTariffNotiListVO[]
	 */
	public SearchBasicTariffNotiListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBasicTariffNotiListVO[]
	 */
	public SearchBasicTariffNotiListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBasicTariffNotiListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] orgDest = (JSPUtil.getParameter(request, prefix	+ "org_dest", length));
			String[] dmdtCntrTpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_nm", length));
			String[] cycNoti = (JSPUtil.getParameter(request, prefix	+ "cyc_noti", length));
			String[] picTeam = (JSPUtil.getParameter(request, prefix	+ "pic_team", length));
			String[] dmdtCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_cd", length));
			String[] dmdtCgoTpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_nm", length));
			String[] sysAreaGrpId = (JSPUtil.getParameter(request, prefix	+ "sys_area_grp_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trfMngUsrId = (JSPUtil.getParameter(request, prefix	+ "trf_mng_usr_id", length));
			String[] dmdtDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_nm", length));
			String[] dmdtDeTermCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] dmdtCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_cd", length));
			String[] trfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "trf_grp_seq", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] trfSeq = (JSPUtil.getParameter(request, prefix	+ "trf_seq", length));
			String[] covrg = (JSPUtil.getParameter(request, prefix	+ "covrg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] trfMngUsrNm = (JSPUtil.getParameter(request, prefix	+ "trf_mng_usr_nm", length));
			String[] exist = (JSPUtil.getParameter(request, prefix	+ "exist", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new SearchBasicTariffNotiListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (orgDest[i] != null)
					model.setOrgDest(orgDest[i]);
				if (dmdtCntrTpNm[i] != null)
					model.setDmdtCntrTpNm(dmdtCntrTpNm[i]);
				if (cycNoti[i] != null)
					model.setCycNoti(cycNoti[i]);
				if (picTeam[i] != null)
					model.setPicTeam(picTeam[i]);
				if (dmdtCntrTpCd[i] != null)
					model.setDmdtCntrTpCd(dmdtCntrTpCd[i]);
				if (dmdtCgoTpNm[i] != null)
					model.setDmdtCgoTpNm(dmdtCgoTpNm[i]);
				if (sysAreaGrpId[i] != null)
					model.setSysAreaGrpId(sysAreaGrpId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trfMngUsrId[i] != null)
					model.setTrfMngUsrId(trfMngUsrId[i]);
				if (dmdtDeTermNm[i] != null)
					model.setDmdtDeTermNm(dmdtDeTermNm[i]);
				if (dmdtDeTermCd[i] != null)
					model.setDmdtDeTermCd(dmdtDeTermCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (dmdtCgoTpCd[i] != null)
					model.setDmdtCgoTpCd(dmdtCgoTpCd[i]);
				if (trfGrpSeq[i] != null)
					model.setTrfGrpSeq(trfGrpSeq[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (trfSeq[i] != null)
					model.setTrfSeq(trfSeq[i]);
				if (covrg[i] != null)
					model.setCovrg(covrg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (trfMngUsrNm[i] != null)
					model.setTrfMngUsrNm(trfMngUsrNm[i]);
				if (exist[i] != null)
					model.setExist(exist[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBasicTariffNotiListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBasicTariffNotiListVO[]
	 */
	public SearchBasicTariffNotiListVO[] getSearchBasicTariffNotiListVOs(){
		SearchBasicTariffNotiListVO[] vos = (SearchBasicTariffNotiListVO[])models.toArray(new SearchBasicTariffNotiListVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDest = this.orgDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpNm = this.dmdtCntrTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cycNoti = this.cycNoti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picTeam = this.picTeam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpCd = this.dmdtCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpNm = this.dmdtCgoTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysAreaGrpId = this.sysAreaGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfMngUsrId = this.trfMngUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermNm = this.dmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermCd = this.dmdtDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpCd = this.dmdtCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfGrpSeq = this.trfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfSeq = this.trfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.covrg = this.covrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfMngUsrNm = this.trfMngUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exist = this.exist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
