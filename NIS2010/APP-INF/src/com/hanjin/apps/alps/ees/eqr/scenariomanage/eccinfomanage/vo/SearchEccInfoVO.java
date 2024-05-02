/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEccInfoVO.java
*@FileTitle : SearchEccInfoVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.07.21		1.0 최초 생성
*
*@LastModifyDate : 2009.07.21
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEccInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEccInfoVO> models = new ArrayList<SearchEccInfoVO>();
	
	/* Column Info */
	private String hndl45ftCostAmt = null;
	/* Column Info */
	private String exptStoQty = null;
	/* Column Info */
	private String sttl45ftCostAmt = null;
	/* Column Info */
	private String wkyMinHndlQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String wkyMaxHndlQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String stoMaxCapaQty = null;
	/* Column Info */
	private String sttl40ftCostAmt = null;
	/* Column Info */
	private String sttl20ftCostAmt = null;
	/* Column Info */
	private String sto40ftCostAmt = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String tsDivFlg = null;
	/* Column Info */
	private String stv20ftCostAmt = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String sto45ftCostAmt = null;
	/* Column Info */
	private String stoFreeQty = null;
	/* Column Info */
	private String stoMinCapaQty = null;
	/* Column Info */
	private String hndl40ftCostAmt = null;
	/* Column Info */
	private String exptFmYrwk = null;
	/* Column Info */
	private String stv45ftCostAmt = null;
	/* Column Info */
	private String exptToYrwk = null;
	/* Column Info */
	private String hndl20ftCostAmt = null;
	/* Column Info */
	private String sto20ftCostAmt = null;
	/* Column Info */
	private String stv40ftCostAmt = null;
	/* Column Info */
	private String exptWkyHndlQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEccInfoVO() {}

	public SearchEccInfoVO(String ibflag, String pagerows, String eccCd, String stoMaxCapaQty, String stoMinCapaQty, String stoFreeQty, String wkyMaxHndlQty, String wkyMinHndlQty, String tsDivFlg, String stv20ftCostAmt, String stv40ftCostAmt, String stv45ftCostAmt, String sto20ftCostAmt, String sto40ftCostAmt, String sto45ftCostAmt, String hndl20ftCostAmt, String hndl40ftCostAmt, String hndl45ftCostAmt, String sttl20ftCostAmt, String sttl40ftCostAmt, String sttl45ftCostAmt, String exptFmYrwk, String exptToYrwk, String exptStoQty, String exptWkyHndlQty, String scnrId) {
		this.hndl45ftCostAmt = hndl45ftCostAmt;
		this.exptStoQty = exptStoQty;
		this.sttl45ftCostAmt = sttl45ftCostAmt;
		this.wkyMinHndlQty = wkyMinHndlQty;
		this.pagerows = pagerows;
		this.wkyMaxHndlQty = wkyMaxHndlQty;
		this.ibflag = ibflag;
		this.stoMaxCapaQty = stoMaxCapaQty;
		this.sttl40ftCostAmt = sttl40ftCostAmt;
		this.sttl20ftCostAmt = sttl20ftCostAmt;
		this.sto40ftCostAmt = sto40ftCostAmt;
		this.scnrId = scnrId;
		this.tsDivFlg = tsDivFlg;
		this.stv20ftCostAmt = stv20ftCostAmt;
		this.eccCd = eccCd;
		this.sto45ftCostAmt = sto45ftCostAmt;
		this.stoFreeQty = stoFreeQty;
		this.stoMinCapaQty = stoMinCapaQty;
		this.hndl40ftCostAmt = hndl40ftCostAmt;
		this.exptFmYrwk = exptFmYrwk;
		this.stv45ftCostAmt = stv45ftCostAmt;
		this.exptToYrwk = exptToYrwk;
		this.hndl20ftCostAmt = hndl20ftCostAmt;
		this.sto20ftCostAmt = sto20ftCostAmt;
		this.stv40ftCostAmt = stv40ftCostAmt;
		this.exptWkyHndlQty = exptWkyHndlQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hndl_45ft_cost_amt", getHndl45ftCostAmt());
		this.hashColumns.put("expt_sto_qty", getExptStoQty());
		this.hashColumns.put("sttl_45ft_cost_amt", getSttl45ftCostAmt());
		this.hashColumns.put("wky_min_hndl_qty", getWkyMinHndlQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("wky_max_hndl_qty", getWkyMaxHndlQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sto_max_capa_qty", getStoMaxCapaQty());
		this.hashColumns.put("sttl_40ft_cost_amt", getSttl40ftCostAmt());
		this.hashColumns.put("sttl_20ft_cost_amt", getSttl20ftCostAmt());
		this.hashColumns.put("sto_40ft_cost_amt", getSto40ftCostAmt());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("ts_div_flg", getTsDivFlg());
		this.hashColumns.put("stv_20ft_cost_amt", getStv20ftCostAmt());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("sto_45ft_cost_amt", getSto45ftCostAmt());
		this.hashColumns.put("sto_free_qty", getStoFreeQty());
		this.hashColumns.put("sto_min_capa_qty", getStoMinCapaQty());
		this.hashColumns.put("hndl_40ft_cost_amt", getHndl40ftCostAmt());
		this.hashColumns.put("expt_fm_yrwk", getExptFmYrwk());
		this.hashColumns.put("stv_45ft_cost_amt", getStv45ftCostAmt());
		this.hashColumns.put("expt_to_yrwk", getExptToYrwk());
		this.hashColumns.put("hndl_20ft_cost_amt", getHndl20ftCostAmt());
		this.hashColumns.put("sto_20ft_cost_amt", getSto20ftCostAmt());
		this.hashColumns.put("stv_40ft_cost_amt", getStv40ftCostAmt());
		this.hashColumns.put("expt_wky_hndl_qty", getExptWkyHndlQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hndl_45ft_cost_amt", "hndl45ftCostAmt");
		this.hashFields.put("expt_sto_qty", "exptStoQty");
		this.hashFields.put("sttl_45ft_cost_amt", "sttl45ftCostAmt");
		this.hashFields.put("wky_min_hndl_qty", "wkyMinHndlQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("wky_max_hndl_qty", "wkyMaxHndlQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sto_max_capa_qty", "stoMaxCapaQty");
		this.hashFields.put("sttl_40ft_cost_amt", "sttl40ftCostAmt");
		this.hashFields.put("sttl_20ft_cost_amt", "sttl20ftCostAmt");
		this.hashFields.put("sto_40ft_cost_amt", "sto40ftCostAmt");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("ts_div_flg", "tsDivFlg");
		this.hashFields.put("stv_20ft_cost_amt", "stv20ftCostAmt");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("sto_45ft_cost_amt", "sto45ftCostAmt");
		this.hashFields.put("sto_free_qty", "stoFreeQty");
		this.hashFields.put("sto_min_capa_qty", "stoMinCapaQty");
		this.hashFields.put("hndl_40ft_cost_amt", "hndl40ftCostAmt");
		this.hashFields.put("expt_fm_yrwk", "exptFmYrwk");
		this.hashFields.put("stv_45ft_cost_amt", "stv45ftCostAmt");
		this.hashFields.put("expt_to_yrwk", "exptToYrwk");
		this.hashFields.put("hndl_20ft_cost_amt", "hndl20ftCostAmt");
		this.hashFields.put("sto_20ft_cost_amt", "sto20ftCostAmt");
		this.hashFields.put("stv_40ft_cost_amt", "stv40ftCostAmt");
		this.hashFields.put("expt_wky_hndl_qty", "exptWkyHndlQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hndl45ftCostAmt
	 */
	public String getHndl45ftCostAmt() {
		return this.hndl45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return exptStoQty
	 */
	public String getExptStoQty() {
		return this.exptStoQty;
	}
	
	/**
	 * Column Info
	 * @return sttl45ftCostAmt
	 */
	public String getSttl45ftCostAmt() {
		return this.sttl45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return wkyMinHndlQty
	 */
	public String getWkyMinHndlQty() {
		return this.wkyMinHndlQty;
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
	 * @return wkyMaxHndlQty
	 */
	public String getWkyMaxHndlQty() {
		return this.wkyMaxHndlQty;
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
	 * @return stoMaxCapaQty
	 */
	public String getStoMaxCapaQty() {
		return this.stoMaxCapaQty;
	}
	
	/**
	 * Column Info
	 * @return sttl40ftCostAmt
	 */
	public String getSttl40ftCostAmt() {
		return this.sttl40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return sttl20ftCostAmt
	 */
	public String getSttl20ftCostAmt() {
		return this.sttl20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return sto40ftCostAmt
	 */
	public String getSto40ftCostAmt() {
		return this.sto40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
	}
	
	/**
	 * Column Info
	 * @return tsDivFlg
	 */
	public String getTsDivFlg() {
		return this.tsDivFlg;
	}
	
	/**
	 * Column Info
	 * @return stv20ftCostAmt
	 */
	public String getStv20ftCostAmt() {
		return this.stv20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return sto45ftCostAmt
	 */
	public String getSto45ftCostAmt() {
		return this.sto45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return stoFreeQty
	 */
	public String getStoFreeQty() {
		return this.stoFreeQty;
	}
	
	/**
	 * Column Info
	 * @return stoMinCapaQty
	 */
	public String getStoMinCapaQty() {
		return this.stoMinCapaQty;
	}
	
	/**
	 * Column Info
	 * @return hndl40ftCostAmt
	 */
	public String getHndl40ftCostAmt() {
		return this.hndl40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return exptFmYrwk
	 */
	public String getExptFmYrwk() {
		return this.exptFmYrwk;
	}
	
	/**
	 * Column Info
	 * @return stv45ftCostAmt
	 */
	public String getStv45ftCostAmt() {
		return this.stv45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return exptToYrwk
	 */
	public String getExptToYrwk() {
		return this.exptToYrwk;
	}
	
	/**
	 * Column Info
	 * @return hndl20ftCostAmt
	 */
	public String getHndl20ftCostAmt() {
		return this.hndl20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return sto20ftCostAmt
	 */
	public String getSto20ftCostAmt() {
		return this.sto20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return stv40ftCostAmt
	 */
	public String getStv40ftCostAmt() {
		return this.stv40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return exptWkyHndlQty
	 */
	public String getExptWkyHndlQty() {
		return this.exptWkyHndlQty;
	}
	

	/**
	 * Column Info
	 * @param hndl45ftCostAmt
	 */
	public void setHndl45ftCostAmt(String hndl45ftCostAmt) {
		this.hndl45ftCostAmt = hndl45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param exptStoQty
	 */
	public void setExptStoQty(String exptStoQty) {
		this.exptStoQty = exptStoQty;
	}
	
	/**
	 * Column Info
	 * @param sttl45ftCostAmt
	 */
	public void setSttl45ftCostAmt(String sttl45ftCostAmt) {
		this.sttl45ftCostAmt = sttl45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param wkyMinHndlQty
	 */
	public void setWkyMinHndlQty(String wkyMinHndlQty) {
		this.wkyMinHndlQty = wkyMinHndlQty;
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
	 * @param wkyMaxHndlQty
	 */
	public void setWkyMaxHndlQty(String wkyMaxHndlQty) {
		this.wkyMaxHndlQty = wkyMaxHndlQty;
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
	 * @param stoMaxCapaQty
	 */
	public void setStoMaxCapaQty(String stoMaxCapaQty) {
		this.stoMaxCapaQty = stoMaxCapaQty;
	}
	
	/**
	 * Column Info
	 * @param sttl40ftCostAmt
	 */
	public void setSttl40ftCostAmt(String sttl40ftCostAmt) {
		this.sttl40ftCostAmt = sttl40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param sttl20ftCostAmt
	 */
	public void setSttl20ftCostAmt(String sttl20ftCostAmt) {
		this.sttl20ftCostAmt = sttl20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param sto40ftCostAmt
	 */
	public void setSto40ftCostAmt(String sto40ftCostAmt) {
		this.sto40ftCostAmt = sto40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}
	
	/**
	 * Column Info
	 * @param tsDivFlg
	 */
	public void setTsDivFlg(String tsDivFlg) {
		this.tsDivFlg = tsDivFlg;
	}
	
	/**
	 * Column Info
	 * @param stv20ftCostAmt
	 */
	public void setStv20ftCostAmt(String stv20ftCostAmt) {
		this.stv20ftCostAmt = stv20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param sto45ftCostAmt
	 */
	public void setSto45ftCostAmt(String sto45ftCostAmt) {
		this.sto45ftCostAmt = sto45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param stoFreeQty
	 */
	public void setStoFreeQty(String stoFreeQty) {
		this.stoFreeQty = stoFreeQty;
	}
	
	/**
	 * Column Info
	 * @param stoMinCapaQty
	 */
	public void setStoMinCapaQty(String stoMinCapaQty) {
		this.stoMinCapaQty = stoMinCapaQty;
	}
	
	/**
	 * Column Info
	 * @param hndl40ftCostAmt
	 */
	public void setHndl40ftCostAmt(String hndl40ftCostAmt) {
		this.hndl40ftCostAmt = hndl40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param exptFmYrwk
	 */
	public void setExptFmYrwk(String exptFmYrwk) {
		this.exptFmYrwk = exptFmYrwk;
	}
	
	/**
	 * Column Info
	 * @param stv45ftCostAmt
	 */
	public void setStv45ftCostAmt(String stv45ftCostAmt) {
		this.stv45ftCostAmt = stv45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param exptToYrwk
	 */
	public void setExptToYrwk(String exptToYrwk) {
		this.exptToYrwk = exptToYrwk;
	}
	
	/**
	 * Column Info
	 * @param hndl20ftCostAmt
	 */
	public void setHndl20ftCostAmt(String hndl20ftCostAmt) {
		this.hndl20ftCostAmt = hndl20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param sto20ftCostAmt
	 */
	public void setSto20ftCostAmt(String sto20ftCostAmt) {
		this.sto20ftCostAmt = sto20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param stv40ftCostAmt
	 */
	public void setStv40ftCostAmt(String stv40ftCostAmt) {
		this.stv40ftCostAmt = stv40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param exptWkyHndlQty
	 */
	public void setExptWkyHndlQty(String exptWkyHndlQty) {
		this.exptWkyHndlQty = exptWkyHndlQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setHndl45ftCostAmt(JSPUtil.getParameter(request, "hndl_45ft_cost_amt", ""));
		setExptStoQty(JSPUtil.getParameter(request, "expt_sto_qty", ""));
		setSttl45ftCostAmt(JSPUtil.getParameter(request, "sttl_45ft_cost_amt", ""));
		setWkyMinHndlQty(JSPUtil.getParameter(request, "wky_min_hndl_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setWkyMaxHndlQty(JSPUtil.getParameter(request, "wky_max_hndl_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setStoMaxCapaQty(JSPUtil.getParameter(request, "sto_max_capa_qty", ""));
		setSttl40ftCostAmt(JSPUtil.getParameter(request, "sttl_40ft_cost_amt", ""));
		setSttl20ftCostAmt(JSPUtil.getParameter(request, "sttl_20ft_cost_amt", ""));
		setSto40ftCostAmt(JSPUtil.getParameter(request, "sto_40ft_cost_amt", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setTsDivFlg(JSPUtil.getParameter(request, "ts_div_flg", ""));
		setStv20ftCostAmt(JSPUtil.getParameter(request, "stv_20ft_cost_amt", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setSto45ftCostAmt(JSPUtil.getParameter(request, "sto_45ft_cost_amt", ""));
		setStoFreeQty(JSPUtil.getParameter(request, "sto_free_qty", ""));
		setStoMinCapaQty(JSPUtil.getParameter(request, "sto_min_capa_qty", ""));
		setHndl40ftCostAmt(JSPUtil.getParameter(request, "hndl_40ft_cost_amt", ""));
		setExptFmYrwk(JSPUtil.getParameter(request, "expt_fm_yrwk", ""));
		setStv45ftCostAmt(JSPUtil.getParameter(request, "stv_45ft_cost_amt", ""));
		setExptToYrwk(JSPUtil.getParameter(request, "expt_to_yrwk", ""));
		setHndl20ftCostAmt(JSPUtil.getParameter(request, "hndl_20ft_cost_amt", ""));
		setSto20ftCostAmt(JSPUtil.getParameter(request, "sto_20ft_cost_amt", ""));
		setStv40ftCostAmt(JSPUtil.getParameter(request, "stv_40ft_cost_amt", ""));
		setExptWkyHndlQty(JSPUtil.getParameter(request, "expt_wky_hndl_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEccInfoVO[]
	 */
	public SearchEccInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEccInfoVO[]
	 */
	public SearchEccInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEccInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hndl45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "hndl_45ft_cost_amt", length));
			String[] exptStoQty = (JSPUtil.getParameter(request, prefix	+ "expt_sto_qty", length));
			String[] sttl45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "sttl_45ft_cost_amt", length));
			String[] wkyMinHndlQty = (JSPUtil.getParameter(request, prefix	+ "wky_min_hndl_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] wkyMaxHndlQty = (JSPUtil.getParameter(request, prefix	+ "wky_max_hndl_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] stoMaxCapaQty = (JSPUtil.getParameter(request, prefix	+ "sto_max_capa_qty", length));
			String[] sttl40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "sttl_40ft_cost_amt", length));
			String[] sttl20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "sttl_20ft_cost_amt", length));
			String[] sto40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "sto_40ft_cost_amt", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] tsDivFlg = (JSPUtil.getParameter(request, prefix	+ "ts_div_flg", length));
			String[] stv20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "stv_20ft_cost_amt", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] sto45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "sto_45ft_cost_amt", length));
			String[] stoFreeQty = (JSPUtil.getParameter(request, prefix	+ "sto_free_qty", length));
			String[] stoMinCapaQty = (JSPUtil.getParameter(request, prefix	+ "sto_min_capa_qty", length));
			String[] hndl40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "hndl_40ft_cost_amt", length));
			String[] exptFmYrwk = (JSPUtil.getParameter(request, prefix	+ "expt_fm_yrwk", length));
			String[] stv45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "stv_45ft_cost_amt", length));
			String[] exptToYrwk = (JSPUtil.getParameter(request, prefix	+ "expt_to_yrwk", length));
			String[] hndl20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "hndl_20ft_cost_amt", length));
			String[] sto20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "sto_20ft_cost_amt", length));
			String[] stv40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "stv_40ft_cost_amt", length));
			String[] exptWkyHndlQty = (JSPUtil.getParameter(request, prefix	+ "expt_wky_hndl_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEccInfoVO();
				if (hndl45ftCostAmt[i] != null)
					model.setHndl45ftCostAmt(hndl45ftCostAmt[i]);
				if (exptStoQty[i] != null)
					model.setExptStoQty(exptStoQty[i]);
				if (sttl45ftCostAmt[i] != null)
					model.setSttl45ftCostAmt(sttl45ftCostAmt[i]);
				if (wkyMinHndlQty[i] != null)
					model.setWkyMinHndlQty(wkyMinHndlQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (wkyMaxHndlQty[i] != null)
					model.setWkyMaxHndlQty(wkyMaxHndlQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (stoMaxCapaQty[i] != null)
					model.setStoMaxCapaQty(stoMaxCapaQty[i]);
				if (sttl40ftCostAmt[i] != null)
					model.setSttl40ftCostAmt(sttl40ftCostAmt[i]);
				if (sttl20ftCostAmt[i] != null)
					model.setSttl20ftCostAmt(sttl20ftCostAmt[i]);
				if (sto40ftCostAmt[i] != null)
					model.setSto40ftCostAmt(sto40ftCostAmt[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (tsDivFlg[i] != null)
					model.setTsDivFlg(tsDivFlg[i]);
				if (stv20ftCostAmt[i] != null)
					model.setStv20ftCostAmt(stv20ftCostAmt[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (sto45ftCostAmt[i] != null)
					model.setSto45ftCostAmt(sto45ftCostAmt[i]);
				if (stoFreeQty[i] != null)
					model.setStoFreeQty(stoFreeQty[i]);
				if (stoMinCapaQty[i] != null)
					model.setStoMinCapaQty(stoMinCapaQty[i]);
				if (hndl40ftCostAmt[i] != null)
					model.setHndl40ftCostAmt(hndl40ftCostAmt[i]);
				if (exptFmYrwk[i] != null)
					model.setExptFmYrwk(exptFmYrwk[i]);
				if (stv45ftCostAmt[i] != null)
					model.setStv45ftCostAmt(stv45ftCostAmt[i]);
				if (exptToYrwk[i] != null)
					model.setExptToYrwk(exptToYrwk[i]);
				if (hndl20ftCostAmt[i] != null)
					model.setHndl20ftCostAmt(hndl20ftCostAmt[i]);
				if (sto20ftCostAmt[i] != null)
					model.setSto20ftCostAmt(sto20ftCostAmt[i]);
				if (stv40ftCostAmt[i] != null)
					model.setStv40ftCostAmt(stv40ftCostAmt[i]);
				if (exptWkyHndlQty[i] != null)
					model.setExptWkyHndlQty(exptWkyHndlQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEccInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEccInfoVO[]
	 */
	public SearchEccInfoVO[] getSearchEccInfoVOs(){
		SearchEccInfoVO[] vos = (SearchEccInfoVO[])models.toArray(new SearchEccInfoVO[models.size()]);
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
		this.hndl45ftCostAmt = this.hndl45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptStoQty = this.exptStoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sttl45ftCostAmt = this.sttl45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkyMinHndlQty = this.wkyMinHndlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkyMaxHndlQty = this.wkyMaxHndlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoMaxCapaQty = this.stoMaxCapaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sttl40ftCostAmt = this.sttl40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sttl20ftCostAmt = this.sttl20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sto40ftCostAmt = this.sto40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsDivFlg = this.tsDivFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stv20ftCostAmt = this.stv20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sto45ftCostAmt = this.sto45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoFreeQty = this.stoFreeQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoMinCapaQty = this.stoMinCapaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndl40ftCostAmt = this.hndl40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptFmYrwk = this.exptFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stv45ftCostAmt = this.stv45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptToYrwk = this.exptToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndl20ftCostAmt = this.hndl20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sto20ftCostAmt = this.sto20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stv40ftCostAmt = this.stv40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptWkyHndlQty = this.exptWkyHndlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}