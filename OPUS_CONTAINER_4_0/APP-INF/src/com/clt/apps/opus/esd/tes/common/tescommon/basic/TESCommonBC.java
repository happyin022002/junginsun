/**
 * Copyright(c) 2006 CyberLogitec
 * @FileName : TESCommonBC.java
 * @FileTitle : TES Common
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion : 1.0
 */
package com.clt.apps.opus.esd.tes.common.tescommon.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.syscommon.common.table.TesJbExePerfLogVO;

/**
 * ESD Business Logic Basic Command implementation<br>
 * Coding business logic for ESD<br>
 *
 * @author byungheeyoo
 * @see TESCommonHTMLAction, TESCommonBC
 * @since J2EE 1.4
 */
public interface TESCommonBC  {

	static final String PERF_PAGE_URL_PARAMETER_NAME 	= "TESPerfPageURL";
	static final int PERF_SIZE_PAGE_URL					= 50;

	static final boolean IS_CHK_PERF_PARAMETER_SIZE_Y	= true;
	static final boolean IS_CHK_PERF_PARAMETER_SIZE_N	= false;
	static final int PERF_SIZE_PARAMETER_VALUE			= 1000;
	static final int PERF_DEFAULT_MAX_SIZE_PARAMETER_VALUE	= 999999;

	static final String PERF_JOB_TYPE_ON_LINE 			= "ON";	//ON-LINE
	static final String PERF_JOB_TYPE_ON_LINE_INVOICE 	= "OI";	//ON-LINE INVOICE : 
	static final String PERF_JOB_TYPE_ON_LINE_AGREEMENT = "OA";	//ON-LINE AGREEMENT
	static final String PERF_JOB_TYPE_BATCH 			= "BT";	//BATCH
	static final String PERF_JOB_TYPE_TPB   		    = "3P";	//TPB I/F DATA

	static final String PERF_JOB_BEGIN 		= "B";	//BEGIN
	static final String PERF_JOB_COMPLETE 	= "C";	//COMPLETE
	static final String PERF_JOB_ERROR 		= "E";	//ERROR

	/**
	 * Retrieving MDM's cnt_cd by ofc_cd. 
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getMDMCnt_cd(String ofc_cd) throws EventException;

	/**
	 * Retrieving Cost OFC.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostOFC(Event e) throws EventException;

	/** searchEQNo
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEQNo(Event e) throws EventException;
	
	/**
	 * Retrieving currency.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCurrencyList(Event e) throws EventException;

	/**
	 * Validating Cost OFC.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateCostOFC(Event e) throws EventException;

	/**
	 * Cost OFC confirm the presence
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateCostOFC2(Event e) throws EventException;

	/**
	 * INV OFC confirm the presence
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateInvOFC(Event e) throws EventException;

	/**
	 * Retrieving Node Code by Location Code.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getNodeCode(Event e) throws EventException;

	/**
	 * Validating Yard code.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateYardCode(Event e) throws EventException;

	/**
	 * Yard code confirm the presence
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateYardCode2(Event e) throws EventException;

	/**
	 * Retrieving DB time.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getDBdate(Event e) throws EventException;

	/**
	 * Validating vndr code.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateVndrCode(Event e) throws EventException;

	/**
	 * vndr code confirm the presence
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateVndrCode2(Event e) throws EventException;

	/**
	 * Retrieving cost code in yard code.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYdCostCodeList(Event e) throws EventException;

	/**
	 * Validating Yard code and Retrieving cost code
	 * @param Event e
	 * @return
	 * @exception EventException
	 */
	public EventResponse validateYardCodeNsearchYdCostCodeList(Event e) throws EventException;

	/**
	 * Retrieving TES' cost code
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTESCostCodeList(Event e) throws EventException;

	/** searchAgmtCostCodeList
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchAgmtCostCodeList(Event e) throws EventException;
	
	/**
	 * Retrieving CntrTPCD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrTPCDList(Event e) throws EventException;

	/**
	 * Retrieving CntrSZCD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrSZCDList(Event e) throws EventException;

	/**
	 * Retrieving CntrTPSZCD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrTPSZCDList(Event e) throws EventException;

	/**
	 * Retrieving Lane CD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLaneList(Event e) throws EventException;

	/**
	 * Retrieving auto Cost code.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAutoTESTmlSoCostCDList(Event e) throws EventException;

	/**
	 * Retrieving manual Cost code
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualTESTmlSoCostCDList(Event e) throws EventException;

	/**
	 * Retrieving TES invoice common code.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTESInvoiceCommonCodeList(Event e) throws EventException;

	/**
	 * Retrieving agreement cost code.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgreementCostCodeList(Event e) throws EventException;

	/**
	 * Retrieving Lane CD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLaneCodeList(Event e) throws EventException;

	/**
	 * Retrieving Sub Trade CD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubTrdCodeList(Event e) throws EventException;

	/** searchBkgCntrTPCDList
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchBkgCntrTPCDList(Event e) throws EventException;
	
	
	/**
	 * Retrieving Lane CD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMDMAccount(Event e) throws EventException;

	/**
	 * Retrieving Lane CD.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAuthOfcCd(Event e) throws EventException;

	/**
	 * Measuring the performance of the registered functions.
	 *  
	 * @param TesJbExePerfLogVO tesJbExePerfLogVO
	 * @return String
	 * @exception EventException
	 */
	public String beginJobExecutionPerformance(TesJbExePerfLogVO tesJbExePerfLogVO) throws EventException;

	/**
	 * Measuring the performance of the registered functions. 
	 *  
	 * @param String curr_seq
	 * @exception EventException
	 */
	public void endJobExecutionPerformance(String curr_seq) throws EventException;

	/**
	 * Measuring the performance errors of the registered functions. 
	 *  
	 * @param String curr_seq
	 * @exception EventException
	 */
	public void errorJobExecutionPerformance(String curr_seq) throws EventException;

	/**
	 * Invoice No 중복 확인
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvNoDupChk(Event e) throws EventException;
	
	/**
	 * Completing ESD business logic<br>
	 */
	public void doEnd();
}