/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqYardOrzBCImpl.java
*@FileTitle : EsdSce114
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.sce.common.popup.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.common.popup.integration.EqYardOrzDBDAO;
import com.clt.apps.opus.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.EQYARDManageConditionVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.EQYARDManageVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * common Business Logic Basic Command implementation<br>
 * - <br>
 *
 * @author 
 * @see EsdSce114EventResponse,popupBC 
 * @since J2EE 1.6
 */
public class EqYardOrzBCImpl extends BasicCommandSupport implements EqYardOrzBC {

	// Database Access Object
	private transient EqYardOrzDBDAO dbDao = null;

	/**
	 * EqYardOrzBCImpl objects creation<br>
	 * create EqYardOrzDBDAO.<br>
	 */
	public EqYardOrzBCImpl() {
		dbDao = new EqYardOrzDBDAO();
	}
	
	/**
	 * retrieving EQ YARD List
	 * 
	 * @param EQYARDManageConditionVO eqYARDManageConditionVO
	 * @return List<EQYARDManageVO>
	 * @exception EventException
	 */
	public List<EQYARDManageVO> searchEQYARDManage(EQYARDManageConditionVO eqYARDManageConditionVO) throws EventException {
		try {
			return dbDao.searchEQYARDManage(eqYARDManageConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * <br>
	 * 
	 * @param ComOfficeManagementVO comOfficeManagementVO
	 * @return List<ComOfficeManagementVO>
	 * @exception EventException
	 */
	public List<ComOfficeManagementVO> searchExptInqMapgOfc(ComOfficeManagementVO comOfficeManagementVO) throws EventException {
		try {
			return dbDao.searchExptInqMapgOfc(comOfficeManagementVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * <br>
	 * 
	 * @param ComOfficeManagementVO comOfficeManagementVO
	 * @return List<ComOfficeManagementVO>
	 * @exception EventException
	 */
	public List<ComOfficeManagementVO> searchExptMapgOfc(ComOfficeManagementVO comOfficeManagementVO) throws EventException {
		try {
			return dbDao.searchExptMapgOfc(comOfficeManagementVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
}