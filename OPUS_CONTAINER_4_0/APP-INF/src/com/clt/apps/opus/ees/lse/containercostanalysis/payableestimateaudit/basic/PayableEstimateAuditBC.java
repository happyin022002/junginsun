/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableEstimateAuditBC.java
*@FileTitle : Estimate expense
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.vo.EstimatedAuditVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Containercostanalysis Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_lse_0018EventResponse
 * @since J2EE 1.6
 */

public interface PayableEstimateAuditBC {

	/**
	 * retrieving for payable estimate audit<br>
	 * 
	 * @param EstimatedAuditVO	estimatedAuditVO
	 * @return List<EstimatedAuditVO>
	 * @exception EventException
	 */
	public List<EstimatedAuditVO> searchPayableEstimateAuditBasic(EstimatedAuditVO estimatedAuditVO) throws EventException;
	
	/**
	 * calculation payalbe estivate audit<br>
	 * 
	 * @param EstimatedAuditVO	estimatedAuditVO
	 * @return List<EstimatedAuditVO>
	 * @exception EventException
	 */
	public List<EstimatedAuditVO> calculationPayableEstimateAuditBasic(EstimatedAuditVO estimatedAuditVO ) throws EventException;

	/**
	 * saving payable estimate audit<br>
	 * 
	 * @param EstimatedAuditVO[] estimatedAuditVOs
	 * @param String yearMonth
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void savePayableEstimateAuditBasic(EstimatedAuditVO[] estimatedAuditVOs , String yearMonth , SignOnUserAccount account) throws EventException;

}