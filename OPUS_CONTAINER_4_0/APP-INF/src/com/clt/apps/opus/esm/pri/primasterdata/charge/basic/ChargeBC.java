/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeBC.java
*@FileTitle : Charge Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.charge.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.charge.vo.MdmChgVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - interface about Primasterdata biz logic<br>
 *
 * @author 
 * @see Esm_pri_4025EventResponse 
 * @since J2EE 1.6
 */

public interface ChargeBC {

	/**
	 * Retrieving Charge Code List<br>
	 * 
	 * @param MdmChgVO	mdmChgVO
	 * @return List<MdmChgVO>
	 * @exception EventException
	 */
	public List<MdmChgVO> searchChargeList(MdmChgVO mdmChgVO) throws EventException;
}