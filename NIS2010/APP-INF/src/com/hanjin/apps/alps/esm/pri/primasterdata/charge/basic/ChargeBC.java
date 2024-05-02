/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeBC.java
*@FileTitle : Charge Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.25 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.charge.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.charge.vo.MdmChgVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Primasterdata Business Logic Command Interface<br>
 * - ALPS-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_4025EventResponse 참조
 * @since J2EE 1.6
 */

public interface ChargeBC {

	/**
	 * Charge Code List를 조회합니다.<br>
	 * 
	 * @param MdmChgVO	mdmChgVO
	 * @return List<MdmChgVO>
	 * @exception EventException
	 */
	public List<MdmChgVO> searchChargeList(MdmChgVO mdmChgVO) throws EventException;
}