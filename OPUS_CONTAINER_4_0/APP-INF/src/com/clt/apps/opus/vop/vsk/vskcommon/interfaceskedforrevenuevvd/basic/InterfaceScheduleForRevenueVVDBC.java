/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceScheduleForRevenueVVDBC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedforrevenuevvd.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Vskcommon Business Logic Command Interface<br>
 * - business logic interface about Vskcommon<br>
 *
 * @author 
 * @see Ui_vsk-0202EventResponse
 * @since J2EE 1.4
 */

public interface InterfaceScheduleForRevenueVVDBC {
	/**
	 * Retrieving Service Lane
	 * 
	 * @param List<VvdVO> vvdVOs
	 * @exception EventException
	 */
	public void interfaceScheduleForRevenueVVD(List<VvdVO> vvdVOs) throws EventException;
	
	
}