/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InlandRouteSelCreVO.java
*@FileTitle : InlandRouteSelCreVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.01 김귀진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InlandRouteSelCreVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InlandRouteSelCreVO> models = new ArrayList<InlandRouteSelCreVO>();
	
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String iOrgCd = null;
	/* Column Info */
	private String hubSearchGb = null;
	/* Column Info */
	private String fromChk = null;
	/* Column Info */
	private String fmtTotTt = null;
	/* Column Info */
	private String sumDwTt = null;
	/* Column Info */
	private String routOrgNodCd = null;
	/* Column Info */
	private String trspMod = null;
	/* Column Info */
	private String trspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totTt = null;
	/* Column Info */
	private String routDestNodCd = null;
	/* Column Info */
	private String orgLoc = null;
	/* Column Info */
	private String frontGb = null;
	/* Column Info */
	private String iDestCd = null;
	/* Column Info */
	private String toChk = null;
	/* Column Info */
	private String destLocType = null;
	/* Column Info */
	private String groupGubun = null;
	/* Column Info */
	private String chkBf = null;
	/* Column Info */
	private String sumTtTime = null;
	/* Column Info */
	private String firstmod = null;
	/* Column Info */
	private String destLoc = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String inlndRoutRmk = null;
	/* Column Info */
	private String route = null;
	/* Column Info */
	private String rInbound = null;
	/* Column Info */
	private String nodTp2 = null;
	/* Column Info */
	private String nodTp1 = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String prioSeq = null;
	/* Column Info */
	private String orgLocType = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Column Info */
	private String undefineNod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InlandRouteSelCreVO() {}

	public InlandRouteSelCreVO(String ibflag, String pagerows, String routOrgNodCd, String routDestNodCd, String rn, String inlndRoutRmk, String orgLoc, String orgLocType, String destLoc, String destLocType, String routSeq, String prioSeq, String sumTtTime, String sumDwTt, String totTt, String trspMod, String fmtTotTt, String hubSearchGb, String frontGb, String undefineNod, String groupGubun, String nodCd, String route, String firstmod, String rInbound, String fromChk, String toChk, String iDestCd, String iOrgCd, String hubLocCd, String trspModCd, String nodTp1, String nodTp2, String chkBf) {
		this.rn = rn;
		this.iOrgCd = iOrgCd;
		this.hubSearchGb = hubSearchGb;
		this.fromChk = fromChk;
		this.fmtTotTt = fmtTotTt;
		this.sumDwTt = sumDwTt;
		this.routOrgNodCd = routOrgNodCd;
		this.trspMod = trspMod;
		this.trspModCd = trspModCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.totTt = totTt;
		this.routDestNodCd = routDestNodCd;
		this.orgLoc = orgLoc;
		this.frontGb = frontGb;
		this.iDestCd = iDestCd;
		this.toChk = toChk;
		this.destLocType = destLocType;
		this.groupGubun = groupGubun;
		this.chkBf = chkBf;
		this.sumTtTime = sumTtTime;
		this.firstmod = firstmod;
		this.destLoc = destLoc;
		this.routSeq = routSeq;
		this.inlndRoutRmk = inlndRoutRmk;
		this.route = route;
		this.rInbound = rInbound;
		this.nodTp2 = nodTp2;
		this.nodTp1 = nodTp1;
		this.nodCd = nodCd;
		this.prioSeq = prioSeq;
		this.orgLocType = orgLocType;
		this.hubLocCd = hubLocCd;
		this.undefineNod = undefineNod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("i_org_cd", getIOrgCd());
		this.hashColumns.put("hub_search_gb", getHubSearchGb());
		this.hashColumns.put("from_chk", getFromChk());
		this.hashColumns.put("fmt_tot_tt", getFmtTotTt());
		this.hashColumns.put("sum_dw_tt", getSumDwTt());
		this.hashColumns.put("rout_org_nod_cd", getRoutOrgNodCd());
		this.hashColumns.put("trsp_mod", getTrspMod());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tot_tt", getTotTt());
		this.hashColumns.put("rout_dest_nod_cd", getRoutDestNodCd());
		this.hashColumns.put("org_loc", getOrgLoc());
		this.hashColumns.put("front_gb", getFrontGb());
		this.hashColumns.put("i_dest_cd", getIDestCd());
		this.hashColumns.put("to_chk", getToChk());
		this.hashColumns.put("dest_loc_type", getDestLocType());
		this.hashColumns.put("group_gubun", getGroupGubun());
		this.hashColumns.put("chk_bf", getChkBf());
		this.hashColumns.put("sum_tt_time", getSumTtTime());
		this.hashColumns.put("firstmod", getFirstmod());
		this.hashColumns.put("dest_loc", getDestLoc());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("inlnd_rout_rmk", getInlndRoutRmk());
		this.hashColumns.put("route", getRoute());
		this.hashColumns.put("r_inbound", getRInbound());
		this.hashColumns.put("nod_tp2", getNodTp2());
		this.hashColumns.put("nod_tp1", getNodTp1());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("prio_seq", getPrioSeq());
		this.hashColumns.put("org_loc_type", getOrgLocType());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("undefine_nod", getUndefineNod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rn", "rn");
		this.hashFields.put("i_org_cd", "iOrgCd");
		this.hashFields.put("hub_search_gb", "hubSearchGb");
		this.hashFields.put("from_chk", "fromChk");
		this.hashFields.put("fmt_tot_tt", "fmtTotTt");
		this.hashFields.put("sum_dw_tt", "sumDwTt");
		this.hashFields.put("rout_org_nod_cd", "routOrgNodCd");
		this.hashFields.put("trsp_mod", "trspMod");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tot_tt", "totTt");
		this.hashFields.put("rout_dest_nod_cd", "routDestNodCd");
		this.hashFields.put("org_loc", "orgLoc");
		this.hashFields.put("front_gb", "frontGb");
		this.hashFields.put("i_dest_cd", "iDestCd");
		this.hashFields.put("to_chk", "toChk");
		this.hashFields.put("dest_loc_type", "destLocType");
		this.hashFields.put("group_gubun", "groupGubun");
		this.hashFields.put("chk_bf", "chkBf");
		this.hashFields.put("sum_tt_time", "sumTtTime");
		this.hashFields.put("firstmod", "firstmod");
		this.hashFields.put("dest_loc", "destLoc");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("inlnd_rout_rmk", "inlndRoutRmk");
		this.hashFields.put("route", "route");
		this.hashFields.put("r_inbound", "rInbound");
		this.hashFields.put("nod_tp2", "nodTp2");
		this.hashFields.put("nod_tp1", "nodTp1");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("prio_seq", "prioSeq");
		this.hashFields.put("org_loc_type", "orgLocType");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("undefine_nod", "undefineNod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
	}
	
	/**
	 * Column Info
	 * @return iOrgCd
	 */
	public String getIOrgCd() {
		return this.iOrgCd;
	}
	
	/**
	 * Column Info
	 * @return hubSearchGb
	 */
	public String getHubSearchGb() {
		return this.hubSearchGb;
	}
	
	/**
	 * Column Info
	 * @return fromChk
	 */
	public String getFromChk() {
		return this.fromChk;
	}
	
	/**
	 * Column Info
	 * @return fmtTotTt
	 */
	public String getFmtTotTt() {
		return this.fmtTotTt;
	}
	
	/**
	 * Column Info
	 * @return sumDwTt
	 */
	public String getSumDwTt() {
		return this.sumDwTt;
	}
	
	/**
	 * Column Info
	 * @return routOrgNodCd
	 */
	public String getRoutOrgNodCd() {
		return this.routOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspMod
	 */
	public String getTrspMod() {
		return this.trspMod;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
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
	 * @return totTt
	 */
	public String getTotTt() {
		return this.totTt;
	}
	
	/**
	 * Column Info
	 * @return routDestNodCd
	 */
	public String getRoutDestNodCd() {
		return this.routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @return orgLoc
	 */
	public String getOrgLoc() {
		return this.orgLoc;
	}
	
	/**
	 * Column Info
	 * @return frontGb
	 */
	public String getFrontGb() {
		return this.frontGb;
	}
	
	/**
	 * Column Info
	 * @return iDestCd
	 */
	public String getIDestCd() {
		return this.iDestCd;
	}
	
	/**
	 * Column Info
	 * @return toChk
	 */
	public String getToChk() {
		return this.toChk;
	}
	
	/**
	 * Column Info
	 * @return destLocType
	 */
	public String getDestLocType() {
		return this.destLocType;
	}
	
	/**
	 * Column Info
	 * @return groupGubun
	 */
	public String getGroupGubun() {
		return this.groupGubun;
	}
	
	/**
	 * Column Info
	 * @return chkBf
	 */
	public String getChkBf() {
		return this.chkBf;
	}
	
	/**
	 * Column Info
	 * @return sumTtTime
	 */
	public String getSumTtTime() {
		return this.sumTtTime;
	}
	
	/**
	 * Column Info
	 * @return firstmod
	 */
	public String getFirstmod() {
		return this.firstmod;
	}
	
	/**
	 * Column Info
	 * @return destLoc
	 */
	public String getDestLoc() {
		return this.destLoc;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutRmk
	 */
	public String getInlndRoutRmk() {
		return this.inlndRoutRmk;
	}
	
	/**
	 * Column Info
	 * @return route
	 */
	public String getRoute() {
		return this.route;
	}
	
	/**
	 * Column Info
	 * @return rInbound
	 */
	public String getRInbound() {
		return this.rInbound;
	}
	
	/**
	 * Column Info
	 * @return nodTp2
	 */
	public String getNodTp2() {
		return this.nodTp2;
	}
	
	/**
	 * Column Info
	 * @return nodTp1
	 */
	public String getNodTp1() {
		return this.nodTp1;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return prioSeq
	 */
	public String getPrioSeq() {
		return this.prioSeq;
	}
	
	/**
	 * Column Info
	 * @return orgLocType
	 */
	public String getOrgLocType() {
		return this.orgLocType;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	
	/**
	 * Column Info
	 * @return undefineNod
	 */
	public String getUndefineNod() {
		return this.undefineNod;
	}
	

	/**
	 * Column Info
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}
	
	/**
	 * Column Info
	 * @param iOrgCd
	 */
	public void setIOrgCd(String iOrgCd) {
		this.iOrgCd = iOrgCd;
	}
	
	/**
	 * Column Info
	 * @param hubSearchGb
	 */
	public void setHubSearchGb(String hubSearchGb) {
		this.hubSearchGb = hubSearchGb;
	}
	
	/**
	 * Column Info
	 * @param fromChk
	 */
	public void setFromChk(String fromChk) {
		this.fromChk = fromChk;
	}
	
	/**
	 * Column Info
	 * @param fmtTotTt
	 */
	public void setFmtTotTt(String fmtTotTt) {
		this.fmtTotTt = fmtTotTt;
	}
	
	/**
	 * Column Info
	 * @param sumDwTt
	 */
	public void setSumDwTt(String sumDwTt) {
		this.sumDwTt = sumDwTt;
	}
	
	/**
	 * Column Info
	 * @param routOrgNodCd
	 */
	public void setRoutOrgNodCd(String routOrgNodCd) {
		this.routOrgNodCd = routOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspMod
	 */
	public void setTrspMod(String trspMod) {
		this.trspMod = trspMod;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
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
	 * @param totTt
	 */
	public void setTotTt(String totTt) {
		this.totTt = totTt;
	}
	
	/**
	 * Column Info
	 * @param routDestNodCd
	 */
	public void setRoutDestNodCd(String routDestNodCd) {
		this.routDestNodCd = routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @param orgLoc
	 */
	public void setOrgLoc(String orgLoc) {
		this.orgLoc = orgLoc;
	}
	
	/**
	 * Column Info
	 * @param frontGb
	 */
	public void setFrontGb(String frontGb) {
		this.frontGb = frontGb;
	}
	
	/**
	 * Column Info
	 * @param iDestCd
	 */
	public void setIDestCd(String iDestCd) {
		this.iDestCd = iDestCd;
	}
	
	/**
	 * Column Info
	 * @param toChk
	 */
	public void setToChk(String toChk) {
		this.toChk = toChk;
	}
	
	/**
	 * Column Info
	 * @param destLocType
	 */
	public void setDestLocType(String destLocType) {
		this.destLocType = destLocType;
	}
	
	/**
	 * Column Info
	 * @param groupGubun
	 */
	public void setGroupGubun(String groupGubun) {
		this.groupGubun = groupGubun;
	}
	
	/**
	 * Column Info
	 * @param chkBf
	 */
	public void setChkBf(String chkBf) {
		this.chkBf = chkBf;
	}
	
	/**
	 * Column Info
	 * @param sumTtTime
	 */
	public void setSumTtTime(String sumTtTime) {
		this.sumTtTime = sumTtTime;
	}
	
	/**
	 * Column Info
	 * @param firstmod
	 */
	public void setFirstmod(String firstmod) {
		this.firstmod = firstmod;
	}
	
	/**
	 * Column Info
	 * @param destLoc
	 */
	public void setDestLoc(String destLoc) {
		this.destLoc = destLoc;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutRmk
	 */
	public void setInlndRoutRmk(String inlndRoutRmk) {
		this.inlndRoutRmk = inlndRoutRmk;
	}
	
	/**
	 * Column Info
	 * @param route
	 */
	public void setRoute(String route) {
		this.route = route;
	}
	
	/**
	 * Column Info
	 * @param rInbound
	 */
	public void setRInbound(String rInbound) {
		this.rInbound = rInbound;
	}
	
	/**
	 * Column Info
	 * @param nodTp2
	 */
	public void setNodTp2(String nodTp2) {
		this.nodTp2 = nodTp2;
	}
	
	/**
	 * Column Info
	 * @param nodTp1
	 */
	public void setNodTp1(String nodTp1) {
		this.nodTp1 = nodTp1;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param prioSeq
	 */
	public void setPrioSeq(String prioSeq) {
		this.prioSeq = prioSeq;
	}
	
	/**
	 * Column Info
	 * @param orgLocType
	 */
	public void setOrgLocType(String orgLocType) {
		this.orgLocType = orgLocType;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Column Info
	 * @param undefineNod
	 */
	public void setUndefineNod(String undefineNod) {
		this.undefineNod = undefineNod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRn(JSPUtil.getParameter(request, "rn", ""));
		setIOrgCd(JSPUtil.getParameter(request, "i_org_cd", ""));
		setHubSearchGb(JSPUtil.getParameter(request, "hub_search_gb", ""));
		setFromChk(JSPUtil.getParameter(request, "from_chk", ""));
		setFmtTotTt(JSPUtil.getParameter(request, "fmt_tot_tt", ""));
		setSumDwTt(JSPUtil.getParameter(request, "sum_dw_tt", ""));
		setRoutOrgNodCd(JSPUtil.getParameter(request, "rout_org_nod_cd", ""));
		setTrspMod(JSPUtil.getParameter(request, "trsp_mod", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTotTt(JSPUtil.getParameter(request, "tot_tt", ""));
		setRoutDestNodCd(JSPUtil.getParameter(request, "rout_dest_nod_cd", ""));
		setOrgLoc(JSPUtil.getParameter(request, "org_loc", ""));
		setFrontGb(JSPUtil.getParameter(request, "front_gb", ""));
		setIDestCd(JSPUtil.getParameter(request, "i_dest_cd", ""));
		setToChk(JSPUtil.getParameter(request, "to_chk", ""));
		setDestLocType(JSPUtil.getParameter(request, "dest_loc_type", ""));
		setGroupGubun(JSPUtil.getParameter(request, "group_gubun", ""));
		setChkBf(JSPUtil.getParameter(request, "chk_bf", ""));
		setSumTtTime(JSPUtil.getParameter(request, "sum_tt_time", ""));
		setFirstmod(JSPUtil.getParameter(request, "firstmod", ""));
		setDestLoc(JSPUtil.getParameter(request, "dest_loc", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setInlndRoutRmk(JSPUtil.getParameter(request, "inlnd_rout_rmk", ""));
		setRoute(JSPUtil.getParameter(request, "route", ""));
		setRInbound(JSPUtil.getParameter(request, "r_inbound", ""));
		setNodTp2(JSPUtil.getParameter(request, "nod_tp2", ""));
		setNodTp1(JSPUtil.getParameter(request, "nod_tp1", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setPrioSeq(JSPUtil.getParameter(request, "prio_seq", ""));
		setOrgLocType(JSPUtil.getParameter(request, "org_loc_type", ""));
		setHubLocCd(JSPUtil.getParameter(request, "hub_loc_cd", ""));
		setUndefineNod(JSPUtil.getParameter(request, "undefine_nod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InlandRouteSelCreVO[]
	 */
	public InlandRouteSelCreVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InlandRouteSelCreVO[]
	 */
	public InlandRouteSelCreVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InlandRouteSelCreVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] iOrgCd = (JSPUtil.getParameter(request, prefix	+ "i_org_cd", length));
			String[] hubSearchGb = (JSPUtil.getParameter(request, prefix	+ "hub_search_gb", length));
			String[] fromChk = (JSPUtil.getParameter(request, prefix	+ "from_chk", length));
			String[] fmtTotTt = (JSPUtil.getParameter(request, prefix	+ "fmt_tot_tt", length));
			String[] sumDwTt = (JSPUtil.getParameter(request, prefix	+ "sum_dw_tt", length));
			String[] routOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_org_nod_cd", length));
			String[] trspMod = (JSPUtil.getParameter(request, prefix	+ "trsp_mod", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totTt = (JSPUtil.getParameter(request, prefix	+ "tot_tt", length));
			String[] routDestNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_dest_nod_cd", length));
			String[] orgLoc = (JSPUtil.getParameter(request, prefix	+ "org_loc", length));
			String[] frontGb = (JSPUtil.getParameter(request, prefix	+ "front_gb", length));
			String[] iDestCd = (JSPUtil.getParameter(request, prefix	+ "i_dest_cd", length));
			String[] toChk = (JSPUtil.getParameter(request, prefix	+ "to_chk", length));
			String[] destLocType = (JSPUtil.getParameter(request, prefix	+ "dest_loc_type", length));
			String[] groupGubun = (JSPUtil.getParameter(request, prefix	+ "group_gubun", length));
			String[] chkBf = (JSPUtil.getParameter(request, prefix	+ "chk_bf", length));
			String[] sumTtTime = (JSPUtil.getParameter(request, prefix	+ "sum_tt_time", length));
			String[] firstmod = (JSPUtil.getParameter(request, prefix	+ "firstmod", length));
			String[] destLoc = (JSPUtil.getParameter(request, prefix	+ "dest_loc", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] inlndRoutRmk = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_rmk", length));
			String[] route = (JSPUtil.getParameter(request, prefix	+ "route", length));
			String[] rInbound = (JSPUtil.getParameter(request, prefix	+ "r_inbound", length));
			String[] nodTp2 = (JSPUtil.getParameter(request, prefix	+ "nod_tp2", length));
			String[] nodTp1 = (JSPUtil.getParameter(request, prefix	+ "nod_tp1", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] prioSeq = (JSPUtil.getParameter(request, prefix	+ "prio_seq", length));
			String[] orgLocType = (JSPUtil.getParameter(request, prefix	+ "org_loc_type", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			String[] undefineNod = (JSPUtil.getParameter(request, prefix	+ "undefine_nod", length));
			
			for (int i = 0; i < length; i++) {
				model = new InlandRouteSelCreVO();
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (iOrgCd[i] != null)
					model.setIOrgCd(iOrgCd[i]);
				if (hubSearchGb[i] != null)
					model.setHubSearchGb(hubSearchGb[i]);
				if (fromChk[i] != null)
					model.setFromChk(fromChk[i]);
				if (fmtTotTt[i] != null)
					model.setFmtTotTt(fmtTotTt[i]);
				if (sumDwTt[i] != null)
					model.setSumDwTt(sumDwTt[i]);
				if (routOrgNodCd[i] != null)
					model.setRoutOrgNodCd(routOrgNodCd[i]);
				if (trspMod[i] != null)
					model.setTrspMod(trspMod[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totTt[i] != null)
					model.setTotTt(totTt[i]);
				if (routDestNodCd[i] != null)
					model.setRoutDestNodCd(routDestNodCd[i]);
				if (orgLoc[i] != null)
					model.setOrgLoc(orgLoc[i]);
				if (frontGb[i] != null)
					model.setFrontGb(frontGb[i]);
				if (iDestCd[i] != null)
					model.setIDestCd(iDestCd[i]);
				if (toChk[i] != null)
					model.setToChk(toChk[i]);
				if (destLocType[i] != null)
					model.setDestLocType(destLocType[i]);
				if (groupGubun[i] != null)
					model.setGroupGubun(groupGubun[i]);
				if (chkBf[i] != null)
					model.setChkBf(chkBf[i]);
				if (sumTtTime[i] != null)
					model.setSumTtTime(sumTtTime[i]);
				if (firstmod[i] != null)
					model.setFirstmod(firstmod[i]);
				if (destLoc[i] != null)
					model.setDestLoc(destLoc[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (inlndRoutRmk[i] != null)
					model.setInlndRoutRmk(inlndRoutRmk[i]);
				if (route[i] != null)
					model.setRoute(route[i]);
				if (rInbound[i] != null)
					model.setRInbound(rInbound[i]);
				if (nodTp2[i] != null)
					model.setNodTp2(nodTp2[i]);
				if (nodTp1[i] != null)
					model.setNodTp1(nodTp1[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (prioSeq[i] != null)
					model.setPrioSeq(prioSeq[i]);
				if (orgLocType[i] != null)
					model.setOrgLocType(orgLocType[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (undefineNod[i] != null)
					model.setUndefineNod(undefineNod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInlandRouteSelCreVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InlandRouteSelCreVO[]
	 */
	public InlandRouteSelCreVO[] getInlandRouteSelCreVOs(){
		InlandRouteSelCreVO[] vos = (InlandRouteSelCreVO[])models.toArray(new InlandRouteSelCreVO[models.size()]);
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
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOrgCd = this.iOrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubSearchGb = this.hubSearchGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromChk = this.fromChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTotTt = this.fmtTotTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumDwTt = this.sumDwTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routOrgNodCd = this.routOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMod = this.trspMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTt = this.totTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDestNodCd = this.routDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLoc = this.orgLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frontGb = this.frontGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iDestCd = this.iDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toChk = this.toChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocType = this.destLocType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupGubun = this.groupGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkBf = this.chkBf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTtTime = this.sumTtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstmod = this.firstmod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLoc = this.destLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutRmk = this.inlndRoutRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.route = this.route .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rInbound = this.rInbound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodTp2 = this.nodTp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodTp1 = this.nodTp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prioSeq = this.prioSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLocType = this.orgLocType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.undefineNod = this.undefineNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
