/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgVgmClzSetListVO.java
*@FileTitle : BkgVgmClzSetListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.25
*@LastModifier : 조창우
*@LastVersion : 1.0
* 2016.05.25 조창우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 조창우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgVgmClzSetListVO extends AbstractValueObject {
 
	private static final long serialVersionUID = 1L;
	
	private Collection<BkgVgmClzSetListVO> models = new ArrayList<BkgVgmClzSetListVO>();
	
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vgmItvalHrs = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String holChk = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String hour = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chkOp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String vgmClzTpCd = null;
	/* Column Info */
	private String destCntCd = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String day = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String vgmClzDyCd = null;
	/* Column Info */
	private String vgmClzDyHrs = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String vvdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgVgmClzSetListVO() {}

	public BkgVgmClzSetListVO(String ibflag, String pagerows, String vslSlanCd, String locCd, String ydCd, String destCntCd, String vgmClzTpCd, String vgmItvalHrs, String xcldHolFlg, String holChk, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String hour, String eta, String etb, String etd, String chkOp, String usrNm, String pol, String day, String ofcCd,  String vgmClzDyCd,  String vgmClzDyHrs, String contiCd, String vvdCd) {
		this.etb = etb;
		this.updDt = updDt;
		this.vgmItvalHrs = vgmItvalHrs;
		this.eta = eta;
		this.holChk = holChk;
		this.deltFlg = deltFlg;
		this.etd = etd;
		this.creDt = creDt;
		this.hour = hour;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
		this.chkOp = chkOp;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.usrNm = usrNm;
		this.ydCd = ydCd;
		this.locCd = locCd;
		this.pol = pol;
		this.vgmClzTpCd = vgmClzTpCd;
		this.destCntCd = destCntCd;
		this.xcldHolFlg = xcldHolFlg;
		this.updUsrId = updUsrId;
		this.day = day;
		this.ofcCd = ofcCd;
		this.vgmClzDyCd = vgmClzDyCd;
		this.vgmClzDyHrs = vgmClzDyHrs;
		this.contiCd = contiCd;
		this.vvdCd = vvdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vgm_itval_hrs", getVgmItvalHrs());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("hol_chk", getHolChk());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("hour", getHour());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chk_op", getChkOp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("vgm_clz_tp_cd", getVgmClzTpCd());
		this.hashColumns.put("dest_cnt_cd", getDestCntCd());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("day", getDay());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("vgm_clz_dy_cd", getVgmClzDyCd());
		this.hashColumns.put("vgm_clz_dy_hrs", getVgmClzDyHrs());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etb", "etb");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vgm_itval_hrs", "vgmItvalHrs");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("hol_chk", "holChk");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("hour", "hour");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chk_op", "chkOp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("vgm_clz_tp_cd", "vgmClzTpCd");
		this.hashFields.put("dest_cnt_cd", "destCntCd");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("day", "day");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("vgm_clz_dy_cd", "vgmClzDyCd");
		this.hashFields.put("vgm_clz_dy_hrs", "vgmClzDyHrs");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
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
	 * @return itvalHrs
	 */
	public String getVgmItvalHrs() {
		return this.vgmItvalHrs;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return holChk
	 */
	public String getHolChk() {
		return this.holChk;
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
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
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
	 * @return hour
	 */
	public String getHour() {
		return this.hour;
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
	 * @return chkOp
	 */
	public String getChkOp() {
		return this.chkOp;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return vgmClzTpCd
	 */
	public String getVgmClzTpCd() {
		return this.vgmClzTpCd;
	}
	
	/**
	 * Column Info
	 * @return destCntCd
	 */
	public String getDestCntCd() {
		return this.destCntCd;
	}
	
	/**
	 * Column Info
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
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
	 * @return day
	 */
	public String getDay() {
		return day;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}
	
	/**
	 * Column Info
	 * @return vgmClzDyCd
	 */
	public String getVgmClzDyCd() {
		return vgmClzDyCd;
	}
	
	/**
	 * Column Info
	 * @return vgmClzDyHrs
	 */
	public String getVgmClzDyHrs() {
		return vgmClzDyHrs;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return contiCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return vvdCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
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
	 * @param itvalHrs
	 */
	public void setVgmItvalHrs(String vgmItvalHrs) {
		this.vgmItvalHrs = vgmItvalHrs;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param holChk
	 */
	public void setHolChk(String holChk) {
		this.holChk = holChk;
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
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
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
	 * @param hour
	 */
	public void setHour(String hour) {
		this.hour = hour;
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
	 * @param chkOp
	 */
	public void setChkOp(String chkOp) {
		this.chkOp = chkOp;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param vgmClzTpCd
	 */
	public void setVgmClzTpCd(String vgmClzTpCd) {
		this.vgmClzTpCd = vgmClzTpCd;
	}
	
	/**
	 * Column Info
	 * @param destCntCd
	 */
	public void setDestCntCd(String destCntCd) {
		this.destCntCd = destCntCd;
	}
	
	/**
	 * Column Info
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
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
	 * @param day
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * Column Info
	 * @param vgmClzDyCd
	 */
	public void setVgmClzDyCd(String vgmClzDyCd) {
		this.vgmClzDyCd = vgmClzDyCd;
	}

	/**
	 * Column Info
	 * @param vgmClzDyHrs
	 */
	public void setVgmClzDyHrs(String vgmClzDyHrs) {
		this.vgmClzDyHrs = vgmClzDyHrs;
	}
	
	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEtb(JSPUtil.getParameter(request, "etb", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setVgmItvalHrs(JSPUtil.getParameter(request, "vgm_itval_hrs", ""));
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setHolChk(JSPUtil.getParameter(request, "hol_chk", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setHour(JSPUtil.getParameter(request, "hour", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChkOp(JSPUtil.getParameter(request, "chk_op", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setVgmClzTpCd(JSPUtil.getParameter(request, "vgm_clz_tp_cd", ""));
		setDestCntCd(JSPUtil.getParameter(request, "dest_cnt_cd", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDay(JSPUtil.getParameter(request, "day",""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setVgmClzDyCd(JSPUtil.getParameter(request, "vgm_clz_dy_cd", ""));
		setVgmClzDyHrs(JSPUtil.getParameter(request, "vgm_clz_dy_hrs", ""));
		setContiCd(JSPUtil.getParameter(request, "conti_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgVgmClzSetListVO[]
	 */
	public BkgVgmClzSetListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgVgmClzSetListVO[]
	 */
	public BkgVgmClzSetListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgVgmClzSetListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vgmItvalHrs = (JSPUtil.getParameter(request, prefix	+ "vgm_itval_hrs", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] holChk = (JSPUtil.getParameter(request, prefix	+ "hol_chk", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] hour = (JSPUtil.getParameter(request, prefix	+ "hour", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chkOp = (JSPUtil.getParameter(request, prefix	+ "chk_op", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] vgmClzTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_clz_tp_cd", length));
			String[] destCntCd = (JSPUtil.getParameter(request, prefix	+ "dest_cnt_cd", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] day = (JSPUtil.getParameter(request, prefix	+ "day", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] vgmClzDyCd = (JSPUtil.getParameter(request, prefix	+ "vgm_clz_dy_cd", length));
			String[] vgmClzDyHrs = (JSPUtil.getParameter(request, prefix	+ "vgm_clz_dy_hrs", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgVgmClzSetListVO();
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vgmItvalHrs[i] != null)
					model.setVgmItvalHrs(vgmItvalHrs[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (holChk[i] != null)
					model.setHolChk(holChk[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (hour[i] != null)
					model.setHour(hour[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chkOp[i] != null)
					model.setChkOp(chkOp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (vgmClzTpCd[i] != null)
					model.setVgmClzTpCd(vgmClzTpCd[i]);
				if (destCntCd[i] != null)
					model.setDestCntCd(destCntCd[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (day[i] != null)
					model.setDay(day[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (vgmClzDyCd[i] != null)
					model.setVgmClzDyCd(vgmClzDyCd[i]);
				if (vgmClzDyHrs[i] != null)
					model.setVgmClzDyHrs(vgmClzDyHrs[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgVgmClzSetListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgVgmClzSetListVO[]
	 */
	public BkgVgmClzSetListVO[] getBkgVgmClzSetListVOs(){
		BkgVgmClzSetListVO[] vos = (BkgVgmClzSetListVO[])models.toArray(new BkgVgmClzSetListVO[models.size()]);
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
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmItvalHrs = this.vgmItvalHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holChk = this.holChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hour = this.hour .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOp = this.chkOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmClzTpCd = this.vgmClzTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCntCd = this.destCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day = this.day .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmClzDyCd = this.vgmClzDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmClzDyHrs = this.vgmClzDyHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
