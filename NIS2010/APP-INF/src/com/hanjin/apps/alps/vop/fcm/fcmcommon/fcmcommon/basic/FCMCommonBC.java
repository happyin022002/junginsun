/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FCMCommonBC
*@FileTitle : FCMCommonBC
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.15 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.fcmcommon.fcmcommon.basic;

import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-FCM Common Business Logic Basic Command implementation<br>
 * - ALPS-FCM Common 에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Ryu Hyuk
 * @see FCMCommonBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public interface FCMCommonBC {
	
	/**
	 * MDM Vessel Class Capacity List를 조회한다.
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchVslClassCapaList() throws EventException;
	
	/**
	 * MDM에서 Vessel(Container) Design Capacity List를 조회한다.
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchCntrDznCapaList() throws EventException;
	
	/**
	 * MDM에 존재하는 lane code인지 check한다.
	 * 
	 * @param String vslSlanCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMdmVslSlanCd(String vslSlanCd) throws EventException;

	/**
	 * MDM에 존재하는 vsl code인지 check한다.
	 * 
	 * @param String vslCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMdmVslCd(String vslCd) throws EventException;
}
