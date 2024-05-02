/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : LaneServiceBCImpl.java
 *@FileTitle : LaneServiceBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.07.15
 *@LastModifier : 함대성
 *@LastVersion : 1.0
 * 2010.07.15 함대성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0140Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0146Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0150Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0151Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0152Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0154Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0155Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0157Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0160Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0163Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0164Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.integration.DwellNotificationDBDAO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DewllNotifiySetupExpContainerVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwellNofifySendStsVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwellNotifyLMTDateVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwllNtfcSrchVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchDwellVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchMSExptSaveVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwellRnsVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchOneTimeSndHistVO;
import com.hanjin.syscommon.common.table.SceDwllCustSvcListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-CustomerScheduleEdi Business Logic Command implementation<br>
 * - NIS2010-CustomerScheduleEdi에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author HAM DAE SUNG
 * @see
 * @since J2EE 1.4
 */
public class DwellNotificationBCImpl  extends BasicCommandSupport implements DwellNotificationBC {
	// Database Access Object
	private transient DwellNotificationDBDAO dbDao=null;
	// EAI Interface Object
	//private transient LaneServiceSendEAIDAO eaiDao = null;
	/**
	 * LaneServiceBCImpl 객체 생성<br>
	 * LaneServiceDBDAO 생성한다.<br>
	 */
	public DwellNotificationBCImpl(){
		dbDao = new DwellNotificationDBDAO();
		//eaiDao = new LaneServiceSendEAIDAO();
	}
	
	/**
	 * Dwell Type별 목록 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDwellList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0140Event event=(EsdSce0140Event)e;
		
		try {
			return dbDao.searchDwellList(event);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * DWELL REASON 의 입력 내역 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDwellResonByVVD(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0140Event event=(EsdSce0140Event)e;
		
		try {
			return dbDao.searchDwellResonByVVD(event);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * DWELL Emailing list를 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDwellEmailList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0140Event event=(EsdSce0140Event)e;
		
		try {
			return dbDao.searchDwellEmailList(event);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * DWELL REASON 의 입력 내역 수정 이벤트 처리<br>
	 * 
	 * @param e EsdSce0140Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse updateDwellResonByVVD(EsdSce0140Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		//EsdSce0140Event event=(EsdSce0140Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.updateDwellResonByVVD(e);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * Dwell Type별 Total Count 값 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDwellTotalCnt(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0140Event event=(EsdSce0140Event)e;
		
		try {
			return dbDao.searchDwellTotalCnt(event);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Microsoft Exception List 값 조회 이벤트 처리<br>
	 *  
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMSExptList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0146Event event=(EsdSce0146Event)e;
		
		try {
			return dbDao.searchMSExptList(event);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Microsoft Exception List 값 저장 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @param String usr_id
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyMSExptList(Event e, String usr_id) throws EventException{
		EsdSce0146Event event=(EsdSce0146Event)e;
		SearchMSExptSaveVO[] models = event.getSearchMSExptSaveVOs();         
		try {
			for ( int i=0; i<models.length; i++ ) {
				if ( models[i].getIbflag().equals("U")){
					models[i].setCreUsrId(usr_id);
					models[i].setUpdUsrId(usr_id);
					dbDao.modifyMSExptList(models[i]);
				}
			}
		
     	} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		 return null;
	}

	/**
	 * Email List 조회
     * @param  Event e
     * @return List<DwllNtfcSrchVO>
     * @exception EventException
	 */
	public List<DwllNtfcSrchVO> searchDwllNtfcSvcList(Event e) throws EventException {

			List<DwllNtfcSrchVO> list = null;
			try {
				list = dbDao.searchDwllNtfcSvcList((EsdSce0154Event) e);
	        } catch (DAOException de) {
	        	log.error(de.getMessage(), de);
	            throw new EventException(de.getMessage());
	        }
	        return list;
	}

	
	/**
	 * Email List 조회(단건, Row Add일 경우)
     * @param  DwllNtfcSrchVO dwllvo
     * @return List<DwllNtfcSrchVO>
     * @exception EventException
	 */
	public DwllNtfcSrchVO searchDwllNtfcSvcItem(DwllNtfcSrchVO dwllvo) throws EventException {
		try {
		    return dbDao.searchDwllNtfcSvcItem(dwllvo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
 
	/**
	 * Dwell Notification Exception List 저장
	 * @param Event e
	 * @param String usr_id
	 * @param String ofc_cd
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse addDwllNtfcExptForSvc(Event e , String usr_id, String ofc_cd) throws EventException {
		EsdSce0154Event event=(EsdSce0154Event)e;
		try {
			DwllNtfcSrchVO[] models = event.getDwllNtfcSrchVOS();
			List<DwllNtfcSrchVO> insertVoList = new ArrayList<DwllNtfcSrchVO>();
			List<DwllNtfcSrchVO> deleteVoList = new ArrayList<DwllNtfcSrchVO>();
			for ( int i=0; i<models .length; i++ ) {
				models[i].setUsrid(usr_id);
				models[i].setOfcCd(ofc_cd);
				if ( models[i].getIbflag().equals("I")){
					insertVoList.add(models[i]);
				}else if( models[i].getIbflag().equals("D")){
					deleteVoList.add(models[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addDwllNtfcExptForSvc(insertVoList);
				dbDao.addDwllNtfcExptHistory(insertVoList);
			}
			if (deleteVoList.size() > 0){
				dbDao.deleteDwllNtfcExptForSvc(deleteVoList);
				dbDao.addDwllNtfcExptHistory(deleteVoList);
			}
            return null;
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	
	}

	/**
	 * Email 정보를 조회를 해온다.
     * @param  DwllNtfcSrchVO dwllvo
     * @return List<DwllNtfcSrchVO>
     * @exception EventException
	 */
	public List<DwllNtfcSrchVO> searchDwllNtfcSvcPopUpList(DwllNtfcSrchVO dwllvo) throws EventException {

			List<DwllNtfcSrchVO> list = null;			
			try {
				list = dbDao.searchDwllNtfcSvcPopUpList(dwllvo);
	        } catch (DAOException de) {
	        	log.error(de.getMessage(), de);
	            throw new EventException(de.getMessage());
	        }
	        return list;
	}
	
	/**
	 * email 정보를 관리<br>
	 * <br>
	 * 
	 * @param Event e
	 * @param String account
	 * @param String ofcCd
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse manageDwllNtfcSvcList(Event e , String account, String ofcCd) throws EventException {
		EsdSce0155Event event=(EsdSce0155Event)e;
		DwllNtfcSrchVO[] models = event.getDwllNtfcSrchVOS();
		DwllNtfcSrchVO dwllvo = null;
		String[] cloumndata  = null;
		String ntfcseq = null;
		try {
            // SCE_DWLL_NTFC_EXPT를 등록한다.(없을 경우 default insert)
            List<DwllNtfcSrchVO> insModels = new ArrayList<DwllNtfcSrchVO>();
            DwllNtfcSrchVO dwllNtfcSrchVO = new DwllNtfcSrchVO();
            dwllNtfcSrchVO.setCustCd(models[0].getCustCd());
            dwllNtfcSrchVO.setScno(models[0].getScno());
            dwllNtfcSrchVO.setUsrid(account);
            insModels.add(dwllNtfcSrchVO);
            dbDao.addDwllNtfcExptForSvc(insModels);


			for ( int i=0; i<models .length; i++ ) {
				if ( models[i].getIbflag().equals("I")){
					models[i].setUsrid(account);
					models[i].setCreOfcCd(ofcCd);
					log.debug("=======email address" + models[i].getSubscEml());
					// 중복체크를 위해서 
					dwllvo = dbDao.searchDwllNtfcSvcListDtl(models[i].getCustCd(),models[i].getSubscEml(),models[i].getNtfcSeq());
					cloumndata = dwllvo.getResultStrArray();
					if(cloumndata[0].endsWith("ERR1") || cloumndata[0].endsWith("ERR2") || cloumndata[0].endsWith("ERR3")){
						throw new EventException(new ErrorHandler(" Email Address is Duplicate!").getMessage());
					}else {
						// 신규데이터이면 실행
						ntfcseq = cloumndata[1].toString();
						log.debug("======체크" + ntfcseq);
						if (ntfcseq.equals("")){
							dbDao.insertDwllNtfcSvcListDtl(models[i]);
						// 이미 있는 데이터 이면 update를 실행
						}else{
							dbDao.updateDwllNtfcSvcListDtl(models[i]);
						}
					}
					
				}else if(models[i].getIbflag().equals("U")) {
					 models[i].setUsrid(account);
					 models[i].setCreOfcCd(ofcCd);
			 	     dbDao.updateDwllNtfcSvcListDtl(models[i]);	 
				   
				}else if(models[i].getIbflag().equals("D")) {
					models[i].setUsrid(account);
					dbDao.modifyDwllNtfcSvcListDtl(models[i]);
				}
			
			}

            return null;
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	
	}

	/**
	 * email Detail List 저장<br>
	 * <br>
	 * 
	 * @param Event e
	 * @param String account
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyDwllNtfcSvcListDtl(Event e , String account) throws EventException {
		EsdSce0155Event event=(EsdSce0155Event)e;
		DwllNtfcSrchVO[] models = event.getDwllNtfcSrchVOS();
	
		try {
			for ( int i=0; i<models.length; i++ ) {
				if ( models[i].getIbflag().equals("U")){
					models[i].setUsrid(account);
					dbDao.modifyDwllNtfcSvcListDtl(models[i]);
					}
				}

            return null;
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	
	}
	/**
	 * E-mail Sending Exception List 검색.
     * @param  DwllNtfcSrchVO dwllvo
     * @return List<DwllNtfcSrchVO>
     * @exception EventException
	 */
	public List<DwllNtfcSrchVO>searchDwllNtfcExptList(DwllNtfcSrchVO dwllvo) throws EventException {

			List<DwllNtfcSrchVO> list = null;			
			try {
				list = dbDao.searchDwllNtfcExptList(dwllvo);
	        } catch (DAOException de) {
	        	log.error(de.getMessage(), de);
	            throw new EventException(de.getMessage());
	        }
	        return list;
	}

	/**
	 * E-mail Sending Exception List 저장 <br>
	 * <br>
	 * 
	 * @param  e Event
	 * @param  usrId String
	 * @param  ofcCd String
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse addDwllNtfcExpt(Event e , String usrId, String ofcCd) throws EventException {
		EsdSce0151Event event=(EsdSce0151Event)e;
		DwllNtfcSrchVO[] models = event.getDwllNtfcSrchVOS();
			try {
			List<DwllNtfcSrchVO> insertVoList = new ArrayList<DwllNtfcSrchVO>();
			List<DwllNtfcSrchVO> deleteVoList = new ArrayList<DwllNtfcSrchVO>();
			for ( int i=0; i<models .length; i++ ) {
			 	models[i].setUsrid(usrId);
			 	models[i].setOfcCd(ofcCd);
			 	if(models[i].getIbflag().equals("I")||models[i].getIbflag().equals("U")){
			 		insertVoList.add(models[i]);
			 	}else if(models[i].getIbflag().equals("D")){
			 		deleteVoList.add(models[i]);
			 	}
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addDwllNtfcExpt(insertVoList);
				dbDao.addDwllNtfcExptHistory(insertVoList);
			}
			if (deleteVoList.size()>0){
				dbDao.deleteDwllNtfcExpt(deleteVoList);// 딜리트 쿼리 추가
				dbDao.addDwllNtfcExptHistory(deleteVoList);
			}
     	} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		 return null;
	}
	/**
	 * Dwell Type별 E-Mail로 발송된 CNTR 개수를 조회<br>
	 * 
	 * @param e Event
	 * @return List<DwellNofifySendStsVO>
	 * @exception EventException
	 */
	public List<DwellNofifySendStsVO> searchDwellNofifySendSts(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0150Event event=(EsdSce0150Event)e;
		
		try {
			return dbDao.searchDwellNofifySendSts(event);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Dwell Type별 E-Mail로 발송된 CNTR 개수를 Customer Code별 조회<br>
	 * 
	 * @param e Event
	 * @return List<DwellNofifySendStsVO>
	 * @exception EventException
	 */
	public List<DwellNofifySendStsVO> searchDwellNofifySendStsDtl(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0152Event event=(EsdSce0152Event)e;
		
		try {
			return dbDao.searchDwellNofifySendStsDtl(event);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Dwell Notification은 USNYC기준으로 화면 표시하도록 처리된다.
	 * 이에 대응해서 화면 처리가 되도록 정보를 제공
	 * @return DwellNotifyLMTDateVO
	 * @throws EventException
	 */
	public DwellNotifyLMTDateVO searchDwellNotifyLMTDate() throws EventException {
		try {
			return dbDao.searchDwellNotifyLMTDate();
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Set up for Exception by Container 검색.
     * @param  DewllNotifiySetupExpContainerVO dwllvo
     * @return List<DewllNotifiySetupExpContainerVO>
     * @exception EventException
	 */
	public List<DewllNotifiySetupExpContainerVO>searchDwllNtfcExptCntList(DewllNotifiySetupExpContainerVO dwllvo) throws EventException {

			List<DewllNotifiySetupExpContainerVO> list = null;			
			try {
				list = dbDao.searchDwllNtfcExptCntList(dwllvo);
	        } catch (DAOException de) {
	        	log.error(de.getMessage(), de);
	            throw new EventException(de.getMessage());
	        }
	        return list;
	}

	/**
	 * E-mail Sending Exception List 저장 <br>
	 * <br>
	 * 
	 * @param  e Event
	 * @param  usrId String
	 * @param  ofcCd String
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse addDwllNtfcExptCnt(Event e , String usrId, String ofcCd) throws EventException {
		EsdSce0157Event event=(EsdSce0157Event)e;
		String[] cntMov = new String[4];
		DewllNotifiySetupExpContainerVO[] models = event.getDewllNotifiySetupExpContainerVOS();
			try {
			log.debug("======count===" +models .length );
			for ( int i=0; i<models .length; i++ ) {
				if ( models[i].getIbflag().equals("I")){
				// 해당 cntr_no 기준으로 값을 조회를 해온다.
				cntMov = dbDao.addDwllNtfcExptCntCtmMov(models[i].getCntrNo());
				models[i].setUserId(usrId);
				models[i].setCnmvYr(cntMov[1]);
				models[i].setCnmvIdNo(cntMov[2]);
			 	models[i].setCnmvCycNo(cntMov[3]);
			 	models[i].setExptSetOfcCd(ofcCd);
			 	dbDao.addDwllNtfcExptCnt(models[i]);
				dbDao.addDwllNtfcExptCntHistory(models[i]);
				}else if (models[i].getIbflag().equals("U")) {
				//	cntMov = dbDao.addDwllNtfcExptCntCtmMov(models[i].getCntrNo());
					models[i].setUserId(usrId);
				//	models[i].setCnmvYr(cntMov[1]);
				//	models[i].setCnmvIdNo(cntMov[2]);
				// 	models[i].setCnmvCycNo(cntMov[3]);
				 	models[i].setExptSetOfcCd(ofcCd);
				 	dbDao.addDwllNtfcExptCnt(models[i]);
					dbDao.addDwllNtfcExptCntHistory(models[i]);
				}else if (models[i].getIbflag().equals("D")){
//					cntMov = dbDao.addDwllNtfcExptCntCtmMov(models[i].getCntrNo());
  				    models[i].setUserId(usrId);
//					models[i].setCnmvYr(cntMov[1]);
//					models[i].setCnmvIdNo(cntMov[2]);
//				 	models[i].setCnmvCycNo(cntMov[3]);
				 	models[i].setExptSetOfcCd(ofcCd);
				 	dbDao.modifyDwllNtfcExptCnt(models[i]);
					dbDao.addDwllNtfcExptCntHistory(models[i]);
				}
		 	
			}
			
     	} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		 return null;
	}

	/**
	 * Master Booking Row 검색.
     * @param  DewllNotifiySetupExpContainerVO dwllvo
     * @return List<DewllNotifiySetupExpContainerVO>
     * @exception EventException
	 */
	public DewllNotifiySetupExpContainerVO searchDwllNtfcExptCntMastBkg(DewllNotifiySetupExpContainerVO dwllvo) throws EventException {
		String[] cntMov = new String[4];
		try {
			cntMov = dbDao.addDwllNtfcExptCntCtmMov(dwllvo.getCntrNo());
			dwllvo.setCnmvYr(cntMov[1]);
			dwllvo.setCnmvIdNo(cntMov[2]);
			dwllvo.setCnmvCycNo(cntMov[3]);
		    return dbDao.searchDwllNtfcExptCntMastBkg(dwllvo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Candidate Inquiry by Dwell Type별 목록 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDwellCandidateList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0160Event event=(EsdSce0160Event)e;
		
		try {
			return dbDao.searchDwellCandidateList(event);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Customer Type Code 조회.<br>
	 * @param String custCd
	 * @return String
	 * @throws EventException
	 */
	public String searchRvisCntrCustTpCd(String custCd) throws EventException {

		DBRowSet rowSet = null;							
        String retVal = "";
        
        try {
            rowSet=dbDao.searchRvisCntrCustTpCd(custCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	
	}
 
	/**
	 * 해당 SC No를 조회한다.<br>
	 * @param String custCd
	 * @return String
	 * @throws EventException
	 */
	public String searchScNoInfo(String custCd) throws EventException {

		DBRowSet rowSet = null;							
        String retVal = "";
        
        try {
            rowSet=dbDao.searchScNoInfo(custCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	
	}
	
	/**
	 * c<br>
	 * <br>
	 * 
	 * @param Event e
	 * @param String account
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyDwllEmailSendOption(Event e , String account) throws EventException {
		EsdSce0164Event event=(EsdSce0164Event)e;
		SearchDwellVO dwellVO = event.getSearchDwellVO();
		List<SceDwllCustSvcListVO> list = new ArrayList<SceDwllCustSvcListVO>();
		String[] maininfo = new String[2];
		String[] targetinfo = new String[2];
		String cntr_no = dwellVO.getCntrNo(); 
		log.debug("====cntr_no=======" + cntr_no);
	    String cntr_no1 = dwellVO.getCntrNo1(); //화면 입력 된 값
	    String search_dt = dwellVO.getSearchDt();
	    String cntrList = dwellVO.getCntrList();
	    String cust_cd ="";
	    String cust_seq ="";
	    int ntfc_seq = 0;
	    String[] cntrListArray = cntrList.split(",");
		try {
			if (!"".equals(dwellVO.getCntrNo1())){
				//cntr 정보를 이용을 해서 SCE_DWLL_CNDDT_SVC_LIST테이블에 조회 가능 한 정보를 가져온다.
				//CNUST_CD을 가져온다. 
				maininfo = dbDao.searchCandtHisInfo(cntr_no1 ,search_dt);
				//SCE_DWLL_CUST_SVC_LIST 테이블의 정보를 가져온다.
				list = dbDao.searchSceDwllCustSvcList(maininfo);
				
			}else{
					//cntr 정보를 이용을 해서 SCE_DWLL_CNDDT_SVC_LIST테이블에 조회 가능 한 정보를 가져온다.
					//CNUST_CD을 가져온다. 
					maininfo = dbDao.searchCandtHisInfo(cntr_no ,search_dt);
					//SCE_DWLL_CUST_SVC_LIST 테이블의 정보를 가져온다.
					list = dbDao.searchSceDwllCustSvcList(maininfo);	
			}
			
			if( !"".equals(list)){
				for(int i=0 ; i< cntrListArray.length ; i++){
					//cntr 정보를 이용을 해서 SCE_DWLL_CNDDT_SVC_LIST테이블에 조회 가능 한 정보를 가져온다.
					//CNUST_CD을 가져온다.
					targetinfo = dbDao.searchCandtHisInfo(cntrListArray[i] ,search_dt);
					cust_cd = targetinfo[0];
					cust_seq = targetinfo[1];
					ntfc_seq = dbDao.searchMaxNtfcSeq(cust_cd , cust_seq);
					log.debug("main" + maininfo[0]+ maininfo[1] );
					log.debug("target" +cust_cd + cust_seq);
					if(!cust_cd.equals(maininfo[0]) || !cust_seq.equals(maininfo[1])){
						for (int k=0 ; k < list.size() ; k++){
							 ntfc_seq = ntfc_seq + 1;
							 list.get(k).setDwllCustCntCd(cust_cd);
							 list.get(k).setDwllCustSeq(cust_seq);
							 list.get(k).setNtfcSeq(Integer.toString(ntfc_seq));
							 list.get(k).setCreUsrId(account);
							 list.get(k).setUpdUsrId(account);
							 dbDao.addSceDwllCustSvcList(list.get(k));
							 
						}
					}
				}
			}
	      
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	    return null;
	}
	/**
	 * Candidate Email 정보를 조회를 해온다.
     * @param  DwllNtfcSrchVO dwllvo
     * @return List<DwllNtfcSrchVO>
     * @exception EventException
	 */
	public List<DwllNtfcSrchVO> searchCandidateDwllNtfcSvcPopUpList(DwllNtfcSrchVO dwllvo) throws EventException {

			List<DwllNtfcSrchVO> list = null;			
			try {
				list = dbDao.searchCandidateDwllNtfcSvcPopUpList(dwllvo);
	        } catch (DAOException de) {
	        	log.error(de.getMessage(), de);
	            throw new EventException(de.getMessage());
	        }
	        return list;
	}
	
	/**
	 * Candidate email 정보를 관리<br>
	 * <br>
	 * 
	 * @param Event e
	 * @param String account
	 * @param String ofcCd
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse manageCandidateDwllNtfcSvcList(Event e , String account, String ofcCd) throws EventException {
		EsdSce0163Event event=(EsdSce0163Event)e;
		DwllNtfcSrchVO[] models = event.getDwllNtfcSrchVOS();
		DwllNtfcSrchVO dwllvo = null;
		String[] cloumndata  = null;
		String ntfcseq = null;
		try {
            // SCE_DWLL_NTFC_EXPT를 등록한다.(없을 경우 default insert)
            List<DwllNtfcSrchVO> insModels = new ArrayList<DwllNtfcSrchVO>();
            DwllNtfcSrchVO dwllNtfcSrchVO = new DwllNtfcSrchVO();
            dwllNtfcSrchVO.setCustCd(models[0].getCustCd());
            dwllNtfcSrchVO.setScno(models[0].getScno());
            dwllNtfcSrchVO.setUsrid(account);
            insModels.add(dwllNtfcSrchVO);
            dbDao.addDwllNtfcExptForSvc(insModels);


			for ( int i=0; i<models .length; i++ ) {
				if ( models[i].getIbflag().equals("I")){
					models[i].setUsrid(account);
					models[i].setCreOfcCd(ofcCd);
					log.debug("=======email address" + models[i].getSubscEml());
					// 중복체크를 위해서 
					dwllvo = dbDao.searchDwllNtfcSvcListDtl(models[i].getCustCd(),models[i].getSubscEml(),models[i].getNtfcSeq());
					cloumndata = dwllvo.getResultStrArray();
					if(cloumndata[0].endsWith("ERR1") || cloumndata[0].endsWith("ERR2") || cloumndata[0].endsWith("ERR3")){
						throw new EventException(new ErrorHandler(" Email Address is Duplicate!").getMessage());
					}else {
						// 신규데이터이면 실행
						ntfcseq = cloumndata[1].toString();
						log.debug("======체크" + ntfcseq);
						if (ntfcseq.equals("")){
							dbDao.insertCandidateDwllNtfcSvcListDtl(models[i]);
						// 이미 있는 데이터 이면 update를 실행
						}else{
							dbDao.updateCandidateDwllNtfcSvcListDtl(models[i]);
						}
					}
					
				}else if(models[i].getIbflag().equals("U")) {
					 models[i].setUsrid(account);
					 models[i].setCreOfcCd(ofcCd);
			 	     dbDao.updateCandidateDwllNtfcSvcListDtl(models[i]);	 
				   
				}else if(models[i].getIbflag().equals("D")) {
					models[i].setUsrid(account);
					dbDao.modifyCandidateDwllNtfcSvcListDtl(models[i]);
				}
			
			}

            return null;
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	
	}
	
	/**
	 * UI_ESD_SCE_0160 조회화면의  Dwll Reason 검색.
     * @param  DwellRnsVO dwllvo
     * @return List<DwellRnsVO>
     * @exception EventException
	 */
	public DwellRnsVO searchDwellRsn(DwellRnsVO dwllvo) throws EventException {

			try {
				return dbDao.searchDwellRsn(dwllvo);
	        } catch (DAOException de) {
	        	log.error(de.getMessage(), de);
	            throw new EventException(de.getMessage());
	        }
	 }
	

	/**
	 * UI_ESD_SCE_0160 조회화면의  Dwll Reason 저장 <br>
	 * @param  e Event
	 * @param  usrId String
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse manageDwellRsn(Event e , String usrId) throws EventException {
		EsdSce0160Event event=(EsdSce0160Event)e;
		DwellRnsVO[] models = event.getDwellRnsVOs();
			try {
			List<DwellRnsVO> updVoList = new ArrayList<DwellRnsVO>();
			for ( int i=0; i<models .length; i++ ) {
			 	models[i].setUpdUsrId(usrId);
			 	models[i].setCreUsrId(usrId);
			 	updVoList.add(models[i]);
		 	
			}
			if ( updVoList.size() > 0 ) {
				dbDao.addDwellRsn(updVoList);
			}
     	} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		 return null;
	}

	
	/**
	 * UI_ESD_SCE_0160 조회화면의  Dwll Reason 저장  <br>
	 * <br>
	 * 
	 * @param  DwellRnsVO dwllvo
	 * @param  String[] colvalue
	 * @param  usrId String
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse manageDwellRsn1(DwellRnsVO dwllvo ,String[] colvalue, String usrId) throws EventException {
		    DwellRnsVO models = new DwellRnsVO();
		 	try {
			List<DwellRnsVO> updVoList = new ArrayList<DwellRnsVO>();
			    models.setBkgNo(dwllvo.getBkgNo());
			    models.setCntrNo(dwllvo.getCntrNo());
			    models.setEmlSndDt(dwllvo.getEmlSndDt());
			    models.setDwllRsn(colvalue[0].toString());
			    models.setDwllRsnTpCd(dwllvo.getDwllRsnTpCd());
			    models.setDwllTmTpCd(dwllvo.getDwllTmTpCd());
			    models.setHisSeq("1");
			 	models.setUpdUsrId(usrId);
			 	models.setCreUsrId(usrId);
			 	updVoList.add(models);
		 
			if ( updVoList.size() > 0 ) {
				dbDao.addDwellRsn(updVoList);
			}
     	} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		 return null;
	}

	/**
	 * Customer Code 유/무 조회.<br>
	 * @param String custCd
	 * @return String
	 * @throws EventException
	 */
	public String checkCustCd(String custCd) throws EventException {

		DBRowSet rowSet = null;							
        String retVal = "";
        
        try {
            rowSet=dbDao.checkCustCd(custCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	
	}
	
	/**
	 * Dwell Notification Exception 항목 단건 조회
     * @param  DwllNtfcSrchVO dwllvo
     * @return List<DwllNtfcSrchVO>
     * @exception EventException
	 */
	public DwllNtfcSrchVO searchDwllNtfcExptItem(DwllNtfcSrchVO dwllvo) throws EventException {
		try {
			return dbDao.searchDwllNtfcExptItem(dwllvo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Candidate Email 정보를 조회를 해온다.
     * @param  SearchOneTimeSndHistVO searchOneTimeSndHistVO
     * @return List<SearchOneTimeSndHistVO>
     * @exception EventException
	 */
	public List<SearchOneTimeSndHistVO> searchOneTimeSndHistList(SearchOneTimeSndHistVO searchOneTimeSndHistVO) throws EventException {

			List<SearchOneTimeSndHistVO> list = null;			
			try {
				list = dbDao.searchOneTimeSndHistList(searchOneTimeSndHistVO);
	        } catch (DAOException de) {
	        	log.error(de.getMessage(), de);
	            throw new EventException(de.getMessage());
	        }
	        return list;
	}

	/**
	 * Candidate Type tab별 Total Count 값 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDwellCandidateTotalCnt(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0160Event event=(EsdSce0160Event)e;
		
		try {
			return dbDao.searchDwellCandidateTotalCnt(event);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
}