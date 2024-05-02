/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OrganizationBC.java
*@FileTitle : Office Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.organization.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.organization.vo.MdmOrzVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - Handling a biz logic about Primasterdata<br>
 *
 * @author 
 * @see Esm_pri_4023EventResponse 
 * @since J2EE 1.6
 */

public interface OrganizationBC {

	/**
	 * Retrieving Office Code List. <br>
	 * 
	 * @param MdmOrzVO mdmOrzVO
	 * @return List<MdmOrzVO>
	 * @exception EventException
	 */
	public List<MdmOrzVO> searchOrganizationList(MdmOrzVO mdmOrzVO) throws EventException;
}