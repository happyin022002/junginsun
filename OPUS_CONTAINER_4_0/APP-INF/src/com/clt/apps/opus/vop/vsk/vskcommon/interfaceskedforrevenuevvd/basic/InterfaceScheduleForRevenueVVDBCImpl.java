/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceScheduleForRevenueVVDBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedforrevenuevvd.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedforrevenuevvd.integration.InterfaceScheduleForRevenueVVDDBDAO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * VSKCommon Business Logic Basic Command implementation<br>
 * - Handling business logic of VSKCommon<br>
 *
 * @author 
 * @see UI_VSK-0202EventResponse,VSKCodeFinderBC, DAO
 * @since J2EE 1.4
 */

public class InterfaceScheduleForRevenueVVDBCImpl extends BasicCommandSupport implements InterfaceScheduleForRevenueVVDBC {

	// Database Access Object
	private transient InterfaceScheduleForRevenueVVDDBDAO dbDao = null;

	/**
	 * VSKCodeFinderBCImpl object creation<br>
	 * Creating VSKCodeFinderDBDAO<br>
	 */
	public InterfaceScheduleForRevenueVVDBCImpl() {
		dbDao = new InterfaceScheduleForRevenueVVDDBDAO();
	}
	
	/**
	 * Retrieving Service Lane
	 * 
	 * @param List<VvdVO> vvdVOs
	 * @exception EventException
	 */
	public void interfaceScheduleForRevenueVVD(List<VvdVO> vvdVOs) throws EventException {
		try {
			dbDao.interfaceScheduleForRevenueVVD(vvdVOs);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} 
	}
	
}