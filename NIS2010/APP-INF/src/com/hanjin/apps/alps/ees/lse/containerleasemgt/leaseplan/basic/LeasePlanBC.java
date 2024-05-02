/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeasePlanBC.java
*@FileTitle : Long Term Lease CNTR Delivery Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.LeasePlanPerformanceDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.LeasePlanPerformanceVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.LeasePlanVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePerformanceVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanRccVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanSearchVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.PlanSearchVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Containerleasemgt Business Logic Command Interface<br>
 * - ALPS-Containerleasemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Nho Jung Yong
 * @see Ui_lse_0048EventResponse 참조
 * @since J2EE 1.4
 */

public interface LeasePlanBC {
	/**
	 * Long Term Lease CNTR Delivery Plan 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanVO>
	 * @exception EventException
	 */
	public List<LeasePlanVO> searchLongTermCNTRDeliveryPlanBasic(PlanSearchVO planSearchVO) throws EventException;

	/**
	 *  Long Term Lease Delivery Plan 데이타 건수 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return int
	 * @exception EventException
	 */
	public int searchLongTermCNTRDeliveryPlanAgreementCheckBasic(PlanSearchVO planSearchVO) throws EventException;

	/**
	 * Long Term Lease Delivery Performance 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanPerformanceVO>
	 * @exception EventException
	 */
	public List<LeasePlanPerformanceVO> searchLongTermCNTRDeliveryPerformanceBasic(PlanSearchVO planSearchVO) throws EventException;

	/**
	 * Long Term Lease CNTR Delivery Plan & Performance 화면의 Container Detail 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanPerformanceDetailVO>
	 * @exception EventException
	 */
	public List<LeasePlanPerformanceDetailVO> searchLongTermCNTRDeliveryPerformanceDetailBasic(PlanSearchVO planSearchVO) throws EventException;

	/**
	 * Long Term Lease CNTR Delivery Plan 데이터 저장합니다.<br>
	 *
	 * @param PlanSearchVO planSearchVO
	 * @param LeasePlanVO[] leasePlanVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLongTermCNTRDeliveryPlanBasic(PlanSearchVO planSearchVO, LeasePlanVO[] leasePlanVOs, SignOnUserAccount account) throws EventException;


	/**
	 * Off-Hire Plan Input &amp; Update by H/Q 조회합니다.<br>
	 *
	 * @param  OffHirePlanSearchVO offHirePlanSearchVO
	 * @return List<OffHirePlanVO>
	 * @throws EventException
	 */
	public List<OffHirePlanVO> searchOffHirePlanBasic(OffHirePlanSearchVO offHirePlanSearchVO) throws EventException;

	/**
	 * Off-Hire Plan Input &amp; Update by H/Q 데이터 저장합니다.<br>
	 *
	 * @param OffHirePlanVO[] offHirePlanVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageOffHirePlanBasic(OffHirePlanVO[] offHirePlanVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Off Hire Plan Input &amp; Update by H/Q 의 Version 생성합니다.<br>
	 *
	 * @param OffHirePlanSearchVO offHirePlanSearchVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createOffHirePlanNewVerBasic(OffHirePlanSearchVO offHirePlanSearchVO, SignOnUserAccount account) throws EventException;

	/**
	 * 입력받은 AGMT No.에 대한 유효성을 검증합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return String
	 * @exception EventException
	 */
	public String searchNewVanCNTRDeliveryPlanAvailBasic(PlanSearchVO planSearchVO) throws EventException;

	/**
	 * 신조장비(OW/LP/OL) 계획목록을 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanVO>
	 * @exception EventException
	 */
	public List<LeasePlanVO> searchNewVanCNTRDeliveryPlanListBasic(PlanSearchVO planSearchVO) throws EventException;

	/**
	 * 신조장비(OW/LP/OL) 계획목록을 일괄 저장합니다.<br>
	 *
	 * @param LeasePlanVO[] leasePlanVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageNewVanCNTRDeliveryPlanListBasic(LeasePlanVO[] leasePlanVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * 신조(자가/장기)장비 인수계획 대비 실적목록을 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanPerformanceVO>
	 * @exception EventException
	 */
	public List<LeasePlanPerformanceVO> searchNewVanCNTRDeliveryPlanPerformanceListBasic(PlanSearchVO planSearchVO) throws EventException;

	/**
	 * 신조(자가/장기)장비 인수계획 대비 실적별 상세내역을 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanPerformanceDetailVO>
	 * @exception EventException
	 */
	public List<LeasePlanPerformanceDetailVO> searchNewVanCNTRDeliveryPlanPerformanceDetailBasic(PlanSearchVO planSearchVO) throws EventException;

	/**
	 * Off-Hire Plan Input &amp; Update by RCC 조회합니다.<br>
	 *
	 * @param  OffHirePlanSearchVO offHirePlanSearchVO
	 * @return List<OffHirePlanRccVO>
	 * @throws EventException
	 */
	public List<OffHirePlanRccVO> searchOffHirePlanByRCCBasic(OffHirePlanSearchVO offHirePlanSearchVO) throws EventException;

	/**
	 * Off Hire Plan Input &amp; Update by RCC 데이터 저장합니다.<br>
	 *
	 * @param OffHirePlanSearchVO offHirePlanSearchVO
	 * @param OffHirePlanRccVO[] offHirePlanRccVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageOffHirePlanByRCCBasic(OffHirePlanSearchVO offHirePlanSearchVO, OffHirePlanRccVO[] offHirePlanRccVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Off-Hire Plan & Performance 조회합니다.<br>
	 *
	 * @param  OffHirePlanSearchVO searchOffHirePlanVO
	 * @return List<LeasePlanPerformanceVO>
	 * @exception EventException
	 */
	public List<OffHirePerformanceVO> searchOffHirePerformanceBasic(OffHirePlanSearchVO searchOffHirePlanVO) throws EventException;

	/**
	 * Off Hire Plan Input &amp; Update by RCC DOL 팝업 조회합니다.<br>
	 *
	 * @param  OffHirePlanSearchVO searchOffHirePlanVO
	 * @return List<OffHirePlanRccVO>
	 * @throws EventException
	 */
	public List<OffHirePlanRccVO> searchOffHirePlanByRCCDOLBasic(OffHirePlanSearchVO searchOffHirePlanVO) throws EventException;
}