/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DOFChgColPermanageBC
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-30
*@LastModifier : ho-sam lee
*@LastVersion : 1.0
* 2008-01-30 ho-sam lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.basic;

import java.util.ArrayList;
import java.util.Collection;

import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0007Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0011Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0012Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0013Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.integration.DOFChgTrfmanageDBDAO;
import com.hanjin.apps.alps.esd.eas.transportmanage.vo.CommEasDrffChgTrfVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EasDrffChgTrfDtlVO;
import com.hanjin.syscommon.common.table.EasDrffChgTrfHdrVO;

/**
 * DOFChgTrfmanageBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class DOFChgTrfmanageBCImpl extends BasicCommandSupport implements DOFChgTrfmanageBC {

	
	// Database Access Object
	private transient DOFChgTrfmanageDBDAO dbDao = null;

	/**
	 * OutstandingManageBCImpl 객체 생성<br>
	 * OutstandingManageDBDAO를 생성한다.<br>
	 */
	public DOFChgTrfmanageBCImpl(){
		dbDao = new DOFChgTrfmanageDBDAO();
	}

	/**
	 * searchDofChgTrfList 기본 조회 기능<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDofChgTrfList(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet = dbDao.searchDofChgTrfList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * searchEasDrffChgTrfHdrRSQL 기본 조회 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEasDrffChgTrfHdrRSQL(Event e) throws EventException {

		EsdEas0011Event event=(EsdEas0011Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		try {
//			rowSet = dbDao.searchEasDrffChgTrfHdrRSQL(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
			
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}

	/**
	 * searchEasDrffChgTrfDtlRSQL 기본 조회 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEasDrffChgTrfDtlRSQL(Event e) throws EventException {

		EsdEas0011Event event=(EsdEas0011Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		try {
//			
//			log.info("getCntCd:::::::::"+event.getCntCd());
//			log.info("getRfaNo:::::::::"+event.getRfaNo());
			
//			rowSet = dbDao.searchEasDrffChgTrfDtlRSQL(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
			
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}
	
	/**
	 * searchEasDrffChgTrfDtlSccRSQL 기본 조회 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEasDrffChgTrfDtlSccRSQL(Event e) throws EventException {

		EsdEas0011Event event=(EsdEas0011Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		try {
//			
//			log.info("getCntCd:::::::::"+event.getCntCd());
//			log.info("getRfaNo:::::::::"+event.getRfaNo());
//			
//			rowSet = dbDao.searchEasDrffChgTrfDtlSccRSQL(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
			
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}
	
	/**
	 * searchEffDT Effect 날짜 조회 기능<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEffDT(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {

			rowSet = dbDao.searchEffDT(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * RfaNo 체크 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse checkRfaNo(Event e) throws EventException {

		EsdEas0011Event event=(EsdEas0011Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		try {
//
//			rowSet = dbDao.checkRfaNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
			
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}
	
	/**
	 * RfaNo 체크 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse checkInputRfaNo(Event e) throws EventException {

		EsdEas0011Event event=(EsdEas0011Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		try {
//
//			rowSet = dbDao.checkInputRfaNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
			
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}
	
	/**
	 * Country Search 체크 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCountryCombo(Event e) throws EventException {

		EsdEas0011Event event=(EsdEas0011Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		try {
//
//			rowSet = dbDao.searchCountryCombo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
			
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}
	
	/**
	 * Curr Code 체크 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCurrCd(Event e) throws EventException {
		EsdEas0011Event event=(EsdEas0011Event)e;		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		try {
//
//			rowSet = dbDao.searchCurrCd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
			
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}	
	
	/**
	 * Curr Code 리스트 목록 조회 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCurrList(Event e) throws EventException {
		EsdEas0011Event event=(EsdEas0011Event)e;		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		try {
//
//			rowSet = dbDao.searchCurrList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
			
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}		
	
	
	/**
	 * multiDofChgTrf 등록.수정,삭제
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiDofChgTrf(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
    	try {
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
        	dbDao.multiDofChgTrf(event);
        	return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
		
	/**
	 * multiDrffChgTrf 등록.수정,삭제
	 * @param String isSave
	 * @param EasDrffChgTrfHdrVO easDrffChgTrfHdrVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */	
	public void multiDrffChgTrf(String isSave, EasDrffChgTrfHdrVO easDrffChgTrfHdrVO, SignOnUserAccount account) throws EventException {
		String[] chkData = null;		
		String rtnData = "";
		String effChk = "";
//		try {	
//			if(!isSave.equals("R")){			
//				if (isSave.equals("I")){
//					rtnData = dbDao.searchEasDrffChgTrfVerChk(easDrffChgTrfHdrVO);
//					chkData = rtnData.split(",");
//					if (chkData[0].equals("Y")){
//						easDrffChgTrfHdrVO.setDrffChgTrfVerNo(chkData[1]);
//						easDrffChgTrfHdrVO.setDrffChgTrfSeq(chkData[2]);	
//						dbDao.addDrffChgTrf(easDrffChgTrfHdrVO, account);
//					}else{
//						throw new EventException("VerChk is null!");
//					}
//				} else if (isSave.equals("U")){
//					dbDao.modifyDrffChgTrf(easDrffChgTrfHdrVO, account);
//				}			
//			
//				effChk = dbDao.searchEasDrffChgTrfEffdtChk(easDrffChgTrfHdrVO);		
//				 // 2.EffDt Update
//				if (effChk.equals("Y")) {
//					dbDao.modifyDrffChgTrfEffdt(easDrffChgTrfHdrVO);
//				} else {
//					throw new EventException("FmEffDt is Error!");
//				}
//			}
//		} catch(DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
//		}
	}	
	
	/**
	 * multiDrffChgTrfDtl 등록.수정,삭제 
	 * @param String isUpload
	 * @param EasDrffChgTrfHdrVO easDrffChgTrfHdrVO
	 * @param CommEasDrffChgTrfVO[] commEasTrfVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */		
	public void multiDrffChgTrfDtl(String isUpload, EasDrffChgTrfHdrVO easDrffChgTrfHdrVO, CommEasDrffChgTrfVO[] commEasTrfVOs, SignOnUserAccount account) throws EventException {		
		int MaxSeq = 0;

//		try {
//			MaxSeq = dbDao.searchEasDrffChgTrfDtlSeq(easDrffChgTrfHdrVO);
//
//			EasDrffChgTrfDtlVO easDrffChgTrfDtlVO = null;
//
//			Collection<EasDrffChgTrfDtlVO> insertDtlVoList = new ArrayList<EasDrffChgTrfDtlVO>();
//			Collection<EasDrffChgTrfDtlVO> updateDtlVoList = new ArrayList<EasDrffChgTrfDtlVO>();	
//			Collection<EasDrffChgTrfDtlVO> deleteDtlVoList = new ArrayList<EasDrffChgTrfDtlVO>();
//
//			if(commEasTrfVOs != null){						
//				for (int i=0; i<commEasTrfVOs.length; i++) {														
//					if( (commEasTrfVOs[i].getDrffChgTrfVerNo().equals("") || commEasTrfVOs[i].getDrffChgTrfVerNo() == null)){						
//						commEasTrfVOs[i].setIbflag("I"); 							
//					}								
//										
//					if (commEasTrfVOs[i].getIbflag().equals("I")) {																		
//						commEasTrfVOs[i].setDrffChgTrfDtlSeq(String.valueOf(MaxSeq++));
//					}
//															
//					easDrffChgTrfDtlVO = new EasDrffChgTrfDtlVO();
//					easDrffChgTrfDtlVO.setDrffChgTrfSeq(easDrffChgTrfHdrVO.getDrffChgTrfSeq());
//					easDrffChgTrfDtlVO.setDrffChgTrfVerNo(easDrffChgTrfHdrVO.getDrffChgTrfVerNo());
//					commEasTrfVOs[i].setDrffChgTrfSeq(easDrffChgTrfHdrVO.getDrffChgTrfSeq());
//					commEasTrfVOs[i].setDrffChgTrfVerNo(easDrffChgTrfHdrVO.getDrffChgTrfVerNo());
//					easDrffChgTrfDtlVO.setDrffChgTrfDtlSeq(commEasTrfVOs[i].getDrffChgTrfDtlSeq());
//					easDrffChgTrfDtlVO.setSccCd(commEasTrfVOs[i].getSccCd());
//					easDrffChgTrfDtlVO.setPortInlndCd(commEasTrfVOs[i].getPortInlndCd());
//					easDrffChgTrfDtlVO.setContiCd(commEasTrfVOs[i].getContiCd());
//					easDrffChgTrfDtlVO.setPodCntCd(commEasTrfVOs[i].getPodCntCd());
//					easDrffChgTrfDtlVO.setPodCntListCtnt(commEasTrfVOs[i].getPodCntListCtnt());
//					easDrffChgTrfDtlVO.setCurrCd(commEasTrfVOs[i].getCurrCd());
//					easDrffChgTrfDtlVO.setCurrListCtnt(commEasTrfVOs[i].getCurrListCtnt());
//					easDrffChgTrfDtlVO.setExpFlg(commEasTrfVOs[i].getExpFlg());
//						
//					if (commEasTrfVOs[i].getIbflag().equals("I")) {								
//						insertDtlVoList.add(easDrffChgTrfDtlVO);
//					}else if(commEasTrfVOs[i].getIbflag().equals("U")) {						
//						updateDtlVoList.add(easDrffChgTrfDtlVO);
//					}else if(commEasTrfVOs[i].getIbflag().equals("D")) {						
//						deleteDtlVoList.add(easDrffChgTrfDtlVO);				
//					}							
//				}	
//				
//				// TY SZ DELETE를 먼저한다.
//				for (int i=0; i<commEasTrfVOs.length; i++) {
//					if (commEasTrfVOs[i].getIbflag().equals("U")) {
//						if(isUpload.equals("N")){
//							dbDao.removeDrffChgTrfTpSz(isUpload, commEasTrfVOs[i]);
//						}
//					}else if(commEasTrfVOs[i].getIbflag().equals("I")) {
//						if(isUpload.equals("N")){
//							dbDao.removeDrffChgTrfTpSz(isUpload, commEasTrfVOs[i]);
//						}					
//					}else if(commEasTrfVOs[i].getIbflag().equals("D")) {
//						if(isUpload.equals("N")){
//							dbDao.removeDrffChgTrfTpSz(isUpload, commEasTrfVOs[i]);
//						}
//					}	
//				}						
//				// DTL 삭제를 한다.
//				if ( insertDtlVoList.size() > 0 ) {
//					if(isUpload.equals("N")){
//						dbDao.removeDrffChgTrfDtl(isUpload, insertDtlVoList);
//					}
//				}				
//								
//				if ( deleteDtlVoList.size() > 0 ) {
//					if(isUpload.equals("N")){
//						dbDao.removeDrffChgTrfDtl(isUpload, deleteDtlVoList);
//					}
//				}									
//				//---------------------------------------------------------------------
//				// delete 후에 저장한다.
//				if ( insertDtlVoList.size() > 0 ) {
//					dbDao.addDrffChgTrfDtl(easDrffChgTrfHdrVO, insertDtlVoList, account);
//				}				
//				
//				if ( updateDtlVoList.size() > 0 ) {
//					dbDao.modifyDrffChgTrfDtl(easDrffChgTrfHdrVO, updateDtlVoList, account);
//				}
//								
//				for (int i=0; i<commEasTrfVOs.length; i++) {
//					if (commEasTrfVOs[i].getIbflag().equals("U")) {
//						dbDao.addDrffChgTrfTpSz(commEasTrfVOs[i], account);
//					}else if(commEasTrfVOs[i].getIbflag().equals("I")) {
//						dbDao.addDrffChgTrfTpSz(commEasTrfVOs[i], account);
//					}
//				}														
//			}
//		} catch(DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
//		}			
	}	
		
	
	/**
	 * multiDrffChgTrfDtl 삭제
	 * 
	 * @param String isUpload
	 * @param EasDrffChgTrfHdrVO easDrffChgTrfHdrVO
	 * @param CommEasDrffChgTrfVO[] commEasTrfVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */		
	public void multiDrffChgTrfDtlDelete(String isUpload, EasDrffChgTrfHdrVO easDrffChgTrfHdrVO, CommEasDrffChgTrfVO[] commEasTrfVOs, SignOnUserAccount account) throws EventException {		
		int MaxSeq  = 0;
		int isFirstIns = 1;
		int isFirstUpd = 1;
		int isFirstDel = 1;
		int isFirstIns2 = 1;
		int isFirstUpd2 = 1;
		int isFirstDel2 = 1;

//		try {
//			MaxSeq = dbDao.searchEasDrffChgTrfDtlSeq(easDrffChgTrfHdrVO);
//
//			EasDrffChgTrfDtlVO easDrffChgTrfDtlVO = null;
//
//			Collection<EasDrffChgTrfDtlVO> insertDtlVoList = new ArrayList<EasDrffChgTrfDtlVO>();
//			Collection<EasDrffChgTrfDtlVO> updateDtlVoList = new ArrayList<EasDrffChgTrfDtlVO>();	
//			Collection<EasDrffChgTrfDtlVO> deleteDtlVoList = new ArrayList<EasDrffChgTrfDtlVO>();
//
//			if(commEasTrfVOs != null){
//				for (int i=0; i<commEasTrfVOs.length; i++) {			
////					if(isUpload.equals("Y")){						// 파일 업로드시에는 Delete를 먼저하고 Insert를 한다. 화면에서 지정
////						commEasTrfVOs[i].setIbflag("I"); 
////					}
//					
//					if(commEasTrfVOs[i].getDrffChgTrfDtlSeq().equals("")){							
//						commEasTrfVOs[i].setIbflag("I"); 							
//					}					
//										
//					if( (commEasTrfVOs[i].getDrffChgTrfVerNo().equals("") || commEasTrfVOs[i].getDrffChgTrfVerNo() == null)){						
//						commEasTrfVOs[i].setIbflag("I"); 							
//					}								
//					
//					if( commEasTrfVOs[i].getDrffChgTrfDtlSeq().equals("") || commEasTrfVOs[i].getDrffChgTrfDtlSeq() == null){						
//						commEasTrfVOs[i].setIbflag("I");										
//					}
//					
//					if (commEasTrfVOs[i].getIbflag().equals("I")) {																		
//						commEasTrfVOs[i].setDrffChgTrfDtlSeq(String.valueOf(MaxSeq++));
//					}
//					
//					easDrffChgTrfDtlVO = new EasDrffChgTrfDtlVO();
//					easDrffChgTrfDtlVO.setDrffChgTrfSeq(easDrffChgTrfHdrVO.getDrffChgTrfSeq());
//					easDrffChgTrfDtlVO.setDrffChgTrfVerNo(easDrffChgTrfHdrVO.getDrffChgTrfVerNo());
//					commEasTrfVOs[i].setDrffChgTrfSeq(easDrffChgTrfHdrVO.getDrffChgTrfSeq());
//					commEasTrfVOs[i].setDrffChgTrfVerNo(easDrffChgTrfHdrVO.getDrffChgTrfVerNo());
//					easDrffChgTrfDtlVO.setDrffChgTrfDtlSeq(commEasTrfVOs[i].getDrffChgTrfDtlSeq());
//					easDrffChgTrfDtlVO.setSccCd(commEasTrfVOs[i].getSccCd());
//					easDrffChgTrfDtlVO.setPortInlndCd(commEasTrfVOs[i].getPortInlndCd());
//					easDrffChgTrfDtlVO.setContiCd(commEasTrfVOs[i].getContiCd());
//					easDrffChgTrfDtlVO.setPodCntCd(commEasTrfVOs[i].getPodCntCd());
//					easDrffChgTrfDtlVO.setPodCntListCtnt(commEasTrfVOs[i].getPodCntListCtnt());
//					easDrffChgTrfDtlVO.setCurrCd(commEasTrfVOs[i].getCurrCd());
//					easDrffChgTrfDtlVO.setCurrListCtnt(commEasTrfVOs[i].getCurrListCtnt());
//					easDrffChgTrfDtlVO.setExpFlg(commEasTrfVOs[i].getExpFlg());
//	
//					if (commEasTrfVOs[i].getIbflag().equals("I")) {
//						if(isFirstIns == 1){
//							insertDtlVoList.add(easDrffChgTrfDtlVO);
//							isFirstIns = 2;
//						}
//					}else if(commEasTrfVOs[i].getIbflag().equals("U")) {
//						if(isFirstUpd == 1){
//							updateDtlVoList.add(easDrffChgTrfDtlVO);
//							isFirstUpd = 2;
//						}
//					}else if(commEasTrfVOs[i].getIbflag().equals("D")) {
//						if(isFirstDel == 1){
//							deleteDtlVoList.add(easDrffChgTrfDtlVO);
//							isFirstDel = 2;
//						}
//					}																									
//				}	
//				
//				for (int i=0; i<commEasTrfVOs.length; i++) {
//					if (commEasTrfVOs[i].getIbflag().equals("U")) {
//						if(isFirstUpd2 == 1){
//							dbDao.removeDrffChgTrfTpSz(isUpload, commEasTrfVOs[i]);
//							isFirstUpd2 = 2;
//						}
//					}else if(commEasTrfVOs[i].getIbflag().equals("I")) {
//						if(isFirstIns2 == 1){
//							dbDao.removeDrffChgTrfTpSz(isUpload, commEasTrfVOs[i]);						
//							isFirstIns2 = 2;
//						}
//					}else if(commEasTrfVOs[i].getIbflag().equals("D")) {
//						if(isFirstDel2 == 1){
//							dbDao.removeDrffChgTrfTpSz(isUpload, commEasTrfVOs[i]);
//							isFirstDel2 = 2;
//						}
//					}	
//				}				
//				
//				if ( insertDtlVoList.size() > 0 ) {
//					dbDao.removeDrffChgTrfDtl(isUpload, insertDtlVoList);						
//				}
//								
//				if ( deleteDtlVoList.size() > 0 ) {
//					dbDao.removeDrffChgTrfDtl(isUpload, deleteDtlVoList);				
//				}	
//			}
//		} catch(DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
//		}			
	}	
	
	
	/**
	 * searchEUROffcd 유럽 Office 조회 기능<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse searchEUROffcd(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		
    	try {
    		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
    		rowSet=dbDao.searchEUROffcd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;	
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * searchDofChgDupCnt 중복 갯수 조회 기능<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse searchDofChgDupCnt(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
    	try {
    		
    		rowSet=dbDao.searchDofChgDupCnt(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;	
	
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * verifyLocCd 입력된 loc_cd의 MDM내 존재여부 확인<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyLocCd(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
    	try {
    		
    		rowSet=dbDao.verifyLocCd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;	
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * verifyCustCd 입력된 cust_cd의 MDM내 존재여부 확인<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyCustCd(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
    	try {
    		
    		rowSet=dbDao.verifyCustCd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;	
			
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * verifyTpSz 입력된 tpsz_cd의 MDM내 존재여부 확인<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyTpSz(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
    	try {
    		
    		rowSet=dbDao.verifyTpSz(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;	
			
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * verifyCurr 입력된 curr_cd의 MDM내 존재여부 확인<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyCurr(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
    	try {
    		
    		rowSet=dbDao.verifyCurr(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * searchDofChgTrfNewList 기본 조회 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDofChgTrfNewList(Event e) throws EventException {

		EsdEas0011Event event=(EsdEas0011Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		try {
//			rowSet = dbDao.searchDofChgTrfNewList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
			
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}	
	
	

	/**
	 * searchDODCollectionInquiry 기본 조회 기능<br>
	 * @param e EsdEas0012Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDODCollectionInquiry(Event e) throws EventException {
		
		EsdEas0012Event event=(EsdEas0012Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		try {
//			rowSet = dbDao.searchDODCollectionInquiry(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
			
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}
	
	
	/**
	 * searchDODCollectionInquiry 기본 조회 기능<br>
	 * @param e EsdEas0013Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDODCollectionPerformance(Event e) throws EventException {
		
		EsdEas0013Event event=(EsdEas0013Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		try {
//			rowSet = dbDao.searchDODCollectionPerformance(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
			
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}
	
}
