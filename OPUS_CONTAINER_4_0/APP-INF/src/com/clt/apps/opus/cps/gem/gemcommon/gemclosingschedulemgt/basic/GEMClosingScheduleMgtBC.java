/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMClosingScheduleMgtBC.java
*@FileTitle : Closing Confirmation & Interface Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.22
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.22 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemclosingschedulemgt.basic;

import java.util.List;

import com.clt.apps.opus.cps.gem.gemcommon.gemclosingschedulemgt.vo.MonClzVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * NIS2010-Gemcommon Business Logic Command Interface<br>
 * - NIS2010-Gemcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author choijungmi
 * @see Cps_gem_0006EventResponse 참조
 * @since J2EE 1.4
 */

public interface GEMClosingScheduleMgtBC 
{    
	// C.J.M
	// ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0006] Closing Confirmation & Interface Status
	// ---------------------------------------------------------------------------

    /**
     * CPS_GEM_0006 조회 이벤트 처리<br>
	 * CPS_GEM_0006 화면에 대한 조회 이벤트 처리<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0006
     * @category searchClosingInfo
     * 
     * @param String year
     * @return EventResponse Cps_gem_0006EventResponse
     * @exception EventException
     */
    public List<MonClzVO> searchClosingInfo(String year) throws EventException;
    
    /**
	 * CPS_GEM_0006 멀티 이벤트 처리<br>
	 * CPS_GEM_0006 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
     * @category CPS_GEM_0006k
     * @category manageClosingInfo
     * @param MonClzVO[] monClzVOs
	 * @param String userId 
	 * @exception EventException
	 */
	public void manageClosingInfo(MonClzVO[] monClzVOs, String userId) throws EventException;
}