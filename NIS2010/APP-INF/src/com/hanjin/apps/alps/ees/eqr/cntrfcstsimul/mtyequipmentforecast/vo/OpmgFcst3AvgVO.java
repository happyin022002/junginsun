/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OpmgFcst3AvgVO.java
*@FileTitle : OpmgFcst3AvgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.10
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.06.10 문동선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo;

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
 * @author 문동선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OpmgFcst3AvgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpmgFcst3AvgVO> models = new ArrayList<OpmgFcst3AvgVO>();
	
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String a4Qty = null;
	/* Column Info */
	private String a5Qty = null;
	/* Column Info */
	private String o5Qty = null;
	/* Column Info */
	private String f2Qty = null;
	/* Column Info */
	private String a2Qty = null;
	/* Column Info */
	private String d7Qty = null;
	/* Column Info */
	private String s4Qty = null;
	/* Column Info */
	private String f5Qty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String r2Qty = null;
	/* Column Info */
	private String s2Qty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String o2Qty = null;
	/* Column Info */
	private String d4Qty = null;
	/* Column Info */
	private String r9Qty = null;
	/* Column Info */
	private String r5Qty = null;
	/* Column Info */
	private String d2Qty = null;
	/* Column Info */
	private String d5Qty = null;
	/* Column Info */
	private String wkySimTpCd = null;
	/* Column Info */
	private String o4Qty = null;
	/* Column Info */
	private String f4Qty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OpmgFcst3AvgVO() {}

	public OpmgFcst3AvgVO(String ibflag, String pagerows, String wkySimTpCd, String dpSeq, String d2Qty, String d4Qty, String d5Qty, String d7Qty, String r2Qty, String r5Qty, String r9Qty, String o2Qty, String s2Qty, String o4Qty, String s4Qty, String f2Qty, String a2Qty, String f4Qty, String a4Qty, String a5Qty, String f5Qty, String o5Qty) {
		this.dpSeq = dpSeq;
		this.a4Qty = a4Qty;
		this.a5Qty = a5Qty;
		this.o5Qty = o5Qty;
		this.f2Qty = f2Qty;
		this.a2Qty = a2Qty;
		this.d7Qty = d7Qty;
		this.s4Qty = s4Qty;
		this.f5Qty = f5Qty;
		this.pagerows = pagerows;
		this.r2Qty = r2Qty;
		this.s2Qty = s2Qty;
		this.ibflag = ibflag;
		this.o2Qty = o2Qty;
		this.d4Qty = d4Qty;
		this.r9Qty = r9Qty;
		this.r5Qty = r5Qty;
		this.d2Qty = d2Qty;
		this.d5Qty = d5Qty;
		this.wkySimTpCd = wkySimTpCd;
		this.o4Qty = o4Qty;
		this.f4Qty = f4Qty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("a4_qty", getA4Qty());
		this.hashColumns.put("a5_qty", getA5Qty());
		this.hashColumns.put("o5_qty", getO5Qty());
		this.hashColumns.put("f2_qty", getF2Qty());
		this.hashColumns.put("a2_qty", getA2Qty());
		this.hashColumns.put("d7_qty", getD7Qty());
		this.hashColumns.put("s4_qty", getS4Qty());
		this.hashColumns.put("f5_qty", getF5Qty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("r2_qty", getR2Qty());
		this.hashColumns.put("s2_qty", getS2Qty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("o2_qty", getO2Qty());
		this.hashColumns.put("d4_qty", getD4Qty());
		this.hashColumns.put("r9_qty", getR9Qty());
		this.hashColumns.put("r5_qty", getR5Qty());
		this.hashColumns.put("d2_qty", getD2Qty());
		this.hashColumns.put("d5_qty", getD5Qty());
		this.hashColumns.put("wky_sim_tp_cd", getWkySimTpCd());
		this.hashColumns.put("o4_qty", getO4Qty());
		this.hashColumns.put("f4_qty", getF4Qty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("a4_qty", "a4Qty");
		this.hashFields.put("a5_qty", "a5Qty");
		this.hashFields.put("o5_qty", "o5Qty");
		this.hashFields.put("f2_qty", "f2Qty");
		this.hashFields.put("a2_qty", "a2Qty");
		this.hashFields.put("d7_qty", "d7Qty");
		this.hashFields.put("s4_qty", "s4Qty");
		this.hashFields.put("f5_qty", "f5Qty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("r2_qty", "r2Qty");
		this.hashFields.put("s2_qty", "s2Qty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("o2_qty", "o2Qty");
		this.hashFields.put("d4_qty", "d4Qty");
		this.hashFields.put("r9_qty", "r9Qty");
		this.hashFields.put("r5_qty", "r5Qty");
		this.hashFields.put("d2_qty", "d2Qty");
		this.hashFields.put("d5_qty", "d5Qty");
		this.hashFields.put("wky_sim_tp_cd", "wkySimTpCd");
		this.hashFields.put("o4_qty", "o4Qty");
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
	 * @return a4Qty
	 */
	public String getA4Qty() {
		return this.a4Qty;
	}
	
	/**
	 * Column Info
	 * @return o5Qty
	 */
	public String getO5Qty() {
		return this.o5Qty;
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
	 * @return a2Qty
	 */
	public String getA2Qty() {
		return this.a2Qty;
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
	 * @return f5Qty
	 */
	public String getF5Qty() {
		return this.f5Qty;
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
	 * Column Info
	 * @return s2Qty
	 */
	public String getS2Qty() {
		return this.s2Qty;
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
	 * @return r9Qty
	 */
	public String getR9Qty() {
		return this.r9Qty;
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
	 * @return wkySimTpCd
	 */
	public String getWkySimTpCd() {
		return this.wkySimTpCd;
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
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
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
	 * @param o5Qty
	 */
	public void setO5Qty(String o5Qty) {
		this.o5Qty = o5Qty;
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
	 * @param a2Qty
	 */
	public void setA2Qty(String a2Qty) {
		this.a2Qty = a2Qty;
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
	 * @param f5Qty
	 */
	public void setF5Qty(String f5Qty) {
		this.f5Qty = f5Qty;
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
	 * Column Info
	 * @param s2Qty
	 */
	public void setS2Qty(String s2Qty) {
		this.s2Qty = s2Qty;
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
	 * @param r9Qty
	 */
	public void setR9Qty(String r9Qty) {
		this.r9Qty = r9Qty;
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
	 * @param wkySimTpCd
	 */
	public void setWkySimTpCd(String wkySimTpCd) {
		this.wkySimTpCd = wkySimTpCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setA4Qty(JSPUtil.getParameter(request, prefix + "a4_qty", ""));
		setA5Qty(JSPUtil.getParameter(request, prefix + "a5_qty", ""));
		setO5Qty(JSPUtil.getParameter(request, prefix + "o5_qty", ""));
		setF2Qty(JSPUtil.getParameter(request, prefix + "f2_qty", ""));
		setA2Qty(JSPUtil.getParameter(request, prefix + "a2_qty", ""));
		setD7Qty(JSPUtil.getParameter(request, prefix + "d7_qty", ""));
		setS4Qty(JSPUtil.getParameter(request, prefix + "s4_qty", ""));
		setF5Qty(JSPUtil.getParameter(request, prefix + "f5_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setR2Qty(JSPUtil.getParameter(request, prefix + "r2_qty", ""));
		setS2Qty(JSPUtil.getParameter(request, prefix + "s2_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setO2Qty(JSPUtil.getParameter(request, prefix + "o2_qty", ""));
		setD4Qty(JSPUtil.getParameter(request, prefix + "d4_qty", ""));
		setR9Qty(JSPUtil.getParameter(request, prefix + "r9_qty", ""));
		setR5Qty(JSPUtil.getParameter(request, prefix + "r5_qty", ""));
		setD2Qty(JSPUtil.getParameter(request, prefix + "d2_qty", ""));
		setD5Qty(JSPUtil.getParameter(request, prefix + "d5_qty", ""));
		setWkySimTpCd(JSPUtil.getParameter(request, prefix + "wky_sim_tp_cd", ""));
		setO4Qty(JSPUtil.getParameter(request, prefix + "o4_qty", ""));
		setF4Qty(JSPUtil.getParameter(request, prefix + "f4_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpmgFcst3AvgVO[]
	 */
	public OpmgFcst3AvgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpmgFcst3AvgVO[]
	 */
	public OpmgFcst3AvgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpmgFcst3AvgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] a4Qty = (JSPUtil.getParameter(request, prefix	+ "a4_qty", length));
			String[] a5Qty = (JSPUtil.getParameter(request, prefix	+ "a5_qty", length));
			String[] o5Qty = (JSPUtil.getParameter(request, prefix	+ "o5_qty", length));
			String[] f2Qty = (JSPUtil.getParameter(request, prefix	+ "f2_qty", length));
			String[] a2Qty = (JSPUtil.getParameter(request, prefix	+ "a2_qty", length));
			String[] d7Qty = (JSPUtil.getParameter(request, prefix	+ "d7_qty", length));
			String[] s4Qty = (JSPUtil.getParameter(request, prefix	+ "s4_qty", length));
			String[] f5Qty = (JSPUtil.getParameter(request, prefix	+ "f5_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] r2Qty = (JSPUtil.getParameter(request, prefix	+ "r2_qty", length));
			String[] s2Qty = (JSPUtil.getParameter(request, prefix	+ "s2_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] o2Qty = (JSPUtil.getParameter(request, prefix	+ "o2_qty", length));
			String[] d4Qty = (JSPUtil.getParameter(request, prefix	+ "d4_qty", length));
			String[] r9Qty = (JSPUtil.getParameter(request, prefix	+ "r9_qty", length));
			String[] r5Qty = (JSPUtil.getParameter(request, prefix	+ "r5_qty", length));
			String[] d2Qty = (JSPUtil.getParameter(request, prefix	+ "d2_qty", length));
			String[] d5Qty = (JSPUtil.getParameter(request, prefix	+ "d5_qty", length));
			String[] wkySimTpCd = (JSPUtil.getParameter(request, prefix	+ "wky_sim_tp_cd", length));
			String[] o4Qty = (JSPUtil.getParameter(request, prefix	+ "o4_qty", length));
			String[] f4Qty = (JSPUtil.getParameter(request, prefix	+ "f4_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpmgFcst3AvgVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (a4Qty[i] != null)
					model.setA4Qty(a4Qty[i]);
				if (a5Qty[i] != null)
					model.setA5Qty(a5Qty[i]);
				if (o5Qty[i] != null)
					model.setO5Qty(o5Qty[i]);
				if (f2Qty[i] != null)
					model.setF2Qty(f2Qty[i]);
				if (a2Qty[i] != null)
					model.setA2Qty(a2Qty[i]);
				if (d7Qty[i] != null)
					model.setD7Qty(d7Qty[i]);
				if (s4Qty[i] != null)
					model.setS4Qty(s4Qty[i]);
				if (f5Qty[i] != null)
					model.setF5Qty(f5Qty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (r2Qty[i] != null)
					model.setR2Qty(r2Qty[i]);
				if (s2Qty[i] != null)
					model.setS2Qty(s2Qty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (o2Qty[i] != null)
					model.setO2Qty(o2Qty[i]);
				if (d4Qty[i] != null)
					model.setD4Qty(d4Qty[i]);
				if (r9Qty[i] != null)
					model.setR9Qty(r9Qty[i]);
				if (r5Qty[i] != null)
					model.setR5Qty(r5Qty[i]);
				if (d2Qty[i] != null)
					model.setD2Qty(d2Qty[i]);
				if (d5Qty[i] != null)
					model.setD5Qty(d5Qty[i]);
				if (wkySimTpCd[i] != null)
					model.setWkySimTpCd(wkySimTpCd[i]);
				if (o4Qty[i] != null)
					model.setO4Qty(o4Qty[i]);
				if (f4Qty[i] != null)
					model.setF4Qty(f4Qty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpmgFcst3AvgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpmgFcst3AvgVO[]
	 */
	public OpmgFcst3AvgVO[] getOpmgFcst3AvgVOs(){
		OpmgFcst3AvgVO[] vos = (OpmgFcst3AvgVO[])models.toArray(new OpmgFcst3AvgVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4Qty = this.a4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a5Qty = this.a5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5Qty = this.o5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2Qty = this.f2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2Qty = this.a2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Qty = this.d7Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4Qty = this.s4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5Qty = this.f5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Qty = this.r2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Qty = this.s2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Qty = this.o2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Qty = this.d4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r9Qty = this.r9Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5Qty = this.r5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Qty = this.d2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Qty = this.d5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkySimTpCd = this.wkySimTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Qty = this.o4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4Qty = this.f4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getA5Qty() {
		return a5Qty;
	}

	public void setA5Qty(String a5Qty) {
		this.a5Qty = a5Qty;
	}
}
