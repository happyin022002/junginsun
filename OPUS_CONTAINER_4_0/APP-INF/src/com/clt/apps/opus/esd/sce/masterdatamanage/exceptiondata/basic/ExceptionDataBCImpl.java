/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ScemSetupBCImpl.java
 *@FileTitle : Exception Alert / notification registration screen target
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 =========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.basic;
 
import java.util.List;

import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0026Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0028Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0029Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0049Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0112Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration.ExceptionDataDBDAO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcList3VO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMasterOfcListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeDetailListForMultiVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeDetailListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpmasterOfcInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDTLTPListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailList3VO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStr2VO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStrVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptSubReqInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptSubReqListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptTPListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchSubscriberGroupMappingVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceListVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * SCEM Business Logic Basic Command implementation<br> - To handle the business logic for SCEM.<br>
 * 
 * @author yong_cheon_shin
 * @see EsdSce0028EventResponse,ExceptionDataBCImpl 
 * @since J2EE 1.4
 */
public class ExceptionDataBCImpl extends BasicCommandSupport implements ExceptionDataBC {

	// Database Access Object
	private transient ExceptionDataDBDAO dbDao = null;

	/**
	 * ScemSetupBCImpl 객체 생성<br>
	 * ScemSetupDBDAO를 생성한다.<br>
	 */
	public ExceptionDataBCImpl() {
		dbDao = new ExceptionDataDBDAO();
	}

	/**
	 * Exception Tolerance list Query
	 * 
	 * @param SearchToleranceInfoVO tolInfo
	 * @return List<SearchToleranceListVO>
	 * @throws EventException
	 */
	public List<SearchToleranceListVO> searchToleranceList(SearchToleranceInfoVO tolInfo) throws EventException {
		log.debug("ESDSCE0029 - searchToleranceList 함수 진입");
		try {
			return dbDao.searchToleranceList(tolInfo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Exception tolerance Insert/Update
	 * 
	 * @param Event e
	 * @param String usr_id
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiTolerance(Event e, String usr_id) throws EventException {
		log.debug("\n multiToleranceBCImpl");
		EsdSce0029Event event = (EsdSce0029Event) e;
		
		try {
			dbDao.multiTolerance(event.getMultiInfos(), usr_id);
			return	null;
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}


	/**
	 * Exception Type Registration Query
	 * 
	 * @return List<SearchExpTypeListVO>
	 * @throws EventException
	 */
	public List<SearchExpTypeListVO> searchExpTypeList() throws EventException {
		log.debug("ESDSCE0026 - searchExpTypeList");
		try {
			return dbDao.searchExpTypeList();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Exception Type Detail Registration Query
	 * 
	 * @return List<SearchExpTypeDetailListVO>
	 * @throws EventException
	 */
	public List<SearchExpTypeDetailListVO> searchExpTypeDetailList() throws EventException {
		log.debug("ESDSCE0026 - searchExpTypeDetailList ");
		try {
			return dbDao.searchExpTypeDetailList();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Exception Type Registration Insert/Update
	 * 
	 * @param Event e
	 * @param String usrId
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiExpType(Event e, String usrId) throws EventException {
		EsdSce0026Event event = (EsdSce0026Event) e; // PDTO(Data Transfer Object including Parameters)
		try {
			dbDao.multiExpType(event.getExpTypes(), usrId);
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Exception Type Detail Registration 
	 * 
	 * @param Event e
	 * @param String usrId
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiExpTypeDetail(Event e, String usrId) throws EventException {
		EsdSce0026Event event = (EsdSce0026Event) e; // PDTO(Data Transfer Object including Parameters)

		try {
			dbDao.multiExpTypeDetail(event.getExpTypeDetails(), usrId);
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * minestar Update - Subscriber Registration Insert/Update
	 * 
	 * @param Event e
	 * @param String usr_id
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiExptNoticeSubscriber(Event e, String usr_id) throws EventException {
		log.debug("\n multiExptNoticeSubscriber");
		EsdSce0028Event event = (EsdSce0028Event) e;

		try {
			dbDao.multiExptNoticeSubscriber(event.getExptNotSubs(), usr_id);
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Exception Type Detail Max Seq Queyr
	 * 
	 * @param SearchExpTypeDetailListForMultiVO detail
	 * @return List<SearchExptDetailQueryStrVO>
	 * @exception EventException
	 */
	public List<SearchExptDetailQueryStrVO> searchExptDetail(SearchExpTypeDetailListForMultiVO detail) throws EventException {
		log.debug("ESDSCE0026 - searchExptDetail ");

		try {
			return dbDao.searchExptDetail(detail);

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Exception Type Detail Max Seq Queyr
	 * 
	 * @param SearchExpTypeDetailListForMultiVO detail
	 * @return List<SearchExptDetailQueryStr2VO>
	 * @exception EventException
	 */
	public List<SearchExptDetailQueryStr2VO> searchExptDetail2(SearchExpTypeDetailListForMultiVO detail) throws EventException {
		log.debug("ESDSCE0026 - searchExptDetail2");

		try {
			return dbDao.searchExptDetail2(detail);

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Exception Detail by Exception Type
	 * 
	 * @param SearchExpInfoVO expt
	 * @return List<SearchExptDetailList3VO>
	 * @exception EventException
	 */
	public List<SearchExptDetailList3VO> searchExptDetailList3(SearchExpInfoVO expt) throws EventException {
		log.debug("ESDSCE0026 - searchExptDetailList3");
		try {
			return dbDao.searchExptDetailList3(expt);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Rail Exception Tolerance Registration Insert/Update
	 * 
	 * @param Event e
	 * @param String usr_id
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiSubscriberGroupMapping(Event e, String usr_id) throws EventException {
		log.debug("\n multiSubscriberGroupMapping");
		EsdSce0049Event event = (EsdSce0049Event) e;

		try {

			dbDao.multiSubscriberGroupMapping(event.getMultiMaps(), usr_id);

			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * minestar - Subscriber Group Mapping Query
	 * 
	 * @param SearchToleranceInfoVO tolInfo
	 * @return List<SearchSubscriberGroupMappingVO>
	 * @exception EventException
	 */
	public List<SearchSubscriberGroupMappingVO> searchSubscriberGroupMapping(SearchToleranceInfoVO tolInfo) throws EventException {
		log.debug("ESDSCE0049 - getSubscriberGroupMapping ");
		try {
			return dbDao.searchSubscriberGroupMapping(tolInfo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * minestar - Subscriber Registration Query
	 * 
	 * @param SearchExptSubReqInfoVO reqInfo
	 * @return List<SearchExptSubReqListVO>
	 * @exception EventException
	 */
	public List<SearchExptSubReqListVO> searchExptSubscriberRegistration(SearchExptSubReqInfoVO reqInfo) throws EventException {
		log.debug("ESDSCE0028 - searchExptSubscriberRegistration ");

		try {
			return dbDao.searchExptSubscriberRegistration(reqInfo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Exception Type Qeury<br>
	 * 
	 * @return List<SearchExptTPListVO>
	 * @throws EventException
	 */
	public List<SearchExptTPListVO> searchExptTPList() throws EventException {
		log.debug("ESDSCE0049 - searchExptTPList ");

		try {
			return dbDao.searchExptTPList();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Exception Detail Type Query<br>
	 * 
	 * @param SearchExpInfoVO expInfo
	 * @return List<SearchExptDTLTPListVO>
	 * @throws EventException
	 */
	public List<SearchExptDTLTPListVO> searchExptDTLTPList(SearchExpInfoVO expInfo) throws EventException {
		log.debug("ESDSCE0049 - searchTOLExptDTLTPList");

		try {
			return dbDao.searchTOLExptDTLTPList(expInfo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Exception Type Query<br>
	 * 
	 * @return List<SearchExptTPListVO>
	 * @throws EventException
	 */
	public List<SearchExptTPListVO> searchTOLExptTPList() throws EventException {
		log.debug("ESDSCE0029 - searchTOLExptTPList");

		try {
			return dbDao.searchExptTPList();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Exception Detail Type Query<br>
	 * 
	 * @param SearchExpInfoVO expInfo
	 * @return List<SearchExptDTLTPListVO>
	 * @throws EventException
	 */
	public List<SearchExptDTLTPListVO> searchTOLExptDTLTPList(SearchExpInfoVO expInfo) throws EventException {
		log.debug("ESDSCE0029 - searchTOLExptDTLTPList");

		try {
			return dbDao.searchTOLExptDTLTPList(expInfo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	
	/**
	 * Exception Office Mapping(master office) Query &&&
	 * 
	 * @param SearchExpmasterOfcInfoVO ofcInfo
	 * @return List<SearchExpMasterOfcListVO>
	 * @throws EventException
	 */
	public List<SearchExpMasterOfcListVO> searchExpMasterOfcList(SearchExpmasterOfcInfoVO ofcInfo) throws EventException {
		log.debug("ESDSCE0112 - searchExpMasterOfcList");

		try {
			return dbDao.searchExpMasterOfcList(ofcInfo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Exception Office Mapping(searchExpMapgOfcList) &&&
	 * 
	 * @return List<SearchExpMapgOfcListVO>
	 * @throws EventException
	 */
	public List<SearchExpMapgOfcListVO> searchExpMapgOfcList() throws EventException {
		log.debug("ESDSCE0112 - searchExpMapgOfcList");
		try {
			return dbDao.searchExpMapgOfcList();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	

	/**
	 * Exception Office Mapping(multiExpMapgOfc| Mapping Office save When Button Click) &&&
	 * 
	 * @param Event e
	 * @param String usrId
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiExpMapgOfc(Event e, String usrId) throws EventException {
		log.debug("\n BC.multiExpMapgOfc");
		EsdSce0112Event event = (EsdSce0112Event) e; // PDTO(Data Transfer Object including Parameters)
		try {
			dbDao.multiExpMapgOfc(event.getMultiInfos(), usrId);
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Exception Office Mapping(searchExpMapgOfcList3)
	 * Master Office at Double-click lookup results, the query result Mapping Office&&&
	 * 
	 * @param SearchExpmasterOfcInfoVO ofcInfo
	 * @return List<SearchExpMapgOfcList3VO>
	 * @exception EventException
	 */
	public List<SearchExpMapgOfcList3VO> searchExpMapgOfcList3(SearchExpmasterOfcInfoVO ofcInfo) throws EventException {
		log.debug("ESDSCE0112 - searchExpMapgOfcList3");
		try {
			return dbDao.searchExpMapgOfcList3(ofcInfo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
}