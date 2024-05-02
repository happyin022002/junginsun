/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : TESCommonBCImpl.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016-03-08 KHS
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.tescommon.basic;

import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.tes.tescommon.event.TESCommonEvent;
import com.clt.apps.opus.esd.tes.tescommon.integration.TESCommonDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * Business Logic Basic Command implementation<br>
 * - TES에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author KHS
 * @see TESCommonHTMLAction, TESCommonBC
 * @since J2EE 1.4
 */
public class TESCommonBCImpl extends BasicCommandSupport implements TESCommonBC {

	// Database Access Object
	private transient TESCommonDBDAO dbDao = null;

	/**
	 * TESCommonBCImpl object creation.<br>
	 * Creating TESCommonDBDAO<br>
	 */
	public TESCommonBCImpl() {
		dbDao = new TESCommonDBDAO();
	}

	/**
	 * Retrieve Currency Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCurrencyCodeList(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strIndex = "";
		String strCurList = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchCurrencyCodeList(event);

			while (dbRowset.next()) {
				strIndex = dbRowset.getString("DEF"); 
				strCurList = dbRowset.getString("CURR_LIST");
			}

			eventResponse.setRs(dbRowset);
			etcData.put("INDEX", strIndex);
			etcData.put("CURCD", strCurList);

			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Common Code List <br>
	 * CNTR_TPSZ_CD, MT_A_LGS_COST_CD, ON_A_LGS_COST_CD, OT_A_LGS_COST_CD, OS_A_LGS_COST_CD, ST_A_LGS_COST_CD, CARR_CD, EQ_TPSZ_CD <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommonCodeList(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strCntrTpszCd = "";
		String strMtALgsCostCd = "";
		String strOnALgsCostCd = "";
		String strOtALgsCostCd = "";
		String strOsALgsCostCd = "";
		String strStALgsCostCd = "";
		String strCarrCd = "";
		String strEqTpszCd = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchCommonCodeList(event);

			while (dbRowset.next()) {
				strCntrTpszCd = dbRowset.getString("CNTR_TPSZ_CD"); 
				strMtALgsCostCd = dbRowset.getString("MT_A_LGS_COST_CD");
				strOnALgsCostCd = dbRowset.getString("ON_A_LGS_COST_CD");
				strOtALgsCostCd = dbRowset.getString("OT_A_LGS_COST_CD");
				strOsALgsCostCd = dbRowset.getString("OS_A_LGS_COST_CD");
				strStALgsCostCd = dbRowset.getString("ST_A_LGS_COST_CD");
				strCarrCd = dbRowset.getString("CARR_CD");
				strEqTpszCd = dbRowset.getString("EQ_TPSZ_CD");
			}

			eventResponse.setRs(dbRowset);
			etcData.put("CNTR_TPSZ_CD", strCntrTpszCd);
			etcData.put("MT_A_LGS_COST_CD", strMtALgsCostCd);
			etcData.put("ON_A_LGS_COST_CD", strOnALgsCostCd);
			etcData.put("OT_A_LGS_COST_CD", strOtALgsCostCd);
			etcData.put("OS_A_LGS_COST_CD", strOsALgsCostCd);
			etcData.put("ST_A_LGS_COST_CD", strStALgsCostCd);
			etcData.put("CARR_CD", strCarrCd);
			etcData.put("EQ_TPSZ_CD", strEqTpszCd);

			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve WHLD_TAX_AMT_MODE <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWhldTaxAmtMode(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strWhldTaxAmtMode = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchWhldTaxAmtMode(event);

			while (dbRowset.next()) {
				strWhldTaxAmtMode = dbRowset.getString("YN"); 
			}

			eventResponse.setRs(dbRowset);
			etcData.put("WHLD_TAX_AMT_MODE", strWhldTaxAmtMode);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Manual Lgs Cost Cd <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualLgsCostCdList(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strManualLgsCostCd = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchManualLgsCostCdList(event);

			while (dbRowset.next()) {
				strManualLgsCostCd = dbRowset.getString("LGS_COST_CD"); 
			}

			eventResponse.setRs(dbRowset);
			etcData.put("MANUAL_LGS_COST_CD", strManualLgsCostCd);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Service Provider Name <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchServiceProviderName(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strIsValidVndrSeq = "";
		String strVndrLglEngNm = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchServiceProviderName(event);

			while (dbRowset.next()) {
				strIsValidVndrSeq = dbRowset.getString("VNDR_SEQ_EXISTING"); 
				strVndrLglEngNm = dbRowset.getString("VNDR_LGL_ENG_NM"); 
			}

			eventResponse.setRs(dbRowset);
			etcData.put("IS_VALID_VNDR_SEQ", strIsValidVndrSeq);
			etcData.put("VNDR_LGL_ENG_NM", strVndrLglEngNm);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Invoice Duplication YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvDuplicateYN(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strInvDupYN = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchInvDuplicateYN(event);

			while (dbRowset.next()) {
				strInvDupYN = dbRowset.getString("INV_DUP_YN"); 
			}

			eventResponse.setRs(dbRowset);
			etcData.put("INV_DUP_YN", strInvDupYN);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Error Invoice Validation YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchErrInvValidYN(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strInvDupYN = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchErrInvValidYN(event);

			while (dbRowset.next()) {
				strInvDupYN = dbRowset.getString("YN"); 
			}

			eventResponse.setRs(dbRowset);
			etcData.put("ERR_INV_VALID_YN", strInvDupYN);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Yard Code Validation & Cost Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYdCdCostCdList(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strYdCdExisting = "";
		String strYdCd = "";
		String strYdNm = "";
		String strYdChrCd = "";
		String strYdFctyTpMrnTmlFlg = "";
		String strYdFctyTpCyFlg = "";
		String strYdFctyTpCfsFlg = "";
		String strYdFctyTpRailRmpFlg = "";
		String strYdOshpCd = "";
		String strCostCdMt = "";
		String strCostCdOn = "";
		String strCostCdOt = "";
		String strCostCdOs = "";
		String strCostCdSt = "";
		String strCostCdSe = "";
		String strCostCdOe = "";		

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchYdCdCostCdList(event);

			while (dbRowset.next()) {
				strYdCdExisting = dbRowset.getString("YD_CD_EXISTING"); 
				strYdCd = dbRowset.getString("YD_CD"); 
				strYdNm = dbRowset.getString("YD_NM"); 
				strYdChrCd = dbRowset.getString("YD_CHR_CD"); 
				strYdFctyTpMrnTmlFlg = dbRowset.getString("YD_FCTY_TP_MRN_TML_FLG"); 
				strYdFctyTpCyFlg = dbRowset.getString("YD_FCTY_TP_CY_FLG"); 
				strYdFctyTpCfsFlg = dbRowset.getString("YD_FCTY_TP_CFS_FLG"); 
				strYdFctyTpRailRmpFlg = dbRowset.getString("YD_FCTY_TP_RAIL_RMP_FLG"); 
				strYdOshpCd = dbRowset.getString("YD_OSHP_CD"); 
				strCostCdMt = dbRowset.getString("COST_CD_MT"); 
				strCostCdOn = dbRowset.getString("COST_CD_ON"); 
				strCostCdOt = dbRowset.getString("COST_CD_OT");
				strCostCdOs = dbRowset.getString("COST_CD_OS"); 
				strCostCdSt = dbRowset.getString("COST_CD_ST"); 
				strCostCdSe = dbRowset.getString("COST_CD_SE"); 
				strCostCdOe = dbRowset.getString("COST_CD_OE"); 
			}

			eventResponse.setRs(dbRowset);
			
			etcData.put("YD_CD_EXISTING", strYdCdExisting);
			etcData.put("YD_CD", strYdCd);
			etcData.put("YD_NM", strYdNm);
			etcData.put("YD_CHR_CD", strYdChrCd);
			etcData.put("YD_FCTY_TP_MRN_TML_FLG", strYdFctyTpMrnTmlFlg);
			etcData.put("YD_FCTY_TP_CY_FLG", strYdFctyTpCyFlg);
			etcData.put("YD_FCTY_TP_CFS_FLG", strYdFctyTpCfsFlg);
			etcData.put("YD_FCTY_TP_RAIL_RMP_FLG", strYdFctyTpRailRmpFlg);
			etcData.put("YD_OSHP_CD", strYdOshpCd);
			etcData.put("COST_CD_MT", strCostCdMt);
			etcData.put("COST_CD_ON", strCostCdOn);
			etcData.put("COST_CD_OT", strCostCdOt);
			etcData.put("COST_CD_OS", strCostCdOs);
			etcData.put("COST_CD_ST", strCostCdSt);
			etcData.put("COST_CD_SE", strCostCdSe);
			etcData.put("COST_CD_OE", strCostCdOe);
			
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Office Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOfcCd(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strOfcCd = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchOfcCd(event);

			while (dbRowset.next()) {
				strOfcCd = dbRowset.getString("OFC_CD"); 
			}

			eventResponse.setRs(dbRowset);
			etcData.put("OFC_CD", strOfcCd);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Sub Trade Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubTrdCdList(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strSubTrdCd = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchSubTrdCdList(event);

			while (dbRowset.next()) {
				strSubTrdCd = dbRowset.getString("SUB_TRD_CD"); 
			}

			eventResponse.setRs(dbRowset);
			etcData.put("SUB_TRD_CD", strSubTrdCd);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Agreement Cost Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtCostCdList(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strAgmtCostCd = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchAgmtCostCdList(event);

			while (dbRowset.next()) {
				strAgmtCostCd = dbRowset.getString("COST_CODE"); 
			}

			eventResponse.setRs(dbRowset);
			etcData.put("AGMT_COST_CODE", strAgmtCostCd);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Agreement Status Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtStatusCd(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strEx = "";
		String strStatus = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {			
			if ( "TM".equals( event.getTesCommonVO().getTmlInvTpCd() ) ) {	// Terminal Invoice
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getAtbDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getAtbDt() );
			} else if ("ON".equals( event.getTesCommonVO().getTmlInvTpCd() ) ) {	// OnDock
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getMinWrkDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getMaxWrkDt() );
			} else if ("OF".equals( event.getTesCommonVO().getTmlInvTpCd() ) ) {	// OffDock
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getFmPrdDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getToPrdDt() );
			} else if ("ST".equals( event.getTesCommonVO().getTmlInvTpCd() ) ) { // Storage
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getFmPrdDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getToPrdDt() );
			} 		
			
			dbRowset = dbDao.searchAgmtStatusCd(event);

			while (dbRowset.next()) {
				strEx = dbRowset.getString("EX");
				strStatus = dbRowset.getString("ST"); 
			}

			eventResponse.setRs(dbRowset);
			etcData.put("EX", strEx);
			etcData.put("ST", strStatus);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve SLane Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSLanCd(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strSLanCd = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchSLanCd(event);

			while (dbRowset.next()) {
				strSLanCd = dbRowset.getString("SLAN_CD");
			}

			eventResponse.setRs(dbRowset);
			etcData.put("SLAN_CD", strSLanCd);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Cost Office Validation YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostOfcValidYN(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String sOfcCdValidYN = "";
		String sYdCdValidYN = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchCostOfcValidYN(event);

			while (dbRowset.next()) {
				sOfcCdValidYN = dbRowset.getString("IS_EXISTING_OFC_CD");
				sYdCdValidYN = dbRowset.getString("IS_VALID_YD_CD");
			}

			eventResponse.setRs(dbRowset);
			etcData.put("IS_EXISTING_OFC_CD", sOfcCdValidYN);
			etcData.put("IS_VALID_YD_CD", sYdCdValidYN);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Agreement Curr Cd <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtCurrCd(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strAgmtCurrCd = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {			
			if ( "TM".equals( event.getTesCommonVO().getTmlInvTpCd() ) ) {	// Terminal Invoice
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getAtbDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getAtbDt() );
			} else if ("ON".equals( event.getTesCommonVO().getTmlInvTpCd() ) ) {	// OnDock
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getMinWrkDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getMaxWrkDt() );
			} else if ("OF".equals( event.getTesCommonVO().getTmlInvTpCd() ) ) {	// OffDock
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getFmPrdDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getToPrdDt() );
			} else if ("ST".equals( event.getTesCommonVO().getTmlInvTpCd() ) ) { // Storage
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getFmPrdDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getToPrdDt() );
			} 		
			
			dbRowset = dbDao.searchAgmtCurrCd(event);

			while (dbRowset.next()) {
				strAgmtCurrCd = dbRowset.getString("CURR_CD");
			}

			eventResponse.setRs(dbRowset);
			etcData.put("CURR_CD", strAgmtCurrCd);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Equipment Type Size <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEquipTypeCd(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String sOfcCdValidYN = "";
		String sYdCdValidYN = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchEquipTypeCd(event);

			while (dbRowset.next()) {
				sOfcCdValidYN = dbRowset.getString("IS_EXISTING_OFC_CD");
				sYdCdValidYN = dbRowset.getString("IS_VALID_YD_CD");
			}

			eventResponse.setRs(dbRowset);
			etcData.put("IS_EXISTING_OFC_CD", sOfcCdValidYN);
			etcData.put("IS_VALID_YD_CD", sYdCdValidYN);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Authorization Office Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAuthOfcCd(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String sAuthOfcCd = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchAuthOfcCd(event);

			while (dbRowset.next()) {
				sAuthOfcCd = dbRowset.getString("AUTH_OFCS");
			}

			eventResponse.setRs(dbRowset);
			etcData.put("AUTH_OFCS", sAuthOfcCd);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Yard Code Validation  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYdCdValid(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strYdCdExisting = "";
		String strYdCd = "";
		String strYdNm = "";
		String strYdChrCd = "";
		String strYdFctyTpMrnTmlFlg = "";
		String strYdFctyTpCyFlg = "";
		String strYdFctyTpCfsFlg = "";
		String strYdFctyTpRailRmpFlg = "";
		String strYdOshpCd = "";
		String strDelFlg = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchYdCdValid(event);

			while (dbRowset.next()) {
				strYdCdExisting = dbRowset.getString("YD_CD_EXISTING"); 
				strYdCd = dbRowset.getString("YD_CD"); 
				strYdNm = dbRowset.getString("YD_NM"); 
				strYdChrCd = dbRowset.getString("YD_CHR_CD"); 
				strYdFctyTpMrnTmlFlg = dbRowset.getString("YD_FCTY_TP_MRN_TML_FLG"); 
				strYdFctyTpCyFlg = dbRowset.getString("YD_FCTY_TP_CY_FLG"); 
				strYdFctyTpCfsFlg = dbRowset.getString("YD_FCTY_TP_CFS_FLG"); 
				strYdFctyTpRailRmpFlg = dbRowset.getString("YD_FCTY_TP_RAIL_RMP_FLG"); 
				strYdOshpCd = dbRowset.getString("YD_OSHP_CD"); 
				strDelFlg = dbRowset.getString("DELT_FLG"); 
			}

			eventResponse.setRs(dbRowset);
			
			etcData.put("YD_CD_EXISTING", strYdCdExisting);
			etcData.put("YD_CD", strYdCd);
			etcData.put("YD_NM", strYdNm);
			etcData.put("YD_CHR_CD", strYdChrCd);
			etcData.put("YD_FCTY_TP_MRN_TML_FLG", strYdFctyTpMrnTmlFlg);
			etcData.put("YD_FCTY_TP_CY_FLG", strYdFctyTpCyFlg);
			etcData.put("YD_FCTY_TP_CFS_FLG", strYdFctyTpCfsFlg);
			etcData.put("YD_FCTY_TP_RAIL_RMP_FLG", strYdFctyTpRailRmpFlg);
			etcData.put("YD_OSHP_CD", strYdOshpCd);
			etcData.put("DELT_FLG", strDelFlg);
			
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Vendor Code Validation <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVndrCdValid(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strVndrSeqExisting = "";
		String strVndrSeqNm = "";
		String strDelFlg = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchVndrCdValid(event);

			while (dbRowset.next()) {
				strVndrSeqExisting = dbRowset.getString("VNDR_SEQ_EXISTING"); 
				strVndrSeqNm = dbRowset.getString("VNDR_LGL_ENG_NM"); 
				strDelFlg = dbRowset.getString("DELT_FLG"); 
			}

			eventResponse.setRs(dbRowset);
			
			etcData.put("VNDR_SEQ_EXISTING", strVndrSeqExisting);
			etcData.put("VNDR_LGL_ENG_NM", strVndrSeqNm);
			etcData.put("DELT_FLG", strDelFlg);
			
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve CURR_DATE (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC) <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDBDate(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strCurrDate = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchDBDate(event);

			while (dbRowset.next()) {
				strCurrDate = dbRowset.getString("CURR_DATE"); 
			}

			eventResponse.setRs(dbRowset);
			
			etcData.put("CURR_DATE", strCurrDate);
			
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Cost Office Validation Delete YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostOfcValidDelYN(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strIsExistingOfcCd = "";
		String strIsValidYdCd = "";
		String strDelFlg = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchCostOfcValidDelYN(event);

			while (dbRowset.next()) {
				strIsExistingOfcCd = dbRowset.getString("IS_EXISTING_OFC_CD");
				strIsValidYdCd = dbRowset.getString("IS_VALID_YD_CD");
				strDelFlg = dbRowset.getString("DELT_FLG");
			}

			eventResponse.setRs(dbRowset);
			
			etcData.put("IS_EXISTING_OFC_CD", strIsExistingOfcCd);
			etcData.put("IS_VALID_YD_CD", strIsValidYdCd);
			etcData.put("DELT_FLG", strDelFlg);
			
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Invoice Office Validation Delete YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvOfcValidDelYN(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strIsExistingOfcCd = "";
		String strIsValidYdCd = "";
		String strDelFlg = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchInvOfcValidDelYN(event);

			while (dbRowset.next()) {
				strIsExistingOfcCd = dbRowset.getString("IS_EXISTING_OFC_CD");
				strIsValidYdCd = dbRowset.getString("IS_VALID_YD_CD");
				strDelFlg = dbRowset.getString("DELT_FLG");
			}

			eventResponse.setRs(dbRowset);
			
			etcData.put("IS_EXISTING_OFC_CD", strIsExistingOfcCd);
			etcData.put("IS_VALID_YD_CD", strIsValidYdCd);
			etcData.put("DELT_FLG", strDelFlg);
			
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Invoice Office Validation Delete YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostCode(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strCostCd = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchCostCode(event);

			while (dbRowset.next()) {
				strCostCd = dbRowset.getString("COST_CODE");
			}

			eventResponse.setRs(dbRowset);
			
			etcData.put("COST_CODE", strCostCd);
			
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Node Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchNodeCdList(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strNodeCd = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchNodeCdList(event);

			while (dbRowset.next()) {
				strNodeCd = dbRowset.getString("NOD_CD");
			}

			eventResponse.setRs(dbRowset);
			
			etcData.put("NOD_CD", strNodeCd);
			
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Container Type Size <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrTpSz(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;

		String strCntrTpSz = "";

		Map<String, String> etcData = new HashMap<String, String>();
		try {
			dbRowset = dbDao.searchCntrTpSz(event);

			while (dbRowset.next()) {
				strCntrTpSz = dbRowset.getString("CNTR_TPSZ_CD");
			}

			eventResponse.setRs(dbRowset);
			
			etcData.put("CNTR_TPSZ_CD", strCntrTpSz);
			
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
}
