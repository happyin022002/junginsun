/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CustPreferenceBC.java
*@FileTitle : jms bc 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-21
*@LastModifier : JeongSeon An
*@LastVersion : 1.0
* 2006-11-21 JeongSeon An
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.custpreference.basic;

import java.util.Collection;

import org.apache.xmlbeans.XmlObject;

/**
 * ENIS-ESD Business Logic ServiceCommand<br>
 * - ENIS-ESD에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author an
 * @see  참조
 * @since J2EE 1.4
 */
public interface CustPreferenceBC {
	
	/**
	 * Creating Data Received From MNR<br>
	 * 주의 : Receive JMS Queue 방식 사용 (JMS Inbound)
	 * @param models Collection - JMS Queue로부터 얻은 Data models 
	 * @return 
	 * @exception EventException
	 */
	public boolean createPRDTB(Collection models);
	
	/**
	 * CustPreferenceBC's receiveXML
	 * @param xmlObject
	 * @return Collection
	 */
	public Collection receiveXML(XmlObject xmlObject);
}
