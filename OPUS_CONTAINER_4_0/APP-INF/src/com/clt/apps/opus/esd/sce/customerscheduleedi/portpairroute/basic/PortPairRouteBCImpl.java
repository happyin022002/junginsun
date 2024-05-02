/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortPairRouteBCImpl.java
*@FileTitle : Exception Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.integration.PortPairRouteDBDAO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteConditionVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteDetailVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteMstVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ExceptionManage Business Logic Basic Command implementation<br>
 * <br>
 *
 * @author 
 * @see UI_SCE_001EventResponse,PortPairRouteBC
 * @since J2EE 1.6
 */
public class PortPairRouteBCImpl extends BasicCommandSupport implements PortPairRouteBC {

	// Database Access Object
	private transient PortPairRouteDBDAO dbDao = null;

	/**
	 * PortPairRouteBCImpl objects creation<br>
	 * create PortPairRouteDBDAO<br>
	 */
	public PortPairRouteBCImpl() {
		dbDao = new PortPairRouteDBDAO();
	}
	
	/**
	 * retrieving ED PartnerName
	 * 
	 * @param String partnerId
	 * @return String
	 * @exception EventException
	 */
	public String searchPartnerName(String partnerId) throws EventException {
		try {
            return dbDao.searchPartnerName(partnerId);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * retrieving Port Pair Master Route
	 * 
	 * @param PortPairRouteMstVO model
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchPortPairMaster(PortPairRouteMstVO model) throws EventException {
		try {
            return dbDao.searchPortPairMaster(model);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * retrieving Port Pair Master Route
	 * 
	 * @param PortPairRouteDetailVO model
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchPortPairMaster(PortPairRouteDetailVO model) throws EventException {
		try {
            return dbDao.searchPortPairMaster(model);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * retrieving Port Pair Master Route
	 * 
	 * @param PortPairRouteConditionVO portPairRouteConditionVO
	 * @return List<ExceptionInquiryVO>
	 * @exception EventException
	 */
	public List<PortPairRouteMstVO> searchPortPairMasters(PortPairRouteConditionVO portPairRouteConditionVO) throws EventException {
		try {
            return dbDao.searchPortPairMasters(portPairRouteConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * retrieving Port Pair Detail Route
	 * 
	 * @param PortPairRouteConditionVO condition
	 * @return List<PortPairRouteDetailVO>
	 * @exception EventException
	 */
	public List<PortPairRouteDetailVO> searchPortPairDetails(PortPairRouteConditionVO condition) throws EventException {
		try {
            return dbDao.searchPortPairDetails(condition);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * retrieving Port Pair Detail Route
	 * 
	 * @param PortPairRouteMstVO mstVO
	 * @return List<PortPairRouteDetailVO>
	 * @exception EventException
	 */
	public List<PortPairRouteDetailVO> searchPortPairDetails(PortPairRouteMstVO mstVO) throws EventException {
		try {
            return dbDao.searchPortPairDetails(mstVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * checking SCE_PORT_PAR_DTL.Route duplication
	 * 
	 * @param PortPairRouteDetailVO model
	 * @return boolean
	 * @exception EventException
	 */
	public boolean hasSameRoute(PortPairRouteDetailVO model) throws EventException {
		try {
            return dbDao.hasSameRoute(model);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * retrieving sequence at SCE_PORT_PAIR_DTL_SEQ1.NEXTVAL
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String getNextRouteSeq() throws EventException {
		try {
            return dbDao.getNextRouteSeq();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * create key for PORT PAIR Table
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String getCurrentDate() throws EventException {
		try {
            return dbDao.getCurrentDate();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * registering partner
	 * 
	 * @param PortPairRouteConditionVO condition
	 * @exception EventException
	 */
	public void insertPartnerCode(PortPairRouteConditionVO condition) throws EventException{
		
		log.debug("PortPairRouteBC - insertPartnerCode");
		
		try {
			dbDao.insertPartnerCode(condition);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * update SCE_PORT_PAIR_MST Table.
	 * 
	 * @param PortPairRouteConditionVO condition
	 * @param PortPairRouteMstVO[] models
	 * @exception EventException
	 */
	public void modifyPortPairMaster(PortPairRouteConditionVO condition, PortPairRouteMstVO[] models) throws EventException{
		
		log.debug("PortPairRouteBC - modifyPortPairMaster");
		
		try {
			dbDao.modifyPortPairMaster(condition, models);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * calling daily batch when PRD profomatransittime.
	 * Call From : com.clt.apps.opus.esd.prd.batch.profomatransittime.basic.ProfomaTransitTime.java
	 * @exception EventException
	 */
	public void modifyPortPairRoute() throws EventException{
		
		log.debug("PortPairRouteBC - modifyPortPairRoute");
		
		try {
			dbDao.modifyPortPairRoute();
			dbDao.updatePortPairRouteDtlIndUpd();
			dbDao.updatePortPairRouteDtlNotExist();
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * update SCE_PORT_PAIR_DTL Table.
	 * 
	 * @param PortPairRouteConditionVO condition
	 * @param PortPairRouteMstVO[] models
	 * @exception EventException
	 */
	public void modifyPortPairDetail(PortPairRouteConditionVO condition, PortPairRouteMstVO[] models) throws EventException{
		
		log.debug("PortPairRouteBC - modifyPortPairDetail");
		
		try {
			dbDao.modifyPortPairDetail(condition, models);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * Update SCE_PORT_PAIR_DTL Table.
	 * 
	 * @param PortPairRouteConditionVO condition
	 * @param PortPairRouteDetailVO[] models
	 * @exception EventException
	 */
	public void modifyPortPairDetail(PortPairRouteConditionVO condition, PortPairRouteDetailVO[] models) throws EventException{
		
		log.debug("PortPairRouteBC - modifyPortPairDetail");
		
		try {
			dbDao.modifyPortPairDetail(condition, models);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
}