/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSafetyStockVO.java
*@FileTitle : SearchSafetyStockVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.08 채창호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSafetyStockVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSafetyStockVO> models = new ArrayList<SearchSafetyStockVO>();
	
	/* Column Info */
	private String f2sfstkVolQty = null;
	/* Column Info */
	private String r2sfstkVolQty = null;
	/* Column Info */
	private String f4sfstkVolQty = null;
	/* Column Info */
	private String d7sfstkLvlCd = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String r2sfstkLvlCd = null;
	/* Column Info */
	private String o2sfstkVolQty = null;
	/* Column Info */
	private String f4sfstkLvlCd = null;
	/* Column Info */
	private String d2sfstkVolQty = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String o4sfstkLvlCd = null;
	/* Column Info */
	private String r5sfstkVolQty = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String f2sfstkLvlCd = null;
	/* Column Info */
	private String d4sfstkVolQty = null;
	/* Column Info */
	private String timegap = null;
	/* Column Info */
	private String d7sfstkVolQty = null;
	/* Column Info */
	private String o4sfstkVolQty = null;
	/* Column Info */
	private String d4sfstkLvlCd = null;
	/* Column Info */
	private String d5sfstkVolQty = null;
	/* Column Info */
	private String o2sfstkLvlCd = null;
	/* Column Info */
	private String d2sfstkLvlCd = null;
	/* Column Info */
	private String r5sfstkLvlCd = null;
	/* Column Info */
	private String d5sfstkLvlCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSafetyStockVO() {}

	public SearchSafetyStockVO(String ibflag, String pagerows, String eccCd, String d2sfstkLvlCd, String d2sfstkVolQty, String d4sfstkLvlCd, String d4sfstkVolQty, String d5sfstkLvlCd, String d5sfstkVolQty, String d7sfstkLvlCd, String d7sfstkVolQty, String r2sfstkLvlCd, String r2sfstkVolQty, String r5sfstkLvlCd, String r5sfstkVolQty, String o2sfstkLvlCd, String o2sfstkVolQty, String o4sfstkLvlCd, String o4sfstkVolQty, String f2sfstkLvlCd, String f2sfstkVolQty, String f4sfstkLvlCd, String f4sfstkVolQty, String timegap, String creDt, String updDt) {
		this.f2sfstkVolQty = f2sfstkVolQty;
		this.r2sfstkVolQty = r2sfstkVolQty;
		this.f4sfstkVolQty = f4sfstkVolQty;
		this.d7sfstkLvlCd = d7sfstkLvlCd;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.r2sfstkLvlCd = r2sfstkLvlCd;
		this.o2sfstkVolQty = o2sfstkVolQty;
		this.f4sfstkLvlCd = f4sfstkLvlCd;
		this.d2sfstkVolQty = d2sfstkVolQty;
		this.updDt = updDt;
		this.o4sfstkLvlCd = o4sfstkLvlCd;
		this.r5sfstkVolQty = r5sfstkVolQty;
		this.eccCd = eccCd;
		this.f2sfstkLvlCd = f2sfstkLvlCd;
		this.d4sfstkVolQty = d4sfstkVolQty;
		this.timegap = timegap;
		this.d7sfstkVolQty = d7sfstkVolQty;
		this.o4sfstkVolQty = o4sfstkVolQty;
		this.d4sfstkLvlCd = d4sfstkLvlCd;
		this.d5sfstkVolQty = d5sfstkVolQty;
		this.o2sfstkLvlCd = o2sfstkLvlCd;
		this.d2sfstkLvlCd = d2sfstkLvlCd;
		this.r5sfstkLvlCd = r5sfstkLvlCd;
		this.d5sfstkLvlCd = d5sfstkLvlCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f2sfstk_vol_qty", getF2sfstkVolQty());
		this.hashColumns.put("r2sfstk_vol_qty", getR2sfstkVolQty());
		this.hashColumns.put("f4sfstk_vol_qty", getF4sfstkVolQty());
		this.hashColumns.put("d7sfstk_lvl_cd", getD7sfstkLvlCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("r2sfstk_lvl_cd", getR2sfstkLvlCd());
		this.hashColumns.put("o2sfstk_vol_qty", getO2sfstkVolQty());
		this.hashColumns.put("f4sfstk_lvl_cd", getF4sfstkLvlCd());
		this.hashColumns.put("d2sfstk_vol_qty", getD2sfstkVolQty());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("o4sfstk_lvl_cd", getO4sfstkLvlCd());
		this.hashColumns.put("r5sfstk_vol_qty", getR5sfstkVolQty());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("f2sfstk_lvl_cd", getF2sfstkLvlCd());
		this.hashColumns.put("d4sfstk_vol_qty", getD4sfstkVolQty());
		this.hashColumns.put("timegap", getTimegap());
		this.hashColumns.put("d7sfstk_vol_qty", getD7sfstkVolQty());
		this.hashColumns.put("o4sfstk_vol_qty", getO4sfstkVolQty());
		this.hashColumns.put("d4sfstk_lvl_cd", getD4sfstkLvlCd());
		this.hashColumns.put("d5sfstk_vol_qty", getD5sfstkVolQty());
		this.hashColumns.put("o2sfstk_lvl_cd", getO2sfstkLvlCd());
		this.hashColumns.put("d2sfstk_lvl_cd", getD2sfstkLvlCd());
		this.hashColumns.put("r5sfstk_lvl_cd", getR5sfstkLvlCd());
		this.hashColumns.put("d5sfstk_lvl_cd", getD5sfstkLvlCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f2sfstk_vol_qty", "f2sfstkVolQty");
		this.hashFields.put("r2sfstk_vol_qty", "r2sfstkVolQty");
		this.hashFields.put("f4sfstk_vol_qty", "f4sfstkVolQty");
		this.hashFields.put("d7sfstk_lvl_cd", "d7sfstkLvlCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("r2sfstk_lvl_cd", "r2sfstkLvlCd");
		this.hashFields.put("o2sfstk_vol_qty", "o2sfstkVolQty");
		this.hashFields.put("f4sfstk_lvl_cd", "f4sfstkLvlCd");
		this.hashFields.put("d2sfstk_vol_qty", "d2sfstkVolQty");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("o4sfstk_lvl_cd", "o4sfstkLvlCd");
		this.hashFields.put("r5sfstk_vol_qty", "r5sfstkVolQty");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("f2sfstk_lvl_cd", "f2sfstkLvlCd");
		this.hashFields.put("d4sfstk_vol_qty", "d4sfstkVolQty");
		this.hashFields.put("timegap", "timegap");
		this.hashFields.put("d7sfstk_vol_qty", "d7sfstkVolQty");
		this.hashFields.put("o4sfstk_vol_qty", "o4sfstkVolQty");
		this.hashFields.put("d4sfstk_lvl_cd", "d4sfstkLvlCd");
		this.hashFields.put("d5sfstk_vol_qty", "d5sfstkVolQty");
		this.hashFields.put("o2sfstk_lvl_cd", "o2sfstkLvlCd");
		this.hashFields.put("d2sfstk_lvl_cd", "d2sfstkLvlCd");
		this.hashFields.put("r5sfstk_lvl_cd", "r5sfstkLvlCd");
		this.hashFields.put("d5sfstk_lvl_cd", "d5sfstkLvlCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return f2sfstkVolQty
	 */
	public String getF2sfstkVolQty() {
		return this.f2sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @return r2sfstkVolQty
	 */
	public String getR2sfstkVolQty() {
		return this.r2sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @return f4sfstkVolQty
	 */
	public String getF4sfstkVolQty() {
		return this.f4sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @return d7sfstkLvlCd
	 */
	public String getD7sfstkLvlCd() {
		return this.d7sfstkLvlCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return r2sfstkLvlCd
	 */
	public String getR2sfstkLvlCd() {
		return this.r2sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @return o2sfstkVolQty
	 */
	public String getO2sfstkVolQty() {
		return this.o2sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @return f4sfstkLvlCd
	 */
	public String getF4sfstkLvlCd() {
		return this.f4sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @return d2sfstkVolQty
	 */
	public String getD2sfstkVolQty() {
		return this.d2sfstkVolQty;
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
	 * @return o4sfstkLvlCd
	 */
	public String getO4sfstkLvlCd() {
		return this.o4sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @return r5sfstkVolQty
	 */
	public String getR5sfstkVolQty() {
		return this.r5sfstkVolQty;
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
	 * @return f2sfstkLvlCd
	 */
	public String getF2sfstkLvlCd() {
		return this.f2sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @return d4sfstkVolQty
	 */
	public String getD4sfstkVolQty() {
		return this.d4sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @return timegap
	 */
	public String getTimegap() {
		return this.timegap;
	}
	
	/**
	 * Column Info
	 * @return d7sfstkVolQty
	 */
	public String getD7sfstkVolQty() {
		return this.d7sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @return o4sfstkVolQty
	 */
	public String getO4sfstkVolQty() {
		return this.o4sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @return d4sfstkLvlCd
	 */
	public String getD4sfstkLvlCd() {
		return this.d4sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @return d5sfstkVolQty
	 */
	public String getD5sfstkVolQty() {
		return this.d5sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @return o2sfstkLvlCd
	 */
	public String getO2sfstkLvlCd() {
		return this.o2sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @return d2sfstkLvlCd
	 */
	public String getD2sfstkLvlCd() {
		return this.d2sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @return r5sfstkLvlCd
	 */
	public String getR5sfstkLvlCd() {
		return this.r5sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @return d5sfstkLvlCd
	 */
	public String getD5sfstkLvlCd() {
		return this.d5sfstkLvlCd;
	}
	

	/**
	 * Column Info
	 * @param f2sfstkVolQty
	 */
	public void setF2sfstkVolQty(String f2sfstkVolQty) {
		this.f2sfstkVolQty = f2sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @param r2sfstkVolQty
	 */
	public void setR2sfstkVolQty(String r2sfstkVolQty) {
		this.r2sfstkVolQty = r2sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @param f4sfstkVolQty
	 */
	public void setF4sfstkVolQty(String f4sfstkVolQty) {
		this.f4sfstkVolQty = f4sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @param d7sfstkLvlCd
	 */
	public void setD7sfstkLvlCd(String d7sfstkLvlCd) {
		this.d7sfstkLvlCd = d7sfstkLvlCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param r2sfstkLvlCd
	 */
	public void setR2sfstkLvlCd(String r2sfstkLvlCd) {
		this.r2sfstkLvlCd = r2sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @param o2sfstkVolQty
	 */
	public void setO2sfstkVolQty(String o2sfstkVolQty) {
		this.o2sfstkVolQty = o2sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @param f4sfstkLvlCd
	 */
	public void setF4sfstkLvlCd(String f4sfstkLvlCd) {
		this.f4sfstkLvlCd = f4sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @param d2sfstkVolQty
	 */
	public void setD2sfstkVolQty(String d2sfstkVolQty) {
		this.d2sfstkVolQty = d2sfstkVolQty;
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
	 * @param o4sfstkLvlCd
	 */
	public void setO4sfstkLvlCd(String o4sfstkLvlCd) {
		this.o4sfstkLvlCd = o4sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @param r5sfstkVolQty
	 */
	public void setR5sfstkVolQty(String r5sfstkVolQty) {
		this.r5sfstkVolQty = r5sfstkVolQty;
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
	 * @param f2sfstkLvlCd
	 */
	public void setF2sfstkLvlCd(String f2sfstkLvlCd) {
		this.f2sfstkLvlCd = f2sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @param d4sfstkVolQty
	 */
	public void setD4sfstkVolQty(String d4sfstkVolQty) {
		this.d4sfstkVolQty = d4sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @param timegap
	 */
	public void setTimegap(String timegap) {
		this.timegap = timegap;
	}
	
	/**
	 * Column Info
	 * @param d7sfstkVolQty
	 */
	public void setD7sfstkVolQty(String d7sfstkVolQty) {
		this.d7sfstkVolQty = d7sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @param o4sfstkVolQty
	 */
	public void setO4sfstkVolQty(String o4sfstkVolQty) {
		this.o4sfstkVolQty = o4sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @param d4sfstkLvlCd
	 */
	public void setD4sfstkLvlCd(String d4sfstkLvlCd) {
		this.d4sfstkLvlCd = d4sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @param d5sfstkVolQty
	 */
	public void setD5sfstkVolQty(String d5sfstkVolQty) {
		this.d5sfstkVolQty = d5sfstkVolQty;
	}
	
	/**
	 * Column Info
	 * @param o2sfstkLvlCd
	 */
	public void setO2sfstkLvlCd(String o2sfstkLvlCd) {
		this.o2sfstkLvlCd = o2sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @param d2sfstkLvlCd
	 */
	public void setD2sfstkLvlCd(String d2sfstkLvlCd) {
		this.d2sfstkLvlCd = d2sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @param r5sfstkLvlCd
	 */
	public void setR5sfstkLvlCd(String r5sfstkLvlCd) {
		this.r5sfstkLvlCd = r5sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @param d5sfstkLvlCd
	 */
	public void setD5sfstkLvlCd(String d5sfstkLvlCd) {
		this.d5sfstkLvlCd = d5sfstkLvlCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setF2sfstkVolQty(JSPUtil.getParameter(request, "f2sfstk_vol_qty", ""));
		setR2sfstkVolQty(JSPUtil.getParameter(request, "r2sfstk_vol_qty", ""));
		setF4sfstkVolQty(JSPUtil.getParameter(request, "f4sfstk_vol_qty", ""));
		setD7sfstkLvlCd(JSPUtil.getParameter(request, "d7sfstk_lvl_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setR2sfstkLvlCd(JSPUtil.getParameter(request, "r2sfstk_lvl_cd", ""));
		setO2sfstkVolQty(JSPUtil.getParameter(request, "o2sfstk_vol_qty", ""));
		setF4sfstkLvlCd(JSPUtil.getParameter(request, "f4sfstk_lvl_cd", ""));
		setD2sfstkVolQty(JSPUtil.getParameter(request, "d2sfstk_vol_qty", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setO4sfstkLvlCd(JSPUtil.getParameter(request, "o4sfstk_lvl_cd", ""));
		setR5sfstkVolQty(JSPUtil.getParameter(request, "r5sfstk_vol_qty", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setF2sfstkLvlCd(JSPUtil.getParameter(request, "f2sfstk_lvl_cd", ""));
		setD4sfstkVolQty(JSPUtil.getParameter(request, "d4sfstk_vol_qty", ""));
		setTimegap(JSPUtil.getParameter(request, "timegap", ""));
		setD7sfstkVolQty(JSPUtil.getParameter(request, "d7sfstk_vol_qty", ""));
		setO4sfstkVolQty(JSPUtil.getParameter(request, "o4sfstk_vol_qty", ""));
		setD4sfstkLvlCd(JSPUtil.getParameter(request, "d4sfstk_lvl_cd", ""));
		setD5sfstkVolQty(JSPUtil.getParameter(request, "d5sfstk_vol_qty", ""));
		setO2sfstkLvlCd(JSPUtil.getParameter(request, "o2sfstk_lvl_cd", ""));
		setD2sfstkLvlCd(JSPUtil.getParameter(request, "d2sfstk_lvl_cd", ""));
		setR5sfstkLvlCd(JSPUtil.getParameter(request, "r5sfstk_lvl_cd", ""));
		setD5sfstkLvlCd(JSPUtil.getParameter(request, "d5sfstk_lvl_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSafetyStockVO[]
	 */
	public SearchSafetyStockVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSafetyStockVO[]
	 */
	public SearchSafetyStockVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSafetyStockVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] f2sfstkVolQty = (JSPUtil.getParameter(request, prefix	+ "f2sfstk_vol_qty", length));
			String[] r2sfstkVolQty = (JSPUtil.getParameter(request, prefix	+ "r2sfstk_vol_qty", length));
			String[] f4sfstkVolQty = (JSPUtil.getParameter(request, prefix	+ "f4sfstk_vol_qty", length));
			String[] d7sfstkLvlCd = (JSPUtil.getParameter(request, prefix	+ "d7sfstk_lvl_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] r2sfstkLvlCd = (JSPUtil.getParameter(request, prefix	+ "r2sfstk_lvl_cd", length));
			String[] o2sfstkVolQty = (JSPUtil.getParameter(request, prefix	+ "o2sfstk_vol_qty", length));
			String[] f4sfstkLvlCd = (JSPUtil.getParameter(request, prefix	+ "f4sfstk_lvl_cd", length));
			String[] d2sfstkVolQty = (JSPUtil.getParameter(request, prefix	+ "d2sfstk_vol_qty", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] o4sfstkLvlCd = (JSPUtil.getParameter(request, prefix	+ "o4sfstk_lvl_cd", length));
			String[] r5sfstkVolQty = (JSPUtil.getParameter(request, prefix	+ "r5sfstk_vol_qty", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] f2sfstkLvlCd = (JSPUtil.getParameter(request, prefix	+ "f2sfstk_lvl_cd", length));
			String[] d4sfstkVolQty = (JSPUtil.getParameter(request, prefix	+ "d4sfstk_vol_qty", length));
			String[] timegap = (JSPUtil.getParameter(request, prefix	+ "timegap", length));
			String[] d7sfstkVolQty = (JSPUtil.getParameter(request, prefix	+ "d7sfstk_vol_qty", length));
			String[] o4sfstkVolQty = (JSPUtil.getParameter(request, prefix	+ "o4sfstk_vol_qty", length));
			String[] d4sfstkLvlCd = (JSPUtil.getParameter(request, prefix	+ "d4sfstk_lvl_cd", length));
			String[] d5sfstkVolQty = (JSPUtil.getParameter(request, prefix	+ "d5sfstk_vol_qty", length));
			String[] o2sfstkLvlCd = (JSPUtil.getParameter(request, prefix	+ "o2sfstk_lvl_cd", length));
			String[] d2sfstkLvlCd = (JSPUtil.getParameter(request, prefix	+ "d2sfstk_lvl_cd", length));
			String[] r5sfstkLvlCd = (JSPUtil.getParameter(request, prefix	+ "r5sfstk_lvl_cd", length));
			String[] d5sfstkLvlCd = (JSPUtil.getParameter(request, prefix	+ "d5sfstk_lvl_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSafetyStockVO();
				if (f2sfstkVolQty[i] != null)
					model.setF2sfstkVolQty(f2sfstkVolQty[i]);
				if (r2sfstkVolQty[i] != null)
					model.setR2sfstkVolQty(r2sfstkVolQty[i]);
				if (f4sfstkVolQty[i] != null)
					model.setF4sfstkVolQty(f4sfstkVolQty[i]);
				if (d7sfstkLvlCd[i] != null)
					model.setD7sfstkLvlCd(d7sfstkLvlCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (r2sfstkLvlCd[i] != null)
					model.setR2sfstkLvlCd(r2sfstkLvlCd[i]);
				if (o2sfstkVolQty[i] != null)
					model.setO2sfstkVolQty(o2sfstkVolQty[i]);
				if (f4sfstkLvlCd[i] != null)
					model.setF4sfstkLvlCd(f4sfstkLvlCd[i]);
				if (d2sfstkVolQty[i] != null)
					model.setD2sfstkVolQty(d2sfstkVolQty[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (o4sfstkLvlCd[i] != null)
					model.setO4sfstkLvlCd(o4sfstkLvlCd[i]);
				if (r5sfstkVolQty[i] != null)
					model.setR5sfstkVolQty(r5sfstkVolQty[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (f2sfstkLvlCd[i] != null)
					model.setF2sfstkLvlCd(f2sfstkLvlCd[i]);
				if (d4sfstkVolQty[i] != null)
					model.setD4sfstkVolQty(d4sfstkVolQty[i]);
				if (timegap[i] != null)
					model.setTimegap(timegap[i]);
				if (d7sfstkVolQty[i] != null)
					model.setD7sfstkVolQty(d7sfstkVolQty[i]);
				if (o4sfstkVolQty[i] != null)
					model.setO4sfstkVolQty(o4sfstkVolQty[i]);
				if (d4sfstkLvlCd[i] != null)
					model.setD4sfstkLvlCd(d4sfstkLvlCd[i]);
				if (d5sfstkVolQty[i] != null)
					model.setD5sfstkVolQty(d5sfstkVolQty[i]);
				if (o2sfstkLvlCd[i] != null)
					model.setO2sfstkLvlCd(o2sfstkLvlCd[i]);
				if (d2sfstkLvlCd[i] != null)
					model.setD2sfstkLvlCd(d2sfstkLvlCd[i]);
				if (r5sfstkLvlCd[i] != null)
					model.setR5sfstkLvlCd(r5sfstkLvlCd[i]);
				if (d5sfstkLvlCd[i] != null)
					model.setD5sfstkLvlCd(d5sfstkLvlCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSafetyStockVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSafetyStockVO[]
	 */
	public SearchSafetyStockVO[] getSearchSafetyStockVOs(){
		SearchSafetyStockVO[] vos = (SearchSafetyStockVO[])models.toArray(new SearchSafetyStockVO[models.size()]);
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
		this.f2sfstkVolQty = this.f2sfstkVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2sfstkVolQty = this.r2sfstkVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4sfstkVolQty = this.f4sfstkVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7sfstkLvlCd = this.d7sfstkLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2sfstkLvlCd = this.r2sfstkLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2sfstkVolQty = this.o2sfstkVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4sfstkLvlCd = this.f4sfstkLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2sfstkVolQty = this.d2sfstkVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4sfstkLvlCd = this.o4sfstkLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5sfstkVolQty = this.r5sfstkVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2sfstkLvlCd = this.f2sfstkLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4sfstkVolQty = this.d4sfstkVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.timegap = this.timegap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7sfstkVolQty = this.d7sfstkVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4sfstkVolQty = this.o4sfstkVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4sfstkLvlCd = this.d4sfstkLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5sfstkVolQty = this.d5sfstkVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2sfstkLvlCd = this.o2sfstkLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2sfstkLvlCd = this.d2sfstkLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5sfstkLvlCd = this.r5sfstkLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5sfstkLvlCd = this.d5sfstkLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
