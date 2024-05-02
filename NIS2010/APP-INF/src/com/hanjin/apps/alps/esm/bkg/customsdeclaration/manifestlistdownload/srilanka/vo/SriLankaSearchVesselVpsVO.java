/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SriLankaSearchVesselVpsVO.java
*@FileTitle : SriLankaSearchVesselVpsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo;

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

public class SriLankaSearchVesselVpsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SriLankaSearchVesselVpsVO> models = new ArrayList<SriLankaSearchVesselVpsVO>();
	
	/* Column Info */
	private String shippingAgent = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arrivalPortCd = null;
	/* Column Info */
	private String depaturePort = null;
	/* Column Info */
	private String localAgent = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String vpsEtaDtTime = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SriLankaSearchVesselVpsVO() {}

	public SriLankaSearchVesselVpsVO(String ibflag, String pagerows, String shippingAgent, String arrivalPortCd, String localAgent, String vpsEtaDt, String vpsEtaDtTime, String depaturePort) {
		this.shippingAgent = shippingAgent;
		this.ibflag = ibflag;
		this.arrivalPortCd = arrivalPortCd;
		this.depaturePort = depaturePort;
		this.localAgent = localAgent;
		this.vpsEtaDt = vpsEtaDt;
		this.vpsEtaDtTime = vpsEtaDtTime;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("shipping_agent", getShippingAgent());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("arrival_port_cd", getArrivalPortCd());
		this.hashColumns.put("depature_port", getDepaturePort());
		this.hashColumns.put("local_agent", getLocalAgent());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("vps_eta_dt_time", getVpsEtaDtTime());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("shipping_agent", "shippingAgent");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("arrival_port_cd", "arrivalPortCd");
		this.hashFields.put("depature_port", "depaturePort");
		this.hashFields.put("local_agent", "localAgent");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("vps_eta_dt_time", "vpsEtaDtTime");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return shippingAgent
	 */
	public String getShippingAgent() {
		return this.shippingAgent;
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
	 * @return arrivalPortCd
	 */
	public String getArrivalPortCd() {
		return this.arrivalPortCd;
	}
	
	/**
	 * Column Info
	 * @return depaturePort
	 */
	public String getDepaturePort() {
		return this.depaturePort;
	}
	
	/**
	 * Column Info
	 * @return localAgent
	 */
	public String getLocalAgent() {
		return this.localAgent;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @param shippingAgent
	 */
	public void setShippingAgent(String shippingAgent) {
		this.shippingAgent = shippingAgent;
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
	 * @param arrivalPortCd
	 */
	public void setArrivalPortCd(String arrivalPortCd) {
		this.arrivalPortCd = arrivalPortCd;
	}
	
	/**
	 * Column Info
	 * @param depaturePort
	 */
	public void setDepaturePort(String depaturePort) {
		this.depaturePort = depaturePort;
	}
	
	/**
	 * Column Info
	 * @param localAgent
	 */
	public void setLocalAgent(String localAgent) {
		this.localAgent = localAgent;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
		setShippingAgent(JSPUtil.getParameter(request, prefix + "shipping_agent", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setArrivalPortCd(JSPUtil.getParameter(request, prefix + "arrival_port_cd", ""));
		setDepaturePort(JSPUtil.getParameter(request, prefix + "depature_port", ""));
		setLocalAgent(JSPUtil.getParameter(request, prefix + "local_agent", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setVpsEtaDtTime(JSPUtil.getParameter(request, prefix + "vps_eta_dt_time", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SriLankaSearchVesselVpsVO[]
	 */
	public SriLankaSearchVesselVpsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SriLankaSearchVesselVpsVO[]
	 */
	public SriLankaSearchVesselVpsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SriLankaSearchVesselVpsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] shippingAgent = (JSPUtil.getParameter(request, prefix	+ "shipping_agent", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arrivalPortCd = (JSPUtil.getParameter(request, prefix	+ "arrival_port_cd", length));
			String[] depaturePort = (JSPUtil.getParameter(request, prefix	+ "depature_port", length));
			String[] localAgent = (JSPUtil.getParameter(request, prefix	+ "local_agent", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] vpsEtaDtTime = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_time", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SriLankaSearchVesselVpsVO();
				if (shippingAgent[i] != null)
					model.setShippingAgent(shippingAgent[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arrivalPortCd[i] != null)
					model.setArrivalPortCd(arrivalPortCd[i]);
				if (depaturePort[i] != null)
					model.setDepaturePort(depaturePort[i]);
				if (localAgent[i] != null)
					model.setLocalAgent(localAgent[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (vpsEtaDtTime[i] != null)
					model.setVpsEtaDtTime(vpsEtaDtTime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSriLankaSearchVesselVpsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SriLankaSearchVesselVpsVO[]
	 */
	public SriLankaSearchVesselVpsVO[] getSriLankaSearchVesselVpsVOs(){
		SriLankaSearchVesselVpsVO[] vos = (SriLankaSearchVesselVpsVO[])models.toArray(new SriLankaSearchVesselVpsVO[models.size()]);
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
		this.shippingAgent = this.shippingAgent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrivalPortCd = this.arrivalPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depaturePort = this.depaturePort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localAgent = this.localAgent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtTime = this.vpsEtaDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
