/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonBC.java
*@FileTitle : : LEA CommonBC
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : junghyung kim
*@LastVersion : 1.0
* 2006-08-25 junghyung kim
* 1.0 최초 생성
* @History
* 2009-09-08 : Ho-Jin Lee Alps 전환
* 2011-05-02 이정수 : Office COMBO가 정상적으로 생성되도록 수정
=========================================================*/
package com.hanjin.apps.alps.esd.lea.common.codecomboutil.basic;

import com.hanjin.framework.core.layer.event.EventException;


/**
 *
 * @author junghyung kim
 * @see CommonBCImpl 참조
 * @since J2EE 1.4
 */
public interface CommonBC {
	
	/**
     * 해당 Logistics Office 에 대한 Sub Office List 정보를 조회한다.
     * 
     * @param String ctrlOfcCd
     * @return String
     * @throws EventException
     */
    public String searchLogisticsSubOfficeCodeList(String ctrlOfcCd) throws EventException;
    
	/**
     * 해당 RHQ 에 대한 Control Office List 정보를 조회한다.
     * 
     * @param String rhqCd
     * @return String
     * @throws EventException
     */
    public String searchCtrlOfficeCodeList(String rhqCd) throws EventException;
	
}