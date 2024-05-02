/*=========================================================
*Copyright(c) 2017 HiplusCard
*@FileName : ServiceProviderManageBC.java
*@FileTitle : Service Provider Master
*Open Issues :
*Change history :
*@LastModifyDate : 2017-06-29
*@LastModifier : 
*@LastVersion : 1.0
* 2017-06-29 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ENIS-ESD Business Logic Command Interface<br>
 * - ENIS-ESD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see ESD_TES_028EventResponse 참조 
 * @since J2EE 1.4
 */
public interface ServiceProviderManageBC  {
	
	/**
	 * MDM VENDOR INFO
	 * 
	 * @param e
	 * @return eventResponse
	 * @throws EventException
	 */
	public EventResponse searchMdmVendorInfo(Event e) throws EventException;
	
	/**
	 * MDM VENDOR INDIA INFO
	 * 
	 * @param e
	 * @return eventResponse
	 * @throws EventException
	 */
	public EventResponse searchMdmVendorIndiaInfo(Event e) throws EventException;
	
	/**
	 * Modify MDM VENDOR INDIA INFO
	 * 
	 * @param e
	 * @return eventResponse
	 * @throws EventException
	 */
	public EventResponse modifyMdmVendorIndiaInfo(Event e) throws EventException;
	
}