/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncidentInquiryCondVO.java
*@FileTitle : IncidentInquiryCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.10.29 양정란 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo;

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
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IncidentInquiryCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IncidentInquiryCondVO> models = new ArrayList<IncidentInquiryCondVO>();
	
	/* Column Info */
	private String schToStr = null;
	/* Column Info */
	private String schCond = null;
	/* Column Info */
	private String schLocCd = null;
	/* Column Info */
	private String schOfcCd = null;
	/* Column Info */
	private String schPlcTpCd = null;
	/* Column Info */
	private String schStr = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String schCreUsrId = null;
	/* Column Info */
	private String schFromStr = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String schDuration = null;
	/* Column Info */
	private String schArea = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IncidentInquiryCondVO() {}

	public IncidentInquiryCondVO(String ibflag, String pagerows, String schCond, String schStr, String schArea, String schOfcCd, String schCreUsrId, String schPlcTpCd, String schLocCd, String schDuration, String schFromStr, String schToStr, String pageNo) {
		this.schToStr = schToStr;
		this.schCond = schCond;
		this.schLocCd = schLocCd;
		this.schOfcCd = schOfcCd;
		this.schPlcTpCd = schPlcTpCd;
		this.schStr = schStr;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.schCreUsrId = schCreUsrId;
		this.schFromStr = schFromStr;
		this.pageNo = pageNo;
		this.schDuration = schDuration;
		this.schArea = schArea;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sch_to_str", getSchToStr());
		this.hashColumns.put("sch_cond", getSchCond());
		this.hashColumns.put("sch_loc_cd", getSchLocCd());
		this.hashColumns.put("sch_ofc_cd", getSchOfcCd());
		this.hashColumns.put("sch_plc_tp_cd", getSchPlcTpCd());
		this.hashColumns.put("sch_str", getSchStr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sch_cre_usr_id", getSchCreUsrId());
		this.hashColumns.put("sch_from_str", getSchFromStr());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("sch_duration", getSchDuration());
		this.hashColumns.put("sch_area", getSchArea());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sch_to_str", "schToStr");
		this.hashFields.put("sch_cond", "schCond");
		this.hashFields.put("sch_loc_cd", "schLocCd");
		this.hashFields.put("sch_ofc_cd", "schOfcCd");
		this.hashFields.put("sch_plc_tp_cd", "schPlcTpCd");
		this.hashFields.put("sch_str", "schStr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sch_cre_usr_id", "schCreUsrId");
		this.hashFields.put("sch_from_str", "schFromStr");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("sch_duration", "schDuration");
		this.hashFields.put("sch_area", "schArea");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return schToStr
	 */
	public String getSchToStr() {
		return this.schToStr;
	}
	
	/**
	 * Column Info
	 * @return schCond
	 */
	public String getSchCond() {
		return this.schCond;
	}
	
	/**
	 * Column Info
	 * @return schLocCd
	 */
	public String getSchLocCd() {
		return this.schLocCd;
	}
	
	/**
	 * Column Info
	 * @return schOfcCd
	 */
	public String getSchOfcCd() {
		return this.schOfcCd;
	}
	
	/**
	 * Column Info
	 * @return schPlcTpCd
	 */
	public String getSchPlcTpCd() {
		return this.schPlcTpCd;
	}
	
	/**
	 * Column Info
	 * @return schStr
	 */
	public String getSchStr() {
		return this.schStr;
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
	 * @return schCreUsrId
	 */
	public String getSchCreUsrId() {
		return this.schCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return schFromStr
	 */
	public String getSchFromStr() {
		return this.schFromStr;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return schDuration
	 */
	public String getSchDuration() {
		return this.schDuration;
	}
	
	/**
	 * Column Info
	 * @return schArea
	 */
	public String getSchArea() {
		return this.schArea;
	}
	

	/**
	 * Column Info
	 * @param schToStr
	 */
	public void setSchToStr(String schToStr) {
		this.schToStr = schToStr;
	}
	
	/**
	 * Column Info
	 * @param schCond
	 */
	public void setSchCond(String schCond) {
		this.schCond = schCond;
	}
	
	/**
	 * Column Info
	 * @param schLocCd
	 */
	public void setSchLocCd(String schLocCd) {
		this.schLocCd = schLocCd;
	}
	
	/**
	 * Column Info
	 * @param schOfcCd
	 */
	public void setSchOfcCd(String schOfcCd) {
		this.schOfcCd = schOfcCd;
	}
	
	/**
	 * Column Info
	 * @param schPlcTpCd
	 */
	public void setSchPlcTpCd(String schPlcTpCd) {
		this.schPlcTpCd = schPlcTpCd;
	}
	
	/**
	 * Column Info
	 * @param schStr
	 */
	public void setSchStr(String schStr) {
		this.schStr = schStr;
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
	 * @param schCreUsrId
	 */
	public void setSchCreUsrId(String schCreUsrId) {
		this.schCreUsrId = schCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param schFromStr
	 */
	public void setSchFromStr(String schFromStr) {
		this.schFromStr = schFromStr;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param schDuration
	 */
	public void setSchDuration(String schDuration) {
		this.schDuration = schDuration;
	}
	
	/**
	 * Column Info
	 * @param schArea
	 */
	public void setSchArea(String schArea) {
		this.schArea = schArea;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSchToStr(JSPUtil.getParameter(request, "sch_to_str", ""));
		setSchCond(JSPUtil.getParameter(request, "sch_cond", ""));
		setSchLocCd(JSPUtil.getParameter(request, "sch_loc_cd", ""));
		setSchOfcCd(JSPUtil.getParameter(request, "sch_ofc_cd", ""));
		setSchPlcTpCd(JSPUtil.getParameter(request, "sch_plc_tp_cd", ""));
		setSchStr(JSPUtil.getParameter(request, "sch_str", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSchCreUsrId(JSPUtil.getParameter(request, "sch_cre_usr_id", ""));
		setSchFromStr(JSPUtil.getParameter(request, "sch_from_str", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setSchDuration(JSPUtil.getParameter(request, "sch_duration", ""));
		setSchArea(JSPUtil.getParameter(request, "sch_area", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IncidentInquiryCondVO[]
	 */
	public IncidentInquiryCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IncidentInquiryCondVO[]
	 */
	public IncidentInquiryCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IncidentInquiryCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] schToStr = (JSPUtil.getParameter(request, prefix	+ "sch_to_str", length));
			String[] schCond = (JSPUtil.getParameter(request, prefix	+ "sch_cond", length));
			String[] schLocCd = (JSPUtil.getParameter(request, prefix	+ "sch_loc_cd", length));
			String[] schOfcCd = (JSPUtil.getParameter(request, prefix	+ "sch_ofc_cd", length));
			String[] schPlcTpCd = (JSPUtil.getParameter(request, prefix	+ "sch_plc_tp_cd", length));
			String[] schStr = (JSPUtil.getParameter(request, prefix	+ "sch_str", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] schCreUsrId = (JSPUtil.getParameter(request, prefix	+ "sch_cre_usr_id", length));
			String[] schFromStr = (JSPUtil.getParameter(request, prefix	+ "sch_from_str", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] schDuration = (JSPUtil.getParameter(request, prefix	+ "sch_duration", length));
			String[] schArea = (JSPUtil.getParameter(request, prefix	+ "sch_area", length));
			
			for (int i = 0; i < length; i++) {
				model = new IncidentInquiryCondVO();
				if (schToStr[i] != null)
					model.setSchToStr(schToStr[i]);
				if (schCond[i] != null)
					model.setSchCond(schCond[i]);
				if (schLocCd[i] != null)
					model.setSchLocCd(schLocCd[i]);
				if (schOfcCd[i] != null)
					model.setSchOfcCd(schOfcCd[i]);
				if (schPlcTpCd[i] != null)
					model.setSchPlcTpCd(schPlcTpCd[i]);
				if (schStr[i] != null)
					model.setSchStr(schStr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (schCreUsrId[i] != null)
					model.setSchCreUsrId(schCreUsrId[i]);
				if (schFromStr[i] != null)
					model.setSchFromStr(schFromStr[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (schDuration[i] != null)
					model.setSchDuration(schDuration[i]);
				if (schArea[i] != null)
					model.setSchArea(schArea[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIncidentInquiryCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IncidentInquiryCondVO[]
	 */
	public IncidentInquiryCondVO[] getIncidentInquiryCondVOs(){
		IncidentInquiryCondVO[] vos = (IncidentInquiryCondVO[])models.toArray(new IncidentInquiryCondVO[models.size()]);
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
		this.schToStr = this.schToStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schCond = this.schCond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schLocCd = this.schLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schOfcCd = this.schOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schPlcTpCd = this.schPlcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schStr = this.schStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schCreUsrId = this.schCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schFromStr = this.schFromStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schDuration = this.schDuration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schArea = this.schArea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
