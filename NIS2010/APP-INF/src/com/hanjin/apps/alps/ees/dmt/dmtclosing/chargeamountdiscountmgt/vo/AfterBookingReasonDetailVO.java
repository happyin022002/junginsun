/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AfterBookingReasonDetailVO.java
*@FileTitle : AfterBookingReasonDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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

public class AfterBookingReasonDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBookingReasonDetailVO> models = new ArrayList<AfterBookingReasonDetailVO>();
	
	/* Column Info */
	private String aftBkgFileDivCd = null;
	/* Column Info */
	private String detail5Type = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String detail6Type = null;
	/* Column Info */
	private String detail8Type = null;
	/* Column Info */
	private String detail2Type = null;
	/* Column Info */
	private String detail9Type = null;
	/* Column Info */
	private String detail3Type = null;
	/* Column Info */
	private String detail1Type = null;
	/* Column Info */
	private String detail7Type = null;
	/* Column Info */
	private String detail4Type = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AfterBookingReasonDetailVO() {}

	public AfterBookingReasonDetailVO(String ibflag, String pagerows, String aftExptDarNo, String aftBkgFileDivCd, String detail1Type, String detail2Type, String detail3Type, String detail4Type, String detail5Type, String detail6Type, String detail7Type, String detail8Type, String detail9Type) {
		this.aftBkgFileDivCd = aftBkgFileDivCd;
		this.detail5Type = detail5Type;
		this.ibflag = ibflag;
		this.aftExptDarNo = aftExptDarNo;
		this.detail6Type = detail6Type;
		this.detail8Type = detail8Type;
		this.detail2Type = detail2Type;
		this.detail9Type = detail9Type;
		this.detail3Type = detail3Type;
		this.detail1Type = detail1Type;
		this.detail7Type = detail7Type;
		this.detail4Type = detail4Type;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aft_bkg_file_div_cd", getAftBkgFileDivCd());
		this.hashColumns.put("detail_5_type", getDetail5Type());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("detail_6_type", getDetail6Type());
		this.hashColumns.put("detail_8_type", getDetail8Type());
		this.hashColumns.put("detail_2_type", getDetail2Type());
		this.hashColumns.put("detail_9_type", getDetail9Type());
		this.hashColumns.put("detail_3_type", getDetail3Type());
		this.hashColumns.put("detail_1_type", getDetail1Type());
		this.hashColumns.put("detail_7_type", getDetail7Type());
		this.hashColumns.put("detail_4_type", getDetail4Type());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aft_bkg_file_div_cd", "aftBkgFileDivCd");
		this.hashFields.put("detail_5_type", "detail5Type");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("detail_6_type", "detail6Type");
		this.hashFields.put("detail_8_type", "detail8Type");
		this.hashFields.put("detail_2_type", "detail2Type");
		this.hashFields.put("detail_9_type", "detail9Type");
		this.hashFields.put("detail_3_type", "detail3Type");
		this.hashFields.put("detail_1_type", "detail1Type");
		this.hashFields.put("detail_7_type", "detail7Type");
		this.hashFields.put("detail_4_type", "detail4Type");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aftBkgFileDivCd
	 */
	public String getAftBkgFileDivCd() {
		return this.aftBkgFileDivCd;
	}
	
	/**
	 * Column Info
	 * @return detail5Type
	 */
	public String getDetail5Type() {
		return this.detail5Type;
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
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return detail6Type
	 */
	public String getDetail6Type() {
		return this.detail6Type;
	}
	
	/**
	 * Column Info
	 * @return detail8Type
	 */
	public String getDetail8Type() {
		return this.detail8Type;
	}
	
	/**
	 * Column Info
	 * @return detail2Type
	 */
	public String getDetail2Type() {
		return this.detail2Type;
	}
	
	/**
	 * Column Info
	 * @return detail9Type
	 */
	public String getDetail9Type() {
		return this.detail9Type;
	}
	
	/**
	 * Column Info
	 * @return detail3Type
	 */
	public String getDetail3Type() {
		return this.detail3Type;
	}
	
	/**
	 * Column Info
	 * @return detail1Type
	 */
	public String getDetail1Type() {
		return this.detail1Type;
	}
	
	/**
	 * Column Info
	 * @return detail7Type
	 */
	public String getDetail7Type() {
		return this.detail7Type;
	}
	
	/**
	 * Column Info
	 * @return detail4Type
	 */
	public String getDetail4Type() {
		return this.detail4Type;
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
	 * @param aftBkgFileDivCd
	 */
	public void setAftBkgFileDivCd(String aftBkgFileDivCd) {
		this.aftBkgFileDivCd = aftBkgFileDivCd;
	}
	
	/**
	 * Column Info
	 * @param detail5Type
	 */
	public void setDetail5Type(String detail5Type) {
		this.detail5Type = detail5Type;
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
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param detail6Type
	 */
	public void setDetail6Type(String detail6Type) {
		this.detail6Type = detail6Type;
	}
	
	/**
	 * Column Info
	 * @param detail8Type
	 */
	public void setDetail8Type(String detail8Type) {
		this.detail8Type = detail8Type;
	}
	
	/**
	 * Column Info
	 * @param detail2Type
	 */
	public void setDetail2Type(String detail2Type) {
		this.detail2Type = detail2Type;
	}
	
	/**
	 * Column Info
	 * @param detail9Type
	 */
	public void setDetail9Type(String detail9Type) {
		this.detail9Type = detail9Type;
	}
	
	/**
	 * Column Info
	 * @param detail3Type
	 */
	public void setDetail3Type(String detail3Type) {
		this.detail3Type = detail3Type;
	}
	
	/**
	 * Column Info
	 * @param detail1Type
	 */
	public void setDetail1Type(String detail1Type) {
		this.detail1Type = detail1Type;
	}
	
	/**
	 * Column Info
	 * @param detail7Type
	 */
	public void setDetail7Type(String detail7Type) {
		this.detail7Type = detail7Type;
	}
	
	/**
	 * Column Info
	 * @param detail4Type
	 */
	public void setDetail4Type(String detail4Type) {
		this.detail4Type = detail4Type;
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
		setAftBkgFileDivCd(JSPUtil.getParameter(request, prefix + "aft_bkg_file_div_cd", ""));
		setDetail5Type(JSPUtil.getParameter(request, prefix + "detail_5_type", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", ""));
		setDetail6Type(JSPUtil.getParameter(request, prefix + "detail_6_type", ""));
		setDetail8Type(JSPUtil.getParameter(request, prefix + "detail_8_type", ""));
		setDetail2Type(JSPUtil.getParameter(request, prefix + "detail_2_type", ""));
		setDetail9Type(JSPUtil.getParameter(request, prefix + "detail_9_type", ""));
		setDetail3Type(JSPUtil.getParameter(request, prefix + "detail_3_type", ""));
		setDetail1Type(JSPUtil.getParameter(request, prefix + "detail_1_type", ""));
		setDetail7Type(JSPUtil.getParameter(request, prefix + "detail_7_type", ""));
		setDetail4Type(JSPUtil.getParameter(request, prefix + "detail_4_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBookingReasonDetailVO[]
	 */
	public AfterBookingReasonDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBookingReasonDetailVO[]
	 */
	public AfterBookingReasonDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBookingReasonDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aftBkgFileDivCd = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_file_div_cd", length));
			String[] detail5Type = (JSPUtil.getParameter(request, prefix	+ "detail_5_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] detail6Type = (JSPUtil.getParameter(request, prefix	+ "detail_6_type", length));
			String[] detail8Type = (JSPUtil.getParameter(request, prefix	+ "detail_8_type", length));
			String[] detail2Type = (JSPUtil.getParameter(request, prefix	+ "detail_2_type", length));
			String[] detail9Type = (JSPUtil.getParameter(request, prefix	+ "detail_9_type", length));
			String[] detail3Type = (JSPUtil.getParameter(request, prefix	+ "detail_3_type", length));
			String[] detail1Type = (JSPUtil.getParameter(request, prefix	+ "detail_1_type", length));
			String[] detail7Type = (JSPUtil.getParameter(request, prefix	+ "detail_7_type", length));
			String[] detail4Type = (JSPUtil.getParameter(request, prefix	+ "detail_4_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBookingReasonDetailVO();
				if (aftBkgFileDivCd[i] != null)
					model.setAftBkgFileDivCd(aftBkgFileDivCd[i]);
				if (detail5Type[i] != null)
					model.setDetail5Type(detail5Type[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (detail6Type[i] != null)
					model.setDetail6Type(detail6Type[i]);
				if (detail8Type[i] != null)
					model.setDetail8Type(detail8Type[i]);
				if (detail2Type[i] != null)
					model.setDetail2Type(detail2Type[i]);
				if (detail9Type[i] != null)
					model.setDetail9Type(detail9Type[i]);
				if (detail3Type[i] != null)
					model.setDetail3Type(detail3Type[i]);
				if (detail1Type[i] != null)
					model.setDetail1Type(detail1Type[i]);
				if (detail7Type[i] != null)
					model.setDetail7Type(detail7Type[i]);
				if (detail4Type[i] != null)
					model.setDetail4Type(detail4Type[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBookingReasonDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBookingReasonDetailVO[]
	 */
	public AfterBookingReasonDetailVO[] getAfterBookingReasonDetailVOs(){
		AfterBookingReasonDetailVO[] vos = (AfterBookingReasonDetailVO[])models.toArray(new AfterBookingReasonDetailVO[models.size()]);
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
		this.aftBkgFileDivCd = this.aftBkgFileDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail5Type = this.detail5Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail6Type = this.detail6Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail8Type = this.detail8Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail2Type = this.detail2Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail9Type = this.detail9Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail3Type = this.detail3Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail1Type = this.detail1Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail7Type = this.detail7Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail4Type = this.detail4Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
