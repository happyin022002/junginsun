/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MtyBalanceRepoListVO.java
*@FileTitle : MtyBalanceRepoListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.05.23 나상보 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo;

import java.lang.reflect.Field;
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

public class MtyBalanceRepoListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MtyBalanceRepoListVO> models = new ArrayList<MtyBalanceRepoListVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String a2FcastQty = null;
	/* Column Info */
	private String d7FcastQty = null;
	/* Column Info */
	private String r9FcastQty = null;
	/* Column Info */
	private String creSeq = null;
	/* Column Info */
	private String rptSeq = null;	
	/* Column Info */
	private String fmYdCd = null;
	/* Column Info */
	private String d5FcastQty = null;
	/* Column Info */
	private String trspModCd = null;
	/* Column Info */
	private String toYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String r2FcastQty = null;
	/* Column Info */
	private String o2FcastQty = null;
	/* Column Info */
	private String vslLaneCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmEtdDt = null;
	/* Column Info */
	private String inpYrwk = null;
	/* Column Info */
	private String a4FcastQty = null;
	/* Column Info */
	private String locGrpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String d2FcastQty = null;
	/* Column Info */
	private String toEtbDt = null;
	/* Column Info */
	private String toEtbDtOrg = null;  	
	/* Column Info */
	private String r5FcastQty = null;
	/* Column Info */
	private String s4FcastQty = null;
	/* Column Info */
	private String s2FcastQty = null;
	/* Column Info */
	private String f4FcastQty = null;
	/* Column Info */
	private String f5FcastQty = null;
	/* Column Info */
	private String vvd = null;
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
	private String remark = null;
	/* Column Info */
	private String toEtbDay = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String wkStDt = null;
	/* Column Info */
	private String wkEndDt = null;
	/* Column Info */
	private String currFlag = null;
	/* Column Info */
	private String div  = null;	
	/* Column Info */
	private String ofcCd  = null;		
			

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MtyBalanceRepoListVO() {}

	public MtyBalanceRepoListVO(String ibflag, String pagerows, String locGrpCd, String locCd, String inpYrwk, String fcastYrwk, String creSeq, String rptSeq, String trspModCd, String vslLaneCd, String vvd, String fmYdCd, String fmEtdDt, String toYdCd, String toEtbDt, String toEtbDtOrg, String total, String d2FcastQty, String d4FcastQty, String d5FcastQty, String d7FcastQty, String r2FcastQty, String r5FcastQty, String r9FcastQty, String o2FcastQty, String s2FcastQty, String o4FcastQty, String s4FcastQty, String f2FcastQty, String a2FcastQty, String f4FcastQty, String a4FcastQty, String f5FcastQty, String creUsrId, String updUsrId, String remark, String toEtbDay, String lvl, String wkStDt, String wkEndDt, String currFlag, String div, String ofcCd) {
		this.total = total;
		this.a2FcastQty = a2FcastQty;
		this.d7FcastQty = d7FcastQty;
		this.r9FcastQty = r9FcastQty;
		this.creSeq = creSeq;
		this.rptSeq = rptSeq;		
		this.fmYdCd = fmYdCd;
		this.d5FcastQty = d5FcastQty;
		this.trspModCd = trspModCd;
		this.toYdCd = toYdCd;
		this.pagerows = pagerows;
		this.r2FcastQty = r2FcastQty;
		this.o2FcastQty = o2FcastQty;
		this.vslLaneCd = vslLaneCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.fmEtdDt = fmEtdDt;
		this.inpYrwk = inpYrwk;
		this.a4FcastQty = a4FcastQty;
		this.locGrpCd = locGrpCd;
		this.updUsrId = updUsrId;
		this.d2FcastQty = d2FcastQty;
		this.toEtbDt = toEtbDt;
		this.toEtbDtOrg = toEtbDtOrg;
		this.r5FcastQty = r5FcastQty;
		this.s4FcastQty = s4FcastQty;
		this.s2FcastQty = s2FcastQty;
		this.f4FcastQty = f4FcastQty;
		this.f5FcastQty = f5FcastQty;
		this.vvd = vvd;
		this.o4FcastQty = o4FcastQty;
		this.creUsrId = creUsrId;
		this.f2FcastQty = f2FcastQty;
		this.fcastYrwk = fcastYrwk;
		this.d4FcastQty = d4FcastQty;
		this.remark = remark;
		this.toEtbDay = toEtbDay;
		this.lvl = lvl;
		this.wkStDt = wkStDt;
		this.wkEndDt = wkEndDt;
		this.currFlag = currFlag;
		this.div   = div;	
		this.ofcCd = ofcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("a2_fcast_qty", getA2FcastQty());
		this.hashColumns.put("d7_fcast_qty", getD7FcastQty());
		this.hashColumns.put("r9_fcast_qty", getR9FcastQty());
		this.hashColumns.put("cre_seq", getCreSeq());
		this.hashColumns.put("rpt_seq", getRptSeq());		
		this.hashColumns.put("fm_yd_cd", getFmYdCd());
		this.hashColumns.put("d5_fcast_qty", getD5FcastQty());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("to_yd_cd", getToYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("r2_fcast_qty", getR2FcastQty());
		this.hashColumns.put("o2_fcast_qty", getO2FcastQty());
		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_etd_dt", getFmEtdDt());
		this.hashColumns.put("inp_yrwk", getInpYrwk());
		this.hashColumns.put("a4_fcast_qty", getA4FcastQty());
		this.hashColumns.put("loc_grp_cd", getLocGrpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("d2_fcast_qty", getD2FcastQty());
		this.hashColumns.put("to_etb_dt", getToEtbDt());
		this.hashColumns.put("to_etb_dt_org", getToEtbDtOrg());		
		this.hashColumns.put("r5_fcast_qty", getR5FcastQty());
		this.hashColumns.put("s4_fcast_qty", getS4FcastQty());
		this.hashColumns.put("s2_fcast_qty", getS2FcastQty());
		this.hashColumns.put("f4_fcast_qty", getF4FcastQty());
		this.hashColumns.put("f5_fcast_qty", getF5FcastQty());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("o4_fcast_qty", getO4FcastQty());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("f2_fcast_qty", getF2FcastQty());
		this.hashColumns.put("fcast_yrwk", getFcastYrwk());
		this.hashColumns.put("d4_fcast_qty", getD4FcastQty());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("to_etb_day", getToEtbDay());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("wk_st_dt", getWkStDt());
		this.hashColumns.put("wk_end_dt", getWkEndDt());
		this.hashColumns.put("curr_flag", getCurrFlag());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("ofcCd", getOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("a2_fcast_qty", "a2FcastQty");
		this.hashFields.put("d7_fcast_qty", "d7FcastQty");
		this.hashFields.put("r9_fcast_qty", "r9FcastQty");
		this.hashFields.put("cre_seq", "creSeq");
		this.hashFields.put("rpt_seq", "rptSeq");		
		this.hashFields.put("fm_yd_cd", "fmYdCd");
		this.hashFields.put("d5_fcast_qty", "d5FcastQty");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("to_yd_cd", "toYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("r2_fcast_qty", "r2FcastQty");
		this.hashFields.put("o2_fcast_qty", "o2FcastQty");
		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_etd_dt", "fmEtdDt");
		this.hashFields.put("inp_yrwk", "inpYrwk");
		this.hashFields.put("a4_fcast_qty", "a4FcastQty");
		this.hashFields.put("loc_grp_cd", "locGrpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("d2_fcast_qty", "d2FcastQty");
		this.hashFields.put("to_etb_dt", "toEtbDt");
		this.hashFields.put("to_etb_dt_org", "toEtbDtOrg");		
		this.hashFields.put("r5_fcast_qty", "r5FcastQty");
		this.hashFields.put("s4_fcast_qty", "s4FcastQty");
		this.hashFields.put("s2_fcast_qty", "s2FcastQty");
		this.hashFields.put("f4_fcast_qty", "f4FcastQty");
		this.hashFields.put("f5_fcast_qty", "f5FcastQty");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("o4_fcast_qty", "o4FcastQty");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("f2_fcast_qty", "f2FcastQty");
		this.hashFields.put("fcast_yrwk", "fcastYrwk");
		this.hashFields.put("d4_fcast_qty", "d4FcastQty");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("to_etb_day", "toEtbDay");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("wk_st_dt", "wkStDt");
		this.hashFields.put("wk_end_dt", "wkEndDt");
		this.hashFields.put("curr_flag", "currFlag");
		this.hashFields.put("div", "div");	
		this.hashFields.put("ofc_cd", "ofcCd");	
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
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
	 * @return creSeq
	 */
	public String getCreSeq() {
		return this.creSeq;
	}
	
	/**
	 * Column Info
	 * @return rptSeq
	 */
	public String getRptSeq() {
		return this.rptSeq;
	}	
	
	/**
	 * Column Info
	 * @return fmYdCd
	 */
	public String getFmYdCd() {
		return this.fmYdCd;
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
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
	}
	
	/**
	 * Column Info
	 * @return toYdCd
	 */
	public String getToYdCd() {
		return this.toYdCd;
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
	 * @return vslLaneCd
	 */
	public String getVslLaneCd() {
		return this.vslLaneCd;
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
	 * @return fmEtdDt
	 */
	public String getFmEtdDt() {
		return this.fmEtdDt;
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
	 * @return a4FcastQty
	 */
	public String getA4FcastQty() {
		return this.a4FcastQty;
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
	 * @return toEtbDt
	 */
	public String getToEtbDt() {
		return this.toEtbDt;
	}
	
	/**
	 * Column Info
	 * @return toEtbDtOrg
	 */
	public String getToEtbDtOrg() {
		return this.toEtbDtOrg;
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
	 * @return f5FcastQty
	 */
	public String getF5FcastQty() {
		return this.f5FcastQty;
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
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return toEtbDay
	 */
	public String getToEtbDay() {
		return this.toEtbDay;
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
	 * @return wkStDt
	 */
	public String getWkStDt() {
		return this.wkStDt;
	}
	
	/**
	 * Column Info
	 * @return wkEndDt
	 */
	public String getWkEndDt() {
		return this.wkEndDt;
	}
	
	/**
	 * Column Info
	 * @return currFlag
	 */
	public String getCurrFlag() {
		return this.currFlag;
	}

	/**
	 * Column Info
	 * @return div
	 */
	public String getDiv() {
		return this.div;
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
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
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
	 * @param creSeq
	 */
	public void setCreSeq(String creSeq) {
		this.creSeq = creSeq;
	}
	
	/**
	 * Column Info
	 * @param rptSeq
	 */
	public void setRptSeq(String rptSeq) {
		this.rptSeq = rptSeq;
	}	
	
	/**
	 * Column Info
	 * @param fmYdCd
	 */
	public void setFmYdCd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
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
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}
	
	/**
	 * Column Info
	 * @param toYdCd
	 */
	public void setToYdCd(String toYdCd) {
		this.toYdCd = toYdCd;
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
	 * @param vslLaneCd
	 */
	public void setVslLaneCd(String vslLaneCd) {
		this.vslLaneCd = vslLaneCd;
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
	 * @param fmEtdDt
	 */
	public void setFmEtdDt(String fmEtdDt) {
		this.fmEtdDt = fmEtdDt;
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
	 * @param a4FcastQty
	 */
	public void setA4FcastQty(String a4FcastQty) {
		this.a4FcastQty = a4FcastQty;
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
	 * @param toEtbDt
	 */
	public void setToEtbDt(String toEtbDt) {
		this.toEtbDt = toEtbDt;
	}
	
	/**
	 * Column Info
	 * @param toEtbDtOrg
	 */
	public void setToEtbDtOrg(String toEtbDtOrg) {
		this.toEtbDtOrg = toEtbDtOrg;
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
	 * @param f5FcastQty
	 */
	public void setF5FcastQty(String f5FcastQty) {
		this.f5FcastQty = f5FcastQty;
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
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param toEtbDay
	 */
	public void setToEtbDay(String toEtbDay) {
		this.toEtbDay = toEtbDay;
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
	 * @param wkStDt
	 */
	public void setWkStDt(String wkStDt) {
		this.wkStDt = wkStDt;
	}
	
	/**
	 * Column Info
	 * @param wkEndDt
	 */
	public void setWkEndDt(String wkEndDt) {
		this.wkEndDt = wkEndDt;
	}
	
	/**
	 * Column Info
	 * @param currFlag
	 */
	public void setCurrFlag(String currFlag) {
		this.currFlag = currFlag;
	}
	
	/**
	 * Column Info
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
	}	
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setA2FcastQty(JSPUtil.getParameter(request, prefix + "a2_fcast_qty", ""));
		setD7FcastQty(JSPUtil.getParameter(request, prefix + "d7_fcast_qty", ""));
		setR9FcastQty(JSPUtil.getParameter(request, prefix + "r9_fcast_qty", ""));
		setCreSeq(JSPUtil.getParameter(request, prefix + "cre_seq", ""));
		setRptSeq(JSPUtil.getParameter(request, prefix + "rpt_seq", ""));		
		setFmYdCd(JSPUtil.getParameter(request, prefix + "fm_yd_cd", ""));
		setD5FcastQty(JSPUtil.getParameter(request, prefix + "d5_fcast_qty", ""));
		setTrspModCd(JSPUtil.getParameter(request, prefix + "trsp_mod_cd", ""));
		setToYdCd(JSPUtil.getParameter(request, prefix + "to_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setR2FcastQty(JSPUtil.getParameter(request, prefix + "r2_fcast_qty", ""));
		setO2FcastQty(JSPUtil.getParameter(request, prefix + "o2_fcast_qty", ""));
		setVslLaneCd(JSPUtil.getParameter(request, prefix + "vsl_lane_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmEtdDt(JSPUtil.getParameter(request, prefix + "fm_etd_dt", ""));
		setInpYrwk(JSPUtil.getParameter(request, prefix + "inp_yrwk", ""));
		setA4FcastQty(JSPUtil.getParameter(request, prefix + "a4_fcast_qty", ""));
		setLocGrpCd(JSPUtil.getParameter(request, prefix + "loc_grp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setD2FcastQty(JSPUtil.getParameter(request, prefix + "d2_fcast_qty", ""));
		setToEtbDt(JSPUtil.getParameter(request, prefix + "to_etb_dt", ""));
		setToEtbDtOrg(JSPUtil.getParameter(request, prefix + "to_etb_dt_org", ""));		
		setR5FcastQty(JSPUtil.getParameter(request, prefix + "r5_fcast_qty", ""));
		setS4FcastQty(JSPUtil.getParameter(request, prefix + "s4_fcast_qty", ""));
		setS2FcastQty(JSPUtil.getParameter(request, prefix + "s2_fcast_qty", ""));
		setF4FcastQty(JSPUtil.getParameter(request, prefix + "f4_fcast_qty", ""));
		setF5FcastQty(JSPUtil.getParameter(request, prefix + "f5_fcast_qty", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setO4FcastQty(JSPUtil.getParameter(request, prefix + "o4_fcast_qty", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setF2FcastQty(JSPUtil.getParameter(request, prefix + "f2_fcast_qty", ""));
		setFcastYrwk(JSPUtil.getParameter(request, prefix + "fcast_yrwk", ""));
		setD4FcastQty(JSPUtil.getParameter(request, prefix + "d4_fcast_qty", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setToEtbDay(JSPUtil.getParameter(request, prefix + "to_etb_day", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setWkStDt(JSPUtil.getParameter(request, "wk_st_dt", ""));
		setWkEndDt(JSPUtil.getParameter(request, "wk_end_dt", ""));
		setCurrFlag(JSPUtil.getParameter(request, "curr_flag", ""));
		setDiv(JSPUtil.getParameter(request, "div", ""));		
		setOfcCd(JSPUtil.getParameter(request, "ofcCd", ""));				
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyBalanceRepoListVO[]
	 */
	public MtyBalanceRepoListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyBalanceRepoListVO[]
	 */
	public MtyBalanceRepoListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MtyBalanceRepoListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] a2FcastQty = (JSPUtil.getParameter(request, prefix	+ "a2_fcast_qty", length));
			String[] d7FcastQty = (JSPUtil.getParameter(request, prefix	+ "d7_fcast_qty", length));
			String[] r9FcastQty = (JSPUtil.getParameter(request, prefix	+ "r9_fcast_qty", length));
			String[] creSeq = (JSPUtil.getParameter(request, prefix	+ "cre_seq", length));
			String[] rptSeq = (JSPUtil.getParameter(request, prefix	+ "rpt_seq", length));			
			String[] fmYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_yd_cd", length));
			String[] d5FcastQty = (JSPUtil.getParameter(request, prefix	+ "d5_fcast_qty", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] toYdCd = (JSPUtil.getParameter(request, prefix	+ "to_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] r2FcastQty = (JSPUtil.getParameter(request, prefix	+ "r2_fcast_qty", length));
			String[] o2FcastQty = (JSPUtil.getParameter(request, prefix	+ "o2_fcast_qty", length));
			String[] vslLaneCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmEtdDt = (JSPUtil.getParameter(request, prefix	+ "fm_etd_dt", length));
			String[] inpYrwk = (JSPUtil.getParameter(request, prefix	+ "inp_yrwk", length));
			String[] a4FcastQty = (JSPUtil.getParameter(request, prefix	+ "a4_fcast_qty", length));
			String[] locGrpCd = (JSPUtil.getParameter(request, prefix	+ "loc_grp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] d2FcastQty = (JSPUtil.getParameter(request, prefix	+ "d2_fcast_qty", length));
			String[] toEtbDt = (JSPUtil.getParameter(request, prefix	+ "to_etb_dt", length));
			String[] toEtbDtOrg = (JSPUtil.getParameter(request, prefix	+ "to_etb_dt_org", length));
			String[] r5FcastQty = (JSPUtil.getParameter(request, prefix	+ "r5_fcast_qty", length));
			String[] s4FcastQty = (JSPUtil.getParameter(request, prefix	+ "s4_fcast_qty", length));
			String[] s2FcastQty = (JSPUtil.getParameter(request, prefix	+ "s2_fcast_qty", length));
			String[] f4FcastQty = (JSPUtil.getParameter(request, prefix	+ "f4_fcast_qty", length));
			String[] f5FcastQty = (JSPUtil.getParameter(request, prefix	+ "f5_fcast_qty", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] o4FcastQty = (JSPUtil.getParameter(request, prefix	+ "o4_fcast_qty", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] f2FcastQty = (JSPUtil.getParameter(request, prefix	+ "f2_fcast_qty", length));
			String[] fcastYrwk = (JSPUtil.getParameter(request, prefix	+ "fcast_yrwk", length));
			String[] d4FcastQty = (JSPUtil.getParameter(request, prefix	+ "d4_fcast_qty", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] toEtbDay = (JSPUtil.getParameter(request, prefix	+ "to_etb_day", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] wkStDt = (JSPUtil.getParameter(request, prefix	+ "wk_st_dt", length));
			String[] wkEndDt = (JSPUtil.getParameter(request, prefix	+ "wk_end_dt", length));
			String[] currFlag = (JSPUtil.getParameter(request, prefix	+ "curr_flag", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));			
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofcCd", length));			
			
			for (int i = 0; i < length; i++) {
				model = new MtyBalanceRepoListVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (a2FcastQty[i] != null)
					model.setA2FcastQty(a2FcastQty[i]);
				if (d7FcastQty[i] != null)
					model.setD7FcastQty(d7FcastQty[i]);
				if (r9FcastQty[i] != null)
					model.setR9FcastQty(r9FcastQty[i]);
				if (creSeq[i] != null)
					model.setCreSeq(creSeq[i]);
				if (rptSeq[i] != null)
					model.setRptSeq(rptSeq[i]);				
				if (fmYdCd[i] != null)
					model.setFmYdCd(fmYdCd[i]);
				if (d5FcastQty[i] != null)
					model.setD5FcastQty(d5FcastQty[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (toYdCd[i] != null)
					model.setToYdCd(toYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (r2FcastQty[i] != null)
					model.setR2FcastQty(r2FcastQty[i]);
				if (o2FcastQty[i] != null)
					model.setO2FcastQty(o2FcastQty[i]);
				if (vslLaneCd[i] != null)
					model.setVslLaneCd(vslLaneCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmEtdDt[i] != null)
					model.setFmEtdDt(fmEtdDt[i]);
				if (inpYrwk[i] != null)
					model.setInpYrwk(inpYrwk[i]);
				if (a4FcastQty[i] != null)
					model.setA4FcastQty(a4FcastQty[i]);
				if (locGrpCd[i] != null)
					model.setLocGrpCd(locGrpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (d2FcastQty[i] != null)
					model.setD2FcastQty(d2FcastQty[i]);
				if (toEtbDt[i] != null)
					model.setToEtbDt(toEtbDt[i]);
				if (toEtbDtOrg[i] != null)
					model.setToEtbDtOrg(toEtbDtOrg[i]);				
				if (r5FcastQty[i] != null)
					model.setR5FcastQty(r5FcastQty[i]);
				if (s4FcastQty[i] != null)
					model.setS4FcastQty(s4FcastQty[i]);
				if (s2FcastQty[i] != null)
					model.setS2FcastQty(s2FcastQty[i]);
				if (f4FcastQty[i] != null)
					model.setF4FcastQty(f4FcastQty[i]);
				if (f5FcastQty[i] != null)
					model.setF5FcastQty(f5FcastQty[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
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
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (toEtbDay[i] != null)
					model.setToEtbDay(toEtbDay[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (wkStDt[i] != null)
					model.setWkStDt(wkStDt[i]);
				if (wkEndDt[i] != null)
					model.setWkEndDt(wkEndDt[i]);
				if (currFlag[i] != null)
					model.setCurrFlag(currFlag[i]);
				if (div[i] != null)
					model.setDiv(div[i]);		
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);	
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMtyBalanceRepoListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyBalanceRepoListVO[]
	 */
	public MtyBalanceRepoListVO[] getMtyBalanceRepoListVOs(){
		MtyBalanceRepoListVO[] vos = (MtyBalanceRepoListVO[])models.toArray(new MtyBalanceRepoListVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2FcastQty = this.a2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7FcastQty = this.d7FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r9FcastQty = this.r9FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creSeq = this.creSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptSeq = this.rptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.fmYdCd = this.fmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5FcastQty = this.d5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdCd = this.toYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2FcastQty = this.r2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2FcastQty = this.o2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd = this.vslLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEtdDt = this.fmEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpYrwk = this.inpYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4FcastQty = this.a4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrpCd = this.locGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2FcastQty = this.d2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtbDt = this.toEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtbDtOrg = this.toEtbDtOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5FcastQty = this.r5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4FcastQty = this.s4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2FcastQty = this.s2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4FcastQty = this.f4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5FcastQty = this.f5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4FcastQty = this.o4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2FcastQty = this.f2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastYrwk = this.fcastYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4FcastQty = this.d4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtbDay = this.toEtbDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkStDt = this.wkStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkEndDt = this.wkEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currFlag = this.currFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");			
	}
}
