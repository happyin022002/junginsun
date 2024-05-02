/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingCommonSC.java
 *@FileTitle : Booking Page
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.event.EsmBkg0080Event;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.event.EsmBkg0088Event;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.event.EsmBkg0895Event;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.event.EsmBookingUtilEvent;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilDBDAO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgCstmsHrdCdgCtntVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmChgTaxFlgVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.ReportItemVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchSvcLaneBoundVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingProcessMgtBC;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingProcessMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.PickUpNoticeBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.PickUpNoticeBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1063Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.framework.component.databasedata.FileDatabaseData;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;
import com.clt.syscommon.common.table.MdmYardVO;

/**
 * BookingCommon Business Logic ServiceCommand - 
 * Handling business transaction about BookingCommon. 
 * 
 * @author 
 * @see BookingUtilDBDAO
 * @since J2EE 1.4
 */

public class BookingCommonSC extends ServiceCommandSupport {
	// Login User Information
    private SignOnUserAccount account = null;
    
	/**
	 * Preceding tasks BookingCommon system business scenarios<br>
	 * Creating related internal object in case of calling UI_Booking_Util business scenario.
	 */
	public void doStart() {
		log.debug("Starting BookingCommonSC");
		try {
			// Checking Log-in
            account = getSignOnUserAccount();
        } catch(Exception e) {
            log.error(e.getMessage());
        }
	}

	/**
	 * Finishing tasks BookingCommon system business scenarios<br>
	 * Releasing related internal object in case of closing UI_Booking_Util business scenario.<br>
	 */
	public void doEnd() {
		log.debug("Closing BookingCommonSC");
	}

	
	/**
	 * Performing business scenarios that related each event<br>
	 * Jump handling all events that occurs in BookingCommon system.
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		/* EsmBookingUtilEvent */
		if (e.getEventName().equalsIgnoreCase("EsmBookingUtilEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCombo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchBkgNoByBlNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchBkgStatusByBkg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchBkgNoSplitByBkg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = sendFaxEmailByBkgNoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = existCountryCode(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = seacrhMDMCombo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {
				eventResponse = searchFrob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)) {
				eventResponse = searchRfaAvailable(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {
				eventResponse = searchScAvailable(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchTaaAvailable(e);

			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)) {
				// Parameter value: BKG_NO,return values:OLD ,NEW BKG_NO number separator($)
				eventResponse = searchBkgNoListByBkgNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST15)) {
				// Parameter value: BL_NO,return values:OLD ,NEW BL_NO number separator($)
				eventResponse = searchBlNoListByBlNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST16)) {
				// Function that checks existence of ChargeCode code number.
				eventResponse = existChargeCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST17)) {
				// Parameter value: LOC_CD code number ,return value: LOC_NM
				eventResponse = searchMdmLocName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST18)) {
				// Function that checks existence of CurrencyCode code number 
				eventResponse = existCurrencyCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST19)) {
				// Checking Third (Offce cd) validation 
				eventResponse = existThirdCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST20)) {
				// Checking Payer (custCntCd, custSeq) validation
				eventResponse = existPayerCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				// Checking Per (per) validation
				eventResponse = existPerCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND10)) {
				eventResponse = exeProcedureTest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				// Checking This customer is blacklisted customer validation
				eventResponse = existBlackListedCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				// Checking existNoteButtonColor validation
				eventResponse = existNoteButtonColor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				// Checking AutoratingRfaAvailable validation
				eventResponse = autoratingRfaAvailable(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				// Checking AutoratingScAvailable validation 
				eventResponse = autoratingScAvailable(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)){
				// Checking AutoratingTaaAvailable validation
				eventResponse = autoratingTaaAvailable(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)){
				// Checking repCustomer validation
				eventResponse = repCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND08)){
				// saveFileExist Checking whether the file exists
				eventResponse = saveFileExist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)){
				// Executing Sql in case of receiving input from ESM_Booking_Util_01 screen
					eventResponse = executeQuery(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				// searchCountryName
				eventResponse = searchCountryName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				// searchScNoValidationCheck
				eventResponse = searchScNoValidationCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				// searchBkgVvdCheck
				eventResponse = searchBkgVvdCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				// autoRatingRFACheck
				eventResponse = autoRatingRFACheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)){
				// autoRatingRFACheck
				eventResponse = searchRtAplyDateCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)){
				// doc Perfomance Report User id
				eventResponse = seacrhDocPerformanceUserCheck(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)){
				// ANCS Main Menu
				eventResponse = searchCstmsHardCodingList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)){
				// searchMdmEurFlg
				eventResponse = searchMdmEurFlg(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)){
				// searchChgTaxFlg ESM_BKG_0079_08
				eventResponse = searchChgTaxFlg(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				// Reactivate Booking
				eventResponse = reactivateBooking(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {
                eventResponse = executeBatch(e);
//            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
//                eventResponse = monitorPickupSetting(e);
            }
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = checkCntrTpszCd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchSoStatus(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchUserPgmRoleMach(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchDpPrcsKntByCur(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = checkHtml5RDPass(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchVslNm(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchLocationNm(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				eventResponse = searchLocCdByOfcCd(e);
			}
			
		} else /* EsmBkg0080Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTypeSize(e);
			}
		} else /* EsmBkg0088Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0088Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchYardCode(e);
			}
		} else /* EsmBkg0895Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0895Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReportItemList(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * searchRtAplyDateChecksearchRtAplyDateCheck Handling aa retrieving event<br>
	 * Checking event <br>
	 * Checking whether value RtAplyDate exists <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRtAplyDateCheck(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchRtAplyDateCheck(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * autoRatingRFACheck Handling aa retrieving event<br>
	 * Checking event <br>
	 * Checking RFA Number validation <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse autoRatingRFACheck(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.autoRatingRFACheck(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * searchBkgVvdCheck Handling aa retrieving event<br>
	 * Checking event <br>
	 * Checking ScNumber validation <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVvdCheck(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchBkgVvdCheck(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * searchScNoValidationCheck Handling aa retrieving event<br>
	 * 79-08 Checking event <br>
	 * Checking ScNumber validation <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScNoValidationCheck(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchScNoValidationCheck(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * searchCountryName Handling aa retrieving event<br>
	 * 79-02C Checking event <br>
	 * Getting name value MDM_COUNTRY <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCountryName(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchCountryName(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * Checking whether the file exists  
	 * After checking file_path_url with file_id number, file existence check function 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse saveFileExist(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		
		try {
			boolean fileExist = new FileDatabaseData(event.getInputText()).getFile().exists();
			eventResponse.setETCData("output_text", String.valueOf(fileExist));
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * AutoratingRfaAvailable Handling aa retrieving event<br>
	 * 79-08 Checking event <br>
	 * Checking AutoratingRfaAvailable validation <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse autoratingRfaAvailable(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.autoratingRfaAvailable(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * Handling AutoratingScAvailable retrieving event<br>
	 * 79-08 Checking event <br>
	 * Checking AutoratingScAvailable validation <br> 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse autoratingScAvailable(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.autoratingScAvailable(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	

	/**
	 * Handling repCustomer retrieving event<br>
	 * 79-08 Checking event <br>
	 * Checking AutoratingTaaAvailable validation 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse repCustomer(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try{
			String output_text = command.repCustomer(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex){
			throw ex;
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * Handling AutoratingTaaAvailable retrieving event<br>
	 * 79-08 Checking event <br>
	 * Checking AutoratingTaaAvailable validation 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse autoratingTaaAvailable(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try{
			String output_text = command.autoratingTaaAvailable(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex){
			throw ex;
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Handling existNoteButtonColor retrieving event<br>
	 * 79-08 Checking event <br>
	 * Changing note button color  
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existNoteButtonColor(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existNoteButtonColor(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * Handling existBlackListedCustomer retrieving event<br>
	 * 79-08 Checking event <br>
	 * Checking Per (Per cd) validation 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existBlackListedCustomer(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existBlackListedCustomer(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * Handling existPerCode retrieving event<br>
	 * 79-08 Checking event <br>
	 * Checking Per (Per cd) validation 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existPerCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existPerCode(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * Handling existCountryCode retrieving event<br>
	 * 79-08 Checking event <br>
	 * Checking Third (COUNTY cd) validation 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existCountryCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existCountryCode(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * Handling existThirdCode retrieving event<br>
	 * 79-08 Checking event <br>
	 * Checking Third (Offce cd) validation 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existThirdCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existThirdCode(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * Handling existPayerCode retrieving event<br>
	 * 79-08 Checking event <br>
	 * Checking Payer (custCntCd, custSeq) validation 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existPayerCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existPayerCode(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Handling searchMdmLocName retrieving event<br>
	 * Parameter value: LOC_CD code number ,return value: LOC_NM �뗢�땏unction 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmLocName(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchMdmLocName(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
		
	/**
	 * Handling searchBkgNoListByBkgNo retrieving event<br>
	 * Parameter value: BKG_NO,return values:OLD ,NEW BKG_NO number separator($) �뗢�땏unction
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgNoListByBkgNo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchBkgNoListByBkgNo(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Handling searchBlNoListByBlNo retrieving event<br>
	 * Parameter value: BL_NO,return values:OLD ,NEW BL_NO number separator($) �뗢�땏unction
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlNoListByBlNo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchBlNoListByBlNo(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Handling existChargeCode retrieving event<br>
	 * Function that checks existence of ChargeCode code number
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existChargeCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existChargeCode(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * Handling existCurrencyCode retrieving event<br>
	 * Function that checks existence of CurrencyCode code number
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existCurrencyCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existCurrencyCode(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	

	/**
	 * Handling retrieving event<br>
	 * Handling specific list retrieving event about BookingComboUtil <br>
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		try {
			String comboCd = event.getComboCd();

			List<BkgComboVO> list = command.searchCombo(comboCd);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Handling retrieving event<br>
	 * Handling specific list retrieving event about BookingComboUtil <br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgNoByBlNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		try {
			String blNo = "";
			String bkgStsCd = command.searchBkgNoByBlNo(blNo);
			eventResponse.setCustomData("bkg_sts_cd", bkgStsCd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Handling retrieving event<br>
	 * Handling specific list retrieving event about BookingUtil <br>
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgStatusByBkg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		
		try {
			String bkgStsCd = command.searchBkgStatusByBkg(event.getBkgBlNoVO());
			eventResponse.setCustomData("bkg_sts_cd", bkgStsCd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * Handling retrieving event<br>
     * Handling specific list retrieving event about BookingComboUtil <br>
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgNoSplitByBkg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		
		String bkgNo = event.getBkgNo();
		if (bkgNo == null || bkgNo.length() == 0) {
			log.info("Bkg No. can't be null!!! ");
			return eventResponse;
		}

		try {
			List<BkgComboVO> list = command.searchBkgNoSplitByBkg(bkgNo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse sendFaxEmailByBkgNoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		// EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		//
		// String bkgNo = event.getBkgNo();
		//
		// try{
		// List<BkgComboVO> list = command.searchBkgNoSplitByBkg(bkgNo);
		// eventResponse.setRsVoList(list);
		// }catch(EventException ex){
		// throw ex;
		// }catch(Exception ex){
		// throw new EventException(ex.getMessage(), ex);
		// }

		return eventResponse;
	}

	/**
	 * Handling retrieving event<br>
	 * Handling specific list retrieving event about BookingUtil <br>
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTypeSize(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0080Event event = (EsmBkg0080Event) e;

		BookingUtil command = new BookingUtil();
		try {
			List<MdmCntrTpSzVO> list = command.searchTypeSize(event.getMdmCntrTpSzVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			eventResponse.setRsVoList(list);

			return eventResponse;

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

	}


    /**
     * Retrieving list Return CY Inquiry
     * @param e Event 
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchYardCode (Event e) throws EventException {
    	EsmBkg0088Event event = (EsmBkg0088Event)e;
    	BookingUtil command = new BookingUtil();
    	MdmYardVO vo = event.getMdmYardVO();
    	try {
    		List <MdmYardVO> list = command.searchYardCode(vo);
        	GeneralEventResponse eventResponse = new GeneralEventResponse();
        	eventResponse.setRsVoList(list);
        	return eventResponse;
        	
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
     * Retrieving list MDM TABLE COMBO
     * @param e Event 
     * @return EventResponse
     * @throws EventException
     */
	@SuppressWarnings({ "unchecked" })
	private EventResponse seacrhMDMCombo (Event e) throws EventException {
    	EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
    	BookingUtil command = new BookingUtil();
    	try {
    		DBRowSet dbRowset  = command.seacrhMDMCombo(null,event.getComboCd());
        	GeneralEventResponse eventResponse = new GeneralEventResponse();
        	
        	if (event.getComboCd().equals("MDM0001")){
        		List<SearchSvcLaneBoundVO> list = null;
        		list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchSvcLaneBoundVO.class);
        		SearchSvcLaneBoundVO svo = new SearchSvcLaneBoundVO();
        		svo.setSkdDirCd("*");
        		svo.setVslSlanCd("*	*");
        	    svo.setVslSlanNm("All");
        	    list.add(0,svo);
        	    
        		eventResponse.setRsVoList(list);
    		}
        	
        	return eventResponse;
        	
    	} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
    	} catch (Exception ex){
    		throw new EventException(ex.getMessage(), ex);
		} 
    }

	/**
	 * Retrieving list Return Report Table,Column
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchReportItemList (Event e) throws EventException {
    	
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0895Event event = (EsmBkg0895Event)e;
    	
        String rptId 		= event.getRptId();
        String bkgRptKndCd 	= event.getBkgRptKndCd();
    	
    	BookingUtil command = new BookingUtil();
    	try {
    		List <ReportItemVO> list  = command.searchReportItemList(rptId, bkgRptKndCd);
    		List <ReportItemVO> list2 = command.searchTblColList(rptId, bkgRptKndCd);
        	
    		eventResponse.setRsVoList(list2);
        	eventResponse.setRsVoList(list);        	
        	return eventResponse;
        	
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

	/**
	 * Checking whether port usa, canada stops
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchFrob(Event e) throws EventException {
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		
		try {
			String frob = command.searchFrob(event.getBkgNo(), event.getBkgTrunkVvd(), event.getPolCd(), event.getPodCd());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("frobCode", frob);
			return eventResponse;

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Checking Rfa NO validation
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRfaAvailable(Event e) throws EventException {
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		try {
			String rfaAvailable = "Y";
			if (!command.searchRfaAvailable(event.getRfaNo(), event.getBkgBlNoVO())) {
				rfaAvailable = "N";
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("rfa_available", rfaAvailable);
			return eventResponse;

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Checking Sc NO validation
	 * 
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchScAvailable(Event e) throws EventException {
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		try {
			String scAvailable = "Y";
			if (!command.searchScAvailable(event.getScNo(), event.getBkgBlNoVO())) {
				scAvailable = "N";
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("sc_available", scAvailable);
			return eventResponse;

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	/**
	 * Checking Taa NO validation
	 * 
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTaaAvailable(Event e) throws EventException {
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		try {
			String taaAvailable = "Y";
			if (!command.searchTaaAvailable(event.getTaaNo(), event.getBkgBlNoVO())) {
				taaAvailable = "N";
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("taa_available", taaAvailable);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
     * Testing PROCEDURE
     * @param e Event 
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse exeProcedureTest (Event e) throws EventException {
    	try {
    		BookingProcessMgtBC bc = new BookingProcessMgtBCImpl();
    		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
			
			//List<BkgVvdBdrLogVO> vos     = new ArrayList<BkgVvdBdrLogVO>();
			//BkgVvdBdrLogVO[] bkgVvdBdrLogVOs = null;
			
			/*BkgVvdBdrLogVO vo = new BkgVvdBdrLogVO();
			
			vo.setSkdVoyNo("0011");
			vo.setSkdDirCd("W");
			vo.setIbflag("N");
			vo.setVpsPortCd("CNNBO");
			vo.setPortSkdStsCd("D");
			vo.setClptIndSeq("1");*/
			BkgVvdBdrLogVO vo = event.getBkgVvdBdrLogVO();
			//vos.add(vo);
			begin();
			vo = bc.manageBKGBDRLOG(vo,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			//eventResponse.setETCData(vo.getColumnValues());
			if (vo.getOResult().equals("S")){
				commit();
			}else{ 
				rollback();
			}
			eventResponse.setETCData("o_result",vo.getOResult());
			eventResponse.setETCData("o_err_msg",vo.getOErrMsg());
			
			return eventResponse;
			
    	} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		}
    }
    /**
     * Executing Sql in case of receiving input from ESM_Booking_Util_01 screen.<br>
     * @param e Event 
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse executeQuery (Event e) throws EventException {
    	EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			
			String result =  command.executeQuery(event.getSql());
			eventResponse.setETCData("result", result);
			
			commit();
			

		} catch (EventException ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		} 
		return eventResponse;
    }
    

	/**
	 * Handling seacrhDocPerformanceUserCheck retrieving event<br>
	 * Checking event <br>
	 * Checking value DocPerformance User <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse seacrhDocPerformanceUserCheck(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
//		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.seacrhDocPerformanceUserCheck(account.getUsr_id());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ANCS Main Menu 愿��젴 ESM_BKG_0044,0494,0965,0970 �솕硫댁쓽 POD議고쉶<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsHardCodingList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			List<BkgCstmsHrdCdgCtntVO> list = command.searchCstmsHardCodingList(event.getBkgCstmsHrdCdgCtntVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchMdmEurFlg(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String eurFlg = command.searchMdmEurFlg(event.getOfcCd());
			eventResponse.setETCData("eur_flg", eurFlg);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
     * Reactivate Cancel BKG
     * @param e Event 
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse reactivateBooking (Event e) throws EventException {
    	try {
    		EsmBookingUtilEvent event 			= (EsmBookingUtilEvent) e;
			GeneralEventResponse eventResponse 	= new GeneralEventResponse();
    		GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
    		BLDocumentationCMBC blDocCmBC 		= new BLDocumentationCMBCImpl();
    		BkgCopManageBC 			copBC		= new BkgCopManageBCImpl();
    		CostAssignBC coaBc 					= new CostAssignBCImpl();	
    		BookingARCreationBC invBc 			= new BookingARCreationBCImpl();
			BookingHistoryMgtBC historyBC 		= new BookingHistoryMgtBCImpl();	
    		BookingUtil command 				= new BookingUtil();
    		BkgBlNoVO bkgBlNoVO 				= new BkgBlNoVO();
			CoaBkgComIfVO coaBkgComIfVo 		= new CoaBkgComIfVO();
			ARBkgInterfaceCreationVO bkgIfVo 	= new ARBkgInterfaceCreationVO();
			String bkgNo = event.getBkgNo();
			log.debug("reactivateBooking:"+bkgNo);    		
    		bkgBlNoVO.setBkgNo(bkgNo);
    		bkgBlNoVO = command.searchBkgBlNoVO(bkgBlNoVO);

    		//Activate Container 
    		blDocCmBC.activateBkgCntr(bkgBlNoVO, account);
    		//COP replan
    		copBC.reviveCopsByBkgRqst(bkgNo);
    		//BKG status change
    		receiptBC.reactBkgStatus(bkgNo);
//    		receiptBC.compFirm(bkgBlNoVO, account);
    		receiptBC.changeBkgStatus("F", bkgBlNoVO, false, account);
			//COA I/F
			coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			coaBkgComIfVo.setCostSrcSysCd("BKG");
			coaBkgComIfVo.setIfRmk("reactivate");
			coaBkgComIfVo.setCreUsrId(account.getUsr_id());
			coaBkgComIfVo.setUpdUsrId(account.getUsr_id());			
			coaBc.modifyCoaCommonInterface(coaBkgComIfVo);
			//INV I/F
			bkgIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			bkgIfVo.setBkgCorrNo(bkgBlNoVO.getCaNo());
			bkgIfVo.setUserId(account.getUsr_id());
			bkgIfVo.setManDivInd("B");
			invBc.interfaceBKGARInvoiceToINV(bkgIfVo);
			//History 異붽�			
			HistoryLineVO historyLineVO = new HistoryLineVO();
			historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
			historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
			historyLineVO.setBkgDocProcTpCd("BREACT");// booking firm for doc performance
			historyLineVO.setUiId("ESM_BKG_0079_01");
			historyLineVO.setCrntCtnt("Reactivate.");
			historyLineVO.setHisCateNm("Reactivate."); 
			historyBC.createBkgHistoryLine(historyLineVO, account);

			eventResponse.setETCData("isSuccess","Y");
			return eventResponse;
			
    	} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		}
    }
    /**
	 * ESM_BKG_1063 : Batch<br>
	 *  <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */    
    private GeneralEventResponse executeBatch(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
		
        try {
        	        	
            begin();
            String jobId = command.executeBatch("ESM_BKG_B910","");
            eventResponse.setETCData("JOB_ID", jobId);
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

        return eventResponse;
    }
    
    /**
     * 
     * @param e
     * @return
     * @throws EventException
     */
    private GeneralEventResponse checkCntrTpszCd(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
        try {
        	String cntrTpszCd = event.getCntrTpszCd();
            String count = command.checkCntrTpszCd(cntrTpszCd);
            eventResponse.setETCData("count", count);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
        return eventResponse;
    }
    
    /**
     * 
     * @param e
     * @return
     * @throws EventException
     */
    private GeneralEventResponse searchSoStatus(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
        try {
        	if("Y".equals(command.searchSoStatus("", "", event.getBkgBlNoVO(), ""))){
				throw new EventException((String)new ErrorHandler("BKG00094").getMessage());								
			}
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
        return eventResponse;
    }
    
    /**
     * 
     * @param e
     * @return
     * @throws EventException
     */
    private GeneralEventResponse searchUserPgmRoleMach(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
        try {
        	eventResponse.setETCData("CNT", String.valueOf(command.searchUserPgmRoleMach(event.getPgmNo(), account.getUsr_id())));
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
        return eventResponse;
    }
    
    
    
    
//    /**
//	 * ESM_BKG_1063 : Batch Monitor <br>
//	 *  <br>
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */    
//    private GeneralEventResponse monitorPickupSetting(Event e) throws EventException{
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        EsmBookingUtilEvent event = (EsmBookingUtilEvent)e;
//        BookingUtil command = new BookingUtil();
//		
//        try {
//        	        	
//            String jobStatus = command.getBatchStatus(event.getJobId(), "ESM_BKG_B910");
//            eventResponse.setETCData("BATCH_STATUS", jobStatus);
//
//		}catch(EventException ex){
//			log.error("err " + ex.toString(), ex);
//			throw ex;
//		}catch(Exception ex){
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
//		}
//
//        return eventResponse;
//    }
    
	/**
	 * Retrieve MDM_CHAGRE TAX_FLG<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchChgTaxFlg(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			MdmChgTaxFlgVO mdmChgTaxFlgVO = command.searchChgTaxFlg(event.getChgCd());
			if(mdmChgTaxFlgVO.getTaxFlg() == null){
				eventResponse.setETCData("tax_flg", "");
				eventResponse.setETCData("tax_cnt_cd", "");
				eventResponse.setETCData("exist_flg", "N");
			}else{
				eventResponse.setETCData("tax_flg", mdmChgTaxFlgVO.getTaxFlg());
				eventResponse.setETCData("tax_cnt_cd", mdmChgTaxFlgVO.getTaxCntCd());
				eventResponse.setETCData("exist_flg", "Y");
			}
			
//			if(mdmChgTaxFlgVO == null){
//			}else{
//			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * currency에 대한 소숫점 자릿수를 조회한다.<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchDpPrcsKntByCur(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			MdmCurrencyVO mdmCurrencyVO = command.searchDpPrcsKntByCur(event.getCurrCd());
			if(mdmCurrencyVO.getCurrCd() == null){
				eventResponse.setETCData("dp_prcs_knt", "");
				eventResponse.setETCData("exist_curr_cd", "N");
			}else{
				eventResponse.setETCData("dp_prcs_knt", mdmCurrencyVO.getDpPrcsKnt());
				eventResponse.setETCData("exist_curr_cd", "Y");
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	/**
	 * LOGIN USER, OFFICE의 HTML5 RD 사용여부 체크<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkHtml5RDPass(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
//		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			eventResponse.setETCData("IS_HTML5_RD", command.checkHtml5RDPass(account));	//"Y": ESM_BKG_0743.jsp(html5), "N": ESM_BKG_0743_T.jsp(plungin)
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchVslNm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			eventResponse.setETCData("VSL_ENG_NM", command.searchVslNm(event.getVvd()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchLocationNm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			eventResponse.setETCData("LOC_NM", command.searchLocationNm(event.getLocCd()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchLocCdByOfcCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			eventResponse.setETCData("LOC_CD", command.searchLocCdByOfcCd(event.getOfcCd()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}		
}
