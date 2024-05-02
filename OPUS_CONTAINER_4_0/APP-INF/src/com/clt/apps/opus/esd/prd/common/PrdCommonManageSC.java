/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PrdCommonManageSC.java
 *@FileTitle : PRD Common Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0 
=========================================================*/
package com.clt.apps.opus.esd.prd.common;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.prd.common.prdcommon.basic.PrdCommonManageBC;
import com.clt.apps.opus.esd.prd.common.prdcommon.basic.PrdCommonManageBCImpl;
import com.clt.apps.opus.esd.prd.common.prdcommon.event.EsdPrd0026Event;
import com.clt.apps.opus.esd.prd.common.prdcommon.event.EsdPrd0027Event;
import com.clt.apps.opus.esd.prd.common.prdcommon.event.PrdCommonEvent;
import com.clt.apps.opus.esd.prd.common.prdcommon.vo.ContinentVO;
import com.clt.apps.opus.esd.prd.common.prdcommon.vo.ServiceProviderVO;
import com.clt.apps.opus.esd.prd.common.prdcommon.vo.ValidationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic ServiceCommand<br>
 * handling business transaction of PRD<br>
 * 
 * @author jungsunyoung
 * @see EventResponse,PrdCommonManageDBDAO
 * @since J2EE 1.4
 */
public class PrdCommonManageSC extends ServiceCommandSupport {
	// Login User Information

	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario - PRD<br>
	 * related objects creation<br>
	 */
	@Override
	public void doStart() {
		try {
			account = getSignOnUserAccount();
			if (account.getUsr_id() == null) {
				throw new RuntimeException((new ErrorHandler("PRD00035")).getMessage());
			}

		} catch (Exception e) {
			log.error("PrdCommonManageSC error : " + e.toString(), e);
		}
	}

	/**
	 * biz scenario closing - PRD<br>
	 * clearing related objects<br>
	 */
	@Override
	public void doEnd() {
		// command.doEnd();
		log.debug("PrdCommonManageSC End");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EventResponse perform(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		if (e.getEventName().equalsIgnoreCase("PrdCommonEvent")) {
			
			PrdCommonEvent 		event 		= (PrdCommonEvent) e;
			PrdCommonManageBC 	command 	= new PrdCommonManageBCImpl();
			List<ValidationVO> 	list 		= new ArrayList<ValidationVO>();
			List<ContinentVO> 	conList 	= new ArrayList<ContinentVO>();
			
			boolean				isInThePast	= false;
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				list = command.validationPort(event.getValidationVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02) || e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				list = command.validationLocation(event.getValidationVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//
				list = command.validationNode(event.getValidationVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				list = command.validationTerminal(event.getValidationVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				list = command.validationCountry(event.getValidationVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				list = command.validationLane(event.getValidationVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				list = command.validationVendor(event.getValidationVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				list = command.validationFdrLane(event.getValidationVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				list = command.validationCallingTmlMtxLane(event.getValidationVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				list = command.validationCallingTmlMtxTmlCd(event.getValidationVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				// SearchSubContinentList
				conList = command.searchSubContinent(event.getContinentVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				// SearchContinentList
				conList = command.searchContinent();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				// Checking whether full cargo closing time is in the past or not //
				isInThePast = command.isFullCargoCutOffInThePast(event.getValidationVO());
			}
			
			if(e.getFormCommand().isCommand(FormCommand.SEARCH21)){
				eventResponse.setETCData("IS_IN_THE_PAST", isInThePast==true?"Y":"N");
			}else if (conList != null && conList.size() > 0 && (conList.get(0) instanceof ContinentVO)) {
				eventResponse.setRsVoList(conList);
			}else{
				String comData1 = "";
				String comData2 = "";
				boolean isDoor = false;
				eventResponse.setETCData("rowCount", "0");
				if (list != null && list.size() > 0) {
					ValidationVO vo = (ValidationVO) list.get(0);
					eventResponse.setETCData(vo.getColumnValues());
					eventResponse.setETCData("rowCount", list.size() + "");
					eventResponse.setRsVoList(list);
					if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
						for (int i = 0; i < list.size(); i++) {

							comData1 = list.get(i).getVslSlanNm();
						}
					} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
						isDoor = command.isDoorTerminal(event.getValidationVO().getCheckData());
						for (int i = 0; i < list.size(); i++) {
							comData1 = list.get(i).getNodeName();
							comData2 = list.get(i).getLocationCode();
						}
					} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
						for (int i = 0; i < list.size(); i++) {
							comData1 = list.get(i).getComData1();
							comData2 = list.get(i).getComData2();
						}
					} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
						for (int i = 0; i < list.size(); i++) {
							comData1 = list.get(i).getCheckData();
						}
					}
				}
				
				eventResponse.setETCData("comData1", comData1);
				eventResponse.setETCData("comData2", comData2);
				eventResponse.setETCData("isDoor", isDoor + "");
			}
			
		} else if (e.getEventName().equalsIgnoreCase("ESD_PRD_030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				PrdCommonEvent event = (PrdCommonEvent) e;
				PrdCommonManageBC command = new PrdCommonManageBCImpl();
				List list = command.validationCallingTmlMtxLane(event.getValidationVO());
				eventResponse.setRsVoList(list);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0026Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchServiceProviderList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchComIntgCdDtl(e);
			}
		}
		
		return eventResponse;
	}

	/**
	 * PrdCommonManageSC's searchServiceProviderList
	 * 
	 * @param e
	 * @return
	 * @throws EventException EventResponse
	 */
	private GeneralEventResponse searchServiceProviderList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0026Event event = (EsdPrd0026Event) e;
		PrdCommonManageBC command = new PrdCommonManageBCImpl();
		try {
			if (event.getServiceProviderVO().getOfcCd().equals("")) {
				event.getServiceProviderVO().setOfcCd(account.getOfc_cd());
			}
			List<ServiceProviderVO> list = command.searchServiceProviderList(event.getServiceProviderVO());
			eventResponse.setETCData("ofc_cd", event.getServiceProviderVO().getOfcCd());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * PrdCommonManageSC's searchComIntgCdDtl
	 * 
	 * @param e
	 * @return
	 * @throws EventException EventResponse
	 */
	private GeneralEventResponse searchComIntgCdDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PrdCommonManageBC command = new PrdCommonManageBCImpl();
		EsdPrd0027Event event = (EsdPrd0027Event) e;
		try {
			eventResponse.setRsVoList(command.searchComIntgCdDtl(event.getComIntgCdDtlVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
}
