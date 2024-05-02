/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VskVslSkdPhsIoHisVO.java
*@FileTitle : VskVslSkdPhsIoHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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

public class VskVslSkdPhsIoHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VskVslSkdPhsIoHisVO> models = new ArrayList<VskVslSkdPhsIoHisVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String refSkdVoyNo = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String refClptSeq = null;
	/* Column Info */
	private String refClptIndSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pfSvcTpCd = null;
	/* Column Info */
	private String refYdCd = null;
	/* Column Info */
	private String refVpsPortCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String refSkdDirCd = null;
	/* Column Info */
	private String refVslCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String pfPortRotnSeq = null;
	/* Column Info */
	private String skdCngStsCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String refPfSvcTpCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String refVslSlanCd = null;
	/* Column Info */
	private String refPortRotnSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VskVslSkdPhsIoHisVO() {}

	public VskVslSkdPhsIoHisVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptIndSeq, String clptSeq, String ydCd, String vslSlanCd, String slanCd, String skdCngStsCd, String pfSvcTpCd, String pfPortRotnSeq, String refVslCd, String refSkdVoyNo, String refSkdDirCd, String refVpsPortCd, String refClptIndSeq, String refClptSeq, String refYdCd, String refVslSlanCd, String refPfSvcTpCd, String refPortRotnSeq, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vslCd = vslCd;
		this.creDt = creDt;
		this.refSkdVoyNo = refSkdVoyNo;
		this.vslSlanCd = vslSlanCd;
		this.refClptSeq = refClptSeq;
		this.refClptIndSeq = refClptIndSeq;
		this.pagerows = pagerows;
		this.clptSeq = clptSeq;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.pfSvcTpCd = pfSvcTpCd;
		this.refYdCd = refYdCd;
		this.refVpsPortCd = refVpsPortCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.refSkdDirCd = refSkdDirCd;
		this.refVslCd = refVslCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.creUsrId = creUsrId;
		this.pfPortRotnSeq = pfPortRotnSeq;
		this.skdCngStsCd = skdCngStsCd;
		this.slanCd = slanCd;
		this.refPfSvcTpCd = refPfSvcTpCd;
		this.ydCd = ydCd;
		this.clptIndSeq = clptIndSeq;
		this.refVslSlanCd = refVslSlanCd;
		this.refPortRotnSeq = refPortRotnSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ref_skd_voy_no", getRefSkdVoyNo());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("ref_clpt_seq", getRefClptSeq());
		this.hashColumns.put("ref_clpt_ind_seq", getRefClptIndSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
		this.hashColumns.put("ref_yd_cd", getRefYdCd());
		this.hashColumns.put("ref_vps_port_cd", getRefVpsPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ref_skd_dir_cd", getRefSkdDirCd());
		this.hashColumns.put("ref_vsl_cd", getRefVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pf_port_rotn_seq", getPfPortRotnSeq());
		this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("ref_pf_svc_tp_cd", getRefPfSvcTpCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("ref_vsl_slan_cd", getRefVslSlanCd());
		this.hashColumns.put("ref_port_rotn_seq", getRefPortRotnSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ref_skd_voy_no", "refSkdVoyNo");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("ref_clpt_seq", "refClptSeq");
		this.hashFields.put("ref_clpt_ind_seq", "refClptIndSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
		this.hashFields.put("ref_yd_cd", "refYdCd");
		this.hashFields.put("ref_vps_port_cd", "refVpsPortCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ref_skd_dir_cd", "refSkdDirCd");
		this.hashFields.put("ref_vsl_cd", "refVslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pf_port_rotn_seq", "pfPortRotnSeq");
		this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("ref_pf_svc_tp_cd", "refPfSvcTpCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("ref_vsl_slan_cd", "refVslSlanCd");
		this.hashFields.put("ref_port_rotn_seq", "refPortRotnSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return refSkdVoyNo
	 */
	public String getRefSkdVoyNo() {
		return this.refSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return refClptSeq
	 */
	public String getRefClptSeq() {
		return this.refClptSeq;
	}
	
	/**
	 * Column Info
	 * @return refClptIndSeq
	 */
	public String getRefClptIndSeq() {
		return this.refClptIndSeq;
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
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return pfSvcTpCd
	 */
	public String getPfSvcTpCd() {
		return this.pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return refYdCd
	 */
	public String getRefYdCd() {
		return this.refYdCd;
	}
	
	/**
	 * Column Info
	 * @return refVpsPortCd
	 */
	public String getRefVpsPortCd() {
		return this.refVpsPortCd;
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
	 * @return refSkdDirCd
	 */
	public String getRefSkdDirCd() {
		return this.refSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return refVslCd
	 */
	public String getRefVslCd() {
		return this.refVslCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return pfPortRotnSeq
	 */
	public String getPfPortRotnSeq() {
		return this.pfPortRotnSeq;
	}
	
	/**
	 * Column Info
	 * @return skdCngStsCd
	 */
	public String getSkdCngStsCd() {
		return this.skdCngStsCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return refPfSvcTpCd
	 */
	public String getRefPfSvcTpCd() {
		return this.refPfSvcTpCd;
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
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return refVslSlanCd
	 */
	public String getRefVslSlanCd() {
		return this.refVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return refPortRotnSeq
	 */
	public String getRefPortRotnSeq() {
		return this.refPortRotnSeq;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param refSkdVoyNo
	 */
	public void setRefSkdVoyNo(String refSkdVoyNo) {
		this.refSkdVoyNo = refSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param refClptSeq
	 */
	public void setRefClptSeq(String refClptSeq) {
		this.refClptSeq = refClptSeq;
	}
	
	/**
	 * Column Info
	 * @param refClptIndSeq
	 */
	public void setRefClptIndSeq(String refClptIndSeq) {
		this.refClptIndSeq = refClptIndSeq;
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
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param pfSvcTpCd
	 */
	public void setPfSvcTpCd(String pfSvcTpCd) {
		this.pfSvcTpCd = pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param refYdCd
	 */
	public void setRefYdCd(String refYdCd) {
		this.refYdCd = refYdCd;
	}
	
	/**
	 * Column Info
	 * @param refVpsPortCd
	 */
	public void setRefVpsPortCd(String refVpsPortCd) {
		this.refVpsPortCd = refVpsPortCd;
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
	 * @param refSkdDirCd
	 */
	public void setRefSkdDirCd(String refSkdDirCd) {
		this.refSkdDirCd = refSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param refVslCd
	 */
	public void setRefVslCd(String refVslCd) {
		this.refVslCd = refVslCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param pfPortRotnSeq
	 */
	public void setPfPortRotnSeq(String pfPortRotnSeq) {
		this.pfPortRotnSeq = pfPortRotnSeq;
	}
	
	/**
	 * Column Info
	 * @param skdCngStsCd
	 */
	public void setSkdCngStsCd(String skdCngStsCd) {
		this.skdCngStsCd = skdCngStsCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param refPfSvcTpCd
	 */
	public void setRefPfSvcTpCd(String refPfSvcTpCd) {
		this.refPfSvcTpCd = refPfSvcTpCd;
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
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param refVslSlanCd
	 */
	public void setRefVslSlanCd(String refVslSlanCd) {
		this.refVslSlanCd = refVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param refPortRotnSeq
	 */
	public void setRefPortRotnSeq(String refPortRotnSeq) {
		this.refPortRotnSeq = refPortRotnSeq;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRefSkdVoyNo(JSPUtil.getParameter(request, prefix + "ref_skd_voy_no", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setRefClptSeq(JSPUtil.getParameter(request, prefix + "ref_clpt_seq", ""));
		setRefClptIndSeq(JSPUtil.getParameter(request, prefix + "ref_clpt_ind_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, prefix + "pf_svc_tp_cd", ""));
		setRefYdCd(JSPUtil.getParameter(request, prefix + "ref_yd_cd", ""));
		setRefVpsPortCd(JSPUtil.getParameter(request, prefix + "ref_vps_port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRefSkdDirCd(JSPUtil.getParameter(request, prefix + "ref_skd_dir_cd", ""));
		setRefVslCd(JSPUtil.getParameter(request, prefix + "ref_vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPfPortRotnSeq(JSPUtil.getParameter(request, prefix + "pf_port_rotn_seq", ""));
		setSkdCngStsCd(JSPUtil.getParameter(request, prefix + "skd_cng_sts_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setRefPfSvcTpCd(JSPUtil.getParameter(request, prefix + "ref_pf_svc_tp_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setRefVslSlanCd(JSPUtil.getParameter(request, prefix + "ref_vsl_slan_cd", ""));
		setRefPortRotnSeq(JSPUtil.getParameter(request, prefix + "ref_port_rotn_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskVslSkdPhsIoHisVO[]
	 */
	public VskVslSkdPhsIoHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskVslSkdPhsIoHisVO[]
	 */
	public VskVslSkdPhsIoHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskVslSkdPhsIoHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] refSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "ref_skd_voy_no", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] refClptSeq = (JSPUtil.getParameter(request, prefix	+ "ref_clpt_seq", length));
			String[] refClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "ref_clpt_ind_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_svc_tp_cd", length));
			String[] refYdCd = (JSPUtil.getParameter(request, prefix	+ "ref_yd_cd", length));
			String[] refVpsPortCd = (JSPUtil.getParameter(request, prefix	+ "ref_vps_port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] refSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "ref_skd_dir_cd", length));
			String[] refVslCd = (JSPUtil.getParameter(request, prefix	+ "ref_vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] pfPortRotnSeq = (JSPUtil.getParameter(request, prefix	+ "pf_port_rotn_seq", length));
			String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_sts_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] refPfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "ref_pf_svc_tp_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] refVslSlanCd = (JSPUtil.getParameter(request, prefix	+ "ref_vsl_slan_cd", length));
			String[] refPortRotnSeq = (JSPUtil.getParameter(request, prefix	+ "ref_port_rotn_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new VskVslSkdPhsIoHisVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (refSkdVoyNo[i] != null)
					model.setRefSkdVoyNo(refSkdVoyNo[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (refClptSeq[i] != null)
					model.setRefClptSeq(refClptSeq[i]);
				if (refClptIndSeq[i] != null)
					model.setRefClptIndSeq(refClptIndSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pfSvcTpCd[i] != null)
					model.setPfSvcTpCd(pfSvcTpCd[i]);
				if (refYdCd[i] != null)
					model.setRefYdCd(refYdCd[i]);
				if (refVpsPortCd[i] != null)
					model.setRefVpsPortCd(refVpsPortCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (refSkdDirCd[i] != null)
					model.setRefSkdDirCd(refSkdDirCd[i]);
				if (refVslCd[i] != null)
					model.setRefVslCd(refVslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (pfPortRotnSeq[i] != null)
					model.setPfPortRotnSeq(pfPortRotnSeq[i]);
				if (skdCngStsCd[i] != null)
					model.setSkdCngStsCd(skdCngStsCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (refPfSvcTpCd[i] != null)
					model.setRefPfSvcTpCd(refPfSvcTpCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (refVslSlanCd[i] != null)
					model.setRefVslSlanCd(refVslSlanCd[i]);
				if (refPortRotnSeq[i] != null)
					model.setRefPortRotnSeq(refPortRotnSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskVslSkdPhsIoHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskVslSkdPhsIoHisVO[]
	 */
	public VskVslSkdPhsIoHisVO[] getVskVslSkdPhsIoHisVOs(){
		VskVslSkdPhsIoHisVO[] vos = (VskVslSkdPhsIoHisVO[])models.toArray(new VskVslSkdPhsIoHisVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSkdVoyNo = this.refSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refClptSeq = this.refClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refClptIndSeq = this.refClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSvcTpCd = this.pfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refYdCd = this.refYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refVpsPortCd = this.refVpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSkdDirCd = this.refSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refVslCd = this.refVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfPortRotnSeq = this.pfPortRotnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngStsCd = this.skdCngStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refPfSvcTpCd = this.refPfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refVslSlanCd = this.refVslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refPortRotnSeq = this.refPortRotnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
