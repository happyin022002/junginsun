/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : REPOResultInGeneralVO.java
*@FileTitle : REPOResultInGeneralVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.26 박광석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo;

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

public class REPOResultInGeneralVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<REPOResultInGeneralVO> models = new ArrayList<REPOResultInGeneralVO>();
	
	/* Column Info */
	private String count20 = null;
	/* Column Info */
	private String count40 = null;
	/* Column Info */
	private String count22 = null;
	/* Column Info */
	private String counttotal = null;
	/* Column Info */
	private String count21 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String count06 = null;
	/* Column Info */
	private String count05 = null;
	/* Column Info */
	private String count08 = null;
	/* Column Info */
	private String loccode02 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String count07 = null;
	/* Column Info */
	private String loccode01 = null;
	/* Column Info */
	private String count02 = null;
	/* Column Info */
	private String count01 = null;
	/* Column Info */
	private String count04 = null;
	/* Column Info */
	private String count03 = null;
	/* Column Info */
	private String count23 = null;
	/* Column Info */
	private String count24 = null;
	/* Column Info */
	private String count25 = null;
	/* Column Info */
	private String count26 = null;
	/* Column Info */
	private String count27 = null;
	/* Column Info */
	private String count28 = null;
	/* Column Info */
	private String count09 = null;
	/* Column Info */
	private String count29 = null;
	/* Column Info */
	private String count33 = null;
	/* Column Info */
	private String count32 = null;
	/* Column Info */
	private String count31 = null;
	/* Column Info */
	private String count30 = null;
	/* Column Info */
	private String count10 = null;
	/* Column Info */
	private String count11 = null;
	/* Column Info */
	private String count19 = null;
	/* Column Info */
	private String count18 = null;
	/* Column Info */
	private String count17 = null;
	/* Column Info */
	private String count16 = null;
	/* Column Info */
	private String count15 = null;
	/* Column Info */
	private String count14 = null;
	/* Column Info */
	private String count13 = null;
	/* Column Info */
	private String count12 = null;
	/* Column Info */
	private String count36 = null;
	/* Column Info */
	private String count37 = null;
	/* Column Info */
	private String count34 = null;
	/* Column Info */
	private String count35 = null;
	/* Column Info */
	private String count38 = null;
	/* Column Info */
	private String count39 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public REPOResultInGeneralVO() {}

	/**
	 * 
	 * @param ibflag
	 * @param pagerows
	 * @param loccode01
	 * @param loccode02
	 * @param counttotal
	 * @param count01
	 * @param count02
	 * @param count03
	 * @param count04
	 * @param count05
	 * @param count06
	 * @param count07
	 * @param count08
	 * @param count09
	 * @param count10
	 * @param count11
	 * @param count12
	 * @param count13
	 * @param count14
	 * @param count15
	 * @param count16
	 * @param count17
	 * @param count18
	 * @param count19
	 * @param count20
	 * @param count21
	 * @param count22
	 * @param count23
	 * @param count24
	 * @param count25
	 * @param count26
	 * @param count27
	 * @param count28
	 * @param count29
	 * @param count30
	 * @param count31
	 * @param count32
	 * @param count33
	 * @param count34
	 * @param count35
	 * @param count36
	 * @param count37
	 * @param count38
	 * @param count39
	 * @param count40
	 */
	public REPOResultInGeneralVO(String ibflag, String pagerows, String loccode01, String loccode02, String counttotal, String count01, String count02, String count03, String count04, String count05, String count06, String count07, String count08, String count09, String count10, String count11, String count12, String count13, String count14, String count15, String count16, String count17, String count18, String count19, String count20, String count21, String count22, String count23, String count24, String count25, String count26, String count27, String count28, String count29, String count30, String count31, String count32, String count33, String count34, String count35, String count36, String count37, String count38, String count39, String count40) {
		this.count20 = count20;
		this.count40 = count40;
		this.count22 = count22;
		this.counttotal = counttotal;
		this.count21 = count21;
		this.pagerows = pagerows;
		this.count06 = count06;
		this.count05 = count05;
		this.count08 = count08;
		this.loccode02 = loccode02;
		this.ibflag = ibflag;
		this.count07 = count07;
		this.loccode01 = loccode01;
		this.count02 = count02;
		this.count01 = count01;
		this.count04 = count04;
		this.count03 = count03;
		this.count23 = count23;
		this.count24 = count24;
		this.count25 = count25;
		this.count26 = count26;
		this.count27 = count27;
		this.count28 = count28;
		this.count09 = count09;
		this.count29 = count29;
		this.count33 = count33;
		this.count32 = count32;
		this.count31 = count31;
		this.count30 = count30;
		this.count10 = count10;
		this.count11 = count11;
		this.count19 = count19;
		this.count18 = count18;
		this.count17 = count17;
		this.count16 = count16;
		this.count15 = count15;
		this.count14 = count14;
		this.count13 = count13;
		this.count12 = count12;
		this.count36 = count36;
		this.count37 = count37;
		this.count34 = count34;
		this.count35 = count35;
		this.count38 = count38;
		this.count39 = count39;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("count20", getCount20());
		this.hashColumns.put("count40", getCount40());
		this.hashColumns.put("count22", getCount22());
		this.hashColumns.put("counttotal", getCounttotal());
		this.hashColumns.put("count21", getCount21());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("count06", getCount06());
		this.hashColumns.put("count05", getCount05());
		this.hashColumns.put("count08", getCount08());
		this.hashColumns.put("loccode02", getLoccode02());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("count07", getCount07());
		this.hashColumns.put("loccode01", getLoccode01());
		this.hashColumns.put("count02", getCount02());
		this.hashColumns.put("count01", getCount01());
		this.hashColumns.put("count04", getCount04());
		this.hashColumns.put("count03", getCount03());
		this.hashColumns.put("count23", getCount23());
		this.hashColumns.put("count24", getCount24());
		this.hashColumns.put("count25", getCount25());
		this.hashColumns.put("count26", getCount26());
		this.hashColumns.put("count27", getCount27());
		this.hashColumns.put("count28", getCount28());
		this.hashColumns.put("count09", getCount09());
		this.hashColumns.put("count29", getCount29());
		this.hashColumns.put("count33", getCount33());
		this.hashColumns.put("count32", getCount32());
		this.hashColumns.put("count31", getCount31());
		this.hashColumns.put("count30", getCount30());
		this.hashColumns.put("count10", getCount10());
		this.hashColumns.put("count11", getCount11());
		this.hashColumns.put("count19", getCount19());
		this.hashColumns.put("count18", getCount18());
		this.hashColumns.put("count17", getCount17());
		this.hashColumns.put("count16", getCount16());
		this.hashColumns.put("count15", getCount15());
		this.hashColumns.put("count14", getCount14());
		this.hashColumns.put("count13", getCount13());
		this.hashColumns.put("count12", getCount12());
		this.hashColumns.put("count36", getCount36());
		this.hashColumns.put("count37", getCount37());
		this.hashColumns.put("count34", getCount34());
		this.hashColumns.put("count35", getCount35());
		this.hashColumns.put("count38", getCount38());
		this.hashColumns.put("count39", getCount39());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("count20", "count20");
		this.hashFields.put("count40", "count40");
		this.hashFields.put("count22", "count22");
		this.hashFields.put("counttotal", "counttotal");
		this.hashFields.put("count21", "count21");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("count06", "count06");
		this.hashFields.put("count05", "count05");
		this.hashFields.put("count08", "count08");
		this.hashFields.put("loccode02", "loccode02");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("count07", "count07");
		this.hashFields.put("loccode01", "loccode01");
		this.hashFields.put("count02", "count02");
		this.hashFields.put("count01", "count01");
		this.hashFields.put("count04", "count04");
		this.hashFields.put("count03", "count03");
		this.hashFields.put("count23", "count23");
		this.hashFields.put("count24", "count24");
		this.hashFields.put("count25", "count25");
		this.hashFields.put("count26", "count26");
		this.hashFields.put("count27", "count27");
		this.hashFields.put("count28", "count28");
		this.hashFields.put("count09", "count09");
		this.hashFields.put("count29", "count29");
		this.hashFields.put("count33", "count33");
		this.hashFields.put("count32", "count32");
		this.hashFields.put("count31", "count31");
		this.hashFields.put("count30", "count30");
		this.hashFields.put("count10", "count10");
		this.hashFields.put("count11", "count11");
		this.hashFields.put("count19", "count19");
		this.hashFields.put("count18", "count18");
		this.hashFields.put("count17", "count17");
		this.hashFields.put("count16", "count16");
		this.hashFields.put("count15", "count15");
		this.hashFields.put("count14", "count14");
		this.hashFields.put("count13", "count13");
		this.hashFields.put("count12", "count12");
		this.hashFields.put("count36", "count36");
		this.hashFields.put("count37", "count37");
		this.hashFields.put("count34", "count34");
		this.hashFields.put("count35", "count35");
		this.hashFields.put("count38", "count38");
		this.hashFields.put("count39", "count39");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return count20
	 */
	public String getCount20() {
		return this.count20;
	}
	
	/**
	 * Column Info
	 * @return count40
	 */
	public String getCount40() {
		return this.count40;
	}
	
	/**
	 * Column Info
	 * @return count22
	 */
	public String getCount22() {
		return this.count22;
	}
	
	/**
	 * Column Info
	 * @return counttotal
	 */
	public String getCounttotal() {
		return this.counttotal;
	}
	
	/**
	 * Column Info
	 * @return count21
	 */
	public String getCount21() {
		return this.count21;
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
	 * @return count06
	 */
	public String getCount06() {
		return this.count06;
	}
	
	/**
	 * Column Info
	 * @return count05
	 */
	public String getCount05() {
		return this.count05;
	}
	
	/**
	 * Column Info
	 * @return count08
	 */
	public String getCount08() {
		return this.count08;
	}
	
	/**
	 * Column Info
	 * @return loccode02
	 */
	public String getLoccode02() {
		return this.loccode02;
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
	 * @return count07
	 */
	public String getCount07() {
		return this.count07;
	}
	
	/**
	 * Column Info
	 * @return loccode01
	 */
	public String getLoccode01() {
		return this.loccode01;
	}
	
	/**
	 * Column Info
	 * @return count02
	 */
	public String getCount02() {
		return this.count02;
	}
	
	/**
	 * Column Info
	 * @return count01
	 */
	public String getCount01() {
		return this.count01;
	}
	
	/**
	 * Column Info
	 * @return count04
	 */
	public String getCount04() {
		return this.count04;
	}
	
	/**
	 * Column Info
	 * @return count03
	 */
	public String getCount03() {
		return this.count03;
	}
	
	/**
	 * Column Info
	 * @return count23
	 */
	public String getCount23() {
		return this.count23;
	}
	
	/**
	 * Column Info
	 * @return count24
	 */
	public String getCount24() {
		return this.count24;
	}
	
	/**
	 * Column Info
	 * @return count25
	 */
	public String getCount25() {
		return this.count25;
	}
	
	/**
	 * Column Info
	 * @return count26
	 */
	public String getCount26() {
		return this.count26;
	}
	
	/**
	 * Column Info
	 * @return count27
	 */
	public String getCount27() {
		return this.count27;
	}
	
	/**
	 * Column Info
	 * @return count28
	 */
	public String getCount28() {
		return this.count28;
	}
	
	/**
	 * Column Info
	 * @return count09
	 */
	public String getCount09() {
		return this.count09;
	}
	
	/**
	 * Column Info
	 * @return count29
	 */
	public String getCount29() {
		return this.count29;
	}
	
	/**
	 * Column Info
	 * @return count33
	 */
	public String getCount33() {
		return this.count33;
	}
	
	/**
	 * Column Info
	 * @return count32
	 */
	public String getCount32() {
		return this.count32;
	}
	
	/**
	 * Column Info
	 * @return count31
	 */
	public String getCount31() {
		return this.count31;
	}
	
	/**
	 * Column Info
	 * @return count30
	 */
	public String getCount30() {
		return this.count30;
	}
	
	/**
	 * Column Info
	 * @return count10
	 */
	public String getCount10() {
		return this.count10;
	}
	
	/**
	 * Column Info
	 * @return count11
	 */
	public String getCount11() {
		return this.count11;
	}
	
	/**
	 * Column Info
	 * @return count19
	 */
	public String getCount19() {
		return this.count19;
	}
	
	/**
	 * Column Info
	 * @return count18
	 */
	public String getCount18() {
		return this.count18;
	}
	
	/**
	 * Column Info
	 * @return count17
	 */
	public String getCount17() {
		return this.count17;
	}
	
	/**
	 * Column Info
	 * @return count16
	 */
	public String getCount16() {
		return this.count16;
	}
	
	/**
	 * Column Info
	 * @return count15
	 */
	public String getCount15() {
		return this.count15;
	}
	
	/**
	 * Column Info
	 * @return count14
	 */
	public String getCount14() {
		return this.count14;
	}
	
	/**
	 * Column Info
	 * @return count13
	 */
	public String getCount13() {
		return this.count13;
	}
	
	/**
	 * Column Info
	 * @return count12
	 */
	public String getCount12() {
		return this.count12;
	}
	
	/**
	 * Column Info
	 * @return count36
	 */
	public String getCount36() {
		return this.count36;
	}
	
	/**
	 * Column Info
	 * @return count37
	 */
	public String getCount37() {
		return this.count37;
	}
	
	/**
	 * Column Info
	 * @return count34
	 */
	public String getCount34() {
		return this.count34;
	}
	
	/**
	 * Column Info
	 * @return count35
	 */
	public String getCount35() {
		return this.count35;
	}
	
	/**
	 * Column Info
	 * @return count38
	 */
	public String getCount38() {
		return this.count38;
	}
	
	/**
	 * Column Info
	 * @return count39
	 */
	public String getCount39() {
		return this.count39;
	}
	

	/**
	 * Column Info
	 * @param count20
	 */
	public void setCount20(String count20) {
		this.count20 = count20;
	}
	
	/**
	 * Column Info
	 * @param count40
	 */
	public void setCount40(String count40) {
		this.count40 = count40;
	}
	
	/**
	 * Column Info
	 * @param count22
	 */
	public void setCount22(String count22) {
		this.count22 = count22;
	}
	
	/**
	 * Column Info
	 * @param counttotal
	 */
	public void setCounttotal(String counttotal) {
		this.counttotal = counttotal;
	}
	
	/**
	 * Column Info
	 * @param count21
	 */
	public void setCount21(String count21) {
		this.count21 = count21;
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
	 * @param count06
	 */
	public void setCount06(String count06) {
		this.count06 = count06;
	}
	
	/**
	 * Column Info
	 * @param count05
	 */
	public void setCount05(String count05) {
		this.count05 = count05;
	}
	
	/**
	 * Column Info
	 * @param count08
	 */
	public void setCount08(String count08) {
		this.count08 = count08;
	}
	
	/**
	 * Column Info
	 * @param loccode02
	 */
	public void setLoccode02(String loccode02) {
		this.loccode02 = loccode02;
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
	 * @param count07
	 */
	public void setCount07(String count07) {
		this.count07 = count07;
	}
	
	/**
	 * Column Info
	 * @param loccode01
	 */
	public void setLoccode01(String loccode01) {
		this.loccode01 = loccode01;
	}
	
	/**
	 * Column Info
	 * @param count02
	 */
	public void setCount02(String count02) {
		this.count02 = count02;
	}
	
	/**
	 * Column Info
	 * @param count01
	 */
	public void setCount01(String count01) {
		this.count01 = count01;
	}
	
	/**
	 * Column Info
	 * @param count04
	 */
	public void setCount04(String count04) {
		this.count04 = count04;
	}
	
	/**
	 * Column Info
	 * @param count03
	 */
	public void setCount03(String count03) {
		this.count03 = count03;
	}
	
	/**
	 * Column Info
	 * @param count23
	 */
	public void setCount23(String count23) {
		this.count23 = count23;
	}
	
	/**
	 * Column Info
	 * @param count24
	 */
	public void setCount24(String count24) {
		this.count24 = count24;
	}
	
	/**
	 * Column Info
	 * @param count25
	 */
	public void setCount25(String count25) {
		this.count25 = count25;
	}
	
	/**
	 * Column Info
	 * @param count26
	 */
	public void setCount26(String count26) {
		this.count26 = count26;
	}
	
	/**
	 * Column Info
	 * @param count27
	 */
	public void setCount27(String count27) {
		this.count27 = count27;
	}
	
	/**
	 * Column Info
	 * @param count28
	 */
	public void setCount28(String count28) {
		this.count28 = count28;
	}
	
	/**
	 * Column Info
	 * @param count09
	 */
	public void setCount09(String count09) {
		this.count09 = count09;
	}
	
	/**
	 * Column Info
	 * @param count29
	 */
	public void setCount29(String count29) {
		this.count29 = count29;
	}
	
	/**
	 * Column Info
	 * @param count33
	 */
	public void setCount33(String count33) {
		this.count33 = count33;
	}
	
	/**
	 * Column Info
	 * @param count32
	 */
	public void setCount32(String count32) {
		this.count32 = count32;
	}
	
	/**
	 * Column Info
	 * @param count31
	 */
	public void setCount31(String count31) {
		this.count31 = count31;
	}
	
	/**
	 * Column Info
	 * @param count30
	 */
	public void setCount30(String count30) {
		this.count30 = count30;
	}
	
	/**
	 * Column Info
	 * @param count10
	 */
	public void setCount10(String count10) {
		this.count10 = count10;
	}
	
	/**
	 * Column Info
	 * @param count11
	 */
	public void setCount11(String count11) {
		this.count11 = count11;
	}
	
	/**
	 * Column Info
	 * @param count19
	 */
	public void setCount19(String count19) {
		this.count19 = count19;
	}
	
	/**
	 * Column Info
	 * @param count18
	 */
	public void setCount18(String count18) {
		this.count18 = count18;
	}
	
	/**
	 * Column Info
	 * @param count17
	 */
	public void setCount17(String count17) {
		this.count17 = count17;
	}
	
	/**
	 * Column Info
	 * @param count16
	 */
	public void setCount16(String count16) {
		this.count16 = count16;
	}
	
	/**
	 * Column Info
	 * @param count15
	 */
	public void setCount15(String count15) {
		this.count15 = count15;
	}
	
	/**
	 * Column Info
	 * @param count14
	 */
	public void setCount14(String count14) {
		this.count14 = count14;
	}
	
	/**
	 * Column Info
	 * @param count13
	 */
	public void setCount13(String count13) {
		this.count13 = count13;
	}
	
	/**
	 * Column Info
	 * @param count12
	 */
	public void setCount12(String count12) {
		this.count12 = count12;
	}
	
	/**
	 * Column Info
	 * @param count36
	 */
	public void setCount36(String count36) {
		this.count36 = count36;
	}
	
	/**
	 * Column Info
	 * @param count37
	 */
	public void setCount37(String count37) {
		this.count37 = count37;
	}
	
	/**
	 * Column Info
	 * @param count34
	 */
	public void setCount34(String count34) {
		this.count34 = count34;
	}
	
	/**
	 * Column Info
	 * @param count35
	 */
	public void setCount35(String count35) {
		this.count35 = count35;
	}
	
	/**
	 * Column Info
	 * @param count38
	 */
	public void setCount38(String count38) {
		this.count38 = count38;
	}
	
	/**
	 * Column Info
	 * @param count39
	 */
	public void setCount39(String count39) {
		this.count39 = count39;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCount20(JSPUtil.getParameter(request, "count20", ""));
		setCount40(JSPUtil.getParameter(request, "count40", ""));
		setCount22(JSPUtil.getParameter(request, "count22", ""));
		setCounttotal(JSPUtil.getParameter(request, "counttotal", ""));
		setCount21(JSPUtil.getParameter(request, "count21", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCount06(JSPUtil.getParameter(request, "count06", ""));
		setCount05(JSPUtil.getParameter(request, "count05", ""));
		setCount08(JSPUtil.getParameter(request, "count08", ""));
		setLoccode02(JSPUtil.getParameter(request, "loccode02", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCount07(JSPUtil.getParameter(request, "count07", ""));
		setLoccode01(JSPUtil.getParameter(request, "loccode01", ""));
		setCount02(JSPUtil.getParameter(request, "count02", ""));
		setCount01(JSPUtil.getParameter(request, "count01", ""));
		setCount04(JSPUtil.getParameter(request, "count04", ""));
		setCount03(JSPUtil.getParameter(request, "count03", ""));
		setCount23(JSPUtil.getParameter(request, "count23", ""));
		setCount24(JSPUtil.getParameter(request, "count24", ""));
		setCount25(JSPUtil.getParameter(request, "count25", ""));
		setCount26(JSPUtil.getParameter(request, "count26", ""));
		setCount27(JSPUtil.getParameter(request, "count27", ""));
		setCount28(JSPUtil.getParameter(request, "count28", ""));
		setCount09(JSPUtil.getParameter(request, "count09", ""));
		setCount29(JSPUtil.getParameter(request, "count29", ""));
		setCount33(JSPUtil.getParameter(request, "count33", ""));
		setCount32(JSPUtil.getParameter(request, "count32", ""));
		setCount31(JSPUtil.getParameter(request, "count31", ""));
		setCount30(JSPUtil.getParameter(request, "count30", ""));
		setCount10(JSPUtil.getParameter(request, "count10", ""));
		setCount11(JSPUtil.getParameter(request, "count11", ""));
		setCount19(JSPUtil.getParameter(request, "count19", ""));
		setCount18(JSPUtil.getParameter(request, "count18", ""));
		setCount17(JSPUtil.getParameter(request, "count17", ""));
		setCount16(JSPUtil.getParameter(request, "count16", ""));
		setCount15(JSPUtil.getParameter(request, "count15", ""));
		setCount14(JSPUtil.getParameter(request, "count14", ""));
		setCount13(JSPUtil.getParameter(request, "count13", ""));
		setCount12(JSPUtil.getParameter(request, "count12", ""));
		setCount36(JSPUtil.getParameter(request, "count36", ""));
		setCount37(JSPUtil.getParameter(request, "count37", ""));
		setCount34(JSPUtil.getParameter(request, "count34", ""));
		setCount35(JSPUtil.getParameter(request, "count35", ""));
		setCount38(JSPUtil.getParameter(request, "count38", ""));
		setCount39(JSPUtil.getParameter(request, "count39", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return REPOResultInGeneralVO[]
	 */
	public REPOResultInGeneralVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return REPOResultInGeneralVO[]
	 */
	public REPOResultInGeneralVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		REPOResultInGeneralVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] count20 = (JSPUtil.getParameter(request, prefix	+ "count20".trim(), length));
			String[] count40 = (JSPUtil.getParameter(request, prefix	+ "count40".trim(), length));
			String[] count22 = (JSPUtil.getParameter(request, prefix	+ "count22".trim(), length));
			String[] counttotal = (JSPUtil.getParameter(request, prefix	+ "counttotal".trim(), length));
			String[] count21 = (JSPUtil.getParameter(request, prefix	+ "count21".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] count06 = (JSPUtil.getParameter(request, prefix	+ "count06".trim(), length));
			String[] count05 = (JSPUtil.getParameter(request, prefix	+ "count05".trim(), length));
			String[] count08 = (JSPUtil.getParameter(request, prefix	+ "count08".trim(), length));
			String[] loccode02 = (JSPUtil.getParameter(request, prefix	+ "loccode02".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] count07 = (JSPUtil.getParameter(request, prefix	+ "count07".trim(), length));
			String[] loccode01 = (JSPUtil.getParameter(request, prefix	+ "loccode01".trim(), length));
			String[] count02 = (JSPUtil.getParameter(request, prefix	+ "count02".trim(), length));
			String[] count01 = (JSPUtil.getParameter(request, prefix	+ "count01".trim(), length));
			String[] count04 = (JSPUtil.getParameter(request, prefix	+ "count04".trim(), length));
			String[] count03 = (JSPUtil.getParameter(request, prefix	+ "count03".trim(), length));
			String[] count23 = (JSPUtil.getParameter(request, prefix	+ "count23".trim(), length));
			String[] count24 = (JSPUtil.getParameter(request, prefix	+ "count24".trim(), length));
			String[] count25 = (JSPUtil.getParameter(request, prefix	+ "count25".trim(), length));
			String[] count26 = (JSPUtil.getParameter(request, prefix	+ "count26".trim(), length));
			String[] count27 = (JSPUtil.getParameter(request, prefix	+ "count27".trim(), length));
			String[] count28 = (JSPUtil.getParameter(request, prefix	+ "count28".trim(), length));
			String[] count09 = (JSPUtil.getParameter(request, prefix	+ "count09".trim(), length));
			String[] count29 = (JSPUtil.getParameter(request, prefix	+ "count29".trim(), length));
			String[] count33 = (JSPUtil.getParameter(request, prefix	+ "count33".trim(), length));
			String[] count32 = (JSPUtil.getParameter(request, prefix	+ "count32".trim(), length));
			String[] count31 = (JSPUtil.getParameter(request, prefix	+ "count31".trim(), length));
			String[] count30 = (JSPUtil.getParameter(request, prefix	+ "count30".trim(), length));
			String[] count10 = (JSPUtil.getParameter(request, prefix	+ "count10".trim(), length));
			String[] count11 = (JSPUtil.getParameter(request, prefix	+ "count11".trim(), length));
			String[] count19 = (JSPUtil.getParameter(request, prefix	+ "count19".trim(), length));
			String[] count18 = (JSPUtil.getParameter(request, prefix	+ "count18".trim(), length));
			String[] count17 = (JSPUtil.getParameter(request, prefix	+ "count17".trim(), length));
			String[] count16 = (JSPUtil.getParameter(request, prefix	+ "count16".trim(), length));
			String[] count15 = (JSPUtil.getParameter(request, prefix	+ "count15".trim(), length));
			String[] count14 = (JSPUtil.getParameter(request, prefix	+ "count14".trim(), length));
			String[] count13 = (JSPUtil.getParameter(request, prefix	+ "count13".trim(), length));
			String[] count12 = (JSPUtil.getParameter(request, prefix	+ "count12".trim(), length));
			String[] count36 = (JSPUtil.getParameter(request, prefix	+ "count36".trim(), length));
			String[] count37 = (JSPUtil.getParameter(request, prefix	+ "count37".trim(), length));
			String[] count34 = (JSPUtil.getParameter(request, prefix	+ "count34".trim(), length));
			String[] count35 = (JSPUtil.getParameter(request, prefix	+ "count35".trim(), length));
			String[] count38 = (JSPUtil.getParameter(request, prefix	+ "count38".trim(), length));
			String[] count39 = (JSPUtil.getParameter(request, prefix	+ "count39".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new REPOResultInGeneralVO();
				if (count20[i] != null)
					model.setCount20(count20[i]);
				if (count40[i] != null)
					model.setCount40(count40[i]);
				if (count22[i] != null)
					model.setCount22(count22[i]);
				if (counttotal[i] != null)
					model.setCounttotal(counttotal[i]);
				if (count21[i] != null)
					model.setCount21(count21[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (count06[i] != null)
					model.setCount06(count06[i]);
				if (count05[i] != null)
					model.setCount05(count05[i]);
				if (count08[i] != null)
					model.setCount08(count08[i]);
				if (loccode02[i] != null)
					model.setLoccode02(loccode02[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (count07[i] != null)
					model.setCount07(count07[i]);
				if (loccode01[i] != null)
					model.setLoccode01(loccode01[i]);
				if (count02[i] != null)
					model.setCount02(count02[i]);
				if (count01[i] != null)
					model.setCount01(count01[i]);
				if (count04[i] != null)
					model.setCount04(count04[i]);
				if (count03[i] != null)
					model.setCount03(count03[i]);
				if (count23[i] != null)
					model.setCount23(count23[i]);
				if (count24[i] != null)
					model.setCount24(count24[i]);
				if (count25[i] != null)
					model.setCount25(count25[i]);
				if (count26[i] != null)
					model.setCount26(count26[i]);
				if (count27[i] != null)
					model.setCount27(count27[i]);
				if (count28[i] != null)
					model.setCount28(count28[i]);
				if (count09[i] != null)
					model.setCount09(count09[i]);
				if (count29[i] != null)
					model.setCount29(count29[i]);
				if (count33[i] != null)
					model.setCount33(count33[i]);
				if (count32[i] != null)
					model.setCount32(count32[i]);
				if (count31[i] != null)
					model.setCount31(count31[i]);
				if (count30[i] != null)
					model.setCount30(count30[i]);
				if (count10[i] != null)
					model.setCount10(count10[i]);
				if (count11[i] != null)
					model.setCount11(count11[i]);
				if (count19[i] != null)
					model.setCount19(count19[i]);
				if (count18[i] != null)
					model.setCount18(count18[i]);
				if (count17[i] != null)
					model.setCount17(count17[i]);
				if (count16[i] != null)
					model.setCount16(count16[i]);
				if (count15[i] != null)
					model.setCount15(count15[i]);
				if (count14[i] != null)
					model.setCount14(count14[i]);
				if (count13[i] != null)
					model.setCount13(count13[i]);
				if (count12[i] != null)
					model.setCount12(count12[i]);
				if (count36[i] != null)
					model.setCount36(count36[i]);
				if (count37[i] != null)
					model.setCount37(count37[i]);
				if (count34[i] != null)
					model.setCount34(count34[i]);
				if (count35[i] != null)
					model.setCount35(count35[i]);
				if (count38[i] != null)
					model.setCount38(count38[i]);
				if (count39[i] != null)
					model.setCount39(count39[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getREPOResultInGeneralVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return REPOResultInGeneralVO[]
	 */
	public REPOResultInGeneralVO[] getREPOResultInGeneralVOs(){
		REPOResultInGeneralVO[] vos = (REPOResultInGeneralVO[])models.toArray(new REPOResultInGeneralVO[models.size()]);
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
		this.count20 = this.count20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count40 = this.count40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count22 = this.count22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.counttotal = this.counttotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count21 = this.count21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count06 = this.count06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count05 = this.count05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count08 = this.count08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loccode02 = this.loccode02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count07 = this.count07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loccode01 = this.loccode01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count02 = this.count02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count01 = this.count01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count04 = this.count04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count03 = this.count03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count23 = this.count23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count24 = this.count24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count25 = this.count25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count26 = this.count26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count27 = this.count27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count28 = this.count28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count09 = this.count09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count29 = this.count29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count33 = this.count33 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count32 = this.count32 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count31 = this.count31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count30 = this.count30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count10 = this.count10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count11 = this.count11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count19 = this.count19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count18 = this.count18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count17 = this.count17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count16 = this.count16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count15 = this.count15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count14 = this.count14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count13 = this.count13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count12 = this.count12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count36 = this.count36 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count37 = this.count37 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count34 = this.count34 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count35 = this.count35 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count38 = this.count38 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count39 = this.count39 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
