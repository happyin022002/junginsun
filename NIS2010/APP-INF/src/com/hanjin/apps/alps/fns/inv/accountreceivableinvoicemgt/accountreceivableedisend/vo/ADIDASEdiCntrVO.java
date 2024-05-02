/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ADIDASEdiCntrVO.java
*@FileTitle : ADIDASEdiCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.29  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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

public class ADIDASEdiCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ADIDASEdiCntrVO> models = new ArrayList<ADIDASEdiCntrVO>();
	
	/* Column Info */
	private String cntrNbr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrOncarriageTransportMode = null;
	/* Column Info */
	private String cntrBasedateDetDem = null;
	/* Column Info */
	private String cntrStartdateDetDem = null;
	/* Column Info */
	private String blCountPerCntr = null;
	/* Column Info */
	private String cntrBlVolume = null;
	/* Column Info */
	private String cntrBlWeight = null;
	/* Column Info */
	private String cntrRatio = null;
	/* Column Info */
	private String cntrType = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ADIDASEdiCntrVO() {}

	public ADIDASEdiCntrVO(String ibflag, String pagerows, String cntrNbr, String cntrType, String cntrBlWeight, String cntrBlVolume, String cntrRatio, String blCountPerCntr, String cntrBasedateDetDem, String cntrStartdateDetDem, String cntrOncarriageTransportMode) {
		this.cntrNbr = cntrNbr;
		this.ibflag = ibflag;
		this.cntrOncarriageTransportMode = cntrOncarriageTransportMode;
		this.cntrBasedateDetDem = cntrBasedateDetDem;
		this.cntrStartdateDetDem = cntrStartdateDetDem;
		this.blCountPerCntr = blCountPerCntr;
		this.cntrBlVolume = cntrBlVolume;
		this.cntrBlWeight = cntrBlWeight;
		this.cntrRatio = cntrRatio;
		this.cntrType = cntrType;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_nbr", getCntrNbr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_oncarriage_transport_mode", getCntrOncarriageTransportMode());
		this.hashColumns.put("cntr_basedate_det_dem", getCntrBasedateDetDem());
		this.hashColumns.put("cntr_startdate_det_dem", getCntrStartdateDetDem());
		this.hashColumns.put("bl_count_per_cntr", getBlCountPerCntr());
		this.hashColumns.put("cntr_bl_volume", getCntrBlVolume());
		this.hashColumns.put("cntr_bl_weight", getCntrBlWeight());
		this.hashColumns.put("cntr_ratio", getCntrRatio());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_nbr", "cntrNbr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_oncarriage_transport_mode", "cntrOncarriageTransportMode");
		this.hashFields.put("cntr_basedate_det_dem", "cntrBasedateDetDem");
		this.hashFields.put("cntr_startdate_det_dem", "cntrStartdateDetDem");
		this.hashFields.put("bl_count_per_cntr", "blCountPerCntr");
		this.hashFields.put("cntr_bl_volume", "cntrBlVolume");
		this.hashFields.put("cntr_bl_weight", "cntrBlWeight");
		this.hashFields.put("cntr_ratio", "cntrRatio");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrNbr
	 */
	public String getCntrNbr() {
		return this.cntrNbr;
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
	 * @return cntrOncarriageTransportMode
	 */
	public String getCntrOncarriageTransportMode() {
		return this.cntrOncarriageTransportMode;
	}
	
	/**
	 * Column Info
	 * @return cntrBasedateDetDem
	 */
	public String getCntrBasedateDetDem() {
		return this.cntrBasedateDetDem;
	}
	
	/**
	 * Column Info
	 * @return cntrStartdateDetDem
	 */
	public String getCntrStartdateDetDem() {
		return this.cntrStartdateDetDem;
	}
	
	/**
	 * Column Info
	 * @return blCountPerCntr
	 */
	public String getBlCountPerCntr() {
		return this.blCountPerCntr;
	}
	
	/**
	 * Column Info
	 * @return cntrBlVolume
	 */
	public String getCntrBlVolume() {
		return this.cntrBlVolume;
	}
	
	/**
	 * Column Info
	 * @return cntrBlWeight
	 */
	public String getCntrBlWeight() {
		return this.cntrBlWeight;
	}
	
	/**
	 * Column Info
	 * @return cntrRatio
	 */
	public String getCntrRatio() {
		return this.cntrRatio;
	}
	
	/**
	 * Column Info
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
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
	 * @param cntrNbr
	 */
	public void setCntrNbr(String cntrNbr) {
		this.cntrNbr = cntrNbr;
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
	 * @param cntrOncarriageTransportMode
	 */
	public void setCntrOncarriageTransportMode(String cntrOncarriageTransportMode) {
		this.cntrOncarriageTransportMode = cntrOncarriageTransportMode;
	}
	
	/**
	 * Column Info
	 * @param cntrBasedateDetDem
	 */
	public void setCntrBasedateDetDem(String cntrBasedateDetDem) {
		this.cntrBasedateDetDem = cntrBasedateDetDem;
	}
	
	/**
	 * Column Info
	 * @param cntrStartdateDetDem
	 */
	public void setCntrStartdateDetDem(String cntrStartdateDetDem) {
		this.cntrStartdateDetDem = cntrStartdateDetDem;
	}
	
	/**
	 * Column Info
	 * @param blCountPerCntr
	 */
	public void setBlCountPerCntr(String blCountPerCntr) {
		this.blCountPerCntr = blCountPerCntr;
	}
	
	/**
	 * Column Info
	 * @param cntrBlVolume
	 */
	public void setCntrBlVolume(String cntrBlVolume) {
		this.cntrBlVolume = cntrBlVolume;
	}
	
	/**
	 * Column Info
	 * @param cntrBlWeight
	 */
	public void setCntrBlWeight(String cntrBlWeight) {
		this.cntrBlWeight = cntrBlWeight;
	}
	
	/**
	 * Column Info
	 * @param cntrRatio
	 */
	public void setCntrRatio(String cntrRatio) {
		this.cntrRatio = cntrRatio;
	}
	
	/**
	 * Column Info
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setCntrNbr(JSPUtil.getParameter(request, prefix + "cntr_nbr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrOncarriageTransportMode(JSPUtil.getParameter(request, prefix + "cntr_oncarriage_transport_mode", ""));
		setCntrBasedateDetDem(JSPUtil.getParameter(request, prefix + "cntr_basedate_det_dem", ""));
		setCntrStartdateDetDem(JSPUtil.getParameter(request, prefix + "cntr_startdate_det_dem", ""));
		setBlCountPerCntr(JSPUtil.getParameter(request, prefix + "bl_count_per_cntr", ""));
		setCntrBlVolume(JSPUtil.getParameter(request, prefix + "cntr_bl_volume", ""));
		setCntrBlWeight(JSPUtil.getParameter(request, prefix + "cntr_bl_weight", ""));
		setCntrRatio(JSPUtil.getParameter(request, prefix + "cntr_ratio", ""));
		setCntrType(JSPUtil.getParameter(request, prefix + "cntr_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ADIDASEdiCntrVO[]
	 */
	public ADIDASEdiCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ADIDASEdiCntrVO[]
	 */
	public ADIDASEdiCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ADIDASEdiCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrNbr = (JSPUtil.getParameter(request, prefix	+ "cntr_nbr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrOncarriageTransportMode = (JSPUtil.getParameter(request, prefix	+ "cntr_oncarriage_transport_mode", length));
			String[] cntrBasedateDetDem = (JSPUtil.getParameter(request, prefix	+ "cntr_basedate_det_dem", length));
			String[] cntrStartdateDetDem = (JSPUtil.getParameter(request, prefix	+ "cntr_startdate_det_dem", length));
			String[] blCountPerCntr = (JSPUtil.getParameter(request, prefix	+ "bl_count_per_cntr", length));
			String[] cntrBlVolume = (JSPUtil.getParameter(request, prefix	+ "cntr_bl_volume", length));
			String[] cntrBlWeight = (JSPUtil.getParameter(request, prefix	+ "cntr_bl_weight", length));
			String[] cntrRatio = (JSPUtil.getParameter(request, prefix	+ "cntr_ratio", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ADIDASEdiCntrVO();
				if (cntrNbr[i] != null)
					model.setCntrNbr(cntrNbr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrOncarriageTransportMode[i] != null)
					model.setCntrOncarriageTransportMode(cntrOncarriageTransportMode[i]);
				if (cntrBasedateDetDem[i] != null)
					model.setCntrBasedateDetDem(cntrBasedateDetDem[i]);
				if (cntrStartdateDetDem[i] != null)
					model.setCntrStartdateDetDem(cntrStartdateDetDem[i]);
				if (blCountPerCntr[i] != null)
					model.setBlCountPerCntr(blCountPerCntr[i]);
				if (cntrBlVolume[i] != null)
					model.setCntrBlVolume(cntrBlVolume[i]);
				if (cntrBlWeight[i] != null)
					model.setCntrBlWeight(cntrBlWeight[i]);
				if (cntrRatio[i] != null)
					model.setCntrRatio(cntrRatio[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getADIDASEdiCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ADIDASEdiCntrVO[]
	 */
	public ADIDASEdiCntrVO[] getADIDASEdiCntrVOs(){
		ADIDASEdiCntrVO[] vos = (ADIDASEdiCntrVO[])models.toArray(new ADIDASEdiCntrVO[models.size()]);
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
		this.cntrNbr = this.cntrNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOncarriageTransportMode = this.cntrOncarriageTransportMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrBasedateDetDem = this.cntrBasedateDetDem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStartdateDetDem = this.cntrStartdateDetDem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCountPerCntr = this.blCountPerCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrBlVolume = this.cntrBlVolume .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrBlWeight = this.cntrBlWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRatio = this.cntrRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
