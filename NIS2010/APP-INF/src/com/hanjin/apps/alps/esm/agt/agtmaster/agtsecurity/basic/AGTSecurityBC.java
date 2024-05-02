/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTSecurityBC.java
*@FileTitle : Security & AR Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.14 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtsecurity.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.AgtFincOfcInfoVO;

/**
 * ALPS-Agtmaster Business Logic Command Interface<br>
 * - ALPS-Agtmaster에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kyung-won Chu
 * @see Esm_agt_0038EventResponse 참조
 * @since J2EE 1.6
 */

public interface AGTSecurityBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param AgtFincOfcInfoVO agtFincOfcInfoVO
	 * @return List<AgtFincOfcInfoVO>
	 * @exception EventException
	 */
	public List<AgtFincOfcInfoVO> searchAROfficeInfoList(AgtFincOfcInfoVO agtFincOfcInfoVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param AgtFincOfcInfoVO[] agtFincOfcInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAROfficeInfobyOffice(AgtFincOfcInfoVO[] agtFincOfcInfoVO,SignOnUserAccount account) throws EventException;
}