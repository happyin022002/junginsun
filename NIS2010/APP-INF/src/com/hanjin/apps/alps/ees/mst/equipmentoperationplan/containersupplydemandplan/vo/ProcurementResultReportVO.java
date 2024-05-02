/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProcurementResultReportVO.java
*@FileTitle : ProcurementResultReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.07.10 민정호 
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

public class ProcurementResultReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ProcurementResultReportVO> models = new ArrayList<ProcurementResultReportVO>();
	
	/* Column Info */
	private String d3Qty = null;
	/* Column Info */
	private String lev = null;
	/* Column Info */
	private String f2Qty = null;
	/* Column Info */
	private String gTtl = null;
	/* Column Info */
	private String tpNm = null;
	/* Column Info */
	private String d7Qty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String r2Qty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String num = null;
	/* Column Info */
	private String o2Qty = null;
	/* Column Info */
	private String d4Qty = null;
	/* Column Info */
	private String r5Qty = null;
	/* Column Info */
	private String d2Qty = null;
	/* Column Info */
	private String d5Qty = null;
	/* Column Info */
	private String leaseTerm = null;
	/* Column Info */
	private String o4Qty = null;
	/* Column Info */
	private String f4Qty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ProcurementResultReportVO() {}

	public ProcurementResultReportVO(String ibflag, String pagerows, String num, String lev, String tpNm, String leaseTerm, String d2Qty, String d3Qty, String d4Qty, String d5Qty, String d7Qty, String r2Qty, String r5Qty, String f2Qty, String f4Qty, String o2Qty, String o4Qty, String gTtl) {
		this.d3Qty = d3Qty;
		this.lev = lev;
		this.f2Qty = f2Qty;
		this.gTtl = gTtl;
		this.tpNm = tpNm;
		this.d7Qty = d7Qty;
		this.pagerows = pagerows;
		this.r2Qty = r2Qty;
		this.ibflag = ibflag;
		this.num = num;
		this.o2Qty = o2Qty;
		this.d4Qty = d4Qty;
		this.r5Qty = r5Qty;
		this.d2Qty = d2Qty;
		this.d5Qty = d5Qty;
		this.leaseTerm = leaseTerm;
		this.o4Qty = o4Qty;
		this.f4Qty = f4Qty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("d3_qty", getD3Qty());
		this.hashColumns.put("lev", getLev());
		this.hashColumns.put("f2_qty", getF2Qty());
		this.hashColumns.put("g_ttl", getGTtl());
		this.hashColumns.put("tp_nm", getTpNm());
		this.hashColumns.put("d7_qty", getD7Qty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("r2_qty", getR2Qty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("num", getNum());
		this.hashColumns.put("o2_qty", getO2Qty());
		this.hashColumns.put("d4_qty", getD4Qty());
		this.hashColumns.put("r5_qty", getR5Qty());
		this.hashColumns.put("d2_qty", getD2Qty());
		this.hashColumns.put("d5_qty", getD5Qty());
		this.hashColumns.put("lease_term", getLeaseTerm());
		this.hashColumns.put("o4_qty", getO4Qty());
		this.hashColumns.put("f4_qty", getF4Qty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("d3_qty", "d3Qty");
		this.hashFields.put("lev", "lev");
		this.hashFields.put("f2_qty", "f2Qty");
		this.hashFields.put("g_ttl", "gTtl");
		this.hashFields.put("tp_nm", "tpNm");
		this.hashFields.put("d7_qty", "d7Qty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("r2_qty", "r2Qty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("num", "num");
		this.hashFields.put("o2_qty", "o2Qty");
		this.hashFields.put("d4_qty", "d4Qty");
		this.hashFields.put("r5_qty", "r5Qty");
		this.hashFields.put("d2_qty", "d2Qty");
		this.hashFields.put("d5_qty", "d5Qty");
		this.hashFields.put("lease_term", "leaseTerm");
		this.hashFields.put("o4_qty", "o4Qty");
		this.hashFields.put("f4_qty", "f4Qty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return d3Qty
	 */
	public String getD3Qty() {
		return this.d3Qty;
	}
	
	/**
	 * Column Info
	 * @return lev
	 */
	public String getLev() {
		return this.lev;
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
	 * @return gTtl
	 */
	public String getGTtl() {
		return this.gTtl;
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
	 * @return d7Qty
	 */
	public String getD7Qty() {
		return this.d7Qty;
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
	 * @return r2Qty
	 */
	public String getR2Qty() {
		return this.r2Qty;
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
	 * @return num
	 */
	public String getNum() {
		return this.num;
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
	 * @return d2Qty
	 */
	public String getD2Qty() {
		return this.d2Qty;
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
	 * @return leaseTerm
	 */
	public String getLeaseTerm() {
		return this.leaseTerm;
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
	 * @return f4Qty
	 */
	public String getF4Qty() {
		return this.f4Qty;
	}
	

	/**
	 * Column Info
	 * @param d3Qty
	 */
	public void setD3Qty(String d3Qty) {
		this.d3Qty = d3Qty;
	}
	
	/**
	 * Column Info
	 * @param lev
	 */
	public void setLev(String lev) {
		this.lev = lev;
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
	 * @param gTtl
	 */
	public void setGTtl(String gTtl) {
		this.gTtl = gTtl;
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
	 * @param d7Qty
	 */
	public void setD7Qty(String d7Qty) {
		this.d7Qty = d7Qty;
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
	 * @param r2Qty
	 */
	public void setR2Qty(String r2Qty) {
		this.r2Qty = r2Qty;
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
	 * @param num
	 */
	public void setNum(String num) {
		this.num = num;
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
	 * @param d2Qty
	 */
	public void setD2Qty(String d2Qty) {
		this.d2Qty = d2Qty;
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
	 * @param leaseTerm
	 */
	public void setLeaseTerm(String leaseTerm) {
		this.leaseTerm = leaseTerm;
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
		setD3Qty(JSPUtil.getParameter(request, "d3_qty", ""));
		setLev(JSPUtil.getParameter(request, "lev", ""));
		setF2Qty(JSPUtil.getParameter(request, "f2_qty", ""));
		setGTtl(JSPUtil.getParameter(request, "g_ttl", ""));
		setTpNm(JSPUtil.getParameter(request, "tp_nm", ""));
		setD7Qty(JSPUtil.getParameter(request, "d7_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setR2Qty(JSPUtil.getParameter(request, "r2_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNum(JSPUtil.getParameter(request, "num", ""));
		setO2Qty(JSPUtil.getParameter(request, "o2_qty", ""));
		setD4Qty(JSPUtil.getParameter(request, "d4_qty", ""));
		setR5Qty(JSPUtil.getParameter(request, "r5_qty", ""));
		setD2Qty(JSPUtil.getParameter(request, "d2_qty", ""));
		setD5Qty(JSPUtil.getParameter(request, "d5_qty", ""));
		setLeaseTerm(JSPUtil.getParameter(request, "lease_term", ""));
		setO4Qty(JSPUtil.getParameter(request, "o4_qty", ""));
		setF4Qty(JSPUtil.getParameter(request, "f4_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ProcurementResultReportVO[]
	 */
	public ProcurementResultReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ProcurementResultReportVO[]
	 */
	public ProcurementResultReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ProcurementResultReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] d3Qty = (JSPUtil.getParameter(request, prefix	+ "d3_qty", length));
			String[] lev = (JSPUtil.getParameter(request, prefix	+ "lev", length));
			String[] f2Qty = (JSPUtil.getParameter(request, prefix	+ "f2_qty", length));
			String[] gTtl = (JSPUtil.getParameter(request, prefix	+ "g_ttl", length));
			String[] tpNm = (JSPUtil.getParameter(request, prefix	+ "tp_nm", length));
			String[] d7Qty = (JSPUtil.getParameter(request, prefix	+ "d7_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] r2Qty = (JSPUtil.getParameter(request, prefix	+ "r2_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] num = (JSPUtil.getParameter(request, prefix	+ "num", length));
			String[] o2Qty = (JSPUtil.getParameter(request, prefix	+ "o2_qty", length));
			String[] d4Qty = (JSPUtil.getParameter(request, prefix	+ "d4_qty", length));
			String[] r5Qty = (JSPUtil.getParameter(request, prefix	+ "r5_qty", length));
			String[] d2Qty = (JSPUtil.getParameter(request, prefix	+ "d2_qty", length));
			String[] d5Qty = (JSPUtil.getParameter(request, prefix	+ "d5_qty", length));
			String[] leaseTerm = (JSPUtil.getParameter(request, prefix	+ "lease_term", length));
			String[] o4Qty = (JSPUtil.getParameter(request, prefix	+ "o4_qty", length));
			String[] f4Qty = (JSPUtil.getParameter(request, prefix	+ "f4_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new ProcurementResultReportVO();
				if (d3Qty[i] != null)
					model.setD3Qty(d3Qty[i]);
				if (lev[i] != null)
					model.setLev(lev[i]);
				if (f2Qty[i] != null)
					model.setF2Qty(f2Qty[i]);
				if (gTtl[i] != null)
					model.setGTtl(gTtl[i]);
				if (tpNm[i] != null)
					model.setTpNm(tpNm[i]);
				if (d7Qty[i] != null)
					model.setD7Qty(d7Qty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (r2Qty[i] != null)
					model.setR2Qty(r2Qty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (num[i] != null)
					model.setNum(num[i]);
				if (o2Qty[i] != null)
					model.setO2Qty(o2Qty[i]);
				if (d4Qty[i] != null)
					model.setD4Qty(d4Qty[i]);
				if (r5Qty[i] != null)
					model.setR5Qty(r5Qty[i]);
				if (d2Qty[i] != null)
					model.setD2Qty(d2Qty[i]);
				if (d5Qty[i] != null)
					model.setD5Qty(d5Qty[i]);
				if (leaseTerm[i] != null)
					model.setLeaseTerm(leaseTerm[i]);
				if (o4Qty[i] != null)
					model.setO4Qty(o4Qty[i]);
				if (f4Qty[i] != null)
					model.setF4Qty(f4Qty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getProcurementResultReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ProcurementResultReportVO[]
	 */
	public ProcurementResultReportVO[] getProcurementResultReportVOs(){
		ProcurementResultReportVO[] vos = (ProcurementResultReportVO[])models.toArray(new ProcurementResultReportVO[models.size()]);
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
		this.d3Qty = this.d3Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lev = this.lev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2Qty = this.f2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gTtl = this.gTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpNm = this.tpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Qty = this.d7Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Qty = this.r2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.num = this.num .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Qty = this.o2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Qty = this.d4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5Qty = this.r5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Qty = this.d2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Qty = this.d5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leaseTerm = this.leaseTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Qty = this.o4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4Qty = this.f4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
