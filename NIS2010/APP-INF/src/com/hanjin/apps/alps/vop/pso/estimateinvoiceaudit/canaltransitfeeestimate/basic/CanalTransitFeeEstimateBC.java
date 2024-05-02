/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeEstimateBC.java
*@FileTitle : Requested Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.15 김진일
* 1.0 Creation
* 
* History
* 2012.02.01 진마리아 CHM-201215859-01 전도금 비용 수정 기능 추가 요청건(spp로부터 입력받는 전도금을 alps 화면을 통해 수정하여 저장 가능하도록)
* 2012.03.09 진마리아 CHM-201216307-01 Canal invoice 화면 변경 및 File download 기능 개발
* 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가 - file download는 전도금이 아닌 invoice 화면으로 수정
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidOwnerAccountVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdCondVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeHdVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeSumVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Estimateinvoiceaudit Business Logic Command Interface<br>
 * - ALPS-Estimateinvoiceaudit에 대한 비지니스 로직에 대한 인터페이스<br>
 * @author Kim Jin Ihl
 * @see Vop_pso-0018EventResponse 참조
 * @since J2EE 1.6
 */

public interface CanalTransitFeeEstimateBC {
	
	/**
	 * Requested Advance Payment 취소처리
	 * @category VOP_PSO_0018_reject_button_click
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 */
	public void cancelCanalTzFeeEst(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException;
			
	/**
	 * Requested Advanced Payment Confirm@CLICK
	 * InvoiceNo를 계산하여 가져온다. 
	 * @category VOP_PSO_0018_Confirm_CLICK
	 * @param CanalTzFeeHdVO canalTzFeeHdVO
	 * @return String
	 * @throws EventException
	 */
	public String createCanalTzFeeEst ( CanalTzFeeHdVO canalTzFeeHdVO ) throws EventException;
	
	/**
	 * VVD별로 Estimate Canal Transit Fee를 조회한다. 
	 * @category VOP_PSO_0018_windows_open
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return List<CanalTzFeeEstDtlByVvdVO>
	 * @throws EventException
	 */
	public List<CanalTzFeeEstDtlByVvdVO> searchCanalTzFeeEstDtlByVvd(CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException;
	/**
	 * Canal Invoice 조회
	 * @category VOP_PSO_0017_Retrieve
	 * @param CanalTzFeeSumVO canalTzFeeSumVO
	 * @return List<CanalTzFeeSumVO>
	 */
	public List<CanalTzFeeSumVO> searchCanalTzFeeSumRpt(CanalTzFeeSumVO canalTzFeeSumVO) throws EventException;
	/**
	 * CanalTzFee 및 CanalTzFeeDtl의 정보를 갱신한다.
	 * @param AuditDataValidVO[] auditDataValidVOs
	 */
	public void manageCanalTzFee(AuditDataValidVO[] auditDataValidVOs)  throws EventException;
	/**
	 * CanalTzFee 및 CanalTzFeeDtl의 정보를 갱신한다.(OA비용만)
	 * @param AuditDataValidOwnerAccountVO[] auditDataValidOwnerAccountVOs
	 */
	public void manageCanalTzFeeOwnerAccount(AuditDataValidOwnerAccountVO[] auditDataValidOwnerAccountVOs)  throws EventException;

	/**
	 * Remark항목을 update한다. 
	 * @param auditDataValidVOs
	 * @throws EventException
	 */
	public void modifyRemark(AuditDataValidVO[] auditDataValidVOs)  throws EventException;
	
	/**
	 * Remark항목을 update한다. - OA 비용에 한해서.
	 * @param auditDataValidOwnerAccountVOs
	 * @throws EventException
	 */
	public void modifyRemarkOwnerAccount(AuditDataValidOwnerAccountVO[] auditDataValidOwnerAccountVOs)  throws EventException;
	
	/**
	 * CanalTzFeeDtl의 Rqst Amt, Rmk 정보를 갱신한다.
	 * @category VOP_PSO_0018_SaveClick
	 * @param AuditDataValidVO[] auditDataValidVOs
	 * @throws EventException
	 */
	public void manageCanalTzFeeRqstAmt(AuditDataValidVO[] auditDataValidVOs) throws EventException;

}