/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EdiJapanCommonVO.java
*@FileTitle : EdiJapanCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.06  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EdiJapanCommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EdiJapanCommonVO> models = new ArrayList<EdiJapanCommonVO>();
	
	/* Column Info */
	private String data19 = null;
	/* Column Info */
	private String data17 = null;
	/* Column Info */
	private String data18 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String data12 = null;
	/* Column Info */
	private String data11 = null;
	/* Column Info */
	private String data10 = null;
	/* Column Info */
	private String data16 = null;
	/* Column Info */
	private String data15 = null;
	/* Column Info */
	private String data14 = null;
	/* Column Info */
	private String data50 = null;
	/* Column Info */
	private String data13 = null;
	/* Column Info */
	private String data28 = null;
	/* Column Info */
	private String data29 = null;
	/* Column Info */
	private String data21 = null;
	/* Column Info */
	private String data20 = null;
	/* Column Info */
	private String data23 = null;
	/* Column Info */
	private String data22 = null;
	/* Column Info */
	private String data25 = null;
	/* Column Info */
	private String data24 = null;
	/* Column Info */
	private String data27 = null;
	/* Column Info */
	private String data26 = null;
	/* Column Info */
	private String data39 = null;
	/* Column Info */
	private String data30 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String data37 = null;
	/* Column Info */
	private String data38 = null;
	/* Column Info */
	private String data35 = null;
	/* Column Info */
	private String data36 = null;
	/* Column Info */
	private String data33 = null;
	/* Column Info */
	private String data34 = null;
	/* Column Info */
	private String data31 = null;
	/* Column Info */
	private String data32 = null;
	/* Column Info */
	private String data06 = null;
	/* Column Info */
	private String data07 = null;
	/* Column Info */
	private String data08 = null;
	/* Column Info */
	private String data09 = null;
	/* Column Info */
	private String data03 = null;
	/* Column Info */
	private String data02 = null;
	/* Column Info */
	private String data05 = null;
	/* Column Info */
	private String data40 = null;
	/* Column Info */
	private String data04 = null;
	/* Column Info */
	private String data41 = null;
	/* Column Info */
	private String data01 = null;
	/* Column Info */
	private String data00 = null;
	/* Column Info */
	private String data46 = null;
	/* Column Info */
	private String data47 = null;
	/* Column Info */
	private String data48 = null;
	/* Column Info */
	private String data49 = null;
	/* Column Info */
	private String data42 = null;
	/* Column Info */
	private String data44 = null;
	/* Column Info */
	private String data45 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EdiJapanCommonVO() {}

	public EdiJapanCommonVO(String ibflag, String pagerows, String data00, String data01, String data02, String data03, String data04, String data05, String data06, String data07, String data08, String data09, String data10, String data11, String data12, String data13, String data14, String data15, String data16, String data17, String data18, String data19, String data20, String data21, String data22, String data23, String data24, String data25, String data26, String data27, String data28, String data29, String data30, String data31, String data32, String data33, String data34, String data35, String data36, String data37, String data38, String data39, String data40, String data41, String data42, String data44, String data45, String data46, String data47, String data48, String data49, String data50) {
		this.data19 = data19;
		this.data17 = data17;
		this.data18 = data18;
		this.pagerows = pagerows;
		this.data12 = data12;
		this.data11 = data11;
		this.data10 = data10;
		this.data16 = data16;
		this.data15 = data15;
		this.data14 = data14;
		this.data50 = data50;
		this.data13 = data13;
		this.data28 = data28;
		this.data29 = data29;
		this.data21 = data21;
		this.data20 = data20;
		this.data23 = data23;
		this.data22 = data22;
		this.data25 = data25;
		this.data24 = data24;
		this.data27 = data27;
		this.data26 = data26;
		this.data39 = data39;
		this.data30 = data30;
		this.ibflag = ibflag;
		this.data37 = data37;
		this.data38 = data38;
		this.data35 = data35;
		this.data36 = data36;
		this.data33 = data33;
		this.data34 = data34;
		this.data31 = data31;
		this.data32 = data32;
		this.data06 = data06;
		this.data07 = data07;
		this.data08 = data08;
		this.data09 = data09;
		this.data03 = data03;
		this.data02 = data02;
		this.data05 = data05;
		this.data40 = data40;
		this.data04 = data04;
		this.data41 = data41;
		this.data01 = data01;
		this.data00 = data00;
		this.data46 = data46;
		this.data47 = data47;
		this.data48 = data48;
		this.data49 = data49;
		this.data42 = data42;
		this.data44 = data44;
		this.data45 = data45;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("data19", getData19());
		this.hashColumns.put("data17", getData17());
		this.hashColumns.put("data18", getData18());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("data12", getData12());
		this.hashColumns.put("data11", getData11());
		this.hashColumns.put("data10", getData10());
		this.hashColumns.put("data16", getData16());
		this.hashColumns.put("data15", getData15());
		this.hashColumns.put("data14", getData14());
		this.hashColumns.put("data50", getData50());
		this.hashColumns.put("data13", getData13());
		this.hashColumns.put("data28", getData28());
		this.hashColumns.put("data29", getData29());
		this.hashColumns.put("data21", getData21());
		this.hashColumns.put("data20", getData20());
		this.hashColumns.put("data23", getData23());
		this.hashColumns.put("data22", getData22());
		this.hashColumns.put("data25", getData25());
		this.hashColumns.put("data24", getData24());
		this.hashColumns.put("data27", getData27());
		this.hashColumns.put("data26", getData26());
		this.hashColumns.put("data39", getData39());
		this.hashColumns.put("data30", getData30());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("data37", getData37());
		this.hashColumns.put("data38", getData38());
		this.hashColumns.put("data35", getData35());
		this.hashColumns.put("data36", getData36());
		this.hashColumns.put("data33", getData33());
		this.hashColumns.put("data34", getData34());
		this.hashColumns.put("data31", getData31());
		this.hashColumns.put("data32", getData32());
		this.hashColumns.put("data06", getData06());
		this.hashColumns.put("data07", getData07());
		this.hashColumns.put("data08", getData08());
		this.hashColumns.put("data09", getData09());
		this.hashColumns.put("data03", getData03());
		this.hashColumns.put("data02", getData02());
		this.hashColumns.put("data05", getData05());
		this.hashColumns.put("data40", getData40());
		this.hashColumns.put("data04", getData04());
		this.hashColumns.put("data41", getData41());
		this.hashColumns.put("data01", getData01());
		this.hashColumns.put("data00", getData00());
		this.hashColumns.put("data46", getData46());
		this.hashColumns.put("data47", getData47());
		this.hashColumns.put("data48", getData48());
		this.hashColumns.put("data49", getData49());
		this.hashColumns.put("data42", getData42());
		this.hashColumns.put("data44", getData44());
		this.hashColumns.put("data45", getData45());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("data19", "data19");
		this.hashFields.put("data17", "data17");
		this.hashFields.put("data18", "data18");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("data12", "data12");
		this.hashFields.put("data11", "data11");
		this.hashFields.put("data10", "data10");
		this.hashFields.put("data16", "data16");
		this.hashFields.put("data15", "data15");
		this.hashFields.put("data14", "data14");
		this.hashFields.put("data50", "data50");
		this.hashFields.put("data13", "data13");
		this.hashFields.put("data28", "data28");
		this.hashFields.put("data29", "data29");
		this.hashFields.put("data21", "data21");
		this.hashFields.put("data20", "data20");
		this.hashFields.put("data23", "data23");
		this.hashFields.put("data22", "data22");
		this.hashFields.put("data25", "data25");
		this.hashFields.put("data24", "data24");
		this.hashFields.put("data27", "data27");
		this.hashFields.put("data26", "data26");
		this.hashFields.put("data39", "data39");
		this.hashFields.put("data30", "data30");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("data37", "data37");
		this.hashFields.put("data38", "data38");
		this.hashFields.put("data35", "data35");
		this.hashFields.put("data36", "data36");
		this.hashFields.put("data33", "data33");
		this.hashFields.put("data34", "data34");
		this.hashFields.put("data31", "data31");
		this.hashFields.put("data32", "data32");
		this.hashFields.put("data06", "data06");
		this.hashFields.put("data07", "data07");
		this.hashFields.put("data08", "data08");
		this.hashFields.put("data09", "data09");
		this.hashFields.put("data03", "data03");
		this.hashFields.put("data02", "data02");
		this.hashFields.put("data05", "data05");
		this.hashFields.put("data40", "data40");
		this.hashFields.put("data04", "data04");
		this.hashFields.put("data41", "data41");
		this.hashFields.put("data01", "data01");
		this.hashFields.put("data00", "data00");
		this.hashFields.put("data46", "data46");
		this.hashFields.put("data47", "data47");
		this.hashFields.put("data48", "data48");
		this.hashFields.put("data49", "data49");
		this.hashFields.put("data42", "data42");
		this.hashFields.put("data44", "data44");
		this.hashFields.put("data45", "data45");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return data19
	 */
	public String getData19() {
		return this.data19;
	}
	
	/**
	 * Column Info
	 * @return data17
	 */
	public String getData17() {
		return this.data17;
	}
	
	/**
	 * Column Info
	 * @return data18
	 */
	public String getData18() {
		return this.data18;
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
	 * @return data12
	 */
	public String getData12() {
		return this.data12;
	}
	
	/**
	 * Column Info
	 * @return data11
	 */
	public String getData11() {
		return this.data11;
	}
	
	/**
	 * Column Info
	 * @return data10
	 */
	public String getData10() {
		return this.data10;
	}
	
	/**
	 * Column Info
	 * @return data16
	 */
	public String getData16() {
		return this.data16;
	}
	
	/**
	 * Column Info
	 * @return data15
	 */
	public String getData15() {
		return this.data15;
	}
	
	/**
	 * Column Info
	 * @return data14
	 */
	public String getData14() {
		return this.data14;
	}
	
	/**
	 * Column Info
	 * @return data50
	 */
	public String getData50() {
		return this.data50;
	}
	
	/**
	 * Column Info
	 * @return data13
	 */
	public String getData13() {
		return this.data13;
	}
	
	/**
	 * Column Info
	 * @return data28
	 */
	public String getData28() {
		return this.data28;
	}
	
	/**
	 * Column Info
	 * @return data29
	 */
	public String getData29() {
		return this.data29;
	}
	
	/**
	 * Column Info
	 * @return data21
	 */
	public String getData21() {
		return this.data21;
	}
	
	/**
	 * Column Info
	 * @return data20
	 */
	public String getData20() {
		return this.data20;
	}
	
	/**
	 * Column Info
	 * @return data23
	 */
	public String getData23() {
		return this.data23;
	}
	
	/**
	 * Column Info
	 * @return data22
	 */
	public String getData22() {
		return this.data22;
	}
	
	/**
	 * Column Info
	 * @return data25
	 */
	public String getData25() {
		return this.data25;
	}
	
	/**
	 * Column Info
	 * @return data24
	 */
	public String getData24() {
		return this.data24;
	}
	
	/**
	 * Column Info
	 * @return data27
	 */
	public String getData27() {
		return this.data27;
	}
	
	/**
	 * Column Info
	 * @return data26
	 */
	public String getData26() {
		return this.data26;
	}
	
	/**
	 * Column Info
	 * @return data39
	 */
	public String getData39() {
		return this.data39;
	}
	
	/**
	 * Column Info
	 * @return data30
	 */
	public String getData30() {
		return this.data30;
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
	 * @return data37
	 */
	public String getData37() {
		return this.data37;
	}
	
	/**
	 * Column Info
	 * @return data38
	 */
	public String getData38() {
		return this.data38;
	}
	
	/**
	 * Column Info
	 * @return data35
	 */
	public String getData35() {
		return this.data35;
	}
	
	/**
	 * Column Info
	 * @return data36
	 */
	public String getData36() {
		return this.data36;
	}
	
	/**
	 * Column Info
	 * @return data33
	 */
	public String getData33() {
		return this.data33;
	}
	
	/**
	 * Column Info
	 * @return data34
	 */
	public String getData34() {
		return this.data34;
	}
	
	/**
	 * Column Info
	 * @return data31
	 */
	public String getData31() {
		return this.data31;
	}
	
	/**
	 * Column Info
	 * @return data32
	 */
	public String getData32() {
		return this.data32;
	}
	
	/**
	 * Column Info
	 * @return data06
	 */
	public String getData06() {
		return this.data06;
	}
	
	/**
	 * Column Info
	 * @return data07
	 */
	public String getData07() {
		return this.data07;
	}
	
	/**
	 * Column Info
	 * @return data08
	 */
	public String getData08() {
		return this.data08;
	}
	
	/**
	 * Column Info
	 * @return data09
	 */
	public String getData09() {
		return this.data09;
	}
	
	/**
	 * Column Info
	 * @return data03
	 */
	public String getData03() {
		return this.data03;
	}
	
	/**
	 * Column Info
	 * @return data02
	 */
	public String getData02() {
		return this.data02;
	}
	
	/**
	 * Column Info
	 * @return data05
	 */
	public String getData05() {
		return this.data05;
	}
	
	/**
	 * Column Info
	 * @return data40
	 */
	public String getData40() {
		return this.data40;
	}
	
	/**
	 * Column Info
	 * @return data04
	 */
	public String getData04() {
		return this.data04;
	}
	
	/**
	 * Column Info
	 * @return data41
	 */
	public String getData41() {
		return this.data41;
	}
	
	/**
	 * Column Info
	 * @return data01
	 */
	public String getData01() {
		return this.data01;
	}
	
	/**
	 * Column Info
	 * @return data00
	 */
	public String getData00() {
		return this.data00;
	}
	
	/**
	 * Column Info
	 * @return data46
	 */
	public String getData46() {
		return this.data46;
	}
	
	/**
	 * Column Info
	 * @return data47
	 */
	public String getData47() {
		return this.data47;
	}
	
	/**
	 * Column Info
	 * @return data48
	 */
	public String getData48() {
		return this.data48;
	}
	
	/**
	 * Column Info
	 * @return data49
	 */
	public String getData49() {
		return this.data49;
	}
	
	/**
	 * Column Info
	 * @return data42
	 */
	public String getData42() {
		return this.data42;
	}
	
	/**
	 * Column Info
	 * @return data44
	 */
	public String getData44() {
		return this.data44;
	}
	
	/**
	 * Column Info
	 * @return data45
	 */
	public String getData45() {
		return this.data45;
	}
	

	/**
	 * Column Info
	 * @param data19
	 */
	public void setData19(String data19) {
		this.data19 = data19;
	}
	
	/**
	 * Column Info
	 * @param data17
	 */
	public void setData17(String data17) {
		this.data17 = data17;
	}
	
	/**
	 * Column Info
	 * @param data18
	 */
	public void setData18(String data18) {
		this.data18 = data18;
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
	 * @param data12
	 */
	public void setData12(String data12) {
		this.data12 = data12;
	}
	
	/**
	 * Column Info
	 * @param data11
	 */
	public void setData11(String data11) {
		this.data11 = data11;
	}
	
	/**
	 * Column Info
	 * @param data10
	 */
	public void setData10(String data10) {
		this.data10 = data10;
	}
	
	/**
	 * Column Info
	 * @param data16
	 */
	public void setData16(String data16) {
		this.data16 = data16;
	}
	
	/**
	 * Column Info
	 * @param data15
	 */
	public void setData15(String data15) {
		this.data15 = data15;
	}
	
	/**
	 * Column Info
	 * @param data14
	 */
	public void setData14(String data14) {
		this.data14 = data14;
	}
	
	/**
	 * Column Info
	 * @param data50
	 */
	public void setData50(String data50) {
		this.data50 = data50;
	}
	
	/**
	 * Column Info
	 * @param data13
	 */
	public void setData13(String data13) {
		this.data13 = data13;
	}
	
	/**
	 * Column Info
	 * @param data28
	 */
	public void setData28(String data28) {
		this.data28 = data28;
	}
	
	/**
	 * Column Info
	 * @param data29
	 */
	public void setData29(String data29) {
		this.data29 = data29;
	}
	
	/**
	 * Column Info
	 * @param data21
	 */
	public void setData21(String data21) {
		this.data21 = data21;
	}
	
	/**
	 * Column Info
	 * @param data20
	 */
	public void setData20(String data20) {
		this.data20 = data20;
	}
	
	/**
	 * Column Info
	 * @param data23
	 */
	public void setData23(String data23) {
		this.data23 = data23;
	}
	
	/**
	 * Column Info
	 * @param data22
	 */
	public void setData22(String data22) {
		this.data22 = data22;
	}
	
	/**
	 * Column Info
	 * @param data25
	 */
	public void setData25(String data25) {
		this.data25 = data25;
	}
	
	/**
	 * Column Info
	 * @param data24
	 */
	public void setData24(String data24) {
		this.data24 = data24;
	}
	
	/**
	 * Column Info
	 * @param data27
	 */
	public void setData27(String data27) {
		this.data27 = data27;
	}
	
	/**
	 * Column Info
	 * @param data26
	 */
	public void setData26(String data26) {
		this.data26 = data26;
	}
	
	/**
	 * Column Info
	 * @param data39
	 */
	public void setData39(String data39) {
		this.data39 = data39;
	}
	
	/**
	 * Column Info
	 * @param data30
	 */
	public void setData30(String data30) {
		this.data30 = data30;
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
	 * @param data37
	 */
	public void setData37(String data37) {
		this.data37 = data37;
	}
	
	/**
	 * Column Info
	 * @param data38
	 */
	public void setData38(String data38) {
		this.data38 = data38;
	}
	
	/**
	 * Column Info
	 * @param data35
	 */
	public void setData35(String data35) {
		this.data35 = data35;
	}
	
	/**
	 * Column Info
	 * @param data36
	 */
	public void setData36(String data36) {
		this.data36 = data36;
	}
	
	/**
	 * Column Info
	 * @param data33
	 */
	public void setData33(String data33) {
		this.data33 = data33;
	}
	
	/**
	 * Column Info
	 * @param data34
	 */
	public void setData34(String data34) {
		this.data34 = data34;
	}
	
	/**
	 * Column Info
	 * @param data31
	 */
	public void setData31(String data31) {
		this.data31 = data31;
	}
	
	/**
	 * Column Info
	 * @param data32
	 */
	public void setData32(String data32) {
		this.data32 = data32;
	}
	
	/**
	 * Column Info
	 * @param data06
	 */
	public void setData06(String data06) {
		this.data06 = data06;
	}
	
	/**
	 * Column Info
	 * @param data07
	 */
	public void setData07(String data07) {
		this.data07 = data07;
	}
	
	/**
	 * Column Info
	 * @param data08
	 */
	public void setData08(String data08) {
		this.data08 = data08;
	}
	
	/**
	 * Column Info
	 * @param data09
	 */
	public void setData09(String data09) {
		this.data09 = data09;
	}
	
	/**
	 * Column Info
	 * @param data03
	 */
	public void setData03(String data03) {
		this.data03 = data03;
	}
	
	/**
	 * Column Info
	 * @param data02
	 */
	public void setData02(String data02) {
		this.data02 = data02;
	}
	
	/**
	 * Column Info
	 * @param data05
	 */
	public void setData05(String data05) {
		this.data05 = data05;
	}
	
	/**
	 * Column Info
	 * @param data40
	 */
	public void setData40(String data40) {
		this.data40 = data40;
	}
	
	/**
	 * Column Info
	 * @param data04
	 */
	public void setData04(String data04) {
		this.data04 = data04;
	}
	
	/**
	 * Column Info
	 * @param data41
	 */
	public void setData41(String data41) {
		this.data41 = data41;
	}
	
	/**
	 * Column Info
	 * @param data01
	 */
	public void setData01(String data01) {
		this.data01 = data01;
	}
	
	/**
	 * Column Info
	 * @param data00
	 */
	public void setData00(String data00) {
		this.data00 = data00;
	}
	
	/**
	 * Column Info
	 * @param data46
	 */
	public void setData46(String data46) {
		this.data46 = data46;
	}
	
	/**
	 * Column Info
	 * @param data47
	 */
	public void setData47(String data47) {
		this.data47 = data47;
	}
	
	/**
	 * Column Info
	 * @param data48
	 */
	public void setData48(String data48) {
		this.data48 = data48;
	}
	
	/**
	 * Column Info
	 * @param data49
	 */
	public void setData49(String data49) {
		this.data49 = data49;
	}
	
	/**
	 * Column Info
	 * @param data42
	 */
	public void setData42(String data42) {
		this.data42 = data42;
	}
	
	/**
	 * Column Info
	 * @param data44
	 */
	public void setData44(String data44) {
		this.data44 = data44;
	}
	
	/**
	 * Column Info
	 * @param data45
	 */
	public void setData45(String data45) {
		this.data45 = data45;
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
		setData19(JSPUtil.getParameter(request, prefix + "data19", ""));
		setData17(JSPUtil.getParameter(request, prefix + "data17", ""));
		setData18(JSPUtil.getParameter(request, prefix + "data18", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setData12(JSPUtil.getParameter(request, prefix + "data12", ""));
		setData11(JSPUtil.getParameter(request, prefix + "data11", ""));
		setData10(JSPUtil.getParameter(request, prefix + "data10", ""));
		setData16(JSPUtil.getParameter(request, prefix + "data16", ""));
		setData15(JSPUtil.getParameter(request, prefix + "data15", ""));
		setData14(JSPUtil.getParameter(request, prefix + "data14", ""));
		setData50(JSPUtil.getParameter(request, prefix + "data50", ""));
		setData13(JSPUtil.getParameter(request, prefix + "data13", ""));
		setData28(JSPUtil.getParameter(request, prefix + "data28", ""));
		setData29(JSPUtil.getParameter(request, prefix + "data29", ""));
		setData21(JSPUtil.getParameter(request, prefix + "data21", ""));
		setData20(JSPUtil.getParameter(request, prefix + "data20", ""));
		setData23(JSPUtil.getParameter(request, prefix + "data23", ""));
		setData22(JSPUtil.getParameter(request, prefix + "data22", ""));
		setData25(JSPUtil.getParameter(request, prefix + "data25", ""));
		setData24(JSPUtil.getParameter(request, prefix + "data24", ""));
		setData27(JSPUtil.getParameter(request, prefix + "data27", ""));
		setData26(JSPUtil.getParameter(request, prefix + "data26", ""));
		setData39(JSPUtil.getParameter(request, prefix + "data39", ""));
		setData30(JSPUtil.getParameter(request, prefix + "data30", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setData37(JSPUtil.getParameter(request, prefix + "data37", ""));
		setData38(JSPUtil.getParameter(request, prefix + "data38", ""));
		setData35(JSPUtil.getParameter(request, prefix + "data35", ""));
		setData36(JSPUtil.getParameter(request, prefix + "data36", ""));
		setData33(JSPUtil.getParameter(request, prefix + "data33", ""));
		setData34(JSPUtil.getParameter(request, prefix + "data34", ""));
		setData31(JSPUtil.getParameter(request, prefix + "data31", ""));
		setData32(JSPUtil.getParameter(request, prefix + "data32", ""));
		setData06(JSPUtil.getParameter(request, prefix + "data06", ""));
		setData07(JSPUtil.getParameter(request, prefix + "data07", ""));
		setData08(JSPUtil.getParameter(request, prefix + "data08", ""));
		setData09(JSPUtil.getParameter(request, prefix + "data09", ""));
		setData03(JSPUtil.getParameter(request, prefix + "data03", ""));
		setData02(JSPUtil.getParameter(request, prefix + "data02", ""));
		setData05(JSPUtil.getParameter(request, prefix + "data05", ""));
		setData40(JSPUtil.getParameter(request, prefix + "data40", ""));
		setData04(JSPUtil.getParameter(request, prefix + "data04", ""));
		setData41(JSPUtil.getParameter(request, prefix + "data41", ""));
		setData01(JSPUtil.getParameter(request, prefix + "data01", ""));
		setData00(JSPUtil.getParameter(request, prefix + "data00", ""));
		setData46(JSPUtil.getParameter(request, prefix + "data46", ""));
		setData47(JSPUtil.getParameter(request, prefix + "data47", ""));
		setData48(JSPUtil.getParameter(request, prefix + "data48", ""));
		setData49(JSPUtil.getParameter(request, prefix + "data49", ""));
		setData42(JSPUtil.getParameter(request, prefix + "data42", ""));
		setData44(JSPUtil.getParameter(request, prefix + "data44", ""));
		setData45(JSPUtil.getParameter(request, prefix + "data45", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdiJapanCommonVO[]
	 */
	public EdiJapanCommonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EdiJapanCommonVO[]
	 */
	public EdiJapanCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EdiJapanCommonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] data19 = (JSPUtil.getParameter(request, prefix	+ "data19", length));
			String[] data17 = (JSPUtil.getParameter(request, prefix	+ "data17", length));
			String[] data18 = (JSPUtil.getParameter(request, prefix	+ "data18", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] data12 = (JSPUtil.getParameter(request, prefix	+ "data12", length));
			String[] data11 = (JSPUtil.getParameter(request, prefix	+ "data11", length));
			String[] data10 = (JSPUtil.getParameter(request, prefix	+ "data10", length));
			String[] data16 = (JSPUtil.getParameter(request, prefix	+ "data16", length));
			String[] data15 = (JSPUtil.getParameter(request, prefix	+ "data15", length));
			String[] data14 = (JSPUtil.getParameter(request, prefix	+ "data14", length));
			String[] data50 = (JSPUtil.getParameter(request, prefix	+ "data50", length));
			String[] data13 = (JSPUtil.getParameter(request, prefix	+ "data13", length));
			String[] data28 = (JSPUtil.getParameter(request, prefix	+ "data28", length));
			String[] data29 = (JSPUtil.getParameter(request, prefix	+ "data29", length));
			String[] data21 = (JSPUtil.getParameter(request, prefix	+ "data21", length));
			String[] data20 = (JSPUtil.getParameter(request, prefix	+ "data20", length));
			String[] data23 = (JSPUtil.getParameter(request, prefix	+ "data23", length));
			String[] data22 = (JSPUtil.getParameter(request, prefix	+ "data22", length));
			String[] data25 = (JSPUtil.getParameter(request, prefix	+ "data25", length));
			String[] data24 = (JSPUtil.getParameter(request, prefix	+ "data24", length));
			String[] data27 = (JSPUtil.getParameter(request, prefix	+ "data27", length));
			String[] data26 = (JSPUtil.getParameter(request, prefix	+ "data26", length));
			String[] data39 = (JSPUtil.getParameter(request, prefix	+ "data39", length));
			String[] data30 = (JSPUtil.getParameter(request, prefix	+ "data30", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] data37 = (JSPUtil.getParameter(request, prefix	+ "data37", length));
			String[] data38 = (JSPUtil.getParameter(request, prefix	+ "data38", length));
			String[] data35 = (JSPUtil.getParameter(request, prefix	+ "data35", length));
			String[] data36 = (JSPUtil.getParameter(request, prefix	+ "data36", length));
			String[] data33 = (JSPUtil.getParameter(request, prefix	+ "data33", length));
			String[] data34 = (JSPUtil.getParameter(request, prefix	+ "data34", length));
			String[] data31 = (JSPUtil.getParameter(request, prefix	+ "data31", length));
			String[] data32 = (JSPUtil.getParameter(request, prefix	+ "data32", length));
			String[] data06 = (JSPUtil.getParameter(request, prefix	+ "data06", length));
			String[] data07 = (JSPUtil.getParameter(request, prefix	+ "data07", length));
			String[] data08 = (JSPUtil.getParameter(request, prefix	+ "data08", length));
			String[] data09 = (JSPUtil.getParameter(request, prefix	+ "data09", length));
			String[] data03 = (JSPUtil.getParameter(request, prefix	+ "data03", length));
			String[] data02 = (JSPUtil.getParameter(request, prefix	+ "data02", length));
			String[] data05 = (JSPUtil.getParameter(request, prefix	+ "data05", length));
			String[] data40 = (JSPUtil.getParameter(request, prefix	+ "data40", length));
			String[] data04 = (JSPUtil.getParameter(request, prefix	+ "data04", length));
			String[] data41 = (JSPUtil.getParameter(request, prefix	+ "data41", length));
			String[] data01 = (JSPUtil.getParameter(request, prefix	+ "data01", length));
			String[] data00 = (JSPUtil.getParameter(request, prefix	+ "data00", length));
			String[] data46 = (JSPUtil.getParameter(request, prefix	+ "data46", length));
			String[] data47 = (JSPUtil.getParameter(request, prefix	+ "data47", length));
			String[] data48 = (JSPUtil.getParameter(request, prefix	+ "data48", length));
			String[] data49 = (JSPUtil.getParameter(request, prefix	+ "data49", length));
			String[] data42 = (JSPUtil.getParameter(request, prefix	+ "data42", length));
			String[] data44 = (JSPUtil.getParameter(request, prefix	+ "data44", length));
			String[] data45 = (JSPUtil.getParameter(request, prefix	+ "data45", length));
			
			for (int i = 0; i < length; i++) {
				model = new EdiJapanCommonVO();
				if (data19[i] != null)
					model.setData19(data19[i]);
				if (data17[i] != null)
					model.setData17(data17[i]);
				if (data18[i] != null)
					model.setData18(data18[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (data12[i] != null)
					model.setData12(data12[i]);
				if (data11[i] != null)
					model.setData11(data11[i]);
				if (data10[i] != null)
					model.setData10(data10[i]);
				if (data16[i] != null)
					model.setData16(data16[i]);
				if (data15[i] != null)
					model.setData15(data15[i]);
				if (data14[i] != null)
					model.setData14(data14[i]);
				if (data50[i] != null)
					model.setData50(data50[i]);
				if (data13[i] != null)
					model.setData13(data13[i]);
				if (data28[i] != null)
					model.setData28(data28[i]);
				if (data29[i] != null)
					model.setData29(data29[i]);
				if (data21[i] != null)
					model.setData21(data21[i]);
				if (data20[i] != null)
					model.setData20(data20[i]);
				if (data23[i] != null)
					model.setData23(data23[i]);
				if (data22[i] != null)
					model.setData22(data22[i]);
				if (data25[i] != null)
					model.setData25(data25[i]);
				if (data24[i] != null)
					model.setData24(data24[i]);
				if (data27[i] != null)
					model.setData27(data27[i]);
				if (data26[i] != null)
					model.setData26(data26[i]);
				if (data39[i] != null)
					model.setData39(data39[i]);
				if (data30[i] != null)
					model.setData30(data30[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (data37[i] != null)
					model.setData37(data37[i]);
				if (data38[i] != null)
					model.setData38(data38[i]);
				if (data35[i] != null)
					model.setData35(data35[i]);
				if (data36[i] != null)
					model.setData36(data36[i]);
				if (data33[i] != null)
					model.setData33(data33[i]);
				if (data34[i] != null)
					model.setData34(data34[i]);
				if (data31[i] != null)
					model.setData31(data31[i]);
				if (data32[i] != null)
					model.setData32(data32[i]);
				if (data06[i] != null)
					model.setData06(data06[i]);
				if (data07[i] != null)
					model.setData07(data07[i]);
				if (data08[i] != null)
					model.setData08(data08[i]);
				if (data09[i] != null)
					model.setData09(data09[i]);
				if (data03[i] != null)
					model.setData03(data03[i]);
				if (data02[i] != null)
					model.setData02(data02[i]);
				if (data05[i] != null)
					model.setData05(data05[i]);
				if (data40[i] != null)
					model.setData40(data40[i]);
				if (data04[i] != null)
					model.setData04(data04[i]);
				if (data41[i] != null)
					model.setData41(data41[i]);
				if (data01[i] != null)
					model.setData01(data01[i]);
				if (data00[i] != null)
					model.setData00(data00[i]);
				if (data46[i] != null)
					model.setData46(data46[i]);
				if (data47[i] != null)
					model.setData47(data47[i]);
				if (data48[i] != null)
					model.setData48(data48[i]);
				if (data49[i] != null)
					model.setData49(data49[i]);
				if (data42[i] != null)
					model.setData42(data42[i]);
				if (data44[i] != null)
					model.setData44(data44[i]);
				if (data45[i] != null)
					model.setData45(data45[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdiJapanCommonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EdiJapanCommonVO[]
	 */
	public EdiJapanCommonVO[] getEdiJapanCommonVOs(){
		EdiJapanCommonVO[] vos = (EdiJapanCommonVO[])models.toArray(new EdiJapanCommonVO[models.size()]);
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
		this.data19 = this.data19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data17 = this.data17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data18 = this.data18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data12 = this.data12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data11 = this.data11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data10 = this.data10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data16 = this.data16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data15 = this.data15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data14 = this.data14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data50 = this.data50 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data13 = this.data13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data28 = this.data28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data29 = this.data29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data21 = this.data21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data20 = this.data20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data23 = this.data23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data22 = this.data22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data25 = this.data25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data24 = this.data24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data27 = this.data27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data26 = this.data26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data39 = this.data39 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data30 = this.data30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data37 = this.data37 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data38 = this.data38 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data35 = this.data35 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data36 = this.data36 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data33 = this.data33 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data34 = this.data34 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data31 = this.data31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data32 = this.data32 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data06 = this.data06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data07 = this.data07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data08 = this.data08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data09 = this.data09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data03 = this.data03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data02 = this.data02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data05 = this.data05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data40 = this.data40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data04 = this.data04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data41 = this.data41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data01 = this.data01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data00 = this.data00 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data46 = this.data46 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data47 = this.data47 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data48 = this.data48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data49 = this.data49 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data42 = this.data42 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data44 = this.data44 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data45 = this.data45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
