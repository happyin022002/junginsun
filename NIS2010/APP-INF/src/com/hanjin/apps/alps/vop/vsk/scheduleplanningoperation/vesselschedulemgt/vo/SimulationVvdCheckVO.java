/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SimulationVvdCheckVO.java
*@FileTitle : SimulationVvdCheckVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.12.30 유혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author 유혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SimulationVvdCheckVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SimulationVvdCheckVO> models = new ArrayList<SimulationVvdCheckVO>();
	
	/* Column Info */
	private String startDate = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String duration = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String skdDirCd1 = null;
	/* Column Info */
	private String voyNoType = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd2 = null;
	/* Column Info */
	private String endDate = null;
	/* Column Info */
	private String vslCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SimulationVvdCheckVO() {}

	public SimulationVvdCheckVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String startDate, String endDate, String vslCnt, String voyNoType, String skdDirCd1, String skdDirCd2, String duration) {
		this.startDate = startDate;
		this.vslCd = vslCd;
		this.duration = duration;
		this.ibflag = ibflag;
		this.skdDirCd1 = skdDirCd1;
		this.voyNoType = voyNoType;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd2 = skdDirCd2;
		this.endDate = endDate;
		this.vslCnt = vslCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("start_date", getStartDate());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("duration", getDuration());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("skd_dir_cd_1", getSkdDirCd1());
		this.hashColumns.put("voy_no_type", getVoyNoType());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd_2", getSkdDirCd2());
		this.hashColumns.put("end_date", getEndDate());
		this.hashColumns.put("vsl_cnt", getVslCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("start_date", "startDate");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("duration", "duration");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("skd_dir_cd_1", "skdDirCd1");
		this.hashFields.put("voy_no_type", "voyNoType");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd_2", "skdDirCd2");
		this.hashFields.put("end_date", "endDate");
		this.hashFields.put("vsl_cnt", "vslCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return startDate
	 */
	public String getStartDate() {
		return this.startDate;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return duration
	 */
	public String getDuration() {
		return this.duration;
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
	 * @return skdDirCd1
	 */
	public String getSkdDirCd1() {
		return this.skdDirCd1;
	}
	
	/**
	 * Column Info
	 * @return voyNoType
	 */
	public String getVoyNoType() {
		return this.voyNoType;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd2
	 */
	public String getSkdDirCd2() {
		return this.skdDirCd2;
	}
	
	/**
	 * Column Info
	 * @return endDate
	 */
	public String getEndDate() {
		return this.endDate;
	}
	
	/**
	 * Column Info
	 * @return vslCnt
	 */
	public String getVslCnt() {
		return this.vslCnt;
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
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
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
	 * @param skdDirCd1
	 */
	public void setSkdDirCd1(String skdDirCd1) {
		this.skdDirCd1 = skdDirCd1;
	}
	
	/**
	 * Column Info
	 * @param voyNoType
	 */
	public void setVoyNoType(String voyNoType) {
		this.voyNoType = voyNoType;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd2
	 */
	public void setSkdDirCd2(String skdDirCd2) {
		this.skdDirCd2 = skdDirCd2;
	}
	
	/**
	 * Column Info
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Column Info
	 * @param vslCnt
	 */
	public void setVslCnt(String vslCnt) {
		this.vslCnt = vslCnt;
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
		setStartDate(JSPUtil.getParameter(request, prefix + "start_date", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setDuration(JSPUtil.getParameter(request, prefix + "duration", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSkdDirCd1(JSPUtil.getParameter(request, prefix + "skd_dir_cd_1", ""));
		setVoyNoType(JSPUtil.getParameter(request, prefix + "voy_no_type", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd2(JSPUtil.getParameter(request, prefix + "skd_dir_cd_2", ""));
		setEndDate(JSPUtil.getParameter(request, prefix + "end_date", ""));
		setVslCnt(JSPUtil.getParameter(request, prefix + "vsl_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SimulationVvdCheckVO[]
	 */
	public SimulationVvdCheckVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SimulationVvdCheckVO[]
	 */
	public SimulationVvdCheckVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SimulationVvdCheckVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] startDate = (JSPUtil.getParameter(request, prefix	+ "start_date", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] skdDirCd1 = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd_1", length));
			String[] voyNoType = (JSPUtil.getParameter(request, prefix	+ "voy_no_type", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd2 = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd_2", length));
			String[] endDate = (JSPUtil.getParameter(request, prefix	+ "end_date", length));
			String[] vslCnt = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SimulationVvdCheckVO();
				if (startDate[i] != null)
					model.setStartDate(startDate[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (skdDirCd1[i] != null)
					model.setSkdDirCd1(skdDirCd1[i]);
				if (voyNoType[i] != null)
					model.setVoyNoType(voyNoType[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd2[i] != null)
					model.setSkdDirCd2(skdDirCd2[i]);
				if (endDate[i] != null)
					model.setEndDate(endDate[i]);
				if (vslCnt[i] != null)
					model.setVslCnt(vslCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSimulationVvdCheckVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SimulationVvdCheckVO[]
	 */
	public SimulationVvdCheckVO[] getSimulationVvdCheckVOs(){
		SimulationVvdCheckVO[] vos = (SimulationVvdCheckVO[])models.toArray(new SimulationVvdCheckVO[models.size()]);
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
		this.startDate = this.startDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd1 = this.skdDirCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyNoType = this.voyNoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd2 = this.skdDirCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDate = this.endDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCnt = this.vslCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
