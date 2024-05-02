/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESInvoiceCommonBCImpl.java
*@FileTitle : TES Invoice Common 관리
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic;

import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.event.TESInvoiceCommonEvent;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration.TESInvoiceCommonDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;

/**
 * ESD Business Logic Basic Command implementation<br>
 * ESD business logic handling.<br>
 * 
 * @author byungheeyoo
 * @see TESInvoiceCommonBC each DAO class reference
 * @since J2EE 1.4
 */
public class TESInvoiceCommonBCImpl   extends BasicCommandSupport implements TESInvoiceCommonBC {

	// Database Access Object
	private transient TESInvoiceCommonDBDAO dbDao=null;

	/**
	 * TESInvoiceCommonBCImpl object creation<br>
	 * TESInvoiceCommonDBDAO creation<br>
	 */
	public TESInvoiceCommonBCImpl(){
		dbDao = new TESInvoiceCommonDBDAO();
	}
	
	
	/**
	 * Get Withholding tax mode
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getWHTmode(Event e) throws EventException {
		log.debug("\n\n BC.getWHTmode \n");
		
		TESInvoiceCommonEvent	event			= (TESInvoiceCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			eventResponse.setRs (dbDao.getWHTmode(event));
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
	 * Get agreement currency code
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getAgmtCurrCD(Event e) throws EventException {
		log.debug("\n\n BC.getAgmtCurrCD \n");
		TESInvoiceCommonEvent	event			=(TESInvoiceCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			
			if ( "TM".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {	// Terminal Invoice
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getAtbDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getAtbDt() );
			} else if ("ON".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {	// OnDock
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getMinWrkDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getMaxWrkDt() );
			} else if ("OF".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {	// Storage, OffDock
				event.getTesCommonVO().setFromDate( event.getTesTmlSoHdrVO().getToPrdDt() );
				event.getTesCommonVO().setToDate( event.getTesTmlSoHdrVO().getToPrdDt() );
			} else if ("ST".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {
				event.getTesCommonVO().setFromDate( event.getTesTmlSoHdrVO().getFmPrdDt() );
				event.getTesCommonVO().setToDate( event.getTesTmlSoHdrVO().getFmPrdDt() );
			}
			
			eventResponse.setRs ( dbDao.getAgmtCurrCD(event) );
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
	 * Get agreement status
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getAgmtSts(Event e) throws EventException {
		log.debug("\n\n BC.getAgmtSts \n");
		TESInvoiceCommonEvent	event			= (TESInvoiceCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
		try {
			
			if ( "TM".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {	// Terminal Invoice
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getAtbDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getAtbDt() );
			} else if ("ON".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {	// OnDock
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getMinWrkDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getMaxWrkDt() );
			} else if ("OF".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {	// Storage, OffDock
				event.getTesCommonVO().setFromDate( event.getTesTmlSoHdrVO().getToPrdDt() );
				event.getTesCommonVO().setToDate( event.getTesTmlSoHdrVO().getToPrdDt() );
			} else if ("ST".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {
				event.getTesCommonVO().setFromDate( event.getTesTmlSoHdrVO().getFmPrdDt() );
				event.getTesCommonVO().setToDate( event.getTesTmlSoHdrVO().getFmPrdDt() );
			} 		
		 	
			eventResponse.setRs ( dbDao.getAgmtSts( event ) );
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
	 * Get COST CODE N3PTY_BIL_CS_CD
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getN3ptyBilCSCD(Event e) throws EventException {
		log.debug("\n\n BC.getN3ptyBilCSCD \n");
		TESInvoiceCommonEvent event=(TESInvoiceCommonEvent)e;
		GeneralEventResponse	eventResponse = new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			eventResponse.setRs (dbDao.getN3ptyBilCSCD(event));
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
	 * Get ERR_INV_NO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse isValidErrInvNo(Event e) throws EventException {
		log.debug("\n\n BC.isValidErrInvNo \n");
		
		TESInvoiceCommonEvent event=(TESInvoiceCommonEvent)e;
		GeneralEventResponse	eventResponse = new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
	
		try {
			eventResponse.setRs (dbDao.isValidErrInvNo(event));
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
	 * selectYdNm
	 * @param TesTmlSoHdrVO model
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse selectYdNm(TesTmlSoHdrVO model) throws EventException {
		log.debug("\n\n BC.selectYdNm \n");
		GeneralEventResponse	eventResponse = new GeneralEventResponse();
		String ydNm = "";
		Map<String, String> etcData	= new HashMap<String, String>();
		
		try {
			ydNm = dbDao.selectYdNm(model);
			etcData.put("yd_nm", ydNm);
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/** selectVndrNm
	 * 
	 * @param model
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse selectVndrNm(TesTmlSoHdrVO model) throws EventException {
		log.debug("\n\n BC.selectVndrNm \n");
		GeneralEventResponse	eventResponse = new GeneralEventResponse();
		String vndrNm = "";
		Map<String, String> etcData	= new HashMap<String, String>();
		
		try {
			vndrNm = dbDao.selectVndrNm(model);
			etcData.put("vndr_nm", vndrNm);
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/** selectCostCdFtrRmk
	 * 
	 * @param model
	 * @return String
	 * @throws EventException
	 */
	public String selectCostCdFtrRmk(TesTmlSoHdrVO model) throws EventException {
		log.debug("\n\n BC.selectCostCdFtrRmk \n");
		String costCdFtrRmk = "";
		
		try {
			costCdFtrRmk = dbDao.selectCostCdFtrRmk(model);
			
			return costCdFtrRmk ;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Check invoice Status
	 * @param TesTmlSoHdrVO model
	 * @param String mode
	 * @exception EventException
	 */
	public void checkInvoiceStatus(TesTmlSoHdrVO model, String mode) throws EventException {
		log.debug("\n\n BC.checkInvoiceStatus \n");
	
		try {
			dbDao.checkInvoiceStatus(model, mode);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Check invoice Status
	 * @param TesTmlSoHdrVO[] tesTmlSoHdrVOs
	 * @param String mode
	 * @exception EventException
	 */
	public void checkInvoiceStatus(TesTmlSoHdrVO[] tesTmlSoHdrVOs, String mode) throws EventException {
		log.debug("\n\n BC.checkInvoicesStatus \n");
	
		try {
			dbDao.checkInvoiceStatus(tesTmlSoHdrVOs, mode);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Check invoice Status
	 * @param String csrNo
	 * @param String mode
	 * @exception EventException
	 */
	public void checkInvoiceStatus(String csrNo, String mode) throws EventException {
		log.debug("\n\n BC.checkInvoicesStatus \n");
	
		try {
			dbDao.checkInvoiceStatus(csrNo, mode);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Check TBP I/F DATA
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @exception EventException
	 */
	public void checkDetailTpb(TesTmlSoHdrVO tesTmlSoHdrVO) throws EventException {
		log.debug("\n\n BC.checkDetailTpb \n");
		
		try {
			dbDao.checkDetailTpb( tesTmlSoHdrVO );
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESD Handling for the end of working scenario<br>
	 * TESInvoiceCommon Clearing object by the end of work scenario<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
	
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getMgstNos(Event e) throws EventException {
		log.debug("\n\n BC.getMgstNos \n");
		TESInvoiceCommonEvent	event			= (TESInvoiceCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
		try {
			eventResponse.setRs ( dbDao.getMgstNos( event ) );
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
	 * Invoice CF Cost Code Check auto calc
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse checkInvCalcCostCD(TesTmlSoHdrVO tesTmlSoHdrVO) throws EventException {
		log.debug("\n\n BC.checkInvCalcCostCD \n");
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			DBRowSet 	costCdSet = dbDao.checkInvCalcCostCD( tesTmlSoHdrVO );
			
			String 		chk				= "";
			String 		tmp_wrong_inv	= "";
			String 		tmp_no_dtl_inv	= "";
			int 		knt_wrong_inv 	= 0;
			int 		knt_no_dtl_inv 	= 0;
			
			while (costCdSet.next()){
				chk = costCdSet.getString("CHK");
				log.debug("\n\n  INV_NO:"+costCdSet.getString("INV_NO") + " - LGS_COST_CD:"+costCdSet.getString("LGS_COST_CD")+"  ---------------------  --------------------- ---------------------  \n\n");
				
				if (chk!=null && chk.trim().equals("N")){
					tmp_wrong_inv = tmp_wrong_inv + ((costCdSet.isFirst()?"":(++knt_wrong_inv>0?", ":"")) + (costCdSet.getString("INV_NO")));
				} else if (chk!=null && chk.trim().equals("NF")){
					tmp_no_dtl_inv = tmp_no_dtl_inv + ((costCdSet.isFirst()?"":(++knt_no_dtl_inv>0?", ":"")) + (costCdSet.getString("INV_NO")));
				}
			}

			log.debug("\n\n %%%%% tmp_wrong_inv : "+tmp_wrong_inv + " %%%%% %%%%% %%%%% \n");
			log.debug("\n\n %%%%% tmp_no_dtl_inv : "+tmp_no_dtl_inv + " %%%%% %%%%% %%%%% \n");
			
			if (tmp_wrong_inv!=null && !tmp_wrong_inv.trim().equals("")){
				throw new EventException(new ErrorHandler("TES00085", new String[]{tmp_wrong_inv}).getMessage());		
			}
			if (tmp_no_dtl_inv!=null && !tmp_no_dtl_inv.trim().equals("")){
				throw new EventException(new ErrorHandler("TES00086", new String[]{tmp_no_dtl_inv}).getMessage());					
			}
			
		} catch(EventException ex) {
			throw ex;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(ex.getMessage());
		} 
		
		return eventResponse;
	}
	
	/**
	 * Confirm Button Click <br />
	 * Invoice Creation Confirm Button Click AP_PAY_INV Info retrieve <br />
	 * @category 
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return ApPayInvVO
	 * @throws EventException
	 */
	public ApPayInvVO searchApPayInv(TesTmlSoHdrVO tesTmlSoHdrVO) throws EventException {
		log.debug("\n\n BCim.searchApPayInv \n");
		try {
			return dbDao.searchApPayInv(tesTmlSoHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("", new String[]{"Invoice Creation"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("", new String[]{"Invoice Creation"}).getMessage(),ex);
		}
	}
	
	/**
	 * searchApPayInvDtl 
	 * Invoice Creation Confirm Button Click AP_PAY_INV Info retrieve <br />
	 * @category 
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @param  ApPayInvVO apPayInvVO
	 * @return ApPayInvDtlVO[]
	 * @throws EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvDtl(TesTmlSoHdrVO tesTmlSoHdrVO, ApPayInvVO apPayInvVO) throws EventException { 
		log.debug("\n\n BCim.searchApPayInvDtl \n");
		try {
			return dbDao.searchApPayInvDtl(tesTmlSoHdrVO, apPayInvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("", new String[]{"Invoice Creation"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("", new String[]{"Invoice Creation"}).getMessage(),ex);
		}
	}	
	
	/** cancelApPayInvAll
	 * 
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @param ApPayInvVO apPayInvVO
	 * @throws EventException
	 */
	public void cancelApPayInvAll(TesTmlSoHdrVO tesTmlSoHdrVO, ApPayInvVO apPayInvVO) throws EventException {
		log.debug("\n\n BCim.searchApPayInv \n");
		
		try {
			String invRgstNo = dbDao.searchApPayInvRgstNo(tesTmlSoHdrVO);
			apPayInvVO.setInvRgstNo(invRgstNo);
			
			if(invRgstNo!=null && !invRgstNo.equals("")){
				dbDao.cancelApPayInv(apPayInvVO);
				dbDao.cancelApPayInvDtl(apPayInvVO);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("", new String[]{"Invoice Creation"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("", new String[]{"Invoice Creation"}).getMessage(),ex);
		}
	}
	
}
