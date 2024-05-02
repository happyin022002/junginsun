/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VvdLanePortVO.java
*@FileTitle : VvdLanePortVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.24
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.24 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VvdLanePortVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VvdLanePortVO> models = new ArrayList<VvdLanePortVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String revVvd = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String sailDt = null;
	/* Column Info */
	private String znIocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String delCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VvdLanePortVO() {}

	public VvdLanePortVO(String ibflag, String pagerows, String vvd, String slanCd, String svcScpCd, String rlaneCd, String portCd, String revVvd, String sailArrDt, String sailDt, String polCd, String podCd, String znIocCd, String porCd, String delCd) {
		this.podCd = podCd;
		this.vvd = vvd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.svcScpCd = svcScpCd;
		this.rlaneCd = rlaneCd;
		this.portCd = portCd;
		this.revVvd = revVvd;
		this.sailArrDt = sailArrDt;
		this.sailDt = sailDt;
		this.znIocCd = znIocCd;
		this.pagerows = pagerows;
		this.porCd = porCd;
		this.delCd = delCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("sail_dt", getSailDt());
		this.hashColumns.put("zn_ioc_cd", getZnIocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("del_cd", getDelCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("zn_ioc_cd", "znIocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("del_cd", "delCd");
		return this.hashFields;
	}
	
	
	
	/**
	 * @return the porCd
	 */
	public String getPorCd() {
		return porCd;
	}

	/**
	 * @param porCd the porCd to set
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}

	/**
	 * @return the delCd
	 */
	public String getDelCd() {
		return delCd;
	}

	/**
	 * @param delCd the delCd to set
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	/**
	 * @return the zoneIocCd
	 */
	public String getZnIocCd() {
		return znIocCd;
	}

	/**
	 * @param zoneIocCd the zoneIocCd to set
	 */
	public void setZnIocCd(String znIocCd) {
		this.znIocCd = znIocCd;
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
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return revVvd
	 */
	public String getRevVvd() {
		return this.revVvd;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return sailDt
	 */
	public String getSailDt() {
		return this.sailDt;
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
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param revVvd
	 */
	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param sailDt
	 */
	public void setSailDt(String sailDt) {
		this.sailDt = sailDt;
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
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setSailDt(JSPUtil.getParameter(request, "sail_dt", ""));
		setZnIocCd(JSPUtil.getParameter(request, "zn_ioc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VvdLanePortVO[]
	 */
	public VvdLanePortVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VvdLanePortVO[]
	 */
	public VvdLanePortVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VvdLanePortVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] sailDt = (JSPUtil.getParameter(request, prefix	+ "sail_dt", length));
			String[] znIocCd = (JSPUtil.getParameter(request, prefix	+ "zn_ioc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new VvdLanePortVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (sailDt[i] != null)
					model.setSailDt(sailDt[i]);
				if (znIocCd[i] != null)
					model.setZnIocCd(znIocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVvdLanePortVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VvdLanePortVO[]
	 */
	public VvdLanePortVO[] getVvdLanePortVOs(){
		VvdLanePortVO[] vos = (VvdLanePortVO[])models.toArray(new VvdLanePortVO[models.size()]);
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
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt = this.sailDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znIocCd = this.znIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
