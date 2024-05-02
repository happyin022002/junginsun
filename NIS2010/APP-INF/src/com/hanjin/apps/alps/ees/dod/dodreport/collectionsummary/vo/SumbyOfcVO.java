/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SumbyOfcVO.java
*@FileTitle : SumbyOfcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : Won-Ki Eo
*@LastVersion : 1.0
* 2016.05.20  
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo;

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

public class SumbyOfcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SumbyOfcVO> models = new ArrayList<SumbyOfcVO>();
	
	/* Column Info */
	private String to = null;
	/* Column Info */
	private String genTrfAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String sCurrCd = null;
	/* Column Info */
	private String troIbCfmOfcCd = null;
	/* Column Info */
	private String dodCntrTpCd = null;
	/* Column Info */
	private String from = null;
	/* Column Info */
	private String genTrfCntr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String spcTrfAmt = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String penAmt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String sCustCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String penCntr = null;
	/* Column Info */
	private String sCntrTp = null;
	/* Column Info */
	private String invCntr = null;
	/* Column Info */
	private String adjAmt = null;
	/* Column Info */
	private String spcTrfCntr = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String adjCntr = null;
	/* Column Info */
	private String ofcFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ofcCdList = null;
	/* Column Info */
	private String sRtnLoc = null;
	/* Column Info */
	private String cntrTpList = null;
	/* Column Info */
	private String sArIfYn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SumbyOfcVO() {}

	public SumbyOfcVO(String ibflag, String pagerows, String troIbCfmOfcCd, String locCd, String cntrTpszCd, String currCd, String genTrfCntr, String genTrfAmt, String spcTrfCntr, String spcTrfAmt, String adjCntr, String adjAmt, String invCntr, String invAmt, String penCntr, String penAmt, String sCurrCd, String dodCntrTpCd, String to, String from, String period, String sRtnLoc, String cntrTpList, String sCntrTp, String ofcCdList, String ofcFlg, String ofcCd, String sCustCd, String sArIfYn) {
		this.to = to;
		this.genTrfAmt = genTrfAmt;
		this.currCd = currCd;
		this.sCurrCd = sCurrCd;
		this.troIbCfmOfcCd = troIbCfmOfcCd;
		this.dodCntrTpCd = dodCntrTpCd;
		this.from = from;
		this.genTrfCntr = genTrfCntr;
		this.pagerows = pagerows;
		this.spcTrfAmt = spcTrfAmt;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.penAmt = penAmt;
		this.cntrTpszCd = cntrTpszCd;
		this.sCustCd = sCustCd;
		this.invAmt = invAmt;
		this.penCntr = penCntr;
		this.sCntrTp = sCntrTp;
		this.invCntr = invCntr;
		this.adjAmt = adjAmt;
		this.spcTrfCntr = spcTrfCntr;
		this.period = period;
		this.adjCntr = adjCntr;
		this.ofcFlg = ofcFlg;
		this.ofcCd = ofcCd;
		this.ofcCdList = ofcCdList;
		this.sRtnLoc = sRtnLoc;
		this.cntrTpList = cntrTpList;
		this.sArIfYn = sArIfYn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to", getTo());
		this.hashColumns.put("gen_trf_amt", getGenTrfAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("s_curr_cd", getSCurrCd());
		this.hashColumns.put("tro_ib_cfm_ofc_cd", getTroIbCfmOfcCd());
		this.hashColumns.put("dod_cntr_tp_cd", getDodCntrTpCd());
		this.hashColumns.put("from", getFrom());
		this.hashColumns.put("gen_trf_cntr", getGenTrfCntr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("spc_trf_amt", getSpcTrfAmt());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pen_amt", getPenAmt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("s_cust_cd", getSCustCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("pen_cntr", getPenCntr());
		this.hashColumns.put("s_cntr_tp", getSCntrTp());
		this.hashColumns.put("inv_cntr", getInvCntr());
		this.hashColumns.put("adj_amt", getAdjAmt());
		this.hashColumns.put("spc_trf_cntr", getSpcTrfCntr());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("adj_cntr", getAdjCntr());
		this.hashColumns.put("ofc_flg", getOfcFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ofc_cd_list", getOfcCdList());
		this.hashColumns.put("s_rtn_loc", getSRtnLoc());
		this.hashColumns.put("cntr_tp_list", getCntrTpList());
		this.hashColumns.put("s_ar_if_yn", getSArIfYn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to", "to");
		this.hashFields.put("gen_trf_amt", "genTrfAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("s_curr_cd", "sCurrCd");
		this.hashFields.put("tro_ib_cfm_ofc_cd", "troIbCfmOfcCd");
		this.hashFields.put("dod_cntr_tp_cd", "dodCntrTpCd");
		this.hashFields.put("from", "from");
		this.hashFields.put("gen_trf_cntr", "genTrfCntr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spc_trf_amt", "spcTrfAmt");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pen_amt", "penAmt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("s_cust_cd", "sCustCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("pen_cntr", "penCntr");
		this.hashFields.put("s_cntr_tp", "sCntrTp");
		this.hashFields.put("inv_cntr", "invCntr");
		this.hashFields.put("adj_amt", "adjAmt");
		this.hashFields.put("spc_trf_cntr", "spcTrfCntr");
		this.hashFields.put("period", "period");
		this.hashFields.put("adj_cntr", "adjCntr");
		this.hashFields.put("ofc_flg", "ofcFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ofc_cd_list", "ofcCdList");
		this.hashFields.put("s_rtn_loc", "sRtnLoc");
		this.hashFields.put("cntr_tp_list", "cntrTpList");
		this.hashFields.put("s_ar_if_yn", "sArIfYn");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return to
	 */
	public String getTo() {
		return this.to;
	}
	
	/**
	 * Column Info
	 * @return genTrfAmt
	 */
	public String getGenTrfAmt() {
		return this.genTrfAmt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return sCurrCd
	 */
	public String getSCurrCd() {
		return this.sCurrCd;
	}
	
	/**
	 * Column Info
	 * @return troIbCfmOfcCd
	 */
	public String getTroIbCfmOfcCd() {
		return this.troIbCfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dodCntrTpCd
	 */
	public String getDodCntrTpCd() {
		return this.dodCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return from
	 */
	public String getFrom() {
		return this.from;
	}
	
	/**
	 * Column Info
	 * @return genTrfCntr
	 */
	public String getGenTrfCntr() {
		return this.genTrfCntr;
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
	 * @return spcTrfAmt
	 */
	public String getSpcTrfAmt() {
		return this.spcTrfAmt;
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
	 * @return penAmt
	 */
	public String getPenAmt() {
		return this.penAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return sCustCd
	 */
	public String getSCustCd() {
		return this.sCustCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return penCntr
	 */
	public String getPenCntr() {
		return this.penCntr;
	}
	
	/**
	 * Column Info
	 * @return sCntrTp
	 */
	public String getSCntrTp() {
		return this.sCntrTp;
	}
	
	/**
	 * Column Info
	 * @return invCntr
	 */
	public String getInvCntr() {
		return this.invCntr;
	}
	
	/**
	 * Column Info
	 * @return adjAmt
	 */
	public String getAdjAmt() {
		return this.adjAmt;
	}
	
	/**
	 * Column Info
	 * @return spcTrfCntr
	 */
	public String getSpcTrfCntr() {
		return this.spcTrfCntr;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}
	
	/**
	 * Column Info
	 * @return adjCntr
	 */
	public String getAdjCntr() {
		return this.adjCntr;
	}
	
	/**
	 * Column Info
	 * @return ofcFlg
	 */
	public String getOfcFlg() {
		return this.ofcFlg;
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
	 * @return ofcCdList
	 */
	public String getOfcCdList() {
		return this.ofcCdList;
	}
	
	/**
	 * Column Info
	 * @return sRtnLoc
	 */
	public String getSRtnLoc() {
		return this.sRtnLoc;
	}
	
	/**
	 * Column Info
	 * @return cntrTpList
	 */
	public String getCntrTpList() {
		return this.cntrTpList;
	}
	
	/**
	 * Column Info
	 * @return sArIfYn
	 */
	public String getSArIfYn() {
		return this.sArIfYn;
	}
	

	/**
	 * Column Info
	 * @param to
	 */
	public void setTo(String to) {
		this.to = to;
	}
	
	/**
	 * Column Info
	 * @param genTrfAmt
	 */
	public void setGenTrfAmt(String genTrfAmt) {
		this.genTrfAmt = genTrfAmt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param sCurrCd
	 */
	public void setSCurrCd(String sCurrCd) {
		this.sCurrCd = sCurrCd;
	}
	
	/**
	 * Column Info
	 * @param troIbCfmOfcCd
	 */
	public void setTroIbCfmOfcCd(String troIbCfmOfcCd) {
		this.troIbCfmOfcCd = troIbCfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dodCntrTpCd
	 */
	public void setDodCntrTpCd(String dodCntrTpCd) {
		this.dodCntrTpCd = dodCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * Column Info
	 * @param genTrfCntr
	 */
	public void setGenTrfCntr(String genTrfCntr) {
		this.genTrfCntr = genTrfCntr;
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
	 * @param spcTrfAmt
	 */
	public void setSpcTrfAmt(String spcTrfAmt) {
		this.spcTrfAmt = spcTrfAmt;
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
	 * @param penAmt
	 */
	public void setPenAmt(String penAmt) {
		this.penAmt = penAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param sCustCd
	 */
	public void setSCustCd(String sCustCd) {
		this.sCustCd = sCustCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param penCntr
	 */
	public void setPenCntr(String penCntr) {
		this.penCntr = penCntr;
	}
	
	/**
	 * Column Info
	 * @param sCntrTp
	 */
	public void setSCntrTp(String sCntrTp) {
		this.sCntrTp = sCntrTp;
	}
	
	/**
	 * Column Info
	 * @param invCntr
	 */
	public void setInvCntr(String invCntr) {
		this.invCntr = invCntr;
	}
	
	/**
	 * Column Info
	 * @param adjAmt
	 */
	public void setAdjAmt(String adjAmt) {
		this.adjAmt = adjAmt;
	}
	
	/**
	 * Column Info
	 * @param spcTrfCntr
	 */
	public void setSpcTrfCntr(String spcTrfCntr) {
		this.spcTrfCntr = spcTrfCntr;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Column Info
	 * @param adjCntr
	 */
	public void setAdjCntr(String adjCntr) {
		this.adjCntr = adjCntr;
	}
	
	/**
	 * Column Info
	 * @param ofcFlg
	 */
	public void setOfcFlg(String ofcFlg) {
		this.ofcFlg = ofcFlg;
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
	 * @param ofcCdList
	 */
	public void setOfcCdList(String ofcCdList) {
		this.ofcCdList = ofcCdList;
	}
	
	/**
	 * Column Info
	 * @param sRtnLoc
	 */
	public void setSRtnLoc(String sRtnLoc) {
		this.sRtnLoc = sRtnLoc;
	}
	
	/**
	 * Column Info
	 * @param cntrTpList
	 */
	public void setCntrTpList(String cntrTpList) {
		this.cntrTpList = cntrTpList;
	}
	
	/**
	 * Column Info
	 * @param sArIfYn
	 */
	public void setSArIfYn(String sArIfYn) {
		this.sArIfYn = sArIfYn;
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
		setTo(JSPUtil.getParameter(request, prefix + "to", ""));
		setGenTrfAmt(JSPUtil.getParameter(request, prefix + "gen_trf_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setSCurrCd(JSPUtil.getParameter(request, prefix + "s_curr_cd", ""));
		setTroIbCfmOfcCd(JSPUtil.getParameter(request, prefix + "tro_ib_cfm_ofc_cd", ""));
		setDodCntrTpCd(JSPUtil.getParameter(request, prefix + "dod_cntr_tp_cd", ""));
		setFrom(JSPUtil.getParameter(request, prefix + "from", ""));
		setGenTrfCntr(JSPUtil.getParameter(request, prefix + "gen_trf_cntr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSpcTrfAmt(JSPUtil.getParameter(request, prefix + "spc_trf_amt", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPenAmt(JSPUtil.getParameter(request, prefix + "pen_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setSCustCd(JSPUtil.getParameter(request, prefix + "s_cust_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setPenCntr(JSPUtil.getParameter(request, prefix + "pen_cntr", ""));
		setSCntrTp(JSPUtil.getParameter(request, prefix + "s_cntr_tp", ""));
		setInvCntr(JSPUtil.getParameter(request, prefix + "inv_cntr", ""));
		setAdjAmt(JSPUtil.getParameter(request, prefix + "adj_amt", ""));
		setSpcTrfCntr(JSPUtil.getParameter(request, prefix + "spc_trf_cntr", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setAdjCntr(JSPUtil.getParameter(request, prefix + "adj_cntr", ""));
		setOfcFlg(JSPUtil.getParameter(request, prefix + "ofc_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setOfcCdList(JSPUtil.getParameter(request, prefix + "ofc_cd_list", ""));
		setSRtnLoc(JSPUtil.getParameter(request, prefix + "s_rtn_loc", ""));
		setCntrTpList(JSPUtil.getParameter(request, prefix + "cntr_tp_list", ""));
		setSArIfYn(JSPUtil.getParameter(request, prefix + "s_ar_if_yn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SumbyOfcVO[]
	 */
	public SumbyOfcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SumbyOfcVO[]
	 */
	public SumbyOfcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SumbyOfcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] to = (JSPUtil.getParameter(request, prefix	+ "to", length));
			String[] genTrfAmt = (JSPUtil.getParameter(request, prefix	+ "gen_trf_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] sCurrCd = (JSPUtil.getParameter(request, prefix	+ "s_curr_cd", length));
			String[] troIbCfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "tro_ib_cfm_ofc_cd", length));
			String[] dodCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "dod_cntr_tp_cd", length));
			String[] from = (JSPUtil.getParameter(request, prefix	+ "from", length));
			String[] genTrfCntr = (JSPUtil.getParameter(request, prefix	+ "gen_trf_cntr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] spcTrfAmt = (JSPUtil.getParameter(request, prefix	+ "spc_trf_amt", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] penAmt = (JSPUtil.getParameter(request, prefix	+ "pen_amt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] sCustCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] penCntr = (JSPUtil.getParameter(request, prefix	+ "pen_cntr", length));
			String[] sCntrTp = (JSPUtil.getParameter(request, prefix	+ "s_cntr_tp", length));
			String[] invCntr = (JSPUtil.getParameter(request, prefix	+ "inv_cntr", length));
			String[] adjAmt = (JSPUtil.getParameter(request, prefix	+ "adj_amt", length));
			String[] spcTrfCntr = (JSPUtil.getParameter(request, prefix	+ "spc_trf_cntr", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] adjCntr = (JSPUtil.getParameter(request, prefix	+ "adj_cntr", length));
			String[] ofcFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ofcCdList = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_list", length));
			String[] sRtnLoc = (JSPUtil.getParameter(request, prefix	+ "s_rtn_loc", length));
			String[] cntrTpList = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_list", length));
			String[] sArIfYn = (JSPUtil.getParameter(request, prefix	+ "s_ar_if_yn", length));
			
			for (int i = 0; i < length; i++) {
				model = new SumbyOfcVO();
				if (to[i] != null)
					model.setTo(to[i]);
				if (genTrfAmt[i] != null)
					model.setGenTrfAmt(genTrfAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (sCurrCd[i] != null)
					model.setSCurrCd(sCurrCd[i]);
				if (troIbCfmOfcCd[i] != null)
					model.setTroIbCfmOfcCd(troIbCfmOfcCd[i]);
				if (dodCntrTpCd[i] != null)
					model.setDodCntrTpCd(dodCntrTpCd[i]);
				if (from[i] != null)
					model.setFrom(from[i]);
				if (genTrfCntr[i] != null)
					model.setGenTrfCntr(genTrfCntr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (spcTrfAmt[i] != null)
					model.setSpcTrfAmt(spcTrfAmt[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (penAmt[i] != null)
					model.setPenAmt(penAmt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (sCustCd[i] != null)
					model.setSCustCd(sCustCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (penCntr[i] != null)
					model.setPenCntr(penCntr[i]);
				if (sCntrTp[i] != null)
					model.setSCntrTp(sCntrTp[i]);
				if (invCntr[i] != null)
					model.setInvCntr(invCntr[i]);
				if (adjAmt[i] != null)
					model.setAdjAmt(adjAmt[i]);
				if (spcTrfCntr[i] != null)
					model.setSpcTrfCntr(spcTrfCntr[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (adjCntr[i] != null)
					model.setAdjCntr(adjCntr[i]);
				if (ofcFlg[i] != null)
					model.setOfcFlg(ofcFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ofcCdList[i] != null)
					model.setOfcCdList(ofcCdList[i]);
				if (sRtnLoc[i] != null)
					model.setSRtnLoc(sRtnLoc[i]);
				if (cntrTpList[i] != null)
					model.setCntrTpList(cntrTpList[i]);
				if (sArIfYn[i] != null)
					model.setSArIfYn(sArIfYn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSumbyOfcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SumbyOfcVO[]
	 */
	public SumbyOfcVO[] getSumbyOfcVOs(){
		SumbyOfcVO[] vos = (SumbyOfcVO[])models.toArray(new SumbyOfcVO[models.size()]);
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
		this.to = this.to .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genTrfAmt = this.genTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCurrCd = this.sCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troIbCfmOfcCd = this.troIbCfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dodCntrTpCd = this.dodCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.from = this.from .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genTrfCntr = this.genTrfCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcTrfAmt = this.spcTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.penAmt = this.penAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCd = this.sCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.penCntr = this.penCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrTp = this.sCntrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCntr = this.invCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAmt = this.adjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcTrfCntr = this.spcTrfCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjCntr = this.adjCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFlg = this.ofcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCdList = this.ofcCdList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRtnLoc = this.sRtnLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpList = this.cntrTpList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sArIfYn = this.sArIfYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
