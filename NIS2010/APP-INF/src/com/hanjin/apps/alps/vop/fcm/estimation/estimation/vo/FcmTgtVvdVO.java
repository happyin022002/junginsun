/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FcmTgtVvdVO.java
*@FileTitle : FcmTgtVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.23 진마리아 
* 1.0 Creation
* 
* History
* 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmTgtVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmTgtVvdVO> models = new ArrayList<FcmTgtVvdVO>();
	
	/* Column Info */
	private String trndLineTpCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String toFlg = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String endPortCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String doilEstmCsmWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fuelCalcErrFlg = null;
	/* Column Info */
	private String doilMonEndCsmWgt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String foilVvdEndCsmWgt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String endDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String doilVvdEndCsmWgt = null;
	/* Column Info */
	private String stDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String fcmBztpCd = null;
	/* Column Info */
	private String cntrDznCapa = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String foilEstmCsmWgt = null;
	/* Column Info */
	private String stPortCd = null;
	/* Column Info */
	private String foilMonEndCsmWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmTgtVvdVO() {}

	public FcmTgtVvdVO(String ibflag, String pagerows, String fcmBztpCd, String revYrmon, String rlaneCd, String vslCd, String skdVoyNo, String skdDirCd, String crrCd, String toFlg, String fuelCalcErrFlg, String cntrDznCapa, String trndLineTpCd, String stPortCd, String stDt, String endPortCd, String endDt, String foilVvdEndCsmWgt, String foilMonEndCsmWgt, String foilEstmCsmWgt, String doilVvdEndCsmWgt, String doilMonEndCsmWgt, String doilEstmCsmWgt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.trndLineTpCd = trndLineTpCd;
		this.vslCd = vslCd;
		this.creDt = creDt;
		this.rlaneCd = rlaneCd;
		this.toFlg = toFlg;
		this.crrCd = crrCd;
		this.endPortCd = endPortCd;
		this.pagerows = pagerows;
		this.doilEstmCsmWgt = doilEstmCsmWgt;
		this.ibflag = ibflag;
		this.fuelCalcErrFlg = fuelCalcErrFlg;
		this.doilMonEndCsmWgt = doilMonEndCsmWgt;
		this.updUsrId = updUsrId;
		this.foilVvdEndCsmWgt = foilVvdEndCsmWgt;
		this.updDt = updDt;
		this.revYrmon = revYrmon;
		this.endDt = endDt;
		this.skdVoyNo = skdVoyNo;
		this.doilVvdEndCsmWgt = doilVvdEndCsmWgt;
		this.stDt = stDt;
		this.skdDirCd = skdDirCd;
		this.fcmBztpCd = fcmBztpCd;
		this.cntrDznCapa = cntrDznCapa;
		this.creUsrId = creUsrId;
		this.foilEstmCsmWgt = foilEstmCsmWgt;
		this.stPortCd = stPortCd;
		this.foilMonEndCsmWgt = foilMonEndCsmWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trnd_line_tp_cd", getTrndLineTpCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("to_flg", getToFlg());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("end_port_cd", getEndPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("doil_estm_csm_wgt", getDoilEstmCsmWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fuel_calc_err_flg", getFuelCalcErrFlg());
		this.hashColumns.put("doil_mon_end_csm_wgt", getDoilMonEndCsmWgt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("foil_vvd_end_csm_wgt", getFoilVvdEndCsmWgt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("end_dt", getEndDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("doil_vvd_end_csm_wgt", getDoilVvdEndCsmWgt());
		this.hashColumns.put("st_dt", getStDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("fcm_bztp_cd", getFcmBztpCd());
		this.hashColumns.put("cntr_dzn_capa", getCntrDznCapa());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("foil_estm_csm_wgt", getFoilEstmCsmWgt());
		this.hashColumns.put("st_port_cd", getStPortCd());
		this.hashColumns.put("foil_mon_end_csm_wgt", getFoilMonEndCsmWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trnd_line_tp_cd", "trndLineTpCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("to_flg", "toFlg");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("end_port_cd", "endPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("doil_estm_csm_wgt", "doilEstmCsmWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fuel_calc_err_flg", "fuelCalcErrFlg");
		this.hashFields.put("doil_mon_end_csm_wgt", "doilMonEndCsmWgt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("foil_vvd_end_csm_wgt", "foilVvdEndCsmWgt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("end_dt", "endDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("doil_vvd_end_csm_wgt", "doilVvdEndCsmWgt");
		this.hashFields.put("st_dt", "stDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("fcm_bztp_cd", "fcmBztpCd");
		this.hashFields.put("cntr_dzn_capa", "cntrDznCapa");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("foil_estm_csm_wgt", "foilEstmCsmWgt");
		this.hashFields.put("st_port_cd", "stPortCd");
		this.hashFields.put("foil_mon_end_csm_wgt", "foilMonEndCsmWgt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trndLineTpCd
	 */
	public String getTrndLineTpCd() {
		return this.trndLineTpCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return toFlg
	 */
	public String getToFlg() {
		return this.toFlg;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return endPortCd
	 */
	public String getEndPortCd() {
		return this.endPortCd;
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
	 * @return doilEstmCsmWgt
	 */
	public String getDoilEstmCsmWgt() {
		return this.doilEstmCsmWgt;
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
	 * @return fuelCalcErrFlg
	 */
	public String getFuelCalcErrFlg() {
		return this.fuelCalcErrFlg;
	}
	
	/**
	 * Column Info
	 * @return doilMonEndCsmWgt
	 */
	public String getDoilMonEndCsmWgt() {
		return this.doilMonEndCsmWgt;
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
	 * @return foilVvdEndCsmWgt
	 */
	public String getFoilVvdEndCsmWgt() {
		return this.foilVvdEndCsmWgt;
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
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return endDt
	 */
	public String getEndDt() {
		return this.endDt;
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
	 * @return doilVvdEndCsmWgt
	 */
	public String getDoilVvdEndCsmWgt() {
		return this.doilVvdEndCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return stDt
	 */
	public String getStDt() {
		return this.stDt;
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
	 * @return fcmBztpCd
	 */
	public String getFcmBztpCd() {
		return this.fcmBztpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrDznCapa
	 */
	public String getCntrDznCapa() {
		return this.cntrDznCapa;
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
	 * @return foilEstmCsmWgt
	 */
	public String getFoilEstmCsmWgt() {
		return this.foilEstmCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return stPortCd
	 */
	public String getStPortCd() {
		return this.stPortCd;
	}
	
	/**
	 * Column Info
	 * @return foilMonEndCsmWgt
	 */
	public String getFoilMonEndCsmWgt() {
		return this.foilMonEndCsmWgt;
	}
	

	/**
	 * Column Info
	 * @param trndLineTpCd
	 */
	public void setTrndLineTpCd(String trndLineTpCd) {
		this.trndLineTpCd = trndLineTpCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param toFlg
	 */
	public void setToFlg(String toFlg) {
		this.toFlg = toFlg;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param endPortCd
	 */
	public void setEndPortCd(String endPortCd) {
		this.endPortCd = endPortCd;
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
	 * @param doilEstmCsmWgt
	 */
	public void setDoilEstmCsmWgt(String doilEstmCsmWgt) {
		this.doilEstmCsmWgt = doilEstmCsmWgt;
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
	 * @param fuelCalcErrFlg
	 */
	public void setFuelCalcErrFlg(String fuelCalcErrFlg) {
		this.fuelCalcErrFlg = fuelCalcErrFlg;
	}
	
	/**
	 * Column Info
	 * @param doilMonEndCsmWgt
	 */
	public void setDoilMonEndCsmWgt(String doilMonEndCsmWgt) {
		this.doilMonEndCsmWgt = doilMonEndCsmWgt;
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
	 * @param foilVvdEndCsmWgt
	 */
	public void setFoilVvdEndCsmWgt(String foilVvdEndCsmWgt) {
		this.foilVvdEndCsmWgt = foilVvdEndCsmWgt;
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
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
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
	 * @param doilVvdEndCsmWgt
	 */
	public void setDoilVvdEndCsmWgt(String doilVvdEndCsmWgt) {
		this.doilVvdEndCsmWgt = doilVvdEndCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param stDt
	 */
	public void setStDt(String stDt) {
		this.stDt = stDt;
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
	 * @param fcmBztpCd
	 */
	public void setFcmBztpCd(String fcmBztpCd) {
		this.fcmBztpCd = fcmBztpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrDznCapa
	 */
	public void setCntrDznCapa(String cntrDznCapa) {
		this.cntrDznCapa = cntrDznCapa;
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
	 * @param foilEstmCsmWgt
	 */
	public void setFoilEstmCsmWgt(String foilEstmCsmWgt) {
		this.foilEstmCsmWgt = foilEstmCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param stPortCd
	 */
	public void setStPortCd(String stPortCd) {
		this.stPortCd = stPortCd;
	}
	
	/**
	 * Column Info
	 * @param foilMonEndCsmWgt
	 */
	public void setFoilMonEndCsmWgt(String foilMonEndCsmWgt) {
		this.foilMonEndCsmWgt = foilMonEndCsmWgt;
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
		setTrndLineTpCd(JSPUtil.getParameter(request, prefix + "trnd_line_tp_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setToFlg(JSPUtil.getParameter(request, prefix + "to_flg", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setEndPortCd(JSPUtil.getParameter(request, prefix + "end_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDoilEstmCsmWgt(JSPUtil.getParameter(request, prefix + "doil_estm_csm_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFuelCalcErrFlg(JSPUtil.getParameter(request, prefix + "fuel_calc_err_flg", ""));
		setDoilMonEndCsmWgt(JSPUtil.getParameter(request, prefix + "doil_mon_end_csm_wgt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFoilVvdEndCsmWgt(JSPUtil.getParameter(request, prefix + "foil_vvd_end_csm_wgt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setEndDt(JSPUtil.getParameter(request, prefix + "end_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setDoilVvdEndCsmWgt(JSPUtil.getParameter(request, prefix + "doil_vvd_end_csm_wgt", ""));
		setStDt(JSPUtil.getParameter(request, prefix + "st_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setFcmBztpCd(JSPUtil.getParameter(request, prefix + "fcm_bztp_cd", ""));
		setCntrDznCapa(JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFoilEstmCsmWgt(JSPUtil.getParameter(request, prefix + "foil_estm_csm_wgt", ""));
		setStPortCd(JSPUtil.getParameter(request, prefix + "st_port_cd", ""));
		setFoilMonEndCsmWgt(JSPUtil.getParameter(request, prefix + "foil_mon_end_csm_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmTgtVvdVO[]
	 */
	public FcmTgtVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmTgtVvdVO[]
	 */
	public FcmTgtVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmTgtVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trndLineTpCd = (JSPUtil.getParameter(request, prefix	+ "trnd_line_tp_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] toFlg = (JSPUtil.getParameter(request, prefix	+ "to_flg", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] endPortCd = (JSPUtil.getParameter(request, prefix	+ "end_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] doilEstmCsmWgt = (JSPUtil.getParameter(request, prefix	+ "doil_estm_csm_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fuelCalcErrFlg = (JSPUtil.getParameter(request, prefix	+ "fuel_calc_err_flg", length));
			String[] doilMonEndCsmWgt = (JSPUtil.getParameter(request, prefix	+ "doil_mon_end_csm_wgt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] foilVvdEndCsmWgt = (JSPUtil.getParameter(request, prefix	+ "foil_vvd_end_csm_wgt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] endDt = (JSPUtil.getParameter(request, prefix	+ "end_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] doilVvdEndCsmWgt = (JSPUtil.getParameter(request, prefix	+ "doil_vvd_end_csm_wgt", length));
			String[] stDt = (JSPUtil.getParameter(request, prefix	+ "st_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] fcmBztpCd = (JSPUtil.getParameter(request, prefix	+ "fcm_bztp_cd", length));
			String[] cntrDznCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_dzn_capa", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] foilEstmCsmWgt = (JSPUtil.getParameter(request, prefix	+ "foil_estm_csm_wgt", length));
			String[] stPortCd = (JSPUtil.getParameter(request, prefix	+ "st_port_cd", length));
			String[] foilMonEndCsmWgt = (JSPUtil.getParameter(request, prefix	+ "foil_mon_end_csm_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmTgtVvdVO();
				if (trndLineTpCd[i] != null)
					model.setTrndLineTpCd(trndLineTpCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (toFlg[i] != null)
					model.setToFlg(toFlg[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (endPortCd[i] != null)
					model.setEndPortCd(endPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (doilEstmCsmWgt[i] != null)
					model.setDoilEstmCsmWgt(doilEstmCsmWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fuelCalcErrFlg[i] != null)
					model.setFuelCalcErrFlg(fuelCalcErrFlg[i]);
				if (doilMonEndCsmWgt[i] != null)
					model.setDoilMonEndCsmWgt(doilMonEndCsmWgt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (foilVvdEndCsmWgt[i] != null)
					model.setFoilVvdEndCsmWgt(foilVvdEndCsmWgt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (endDt[i] != null)
					model.setEndDt(endDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (doilVvdEndCsmWgt[i] != null)
					model.setDoilVvdEndCsmWgt(doilVvdEndCsmWgt[i]);
				if (stDt[i] != null)
					model.setStDt(stDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (fcmBztpCd[i] != null)
					model.setFcmBztpCd(fcmBztpCd[i]);
				if (cntrDznCapa[i] != null)
					model.setCntrDznCapa(cntrDznCapa[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (foilEstmCsmWgt[i] != null)
					model.setFoilEstmCsmWgt(foilEstmCsmWgt[i]);
				if (stPortCd[i] != null)
					model.setStPortCd(stPortCd[i]);
				if (foilMonEndCsmWgt[i] != null)
					model.setFoilMonEndCsmWgt(foilMonEndCsmWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmTgtVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmTgtVvdVO[]
	 */
	public FcmTgtVvdVO[] getFcmTgtVvdVOs(){
		FcmTgtVvdVO[] vos = (FcmTgtVvdVO[])models.toArray(new FcmTgtVvdVO[models.size()]);
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
		this.trndLineTpCd = this.trndLineTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toFlg = this.toFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endPortCd = this.endPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilEstmCsmWgt = this.doilEstmCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelCalcErrFlg = this.fuelCalcErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilMonEndCsmWgt = this.doilMonEndCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilVvdEndCsmWgt = this.foilVvdEndCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDt = this.endDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilVvdEndCsmWgt = this.doilVvdEndCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stDt = this.stDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcmBztpCd = this.fcmBztpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDznCapa = this.cntrDznCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilEstmCsmWgt = this.foilEstmCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stPortCd = this.stPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilMonEndCsmWgt = this.foilMonEndCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
