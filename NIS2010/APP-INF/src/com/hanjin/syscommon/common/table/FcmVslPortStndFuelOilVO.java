/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FcmVslPortStndFuelOilVO.java
*@FileTitle : FcmVslPortStndFuelOilVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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

public class FcmVslPortStndFuelOilVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmVslPortStndFuelOilVO> models = new ArrayList<FcmVslPortStndFuelOilVO>();
	
	/* Column Info */
	private String initPortFoilCsm = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String opmzSeaTmHrs = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String opmzDist = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pfSeaTmHrs = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actPortFoilCsm = null;
	/* Column Info */
	private String trndLinePortFoilCsm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String opmzSeaSpd = null;
	/* Column Info */
	private String rvisFoilCsm = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rvisPortFoilCsm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String trndLineFoilCsm = null;
	/* Column Info */
	private String initFoilCsm = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String actFoilCsm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FcmVslPortStndFuelOilVO() {}

	public FcmVslPortStndFuelOilVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptIndSeq, String vslSlanCd, String ydCd, String initFoilCsm, String rvisFoilCsm, String trndLineFoilCsm, String actFoilCsm, String opmzDist, String opmzSeaSpd, String pfSeaTmHrs, String opmzSeaTmHrs, String creUsrId, String creDt, String updUsrId, String updDt, String initPortFoilCsm, String rvisPortFoilCsm, String trndLinePortFoilCsm, String actPortFoilCsm) {
		this.initPortFoilCsm = initPortFoilCsm;
		this.vslCd = vslCd;
		this.opmzSeaTmHrs = opmzSeaTmHrs;
		this.creDt = creDt;
		this.opmzDist = opmzDist;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
		this.pfSeaTmHrs = pfSeaTmHrs;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.actPortFoilCsm = actPortFoilCsm;
		this.trndLinePortFoilCsm = trndLinePortFoilCsm;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.opmzSeaSpd = opmzSeaSpd;
		this.rvisFoilCsm = rvisFoilCsm;
		this.skdVoyNo = skdVoyNo;
		this.rvisPortFoilCsm = rvisPortFoilCsm;
		this.skdDirCd = skdDirCd;
		this.creUsrId = creUsrId;
		this.trndLineFoilCsm = trndLineFoilCsm;
		this.initFoilCsm = initFoilCsm;
		this.ydCd = ydCd;
		this.clptIndSeq = clptIndSeq;
		this.actFoilCsm = actFoilCsm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("init_port_foil_csm", getInitPortFoilCsm());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("opmz_sea_tm_hrs", getOpmzSeaTmHrs());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("opmz_dist", getOpmzDist());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pf_sea_tm_hrs", getPfSeaTmHrs());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_port_foil_csm", getActPortFoilCsm());
		this.hashColumns.put("trnd_line_port_foil_csm", getTrndLinePortFoilCsm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("opmz_sea_spd", getOpmzSeaSpd());
		this.hashColumns.put("rvis_foil_csm", getRvisFoilCsm());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rvis_port_foil_csm", getRvisPortFoilCsm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("trnd_line_foil_csm", getTrndLineFoilCsm());
		this.hashColumns.put("init_foil_csm", getInitFoilCsm());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("act_foil_csm", getActFoilCsm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("init_port_foil_csm", "initPortFoilCsm");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("opmz_sea_tm_hrs", "opmzSeaTmHrs");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("opmz_dist", "opmzDist");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pf_sea_tm_hrs", "pfSeaTmHrs");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_port_foil_csm", "actPortFoilCsm");
		this.hashFields.put("trnd_line_port_foil_csm", "trndLinePortFoilCsm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("opmz_sea_spd", "opmzSeaSpd");
		this.hashFields.put("rvis_foil_csm", "rvisFoilCsm");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rvis_port_foil_csm", "rvisPortFoilCsm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("trnd_line_foil_csm", "trndLineFoilCsm");
		this.hashFields.put("init_foil_csm", "initFoilCsm");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("act_foil_csm", "actFoilCsm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return initPortFoilCsm
	 */
	public String getInitPortFoilCsm() {
		return this.initPortFoilCsm;
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
	 * @return opmzSeaTmHrs
	 */
	public String getOpmzSeaTmHrs() {
		return this.opmzSeaTmHrs;
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
	 * @return opmzDist
	 */
	public String getOpmzDist() {
		return this.opmzDist;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return pfSeaTmHrs
	 */
	public String getPfSeaTmHrs() {
		return this.pfSeaTmHrs;
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
	 * @return actPortFoilCsm
	 */
	public String getActPortFoilCsm() {
		return this.actPortFoilCsm;
	}
	
	/**
	 * Column Info
	 * @return trndLinePortFoilCsm
	 */
	public String getTrndLinePortFoilCsm() {
		return this.trndLinePortFoilCsm;
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
	 * @return opmzSeaSpd
	 */
	public String getOpmzSeaSpd() {
		return this.opmzSeaSpd;
	}
	
	/**
	 * Column Info
	 * @return rvisFoilCsm
	 */
	public String getRvisFoilCsm() {
		return this.rvisFoilCsm;
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
	 * @return rvisPortFoilCsm
	 */
	public String getRvisPortFoilCsm() {
		return this.rvisPortFoilCsm;
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
	 * @return trndLineFoilCsm
	 */
	public String getTrndLineFoilCsm() {
		return this.trndLineFoilCsm;
	}
	
	/**
	 * Column Info
	 * @return initFoilCsm
	 */
	public String getInitFoilCsm() {
		return this.initFoilCsm;
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
	 * @return actFoilCsm
	 */
	public String getActFoilCsm() {
		return this.actFoilCsm;
	}
	

	/**
	 * Column Info
	 * @param initPortFoilCsm
	 */
	public void setInitPortFoilCsm(String initPortFoilCsm) {
		this.initPortFoilCsm = initPortFoilCsm;
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
	 * @param opmzSeaTmHrs
	 */
	public void setOpmzSeaTmHrs(String opmzSeaTmHrs) {
		this.opmzSeaTmHrs = opmzSeaTmHrs;
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
	 * @param opmzDist
	 */
	public void setOpmzDist(String opmzDist) {
		this.opmzDist = opmzDist;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param pfSeaTmHrs
	 */
	public void setPfSeaTmHrs(String pfSeaTmHrs) {
		this.pfSeaTmHrs = pfSeaTmHrs;
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
	 * @param actPortFoilCsm
	 */
	public void setActPortFoilCsm(String actPortFoilCsm) {
		this.actPortFoilCsm = actPortFoilCsm;
	}
	
	/**
	 * Column Info
	 * @param trndLinePortFoilCsm
	 */
	public void setTrndLinePortFoilCsm(String trndLinePortFoilCsm) {
		this.trndLinePortFoilCsm = trndLinePortFoilCsm;
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
	 * @param opmzSeaSpd
	 */
	public void setOpmzSeaSpd(String opmzSeaSpd) {
		this.opmzSeaSpd = opmzSeaSpd;
	}
	
	/**
	 * Column Info
	 * @param rvisFoilCsm
	 */
	public void setRvisFoilCsm(String rvisFoilCsm) {
		this.rvisFoilCsm = rvisFoilCsm;
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
	 * @param rvisPortFoilCsm
	 */
	public void setRvisPortFoilCsm(String rvisPortFoilCsm) {
		this.rvisPortFoilCsm = rvisPortFoilCsm;
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
	 * @param trndLineFoilCsm
	 */
	public void setTrndLineFoilCsm(String trndLineFoilCsm) {
		this.trndLineFoilCsm = trndLineFoilCsm;
	}
	
	/**
	 * Column Info
	 * @param initFoilCsm
	 */
	public void setInitFoilCsm(String initFoilCsm) {
		this.initFoilCsm = initFoilCsm;
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
	 * @param actFoilCsm
	 */
	public void setActFoilCsm(String actFoilCsm) {
		this.actFoilCsm = actFoilCsm;
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
		setInitPortFoilCsm(JSPUtil.getParameter(request, prefix + "init_port_foil_csm", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setOpmzSeaTmHrs(JSPUtil.getParameter(request, prefix + "opmz_sea_tm_hrs", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setOpmzDist(JSPUtil.getParameter(request, prefix + "opmz_dist", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPfSeaTmHrs(JSPUtil.getParameter(request, prefix + "pf_sea_tm_hrs", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActPortFoilCsm(JSPUtil.getParameter(request, prefix + "act_port_foil_csm", ""));
		setTrndLinePortFoilCsm(JSPUtil.getParameter(request, prefix + "trnd_line_port_foil_csm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setOpmzSeaSpd(JSPUtil.getParameter(request, prefix + "opmz_sea_spd", ""));
		setRvisFoilCsm(JSPUtil.getParameter(request, prefix + "rvis_foil_csm", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setRvisPortFoilCsm(JSPUtil.getParameter(request, prefix + "rvis_port_foil_csm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTrndLineFoilCsm(JSPUtil.getParameter(request, prefix + "trnd_line_foil_csm", ""));
		setInitFoilCsm(JSPUtil.getParameter(request, prefix + "init_foil_csm", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setActFoilCsm(JSPUtil.getParameter(request, prefix + "act_foil_csm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmVslPortStndFuelOilVO[]
	 */
	public FcmVslPortStndFuelOilVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmVslPortStndFuelOilVO[]
	 */
	public FcmVslPortStndFuelOilVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmVslPortStndFuelOilVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] initPortFoilCsm = (JSPUtil.getParameter(request, prefix	+ "init_port_foil_csm", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] opmzSeaTmHrs = (JSPUtil.getParameter(request, prefix	+ "opmz_sea_tm_hrs", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] opmzDist = (JSPUtil.getParameter(request, prefix	+ "opmz_dist", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pfSeaTmHrs = (JSPUtil.getParameter(request, prefix	+ "pf_sea_tm_hrs", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actPortFoilCsm = (JSPUtil.getParameter(request, prefix	+ "act_port_foil_csm", length));
			String[] trndLinePortFoilCsm = (JSPUtil.getParameter(request, prefix	+ "trnd_line_port_foil_csm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] opmzSeaSpd = (JSPUtil.getParameter(request, prefix	+ "opmz_sea_spd", length));
			String[] rvisFoilCsm = (JSPUtil.getParameter(request, prefix	+ "rvis_foil_csm", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rvisPortFoilCsm = (JSPUtil.getParameter(request, prefix	+ "rvis_port_foil_csm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] trndLineFoilCsm = (JSPUtil.getParameter(request, prefix	+ "trnd_line_foil_csm", length));
			String[] initFoilCsm = (JSPUtil.getParameter(request, prefix	+ "init_foil_csm", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] actFoilCsm = (JSPUtil.getParameter(request, prefix	+ "act_foil_csm", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmVslPortStndFuelOilVO();
				if (initPortFoilCsm[i] != null)
					model.setInitPortFoilCsm(initPortFoilCsm[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (opmzSeaTmHrs[i] != null)
					model.setOpmzSeaTmHrs(opmzSeaTmHrs[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (opmzDist[i] != null)
					model.setOpmzDist(opmzDist[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pfSeaTmHrs[i] != null)
					model.setPfSeaTmHrs(pfSeaTmHrs[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actPortFoilCsm[i] != null)
					model.setActPortFoilCsm(actPortFoilCsm[i]);
				if (trndLinePortFoilCsm[i] != null)
					model.setTrndLinePortFoilCsm(trndLinePortFoilCsm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (opmzSeaSpd[i] != null)
					model.setOpmzSeaSpd(opmzSeaSpd[i]);
				if (rvisFoilCsm[i] != null)
					model.setRvisFoilCsm(rvisFoilCsm[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rvisPortFoilCsm[i] != null)
					model.setRvisPortFoilCsm(rvisPortFoilCsm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (trndLineFoilCsm[i] != null)
					model.setTrndLineFoilCsm(trndLineFoilCsm[i]);
				if (initFoilCsm[i] != null)
					model.setInitFoilCsm(initFoilCsm[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (actFoilCsm[i] != null)
					model.setActFoilCsm(actFoilCsm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmVslPortStndFuelOilVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmVslPortStndFuelOilVO[]
	 */
	public FcmVslPortStndFuelOilVO[] getFcmVslPortStndFuelOilVOs(){
		FcmVslPortStndFuelOilVO[] vos = (FcmVslPortStndFuelOilVO[])models.toArray(new FcmVslPortStndFuelOilVO[models.size()]);
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
		this.initPortFoilCsm = this.initPortFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opmzSeaTmHrs = this.opmzSeaTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opmzDist = this.opmzDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSeaTmHrs = this.pfSeaTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPortFoilCsm = this.actPortFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLinePortFoilCsm = this.trndLinePortFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opmzSeaSpd = this.opmzSeaSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisFoilCsm = this.rvisFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisPortFoilCsm = this.rvisPortFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineFoilCsm = this.trndLineFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initFoilCsm = this.initFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFoilCsm = this.actFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
