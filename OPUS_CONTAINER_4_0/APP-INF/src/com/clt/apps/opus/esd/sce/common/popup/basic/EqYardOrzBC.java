/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqYardOrzBC.java
*@FileTitle : EsdSce114
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.sce.common.popup.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.EQYARDManageConditionVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.EQYARDManageVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Common Business Logic Command Interface<br>
 * - <br>
 *
 * @author 
 * @see EsdSce114EventResponse
 * @since J2EE 1.6
 */

public interface EqYardOrzBC {

	/**
	 * retrieving EQ YARD List
	 * 
	 * @param EQYARDManageConditionVO eqYARDManageConditionVO
	 * @return List<EQYARDManageVO>
	 * @exception EventException
	 */
	public List<EQYARDManageVO> searchEQYARDManage(EQYARDManageConditionVO eqYARDManageConditionVO) throws EventException;
	
	/**
	 * <br>
	 * 
	 * @param ComOfficeManagementVO	comOfficeManagementVO
	 * @return List<ComOfficeManagementVO>
	 * @exception EventException
	 */
	public List<ComOfficeManagementVO> searchExptInqMapgOfc(ComOfficeManagementVO comOfficeManagementVO) throws EventException;
	
	/**
	 * <br>
	 * 
	 * @param ComOfficeManagementVO	comOfficeManagementVO
	 * @return List<ComOfficeManagementVO>
	 * @exception EventException
	 */
	public List<ComOfficeManagementVO> searchExptMapgOfc(ComOfficeManagementVO comOfficeManagementVO) throws EventException;
}