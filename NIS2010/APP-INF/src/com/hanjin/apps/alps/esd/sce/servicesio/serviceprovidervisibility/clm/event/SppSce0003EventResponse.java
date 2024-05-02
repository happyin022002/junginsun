/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SPP_SCE_003EventResponse.java
*@FileTitle : ServiceProvicerVisibility Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-02
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.event;

import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * SPP-SCE PDTO(Data Transfer Object including Parameters)<br>
 * - SPP-SCE에 대한 데이터 전달하는 PDTO로 사용<br>
 *
 * @author yeon-jin park
 * @see SppSce0003EventResponse 참조
 * @since J2EE 1.4
 */
public class SppSce0003EventResponse extends EventResponseSupport {
    // Movement array
    private ClmInquiry[] cntrClm 		= null;
    
    // Success Flag
    private String successFlag = null;

    // 전체 카운트
    private int totalCount = 0;
   /**
     * 객체 표현 문자열(SPP_SCE_003EventResponse)을 반환
     * 
     * @return String SPP_SCE_003EventResponse
     */
    public String toString() {
        return "SPP_SCE_003EventResponse";
    }

    /**
     * 이벤트 명(SPP_SCE_003EventResponse)을 반환
     * 
     * @return String SPP_SCE_003EventResponse
     */
	public String getEventName() {
		return "SPP_SCE_003EventResponse";
	}
    /**
     * SPP_SCE_003 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 SPP_SCE_003EventResponse 객체를 생성
     * @param cntrClm ClmInquiry[] 
     * @param successFlag String 
     */
    public SppSce0003EventResponse(ClmInquiry[] cntrClm, 
            						String successFlag) {
		this.cntrClm = cntrClm;
		this.successFlag=successFlag;
	}
    
    /**
     * get CLMInquiry
     * 
     * @return CLMInquiry[] cntrclm
     */
   public ClmInquiry[] getCntrClm(){
    	return cntrClm;
    	
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
    /**
     * get totalCount
     * 
     * @return String totalCount
     */
    public int getTotalCount() {
    	return totalCount;
    }
    /**
     * set totalCount
     * 
     * @param totalCount String
     */
    public void setTotalCount(int totalCount) {
    	this.totalCount = totalCount;
    }   

}
