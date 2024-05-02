/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTExceptionMgtSC.java
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.04.30 최성환
* 2009.05.12 황효근 <추가>
* 1.0 Creation
* 2010.10.04 김태균 [CHM-201006288-01] [EES-DMT] Session 정보 관련 수정 - 9400 서버에러로 인하여 method 명 변경(comBakEndJb -> comBackEndJb)
* 2010.11.25 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
* 2012.01.09 김현화[CHM-201114916-01]SC or RFA Version 변경시 Tariff 중복 금지logic보완.-RFA 중복 check Return value 변경
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.basic.FaxEmailBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.basic.FaxEmailBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo.GRWEmailNoticeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBC;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CommonCodeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.ContainerCargoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.TariffNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.UserRoleVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.basic.DualTypeExceptionMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.basic.DualTypeExceptionMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.event.EesDmt2014Event;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.event.EesDmt2015Event;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.AllCNTRCargoVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.RFACNTRCargoVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCCNTRCargoVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2003Event;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2005Event;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2006Event;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2105Event;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt7008Event;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFACopyMstToBzcVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionGRPVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionRateAdjustVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAProgressVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event.EesDmt2001Event;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event.EesDmt2007Event;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event.EesDmt2103Event;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCommodityVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionGRPVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionRateAdjustVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVersionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCRFAExceptionListVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.basic.TimeClockStopMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.basic.TimeClockStopMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.event.EesDmt2010Event;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration.TimeClockStopMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.DmtTimeClockStopVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.YardByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.basic.VLVDDateUpdateMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.basic.VLVDDateUpdateMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.event.EesDmt2012Event;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.VslDtUpdListVO;
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
 * alps-DMTExceptionMgt Business Logic ServiceCommand - alps-DMTExceptionMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Choi Sung Hwan
 * @see TimeClockStopMgtDBDAO
 * @since J2EE 1.4
 */

public class DMTExceptionMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DMTExceptionMgt system 업무 시나리오 선행작업<br>
	 * UI_DMT_2010업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * DMTExceptionMgt system 업무 시나리오 마감작업<br>
	 * UI_DMT_2010 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DMTExceptionMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * alps-DMTExceptionMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		
		if (e.getEventName().equalsIgnoreCase("EesDmt2001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCException(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateAdjustment(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVersionByProposalNo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCustomerListBySC(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCommodityListBySC(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = removeSCExceptionByVer(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkCalcType(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = checkCalcDualType(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = checkContinentType(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = checkFiledBySC(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = modifyVersionSTS(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchSCNoCustomerByProposalNo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchSCDuration(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = hasAcceptAuth(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchAffiliateListBySC(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = checkAffiliateCustomer(e);
			}
			//S/C Exception Tariff 의 Group Seq.에 대한 하위 항목들을 모두 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchSubSCException(e);
			}
			//S/C Exception Tariff 의 현재 선택되어진 Group Seq. 정보만 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchSCExceptionByGroupSeq(e);
			}
			//화면에서 입력한 S/C 정보와 기등록된 S/C 정보중 중복된 데이터가 있는지 조회 합니다.	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = checkDuplicateSCException(e);
			}
			//화면에서 입력한 PROP_NO에 대한 CUSTOMER 정보가 중복인지 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = isCustomerByPriMn(e);
			}
			//페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchSCInitControls(e);
			}
			//S/C Exception Tariff 의 선택한 Group Seq. 와 그 하위 모든 항목을 삭제한다.
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = removeSCException(e);
			}	
			//Update 버튼 클릭시 'Live'상태의 S/C Exception Tariff 정보를 새로운 버전으로 생성한다.
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createSCExceptionByUpdate(e);
			}
			//S/C Exception Tariff History 팝업화면에서 Copy 버튼 클릭시 현재 버전에 있는 정보를 삭제하고 현재 버전에 선택한 버전의 정보로  생성한다.
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = createSCExceptionByHistoryCopy(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifySCException(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt2003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBeforeExceptionList(e);
			}			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBeforeDARList(e);
			}
			//DAR No. 에 해당되는 VER No. 정보를 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBeforeVERList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCustomerListByRFA(e);
			}
			//Proposal No. 로 Affiliate 정보를 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchAffiliateListByRFA(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchBeforeNewDAR(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = requestBeforeException(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = cancelBeforeException(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = approvalBeforeException(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = counterofferBeforeException(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = rejectBeforeException(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchBeforeAPROList(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchCustomerByProp(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchRFAByProp(e);
			}
			//Proposal No. 로 RFA No. 와 Customer Cd 와 Customer Name 을 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchRFANoCustomerByProposalNo(e);
			}
			//Before Booking Request 의 Request Detail. 에 대한 하위 항목들을 모두 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchSubBeforeException(e);
			}
			//Before Booking Request 의 현재 선택되어진 Request Detail. 정보만 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchBeforeExceptionByDetailSeq(e);
			}
			//Before Booking Request 의 현재 선택되어진 Request Detail. 정보만 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = checkDuplicateBeforeException(e);
			}
			//Before Booking의 APVL No. 에 해당되는 APVL OFC, DAR No., Version, Status 를 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchRFATariffByAPVLNo(e);
			}
			//페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchRFAInitControls(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyBeforeException(e);
			}			
			//Before Booking Request 의 선택한 Detail Seq. 와 그 하위 모든 항목을 삭제한다.
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = removeBeforeException(e);
			}	
			//Update 버튼 클릭시 'Approved', 'Rejected' 상태의 Before Booking Request 정보를 새로운 버전으로 생성한다.
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = addBeforeExceptionByUpdate(e);
			}
			//DAR History 팝업화면에서 Copy 버튼 클릭시 현재 버전에 있는 정보를 삭제하고 현재 버전에 선택한 버전의 정보로  생성한다.
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = addBeforeExceptionByHistoryCopy(e);
			}			
			// 2017.06.05 Auto Update 실행시 Master RFA 의 유효한 상위버전 정보를 Basic RFA 에 Copy 합니다.
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = copyMstRfaVerToBzcRfaVer(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt2005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBeforeExceptionList(e);
			}			
			//DAR No. 에 해당되는 VER No. 정보를 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBeforeVERList(e);
			}
			//Proposal No. 로 Affiliate 정보를 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchAffiliateListByRFA(e);
			}
			//DAR No. 나 Approval No. 로 Proposal No. 를 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchPropNoByDARApprovalNo(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchCommentHistory(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = approvalBeforeException(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = counterofferBeforeException(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = rejectBeforeException(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchBeforeAPROList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchCustomerByProp(e);
			}
			//Proposal No. 로 RFA No. 와 Customer Cd 와 Customer Name 을 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchRFANoCustomerByProposalNo(e);
			}	
			//Approval No. 에 해당되는 RFA(Before Booking Request) 의 VER 를 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchVERByApprovalNo(e);
			}
			//DAR No. 에 해당되는 Approval Office Code 를 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchApprovalOfcByDAR(e);
			}
			//Before Booking Request 의 Request Detail. 에 대한 하위 항목들을 모두 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchSubBeforeException(e);
			}			
			//Approved 상태일때 Apro_no를 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchAproNoByPropApprovalNo(e);
			}			
		}
		//DEM/DET Adjustment Request & Approval Status
		else if (e.getEventName().equalsIgnoreCase("EesDmt2006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBeforeAfterStatusList(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt2007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCRFAExceptionList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSCTieredFreeTimeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSCRateAdjustmentList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSCActualCustomerList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchSCCommodityList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchRFAMultiCoverageList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchRFARateAdjustmentList(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt2010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTimeClockStop(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//It gets a status of backendjob. 2
				eventResponse = comBakEndJb(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//It starts a job of backend. 1
				eventResponse = doBackEndJob(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){//It returns a result. 3
				eventResponse = createTimeClockStopBackEndJob(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND22)) {//It gets a status of backendjob. 2
				eventResponse = comCancelBakEndJb(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND11)) {//It starts a job of backend. 1
				eventResponse = doCancelBackEndJob(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){//It returns a result. 3
				eventResponse = cancelTimeClockStopBackEndJob(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTimeClockStopList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDMTYardByOffice(e);
			}
		}
		else if ( e.getEventName().equalsIgnoreCase("EesDmt2012Event") ) {
            if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
                eventResponse = searchVLVDByVVDList(e);
            } 
            else if ( e.getFormCommand().isCommand(FormCommand.MULTI) ) {
                eventResponse = manageVLVDDate(e);
            }
        }		
		else if (e.getEventName().equalsIgnoreCase("EesDmt2014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDualTypeCustomer(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDualTypeCustomerList(e);
			}
			//선택한 Customer 가 S/C, Before 인지를 체크한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkDualTypeCustomer(e);
			}
			//입력한 Coverage 가 Dual 인지를 체크한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkDualCoverage(e);
			}
			//Dual Type Exception 이 삭제가능한지를 체크한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkDelDualTypeCustomer(e);
			}			
			//Expire Date 가 유효한지 체크한다.(S/C, Before Booking 데이터의 Expire Date 보다 작다면 에러)
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkDualTypeExpireDate(e);
			}
			//입력한 Dual Type Exception 이 중복된 데이터인지 체크한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkDuplicateDualTypeException(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDualTypeCustomer(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt2015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDualTypeCustomer(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDualTypeCustomerList(e);
			}
			//Dual Type Exception Applied 데이터를 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSCorDARListByCustomer(e);
			}			
		}		
		//S/C Exception Tariff History
		else if (e.getEventName().equalsIgnoreCase("EesDmt2103Event")) {
			//1.S/C Exception History By S/C No.
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCExceptionListByPropNo(e);
			}
			//2.S/C Exception History By Customer
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSCExceptionListByCustomer(e);
			}				
		}
		//DAR History
		else if (e.getEventName().equalsIgnoreCase("EesDmt2105Event")) {
			//1.DAR History By RFA No.
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBeforeExceptionListByPropNo(e);
			}
			//1.DAR History By Customer
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBeforeExceptionListByCustomer(e);
			}				
		}
		//Approval Authority Inquiry
		else if (e.getEventName().equalsIgnoreCase("EesDmt7008Event")) {
			//Approval Authority Inquiry - before/after booking
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchApprovalAuthorityList(e);
			}
		
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
	private EventResponse searchSCException(Event e) throws EventException {
		EesDmt2001Event 				event 				= (EesDmt2001Event)e;
		SCExceptionTariffMgtBC 			command 			= new SCExceptionTariffMgtBCImpl();
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();

		//Continent 에 해당되는 Country 목록을 가진다.
		Map<String, Object> mapCountryCodes = new HashMap<String, Object>();
		Map<String, Object> mapCountryNames = new HashMap<String, Object>();

		//Country 에 해당되는 Region 목록을 가진다.
		Map<String, Object> mapRegionCodes 	= new HashMap<String, Object>();
		Map<String, Object> mapRegionNames 	= new HashMap<String, Object>();
		
		String 				cntCd 			= null;
		String 				contiCd 		= null;

		
		try{
			List<SCExceptionVO> 			sCExceptionVOs		= command.searchSCException(event.getSCExceptionParmVO());
		
			//S/C Exception Terms Entry
			if (sCExceptionVOs != null && sCExceptionVOs.size() > 0) {
	
				for (int i = 0 ; i < sCExceptionVOs.size() ; i++) {
	
					//Coverage
					cntCd = sCExceptionVOs.get(i).getCntCd() != null ? sCExceptionVOs.get(i).getCntCd().trim() : "";
					if (cntCd.length() > 0) {
						if (!mapRegionCodes.containsKey(cntCd)) {
							CommonCodeVO commonCodeVO = getAllRegion(cntCd);
							mapRegionCodes.put(cntCd, commonCodeVO.getIntgCdId());
							mapRegionNames.put(cntCd, commonCodeVO.getIntgCdValDpDesc());
						}
						sCExceptionVOs.get(i).setRgnAllCd((String)mapRegionCodes.get(cntCd));
						sCExceptionVOs.get(i).setRgnAllNm((String)mapRegionNames.get(cntCd));				
					} else {
						sCExceptionVOs.get(i).setRgnAllCd("");
						sCExceptionVOs.get(i).setRgnAllNm("");
					}
					
					//Origin(I) or Dest.(O)
					contiCd = sCExceptionVOs.get(i).getScExptFmContiCd() != null ? sCExceptionVOs.get(i).getScExptFmContiCd().trim() : "";
					if (contiCd.length() > 0) {
						if (!mapCountryCodes.containsKey(contiCd)) {
							CommonCodeVO commonCodeVO = getAllCountry(contiCd);
							mapCountryCodes.put(contiCd, commonCodeVO.getIntgCdId());
							mapCountryNames.put(contiCd, commonCodeVO.getIntgCdValDpDesc());
						}
						sCExceptionVOs.get(i).setScExptFmCntAllCd((String)mapCountryCodes.get(contiCd));
						sCExceptionVOs.get(i).setScExptFmCntAllNm((String)mapCountryNames.get(contiCd));				
					} else {
						sCExceptionVOs.get(i).setScExptFmCntAllCd("");
						sCExceptionVOs.get(i).setScExptFmCntAllNm("");
					}
					
					cntCd = sCExceptionVOs.get(i).getScExptFmCntCd() != null ? sCExceptionVOs.get(i).getScExptFmCntCd().trim() : "";
					if (cntCd.length() > 0) {
						if (!mapRegionCodes.containsKey(cntCd)) {
							CommonCodeVO commonCodeVO = getAllRegion(cntCd);
							mapRegionCodes.put(cntCd, commonCodeVO.getIntgCdId());
							mapRegionNames.put(cntCd, commonCodeVO.getIntgCdValDpDesc());
						}
						sCExceptionVOs.get(i).setScExptFmRgnAllCd((String)mapRegionCodes.get(cntCd));
						sCExceptionVOs.get(i).setScExptFmRgnAllNm((String)mapRegionNames.get(cntCd));				
					} else {
						sCExceptionVOs.get(i).setScExptFmRgnAllCd("");
						sCExceptionVOs.get(i).setScExptFmRgnAllNm("");
					}
					
					//BKG DEL(I) or POR(O)
					cntCd = sCExceptionVOs.get(i).getFnlDestCntCd() != null ? sCExceptionVOs.get(i).getFnlDestCntCd().trim() : "";
					if (cntCd.length() > 0) {
						if (!mapRegionCodes.containsKey(cntCd)) {
							CommonCodeVO commonCodeVO = getAllRegion(cntCd);
							mapRegionCodes.put(cntCd, commonCodeVO.getIntgCdId());
							mapRegionNames.put(cntCd, commonCodeVO.getIntgCdValDpDesc());
						}
						sCExceptionVOs.get(i).setFnlDestRgnAllCd((String)mapRegionCodes.get(cntCd));
						sCExceptionVOs.get(i).setFnlDestRgnAllNm((String)mapRegionNames.get(cntCd));				
					} else {
						sCExceptionVOs.get(i).setFnlDestRgnAllCd("");
						sCExceptionVOs.get(i).setFnlDestRgnAllNm("");
					}
				}
			}
			
			eventResponse.setRsVoList(sCExceptionVOs);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * S/C Exception Tariff 의 Group Seq 에 포함되는 Multi Coverage, Tiered Free Time, Rate Adjustment, Customer, Commodity 를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubSCException(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 				= new GeneralEventResponse();
		EesDmt2001Event 				event 						= (EesDmt2001Event)e;
		SCExceptionTariffMgtBC 			command 					= new SCExceptionTariffMgtBCImpl();
		
		try{
		
			//Multi Coverage 조회
			List<SCExceptionCoverageVO>		sCExceptionCoverageVOs		= command.searchMultiCoverageBySC(event.getSCExceptionParmVO());
			
			//Tiered Free Time 조회
			List<SCExceptionFreeTimeVO>		sCExceptionFreeTimeVOs		= command.searchTieredFreeTimeBySC(event.getSCExceptionParmVO());
			
			//Rate Adjustment 조회
			List<SCExceptionRateAdjustVO>	sCExceptionRateAdjustVOs	= command.searchRateAdjustmentBySC(event.getSCExceptionParmVO());
			
			//Customer 조회
			List<SCExceptionCustomerVO>		sCExceptionCustomerVOs		= command.searchCustomerBySC(event.getSCExceptionParmVO());
			
			//Commodity 조회
			List<SCExceptionCommodityVO>	sCExceptionCommodityVOs		= command.searchCommodityBySC(event.getSCExceptionParmVO());
			
			//Country 에 해당되는 Region 목록을 가진다.
			Map<String, Object> mapRegionCodes 	= new HashMap<String, Object>();
			Map<String, Object> mapRegionNames 	= new HashMap<String, Object>();
			
			String 				cntCd 			= null;
			
			//S/C Exception Multi Coverage
			if (sCExceptionCoverageVOs != null && sCExceptionCoverageVOs.size() > 0) {
	
				for (int i = 0 ; i < sCExceptionCoverageVOs.size() ; i++) {
	
					//Coverage
					cntCd = sCExceptionCoverageVOs.get(i).getCntCd() != null ? sCExceptionCoverageVOs.get(i).getCntCd().trim() : "";
					if (cntCd.length() > 0) {
						if (!mapRegionCodes.containsKey(cntCd)) {
							CommonCodeVO reVO = getAllRegion(cntCd);
							mapRegionCodes.put(cntCd, reVO.getIntgCdId());
							mapRegionNames.put(cntCd, reVO.getIntgCdValDpDesc());
						}
						sCExceptionCoverageVOs.get(i).setRgnAllCd((String)mapRegionCodes.get(cntCd));
						sCExceptionCoverageVOs.get(i).setRgnAllNm((String)mapRegionNames.get(cntCd));				
					} else {
						sCExceptionCoverageVOs.get(i).setRgnAllCd("");
						sCExceptionCoverageVOs.get(i).setRgnAllNm("");
					}				
				}
			}
			
			eventResponse.setRsVoList(	sCExceptionCoverageVOs		);
			eventResponse.setRsVoList(	sCExceptionFreeTimeVOs		);
			eventResponse.setRsVoList(	sCExceptionRateAdjustVOs	);
			eventResponse.setRsVoList(	sCExceptionCustomerVOs		);
			eventResponse.setRsVoList(	sCExceptionCommodityVOs		);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * EES_DMT_2001 : Save<br>
	 * 화면에서 입력한 S/C 정보와 기등록된 S/C 정보중 중복된 데이터가 있는지 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDuplicateSCException(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 				= new GeneralEventResponse();
		EesDmt2001Event 				event 						= (EesDmt2001Event)e;
		SCExceptionTariffMgtBC 			command 					= new SCExceptionTariffMgtBCImpl();
		
		try {
			//중복된 데이터인지 조회를 실행합니다.
			boolean isDuplicate = command.isDuplicateSC(event.getSCExceptionParmVO());
	
			eventResponse.setETCData("RESULT", isDuplicate ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Continent CD 에 대한 해당 데이터를 조회 합니다. <br>
	 * 
	 * @param contiCd String
	 * @return map Map<String,String>
	 * @exception
	 */	
	private CommonCodeVO getAllCountry(String contiCd) {
		CoverageVO cvrgVO = null;
		List<CoverageVO> list = null;
		StringBuffer codes = new StringBuffer();
		StringBuffer names = new StringBuffer();
		CommonCodeVO reVO = new CommonCodeVO();
		CommonFinderBC command = new CommonFinderBCImpl();

		try {
			cvrgVO = new CoverageVO();
			cvrgVO.setContiCd(contiCd);
			list = command.searchCountryListByContinent(cvrgVO);
			if (list != null && list.size() > 0) {
				for (int j = 0 ; j < list.size() ; j++) {
					codes.append(list.get(j).getCode(CoverageVO.CVRG_COUNTRY));
					names.append(list.get(j).getCode(CoverageVO.CVRG_COUNTRY));
					names.append("\t");
					names.append(list.get(j).getName(CoverageVO.CVRG_COUNTRY));
					if (j < list.size()-1) {
						codes.append("|");
						names.append("|");
					}							
				}
			}
		} catch(EventException e) {
			log.error(e.getMessage());	
		} catch(Exception e) {
			log.error(e.getMessage());
		} finally {
			reVO.setIntgCdId(codes.toString());
			reVO.setIntgCdValDpDesc(names.toString());			
		}
		
		return reVO;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Country CD 에 대한 해당 데이터를 조회 합니다. <br>
	 * 
	 * @param cntCd String
	 * @return CommonCodeVO
	 * @exception
	 */		
	private CommonCodeVO getAllRegion(String cntCd){
		String key = null;
		CoverageVO cvrgVO = null;
		List<CoverageVO> list = null;
		StringBuffer codes = new StringBuffer();
		StringBuffer names = new StringBuffer();
		CommonCodeVO reVO  = new CommonCodeVO();
		CommonFinderBC command = new CommonFinderBCImpl();

		try {
			cvrgVO = new CoverageVO();
			cvrgVO.setCntCd(cntCd);
			if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
				list = command.searchStateListByCountry(cvrgVO);
				key = CoverageVO.CVRG_STATE;
			}
			else {
				list = command.searchRegionListByCountry(cvrgVO);
				key = CoverageVO.CVRG_REGION;
			}
			if (list != null && list.size() > 0) {
				for (int j = 0 ; j < list.size() ; j++) {
					codes.append(list.get(j).getCode(key));
					names.append(list.get(j).getCode(key));
					names.append("\t");
					names.append(list.get(j).getName(key));
					if (j < list.size()-1) {
						codes.append("|");
						names.append("|");
					}							
				}
			}
		} catch(EventException e) {
			log.error(e.getMessage());
		} catch(Exception e) {
			log.error(e.getMessage());
		} finally {
			reVO.setIntgCdId(codes.toString());
			reVO.setIntgCdValDpDesc(names.toString());			
		}
		
		return reVO;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * S/C 와 RFA(Before Booking) 에 해당되는 CNTR/Cargo Type 전체 데이터를 조회 합니다.
	 * 
	 * @param typeCd String
	 * @return map Map<String,String>
	 * @exception
	 */		
	private AllCNTRCargoVO getAllContainerCargoType(String intgCdId, String code1, String code2) {

		CommonCodeVO 		codeVO 				= null;
		ContainerCargoVO 	cargoVO 			= null;
		
		StringBuffer 		sCCNTRCargoCode 	= new StringBuffer();
		StringBuffer 		sCCNTRCargoDesc 	= new StringBuffer();
		StringBuffer 		rFACNTRCargoCode 	= new StringBuffer();
		StringBuffer 		rFACNTRCargoDesc 	= new StringBuffer();

		AllCNTRCargoVO 		allCNTRCargoVO 		= new AllCNTRCargoVO();
		SCCNTRCargoVO 		sCCNTRCargoVO 		= new SCCNTRCargoVO();
		RFACNTRCargoVO 		rFACNTRCargoVO 		= new RFACNTRCargoVO();
		
		CommonFinderBC 		command 			= new CommonFinderBCImpl();

		try {
			//S/C 에 해당하는 모든 CNTR/Cargo Type 정보를 조회한다.
			codeVO = new CommonCodeVO();
			codeVO.setIntgCdId(intgCdId);
			List<CommonCodeVO> sCCNTRCargoVOList = command.searchCommonCode(codeVO);
			
			if (sCCNTRCargoVOList != null && sCCNTRCargoVOList.size() > 0) {
				
				for (int i = 0 ; i < sCCNTRCargoVOList.size() ; i++) {
					sCCNTRCargoCode.append(sCCNTRCargoVOList.get(i).getIntgCdValCtnt());
					sCCNTRCargoDesc.append(sCCNTRCargoVOList.get(i).getIntgCdValDpDesc());
					
					if (i < sCCNTRCargoVOList.size() - 1) {
						sCCNTRCargoCode.append("|");
						sCCNTRCargoDesc.append("|");
					}
				}
				sCCNTRCargoVO.setSccntrCargoCode(sCCNTRCargoCode.toString());
				sCCNTRCargoVO.setSccntrCargoDesc(sCCNTRCargoDesc.toString());
			}else{
				sCCNTRCargoVO.setSccntrCargoCode("");
				sCCNTRCargoVO.setSccntrCargoDesc("");
			}

			//Before 에 해당하는 모든 CNTR/Cargo Type 정보를 조회한다.
			cargoVO = new ContainerCargoVO();
			cargoVO.setCode1(code1);
			cargoVO.setCode2(code2);
			List<ContainerCargoVO> rFACNTRCargoVOList = command.searchContainterCargoList(cargoVO);
			
			if (rFACNTRCargoVOList != null && rFACNTRCargoVOList.size() > 0) {
			
				for (int i = 0 ; i < rFACNTRCargoVOList.size() ; i++) {
					rFACNTRCargoCode.append(rFACNTRCargoVOList.get(i).getCntrCgo());
					rFACNTRCargoDesc.append(rFACNTRCargoVOList.get(i).getDmdtCgoTpNm())
									.append(" - ")
									.append(rFACNTRCargoVOList.get(i).getDmdtCntrTpNm());
					
					if (i < rFACNTRCargoVOList.size() - 1) {
						rFACNTRCargoCode.append("|");
						rFACNTRCargoDesc.append("|");
					}
				}
				rFACNTRCargoVO.setRfacntrCargoCode(rFACNTRCargoCode.toString());
				rFACNTRCargoVO.setRfacntrCargoDesc(rFACNTRCargoDesc.toString());				
			}else{
				rFACNTRCargoVO.setRfacntrCargoCode("");
				rFACNTRCargoVO.setRfacntrCargoDesc("");				
			}
		} catch(EventException e){
			log.error(e.getMessage());
		} catch(Exception e) {
			log.error(e.getMessage());
		} finally {
			allCNTRCargoVO.setSCCNTRCargoVO(sCCNTRCargoVO);
			allCNTRCargoVO.setRFACNTRCargoVO(rFACNTRCargoVO);
		}
		
		return allCNTRCargoVO;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Rate Adjustment 가 필수항목인지 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkRateAdjustment(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 		= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 			event 			= (EesDmt2001Event)e;
		try {
			
			String 						result 			= command.checkRateAdjustment(event.getSCExceptionParmVO());
			
			eventResponse.setETCData("RT_MANDATORY", result);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_2001 : Open<br>
	 * Proposal No. 에 해당되는 모든 Version 정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVersionByProposalNo(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 		= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 			event 			= (EesDmt2001Event)e;
		
		try{
			List<SCExceptionVersionVO> 	list 			= command.searchVersionByProposalNo(event.getSCExceptionParmVO());
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getScExptVerSeq()).append("=").append(list.get(i).getDmdtExptVerStsCd());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			else {
				codes.append("001").append("=").append("");
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
	 * EES_DMT_2001 : Open<br>
	 * Proposal No. 에 해당하는 Actual Customer / Affiliate 정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCustomerListBySC(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 		= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 			event 			= (EesDmt2001Event)e;
		try{
			List<SCExceptionCustomerVO>	custList		= command.searchCustomerListBySC(event.getSCExceptionParmVO());
			StringBuffer 				sbCust			= new StringBuffer();
			
			if (custList != null && custList.size() > 0) {
				sbCust.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < custList.size() ; i++) {
					sbCust.append(custList.get(i).getCustCd()).append("=").append(custList.get(i).getCustNm());
					if (i < custList.size() - 1) sbCust.append("|");
				}
			}
	
			eventResponse.setETCData("CUST", sbCust.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Open<br>
	 * Proposal No. 에 해당하는 Commodity 정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCommodityListBySC(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 		= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 			event 			= (EesDmt2001Event)e;
		try{
			List<SCExceptionCommodityVO> list 			= command.searchCommodityListBySC(event.getSCExceptionParmVO());
			StringBuffer 				sbCmdtCodes		= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				sbCmdtCodes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < list.size() ; i++) {
					sbCmdtCodes.append(list.get(i).getCmdtCd()).append("=").append(list.get(i).getCmdtNm());
					if (i < list.size() - 1) sbCmdtCodes.append("|");
				}
			}
	
			eventResponse.setETCData("CMDT", sbCmdtCodes.toString());
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
	private EventResponse modifySCException(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		SCExceptionGRPVO 		sCExceptionGRPVO 	= new SCExceptionGRPVO();
		
		sCExceptionGRPVO.setSCExceptionVersionVO(		event.getSCExceptionVersionVO()		);
		sCExceptionGRPVO.setSCExceptionVOS(				event.getSCExceptionVOS()			);
		sCExceptionGRPVO.setSCExceptionCoverageVOS(		event.getSCExceptionCoverageVOS()	);
		sCExceptionGRPVO.setSCExceptionFreeTimeVOS(		event.getSCExceptionFreeTimeVOS()	);
		sCExceptionGRPVO.setSCExceptionRateAdjustVOS(	event.getSCExceptionRateAdjustVOS()	);
		sCExceptionGRPVO.setSCExceptionCustomerVOS(		event.getSCExceptionCustomerVOS()	);
		sCExceptionGRPVO.setSCExceptionCommodityVOS(	event.getSCExceptionCommodityVOS()	);
		
		try {
			begin();
			String groupSeq = command.modifySCException(sCExceptionGRPVO, account);
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
	 * EES_DMT_2001 : Delete<br>
	 * Proposal no, Version no 에 대한 해당 데이터를 삭제 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeSCExceptionByVer(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		SCExceptionParmVO 		sCExceptionParmVO 	= event.getSCExceptionParmVO();
		
		try{
			sCExceptionParmVO.setUpdUsrId(account.getUsr_id());
			sCExceptionParmVO.setUpdOfcCd(account.getOfc_cd());
			begin();
			command.removeSCExceptionByVer(sCExceptionParmVO);
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
	 * EES_DMT_2001 : Save<br>
	 * Tariff Type 에 해당되는 Calculation Type 이 존재하는지 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkCalcType(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		SCExceptionParmVO 		sCExceptionParmVO 	= event.getSCExceptionParmVO();
		
		try{
		
			//조회용 파라미터
			//0 : Coverage
			//1 : Tariff 
			//2 : Effective Data
			//3 : Expire Data
			//4 : CNTR/Cargo Type
			//5 : Cust CD
			String[] 	chkCalcTpIn 	= sCExceptionParmVO.getChkCalcTpIn().split("\\|");
			//Coverage 정보 추출
			String[] 	coverageItems 	= chkCalcTpIn[0].split("\\^");
			//Tariff 정보 추출
			String 		tariff 			= chkCalcTpIn[1];
			//Bound 정보 추출(Tariff 정보로 부터 추출)
			String 		bound 			= tariff.substring(2, 3);
			//Calculation Type Code 정보 추출(Tariff 정보로 부터 추출)
			String 		calcTpCd 		= tariff.substring(0, 1);
			//DMIF,DMOF 의  경우 BKG DEL(I) or POR(O) 입력시 해당 지역의 Calculation Type
			//이 Combined 일 경우 에러체크를 하는 로직을 태우도록 구분하기 위한 변수
			String 		checkCombined 	= sCExceptionParmVO.getChkCalcTpCombined();
			
			String 					isResult 		= null;
			String[] 				coverageItem 	= null;
			CalculationTypeParmVO 	calcVO 			= null;
			
			for (int i = 0 ; i < coverageItems.length ; i++) {
				calcVO = new CalculationTypeParmVO();
				//Coverage 정보 세팅
				coverageItem = coverageItems[i].split("=");
				calcVO.setCntCd(coverageItem[0]);
				if ("US".equals(coverageItem[0]) || "CA".equals(coverageItem[0])) {
					calcVO.setSteCd(coverageItem[1]);
				}
				else {
					calcVO.setRgnCd(coverageItem[1]);
				}
				calcVO.setLocCd(coverageItem[2]);
				//Bound 정보 세팅
				calcVO.setIoBndCd(bound);
				//Calculation Type 정보 세팅
				if ("Y".equals(checkCombined))  {
					calcVO.setDmdtCalcTpCd("C");
				}
				else {
					calcVO.setDmdtCalcTpCd(calcTpCd);
				}
				calcVO.setEffDt(chkCalcTpIn[2]);
				calcVO.setExpDt(chkCalcTpIn[3]);
				
				boolean result = command.checkCalcType(calcVO);
				if (("Y".equals(checkCombined) && result) || ("N".equals(checkCombined) && !result)) {
					isResult = "E";
					break;
				}
			}
			if (isResult == null) isResult = "O";
			
			//isResult(E: Error, O: Option)
			eventResponse.setETCData("CALC", isResult);
			if ("E".equals(isResult)) {
				eventResponse.setETCData("CNT", calcVO.getCntCd() != null ? calcVO.getCntCd() : "");
				eventResponse.setETCData("RGN", calcVO.getRgnCd() != null ? calcVO.getRgnCd() : "");
				eventResponse.setETCData("STE", calcVO.getSteCd() != null ? calcVO.getSteCd() : "");
				eventResponse.setETCData("LOC", calcVO.getLocCd() != null ? calcVO.getLocCd() : "");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_2001 : Save<br>
	 * Tariff Type 에 해당되는 Calculation Type 와 Dual Type 이 존재하는지 체크한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkCalcDualType(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		SCExceptionParmVO 		sCExceptionParmVO 	= event.getSCExceptionParmVO();
		
		try{
		
			//조회용 파라미터
			//0 : Coverage
			//1 : Tariff 
			//2 : Effective Data
			//3 : Expire Data
			//4 : CNTR/Cargo Type
			//5 : Cust CD
			String[] 	chkCalcTpIn 	= sCExceptionParmVO.getChkCalcTpIn().split("\\|");
			//Coverage 정보 추출
			String[] 	coverageItems 	= chkCalcTpIn[0].split("\\^");
			//Tariff 정보 추출
			String 		tariff 			= chkCalcTpIn[1];
			//Effective Date 정보 추출
			String 		effDt 			= chkCalcTpIn[2];
			//Expose Date 정보 추출
			String 		expDt 			= chkCalcTpIn[3];
			//Container / Cargo 정보 추출
			String 		cntrCgoTp 		= chkCalcTpIn[4];
			//Customer Code 정보 추출
			String 		custCd 			= chkCalcTpIn[5];		
			//Bound 정보 추출(Tariff 정보로 부터 추출)
			String 		bound 			= tariff.substring(2, 3);
			//Calculation Type Code 정보 추출(Tariff 정보로 부터 추출)
			String 		calcTpCd 		= tariff.substring(0, 1);
			
			String 					isResult 		= null;
			String[] 				coverageItem 	= null;
			CalculationTypeParmVO 	calcVO 			= null;
			DualTypeCustomerVO 		dualTypVO 		= null;
			
			for (int i = 0 ; i < coverageItems.length ; i++) {
				calcVO = new CalculationTypeParmVO();
				//Coverage 정보 세팅
				coverageItem = coverageItems[i].split("=");
				calcVO.setCntCd(coverageItem[0]);
				if ("US".equals(coverageItem[0]) || "CA".equals(coverageItem[0])) {
					calcVO.setSteCd(coverageItem[1]);
				}
				else {
					calcVO.setRgnCd(coverageItem[1]);
				}
				calcVO.setLocCd(coverageItem[2]);
				//Bound 정보 세팅
				calcVO.setIoBndCd(bound);
				//Calculation Type 정보 세팅
				calcVO.setDmdtCalcTpCd(calcTpCd);
				//날짜 기간
				calcVO.setEffDt(chkCalcTpIn[2]);
				calcVO.setExpDt(chkCalcTpIn[3]);	
				
			
				//Calculation Check 에 실패했다면 Dual Type 을 Check 한다.
				if (!command.checkCalcType(calcVO)) {
					dualTypVO = new DualTypeCustomerVO();
					dualTypVO.setCustCntCd(			custCd.substring(0,2)					);
					dualTypVO.setCustSeq(			custCd.substring(2)						);
					dualTypVO.setCvrgCntCd(			coverageItem[0]							);
					dualTypVO.setCvrgRgnSteCd(		coverageItem[1]							);
					dualTypVO.setCvrgLocCd(			coverageItem[2]							);
					dualTypVO.setIoBndCd(			bound									);
					dualTypVO.setDmdtCtrtExptTpCd(	sCExceptionParmVO.getDmdtCtrtExptTpCd()	);
					dualTypVO.setDulExptEffDt(		effDt									);
					dualTypVO.setDulExptExpDt(		expDt									);
					dualTypVO.setDmdtCntrCgoTpCd(	cntrCgoTp								);
					dualTypVO.setPropNo(			sCExceptionParmVO.getPropNo()			);
					
					if (!command.checkDualTypeCoverage(dualTypVO)) {
						isResult = "E";
						break; 					
					}
					else {
						isResult = "M";
					}
				}
				else {
					if (isResult == null) isResult = "O";
				}
			}
			
			//isResult(E: Error, M: Mandatory, O: Option)
			eventResponse.setETCData("CALC", isResult);
			if ("E".equals(isResult)) {
				if( calcVO != null ) {
					eventResponse.setETCData("CNT", calcVO.getCntCd() != null ? calcVO.getCntCd() : "");
					eventResponse.setETCData("RGN", calcVO.getRgnCd() != null ? calcVO.getRgnCd() : "");
					eventResponse.setETCData("STE", calcVO.getSteCd() != null ? calcVO.getSteCd() : "");
					eventResponse.setETCData("LOC", calcVO.getLocCd() != null ? calcVO.getLocCd() : "");
				} else {
					eventResponse.setETCData("CNT", "");
					eventResponse.setETCData("RGN", "");
					eventResponse.setETCData("STE", "");
					eventResponse.setETCData("LOC", "");
				}
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * BKG POR(O) or DEL(I) 의 입력된 CN 의 Continent 와 Coverage CN 의 Continent 가 동일한지를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkContinentType(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		try{
			boolean 				isCheck 			= command.checkContinentType(event.getSCExceptionVO());
			
			eventResponse.setETCData("EQUAL", isCheck ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
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
	private EventResponse checkFiledBySC(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		try{
			boolean 				isCheck 			= command.checkFiledBySC(event.getSCExceptionParmVO());
	
			eventResponse.setETCData("FILED", isCheck ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
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
	private EventResponse modifyVersionSTS(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		SCExceptionVersionVO 	versionVO 			= event.getSCExceptionVersionVO();
		
		try{
			versionVO.setCreUsrId(account.getUsr_id());
			versionVO.setCreOfcCd(account.getOfc_cd());
			versionVO.setUpdUsrId(account.getUsr_id());
			versionVO.setUpdOfcCd(account.getOfc_cd());

			begin();
			command.modifyVersionSTS(versionVO);
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
	 * Proposal No 의 해당 SC No. 와 Customer 정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCNoCustomerByProposalNo(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 			event 				= (EesDmt2001Event)e;
		try{
			List<SCExceptionCustomerVO> list 				= command.searchSCNoCustomerByProposalNo(event.getSCExceptionParmVO());
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("SC_NO", list.get(0).getScNo());
				eventResponse.setETCData("CUST_SEQ", list.get(0).getCustSeq());
				eventResponse.setETCData("CUST_CD", list.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", list.get(0).getCustNm());
			}
			else {
				eventResponse.setETCData("SC_NO", "");
				eventResponse.setETCData("CUST_SEQ", "");
				eventResponse.setETCData("CUST_CD", "");
				eventResponse.setETCData("CUST_NM", "");			
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2001 : Open<br>
	 * Proposal No 의 S/C Duration 데이터를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCDuration(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		
		try{
			SCExceptionParmVO 		sCDurationVO 		= command.searchSCDuration(event.getSCExceptionParmVO());
	
			if (sCDurationVO != null) {
				eventResponse.setETCData("EFF_DT", sCDurationVO.getEffDt());
				eventResponse.setETCData("EXP_DT", sCDurationVO.getExpDt());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}	
	
	/**
	 * EES_DMT_2001 : Open<br>
	 * S/C Exception Tariff 를 Accept, Accept Cancel 할 수 있는 권한이 있는지를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse hasAcceptAuth(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		try{
			boolean 				hasAuth 			= command.hasAcceptAuth(event.getSCExceptionParmVO());
			
			eventResponse.setETCData("HAS_AUTH", hasAuth ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2001 : Open<br>
	 * Affiliate Customer 정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAffiliateListBySC(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 			event 				= (EesDmt2001Event)e;
		
		try{
			List<SCExceptionCustomerVO> list 				= command.searchAffiliateListBySC(event.getSCExceptionParmVO());
			StringBuffer 				sbCustCodes 		= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				sbCustCodes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < list.size() ; i++) {
					sbCustCodes.append(list.get(i).getCustCd()).append("=").append(list.get(i).getCustNm());
					if (i < list.size() - 1) sbCustCodes.append("|");
				}
			}
	
			eventResponse.setETCData("CUST", sbCustCodes.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Open<br>
	 * Customer Type 이 'Affiliate' 인지를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkAffiliateCustomer(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		try{
			boolean 				result 				= command.checkAffiliateCustomer(event.getSCExceptionParmVO());
	
			eventResponse.setETCData("RESULT", result ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Row Delete<br>
	 * 선택한 S/C Exception Tariff 와 그 하위항목을 모두 삭제 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse removeSCException(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;

		try {
			begin();
			command.removeSCException(event.getSCExceptionParmVO());
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
	 * EES_DMT_2001 : Update<br>
	 * Update 버튼 클릭시 'Live'상태의 S/C Exception Tariff 정보를 새로운 버전으로 생성 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse createSCExceptionByUpdate(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		SCExceptionParmVO		sCExceptionParmVO	= event.getSCExceptionParmVO();

		try {
			sCExceptionParmVO.setCreUsrId(account.getUsr_id());
			sCExceptionParmVO.setCreOfcCd(account.getOfc_cd());
			
			begin();
			command.createSCExceptionByUpdate(sCExceptionParmVO);
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
	 * EES_DMT_2013 : Copy<br>
	 * 현재 버전에 있는 정보를 삭제하고 현재 버전에 S/C Exception Tariff History 에서 선택한 버전의 정보로 생성 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse createSCExceptionByHistoryCopy(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		SCExceptionParmVO		sCExceptionParmVO	= event.getSCExceptionParmVO();

		try {
			sCExceptionParmVO.setCreUsrId(account.getUsr_id());
			sCExceptionParmVO.setCreOfcCd(account.getOfc_cd());
			sCExceptionParmVO.setUpdUsrId(account.getUsr_id());
			sCExceptionParmVO.setUpdOfcCd(account.getOfc_cd());
			
			begin();
			command.createSCExceptionByHistoryCopy(sCExceptionParmVO);
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
	 * EES_DMT_2003 : Retrieve<br>
	 * Proposal No 의 해당 RFA No. 와 Customer 정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRFANoCustomerByProposalNo(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 				rFAProgressVO 		= null;
		if (e instanceof EesDmt2003Event) {
			rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
		} 
		else if (e instanceof EesDmt2005Event) {
			rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
		}
		
		try{
		
			List<RFAExceptionCustomerVO> list 				= command.searchRFANoCustomerByProposalNo(rFAProgressVO);
	
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("RFA_NO", list.get(0).getRfaNo());
				eventResponse.setETCData("CUST_SEQ", list.get(0).getCustSeq());
				eventResponse.setETCData("CUST_CD", list.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", list.get(0).getCustNm());
			}
			else {
				eventResponse.setETCData("RFA_NO", "");
				eventResponse.setETCData("CUST_SEQ", "");
				eventResponse.setETCData("CUST_CD", "");
				eventResponse.setETCData("CUST_NM", "");			
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2005 : Retrieve<br>
	 * Approval No 에 해당되는 Version 정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVERByApprovalNo(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2005Event 			event 				= (EesDmt2005Event)e;
		
		try{
			List<RFAProgressVO> 		list 				= command.searchVERByApprovalNo(event.getRFAProgressVO());
	
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("VER", list.get(0).getRfaExptVerSeq());
			}
			else {
				eventResponse.setETCData("VER", "");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2005 : Retrieve<br>
	 * Approval No 에 해당되는 Version 정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApprovalOfcByDAR(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2005Event 			event 				= (EesDmt2005Event)e;
		
		try{
			List<RFAProgressVO> 		list 				= command.searchApprovalOfcByDAR(event.getRFAProgressVO());
	
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("APVLOFC", list.get(0).getAproOfcCd());
			}
			else {
				eventResponse.setETCData("APVLOFC", "");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2006 : Retrieve<br>
	 * S/C 및 DAR의 Request & Approval 정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBeforeAfterStatusList(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2006Event 			event 				= (EesDmt2006Event)e;
		BeforeAfterStatusInputVO 	inputVO 			= event.getBeforeAfterStatusInputVO();
		
		try{
			//Temp Saved. 상태의 Before Booking 정보는 조회대상에서 배제시킨다.
			inputVO.setIsTemp("N");
			List<BeforeAfterStatusVO> 	list 				= command.searchBeforeAfterStatusList(inputVO);
	
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Proposal No 의 해당 DAR No. 데이터를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchBeforeExceptionList(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 		= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 			rFAProgressVO 	= null;
		
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
				//Temp Saved 상태의 데이터도 조회대상에서 포함된다.
				rFAProgressVO.setIsTemp("Y");
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
				//Temp Saved 상태의 데이터는 조회대상에서 배제한다.
				rFAProgressVO.setIsTemp("N");
			}
			
			//조회를 수행한다.
			//Before Booking Request 항목을 조회한다.
			List<BeforeExceptionVO> beforeExceptionVOs	= command.searchBeforeExceptionList(rFAProgressVO);
			List<RFAProgressVO> 	commentHistVOs		= null;
			
			//Before Booking Request 항목이 있다면 그 이력을 조회한다.
			if (beforeExceptionVOs != null && beforeExceptionVOs.size() > 0) {
				commentHistVOs	= command.searchCommentHistory(rFAProgressVO);
			}
			
			//조회된 결과를 적절하게 변환하여 준다.
			if (e instanceof EesDmt2003Event) {
				//Continent 에 해당되는 Country 목록을 가진다.
				Map<String, Object> mapCountryCodes = new HashMap<String, Object>();
				Map<String, Object> mapCountryNames = new HashMap<String, Object>();
		
				//Country 에 해당되는 Region 목록을 가진다.
				Map<String, Object> mapRegionCodes 	= new HashMap<String, Object>();
				Map<String, Object> mapRegionNames 	= new HashMap<String, Object>();
				
				String 				cntCd 			= null;
				String 				contiCd 		= null;
				
				//RFA Exception Terms Entry
				if (beforeExceptionVOs != null && beforeExceptionVOs.size() > 0) {
		
					for (int i = 0 ; i < beforeExceptionVOs.size() ; i++) {
		
						//Coverage
						contiCd = beforeExceptionVOs.get(i).getCvrgContiCd() != null ? beforeExceptionVOs.get(i).getCvrgContiCd().trim() : "";
						if (contiCd.length() > 0) {
							if (!mapCountryCodes.containsKey(contiCd)) {
								CommonCodeVO commonCodeVO = getAllCountry(contiCd);
								mapCountryCodes.put(contiCd, commonCodeVO.getIntgCdId());
								mapCountryNames.put(contiCd, commonCodeVO.getIntgCdValDpDesc());
							}
							beforeExceptionVOs.get(i).setCvrgCntAllCd((String)mapCountryCodes.get(contiCd));
							beforeExceptionVOs.get(i).setCvrgCntAllNm((String)mapCountryNames.get(contiCd));				
						} else {
							beforeExceptionVOs.get(i).setCvrgCntAllCd("");
							beforeExceptionVOs.get(i).setCvrgCntAllNm("");
						}
							
						cntCd = beforeExceptionVOs.get(i).getCvrgCntCd() != null ? beforeExceptionVOs.get(i).getCvrgCntCd().trim() : "";
						if (cntCd.length() > 0) {
							if (!mapRegionCodes.containsKey(cntCd)) {
								CommonCodeVO reVO = getAllRegion(cntCd);
								mapRegionCodes.put(cntCd, reVO.getIntgCdId());
								mapRegionNames.put(cntCd, reVO.getIntgCdValDpDesc());
							}
							beforeExceptionVOs.get(i).setCvrgRgnAllCd((String)mapRegionCodes.get(cntCd));
							beforeExceptionVOs.get(i).setCvrgRgnAllNm((String)mapRegionNames.get(cntCd));				
						} else {
							beforeExceptionVOs.get(i).setCvrgRgnAllCd("");
							beforeExceptionVOs.get(i).setCvrgRgnAllNm("");
						}
						
						//Origin(I) or Dest.(O)
						contiCd = beforeExceptionVOs.get(i).getOrgDestContiCd() != null ? beforeExceptionVOs.get(i).getOrgDestContiCd().trim() : "";
						if (contiCd.length() > 0) {
							if (!mapCountryCodes.containsKey(contiCd)) {
								CommonCodeVO commonCodeVO = getAllCountry(contiCd);
								mapCountryCodes.put(contiCd, commonCodeVO.getIntgCdId());
								mapCountryNames.put(contiCd, commonCodeVO.getIntgCdValDpDesc());
							}
							beforeExceptionVOs.get(i).setOrgDestCntAllCd((String)mapCountryCodes.get(contiCd));
							beforeExceptionVOs.get(i).setOrgDestCntAllNm((String)mapCountryNames.get(contiCd));				
						} else {
							beforeExceptionVOs.get(i).setOrgDestCntAllCd("");
							beforeExceptionVOs.get(i).setOrgDestCntAllNm("");
						}
						
						cntCd = beforeExceptionVOs.get(i).getOrgDestCntCd() != null ? beforeExceptionVOs.get(i).getOrgDestCntCd().trim() : "";
						if (cntCd.length() > 0) {
							if (!mapRegionCodes.containsKey(cntCd)) {
								CommonCodeVO reVO = getAllRegion(cntCd);
								mapRegionCodes.put(cntCd, reVO.getIntgCdId());
								mapRegionNames.put(cntCd, reVO.getIntgCdValDpDesc());
							}
							beforeExceptionVOs.get(i).setOrgDestRgnAllCd((String)mapRegionCodes.get(cntCd));
							beforeExceptionVOs.get(i).setOrgDestRgnAllNm((String)mapRegionNames.get(cntCd));				
						} else {
							beforeExceptionVOs.get(i).setOrgDestRgnAllCd("");
							beforeExceptionVOs.get(i).setOrgDestRgnAllNm("");
						}
						
						//BKG DEL(I) or POR(O)
						contiCd = beforeExceptionVOs.get(i).getFnlDestContiCd() != null ? beforeExceptionVOs.get(i).getFnlDestContiCd().trim() : "";
						if (contiCd.length() > 0) {
							if (!mapCountryCodes.containsKey(contiCd)) {
								CommonCodeVO commonCodeVO = getAllCountry(contiCd);
								mapCountryCodes.put(contiCd, commonCodeVO.getIntgCdId());
								mapCountryNames.put(contiCd, commonCodeVO.getIntgCdValDpDesc());
							}
							beforeExceptionVOs.get(i).setFnlDestCntAllCd((String)mapCountryCodes.get(contiCd));
							beforeExceptionVOs.get(i).setFnlDestCntAllNm((String)mapCountryNames.get(contiCd));				
						} else {
							beforeExceptionVOs.get(i).setFnlDestCntAllCd("");
							beforeExceptionVOs.get(i).setFnlDestCntAllNm("");
						}
						
						cntCd = beforeExceptionVOs.get(i).getFnlDestCntCd() != null ? beforeExceptionVOs.get(i).getFnlDestCntCd().trim() : "";
						if (cntCd.length() > 0) {
							if (!mapRegionCodes.containsKey(cntCd)) {
								CommonCodeVO reVO = getAllRegion(cntCd);
								mapRegionCodes.put(cntCd, reVO.getIntgCdId());
								mapRegionNames.put(cntCd, reVO.getIntgCdValDpDesc());
							}
							beforeExceptionVOs.get(i).setFnlDestRgnAllCd((String)mapRegionCodes.get(cntCd));
							beforeExceptionVOs.get(i).setFnlDestRgnAllNm((String)mapRegionNames.get(cntCd));				
						} else {
							beforeExceptionVOs.get(i).setFnlDestRgnAllCd("");
							beforeExceptionVOs.get(i).setFnlDestRgnAllNm("");
						}
					}
				}
			}
			else if (e instanceof EesDmt2005Event) {
				String cntCd = null;
	
				//RFA Exception Terms Entry
				if (beforeExceptionVOs != null && beforeExceptionVOs.size() > 0) {
		
					for (int i = 0 ; i < beforeExceptionVOs.size() ; i++) {
						//Coverage
						cntCd = beforeExceptionVOs.get(i).getCvrgCntCd() != null ? beforeExceptionVOs.get(i).getCvrgCntCd().trim() : "";
						if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
							beforeExceptionVOs.get(i).setCvrgRgnCd(beforeExceptionVOs.get(i).getCvrgSteCd());
						}					
						
						//Origin(I) or Dest.(O)
						cntCd = beforeExceptionVOs.get(i).getOrgDestCntCd() != null ? beforeExceptionVOs.get(i).getOrgDestCntCd().trim() : "";
						if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
							beforeExceptionVOs.get(i).setOrgDestRgnCd(beforeExceptionVOs.get(i).getOrgDestSteCd());
						}					
						
						//BKG DEL(I) or POR(O)
						cntCd = beforeExceptionVOs.get(i).getFnlDestCntCd() != null ? beforeExceptionVOs.get(i).getFnlDestCntCd().trim() : "";
						if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
							beforeExceptionVOs.get(i).setFnlDestRgnCd(beforeExceptionVOs.get(i).getFnlDestSteCd());
						}						
					}
				}
			}
			
			//조회된 결과를 반환한다.
			eventResponse.setRsVoList(beforeExceptionVOs);
			eventResponse.setRsVoList(commentHistVOs);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;			
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Proposal No 의 해당 DAR No. 데이터를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchBeforeDARList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProgressVO rFAProgressVO = null;
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			}
			RFAExceptionTariffMgtBC command = new RFAExceptionTariffMgtBCImpl();
			List<RFAProgressVO> list = command.searchBeforeDARList(rFAProgressVO);
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getAproOfcCd()).append("=").append(list.get(i).getRfaExptDarNo());
					if (i < list.size() - 1) codes.append("|");
				}
				eventResponse.setETCData("DAR", codes.toString());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;			
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * DAR No 의 해당 VER No. 데이터를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchBeforeVERList(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 				rFAProgressVO 		= null;
		
		try {
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
				//Temp 상태의 Before Booking 데이터도 조회대상에 포함시킨다.
				rFAProgressVO.setIsTemp("Y");
				
				// [ Basic RFA ] 1. Master Ver. 이 Basic Ver. 보다 상위인지 조회한다. ===========================================
				String bzcPropNo = rFAProgressVO.getPropNo();
				String mstPropNo = command.searchPropNoOfMstRfa(bzcPropNo);
				
				boolean isMstRfaVerUppr = command.isUpprMstRfaVerThanBzcRfaVer(mstPropNo, bzcPropNo);
				eventResponse.setETCData("MST_RFA_VER_UPPR_YN", isMstRfaVerUppr ? "Y" : "N");
				//===============================================================================================================					
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
				//Temp 상태의 Before Booking 데이터는 조회대상에 배제시킨다.
				rFAProgressVO.setIsTemp("N");
			}
			List<RFAProgressVO> 		list 				= command.searchBeforeVERList(rFAProgressVO);
			StringBuffer 				sbVerCodes 			= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					sbVerCodes.append(list.get(i).getDmdtExptRqstStsCd()).append("=").append(list.get(i).getRfaExptVerSeq());
					if (i < list.size() - 1) sbVerCodes.append("|");
				}
				eventResponse.setETCData("VER", sbVerCodes.toString());
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;			
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Before Booking 의 Actual Customer 정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerListByRFA(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event 			event 				= (EesDmt2003Event)e;
		
		try{
			List<RFAExceptionCustomerVO> list 				= command.searchCustomerListByRFA(event.getRFAProgressVO());
			StringBuffer 				sbCustCodes 		= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				sbCustCodes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < list.size() ; i++) {
					sbCustCodes.append(list.get(i).getCustCd()).append("=").append(list.get(i).getCustNm());
					if (i < list.size() - 1) sbCustCodes.append("|");
				}
			}
			eventResponse.setETCData("CUST", sbCustCodes.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Before Booking 의 Affiliate 정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAffiliateListByRFA(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();	
		RFAProgressVO 				rFAProgressVO 		= null;
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			}
			List<RFAExceptionCustomerVO> list 				= command.searchAffiliateListByRFA(rFAProgressVO);
			StringBuffer 				sbAffilCodes 		= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				sbAffilCodes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < list.size() ; i++) {
					sbAffilCodes.append(list.get(i).getCustCd()).append("=").append(list.get(i).getCustNm());
					if (i < list.size() - 1) sbAffilCodes.append("|");
				}
			}
			eventResponse.setETCData("AFFL", sbAffilCodes.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * DAR No. 나 Approval No. 로 Proposal No. 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPropNoByDARApprovalNo(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2005Event 			event 				= (EesDmt2005Event)e;
		
		try{
			RFAProgressVO 				rFAProgressVO 		= event.getRFAProgressVO();
			
			//Temp 상태의 Before Booking 정보는 조회하지 않는다.(2009-10-21(수))
			rFAProgressVO.setIsTemp("N");
			List<RFAProgressVO> 		list 				= command.searchPropNoByDARApprovalNo(rFAProgressVO);
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("PROP_NO", list.get(0).getPropNo());
				eventResponse.setETCData("DAR_NO", list.get(0).getRfaExptDarNo());	
				eventResponse.setETCData("APRO_NO", list.get(0).getRfaExptAproNo());	
			} 
			else {
				eventResponse.setETCData("PROP_NO", "");			
				eventResponse.setETCData("DAR_NO", "");	
				eventResponse.setETCData("APRO_NO", "");	
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Request<br>
	 * DAR No. 를 생성,조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBeforeNewDAR(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();
		try{
			String 	darNo = command.searchNewDAR("B", account.getUsr_id(), account.getOfc_cd());
			
			eventResponse.setETCData("DAR", darNo);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Open<br>
	 * Comment History 정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommentHistory(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();		
		RFAProgressVO 				rFAProgressVO 	= null;
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			}
			List<RFAProgressVO> 		list 			= command.searchCommentHistory(rFAProgressVO);
	
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Request<br>
	 * Before Booking Request 의 상태를 Request 로 수정 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse requestBeforeException(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();;
		EesDmt2003Event 			event			= (EesDmt2003Event)e;
		RFAProgressVO 				rFAProgressVO 	= event.getRFAProgressVO();
		
		rFAProgressVO.setCreUsrId(account.getUsr_id());
		rFAProgressVO.setCreOfcCd(account.getOfc_cd());
		rFAProgressVO.setUpdUsrId(account.getUsr_id());
		rFAProgressVO.setUpdOfcCd(account.getOfc_cd());
		
		try {
			begin();
			
			// 1. Request 실행
			command.requestBeforeException(rFAProgressVO);
			
			// 2. Basic RFA 인지 여부를 조회합니다.
			boolean isBzcRfa = command.isBzcRfa(rFAProgressVO.getPropNo());
			
			// 3. [ 2017.06.07 : Basic RFA 인 경우, 요청시 승인까지 일괄적으로 처리한다. ]===========
			if (isBzcRfa) {
				// 승인자 정보
				rFAProgressVO.setAproUsrId(account.getUsr_id());
				// 승인상태로 갱신
				rFAProgressVO.setDmdtExptRqstStsCd("A");	
				// 승인상태가 자동갱신 이므로 Comment 를 자동으로 등록해준다.
				rFAProgressVO.setProgRmk("It is automatically approved because it is the Basic RFA");
				command.approvalByBzcRfa(rFAProgressVO);
			}
			//=====================================================================================
			
			commit();
			
			// 4. [ 2017.06.07 : Basic RFA 인 경우, 요청시 승인처리 후 메일을 전송한다. ]===========
			if (isBzcRfa) {
				
				// DAR Request & Approval Status ( EES_DMT_2006_1 ) 화면에서 팝업으로 띄울 경우 Approval 한 DATE 정보를 보여주기 위해서 조회함. 
				if ("Y".equals(rFAProgressVO.getPopupFlag()))
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(rFAProgressVO));
				
				this.sendEmail(rFAProgressVO);
			}
			//=====================================================================================			
		}
		catch(EventException ex) {
			rollback();
			throw ex;
		}
		catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Cancel<br>
	 * Before Booking Request 의 상태를 Cancel 로 수정 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelBeforeException(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();;
		EesDmt2003Event 			event			= (EesDmt2003Event)e;
		RFAProgressVO 				rFAProgressVO 	= event.getRFAProgressVO();
		
		rFAProgressVO.setCreUsrId(account.getUsr_id());
		rFAProgressVO.setCreOfcCd(account.getOfc_cd());
		rFAProgressVO.setUpdUsrId(account.getUsr_id());
		rFAProgressVO.setUpdOfcCd(account.getOfc_cd());
		
		try {
			begin();
			command.cancelBeforeException(rFAProgressVO);
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
	 * EES_DMT_2003 : Approval<br>
	 * Before Booking Request 의 상태를 Approval 로 수정 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse approvalBeforeException(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 				rFAProgressVO 	= null;
		
		if (e instanceof EesDmt2003Event) {
			rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
		} 
		else if (e instanceof EesDmt2005Event) {
			rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
		}
	
		if ( rFAProgressVO != null ){
			//Set Parameters 
			rFAProgressVO.setCreUsrId(		account.getUsr_id()		);
			rFAProgressVO.setCreOfcCd(		account.getOfc_cd()		);
			rFAProgressVO.setUpdUsrId(		account.getUsr_id()		);
			rFAProgressVO.setUpdOfcCd(		account.getOfc_cd()		);
			rFAProgressVO.setAproUsrId(		account.getUsr_id()		);
			rFAProgressVO.setRhqOfcCd(		account.getRhq_ofc_cd()	);
			
			try {
				begin();
	
				//1.승인상태의 이전 버전이 존재한다면 승인번호는 이전버전의 승인번호를 유지한다.
				String approvalNo = command.searchPrevApprovalNo(rFAProgressVO);
				//2.그렇지 않다면, 새로운 번호를 채번한다.
				if (approvalNo == null || approvalNo.length() == 0) {
					approvalNo = command.searchNewApprovalNo(rFAProgressVO.getCreUsrId(), rFAProgressVO.getRhqOfcCd(), "B");
				}
				rFAProgressVO.setRfaExptAproNo(approvalNo);
				
				command.approvalBeforeException(rFAProgressVO);
				commit();
				
				//2006 번 화면에서 팝업으로 띄울 경우 Approval 한 DATE 정보를 보여주기 위해서 조회함. 
				if ("Y".equals(rFAProgressVO.getPopupFlag()))
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(rFAProgressVO));
				
				//APPROVE 처리 후 메일송부 ######################################################################
				sendEmail(rFAProgressVO);
				//############################################################################################
			}catch(EventException ex){
				rollback();
				throw ex;
			}catch(Exception ex){
				rollback();
				throw new EventException(ex.getMessage(), ex);
			}	
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Counter Offer<br>
	 * Before Booking Request 의 상태를 Counter Offer 로 수정 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse counterofferBeforeException(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 				rFAProgressVO 	= null;
		
		if (e instanceof EesDmt2003Event) {
			rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
		} 
		else if (e instanceof EesDmt2005Event) {
			rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
		}
		
		if ( rFAProgressVO != null ){
			//Set Parameters 
			rFAProgressVO.setCreUsrId(		account.getUsr_id()		);
			rFAProgressVO.setCreOfcCd(		account.getOfc_cd()		);
			rFAProgressVO.setUpdUsrId(		account.getUsr_id()		);
			rFAProgressVO.setUpdOfcCd(		account.getOfc_cd()		);
			
			try {
				begin();
				command.counterofferBeforeException(rFAProgressVO);
				commit();
				
				//2006 번 화면에서 팝업으로 띄울 경우 Counter Offer 한 DATE 정보를 보여주기 위해서 조회함. 
				if ("Y".equals(rFAProgressVO.getPopupFlag()))
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(rFAProgressVO));
				
				//COUNTER OFFER 처리 후 메일송부 ################################################################
				sendEmail(rFAProgressVO);
				//############################################################################################
			}catch(EventException ex){
				rollback();
				throw ex;
			}catch(Exception ex){
				rollback();
				throw new EventException(ex.getMessage(), ex);
			}
		}
		return eventResponse;
	}	
	
	/**
	 * EES_DMT_2003 : Reject<br>
	 * Before Booking Request 의 상태를 Reject 로 수정 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectBeforeException(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 				rFAProgressVO 	= new RFAProgressVO();
		
		if (e instanceof EesDmt2003Event) {
			rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
		} 
		else if (e instanceof EesDmt2005Event) {
			rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
		}
		
		//Set Parameters 
		rFAProgressVO.setCreUsrId(		account.getUsr_id()		);
		rFAProgressVO.setCreOfcCd(		account.getOfc_cd()		);
		rFAProgressVO.setUpdUsrId(		account.getUsr_id()		);
		rFAProgressVO.setUpdOfcCd(		account.getOfc_cd()		);
				
		try {
			begin();
			command.rejectBeforeException(rFAProgressVO);
			commit();
			
			//2006 번 화면에서 팝업으로 띄울 경우 Reject 한 DATE 정보를 보여주기 위해서 조회함.
			if ("Y".equals(rFAProgressVO.getPopupFlag()))
				eventResponse.setETCData("upd_dt", command.searchUpdateDate(rFAProgressVO));
			
			//REJECT 처리 후 메일송부 ######################################################################
			sendEmail(rFAProgressVO);
			//############################################################################################			
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
	 * EES_DMT_2003 : Retrieve<br>
	 * DAR No. 와 VER No. 에 해당되는 Adjustment Request 의 Approval No. 데이터를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchBeforeAPROList(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();		
		RFAProgressVO 				rFAProgressVO 	= null;
		
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			}
			List<RFAProgressVO> 		list 			= command.searchBeforeAPROList(rFAProgressVO);
			StringBuffer 				sbAproCodes 	= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					sbAproCodes.append(list.get(i).getRfaExptAproNo()).append("=").append(list.get(i).getRfaExptAproNo());
					if (i < list.size() - 1) sbAproCodes.append("|");
				}
				eventResponse.setETCData("APRO", sbAproCodes.toString());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;			
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * roposal No. 에 해당되는 Customer를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchCustomerByProp(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 				rFAProgressVO 	= null;
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			}
			List<RFAProgressVO> 		list 			= command.searchCustomerByProp(rFAProgressVO);
	
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("CUST_CD", list.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", list.get(0).getCustNm());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;			
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Proposal No. 에 해당되는 RFA No.를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchRFAByProp(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 				rFAProgressVO 	= null;
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			}
			List<RFAProgressVO> 		list 			= command.searchRFAByProp(rFAProgressVO);
	
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("RFA", list.get(0).getRfaNo());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;			
	}	
	
	/**
	 * EES_DMT_2003 : Request<br>
	 * RFA별 DEM/DET 특별 계약 내용을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyBeforeException(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event 			event 				= (EesDmt2003Event)e;
		RFAExceptionGRPVO 			rfaExceptionGRPVO 	= new RFAExceptionGRPVO();
		
		rfaExceptionGRPVO.setBeforeExceptionVersionVO(		event.getBeforeExceptionVersionVO()		);
		rfaExceptionGRPVO.setBeforeExceptionVOS(			event.getBeforeExceptionVOS()			);
		rfaExceptionGRPVO.setRFAExceptionCoverageVOS(		event.getRFAExceptionCoverageVOS()		);
		rfaExceptionGRPVO.setRFAExceptionRateAdjustVOS(		event.getRFAExceptionRateAdjustVOS()	);
		
		try {
			begin();
			RFAProgressVO rFAProgressVO = command.modifyBeforeException(rfaExceptionGRPVO, account);
			commit();
			
			//신규 생성된 DAR 를 항목이라면..
			if (rFAProgressVO.getRfaExptDarNo() != null) {
				//DAR 정보를 조회한다.===============================================================================
				List<RFAProgressVO>				darList			= command.searchBeforeDARList(event.getRFAProgressVO());
				StringBuffer 					sbDar	 		= new StringBuffer();
					
				if (darList != null && darList.size() > 0) {
					for (int i = 0 ; i < darList.size() ; i++) {
						sbDar.append(darList.get(i).getAproOfcCd()).append("=").append(darList.get(i).getRfaExptDarNo());
						if (i < darList.size() - 1) sbDar.append("|");
					}
				}
				eventResponse.setETCData("DAR", sbDar.toString());
				//===============================================================================================================
			}
			eventResponse.setETCData("DTL_SEQ", 	rFAProgressVO.getRfaRqstDtlSeq());
			
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
	 * EES_DMT_2007 : Retrieve<br>
	 * S/C & RFA Exception 정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCRFAExceptionList(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2007Event 			event 				= (EesDmt2007Event)e;
		try{
			List<SCRFAExceptionListVO> 	list 				= command.searchSCRFAExceptionList(event.getSCRFAExceptionParamVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * S/C & RFA Exception Inquiry - S/C 에 등록된 Tiered Free Time 을 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCTieredFreeTimeList(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2007Event 			event 				= (EesDmt2007Event)e;
		try{
			List<SCExceptionFreeTimeVO> list 				= command.searchTieredFreeTimeBySC(event.getSCExceptionParmVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * S/C & RFA Exception Inquiry - S/C 에 등록된 Rate Adjustment 를 조회 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCRateAdjustmentList(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 			command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2007Event 				event 				= (EesDmt2007Event)e;
		try{
			List<SCExceptionRateAdjustVO> 	list 				= command.searchRateAdjustmentBySC(event.getSCExceptionParmVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * S/C & RFA Exception Inquiry - S/C 에 등록된 Actual Customer 를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCActualCustomerList(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 			command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2007Event 				event 				= (EesDmt2007Event)e;
		try{
			List<SCExceptionCustomerVO> 	list 				= command.searchCustomerBySC(event.getSCExceptionParmVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * S/C & RFA Exception Inquiry - S/C 에 등록된 Commodity 를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCCommodityList(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 			command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2007Event 				event 				= (EesDmt2007Event)e;
		try{
			List<SCExceptionCommodityVO> 	list 				= command.searchCommodityBySC(event.getSCExceptionParmVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * S/C & RFA Exception Inquiry - RFA 에 등록된 Multi Origin or Destination 를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRFAMultiCoverageList(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 		command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2007Event 				event 				= (EesDmt2007Event)e;
		try{
			List<RFAExceptionCoverageVO> 	list 				= command.searchMultiCoverageByRFA(event.getRFAProgressVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * S/C & RFA Exception Inquiry - RFA 에 등록된 Rate Adjustment 를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRFARateAdjustmentList(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 		command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2007Event 				event 				= (EesDmt2007Event)e;
		try{
			List<RFAExceptionRateAdjustVO> 	list 				= command.searchRateAdjustmentByRFA(event.getRFAProgressVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2010 : Retrieve<br>
	 * Clock Stop no의 대한 해당 데이터를 조회한다.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTimeClockStop(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt2010Event event 				= (EesDmt2010Event)e;
		TimeClockStopMgtBC command 			= new TimeClockStopMgtBCImpl();
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		Map<String, String> etcData 		= new HashMap<String, String>();
		try{
			List<DmtTimeClockStopVO> list = command.searchTimeClockStop(event.getTimeClockStopParmVO());
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size(); i++) {
					etcData.put("clk_stop_no", list.get(i).getClkStopNo());
					etcData.put("cxl_flg", list.get(i).getCxlFlg());                                                
					etcData.put("dmdt_trf_cd", list.get(i).getDmdtTrfCd());  
					etcData.put("dmdt_trf_nm", list.get(i).getDmdtTrfNm());
					etcData.put("clk_stop_ofc_cd", list.get(i).getClkStopOfcCd());  
					etcData.put("clk_stop_ofc_nm", list.get(i).getClkStopOfcNm());                             
					etcData.put("clk_stop_fm_dt", list.get(i).getClkStopFmDt());                                          
					etcData.put("clk_stop_to_dt", list.get(i).getClkStopToDt());                                          
					etcData.put("stop_days", list.get(i).getStopDays());                              
					etcData.put("clk_stop_rmk", list.get(i).getClkStopRmk());                                   
					etcData.put("cre_usr_id", list.get(i).getCreDt());
					etcData.put("cre_dt", list.get(i).getCreOfcCd());
					etcData.put("cre_ofc_cd", list.get(i).getCreUsrId());
					etcData.put("upd_usr_id", list.get(i).getUpdUsrId());
					etcData.put("upd_dt", list.get(i).getUpdDt());
					etcData.put("upd_ofc_cd", list.get(i).getUpdOfcCd());
					etcData.put("clk_stop_yd_cd", list.get(i).getClkStopYdCd());
					etcData.put("clk_stop_yd_nm", list.get(i).getClkStopYdCd());	//user 요청 사항
					etcData.put("all_yd_flg", list.get(i).getAllYdFlg());
					etcData.put("dmdt_bkg_term_ctnt", list.get(i).getDmdtBkgTermCtnt()); // 2012.03.14 추가
				}
			}
			
			etcData.put("auth_yn", command.searchAuthExist(etcData.get("clk_stop_ofc_cd")));
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2010 : Retrieve<br>
	 * Clock Stop no의 대한 List 데이터를 조회한다.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTimeClockStopList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt2010Event event 				= (EesDmt2010Event)e;
		TimeClockStopMgtBC command 			= new TimeClockStopMgtBCImpl();
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		try{
			List<DmtTimeClockStopVO> list = command.searchTimeClockStopList(event.getTimeClockStopParmVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2014 : Open<br>
	 * Dual Type Exception 에 기등록된 Customer 정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDualTypeCustomerList(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		DualTypeExceptionMgtBC 		command 			= new DualTypeExceptionMgtBCImpl();
		
		try{
			List<DualTypeCustomerVO> 	list 				= command.searchDualTypeCustomerList();
			StringBuffer 				sbCustCodes 		= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				sbCustCodes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < list.size(); i++) {
					sbCustCodes.append(list.get(i).getCustCd()).append("=").append(list.get(i).getCustNm());
					if (i < list.size() - 1) sbCustCodes.append("|");
				}
			}
			eventResponse.setETCData("CUSTCODE", sbCustCodes.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_DMT_2014 : Retrieve<br>
	 * 선택한 Customer 가 S/C, Before Customer 인지를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDualTypeCustomer(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	scCommand 			= new SCExceptionTariffMgtBCImpl();
		RFAExceptionTariffMgtBC rfaCommand 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2014Event 		event 				= (EesDmt2014Event)e;
		DualTypeCustomerVO 		dualTypeCustomerVO 	= event.getDualTypeCustomerVO();
		try{
			String 					cust_cnt_cd 		= dualTypeCustomerVO.getCustCntCd();
			String 					cust_seq 			= dualTypeCustomerVO.getCustSeq();
			
			eventResponse.setETCData("SC_CUST", scCommand.isSCCustomer(cust_cnt_cd, cust_seq) ? "Y" : "N");
			eventResponse.setETCData("BF_CUST", rfaCommand.isBeforeBKGCustomer(cust_cnt_cd, cust_seq) ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_DMT_2014 : Save<br>
	 * Dual Type Exception Coverage의 Dual Type 여부를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDualCoverage(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		DualTypeExceptionMgtBC 	command	 			= new DualTypeExceptionMgtBCImpl();
		EesDmt2014Event 		event 				= (EesDmt2014Event)e;
		try{
			eventResponse.setETCData("IS_DUALCVRG", command.checkDualCoverage(event.getCoverageVO()) ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2014 : Row Delete<br>
	 * 선택한 Dual Type Customer 가 삭제가능한지를 체크하는 함수<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDelDualTypeCustomer(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		DualTypeExceptionMgtBC 	command	 			= new DualTypeExceptionMgtBCImpl();
		EesDmt2014Event 		event 				= (EesDmt2014Event)e;
		DualTypeCustomerVO 		dualTypeCustomerVO 	= event.getDualTypeCustomerVO();
		try{
			String 					result 				= command.checkDelDualTypeCustomer(dualTypeCustomerVO);
			
			if (result != null && result.length() > 0) {
				if ("S".equals(dualTypeCustomerVO.getDmdtCtrtExptTpCd())) {
					eventResponse.setETCData("SC_NO", result);
					eventResponse.setETCData("DAR_NO", "");
				}
				else if ("B".equals(dualTypeCustomerVO.getDmdtCtrtExptTpCd())) {
					eventResponse.setETCData("SC_NO", "");
					eventResponse.setETCData("DAR_NO", result);
				}
				eventResponse.setETCData("DEL_CUST", "N");
			}
			else {
				eventResponse.setETCData("DEL_CUST", "Y");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2014 : Save<br>
	 * 입력한 Expire Date 가 유효한지 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDualTypeExpireDate(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		DualTypeExceptionMgtBC 	command	 			= new DualTypeExceptionMgtBCImpl();
		EesDmt2014Event 		event 				= (EesDmt2014Event)e;
		DualTypeCustomerVO 		dualTypeCustomerVO 	= event.getDualTypeCustomerVO();
		try{
			String 					result 				= command.checkDualTypeExpireDate(dualTypeCustomerVO);
			
			if (result != null && result.length() > 0) {
				if ("S".equals(dualTypeCustomerVO.getDmdtCtrtExptTpCd())) {
					eventResponse.setETCData("SC_NO", result);
					eventResponse.setETCData("DAR_NO", "");
				}
				else if ("B".equals(dualTypeCustomerVO.getDmdtCtrtExptTpCd())) {
					eventResponse.setETCData("SC_NO", "");
					eventResponse.setETCData("DAR_NO", result);
				}
				eventResponse.setETCData("RESULT", "N");
			}
			else {
				eventResponse.setETCData("RESULT", "Y");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2014 : Save<br>
	 * 등록할 Dual Type Exception 이 기등록된 것인지 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDuplicateDualTypeException(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		DualTypeExceptionMgtBC 	command	 			= new DualTypeExceptionMgtBCImpl();
		EesDmt2014Event 		event 				= (EesDmt2014Event)e;
		DualTypeCustomerVO 		dualTypeCustomerVO 	= event.getDualTypeCustomerVO();
		
		try{
			DualTypeCustomerVO 		customerVO 			= command.checkDuplicateDualTypeException(dualTypeCustomerVO);
			
			if (customerVO != null) {
				eventResponse.setETCData("RESULT", "Y");
				eventResponse.setETCData("DUL_EXPT_EFF_DT", customerVO.getDulExptEffDt());
				eventResponse.setETCData("DUL_EXPT_EXP_DT", customerVO.getDulExptExpDt());
			}
			else {
				eventResponse.setETCData("RESULT", "N");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2014 : Retrieve<br>
	 * Dual Type Exception을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDualTypeCustomer(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 			= new GeneralEventResponse();
		DualTypeExceptionMgtBC 	command 				= new DualTypeExceptionMgtBCImpl();
		DualTypeCustomerVO 		dualTypeCustomerVO 		= new DualTypeCustomerVO();
		
		if (e instanceof EesDmt2014Event) {
			EesDmt2014Event event = (EesDmt2014Event)e;
			dualTypeCustomerVO = event.getDualTypeCustomerVO();
		} 
		else if (e instanceof EesDmt2015Event) {
			EesDmt2015Event event = (EesDmt2015Event)e;
			dualTypeCustomerVO = event.getDualTypeCustomerVO();
		}
		try{
			List<DualTypeCustomerVO> dualTypeCustomerVOList = command.searchDualTypeCustomer(dualTypeCustomerVO);
			
			if (dualTypeCustomerVOList != null && dualTypeCustomerVOList.size() > 0) {
				
				//Country 에 해당되는 Region 목록을 가진다.
				Map<String, Object> mapRegionCodes = new HashMap<String, Object>();
				Map<String, Object> mapRegionNames = new HashMap<String, Object>();
	
				String cntCd = null;
				String typeCd = null;
				
				//Type(SC, Before) 구분에 따라 CNTR/Cargo Type 을 각각 조회해서 콤보기타선택값으로 입력해준다.
				AllCNTRCargoVO allCNTRCargoVO = getAllContainerCargoType(
															  dualTypeCustomerVO.getIntgCdId()
															, dualTypeCustomerVO.getCode1()
															, dualTypeCustomerVO.getCode2());
				//Map<String,String> tmpCNTRCargoMap = null;
				SCCNTRCargoVO sCCNTRCargoVO 	= new SCCNTRCargoVO();
				RFACNTRCargoVO rFACNTRCargoVO 	= new RFACNTRCargoVO();
				
				for (int i = 0 ; i < dualTypeCustomerVOList.size() ; i++) {
					
					cntCd = dualTypeCustomerVOList.get(i).getCvrgCntCd() != null 
									? dualTypeCustomerVOList.get(i).getCvrgCntCd().trim() : "";
					typeCd = dualTypeCustomerVOList.get(i).getDmdtCtrtExptTpCd() != null 
									? dualTypeCustomerVOList.get(i).getDmdtCtrtExptTpCd().trim() : "";
					
									
					if(typeCd.equals("S")){
						sCCNTRCargoVO 	= allCNTRCargoVO.getSCCNTRCargoVO();
						dualTypeCustomerVOList.get(i).setDmdtCntrCgoTpAllCd(sCCNTRCargoVO.getSccntrCargoCode());
						dualTypeCustomerVOList.get(i).setDmdtCntrCgoTpAllNm(sCCNTRCargoVO.getSccntrCargoDesc());
					}else if(typeCd.equals("B")){
						rFACNTRCargoVO 	= allCNTRCargoVO.getRFACNTRCargoVO();
						dualTypeCustomerVOList.get(i).setDmdtCntrCgoTpAllCd(rFACNTRCargoVO.getRfacntrCargoCode());
						dualTypeCustomerVOList.get(i).setDmdtCntrCgoTpAllNm(rFACNTRCargoVO.getRfacntrCargoDesc());
					}
					
					//Region 의 콤보데이터 설정
					if (cntCd.length() > 0) {
						if (!mapRegionCodes.containsKey(cntCd)) {
							CommonCodeVO reVO = getAllRegion(cntCd);
							mapRegionCodes.put(cntCd, reVO.getIntgCdId());
							mapRegionNames.put(cntCd, reVO.getIntgCdValDpDesc());
						}
						dualTypeCustomerVOList.get(i).setCvrgRgnSteAllCd((String)mapRegionCodes.get(cntCd));
						dualTypeCustomerVOList.get(i).setCvrgRgnSteAllNm((String)mapRegionNames.get(cntCd));
					} 
					else {
						dualTypeCustomerVOList.get(i).setCvrgRgnSteAllCd("");
						dualTypeCustomerVOList.get(i).setCvrgRgnSteAllNm("");
					}
				}
			}
	
			eventResponse.setRsVoList(dualTypeCustomerVOList);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2014 : Save<br>
	 * Dual Type Exception을 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDualTypeCustomer(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		DualTypeExceptionMgtBC 	command 		= new DualTypeExceptionMgtBCImpl();
		EesDmt2014Event 		event 			= (EesDmt2014Event)e;

		try{
			begin();
			command.manageDualTypeCustomer(event.getDualTypeCustomerVOS(),account);
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
	 * EES_DMT_2015 : Retrieve<br>
	 * 기등록된 Dual Type Exception 를 조회하는 함수<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCorDARListByCustomer(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		DualTypeExceptionMgtBC 	command 		= new DualTypeExceptionMgtBCImpl();
		EesDmt2015Event 		event 			= (EesDmt2015Event)e;
		SCOrDARListInputVO 		inputVO 		= event.getSCOrDARListInputVO();
		
		try{
			List<SCOrDARListVO> 	sCOrDARListVO 	= command.searchSCorDARListByCustomer(inputVO);
			
			if (sCOrDARListVO != null && sCOrDARListVO.size() > 0) {		
			
				//Type(SC, Before) 구분에 따라 CNTR/Cargo Type 을 각각 조회해서 콤보기타선택값으로 입력해준다.
				AllCNTRCargoVO allCNTRCargoVO = getAllContainerCargoType(
														  inputVO.getIntgCdId()
														, inputVO.getCode1()
														, inputVO.getCode2());
				
				SCCNTRCargoVO sCCNTRCargoVO 	= new SCCNTRCargoVO();
				RFACNTRCargoVO rFACNTRCargoVO 	= new RFACNTRCargoVO();
				String typeCd 					= inputVO.getDmdtCtrtExptTpCd(); 
				
				for (int i = 0 ; i < sCOrDARListVO.size() ; i++) {
					if(typeCd.equals("S")){
						sCCNTRCargoVO 	= allCNTRCargoVO.getSCCNTRCargoVO();
						sCOrDARListVO.get(i).setDmdtCntrCgoTpAllCd(sCCNTRCargoVO.getSccntrCargoCode());
						sCOrDARListVO.get(i).setDmdtCntrCgoTpAllNm(sCCNTRCargoVO.getSccntrCargoDesc());
					}else if(typeCd.equals("B")){
						rFACNTRCargoVO 	= allCNTRCargoVO.getRFACNTRCargoVO();
						sCOrDARListVO.get(i).setDmdtCntrCgoTpAllCd(rFACNTRCargoVO.getRfacntrCargoCode());
						sCOrDARListVO.get(i).setDmdtCntrCgoTpAllNm(rFACNTRCargoVO.getRfacntrCargoDesc());
					}
				}
			}
			eventResponse.setRsVoList(sCOrDARListVO);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

   /**
    * EES_DMT_2012 : Retrieve<br>
    * [VL/VD Date Update 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchVLVDByVVDList (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt2012Event event 				= (EesDmt2012Event)e;
        VLVDDateUpdateMgtBC command 		= new VLVDDateUpdateMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        try{
	        List<VslDtUpdListVO> list = command.searchVLVDByVVDList ( event.getDmtVesselDateUpdateParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    
   /**
    * EES_DMT_2012 : Save<br>
    * [VL/VD Date]을 [Update by VVD]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse manageVLVDDate (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt2012Event event = (EesDmt2012Event)e;
        VLVDDateUpdateMgtBC command = new VLVDDateUpdateMgtBCImpl();
        try{
            begin();
            String xMvmt = (String)event.getAttribute("xMvmt");
            String xPort = (String)event.getAttribute("xPort");
            String audVerSeq = command.manageVLVDDate( xMvmt , xPort , event.getDmtVslDtUpdVOs() , account );
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("aud_ver_seq" , audVerSeq);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
   /**
    * EES_DMT_2013 : Retrieve<br>
    * S/C No. 에 해당되는 S/C Exception Tariff History 를 조회 합니다. <br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchSCExceptionListByPropNo(Event e) throws EventException {
        GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
        SCExceptionTariffMgtBC 	command 		= new SCExceptionTariffMgtBCImpl();
        EesDmt2103Event 		event 			= (EesDmt2103Event)e;
        SCExceptionParmVO 		parmVO			= null;
        List<SCExceptionVO> 	list			= null;
        
       try {
    	   parmVO 	= event.getSCExceptionParmVO();
    	   list 	= command.searchSCExceptionListByPropNo(parmVO.getPropNo());
    	   
    	   eventResponse.setRsVoList(list);
       } catch(EventException ex) {
           throw ex;
       } catch(Exception ex) {
           throw new EventException(ex.getMessage(), ex);
       }       
       return eventResponse;
	}
   
    /**
     * EES_DMT_2013 : Retrieve<br>
     * Customer Code 와 S/C No. 에 해당되는 S/C Exception Tariff History 를 조회 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSCExceptionListByCustomer(Event e) throws EventException {
        GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
        SCExceptionTariffMgtBC 	command 		= new SCExceptionTariffMgtBCImpl();
        EesDmt2103Event 		event 			= (EesDmt2103Event)e;
        SCExceptionParmVO 		parmVO			= null;
        List<SCExceptionVO> 	list			= null;
        
        try {
        	parmVO 	= event.getSCExceptionParmVO();
        	list 	= command.searchSCExceptionListByCustomer(parmVO.getCustCd());
        	
        	eventResponse.setRsVoList(list);
        } catch(EventException ex) {
        	throw ex;
        } catch(Exception ex) {
        	throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }

    /**
     * EES_DMT_2105 : Open<br>
     * RFA No. 에 해당되는 DAR History 를 조회한다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBeforeExceptionListByPropNo(Event e) throws EventException {
		 GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		 RFAExceptionTariffMgtBC 		command 			= new RFAExceptionTariffMgtBCImpl();
         EesDmt2105Event 				event 				= (EesDmt2105Event)e;
         BeforeExceptionListInputVO 	inputVO				= null;
         List<BeforeExceptionListVO> 	list				= null;
         
        try {
        	inputVO 	= event.getBeforeExceptionListInputVO();
        	//Temp Saved. 상태의 Before Booking 데이터는 조회대상에서 배제시킨다.
        	inputVO.setIsTemp("N");
        	
        	list 		= command.searchBeforeExceptionListByPropNo(inputVO);
     	    eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
     /**
      * EES_DMT_2105 : Open<br>
      * Customer Code 와 RFA No. 에 해당되는 DAR History 를 조회 합니다.<br>
      * 
      * @param Event e
      * @return EventResponse
      * @exception EventException
      */
    private EventResponse searchBeforeExceptionListByCustomer(Event e) throws EventException {
 		 GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		 RFAExceptionTariffMgtBC 		command 			= new RFAExceptionTariffMgtBCImpl();
         EesDmt2105Event 				event 				= (EesDmt2105Event)e;
         BeforeExceptionListInputVO 	inputVO				= null;
         List<BeforeExceptionListVO> 	list				= null;
         
         try {
        	 inputVO 	= event.getBeforeExceptionListInputVO();
        	 //Temp Saved. 상태의 Before Booking 데이터는 조회대상에서 배제시킨다.
        	 inputVO.setIsTemp("N");
        	 list 		= command.searchBeforeExceptionListByCustomer(inputVO);
        	 
         	 eventResponse.setRsVoList(list);
         } catch(EventException ex) {
         	throw ex;
         } catch(Exception ex) {
         	throw new EventException(ex.getMessage(), ex);
         }       
         return eventResponse;
     }     
     
     /**
      * EES_DMT_7008 : Retrieve<br>
      * 승인권한자 List 를 조회하는 화면<br>
      * 
      * @param Event e
      * @return EventResponse
      * @exception EventException
      */
    private EventResponse searchApprovalAuthorityList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt7008Event event = (EesDmt7008Event)e;
        RFAExceptionTariffMgtBC command = new RFAExceptionTariffMgtBCImpl();
        
        try {
       	 // 승인권한 조회 대상목록
       	 String[] auths = {"before", "after", "inactive"};
      	 
       	 for (String auth : auths) {

       		 eventResponse.setRsVoList(command.searchApprovalAuthorityList(event.getApprovalRequestUserVO(), auth));
       	 }
        } 
        catch(EventException ex) {
        	throw ex;
        } 
        catch(Exception ex) {
        	throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
     }
     
 	/**
 	 * EES_DMT_2009 : Approval<br>
 	 * APPROVAL, COUNTER OFFER, REJECT 처리후 메일을 전송 합니다.<br>
 	 * 
 	 * @param RFAProgressVO rFAProgressVO
 	 * @return void
 	 * @exception EventException
 	 */	
 	private void sendEmail(RFAProgressVO rFAProgressVO) throws EventException {
 		boolean		isThrowException = false;
 		
 		try {
 			//승인처리 후 메일송부 ##########################################################################
 			FaxEmailBC 			mailBC 		= new FaxEmailBCImpl();
 			GRWEmailNoticeVO 	emailVO 	= new GRWEmailNoticeVO();
 			String 				receivers	= mailBC.searchBeforeBookingUserEmailByDARNo(
 														rFAProgressVO.getRfaExptDarNo()
 													, 	rFAProgressVO.getRfaExptMapgSeq()
 													, 	rFAProgressVO.getRfaExptVerSeq()
 												);
 			StringBuffer		subject		= new StringBuffer();
 			
 			//제목설정
 			subject.append("[DEM/DET] DAR No. ");
 			subject.append(rFAProgressVO.getRfaExptDarNo());
 			subject.append(" - ");
 			subject.append(rFAProgressVO.getDmdtExptRqstStsDesc());
 	
 			emailVO.setSender(		account.getUsr_eml()					);
 			emailVO.setRecipient(	receivers								);
 			emailVO.setSubject(		subject.toString()						);
 			
 			//HTML Template 의 파라미터와 매핑되어져 나타날 데이터들 설정
 			emailVO.setDarNo(		rFAProgressVO.getRfaExptDarNo()			);
 			emailVO.setVerNo(		rFAProgressVO.getRfaExptVerSeq()		);
 			
 			if (rFAProgressVO.getRfaExptAproNo() != null 
 					&& rFAProgressVO.getRfaExptAproNo().length() > 0) {
 				//Approval No. 를 주어진 형식의 Content 로 보여주도록 처리한다.
 				StringBuffer sbApvlCntn = new StringBuffer();
 				sbApvlCntn.append("(Approval No.: ");
 				sbApvlCntn.append(rFAProgressVO.getRfaExptAproNo());
 				sbApvlCntn.append(")");
 				
 				emailVO.setApvlNo(	sbApvlCntn.toString()					);
 			}
 			else {
 				emailVO.setApvlNo(		""									);	
 			}
 			
 			emailVO.setStatus(		rFAProgressVO.getDmdtExptRqstStsDesc()	);
 			emailVO.setRfaNo(		rFAProgressVO.getRfaNo()				);
 			emailVO.setPropNo(		rFAProgressVO.getPropNo()				);
 			emailVO.setCustCd(		rFAProgressVO.getCustCd()				);
 			emailVO.setCustNm(		rFAProgressVO.getCustNm()				);
 			emailVO.setComments(	rFAProgressVO.getProgRmk()				);
 					
 			//HTML Template 파일명 설정
 			emailVO.setHtmltemplate("EES_DMT_0001_01T.html"					);
 			
 			//메일 송신
 			begin();
 			mailBC.sendGRWEmail(emailVO);
 			commit();
 			//############################################################################################	
 		} catch(EventException e) {
 			rollback();
 			if (isThrowException)
 				throw e;
 		} catch(Exception ex){
 			rollback();
 			if (isThrowException)
 				throw new EventException(ex.getMessage(), ex);
 		}
 	}
 	
	/**
	 * EES_DMT_2001 : Open<br>
	 * 페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse searchSCInitControls(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		CommonFinderBC 			command 			= new CommonFinderBCImpl();
		SCExceptionTariffMgtBC	command2			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event			event				= (EesDmt2001Event)e;
		
		try{
			//1.Tariff Type 정보를 조회한다.===================================================================================
			List<TariffNameVO> 		tariffList 			= command.searchTariffTypeList();
			StringBuffer 			sbTariff 			= new StringBuffer();
			
			if (tariffList != null && tariffList.size() > 0) {
				for (int i = 0 ; i < tariffList.size() ; i++) {
					sbTariff.append(tariffList.get(i).getDmdtTrfCd()).append("=").append(tariffList.get(i).getDmdtTrfNm());
					if (i < tariffList.size() - 1) sbTariff.append("|");
				}
			}
			eventResponse.setETCData("TARIFF", sbTariff.toString());
			//===============================================================================================================
			
			//2.CNTR/CGO 정보를 조회한다.======================================================================================
			CommonCodeVO			commonCodeVO		= new CommonCodeVO();
			commonCodeVO.setIntgCdId("CD01969");
			
			List<CommonCodeVO> 		cntrCgoList 		= command.searchCommonCode(commonCodeVO);
			StringBuffer 			sbCntrCgo 			= new StringBuffer();
			
			if (cntrCgoList != null && cntrCgoList.size() > 0) {
				for (int i = 0 ; i < cntrCgoList.size() ; i++) {
					sbCntrCgo.append(cntrCgoList.get(i).getIntgCdValCtnt()).append("=").append(cntrCgoList.get(i).getIntgCdValDpDesc());
					if (i < cntrCgoList.size() - 1) sbCntrCgo.append("|");
				}
			}
			eventResponse.setETCData("CNTRCGO", sbCntrCgo.toString());
			//===============================================================================================================
			
			//3.Continent 정보를 조회한다.====================================================================================
			List<CoverageVO> 		continentList		= command.searchContinetList();
			StringBuffer			sbContinent			= new StringBuffer();
			
			if (continentList != null && continentList.size() > 0) {
				sbContinent.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < continentList.size() ; i++) {
					sbContinent.append(continentList.get(i).getContiCd()).append("=").append(continentList.get(i).getContiNm());
					if (i < continentList.size() - 1) sbContinent.append("|");
				}
			}
			eventResponse.setETCData("CONTINENT", sbContinent.toString());
			//===============================================================================================================
			
			//4.Country 정보를 조회한다.=======================================================================================
			CoverageVO				coverageVO				= new CoverageVO();
			List<CoverageVO> 		countryList 			= command.searchCountryList(coverageVO);
			StringBuffer 			sbCountry				= new StringBuffer();
			
			if (countryList != null && countryList.size() > 0) {
				sbCountry.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < countryList.size(); i++) {
					sbCountry.append(countryList.get(i).getCntCd()).append("=").append(countryList.get(i).getCntNm());
					if (i < countryList.size() - 1) sbCountry.append("|");
				}
			}
			eventResponse.setETCData("COUNTRY", sbCountry.toString());
			//===============================================================================================================
			
			//5.Region 정보를 조회한다.=======================================================================================
			List<CoverageVO> 		regionList 				= command.searchRegionList(coverageVO);
			StringBuffer 			sbRegion				= new StringBuffer();
			
			if (regionList != null && regionList.size() > 0) {
				sbRegion.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < regionList.size(); i++) {
					sbRegion.append(regionList.get(i).getRgnCd()).append("=").append(regionList.get(i).getRgnNm());
					if (i < regionList.size() - 1) sbRegion.append("|");
				}
			}
			eventResponse.setETCData("REGION", sbRegion.toString());
			//===============================================================================================================
			
			//6.S/C Duration 정보를 조회한다.==================================================================================
			SCExceptionParmVO 		sCDurationVO 			= command2.searchSCDuration(event.getSCExceptionParmVO());
	
			if (sCDurationVO != null) {
				eventResponse.setETCData("EFF_DT", sCDurationVO.getEffDt());
				eventResponse.setETCData("EXP_DT", sCDurationVO.getExpDt());
			}
			//===============================================================================================================
			
			//7.Accept, Accept Cancel 버튼권한 정보를 조회한다.=================================================================
			boolean 				hasAuth 				= command2.hasAcceptAuth(event.getSCExceptionParmVO());
	
			eventResponse.setETCData("HAS_AUTH", hasAuth ? "Y" : "N");
			//===============================================================================================================	
			
			//8.SC No. 와  Contract Party 정보를 조회한다.======================================================================
			List<SCExceptionCustomerVO> custList			= command2.searchSCNoCustomerByProposalNo(event.getSCExceptionParmVO());
	
			if (custList != null && custList.size() > 0) {
				eventResponse.setETCData("SC_NO", 		custList.get(0).getScNo());
				eventResponse.setETCData("CUST_SEQ", 	custList.get(0).getCustSeq());
				eventResponse.setETCData("CUST_CD", 	custList.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", 	custList.get(0).getCustNm());
			}
			//===============================================================================================================

			//9.SC No. 와  Contract Party 정보를 조회한다.======================================================================
			List<SCExceptionCustomerVO> custTpCd			= command2.searchSCNoCustTpCdProposalNo(event.getSCExceptionParmVO());
	
			if (custList != null && custList.size() > 0) {
				eventResponse.setETCData("PRC_CTRT_CUST_TP_CD", 		custTpCd.get(0).getPrcCtrtCustTpCd());
			}
			//===============================================================================================================	
			
			//9.Actual Customer 정보를 조회한다.===============================================================================
			List<SCExceptionCustomerVO>	actCustList			= command2.searchCustomerListBySC(event.getSCExceptionParmVO());
			StringBuffer 				sbActCust			= new StringBuffer();
			
			if (actCustList != null && actCustList.size() > 0) {
				sbActCust.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < actCustList.size() ; i++) {
					sbActCust.append(actCustList.get(i).getCustCd()).append("=").append(actCustList.get(i).getCustNm());
					if (i < actCustList.size() - 1) sbActCust.append("|");
				}
			}
			
			eventResponse.setETCData("CUST", sbActCust.toString());
			//===============================================================================================================
			
			//10.Commodity 정보를 조회한다.===============================================================================
			List<SCExceptionCommodityVO>	cmdtList		= command2.searchCommodityListBySC(event.getSCExceptionParmVO());
			StringBuffer 					sbCmdt			= new StringBuffer();
			
			if (cmdtList != null && cmdtList.size() > 0) {
				sbCmdt.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < cmdtList.size() ; i++) {
					sbCmdt.append(cmdtList.get(i).getCmdtCd()).append("=").append(cmdtList.get(i).getCmdtNm());
					if (i < cmdtList.size() - 1) sbCmdt.append("|");
				}
			}
			
			eventResponse.setETCData("CMDT", sbCmdt.toString());
			//===============================================================================================================	
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * S/C Exception Tariff 에서 선택한 Group Seq. 에 대한 해당 데이터를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCExceptionByGroupSeq(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 			command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 				event 				= (EesDmt2001Event)e;
		try{
			List<SCExceptionVO> 			sCExceptionVOs		= command.searchSCException(event.getSCExceptionParmVO());
	
			if (sCExceptionVOs != null) {
				
				if (	"CA".equals(sCExceptionVOs.get(0).getCntCd()) 
					|| 	"US".equals(sCExceptionVOs.get(0).getCntCd())	) {
					sCExceptionVOs.get(0).setRgnCd(sCExceptionVOs.get(0).getSteCd());
				}
				if (	"CA".equals(sCExceptionVOs.get(0).getScExptFmCntCd()) 
					|| 	"US".equals(sCExceptionVOs.get(0).getScExptFmCntCd())) {
					sCExceptionVOs.get(0).setScExptFmRgnCd(sCExceptionVOs.get(0).getScExptFmSteCd());
				}
				if (	"CA".equals(sCExceptionVOs.get(0).getFnlDestCntCd()) 
					|| 	"US".equals(sCExceptionVOs.get(0).getFnlDestCntCd())) {
					sCExceptionVOs.get(0).setFnlDestRgnCd(sCExceptionVOs.get(0).getFnlDestSteCd());
				}			
				
				eventResponse.setETCData("TARIFF", 			sCExceptionVOs.get(0).getDmdtTrfCd());
				eventResponse.setETCData("EFF_DT", 			sCExceptionVOs.get(0).getEffDt());
				eventResponse.setETCData("EXP_DT", 			sCExceptionVOs.get(0).getExpDt());
				eventResponse.setETCData("CNTRCGO", 		sCExceptionVOs.get(0).getDmdtCntrCgoTpCd());
				eventResponse.setETCData("CVRG_MULTI", 		sCExceptionVOs.get(0).getCvrgMulti());
				eventResponse.setETCData("CVRG_CNT", 		sCExceptionVOs.get(0).getCntCd());
				eventResponse.setETCData("CVRG_RGN", 		sCExceptionVOs.get(0).getRgnCd());
				eventResponse.setETCData("CVRG_LOC", 		sCExceptionVOs.get(0).getLocCd());
				eventResponse.setETCData("FT_FLG", 			sCExceptionVOs.get(0).getFtFlg());
				eventResponse.setETCData("FT_TIR", 			sCExceptionVOs.get(0).getFtTir());
				eventResponse.setETCData("ADD_DYS", 		sCExceptionVOs.get(0).getFtAddDys());
				eventResponse.setETCData("TOT_DYS", 		sCExceptionVOs.get(0).getFtTotDys());
				eventResponse.setETCData("SAT_FLG", 		sCExceptionVOs.get(0).getXcldSatFlg());
				eventResponse.setETCData("SUN_FLG", 		sCExceptionVOs.get(0).getXcldSunFlg());
				eventResponse.setETCData("HOL_FLG", 		sCExceptionVOs.get(0).getXcldHolFlg());
				eventResponse.setETCData("ORGDST_CTI", 		sCExceptionVOs.get(0).getScExptFmContiCd());
				eventResponse.setETCData("ORGDST_CNT", 		sCExceptionVOs.get(0).getScExptFmCntCd());
				eventResponse.setETCData("ORGDST_RGN", 		sCExceptionVOs.get(0).getScExptFmRgnCd());
				eventResponse.setETCData("ORGDST_LOC", 		sCExceptionVOs.get(0).getScExptFmLocCd());
				eventResponse.setETCData("BKGDEL_CNT", 		sCExceptionVOs.get(0).getFnlDestCntCd());
				eventResponse.setETCData("BKGDEL_RGN", 		sCExceptionVOs.get(0).getFnlDestRgnCd());
				eventResponse.setETCData("BKGDEL_LOC", 		sCExceptionVOs.get(0).getFnlDestLocCd());
				eventResponse.setETCData("CYDOOR", 			sCExceptionVOs.get(0).getRcvDeTermCd());
				eventResponse.setETCData("REMARK", 			sCExceptionVOs.get(0).getExptTrfRmk());
				eventResponse.setETCData("PROP_NO", 		sCExceptionVOs.get(0).getPropNo());
				eventResponse.setETCData("VER_SEQ", 		sCExceptionVOs.get(0).getScExptVerSeq());
				eventResponse.setETCData("GRP_SEQ", 		sCExceptionVOs.get(0).getScExptGrpSeq());
				eventResponse.setETCData("CURR_CVRG_MULTI", sCExceptionVOs.get(0).getCurrCvrgMulti());
				eventResponse.setETCData("CURR_CD", 		sCExceptionVOs.get(0).getCurrCd());
				eventResponse.setETCData("FULL_REMARK", 	sCExceptionVOs.get(0).getFullExptTrfRmk());
				eventResponse.setETCData("RT_MANDATORY", 	sCExceptionVOs.get(0).getRtChkFlg());
				eventResponse.setETCData("RT_CHECK", 		sCExceptionVOs.get(0).getRtChk());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Open<br>
	 * 페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse searchRFAInitControls(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		CommonFinderBC 			command 			= new CommonFinderBCImpl();
		RFAExceptionTariffMgtBC command2 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event			event				= (EesDmt2003Event)e;
		try{
		
			//1.로그인 User가 Security 상에서 EES_DMT_2005(DAR-Before BKG Approval)의 Access 권한이 있는지 조회한다.===============
			UserRoleVO				paramRoleVO				= new UserRoleVO();
			paramRoleVO.setUsrId(		event.getRFAProgressVO().getUsrId()		);
			paramRoleVO.setPgmNo(		event.getRFAProgressVO().getPgmNo()		);
			paramRoleVO.setUsrRoleCd(	event.getRFAProgressVO().getUsrRoleCd()	);
			
			UserRoleVO 				roleVO 				= command.hasRoleAuth(paramRoleVO);
	
			eventResponse.setETCData("ROLE_PERMIT", 	roleVO.getIsAuthorized());
			eventResponse.setETCData("ROLE_AUTH", 		roleVO.getUsrRoleCd());
			//===============================================================================================================
			
			//2.Tariff Type 정보를 조회한다.===================================================================================
			List<TariffNameVO> 		tariffList 			= command.searchTariffTypeList();
			StringBuffer 			sbTariff 			= new StringBuffer();
			
			if (tariffList != null && tariffList.size() > 0) {
				for (int i = 0 ; i < tariffList.size() ; i++) {
					sbTariff.append(tariffList.get(i).getDmdtTrfCd()).append("=").append(tariffList.get(i).getDmdtTrfNm());
					if (i < tariffList.size() - 1) sbTariff.append("|");
				}
			}
			eventResponse.setETCData("TARIFF", sbTariff.toString());
			//===============================================================================================================
			
			//3.CNTR/CGO 정보를 조회한다.======================================================================================
			ContainerCargoVO 		paramCargoVO		= new ContainerCargoVO();
			paramCargoVO.setCode1(		event.getRFAProgressVO().getCode1()		);
			paramCargoVO.setCode2(		event.getRFAProgressVO().getCode2()		);
			
			List<ContainerCargoVO> 	cntrCgoList 		= command.searchContainterCargoList(paramCargoVO);
			StringBuffer 			sbCntrCgo 			= new StringBuffer();
			
			// 아래 Logic은 실제 화면 적용시에 변경 처리 필요 : 적용 후 주석 삭제 
			if (cntrCgoList != null && cntrCgoList.size() > 0) {
				for (int i = 0 ; i < cntrCgoList.size() ; i++) {
					sbCntrCgo.append(cntrCgoList.get(i).getCntrCgo()).append("=").append(cntrCgoList.get(i).getDmdtCgoTpNm()).append("^").append(cntrCgoList.get(i).getDmdtCntrTpNm());
					if (i < cntrCgoList.size() - 1) sbCntrCgo.append("|");
				}
			}
			eventResponse.setETCData("CNTRCGO", sbCntrCgo.toString());		
			//===============================================================================================================
			
			//4.Continent 정보를 조회한다.====================================================================================
			List<CoverageVO> 		continentList		= command.searchContinetList();
			StringBuffer			sbContinent			= new StringBuffer();
			
			if (continentList != null && continentList.size() > 0) {
				sbContinent.append(" ").append("=").append(" ").append("|");
				
				for (int i = 0 ; i < continentList.size() ; i++) {
					sbContinent.append(continentList.get(i).getContiCd()).append("=").append(continentList.get(i).getContiNm());
					if (i < continentList.size() - 1) sbContinent.append("|");
				}
			}
			eventResponse.setETCData("CONTINENT", sbContinent.toString());
			//===============================================================================================================
			
			//5.Country 정보를 조회한다.=======================================================================================
			CoverageVO				coverageVO				= new CoverageVO();
			List<CoverageVO> 		countryList 			= command.searchCountryList(coverageVO);
			StringBuffer 			sbCountry				= new StringBuffer();
			
			if (countryList != null && countryList.size() > 0) {
				sbCountry.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < countryList.size(); i++) {
					sbCountry.append(countryList.get(i).getCntCd()).append("=").append(countryList.get(i).getCntNm());
					if (i < countryList.size() - 1) sbCountry.append("|");
				}
			}
			eventResponse.setETCData("COUNTRY", sbCountry.toString());
			//===============================================================================================================
			
			//6.Region 정보를 조회한다.=======================================================================================
			List<CoverageVO> 		regionList 				= command.searchRegionList(coverageVO);
			StringBuffer 			sbRegion				= new StringBuffer();
			
			if (regionList != null && regionList.size() > 0) {
				sbRegion.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < regionList.size(); i++) {
					sbRegion.append(regionList.get(i).getRgnCd()).append("=").append(regionList.get(i).getRgnNm());
					if (i < regionList.size() - 1) sbRegion.append("|");
				}
			}
			eventResponse.setETCData("REGION", sbRegion.toString());
			//===============================================================================================================
			
			//7.RFA No. 와 Customer 정보를 조회한다.===========================================================================
			List<RFAExceptionCustomerVO> custList			= command2.searchRFANoCustomerByProposalNo(event.getRFAProgressVO());
	
			if (custList != null && custList.size() > 0) {
				eventResponse.setETCData("RFA_NO", 		custList.get(0).getRfaNo());
				eventResponse.setETCData("CUST_SEQ", 	custList.get(0).getCustSeq());
				eventResponse.setETCData("CUST_CD", 	custList.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", 	custList.get(0).getCustNm());
			}
			//===============================================================================================================
			
			//8.Actual Customer 정보를 조회한다.===============================================================================
			List<RFAExceptionCustomerVO> 	actCustList		= command2.searchCustomerListByRFA(event.getRFAProgressVO());
			StringBuffer 					sbActCust 		= new StringBuffer();
				
			if (actCustList != null && actCustList.size() > 0) {
				sbActCust.append(" ").append("=").append(" ").append("|");
				
				for (int i = 0 ; i < actCustList.size() ; i++) {
					sbActCust.append(actCustList.get(i).getCustCd()).append("=").append(actCustList.get(i).getCustNm());
					if (i < actCustList.size() - 1) sbActCust.append("|");
				}
			}
			eventResponse.setETCData("CUST", sbActCust.toString());
			//===============================================================================================================
			
			//9.DAR 정보를 조회한다.===============================================================================
			List<RFAProgressVO>				darList			= command2.searchBeforeDARList(event.getRFAProgressVO());
			StringBuffer 					sbDar	 		= new StringBuffer();
				
			if (darList != null && darList.size() > 0) {
				for (int i = 0 ; i < darList.size() ; i++) {
					sbDar.append(darList.get(i).getAproOfcCd()).append("=").append(darList.get(i).getRfaExptDarNo());
					if (i < darList.size() - 1) sbDar.append("|");
				}
			}
			eventResponse.setETCData("DAR", sbDar.toString());
			//===============================================================================================================
			
			// 10. Master/Basic/General RFA 인지 조회한다. ==================================================================
			boolean isBzcRfa = command2.isBzcRfa(event.getRFAProgressVO().getPropNo());
			eventResponse.setETCData("BZC_RFA_YN", isBzcRfa ? "Y" : "N");
			//===============================================================================================================	
			
			// 11. Master Ver. 이 Basic Ver. 보다 상위인지 조회한다. ========================================================
			String bzcPropNo = event.getRFAProgressVO().getPropNo();
			String mstPropNo = command2.searchPropNoOfMstRfa(bzcPropNo);
			
			boolean isMstRfaVerUppr = command2.isUpprMstRfaVerThanBzcRfaVer(mstPropNo, bzcPropNo);
			eventResponse.setETCData("MST_RFA_VER_UPPR_YN", isMstRfaVerUppr ? "Y" : "N");
			//===============================================================================================================
			
			// 12. Proposal No. 에 대한 BBE( Before Booking Exception ) 가 존재하는지 여부 ==================================
			boolean isExistRfa = command2.isExistRfa(event.getRFAProgressVO().getPropNo());
			eventResponse.setETCData("EXIST_RFA_YN", isExistRfa ? "Y" : "N");
			//===============================================================================================================			
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Before Booking Request 의 Detail Seq. 에 포함되는 Multi Origin or Dest., Rate Adjustment 를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubBeforeException(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 				= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 		command 					= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 					rFAProgressVO 				= null;
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
				//Temp Saved 상태의 데이터도 조회대상에서 포함된다.
				rFAProgressVO.setIsTemp("Y");
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
				//Temp Saved 상태의 데이터는 조회대상에서 배제한다.
				rFAProgressVO.setIsTemp("N");
			}
			
			//Multi Origin or Dest. 조회를 수행한다.
			List<RFAExceptionCoverageVO>	rFAExceptionCoverageVOs		= command.searchMultiCoverageByRFA(rFAProgressVO);
			
			//Rate Adjustment 조회를 수행한다.
			List<RFAExceptionRateAdjustVO>	rFAExceptionRateAdjustVOs 	= command.searchRateAdjustmentByRFA(rFAProgressVO);
			
			//조회된 결과를 적절하게 변환하여 준다.
			if (e instanceof EesDmt2003Event) {
				//Continent 에 해당되는 Country 목록을 가진다.
				Map<String, Object> mapCountryCodes = new HashMap<String, Object>();
				Map<String, Object> mapCountryNames = new HashMap<String, Object>();
		
				//Country 에 해당되는 Region 목록을 가진다.
				Map<String, Object> mapRegionCodes = new HashMap<String, Object>();
				Map<String, Object> mapRegionNames = new HashMap<String, Object>();
				
				String cntCd = null;
				String contiCd = null;
			
				//RFA Exception Multi Origin or Destination
				if (rFAExceptionCoverageVOs != null && rFAExceptionCoverageVOs.size() > 0) {
		
					for (int i = 0 ; i < rFAExceptionCoverageVOs.size() ; i++) {
						
						contiCd = rFAExceptionCoverageVOs.get(i).getOrgDestContiCd() != null ? rFAExceptionCoverageVOs.get(i).getOrgDestContiCd().trim() : "";
						if (contiCd.length() > 0) {
							if (!mapCountryCodes.containsKey(contiCd)) {
								CommonCodeVO commonCodeVO = getAllCountry(contiCd);
								mapCountryCodes.put(contiCd, commonCodeVO.getIntgCdId());
								mapCountryNames.put(contiCd, commonCodeVO.getIntgCdValDpDesc());
							}
							rFAExceptionCoverageVOs.get(i).setOrgDestCntAllCd((String)mapCountryCodes.get(contiCd));
							rFAExceptionCoverageVOs.get(i).setOrgDestCntAllNm((String)mapCountryNames.get(contiCd));				
						} else {
							rFAExceptionCoverageVOs.get(i).setOrgDestCntAllCd("");
							rFAExceptionCoverageVOs.get(i).setOrgDestCntAllNm("");
						}
						
						cntCd = rFAExceptionCoverageVOs.get(i).getOrgDestCntCd() != null ? rFAExceptionCoverageVOs.get(i).getOrgDestCntCd().trim() : "";
						if (cntCd.length() > 0) {
							if (!mapRegionCodes.containsKey(cntCd)) {
								CommonCodeVO reVO = getAllRegion(cntCd);
								mapRegionCodes.put(cntCd, reVO.getIntgCdId());
								mapRegionNames.put(cntCd, reVO.getIntgCdValDpDesc());
							}
							rFAExceptionCoverageVOs.get(i).setOrgDestRgnAllCd((String)mapRegionCodes.get(cntCd));
							rFAExceptionCoverageVOs.get(i).setOrgDestRgnAllNm((String)mapRegionNames.get(cntCd));				
						} else {
							rFAExceptionCoverageVOs.get(i).setOrgDestRgnAllCd("");
							rFAExceptionCoverageVOs.get(i).setOrgDestRgnAllNm("");
						}				
					}
				}
			}
			else if (e instanceof EesDmt2005Event) {
				String cntCd = null;
				
				//RFA Exception Multi Origin or Destination
				if (rFAExceptionCoverageVOs != null && rFAExceptionCoverageVOs.size() > 0) {
		
					for (int i = 0 ; i < rFAExceptionCoverageVOs.size() ; i++) {
						//Multi Origin(I) or Dest.(O)
						cntCd = rFAExceptionCoverageVOs.get(i).getOrgDestCntCd() != null ? rFAExceptionCoverageVOs.get(i).getOrgDestCntCd().trim() : "";
						if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
							rFAExceptionCoverageVOs.get(i).setOrgDestRgnCd(rFAExceptionCoverageVOs.get(i).getOrgDestSteCd());
						}						
					}
				}			
			}
			
			//조회된 결과를 반환한다.
			eventResponse.setRsVoList(rFAExceptionCoverageVOs);
			eventResponse.setRsVoList(rFAExceptionRateAdjustVOs);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Before Booking Request 에서 선택한 Detail Seq. 에 대한 해당 데이터를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBeforeExceptionByDetailSeq(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 			= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 			rFAProgressVO 		= null;
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
				//Temp Saved 상태의 데이터도 조회대상에서 포함된다.
				rFAProgressVO.setIsTemp("Y");
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
				//Temp Saved 상태의 데이터는 조회대상에서 배제한다.
				rFAProgressVO.setIsTemp("N");
			}
			
			//조회를 수행한다.
			List<BeforeExceptionVO> beforeExceptionVOs	= command.searchBeforeExceptionList(rFAProgressVO);
			
			//조회된 결과를 적절하게 변환하여 준다.
			if (beforeExceptionVOs != null) {
				
				if (	"CA".equals(beforeExceptionVOs.get(0).getCvrgCntCd()) 
					|| 	"US".equals(beforeExceptionVOs.get(0).getCvrgCntCd())	) {
					beforeExceptionVOs.get(0).setCvrgRgnCd(beforeExceptionVOs.get(0).getCvrgSteCd());
				}
				if (	"CA".equals(beforeExceptionVOs.get(0).getOrgDestCntCd()) 
					|| 	"US".equals(beforeExceptionVOs.get(0).getOrgDestCntCd())) {
					beforeExceptionVOs.get(0).setOrgDestRgnCd(beforeExceptionVOs.get(0).getOrgDestSteCd());
				}
				if (	"CA".equals(beforeExceptionVOs.get(0).getFnlDestCntCd()) 
					|| 	"US".equals(beforeExceptionVOs.get(0).getFnlDestCntCd())) {
					beforeExceptionVOs.get(0).setFnlDestRgnCd(beforeExceptionVOs.get(0).getFnlDestSteCd());
				}			
				
				eventResponse.setETCData("TARIFF", 				beforeExceptionVOs.get(0).getDmdtTrfCd());
				eventResponse.setETCData("EFF_DT", 				beforeExceptionVOs.get(0).getEffDt());
				eventResponse.setETCData("EXP_DT", 				beforeExceptionVOs.get(0).getExpDt());
				eventResponse.setETCData("CNTRCGO", 			beforeExceptionVOs.get(0).getDmdtCntrCgoTpCd());
				eventResponse.setETCData("CVRG_CTI", 			beforeExceptionVOs.get(0).getCvrgContiCd());
				eventResponse.setETCData("CVRG_CNT", 			beforeExceptionVOs.get(0).getCvrgCntCd());
				eventResponse.setETCData("CVRG_RGN", 			beforeExceptionVOs.get(0).getCvrgRgnCd());
				eventResponse.setETCData("CVRG_LOC", 			beforeExceptionVOs.get(0).getCvrgLocCd());
				eventResponse.setETCData("FT_FLG", 				beforeExceptionVOs.get(0).getFtUseFlg());
				eventResponse.setETCData("ADD_DYS", 			beforeExceptionVOs.get(0).getAddDys());
				eventResponse.setETCData("TOT_DYS", 			beforeExceptionVOs.get(0).getTtlDys());
				eventResponse.setETCData("SAT_FLG", 			beforeExceptionVOs.get(0).getXcldSatFlg());
				eventResponse.setETCData("SUN_FLG", 			beforeExceptionVOs.get(0).getXcldSunFlg());
				eventResponse.setETCData("HOL_FLG", 			beforeExceptionVOs.get(0).getXcldHolFlg());
				eventResponse.setETCData("ORGDST_MULTI", 		beforeExceptionVOs.get(0).getOrgDestMulti());
				eventResponse.setETCData("ORGDST_CTI", 			beforeExceptionVOs.get(0).getOrgDestContiCd());
				eventResponse.setETCData("ORGDST_CNT", 			beforeExceptionVOs.get(0).getOrgDestCntCd());
				eventResponse.setETCData("ORGDST_RGN", 			beforeExceptionVOs.get(0).getOrgDestRgnCd());
				eventResponse.setETCData("ORGDST_LOC", 			beforeExceptionVOs.get(0).getOrgDestLocCd());
				eventResponse.setETCData("BKGDEL_CTI", 			beforeExceptionVOs.get(0).getFnlDestContiCd());
				eventResponse.setETCData("BKGDEL_CNT", 			beforeExceptionVOs.get(0).getFnlDestCntCd());
				eventResponse.setETCData("BKGDEL_RGN", 			beforeExceptionVOs.get(0).getFnlDestRgnCd());
				eventResponse.setETCData("BKGDEL_LOC", 			beforeExceptionVOs.get(0).getFnlDestLocCd());
				eventResponse.setETCData("CUST_CD", 			beforeExceptionVOs.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", 			beforeExceptionVOs.get(0).getCustNm());
				eventResponse.setETCData("REMARK", 				beforeExceptionVOs.get(0).getExptTrfRmk());
				eventResponse.setETCData("DAR_NO", 				beforeExceptionVOs.get(0).getRfaExptDarNo());
				eventResponse.setETCData("MAPG_SEQ", 			beforeExceptionVOs.get(0).getRfaExptMapgSeq());
				eventResponse.setETCData("VER_SEQ", 			beforeExceptionVOs.get(0).getRfaExptVerSeq());
				eventResponse.setETCData("DTL_SEQ", 			beforeExceptionVOs.get(0).getRfaRqstDtlSeq());
				eventResponse.setETCData("CVRG_SEQ", 			beforeExceptionVOs.get(0).getCvrgCmbSeq());
				eventResponse.setETCData("VIEW_CVRG_SEQ", 		beforeExceptionVOs.get(0).getViewCvrgCmbSeq());
				eventResponse.setETCData("CURR_ORGDST_MULTI",	beforeExceptionVOs.get(0).getCurrOrgDestMulti());
				eventResponse.setETCData("CURR_CD", 			beforeExceptionVOs.get(0).getCurrCd());
				eventResponse.setETCData("FULL_REMARK", 		beforeExceptionVOs.get(0).getFullExptTrfRmk());
				eventResponse.setETCData("RQST_STS_CD", 		beforeExceptionVOs.get(0).getDmdtExptRqstStsCd());
				eventResponse.setETCData("RQST_OFC_CD", 		beforeExceptionVOs.get(0).getRqstOfcCd());
			}		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Save<br>
	 * 화면에서 입력한 RFA 정보와 기등록된 RFA 정보중 중복된 데이터가 있는지 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDuplicateBeforeException(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 		command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event 				event 				= (EesDmt2003Event)e;
		try{
			//중복된 데이터인지 조회를 실행합니다.
			//boolean isDuplicate = command.isDuplicateRFA(event.getRFAProgressVO());
			String resultMsg = command.isDuplicateRFA(event.getRFAProgressVO());
	
			eventResponse.setETCData("RESULT", resultMsg);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Update<br>
	 * Update 버튼 클릭시 'Approved', 'Rejected' 상태의 Before Booking Request 정보를 새로운 버전으로 생성 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse addBeforeExceptionByUpdate(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event 		event 				= (EesDmt2003Event)e;
		RFAProgressVO			rFAProgressVO		= event.getRFAProgressVO();

		try {
			rFAProgressVO.setCreUsrId(		account.getUsr_id()		);
			rFAProgressVO.setCreOfcCd(		account.getOfc_cd()		);
			rFAProgressVO.setRqstUsrId(		account.getUsr_id()		);
			rFAProgressVO.setRqstOfcCd(		account.getOfc_cd()		);
			
			// Basic RFA 인 경우는, Master RFA 의 상위버전으로 copy 를 한다.
			
			begin();
			command.addBeforeExceptionByUpdate(rFAProgressVO);
			commit();
		}
		catch(EventException ex) {
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2103 : Copy<br>
	 * 현재 버전에 있는 정보를 삭제하고 현재 버전에 DAR History 에서 선택한 버전의 정보로 생성 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse addBeforeExceptionByHistoryCopy(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event 		event 				= (EesDmt2003Event)e;
		RFAProgressVO			rFAProgressVO		= event.getRFAProgressVO();

		try {
			rFAProgressVO.setCreUsrId(account.getUsr_id());
			rFAProgressVO.setCreOfcCd(account.getOfc_cd());
			rFAProgressVO.setUpdUsrId(account.getUsr_id());
			rFAProgressVO.setUpdOfcCd(account.getOfc_cd());
			
			begin();
			command.addBeforeExceptionByHistoryCopy(rFAProgressVO, account);
			commit();
		}
		catch(EventException ex) {
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2003 : Row Delete<br>
	 * 선택한 Before Exception Request 의 Detail 과 그 하위항목을 모두 삭제 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse removeBeforeException(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event 		event 				= (EesDmt2003Event)e;

		try {
			begin();
			command.removeBeforeException(event.getRFAProgressVO());
			commit();
		}catch(EventException ex) {
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}	
	
	
    
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	////////// START BACK END JOB AREA //////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////

	/**
	 * EES_DMT_2010 : btn_retrive<br>
	 * BACKENDJOB의 진행상태를 리턴합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBakEndJb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt2010Event event = (EesDmt2010Event)e;
		TimeClockStopMgtBC command = new TimeClockStopMgtBCImpl();
		try{
			String status = command.comBackEndJb((String)event.getAttribute("KEY"));
			eventResponse.setETCData("jb_sts_flg", status);
		}catch(EventException ex){
			log.error("comBakEndJb Error(1)====>"+ex.getMessage());
			throw ex;
		}catch(Exception ex){
			log.error("comBakEndJb Error(2)====>"+ex.getMessage());
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2010 : btn_retrive<br>
	 * Back End Job을 실행합니다.<br>
	 * doBackEndJob method
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse doBackEndJob(Event e) throws EventException {
		log.error("doBackEndJob start..........");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TimeClockStopMgtBC command = new TimeClockStopMgtBCImpl();
		try {
			begin();
			EesDmt2010Event event = (EesDmt2010Event)e;
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJob(event.getDmtTimeClockStopVO(),account));
			commit();
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		log.error("doBackEndJob end..........");
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_2010 : btn_retrive<br>
	 * Long Tx 결과 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse createTimeClockStopBackEndJob(Event e) throws EventException {
		String key = (String)e.getAttribute("KEY");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TimeClockStopMgtBC command = new TimeClockStopMgtBCImpl();
		try{
			DmtTimeClockStopVO dmtTimeClockStopVO = command.createTimeClockStopBackEndJob(key);
			Map<String, String> etcData = dmtTimeClockStopVO.getColumnValues();
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_2010 : btn_cancel<br>
	 * BACKENDJOB의 진행상태를 리턴합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comCancelBakEndJb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt2010Event event = (EesDmt2010Event)e;
		TimeClockStopMgtBC command = new TimeClockStopMgtBCImpl();

		try{
			String status = command.comCancelBakEndJb((String)event.getAttribute("KEY"));
			eventResponse.setETCData("jb_sts_flg", status);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2010 : btn_cancel<br>
	 * Back End Job을 실행합니다.<br>
	 * doCancelBackEndJob method
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse doCancelBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TimeClockStopMgtBC command = new TimeClockStopMgtBCImpl();
		try {
			begin();
			EesDmt2010Event event = (EesDmt2010Event)e;
			eventResponse.setETCData("BackEndJobKey", command.doCancelBackEndJob(event.getDmtTimeClockStopVO(),account));
			commit();
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
	 * EES_DMT_2010 : btn_cancel<br>
	 * Long Tx 결과 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse cancelTimeClockStopBackEndJob(Event e) throws EventException {
		String key = (String)e.getAttribute("KEY");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TimeClockStopMgtBC command = new TimeClockStopMgtBCImpl();
		try{
			DmtTimeClockStopVO dmtTimeClockStopVO = command.cancelTimeClockStopBackEndJob(key);
			
			Map<String, String> etcData = dmtTimeClockStopVO.getColumnValues();
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/////////////////////////////////////////////////////////////////////////////////////
	////////// END BACK END JOB AREA //////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * EES_DMT_2003 : APVL No. Change<br>
	 * Before Booking의 APVL No. 에 해당되는 APVL OFC, DAR No., Version, Status 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchRFATariffByAPVLNo(Event e) throws EventException {
		RFAProgressVO 			rFAProgressVO 	= null;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 		= new RFAExceptionTariffMgtBCImpl();
		
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			}
			
			List<RFAProgressVO> list = command.searchRFATariffByAPVLNo(rFAProgressVO);
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("APVL_OFC", list.get(0).getAproOfcCd());
				eventResponse.setETCData("DAR", list.get(0).getRfaExptDarNo());
				eventResponse.setETCData("VER", list.get(0).getRfaExptVerSeq());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;			
	}	
	
	/**
	 * EES_DMT_2005 : Approved 상태일때 Apro_no를 조회<br>
	 * Proposal No.나 DAR No. 로 Approval No.를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchAproNoByPropApprovalNo(Event e) throws EventException {
		RFAProgressVO 			rFAProgressVO 	= null;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 		= new RFAExceptionTariffMgtBCImpl();
		
		try{
			rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			
			rFAProgressVO = command.searchAproNoByPropApprovalNo(rFAProgressVO);
			
			if(rFAProgressVO != null && rFAProgressVO.getRfaExptAproNo() != null && rFAProgressVO.getRfaExptAproNo().length() > 0){
				eventResponse.setETCData("APVL_NO", rFAProgressVO.getRfaExptAproNo());
			}else{
				eventResponse.setETCData("APVL_NO", "");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
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
	private EventResponse isCustomerByPriMn(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 				= new GeneralEventResponse();
		EesDmt2001Event 				event 						= (EesDmt2001Event)e;
		SCExceptionTariffMgtBC 			command 					= new SCExceptionTariffMgtBCImpl();

		try {
			//중복된 데이터인지 조회를 실행합니다.
			boolean isDuplicate = command.isCustomerByPriMn(event.getSCExceptionParmVO());
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
	 * PRI_SP_CTRT_PTY에 동일한 Customer가 존재하는지 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDMTYardByOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		TimeClockStopMgtBC command 			= new TimeClockStopMgtBCImpl();
		EesDmt2010Event event 				= (EesDmt2010Event)e;
		try {
			List<YardByOfficeVO> list = command.searchDMTYardByOffice(event.getTimeClockStopParmVO());
			if (list != null && list.size() > 0) {

				StringBuffer yard_codes = new StringBuffer();
				StringBuffer yard_names = new StringBuffer();
				
				yard_codes.append("All").append("|");
				yard_names.append("All").append("|");
				for (int i = 0 ; i < list.size() ; i++) {
					YardByOfficeVO vo = (YardByOfficeVO)list.get(i);
					yard_codes.append(vo.getYdCd()).append("|");
					yard_names.append(vo.getYdNm()).append("|");
					
				}
				yard_codes.deleteCharAt(yard_codes.length()-1);
				yard_names.deleteCharAt(yard_names.length()-1);
			
				eventResponse.setETCData("YARD_CD", yard_codes.toString());
				eventResponse.setETCData("YARD_NM", yard_names.toString());
			}
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * 호출메뉴 : EES_DMT_2003 ( DEM/DET Adjustment Request - Before Booking Request )
	 * Auto Update 버튼 클릭시 Master RFA 의 유효한 상위버전 정보를 Basic RFA 에 Copy 합니다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse copyMstRfaVerToBzcRfaVer(Event e) throws EventException {
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 	= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event event 				= (EesDmt2003Event)e;
		RFACopyMstToBzcVO		paramVO		= event.getRFACopyMstToBzcVO();
		
		try {
			// 1. Auto Update 실행 가능한 상태인지 여부를 체크합니다.
			// 1.1) Basic RFA 인지 여부를 체크합니다.
			boolean isBzcRfa = command.isBzcRfa(paramVO.getBzcPropNo());
			if (!isBzcRfa) {
				// DMT02020 :: Basic RFA 가 아닙니다.
				throw new EventException("DMT02020");
			}
			
			// 1.2) Master RFA 의 Proposal No. 조회
			String mstPropNo = command.searchPropNoOfMstRfa(paramVO.getBzcPropNo());
			paramVO.setMstPropNo(mstPropNo);

			// 1.3) Master RFA 의 유효한 버전이 Basic RFA 보다 상위 버전인지 여부를 체크합니다.
			boolean isUpprVer = command.isUpprMstRfaVerThanBzcRfaVer(paramVO.getMstPropNo(), paramVO.getBzcPropNo());
			if (!isUpprVer) {
				// DMT02021 : 승인된 Master RFA 의 상위버전이 존재하지 않습니다.
				throw new EventException("DMT02021");
			}
			
			// 2. Copy Master RFA Version To Basic RFA New Version
			paramVO.setCreUsrId(account.getUsr_id());
			paramVO.setCreOfcCd(account.getOfc_cd());
			
			begin();
			command.copyMstRfaVerToBzcRfaVer(paramVO);
			commit();			
		} 
		catch(EventException ex) {
			throw ex;
		} 
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;			
	}

}