/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FlaggingListSmryVO.java
*@FileTitle : FlaggingListSmryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.09.07 김종준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo;

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
 * @author 김종준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FlaggingListSmryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FlaggingListSmryVO> models = new ArrayList<FlaggingListSmryVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String qty11 = null;
	/* Column Info */
	private String qty12 = null;
	/* Column Info */
	private String qty10 = null;
	/* Column Info */
	private String qty19 = null;
	/* Column Info */
	private String qty17 = null;
	/* Column Info */
	private String qty18 = null;
	/* Column Info */
	private String totalQty = null;
	/* Column Info */
	private String qty15 = null;
	/* Column Info */
	private String qty16 = null;
	/* Column Info */
	private String qty13 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String qty14 = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String qty1 = null;
	/* Column Info */
	private String qty3 = null;
	/* Column Info */
	private String qty2 = null;
	/* Column Info */
	private String qty5 = null;
	/* Column Info */
	private String qty4 = null;
	/* Column Info */
	private String qty20 = null;
	/* Column Info */
	private String qty21 = null;
	/* Column Info */
	private String qty22 = null;
	/* Column Info */
	private String qty8 = null;
	/* Column Info */
	private String qty9 = null;
	/* Column Info */
	private String qty6 = null;
	/* Column Info */
	private String flagStatus = null;
	/* Column Info */
	private String qty7 = null;
	/* Column Info */
	private String lvl = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FlaggingListSmryVO() {}

	public FlaggingListSmryVO(String ibflag, String pagerows, String lvl, String locCd, String cnmvStsCd, String flagStatus, String totalQty, String total, String qty1, String qty2, String qty3, String qty4, String qty5, String qty6, String qty7, String qty8, String qty9, String qty10, String qty11, String qty12, String qty13, String qty14, String qty15, String qty16, String qty17, String qty18, String qty19, String qty20, String qty21, String qty22) {
		this.total = total;
		this.qty11 = qty11;
		this.qty12 = qty12;
		this.qty10 = qty10;
		this.qty19 = qty19;
		this.qty17 = qty17;
		this.qty18 = qty18;
		this.totalQty = totalQty;
		this.qty15 = qty15;
		this.qty16 = qty16;
		this.qty13 = qty13;
		this.pagerows = pagerows;
		this.qty14 = qty14;
		this.cnmvStsCd = cnmvStsCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.qty1 = qty1;
		this.qty3 = qty3;
		this.qty2 = qty2;
		this.qty5 = qty5;
		this.qty4 = qty4;
		this.qty20 = qty20;
		this.qty21 = qty21;
		this.qty22 = qty22;
		this.qty8 = qty8;
		this.qty9 = qty9;
		this.qty6 = qty6;
		this.flagStatus = flagStatus;
		this.qty7 = qty7;
		this.lvl = lvl;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("qty11", getQty11());
		this.hashColumns.put("qty12", getQty12());
		this.hashColumns.put("qty10", getQty10());
		this.hashColumns.put("qty19", getQty19());
		this.hashColumns.put("qty17", getQty17());
		this.hashColumns.put("qty18", getQty18());
		this.hashColumns.put("total_qty", getTotalQty());
		this.hashColumns.put("qty15", getQty15());
		this.hashColumns.put("qty16", getQty16());
		this.hashColumns.put("qty13", getQty13());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("qty14", getQty14());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("qty1", getQty1());
		this.hashColumns.put("qty3", getQty3());
		this.hashColumns.put("qty2", getQty2());
		this.hashColumns.put("qty5", getQty5());
		this.hashColumns.put("qty4", getQty4());
		this.hashColumns.put("qty20", getQty20());
		this.hashColumns.put("qty21", getQty21());
		this.hashColumns.put("qty22", getQty22());
		this.hashColumns.put("qty8", getQty8());
		this.hashColumns.put("qty9", getQty9());
		this.hashColumns.put("qty6", getQty6());
		this.hashColumns.put("flag_status", getFlagStatus());
		this.hashColumns.put("qty7", getQty7());
		this.hashColumns.put("lvl", getLvl());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("qty11", "qty11");
		this.hashFields.put("qty12", "qty12");
		this.hashFields.put("qty10", "qty10");
		this.hashFields.put("qty19", "qty19");
		this.hashFields.put("qty17", "qty17");
		this.hashFields.put("qty18", "qty18");
		this.hashFields.put("total_qty", "totalQty");
		this.hashFields.put("qty15", "qty15");
		this.hashFields.put("qty16", "qty16");
		this.hashFields.put("qty13", "qty13");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("qty14", "qty14");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("qty1", "qty1");
		this.hashFields.put("qty3", "qty3");
		this.hashFields.put("qty2", "qty2");
		this.hashFields.put("qty5", "qty5");
		this.hashFields.put("qty4", "qty4");
		this.hashFields.put("qty20", "qty20");
		this.hashFields.put("qty21", "qty21");
		this.hashFields.put("qty22", "qty22");
		this.hashFields.put("qty8", "qty8");
		this.hashFields.put("qty9", "qty9");
		this.hashFields.put("qty6", "qty6");
		this.hashFields.put("flag_status", "flagStatus");
		this.hashFields.put("qty7", "qty7");
		this.hashFields.put("lvl", "lvl");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return qty11
	 */
	public String getQty11() {
		return this.qty11;
	}
	
	/**
	 * Column Info
	 * @return qty12
	 */
	public String getQty12() {
		return this.qty12;
	}
	
	/**
	 * Column Info
	 * @return qty10
	 */
	public String getQty10() {
		return this.qty10;
	}
	
	/**
	 * Column Info
	 * @return qty19
	 */
	public String getQty19() {
		return this.qty19;
	}
	
	/**
	 * Column Info
	 * @return qty17
	 */
	public String getQty17() {
		return this.qty17;
	}
	
	/**
	 * Column Info
	 * @return qty18
	 */
	public String getQty18() {
		return this.qty18;
	}
	
	/**
	 * Column Info
	 * @return totalQty
	 */
	public String getTotalQty() {
		return this.totalQty;
	}
	
	/**
	 * Column Info
	 * @return qty15
	 */
	public String getQty15() {
		return this.qty15;
	}
	
	/**
	 * Column Info
	 * @return qty16
	 */
	public String getQty16() {
		return this.qty16;
	}
	
	/**
	 * Column Info
	 * @return qty13
	 */
	public String getQty13() {
		return this.qty13;
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
	 * @return qty14
	 */
	public String getQty14() {
		return this.qty14;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return qty1
	 */
	public String getQty1() {
		return this.qty1;
	}
	
	/**
	 * Column Info
	 * @return qty3
	 */
	public String getQty3() {
		return this.qty3;
	}
	
	/**
	 * Column Info
	 * @return qty2
	 */
	public String getQty2() {
		return this.qty2;
	}
	
	/**
	 * Column Info
	 * @return qty5
	 */
	public String getQty5() {
		return this.qty5;
	}
	
	/**
	 * Column Info
	 * @return qty4
	 */
	public String getQty4() {
		return this.qty4;
	}
	
	/**
	 * Column Info
	 * @return qty20
	 */
	public String getQty20() {
		return this.qty20;
	}
	
	/**
	 * Column Info
	 * @return qty21
	 */
	public String getQty21() {
		return this.qty21;
	}
	
	/**
	 * Column Info
	 * @return qty22
	 */
	public String getQty22() {
		return this.qty22;
	}
	
	/**
	 * Column Info
	 * @return qty8
	 */
	public String getQty8() {
		return this.qty8;
	}
	
	/**
	 * Column Info
	 * @return qty9
	 */
	public String getQty9() {
		return this.qty9;
	}
	
	/**
	 * Column Info
	 * @return qty6
	 */
	public String getQty6() {
		return this.qty6;
	}
	
	/**
	 * Column Info
	 * @return flagStatus
	 */
	public String getFlagStatus() {
		return this.flagStatus;
	}
	
	/**
	 * Column Info
	 * @return qty7
	 */
	public String getQty7() {
		return this.qty7;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param qty11
	 */
	public void setQty11(String qty11) {
		this.qty11 = qty11;
	}
	
	/**
	 * Column Info
	 * @param qty12
	 */
	public void setQty12(String qty12) {
		this.qty12 = qty12;
	}
	
	/**
	 * Column Info
	 * @param qty10
	 */
	public void setQty10(String qty10) {
		this.qty10 = qty10;
	}
	
	/**
	 * Column Info
	 * @param qty19
	 */
	public void setQty19(String qty19) {
		this.qty19 = qty19;
	}
	
	/**
	 * Column Info
	 * @param qty17
	 */
	public void setQty17(String qty17) {
		this.qty17 = qty17;
	}
	
	/**
	 * Column Info
	 * @param qty18
	 */
	public void setQty18(String qty18) {
		this.qty18 = qty18;
	}
	
	/**
	 * Column Info
	 * @param totalQty
	 */
	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}
	
	/**
	 * Column Info
	 * @param qty15
	 */
	public void setQty15(String qty15) {
		this.qty15 = qty15;
	}
	
	/**
	 * Column Info
	 * @param qty16
	 */
	public void setQty16(String qty16) {
		this.qty16 = qty16;
	}
	
	/**
	 * Column Info
	 * @param qty13
	 */
	public void setQty13(String qty13) {
		this.qty13 = qty13;
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
	 * @param qty14
	 */
	public void setQty14(String qty14) {
		this.qty14 = qty14;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param qty1
	 */
	public void setQty1(String qty1) {
		this.qty1 = qty1;
	}
	
	/**
	 * Column Info
	 * @param qty3
	 */
	public void setQty3(String qty3) {
		this.qty3 = qty3;
	}
	
	/**
	 * Column Info
	 * @param qty2
	 */
	public void setQty2(String qty2) {
		this.qty2 = qty2;
	}
	
	/**
	 * Column Info
	 * @param qty5
	 */
	public void setQty5(String qty5) {
		this.qty5 = qty5;
	}
	
	/**
	 * Column Info
	 * @param qty4
	 */
	public void setQty4(String qty4) {
		this.qty4 = qty4;
	}
	
	/**
	 * Column Info
	 * @param qty20
	 */
	public void setQty20(String qty20) {
		this.qty20 = qty20;
	}
	
	/**
	 * Column Info
	 * @param qty21
	 */
	public void setQty21(String qty21) {
		this.qty21 = qty21;
	}
	
	/**
	 * Column Info
	 * @param qty22
	 */
	public void setQty22(String qty22) {
		this.qty22 = qty22;
	}
	
	/**
	 * Column Info
	 * @param qty8
	 */
	public void setQty8(String qty8) {
		this.qty8 = qty8;
	}
	
	/**
	 * Column Info
	 * @param qty9
	 */
	public void setQty9(String qty9) {
		this.qty9 = qty9;
	}
	
	/**
	 * Column Info
	 * @param qty6
	 */
	public void setQty6(String qty6) {
		this.qty6 = qty6;
	}
	
	/**
	 * Column Info
	 * @param flagStatus
	 */
	public void setFlagStatus(String flagStatus) {
		this.flagStatus = flagStatus;
	}
	
	/**
	 * Column Info
	 * @param qty7
	 */
	public void setQty7(String qty7) {
		this.qty7 = qty7;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setQty11(JSPUtil.getParameter(request, "qty11", ""));
		setQty12(JSPUtil.getParameter(request, "qty12", ""));
		setQty10(JSPUtil.getParameter(request, "qty10", ""));
		setQty19(JSPUtil.getParameter(request, "qty19", ""));
		setQty17(JSPUtil.getParameter(request, "qty17", ""));
		setQty18(JSPUtil.getParameter(request, "qty18", ""));
		setTotalQty(JSPUtil.getParameter(request, "total_qty", ""));
		setQty15(JSPUtil.getParameter(request, "qty15", ""));
		setQty16(JSPUtil.getParameter(request, "qty16", ""));
		setQty13(JSPUtil.getParameter(request, "qty13", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setQty14(JSPUtil.getParameter(request, "qty14", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setQty1(JSPUtil.getParameter(request, "qty1", ""));
		setQty3(JSPUtil.getParameter(request, "qty3", ""));
		setQty2(JSPUtil.getParameter(request, "qty2", ""));
		setQty5(JSPUtil.getParameter(request, "qty5", ""));
		setQty4(JSPUtil.getParameter(request, "qty4", ""));
		setQty20(JSPUtil.getParameter(request, "qty20", ""));
		setQty21(JSPUtil.getParameter(request, "qty21", ""));
		setQty22(JSPUtil.getParameter(request, "qty22", ""));
		setQty8(JSPUtil.getParameter(request, "qty8", ""));
		setQty9(JSPUtil.getParameter(request, "qty9", ""));
		setQty6(JSPUtil.getParameter(request, "qty6", ""));
		setFlagStatus(JSPUtil.getParameter(request, "flag_status", ""));
		setQty7(JSPUtil.getParameter(request, "qty7", ""));
		setLvl(JSPUtil.getParameter(request, "lvl", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FlaggingListSmryVO[]
	 */
	public FlaggingListSmryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FlaggingListSmryVO[]
	 */
	public FlaggingListSmryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FlaggingListSmryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] qty11 = (JSPUtil.getParameter(request, prefix	+ "qty11", length));
			String[] qty12 = (JSPUtil.getParameter(request, prefix	+ "qty12", length));
			String[] qty10 = (JSPUtil.getParameter(request, prefix	+ "qty10", length));
			String[] qty19 = (JSPUtil.getParameter(request, prefix	+ "qty19", length));
			String[] qty17 = (JSPUtil.getParameter(request, prefix	+ "qty17", length));
			String[] qty18 = (JSPUtil.getParameter(request, prefix	+ "qty18", length));
			String[] totalQty = (JSPUtil.getParameter(request, prefix	+ "total_qty", length));
			String[] qty15 = (JSPUtil.getParameter(request, prefix	+ "qty15", length));
			String[] qty16 = (JSPUtil.getParameter(request, prefix	+ "qty16", length));
			String[] qty13 = (JSPUtil.getParameter(request, prefix	+ "qty13", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] qty14 = (JSPUtil.getParameter(request, prefix	+ "qty14", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] qty1 = (JSPUtil.getParameter(request, prefix	+ "qty1", length));
			String[] qty3 = (JSPUtil.getParameter(request, prefix	+ "qty3", length));
			String[] qty2 = (JSPUtil.getParameter(request, prefix	+ "qty2", length));
			String[] qty5 = (JSPUtil.getParameter(request, prefix	+ "qty5", length));
			String[] qty4 = (JSPUtil.getParameter(request, prefix	+ "qty4", length));
			String[] qty20 = (JSPUtil.getParameter(request, prefix	+ "qty20", length));
			String[] qty21 = (JSPUtil.getParameter(request, prefix	+ "qty21", length));
			String[] qty22 = (JSPUtil.getParameter(request, prefix	+ "qty22", length));
			String[] qty8 = (JSPUtil.getParameter(request, prefix	+ "qty8", length));
			String[] qty9 = (JSPUtil.getParameter(request, prefix	+ "qty9", length));
			String[] qty6 = (JSPUtil.getParameter(request, prefix	+ "qty6", length));
			String[] flagStatus = (JSPUtil.getParameter(request, prefix	+ "flag_status", length));
			String[] qty7 = (JSPUtil.getParameter(request, prefix	+ "qty7", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			
			for (int i = 0; i < length; i++) {
				model = new FlaggingListSmryVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (qty11[i] != null)
					model.setQty11(qty11[i]);
				if (qty12[i] != null)
					model.setQty12(qty12[i]);
				if (qty10[i] != null)
					model.setQty10(qty10[i]);
				if (qty19[i] != null)
					model.setQty19(qty19[i]);
				if (qty17[i] != null)
					model.setQty17(qty17[i]);
				if (qty18[i] != null)
					model.setQty18(qty18[i]);
				if (totalQty[i] != null)
					model.setTotalQty(totalQty[i]);
				if (qty15[i] != null)
					model.setQty15(qty15[i]);
				if (qty16[i] != null)
					model.setQty16(qty16[i]);
				if (qty13[i] != null)
					model.setQty13(qty13[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (qty14[i] != null)
					model.setQty14(qty14[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (qty1[i] != null)
					model.setQty1(qty1[i]);
				if (qty3[i] != null)
					model.setQty3(qty3[i]);
				if (qty2[i] != null)
					model.setQty2(qty2[i]);
				if (qty5[i] != null)
					model.setQty5(qty5[i]);
				if (qty4[i] != null)
					model.setQty4(qty4[i]);
				if (qty20[i] != null)
					model.setQty20(qty20[i]);
				if (qty21[i] != null)
					model.setQty21(qty21[i]);
				if (qty22[i] != null)
					model.setQty22(qty22[i]);
				if (qty8[i] != null)
					model.setQty8(qty8[i]);
				if (qty9[i] != null)
					model.setQty9(qty9[i]);
				if (qty6[i] != null)
					model.setQty6(qty6[i]);
				if (flagStatus[i] != null)
					model.setFlagStatus(flagStatus[i]);
				if (qty7[i] != null)
					model.setQty7(qty7[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFlaggingListSmryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FlaggingListSmryVO[]
	 */
	public FlaggingListSmryVO[] getFlaggingListSmryVOs(){
		FlaggingListSmryVO[] vos = (FlaggingListSmryVO[])models.toArray(new FlaggingListSmryVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty11 = this.qty11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty12 = this.qty12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty10 = this.qty10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty19 = this.qty19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty17 = this.qty17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty18 = this.qty18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalQty = this.totalQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty15 = this.qty15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty16 = this.qty16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty13 = this.qty13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty14 = this.qty14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty1 = this.qty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty3 = this.qty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty2 = this.qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty5 = this.qty5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty4 = this.qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty20 = this.qty20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty21 = this.qty21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty22 = this.qty22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty8 = this.qty8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty9 = this.qty9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty6 = this.qty6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flagStatus = this.flagStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty7 = this.qty7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
