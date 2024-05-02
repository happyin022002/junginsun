/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OTSAgingListVO.java
*@FileTitle : OTSAgingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

import java.lang.reflect.Field;
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

public class OTSAgingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OTSAgingListVO> models = new ArrayList<OTSAgingListVO>();
	
	/* Column Info */
	private String col09 = null;
	/* Column Info */
	private String col08 = null;
	/* Column Info */
	private String col77 = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String col01 = null;
	/* Column Info */
	private String col78 = null;
	/* Column Info */
	private String col79 = null;
	/* Column Info */
	private String col03 = null;
	/* Column Info */
	private String col02 = null;
	/* Column Info */
	private String col05 = null;
	/* Column Info */
	private String col04 = null;
	/* Column Info */
	private String col07 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String col06 = null;
	/* Column Info */
	private String col81 = null;
	/* Column Info */
	private String col80 = null;
	/* Column Info */
	private String col10 = null;
	/* Column Info */
	private String col19 = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String col68 = null;
	/* Column Info */
	private String col14 = null;
	/* Column Info */
	private String col69 = null;
	/* Column Info */
	private String col13 = null;
	/* Column Info */
	private String col66 = null;
	/* Column Info */
	private String col12 = null;
	/* Column Info */
	private String col67 = null;
	/* Column Info */
	private String col11 = null;
	/* Column Info */
	private String col18 = null;
	/* Column Info */
	private String col17 = null;
	/* Column Info */
	private String col16 = null;
	/* Column Info */
	private String col15 = null;
	/* Column Info */
	private String col72 = null;
	/* Column Info */
	private String col71 = null;
	/* Column Info */
	private String col70 = null;
	/* Column Info */
	private String col76 = null;
	/* Column Info */
	private String col20 = null;
	/* Column Info */
	private String col75 = null;
	/* Column Info */
	private String col21 = null;
	/* Column Info */
	private String col74 = null;
	/* Column Info */
	private String col73 = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String col59 = null;
	/* Column Info */
	private String col27 = null;
	/* Column Info */
	private String col26 = null;
	/* Column Info */
	private String col29 = null;
	/* Column Info */
	private String col28 = null;
	/* Column Info */
	private String col55 = null;
	/* Column Info */
	private String col23 = null;
	/* Column Info */
	private String col56 = null;
	/* Column Info */
	private String col22 = null;
	/* Column Info */
	private String col57 = null;
	/* Column Info */
	private String col25 = null;
	/* Column Info */
	private String col58 = null;
	/* Column Info */
	private String col24 = null;
	/* Column Info */
	private String col63 = null;
	/* Column Info */
	private String col62 = null;
	/* Column Info */
	private String col30 = null;
	/* Column Info */
	private String col65 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String col31 = null;
	/* Column Info */
	private String col64 = null;
	/* Column Info */
	private String col32 = null;
	/* Column Info */
	private String col61 = null;
	/* Column Info */
	private String col60 = null;
	/* Column Info */
	private String custNum = null;
	/* Column Info */
	private String col39 = null;
	/* Column Info */
	private String col48 = null;
	/* Column Info */
	private String col38 = null;
	/* Column Info */
	private String col49 = null;
	/* Column Info */
	private String col37 = null;
	/* Column Info */
	private String col46 = null;
	/* Column Info */
	private String col36 = null;
	/* Column Info */
	private String col47 = null;
	/* Column Info */
	private String col35 = null;
	/* Column Info */
	private String col44 = null;
	/* Column Info */
	private String col34 = null;
	/* Column Info */
	private String col45 = null;
	/* Column Info */
	private String col33 = null;
	/* Column Info */
	private String col54 = null;
	/* Column Info */
	private String col42 = null;
	/* Column Info */
	private String col53 = null;
	/* Column Info */
	private String col43 = null;
	/* Column Info */
	private String col52 = null;
	/* Column Info */
	private String col40 = null;
	/* Column Info */
	private String col51 = null;
	/* Column Info */
	private String col41 = null;
	/* Column Info */
	private String col50 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OTSAgingListVO() {}

	public OTSAgingListVO(String ibflag, String pagerows, String cltOfcCd, String custNum, String custNm, String rhqCd, String col01, String col02, String col03, String col04, String col05, String col06, String col07, String col08, String col09, String col10, String col11, String col12, String col13, String col14, String col15, String col16, String col17, String col18, String col19, String col20, String col21, String col22, String col23, String col24, String col25, String col26, String col27, String col28, String col29, String col30, String col31, String col32, String col33, String col34, String col35, String col36, String col37, String col38, String col39, String col40, String col41, String col42, String col43, String col44, String col45, String col46, String col47, String col48, String col49, String col50, String col51, String col52, String col53, String col54, String col55, String col56, String col57, String col58, String col59, String col60, String col61, String col62, String col63, String col64, String col65, String col66, String col67, String col68, String col69, String col70, String col71, String col72, String col73, String col74, String col75, String col76, String col77, String col78, String col79, String col80, String col81) {
		this.col09 = col09;
		this.col08 = col08;
		this.col77 = col77;
		this.cltOfcCd = cltOfcCd;
		this.col01 = col01;
		this.col78 = col78;
		this.col79 = col79;
		this.col03 = col03;
		this.col02 = col02;
		this.col05 = col05;
		this.col04 = col04;
		this.col07 = col07;
		this.pagerows = pagerows;
		this.col06 = col06;
		this.col81 = col81;
		this.col80 = col80;
		this.col10 = col10;
		this.col19 = col19;
		this.rhqCd = rhqCd;
		this.col68 = col68;
		this.col14 = col14;
		this.col69 = col69;
		this.col13 = col13;
		this.col66 = col66;
		this.col12 = col12;
		this.col67 = col67;
		this.col11 = col11;
		this.col18 = col18;
		this.col17 = col17;
		this.col16 = col16;
		this.col15 = col15;
		this.col72 = col72;
		this.col71 = col71;
		this.col70 = col70;
		this.col76 = col76;
		this.col20 = col20;
		this.col75 = col75;
		this.col21 = col21;
		this.col74 = col74;
		this.col73 = col73;
		this.custNm = custNm;
		this.col59 = col59;
		this.col27 = col27;
		this.col26 = col26;
		this.col29 = col29;
		this.col28 = col28;
		this.col55 = col55;
		this.col23 = col23;
		this.col56 = col56;
		this.col22 = col22;
		this.col57 = col57;
		this.col25 = col25;
		this.col58 = col58;
		this.col24 = col24;
		this.col63 = col63;
		this.col62 = col62;
		this.col30 = col30;
		this.col65 = col65;
		this.ibflag = ibflag;
		this.col31 = col31;
		this.col64 = col64;
		this.col32 = col32;
		this.col61 = col61;
		this.col60 = col60;
		this.custNum = custNum;
		this.col39 = col39;
		this.col48 = col48;
		this.col38 = col38;
		this.col49 = col49;
		this.col37 = col37;
		this.col46 = col46;
		this.col36 = col36;
		this.col47 = col47;
		this.col35 = col35;
		this.col44 = col44;
		this.col34 = col34;
		this.col45 = col45;
		this.col33 = col33;
		this.col54 = col54;
		this.col42 = col42;
		this.col53 = col53;
		this.col43 = col43;
		this.col52 = col52;
		this.col40 = col40;
		this.col51 = col51;
		this.col41 = col41;
		this.col50 = col50;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("col09", getCol09());
		this.hashColumns.put("col08", getCol08());
		this.hashColumns.put("col77", getCol77());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("col01", getCol01());
		this.hashColumns.put("col78", getCol78());
		this.hashColumns.put("col79", getCol79());
		this.hashColumns.put("col03", getCol03());
		this.hashColumns.put("col02", getCol02());
		this.hashColumns.put("col05", getCol05());
		this.hashColumns.put("col04", getCol04());
		this.hashColumns.put("col07", getCol07());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("col06", getCol06());
		this.hashColumns.put("col81", getCol81());
		this.hashColumns.put("col80", getCol80());
		this.hashColumns.put("col10", getCol10());
		this.hashColumns.put("col19", getCol19());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("col68", getCol68());
		this.hashColumns.put("col14", getCol14());
		this.hashColumns.put("col69", getCol69());
		this.hashColumns.put("col13", getCol13());
		this.hashColumns.put("col66", getCol66());
		this.hashColumns.put("col12", getCol12());
		this.hashColumns.put("col67", getCol67());
		this.hashColumns.put("col11", getCol11());
		this.hashColumns.put("col18", getCol18());
		this.hashColumns.put("col17", getCol17());
		this.hashColumns.put("col16", getCol16());
		this.hashColumns.put("col15", getCol15());
		this.hashColumns.put("col72", getCol72());
		this.hashColumns.put("col71", getCol71());
		this.hashColumns.put("col70", getCol70());
		this.hashColumns.put("col76", getCol76());
		this.hashColumns.put("col20", getCol20());
		this.hashColumns.put("col75", getCol75());
		this.hashColumns.put("col21", getCol21());
		this.hashColumns.put("col74", getCol74());
		this.hashColumns.put("col73", getCol73());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("col59", getCol59());
		this.hashColumns.put("col27", getCol27());
		this.hashColumns.put("col26", getCol26());
		this.hashColumns.put("col29", getCol29());
		this.hashColumns.put("col28", getCol28());
		this.hashColumns.put("col55", getCol55());
		this.hashColumns.put("col23", getCol23());
		this.hashColumns.put("col56", getCol56());
		this.hashColumns.put("col22", getCol22());
		this.hashColumns.put("col57", getCol57());
		this.hashColumns.put("col25", getCol25());
		this.hashColumns.put("col58", getCol58());
		this.hashColumns.put("col24", getCol24());
		this.hashColumns.put("col63", getCol63());
		this.hashColumns.put("col62", getCol62());
		this.hashColumns.put("col30", getCol30());
		this.hashColumns.put("col65", getCol65());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("col31", getCol31());
		this.hashColumns.put("col64", getCol64());
		this.hashColumns.put("col32", getCol32());
		this.hashColumns.put("col61", getCol61());
		this.hashColumns.put("col60", getCol60());
		this.hashColumns.put("cust_num", getCustNum());
		this.hashColumns.put("col39", getCol39());
		this.hashColumns.put("col48", getCol48());
		this.hashColumns.put("col38", getCol38());
		this.hashColumns.put("col49", getCol49());
		this.hashColumns.put("col37", getCol37());
		this.hashColumns.put("col46", getCol46());
		this.hashColumns.put("col36", getCol36());
		this.hashColumns.put("col47", getCol47());
		this.hashColumns.put("col35", getCol35());
		this.hashColumns.put("col44", getCol44());
		this.hashColumns.put("col34", getCol34());
		this.hashColumns.put("col45", getCol45());
		this.hashColumns.put("col33", getCol33());
		this.hashColumns.put("col54", getCol54());
		this.hashColumns.put("col42", getCol42());
		this.hashColumns.put("col53", getCol53());
		this.hashColumns.put("col43", getCol43());
		this.hashColumns.put("col52", getCol52());
		this.hashColumns.put("col40", getCol40());
		this.hashColumns.put("col51", getCol51());
		this.hashColumns.put("col41", getCol41());
		this.hashColumns.put("col50", getCol50());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("col09", "col09");
		this.hashFields.put("col08", "col08");
		this.hashFields.put("col77", "col77");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("col01", "col01");
		this.hashFields.put("col78", "col78");
		this.hashFields.put("col79", "col79");
		this.hashFields.put("col03", "col03");
		this.hashFields.put("col02", "col02");
		this.hashFields.put("col05", "col05");
		this.hashFields.put("col04", "col04");
		this.hashFields.put("col07", "col07");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("col06", "col06");
		this.hashFields.put("col81", "col81");
		this.hashFields.put("col80", "col80");
		this.hashFields.put("col10", "col10");
		this.hashFields.put("col19", "col19");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("col68", "col68");
		this.hashFields.put("col14", "col14");
		this.hashFields.put("col69", "col69");
		this.hashFields.put("col13", "col13");
		this.hashFields.put("col66", "col66");
		this.hashFields.put("col12", "col12");
		this.hashFields.put("col67", "col67");
		this.hashFields.put("col11", "col11");
		this.hashFields.put("col18", "col18");
		this.hashFields.put("col17", "col17");
		this.hashFields.put("col16", "col16");
		this.hashFields.put("col15", "col15");
		this.hashFields.put("col72", "col72");
		this.hashFields.put("col71", "col71");
		this.hashFields.put("col70", "col70");
		this.hashFields.put("col76", "col76");
		this.hashFields.put("col20", "col20");
		this.hashFields.put("col75", "col75");
		this.hashFields.put("col21", "col21");
		this.hashFields.put("col74", "col74");
		this.hashFields.put("col73", "col73");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("col59", "col59");
		this.hashFields.put("col27", "col27");
		this.hashFields.put("col26", "col26");
		this.hashFields.put("col29", "col29");
		this.hashFields.put("col28", "col28");
		this.hashFields.put("col55", "col55");
		this.hashFields.put("col23", "col23");
		this.hashFields.put("col56", "col56");
		this.hashFields.put("col22", "col22");
		this.hashFields.put("col57", "col57");
		this.hashFields.put("col25", "col25");
		this.hashFields.put("col58", "col58");
		this.hashFields.put("col24", "col24");
		this.hashFields.put("col63", "col63");
		this.hashFields.put("col62", "col62");
		this.hashFields.put("col30", "col30");
		this.hashFields.put("col65", "col65");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("col31", "col31");
		this.hashFields.put("col64", "col64");
		this.hashFields.put("col32", "col32");
		this.hashFields.put("col61", "col61");
		this.hashFields.put("col60", "col60");
		this.hashFields.put("cust_num", "custNum");
		this.hashFields.put("col39", "col39");
		this.hashFields.put("col48", "col48");
		this.hashFields.put("col38", "col38");
		this.hashFields.put("col49", "col49");
		this.hashFields.put("col37", "col37");
		this.hashFields.put("col46", "col46");
		this.hashFields.put("col36", "col36");
		this.hashFields.put("col47", "col47");
		this.hashFields.put("col35", "col35");
		this.hashFields.put("col44", "col44");
		this.hashFields.put("col34", "col34");
		this.hashFields.put("col45", "col45");
		this.hashFields.put("col33", "col33");
		this.hashFields.put("col54", "col54");
		this.hashFields.put("col42", "col42");
		this.hashFields.put("col53", "col53");
		this.hashFields.put("col43", "col43");
		this.hashFields.put("col52", "col52");
		this.hashFields.put("col40", "col40");
		this.hashFields.put("col51", "col51");
		this.hashFields.put("col41", "col41");
		this.hashFields.put("col50", "col50");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return col09
	 */
	public String getCol09() {
		return this.col09;
	}
	
	/**
	 * Column Info
	 * @return col08
	 */
	public String getCol08() {
		return this.col08;
	}
	
	/**
	 * Column Info
	 * @return col77
	 */
	public String getCol77() {
		return this.col77;
	}
	
	/**
	 * Column Info
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return col01
	 */
	public String getCol01() {
		return this.col01;
	}
	
	/**
	 * Column Info
	 * @return col78
	 */
	public String getCol78() {
		return this.col78;
	}
	
	/**
	 * Column Info
	 * @return col79
	 */
	public String getCol79() {
		return this.col79;
	}
	
	/**
	 * Column Info
	 * @return col03
	 */
	public String getCol03() {
		return this.col03;
	}
	
	/**
	 * Column Info
	 * @return col02
	 */
	public String getCol02() {
		return this.col02;
	}
	
	/**
	 * Column Info
	 * @return col05
	 */
	public String getCol05() {
		return this.col05;
	}
	
	/**
	 * Column Info
	 * @return col04
	 */
	public String getCol04() {
		return this.col04;
	}
	
	/**
	 * Column Info
	 * @return col07
	 */
	public String getCol07() {
		return this.col07;
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
	 * @return col06
	 */
	public String getCol06() {
		return this.col06;
	}
	
	/**
	 * Column Info
	 * @return col81
	 */
	public String getCol81() {
		return this.col81;
	}
	
	/**
	 * Column Info
	 * @return col80
	 */
	public String getCol80() {
		return this.col80;
	}
	
	/**
	 * Column Info
	 * @return col10
	 */
	public String getCol10() {
		return this.col10;
	}
	
	/**
	 * Column Info
	 * @return col19
	 */
	public String getCol19() {
		return this.col19;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return col68
	 */
	public String getCol68() {
		return this.col68;
	}
	
	/**
	 * Column Info
	 * @return col14
	 */
	public String getCol14() {
		return this.col14;
	}
	
	/**
	 * Column Info
	 * @return col69
	 */
	public String getCol69() {
		return this.col69;
	}
	
	/**
	 * Column Info
	 * @return col13
	 */
	public String getCol13() {
		return this.col13;
	}
	
	/**
	 * Column Info
	 * @return col66
	 */
	public String getCol66() {
		return this.col66;
	}
	
	/**
	 * Column Info
	 * @return col12
	 */
	public String getCol12() {
		return this.col12;
	}
	
	/**
	 * Column Info
	 * @return col67
	 */
	public String getCol67() {
		return this.col67;
	}
	
	/**
	 * Column Info
	 * @return col11
	 */
	public String getCol11() {
		return this.col11;
	}
	
	/**
	 * Column Info
	 * @return col18
	 */
	public String getCol18() {
		return this.col18;
	}
	
	/**
	 * Column Info
	 * @return col17
	 */
	public String getCol17() {
		return this.col17;
	}
	
	/**
	 * Column Info
	 * @return col16
	 */
	public String getCol16() {
		return this.col16;
	}
	
	/**
	 * Column Info
	 * @return col15
	 */
	public String getCol15() {
		return this.col15;
	}
	
	/**
	 * Column Info
	 * @return col72
	 */
	public String getCol72() {
		return this.col72;
	}
	
	/**
	 * Column Info
	 * @return col71
	 */
	public String getCol71() {
		return this.col71;
	}
	
	/**
	 * Column Info
	 * @return col70
	 */
	public String getCol70() {
		return this.col70;
	}
	
	/**
	 * Column Info
	 * @return col76
	 */
	public String getCol76() {
		return this.col76;
	}
	
	/**
	 * Column Info
	 * @return col20
	 */
	public String getCol20() {
		return this.col20;
	}
	
	/**
	 * Column Info
	 * @return col75
	 */
	public String getCol75() {
		return this.col75;
	}
	
	/**
	 * Column Info
	 * @return col21
	 */
	public String getCol21() {
		return this.col21;
	}
	
	/**
	 * Column Info
	 * @return col74
	 */
	public String getCol74() {
		return this.col74;
	}
	
	/**
	 * Column Info
	 * @return col73
	 */
	public String getCol73() {
		return this.col73;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return col59
	 */
	public String getCol59() {
		return this.col59;
	}
	
	/**
	 * Column Info
	 * @return col27
	 */
	public String getCol27() {
		return this.col27;
	}
	
	/**
	 * Column Info
	 * @return col26
	 */
	public String getCol26() {
		return this.col26;
	}
	
	/**
	 * Column Info
	 * @return col29
	 */
	public String getCol29() {
		return this.col29;
	}
	
	/**
	 * Column Info
	 * @return col28
	 */
	public String getCol28() {
		return this.col28;
	}
	
	/**
	 * Column Info
	 * @return col55
	 */
	public String getCol55() {
		return this.col55;
	}
	
	/**
	 * Column Info
	 * @return col23
	 */
	public String getCol23() {
		return this.col23;
	}
	
	/**
	 * Column Info
	 * @return col56
	 */
	public String getCol56() {
		return this.col56;
	}
	
	/**
	 * Column Info
	 * @return col22
	 */
	public String getCol22() {
		return this.col22;
	}
	
	/**
	 * Column Info
	 * @return col57
	 */
	public String getCol57() {
		return this.col57;
	}
	
	/**
	 * Column Info
	 * @return col25
	 */
	public String getCol25() {
		return this.col25;
	}
	
	/**
	 * Column Info
	 * @return col58
	 */
	public String getCol58() {
		return this.col58;
	}
	
	/**
	 * Column Info
	 * @return col24
	 */
	public String getCol24() {
		return this.col24;
	}
	
	/**
	 * Column Info
	 * @return col63
	 */
	public String getCol63() {
		return this.col63;
	}
	
	/**
	 * Column Info
	 * @return col62
	 */
	public String getCol62() {
		return this.col62;
	}
	
	/**
	 * Column Info
	 * @return col30
	 */
	public String getCol30() {
		return this.col30;
	}
	
	/**
	 * Column Info
	 * @return col65
	 */
	public String getCol65() {
		return this.col65;
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
	 * @return col31
	 */
	public String getCol31() {
		return this.col31;
	}
	
	/**
	 * Column Info
	 * @return col64
	 */
	public String getCol64() {
		return this.col64;
	}
	
	/**
	 * Column Info
	 * @return col32
	 */
	public String getCol32() {
		return this.col32;
	}
	
	/**
	 * Column Info
	 * @return col61
	 */
	public String getCol61() {
		return this.col61;
	}
	
	/**
	 * Column Info
	 * @return col60
	 */
	public String getCol60() {
		return this.col60;
	}
	
	/**
	 * Column Info
	 * @return custNum
	 */
	public String getCustNum() {
		return this.custNum;
	}
	
	/**
	 * Column Info
	 * @return col39
	 */
	public String getCol39() {
		return this.col39;
	}
	
	/**
	 * Column Info
	 * @return col48
	 */
	public String getCol48() {
		return this.col48;
	}
	
	/**
	 * Column Info
	 * @return col38
	 */
	public String getCol38() {
		return this.col38;
	}
	
	/**
	 * Column Info
	 * @return col49
	 */
	public String getCol49() {
		return this.col49;
	}
	
	/**
	 * Column Info
	 * @return col37
	 */
	public String getCol37() {
		return this.col37;
	}
	
	/**
	 * Column Info
	 * @return col46
	 */
	public String getCol46() {
		return this.col46;
	}
	
	/**
	 * Column Info
	 * @return col36
	 */
	public String getCol36() {
		return this.col36;
	}
	
	/**
	 * Column Info
	 * @return col47
	 */
	public String getCol47() {
		return this.col47;
	}
	
	/**
	 * Column Info
	 * @return col35
	 */
	public String getCol35() {
		return this.col35;
	}
	
	/**
	 * Column Info
	 * @return col44
	 */
	public String getCol44() {
		return this.col44;
	}
	
	/**
	 * Column Info
	 * @return col34
	 */
	public String getCol34() {
		return this.col34;
	}
	
	/**
	 * Column Info
	 * @return col45
	 */
	public String getCol45() {
		return this.col45;
	}
	
	/**
	 * Column Info
	 * @return col33
	 */
	public String getCol33() {
		return this.col33;
	}
	
	/**
	 * Column Info
	 * @return col54
	 */
	public String getCol54() {
		return this.col54;
	}
	
	/**
	 * Column Info
	 * @return col42
	 */
	public String getCol42() {
		return this.col42;
	}
	
	/**
	 * Column Info
	 * @return col53
	 */
	public String getCol53() {
		return this.col53;
	}
	
	/**
	 * Column Info
	 * @return col43
	 */
	public String getCol43() {
		return this.col43;
	}
	
	/**
	 * Column Info
	 * @return col52
	 */
	public String getCol52() {
		return this.col52;
	}
	
	/**
	 * Column Info
	 * @return col40
	 */
	public String getCol40() {
		return this.col40;
	}
	
	/**
	 * Column Info
	 * @return col51
	 */
	public String getCol51() {
		return this.col51;
	}
	
	/**
	 * Column Info
	 * @return col41
	 */
	public String getCol41() {
		return this.col41;
	}
	
	/**
	 * Column Info
	 * @return col50
	 */
	public String getCol50() {
		return this.col50;
	}
	

	/**
	 * Column Info
	 * @param col09
	 */
	public void setCol09(String col09) {
		this.col09 = col09;
	}
	
	/**
	 * Column Info
	 * @param col08
	 */
	public void setCol08(String col08) {
		this.col08 = col08;
	}
	
	/**
	 * Column Info
	 * @param col77
	 */
	public void setCol77(String col77) {
		this.col77 = col77;
	}
	
	/**
	 * Column Info
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param col01
	 */
	public void setCol01(String col01) {
		this.col01 = col01;
	}
	
	/**
	 * Column Info
	 * @param col78
	 */
	public void setCol78(String col78) {
		this.col78 = col78;
	}
	
	/**
	 * Column Info
	 * @param col79
	 */
	public void setCol79(String col79) {
		this.col79 = col79;
	}
	
	/**
	 * Column Info
	 * @param col03
	 */
	public void setCol03(String col03) {
		this.col03 = col03;
	}
	
	/**
	 * Column Info
	 * @param col02
	 */
	public void setCol02(String col02) {
		this.col02 = col02;
	}
	
	/**
	 * Column Info
	 * @param col05
	 */
	public void setCol05(String col05) {
		this.col05 = col05;
	}
	
	/**
	 * Column Info
	 * @param col04
	 */
	public void setCol04(String col04) {
		this.col04 = col04;
	}
	
	/**
	 * Column Info
	 * @param col07
	 */
	public void setCol07(String col07) {
		this.col07 = col07;
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
	 * @param col06
	 */
	public void setCol06(String col06) {
		this.col06 = col06;
	}
	
	/**
	 * Column Info
	 * @param col81
	 */
	public void setCol81(String col81) {
		this.col81 = col81;
	}
	
	/**
	 * Column Info
	 * @param col80
	 */
	public void setCol80(String col80) {
		this.col80 = col80;
	}
	
	/**
	 * Column Info
	 * @param col10
	 */
	public void setCol10(String col10) {
		this.col10 = col10;
	}
	
	/**
	 * Column Info
	 * @param col19
	 */
	public void setCol19(String col19) {
		this.col19 = col19;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param col68
	 */
	public void setCol68(String col68) {
		this.col68 = col68;
	}
	
	/**
	 * Column Info
	 * @param col14
	 */
	public void setCol14(String col14) {
		this.col14 = col14;
	}
	
	/**
	 * Column Info
	 * @param col69
	 */
	public void setCol69(String col69) {
		this.col69 = col69;
	}
	
	/**
	 * Column Info
	 * @param col13
	 */
	public void setCol13(String col13) {
		this.col13 = col13;
	}
	
	/**
	 * Column Info
	 * @param col66
	 */
	public void setCol66(String col66) {
		this.col66 = col66;
	}
	
	/**
	 * Column Info
	 * @param col12
	 */
	public void setCol12(String col12) {
		this.col12 = col12;
	}
	
	/**
	 * Column Info
	 * @param col67
	 */
	public void setCol67(String col67) {
		this.col67 = col67;
	}
	
	/**
	 * Column Info
	 * @param col11
	 */
	public void setCol11(String col11) {
		this.col11 = col11;
	}
	
	/**
	 * Column Info
	 * @param col18
	 */
	public void setCol18(String col18) {
		this.col18 = col18;
	}
	
	/**
	 * Column Info
	 * @param col17
	 */
	public void setCol17(String col17) {
		this.col17 = col17;
	}
	
	/**
	 * Column Info
	 * @param col16
	 */
	public void setCol16(String col16) {
		this.col16 = col16;
	}
	
	/**
	 * Column Info
	 * @param col15
	 */
	public void setCol15(String col15) {
		this.col15 = col15;
	}
	
	/**
	 * Column Info
	 * @param col72
	 */
	public void setCol72(String col72) {
		this.col72 = col72;
	}
	
	/**
	 * Column Info
	 * @param col71
	 */
	public void setCol71(String col71) {
		this.col71 = col71;
	}
	
	/**
	 * Column Info
	 * @param col70
	 */
	public void setCol70(String col70) {
		this.col70 = col70;
	}
	
	/**
	 * Column Info
	 * @param col76
	 */
	public void setCol76(String col76) {
		this.col76 = col76;
	}
	
	/**
	 * Column Info
	 * @param col20
	 */
	public void setCol20(String col20) {
		this.col20 = col20;
	}
	
	/**
	 * Column Info
	 * @param col75
	 */
	public void setCol75(String col75) {
		this.col75 = col75;
	}
	
	/**
	 * Column Info
	 * @param col21
	 */
	public void setCol21(String col21) {
		this.col21 = col21;
	}
	
	/**
	 * Column Info
	 * @param col74
	 */
	public void setCol74(String col74) {
		this.col74 = col74;
	}
	
	/**
	 * Column Info
	 * @param col73
	 */
	public void setCol73(String col73) {
		this.col73 = col73;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param col59
	 */
	public void setCol59(String col59) {
		this.col59 = col59;
	}
	
	/**
	 * Column Info
	 * @param col27
	 */
	public void setCol27(String col27) {
		this.col27 = col27;
	}
	
	/**
	 * Column Info
	 * @param col26
	 */
	public void setCol26(String col26) {
		this.col26 = col26;
	}
	
	/**
	 * Column Info
	 * @param col29
	 */
	public void setCol29(String col29) {
		this.col29 = col29;
	}
	
	/**
	 * Column Info
	 * @param col28
	 */
	public void setCol28(String col28) {
		this.col28 = col28;
	}
	
	/**
	 * Column Info
	 * @param col55
	 */
	public void setCol55(String col55) {
		this.col55 = col55;
	}
	
	/**
	 * Column Info
	 * @param col23
	 */
	public void setCol23(String col23) {
		this.col23 = col23;
	}
	
	/**
	 * Column Info
	 * @param col56
	 */
	public void setCol56(String col56) {
		this.col56 = col56;
	}
	
	/**
	 * Column Info
	 * @param col22
	 */
	public void setCol22(String col22) {
		this.col22 = col22;
	}
	
	/**
	 * Column Info
	 * @param col57
	 */
	public void setCol57(String col57) {
		this.col57 = col57;
	}
	
	/**
	 * Column Info
	 * @param col25
	 */
	public void setCol25(String col25) {
		this.col25 = col25;
	}
	
	/**
	 * Column Info
	 * @param col58
	 */
	public void setCol58(String col58) {
		this.col58 = col58;
	}
	
	/**
	 * Column Info
	 * @param col24
	 */
	public void setCol24(String col24) {
		this.col24 = col24;
	}
	
	/**
	 * Column Info
	 * @param col63
	 */
	public void setCol63(String col63) {
		this.col63 = col63;
	}
	
	/**
	 * Column Info
	 * @param col62
	 */
	public void setCol62(String col62) {
		this.col62 = col62;
	}
	
	/**
	 * Column Info
	 * @param col30
	 */
	public void setCol30(String col30) {
		this.col30 = col30;
	}
	
	/**
	 * Column Info
	 * @param col65
	 */
	public void setCol65(String col65) {
		this.col65 = col65;
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
	 * @param col31
	 */
	public void setCol31(String col31) {
		this.col31 = col31;
	}
	
	/**
	 * Column Info
	 * @param col64
	 */
	public void setCol64(String col64) {
		this.col64 = col64;
	}
	
	/**
	 * Column Info
	 * @param col32
	 */
	public void setCol32(String col32) {
		this.col32 = col32;
	}
	
	/**
	 * Column Info
	 * @param col61
	 */
	public void setCol61(String col61) {
		this.col61 = col61;
	}
	
	/**
	 * Column Info
	 * @param col60
	 */
	public void setCol60(String col60) {
		this.col60 = col60;
	}
	
	/**
	 * Column Info
	 * @param custNum
	 */
	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}
	
	/**
	 * Column Info
	 * @param col39
	 */
	public void setCol39(String col39) {
		this.col39 = col39;
	}
	
	/**
	 * Column Info
	 * @param col48
	 */
	public void setCol48(String col48) {
		this.col48 = col48;
	}
	
	/**
	 * Column Info
	 * @param col38
	 */
	public void setCol38(String col38) {
		this.col38 = col38;
	}
	
	/**
	 * Column Info
	 * @param col49
	 */
	public void setCol49(String col49) {
		this.col49 = col49;
	}
	
	/**
	 * Column Info
	 * @param col37
	 */
	public void setCol37(String col37) {
		this.col37 = col37;
	}
	
	/**
	 * Column Info
	 * @param col46
	 */
	public void setCol46(String col46) {
		this.col46 = col46;
	}
	
	/**
	 * Column Info
	 * @param col36
	 */
	public void setCol36(String col36) {
		this.col36 = col36;
	}
	
	/**
	 * Column Info
	 * @param col47
	 */
	public void setCol47(String col47) {
		this.col47 = col47;
	}
	
	/**
	 * Column Info
	 * @param col35
	 */
	public void setCol35(String col35) {
		this.col35 = col35;
	}
	
	/**
	 * Column Info
	 * @param col44
	 */
	public void setCol44(String col44) {
		this.col44 = col44;
	}
	
	/**
	 * Column Info
	 * @param col34
	 */
	public void setCol34(String col34) {
		this.col34 = col34;
	}
	
	/**
	 * Column Info
	 * @param col45
	 */
	public void setCol45(String col45) {
		this.col45 = col45;
	}
	
	/**
	 * Column Info
	 * @param col33
	 */
	public void setCol33(String col33) {
		this.col33 = col33;
	}
	
	/**
	 * Column Info
	 * @param col54
	 */
	public void setCol54(String col54) {
		this.col54 = col54;
	}
	
	/**
	 * Column Info
	 * @param col42
	 */
	public void setCol42(String col42) {
		this.col42 = col42;
	}
	
	/**
	 * Column Info
	 * @param col53
	 */
	public void setCol53(String col53) {
		this.col53 = col53;
	}
	
	/**
	 * Column Info
	 * @param col43
	 */
	public void setCol43(String col43) {
		this.col43 = col43;
	}
	
	/**
	 * Column Info
	 * @param col52
	 */
	public void setCol52(String col52) {
		this.col52 = col52;
	}
	
	/**
	 * Column Info
	 * @param col40
	 */
	public void setCol40(String col40) {
		this.col40 = col40;
	}
	
	/**
	 * Column Info
	 * @param col51
	 */
	public void setCol51(String col51) {
		this.col51 = col51;
	}
	
	/**
	 * Column Info
	 * @param col41
	 */
	public void setCol41(String col41) {
		this.col41 = col41;
	}
	
	/**
	 * Column Info
	 * @param col50
	 */
	public void setCol50(String col50) {
		this.col50 = col50;
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
		setCol09(JSPUtil.getParameter(request, prefix + "col09", ""));
		setCol08(JSPUtil.getParameter(request, prefix + "col08", ""));
		setCol77(JSPUtil.getParameter(request, prefix + "col77", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setCol01(JSPUtil.getParameter(request, prefix + "col01", ""));
		setCol78(JSPUtil.getParameter(request, prefix + "col78", ""));
		setCol79(JSPUtil.getParameter(request, prefix + "col79", ""));
		setCol03(JSPUtil.getParameter(request, prefix + "col03", ""));
		setCol02(JSPUtil.getParameter(request, prefix + "col02", ""));
		setCol05(JSPUtil.getParameter(request, prefix + "col05", ""));
		setCol04(JSPUtil.getParameter(request, prefix + "col04", ""));
		setCol07(JSPUtil.getParameter(request, prefix + "col07", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCol06(JSPUtil.getParameter(request, prefix + "col06", ""));
		setCol81(JSPUtil.getParameter(request, prefix + "col81", ""));
		setCol80(JSPUtil.getParameter(request, prefix + "col80", ""));
		setCol10(JSPUtil.getParameter(request, prefix + "col10", ""));
		setCol19(JSPUtil.getParameter(request, prefix + "col19", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setCol68(JSPUtil.getParameter(request, prefix + "col68", ""));
		setCol14(JSPUtil.getParameter(request, prefix + "col14", ""));
		setCol69(JSPUtil.getParameter(request, prefix + "col69", ""));
		setCol13(JSPUtil.getParameter(request, prefix + "col13", ""));
		setCol66(JSPUtil.getParameter(request, prefix + "col66", ""));
		setCol12(JSPUtil.getParameter(request, prefix + "col12", ""));
		setCol67(JSPUtil.getParameter(request, prefix + "col67", ""));
		setCol11(JSPUtil.getParameter(request, prefix + "col11", ""));
		setCol18(JSPUtil.getParameter(request, prefix + "col18", ""));
		setCol17(JSPUtil.getParameter(request, prefix + "col17", ""));
		setCol16(JSPUtil.getParameter(request, prefix + "col16", ""));
		setCol15(JSPUtil.getParameter(request, prefix + "col15", ""));
		setCol72(JSPUtil.getParameter(request, prefix + "col72", ""));
		setCol71(JSPUtil.getParameter(request, prefix + "col71", ""));
		setCol70(JSPUtil.getParameter(request, prefix + "col70", ""));
		setCol76(JSPUtil.getParameter(request, prefix + "col76", ""));
		setCol20(JSPUtil.getParameter(request, prefix + "col20", ""));
		setCol75(JSPUtil.getParameter(request, prefix + "col75", ""));
		setCol21(JSPUtil.getParameter(request, prefix + "col21", ""));
		setCol74(JSPUtil.getParameter(request, prefix + "col74", ""));
		setCol73(JSPUtil.getParameter(request, prefix + "col73", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCol59(JSPUtil.getParameter(request, prefix + "col59", ""));
		setCol27(JSPUtil.getParameter(request, prefix + "col27", ""));
		setCol26(JSPUtil.getParameter(request, prefix + "col26", ""));
		setCol29(JSPUtil.getParameter(request, prefix + "col29", ""));
		setCol28(JSPUtil.getParameter(request, prefix + "col28", ""));
		setCol55(JSPUtil.getParameter(request, prefix + "col55", ""));
		setCol23(JSPUtil.getParameter(request, prefix + "col23", ""));
		setCol56(JSPUtil.getParameter(request, prefix + "col56", ""));
		setCol22(JSPUtil.getParameter(request, prefix + "col22", ""));
		setCol57(JSPUtil.getParameter(request, prefix + "col57", ""));
		setCol25(JSPUtil.getParameter(request, prefix + "col25", ""));
		setCol58(JSPUtil.getParameter(request, prefix + "col58", ""));
		setCol24(JSPUtil.getParameter(request, prefix + "col24", ""));
		setCol63(JSPUtil.getParameter(request, prefix + "col63", ""));
		setCol62(JSPUtil.getParameter(request, prefix + "col62", ""));
		setCol30(JSPUtil.getParameter(request, prefix + "col30", ""));
		setCol65(JSPUtil.getParameter(request, prefix + "col65", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCol31(JSPUtil.getParameter(request, prefix + "col31", ""));
		setCol64(JSPUtil.getParameter(request, prefix + "col64", ""));
		setCol32(JSPUtil.getParameter(request, prefix + "col32", ""));
		setCol61(JSPUtil.getParameter(request, prefix + "col61", ""));
		setCol60(JSPUtil.getParameter(request, prefix + "col60", ""));
		setCustNum(JSPUtil.getParameter(request, prefix + "cust_num", ""));
		setCol39(JSPUtil.getParameter(request, prefix + "col39", ""));
		setCol48(JSPUtil.getParameter(request, prefix + "col48", ""));
		setCol38(JSPUtil.getParameter(request, prefix + "col38", ""));
		setCol49(JSPUtil.getParameter(request, prefix + "col49", ""));
		setCol37(JSPUtil.getParameter(request, prefix + "col37", ""));
		setCol46(JSPUtil.getParameter(request, prefix + "col46", ""));
		setCol36(JSPUtil.getParameter(request, prefix + "col36", ""));
		setCol47(JSPUtil.getParameter(request, prefix + "col47", ""));
		setCol35(JSPUtil.getParameter(request, prefix + "col35", ""));
		setCol44(JSPUtil.getParameter(request, prefix + "col44", ""));
		setCol34(JSPUtil.getParameter(request, prefix + "col34", ""));
		setCol45(JSPUtil.getParameter(request, prefix + "col45", ""));
		setCol33(JSPUtil.getParameter(request, prefix + "col33", ""));
		setCol54(JSPUtil.getParameter(request, prefix + "col54", ""));
		setCol42(JSPUtil.getParameter(request, prefix + "col42", ""));
		setCol53(JSPUtil.getParameter(request, prefix + "col53", ""));
		setCol43(JSPUtil.getParameter(request, prefix + "col43", ""));
		setCol52(JSPUtil.getParameter(request, prefix + "col52", ""));
		setCol40(JSPUtil.getParameter(request, prefix + "col40", ""));
		setCol51(JSPUtil.getParameter(request, prefix + "col51", ""));
		setCol41(JSPUtil.getParameter(request, prefix + "col41", ""));
		setCol50(JSPUtil.getParameter(request, prefix + "col50", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OTSAgingListVO[]
	 */
	public OTSAgingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OTSAgingListVO[]
	 */
	public OTSAgingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OTSAgingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] col09 = (JSPUtil.getParameter(request, prefix	+ "col09", length));
			String[] col08 = (JSPUtil.getParameter(request, prefix	+ "col08", length));
			String[] col77 = (JSPUtil.getParameter(request, prefix	+ "col77", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] col01 = (JSPUtil.getParameter(request, prefix	+ "col01", length));
			String[] col78 = (JSPUtil.getParameter(request, prefix	+ "col78", length));
			String[] col79 = (JSPUtil.getParameter(request, prefix	+ "col79", length));
			String[] col03 = (JSPUtil.getParameter(request, prefix	+ "col03", length));
			String[] col02 = (JSPUtil.getParameter(request, prefix	+ "col02", length));
			String[] col05 = (JSPUtil.getParameter(request, prefix	+ "col05", length));
			String[] col04 = (JSPUtil.getParameter(request, prefix	+ "col04", length));
			String[] col07 = (JSPUtil.getParameter(request, prefix	+ "col07", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] col06 = (JSPUtil.getParameter(request, prefix	+ "col06", length));
			String[] col81 = (JSPUtil.getParameter(request, prefix	+ "col81", length));
			String[] col80 = (JSPUtil.getParameter(request, prefix	+ "col80", length));
			String[] col10 = (JSPUtil.getParameter(request, prefix	+ "col10", length));
			String[] col19 = (JSPUtil.getParameter(request, prefix	+ "col19", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] col68 = (JSPUtil.getParameter(request, prefix	+ "col68", length));
			String[] col14 = (JSPUtil.getParameter(request, prefix	+ "col14", length));
			String[] col69 = (JSPUtil.getParameter(request, prefix	+ "col69", length));
			String[] col13 = (JSPUtil.getParameter(request, prefix	+ "col13", length));
			String[] col66 = (JSPUtil.getParameter(request, prefix	+ "col66", length));
			String[] col12 = (JSPUtil.getParameter(request, prefix	+ "col12", length));
			String[] col67 = (JSPUtil.getParameter(request, prefix	+ "col67", length));
			String[] col11 = (JSPUtil.getParameter(request, prefix	+ "col11", length));
			String[] col18 = (JSPUtil.getParameter(request, prefix	+ "col18", length));
			String[] col17 = (JSPUtil.getParameter(request, prefix	+ "col17", length));
			String[] col16 = (JSPUtil.getParameter(request, prefix	+ "col16", length));
			String[] col15 = (JSPUtil.getParameter(request, prefix	+ "col15", length));
			String[] col72 = (JSPUtil.getParameter(request, prefix	+ "col72", length));
			String[] col71 = (JSPUtil.getParameter(request, prefix	+ "col71", length));
			String[] col70 = (JSPUtil.getParameter(request, prefix	+ "col70", length));
			String[] col76 = (JSPUtil.getParameter(request, prefix	+ "col76", length));
			String[] col20 = (JSPUtil.getParameter(request, prefix	+ "col20", length));
			String[] col75 = (JSPUtil.getParameter(request, prefix	+ "col75", length));
			String[] col21 = (JSPUtil.getParameter(request, prefix	+ "col21", length));
			String[] col74 = (JSPUtil.getParameter(request, prefix	+ "col74", length));
			String[] col73 = (JSPUtil.getParameter(request, prefix	+ "col73", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] col59 = (JSPUtil.getParameter(request, prefix	+ "col59", length));
			String[] col27 = (JSPUtil.getParameter(request, prefix	+ "col27", length));
			String[] col26 = (JSPUtil.getParameter(request, prefix	+ "col26", length));
			String[] col29 = (JSPUtil.getParameter(request, prefix	+ "col29", length));
			String[] col28 = (JSPUtil.getParameter(request, prefix	+ "col28", length));
			String[] col55 = (JSPUtil.getParameter(request, prefix	+ "col55", length));
			String[] col23 = (JSPUtil.getParameter(request, prefix	+ "col23", length));
			String[] col56 = (JSPUtil.getParameter(request, prefix	+ "col56", length));
			String[] col22 = (JSPUtil.getParameter(request, prefix	+ "col22", length));
			String[] col57 = (JSPUtil.getParameter(request, prefix	+ "col57", length));
			String[] col25 = (JSPUtil.getParameter(request, prefix	+ "col25", length));
			String[] col58 = (JSPUtil.getParameter(request, prefix	+ "col58", length));
			String[] col24 = (JSPUtil.getParameter(request, prefix	+ "col24", length));
			String[] col63 = (JSPUtil.getParameter(request, prefix	+ "col63", length));
			String[] col62 = (JSPUtil.getParameter(request, prefix	+ "col62", length));
			String[] col30 = (JSPUtil.getParameter(request, prefix	+ "col30", length));
			String[] col65 = (JSPUtil.getParameter(request, prefix	+ "col65", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] col31 = (JSPUtil.getParameter(request, prefix	+ "col31", length));
			String[] col64 = (JSPUtil.getParameter(request, prefix	+ "col64", length));
			String[] col32 = (JSPUtil.getParameter(request, prefix	+ "col32", length));
			String[] col61 = (JSPUtil.getParameter(request, prefix	+ "col61", length));
			String[] col60 = (JSPUtil.getParameter(request, prefix	+ "col60", length));
			String[] custNum = (JSPUtil.getParameter(request, prefix	+ "cust_num", length));
			String[] col39 = (JSPUtil.getParameter(request, prefix	+ "col39", length));
			String[] col48 = (JSPUtil.getParameter(request, prefix	+ "col48", length));
			String[] col38 = (JSPUtil.getParameter(request, prefix	+ "col38", length));
			String[] col49 = (JSPUtil.getParameter(request, prefix	+ "col49", length));
			String[] col37 = (JSPUtil.getParameter(request, prefix	+ "col37", length));
			String[] col46 = (JSPUtil.getParameter(request, prefix	+ "col46", length));
			String[] col36 = (JSPUtil.getParameter(request, prefix	+ "col36", length));
			String[] col47 = (JSPUtil.getParameter(request, prefix	+ "col47", length));
			String[] col35 = (JSPUtil.getParameter(request, prefix	+ "col35", length));
			String[] col44 = (JSPUtil.getParameter(request, prefix	+ "col44", length));
			String[] col34 = (JSPUtil.getParameter(request, prefix	+ "col34", length));
			String[] col45 = (JSPUtil.getParameter(request, prefix	+ "col45", length));
			String[] col33 = (JSPUtil.getParameter(request, prefix	+ "col33", length));
			String[] col54 = (JSPUtil.getParameter(request, prefix	+ "col54", length));
			String[] col42 = (JSPUtil.getParameter(request, prefix	+ "col42", length));
			String[] col53 = (JSPUtil.getParameter(request, prefix	+ "col53", length));
			String[] col43 = (JSPUtil.getParameter(request, prefix	+ "col43", length));
			String[] col52 = (JSPUtil.getParameter(request, prefix	+ "col52", length));
			String[] col40 = (JSPUtil.getParameter(request, prefix	+ "col40", length));
			String[] col51 = (JSPUtil.getParameter(request, prefix	+ "col51", length));
			String[] col41 = (JSPUtil.getParameter(request, prefix	+ "col41", length));
			String[] col50 = (JSPUtil.getParameter(request, prefix	+ "col50", length));
			
			for (int i = 0; i < length; i++) {
				model = new OTSAgingListVO();
				if (col09[i] != null)
					model.setCol09(col09[i]);
				if (col08[i] != null)
					model.setCol08(col08[i]);
				if (col77[i] != null)
					model.setCol77(col77[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (col01[i] != null)
					model.setCol01(col01[i]);
				if (col78[i] != null)
					model.setCol78(col78[i]);
				if (col79[i] != null)
					model.setCol79(col79[i]);
				if (col03[i] != null)
					model.setCol03(col03[i]);
				if (col02[i] != null)
					model.setCol02(col02[i]);
				if (col05[i] != null)
					model.setCol05(col05[i]);
				if (col04[i] != null)
					model.setCol04(col04[i]);
				if (col07[i] != null)
					model.setCol07(col07[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (col06[i] != null)
					model.setCol06(col06[i]);
				if (col81[i] != null)
					model.setCol81(col81[i]);
				if (col80[i] != null)
					model.setCol80(col80[i]);
				if (col10[i] != null)
					model.setCol10(col10[i]);
				if (col19[i] != null)
					model.setCol19(col19[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (col68[i] != null)
					model.setCol68(col68[i]);
				if (col14[i] != null)
					model.setCol14(col14[i]);
				if (col69[i] != null)
					model.setCol69(col69[i]);
				if (col13[i] != null)
					model.setCol13(col13[i]);
				if (col66[i] != null)
					model.setCol66(col66[i]);
				if (col12[i] != null)
					model.setCol12(col12[i]);
				if (col67[i] != null)
					model.setCol67(col67[i]);
				if (col11[i] != null)
					model.setCol11(col11[i]);
				if (col18[i] != null)
					model.setCol18(col18[i]);
				if (col17[i] != null)
					model.setCol17(col17[i]);
				if (col16[i] != null)
					model.setCol16(col16[i]);
				if (col15[i] != null)
					model.setCol15(col15[i]);
				if (col72[i] != null)
					model.setCol72(col72[i]);
				if (col71[i] != null)
					model.setCol71(col71[i]);
				if (col70[i] != null)
					model.setCol70(col70[i]);
				if (col76[i] != null)
					model.setCol76(col76[i]);
				if (col20[i] != null)
					model.setCol20(col20[i]);
				if (col75[i] != null)
					model.setCol75(col75[i]);
				if (col21[i] != null)
					model.setCol21(col21[i]);
				if (col74[i] != null)
					model.setCol74(col74[i]);
				if (col73[i] != null)
					model.setCol73(col73[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (col59[i] != null)
					model.setCol59(col59[i]);
				if (col27[i] != null)
					model.setCol27(col27[i]);
				if (col26[i] != null)
					model.setCol26(col26[i]);
				if (col29[i] != null)
					model.setCol29(col29[i]);
				if (col28[i] != null)
					model.setCol28(col28[i]);
				if (col55[i] != null)
					model.setCol55(col55[i]);
				if (col23[i] != null)
					model.setCol23(col23[i]);
				if (col56[i] != null)
					model.setCol56(col56[i]);
				if (col22[i] != null)
					model.setCol22(col22[i]);
				if (col57[i] != null)
					model.setCol57(col57[i]);
				if (col25[i] != null)
					model.setCol25(col25[i]);
				if (col58[i] != null)
					model.setCol58(col58[i]);
				if (col24[i] != null)
					model.setCol24(col24[i]);
				if (col63[i] != null)
					model.setCol63(col63[i]);
				if (col62[i] != null)
					model.setCol62(col62[i]);
				if (col30[i] != null)
					model.setCol30(col30[i]);
				if (col65[i] != null)
					model.setCol65(col65[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (col31[i] != null)
					model.setCol31(col31[i]);
				if (col64[i] != null)
					model.setCol64(col64[i]);
				if (col32[i] != null)
					model.setCol32(col32[i]);
				if (col61[i] != null)
					model.setCol61(col61[i]);
				if (col60[i] != null)
					model.setCol60(col60[i]);
				if (custNum[i] != null)
					model.setCustNum(custNum[i]);
				if (col39[i] != null)
					model.setCol39(col39[i]);
				if (col48[i] != null)
					model.setCol48(col48[i]);
				if (col38[i] != null)
					model.setCol38(col38[i]);
				if (col49[i] != null)
					model.setCol49(col49[i]);
				if (col37[i] != null)
					model.setCol37(col37[i]);
				if (col46[i] != null)
					model.setCol46(col46[i]);
				if (col36[i] != null)
					model.setCol36(col36[i]);
				if (col47[i] != null)
					model.setCol47(col47[i]);
				if (col35[i] != null)
					model.setCol35(col35[i]);
				if (col44[i] != null)
					model.setCol44(col44[i]);
				if (col34[i] != null)
					model.setCol34(col34[i]);
				if (col45[i] != null)
					model.setCol45(col45[i]);
				if (col33[i] != null)
					model.setCol33(col33[i]);
				if (col54[i] != null)
					model.setCol54(col54[i]);
				if (col42[i] != null)
					model.setCol42(col42[i]);
				if (col53[i] != null)
					model.setCol53(col53[i]);
				if (col43[i] != null)
					model.setCol43(col43[i]);
				if (col52[i] != null)
					model.setCol52(col52[i]);
				if (col40[i] != null)
					model.setCol40(col40[i]);
				if (col51[i] != null)
					model.setCol51(col51[i]);
				if (col41[i] != null)
					model.setCol41(col41[i]);
				if (col50[i] != null)
					model.setCol50(col50[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOTSAgingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OTSAgingListVO[]
	 */
	public OTSAgingListVO[] getOTSAgingListVOs(){
		OTSAgingListVO[] vos = (OTSAgingListVO[])models.toArray(new OTSAgingListVO[models.size()]);
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
		this.col09 = this.col09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col08 = this.col08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col77 = this.col77 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col01 = this.col01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col78 = this.col78 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col79 = this.col79 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col03 = this.col03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col02 = this.col02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col05 = this.col05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col04 = this.col04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col07 = this.col07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col06 = this.col06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col81 = this.col81 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col80 = this.col80 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col10 = this.col10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col19 = this.col19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col68 = this.col68 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col14 = this.col14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col69 = this.col69 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col13 = this.col13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col66 = this.col66 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col12 = this.col12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col67 = this.col67 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col11 = this.col11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col18 = this.col18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col17 = this.col17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col16 = this.col16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col15 = this.col15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col72 = this.col72 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col71 = this.col71 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col70 = this.col70 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col76 = this.col76 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col20 = this.col20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col75 = this.col75 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col21 = this.col21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col74 = this.col74 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col73 = this.col73 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col59 = this.col59 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col27 = this.col27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col26 = this.col26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col29 = this.col29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col28 = this.col28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col55 = this.col55 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col23 = this.col23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col56 = this.col56 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col22 = this.col22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col57 = this.col57 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col25 = this.col25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col58 = this.col58 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col24 = this.col24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col63 = this.col63 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col62 = this.col62 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col30 = this.col30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col65 = this.col65 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col31 = this.col31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col64 = this.col64 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col32 = this.col32 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col61 = this.col61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col60 = this.col60 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNum = this.custNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col39 = this.col39 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col48 = this.col48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col38 = this.col38 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col49 = this.col49 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col37 = this.col37 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col46 = this.col46 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col36 = this.col36 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col47 = this.col47 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col35 = this.col35 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col44 = this.col44 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col34 = this.col34 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col45 = this.col45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col33 = this.col33 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col54 = this.col54 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col42 = this.col42 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col53 = this.col53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col43 = this.col43 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col52 = this.col52 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col40 = this.col40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col51 = this.col51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col41 = this.col41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col50 = this.col50 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
