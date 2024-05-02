/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0005Event.java
*@FileTitle : WO Inquiry
*Open Issues :
*Change history :
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
*@LastModifyDate : 2007-08-03
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.1
* 2006-11-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.event;


import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EXP_PAP_005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EXP_PAP_005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author juhyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ExpPap0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String userID = "";
	private String vendorCode = "";
	private String mainFlag = "";
	private String groupId = "";
 	private String parentVendorCode = "";
		
	
	
	/**
	 * @return Returns the parentVendorCode.
	 */
	public String getParentVendorCode() {
		return parentVendorCode;
	}



	/**
	 * @param parentVendorCode The parentVendorCode to set.
	 */
	public void setParentVendorCode(String parentVendorCode) {
		this.parentVendorCode = parentVendorCode;
	}



	/**
	 * @return Returns the groupId.
	 */
	public String getGroupId() {
		return groupId;
	}



	/**
	 * @param groupId The groupId to set.
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}



	/**
	 * @return Returns the mainFlag.
	 */
	public String getMainFlag() {
		return mainFlag;
	}



	/**
	 * @param mainFlag The mainFlag to set.
	 */
	public void setMainFlag(String mainFlag) {
		this.mainFlag = mainFlag;
	}



	/**
	 * 
	 * @return
	 */
	public ExpPap0005Event(){}



    /** 
     * ExpPap0005Event 생성자
     * 
     * @param userID
     * @param vendorCode
     * @param mainFlag
     * @param groupId
     * @param parentVendorCode
     */
    public ExpPap0005Event(String userID,	String vendorCode, String mainFlag, String groupId, String parentVendorCode) {
    	this.userID = userID;
    	this.vendorCode = vendorCode;
    	this.mainFlag = mainFlag;
    	this.parentVendorCode = parentVendorCode;
    	this.groupId = groupId;
    }


    /**
     * getUserID<br>
     * 
     * @param void
     * @return userID String
     * @exception 
     */
	public String getUserID() {
		return userID;
	}
    /**
     * setUserID<br>
     * 
     * @param userID String
     * @return void
     * @exception 
     */
	public void setUserID(String userID) {
		this.userID = userID;
	}
    /**
     * getVendorCode<br>
     * 
     * @param void
     * @return vendorCode String
     * @exception 
     */
	public String getVendorCode() {
		return vendorCode;
	}
    /**
     * setVendorCode<br>
     * 
     * @param vendorCode String
     * @return void
     * @exception 
     */
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}



	/**
	 * @return 
	 */
    public String getEventName() {
        return "ExpPap0005Event";
    }

	/**
	 * @return 
	 */
    public String toString() {
        return "ExpPap0005Event";
    }	

    
}
