/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomerBC.java
*@FileTitle : Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.customer.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.customer.vo.MdmCustVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - Handling a biz logic about Primasterdata<br>
 *
 * @author 
 * @see Esm_pri_4014EventResponse 
 * @since J2EE 1.4
 */

public interface CustomerBC {
	/**
	 * Retrieving Customer List<br>
	 * 
	 * @param MdmCustVO mdmCustVO
	 * @return List<MdmCustVO>
	 * @exception EventException
	 */
	public List<MdmCustVO> searchCustomerList(MdmCustVO mdmCustVO) throws EventException;
}