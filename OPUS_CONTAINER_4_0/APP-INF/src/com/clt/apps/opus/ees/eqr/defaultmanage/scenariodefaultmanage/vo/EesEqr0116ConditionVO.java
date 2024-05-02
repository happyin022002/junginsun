/**
 * 
 */
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;

/**
 * @author 9009627
 *
 */
public class EesEqr0116ConditionVO {
/* parameter Info */
	
	private String fromStatus  = "";
	private String toStatus	   = "";
	private String fromLocation= "";
	private String toLocation  = "";
	private String transitTime = "";
	private String mode        = "";
	
	/* common */
	private String maxUpdate = "";
	private String maxUserid = "";
	
	/**
	 * @return the fromStatus
	 */
	public String getFromStatus() {
		return fromStatus;
	}

	/**
	 * @param fromStatus the fromStatus to set
	 */
	public void setFromStatus(String fromStatus) {
		this.fromStatus = fromStatus;
	}

	/**
	 * @return the toStatus
	 */
	public String getToStatus() {
		return toStatus;
	}

	/**
	 * @param toStatus the toStatus to set
	 */
	public void setToStatus(String toStatus) {
		this.toStatus = toStatus;
	}

	/**
	 * @return the fromLocation
	 */
	public String getFromLocation() {
		return fromLocation;
	}

	/**
	 * @param fromLocation the fromLocation to set
	 */
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	/**
	 * @return the toLocation
	 */
	public String getToLocation() {
		return toLocation;
	}

	/**
	 * @param toLocation the toLocation to set
	 */
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	/**
	 * @return the transitTime
	 */
	public String getTransitTime() {
		return transitTime;
	}

	/**
	 * @param transitTime the transitTime to set
	 */
	public void setTransitTime(String transitTime) {
		this.transitTime = transitTime;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return the maxUpdate
	 */
	public String getMaxUpdate() {
		return maxUpdate;
	}

	/**
	 * @param maxUpdate the maxUpdate to set
	 */
	public void setMaxUpdate(String maxUpdate) {
		this.maxUpdate = maxUpdate;
	}

	/**
	 * @return the maxUserid
	 */
	public String getMaxUserid() {
		return maxUserid;
	}

	/**
	 * @param maxUserid the maxUserid to set
	 */
	public void setMaxUserid(String maxUserid) {
		this.maxUserid = maxUserid;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFromStatus(JSPUtil.getParameter(request, "fromStatus", ""));
		setToStatus(JSPUtil.getParameter(request, "toStatus", ""));
		setFromLocation(JSPUtil.getParameter(request, "fromLocation", ""));
		setToLocation(JSPUtil.getParameter(request, "toLocation", ""));
		setTransitTime(JSPUtil.getParameter(request, "transitTime", ""));
		setMode(JSPUtil.getParameter(request, "mode", ""));
	}

}
