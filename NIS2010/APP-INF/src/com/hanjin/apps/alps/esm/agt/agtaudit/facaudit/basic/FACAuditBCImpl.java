/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FACAuditBCImpl.java
*@FileTitle : FAC Commission Maintenance Management
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-17
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-17 Hwang GyeongNam
* 1.0 최초 생성
* 2009-10-09 : Ho-Jin Lee Alps 전환
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.integration.FACAuditDBDAO;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.integration.FACAuditEAIDAO;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.AGTFACRateInfoVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.FACCommDetailBasicbyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.FACCommDetailChargebyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.FACCommDetailHistorybyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.FACCommVO;
import com.hanjin.apps.alps.esm.agt.agtcalculation.AGTCalculationSC;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * eNIS-AGT Business Logic Basic Command implementation<br>
 * - eNIS-AGT에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Hwang GyeongNam
 * @see AGTAuditDAO 참조
 * @since J2EE 1.4
 */
public class FACAuditBCImpl extends BasicCommandSupport implements FACAuditBC {
	
	// Database Access Object, EAI Interface Object
	private transient FACAuditDBDAO dbDao = null;
	private transient FACAuditEAIDAO eaiDao = null;
	

	/**
	 * FACAuditBCImpl 객체 생성<br>
	 * FACAuditDBDAO, FACAuditEAIDAO를 생성한다.<br>
	 */
	public FACAuditBCImpl(){
		dbDao = new FACAuditDBDAO();
		eaiDao = new FACAuditEAIDAO();
	}
	/**
	 * (ESM_AGT_015) 화면-FAC Commission의 Basic 정보 조회
	 * @param FACCommDetailBasicbyBLVO facCommDetailBasicbyBLVO
	 * @return List<FACCommDetailBasicbyBLVO>
	 * @exception EventException
	 */
	@Override
    public List<FACCommDetailBasicbyBLVO> searchFACCommDetailBasicbyBL(FACCommDetailBasicbyBLVO facCommDetailBasicbyBLVO) throws EventException {
		try{
	    	return dbDao.searchFACCommDetailBasicbyBL(facCommDetailBasicbyBLVO);
	    }catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		}
    }
	/**
	 * (ESM_AGT_015) Charge Detail 목록 조회
	 * @param FACCommDetailChargebyBLVO facCommDetailChargebyBLVO
	 * @return List<FACCommDetailChargebyBLVO>
	 * @exception EventException
	 */
	@Override
    public List<FACCommDetailChargebyBLVO> searchFACCommDetailChargebyBL(FACCommDetailChargebyBLVO facCommDetailChargebyBLVO) throws EventException {
		try{
	    	return dbDao.searchFACCommDetailChargebyBL(facCommDetailChargebyBLVO);
	    }catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		}
    }
	/**
	 * (ESM_AGT_015) FAC Commission의 History Detail 목록 조회
	 * @param FACCommDetailHistorybyBLVO facCommDetailHistorybyBLVO
	 * @return List<FACCommDetailHistorybyBLVO>
	 * @exception EventException
	 */
	@Override
    public List<FACCommDetailHistorybyBLVO> searchFACCommDetailHistorybyBL(FACCommDetailHistorybyBLVO facCommDetailHistorybyBLVO) throws EventException {
		try{
	    	return dbDao.searchFACCommDetailHistorybyBL(facCommDetailHistorybyBLVO);
	    }catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		}
    }
	/**
	 * (ESM_AGT_015) 실제로 Commission 계산한 FAC Agreement 요율 정보 조회
	 * @param AGTFACRateInfoVO agtFacRateInfoVO
	 * @return List<AGTFACRateInfoVO>
	 * @exception EventException
	 */
	@Override
	public List<AGTFACRateInfoVO> searchAGTFACRateInfo(AGTFACRateInfoVO agtFacRateInfoVO) throws EventException {
	    try{
	    	return dbDao.searchAGTFACRateInfo(agtFacRateInfoVO);
	    }catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		}
    }
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_033 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param FACCommVO facCommVO
	 * @return List<FACCommVO>
	 * @exception EventException
	 */
	public List<FACCommVO> searchFACCommList(FACCommVO facCommVO) throws EventException {
		try
		{
			if (5 < facCommVO.getBlNos().length())
			{
				facCommVO.setBlNos("'"+facCommVO.getBlNos().replaceAll(" ", "").replaceAll(",", "','")+"'");
			}

			return dbDao.searchFACCommList(facCommVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	
	/**
	 * ESM_AGT_33 화면에서 Agreement Commission recalculate버튼 클릭시 처리 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse reCalcFACComm(Event e) throws EventException {

		// Commission 계산을 위한 객체 
		AGTCalculationSC agtCalSC = null;

		try {

			agtCalSC = new AGTCalculationSC();
			agtCalSC.reCalcFACComm(e);

			//agtCalSC.createFACComm("GOA71150060","  ");
			
			return null;

		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}


	

	
	/**
	 * ESM_AGT_33 화면에서 Agreement Commission recalculate버튼 클릭시 처리 한다.<br>
	 * 
	 * @param String bkg_no
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalcFACComm(String bkg_no, SignOnUserAccount account) throws EventException
	{

		// Commission 계산을 위한 객체 
		AGTCalculationSC agtCalSC = null;

		try {

			agtCalSC = new AGTCalculationSC();
			agtCalSC.recalcFACComm(bkg_no, account);
			return null;

		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}

	
/*	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_034 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 *
	public EventResponse searchAPActualInterfaceMasterForFAC(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmAgt0034Event event=(EsmAgt0034Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet = null;		
		
		try {
			rowSet = dbDao.searchAPActualInterfaceMasterForFAC(event);
						
			return new ESM_AGT_034EventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_034 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 *
	public EventResponse searchAPActualInterfaceDetailForFAC(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmAgt0034Event event=(EsmAgt0034Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet = null;		
		
		try {
			rowSet = dbDao.searchAPActualInterfaceDetailForFAC(event);
						
			return new ESM_AGT_034EventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
*/	
	/**
     * ESM_AGT_034 화면에 대한 AP Interface 이벤트 처리<br>
     * 
     * @param  e ESM_AGT_034Event
     * @return EventResponse ESM_AGT_034EventResponse
     * @throws EventException
     */
	/*
    public EventResponse createFACActualINFtoAP(Event e) throws EventException{
    	//PDTO(Data Transfer Object including Parameters)
		EsmAgt0034Event event=(EsmAgt0034Event)e;
		
		//데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet = null;		
		
		HashMap dataHash = null;
		HashMap eaiHash = null;
		boolean isSuccess = true; //Test:false, real:true
		
		try {
			//1.AP_INV_HDR에 INSERT하기
			dataHash = dbDao.createFACCSRHeader(event);
			
			//2.AP_INV_DSTR에 INSERT하기
			dbDao.createFACCSRDistribution(event, dataHash);
			
			//3.EP 결제하기
			//dbDao.createFACEPApproval(event);
			
			//4.AP_INV_IF에 INSERT하기
			dbDao.createFACAPTempTable(event, dataHash);
			
			//5.AP 인터페이스 실행하기
			rowSet = dbDao.searchFACActualINFtoAP(dataHash);
			if(isSuccess){
				eaiHash = eaiDao.transferAtOnceAGT034ToEAIByWS(rowSet);
				dbDao.createFACAcutalINFFromAPbyMSG(dataHash, eaiHash);
			}else{
				//(테스트용. 삭제 예정!!!)
				eaiHash = new HashMap();
				eaiHash.put("isSuccess", "Y");
			}
			//6.AP 인터페이스 실행결과를 AGT_AGN_COMM에 UPDATE하기
			isSuccess = ((String)eaiHash.get("isSuccess") == "Y"?true:false);
			dbDao.modifyFACInfo(event, isSuccess, dataHash);

			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
    }
    */
    /**
	 * 인쇄 이벤트 처리<br>
	 * ESM_AGT_034 화면에 대한 인쇄 이벤트 처리<br>
	 * 
	 * @param e ESM_AGT_034Event
	 * @return EventResponse ESM_AGT_034EventResponse
	 * @exception EventException
	 *
	public EventResponse searchFACInfoForPrint(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmAgt0034Event event=(EsmAgt0034Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet1 = null;	//AP_INV_HDR
		DBRowSet rowSet2 = null;	//AP_INV_DTRB
		
		HashMap rtnHash = null;
		
		try {
			rtnHash = dbDao.searchFACInfoForPrint(event);
			rowSet1 = (DBRowSet)rtnHash.get("HDR");
			rowSet2 = (DBRowSet)rtnHash.get("DTL");
			
			return new ESM_AGT_034EventResponse(rowSet1, rowSet2, "SUCCESS");
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
*/
    /**
     * ESM_AGT_034 화면에 대한 AP Cancel Interface 이벤트 처리<br>
     * 
     * @param  e ESM_AGT_034Event
     * @return EventResponse ESM_AGT_034EventResponse
     * @throws EventException
     */
	/*
    public EventResponse createCancelFACActualINFtoAP(Event e) throws EventException{
    	//PDTO(Data Transfer Object including Parameters)
		EsmAgt0034Event event=(EsmAgt0034Event)e;
		
		try {
			dbDao.modifyCancelFACInfo(event);
			
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
    }
	*/
    /**
     * ESM_AGT_033 화면에서 Recalculation 시 AR Interface 처리<br>
     * 
     * @param  array String[][]
     * @throws EventException
     */
    public void reCalcEAINISFACCommInfo(String[][] array) throws EventException{

		try {

			if(array != null && array.length > 0) {
				eaiDao.modifyEAINISFACCommInfo(array);
			}

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
    }

	   
}