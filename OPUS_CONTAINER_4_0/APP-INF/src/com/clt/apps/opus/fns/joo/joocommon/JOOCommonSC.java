/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOCommonSC.java
*@FileTitle : common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.clt.apps.opus.fns.joo.joocommon.joofileupload.basic.JOOFileUploadBC;
import com.clt.apps.opus.fns.joo.joocommon.joofileupload.basic.JOOFileUploadBCImpl;
import com.clt.apps.opus.fns.joo.joocommon.joofileupload.event.FnsJoo0082Event;
import com.clt.apps.opus.fns.joo.joocommon.joofileupload.vo.FileUploadListVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBC;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBCImpl;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.event.JooComEvent;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration.JOOFindCodeAndCheckDBDAO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoGrpVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooComActualCarrierVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooComCodeVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooComRlaneVO;
import com.clt.apps.opus.fns.joo.joocommonutil.JooConstants;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-JOOCommon Business Logic ServiceCommand - handling business transaction
 *
 * @author
 * @see JOOFindCodeAndCheckDBDAO
 * @since J2EE 1.4
 */

public class JOOCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * JOOCommon system : preceding process for biz scenario<br>
	 */
	public void doStart() {
		try {
			// checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * JOOCommon system : biz scenario closing<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("JOOCommonSC 종료");
	}

	/**
	 * 
	 * OPUS-JOOCommon system <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

        if (e.getEventName().equalsIgnoreCase("FnsJoo0082Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
                eventResponse = searchFileUploadList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFileUpload(e);
            }
		}

		
		if (e.getEventName().equalsIgnoreCase("JooComEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMdmTradeCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchMdmRlaneCdList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchCarrierCodeString(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchCustomerList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchVendorList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = searchTradeCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) {
				eventResponse = searchRLaneCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST08)) {
				eventResponse = checkVVD(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST09)) {
				eventResponse = searchItemAcctList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = searchRevDirPortList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {
				eventResponse = searchPortListByLane(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)) {
				eventResponse = checkCarrierCode(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {
                eventResponse = searchCarrierCodeList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)) {
                eventResponse = searchUnitCostPortList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST15)) {
                eventResponse = searchRLaneRTUList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST16)) {
                eventResponse = searchRLaneCurrList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST17)) {
                eventResponse = searchTradeCombinedNoList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST18)) {
                eventResponse = searchCombinedNoList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST19)) {
                eventResponse = searchTradeRlaneCodeList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST20)) {
                eventResponse = searchCheckEstmClz(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRlaneAndCarrierListByTrade(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchCarrierListByRlane(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchRevYrmonFrTo(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchTradeCodeListEstm(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = searchRlaneCodeListEstm(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
                eventResponse = searchCarrierCodeListEstm(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
                eventResponse = searchSvcRlaneCodeList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
                eventResponse = searchRLaneStlOptList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
            	eventResponse = searchRevDirAndUnitCostPortList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
                /* OFC_CD of JOO_SLIP */
                eventResponse = searchOfcCdSlip(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
                /* retrieving office code check */
                eventResponse = searchOfcCd(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
                /* retrieving RLane Code check */
                eventResponse = searchRLaneStlOpt3CodeList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
                /* retrieving office code check */
                eventResponse = searchCombinedNoOptAuthList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
                /* VSL+VO code check  */
                eventResponse = searchVslVoyageList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchTradeCodeWithoutAuthorityList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchRLaneCodeWithoutAuthorityList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchRLaneCodeByCarrierList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchArHqOfcAllList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
            	eventResponse = searchCarrierCodeWithoutAuthorityList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
            	eventResponse = searchJooComCodeList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
            	eventResponse = searchRlaneCodeList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
            	eventResponse = searchActualCarrierList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH23)) { //2016.08.01 Add
            	eventResponse = searchConditionComboItemByAuthOfficeCd(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH24)) { //2016.08.01 Add
            	eventResponse = searchTradeCodeByAuthOfficeList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH25)) { //2016.08.01 Add
            	eventResponse = searchRLaneCodeByAuthOfficeList(e);
            }



		}

		return eventResponse;
	}

	/**
	 * checking validation in case of inputting Account Code manually
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchItemAcctList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchItemAcctList(jooCodeParamVO);

		if (list.isEmpty()){
			eventResponse.setETCData("CHECKVVD", "E");
			eventResponse.setETCData("VVDMSG", "Wrong Account Number");
		}else{
			eventResponse.setETCData("CHECKVVD", "N");
			eventResponse.setETCData("VVDMSG", "Normal");
		}

		return eventResponse;
	}

	/**
	 * retrieving Trade Code List from MDM
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMdmTradeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();

		List<JooCodeInfoVO> list = command.searchMdmTrdCdList(jooCodeParamVO);

		String comboList = makeComboString(list, 1);
		eventResponse.setETCData("trd_cd" ,comboList);
		return eventResponse;
	}

	/**
	 * retrieving Revenue Lane from MDM
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMdmRlaneCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		jooCodeParamVO.setOfcCd(account.getOfc_cd());

		List<JooCodeInfoVO> list = command.searchMdmRlaneCdList(jooCodeParamVO);
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse searchCommonCodeList(Event e) throws EventException {
//		JooComEvent event = (JooComEvent)e;
//
//		// PDTO(Data Transfer Object including Parameters)
//		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
//
//		List<JooCodeInfoVO> list = command.searchComCodeList(jooCodeParamVO);
//		eventResponse.setRsVoList( list );
//		String comboList = makeComboString(list, 2);
//		eventResponse.setETCData(jooCodeParamVO.getSuperCd1(), comboList);
//		return eventResponse;
//	}

	/**
	 * retrieving Customer Name in case of inputting Customer Code
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchCustomerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchCustomerList(jooCodeParamVO);
		Iterator iterator = (Iterator) list.iterator();

		String code = "";
		String name = "";
		while(iterator.hasNext()){
			JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO)iterator.next();
			code = jooCodeInfoVO.getCode();
			name = jooCodeInfoVO.getName();
		}
		eventResponse.setETCData("cust_seq" ,code);
		eventResponse.setETCData("cust_lgl_eng_nm" ,name);
		return eventResponse;
	}

	/**
	 * retrieving Vendor Name in case of inputting Vendor Code 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchVendorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();

		List<JooCodeInfoVO> list = command.searchVendorList(jooCodeParamVO);

		Iterator iterator = (Iterator) list.iterator();

		String name = "";
		String code = "";
		while(iterator.hasNext()){
			JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO)iterator.next();
			code = jooCodeInfoVO.getCode();
			name = jooCodeInfoVO.getName();
		}
		eventResponse.setETCData("vndr_seq" ,code);
		eventResponse.setETCData("vndr_lgl_eng_nm" ,name);
		return eventResponse;
	}

	/**
	 * retrieving Trade code of carrier in case of changing Carrier Code
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTradeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
        jooCodeParamVO.setOfcCd(  this.account.getOfc_cd() );
		List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * retrieving Rlane_cd by Carrier Code, Trade Code in case of changing Trade
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRLaneCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		jooCodeParamVO.setOfcCd( this.account.getOfc_cd()  );
		List<JooCodeInfoVO> list = command.searchRlaneCodeList(jooCodeParamVO);
		eventResponse.setRsVoList( list );
		String comboList = makeComboString(list, 1);
		eventResponse.setETCData("rlane_cd" ,comboList);
		return eventResponse;
	}

	/**
	 * checking validation in case of inputting VVD manually
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.checkVVD(jooCodeParamVO);

		if (list.isEmpty()){
			eventResponse.setETCData("CHECKVVD", "E");
			eventResponse.setETCData("VVDMSG", "Wrong VVD");
		}else{
			eventResponse.setETCData("CHECKVVD", "N");
			eventResponse.setETCData("VVDMSG", "Normal");
		}

		return eventResponse;
	}


	/**
	 * retrieving Basic Port(n1st,n2nd,n3rd), Pair Port in case of inputting VVD
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRevDirPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		//parameter
		//super_cd1 => rlane_cd
		//super_cd2 => VVD (VSL_CD,SKD_VOY_NO,SKD_DIR_CD 9 digits)
		//code      => jo_crr_cd
		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		JooCodeInfoGrpVO grpVO = command.searchRevDirPortList(jooCodeParamVO);
		List<JooCodeInfoVO> list1 = grpVO.getJooCodeInfoVO1s(); //Basic Port List
		List<JooCodeInfoVO> list2 = grpVO.getJooCodeInfoVO2s(); //Pair  Port List
		List<JooCodeInfoVO> list3 = grpVO.getJooCodeInfoVO3s(); //UnitCost Port List

		//select List 
		//CODE => PORT
		//NAME => ETA||','||ETD
		//SUPER_CD1 => RLANE_DIR_CD
		//SUPER_CD2 => REVENUE DIRECTION 의 DELT_FLG
		String basicPorts = makeComboString(list1, 7);
		//select List 
		//CODE => PORT
		//NAME => ETA||','||ETD
		String pairPorts = makeComboString(list2, 5);

		//select List 
		//CODE => PORT
		//NAME => ETD
		String unitPorts = makeComboString(list3, 5);

		eventResponse.setETCData("basicPorts", basicPorts);
		eventResponse.setETCData("pairPorts" , pairPorts);
		eventResponse.setETCData("unitPorts" , unitPorts);
		return eventResponse;
	}

	/**
	 * retrieving port list that ETA is after -100 days
	 * Search Condition
	 *  - super_cd1 : lane code
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPortListByLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchPortListByLane(jooCodeParamVO);
		String portCode = makeComboString(list, 2);
		
		//2015.02.16 Add Direction Search.
		List<JooCodeInfoVO> list2 = command.searchVslSlanDirCdByLane(jooCodeParamVO);
		String vslSlanDirCode = makeComboString(list2, 2);

		eventResponse.setETCData("portCode", portCode);
		eventResponse.setETCData("vslSlanDirCode", vslSlanDirCode);
		return eventResponse;
	}

	/**
	 * inputting Carrier Code manually
	 * Search Condition
	 *  - code : Carrier code (optional)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkCarrierCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchVskCarrierList(jooCodeParamVO);

		if (list.isEmpty()){
			eventResponse.setETCData("CHECK", "E");
			eventResponse.setETCData("CHKMSG", "Wrong Carrier");
		}else{
			eventResponse.setETCData("CHECK", "N");
			eventResponse.setETCData("CHKMSG", "Normal");
		}
		return eventResponse;
	}

    /**
	 * retrieving carrier code used in joint operation
	 * Search Condition
	 *  - super_cd1 : trade code (optional)
	 *  - super_cd2 : rlane code (optional)
	 *  - code : carrier code (optional)
	 * @param e Event
	 * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchCarrierCodeList(Event e) throws EventException {
        JooComEvent event = (JooComEvent)e;
        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
        jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
        List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
        eventResponse.setRsVoList( list );
        return eventResponse;
    }

    /**
	 * retrieving carrier code used in joint operation (ETC-DATA(String)로 return)
	 * Search Condition
	 *  - super_cd1 : trade code (optional)
	 *  - super_cd2 : rlane code (optional)
	 *  - code : carrier code (optional)
	 * @param e Event
	 * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchCarrierCodeString(Event e) throws EventException {
        JooComEvent event = (JooComEvent)e;
        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
        jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
        List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

        StringBuilder comboCode = new StringBuilder();
		StringBuilder comboText = new StringBuilder();
		for (int i=0 ; i<list.size(); i++) {
			comboCode.append(list.get(i).getCode() + "^#^");
			comboText.append(list.get(i).getName() + "^#^");
		}
		eventResponse.setETCData("comboCode", comboCode.toString());
		eventResponse.setETCData("comboText", comboText.toString());
        return eventResponse;
    }

	/**
	 * retrieving Unit Cost Port in Vessel Port Schedule by Lane and VVD
	 * Search Condition
	 *  - super_cd1 : lane code - mandatory
	 *  - super_cd2 : VVD (9 digits) - mandatory
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUnitCostPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		//parameter 
		//super_cd1 => rlane_cd
		//super_cd2 => VVD (VSL_CD,SKD_VOY_NO,SKD_DIR_CD 9 digits)
		//code      => jo_crr_cd
		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchUnitCostPortList(jooCodeParamVO);

		//select List 
		//CODE => PORT
		//NAME => ETD
		String unitPorts = makeComboString(list, 5);

		eventResponse.setETCData("unitPorts" , unitPorts);
		return eventResponse;
	}

	/**
	 * creating String for combo by List
	 * @param List<JooCodeInfoVO> list
	 * @param int flg
	 * @return String rtnVal
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	private String makeComboString(List<JooCodeInfoVO> list, int flg) throws EventException{
		String rtnVal = null;

		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while(iterator.hasNext()){
			JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO)iterator.next();

			if (flg==0){
				sb.append(jooCodeInfoVO.getName()+","+jooCodeInfoVO.getCode()+"|");
			//IBCombo (code, code|)
			}else if (flg==1){
				sb.append(jooCodeInfoVO.getCode()+","+jooCodeInfoVO.getCode()+"|");
			//IBSheet code(code|)
			}else if (flg==2){
				sb.append(jooCodeInfoVO.getCode()+"|");
			//IBSheet name(name|)
			}else if (flg==3){
				sb.append(jooCodeInfoVO.getName()+"|");
			//retrieving SuperCd
			}else if (flg==4){
				sb.append(jooCodeInfoVO.getSuperCd1()+","+jooCodeInfoVO.getSuperCd2()+","+jooCodeInfoVO.getCode()+"|");
			//Code, Name
			}else if (flg==5){
				sb.append(jooCodeInfoVO.getCode()+","+jooCodeInfoVO.getName()+"|");
			//Port
			}else if (flg==6){
				sb.append(jooCodeInfoVO.getSuperCd2()+","+jooCodeInfoVO.getCode()+","+ jooCodeInfoVO.getName()+"|");
			}else if (flg==7){
				sb.append(jooCodeInfoVO.getSuperCd1()+","+jooCodeInfoVO.getSuperCd2()+","+jooCodeInfoVO.getCode()+","+ jooCodeInfoVO.getName()+"|");
			}else if (flg==8){
				sb.append(jooCodeInfoVO.getSuperCd1()+"|");
			}else if (flg==9){
				sb.append(jooCodeInfoVO.getName()+","+jooCodeInfoVO.getCode()+","+jooCodeInfoVO.getSuperCd1()+"|");
			}
		}

		rtnVal = sb.toString();

		if (rtnVal.length() > 0){
			rtnVal = rtnVal.substring(0,rtnVal.length()-1);
		}

		return rtnVal;
	}


	/**
	 * FNS_JOO_0009, FNS_JOO_0010, FNS_JOO_0011 : changing Trade
	 * retrieving Lane, RTU, Currency, AUTH_CD for OUS RDR, OUS TDR, Reefer of Settlement
	 * Search Condition
	 *  - super_cd1 : Carrier (mandatory)
	 *  - super_cd2 : Trade  (mandatory)
	 *  - code : settlement ITEM (mandatory)
	 *  - name : (re_divr_cd) (mandatory)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRLaneRTUList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchRlaneRTUList(jooCodeParamVO);
		eventResponse.setRsVoList( list );
		return eventResponse;
	}

	/**
	 * getting Rlane and Currency of Financial Matix in case of changing Trade
	 * Search Condition
	 *  - super_cd1 : Carrier (mandatory)
	 *  - super_cd2 : Trade  (mandatory)
	 *  - code : settlement ITEM (mandatory)
	 *  - name : (re_divr_cd) (mandatory)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRLaneCurrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchRlaneCurrList(jooCodeParamVO);
		eventResponse.setRsVoList( list );
//		String codeList = makeComboString(list, 2);
//		String nameList = makeComboString(list, 3);
//		eventResponse.setETCData("codeList" ,codeList);
//		eventResponse.setETCData("nameList" ,nameList);
		return eventResponse;
	}

	/**
	 * retrieving Trade code and STL_CMB_SEQ in case of changing Carrier
	 * Trade Search Condition
	 *  - super_cd2 : Carrier (optional)
	 *  - code : trade code
	 * STL_CMB_SEQ Search Condition
	 *  - super_cd1 : Account Month (ACCT_YRMON)
	 *  - super_cd2 : Carrier Code (JO_CRR_CD)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTradeCombinedNoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		String acctYrmon = jooCodeParamVO.getSuperCd2();
		jooCodeParamVO.setSuperCd2("");
		List<JooCodeInfoVO> tradeList    = command.searchTradeCodeList (jooCodeParamVO);
		jooCodeParamVO.setSuperCd2(acctYrmon);
		List<JooCodeInfoVO> combinedList = command.searchCombinedNoList(jooCodeParamVO);

		String tradeCombo    = makeComboString(tradeList, 1);
		String combinedCombo = makeComboString(combinedList, 2);
		String slipCombo     = makeComboString(combinedList, 3);
		eventResponse.setETCData("trd_cd"      ,tradeCombo);
		eventResponse.setETCData("combined_no" ,combinedCombo);
		eventResponse.setETCData("slip_no"     ,slipCombo);
		return eventResponse;
	}

	/**
	 * retrieving combined no in JOO_STL_CMB
	 * Search Condition
	 *  - super_cd1 : Account Month (ACCT_YRMON)
	 *  - super_cd2 : Carrier Code (JO_CRR_CD)
	 *  - name : Trade Code
	 *  - code : re_divr_cd (option)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCombinedNoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> combinedList = command.searchCombinedNoList(jooCodeParamVO);

		String combinedCombo = makeComboString(combinedList, 2);
		String slipCombo     = makeComboString(combinedList, 3);
		eventResponse.setRsVoList(combinedList);
		eventResponse.setETCData("combined_no" ,combinedCombo);
		eventResponse.setETCData("slip_no"     ,slipCombo);
		return eventResponse;
	}

	/**
	 * retrieving Trade and Rlane in case of changing Carrier
	 * Search Condition
	 *  - super_cd1 : Carrier Code (JO_CRR_CD)
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchTradeRlaneCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);

		String comboList = makeComboString(list, 1);
		eventResponse.setETCData("trd_cd" ,comboList);

		list = command.searchRlaneCodeList(jooCodeParamVO);
		eventResponse.setRsVoList( list );
		comboList = makeComboString(list, 1);
		eventResponse.setETCData("rlane_cd" ,comboList);
		return eventResponse;
	}

	/**
	 * retrieving monthly closing status in case of chagning month
	 * Search Condition
	 *  - super_cd1 : (exe_yrmon)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCheckEstmClz(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		JooCodeInfoVO jooCodeInfoVO = command.searchCheckEstmClz(jooCodeParamVO);

		eventResponse.setETCData("estm_clz_flg",jooCodeInfoVO.getCode());

		return eventResponse;
	}

	/**
	 * retrieving Rlane and Carrier in case of changing Trade
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRlaneAndCarrierListByTrade(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
        jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchRlaneCodeList(jooCodeParamVO);
		String comboList = makeComboString(list, 1);
		eventResponse.setETCData("rlane_cd" ,comboList);

		list = command.searchCarrierCodeListByTradeAndRlane(jooCodeParamVO);
		comboList = makeComboString(list, 1);
		eventResponse.setETCData("jo_crr_cd" ,comboList);

		return eventResponse;
	}

	/**
	 * retrieving carrier in case of changing Rlane
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCarrierListByRlane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeListByTradeAndRlane(jooCodeParamVO);
        eventResponse.setRsVoList( list );
		String comboList = makeComboString(list, 1);
		eventResponse.setETCData("jo_crr_cd" ,comboList);

		return eventResponse;
	}

	/**
	 * retrieving MIN, MAX rev_yrmon by month
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRevYrmonFrTo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EstmConditionVO estmConditionVO = new EstmConditionVO();//event.getestm
		List<EstmConditionVO> list = command.searchRevYrmonFrTo(estmConditionVO);

		String revYrmonFr = estmConditionVO.getExeYrmon();
		String revYrmonTo = estmConditionVO.getExeYrmon();
		if (!list.isEmpty()){
			if (list.get(0).getRevYrmonFr()!= null && !"".equals(list.get(0).getRevYrmonFr())){
				revYrmonFr = list.get(0).getRevYrmonFr();
			}

			if (list.get(0).getRevYrmonTo()!= null && !"".equals(list.get(0).getRevYrmonTo())){
				revYrmonTo = list.get(0).getRevYrmonTo();
			}
		}
		eventResponse.setETCData("REV_YRMON_FR" ,revYrmonFr);
		eventResponse.setETCData("REV_YRMON_TO" ,revYrmonTo);

		return eventResponse;
	}

	/**
	 * retrieving Trade code list  by month, Revenue month from, to, R/E
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTradeCodeListEstm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EstmConditionVO estmConditionVO = new EstmConditionVO();//event.getestm
		List<EstmConditionVO> list = command.searchTradeCodeListEstm(estmConditionVO);

		String trdCd = makeEstmComboString(list, 0);
		eventResponse.setETCData("TRD_CD",trdCd);

		return eventResponse;
	}


	/**
	 * retrieving Revenue Lane code list  by month, Revenue month from, to, R/E, Trade
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRlaneCodeListEstm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EstmConditionVO estmConditionVO = new EstmConditionVO();//event.getestm
		List<EstmConditionVO> list = command.searchRlaneCodeListEstm(estmConditionVO);

		String rlaneCd = makeEstmComboString(list, 1);
		eventResponse.setETCData("RLANE_CD",rlaneCd);

		return eventResponse;
	}

	/**
	 * retrieving carrier code list by month, Revenue month from, to, R/E, Trade, Rlane
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCarrierCodeListEstm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EstmConditionVO estmConditionVO = new EstmConditionVO();//event.getestm
		List<EstmConditionVO> list = command.searchCarrierCodeListEstm(estmConditionVO);

		String joCrrCd = makeEstmComboString(list, 2);
		eventResponse.setETCData("JO_CRR_CD",joCrrCd);

		return eventResponse;
	}
	/**
	 *
     * retrieving MDM_VSL_SVC_LANE Rlane
	 *
	 * @param  Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author 
	 */
    private EventResponse searchSvcRlaneCodeList(Event e) throws EventException {
        JOOFindCodeAndCheckBC command      = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        JooComEvent event                  = (JooComEvent)e;
        JooCodeParamVO jooCodeParamVO      = event.getJooCodeParamVO();
        jooCodeParamVO.setOfcCd(  this.account.getOfc_cd() );
        List<JooCodeInfoVO> list           = command.searchSvcRlaneCodeList(jooCodeParamVO);

        eventResponse.setRsVoList( list );
        return eventResponse;
    }
	/**
	 * changing EstmConditionVO list to String
	 * @param List<EstmConditionVO> list
	 * @param int flg
	 * @return String
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	private String makeEstmComboString(List<EstmConditionVO> list, int flg) throws EventException{
		String rtnVal = null;

		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while(iterator.hasNext()){
			EstmConditionVO estmConditionVO = (EstmConditionVO)iterator.next();

			if (flg==0){
				sb.append(estmConditionVO.getTrdCd()+"|");
			}else if (flg==1){
				sb.append(estmConditionVO.getRlaneCd()+"|");
			}else if (flg==2){
				sb.append(estmConditionVO.getJoCrrCd()+"|");
			}
		}

		rtnVal = sb.toString();

		if (rtnVal.length() > 0){
			rtnVal = rtnVal.substring(0,rtnVal.length()-1);
		}

		return rtnVal;
	}

	/**
	 * retrieving Rlane_cd and Jo_stl_opt_cd in case of changing Trade
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRLaneStlOptList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchRLaneStlOptList(jooCodeParamVO);
		eventResponse.setRsVoList( list );
		return eventResponse;

	}
    /**
     * @param  FnsJooFileViewEvent e
     * @throws EventException
     * @author 
     */
//	private EventResponse searchAttchFile(Event e) throws EventException {
//	    try{
//    	    FnsJooFileViewEvent event = (FnsJooFileViewEvent)e;
//
//    	    JointOperationLetterBC command = new JointOperationLetterBCImpl();
//            GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//            FileInfoVO fileInfoVO = event.getFileInfo();
//            List<FileInfoVO> list = command.searchAttchFile(fileInfoVO);
//            eventResponse.setRsVoList( list );
//            return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);;
//            throw new EventException(ex.getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);;
//            throw new EventException(ex.getMessage(), ex);
//        }
//    }


	/**
	 * FNS_JOO_0005 : Revenue Direction Click
	 * retrieving Rev Dir and Unit Cost Port list
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRevDirAndUnitCostPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		//parameter 
		//super_cd1 => rlane_cd
		//super_cd2 => VVD (VSL_CD,SKD_VOY_NO,SKD_DIR_CD 9 digits)
		//code      => jo_crr_cd
		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchRevDirAndUnitCostPortList(jooCodeParamVO);

		String revDirCd = "";
		String deltFlg  = "";
		if (!list.isEmpty()){
			revDirCd = list.get(0).getSuperCd1();
			deltFlg  = list.get(0).getSuperCd2();
		}

		//select List 
		//CODE => PORT
		//NAME => ETD
		String unitPorts = makeComboString(list, 5);

		eventResponse.setETCData("revDirCd" , revDirCd);
		eventResponse.setETCData("deltFlg"  , deltFlg);
		eventResponse.setETCData("unitPorts", unitPorts);
		return eventResponse;
	}
    /**
     *
     * retrieving  SLP_OFC_CD of JOO_SLIP
     *
     * @param  Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchOfcCdSlip(Event e) throws EventException {
        JOOFindCodeAndCheckBC command      = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        JooComEvent event                  = (JooComEvent)e;
        JooCodeParamVO jooCodeParamVO      = event.getJooCodeParamVO();
        List<JooCodeInfoVO> list           = command.searchOfcCdSlip(jooCodeParamVO);

        eventResponse.setRsVoList( list );
        return eventResponse;
    }
    /**
     *
     * retrieving office code check
     *
     * @param  Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchOfcCd(Event e) throws EventException {
        JOOFindCodeAndCheckBC command      = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        JooComEvent event                  = (JooComEvent)e;
        JooCodeParamVO jooCodeParamVO      = event.getJooCodeParamVO();
        List<JooCodeInfoVO> list           = command.searchOfcCd(jooCodeParamVO);

        eventResponse.setRsVoList( list );
        
        String result = "N";
        if (list.isEmpty()){
        	result = "E";
        }
        eventResponse.setETCData("RESULT", result);
        return eventResponse;
    }
    /**
     *
     * retrieving carrier code 3 digits
     *
     * @param  Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchRLaneStlOpt3CodeList(Event e) throws EventException {
        JOOFindCodeAndCheckBC command      = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        JooComEvent event                  = (JooComEvent)e;
        JooCodeParamVO jooCodeParamVO      = event.getJooCodeParamVO();
        jooCodeParamVO.setOfcCd(account.getOfc_cd());
        List<JooCodeInfoVO> list           = command.searchRLaneStlOpt3CodeList(jooCodeParamVO);

        eventResponse.setRsVoList( list );
        return eventResponse;
    }
    /**
     * FNS_JOO_0062 : combo Focus
     * retrieving combined no
     *
     * @param  Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchCombinedNoOptAuthList(Event e) throws EventException {

        JooComEvent event = (JooComEvent)e;
        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
        jooCodeParamVO.setOfcCd(account.getOfc_cd());
        List<JooCodeInfoVO> combinedList = command.searchCombinedNoOptAuthList(jooCodeParamVO);;
        eventResponse.setRsVoList(combinedList);

        return eventResponse;
    }
    /**
     * FNS_JOO_0081 : EDIT KEYUP
     * checking validation of VSL CODE + VOYAGE NUMBER
     *
     * @param  Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchVslVoyageList(Event e) throws EventException {

        JooComEvent event = (JooComEvent)e;
        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
        List<JooCodeInfoVO> vslVoyageList = command.searchVslVoyageList(jooCodeParamVO);;
        eventResponse.setRsVoList(vslVoyageList);

        return eventResponse;
    }

	/**
	 * retrieving Trade code in case of changing Carrier Code
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTradeCodeWithoutAuthorityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchTradeCodeWithoutAuthorityList(jooCodeParamVO);
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * retrieving Rlane_cd in case of changing Trade
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRLaneCodeWithoutAuthorityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchRlaneCodeWithoutAuthorityList(jooCodeParamVO);
		eventResponse.setRsVoList( list );
		String comboList = makeComboString(list, 1);
		String comboListSheet = makeComboString(list, 2);
		eventResponse.setETCData("rlane_cd" ,comboList);
		eventResponse.setETCData("rlane_combo_sheet" ,comboListSheet);
		return eventResponse;
	}


	/**
	 * retrieving Rlane_cd in case of changing Trade
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRLaneCodeByCarrierList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		jooCodeParamVO.setOfcCd( this.account.getOfc_cd()  );
		List<JooCodeInfoVO> list = command.searchRlaneCodeList(jooCodeParamVO);
		String comboList = makeComboString(list, 2);
		eventResponse.setETCData("rlane_cd" ,comboList);
		return eventResponse;
	}

	/**
	 * retrieving File Upload<br>
	 * @author
	 * @category FNS_JOO_0082
	 * @category searchFileUploadList
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFileUploadList(Event e) throws EventException {

		// return object creation
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC object creation
			JOOFileUploadBC command = new JOOFileUploadBCImpl();

			FnsJoo0082Event event = (FnsJoo0082Event)e;

			String joCrrCd = event.getJoCrrCd();

			String crrCntcSeq = event.getCrrCntcSeq();

			List<FileUploadListVO> list =
				command.searchFileUploadList(joCrrCd, crrCntcSeq);

			eventResponse.setRsVoList(list);

		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * File Upload update, input<br>
	 * @author
	 * @category FNS_JOO_0082
	 * @category manageFileUpload
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFileUpload(Event e) throws EventException {

		// return object creation
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			begin();

			// BC object creation
			JOOFileUploadBC command = new JOOFileUploadBCImpl();

			FnsJoo0082Event event = (FnsJoo0082Event)e;

			FileUploadListVO[] fileUploadListVOs = event.getFileUploadListVOs();
			FileUploadListVO vo = fileUploadListVOs[0];

			vo.setUpdUsrId(account.getUsr_id());

			command.manageFileUpload(fileUploadListVOs);

			
			eventResponse.setUserMessage(new ErrorHandler("JOO10003")
					.getUserMessage());

			eventResponse.setETCData("ERROR_YN", "N");

			commit();

		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}


		return eventResponse;
	}

	/**
	 * retrieving RHQ code
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchArHqOfcAllList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		jooCodeParamVO.setOfcCd(account.getOfc_cd());

		String offCombo = "";
		List<JooCodeInfoVO> list = command.searchArHqOfcAllList(jooCodeParamVO);
		offCombo = " ,|"+makeComboString(list, 1);
		eventResponse.setETCData("office", offCombo);
		return eventResponse;
	}

	/**
	 * retrieving Carrier in case of changing code Lane Code
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCarrierCodeWithoutAuthorityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);
		eventResponse.setRsVoList(list);
		String crrCdListForSheet = makeComboString(list, 2);
		eventResponse.setETCData("crr_combo_sheet", crrCdListForSheet);
		return eventResponse;
	}

	/**
	 * retrieving Joo Com Ppt Common Code.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchJooComCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		
		if(null != jooCodeParamVO){
			if(StringUtils.isBlank(jooCodeParamVO.getCode())){
				jooCodeParamVO.setCode(JooConstants.KEY_COM_PPT_TPSZ);
			}
			
			List<JooComCodeVO> list = command.searchJooComCodeList(jooCodeParamVO);
			
			StringBuilder sb = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();

			Iterator iterator = (Iterator) list.iterator();
			int iCnt = 0;
			while(iterator.hasNext()){
				JooComCodeVO vo = (JooComCodeVO)iterator.next();
				if(iCnt == 0){
					sb.append(vo.getAttrCtnt1()); // TPSZ Code
					sb2.append(vo.getAttrCtnt2()); // Laden TPSZ Name
					sb3.append(vo.getAttrCtnt3()); // Empth TPSZ Name
				}else{
					sb.append("|"+vo.getAttrCtnt1()); // TPSZ Code
					sb2.append("|"+vo.getAttrCtnt2()); // Laden TPSZ Name
					sb3.append("|"+vo.getAttrCtnt3()); // Empth TPSZ Name
				}
				iCnt++;
			}
			eventResponse.setETCData("tpsz_cd", sb.toString());
			eventResponse.setETCData("tpsz_laden_nm", sb2.toString());
			eventResponse.setETCData("tpsz_empty_nm", sb3.toString());
		}
		
		return eventResponse;
	}

	/**
	 * retrieving Rlane 조회.<br>
	 * @author
	 * @category Common
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRlaneCodeList(Event e) throws EventException {
		JooComEvent event = (JooComEvent)e;
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		// return object creation
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			JooComRlaneVO jooComRlaneVO = (JooComRlaneVO)event.getJooComRlaneVO();
			jooComRlaneVO.setAuthOfcCd(account.getOfc_cd());
			List<JooComRlaneVO> list = command.searchRlaneCodeList(jooComRlaneVO);

			eventResponse.setRsVoList(list);

		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving Rlane 조회.<br>
	 * @author
	 * @category Common
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualCarrierList(Event e) throws EventException {
		JooComEvent event = (JooComEvent)e;
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		// return object creation
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			JooCodeParamVO jooCodeParamVO = (JooCodeParamVO)event.getJooCodeParamVO();
			List<JooComActualCarrierVO> list = command.searchActualCarrierList(jooCodeParamVO);

			eventResponse.setRsVoList(list);

		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	

    /**
     * 공통 Carrier, Trade, lane ComboItem 을 Office 권한으로 조회한다.
     * 2016.07.29 Add
     * 
     * @param  Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchConditionComboItemByAuthOfficeCd(Event e) throws EventException {

        JooComEvent event = (JooComEvent)e;
        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
        //ofc_cd : 화면에서 선택한 Office 입니다.
        
        //String authOfcCd = StringUtils.isEmpty(jooCodeParamVO.getAuthOfcCd()) ? account.getOfc_cd() : jooCodeParamVO.getOfcCd();
        //jooCodeParamVO.setOfcCd(authOfcCd); // 권한 Office 코드.        
        
        //Carrier
        List<JooCodeInfoVO> carrlist   = command.searchCarrierCodeList(jooCodeParamVO);
        String joCrrCdCombo 	= makeComboString(carrlist, 2); //IBCombo, Code만
        
        //Trade 
		List<JooCodeInfoVO> trdList = command.searchTradeCodeList(jooCodeParamVO);
		String trdCdCombo 		= makeComboString(trdList, 2); //IBCombo, Code만
		
        //Lane
		List<JooCodeInfoVO> rlaneList = command.searchRlaneCodeList(jooCodeParamVO);
		String rlaneCdCombo		= makeComboString(rlaneList, 2); //IBCombo, Code만
		
		eventResponse.setETCData("jo_crr_cds"   , joCrrCdCombo);
		eventResponse.setETCData("trd_cds"   	, trdCdCombo);
		eventResponse.setETCData("rlane_cds"  	, rlaneCdCombo);

        return eventResponse;
    }

	/**
	 * retrieving Trade code of carrier in case of changing Carrier Code
	 * 2016.08.01 Add
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTradeCodeByAuthOfficeList(Event e) throws EventException {
		JooComEvent event = (JooComEvent)e;

		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
        //jooCodeParamVO.setOfcCd(  this.account.getOfc_cd() );
		List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * retrieving Rlane_cd by Carrier Code, Trade Code in case of changing Trade
	 * 2016.08.01 Add
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRLaneCodeByAuthOfficeList(Event e) throws EventException {
		JooComEvent event = (JooComEvent)e;

		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		//jooCodeParamVO.setOfcCd( this.account.getOfc_cd()  );
		List<JooCodeInfoVO> list = command.searchRlaneCodeList(jooCodeParamVO);
		eventResponse.setRsVoList( list );
		
		return eventResponse;
	}
}