/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USDemurrageAuditBC.java
*@FileTitle : 3rd Party DEM/DET Collection Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.08.25 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.vo.ChargeForAuditParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.vo.ChargeForAuditVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Dmtinvoicemgt Business Logic Command Interface<br>
 * - ALPS-Dmtinvoicemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Choi Sung Hwan
 * @see Ees_dmt_4005EventResponse 참조
 * @since J2EE 1.6
 */

public interface USDemurrageAuditBC {

	/**
	 * [3rd Party DEM/DET Collection Audit]을 [조회] 합니다.<br>
	 * 
	 * @param ChargeForAuditParmVO[] chargeForAuditParmVOS
	 * @return List<ChargeForAuditParmVO> Audit 결과 리스트
	 * @exception EventException
	 */
	public List<ChargeForAuditVO> searchChargeForAudit(ChargeForAuditParmVO[] chargeForAuditParmVOS) throws EventException;
}