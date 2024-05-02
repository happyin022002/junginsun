/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MovementResponse.java
*@FileTitle : Movement Response
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-10
*@LastModifier : cho_gilhong@naver.com
*@LastVersion : 1.0
* 2007-07-10 cho_gilhong@naver.com
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio.newwebgate.event;
 
/**
 * SPP_SCE_002Response 에 대한 WebService Document Object including Parameters<br>
 * - WebGateIWSProxy의 Output Parameter<br>
 * - SPP_SCE_002EventResponse에서 변환하여 사용<br>
 *
 * @author cho_gilhong
 * @see WebGateIWSProxy 참조
 * @since J2EE 1.4
 */
public class CntrMvmtResponse {
    /** (Header) */
    
	private String id = "CntrMvmtResponse";
    private String status = null;
    
    /** (Param 객체) */
    private CntrMvmt[] movement = null;
    
    /**
     * get id
     * 
     * @return String id
     */
    public String getId() {
    	return id;
    }
    
    /**
     * set id
     * 
     * @param id String
     */
    public void setId(String id) {
    	this.id = id;
    }
    
    /**
     * get Movement
     * 
     * @return Movement[] Movement array
     */
    public CntrMvmt[] getMovement() {
    	return movement;
    }
    
    /**
     * set Movement
     * 
     * @param movement Movement array
     */
    public void setMovement(CntrMvmt[] movement) {
    	this.movement = movement;
    }
    
    /**
     * get status
     * 
     * @return String status
     */
    public String getStatus() {
    	return status;
    }
    
    /**
     * set status
     * 
     * @param status String
     */
    public void setStatus(String status) {
    	this.status = status;
    }
    
}