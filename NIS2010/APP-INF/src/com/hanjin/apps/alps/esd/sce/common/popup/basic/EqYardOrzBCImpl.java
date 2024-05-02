/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqYardOrzBCImpl.java
*@FileTitle : EsdSce114
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.30 신한성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.popup.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.common.popup.integration.EqYardOrzDBDAO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.EQYARDManageConditionVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.EQYARDManageVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-common Business Logic Basic Command implementation<br>
 * - ALPS-common에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Shin Han Sung
 * @see EsdSce114EventResponse,popupBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class EqYardOrzBCImpl extends BasicCommandSupport implements EqYardOrzBC {

	// Database Access Object
	private transient EqYardOrzDBDAO dbDao = null;

	/**
	 * EqYardOrzBCImpl 객체 생성<br>
	 * EqYardOrzDBDAO를 생성한다.<br>
	 */
	public EqYardOrzBCImpl() {
		dbDao = new EqYardOrzDBDAO();
	}
	
	/**
	 * EQ YARD 조회
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
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