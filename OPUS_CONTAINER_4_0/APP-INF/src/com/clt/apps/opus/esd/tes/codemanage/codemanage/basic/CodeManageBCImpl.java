/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeManageBCImpl.java
*@FileTitle : Cost Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tes.codemanage.codemanage.event.EsdTes0027Event;
import com.clt.apps.opus.esd.tes.codemanage.codemanage.event.EsdTes0028Event;
import com.clt.apps.opus.esd.tes.codemanage.codemanage.event.EsdTes0038Event;
import com.clt.apps.opus.esd.tes.codemanage.codemanage.event.EsdTes0036Event;
import com.clt.apps.opus.esd.tes.codemanage.codemanage.event.EsdTes0037Event;
import com.clt.apps.opus.esd.tes.codemanage.codemanage.integration.CodeManageDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD Business Logic Basic Command implementation<br>
 * ESD business logic handling.<br>
 * 
 * @author jongbaemoon
 * @see ESD_TES_027EventResponse,CodeManageBC each DAO class reference
 * @since J2EE 1.4
 */
public class CodeManageBCImpl   extends BasicCommandSupport implements CodeManageBC {

	// Database Access Object
	private transient CodeManageDBDAO dbDao=null;

	/**
	 * CodeManageBCImpl object creation<br>
	 * CodeManageDBDAO creation<br>
	 */
	public CodeManageBCImpl(){
		dbDao = new CodeManageDBDAO();
	}

    /**
     * Acct Code List retrieve event process
     * ESD_TES_0027 detail retrieve event process
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
     * Cost Code Option retrieve event process
     * ESD_TES_0028 detail retrieve event process
     * 
     * @param Event e 
     * @return EventResponse 
     * @exception EventException
     */
    public EventResponse searchCostcdOption(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsdTes0028Event event=(EsdTes0028Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        // DBRowSet List
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
	 * retrieve event process
	 * Cost Code info retrieve event process
	 * 
	 * @param Event e 
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
	 * retrieve event process
	 * CodeManage retrieve event process
	 * 
	 * @param Event e 
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchCostCodeInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0027Event event=(EsdTes0027Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		if(log.isDebugEnabled())log.debug("\n==========CodeManageBCImpl()    searchCostCodeInfo() ============");
		//DB ResultSet object For data transfer
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
	 *  retrieve event process
	 * CodeManage  retrieve event process
	 * 
	 * @param e 
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
//	public EventResponse checkMandatory(Event e) throws EventException {
//		DBRowSet			dbRowSet	= null;
//		DBRowSet			costcdSet	= null;
//
//		// PDTO(Data Transfer Object including Parameters)
//		EsdTes9090Event			event	= (EsdTes9090Event)e;
//		
//		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
//		
//		try {
//			dbDao.checkCostCodeOPTNO( event.getTesCodeManageCommonVO().getLgsCostOptNo() );
//			
//			int existUser = 0;
//			int existCostCd = 0;
//			
//			dbRowSet  = dbDao.checkMandatory( event.getComUserVO() );
//			if(dbRowSet!=null && dbRowSet.getRowCount()>0) existUser = dbRowSet.getRowCount();
//			
//			costcdSet = dbDao.checkCostCode( event.getTesCodeManageCommonVO().getLgsCostCd() );
//			if(costcdSet!=null && dbRowSet.getRowCount()>0) existCostCd=costcdSet.getRowCount();
//
//			eventResponse.setETCData( "existUser", String.valueOf(existUser) );
//			eventResponse.setETCData( "existCostCd", String.valueOf(existCostCd) );
//			
//			log.debug( "existUser : "+eventResponse.getETCData("existUser") );
//			log.debug( "existCostCd : " + eventResponse.getETCData("existCostCd") );
//	
//			return eventResponse;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
	
//	/**
//	 *  retrieve event process
//	 * CodeManage  retrieve event process
//	 * 
//	 * @param e EsdTes9090Event
//	 * @return EventResponse GeneralEventResponse
//	 * @exception EventException
//	 */
//	public EventResponse checkAgreementPassWord(Event e) throws EventException {
//		
//		// DB ResultSet object For data transfer
//		DBRowSet			agmtRowSet	= null;
//		DBRowSet			costRowSet	= null;
//		
//		// PDTO(Data Transfer Object including Parameters)
//		EsdTes9090Event			event			= (EsdTes9090Event)e;
//		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
//
//		int		existUser		= 0;
//		int		existCostCd		= 0;
//
//		try {
//			dbDao.checkCostCodeOPTNO( event.getTesCodeManageCommonVO().getLgsCostOptNo() );
//			
//			// Agreement Password Check.
//			agmtRowSet	= dbDao.checkAgreementPassWord( event.getComUserVO() );
//			if ( agmtRowSet != null && agmtRowSet.getRowCount() > 0 ) {
//				existUser = agmtRowSet.getRowCount();
//			}
//			
//			// Cost Code Check
//			costRowSet	= dbDao.checkCostCode( event.getTesCodeManageCommonVO().getLgsCostCd() );
//			if ( costRowSet != null && costRowSet.getRowCount() > 0 ) {
//				existCostCd = agmtRowSet.getRowCount();
//			}
//
//			eventResponse.setETCData( "existUser", String.valueOf(existUser) );
//			eventResponse.setETCData( "existCostCd", String.valueOf(existCostCd) );
//			
//			return eventResponse;
//
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}	
	
	/**
	 * Cost Code Add Event Process<br>
	 * ESD_TES_0027 Add Event Process<br>
	 * 
	 * @param Event e 
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse createCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0027Event event=(EsdTes0027Event)e;	
//		DBRowSet			costcdSet	= null;
		
//		int existCostCd = 0;
		try {
//			costcdSet = dbDao.checkCostCode(event.getTesLgsCostVO().getLgsCostCd());
//			existCostCd = costcdSet!=null?costcdSet.getRowCount():0;
			
//			if(costcdSet==null || existCostCd==0 ){
				event.getTesLgsCostVO().setCreUsrId(event.getSignOnUserAccount().getUsr_id());
				event.getTesLgsCostVO().setCreDt(event.getSignOnUserAccount().getOfc_cd());
				event.getTesLgsCostVO().setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
				event.getTesLgsCostVO().setUpdDt(event.getSignOnUserAccount().getOfc_cd());
				
				dbDao.createCostCode(event.getTesLgsCostVO());
//			} else {
//				throw new DAOException(new ErrorHandler("Not Acceptable Cost Code. Try Again.", new String[]{}).getMessage());
//			}
				return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Cost Code Update Event Process<br>
	 * ESD_TES_0027 Update Event Process<br>
	 * 
	 * @param Event e 
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
	 * Cost Code Delete Event Process<br>
	 * ESD_TES_0027 Delete Event Process<br>
	 * 
	 * @param Event e 
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
     * retrieve event process
     * CodeManage retrieve event process
     * @param Event e 
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
    
    /**
     * Terminal SO Cost Code retrieve event process<br>
     * CodeManage retrieve event process<br>
     * @param Event e 
     * @return response GeneralEventResponse
     * @exception EventException
     */
    public EventResponse searchTmnlSoCostCode(Event e) throws EventException {
    	EsdTes0038Event event=(EsdTes0038Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		if(log.isDebugEnabled())log.debug("\n==========CodeManageBCImpl()    searchTmnlSoCostCode() ============");
		try {
			eventResponse.setRs( dbDao.searchTmnlSoCostCode(event.getTesTmlSoCostVO()) );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
    }
    
    /**
     * Terminal Agreement Cost Code retrieve event process<br>
     * CodeManage retrieve event process<br>
     * @param Event e 
     * @return response GeneralEventResponse
     * @exception EventException
     */
    public EventResponse searchTmnlAgmtCostCode(Event e) throws EventException {
    	EsdTes0036Event event=(EsdTes0036Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		if(log.isDebugEnabled())log.debug("\n==========CodeManageBCImpl()    searchTmnlAgmtCostCode() ============");
		try {
			eventResponse.setRs( dbDao.searchTmnlAgmtCostCode(event.getTesTmlAgmtCostVO()) );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
    }    
    
    /**
     * Terminal Agreement Verify Method retrieve event process<br>
     * CodeManage retrieve event process<br>
     * @param Event e 
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse searchTmnlAgmtVrfyMzdCode(Event e) throws EventException {
    	EsdTes0037Event event=(EsdTes0037Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		if(log.isDebugEnabled())log.debug("\n==========CodeManageBCImpl()    searchTmnlAgmtVrfyMzdCode() ============");
		try {
			eventResponse.setRs( dbDao.searchTmnlAgmtVrfyMzdCode(event.getTesTmlAgmtVrfyMzdVO()) );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
    }
//    /**
//     * Multi Event Process<br>
//     * ESD_TES_031 Multi Event Process<br>
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
	 * ESD Handling for the end of working scenario<br>
	 * CodeManage Clearing object by the end of work scenario<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}