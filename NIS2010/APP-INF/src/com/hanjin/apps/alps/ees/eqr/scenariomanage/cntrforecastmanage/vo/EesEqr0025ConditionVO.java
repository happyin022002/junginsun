/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0025ConditionVO.java
*@FileTitle : EesEqr0025ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.08.10		1.0 최초 생성
*
*@LastModifyDate : 2009.08.10
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0025ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0025ConditionVO> models = new ArrayList<EesEqr0025ConditionVO>();
	
	/* Column Info */
	private String fcastDt5 = null;
	/* Column Info */
	private String fcastDt6 = null;
	/* Column Info */
	private String fcastDt7 = null;
	/* Column Info */
	private String statusType = null;
	/* Column Info */
	private String fmsfcastyr = null;
	/* Column Info */
	private String cocd = null;
	/* Column Info */
	private String fmEccCdIns = null;
	/* Column Info */
	private String fmtypeby = null;
	/* Column Info */
	private String attypeby = null;
	/* Column Info */
	private String cntrtpszcd = null;
	/* Column Info */
	private String fcastYrwkIns = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmecccd = null;
	/* Column Info */
	private String toEccCdIns = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String atefcastwk = null;
	/* Column Info */
	private String fmsfcastwk = null;
	/* Column Info */
	private String coCdIns = null;
	/* Column Info */
	private String atefcastyr = null;
	/* Column Info */
	private String fmefcastyr = null;
	/* Column Info */
	private String toecccd = null;
	/* Column Info */
	private String atecccd = null;
	/* Column Info */
	private String fmefcastwk = null;
	/* Column Info */
	private String fmtype = null;
	/* Column Info */
	private String row = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String attype = null;
	/* Column Info */
	private String atsfcastyr = null;
	/* Column Info */
	private String atsfcastwk = null;
	/* Column Info */
	private String totype = null;
	/* Column Info */
	private String fmtoat = null;
	/* Column Info */
	private String totypeby = null;
	/* Column Info */
	private String srcdata = null;
	/* Column Info */
	private String fcastDt4 = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String fcastDt3 = null;
	/* Column Info */
	private String fcastDt2 = null;
	/* Column Info */
	private String fcastDt1 = null;
	/* Column Info */
	private String day = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0025ConditionVO() {}

	public EesEqr0025ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String fmtoat, String fmtype, String fmecccd, String fmtypeby, String fmsfcastyr, String fmsfcastwk, String fmefcastyr, String fmefcastwk, String totype, String toecccd, String totypeby, String attype, String atecccd, String attypeby, String atsfcastyr, String atsfcastwk, String atefcastyr, String atefcastwk, String cntrtpszcd, String cocd, String srcdata, String day, String statusType, String fcastYrwkIns, String fmEccCdIns, String toEccCdIns, String coCdIns, String fcastDt1, String fcastDt2, String fcastDt3, String fcastDt4, String fcastDt5, String fcastDt6, String fcastDt7, String row) {
		this.fcastDt5 = fcastDt5;
		this.fcastDt6 = fcastDt6;
		this.fcastDt7 = fcastDt7;
		this.statusType = statusType;
		this.fmsfcastyr = fmsfcastyr;
		this.cocd = cocd;
		this.fmEccCdIns = fmEccCdIns;
		this.fmtypeby = fmtypeby;
		this.attypeby = attypeby;
		this.cntrtpszcd = cntrtpszcd;
		this.fcastYrwkIns = fcastYrwkIns;
		this.pagerows = pagerows;
		this.fmecccd = fmecccd;
		this.toEccCdIns = toEccCdIns;
		this.ibflag = ibflag;
		this.atefcastwk = atefcastwk;
		this.fmsfcastwk = fmsfcastwk;
		this.coCdIns = coCdIns;
		this.atefcastyr = atefcastyr;
		this.fmefcastyr = fmefcastyr;
		this.toecccd = toecccd;
		this.atecccd = atecccd;
		this.fmefcastwk = fmefcastwk;
		this.fmtype = fmtype;
		this.row = row;
		this.yyyyww = yyyyww;
		this.attype = attype;
		this.atsfcastyr = atsfcastyr;
		this.atsfcastwk = atsfcastwk;
		this.totype = totype;
		this.fmtoat = fmtoat;
		this.totypeby = totypeby;
		this.srcdata = srcdata;
		this.fcastDt4 = fcastDt4;
		this.seq = seq;
		this.fcastDt3 = fcastDt3;
		this.fcastDt2 = fcastDt2;
		this.fcastDt1 = fcastDt1;
		this.day = day;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fcast_dt5", getFcastDt5());
		this.hashColumns.put("fcast_dt6", getFcastDt6());
		this.hashColumns.put("fcast_dt7", getFcastDt7());
		this.hashColumns.put("status_type", getStatusType());
		this.hashColumns.put("fmSFcastYr", getFmsfcastyr());
		this.hashColumns.put("coCd", getCocd());
		this.hashColumns.put("fm_ecc_cd_ins", getFmEccCdIns());
		this.hashColumns.put("fmTypeBy", getFmtypeby());
		this.hashColumns.put("atTypeBy", getAttypeby());
		this.hashColumns.put("cntrTpszCd", getCntrtpszcd());
		this.hashColumns.put("fcast_yrwk_ins", getFcastYrwkIns());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fmEccCd", getFmecccd());
		this.hashColumns.put("to_ecc_cd_ins", getToEccCdIns());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("atEFcastWk", getAtefcastwk());
		this.hashColumns.put("fmSFcastWk", getFmsfcastwk());
		this.hashColumns.put("co_cd_ins", getCoCdIns());
		this.hashColumns.put("atEFcastYr", getAtefcastyr());
		this.hashColumns.put("fmEFcastYr", getFmefcastyr());
		this.hashColumns.put("toEccCd", getToecccd());
		this.hashColumns.put("atEccCd", getAtecccd());
		this.hashColumns.put("fmEFcastWk", getFmefcastwk());
		this.hashColumns.put("fmType", getFmtype());
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("atType", getAttype());
		this.hashColumns.put("atSFcastYr", getAtsfcastyr());
		this.hashColumns.put("atSFcastWk", getAtsfcastwk());
		this.hashColumns.put("toType", getTotype());
		this.hashColumns.put("fmToAt", getFmtoat());
		this.hashColumns.put("toTypeBy", getTotypeby());
		this.hashColumns.put("srcData", getSrcdata());
		this.hashColumns.put("fcast_dt4", getFcastDt4());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("fcast_dt3", getFcastDt3());
		this.hashColumns.put("fcast_dt2", getFcastDt2());
		this.hashColumns.put("fcast_dt1", getFcastDt1());
		this.hashColumns.put("day", getDay());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fcast_dt5", "fcastDt5");
		this.hashFields.put("fcast_dt6", "fcastDt6");
		this.hashFields.put("fcast_dt7", "fcastDt7");
		this.hashFields.put("status_type", "statusType");
		this.hashFields.put("fmsfcastyr", "fmsfcastyr");
		this.hashFields.put("cocd", "cocd");
		this.hashFields.put("fm_ecc_cd_ins", "fmEccCdIns");
		this.hashFields.put("fmtypeby", "fmtypeby");
		this.hashFields.put("attypeby", "attypeby");
		this.hashFields.put("cntrtpszcd", "cntrtpszcd");
		this.hashFields.put("fcast_yrwk_ins", "fcastYrwkIns");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fmecccd", "fmecccd");
		this.hashFields.put("to_ecc_cd_ins", "toEccCdIns");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("atefcastwk", "atefcastwk");
		this.hashFields.put("fmsfcastwk", "fmsfcastwk");
		this.hashFields.put("co_cd_ins", "coCdIns");
		this.hashFields.put("atefcastyr", "atefcastyr");
		this.hashFields.put("fmefcastyr", "fmefcastyr");
		this.hashFields.put("toecccd", "toecccd");
		this.hashFields.put("atecccd", "atecccd");
		this.hashFields.put("fmefcastwk", "fmefcastwk");
		this.hashFields.put("fmtype", "fmtype");
		this.hashFields.put("row", "row");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("attype", "attype");
		this.hashFields.put("atsfcastyr", "atsfcastyr");
		this.hashFields.put("atsfcastwk", "atsfcastwk");
		this.hashFields.put("totype", "totype");
		this.hashFields.put("fmtoat", "fmtoat");
		this.hashFields.put("totypeby", "totypeby");
		this.hashFields.put("srcdata", "srcdata");
		this.hashFields.put("fcast_dt4", "fcastDt4");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("fcast_dt3", "fcastDt3");
		this.hashFields.put("fcast_dt2", "fcastDt2");
		this.hashFields.put("fcast_dt1", "fcastDt1");
		this.hashFields.put("day", "day");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fcastDt5
	 */
	public String getFcastDt5() {
		return this.fcastDt5;
	}
	
	/**
	 * Column Info
	 * @return fcastDt6
	 */
	public String getFcastDt6() {
		return this.fcastDt6;
	}
	
	/**
	 * Column Info
	 * @return fcastDt7
	 */
	public String getFcastDt7() {
		return this.fcastDt7;
	}
	
	/**
	 * Column Info
	 * @return statusType
	 */
	public String getStatusType() {
		return this.statusType;
	}
	
	/**
	 * Column Info
	 * @return fmsfcastyr
	 */
	public String getFmsfcastyr() {
		return this.fmsfcastyr;
	}
	
	/**
	 * Column Info
	 * @return cocd
	 */
	public String getCocd() {
		return this.cocd;
	}
	
	/**
	 * Column Info
	 * @return fmEccCdIns
	 */
	public String getFmEccCdIns() {
		return this.fmEccCdIns;
	}
	
	/**
	 * Column Info
	 * @return fmtypeby
	 */
	public String getFmtypeby() {
		return this.fmtypeby;
	}
	
	/**
	 * Column Info
	 * @return attypeby
	 */
	public String getAttypeby() {
		return this.attypeby;
	}
	
	/**
	 * Column Info
	 * @return cntrtpszcd
	 */
	public String getCntrtpszcd() {
		return this.cntrtpszcd;
	}
	
	/**
	 * Column Info
	 * @return fcastYrwkIns
	 */
	public String getFcastYrwkIns() {
		return this.fcastYrwkIns;
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
	 * @return fmecccd
	 */
	public String getFmecccd() {
		return this.fmecccd;
	}
	
	/**
	 * Column Info
	 * @return toEccCdIns
	 */
	public String getToEccCdIns() {
		return this.toEccCdIns;
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
	 * @return atefcastwk
	 */
	public String getAtefcastwk() {
		return this.atefcastwk;
	}
	
	/**
	 * Column Info
	 * @return fmsfcastwk
	 */
	public String getFmsfcastwk() {
		return this.fmsfcastwk;
	}
	
	/**
	 * Column Info
	 * @return coCdIns
	 */
	public String getCoCdIns() {
		return this.coCdIns;
	}
	
	/**
	 * Column Info
	 * @return atefcastyr
	 */
	public String getAtefcastyr() {
		return this.atefcastyr;
	}
	
	/**
	 * Column Info
	 * @return fmefcastyr
	 */
	public String getFmefcastyr() {
		return this.fmefcastyr;
	}
	
	/**
	 * Column Info
	 * @return toecccd
	 */
	public String getToecccd() {
		return this.toecccd;
	}
	
	/**
	 * Column Info
	 * @return atecccd
	 */
	public String getAtecccd() {
		return this.atecccd;
	}
	
	/**
	 * Column Info
	 * @return fmefcastwk
	 */
	public String getFmefcastwk() {
		return this.fmefcastwk;
	}
	
	/**
	 * Column Info
	 * @return fmtype
	 */
	public String getFmtype() {
		return this.fmtype;
	}
	
	/**
	 * Column Info
	 * @return row
	 */
	public String getRow() {
		return this.row;
	}
	
	/**
	 * Column Info
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
	}
	
	/**
	 * Column Info
	 * @return attype
	 */
	public String getAttype() {
		return this.attype;
	}
	
	/**
	 * Column Info
	 * @return atsfcastyr
	 */
	public String getAtsfcastyr() {
		return this.atsfcastyr;
	}
	
	/**
	 * Column Info
	 * @return atsfcastwk
	 */
	public String getAtsfcastwk() {
		return this.atsfcastwk;
	}
	
	/**
	 * Column Info
	 * @return totype
	 */
	public String getTotype() {
		return this.totype;
	}
	
	/**
	 * Column Info
	 * @return fmtoat
	 */
	public String getFmtoat() {
		return this.fmtoat;
	}
	
	/**
	 * Column Info
	 * @return totypeby
	 */
	public String getTotypeby() {
		return this.totypeby;
	}
	
	/**
	 * Column Info
	 * @return srcdata
	 */
	public String getSrcdata() {
		return this.srcdata;
	}
	
	/**
	 * Column Info
	 * @return fcastDt4
	 */
	public String getFcastDt4() {
		return this.fcastDt4;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return fcastDt3
	 */
	public String getFcastDt3() {
		return this.fcastDt3;
	}
	
	/**
	 * Column Info
	 * @return fcastDt2
	 */
	public String getFcastDt2() {
		return this.fcastDt2;
	}
	
	/**
	 * Column Info
	 * @return fcastDt1
	 */
	public String getFcastDt1() {
		return this.fcastDt1;
	}
	
	/**
	 * Column Info
	 * @return day
	 */
	public String getDay() {
		return this.day;
	}
	

	/**
	 * Column Info
	 * @param fcastDt5
	 */
	public void setFcastDt5(String fcastDt5) {
		this.fcastDt5 = fcastDt5;
	}
	
	/**
	 * Column Info
	 * @param fcastDt6
	 */
	public void setFcastDt6(String fcastDt6) {
		this.fcastDt6 = fcastDt6;
	}
	
	/**
	 * Column Info
	 * @param fcastDt7
	 */
	public void setFcastDt7(String fcastDt7) {
		this.fcastDt7 = fcastDt7;
	}
	
	/**
	 * Column Info
	 * @param statusType
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
	/**
	 * Column Info
	 * @param fmsfcastyr
	 */
	public void setFmsfcastyr(String fmsfcastyr) {
		this.fmsfcastyr = fmsfcastyr;
	}
	
	/**
	 * Column Info
	 * @param cocd
	 */
	public void setCocd(String cocd) {
		this.cocd = cocd;
	}
	
	/**
	 * Column Info
	 * @param fmEccCdIns
	 */
	public void setFmEccCdIns(String fmEccCdIns) {
		this.fmEccCdIns = fmEccCdIns;
	}
	
	/**
	 * Column Info
	 * @param fmtypeby
	 */
	public void setFmtypeby(String fmtypeby) {
		this.fmtypeby = fmtypeby;
	}
	
	/**
	 * Column Info
	 * @param attypeby
	 */
	public void setAttypeby(String attypeby) {
		this.attypeby = attypeby;
	}
	
	/**
	 * Column Info
	 * @param cntrtpszcd
	 */
	public void setCntrtpszcd(String cntrtpszcd) {
		this.cntrtpszcd = cntrtpszcd;
	}
	
	/**
	 * Column Info
	 * @param fcastYrwkIns
	 */
	public void setFcastYrwkIns(String fcastYrwkIns) {
		this.fcastYrwkIns = fcastYrwkIns;
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
	 * @param fmecccd
	 */
	public void setFmecccd(String fmecccd) {
		this.fmecccd = fmecccd;
	}
	
	/**
	 * Column Info
	 * @param toEccCdIns
	 */
	public void setToEccCdIns(String toEccCdIns) {
		this.toEccCdIns = toEccCdIns;
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
	 * @param atefcastwk
	 */
	public void setAtefcastwk(String atefcastwk) {
		this.atefcastwk = atefcastwk;
	}
	
	/**
	 * Column Info
	 * @param fmsfcastwk
	 */
	public void setFmsfcastwk(String fmsfcastwk) {
		this.fmsfcastwk = fmsfcastwk;
	}
	
	/**
	 * Column Info
	 * @param coCdIns
	 */
	public void setCoCdIns(String coCdIns) {
		this.coCdIns = coCdIns;
	}
	
	/**
	 * Column Info
	 * @param atefcastyr
	 */
	public void setAtefcastyr(String atefcastyr) {
		this.atefcastyr = atefcastyr;
	}
	
	/**
	 * Column Info
	 * @param fmefcastyr
	 */
	public void setFmefcastyr(String fmefcastyr) {
		this.fmefcastyr = fmefcastyr;
	}
	
	/**
	 * Column Info
	 * @param toecccd
	 */
	public void setToecccd(String toecccd) {
		this.toecccd = toecccd;
	}
	
	/**
	 * Column Info
	 * @param atecccd
	 */
	public void setAtecccd(String atecccd) {
		this.atecccd = atecccd;
	}
	
	/**
	 * Column Info
	 * @param fmefcastwk
	 */
	public void setFmefcastwk(String fmefcastwk) {
		this.fmefcastwk = fmefcastwk;
	}
	
	/**
	 * Column Info
	 * @param fmtype
	 */
	public void setFmtype(String fmtype) {
		this.fmtype = fmtype;
	}
	
	/**
	 * Column Info
	 * @param row
	 */
	public void setRow(String row) {
		this.row = row;
	}
	
	/**
	 * Column Info
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}
	
	/**
	 * Column Info
	 * @param attype
	 */
	public void setAttype(String attype) {
		this.attype = attype;
	}
	
	/**
	 * Column Info
	 * @param atsfcastyr
	 */
	public void setAtsfcastyr(String atsfcastyr) {
		this.atsfcastyr = atsfcastyr;
	}
	
	/**
	 * Column Info
	 * @param atsfcastwk
	 */
	public void setAtsfcastwk(String atsfcastwk) {
		this.atsfcastwk = atsfcastwk;
	}
	
	/**
	 * Column Info
	 * @param totype
	 */
	public void setTotype(String totype) {
		this.totype = totype;
	}
	
	/**
	 * Column Info
	 * @param fmtoat
	 */
	public void setFmtoat(String fmtoat) {
		this.fmtoat = fmtoat;
	}
	
	/**
	 * Column Info
	 * @param totypeby
	 */
	public void setTotypeby(String totypeby) {
		this.totypeby = totypeby;
	}
	
	/**
	 * Column Info
	 * @param srcdata
	 */
	public void setSrcdata(String srcdata) {
		this.srcdata = srcdata;
	}
	
	/**
	 * Column Info
	 * @param fcastDt4
	 */
	public void setFcastDt4(String fcastDt4) {
		this.fcastDt4 = fcastDt4;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param fcastDt3
	 */
	public void setFcastDt3(String fcastDt3) {
		this.fcastDt3 = fcastDt3;
	}
	
	/**
	 * Column Info
	 * @param fcastDt2
	 */
	public void setFcastDt2(String fcastDt2) {
		this.fcastDt2 = fcastDt2;
	}
	
	/**
	 * Column Info
	 * @param fcastDt1
	 */
	public void setFcastDt1(String fcastDt1) {
		this.fcastDt1 = fcastDt1;
	}
	
	/**
	 * Column Info
	 * @param day
	 */
	public void setDay(String day) {
		this.day = day;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFcastDt5(JSPUtil.getParameter(request, "fcast_dt5", ""));
		setFcastDt6(JSPUtil.getParameter(request, "fcast_dt6", ""));
		setFcastDt7(JSPUtil.getParameter(request, "fcast_dt7", ""));
		setStatusType(JSPUtil.getParameter(request, "status_type", ""));
		setFmsfcastyr(JSPUtil.getParameter(request, "fmSFcastYr", ""));
		setCocd(JSPUtil.getParameter(request, "coCd", ""));
		setFmEccCdIns(JSPUtil.getParameter(request, "fm_ecc_cd_ins", ""));
		setFmtypeby(JSPUtil.getParameter(request, "fmTypeBy", ""));
		setAttypeby(JSPUtil.getParameter(request, "atTypeBy", ""));
		setCntrtpszcd(JSPUtil.getParameter(request, "cntrTpszCd", ""));
		setFcastYrwkIns(JSPUtil.getParameter(request, "fcast_yrwk_ins", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFmecccd(JSPUtil.getParameter(request, "fmEccCd", ""));
		setToEccCdIns(JSPUtil.getParameter(request, "to_ecc_cd_ins", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAtefcastwk(JSPUtil.getParameter(request, "atEFcastWk", ""));
		setFmsfcastwk(JSPUtil.getParameter(request, "fmSFcastWk", ""));
		setCoCdIns(JSPUtil.getParameter(request, "co_cd_ins", ""));
		setAtefcastyr(JSPUtil.getParameter(request, "atEFcastYr", ""));
		setFmefcastyr(JSPUtil.getParameter(request, "fmEFcastYr", ""));
		setToecccd(JSPUtil.getParameter(request, "toEccCd", ""));
		setAtecccd(JSPUtil.getParameter(request, "atEccCd", ""));
		setFmefcastwk(JSPUtil.getParameter(request, "fmEFcastWk", ""));
		setFmtype(JSPUtil.getParameter(request, "fmType", ""));
		setRow(JSPUtil.getParameter(request, "row", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setAttype(JSPUtil.getParameter(request, "atType", ""));
		setAtsfcastyr(JSPUtil.getParameter(request, "atSFcastYr", ""));
		setAtsfcastwk(JSPUtil.getParameter(request, "atSFcastWk", ""));
		setTotype(JSPUtil.getParameter(request, "toType", ""));
		setFmtoat(JSPUtil.getParameter(request, "fmToAt", ""));
		setTotypeby(JSPUtil.getParameter(request, "toTypeBy", ""));
		setSrcdata(JSPUtil.getParameter(request, "srcData", ""));
		setFcastDt4(JSPUtil.getParameter(request, "fcast_dt4", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setFcastDt3(JSPUtil.getParameter(request, "fcast_dt3", ""));
		setFcastDt2(JSPUtil.getParameter(request, "fcast_dt2", ""));
		setFcastDt1(JSPUtil.getParameter(request, "fcast_dt1", ""));
		setDay(JSPUtil.getParameter(request, "day", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0025ConditionVO[]
	 */
	public EesEqr0025ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0025ConditionVO[]
	 */
	public EesEqr0025ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0025ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fcastDt5 = (JSPUtil.getParameter(request, prefix	+ "fcast_dt5", length));
			String[] fcastDt6 = (JSPUtil.getParameter(request, prefix	+ "fcast_dt6", length));
			String[] fcastDt7 = (JSPUtil.getParameter(request, prefix	+ "fcast_dt7", length));
			String[] statusType = (JSPUtil.getParameter(request, prefix	+ "status_type", length));
			String[] fmsfcastyr = (JSPUtil.getParameter(request, prefix	+ "fmsfcastyr", length));
			String[] cocd = (JSPUtil.getParameter(request, prefix	+ "cocd", length));
			String[] fmEccCdIns = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cd_ins", length));
			String[] fmtypeby = (JSPUtil.getParameter(request, prefix	+ "fmtypeby", length));
			String[] attypeby = (JSPUtil.getParameter(request, prefix	+ "attypeby", length));
			String[] cntrtpszcd = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd", length));
			String[] fcastYrwkIns = (JSPUtil.getParameter(request, prefix	+ "fcast_yrwk_ins", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmecccd = (JSPUtil.getParameter(request, prefix	+ "fmecccd", length));
			String[] toEccCdIns = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cd_ins", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] atefcastwk = (JSPUtil.getParameter(request, prefix	+ "atefcastwk", length));
			String[] fmsfcastwk = (JSPUtil.getParameter(request, prefix	+ "fmsfcastwk", length));
			String[] coCdIns = (JSPUtil.getParameter(request, prefix	+ "co_cd_ins", length));
			String[] atefcastyr = (JSPUtil.getParameter(request, prefix	+ "atefcastyr", length));
			String[] fmefcastyr = (JSPUtil.getParameter(request, prefix	+ "fmefcastyr", length));
			String[] toecccd = (JSPUtil.getParameter(request, prefix	+ "toecccd", length));
			String[] atecccd = (JSPUtil.getParameter(request, prefix	+ "atecccd", length));
			String[] fmefcastwk = (JSPUtil.getParameter(request, prefix	+ "fmefcastwk", length));
			String[] fmtype = (JSPUtil.getParameter(request, prefix	+ "fmtype", length));
			String[] row = (JSPUtil.getParameter(request, prefix	+ "row", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] attype = (JSPUtil.getParameter(request, prefix	+ "attype", length));
			String[] atsfcastyr = (JSPUtil.getParameter(request, prefix	+ "atsfcastyr", length));
			String[] atsfcastwk = (JSPUtil.getParameter(request, prefix	+ "atsfcastwk", length));
			String[] totype = (JSPUtil.getParameter(request, prefix	+ "totype", length));
			String[] fmtoat = (JSPUtil.getParameter(request, prefix	+ "fmtoat", length));
			String[] totypeby = (JSPUtil.getParameter(request, prefix	+ "totypeby", length));
			String[] srcdata = (JSPUtil.getParameter(request, prefix	+ "srcdata", length));
			String[] fcastDt4 = (JSPUtil.getParameter(request, prefix	+ "fcast_dt4", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] fcastDt3 = (JSPUtil.getParameter(request, prefix	+ "fcast_dt3", length));
			String[] fcastDt2 = (JSPUtil.getParameter(request, prefix	+ "fcast_dt2", length));
			String[] fcastDt1 = (JSPUtil.getParameter(request, prefix	+ "fcast_dt1", length));
			String[] day = (JSPUtil.getParameter(request, prefix	+ "day", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0025ConditionVO();
				if (fcastDt5[i] != null)
					model.setFcastDt5(fcastDt5[i]);
				if (fcastDt6[i] != null)
					model.setFcastDt6(fcastDt6[i]);
				if (fcastDt7[i] != null)
					model.setFcastDt7(fcastDt7[i]);
				if (statusType[i] != null)
					model.setStatusType(statusType[i]);
				if (fmsfcastyr[i] != null)
					model.setFmsfcastyr(fmsfcastyr[i]);
				if (cocd[i] != null)
					model.setCocd(cocd[i]);
				if (fmEccCdIns[i] != null)
					model.setFmEccCdIns(fmEccCdIns[i]);
				if (fmtypeby[i] != null)
					model.setFmtypeby(fmtypeby[i]);
				if (attypeby[i] != null)
					model.setAttypeby(attypeby[i]);
				if (cntrtpszcd[i] != null)
					model.setCntrtpszcd(cntrtpszcd[i]);
				if (fcastYrwkIns[i] != null)
					model.setFcastYrwkIns(fcastYrwkIns[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmecccd[i] != null)
					model.setFmecccd(fmecccd[i]);
				if (toEccCdIns[i] != null)
					model.setToEccCdIns(toEccCdIns[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (atefcastwk[i] != null)
					model.setAtefcastwk(atefcastwk[i]);
				if (fmsfcastwk[i] != null)
					model.setFmsfcastwk(fmsfcastwk[i]);
				if (coCdIns[i] != null)
					model.setCoCdIns(coCdIns[i]);
				if (atefcastyr[i] != null)
					model.setAtefcastyr(atefcastyr[i]);
				if (fmefcastyr[i] != null)
					model.setFmefcastyr(fmefcastyr[i]);
				if (toecccd[i] != null)
					model.setToecccd(toecccd[i]);
				if (atecccd[i] != null)
					model.setAtecccd(atecccd[i]);
				if (fmefcastwk[i] != null)
					model.setFmefcastwk(fmefcastwk[i]);
				if (fmtype[i] != null)
					model.setFmtype(fmtype[i]);
				if (row[i] != null)
					model.setRow(row[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (attype[i] != null)
					model.setAttype(attype[i]);
				if (atsfcastyr[i] != null)
					model.setAtsfcastyr(atsfcastyr[i]);
				if (atsfcastwk[i] != null)
					model.setAtsfcastwk(atsfcastwk[i]);
				if (totype[i] != null)
					model.setTotype(totype[i]);
				if (fmtoat[i] != null)
					model.setFmtoat(fmtoat[i]);
				if (totypeby[i] != null)
					model.setTotypeby(totypeby[i]);
				if (srcdata[i] != null)
					model.setSrcdata(srcdata[i]);
				if (fcastDt4[i] != null)
					model.setFcastDt4(fcastDt4[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (fcastDt3[i] != null)
					model.setFcastDt3(fcastDt3[i]);
				if (fcastDt2[i] != null)
					model.setFcastDt2(fcastDt2[i]);
				if (fcastDt1[i] != null)
					model.setFcastDt1(fcastDt1[i]);
				if (day[i] != null)
					model.setDay(day[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0025ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0025ConditionVO[]
	 */
	public EesEqr0025ConditionVO[] getEesEqr0025ConditionVOs(){
		EesEqr0025ConditionVO[] vos = (EesEqr0025ConditionVO[])models.toArray(new EesEqr0025ConditionVO[models.size()]);
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
		this.fcastDt5 = this.fcastDt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastDt6 = this.fcastDt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastDt7 = this.fcastDt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusType = this.statusType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmsfcastyr = this.fmsfcastyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cocd = this.cocd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEccCdIns = this.fmEccCdIns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtypeby = this.fmtypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attypeby = this.attypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd = this.cntrtpszcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastYrwkIns = this.fcastYrwkIns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmecccd = this.fmecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCdIns = this.toEccCdIns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atefcastwk = this.atefcastwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmsfcastwk = this.fmsfcastwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCdIns = this.coCdIns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atefcastyr = this.atefcastyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmefcastyr = this.fmefcastyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toecccd = this.toecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atecccd = this.atecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmefcastwk = this.fmefcastwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtype = this.fmtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row = this.row .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attype = this.attype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atsfcastyr = this.atsfcastyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atsfcastwk = this.atsfcastwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totype = this.totype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoat = this.fmtoat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totypeby = this.totypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcdata = this.srcdata .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastDt4 = this.fcastDt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastDt3 = this.fcastDt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastDt2 = this.fcastDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastDt1 = this.fcastDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day = this.day .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
