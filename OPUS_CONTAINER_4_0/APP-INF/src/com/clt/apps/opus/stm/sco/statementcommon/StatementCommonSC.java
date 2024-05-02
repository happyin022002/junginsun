/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : StatementCommonSC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.03.03 authorName
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon;


import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBC;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBCImpl;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0010Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0020Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0050Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0051Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0052Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0053Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0054Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0055Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0056Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0060Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0090Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0100Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0200Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0300Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0400Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0410Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0420Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0500Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco9999Event;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmScoCommonEvent;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration.StatementCommonDBDAO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.APCostActivityInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.AccrualCodeInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.AccrualVerificationVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ApplicationComboVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.CenterListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.CompanyListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.InterCompanyListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LedgerCodeCombinationListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupDetailVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupHeaderVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfcWrtfTpComboListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfficeComboListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfficeInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.PopAccountListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.RegionListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.RevenuePortEachLaneVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SakuraConversionComboVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SakuraInterfaceListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ScoStmtCdConvVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SearchPeriodClosingInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SearchTrsTesAcclDataVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.TesManualCancellationVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.VVDListVO;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * StatementCommon Business Logic ServiceCommand 
 * - Handling StatementCommon Business transaction.
 * 
 * @author 
 * @see StatementCommonDBDAO
 * @since J2EE 1.6
 */ 
public class StatementCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;  

	/**
	 * Precede StatementCommon system <br>
	 *  Create Object when STM_SCO job call<br>
	 */
	public void doStart() {
		try {
			//Checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

		}
	}

	/**
	 * Follow StatementCommon system<br>
	 * Release Object when STM_SCO job end<br>
	 */
	public void doEnd() {
		log.debug("StatementCommonSC END");
	}

	/**
	 * proceeding job each Even<br>
	 *  Handling every Event on  StatementCommon system<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
				
		if (e.getEventName().equalsIgnoreCase("StmScoCommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchLookupComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchAcctCtnt2LookupComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchAcctCtnt3LookupComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchAcctCtnt4LookupComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = searchInvArOfc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {
				eventResponse = searchEvidenceLookupComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)) {
				eventResponse = searchLookupComboListWithChkStartEndDate(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND08)) {
				eventResponse = searchLocalSysdate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSco0010Event")) {// by yhha								
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {  
				eventResponse = condPeriodCloseAppl(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePeriodClosingInfo(e);
			}		
		}  else if (e.getEventName().equalsIgnoreCase("StmSco0020Event")) {			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {  
				eventResponse = searchLookupHeader(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {  
				eventResponse = searchLookupDetail(e);  
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageLookupHeader(e);						
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchApplicationCombo(e);						
			}
		}  else if (e.getEventName().equalsIgnoreCase("StmSco0050Event")) {				
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  
				eventResponse = searchLedgerCodeCombination(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {						
				eventResponse = manageLedgerCodeCombination(e);						
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {						
				eventResponse = manageLedgerCodeCombinationBiz(e);						
			}
		}  else if (e.getEventName().equalsIgnoreCase("StmSco0100Event")) {				
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  
				eventResponse = searchOfficeInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { 
				eventResponse = searchOfficeComboList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {						
				eventResponse = manageOfficeInfo(e);						
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { 
				eventResponse = searchBankOfficeComboList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { 
				eventResponse = searchOfcWrtfTpComboList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { 
				eventResponse = searchOfcAdjustTpComboList(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("StmSco0051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopCompanyList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSco0052Event")) {		
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	
				eventResponse = searchPopRegionList(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("StmSco0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopCenterList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSco0054Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopAccountList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSco0055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopInterCompanyList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSco0056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopVVDList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSco0090Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopAccountCommonList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSco0200Event")) {				
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  
				eventResponse = searchAPCostActivityInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {						
				eventResponse = manageAPCostActivityInfo(e);						
			} 
		} else if (e.getEventName().equalsIgnoreCase("StmSco0300Event")) {				
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {  
				eventResponse = searchSakuraConversionCombo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  
				eventResponse = searchSakuraConversionInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {						
				eventResponse = manageSakuraConversionInfo(e);						
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSco0060Event")) {				
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  
				eventResponse = searchRevenuePortEachLaneList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {						
				eventResponse = manageRevenuePortEachLaneList(e);						
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {						
				eventResponse = searchRevenuePort(e);						
			} 
		}  else if (e.getEventName().equalsIgnoreCase("StmSco0400Event")) {				
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  
				eventResponse = searchTesMenualCancellation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {						
				eventResponse = cancelTesMenualCancellation(e);						
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {						
				eventResponse = searchYardName(e);						
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSco9999Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	//EXECUTE  
				eventResponse = executePgm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {	//REFRESH					
				eventResponse = searchAcclJobStatus(e);						
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND13)) {	//DownLoad					
				eventResponse = manageAcclDataDownLoad(e);						
			} 
			
		}else if (e.getEventName().equalsIgnoreCase("StmSco0500Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSakuraInterfaceList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("StmSco0410Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //backendjob start
				eventResponse = searchMonthlyAccrualVerificationBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//backendjob status	
				eventResponse = searchComBakEndJobStatus(e);					
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//backendjob result	
				eventResponse = searchComBackEndJobResult(e);					
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	//combo code : trade, account
				eventResponse = searchMonthlyTesTrsAccrualCodeList(e);					
			}
		}else if (e.getEventName().equalsIgnoreCase("StmSco0420Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //backendjob start
				eventResponse = searchMonthlyAccrualVerificationBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//backendjob status	
				eventResponse = searchComBakEndJobStatus(e);					
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//backendjob result	
				eventResponse = searchComBackEndJobResult(e);					
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	//combo code : trade, account
				eventResponse = searchMonthlyCostAccrualCodeList(e);					
			}
		}

		return eventResponse;		
	}


	/**
	 * [common] lookup detail retrieve<br>
	 * lookup detail retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLookupComboList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmScoCommonEvent event = (StmScoCommonEvent)e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{
			List<LookupInfoVO> list = command.searchLookupComboList(event.getLookupInfoVO());
			
			StringBuffer code = new StringBuffer("");
			StringBuffer combo_code = new StringBuffer("");
			StringBuffer combo_nm = new StringBuffer("");
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("one_lu_cd", list.get(0).getLuCd());
				eventResponse.setETCData("one_lu_desc", list.get(0).getLuDesc());
				
				for (int i = 0 ; i < list.size() ; i++) {
					
					code.append(list.get(i).getLuCd()).append("=")
					    .append(list.get(i).getLuDesc()).append("=")
					    .append(list.get(i).getAttrCtnt1()).append("=")
					    .append(list.get(i).getAttrCtnt2()).append("=")
					    .append(list.get(i).getAttrCtnt3()).append("=")
					    .append(list.get(i).getAttrCtnt4()).append("=")
					    .append(list.get(i).getAttrCtnt5())
					    ;
					
					if (i < list.size() - 1)	code.append("|");
					
					combo_code.append("|").append(list.get(i).getLuCd());
					combo_nm.append("|").append(list.get(i).getLuCd()).append("\t").append(list.get(i).getLuDesc());
				}
				
				eventResponse.setETCData("combo_code", combo_code.toString());
				eventResponse.setETCData("combo_nm", combo_nm.toString());
				
			} else {
				eventResponse.setETCData("one_lu_cd", "NO_DATA");
				eventResponse.setETCData("one_lu_desc", "NO_DATA");
			}
			
			eventResponse.setETCData("lu_cd_list", code.toString());
			if (list != null){
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * [common] lookup detail retrieve<br>
	 * lookup detail retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEvidenceLookupComboList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmScoCommonEvent event = (StmScoCommonEvent)e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{
			//log.debug("AAAAA:"+ event.getLookupInfoVO());
			List<LookupInfoVO> list = command.searchEvidenceLookupComboList(event.getLookupInfoVO());
			
			StringBuffer code = new StringBuffer("");
			StringBuffer combo_code = new StringBuffer("");
			StringBuffer combo_nm = new StringBuffer("");
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("one_lu_cd", list.get(0).getLuCd());
				eventResponse.setETCData("one_lu_desc", list.get(0).getLuDesc());
				
				for (int i = 0 ; i < list.size() ; i++) {
					
					code.append(list.get(i).getLuCd()).append("=")
					    .append(list.get(i).getLuDesc()).append("=")
					    .append(list.get(i).getAttrCtnt1()).append("=")
					    .append(list.get(i).getAttrCtnt2()).append("=")
					    .append(list.get(i).getAttrCtnt3()).append("=")
					    .append(list.get(i).getAttrCtnt4()).append("=")
					    .append(list.get(i).getAttrCtnt5())
					    ;
					
					if (i < list.size() - 1)	code.append("|");
					
					combo_code.append("|").append(list.get(i).getLuCd());
					combo_nm.append("|").append(list.get(i).getLuCd()).append("\t").append(list.get(i).getLuDesc());
				}
				
				eventResponse.setETCData("combo_code", combo_code.toString());
				eventResponse.setETCData("combo_nm", combo_nm.toString());
				
			} else {
				eventResponse.setETCData("one_lu_cd", "NO_DATA");
				eventResponse.setETCData("one_lu_desc", "NO_DATA");
			}
			
			eventResponse.setETCData("lu_cd_list", code.toString());
			if (list != null){
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [common] Period Closing
	 * Period Closing retrieve<br>
	 * by yhha 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse condPeriodCloseAppl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0010Event event = (StmSco0010Event)e;
		StatementCommonBC command = new StatementCommonBCImpl();
		try{ 
			List<SearchPeriodClosingInfoVO> list = command.searchPeriodClosingList(event.getEffYrMon(), event.getPrdApplCd());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}	
		return eventResponse;
	}		
	
	/**
	 * [common] Period Closing save<br>
	 * by yhha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePeriodClosingInfo (Event e) throws EventException { 
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0010Event event = (StmSco0010Event)e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{
			begin();
			List<String> runninglist = command.searchZeroBalanceRunningList();
		    	
			SearchPeriodClosingInfoVO[] searchPeriodClosingInfoVO = event.getSearchPeriodClosingInfoVOs();
			for (int i = 0; i < searchPeriodClosingInfoVO.length; i++) {
				if (searchPeriodClosingInfoVO[i].getIbflag().equals("I") || searchPeriodClosingInfoVO[i].getIbflag().equals("U")) {
					if(searchPeriodClosingInfoVO[i].getPrdStsCd().equals("C") && searchPeriodClosingInfoVO[i].getPrdApplCd().equals("AR")){
						for (int j = 0; j < runninglist.size(); j++) {
							if(searchPeriodClosingInfoVO[i].getEffYrmon().equals(runninglist.get(j))){
								throw new EventException(new ErrorHandler("SAR00063",new String[]{runninglist.get(j)}).getMessage());
							}
						}
					}
				}
			}
			
			command.managePeriodClosingInfo(event.getSearchPeriodClosingInfoVOs(),account);			            
			commit();
			
		} catch(EventException ex) { 
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * [common] lookup detail retrieve<br>
	 * lookup header retrieve<br>
	 * by HJPARK 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLookupHeader(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0020Event event = (StmSco0020Event)e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{ 
			List<LookupHeaderVO> list = command.searchLookupHeader(event.getLuTpCd(), event.getLuApplCd());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * [common] lookup detail retrieve<br>
	 * lookup detail retrieve<br>
	 * by HJPARK 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLookupDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0020Event event = (StmSco0020Event)e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{
			List<LookupDetailVO> list = command.searchLookupDetail(event.getHluTpCd());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * [common] lookup detail save<br>
	 * lookup header save<br>
	 * by HJPARK
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLookupHeader (Event e) throws EventException { 
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0020Event event = (StmSco0020Event)e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{
			begin();
			command.manageLookupHeader(event.getLookupHeaderVOs(),account);	
			if ( event.getLookupDetailVOs() != null && event.getLookupDetailVOs().length > 0 ) {
				command.manageLookupDetail(event.getLookupDetailVOs(),account);	
			}            
			commit();
			
		} catch(EventException ex) { 
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * Search Application Combo List<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApplicationCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//StmSco0020Event event = (StmSco0020Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ApplicationComboVO> list = command.searchApplicationCombo();
			
			if(list.size() > 0){
				eventResponse.setETCData(list.get(0).getColumnValues());
			}else{
				eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());
			}
			
			StringBuffer applCd = new StringBuffer("");
			
			for (int i = 0; i < list.size(); i++) {
				applCd.append("|").append(list.get(i).getApplCd());
			}
			
			eventResponse.setETCData("appl_cd_list", applCd.toString());
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Search Office Combo List<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeComboList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//StmSco0100Event event = (StmSco0100Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<OfficeComboListVO> list = command.searchOfficeComboList();
			
			if(list.size() > 0){
				eventResponse.setETCData(list.get(0).getColumnValues());
			}else{
				eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());
			}
			
			StringBuffer ofcCd = new StringBuffer("");
			for (int i = 0; i < list.size(); i++) {
				ofcCd.append("|").append(list.get(i).getOfcCd()).append("^").append(list.get(i).getArHdQtrOfcCd());
			}
			
			StringBuffer sheetOfcCd = new StringBuffer("");
			StringBuffer sheetOfcRhq = new StringBuffer("");
			for (int i = 0; i < list.size(); i++) {
				sheetOfcCd.append("|").append(list.get(i).getOfcCd());
				sheetOfcRhq.append("|").append(list.get(i).getOfcCd()).append("\t").append(list.get(i).getArHdQtrOfcCd());
			}
			eventResponse.setETCData("ofc_cd_list", ofcCd.toString());
			eventResponse.setETCData("sheet_ofc_cd_list", sheetOfcCd.toString());
			eventResponse.setETCData("sheet_ofc_cd_list2", sheetOfcRhq.toString()); 
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [common] Office Info retrieve<br>
	 * Office Info retrieve<br>
	 * by HJPARK 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0100Event event = (StmSco0100Event)e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{ 
			List<OfficeInfoVO> list = command.searchOfficeInfo(event.getMdmOfcCd());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * [common] STM Office save<br>
	 * STM Office save<br>
	 * by HJPARK
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOfficeInfo (Event e) throws EventException { 
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0100Event event = (StmSco0100Event)e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{
			begin();
			if ( event.getOfficeInfoVOs() != null && event.getOfficeInfoVOs().length > 0 ) {
				command.manageOfficeInfo(event.getOfficeInfoVOs(),account);	
			}            
			commit();
			
		} catch(EventException ex) { 
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }	
		return eventResponse;
	}	

	/**
	 * Retrieve Company Popup<br>
	 * 
	 * @author MCJung 2014.04.03 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopCompanyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// ?遺얇늺�귐뗪쉘??����
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSco0051Event event = (StmSco0051Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();
		
		
		try {
			
			List<CompanyListVO> list = command.searchPopCompanyList(event.getLu_cd());
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("lu_cd",          list.get(0).getLuCd());
				eventResponse.setETCData("lu_desc",        list.get(0).getLuDesc());
			} else {
				eventResponse.setETCData("lu_cd",          "NO_DATA");
				eventResponse.setETCData("lu_desc",        "NO_DATA");
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**			
	 * Region Popup - Retrieve<br> 			
	 * 			
     * @category STM_SCO_0052				
	 * @author CYJ			
	 * @param Event e			
	 * @return EventResponse			
	 * @exception EventException			
	*/			
	private EventResponse searchPopRegionList(Event e) throws EventException {			
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
				
		StmSco0052Event event = (StmSco0052Event) e;		
		StatementCommonBC command = new StatementCommonBCImpl();	
				
		try {		
			List<RegionListVO> list = command.searchPopRegionList(event.getLuCd());	 
			eventResponse.setRsVoList(list);	
		} catch (EventException ex) {		
			throw ex;	
		} catch (Exception ex) {		
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		}		
		return eventResponse;		
	}
	
	/**
	 * Retrieve Center Popup<br>
	 * Center Popup event<br>
	 * @author JKKil
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopCenterList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		StmSco0053Event event = (StmSco0053Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();	

		try {
			List<CenterListVO> list = command.searchPopCenterListVO(event.getCenterListVO());
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("ctr_erp_no",  list.get(0).getCtrErpNo());
				eventResponse.setETCData("ctr_desc", list.get(0).getCtrDesc());				
			} else {
				eventResponse.setETCData("ctr_erp_no", "NO_DATA");
				eventResponse.setETCData("ctr_desc", "NO_DATA");
			}			
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * Retrieve Acount popup event<br>
	 * 
	 * @author MCJung 2014.04.01 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopAccountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// ?遺얇늺�귐뗪쉘??����
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		
		StmSco0054Event event = (StmSco0054Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();	

		try {
			
			List<PopAccountListVO> list = command.searchPopAccountList(event.getAcct_cd(),event.getAcctg_mng_tp_cd(), event.getPnd_tgt_flg());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * Retrieve Inter Company Popup<br>
	 * Inter Company Popup event<br>
	 * @author JKKil
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopInterCompanyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		StmSco0055Event event = (StmSco0055Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();	

		try {
			List<InterCompanyListVO> list = command.searchPopInterCompanyListVO(event.getInterCompanyListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * Retrieve VVD Popup<br>
	 * VVD Popup List retrieve<br> * 
	 * @author JISONG
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopVVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSco0056Event event = (StmSco0056Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();	

		try {
			List<VVDListVO> list = command.searchPopVVDList(event.getVvdCd());
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("vvd_cd",          list.get(0).getVvdCd());
				eventResponse.setETCData("vvd_desc",        list.get(0).getVvdDesc());
			} else {
				eventResponse.setETCData("vvd_cd",          "NO_DATA");
				eventResponse.setETCData("vvd_desc",        "NO_DATA");
			}
		
			if ( list != null){
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	} 
	
	/**
	 * Search Ledger Code Combination List <br>
	 * 
	 * @author HeeJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLedgerCodeCombination(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSco0050Event event = (StmSco0050Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<LedgerCodeCombinationListVO> ledgerCodeCombinationListVO = command.searchLedgerCodeCombination(event.getLedgerCodeCombinationCondVO());
			eventResponse.setRsVoList(ledgerCodeCombinationListVO);			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
	/**
	 * [STM_SCO_0050]<br>
	 * manageLedgerCodeCombination<br>
	 * ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLedgerCodeCombination(Event e) throws EventException { 
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0050Event event = (StmSco0050Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{
			begin();
			command.manageLedgerCodeCombination(event.getLedgerCodeCombinationListVOs(),account);	
			commit();
		} catch(EventException ex) { 
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	
	/**
	 * [STM_SCO_0050]<br>
	 * manageLedgerCodeCombinationBiz<br>
	 * ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLedgerCodeCombinationBiz(Event e) throws EventException { 
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0050Event event = (StmSco0050Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{
			begin();
			String[] rtnValue = command.manageLedgerCodeCombinationBiz(event.getLedgerCodeCombinationListVO(),account.getUsr_id());	
			eventResponse.setETCData("COA_MSG",          rtnValue[0]);
			eventResponse.setETCData("COA_KEY",          rtnValue[1]);
			commit();
		} catch(EventException ex) { 
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }	
		return eventResponse;
	}	
	
	/**
	 * Search Bank Office Combo List<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBankOfficeComboList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSco0100Event event = (StmSco0100Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<OfficeComboListVO> list = command.searchBankOfficeComboList(event.getMdmOfcCd(), event.getOfcEntrLvlCd());
			
			if(list.size() > 0){
				eventResponse.setETCData(list.get(0).getColumnValues());
			}else{
				eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());
			}
			
			
			StringBuffer bankOfcCd = new StringBuffer("");
			
			for (int i = 0; i < list.size(); i++) {
				bankOfcCd.append("^").append(list.get(i).getOfcCd());
			}
			
			eventResponse.setETCData("bank_ofc_cd_list", bankOfcCd.toString());
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [STM_SCO_0050]<br>
	 * searchOfcWrtfTpComboList<br>
	 * ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcWrtfTpComboList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//StmSco0100Event event = (StmSco0100Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<OfcWrtfTpComboListVO> list = command.searchOfcWrtfTpComboList();
			
			if(list.size() > 0){
				eventResponse.setETCData(list.get(0).getColumnValues());
			}else{
				eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());
			}

			StringBuffer ofcWrtfTp = new StringBuffer("");
			
			for (int i = 0; i < list.size(); i++) {
				ofcWrtfTp.append("|").append(list.get(i).getAcctTpCd()).append("^").append(list.get(i).getLuDesc());
			}
			
			eventResponse.setETCData("ofc_wrtf_tp_list", ofcWrtfTp.toString());
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * searchAPCostActivityInfoList <br>
	 * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAPCostActivityInfoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSco0200Event event = (StmSco0200Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<APCostActivityInfoVO> aPCostActivityInfoVOList = command.searchAPCostActivityInfoList(event.getSrcMdlCd().trim(), event.getActCostCd(), event.getDelFlg());
			eventResponse.setRsVoList(aPCostActivityInfoVOList);			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve account information(s) event<br>
	 * 
	 * @author Kyungsam Jo 2015.03.17 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopAccountCommonList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// �붾㈃由ы꽩��遺�텇
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0090Event event = (StmSco0090Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try {
			
			List<PopAccountListVO> list = command.searchPopAccountCommonList(event.getAcct_cd(),event.getAcctg_mng_tp_cd(), event.getPnd_tgt_flg(), event.getLine_type(), event.getAcct_eng_nm());
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("acct_cd", list.get(0).getAcctCd());
			} else {
				eventResponse.setETCData("acct_cd", "NO_DATA");
			}
			if (list != null){
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [STM_SCO_0200]<br>
	 * manageLedgerCodeCombination<br>
	 * ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAPCostActivityInfo(Event e) throws EventException { 
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0200Event event = (StmSco0200Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{
			begin();
			command.manageAPCostActivityInfo(event.getAPCostActivityInfoVOs(),account);	
			commit();
		} catch(EventException ex) { 
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }	
		return eventResponse;
	}	
	
	/**
	 * SAKURA Code Conversion Combo List<br>
	 * 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSakuraConversionCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//StmSco0300Event event = (StmSco0300Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();		
		try {
			List<SakuraConversionComboVO> list = command.searchSakuraConversionCombo();
			
			if(list.size() > 0){
				eventResponse.setETCData(list.get(0).getColumnValues());
			}else{
				eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());
			}
			
			StringBuffer sakuraConvCd = new StringBuffer("");

			for (int i = 0; i < list.size(); i++) {
				sakuraConvCd.append("|").append(list.get(i).getLuTpCd()).append("^").append(list.get(i).getLuDesc());
			}
			eventResponse.setETCData("sabura_conv_cd", sakuraConvCd.toString());
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SCO_0300]
	 * SAKURA Code Conversion - retrieve<br> 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
    private EventResponse searchSakuraConversionInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSco0300Event event = (StmSco0300Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();
		try {
			List<ScoStmtCdConvVO> list = command.searchSakuraConversionInfo(event.getLuTpCd(), event.getEnblFlg());
			
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
    
	/**
	 * [STM_SCO_0300]
	 * SAKURA Code Conversion - save<br> 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse manageSakuraConversionInfo(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    StmSco0300Event event = (StmSco0300Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();
		
		try{
			begin();
			if (event.getScoStmtCdConvVOs() != null ) { 
				command.manageSakuraConversionInfo(event.getScoStmtCdConvVOs(), account.getUsr_id());
			}
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [common] lookup detail retrieve<br>
	 * lookup detail retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAcctCtnt2LookupComboList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmScoCommonEvent event = (StmScoCommonEvent)e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{
			List<LookupInfoVO> list = command.searchAcctCtnt2LookupComboList(event.getLookupInfoVO());
			
			StringBuffer code = new StringBuffer("");
			StringBuffer combo_code = new StringBuffer("");
			StringBuffer combo_nm = new StringBuffer("");
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("one_lu_cd", list.get(0).getLuCd());
				eventResponse.setETCData("one_lu_desc", list.get(0).getLuDesc());
				
				for (int i = 0 ; i < list.size() ; i++) {
					
					code.append(list.get(i).getLuCd()).append("=")
					    .append(list.get(i).getLuDesc()).append("=")
					    .append(list.get(i).getAttrCtnt1()).append("=")
					    .append(list.get(i).getAttrCtnt2()).append("=")
					    .append(list.get(i).getAttrCtnt3()).append("=")
					    .append(list.get(i).getAttrCtnt4()).append("=")
					    .append(list.get(i).getAttrCtnt5())
					    ;
					
					if (i < list.size() - 1)	code.append("|");
					
					combo_code.append("|").append(list.get(i).getLuCd());
					combo_nm.append("|").append(list.get(i).getLuCd()).append("\t").append(list.get(i).getLuDesc());
				}
				
				eventResponse.setETCData("combo_code", combo_code.toString());
				eventResponse.setETCData("combo_nm", combo_nm.toString());
				
			} else {
				eventResponse.setETCData("one_lu_cd", "NO_DATA");
				eventResponse.setETCData("one_lu_desc", "NO_DATA");
			}
			
			eventResponse.setETCData("lu_cd_list", code.toString());
			if (list != null){
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [common] lookup detail retrieve<br>
	 * lookup detail retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAcctCtnt3LookupComboList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmScoCommonEvent event = (StmScoCommonEvent)e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{
			List<LookupInfoVO> list = command.searchAcctCtnt3LookupComboList(event.getLookupInfoVO());
			
			StringBuffer code = new StringBuffer("");
			StringBuffer combo_code = new StringBuffer("");
			StringBuffer combo_nm = new StringBuffer("");
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("one_lu_cd", list.get(0).getLuCd());
				eventResponse.setETCData("one_lu_desc", list.get(0).getLuDesc());
				
				for (int i = 0 ; i < list.size() ; i++) {
					
					code.append(list.get(i).getLuCd()).append("=")
					    .append(list.get(i).getLuDesc()).append("=")
					    .append(list.get(i).getAttrCtnt1()).append("=")
					    .append(list.get(i).getAttrCtnt2()).append("=")
					    .append(list.get(i).getAttrCtnt3()).append("=")
					    .append(list.get(i).getAttrCtnt4()).append("=")
					    .append(list.get(i).getAttrCtnt5())
					    ;
					
					if (i < list.size() - 1)	code.append("|");
					
					combo_code.append("|").append(list.get(i).getLuCd());
					combo_nm.append("|").append(list.get(i).getLuCd()).append("\t").append(list.get(i).getLuDesc());
				}
				
				eventResponse.setETCData("combo_code", combo_code.toString());
				eventResponse.setETCData("combo_nm", combo_nm.toString());
				
			} else {
				eventResponse.setETCData("one_lu_cd", "NO_DATA");
				eventResponse.setETCData("one_lu_desc", "NO_DATA");
			}
			
			eventResponse.setETCData("lu_cd_list", code.toString());
			if (list != null){
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [common] lookup detail retrieve<br>
	 * lookup detail retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAcctCtnt4LookupComboList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmScoCommonEvent event = (StmScoCommonEvent)e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{
			List<LookupInfoVO> list = command.searchAcctCtnt4LookupComboList(event.getLookupInfoVO());
			
			StringBuffer code = new StringBuffer("");
			StringBuffer combo_code = new StringBuffer("");
			StringBuffer combo_nm = new StringBuffer("");
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("one_lu_cd", list.get(0).getLuCd());
				eventResponse.setETCData("one_lu_desc", list.get(0).getLuDesc());
				
				for (int i = 0 ; i < list.size() ; i++) {
					
					code.append(list.get(i).getLuCd()).append("=")
					    .append(list.get(i).getLuDesc()).append("=")
					    .append(list.get(i).getAttrCtnt1()).append("=")
					    .append(list.get(i).getAttrCtnt2()).append("=")
					    .append(list.get(i).getAttrCtnt3()).append("=")
					    .append(list.get(i).getAttrCtnt4()).append("=")
					    .append(list.get(i).getAttrCtnt5())
					    ;
					
					if (i < list.size() - 1)	code.append("|");
					
					combo_code.append("|").append(list.get(i).getLuCd());
					combo_nm.append("|").append(list.get(i).getLuCd()).append("\t").append(list.get(i).getLuDesc());
				}
				
				eventResponse.setETCData("combo_code", combo_code.toString());
				eventResponse.setETCData("combo_nm", combo_nm.toString());
				
			} else {
				eventResponse.setETCData("one_lu_cd", "NO_DATA");
				eventResponse.setETCData("one_lu_desc", "NO_DATA");
			}
			
			eventResponse.setETCData("lu_cd_list", code.toString());
			if (list != null){
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	private EventResponse searchRevenuePortEachLaneList(Event e) throws EventException {
		log.debug("===============START searchRevenuePortEachLaneList");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0060Event event =(StmSco0060Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try {
			List<RevenuePortEachLaneVO> list = command.searchRevenuePortEachLaneList(event.getSlanCd(), event.getRlaneCd());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	private EventResponse manageRevenuePortEachLaneList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    StmSco0060Event event = (StmSco0060Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();
		
		try{
			begin(); 
			command.manageRevenuePortEachLaneList(event.getRevenuePortEachLaneVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	private EventResponse searchRevenuePort(Event e) throws EventException {
		log.debug("===============START searchRevenuePortEachLaneList");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0060Event event =(StmSco0060Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try {
			String result = command.searchRevenuePort(event.getRevPortCd());
			eventResponse.setETCData("result", result);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	private EventResponse searchTesMenualCancellation(Event e) throws EventException {
		log.debug("===============START searchRevenuePortEachLaneList");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0400Event event =(StmSco0400Event) e;
		StatementCommonBC command = new StatementCommonBCImpl("ACC_OPUSCNTR");

		try {
			List<TesManualCancellationVO> list = command.searchTesMenualCancellation(event.getExeYrmon(), event.getCancelFlg(), event.getVvd(), event.getYdCd());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	private EventResponse searchYardName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0400Event event =(StmSco0400Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try {
			String ydNm = command.searchYardName(event.getYdCd());
			eventResponse.setETCData("yd_nm", ydNm);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	private EventResponse cancelTesMenualCancellation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco0400Event event = (StmSco0400Event) e;
		StatementCommonBC command = new StatementCommonBCImpl("ACC_OPUSCNTR");
		
		try{
			begin(); 
			command.cancelTesMenualCancellation(event.getTesManualCancellationVOs(), account, event.getExeYrmon());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [common] lookup detail retrieve<br>
	 * lookup detail retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvArOfc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmScoCommonEvent event = (StmScoCommonEvent)e;
		StatementCommonBC command = new StatementCommonBCImpl();
		String exist = "N";
		try{
			LookupInfoVO lookupInfoVO = event.getLookupInfoVO();
			if(lookupInfoVO.getLuTpCd().equals("CHK_INV_AR_OFC")){ 
				exist = command.searchInvArOfc(lookupInfoVO.getOfcCd());
				eventResponse.setETCData("inv_ar_ofc", exist);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * Execute pgm : Retrieve<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse executePgm(Event e) throws EventException { 
		StmSco9999Event event = (StmSco9999Event) e; 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StatementCommonBC command = new StatementCommonBCImpl("ACC_OPUSCNTR");
		
		try { 
			
			begin();
			
			String jobNm 	= event.getJobNm();
			String ym 		= event.getAcclYm();
			
			String result = command.manageAccrualData(jobNm, (ym!=null&&!ym.equals(""))?ym.replaceAll("-", ""):"", account.getUsr_id());
			log.debug(">> STM_SCO_9999 ("+jobNm+") execute result ----------> : "+result);
			
			commit();

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Execute pgm : Job Status Refresh<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAcclJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco9999Event event = (StmSco9999Event) e; 
		StatementCommonBC command = new StatementCommonBCImpl("ACC_OPUSCNTR");

		try {
			String jobStatus = command.searchAcclJobStatus(event.getJobNm(), event.getAcclYm());
			eventResponse.setETCData("job_status", jobStatus);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * Execute pgm : Excel Download<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse manageAcclDataDownLoad(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSco9999Event event = (StmSco9999Event) e; 
		StatementCommonBC command = new StatementCommonBCImpl("ACC_OPUSCNTR");

		try {
			String fileNm = (("ACCLTRS".equals(event.getJobNm()))?"TRS_AccrualRowData":"TES_AccrualRowData")+"_"+event.getAcclYm().replace("-", "")+".xls";
			log.debug("event.getJobNm() 	: ====================>"+event.getJobNm()	);
			log.debug("event.getAcclYm() 	: ====================>"+event.getAcclYm()	);
			log.debug("fileNm 				: ====================>"+fileNm				);
			
			List<Object> list_all = command.manageAcclDataDownLoad(event.getJobNm(), event.getAcclYm());
			
			List<SearchTrsTesAcclDataVO> voList = (List<SearchTrsTesAcclDataVO>) list_all.get(2);
			
			if(voList.size() > 0 && voList != null){
				eventResponse.setCustomData("vos"		, voList			);
				eventResponse.setCustomData("title"		, list_all.get(1)	);
				eventResponse.setCustomData("columns"	, list_all.get(0)	);
				eventResponse.setCustomData("fileName"	, fileNm			);
				eventResponse.setCustomData("isZip"		, false				);
			} else {
				SearchTrsTesAcclDataVO vo = new SearchTrsTesAcclDataVO();
				vo.setExeYrmon("There is no data to search.");
				voList.add(vo);
				
				String headTitle    = "EXE_YRMON";
				String column_names = "exe_yrmon"; 
				
				String title[]   = headTitle.split("￠");
				String columns[] = column_names.split("￠");
				
				eventResponse.setCustomData("vos"		, voList	);
				eventResponse.setCustomData("title"		, title		);
				eventResponse.setCustomData("columns"	, columns	);
				eventResponse.setCustomData("fileName"	, fileNm	);
				eventResponse.setCustomData("isZip"		, false		);
			}
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [common] lookup detail retrieve<br>
	 * lookup detail retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLookupComboListWithChkStartEndDate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmScoCommonEvent event = (StmScoCommonEvent)e;
		StatementCommonBC command = new StatementCommonBCImpl();

		try{
			
			// loginOfcCd setting
			event.getLookupInfoVO().setLoginOfcCd(account.getOfc_cd());
			event.getLookupInfoVO().setLocalSysdate(command.searchLocalSysdate(account.getOfc_cd()));
			List<LookupInfoVO> list = command.searchLookupComboListWithChkStartEndDate(event.getLookupInfoVO());
			
			StringBuffer code = new StringBuffer("");
			StringBuffer combo_code = new StringBuffer("");
			StringBuffer combo_nm = new StringBuffer("");
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("one_lu_cd", list.get(0).getLuCd());
				eventResponse.setETCData("one_lu_desc", list.get(0).getLuDesc());
				
				for (int i = 0 ; i < list.size() ; i++) {
					
					code.append(list.get(i).getLuCd()).append("=")
					    .append(list.get(i).getLuDesc()).append("=")
					    .append(list.get(i).getAttrCtnt1()).append("=")
					    .append(list.get(i).getAttrCtnt2()).append("=")
					    .append(list.get(i).getAttrCtnt3()).append("=")
					    .append(list.get(i).getAttrCtnt4()).append("=")
					    .append(list.get(i).getAttrCtnt5())
					    ;
					
					if (i < list.size() - 1)	code.append("|");
					
					combo_code.append("|").append(list.get(i).getLuCd());
					combo_nm.append("|").append(list.get(i).getLuCd()).append("\t").append(list.get(i).getLuDesc());
				}
				
				eventResponse.setETCData("combo_code", combo_code.toString());
				eventResponse.setETCData("combo_nm", combo_nm.toString());
				
			} else {
				eventResponse.setETCData("one_lu_cd", "NO_DATA");
				eventResponse.setETCData("one_lu_desc", "NO_DATA");
			}
			
			eventResponse.setETCData("lu_cd_list", code.toString());
			if (list != null){
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * COMMON : searchLocalSysdate (COMMAND08) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalSysdate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StatementCommonBC command = new StatementCommonBCImpl();
		
		try {
			String rtnVal = command.searchLocalSysdate(account.getOfc_cd());
			eventResponse.setETCData("local_time", rtnVal);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * STM_SCO_0500 : SAKURA Interface Inquiry<br>
	 * 
	 * @author Kana Wakaumi
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSakuraInterfaceList(Event e) throws EventException {
		StmSco0500Event event = (StmSco0500Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try { 
			List<SakuraInterfaceListVO> list = command.searchSakuraInterfaceList(event.getSakuraInterfaceCondVO());
			eventResponse.setRsVoList(list);
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SCO_0100]<br>
	 * searchOfcAdjustTpComboList<br>
	 * SYPARK
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcAdjustTpComboList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//StmSco0100Event event = (StmSco0100Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<OfcWrtfTpComboListVO> list = command.searchOfcAdjustTpComboList();
			
			if(list.size() > 0){
				eventResponse.setETCData(list.get(0).getColumnValues());
			}else{
				eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());
			}

			StringBuffer ofcAdjustTp = new StringBuffer("");
			
			for (int i = 0; i < list.size(); i++) {
				ofcAdjustTp.append("|").append(list.get(i).getAcctTpCd()).append("^").append(list.get(i).getLuDesc());
			}
			
			eventResponse.setETCData("ofc_adj_tp_list", ofcAdjustTp.toString());
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Monthly TES/TRS/Cost Accrual Verification BackEndJob
     * 2016.12.21 Add
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchMonthlyAccrualVerificationBackEndJob(Event e) throws EventException {
		StatementCommonBC command = new StatementCommonBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String key = "";
			if(e.getEventName().equalsIgnoreCase("StmSco0410Event")) {
				StmSco0410Event event = (StmSco0410Event) e;
				key = command.searchMonthlyAccrualVerificationBackEndJob(event.getAccrualVerificationVO(), this.account);
			}else if(e.getEventName().equalsIgnoreCase("StmSco0420Event")) {
				StmSco0420Event event = (StmSco0420Event) e;
				key = command.searchMonthlyAccrualVerificationBackEndJob(event.getAccrualVerificationVO(), this.account);				
			}
			eventResponse.setETCData("key", key);
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
            rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
     * Retrieve Common BackEndJob Status
     * 2016.12.21 Add
     * 
     * @param Event e
     * @return EventResponse
	 * @throws BackEndJobException
	 */
	private EventResponse searchComBakEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String key = (String)e.getAttribute("key");
		String status = null;
		try {
			DBRowSet rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			Thread.sleep(1000);
			/*rowSet.next();
			Thread.sleep(1000);
			status = (String) rowSet.getObject("jb_sts_flg");
			*/
			while (rowSet.next()) {
				String jbStsFlg = rowSet.getString("JB_STS_FLG");
				String jbUsrErrMsg = rowSet.getString("JB_USR_ERR_MSG");
				if ("2".equals(jbStsFlg)) {
					// BackEndJob 
					status = "PROCESSING";
					break;
				} else if("3".equals(jbStsFlg)) {
					// success
					// Data Transmitted successufully!      
					eventResponse.setUserMessage("Data Retrieved Successfully !");  //Data Retrieved Successfully !
					status = "SUCCESS";
					break;
				} else if("4".equals(jbStsFlg)) { 
					if (!StringUtils.isEmpty(jbUsrErrMsg)) {
						eventResponse.setUserMessage(jbUsrErrMsg);
					} else {
						eventResponse.setUserMessage("Has been failed to retrieve data.");  //Has been failed to retrieve data.
					}
					status = "FAIL";
					break;
				}
			}
			
			eventResponse.setETCData("jb_sts_flg", status);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
     * Retrieve Common BackEndJob Result
     * 2016.12.21 Add
     * 
     * @param Event e
     * @return EventResponse
	 * @throws BackEndJobException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchComBackEndJobResult(Event e) throws EventException {
		String key = (String)e.getAttribute("key");		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if(e.getEventName().equalsIgnoreCase("StmSco0410Event") || e.getEventName().equalsIgnoreCase("StmSco0420Event")) {
				List<AccrualVerificationVO> list = null;
				list = (List<AccrualVerificationVO>)BackEndJobResult.loadFromFile(key);
				
				if( list != null ) {
					eventResponse.setRsVoList(list);
				}
			}
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Monthly Accrual Verification Trade/Account Code 조회.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyTesTrsAccrualCodeList(Event e) throws EventException {
		StmSco0410Event event = (StmSco0410Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try { 
			//Trade Code 조회.			
			List<AccrualCodeInfoVO> trdList = command.searchMonthlyAccrualCodeList("T", event.getAccrualVerificationVO());
			
			//Account Code 조회
			List<AccrualCodeInfoVO> acctList = command.searchMonthlyAccrualCodeList("A", event.getAccrualVerificationVO());
			
			eventResponse.setRsVoList(trdList);
			eventResponse.setRsVoList(acctList);
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Monthly Accrual Verification Profit Center/Sakura Account Code 조회.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyCostAccrualCodeList(Event e) throws EventException {
		StmSco0420Event event = (StmSco0420Event) e;
		StatementCommonBC command = new StatementCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try { 
			
			//Sakura Account Code 조회
			List<AccrualCodeInfoVO> acctList = command.searchMonthlyAccrualCodeList("S", event.getAccrualVerificationVO());
			
			eventResponse.setRsVoList(acctList);
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
}
