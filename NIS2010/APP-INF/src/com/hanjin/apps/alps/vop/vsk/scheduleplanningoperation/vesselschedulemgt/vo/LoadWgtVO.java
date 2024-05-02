/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LoadWgtVO.java
*@FileTitle : LoadWgtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.07.27 정진우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LoadWgtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LoadWgtVO> models = new ArrayList<LoadWgtVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String wgtVslCd = null;
	/* Column Info */
	private String callIndCd = null;
	/* Column Info */
	private String col01 = null;
	/* Column Info */
	private String leftTitle = null;
	/* Column Info */
	private String col03 = null;
	/* Column Info */
	private String col02 = null;
	/* Column Info */
	private String ballast = null;
	/* Column Info */
	private String col05 = null;
	/* Column Info */
	private String col04 = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String col06 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String displacement = null;
	/* Column Info */
	private String cargoWeight = null;
	/* Column Info */
	private String wgtPortCd = null;
	/* Column Info */
	private String constant = null;
	/* Column Info */
	private String postType = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String dieselOil = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String fuelOil = null;
	/* Column Info */
	private String freshWater = null;
	/* Column Info */
	private String wgtSkdDirCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String wgtClptIndSeq = null;
	/* Column Info */
	private String wgtSkdVoyNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LoadWgtVO() {}

	public LoadWgtVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsEtaDt, String vpsEtdDt, String callIndCd, String postType, String vpsPortCd, String clptIndSeq, String locCd, String constant, String fuelOil, String dieselOil, String freshWater, String ballast, String displacement, String cargoWeight, String wgtPortCd, String wgtVslCd, String wgtSkdVoyNo, String wgtSkdDirCd, String wgtClptIndSeq, String leftTitle, String col01, String col02, String col03, String col04, String col05, String col06) {
		this.vslCd = vslCd;
		this.wgtVslCd = wgtVslCd;
		this.callIndCd = callIndCd;
		this.col01 = col01;
		this.leftTitle = leftTitle;
		this.col03 = col03;
		this.col02 = col02;
		this.ballast = ballast;
		this.col05 = col05;
		this.col04 = col04;
		this.vpsEtaDt = vpsEtaDt;
		this.col06 = col06;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.displacement = displacement;
		this.cargoWeight = cargoWeight;
		this.wgtPortCd = wgtPortCd;
		this.constant = constant;
		this.postType = postType;
		this.vpsEtdDt = vpsEtdDt;
		this.skdVoyNo = skdVoyNo;
		this.dieselOil = dieselOil;
		this.skdDirCd = skdDirCd;
		this.fuelOil = fuelOil;
		this.freshWater = freshWater;
		this.wgtSkdDirCd = wgtSkdDirCd;
		this.clptIndSeq = clptIndSeq;
		this.wgtClptIndSeq = wgtClptIndSeq;
		this.wgtSkdVoyNo = wgtSkdVoyNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("wgt_vsl_cd", getWgtVslCd());
		this.hashColumns.put("call_ind_cd", getCallIndCd());
		this.hashColumns.put("col01", getCol01());
		this.hashColumns.put("left_title", getLeftTitle());
		this.hashColumns.put("col03", getCol03());
		this.hashColumns.put("col02", getCol02());
		this.hashColumns.put("ballast", getBallast());
		this.hashColumns.put("col05", getCol05());
		this.hashColumns.put("col04", getCol04());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("col06", getCol06());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("displacement", getDisplacement());
		this.hashColumns.put("cargo_weight", getCargoWeight());
		this.hashColumns.put("wgt_port_cd", getWgtPortCd());
		this.hashColumns.put("constant", getConstant());
		this.hashColumns.put("post_type", getPostType());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("diesel_oil", getDieselOil());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("fuel_oil", getFuelOil());
		this.hashColumns.put("fresh_water", getFreshWater());
		this.hashColumns.put("wgt_skd_dir_cd", getWgtSkdDirCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("wgt_clpt_ind_seq", getWgtClptIndSeq());
		this.hashColumns.put("wgt_skd_voy_no", getWgtSkdVoyNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("wgt_vsl_cd", "wgtVslCd");
		this.hashFields.put("call_ind_cd", "callIndCd");
		this.hashFields.put("col01", "col01");
		this.hashFields.put("left_title", "leftTitle");
		this.hashFields.put("col03", "col03");
		this.hashFields.put("col02", "col02");
		this.hashFields.put("ballast", "ballast");
		this.hashFields.put("col05", "col05");
		this.hashFields.put("col04", "col04");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("col06", "col06");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("displacement", "displacement");
		this.hashFields.put("cargo_weight", "cargoWeight");
		this.hashFields.put("wgt_port_cd", "wgtPortCd");
		this.hashFields.put("constant", "constant");
		this.hashFields.put("post_type", "postType");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("diesel_oil", "dieselOil");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("fuel_oil", "fuelOil");
		this.hashFields.put("fresh_water", "freshWater");
		this.hashFields.put("wgt_skd_dir_cd", "wgtSkdDirCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("wgt_clpt_ind_seq", "wgtClptIndSeq");
		this.hashFields.put("wgt_skd_voy_no", "wgtSkdVoyNo");
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
	 * @return wgtVslCd
	 */
	public String getWgtVslCd() {
		return this.wgtVslCd;
	}
	
	/**
	 * Column Info
	 * @return callIndCd
	 */
	public String getCallIndCd() {
		return this.callIndCd;
	}
	
	/**
	 * Column Info
	 * @return col01
	 */
	public String getCol01() {
		return this.col01;
	}
	
	/**
	 * Column Info
	 * @return leftTitle
	 */
	public String getLeftTitle() {
		return this.leftTitle;
	}
	
	/**
	 * Column Info
	 * @return col03
	 */
	public String getCol03() {
		return this.col03;
	}
	
	/**
	 * Column Info
	 * @return col02
	 */
	public String getCol02() {
		return this.col02;
	}
	
	/**
	 * Column Info
	 * @return ballast
	 */
	public String getBallast() {
		return this.ballast;
	}
	
	/**
	 * Column Info
	 * @return col05
	 */
	public String getCol05() {
		return this.col05;
	}
	
	/**
	 * Column Info
	 * @return col04
	 */
	public String getCol04() {
		return this.col04;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return col06
	 */
	public String getCol06() {
		return this.col06;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return displacement
	 */
	public String getDisplacement() {
		return this.displacement;
	}
	
	/**
	 * Column Info
	 * @return cargoWeight
	 */
	public String getCargoWeight() {
		return this.cargoWeight;
	}
	
	/**
	 * Column Info
	 * @return wgtPortCd
	 */
	public String getWgtPortCd() {
		return this.wgtPortCd;
	}
	
	/**
	 * Column Info
	 * @return constant
	 */
	public String getConstant() {
		return this.constant;
	}
	
	/**
	 * Column Info
	 * @return postType
	 */
	public String getPostType() {
		return this.postType;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return dieselOil
	 */
	public String getDieselOil() {
		return this.dieselOil;
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
	 * @return fuelOil
	 */
	public String getFuelOil() {
		return this.fuelOil;
	}
	
	/**
	 * Column Info
	 * @return freshWater
	 */
	public String getFreshWater() {
		return this.freshWater;
	}
	
	/**
	 * Column Info
	 * @return wgtSkdDirCd
	 */
	public String getWgtSkdDirCd() {
		return this.wgtSkdDirCd;
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
	 * @return wgtClptIndSeq
	 */
	public String getWgtClptIndSeq() {
		return this.wgtClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return wgtSkdVoyNo
	 */
	public String getWgtSkdVoyNo() {
		return this.wgtSkdVoyNo;
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
	 * @param wgtVslCd
	 */
	public void setWgtVslCd(String wgtVslCd) {
		this.wgtVslCd = wgtVslCd;
	}
	
	/**
	 * Column Info
	 * @param callIndCd
	 */
	public void setCallIndCd(String callIndCd) {
		this.callIndCd = callIndCd;
	}
	
	/**
	 * Column Info
	 * @param col01
	 */
	public void setCol01(String col01) {
		this.col01 = col01;
	}
	
	/**
	 * Column Info
	 * @param leftTitle
	 */
	public void setLeftTitle(String leftTitle) {
		this.leftTitle = leftTitle;
	}
	
	/**
	 * Column Info
	 * @param col03
	 */
	public void setCol03(String col03) {
		this.col03 = col03;
	}
	
	/**
	 * Column Info
	 * @param col02
	 */
	public void setCol02(String col02) {
		this.col02 = col02;
	}
	
	/**
	 * Column Info
	 * @param ballast
	 */
	public void setBallast(String ballast) {
		this.ballast = ballast;
	}
	
	/**
	 * Column Info
	 * @param col05
	 */
	public void setCol05(String col05) {
		this.col05 = col05;
	}
	
	/**
	 * Column Info
	 * @param col04
	 */
	public void setCol04(String col04) {
		this.col04 = col04;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param col06
	 */
	public void setCol06(String col06) {
		this.col06 = col06;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param displacement
	 */
	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}
	
	/**
	 * Column Info
	 * @param cargoWeight
	 */
	public void setCargoWeight(String cargoWeight) {
		this.cargoWeight = cargoWeight;
	}
	
	/**
	 * Column Info
	 * @param wgtPortCd
	 */
	public void setWgtPortCd(String wgtPortCd) {
		this.wgtPortCd = wgtPortCd;
	}
	
	/**
	 * Column Info
	 * @param constant
	 */
	public void setConstant(String constant) {
		this.constant = constant;
	}
	
	/**
	 * Column Info
	 * @param postType
	 */
	public void setPostType(String postType) {
		this.postType = postType;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param dieselOil
	 */
	public void setDieselOil(String dieselOil) {
		this.dieselOil = dieselOil;
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
	 * @param fuelOil
	 */
	public void setFuelOil(String fuelOil) {
		this.fuelOil = fuelOil;
	}
	
	/**
	 * Column Info
	 * @param freshWater
	 */
	public void setFreshWater(String freshWater) {
		this.freshWater = freshWater;
	}
	
	/**
	 * Column Info
	 * @param wgtSkdDirCd
	 */
	public void setWgtSkdDirCd(String wgtSkdDirCd) {
		this.wgtSkdDirCd = wgtSkdDirCd;
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
	 * @param wgtClptIndSeq
	 */
	public void setWgtClptIndSeq(String wgtClptIndSeq) {
		this.wgtClptIndSeq = wgtClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param wgtSkdVoyNo
	 */
	public void setWgtSkdVoyNo(String wgtSkdVoyNo) {
		this.wgtSkdVoyNo = wgtSkdVoyNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setWgtVslCd(JSPUtil.getParameter(request, "wgt_vsl_cd", ""));
		setCallIndCd(JSPUtil.getParameter(request, "call_ind_cd", ""));
		setCol01(JSPUtil.getParameter(request, "col01", ""));
		setLeftTitle(JSPUtil.getParameter(request, "left_title", ""));
		setCol03(JSPUtil.getParameter(request, "col03", ""));
		setCol02(JSPUtil.getParameter(request, "col02", ""));
		setBallast(JSPUtil.getParameter(request, "ballast", ""));
		setCol05(JSPUtil.getParameter(request, "col05", ""));
		setCol04(JSPUtil.getParameter(request, "col04", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setCol06(JSPUtil.getParameter(request, "col06", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDisplacement(JSPUtil.getParameter(request, "displacement", ""));
		setCargoWeight(JSPUtil.getParameter(request, "cargo_weight", ""));
		setWgtPortCd(JSPUtil.getParameter(request, "wgt_port_cd", ""));
		setConstant(JSPUtil.getParameter(request, "constant", ""));
		setPostType(JSPUtil.getParameter(request, "post_type", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setDieselOil(JSPUtil.getParameter(request, "diesel_oil", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setFuelOil(JSPUtil.getParameter(request, "fuel_oil", ""));
		setFreshWater(JSPUtil.getParameter(request, "fresh_water", ""));
		setWgtSkdDirCd(JSPUtil.getParameter(request, "wgt_skd_dir_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setWgtClptIndSeq(JSPUtil.getParameter(request, "wgt_clpt_ind_seq", ""));
		setWgtSkdVoyNo(JSPUtil.getParameter(request, "wgt_skd_voy_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LoadWgtVO[]
	 */
	public LoadWgtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LoadWgtVO[]
	 */
	public LoadWgtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LoadWgtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] wgtVslCd = (JSPUtil.getParameter(request, prefix	+ "wgt_vsl_cd", length));
			String[] callIndCd = (JSPUtil.getParameter(request, prefix	+ "call_ind_cd", length));
			String[] col01 = (JSPUtil.getParameter(request, prefix	+ "col01", length));
			String[] leftTitle = (JSPUtil.getParameter(request, prefix	+ "left_title", length));
			String[] col03 = (JSPUtil.getParameter(request, prefix	+ "col03", length));
			String[] col02 = (JSPUtil.getParameter(request, prefix	+ "col02", length));
			String[] ballast = (JSPUtil.getParameter(request, prefix	+ "ballast", length));
			String[] col05 = (JSPUtil.getParameter(request, prefix	+ "col05", length));
			String[] col04 = (JSPUtil.getParameter(request, prefix	+ "col04", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] col06 = (JSPUtil.getParameter(request, prefix	+ "col06", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] displacement = (JSPUtil.getParameter(request, prefix	+ "displacement", length));
			String[] cargoWeight = (JSPUtil.getParameter(request, prefix	+ "cargo_weight", length));
			String[] wgtPortCd = (JSPUtil.getParameter(request, prefix	+ "wgt_port_cd", length));
			String[] constant = (JSPUtil.getParameter(request, prefix	+ "constant", length));
			String[] postType = (JSPUtil.getParameter(request, prefix	+ "post_type", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] dieselOil = (JSPUtil.getParameter(request, prefix	+ "diesel_oil", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] fuelOil = (JSPUtil.getParameter(request, prefix	+ "fuel_oil", length));
			String[] freshWater = (JSPUtil.getParameter(request, prefix	+ "fresh_water", length));
			String[] wgtSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "wgt_skd_dir_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] wgtClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "wgt_clpt_ind_seq", length));
			String[] wgtSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "wgt_skd_voy_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new LoadWgtVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (wgtVslCd[i] != null)
					model.setWgtVslCd(wgtVslCd[i]);
				if (callIndCd[i] != null)
					model.setCallIndCd(callIndCd[i]);
				if (col01[i] != null)
					model.setCol01(col01[i]);
				if (leftTitle[i] != null)
					model.setLeftTitle(leftTitle[i]);
				if (col03[i] != null)
					model.setCol03(col03[i]);
				if (col02[i] != null)
					model.setCol02(col02[i]);
				if (ballast[i] != null)
					model.setBallast(ballast[i]);
				if (col05[i] != null)
					model.setCol05(col05[i]);
				if (col04[i] != null)
					model.setCol04(col04[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (col06[i] != null)
					model.setCol06(col06[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (displacement[i] != null)
					model.setDisplacement(displacement[i]);
				if (cargoWeight[i] != null)
					model.setCargoWeight(cargoWeight[i]);
				if (wgtPortCd[i] != null)
					model.setWgtPortCd(wgtPortCd[i]);
				if (constant[i] != null)
					model.setConstant(constant[i]);
				if (postType[i] != null)
					model.setPostType(postType[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (dieselOil[i] != null)
					model.setDieselOil(dieselOil[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (fuelOil[i] != null)
					model.setFuelOil(fuelOil[i]);
				if (freshWater[i] != null)
					model.setFreshWater(freshWater[i]);
				if (wgtSkdDirCd[i] != null)
					model.setWgtSkdDirCd(wgtSkdDirCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (wgtClptIndSeq[i] != null)
					model.setWgtClptIndSeq(wgtClptIndSeq[i]);
				if (wgtSkdVoyNo[i] != null)
					model.setWgtSkdVoyNo(wgtSkdVoyNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLoadWgtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LoadWgtVO[]
	 */
	public LoadWgtVO[] getLoadWgtVOs(){
		LoadWgtVO[] vos = (LoadWgtVO[])models.toArray(new LoadWgtVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtVslCd = this.wgtVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callIndCd = this.callIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col01 = this.col01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leftTitle = this.leftTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col03 = this.col03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col02 = this.col02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ballast = this.ballast .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col05 = this.col05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col04 = this.col04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col06 = this.col06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.displacement = this.displacement .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoWeight = this.cargoWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtPortCd = this.wgtPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.constant = this.constant .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postType = this.postType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dieselOil = this.dieselOil .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelOil = this.fuelOil .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freshWater = this.freshWater .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtSkdDirCd = this.wgtSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtClptIndSeq = this.wgtClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtSkdVoyNo = this.wgtSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
