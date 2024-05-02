/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LoadFactorByTradeLaneVvdVO.java
*@FileTitle : LoadFactorByTradeLaneVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.06.15 박광석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo;

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
 * @author 박광석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LoadFactorByTradeLaneVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LoadFactorByTradeLaneVvdVO> models = new ArrayList<LoadFactorByTradeLaneVvdVO>();
	
	/* Column Info */
	private String unusedspace = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String teutotal = null;
	/* Column Info */
	private String mty40qty = null;
	/* Column Info */
	private String bsaweight = null;
	/* Column Info */
	private String full40qty = null;
	/* Column Info */
	private String bsaspace = null;
	/* Column Info */
	private String fulltotal = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String lfeq = null;
	/* Column Info */
	private String releasedteu = null;
	/* Column Info */
	private String unusedweight = null;
	/* Column Info */
	private String full45qty = null;
	/* Column Info */
	private String boxtotal = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lfwgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mty20qty = null;
	/* Column Info */
	private String atdWeek = null;
	/* Column Info */
	private String mtytotal = null;
	/* Column Info */
	private String atd = null;
	/* Column Info */
	private String datasource = null;
	/* Column Info */
	private String lffull = null;
	/* Column Info */
	private String releasedweight = null;
	/* Column Info */
	private String mtyhcqty = null;
	/* Column Info */
	private String fullhcqty = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String weighttotal = null;
	/* Column Info */
	private String deadslot = null;
	/* Column Info */
	private String full20qty = null;
	/* Column Info */
	private String mty45qty = null;
	/* Column Info */
	private String callind = null;
	/* Column Info */
	private String callseq = null;
	/* Column Info */
	private String fromregion = null;
	/* Column Info */
	private String colsorts = null;
	
	public String getColsorts() {
		return colsorts;
	}

	public void setColsorts(String colsorts) {
		this.colsorts = colsorts;
	}

	public String getFromregion() {
		return fromregion;
	}

	public void setFromregion(String fromregion) {
		this.fromregion = fromregion;
	}

	public String getCallind() {
		return callind;
	}

	public void setCallind(String callind) {
		this.callind = callind;
	}

	public String getCallseq() {
		return callseq;
	}

	public void setCallseq(String callseq) {
		this.callseq = callseq;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LoadFactorByTradeLaneVvdVO() {}

	public LoadFactorByTradeLaneVvdVO(String ibflag, String pagerows, String company, String region, String trade, String lane, String vvd, String port, String atd, String atdWeek, String full20qty, String full40qty, String fullhcqty, String full45qty, String mty20qty, String mty40qty, String mtyhcqty, String mty45qty, String deadslot, String weighttotal, String releasedteu, String releasedweight, String bsaspace, String bsaweight, String datasource, String fulltotal, String mtytotal, String boxtotal, String teutotal, String unusedspace, String unusedweight, String lffull, String lfeq, String lfwgt,String callind,String callseq,String fromregion,String colsorts) {
		this.unusedspace = unusedspace;
		this.callind = callind;
		this.callseq = callseq;
		this.fromregion = fromregion;
		this.port = port;
		this.region = region;
		this.teutotal = teutotal;
		this.mty40qty = mty40qty;
		this.bsaweight = bsaweight;
		this.full40qty = full40qty;
		this.bsaspace = bsaspace;
		this.fulltotal = fulltotal;
		this.trade = trade;
		this.lfeq = lfeq;
		this.releasedteu = releasedteu;
		this.unusedweight = unusedweight;
		this.full45qty = full45qty;
		this.boxtotal = boxtotal;
		this.lane = lane;
		this.pagerows = pagerows;
		this.lfwgt = lfwgt;
		this.ibflag = ibflag;
		this.mty20qty = mty20qty;
		this.atdWeek = atdWeek;
		this.mtytotal = mtytotal;
		this.atd = atd;
		this.datasource = datasource;
		this.lffull = lffull;
		this.releasedweight = releasedweight;
		this.mtyhcqty = mtyhcqty;
		this.fullhcqty = fullhcqty;
		this.vvd = vvd;
		this.company = company;
		this.weighttotal = weighttotal;
		this.deadslot = deadslot;
		this.full20qty = full20qty;
		this.mty45qty = mty45qty;
		this.colsorts = colsorts;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("unusedspace", getUnusedspace());
		this.hashColumns.put("callind", getCallind());
		this.hashColumns.put("callseq", getCallseq());
		this.hashColumns.put("fromregion", getFromregion());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("teutotal", getTeutotal());
		this.hashColumns.put("mty40qty", getMty40qty());
		this.hashColumns.put("bsaweight", getBsaweight());
		this.hashColumns.put("full40qty", getFull40qty());
		this.hashColumns.put("bsaspace", getBsaspace());
		this.hashColumns.put("fulltotal", getFulltotal());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("lfeq", getLfeq());
		this.hashColumns.put("releasedteu", getReleasedteu());
		this.hashColumns.put("unusedweight", getUnusedweight());
		this.hashColumns.put("full45qty", getFull45qty());
		this.hashColumns.put("boxtotal", getBoxtotal());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lfwgt", getLfwgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mty20qty", getMty20qty());
		this.hashColumns.put("atd_week", getAtdWeek());
		this.hashColumns.put("mtytotal", getMtytotal());
		this.hashColumns.put("atd", getAtd());
		this.hashColumns.put("datasource", getDatasource());
		this.hashColumns.put("lffull", getLffull());
		this.hashColumns.put("releasedweight", getReleasedweight());
		this.hashColumns.put("mtyhcqty", getMtyhcqty());
		this.hashColumns.put("fullhcqty", getFullhcqty());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("weighttotal", getWeighttotal());
		this.hashColumns.put("deadslot", getDeadslot());
		this.hashColumns.put("full20qty", getFull20qty());
		this.hashColumns.put("mty45qty", getMty45qty());
		this.hashColumns.put("colsorts", getColsorts());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("unusedspace", "unusedspace");
		this.hashFields.put("port", "port");
		this.hashFields.put("region", "region");
		this.hashFields.put("teutotal", "teutotal");
		this.hashFields.put("mty40qty", "mty40qty");
		this.hashFields.put("bsaweight", "bsaweight");
		this.hashFields.put("full40qty", "full40qty");
		this.hashFields.put("bsaspace", "bsaspace");
		this.hashFields.put("fulltotal", "fulltotal");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("lfeq", "lfeq");
		this.hashFields.put("releasedteu", "releasedteu");
		this.hashFields.put("unusedweight", "unusedweight");
		this.hashFields.put("full45qty", "full45qty");
		this.hashFields.put("boxtotal", "boxtotal");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lfwgt", "lfwgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mty20qty", "mty20qty");
		this.hashFields.put("atd_week", "atdWeek");
		this.hashFields.put("mtytotal", "mtytotal");
		this.hashFields.put("atd", "atd");
		this.hashFields.put("datasource", "datasource");
		this.hashFields.put("lffull", "lffull");
		this.hashFields.put("releasedweight", "releasedweight");
		this.hashFields.put("mtyhcqty", "mtyhcqty");
		this.hashFields.put("fullhcqty", "fullhcqty");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("company", "company");
		this.hashFields.put("weighttotal", "weighttotal");
		this.hashFields.put("deadslot", "deadslot");
		this.hashFields.put("full20qty", "full20qty");
		this.hashFields.put("mty45qty", "mty45qty");
		this.hashFields.put("callind", "callind");
		this.hashFields.put("callseq", "callseq");
		this.hashFields.put("fromregion", "fromregion");
		this.hashFields.put("colsorts", "colsorts");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return unusedspace
	 */
	public String getUnusedspace() {
		return this.unusedspace;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Column Info
	 * @return teutotal
	 */
	public String getTeutotal() {
		return this.teutotal;
	}
	
	/**
	 * Column Info
	 * @return mty40qty
	 */
	public String getMty40qty() {
		return this.mty40qty;
	}
	
	/**
	 * Column Info
	 * @return bsaweight
	 */
	public String getBsaweight() {
		return this.bsaweight;
	}
	
	/**
	 * Column Info
	 * @return full40qty
	 */
	public String getFull40qty() {
		return this.full40qty;
	}
	
	/**
	 * Column Info
	 * @return bsaspace
	 */
	public String getBsaspace() {
		return this.bsaspace;
	}
	
	/**
	 * Column Info
	 * @return fulltotal
	 */
	public String getFulltotal() {
		return this.fulltotal;
	}
	
	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}
	
	/**
	 * Column Info
	 * @return lfeq
	 */
	public String getLfeq() {
		return this.lfeq;
	}
	
	/**
	 * Column Info
	 * @return releasedteu
	 */
	public String getReleasedteu() {
		return this.releasedteu;
	}
	
	/**
	 * Column Info
	 * @return unusedweight
	 */
	public String getUnusedweight() {
		return this.unusedweight;
	}
	
	/**
	 * Column Info
	 * @return full45qty
	 */
	public String getFull45qty() {
		return this.full45qty;
	}
	
	/**
	 * Column Info
	 * @return boxtotal
	 */
	public String getBoxtotal() {
		return this.boxtotal;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return lfwgt
	 */
	public String getLfwgt() {
		return this.lfwgt;
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
	 * @return mty20qty
	 */
	public String getMty20qty() {
		return this.mty20qty;
	}
	
	/**
	 * Column Info
	 * @return atdWeek
	 */
	public String getAtdWeek() {
		return this.atdWeek;
	}
	
	/**
	 * Column Info
	 * @return mtytotal
	 */
	public String getMtytotal() {
		return this.mtytotal;
	}
	
	/**
	 * Column Info
	 * @return atd
	 */
	public String getAtd() {
		return this.atd;
	}
	
	/**
	 * Column Info
	 * @return datasource
	 */
	public String getDatasource() {
		return this.datasource;
	}
	
	/**
	 * Column Info
	 * @return lffull
	 */
	public String getLffull() {
		return this.lffull;
	}
	
	/**
	 * Column Info
	 * @return releasedweight
	 */
	public String getReleasedweight() {
		return this.releasedweight;
	}
	
	/**
	 * Column Info
	 * @return mtyhcqty
	 */
	public String getMtyhcqty() {
		return this.mtyhcqty;
	}
	
	/**
	 * Column Info
	 * @return fullhcqty
	 */
	public String getFullhcqty() {
		return this.fullhcqty;
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
	 * @return company
	 */
	public String getCompany() {
		return this.company;
	}
	
	/**
	 * Column Info
	 * @return weighttotal
	 */
	public String getWeighttotal() {
		return this.weighttotal;
	}
	
	/**
	 * Column Info
	 * @return deadslot
	 */
	public String getDeadslot() {
		return this.deadslot;
	}
	
	/**
	 * Column Info
	 * @return full20qty
	 */
	public String getFull20qty() {
		return this.full20qty;
	}
	
	/**
	 * Column Info
	 * @return mty45qty
	 */
	public String getMty45qty() {
		return this.mty45qty;
	}
	

	/**
	 * Column Info
	 * @param unusedspace
	 */
	public void setUnusedspace(String unusedspace) {
		this.unusedspace = unusedspace;
	}
	
	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Column Info
	 * @param teutotal
	 */
	public void setTeutotal(String teutotal) {
		this.teutotal = teutotal;
	}
	
	/**
	 * Column Info
	 * @param mty40qty
	 */
	public void setMty40qty(String mty40qty) {
		this.mty40qty = mty40qty;
	}
	
	/**
	 * Column Info
	 * @param bsaweight
	 */
	public void setBsaweight(String bsaweight) {
		this.bsaweight = bsaweight;
	}
	
	/**
	 * Column Info
	 * @param full40qty
	 */
	public void setFull40qty(String full40qty) {
		this.full40qty = full40qty;
	}
	
	/**
	 * Column Info
	 * @param bsaspace
	 */
	public void setBsaspace(String bsaspace) {
		this.bsaspace = bsaspace;
	}
	
	/**
	 * Column Info
	 * @param fulltotal
	 */
	public void setFulltotal(String fulltotal) {
		this.fulltotal = fulltotal;
	}
	
	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param lfeq
	 */
	public void setLfeq(String lfeq) {
		this.lfeq = lfeq;
	}
	
	/**
	 * Column Info
	 * @param releasedteu
	 */
	public void setReleasedteu(String releasedteu) {
		this.releasedteu = releasedteu;
	}
	
	/**
	 * Column Info
	 * @param unusedweight
	 */
	public void setUnusedweight(String unusedweight) {
		this.unusedweight = unusedweight;
	}
	
	/**
	 * Column Info
	 * @param full45qty
	 */
	public void setFull45qty(String full45qty) {
		this.full45qty = full45qty;
	}
	
	/**
	 * Column Info
	 * @param boxtotal
	 */
	public void setBoxtotal(String boxtotal) {
		this.boxtotal = boxtotal;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param lfwgt
	 */
	public void setLfwgt(String lfwgt) {
		this.lfwgt = lfwgt;
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
	 * @param mty20qty
	 */
	public void setMty20qty(String mty20qty) {
		this.mty20qty = mty20qty;
	}
	
	/**
	 * Column Info
	 * @param atdWeek
	 */
	public void setAtdWeek(String atdWeek) {
		this.atdWeek = atdWeek;
	}
	
	/**
	 * Column Info
	 * @param mtytotal
	 */
	public void setMtytotal(String mtytotal) {
		this.mtytotal = mtytotal;
	}
	
	/**
	 * Column Info
	 * @param atd
	 */
	public void setAtd(String atd) {
		this.atd = atd;
	}
	
	/**
	 * Column Info
	 * @param datasource
	 */
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	
	/**
	 * Column Info
	 * @param lffull
	 */
	public void setLffull(String lffull) {
		this.lffull = lffull;
	}
	
	/**
	 * Column Info
	 * @param releasedweight
	 */
	public void setReleasedweight(String releasedweight) {
		this.releasedweight = releasedweight;
	}
	
	/**
	 * Column Info
	 * @param mtyhcqty
	 */
	public void setMtyhcqty(String mtyhcqty) {
		this.mtyhcqty = mtyhcqty;
	}
	
	/**
	 * Column Info
	 * @param fullhcqty
	 */
	public void setFullhcqty(String fullhcqty) {
		this.fullhcqty = fullhcqty;
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
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Column Info
	 * @param weighttotal
	 */
	public void setWeighttotal(String weighttotal) {
		this.weighttotal = weighttotal;
	}
	
	/**
	 * Column Info
	 * @param deadslot
	 */
	public void setDeadslot(String deadslot) {
		this.deadslot = deadslot;
	}
	
	/**
	 * Column Info
	 * @param full20qty
	 */
	public void setFull20qty(String full20qty) {
		this.full20qty = full20qty;
	}
	
	/**
	 * Column Info
	 * @param mty45qty
	 */
	public void setMty45qty(String mty45qty) {
		this.mty45qty = mty45qty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUnusedspace(JSPUtil.getParameter(request, "unusedspace", ""));
		setPort(JSPUtil.getParameter(request, "port", ""));
		setRegion(JSPUtil.getParameter(request, "region", ""));
		setTeutotal(JSPUtil.getParameter(request, "teutotal", ""));
		setMty40qty(JSPUtil.getParameter(request, "mty40qty", ""));
		setBsaweight(JSPUtil.getParameter(request, "bsaweight", ""));
		setFull40qty(JSPUtil.getParameter(request, "full40qty", ""));
		setBsaspace(JSPUtil.getParameter(request, "bsaspace", ""));
		setFulltotal(JSPUtil.getParameter(request, "fulltotal", ""));
		setTrade(JSPUtil.getParameter(request, "trade", ""));
		setLfeq(JSPUtil.getParameter(request, "lfeq", ""));
		setReleasedteu(JSPUtil.getParameter(request, "releasedteu", ""));
		setUnusedweight(JSPUtil.getParameter(request, "unusedweight", ""));
		setFull45qty(JSPUtil.getParameter(request, "full45qty", ""));
		setBoxtotal(JSPUtil.getParameter(request, "boxtotal", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLfwgt(JSPUtil.getParameter(request, "lfwgt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMty20qty(JSPUtil.getParameter(request, "mty20qty", ""));
		setAtdWeek(JSPUtil.getParameter(request, "atd_week", ""));
		setMtytotal(JSPUtil.getParameter(request, "mtytotal", ""));
		setAtd(JSPUtil.getParameter(request, "atd", ""));
		setDatasource(JSPUtil.getParameter(request, "datasource", ""));
		setLffull(JSPUtil.getParameter(request, "lffull", ""));
		setReleasedweight(JSPUtil.getParameter(request, "releasedweight", ""));
		setMtyhcqty(JSPUtil.getParameter(request, "mtyhcqty", ""));
		setFullhcqty(JSPUtil.getParameter(request, "fullhcqty", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setWeighttotal(JSPUtil.getParameter(request, "weighttotal", ""));
		setDeadslot(JSPUtil.getParameter(request, "deadslot", ""));
		setFull20qty(JSPUtil.getParameter(request, "full20qty", ""));
		setMty45qty(JSPUtil.getParameter(request, "mty45qty", ""));
		setCallind(JSPUtil.getParameter(request, "callind", ""));
		setCallseq(JSPUtil.getParameter(request, "callseq", ""));
		setFromregion(JSPUtil.getParameter(request, "fromregion", ""));
		setColsorts(JSPUtil.getParameter(request, "colsorts", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LoadFactorByTradeLaneVvdVO[]
	 */
	public LoadFactorByTradeLaneVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LoadFactorByTradeLaneVvdVO[]
	 */
	public LoadFactorByTradeLaneVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LoadFactorByTradeLaneVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] unusedspace = (JSPUtil.getParameter(request, prefix	+ "unusedspace", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] teutotal = (JSPUtil.getParameter(request, prefix	+ "teutotal", length));
			String[] mty40qty = (JSPUtil.getParameter(request, prefix	+ "mty40qty", length));
			String[] bsaweight = (JSPUtil.getParameter(request, prefix	+ "bsaweight", length));
			String[] full40qty = (JSPUtil.getParameter(request, prefix	+ "full40qty", length));
			String[] bsaspace = (JSPUtil.getParameter(request, prefix	+ "bsaspace", length));
			String[] fulltotal = (JSPUtil.getParameter(request, prefix	+ "fulltotal", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] lfeq = (JSPUtil.getParameter(request, prefix	+ "lfeq", length));
			String[] releasedteu = (JSPUtil.getParameter(request, prefix	+ "releasedteu", length));
			String[] unusedweight = (JSPUtil.getParameter(request, prefix	+ "unusedweight", length));
			String[] full45qty = (JSPUtil.getParameter(request, prefix	+ "full45qty", length));
			String[] boxtotal = (JSPUtil.getParameter(request, prefix	+ "boxtotal", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lfwgt = (JSPUtil.getParameter(request, prefix	+ "lfwgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mty20qty = (JSPUtil.getParameter(request, prefix	+ "mty20qty", length));
			String[] atdWeek = (JSPUtil.getParameter(request, prefix	+ "atd_week", length));
			String[] mtytotal = (JSPUtil.getParameter(request, prefix	+ "mtytotal", length));
			String[] atd = (JSPUtil.getParameter(request, prefix	+ "atd", length));
			String[] datasource = (JSPUtil.getParameter(request, prefix	+ "datasource", length));
			String[] lffull = (JSPUtil.getParameter(request, prefix	+ "lffull", length));
			String[] releasedweight = (JSPUtil.getParameter(request, prefix	+ "releasedweight", length));
			String[] mtyhcqty = (JSPUtil.getParameter(request, prefix	+ "mtyhcqty", length));
			String[] fullhcqty = (JSPUtil.getParameter(request, prefix	+ "fullhcqty", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] weighttotal = (JSPUtil.getParameter(request, prefix	+ "weighttotal", length));
			String[] deadslot = (JSPUtil.getParameter(request, prefix	+ "deadslot", length));
			String[] full20qty = (JSPUtil.getParameter(request, prefix	+ "full20qty", length));
			String[] mty45qty = (JSPUtil.getParameter(request, prefix	+ "mty45qty", length));
			String[] callind = (JSPUtil.getParameter(request, prefix	+ "callind", length));
			String[] callseq = (JSPUtil.getParameter(request, prefix	+ "callseq", length));
			String[] fromregion = (JSPUtil.getParameter(request, prefix	+ "fromregion", length));
			String[] colsorts = (JSPUtil.getParameter(request, prefix	+ "colsorts", length));
			
			for (int i = 0; i < length; i++) {
				model = new LoadFactorByTradeLaneVvdVO();
				if (unusedspace[i] != null)
					model.setUnusedspace(unusedspace[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (region[i] != null)
					model.setRegion(region[i]);
				if (teutotal[i] != null)
					model.setTeutotal(teutotal[i]);
				if (mty40qty[i] != null)
					model.setMty40qty(mty40qty[i]);
				if (bsaweight[i] != null)
					model.setBsaweight(bsaweight[i]);
				if (full40qty[i] != null)
					model.setFull40qty(full40qty[i]);
				if (bsaspace[i] != null)
					model.setBsaspace(bsaspace[i]);
				if (fulltotal[i] != null)
					model.setFulltotal(fulltotal[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (lfeq[i] != null)
					model.setLfeq(lfeq[i]);
				if (releasedteu[i] != null)
					model.setReleasedteu(releasedteu[i]);
				if (unusedweight[i] != null)
					model.setUnusedweight(unusedweight[i]);
				if (full45qty[i] != null)
					model.setFull45qty(full45qty[i]);
				if (boxtotal[i] != null)
					model.setBoxtotal(boxtotal[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lfwgt[i] != null)
					model.setLfwgt(lfwgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mty20qty[i] != null)
					model.setMty20qty(mty20qty[i]);
				if (atdWeek[i] != null)
					model.setAtdWeek(atdWeek[i]);
				if (mtytotal[i] != null)
					model.setMtytotal(mtytotal[i]);
				if (atd[i] != null)
					model.setAtd(atd[i]);
				if (datasource[i] != null)
					model.setDatasource(datasource[i]);
				if (lffull[i] != null)
					model.setLffull(lffull[i]);
				if (releasedweight[i] != null)
					model.setReleasedweight(releasedweight[i]);
				if (mtyhcqty[i] != null)
					model.setMtyhcqty(mtyhcqty[i]);
				if (fullhcqty[i] != null)
					model.setFullhcqty(fullhcqty[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (weighttotal[i] != null)
					model.setWeighttotal(weighttotal[i]);
				if (deadslot[i] != null)
					model.setDeadslot(deadslot[i]);
				if (full20qty[i] != null)
					model.setFull20qty(full20qty[i]);
				if (mty45qty[i] != null)
					model.setMty45qty(mty45qty[i]);
				if (callind[i] != null)
					model.setCallind(callind[i]);
				if (callseq[i] != null)
					model.setCallseq(callseq[i]);
				if (fromregion[i] != null)
					model.setFromregion(fromregion[i]);
				if (colsorts[i] != null)
					model.setColsorts(colsorts[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLoadFactorByTradeLaneVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LoadFactorByTradeLaneVvdVO[]
	 */
	public LoadFactorByTradeLaneVvdVO[] getLoadFactorByTradeLaneVvdVOs(){
		LoadFactorByTradeLaneVvdVO[] vos = (LoadFactorByTradeLaneVvdVO[])models.toArray(new LoadFactorByTradeLaneVvdVO[models.size()]);
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
		this.unusedspace = this.unusedspace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teutotal = this.teutotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty40qty = this.mty40qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaweight = this.bsaweight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full40qty = this.full40qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaspace = this.bsaspace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fulltotal = this.fulltotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfeq = this.lfeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.releasedteu = this.releasedteu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unusedweight = this.unusedweight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full45qty = this.full45qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boxtotal = this.boxtotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfwgt = this.lfwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty20qty = this.mty20qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdWeek = this.atdWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtytotal = this.mtytotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atd = this.atd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datasource = this.datasource .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lffull = this.lffull .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.releasedweight = this.releasedweight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyhcqty = this.mtyhcqty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullhcqty = this.fullhcqty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weighttotal = this.weighttotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deadslot = this.deadslot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full20qty = this.full20qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty45qty = this.mty45qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callind = this.callind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callseq = this.callseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromregion = this.fromregion .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colsorts = this.colsorts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
