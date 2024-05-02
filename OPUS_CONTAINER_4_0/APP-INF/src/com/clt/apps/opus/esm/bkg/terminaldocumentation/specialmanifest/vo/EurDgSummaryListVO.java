/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EurDgSummaryListVO.java
*@FileTitle : EurDgSummaryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.09
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2015.11.09 이종길 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이종길
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurDgSummaryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurDgSummaryListVO> models = new ArrayList<EurDgSummaryListVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totalBookings = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String listType = null;
	/* Column Info */
	private String class90 = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String class80 = null;
	/* Column Info */
	private String class61 = null;
	/* Column Info */
	private String class30 = null;
	/* Column Info */
	private String class41 = null;
	/* Column Info */
	private String class52 = null;
	/* Column Info */
	private String class51 = null;
	/* Column Info */
	private String class21 = null;
	/* Column Info */
	private String class43 = null;
	/* Column Info */
	private String class42 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String class22 = null;
	/* Column Info */
	private String class14 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EurDgSummaryListVO() {}

	public EurDgSummaryListVO(String ibflag, String pagerows, String podCd, String class14, String class21, String class22, String class30, String class41, String class42, String class43, String class51, String class52, String class61, String class80, String class90, String totalBookings, String vvdCd, String crrCd, String listType, String polCd) {
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.totalBookings = totalBookings;
		this.crrCd = crrCd;
		this.listType = listType;
		this.class90 = class90;
		this.vvdCd = vvdCd;
		this.polCd = polCd;
		this.class80 = class80;
		this.class61 = class61;
		this.class30 = class30;
		this.class41 = class41;
		this.class52 = class52;
		this.class51 = class51;
		this.class21 = class21;
		this.class43 = class43;
		this.class42 = class42;
		this.podCd = podCd;
		this.class22 = class22;
		this.class14 = class14;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("total_bookings", getTotalBookings());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("list_type", getListType());
		this.hashColumns.put("class_90", getClass90());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("class_80", getClass80());
		this.hashColumns.put("class_61", getClass61());
		this.hashColumns.put("class_30", getClass30());
		this.hashColumns.put("class_41", getClass41());
		this.hashColumns.put("class_52", getClass52());
		this.hashColumns.put("class_51", getClass51());
		this.hashColumns.put("class_21", getClass21());
		this.hashColumns.put("class_43", getClass43());
		this.hashColumns.put("class_42", getClass42());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("class_22", getClass22());
		this.hashColumns.put("class_14", getClass14());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("total_bookings", "totalBookings");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("list_type", "listType");
		this.hashFields.put("class_90", "class90");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("class_80", "class80");
		this.hashFields.put("class_61", "class61");
		this.hashFields.put("class_30", "class30");
		this.hashFields.put("class_41", "class41");
		this.hashFields.put("class_52", "class52");
		this.hashFields.put("class_51", "class51");
		this.hashFields.put("class_21", "class21");
		this.hashFields.put("class_43", "class43");
		this.hashFields.put("class_42", "class42");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("class_22", "class22");
		this.hashFields.put("class_14", "class14");
		return this.hashFields;
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
	 * @return totalBookings
	 */
	public String getTotalBookings() {
		return this.totalBookings;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return listType
	 */
	public String getListType() {
		return this.listType;
	}
	
	/**
	 * Column Info
	 * @return class90
	 */
	public String getClass90() {
		return this.class90;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return class80
	 */
	public String getClass80() {
		return this.class80;
	}
	
	/**
	 * Column Info
	 * @return class61
	 */
	public String getClass61() {
		return this.class61;
	}
	
	/**
	 * Column Info
	 * @return class30
	 */
	public String getClass30() {
		return this.class30;
	}
	
	/**
	 * Column Info
	 * @return class41
	 */
	public String getClass41() {
		return this.class41;
	}
	
	/**
	 * Column Info
	 * @return class52
	 */
	public String getClass52() {
		return this.class52;
	}
	
	/**
	 * Column Info
	 * @return class51
	 */
	public String getClass51() {
		return this.class51;
	}
	
	/**
	 * Column Info
	 * @return class21
	 */
	public String getClass21() {
		return this.class21;
	}
	
	/**
	 * Column Info
	 * @return class43
	 */
	public String getClass43() {
		return this.class43;
	}
	
	/**
	 * Column Info
	 * @return class42
	 */
	public String getClass42() {
		return this.class42;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return class22
	 */
	public String getClass22() {
		return this.class22;
	}
	
	/**
	 * Column Info
	 * @return class14
	 */
	public String getClass14() {
		return this.class14;
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
	 * @param totalBookings
	 */
	public void setTotalBookings(String totalBookings) {
		this.totalBookings = totalBookings;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param listType
	 */
	public void setListType(String listType) {
		this.listType = listType;
	}
	
	/**
	 * Column Info
	 * @param class90
	 */
	public void setClass90(String class90) {
		this.class90 = class90;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param class80
	 */
	public void setClass80(String class80) {
		this.class80 = class80;
	}
	
	/**
	 * Column Info
	 * @param class61
	 */
	public void setClass61(String class61) {
		this.class61 = class61;
	}
	
	/**
	 * Column Info
	 * @param class30
	 */
	public void setClass30(String class30) {
		this.class30 = class30;
	}
	
	/**
	 * Column Info
	 * @param class41
	 */
	public void setClass41(String class41) {
		this.class41 = class41;
	}
	
	/**
	 * Column Info
	 * @param class52
	 */
	public void setClass52(String class52) {
		this.class52 = class52;
	}
	
	/**
	 * Column Info
	 * @param class51
	 */
	public void setClass51(String class51) {
		this.class51 = class51;
	}
	
	/**
	 * Column Info
	 * @param class21
	 */
	public void setClass21(String class21) {
		this.class21 = class21;
	}
	
	/**
	 * Column Info
	 * @param class43
	 */
	public void setClass43(String class43) {
		this.class43 = class43;
	}
	
	/**
	 * Column Info
	 * @param class42
	 */
	public void setClass42(String class42) {
		this.class42 = class42;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param class22
	 */
	public void setClass22(String class22) {
		this.class22 = class22;
	}
	
	/**
	 * Column Info
	 * @param class14
	 */
	public void setClass14(String class14) {
		this.class14 = class14;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotalBookings(JSPUtil.getParameter(request, prefix + "total_bookings", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setListType(JSPUtil.getParameter(request, prefix + "list_type", ""));
		setClass90(JSPUtil.getParameter(request, prefix + "class_90", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setClass80(JSPUtil.getParameter(request, prefix + "class_80", ""));
		setClass61(JSPUtil.getParameter(request, prefix + "class_61", ""));
		setClass30(JSPUtil.getParameter(request, prefix + "class_30", ""));
		setClass41(JSPUtil.getParameter(request, prefix + "class_41", ""));
		setClass52(JSPUtil.getParameter(request, prefix + "class_52", ""));
		setClass51(JSPUtil.getParameter(request, prefix + "class_51", ""));
		setClass21(JSPUtil.getParameter(request, prefix + "class_21", ""));
		setClass43(JSPUtil.getParameter(request, prefix + "class_43", ""));
		setClass42(JSPUtil.getParameter(request, prefix + "class_42", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setClass22(JSPUtil.getParameter(request, prefix + "class_22", ""));
		setClass14(JSPUtil.getParameter(request, prefix + "class_14", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurDgSummaryListVO[]
	 */
	public EurDgSummaryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurDgSummaryListVO[]
	 */
	public EurDgSummaryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurDgSummaryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totalBookings = (JSPUtil.getParameter(request, prefix	+ "total_bookings", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] listType = (JSPUtil.getParameter(request, prefix	+ "list_type", length));
			String[] class90 = (JSPUtil.getParameter(request, prefix	+ "class_90", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] class80 = (JSPUtil.getParameter(request, prefix	+ "class_80", length));
			String[] class61 = (JSPUtil.getParameter(request, prefix	+ "class_61", length));
			String[] class30 = (JSPUtil.getParameter(request, prefix	+ "class_30", length));
			String[] class41 = (JSPUtil.getParameter(request, prefix	+ "class_41", length));
			String[] class52 = (JSPUtil.getParameter(request, prefix	+ "class_52", length));
			String[] class51 = (JSPUtil.getParameter(request, prefix	+ "class_51", length));
			String[] class21 = (JSPUtil.getParameter(request, prefix	+ "class_21", length));
			String[] class43 = (JSPUtil.getParameter(request, prefix	+ "class_43", length));
			String[] class42 = (JSPUtil.getParameter(request, prefix	+ "class_42", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] class22 = (JSPUtil.getParameter(request, prefix	+ "class_22", length));
			String[] class14 = (JSPUtil.getParameter(request, prefix	+ "class_14", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurDgSummaryListVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totalBookings[i] != null)
					model.setTotalBookings(totalBookings[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (listType[i] != null)
					model.setListType(listType[i]);
				if (class90[i] != null)
					model.setClass90(class90[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (class80[i] != null)
					model.setClass80(class80[i]);
				if (class61[i] != null)
					model.setClass61(class61[i]);
				if (class30[i] != null)
					model.setClass30(class30[i]);
				if (class41[i] != null)
					model.setClass41(class41[i]);
				if (class52[i] != null)
					model.setClass52(class52[i]);
				if (class51[i] != null)
					model.setClass51(class51[i]);
				if (class21[i] != null)
					model.setClass21(class21[i]);
				if (class43[i] != null)
					model.setClass43(class43[i]);
				if (class42[i] != null)
					model.setClass42(class42[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (class22[i] != null)
					model.setClass22(class22[i]);
				if (class14[i] != null)
					model.setClass14(class14[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurDgSummaryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurDgSummaryListVO[]
	 */
	public EurDgSummaryListVO[] getEurDgSummaryListVOs(){
		EurDgSummaryListVO[] vos = (EurDgSummaryListVO[])models.toArray(new EurDgSummaryListVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalBookings = this.totalBookings .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.listType = this.listType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.class90 = this.class90 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.class80 = this.class80 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.class61 = this.class61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.class30 = this.class30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.class41 = this.class41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.class52 = this.class52 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.class51 = this.class51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.class21 = this.class21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.class43 = this.class43 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.class42 = this.class42 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.class22 = this.class22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.class14 = this.class14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
