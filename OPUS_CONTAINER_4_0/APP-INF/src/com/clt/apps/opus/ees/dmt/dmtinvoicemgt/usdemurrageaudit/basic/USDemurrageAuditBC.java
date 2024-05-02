/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USDemurrageAuditBC.java
*@FileTitle : 3rd Party DEM/DET Collection Audit
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.vo.ChargeForAuditParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.vo.ChargeForAuditVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Dmtinvoicemgt Business Logic Command Interface<br>
 *
 * @author
 * @see reference Ees_dmt_4005EventResponse 
 * @since J2EE 1.6
 */

public interface USDemurrageAuditBC {

	/**
	 *  Search 3rd Party DEM/DET Collection Audit.<br>
	 * 
	 * @param ChargeForAuditParmVO[] chargeForAuditParmVOS
	 * @return List<ChargeForAuditParmVO> 
	 * @exception EventException
	 */
	public List<ChargeForAuditVO> searchChargeForAudit(ChargeForAuditParmVO[] chargeForAuditParmVOS) throws EventException;
}
