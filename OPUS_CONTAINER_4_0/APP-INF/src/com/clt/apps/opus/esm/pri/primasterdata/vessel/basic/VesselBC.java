/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselBC.java
*@FileTitle : Vessel Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.vessel.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmVslCntrVO;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - Handling a biz logic about Primasterdata<br>
 *
 * @author
 * @see Esm_pri_4013EventResponse 
 * @since J2EE 1.6
 */

public interface VesselBC {
	/**
	 * Retrieving Vessel Code .<br>
	 * 
	 * @param MdmVslCntrVO mdmVslCntrVO
	 * @return List<MdmVslCntrVO>
	 * @exception EventException
	 */
	public List<MdmVslCntrVO> searchVesselList(MdmVslCntrVO mdmVslCntrVO) throws EventException;
}