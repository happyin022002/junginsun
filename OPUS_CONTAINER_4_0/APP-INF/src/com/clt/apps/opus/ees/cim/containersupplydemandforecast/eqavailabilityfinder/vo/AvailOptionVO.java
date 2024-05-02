/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AvailOptionVO.java
*@FileTitle : AvailOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.02.17 김종준 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo;

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

public class AvailOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AvailOptionVO> models = new ArrayList<AvailOptionVO>();
	
	/* Column Info */
	private String cntrTpszCd14 = null;
	/* Column Info */
	private String headCntrTpszCd = null;
	/* Column Info */
	private String cntrTpszCd15 = null;
	/* Column Info */
	private String cntrTpszCd16 = null;
	/* Column Info */
	private String cntrTpszCd17 = null;
	/* Column Info */
	private String cntrTpszCd18 = null;
	/* Column Info */
	private String cntrTpszCd19 = null;
	/* Column Info */
	private String locTypeCode = null;
	/* Column Info */
	private String fcastDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrTpszCd11 = null;
	/* Column Info */
	private String cntrTpszCd10 = null;
	/* Column Info */
	private String cntrTpszCd13 = null;
	/* Column Info */
	private String cntrTpszCd12 = null;
	/* Column Info */
	private String cntrTpszCdVal4 = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String cntrTpszCdVal1 = null;
	/* Column Info */
	private String cntrTpszCdVal3 = null;
	/* Column Info */
	private String cntrTpszCdVal2 = null;
	/* Column Info */
	private String cntrTpszCd6 = null;
	/* Column Info */
	private String cntrTpszCd5 = null;
	/* Column Info */
	private String cntrTpszCd8 = null;
	/* Column Info */
	private String cntrTpszCd7 = null;
	/* Column Info */
	private String cntrTpszCd9 = null;
	/* Column Info */
	private String cntrTpszCd20 = null;
	/* Column Info */
	private String cntrTpszCd2 = null;
	/* Column Info */
	private String cntrTpszCd1 = null;
	/* Column Info */
	private String cntrTpszCd4 = null;
	/* Column Info */
	private String cntrTpszCd3 = null;
	/* Column Info */
	private String rstUsgLbl = null;
	/*	Column Info	*/
	private  String	 sType   =  null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AvailOptionVO() {}

	public AvailOptionVO(String ibflag, String pagerows, String locCd, String locTypeCode, String headCntrTpszCd, String cntrTpszCdVal1, String cntrTpszCdVal2, String cntrTpszCdVal3, String cntrTpszCdVal4, String cntrTpszCd1, String cntrTpszCd2, String cntrTpszCd3, String cntrTpszCd4, String cntrTpszCd5, String cntrTpszCd6, String cntrTpszCd7, String cntrTpszCd8, String cntrTpszCd9, String cntrTpszCd10, String cntrTpszCd11, String cntrTpszCd12, String cntrTpszCd13, String cntrTpszCd14, String cntrTpszCd15, String cntrTpszCd16, String cntrTpszCd17, String cntrTpszCd18, String cntrTpszCd19, String cntrTpszCd20, String ioBndCd, String fcastDt, String cntrTpszCd, String rstUsgLbl,String sType) {
		this.cntrTpszCd14 = cntrTpszCd14;
		this.headCntrTpszCd = headCntrTpszCd;
		this.cntrTpszCd15 = cntrTpszCd15;
		this.cntrTpszCd16 = cntrTpszCd16;
		this.cntrTpszCd17 = cntrTpszCd17;
		this.cntrTpszCd18 = cntrTpszCd18;
		this.cntrTpszCd19 = cntrTpszCd19;
		this.locTypeCode = locTypeCode;
		this.fcastDt = fcastDt;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrTpszCd11 = cntrTpszCd11;
		this.cntrTpszCd10 = cntrTpszCd10;
		this.cntrTpszCd13 = cntrTpszCd13;
		this.cntrTpszCd12 = cntrTpszCd12;
		this.cntrTpszCdVal4 = cntrTpszCdVal4;
		this.ioBndCd = ioBndCd;
		this.cntrTpszCdVal1 = cntrTpszCdVal1;
		this.cntrTpszCdVal3 = cntrTpszCdVal3;
		this.cntrTpszCdVal2 = cntrTpszCdVal2;
		this.cntrTpszCd6 = cntrTpszCd6;
		this.cntrTpszCd5 = cntrTpszCd5;
		this.cntrTpszCd8 = cntrTpszCd8;
		this.cntrTpszCd7 = cntrTpszCd7;
		this.cntrTpszCd9 = cntrTpszCd9;
		this.cntrTpszCd20 = cntrTpszCd20;
		this.cntrTpszCd2 = cntrTpszCd2;
		this.cntrTpszCd1 = cntrTpszCd1;
		this.cntrTpszCd4 = cntrTpszCd4;
		this.cntrTpszCd3 = cntrTpszCd3;
		this.rstUsgLbl = rstUsgLbl;
		this.sType  = sType ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_tpsz_cd14", getCntrTpszCd14());
		this.hashColumns.put("head_cntr_tpsz_cd", getHeadCntrTpszCd());
		this.hashColumns.put("cntr_tpsz_cd15", getCntrTpszCd15());
		this.hashColumns.put("cntr_tpsz_cd16", getCntrTpszCd16());
		this.hashColumns.put("cntr_tpsz_cd17", getCntrTpszCd17());
		this.hashColumns.put("cntr_tpsz_cd18", getCntrTpszCd18());
		this.hashColumns.put("cntr_tpsz_cd19", getCntrTpszCd19());
		this.hashColumns.put("loc_type_code", getLocTypeCode());
		this.hashColumns.put("fcast_dt", getFcastDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_tpsz_cd11", getCntrTpszCd11());
		this.hashColumns.put("cntr_tpsz_cd10", getCntrTpszCd10());
		this.hashColumns.put("cntr_tpsz_cd13", getCntrTpszCd13());
		this.hashColumns.put("cntr_tpsz_cd12", getCntrTpszCd12());
		this.hashColumns.put("cntr_tpsz_cd_val4", getCntrTpszCdVal4());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cntr_tpsz_cd_val1", getCntrTpszCdVal1());
		this.hashColumns.put("cntr_tpsz_cd_val3", getCntrTpszCdVal3());
		this.hashColumns.put("cntr_tpsz_cd_val2", getCntrTpszCdVal2());
		this.hashColumns.put("cntr_tpsz_cd6", getCntrTpszCd6());
		this.hashColumns.put("cntr_tpsz_cd5", getCntrTpszCd5());
		this.hashColumns.put("cntr_tpsz_cd8", getCntrTpszCd8());
		this.hashColumns.put("cntr_tpsz_cd7", getCntrTpszCd7());
		this.hashColumns.put("cntr_tpsz_cd9", getCntrTpszCd9());
		this.hashColumns.put("cntr_tpsz_cd20", getCntrTpszCd20());
		this.hashColumns.put("cntr_tpsz_cd2", getCntrTpszCd2());
		this.hashColumns.put("cntr_tpsz_cd1", getCntrTpszCd1());
		this.hashColumns.put("cntr_tpsz_cd4", getCntrTpszCd4());
		this.hashColumns.put("cntr_tpsz_cd3", getCntrTpszCd3());
		this.hashColumns.put("rstr_usg_lbl", getRstUsgLbl());
		this.hashColumns.put("s_type", getSType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_tpsz_cd14", "cntrTpszCd14");
		this.hashFields.put("head_cntr_tpsz_cd", "headCntrTpszCd");
		this.hashFields.put("cntr_tpsz_cd15", "cntrTpszCd15");
		this.hashFields.put("cntr_tpsz_cd16", "cntrTpszCd16");
		this.hashFields.put("cntr_tpsz_cd17", "cntrTpszCd17");
		this.hashFields.put("cntr_tpsz_cd18", "cntrTpszCd18");
		this.hashFields.put("cntr_tpsz_cd19", "cntrTpszCd19");
		this.hashFields.put("loc_type_code", "locTypeCode");
		this.hashFields.put("fcast_dt", "fcastDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_tpsz_cd11", "cntrTpszCd11");
		this.hashFields.put("cntr_tpsz_cd10", "cntrTpszCd10");
		this.hashFields.put("cntr_tpsz_cd13", "cntrTpszCd13");
		this.hashFields.put("cntr_tpsz_cd12", "cntrTpszCd12");
		this.hashFields.put("cntr_tpsz_cd_val4", "cntrTpszCdVal4");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cntr_tpsz_cd_val1", "cntrTpszCdVal1");
		this.hashFields.put("cntr_tpsz_cd_val3", "cntrTpszCdVal3");
		this.hashFields.put("cntr_tpsz_cd_val2", "cntrTpszCdVal2");
		this.hashFields.put("cntr_tpsz_cd6", "cntrTpszCd6");
		this.hashFields.put("cntr_tpsz_cd5", "cntrTpszCd5");
		this.hashFields.put("cntr_tpsz_cd8", "cntrTpszCd8");
		this.hashFields.put("cntr_tpsz_cd7", "cntrTpszCd7");
		this.hashFields.put("cntr_tpsz_cd9", "cntrTpszCd9");
		this.hashFields.put("cntr_tpsz_cd20", "cntrTpszCd20");
		this.hashFields.put("cntr_tpsz_cd2", "cntrTpszCd2");
		this.hashFields.put("cntr_tpsz_cd1", "cntrTpszCd1");
		this.hashFields.put("cntr_tpsz_cd4", "cntrTpszCd4");
		this.hashFields.put("cntr_tpsz_cd3", "cntrTpszCd3");
		this.hashFields.put("rstr_usg_lbl", "rstUsgLbl");
		this.hashFields.put("s_type", "sType");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd14
	 */
	public String getCntrTpszCd14() {
		return this.cntrTpszCd14;
	}
	
	/**
	 * Column Info
	 * @return headCntrTpszCd
	 */
	public String getHeadCntrTpszCd() {
		return this.headCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd15
	 */
	public String getCntrTpszCd15() {
		return this.cntrTpszCd15;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd16
	 */
	public String getCntrTpszCd16() {
		return this.cntrTpszCd16;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd17
	 */
	public String getCntrTpszCd17() {
		return this.cntrTpszCd17;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd18
	 */
	public String getCntrTpszCd18() {
		return this.cntrTpszCd18;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd19
	 */
	public String getCntrTpszCd19() {
		return this.cntrTpszCd19;
	}
	
	/**
	 * Column Info
	 * @return locTypeCode
	 */
	public String getLocTypeCode() {
		return this.locTypeCode;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd11
	 */
	public String getCntrTpszCd11() {
		return this.cntrTpszCd11;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd10
	 */
	public String getCntrTpszCd10() {
		return this.cntrTpszCd10;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd13
	 */
	public String getCntrTpszCd13() {
		return this.cntrTpszCd13;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd12
	 */
	public String getCntrTpszCd12() {
		return this.cntrTpszCd12;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCdVal4
	 */
	public String getCntrTpszCdVal4() {
		return this.cntrTpszCdVal4;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCdVal1
	 */
	public String getCntrTpszCdVal1() {
		return this.cntrTpszCdVal1;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCdVal3
	 */
	public String getCntrTpszCdVal3() {
		return this.cntrTpszCdVal3;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCdVal2
	 */
	public String getCntrTpszCdVal2() {
		return this.cntrTpszCdVal2;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd6
	 */
	public String getCntrTpszCd6() {
		return this.cntrTpszCd6;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd5
	 */
	public String getCntrTpszCd5() {
		return this.cntrTpszCd5;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd8
	 */
	public String getCntrTpszCd8() {
		return this.cntrTpszCd8;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd7
	 */
	public String getCntrTpszCd7() {
		return this.cntrTpszCd7;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd9
	 */
	public String getCntrTpszCd9() {
		return this.cntrTpszCd9;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd20
	 */
	public String getCntrTpszCd20() {
		return this.cntrTpszCd20;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd2
	 */
	public String getCntrTpszCd2() {
		return this.cntrTpszCd2;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd1
	 */
	public String getCntrTpszCd1() {
		return this.cntrTpszCd1;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd4
	 */
	public String getCntrTpszCd4() {
		return this.cntrTpszCd4;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd3
	 */
	public String getCntrTpszCd3() {
		return this.cntrTpszCd3;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd3
	 */
	public String getRstUsgLbl() {
		return this.rstUsgLbl;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd14
	 */
	public void setCntrTpszCd14(String cntrTpszCd14) {
		this.cntrTpszCd14 = cntrTpszCd14;
	}
	
	/**
	 * Column Info
	 * @param headCntrTpszCd
	 */
	public void setHeadCntrTpszCd(String headCntrTpszCd) {
		this.headCntrTpszCd = headCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd15
	 */
	public void setCntrTpszCd15(String cntrTpszCd15) {
		this.cntrTpszCd15 = cntrTpszCd15;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd16
	 */
	public void setCntrTpszCd16(String cntrTpszCd16) {
		this.cntrTpszCd16 = cntrTpszCd16;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd17
	 */
	public void setCntrTpszCd17(String cntrTpszCd17) {
		this.cntrTpszCd17 = cntrTpszCd17;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd18
	 */
	public void setCntrTpszCd18(String cntrTpszCd18) {
		this.cntrTpszCd18 = cntrTpszCd18;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd19
	 */
	public void setCntrTpszCd19(String cntrTpszCd19) {
		this.cntrTpszCd19 = cntrTpszCd19;
	}
	
	/**
	 * Column Info
	 * @param locTypeCode
	 */
	public void setLocTypeCode(String locTypeCode) {
		this.locTypeCode = locTypeCode;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd11
	 */
	public void setCntrTpszCd11(String cntrTpszCd11) {
		this.cntrTpszCd11 = cntrTpszCd11;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd10
	 */
	public void setCntrTpszCd10(String cntrTpszCd10) {
		this.cntrTpszCd10 = cntrTpszCd10;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd13
	 */
	public void setCntrTpszCd13(String cntrTpszCd13) {
		this.cntrTpszCd13 = cntrTpszCd13;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd12
	 */
	public void setCntrTpszCd12(String cntrTpszCd12) {
		this.cntrTpszCd12 = cntrTpszCd12;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCdVal4
	 */
	public void setCntrTpszCdVal4(String cntrTpszCdVal4) {
		this.cntrTpszCdVal4 = cntrTpszCdVal4;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCdVal1
	 */
	public void setCntrTpszCdVal1(String cntrTpszCdVal1) {
		this.cntrTpszCdVal1 = cntrTpszCdVal1;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCdVal3
	 */
	public void setCntrTpszCdVal3(String cntrTpszCdVal3) {
		this.cntrTpszCdVal3 = cntrTpszCdVal3;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCdVal2
	 */
	public void setCntrTpszCdVal2(String cntrTpszCdVal2) {
		this.cntrTpszCdVal2 = cntrTpszCdVal2;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd6
	 */
	public void setCntrTpszCd6(String cntrTpszCd6) {
		this.cntrTpszCd6 = cntrTpszCd6;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd5
	 */
	public void setCntrTpszCd5(String cntrTpszCd5) {
		this.cntrTpszCd5 = cntrTpszCd5;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd8
	 */
	public void setCntrTpszCd8(String cntrTpszCd8) {
		this.cntrTpszCd8 = cntrTpszCd8;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd7
	 */
	public void setCntrTpszCd7(String cntrTpszCd7) {
		this.cntrTpszCd7 = cntrTpszCd7;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd9
	 */
	public void setCntrTpszCd9(String cntrTpszCd9) {
		this.cntrTpszCd9 = cntrTpszCd9;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd20
	 */
	public void setCntrTpszCd20(String cntrTpszCd20) {
		this.cntrTpszCd20 = cntrTpszCd20;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd2
	 */
	public void setCntrTpszCd2(String cntrTpszCd2) {
		this.cntrTpszCd2 = cntrTpszCd2;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd1
	 */
	public void setCntrTpszCd1(String cntrTpszCd1) {
		this.cntrTpszCd1 = cntrTpszCd1;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd4
	 */
	public void setCntrTpszCd4(String cntrTpszCd4) {
		this.cntrTpszCd4 = cntrTpszCd4;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd3
	 */
	public void setCntrTpszCd3(String cntrTpszCd3) {
		this.cntrTpszCd3 = cntrTpszCd3;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd3
	 */
	public void setRstUsgLbl(String rstUsgLbl) {
		this.rstUsgLbl = rstUsgLbl;
	}
	
	/**
	* Column Info
	* @param  sType
	*/
	public void	setSType( String	sType ) {
		this.sType =	sType;
	}
 
	/**
	 * Column Info
	 * @return	sType
	 */
	 public	 String	getSType() {
		 return	this.sType;
	 } 
	 
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrTpszCd14(JSPUtil.getParameter(request, "cntr_tpsz_cd14", ""));
		setHeadCntrTpszCd(JSPUtil.getParameter(request, "head_cntr_tpsz_cd", ""));
		setCntrTpszCd15(JSPUtil.getParameter(request, "cntr_tpsz_cd15", ""));
		setCntrTpszCd16(JSPUtil.getParameter(request, "cntr_tpsz_cd16", ""));
		setCntrTpszCd17(JSPUtil.getParameter(request, "cntr_tpsz_cd17", ""));
		setCntrTpszCd18(JSPUtil.getParameter(request, "cntr_tpsz_cd18", ""));
		setCntrTpszCd19(JSPUtil.getParameter(request, "cntr_tpsz_cd19", ""));
		setLocTypeCode(JSPUtil.getParameter(request, "loc_type_code", ""));
		setFcastDt(JSPUtil.getParameter(request, "fcast_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrTpszCd11(JSPUtil.getParameter(request, "cntr_tpsz_cd11", ""));
		setCntrTpszCd10(JSPUtil.getParameter(request, "cntr_tpsz_cd10", ""));
		setCntrTpszCd13(JSPUtil.getParameter(request, "cntr_tpsz_cd13", ""));
		setCntrTpszCd12(JSPUtil.getParameter(request, "cntr_tpsz_cd12", ""));
		setCntrTpszCdVal4(JSPUtil.getParameter(request, "cntr_tpsz_cd_val4", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setCntrTpszCdVal1(JSPUtil.getParameter(request, "cntr_tpsz_cd_val1", ""));
		setCntrTpszCdVal3(JSPUtil.getParameter(request, "cntr_tpsz_cd_val3", ""));
		setCntrTpszCdVal2(JSPUtil.getParameter(request, "cntr_tpsz_cd_val2", ""));
		setCntrTpszCd6(JSPUtil.getParameter(request, "cntr_tpsz_cd6", ""));
		setCntrTpszCd5(JSPUtil.getParameter(request, "cntr_tpsz_cd5", ""));
		setCntrTpszCd8(JSPUtil.getParameter(request, "cntr_tpsz_cd8", ""));
		setCntrTpszCd7(JSPUtil.getParameter(request, "cntr_tpsz_cd7", ""));
		setCntrTpszCd9(JSPUtil.getParameter(request, "cntr_tpsz_cd9", ""));
		setCntrTpszCd20(JSPUtil.getParameter(request, "cntr_tpsz_cd20", ""));
		setCntrTpszCd2(JSPUtil.getParameter(request, "cntr_tpsz_cd2", ""));
		setCntrTpszCd1(JSPUtil.getParameter(request, "cntr_tpsz_cd1", ""));
		setCntrTpszCd4(JSPUtil.getParameter(request, "cntr_tpsz_cd4", ""));
		setCntrTpszCd3(JSPUtil.getParameter(request, "cntr_tpsz_cd3", ""));
		setRstUsgLbl(JSPUtil.getParameter(request, "rstr_usg_lbl", ""));
		setSType(JSPUtil.getParameter(request,	 "s_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AvailOptionVO[]
	 */
	public AvailOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AvailOptionVO[]
	 */
	public AvailOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AvailOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrTpszCd14 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd14", length));
			String[] headCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "head_cntr_tpsz_cd", length));
			String[] cntrTpszCd15 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd15", length));
			String[] cntrTpszCd16 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd16", length));
			String[] cntrTpszCd17 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd17", length));
			String[] cntrTpszCd18 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd18", length));
			String[] cntrTpszCd19 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd19", length));
			String[] locTypeCode = (JSPUtil.getParameter(request, prefix	+ "loc_type_code", length));
			String[] fcastDt = (JSPUtil.getParameter(request, prefix	+ "fcast_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrTpszCd11 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd11", length));
			String[] cntrTpszCd10 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd10", length));
			String[] cntrTpszCd13 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd13", length));
			String[] cntrTpszCd12 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd12", length));
			String[] cntrTpszCdVal4 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd_val4", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] cntrTpszCdVal1 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd_val1", length));
			String[] cntrTpszCdVal3 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd_val3", length));
			String[] cntrTpszCdVal2 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd_val2", length));
			String[] cntrTpszCd6 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd6", length));
			String[] cntrTpszCd5 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd5", length));
			String[] cntrTpszCd8 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd8", length));
			String[] cntrTpszCd7 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd7", length));
			String[] cntrTpszCd9 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd9", length));
			String[] cntrTpszCd20 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd20", length));
			String[] cntrTpszCd2 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd2", length));
			String[] cntrTpszCd1 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd1", length));
			String[] cntrTpszCd4 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd4", length));
			String[] cntrTpszCd3 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd3", length));
			String[] rstUsgLbl = (JSPUtil.getParameter(request, prefix	+ "rstr_usg_lbl", length));
			String[] sType =	(JSPUtil.getParameter(request, prefix +	"s_type".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new AvailOptionVO();
				if (cntrTpszCd14[i] != null)
					model.setCntrTpszCd14(cntrTpszCd14[i]);
				if (headCntrTpszCd[i] != null)
					model.setHeadCntrTpszCd(headCntrTpszCd[i]);
				if (cntrTpszCd15[i] != null)
					model.setCntrTpszCd15(cntrTpszCd15[i]);
				if (cntrTpszCd16[i] != null)
					model.setCntrTpszCd16(cntrTpszCd16[i]);
				if (cntrTpszCd17[i] != null)
					model.setCntrTpszCd17(cntrTpszCd17[i]);
				if (cntrTpszCd18[i] != null)
					model.setCntrTpszCd18(cntrTpszCd18[i]);
				if (cntrTpszCd19[i] != null)
					model.setCntrTpszCd19(cntrTpszCd19[i]);
				if (locTypeCode[i] != null)
					model.setLocTypeCode(locTypeCode[i]);
				if (fcastDt[i] != null)
					model.setFcastDt(fcastDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrTpszCd11[i] != null)
					model.setCntrTpszCd11(cntrTpszCd11[i]);
				if (cntrTpszCd10[i] != null)
					model.setCntrTpszCd10(cntrTpszCd10[i]);
				if (cntrTpszCd13[i] != null)
					model.setCntrTpszCd13(cntrTpszCd13[i]);
				if (cntrTpszCd12[i] != null)
					model.setCntrTpszCd12(cntrTpszCd12[i]);
				if (cntrTpszCdVal4[i] != null)
					model.setCntrTpszCdVal4(cntrTpszCdVal4[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (cntrTpszCdVal1[i] != null)
					model.setCntrTpszCdVal1(cntrTpszCdVal1[i]);
				if (cntrTpszCdVal3[i] != null)
					model.setCntrTpszCdVal3(cntrTpszCdVal3[i]);
				if (cntrTpszCdVal2[i] != null)
					model.setCntrTpszCdVal2(cntrTpszCdVal2[i]);
				if (cntrTpszCd6[i] != null)
					model.setCntrTpszCd6(cntrTpszCd6[i]);
				if (cntrTpszCd5[i] != null)
					model.setCntrTpszCd5(cntrTpszCd5[i]);
				if (cntrTpszCd8[i] != null)
					model.setCntrTpszCd8(cntrTpszCd8[i]);
				if (cntrTpszCd7[i] != null)
					model.setCntrTpszCd7(cntrTpszCd7[i]);
				if (cntrTpszCd9[i] != null)
					model.setCntrTpszCd9(cntrTpszCd9[i]);
				if (cntrTpszCd20[i] != null)
					model.setCntrTpszCd20(cntrTpszCd20[i]);
				if (cntrTpszCd2[i] != null)
					model.setCntrTpszCd2(cntrTpszCd2[i]);
				if (cntrTpszCd1[i] != null)
					model.setCntrTpszCd1(cntrTpszCd1[i]);
				if (cntrTpszCd4[i] != null)
					model.setCntrTpszCd4(cntrTpszCd4[i]);
				if (cntrTpszCd3[i] != null)
					model.setCntrTpszCd3(cntrTpszCd3[i]);
				if (rstUsgLbl[i] != null)
					model.setRstUsgLbl(rstUsgLbl[i]);
				if ( sType[i] !=	null)
					model.setSType( sType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAvailOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AvailOptionVO[]
	 */
	public AvailOptionVO[] getAvailOptionVOs(){
		AvailOptionVO[] vos = (AvailOptionVO[])models.toArray(new AvailOptionVO[models.size()]);
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
		this.cntrTpszCd14 = this.cntrTpszCd14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headCntrTpszCd = this.headCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd15 = this.cntrTpszCd15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd16 = this.cntrTpszCd16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd17 = this.cntrTpszCd17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd18 = this.cntrTpszCd18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd19 = this.cntrTpszCd19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTypeCode = this.locTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastDt = this.fcastDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd11 = this.cntrTpszCd11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd10 = this.cntrTpszCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd13 = this.cntrTpszCd13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd12 = this.cntrTpszCd12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCdVal4 = this.cntrTpszCdVal4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCdVal1 = this.cntrTpszCdVal1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCdVal3 = this.cntrTpszCdVal3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCdVal2 = this.cntrTpszCdVal2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd6 = this.cntrTpszCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd5 = this.cntrTpszCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd8 = this.cntrTpszCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd7 = this.cntrTpszCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd9 = this.cntrTpszCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd20 = this.cntrTpszCd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd2 = this.cntrTpszCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd1 = this.cntrTpszCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd4 = this.cntrTpszCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd3 = this.cntrTpszCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstUsgLbl = this.rstUsgLbl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sType =	this.sType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
