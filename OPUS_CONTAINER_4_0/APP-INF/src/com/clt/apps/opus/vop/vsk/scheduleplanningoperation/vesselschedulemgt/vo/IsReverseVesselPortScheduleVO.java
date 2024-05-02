/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : IsReverseVesselPortScheduleVO.java
*@FileTitle : IsReverseVesselPortScheduleVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IsReverseVesselPortScheduleVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IsReverseVesselPortScheduleVO> models = new ArrayList<IsReverseVesselPortScheduleVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vpsReverseFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public IsReverseVesselPortScheduleVO() {}

	public IsReverseVesselPortScheduleVO(String ibflag, String pagerows, String vpsReverseFlg) {
		this.ibflag = ibflag;
		this.vpsReverseFlg = vpsReverseFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vps_reverse_flg", getVpsReverseFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vps_reverse_flg", "vpsReverseFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return vpsReverseFlg
	 */
	public String getVpsReverseFlg() {
		return this.vpsReverseFlg;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param vpsReverseFlg
	 */
	public void setVpsReverseFlg(String vpsReverseFlg) {
		this.vpsReverseFlg = vpsReverseFlg;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVpsReverseFlg(JSPUtil.getParameter(request, prefix + "vps_reverse_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IsReverseVesselPortScheduleVO[]
	 */
	public IsReverseVesselPortScheduleVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IsReverseVesselPortScheduleVO[]
	 */
	public IsReverseVesselPortScheduleVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IsReverseVesselPortScheduleVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vpsReverseFlg = (JSPUtil.getParameter(request, prefix	+ "vps_reverse_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new IsReverseVesselPortScheduleVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vpsReverseFlg[i] != null)
					model.setVpsReverseFlg(vpsReverseFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIsReverseVesselPortScheduleVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IsReverseVesselPortScheduleVO[]
	 */
	public IsReverseVesselPortScheduleVO[] getIsReverseVesselPortScheduleVOs(){
		IsReverseVesselPortScheduleVO[] vos = (IsReverseVesselPortScheduleVO[])models.toArray(new IsReverseVesselPortScheduleVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsReverseFlg = this.vpsReverseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
