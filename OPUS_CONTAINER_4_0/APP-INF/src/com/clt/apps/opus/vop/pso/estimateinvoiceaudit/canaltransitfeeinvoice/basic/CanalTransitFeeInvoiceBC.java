/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CanalTransitFeeInvoiceBC.java
 *@FileTitle : CanalTransitFeeInvoiceBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.04
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.06.08 박명종
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.basic;

import java.util.List;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlCondVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * ALPS-Estimateinvoiceaudit Business Logic Command Interface<br>
 *
 * @author 
 * @see Reference Vop_pso-0019EventResponse 
 * @since J2EE 1.6
 */

public interface CanalTransitFeeInvoiceBC {
	/**
	 * Retrieve Actual Invoice requested by SPP : Retrieve Requested Actual Invoice WindowOpen event 
	 * @category VOP_PSO_0019_windowOpen
	 * @param CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO
	 * @return List<CanalTzFeeInvDtlVO>
	 * @throws EventException
	 */
	public List<CanalTzFeeInvDtlVO> searchCanalTzFeeInvByVvd(
			CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO)
			throws EventException;
}