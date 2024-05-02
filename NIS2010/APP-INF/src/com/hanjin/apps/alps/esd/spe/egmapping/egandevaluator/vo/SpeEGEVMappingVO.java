/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpeEGEVMappingVO.java
*@FileTitle : SpeEGEVMappingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.04 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.vo;

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

public class SpeEGEVMappingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpeEGEVMappingVO> models = new ArrayList<SpeEGEVMappingVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String evKndCd = null;
	/* Column Info */
	private String isinput = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String perEvrUsrId = null;
	/* Column Info */
	private String egRhqCd = null;
	/* Column Info */
	private String bzcEvrUsrNm = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sEgOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String egNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String evKndSeq = null;
	/* Column Info */
	private String sEgRhqCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String egOfcCd = null;
	/* Column Info */
	private String sEvSvcCateCd = null;
	/* Column Info */
	private String bzcEvrUsrId = null;
	/* Column Info */
	private String perEvrUsrNm = null;
	/* Column Info */
	private String egId = null;
	/* Column Info */
	private String evrUsrId = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpeEGEVMappingVO() {}

	public SpeEGEVMappingVO(String ibflag, String pagerows, String egId, String egNm, String ctrtOfcCd, String evKndCd, String evKndSeq, String evrUsrId, String creUsrId, String creDt, String updUsrId, String updDt, String bzcEvrUsrId, String bzcEvrUsrNm, String perEvrUsrId, String perEvrUsrNm, String chk, String sEgRhqCd, String sEgOfcCd, String sEvSvcCateCd, String isinput, String deltFlg, String egRhqCd, String egOfcCd) {
		this.updDt = updDt;
		this.evKndCd = evKndCd;
		this.isinput = isinput;
		this.deltFlg = deltFlg;
		this.perEvrUsrId = perEvrUsrId;
		this.egRhqCd = egRhqCd;
		this.bzcEvrUsrNm = bzcEvrUsrNm;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.sEgOfcCd = sEgOfcCd;
		this.ibflag = ibflag;
		this.egNm = egNm;
		this.creUsrId = creUsrId;
		this.chk = chk;
		this.evKndSeq = evKndSeq;
		this.sEgRhqCd = sEgRhqCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.egOfcCd = egOfcCd;
		this.sEvSvcCateCd = sEvSvcCateCd;
		this.bzcEvrUsrId = bzcEvrUsrId;
		this.perEvrUsrNm = perEvrUsrNm;
		this.egId = egId;
		this.evrUsrId = evrUsrId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ev_knd_cd", getEvKndCd());
		this.hashColumns.put("isinput", getIsinput());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("per_evr_usr_id", getPerEvrUsrId());
		this.hashColumns.put("eg_rhq_cd", getEgRhqCd());
		this.hashColumns.put("bzc_evr_usr_nm", getBzcEvrUsrNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_eg_ofc_cd", getSEgOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eg_nm", getEgNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("ev_knd_seq", getEvKndSeq());
		this.hashColumns.put("s_eg_rhq_cd", getSEgRhqCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("eg_ofc_cd", getEgOfcCd());
		this.hashColumns.put("s_ev_svc_cate_cd", getSEvSvcCateCd());
		this.hashColumns.put("bzc_evr_usr_id", getBzcEvrUsrId());
		this.hashColumns.put("per_evr_usr_nm", getPerEvrUsrNm());
		this.hashColumns.put("eg_id", getEgId());
		this.hashColumns.put("evr_usr_id", getEvrUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ev_knd_cd", "evKndCd");
		this.hashFields.put("isinput", "isinput");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("per_evr_usr_id", "perEvrUsrId");
		this.hashFields.put("eg_rhq_cd", "egRhqCd");
		this.hashFields.put("bzc_evr_usr_nm", "bzcEvrUsrNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_eg_ofc_cd", "sEgOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eg_nm", "egNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("ev_knd_seq", "evKndSeq");
		this.hashFields.put("s_eg_rhq_cd", "sEgRhqCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("eg_ofc_cd", "egOfcCd");
		this.hashFields.put("s_ev_svc_cate_cd", "sEvSvcCateCd");
		this.hashFields.put("bzc_evr_usr_id", "bzcEvrUsrId");
		this.hashFields.put("per_evr_usr_nm", "perEvrUsrNm");
		this.hashFields.put("eg_id", "egId");
		this.hashFields.put("evr_usr_id", "evrUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return evKndCd
	 */
	public String getEvKndCd() {
		return this.evKndCd;
	}
	
	/**
	 * Column Info
	 * @return isinput
	 */
	public String getIsinput() {
		return this.isinput;
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
	 * @return perEvrUsrId
	 */
	public String getPerEvrUsrId() {
		return this.perEvrUsrId;
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
	 * @return bzcEvrUsrNm
	 */
	public String getBzcEvrUsrNm() {
		return this.bzcEvrUsrNm;
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
	 * @return sEgOfcCd
	 */
	public String getSEgOfcCd() {
		return this.sEgOfcCd;
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
	 * @return egNm
	 */
	public String getEgNm() {
		return this.egNm;
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
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return evKndSeq
	 */
	public String getEvKndSeq() {
		return this.evKndSeq;
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
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
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
	 * @return sEvSvcCateCd
	 */
	public String getSEvSvcCateCd() {
		return this.sEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return bzcEvrUsrId
	 */
	public String getBzcEvrUsrId() {
		return this.bzcEvrUsrId;
	}
	
	/**
	 * Column Info
	 * @return perEvrUsrNm
	 */
	public String getPerEvrUsrNm() {
		return this.perEvrUsrNm;
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
	 * @return evrUsrId
	 */
	public String getEvrUsrId() {
		return this.evrUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param evKndCd
	 */
	public void setEvKndCd(String evKndCd) {
		this.evKndCd = evKndCd;
	}
	
	/**
	 * Column Info
	 * @param isinput
	 */
	public void setIsinput(String isinput) {
		this.isinput = isinput;
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
	 * @param perEvrUsrId
	 */
	public void setPerEvrUsrId(String perEvrUsrId) {
		this.perEvrUsrId = perEvrUsrId;
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
	 * @param bzcEvrUsrNm
	 */
	public void setBzcEvrUsrNm(String bzcEvrUsrNm) {
		this.bzcEvrUsrNm = bzcEvrUsrNm;
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
	 * @param sEgOfcCd
	 */
	public void setSEgOfcCd(String sEgOfcCd) {
		this.sEgOfcCd = sEgOfcCd;
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
	 * @param egNm
	 */
	public void setEgNm(String egNm) {
		this.egNm = egNm;
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
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param evKndSeq
	 */
	public void setEvKndSeq(String evKndSeq) {
		this.evKndSeq = evKndSeq;
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
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
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
	 * @param sEvSvcCateCd
	 */
	public void setSEvSvcCateCd(String sEvSvcCateCd) {
		this.sEvSvcCateCd = sEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param bzcEvrUsrId
	 */
	public void setBzcEvrUsrId(String bzcEvrUsrId) {
		this.bzcEvrUsrId = bzcEvrUsrId;
	}
	
	/**
	 * Column Info
	 * @param perEvrUsrNm
	 */
	public void setPerEvrUsrNm(String perEvrUsrNm) {
		this.perEvrUsrNm = perEvrUsrNm;
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
	 * @param evrUsrId
	 */
	public void setEvrUsrId(String evrUsrId) {
		this.evrUsrId = evrUsrId;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setEvKndCd(JSPUtil.getParameter(request, prefix + "ev_knd_cd", ""));
		setIsinput(JSPUtil.getParameter(request, prefix + "isinput", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setPerEvrUsrId(JSPUtil.getParameter(request, prefix + "per_evr_usr_id", ""));
		setEgRhqCd(JSPUtil.getParameter(request, prefix + "eg_rhq_cd", ""));
		setBzcEvrUsrNm(JSPUtil.getParameter(request, prefix + "bzc_evr_usr_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSEgOfcCd(JSPUtil.getParameter(request, prefix + "s_eg_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEgNm(JSPUtil.getParameter(request, prefix + "eg_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setEvKndSeq(JSPUtil.getParameter(request, prefix + "ev_knd_seq", ""));
		setSEgRhqCd(JSPUtil.getParameter(request, prefix + "s_eg_rhq_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setEgOfcCd(JSPUtil.getParameter(request, prefix + "eg_ofc_cd", ""));
		setSEvSvcCateCd(JSPUtil.getParameter(request, prefix + "s_ev_svc_cate_cd", ""));
		setBzcEvrUsrId(JSPUtil.getParameter(request, prefix + "bzc_evr_usr_id", ""));
		setPerEvrUsrNm(JSPUtil.getParameter(request, prefix + "per_evr_usr_nm", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
		setEvrUsrId(JSPUtil.getParameter(request, prefix + "evr_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpeEGEVMappingVO[]
	 */
	public SpeEGEVMappingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpeEGEVMappingVO[]
	 */
	public SpeEGEVMappingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpeEGEVMappingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] evKndCd = (JSPUtil.getParameter(request, prefix	+ "ev_knd_cd", length));
			String[] isinput = (JSPUtil.getParameter(request, prefix	+ "isinput", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] perEvrUsrId = (JSPUtil.getParameter(request, prefix	+ "per_evr_usr_id", length));
			String[] egRhqCd = (JSPUtil.getParameter(request, prefix	+ "eg_rhq_cd", length));
			String[] bzcEvrUsrNm = (JSPUtil.getParameter(request, prefix	+ "bzc_evr_usr_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sEgOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] egNm = (JSPUtil.getParameter(request, prefix	+ "eg_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] evKndSeq = (JSPUtil.getParameter(request, prefix	+ "ev_knd_seq", length));
			String[] sEgRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_rhq_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] egOfcCd = (JSPUtil.getParameter(request, prefix	+ "eg_ofc_cd", length));
			String[] sEvSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "s_ev_svc_cate_cd", length));
			String[] bzcEvrUsrId = (JSPUtil.getParameter(request, prefix	+ "bzc_evr_usr_id", length));
			String[] perEvrUsrNm = (JSPUtil.getParameter(request, prefix	+ "per_evr_usr_nm", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			String[] evrUsrId = (JSPUtil.getParameter(request, prefix	+ "evr_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpeEGEVMappingVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (evKndCd[i] != null)
					model.setEvKndCd(evKndCd[i]);
				if (isinput[i] != null)
					model.setIsinput(isinput[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (perEvrUsrId[i] != null)
					model.setPerEvrUsrId(perEvrUsrId[i]);
				if (egRhqCd[i] != null)
					model.setEgRhqCd(egRhqCd[i]);
				if (bzcEvrUsrNm[i] != null)
					model.setBzcEvrUsrNm(bzcEvrUsrNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sEgOfcCd[i] != null)
					model.setSEgOfcCd(sEgOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (egNm[i] != null)
					model.setEgNm(egNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (evKndSeq[i] != null)
					model.setEvKndSeq(evKndSeq[i]);
				if (sEgRhqCd[i] != null)
					model.setSEgRhqCd(sEgRhqCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (egOfcCd[i] != null)
					model.setEgOfcCd(egOfcCd[i]);
				if (sEvSvcCateCd[i] != null)
					model.setSEvSvcCateCd(sEvSvcCateCd[i]);
				if (bzcEvrUsrId[i] != null)
					model.setBzcEvrUsrId(bzcEvrUsrId[i]);
				if (perEvrUsrNm[i] != null)
					model.setPerEvrUsrNm(perEvrUsrNm[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				if (evrUsrId[i] != null)
					model.setEvrUsrId(evrUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpeEGEVMappingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpeEGEVMappingVO[]
	 */
	public SpeEGEVMappingVO[] getSpeEGEVMappingVOs(){
		SpeEGEVMappingVO[] vos = (SpeEGEVMappingVO[])models.toArray(new SpeEGEVMappingVO[models.size()]);
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
		this.evKndCd = this.evKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isinput = this.isinput .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perEvrUsrId = this.perEvrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egRhqCd = this.egRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcEvrUsrNm = this.bzcEvrUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgOfcCd = this.sEgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egNm = this.egNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evKndSeq = this.evKndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgRhqCd = this.sEgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egOfcCd = this.egOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvSvcCateCd = this.sEvSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcEvrUsrId = this.bzcEvrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perEvrUsrNm = this.perEvrUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evrUsrId = this.evrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
