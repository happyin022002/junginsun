/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PlannedRepoInVO.java
*@FileTitle : PlannedRepoInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.26
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.07.26 문동선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo;

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
 * @author 문동선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PlannedRepoInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PlannedRepoInVO> models = new ArrayList<PlannedRepoInVO>();
	
	/* Column Info */
	private String r9Ef = null;
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String d2F = null;
	/* Column Info */
	private String s2Qty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String s2F = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String etbDay = null;
	/* Column Info */
	private String showVvd = null;
	/* Column Info */
	private String r5Ef = null;
	/* Column Info */
	private String r2F = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String wkEndDt = null;
	/* Column Info */
	private String o4Qty = null;
	/* Column Info */
	private String o5Qty = null;	
	/* Column Info */
	private String d5F = null;
	/* Column Info */
	private String a2F = null;
	/* Column Info */
	private String a4Qty = null;
	/* Column Info */
	private String a5Qty = null;	
	/* Column Info */
	private String o2F = null;
	/* Column Info */
	private String a2Qty = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String d7Qty = null;
	/* Column Info */
	private String s4Qty = null;
	/* Column Info */
	private String d2Ef = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String o2Qty = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String o4Ef = null;
	/* Column Info */
	private String o5Ef = null;	
	/* Column Info */
	private String d4Qty = null;
	/* Column Info */
	private String r9Qty = null;
	/* Column Info */
	private String sts = null;
	/* Column Info */
	private String bsa = null;
	/* Column Info */
	private String eqlf = null;
	/* Column Info */
	private String d5Qty = null;
	/* Column Info */
	private String f4F = null;
	/* Column Info */
	private String yard = null;
	/* Column Info */
	private String d4F = null;
	/* Column Info */
	private String d7Ef = null;
	/* Column Info */
	private String creSeq = null;
	/* Column Info */
	private String showWeek = null;
	/* Column Info */
	private String f2Qty = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String f5Ef = null;
	/* Column Info */
	private String o2Ef = null;
	/* Column Info */
	private String showLane = null;
	/* Column Info */
	private String s4Ef = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String f5Qty = null;
	/* Column Info */
	private String d4Ef = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String r9F = null;
	/* Column Info */
	private String wkStDt = null;
	/* Column Info */
	private String s4F = null;
	/* Column Info */
	private String f4Ef = null;
	/* Column Info */
	private String d2Qty = null;
	/* Column Info */
	private String d5Ef = null;
	/* Column Info */
	private String d7F = null;
	/* Column Info */
	private String f5F = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String o4F = null;
	/* Column Info */
	private String o5F = null;	
	/* Column Info */
	private String s2Ef = null;
	/* Column Info */
	private String a4Ef = null;
	/* Column Info */
	private String a5Ef = null;
	
	/* Column Info */
	private String a2Ef = null;
	/* Column Info */
	private String a4F = null;
	/* Column Info */
	private String a5F = null;	
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String r2Qty = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String r5F = null;
	/* Column Info */
	private String f2Ef = null;
	/* Column Info */
	private String r5Qty = null;
	/* Column Info */
	private String r2Ef = null;
	/* Column Info */
	private String f2F = null;
	/* Column Info */
	private String week = null;
	/* Column Info */
	private String f4Qty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PlannedRepoInVO() {}

	public PlannedRepoInVO(String ibflag, String pagerows, String lvl, String week, String sts, String lane, String vslCd, String skdVoyNo, String skdDirCd, String yard, String etb, String etbDay, String d2Qty, String d4Qty, String d5Qty, String d7Qty, String r2Qty, String r5Qty, String r9Qty, String o2Qty, String s2Qty, String o4Qty, String o5Qty,String s4Qty, String f2Qty, String a2Qty, String f4Qty, String a4Qty, String a5Qty, String f5Qty, String d2F, String d4F, String d5F, String d7F, String r2F, String r5F, String r9F, String o2F, String s2F, String o4F, String o5F,String s4F, String f2F, String a2F, String f4F, String a4F, String a5F, String f5F, String d2Ef, String d4Ef, String d5Ef, String d7Ef, String r2Ef, String r5Ef, String r9Ef, String o2Ef, String s2Ef, String o4Ef, String o5Ef,String s4Ef, String f2Ef, String a2Ef, String f4Ef, String a4Ef, String a5Ef, String f5Ef, String bsa, String eqlf, String wkStDt, String wkEndDt, String updDt, String creDt, String updUsrId, String creUsrId, String creSeq, String ofcCd, String showVvd, String showWeek, String showLane, String locCd, String tpsz) {
		this.r9Ef = r9Ef;
		this.etb = etb;
		this.vslCd = vslCd;
		this.d2F = d2F;
		this.s2Qty = s2Qty;
		this.pagerows = pagerows;
		this.s2F = s2F;
		this.locCd = locCd;
		this.etbDay = etbDay;
		this.showVvd = showVvd;
		this.r5Ef = r5Ef;
		this.r2F = r2F;
		this.updUsrId = updUsrId;
		this.wkEndDt = wkEndDt;
		this.o4Qty = o4Qty;
		this.o5Qty = o5Qty;		
		this.d5F = d5F;
		this.a2F = a2F;
		this.a4Qty = a4Qty;
		this.a5Qty = a5Qty;
		this.o2F = o2F;
		this.a2Qty = a2Qty;
		this.skdVoyNo = skdVoyNo;
		this.d7Qty = d7Qty;
		this.s4Qty = s4Qty;
		this.d2Ef = d2Ef;
		this.creUsrId = creUsrId;
		this.tpsz = tpsz;
		this.o2Qty = o2Qty;
		this.lvl = lvl;
		this.o4Ef = o4Ef;
		this.o5Ef = o5Ef;		
		this.d4Qty = d4Qty;
		this.r9Qty = r9Qty;
		this.sts = sts;
		this.bsa = bsa;
		this.eqlf = eqlf;
		this.d5Qty = d5Qty;
		this.f4F = f4F;
		this.yard = yard;
		this.d4F = d4F;
		this.d7Ef = d7Ef;
		this.creSeq = creSeq;
		this.showWeek = showWeek;
		this.f2Qty = f2Qty;
		this.creDt = creDt;
		this.f5Ef = f5Ef;
		this.o2Ef = o2Ef;
		this.showLane = showLane;
		this.s4Ef = s4Ef;
		this.lane = lane;
		this.f5Qty = f5Qty;
		this.d4Ef = d4Ef;
		this.ibflag = ibflag;
		this.r9F = r9F;
		this.wkStDt = wkStDt;
		this.s4F = s4F;
		this.f4Ef = f4Ef;
		this.d2Qty = d2Qty;
		this.d5Ef = d5Ef;
		this.d7F = d7F;
		this.f5F = f5F;
		this.updDt = updDt;
		this.o4F = o4F;
		this.setO5F(o5F);		
		this.s2Ef = s2Ef;
		this.a4Ef = a4Ef;
		this.a5Ef = a5Ef;
		this.a2Ef = a2Ef;
		this.a4F = a4F;
		this.a5F = a5F;
		this.skdDirCd = skdDirCd;
		this.r2Qty = r2Qty;
		this.ofcCd = ofcCd;
		this.r5F = r5F;
		this.f2Ef = f2Ef;
		this.r5Qty = r5Qty;
		this.r2Ef = r2Ef;
		this.f2F = f2F;
		this.week = week;
		this.f4Qty = f4Qty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("r9_ef", getR9Ef());
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("d2_f", getD2F());
		this.hashColumns.put("s2_qty", getS2Qty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s2_f", getS2F());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("etb_day", getEtbDay());
		this.hashColumns.put("show_vvd", getShowVvd());
		this.hashColumns.put("r5_ef", getR5Ef());
		this.hashColumns.put("r2_f", getR2F());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("wk_end_dt", getWkEndDt());
		this.hashColumns.put("o4_qty", getO4Qty());
		this.hashColumns.put("o5_qty", getO5Qty());		
		this.hashColumns.put("d5_f", getD5F());
		this.hashColumns.put("a2_f", getA2F());
		this.hashColumns.put("a4_qty", getA4Qty());
		this.hashColumns.put("a5_qty", getA5Qty());
		this.hashColumns.put("o2_f", getO2F());
		this.hashColumns.put("a2_qty", getA2Qty());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("d7_qty", getD7Qty());
		this.hashColumns.put("s4_qty", getS4Qty());
		this.hashColumns.put("d2_ef", getD2Ef());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("o2_qty", getO2Qty());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("o4_ef", getO4Ef());
		this.hashColumns.put("o5_ef", getO5Ef());		
		this.hashColumns.put("d4_qty", getD4Qty());
		this.hashColumns.put("r9_qty", getR9Qty());
		this.hashColumns.put("sts", getSts());
		this.hashColumns.put("bsa", getBsa());
		this.hashColumns.put("eqlf", getEqlf());
		this.hashColumns.put("d5_qty", getD5Qty());
		this.hashColumns.put("f4_f", getF4F());
		this.hashColumns.put("yard", getYard());
		this.hashColumns.put("d4_f", getD4F());
		this.hashColumns.put("d7_ef", getD7Ef());
		this.hashColumns.put("cre_seq", getCreSeq());
		this.hashColumns.put("show_week", getShowWeek());
		this.hashColumns.put("f2_qty", getF2Qty());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("f5_ef", getF5Ef());
		this.hashColumns.put("o2_ef", getO2Ef());
		this.hashColumns.put("show_lane", getShowLane());
		this.hashColumns.put("s4_ef", getS4Ef());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("f5_qty", getF5Qty());
		this.hashColumns.put("d4_ef", getD4Ef());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("r9_f", getR9F());
		this.hashColumns.put("wk_st_dt", getWkStDt());
		this.hashColumns.put("s4_f", getS4F());
		this.hashColumns.put("f4_ef", getF4Ef());
		this.hashColumns.put("d2_qty", getD2Qty());
		this.hashColumns.put("d5_ef", getD5Ef());
		this.hashColumns.put("d7_f", getD7F());
		this.hashColumns.put("f5_f", getF5F());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("o4_f", getO4F());
		this.hashColumns.put("o5_f", getO5F());		
		this.hashColumns.put("s2_ef", getS2Ef());
		this.hashColumns.put("a4_ef", getA4Ef());
		this.hashColumns.put("a5_ef", getA5Ef());
		this.hashColumns.put("a2_ef", getA2Ef());
		this.hashColumns.put("a4_f", getA4F());
		this.hashColumns.put("a5_f", getA5F());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("r2_qty", getR2Qty());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("r5_f", getR5F());
		this.hashColumns.put("f2_ef", getF2Ef());
		this.hashColumns.put("r5_qty", getR5Qty());
		this.hashColumns.put("r2_ef", getR2Ef());
		this.hashColumns.put("f2_f", getF2F());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("f4_qty", getF4Qty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("r9_ef", "r9Ef");
		this.hashFields.put("etb", "etb");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("d2_f", "d2F");
		this.hashFields.put("s2_qty", "s2Qty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s2_f", "s2F");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("etb_day", "etbDay");
		this.hashFields.put("show_vvd", "showVvd");
		this.hashFields.put("r5_ef", "r5Ef");
		this.hashFields.put("r2_f", "r2F");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("wk_end_dt", "wkEndDt");
		this.hashFields.put("o4_qty", "o4Qty");
		this.hashFields.put("o5_qty", "o5Qty");		
		this.hashFields.put("d5_f", "d5F");
		this.hashFields.put("a2_f", "a2F");
		this.hashFields.put("a4_qty", "a4Qty");
		this.hashFields.put("a5_qty", "a5Qty");
		this.hashFields.put("o2_f", "o2F");
		this.hashFields.put("a2_qty", "a2Qty");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("d7_qty", "d7Qty");
		this.hashFields.put("s4_qty", "s4Qty");
		this.hashFields.put("d2_ef", "d2Ef");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("o2_qty", "o2Qty");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("o4_ef", "o4Ef");
		this.hashFields.put("o5_ef", "o5Ef");		
		this.hashFields.put("d4_qty", "d4Qty");
		this.hashFields.put("r9_qty", "r9Qty");
		this.hashFields.put("sts", "sts");
		this.hashFields.put("bsa", "bsa");
		this.hashFields.put("eqlf", "eqlf");
		this.hashFields.put("d5_qty", "d5Qty");
		this.hashFields.put("f4_f", "f4F");
		this.hashFields.put("yard", "yard");
		this.hashFields.put("d4_f", "d4F");
		this.hashFields.put("d7_ef", "d7Ef");
		this.hashFields.put("cre_seq", "creSeq");
		this.hashFields.put("show_week", "showWeek");
		this.hashFields.put("f2_qty", "f2Qty");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("f5_ef", "f5Ef");
		this.hashFields.put("o2_ef", "o2Ef");
		this.hashFields.put("show_lane", "showLane");
		this.hashFields.put("s4_ef", "s4Ef");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("f5_qty", "f5Qty");
		this.hashFields.put("d4_ef", "d4Ef");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("r9_f", "r9F");
		this.hashFields.put("wk_st_dt", "wkStDt");
		this.hashFields.put("s4_f", "s4F");
		this.hashFields.put("f4_ef", "f4Ef");
		this.hashFields.put("d2_qty", "d2Qty");
		this.hashFields.put("d5_ef", "d5Ef");
		this.hashFields.put("d7_f", "d7F");
		this.hashFields.put("f5_f", "f5F");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("o4_f", "o4F");
		this.hashFields.put("o5_f", "o5F");		
		this.hashFields.put("s2_ef", "s2Ef");
		this.hashFields.put("a4_ef", "a4Ef");
		this.hashFields.put("a5_ef", "a5Ef");
		this.hashFields.put("a2_ef", "a2Ef");
		this.hashFields.put("a4_f", "a4F");
		this.hashFields.put("a5_f", "a5F");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("r2_qty", "r2Qty");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("r5_f", "r5F");
		this.hashFields.put("f2_ef", "f2Ef");
		this.hashFields.put("r5_qty", "r5Qty");
		this.hashFields.put("r2_ef", "r2Ef");
		this.hashFields.put("f2_f", "f2F");
		this.hashFields.put("week", "week");
		this.hashFields.put("f4_qty", "f4Qty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return r9Ef
	 */
	public String getR9Ef() {
		return this.r9Ef;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return d2F
	 */
	public String getD2F() {
		return this.d2F;
	}
	
	/**
	 * Column Info
	 * @return s2Qty
	 */
	public String getS2Qty() {
		return this.s2Qty;
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
	 * @return s2F
	 */
	public String getS2F() {
		return this.s2F;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return etbDay
	 */
	public String getEtbDay() {
		return this.etbDay;
	}
	
	/**
	 * Column Info
	 * @return showVvd
	 */
	public String getShowVvd() {
		return this.showVvd;
	}
	
	/**
	 * Column Info
	 * @return r5Ef
	 */
	public String getR5Ef() {
		return this.r5Ef;
	}
	
	/**
	 * Column Info
	 * @return r2F
	 */
	public String getR2F() {
		return this.r2F;
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
	 * @return wkEndDt
	 */
	public String getWkEndDt() {
		return this.wkEndDt;
	}
	
	/**
	 * Column Info
	 * @return o4Qty
	 */
	public String getO4Qty() {
		return this.o4Qty;
	}
	
	/**
	 * Column Info
	 * @return d5F
	 */
	public String getD5F() {
		return this.d5F;
	}
	
	/**
	 * Column Info
	 * @return a2F
	 */
	public String getA2F() {
		return this.a2F;
	}
	
	/**
	 * Column Info
	 * @return a4Qty
	 */
	public String getA4Qty() {
		return this.a4Qty;
	}
	
	/**
	 * Column Info
	 * @return o2F
	 */
	public String getO2F() {
		return this.o2F;
	}
	
	/**
	 * Column Info
	 * @return a2Qty
	 */
	public String getA2Qty() {
		return this.a2Qty;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return d7Qty
	 */
	public String getD7Qty() {
		return this.d7Qty;
	}
	
	/**
	 * Column Info
	 * @return s4Qty
	 */
	public String getS4Qty() {
		return this.s4Qty;
	}
	
	/**
	 * Column Info
	 * @return d2Ef
	 */
	public String getD2Ef() {
		return this.d2Ef;
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
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return o2Qty
	 */
	public String getO2Qty() {
		return this.o2Qty;
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
	 * @return o4Ef
	 */
	public String getO4Ef() {
		return this.o4Ef;
	}
	
	/**
	 * Column Info
	 * @return d4Qty
	 */
	public String getD4Qty() {
		return this.d4Qty;
	}
	
	/**
	 * Column Info
	 * @return r9Qty
	 */
	public String getR9Qty() {
		return this.r9Qty;
	}
	
	/**
	 * Column Info
	 * @return sts
	 */
	public String getSts() {
		return this.sts;
	}
	
	/**
	 * Column Info
	 * @return bsa
	 */
	public String getBsa() {
		return this.bsa;
	}
	
	/**
	 * Column Info
	 * @return eqlf
	 */
	public String getEqlf() {
		return this.eqlf;
	}
	
	/**
	 * Column Info
	 * @return d5Qty
	 */
	public String getD5Qty() {
		return this.d5Qty;
	}
	
	/**
	 * Column Info
	 * @return f4F
	 */
	public String getF4F() {
		return this.f4F;
	}
	
	/**
	 * Column Info
	 * @return yard
	 */
	public String getYard() {
		return this.yard;
	}
	
	/**
	 * Column Info
	 * @return d4F
	 */
	public String getD4F() {
		return this.d4F;
	}
	
	/**
	 * Column Info
	 * @return d7Ef
	 */
	public String getD7Ef() {
		return this.d7Ef;
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
	 * @return showWeek
	 */
	public String getShowWeek() {
		return this.showWeek;
	}
	
	/**
	 * Column Info
	 * @return f2Qty
	 */
	public String getF2Qty() {
		return this.f2Qty;
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
	 * @return f5Ef
	 */
	public String getF5Ef() {
		return this.f5Ef;
	}
	
	/**
	 * Column Info
	 * @return o2Ef
	 */
	public String getO2Ef() {
		return this.o2Ef;
	}
	
	/**
	 * Column Info
	 * @return showLane
	 */
	public String getShowLane() {
		return this.showLane;
	}
	
	/**
	 * Column Info
	 * @return s4Ef
	 */
	public String getS4Ef() {
		return this.s4Ef;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return f5Qty
	 */
	public String getF5Qty() {
		return this.f5Qty;
	}
	
	/**
	 * Column Info
	 * @return d4Ef
	 */
	public String getD4Ef() {
		return this.d4Ef;
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
	 * @return r9F
	 */
	public String getR9F() {
		return this.r9F;
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
	 * @return s4F
	 */
	public String getS4F() {
		return this.s4F;
	}
	
	/**
	 * Column Info
	 * @return f4Ef
	 */
	public String getF4Ef() {
		return this.f4Ef;
	}
	
	/**
	 * Column Info
	 * @return d2Qty
	 */
	public String getD2Qty() {
		return this.d2Qty;
	}
	
	/**
	 * Column Info
	 * @return d5Ef
	 */
	public String getD5Ef() {
		return this.d5Ef;
	}
	
	/**
	 * Column Info
	 * @return d7F
	 */
	public String getD7F() {
		return this.d7F;
	}
	
	/**
	 * Column Info
	 * @return f5F
	 */
	public String getF5F() {
		return this.f5F;
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
	 * @return o4F
	 */
	public String getO4F() {
		return this.o4F;
	}
	
	/**
	 * Column Info
	 * @return s2Ef
	 */
	public String getS2Ef() {
		return this.s2Ef;
	}
	
	/**
	 * Column Info
	 * @return a4Ef
	 */
	public String getA4Ef() {
		return this.a4Ef;
	}
	
	/**
	 * Column Info
	 * @return a2Ef
	 */
	public String getA2Ef() {
		return this.a2Ef;
	}
	
	/**
	 * Column Info
	 * @return a4F
	 */
	public String getA4F() {
		return this.a4F;
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
	 * @return r2Qty
	 */
	public String getR2Qty() {
		return this.r2Qty;
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
	 * @return r5F
	 */
	public String getR5F() {
		return this.r5F;
	}
	
	/**
	 * Column Info
	 * @return f2Ef
	 */
	public String getF2Ef() {
		return this.f2Ef;
	}
	
	/**
	 * Column Info
	 * @return r5Qty
	 */
	public String getR5Qty() {
		return this.r5Qty;
	}
	
	/**
	 * Column Info
	 * @return r2Ef
	 */
	public String getR2Ef() {
		return this.r2Ef;
	}
	
	/**
	 * Column Info
	 * @return f2F
	 */
	public String getF2F() {
		return this.f2F;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
	}
	
	/**
	 * Column Info
	 * @return f4Qty
	 */
	public String getF4Qty() {
		return this.f4Qty;
	}
	

	/**
	 * Column Info
	 * @param r9Ef
	 */
	public void setR9Ef(String r9Ef) {
		this.r9Ef = r9Ef;
	}
	
	/**
	 * Column Info
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param d2F
	 */
	public void setD2F(String d2F) {
		this.d2F = d2F;
	}
	
	/**
	 * Column Info
	 * @param s2Qty
	 */
	public void setS2Qty(String s2Qty) {
		this.s2Qty = s2Qty;
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
	 * @param s2F
	 */
	public void setS2F(String s2F) {
		this.s2F = s2F;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param etbDay
	 */
	public void setEtbDay(String etbDay) {
		this.etbDay = etbDay;
	}
	
	/**
	 * Column Info
	 * @param showVvd
	 */
	public void setShowVvd(String showVvd) {
		this.showVvd = showVvd;
	}
	
	/**
	 * Column Info
	 * @param r5Ef
	 */
	public void setR5Ef(String r5Ef) {
		this.r5Ef = r5Ef;
	}
	
	/**
	 * Column Info
	 * @param r2F
	 */
	public void setR2F(String r2F) {
		this.r2F = r2F;
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
	 * @param wkEndDt
	 */
	public void setWkEndDt(String wkEndDt) {
		this.wkEndDt = wkEndDt;
	}
	
	/**
	 * Column Info
	 * @param o4Qty
	 */
	public void setO4Qty(String o4Qty) {
		this.o4Qty = o4Qty;
	}
	
	/**
	 * Column Info
	 * @param d5F
	 */
	public void setD5F(String d5F) {
		this.d5F = d5F;
	}
	
	/**
	 * Column Info
	 * @param a2F
	 */
	public void setA2F(String a2F) {
		this.a2F = a2F;
	}
	
	/**
	 * Column Info
	 * @param a4Qty
	 */
	public void setA4Qty(String a4Qty) {
		this.a4Qty = a4Qty;
	}
	
	/**
	 * Column Info
	 * @param o2F
	 */
	public void setO2F(String o2F) {
		this.o2F = o2F;
	}
	
	/**
	 * Column Info
	 * @param a2Qty
	 */
	public void setA2Qty(String a2Qty) {
		this.a2Qty = a2Qty;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param d7Qty
	 */
	public void setD7Qty(String d7Qty) {
		this.d7Qty = d7Qty;
	}
	
	/**
	 * Column Info
	 * @param s4Qty
	 */
	public void setS4Qty(String s4Qty) {
		this.s4Qty = s4Qty;
	}
	
	/**
	 * Column Info
	 * @param d2Ef
	 */
	public void setD2Ef(String d2Ef) {
		this.d2Ef = d2Ef;
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
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param o2Qty
	 */
	public void setO2Qty(String o2Qty) {
		this.o2Qty = o2Qty;
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
	 * @param o4Ef
	 */
	public void setO4Ef(String o4Ef) {
		this.o4Ef = o4Ef;
	}
	
	/**
	 * Column Info
	 * @param d4Qty
	 */
	public void setD4Qty(String d4Qty) {
		this.d4Qty = d4Qty;
	}
	
	/**
	 * Column Info
	 * @param r9Qty
	 */
	public void setR9Qty(String r9Qty) {
		this.r9Qty = r9Qty;
	}
	
	/**
	 * Column Info
	 * @param sts
	 */
	public void setSts(String sts) {
		this.sts = sts;
	}
	
	/**
	 * Column Info
	 * @param bsa
	 */
	public void setBsa(String bsa) {
		this.bsa = bsa;
	}
	
	/**
	 * Column Info
	 * @param eqlf
	 */
	public void setEqlf(String eqlf) {
		this.eqlf = eqlf;
	}
	
	/**
	 * Column Info
	 * @param d5Qty
	 */
	public void setD5Qty(String d5Qty) {
		this.d5Qty = d5Qty;
	}
	
	/**
	 * Column Info
	 * @param f4F
	 */
	public void setF4F(String f4F) {
		this.f4F = f4F;
	}
	
	/**
	 * Column Info
	 * @param yard
	 */
	public void setYard(String yard) {
		this.yard = yard;
	}
	
	/**
	 * Column Info
	 * @param d4F
	 */
	public void setD4F(String d4F) {
		this.d4F = d4F;
	}
	
	/**
	 * Column Info
	 * @param d7Ef
	 */
	public void setD7Ef(String d7Ef) {
		this.d7Ef = d7Ef;
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
	 * @param showWeek
	 */
	public void setShowWeek(String showWeek) {
		this.showWeek = showWeek;
	}
	
	/**
	 * Column Info
	 * @param f2Qty
	 */
	public void setF2Qty(String f2Qty) {
		this.f2Qty = f2Qty;
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
	 * @param f5Ef
	 */
	public void setF5Ef(String f5Ef) {
		this.f5Ef = f5Ef;
	}
	
	/**
	 * Column Info
	 * @param o2Ef
	 */
	public void setO2Ef(String o2Ef) {
		this.o2Ef = o2Ef;
	}
	
	/**
	 * Column Info
	 * @param showLane
	 */
	public void setShowLane(String showLane) {
		this.showLane = showLane;
	}
	
	/**
	 * Column Info
	 * @param s4Ef
	 */
	public void setS4Ef(String s4Ef) {
		this.s4Ef = s4Ef;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param f5Qty
	 */
	public void setF5Qty(String f5Qty) {
		this.f5Qty = f5Qty;
	}
	
	/**
	 * Column Info
	 * @param d4Ef
	 */
	public void setD4Ef(String d4Ef) {
		this.d4Ef = d4Ef;
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
	 * @param r9F
	 */
	public void setR9F(String r9F) {
		this.r9F = r9F;
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
	 * @param s4F
	 */
	public void setS4F(String s4F) {
		this.s4F = s4F;
	}
	
	/**
	 * Column Info
	 * @param f4Ef
	 */
	public void setF4Ef(String f4Ef) {
		this.f4Ef = f4Ef;
	}
	
	/**
	 * Column Info
	 * @param d2Qty
	 */
	public void setD2Qty(String d2Qty) {
		this.d2Qty = d2Qty;
	}
	
	/**
	 * Column Info
	 * @param d5Ef
	 */
	public void setD5Ef(String d5Ef) {
		this.d5Ef = d5Ef;
	}
	
	/**
	 * Column Info
	 * @param d7F
	 */
	public void setD7F(String d7F) {
		this.d7F = d7F;
	}
	
	/**
	 * Column Info
	 * @param f5F
	 */
	public void setF5F(String f5F) {
		this.f5F = f5F;
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
	 * @param o4F
	 */
	public void setO4F(String o4F) {
		this.o4F = o4F;
	}
	
	/**
	 * Column Info
	 * @param s2Ef
	 */
	public void setS2Ef(String s2Ef) {
		this.s2Ef = s2Ef;
	}
	
	/**
	 * Column Info
	 * @param a4Ef
	 */
	public void setA4Ef(String a4Ef) {
		this.a4Ef = a4Ef;
	}
	
	/**
	 * Column Info
	 * @param a2Ef
	 */
	public void setA2Ef(String a2Ef) {
		this.a2Ef = a2Ef;
	}
	
	/**
	 * Column Info
	 * @param a4F
	 */
	public void setA4F(String a4F) {
		this.a4F = a4F;
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
	 * @param r2Qty
	 */
	public void setR2Qty(String r2Qty) {
		this.r2Qty = r2Qty;
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
	 * @param r5F
	 */
	public void setR5F(String r5F) {
		this.r5F = r5F;
	}
	
	/**
	 * Column Info
	 * @param f2Ef
	 */
	public void setF2Ef(String f2Ef) {
		this.f2Ef = f2Ef;
	}
	
	/**
	 * Column Info
	 * @param r5Qty
	 */
	public void setR5Qty(String r5Qty) {
		this.r5Qty = r5Qty;
	}
	
	/**
	 * Column Info
	 * @param r2Ef
	 */
	public void setR2Ef(String r2Ef) {
		this.r2Ef = r2Ef;
	}
	
	/**
	 * Column Info
	 * @param f2F
	 */
	public void setF2F(String f2F) {
		this.f2F = f2F;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	
	/**
	 * Column Info
	 * @param f4Qty
	 */
	public void setF4Qty(String f4Qty) {
		this.f4Qty = f4Qty;
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
		setR9Ef(JSPUtil.getParameter(request, prefix + "r9_ef", ""));
		setEtb(JSPUtil.getParameter(request, prefix + "etb", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setD2F(JSPUtil.getParameter(request, prefix + "d2_f", ""));
		setS2Qty(JSPUtil.getParameter(request, prefix + "s2_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setS2F(JSPUtil.getParameter(request, prefix + "s2_f", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setEtbDay(JSPUtil.getParameter(request, prefix + "etb_day", ""));
		setShowVvd(JSPUtil.getParameter(request, prefix + "show_vvd", ""));
		setR5Ef(JSPUtil.getParameter(request, prefix + "r5_ef", ""));
		setR2F(JSPUtil.getParameter(request, prefix + "r2_f", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setWkEndDt(JSPUtil.getParameter(request, prefix + "wk_end_dt", ""));
		setO4Qty(JSPUtil.getParameter(request, prefix + "o4_qty", ""));
		setO5Qty(JSPUtil.getParameter(request, prefix + "o5_qty", ""));		
		setD5F(JSPUtil.getParameter(request, prefix + "d5_f", ""));
		setA2F(JSPUtil.getParameter(request, prefix + "a2_f", ""));
		setA4Qty(JSPUtil.getParameter(request, prefix + "a4_qty", ""));
		setA5Qty(JSPUtil.getParameter(request, prefix + "a5_qty", ""));
		setO2F(JSPUtil.getParameter(request, prefix + "o2_f", ""));
		setA2Qty(JSPUtil.getParameter(request, prefix + "a2_qty", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setD7Qty(JSPUtil.getParameter(request, prefix + "d7_qty", ""));
		setS4Qty(JSPUtil.getParameter(request, prefix + "s4_qty", ""));
		setD2Ef(JSPUtil.getParameter(request, prefix + "d2_ef", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTpsz(JSPUtil.getParameter(request, prefix + "tpsz", ""));
		setO2Qty(JSPUtil.getParameter(request, prefix + "o2_qty", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setO4Ef(JSPUtil.getParameter(request, prefix + "o4_ef", ""));
		setO5Ef(JSPUtil.getParameter(request, prefix + "o5_ef", ""));		
		setD4Qty(JSPUtil.getParameter(request, prefix + "d4_qty", ""));
		setR9Qty(JSPUtil.getParameter(request, prefix + "r9_qty", ""));
		setSts(JSPUtil.getParameter(request, prefix + "sts", ""));
		setBsa(JSPUtil.getParameter(request, prefix + "bsa", ""));
		setEqlf(JSPUtil.getParameter(request, prefix + "eqlf", ""));
		setD5Qty(JSPUtil.getParameter(request, prefix + "d5_qty", ""));
		setF4F(JSPUtil.getParameter(request, prefix + "f4_f", ""));
		setYard(JSPUtil.getParameter(request, prefix + "yard", ""));
		setD4F(JSPUtil.getParameter(request, prefix + "d4_f", ""));
		setD7Ef(JSPUtil.getParameter(request, prefix + "d7_ef", ""));
		setCreSeq(JSPUtil.getParameter(request, prefix + "cre_seq", ""));
		setShowWeek(JSPUtil.getParameter(request, prefix + "show_week", ""));
		setF2Qty(JSPUtil.getParameter(request, prefix + "f2_qty", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setF5Ef(JSPUtil.getParameter(request, prefix + "f5_ef", ""));
		setO2Ef(JSPUtil.getParameter(request, prefix + "o2_ef", ""));
		setShowLane(JSPUtil.getParameter(request, prefix + "show_lane", ""));
		setS4Ef(JSPUtil.getParameter(request, prefix + "s4_ef", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setF5Qty(JSPUtil.getParameter(request, prefix + "f5_qty", ""));
		setD4Ef(JSPUtil.getParameter(request, prefix + "d4_ef", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setR9F(JSPUtil.getParameter(request, prefix + "r9_f", ""));
		setWkStDt(JSPUtil.getParameter(request, prefix + "wk_st_dt", ""));
		setS4F(JSPUtil.getParameter(request, prefix + "s4_f", ""));
		setF4Ef(JSPUtil.getParameter(request, prefix + "f4_ef", ""));
		setD2Qty(JSPUtil.getParameter(request, prefix + "d2_qty", ""));
		setD5Ef(JSPUtil.getParameter(request, prefix + "d5_ef", ""));
		setD7F(JSPUtil.getParameter(request, prefix + "d7_f", ""));
		setF5F(JSPUtil.getParameter(request, prefix + "f5_f", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setO4F(JSPUtil.getParameter(request, prefix + "o4_f", ""));
		setO5F(JSPUtil.getParameter(request, prefix + "o5_f", ""));		
		setS2Ef(JSPUtil.getParameter(request, prefix + "s2_ef", ""));
		setA4Ef(JSPUtil.getParameter(request, prefix + "a4_ef", ""));
		setA5Ef(JSPUtil.getParameter(request, prefix + "a5_ef", ""));
		setA2Ef(JSPUtil.getParameter(request, prefix + "a2_ef", ""));
		setA4F(JSPUtil.getParameter(request, prefix + "a4_f", ""));
		setA5F(JSPUtil.getParameter(request, prefix + "a5_f", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setR2Qty(JSPUtil.getParameter(request, prefix + "r2_qty", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setR5F(JSPUtil.getParameter(request, prefix + "r5_f", ""));
		setF2Ef(JSPUtil.getParameter(request, prefix + "f2_ef", ""));
		setR5Qty(JSPUtil.getParameter(request, prefix + "r5_qty", ""));
		setR2Ef(JSPUtil.getParameter(request, prefix + "r2_ef", ""));
		setF2F(JSPUtil.getParameter(request, prefix + "f2_f", ""));
		setWeek(JSPUtil.getParameter(request, prefix + "week", ""));
		setF4Qty(JSPUtil.getParameter(request, prefix + "f4_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PlannedRepoInVO[]
	 */
	public PlannedRepoInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PlannedRepoInVO[]
	 */
	public PlannedRepoInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PlannedRepoInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] r9Ef = (JSPUtil.getParameter(request, prefix	+ "r9_ef", length));
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] d2F = (JSPUtil.getParameter(request, prefix	+ "d2_f", length));
			String[] s2Qty = (JSPUtil.getParameter(request, prefix	+ "s2_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] s2F = (JSPUtil.getParameter(request, prefix	+ "s2_f", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] etbDay = (JSPUtil.getParameter(request, prefix	+ "etb_day", length));
			String[] showVvd = (JSPUtil.getParameter(request, prefix	+ "show_vvd", length));
			String[] r5Ef = (JSPUtil.getParameter(request, prefix	+ "r5_ef", length));
			String[] r2F = (JSPUtil.getParameter(request, prefix	+ "r2_f", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] wkEndDt = (JSPUtil.getParameter(request, prefix	+ "wk_end_dt", length));
			String[] o4Qty = (JSPUtil.getParameter(request, prefix	+ "o4_qty", length));
			String[] o5Qty = (JSPUtil.getParameter(request, prefix	+ "o5_qty", length));
			String[] d5F = (JSPUtil.getParameter(request, prefix	+ "d5_f", length));
			String[] a2F = (JSPUtil.getParameter(request, prefix	+ "a2_f", length));
			String[] a4Qty = (JSPUtil.getParameter(request, prefix	+ "a4_qty", length));
			String[] a5Qty = (JSPUtil.getParameter(request, prefix	+ "a5_qty", length));
			String[] o2F = (JSPUtil.getParameter(request, prefix	+ "o2_f", length));
			String[] a2Qty = (JSPUtil.getParameter(request, prefix	+ "a2_qty", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] d7Qty = (JSPUtil.getParameter(request, prefix	+ "d7_qty", length));
			String[] s4Qty = (JSPUtil.getParameter(request, prefix	+ "s4_qty", length));
			String[] d2Ef = (JSPUtil.getParameter(request, prefix	+ "d2_ef", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] o2Qty = (JSPUtil.getParameter(request, prefix	+ "o2_qty", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] o4Ef = (JSPUtil.getParameter(request, prefix	+ "o4_ef", length));
			String[] o5Ef = (JSPUtil.getParameter(request, prefix	+ "o5_ef", length));
			String[] d4Qty = (JSPUtil.getParameter(request, prefix	+ "d4_qty", length));
			String[] r9Qty = (JSPUtil.getParameter(request, prefix	+ "r9_qty", length));
			String[] sts = (JSPUtil.getParameter(request, prefix	+ "sts", length));
			String[] bsa = (JSPUtil.getParameter(request, prefix	+ "bsa", length));
			String[] eqlf = (JSPUtil.getParameter(request, prefix	+ "eqlf", length));
			String[] d5Qty = (JSPUtil.getParameter(request, prefix	+ "d5_qty", length));
			String[] f4F = (JSPUtil.getParameter(request, prefix	+ "f4_f", length));
			String[] yard = (JSPUtil.getParameter(request, prefix	+ "yard", length));
			String[] d4F = (JSPUtil.getParameter(request, prefix	+ "d4_f", length));
			String[] d7Ef = (JSPUtil.getParameter(request, prefix	+ "d7_ef", length));
			String[] creSeq = (JSPUtil.getParameter(request, prefix	+ "cre_seq", length));
			String[] showWeek = (JSPUtil.getParameter(request, prefix	+ "show_week", length));
			String[] f2Qty = (JSPUtil.getParameter(request, prefix	+ "f2_qty", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] f5Ef = (JSPUtil.getParameter(request, prefix	+ "f5_ef", length));
			String[] o2Ef = (JSPUtil.getParameter(request, prefix	+ "o2_ef", length));
			String[] showLane = (JSPUtil.getParameter(request, prefix	+ "show_lane", length));
			String[] s4Ef = (JSPUtil.getParameter(request, prefix	+ "s4_ef", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] f5Qty = (JSPUtil.getParameter(request, prefix	+ "f5_qty", length));
			String[] d4Ef = (JSPUtil.getParameter(request, prefix	+ "d4_ef", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] r9F = (JSPUtil.getParameter(request, prefix	+ "r9_f", length));
			String[] wkStDt = (JSPUtil.getParameter(request, prefix	+ "wk_st_dt", length));
			String[] s4F = (JSPUtil.getParameter(request, prefix	+ "s4_f", length));
			String[] f4Ef = (JSPUtil.getParameter(request, prefix	+ "f4_ef", length));
			String[] d2Qty = (JSPUtil.getParameter(request, prefix	+ "d2_qty", length));
			String[] d5Ef = (JSPUtil.getParameter(request, prefix	+ "d5_ef", length));
			String[] d7F = (JSPUtil.getParameter(request, prefix	+ "d7_f", length));
			String[] f5F = (JSPUtil.getParameter(request, prefix	+ "f5_f", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] o4F = (JSPUtil.getParameter(request, prefix	+ "o4_f", length));
			String[] o5F = (JSPUtil.getParameter(request, prefix	+ "o5_f", length));
			String[] s2Ef = (JSPUtil.getParameter(request, prefix	+ "s2_ef", length));
			String[] a4Ef = (JSPUtil.getParameter(request, prefix	+ "a4_ef", length));
			String[] a5Ef = (JSPUtil.getParameter(request, prefix	+ "a5_ef", length));
			String[] a2Ef = (JSPUtil.getParameter(request, prefix	+ "a2_ef", length));
			String[] a4F = (JSPUtil.getParameter(request, prefix	+ "a4_f", length));
			String[] a5F = (JSPUtil.getParameter(request, prefix	+ "a5_f", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] r2Qty = (JSPUtil.getParameter(request, prefix	+ "r2_qty", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] r5F = (JSPUtil.getParameter(request, prefix	+ "r5_f", length));
			String[] f2Ef = (JSPUtil.getParameter(request, prefix	+ "f2_ef", length));
			String[] r5Qty = (JSPUtil.getParameter(request, prefix	+ "r5_qty", length));
			String[] r2Ef = (JSPUtil.getParameter(request, prefix	+ "r2_ef", length));
			String[] f2F = (JSPUtil.getParameter(request, prefix	+ "f2_f", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] f4Qty = (JSPUtil.getParameter(request, prefix	+ "f4_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new PlannedRepoInVO();
				if (r9Ef[i] != null)
					model.setR9Ef(r9Ef[i]);
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (d2F[i] != null)
					model.setD2F(d2F[i]);
				if (s2Qty[i] != null)
					model.setS2Qty(s2Qty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (s2F[i] != null)
					model.setS2F(s2F[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (etbDay[i] != null)
					model.setEtbDay(etbDay[i]);
				if (showVvd[i] != null)
					model.setShowVvd(showVvd[i]);
				if (r5Ef[i] != null)
					model.setR5Ef(r5Ef[i]);
				if (r2F[i] != null)
					model.setR2F(r2F[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (wkEndDt[i] != null)
					model.setWkEndDt(wkEndDt[i]);
				if (o4Qty[i] != null)
					model.setO4Qty(o4Qty[i]);
				if (o5Qty[i] != null)
					model.setO5Qty(o5Qty[i]);				
				if (d5F[i] != null)
					model.setD5F(d5F[i]);
				if (a2F[i] != null)
					model.setA2F(a2F[i]);
				if (a4Qty[i] != null)
					model.setA4Qty(a4Qty[i]);
				if (a5Qty[i] != null)
					model.setA5Qty(a5Qty[i]);
				if (o2F[i] != null)
					model.setO2F(o2F[i]);
				if (a2Qty[i] != null)
					model.setA2Qty(a2Qty[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (d7Qty[i] != null)
					model.setD7Qty(d7Qty[i]);
				if (s4Qty[i] != null)
					model.setS4Qty(s4Qty[i]);
				if (d2Ef[i] != null)
					model.setD2Ef(d2Ef[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (o2Qty[i] != null)
					model.setO2Qty(o2Qty[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (o4Ef[i] != null)
					model.setO4Ef(o4Ef[i]);
				if (o5Ef[i] != null)
					model.setO5Ef(o5Ef[i]);				
				if (d4Qty[i] != null)
					model.setD4Qty(d4Qty[i]);
				if (r9Qty[i] != null)
					model.setR9Qty(r9Qty[i]);
				if (sts[i] != null)
					model.setSts(sts[i]);
				if (bsa[i] != null)
					model.setBsa(bsa[i]);
				if (eqlf[i] != null)
					model.setEqlf(eqlf[i]);
				if (d5Qty[i] != null)
					model.setD5Qty(d5Qty[i]);
				if (f4F[i] != null)
					model.setF4F(f4F[i]);
				if (yard[i] != null)
					model.setYard(yard[i]);
				if (d4F[i] != null)
					model.setD4F(d4F[i]);
				if (d7Ef[i] != null)
					model.setD7Ef(d7Ef[i]);
				if (creSeq[i] != null)
					model.setCreSeq(creSeq[i]);
				if (showWeek[i] != null)
					model.setShowWeek(showWeek[i]);
				if (f2Qty[i] != null)
					model.setF2Qty(f2Qty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (f5Ef[i] != null)
					model.setF5Ef(f5Ef[i]);
				if (o2Ef[i] != null)
					model.setO2Ef(o2Ef[i]);
				if (showLane[i] != null)
					model.setShowLane(showLane[i]);
				if (s4Ef[i] != null)
					model.setS4Ef(s4Ef[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (f5Qty[i] != null)
					model.setF5Qty(f5Qty[i]);
				if (d4Ef[i] != null)
					model.setD4Ef(d4Ef[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (r9F[i] != null)
					model.setR9F(r9F[i]);
				if (wkStDt[i] != null)
					model.setWkStDt(wkStDt[i]);
				if (s4F[i] != null)
					model.setS4F(s4F[i]);
				if (f4Ef[i] != null)
					model.setF4Ef(f4Ef[i]);
				if (d2Qty[i] != null)
					model.setD2Qty(d2Qty[i]);
				if (d5Ef[i] != null)
					model.setD5Ef(d5Ef[i]);
				if (d7F[i] != null)
					model.setD7F(d7F[i]);
				if (f5F[i] != null)
					model.setF5F(f5F[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (o4F[i] != null)
					model.setO4F(o4F[i]);
				if (o5F[i] != null)
					model.setO5F(o5F[i]);				
				if (s2Ef[i] != null)
					model.setS2Ef(s2Ef[i]);
				if (a4Ef[i] != null)
					model.setA4Ef(a4Ef[i]);
				if (a5Ef[i] != null)
					model.setA5Ef(a5Ef[i]);
				if (a2Ef[i] != null)
					model.setA2Ef(a2Ef[i]);
				if (a4F[i] != null)
					model.setA4F(a4F[i]);
				if (a5F[i] != null)
					model.setA5F(a5F[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (r2Qty[i] != null)
					model.setR2Qty(r2Qty[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (r5F[i] != null)
					model.setR5F(r5F[i]);
				if (f2Ef[i] != null)
					model.setF2Ef(f2Ef[i]);
				if (r5Qty[i] != null)
					model.setR5Qty(r5Qty[i]);
				if (r2Ef[i] != null)
					model.setR2Ef(r2Ef[i]);
				if (f2F[i] != null)
					model.setF2F(f2F[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (f4Qty[i] != null)
					model.setF4Qty(f4Qty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPlannedRepoInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PlannedRepoInVO[]
	 */
	public PlannedRepoInVO[] getPlannedRepoInVOs(){
		PlannedRepoInVO[] vos = (PlannedRepoInVO[])models.toArray(new PlannedRepoInVO[models.size()]);
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
		this.r9Ef = this.r9Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2F = this.d2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Qty = this.s2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2F = this.s2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDay = this.etbDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.showVvd = this.showVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5Ef = this.r5Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2F = this.r2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkEndDt = this.wkEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Qty = this.o4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5Qty = this.o5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5F = this.d5F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2F = this.a2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4Qty = this.a4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a5Qty = this.a5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2F = this.o2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2Qty = this.a2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Qty = this.d7Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4Qty = this.s4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Ef = this.d2Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Qty = this.o2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Ef = this.o4Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5Ef = this.o5Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Qty = this.d4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r9Qty = this.r9Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts = this.sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa = this.bsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqlf = this.eqlf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Qty = this.d5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4F = this.f4F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yard = this.yard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4F = this.d4F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Ef = this.d7Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creSeq = this.creSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.showWeek = this.showWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2Qty = this.f2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5Ef = this.f5Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Ef = this.o2Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.showLane = this.showLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4Ef = this.s4Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5Qty = this.f5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Ef = this.d4Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r9F = this.r9F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkStDt = this.wkStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4F = this.s4F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4Ef = this.f4Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Qty = this.d2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Ef = this.d5Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7F = this.d7F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5F = this.f5F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4F = this.o4F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5F = this.o5F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Ef = this.s2Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4Ef = this.a4Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a5Ef = this.a5Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2Ef = this.a2Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4F = this.a4F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a5F = this.a5F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Qty = this.r2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5F = this.r5F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2Ef = this.f2Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5Qty = this.r5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Ef = this.r2Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2F = this.f2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4Qty = this.f4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getO5Ef() {
		return o5Ef;
	}

	public void setO5Ef(String o5Ef) {
		this.o5Ef = o5Ef;
	}

	public String getO5Qty() {
		return o5Qty;
	}

	public void setO5Qty(String o5Qty) {
		this.o5Qty = o5Qty;
	}

	public String getO5F() {
		return o5F;
	}

	public void setO5F(String o5f) {
		o5F = o5f;
	}

	public String getA5Qty() {
		return a5Qty;
	}

	public void setA5Qty(String a5Qty) {
		this.a5Qty = a5Qty;
	}

	public String getA5Ef() {
		return a5Ef;
	}

	public void setA5Ef(String a5Ef) {
		this.a5Ef = a5Ef;
	}

	public String getA5F() {
		return a5F;
	}

	public void setA5F(String a5f) {
		a5F = a5f;
	}
}
