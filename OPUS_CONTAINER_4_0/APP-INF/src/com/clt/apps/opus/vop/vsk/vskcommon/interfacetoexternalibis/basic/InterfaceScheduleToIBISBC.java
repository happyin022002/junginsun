/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceScheduleToIBISBC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPortNworkIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPfSkdIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPfSkdDtlIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskVslPortSkdIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskVslSkdIbisIfVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Vskcommon Business Logic Command Interface<br>
 * - business logic interface about Vskcommon<br>
 *
 * @author 
 * @see InterfaceScheduleToIBISBCImpl
 * @since J2EE 1.4
 */
public interface InterfaceScheduleToIBISBC {

	/**
	 *  VSK_PORT_NWORK IBIS I/F  
	 *
	 * @param List<VskPortNworkIbisIfVO> vskPortNworkIbisIfVOs
	 * @param String sEventTypeCode
	 * @return String
	 * @exception EventException
	 */
	public String createVskPortNworkIbisIfBackEndJob(List<VskPortNworkIbisIfVO> vskPortNworkIbisIfVOs, String sEventTypeCode)  throws EventException;

	/**
	 *  VSK_PF_SKD, Dtl IBIS I/F  
	 *
	 * @param List<VskPfSkdIbisIfVO> vskPfSkdIbisIfVOs
	 * @param List<VskPfSkdDtlIbisIfVO> vskPfSkdDtlIbisIfVOs
	 * @param String sEventTypeCode
	 * @return String
	 * @exception EventException
	 */
	public String createVskPfSkdIbisIfBackEndJob(List<VskPfSkdIbisIfVO> vskPfSkdIbisIfVOs, List<VskPfSkdDtlIbisIfVO> vskPfSkdDtlIbisIfVOs, String sEventTypeCode)  throws EventException;
	
	/**
	 *  VSK_VSL_SKD, Dtl IBIS I/F  
	 *
	 * @param List<VskVslSkdIbisIfVO> vskVslSkdIbisIfVOs
	 * @param List<VskVslPortSkdIbisIfVO> vskVslPortSkdIbisIfVOs
	 * @param String sEventTypeCode
	 * @return String
	 * @exception EventException
	 */	
	public String createVskVslSkdIbisIfBackEndJob(List<VskVslSkdIbisIfVO> vskVslSkdIbisIfVOs, List<VskVslPortSkdIbisIfVO> vskVslPortSkdIbisIfVOs, String sEventTypeCode)  throws EventException;
}
