/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SlotXchLaneVO.java
*@FileTitle : SlotXchLaneVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.20 장강철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SlotXchLaneVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SlotXchLaneVO> models = new ArrayList<SlotXchLaneVO>();
	
	/* Column Info */
	private String rStlBsaSltPrc = null;
	/* Column Info */
	private String acctYrmonFr = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String yrFrom = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String acctYrmonTo = null;
	/* Column Info */
	private String eStlBsaSltPrc = null;
	/* Column Info */
	private String eJoCrrCd = null;
	/* Column Info */
	private String costMon = null;
	/* Column Info */
	private String yrTo = null;
	/* Column Info */
	private String weekMonth = null;
	/* Column Info */
	private String costWkFr = null;
	/* Column Info */
	private String rStlLoclAmt = null;
	/* Column Info */
	private String rJoCrrCd = null;
	/* Column Info */
	private String wkmonFr = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String rStlBsaQty = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String wkmonTo = null;
	/* Column Info */
	private String eStlLoclAmt = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String eStlBsaQty = null;
	/* Column Info */
	private String costWkTo = null;
	/* Column Info */
	private String costWk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SlotXchLaneVO() {}

	public SlotXchLaneVO(String ibflag, String pagerows, String skdDirCd, String costYrmon, String costYr, String costMon, String acctYrmonFr, String acctYrmonTo, String trdCd, String rlaneCd, String vvd, String rStlBsaQty, String rStlBsaSltPrc, String rStlLoclAmt, String rJoCrrCd, String eStlLoclAmt, String eStlBsaSltPrc, String eStlBsaQty, String eJoCrrCd, String acctYrmon, String costWkFr, String costWkTo, String costWk, String yrFrom, String yrTo, String wkmonFr, String wkmonTo, String weekMonth, String joCrrCd, String ofcCd) {
		this.rStlBsaSltPrc = rStlBsaSltPrc;
		this.acctYrmonFr = acctYrmonFr;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.yrFrom = yrFrom;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.acctYrmonTo = acctYrmonTo;
		this.eStlBsaSltPrc = eStlBsaSltPrc;
		this.eJoCrrCd = eJoCrrCd;
		this.costMon = costMon;
		this.yrTo = yrTo;
		this.weekMonth = weekMonth;
		this.costWkFr = costWkFr;
		this.rStlLoclAmt = rStlLoclAmt;
		this.rJoCrrCd = rJoCrrCd;
		this.wkmonFr = wkmonFr;
		this.joCrrCd = joCrrCd;
		this.skdDirCd = skdDirCd;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.rStlBsaQty = rStlBsaQty;
		this.acctYrmon = acctYrmon;
		this.wkmonTo = wkmonTo;
		this.eStlLoclAmt = eStlLoclAmt;
		this.costYr = costYr;
		this.eStlBsaQty = eStlBsaQty;
		this.costWkTo = costWkTo;
		this.costWk = costWk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("r_stl_bsa_slt_prc", getRStlBsaSltPrc());
		this.hashColumns.put("acct_yrmon_fr", getAcctYrmonFr());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("yr_from", getYrFrom());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("acct_yrmon_to", getAcctYrmonTo());
		this.hashColumns.put("e_stl_bsa_slt_prc", getEStlBsaSltPrc());
		this.hashColumns.put("e_jo_crr_cd", getEJoCrrCd());
		this.hashColumns.put("cost_mon", getCostMon());
		this.hashColumns.put("yr_to", getYrTo());
		this.hashColumns.put("week_month", getWeekMonth());
		this.hashColumns.put("cost_wk_fr", getCostWkFr());
		this.hashColumns.put("r_stl_locl_amt", getRStlLoclAmt());
		this.hashColumns.put("r_jo_crr_cd", getRJoCrrCd());
		this.hashColumns.put("wkmon_fr", getWkmonFr());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("r_stl_bsa_qty", getRStlBsaQty());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("wkmon_to", getWkmonTo());
		this.hashColumns.put("e_stl_locl_amt", getEStlLoclAmt());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("e_stl_bsa_qty", getEStlBsaQty());
		this.hashColumns.put("cost_wk_to", getCostWkTo());
		this.hashColumns.put("cost_wk", getCostWk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("r_stl_bsa_slt_prc", "rStlBsaSltPrc");
		this.hashFields.put("acct_yrmon_fr", "acctYrmonFr");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("yr_from", "yrFrom");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("acct_yrmon_to", "acctYrmonTo");
		this.hashFields.put("e_stl_bsa_slt_prc", "eStlBsaSltPrc");
		this.hashFields.put("e_jo_crr_cd", "eJoCrrCd");
		this.hashFields.put("cost_mon", "costMon");
		this.hashFields.put("yr_to", "yrTo");
		this.hashFields.put("week_month", "weekMonth");
		this.hashFields.put("cost_wk_fr", "costWkFr");
		this.hashFields.put("r_stl_locl_amt", "rStlLoclAmt");
		this.hashFields.put("r_jo_crr_cd", "rJoCrrCd");
		this.hashFields.put("wkmon_fr", "wkmonFr");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("r_stl_bsa_qty", "rStlBsaQty");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("wkmon_to", "wkmonTo");
		this.hashFields.put("e_stl_locl_amt", "eStlLoclAmt");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("e_stl_bsa_qty", "eStlBsaQty");
		this.hashFields.put("cost_wk_to", "costWkTo");
		this.hashFields.put("cost_wk", "costWk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rStlBsaSltPrc
	 */
	public String getRStlBsaSltPrc() {
		return this.rStlBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return acctYrmonFr
	 */
	public String getAcctYrmonFr() {
		return this.acctYrmonFr;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return yrFrom
	 */
	public String getYrFrom() {
		return this.yrFrom;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return acctYrmonTo
	 */
	public String getAcctYrmonTo() {
		return this.acctYrmonTo;
	}
	
	/**
	 * Column Info
	 * @return eStlBsaSltPrc
	 */
	public String getEStlBsaSltPrc() {
		return this.eStlBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return eJoCrrCd
	 */
	public String getEJoCrrCd() {
		return this.eJoCrrCd;
	}
	
	/**
	 * Column Info
	 * @return costMon
	 */
	public String getCostMon() {
		return this.costMon;
	}
	
	/**
	 * Column Info
	 * @return yrTo
	 */
	public String getYrTo() {
		return this.yrTo;
	}
	
	/**
	 * Column Info
	 * @return weekMonth
	 */
	public String getWeekMonth() {
		return this.weekMonth;
	}
	
	/**
	 * Column Info
	 * @return costWkFr
	 */
	public String getCostWkFr() {
		return this.costWkFr;
	}
	
	/**
	 * Column Info
	 * @return rStlLoclAmt
	 */
	public String getRStlLoclAmt() {
		return this.rStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return rJoCrrCd
	 */
	public String getRJoCrrCd() {
		return this.rJoCrrCd;
	}
	
	/**
	 * Column Info
	 * @return wkmonFr
	 */
	public String getWkmonFr() {
		return this.wkmonFr;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return rStlBsaQty
	 */
	public String getRStlBsaQty() {
		return this.rStlBsaQty;
	}
	
	/**
	 * Column Info
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
	}
	
	/**
	 * Column Info
	 * @return wkmonTo
	 */
	public String getWkmonTo() {
		return this.wkmonTo;
	}
	
	/**
	 * Column Info
	 * @return eStlLoclAmt
	 */
	public String getEStlLoclAmt() {
		return this.eStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return costYr
	 */
	public String getCostYr() {
		return this.costYr;
	}
	
	/**
	 * Column Info
	 * @return eStlBsaQty
	 */
	public String getEStlBsaQty() {
		return this.eStlBsaQty;
	}
	
	/**
	 * Column Info
	 * @return costWkTo
	 */
	public String getCostWkTo() {
		return this.costWkTo;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	

	/**
	 * Column Info
	 * @param rStlBsaSltPrc
	 */
	public void setRStlBsaSltPrc(String rStlBsaSltPrc) {
		this.rStlBsaSltPrc = rStlBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param acctYrmonFr
	 */
	public void setAcctYrmonFr(String acctYrmonFr) {
		this.acctYrmonFr = acctYrmonFr;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param yrFrom
	 */
	public void setYrFrom(String yrFrom) {
		this.yrFrom = yrFrom;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param acctYrmonTo
	 */
	public void setAcctYrmonTo(String acctYrmonTo) {
		this.acctYrmonTo = acctYrmonTo;
	}
	
	/**
	 * Column Info
	 * @param eStlBsaSltPrc
	 */
	public void setEStlBsaSltPrc(String eStlBsaSltPrc) {
		this.eStlBsaSltPrc = eStlBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param eJoCrrCd
	 */
	public void setEJoCrrCd(String eJoCrrCd) {
		this.eJoCrrCd = eJoCrrCd;
	}
	
	/**
	 * Column Info
	 * @param costMon
	 */
	public void setCostMon(String costMon) {
		this.costMon = costMon;
	}
	
	/**
	 * Column Info
	 * @param yrTo
	 */
	public void setYrTo(String yrTo) {
		this.yrTo = yrTo;
	}
	
	/**
	 * Column Info
	 * @param weekMonth
	 */
	public void setWeekMonth(String weekMonth) {
		this.weekMonth = weekMonth;
	}
	
	/**
	 * Column Info
	 * @param costWkFr
	 */
	public void setCostWkFr(String costWkFr) {
		this.costWkFr = costWkFr;
	}
	
	/**
	 * Column Info
	 * @param rStlLoclAmt
	 */
	public void setRStlLoclAmt(String rStlLoclAmt) {
		this.rStlLoclAmt = rStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param rJoCrrCd
	 */
	public void setRJoCrrCd(String rJoCrrCd) {
		this.rJoCrrCd = rJoCrrCd;
	}
	
	/**
	 * Column Info
	 * @param wkmonFr
	 */
	public void setWkmonFr(String wkmonFr) {
		this.wkmonFr = wkmonFr;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param rStlBsaQty
	 */
	public void setRStlBsaQty(String rStlBsaQty) {
		this.rStlBsaQty = rStlBsaQty;
	}
	
	/**
	 * Column Info
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
	}
	
	/**
	 * Column Info
	 * @param wkmonTo
	 */
	public void setWkmonTo(String wkmonTo) {
		this.wkmonTo = wkmonTo;
	}
	
	/**
	 * Column Info
	 * @param eStlLoclAmt
	 */
	public void setEStlLoclAmt(String eStlLoclAmt) {
		this.eStlLoclAmt = eStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
	}
	
	/**
	 * Column Info
	 * @param eStlBsaQty
	 */
	public void setEStlBsaQty(String eStlBsaQty) {
		this.eStlBsaQty = eStlBsaQty;
	}
	
	/**
	 * Column Info
	 * @param costWkTo
	 */
	public void setCostWkTo(String costWkTo) {
		this.costWkTo = costWkTo;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRStlBsaSltPrc(JSPUtil.getParameter(request, "r_stl_bsa_slt_prc", ""));
		setAcctYrmonFr(JSPUtil.getParameter(request, "acct_yrmon_fr", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setYrFrom(JSPUtil.getParameter(request, "yr_from", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setAcctYrmonTo(JSPUtil.getParameter(request, "acct_yrmon_to", ""));
		setEStlBsaSltPrc(JSPUtil.getParameter(request, "e_stl_bsa_slt_prc", ""));
		setEJoCrrCd(JSPUtil.getParameter(request, "e_jo_crr_cd", ""));
		setCostMon(JSPUtil.getParameter(request, "cost_mon", ""));
		setYrTo(JSPUtil.getParameter(request, "yr_to", ""));
		setWeekMonth(JSPUtil.getParameter(request, "week_month", ""));
		setCostWkFr(JSPUtil.getParameter(request, "cost_wk_fr", ""));
		setRStlLoclAmt(JSPUtil.getParameter(request, "r_stl_locl_amt", ""));
		setRJoCrrCd(JSPUtil.getParameter(request, "r_jo_crr_cd", ""));
		setWkmonFr(JSPUtil.getParameter(request, "wkmon_fr", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setRStlBsaQty(JSPUtil.getParameter(request, "r_stl_bsa_qty", ""));
		setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
		setWkmonTo(JSPUtil.getParameter(request, "wkmon_to", ""));
		setEStlLoclAmt(JSPUtil.getParameter(request, "e_stl_locl_amt", ""));
		setCostYr(JSPUtil.getParameter(request, "cost_yr", ""));
		setEStlBsaQty(JSPUtil.getParameter(request, "e_stl_bsa_qty", ""));
		setCostWkTo(JSPUtil.getParameter(request, "cost_wk_to", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SlotXchLaneVO[]
	 */
	public SlotXchLaneVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SlotXchLaneVO[]
	 */
	public SlotXchLaneVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SlotXchLaneVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rStlBsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "r_stl_bsa_slt_prc", length));
			String[] acctYrmonFr = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon_fr", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] yrFrom = (JSPUtil.getParameter(request, prefix	+ "yr_from", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] acctYrmonTo = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon_to", length));
			String[] eStlBsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "e_stl_bsa_slt_prc", length));
			String[] eJoCrrCd = (JSPUtil.getParameter(request, prefix	+ "e_jo_crr_cd", length));
			String[] costMon = (JSPUtil.getParameter(request, prefix	+ "cost_mon", length));
			String[] yrTo = (JSPUtil.getParameter(request, prefix	+ "yr_to", length));
			String[] weekMonth = (JSPUtil.getParameter(request, prefix	+ "week_month", length));
			String[] costWkFr = (JSPUtil.getParameter(request, prefix	+ "cost_wk_fr", length));
			String[] rStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "r_stl_locl_amt", length));
			String[] rJoCrrCd = (JSPUtil.getParameter(request, prefix	+ "r_jo_crr_cd", length));
			String[] wkmonFr = (JSPUtil.getParameter(request, prefix	+ "wkmon_fr", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] rStlBsaQty = (JSPUtil.getParameter(request, prefix	+ "r_stl_bsa_qty", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] wkmonTo = (JSPUtil.getParameter(request, prefix	+ "wkmon_to", length));
			String[] eStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "e_stl_locl_amt", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] eStlBsaQty = (JSPUtil.getParameter(request, prefix	+ "e_stl_bsa_qty", length));
			String[] costWkTo = (JSPUtil.getParameter(request, prefix	+ "cost_wk_to", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SlotXchLaneVO();
				if (rStlBsaSltPrc[i] != null)
					model.setRStlBsaSltPrc(rStlBsaSltPrc[i]);
				if (acctYrmonFr[i] != null)
					model.setAcctYrmonFr(acctYrmonFr[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (yrFrom[i] != null)
					model.setYrFrom(yrFrom[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (acctYrmonTo[i] != null)
					model.setAcctYrmonTo(acctYrmonTo[i]);
				if (eStlBsaSltPrc[i] != null)
					model.setEStlBsaSltPrc(eStlBsaSltPrc[i]);
				if (eJoCrrCd[i] != null)
					model.setEJoCrrCd(eJoCrrCd[i]);
				if (costMon[i] != null)
					model.setCostMon(costMon[i]);
				if (yrTo[i] != null)
					model.setYrTo(yrTo[i]);
				if (weekMonth[i] != null)
					model.setWeekMonth(weekMonth[i]);
				if (costWkFr[i] != null)
					model.setCostWkFr(costWkFr[i]);
				if (rStlLoclAmt[i] != null)
					model.setRStlLoclAmt(rStlLoclAmt[i]);
				if (rJoCrrCd[i] != null)
					model.setRJoCrrCd(rJoCrrCd[i]);
				if (wkmonFr[i] != null)
					model.setWkmonFr(wkmonFr[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (rStlBsaQty[i] != null)
					model.setRStlBsaQty(rStlBsaQty[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (wkmonTo[i] != null)
					model.setWkmonTo(wkmonTo[i]);
				if (eStlLoclAmt[i] != null)
					model.setEStlLoclAmt(eStlLoclAmt[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (eStlBsaQty[i] != null)
					model.setEStlBsaQty(eStlBsaQty[i]);
				if (costWkTo[i] != null)
					model.setCostWkTo(costWkTo[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSlotXchLaneVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SlotXchLaneVO[]
	 */
	public SlotXchLaneVO[] getSlotXchLaneVOs(){
		SlotXchLaneVO[] vos = (SlotXchLaneVO[])models.toArray(new SlotXchLaneVO[models.size()]);
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
		this.rStlBsaSltPrc = this.rStlBsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmonFr = this.acctYrmonFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrFrom = this.yrFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmonTo = this.acctYrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eStlBsaSltPrc = this.eStlBsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eJoCrrCd = this.eJoCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costMon = this.costMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrTo = this.yrTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekMonth = this.weekMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWkFr = this.costWkFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rStlLoclAmt = this.rStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rJoCrrCd = this.rJoCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkmonFr = this.wkmonFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rStlBsaQty = this.rStlBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkmonTo = this.wkmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eStlLoclAmt = this.eStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eStlBsaQty = this.eStlBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWkTo = this.costWkTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
