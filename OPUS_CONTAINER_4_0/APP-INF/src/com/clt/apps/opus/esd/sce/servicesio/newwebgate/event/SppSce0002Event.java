/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SPP_SCE_001Event.java
*@FileTitle : Movement Input
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-10
*@LastModifier : cho_gilhong@naver.com
*@LastVersion : 1.0
* 2007-07-10 cho_gilhong@naver.com
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.servicesio.newwebgate.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * SPP_SCE_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - WebGateIWSProxy에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author cho_gilhong
 * @see WebGateIWSProxy 참조
 * @since J2EE 1.4
 */
public class SppSce0002Event extends EventSupport {
	private static final long serialVersionUID = 1L;
    /** (Param 객체) */
    private String bkblNo = null;
    private String cntrNo = null;

    /**
     * default constructor
     */
    public SppSce0002Event() {}
    
    
    /**
     * constructor for SPP_SCE_002Event
     * 
     * @param bkbl_no
     * @param cntr_no
     */
    public SppSce0002Event(String bkbl_no,
    		            	String cntr_no
    		           ) {
    	this.bkblNo = bkbl_no;
    	this.cntrNo = cntr_no;
    }
    
    /**
     * get bkbl_no
     * 
     * @return String bkbl_no
     */
    public String getBkbl_no() {
    	return bkblNo;
    }
    /**
     * set bkbl_no
     * @param bkbl_no String
     */
    public void setBkbl_no(String bkbl_no) {
    	this.bkblNo = bkbl_no;
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
     * get event name
     * @return String
     */
    public String getEventName() {
        return "SPP_SCE_002Event";
    }
	/**
	 * toString
	 * @return String
	 */
    public String toString() {
        return "SPP_SCE_002Event";
    }
    
}