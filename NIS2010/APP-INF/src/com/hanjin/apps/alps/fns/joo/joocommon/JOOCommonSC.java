/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOCommonSC.java
*@FileTitle : 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.07 박희동
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.01.07 김상수 [소스품질관리] R4J에 도출된 printStackTrace문 수정
*                   - printStackTrace => log.error로 수정
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon;

import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.basic.JOOFileUploadBC;
import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.basic.JOOFileUploadBCImpl;
import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.event.FnsJoo0082Event;
import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.event.FnsJoo0097Event;
import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.event.FnsJoo0098Event;
import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.vo.FileUploadInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.vo.FileUploadListVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBC;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBCImpl;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.event.JooComEvent;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration.JOOFindCodeAndCheckDBDAO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoGrpVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-JOOCommon Business Logic ServiceCommand - ALPS-JOOCommon 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Park Hee Dong
 * @see JOOFindCodeAndCheckDBDAO
 * @since J2EE 1.4
 */

public class JOOCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * JOOCommon system 업무 시나리오 선행작업<br>
	 * JOOCommon업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * JOOCommon system 업무 시나리오 마감작업<br>
	 * JOOCommon 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("JOOCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-JOOCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
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

        // File Upload 관련 : Upload 파일이 한 건인 경우
        if (e.getEventName().equalsIgnoreCase("FnsJoo0097Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchFileUploadInfo(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = manageFileUploadInfo(e);
        	}
        }	
        
        if (e.getEventName().equalsIgnoreCase("FnsJoo0098Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
                eventResponse = searchCsrFileUploadList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCsrFileUpload(e);
            }
		}        
                
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
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
                /* JOO_SLIP의 OFC_CD */
                eventResponse = searchOfcCdSlip(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
                /* Office Code 체크 조회한다. */
                eventResponse = searchOfcCd(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
                /* RLane Code 체크 조회한다. */
                eventResponse = searchRLaneStlOpt3CodeList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
                /* Office Code 체크 조회한다. */
                eventResponse = searchCombinedNoOptAuthList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
                /* VSL+VO 코드 체크  */
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
                eventResponse = searchLaneRegion(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				eventResponse = searchRVslCodeWithoutAuthorityList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
				eventResponse = searchRVpsPortCodeWithoutAuthorityList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH23)) {
				eventResponse = searchVslCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH24)) {
				eventResponse = searchLocCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH25)) {
				eventResponse = searchVslPortSkdCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH26)) {
				eventResponse = searchArVvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH27)) {
				eventResponse = searchVvdPortCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH28)) {
				eventResponse = searchTgtCrrCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH29)) {
				eventResponse = searchUsrInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH30)) {
				eventResponse = searchCarrierListByCsr(e);
			}
		}

		return eventResponse;
	}

	/**
	 * 공통 : Account 입력
	 * Account Code 수기 입력시 validation을 check한다.
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
	 * 공통 : 공통
	 * MDM에서 Trade Code List를 조회한다.
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
	 * 공통 : 공통
	 * MDM에서 Revenue Lane코드를 조회한다.
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
	 * 공통 : 화면 open
	 * Common Code를 조회한다. (사용하지 않음 삭제 예정)
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
	 * 공통 : Customer Code 입력
	 * Customer Code 입력시 Customer Name을 조회한다. (Validation Check를 겸함)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
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
	 * 공통 : Vendor Code 입력
	 * Vendor Code 입력시 Vendor 명을 조회한다. (Validation Check를 겸함)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
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
	 * 공통 : Carrier Code 변경
	 * Carrier Code 변경시 Joo_Carrier 테이블에서 해당 Carrier에 속한 Trade코드를 distinct 로 조회한다.
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
	 * 공통 : Trade Code 변경
	 * Trade변경시 Carrier Code, Trade Code를 조회조건으로 JOO_Carrier 테이블에서 Rlane_cd를 distinct 로 조회한다.
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
	 * 공통 : VVD변경
	 * VVD 수기 입력시 Validation을 체크한다. (VSK_VSL_SKD)
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
	 * 공통 : VVD 입력
	 * VVD 입력시 Rev.Dir과 Basis Port에서 Basic Port(n1st,n2nd,n3rd), Pair Port를 조회한다.
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

		//parameter 정의
		//super_cd1 => rlane_cd
		//super_cd2 => VVD (VSL_CD,SKD_VOY_NO,SKD_DIR_CD 9자리)
		//code      => jo_crr_cd
		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		JooCodeInfoGrpVO grpVO = command.searchRevDirPortList(jooCodeParamVO);
		List<JooCodeInfoVO> list1 = grpVO.getJooCodeInfoVO1s(); //Basic Port List
		List<JooCodeInfoVO> list2 = grpVO.getJooCodeInfoVO2s(); //Pair  Port List
		List<JooCodeInfoVO> list3 = grpVO.getJooCodeInfoVO3s(); //UnitCost Port List

		//select List 정의
		//CODE => PORT
		//NAME => ETA||','||ETD
		//SUPER_CD1 => RLANE_DIR_CD
		//SUPER_CD2 => REVENUE DIRECTION 의 DELT_FLG
		String basicPorts = makeComboString(list1, 7);
		//select List 정의
		//CODE => PORT
		//NAME => ETA||','||ETD
		String pairPorts = makeComboString(list2, 5);

		//select List 정의
		//CODE => PORT
		//NAME => ETD
		String unitPorts = makeComboString(list3, 5);

		eventResponse.setETCData("basicPorts", basicPorts);
		eventResponse.setETCData("pairPorts" , pairPorts);
		eventResponse.setETCData("unitPorts" , unitPorts);
		return eventResponse;
	}

	/**
	 * 공통 : Lane 변경
	 * Vessel Port Schedule 에서 Rlane 변경시 ETA 일자가 100일전 이후 인 Port list를 조회한다.
	 * 조회조건
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

		eventResponse.setETCData("portCode", portCode);
		return eventResponse;
	}

	/**
	 * 공통 : Carrier Code 수기 입력
	 * Carrier Code 수기 입력시 VSK_CARRIER 를 조회하여 Validation을 Check한다.
	 * 조회조건
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
	 * 공통 : 화면 Open
	 * 공동운항에서만 사용하는 Carrier Code 조회
	 * 조회조건
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
	 * 공통 : 화면 Open
	 * 공동운항에서만 사용하는 Carrier Code 조회 (ETC-DATA(String)로 return)
	 * 조회조건
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
	 * 공통 : Lane코드, VVD 입력
	 * Lane코드와 VVD를 조회조건으로 Unit Cost Port를 Vessel Port Schedule에서 읽어온다.
	 * 조회조건
	 *  - super_cd1 : lane code - mandatory
	 *  - super_cd2 : VVD (9자리) - mandatory
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

		//parameter 정의
		//super_cd1 => rlane_cd
		//super_cd2 => VVD (VSL_CD,SKD_VOY_NO,SKD_DIR_CD 9자리)
		//code      => jo_crr_cd
		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchUnitCostPortList(jooCodeParamVO);

		//select List 정의
		//CODE => PORT
		//NAME => ETD
		String unitPorts = makeComboString(list, 5);

		eventResponse.setETCData("unitPorts" , unitPorts);
		return eventResponse;
	}

	/**
	 * 공통 : 공통
	 * List를 combo용 String으로 만들어준다.
	 * @param List<JooCodeInfoVO> list
	 * @param int flg
	 * @return String rtnVal
	 * @throws EventException
	 */
	private String makeComboString(List<JooCodeInfoVO> list, int flg) throws EventException{
		String rtnVal = null;

		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while(iterator.hasNext()){
			JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO)iterator.next();

			//일반적인 IBCombo용(name, code|)
			if (flg==0){
				sb.append(jooCodeInfoVO.getName()+","+jooCodeInfoVO.getCode()+"|");
			//IBCombo (code, code|)
			}else if (flg==1){
				sb.append(jooCodeInfoVO.getCode()+","+jooCodeInfoVO.getCode()+"|");
			//IBSheet의 코드부분(code|)
			}else if (flg==2){
				sb.append(jooCodeInfoVO.getCode()+"|");
			//IBSheet의 코드명부분(name|)
			}else if (flg==3){
				sb.append(jooCodeInfoVO.getName()+"|");
			//SuperCd조회
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
			}else if (flg==10){	//201410  민정호 Approval Step 조회			
				sb.append(jooCodeInfoVO.getApproval()+"|");				
			}
		}

		rtnVal = sb.toString();

		if (rtnVal.length() > 0){
			rtnVal = rtnVal.substring(0,rtnVal.length()-1);
		}

		return rtnVal;
	}


	/**
	 * FNS_JOO_0009, FNS_JOO_0010, FNS_JOO_0011 : Trade 변경
	 * Settlement의 OUS RDR, OUS TDR, Reefer에서 적용할 Lane, RTU, Currency, AUTH_CD 를 조회한다.
	 * 조회조건
	 *  - super_cd1 : Carrier (mandatory)
	 *  - super_cd2 : Trade  (mandatory)
	 *  - code : 정산 ITEM (mandatory)
	 *  - name : 용,대선 구분(re_divr_cd) (mandatory)
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
	 * 공통 : Trade변경
	 * Trade변경시 Rlane과 Financial Matrix의 Currency를 가져온다.
	 * OUS RDR, TDR, Reefer를 제외한 Settlement에서 사용한다.
	 * 조회조건
	 *  - super_cd1 : Carrier (mandatory)
	 *  - super_cd2 : Trade  (mandatory)
	 *  - code : 정산 ITEM (mandatory)
	 *  - name : 용,대선 구분(re_divr_cd) (mandatory)
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
	 * 공통 : Carrier 변경
	 * Carrier 변경시 Trade코드와 JOO_STL_CMB 에서 STL_CMB_SEQ 조회한다.
	 * Trade 조회조건
	 *  - super_cd2 : Carrier (optional)
	 *  - code : trade code
	 * STL_CMB_SEQ 조회조건
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
	 * 공통 : Carrier변경
	 * JOO_STL_CMB 에서 Combined No를 조회한다.
	 * 조회조건
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

/*
 *  10만불 2차 버전		
		String combinedCombo = makeComboString(combinedList, 2);
		String slipCombo     = makeComboString(combinedList, 3);		
		String approvalCombo = makeComboString(combinedList, 10);
		
		eventResponse.setRsVoList(combinedList);
		eventResponse.setETCData("combined_no" ,combinedCombo);
		eventResponse.setETCData("slip_no"     ,slipCombo);
		eventResponse.setETCData("approval"   ,approvalCombo);		
*/
		String combinedCombo = makeComboString(combinedList, 2);
		String slipCombo     = makeComboString(combinedList, 3);		
		
		eventResponse.setRsVoList(combinedList);
		eventResponse.setETCData("combined_no" ,combinedCombo);
		eventResponse.setETCData("slip_no"     ,slipCombo);
				
		return eventResponse;
	}

	/**
	 * 공통 : Carrier변경
	 * Carrier변경시 해당하는 Trade와 Rlane을 동시에 조회한다.
	 * 조회조건
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
	 * 공통 : 시행월변경
	 * 시행월 변경시 해당 시행월이 마감되었는지 여부를 조회한다.
	 * 조회조건
	 *  - super_cd1 : 시행월(exe_yrmon)
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
	 * Trade 변경시 Rlane과 Carrier조회
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
	 * Rlane 변경시 Carrier조회
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
	 * 시행월을 기준으로 추정결과테이블의 MIN, MAX rev_yrmon을 조회한다.
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
	 * 시행월, Revenue month from, to, R/E 을 기준으로 추정결과테이블의 Trade코드리스트를 조회한다.
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
	 * 시행월, Revenue month from, to, R/E, Trade를 기준으로 추정결과테이블의 Revenue Lane 코드리스트를 조회한다.
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
	 * 시행월, Revenue month from, to, R/E, Trade, Rlane를 기준으로 추정결과테이블의 Carrier 코드리스트를 조회한다.
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
     * MDM_VSL_SVC_LANE Rlane 조회한다.
	 *
	 * @param  Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
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
	 * EstmConditionVO list를 IBSheet내에서 사용할 수 있도록 String으로 변환
	 * @param List<EstmConditionVO> list
	 * @param int flg
	 * @return String
	 * @throws EventException
	 */
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
	 * FNS_JOO_0004, FNS_JOO_0005 : Trade Code 변경
	 * Trade변경시 Carrier Code, Trade Code를 조회조건으로 JOO_Carrier 테이블에서 Rlane_cd와 Jo_stl_opt_cd 를 조회한다.
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
     *  파일정보를 조회합니다.<br>
     *
     * @param  FnsJooFileViewEvent e
     * @throws EventException
     * @author jang kang cheol
     * 추가 작업예정 지우지 말것.
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
	 * Cycle인 경우 Rev Dir.을 클릭할 경우 Rev Dir과 Unit Cost Port list를 조회한다.
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

		//parameter 정의
		//super_cd1 => rlane_cd
		//super_cd2 => VVD (VSL_CD,SKD_VOY_NO,SKD_DIR_CD 9자리)
		//code      => jo_crr_cd
		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchRevDirAndUnitCostPortList(jooCodeParamVO);

		String revDirCd = "";
		String deltFlg  = "";
		if (!list.isEmpty()){
			revDirCd = list.get(0).getSuperCd1();
			deltFlg  = list.get(0).getSuperCd2();
		}

		//select List 정의
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
     * JOO_SLIP의 SLP_OFC_CD을 조회한다.
     *
     * @param  Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
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
     * Office Code 체크 조회한다.
     *
     * @param  Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
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
     * Carrier 코드 조회 3자리 조회
     *
     * @param  Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
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
     * FNS_JOO_0062 : 콤보 Focus
     * Combined No를 조회한다.
     *
     * @param  Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
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
     * VSL CODE + VOYAGE NUMBER 조합의 KEY 입력값 valide 체크.
     *
     * @param  Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
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
	 * 공통 : Carrier Code 변경
	 * Carrier Code 변경시 Joo_Carrier 테이블에서 해당 Carrier에 속한 Trade코드를 distinct 로 조회한다.
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
	 * 공통 : Trade Code 변경
	 * Trade변경시 Carrier Code, Trade Code를 조회조건으로 JOO_Carrier 테이블에서 Rlane_cd를 distinct 로 조회한다.
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
	 * 공통 : Trade Code 변경
	 * Trade변경시 Carrier Code, Trade Code를 조회조건으로 JOO_Carrier 테이블에서 Rlane_cd를 distinct 로 조회한다.
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
	 * File Upload 조회<br>
	 * @author 이준범
	 * @category FNS_JOO_0082
	 * @category searchFileUploadList
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFileUploadList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
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

	// ---------------------------------------------------------------------------
	// [FNS_JOO_0082] File Upload
	// ---------------------------------------------------------------------------
	/**
	 * File Upload 수정 ,입력<br>
	 * @author 이준범
	 * @category FNS_JOO_0082
	 * @category manageFileUpload
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFileUpload(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			begin();

			// BC 객체 생성
			JOOFileUploadBC command = new JOOFileUploadBCImpl();

			FnsJoo0082Event event = (FnsJoo0082Event)e;

			FileUploadListVO[] fileUploadListVOs = event.getFileUploadListVOs();
			FileUploadListVO vo = fileUploadListVOs[0];

			vo.setUpdUsrId(account.getUsr_id());

			command.manageFileUpload(fileUploadListVOs);

			// 성공 메세지설정
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
	 * File Upload 조회<br>
	 * @author 민정호
	 * @category FNS_JOO_0098
	 * @category searchCsrFileUploadList
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCsrFileUploadList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			JOOFileUploadBC command = new JOOFileUploadBCImpl();

			FnsJoo0098Event event = (FnsJoo0098Event)e;

			String csrNo = event.getCsrNo();

//			String fileSeq = event.getFileSeq();

			List<FileUploadListVO> list =
				command.searchCsrFileUploadList(csrNo);

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
	
	// ---------------------------------------------------------------------------
	// [FNS_JOO_0098] File Upload
	// ---------------------------------------------------------------------------
	/**
	 * File Upload 수정 ,입력<br>
	 * @author 민정호
	 * @category FNS_JOO_0098
	 * @category manageCsrFileUpload
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCsrFileUpload(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			begin();

			// BC 객체 생성
			JOOFileUploadBC command = new JOOFileUploadBCImpl();

			FnsJoo0098Event event = (FnsJoo0098Event)e;

			FileUploadListVO[] fileUploadListVOs = event.getFileUploadListVOs();
			FileUploadListVO vo = fileUploadListVOs[0];

			vo.setUpdUsrId(account.getUsr_id());

			command.manageCsrFileUpload(fileUploadListVOs);

			// 성공 메세지설정
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
	 * 공통 : 공통
	 * MDM에서 RHQ 코드를 조회한다.
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
	 * 공통 : Carrier Code 변경
	 * Lane Code 변경시 Joo_Carrier 테이블에서 해당 Carrier에 속한 Carrier코드를 distinct 로 조회한다.
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
	 * Integrated Loading Summary Report
     * VVD code를 파라미터로 입력하여 Lane과 Region를 조회한다.
	 *
	 * @param  Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author kim young oh
	 */	
	
   private EventResponse searchLaneRegion(Event e) throws EventException {
       JOOFindCodeAndCheckBC command      = new JOOFindCodeAndCheckBCImpl();
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       JooComEvent event                  = (JooComEvent)e;
       JooCodeParamVO jooCodeParamVO      = event.getJooCodeParamVO();
       jooCodeParamVO.setOfcCd(  this.account.getOfc_cd() );
       List<JooCodeInfoVO> list           = command.searchLaneRegion(jooCodeParamVO);

       eventResponse.setRsVoList( list );
       return eventResponse;
   }
   


	/**
	 * 공통 : Lane Code 변경
	 * Lane변경시 Lane Code, Trade Code를 조회조건으로 VSK_VSL_PORT_SKD, MDM_REV_LANE 테이블에서 vsl_cd를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRVslCodeWithoutAuthorityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchRVslCodeWithoutAuthorityList(jooCodeParamVO);
		eventResponse.setRsVoList( list );
		String comboList = makeComboString(list, 1);
		String comboListSheet = makeComboString(list, 2);
		eventResponse.setETCData("vsl_cd" ,comboList);
		eventResponse.setETCData("vsl_combo_sheet" ,comboListSheet);
		return eventResponse;
	}
	

	/**
	 * 공통 : Lane Code 변경
	 * Lane변경시 Lane Code, Trade Code, Vsl Code를 조회조건으로 VSK_VSL_PORT_SKD, MDM_REV_LANE 테이블에서 VPS_PORT_CD를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRVpsPortCodeWithoutAuthorityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchRVpsPortCodeWithoutAuthorityList(jooCodeParamVO);
		eventResponse.setRsVoList( list );
		String comboList = makeComboString(list, 1);
		String comboListSheet = makeComboString(list, 2);
		eventResponse.setETCData("vpsport_cd" ,comboList);
		eventResponse.setETCData("vpsport_combo_sheet" ,comboListSheet);
		return eventResponse;
	}
	
	
	
	
	
	

	/**
	 * BSA Information Entry 공통 MDM_VSL_CNTR 테이블에서 VSL_CD 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVslCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchVslCodeList(jooCodeParamVO);
		
        String result = "N";
        if (list.isEmpty()){
        	result = "E";
        }
        eventResponse.setETCData("RESULT", result);		
		return eventResponse;
	}

	/**
	 * BSA Information Entry 공통 MDM_LOCATION 테이블에서 LOC_CD 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLocCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchLocCodeList(jooCodeParamVO);
		
        String result = "N";
        if (list.isEmpty()){
        	result = "E";
        }
        eventResponse.setETCData("RESULT", result);
		return eventResponse;
	}

	/**
	 * BSA Information Entry 공통 VSK_VSL_PORT_SKD 테이블에서 VSL_CD 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVslPortSkdCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchVslPortSkdCodeList(jooCodeParamVO);
		
        String result = "N";
        if (list.isEmpty()){
        	result = "E";
        }
        eventResponse.setETCData("RESULT", result);
		return eventResponse;
	}

	/**
	 * Blank Voyage Status 공통 AR_MST_REV_VVD 테이블에서 Voyage 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchArVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchArVvd(jooCodeParamVO);
		
        String result = "N";
        if (list.isEmpty()){
        	result = "E";
        }
        eventResponse.setETCData("RESULT", result);
		return eventResponse;
	}

	/**
	 * File Upload 조회<br>
	 * @author 김현주
	 * @category FNS_JOO_0097
	 * @category searchFileUploadInfo
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFileUploadInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			JOOFileUploadBC command = new JOOFileUploadBCImpl();
			FnsJoo0097Event event = (FnsJoo0097Event)e;
			FileUploadInfoVO fileUploadInfoVO = event.getFileUploadInfoVO();
			
			List<FileUploadInfoVO> list = command.searchFileUploadInfo(fileUploadInfoVO);
			eventResponse.setRsVoList( list );
	        
			String result = "N";
	        if (list.isEmpty()){
	        	result = "E";
	        }
	        eventResponse.setETCData("RESULT", result);

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
	 * File Upload info 수정 ,입력<br>
	 * @author 김현주
	 * @category FNS_JOO_00897
	 * @category manageFileUpload
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFileUploadInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String saveId=null;
		
		try {

			begin();
			
			// BC 객체 생성
			JOOFileUploadBC command = new JOOFileUploadBCImpl();

			FnsJoo0097Event event = (FnsJoo0097Event)e;

			FileUploadInfoVO[] fileUploadInfoVOs = event.getFileUploadInfoVOs();
			FileUploadInfoVO vo = fileUploadInfoVOs[0];

			vo.setUpdUsrId(account.getUsr_id());

			saveId = command.manageFileUploadInfo(fileUploadInfoVOs);

			// 성공 메세지설정
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			eventResponse.setETCData("ERROR_YN", "N");
  			if (saveId == null||"".equals(saveId)){
				saveId = " ";
			}
			eventResponse.setETCData("SAVE_ID", saveId);
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
	 * Additional Slot Manager 공통 VSK_VSL_PORT_SKD 테이블에서 Vvd, Port 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVvdPortCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchVvdPortCodeList(jooCodeParamVO);
		
        String result = "N";
        if (list.isEmpty()){
        	result = "E";
        }
        eventResponse.setETCData("RESULT", result);
		return eventResponse;
	}
	
	
	/**
	 * Settlement Target에서 Carrier Code를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTgtCrrCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
        jooCodeParamVO.setOfcCd(  this.account.getOfc_cd() );
		List<JooCodeInfoVO> list = command.searchTgtCrrCodeList(jooCodeParamVO);
		eventResponse.setRsVoList(list);
		return eventResponse;
	}	
	
	/**
	 * Additional Slot Manager 공통 COM_USER에서 user정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUsrInfo(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchUsrInfo(jooCodeParamVO);
		
		String result = "N";
		String name = "";
        if (list.isEmpty()){
        	result = "E";
        }else{
        	name = list.get(0).getName(); 
        }
		
		eventResponse.setETCData("RESULT",result);
		eventResponse.setETCData("NAME",name);
		return eventResponse;
	}
	
	/**
	 * CSR List Inquiry JOO_STL_CMB 테이블에서 JO_CRR_CD 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCarrierListByCsr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JooComEvent event = (JooComEvent)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		SlipConditionVO slipConditionVO = event.getSlipConditionVO();
		List<JooCodeInfoVO> list = command.searchCarrierListByCsr(slipConditionVO);
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
}