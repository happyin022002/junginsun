/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MnrOnSite2VO.java
*@FileTitle : MnrOnSite2VO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.vo;

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

public class MnrOnSite2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MnrOnSite2VO> models = new ArrayList<MnrOnSite2VO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String wk15 = null;
	/* Column Info */
	private String wk39 = null;
	/* Column Info */
	private String wk16 = null;
	/* Column Info */
	private String wk17 = null;
	/* Column Info */
	private String wk37 = null;
	/* Column Info */
	private String wk18 = null;
	/* Column Info */
	private String wk38 = null;
	/* Column Info */
	private String wk19 = null;
	/* Column Info */
	private String wk31 = null;
	/* Column Info */
	private String wk32 = null;
	/* Column Info */
	private String wk10 = null;
	/* Column Info */
	private String wk30 = null;
	/* Column Info */
	private String wk11 = null;
	/* Column Info */
	private String wk35 = null;
	/* Column Info */
	private String wk12 = null;
	/* Column Info */
	private String wk36 = null;
	/* Column Info */
	private String wk13 = null;
	/* Column Info */
	private String wk33 = null;
	/* Column Info */
	private String wk14 = null;
	/* Column Info */
	private String wk34 = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String wk06 = null;
	/* Column Info */
	private String wk26 = null;
	/* Column Info */
	private String wk07 = null;
	/* Column Info */
	private String wk27 = null;
	/* Column Info */
	private String wk04 = null;
	/* Column Info */
	private String wk28 = null;
	/* Column Info */
	private String wk05 = null;
	/* Column Info */
	private String wk29 = null;
	/* Column Info */
	private String wk08 = null;
	/* Column Info */
	private String wk09 = null;
	/* Column Info */
	private String wk20 = null;
	/* Column Info */
	private String wk21 = null;
	/* Column Info */
	private String wk02 = null;
	/* Column Info */
	private String wk22 = null;
	/* Column Info */
	private String wk03 = null;
	/* Column Info */
	private String wk23 = null;
	/* Column Info */
	private String wk24 = null;
	/* Column Info */
	private String wk01 = null;
	/* Column Info */
	private String wk25 = null;
	/* Column Info */
	private String wk50 = null;
	/* Column Info */
	private String inspYr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String subTotal = null;
	/* Column Info */
	private String duty = null;
	/* Column Info */
	private String inspOfcCd = null;
	/* Column Info */
	private String wk53 = null;
	/* Column Info */
	private String wk51 = null;
	/* Column Info */
	private String wk52 = null;
	/* Column Info */
	private String wk48 = null;
	/* Column Info */
	private String wk49 = null;
	/* Column Info */
	private String wk44 = null;
	/* Column Info */
	private String wk45 = null;
	/* Column Info */
	private String wk46 = null;
	/* Column Info */
	private String wk47 = null;
	/* Column Info */
	private String wk40 = null;
	/* Column Info */
	private String wk41 = null;
	/* Column Info */
	private String wk42 = null;
	/* Column Info */
	private String wk43 = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String brncInspFlg = null;
	/* Column Info */
	private String hdbrnInspFlg = null;
	/* Column Info */
	private String sheetBrncInspFlg = null;
	/* Column Info */
	private String sheetHdbrnInspFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MnrOnSite2VO() {}

	public MnrOnSite2VO(String ibflag, String pagerows, String rhqOfcCd, String inspOfcCd, String duty, String wk01, String wk02, String wk03, String wk04, String wk05, String wk06, String wk07, String wk08, String wk09, String wk10, String wk11, String wk12, String wk13, String wk14, String wk15, String wk16, String wk17, String wk18, String wk19, String wk20, String wk21, String wk22, String wk23, String wk24, String wk25, String wk26, String wk27, String wk28, String wk29, String wk30, String wk31, String wk32, String wk33, String wk34, String wk35, String wk36, String wk37, String wk38, String wk39, String wk40, String wk41, String wk42, String wk43, String wk44, String wk45, String wk46, String wk47, String wk48, String wk49, String wk50, String wk51, String wk52, String wk53, String subTotal, String inspYr, String vndrSeq, String brncInspFlg, String hdbrnInspFlg, String sheetBrncInspFlg, String sheetHdbrnInspFlg) {
		this.pagerows = pagerows;
		this.wk15 = wk15;
		this.wk39 = wk39;
		this.wk16 = wk16;
		this.wk17 = wk17;
		this.wk37 = wk37;
		this.wk18 = wk18;
		this.wk38 = wk38;
		this.wk19 = wk19;
		this.wk31 = wk31;
		this.wk32 = wk32;
		this.wk10 = wk10;
		this.wk30 = wk30;
		this.wk11 = wk11;
		this.wk35 = wk35;
		this.wk12 = wk12;
		this.wk36 = wk36;
		this.wk13 = wk13;
		this.wk33 = wk33;
		this.wk14 = wk14;
		this.wk34 = wk34;
		this.rhqOfcCd = rhqOfcCd;
		this.wk06 = wk06;
		this.wk26 = wk26;
		this.wk07 = wk07;
		this.wk27 = wk27;
		this.wk04 = wk04;
		this.wk28 = wk28;
		this.wk05 = wk05;
		this.wk29 = wk29;
		this.wk08 = wk08;
		this.wk09 = wk09;
		this.wk20 = wk20;
		this.wk21 = wk21;
		this.wk02 = wk02;
		this.wk22 = wk22;
		this.wk03 = wk03;
		this.wk23 = wk23;
		this.wk24 = wk24;
		this.wk01 = wk01;
		this.wk25 = wk25;
		this.wk50 = wk50;
		this.inspYr = inspYr;
		this.ibflag = ibflag;
		this.subTotal = subTotal;
		this.duty = duty;
		this.inspOfcCd = inspOfcCd;
		this.wk53 = wk53;
		this.wk51 = wk51;
		this.wk52 = wk52;
		this.wk48 = wk48;
		this.wk49 = wk49;
		this.wk44 = wk44;
		this.wk45 = wk45;
		this.wk46 = wk46;
		this.wk47 = wk47;
		this.wk40 = wk40;
		this.wk41 = wk41;
		this.wk42 = wk42;
		this.wk43 = wk43;
		this.vndrSeq = vndrSeq;
		this.brncInspFlg = brncInspFlg;
		this.hdbrnInspFlg = hdbrnInspFlg;
		this.sheetBrncInspFlg = sheetBrncInspFlg;
		this.sheetHdbrnInspFlg = sheetHdbrnInspFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("wk15", getWk15());
		this.hashColumns.put("wk39", getWk39());
		this.hashColumns.put("wk16", getWk16());
		this.hashColumns.put("wk17", getWk17());
		this.hashColumns.put("wk37", getWk37());
		this.hashColumns.put("wk18", getWk18());
		this.hashColumns.put("wk38", getWk38());
		this.hashColumns.put("wk19", getWk19());
		this.hashColumns.put("wk31", getWk31());
		this.hashColumns.put("wk32", getWk32());
		this.hashColumns.put("wk10", getWk10());
		this.hashColumns.put("wk30", getWk30());
		this.hashColumns.put("wk11", getWk11());
		this.hashColumns.put("wk35", getWk35());
		this.hashColumns.put("wk12", getWk12());
		this.hashColumns.put("wk36", getWk36());
		this.hashColumns.put("wk13", getWk13());
		this.hashColumns.put("wk33", getWk33());
		this.hashColumns.put("wk14", getWk14());
		this.hashColumns.put("wk34", getWk34());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("wk06", getWk06());
		this.hashColumns.put("wk26", getWk26());
		this.hashColumns.put("wk07", getWk07());
		this.hashColumns.put("wk27", getWk27());
		this.hashColumns.put("wk04", getWk04());
		this.hashColumns.put("wk28", getWk28());
		this.hashColumns.put("wk05", getWk05());
		this.hashColumns.put("wk29", getWk29());
		this.hashColumns.put("wk08", getWk08());
		this.hashColumns.put("wk09", getWk09());
		this.hashColumns.put("wk20", getWk20());
		this.hashColumns.put("wk21", getWk21());
		this.hashColumns.put("wk02", getWk02());
		this.hashColumns.put("wk22", getWk22());
		this.hashColumns.put("wk03", getWk03());
		this.hashColumns.put("wk23", getWk23());
		this.hashColumns.put("wk24", getWk24());
		this.hashColumns.put("wk01", getWk01());
		this.hashColumns.put("wk25", getWk25());
		this.hashColumns.put("wk50", getWk50());
		this.hashColumns.put("insp_yr", getInspYr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sub_total", getSubTotal());
		this.hashColumns.put("duty", getDuty());
		this.hashColumns.put("insp_ofc_cd", getInspOfcCd());
		this.hashColumns.put("wk53", getWk53());
		this.hashColumns.put("wk51", getWk51());
		this.hashColumns.put("wk52", getWk52());
		this.hashColumns.put("wk48", getWk48());
		this.hashColumns.put("wk49", getWk49());
		this.hashColumns.put("wk44", getWk44());
		this.hashColumns.put("wk45", getWk45());
		this.hashColumns.put("wk46", getWk46());
		this.hashColumns.put("wk47", getWk47());
		this.hashColumns.put("wk40", getWk40());
		this.hashColumns.put("wk41", getWk41());
		this.hashColumns.put("wk42", getWk42());
		this.hashColumns.put("wk43", getWk43());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("brnc_insp_flg", getBrncInspFlg());
		this.hashColumns.put("hdbrn_insp_flg", getHdbrnInspFlg());
		this.hashColumns.put("sheet_brnc_insp_flg", getSheetBrncInspFlg());
		this.hashColumns.put("sheet_hdbrn_insp_flg", getSheetHdbrnInspFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("wk15", "wk15");
		this.hashFields.put("wk39", "wk39");
		this.hashFields.put("wk16", "wk16");
		this.hashFields.put("wk17", "wk17");
		this.hashFields.put("wk37", "wk37");
		this.hashFields.put("wk18", "wk18");
		this.hashFields.put("wk38", "wk38");
		this.hashFields.put("wk19", "wk19");
		this.hashFields.put("wk31", "wk31");
		this.hashFields.put("wk32", "wk32");
		this.hashFields.put("wk10", "wk10");
		this.hashFields.put("wk30", "wk30");
		this.hashFields.put("wk11", "wk11");
		this.hashFields.put("wk35", "wk35");
		this.hashFields.put("wk12", "wk12");
		this.hashFields.put("wk36", "wk36");
		this.hashFields.put("wk13", "wk13");
		this.hashFields.put("wk33", "wk33");
		this.hashFields.put("wk14", "wk14");
		this.hashFields.put("wk34", "wk34");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("wk06", "wk06");
		this.hashFields.put("wk26", "wk26");
		this.hashFields.put("wk07", "wk07");
		this.hashFields.put("wk27", "wk27");
		this.hashFields.put("wk04", "wk04");
		this.hashFields.put("wk28", "wk28");
		this.hashFields.put("wk05", "wk05");
		this.hashFields.put("wk29", "wk29");
		this.hashFields.put("wk08", "wk08");
		this.hashFields.put("wk09", "wk09");
		this.hashFields.put("wk20", "wk20");
		this.hashFields.put("wk21", "wk21");
		this.hashFields.put("wk02", "wk02");
		this.hashFields.put("wk22", "wk22");
		this.hashFields.put("wk03", "wk03");
		this.hashFields.put("wk23", "wk23");
		this.hashFields.put("wk24", "wk24");
		this.hashFields.put("wk01", "wk01");
		this.hashFields.put("wk25", "wk25");
		this.hashFields.put("wk50", "wk50");
		this.hashFields.put("insp_yr", "inspYr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sub_total", "subTotal");
		this.hashFields.put("duty", "duty");
		this.hashFields.put("insp_ofc_cd", "inspOfcCd");
		this.hashFields.put("wk53", "wk53");
		this.hashFields.put("wk51", "wk51");
		this.hashFields.put("wk52", "wk52");
		this.hashFields.put("wk48", "wk48");
		this.hashFields.put("wk49", "wk49");
		this.hashFields.put("wk44", "wk44");
		this.hashFields.put("wk45", "wk45");
		this.hashFields.put("wk46", "wk46");
		this.hashFields.put("wk47", "wk47");
		this.hashFields.put("wk40", "wk40");
		this.hashFields.put("wk41", "wk41");
		this.hashFields.put("wk42", "wk42");
		this.hashFields.put("wk43", "wk43");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("brnc_insp_flg", "brncInspFlg");
		this.hashFields.put("hdbrn_insp_flg", "hdbrnInspFlg");
		this.hashFields.put("sheet_brnc_insp_flg", "sheetBrncInspFlg");
		this.hashFields.put("sheet_hdbrn_insp_flg", "sheetHdbrnInspFlg");
		return this.hashFields;
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
	 * @return wk15
	 */
	public String getWk15() {
		return this.wk15;
	}
	
	/**
	 * Column Info
	 * @return wk39
	 */
	public String getWk39() {
		return this.wk39;
	}
	
	/**
	 * Column Info
	 * @return wk16
	 */
	public String getWk16() {
		return this.wk16;
	}
	
	/**
	 * Column Info
	 * @return wk17
	 */
	public String getWk17() {
		return this.wk17;
	}
	
	/**
	 * Column Info
	 * @return wk37
	 */
	public String getWk37() {
		return this.wk37;
	}
	
	/**
	 * Column Info
	 * @return wk18
	 */
	public String getWk18() {
		return this.wk18;
	}
	
	/**
	 * Column Info
	 * @return wk38
	 */
	public String getWk38() {
		return this.wk38;
	}
	
	/**
	 * Column Info
	 * @return wk19
	 */
	public String getWk19() {
		return this.wk19;
	}
	
	/**
	 * Column Info
	 * @return wk31
	 */
	public String getWk31() {
		return this.wk31;
	}
	
	/**
	 * Column Info
	 * @return wk32
	 */
	public String getWk32() {
		return this.wk32;
	}
	
	/**
	 * Column Info
	 * @return wk10
	 */
	public String getWk10() {
		return this.wk10;
	}
	
	/**
	 * Column Info
	 * @return wk30
	 */
	public String getWk30() {
		return this.wk30;
	}
	
	/**
	 * Column Info
	 * @return wk11
	 */
	public String getWk11() {
		return this.wk11;
	}
	
	/**
	 * Column Info
	 * @return wk35
	 */
	public String getWk35() {
		return this.wk35;
	}
	
	/**
	 * Column Info
	 * @return wk12
	 */
	public String getWk12() {
		return this.wk12;
	}
	
	/**
	 * Column Info
	 * @return wk36
	 */
	public String getWk36() {
		return this.wk36;
	}
	
	/**
	 * Column Info
	 * @return wk13
	 */
	public String getWk13() {
		return this.wk13;
	}
	
	/**
	 * Column Info
	 * @return wk33
	 */
	public String getWk33() {
		return this.wk33;
	}
	
	/**
	 * Column Info
	 * @return wk14
	 */
	public String getWk14() {
		return this.wk14;
	}
	
	/**
	 * Column Info
	 * @return wk34
	 */
	public String getWk34() {
		return this.wk34;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return wk06
	 */
	public String getWk06() {
		return this.wk06;
	}
	
	/**
	 * Column Info
	 * @return wk26
	 */
	public String getWk26() {
		return this.wk26;
	}
	
	/**
	 * Column Info
	 * @return wk07
	 */
	public String getWk07() {
		return this.wk07;
	}
	
	/**
	 * Column Info
	 * @return wk27
	 */
	public String getWk27() {
		return this.wk27;
	}
	
	/**
	 * Column Info
	 * @return wk04
	 */
	public String getWk04() {
		return this.wk04;
	}
	
	/**
	 * Column Info
	 * @return wk28
	 */
	public String getWk28() {
		return this.wk28;
	}
	
	/**
	 * Column Info
	 * @return wk05
	 */
	public String getWk05() {
		return this.wk05;
	}
	
	/**
	 * Column Info
	 * @return wk29
	 */
	public String getWk29() {
		return this.wk29;
	}
	
	/**
	 * Column Info
	 * @return wk08
	 */
	public String getWk08() {
		return this.wk08;
	}
	
	/**
	 * Column Info
	 * @return wk09
	 */
	public String getWk09() {
		return this.wk09;
	}
	
	/**
	 * Column Info
	 * @return wk20
	 */
	public String getWk20() {
		return this.wk20;
	}
	
	/**
	 * Column Info
	 * @return wk21
	 */
	public String getWk21() {
		return this.wk21;
	}
	
	/**
	 * Column Info
	 * @return wk02
	 */
	public String getWk02() {
		return this.wk02;
	}
	
	/**
	 * Column Info
	 * @return wk22
	 */
	public String getWk22() {
		return this.wk22;
	}
	
	/**
	 * Column Info
	 * @return wk03
	 */
	public String getWk03() {
		return this.wk03;
	}
	
	/**
	 * Column Info
	 * @return wk23
	 */
	public String getWk23() {
		return this.wk23;
	}
	
	/**
	 * Column Info
	 * @return wk24
	 */
	public String getWk24() {
		return this.wk24;
	}
	
	/**
	 * Column Info
	 * @return wk01
	 */
	public String getWk01() {
		return this.wk01;
	}
	
	/**
	 * Column Info
	 * @return wk25
	 */
	public String getWk25() {
		return this.wk25;
	}
	
	/**
	 * Column Info
	 * @return wk50
	 */
	public String getWk50() {
		return this.wk50;
	}
	
	/**
	 * Column Info
	 * @return inspYr
	 */
	public String getInspYr() {
		return this.inspYr;
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
	 * @return subTotal
	 */
	public String getSubTotal() {
		return this.subTotal;
	}
	
	/**
	 * Column Info
	 * @return duty
	 */
	public String getDuty() {
		return this.duty;
	}
	
	/**
	 * Column Info
	 * @return inspOfcCd
	 */
	public String getInspOfcCd() {
		return this.inspOfcCd;
	}
	
	/**
	 * Column Info
	 * @return wk53
	 */
	public String getWk53() {
		return this.wk53;
	}
	
	/**
	 * Column Info
	 * @return wk51
	 */
	public String getWk51() {
		return this.wk51;
	}
	
	/**
	 * Column Info
	 * @return wk52
	 */
	public String getWk52() {
		return this.wk52;
	}
	
	/**
	 * Column Info
	 * @return wk48
	 */
	public String getWk48() {
		return this.wk48;
	}
	
	/**
	 * Column Info
	 * @return wk49
	 */
	public String getWk49() {
		return this.wk49;
	}
	
	/**
	 * Column Info
	 * @return wk44
	 */
	public String getWk44() {
		return this.wk44;
	}
	
	/**
	 * Column Info
	 * @return wk45
	 */
	public String getWk45() {
		return this.wk45;
	}
	
	/**
	 * Column Info
	 * @return wk46
	 */
	public String getWk46() {
		return this.wk46;
	}
	
	/**
	 * Column Info
	 * @return wk47
	 */
	public String getWk47() {
		return this.wk47;
	}
	
	/**
	 * Column Info
	 * @return wk40
	 */
	public String getWk40() {
		return this.wk40;
	}
	
	/**
	 * Column Info
	 * @return wk41
	 */
	public String getWk41() {
		return this.wk41;
	}
	
	/**
	 * Column Info
	 * @return wk42
	 */
	public String getWk42() {
		return this.wk42;
	}
	
	/**
	 * Column Info
	 * @return wk43
	 */
	public String getWk43() {
		return this.wk43;
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
	 * @return brncInspFlg
	 */
	public String getBrncInspFlg() {
		return this.brncInspFlg;
	}
	
	/**
	 * Column Info
	 * @return hdbrnInspFlg
	 */
	public String getHdbrnInspFlg() {
		return this.hdbrnInspFlg;
	}
	
	/**
	 * Column Info
	 * @return sheetBrncInspFlg
	 */
	public String getSheetBrncInspFlg() {
		return this.sheetBrncInspFlg;
	}
	
	/**
	 * Column Info
	 * @return sheetHdbrnInspFlg
	 */
	public String getSheetHdbrnInspFlg() {
		return this.sheetHdbrnInspFlg;
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
	 * @param wk15
	 */
	public void setWk15(String wk15) {
		this.wk15 = wk15;
	}
	
	/**
	 * Column Info
	 * @param wk39
	 */
	public void setWk39(String wk39) {
		this.wk39 = wk39;
	}
	
	/**
	 * Column Info
	 * @param wk16
	 */
	public void setWk16(String wk16) {
		this.wk16 = wk16;
	}
	
	/**
	 * Column Info
	 * @param wk17
	 */
	public void setWk17(String wk17) {
		this.wk17 = wk17;
	}
	
	/**
	 * Column Info
	 * @param wk37
	 */
	public void setWk37(String wk37) {
		this.wk37 = wk37;
	}
	
	/**
	 * Column Info
	 * @param wk18
	 */
	public void setWk18(String wk18) {
		this.wk18 = wk18;
	}
	
	/**
	 * Column Info
	 * @param wk38
	 */
	public void setWk38(String wk38) {
		this.wk38 = wk38;
	}
	
	/**
	 * Column Info
	 * @param wk19
	 */
	public void setWk19(String wk19) {
		this.wk19 = wk19;
	}
	
	/**
	 * Column Info
	 * @param wk31
	 */
	public void setWk31(String wk31) {
		this.wk31 = wk31;
	}
	
	/**
	 * Column Info
	 * @param wk32
	 */
	public void setWk32(String wk32) {
		this.wk32 = wk32;
	}
	
	/**
	 * Column Info
	 * @param wk10
	 */
	public void setWk10(String wk10) {
		this.wk10 = wk10;
	}
	
	/**
	 * Column Info
	 * @param wk30
	 */
	public void setWk30(String wk30) {
		this.wk30 = wk30;
	}
	
	/**
	 * Column Info
	 * @param wk11
	 */
	public void setWk11(String wk11) {
		this.wk11 = wk11;
	}
	
	/**
	 * Column Info
	 * @param wk35
	 */
	public void setWk35(String wk35) {
		this.wk35 = wk35;
	}
	
	/**
	 * Column Info
	 * @param wk12
	 */
	public void setWk12(String wk12) {
		this.wk12 = wk12;
	}
	
	/**
	 * Column Info
	 * @param wk36
	 */
	public void setWk36(String wk36) {
		this.wk36 = wk36;
	}
	
	/**
	 * Column Info
	 * @param wk13
	 */
	public void setWk13(String wk13) {
		this.wk13 = wk13;
	}
	
	/**
	 * Column Info
	 * @param wk33
	 */
	public void setWk33(String wk33) {
		this.wk33 = wk33;
	}
	
	/**
	 * Column Info
	 * @param wk14
	 */
	public void setWk14(String wk14) {
		this.wk14 = wk14;
	}
	
	/**
	 * Column Info
	 * @param wk34
	 */
	public void setWk34(String wk34) {
		this.wk34 = wk34;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param wk06
	 */
	public void setWk06(String wk06) {
		this.wk06 = wk06;
	}
	
	/**
	 * Column Info
	 * @param wk26
	 */
	public void setWk26(String wk26) {
		this.wk26 = wk26;
	}
	
	/**
	 * Column Info
	 * @param wk07
	 */
	public void setWk07(String wk07) {
		this.wk07 = wk07;
	}
	
	/**
	 * Column Info
	 * @param wk27
	 */
	public void setWk27(String wk27) {
		this.wk27 = wk27;
	}
	
	/**
	 * Column Info
	 * @param wk04
	 */
	public void setWk04(String wk04) {
		this.wk04 = wk04;
	}
	
	/**
	 * Column Info
	 * @param wk28
	 */
	public void setWk28(String wk28) {
		this.wk28 = wk28;
	}
	
	/**
	 * Column Info
	 * @param wk05
	 */
	public void setWk05(String wk05) {
		this.wk05 = wk05;
	}
	
	/**
	 * Column Info
	 * @param wk29
	 */
	public void setWk29(String wk29) {
		this.wk29 = wk29;
	}
	
	/**
	 * Column Info
	 * @param wk08
	 */
	public void setWk08(String wk08) {
		this.wk08 = wk08;
	}
	
	/**
	 * Column Info
	 * @param wk09
	 */
	public void setWk09(String wk09) {
		this.wk09 = wk09;
	}
	
	/**
	 * Column Info
	 * @param wk20
	 */
	public void setWk20(String wk20) {
		this.wk20 = wk20;
	}
	
	/**
	 * Column Info
	 * @param wk21
	 */
	public void setWk21(String wk21) {
		this.wk21 = wk21;
	}
	
	/**
	 * Column Info
	 * @param wk02
	 */
	public void setWk02(String wk02) {
		this.wk02 = wk02;
	}
	
	/**
	 * Column Info
	 * @param wk22
	 */
	public void setWk22(String wk22) {
		this.wk22 = wk22;
	}
	
	/**
	 * Column Info
	 * @param wk03
	 */
	public void setWk03(String wk03) {
		this.wk03 = wk03;
	}
	
	/**
	 * Column Info
	 * @param wk23
	 */
	public void setWk23(String wk23) {
		this.wk23 = wk23;
	}
	
	/**
	 * Column Info
	 * @param wk24
	 */
	public void setWk24(String wk24) {
		this.wk24 = wk24;
	}
	
	/**
	 * Column Info
	 * @param wk01
	 */
	public void setWk01(String wk01) {
		this.wk01 = wk01;
	}
	
	/**
	 * Column Info
	 * @param wk25
	 */
	public void setWk25(String wk25) {
		this.wk25 = wk25;
	}
	
	/**
	 * Column Info
	 * @param wk50
	 */
	public void setWk50(String wk50) {
		this.wk50 = wk50;
	}
	
	/**
	 * Column Info
	 * @param inspYr
	 */
	public void setInspYr(String inspYr) {
		this.inspYr = inspYr;
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
	 * @param subTotal
	 */
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}
	
	/**
	 * Column Info
	 * @param duty
	 */
	public void setDuty(String duty) {
		this.duty = duty;
	}
	
	/**
	 * Column Info
	 * @param inspOfcCd
	 */
	public void setInspOfcCd(String inspOfcCd) {
		this.inspOfcCd = inspOfcCd;
	}
	
	/**
	 * Column Info
	 * @param wk53
	 */
	public void setWk53(String wk53) {
		this.wk53 = wk53;
	}
	
	/**
	 * Column Info
	 * @param wk51
	 */
	public void setWk51(String wk51) {
		this.wk51 = wk51;
	}
	
	/**
	 * Column Info
	 * @param wk52
	 */
	public void setWk52(String wk52) {
		this.wk52 = wk52;
	}
	
	/**
	 * Column Info
	 * @param wk48
	 */
	public void setWk48(String wk48) {
		this.wk48 = wk48;
	}
	
	/**
	 * Column Info
	 * @param wk49
	 */
	public void setWk49(String wk49) {
		this.wk49 = wk49;
	}
	
	/**
	 * Column Info
	 * @param wk44
	 */
	public void setWk44(String wk44) {
		this.wk44 = wk44;
	}
	
	/**
	 * Column Info
	 * @param wk45
	 */
	public void setWk45(String wk45) {
		this.wk45 = wk45;
	}
	
	/**
	 * Column Info
	 * @param wk46
	 */
	public void setWk46(String wk46) {
		this.wk46 = wk46;
	}
	
	/**
	 * Column Info
	 * @param wk47
	 */
	public void setWk47(String wk47) {
		this.wk47 = wk47;
	}
	
	/**
	 * Column Info
	 * @param wk40
	 */
	public void setWk40(String wk40) {
		this.wk40 = wk40;
	}
	
	/**
	 * Column Info
	 * @param wk41
	 */
	public void setWk41(String wk41) {
		this.wk41 = wk41;
	}
	
	/**
	 * Column Info
	 * @param wk42
	 */
	public void setWk42(String wk42) {
		this.wk42 = wk42;
	}
	
	/**
	 * Column Info
	 * @param wk43
	 */
	public void setWk43(String wk43) {
		this.wk43 = wk43;
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
	 * @param brncInspFlg
	 */
	public void setBrncInspFlg(String brncInspFlg) {
		this.brncInspFlg = brncInspFlg;
	}
	
	/**
	 * Column Info
	 * @param hdbrnInspFlg
	 */
	public void setHdbrnInspFlg(String hdbrnInspFlg) {
		this.hdbrnInspFlg = hdbrnInspFlg;
	}
	
	/**
	 * Column Info
	 * @param sheetBrncInspFlg
	 */
	public void setSheetBrncInspFlg(String sheetBrncInspFlg) {
		this.sheetBrncInspFlg = sheetBrncInspFlg;
	}
	
	/**
	 * Column Info
	 * @param hdbrnInspFlg
	 */
	public void setSheetHdbrnInspFlg(String sheetHdbrnInspFlg) {
		this.sheetHdbrnInspFlg = sheetHdbrnInspFlg;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setWk15(JSPUtil.getParameter(request, prefix + "wk15", ""));
		setWk39(JSPUtil.getParameter(request, prefix + "wk39", ""));
		setWk16(JSPUtil.getParameter(request, prefix + "wk16", ""));
		setWk17(JSPUtil.getParameter(request, prefix + "wk17", ""));
		setWk37(JSPUtil.getParameter(request, prefix + "wk37", ""));
		setWk18(JSPUtil.getParameter(request, prefix + "wk18", ""));
		setWk38(JSPUtil.getParameter(request, prefix + "wk38", ""));
		setWk19(JSPUtil.getParameter(request, prefix + "wk19", ""));
		setWk31(JSPUtil.getParameter(request, prefix + "wk31", ""));
		setWk32(JSPUtil.getParameter(request, prefix + "wk32", ""));
		setWk10(JSPUtil.getParameter(request, prefix + "wk10", ""));
		setWk30(JSPUtil.getParameter(request, prefix + "wk30", ""));
		setWk11(JSPUtil.getParameter(request, prefix + "wk11", ""));
		setWk35(JSPUtil.getParameter(request, prefix + "wk35", ""));
		setWk12(JSPUtil.getParameter(request, prefix + "wk12", ""));
		setWk36(JSPUtil.getParameter(request, prefix + "wk36", ""));
		setWk13(JSPUtil.getParameter(request, prefix + "wk13", ""));
		setWk33(JSPUtil.getParameter(request, prefix + "wk33", ""));
		setWk14(JSPUtil.getParameter(request, prefix + "wk14", ""));
		setWk34(JSPUtil.getParameter(request, prefix + "wk34", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setWk06(JSPUtil.getParameter(request, prefix + "wk06", ""));
		setWk26(JSPUtil.getParameter(request, prefix + "wk26", ""));
		setWk07(JSPUtil.getParameter(request, prefix + "wk07", ""));
		setWk27(JSPUtil.getParameter(request, prefix + "wk27", ""));
		setWk04(JSPUtil.getParameter(request, prefix + "wk04", ""));
		setWk28(JSPUtil.getParameter(request, prefix + "wk28", ""));
		setWk05(JSPUtil.getParameter(request, prefix + "wk05", ""));
		setWk29(JSPUtil.getParameter(request, prefix + "wk29", ""));
		setWk08(JSPUtil.getParameter(request, prefix + "wk08", ""));
		setWk09(JSPUtil.getParameter(request, prefix + "wk09", ""));
		setWk20(JSPUtil.getParameter(request, prefix + "wk20", ""));
		setWk21(JSPUtil.getParameter(request, prefix + "wk21", ""));
		setWk02(JSPUtil.getParameter(request, prefix + "wk02", ""));
		setWk22(JSPUtil.getParameter(request, prefix + "wk22", ""));
		setWk03(JSPUtil.getParameter(request, prefix + "wk03", ""));
		setWk23(JSPUtil.getParameter(request, prefix + "wk23", ""));
		setWk24(JSPUtil.getParameter(request, prefix + "wk24", ""));
		setWk01(JSPUtil.getParameter(request, prefix + "wk01", ""));
		setWk25(JSPUtil.getParameter(request, prefix + "wk25", ""));
		setWk50(JSPUtil.getParameter(request, prefix + "wk50", ""));
		setInspYr(JSPUtil.getParameter(request, prefix + "insp_yr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSubTotal(JSPUtil.getParameter(request, prefix + "sub_total", ""));
		setDuty(JSPUtil.getParameter(request, prefix + "duty", ""));
		setInspOfcCd(JSPUtil.getParameter(request, prefix + "insp_ofc_cd", ""));
		setWk53(JSPUtil.getParameter(request, prefix + "wk53", ""));
		setWk51(JSPUtil.getParameter(request, prefix + "wk51", ""));
		setWk52(JSPUtil.getParameter(request, prefix + "wk52", ""));
		setWk48(JSPUtil.getParameter(request, prefix + "wk48", ""));
		setWk49(JSPUtil.getParameter(request, prefix + "wk49", ""));
		setWk44(JSPUtil.getParameter(request, prefix + "wk44", ""));
		setWk45(JSPUtil.getParameter(request, prefix + "wk45", ""));
		setWk46(JSPUtil.getParameter(request, prefix + "wk46", ""));
		setWk47(JSPUtil.getParameter(request, prefix + "wk47", ""));
		setWk40(JSPUtil.getParameter(request, prefix + "wk40", ""));
		setWk41(JSPUtil.getParameter(request, prefix + "wk41", ""));
		setWk42(JSPUtil.getParameter(request, prefix + "wk42", ""));
		setWk43(JSPUtil.getParameter(request, prefix + "wk43", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setBrncInspFlg(JSPUtil.getParameter(request, prefix + "brnc_insp_flg", ""));
		setHdbrnInspFlg(JSPUtil.getParameter(request, prefix + "hdbrn_insp_flg", ""));
		setSheetBrncInspFlg(JSPUtil.getParameter(request, prefix + "sheet_brnc_insp_flg", ""));
		setSheetHdbrnInspFlg(JSPUtil.getParameter(request, prefix + "sheet_hdbrn_insp_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MnrOnSite2VO[]
	 */
	public MnrOnSite2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MnrOnSite2VO[]
	 */
	public MnrOnSite2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MnrOnSite2VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] wk15 = (JSPUtil.getParameter(request, prefix	+ "wk15", length));
			String[] wk39 = (JSPUtil.getParameter(request, prefix	+ "wk39", length));
			String[] wk16 = (JSPUtil.getParameter(request, prefix	+ "wk16", length));
			String[] wk17 = (JSPUtil.getParameter(request, prefix	+ "wk17", length));
			String[] wk37 = (JSPUtil.getParameter(request, prefix	+ "wk37", length));
			String[] wk18 = (JSPUtil.getParameter(request, prefix	+ "wk18", length));
			String[] wk38 = (JSPUtil.getParameter(request, prefix	+ "wk38", length));
			String[] wk19 = (JSPUtil.getParameter(request, prefix	+ "wk19", length));
			String[] wk31 = (JSPUtil.getParameter(request, prefix	+ "wk31", length));
			String[] wk32 = (JSPUtil.getParameter(request, prefix	+ "wk32", length));
			String[] wk10 = (JSPUtil.getParameter(request, prefix	+ "wk10", length));
			String[] wk30 = (JSPUtil.getParameter(request, prefix	+ "wk30", length));
			String[] wk11 = (JSPUtil.getParameter(request, prefix	+ "wk11", length));
			String[] wk35 = (JSPUtil.getParameter(request, prefix	+ "wk35", length));
			String[] wk12 = (JSPUtil.getParameter(request, prefix	+ "wk12", length));
			String[] wk36 = (JSPUtil.getParameter(request, prefix	+ "wk36", length));
			String[] wk13 = (JSPUtil.getParameter(request, prefix	+ "wk13", length));
			String[] wk33 = (JSPUtil.getParameter(request, prefix	+ "wk33", length));
			String[] wk14 = (JSPUtil.getParameter(request, prefix	+ "wk14", length));
			String[] wk34 = (JSPUtil.getParameter(request, prefix	+ "wk34", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] wk06 = (JSPUtil.getParameter(request, prefix	+ "wk06", length));
			String[] wk26 = (JSPUtil.getParameter(request, prefix	+ "wk26", length));
			String[] wk07 = (JSPUtil.getParameter(request, prefix	+ "wk07", length));
			String[] wk27 = (JSPUtil.getParameter(request, prefix	+ "wk27", length));
			String[] wk04 = (JSPUtil.getParameter(request, prefix	+ "wk04", length));
			String[] wk28 = (JSPUtil.getParameter(request, prefix	+ "wk28", length));
			String[] wk05 = (JSPUtil.getParameter(request, prefix	+ "wk05", length));
			String[] wk29 = (JSPUtil.getParameter(request, prefix	+ "wk29", length));
			String[] wk08 = (JSPUtil.getParameter(request, prefix	+ "wk08", length));
			String[] wk09 = (JSPUtil.getParameter(request, prefix	+ "wk09", length));
			String[] wk20 = (JSPUtil.getParameter(request, prefix	+ "wk20", length));
			String[] wk21 = (JSPUtil.getParameter(request, prefix	+ "wk21", length));
			String[] wk02 = (JSPUtil.getParameter(request, prefix	+ "wk02", length));
			String[] wk22 = (JSPUtil.getParameter(request, prefix	+ "wk22", length));
			String[] wk03 = (JSPUtil.getParameter(request, prefix	+ "wk03", length));
			String[] wk23 = (JSPUtil.getParameter(request, prefix	+ "wk23", length));
			String[] wk24 = (JSPUtil.getParameter(request, prefix	+ "wk24", length));
			String[] wk01 = (JSPUtil.getParameter(request, prefix	+ "wk01", length));
			String[] wk25 = (JSPUtil.getParameter(request, prefix	+ "wk25", length));
			String[] wk50 = (JSPUtil.getParameter(request, prefix	+ "wk50", length));
			String[] inspYr = (JSPUtil.getParameter(request, prefix	+ "insp_yr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] subTotal = (JSPUtil.getParameter(request, prefix	+ "sub_total", length));
			String[] duty = (JSPUtil.getParameter(request, prefix	+ "duty", length));
			String[] inspOfcCd = (JSPUtil.getParameter(request, prefix	+ "insp_ofc_cd", length));
			String[] wk53 = (JSPUtil.getParameter(request, prefix	+ "wk53", length));
			String[] wk51 = (JSPUtil.getParameter(request, prefix	+ "wk51", length));
			String[] wk52 = (JSPUtil.getParameter(request, prefix	+ "wk52", length));
			String[] wk48 = (JSPUtil.getParameter(request, prefix	+ "wk48", length));
			String[] wk49 = (JSPUtil.getParameter(request, prefix	+ "wk49", length));
			String[] wk44 = (JSPUtil.getParameter(request, prefix	+ "wk44", length));
			String[] wk45 = (JSPUtil.getParameter(request, prefix	+ "wk45", length));
			String[] wk46 = (JSPUtil.getParameter(request, prefix	+ "wk46", length));
			String[] wk47 = (JSPUtil.getParameter(request, prefix	+ "wk47", length));
			String[] wk40 = (JSPUtil.getParameter(request, prefix	+ "wk40", length));
			String[] wk41 = (JSPUtil.getParameter(request, prefix	+ "wk41", length));
			String[] wk42 = (JSPUtil.getParameter(request, prefix	+ "wk42", length));
			String[] wk43 = (JSPUtil.getParameter(request, prefix	+ "wk43", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] brncInspFlg = (JSPUtil.getParameter(request, prefix	+ "brnc_insp_flg", length));
			String[] hdbrnInspFlg = (JSPUtil.getParameter(request, prefix	+ "hdbrn_insp_flg", length));
			String[] sheetBrncInspFlg = (JSPUtil.getParameter(request, prefix	+ "sheet_brnc_insp_flg", length));
			String[] sheetHdbrnInspFlg = (JSPUtil.getParameter(request, prefix	+ "sheet_hdbrn_insp_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new MnrOnSite2VO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (wk15[i] != null)
					model.setWk15(wk15[i]);
				if (wk39[i] != null)
					model.setWk39(wk39[i]);
				if (wk16[i] != null)
					model.setWk16(wk16[i]);
				if (wk17[i] != null)
					model.setWk17(wk17[i]);
				if (wk37[i] != null)
					model.setWk37(wk37[i]);
				if (wk18[i] != null)
					model.setWk18(wk18[i]);
				if (wk38[i] != null)
					model.setWk38(wk38[i]);
				if (wk19[i] != null)
					model.setWk19(wk19[i]);
				if (wk31[i] != null)
					model.setWk31(wk31[i]);
				if (wk32[i] != null)
					model.setWk32(wk32[i]);
				if (wk10[i] != null)
					model.setWk10(wk10[i]);
				if (wk30[i] != null)
					model.setWk30(wk30[i]);
				if (wk11[i] != null)
					model.setWk11(wk11[i]);
				if (wk35[i] != null)
					model.setWk35(wk35[i]);
				if (wk12[i] != null)
					model.setWk12(wk12[i]);
				if (wk36[i] != null)
					model.setWk36(wk36[i]);
				if (wk13[i] != null)
					model.setWk13(wk13[i]);
				if (wk33[i] != null)
					model.setWk33(wk33[i]);
				if (wk14[i] != null)
					model.setWk14(wk14[i]);
				if (wk34[i] != null)
					model.setWk34(wk34[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (wk06[i] != null)
					model.setWk06(wk06[i]);
				if (wk26[i] != null)
					model.setWk26(wk26[i]);
				if (wk07[i] != null)
					model.setWk07(wk07[i]);
				if (wk27[i] != null)
					model.setWk27(wk27[i]);
				if (wk04[i] != null)
					model.setWk04(wk04[i]);
				if (wk28[i] != null)
					model.setWk28(wk28[i]);
				if (wk05[i] != null)
					model.setWk05(wk05[i]);
				if (wk29[i] != null)
					model.setWk29(wk29[i]);
				if (wk08[i] != null)
					model.setWk08(wk08[i]);
				if (wk09[i] != null)
					model.setWk09(wk09[i]);
				if (wk20[i] != null)
					model.setWk20(wk20[i]);
				if (wk21[i] != null)
					model.setWk21(wk21[i]);
				if (wk02[i] != null)
					model.setWk02(wk02[i]);
				if (wk22[i] != null)
					model.setWk22(wk22[i]);
				if (wk03[i] != null)
					model.setWk03(wk03[i]);
				if (wk23[i] != null)
					model.setWk23(wk23[i]);
				if (wk24[i] != null)
					model.setWk24(wk24[i]);
				if (wk01[i] != null)
					model.setWk01(wk01[i]);
				if (wk25[i] != null)
					model.setWk25(wk25[i]);
				if (wk50[i] != null)
					model.setWk50(wk50[i]);
				if (inspYr[i] != null)
					model.setInspYr(inspYr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (subTotal[i] != null)
					model.setSubTotal(subTotal[i]);
				if (duty[i] != null)
					model.setDuty(duty[i]);
				if (inspOfcCd[i] != null)
					model.setInspOfcCd(inspOfcCd[i]);
				if (wk53[i] != null)
					model.setWk53(wk53[i]);
				if (wk51[i] != null)
					model.setWk51(wk51[i]);
				if (wk52[i] != null)
					model.setWk52(wk52[i]);
				if (wk48[i] != null)
					model.setWk48(wk48[i]);
				if (wk49[i] != null)
					model.setWk49(wk49[i]);
				if (wk44[i] != null)
					model.setWk44(wk44[i]);
				if (wk45[i] != null)
					model.setWk45(wk45[i]);
				if (wk46[i] != null)
					model.setWk46(wk46[i]);
				if (wk47[i] != null)
					model.setWk47(wk47[i]);
				if (wk40[i] != null)
					model.setWk40(wk40[i]);
				if (wk41[i] != null)
					model.setWk41(wk41[i]);
				if (wk42[i] != null)
					model.setWk42(wk42[i]);
				if (wk43[i] != null)
					model.setWk43(wk43[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (brncInspFlg[i] != null)
					model.setBrncInspFlg(brncInspFlg[i]);
				if (hdbrnInspFlg[i] != null)
					model.setHdbrnInspFlg(hdbrnInspFlg[i]);
				if (sheetBrncInspFlg[i] != null)
					model.setSheetBrncInspFlg(sheetBrncInspFlg[i]);
				if (sheetHdbrnInspFlg[i] != null)
					model.setSheetHdbrnInspFlg(sheetHdbrnInspFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMnrOnSite2VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MnrOnSite2VO[]
	 */
	public MnrOnSite2VO[] getMnrOnSite2VOs(){
		MnrOnSite2VO[] vos = (MnrOnSite2VO[])models.toArray(new MnrOnSite2VO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk15 = this.wk15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk39 = this.wk39 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk16 = this.wk16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk17 = this.wk17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk37 = this.wk37 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk18 = this.wk18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk38 = this.wk38 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk19 = this.wk19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk31 = this.wk31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk32 = this.wk32 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk10 = this.wk10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk30 = this.wk30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk11 = this.wk11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk35 = this.wk35 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk12 = this.wk12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk36 = this.wk36 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk13 = this.wk13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk33 = this.wk33 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk14 = this.wk14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk34 = this.wk34 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk06 = this.wk06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk26 = this.wk26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk07 = this.wk07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk27 = this.wk27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk04 = this.wk04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk28 = this.wk28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk05 = this.wk05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk29 = this.wk29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk08 = this.wk08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk09 = this.wk09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk20 = this.wk20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk21 = this.wk21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk02 = this.wk02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk22 = this.wk22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk03 = this.wk03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk23 = this.wk23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk24 = this.wk24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk01 = this.wk01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk25 = this.wk25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk50 = this.wk50 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inspYr = this.inspYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotal = this.subTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duty = this.duty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inspOfcCd = this.inspOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk53 = this.wk53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk51 = this.wk51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk52 = this.wk52 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk48 = this.wk48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk49 = this.wk49 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk44 = this.wk44 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk45 = this.wk45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk46 = this.wk46 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk47 = this.wk47 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk40 = this.wk40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk41 = this.wk41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk42 = this.wk42 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk43 = this.wk43 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brncInspFlg = this.brncInspFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdbrnInspFlg = this.hdbrnInspFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetBrncInspFlg = this.sheetBrncInspFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetHdbrnInspFlg = this.sheetHdbrnInspFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
