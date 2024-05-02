/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceBC
*@FileTitle : PerformanceBC
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.15 진마리아
* 1.0 Creation
* 
* History
* 2015.01.23 이병훈 [CHM-201430612] Fuel Consumption Master table 개발
=========================================================*/
package com.clt.apps.opus.vop.fcm.performance.performance.basic;

import java.util.List;

import com.clt.apps.opus.vop.fcm.performance.performance.vo.FcmMasterTableInquiryVO;
import com.clt.apps.opus.vop.fcm.performance.performance.vo.FcmMonFoilSavCostVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * ALPS-Performance Business Logic Command Interface<br>
 * - ALPS-Performance에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Ryu Hyuk
 * @see BudgetPlanEventResponse 참조
 * @since J2EE 1.6
 */
public interface PerformanceBC {

	/**
	 * Fuel Consumption Master Table Inquiry 정보를 조회합니다.<br>
	 * [CHM-201430612] Fuel Consumption Master table 개발
	 * 
	 * @param FcmMonFoilSavCostVO fcmMonFoilSavCostVO
	 * @return List<FcmMasterTableInquiryVO>
	 * @exception EventException
	 */
	public List<FcmMasterTableInquiryVO> searchFcmMasterTableInquiry(FcmMonFoilSavCostVO fcmMonFoilSavCostVO) throws EventException;
	
}
