/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeInvoiceBC.java
*@FileTitle : Requested Actual Invoice
*Open Issues : 
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.23 김진일
* 1.0 Creation
* 
* History
* 2012.03.22 진마리아 CHM-201216307-01 Canal invoice 화면 변경 및 File download 기능 개발
* 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가 - file download는 전도금이 아닌 invoice 화면으로 수정
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzOwnerAccountInterfaceVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.AtchFileVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlCondVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlByVvdOwnerAccountVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeSummaryVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Estimateinvoiceaudit Business Logic Command Interface<br>
 * - ALPS-Estimateinvoiceaudit에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jin Ihl
 * @see Vop_pso-0019EventResponse 참조
 * @since J2EE 1.6
 */

public interface CanalTransitFeeInvoiceBC {
	/**
	 * Requested Actual Invoice WindowOpen이벤트 조회 : SPP 로 부터 Requested 된 Actual Invoice  를 조회한다
	 * @category VOP_PSO_0019_windowOpen
	 * @param CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO
	 * @return List<CanalTzFeeInvDtlVO>
	 * @throws EventException
	 */
	public List<CanalTzFeeInvDtlVO> searchCanalTzFeeInvByVvd(
			CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO)
			throws EventException;
	
	/**
	 * Requested Actual Invoice WindowOpen이벤트 조회 : SPP 로 부터 OwnerAccount 계정만 Requested 된 Actual Invoice  를 조회한다
	 * @category VOP_PSO_0019_windowOpen
	 * @param CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO
	 * @return List<CanalTzFeeInvDtlByVvdOwnerAccountVO>
	 * @throws EventException
	 */
	public List<CanalTzFeeInvDtlByVvdOwnerAccountVO> searchCanalTzFeeInvByVvdOwnerAccount(
			CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO)
			throws EventException;
	
	/**
	 * Requested Actual Invoice 관련 atch file retrieve
	 * @category VOP_PSO-0215 Open
	 * @param AtchFileVO atchFileVO
	 * @return List<AtchFileVO>
	 */
	public List<AtchFileVO> searchAtchFileList(AtchFileVO atchFileVO) throws EventException;
	
	/**
	 * Requested Actual Invoice WindowOpen이벤트 조회 : summary data 조회
	 * @category VOP_PSO_0019_windowOpen
	 * @param CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO
	 * @return List<CanalTzFeeSummaryVO>
	 */
	public List<CanalTzFeeSummaryVO> searchCanalTzFeeSummary(CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO)  throws EventException;
	
	/**
	 * Tariff upload file 을 저장합니다.
	 * @category VOP_PSO_0215
	 * @param AtchFileVO atchFileVO
	 * @throws EventException
	 */	
	public void multiAtchFile(AtchFileVO atchFileVO) throws EventException;
	
	/**
	 * FMS 모듈에서 OA 비용에 대한 정보를 조회
	 * @param String vvd
	 * @return List<CanalTzOwnerAccountInterfaceVO>
	 * @throws EventException
	 */
	public List<CanalTzOwnerAccountInterfaceVO> searchCanalTzOwnerAccountInterface(String vvd) throws EventException ;
	
}