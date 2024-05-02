/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FCMCommonBCImpl
*@FileTitle : FCMCommonBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.15 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.fcmcommon.fcmcommon.basic;

import com.clt.apps.opus.vop.fcm.fcmcommon.fcmcommon.integration.FCMCommonDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-FCM Common Business Logic Basic Command implementation<br>
 * - ALPS-FCM Common 에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Ryu Hyuk
 * @see FCMCommonBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class FCMCommonBCImpl extends BasicCommandSupport implements FCMCommonBC {
	
	// Database Access Object
	private transient FCMCommonDBDAO dbDao = null;

	/**
	 * VesselReportBCImpl 객체 생성<br>
	 * VesselReportBCDBDAO 생성한다.<br>
	 */
	public FCMCommonBCImpl() {
		dbDao = new FCMCommonDBDAO();
	}
	
	/**
	 * MDM Vessel Class Capacity List를 조회한다.
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchVslClassCapaList() throws EventException {
		try{
			return dbDao.searchVslClassCapaList();			
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Monthly Fuel Saving Cost List"}).getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Monthly Fuel Saving Cost List"}).getMessage(), ex);
		}
	}
	
}
