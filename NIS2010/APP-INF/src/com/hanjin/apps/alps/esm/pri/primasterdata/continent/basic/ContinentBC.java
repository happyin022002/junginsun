/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContinentBC.java
*@FileTitle : Continent-Subcontinent Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.14 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.continent.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.continent.vo.ContinentVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.MdmContinentVO;
import com.hanjin.syscommon.common.table.MdmSubcontinentVO;

/**
 * ALPS-Primasterdata Business Logic Command Interface<br>
 * - ALPS-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_4021EventResponse 참조
 * @since J2EE 1.6
 */

public interface ContinentBC {

	/**
	 * Continent List를 조회합니다. <br>
	 * 
	 * @param ContinentVO continentVO
	 * @return List<MdmContinentVO>
	 * @exception EventException
	 */
	public List<MdmContinentVO> searchContinentList(ContinentVO continentVO) throws EventException;

	/**
	 * Sub Continent List를 조회합니다. <br>
	 * 
	 * @param ContinentVO continentVO
	 * @return List<MdmSubcontinentVO>
	 * @exception EventException
	 */
	public List<MdmSubcontinentVO> searchSubcontinentList(ContinentVO continentVO) throws EventException;
}