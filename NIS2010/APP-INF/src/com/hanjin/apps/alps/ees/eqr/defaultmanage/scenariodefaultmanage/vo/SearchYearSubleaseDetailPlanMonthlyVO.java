/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchYearSubleaseDetailPlanMonthlyVO.java
*@FileTitle : SearchYearSubleaseDetailPlanMonthlyVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           			modifier date    explanation
* 1		1.0		Lee Byoung Hun		2009.07.14		1.0 최초 생성
*
*@LastModifyDate : 2009.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo;

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

public class SearchYearSubleaseDetailPlanMonthlyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchYearSubleaseDetailPlanMonthlyVO> models = new ArrayList<SearchYearSubleaseDetailPlanMonthlyVO>();
	
	/* Column Info */
	private String s28CntrVolQty = null;
	/* Column Info */
	private String s29CntrVolQty = null;
	/* Column Info */
	private String s211CntrVolQty = null;
	/* Column Info */
	private String s24CntrVolQty = null;
	/* Column Info */
	private String s27CntrVolQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String s212CntrVolQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String s21CntrVolQty = null;
	/* Column Info */
	private String s2FmRccCd = null;
	/* Column Info */
	private String s2FmEccCd = null;
	/* Column Info */
	private String s26CntrVolQty = null;
	/* Column Info */
	private String s2ToEccCd = null;
	/* Column Info */
	private String s2DmstRto = null;
	/* Column Info */
	private String s210CntrVolQty = null;
	/* Column Info */
	private String s25CntrVolQty = null;
	/* Column Info */
	private String s22CntrVolQty = null;
	/* Column Info */
	private String s23CntrVolQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchYearSubleaseDetailPlanMonthlyVO() {}

	public SearchYearSubleaseDetailPlanMonthlyVO(String ibflag, String pagerows, String s2FmRccCd, String s2FmEccCd, String s2ToEccCd, String tpsz, String s2DmstRto, String s21CntrVolQty, String s22CntrVolQty, String s23CntrVolQty, String s24CntrVolQty, String s25CntrVolQty, String s26CntrVolQty, String s27CntrVolQty, String s28CntrVolQty, String s29CntrVolQty, String s210CntrVolQty, String s211CntrVolQty, String s212CntrVolQty) {
		this.s28CntrVolQty = s28CntrVolQty;
		this.s29CntrVolQty = s29CntrVolQty;
		this.s211CntrVolQty = s211CntrVolQty;
		this.s24CntrVolQty = s24CntrVolQty;
		this.s27CntrVolQty = s27CntrVolQty;
		this.pagerows = pagerows;
		this.s212CntrVolQty = s212CntrVolQty;
		this.ibflag = ibflag;
		this.tpsz = tpsz;
		this.s21CntrVolQty = s21CntrVolQty;
		this.s2FmRccCd = s2FmRccCd;
		this.s2FmEccCd = s2FmEccCd;
		this.s26CntrVolQty = s26CntrVolQty;
		this.s2ToEccCd = s2ToEccCd;
		this.s2DmstRto = s2DmstRto;
		this.s210CntrVolQty = s210CntrVolQty;
		this.s25CntrVolQty = s25CntrVolQty;
		this.s22CntrVolQty = s22CntrVolQty;
		this.s23CntrVolQty = s23CntrVolQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s2_8_cntr_vol_qty", getS28CntrVolQty());
		this.hashColumns.put("s2_9_cntr_vol_qty", getS29CntrVolQty());
		this.hashColumns.put("s2_11_cntr_vol_qty", getS211CntrVolQty());
		this.hashColumns.put("s2_4_cntr_vol_qty", getS24CntrVolQty());
		this.hashColumns.put("s2_7_cntr_vol_qty", getS27CntrVolQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s2_12_cntr_vol_qty", getS212CntrVolQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("s2_1_cntr_vol_qty", getS21CntrVolQty());
		this.hashColumns.put("s2_fm_rcc_cd", getS2FmRccCd());
		this.hashColumns.put("s2_fm_ecc_cd", getS2FmEccCd());
		this.hashColumns.put("s2_6_cntr_vol_qty", getS26CntrVolQty());
		this.hashColumns.put("s2_to_ecc_cd", getS2ToEccCd());
		this.hashColumns.put("s2_dmst_rto", getS2DmstRto());
		this.hashColumns.put("s2_10_cntr_vol_qty", getS210CntrVolQty());
		this.hashColumns.put("s2_5_cntr_vol_qty", getS25CntrVolQty());
		this.hashColumns.put("s2_2_cntr_vol_qty", getS22CntrVolQty());
		this.hashColumns.put("s2_3_cntr_vol_qty", getS23CntrVolQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s2_8_cntr_vol_qty", "s28CntrVolQty");
		this.hashFields.put("s2_9_cntr_vol_qty", "s29CntrVolQty");
		this.hashFields.put("s2_11_cntr_vol_qty", "s211CntrVolQty");
		this.hashFields.put("s2_4_cntr_vol_qty", "s24CntrVolQty");
		this.hashFields.put("s2_7_cntr_vol_qty", "s27CntrVolQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s2_12_cntr_vol_qty", "s212CntrVolQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("s2_1_cntr_vol_qty", "s21CntrVolQty");
		this.hashFields.put("s2_fm_rcc_cd", "s2FmRccCd");
		this.hashFields.put("s2_fm_ecc_cd", "s2FmEccCd");
		this.hashFields.put("s2_6_cntr_vol_qty", "s26CntrVolQty");
		this.hashFields.put("s2_to_ecc_cd", "s2ToEccCd");
		this.hashFields.put("s2_dmst_rto", "s2DmstRto");
		this.hashFields.put("s2_10_cntr_vol_qty", "s210CntrVolQty");
		this.hashFields.put("s2_5_cntr_vol_qty", "s25CntrVolQty");
		this.hashFields.put("s2_2_cntr_vol_qty", "s22CntrVolQty");
		this.hashFields.put("s2_3_cntr_vol_qty", "s23CntrVolQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return s28CntrVolQty
	 */
	public String getS28CntrVolQty() {
		return this.s28CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s29CntrVolQty
	 */
	public String getS29CntrVolQty() {
		return this.s29CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s211CntrVolQty
	 */
	public String getS211CntrVolQty() {
		return this.s211CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s24CntrVolQty
	 */
	public String getS24CntrVolQty() {
		return this.s24CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s27CntrVolQty
	 */
	public String getS27CntrVolQty() {
		return this.s27CntrVolQty;
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
	 * @return s212CntrVolQty
	 */
	public String getS212CntrVolQty() {
		return this.s212CntrVolQty;
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
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return s21CntrVolQty
	 */
	public String getS21CntrVolQty() {
		return this.s21CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s2FmRccCd
	 */
	public String getS2FmRccCd() {
		return this.s2FmRccCd;
	}
	
	/**
	 * Column Info
	 * @return s2FmEccCd
	 */
	public String getS2FmEccCd() {
		return this.s2FmEccCd;
	}
	
	/**
	 * Column Info
	 * @return s26CntrVolQty
	 */
	public String getS26CntrVolQty() {
		return this.s26CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s2ToEccCd
	 */
	public String getS2ToEccCd() {
		return this.s2ToEccCd;
	}
	
	/**
	 * Column Info
	 * @return s2DmstRto
	 */
	public String getS2DmstRto() {
		return this.s2DmstRto;
	}
	
	/**
	 * Column Info
	 * @return s210CntrVolQty
	 */
	public String getS210CntrVolQty() {
		return this.s210CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s25CntrVolQty
	 */
	public String getS25CntrVolQty() {
		return this.s25CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s22CntrVolQty
	 */
	public String getS22CntrVolQty() {
		return this.s22CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s23CntrVolQty
	 */
	public String getS23CntrVolQty() {
		return this.s23CntrVolQty;
	}
	

	/**
	 * Column Info
	 * @param s28CntrVolQty
	 */
	public void setS28CntrVolQty(String s28CntrVolQty) {
		this.s28CntrVolQty = s28CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s29CntrVolQty
	 */
	public void setS29CntrVolQty(String s29CntrVolQty) {
		this.s29CntrVolQty = s29CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s211CntrVolQty
	 */
	public void setS211CntrVolQty(String s211CntrVolQty) {
		this.s211CntrVolQty = s211CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s24CntrVolQty
	 */
	public void setS24CntrVolQty(String s24CntrVolQty) {
		this.s24CntrVolQty = s24CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s27CntrVolQty
	 */
	public void setS27CntrVolQty(String s27CntrVolQty) {
		this.s27CntrVolQty = s27CntrVolQty;
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
	 * @param s212CntrVolQty
	 */
	public void setS212CntrVolQty(String s212CntrVolQty) {
		this.s212CntrVolQty = s212CntrVolQty;
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
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param s21CntrVolQty
	 */
	public void setS21CntrVolQty(String s21CntrVolQty) {
		this.s21CntrVolQty = s21CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s2FmRccCd
	 */
	public void setS2FmRccCd(String s2FmRccCd) {
		this.s2FmRccCd = s2FmRccCd;
	}
	
	/**
	 * Column Info
	 * @param s2FmEccCd
	 */
	public void setS2FmEccCd(String s2FmEccCd) {
		this.s2FmEccCd = s2FmEccCd;
	}
	
	/**
	 * Column Info
	 * @param s26CntrVolQty
	 */
	public void setS26CntrVolQty(String s26CntrVolQty) {
		this.s26CntrVolQty = s26CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s2ToEccCd
	 */
	public void setS2ToEccCd(String s2ToEccCd) {
		this.s2ToEccCd = s2ToEccCd;
	}
	
	/**
	 * Column Info
	 * @param s2DmstRto
	 */
	public void setS2DmstRto(String s2DmstRto) {
		this.s2DmstRto = s2DmstRto;
	}
	
	/**
	 * Column Info
	 * @param s210CntrVolQty
	 */
	public void setS210CntrVolQty(String s210CntrVolQty) {
		this.s210CntrVolQty = s210CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s25CntrVolQty
	 */
	public void setS25CntrVolQty(String s25CntrVolQty) {
		this.s25CntrVolQty = s25CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s22CntrVolQty
	 */
	public void setS22CntrVolQty(String s22CntrVolQty) {
		this.s22CntrVolQty = s22CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s23CntrVolQty
	 */
	public void setS23CntrVolQty(String s23CntrVolQty) {
		this.s23CntrVolQty = s23CntrVolQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setS28CntrVolQty(JSPUtil.getParameter(request, "s2_8_cntr_vol_qty", ""));
		setS29CntrVolQty(JSPUtil.getParameter(request, "s2_9_cntr_vol_qty", ""));
		setS211CntrVolQty(JSPUtil.getParameter(request, "s2_11_cntr_vol_qty", ""));
		setS24CntrVolQty(JSPUtil.getParameter(request, "s2_4_cntr_vol_qty", ""));
		setS27CntrVolQty(JSPUtil.getParameter(request, "s2_7_cntr_vol_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setS212CntrVolQty(JSPUtil.getParameter(request, "s2_12_cntr_vol_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTpsz(JSPUtil.getParameter(request, "tpsz", ""));
		setS21CntrVolQty(JSPUtil.getParameter(request, "s2_1_cntr_vol_qty", ""));
		setS2FmRccCd(JSPUtil.getParameter(request, "s2_fm_rcc_cd", ""));
		setS2FmEccCd(JSPUtil.getParameter(request, "s2_fm_ecc_cd", ""));
		setS26CntrVolQty(JSPUtil.getParameter(request, "s2_6_cntr_vol_qty", ""));
		setS2ToEccCd(JSPUtil.getParameter(request, "s2_to_ecc_cd", ""));
		setS2DmstRto(JSPUtil.getParameter(request, "s2_dmst_rto", ""));
		setS210CntrVolQty(JSPUtil.getParameter(request, "s2_10_cntr_vol_qty", ""));
		setS25CntrVolQty(JSPUtil.getParameter(request, "s2_5_cntr_vol_qty", ""));
		setS22CntrVolQty(JSPUtil.getParameter(request, "s2_2_cntr_vol_qty", ""));
		setS23CntrVolQty(JSPUtil.getParameter(request, "s2_3_cntr_vol_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchYearSubleaseDetailPlanMonthlyVO[]
	 */
	public SearchYearSubleaseDetailPlanMonthlyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchYearSubleaseDetailPlanMonthlyVO[]
	 */
	public SearchYearSubleaseDetailPlanMonthlyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchYearSubleaseDetailPlanMonthlyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] s28CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s2_8_cntr_vol_qty", length));
			String[] s29CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s2_9_cntr_vol_qty", length));
			String[] s211CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s2_11_cntr_vol_qty", length));
			String[] s24CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s2_4_cntr_vol_qty", length));
			String[] s27CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s2_7_cntr_vol_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] s212CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s2_12_cntr_vol_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] s21CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s2_1_cntr_vol_qty", length));
			String[] s2FmRccCd = (JSPUtil.getParameter(request, prefix	+ "s2_fm_rcc_cd", length));
			String[] s2FmEccCd = (JSPUtil.getParameter(request, prefix	+ "s2_fm_ecc_cd", length));
			String[] s26CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s2_6_cntr_vol_qty", length));
			String[] s2ToEccCd = (JSPUtil.getParameter(request, prefix	+ "s2_to_ecc_cd", length));
			String[] s2DmstRto = (JSPUtil.getParameter(request, prefix	+ "s2_dmst_rto", length));
			String[] s210CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s2_10_cntr_vol_qty", length));
			String[] s25CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s2_5_cntr_vol_qty", length));
			String[] s22CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s2_2_cntr_vol_qty", length));
			String[] s23CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s2_3_cntr_vol_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchYearSubleaseDetailPlanMonthlyVO();
				if (s28CntrVolQty[i] != null)
					model.setS28CntrVolQty(s28CntrVolQty[i]);
				if (s29CntrVolQty[i] != null)
					model.setS29CntrVolQty(s29CntrVolQty[i]);
				if (s211CntrVolQty[i] != null)
					model.setS211CntrVolQty(s211CntrVolQty[i]);
				if (s24CntrVolQty[i] != null)
					model.setS24CntrVolQty(s24CntrVolQty[i]);
				if (s27CntrVolQty[i] != null)
					model.setS27CntrVolQty(s27CntrVolQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (s212CntrVolQty[i] != null)
					model.setS212CntrVolQty(s212CntrVolQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (s21CntrVolQty[i] != null)
					model.setS21CntrVolQty(s21CntrVolQty[i]);
				if (s2FmRccCd[i] != null)
					model.setS2FmRccCd(s2FmRccCd[i]);
				if (s2FmEccCd[i] != null)
					model.setS2FmEccCd(s2FmEccCd[i]);
				if (s26CntrVolQty[i] != null)
					model.setS26CntrVolQty(s26CntrVolQty[i]);
				if (s2ToEccCd[i] != null)
					model.setS2ToEccCd(s2ToEccCd[i]);
				if (s2DmstRto[i] != null)
					model.setS2DmstRto(s2DmstRto[i]);
				if (s210CntrVolQty[i] != null)
					model.setS210CntrVolQty(s210CntrVolQty[i]);
				if (s25CntrVolQty[i] != null)
					model.setS25CntrVolQty(s25CntrVolQty[i]);
				if (s22CntrVolQty[i] != null)
					model.setS22CntrVolQty(s22CntrVolQty[i]);
				if (s23CntrVolQty[i] != null)
					model.setS23CntrVolQty(s23CntrVolQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchYearSubleaseDetailPlanMonthlyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchYearSubleaseDetailPlanMonthlyVO[]
	 */
	public SearchYearSubleaseDetailPlanMonthlyVO[] getSearchYearSubleaseDetailPlanMonthlyVOs(){
		SearchYearSubleaseDetailPlanMonthlyVO[] vos = (SearchYearSubleaseDetailPlanMonthlyVO[])models.toArray(new SearchYearSubleaseDetailPlanMonthlyVO[models.size()]);
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
		this.s28CntrVolQty = this.s28CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s29CntrVolQty = this.s29CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s211CntrVolQty = this.s211CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s24CntrVolQty = this.s24CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s27CntrVolQty = this.s27CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s212CntrVolQty = this.s212CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s21CntrVolQty = this.s21CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2FmRccCd = this.s2FmRccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2FmEccCd = this.s2FmEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s26CntrVolQty = this.s26CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2ToEccCd = this.s2ToEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2DmstRto = this.s2DmstRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s210CntrVolQty = this.s210CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s25CntrVolQty = this.s25CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s22CntrVolQty = this.s22CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s23CntrVolQty = this.s23CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
