/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : PlanningInquiryBC.java
*@FileTitle      : PlanningInquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.29
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.29 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.vo.SearchPlanningQtaIasSectorVO;
import com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.vo.SearchQtaInquiryListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-QtaInquiry Business Logic Command Interface<br>
 * - ALPS-PlanningInquiry 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
 * @see
 * @since J2EE 1.6
 */
public interface PlanningInquiryBC {
	
/**
 * ESM_SQM_0029 : Retrieve 이벤트 처리<br>
 * [QTA Inquiry_Yearly Planning]을 [조회] 합니다
 * 
 * @param ConditionVO conditionVO
 * @return List<SearchQtaInquiryListVO>
 * @throws EventException
 */
public List<SearchQtaInquiryListVO> searchQtaInquiryList(ConditionVO conditionVO) throws EventException;

/**
 * ESM_SQM_0217 : [Retrieve]<br>
 * [Planning QTA Inquiry_Yearly Planning_IAS Sector]을 [조회] 합니다.<br>
 * 
 * @param ConditionVO conditionVO
 * @return List<SearchPlanningQtaIasSectorVO>
 * @throws EventException
 */
public List<SearchPlanningQtaIasSectorVO> searchPlanningQtaYrIasSector(ConditionVO conditionVO) throws EventException;

/**
 * ESM_SQM_0218 : [Retrieve]<br>
 * [Planning QTA Inquiry_Quarterly Planning_IAS Sector]을 [조회] 합니다.<br>
 * 
 * @param ConditionVO conditionVO
 * @return List<SearchPlanningQtaIasSectorVO>
 * @throws EventException
 */
public List<SearchPlanningQtaIasSectorVO> searchPlanningQtaQtrIasSector(ConditionVO conditionVO) throws EventException;
}