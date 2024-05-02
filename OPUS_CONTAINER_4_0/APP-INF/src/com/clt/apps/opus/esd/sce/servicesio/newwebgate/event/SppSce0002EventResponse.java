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
public class SppSce0002EventResponse extends EventResponseSupport {
	private static final long serialVersionUID = 1L;
    // Movement array
    private CntrMvmt[] mvmt 		= null;
    
    // Success Flag
    private String successFlag = null;
	
    /**
     * 객체 표현 문자열(SPP_SCE_001EventResponse)을 반환
     * 
     * @return String SPP_SCE_001EventResponse
     */
    public String toString() {
        return "SPP_SCE_002EventResponse";
    }

    /**
     * 이벤트 명(SPP_SCE_001EventResponse)을 반환
     * 
     * @return String SPP_SCE_001EventResponse
     */
    public String getEventName() {
        return "SPP_SCE_002EventResponse";
    }
    
    /**
     * SPP_SCE_002 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 SCE_CUP_008EventResponse 객체를 생성
     * @param mvmt
     * @param successFlag
     */
    public SppSce0002EventResponse(CntrMvmt[] mvmt, 
    		                        String successFlag) {
    	this.mvmt = mvmt;
        this.successFlag=successFlag;
    }
    
    /**
     * get Movement
     * 
     * @return Movement[] Movement array
     */
    public CntrMvmt[] getCntrMvmt() {
    	CntrMvmt[] rtnVOs = null;
		if (this.mvmt != null) {
			rtnVOs = Arrays.copyOf(mvmt, mvmt.length);
		}
		return rtnVOs;
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