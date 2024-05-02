/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListBlCustInfoVO.java
*@FileTitle : JapanManifestListBlCustInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.01  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo;

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

public class JapanManifestListBlCustInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapanManifestListBlCustInfoVO> models = new ArrayList<JapanManifestListBlCustInfoVO>();
	
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
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String data10 = null;
	/* Column Info */
	private String data16 = null;
	/* Column Info */
	private String data15 = null;
	/* Column Info */
	private String data14 = null;
	/* Column Info */
	private String data13 = null;
	/* Column Info */
	private String custCntCd3 = null;
	/* Column Info */
	private String custCntCd1 = null;
	/* Column Info */
	private String custNm1 = null;
	/* Column Info */
	private String custCntCd2 = null;
	/* Column Info */
	private String custAddr1 = null;
	/* Column Info */
	private String custAddr3 = null;
	/* Column Info */
	private String custAddr2 = null;
	/* Column Info */
	private String data1 = null;
	/* Column Info */
	private String data28 = null;
	/* Column Info */
	private String data4 = null;
	/* Column Info */
	private String data5 = null;
	/* Column Info */
	private String data2 = null;
	/* Column Info */
	private String data3 = null;
	/* Column Info */
	private String data8 = null;
	/* Column Info */
	private String data9 = null;
	/* Column Info */
	private String data6 = null;
	/* Column Info */
	private String data7 = null;
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
	private String phnNo3 = null;
	/* Column Info */
	private String phnNo1 = null;
	/* Column Info */
	private String custNm3 = null;
	/* Column Info */
	private String custNm2 = null;
	/* Column Info */
	private String phnNo2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapanManifestListBlCustInfoVO() {}

	public JapanManifestListBlCustInfoVO(String ibflag, String pagerows, String data1, String custNm1, String custAddr1, String data2, String data3, String data4, String data5, String data6, String custCntCd1, String phnNo1, String data7, String custNm2, String custAddr2, String data8, String data9, String data10, String data11, String data12, String custCntCd2, String phnNo2, String data13, String custNm3, String custAddr3, String data14, String data15, String data16, String data17, String data18, String custCntCd3, String phnNo3, String data19, String data20, String data21, String data22, String data23, String data24, String data25, String data26, String data27, String data28) {
		this.data19 = data19;
		this.data17 = data17;
		this.data18 = data18;
		this.pagerows = pagerows;
		this.data12 = data12;
		this.data11 = data11;
		this.ibflag = ibflag;
		this.data10 = data10;
		this.data16 = data16;
		this.data15 = data15;
		this.data14 = data14;
		this.data13 = data13;
		this.custCntCd3 = custCntCd3;
		this.custCntCd1 = custCntCd1;
		this.custNm1 = custNm1;
		this.custCntCd2 = custCntCd2;
		this.custAddr1 = custAddr1;
		this.custAddr3 = custAddr3;
		this.custAddr2 = custAddr2;
		this.data1 = data1;
		this.data28 = data28;
		this.data4 = data4;
		this.data5 = data5;
		this.data2 = data2;
		this.data3 = data3;
		this.data8 = data8;
		this.data9 = data9;
		this.data6 = data6;
		this.data7 = data7;
		this.data21 = data21;
		this.data20 = data20;
		this.data23 = data23;
		this.data22 = data22;
		this.data25 = data25;
		this.data24 = data24;
		this.data27 = data27;
		this.data26 = data26;
		this.phnNo3 = phnNo3;
		this.phnNo1 = phnNo1;
		this.custNm3 = custNm3;
		this.custNm2 = custNm2;
		this.phnNo2 = phnNo2;
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
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("data10", getData10());
		this.hashColumns.put("data16", getData16());
		this.hashColumns.put("data15", getData15());
		this.hashColumns.put("data14", getData14());
		this.hashColumns.put("data13", getData13());
		this.hashColumns.put("cust_cnt_cd3", getCustCntCd3());
		this.hashColumns.put("cust_cnt_cd1", getCustCntCd1());
		this.hashColumns.put("cust_nm1", getCustNm1());
		this.hashColumns.put("cust_cnt_cd2", getCustCntCd2());
		this.hashColumns.put("cust_addr1", getCustAddr1());
		this.hashColumns.put("cust_addr3", getCustAddr3());
		this.hashColumns.put("cust_addr2", getCustAddr2());
		this.hashColumns.put("data1", getData1());
		this.hashColumns.put("data28", getData28());
		this.hashColumns.put("data4", getData4());
		this.hashColumns.put("data5", getData5());
		this.hashColumns.put("data2", getData2());
		this.hashColumns.put("data3", getData3());
		this.hashColumns.put("data8", getData8());
		this.hashColumns.put("data9", getData9());
		this.hashColumns.put("data6", getData6());
		this.hashColumns.put("data7", getData7());
		this.hashColumns.put("data21", getData21());
		this.hashColumns.put("data20", getData20());
		this.hashColumns.put("data23", getData23());
		this.hashColumns.put("data22", getData22());
		this.hashColumns.put("data25", getData25());
		this.hashColumns.put("data24", getData24());
		this.hashColumns.put("data27", getData27());
		this.hashColumns.put("data26", getData26());
		this.hashColumns.put("phn_no3", getPhnNo3());
		this.hashColumns.put("phn_no1", getPhnNo1());
		this.hashColumns.put("cust_nm3", getCustNm3());
		this.hashColumns.put("cust_nm2", getCustNm2());
		this.hashColumns.put("phn_no2", getPhnNo2());
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
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("data10", "data10");
		this.hashFields.put("data16", "data16");
		this.hashFields.put("data15", "data15");
		this.hashFields.put("data14", "data14");
		this.hashFields.put("data13", "data13");
		this.hashFields.put("cust_cnt_cd3", "custCntCd3");
		this.hashFields.put("cust_cnt_cd1", "custCntCd1");
		this.hashFields.put("cust_nm1", "custNm1");
		this.hashFields.put("cust_cnt_cd2", "custCntCd2");
		this.hashFields.put("cust_addr1", "custAddr1");
		this.hashFields.put("cust_addr3", "custAddr3");
		this.hashFields.put("cust_addr2", "custAddr2");
		this.hashFields.put("data1", "data1");
		this.hashFields.put("data28", "data28");
		this.hashFields.put("data4", "data4");
		this.hashFields.put("data5", "data5");
		this.hashFields.put("data2", "data2");
		this.hashFields.put("data3", "data3");
		this.hashFields.put("data8", "data8");
		this.hashFields.put("data9", "data9");
		this.hashFields.put("data6", "data6");
		this.hashFields.put("data7", "data7");
		this.hashFields.put("data21", "data21");
		this.hashFields.put("data20", "data20");
		this.hashFields.put("data23", "data23");
		this.hashFields.put("data22", "data22");
		this.hashFields.put("data25", "data25");
		this.hashFields.put("data24", "data24");
		this.hashFields.put("data27", "data27");
		this.hashFields.put("data26", "data26");
		this.hashFields.put("phn_no3", "phnNo3");
		this.hashFields.put("phn_no1", "phnNo1");
		this.hashFields.put("cust_nm3", "custNm3");
		this.hashFields.put("cust_nm2", "custNm2");
		this.hashFields.put("phn_no2", "phnNo2");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return data13
	 */
	public String getData13() {
		return this.data13;
	}
	
	/**
	 * Column Info
	 * @return custCntCd3
	 */
	public String getCustCntCd3() {
		return this.custCntCd3;
	}
	
	/**
	 * Column Info
	 * @return custCntCd1
	 */
	public String getCustCntCd1() {
		return this.custCntCd1;
	}
	
	/**
	 * Column Info
	 * @return custNm1
	 */
	public String getCustNm1() {
		return this.custNm1;
	}
	
	/**
	 * Column Info
	 * @return custCntCd2
	 */
	public String getCustCntCd2() {
		return this.custCntCd2;
	}
	
	/**
	 * Column Info
	 * @return custAddr1
	 */
	public String getCustAddr1() {
		return this.custAddr1;
	}
	
	/**
	 * Column Info
	 * @return custAddr3
	 */
	public String getCustAddr3() {
		return this.custAddr3;
	}
	
	/**
	 * Column Info
	 * @return custAddr2
	 */
	public String getCustAddr2() {
		return this.custAddr2;
	}
	
	/**
	 * Column Info
	 * @return data1
	 */
	public String getData1() {
		return this.data1;
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
	 * @return data4
	 */
	public String getData4() {
		return this.data4;
	}
	
	/**
	 * Column Info
	 * @return data5
	 */
	public String getData5() {
		return this.data5;
	}
	
	/**
	 * Column Info
	 * @return data2
	 */
	public String getData2() {
		return this.data2;
	}
	
	/**
	 * Column Info
	 * @return data3
	 */
	public String getData3() {
		return this.data3;
	}
	
	/**
	 * Column Info
	 * @return data8
	 */
	public String getData8() {
		return this.data8;
	}
	
	/**
	 * Column Info
	 * @return data9
	 */
	public String getData9() {
		return this.data9;
	}
	
	/**
	 * Column Info
	 * @return data6
	 */
	public String getData6() {
		return this.data6;
	}
	
	/**
	 * Column Info
	 * @return data7
	 */
	public String getData7() {
		return this.data7;
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
	 * @return phnNo3
	 */
	public String getPhnNo3() {
		return this.phnNo3;
	}
	
	/**
	 * Column Info
	 * @return phnNo1
	 */
	public String getPhnNo1() {
		return this.phnNo1;
	}
	
	/**
	 * Column Info
	 * @return custNm3
	 */
	public String getCustNm3() {
		return this.custNm3;
	}
	
	/**
	 * Column Info
	 * @return custNm2
	 */
	public String getCustNm2() {
		return this.custNm2;
	}
	
	/**
	 * Column Info
	 * @return phnNo2
	 */
	public String getPhnNo2() {
		return this.phnNo2;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param data13
	 */
	public void setData13(String data13) {
		this.data13 = data13;
	}
	
	/**
	 * Column Info
	 * @param custCntCd3
	 */
	public void setCustCntCd3(String custCntCd3) {
		this.custCntCd3 = custCntCd3;
	}
	
	/**
	 * Column Info
	 * @param custCntCd1
	 */
	public void setCustCntCd1(String custCntCd1) {
		this.custCntCd1 = custCntCd1;
	}
	
	/**
	 * Column Info
	 * @param custNm1
	 */
	public void setCustNm1(String custNm1) {
		this.custNm1 = custNm1;
	}
	
	/**
	 * Column Info
	 * @param custCntCd2
	 */
	public void setCustCntCd2(String custCntCd2) {
		this.custCntCd2 = custCntCd2;
	}
	
	/**
	 * Column Info
	 * @param custAddr1
	 */
	public void setCustAddr1(String custAddr1) {
		this.custAddr1 = custAddr1;
	}
	
	/**
	 * Column Info
	 * @param custAddr3
	 */
	public void setCustAddr3(String custAddr3) {
		this.custAddr3 = custAddr3;
	}
	
	/**
	 * Column Info
	 * @param custAddr2
	 */
	public void setCustAddr2(String custAddr2) {
		this.custAddr2 = custAddr2;
	}
	
	/**
	 * Column Info
	 * @param data1
	 */
	public void setData1(String data1) {
		this.data1 = data1;
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
	 * @param data4
	 */
	public void setData4(String data4) {
		this.data4 = data4;
	}
	
	/**
	 * Column Info
	 * @param data5
	 */
	public void setData5(String data5) {
		this.data5 = data5;
	}
	
	/**
	 * Column Info
	 * @param data2
	 */
	public void setData2(String data2) {
		this.data2 = data2;
	}
	
	/**
	 * Column Info
	 * @param data3
	 */
	public void setData3(String data3) {
		this.data3 = data3;
	}
	
	/**
	 * Column Info
	 * @param data8
	 */
	public void setData8(String data8) {
		this.data8 = data8;
	}
	
	/**
	 * Column Info
	 * @param data9
	 */
	public void setData9(String data9) {
		this.data9 = data9;
	}
	
	/**
	 * Column Info
	 * @param data6
	 */
	public void setData6(String data6) {
		this.data6 = data6;
	}
	
	/**
	 * Column Info
	 * @param data7
	 */
	public void setData7(String data7) {
		this.data7 = data7;
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
	 * @param phnNo3
	 */
	public void setPhnNo3(String phnNo3) {
		this.phnNo3 = phnNo3;
	}
	
	/**
	 * Column Info
	 * @param phnNo1
	 */
	public void setPhnNo1(String phnNo1) {
		this.phnNo1 = phnNo1;
	}
	
	/**
	 * Column Info
	 * @param custNm3
	 */
	public void setCustNm3(String custNm3) {
		this.custNm3 = custNm3;
	}
	
	/**
	 * Column Info
	 * @param custNm2
	 */
	public void setCustNm2(String custNm2) {
		this.custNm2 = custNm2;
	}
	
	/**
	 * Column Info
	 * @param phnNo2
	 */
	public void setPhnNo2(String phnNo2) {
		this.phnNo2 = phnNo2;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setData19(JSPUtil.getParameter(request, "data19", ""));
		setData17(JSPUtil.getParameter(request, "data17", ""));
		setData18(JSPUtil.getParameter(request, "data18", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setData12(JSPUtil.getParameter(request, "data12", ""));
		setData11(JSPUtil.getParameter(request, "data11", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setData10(JSPUtil.getParameter(request, "data10", ""));
		setData16(JSPUtil.getParameter(request, "data16", ""));
		setData15(JSPUtil.getParameter(request, "data15", ""));
		setData14(JSPUtil.getParameter(request, "data14", ""));
		setData13(JSPUtil.getParameter(request, "data13", ""));
		setCustCntCd3(JSPUtil.getParameter(request, "cust_cnt_cd3", ""));
		setCustCntCd1(JSPUtil.getParameter(request, "cust_cnt_cd1", ""));
		setCustNm1(JSPUtil.getParameter(request, "cust_nm1", ""));
		setCustCntCd2(JSPUtil.getParameter(request, "cust_cnt_cd2", ""));
		setCustAddr1(JSPUtil.getParameter(request, "cust_addr1", ""));
		setCustAddr3(JSPUtil.getParameter(request, "cust_addr3", ""));
		setCustAddr2(JSPUtil.getParameter(request, "cust_addr2", ""));
		setData1(JSPUtil.getParameter(request, "data1", ""));
		setData28(JSPUtil.getParameter(request, "data28", ""));
		setData4(JSPUtil.getParameter(request, "data4", ""));
		setData5(JSPUtil.getParameter(request, "data5", ""));
		setData2(JSPUtil.getParameter(request, "data2", ""));
		setData3(JSPUtil.getParameter(request, "data3", ""));
		setData8(JSPUtil.getParameter(request, "data8", ""));
		setData9(JSPUtil.getParameter(request, "data9", ""));
		setData6(JSPUtil.getParameter(request, "data6", ""));
		setData7(JSPUtil.getParameter(request, "data7", ""));
		setData21(JSPUtil.getParameter(request, "data21", ""));
		setData20(JSPUtil.getParameter(request, "data20", ""));
		setData23(JSPUtil.getParameter(request, "data23", ""));
		setData22(JSPUtil.getParameter(request, "data22", ""));
		setData25(JSPUtil.getParameter(request, "data25", ""));
		setData24(JSPUtil.getParameter(request, "data24", ""));
		setData27(JSPUtil.getParameter(request, "data27", ""));
		setData26(JSPUtil.getParameter(request, "data26", ""));
		setPhnNo3(JSPUtil.getParameter(request, "phn_no3", ""));
		setPhnNo1(JSPUtil.getParameter(request, "phn_no1", ""));
		setCustNm3(JSPUtil.getParameter(request, "cust_nm3", ""));
		setCustNm2(JSPUtil.getParameter(request, "cust_nm2", ""));
		setPhnNo2(JSPUtil.getParameter(request, "phn_no2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListBlCustInfoVO[]
	 */
	public JapanManifestListBlCustInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListBlCustInfoVO[]
	 */
	public JapanManifestListBlCustInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListBlCustInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] data19 = (JSPUtil.getParameter(request, prefix	+ "data19".trim(), length));
			String[] data17 = (JSPUtil.getParameter(request, prefix	+ "data17".trim(), length));
			String[] data18 = (JSPUtil.getParameter(request, prefix	+ "data18".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] data12 = (JSPUtil.getParameter(request, prefix	+ "data12".trim(), length));
			String[] data11 = (JSPUtil.getParameter(request, prefix	+ "data11".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] data10 = (JSPUtil.getParameter(request, prefix	+ "data10".trim(), length));
			String[] data16 = (JSPUtil.getParameter(request, prefix	+ "data16".trim(), length));
			String[] data15 = (JSPUtil.getParameter(request, prefix	+ "data15".trim(), length));
			String[] data14 = (JSPUtil.getParameter(request, prefix	+ "data14".trim(), length));
			String[] data13 = (JSPUtil.getParameter(request, prefix	+ "data13".trim(), length));
			String[] custCntCd3 = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd3".trim(), length));
			String[] custCntCd1 = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd1".trim(), length));
			String[] custNm1 = (JSPUtil.getParameter(request, prefix	+ "cust_nm1".trim(), length));
			String[] custCntCd2 = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd2".trim(), length));
			String[] custAddr1 = (JSPUtil.getParameter(request, prefix	+ "cust_addr1".trim(), length));
			String[] custAddr3 = (JSPUtil.getParameter(request, prefix	+ "cust_addr3".trim(), length));
			String[] custAddr2 = (JSPUtil.getParameter(request, prefix	+ "cust_addr2".trim(), length));
			String[] data1 = (JSPUtil.getParameter(request, prefix	+ "data1".trim(), length));
			String[] data28 = (JSPUtil.getParameter(request, prefix	+ "data28".trim(), length));
			String[] data4 = (JSPUtil.getParameter(request, prefix	+ "data4".trim(), length));
			String[] data5 = (JSPUtil.getParameter(request, prefix	+ "data5".trim(), length));
			String[] data2 = (JSPUtil.getParameter(request, prefix	+ "data2".trim(), length));
			String[] data3 = (JSPUtil.getParameter(request, prefix	+ "data3".trim(), length));
			String[] data8 = (JSPUtil.getParameter(request, prefix	+ "data8".trim(), length));
			String[] data9 = (JSPUtil.getParameter(request, prefix	+ "data9".trim(), length));
			String[] data6 = (JSPUtil.getParameter(request, prefix	+ "data6".trim(), length));
			String[] data7 = (JSPUtil.getParameter(request, prefix	+ "data7".trim(), length));
			String[] data21 = (JSPUtil.getParameter(request, prefix	+ "data21".trim(), length));
			String[] data20 = (JSPUtil.getParameter(request, prefix	+ "data20".trim(), length));
			String[] data23 = (JSPUtil.getParameter(request, prefix	+ "data23".trim(), length));
			String[] data22 = (JSPUtil.getParameter(request, prefix	+ "data22".trim(), length));
			String[] data25 = (JSPUtil.getParameter(request, prefix	+ "data25".trim(), length));
			String[] data24 = (JSPUtil.getParameter(request, prefix	+ "data24".trim(), length));
			String[] data27 = (JSPUtil.getParameter(request, prefix	+ "data27".trim(), length));
			String[] data26 = (JSPUtil.getParameter(request, prefix	+ "data26".trim(), length));
			String[] phnNo3 = (JSPUtil.getParameter(request, prefix	+ "phn_no3".trim(), length));
			String[] phnNo1 = (JSPUtil.getParameter(request, prefix	+ "phn_no1".trim(), length));
			String[] custNm3 = (JSPUtil.getParameter(request, prefix	+ "cust_nm3".trim(), length));
			String[] custNm2 = (JSPUtil.getParameter(request, prefix	+ "cust_nm2".trim(), length));
			String[] phnNo2 = (JSPUtil.getParameter(request, prefix	+ "phn_no2".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new JapanManifestListBlCustInfoVO();
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
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (data10[i] != null)
					model.setData10(data10[i]);
				if (data16[i] != null)
					model.setData16(data16[i]);
				if (data15[i] != null)
					model.setData15(data15[i]);
				if (data14[i] != null)
					model.setData14(data14[i]);
				if (data13[i] != null)
					model.setData13(data13[i]);
				if (custCntCd3[i] != null)
					model.setCustCntCd3(custCntCd3[i]);
				if (custCntCd1[i] != null)
					model.setCustCntCd1(custCntCd1[i]);
				if (custNm1[i] != null)
					model.setCustNm1(custNm1[i]);
				if (custCntCd2[i] != null)
					model.setCustCntCd2(custCntCd2[i]);
				if (custAddr1[i] != null)
					model.setCustAddr1(custAddr1[i]);
				if (custAddr3[i] != null)
					model.setCustAddr3(custAddr3[i]);
				if (custAddr2[i] != null)
					model.setCustAddr2(custAddr2[i]);
				if (data1[i] != null)
					model.setData1(data1[i]);
				if (data28[i] != null)
					model.setData28(data28[i]);
				if (data4[i] != null)
					model.setData4(data4[i]);
				if (data5[i] != null)
					model.setData5(data5[i]);
				if (data2[i] != null)
					model.setData2(data2[i]);
				if (data3[i] != null)
					model.setData3(data3[i]);
				if (data8[i] != null)
					model.setData8(data8[i]);
				if (data9[i] != null)
					model.setData9(data9[i]);
				if (data6[i] != null)
					model.setData6(data6[i]);
				if (data7[i] != null)
					model.setData7(data7[i]);
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
				if (phnNo3[i] != null)
					model.setPhnNo3(phnNo3[i]);
				if (phnNo1[i] != null)
					model.setPhnNo1(phnNo1[i]);
				if (custNm3[i] != null)
					model.setCustNm3(custNm3[i]);
				if (custNm2[i] != null)
					model.setCustNm2(custNm2[i]);
				if (phnNo2[i] != null)
					model.setPhnNo2(phnNo2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListBlCustInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListBlCustInfoVO[]
	 */
	public JapanManifestListBlCustInfoVO[] getJapanManifestListBlCustInfoVOs(){
		JapanManifestListBlCustInfoVO[] vos = (JapanManifestListBlCustInfoVO[])models.toArray(new JapanManifestListBlCustInfoVO[models.size()]);
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
		this.data19 = this.data19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data17 = this.data17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data18 = this.data18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data12 = this.data12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data11 = this.data11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data10 = this.data10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data16 = this.data16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data15 = this.data15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data14 = this.data14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data13 = this.data13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd3 = this.custCntCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd1 = this.custCntCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm1 = this.custNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd2 = this.custCntCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr1 = this.custAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr3 = this.custAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr2 = this.custAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data1 = this.data1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data28 = this.data28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data4 = this.data4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data5 = this.data5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data2 = this.data2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data3 = this.data3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data8 = this.data8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data9 = this.data9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data6 = this.data6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data7 = this.data7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data21 = this.data21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data20 = this.data20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data23 = this.data23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data22 = this.data22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data25 = this.data25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data24 = this.data24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data27 = this.data27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data26 = this.data26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo3 = this.phnNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo1 = this.phnNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm3 = this.custNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm2 = this.custNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo2 = this.phnNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
