/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MtyBalRptOtrVO.java
*@FileTitle : MtyBalRptOtrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.08.06 김종준 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo;

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
 * @author 김종준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MtyBalRptOtrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MtyBalRptOtrVO> models = new ArrayList<MtyBalRptOtrVO>();
	
	/* Column Info */
	private String a2FcastQty = null;
	/* Column Info */
	private String d7FcastQty = null;
	/* Column Info */
	private String creSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String d5FcastQty = null;
	/* Column Info */
	private String fcastDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String r2FcastQty = null;
	/* Column Info */
	private String o2FcastQty = null;
	/* Column Info */
	private String mtyBalOtrTpCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dTotal = null;
	/* Column Info */
	private String gTotal = null;
	/* Column Info */
	private String inpYrwk = null;
	/* Column Info */
	private String fctrCtnt = null;
	/* Column Info */
	private String a4FcastQty = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String d2FcastQty = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String r5FcastQty = null;
	/* Column Info */
	private String s4FcastQty = null;
	/* Column Info */
	private String s2FcastQty = null;
	/* Column Info */
	private String f4FcastQty = null;
	/* Column Info */
	private String sTotal = null;
	/* Column Info */
	private String f5FcastQty = null;
	/* Column Info */
	private String o4FcastQty = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String f2FcastQty = null;
	/* Column Info */
	private String fcastYrwk = null;
	/* Column Info */
	private String d4FcastQty = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String ydCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MtyBalRptOtrVO() {}

	public MtyBalRptOtrVO(String ibflag, String pagerows, String coCd, String locCd, String inpYrwk, String fcastYrwk, String mtyBalOtrTpCd, String creSeq, String fctrCtnt, String lstmCd, String ydCd, String fcastDt, String gTotal, String dTotal, String d2FcastQty, String d4FcastQty, String d5FcastQty, String d7FcastQty, String sTotal, String r2FcastQty, String r5FcastQty, String o2FcastQty, String s2FcastQty, String o4FcastQty, String s4FcastQty, String f2FcastQty, String a2FcastQty, String f4FcastQty, String a4FcastQty, String f5FcastQty, String diffRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.a2FcastQty = a2FcastQty;
		this.d7FcastQty = d7FcastQty;
		this.creSeq = creSeq;
		this.creDt = creDt;
		this.d5FcastQty = d5FcastQty;
		this.fcastDt = fcastDt;
		this.pagerows = pagerows;
		this.r2FcastQty = r2FcastQty;
		this.o2FcastQty = o2FcastQty;
		this.mtyBalOtrTpCd = mtyBalOtrTpCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.dTotal = dTotal;
		this.gTotal = gTotal;
		this.inpYrwk = inpYrwk;
		this.fctrCtnt = fctrCtnt;
		this.a4FcastQty = a4FcastQty;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.d2FcastQty = d2FcastQty;
		this.coCd = coCd;
		this.r5FcastQty = r5FcastQty;
		this.s4FcastQty = s4FcastQty;
		this.s2FcastQty = s2FcastQty;
		this.f4FcastQty = f4FcastQty;
		this.sTotal = sTotal;
		this.f5FcastQty = f5FcastQty;
		this.o4FcastQty = o4FcastQty;
		this.creUsrId = creUsrId;
		this.f2FcastQty = f2FcastQty;
		this.fcastYrwk = fcastYrwk;
		this.d4FcastQty = d4FcastQty;
		this.diffRmk = diffRmk;
		this.ydCd = ydCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("a2_fcast_qty", getA2FcastQty());
		this.hashColumns.put("d7_fcast_qty", getD7FcastQty());
		this.hashColumns.put("cre_seq", getCreSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("d5_fcast_qty", getD5FcastQty());
		this.hashColumns.put("fcast_dt", getFcastDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("r2_fcast_qty", getR2FcastQty());
		this.hashColumns.put("o2_fcast_qty", getO2FcastQty());
		this.hashColumns.put("mty_bal_otr_tp_cd", getMtyBalOtrTpCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("d_total", getDTotal());
		this.hashColumns.put("g_total", getGTotal());
		this.hashColumns.put("inp_yrwk", getInpYrwk());
		this.hashColumns.put("fctr_ctnt", getFctrCtnt());
		this.hashColumns.put("a4_fcast_qty", getA4FcastQty());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("d2_fcast_qty", getD2FcastQty());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("r5_fcast_qty", getR5FcastQty());
		this.hashColumns.put("s4_fcast_qty", getS4FcastQty());
		this.hashColumns.put("s2_fcast_qty", getS2FcastQty());
		this.hashColumns.put("f4_fcast_qty", getF4FcastQty());
		this.hashColumns.put("s_total", getSTotal());
		this.hashColumns.put("f5_fcast_qty", getF5FcastQty());
		this.hashColumns.put("o4_fcast_qty", getO4FcastQty());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("f2_fcast_qty", getF2FcastQty());
		this.hashColumns.put("fcast_yrwk", getFcastYrwk());
		this.hashColumns.put("d4_fcast_qty", getD4FcastQty());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("yd_cd", getYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("a2_fcast_qty", "a2FcastQty");
		this.hashFields.put("d7_fcast_qty", "d7FcastQty");
		this.hashFields.put("cre_seq", "creSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("d5_fcast_qty", "d5FcastQty");
		this.hashFields.put("fcast_dt", "fcastDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("r2_fcast_qty", "r2FcastQty");
		this.hashFields.put("o2_fcast_qty", "o2FcastQty");
		this.hashFields.put("mty_bal_otr_tp_cd", "mtyBalOtrTpCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d_total", "dTotal");
		this.hashFields.put("g_total", "gTotal");
		this.hashFields.put("inp_yrwk", "inpYrwk");
		this.hashFields.put("fctr_ctnt", "fctrCtnt");
		this.hashFields.put("a4_fcast_qty", "a4FcastQty");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("d2_fcast_qty", "d2FcastQty");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("r5_fcast_qty", "r5FcastQty");
		this.hashFields.put("s4_fcast_qty", "s4FcastQty");
		this.hashFields.put("s2_fcast_qty", "s2FcastQty");
		this.hashFields.put("f4_fcast_qty", "f4FcastQty");
		this.hashFields.put("s_total", "sTotal");
		this.hashFields.put("f5_fcast_qty", "f5FcastQty");
		this.hashFields.put("o4_fcast_qty", "o4FcastQty");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("f2_fcast_qty", "f2FcastQty");
		this.hashFields.put("fcast_yrwk", "fcastYrwk");
		this.hashFields.put("d4_fcast_qty", "d4FcastQty");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("yd_cd", "ydCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return a2FcastQty
	 */
	public String getA2FcastQty() {
		return this.a2FcastQty;
	}
	
	/**
	 * Column Info
	 * @return d7FcastQty
	 */
	public String getD7FcastQty() {
		return this.d7FcastQty;
	}
	
	/**
	 * Column Info
	 * @return creSeq
	 */
	public String getCreSeq() {
		return this.creSeq;
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
	 * @return d5FcastQty
	 */
	public String getD5FcastQty() {
		return this.d5FcastQty;
	}
	
	/**
	 * Column Info
	 * @return fcastDt
	 */
	public String getFcastDt() {
		return this.fcastDt;
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
	 * @return r2FcastQty
	 */
	public String getR2FcastQty() {
		return this.r2FcastQty;
	}
	
	/**
	 * Column Info
	 * @return o2FcastQty
	 */
	public String getO2FcastQty() {
		return this.o2FcastQty;
	}
	
	/**
	 * Column Info
	 * @return mtyBalOtrTpCd
	 */
	public String getMtyBalOtrTpCd() {
		return this.mtyBalOtrTpCd;
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
	 * @return dTotal
	 */
	public String getDTotal() {
		return this.dTotal;
	}
	
	/**
	 * Column Info
	 * @return gTotal
	 */
	public String getGTotal() {
		return this.gTotal;
	}
	
	/**
	 * Column Info
	 * @return inpYrwk
	 */
	public String getInpYrwk() {
		return this.inpYrwk;
	}
	
	/**
	 * Column Info
	 * @return fctrCtnt
	 */
	public String getFctrCtnt() {
		return this.fctrCtnt;
	}
	
	/**
	 * Column Info
	 * @return a4FcastQty
	 */
	public String getA4FcastQty() {
		return this.a4FcastQty;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return d2FcastQty
	 */
	public String getD2FcastQty() {
		return this.d2FcastQty;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return r5FcastQty
	 */
	public String getR5FcastQty() {
		return this.r5FcastQty;
	}
	
	/**
	 * Column Info
	 * @return s4FcastQty
	 */
	public String getS4FcastQty() {
		return this.s4FcastQty;
	}
	
	/**
	 * Column Info
	 * @return s2FcastQty
	 */
	public String getS2FcastQty() {
		return this.s2FcastQty;
	}
	
	/**
	 * Column Info
	 * @return f4FcastQty
	 */
	public String getF4FcastQty() {
		return this.f4FcastQty;
	}
	
	/**
	 * Column Info
	 * @return sTotal
	 */
	public String getSTotal() {
		return this.sTotal;
	}
	
	/**
	 * Column Info
	 * @return f5FcastQty
	 */
	public String getF5FcastQty() {
		return this.f5FcastQty;
	}
	
	/**
	 * Column Info
	 * @return o4FcastQty
	 */
	public String getO4FcastQty() {
		return this.o4FcastQty;
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
	 * @return f2FcastQty
	 */
	public String getF2FcastQty() {
		return this.f2FcastQty;
	}
	
	/**
	 * Column Info
	 * @return fcastYrwk
	 */
	public String getFcastYrwk() {
		return this.fcastYrwk;
	}
	
	/**
	 * Column Info
	 * @return d4FcastQty
	 */
	public String getD4FcastQty() {
		return this.d4FcastQty;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @param a2FcastQty
	 */
	public void setA2FcastQty(String a2FcastQty) {
		this.a2FcastQty = a2FcastQty;
	}
	
	/**
	 * Column Info
	 * @param d7FcastQty
	 */
	public void setD7FcastQty(String d7FcastQty) {
		this.d7FcastQty = d7FcastQty;
	}
	
	/**
	 * Column Info
	 * @param creSeq
	 */
	public void setCreSeq(String creSeq) {
		this.creSeq = creSeq;
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
	 * @param d5FcastQty
	 */
	public void setD5FcastQty(String d5FcastQty) {
		this.d5FcastQty = d5FcastQty;
	}
	
	/**
	 * Column Info
	 * @param fcastDt
	 */
	public void setFcastDt(String fcastDt) {
		this.fcastDt = fcastDt;
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
	 * @param r2FcastQty
	 */
	public void setR2FcastQty(String r2FcastQty) {
		this.r2FcastQty = r2FcastQty;
	}
	
	/**
	 * Column Info
	 * @param o2FcastQty
	 */
	public void setO2FcastQty(String o2FcastQty) {
		this.o2FcastQty = o2FcastQty;
	}
	
	/**
	 * Column Info
	 * @param mtyBalOtrTpCd
	 */
	public void setMtyBalOtrTpCd(String mtyBalOtrTpCd) {
		this.mtyBalOtrTpCd = mtyBalOtrTpCd;
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
	 * @param dTotal
	 */
	public void setDTotal(String dTotal) {
		this.dTotal = dTotal;
	}
	
	/**
	 * Column Info
	 * @param gTotal
	 */
	public void setGTotal(String gTotal) {
		this.gTotal = gTotal;
	}
	
	/**
	 * Column Info
	 * @param inpYrwk
	 */
	public void setInpYrwk(String inpYrwk) {
		this.inpYrwk = inpYrwk;
	}
	
	/**
	 * Column Info
	 * @param fctrCtnt
	 */
	public void setFctrCtnt(String fctrCtnt) {
		this.fctrCtnt = fctrCtnt;
	}
	
	/**
	 * Column Info
	 * @param a4FcastQty
	 */
	public void setA4FcastQty(String a4FcastQty) {
		this.a4FcastQty = a4FcastQty;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param d2FcastQty
	 */
	public void setD2FcastQty(String d2FcastQty) {
		this.d2FcastQty = d2FcastQty;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param r5FcastQty
	 */
	public void setR5FcastQty(String r5FcastQty) {
		this.r5FcastQty = r5FcastQty;
	}
	
	/**
	 * Column Info
	 * @param s4FcastQty
	 */
	public void setS4FcastQty(String s4FcastQty) {
		this.s4FcastQty = s4FcastQty;
	}
	
	/**
	 * Column Info
	 * @param s2FcastQty
	 */
	public void setS2FcastQty(String s2FcastQty) {
		this.s2FcastQty = s2FcastQty;
	}
	
	/**
	 * Column Info
	 * @param f4FcastQty
	 */
	public void setF4FcastQty(String f4FcastQty) {
		this.f4FcastQty = f4FcastQty;
	}
	
	/**
	 * Column Info
	 * @param sTotal
	 */
	public void setSTotal(String sTotal) {
		this.sTotal = sTotal;
	}
	
	/**
	 * Column Info
	 * @param f5FcastQty
	 */
	public void setF5FcastQty(String f5FcastQty) {
		this.f5FcastQty = f5FcastQty;
	}
	
	/**
	 * Column Info
	 * @param o4FcastQty
	 */
	public void setO4FcastQty(String o4FcastQty) {
		this.o4FcastQty = o4FcastQty;
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
	 * @param f2FcastQty
	 */
	public void setF2FcastQty(String f2FcastQty) {
		this.f2FcastQty = f2FcastQty;
	}
	
	/**
	 * Column Info
	 * @param fcastYrwk
	 */
	public void setFcastYrwk(String fcastYrwk) {
		this.fcastYrwk = fcastYrwk;
	}
	
	/**
	 * Column Info
	 * @param d4FcastQty
	 */
	public void setD4FcastQty(String d4FcastQty) {
		this.d4FcastQty = d4FcastQty;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setA2FcastQty(JSPUtil.getParameter(request, "a2_fcast_qty", ""));
		setD7FcastQty(JSPUtil.getParameter(request, "d7_fcast_qty", ""));
		setCreSeq(JSPUtil.getParameter(request, "cre_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setD5FcastQty(JSPUtil.getParameter(request, "d5_fcast_qty", ""));
		setFcastDt(JSPUtil.getParameter(request, "fcast_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setR2FcastQty(JSPUtil.getParameter(request, "r2_fcast_qty", ""));
		setO2FcastQty(JSPUtil.getParameter(request, "o2_fcast_qty", ""));
		setMtyBalOtrTpCd(JSPUtil.getParameter(request, "mty_bal_otr_tp_cd", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDTotal(JSPUtil.getParameter(request, "d_total", ""));
		setGTotal(JSPUtil.getParameter(request, "g_total", ""));
		setInpYrwk(JSPUtil.getParameter(request, "inp_yrwk", ""));
		setFctrCtnt(JSPUtil.getParameter(request, "fctr_ctnt", ""));
		setA4FcastQty(JSPUtil.getParameter(request, "a4_fcast_qty", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setD2FcastQty(JSPUtil.getParameter(request, "d2_fcast_qty", ""));
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setR5FcastQty(JSPUtil.getParameter(request, "r5_fcast_qty", ""));
		setS4FcastQty(JSPUtil.getParameter(request, "s4_fcast_qty", ""));
		setS2FcastQty(JSPUtil.getParameter(request, "s2_fcast_qty", ""));
		setF4FcastQty(JSPUtil.getParameter(request, "f4_fcast_qty", ""));
		setSTotal(JSPUtil.getParameter(request, "s_total", ""));
		setF5FcastQty(JSPUtil.getParameter(request, "f5_fcast_qty", ""));
		setO4FcastQty(JSPUtil.getParameter(request, "o4_fcast_qty", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setF2FcastQty(JSPUtil.getParameter(request, "f2_fcast_qty", ""));
		setFcastYrwk(JSPUtil.getParameter(request, "fcast_yrwk", ""));
		setD4FcastQty(JSPUtil.getParameter(request, "d4_fcast_qty", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyBalRptOtrVO[]
	 */
	public MtyBalRptOtrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyBalRptOtrVO[]
	 */
	public MtyBalRptOtrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MtyBalRptOtrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] a2FcastQty = (JSPUtil.getParameter(request, prefix	+ "a2_fcast_qty", length));
			String[] d7FcastQty = (JSPUtil.getParameter(request, prefix	+ "d7_fcast_qty", length));
			String[] creSeq = (JSPUtil.getParameter(request, prefix	+ "cre_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] d5FcastQty = (JSPUtil.getParameter(request, prefix	+ "d5_fcast_qty", length));
			String[] fcastDt = (JSPUtil.getParameter(request, prefix	+ "fcast_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] r2FcastQty = (JSPUtil.getParameter(request, prefix	+ "r2_fcast_qty", length));
			String[] o2FcastQty = (JSPUtil.getParameter(request, prefix	+ "o2_fcast_qty", length));
			String[] mtyBalOtrTpCd = (JSPUtil.getParameter(request, prefix	+ "mty_bal_otr_tp_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dTotal = (JSPUtil.getParameter(request, prefix	+ "d_total", length));
			String[] gTotal = (JSPUtil.getParameter(request, prefix	+ "g_total", length));
			String[] inpYrwk = (JSPUtil.getParameter(request, prefix	+ "inp_yrwk", length));
			String[] fctrCtnt = (JSPUtil.getParameter(request, prefix	+ "fctr_ctnt", length));
			String[] a4FcastQty = (JSPUtil.getParameter(request, prefix	+ "a4_fcast_qty", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] d2FcastQty = (JSPUtil.getParameter(request, prefix	+ "d2_fcast_qty", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] r5FcastQty = (JSPUtil.getParameter(request, prefix	+ "r5_fcast_qty", length));
			String[] s4FcastQty = (JSPUtil.getParameter(request, prefix	+ "s4_fcast_qty", length));
			String[] s2FcastQty = (JSPUtil.getParameter(request, prefix	+ "s2_fcast_qty", length));
			String[] f4FcastQty = (JSPUtil.getParameter(request, prefix	+ "f4_fcast_qty", length));
			String[] sTotal = (JSPUtil.getParameter(request, prefix	+ "s_total", length));
			String[] f5FcastQty = (JSPUtil.getParameter(request, prefix	+ "f5_fcast_qty", length));
			String[] o4FcastQty = (JSPUtil.getParameter(request, prefix	+ "o4_fcast_qty", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] f2FcastQty = (JSPUtil.getParameter(request, prefix	+ "f2_fcast_qty", length));
			String[] fcastYrwk = (JSPUtil.getParameter(request, prefix	+ "fcast_yrwk", length));
			String[] d4FcastQty = (JSPUtil.getParameter(request, prefix	+ "d4_fcast_qty", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MtyBalRptOtrVO();
				if (a2FcastQty[i] != null)
					model.setA2FcastQty(a2FcastQty[i]);
				if (d7FcastQty[i] != null)
					model.setD7FcastQty(d7FcastQty[i]);
				if (creSeq[i] != null)
					model.setCreSeq(creSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (d5FcastQty[i] != null)
					model.setD5FcastQty(d5FcastQty[i]);
				if (fcastDt[i] != null)
					model.setFcastDt(fcastDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (r2FcastQty[i] != null)
					model.setR2FcastQty(r2FcastQty[i]);
				if (o2FcastQty[i] != null)
					model.setO2FcastQty(o2FcastQty[i]);
				if (mtyBalOtrTpCd[i] != null)
					model.setMtyBalOtrTpCd(mtyBalOtrTpCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dTotal[i] != null)
					model.setDTotal(dTotal[i]);
				if (gTotal[i] != null)
					model.setGTotal(gTotal[i]);
				if (inpYrwk[i] != null)
					model.setInpYrwk(inpYrwk[i]);
				if (fctrCtnt[i] != null)
					model.setFctrCtnt(fctrCtnt[i]);
				if (a4FcastQty[i] != null)
					model.setA4FcastQty(a4FcastQty[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (d2FcastQty[i] != null)
					model.setD2FcastQty(d2FcastQty[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (r5FcastQty[i] != null)
					model.setR5FcastQty(r5FcastQty[i]);
				if (s4FcastQty[i] != null)
					model.setS4FcastQty(s4FcastQty[i]);
				if (s2FcastQty[i] != null)
					model.setS2FcastQty(s2FcastQty[i]);
				if (f4FcastQty[i] != null)
					model.setF4FcastQty(f4FcastQty[i]);
				if (sTotal[i] != null)
					model.setSTotal(sTotal[i]);
				if (f5FcastQty[i] != null)
					model.setF5FcastQty(f5FcastQty[i]);
				if (o4FcastQty[i] != null)
					model.setO4FcastQty(o4FcastQty[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (f2FcastQty[i] != null)
					model.setF2FcastQty(f2FcastQty[i]);
				if (fcastYrwk[i] != null)
					model.setFcastYrwk(fcastYrwk[i]);
				if (d4FcastQty[i] != null)
					model.setD4FcastQty(d4FcastQty[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMtyBalRptOtrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyBalRptOtrVO[]
	 */
	public MtyBalRptOtrVO[] getMtyBalRptOtrVOs(){
		MtyBalRptOtrVO[] vos = (MtyBalRptOtrVO[])models.toArray(new MtyBalRptOtrVO[models.size()]);
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
		this.a2FcastQty = this.a2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7FcastQty = this.d7FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creSeq = this.creSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5FcastQty = this.d5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastDt = this.fcastDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2FcastQty = this.r2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2FcastQty = this.o2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBalOtrTpCd = this.mtyBalOtrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTotal = this.dTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gTotal = this.gTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpYrwk = this.inpYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctrCtnt = this.fctrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4FcastQty = this.a4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2FcastQty = this.d2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5FcastQty = this.r5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4FcastQty = this.s4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2FcastQty = this.s2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4FcastQty = this.f4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTotal = this.sTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5FcastQty = this.f5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4FcastQty = this.o4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2FcastQty = this.f2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastYrwk = this.fcastYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4FcastQty = this.d4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
