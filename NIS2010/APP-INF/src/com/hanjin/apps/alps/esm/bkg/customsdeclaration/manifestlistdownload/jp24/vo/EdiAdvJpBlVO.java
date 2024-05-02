/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EdiAdvJpBlVO.java
*@FileTitle : EdiAdvJpBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.06
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.09.06 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EdiAdvJpBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EdiAdvJpBlVO> models = new ArrayList<EdiAdvJpBlVO>();
	
	/* Column Info */
	private String data19 = null;
	/* Column Info */
	private String data17 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String data12 = null;
	/* Column Info */
	private String data11 = null;
	/* Column Info */
	private String data10 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String data16 = null;
	/* Column Info */
	private String data15 = null;
	/* Column Info */
	private String data14 = null;
	/* Column Info */
	private String data13 = null;
	/* Column Info */
	private String data18c = null;
	/* Column Info */
	private String data18a = null;
	/* Column Info */
	private String data18b = null;
	/* Column Info */
	private String data28 = null;
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
	private String data21 = null;
	/* Column Info */
	private String data20 = null;
	/* Column Info */
	private String data05 = null;
	/* Column Info */
	private String data23 = null;
	/* Column Info */
	private String data04 = null;
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

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EdiAdvJpBlVO() {}

	public EdiAdvJpBlVO(String ibflag, String pagerows, String data03, String data04, String data05, String data06, String data07, String data08, String data09, String data10, String data11, String data12, String data13, String data14, String data15, String data16, String data17, String data18a, String data18b, String data18c, String data19, String data20, String data21, String data22, String data23, String data24, String data25, String data26, String data27, String data28) {
		this.data19 = data19;
		this.data17 = data17;
		this.pagerows = pagerows;
		this.data12 = data12;
		this.data11 = data11;
		this.data10 = data10;
		this.ibflag = ibflag;
		this.data16 = data16;
		this.data15 = data15;
		this.data14 = data14;
		this.data13 = data13;
		this.data18c = data18c;
		this.data18a = data18a;
		this.data18b = data18b;
		this.data28 = data28;
		this.data06 = data06;
		this.data07 = data07;
		this.data08 = data08;
		this.data09 = data09;
		this.data03 = data03;
		this.data21 = data21;
		this.data20 = data20;
		this.data05 = data05;
		this.data23 = data23;
		this.data04 = data04;
		this.data22 = data22;
		this.data25 = data25;
		this.data24 = data24;
		this.data27 = data27;
		this.data26 = data26;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("data19", getData19());
		this.hashColumns.put("data17", getData17());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("data12", getData12());
		this.hashColumns.put("data11", getData11());
		this.hashColumns.put("data10", getData10());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("data16", getData16());
		this.hashColumns.put("data15", getData15());
		this.hashColumns.put("data14", getData14());
		this.hashColumns.put("data13", getData13());
		this.hashColumns.put("data18c", getData18c());
		this.hashColumns.put("data18a", getData18a());
		this.hashColumns.put("data18b", getData18b());
		this.hashColumns.put("data28", getData28());
		this.hashColumns.put("data06", getData06());
		this.hashColumns.put("data07", getData07());
		this.hashColumns.put("data08", getData08());
		this.hashColumns.put("data09", getData09());
		this.hashColumns.put("data03", getData03());
		this.hashColumns.put("data21", getData21());
		this.hashColumns.put("data20", getData20());
		this.hashColumns.put("data05", getData05());
		this.hashColumns.put("data23", getData23());
		this.hashColumns.put("data04", getData04());
		this.hashColumns.put("data22", getData22());
		this.hashColumns.put("data25", getData25());
		this.hashColumns.put("data24", getData24());
		this.hashColumns.put("data27", getData27());
		this.hashColumns.put("data26", getData26());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("data19", "data19");
		this.hashFields.put("data17", "data17");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("data12", "data12");
		this.hashFields.put("data11", "data11");
		this.hashFields.put("data10", "data10");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("data16", "data16");
		this.hashFields.put("data15", "data15");
		this.hashFields.put("data14", "data14");
		this.hashFields.put("data13", "data13");
		this.hashFields.put("data18c", "data18c");
		this.hashFields.put("data18a", "data18a");
		this.hashFields.put("data18b", "data18b");
		this.hashFields.put("data28", "data28");
		this.hashFields.put("data06", "data06");
		this.hashFields.put("data07", "data07");
		this.hashFields.put("data08", "data08");
		this.hashFields.put("data09", "data09");
		this.hashFields.put("data03", "data03");
		this.hashFields.put("data21", "data21");
		this.hashFields.put("data20", "data20");
		this.hashFields.put("data05", "data05");
		this.hashFields.put("data23", "data23");
		this.hashFields.put("data04", "data04");
		this.hashFields.put("data22", "data22");
		this.hashFields.put("data25", "data25");
		this.hashFields.put("data24", "data24");
		this.hashFields.put("data27", "data27");
		this.hashFields.put("data26", "data26");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return data18c
	 */
	public String getData18c() {
		return this.data18c;
	}
	
	/**
	 * Column Info
	 * @return data18a
	 */
	public String getData18a() {
		return this.data18a;
	}
	
	/**
	 * Column Info
	 * @return data18b
	 */
	public String getData18b() {
		return this.data18b;
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
	 * @return data05
	 */
	public String getData05() {
		return this.data05;
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
	 * @return data04
	 */
	public String getData04() {
		return this.data04;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param data18c
	 */
	public void setData18c(String data18c) {
		this.data18c = data18c;
	}
	
	/**
	 * Column Info
	 * @param data18a
	 */
	public void setData18a(String data18a) {
		this.data18a = data18a;
	}
	
	/**
	 * Column Info
	 * @param data18b
	 */
	public void setData18b(String data18b) {
		this.data18b = data18b;
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
	 * @param data05
	 */
	public void setData05(String data05) {
		this.data05 = data05;
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
	 * @param data04
	 */
	public void setData04(String data04) {
		this.data04 = data04;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setData12(JSPUtil.getParameter(request, prefix + "data12", ""));
		setData11(JSPUtil.getParameter(request, prefix + "data11", ""));
		setData10(JSPUtil.getParameter(request, prefix + "data10", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setData16(JSPUtil.getParameter(request, prefix + "data16", ""));
		setData15(JSPUtil.getParameter(request, prefix + "data15", ""));
		setData14(JSPUtil.getParameter(request, prefix + "data14", ""));
		setData13(JSPUtil.getParameter(request, prefix + "data13", ""));
		setData18c(JSPUtil.getParameter(request, prefix + "data18c", ""));
		setData18a(JSPUtil.getParameter(request, prefix + "data18a", ""));
		setData18b(JSPUtil.getParameter(request, prefix + "data18b", ""));
		setData28(JSPUtil.getParameter(request, prefix + "data28", ""));
		setData06(JSPUtil.getParameter(request, prefix + "data06", ""));
		setData07(JSPUtil.getParameter(request, prefix + "data07", ""));
		setData08(JSPUtil.getParameter(request, prefix + "data08", ""));
		setData09(JSPUtil.getParameter(request, prefix + "data09", ""));
		setData03(JSPUtil.getParameter(request, prefix + "data03", ""));
		setData21(JSPUtil.getParameter(request, prefix + "data21", ""));
		setData20(JSPUtil.getParameter(request, prefix + "data20", ""));
		setData05(JSPUtil.getParameter(request, prefix + "data05", ""));
		setData23(JSPUtil.getParameter(request, prefix + "data23", ""));
		setData04(JSPUtil.getParameter(request, prefix + "data04", ""));
		setData22(JSPUtil.getParameter(request, prefix + "data22", ""));
		setData25(JSPUtil.getParameter(request, prefix + "data25", ""));
		setData24(JSPUtil.getParameter(request, prefix + "data24", ""));
		setData27(JSPUtil.getParameter(request, prefix + "data27", ""));
		setData26(JSPUtil.getParameter(request, prefix + "data26", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdiAdvJpBlVO[]
	 */
	public EdiAdvJpBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EdiAdvJpBlVO[]
	 */
	public EdiAdvJpBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EdiAdvJpBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] data19 = (JSPUtil.getParameter(request, prefix	+ "data19", length));
			String[] data17 = (JSPUtil.getParameter(request, prefix	+ "data17", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] data12 = (JSPUtil.getParameter(request, prefix	+ "data12", length));
			String[] data11 = (JSPUtil.getParameter(request, prefix	+ "data11", length));
			String[] data10 = (JSPUtil.getParameter(request, prefix	+ "data10", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] data16 = (JSPUtil.getParameter(request, prefix	+ "data16", length));
			String[] data15 = (JSPUtil.getParameter(request, prefix	+ "data15", length));
			String[] data14 = (JSPUtil.getParameter(request, prefix	+ "data14", length));
			String[] data13 = (JSPUtil.getParameter(request, prefix	+ "data13", length));
			String[] data18c = (JSPUtil.getParameter(request, prefix	+ "data18c", length));
			String[] data18a = (JSPUtil.getParameter(request, prefix	+ "data18a", length));
			String[] data18b = (JSPUtil.getParameter(request, prefix	+ "data18b", length));
			String[] data28 = (JSPUtil.getParameter(request, prefix	+ "data28", length));
			String[] data06 = (JSPUtil.getParameter(request, prefix	+ "data06", length));
			String[] data07 = (JSPUtil.getParameter(request, prefix	+ "data07", length));
			String[] data08 = (JSPUtil.getParameter(request, prefix	+ "data08", length));
			String[] data09 = (JSPUtil.getParameter(request, prefix	+ "data09", length));
			String[] data03 = (JSPUtil.getParameter(request, prefix	+ "data03", length));
			String[] data21 = (JSPUtil.getParameter(request, prefix	+ "data21", length));
			String[] data20 = (JSPUtil.getParameter(request, prefix	+ "data20", length));
			String[] data05 = (JSPUtil.getParameter(request, prefix	+ "data05", length));
			String[] data23 = (JSPUtil.getParameter(request, prefix	+ "data23", length));
			String[] data04 = (JSPUtil.getParameter(request, prefix	+ "data04", length));
			String[] data22 = (JSPUtil.getParameter(request, prefix	+ "data22", length));
			String[] data25 = (JSPUtil.getParameter(request, prefix	+ "data25", length));
			String[] data24 = (JSPUtil.getParameter(request, prefix	+ "data24", length));
			String[] data27 = (JSPUtil.getParameter(request, prefix	+ "data27", length));
			String[] data26 = (JSPUtil.getParameter(request, prefix	+ "data26", length));
			
			for (int i = 0; i < length; i++) {
				model = new EdiAdvJpBlVO();
				if (data19[i] != null)
					model.setData19(data19[i]);
				if (data17[i] != null)
					model.setData17(data17[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (data12[i] != null)
					model.setData12(data12[i]);
				if (data11[i] != null)
					model.setData11(data11[i]);
				if (data10[i] != null)
					model.setData10(data10[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (data16[i] != null)
					model.setData16(data16[i]);
				if (data15[i] != null)
					model.setData15(data15[i]);
				if (data14[i] != null)
					model.setData14(data14[i]);
				if (data13[i] != null)
					model.setData13(data13[i]);
				if (data18c[i] != null)
					model.setData18c(data18c[i]);
				if (data18a[i] != null)
					model.setData18a(data18a[i]);
				if (data18b[i] != null)
					model.setData18b(data18b[i]);
				if (data28[i] != null)
					model.setData28(data28[i]);
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
				if (data21[i] != null)
					model.setData21(data21[i]);
				if (data20[i] != null)
					model.setData20(data20[i]);
				if (data05[i] != null)
					model.setData05(data05[i]);
				if (data23[i] != null)
					model.setData23(data23[i]);
				if (data04[i] != null)
					model.setData04(data04[i]);
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
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdiAdvJpBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EdiAdvJpBlVO[]
	 */
	public EdiAdvJpBlVO[] getEdiAdvJpBlVOs(){
		EdiAdvJpBlVO[] vos = (EdiAdvJpBlVO[])models.toArray(new EdiAdvJpBlVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data12 = this.data12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data11 = this.data11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data10 = this.data10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data16 = this.data16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data15 = this.data15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data14 = this.data14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data13 = this.data13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data18c = this.data18c .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data18a = this.data18a .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data18b = this.data18b .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data28 = this.data28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data06 = this.data06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data07 = this.data07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data08 = this.data08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data09 = this.data09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data03 = this.data03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data21 = this.data21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data20 = this.data20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data05 = this.data05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data23 = this.data23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data04 = this.data04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data22 = this.data22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data25 = this.data25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data24 = this.data24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data27 = this.data27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data26 = this.data26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
