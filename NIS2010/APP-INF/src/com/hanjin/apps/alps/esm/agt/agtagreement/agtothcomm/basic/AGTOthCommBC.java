/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTOthCommBC.java
*@FileTitle : Commission Unit Cost Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.13 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.AgtOtrUtCostVO;

/**
 * ALPS-Agtagreement Business Logic Command Interface<br>
 * - ALPS-Agtagreement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kyung-won Chu
 * @see Esm_agt_0009EventResponse 참조
 * @since J2EE 1.6
 */

public interface AGTOthCommBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param AgtOtrUtCostVO agtOtrUtCostVO
	 * @return List<AgtOtrUtCostVO>
	 * @exception EventException
	 */
	public List<AgtOtrUtCostVO> searchOtherUnitCostInfoList(AgtOtrUtCostVO agtOtrUtCostVO) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param AgtOtrUtCostVO agtOtrUtCostVO
	 * @return List<AgtOtrUtCostVO>
	 * @exception EventException
	 */
	public List<AgtOtrUtCostVO> searchUpdateDate(AgtOtrUtCostVO agtOtrUtCostVO) throws EventException;
}