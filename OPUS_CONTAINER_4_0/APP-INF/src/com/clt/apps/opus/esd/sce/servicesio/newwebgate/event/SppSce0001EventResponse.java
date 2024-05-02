/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SPP_SCE_001EventResponse.java
*@FileTitle : WebGate
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

import com.clt.framework.support.layer.event.EventResponseSupport;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - SPP_SCE_001 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 *
 * @author cho_gilhong
 * @see WebGateRSC 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("deprecation")
public class SppSce0001EventResponse extends EventResponseSupport {
	private static final long serialVersionUID = 1L;
    // Movement array
    private Movement[] mov = null;
    
    // Success Flag
    private String successFlag = null;
    
    // info
    private int successCount = 0;
    private int failCount = 0;
	
    /**
     * 객체 표현 문자열(SPP_SCE_001EventResponse)을 반환
     * 
     * @return String SPP_SCE_001EventResponse
     */
    public String toString() {
        return "SPP_SCE_001EventResponse";
    }

    /**
     * 이벤트 명(SPP_SCE_001EventResponse)을 반환
     * 
     * @return String SPP_SCE_001EventResponse
     */
    public String getEventName() {
        return "SPP_SCE_001EventResponse";
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
     * get Movement
     * 
     * @return Movement[] Movement array
     */
    public Movement[] getMov() {
    	Movement[] rtnVOs = null;
		if (this.mov != null) {
			rtnVOs = Arrays.copyOf(mov, mov.length);
		}
		return rtnVOs;
    }
    /**
     * set Movement
     * 
     * @param mov Movement array
     */
    public void setMov(Movement[] mov) {
		if(mov != null){
			Movement[] tmpVOs = Arrays.copyOf(mov, mov.length);
			this.mov = tmpVOs;
		}
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
    
    /**
     * get successFlag
     * 
     * @return String successFlag
     */
    public String getSuccessFlag() {
    	return successFlag;
    }
    /**
     * set successFlag
     * 
     * @param successFlag String
     */
    public void setSuccessFlag(String successFlag) {
    	this.successFlag = successFlag;
    }   
    
}