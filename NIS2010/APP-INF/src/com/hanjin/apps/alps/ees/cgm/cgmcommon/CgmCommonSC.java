/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CgmCommonSC.java
 *@FileTitle : CgmCodeMgt
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.08.03
 *@LastModifier : 김상수
 *@LastVersion : 1.32
 *
 * 2009.05.12 김창식
 *     1.0 Creation
 *
 * 2010.08.03 김상수
 *     [CHM-201004960-01] Genset Ineventory Logic error 수정건
 *         : [EES_CGM_1113] UI에 RCC멀티콤보 기능 및 조회조건 추가 by 김상수
 *
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBC;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBCImpl;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.event.CgmComEvent;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.event.EesCgm1201Event;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.event.EesCgm1206Event;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.event.EesCgm1209Event;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.event.EesCgm1210Event;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration.CgmCodeMgtDBDAO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSCHSSPoolMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSScExptListINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSScExptListMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ChssSCExceptionGRPVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ChssScExceptionHisVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ChssScExceptionVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionCommodityVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionCustomerVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CHSSSCExceptionVersionVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.basic.CgmValidationBC;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.basic.CgmValidationBCImpl;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event.CgmAgreementEvent;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event.CgmCheckLocationEvent;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event.CgmChsMasterEvent;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event.CgmChssPoolEvent;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event.CgmCurrencyEvent;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event.CgmMdmVendorEvent;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event.CgmMstContainerEvent;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event.CgmTpszEvent;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event.CgmValidationEvent;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event.CgmYardEvent;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.AgrementMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.CgmChssPoolMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.ChsMasterMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.LocationMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.MdmCurrencyMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.MdmVendorMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.OfficeMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.TpSzDupChkMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.YardMGTVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-CgmCommon Business Logic ServiceCommand - ALPS-CgmCommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author KIM CHANG SIK
 * @see CgmCodeMgtDBDAO
 * @since J2EE 1.4
 */

public class CgmCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null; 

	/**
	 * CgmCommon system 업무 시나리오 선행작업<br> 
	 * CgmCodeMgt업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CgmCommon system 업무 시나리오 마감작업<br>
	 * CgmCodeMgt 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CgmCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-CgmCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		try
		{
			// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
			if (e.getEventName().equalsIgnoreCase("CgmComEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					// Common Code 조회
					eventResponse = searchCommonCodeListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					// IBCombo Agreement No에 해당하는 Pool List 조회
					eventResponse = searchAgreementByPoolService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					// IBCombo Pool List 조회
					eventResponse = searchPoolListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					// IBCOMBO - Spec No
					eventResponse = searchSpecListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
					// IBCOMBO - Chassis Type/Size
					eventResponse = searchEqTpszListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
					// IBCOMBO - Manufacturer Type/Size
					eventResponse = searchManuListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
					// M.G Set No 조회(EES_CGM_2001)
					eventResponse = searchMgsetNoFindService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
					// Vendor Code 조회
					eventResponse = searchVendorCodeListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
					// Chassis No 조회(EES_CGM_1006)
					eventResponse = searchStateCodeListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
					// M.G Set No 조회(EES_CGM_1006)
					eventResponse = searchOrganizationService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
					// Cert Chassis No조회(EES_CGM_1005)
					eventResponse = searchCertChassisListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
					// Financing Co조회(EES_CGM_1005)
					eventResponse = searchFinancingCoService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
					eventResponse = searchAgreementMainService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
					eventResponse = searchMovementStatusListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
					eventResponse = searchNuPoolListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
					// DATE로 WEEK, FMDAY-TODAY 조회
					eventResponse = searchWeekFmToDateService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
					// YEAR-WEEKL로 WEEK, FMDAY-TODAY 조회
					eventResponse = searchWeekFmToDateByWeekService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
					// RCC, LCC, SCC 체크
					eventResponse = searchEqOrzChtService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
					// Cost Office Code 조회
					eventResponse = searchCostOfficeService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
					// Invoice Service Provider 조회
					eventResponse = searchInvSerProviderService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
					// Invoice Service Provider 조회
					eventResponse = searchLocalTimeByOfficeService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
					// Cps Pool Code & Name 조회
					eventResponse = searchCPSPoolCodeListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
					eventResponse = searchCustomerNameService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmValidationEvent")) {
				// Office Code Validation 체크 
				if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = checkOfficeService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmYardEvent")) {
				// ya_cd Code Validation 체크 
				if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = checkYardService(e);	// noraml
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmAgreementEvent")) {
				// ya_cd Code Validation 체크 
				if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = checkAgreementService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmChsMasterEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCGMMasterService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmMdmVendorEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchVendorListService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmTpszEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchEqTpSzDupChkService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmMstContainerEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCNTRMasterService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmCheckLocationEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = checkLocationService(e);
				} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchOfficeYardControlOfficeMatchService(e);
				} 
			}  else if (e.getEventName().equalsIgnoreCase("CgmChssPoolEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchChssPoolListService(e);
				}
			}  else if (e.getEventName().equalsIgnoreCase("CgmCurrencyEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMDMCurrencyService(e);
				}
			}else if (e.getEventName().equalsIgnoreCase("CgmFileUploadEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = manageFileUploadService(e);
				}
					
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1201Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCPSScExptListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = checkCPSScExptCustNameService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = checkCPSScExptListSccService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					eventResponse = checkCPSScExptListDupService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
					eventResponse = checkCPSScExptGroupCustNameService(e);
				}  else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCPSScExptListService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1206Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCPSCHSSPoolService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = checkCPSCHSSPoolCodeDupService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = checkCPSCHSSPoolVndrNameService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					eventResponse = searchCPSCHSSPoolListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCPSCHSSPoolService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchCPSCHSSPoolListService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1209Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchSCExceptionService(e);
				}

				else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchSCVersionByProposalNoService(e);
				}

				else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
					eventResponse = removeSCExceptionByVerService(e);
				}			

				else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
					eventResponse = checkFiledBySCService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
					eventResponse = modifyVersionSTSService(e);
				}

				//화면에서 입력한 PROP_NO에 대한 CUSTOMER 정보가 중복인지 조회한다.
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
					eventResponse = isCustomerByPriMnService(e);
				}
				//페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회한다.
				else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = searchSCInitControlService(e);
				}

				//Update 버튼 클릭시 'Live'상태의 S/C Exception 정보를 새로운 버전으로 생성한다.
				else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = createSCExceptionByUpdateService(e);
				}
				//S/C Exception History 팝업화면에서 Copy 버튼 클릭시 현재 버전에 있는 정보를 삭제하고 현재 버전에 선택한 버전의 정보로  생성한다.
				else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
					eventResponse = createSCExceptionByHistoryCopyService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = modifySCExceptionService(e);
				}else if(e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
					eventResponse = searchCommodityNameService(e);
		        }
			}else if (e.getEventName().equalsIgnoreCase("EesCgm1210Event")) {
				//1.S/C Exception History By S/C No.
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchSCExceptionListByPropNoService(e);
				}
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 *  [Retrieve] <br>
	 *  Pool Code에속한 경우가 없는경우의 Agreement 정보를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementByPoolService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchAgreementByPoolBasic(event.getComboINVO());
			
			StringBuffer comboList = new StringBuffer("");
			 
			for(int i=0; i<list.size(); i++){
				ComboMGTVO comboMGTVO = (ComboMGTVO)list.get(i);
				
				String agmtOfcCtyCd = comboMGTVO.getCode1();
				String agmtSeq 		= "000000" +  comboMGTVO.getCode2();
				String agmtNo 		= agmtOfcCtyCd + agmtSeq.substring(agmtSeq.length()-6);
				String agmtRefNo 	= comboMGTVO.getCode3();
				String vndrSeq		= comboMGTVO.getCode4();
				String vndrNm		= comboMGTVO.getDesc4();
				String chssPoolCd	= comboMGTVO.getCode5();	
				String currCd 		= comboMGTVO.getCode6();
				
				comboList.append(agmtNo + "|" + vndrSeq + "|" + vndrNm + "|" + currCd + "|" + chssPoolCd + "|" + agmtRefNo);
				if(i < list.size()-1) comboList.append("@");
			}
				
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  Chassis Pool 로 등록된 리스트를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPoolListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchPoolListBasic(event.getComboINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 *  [Retrieve] <br>
	 *  CGM_EQ_SPEC 테이블에서 Spec No 리스트를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchSpecListBasic(event.getComboINVO());
	
			StringBuffer comboList = new StringBuffer("");
			StringBuffer comboList1002 = new StringBuffer("");
			for(int i=0; i<list.size(); i++){
				ComboMGTVO comboMGTVO = (ComboMGTVO)list.get(i);
				
				String eqSpecCd = comboMGTVO.getCode1();	
				String eqSpecNm = comboMGTVO.getDesc1();
				String eqTpsz = comboMGTVO.getDesc2();
				comboList.append(eqSpecCd + "|" + eqSpecNm);
				comboList1002.append(eqSpecCd + "|" + eqTpsz);
				if(i < list.size()-1) 
				{
					comboList.append("@");
					comboList1002.append("@");
				}
			}
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());
			eventResponse.setETCData("comboList1002", comboList1002.toString());
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 *  [Retrieve] <br>
	 *  Chassis ,M.G.Set 의 Type Size 목록을 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqTpszListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchEqTpszListBasic(event.getComboINVO());
	
			StringBuffer comboList = new StringBuffer("");
	
			for(int i=0; i<list.size(); i++){
				ComboMGTVO comboMGTVO = (ComboMGTVO)list.get(i);
				
				String eqTpszCd = comboMGTVO.getCode1();	
				String eqTpszNm = comboMGTVO.getDesc1();
				
				comboList.append(eqTpszCd + "|" + eqTpszNm);
				if(i < list.size()-1) comboList.append("@");
			}
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());
	
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 *  [Retrieve] <br>
	 *  MDM 테이블에서 Manufacture List를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManuListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchManuListBasic(event.getComboINVO());
	
			StringBuffer comboList = new StringBuffer("");
	
			for(int i=0; i<list.size(); i++){
				ComboMGTVO comboMGTVO = (ComboMGTVO)list.get(i);
				
				String eqManuCd = comboMGTVO.getCode1();	
				String eqManuNm = comboMGTVO.getDesc1();
				
				comboList.append(eqManuCd + "|" + eqManuNm);
				if(i < list.size()-1) comboList.append("@");
			}
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());
	
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 *  [Retrieve] <br>
	 *  M.G.Set Spec No에 해당하는 Lot No 리스트를 가져온다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMgsetNoFindService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchMgsetNoFindBasic(event.getComboINVO());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			//ETCDATA ->> MGTVO 
			eventResponse.setRsVoList(list);
			//eventResponse.setETCData("comboList", comboList.toString());
	
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 *  [Retrieve] <br>
	 *  Location Code가 유효한지 체크한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocationService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmCheckLocationEvent event = (CgmCheckLocationEvent)e;
			CgmValidationBC command = new CgmValidationBCImpl();
			
			List<LocationMGTVO> list = command.checkLocationBasic(event.getLocationMGTVO());
			log.debug("======================================================"+list.size());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			//ETCDATA ->> MGTVO 
	//		eventResponse.setRsVoList(list);
			@SuppressWarnings("unused")
			String checkResult = "FALSE";
			if(list != null){
				if(list.size() > 0){
					checkResult = "TRUE";
				}
			}
			if(list != null){
				eventResponse.setRsVoList(list);
			}
	//		eventResponse.setETCData("checkResult", checkResult);
	
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}			
	}
	
	/**
	 *  [Retrieve] <br>
	 *  공통코드 테이블에서 넘어온 코드값을 받아 공통코드 리스트를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonCodeListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchCommonCodeListBasic(event.getComboINVO());
			
			StringBuffer comboList = new StringBuffer("");
			 
			for(int i=0; i<list.size(); i++){
				ComboMGTVO comboMGTVO = (ComboMGTVO)list.get(i);
				
				String code = comboMGTVO.getCode1();
				String name	= comboMGTVO.getDesc1();
				
				comboList.append(code + "|" + name);
				if(i < list.size()-1) comboList.append("@");
			}
				
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  MDM_VENDOR 테이블에서 Vendor Code 및 Name 을 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorCodeListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchVendorCodeListBasic(event.getComboINVO());
			
			StringBuffer code = new StringBuffer("");
			StringBuffer text = new StringBuffer("");
			StringBuffer code2 = new StringBuffer("");
			StringBuffer code3 = new StringBuffer("");
			 
			for(int i=0; i<list.size(); i++){
				ComboMGTVO comboMGTVO = (ComboMGTVO)list.get(i);
				
				code.append(comboMGTVO.getCode1());
				text.append(comboMGTVO.getDesc1());
				code2.append(comboMGTVO.getCode2());
				code3.append(comboMGTVO.getCode3());
				
				if(i < list.size()-1) {
					code.append("|");
					text.append("|");
					code2.append("|");
					code3.append("|");
				}
			}
				
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("code", code.toString());
			eventResponse.setETCData("text", text.toString());
			eventResponse.setETCData("gen_pay_term_cd", code2.toString());
			eventResponse.setETCData("pay_curr_cd", code3.toString());
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  Office Code가 유효한지 체크한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkOfficeService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmValidationEvent event = (CgmValidationEvent)e;
			CgmValidationBC command = new CgmValidationBCImpl();
			List<OfficeMGTVO> list = command.checkOfficeBasic(event.getOfficeINVO());
			String rhqCd = "";
			String checkResult = "FALSE";
			if(list != null){
				if(list.size() > 0){
					checkResult = "TRUE";
					rhqCd = list.get(0).getRhqCd();
				}
			}
			
			eventResponse.setETCData("checkResult", checkResult);
			eventResponse.setETCData("rhq_cd", rhqCd);
	
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  Yard Code가 유효한지 체크한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkYardService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmYardEvent event = (CgmYardEvent)e;
			CgmValidationBC command = new CgmValidationBCImpl();
			
			List<YardMGTVO> list = null;
			
			if(event.getCgmYardINVO().getChkVer().equals("ver2"))
			{
				list = command.checkYardAvailableYardBasic(event.getCgmYardINVO());
			}else
			{
				list = command.checkYardBasic(event.getCgmYardINVO());	// noraml
			}
	
			String checkResult = "FALSE";
			if(list != null){
				if(list.size() > 0){
					checkResult = "TRUE";
				}
			}
			eventResponse.setETCData("checkResult", checkResult);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  MDM_STATE 테이블에서 미주지역의 State 정보를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStateCodeListService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchStateCodeListBasic(event.getComboINVO());
	
			//ETCDATA ->> MGTVO 
			eventResponse.setRsVoList(list);
	
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  MDM_ORGANIZATION 테이블 정보를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOrganizationService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			MdmOrganizationMGTVO mdmOrganizationMGTVO  = command.searchOrganizationBasic(event.getMdmOranizationINVO());
	
			// ETC DATA 설정
			eventResponse.setETCData((Map<String,String>)mdmOrganizationMGTVO.getColumnValues());
	
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  Agreement 정보가 등록되어 있는지 체크한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkAgreementService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters) 
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmAgreementEvent event = (CgmAgreementEvent)e;
			CgmValidationBC command = new CgmValidationBCImpl();
			log.debug("checkAgreementService====================222222222222222222222222222======");
			List<AgrementMGTVO> list = command.checkAgreementBasic(event.getAgrementINVO());
			log.debug("checkAgreementService");
			String checkResult = "FALSE";
			if(list != null){
				if(list.size() > 0){
					checkResult = "TRUE";
					AgrementMGTVO  tmp = new AgrementMGTVO();
					tmp = list.get(0);
					checkResult = tmp.getAgmtOfcCtyCd() + tmp.getAgmtSeq();
				}
			}
			
			eventResponse.setETCData("checkResult", checkResult);
	
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  EQ_LOT_NO 테이블의 lot No를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCertChassisListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchCertChassisListBasic(event.getComboINVO());
	
			StringBuffer comboList = new StringBuffer("");
	
			for(int i=0; i<list.size(); i++){
				ComboMGTVO comboMGTVO = (ComboMGTVO)list.get(i);
				
				String eqCertCd = comboMGTVO.getCode1();	
				String eqCertNm = comboMGTVO.getDesc1();
				
				comboList.append(eqCertCd + "|" + eqCertNm);
				if(i < list.size()-1) comboList.append("@");
			}
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());
	
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 *  [Retrieve] <br>
	 *  MDM 테이블에서 Financing Company리스트를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFinancingCoService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchFinancingCoBasic(event.getComboINVO());
	
			StringBuffer comboList = new StringBuffer("");
	
			for(int i=0; i<list.size(); i++){
				ComboMGTVO comboMGTVO = (ComboMGTVO)list.get(i);
				
				String eqFinaCd = comboMGTVO.getCode1();	
				String eqFinaNm = comboMGTVO.getDesc1();
				
				comboList.append(eqFinaCd + "|" + eqFinaNm);
				if(i < list.size()-1) comboList.append("@");
			}
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());
	
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  Agreement No가 유효한지 체크한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementMainService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<AgreementMGTVO> responseData  = command.searchAgreementMainBasic(event.getAgreementINVO());
	
			eventResponse.setRsVoList(responseData);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  CGM EQUIPMENT 테이블로부터  Chassis 마스터 정보를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCGMMasterService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			// PDTO(Data Transfer Object including Parameters) 
			CgmChsMasterEvent event = (CgmChsMasterEvent)e;
			CgmValidationBC command = new CgmValidationBCImpl();
			
			List<ChsMasterMGTVO> responseData = command.searchCGMMasterBasic(event.getChsMasterMGTVO());
	 
			// VO Data 설정 ==> 데이터가 존재하는지 알기 위해
			eventResponse.setRsVoList(responseData);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 *  [Retrieve] <br>
	 *  DM_VENDOR 테이블에서 Vendor 정보 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorListService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			// PDTO(Data Transfer Object including Parameters) 
			CgmMdmVendorEvent event = (CgmMdmVendorEvent)e;
			CgmValidationBC command = new CgmValidationBCImpl();
			
			List<MdmVendorMGTVO> responseData = command.searchVendorListBasic(event.getMdmVendorMGTVO());
	 
			eventResponse.setRsVoList(responseData);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  CGM_EQ_TP_SZ 테이블로부터  정보를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqTpSzDupChkService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmTpszEvent event = (CgmTpszEvent)e;
			CgmValidationBC command = new CgmValidationBCImpl();
			List<TpSzDupChkMGTVO> list = command.searchEqTpSzDupChkBasic(event.getTpSzDupChkINVO());
			log.debug("####### checkTpszService #######");
			String checkResult = "FALSE";
			if(list != null){
				if(list.size() > 0){
					checkResult = "TRUE";
				}
			}
			
			eventResponse.setETCData("checkResult", checkResult);
	
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 *  [Retrieve] <br>
	 *  MST_CONTAINER 정보를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCNTRMasterService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			// PDTO(Data Transfer Object including Parameters) 
			CgmMstContainerEvent event = (CgmMstContainerEvent)e;
			CgmValidationBC command = new CgmValidationBCImpl();
			
			List<ChsMasterMGTVO>  tmpMGTVO = command.searchCNTRMasterBasic(event.getChsMasterMGTVO());
	 
			// VO Data 설정 ==> 데이터가 존재하는지 알기 위해
			eventResponse.setRsVoList(tmpMGTVO);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  MDM_MVMT_STS 테이블 정보를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMovementStatusListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchMovementStatusListBasic(event.getComboINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	
	/**
	 *  [Retrieve] <br>
	 *  CGM_CHSS_POOL 테이블 정보를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChssPoolListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmChssPoolEvent event = (CgmChssPoolEvent)e;
			CgmValidationBC command = new CgmValidationBCImpl();
			List<CgmChssPoolMGTVO> list = command.seachChssPoolListBasic(event.getCgmChssPoolINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  Chassis Nutural Pool 로 등록된 리스트를 조회한다.. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchNuPoolListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchNuPoolListBasic(event.getComboINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  WEEK와 해당하는 FROM DATE, TO DATE 를 조회한다.. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchWeekFmToDateService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchWeekFmToDateBasic(event.getComboINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 *  [Retrieve] <br>
	 *  WEEK와 해당하는 FROM DATE, TO DATE 를 조회한다.. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchWeekFmToDateByWeekService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchWeekFmToDateByWeekBasic(event.getComboINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}	
	
	
	/**
	 *  [Retrieve] <br>
	 *  RCC,LCC,SCC 조회 및 Validation 체크.. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchEqOrzChtService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			EqOrzChtINVO eqOrzChtINVO = event.getEqOrzChtINVO();
			List<EqOrzChtMGTVO> list = command.searchEqOrzChtBasic(eqOrzChtINVO);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			// RCC로 LCC목록 조회이거나 LCC로 SCC목록 조회일 경우는 멀티콤보용 리스트를 함께 리턴한다 (중복은 제외시킨다).
			String eqOrzChtChktype = eqOrzChtINVO.getEqOrzChtChktype();
			if ("RCC".equals(eqOrzChtChktype) || "RCCLCC".equals(eqOrzChtChktype) || "LCCSCC".equals(eqOrzChtChktype)) {
				StringBuffer comboList = new StringBuffer("");
				for (int i=0; i<list.size(); i++) {
					String currCode = "";
					if ("RCC".equals(eqOrzChtChktype)) {
						currCode = list.get(i).getEqOrzChtRccCd();
					} else if ("RCCLCC".equals(eqOrzChtChktype)) {
						currCode = list.get(i).getEqOrzChtLccCd();
					} else if ("LCCSCC".equals(eqOrzChtChktype)) {
						currCode = list.get(i).getEqOrzChtSccCd();
					}
					if (i > 0)comboList.append("@");
					comboList.append(currCode + "|" + currCode);
				}
				eventResponse.setETCData("comboList", comboList.toString());
			}

			return eventResponse;

		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}	
		
	/**
	 *  [Retrieve] <br>
	 *  MDM_CURRENCY 테이블 정보를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMDMCurrencyService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmCurrencyEvent event = (CgmCurrencyEvent)e;
			CgmValidationBC command = new CgmValidationBCImpl();
			List<MdmCurrencyMGTVO> list = command.searchMDMCurrencyBasic(event.getMdmCurrencyMGTVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  Cost Office Code 를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostOfficeService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchCostOfficeBasic(event.getComboINVO());
			
			String costOfficeCode = "";
			if(list != null){
				ComboMGTVO comboMGTVO = (ComboMGTVO)list.get(0);
				costOfficeCode = comboMGTVO.getCode1();
			}
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("ofc_cd", costOfficeCode);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  Invoice Service Provider 를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvSerProviderService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchInvSerProviderBasic(event.getComboINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  Invoice Service Provider 를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalTimeByOfficeService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchLocalTimeByOfficeBasic(event.getComboINVO());
			
			String localDate = "";
			if(list != null){
				ComboMGTVO comboMGTVO = (ComboMGTVO)list.get(0);
				localDate = comboMGTVO.getCode1();
			}
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setETCData("local_date", localDate);
			if(list != null){
				eventResponse.setRsVoList(list);
			}
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * EES_LSE_0008 : 파일 업로드 이벤트 처리<br>
	 * 파일 업로드의 event에 대한 처리<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse manageFileUploadService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			String strFileName = "";
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			List<String> keys = (List<String>)e.getAttribute("KEYS");
			//log.debug("=============>>>>>>>>>>>>>>>> [LseCommonSC] keys.size() : " + keys.size());
			strFileName = keys.get(0);
			/*
			for ( int i = 0 ; i < keys.size(); i++ ) {
				if ( strFileName.equals("") ) {
					strFileName = keys.get(i);
				} else {
					strFileName = strFileName + "|" + keys.get(i);
				}
			}
			*/
			//log.debug("=============>>>>>>>>>>>>>>>> [LseCommonSC] strFileName : " + strFileName);
			eventResponse.setETCData("filename", strFileName);
	
			return eventResponse;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  Location Code가 유효한지 체크한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeYardControlOfficeMatchService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmCheckLocationEvent event = (CgmCheckLocationEvent)e;
			CgmValidationBC command = new CgmValidationBCImpl();
			
			List<LocationMGTVO> list = command.searchOfficeYardControlOfficeMatchBasic(event.getLocationMGTVO());
			log.debug("======================================================"+list.size());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(list);
	//		eventResponse.setETCData("checkResult", checkResult);
	
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Retrieve] <br>
	 *  S/C Exception으로 등록된 리스트를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCPSScExptListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1201Event event = (EesCgm1201Event)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<CPSScExptListMGTVO> list = command.searchCPSScExptListBasic(event.getCpsScExptListINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  입력된 Customer Code로부터 Customer Name을 체크한다. <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCPSScExptCustNameService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1201Event event = (EesCgm1201Event)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			String custNm = "";
			custNm = command.checkCPSScExptCustNameBasic(event.getCpsScExptListINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("cust_nm", custNm);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  입력된 SCC가 유효한 값인지 체크한다. <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCPSScExptListSccService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1201Event event = (EesCgm1201Event)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			String sccCd = "";
			sccCd = command.checkCPSScExptListSccBasic(event.getCpsScExptListINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("scc_cd", sccCd);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  입력된 SC NO., E.Month, SCC로부터 중복을 체크한다. <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCPSScExptListDupService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1201Event event = (EesCgm1201Event)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			String chkDup = command.checkCPSScExptListDupBasic(event.getCpsScExptListINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("chk_dup", chkDup);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  입력된 Group Customer Code로부터 Group Customer Name을 체크한다. <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCPSScExptGroupCustNameService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1201Event event = (EesCgm1201Event)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			String custGrpNm = "";
			custGrpNm = command.checkCPSScExptGroupCustNameBasic(event.getCpsScExptListINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("cust_grp_nm", custGrpNm);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Save] <br>
	 *  S/C Exception List를 입력하거나 수정한다. Save <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCPSScExptListService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<CPSScExptListINVO> retVoList = new ArrayList<CPSScExptListINVO>();
		EesCgm1201Event event = (EesCgm1201Event)e;
		CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
		try{
			begin();
			retVoList = command.manageCPSScExptListBasic (event.getCpsScExptListINVOS(),account);
			commit();
			eventResponse.setRsVoList(retVoList);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 *  [Retrieve] <br>
	 *  CPS Neutral Pool로 등록된 업체를 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCPSCHSSPoolService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1206Event event = (EesCgm1206Event)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<CPSCHSSPoolMGTVO> list = command.searchCPSCHSSPoolBasic(event.getCpsCHSSPoolINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_1206] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCPSCHSSPoolListService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			ComboINVO comboINVO = new ComboINVO();

			List<ComboMGTVO> list = command.searchCPSCHSSPoolListBasic(comboINVO);
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  입력된 Pool Code의 중복을 체크한다. <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCPSCHSSPoolCodeDupService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1206Event event = (EesCgm1206Event)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			String poolCd = "";
			
			poolCd = command.checkCPSCHSSPoolCodeDupBasic(event.getCpsCHSSPoolINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("pool_cd", poolCd);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  입력된 Vendor Code로부터 Vendor Name을 체크한다. <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCPSCHSSPoolVndrNameService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1206Event event = (EesCgm1206Event)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			String vndrNm = "";
			vndrNm = command.checkCPSCHSSPoolVndrNameBasic(event.getCpsCHSSPoolINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("vndr_nm", vndrNm);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  [Save] <br>
	 *  CPS Neutral Pool을 입력하거나 수정한다. Save <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCPSCHSSPoolService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1206Event event = (EesCgm1206Event)e;
		CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
		try{
			begin();
			command.manageCPSCHSSPoolBasic (event.getCpsCHSSPoolINVOS(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 *  [Retrieve] <br>
	 *  Cps Pool Code 및 Name 을 조회한다. Retrieve <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCPSPoolCodeListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent)e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchCPSCHSSPoolListBasic(event.getComboINVO());
			
			StringBuffer code = new StringBuffer("");
			StringBuffer text = new StringBuffer("");
			StringBuffer code2 = new StringBuffer("");
			 
			for(int i=0; i<list.size(); i++){
				ComboMGTVO comboMGTVO = (ComboMGTVO)list.get(i);
				
				code.append(comboMGTVO.getCode1());
				text.append(comboMGTVO.getDesc1());
				code2.append(comboMGTVO.getCode2());
				
				if(i < list.size()-1) {
					code.append("|");
					text.append("|");
					code2.append("|");
				}
			}
				
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("code", code.toString());
			eventResponse.setETCData("text", text.toString());
			eventResponse.setETCData("code2", code2.toString());
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * EES_CGM_1209 : Open<br>
	 * 페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse searchSCInitControlService(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		CgmCodeMgtBC			command				= new CgmCodeMgtBCImpl();
		EesCgm1209Event			event				= (EesCgm1209Event)e;
		
		try{
			//2.CNTR/CGO 정보를 조회한다.======================================================================================
			ComboINVO			comboINVO		= new ComboINVO();
			comboINVO.setIntgCdId("CD03261");
			
			List<ComboMGTVO> 		cntrCgoList 		= command.searchCommonCodeListBasic(comboINVO);
			StringBuffer 			sbCntrCgo 			= new StringBuffer();
			
			if (cntrCgoList != null && cntrCgoList.size() > 0) {
				sbCntrCgo.append("ALL").append("=").append("ALL").append("|");
				for (int i = 0 ; i < cntrCgoList.size() ; i++) {
					sbCntrCgo.append(cntrCgoList.get(i).getCode1()).append("=").append(cntrCgoList.get(i).getDesc1());
					if (i < cntrCgoList.size() - 1) sbCntrCgo.append("|");
				}
			}
			eventResponse.setETCData("CNTRCGO", sbCntrCgo.toString());
			//===============================================================================================================

			//6.S/C Duration 정보를 조회한다.==================================================================================
			SCExceptionParmVO 		sCDurationVO 			= command.searchSCDurationBasic(event.getSCExceptionParmVO());
	
			if (sCDurationVO != null) {
				eventResponse.setETCData("EFF_DT", sCDurationVO.getEffDt());
				eventResponse.setETCData("EXP_DT", sCDurationVO.getExpDt());
			}
			//===============================================================================================================
			
			//7.Accept, Accept Cancel 버튼권한 정보를 조회한다.=================================================================
			boolean 				hasAuth 				= command.hasAcceptAuthBasic(event.getSCExceptionParmVO());
	
			eventResponse.setETCData("HAS_AUTH", hasAuth ? "Y" : "N");
			//===============================================================================================================	
			
			//8.SC No. 와  Contract Party 정보를 조회한다.======================================================================
			List<SCExceptionCustomerVO> custList			= command.searchSCNoCustomerByProposalNoBasic(event.getSCExceptionParmVO());
	
			if (custList != null && custList.size() > 0) {
				eventResponse.setETCData("SC_NO", 		custList.get(0).getScNo());
				eventResponse.setETCData("PROP_NO", 		custList.get(0).getPropNo());
				eventResponse.setETCData("CUST_SEQ", 	custList.get(0).getCustSeq());
				eventResponse.setETCData("CUST_CD", 	custList.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", 	custList.get(0).getCustNm());
			
				//===============================================================================================================
				
				//9.Actual Customer 정보를 조회한다.===============================================================================
				List<SCExceptionCustomerVO>	actCustList			= command.searchCustomerListBySCBasic(event.getSCExceptionParmVO());
				StringBuffer 				sbActCust			= new StringBuffer();
				
				if (actCustList != null && actCustList.size() > 0) {
					sbActCust.append("ALL").append("=").append(" ").append("|");
					for (int i = 0 ; i < actCustList.size() ; i++) {
						sbActCust.append(actCustList.get(i).getCustCd()).append("=").append(actCustList.get(i).getCustNm());
						if (i < actCustList.size() - 1) sbActCust.append("|");
					}
				}else{
					sbActCust.append("ALL").append("=").append(" "); //.append("|");
				}
				
				eventResponse.setETCData("CUST", sbActCust.toString());
				
				//10.Commodity 정보를 조회한다.===============================================================================
				List<SCExceptionCommodityVO>	cmdtList		= command.searchCommodityListBySCBasic(event.getSCExceptionParmVO());
				StringBuffer 					sbCmdt			= new StringBuffer();
				
				if (cmdtList != null && cmdtList.size() > 0) {
					sbCmdt.append("ALL").append("=").append(" ").append("|");
					for (int i = 0 ; i < cmdtList.size() ; i++) {
						sbCmdt.append(cmdtList.get(i).getCmdtCd()).append("=").append(cmdtList.get(i).getCmdtNm());
						if (i < cmdtList.size() - 1) sbCmdt.append("|");
					}
				}else{
					sbCmdt.append("ALL").append("=").append(" "); //.append("|");
				}
				
				eventResponse.setETCData("CMDT", sbCmdt.toString());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_CGM_1209 : Open<br>
	 * Proposal No. 에 해당되는 모든 Version 정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCVersionByProposalNoService(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		CgmCodeMgtBC				command			= new CgmCodeMgtBCImpl();
		EesCgm1209Event 			event 			= (EesCgm1209Event)e;
		
		try{
			List<CHSSSCExceptionVersionVO> 	list 			= command.searchSCVersionByProposalNoBasic(event.getSCExceptionParmVO());
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getScExptVerSeq()).append("=").append(list.get(i).getChssExptVerStsCd());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			else {
				codes.append("001").append("=").append("");
			}		
			//6.S/C Duration 정보를 조회한다.==================================================================================
			SCExceptionParmVO 		sCDurationVO 			= command.searchSCDurationBasic(event.getSCExceptionParmVO());
	
			if (sCDurationVO != null) {
				eventResponse.setETCData("EFF_DT", sCDurationVO.getEffDt());
				eventResponse.setETCData("EXP_DT", sCDurationVO.getExpDt());
				/* 2014.06.24 Chang Young Kim Added In accordance with the "SRM-201445510" (S) */
				eventResponse.setETCData("PROP_STS_CD", sCDurationVO.getPropStsCd());
				/* 2014.06.24 Chang Young Kim Added In accordance with the "SRM-201445510" (E) */
			}
			eventResponse.setETCData("VER", codes.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;			
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Proposal no 에 대한 해당 데이터를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCExceptionService(Event e) throws EventException {
		CgmCodeMgtBC					command			= new CgmCodeMgtBCImpl();
		EesCgm1209Event 				event 			= (EesCgm1209Event)e;
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();

		try{
			List<ChssScExceptionVO> 			sCExceptionVOs		= command.searchSCExceptionBasic(event.getSCExceptionParmVO());
			List<CHSSSCExceptionVersionVO> 	list 			= command.searchSCVersionByProposalNoBasic(event.getSCExceptionParmVO());
			
			eventResponse.setETCData("EFF_DT", list.size() > 0 ? list.get(0).getEffDt() : "");
			eventResponse.setETCData("EXP_DT", list.size() > 0 ? list.get(0).getExpDt() : "");
			eventResponse.setETCData("FT_FLG", list.size() > 0 ? list.get(0).getFtFlg() : "");
			eventResponse.setRsVoList(sCExceptionVOs);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Save<br>
	 * S/C별 DEM/DET 특별 계약 내용을 입력,수정,삭제 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse modifySCExceptionService(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		CgmCodeMgtBC					command			= new CgmCodeMgtBCImpl();
		EesCgm1209Event 		event 				= (EesCgm1209Event)e;
		ChssSCExceptionGRPVO		chssSCExceptionGRPVO 	= new ChssSCExceptionGRPVO();
		
		chssSCExceptionGRPVO.setsCExceptionVersionVO(event.getsCExceptionVersionVO());
		chssSCExceptionGRPVO.setChssScExceptionVOS(event.getChssScExceptionVOS());

		try {
			begin();
			String groupSeq = command.modifySCExceptionBasic(chssSCExceptionGRPVO, account);
			eventResponse.setETCData("GRP_SEQ", 	groupSeq);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * Customer Name 정보를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerNameService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CgmComEvent event = (CgmComEvent)e;
		CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
		
		try {
			String custNm = command.searchCustomerNameBasic(event.getCustomerVO());
			eventResponse.setETCData("CUST_NM", custNm);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * PRI_SP_CTRT_PTY에 동일한 Customer가 존재하는지 조회합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	private EventResponse isCustomerByPriMnService(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 				= new GeneralEventResponse();
		EesCgm1209Event 				event 						= (EesCgm1209Event)e;
		CgmCodeMgtBC 					command						= new CgmCodeMgtBCImpl();

		try {
			//중복된 데이터인지 조회를 실행합니다.
			boolean isDuplicate = command.isCustomerByPriMnBasic(event.getSCExceptionParmVO());
			String rtnValue = "N";
			if(isDuplicate) {
				rtnValue = "Y";
			}
			
			eventResponse.setETCData("rtnValue", rtnValue);
			
			log.debug("------->"+rtnValue);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;		
	}
	
	/**
     * Commondity Name 정보를 조회 합니다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCommodityNameService(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesCgm1209Event event = (EesCgm1209Event)e;
        CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
        
        try {
	        String cmdt_cd = (String)event.getAttribute("cmdt_cd");
	        String rtnName = command.searchCommodityNameBasic(cmdt_cd);
	        Map<String,String> etcData = new HashMap<String,String>();
	        etcData.put("rtnName",rtnName);
	        eventResponse.setETCData(etcData);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
	 * EES_CGM_1209 : Update<br>
	 * Update 버튼 클릭시 'Live'상태의 S/C Exception 정보를 새로운 버전으로 생성 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse createSCExceptionByUpdateService(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		CgmCodeMgtBC 				command 		= new CgmCodeMgtBCImpl();
		EesCgm1209Event 		event 				= (EesCgm1209Event)e;
		SCExceptionParmVO		sCExceptionParmVO	= event.getSCExceptionParmVO();

		try {
			sCExceptionParmVO.setCreUsrId(account.getUsr_id());
			sCExceptionParmVO.setCreOfcCd(account.getOfc_cd());
			
			begin();
			command.createSCExceptionByUpdateBasic(sCExceptionParmVO);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2001 : Accept<br>
	 * S/C 의 Version 상태정보를 수정 합니다.<br>
	 * S/C 의 Version 로그를 입력 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyVersionSTSService(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		CgmCodeMgtBC 				command 		= new CgmCodeMgtBCImpl();
		EesCgm1209Event 		event 				= (EesCgm1209Event)e;
		CHSSSCExceptionVersionVO 	versionVO 			= event.getsCExceptionVersionVO();
		
		try{
			versionVO.setCreUsrId(account.getUsr_id());
			versionVO.setCreOfcCd(account.getOfc_cd());
			versionVO.setUpdUsrId(account.getUsr_id());
			versionVO.setUpdOfcCd(account.getOfc_cd());

			begin();
			command.modifyVersionSTSBasic(versionVO);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_CGM_1209 : Delete<br>
	 * Proposal no, Version no 에 대한 해당 데이터를 삭제 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeSCExceptionByVerService(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		CgmCodeMgtBC 				command 		= new CgmCodeMgtBCImpl();
		EesCgm1209Event 		event 				= (EesCgm1209Event)e;
		SCExceptionParmVO 		sCExceptionParmVO 	= event.getSCExceptionParmVO();
		
		try{
			sCExceptionParmVO.setUpdUsrId(account.getUsr_id());
			sCExceptionParmVO.setUpdOfcCd(account.getOfc_cd());
			begin();
			command.removeSCExceptionByVerBasic(sCExceptionParmVO);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * S/C 가 Filed 상태인지를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkFiledBySCService(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		CgmCodeMgtBC 			command 			= new CgmCodeMgtBCImpl();
		EesCgm1209Event 		event 				= (EesCgm1209Event)e;
		try{
			boolean isCheck = command.checkFiledBySCBasic(event.getSCExceptionParmVO());
	
			eventResponse.setETCData("FILED", isCheck ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_CGM_1210 : Retrieve<br>
	 * S/C No. 에 해당되는 S/C Exception History 를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCExceptionListByPropNoService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
		EesCgm1210Event event = (EesCgm1210Event) e;
		SCExceptionParmVO parmVO = null;
		List<ChssScExceptionHisVO> list = null;

		try {
			parmVO = event.getSCExceptionParmVO();
			list = command.searchSCExceptionListByPropNoBasic(parmVO.getPropNo());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CGM_1210 : Copy<br>
	 * 현재 버전에 있는 정보를 삭제하고 현재 버전에 S/C Exception History 에서 선택한 버전의 정보로 생성 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse createSCExceptionByHistoryCopyService(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
		EesCgm1209Event event = (EesCgm1209Event) e;
		SCExceptionParmVO		sCExceptionParmVO	= event.getSCExceptionParmVO();

		try {
			sCExceptionParmVO.setCreUsrId(account.getUsr_id());
			sCExceptionParmVO.setCreOfcCd(account.getOfc_cd());
			sCExceptionParmVO.setUpdUsrId(account.getUsr_id());
			sCExceptionParmVO.setUpdOfcCd(account.getOfc_cd());
			
			begin();
			command.createSCExceptionByHistoryCopyBasic(sCExceptionParmVO);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
}
