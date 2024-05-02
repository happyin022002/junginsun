/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OutstandingAgingListVO.java
*@FileTitle : OutstandingAgingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.21  
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

public class OutstandingAgingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OutstandingAgingListVO> models = new ArrayList<OutstandingAgingListVO>();
	
	/* Column Info */
	private String col09 = null;
	/* Column Info */
	private String col08 = null;
	/* Column Info */
	private String col27 = null;
	/* Column Info */
	private String col01 = null;
	/* Column Info */
	private String col26 = null;
	/* Column Info */
	private String col03 = null;
	/* Column Info */
	private String col02 = null;
	/* Column Info */
	private String col05 = null;
	/* Column Info */
	private String col23 = null;
	/* Column Info */
	private String col04 = null;
	/* Column Info */
	private String col22 = null;
	/* Column Info */
	private String col25 = null;
	/* Column Info */
	private String col07 = null;
	/* Column Info */
	private String col24 = null;
	/* Column Info */
	private String col06 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String col10 = null;
	/* Column Info */
	private String col19 = null;
	/* Column Info */
	private String col14 = null;
	/* Column Info */
	private String col13 = null;
	/* Column Info */
	private String col12 = null;
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
	private String col20 = null;
	/* Column Info */
	private String col21 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OutstandingAgingListVO() {}

	public OutstandingAgingListVO(String ibflag, String pagerows, String col01, String col02, String col03, String col04, String col05, String col06, String col07, String col08, String col09, String col10, String col11, String col12, String col13, String col14, String col15, String col16, String col17, String col18, String col19, String col20, String col21, String col22, String col23, String col24, String col25, String col26, String col27) {
		this.col09 = col09;
		this.col08 = col08;
		this.col27 = col27;
		this.col01 = col01;
		this.col26 = col26;
		this.col03 = col03;
		this.col02 = col02;
		this.col05 = col05;
		this.col23 = col23;
		this.col04 = col04;
		this.col22 = col22;
		this.col25 = col25;
		this.col07 = col07;
		this.col24 = col24;
		this.col06 = col06;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.col10 = col10;
		this.col19 = col19;
		this.col14 = col14;
		this.col13 = col13;
		this.col12 = col12;
		this.col11 = col11;
		this.col18 = col18;
		this.col17 = col17;
		this.col16 = col16;
		this.col15 = col15;
		this.col20 = col20;
		this.col21 = col21;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("col09", getCol09());
		this.hashColumns.put("col08", getCol08());
		this.hashColumns.put("col27", getCol27());
		this.hashColumns.put("col01", getCol01());
		this.hashColumns.put("col26", getCol26());
		this.hashColumns.put("col03", getCol03());
		this.hashColumns.put("col02", getCol02());
		this.hashColumns.put("col05", getCol05());
		this.hashColumns.put("col23", getCol23());
		this.hashColumns.put("col04", getCol04());
		this.hashColumns.put("col22", getCol22());
		this.hashColumns.put("col25", getCol25());
		this.hashColumns.put("col07", getCol07());
		this.hashColumns.put("col24", getCol24());
		this.hashColumns.put("col06", getCol06());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("col10", getCol10());
		this.hashColumns.put("col19", getCol19());
		this.hashColumns.put("col14", getCol14());
		this.hashColumns.put("col13", getCol13());
		this.hashColumns.put("col12", getCol12());
		this.hashColumns.put("col11", getCol11());
		this.hashColumns.put("col18", getCol18());
		this.hashColumns.put("col17", getCol17());
		this.hashColumns.put("col16", getCol16());
		this.hashColumns.put("col15", getCol15());
		this.hashColumns.put("col20", getCol20());
		this.hashColumns.put("col21", getCol21());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("col09", "col09");
		this.hashFields.put("col08", "col08");
		this.hashFields.put("col27", "col27");
		this.hashFields.put("col01", "col01");
		this.hashFields.put("col26", "col26");
		this.hashFields.put("col03", "col03");
		this.hashFields.put("col02", "col02");
		this.hashFields.put("col05", "col05");
		this.hashFields.put("col23", "col23");
		this.hashFields.put("col04", "col04");
		this.hashFields.put("col22", "col22");
		this.hashFields.put("col25", "col25");
		this.hashFields.put("col07", "col07");
		this.hashFields.put("col24", "col24");
		this.hashFields.put("col06", "col06");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("col10", "col10");
		this.hashFields.put("col19", "col19");
		this.hashFields.put("col14", "col14");
		this.hashFields.put("col13", "col13");
		this.hashFields.put("col12", "col12");
		this.hashFields.put("col11", "col11");
		this.hashFields.put("col18", "col18");
		this.hashFields.put("col17", "col17");
		this.hashFields.put("col16", "col16");
		this.hashFields.put("col15", "col15");
		this.hashFields.put("col20", "col20");
		this.hashFields.put("col21", "col21");
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
	 * @return col27
	 */
	public String getCol27() {
		return this.col27;
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
	 * @return col26
	 */
	public String getCol26() {
		return this.col26;
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
	 * @return col23
	 */
	public String getCol23() {
		return this.col23;
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
	 * @return col22
	 */
	public String getCol22() {
		return this.col22;
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
	 * @return col07
	 */
	public String getCol07() {
		return this.col07;
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
	 * @return col06
	 */
	public String getCol06() {
		return this.col06;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return col14
	 */
	public String getCol14() {
		return this.col14;
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
	 * @return col12
	 */
	public String getCol12() {
		return this.col12;
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
	 * @return col20
	 */
	public String getCol20() {
		return this.col20;
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
	 * @param col27
	 */
	public void setCol27(String col27) {
		this.col27 = col27;
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
	 * @param col26
	 */
	public void setCol26(String col26) {
		this.col26 = col26;
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
	 * @param col23
	 */
	public void setCol23(String col23) {
		this.col23 = col23;
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
	 * @param col22
	 */
	public void setCol22(String col22) {
		this.col22 = col22;
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
	 * @param col07
	 */
	public void setCol07(String col07) {
		this.col07 = col07;
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
	 * @param col06
	 */
	public void setCol06(String col06) {
		this.col06 = col06;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param col14
	 */
	public void setCol14(String col14) {
		this.col14 = col14;
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
	 * @param col12
	 */
	public void setCol12(String col12) {
		this.col12 = col12;
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
	 * @param col20
	 */
	public void setCol20(String col20) {
		this.col20 = col20;
	}
	
	/**
	 * Column Info
	 * @param col21
	 */
	public void setCol21(String col21) {
		this.col21 = col21;
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
		setCol27(JSPUtil.getParameter(request, prefix + "col27", ""));
		setCol01(JSPUtil.getParameter(request, prefix + "col01", ""));
		setCol26(JSPUtil.getParameter(request, prefix + "col26", ""));
		setCol03(JSPUtil.getParameter(request, prefix + "col03", ""));
		setCol02(JSPUtil.getParameter(request, prefix + "col02", ""));
		setCol05(JSPUtil.getParameter(request, prefix + "col05", ""));
		setCol23(JSPUtil.getParameter(request, prefix + "col23", ""));
		setCol04(JSPUtil.getParameter(request, prefix + "col04", ""));
		setCol22(JSPUtil.getParameter(request, prefix + "col22", ""));
		setCol25(JSPUtil.getParameter(request, prefix + "col25", ""));
		setCol07(JSPUtil.getParameter(request, prefix + "col07", ""));
		setCol24(JSPUtil.getParameter(request, prefix + "col24", ""));
		setCol06(JSPUtil.getParameter(request, prefix + "col06", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCol10(JSPUtil.getParameter(request, prefix + "col10", ""));
		setCol19(JSPUtil.getParameter(request, prefix + "col19", ""));
		setCol14(JSPUtil.getParameter(request, prefix + "col14", ""));
		setCol13(JSPUtil.getParameter(request, prefix + "col13", ""));
		setCol12(JSPUtil.getParameter(request, prefix + "col12", ""));
		setCol11(JSPUtil.getParameter(request, prefix + "col11", ""));
		setCol18(JSPUtil.getParameter(request, prefix + "col18", ""));
		setCol17(JSPUtil.getParameter(request, prefix + "col17", ""));
		setCol16(JSPUtil.getParameter(request, prefix + "col16", ""));
		setCol15(JSPUtil.getParameter(request, prefix + "col15", ""));
		setCol20(JSPUtil.getParameter(request, prefix + "col20", ""));
		setCol21(JSPUtil.getParameter(request, prefix + "col21", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OutstandingAgingListVO[]
	 */
	public OutstandingAgingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OutstandingAgingListVO[]
	 */
	public OutstandingAgingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OutstandingAgingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] col09 = (JSPUtil.getParameter(request, prefix	+ "col09", length));
			String[] col08 = (JSPUtil.getParameter(request, prefix	+ "col08", length));
			String[] col27 = (JSPUtil.getParameter(request, prefix	+ "col27", length));
			String[] col01 = (JSPUtil.getParameter(request, prefix	+ "col01", length));
			String[] col26 = (JSPUtil.getParameter(request, prefix	+ "col26", length));
			String[] col03 = (JSPUtil.getParameter(request, prefix	+ "col03", length));
			String[] col02 = (JSPUtil.getParameter(request, prefix	+ "col02", length));
			String[] col05 = (JSPUtil.getParameter(request, prefix	+ "col05", length));
			String[] col23 = (JSPUtil.getParameter(request, prefix	+ "col23", length));
			String[] col04 = (JSPUtil.getParameter(request, prefix	+ "col04", length));
			String[] col22 = (JSPUtil.getParameter(request, prefix	+ "col22", length));
			String[] col25 = (JSPUtil.getParameter(request, prefix	+ "col25", length));
			String[] col07 = (JSPUtil.getParameter(request, prefix	+ "col07", length));
			String[] col24 = (JSPUtil.getParameter(request, prefix	+ "col24", length));
			String[] col06 = (JSPUtil.getParameter(request, prefix	+ "col06", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] col10 = (JSPUtil.getParameter(request, prefix	+ "col10", length));
			String[] col19 = (JSPUtil.getParameter(request, prefix	+ "col19", length));
			String[] col14 = (JSPUtil.getParameter(request, prefix	+ "col14", length));
			String[] col13 = (JSPUtil.getParameter(request, prefix	+ "col13", length));
			String[] col12 = (JSPUtil.getParameter(request, prefix	+ "col12", length));
			String[] col11 = (JSPUtil.getParameter(request, prefix	+ "col11", length));
			String[] col18 = (JSPUtil.getParameter(request, prefix	+ "col18", length));
			String[] col17 = (JSPUtil.getParameter(request, prefix	+ "col17", length));
			String[] col16 = (JSPUtil.getParameter(request, prefix	+ "col16", length));
			String[] col15 = (JSPUtil.getParameter(request, prefix	+ "col15", length));
			String[] col20 = (JSPUtil.getParameter(request, prefix	+ "col20", length));
			String[] col21 = (JSPUtil.getParameter(request, prefix	+ "col21", length));
			
			for (int i = 0; i < length; i++) {
				model = new OutstandingAgingListVO();
				if (col09[i] != null)
					model.setCol09(col09[i]);
				if (col08[i] != null)
					model.setCol08(col08[i]);
				if (col27[i] != null)
					model.setCol27(col27[i]);
				if (col01[i] != null)
					model.setCol01(col01[i]);
				if (col26[i] != null)
					model.setCol26(col26[i]);
				if (col03[i] != null)
					model.setCol03(col03[i]);
				if (col02[i] != null)
					model.setCol02(col02[i]);
				if (col05[i] != null)
					model.setCol05(col05[i]);
				if (col23[i] != null)
					model.setCol23(col23[i]);
				if (col04[i] != null)
					model.setCol04(col04[i]);
				if (col22[i] != null)
					model.setCol22(col22[i]);
				if (col25[i] != null)
					model.setCol25(col25[i]);
				if (col07[i] != null)
					model.setCol07(col07[i]);
				if (col24[i] != null)
					model.setCol24(col24[i]);
				if (col06[i] != null)
					model.setCol06(col06[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (col10[i] != null)
					model.setCol10(col10[i]);
				if (col19[i] != null)
					model.setCol19(col19[i]);
				if (col14[i] != null)
					model.setCol14(col14[i]);
				if (col13[i] != null)
					model.setCol13(col13[i]);
				if (col12[i] != null)
					model.setCol12(col12[i]);
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
				if (col20[i] != null)
					model.setCol20(col20[i]);
				if (col21[i] != null)
					model.setCol21(col21[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOutstandingAgingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OutstandingAgingListVO[]
	 */
	public OutstandingAgingListVO[] getOutstandingAgingListVOs(){
		OutstandingAgingListVO[] vos = (OutstandingAgingListVO[])models.toArray(new OutstandingAgingListVO[models.size()]);
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
		this.col27 = this.col27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col01 = this.col01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col26 = this.col26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col03 = this.col03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col02 = this.col02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col05 = this.col05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col23 = this.col23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col04 = this.col04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col22 = this.col22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col25 = this.col25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col07 = this.col07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col24 = this.col24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col06 = this.col06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col10 = this.col10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col19 = this.col19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col14 = this.col14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col13 = this.col13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col12 = this.col12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col11 = this.col11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col18 = this.col18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col17 = this.col17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col16 = this.col16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col15 = this.col15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col20 = this.col20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col21 = this.col21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
