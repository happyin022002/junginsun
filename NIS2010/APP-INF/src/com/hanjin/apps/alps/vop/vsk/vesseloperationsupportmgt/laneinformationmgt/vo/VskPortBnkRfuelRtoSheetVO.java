/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VskPortBnkRfuelRtoVO.java
*@FileTitle : VskPortBnkRfuelRtoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.23 장석현 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo;

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
 * @author 장석현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VskPortBnkRfuelRtoSheetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VskPortBnkRfuelRtoSheetVO> models = new ArrayList<VskPortBnkRfuelRtoSheetVO>();
	
	/* Column Info */
	private String rfuelRto07 = null;
	/* Column Info */
	private String rfuelRto08 = null;
	/* Column Info */
	private String rfuelRto09 = null;
	/* Column Info */
	private String rfuelRto03 = null;
	/* Column Info */
	private String rfuelRto04 = null;
	/* Column Info */
	private String rfuelRto05 = null;
	/* Column Info */
	private String rfuelRto06 = null;
	/* Column Info */
	private String rfuelRto01 = null;
	/* Column Info */
	private String rfuelRto02 = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfuelRto20 = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vslSlanNm = null;
	/* Column Info */
	private String rfuelRto24 = null;
	/* Column Info */
	private String rfuelRto23 = null;
	/* Column Info */
	private String rfuelRto22 = null;
	/* Column Info */
	private String rfuelRto21 = null;
	/* Column Info */
	private String rfuelRto28 = null;
	/* Column Info */
	private String rfuelRto27 = null;
	/* Column Info */
	private String rfuelRto26 = null;
	/* Column Info */
	private String rfuelRto25 = null;
	/* Column Info */
	private String rfuelRto29 = null;
	/* Column Info */
	private String rfuelRtoTot = null;
	/* Column Info */
	private String rfuelRto11 = null;
	/* Column Info */
	private String rfuelRto10 = null;
	/* Column Info */
	private String rfuelRto13 = null;
	/* Column Info */
	private String rfuelRto30 = null;
	/* Column Info */
	private String rfuelRto12 = null;
	/* Column Info */
	private String rfuelRto15 = null;
	/* Column Info */
	private String rfuelRto14 = null;
	/* Column Info */
	private String rfuelRto17 = null;
	/* Column Info */
	private String rfuelRto16 = null;
	/* Column Info */
	private String rfuelRto19 = null;
	/* Column Info */
	private String rfuelRto18 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VskPortBnkRfuelRtoSheetVO() {}

	public VskPortBnkRfuelRtoSheetVO(String ibflag, String pagerows, String vslSlanNm, String vslSlanCd, String rfuelRto01, String rfuelRto02, String rfuelRto03, String rfuelRto04, String rfuelRto05, String rfuelRto06, String rfuelRto07, String rfuelRto08, String rfuelRto09, String rfuelRto10, String rfuelRto11, String rfuelRto12, String rfuelRto13, String rfuelRto14, String rfuelRto15, String rfuelRto16, String rfuelRto17, String rfuelRto18, String rfuelRto19, String rfuelRto20, String rfuelRto21, String rfuelRto22, String rfuelRto23, String rfuelRto24, String rfuelRto25, String rfuelRto26, String rfuelRto27, String rfuelRto28, String rfuelRto29, String rfuelRto30, String rfuelRtoTot) {
		this.rfuelRto07 = rfuelRto07;
		this.rfuelRto08 = rfuelRto08;
		this.rfuelRto09 = rfuelRto09;
		this.rfuelRto03 = rfuelRto03;
		this.rfuelRto04 = rfuelRto04;
		this.rfuelRto05 = rfuelRto05;
		this.rfuelRto06 = rfuelRto06;
		this.rfuelRto01 = rfuelRto01;
		this.rfuelRto02 = rfuelRto02;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
		this.rfuelRto20 = rfuelRto20;
		this.ibflag = ibflag;
		this.vslSlanNm = vslSlanNm;
		this.rfuelRto24 = rfuelRto24;
		this.rfuelRto23 = rfuelRto23;
		this.rfuelRto22 = rfuelRto22;
		this.rfuelRto21 = rfuelRto21;
		this.rfuelRto28 = rfuelRto28;
		this.rfuelRto27 = rfuelRto27;
		this.rfuelRto26 = rfuelRto26;
		this.rfuelRto25 = rfuelRto25;
		this.rfuelRto29 = rfuelRto29;
		this.rfuelRtoTot = rfuelRtoTot;
		this.rfuelRto11 = rfuelRto11;
		this.rfuelRto10 = rfuelRto10;
		this.rfuelRto13 = rfuelRto13;
		this.rfuelRto30 = rfuelRto30;
		this.rfuelRto12 = rfuelRto12;
		this.rfuelRto15 = rfuelRto15;
		this.rfuelRto14 = rfuelRto14;
		this.rfuelRto17 = rfuelRto17;
		this.rfuelRto16 = rfuelRto16;
		this.rfuelRto19 = rfuelRto19;
		this.rfuelRto18 = rfuelRto18;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rfuel_rto_07", getRfuelRto07());
		this.hashColumns.put("rfuel_rto_08", getRfuelRto08());
		this.hashColumns.put("rfuel_rto_09", getRfuelRto09());
		this.hashColumns.put("rfuel_rto_03", getRfuelRto03());
		this.hashColumns.put("rfuel_rto_04", getRfuelRto04());
		this.hashColumns.put("rfuel_rto_05", getRfuelRto05());
		this.hashColumns.put("rfuel_rto_06", getRfuelRto06());
		this.hashColumns.put("rfuel_rto_01", getRfuelRto01());
		this.hashColumns.put("rfuel_rto_02", getRfuelRto02());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfuel_rto_20", getRfuelRto20());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
		this.hashColumns.put("rfuel_rto_24", getRfuelRto24());
		this.hashColumns.put("rfuel_rto_23", getRfuelRto23());
		this.hashColumns.put("rfuel_rto_22", getRfuelRto22());
		this.hashColumns.put("rfuel_rto_21", getRfuelRto21());
		this.hashColumns.put("rfuel_rto_28", getRfuelRto28());
		this.hashColumns.put("rfuel_rto_27", getRfuelRto27());
		this.hashColumns.put("rfuel_rto_26", getRfuelRto26());
		this.hashColumns.put("rfuel_rto_25", getRfuelRto25());
		this.hashColumns.put("rfuel_rto_29", getRfuelRto29());
		this.hashColumns.put("rfuel_rto_tot", getRfuelRtoTot());
		this.hashColumns.put("rfuel_rto_11", getRfuelRto11());
		this.hashColumns.put("rfuel_rto_10", getRfuelRto10());
		this.hashColumns.put("rfuel_rto_13", getRfuelRto13());
		this.hashColumns.put("rfuel_rto_30", getRfuelRto30());
		this.hashColumns.put("rfuel_rto_12", getRfuelRto12());
		this.hashColumns.put("rfuel_rto_15", getRfuelRto15());
		this.hashColumns.put("rfuel_rto_14", getRfuelRto14());
		this.hashColumns.put("rfuel_rto_17", getRfuelRto17());
		this.hashColumns.put("rfuel_rto_16", getRfuelRto16());
		this.hashColumns.put("rfuel_rto_19", getRfuelRto19());
		this.hashColumns.put("rfuel_rto_18", getRfuelRto18());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rfuel_rto_07", "rfuelRto07");
		this.hashFields.put("rfuel_rto_08", "rfuelRto08");
		this.hashFields.put("rfuel_rto_09", "rfuelRto09");
		this.hashFields.put("rfuel_rto_03", "rfuelRto03");
		this.hashFields.put("rfuel_rto_04", "rfuelRto04");
		this.hashFields.put("rfuel_rto_05", "rfuelRto05");
		this.hashFields.put("rfuel_rto_06", "rfuelRto06");
		this.hashFields.put("rfuel_rto_01", "rfuelRto01");
		this.hashFields.put("rfuel_rto_02", "rfuelRto02");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfuel_rto_20", "rfuelRto20");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_slan_nm", "vslSlanNm");
		this.hashFields.put("rfuel_rto_24", "rfuelRto24");
		this.hashFields.put("rfuel_rto_23", "rfuelRto23");
		this.hashFields.put("rfuel_rto_22", "rfuelRto22");
		this.hashFields.put("rfuel_rto_21", "rfuelRto21");
		this.hashFields.put("rfuel_rto_28", "rfuelRto28");
		this.hashFields.put("rfuel_rto_27", "rfuelRto27");
		this.hashFields.put("rfuel_rto_26", "rfuelRto26");
		this.hashFields.put("rfuel_rto_25", "rfuelRto25");
		this.hashFields.put("rfuel_rto_29", "rfuelRto29");
		this.hashFields.put("rfuel_rto_tot", "rfuelRtoTot");
		this.hashFields.put("rfuel_rto_11", "rfuelRto11");
		this.hashFields.put("rfuel_rto_10", "rfuelRto10");
		this.hashFields.put("rfuel_rto_13", "rfuelRto13");
		this.hashFields.put("rfuel_rto_30", "rfuelRto30");
		this.hashFields.put("rfuel_rto_12", "rfuelRto12");
		this.hashFields.put("rfuel_rto_15", "rfuelRto15");
		this.hashFields.put("rfuel_rto_14", "rfuelRto14");
		this.hashFields.put("rfuel_rto_17", "rfuelRto17");
		this.hashFields.put("rfuel_rto_16", "rfuelRto16");
		this.hashFields.put("rfuel_rto_19", "rfuelRto19");
		this.hashFields.put("rfuel_rto_18", "rfuelRto18");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto07
	 */
	public String getRfuelRto07() {
		return this.rfuelRto07;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto08
	 */
	public String getRfuelRto08() {
		return this.rfuelRto08;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto09
	 */
	public String getRfuelRto09() {
		return this.rfuelRto09;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto03
	 */
	public String getRfuelRto03() {
		return this.rfuelRto03;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto04
	 */
	public String getRfuelRto04() {
		return this.rfuelRto04;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto05
	 */
	public String getRfuelRto05() {
		return this.rfuelRto05;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto06
	 */
	public String getRfuelRto06() {
		return this.rfuelRto06;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto01
	 */
	public String getRfuelRto01() {
		return this.rfuelRto01;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto02
	 */
	public String getRfuelRto02() {
		return this.rfuelRto02;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return rfuelRto20
	 */
	public String getRfuelRto20() {
		return this.rfuelRto20;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return vslSlanNm
	 */
	public String getVslSlanNm() {
		return this.vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto24
	 */
	public String getRfuelRto24() {
		return this.rfuelRto24;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto23
	 */
	public String getRfuelRto23() {
		return this.rfuelRto23;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto22
	 */
	public String getRfuelRto22() {
		return this.rfuelRto22;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto21
	 */
	public String getRfuelRto21() {
		return this.rfuelRto21;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto28
	 */
	public String getRfuelRto28() {
		return this.rfuelRto28;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto27
	 */
	public String getRfuelRto27() {
		return this.rfuelRto27;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto26
	 */
	public String getRfuelRto26() {
		return this.rfuelRto26;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto25
	 */
	public String getRfuelRto25() {
		return this.rfuelRto25;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto29
	 */
	public String getRfuelRto29() {
		return this.rfuelRto29;
	}
	
	/**
	 * Column Info
	 * @return rfuelRtoTot
	 */
	public String getRfuelRtoTot() {
		return this.rfuelRtoTot;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto11
	 */
	public String getRfuelRto11() {
		return this.rfuelRto11;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto10
	 */
	public String getRfuelRto10() {
		return this.rfuelRto10;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto13
	 */
	public String getRfuelRto13() {
		return this.rfuelRto13;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto30
	 */
	public String getRfuelRto30() {
		return this.rfuelRto30;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto12
	 */
	public String getRfuelRto12() {
		return this.rfuelRto12;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto15
	 */
	public String getRfuelRto15() {
		return this.rfuelRto15;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto14
	 */
	public String getRfuelRto14() {
		return this.rfuelRto14;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto17
	 */
	public String getRfuelRto17() {
		return this.rfuelRto17;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto16
	 */
	public String getRfuelRto16() {
		return this.rfuelRto16;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto19
	 */
	public String getRfuelRto19() {
		return this.rfuelRto19;
	}
	
	/**
	 * Column Info
	 * @return rfuelRto18
	 */
	public String getRfuelRto18() {
		return this.rfuelRto18;
	}
	

	/**
	 * Column Info
	 * @param rfuelRto07
	 */
	public void setRfuelRto07(String rfuelRto07) {
		this.rfuelRto07 = rfuelRto07;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto08
	 */
	public void setRfuelRto08(String rfuelRto08) {
		this.rfuelRto08 = rfuelRto08;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto09
	 */
	public void setRfuelRto09(String rfuelRto09) {
		this.rfuelRto09 = rfuelRto09;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto03
	 */
	public void setRfuelRto03(String rfuelRto03) {
		this.rfuelRto03 = rfuelRto03;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto04
	 */
	public void setRfuelRto04(String rfuelRto04) {
		this.rfuelRto04 = rfuelRto04;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto05
	 */
	public void setRfuelRto05(String rfuelRto05) {
		this.rfuelRto05 = rfuelRto05;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto06
	 */
	public void setRfuelRto06(String rfuelRto06) {
		this.rfuelRto06 = rfuelRto06;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto01
	 */
	public void setRfuelRto01(String rfuelRto01) {
		this.rfuelRto01 = rfuelRto01;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto02
	 */
	public void setRfuelRto02(String rfuelRto02) {
		this.rfuelRto02 = rfuelRto02;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param rfuelRto20
	 */
	public void setRfuelRto20(String rfuelRto20) {
		this.rfuelRto20 = rfuelRto20;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param vslSlanNm
	 */
	public void setVslSlanNm(String vslSlanNm) {
		this.vslSlanNm = vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto24
	 */
	public void setRfuelRto24(String rfuelRto24) {
		this.rfuelRto24 = rfuelRto24;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto23
	 */
	public void setRfuelRto23(String rfuelRto23) {
		this.rfuelRto23 = rfuelRto23;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto22
	 */
	public void setRfuelRto22(String rfuelRto22) {
		this.rfuelRto22 = rfuelRto22;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto21
	 */
	public void setRfuelRto21(String rfuelRto21) {
		this.rfuelRto21 = rfuelRto21;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto28
	 */
	public void setRfuelRto28(String rfuelRto28) {
		this.rfuelRto28 = rfuelRto28;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto27
	 */
	public void setRfuelRto27(String rfuelRto27) {
		this.rfuelRto27 = rfuelRto27;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto26
	 */
	public void setRfuelRto26(String rfuelRto26) {
		this.rfuelRto26 = rfuelRto26;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto25
	 */
	public void setRfuelRto25(String rfuelRto25) {
		this.rfuelRto25 = rfuelRto25;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto29
	 */
	public void setRfuelRto29(String rfuelRto29) {
		this.rfuelRto29 = rfuelRto29;
	}
	
	/**
	 * Column Info
	 * @param rfuelRtoTot
	 */
	public void setRfuelRtoTot(String rfuelRtoTot) {
		this.rfuelRtoTot = rfuelRtoTot;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto11
	 */
	public void setRfuelRto11(String rfuelRto11) {
		this.rfuelRto11 = rfuelRto11;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto10
	 */
	public void setRfuelRto10(String rfuelRto10) {
		this.rfuelRto10 = rfuelRto10;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto13
	 */
	public void setRfuelRto13(String rfuelRto13) {
		this.rfuelRto13 = rfuelRto13;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto30
	 */
	public void setRfuelRto30(String rfuelRto30) {
		this.rfuelRto30 = rfuelRto30;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto12
	 */
	public void setRfuelRto12(String rfuelRto12) {
		this.rfuelRto12 = rfuelRto12;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto15
	 */
	public void setRfuelRto15(String rfuelRto15) {
		this.rfuelRto15 = rfuelRto15;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto14
	 */
	public void setRfuelRto14(String rfuelRto14) {
		this.rfuelRto14 = rfuelRto14;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto17
	 */
	public void setRfuelRto17(String rfuelRto17) {
		this.rfuelRto17 = rfuelRto17;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto16
	 */
	public void setRfuelRto16(String rfuelRto16) {
		this.rfuelRto16 = rfuelRto16;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto19
	 */
	public void setRfuelRto19(String rfuelRto19) {
		this.rfuelRto19 = rfuelRto19;
	}
	
	/**
	 * Column Info
	 * @param rfuelRto18
	 */
	public void setRfuelRto18(String rfuelRto18) {
		this.rfuelRto18 = rfuelRto18;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRfuelRto07(JSPUtil.getParameter(request, "rfuel_rto_07", ""));
		setRfuelRto08(JSPUtil.getParameter(request, "rfuel_rto_08", ""));
		setRfuelRto09(JSPUtil.getParameter(request, "rfuel_rto_09", ""));
		setRfuelRto03(JSPUtil.getParameter(request, "rfuel_rto_03", ""));
		setRfuelRto04(JSPUtil.getParameter(request, "rfuel_rto_04", ""));
		setRfuelRto05(JSPUtil.getParameter(request, "rfuel_rto_05", ""));
		setRfuelRto06(JSPUtil.getParameter(request, "rfuel_rto_06", ""));
		setRfuelRto01(JSPUtil.getParameter(request, "rfuel_rto_01", ""));
		setRfuelRto02(JSPUtil.getParameter(request, "rfuel_rto_02", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRfuelRto20(JSPUtil.getParameter(request, "rfuel_rto_20", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslSlanNm(JSPUtil.getParameter(request, "vsl_slan_nm", ""));
		setRfuelRto24(JSPUtil.getParameter(request, "rfuel_rto_24", ""));
		setRfuelRto23(JSPUtil.getParameter(request, "rfuel_rto_23", ""));
		setRfuelRto22(JSPUtil.getParameter(request, "rfuel_rto_22", ""));
		setRfuelRto21(JSPUtil.getParameter(request, "rfuel_rto_21", ""));
		setRfuelRto28(JSPUtil.getParameter(request, "rfuel_rto_28", ""));
		setRfuelRto27(JSPUtil.getParameter(request, "rfuel_rto_27", ""));
		setRfuelRto26(JSPUtil.getParameter(request, "rfuel_rto_26", ""));
		setRfuelRto25(JSPUtil.getParameter(request, "rfuel_rto_25", ""));
		setRfuelRto29(JSPUtil.getParameter(request, "rfuel_rto_29", ""));
		setRfuelRtoTot(JSPUtil.getParameter(request, "rfuel_rto_tot", ""));
		setRfuelRto11(JSPUtil.getParameter(request, "rfuel_rto_11", ""));
		setRfuelRto10(JSPUtil.getParameter(request, "rfuel_rto_10", ""));
		setRfuelRto13(JSPUtil.getParameter(request, "rfuel_rto_13", ""));
		setRfuelRto30(JSPUtil.getParameter(request, "rfuel_rto_30", ""));
		setRfuelRto12(JSPUtil.getParameter(request, "rfuel_rto_12", ""));
		setRfuelRto15(JSPUtil.getParameter(request, "rfuel_rto_15", ""));
		setRfuelRto14(JSPUtil.getParameter(request, "rfuel_rto_14", ""));
		setRfuelRto17(JSPUtil.getParameter(request, "rfuel_rto_17", ""));
		setRfuelRto16(JSPUtil.getParameter(request, "rfuel_rto_16", ""));
		setRfuelRto19(JSPUtil.getParameter(request, "rfuel_rto_19", ""));
		setRfuelRto18(JSPUtil.getParameter(request, "rfuel_rto_18", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskPortBnkRfuelRtoVO[]
	 */
	public VskPortBnkRfuelRtoSheetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskPortBnkRfuelRtoVO[]
	 */
	public VskPortBnkRfuelRtoSheetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskPortBnkRfuelRtoSheetVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rfuelRto07 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_07", length));
			String[] rfuelRto08 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_08", length));
			String[] rfuelRto09 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_09", length));
			String[] rfuelRto03 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_03", length));
			String[] rfuelRto04 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_04", length));
			String[] rfuelRto05 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_05", length));
			String[] rfuelRto06 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_06", length));
			String[] rfuelRto01 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_01", length));
			String[] rfuelRto02 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_02", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfuelRto20 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_20", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslSlanNm = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm", length));
			String[] rfuelRto24 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_24", length));
			String[] rfuelRto23 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_23", length));
			String[] rfuelRto22 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_22", length));
			String[] rfuelRto21 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_21", length));
			String[] rfuelRto28 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_28", length));
			String[] rfuelRto27 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_27", length));
			String[] rfuelRto26 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_26", length));
			String[] rfuelRto25 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_25", length));
			String[] rfuelRto29 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_29", length));
			String[] rfuelRtoTot = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_tot", length));
			String[] rfuelRto11 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_11", length));
			String[] rfuelRto10 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_10", length));
			String[] rfuelRto13 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_13", length));
			String[] rfuelRto30 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_30", length));
			String[] rfuelRto12 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_12", length));
			String[] rfuelRto15 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_15", length));
			String[] rfuelRto14 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_14", length));
			String[] rfuelRto17 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_17", length));
			String[] rfuelRto16 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_16", length));
			String[] rfuelRto19 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_19", length));
			String[] rfuelRto18 = (JSPUtil.getParameter(request, prefix	+ "rfuel_rto_18", length));
			
			for (int i = 0; i < length; i++) {
				model = new VskPortBnkRfuelRtoSheetVO();
				if (rfuelRto07[i] != null)
					model.setRfuelRto07(rfuelRto07[i]);
				if (rfuelRto08[i] != null)
					model.setRfuelRto08(rfuelRto08[i]);
				if (rfuelRto09[i] != null)
					model.setRfuelRto09(rfuelRto09[i]);
				if (rfuelRto03[i] != null)
					model.setRfuelRto03(rfuelRto03[i]);
				if (rfuelRto04[i] != null)
					model.setRfuelRto04(rfuelRto04[i]);
				if (rfuelRto05[i] != null)
					model.setRfuelRto05(rfuelRto05[i]);
				if (rfuelRto06[i] != null)
					model.setRfuelRto06(rfuelRto06[i]);
				if (rfuelRto01[i] != null)
					model.setRfuelRto01(rfuelRto01[i]);
				if (rfuelRto02[i] != null)
					model.setRfuelRto02(rfuelRto02[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfuelRto20[i] != null)
					model.setRfuelRto20(rfuelRto20[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslSlanNm[i] != null)
					model.setVslSlanNm(vslSlanNm[i]);
				if (rfuelRto24[i] != null)
					model.setRfuelRto24(rfuelRto24[i]);
				if (rfuelRto23[i] != null)
					model.setRfuelRto23(rfuelRto23[i]);
				if (rfuelRto22[i] != null)
					model.setRfuelRto22(rfuelRto22[i]);
				if (rfuelRto21[i] != null)
					model.setRfuelRto21(rfuelRto21[i]);
				if (rfuelRto28[i] != null)
					model.setRfuelRto28(rfuelRto28[i]);
				if (rfuelRto27[i] != null)
					model.setRfuelRto27(rfuelRto27[i]);
				if (rfuelRto26[i] != null)
					model.setRfuelRto26(rfuelRto26[i]);
				if (rfuelRto25[i] != null)
					model.setRfuelRto25(rfuelRto25[i]);
				if (rfuelRto29[i] != null)
					model.setRfuelRto29(rfuelRto29[i]);
				if (rfuelRtoTot[i] != null)
					model.setRfuelRtoTot(rfuelRtoTot[i]);
				if (rfuelRto11[i] != null)
					model.setRfuelRto11(rfuelRto11[i]);
				if (rfuelRto10[i] != null)
					model.setRfuelRto10(rfuelRto10[i]);
				if (rfuelRto13[i] != null)
					model.setRfuelRto13(rfuelRto13[i]);
				if (rfuelRto30[i] != null)
					model.setRfuelRto30(rfuelRto30[i]);
				if (rfuelRto12[i] != null)
					model.setRfuelRto12(rfuelRto12[i]);
				if (rfuelRto15[i] != null)
					model.setRfuelRto15(rfuelRto15[i]);
				if (rfuelRto14[i] != null)
					model.setRfuelRto14(rfuelRto14[i]);
				if (rfuelRto17[i] != null)
					model.setRfuelRto17(rfuelRto17[i]);
				if (rfuelRto16[i] != null)
					model.setRfuelRto16(rfuelRto16[i]);
				if (rfuelRto19[i] != null)
					model.setRfuelRto19(rfuelRto19[i]);
				if (rfuelRto18[i] != null)
					model.setRfuelRto18(rfuelRto18[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskPortBnkRfuelRtoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskPortBnkRfuelRtoVO[]
	 */
	public VskPortBnkRfuelRtoSheetVO[] getVskPortBnkRfuelRtoVOs(){
		VskPortBnkRfuelRtoSheetVO[] vos = (VskPortBnkRfuelRtoSheetVO[])models.toArray(new VskPortBnkRfuelRtoSheetVO[models.size()]);
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
		this.rfuelRto07 = this.rfuelRto07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto08 = this.rfuelRto08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto09 = this.rfuelRto09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto03 = this.rfuelRto03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto04 = this.rfuelRto04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto05 = this.rfuelRto05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto06 = this.rfuelRto06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto01 = this.rfuelRto01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto02 = this.rfuelRto02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto20 = this.rfuelRto20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm = this.vslSlanNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto24 = this.rfuelRto24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto23 = this.rfuelRto23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto22 = this.rfuelRto22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto21 = this.rfuelRto21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto28 = this.rfuelRto28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto27 = this.rfuelRto27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto26 = this.rfuelRto26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto25 = this.rfuelRto25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto29 = this.rfuelRto29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRtoTot = this.rfuelRtoTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto11 = this.rfuelRto11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto10 = this.rfuelRto10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto13 = this.rfuelRto13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto30 = this.rfuelRto30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto12 = this.rfuelRto12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto15 = this.rfuelRto15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto14 = this.rfuelRto14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto17 = this.rfuelRto17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto16 = this.rfuelRto16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto19 = this.rfuelRto19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfuelRto18 = this.rfuelRto18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
