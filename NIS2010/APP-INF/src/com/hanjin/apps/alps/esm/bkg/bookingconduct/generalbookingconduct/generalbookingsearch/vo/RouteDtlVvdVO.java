/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RouteDtlVvdVO.java
*@FileTitle : RouteDtlVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.10.29 이병규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 이병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RouteDtlVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RouteDtlVvdVO> models = new ArrayList<RouteDtlVvdVO>();
	
	/* Column Info */
	private String vpsEtaDtTime = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vpsEtdDtDate = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String vpsEtaDtDate = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String vpsEtdDtTime = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RouteDtlVvdVO() {}

	public RouteDtlVvdVO(String ibflag, String pagerows, String vslPrePstCd, String polCd, String polYdCd, String podCd, String podYdCd, String vvd, String slanCd, String vpsEtdDtDate, String vpsEtdDtTime, String vpsEtaDtDate, String vpsEtaDtTime) {
		this.vpsEtaDtTime = vpsEtaDtTime;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.vpsEtdDtDate = vpsEtdDtDate;
		this.slanCd = slanCd;
		this.polYdCd = polYdCd;
		this.vpsEtaDtDate = vpsEtaDtDate;
		this.vslPrePstCd = vslPrePstCd;
		this.podYdCd = podYdCd;
		this.vpsEtdDtTime = vpsEtdDtTime;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vps_eta_dt_time", getVpsEtaDtTime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vps_etd_dt_date", getVpsEtdDtDate());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("vps_eta_dt_date", getVpsEtaDtDate());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("vps_etd_dt_time", getVpsEtdDtTime());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vps_eta_dt_time", "vpsEtaDtTime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vps_etd_dt_date", "vpsEtdDtDate");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("vps_eta_dt_date", "vpsEtaDtDate");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("vps_etd_dt_time", "vpsEtdDtTime");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDtTime
	 */
	public String getVpsEtaDtTime() {
		return this.vpsEtaDtTime;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDtDate
	 */
	public String getVpsEtdDtDate() {
		return this.vpsEtdDtDate;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDtDate
	 */
	public String getVpsEtaDtDate() {
		return this.vpsEtaDtDate;
	}
	
	/**
	 * Column Info
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDtTime
	 */
	public String getVpsEtdDtTime() {
		return this.vpsEtdDtTime;
	}
	

	/**
	 * Column Info
	 * @param vpsEtaDtTime
	 */
	public void setVpsEtaDtTime(String vpsEtaDtTime) {
		this.vpsEtaDtTime = vpsEtaDtTime;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDtDate
	 */
	public void setVpsEtdDtDate(String vpsEtdDtDate) {
		this.vpsEtdDtDate = vpsEtdDtDate;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDtDate
	 */
	public void setVpsEtaDtDate(String vpsEtaDtDate) {
		this.vpsEtaDtDate = vpsEtaDtDate;
	}
	
	/**
	 * Column Info
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDtTime
	 */
	public void setVpsEtdDtTime(String vpsEtdDtTime) {
		this.vpsEtdDtTime = vpsEtdDtTime;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVpsEtaDtTime(JSPUtil.getParameter(request, "vps_eta_dt_time", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setVpsEtdDtDate(JSPUtil.getParameter(request, "vps_etd_dt_date", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
		setVpsEtaDtDate(JSPUtil.getParameter(request, "vps_eta_dt_date", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, "vsl_pre_pst_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setVpsEtdDtTime(JSPUtil.getParameter(request, "vps_etd_dt_time", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RouteDtlVvdVO[]
	 */
	public RouteDtlVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RouteDtlVvdVO[]
	 */
	public RouteDtlVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RouteDtlVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vpsEtaDtTime = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_time", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vpsEtdDtDate = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt_date", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] vpsEtaDtDate = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_date", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] vpsEtdDtTime = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt_time", length));
			
			for (int i = 0; i < length; i++) {
				model = new RouteDtlVvdVO();
				if (vpsEtaDtTime[i] != null)
					model.setVpsEtaDtTime(vpsEtaDtTime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vpsEtdDtDate[i] != null)
					model.setVpsEtdDtDate(vpsEtdDtDate[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (vpsEtaDtDate[i] != null)
					model.setVpsEtaDtDate(vpsEtaDtDate[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (vpsEtdDtTime[i] != null)
					model.setVpsEtdDtTime(vpsEtdDtTime[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRouteDtlVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RouteDtlVvdVO[]
	 */
	public RouteDtlVvdVO[] getRouteDtlVvdVOs(){
		RouteDtlVvdVO[] vos = (RouteDtlVvdVO[])models.toArray(new RouteDtlVvdVO[models.size()]);
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
		this.vpsEtaDtTime = this.vpsEtaDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDtDate = this.vpsEtdDtDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtDate = this.vpsEtaDtDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDtTime = this.vpsEtdDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
