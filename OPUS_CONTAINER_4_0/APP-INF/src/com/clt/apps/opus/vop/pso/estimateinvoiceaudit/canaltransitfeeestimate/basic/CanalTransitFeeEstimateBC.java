/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CanalTransitFeeEstimateBC.java
 *@FileTitle : CanalTransitFeeEstimateBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.04
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.06.08 박명종
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.basic;

import java.util.List;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdCondVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeHdVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeSumVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * ALPS-Estimateinvoiceaudit Business Logic Command Interface<br>
 *
 * @author
 * @see Reference Vop_pso-0018EventResponse 
 * @since J2EE 1.6
 */

public interface CanalTransitFeeEstimateBC {
	
	/**
	 * Cancel Requested Advance Payment 
	 * @category VOP_PSO_0018_reject_button_click
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 */
	public void cancelCanalTzFeeEst(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException;
			
	/**
	 * Requested Advanced Payment Confirm@CLICK
	 * get InvoiceNo calculated 
	 * @category VOP_PSO_0018_Confirm_CLICK
	 * @param CanalTzFeeHdVO canalTzFeeHdVO
	 * @return String
	 * @throws EventException
	 */
	public String createCanalTzFeeEst ( CanalTzFeeHdVO canalTzFeeHdVO ) throws EventException;
	
	/**
	 * retrieve Estimate Canal Transit Fee by VVD 
	 * @category VOP_PSO_0018_windows_open
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return List<CanalTzFeeEstDtlByVvdVO>
	 * @throws EventException
	 */
	public List<CanalTzFeeEstDtlByVvdVO> searchCanalTzFeeEstDtlByVvd(CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException;
	/**
	 * retrieve Canal Invoice 
	 * @category VOP_PSO_0017_Retrieve
	 * @param CanalTzFeeSumVO canalTzFeeSumVO
	 * @return List<CanalTzFeeSumVO>
	 */
	public List<CanalTzFeeSumVO> searchCanalTzFeeSumRpt(CanalTzFeeSumVO canalTzFeeSumVO) throws EventException;
	/**
	 * Renew CanalTzFee and CanalTzFeeDtl info
	 * @param AuditDataValidVO[] auditDataValidVOs
	 */
	public void manageCanalTzFee(AuditDataValidVO[] auditDataValidVOs)  throws EventException;

	/**
	 * update Remark item 
	 * @param auditDataValidVOs
	 * @throws EventException
	 */
	public void modifyRemark(AuditDataValidVO[] auditDataValidVOs)  throws EventException;

}