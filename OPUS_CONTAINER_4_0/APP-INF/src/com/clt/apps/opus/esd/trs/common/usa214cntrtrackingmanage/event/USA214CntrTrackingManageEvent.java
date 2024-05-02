/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : USA214CntrTrackingManageEvent.java
*@FileTitle : USA 214 CONTAINER TRACKING 
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-18
*@LastModifier : Park Jun-Yong
*@LastVersion : 1.0
* 2008-07-18 Park Jun-Yong
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.common.usa214cntrtrackingmanage.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * USA 214 CONTAINER TRACKING<br>
 * - TRS 테이블 갱신을 위해 SCEM에 제공하는 메소드<br>
 * 
 * @author Park Jun-Yong
 * @see SCEM 참조
 * @since J2EE 1.4
 */
public class USA214CntrTrackingManageEvent extends EventSupport {	
	private static final long serialVersionUID = 1L;
	private String sServiceOrderNo		= null;
	private String sWorkOrderNo			= null;
	private String sAppointmentDate		= null;
	private String sDeliveryDate		= null;
	private String sContainerNo			= null;
	
	
	/*
	 * @parm String sServiceOrderNo
	 */
	public void setSoNo(String sServiceOrderNo) {
		this.sServiceOrderNo 	= sServiceOrderNo;
	}
	
	/*
	 * @parm String sServiceOrderNo
	 */
	public String getSoNo() {
		return	this.sServiceOrderNo;
	}	
	
	/*
	 * @parm String sWorkOrderNo
	 */
	public void setWoNo(String sWorkOrderNo) {
		this.sWorkOrderNo 		= sWorkOrderNo;
	}
	
	/*
	 * @parm String sWorkOrderNo
	 */
	public String getWoNo() {
		return	this.sWorkOrderNo;
	}		
	
	/*
	 * @parm String sAppointmentDate
	 */
	public void setApntDt(String sAppointmentDate) {
		this.sAppointmentDate 	= sAppointmentDate;
	}
	
	/*
	 * @parm String sAppointmentDate
	 */
	public String getApntDt() {
		return	this.sAppointmentDate;
	}	
	
	/*
	 * @parm String sDeliveryDate
	 */
	public void setDeDt(String sDeliveryDate) {
		this.sDeliveryDate 		= sDeliveryDate;
	}
	
	/*
	 * @parm String sDeliveryDate
	 */
	public String getDeDt() {
		return	this.sDeliveryDate;
	}
	
	/*
	 * @parm String sContainerNo
	 */
	public void setCntrNo(String sContainerNo) {
		this.sContainerNo 		= sContainerNo;
	}
	
	/*
	 * @parm String sContainerNo
	 */
	public String getCntrNo() {
		return	this.sContainerNo;
	}
}
