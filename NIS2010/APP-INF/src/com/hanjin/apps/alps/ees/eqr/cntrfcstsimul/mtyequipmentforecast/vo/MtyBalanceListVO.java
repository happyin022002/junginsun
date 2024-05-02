/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MtyBalanceListVO.java
*@FileTitle : MtyBalanceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.16
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2011.06.16 나상보 
* 1.0 Creation
* ======================================================
* 2011.06.13 나상보 [CHM-201111555-01] [EQR] R9 코드 생성에 따른 EQR 모듈 보완 작업 요청
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo;

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
 * @author 나상보
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MtyBalanceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MtyBalanceListVO> models = new ArrayList<MtyBalanceListVO>();
	
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String a2FcastQty = null;
	/* Column Info */
	private String d7FcastQty = null;
	/* Column Info */
	private String r9FcastQty = null;
	/* Column Info */
	private String fcastYrwk0 = null;
	/* Column Info */
	private String d5FcastQty = null;
	/* Column Info */
	private String totalFcastQty = null;
	/* Column Info */
	private String o2FcastQty = null;
	/* Column Info */
	private String r2FcastQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String title = null;
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
	private String tpCd = null;
	/* Column Info */
	private String a4FcastQty = null;
	/* Column Info */
	private String a5FcastQty = null;	
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String d2FcastQty = null;
	/* Column Info */
	private String r5FcastQty = null;
	/* Column Info */
	private String s4FcastQty = null;
	/* Column Info */
	private String s2FcastQty = null;
	/* Column Info */
	private String sTotal = null;
	/* Column Info */
	private String f4FcastQty = null;
	/* Column Info */
	private String f5FcastQty = null;
	/* Column Info */
	private String o4FcastQty = null;
	/* Column Info */
	private String f2FcastQty = null;
	/* Column Info */
	private String d4FcastQty = null;
	/* Column Info */
	private String fcastYrwk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String locGrpCd = null;
	/* Column Info */
	private String o5FcastQty = null;
	/* Column Info */
	private String logSeq = null;
	/* Column Info */
	private String ofcCd = null;	
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String loclDt = null;
	/* Column Info */
	private String creDt = null;	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MtyBalanceListVO() {}

	public MtyBalanceListVO(String ibflag, String pagerows, String dpSeq, String d7FcastQty, String a2FcastQty, String d5FcastQty, String fcastYrwk0, String totalFcastQty, String r2FcastQty, String o2FcastQty, String locCd, String title, String dTotal, String gTotal, String inpYrwk, String tpCd, String a4FcastQty, String a5FcastQty, String updUsrId, String d2FcastQty, String r5FcastQty, String r9FcastQty, String s4FcastQty, String s2FcastQty, String sTotal, String f4FcastQty, String f5FcastQty, String o4FcastQty, String creUsrId, String fcastYrwk, String d4FcastQty, String f2FcastQty, String o5FcastQty, 
			String item, String locGrpCd, String logSeq, String ofcCd, String usrNm, String loclDt, String creDt) {
		this.dpSeq = dpSeq;
		this.a2FcastQty = a2FcastQty;
		this.d7FcastQty = d7FcastQty;
		this.r9FcastQty = r9FcastQty;
		this.fcastYrwk0 = fcastYrwk0;
		this.d5FcastQty = d5FcastQty;
		this.totalFcastQty = totalFcastQty;
		this.o2FcastQty = o2FcastQty;
		this.r2FcastQty = r2FcastQty;
		this.pagerows = pagerows;
		this.title = title;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.dTotal = dTotal;
		this.gTotal = gTotal;
		this.inpYrwk = inpYrwk;
		this.tpCd = tpCd;
		this.a4FcastQty = a4FcastQty;
		this.a5FcastQty = a5FcastQty;		
		this.updUsrId = updUsrId;
		this.d2FcastQty = d2FcastQty;
		this.r5FcastQty = r5FcastQty;
		this.s4FcastQty = s4FcastQty;
		this.s2FcastQty = s2FcastQty;
		this.sTotal = sTotal;
		this.f4FcastQty = f4FcastQty;
		this.f5FcastQty = f5FcastQty;
		this.o4FcastQty = o4FcastQty;
		this.f2FcastQty = f2FcastQty;
		this.d4FcastQty = d4FcastQty;
		this.fcastYrwk = fcastYrwk;
		this.creUsrId = creUsrId;
		this.item = item;
		this.locGrpCd = locGrpCd;
		this.o5FcastQty = o5FcastQty;
		this.logSeq = logSeq;
		this.ofcCd = ofcCd;	
		this.usrNm = usrNm;	
		this.loclDt = loclDt;	
		this.creDt = creDt;			
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("a2_fcast_qty", getA2FcastQty());
		this.hashColumns.put("d7_fcast_qty", getD7FcastQty());
		this.hashColumns.put("r9_fcast_qty", getR9FcastQty());
		this.hashColumns.put("fcast_yrwk0", getFcastYrwk0());
		this.hashColumns.put("d5_fcast_qty", getD5FcastQty());
		this.hashColumns.put("total_fcast_qty", getTotalFcastQty());
		this.hashColumns.put("o2_fcast_qty", getO2FcastQty());
		this.hashColumns.put("r2_fcast_qty", getR2FcastQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("d_total", getDTotal());
		this.hashColumns.put("g_total", getGTotal());
		this.hashColumns.put("inp_yrwk", getInpYrwk());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("a4_fcast_qty", getA4FcastQty());
		this.hashColumns.put("a5_fcast_qty", getA5FcastQty());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("d2_fcast_qty", getD2FcastQty());
		this.hashColumns.put("r5_fcast_qty", getR5FcastQty());
		this.hashColumns.put("s4_fcast_qty", getS4FcastQty());
		this.hashColumns.put("s2_fcast_qty", getS2FcastQty());
		this.hashColumns.put("s_total", getSTotal());
		this.hashColumns.put("f4_fcast_qty", getF4FcastQty());
		this.hashColumns.put("f5_fcast_qty", getF5FcastQty());
		this.hashColumns.put("o4_fcast_qty", getO4FcastQty());
		this.hashColumns.put("f2_fcast_qty", getF2FcastQty());
		this.hashColumns.put("d4_fcast_qty", getD4FcastQty());
		this.hashColumns.put("fcast_yrwk", getFcastYrwk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("loc_grp_cd", getLocGrpCd());
		this.hashColumns.put("o5_fcast_qty", getO5FcastQty());
		this.hashColumns.put("log_seq", getLogSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());	
		this.hashColumns.put("usr_nm", getUsrNm());	
		this.hashColumns.put("locl_dt", getLoclDt());	
		this.hashColumns.put("cre_dt", getCreDt());			
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("a2_fcast_qty", "a2FcastQty");
		this.hashFields.put("d7_fcast_qty", "d7FcastQty");
		this.hashFields.put("r9_fcast_qty", "r9FcastQty");
		this.hashFields.put("fcast_yrwk0", "fcastYrwk0");
		this.hashFields.put("d5_fcast_qty", "d5FcastQty");
		this.hashFields.put("total_fcast_qty", "totalFcastQty");
		this.hashFields.put("o2_fcast_qty", "o2FcastQty");
		this.hashFields.put("r2_fcast_qty", "r2FcastQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("title", "title");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d_total", "dTotal");
		this.hashFields.put("g_total", "gTotal");
		this.hashFields.put("inp_yrwk", "inpYrwk");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("a4_fcast_qty", "a4FcastQty");
		this.hashFields.put("a5_fcast_qty", "a5FcastQty");		
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("d2_fcast_qty", "d2FcastQty");
		this.hashFields.put("r5_fcast_qty", "r5FcastQty");
		this.hashFields.put("s4_fcast_qty", "s4FcastQty");
		this.hashFields.put("s2_fcast_qty", "s2FcastQty");
		this.hashFields.put("s_total", "sTotal");
		this.hashFields.put("f4_fcast_qty", "f4FcastQty");
		this.hashFields.put("f5_fcast_qty", "f5FcastQty");
		this.hashFields.put("o4_fcast_qty", "o4FcastQty");
		this.hashFields.put("f2_fcast_qty", "f2FcastQty");
		this.hashFields.put("d4_fcast_qty", "d4FcastQty");
		this.hashFields.put("fcast_yrwk", "fcastYrwk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("item", "item");
		this.hashFields.put("loc_grp_cd", "locGrpCd");
		this.hashFields.put("o5_fcast_qty", "o5FcastQty");
		this.hashFields.put("log_seq", "logSeq");
		this.hashFields.put("ofc_cd", "ofcCd");		
		this.hashFields.put("usr_nm", "usrNm");		
		this.hashFields.put("locl_dt", "loclDt");		
		this.hashFields.put("cre_dt", "creDt");				
		return this.hashFields;
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
	 * @return loclDt
	 */
	public String getLoclDt() {
		return this.loclDt;
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
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
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
	 * @return r9FcastQty
	 */
	public String getR9FcastQty() {
		return this.r9FcastQty;
	}
	
	/**
	 * Column Info
	 * @return fcastYrwk0
	 */
	public String getFcastYrwk0() {
		return this.fcastYrwk0;
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
	 * @return totalFcastQty
	 */
	public String getTotalFcastQty() {
		return this.totalFcastQty;
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
	 * @return r2FcastQty
	 */
	public String getR2FcastQty() {
		return this.r2FcastQty;
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
	 * @return title
	 */
	public String getTitle() {
		return this.title;
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
	 * @return tpCd
	 */
	public String getTpCd() {
		return this.tpCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return sTotal
	 */
	public String getSTotal() {
		return this.sTotal;
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
	 * @return f2FcastQty
	 */
	public String getF2FcastQty() {
		return this.f2FcastQty;
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
	 * @return fcastYrwk
	 */
	public String getFcastYrwk() {
		return this.fcastYrwk;
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
	 * @return item
	 */
	public String getItem() {
		return this.item;
	}
	
	/**
	 * Column Info
	 * @return locGrpCd
	 */
	public String getLocGrpCd() {
		return this.locGrpCd;
	}
	
	/**
	 * Column Info
	 * @return o5FcastQty
	 */
	public String getO5FcastQty() {
		return this.o5FcastQty;
	}
	
	/**
	 * Column Info
	 * @return logSeq
	 */
	public String getLogSeq() {
		return this.logSeq;
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
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
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
	 * @param r9FcastQty
	 */
	public void setR9FcastQty(String r9FcastQty) {
		this.r9FcastQty = r9FcastQty;
	}
	
	/**
	 * Column Info
	 * @param fcastYrwk0
	 */
	public void setFcastYrwk0(String fcastYrwk0) {
		this.fcastYrwk0 = fcastYrwk0;
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
	 * @param totalFcastQty
	 */
	public void setTotalFcastQty(String totalFcastQty) {
		this.totalFcastQty = totalFcastQty;
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
	 * @param r2FcastQty
	 */
	public void setR2FcastQty(String r2FcastQty) {
		this.r2FcastQty = r2FcastQty;
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
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @param tpCd
	 */
	public void setTpCd(String tpCd) {
		this.tpCd = tpCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param sTotal
	 */
	public void setSTotal(String sTotal) {
		this.sTotal = sTotal;
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
	 * @param f2FcastQty
	 */
	public void setF2FcastQty(String f2FcastQty) {
		this.f2FcastQty = f2FcastQty;
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
	 * @param fcastYrwk
	 */
	public void setFcastYrwk(String fcastYrwk) {
		this.fcastYrwk = fcastYrwk;
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
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
	}
	
	/**
	 * Column Info
	 * @param locGrpCd
	 */
	public void setLocGrpCd(String locGrpCd) {
		this.locGrpCd = locGrpCd;
	}
	
	/**
	 * Column Info
	 * @param o5FcastQty
	 */
	public void setO5FcastQty(String o5FcastQty) {
		this.o5FcastQty = o5FcastQty;
	}
	
	/**
	 * Column Info
	 * @param logSeq
	 */
	public void setLogSeq(String logSeq) {
		this.logSeq = logSeq;
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
	 * @return usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}	
	
	/**
	 * Column Info
	 * @return loclDt
	 */
	public void setLoclDt(String loclDt) {
		this.loclDt = loclDt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setA2FcastQty(JSPUtil.getParameter(request, prefix + "a2_fcast_qty", ""));
		setD7FcastQty(JSPUtil.getParameter(request, prefix + "d7_fcast_qty", ""));
		setR9FcastQty(JSPUtil.getParameter(request, prefix + "r9_fcast_qty", ""));
		setFcastYrwk0(JSPUtil.getParameter(request, prefix + "fcast_yrwk0", ""));
		setD5FcastQty(JSPUtil.getParameter(request, prefix + "d5_fcast_qty", ""));
		setTotalFcastQty(JSPUtil.getParameter(request, prefix + "total_fcast_qty", ""));
		setO2FcastQty(JSPUtil.getParameter(request, prefix + "o2_fcast_qty", ""));
		setR2FcastQty(JSPUtil.getParameter(request, prefix + "r2_fcast_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTitle(JSPUtil.getParameter(request, prefix + "title", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDTotal(JSPUtil.getParameter(request, prefix + "d_total", ""));
		setGTotal(JSPUtil.getParameter(request, prefix + "g_total", ""));
		setInpYrwk(JSPUtil.getParameter(request, prefix + "inp_yrwk", ""));
		setTpCd(JSPUtil.getParameter(request, prefix + "tp_cd", ""));
		setA4FcastQty(JSPUtil.getParameter(request, prefix + "a4_fcast_qty", ""));
		setA5FcastQty(JSPUtil.getParameter(request, prefix + "a5_fcast_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setD2FcastQty(JSPUtil.getParameter(request, prefix + "d2_fcast_qty", ""));
		setR5FcastQty(JSPUtil.getParameter(request, prefix + "r5_fcast_qty", ""));
		setS4FcastQty(JSPUtil.getParameter(request, prefix + "s4_fcast_qty", ""));
		setS2FcastQty(JSPUtil.getParameter(request, prefix + "s2_fcast_qty", ""));
		setSTotal(JSPUtil.getParameter(request, prefix + "s_total", ""));
		setF4FcastQty(JSPUtil.getParameter(request, prefix + "f4_fcast_qty", ""));
		setF5FcastQty(JSPUtil.getParameter(request, prefix + "f5_fcast_qty", ""));
		setO4FcastQty(JSPUtil.getParameter(request, prefix + "o4_fcast_qty", ""));
		setF2FcastQty(JSPUtil.getParameter(request, prefix + "f2_fcast_qty", ""));
		setD4FcastQty(JSPUtil.getParameter(request, prefix + "d4_fcast_qty", ""));
		setFcastYrwk(JSPUtil.getParameter(request, prefix + "fcast_yrwk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setItem(JSPUtil.getParameter(request, prefix + "item", ""));
		setLocGrpCd(JSPUtil.getParameter(request, prefix + "loc_grp_cd", ""));
		setO5FcastQty(JSPUtil.getParameter(request, prefix + "o5_fcast_qty", ""));
		setLogSeq(JSPUtil.getParameter(request, prefix + "log_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));		
		
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));	
		setLoclDt(JSPUtil.getParameter(request, prefix + "locl_dt", ""));	
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));			
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyBalanceListVO[]
	 */
	public MtyBalanceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyBalanceListVO[]
	 */
	public MtyBalanceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MtyBalanceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] a2FcastQty = (JSPUtil.getParameter(request, prefix	+ "a2_fcast_qty", length));
			String[] d7FcastQty = (JSPUtil.getParameter(request, prefix	+ "d7_fcast_qty", length));
			String[] r9FcastQty = (JSPUtil.getParameter(request, prefix	+ "r9_fcast_qty", length));
			String[] fcastYrwk0 = (JSPUtil.getParameter(request, prefix	+ "fcast_yrwk0", length));
			String[] d5FcastQty = (JSPUtil.getParameter(request, prefix	+ "d5_fcast_qty", length));
			String[] totalFcastQty = (JSPUtil.getParameter(request, prefix	+ "total_fcast_qty", length));
			String[] o2FcastQty = (JSPUtil.getParameter(request, prefix	+ "o2_fcast_qty", length));
			String[] r2FcastQty = (JSPUtil.getParameter(request, prefix	+ "r2_fcast_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dTotal = (JSPUtil.getParameter(request, prefix	+ "d_total", length));
			String[] gTotal = (JSPUtil.getParameter(request, prefix	+ "g_total", length));
			String[] inpYrwk = (JSPUtil.getParameter(request, prefix	+ "inp_yrwk", length));
			String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
			String[] a4FcastQty = (JSPUtil.getParameter(request, prefix	+ "a4_fcast_qty", length));
			String[] a5FcastQty = (JSPUtil.getParameter(request, prefix	+ "a5_fcast_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] d2FcastQty = (JSPUtil.getParameter(request, prefix	+ "d2_fcast_qty", length));
			String[] r5FcastQty = (JSPUtil.getParameter(request, prefix	+ "r5_fcast_qty", length));
			String[] s4FcastQty = (JSPUtil.getParameter(request, prefix	+ "s4_fcast_qty", length));
			String[] s2FcastQty = (JSPUtil.getParameter(request, prefix	+ "s2_fcast_qty", length));
			String[] sTotal = (JSPUtil.getParameter(request, prefix	+ "s_total", length));
			String[] f4FcastQty = (JSPUtil.getParameter(request, prefix	+ "f4_fcast_qty", length));
			String[] f5FcastQty = (JSPUtil.getParameter(request, prefix	+ "f5_fcast_qty", length));
			String[] o4FcastQty = (JSPUtil.getParameter(request, prefix	+ "o4_fcast_qty", length));
			String[] f2FcastQty = (JSPUtil.getParameter(request, prefix	+ "f2_fcast_qty", length));
			String[] d4FcastQty = (JSPUtil.getParameter(request, prefix	+ "d4_fcast_qty", length));
			String[] fcastYrwk = (JSPUtil.getParameter(request, prefix	+ "fcast_yrwk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] locGrpCd = (JSPUtil.getParameter(request, prefix	+ "loc_grp_cd", length));
			String[] o5FcastQty = (JSPUtil.getParameter(request, prefix	+ "o5_fcast_qty", length));
			String[] logSeq = (JSPUtil.getParameter(request, prefix	+ "log_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));		
			String[] loclDt = (JSPUtil.getParameter(request, prefix	+ "locl_dt", length));		
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));					
			
			for (int i = 0; i < length; i++) {
				model = new MtyBalanceListVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (a2FcastQty[i] != null)
					model.setA2FcastQty(a2FcastQty[i]);
				if (d7FcastQty[i] != null)
					model.setD7FcastQty(d7FcastQty[i]);
				if (r9FcastQty[i] != null)
					model.setR9FcastQty(r9FcastQty[i]);
				if (fcastYrwk0[i] != null)
					model.setFcastYrwk0(fcastYrwk0[i]);
				if (d5FcastQty[i] != null)
					model.setD5FcastQty(d5FcastQty[i]);
				if (totalFcastQty[i] != null)
					model.setTotalFcastQty(totalFcastQty[i]);
				if (o2FcastQty[i] != null)
					model.setO2FcastQty(o2FcastQty[i]);
				if (r2FcastQty[i] != null)
					model.setR2FcastQty(r2FcastQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
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
				if (tpCd[i] != null)
					model.setTpCd(tpCd[i]);
				if (a4FcastQty[i] != null)
					model.setA4FcastQty(a4FcastQty[i]);
				if (a5FcastQty[i] != null)
					model.setA5FcastQty(a5FcastQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (d2FcastQty[i] != null)
					model.setD2FcastQty(d2FcastQty[i]);
				if (r5FcastQty[i] != null)
					model.setR5FcastQty(r5FcastQty[i]);
				if (s4FcastQty[i] != null)
					model.setS4FcastQty(s4FcastQty[i]);
				if (s2FcastQty[i] != null)
					model.setS2FcastQty(s2FcastQty[i]);
				if (sTotal[i] != null)
					model.setSTotal(sTotal[i]);
				if (f4FcastQty[i] != null)
					model.setF4FcastQty(f4FcastQty[i]);
				if (f5FcastQty[i] != null)
					model.setF5FcastQty(f5FcastQty[i]);
				if (o4FcastQty[i] != null)
					model.setO4FcastQty(o4FcastQty[i]);
				if (f2FcastQty[i] != null)
					model.setF2FcastQty(f2FcastQty[i]);
				if (d4FcastQty[i] != null)
					model.setD4FcastQty(d4FcastQty[i]);
				if (fcastYrwk[i] != null)
					model.setFcastYrwk(fcastYrwk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (locGrpCd[i] != null)
					model.setLocGrpCd(locGrpCd[i]);
				if (o5FcastQty[i] != null)
					model.setO5FcastQty(o5FcastQty[i]);
				if (logSeq[i] != null)
					model.setLogSeq(logSeq[i]);		
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);		
				
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);	
				if (loclDt[i] != null)
					model.setLoclDt(loclDt[i]);	
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);					
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMtyBalanceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyBalanceListVO[]
	 */
	public MtyBalanceListVO[] getMtyBalanceListVOs(){
		MtyBalanceListVO[] vos = (MtyBalanceListVO[])models.toArray(new MtyBalanceListVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2FcastQty = this.a2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7FcastQty = this.d7FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r9FcastQty = this.r9FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastYrwk0 = this.fcastYrwk0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5FcastQty = this.d5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalFcastQty = this.totalFcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2FcastQty = this.o2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2FcastQty = this.r2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTotal = this.dTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gTotal = this.gTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpYrwk = this.inpYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4FcastQty = this.a4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a5FcastQty = this.a5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2FcastQty = this.d2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5FcastQty = this.r5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4FcastQty = this.s4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2FcastQty = this.s2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTotal = this.sTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4FcastQty = this.f4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5FcastQty = this.f5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4FcastQty = this.o4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2FcastQty = this.f2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4FcastQty = this.d4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastYrwk = this.fcastYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrpCd = this.locGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5FcastQty = this.o5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logSeq = this.logSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.loclDt = this.loclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");			
	}

	public String getA5FcastQty() {
		return a5FcastQty;
	}

	public void setA5FcastQty(String a5FcastQty) {
		this.a5FcastQty = a5FcastQty;
	}
}
