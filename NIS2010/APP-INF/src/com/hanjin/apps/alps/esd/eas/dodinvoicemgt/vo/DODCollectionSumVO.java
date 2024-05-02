/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DODCollectionSumVO.java
*@FileTitle : DODCollectionSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo;

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

public class DODCollectionSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DODCollectionSumVO> models = new ArrayList<DODCollectionSumVO>();
	
	/* Column Info */
	private String t2 = null;
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String p4 = null;
	/* Column Info */
	private String dw = null;
	/* Column Info */
	private String dx = null;
	/* Column Info */
	private String p2 = null;
	/* Column Info */
	private String d9 = null;
	/* Column Info */
	private String d8 = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String d7 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String d2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String a2 = null;
	/* Column Info */
	private String a4 = null;
	/* Column Info */
	private String f2 = null;
	/* Column Info */
	private String f5 = null;
	/* Column Info */
	private String f4 = null;
	/* Column Info */
	private String s4 = null;
	/* Column Info */
	private String o2 = null;
	/* Column Info */
	private String s2 = null;
	/* Column Info */
	private String o4 = null;
	/* Column Info */
	private String o5 = null;
	/* Column Info */
	private String total20 = null;
	/* Column Info */
	private String sumTaxAmt = null;
	/* Column Info */
	private String total40 = null;
	/* Column Info */
	private String t4 = null;
	/* Column Info */
	private String sumInvAmt = null;
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String r4 = null;
	/* Column Info */
	private String r5 = null;
	/* Column Info */
	private String sumBilAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DODCollectionSumVO() {}

	public DODCollectionSumVO(String ibflag, String pagerows, String sumInvAmt, String sumTaxAmt, String totAmt, String d2, String d4, String d5, String d7, String d8, String d9, String dw, String dx, String r2, String r4, String r5, String f2, String f4, String f5, String o2, String o4, String o5, String s2, String s4, String t2, String t4, String a2, String a4, String p2, String p4, String total20, String total40, String sumBilAmt) {
		this.t2 = t2;
		this.totAmt = totAmt;
		this.p4 = p4;
		this.dw = dw;
		this.dx = dx;
		this.p2 = p2;
		this.d9 = d9;
		this.d8 = d8;
		this.d5 = d5;
		this.d4 = d4;
		this.d7 = d7;
		this.pagerows = pagerows;
		this.d2 = d2;
		this.ibflag = ibflag;
		this.a2 = a2;
		this.a4 = a4;
		this.f2 = f2;
		this.f5 = f5;
		this.f4 = f4;
		this.s4 = s4;
		this.o2 = o2;
		this.s2 = s2;
		this.o4 = o4;
		this.o5 = o5;
		this.total20 = total20;
		this.sumTaxAmt = sumTaxAmt;
		this.total40 = total40;
		this.t4 = t4;
		this.sumInvAmt = sumInvAmt;
		this.r2 = r2;
		this.r4 = r4;
		this.r5 = r5;
		this.sumBilAmt = sumBilAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("t2", getT2());
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("p4", getP4());
		this.hashColumns.put("dw", getDw());
		this.hashColumns.put("dx", getDx());
		this.hashColumns.put("p2", getP2());
		this.hashColumns.put("d9", getD9());
		this.hashColumns.put("d8", getD8());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("d7", getD7());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("a2", getA2());
		this.hashColumns.put("a4", getA4());
		this.hashColumns.put("f2", getF2());
		this.hashColumns.put("f5", getF5());
		this.hashColumns.put("f4", getF4());
		this.hashColumns.put("s4", getS4());
		this.hashColumns.put("o2", getO2());
		this.hashColumns.put("s2", getS2());
		this.hashColumns.put("o4", getO4());
		this.hashColumns.put("o5", getO5());
		this.hashColumns.put("total20", getTotal20());
		this.hashColumns.put("sum_tax_amt", getSumTaxAmt());
		this.hashColumns.put("total40", getTotal40());
		this.hashColumns.put("t4", getT4());
		this.hashColumns.put("sum_inv_amt", getSumInvAmt());
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("r4", getR4());
		this.hashColumns.put("r5", getR5());
		this.hashColumns.put("sum_bil_amt", getSumBilAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("t2", "t2");
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("p4", "p4");
		this.hashFields.put("dw", "dw");
		this.hashFields.put("dx", "dx");
		this.hashFields.put("p2", "p2");
		this.hashFields.put("d9", "d9");
		this.hashFields.put("d8", "d8");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("a2", "a2");
		this.hashFields.put("a4", "a4");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("f5", "f5");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("s4", "s4");
		this.hashFields.put("o2", "o2");
		this.hashFields.put("s2", "s2");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("o5", "o5");
		this.hashFields.put("total20", "total20");
		this.hashFields.put("sum_tax_amt", "sumTaxAmt");
		this.hashFields.put("total40", "total40");
		this.hashFields.put("t4", "t4");
		this.hashFields.put("sum_inv_amt", "sumInvAmt");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("r4", "r4");
		this.hashFields.put("r5", "r5");
		this.hashFields.put("sum_bil_amt", "sumBilAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return t2
	 */
	public String getT2() {
		return this.t2;
	}
	
	/**
	 * Column Info
	 * @return totAmt
	 */
	public String getTotAmt() {
		return this.totAmt;
	}
	
	/**
	 * Column Info
	 * @return p4
	 */
	public String getP4() {
		return this.p4;
	}
	
	/**
	 * Column Info
	 * @return dw
	 */
	public String getDw() {
		return this.dw;
	}
	
	/**
	 * Column Info
	 * @return dx
	 */
	public String getDx() {
		return this.dx;
	}
	
	/**
	 * Column Info
	 * @return p2
	 */
	public String getP2() {
		return this.p2;
	}
	
	/**
	 * Column Info
	 * @return d9
	 */
	public String getD9() {
		return this.d9;
	}
	
	/**
	 * Column Info
	 * @return d8
	 */
	public String getD8() {
		return this.d8;
	}
	
	/**
	 * Column Info
	 * @return d5
	 */
	public String getD5() {
		return this.d5;
	}
	
	/**
	 * Column Info
	 * @return d4
	 */
	public String getD4() {
		return this.d4;
	}
	
	/**
	 * Column Info
	 * @return d7
	 */
	public String getD7() {
		return this.d7;
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
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
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
	 * @return a2
	 */
	public String getA2() {
		return this.a2;
	}
	
	/**
	 * Column Info
	 * @return a4
	 */
	public String getA4() {
		return this.a4;
	}
	
	/**
	 * Column Info
	 * @return f2
	 */
	public String getF2() {
		return this.f2;
	}
	
	/**
	 * Column Info
	 * @return f5
	 */
	public String getF5() {
		return this.f5;
	}
	
	/**
	 * Column Info
	 * @return f4
	 */
	public String getF4() {
		return this.f4;
	}
	
	/**
	 * Column Info
	 * @return s4
	 */
	public String getS4() {
		return this.s4;
	}
	
	/**
	 * Column Info
	 * @return o2
	 */
	public String getO2() {
		return this.o2;
	}
	
	/**
	 * Column Info
	 * @return s2
	 */
	public String getS2() {
		return this.s2;
	}
	
	/**
	 * Column Info
	 * @return o4
	 */
	public String getO4() {
		return this.o4;
	}
	
	/**
	 * Column Info
	 * @return o5
	 */
	public String getO5() {
		return this.o5;
	}
	
	/**
	 * Column Info
	 * @return total20
	 */
	public String getTotal20() {
		return this.total20;
	}
	
	/**
	 * Column Info
	 * @return sumTaxAmt
	 */
	public String getSumTaxAmt() {
		return this.sumTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return total40
	 */
	public String getTotal40() {
		return this.total40;
	}
	
	/**
	 * Column Info
	 * @return t4
	 */
	public String getT4() {
		return this.t4;
	}
	
	/**
	 * Column Info
	 * @return sumInvAmt
	 */
	public String getSumInvAmt() {
		return this.sumInvAmt;
	}
	
	/**
	 * Column Info
	 * @return r2
	 */
	public String getR2() {
		return this.r2;
	}
	
	/**
	 * Column Info
	 * @return r4
	 */
	public String getR4() {
		return this.r4;
	}
	
	/**
	 * Column Info
	 * @return r5
	 */
	public String getR5() {
		return this.r5;
	}
	

	public String getSumBilAmt() {
		return sumBilAmt;
	}

	public void setSumBilAmt(String sumBilAmt) {
		this.sumBilAmt = sumBilAmt;
	}

	/**
	 * Column Info
	 * @param t2
	 */
	public void setT2(String t2) {
		this.t2 = t2;
	}
	
	/**
	 * Column Info
	 * @param totAmt
	 */
	public void setTotAmt(String totAmt) {
		this.totAmt = totAmt;
	}
	
	/**
	 * Column Info
	 * @param p4
	 */
	public void setP4(String p4) {
		this.p4 = p4;
	}
	
	/**
	 * Column Info
	 * @param dw
	 */
	public void setDw(String dw) {
		this.dw = dw;
	}
	
	/**
	 * Column Info
	 * @param dx
	 */
	public void setDx(String dx) {
		this.dx = dx;
	}
	
	/**
	 * Column Info
	 * @param p2
	 */
	public void setP2(String p2) {
		this.p2 = p2;
	}
	
	/**
	 * Column Info
	 * @param d9
	 */
	public void setD9(String d9) {
		this.d9 = d9;
	}
	
	/**
	 * Column Info
	 * @param d8
	 */
	public void setD8(String d8) {
		this.d8 = d8;
	}
	
	/**
	 * Column Info
	 * @param d5
	 */
	public void setD5(String d5) {
		this.d5 = d5;
	}
	
	/**
	 * Column Info
	 * @param d4
	 */
	public void setD4(String d4) {
		this.d4 = d4;
	}
	
	/**
	 * Column Info
	 * @param d7
	 */
	public void setD7(String d7) {
		this.d7 = d7;
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
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
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
	 * @param a2
	 */
	public void setA2(String a2) {
		this.a2 = a2;
	}
	
	/**
	 * Column Info
	 * @param a4
	 */
	public void setA4(String a4) {
		this.a4 = a4;
	}
	
	/**
	 * Column Info
	 * @param f2
	 */
	public void setF2(String f2) {
		this.f2 = f2;
	}
	
	/**
	 * Column Info
	 * @param f5
	 */
	public void setF5(String f5) {
		this.f5 = f5;
	}
	
	/**
	 * Column Info
	 * @param f4
	 */
	public void setF4(String f4) {
		this.f4 = f4;
	}
	
	/**
	 * Column Info
	 * @param s4
	 */
	public void setS4(String s4) {
		this.s4 = s4;
	}
	
	/**
	 * Column Info
	 * @param o2
	 */
	public void setO2(String o2) {
		this.o2 = o2;
	}
	
	/**
	 * Column Info
	 * @param s2
	 */
	public void setS2(String s2) {
		this.s2 = s2;
	}
	
	/**
	 * Column Info
	 * @param o4
	 */
	public void setO4(String o4) {
		this.o4 = o4;
	}
	
	/**
	 * Column Info
	 * @param o5
	 */
	public void setO5(String o5) {
		this.o5 = o5;
	}
	
	/**
	 * Column Info
	 * @param total20
	 */
	public void setTotal20(String total20) {
		this.total20 = total20;
	}
	
	/**
	 * Column Info
	 * @param sumTaxAmt
	 */
	public void setSumTaxAmt(String sumTaxAmt) {
		this.sumTaxAmt = sumTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param total40
	 */
	public void setTotal40(String total40) {
		this.total40 = total40;
	}
	
	/**
	 * Column Info
	 * @param t4
	 */
	public void setT4(String t4) {
		this.t4 = t4;
	}
	
	/**
	 * Column Info
	 * @param sumInvAmt
	 */
	public void setSumInvAmt(String sumInvAmt) {
		this.sumInvAmt = sumInvAmt;
	}
	
	/**
	 * Column Info
	 * @param r2
	 */
	public void setR2(String r2) {
		this.r2 = r2;
	}
	
	/**
	 * Column Info
	 * @param r4
	 */
	public void setR4(String r4) {
		this.r4 = r4;
	}
	
	/**
	 * Column Info
	 * @param r5
	 */
	public void setR5(String r5) {
		this.r5 = r5;
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
		setT2(JSPUtil.getParameter(request, prefix + "t2", ""));
		setTotAmt(JSPUtil.getParameter(request, prefix + "tot_amt", ""));
		setP4(JSPUtil.getParameter(request, prefix + "p4", ""));
		setDw(JSPUtil.getParameter(request, prefix + "dw", ""));
		setDx(JSPUtil.getParameter(request, prefix + "dx", ""));
		setP2(JSPUtil.getParameter(request, prefix + "p2", ""));
		setD9(JSPUtil.getParameter(request, prefix + "d9", ""));
		setD8(JSPUtil.getParameter(request, prefix + "d8", ""));
		setD5(JSPUtil.getParameter(request, prefix + "d5", ""));
		setD4(JSPUtil.getParameter(request, prefix + "d4", ""));
		setD7(JSPUtil.getParameter(request, prefix + "d7", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setD2(JSPUtil.getParameter(request, prefix + "d2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setA2(JSPUtil.getParameter(request, prefix + "a2", ""));
		setA4(JSPUtil.getParameter(request, prefix + "a4", ""));
		setF2(JSPUtil.getParameter(request, prefix + "f2", ""));
		setF5(JSPUtil.getParameter(request, prefix + "f5", ""));
		setF4(JSPUtil.getParameter(request, prefix + "f4", ""));
		setS4(JSPUtil.getParameter(request, prefix + "s4", ""));
		setO2(JSPUtil.getParameter(request, prefix + "o2", ""));
		setS2(JSPUtil.getParameter(request, prefix + "s2", ""));
		setO4(JSPUtil.getParameter(request, prefix + "o4", ""));
		setO5(JSPUtil.getParameter(request, prefix + "o5", ""));
		setTotal20(JSPUtil.getParameter(request, prefix + "total20", ""));
		setSumTaxAmt(JSPUtil.getParameter(request, prefix + "sum_tax_amt", ""));
		setTotal40(JSPUtil.getParameter(request, prefix + "total40", ""));
		setT4(JSPUtil.getParameter(request, prefix + "t4", ""));
		setSumInvAmt(JSPUtil.getParameter(request, prefix + "sum_inv_amt", ""));
		setR2(JSPUtil.getParameter(request, prefix + "r2", ""));
		setR4(JSPUtil.getParameter(request, prefix + "r4", ""));
		setR5(JSPUtil.getParameter(request, prefix + "r5", ""));
		setSumBilAmt(JSPUtil.getParameter(request, prefix + "sum_bil_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DODCollectionSumVO[]
	 */
	public DODCollectionSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DODCollectionSumVO[]
	 */
	public DODCollectionSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DODCollectionSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] t2 = (JSPUtil.getParameter(request, prefix	+ "t2", length));
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] p4 = (JSPUtil.getParameter(request, prefix	+ "p4", length));
			String[] dw = (JSPUtil.getParameter(request, prefix	+ "dw", length));
			String[] dx = (JSPUtil.getParameter(request, prefix	+ "dx", length));
			String[] p2 = (JSPUtil.getParameter(request, prefix	+ "p2", length));
			String[] d9 = (JSPUtil.getParameter(request, prefix	+ "d9", length));
			String[] d8 = (JSPUtil.getParameter(request, prefix	+ "d8", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d7", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] a2 = (JSPUtil.getParameter(request, prefix	+ "a2", length));
			String[] a4 = (JSPUtil.getParameter(request, prefix	+ "a4", length));
			String[] f2 = (JSPUtil.getParameter(request, prefix	+ "f2", length));
			String[] f5 = (JSPUtil.getParameter(request, prefix	+ "f5", length));
			String[] f4 = (JSPUtil.getParameter(request, prefix	+ "f4", length));
			String[] s4 = (JSPUtil.getParameter(request, prefix	+ "s4", length));
			String[] o2 = (JSPUtil.getParameter(request, prefix	+ "o2", length));
			String[] s2 = (JSPUtil.getParameter(request, prefix	+ "s2", length));
			String[] o4 = (JSPUtil.getParameter(request, prefix	+ "o4", length));
			String[] o5 = (JSPUtil.getParameter(request, prefix	+ "o5", length));
			String[] total20 = (JSPUtil.getParameter(request, prefix	+ "total20", length));
			String[] sumTaxAmt = (JSPUtil.getParameter(request, prefix	+ "sum_tax_amt", length));
			String[] total40 = (JSPUtil.getParameter(request, prefix	+ "total40", length));
			String[] t4 = (JSPUtil.getParameter(request, prefix	+ "t4", length));
			String[] sumInvAmt = (JSPUtil.getParameter(request, prefix	+ "sum_inv_amt", length));
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2", length));
			String[] r4 = (JSPUtil.getParameter(request, prefix	+ "r4", length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5", length));
			String[] sumBilAmt = (JSPUtil.getParameter(request, prefix	+ "sum_bil_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DODCollectionSumVO();
				if (t2[i] != null)
					model.setT2(t2[i]);
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (p4[i] != null)
					model.setP4(p4[i]);
				if (dw[i] != null)
					model.setDw(dw[i]);
				if (dx[i] != null)
					model.setDx(dx[i]);
				if (p2[i] != null)
					model.setP2(p2[i]);
				if (d9[i] != null)
					model.setD9(d9[i]);
				if (d8[i] != null)
					model.setD8(d8[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (a2[i] != null)
					model.setA2(a2[i]);
				if (a4[i] != null)
					model.setA4(a4[i]);
				if (f2[i] != null)
					model.setF2(f2[i]);
				if (f5[i] != null)
					model.setF5(f5[i]);
				if (f4[i] != null)
					model.setF4(f4[i]);
				if (s4[i] != null)
					model.setS4(s4[i]);
				if (o2[i] != null)
					model.setO2(o2[i]);
				if (s2[i] != null)
					model.setS2(s2[i]);
				if (o4[i] != null)
					model.setO4(o4[i]);
				if (o5[i] != null)
					model.setO5(o5[i]);
				if (total20[i] != null)
					model.setTotal20(total20[i]);
				if (sumTaxAmt[i] != null)
					model.setSumTaxAmt(sumTaxAmt[i]);
				if (total40[i] != null)
					model.setTotal40(total40[i]);
				if (t4[i] != null)
					model.setT4(t4[i]);
				if (sumInvAmt[i] != null)
					model.setSumInvAmt(sumInvAmt[i]);
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (r4[i] != null)
					model.setR4(r4[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				if (sumBilAmt[i] != null)
					model.setSumBilAmt(sumBilAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDODCollectionSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DODCollectionSumVO[]
	 */
	public DODCollectionSumVO[] getDODCollectionSumVOs(){
		DODCollectionSumVO[] vos = (DODCollectionSumVO[])models.toArray(new DODCollectionSumVO[models.size()]);
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
		this.t2 = this.t2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmt = this.totAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p4 = this.p4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dw = this.dw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dx = this.dx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2 = this.p2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d9 = this.d9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d8 = this.d8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2 = this.a2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4 = this.a4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 = this.f2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5 = this.f5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 = this.f4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4 = this.s4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2 = this.o2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2 = this.s2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4 = this.o4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5 = this.o5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total20 = this.total20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTaxAmt = this.sumTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total40 = this.total40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t4 = this.t4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumInvAmt = this.sumInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4 = this.r4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumBilAmt = this.sumBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
