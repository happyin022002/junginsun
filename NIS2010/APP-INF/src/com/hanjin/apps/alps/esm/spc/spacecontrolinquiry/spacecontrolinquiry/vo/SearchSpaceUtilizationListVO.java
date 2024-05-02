/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchSpaceUtilizationListVO.java
*@FileTitle : SearchSpaceUtilizationListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.07
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.11.07 최윤성 
* 1.0 Creation
* 
* HISTORY
* 2014.10.10 Arie IM [CHM-201432357] Space utilization inquiry 메뉴 로직 수정
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceUtilizationListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceUtilizationListVO> models = new ArrayList<SearchSpaceUtilizationListVO>();
	
	/* Column Info */
	private String loadTeuTtl = null;
	/* Column Info */
	private String podTmlCd = null;
	/* Column Info */
	private String podEtd = null;
	/* Column Info */
	private String loadWgtTtl = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String polTmlCd = null;
	/* Column Info */
	private String viewType = null;
	/* Column Info */
	private String podPort = null;
	/* Column Info */
	private String carrierCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String polEtd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String avgCmpb = null;
	/* Column Info */
	private String polEta = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String polPort = null;
	/* Column Info */
	private String podEta = null;
	
	private String isR01 = null; //[CHM-201432357]
	
	private String isR02 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceUtilizationListVO() {}

	public SearchSpaceUtilizationListVO(String ibflag, String pagerows, String vvd, String rlaneCd, String polPort, String polYdCd, String polTmlCd, String polEta, String polEtd, String podPort, String podYdCd, String podTmlCd, String podEta, String podEtd, String carrierCd, String loadTeuTtl, String loadWgtTtl, String avgCmpb, String viewType, String isR01, String isR02) {
		this.loadTeuTtl = loadTeuTtl;
		this.podTmlCd = podTmlCd;
		this.podEtd = podEtd;
		this.loadWgtTtl = loadWgtTtl;
		this.rlaneCd = rlaneCd;
		this.polTmlCd = polTmlCd;
		this.viewType = viewType;
		this.podPort = podPort;
		this.carrierCd = carrierCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.polEtd = polEtd;
		this.ibflag = ibflag;
		this.polYdCd = polYdCd;
		this.avgCmpb = avgCmpb;
		this.polEta = polEta;
		this.podYdCd = podYdCd;
		this.polPort = polPort;
		this.podEta = podEta;
		this.isR01 = isR01;
		this.isR02 = isR02;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("load_teu_ttl", getLoadTeuTtl());
		this.hashColumns.put("pod_tml_cd", getPodTmlCd());
		this.hashColumns.put("pod_etd", getPodEtd());
		this.hashColumns.put("load_wgt_ttl", getLoadWgtTtl());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pol_tml_cd", getPolTmlCd());
		this.hashColumns.put("view_type", getViewType());
		this.hashColumns.put("pod_port", getPodPort());
		this.hashColumns.put("carrier_cd", getCarrierCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pol_etd", getPolEtd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("avg_cmpb", getAvgCmpb());
		this.hashColumns.put("pol_eta", getPolEta());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("pol_port", getPolPort());
		this.hashColumns.put("pod_eta", getPodEta());
		this.hashColumns.put("is_r01", getIsR01());
		this.hashColumns.put("is_r02", getIsR02());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("load_teu_ttl", "loadTeuTtl");
		this.hashFields.put("pod_tml_cd", "podTmlCd");
		this.hashFields.put("pod_etd", "podEtd");
		this.hashFields.put("load_wgt_ttl", "loadWgtTtl");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pol_tml_cd", "polTmlCd");
		this.hashFields.put("view_type", "viewType");
		this.hashFields.put("pod_port", "podPort");
		this.hashFields.put("carrier_cd", "carrierCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("avg_cmpb", "avgCmpb");
		this.hashFields.put("pol_eta", "polEta");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("pol_port", "polPort");
		this.hashFields.put("pod_eta", "podEta");
		this.hashFields.put("is_r01", "isR01");
		this.hashFields.put("is_r02", "isR02");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return loadTeuTtl
	 */
	public String getLoadTeuTtl() {
		return this.loadTeuTtl;
	}
	
	/**
	 * Column Info
	 * @return podTmlCd
	 */
	public String getPodTmlCd() {
		return this.podTmlCd;
	}
	
	/**
	 * Column Info
	 * @return podEtd
	 */
	public String getPodEtd() {
		return this.podEtd;
	}
	
	/**
	 * Column Info
	 * @return loadWgtTtl
	 */
	public String getLoadWgtTtl() {
		return this.loadWgtTtl;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return polTmlCd
	 */
	public String getPolTmlCd() {
		return this.polTmlCd;
	}
	
	/**
	 * Column Info
	 * @return viewType
	 */
	public String getViewType() {
		return this.viewType;
	}
	
	/**
	 * Column Info
	 * @return podPort
	 */
	public String getPodPort() {
		return this.podPort;
	}
	
	/**
	 * Column Info
	 * @return carrierCd
	 */
	public String getCarrierCd() {
		return this.carrierCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return polEtd
	 */
	public String getPolEtd() {
		return this.polEtd;
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
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return avgCmpb
	 */
	public String getAvgCmpb() {
		return this.avgCmpb;
	}
	
	/**
	 * Column Info
	 * @return polEta
	 */
	public String getPolEta() {
		return this.polEta;
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
	 * @return polPort
	 */
	public String getPolPort() {
		return this.polPort;
	}
	
	/**
	 * Column Info
	 * @return podEta
	 */
	public String getPodEta() {
		return this.podEta;
	}
	

	/**
	 * Column Info
	 * @param loadTeuTtl
	 */
	public void setLoadTeuTtl(String loadTeuTtl) {
		this.loadTeuTtl = loadTeuTtl;
	}
	
	/**
	 * Column Info
	 * @param podTmlCd
	 */
	public void setPodTmlCd(String podTmlCd) {
		this.podTmlCd = podTmlCd;
	}
	
	/**
	 * Column Info
	 * @param podEtd
	 */
	public void setPodEtd(String podEtd) {
		this.podEtd = podEtd;
	}
	
	/**
	 * Column Info
	 * @param loadWgtTtl
	 */
	public void setLoadWgtTtl(String loadWgtTtl) {
		this.loadWgtTtl = loadWgtTtl;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param polTmlCd
	 */
	public void setPolTmlCd(String polTmlCd) {
		this.polTmlCd = polTmlCd;
	}
	
	/**
	 * Column Info
	 * @param viewType
	 */
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	
	/**
	 * Column Info
	 * @param podPort
	 */
	public void setPodPort(String podPort) {
		this.podPort = podPort;
	}
	
	/**
	 * Column Info
	 * @param carrierCd
	 */
	public void setCarrierCd(String carrierCd) {
		this.carrierCd = carrierCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param polEtd
	 */
	public void setPolEtd(String polEtd) {
		this.polEtd = polEtd;
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
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param avgCmpb
	 */
	public void setAvgCmpb(String avgCmpb) {
		this.avgCmpb = avgCmpb;
	}
	
	/**
	 * Column Info
	 * @param polEta
	 */
	public void setPolEta(String polEta) {
		this.polEta = polEta;
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
	 * @param polPort
	 */
	public void setPolPort(String polPort) {
		this.polPort = polPort;
	}
	
	/**
	 * Column Info
	 * @param podEta
	 */
	public void setPodEta(String podEta) {
		this.podEta = podEta;
	}
	

	/**
	 * @return the isR01
	 */
	public String getIsR01() {
		return isR01;
	}

	/**
	 * @return the isR02
	 */
	public String getIsR02() {
		return isR02;
	}
	
	/**
	 * @param isR01 the isR01 to set
	 */
	public void setIsR01(String isR01) {
		this.isR01 = isR01;
	}

	/**
	 * @param isR02 the isR02 to set
	 */
	public void setIsR02(String isR02) {
		this.isR02 = isR02;
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
		setLoadTeuTtl(JSPUtil.getParameter(request, prefix + "load_teu_ttl", ""));
		setPodTmlCd(JSPUtil.getParameter(request, prefix + "pod_tml_cd", ""));
		setPodEtd(JSPUtil.getParameter(request, prefix + "pod_etd", ""));
		setLoadWgtTtl(JSPUtil.getParameter(request, prefix + "load_wgt_ttl", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPolTmlCd(JSPUtil.getParameter(request, prefix + "pol_tml_cd", ""));
		setViewType(JSPUtil.getParameter(request, prefix + "view_type", ""));
		setPodPort(JSPUtil.getParameter(request, prefix + "pod_port", ""));
		setCarrierCd(JSPUtil.getParameter(request, prefix + "carrier_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPolEtd(JSPUtil.getParameter(request, prefix + "pol_etd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setAvgCmpb(JSPUtil.getParameter(request, prefix + "avg_cmpb", ""));
		setPolEta(JSPUtil.getParameter(request, prefix + "pol_eta", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setPolPort(JSPUtil.getParameter(request, prefix + "pol_port", ""));
		setPodEta(JSPUtil.getParameter(request, prefix + "pod_eta", ""));
		setIsR01(JSPUtil.getParameter(request, prefix + "is_r01", ""));
		setIsR02(JSPUtil.getParameter(request, prefix + "is_r02", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceUtilizationListVO[]
	 */
	public SearchSpaceUtilizationListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceUtilizationListVO[]
	 */
	public SearchSpaceUtilizationListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceUtilizationListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] loadTeuTtl = (JSPUtil.getParameter(request, prefix	+ "load_teu_ttl", length));
			String[] podTmlCd = (JSPUtil.getParameter(request, prefix	+ "pod_tml_cd", length));
			String[] podEtd = (JSPUtil.getParameter(request, prefix	+ "pod_etd", length));
			String[] loadWgtTtl = (JSPUtil.getParameter(request, prefix	+ "load_wgt_ttl", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] polTmlCd = (JSPUtil.getParameter(request, prefix	+ "pol_tml_cd", length));
			String[] viewType = (JSPUtil.getParameter(request, prefix	+ "view_type", length));
			String[] podPort = (JSPUtil.getParameter(request, prefix	+ "pod_port", length));
			String[] carrierCd = (JSPUtil.getParameter(request, prefix	+ "carrier_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] avgCmpb = (JSPUtil.getParameter(request, prefix	+ "avg_cmpb", length));
			String[] polEta = (JSPUtil.getParameter(request, prefix	+ "pol_eta", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] polPort = (JSPUtil.getParameter(request, prefix	+ "pol_port", length));
			String[] podEta = (JSPUtil.getParameter(request, prefix	+ "pod_eta", length));
			String[] isR01 = (JSPUtil.getParameter(request, prefix	+ "is_r01", length));
			String[] isR02 = (JSPUtil.getParameter(request, prefix	+ "is_r02", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceUtilizationListVO();
				if (loadTeuTtl[i] != null)
					model.setLoadTeuTtl(loadTeuTtl[i]);
				if (podTmlCd[i] != null)
					model.setPodTmlCd(podTmlCd[i]);
				if (podEtd[i] != null)
					model.setPodEtd(podEtd[i]);
				if (loadWgtTtl[i] != null)
					model.setLoadWgtTtl(loadWgtTtl[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (polTmlCd[i] != null)
					model.setPolTmlCd(polTmlCd[i]);
				if (viewType[i] != null)
					model.setViewType(viewType[i]);
				if (podPort[i] != null)
					model.setPodPort(podPort[i]);
				if (carrierCd[i] != null)
					model.setCarrierCd(carrierCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (polEtd[i] != null)
					model.setPolEtd(polEtd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (avgCmpb[i] != null)
					model.setAvgCmpb(avgCmpb[i]);
				if (polEta[i] != null)
					model.setPolEta(polEta[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (polPort[i] != null)
					model.setPolPort(polPort[i]);
				if (podEta[i] != null)
					model.setPodEta(podEta[i]);
				if (isR01[i] != null)
					model.setIsR01(isR01[i]);
				if (isR02[i] != null)
					model.setIsR02(isR02[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceUtilizationListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceUtilizationListVO[]
	 */
	public SearchSpaceUtilizationListVO[] getSearchSpaceUtilizationListVOs(){
		SearchSpaceUtilizationListVO[] vos = (SearchSpaceUtilizationListVO[])models.toArray(new SearchSpaceUtilizationListVO[models.size()]);
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
		this.loadTeuTtl = this.loadTeuTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTmlCd = this.podTmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtd = this.podEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadWgtTtl = this.loadWgtTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polTmlCd = this.polTmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewType = this.viewType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podPort = this.podPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrierCd = this.carrierCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgCmpb = this.avgCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEta = this.polEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPort = this.polPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEta = this.podEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isR01 = this.isR01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isR02 = this.isR02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
