/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : QuantityByTypeSizeVO.java
*@FileTitle : QuantityByTypeSizeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 명종범
*@LastVersion : 1.0
* 2009.04.30 명종범 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 명종범
 * @since J2EE 1.5
 */

public class QuantityByTypeSizeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<QuantityByTypeSizeVO> models = new ArrayList<QuantityByTypeSizeVO>();
	
	/* Column Info */
	private String qty18 = null;
	/* Column Info */
	private String qty26 = null;
	/* Column Info */
	private String qty29 = null;
	/* Column Info */
	private String qty13 = null;
	/* Column Info */
	private String qty5 = null;
	/* Column Info */
	private String qty9 = null;
	/* Column Info */
	private String qty33 = null;
	/* Column Info */
	private String qty27 = null;
	/* Column Info */
	private String qty0 = null;
	/* Column Info */
	private String qty10 = null;
	/* Column Info */
	private String qty38 = null;
	/* Column Info */
	private String division = null;
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String qty7 = null;
	/* Column Info */
	private String qty21 = null;
	/* Column Info */
	private String qty11 = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String qty35 = null;
	/* Column Info */
	private String qty19 = null;
	/* Column Info */
	private String qty36 = null;
	/* Column Info */
	private String qty8 = null;
	/* Column Info */
	private String qty24 = null;
	/* Column Info */
	private String qty6 = null;
	/* Column Info */
	private String qty12 = null;
	/* Column Info */
	private String qty1 = null;
	/* Column Info */
	private String qty34 = null;
	/* Column Info */
	private String qty14 = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String qty37 = null;
	/* Column Info */
	private String qty23 = null;
	/* Column Info */
	private String qty30 = null;
	/* Column Info */
	private String yardCd = null;
	/* Column Info */
	private String qty4 = null;
	/* Column Info */
	private String qty17 = null;
	/* Column Info */
	private String qty22 = null;
	/* Column Info */
	private String qty39 = null;
	/* Column Info */
	private String qty16 = null;
	/* Column Info */
	private String qty32 = null;
	/* Column Info */
	private String qty3 = null;
	/* Column Info */
	private String qty20 = null;
	/* Column Info */
	private String qty25 = null;
	/* Column Info */
	private String qty2 = null;
	/* Column Info */
	private String qty28 = null;
	/* Column Info */
	private String qty31 = null;
	/* Column Info */
	private String qty15 = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String vvd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public QuantityByTypeSizeVO() {}

	public QuantityByTypeSizeVO(String ibflag, String laneCd, String vvd, String pagerows, String locCd, String yardCd, String division, String total, String qty0, String qty1, String qty2, String qty3, String qty4, String qty5, String qty6, String qty7, String qty8, String qty9, String qty10, String qty11, String qty12, String qty13, String qty14, String qty15, String qty16, String qty17, String qty18, String qty19, String qty20, String qty21, String qty22, String qty23, String qty24, String qty25, String qty26, String qty27, String qty28, String qty29, String qty30, String qty31, String qty32, String qty33, String qty34, String qty35, String qty36, String qty37, String qty38, String qty39) {
		this.qty18 = qty18;
		this.qty26 = qty26;
		this.qty29 = qty29;
		this.qty13 = qty13;
		this.qty5 = qty5;
		this.qty9 = qty9;
		this.qty33 = qty33;
		this.qty27 = qty27;
		this.qty0 = qty0;
		this.qty10 = qty10;
		this.qty38 = qty38;
		this.division = division;
		this.total = total;
		this.qty7 = qty7;
		this.qty21 = qty21;
		this.qty11 = qty11;
		this.locCd = locCd;
		this.qty35 = qty35;
		this.qty19 = qty19;
		this.qty36 = qty36;
		this.qty8 = qty8;
		this.qty24 = qty24;
		this.qty6 = qty6;
		this.qty12 = qty12;
		this.qty1 = qty1;
		this.qty34 = qty34;
		this.qty14 = qty14;
		this.ibflag = ibflag;
		this.qty37 = qty37;
		this.qty23 = qty23;
		this.qty30 = qty30;
		this.yardCd = yardCd;
		this.qty4 = qty4;
		this.qty17 = qty17;
		this.qty22 = qty22;
		this.qty39 = qty39;
		this.qty16 = qty16;
		this.qty32 = qty32;
		this.qty3 = qty3;
		this.qty20 = qty20;
		this.qty25 = qty25;
		this.qty2 = qty2;
		this.qty28 = qty28;
		this.qty31 = qty31;
		this.qty15 = qty15;
		this.laneCd = laneCd;
		this.vvd = vvd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("qty_18", getQty18());
		this.hashColumns.put("qty_26", getQty26());
		this.hashColumns.put("qty_29", getQty29());
		this.hashColumns.put("qty_13", getQty13());
		this.hashColumns.put("qty_5", getQty5());
		this.hashColumns.put("qty_9", getQty9());
		this.hashColumns.put("qty_33", getQty33());
		this.hashColumns.put("qty_27", getQty27());
		this.hashColumns.put("qty_0", getQty0());
		this.hashColumns.put("qty_10", getQty10());
		this.hashColumns.put("qty_38", getQty38());
		this.hashColumns.put("division", getDivision());
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("qty_7", getQty7());
		this.hashColumns.put("qty_21", getQty21());
		this.hashColumns.put("qty_11", getQty11());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("qty_35", getQty35());
		this.hashColumns.put("qty_19", getQty19());
		this.hashColumns.put("qty_36", getQty36());
		this.hashColumns.put("qty_8", getQty8());
		this.hashColumns.put("qty_24", getQty24());
		this.hashColumns.put("qty_6", getQty6());
		this.hashColumns.put("qty_12", getQty12());
		this.hashColumns.put("qty_1", getQty1());
		this.hashColumns.put("qty_34", getQty34());
		this.hashColumns.put("qty_14", getQty14());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("qty_37", getQty37());
		this.hashColumns.put("qty_23", getQty23());
		this.hashColumns.put("qty_30", getQty30());
		this.hashColumns.put("yard_cd", getYardCd());
		this.hashColumns.put("qty_4", getQty4());
		this.hashColumns.put("qty_17", getQty17());
		this.hashColumns.put("qty_22", getQty22());
		this.hashColumns.put("qty_39", getQty39());
		this.hashColumns.put("qty_16", getQty16());
		this.hashColumns.put("qty_32", getQty32());
		this.hashColumns.put("qty_3", getQty3());
		this.hashColumns.put("qty_20", getQty20());
		this.hashColumns.put("qty_25", getQty25());
		this.hashColumns.put("qty_2", getQty2());
		this.hashColumns.put("qty_28", getQty28());
		this.hashColumns.put("qty_31", getQty31());
		this.hashColumns.put("qty_15", getQty15());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("qty_18", "qty18");
		this.hashFields.put("qty_26", "qty26");
		this.hashFields.put("qty_29", "qty29");
		this.hashFields.put("qty_13", "qty13");
		this.hashFields.put("qty_5", "qty5");
		this.hashFields.put("qty_9", "qty9");
		this.hashFields.put("qty_33", "qty33");
		this.hashFields.put("qty_27", "qty27");
		this.hashFields.put("qty_0", "qty0");
		this.hashFields.put("qty_10", "qty10");
		this.hashFields.put("qty_38", "qty38");
		this.hashFields.put("division", "division");
		this.hashFields.put("total", "total");
		this.hashFields.put("qty_7", "qty7");
		this.hashFields.put("qty_21", "qty21");
		this.hashFields.put("qty_11", "qty11");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("qty_35", "qty35");
		this.hashFields.put("qty_19", "qty19");
		this.hashFields.put("qty_36", "qty36");
		this.hashFields.put("qty_8", "qty8");
		this.hashFields.put("qty_24", "qty24");
		this.hashFields.put("qty_6", "qty6");
		this.hashFields.put("qty_12", "qty12");
		this.hashFields.put("qty_1", "qty1");
		this.hashFields.put("qty_34", "qty34");
		this.hashFields.put("qty_14", "qty14");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("qty_37", "qty37");
		this.hashFields.put("qty_23", "qty23");
		this.hashFields.put("qty_30", "qty30");
		this.hashFields.put("yard_cd", "yardCd");
		this.hashFields.put("qty_4", "qty4");
		this.hashFields.put("qty_17", "qty17");
		this.hashFields.put("qty_22", "qty22");
		this.hashFields.put("qty_39", "qty39");
		this.hashFields.put("qty_16", "qty16");
		this.hashFields.put("qty_32", "qty32");
		this.hashFields.put("qty_3", "qty3");
		this.hashFields.put("qty_20", "qty20");
		this.hashFields.put("qty_25", "qty25");
		this.hashFields.put("qty_2", "qty2");
		this.hashFields.put("qty_28", "qty28");
		this.hashFields.put("qty_31", "qty31");
		this.hashFields.put("qty_15", "qty15");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getQty18() {
		return this.qty18;
	}
	public String getQty26() {
		return this.qty26;
	}
	public String getQty29() {
		return this.qty29;
	}
	public String getQty13() {
		return this.qty13;
	}
	public String getQty5() {
		return this.qty5;
	}
	public String getQty9() {
		return this.qty9;
	}
	public String getQty33() {
		return this.qty33;
	}
	public String getQty27() {
		return this.qty27;
	}
	public String getQty0() {
		return this.qty0;
	}
	public String getQty10() {
		return this.qty10;
	}
	public String getQty38() {
		return this.qty38;
	}
	public String getDivision() {
		return this.division;
	}
	public String getTotal() {
		return this.total;
	}
	public String getQty7() {
		return this.qty7;
	}
	public String getQty21() {
		return this.qty21;
	}
	public String getQty11() {
		return this.qty11;
	}
	public String getLocCd() {
		return this.locCd;
	}
	public String getQty35() {
		return this.qty35;
	}
	public String getQty19() {
		return this.qty19;
	}
	public String getQty36() {
		return this.qty36;
	}
	public String getQty8() {
		return this.qty8;
	}
	public String getQty24() {
		return this.qty24;
	}
	public String getQty6() {
		return this.qty6;
	}
	public String getQty12() {
		return this.qty12;
	}
	public String getQty1() {
		return this.qty1;
	}
	public String getQty34() {
		return this.qty34;
	}
	public String getQty14() {
		return this.qty14;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getQty37() {
		return this.qty37;
	}
	public String getQty23() {
		return this.qty23;
	}
	public String getQty30() {
		return this.qty30;
	}
	public String getYardCd() {
		return this.yardCd;
	}
	public String getQty4() {
		return this.qty4;
	}
	public String getQty17() {
		return this.qty17;
	}
	public String getQty22() {
		return this.qty22;
	}
	public String getQty39() {
		return this.qty39;
	}
	public String getQty16() {
		return this.qty16;
	}
	public String getQty32() {
		return this.qty32;
	}
	public String getQty3() {
		return this.qty3;
	}
	public String getQty20() {
		return this.qty20;
	}
	public String getQty25() {
		return this.qty25;
	}
	public String getQty2() {
		return this.qty2;
	}
	public String getQty28() {
		return this.qty28;
	}
	public String getQty31() {
		return this.qty31;
	}
	public String getQty15() {
		return this.qty15;
	}
	public String getLaneCd() {
		return this.laneCd;
	}
	public String getVvd() {
		return this.vvd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setQty18(String qty18) {
		this.qty18 = qty18;
		//this.qty18=true;
	}
	public void setQty26(String qty26) {
		this.qty26 = qty26;
		//this.qty26=true;
	}
	public void setQty29(String qty29) {
		this.qty29 = qty29;
		//this.qty29=true;
	}
	public void setQty13(String qty13) {
		this.qty13 = qty13;
		//this.qty13=true;
	}
	public void setQty5(String qty5) {
		this.qty5 = qty5;
		//this.qty5=true;
	}
	public void setQty9(String qty9) {
		this.qty9 = qty9;
		//this.qty9=true;
	}
	public void setQty33(String qty33) {
		this.qty33 = qty33;
		//this.qty33=true;
	}
	public void setQty27(String qty27) {
		this.qty27 = qty27;
		//this.qty27=true;
	}
	public void setQty0(String qty0) {
		this.qty0 = qty0;
		//this.qty0=true;
	}
	public void setQty10(String qty10) {
		this.qty10 = qty10;
		//this.qty10=true;
	}
	public void setQty38(String qty38) {
		this.qty38 = qty38;
		//this.qty38=true;
	}
	public void setDivision(String division) {
		this.division = division;
		//this.division=true;
	}
	public void setTotal(String total) {
		this.total = total;
		//this.total=true;
	}
	public void setQty7(String qty7) {
		this.qty7 = qty7;
		//this.qty7=true;
	}
	public void setQty21(String qty21) {
		this.qty21 = qty21;
		//this.qty21=true;
	}
	public void setQty11(String qty11) {
		this.qty11 = qty11;
		//this.qty11=true;
	}
	public void setLocCd(String locCd) {
		this.locCd = locCd;
		//this.locCd=true;
	}
	public void setQty35(String qty35) {
		this.qty35 = qty35;
		//this.qty35=true;
	}
	public void setQty19(String qty19) {
		this.qty19 = qty19;
		//this.qty19=true;
	}
	public void setQty36(String qty36) {
		this.qty36 = qty36;
		//this.qty36=true;
	}
	public void setQty8(String qty8) {
		this.qty8 = qty8;
		//this.qty8=true;
	}
	public void setQty24(String qty24) {
		this.qty24 = qty24;
		//this.qty24=true;
	}
	public void setQty6(String qty6) {
		this.qty6 = qty6;
		//this.qty6=true;
	}
	public void setQty12(String qty12) {
		this.qty12 = qty12;
		//this.qty12=true;
	}
	public void setQty1(String qty1) {
		this.qty1 = qty1;
		//this.qty1=true;
	}
	public void setQty34(String qty34) {
		this.qty34 = qty34;
		//this.qty34=true;
	}
	public void setQty14(String qty14) {
		this.qty14 = qty14;
		//this.qty14=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setQty37(String qty37) {
		this.qty37 = qty37;
		//this.qty37=true;
	}
	public void setQty23(String qty23) {
		this.qty23 = qty23;
		//this.qty23=true;
	}
	public void setQty30(String qty30) {
		this.qty30 = qty30;
		//this.qty30=true;
	}
	public void setYardCd(String yardCd) {
		this.yardCd = yardCd;
		//this.yardCd=true;
	}
	public void setQty4(String qty4) {
		this.qty4 = qty4;
		//this.qty4=true;
	}
	public void setQty17(String qty17) {
		this.qty17 = qty17;
		//this.qty17=true;
	}
	public void setQty22(String qty22) {
		this.qty22 = qty22;
		//this.qty22=true;
	}
	public void setQty39(String qty39) {
		this.qty39 = qty39;
		//this.qty39=true;
	}
	public void setQty16(String qty16) {
		this.qty16 = qty16;
		//this.qty16=true;
	}
	public void setQty32(String qty32) {
		this.qty32 = qty32;
		//this.qty32=true;
	}
	public void setQty3(String qty3) {
		this.qty3 = qty3;
		//this.qty3=true;
	}
	public void setQty20(String qty20) {
		this.qty20 = qty20;
		//this.qty20=true;
	}
	public void setQty25(String qty25) {
		this.qty25 = qty25;
		//this.qty25=true;
	}
	public void setQty2(String qty2) {
		this.qty2 = qty2;
		//this.qty2=true;
	}
	public void setQty28(String qty28) {
		this.qty28 = qty28;
		//this.qty28=true;
	}
	public void setQty31(String qty31) {
		this.qty31 = qty31;
		//this.qty31=true;
	}
	public void setQty15(String qty15) {
		this.qty15 = qty15;
		//this.qty15=true;
	}
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
		//this.lane_cd=true;
	}
	public void setVvd(String vvd) {
		this.vvd = vvd;
		//this.vvd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setQty18(JSPUtil.getParameter(request, "qty_18", ""));
		setQty26(JSPUtil.getParameter(request, "qty_26", ""));
		setQty29(JSPUtil.getParameter(request, "qty_29", ""));
		setQty13(JSPUtil.getParameter(request, "qty_13", ""));
		setQty5(JSPUtil.getParameter(request, "qty_5", ""));
		setQty9(JSPUtil.getParameter(request, "qty_9", ""));
		setQty33(JSPUtil.getParameter(request, "qty_33", ""));
		setQty27(JSPUtil.getParameter(request, "qty_27", ""));
		setQty0(JSPUtil.getParameter(request, "qty_0", ""));
		setQty10(JSPUtil.getParameter(request, "qty_10", ""));
		setQty38(JSPUtil.getParameter(request, "qty_38", ""));
		setDivision(JSPUtil.getParameter(request, "division", ""));
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setQty7(JSPUtil.getParameter(request, "qty_7", ""));
		setQty21(JSPUtil.getParameter(request, "qty_21", ""));
		setQty11(JSPUtil.getParameter(request, "qty_11", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setQty35(JSPUtil.getParameter(request, "qty_35", ""));
		setQty19(JSPUtil.getParameter(request, "qty_19", ""));
		setQty36(JSPUtil.getParameter(request, "qty_36", ""));
		setQty8(JSPUtil.getParameter(request, "qty_8", ""));
		setQty24(JSPUtil.getParameter(request, "qty_24", ""));
		setQty6(JSPUtil.getParameter(request, "qty_6", ""));
		setQty12(JSPUtil.getParameter(request, "qty_12", ""));
		setQty1(JSPUtil.getParameter(request, "qty_1", ""));
		setQty34(JSPUtil.getParameter(request, "qty_34", ""));
		setQty14(JSPUtil.getParameter(request, "qty_14", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setQty37(JSPUtil.getParameter(request, "qty_37", ""));
		setQty23(JSPUtil.getParameter(request, "qty_23", ""));
		setQty30(JSPUtil.getParameter(request, "qty_30", ""));
		setYardCd(JSPUtil.getParameter(request, "yard_cd", ""));
		setQty4(JSPUtil.getParameter(request, "qty_4", ""));
		setQty17(JSPUtil.getParameter(request, "qty_17", ""));
		setQty22(JSPUtil.getParameter(request, "qty_22", ""));
		setQty39(JSPUtil.getParameter(request, "qty_39", ""));
		setQty16(JSPUtil.getParameter(request, "qty_16", ""));
		setQty32(JSPUtil.getParameter(request, "qty_32", ""));
		setQty3(JSPUtil.getParameter(request, "qty_3", ""));
		setQty20(JSPUtil.getParameter(request, "qty_20", ""));
		setQty25(JSPUtil.getParameter(request, "qty_25", ""));
		setQty2(JSPUtil.getParameter(request, "qty_2", ""));
		setQty28(JSPUtil.getParameter(request, "qty_28", ""));
		setQty31(JSPUtil.getParameter(request, "qty_31", ""));
		setQty15(JSPUtil.getParameter(request, "qty_15", ""));
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public QuantityByTypeSizeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public QuantityByTypeSizeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		QuantityByTypeSizeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] qty18 = (JSPUtil.getParameter(request, prefix	+ "qty_18".trim(), length));
			String[] qty26 = (JSPUtil.getParameter(request, prefix	+ "qty_26".trim(), length));
			String[] qty29 = (JSPUtil.getParameter(request, prefix	+ "qty_29".trim(), length));
			String[] qty13 = (JSPUtil.getParameter(request, prefix	+ "qty_13".trim(), length));
			String[] qty5 = (JSPUtil.getParameter(request, prefix	+ "qty_5".trim(), length));
			String[] qty9 = (JSPUtil.getParameter(request, prefix	+ "qty_9".trim(), length));
			String[] qty33 = (JSPUtil.getParameter(request, prefix	+ "qty_33".trim(), length));
			String[] qty27 = (JSPUtil.getParameter(request, prefix	+ "qty_27".trim(), length));
			String[] qty0 = (JSPUtil.getParameter(request, prefix	+ "qty_0".trim(), length));
			String[] qty10 = (JSPUtil.getParameter(request, prefix	+ "qty_10".trim(), length));
			String[] qty38 = (JSPUtil.getParameter(request, prefix	+ "qty_38".trim(), length));
			String[] division = (JSPUtil.getParameter(request, prefix	+ "division".trim(), length));
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total".trim(), length));
			String[] qty7 = (JSPUtil.getParameter(request, prefix	+ "qty_7".trim(), length));
			String[] qty21 = (JSPUtil.getParameter(request, prefix	+ "qty_21".trim(), length));
			String[] qty11 = (JSPUtil.getParameter(request, prefix	+ "qty_11".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] qty35 = (JSPUtil.getParameter(request, prefix	+ "qty_35".trim(), length));
			String[] qty19 = (JSPUtil.getParameter(request, prefix	+ "qty_19".trim(), length));
			String[] qty36 = (JSPUtil.getParameter(request, prefix	+ "qty_36".trim(), length));
			String[] qty8 = (JSPUtil.getParameter(request, prefix	+ "qty_8".trim(), length));
			String[] qty24 = (JSPUtil.getParameter(request, prefix	+ "qty_24".trim(), length));
			String[] qty6 = (JSPUtil.getParameter(request, prefix	+ "qty_6".trim(), length));
			String[] qty12 = (JSPUtil.getParameter(request, prefix	+ "qty_12".trim(), length));
			String[] qty1 = (JSPUtil.getParameter(request, prefix	+ "qty_1".trim(), length));
			String[] qty34 = (JSPUtil.getParameter(request, prefix	+ "qty_34".trim(), length));
			String[] qty14 = (JSPUtil.getParameter(request, prefix	+ "qty_14".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] qty37 = (JSPUtil.getParameter(request, prefix	+ "qty_37".trim(), length));
			String[] qty23 = (JSPUtil.getParameter(request, prefix	+ "qty_23".trim(), length));
			String[] qty30 = (JSPUtil.getParameter(request, prefix	+ "qty_30".trim(), length));
			String[] yardCd = (JSPUtil.getParameter(request, prefix	+ "yard_cd".trim(), length));
			String[] qty4 = (JSPUtil.getParameter(request, prefix	+ "qty_4".trim(), length));
			String[] qty17 = (JSPUtil.getParameter(request, prefix	+ "qty_17".trim(), length));
			String[] qty22 = (JSPUtil.getParameter(request, prefix	+ "qty_22".trim(), length));
			String[] qty39 = (JSPUtil.getParameter(request, prefix	+ "qty_39".trim(), length));
			String[] qty16 = (JSPUtil.getParameter(request, prefix	+ "qty_16".trim(), length));
			String[] qty32 = (JSPUtil.getParameter(request, prefix	+ "qty_32".trim(), length));
			String[] qty3 = (JSPUtil.getParameter(request, prefix	+ "qty_3".trim(), length));
			String[] qty20 = (JSPUtil.getParameter(request, prefix	+ "qty_20".trim(), length));
			String[] qty25 = (JSPUtil.getParameter(request, prefix	+ "qty_25".trim(), length));
			String[] qty2 = (JSPUtil.getParameter(request, prefix	+ "qty_2".trim(), length));
			String[] qty28 = (JSPUtil.getParameter(request, prefix	+ "qty_28".trim(), length));
			String[] qty31 = (JSPUtil.getParameter(request, prefix	+ "qty_31".trim(), length));
			String[] qty15 = (JSPUtil.getParameter(request, prefix	+ "qty_15".trim(), length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new QuantityByTypeSizeVO();
				if (qty18[i] != null)
					model.setQty18(qty18[i]);
				if (qty26[i] != null)
					model.setQty26(qty26[i]);
				if (qty29[i] != null)
					model.setQty29(qty29[i]);
				if (qty13[i] != null)
					model.setQty13(qty13[i]);
				if (qty5[i] != null)
					model.setQty5(qty5[i]);
				if (qty9[i] != null)
					model.setQty9(qty9[i]);
				if (qty33[i] != null)
					model.setQty33(qty33[i]);
				if (qty27[i] != null)
					model.setQty27(qty27[i]);
				if (qty0[i] != null)
					model.setQty0(qty0[i]);
				if (qty10[i] != null)
					model.setQty10(qty10[i]);
				if (qty38[i] != null)
					model.setQty38(qty38[i]);
				if (division[i] != null)
					model.setDivision(division[i]);
				if (total[i] != null)
					model.setTotal(total[i]);
				if (qty7[i] != null)
					model.setQty7(qty7[i]);
				if (qty21[i] != null)
					model.setQty21(qty21[i]);
				if (qty11[i] != null)
					model.setQty11(qty11[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (qty35[i] != null)
					model.setQty35(qty35[i]);
				if (qty19[i] != null)
					model.setQty19(qty19[i]);
				if (qty36[i] != null)
					model.setQty36(qty36[i]);
				if (qty8[i] != null)
					model.setQty8(qty8[i]);
				if (qty24[i] != null)
					model.setQty24(qty24[i]);
				if (qty6[i] != null)
					model.setQty6(qty6[i]);
				if (qty12[i] != null)
					model.setQty12(qty12[i]);
				if (qty1[i] != null)
					model.setQty1(qty1[i]);
				if (qty34[i] != null)
					model.setQty34(qty34[i]);
				if (qty14[i] != null)
					model.setQty14(qty14[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (qty37[i] != null)
					model.setQty37(qty37[i]);
				if (qty23[i] != null)
					model.setQty23(qty23[i]);
				if (qty30[i] != null)
					model.setQty30(qty30[i]);
				if (yardCd[i] != null)
					model.setYardCd(yardCd[i]);
				if (qty4[i] != null)
					model.setQty4(qty4[i]);
				if (qty17[i] != null)
					model.setQty17(qty17[i]);
				if (qty22[i] != null)
					model.setQty22(qty22[i]);
				if (qty39[i] != null)
					model.setQty39(qty39[i]);
				if (qty16[i] != null)
					model.setQty16(qty16[i]);
				if (qty32[i] != null)
					model.setQty32(qty32[i]);
				if (qty3[i] != null)
					model.setQty3(qty3[i]);
				if (qty20[i] != null)
					model.setQty20(qty20[i]);
				if (qty25[i] != null)
					model.setQty25(qty25[i]);
				if (qty2[i] != null)
					model.setQty2(qty2[i]);
				if (qty28[i] != null)
					model.setQty28(qty28[i]);
				if (qty31[i] != null)
					model.setQty31(qty31[i]);
				if (qty15[i] != null)
					model.setQty15(qty15[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getQuantityByTypeSizeVOs();
	}

	public QuantityByTypeSizeVO[] getQuantityByTypeSizeVOs(){
		QuantityByTypeSizeVO[] vos = (QuantityByTypeSizeVO[])models.toArray(new QuantityByTypeSizeVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.qty18 = this.qty18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty26 = this.qty26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty29 = this.qty29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty13 = this.qty13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty5 = this.qty5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty9 = this.qty9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty33 = this.qty33 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty27 = this.qty27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty0 = this.qty0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty10 = this.qty10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty38 = this.qty38 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.division = this.division .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty7 = this.qty7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty21 = this.qty21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty11 = this.qty11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty35 = this.qty35 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty19 = this.qty19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty36 = this.qty36 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty8 = this.qty8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty24 = this.qty24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty6 = this.qty6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty12 = this.qty12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty1 = this.qty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty34 = this.qty34 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty14 = this.qty14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty37 = this.qty37 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty23 = this.qty23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty30 = this.qty30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCd = this.yardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty4 = this.qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty17 = this.qty17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty22 = this.qty22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty39 = this.qty39 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty16 = this.qty16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty32 = this.qty32 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty3 = this.qty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty20 = this.qty20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty25 = this.qty25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty2 = this.qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty28 = this.qty28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty31 = this.qty31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty15 = this.qty15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
