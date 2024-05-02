/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SPP_SCE_003Event.java
*@FileTitle : ServiceProvicerVisibility Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-02
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * SPP-SCE PDTO(Data Transfer Object including Parameters)<br>
 * - SPP-SCE에 대한 데이터 전달하는 PDTO로 사용<br>
 *
 * @author yeon-jin park
 * @see SppSce0003EventResponse 참조
 * @since J2EE 1.4
 */
public class SppSce0003Event extends EventSupport {
    /** (Param 객체) */
    private String bkgNo = null;
    private String cntrNo = null;
    private String copNo = null;

    /**
     * default constructor
     */
    public SppSce0003Event() {}
    
    /**
     * constructor for SPP_SCE_002Event
     * 
     * @param bkg_no String
     * @param cntr_no String
     * @param cop_no String
     */
    public SppSce0003Event(String bkg_no,
    		            	String cntr_no,
    		            	String cop_no
    		           ) {
    	this.bkgNo = bkg_no;
    	this.cntrNo = cntr_no;
    	this.copNo	= cop_no;
    }
    
    /**
     * get bkbl_no
     * 
     * @return String bkbl_no
     */
    public String getBkg_no() {
    	return bkgNo;
    }
    /**
     * set bkbl_no
     * @param bkbl_no String
     */
    public void setBkg_no(String bkg_no) {
    	this.bkgNo = bkg_no;
    }
   
    /**
     * get cntr_no
     * 
     * @return String cntr_no
     */
    public String getCntr_no() {
    	return cntrNo;
    }
    /**
     * set cntr_no
     * 
     * @param cntr_no String
     */
    public void setCntr_no(String cntr_no) {
    	this.cntrNo = cntr_no;
    }
    
    
    /**
     * get cop_no
     * 
     * @return String cop_no
     */
    public String getCop_no() {
    	return copNo;
    }
    /**
     * set cop_no
     * 
     * @param cop_no String
     */
    public void setCop_no(String cop_no) {
    	this.copNo = cop_no;
    }
    /**
     * get event name
     * @return String
     */
    public String getEventName() {
        return "SPP_SCE_003Event";
    }
	/**
	 * toString
	 * @return String
	 */
    public String toString() {
        return "SPP_SCE_003Event";
    }
     

}
