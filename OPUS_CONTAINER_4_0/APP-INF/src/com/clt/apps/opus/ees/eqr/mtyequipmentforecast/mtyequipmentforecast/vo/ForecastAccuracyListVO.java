/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ForecastAccuracyListVO.java
*@FileTitle : ForecastAccuracyListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.12.29 김종준 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ForecastAccuracyListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ForecastAccuracyListVO> models = new ArrayList<ForecastAccuracyListVO>();
	
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String f2Qty = null;
	/* Column Info */
	private String totQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String s2Qty = null;
	/* Column Info */
	private String f5Qty = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String yrwk = null;
	/* Column Info */
	private String d2Qty = null;
	/* Column Info */
	private String o4Qty = null;
	/* Column Info */
	private String a4Qty = null;
	/* Column Info */
	private String eval = null;
	/* Column Info */
	private String a2Qty = null;
	/* Column Info */
	private String factor = null;
	/* Column Info */
	private String d7Qty = null;
	/* Column Info */
	private String s4Qty = null;
	/* Column Info */
	private String r2Qty = null;
	/* Column Info */
	private String o2Qty = null;
	/* Column Info */
	private String viewFlag = null;
	/* Column Info */
	private String d4Qty = null;
	/* Column Info */
	private String r5Qty = null;
	/* Column Info */
	private String d5Qty = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String f4Qty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ForecastAccuracyListVO() {}

	public ForecastAccuracyListVO(String ibflag, String pagerows, String bound, String yrwk, String locCd, String eval, String factor, String dpSeq, String totQty, String d2Qty, String d4Qty, String d5Qty, String d7Qty, String r2Qty, String r5Qty, String o2Qty, String s2Qty, String o4Qty, String s4Qty, String f2Qty, String a2Qty, String f4Qty, String a4Qty, String f5Qty, String viewFlag) {
		this.dpSeq = dpSeq;
		this.f2Qty = f2Qty;
		this.totQty = totQty;
		this.pagerows = pagerows;
		this.s2Qty = s2Qty;
		this.f5Qty = f5Qty;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.yrwk = yrwk;
		this.d2Qty = d2Qty;
		this.o4Qty = o4Qty;
		this.a4Qty = a4Qty;
		this.eval = eval;
		this.a2Qty = a2Qty;
		this.factor = factor;
		this.d7Qty = d7Qty;
		this.s4Qty = s4Qty;
		this.r2Qty = r2Qty;
		this.o2Qty = o2Qty;
		this.viewFlag = viewFlag;
		this.d4Qty = d4Qty;
		this.r5Qty = r5Qty;
		this.d5Qty = d5Qty;
		this.bound = bound;
		this.f4Qty = f4Qty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("f2_qty", getF2Qty());
		this.hashColumns.put("tot_qty", getTotQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s2_qty", getS2Qty());
		this.hashColumns.put("f5_qty", getF5Qty());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yrwk", getYrwk());
		this.hashColumns.put("d2_qty", getD2Qty());
		this.hashColumns.put("o4_qty", getO4Qty());
		this.hashColumns.put("a4_qty", getA4Qty());
		this.hashColumns.put("eval", getEval());
		this.hashColumns.put("a2_qty", getA2Qty());
		this.hashColumns.put("factor", getFactor());
		this.hashColumns.put("d7_qty", getD7Qty());
		this.hashColumns.put("s4_qty", getS4Qty());
		this.hashColumns.put("r2_qty", getR2Qty());
		this.hashColumns.put("o2_qty", getO2Qty());
		this.hashColumns.put("view_flag", getViewFlag());
		this.hashColumns.put("d4_qty", getD4Qty());
		this.hashColumns.put("r5_qty", getR5Qty());
		this.hashColumns.put("d5_qty", getD5Qty());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("f4_qty", getF4Qty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("f2_qty", "f2Qty");
		this.hashFields.put("tot_qty", "totQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s2_qty", "s2Qty");
		this.hashFields.put("f5_qty", "f5Qty");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yrwk", "yrwk");
		this.hashFields.put("d2_qty", "d2Qty");
		this.hashFields.put("o4_qty", "o4Qty");
		this.hashFields.put("a4_qty", "a4Qty");
		this.hashFields.put("eval", "eval");
		this.hashFields.put("a2_qty", "a2Qty");
		this.hashFields.put("factor", "factor");
		this.hashFields.put("d7_qty", "d7Qty");
		this.hashFields.put("s4_qty", "s4Qty");
		this.hashFields.put("r2_qty", "r2Qty");
		this.hashFields.put("o2_qty", "o2Qty");
		this.hashFields.put("view_flag", "viewFlag");
		this.hashFields.put("d4_qty", "d4Qty");
		this.hashFields.put("r5_qty", "r5Qty");
		this.hashFields.put("d5_qty", "d5Qty");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("f4_qty", "f4Qty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return f2Qty
	 */
	public String getF2Qty() {
		return this.f2Qty;
	}
	
	/**
	 * Column Info
	 * @return totQty
	 */
	public String getTotQty() {
		return this.totQty;
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
	 * @return s2Qty
	 */
	public String getS2Qty() {
		return this.s2Qty;
	}
	
	/**
	 * Column Info
	 * @return f5Qty
	 */
	public String getF5Qty() {
		return this.f5Qty;
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
	 * @return yrwk
	 */
	public String getYrwk() {
		return this.yrwk;
	}
	
	/**
	 * Column Info
	 * @return d2Qty
	 */
	public String getD2Qty() {
		return this.d2Qty;
	}
	
	/**
	 * Column Info
	 * @return o4Qty
	 */
	public String getO4Qty() {
		return this.o4Qty;
	}
	
	/**
	 * Column Info
	 * @return a4Qty
	 */
	public String getA4Qty() {
		return this.a4Qty;
	}
	
	/**
	 * Column Info
	 * @return eval
	 */
	public String getEval() {
		return this.eval;
	}
	
	/**
	 * Column Info
	 * @return a2Qty
	 */
	public String getA2Qty() {
		return this.a2Qty;
	}
	
	/**
	 * Column Info
	 * @return factor
	 */
	public String getFactor() {
		return this.factor;
	}
	
	/**
	 * Column Info
	 * @return d7Qty
	 */
	public String getD7Qty() {
		return this.d7Qty;
	}
	
	/**
	 * Column Info
	 * @return s4Qty
	 */
	public String getS4Qty() {
		return this.s4Qty;
	}
	
	/**
	 * Column Info
	 * @return r2Qty
	 */
	public String getR2Qty() {
		return this.r2Qty;
	}
	
	/**
	 * Column Info
	 * @return o2Qty
	 */
	public String getO2Qty() {
		return this.o2Qty;
	}
	
	/**
	 * Column Info
	 * @return viewFlag
	 */
	public String getViewFlag() {
		return this.viewFlag;
	}
	
	/**
	 * Column Info
	 * @return d4Qty
	 */
	public String getD4Qty() {
		return this.d4Qty;
	}
	
	/**
	 * Column Info
	 * @return r5Qty
	 */
	public String getR5Qty() {
		return this.r5Qty;
	}
	
	/**
	 * Column Info
	 * @return d5Qty
	 */
	public String getD5Qty() {
		return this.d5Qty;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	
	/**
	 * Column Info
	 * @return f4Qty
	 */
	public String getF4Qty() {
		return this.f4Qty;
	}
	

	/**
	 * Column Info
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param f2Qty
	 */
	public void setF2Qty(String f2Qty) {
		this.f2Qty = f2Qty;
	}
	
	/**
	 * Column Info
	 * @param totQty
	 */
	public void setTotQty(String totQty) {
		this.totQty = totQty;
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
	 * @param s2Qty
	 */
	public void setS2Qty(String s2Qty) {
		this.s2Qty = s2Qty;
	}
	
	/**
	 * Column Info
	 * @param f5Qty
	 */
	public void setF5Qty(String f5Qty) {
		this.f5Qty = f5Qty;
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
	 * @param yrwk
	 */
	public void setYrwk(String yrwk) {
		this.yrwk = yrwk;
	}
	
	/**
	 * Column Info
	 * @param d2Qty
	 */
	public void setD2Qty(String d2Qty) {
		this.d2Qty = d2Qty;
	}
	
	/**
	 * Column Info
	 * @param o4Qty
	 */
	public void setO4Qty(String o4Qty) {
		this.o4Qty = o4Qty;
	}
	
	/**
	 * Column Info
	 * @param a4Qty
	 */
	public void setA4Qty(String a4Qty) {
		this.a4Qty = a4Qty;
	}
	
	/**
	 * Column Info
	 * @param eval
	 */
	public void setEval(String eval) {
		this.eval = eval;
	}
	
	/**
	 * Column Info
	 * @param a2Qty
	 */
	public void setA2Qty(String a2Qty) {
		this.a2Qty = a2Qty;
	}
	
	/**
	 * Column Info
	 * @param factor
	 */
	public void setFactor(String factor) {
		this.factor = factor;
	}
	
	/**
	 * Column Info
	 * @param d7Qty
	 */
	public void setD7Qty(String d7Qty) {
		this.d7Qty = d7Qty;
	}
	
	/**
	 * Column Info
	 * @param s4Qty
	 */
	public void setS4Qty(String s4Qty) {
		this.s4Qty = s4Qty;
	}
	
	/**
	 * Column Info
	 * @param r2Qty
	 */
	public void setR2Qty(String r2Qty) {
		this.r2Qty = r2Qty;
	}
	
	/**
	 * Column Info
	 * @param o2Qty
	 */
	public void setO2Qty(String o2Qty) {
		this.o2Qty = o2Qty;
	}
	
	/**
	 * Column Info
	 * @param viewFlag
	 */
	public void setViewFlag(String viewFlag) {
		this.viewFlag = viewFlag;
	}
	
	/**
	 * Column Info
	 * @param d4Qty
	 */
	public void setD4Qty(String d4Qty) {
		this.d4Qty = d4Qty;
	}
	
	/**
	 * Column Info
	 * @param r5Qty
	 */
	public void setR5Qty(String r5Qty) {
		this.r5Qty = r5Qty;
	}
	
	/**
	 * Column Info
	 * @param d5Qty
	 */
	public void setD5Qty(String d5Qty) {
		this.d5Qty = d5Qty;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Column Info
	 * @param f4Qty
	 */
	public void setF4Qty(String f4Qty) {
		this.f4Qty = f4Qty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDpSeq(JSPUtil.getParameter(request, "dp_seq", ""));
		setF2Qty(JSPUtil.getParameter(request, "f2_qty", ""));
		setTotQty(JSPUtil.getParameter(request, "tot_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setS2Qty(JSPUtil.getParameter(request, "s2_qty", ""));
		setF5Qty(JSPUtil.getParameter(request, "f5_qty", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYrwk(JSPUtil.getParameter(request, "yrwk", ""));
		setD2Qty(JSPUtil.getParameter(request, "d2_qty", ""));
		setO4Qty(JSPUtil.getParameter(request, "o4_qty", ""));
		setA4Qty(JSPUtil.getParameter(request, "a4_qty", ""));
		setEval(JSPUtil.getParameter(request, "eval", ""));
		setA2Qty(JSPUtil.getParameter(request, "a2_qty", ""));
		setFactor(JSPUtil.getParameter(request, "factor", ""));
		setD7Qty(JSPUtil.getParameter(request, "d7_qty", ""));
		setS4Qty(JSPUtil.getParameter(request, "s4_qty", ""));
		setR2Qty(JSPUtil.getParameter(request, "r2_qty", ""));
		setO2Qty(JSPUtil.getParameter(request, "o2_qty", ""));
		setViewFlag(JSPUtil.getParameter(request, "view_flag", ""));
		setD4Qty(JSPUtil.getParameter(request, "d4_qty", ""));
		setR5Qty(JSPUtil.getParameter(request, "r5_qty", ""));
		setD5Qty(JSPUtil.getParameter(request, "d5_qty", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setF4Qty(JSPUtil.getParameter(request, "f4_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ForecastAccuracyListVO[]
	 */
	public ForecastAccuracyListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ForecastAccuracyListVO[]
	 */
	public ForecastAccuracyListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ForecastAccuracyListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] f2Qty = (JSPUtil.getParameter(request, prefix	+ "f2_qty", length));
			String[] totQty = (JSPUtil.getParameter(request, prefix	+ "tot_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] s2Qty = (JSPUtil.getParameter(request, prefix	+ "s2_qty", length));
			String[] f5Qty = (JSPUtil.getParameter(request, prefix	+ "f5_qty", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] yrwk = (JSPUtil.getParameter(request, prefix	+ "yrwk", length));
			String[] d2Qty = (JSPUtil.getParameter(request, prefix	+ "d2_qty", length));
			String[] o4Qty = (JSPUtil.getParameter(request, prefix	+ "o4_qty", length));
			String[] a4Qty = (JSPUtil.getParameter(request, prefix	+ "a4_qty", length));
			String[] eval = (JSPUtil.getParameter(request, prefix	+ "eval", length));
			String[] a2Qty = (JSPUtil.getParameter(request, prefix	+ "a2_qty", length));
			String[] factor = (JSPUtil.getParameter(request, prefix	+ "factor", length));
			String[] d7Qty = (JSPUtil.getParameter(request, prefix	+ "d7_qty", length));
			String[] s4Qty = (JSPUtil.getParameter(request, prefix	+ "s4_qty", length));
			String[] r2Qty = (JSPUtil.getParameter(request, prefix	+ "r2_qty", length));
			String[] o2Qty = (JSPUtil.getParameter(request, prefix	+ "o2_qty", length));
			String[] viewFlag = (JSPUtil.getParameter(request, prefix	+ "view_flag", length));
			String[] d4Qty = (JSPUtil.getParameter(request, prefix	+ "d4_qty", length));
			String[] r5Qty = (JSPUtil.getParameter(request, prefix	+ "r5_qty", length));
			String[] d5Qty = (JSPUtil.getParameter(request, prefix	+ "d5_qty", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] f4Qty = (JSPUtil.getParameter(request, prefix	+ "f4_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new ForecastAccuracyListVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (f2Qty[i] != null)
					model.setF2Qty(f2Qty[i]);
				if (totQty[i] != null)
					model.setTotQty(totQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (s2Qty[i] != null)
					model.setS2Qty(s2Qty[i]);
				if (f5Qty[i] != null)
					model.setF5Qty(f5Qty[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (yrwk[i] != null)
					model.setYrwk(yrwk[i]);
				if (d2Qty[i] != null)
					model.setD2Qty(d2Qty[i]);
				if (o4Qty[i] != null)
					model.setO4Qty(o4Qty[i]);
				if (a4Qty[i] != null)
					model.setA4Qty(a4Qty[i]);
				if (eval[i] != null)
					model.setEval(eval[i]);
				if (a2Qty[i] != null)
					model.setA2Qty(a2Qty[i]);
				if (factor[i] != null)
					model.setFactor(factor[i]);
				if (d7Qty[i] != null)
					model.setD7Qty(d7Qty[i]);
				if (s4Qty[i] != null)
					model.setS4Qty(s4Qty[i]);
				if (r2Qty[i] != null)
					model.setR2Qty(r2Qty[i]);
				if (o2Qty[i] != null)
					model.setO2Qty(o2Qty[i]);
				if (viewFlag[i] != null)
					model.setViewFlag(viewFlag[i]);
				if (d4Qty[i] != null)
					model.setD4Qty(d4Qty[i]);
				if (r5Qty[i] != null)
					model.setR5Qty(r5Qty[i]);
				if (d5Qty[i] != null)
					model.setD5Qty(d5Qty[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (f4Qty[i] != null)
					model.setF4Qty(f4Qty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getForecastAccuracyListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ForecastAccuracyListVO[]
	 */
	public ForecastAccuracyListVO[] getForecastAccuracyListVOs(){
		ForecastAccuracyListVO[] vos = (ForecastAccuracyListVO[])models.toArray(new ForecastAccuracyListVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2Qty = this.f2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totQty = this.totQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Qty = this.s2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5Qty = this.f5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrwk = this.yrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Qty = this.d2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Qty = this.o4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4Qty = this.a4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eval = this.eval .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2Qty = this.a2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.factor = this.factor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Qty = this.d7Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4Qty = this.s4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Qty = this.r2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Qty = this.o2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewFlag = this.viewFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Qty = this.d4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5Qty = this.r5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Qty = this.d5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4Qty = this.f4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
