/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ReversedPortInfoVO.java
*@FileTitle : ReversedPortInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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

public class ReversedPortInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReversedPortInfoVO> models = new ArrayList<ReversedPortInfoVO>();
	
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String nxtSkdDirCd = null;
	/* Column Info */
	private String nxtSkdVoyNo = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null; 
	/* Column Info */
	private String clptSeq = null;
		/* Column Info */
	private String preSkdVoyNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nxtVpsPortCd = null;
	/* Column Info */
	private String preRvsExistFlg = null;
	/* Column Info */
	private String nxtVslCd = null;
	/* Column Info */
	private String nxtRvsExistFlg = null;
	/* Column Info */
	private String etaEtbRvsExistFlg = null;
	/* Column Info */
	private String etbEtdRvsExistFlg = null;
	/* Column Info */
	private String preVpsPortCd = null;
	/* Column Info */
	private String preEtdDt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String preClptIndSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String nxtEtaDt = null;
	/* Column Info */ 
	private String skdDirCd = null;
	/* Column Info */
	private String preSkdDirCd = null;
	/* Column Info */
	private String nxtClptIndSeq = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String preVslCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ReversedPortInfoVO() {}

	public ReversedPortInfoVO(String ibflag, String pagerows, String preVslCd, String preSkdVoyNo, String preSkdDirCd, String preVpsPortCd, String preClptIndSeq, String preEtdDt, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptIndSeq, String clptSeq, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String nxtVslCd, String nxtSkdVoyNo, String nxtSkdDirCd, String nxtVpsPortCd, String nxtClptIndSeq, String nxtEtaDt, String preRvsExistFlg
			               , String nxtRvsExistFlg, String etaEtbRvsExistFlg, String etbEtdRvsExistFlg) {
		this.vslCd = vslCd;
		this.vpsEtbDt = vpsEtbDt;
		this.nxtSkdDirCd = nxtSkdDirCd;
		this.nxtSkdVoyNo = nxtSkdVoyNo;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.clptSeq = clptSeq;
		this.preSkdVoyNo = preSkdVoyNo;
		this.ibflag = ibflag;
		this.nxtVpsPortCd = nxtVpsPortCd;
		this.preRvsExistFlg = preRvsExistFlg;
		this.nxtVslCd = nxtVslCd;
		this.nxtRvsExistFlg = nxtRvsExistFlg;
		this.preVpsPortCd = preVpsPortCd;
		this.preEtdDt = preEtdDt;
		this.vpsEtdDt = vpsEtdDt;
		this.preClptIndSeq = preClptIndSeq;
		this.skdVoyNo = skdVoyNo;
		this.nxtEtaDt = nxtEtaDt;
		this.skdDirCd = skdDirCd;
		this.preSkdDirCd = preSkdDirCd;
		this.nxtClptIndSeq = nxtClptIndSeq;
		this.clptIndSeq = clptIndSeq;
		this.preVslCd = preVslCd;
		this.etaEtbRvsExistFlg = etaEtbRvsExistFlg;
		this.etbEtdRvsExistFlg = etbEtdRvsExistFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("nxt_skd_dir_cd", getNxtSkdDirCd());
		this.hashColumns.put("nxt_skd_voy_no", getNxtSkdVoyNo());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("pre_skd_voy_no", getPreSkdVoyNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("nxt_vps_port_cd", getNxtVpsPortCd());
		this.hashColumns.put("pre_rvs_exist_flg", getPreRvsExistFlg());
		this.hashColumns.put("nxt_vsl_cd", getNxtVslCd());
		this.hashColumns.put("nxt_rvs_exist_flg", getNxtRvsExistFlg());
		this.hashColumns.put("pre_vps_port_cd", getPreVpsPortCd());
		this.hashColumns.put("pre_etd_dt", getPreEtdDt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("pre_clpt_ind_seq", getPreClptIndSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("nxt_eta_dt", getNxtEtaDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pre_skd_dir_cd", getPreSkdDirCd());
		this.hashColumns.put("nxt_clpt_ind_seq", getNxtClptIndSeq());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("pre_vsl_cd", getPreVslCd());
		this.hashColumns.put("eta_etb_rvs_exist_flg", getEtaEtbRvsExistFlg());
		this.hashColumns.put("etb_etd_rvs_exist_flg", getEtbEtdRvsExistFlg());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("nxt_skd_dir_cd", "nxtSkdDirCd");
		this.hashFields.put("nxt_skd_voy_no", "nxtSkdVoyNo");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("pre_skd_voy_no", "preSkdVoyNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("nxt_vps_port_cd", "nxtVpsPortCd");
		this.hashFields.put("pre_rvs_exist_flg", "preRvsExistFlg");
		this.hashFields.put("nxt_vsl_cd", "nxtVslCd");
		this.hashFields.put("nxt_rvs_exist_flg", "nxtRvsExistFlg");
		this.hashFields.put("pre_vps_port_cd", "preVpsPortCd");
		this.hashFields.put("pre_etd_dt", "preEtdDt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("pre_clpt_ind_seq", "preClptIndSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("nxt_eta_dt", "nxtEtaDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pre_skd_dir_cd", "preSkdDirCd");
		this.hashFields.put("nxt_clpt_ind_seq", "nxtClptIndSeq");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("pre_vsl_cd", "preVslCd");
		this.hashFields.put("eta_etb_rvs_exist_flg", "etaEtbRvsExistFlg");
		this.hashFields.put("etb_etd_rvs_exist_flg", "etbEtdRvsExistFlg");
		
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
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return nxtSkdDirCd
	 */
	public String getNxtSkdDirCd() {
		return this.nxtSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return nxtSkdVoyNo
	 */
	public String getNxtSkdVoyNo() {
		return this.nxtSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return preSkdVoyNo
	 */
	public String getPreSkdVoyNo() {
		return this.preSkdVoyNo;
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
	 * @return nxtVpsPortCd
	 */
	public String getNxtVpsPortCd() {
		return this.nxtVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return preRvsExistFlg
	 */
	public String getPreRvsExistFlg() {
		return this.preRvsExistFlg;
	}
	
	/**
	 * Column Info
	 * @return nxtVslCd
	 */
	public String getNxtVslCd() {
		return this.nxtVslCd;
	}
	
	/**
	 * Column Info
	 * @return nxtRvsExistFlg
	 */
	public String getNxtRvsExistFlg() {
		return this.nxtRvsExistFlg;
	}
	
	/**
	 * Column Info
	 * @return etaEtbRvsExistFlg
	 */
	public String getEtaEtbRvsExistFlg() {
		return this.etaEtbRvsExistFlg;
	}
	
	/**
	 * Column Info
	 * @return etbEtdRvsExistFlg
	 */
	public String getEtbEtdRvsExistFlg() {
		return this.etbEtdRvsExistFlg;
	}
	
	/**
	 * Column Info
	 * @return preVpsPortCd
	 */
	public String getPreVpsPortCd() {
		return this.preVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return preEtdDt
	 */
	public String getPreEtdDt() {
		return this.preEtdDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return preClptIndSeq
	 */
	public String getPreClptIndSeq() {
		return this.preClptIndSeq;
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
	 * @return nxtEtaDt
	 */
	public String getNxtEtaDt() {
		return this.nxtEtaDt;
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
	 * @return preSkdDirCd
	 */
	public String getPreSkdDirCd() {
		return this.preSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return nxtClptIndSeq
	 */
	public String getNxtClptIndSeq() {
		return this.nxtClptIndSeq;
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
	 * @return preVslCd
	 */
	public String getPreVslCd() {
		return this.preVslCd;
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
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param nxtSkdDirCd
	 */
	public void setNxtSkdDirCd(String nxtSkdDirCd) {
		this.nxtSkdDirCd = nxtSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param nxtSkdVoyNo
	 */
	public void setNxtSkdVoyNo(String nxtSkdVoyNo) {
		this.nxtSkdVoyNo = nxtSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param preSkdVoyNo
	 */
	public void setPreSkdVoyNo(String preSkdVoyNo) {
		this.preSkdVoyNo = preSkdVoyNo;
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
	 * @param nxtVpsPortCd
	 */
	public void setNxtVpsPortCd(String nxtVpsPortCd) {
		this.nxtVpsPortCd = nxtVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param preRvsExistFlg
	 */
	public void setPreRvsExistFlg(String preRvsExistFlg) {
		this.preRvsExistFlg = preRvsExistFlg;
	}
	
	/**
	 * Column Info
	 * @param nxtVslCd
	 */
	public void setNxtVslCd(String nxtVslCd) {
		this.nxtVslCd = nxtVslCd;
	}
	
	/**
	 * Column Info
	 * @param nxtRvsExistFlg
	 */
	public void setNxtRvsExistFlg(String nxtRvsExistFlg) {
		this.nxtRvsExistFlg = nxtRvsExistFlg;
	}
	
	/**
	 * Column Info
	 * @param etaEtbRvsExistFlg
	 */
	public void setEtaEtbRvsExistFlg(String etaEtbRvsExistFlg) {
		this.etaEtbRvsExistFlg = etaEtbRvsExistFlg;
	}
	
	/**
	 * Column Info
	 * @param etbEtdRvsExistFlg
	 */
	public void setEtbEtdRvsExistFlg(String etbEtdRvsExistFlg) {
		this.etbEtdRvsExistFlg = etbEtdRvsExistFlg;
	}
	
	/**
	 * Column Info
	 * @param preVpsPortCd
	 */
	public void setPreVpsPortCd(String preVpsPortCd) {
		this.preVpsPortCd = preVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param preEtdDt
	 */
	public void setPreEtdDt(String preEtdDt) {
		this.preEtdDt = preEtdDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param preClptIndSeq
	 */
	public void setPreClptIndSeq(String preClptIndSeq) {
		this.preClptIndSeq = preClptIndSeq;
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
	 * @param nxtEtaDt
	 */
	public void setNxtEtaDt(String nxtEtaDt) {
		this.nxtEtaDt = nxtEtaDt;
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
	 * @param preSkdDirCd
	 */
	public void setPreSkdDirCd(String preSkdDirCd) {
		this.preSkdDirCd = preSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param nxtClptIndSeq
	 */
	public void setNxtClptIndSeq(String nxtClptIndSeq) {
		this.nxtClptIndSeq = nxtClptIndSeq;
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
	 * @param preVslCd
	 */
	public void setPreVslCd(String preVslCd) {
		this.preVslCd = preVslCd;
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
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setNxtSkdDirCd(JSPUtil.getParameter(request, prefix + "nxt_skd_dir_cd", ""));
		setNxtSkdVoyNo(JSPUtil.getParameter(request, prefix + "nxt_skd_voy_no", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setPreSkdVoyNo(JSPUtil.getParameter(request, prefix + "pre_skd_voy_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNxtVpsPortCd(JSPUtil.getParameter(request, prefix + "nxt_vps_port_cd", ""));
		setPreRvsExistFlg(JSPUtil.getParameter(request, prefix + "pre_rvs_exist_flg", ""));
		setNxtVslCd(JSPUtil.getParameter(request, prefix + "nxt_vsl_cd", ""));
		setNxtRvsExistFlg(JSPUtil.getParameter(request, prefix + "nxt_rvs_exist_flg", ""));
		setPreVpsPortCd(JSPUtil.getParameter(request, prefix + "pre_vps_port_cd", ""));
		setPreEtdDt(JSPUtil.getParameter(request, prefix + "pre_etd_dt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setPreClptIndSeq(JSPUtil.getParameter(request, prefix + "pre_clpt_ind_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setNxtEtaDt(JSPUtil.getParameter(request, prefix + "nxt_eta_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPreSkdDirCd(JSPUtil.getParameter(request, prefix + "pre_skd_dir_cd", ""));
		setNxtClptIndSeq(JSPUtil.getParameter(request, prefix + "nxt_clpt_ind_seq", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setPreVslCd(JSPUtil.getParameter(request, prefix + "pre_vsl_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReversedPortInfoVO[]
	 */
	public ReversedPortInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReversedPortInfoVO[]
	 */
	public ReversedPortInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReversedPortInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] nxtSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "nxt_skd_dir_cd", length));
			String[] nxtSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "nxt_skd_voy_no", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] preSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "pre_skd_voy_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nxtVpsPortCd = (JSPUtil.getParameter(request, prefix	+ "nxt_vps_port_cd", length));
			String[] preRvsExistFlg = (JSPUtil.getParameter(request, prefix	+ "pre_rvs_exist_flg", length));
			String[] nxtVslCd = (JSPUtil.getParameter(request, prefix	+ "nxt_vsl_cd", length));
			String[] nxtRvsExistFlg = (JSPUtil.getParameter(request, prefix	+ "nxt_rvs_exist_flg", length));
			String[] preVpsPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_vps_port_cd", length));
			String[] preEtdDt = (JSPUtil.getParameter(request, prefix	+ "pre_etd_dt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] preClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pre_clpt_ind_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] nxtEtaDt = (JSPUtil.getParameter(request, prefix	+ "nxt_eta_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] preSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "pre_skd_dir_cd", length));
			String[] nxtClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "nxt_clpt_ind_seq", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] preVslCd = (JSPUtil.getParameter(request, prefix	+ "pre_vsl_cd", length));
			String[] etaEtbRvsExistFlg = (JSPUtil.getParameter(request, prefix	+ "eta_etb_rvs_exist_flg", length));
			String[] etbEtdRvsExistFlg = (JSPUtil.getParameter(request, prefix	+ "etb_etd_rvs_exist_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReversedPortInfoVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (nxtSkdDirCd[i] != null)
					model.setNxtSkdDirCd(nxtSkdDirCd[i]);
				if (nxtSkdVoyNo[i] != null)
					model.setNxtSkdVoyNo(nxtSkdVoyNo[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (preSkdVoyNo[i] != null)
					model.setPreSkdVoyNo(preSkdVoyNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nxtVpsPortCd[i] != null)
					model.setNxtVpsPortCd(nxtVpsPortCd[i]);
				if (preRvsExistFlg[i] != null)
					model.setPreRvsExistFlg(preRvsExistFlg[i]);
				if (nxtVslCd[i] != null)
					model.setNxtVslCd(nxtVslCd[i]);
				if (nxtRvsExistFlg[i] != null)
					model.setNxtRvsExistFlg(nxtRvsExistFlg[i]);
				if (preVpsPortCd[i] != null)
					model.setPreVpsPortCd(preVpsPortCd[i]);
				if (preEtdDt[i] != null)
					model.setPreEtdDt(preEtdDt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (preClptIndSeq[i] != null)
					model.setPreClptIndSeq(preClptIndSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (nxtEtaDt[i] != null)
					model.setNxtEtaDt(nxtEtaDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (preSkdDirCd[i] != null)
					model.setPreSkdDirCd(preSkdDirCd[i]);
				if (nxtClptIndSeq[i] != null)
					model.setNxtClptIndSeq(nxtClptIndSeq[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (preVslCd[i] != null)
					model.setPreVslCd(preVslCd[i]);
				if (etaEtbRvsExistFlg[i] != null)
					model.setEtaEtbRvsExistFlg(etaEtbRvsExistFlg[i]);
				if (etbEtdRvsExistFlg[i] != null)
					model.setEtbEtdRvsExistFlg(etbEtdRvsExistFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReversedPortInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReversedPortInfoVO[]
	 */
	public ReversedPortInfoVO[] getReversedPortInfoVOs(){
		ReversedPortInfoVO[] vos = (ReversedPortInfoVO[])models.toArray(new ReversedPortInfoVO[models.size()]);
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
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtSkdDirCd = this.nxtSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtSkdVoyNo = this.nxtSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSkdVoyNo = this.preSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtVpsPortCd = this.nxtVpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRvsExistFlg = this.preRvsExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtVslCd = this.nxtVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtRvsExistFlg = this.nxtRvsExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVpsPortCd = this.preVpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEtdDt = this.preEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preClptIndSeq = this.preClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtEtaDt = this.nxtEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSkdDirCd = this.preSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtClptIndSeq = this.nxtClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVslCd = this.preVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaEtbRvsExistFlg = this.etaEtbRvsExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbEtdRvsExistFlg = this.etbEtdRvsExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
