/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OrganizationBC.java
*@FileTitle : Office Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.24 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.organization.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.organization.vo.MdmOrzVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Primasterdata Business Logic Command Interface<br>
 * - ALPS-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_4023EventResponse 참조
 * @since J2EE 1.6
 */

public interface OrganizationBC {

	/**
	 * Office Code List를 조회합니다. <br>
	 * 
	 * @param MdmOrzVO mdmOrzVO
	 * @return List<MdmOrzVO>
	 * @exception EventException
	 */
	public List<MdmOrzVO> searchOrganizationList(MdmOrzVO mdmOrzVO) throws EventException;
}