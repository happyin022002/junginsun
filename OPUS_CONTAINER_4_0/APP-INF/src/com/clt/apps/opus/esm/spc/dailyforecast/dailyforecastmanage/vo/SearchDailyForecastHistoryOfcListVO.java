/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchDailyForecastHistoryOfcListVO.java
*@FileTitle : SearchDailyForecastHistoryOfcListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.08
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.07.08 이상용 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이상용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDailyForecastHistoryOfcListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDailyForecastHistoryOfcListVO> models = new ArrayList<SearchDailyForecastHistoryOfcListVO>();
	
	/* Column Info */
	private String aloc53ftQty = null;
	/* Column Info */
	private String alocTtlWgt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String fcastTtlTeuQty = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String alocLodQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String alocRfQty = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fcastLodQty = null;
	/* Column Info */
	private String aloc40ftHcQty = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String fcast53ftQty = null;
	/* Column Info */
	private String aloc45ftHcQty = null;
	/* Column Info */
	private String fcastTtlWgt = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String fcastRfQty = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bseDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String fcast45ftHcQty = null;
	/* Column Info */
	private String fcast40ftHcQty = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDailyForecastHistoryOfcListVO() {}

	public SearchDailyForecastHistoryOfcListVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String rlaneCd, String skdDirCd, String iocCd, String slsOfcCd, String bseWk, String vvd, String bseDt, String polCd, String podCd, String fcastTtlTeuQty, String fcastLodQty, String fcast40ftHcQty, String fcast45ftHcQty, String fcast53ftQty, String fcastRfQty, String fcastTtlWgt, String alocLodQty, String aloc40ftHcQty, String aloc45ftHcQty, String aloc53ftQty, String alocRfQty, String alocTtlWgt, String lvl) {
		this.aloc53ftQty = aloc53ftQty;
		this.alocTtlWgt = alocTtlWgt;
		this.trdCd = trdCd;
		this.fcastTtlTeuQty = fcastTtlTeuQty;
		this.rlaneCd = rlaneCd;
		this.alocLodQty = alocLodQty;
		this.pagerows = pagerows;
		this.alocRfQty = alocRfQty;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.fcastLodQty = fcastLodQty;
		this.aloc40ftHcQty = aloc40ftHcQty;
		this.slsOfcCd = slsOfcCd;
		this.fcast53ftQty = fcast53ftQty;
		this.aloc45ftHcQty = aloc45ftHcQty;
		this.fcastTtlWgt = fcastTtlWgt;
		this.iocCd = iocCd;
		this.bseWk = bseWk;
		this.skdDirCd = skdDirCd;
		this.fcastRfQty = fcastRfQty;
		this.podCd = podCd;
		this.bseDt = bseDt;
		this.vvd = vvd;
		this.lvl = lvl;
		this.fcast45ftHcQty = fcast45ftHcQty;
		this.fcast40ftHcQty = fcast40ftHcQty;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aloc_53ft_qty", getAloc53ftQty());
		this.hashColumns.put("aloc_ttl_wgt", getAlocTtlWgt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("fcast_ttl_teu_qty", getFcastTtlTeuQty());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("aloc_lod_qty", getAlocLodQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("aloc_rf_qty", getAlocRfQty());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fcast_lod_qty", getFcastLodQty());
		this.hashColumns.put("aloc_40ft_hc_qty", getAloc40ftHcQty());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("fcast_53ft_qty", getFcast53ftQty());
		this.hashColumns.put("aloc_45ft_hc_qty", getAloc45ftHcQty());
		this.hashColumns.put("fcast_ttl_wgt", getFcastTtlWgt());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("fcast_rf_qty", getFcastRfQty());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bse_dt", getBseDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("fcast_45ft_hc_qty", getFcast45ftHcQty());
		this.hashColumns.put("fcast_40ft_hc_qty", getFcast40ftHcQty());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aloc_53ft_qty", "aloc53ftQty");
		this.hashFields.put("aloc_ttl_wgt", "alocTtlWgt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("fcast_ttl_teu_qty", "fcastTtlTeuQty");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("aloc_lod_qty", "alocLodQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("aloc_rf_qty", "alocRfQty");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fcast_lod_qty", "fcastLodQty");
		this.hashFields.put("aloc_40ft_hc_qty", "aloc40ftHcQty");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("fcast_53ft_qty", "fcast53ftQty");
		this.hashFields.put("aloc_45ft_hc_qty", "aloc45ftHcQty");
		this.hashFields.put("fcast_ttl_wgt", "fcastTtlWgt");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("fcast_rf_qty", "fcastRfQty");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bse_dt", "bseDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("fcast_45ft_hc_qty", "fcast45ftHcQty");
		this.hashFields.put("fcast_40ft_hc_qty", "fcast40ftHcQty");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aloc53ftQty
	 */
	public String getAloc53ftQty() {
		return this.aloc53ftQty;
	}
	
	/**
	 * Column Info
	 * @return alocTtlWgt
	 */
	public String getAlocTtlWgt() {
		return this.alocTtlWgt;
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
	 * @return fcastTtlTeuQty
	 */
	public String getFcastTtlTeuQty() {
		return this.fcastTtlTeuQty;
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
	 * @return alocLodQty
	 */
	public String getAlocLodQty() {
		return this.alocLodQty;
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
	 * @return alocRfQty
	 */
	public String getAlocRfQty() {
		return this.alocRfQty;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return fcastLodQty
	 */
	public String getFcastLodQty() {
		return this.fcastLodQty;
	}
	
	/**
	 * Column Info
	 * @return aloc40ftHcQty
	 */
	public String getAloc40ftHcQty() {
		return this.aloc40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fcast53ftQty
	 */
	public String getFcast53ftQty() {
		return this.fcast53ftQty;
	}
	
	/**
	 * Column Info
	 * @return aloc45ftHcQty
	 */
	public String getAloc45ftHcQty() {
		return this.aloc45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return fcastTtlWgt
	 */
	public String getFcastTtlWgt() {
		return this.fcastTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
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
	 * @return fcastRfQty
	 */
	public String getFcastRfQty() {
		return this.fcastRfQty;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return bseDt
	 */
	public String getBseDt() {
		return this.bseDt;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return fcast45ftHcQty
	 */
	public String getFcast45ftHcQty() {
		return this.fcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return fcast40ftHcQty
	 */
	public String getFcast40ftHcQty() {
		return this.fcast40ftHcQty;
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
	 * @param aloc53ftQty
	 */
	public void setAloc53ftQty(String aloc53ftQty) {
		this.aloc53ftQty = aloc53ftQty;
	}
	
	/**
	 * Column Info
	 * @param alocTtlWgt
	 */
	public void setAlocTtlWgt(String alocTtlWgt) {
		this.alocTtlWgt = alocTtlWgt;
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
	 * @param fcastTtlTeuQty
	 */
	public void setFcastTtlTeuQty(String fcastTtlTeuQty) {
		this.fcastTtlTeuQty = fcastTtlTeuQty;
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
	 * @param alocLodQty
	 */
	public void setAlocLodQty(String alocLodQty) {
		this.alocLodQty = alocLodQty;
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
	 * @param alocRfQty
	 */
	public void setAlocRfQty(String alocRfQty) {
		this.alocRfQty = alocRfQty;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param fcastLodQty
	 */
	public void setFcastLodQty(String fcastLodQty) {
		this.fcastLodQty = fcastLodQty;
	}
	
	/**
	 * Column Info
	 * @param aloc40ftHcQty
	 */
	public void setAloc40ftHcQty(String aloc40ftHcQty) {
		this.aloc40ftHcQty = aloc40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fcast53ftQty
	 */
	public void setFcast53ftQty(String fcast53ftQty) {
		this.fcast53ftQty = fcast53ftQty;
	}
	
	/**
	 * Column Info
	 * @param aloc45ftHcQty
	 */
	public void setAloc45ftHcQty(String aloc45ftHcQty) {
		this.aloc45ftHcQty = aloc45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param fcastTtlWgt
	 */
	public void setFcastTtlWgt(String fcastTtlWgt) {
		this.fcastTtlWgt = fcastTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
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
	 * @param fcastRfQty
	 */
	public void setFcastRfQty(String fcastRfQty) {
		this.fcastRfQty = fcastRfQty;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param bseDt
	 */
	public void setBseDt(String bseDt) {
		this.bseDt = bseDt;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param fcast45ftHcQty
	 */
	public void setFcast45ftHcQty(String fcast45ftHcQty) {
		this.fcast45ftHcQty = fcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param fcast40ftHcQty
	 */
	public void setFcast40ftHcQty(String fcast40ftHcQty) {
		this.fcast40ftHcQty = fcast40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setAloc53ftQty(JSPUtil.getParameter(request, prefix + "aloc_53ft_qty", ""));
		setAlocTtlWgt(JSPUtil.getParameter(request, prefix + "aloc_ttl_wgt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setFcastTtlTeuQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_teu_qty", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setAlocLodQty(JSPUtil.getParameter(request, prefix + "aloc_lod_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAlocRfQty(JSPUtil.getParameter(request, prefix + "aloc_rf_qty", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFcastLodQty(JSPUtil.getParameter(request, prefix + "fcast_lod_qty", ""));
		setAloc40ftHcQty(JSPUtil.getParameter(request, prefix + "aloc_40ft_hc_qty", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setFcast53ftQty(JSPUtil.getParameter(request, prefix + "fcast_53ft_qty", ""));
		setAloc45ftHcQty(JSPUtil.getParameter(request, prefix + "aloc_45ft_hc_qty", ""));
		setFcastTtlWgt(JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setFcastRfQty(JSPUtil.getParameter(request, prefix + "fcast_rf_qty", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBseDt(JSPUtil.getParameter(request, prefix + "bse_dt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setFcast45ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty", ""));
		setFcast40ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDailyForecastHistoryOfcListVO[]
	 */
	public SearchDailyForecastHistoryOfcListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDailyForecastHistoryOfcListVO[]
	 */
	public SearchDailyForecastHistoryOfcListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDailyForecastHistoryOfcListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aloc53ftQty = (JSPUtil.getParameter(request, prefix	+ "aloc_53ft_qty", length));
			String[] alocTtlWgt = (JSPUtil.getParameter(request, prefix	+ "aloc_ttl_wgt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] fcastTtlTeuQty = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_teu_qty", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] alocLodQty = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] alocRfQty = (JSPUtil.getParameter(request, prefix	+ "aloc_rf_qty", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fcastLodQty = (JSPUtil.getParameter(request, prefix	+ "fcast_lod_qty", length));
			String[] aloc40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "aloc_40ft_hc_qty", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] fcast53ftQty = (JSPUtil.getParameter(request, prefix	+ "fcast_53ft_qty", length));
			String[] aloc45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "aloc_45ft_hc_qty", length));
			String[] fcastTtlWgt = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_wgt", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] fcastRfQty = (JSPUtil.getParameter(request, prefix	+ "fcast_rf_qty", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bseDt = (JSPUtil.getParameter(request, prefix	+ "bse_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] fcast45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "fcast_45ft_hc_qty", length));
			String[] fcast40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_hc_qty", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDailyForecastHistoryOfcListVO();
				if (aloc53ftQty[i] != null)
					model.setAloc53ftQty(aloc53ftQty[i]);
				if (alocTtlWgt[i] != null)
					model.setAlocTtlWgt(alocTtlWgt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (fcastTtlTeuQty[i] != null)
					model.setFcastTtlTeuQty(fcastTtlTeuQty[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (alocLodQty[i] != null)
					model.setAlocLodQty(alocLodQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (alocRfQty[i] != null)
					model.setAlocRfQty(alocRfQty[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fcastLodQty[i] != null)
					model.setFcastLodQty(fcastLodQty[i]);
				if (aloc40ftHcQty[i] != null)
					model.setAloc40ftHcQty(aloc40ftHcQty[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (fcast53ftQty[i] != null)
					model.setFcast53ftQty(fcast53ftQty[i]);
				if (aloc45ftHcQty[i] != null)
					model.setAloc45ftHcQty(aloc45ftHcQty[i]);
				if (fcastTtlWgt[i] != null)
					model.setFcastTtlWgt(fcastTtlWgt[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (fcastRfQty[i] != null)
					model.setFcastRfQty(fcastRfQty[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bseDt[i] != null)
					model.setBseDt(bseDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (fcast45ftHcQty[i] != null)
					model.setFcast45ftHcQty(fcast45ftHcQty[i]);
				if (fcast40ftHcQty[i] != null)
					model.setFcast40ftHcQty(fcast40ftHcQty[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDailyForecastHistoryOfcListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDailyForecastHistoryOfcListVO[]
	 */
	public SearchDailyForecastHistoryOfcListVO[] getSearchDailyForecastHistoryOfcListVOs(){
		SearchDailyForecastHistoryOfcListVO[] vos = (SearchDailyForecastHistoryOfcListVO[])models.toArray(new SearchDailyForecastHistoryOfcListVO[models.size()]);
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
		this.aloc53ftQty = this.aloc53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocTtlWgt = this.alocTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlTeuQty = this.fcastTtlTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQty = this.alocLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocRfQty = this.alocRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastLodQty = this.fcastLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc40ftHcQty = this.aloc40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast53ftQty = this.fcast53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc45ftHcQty = this.aloc45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlWgt = this.fcastTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRfQty = this.fcastRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseDt = this.bseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast45ftHcQty = this.fcast45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftHcQty = this.fcast40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
