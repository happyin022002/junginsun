/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqYardOrzBC.java
*@FileTitle : EsdSce114
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.30 신한성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.popup.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.EQYARDManageConditionVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.EQYARDManageVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Common Business Logic Command Interface<br>
 * - ALPS-Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Shin Han Sung
 * @see EsdSce114EventResponse 참조
 * @since J2EE 1.6
 */

public interface EqYardOrzBC {

	/**
	 * EQ YARD 조회
	 * 
	 * @param EQYARDManageConditionVO eqYARDManageConditionVO
	 * @return List<EQYARDManageVO>
	 * @exception EventException
	 */
	public List<EQYARDManageVO> searchEQYARDManage(EQYARDManageConditionVO eqYARDManageConditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ComOfficeManagementVO	comOfficeManagementVO
	 * @return List<ComOfficeManagementVO>
	 * @exception EventException
	 */
	public List<ComOfficeManagementVO> searchExptInqMapgOfc(ComOfficeManagementVO comOfficeManagementVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ComOfficeManagementVO	comOfficeManagementVO
	 * @return List<ComOfficeManagementVO>
	 * @exception EventException
	 */
	public List<ComOfficeManagementVO> searchExptMapgOfc(ComOfficeManagementVO comOfficeManagementVO) throws EventException;
}