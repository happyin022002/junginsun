/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProcurementYearMonthGrpVO.java
*@FileTitle : ProcurementYearMonthGrpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.07.24 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ProcurementYearMonthGrpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ProcurementYearMonthGrpVO> models = new ArrayList<ProcurementYearMonthGrpVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String n1 = null;
	/* Column Info */
	private String n5 = null;
	/* Column Info */
	private String n4 = null;
	/* Column Info */
	private String n3 = null;
	/* Column Info */
	private String n2 = null;
	/* Column Info */
	private String n9 = null;
	/* Column Info */
	private String tpNm = null;
	/* Column Info */
	private String n8 = null;
	/* Column Info */
	private String n7 = null;
	/* Column Info */
	private String n6 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpLev = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String m12 = null;
	/* Column Info */
	private String m10 = null;
	/* Column Info */
	private String m11 = null;
	/* Column Info */
	private String m9 = null;
	/* Column Info */
	private String n10 = null;
	/* Column Info */
	private String n12 = null;
	/* Column Info */
	private String n11 = null;
	/* Column Info */
	private String m7 = null;
	/* Column Info */
	private String m8 = null;
	/* Column Info */
	private String tpszLev = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ProcurementYearMonthGrpVO() {}

	public ProcurementYearMonthGrpVO(String ibflag, String pagerows, String plnYr, String tpszLev, String cntrTpszCd, String tpLev, String tpNm, String m7, String m8, String m9, String m10, String m11, String m12, String n1, String n2, String n3, String n4, String n5, String n6, String n7, String n8, String n9, String n10, String n11, String n12, String total) {
		this.total = total;
		this.n1 = n1;
		this.n5 = n5;
		this.n4 = n4;
		this.n3 = n3;
		this.n2 = n2;
		this.n9 = n9;
		this.tpNm = tpNm;
		this.n8 = n8;
		this.n7 = n7;
		this.n6 = n6;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.tpLev = tpLev;
		this.plnYr = plnYr;
		this.cntrTpszCd = cntrTpszCd;
		this.m12 = m12;
		this.m10 = m10;
		this.m11 = m11;
		this.m9 = m9;
		this.n10 = n10;
		this.n12 = n12;
		this.n11 = n11;
		this.m7 = m7;
		this.m8 = m8;
		this.tpszLev = tpszLev;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("n1", getN1());
		this.hashColumns.put("n5", getN5());
		this.hashColumns.put("n4", getN4());
		this.hashColumns.put("n3", getN3());
		this.hashColumns.put("n2", getN2());
		this.hashColumns.put("n9", getN9());
		this.hashColumns.put("tp_nm", getTpNm());
		this.hashColumns.put("n8", getN8());
		this.hashColumns.put("n7", getN7());
		this.hashColumns.put("n6", getN6());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tp_lev", getTpLev());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("m12", getM12());
		this.hashColumns.put("m10", getM10());
		this.hashColumns.put("m11", getM11());
		this.hashColumns.put("m9", getM9());
		this.hashColumns.put("n10", getN10());
		this.hashColumns.put("n12", getN12());
		this.hashColumns.put("n11", getN11());
		this.hashColumns.put("m7", getM7());
		this.hashColumns.put("m8", getM8());
		this.hashColumns.put("tpsz_lev", getTpszLev());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("n1", "n1");
		this.hashFields.put("n5", "n5");
		this.hashFields.put("n4", "n4");
		this.hashFields.put("n3", "n3");
		this.hashFields.put("n2", "n2");
		this.hashFields.put("n9", "n9");
		this.hashFields.put("tp_nm", "tpNm");
		this.hashFields.put("n8", "n8");
		this.hashFields.put("n7", "n7");
		this.hashFields.put("n6", "n6");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tp_lev", "tpLev");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("m12", "m12");
		this.hashFields.put("m10", "m10");
		this.hashFields.put("m11", "m11");
		this.hashFields.put("m9", "m9");
		this.hashFields.put("n10", "n10");
		this.hashFields.put("n12", "n12");
		this.hashFields.put("n11", "n11");
		this.hashFields.put("m7", "m7");
		this.hashFields.put("m8", "m8");
		this.hashFields.put("tpsz_lev", "tpszLev");
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
	 * @return n1
	 */
	public String getN1() {
		return this.n1;
	}
	
	/**
	 * Column Info
	 * @return n5
	 */
	public String getN5() {
		return this.n5;
	}
	
	/**
	 * Column Info
	 * @return n4
	 */
	public String getN4() {
		return this.n4;
	}
	
	/**
	 * Column Info
	 * @return n3
	 */
	public String getN3() {
		return this.n3;
	}
	
	/**
	 * Column Info
	 * @return n2
	 */
	public String getN2() {
		return this.n2;
	}
	
	/**
	 * Column Info
	 * @return n9
	 */
	public String getN9() {
		return this.n9;
	}
	
	/**
	 * Column Info
	 * @return tpNm
	 */
	public String getTpNm() {
		return this.tpNm;
	}
	
	/**
	 * Column Info
	 * @return n8
	 */
	public String getN8() {
		return this.n8;
	}
	
	/**
	 * Column Info
	 * @return n7
	 */
	public String getN7() {
		return this.n7;
	}
	
	/**
	 * Column Info
	 * @return n6
	 */
	public String getN6() {
		return this.n6;
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
	 * @return tpLev
	 */
	public String getTpLev() {
		return this.tpLev;
	}
	
	/**
	 * Column Info
	 * @return plnYr
	 */
	public String getPlnYr() {
		return this.plnYr;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return m12
	 */
	public String getM12() {
		return this.m12;
	}
	
	/**
	 * Column Info
	 * @return m10
	 */
	public String getM10() {
		return this.m10;
	}
	
	/**
	 * Column Info
	 * @return m11
	 */
	public String getM11() {
		return this.m11;
	}
	
	/**
	 * Column Info
	 * @return m9
	 */
	public String getM9() {
		return this.m9;
	}
	
	/**
	 * Column Info
	 * @return n10
	 */
	public String getN10() {
		return this.n10;
	}
	
	/**
	 * Column Info
	 * @return n12
	 */
	public String getN12() {
		return this.n12;
	}
	
	/**
	 * Column Info
	 * @return n11
	 */
	public String getN11() {
		return this.n11;
	}
	
	/**
	 * Column Info
	 * @return m7
	 */
	public String getM7() {
		return this.m7;
	}
	
	/**
	 * Column Info
	 * @return m8
	 */
	public String getM8() {
		return this.m8;
	}
	
	/**
	 * Column Info
	 * @return tpszLev
	 */
	public String getTpszLev() {
		return this.tpszLev;
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
	 * @param n1
	 */
	public void setN1(String n1) {
		this.n1 = n1;
	}
	
	/**
	 * Column Info
	 * @param n5
	 */
	public void setN5(String n5) {
		this.n5 = n5;
	}
	
	/**
	 * Column Info
	 * @param n4
	 */
	public void setN4(String n4) {
		this.n4 = n4;
	}
	
	/**
	 * Column Info
	 * @param n3
	 */
	public void setN3(String n3) {
		this.n3 = n3;
	}
	
	/**
	 * Column Info
	 * @param n2
	 */
	public void setN2(String n2) {
		this.n2 = n2;
	}
	
	/**
	 * Column Info
	 * @param n9
	 */
	public void setN9(String n9) {
		this.n9 = n9;
	}
	
	/**
	 * Column Info
	 * @param tpNm
	 */
	public void setTpNm(String tpNm) {
		this.tpNm = tpNm;
	}
	
	/**
	 * Column Info
	 * @param n8
	 */
	public void setN8(String n8) {
		this.n8 = n8;
	}
	
	/**
	 * Column Info
	 * @param n7
	 */
	public void setN7(String n7) {
		this.n7 = n7;
	}
	
	/**
	 * Column Info
	 * @param n6
	 */
	public void setN6(String n6) {
		this.n6 = n6;
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
	 * @param tpLev
	 */
	public void setTpLev(String tpLev) {
		this.tpLev = tpLev;
	}
	
	/**
	 * Column Info
	 * @param plnYr
	 */
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param m12
	 */
	public void setM12(String m12) {
		this.m12 = m12;
	}
	
	/**
	 * Column Info
	 * @param m10
	 */
	public void setM10(String m10) {
		this.m10 = m10;
	}
	
	/**
	 * Column Info
	 * @param m11
	 */
	public void setM11(String m11) {
		this.m11 = m11;
	}
	
	/**
	 * Column Info
	 * @param m9
	 */
	public void setM9(String m9) {
		this.m9 = m9;
	}
	
	/**
	 * Column Info
	 * @param n10
	 */
	public void setN10(String n10) {
		this.n10 = n10;
	}
	
	/**
	 * Column Info
	 * @param n12
	 */
	public void setN12(String n12) {
		this.n12 = n12;
	}
	
	/**
	 * Column Info
	 * @param n11
	 */
	public void setN11(String n11) {
		this.n11 = n11;
	}
	
	/**
	 * Column Info
	 * @param m7
	 */
	public void setM7(String m7) {
		this.m7 = m7;
	}
	
	/**
	 * Column Info
	 * @param m8
	 */
	public void setM8(String m8) {
		this.m8 = m8;
	}
	
	/**
	 * Column Info
	 * @param tpszLev
	 */
	public void setTpszLev(String tpszLev) {
		this.tpszLev = tpszLev;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setN1(JSPUtil.getParameter(request, "n1", ""));
		setN5(JSPUtil.getParameter(request, "n5", ""));
		setN4(JSPUtil.getParameter(request, "n4", ""));
		setN3(JSPUtil.getParameter(request, "n3", ""));
		setN2(JSPUtil.getParameter(request, "n2", ""));
		setN9(JSPUtil.getParameter(request, "n9", ""));
		setTpNm(JSPUtil.getParameter(request, "tp_nm", ""));
		setN8(JSPUtil.getParameter(request, "n8", ""));
		setN7(JSPUtil.getParameter(request, "n7", ""));
		setN6(JSPUtil.getParameter(request, "n6", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTpLev(JSPUtil.getParameter(request, "tp_lev", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setM12(JSPUtil.getParameter(request, "m12", ""));
		setM10(JSPUtil.getParameter(request, "m10", ""));
		setM11(JSPUtil.getParameter(request, "m11", ""));
		setM9(JSPUtil.getParameter(request, "m9", ""));
		setN10(JSPUtil.getParameter(request, "n10", ""));
		setN12(JSPUtil.getParameter(request, "n12", ""));
		setN11(JSPUtil.getParameter(request, "n11", ""));
		setM7(JSPUtil.getParameter(request, "m7", ""));
		setM8(JSPUtil.getParameter(request, "m8", ""));
		setTpszLev(JSPUtil.getParameter(request, "tpsz_lev", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ProcurementYearMonthGrpVO[]
	 */
	public ProcurementYearMonthGrpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ProcurementYearMonthGrpVO[]
	 */
	public ProcurementYearMonthGrpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ProcurementYearMonthGrpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] n1 = (JSPUtil.getParameter(request, prefix	+ "n1", length));
			String[] n5 = (JSPUtil.getParameter(request, prefix	+ "n5", length));
			String[] n4 = (JSPUtil.getParameter(request, prefix	+ "n4", length));
			String[] n3 = (JSPUtil.getParameter(request, prefix	+ "n3", length));
			String[] n2 = (JSPUtil.getParameter(request, prefix	+ "n2", length));
			String[] n9 = (JSPUtil.getParameter(request, prefix	+ "n9", length));
			String[] tpNm = (JSPUtil.getParameter(request, prefix	+ "tp_nm", length));
			String[] n8 = (JSPUtil.getParameter(request, prefix	+ "n8", length));
			String[] n7 = (JSPUtil.getParameter(request, prefix	+ "n7", length));
			String[] n6 = (JSPUtil.getParameter(request, prefix	+ "n6", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpLev = (JSPUtil.getParameter(request, prefix	+ "tp_lev", length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] m12 = (JSPUtil.getParameter(request, prefix	+ "m12", length));
			String[] m10 = (JSPUtil.getParameter(request, prefix	+ "m10", length));
			String[] m11 = (JSPUtil.getParameter(request, prefix	+ "m11", length));
			String[] m9 = (JSPUtil.getParameter(request, prefix	+ "m9", length));
			String[] n10 = (JSPUtil.getParameter(request, prefix	+ "n10", length));
			String[] n12 = (JSPUtil.getParameter(request, prefix	+ "n12", length));
			String[] n11 = (JSPUtil.getParameter(request, prefix	+ "n11", length));
			String[] m7 = (JSPUtil.getParameter(request, prefix	+ "m7", length));
			String[] m8 = (JSPUtil.getParameter(request, prefix	+ "m8", length));
			String[] tpszLev = (JSPUtil.getParameter(request, prefix	+ "tpsz_lev", length));
			
			for (int i = 0; i < length; i++) {
				model = new ProcurementYearMonthGrpVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (n1[i] != null)
					model.setN1(n1[i]);
				if (n5[i] != null)
					model.setN5(n5[i]);
				if (n4[i] != null)
					model.setN4(n4[i]);
				if (n3[i] != null)
					model.setN3(n3[i]);
				if (n2[i] != null)
					model.setN2(n2[i]);
				if (n9[i] != null)
					model.setN9(n9[i]);
				if (tpNm[i] != null)
					model.setTpNm(tpNm[i]);
				if (n8[i] != null)
					model.setN8(n8[i]);
				if (n7[i] != null)
					model.setN7(n7[i]);
				if (n6[i] != null)
					model.setN6(n6[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpLev[i] != null)
					model.setTpLev(tpLev[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (m12[i] != null)
					model.setM12(m12[i]);
				if (m10[i] != null)
					model.setM10(m10[i]);
				if (m11[i] != null)
					model.setM11(m11[i]);
				if (m9[i] != null)
					model.setM9(m9[i]);
				if (n10[i] != null)
					model.setN10(n10[i]);
				if (n12[i] != null)
					model.setN12(n12[i]);
				if (n11[i] != null)
					model.setN11(n11[i]);
				if (m7[i] != null)
					model.setM7(m7[i]);
				if (m8[i] != null)
					model.setM8(m8[i]);
				if (tpszLev[i] != null)
					model.setTpszLev(tpszLev[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getProcurementYearMonthGrpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ProcurementYearMonthGrpVO[]
	 */
	public ProcurementYearMonthGrpVO[] getProcurementYearMonthGrpVOs(){
		ProcurementYearMonthGrpVO[] vos = (ProcurementYearMonthGrpVO[])models.toArray(new ProcurementYearMonthGrpVO[models.size()]);
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
		this.n1 = this.n1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5 = this.n5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4 = this.n4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3 = this.n3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2 = this.n2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n9 = this.n9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpNm = this.tpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n8 = this.n8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n7 = this.n7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6 = this.n6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpLev = this.tpLev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.m12 = this.m12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.m10 = this.m10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.m11 = this.m11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.m9 = this.m9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n10 = this.n10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n12 = this.n12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n11 = this.n11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.m7 = this.m7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.m8 = this.m8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszLev = this.tpszLev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
