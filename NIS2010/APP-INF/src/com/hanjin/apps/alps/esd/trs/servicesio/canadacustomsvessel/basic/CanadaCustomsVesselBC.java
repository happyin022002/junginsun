/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CanadaCustomsVesselBC.java
*@FileTitle : Canada Customs Vessel 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-22
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.canadacustomsvessel.basic;

import java.util.Collection;
import org.apache.xmlbeans.XmlObject;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * eNIS-BIZCOMMON Business Logic Command Interface<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Sang-Woo
 * @see ESD076_HU01EventResponse 참조
 * @since J2EE 1.4
 */
public interface CanadaCustomsVesselBC  {
	
	
	/**
	 * Receving Data From MNR <br>
	 * 주의 : Receive JMS Queue 방식 사용 (JMS Inbound)
	 * 
	 * @param xmlData
	 * @return
	 */
	public Collection receiveCanadaCustomsVesselManage(XmlObject xmlData);

	/**
	 * Creating Data Received From MNR<br>
	 * 주의 : Receive JMS Queue 방식 사용 (JMS Inbound)
	 * 
	 * @param models
	 * @throws EventException
	 */
	public void ctrlCanadaCustomsVesselManage(Collection models) throws EventException;
	

}
