/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : VIPAgreementVO.java
 * @FileTitle : VIPAgreementVO
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2016.07.27
 * @LastModifier : 
 * @LastVersion : 1.0
 * 2016.07.27 김상현 1.0 Creation.
 * 2016.08.05 김상현 [CHM-201642499] ALPS > ACM VIP Agreement Creation 상 SC/RFA No. 추가 요청
 */

package com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo;

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
 * Table Value Object.
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VIPAgreementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VIPAgreementVO> models = new ArrayList<VIPAgreementVO>();
	
	/* Column Info */
	private String podRoutCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String podGrpTpCd = null;
	/* Column Info */
	private String porRoutCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String delGrpTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String porGrpTpCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vipBkgRt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String polGrpTpCd = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String delRoutCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String polRoutCd = null;
	/* Column Info */
	private String cntrTpszGrpNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VIPAgreementVO() {}

	public VIPAgreementVO(String ibflag, String pagerows, String podRoutCd, String podGrpTpCd, String porRoutCd, String updUsrId, String hulBndCd, String creUsrId, String custGrpId, String delGrpTpCd, String toEffDt, String agmtSeq, String porGrpTpCd, String deltFlg, String custGrpNm, String creDt, String vipBkgRt, String trdCd, String polGrpTpCd, String fmEffDt, String subTrdCd, String delRoutCd, String dirCd, String updDt, String polRoutCd, String cntrTpszGrpNm, String scNo, String rfaNo, String taaNo) {
		this.podRoutCd = podRoutCd;
		this.ibflag = ibflag;
		this.scNo = scNo;
		this.podGrpTpCd = podGrpTpCd;
		this.porRoutCd = porRoutCd;
		this.updUsrId = updUsrId;
		this.hulBndCd = hulBndCd;
		this.creUsrId = creUsrId;
		this.custGrpId = custGrpId;
		this.delGrpTpCd = delGrpTpCd;
		this.pagerows = pagerows;
		this.toEffDt = toEffDt;
		this.taaNo = taaNo;
		this.agmtSeq = agmtSeq;
		this.porGrpTpCd = porGrpTpCd;
		this.deltFlg = deltFlg;
		this.custGrpNm = custGrpNm;
		this.creDt = creDt;
		this.vipBkgRt = vipBkgRt;
		this.trdCd = trdCd;
		this.polGrpTpCd = polGrpTpCd;
		this.fmEffDt = fmEffDt;
		this.subTrdCd = subTrdCd;
		this.rfaNo = rfaNo;
		this.delRoutCd = delRoutCd;
		this.dirCd = dirCd;
		this.updDt = updDt;
		this.polRoutCd = polRoutCd;
		this.cntrTpszGrpNm = cntrTpszGrpNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_rout_cd", getPodRoutCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("pod_grp_tp_cd", getPodGrpTpCd());
		this.hashColumns.put("por_rout_cd", getPorRoutCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("del_grp_tp_cd", getDelGrpTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("por_grp_tp_cd", getPorGrpTpCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vip_bkg_rt", getVipBkgRt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("pol_grp_tp_cd", getPolGrpTpCd());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("del_rout_cd", getDelRoutCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pol_rout_cd", getPolRoutCd());
		this.hashColumns.put("cntr_tpsz_grp_nm", getCntrTpszGrpNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_rout_cd", "podRoutCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("pod_grp_tp_cd", "podGrpTpCd");
		this.hashFields.put("por_rout_cd", "porRoutCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("del_grp_tp_cd", "delGrpTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("por_grp_tp_cd", "porGrpTpCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vip_bkg_rt", "vipBkgRt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("pol_grp_tp_cd", "polGrpTpCd");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("del_rout_cd", "delRoutCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pol_rout_cd", "polRoutCd");
		this.hashFields.put("cntr_tpsz_grp_nm", "cntrTpszGrpNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return podRoutCd
	 */
	public String getPodRoutCd() {
		return this.podRoutCd;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return podGrpTpCd
	 */
	public String getPodGrpTpCd() {
		return this.podGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return porRoutCd
	 */
	public String getPorRoutCd() {
		return this.porRoutCd;
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
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
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
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
	}
	
	/**
	 * Column Info
	 * @return delGrpTpCd
	 */
	public String getDelGrpTpCd() {
		return this.delGrpTpCd;
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
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
	}
	
	/**
	 * Column Info
	 * @return taaNo
	 */
	public String getTaaNo() {
		return this.taaNo;
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
	 * @return porGrpTpCd
	 */
	public String getPorGrpTpCd() {
		return this.porGrpTpCd;
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
	 * @return custGrpNm
	 */
	public String getCustGrpNm() {
		return this.custGrpNm;
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
	 * @return vipBkgRt
	 */
	public String getVipBkgRt() {
		return this.vipBkgRt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return polGrpTpCd
	 */
	public String getPolGrpTpCd() {
		return this.polGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return delRoutCd
	 */
	public String getDelRoutCd() {
		return this.delRoutCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
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
	 * @return polRoutCd
	 */
	public String getPolRoutCd() {
		return this.polRoutCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszGrpNm
	 */
	public String getCntrTpszGrpNm() {
		return this.cntrTpszGrpNm;
	}
	

	/**
	 * Column Info
	 * @param podRoutCd
	 */
	public void setPodRoutCd(String podRoutCd) {
		this.podRoutCd = podRoutCd;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param podGrpTpCd
	 */
	public void setPodGrpTpCd(String podGrpTpCd) {
		this.podGrpTpCd = podGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param porRoutCd
	 */
	public void setPorRoutCd(String porRoutCd) {
		this.porRoutCd = porRoutCd;
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
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
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
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
	}
	
	/**
	 * Column Info
	 * @param delGrpTpCd
	 */
	public void setDelGrpTpCd(String delGrpTpCd) {
		this.delGrpTpCd = delGrpTpCd;
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
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}
	
	/**
	 * Column Info
	 * @param taaNo
	 */
	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
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
	 * @param porGrpTpCd
	 */
	public void setPorGrpTpCd(String porGrpTpCd) {
		this.porGrpTpCd = porGrpTpCd;
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
	 * @param custGrpNm
	 */
	public void setCustGrpNm(String custGrpNm) {
		this.custGrpNm = custGrpNm;
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
	 * @param vipBkgRt
	 */
	public void setVipBkgRt(String vipBkgRt) {
		this.vipBkgRt = vipBkgRt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param polGrpTpCd
	 */
	public void setPolGrpTpCd(String polGrpTpCd) {
		this.polGrpTpCd = polGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param delRoutCd
	 */
	public void setDelRoutCd(String delRoutCd) {
		this.delRoutCd = delRoutCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
	 * @param polRoutCd
	 */
	public void setPolRoutCd(String polRoutCd) {
		this.polRoutCd = polRoutCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszGrpNm
	 */
	public void setCntrTpszGrpNm(String cntrTpszGrpNm) {
		this.cntrTpszGrpNm = cntrTpszGrpNm;
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
		setPodRoutCd(JSPUtil.getParameter(request, prefix + "pod_rout_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setPodGrpTpCd(JSPUtil.getParameter(request, prefix + "pod_grp_tp_cd", ""));
		setPorRoutCd(JSPUtil.getParameter(request, prefix + "por_rout_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setDelGrpTpCd(JSPUtil.getParameter(request, prefix + "del_grp_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setToEffDt(JSPUtil.getParameter(request, prefix + "to_eff_dt", ""));
		setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setPorGrpTpCd(JSPUtil.getParameter(request, prefix + "por_grp_tp_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVipBkgRt(JSPUtil.getParameter(request, prefix + "vip_bkg_rt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setPolGrpTpCd(JSPUtil.getParameter(request, prefix + "pol_grp_tp_cd", ""));
		setFmEffDt(JSPUtil.getParameter(request, prefix + "fm_eff_dt", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setDelRoutCd(JSPUtil.getParameter(request, prefix + "del_rout_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPolRoutCd(JSPUtil.getParameter(request, prefix + "pol_rout_cd", ""));
		setCntrTpszGrpNm(JSPUtil.getParameter(request, prefix + "cntr_tpsz_grp_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VIPAgreementVO[]
	 */
	public VIPAgreementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VIPAgreementVO[]
	 */
	public VIPAgreementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VIPAgreementVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podRoutCd = (JSPUtil.getParameter(request, prefix	+ "pod_rout_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] podGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "pod_grp_tp_cd", length));
			String[] porRoutCd = (JSPUtil.getParameter(request, prefix	+ "por_rout_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] delGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "del_grp_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] porGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "por_grp_tp_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vipBkgRt = (JSPUtil.getParameter(request, prefix	+ "vip_bkg_rt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] polGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "pol_grp_tp_cd", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] delRoutCd = (JSPUtil.getParameter(request, prefix	+ "del_rout_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] polRoutCd = (JSPUtil.getParameter(request, prefix	+ "pol_rout_cd", length));
			String[] cntrTpszGrpNm = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_grp_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new VIPAgreementVO();
				if (podRoutCd[i] != null)
					model.setPodRoutCd(podRoutCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (podGrpTpCd[i] != null)
					model.setPodGrpTpCd(podGrpTpCd[i]);
				if (porRoutCd[i] != null)
					model.setPorRoutCd(porRoutCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (delGrpTpCd[i] != null)
					model.setDelGrpTpCd(delGrpTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (porGrpTpCd[i] != null)
					model.setPorGrpTpCd(porGrpTpCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vipBkgRt[i] != null)
					model.setVipBkgRt(vipBkgRt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (polGrpTpCd[i] != null)
					model.setPolGrpTpCd(polGrpTpCd[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (delRoutCd[i] != null)
					model.setDelRoutCd(delRoutCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (polRoutCd[i] != null)
					model.setPolRoutCd(polRoutCd[i]);
				if (cntrTpszGrpNm[i] != null)
					model.setCntrTpszGrpNm(cntrTpszGrpNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVIPAgreementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VIPAgreementVO[]
	 */
	public VIPAgreementVO[] getVIPAgreementVOs(){
		VIPAgreementVO[] vos = (VIPAgreementVO[])models.toArray(new VIPAgreementVO[models.size()]);
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
		this.podRoutCd = this.podRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podGrpTpCd = this.podGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porRoutCd = this.porRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delGrpTpCd = this.delGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porGrpTpCd = this.porGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipBkgRt = this.vipBkgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polGrpTpCd = this.polGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delRoutCd = this.delRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polRoutCd = this.polRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszGrpNm = this.cntrTpszGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
