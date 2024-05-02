/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalesRepBC.java
*@FileTitle : Sales Rep Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.18 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.salesrep.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.MdmSlsRepVO;

/**
 * ALPS-Primasterdata Business Logic Command Interface<br>
 * - ALPS-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_4022EventResponse 참조
 * @since J2EE 1.6
 */

public interface SalesRepBC {

	/**
	 * Sales Rep List를 조회합니다. <br>
	 * 
	 * @param MdmSlsRepVO mdmSlsRepVO
	 * @return List<MdmSlsRepVO>
	 * @exception EventException
	 */
	public List<MdmSlsRepVO> searchSalesRepList(MdmSlsRepVO mdmSlsRepVO) throws EventException;
}