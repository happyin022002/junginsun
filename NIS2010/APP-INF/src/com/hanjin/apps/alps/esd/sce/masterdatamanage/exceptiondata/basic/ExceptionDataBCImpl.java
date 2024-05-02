/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ScemSetupBCImpl.java
 *@FileTitle : Exception Alert/통지 대상 등록 화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-08-29
 *@LastModifier : yong_cheon_shin
 *@LastVersion : 1.0
 * 2006-08-29 yong_cheon_shin
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.basic;
 
import java.util.List;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0026Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0028Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0029Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0049Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0112Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.integration.ExceptionDataDBDAO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcList3VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMasterOfcListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeDetailListForMultiVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeDetailListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpmasterOfcInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDTLTPListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailList3VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStr2VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStrVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptSubReqInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptSubReqListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptTPListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchSubscriberGroupMappingVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceListVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ENIS-SCEM Business Logic Basic Command implementation<br> - ENIS-SCEM에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author yong_cheon_shin
 * @see EsdSce0028EventResponse,ExceptionDataBCImpl 각 DAO 클래스 참조
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
	 * Exception Tolerance list 조회
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
	 * Exception tolerance 입력/수정
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
	 * Yard명 가져오기
	 * 
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @exception EventException
	 */
//	public EventResponse searchYardName(Event e) throws EventException {
//		EsdSce0029Event event = (EsdSce0029Event) e;
//		RequestDataSetBC dataSet = event.getDataSet();
//		DBRowSet rowSet = null;
//
//		try {
//			rowSet = dbDao.searchYardName(dataSet.getString("yd_cd"));
//			return new EsdSce0029EventResponse(rowSet, "SUCCESS");
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

// 20080923 미사용 table 삭제 관련	
//	/**
//	 * Tolerance Validation Check
//	 * 
//	 * @param e
//	 *            Event
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchToleranceValidate(Event e) throws EventException {
//		EsdSce0029Event event = (EsdSce0029Event) e;
//		RequestDataSetBC dataSet = event.getDataSet();
//		DBRowSet rowSet = null;
//
//		try {
//			rowSet = dbDao.searchToleranceValidate(dataSet);
//			return new EsdSce0029EventResponse(rowSet, "SUCCESS");
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}
// 20080923 미사용 table 삭제 관련	

	/**
	 * validation Check Location
	 * 
	 * @param chkData
	 * @return
	 * @throws EventException
	 */
//	public EventResponse validationLoc(Event e) throws EventException {
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		EsdSce0029Event event = (EsdSce0029Event) e;
//		RequestDataSetBC dataSet = event.getDataSet();
//		DBRowSet rowSet = null;
//
//		try {
//			rowSet = dbDao.validationLoc(dataSet.getString("cell_loc_cd"));
//			return new EsdSce0029EventResponse(rowSet, "SUCCESS");
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * Exception Type Registration 조회
	 * 
	 * @return List<SearchExpTypeListVO>
	 * @throws EventException
	 */
	public List<SearchExpTypeListVO> searchExpTypeList() throws EventException {
		log.debug("ESDSCE0026 - searchExpTypeList 함수 진입");
		try {
			return dbDao.searchExpTypeList();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Exception Type Detail Registration 조회
	 * 
	 * @return List<SearchExpTypeDetailListVO>
	 * @throws EventException
	 */
	public List<SearchExpTypeDetailListVO> searchExpTypeDetailList() throws EventException {
		log.debug("ESDSCE0026 - searchExpTypeDetailList 함수 진입");
		try {
			return dbDao.searchExpTypeDetailList();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Exception Type Registration 입력/수정
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
	 * Exception Type Detail Registration ?낅젰/?섏젙
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
	 * Location명 가져오기
	 * 
	 * @param event
	 *            EsdSce0028Event
	 * @return EventResponse
	 * @exception EventException
	 */
//	public EventResponse searchLocationName(EsdSce0028Event event) throws EventException {
//		RequestDataSetBC dataSet = event.getDataSet();
//		DBRowSet rowSet = null;
//
//		try {
//			rowSet = dbDao.searchLocationName(dataSet.getString("loc_cd"));
//			return new EsdSce0028EventResponse(rowSet, "SUCCESS");
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * minestar 수정 - Subscriber Registration 입력/수정
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

//	/**
//	 * Exception Notification Office 입력/수정
//	 * 
//	 * @param event
//	 *            EsdSce0052Event
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	public EventResponse multiExptNoticeOffice(EsdSce0052Event event) throws EventException {
//		try {
//			dbDao.multiExptNoticeOffice(event.getDataSet());
//			return null;
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

// 20080923미사용table관련 정리	
//	/**
//	 * Exception Notification Subscriber Registration 조회
//	 * 
//	 * @param event
//	 *            EsdSce0028Event
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchExptNoticeSubscriber(EsdSce0028Event event) throws EventException {
//		RequestDataSetBC dataSet = event.getDataSet();
//		DBRowSet rowSet = null;
//		int totCnt = 0;
//
//		try {
//			totCnt = dbDao.searchExptNoticeSubscriberCount(dataSet);
//			rowSet = dbDao.searchExptNoticeSubscriberList(dataSet);
//			return new EsdSce0028EventResponse(rowSet, totCnt, "SUCCESS");
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

//	/**
//	 * Exception Notification Office 조회
//	 * 
//	 * @param event
//	 *            EsdSce0052Event
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchExptNoticeOfficeList(EsdSce0052Event event) throws EventException {
//		RequestDataSetBC dataSet = event.getDataSet();
//		DBRowSet rowSet = null;
//		int totCnt = 0;
//
//		try {
//			totCnt = dbDao.searchExptNoticeOfficeCount(dataSet);
//			rowSet = dbDao.searchExptNoticeOfficeList(dataSet);
//			return new EsdSce0052EventResponse(rowSet, totCnt, "SUCCESS");
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

//	/**
//	 * Rail Exception Tolerance 조회
//	 * 
//	 * @param event
//	 *            EsdSce0047Event
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchRailExptTolerance(EsdSce0047Event event) throws EventException {
//		RequestDataSetBC dataSet = event.getDataSet();
//		DBRowSet rowSet = null;
//		int totCnt = 0;
//
//		try {
//			totCnt = dbDao.searchRailExptToleranceCount(dataSet);
//			rowSet = dbDao.searchRailExptTolerance(dataSet);
//
//			return new EsdSce0047EventResponse(rowSet, totCnt, "SUCCESS");
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

//	/**
//	 * Rail Exception Tolerance 조회
//	 * 
//	 * @param event
//	 *            EsdSce0047Event
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchRailExptYard(EsdSce0047Event event) throws EventException {
//		RequestDataSetBC dataSet = event.getDataSet();
//		DBRowSet rowSet = null;
//
//		try {
//			rowSet = dbDao.searchRailExptYard(dataSet.getString("RAIL_EXPT_TOL_SEQ"));
//
//			return new EsdSce0047EventResponse(rowSet, "SUCCESS");
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * Exception Type Detail Max Seq 조회
	 * 
	 * @param SearchExpTypeDetailListForMultiVO detail
	 * @return List<SearchExptDetailQueryStrVO>
	 * @exception EventException
	 */
	public List<SearchExptDetailQueryStrVO> searchExptDetail(SearchExpTypeDetailListForMultiVO detail) throws EventException {
		log.debug("ESDSCE0026 - searchExptDetail 함수 진입");

		try {
			return dbDao.searchExptDetail(detail);

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Exception Type Detail Max Seq 조회
	 * 
	 * @param SearchExpTypeDetailListForMultiVO detail
	 * @return List<SearchExptDetailQueryStr2VO>
	 * @exception EventException
	 */
	public List<SearchExptDetailQueryStr2VO> searchExptDetail2(SearchExpTypeDetailListForMultiVO detail) throws EventException {
		log.debug("ESDSCE0026 - searchExptDetail2 함수 진입");

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
		log.debug("ESDSCE0026 - searchExptDetailList3 함수 진입");
		try {
			return dbDao.searchExptDetailList3(expt);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
/*		RequestDataSetBC dataSet = event.getDataSet();
		DBRowSet rowSet = null;

		try {
			log.debug("\n bcImple-searchExptDetail");
			rowSet = dbDao.searchExptDetailList3(dataSet.getString("f_expt_tp"));

			return new EsdSce0026EventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}*/
	}

	/**
	 * Exception Tolerance Activity
	 * 
	 * @param event
	 *            EsdSce0029Event
	 * @return EventResponse
	 * @exception EventException
	 */
//	public EventResponse searchExptTolAct(EsdSce0029Event event) throws EventException {
//		RequestDataSetBC dataSet = event.getDataSet();
//		DBRowSet rowSet = null;
//
//		try {
//			log.debug("\n bcImple-searchExptTolAct");
//			rowSet = dbDao.searchExptTolAct(dataSet.getString("cop_expt_tp_cd"), dataSet
//					.getString("cop_expt_tp_dtl_cd"));
//
//			return new EsdSce0029EventResponse(rowSet, "SUCCESS");
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

//	/**
//	 * Rail Exception Tolerance Registration 입력/수정
//	 * 
//	 * @param event
//	 *            EsdSce0047Event
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	public EventResponse multiRailExptTolerance(EsdSce0047Event event) throws EventException {
//
//		try {
//
//			dbDao.multiRailExptTolerance(event.getDataSet());
//
//			return null;
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * Rail Exception Tolerance Registration 입력/수정
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

// 20080923 미사용table 관련 정리	
//	/**
//	 * Exception Type & Subscriber Group Mapping 조회
//	 * 
//	 * @param event
//	 *            EsdSce0049Event
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchSubscriberGroupMapping(EsdSce0049Event event) throws EventException {
//		RequestDataSetBC dataSet = event.getDataSet();
//		DBRowSet rowSet = null;
//		int totCnt = 0;
//
//		try {
//			totCnt = dbDao.searchSubscriberGroupMappingCount();
//			rowSet = dbDao.searchSubscriberGroupMapping(dataSet);
//
//			return new EsdSce0049EventResponse(rowSet, totCnt, "SUCCESS");
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * minestar - Subscriber Group Mapping 조회
	 * 
	 * @param SearchToleranceInfoVO tolInfo
	 * @return List<SearchSubscriberGroupMappingVO>
	 * @exception EventException
	 */
	public List<SearchSubscriberGroupMappingVO> searchSubscriberGroupMapping(SearchToleranceInfoVO tolInfo) throws EventException {
		log.debug("ESDSCE0049 - getSubscriberGroupMapping 함수 진입");
		try {
			return dbDao.searchSubscriberGroupMapping(tolInfo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * minestar - Subscriber Registration 조회
	 * 
	 * @param SearchExptSubReqInfoVO reqInfo
	 * @return List<SearchExptSubReqListVO>
	 * @exception EventException
	 */
	public List<SearchExptSubReqListVO> searchExptSubscriberRegistration(SearchExptSubReqInfoVO reqInfo) throws EventException {
		log.debug("ESDSCE0028 - searchExptSubscriberRegistration 함수 진입");

		try {
			return dbDao.searchExptSubscriberRegistration(reqInfo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Exception Type 조회 기능<br>
	 * 
	 * @return List<SearchExptTPListVO>
	 * @throws EventException
	 */
	public List<SearchExptTPListVO> searchExptTPList() throws EventException {
		log.debug("ESDSCE0049 - searchExptTPList 함수 진입");

		try {
			return dbDao.searchExptTPList();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Exception Detail Type 조회 기능<br>
	 * 
	 * @param SearchExpInfoVO expInfo
	 * @return List<SearchExptDTLTPListVO>
	 * @throws EventException
	 */
	public List<SearchExptDTLTPListVO> searchExptDTLTPList(SearchExpInfoVO expInfo) throws EventException {
		log.debug("ESDSCE0049 - searchTOLExptDTLTPList 함수 진입");

		try {
			return dbDao.searchTOLExptDTLTPList(expInfo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Exception Type 조회 기능<br>
	 * 
	 * @return List<SearchExptTPListVO>
	 * @throws EventException
	 */
	public List<SearchExptTPListVO> searchTOLExptTPList() throws EventException {
		log.debug("ESDSCE0029 - searchTOLExptTPList 함수 진입");

		try {
			return dbDao.searchExptTPList();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Exception Detail Type 조회 기능<br>
	 * 
	 * @param SearchExpInfoVO expInfo
	 * @return List<SearchExptDTLTPListVO>
	 * @throws EventException
	 */
	public List<SearchExptDTLTPListVO> searchTOLExptDTLTPList(SearchExpInfoVO expInfo) throws EventException {
		log.debug("ESDSCE0029 - searchTOLExptDTLTPList 함수 진입");

		try {
			return dbDao.searchTOLExptDTLTPList(expInfo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Exception Loc/Ofc 조회 기능<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
//	public EventResponse searchLocOfcList() throws EventException {
//	//	public EventResponse searchLocOfcList(EsdSce0028Event e) throws EventException {
//	// &&& 소스품질수정
//		// PDTO(Data Transfer Object including Parameters)
//
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet rowSet = null;
//
//		try {
//			rowSet = dbDao.searchLocOfcList();
//			return new EsdSce0028EventResponse(rowSet, "SUCCESS");
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}
	
	/**
	 * Exception Office Mapping(master office) 조회 &&&
	 * 
	 * @param SearchExpmasterOfcInfoVO ofcInfo
	 * @return List<SearchExpMasterOfcListVO>
	 * @throws EventException
	 */
	public List<SearchExpMasterOfcListVO> searchExpMasterOfcList(SearchExpmasterOfcInfoVO ofcInfo) throws EventException {
		log.debug("ESDSCE0112 - searchExpMasterOfcList 함수 진입");

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
		log.debug("ESDSCE0112 - searchExpMapgOfcList 함수 진입");
		try {
			return dbDao.searchExpMapgOfcList();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	

	/**
	 * Exception Office Mapping(multiExpMapgOfc| Mapping Office save 버튼 클릭시) &&&
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
	 * Master Office 조회결과 더블클릭시 Mapping Office 결과 조회&&&
	 * 
	 * @param SearchExpmasterOfcInfoVO ofcInfo
	 * @return List<SearchExpMapgOfcList3VO>
	 * @exception EventException
	 */
	public List<SearchExpMapgOfcList3VO> searchExpMapgOfcList3(SearchExpmasterOfcInfoVO ofcInfo) throws EventException {
		log.debug("ESDSCE0112 - searchExpMapgOfcList3 함수 진입");
		try {
			return dbDao.searchExpMapgOfcList3(ofcInfo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
}