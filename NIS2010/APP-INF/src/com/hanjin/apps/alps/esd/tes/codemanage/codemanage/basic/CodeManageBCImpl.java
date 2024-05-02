/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeManageBCImpl.java
*@FileTitle : Cost Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-07
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-07 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.codemanage.codemanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tes.codemanage.codemanage.event.EsdTes0027Event;
import com.hanjin.apps.alps.esd.tes.codemanage.codemanage.event.EsdTes0028Event;
import com.hanjin.apps.alps.esd.tes.codemanage.codemanage.event.EsdTes9090Event;
import com.hanjin.apps.alps.esd.tes.codemanage.codemanage.integration.CodeManageDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ENIS-ESD Business Logic Basic Command implementation<br>
 * - ENIS-ESD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jongbaemoon
 * @see ESD_TES_027EventResponse,CodeManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CodeManageBCImpl   extends BasicCommandSupport implements CodeManageBC {

	// Database Access Object
	private transient CodeManageDBDAO dbDao=null;

	/**
	 * CodeManageBCImpl 객체 생성<br>
	 * CodeManageDBDAO를 생성한다.<br>
	 */
	public CodeManageBCImpl(){
		dbDao = new CodeManageDBDAO();
	}

    /**
     * Acct Code List 조회 이벤트 처리<br>
     * ESD_TES_0027화면에 대한 세부 조회 이벤트 처리<br>
     * 
     * @return  EventResponse 
     * @exception EventException
     */	
	public EventResponse searchAcctCodeList() throws EventException {		
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRs(dbDao.searchAcctCodeList());
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	

    /**
     * Cost Code Option 조회 이벤트 처리<br>
     * ESD_TES_0028화면에 대한 세부 조회 이벤트 처리<br>
     * 
     * @param e ESD_TES_0028Event
     * @return EventResponse 
     * @exception EventException
     */
    public EventResponse searchCostcdOption(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsdTes0028Event event=(EsdTes0028Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        // 데이터 전송을 위해 DBRowSet을 담을 List
        List<DBRowSet> rsVoList = new ArrayList<DBRowSet>();
        
        try {
        	rsVoList.add( dbDao.searchCodescListSubj() );
        	
        	String lgsCostSubjCd = event.getTesLgsCostVO().getLgsCostSubjCd();
        	
        	log.debug("\n==========CodeManageBCImpl()    searchCostcdOption() - lgsCostSubjCd : "+lgsCostSubjCd+" ============");
        	
        	if(lgsCostSubjCd!=null && !"".equals(lgsCostSubjCd)){
        		rsVoList.add( dbDao.searchCodescListDtl(lgsCostSubjCd) );
            }
        	
        	eventResponse.setRsList(rsVoList);
        	eventResponse.setETCData("cost_code_sc", event.getTesLgsCostVO().getLgsCostSubjCd());
        	eventResponse.setETCData("cost_code_dc", event.getTesLgsCostVO().getLgsCostDtlCd());
        	
        	return eventResponse;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } 
    }	
	
    /**
     * Cost Code Option 조회 이벤트 처리<br>
     * ESD_TES_0028화면에 대한 세부 조회 이벤트 처리<br>
     * 
     * @param e ESD_TES_0028Event
     * @return EventResponse 
     * @exception EventException
     */
    public EventResponse searchCostcdDetail(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	EsdTes0028Event event=(EsdTes0028Event)e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	
    	// 데이터 전송을 위해 DBRowSet을 담을 List
    	List<DBRowSet> rsVoList = new ArrayList<DBRowSet>();
    	
    	try {
    		rsVoList.add( dbDao.searchCodescListSubj() );
    		
    		String lgsCostSubjCd = event.getTesLgsCostVO().getLgsCostSubjCd();
    		
    		log.debug("\n==========CodeManageBCImpl()    searchCostcdDetail() - lgsCostSubjCd : " + lgsCostSubjCd + " ============");
    		
    		if ( lgsCostSubjCd != null && !"".equals(lgsCostSubjCd) ) {
    			rsVoList.add( dbDao.searchCostcdDetail(lgsCostSubjCd) );
    		}
    		
    		eventResponse.setRsList(rsVoList);
    		eventResponse.setETCData("cost_code_sc", event.getTesLgsCostVO().getLgsCostSubjCd());
    		eventResponse.setETCData("cost_code_dc", event.getTesLgsCostVO().getLgsCostDtlCd());
    		eventResponse.setETCData("cost_code", event.getTesLgsCostVO().getLgsCostCd());
    		
    		return eventResponse;
    		
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
    		throw new EventException(de.getMessage());
    	} 
    }	
    
	/**
	 * 조회 이벤트 처리<br>
	 * Cost Code info 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0028Event event=(EsdTes0028Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		if(log.isDebugEnabled())log.debug("\n==========CodeManageBCImpl()    searchCostCode() ============");
		try {
			eventResponse.setRs( dbDao.searchCostCode(event.getTesLgsCostVO()) );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_0027Event
	 * @return EventResponse ESD_TES_0027EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostCodeInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0027Event event=(EsdTes0027Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		if(log.isDebugEnabled())log.debug("\n==========CodeManageBCImpl()    searchCostCodeInfo() ============");
		//데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		try {
			rowSet = dbDao.searchCostCodeInfo(event.getTesLgsCostVO());
			eventResponse.setRs(rowSet);			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}	
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTes9090Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse checkMandatory(Event e) throws EventException {
		DBRowSet			dbRowSet	= null;
		DBRowSet			costcdSet	= null;

		// PDTO(Data Transfer Object including Parameters)
		EsdTes9090Event			event	= (EsdTes9090Event)e;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			dbDao.checkCostCodeOPTNO( event.getTesCodeManageCommonVO().getLgsCostOptNo() );
			
			int existUser = 0;
			int existCostCd = 0;
			
			dbRowSet  = dbDao.checkMandatory( event.getComUserVO() );
			if(dbRowSet!=null && dbRowSet.getRowCount()>0) existUser = dbRowSet.getRowCount();
			
			costcdSet = dbDao.checkCostCode( event.getTesCodeManageCommonVO().getLgsCostCd() );
			if(costcdSet!=null && dbRowSet.getRowCount()>0) existCostCd=costcdSet.getRowCount();

			eventResponse.setETCData( "existUser", String.valueOf(existUser) );
			eventResponse.setETCData( "existCostCd", String.valueOf(existCostCd) );
			
			log.debug( "existUser : "+eventResponse.getETCData("existUser") );
			log.debug( "existCostCd : " + eventResponse.getETCData("existCostCd") );
	
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTes9090Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse checkAgreementPassWord(Event e) throws EventException {
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet			agmtRowSet	= null;
		DBRowSet			costRowSet	= null;
		
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9090Event			event			= (EsdTes9090Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		int		existUser		= 0;
		int		existCostCd		= 0;

		try {
			
			//dbDao.checkCostCodeOPTNO( event.getTesCodeManageCommonVO().getLgsCostOptNo() );

			// Agreement Password Check.
			agmtRowSet	= dbDao.checkAgreementPassWord( event.getComUserVO() );
			if ( agmtRowSet != null && agmtRowSet.getRowCount() > 0 ) {
				existUser = agmtRowSet.getRowCount();
			}
			
			// Cost Code Check
			costRowSet	= dbDao.checkCostCode( event.getTesCodeManageCommonVO().getLgsCostCd() );
			if ( costRowSet != null && costRowSet.getRowCount() > 0 ) {
				existCostCd = agmtRowSet.getRowCount();
			}

			eventResponse.setETCData( "existUser", String.valueOf(existUser) );
			eventResponse.setETCData( "existCostCd", String.valueOf(existCostCd) );
			
			return eventResponse;

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * Cost Code 추가 이벤트 처리<br>
	 * ESD_TES_0027 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e EsdTes0027Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse createCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0027Event event=(EsdTes0027Event)e;	

		try {

			event.getTesLgsCostVO().setCreUsrId(event.getSignOnUserAccount().getUsr_id());
			event.getTesLgsCostVO().setCreDt(event.getSignOnUserAccount().getOfc_cd());
			
			dbDao.createCostCode(event.getTesLgsCostVO());
				
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Cost Code 수정 이벤트 처리<br>
	 * ESD_TES_0027 에 대한 수정 이벤트 처리<br>
	 * 
	 * @param e EsdTes0027Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse modifyCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0027Event event=(EsdTes0027Event)e;		

		try {
			
			event.getTesLgsCostVO().setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
			event.getTesLgsCostVO().setUpdDt(event.getSignOnUserAccount().getOfc_cd());
			
			dbDao.modifyCostCode(event.getTesLgsCostVO());
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Cost Code 삭제 처리 이벤트 처리<br>
	 * ESD_TES_0027 에 대한 삭제 이벤트 처리<br>
	 * 
	 * @param e EsdTes0027Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse modifyCostCodeDelete(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0027Event event=(EsdTes0027Event)e;		

		try {
			dbDao.modifyCostCodeDelete(event.getTesLgsCostVO());
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	

    /**
     * 조회 이벤트 처리<br>
     * CodeManage화면에 대한 조회 이벤트 처리<br>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
    public EventResponse searchCarrierCode(Event e) throws EventException {
//    	EsdTes0031Event event=(EsdTes0031Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		if(log.isDebugEnabled())log.debug("\n==========CodeManageBCImpl()    searchCostCode() ============");
		try {
			eventResponse.setRs( dbDao.searchCarrierCode() );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
    }
    
//    /**
//     * 멀티 이벤트 처리<br>
//     * ESD_TES_031 화면에 대한 멀티 이벤트 처리<br>
//     * 
//     * @param e ESD_TES_031Event
//     * @return EventResponse ESD_TES_031EventResponse
//     * @exception EventException
//     */
//    public EventResponse multiCarrierCode(Event e) throws EventException{
        // PDTO(Data Transfer Object including Parameters)
//        EsdTes0031Event event=(EsdTes0031Event)e;
//
//        try {
//        	dbDao.setSignOnUserAccount(e.getSignOnUserAccount());
//        	dbDao.multiCarrierCode(event.getTES_TML_SO_CRRS(),  event.getSignOnUserAccount().getOfc_cd());
//            return null;
//        } catch (DAOException de) {
//            log.error("err "+de.toString(),de);
//            throw new EventException(de.getMessage());
//        }
//    	return null;
//    }
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * CodeManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
