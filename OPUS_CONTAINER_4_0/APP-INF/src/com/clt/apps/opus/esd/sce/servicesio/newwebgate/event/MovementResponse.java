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
package com.clt.apps.opus.esd.sce.servicesio.newwebgate.event;

import java.util.Arrays;
 
/**
 * SPP_SCE_001Response 에 대한 WebService Document Object including Parameters<br>
 * - WebGateIWSProxy의 Output Parameter<br>
 * - SPP_SCE_001EventResponse에서 변환하여 사용<br>
 *
 * @author cho_gilhong
 * @see WebGateIWSProxy 참조
 * @since J2EE 1.4
 */
public class MovementResponse {
    /** (Header) */
    private String id = "MovementResponse";
    private String status = null;
    private int successCount = 0;
    private int failCount = 0;
    
    /** (Param 객체) */
    private Movement[] movement = null;
    
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
    public Movement[] getMovement() {
    	Movement[] rtnVOs = null;
		if (this.movement != null) {
			rtnVOs = Arrays.copyOf(movement, movement.length);
		}
		return rtnVOs;
    }
    
    /**
     * set Movement
     * 
     * @param movement Movement array
     */
    public void setMovement(Movement[] movement) {
		if(movement != null){
			Movement[] tmpVOs = Arrays.copyOf(movement, movement.length);
			this.movement = tmpVOs;
		}
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
    
    /**
     * get fail count
     * 
     * @return int fail count
     */
    public int getFail_count() {
    	return failCount;
    }
    
    /**
     * set fail count
     * 
     * @param fail_count int
     */
    public void setFail_count(int fail_count) {
    	this.failCount = fail_count;
    }
    
    /**
     * get success count
     * 
     * @return int success count
     */
    public int getSuccess_count() {
    	return successCount;
    }
    
    /**
     * set success count
     * 
     * @param success_count int
     */
    public void setSuccess_count(int success_count) {
    	this.successCount = success_count;
    }
    
}