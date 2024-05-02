/**
 *Copyright(c) 2006 CyberLogitec
 *@FileName : TESCommonBCImpl.java
 *@FileTitle : TES Common
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0 
 */
package com.clt.apps.opus.esd.tes.common.tescommon.basic;

import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.tes.common.tescommon.event.TESCommonEvent;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.TesJbExePerfLogVO;

/**
 * ESD Business Logic Basic Command implementation<br>
 * Coding business logic for ESD<br>
 *
 * @author byungheeyoo
 * @see TESCommonHTMLAction, TESCommonBC
 * @since J2EE 1.4
 */
public class TESCommonBCImpl   extends BasicCommandSupport implements TESCommonBC {

	// Database Access Object
	private transient TESCommonDBDAO dbDao=null;

	/**
	 * TESCommonBCImpl object creation.<br>
	 * Creating TESCommonDBDAO<br>
	 */
	public TESCommonBCImpl(){
		dbDao = new TESCommonDBDAO();
	}

	/**
	 * Retrieving MDM's cnt_cd by ofc_cd. 
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getMDMCnt_cd(String ofc_cd) throws EventException {
		
		try {
			return dbDao.getMDMCnt_cd(ofc_cd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	/**
	 * Retrieving Cost OFC.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostOFC(Event e) throws EventException {

		log.debug("\n\n BC.searchCostOFC \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		log.debug("\n\n Id : "+event.getTesCommonVO().getCoid()+"<<<");
		try {
			eventResponse.setRs (dbDao.searchCostOFC(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/** searchEQNo
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEQNo(Event e) throws EventException {

		log.debug("\n\n BC.searchEQNo \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		log.debug("\n\n Id : "+event.getTesCommonVO().getCoid()+"<<<");
		try {
			eventResponse.setRs (dbDao.searchEQNo(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Retrieving currency.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCurrencyList(Event e) throws EventException {

		log.debug("\n\n BC.searchCurrencyList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
		log.debug("\n\n Id : "+event.getTesCommonVO().getCoid()+"<<<");

		log.debug("ofc_cd:"+event.getSignOnUserAccount().getOfc_cd());

		try {
			eventResponse.setRs (dbDao.searchCurrencyList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Validating Cost OFC.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateCostOFC(Event e) throws EventException {

		log.debug("\n\n BC.validateCostOFC \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.validateCostOFC(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Cost OFC confirm the presence
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateCostOFC2(Event e) throws EventException {

		log.debug("\n\n BC.validateCostOFC2 \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.validateCostOFC2(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * INV OFC confirm the presence
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateInvOFC(Event e) throws EventException {

		log.debug("\n\n BC.validateInvOFC \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			if( !"".equals( event.getTesTmlSoHdrVO().getInvOfcCd() ) ) {
				event.getTesTmlSoHdrVO().setCostOfcCd( event.getTesTmlSoHdrVO().getInvOfcCd() );
			}
			
			eventResponse.setRs (dbDao.validateCostOFC2(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}


	/**
	 * Retrieving Node Code by Location Code.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getNodeCode(Event e) throws EventException {

		log.debug("\n\n BC.validateInvOFC \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs ( dbDao.getNodeCode(event) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Validating Yard code.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateYardCode(Event e) throws EventException {

		log.debug("\n\n BC.validateYardCode \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.validateYardCode(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Yard code confirm the presence
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateYardCode2(Event e) throws EventException {

		log.debug("\n\n BC.validateYardCode2 \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.validateYardCode2(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Retrieving DB time.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getDBdate(Event e) throws EventException {

		log.debug("\n\n BC.getDBdate \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchDBdate(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Validating vndr code.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateVndrCode(Event e) throws EventException {

		log.debug("\n\n BC.validateVndrCode \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs ( dbDao.validateVndrCode(event) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * vndr code confirm the presence
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateVndrCode2(Event e) throws EventException {

		log.debug("\n\n BC.validateVndrCode2 \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs ( dbDao.validateVndrCode2(event) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Retrieving cost code in yard code.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYdCostCodeList(Event e) throws EventException {

		log.debug("\n\n BC.searchYdCostCodeList \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();


		try {
			eventResponse.setRs ( dbDao.searchYdCostCodeList(event) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Validating Yard code and Retrieving cost code
	 * @param Event e
	 * @return
	 * @exception EventException
	 */
	public EventResponse validateYardCodeNsearchYdCostCodeList(Event e) throws EventException {

		log.debug("\n\n BC.validateYardCodeNsearchYdCostCodeList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs ( dbDao.validateYardCodeNsearchYdCostCodeList(event) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Retrieving TES' cost code
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTESCostCodeList(Event e) throws EventException {

		log.debug("\n\n BC.searchTESCostCodeList \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchTESCostCodeList());
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 *  searchAgmtCostCodeList
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtCostCodeList(Event e) throws EventException {

		log.debug("\n\n BC.searchAgmtCostCodeList \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchAgmtCostCodeList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	

	/**
	 * Retrieving CntrTPCD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrTPCDList(Event e) throws EventException {

		log.debug("\n\n BC.searchCntrTPCDList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchCntrTPCDList());
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Retrieving CntrSZCD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrSZCDList(Event e) throws EventException {

		log.debug("\n\n BC.searchCntrSZCDList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchCntrSZCDList());
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Retrieving CntrTPSZCD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrTPSZCDList(Event e) throws EventException {

		log.debug("\n\n BC.searchCntrTPSZCDList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs ( dbDao.searchCntrTPSZCDList() );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Retrieving Lane CD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLaneList(Event e) throws EventException {

		log.debug("\n\n BC.searchLaneList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		log.debug("\n\n Id : "+event.getTesCommonVO().getCoid()+"<<<");
		try {
			eventResponse.setRs (dbDao.searchLaneList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Retrieving auto Cost code.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAutoTESTmlSoCostCDList(Event e) throws EventException {

		log.debug("\n\n BC.searchAutoTESTmlSoCostCDList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchAutoTESTmlSoCostCDList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Retrieving manual Cost code
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualTESTmlSoCostCDList(Event e) throws EventException {

		log.debug("\n\n BC.searchManualTESTmlSoCostCDList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchManualTESTmlSoCostCDList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Retrieving TES invoice common code.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTESInvoiceCommonCodeList(Event e) throws EventException {

		log.debug("\n\n BC.searchTESInvoiceCommonCodeList \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchTESInvoiceCommonCodeList());
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Retrieving agreement cost code.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgreementCostCodeList(Event e) throws EventException {

		log.debug("\n\n BC.searchAgreementCostCodeList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchAgreementCostCodeList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Retrieving Lane CD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLaneCodeList(Event e) throws EventException {

		log.debug("\n\n BC.searchLaneCodeList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchLaneCodeList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Retrieving Lane CD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubTrdCodeList(Event e) throws EventException {

		log.debug("\n\n BC.searchSubTrdCodeList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchSubTrdCodeList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/** searchBkgCntrTPCDList
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchBkgCntrTPCDList(Event e) throws EventException {

		log.debug("\n\n BC.searchBkgCntrTPCDList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchBkgCntrTPCDList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * Retrieving Lane CD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMDMAccount(Event e) throws EventException {

		log.debug("\n\n BC.searchMDMAccount \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchMDMAccount(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Retrieving Lane CD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAuthOfcCd(Event e) throws EventException {
		log.debug("\n\n BC.searchAuthOfcCd \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchAuthOfcCd(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Measuring the performance of the registered functions.
	 *  
	 * @param TesJbExePerfLogVO tesJbExePerfLogVO
	 * @return String
	 * @exception EventException
	 */
	public String beginJobExecutionPerformance(TesJbExePerfLogVO tesJbExePerfLogVO) throws EventException {
		log.debug("\n\n BC.beginJobExecutionPerformance \n");
	
		String			currSeq	= null;
		
		try {
			currSeq = dbDao.beginJobExecutionPerformanceR( tesJbExePerfLogVO );
			
			if ( !"".equals( currSeq ) ) {
				tesJbExePerfLogVO.setExePerfLogSeq( currSeq );
				dbDao.beginJobExecutionPerformanceC( tesJbExePerfLogVO );
			}
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return currSeq;
	}

	/**
	 * Measuring the performance of the registered functions. 
	 *  
	 * @param String curr_seq
	 * @exception EventException
	 */
	public void endJobExecutionPerformance(String curr_seq) throws EventException {
		log.debug("\n\n BC.endJobExecutionPerformance \n");

		try {
			dbDao.endJobExecutionPerformance(curr_seq, TESCommonBC.PERF_JOB_COMPLETE);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Measuring the performance errors of the registered functions. 
	 *  
	 * @param String curr_seq
	 * @exception EventException
	 */
	public void errorJobExecutionPerformance(String curr_seq) throws EventException {
		log.debug("\n\n BC.errorJobExecutionPerformance \n");

		try {
			dbDao.endJobExecutionPerformance(curr_seq, TESCommonBC.PERF_JOB_ERROR);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Invoice No 중복 확인
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchInvNoDupChk(Event e) throws EventException {

		log.debug("\n\n BC.searchInvNoDupChk \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			eventResponse.setRs(dbDao.searchInvNoDupChk(event));	
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * Completing ESD business logic<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
