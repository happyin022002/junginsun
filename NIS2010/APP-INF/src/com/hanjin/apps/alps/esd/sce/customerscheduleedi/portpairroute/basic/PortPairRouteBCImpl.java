/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortPairRouteBCImpl.java
*@FileTitle : Exception Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.02 신한성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration.PortPairRouteDBDAO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairOceanRouteInformationVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteConditionVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteDetailVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteMstVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-ExceptionManage Business Logic Basic Command implementation<br>
 * - ALPS-ExceptionManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Shin Han Sung
 * @see UI_SCE_001EventResponse,PortPairRouteBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PortPairRouteBCImpl extends BasicCommandSupport implements PortPairRouteBC {

	// Database Access Object
	private transient PortPairRouteDBDAO dbDao = null;

	/**
	 * PortPairRouteBCImpl 객체 생성<br>
	 * PortPairRouteDBDAO를 생성한다.<br>
	 */
	public PortPairRouteBCImpl() {
		dbDao = new PortPairRouteDBDAO();
	}
	
	/**
	 * EDI 대상 PartnerName 을 조회.
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
	 * Port Pair Master Route를 조회 한다. 
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
	 * Port Pair Master Route를 조회 한다. 
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
	 * Port Pair Master Route를 조회 한다. 
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
	 * Port Pair Detail Route를 조회 한다. 
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
	 * Port Pair Detail Route를 조회 한다.
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
	
//	/**
//	 * 
//	 * @param PortPairRouteDetailVO model
//	 * @return List<PortPairRouteDetailVO>
//	 * @exception EventException
//	 */
//	public List<PortPairRouteDetailVO> searchPortPairDetailForEAI(PortPairRouteDetailVO model) throws EventException {
//		try {
//            return dbDao.searchPortPairDetailForEAI(model);
//		} catch (DAOException ex) {
//			throw new EventException(ex.getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(ex.getMessage(),ex);
//		}
//	}
	
	/**
	 * Add 버튼을 사용해서 추가 한 Route와 현재 SCE_PORT_PAIR_DTL테이블에 있는 Route가 중복 되는지 체크.
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
	 * SCE_PORT_PAIR_DTL_SEQ1.NEXTVAL 의 seq 생성.
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
	 * PORT PAIR 테이블 관련하여 KEY 생성.
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
	 * 파트너 등록한다.
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
	 * SCE_PORT_PAIR_MST 테이블을 수정 한다.
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
	 * PRD profomatransittime 일배치 처리 시에 제공.
	 * Call From : com.hanjin.apps.alps.esd.prd.batch.profomatransittime.basic.ProfomaTransitTime.java
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
	 * SCE_PORT_PAIR_DTL 테이블을 수정 한다.
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
	 * SCE_PORT_PAIR_DTL 테이블을 수정 한다.
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

	/**
	 * ocn route 정보를 조회 한다.
	 * 
	 * @param PortPairRouteDetailVO portPairRouteDetailVO
	 * @return List<PortPairOceanRouteInformationVO>
	 * @exception EventException
	 */
	public List<PortPairOceanRouteInformationVO> searchPortPairOceanRouteInformation(
			PortPairRouteDetailVO portPairRouteDetailVO) throws EventException {
		try {
            return dbDao.searchPortPairOceanRouteInformation(portPairRouteDetailVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex); 	
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

//	@Override
//	public List<SceComboVO> searchPartnerCombo() throws EventException {
//		try {
//            return dbDao.searchPartnerCombo();
//        }  catch (DAOException ex) {
//			throw new EventException(ex.getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(ex.getMessage(),ex);
//		}
//	}
	
//	/**
//	 * 멀티 이벤트 처리<br>
//	 * UI_COM_SYS_007 화면에 대한 멀티 이벤트 처리<br>
//	 * 
//	 * @param e UI_COM_SYS_007Event
//	 * @return EventResponse UI_COM_SYS_007EventResponse
//	 * @exception EventException
//	 */
//	public void addPortPairRouteIF(PortPairRouteConditionVO condition, Collection<PortPairRouteDetailVO> models) throws EventException{
//		
//		log.debug("PortPairRouteBC - addPortPairRouteIF");
//		
//		try {
//			dbDao.addPortPairRouteIF(condition, models);
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
}