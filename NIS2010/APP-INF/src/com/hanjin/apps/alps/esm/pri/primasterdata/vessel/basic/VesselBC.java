/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselBC.java
*@FileTitle : Vessel Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.27 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.vessel.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;

/**
 * NIS2010-Primasterdata Business Logic Command Interface<br>
 * - NIS2010-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Moon Dong Gyu
 * @see Esm_pri_4013EventResponse 참조
 * @since J2EE 1.6
 */

public interface VesselBC {
	/**
	 * Vessel Code 를 조회합니다.<br>
	 * 
	 * @param MdmVslCntrVO mdmVslCntrVO
	 * @return List<MdmVslCntrVO>
	 * @exception EventException
	 */
	public List<MdmVslCntrVO> searchVesselList(MdmVslCntrVO mdmVslCntrVO) throws EventException;
}