/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IndExpAdvanceListVO.java
*@FileTitle : IndExpAdvanceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class IndExpAdvanceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndExpAdvanceListVO> models = new ArrayList<IndExpAdvanceListVO>();
	
	/* Column Info */
	private String imo = null;
	/* Column Info */
	private String rfFlg = null;
	/* Column Info */
	private String cate = null;
	/* Column Info */
	private String line = null;
	/* Column Info */
	private String pol1 = null;
	/* Column Info */
	private String bayLoc = null;
	/* Column Info */
	private String test2 = null;
	/* Column Info */
	private String kind = null;
	/* Column Info */
	private String test3 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String unit = null;
	/* Column Info */
	private String test1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String sts = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String temp = null;
	/* Column Info */
	private String isoCd = null;
	/* Column Info */
	private String ctr = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public IndExpAdvanceListVO() {}

	public IndExpAdvanceListVO(String ibflag, String pagerows, String ctr, String bayLoc, String cntrNo, String bkgNo, String measQty, String isoCd, String sts, String imo, String pol, String pod, String cate, String kind, String line, String rfFlg, String temp, String unit, String test1, String pol1, String test2, String test3) {
		this.imo = imo;
		this.rfFlg = rfFlg;
		this.cate = cate;
		this.line = line;
		this.pol1 = pol1;
		this.bayLoc = bayLoc;
		this.test2 = test2;
		this.kind = kind;
		this.test3 = test3;
		this.pagerows = pagerows;
		this.unit = unit;
		this.test1 = test1;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.measQty = measQty;
		this.sts = sts;
		this.pol = pol;
		this.temp = temp;
		this.isoCd = isoCd;
		this.ctr = ctr;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("imo", getImo());
		this.hashColumns.put("rf_flg", getRfFlg());
		this.hashColumns.put("cate", getCate());
		this.hashColumns.put("line", getLine());
		this.hashColumns.put("pol1", getPol1());
		this.hashColumns.put("bay_loc", getBayLoc());
		this.hashColumns.put("test2", getTest2());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("test3", getTest3());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("test1", getTest1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("sts", getSts());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("temp", getTemp());
		this.hashColumns.put("iso_cd", getIsoCd());
		this.hashColumns.put("ctr", getCtr());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("imo", "imo");
		this.hashFields.put("rf_flg", "rfFlg");
		this.hashFields.put("cate", "cate");
		this.hashFields.put("line", "line");
		this.hashFields.put("pol1", "pol1");
		this.hashFields.put("bay_loc", "bayLoc");
		this.hashFields.put("test2", "test2");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("test3", "test3");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("test1", "test1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("sts", "sts");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("temp", "temp");
		this.hashFields.put("iso_cd", "isoCd");
		this.hashFields.put("ctr", "ctr");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return imo
	 */
	public String getImo() {
		return this.imo;
	}
	
	/**
	 * Column Info
	 * @return rfFlg
	 */
	public String getRfFlg() {
		return this.rfFlg;
	}
	
	/**
	 * Column Info
	 * @return cate
	 */
	public String getCate() {
		return this.cate;
	}
	
	/**
	 * Column Info
	 * @return line
	 */
	public String getLine() {
		return this.line;
	}
	
	/**
	 * Column Info
	 * @return pol1
	 */
	public String getPol1() {
		return this.pol1;
	}
	
	/**
	 * Column Info
	 * @return bayLoc
	 */
	public String getBayLoc() {
		return this.bayLoc;
	}
	
	/**
	 * Column Info
	 * @return test2
	 */
	public String getTest2() {
		return this.test2;
	}
	
	/**
	 * Column Info
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
	}
	
	/**
	 * Column Info
	 * @return test3
	 */
	public String getTest3() {
		return this.test3;
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
	 * @return unit
	 */
	public String getUnit() {
		return this.unit;
	}
	
	/**
	 * Column Info
	 * @return test1
	 */
	public String getTest1() {
		return this.test1;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return sts
	 */
	public String getSts() {
		return this.sts;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return temp
	 */
	public String getTemp() {
		return this.temp;
	}
	
	/**
	 * Column Info
	 * @return isoCd
	 */
	public String getIsoCd() {
		return this.isoCd;
	}
	
	/**
	 * Column Info
	 * @return ctr
	 */
	public String getCtr() {
		return this.ctr;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	

	/**
	 * Column Info
	 * @param imo
	 */
	public void setImo(String imo) {
		this.imo = imo;
	}
	
	/**
	 * Column Info
	 * @param rfFlg
	 */
	public void setRfFlg(String rfFlg) {
		this.rfFlg = rfFlg;
	}
	
	/**
	 * Column Info
	 * @param cate
	 */
	public void setCate(String cate) {
		this.cate = cate;
	}
	
	/**
	 * Column Info
	 * @param line
	 */
	public void setLine(String line) {
		this.line = line;
	}
	
	/**
	 * Column Info
	 * @param pol1
	 */
	public void setPol1(String pol1) {
		this.pol1 = pol1;
	}
	
	/**
	 * Column Info
	 * @param bayLoc
	 */
	public void setBayLoc(String bayLoc) {
		this.bayLoc = bayLoc;
	}
	
	/**
	 * Column Info
	 * @param test2
	 */
	public void setTest2(String test2) {
		this.test2 = test2;
	}
	
	/**
	 * Column Info
	 * @param kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	/**
	 * Column Info
	 * @param test3
	 */
	public void setTest3(String test3) {
		this.test3 = test3;
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
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * Column Info
	 * @param test1
	 */
	public void setTest1(String test1) {
		this.test1 = test1;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param sts
	 */
	public void setSts(String sts) {
		this.sts = sts;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param temp
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	/**
	 * Column Info
	 * @param isoCd
	 */
	public void setIsoCd(String isoCd) {
		this.isoCd = isoCd;
	}
	
	/**
	 * Column Info
	 * @param ctr
	 */
	public void setCtr(String ctr) {
		this.ctr = ctr;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setImo(JSPUtil.getParameter(request, prefix + "imo", ""));
		setRfFlg(JSPUtil.getParameter(request, prefix + "rf_flg", ""));
		setCate(JSPUtil.getParameter(request, prefix + "cate", ""));
		setLine(JSPUtil.getParameter(request, prefix + "line", ""));
		setPol1(JSPUtil.getParameter(request, prefix + "pol1", ""));
		setBayLoc(JSPUtil.getParameter(request, prefix + "bay_loc", ""));
		setTest2(JSPUtil.getParameter(request, prefix + "test2", ""));
		setKind(JSPUtil.getParameter(request, prefix + "kind", ""));
		setTest3(JSPUtil.getParameter(request, prefix + "test3", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUnit(JSPUtil.getParameter(request, prefix + "unit", ""));
		setTest1(JSPUtil.getParameter(request, prefix + "test1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setSts(JSPUtil.getParameter(request, prefix + "sts", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setTemp(JSPUtil.getParameter(request, prefix + "temp", ""));
		setIsoCd(JSPUtil.getParameter(request, prefix + "iso_cd", ""));
		setCtr(JSPUtil.getParameter(request, prefix + "ctr", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndExpAdvanceListVO[]
	 */
	public IndExpAdvanceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndExpAdvanceListVO[]
	 */
	public IndExpAdvanceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndExpAdvanceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] imo = (JSPUtil.getParameter(request, prefix	+ "imo", length));
			String[] rfFlg = (JSPUtil.getParameter(request, prefix	+ "rf_flg", length));
			String[] cate = (JSPUtil.getParameter(request, prefix	+ "cate", length));
			String[] line = (JSPUtil.getParameter(request, prefix	+ "line", length));
			String[] pol1 = (JSPUtil.getParameter(request, prefix	+ "pol1", length));
			String[] bayLoc = (JSPUtil.getParameter(request, prefix	+ "bay_loc", length));
			String[] test2 = (JSPUtil.getParameter(request, prefix	+ "test2", length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind", length));
			String[] test3 = (JSPUtil.getParameter(request, prefix	+ "test3", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] unit = (JSPUtil.getParameter(request, prefix	+ "unit", length));
			String[] test1 = (JSPUtil.getParameter(request, prefix	+ "test1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] sts = (JSPUtil.getParameter(request, prefix	+ "sts", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] temp = (JSPUtil.getParameter(request, prefix	+ "temp", length));
			String[] isoCd = (JSPUtil.getParameter(request, prefix	+ "iso_cd", length));
			String[] ctr = (JSPUtil.getParameter(request, prefix	+ "ctr", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndExpAdvanceListVO();
				if (imo[i] != null)
					model.setImo(imo[i]);
				if (rfFlg[i] != null)
					model.setRfFlg(rfFlg[i]);
				if (cate[i] != null)
					model.setCate(cate[i]);
				if (line[i] != null)
					model.setLine(line[i]);
				if (pol1[i] != null)
					model.setPol1(pol1[i]);
				if (bayLoc[i] != null)
					model.setBayLoc(bayLoc[i]);
				if (test2[i] != null)
					model.setTest2(test2[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (test3[i] != null)
					model.setTest3(test3[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (unit[i] != null)
					model.setUnit(unit[i]);
				if (test1[i] != null)
					model.setTest1(test1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (sts[i] != null)
					model.setSts(sts[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (temp[i] != null)
					model.setTemp(temp[i]);
				if (isoCd[i] != null)
					model.setIsoCd(isoCd[i]);
				if (ctr[i] != null)
					model.setCtr(ctr[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndExpAdvanceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndExpAdvanceListVO[]
	 */
	public IndExpAdvanceListVO[] getIndExpAdvanceListVOs(){
		IndExpAdvanceListVO[] vos = (IndExpAdvanceListVO[])models.toArray(new IndExpAdvanceListVO[models.size()]);
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
		this.imo = this.imo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfFlg = this.rfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cate = this.cate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.line = this.line .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1 = this.pol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayLoc = this.bayLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.test2 = this.test2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.test3 = this.test3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit = this.unit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.test1 = this.test1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts = this.sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.temp = this.temp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isoCd = this.isoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctr = this.ctr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
