/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceLaneBC.java
*@FileTitle : Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.servicelane.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - Handling a biz logic about Primasterdata<br>
 *
 * @author 
 * @see Esm_pri_4012EventResponse
 * @since J2EE 1.6
 */

public interface ServiceLaneBC {
	/**
	 * Retrieving Lane Code .<br>
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchServiceLaneList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;
}