/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderBC.java
*@FileTitle : LaneCodeHelp
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.VskVslSkdVO;

 
/**
 * Vskcommon Business Logic Command Interface<br>
 * - business logic interface about Vskcommon<br>
 *
 * @author 
 * @see Ui_vsk-0202EventResponse
 * @since J2EE 1.4
 */

public interface InterfaceScheduleToExternalScnBC {

	/**
	 * CSSM I/F 
	 * 
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @exception EventException
	 */
	public void manageScnCssmIf(List<VskVslSkdVO> vskVslSkdVOs) throws EventException;

	/**
	 * CSSM I/F 
	 * 
	 * @param List<VskVslSkdVO>	vskVslSkdVOs
	 * @exception EventException
	 */
	//public void  removeScnCssmIf(List<VskVslSkdVO> vskVslSkdVOs) throws EventException;
	
	}