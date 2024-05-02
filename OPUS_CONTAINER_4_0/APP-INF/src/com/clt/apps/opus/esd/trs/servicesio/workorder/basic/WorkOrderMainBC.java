/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : WorkOrderMainBC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.workorder.basic;

import com.clt.apps.opus.esd.trs.servicesio.workorder.event.WorkOrderRcvEvent;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author
 * @see WorkOrderMainBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public interface WorkOrderMainBC {

	/**
	 * NYK-Hawk_FFile(URV_N)-JOEDIUPDT_IAS_INBOUND
	 * 
	 * @param workOrderRcvEvent
	 * @return int
	 * @throws EventException
	 */
	public int receiveJoEdiUpdt(WorkOrderRcvEvent workOrderRcvEvent) throws EventException;

	/**
	 * NYK-Hawk_FFile(URV_N)-JOEDIREJ_IAS_INBOUND
	 * 
	 * @param workOrderRcvEvent
	 * @return int
	 * @throws EventException
	 */
	public int receiveJoEdiRej(WorkOrderRcvEvent workOrderRcvEvent) throws EventException;

	/**
	 * NYK-Hawk_FFile(URV_N)-JOEDIAPPT_IAS_INBOUND
	 * 
	 * @param workOrderRcvEvent
	 * @return int
	 * @throws EventException
	 */
	public int receiveJoEdiAppt(WorkOrderRcvEvent workOrderRcvEvent) throws EventException;

	/**
	 * NYK-Hawk_FFile(URV_N)-JOEDIACTL_IAS_INBOUND
	 * 
	 * @param workOrderRcvEvent
	 * @return int
	 * @throws EventException
	 */
	public int receiveJoEdiActl(WorkOrderRcvEvent workOrderRcvEvent) throws EventException;

	/**
	 * NYK-Hawk_FFile(URV_N)-JOEDIACC_IAS_INBOUND
	 * 
	 * @param workOrderRcvEvent
	 * @return int
	 * @throws EventException
	 */
	public int receiveJoEdiAcc(WorkOrderRcvEvent workOrderRcvEvent) throws EventException;
}