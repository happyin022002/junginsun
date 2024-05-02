/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalesRepBC.java
*@FileTitle : Sales Rep Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.salesrep.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmSlsRepVO;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - Handling a biz logic of Primaster data<br>
 *
 * @author 
 * @see Esm_pri_4022EventResponse
 * @since J2EE 1.6
 */

public interface SalesRepBC {

	/**
	 * Retrieving Sales Rep List <br>
	 * 
	 * @param MdmSlsRepVO mdmSlsRepVO
	 * @return List<MdmSlsRepVO>
	 * @exception EventException
	 */
	public List<MdmSlsRepVO> searchSalesRepList(MdmSlsRepVO mdmSlsRepVO) throws EventException;
}