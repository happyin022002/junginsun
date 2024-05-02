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
package com.hanjin.apps.alps.vop.fcm.performance.performance.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.fcm.performance.performance.vo.FcmMasterTableInquiryVO;
import com.hanjin.apps.alps.vop.fcm.performance.performance.vo.FcmMonFoilSavCostVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


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
	 * Monthly Fuel Saving Cost 정보를 조회한다.
	 * 
	 * @param FcmMonFoilSavCostVO fcmMonFoilSavCostVO
	 * @return List<FcmMonFoilSavCostVO>
	 * @exception EventException
	 */
	public List<FcmMonFoilSavCostVO> searchFcmMonFoilSavCostList(FcmMonFoilSavCostVO fcmMonFoilSavCostVO) throws EventException;
	
//	/**
//	 * Monthly Fuel Saving Cost 정보를 삭제한다.
//	 * 
//	 * @param List<FcmMonFoilSavCostVO> fcmMonFoilSavCostVOs
//	 * @return int
//	 * @exception EventException
//	 */
//	public int deleteFcmMonFoilSavCostList(List<FcmMonFoilSavCostVO> fcmMonFoilSavCostVOs) throws EventException;
	
	/**
	 * Monthly Fuel Saving Cost 정보를 생성한다.
	 * 
	 * @param List<FcmMonFoilSavCostVO> fcmMonFoilSavCostVOs
	 * @return int
	 * @exception EventException
	 */
	public int addFcmMonFoilSavCostList(List<FcmMonFoilSavCostVO> fcmMonFoilSavCostVOs) throws EventException;
	
	/**
	 * Monthly Fuel Saving Cost 정보가 기존재하는지 조회한다.
	 * 
	 * @param FcmMonFoilSavCostVO fcmMonFoilSavCostVO
	 * @return String
	 * @exception EventException
	 */
	public String searchFcmMonFoilSavCostExist(FcmMonFoilSavCostVO fcmMonFoilSavCostVO) throws EventException;
	
	/**
	 * Monthly Fuel Saving Cost 생성을 위하여 정보를 조회한다.
	 * 
	 * @param FcmMonFoilSavCostVO fcmMonFoilSavCostVO
	 * @return List<FcmMonFoilSavCostVO>
	 * @exception EventException
	 */
	public List<FcmMonFoilSavCostVO> searchFcmMonFoilSavCostForCre(FcmMonFoilSavCostVO fcmMonFoilSavCostVO) throws EventException;
	
	/**
	 * Monthly Fuel Saving Cost 생성.
	 * 
	 * @param FcmMonFoilSavCostVO[] fcmMonFoilSavCostVOs
	 * @param SignOnUserAccount account
	 * @param String inqVslSlanCd
	 * @exception EventException
	 */
	public void manageFcmMonFoilSavCostList(FcmMonFoilSavCostVO[] fcmMonFoilSavCostVOs, SignOnUserAccount account, String inqVslSlanCd) throws EventException;

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