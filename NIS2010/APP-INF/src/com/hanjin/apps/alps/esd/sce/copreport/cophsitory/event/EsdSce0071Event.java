/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce001Event.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-03
*@LastModifier : minestar
*@LastVersion : 1.0
* 2008-03-03 minestar
* 1.0 최초 생성
* 2009.09.03 - 오현경  - NIS2010 Construction 
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.cophsitory.event;

import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * EsdSce0071 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0071HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author minestar
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0071Event extends EventSupport {
	
	/** JSP에서 넘어온 파라마메터를 저장하는 dataset  */
    COPInquiryVO conditionVO = null;	
	/**
     * 생성자
     */
	public EsdSce0071Event(){}
	
    
	/**
     * 이벤트 명(EsdSce0071Event)을 반환
     * 
     * @return EsdSce0071Event
     */
    public String getEventName() {
        return "EsdSce0071Event";
    }

    /**
     * 객체 표현 문자열(EsdSce0071Event)을 반환
     * 
     * @return String EsdSce0071Event
     */
    public String toString() {
        return "EsdSce0071Event";
    }
	/**
	 * 조회조건 저장
	 * @param conditionVO
	 */
	public void setConditionVO(COPInquiryVO conditionVO){
		this.conditionVO = conditionVO;
	}
	/**
	 * 조회조건 반환
	 * @return
	 */
	public COPInquiryVO getConditionVO(){
		return conditionVO;
	} 
}
