/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CPRTInvoiceVO2.java
*@FileTitle : CPRTInvoiceVO2
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.05.25 한동훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * @author 한동훈 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CPRTInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CPRTInvoiceVO> models = new ArrayList<CPRTInvoiceVO>();
	
	/* Column Info */
	private String inv022 = null;
	/* Column Info */
	private String inv021 = null;
	/* Column Info */
	private String inv020 = null;
	/* Column Info */
	private String inv121 = null;
	/* Column Info */
	private String inv120 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inv113 = null;
	/* Column Info */
	private String inv114 = null;
	/* Column Info */
	private String inv111 = null;
	/* Column Info */
	private String inv112 = null;
	/* Column Info */
	private String inv117 = null;
	/* Column Info */
	private String inv118 = null;
	/* Column Info */
	private String inv115 = null;
	/* Column Info */
	private String inv116 = null;
	/* Column Info */
	private String inv018 = null;
	/* Column Info */
	private String inv019 = null;
	/* Column Info */
	private String inv119 = null;
	/* Column Info */
	private String inv016 = null;
	/* Column Info */
	private String inv017 = null;
	/* Column Info */
	private String inv014 = null;
	/* Column Info */
	private String inv015 = null;
	/* Column Info */
	private String inv012 = null;
	/* Column Info */
	private String inv013 = null;
	/* Column Info */
	private String inv031 = null;
	/* Column Info */
	private String inv030 = null;
	/* Column Info */
	private String inv033 = null;
	/* Column Info */
	private String inv032 = null;
	/* Column Info */
	private String inv130 = null;
	/* Column Info */
	private String inv132 = null;
	/* Column Info */
	private String inv131 = null;
	/* Column Info */
	private String inv122 = null;
	/* Column Info */
	private String inv123 = null;
	/* Column Info */
	private String inv124 = null;
	/* Column Info */
	private String inv125 = null;
	/* Column Info */
	private String inv126 = null;
	/* Column Info */
	private String inv127 = null;
	/* Column Info */
	private String inv128 = null;
	/* Column Info */
	private String inv129 = null;
	/* Column Info */
	private String inv027 = null;
	/* Column Info */
	private String inv028 = null;
	/* Column Info */
	private String inv029 = null;
	/* Column Info */
	private String inv023 = null;
	/* Column Info */
	private String inv024 = null;
	/* Column Info */
	private String inv025 = null;
	/* Column Info */
	private String inv026 = null;
	/* Column Info */
	private String inv078 = null;
	/* Column Info */
	private String inv142 = null;
	/* Column Info */
	private String inv079 = null;
	/* Column Info */
	private String inv141 = null;
	/* Column Info */
	private String inv140 = null;
	/* Column Info */
	private String inv139 = null;
	/* Column Info */
	private String inv082 = null;
	/* Column Info */
	private String inv081 = null;
	/* Column Info */
	private String inv137 = null;
	/* Column Info */
	private String inv084 = null;
	/* Column Info */
	private String inv138 = null;
	/* Column Info */
	private String inv083 = null;
	/* Column Info */
	private String inv135 = null;
	/* Column Info */
	private String inv086 = null;
	/* Column Info */
	private String inv136 = null;
	/* Column Info */
	private String inv085 = null;
	/* Column Info */
	private String inv133 = null;
	/* Column Info */
	private String inv088 = null;
	/* Column Info */
	private String inv134 = null;
	/* Column Info */
	private String inv087 = null;
	/* Column Info */
	private String inv080 = null;
	/* Column Info */
	private String inv011 = null;
	/* Column Info */
	private String inv010 = null;
	/* Column Info */
	private String inv089 = null;
	/* Column Info */
	private String inv095 = null;
	/* Column Info */
	private String inv009 = null;
	/* Column Info */
	private String inv094 = null;
	/* Column Info */
	private String inv093 = null;
	/* Column Info */
	private String inv092 = null;
	/* Column Info */
	private String inv099 = null;
	/* Column Info */
	private String inv098 = null;
	/* Column Info */
	private String inv097 = null;
	/* Column Info */
	private String inv096 = null;
	/* Column Info */
	private String inv001 = null;
	/* Column Info */
	private String inv002 = null;
	/* Column Info */
	private String inv003 = null;
	/* Column Info */
	private String inv004 = null;
	/* Column Info */
	private String inv005 = null;
	/* Column Info */
	private String inv091 = null;
	/* Column Info */
	private String inv006 = null;
	/* Column Info */
	private String inv090 = null;
	/* Column Info */
	private String inv007 = null;
	/* Column Info */
	private String inv008 = null;
	/* Column Info */
	private String inv057 = null;
	/* Column Info */
	private String inv056 = null;
	/* Column Info */
	private String inv059 = null;
	/* Column Info */
	private String inv058 = null;
	/* Column Info */
	private String inv063 = null;
	/* Column Info */
	private String inv064 = null;
	/* Column Info */
	private String inv065 = null;
	/* Column Info */
	private String inv066 = null;
	/* Column Info */
	private String inv060 = null;
	/* Column Info */
	private String inv061 = null;
	/* Column Info */
	private String inv062 = null;
	/* Column Info */
	private String inv069 = null;
	/* Column Info */
	private String inv068 = null;
	/* Column Info */
	private String inv067 = null;
	/* Column Info */
	private String inv076 = null;
	/* Column Info */
	private String inv077 = null;
	/* Column Info */
	private String inv074 = null;
	/* Column Info */
	private String inv075 = null;
	/* Column Info */
	private String inv072 = null;
	/* Column Info */
	private String inv073 = null;
	/* Column Info */
	private String inv070 = null;
	/* Column Info */
	private String inv071 = null;
	/* Column Info */
	private String inv035 = null;
	/* Column Info */
	private String inv034 = null;
	/* Column Info */
	private String inv037 = null;
	/* Column Info */
	private String inv036 = null;
	/* Column Info */
	private String inv039 = null;
	/* Column Info */
	private String inv038 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inv040 = null;
	/* Column Info */
	private String inv041 = null;
	/* Column Info */
	private String inv042 = null;
	/* Column Info */
	private String inv043 = null;
	/* Column Info */
	private String inv044 = null;
	/* Column Info */
	private String inv048 = null;
	/* Column Info */
	private String inv047 = null;
	/* Column Info */
	private String inv046 = null;
	/* Column Info */
	private String inv110 = null;
	/* Column Info */
	private String inv045 = null;
	/* Column Info */
	private String inv049 = null;
	/* Column Info */
	private String rptTmpltNm = null;
	/* Column Info */
	private String inv109 = null;
	/* Column Info */
	private String inv108 = null;
	/* Column Info */
	private String inv105 = null;
	/* Column Info */
	private String inv050 = null;
	/* Column Info */
	private String inv104 = null;
	/* Column Info */
	private String inv051 = null;
	/* Column Info */
	private String inv107 = null;
	/* Column Info */
	private String inv106 = null;
	/* Column Info */
	private String inv101 = null;
	/* Column Info */
	private String inv054 = null;
	/* Column Info */
	private String inv100 = null;
	/* Column Info */
	private String inv055 = null;
	/* Column Info */
	private String inv103 = null;
	/* Column Info */
	private String inv052 = null;
	/* Column Info */
	private String inv102 = null;
	/* Column Info */
	private String inv053 = null;
	/* Column Info */
	private String inv143 = null;
	/* Column Info */
	private String inv144 = null;
	/* Column Info */
	private String inv145 = null;
	/* Column Info */
	private String inv146 = null;
	/* Column Info */
	private String inv147 = null;
	/* Column Info */
	private String inv148 = null;
	/* Column Info */
	private String inv149 = null;
	/* Column Info */
	private String inv150 = null;
	/* Column Info */
	private String inv151 = null;
	/* Column Info */
	private String chg001 = null;
	/* Column Info */
	private String chg002 = null;
	/* Column Info */
	private String chg003 = null;
	/* Column Info */
	private String chg004 = null;
	/* Column Info */
	private String chg005 = null;
	/* Column Info */
	private String chg999 = null;
	/* Column Info */
	private String frtTermCd = null;

	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CPRTInvoiceVO() {}

	public CPRTInvoiceVO(String ibflag, String pagerows, String rptTmpltNm, String frtTermCd, String inv001, String inv002, String inv003, String inv004, String inv005, String inv006, String inv007, String inv008, String inv009, String inv010, String inv011, String inv012, String inv013, String inv014, String inv015, String inv016, String inv017, String inv018, String inv019, String inv020, String inv021, String inv022, String inv023, String inv024, String inv025, String inv026, String inv027, String inv028, String inv029, String inv030, String inv031, String inv032, String inv033, String inv034, String inv035, String inv036, String inv037, String inv038, String inv039, String inv040, String inv041, String inv042, String inv043, String inv044, String inv045, String inv046, String inv047, String inv048, String inv049, String inv050, String inv051, String inv052, String inv053, String inv054, String inv055, String inv056, String inv057, String inv058, String inv059, String inv060, String inv061, String inv062, String inv063, String inv064, String inv065, String inv066, String inv067, String inv068, String inv069, String inv070, String inv071, String inv072, String inv073, String inv074, String inv075, String inv076, String inv077, String inv078, String inv079, String inv080, String inv081, String inv082, String inv083, String inv084, String inv085, String inv086, String inv087, String inv088, String inv089, String inv090, String inv091, String inv092, String inv093, String inv094, String inv095, String inv096, String inv097, String inv098, String inv099, String inv100, String inv101, String inv102, String inv103, String inv104, String inv105, String inv106, String inv107, String inv108, String inv109, String inv110, String inv111, String inv112, String inv113, String inv114, String inv115, String inv116, String inv117, String inv118, String inv119, String inv120, String inv121, String inv122, String inv123, String inv124, String inv125, String inv126, String inv127, String inv128, String inv129, String inv130, String inv131, String inv132, String inv133, String inv134, String inv135, String inv136, String inv137, String inv138, String inv139, String inv140, String inv141, String inv142, String inv143, String inv144, String inv145, String inv146, String inv147, String inv148, String inv149, String inv150, String inv151, String chg001, String chg002, String chg003, String chg004, String chg005, String chg999) {
		this.inv022 = inv022;
		this.inv021 = inv021;
		this.inv020 = inv020;
		this.inv121 = inv121;
		this.inv120 = inv120;
		this.pagerows = pagerows;
		this.inv113 = inv113;
		this.inv114 = inv114;
		this.inv111 = inv111;
		this.inv112 = inv112;
		this.inv117 = inv117;
		this.inv118 = inv118;
		this.inv115 = inv115;
		this.inv116 = inv116;
		this.inv018 = inv018;
		this.inv019 = inv019;
		this.inv119 = inv119;
		this.inv016 = inv016;
		this.inv017 = inv017;
		this.inv014 = inv014;
		this.inv015 = inv015;
		this.inv012 = inv012;
		this.inv013 = inv013;
		this.inv031 = inv031;
		this.inv030 = inv030;
		this.inv033 = inv033;
		this.inv032 = inv032;
		this.inv130 = inv130;
		this.inv132 = inv132;
		this.inv131 = inv131;
		this.inv122 = inv122;
		this.inv123 = inv123;
		this.inv124 = inv124;
		this.inv125 = inv125;
		this.inv126 = inv126;
		this.inv127 = inv127;
		this.inv128 = inv128;
		this.inv129 = inv129;
		this.inv027 = inv027;
		this.inv028 = inv028;
		this.inv029 = inv029;
		this.inv023 = inv023;
		this.inv024 = inv024;
		this.inv025 = inv025;
		this.inv026 = inv026;
		this.inv078 = inv078;
		this.inv142 = inv142;
		this.inv079 = inv079;
		this.inv141 = inv141;
		this.inv140 = inv140;
		this.inv139 = inv139;
		this.inv082 = inv082;
		this.inv081 = inv081;
		this.inv137 = inv137;
		this.inv084 = inv084;
		this.inv138 = inv138;
		this.inv083 = inv083;
		this.inv135 = inv135;
		this.inv086 = inv086;
		this.inv136 = inv136;
		this.inv085 = inv085;
		this.inv133 = inv133;
		this.inv088 = inv088;
		this.inv134 = inv134;
		this.inv087 = inv087;
		this.inv080 = inv080;
		this.inv011 = inv011;
		this.inv010 = inv010;
		this.inv089 = inv089;
		this.inv095 = inv095;
		this.inv009 = inv009;
		this.inv094 = inv094;
		this.inv093 = inv093;
		this.inv092 = inv092;
		this.inv099 = inv099;
		this.inv098 = inv098;
		this.inv097 = inv097;
		this.inv096 = inv096;
		this.inv001 = inv001;
		this.inv002 = inv002;
		this.inv003 = inv003;
		this.inv004 = inv004;
		this.inv005 = inv005;
		this.inv091 = inv091;
		this.inv006 = inv006;
		this.inv090 = inv090;
		this.inv007 = inv007;
		this.inv008 = inv008;
		this.inv057 = inv057;
		this.inv056 = inv056;
		this.inv059 = inv059;
		this.inv058 = inv058;
		this.inv063 = inv063;
		this.inv064 = inv064;
		this.inv065 = inv065;
		this.inv066 = inv066;
		this.inv060 = inv060;
		this.inv061 = inv061;
		this.inv062 = inv062;
		this.inv069 = inv069;
		this.inv068 = inv068;
		this.inv067 = inv067;
		this.inv076 = inv076;
		this.inv077 = inv077;
		this.inv074 = inv074;
		this.inv075 = inv075;
		this.inv072 = inv072;
		this.inv073 = inv073;
		this.inv070 = inv070;
		this.inv071 = inv071;
		this.inv035 = inv035;
		this.inv034 = inv034;
		this.inv037 = inv037;
		this.inv036 = inv036;
		this.inv039 = inv039;
		this.inv038 = inv038;
		this.ibflag = ibflag;
		this.inv040 = inv040;
		this.inv041 = inv041;
		this.inv042 = inv042;
		this.inv043 = inv043;
		this.inv044 = inv044;
		this.inv048 = inv048;
		this.inv047 = inv047;
		this.inv046 = inv046;
		this.inv110 = inv110;
		this.inv045 = inv045;
		this.inv046 = inv046;
		this.inv049 = inv049;
		this.rptTmpltNm = rptTmpltNm;
		this.frtTermCd = frtTermCd;
		this.inv109 = inv109;
		this.inv108 = inv108;
		this.inv105 = inv105;
		this.inv050 = inv050;
		this.inv104 = inv104;
		this.inv051 = inv051;
		this.inv107 = inv107;
		this.inv106 = inv106;
		this.inv101 = inv101;
		this.inv054 = inv054;
		this.inv100 = inv100;
		this.inv055 = inv055;
		this.inv103 = inv103;
		this.inv052 = inv052;
		this.inv102 = inv102;
		this.inv053 = inv053;
		this.inv143 = inv143;
		this.inv144 = inv144;
		this.inv145 = inv145;
		this.inv146 = inv146;
		this.inv147 = inv147;
		this.inv148 = inv148;
		this.inv149 = inv149;
		this.inv150 = inv150;
		this.inv151 = inv151;
		this.chg001 = chg001;
		this.chg002 = chg002;
		this.chg003 = chg003;
		this.chg004 = chg004;
		this.chg005 = chg005;
		this.chg999 = chg999;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv022", getInv022());
		this.hashColumns.put("inv021", getInv021());
		this.hashColumns.put("inv020", getInv020());
		this.hashColumns.put("inv121", getInv121());
		this.hashColumns.put("inv120", getInv120());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv113", getInv113());
		this.hashColumns.put("inv114", getInv114());
		this.hashColumns.put("inv111", getInv111());
		this.hashColumns.put("inv112", getInv112());
		this.hashColumns.put("inv117", getInv117());
		this.hashColumns.put("inv118", getInv118());
		this.hashColumns.put("inv115", getInv115());
		this.hashColumns.put("inv116", getInv116());
		this.hashColumns.put("inv018", getInv018());
		this.hashColumns.put("inv019", getInv019());
		this.hashColumns.put("inv119", getInv119());
		this.hashColumns.put("inv016", getInv016());
		this.hashColumns.put("inv017", getInv017());
		this.hashColumns.put("inv014", getInv014());
		this.hashColumns.put("inv015", getInv015());
		this.hashColumns.put("inv012", getInv012());
		this.hashColumns.put("inv013", getInv013());
		this.hashColumns.put("inv031", getInv031());
		this.hashColumns.put("inv030", getInv030());
		this.hashColumns.put("inv033", getInv033());
		this.hashColumns.put("inv032", getInv032());
		this.hashColumns.put("inv130", getInv130());
		this.hashColumns.put("inv132", getInv132());
		this.hashColumns.put("inv131", getInv131());
		this.hashColumns.put("inv122", getInv122());
		this.hashColumns.put("inv123", getInv123());
		this.hashColumns.put("inv124", getInv124());
		this.hashColumns.put("inv125", getInv125());
		this.hashColumns.put("inv126", getInv126());
		this.hashColumns.put("inv127", getInv127());
		this.hashColumns.put("inv128", getInv128());
		this.hashColumns.put("inv129", getInv129());
		this.hashColumns.put("inv027", getInv027());
		this.hashColumns.put("inv028", getInv028());
		this.hashColumns.put("inv029", getInv029());
		this.hashColumns.put("inv023", getInv023());
		this.hashColumns.put("inv024", getInv024());
		this.hashColumns.put("inv025", getInv025());
		this.hashColumns.put("inv026", getInv026());
		this.hashColumns.put("inv078", getInv078());
		this.hashColumns.put("inv142", getInv142());
		this.hashColumns.put("inv079", getInv079());
		this.hashColumns.put("inv141", getInv141());
		this.hashColumns.put("inv140", getInv140());
		this.hashColumns.put("inv139", getInv139());
		this.hashColumns.put("inv082", getInv082());
		this.hashColumns.put("inv081", getInv081());
		this.hashColumns.put("inv137", getInv137());
		this.hashColumns.put("inv084", getInv084());
		this.hashColumns.put("inv138", getInv138());
		this.hashColumns.put("inv083", getInv083());
		this.hashColumns.put("inv135", getInv135());
		this.hashColumns.put("inv086", getInv086());
		this.hashColumns.put("inv136", getInv136());
		this.hashColumns.put("inv085", getInv085());
		this.hashColumns.put("inv133", getInv133());
		this.hashColumns.put("inv088", getInv088());
		this.hashColumns.put("inv134", getInv134());
		this.hashColumns.put("inv087", getInv087());
		this.hashColumns.put("inv080", getInv080());
		this.hashColumns.put("inv011", getInv011());
		this.hashColumns.put("inv010", getInv010());
		this.hashColumns.put("inv089", getInv089());
		this.hashColumns.put("inv095", getInv095());
		this.hashColumns.put("inv009", getInv009());
		this.hashColumns.put("inv094", getInv094());
		this.hashColumns.put("inv093", getInv093());
		this.hashColumns.put("inv092", getInv092());
		this.hashColumns.put("inv099", getInv099());
		this.hashColumns.put("inv098", getInv098());
		this.hashColumns.put("inv097", getInv097());
		this.hashColumns.put("inv096", getInv096());
		this.hashColumns.put("inv001", getInv001());
		this.hashColumns.put("inv002", getInv002());
		this.hashColumns.put("inv003", getInv003());
		this.hashColumns.put("inv004", getInv004());
		this.hashColumns.put("inv005", getInv005());
		this.hashColumns.put("inv091", getInv091());
		this.hashColumns.put("inv006", getInv006());
		this.hashColumns.put("inv090", getInv090());
		this.hashColumns.put("inv007", getInv007());
		this.hashColumns.put("inv008", getInv008());
		this.hashColumns.put("inv057", getInv057());
		this.hashColumns.put("inv056", getInv056());
		this.hashColumns.put("inv059", getInv059());
		this.hashColumns.put("inv058", getInv058());
		this.hashColumns.put("inv063", getInv063());
		this.hashColumns.put("inv064", getInv064());
		this.hashColumns.put("inv065", getInv065());
		this.hashColumns.put("inv066", getInv066());
		this.hashColumns.put("inv060", getInv060());
		this.hashColumns.put("inv061", getInv061());
		this.hashColumns.put("inv062", getInv062());
		this.hashColumns.put("inv069", getInv069());
		this.hashColumns.put("inv068", getInv068());
		this.hashColumns.put("inv067", getInv067());
		this.hashColumns.put("inv076", getInv076());
		this.hashColumns.put("inv077", getInv077());
		this.hashColumns.put("inv074", getInv074());
		this.hashColumns.put("inv075", getInv075());
		this.hashColumns.put("inv072", getInv072());
		this.hashColumns.put("inv073", getInv073());
		this.hashColumns.put("inv070", getInv070());
		this.hashColumns.put("inv071", getInv071());
		this.hashColumns.put("inv035", getInv035());
		this.hashColumns.put("inv034", getInv034());
		this.hashColumns.put("inv037", getInv037());
		this.hashColumns.put("inv036", getInv036());
		this.hashColumns.put("inv039", getInv039());
		this.hashColumns.put("inv038", getInv038());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv040", getInv040());
		this.hashColumns.put("inv041", getInv041());
		this.hashColumns.put("inv042", getInv042());
		this.hashColumns.put("inv043", getInv043());
		this.hashColumns.put("inv044", getInv044());
		this.hashColumns.put("inv048", getInv048());
		this.hashColumns.put("inv047", getInv047());
		this.hashColumns.put("inv046", getInv046());
		this.hashColumns.put("inv110", getInv110());
		this.hashColumns.put("inv045", getInv045());
		this.hashColumns.put("inv049", getInv049());
		this.hashColumns.put("rpt_tmplt_nm", getRptTmpltNm());
		this.hashColumns.put("inv109", getInv109());
		this.hashColumns.put("inv108", getInv108());
		this.hashColumns.put("inv105", getInv105());
		this.hashColumns.put("inv050", getInv050());
		this.hashColumns.put("inv104", getInv104());
		this.hashColumns.put("inv051", getInv051());
		this.hashColumns.put("inv107", getInv107());
		this.hashColumns.put("inv106", getInv106());
		this.hashColumns.put("inv101", getInv101());
		this.hashColumns.put("inv054", getInv054());
		this.hashColumns.put("inv100", getInv100());
		this.hashColumns.put("inv055", getInv055());
		this.hashColumns.put("inv103", getInv103());
		this.hashColumns.put("inv052", getInv052());
		this.hashColumns.put("inv102", getInv102());
		this.hashColumns.put("inv053", getInv053());
		this.hashColumns.put("inv143", getInv143());
		this.hashColumns.put("inv144", getInv144());
		this.hashColumns.put("inv145", getInv145());
		this.hashColumns.put("inv146", getInv146());
		this.hashColumns.put("inv147", getInv147());
		this.hashColumns.put("inv148", getInv148());
		this.hashColumns.put("inv149", getInv149());
		this.hashColumns.put("inv150", getInv150());
		this.hashColumns.put("inv151", getInv151());
		this.hashColumns.put("chg001", getChg001());
		this.hashColumns.put("chg002", getChg002());
		this.hashColumns.put("chg003", getChg003());
		this.hashColumns.put("chg004", getChg004());
		this.hashColumns.put("chg005", getChg005());
		this.hashColumns.put("chg999", getChg999());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv022", "inv022");
		this.hashFields.put("inv021", "inv021");
		this.hashFields.put("inv020", "inv020");
		this.hashFields.put("inv121", "inv121");
		this.hashFields.put("inv120", "inv120");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv113", "inv113");
		this.hashFields.put("inv114", "inv114");
		this.hashFields.put("inv111", "inv111");
		this.hashFields.put("inv112", "inv112");
		this.hashFields.put("inv117", "inv117");
		this.hashFields.put("inv118", "inv118");
		this.hashFields.put("inv115", "inv115");
		this.hashFields.put("inv116", "inv116");
		this.hashFields.put("inv018", "inv018");
		this.hashFields.put("inv019", "inv019");
		this.hashFields.put("inv119", "inv119");
		this.hashFields.put("inv016", "inv016");
		this.hashFields.put("inv017", "inv017");
		this.hashFields.put("inv014", "inv014");
		this.hashFields.put("inv015", "inv015");
		this.hashFields.put("inv012", "inv012");
		this.hashFields.put("inv013", "inv013");
		this.hashFields.put("inv031", "inv031");
		this.hashFields.put("inv030", "inv030");
		this.hashFields.put("inv033", "inv033");
		this.hashFields.put("inv032", "inv032");
		this.hashFields.put("inv130", "inv130");
		this.hashFields.put("inv132", "inv132");
		this.hashFields.put("inv131", "inv131");
		this.hashFields.put("inv122", "inv122");
		this.hashFields.put("inv123", "inv123");
		this.hashFields.put("inv124", "inv124");
		this.hashFields.put("inv125", "inv125");
		this.hashFields.put("inv126", "inv126");
		this.hashFields.put("inv127", "inv127");
		this.hashFields.put("inv128", "inv128");
		this.hashFields.put("inv129", "inv129");
		this.hashFields.put("inv027", "inv027");
		this.hashFields.put("inv028", "inv028");
		this.hashFields.put("inv029", "inv029");
		this.hashFields.put("inv023", "inv023");
		this.hashFields.put("inv024", "inv024");
		this.hashFields.put("inv025", "inv025");
		this.hashFields.put("inv026", "inv026");
		this.hashFields.put("inv078", "inv078");
		this.hashFields.put("inv142", "inv142");
		this.hashFields.put("inv079", "inv079");
		this.hashFields.put("inv141", "inv141");
		this.hashFields.put("inv140", "inv140");
		this.hashFields.put("inv139", "inv139");
		this.hashFields.put("inv082", "inv082");
		this.hashFields.put("inv081", "inv081");
		this.hashFields.put("inv137", "inv137");
		this.hashFields.put("inv084", "inv084");
		this.hashFields.put("inv138", "inv138");
		this.hashFields.put("inv083", "inv083");
		this.hashFields.put("inv135", "inv135");
		this.hashFields.put("inv086", "inv086");
		this.hashFields.put("inv136", "inv136");
		this.hashFields.put("inv085", "inv085");
		this.hashFields.put("inv133", "inv133");
		this.hashFields.put("inv088", "inv088");
		this.hashFields.put("inv134", "inv134");
		this.hashFields.put("inv087", "inv087");
		this.hashFields.put("inv080", "inv080");
		this.hashFields.put("inv011", "inv011");
		this.hashFields.put("inv010", "inv010");
		this.hashFields.put("inv089", "inv089");
		this.hashFields.put("inv095", "inv095");
		this.hashFields.put("inv009", "inv009");
		this.hashFields.put("inv094", "inv094");
		this.hashFields.put("inv093", "inv093");
		this.hashFields.put("inv092", "inv092");
		this.hashFields.put("inv099", "inv099");
		this.hashFields.put("inv098", "inv098");
		this.hashFields.put("inv097", "inv097");
		this.hashFields.put("inv096", "inv096");
		this.hashFields.put("inv001", "inv001");
		this.hashFields.put("inv002", "inv002");
		this.hashFields.put("inv003", "inv003");
		this.hashFields.put("inv004", "inv004");
		this.hashFields.put("inv005", "inv005");
		this.hashFields.put("inv091", "inv091");
		this.hashFields.put("inv006", "inv006");
		this.hashFields.put("inv090", "inv090");
		this.hashFields.put("inv007", "inv007");
		this.hashFields.put("inv008", "inv008");
		this.hashFields.put("inv057", "inv057");
		this.hashFields.put("inv056", "inv056");
		this.hashFields.put("inv059", "inv059");
		this.hashFields.put("inv058", "inv058");
		this.hashFields.put("inv063", "inv063");
		this.hashFields.put("inv064", "inv064");
		this.hashFields.put("inv065", "inv065");
		this.hashFields.put("inv066", "inv066");
		this.hashFields.put("inv060", "inv060");
		this.hashFields.put("inv061", "inv061");
		this.hashFields.put("inv062", "inv062");
		this.hashFields.put("inv069", "inv069");
		this.hashFields.put("inv068", "inv068");
		this.hashFields.put("inv067", "inv067");
		this.hashFields.put("inv076", "inv076");
		this.hashFields.put("inv077", "inv077");
		this.hashFields.put("inv074", "inv074");
		this.hashFields.put("inv075", "inv075");
		this.hashFields.put("inv072", "inv072");
		this.hashFields.put("inv073", "inv073");
		this.hashFields.put("inv070", "inv070");
		this.hashFields.put("inv071", "inv071");
		this.hashFields.put("inv035", "inv035");
		this.hashFields.put("inv034", "inv034");
		this.hashFields.put("inv037", "inv037");
		this.hashFields.put("inv036", "inv036");
		this.hashFields.put("inv039", "inv039");
		this.hashFields.put("inv038", "inv038");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv040", "inv040");
		this.hashFields.put("inv041", "inv041");
		this.hashFields.put("inv042", "inv042");
		this.hashFields.put("inv043", "inv043");
		this.hashFields.put("inv044", "inv044");
		this.hashFields.put("inv048", "inv048");
		this.hashFields.put("inv047", "inv047");
		this.hashFields.put("inv046", "inv046");
		this.hashFields.put("inv110", "inv110");
		this.hashFields.put("inv045", "inv045");
		this.hashFields.put("inv046", "inv046");
		this.hashFields.put("inv049", "inv049");
		this.hashFields.put("rpt_tmplt_nm", "rptTmpltNm");
		this.hashFields.put("inv109", "inv109");
		this.hashFields.put("inv108", "inv108");
		this.hashFields.put("inv105", "inv105");
		this.hashFields.put("inv050", "inv050");
		this.hashFields.put("inv104", "inv104");
		this.hashFields.put("inv051", "inv051");
		this.hashFields.put("inv107", "inv107");
		this.hashFields.put("inv106", "inv106");
		this.hashFields.put("inv101", "inv101");
		this.hashFields.put("inv054", "inv054");
		this.hashFields.put("inv100", "inv100");
		this.hashFields.put("inv055", "inv055");
		this.hashFields.put("inv103", "inv103");
		this.hashFields.put("inv052", "inv052");
		this.hashFields.put("inv102", "inv102");
		this.hashFields.put("inv053", "inv053");
		this.hashFields.put("inv143", "inv143");
		this.hashFields.put("inv144", "inv144");
		this.hashFields.put("inv145", "inv145");
		this.hashFields.put("inv146", "inv146");
		this.hashFields.put("inv147", "inv147");
		this.hashFields.put("inv148", "inv148");
		this.hashFields.put("inv149", "inv149");
		this.hashFields.put("inv150", "inv150");
		this.hashFields.put("inv151", "inv151");
		this.hashFields.put("chg001", "chg001");
		this.hashFields.put("chg002", "chg002");
		this.hashFields.put("chg003", "chg003");
		this.hashFields.put("chg004", "chg004");
		this.hashFields.put("chg005", "chg005");
		this.hashFields.put("chg999", "chg999");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inv022
	 */
	public String getInv022() {
		return this.inv022;
	}
	
	/**
	 * Column Info
	 * @return inv021
	 */
	public String getInv021() {
		return this.inv021;
	}
	
	/**
	 * Column Info
	 * @return inv020
	 */
	public String getInv020() {
		return this.inv020;
	}
	
	/**
	 * Column Info
	 * @return inv121
	 */
	public String getInv121() {
		return this.inv121;
	}
	
	/**
	 * Column Info
	 * @return inv120
	 */
	public String getInv120() {
		return this.inv120;
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
	 * @return inv113
	 */
	public String getInv113() {
		return this.inv113;
	}
	
	/**
	 * Column Info
	 * @return inv114
	 */
	public String getInv114() {
		return this.inv114;
	}
	
	/**
	 * Column Info
	 * @return inv111
	 */
	public String getInv111() {
		return this.inv111;
	}
	
	/**
	 * Column Info
	 * @return inv112
	 */
	public String getInv112() {
		return this.inv112;
	}
	
	/**
	 * Column Info
	 * @return inv117
	 */
	public String getInv117() {
		return this.inv117;
	}
	
	/**
	 * Column Info
	 * @return inv118
	 */
	public String getInv118() {
		return this.inv118;
	}
	
	/**
	 * Column Info
	 * @return inv115
	 */
	public String getInv115() {
		return this.inv115;
	}
	
	/**
	 * Column Info
	 * @return inv116
	 */
	public String getInv116() {
		return this.inv116;
	}
	
	/**
	 * Column Info
	 * @return inv018
	 */
	public String getInv018() {
		return this.inv018;
	}
	
	/**
	 * Column Info
	 * @return inv019
	 */
	public String getInv019() {
		return this.inv019;
	}
	
	/**
	 * Column Info
	 * @return inv119
	 */
	public String getInv119() {
		return this.inv119;
	}
	
	/**
	 * Column Info
	 * @return inv016
	 */
	public String getInv016() {
		return this.inv016;
	}
	
	/**
	 * Column Info
	 * @return inv017
	 */
	public String getInv017() {
		return this.inv017;
	}
	
	/**
	 * Column Info
	 * @return inv014
	 */
	public String getInv014() {
		return this.inv014;
	}
	
	/**
	 * Column Info
	 * @return inv015
	 */
	public String getInv015() {
		return this.inv015;
	}
	
	/**
	 * Column Info
	 * @return inv012
	 */
	public String getInv012() {
		return this.inv012;
	}
	
	/**
	 * Column Info
	 * @return inv013
	 */
	public String getInv013() {
		return this.inv013;
	}
	
	/**
	 * Column Info
	 * @return inv031
	 */
	public String getInv031() {
		return this.inv031;
	}
	
	/**
	 * Column Info
	 * @return inv030
	 */
	public String getInv030() {
		return this.inv030;
	}
	
	/**
	 * Column Info
	 * @return inv033
	 */
	public String getInv033() {
		return this.inv033;
	}
	
	/**
	 * Column Info
	 * @return inv032
	 */
	public String getInv032() {
		return this.inv032;
	}
	
	/**
	 * Column Info
	 * @return inv130
	 */
	public String getInv130() {
		return this.inv130;
	}
	
	/**
	 * Column Info
	 * @return inv132
	 */
	public String getInv132() {
		return this.inv132;
	}
	
	/**
	 * Column Info
	 * @return inv131
	 */
	public String getInv131() {
		return this.inv131;
	}
	
	/**
	 * Column Info
	 * @return inv122
	 */
	public String getInv122() {
		return this.inv122;
	}
	
	/**
	 * Column Info
	 * @return inv123
	 */
	public String getInv123() {
		return this.inv123;
	}
	
	/**
	 * Column Info
	 * @return inv124
	 */
	public String getInv124() {
		return this.inv124;
	}
	
	/**
	 * Column Info
	 * @return inv125
	 */
	public String getInv125() {
		return this.inv125;
	}
	
	/**
	 * Column Info
	 * @return inv126
	 */
	public String getInv126() {
		return this.inv126;
	}
	
	/**
	 * Column Info
	 * @return inv127
	 */
	public String getInv127() {
		return this.inv127;
	}
	
	/**
	 * Column Info
	 * @return inv128
	 */
	public String getInv128() {
		return this.inv128;
	}
	
	/**
	 * Column Info
	 * @return inv129
	 */
	public String getInv129() {
		return this.inv129;
	}
	
	/**
	 * Column Info
	 * @return inv027
	 */
	public String getInv027() {
		return this.inv027;
	}
	
	/**
	 * Column Info
	 * @return inv028
	 */
	public String getInv028() {
		return this.inv028;
	}
	
	/**
	 * Column Info
	 * @return inv029
	 */
	public String getInv029() {
		return this.inv029;
	}
	
	/**
	 * Column Info
	 * @return inv023
	 */
	public String getInv023() {
		return this.inv023;
	}
	
	/**
	 * Column Info
	 * @return inv024
	 */
	public String getInv024() {
		return this.inv024;
	}
	
	/**
	 * Column Info
	 * @return inv025
	 */
	public String getInv025() {
		return this.inv025;
	}
	
	/**
	 * Column Info
	 * @return inv026
	 */
	public String getInv026() {
		return this.inv026;
	}
	
	/**
	 * Column Info
	 * @return inv078
	 */
	public String getInv078() {
		return this.inv078;
	}
	
	/**
	 * Column Info
	 * @return inv142
	 */
	public String getInv142() {
		return this.inv142;
	}
	
	/**
	 * Column Info
	 * @return inv079
	 */
	public String getInv079() {
		return this.inv079;
	}
	
	/**
	 * Column Info
	 * @return inv141
	 */
	public String getInv141() {
		return this.inv141;
	}
	
	/**
	 * Column Info
	 * @return inv140
	 */
	public String getInv140() {
		return this.inv140;
	}
	
	/**
	 * Column Info
	 * @return inv139
	 */
	public String getInv139() {
		return this.inv139;
	}
	
	/**
	 * Column Info
	 * @return inv082
	 */
	public String getInv082() {
		return this.inv082;
	}
	
	/**
	 * Column Info
	 * @return inv081
	 */
	public String getInv081() {
		return this.inv081;
	}
	
	/**
	 * Column Info
	 * @return inv137
	 */
	public String getInv137() {
		return this.inv137;
	}
	
	/**
	 * Column Info
	 * @return inv084
	 */
	public String getInv084() {
		return this.inv084;
	}
	
	/**
	 * Column Info
	 * @return inv138
	 */
	public String getInv138() {
		return this.inv138;
	}
	
	/**
	 * Column Info
	 * @return inv083
	 */
	public String getInv083() {
		return this.inv083;
	}
	
	/**
	 * Column Info
	 * @return inv135
	 */
	public String getInv135() {
		return this.inv135;
	}
	
	/**
	 * Column Info
	 * @return inv086
	 */
	public String getInv086() {
		return this.inv086;
	}
	
	/**
	 * Column Info
	 * @return inv136
	 */
	public String getInv136() {
		return this.inv136;
	}
	
	/**
	 * Column Info
	 * @return inv085
	 */
	public String getInv085() {
		return this.inv085;
	}
	
	/**
	 * Column Info
	 * @return inv133
	 */
	public String getInv133() {
		return this.inv133;
	}
	
	/**
	 * Column Info
	 * @return inv088
	 */
	public String getInv088() {
		return this.inv088;
	}
	
	/**
	 * Column Info
	 * @return inv134
	 */
	public String getInv134() {
		return this.inv134;
	}
	
	/**
	 * Column Info
	 * @return inv087
	 */
	public String getInv087() {
		return this.inv087;
	}
	
	/**
	 * Column Info
	 * @return inv080
	 */
	public String getInv080() {
		return this.inv080;
	}
	
	/**
	 * Column Info
	 * @return inv011
	 */
	public String getInv011() {
		return this.inv011;
	}
	
	/**
	 * Column Info
	 * @return inv010
	 */
	public String getInv010() {
		return this.inv010;
	}
	
	/**
	 * Column Info
	 * @return inv089
	 */
	public String getInv089() {
		return this.inv089;
	}
	
	/**
	 * Column Info
	 * @return inv095
	 */
	public String getInv095() {
		return this.inv095;
	}
	
	/**
	 * Column Info
	 * @return inv009
	 */
	public String getInv009() {
		return this.inv009;
	}
	
	/**
	 * Column Info
	 * @return inv094
	 */
	public String getInv094() {
		return this.inv094;
	}
	
	/**
	 * Column Info
	 * @return inv093
	 */
	public String getInv093() {
		return this.inv093;
	}
	
	/**
	 * Column Info
	 * @return inv092
	 */
	public String getInv092() {
		return this.inv092;
	}
	
	/**
	 * Column Info
	 * @return inv099
	 */
	public String getInv099() {
		return this.inv099;
	}
	
	/**
	 * Column Info
	 * @return inv098
	 */
	public String getInv098() {
		return this.inv098;
	}
	
	/**
	 * Column Info
	 * @return inv097
	 */
	public String getInv097() {
		return this.inv097;
	}
	
	/**
	 * Column Info
	 * @return inv096
	 */
	public String getInv096() {
		return this.inv096;
	}
	
	/**
	 * Column Info
	 * @return inv001
	 */
	public String getInv001() {
		return this.inv001;
	}
	
	/**
	 * Column Info
	 * @return inv002
	 */
	public String getInv002() {
		return this.inv002;
	}
	
	/**
	 * Column Info
	 * @return inv003
	 */
	public String getInv003() {
		return this.inv003;
	}
	
	/**
	 * Column Info
	 * @return inv004
	 */
	public String getInv004() {
		return this.inv004;
	}
	
	/**
	 * Column Info
	 * @return inv005
	 */
	public String getInv005() {
		return this.inv005;
	}
	
	/**
	 * Column Info
	 * @return inv091
	 */
	public String getInv091() {
		return this.inv091;
	}
	
	/**
	 * Column Info
	 * @return inv006
	 */
	public String getInv006() {
		return this.inv006;
	}
	
	/**
	 * Column Info
	 * @return inv090
	 */
	public String getInv090() {
		return this.inv090;
	}
	
	/**
	 * Column Info
	 * @return inv007
	 */
	public String getInv007() {
		return this.inv007;
	}
	
	/**
	 * Column Info
	 * @return inv008
	 */
	public String getInv008() {
		return this.inv008;
	}
	
	/**
	 * Column Info
	 * @return inv057
	 */
	public String getInv057() {
		return this.inv057;
	}
	
	/**
	 * Column Info
	 * @return inv056
	 */
	public String getInv056() {
		return this.inv056;
	}
	
	/**
	 * Column Info
	 * @return inv059
	 */
	public String getInv059() {
		return this.inv059;
	}
	
	/**
	 * Column Info
	 * @return inv058
	 */
	public String getInv058() {
		return this.inv058;
	}
	
	/**
	 * Column Info
	 * @return inv063
	 */
	public String getInv063() {
		return this.inv063;
	}
	
	/**
	 * Column Info
	 * @return inv064
	 */
	public String getInv064() {
		return this.inv064;
	}
	
	/**
	 * Column Info
	 * @return inv065
	 */
	public String getInv065() {
		return this.inv065;
	}
	
	/**
	 * Column Info
	 * @return inv066
	 */
	public String getInv066() {
		return this.inv066;
	}
	
	/**
	 * Column Info
	 * @return inv060
	 */
	public String getInv060() {
		return this.inv060;
	}
	
	/**
	 * Column Info
	 * @return inv061
	 */
	public String getInv061() {
		return this.inv061;
	}
	
	/**
	 * Column Info
	 * @return inv062
	 */
	public String getInv062() {
		return this.inv062;
	}
	
	/**
	 * Column Info
	 * @return inv069
	 */
	public String getInv069() {
		return this.inv069;
	}
	
	/**
	 * Column Info
	 * @return inv068
	 */
	public String getInv068() {
		return this.inv068;
	}
	
	/**
	 * Column Info
	 * @return inv067
	 */
	public String getInv067() {
		return this.inv067;
	}
	
	/**
	 * Column Info
	 * @return inv076
	 */
	public String getInv076() {
		return this.inv076;
	}
	
	/**
	 * Column Info
	 * @return inv077
	 */
	public String getInv077() {
		return this.inv077;
	}
	
	/**
	 * Column Info
	 * @return inv074
	 */
	public String getInv074() {
		return this.inv074;
	}
	
	/**
	 * Column Info
	 * @return inv075
	 */
	public String getInv075() {
		return this.inv075;
	}
	
	/**
	 * Column Info
	 * @return inv072
	 */
	public String getInv072() {
		return this.inv072;
	}
	
	/**
	 * Column Info
	 * @return inv073
	 */
	public String getInv073() {
		return this.inv073;
	}
	
	/**
	 * Column Info
	 * @return inv070
	 */
	public String getInv070() {
		return this.inv070;
	}
	
	/**
	 * Column Info
	 * @return inv071
	 */
	public String getInv071() {
		return this.inv071;
	}
	
	/**
	 * Column Info
	 * @return inv035
	 */
	public String getInv035() {
		return this.inv035;
	}
	
	/**
	 * Column Info
	 * @return inv034
	 */
	public String getInv034() {
		return this.inv034;
	}
	
	/**
	 * Column Info
	 * @return inv037
	 */
	public String getInv037() {
		return this.inv037;
	}
	
	/**
	 * Column Info
	 * @return inv036
	 */
	public String getInv036() {
		return this.inv036;
	}
	
	/**
	 * Column Info
	 * @return inv039
	 */
	public String getInv039() {
		return this.inv039;
	}
	
	/**
	 * Column Info
	 * @return inv038
	 */
	public String getInv038() {
		return this.inv038;
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
	 * @return inv040
	 */
	public String getInv040() {
		return this.inv040;
	}
	
	/**
	 * Column Info
	 * @return inv041
	 */
	public String getInv041() {
		return this.inv041;
	}
	
	/**
	 * Column Info
	 * @return inv042
	 */
	public String getInv042() {
		return this.inv042;
	}
	
	/**
	 * Column Info
	 * @return inv043
	 */
	public String getInv043() {
		return this.inv043;
	}
	
	/**
	 * Column Info
	 * @return inv044
	 */
	public String getInv044() {
		return this.inv044;
	}
	
	/**
	 * Column Info
	 * @return inv048
	 */
	public String getInv048() {
		return this.inv048;
	}
	
	/**
	 * Column Info
	 * @return inv047
	 */
	public String getInv047() {
		return this.inv047;
	}
	
	/**
	 * Column Info
	 * @return inv046
	 */
	public String getInv046() {
		return this.inv046;
	}
	
	/**
	 * Column Info
	 * @return inv110
	 */
	public String getInv110() {
		return this.inv110;
	}
	
	/**
	 * Column Info
	 * @return inv045
	 */
	public String getInv045() {
		return this.inv045;
	}
	
	/**
	 * Column Info
	 * @return inv049
	 */
	public String getInv049() {
		return this.inv049;
	}
	
	/**
	 * Column Info
	 * @return rptTmpltNm
	 */
	public String getRptTmpltNm() {
		return this.rptTmpltNm;
	}
	
	/**
	 * Column Info
	 * @return inv109
	 */
	public String getInv109() {
		return this.inv109;
	}
	
	/**
	 * Column Info
	 * @return inv108
	 */
	public String getInv108() {
		return this.inv108;
	}
	
	/**
	 * Column Info
	 * @return inv105
	 */
	public String getInv105() {
		return this.inv105;
	}
	
	/**
	 * Column Info
	 * @return inv050
	 */
	public String getInv050() {
		return this.inv050;
	}
	
	/**
	 * Column Info
	 * @return inv104
	 */
	public String getInv104() {
		return this.inv104;
	}
	
	/**
	 * Column Info
	 * @return inv051
	 */
	public String getInv051() {
		return this.inv051;
	}
	
	/**
	 * Column Info
	 * @return inv107
	 */
	public String getInv107() {
		return this.inv107;
	}
	
	/**
	 * Column Info
	 * @return inv106
	 */
	public String getInv106() {
		return this.inv106;
	}
	
	/**
	 * Column Info
	 * @return inv101
	 */
	public String getInv101() {
		return this.inv101;
	}
	
	/**
	 * Column Info
	 * @return inv054
	 */
	public String getInv054() {
		return this.inv054;
	}
	
	/**
	 * Column Info
	 * @return inv100
	 */
	public String getInv100() {
		return this.inv100;
	}
	
	/**
	 * Column Info
	 * @return inv055
	 */
	public String getInv055() {
		return this.inv055;
	}
	
	/**
	 * Column Info
	 * @return inv103
	 */
	public String getInv103() {
		return this.inv103;
	}
	
	/**
	 * Column Info
	 * @return inv052
	 */
	public String getInv052() {
		return this.inv052;
	}
	
	/**
	 * Column Info
	 * @return inv102
	 */
	public String getInv102() {
		return this.inv102;
	}
	
	/**
	 * Column Info
	 * @return inv053
	 */
	public String getInv053() {
		return this.inv053;
	}
	/**
	 * Column Info
	 * @return inv143
	 */
	public String getInv143() {
		return this.inv143;
	}	
	/**
	 * Column Info
	 * @return inv144
	 */
	public String getInv144() {
		return this.inv144;
	}
	
	/**
	 * Column Info
	 * @return inv145
	 */
	public String getInv145() {
		return this.inv145;
	}
	
	/**
	 * Column Info
	 * @return inv146
	 */
	public String getInv146() {
		return this.inv146;
	}
	
	/**
	 * Column Info
	 * @return inv147
	 */
	public String getInv147() {
		return this.inv147;
	}
	
	/**
	 * Column Info
	 * @return inv148
	 */
	public String getInv148() {
		return this.inv148;
	}
	
	/**
	 * Column Info
	 * @return inv149
	 */
	public String getInv149() {
		return this.inv149;
	}
	
	/**
	 * Column Info
	 * @return inv150
	 */
	public String getInv150() {
		return this.inv150;
	}
	
	/**
	 * Column Info
	 * @return inv151
	 */
	public String getInv151() {
		return this.inv151;
	}
	
	/**
	 * Column Info
	 * @return chg001
	 */
	public String getChg001() {
		return this.chg001;
	}
	
	/**
	 * Column Info
	 * @return chg002
	 */
	public String getChg002() {
		return this.chg002;
	}
	
	/**
	 * Column Info
	 * @return chg003
	 */
	public String getChg003() {
		return this.chg003;
	}
	
	/**
	 * Column Info
	 * @return chg004
	 */
	public String getChg004() {
		return this.chg004;
	}
	
	/**
	 * Column Info
	 * @return chg005
	 */
	public String getChg005() {
		return this.chg005;
	}
	
	/**
	 * Column Info
	 * @return chg999
	 */
	public String getChg999() {
		return this.chg999;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return frtTermCd;
	}

	/**
	 * Column Info
	 * @param inv022
	 */
	public void setInv022(String inv022) {
		this.inv022 = inv022;
	}
	
	/**
	 * Column Info
	 * @param inv021
	 */
	public void setInv021(String inv021) {
		this.inv021 = inv021;
	}
	
	/**
	 * Column Info
	 * @param inv020
	 */
	public void setInv020(String inv020) {
		this.inv020 = inv020;
	}
	
	/**
	 * Column Info
	 * @param inv121
	 */
	public void setInv121(String inv121) {
		this.inv121 = inv121;
	}
	
	/**
	 * Column Info
	 * @param inv120
	 */
	public void setInv120(String inv120) {
		this.inv120 = inv120;
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
	 * @param inv113
	 */
	public void setInv113(String inv113) {
		this.inv113 = inv113;
	}
	
	/**
	 * Column Info
	 * @param inv114
	 */
	public void setInv114(String inv114) {
		this.inv114 = inv114;
	}
	
	/**
	 * Column Info
	 * @param inv111
	 */
	public void setInv111(String inv111) {
		this.inv111 = inv111;
	}
	
	/**
	 * Column Info
	 * @param inv112
	 */
	public void setInv112(String inv112) {
		this.inv112 = inv112;
	}
	
	/**
	 * Column Info
	 * @param inv117
	 */
	public void setInv117(String inv117) {
		this.inv117 = inv117;
	}
	
	/**
	 * Column Info
	 * @param inv118
	 */
	public void setInv118(String inv118) {
		this.inv118 = inv118;
	}
	
	/**
	 * Column Info
	 * @param inv115
	 */
	public void setInv115(String inv115) {
		this.inv115 = inv115;
	}
	
	/**
	 * Column Info
	 * @param inv116
	 */
	public void setInv116(String inv116) {
		this.inv116 = inv116;
	}
	
	/**
	 * Column Info
	 * @param inv018
	 */
	public void setInv018(String inv018) {
		this.inv018 = inv018;
	}
	
	/**
	 * Column Info
	 * @param inv019
	 */
	public void setInv019(String inv019) {
		this.inv019 = inv019;
	}
	
	/**
	 * Column Info
	 * @param inv119
	 */
	public void setInv119(String inv119) {
		this.inv119 = inv119;
	}
	
	/**
	 * Column Info
	 * @param inv016
	 */
	public void setInv016(String inv016) {
		this.inv016 = inv016;
	}
	
	/**
	 * Column Info
	 * @param inv017
	 */
	public void setInv017(String inv017) {
		this.inv017 = inv017;
	}
	
	/**
	 * Column Info
	 * @param inv014
	 */
	public void setInv014(String inv014) {
		this.inv014 = inv014;
	}
	
	/**
	 * Column Info
	 * @param inv015
	 */
	public void setInv015(String inv015) {
		this.inv015 = inv015;
	}
	
	/**
	 * Column Info
	 * @param inv012
	 */
	public void setInv012(String inv012) {
		this.inv012 = inv012;
	}
	
	/**
	 * Column Info
	 * @param inv013
	 */
	public void setInv013(String inv013) {
		this.inv013 = inv013;
	}
	
	/**
	 * Column Info
	 * @param inv031
	 */
	public void setInv031(String inv031) {
		this.inv031 = inv031;
	}
	
	/**
	 * Column Info
	 * @param inv030
	 */
	public void setInv030(String inv030) {
		this.inv030 = inv030;
	}
	
	/**
	 * Column Info
	 * @param inv033
	 */
	public void setInv033(String inv033) {
		this.inv033 = inv033;
	}
	
	/**
	 * Column Info
	 * @param inv032
	 */
	public void setInv032(String inv032) {
		this.inv032 = inv032;
	}
	
	/**
	 * Column Info
	 * @param inv130
	 */
	public void setInv130(String inv130) {
		this.inv130 = inv130;
	}
	
	/**
	 * Column Info
	 * @param inv132
	 */
	public void setInv132(String inv132) {
		this.inv132 = inv132;
	}
	
	/**
	 * Column Info
	 * @param inv131
	 */
	public void setInv131(String inv131) {
		this.inv131 = inv131;
	}
	
	/**
	 * Column Info
	 * @param inv122
	 */
	public void setInv122(String inv122) {
		this.inv122 = inv122;
	}
	
	/**
	 * Column Info
	 * @param inv123
	 */
	public void setInv123(String inv123) {
		this.inv123 = inv123;
	}
	
	/**
	 * Column Info
	 * @param inv124
	 */
	public void setInv124(String inv124) {
		this.inv124 = inv124;
	}
	
	/**
	 * Column Info
	 * @param inv125
	 */
	public void setInv125(String inv125) {
		this.inv125 = inv125;
	}
	
	/**
	 * Column Info
	 * @param inv126
	 */
	public void setInv126(String inv126) {
		this.inv126 = inv126;
	}
	
	/**
	 * Column Info
	 * @param inv127
	 */
	public void setInv127(String inv127) {
		this.inv127 = inv127;
	}
	
	/**
	 * Column Info
	 * @param inv128
	 */
	public void setInv128(String inv128) {
		this.inv128 = inv128;
	}
	
	/**
	 * Column Info
	 * @param inv129
	 */
	public void setInv129(String inv129) {
		this.inv129 = inv129;
	}
	
	/**
	 * Column Info
	 * @param inv027
	 */
	public void setInv027(String inv027) {
		this.inv027 = inv027;
	}
	
	/**
	 * Column Info
	 * @param inv028
	 */
	public void setInv028(String inv028) {
		this.inv028 = inv028;
	}
	
	/**
	 * Column Info
	 * @param inv029
	 */
	public void setInv029(String inv029) {
		this.inv029 = inv029;
	}
	
	/**
	 * Column Info
	 * @param inv023
	 */
	public void setInv023(String inv023) {
		this.inv023 = inv023;
	}
	
	/**
	 * Column Info
	 * @param inv024
	 */
	public void setInv024(String inv024) {
		this.inv024 = inv024;
	}
	
	/**
	 * Column Info
	 * @param inv025
	 */
	public void setInv025(String inv025) {
		this.inv025 = inv025;
	}
	
	/**
	 * Column Info
	 * @param inv026
	 */
	public void setInv026(String inv026) {
		this.inv026 = inv026;
	}
	
	/**
	 * Column Info
	 * @param inv078
	 */
	public void setInv078(String inv078) {
		this.inv078 = inv078;
	}
	
	/**
	 * Column Info
	 * @param inv142
	 */
	public void setInv142(String inv142) {
		this.inv142 = inv142;
	}
	
	/**
	 * Column Info
	 * @param inv079
	 */
	public void setInv079(String inv079) {
		this.inv079 = inv079;
	}
	
	/**
	 * Column Info
	 * @param inv141
	 */
	public void setInv141(String inv141) {
		this.inv141 = inv141;
	}
	
	/**
	 * Column Info
	 * @param inv140
	 */
	public void setInv140(String inv140) {
		this.inv140 = inv140;
	}
	
	/**
	 * Column Info
	 * @param inv139
	 */
	public void setInv139(String inv139) {
		this.inv139 = inv139;
	}
	
	/**
	 * Column Info
	 * @param inv082
	 */
	public void setInv082(String inv082) {
		this.inv082 = inv082;
	}
	
	/**
	 * Column Info
	 * @param inv081
	 */
	public void setInv081(String inv081) {
		this.inv081 = inv081;
	}
	
	/**
	 * Column Info
	 * @param inv137
	 */
	public void setInv137(String inv137) {
		this.inv137 = inv137;
	}
	
	/**
	 * Column Info
	 * @param inv084
	 */
	public void setInv084(String inv084) {
		this.inv084 = inv084;
	}
	
	/**
	 * Column Info
	 * @param inv138
	 */
	public void setInv138(String inv138) {
		this.inv138 = inv138;
	}
	
	/**
	 * Column Info
	 * @param inv083
	 */
	public void setInv083(String inv083) {
		this.inv083 = inv083;
	}
	
	/**
	 * Column Info
	 * @param inv135
	 */
	public void setInv135(String inv135) {
		this.inv135 = inv135;
	}
	
	/**
	 * Column Info
	 * @param inv086
	 */
	public void setInv086(String inv086) {
		this.inv086 = inv086;
	}
	
	/**
	 * Column Info
	 * @param inv136
	 */
	public void setInv136(String inv136) {
		this.inv136 = inv136;
	}
	
	/**
	 * Column Info
	 * @param inv085
	 */
	public void setInv085(String inv085) {
		this.inv085 = inv085;
	}
	
	/**
	 * Column Info
	 * @param inv133
	 */
	public void setInv133(String inv133) {
		this.inv133 = inv133;
	}
	
	/**
	 * Column Info
	 * @param inv088
	 */
	public void setInv088(String inv088) {
		this.inv088 = inv088;
	}
	
	/**
	 * Column Info
	 * @param inv134
	 */
	public void setInv134(String inv134) {
		this.inv134 = inv134;
	}
	
	/**
	 * Column Info
	 * @param inv087
	 */
	public void setInv087(String inv087) {
		this.inv087 = inv087;
	}
	
	/**
	 * Column Info
	 * @param inv080
	 */
	public void setInv080(String inv080) {
		this.inv080 = inv080;
	}
	
	/**
	 * Column Info
	 * @param inv011
	 */
	public void setInv011(String inv011) {
		this.inv011 = inv011;
	}
	
	/**
	 * Column Info
	 * @param inv010
	 */
	public void setInv010(String inv010) {
		this.inv010 = inv010;
	}
	
	/**
	 * Column Info
	 * @param inv089
	 */
	public void setInv089(String inv089) {
		this.inv089 = inv089;
	}
	
	/**
	 * Column Info
	 * @param inv095
	 */
	public void setInv095(String inv095) {
		this.inv095 = inv095;
	}
	
	/**
	 * Column Info
	 * @param inv009
	 */
	public void setInv009(String inv009) {
		this.inv009 = inv009;
	}
	
	/**
	 * Column Info
	 * @param inv094
	 */
	public void setInv094(String inv094) {
		this.inv094 = inv094;
	}
	
	/**
	 * Column Info
	 * @param inv093
	 */
	public void setInv093(String inv093) {
		this.inv093 = inv093;
	}
	
	/**
	 * Column Info
	 * @param inv092
	 */
	public void setInv092(String inv092) {
		this.inv092 = inv092;
	}
	
	/**
	 * Column Info
	 * @param inv099
	 */
	public void setInv099(String inv099) {
		this.inv099 = inv099;
	}
	
	/**
	 * Column Info
	 * @param inv098
	 */
	public void setInv098(String inv098) {
		this.inv098 = inv098;
	}
	
	/**
	 * Column Info
	 * @param inv097
	 */
	public void setInv097(String inv097) {
		this.inv097 = inv097;
	}
	
	/**
	 * Column Info
	 * @param inv096
	 */
	public void setInv096(String inv096) {
		this.inv096 = inv096;
	}
	
	/**
	 * Column Info
	 * @param inv001
	 */
	public void setInv001(String inv001) {
		this.inv001 = inv001;
	}
	
	/**
	 * Column Info
	 * @param inv002
	 */
	public void setInv002(String inv002) {
		this.inv002 = inv002;
	}
	
	/**
	 * Column Info
	 * @param inv003
	 */
	public void setInv003(String inv003) {
		this.inv003 = inv003;
	}
	
	/**
	 * Column Info
	 * @param inv004
	 */
	public void setInv004(String inv004) {
		this.inv004 = inv004;
	}
	
	/**
	 * Column Info
	 * @param inv005
	 */
	public void setInv005(String inv005) {
		this.inv005 = inv005;
	}
	
	/**
	 * Column Info
	 * @param inv091
	 */
	public void setInv091(String inv091) {
		this.inv091 = inv091;
	}
	
	/**
	 * Column Info
	 * @param inv006
	 */
	public void setInv006(String inv006) {
		this.inv006 = inv006;
	}
	
	/**
	 * Column Info
	 * @param inv090
	 */
	public void setInv090(String inv090) {
		this.inv090 = inv090;
	}
	
	/**
	 * Column Info
	 * @param inv007
	 */
	public void setInv007(String inv007) {
		this.inv007 = inv007;
	}
	
	/**
	 * Column Info
	 * @param inv008
	 */
	public void setInv008(String inv008) {
		this.inv008 = inv008;
	}
	
	/**
	 * Column Info
	 * @param inv057
	 */
	public void setInv057(String inv057) {
		this.inv057 = inv057;
	}
	
	/**
	 * Column Info
	 * @param inv056
	 */
	public void setInv056(String inv056) {
		this.inv056 = inv056;
	}
	
	/**
	 * Column Info
	 * @param inv059
	 */
	public void setInv059(String inv059) {
		this.inv059 = inv059;
	}
	
	/**
	 * Column Info
	 * @param inv058
	 */
	public void setInv058(String inv058) {
		this.inv058 = inv058;
	}
	
	/**
	 * Column Info
	 * @param inv063
	 */
	public void setInv063(String inv063) {
		this.inv063 = inv063;
	}
	
	/**
	 * Column Info
	 * @param inv064
	 */
	public void setInv064(String inv064) {
		this.inv064 = inv064;
	}
	
	/**
	 * Column Info
	 * @param inv065
	 */
	public void setInv065(String inv065) {
		this.inv065 = inv065;
	}
	
	/**
	 * Column Info
	 * @param inv066
	 */
	public void setInv066(String inv066) {
		this.inv066 = inv066;
	}
	
	/**
	 * Column Info
	 * @param inv060
	 */
	public void setInv060(String inv060) {
		this.inv060 = inv060;
	}
	
	/**
	 * Column Info
	 * @param inv061
	 */
	public void setInv061(String inv061) {
		this.inv061 = inv061;
	}
	
	/**
	 * Column Info
	 * @param inv062
	 */
	public void setInv062(String inv062) {
		this.inv062 = inv062;
	}
	
	/**
	 * Column Info
	 * @param inv069
	 */
	public void setInv069(String inv069) {
		this.inv069 = inv069;
	}
	
	/**
	 * Column Info
	 * @param inv068
	 */
	public void setInv068(String inv068) {
		this.inv068 = inv068;
	}
	
	/**
	 * Column Info
	 * @param inv067
	 */
	public void setInv067(String inv067) {
		this.inv067 = inv067;
	}
	
	/**
	 * Column Info
	 * @param inv076
	 */
	public void setInv076(String inv076) {
		this.inv076 = inv076;
	}
	
	/**
	 * Column Info
	 * @param inv077
	 */
	public void setInv077(String inv077) {
		this.inv077 = inv077;
	}
	
	/**
	 * Column Info
	 * @param inv074
	 */
	public void setInv074(String inv074) {
		this.inv074 = inv074;
	}
	
	/**
	 * Column Info
	 * @param inv075
	 */
	public void setInv075(String inv075) {
		this.inv075 = inv075;
	}
	
	/**
	 * Column Info
	 * @param inv072
	 */
	public void setInv072(String inv072) {
		this.inv072 = inv072;
	}
	
	/**
	 * Column Info
	 * @param inv073
	 */
	public void setInv073(String inv073) {
		this.inv073 = inv073;
	}
	
	/**
	 * Column Info
	 * @param inv070
	 */
	public void setInv070(String inv070) {
		this.inv070 = inv070;
	}
	
	/**
	 * Column Info
	 * @param inv071
	 */
	public void setInv071(String inv071) {
		this.inv071 = inv071;
	}
	
	/**
	 * Column Info
	 * @param inv035
	 */
	public void setInv035(String inv035) {
		this.inv035 = inv035;
	}
	
	/**
	 * Column Info
	 * @param inv034
	 */
	public void setInv034(String inv034) {
		this.inv034 = inv034;
	}
	
	/**
	 * Column Info
	 * @param inv037
	 */
	public void setInv037(String inv037) {
		this.inv037 = inv037;
	}
	
	/**
	 * Column Info
	 * @param inv036
	 */
	public void setInv036(String inv036) {
		this.inv036 = inv036;
	}
	
	/**
	 * Column Info
	 * @param inv039
	 */
	public void setInv039(String inv039) {
		this.inv039 = inv039;
	}
	
	/**
	 * Column Info
	 * @param inv038
	 */
	public void setInv038(String inv038) {
		this.inv038 = inv038;
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
	 * @param inv040
	 */
	public void setInv040(String inv040) {
		this.inv040 = inv040;
	}
	
	/**
	 * Column Info
	 * @param inv041
	 */
	public void setInv041(String inv041) {
		this.inv041 = inv041;
	}
	
	/**
	 * Column Info
	 * @param inv042
	 */
	public void setInv042(String inv042) {
		this.inv042 = inv042;
	}
	
	/**
	 * Column Info
	 * @param inv043
	 */
	public void setInv043(String inv043) {
		this.inv043 = inv043;
	}
	
	/**
	 * Column Info
	 * @param inv044
	 */
	public void setInv044(String inv044) {
		this.inv044 = inv044;
	}
	
	/**
	 * Column Info
	 * @param inv048
	 */
	public void setInv048(String inv048) {
		this.inv048 = inv048;
	}
	
	/**
	 * Column Info
	 * @param inv047
	 */
	public void setInv047(String inv047) {
		this.inv047 = inv047;
	}
	
	/**
	 * Column Info
	 * @param inv046
	 */
	public void setInv046(String inv046) {
		this.inv046 = inv046;
	}
	
	/**
	 * Column Info
	 * @param inv110
	 */
	public void setInv110(String inv110) {
		this.inv110 = inv110;
	}
	
	/**
	 * Column Info
	 * @param inv045
	 */
	public void setInv045(String inv045) {
		this.inv045 = inv045;
	}
	
	/**
	 * Column Info
	 * @param inv049
	 */
	public void setInv049(String inv049) {
		this.inv049 = inv049;
	}
	
	/**
	 * Column Info
	 * @param rptTmpltNm
	 */
	public void setRptTmpltNm(String rptTmpltNm) {
		this.rptTmpltNm = rptTmpltNm;
	}
	
	/**
	 * Column Info
	 * @param inv109
	 */
	public void setInv109(String inv109) {
		this.inv109 = inv109;
	}
	
	/**
	 * Column Info
	 * @param inv108
	 */
	public void setInv108(String inv108) {
		this.inv108 = inv108;
	}
	
	/**
	 * Column Info
	 * @param inv105
	 */
	public void setInv105(String inv105) {
		this.inv105 = inv105;
	}
	
	/**
	 * Column Info
	 * @param inv050
	 */
	public void setInv050(String inv050) {
		this.inv050 = inv050;
	}
	
	/**
	 * Column Info
	 * @param inv104
	 */
	public void setInv104(String inv104) {
		this.inv104 = inv104;
	}
	
	/**
	 * Column Info
	 * @param inv051
	 */
	public void setInv051(String inv051) {
		this.inv051 = inv051;
	}
	
	/**
	 * Column Info
	 * @param inv107
	 */
	public void setInv107(String inv107) {
		this.inv107 = inv107;
	}
	
	/**
	 * Column Info
	 * @param inv106
	 */
	public void setInv106(String inv106) {
		this.inv106 = inv106;
	}
	
	/**
	 * Column Info
	 * @param inv101
	 */
	public void setInv101(String inv101) {
		this.inv101 = inv101;
	}
	
	/**
	 * Column Info
	 * @param inv054
	 */
	public void setInv054(String inv054) {
		this.inv054 = inv054;
	}
	
	/**
	 * Column Info
	 * @param inv100
	 */
	public void setInv100(String inv100) {
		this.inv100 = inv100;
	}
	
	/**
	 * Column Info
	 * @param inv055
	 */
	public void setInv055(String inv055) {
		this.inv055 = inv055;
	}
	
	/**
	 * Column Info
	 * @param inv103
	 */
	public void setInv103(String inv103) {
		this.inv103 = inv103;
	}
	
	/**
	 * Column Info
	 * @param inv052
	 */
	public void setInv052(String inv052) {
		this.inv052 = inv052;
	}
	
	/**
	 * Column Info
	 * @param inv102
	 */
	public void setInv102(String inv102) {
		this.inv102 = inv102;
	}
	
	/**
	 * Column Info
	 * @param inv053
	 */
	public void setInv053(String inv053) {
		this.inv053 = inv053;
	}
	
	/**
	 * Column Info
	 * @param inv143
	 */
	public void setInv143(String inv143) {
		this.inv143 = inv143;
	}
		
	/**
	 * Column Info
	 * @param inv144
	 */
	public void setInv144(String inv144) {
		this.inv144 = inv144;
	}	
	
	/**
	 * Column Info
	 * @param inv145
	 */
	public void setInv145(String inv145) {
		this.inv145 = inv145;
	}
	
	/**
	 * Column Info
	 * @param inv146
	 */
	public void setInv146(String inv146) {
		this.inv146 = inv146;
	}
	
	/**
	 * Column Info
	 * @param inv147
	 */
	public void setInv147(String inv147) {
		this.inv147 = inv147;
	}
	
	/**
	 * Column Info
	 * @param inv148
	 */
	public void setInv148(String inv148) {
		this.inv148 = inv148;
	}
	
	/**
	 * Column Info
	 * @param inv149
	 */
	public void setInv149(String inv149) {
		this.inv149 = inv149;
	}
	
	/**
	 * Column Info
	 * @param inv150
	 */
	public void setInv150(String inv150) {
		this.inv150 = inv150;
	}
	
	/**
	 * Column Info
	 * @param inv151
	 */
	public void setInv151(String inv151) {
		this.inv151 = inv151;
	}
	
	/**
	 * Column Info
	 * @param chg001
	 */
	public void setChg001(String chg001) {
		this.chg001 = chg001;
	}	
	
	/**
	 * Column Info
	 * @param chg002
	 */
	public void setChg002(String chg002) {
		this.chg002 = chg002;
	}	
	
	/**
	 * Column Info
	 * @param chg003
	 */
	public void setChg003(String chg003) {
		this.chg003 = chg003;
	}	
	
	/**
	 * Column Info
	 * @param chg004
	 */
	public void setChg004(String chg004) {
		this.chg004 = chg004;
	}
	
	/**
	 * Column Info
	 * @param chg005
	 */
	public void setChg005(String chg005) {
		this.chg005 = chg005;
	}
	
	/**
	 * Column Info
	 * @param chg999
	 */
	public void setChg999(String chg999) {
		this.chg999 = chg999;
	}	
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
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
		setInv022(JSPUtil.getParameter(request, prefix + "inv022", ""));
		setInv021(JSPUtil.getParameter(request, prefix + "inv021", ""));
		setInv020(JSPUtil.getParameter(request, prefix + "inv020", ""));
		setInv121(JSPUtil.getParameter(request, prefix + "inv121", ""));
		setInv120(JSPUtil.getParameter(request, prefix + "inv120", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInv113(JSPUtil.getParameter(request, prefix + "inv113", ""));
		setInv114(JSPUtil.getParameter(request, prefix + "inv114", ""));
		setInv111(JSPUtil.getParameter(request, prefix + "inv111", ""));
		setInv112(JSPUtil.getParameter(request, prefix + "inv112", ""));
		setInv117(JSPUtil.getParameter(request, prefix + "inv117", ""));
		setInv118(JSPUtil.getParameter(request, prefix + "inv118", ""));
		setInv115(JSPUtil.getParameter(request, prefix + "inv115", ""));
		setInv116(JSPUtil.getParameter(request, prefix + "inv116", ""));
		setInv018(JSPUtil.getParameter(request, prefix + "inv018", ""));
		setInv019(JSPUtil.getParameter(request, prefix + "inv019", ""));
		setInv119(JSPUtil.getParameter(request, prefix + "inv119", ""));
		setInv016(JSPUtil.getParameter(request, prefix + "inv016", ""));
		setInv017(JSPUtil.getParameter(request, prefix + "inv017", ""));
		setInv014(JSPUtil.getParameter(request, prefix + "inv014", ""));
		setInv015(JSPUtil.getParameter(request, prefix + "inv015", ""));
		setInv012(JSPUtil.getParameter(request, prefix + "inv012", ""));
		setInv013(JSPUtil.getParameter(request, prefix + "inv013", ""));
		setInv031(JSPUtil.getParameter(request, prefix + "inv031", ""));
		setInv030(JSPUtil.getParameter(request, prefix + "inv030", ""));
		setInv033(JSPUtil.getParameter(request, prefix + "inv033", ""));
		setInv032(JSPUtil.getParameter(request, prefix + "inv032", ""));
		setInv130(JSPUtil.getParameter(request, prefix + "inv130", ""));
		setInv132(JSPUtil.getParameter(request, prefix + "inv132", ""));
		setInv131(JSPUtil.getParameter(request, prefix + "inv131", ""));
		setInv122(JSPUtil.getParameter(request, prefix + "inv122", ""));
		setInv123(JSPUtil.getParameter(request, prefix + "inv123", ""));
		setInv124(JSPUtil.getParameter(request, prefix + "inv124", ""));
		setInv125(JSPUtil.getParameter(request, prefix + "inv125", ""));
		setInv126(JSPUtil.getParameter(request, prefix + "inv126", ""));
		setInv127(JSPUtil.getParameter(request, prefix + "inv127", ""));
		setInv128(JSPUtil.getParameter(request, prefix + "inv128", ""));
		setInv129(JSPUtil.getParameter(request, prefix + "inv129", ""));
		setInv027(JSPUtil.getParameter(request, prefix + "inv027", ""));
		setInv028(JSPUtil.getParameter(request, prefix + "inv028", ""));
		setInv029(JSPUtil.getParameter(request, prefix + "inv029", ""));
		setInv023(JSPUtil.getParameter(request, prefix + "inv023", ""));
		setInv024(JSPUtil.getParameter(request, prefix + "inv024", ""));
		setInv025(JSPUtil.getParameter(request, prefix + "inv025", ""));
		setInv026(JSPUtil.getParameter(request, prefix + "inv026", ""));
		setInv078(JSPUtil.getParameter(request, prefix + "inv078", ""));
		setInv142(JSPUtil.getParameter(request, prefix + "inv142", ""));
		setInv079(JSPUtil.getParameter(request, prefix + "inv079", ""));
		setInv141(JSPUtil.getParameter(request, prefix + "inv141", ""));
		setInv140(JSPUtil.getParameter(request, prefix + "inv140", ""));
		setInv139(JSPUtil.getParameter(request, prefix + "inv139", ""));
		setInv082(JSPUtil.getParameter(request, prefix + "inv082", ""));
		setInv081(JSPUtil.getParameter(request, prefix + "inv081", ""));
		setInv137(JSPUtil.getParameter(request, prefix + "inv137", ""));
		setInv084(JSPUtil.getParameter(request, prefix + "inv084", ""));
		setInv138(JSPUtil.getParameter(request, prefix + "inv138", ""));
		setInv083(JSPUtil.getParameter(request, prefix + "inv083", ""));
		setInv135(JSPUtil.getParameter(request, prefix + "inv135", ""));
		setInv086(JSPUtil.getParameter(request, prefix + "inv086", ""));
		setInv136(JSPUtil.getParameter(request, prefix + "inv136", ""));
		setInv085(JSPUtil.getParameter(request, prefix + "inv085", ""));
		setInv133(JSPUtil.getParameter(request, prefix + "inv133", ""));
		setInv088(JSPUtil.getParameter(request, prefix + "inv088", ""));
		setInv134(JSPUtil.getParameter(request, prefix + "inv134", ""));
		setInv087(JSPUtil.getParameter(request, prefix + "inv087", ""));
		setInv080(JSPUtil.getParameter(request, prefix + "inv080", ""));
		setInv011(JSPUtil.getParameter(request, prefix + "inv011", ""));
		setInv010(JSPUtil.getParameter(request, prefix + "inv010", ""));
		setInv089(JSPUtil.getParameter(request, prefix + "inv089", ""));
		setInv095(JSPUtil.getParameter(request, prefix + "inv095", ""));
		setInv009(JSPUtil.getParameter(request, prefix + "inv009", ""));
		setInv094(JSPUtil.getParameter(request, prefix + "inv094", ""));
		setInv093(JSPUtil.getParameter(request, prefix + "inv093", ""));
		setInv092(JSPUtil.getParameter(request, prefix + "inv092", ""));
		setInv099(JSPUtil.getParameter(request, prefix + "inv099", ""));
		setInv098(JSPUtil.getParameter(request, prefix + "inv098", ""));
		setInv097(JSPUtil.getParameter(request, prefix + "inv097", ""));
		setInv096(JSPUtil.getParameter(request, prefix + "inv096", ""));
		setInv001(JSPUtil.getParameter(request, prefix + "inv001", ""));
		setInv002(JSPUtil.getParameter(request, prefix + "inv002", ""));
		setInv003(JSPUtil.getParameter(request, prefix + "inv003", ""));
		setInv004(JSPUtil.getParameter(request, prefix + "inv004", ""));
		setInv005(JSPUtil.getParameter(request, prefix + "inv005", ""));
		setInv091(JSPUtil.getParameter(request, prefix + "inv091", ""));
		setInv006(JSPUtil.getParameter(request, prefix + "inv006", ""));
		setInv090(JSPUtil.getParameter(request, prefix + "inv090", ""));
		setInv007(JSPUtil.getParameter(request, prefix + "inv007", ""));
		setInv008(JSPUtil.getParameter(request, prefix + "inv008", ""));
		setInv057(JSPUtil.getParameter(request, prefix + "inv057", ""));
		setInv056(JSPUtil.getParameter(request, prefix + "inv056", ""));
		setInv059(JSPUtil.getParameter(request, prefix + "inv059", ""));
		setInv058(JSPUtil.getParameter(request, prefix + "inv058", ""));
		setInv063(JSPUtil.getParameter(request, prefix + "inv063", ""));
		setInv064(JSPUtil.getParameter(request, prefix + "inv064", ""));
		setInv065(JSPUtil.getParameter(request, prefix + "inv065", ""));
		setInv066(JSPUtil.getParameter(request, prefix + "inv066", ""));
		setInv060(JSPUtil.getParameter(request, prefix + "inv060", ""));
		setInv061(JSPUtil.getParameter(request, prefix + "inv061", ""));
		setInv062(JSPUtil.getParameter(request, prefix + "inv062", ""));
		setInv069(JSPUtil.getParameter(request, prefix + "inv069", ""));
		setInv068(JSPUtil.getParameter(request, prefix + "inv068", ""));
		setInv067(JSPUtil.getParameter(request, prefix + "inv067", ""));
		setInv076(JSPUtil.getParameter(request, prefix + "inv076", ""));
		setInv077(JSPUtil.getParameter(request, prefix + "inv077", ""));
		setInv074(JSPUtil.getParameter(request, prefix + "inv074", ""));
		setInv075(JSPUtil.getParameter(request, prefix + "inv075", ""));
		setInv072(JSPUtil.getParameter(request, prefix + "inv072", ""));
		setInv073(JSPUtil.getParameter(request, prefix + "inv073", ""));
		setInv070(JSPUtil.getParameter(request, prefix + "inv070", ""));
		setInv071(JSPUtil.getParameter(request, prefix + "inv071", ""));
		setInv035(JSPUtil.getParameter(request, prefix + "inv035", ""));
		setInv034(JSPUtil.getParameter(request, prefix + "inv034", ""));
		setInv037(JSPUtil.getParameter(request, prefix + "inv037", ""));
		setInv036(JSPUtil.getParameter(request, prefix + "inv036", ""));
		setInv039(JSPUtil.getParameter(request, prefix + "inv039", ""));
		setInv038(JSPUtil.getParameter(request, prefix + "inv038", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInv040(JSPUtil.getParameter(request, prefix + "inv040", ""));
		setInv041(JSPUtil.getParameter(request, prefix + "inv041", ""));
		setInv042(JSPUtil.getParameter(request, prefix + "inv042", ""));
		setInv043(JSPUtil.getParameter(request, prefix + "inv043", ""));
		setInv044(JSPUtil.getParameter(request, prefix + "inv044", ""));
		setInv048(JSPUtil.getParameter(request, prefix + "inv048", ""));
		setInv047(JSPUtil.getParameter(request, prefix + "inv047", ""));
		setInv046(JSPUtil.getParameter(request, prefix + "inv046", ""));
		setInv110(JSPUtil.getParameter(request, prefix + "inv110", ""));
		setInv045(JSPUtil.getParameter(request, prefix + "inv045", ""));
		setInv049(JSPUtil.getParameter(request, prefix + "inv049", ""));
		setRptTmpltNm(JSPUtil.getParameter(request, prefix + "rpt_tmplt_nm", ""));
		setInv109(JSPUtil.getParameter(request, prefix + "inv109", ""));
		setInv108(JSPUtil.getParameter(request, prefix + "inv108", ""));
		setInv105(JSPUtil.getParameter(request, prefix + "inv105", ""));
		setInv050(JSPUtil.getParameter(request, prefix + "inv050", ""));
		setInv104(JSPUtil.getParameter(request, prefix + "inv104", ""));
		setInv051(JSPUtil.getParameter(request, prefix + "inv051", ""));
		setInv107(JSPUtil.getParameter(request, prefix + "inv107", ""));
		setInv106(JSPUtil.getParameter(request, prefix + "inv106", ""));
		setInv101(JSPUtil.getParameter(request, prefix + "inv101", ""));
		setInv054(JSPUtil.getParameter(request, prefix + "inv054", ""));
		setInv100(JSPUtil.getParameter(request, prefix + "inv100", ""));
		setInv055(JSPUtil.getParameter(request, prefix + "inv055", ""));
		setInv103(JSPUtil.getParameter(request, prefix + "inv103", ""));
		setInv052(JSPUtil.getParameter(request, prefix + "inv052", ""));
		setInv102(JSPUtil.getParameter(request, prefix + "inv102", ""));
		setInv053(JSPUtil.getParameter(request, prefix + "inv053", ""));
		setInv143(JSPUtil.getParameter(request, prefix + "inv143", ""));
		setInv144(JSPUtil.getParameter(request, prefix + "inv144", ""));
		setInv145(JSPUtil.getParameter(request, prefix + "inv145", ""));
		setInv146(JSPUtil.getParameter(request, prefix + "inv146", ""));
		setInv147(JSPUtil.getParameter(request, prefix + "inv147", ""));
		setInv148(JSPUtil.getParameter(request, prefix + "inv148", ""));
		setInv149(JSPUtil.getParameter(request, prefix + "inv149", ""));
		setInv150(JSPUtil.getParameter(request, prefix + "inv150", ""));
		setInv151(JSPUtil.getParameter(request, prefix + "inv151", ""));
		setChg001(JSPUtil.getParameter(request, prefix + "chg001", ""));
		setChg002(JSPUtil.getParameter(request, prefix + "chg002", ""));
		setChg003(JSPUtil.getParameter(request, prefix + "chg003", ""));
		setChg004(JSPUtil.getParameter(request, prefix + "chg004", ""));
		setChg005(JSPUtil.getParameter(request, prefix + "chg005", ""));
		setChg999(JSPUtil.getParameter(request, prefix + "chg999", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CPRTInvoiceVO[]
	 */
	public CPRTInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CPRTInvoiceVO[]
	 */
	public CPRTInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CPRTInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inv022 = (JSPUtil.getParameter(request, prefix	+ "inv022", length));
			String[] inv021 = (JSPUtil.getParameter(request, prefix	+ "inv021", length));
			String[] inv020 = (JSPUtil.getParameter(request, prefix	+ "inv020", length));
			String[] inv121 = (JSPUtil.getParameter(request, prefix	+ "inv121", length));
			String[] inv120 = (JSPUtil.getParameter(request, prefix	+ "inv120", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inv113 = (JSPUtil.getParameter(request, prefix	+ "inv113", length));
			String[] inv114 = (JSPUtil.getParameter(request, prefix	+ "inv114", length));
			String[] inv111 = (JSPUtil.getParameter(request, prefix	+ "inv111", length));
			String[] inv112 = (JSPUtil.getParameter(request, prefix	+ "inv112", length));
			String[] inv117 = (JSPUtil.getParameter(request, prefix	+ "inv117", length));
			String[] inv118 = (JSPUtil.getParameter(request, prefix	+ "inv118", length));
			String[] inv115 = (JSPUtil.getParameter(request, prefix	+ "inv115", length));
			String[] inv116 = (JSPUtil.getParameter(request, prefix	+ "inv116", length));
			String[] inv018 = (JSPUtil.getParameter(request, prefix	+ "inv018", length));
			String[] inv019 = (JSPUtil.getParameter(request, prefix	+ "inv019", length));
			String[] inv119 = (JSPUtil.getParameter(request, prefix	+ "inv119", length));
			String[] inv016 = (JSPUtil.getParameter(request, prefix	+ "inv016", length));
			String[] inv017 = (JSPUtil.getParameter(request, prefix	+ "inv017", length));
			String[] inv014 = (JSPUtil.getParameter(request, prefix	+ "inv014", length));
			String[] inv015 = (JSPUtil.getParameter(request, prefix	+ "inv015", length));
			String[] inv012 = (JSPUtil.getParameter(request, prefix	+ "inv012", length));
			String[] inv013 = (JSPUtil.getParameter(request, prefix	+ "inv013", length));
			String[] inv031 = (JSPUtil.getParameter(request, prefix	+ "inv031", length));
			String[] inv030 = (JSPUtil.getParameter(request, prefix	+ "inv030", length));
			String[] inv033 = (JSPUtil.getParameter(request, prefix	+ "inv033", length));
			String[] inv032 = (JSPUtil.getParameter(request, prefix	+ "inv032", length));
			String[] inv130 = (JSPUtil.getParameter(request, prefix	+ "inv130", length));
			String[] inv132 = (JSPUtil.getParameter(request, prefix	+ "inv132", length));
			String[] inv131 = (JSPUtil.getParameter(request, prefix	+ "inv131", length));
			String[] inv122 = (JSPUtil.getParameter(request, prefix	+ "inv122", length));
			String[] inv123 = (JSPUtil.getParameter(request, prefix	+ "inv123", length));
			String[] inv124 = (JSPUtil.getParameter(request, prefix	+ "inv124", length));
			String[] inv125 = (JSPUtil.getParameter(request, prefix	+ "inv125", length));
			String[] inv126 = (JSPUtil.getParameter(request, prefix	+ "inv126", length));
			String[] inv127 = (JSPUtil.getParameter(request, prefix	+ "inv127", length));
			String[] inv128 = (JSPUtil.getParameter(request, prefix	+ "inv128", length));
			String[] inv129 = (JSPUtil.getParameter(request, prefix	+ "inv129", length));
			String[] inv027 = (JSPUtil.getParameter(request, prefix	+ "inv027", length));
			String[] inv028 = (JSPUtil.getParameter(request, prefix	+ "inv028", length));
			String[] inv029 = (JSPUtil.getParameter(request, prefix	+ "inv029", length));
			String[] inv023 = (JSPUtil.getParameter(request, prefix	+ "inv023", length));
			String[] inv024 = (JSPUtil.getParameter(request, prefix	+ "inv024", length));
			String[] inv025 = (JSPUtil.getParameter(request, prefix	+ "inv025", length));
			String[] inv026 = (JSPUtil.getParameter(request, prefix	+ "inv026", length));
			String[] inv078 = (JSPUtil.getParameter(request, prefix	+ "inv078", length));
			String[] inv142 = (JSPUtil.getParameter(request, prefix	+ "inv142", length));
			String[] inv079 = (JSPUtil.getParameter(request, prefix	+ "inv079", length));
			String[] inv141 = (JSPUtil.getParameter(request, prefix	+ "inv141", length));
			String[] inv140 = (JSPUtil.getParameter(request, prefix	+ "inv140", length));
			String[] inv139 = (JSPUtil.getParameter(request, prefix	+ "inv139", length));
			String[] inv082 = (JSPUtil.getParameter(request, prefix	+ "inv082", length));
			String[] inv081 = (JSPUtil.getParameter(request, prefix	+ "inv081", length));
			String[] inv137 = (JSPUtil.getParameter(request, prefix	+ "inv137", length));
			String[] inv084 = (JSPUtil.getParameter(request, prefix	+ "inv084", length));
			String[] inv138 = (JSPUtil.getParameter(request, prefix	+ "inv138", length));
			String[] inv083 = (JSPUtil.getParameter(request, prefix	+ "inv083", length));
			String[] inv135 = (JSPUtil.getParameter(request, prefix	+ "inv135", length));
			String[] inv086 = (JSPUtil.getParameter(request, prefix	+ "inv086", length));
			String[] inv136 = (JSPUtil.getParameter(request, prefix	+ "inv136", length));
			String[] inv085 = (JSPUtil.getParameter(request, prefix	+ "inv085", length));
			String[] inv133 = (JSPUtil.getParameter(request, prefix	+ "inv133", length));
			String[] inv088 = (JSPUtil.getParameter(request, prefix	+ "inv088", length));
			String[] inv134 = (JSPUtil.getParameter(request, prefix	+ "inv134", length));
			String[] inv087 = (JSPUtil.getParameter(request, prefix	+ "inv087", length));
			String[] inv080 = (JSPUtil.getParameter(request, prefix	+ "inv080", length));
			String[] inv011 = (JSPUtil.getParameter(request, prefix	+ "inv011", length));
			String[] inv010 = (JSPUtil.getParameter(request, prefix	+ "inv010", length));
			String[] inv089 = (JSPUtil.getParameter(request, prefix	+ "inv089", length));
			String[] inv095 = (JSPUtil.getParameter(request, prefix	+ "inv095", length));
			String[] inv009 = (JSPUtil.getParameter(request, prefix	+ "inv009", length));
			String[] inv094 = (JSPUtil.getParameter(request, prefix	+ "inv094", length));
			String[] inv093 = (JSPUtil.getParameter(request, prefix	+ "inv093", length));
			String[] inv092 = (JSPUtil.getParameter(request, prefix	+ "inv092", length));
			String[] inv099 = (JSPUtil.getParameter(request, prefix	+ "inv099", length));
			String[] inv098 = (JSPUtil.getParameter(request, prefix	+ "inv098", length));
			String[] inv097 = (JSPUtil.getParameter(request, prefix	+ "inv097", length));
			String[] inv096 = (JSPUtil.getParameter(request, prefix	+ "inv096", length));
			String[] inv001 = (JSPUtil.getParameter(request, prefix	+ "inv001", length));
			String[] inv002 = (JSPUtil.getParameter(request, prefix	+ "inv002", length));
			String[] inv003 = (JSPUtil.getParameter(request, prefix	+ "inv003", length));
			String[] inv004 = (JSPUtil.getParameter(request, prefix	+ "inv004", length));
			String[] inv005 = (JSPUtil.getParameter(request, prefix	+ "inv005", length));
			String[] inv091 = (JSPUtil.getParameter(request, prefix	+ "inv091", length));
			String[] inv006 = (JSPUtil.getParameter(request, prefix	+ "inv006", length));
			String[] inv090 = (JSPUtil.getParameter(request, prefix	+ "inv090", length));
			String[] inv007 = (JSPUtil.getParameter(request, prefix	+ "inv007", length));
			String[] inv008 = (JSPUtil.getParameter(request, prefix	+ "inv008", length));
			String[] inv057 = (JSPUtil.getParameter(request, prefix	+ "inv057", length));
			String[] inv056 = (JSPUtil.getParameter(request, prefix	+ "inv056", length));
			String[] inv059 = (JSPUtil.getParameter(request, prefix	+ "inv059", length));
			String[] inv058 = (JSPUtil.getParameter(request, prefix	+ "inv058", length));
			String[] inv063 = (JSPUtil.getParameter(request, prefix	+ "inv063", length));
			String[] inv064 = (JSPUtil.getParameter(request, prefix	+ "inv064", length));
			String[] inv065 = (JSPUtil.getParameter(request, prefix	+ "inv065", length));
			String[] inv066 = (JSPUtil.getParameter(request, prefix	+ "inv066", length));
			String[] inv060 = (JSPUtil.getParameter(request, prefix	+ "inv060", length));
			String[] inv061 = (JSPUtil.getParameter(request, prefix	+ "inv061", length));
			String[] inv062 = (JSPUtil.getParameter(request, prefix	+ "inv062", length));
			String[] inv069 = (JSPUtil.getParameter(request, prefix	+ "inv069", length));
			String[] inv068 = (JSPUtil.getParameter(request, prefix	+ "inv068", length));
			String[] inv067 = (JSPUtil.getParameter(request, prefix	+ "inv067", length));
			String[] inv076 = (JSPUtil.getParameter(request, prefix	+ "inv076", length));
			String[] inv077 = (JSPUtil.getParameter(request, prefix	+ "inv077", length));
			String[] inv074 = (JSPUtil.getParameter(request, prefix	+ "inv074", length));
			String[] inv075 = (JSPUtil.getParameter(request, prefix	+ "inv075", length));
			String[] inv072 = (JSPUtil.getParameter(request, prefix	+ "inv072", length));
			String[] inv073 = (JSPUtil.getParameter(request, prefix	+ "inv073", length));
			String[] inv070 = (JSPUtil.getParameter(request, prefix	+ "inv070", length));
			String[] inv071 = (JSPUtil.getParameter(request, prefix	+ "inv071", length));
			String[] inv035 = (JSPUtil.getParameter(request, prefix	+ "inv035", length));
			String[] inv034 = (JSPUtil.getParameter(request, prefix	+ "inv034", length));
			String[] inv037 = (JSPUtil.getParameter(request, prefix	+ "inv037", length));
			String[] inv036 = (JSPUtil.getParameter(request, prefix	+ "inv036", length));
			String[] inv039 = (JSPUtil.getParameter(request, prefix	+ "inv039", length));
			String[] inv038 = (JSPUtil.getParameter(request, prefix	+ "inv038", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inv040 = (JSPUtil.getParameter(request, prefix	+ "inv040", length));
			String[] inv041 = (JSPUtil.getParameter(request, prefix	+ "inv041", length));
			String[] inv042 = (JSPUtil.getParameter(request, prefix	+ "inv042", length));
			String[] inv043 = (JSPUtil.getParameter(request, prefix	+ "inv043", length));
			String[] inv044 = (JSPUtil.getParameter(request, prefix	+ "inv044", length));
			String[] inv048 = (JSPUtil.getParameter(request, prefix	+ "inv048", length));
			String[] inv047 = (JSPUtil.getParameter(request, prefix	+ "inv047", length));
			String[] inv046 = (JSPUtil.getParameter(request, prefix	+ "inv046", length));
			String[] inv110 = (JSPUtil.getParameter(request, prefix	+ "inv110", length));
			String[] inv045 = (JSPUtil.getParameter(request, prefix	+ "inv045", length));
			String[] inv049 = (JSPUtil.getParameter(request, prefix	+ "inv049", length));
			String[] rptTmpltNm = (JSPUtil.getParameter(request, prefix	+ "rpt_tmplt_nm", length));
			String[] inv109 = (JSPUtil.getParameter(request, prefix	+ "inv109", length));
			String[] inv108 = (JSPUtil.getParameter(request, prefix	+ "inv108", length));
			String[] inv105 = (JSPUtil.getParameter(request, prefix	+ "inv105", length));
			String[] inv050 = (JSPUtil.getParameter(request, prefix	+ "inv050", length));
			String[] inv104 = (JSPUtil.getParameter(request, prefix	+ "inv104", length));
			String[] inv051 = (JSPUtil.getParameter(request, prefix	+ "inv051", length));
			String[] inv107 = (JSPUtil.getParameter(request, prefix	+ "inv107", length));
			String[] inv106 = (JSPUtil.getParameter(request, prefix	+ "inv106", length));
			String[] inv101 = (JSPUtil.getParameter(request, prefix	+ "inv101", length));
			String[] inv054 = (JSPUtil.getParameter(request, prefix	+ "inv054", length));
			String[] inv100 = (JSPUtil.getParameter(request, prefix	+ "inv100", length));
			String[] inv055 = (JSPUtil.getParameter(request, prefix	+ "inv055", length));
			String[] inv103 = (JSPUtil.getParameter(request, prefix	+ "inv103", length));
			String[] inv052 = (JSPUtil.getParameter(request, prefix	+ "inv052", length));
			String[] inv102 = (JSPUtil.getParameter(request, prefix	+ "inv102", length));
			String[] inv053 = (JSPUtil.getParameter(request, prefix	+ "inv053", length));
			String[] inv143 = (JSPUtil.getParameter(request, prefix	+ "inv143", length));
			String[] inv144 = (JSPUtil.getParameter(request, prefix	+ "inv144", length));
			String[] inv145 = (JSPUtil.getParameter(request, prefix	+ "inv145", length));
			String[] inv146 = (JSPUtil.getParameter(request, prefix	+ "inv146", length));
			String[] inv147 = (JSPUtil.getParameter(request, prefix	+ "inv147", length));
			String[] inv148 = (JSPUtil.getParameter(request, prefix	+ "inv148", length));
			String[] inv149 = (JSPUtil.getParameter(request, prefix	+ "inv149", length));
			String[] inv150 = (JSPUtil.getParameter(request, prefix	+ "inv150", length));
			String[] inv151 = (JSPUtil.getParameter(request, prefix	+ "inv151", length));
			String[] chg001 = (JSPUtil.getParameter(request, prefix	+ "chg001", length));
			String[] chg002 = (JSPUtil.getParameter(request, prefix	+ "chg002", length));
			String[] chg003 = (JSPUtil.getParameter(request, prefix	+ "chg003", length));
			String[] chg004 = (JSPUtil.getParameter(request, prefix	+ "chg004", length));
			String[] chg005 = (JSPUtil.getParameter(request, prefix	+ "chg005", length));
			String[] chg999 = (JSPUtil.getParameter(request, prefix	+ "chg999", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));

			
			
			for (int i = 0; i < length; i++) {
				model = new CPRTInvoiceVO();
				if (inv022[i] != null)
					model.setInv022(inv022[i]);
				if (inv021[i] != null)
					model.setInv021(inv021[i]);
				if (inv020[i] != null)
					model.setInv020(inv020[i]);
				if (inv121[i] != null)
					model.setInv121(inv121[i]);
				if (inv120[i] != null)
					model.setInv120(inv120[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inv113[i] != null)
					model.setInv113(inv113[i]);
				if (inv114[i] != null)
					model.setInv114(inv114[i]);
				if (inv111[i] != null)
					model.setInv111(inv111[i]);
				if (inv112[i] != null)
					model.setInv112(inv112[i]);
				if (inv117[i] != null)
					model.setInv117(inv117[i]);
				if (inv118[i] != null)
					model.setInv118(inv118[i]);
				if (inv115[i] != null)
					model.setInv115(inv115[i]);
				if (inv116[i] != null)
					model.setInv116(inv116[i]);
				if (inv018[i] != null)
					model.setInv018(inv018[i]);
				if (inv019[i] != null)
					model.setInv019(inv019[i]);
				if (inv119[i] != null)
					model.setInv119(inv119[i]);
				if (inv016[i] != null)
					model.setInv016(inv016[i]);
				if (inv017[i] != null)
					model.setInv017(inv017[i]);
				if (inv014[i] != null)
					model.setInv014(inv014[i]);
				if (inv015[i] != null)
					model.setInv015(inv015[i]);
				if (inv012[i] != null)
					model.setInv012(inv012[i]);
				if (inv013[i] != null)
					model.setInv013(inv013[i]);
				if (inv031[i] != null)
					model.setInv031(inv031[i]);
				if (inv030[i] != null)
					model.setInv030(inv030[i]);
				if (inv033[i] != null)
					model.setInv033(inv033[i]);
				if (inv032[i] != null)
					model.setInv032(inv032[i]);
				if (inv130[i] != null)
					model.setInv130(inv130[i]);
				if (inv132[i] != null)
					model.setInv132(inv132[i]);
				if (inv131[i] != null)
					model.setInv131(inv131[i]);
				if (inv122[i] != null)
					model.setInv122(inv122[i]);
				if (inv123[i] != null)
					model.setInv123(inv123[i]);
				if (inv124[i] != null)
					model.setInv124(inv124[i]);
				if (inv125[i] != null)
					model.setInv125(inv125[i]);
				if (inv126[i] != null)
					model.setInv126(inv126[i]);
				if (inv127[i] != null)
					model.setInv127(inv127[i]);
				if (inv128[i] != null)
					model.setInv128(inv128[i]);
				if (inv129[i] != null)
					model.setInv129(inv129[i]);
				if (inv027[i] != null)
					model.setInv027(inv027[i]);
				if (inv028[i] != null)
					model.setInv028(inv028[i]);
				if (inv029[i] != null)
					model.setInv029(inv029[i]);
				if (inv023[i] != null)
					model.setInv023(inv023[i]);
				if (inv024[i] != null)
					model.setInv024(inv024[i]);
				if (inv025[i] != null)
					model.setInv025(inv025[i]);
				if (inv026[i] != null)
					model.setInv026(inv026[i]);
				if (inv078[i] != null)
					model.setInv078(inv078[i]);
				if (inv142[i] != null)
					model.setInv142(inv142[i]);
				if (inv079[i] != null)
					model.setInv079(inv079[i]);
				if (inv141[i] != null)
					model.setInv141(inv141[i]);
				if (inv140[i] != null)
					model.setInv140(inv140[i]);
				if (inv139[i] != null)
					model.setInv139(inv139[i]);
				if (inv082[i] != null)
					model.setInv082(inv082[i]);
				if (inv081[i] != null)
					model.setInv081(inv081[i]);
				if (inv137[i] != null)
					model.setInv137(inv137[i]);
				if (inv084[i] != null)
					model.setInv084(inv084[i]);
				if (inv138[i] != null)
					model.setInv138(inv138[i]);
				if (inv083[i] != null)
					model.setInv083(inv083[i]);
				if (inv135[i] != null)
					model.setInv135(inv135[i]);
				if (inv086[i] != null)
					model.setInv086(inv086[i]);
				if (inv136[i] != null)
					model.setInv136(inv136[i]);
				if (inv085[i] != null)
					model.setInv085(inv085[i]);
				if (inv133[i] != null)
					model.setInv133(inv133[i]);
				if (inv088[i] != null)
					model.setInv088(inv088[i]);
				if (inv134[i] != null)
					model.setInv134(inv134[i]);
				if (inv087[i] != null)
					model.setInv087(inv087[i]);
				if (inv080[i] != null)
					model.setInv080(inv080[i]);
				if (inv011[i] != null)
					model.setInv011(inv011[i]);
				if (inv010[i] != null)
					model.setInv010(inv010[i]);
				if (inv089[i] != null)
					model.setInv089(inv089[i]);
				if (inv095[i] != null)
					model.setInv095(inv095[i]);
				if (inv009[i] != null)
					model.setInv009(inv009[i]);
				if (inv094[i] != null)
					model.setInv094(inv094[i]);
				if (inv093[i] != null)
					model.setInv093(inv093[i]);
				if (inv092[i] != null)
					model.setInv092(inv092[i]);
				if (inv099[i] != null)
					model.setInv099(inv099[i]);
				if (inv098[i] != null)
					model.setInv098(inv098[i]);
				if (inv097[i] != null)
					model.setInv097(inv097[i]);
				if (inv096[i] != null)
					model.setInv096(inv096[i]);
				if (inv001[i] != null)
					model.setInv001(inv001[i]);
				if (inv002[i] != null)
					model.setInv002(inv002[i]);
				if (inv003[i] != null)
					model.setInv003(inv003[i]);
				if (inv004[i] != null)
					model.setInv004(inv004[i]);
				if (inv005[i] != null)
					model.setInv005(inv005[i]);
				if (inv091[i] != null)
					model.setInv091(inv091[i]);
				if (inv006[i] != null)
					model.setInv006(inv006[i]);
				if (inv090[i] != null)
					model.setInv090(inv090[i]);
				if (inv007[i] != null)
					model.setInv007(inv007[i]);
				if (inv008[i] != null)
					model.setInv008(inv008[i]);
				if (inv057[i] != null)
					model.setInv057(inv057[i]);
				if (inv056[i] != null)
					model.setInv056(inv056[i]);
				if (inv059[i] != null)
					model.setInv059(inv059[i]);
				if (inv058[i] != null)
					model.setInv058(inv058[i]);
				if (inv063[i] != null)
					model.setInv063(inv063[i]);
				if (inv064[i] != null)
					model.setInv064(inv064[i]);
				if (inv065[i] != null)
					model.setInv065(inv065[i]);
				if (inv066[i] != null)
					model.setInv066(inv066[i]);
				if (inv060[i] != null)
					model.setInv060(inv060[i]);
				if (inv061[i] != null)
					model.setInv061(inv061[i]);
				if (inv062[i] != null)
					model.setInv062(inv062[i]);
				if (inv069[i] != null)
					model.setInv069(inv069[i]);
				if (inv068[i] != null)
					model.setInv068(inv068[i]);
				if (inv067[i] != null)
					model.setInv067(inv067[i]);
				if (inv076[i] != null)
					model.setInv076(inv076[i]);
				if (inv077[i] != null)
					model.setInv077(inv077[i]);
				if (inv074[i] != null)
					model.setInv074(inv074[i]);
				if (inv075[i] != null)
					model.setInv075(inv075[i]);
				if (inv072[i] != null)
					model.setInv072(inv072[i]);
				if (inv073[i] != null)
					model.setInv073(inv073[i]);
				if (inv070[i] != null)
					model.setInv070(inv070[i]);
				if (inv071[i] != null)
					model.setInv071(inv071[i]);
				if (inv035[i] != null)
					model.setInv035(inv035[i]);
				if (inv034[i] != null)
					model.setInv034(inv034[i]);
				if (inv037[i] != null)
					model.setInv037(inv037[i]);
				if (inv036[i] != null)
					model.setInv036(inv036[i]);
				if (inv039[i] != null)
					model.setInv039(inv039[i]);
				if (inv038[i] != null)
					model.setInv038(inv038[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inv040[i] != null)
					model.setInv040(inv040[i]);
				if (inv041[i] != null)
					model.setInv041(inv041[i]);
				if (inv042[i] != null)
					model.setInv042(inv042[i]);
				if (inv043[i] != null)
					model.setInv043(inv043[i]);
				if (inv044[i] != null)
					model.setInv044(inv044[i]);
				if (inv048[i] != null)
					model.setInv048(inv048[i]);
				if (inv047[i] != null)
					model.setInv047(inv047[i]);
				if (inv046[i] != null)
					model.setInv046(inv046[i]);
				if (inv110[i] != null)
					model.setInv110(inv110[i]);
				if (inv045[i] != null)
					model.setInv045(inv045[i]);
				if (inv049[i] != null)
					model.setInv049(inv049[i]);
				if (rptTmpltNm[i] != null)
					model.setRptTmpltNm(rptTmpltNm[i]);
				if (inv109[i] != null)
					model.setInv109(inv109[i]);
				if (inv108[i] != null)
					model.setInv108(inv108[i]);
				if (inv105[i] != null)
					model.setInv105(inv105[i]);
				if (inv050[i] != null)
					model.setInv050(inv050[i]);
				if (inv104[i] != null)
					model.setInv104(inv104[i]);
				if (inv051[i] != null)
					model.setInv051(inv051[i]);
				if (inv107[i] != null)
					model.setInv107(inv107[i]);
				if (inv106[i] != null)
					model.setInv106(inv106[i]);
				if (inv101[i] != null)
					model.setInv101(inv101[i]);
				if (inv054[i] != null)
					model.setInv054(inv054[i]);
				if (inv100[i] != null)
					model.setInv100(inv100[i]);
				if (inv055[i] != null)
					model.setInv055(inv055[i]);
				if (inv103[i] != null)
					model.setInv103(inv103[i]);
				if (inv052[i] != null)
					model.setInv052(inv052[i]);
				if (inv102[i] != null)
					model.setInv102(inv102[i]);
				if (inv053[i] != null)
					model.setInv053(inv053[i]);
				if (inv143[i] != null)
					model.setInv143(inv143[i]);
				if (inv144[i] != null)
					model.setInv144(inv144[i]);
				if (inv145[i] != null)
					model.setInv145(inv145[i]);
				if (inv146[i] != null)
					model.setInv146(inv146[i]);
				if (inv147[i] != null)
					model.setInv147(inv147[i]);
				if (inv148[i] != null)
					model.setInv148(inv148[i]);
				if (inv149[i] != null)
					model.setInv149(inv149[i]);
				if (inv150[i] != null)
					model.setInv150(inv150[i]);
				if (inv151[i] != null)
					model.setInv151(inv151[i]);
				if (chg001[i] != null)
					model.setChg001(chg001[i]);
				if (chg002[i] != null)
					model.setChg002(chg002[i]);
				if (chg003[i] != null)
					model.setChg003(chg003[i]);
				if (chg004[i] != null)
					model.setChg004(chg004[i]);
				if (chg005[i] != null)
					model.setChg005(chg005[i]);
				if (chg999[i] != null)
					model.setChg999(chg999[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCPRTInvoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CPRTInvoiceVO[]
	 */
	public CPRTInvoiceVO[] getCPRTInvoiceVOs(){
		CPRTInvoiceVO[] vos = (CPRTInvoiceVO[])models.toArray(new CPRTInvoiceVO[models.size()]);
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
		this.inv022 = this.inv022 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv021 = this.inv021 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv020 = this.inv020 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv121 = this.inv121 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv120 = this.inv120 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv113 = this.inv113 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv114 = this.inv114 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv111 = this.inv111 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv112 = this.inv112 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv117 = this.inv117 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv118 = this.inv118 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv115 = this.inv115 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv116 = this.inv116 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv018 = this.inv018 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv019 = this.inv019 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv119 = this.inv119 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv016 = this.inv016 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv017 = this.inv017 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv014 = this.inv014 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv015 = this.inv015 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv012 = this.inv012 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv013 = this.inv013 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv031 = this.inv031 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv030 = this.inv030 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv033 = this.inv033 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv032 = this.inv032 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv130 = this.inv130 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv132 = this.inv132 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv131 = this.inv131 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv122 = this.inv122 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv123 = this.inv123 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv124 = this.inv124 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv125 = this.inv125 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv126 = this.inv126 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv127 = this.inv127 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv128 = this.inv128 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv129 = this.inv129 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv027 = this.inv027 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv028 = this.inv028 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv029 = this.inv029 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv023 = this.inv023 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv024 = this.inv024 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv025 = this.inv025 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv026 = this.inv026 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv078 = this.inv078 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv142 = this.inv142 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv079 = this.inv079 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv141 = this.inv141 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv140 = this.inv140 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv139 = this.inv139 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv082 = this.inv082 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv081 = this.inv081 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv137 = this.inv137 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv084 = this.inv084 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv138 = this.inv138 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv083 = this.inv083 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv135 = this.inv135 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv086 = this.inv086 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv136 = this.inv136 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv085 = this.inv085 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv133 = this.inv133 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv088 = this.inv088 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv134 = this.inv134 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv087 = this.inv087 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv080 = this.inv080 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv011 = this.inv011 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv010 = this.inv010 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv089 = this.inv089 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv095 = this.inv095 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv009 = this.inv009 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv094 = this.inv094 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv093 = this.inv093 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv092 = this.inv092 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv099 = this.inv099 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv098 = this.inv098 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv097 = this.inv097 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv096 = this.inv096 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv001 = this.inv001 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv002 = this.inv002 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv003 = this.inv003 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv004 = this.inv004 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv005 = this.inv005 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv091 = this.inv091 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv006 = this.inv006 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv090 = this.inv090 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv007 = this.inv007 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv008 = this.inv008 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv057 = this.inv057 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv056 = this.inv056 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv059 = this.inv059 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv058 = this.inv058 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv063 = this.inv063 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv064 = this.inv064 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv065 = this.inv065 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv066 = this.inv066 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv060 = this.inv060 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv061 = this.inv061 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv062 = this.inv062 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv069 = this.inv069 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv068 = this.inv068 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv067 = this.inv067 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv076 = this.inv076 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv077 = this.inv077 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv074 = this.inv074 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv075 = this.inv075 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv072 = this.inv072 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv073 = this.inv073 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv070 = this.inv070 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv071 = this.inv071 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv035 = this.inv035 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv034 = this.inv034 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv037 = this.inv037 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv036 = this.inv036 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv039 = this.inv039 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv038 = this.inv038 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv040 = this.inv040 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv041 = this.inv041 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv042 = this.inv042 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv043 = this.inv043 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv044 = this.inv044 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv048 = this.inv048 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv047 = this.inv047 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv046 = this.inv046 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv110 = this.inv110 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv045 = this.inv045 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv049 = this.inv049 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptTmpltNm = this.rptTmpltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv109 = this.inv109 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv108 = this.inv108 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv105 = this.inv105 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv050 = this.inv050 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv104 = this.inv104 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv051 = this.inv051 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv107 = this.inv107 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv106 = this.inv106 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv101 = this.inv101 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv054 = this.inv054 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv100 = this.inv100 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv055 = this.inv055 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv103 = this.inv103 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv052 = this.inv052 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv102 = this.inv102 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv053 = this.inv053 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv143 = this.inv143 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv144 = this.inv144 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv145 = this.inv145 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv146 = this.inv146 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv147 = this.inv147 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv148 = this.inv148 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv149 = this.inv149 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv150 = this.inv150 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inv151 = this.inv151 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chg001 = this.chg001 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chg002 = this.chg002 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chg003 = this.chg003 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chg004 = this.chg004 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chg005 = this.chg005 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chg999 = this.chg999 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
