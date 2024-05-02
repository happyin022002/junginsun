/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueBC.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.clt.apps.opus.common.tableSync.jms.basic;

import java.util.Collection;
import org.apache.xmlbeans.XmlObject;

import com.clt.framework.core.layer.integration.DAOException;

/**
 * ENIS-Table sync JMS Consuming에 따른 JMS receive Interface<br> 
 *  ENIS-MDM에 대한 JMS Inbound 처리에 대한 규칙을 정의한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC 참조
 * @since J2EE 1.4
 */
public interface ReceiveQueueBC {
	/** remote Table로부터 JMS Queue를 VO로 Receive 처리한다.<br>
	 * @param msg xmlObject
	 */
	public Collection receiveBKGTB(XmlObject xmlObject);
	/** receive한 데이타를 DAO에 flag('U,C,D')값에 따라 전달한다.<br>
	 * @param msg Collection
	 */
	public void ctrlBKGTB(Collection models) throws DAOException;
}
