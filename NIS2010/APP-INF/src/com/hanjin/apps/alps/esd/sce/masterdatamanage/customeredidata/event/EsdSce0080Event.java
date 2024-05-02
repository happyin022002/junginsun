/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdSce0080Event.java
*@FileTitle : EsdSce0080
*Open Issues :
*Change history :
*@LastModifyDate : 2009-010-10
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009-10-10 김성일
* 1.0 최초 생성
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEstimationListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdSce0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author sanghyun_kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsdSce0080Event extends EventSupport {


	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEstimationListVO searchEstimationListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEstimationListVO[] searchEstimationListVOs = null;	
	
	private HashMap parameterMap = null;
	/**
	 * 생성자
	 */
	public EsdSce0080Event(){}
    
    /**
     * 이벤트 명(EsdSce0080Event)을 반환
     * 
     * @return EsdSce0080Event
     */
    public String getEventName() {
        return "EsdSce0080Event";
    }

    /**
     * 객체 표현 문자열(EsdSce0080Event)을 반환
     * 
     * @return String EsdSce0080Event
     */
    public String toString() {
        return "EsdSce0080Event";
    }
	public SearchEstimationListVO getSearchEstimationListVO(){
		return searchEstimationListVO;
	}

	public SearchEstimationListVO[] getSearchEstimationListVOS(){
		return searchEstimationListVOs;
	}	
	public void setSearchEstimationListVO(SearchEstimationListVO searchEstimationListVO){
		this. searchEstimationListVO = searchEstimationListVO;
	}

	public void setSearchEstimationListVOS(SearchEstimationListVO[] searchEstimationListVOs){
		this. searchEstimationListVOs = searchEstimationListVOs;
	}
	
	/**
	 * @return Returns the parameterMap.
	 */
	public HashMap getParameterMap() {
		return parameterMap;
	}
	
	/** 
     * @param parameterMap
     */
	public void setParameterMap(HashMap parameterMap) {
		this.parameterMap = parameterMap;
	}

}
