/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTSecurityBC.java
*@FileTitle : Security & AR Office
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtsecurity.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AgtFincOfcInfoVO;

/**
 * OPUS-Agtmaster Business Logic Command Interface<br>
 * - OPUS-Agtmaster handling Business Logic Command Interface<br>
 *
 * @author Kyung-won Chu
 * @see Esm_agt_0038EventResponse 
 * @since J2EE 1.6
 */

public interface AGTSecurityBC {

	/**
	 * ESM_AGT_0038 retrieve event process<br>
	 * 
	 * @param AgtFincOfcInfoVO agtFincOfcInfoVO
	 * @return List<AgtFincOfcInfoVO>
	 * @exception EventException
	 */
	public List<AgtFincOfcInfoVO> searchAROfficeInfoList(AgtFincOfcInfoVO agtFincOfcInfoVO) throws EventException;
	
	/**
	 * ESM_AGT_0038 multi event process<br>
	 * 
	 * @param AgtFincOfcInfoVO[] agtFincOfcInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAROfficeInfobyOffice(AgtFincOfcInfoVO[] agtFincOfcInfoVO,SignOnUserAccount account) throws EventException;
}