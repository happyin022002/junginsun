/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTMasterDataMgtSC.java
*@FileTitle : Holiday by Country Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.04.27 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.AftBkgPathSetupVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChgDeltPathStupVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChgDeltRqstFileVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBC;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.basic.DemDetTariffMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.basic.DemDetTariffMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1001Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1002Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1003Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1004Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1005Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1006Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1101Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1201Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1202Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt4014Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt4015Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt7010Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt7017Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt7019Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.BasicTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffRegionParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffRegionVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffMonitorVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffNotiListVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffSummaryListVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchUserRoleInfoListVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffGroupVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffMgtVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRateVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.ToDmtTariffTypeVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.basic.HolidayMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.basic.HolidayMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.event.EesDmt1007Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.event.EesDmt1008Event;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.integration.HolidayMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.FirstHolidayVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.HolidayMgtVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.SecondHolidayVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * alps-DMTMasterDataMgt Business Logic ServiceCommand - alps-DMTMasterDataMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SungHoon, Lee
 * @see HolidayMgtDBDAO
 * @since J2EE 1.4
 */

public class DMTMasterDataMgtSC extends ServiceCommandSupport { 
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DMTMasterDataMgt system 업무 시나리오 선행작업<br>
	 * EES_DMT_1007업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * DMTMasterDataMgt system 업무 시나리오 마감작업<br>
	 * EES_DMT_1007 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DMTMasterDataMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * alps-DMTMasterDataMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesDmt1001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBasicTariffFreeTime(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBasicTariffRate(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = confirmBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = confirmCancelBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeBasicTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchBasicTariffXSL(e);
            }
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt1002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCombinationSet(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTariffCombination(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTariffFreeTime(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTariffRate(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchUpdateCombinationSet(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = modifyBasicTariffExpire(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt1003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicTariffSummuryList(e);
			}		
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt1004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicTariffDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchBasicTariffDetailList02(e);
            }
		}		
		else if (e.getEventName().equalsIgnoreCase("EesDmt1005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCommodityTariffList(e);
			}		
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyCommodityTariff(e);
			}			
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommodityTrfRuleNo(e);
			}
		}		
		else if (e.getEventName().equalsIgnoreCase("EesDmt1006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCommodityTariffRegionList(e);
			}		
		}		
		else if (e.getEventName().equalsIgnoreCase("EesDmt1007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHoliday(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHolidayList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchWeekendTypeByCountry(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt1008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHolidayCountList(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchHolidayList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchWeekendTypeByCountry(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt1101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = copyBasicTariff(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt4014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				
				eventResponse = searchBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBasicTariffFreeTime(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBasicTariffRate(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = confirmBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = confirmCancelBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeBasicTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchBasicTariffXSL(e);
            }
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt4015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicTariffDetailList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchBasicTariffDetailList02(e);
            }		
		}		
		else if (e.getEventName().equalsIgnoreCase("EesDmt7010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDMTUserRoleInfoList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageDMTUserRoleInfoList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
                eventResponse = checkUserID(e);		// User ID 존재 여부 확인
            }		
		}	
		// Deletion Authority Setup - Transaction 처리
		// 2015-10-19 Tab 구분으로 After Booking Approval 로직 추가
		else if (e.getEventName().equalsIgnoreCase("EesDmt7017Event")) {
			// ■■■ Inactivation ■■■ 
			// Transaction - R
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDeletionAuthoritySetupList(e);
			} 
			// Transaction - C, U, D
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {				
				eventResponse = manageDeletionAuthoritySetup(e);
            }
			// ■■■ After Booking ■■■ 
			// Transaction - R
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAfterBkgSetupList(e);
			} 
			// Transaction - C, U, D
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {				
				eventResponse = manageAfterBkgSetup(e);
            } 
		}		
		// Charge Deletion Attached File 조회
		else if (e.getEventName().equalsIgnoreCase("EesDmt7019Event")) {
			// Transaction - R
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeDeletionRequestFileList(e);
			} 
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt1201Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicTariffMonitor(e);
			} 
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt1202Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicTariffNotiList(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageBasicTariffNotiList(e);
            }
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_1007 : Retrieve<br>
	 * 등록된 국가들의 상세 휴일정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHolidayList(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		HolidayMgtBC 			command 		= new HolidayMgtBCImpl();
		HolidayMgtVO 			holidayMgtVO 	= null;
		
		int 					holFstDate 		= 7;	//토요일(기본값)
		int 					holSndDate 		= 1;	//일요일(기본값)
		String 					wkndTpCd 		= null;
		
		if (e instanceof EesDmt1007Event) {
			EesDmt1007Event event = (EesDmt1007Event)e;
			holidayMgtVO = event.getHolidayMgtVO();
		} else if (e instanceof EesDmt1008Event) {
			EesDmt1008Event event = (EesDmt1008Event)e;
			holidayMgtVO = event.getHolidayMgtVO();
		}
		
		try{
		
			if ( holidayMgtVO != null ){
				//Holiday 조회
				List<HolidayMgtVO> list = command.searchHolidayList(holidayMgtVO);
		
				//요일 파라미터 조회
				if (list != null && list.size() > 0) {
					wkndTpCd = list.get(0).getWkndTpCd();
				} else {
					wkndTpCd = holidayMgtVO.getWkndTpCd();
				}
				
				if ("TF".equals(wkndTpCd)) {
					holFstDate = 5;	//목요일
					holSndDate = 6;	//금요일
				} else if ("FS".equals(wkndTpCd)) {
					holFstDate = 6;	//금요일
					holSndDate = 7;	//토요일			
				}			
			
				//휴일 정보 조회를 위한 부분 ##############################################################################################################
				String[] 				monthOfYears 		= { "JAN", "FEB", "MAR", "APR",	"MAY", "JUN", "JUL", "AUG",	"SEP", "OCT", "NOV", "DEC" }; 
				
				//휴일 정보를 조회할 년도
				int 					holYr 				= Integer.parseInt(holidayMgtVO.getHolYr());
				
				List<String> 			firstHoliday 		= new ArrayList<String>();
				List<String> 			secondHoliday 		= new ArrayList<String>();
				
				List<FirstHolidayVO> 	lstFirstHolidayVO 	= new ArrayList<FirstHolidayVO>();
				List<SecondHolidayVO> 	lstSecondHolidayVO 	= new ArrayList<SecondHolidayVO>();
		
				FirstHolidayVO 			firstHolidayVO 		= null;
				SecondHolidayVO 		secondHolidayVO 	= null;		
				
				Calendar 				fromCal 			= Calendar.getInstance();
				Calendar 				toCal				= Calendar.getInstance();
				
				String 					dayOfMonth 			= null;
				
				//첫번째 Holiday 조회
				fromCal.clear();
				fromCal.set(holYr, 0, 1);
				toCal.clear();
				toCal.set(holYr, 11, 31);
				
				while (!fromCal.after(toCal)) {
					
					dayOfMonth = fromCal.get(Calendar.DAY_OF_MONTH) < 10 
									? "0" + fromCal.get(Calendar.DAY_OF_MONTH) 
									: fromCal.get(Calendar.DAY_OF_MONTH) + "";
									
					if (fromCal.get(Calendar.DAY_OF_WEEK) == holFstDate) {
						firstHoliday.add(dayOfMonth + monthOfYears[fromCal.get(Calendar.MONTH)]);
						fromCal.add(Calendar.DATE, 7);				
					}
					else {
						fromCal.add(Calendar.DATE, 1);
					}
				}
				
				for (int i = 0 ; i < firstHoliday.size() ; i++) {
					firstHolidayVO = new FirstHolidayVO();
					firstHolidayVO.setFirstholiday(firstHoliday.get(i));
					lstFirstHolidayVO.add(firstHolidayVO);
				}
				eventResponse.setRsVoList(lstFirstHolidayVO);
				
				//두번째 Holiday 조회
				fromCal.clear();
				fromCal.set(holYr, 0, 1);
				toCal.clear();
				toCal.set(holYr, 11, 31);
				
				while (!fromCal.after(toCal)) {
					
					dayOfMonth = fromCal.get(Calendar.DAY_OF_MONTH) < 10 
									? "0" + fromCal.get(Calendar.DAY_OF_MONTH) 
									: fromCal.get(Calendar.DAY_OF_MONTH) + "";
									
					if (fromCal.get(Calendar.DAY_OF_WEEK) == holSndDate) {
						secondHoliday.add(dayOfMonth + monthOfYears[fromCal.get(Calendar.MONTH)]);
						fromCal.add(Calendar.DATE, 7);				
					}
					else {
						fromCal.add(Calendar.DATE, 1);
					}
				}
		
				for (int i = 0 ; i < secondHoliday.size() ; i++) {
					secondHolidayVO = new SecondHolidayVO();
					secondHolidayVO.setSecondholiday(secondHoliday.get(i));
					lstSecondHolidayVO.add(secondHolidayVO);
				}
				eventResponse.setRsVoList(lstSecondHolidayVO);		
				//휴일 정보 조회를 위한 부분 ##############################################################################################################
				
				//Holiday 조회된 결과를 응답객체에 추가한다.(반드시 세번째로 추가해야만 함)
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_1007 : Retrieve<br>
	 * 국가별로 휴일타입을 조회 합니다. <br>
	 *  
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeekendTypeByCountry(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		HolidayMgtBC 			command 		= new HolidayMgtBCImpl();
		HolidayMgtVO 			holidayMgtVO 	= null;
		String 					wkndTpCd 		= null;
		
		if (e instanceof EesDmt1007Event) {
			holidayMgtVO 	= ((EesDmt1007Event)e).getHolidayMgtVO();
		} else if (e instanceof EesDmt1008Event) {
			holidayMgtVO 	= ((EesDmt1008Event)e).getHolidayMgtVO();
		}
		try{
		
			//요일 파라미터 조회
			wkndTpCd = command.searchWeekendTypeByCountry(holidayMgtVO);
			//휴일타입설정을 위해서 조회된 휴일 타입도 응답객체에 추가한다.
			eventResponse.setETCData("wknd_tp_cd", wkndTpCd);
		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_1008 : Retrieve<br>
	 * 등록된 국가들의 휴일정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHolidayCountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1008Event event = (EesDmt1008Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			HolidayMgtBC command = new HolidayMgtBCImpl();
			List<HolidayMgtVO> list = command.searchHolidayCountList(event.getHolidayMgtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_1007 : Save<br>
	 * 국가들의 휴일정보를 생성, 수정, 삭제 합니다. <br> 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHoliday(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1007Event event = (EesDmt1007Event)e;
		HolidayMgtBC command = new HolidayMgtBCImpl();
		try{
			begin();
			command.manageHoliday(event.getHolidayMgtVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
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
	 * [EES_DMT_1003] : [search] <br>
	 * [BasicTariffSummuryList]을 [search]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchBasicTariffSummuryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1003Event event = (EesDmt1003Event)e;
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		
			List<SearchBasicTariffSummaryListVO> list = command.searchBasicTariffSummuryList(event.getSearchBasicTariffSummaryParamVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
		
	}
	
	/**
	 * [EES_DMT_1004] : [search] <br>
	 * [EES_DMT_4015] : [search] <br>
	 * [Continent]을 [search]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchBasicTariffDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SearchContinentParamVO searchContinetParamVO = null;
		try{
			if(e instanceof EesDmt1004Event) {
				searchContinetParamVO = ((EesDmt1004Event)e).getSearchContinentParamVO();
				searchContinetParamVO.setUiCode("1004");
			}else if(e instanceof EesDmt4015Event) {
				searchContinetParamVO = ((EesDmt4015Event)e).getSearchContinentParamVO();
				searchContinetParamVO.setUiCode("4015");
			}
			List<SearchContinentVO> list = command.searchBasicTariffDetailList(searchContinetParamVO);
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}	
		
		return eventResponse;
		
	}
	
    /**
     * [EES_DMT_1004] : [search] <br>
     * [EES_DMT_4015] : [search] <br>
     * [Continent]을 [search]합니다<br>
     * @param Event e
     * @return EventResponse response 
     * @throws EventException
     */
    private EventResponse searchBasicTariffDetailList02 ( Event e ) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SearchContinentParamVO searchContinetParamVO = null;
        try{
            if(e instanceof EesDmt1004Event) {
                searchContinetParamVO = ((EesDmt1004Event)e).getSearchContinentParamVO();
                searchContinetParamVO.setUiCode("1004");
            }else if(e instanceof EesDmt4015Event) {
                searchContinetParamVO = ((EesDmt4015Event)e).getSearchContinentParamVO();
                searchContinetParamVO.setUiCode("4015");
            }
            List<SearchContinentVO> list = command.searchBasicTariffDetailList02(searchContinetParamVO);
            eventResponse.setRsVoList(list);
            
        }catch(EventException ex){
			log.error(ex.getMessage(),ex);
            throw ex;
        }catch(Exception ex){
			log.error(ex.getMessage(),ex);
            throw new EventException(ex.getMessage(), ex);
        }   
        
        return eventResponse;
        
    }
    
	/**
	 * [EES_DMT_1001] : [search] <br>
	 * [EES_DMT_4014] : [search] <br>
	 * [BasicTariff]을 [search]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchBasicTariff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<BasicTariffVO> list = null;
		DmtTariffTypeVO dmtTariffTypeVO = null;
		
		try {
			
			if(e instanceof EesDmt1001Event) {
				dmtTariffTypeVO = ((EesDmt1001Event)e).getDmtTariffTypeVO();
				dmtTariffTypeVO.setUiCode("1001");
			}else if(e instanceof EesDmt4014Event) {
				dmtTariffTypeVO = ((EesDmt4014Event)e).getDmtTariffTypeVO();
				dmtTariffTypeVO.setUiCode("4014");
			}
			
			list = command.searchBasicTariff(dmtTariffTypeVO);
			eventResponse.setRsVoList(list);
			list = command.searchWeekEnd(dmtTariffTypeVO);
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("WKND1",list.get(0).getWknd1());
				eventResponse.setETCData("WKND2",list.get(0).getWknd2());
			}else{
				eventResponse.setETCData("WKND1","SAT");
				eventResponse.setETCData("WKND2","SUN");
			}
			
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
    /**
     * [EES_DMT_1001] : [search] <br>
     * [EES_DMT_4014] : [search] <br>
     * [BasicTariff]을 [search]합니다<br>
     * @param Event e
     * @return EventResponse response 
     * @throws EventException
     */
    private EventResponse searchBasicTariffXSL(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        List<BasicTariffVO> list = null;
        DmtTariffTypeVO dmtTariffTypeVO = null;
        
        try {
            
            if(e instanceof EesDmt1001Event) {
                dmtTariffTypeVO = ((EesDmt1001Event)e).getDmtTariffTypeVO();
                dmtTariffTypeVO.setUiCode("1001");
            }else if(e instanceof EesDmt4014Event) {
                dmtTariffTypeVO = ((EesDmt4014Event)e).getDmtTariffTypeVO();
                dmtTariffTypeVO.setUiCode("4014");
            }
            
            List<SearchContinentVO> list = command.searchBasicTariffXSL(dmtTariffTypeVO);
            eventResponse.setRsVoList(list);            
            
//            list = command.searchBasicTariff(dmtTariffTypeVO);
//            eventResponse.setRsVoList(list);
//            list = command.searchWeekEnd(dmtTariffTypeVO);
//            
//            if (list != null && list.size() > 0) {
//                eventResponse.setETCData("WKND1",list.get(0).getWknd1());
//                eventResponse.setETCData("WKND2",list.get(0).getWknd2());
//            }else{
//                eventResponse.setETCData("WKND1","SAT");
//                eventResponse.setETCData("WKND2","SUN");
//            }
            
        }catch(EventException ex){
			log.error(ex.getMessage(),ex);
            throw ex;
        }catch(Exception ex){
			log.error(ex.getMessage(),ex);
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
	
	/**
	 * [EES_DMT_1001] : [search] <br>
	 * [EES_DMT_4014] : [search] <br>
	 * [BasicTariffFreeTime]을 [search]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchBasicTariffFreeTime(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtTariffTypeVO dmtTariffTypeVO = null;
		
		try {
			if(e instanceof EesDmt1001Event) {
				dmtTariffTypeVO = ((EesDmt1001Event)e).getDmtTariffTypeVO();
			}else if(e instanceof EesDmt4014Event) {
				dmtTariffTypeVO = ((EesDmt4014Event)e).getDmtTariffTypeVO();
			}
			List<TariffFreeTimeVO> list = command.searchBasicTariffFreeTime(dmtTariffTypeVO);
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * [EES_DMT_1001] : [search] <br>
	 * [EES_DMT_4014] : [search] <br>
	 * [BasicTariffRate]을 [search]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchBasicTariffRate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtTariffTypeVO dmtTariffTypeVO = null;
		
		try {
			if(e instanceof EesDmt1001Event) {
				dmtTariffTypeVO = ((EesDmt1001Event)e).getDmtTariffTypeVO();
			}else if(e instanceof EesDmt4014Event) {
				dmtTariffTypeVO = ((EesDmt4014Event)e).getDmtTariffTypeVO();
			}
			List<TariffRateVO> list = command.searchBasicTariffRate(dmtTariffTypeVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;

	}
	
	/**
	 * [EES_DMT_1001] : [confirm] <br>
	 * [EES_DMT_4014] : [confirm] <br>
	 * [BasicTariff]을 [confirm]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse confirmBasicTariff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BasicTariffVO[] basicTariffVOs = null;
		
		BasicTariffVO basicTariffVO = new BasicTariffVO();
		String trf_grp_seq = "";
		int max_seq = 0;
		
		try {
			if(e instanceof EesDmt1001Event) {
				basicTariffVOs = ((EesDmt1001Event)e).getBasicTarriffVOs();
			}else if(e instanceof EesDmt4014Event) {
				basicTariffVOs = ((EesDmt4014Event)e).getBasicTarriffVOs();
			}
			
			if ( basicTariffVOs != null ){
				begin();
				for( int i=0; i< basicTariffVOs.length ; i++) {
					basicTariffVO = basicTariffVOs[i];
					
					basicTariffVO.setOfcCd(account.getOfc_cd());
					basicTariffVO.setUsrId(account.getUsr_id());
					basicTariffVO.setCrntCfmFlg("Y");
					
					//처음에는 무조건 처리한다.
					if(i == 0 ) {
						
						//DMT_TRF_GRP CONFIRM
						command.confirmBasicTariff(basicTariffVO);
						//DMT_TRF_RGN CONFIRM
						command.confirmRgnBasicTariff(basicTariffVO);
						
						//DMT_TRF_RGN_CFM_HIS INSERT
						command.addTrfRgnCfmHis(basicTariffVO);
						max_seq = command.searchTrfRgnCfmSeq(basicTariffVO);
						basicTariffVO.setRgnCfmSeq(String.valueOf(max_seq));
						
						//DMT_TRF_GRP_CFM_HIS INSERT
						command.addTrfGrpCfmHis(basicTariffVO);
						
						trf_grp_seq = basicTariffVO.getTrfGrpSeq();
						continue;
					}
					
					//grp_seq가 다를 경우 한번만 dmt_trf_grp confirm 처리 한다.
					if(!basicTariffVO.getTrfGrpSeq().equals(trf_grp_seq)) {
						basicTariffVO.setRgnCfmSeq(String.valueOf(max_seq));
	
						//DMT_TRF_GRP CONFIRM
						command.confirmBasicTariff(basicTariffVO);
						//DMT_TRF_GRP_CFM_HIS INSERT
						command.addTrfGrpCfmHis(basicTariffVO);
						
						trf_grp_seq = basicTariffVO.getTrfGrpSeq();
					}
				}
				commit();
			}
		} catch(EventException ex) {
			log.error(ex.getMessage(),ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            rollback(); 
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;
	}
	
	/**
	 * [EES_DMT_1001] : [confirmCancel] <br>
	 * [EES_DMT_4014] : [confirmCancel] <br>
	 * [BasicTariff]을 [confirmCancel]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException	 
	 */
	private EventResponse confirmCancelBasicTariff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BasicTariffVO[] basicTariffVOs = null;
		BasicTariffVO basicTariffVO = new BasicTariffVO();
		String trf_grp_seq = "";
		int max_seq = 0;
		
		try {
			if(e instanceof EesDmt1001Event) {
				basicTariffVOs = ((EesDmt1001Event)e).getBasicTarriffVOs();
			}else if(e instanceof EesDmt4014Event) {
				basicTariffVOs = ((EesDmt4014Event)e).getBasicTarriffVOs();
			}
			
			if ( basicTariffVOs != null ){
				begin();
				for( int i=0; i< basicTariffVOs.length ; i++) {
					basicTariffVO = basicTariffVOs[i];
					basicTariffVO.setOfcCd(account.getOfc_cd());
					basicTariffVO.setUsrId(account.getUsr_id());
					basicTariffVO.setCrntCfmFlg("N");
					
					//처음에는 무조건 처리한다.
					if(i == 0 ) {
						//DMT_TRF_GRP CONFIRM
						command.confirmCancelBasicTariff(basicTariffVO);
						//DMT_TRF_RGN CONFIRM
						command.confirmCancelRgnBasicTariff(basicTariffVO);
						
						//DMT_TRF_RGN_CFM_HIS INSERT
						command.addTrfRgnCfmHis(basicTariffVO);
						max_seq = command.searchTrfRgnCfmSeq(basicTariffVO);
						
						basicTariffVO.setRgnCfmSeq(String.valueOf(max_seq));
						
						//DMT_TRF_GRP_CFM_HIS INSERT
						command.addTrfGrpCfmHis(basicTariffVO);
						
	
						trf_grp_seq = basicTariffVO.getTrfGrpSeq();
						continue;
					}
					
					//grp_seq가 다를 경우 한번만 dmt_trf_grp confirm 처리 한다.
					if(!basicTariffVO.getTrfGrpSeq().equals(trf_grp_seq)) {
						basicTariffVO.setRgnCfmSeq(String.valueOf(max_seq));
						//DMT_TRF_GRP CONFIRM
						command.confirmCancelBasicTariff(basicTariffVO);
						
						//DMT_TRF_GRP_CFM_HIS INSERT
						command.addTrfGrpCfmHis(basicTariffVO);
						
						trf_grp_seq = basicTariffVO.getTrfGrpSeq();
					}
				}
				commit();
			}
		} catch(EventException ex) {
			log.error(ex.getMessage(),ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            rollback(); 
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;		
	}
	
	/**
	 * [EES_DMT_1001] : [search] <br>
	 * [EES_DMT_4014] : [search] <br>
	 * [BasicTariff]을 [remove]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse removeBasicTariff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BasicTariffVO[] basicTariffVOs = null;
		
		try {
			if(e instanceof EesDmt1001Event) {
				basicTariffVOs = ((EesDmt1001Event)e).getBasicTarriffVOs();
			}else if(e instanceof EesDmt4014Event) {
				basicTariffVOs = ((EesDmt4014Event)e).getBasicTarriffVOs();
			}
			
			begin();
			command.removeBasicTariff(basicTariffVOs);
			commit();
			//eventResponse.setUserMessage("Pls make sure to create new tariff!!");
			eventResponse.setUserMessage(new ErrorHandler("DMT06026").getUserMessage());
		} catch(EventException ex) {
			log.error(ex.getMessage(),ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            rollback(); 
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;			
	}
	
	/**
	 * [EES_DMT_1002] : [search] <br>
	 * [CombinationSet]을 [search]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchCombinationSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1002Event event = (EesDmt1002Event)e;
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<BasicTariffVO> list = command.searchCombinationSet(event.getDmtTariffTypeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
		
	}
	
	/**
	 * [EES_DMT_1002] : [search] <br>
	 * [Update CombinationSet]을 [search]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchUpdateCombinationSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1002Event event = (EesDmt1002Event)e;
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<BasicTariffVO> list = command.searchUpdateCombinationSet(event.getDmtTariffTypeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
		
	}	
	
	/**
	 * [EES_DMT_1002] : [search] <br>
	 * [TariffCombination]을 [search]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchTariffCombination(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1002Event event = (EesDmt1002Event)e;
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BasicTariffVO basicTariffVO = event.getBasicTarriffVO();
		try {
			String button_mode = basicTariffVO.getButtonMode();
			
			if(!button_mode.equals("C")) {
				// Tariff Combination 조회
				List<BasicTariffVO> list = command.searchTariffCombination(basicTariffVO);
				eventResponse.setRsVoList(list);
			}
			
			// DMT_TRF_GRP 조회
			List<TariffGroupVO> list2 = command.searchDmtTrfGrp(basicTariffVO);
			if (list2 != null && list2.size() > 0) {
				eventResponse.setETCData("cmnc_hr",				list2.get(0).getCmncHr());
				eventResponse.setETCData("curr_cd",				list2.get(0).getCurrCd());
				eventResponse.setETCData("dmdt_bzc_trf_grp_nm",	list2.get(0).getDmdtBzcTrfGrpNm());
				eventResponse.setETCData("dmdt_chg_cmnc_tp_cd",	list2.get(0).getDmdtChgCmncTpCd());
				eventResponse.setETCData("dmdt_trf_grp_tp_cd",	list2.get(0).getDmdtTrfGrpTpCd());
				eventResponse.setETCData("eff_dt",				list2.get(0).getEffDt());
				eventResponse.setETCData("exp_dt",				list2.get(0).getExpDt());
				eventResponse.setETCData("xcld_hol_flg",		list2.get(0).getXcldHolFlg());
				eventResponse.setETCData("xcld_sat_flg",		list2.get(0).getXcldSatFlg());
				eventResponse.setETCData("xcld_sun_flg",		list2.get(0).getXcldSunFlg());
				eventResponse.setETCData("bzc_trf_xtn_flg",		list2.get(0).getBzcTrfXtnFlg());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * [EES_DMT_1002] : [search] <br>
	 * [TariffFreeTime]을 [search]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchTariffFreeTime(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1002Event event = (EesDmt1002Event)e;
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<TariffFreeTimeVO> list = command.searchBasicTariffFreeTime(event.getDmtTariffTypeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
		
	}
	
	/**
	 * [EES_DMT_1002] : [search] <br>
	 * [TariffRate]을 [search]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchTariffRate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1002Event event = (EesDmt1002Event)e;
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<TariffRateVO> list = command.searchBasicTariffRate(event.getDmtTariffTypeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
		
	}

	/**
	 * [EES_DMT_1002] : [create] <br>
	 * [BasicTariff]을 [create]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse createBasicTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1002Event event = (EesDmt1002Event)e;
		TariffMgtVO tariffMgtVO = new TariffMgtVO();
		
		tariffMgtVO.setTariffGroupVO(event.getTariffGroupVO());
		tariffMgtVO.setDmtTariffTypeVO(event.getDmtTariffTypeVO());

		tariffMgtVO.setTariffCombinationVOs(event.getTariffCombinationVOs());
		tariffMgtVO.setTariffFreeTimeVOs(event.getTariffFreeTimeVOs());
		tariffMgtVO.setTariffRateVOs(event.getTariffRateVOs());
		
		DemDetTariffMgtBC command 		= new DemDetTariffMgtBCImpl();
		SCExceptionTariffMgtBC commandSC= new SCExceptionTariffMgtBCImpl();
		
		String sResult = "";
		try {
			DmtTariffTypeVO dmtTariffTypeVO = tariffMgtVO.getDmtTariffTypeVO();
			
			String bound 	= dmtTariffTypeVO.getDmdtTrfCd().substring(2, 3);
			String calcTpCd = dmtTariffTypeVO.getDmdtTrfCd().substring(0, 1);
			
			CalculationTypeParmVO calcVO = new CalculationTypeParmVO();
			calcVO.setDmdtCalcTpCd(calcTpCd);
			calcVO.setIoBndCd(bound);
			calcVO.setCntCd(dmtTariffTypeVO.getCvrgCntCd());
			calcVO.setRgnCd(dmtTariffTypeVO.getCvrgRgnCd());
			calcVO.setSteCd(dmtTariffTypeVO.getCvrgSteCd());
			calcVO.setLocCd(dmtTariffTypeVO.getCvrgLocCd());
			//1. checkCalcType
			//날짜 기간
			if("Y".equals(tariffMgtVO.getTariffGroupVO().getXtnFlg())){
				tariffMgtVO.getTariffGroupVO().setEffDt(tariffMgtVO.getTariffGroupVO().getXtnEffDt());
				tariffMgtVO.getTariffGroupVO().setExpDt(tariffMgtVO.getTariffGroupVO().getXtnExpDt()); 
			}
		    calcVO.setEffDt(tariffMgtVO.getTariffGroupVO().getEffDt());
		    calcVO.setExpDt(tariffMgtVO.getTariffGroupVO().getExpDt()); 
			
			//심천(4014)인 경우 체크로직 제외
			if(dmtTariffTypeVO.getUiCode().equals("1001")) {
				//1. checkCalcType
				boolean checkCalc = commandSC.checkCalcType(calcVO);
				
				if(!checkCalc) {
					eventResponse.setUserMessage(new ErrorHandler("DMT06011").getUserMessage());
				}else{
					begin();
					sResult = command.createBasicTariff(tariffMgtVO, account);
					if(sResult.equals("OK")) {
						commit();
						eventResponse.setETCData("SUCCESS_YN", "Y");	//성공
						//eventResponse.setUserMessage("Tariff Group Created! Please Confirm to apply");
						eventResponse.setUserMessage(new ErrorHandler("DMT06008").getUserMessage());
					}else {
						rollback();
						eventResponse.setETCData("SUCCESS_YN", "N");	//실패
						eventResponse.setUserMessage(sResult);
					}
				}
			}else{
				begin();
				sResult = command.createBasicTariff(tariffMgtVO, account);
				if(sResult.equals("OK")) {
					commit();
					eventResponse.setETCData("SUCCESS_YN", "Y");	//성공
					//eventResponse.setUserMessage("Tariff Group Created! Please Confirm to apply");
					eventResponse.setUserMessage(new ErrorHandler("DMT06008").getUserMessage());
				}else {
					rollback();
					eventResponse.setETCData("SUCCESS_YN", "N");	//실패
					eventResponse.setUserMessage(sResult);
				}
			}
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			//eventResponse.setUserMessage(new ErrorHandler(ex.getMessage()).getUserMessage());
			eventResponse.setETCData("SUCCESS_YN", "N");		//실패
			eventResponse.setUserMessage(ex.getMessage());
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			eventResponse.setETCData("SUCCESS_YN", "N");		//실패
			eventResponse.setUserMessage(ex.getMessage());
            rollback(); 
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;	
	}
	
	/**
	 * [EES_DMT_1002] : [modify] <br>
	 * [BasicTariff]을 [modify]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse modifyBasicTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1002Event event = (EesDmt1002Event)e;
		TariffMgtVO tariffMgtVO = new TariffMgtVO();

		tariffMgtVO.setTariffGroupVO(event.getTariffGroupVO());
		tariffMgtVO.setDmtTariffTypeVO(event.getDmtTariffTypeVO());		
		tariffMgtVO.setTariffCombinationVOs(event.getTariffCombinationVOs());
		tariffMgtVO.setTariffFreeTimeVOs(event.getTariffFreeTimeVOs());
		tariffMgtVO.setTariffRateVOs(event.getTariffRateVOs());
		
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		String sResult = "";
		try {
			begin();
			sResult = command.modifyBasicTariff(tariffMgtVO, account);
			if(sResult.equals("OK")) {
				commit();
				eventResponse.setETCData("SUCCESS_YN", "Y");	//�깃났
				//eventResponse.setUserMessage("Update successful! Please Confirm to apply");
				eventResponse.setUserMessage(new ErrorHandler("DMT06028").getUserMessage());
			}else{
				rollback();
				log.error("error==>"+sResult);
				eventResponse.setETCData("SUCCESS_YN", "N");	//�ㅽ뙣
				eventResponse.setUserMessage(sResult);
			}
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			rollback();
			throw ex;
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            rollback(); 
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_1002 : expire<br>
	 * [BasicTariff]를 [Expire]합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyBasicTariffExpire(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1002Event event = (EesDmt1002Event)e;
		TariffMgtVO tariffMgtVO = new TariffMgtVO();

		tariffMgtVO.setTariffGroupVO(event.getTariffGroupVO());
		tariffMgtVO.setDmtTariffTypeVO(event.getDmtTariffTypeVO());		
		tariffMgtVO.setTariffCombinationVOs(event.getTariffCombinationVOs());
		tariffMgtVO.setTariffFreeTimeVOs(event.getTariffFreeTimeVOs());
		tariffMgtVO.setTariffRateVOs(event.getTariffRateVOs());
		
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		try {
			begin();
			command.modifyBasicTariffExpire(tariffMgtVO, account);
			commit();
			eventResponse.setETCData("SUCCESS_YN", "Y");	//성공
			//eventResponse.setUserMessage("Expire successful!");
			eventResponse.setUserMessage(new ErrorHandler("DMT06029").getUserMessage());
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			rollback();
			throw ex;
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            rollback(); 
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;	
	}
	
	/**
	 * EesDmt1101Event : copy<br>
	 * [BasicTariff]를 [copy]합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse copyBasicTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1101Event event = (EesDmt1101Event)e;
		DmtTariffTypeVO dmtTariffTypeVO = new DmtTariffTypeVO();
		dmtTariffTypeVO = event.getDmtTariffTypeVO();
		ToDmtTariffTypeVO toDmtTariffTypeVO = new ToDmtTariffTypeVO();
		toDmtTariffTypeVO = event.getToDmtTariffTypeVO();
		String sResult = "";
		
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		try {
			begin();
			sResult = command.copyBasicTariff(dmtTariffTypeVO, toDmtTariffTypeVO, account);
			
			if(sResult.equals("OK") ) {
				commit();
				//eventResponse.setUserMessage("Copied! Pls make sure to confirm To tariff!");
				eventResponse.setUserMessage(new ErrorHandler("DMT06030").getUserMessage());
			}else{
				log.error("error==>"+sResult);
				rollback();
				eventResponse.setUserMessage(sResult);
			}
			
		} catch(EventException ex) {
			log.error(ex.getMessage(),ex);
			rollback();
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            rollback(); 
			eventResponse.setUserMessage(ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;
		
	}
	
	/**
	 * [EES_DMT_1005] : [search] <br>
	 * [CommdityTariffList]을 [search]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchCommodityTariffList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1005Event event = (EesDmt1005Event)e;
		DmtTariffTypeVO dmtTariffTypeVO = new DmtTariffTypeVO();
		DemDetTariffMgtBC command 		= new DemDetTariffMgtBCImpl();
		SCExceptionTariffMgtBC commandSC= new SCExceptionTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		boolean isError = false;
		String sErrorMsg = "";
		try{
			dmtTariffTypeVO = event.getDmtTariffTypeVO();
			//1.checkCalcType
			String dmdtTrfCd = dmtTariffTypeVO.getSelDmdtTrfCd();
			dmtTariffTypeVO.setDmdtTrfCd(dmdtTrfCd);
			
			String bound 	= dmtTariffTypeVO.getDmdtTrfCd().substring(2, 3);
			String calcTpCd = dmtTariffTypeVO.getDmdtTrfCd().substring(0, 1);
			
			CalculationTypeParmVO calcVO = new CalculationTypeParmVO();
			calcVO.setDmdtCalcTpCd(calcTpCd);
			calcVO.setIoBndCd(bound);
			calcVO.setCntCd(dmtTariffTypeVO.getCvrgCntCd());
			calcVO.setRgnCd(dmtTariffTypeVO.getCvrgRgnCd());
			calcVO.setSteCd(dmtTariffTypeVO.getCvrgSteCd());
			calcVO.setLocCd(dmtTariffTypeVO.getCvrgLocCd());
			
			boolean checkCalc = commandSC.checkCalcType(calcVO);
			
			if(!checkCalc) {
				eventResponse.setUserMessage(new ErrorHandler("DMT06011").getUserMessage());
			}else{
				
				//2.searchCommodity
				List<CommodityTariffVO> list = command.searchCommodityTariffList(dmtTariffTypeVO);
				
				if(list != null ) {
					for(int i = 0; i< list.size() ; i++) {
						CommodityTariffVO commdityTariffVO = (CommodityTariffVO)list.get(i);
						if(commdityTariffVO.getReturnCd().equals("DMT06031")){
							
							isError = true;
							sErrorMsg = new ErrorHandler("DMT06031").getUserMessage();
							log.debug("[ERR_CD]DMT06031||"+sErrorMsg);
							break;
						}
					}
				}
				
				if(isError) {
					log.error("error==>"+sErrorMsg);
					eventResponse.setUserMessage(sErrorMsg);
				}else{
					eventResponse.setRsVoList(list);
				}				
			}
			

		} catch(EventException ex ) {
			log.error(ex.getMessage(),ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}
		
		return eventResponse;
		
	}
	
	/**
	 * [EES_DMT_1005] : [modify] <br>
	 * [CommodityTariff]를 [생성]합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyCommodityTariff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1005Event event = (EesDmt1005Event)e;
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		
		try{
			begin();
			command.modifyCommodityTariff(event.getCommodityTariffVOs(), event.getDmtTariffTypeVO(), account);
			commit();
		}catch(EventException ex) {
			log.error(ex.getMessage(),ex);
			rollback();
			throw ex;
			
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;
	}
	
	/**
	 * [EES_DMT_1006] : [search] <br>
	 * [CommodityTariffRegionList]를 [search]합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCommodityTariffRegionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommodityTariffRegionParamVO commodityTariffRegionParamVO = null;
		try{
			commodityTariffRegionParamVO = ((EesDmt1006Event)e).getCommodityTariffRegionParamVO();
			List<CommodityTariffRegionVO> list = command.searchCommodityTariffRegionList(commodityTariffRegionParamVO);
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}	
		
		return eventResponse;
		
	}
	
	
	/**
	 * [EES_DMT_7010] : [search] <br>
	 * 사용자의 Role정보를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchDMTUserRoleInfoList(Event e) throws EventException {
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SearchUserRoleInfoListVO searchUserRoleInfoListVO = new SearchUserRoleInfoListVO();
		EesDmt7010Event event = (EesDmt7010Event)e;
		
		try{
			searchUserRoleInfoListVO.setUsrId((String)event.getAttribute("usr_id"));
			searchUserRoleInfoListVO.setUsrRoleCd((String)event.getAttribute("usr_role_cd"));
			searchUserRoleInfoListVO.setUsrLoclNm((String)event.getAttribute("usr_locl_nm"));
			searchUserRoleInfoListVO.setOfcCd((String)event.getAttribute("ofc_cd"));
	         
			List<SearchUserRoleInfoListVO> list = command.searchDMTUserRoleInfoList(searchUserRoleInfoListVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}	
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_7010 : Save<br>
	 * 사용자의 Role정보를 생성, 삭제 합니다. <br> 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDMTUserRoleInfoList(Event e) throws EventException {
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt7010Event event = (EesDmt7010Event)e;
		try{
			begin();
  			command.manageDMTUserRoleInfoList(event.getDmtUsrRoleMtchVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
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
	 * User ID가 등록되어 있는지 확인한다.<br>
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse checkUserID(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		String usrId ="";
		
		try {
			if (e instanceof EesDmt7010Event) {
				EesDmt7010Event event = (EesDmt7010Event)e;
				usrId = (String)event.getAttribute("usr_id");
			}
			
			// User ID 에 Offfic Code가 리턴된다.
  			String rtnStr = command.searchUserOfcCd(usrId);
  			String rtnVal = "Y";
  			
  			if (rtnStr.equals("")) {
  				rtnVal = "N";
  			}
  			
  			eventResponse.setETCData("EXISTS_FLAG", rtnVal);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex); 
		}
		return eventResponse;
	}
	

	/**
	 * [EES_DMT_1201] : [search] <br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchBasicTariffMonitor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1201Event event = (EesDmt1201Event)e;
		try{

			List<SearchBasicTariffMonitorVO> list = command.searchBasicTariffMonitor(event.getSearchContinentParamVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}	
		
		return eventResponse;
		
	}
	 
	/**
	 * [EES_DMT_1201] : [search] <br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchBasicTariffNotiList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1202Event event = (EesDmt1202Event)e;
		try{

			List<SearchBasicTariffNotiListVO> list = command.searchBasicTariffNotiList(event.getSearchContinentParamVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}	
		
		return eventResponse;
		
	}

	/**
	 * EES_DMT_7013 : Save <br>
	 * Customer Approval Setup ��옣.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBasicTariffNotiList(Event e) throws EventException {
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1202Event event = (EesDmt1202Event)e;
		
		try{
			begin();
			command.manageBasicTariffNotiList(event.getSearchBasicTariffNotiListVOs(), event.getSignOnUserAccount());
			commit();
		}
		catch(EventException ex){
			rollback();
			throw ex;
		}
		catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * [EES_DMT_1005] : [search] <br>
	 * [trf_rule_no]瑜�[search]�⑸땲��<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCommodityTrfRuleNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<CommodityTariffVO> list = command.searchCommodityTrfRuleNo();

			// �꾨옒 Logic���ㅼ젣 �붾㈃ �곸슜�쒖뿉 蹂�꼍 泥섎━ �꾩슂 : �곸슜 ��二쇱꽍 ��젣 
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getTrfRuleNo()).append("=").append(list.get(i).getTrfRuleNo());
					if (i < list.size() - 1) codes.append("|");
				}
			}

			eventResponse.setETCData("TRF_RULE_NO_LIST", codes.toString());
			
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}	
		
		return eventResponse;
		
	}
	/**
	 * [EES_DMT_7017] : [Retrieve] <br>
	 * Deletion Authority Setup 메뉴에서 Charge Deletion 승인경로 테이블에 등록된 승인경로정보를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchDeletionAuthoritySetupList(Event e) throws EventException {
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt7017Event event = (EesDmt7017Event)e;
		
		try{
			List<ChgDeltPathStupVO> list = command.searchChargeDeletionPathSetupList(event.getSearchChgDeltPathStupVO());
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}	
		
		return eventResponse;
	}	
	
	/**
	 * [EES_DMT_7017] : [Save] <br>
	 * Deletion Authority Setup 메뉴에서 등록 및 수정, 삭제된 설정정보에 대한 트랜잭션처리를 관리합니다.  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDeletionAuthoritySetup(Event e) throws EventException {
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt7017Event event = (EesDmt7017Event)e;
		
		try {
			begin();
			command.manageChargeDeletionPathSetup(event.getChgDeltPathStupVOs(), event.getSignOnUserAccount());
			commit();
		}
		catch(EventException ex){
			rollback();
			throw ex;
		}
		catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * [EES_DMT_7019] : [Retrieve] <br>
	 * Charge Deletion Request File 을 조회합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchChargeDeletionRequestFileList(Event e) throws EventException {
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt7019Event event = (EesDmt7019Event)e;
		
		try{
			List<ChgDeltRqstFileVO> list = command.searchChargeDeletionRequestFileList(event.getChgDeltRqstFileVO());
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}	
		
		return eventResponse;
	}		
	
	/**
	 * [EES_DMT_7017] : [Retrieve] <br>
	 * After BKG Tab 선택된 경우 조회버튼 클릭시 해당 설정된 경로를 조회한다.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAfterBkgSetupList(Event e) throws EventException {
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt7017Event event = (EesDmt7017Event)e;
		
		try{
			List<AftBkgPathSetupVO> list = command.searchAftBkgPathList(event.getAftBkgPathSetupVO());
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}	
		
		return eventResponse;
	}
	
	/**
	 * [EES_DMT_7017] : [Save] <br>
	 * Deletion Authority Setup 메뉴에서 등록 및 수정, 삭제된 설정정보에 대한 트랜잭션처리를 관리합니다.  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAfterBkgSetup(Event e) throws EventException {
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt7017Event event = (EesDmt7017Event)e;
		
		try {
			begin();
			command.manageAftBkgPathSetup(event.getAftBkgPathSetupVOs(), event.getSignOnUserAccount());
			commit();
		}
		catch(EventException ex){
			rollback();
			throw ex;
		}
		catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
}
