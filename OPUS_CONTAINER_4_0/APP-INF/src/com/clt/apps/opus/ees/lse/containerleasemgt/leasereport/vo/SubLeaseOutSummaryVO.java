/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SubLeaseOutSummaryVO.java
*@FileTitle : SubLeaseOutSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.08.13 장준우 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo;

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
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SubLeaseOutSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SubLeaseOutSummaryVO> models = new ArrayList<SubLeaseOutSummaryVO>();
	
	/* Column Info */
	private String tpszDp19 = null;
	/* Column Info */
	private String tpszDp18 = null;
	/* Column Info */
	private String tpszDp17 = null;
	/* Column Info */
	private String tpszDp16 = null;
	/* Column Info */
	private String tpszTotal = null;
	/* Column Info */
	private String tpszDp15 = null;
	/* Column Info */
	private String tpszDp14 = null;
	/* Column Info */
	private String tpszDp13 = null;
	/* Column Info */
	private String tpszDp12 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpszDp10 = null;
	/* Column Info */
	private String tpszDp11 = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String tpszDp24 = null;
	/* Column Info */
	private String tpszDp06 = null;
	/* Column Info */
	private String tpszDp23 = null;
	/* Column Info */
	private String tpszDp05 = null;
	/* Column Info */
	private String tpszDp26 = null;
	/* Column Info */
	private String tpszDp08 = null;
	/* Column Info */
	private String tpszDp25 = null;
	/* Column Info */
	private String tpszDp07 = null;
	/* Column Info */
	private String tpszDp02 = null;
	/* Column Info */
	private String tpszDp01 = null;
	/* Column Info */
	private String tpszDp04 = null;
	/* Column Info */
	private String tpszDp03 = null;
	/* Column Info */
	private String tpszDp09 = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String tpszDp20 = null;
	/* Column Info */
	private String tpszDp21 = null;
	/* Column Info */
	private String tpszDp22 = null;
	/* Column Info */
	private String tpszDp27 = null;
	/* Column Info */
	private String tpszDp28 = null;
	/* Column Info */
	private String tpszDp29 = null;
	/* Column Info */
	private String tpszDp30 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SubLeaseOutSummaryVO() {}

	public SubLeaseOutSummaryVO(String ibflag, String pagerows, String locCd, String lstmCd, String vndrAbbrNm, String vndrSeq, String tpszTotal, String tpszDp01, String tpszDp02, String tpszDp03, String tpszDp04, String tpszDp05, String tpszDp06, String tpszDp07, String tpszDp08, String tpszDp09, String tpszDp10, String tpszDp11, String tpszDp12, String tpszDp13, String tpszDp14, String tpszDp15, String tpszDp16, String tpszDp17, String tpszDp18, String tpszDp19, String tpszDp20, String tpszDp21, String tpszDp22, String tpszDp23, String tpszDp24, String tpszDp25, String tpszDp26, String tpszDp27, String tpszDp28, String tpszDp29, String tpszDp30) {
		this.tpszDp19 = tpszDp19;
		this.tpszDp18 = tpszDp18;
		this.tpszDp17 = tpszDp17;
		this.tpszDp16 = tpszDp16;
		this.tpszTotal = tpszTotal;
		this.tpszDp15 = tpszDp15;
		this.tpszDp14 = tpszDp14;
		this.tpszDp13 = tpszDp13;
		this.tpszDp12 = tpszDp12;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.tpszDp10 = tpszDp10;
		this.tpszDp11 = tpszDp11;
		this.lstmCd = lstmCd;
		this.tpszDp24 = tpszDp24;
		this.tpszDp06 = tpszDp06;
		this.tpszDp23 = tpszDp23;
		this.tpszDp05 = tpszDp05;
		this.tpszDp26 = tpszDp26;
		this.tpszDp08 = tpszDp08;
		this.tpszDp25 = tpszDp25;
		this.tpszDp07 = tpszDp07;
		this.tpszDp02 = tpszDp02;
		this.tpszDp01 = tpszDp01;
		this.tpszDp04 = tpszDp04;
		this.tpszDp03 = tpszDp03;
		this.tpszDp09 = tpszDp09;
		this.vndrSeq = vndrSeq;
		this.vndrAbbrNm = vndrAbbrNm;
		this.tpszDp20 = tpszDp20;
		this.tpszDp21 = tpszDp21;
		this.tpszDp22 = tpszDp22;
		this.tpszDp27 = tpszDp27;
		this.tpszDp28 = tpszDp28;
		this.tpszDp29 = tpszDp29;
		this.tpszDp30 = tpszDp30;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tpsz_dp19", getTpszDp19());
		this.hashColumns.put("tpsz_dp18", getTpszDp18());
		this.hashColumns.put("tpsz_dp17", getTpszDp17());
		this.hashColumns.put("tpsz_dp16", getTpszDp16());
		this.hashColumns.put("tpsz_total", getTpszTotal());
		this.hashColumns.put("tpsz_dp15", getTpszDp15());
		this.hashColumns.put("tpsz_dp14", getTpszDp14());
		this.hashColumns.put("tpsz_dp13", getTpszDp13());
		this.hashColumns.put("tpsz_dp12", getTpszDp12());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz_dp10", getTpszDp10());
		this.hashColumns.put("tpsz_dp11", getTpszDp11());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("tpsz_dp24", getTpszDp24());
		this.hashColumns.put("tpsz_dp06", getTpszDp06());
		this.hashColumns.put("tpsz_dp23", getTpszDp23());
		this.hashColumns.put("tpsz_dp05", getTpszDp05());
		this.hashColumns.put("tpsz_dp26", getTpszDp26());
		this.hashColumns.put("tpsz_dp08", getTpszDp08());
		this.hashColumns.put("tpsz_dp25", getTpszDp25());
		this.hashColumns.put("tpsz_dp07", getTpszDp07());
		this.hashColumns.put("tpsz_dp02", getTpszDp02());
		this.hashColumns.put("tpsz_dp01", getTpszDp01());
		this.hashColumns.put("tpsz_dp04", getTpszDp04());
		this.hashColumns.put("tpsz_dp03", getTpszDp03());
		this.hashColumns.put("tpsz_dp09", getTpszDp09());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("tpsz_dp20", getTpszDp20());
		this.hashColumns.put("tpsz_dp21", getTpszDp21());
		this.hashColumns.put("tpsz_dp22", getTpszDp22());
		this.hashColumns.put("tpsz_dp27", getTpszDp27());
		this.hashColumns.put("tpsz_dp28", getTpszDp28());
		this.hashColumns.put("tpsz_dp29", getTpszDp29());
		this.hashColumns.put("tpsz_dp30", getTpszDp30());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tpsz_dp19", "tpszDp19");
		this.hashFields.put("tpsz_dp18", "tpszDp18");
		this.hashFields.put("tpsz_dp17", "tpszDp17");
		this.hashFields.put("tpsz_dp16", "tpszDp16");
		this.hashFields.put("tpsz_total", "tpszTotal");
		this.hashFields.put("tpsz_dp15", "tpszDp15");
		this.hashFields.put("tpsz_dp14", "tpszDp14");
		this.hashFields.put("tpsz_dp13", "tpszDp13");
		this.hashFields.put("tpsz_dp12", "tpszDp12");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz_dp10", "tpszDp10");
		this.hashFields.put("tpsz_dp11", "tpszDp11");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("tpsz_dp24", "tpszDp24");
		this.hashFields.put("tpsz_dp06", "tpszDp06");
		this.hashFields.put("tpsz_dp23", "tpszDp23");
		this.hashFields.put("tpsz_dp05", "tpszDp05");
		this.hashFields.put("tpsz_dp26", "tpszDp26");
		this.hashFields.put("tpsz_dp08", "tpszDp08");
		this.hashFields.put("tpsz_dp25", "tpszDp25");
		this.hashFields.put("tpsz_dp07", "tpszDp07");
		this.hashFields.put("tpsz_dp02", "tpszDp02");
		this.hashFields.put("tpsz_dp01", "tpszDp01");
		this.hashFields.put("tpsz_dp04", "tpszDp04");
		this.hashFields.put("tpsz_dp03", "tpszDp03");
		this.hashFields.put("tpsz_dp09", "tpszDp09");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("tpsz_dp20", "tpszDp20");
		this.hashFields.put("tpsz_dp21", "tpszDp21");
		this.hashFields.put("tpsz_dp22", "tpszDp22");
		this.hashFields.put("tpsz_dp27", "tpszDp27");
		this.hashFields.put("tpsz_dp28", "tpszDp28");
		this.hashFields.put("tpsz_dp29", "tpszDp29");
		this.hashFields.put("tpsz_dp30", "tpszDp30");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tpszDp19
	 */
	public String getTpszDp19() {
		return this.tpszDp19;
	}
	
	/**
	 * Column Info
	 * @return tpszDp18
	 */
	public String getTpszDp18() {
		return this.tpszDp18;
	}
	
	/**
	 * Column Info
	 * @return tpszDp17
	 */
	public String getTpszDp17() {
		return this.tpszDp17;
	}
	
	/**
	 * Column Info
	 * @return tpszDp16
	 */
	public String getTpszDp16() {
		return this.tpszDp16;
	}
	
	/**
	 * Column Info
	 * @return tpszTotal
	 */
	public String getTpszTotal() {
		return this.tpszTotal;
	}
	
	/**
	 * Column Info
	 * @return tpszDp15
	 */
	public String getTpszDp15() {
		return this.tpszDp15;
	}
	
	/**
	 * Column Info
	 * @return tpszDp14
	 */
	public String getTpszDp14() {
		return this.tpszDp14;
	}
	
	/**
	 * Column Info
	 * @return tpszDp13
	 */
	public String getTpszDp13() {
		return this.tpszDp13;
	}
	
	/**
	 * Column Info
	 * @return tpszDp12
	 */
	public String getTpszDp12() {
		return this.tpszDp12;
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
	 * @return tpszDp10
	 */
	public String getTpszDp10() {
		return this.tpszDp10;
	}
	
	/**
	 * Column Info
	 * @return tpszDp11
	 */
	public String getTpszDp11() {
		return this.tpszDp11;
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
	 * @return tpszDp24
	 */
	public String getTpszDp24() {
		return this.tpszDp24;
	}
	
	/**
	 * Column Info
	 * @return tpszDp06
	 */
	public String getTpszDp06() {
		return this.tpszDp06;
	}
	
	/**
	 * Column Info
	 * @return tpszDp23
	 */
	public String getTpszDp23() {
		return this.tpszDp23;
	}
	
	/**
	 * Column Info
	 * @return tpszDp05
	 */
	public String getTpszDp05() {
		return this.tpszDp05;
	}
	
	/**
	 * Column Info
	 * @return tpszDp26
	 */
	public String getTpszDp26() {
		return this.tpszDp26;
	}
	
	/**
	 * Column Info
	 * @return tpszDp08
	 */
	public String getTpszDp08() {
		return this.tpszDp08;
	}
	
	/**
	 * Column Info
	 * @return tpszDp25
	 */
	public String getTpszDp25() {
		return this.tpszDp25;
	}
	
	/**
	 * Column Info
	 * @return tpszDp07
	 */
	public String getTpszDp07() {
		return this.tpszDp07;
	}
	
	/**
	 * Column Info
	 * @return tpszDp02
	 */
	public String getTpszDp02() {
		return this.tpszDp02;
	}
	
	/**
	 * Column Info
	 * @return tpszDp01
	 */
	public String getTpszDp01() {
		return this.tpszDp01;
	}
	
	/**
	 * Column Info
	 * @return tpszDp04
	 */
	public String getTpszDp04() {
		return this.tpszDp04;
	}
	
	/**
	 * Column Info
	 * @return tpszDp03
	 */
	public String getTpszDp03() {
		return this.tpszDp03;
	}
	
	/**
	 * Column Info
	 * @return tpszDp09
	 */
	public String getTpszDp09() {
		return this.tpszDp09;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return tpszDp20
	 */
	public String getTpszDp20() {
		return this.tpszDp20;
	}
	
	/**
	 * Column Info
	 * @return tpszDp21
	 */
	public String getTpszDp21() {
		return this.tpszDp21;
	}
	
	/**
	 * Column Info
	 * @return tpszDp22
	 */
	public String getTpszDp22() {
		return this.tpszDp22;
	}
	

	/**
	 * Column Info
	 * @param tpszDp19
	 */
	public void setTpszDp19(String tpszDp19) {
		this.tpszDp19 = tpszDp19;
	}
	
	/**
	 * Column Info
	 * @param tpszDp18
	 */
	public void setTpszDp18(String tpszDp18) {
		this.tpszDp18 = tpszDp18;
	}
	
	/**
	 * Column Info
	 * @param tpszDp17
	 */
	public void setTpszDp17(String tpszDp17) {
		this.tpszDp17 = tpszDp17;
	}
	
	/**
	 * Column Info
	 * @param tpszDp16
	 */
	public void setTpszDp16(String tpszDp16) {
		this.tpszDp16 = tpszDp16;
	}
	
	/**
	 * Column Info
	 * @param tpszTotal
	 */
	public void setTpszTotal(String tpszTotal) {
		this.tpszTotal = tpszTotal;
	}
	
	/**
	 * Column Info
	 * @param tpszDp15
	 */
	public void setTpszDp15(String tpszDp15) {
		this.tpszDp15 = tpszDp15;
	}
	
	/**
	 * Column Info
	 * @param tpszDp14
	 */
	public void setTpszDp14(String tpszDp14) {
		this.tpszDp14 = tpszDp14;
	}
	
	/**
	 * Column Info
	 * @param tpszDp13
	 */
	public void setTpszDp13(String tpszDp13) {
		this.tpszDp13 = tpszDp13;
	}
	
	/**
	 * Column Info
	 * @param tpszDp12
	 */
	public void setTpszDp12(String tpszDp12) {
		this.tpszDp12 = tpszDp12;
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
	 * @param tpszDp10
	 */
	public void setTpszDp10(String tpszDp10) {
		this.tpszDp10 = tpszDp10;
	}
	
	/**
	 * Column Info
	 * @param tpszDp11
	 */
	public void setTpszDp11(String tpszDp11) {
		this.tpszDp11 = tpszDp11;
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
	 * @param tpszDp24
	 */
	public void setTpszDp24(String tpszDp24) {
		this.tpszDp24 = tpszDp24;
	}
	
	/**
	 * Column Info
	 * @param tpszDp06
	 */
	public void setTpszDp06(String tpszDp06) {
		this.tpszDp06 = tpszDp06;
	}
	
	/**
	 * Column Info
	 * @param tpszDp23
	 */
	public void setTpszDp23(String tpszDp23) {
		this.tpszDp23 = tpszDp23;
	}
	
	/**
	 * Column Info
	 * @param tpszDp05
	 */
	public void setTpszDp05(String tpszDp05) {
		this.tpszDp05 = tpszDp05;
	}
	
	/**
	 * Column Info
	 * @param tpszDp26
	 */
	public void setTpszDp26(String tpszDp26) {
		this.tpszDp26 = tpszDp26;
	}
	
	/**
	 * Column Info
	 * @param tpszDp08
	 */
	public void setTpszDp08(String tpszDp08) {
		this.tpszDp08 = tpszDp08;
	}
	
	/**
	 * Column Info
	 * @param tpszDp25
	 */
	public void setTpszDp25(String tpszDp25) {
		this.tpszDp25 = tpszDp25;
	}
	
	/**
	 * Column Info
	 * @param tpszDp07
	 */
	public void setTpszDp07(String tpszDp07) {
		this.tpszDp07 = tpszDp07;
	}
	
	/**
	 * Column Info
	 * @param tpszDp02
	 */
	public void setTpszDp02(String tpszDp02) {
		this.tpszDp02 = tpszDp02;
	}
	
	/**
	 * Column Info
	 * @param tpszDp01
	 */
	public void setTpszDp01(String tpszDp01) {
		this.tpszDp01 = tpszDp01;
	}
	
	/**
	 * Column Info
	 * @param tpszDp04
	 */
	public void setTpszDp04(String tpszDp04) {
		this.tpszDp04 = tpszDp04;
	}
	
	/**
	 * Column Info
	 * @param tpszDp03
	 */
	public void setTpszDp03(String tpszDp03) {
		this.tpszDp03 = tpszDp03;
	}
	
	/**
	 * Column Info
	 * @param tpszDp09
	 */
	public void setTpszDp09(String tpszDp09) {
		this.tpszDp09 = tpszDp09;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param tpszDp20
	 */
	public void setTpszDp20(String tpszDp20) {
		this.tpszDp20 = tpszDp20;
	}
	
	/**
	 * Column Info
	 * @param tpszDp21
	 */
	public void setTpszDp21(String tpszDp21) {
		this.tpszDp21 = tpszDp21;
	}
	
	/**
	 * Column Info
	 * @param tpszDp22
	 */
	public void setTpszDp22(String tpszDp22) {
		this.tpszDp22 = tpszDp22;
	}
	
	/**
	 * @return the tpszDp27
	 */
	public String getTpszDp27() {
		return tpszDp27;
	}

	/**
	 * @param tpszDp27 the tpszDp27 to set
	 */
	public void setTpszDp27(String tpszDp27) {
		this.tpszDp27 = tpszDp27;
	}

	/**
	 * @return the tpszDp28
	 */
	public String getTpszDp28() {
		return tpszDp28;
	}

	/**
	 * @param tpszDp28 the tpszDp28 to set
	 */
	public void setTpszDp28(String tpszDp28) {
		this.tpszDp28 = tpszDp28;
	}

	/**
	 * @return the tpszDp29
	 */
	public String getTpszDp29() {
		return tpszDp29;
	}

	/**
	 * @param tpszDp29 the tpszDp29 to set
	 */
	public void setTpszDp29(String tpszDp29) {
		this.tpszDp29 = tpszDp29;
	}

	/**
	 * @return the tpszDp30
	 */
	public String getTpszDp30() {
		return tpszDp30;
	}

	/**
	 * @param tpszDp30 the tpszDp30 to set
	 */
	public void setTpszDp30(String tpszDp30) {
		this.tpszDp30 = tpszDp30;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTpszDp19(JSPUtil.getParameter(request, "tpsz_dp19", ""));
		setTpszDp18(JSPUtil.getParameter(request, "tpsz_dp18", ""));
		setTpszDp17(JSPUtil.getParameter(request, "tpsz_dp17", ""));
		setTpszDp16(JSPUtil.getParameter(request, "tpsz_dp16", ""));
		setTpszTotal(JSPUtil.getParameter(request, "tpsz_total", ""));
		setTpszDp15(JSPUtil.getParameter(request, "tpsz_dp15", ""));
		setTpszDp14(JSPUtil.getParameter(request, "tpsz_dp14", ""));
		setTpszDp13(JSPUtil.getParameter(request, "tpsz_dp13", ""));
		setTpszDp12(JSPUtil.getParameter(request, "tpsz_dp12", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTpszDp10(JSPUtil.getParameter(request, "tpsz_dp10", ""));
		setTpszDp11(JSPUtil.getParameter(request, "tpsz_dp11", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setTpszDp24(JSPUtil.getParameter(request, "tpsz_dp24", ""));
		setTpszDp06(JSPUtil.getParameter(request, "tpsz_dp06", ""));
		setTpszDp23(JSPUtil.getParameter(request, "tpsz_dp23", ""));
		setTpszDp05(JSPUtil.getParameter(request, "tpsz_dp05", ""));
		setTpszDp26(JSPUtil.getParameter(request, "tpsz_dp26", ""));
		setTpszDp08(JSPUtil.getParameter(request, "tpsz_dp08", ""));
		setTpszDp25(JSPUtil.getParameter(request, "tpsz_dp25", ""));
		setTpszDp07(JSPUtil.getParameter(request, "tpsz_dp07", ""));
		setTpszDp02(JSPUtil.getParameter(request, "tpsz_dp02", ""));
		setTpszDp01(JSPUtil.getParameter(request, "tpsz_dp01", ""));
		setTpszDp04(JSPUtil.getParameter(request, "tpsz_dp04", ""));
		setTpszDp03(JSPUtil.getParameter(request, "tpsz_dp03", ""));
		setTpszDp09(JSPUtil.getParameter(request, "tpsz_dp09", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setTpszDp20(JSPUtil.getParameter(request, "tpsz_dp20", ""));
		setTpszDp21(JSPUtil.getParameter(request, "tpsz_dp21", ""));
		setTpszDp22(JSPUtil.getParameter(request, "tpsz_dp22", ""));
		setTpszDp27(JSPUtil.getParameter(request, "tpsz_dp27", ""));
		setTpszDp28(JSPUtil.getParameter(request, "tpsz_dp28", ""));
		setTpszDp29(JSPUtil.getParameter(request, "tpsz_dp29", ""));
		setTpszDp30(JSPUtil.getParameter(request, "tpsz_dp30", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SubLeaseOutSummaryVO[]
	 */
	public SubLeaseOutSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SubLeaseOutSummaryVO[]
	 */
	public SubLeaseOutSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SubLeaseOutSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tpszDp19 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp19", length));
			String[] tpszDp18 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp18", length));
			String[] tpszDp17 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp17", length));
			String[] tpszDp16 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp16", length));
			String[] tpszTotal = (JSPUtil.getParameter(request, prefix	+ "tpsz_total", length));
			String[] tpszDp15 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp15", length));
			String[] tpszDp14 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp14", length));
			String[] tpszDp13 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp13", length));
			String[] tpszDp12 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp12", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpszDp10 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp10", length));
			String[] tpszDp11 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp11", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] tpszDp24 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp24", length));
			String[] tpszDp06 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp06", length));
			String[] tpszDp23 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp23", length));
			String[] tpszDp05 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp05", length));
			String[] tpszDp26 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp26", length));
			String[] tpszDp08 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp08", length));
			String[] tpszDp25 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp25", length));
			String[] tpszDp07 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp07", length));
			String[] tpszDp02 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp02", length));
			String[] tpszDp01 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp01", length));
			String[] tpszDp04 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp04", length));
			String[] tpszDp03 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp03", length));
			String[] tpszDp09 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp09", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] tpszDp20 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp20", length));
			String[] tpszDp21 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp21", length));
			String[] tpszDp22 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp22", length));
			String[] tpszDp27 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp27", length));
			String[] tpszDp28 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp28", length));
			String[] tpszDp29 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp29", length));
			String[] tpszDp30 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp30", length));
			
			for (int i = 0; i < length; i++) {
				model = new SubLeaseOutSummaryVO();
				if (tpszDp19[i] != null)
					model.setTpszDp19(tpszDp19[i]);
				if (tpszDp18[i] != null)
					model.setTpszDp18(tpszDp18[i]);
				if (tpszDp17[i] != null)
					model.setTpszDp17(tpszDp17[i]);
				if (tpszDp16[i] != null)
					model.setTpszDp16(tpszDp16[i]);
				if (tpszTotal[i] != null)
					model.setTpszTotal(tpszTotal[i]);
				if (tpszDp15[i] != null)
					model.setTpszDp15(tpszDp15[i]);
				if (tpszDp14[i] != null)
					model.setTpszDp14(tpszDp14[i]);
				if (tpszDp13[i] != null)
					model.setTpszDp13(tpszDp13[i]);
				if (tpszDp12[i] != null)
					model.setTpszDp12(tpszDp12[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpszDp10[i] != null)
					model.setTpszDp10(tpszDp10[i]);
				if (tpszDp11[i] != null)
					model.setTpszDp11(tpszDp11[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (tpszDp24[i] != null)
					model.setTpszDp24(tpszDp24[i]);
				if (tpszDp06[i] != null)
					model.setTpszDp06(tpszDp06[i]);
				if (tpszDp23[i] != null)
					model.setTpszDp23(tpszDp23[i]);
				if (tpszDp05[i] != null)
					model.setTpszDp05(tpszDp05[i]);
				if (tpszDp26[i] != null)
					model.setTpszDp26(tpszDp26[i]);
				if (tpszDp08[i] != null)
					model.setTpszDp08(tpszDp08[i]);
				if (tpszDp25[i] != null)
					model.setTpszDp25(tpszDp25[i]);
				if (tpszDp07[i] != null)
					model.setTpszDp07(tpszDp07[i]);
				if (tpszDp02[i] != null)
					model.setTpszDp02(tpszDp02[i]);
				if (tpszDp01[i] != null)
					model.setTpszDp01(tpszDp01[i]);
				if (tpszDp04[i] != null)
					model.setTpszDp04(tpszDp04[i]);
				if (tpszDp03[i] != null)
					model.setTpszDp03(tpszDp03[i]);
				if (tpszDp09[i] != null)
					model.setTpszDp09(tpszDp09[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (tpszDp20[i] != null)
					model.setTpszDp20(tpszDp20[i]);
				if (tpszDp21[i] != null)
					model.setTpszDp21(tpszDp21[i]);
				if (tpszDp22[i] != null)
					model.setTpszDp22(tpszDp22[i]);
				if (tpszDp27[i] != null)
					model.setTpszDp27(tpszDp27[i]);
				if (tpszDp28[i] != null)
					model.setTpszDp28(tpszDp28[i]);
				if (tpszDp29[i] != null)
					model.setTpszDp29(tpszDp29[i]);
				if (tpszDp30[i] != null)
					model.setTpszDp30(tpszDp30[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSubLeaseOutSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SubLeaseOutSummaryVO[]
	 */
	public SubLeaseOutSummaryVO[] getSubLeaseOutSummaryVOs(){
		SubLeaseOutSummaryVO[] vos = (SubLeaseOutSummaryVO[])models.toArray(new SubLeaseOutSummaryVO[models.size()]);
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
		this.tpszDp19 = this.tpszDp19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp18 = this.tpszDp18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp17 = this.tpszDp17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp16 = this.tpszDp16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszTotal = this.tpszTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp15 = this.tpszDp15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp14 = this.tpszDp14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp13 = this.tpszDp13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp12 = this.tpszDp12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp10 = this.tpszDp10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp11 = this.tpszDp11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp24 = this.tpszDp24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp06 = this.tpszDp06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp23 = this.tpszDp23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp05 = this.tpszDp05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp26 = this.tpszDp26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp08 = this.tpszDp08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp25 = this.tpszDp25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp07 = this.tpszDp07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp02 = this.tpszDp02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp01 = this.tpszDp01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp04 = this.tpszDp04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp03 = this.tpszDp03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp09 = this.tpszDp09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp20 = this.tpszDp20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp21 = this.tpszDp21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp22 = this.tpszDp22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp27 = this.tpszDp27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp28 = this.tpszDp28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp29 = this.tpszDp29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp30 = this.tpszDp30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
