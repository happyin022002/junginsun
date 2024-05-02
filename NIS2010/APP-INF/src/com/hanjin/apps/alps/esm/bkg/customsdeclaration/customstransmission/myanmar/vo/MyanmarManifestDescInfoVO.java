/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MyanmarManifestDescInfoVO.java
*@FileTitle : MyanmarManifestDescInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.myanmar.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MyanmarManifestDescInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MyanmarManifestDescInfoVO> models = new ArrayList<MyanmarManifestDescInfoVO>();
	
	/* Column Info */
	private String desc29 = null;
	/* Column Info */
	private String desc9 = null;
	/* Column Info */
	private String desc27 = null;
	/* Column Info */
	private String desc7 = null;
	/* Column Info */
	private String desc28 = null;
	/* Column Info */
	private String desc8 = null;
	/* Column Info */
	private String desc25 = null;
	/* Column Info */
	private String desc5 = null;
	/* Column Info */
	private String desc26 = null;
	/* Column Info */
	private String desc6 = null;
	/* Column Info */
	private String desc3 = null;
	/* Column Info */
	private String desc23 = null;
	/* Column Info */
	private String desc24 = null;
	/* Column Info */
	private String desc4 = null;
	/* Column Info */
	private String desc1 = null;
	/* Column Info */
	private String desc21 = null;
	/* Column Info */
	private String desc2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String desc22 = null;
	/* Column Info */
	private String desc20 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String desc11 = null;
	/* Column Info */
	private String desc10 = null;
	/* Column Info */
	private String desc13 = null;
	/* Column Info */
	private String desc12 = null;
	/* Column Info */
	private String desc15 = null;
	/* Column Info */
	private String desc14 = null;
	/* Column Info */
	private String desc17 = null;
	/* Column Info */
	private String desc16 = null;
	/* Column Info */
	private String desc19 = null;
	/* Column Info */
	private String desc18 = null;
	/* Column Info */
	private String desc30 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MyanmarManifestDescInfoVO() {}

	public MyanmarManifestDescInfoVO(String ibflag, String pagerows, String desc1, String desc2, String desc3, String desc4, String desc5, String desc6, String desc7, String desc8, String desc9, String desc10, String desc11, String desc12, String desc13, String desc14, String desc15, String desc16, String desc17, String desc18, String desc19, String desc20, String desc21, String desc22, String desc23, String desc24, String desc25, String desc26, String desc27, String desc28, String desc29, String desc30) {
		this.desc29 = desc29;
		this.desc9 = desc9;
		this.desc27 = desc27;
		this.desc7 = desc7;
		this.desc28 = desc28;
		this.desc8 = desc8;
		this.desc25 = desc25;
		this.desc5 = desc5;
		this.desc26 = desc26;
		this.desc6 = desc6;
		this.desc3 = desc3;
		this.desc23 = desc23;
		this.desc24 = desc24;
		this.desc4 = desc4;
		this.desc1 = desc1;
		this.desc21 = desc21;
		this.desc2 = desc2;
		this.pagerows = pagerows;
		this.desc22 = desc22;
		this.desc20 = desc20;
		this.ibflag = ibflag;
		this.desc11 = desc11;
		this.desc10 = desc10;
		this.desc13 = desc13;
		this.desc12 = desc12;
		this.desc15 = desc15;
		this.desc14 = desc14;
		this.desc17 = desc17;
		this.desc16 = desc16;
		this.desc19 = desc19;
		this.desc18 = desc18;
		this.desc30 = desc30;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("desc29", getDesc29());
		this.hashColumns.put("desc9", getDesc9());
		this.hashColumns.put("desc27", getDesc27());
		this.hashColumns.put("desc7", getDesc7());
		this.hashColumns.put("desc28", getDesc28());
		this.hashColumns.put("desc8", getDesc8());
		this.hashColumns.put("desc25", getDesc25());
		this.hashColumns.put("desc5", getDesc5());
		this.hashColumns.put("desc26", getDesc26());
		this.hashColumns.put("desc6", getDesc6());
		this.hashColumns.put("desc3", getDesc3());
		this.hashColumns.put("desc23", getDesc23());
		this.hashColumns.put("desc24", getDesc24());
		this.hashColumns.put("desc4", getDesc4());
		this.hashColumns.put("desc1", getDesc1());
		this.hashColumns.put("desc21", getDesc21());
		this.hashColumns.put("desc2", getDesc2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("desc22", getDesc22());
		this.hashColumns.put("desc20", getDesc20());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("desc11", getDesc11());
		this.hashColumns.put("desc10", getDesc10());
		this.hashColumns.put("desc13", getDesc13());
		this.hashColumns.put("desc12", getDesc12());
		this.hashColumns.put("desc15", getDesc15());
		this.hashColumns.put("desc14", getDesc14());
		this.hashColumns.put("desc17", getDesc17());
		this.hashColumns.put("desc16", getDesc16());
		this.hashColumns.put("desc19", getDesc19());
		this.hashColumns.put("desc18", getDesc18());
		this.hashColumns.put("desc30", getDesc30());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("desc29", "desc29");
		this.hashFields.put("desc9", "desc9");
		this.hashFields.put("desc27", "desc27");
		this.hashFields.put("desc7", "desc7");
		this.hashFields.put("desc28", "desc28");
		this.hashFields.put("desc8", "desc8");
		this.hashFields.put("desc25", "desc25");
		this.hashFields.put("desc5", "desc5");
		this.hashFields.put("desc26", "desc26");
		this.hashFields.put("desc6", "desc6");
		this.hashFields.put("desc3", "desc3");
		this.hashFields.put("desc23", "desc23");
		this.hashFields.put("desc24", "desc24");
		this.hashFields.put("desc4", "desc4");
		this.hashFields.put("desc1", "desc1");
		this.hashFields.put("desc21", "desc21");
		this.hashFields.put("desc2", "desc2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("desc22", "desc22");
		this.hashFields.put("desc20", "desc20");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("desc11", "desc11");
		this.hashFields.put("desc10", "desc10");
		this.hashFields.put("desc13", "desc13");
		this.hashFields.put("desc12", "desc12");
		this.hashFields.put("desc15", "desc15");
		this.hashFields.put("desc14", "desc14");
		this.hashFields.put("desc17", "desc17");
		this.hashFields.put("desc16", "desc16");
		this.hashFields.put("desc19", "desc19");
		this.hashFields.put("desc18", "desc18");
		this.hashFields.put("desc30", "desc30");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return desc29
	 */
	public String getDesc29() {
		return this.desc29;
	}
	
	/**
	 * Column Info
	 * @return desc9
	 */
	public String getDesc9() {
		return this.desc9;
	}
	
	/**
	 * Column Info
	 * @return desc27
	 */
	public String getDesc27() {
		return this.desc27;
	}
	
	/**
	 * Column Info
	 * @return desc7
	 */
	public String getDesc7() {
		return this.desc7;
	}
	
	/**
	 * Column Info
	 * @return desc28
	 */
	public String getDesc28() {
		return this.desc28;
	}
	
	/**
	 * Column Info
	 * @return desc8
	 */
	public String getDesc8() {
		return this.desc8;
	}
	
	/**
	 * Column Info
	 * @return desc25
	 */
	public String getDesc25() {
		return this.desc25;
	}
	
	/**
	 * Column Info
	 * @return desc5
	 */
	public String getDesc5() {
		return this.desc5;
	}
	
	/**
	 * Column Info
	 * @return desc26
	 */
	public String getDesc26() {
		return this.desc26;
	}
	
	/**
	 * Column Info
	 * @return desc6
	 */
	public String getDesc6() {
		return this.desc6;
	}
	
	/**
	 * Column Info
	 * @return desc3
	 */
	public String getDesc3() {
		return this.desc3;
	}
	
	/**
	 * Column Info
	 * @return desc23
	 */
	public String getDesc23() {
		return this.desc23;
	}
	
	/**
	 * Column Info
	 * @return desc24
	 */
	public String getDesc24() {
		return this.desc24;
	}
	
	/**
	 * Column Info
	 * @return desc4
	 */
	public String getDesc4() {
		return this.desc4;
	}
	
	/**
	 * Column Info
	 * @return desc1
	 */
	public String getDesc1() {
		return this.desc1;
	}
	
	/**
	 * Column Info
	 * @return desc21
	 */
	public String getDesc21() {
		return this.desc21;
	}
	
	/**
	 * Column Info
	 * @return desc2
	 */
	public String getDesc2() {
		return this.desc2;
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
	 * @return desc22
	 */
	public String getDesc22() {
		return this.desc22;
	}
	
	/**
	 * Column Info
	 * @return desc20
	 */
	public String getDesc20() {
		return this.desc20;
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
	 * @return desc11
	 */
	public String getDesc11() {
		return this.desc11;
	}
	
	/**
	 * Column Info
	 * @return desc10
	 */
	public String getDesc10() {
		return this.desc10;
	}
	
	/**
	 * Column Info
	 * @return desc13
	 */
	public String getDesc13() {
		return this.desc13;
	}
	
	/**
	 * Column Info
	 * @return desc12
	 */
	public String getDesc12() {
		return this.desc12;
	}
	
	/**
	 * Column Info
	 * @return desc15
	 */
	public String getDesc15() {
		return this.desc15;
	}
	
	/**
	 * Column Info
	 * @return desc14
	 */
	public String getDesc14() {
		return this.desc14;
	}
	
	/**
	 * Column Info
	 * @return desc17
	 */
	public String getDesc17() {
		return this.desc17;
	}
	
	/**
	 * Column Info
	 * @return desc16
	 */
	public String getDesc16() {
		return this.desc16;
	}
	
	/**
	 * Column Info
	 * @return desc19
	 */
	public String getDesc19() {
		return this.desc19;
	}
	
	/**
	 * Column Info
	 * @return desc18
	 */
	public String getDesc18() {
		return this.desc18;
	}
	
	/**
	 * Column Info
	 * @return desc30
	 */
	public String getDesc30() {
		return this.desc30;
	}
	

	/**
	 * Column Info
	 * @param desc29
	 */
	public void setDesc29(String desc29) {
		this.desc29 = desc29;
	}
	
	/**
	 * Column Info
	 * @param desc9
	 */
	public void setDesc9(String desc9) {
		this.desc9 = desc9;
	}
	
	/**
	 * Column Info
	 * @param desc27
	 */
	public void setDesc27(String desc27) {
		this.desc27 = desc27;
	}
	
	/**
	 * Column Info
	 * @param desc7
	 */
	public void setDesc7(String desc7) {
		this.desc7 = desc7;
	}
	
	/**
	 * Column Info
	 * @param desc28
	 */
	public void setDesc28(String desc28) {
		this.desc28 = desc28;
	}
	
	/**
	 * Column Info
	 * @param desc8
	 */
	public void setDesc8(String desc8) {
		this.desc8 = desc8;
	}
	
	/**
	 * Column Info
	 * @param desc25
	 */
	public void setDesc25(String desc25) {
		this.desc25 = desc25;
	}
	
	/**
	 * Column Info
	 * @param desc5
	 */
	public void setDesc5(String desc5) {
		this.desc5 = desc5;
	}
	
	/**
	 * Column Info
	 * @param desc26
	 */
	public void setDesc26(String desc26) {
		this.desc26 = desc26;
	}
	
	/**
	 * Column Info
	 * @param desc6
	 */
	public void setDesc6(String desc6) {
		this.desc6 = desc6;
	}
	
	/**
	 * Column Info
	 * @param desc3
	 */
	public void setDesc3(String desc3) {
		this.desc3 = desc3;
	}
	
	/**
	 * Column Info
	 * @param desc23
	 */
	public void setDesc23(String desc23) {
		this.desc23 = desc23;
	}
	
	/**
	 * Column Info
	 * @param desc24
	 */
	public void setDesc24(String desc24) {
		this.desc24 = desc24;
	}
	
	/**
	 * Column Info
	 * @param desc4
	 */
	public void setDesc4(String desc4) {
		this.desc4 = desc4;
	}
	
	/**
	 * Column Info
	 * @param desc1
	 */
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	
	/**
	 * Column Info
	 * @param desc21
	 */
	public void setDesc21(String desc21) {
		this.desc21 = desc21;
	}
	
	/**
	 * Column Info
	 * @param desc2
	 */
	public void setDesc2(String desc2) {
		this.desc2 = desc2;
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
	 * @param desc22
	 */
	public void setDesc22(String desc22) {
		this.desc22 = desc22;
	}
	
	/**
	 * Column Info
	 * @param desc20
	 */
	public void setDesc20(String desc20) {
		this.desc20 = desc20;
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
	 * @param desc11
	 */
	public void setDesc11(String desc11) {
		this.desc11 = desc11;
	}
	
	/**
	 * Column Info
	 * @param desc10
	 */
	public void setDesc10(String desc10) {
		this.desc10 = desc10;
	}
	
	/**
	 * Column Info
	 * @param desc13
	 */
	public void setDesc13(String desc13) {
		this.desc13 = desc13;
	}
	
	/**
	 * Column Info
	 * @param desc12
	 */
	public void setDesc12(String desc12) {
		this.desc12 = desc12;
	}
	
	/**
	 * Column Info
	 * @param desc15
	 */
	public void setDesc15(String desc15) {
		this.desc15 = desc15;
	}
	
	/**
	 * Column Info
	 * @param desc14
	 */
	public void setDesc14(String desc14) {
		this.desc14 = desc14;
	}
	
	/**
	 * Column Info
	 * @param desc17
	 */
	public void setDesc17(String desc17) {
		this.desc17 = desc17;
	}
	
	/**
	 * Column Info
	 * @param desc16
	 */
	public void setDesc16(String desc16) {
		this.desc16 = desc16;
	}
	
	/**
	 * Column Info
	 * @param desc19
	 */
	public void setDesc19(String desc19) {
		this.desc19 = desc19;
	}
	
	/**
	 * Column Info
	 * @param desc18
	 */
	public void setDesc18(String desc18) {
		this.desc18 = desc18;
	}
	
	/**
	 * Column Info
	 * @param desc30
	 */
	public void setDesc30(String desc30) {
		this.desc30 = desc30;
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
		setDesc29(JSPUtil.getParameter(request, prefix + "desc29", ""));
		setDesc9(JSPUtil.getParameter(request, prefix + "desc9", ""));
		setDesc27(JSPUtil.getParameter(request, prefix + "desc27", ""));
		setDesc7(JSPUtil.getParameter(request, prefix + "desc7", ""));
		setDesc28(JSPUtil.getParameter(request, prefix + "desc28", ""));
		setDesc8(JSPUtil.getParameter(request, prefix + "desc8", ""));
		setDesc25(JSPUtil.getParameter(request, prefix + "desc25", ""));
		setDesc5(JSPUtil.getParameter(request, prefix + "desc5", ""));
		setDesc26(JSPUtil.getParameter(request, prefix + "desc26", ""));
		setDesc6(JSPUtil.getParameter(request, prefix + "desc6", ""));
		setDesc3(JSPUtil.getParameter(request, prefix + "desc3", ""));
		setDesc23(JSPUtil.getParameter(request, prefix + "desc23", ""));
		setDesc24(JSPUtil.getParameter(request, prefix + "desc24", ""));
		setDesc4(JSPUtil.getParameter(request, prefix + "desc4", ""));
		setDesc1(JSPUtil.getParameter(request, prefix + "desc1", ""));
		setDesc21(JSPUtil.getParameter(request, prefix + "desc21", ""));
		setDesc2(JSPUtil.getParameter(request, prefix + "desc2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDesc22(JSPUtil.getParameter(request, prefix + "desc22", ""));
		setDesc20(JSPUtil.getParameter(request, prefix + "desc20", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDesc11(JSPUtil.getParameter(request, prefix + "desc11", ""));
		setDesc10(JSPUtil.getParameter(request, prefix + "desc10", ""));
		setDesc13(JSPUtil.getParameter(request, prefix + "desc13", ""));
		setDesc12(JSPUtil.getParameter(request, prefix + "desc12", ""));
		setDesc15(JSPUtil.getParameter(request, prefix + "desc15", ""));
		setDesc14(JSPUtil.getParameter(request, prefix + "desc14", ""));
		setDesc17(JSPUtil.getParameter(request, prefix + "desc17", ""));
		setDesc16(JSPUtil.getParameter(request, prefix + "desc16", ""));
		setDesc19(JSPUtil.getParameter(request, prefix + "desc19", ""));
		setDesc18(JSPUtil.getParameter(request, prefix + "desc18", ""));
		setDesc30(JSPUtil.getParameter(request, prefix + "desc30", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MyanmarManifestDescInfoVO[]
	 */
	public MyanmarManifestDescInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MyanmarManifestDescInfoVO[]
	 */
	public MyanmarManifestDescInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MyanmarManifestDescInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] desc29 = (JSPUtil.getParameter(request, prefix	+ "desc29", length));
			String[] desc9 = (JSPUtil.getParameter(request, prefix	+ "desc9", length));
			String[] desc27 = (JSPUtil.getParameter(request, prefix	+ "desc27", length));
			String[] desc7 = (JSPUtil.getParameter(request, prefix	+ "desc7", length));
			String[] desc28 = (JSPUtil.getParameter(request, prefix	+ "desc28", length));
			String[] desc8 = (JSPUtil.getParameter(request, prefix	+ "desc8", length));
			String[] desc25 = (JSPUtil.getParameter(request, prefix	+ "desc25", length));
			String[] desc5 = (JSPUtil.getParameter(request, prefix	+ "desc5", length));
			String[] desc26 = (JSPUtil.getParameter(request, prefix	+ "desc26", length));
			String[] desc6 = (JSPUtil.getParameter(request, prefix	+ "desc6", length));
			String[] desc3 = (JSPUtil.getParameter(request, prefix	+ "desc3", length));
			String[] desc23 = (JSPUtil.getParameter(request, prefix	+ "desc23", length));
			String[] desc24 = (JSPUtil.getParameter(request, prefix	+ "desc24", length));
			String[] desc4 = (JSPUtil.getParameter(request, prefix	+ "desc4", length));
			String[] desc1 = (JSPUtil.getParameter(request, prefix	+ "desc1", length));
			String[] desc21 = (JSPUtil.getParameter(request, prefix	+ "desc21", length));
			String[] desc2 = (JSPUtil.getParameter(request, prefix	+ "desc2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] desc22 = (JSPUtil.getParameter(request, prefix	+ "desc22", length));
			String[] desc20 = (JSPUtil.getParameter(request, prefix	+ "desc20", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] desc11 = (JSPUtil.getParameter(request, prefix	+ "desc11", length));
			String[] desc10 = (JSPUtil.getParameter(request, prefix	+ "desc10", length));
			String[] desc13 = (JSPUtil.getParameter(request, prefix	+ "desc13", length));
			String[] desc12 = (JSPUtil.getParameter(request, prefix	+ "desc12", length));
			String[] desc15 = (JSPUtil.getParameter(request, prefix	+ "desc15", length));
			String[] desc14 = (JSPUtil.getParameter(request, prefix	+ "desc14", length));
			String[] desc17 = (JSPUtil.getParameter(request, prefix	+ "desc17", length));
			String[] desc16 = (JSPUtil.getParameter(request, prefix	+ "desc16", length));
			String[] desc19 = (JSPUtil.getParameter(request, prefix	+ "desc19", length));
			String[] desc18 = (JSPUtil.getParameter(request, prefix	+ "desc18", length));
			String[] desc30 = (JSPUtil.getParameter(request, prefix	+ "desc30", length));
			
			for (int i = 0; i < length; i++) {
				model = new MyanmarManifestDescInfoVO();
				if (desc29[i] != null)
					model.setDesc29(desc29[i]);
				if (desc9[i] != null)
					model.setDesc9(desc9[i]);
				if (desc27[i] != null)
					model.setDesc27(desc27[i]);
				if (desc7[i] != null)
					model.setDesc7(desc7[i]);
				if (desc28[i] != null)
					model.setDesc28(desc28[i]);
				if (desc8[i] != null)
					model.setDesc8(desc8[i]);
				if (desc25[i] != null)
					model.setDesc25(desc25[i]);
				if (desc5[i] != null)
					model.setDesc5(desc5[i]);
				if (desc26[i] != null)
					model.setDesc26(desc26[i]);
				if (desc6[i] != null)
					model.setDesc6(desc6[i]);
				if (desc3[i] != null)
					model.setDesc3(desc3[i]);
				if (desc23[i] != null)
					model.setDesc23(desc23[i]);
				if (desc24[i] != null)
					model.setDesc24(desc24[i]);
				if (desc4[i] != null)
					model.setDesc4(desc4[i]);
				if (desc1[i] != null)
					model.setDesc1(desc1[i]);
				if (desc21[i] != null)
					model.setDesc21(desc21[i]);
				if (desc2[i] != null)
					model.setDesc2(desc2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (desc22[i] != null)
					model.setDesc22(desc22[i]);
				if (desc20[i] != null)
					model.setDesc20(desc20[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (desc11[i] != null)
					model.setDesc11(desc11[i]);
				if (desc10[i] != null)
					model.setDesc10(desc10[i]);
				if (desc13[i] != null)
					model.setDesc13(desc13[i]);
				if (desc12[i] != null)
					model.setDesc12(desc12[i]);
				if (desc15[i] != null)
					model.setDesc15(desc15[i]);
				if (desc14[i] != null)
					model.setDesc14(desc14[i]);
				if (desc17[i] != null)
					model.setDesc17(desc17[i]);
				if (desc16[i] != null)
					model.setDesc16(desc16[i]);
				if (desc19[i] != null)
					model.setDesc19(desc19[i]);
				if (desc18[i] != null)
					model.setDesc18(desc18[i]);
				if (desc30[i] != null)
					model.setDesc30(desc30[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMyanmarManifestDescInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MyanmarManifestDescInfoVO[]
	 */
	public MyanmarManifestDescInfoVO[] getMyanmarManifestDescInfoVOs(){
		MyanmarManifestDescInfoVO[] vos = (MyanmarManifestDescInfoVO[])models.toArray(new MyanmarManifestDescInfoVO[models.size()]);
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
		this.desc29 = this.desc29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc9 = this.desc9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc27 = this.desc27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc7 = this.desc7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc28 = this.desc28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc8 = this.desc8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc25 = this.desc25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc5 = this.desc5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc26 = this.desc26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc6 = this.desc6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc3 = this.desc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc23 = this.desc23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc24 = this.desc24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc4 = this.desc4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc1 = this.desc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc21 = this.desc21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc2 = this.desc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc22 = this.desc22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc20 = this.desc20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc11 = this.desc11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc10 = this.desc10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc13 = this.desc13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc12 = this.desc12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc15 = this.desc15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc14 = this.desc14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc17 = this.desc17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc16 = this.desc16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc19 = this.desc19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc18 = this.desc18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc30 = this.desc30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
