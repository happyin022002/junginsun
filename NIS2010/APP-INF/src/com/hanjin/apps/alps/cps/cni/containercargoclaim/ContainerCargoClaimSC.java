/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ContainerCargoClaimSC.java
 *@FileTitle : Container Cargo Claim 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.05 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
 * -------------------------------------------------------
 * History
 * 2010.10.13 이준범[CHM-201006466-01] Before Status Code 와 After Status code 가 동일해 지는 현상 수정
 * 2010.11.19 이준범[CHM-201007224-01] CNI Insurance Claim by Case화면 Save button logic 변경
 *  1) manageInsuranceRecoveryByCase() 수정
 *  - insurFmalClmDt(INS DOF) 입력 여부 체크 하여, 입력되지 않아도 Insurance Claim 정보를 저장한다
 * 2011.05.27 이준범[CHM-201111059-01] Contract of Carriage-Main 화면 ALPS Error 처리 요청 
 *  - searchContractCarriageBLGet()
 *  - HJS 밣생 B/L 이 아닐경우, BKG 정보 조회 SKIP
 * 2012.01.20 이준범[CHM-201215745-01] LP Recovering Status 관련 로직 수정
 *  - LP_Recovering 상태인 경우도 소송 관련 사항 입력시 Litigated되도록 로직 보완 
 *  -  LP_Recovering 상태 변경 기준이 현재 Formal, Litigated, Paid 상태 Claim에 LP DOF, LP Claim Amount가 입력되는 경우인데 Paid인 경우만 변경되도록 로직을 수정
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.basic.CodeMgtBC;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.basic.CodeMgtBCImpl;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.HandlerHistoryVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.MiscellaneousVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.basic.FileMgtBC;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.basic.FileMgtBCImpl;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.FileUploadCondVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.FileUploadVO;
import com.hanjin.apps.alps.cps.cni.common.CniConst;
import com.hanjin.apps.alps.cps.cni.common.CniUtil;
import com.hanjin.apps.alps.cps.cni.common.basic.CniCommonBC;
import com.hanjin.apps.alps.cps.cni.common.basic.CniCommonBCImpl;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.basic.ClaimMainBC;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.basic.ClaimMainBCImpl;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0001Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0002Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0003Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0008Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0009Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0010Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0033Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0036Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0037Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0043Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration.ClaimMainDBDAO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.BlGetVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.BookingNoVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ClaimMainCntVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ClaimMainVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniAreaOfcVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmBlDtlVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCntrDtlVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCostVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCtrtVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmLtgtVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmTrnsVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ContractCarriageVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.FindVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.HandlingCostInfoVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.HandlingCostVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.PaymentVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.TransferVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.basic.IncidentSurveyBC;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.basic.IncidentSurveyBCImpl;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.event.CpsCni0012Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.event.CpsCni0013Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.event.CpsCni0030Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.event.CpsCni0031Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.event.CpsCni0032Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmInciVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmSlvVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmSveyVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentClaimInquiryVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentCreationVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentInquiryVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.SalvageVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.SurveyVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.basic.IndemnityClaimBC;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.basic.IndemnityClaimBCImpl;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.event.CpsCni0015Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.vo.CniLiablePartyVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.vo.LiablePartyVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.basic.InsuranceRecoveryBC;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.basic.InsuranceRecoveryBCImpl;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.event.CpsCni0016Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.event.CpsCni0017Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.vo.CniCgoClmInsurVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.vo.EntryStatusVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.vo.InsuranceRecoveryByCaseVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.vo.InsuranceRecoveryByVvdVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.basic.PreventionBC;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.basic.PreventionBCImpl;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.event.CpsCni0022Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.event.CpsCni0023Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.vo.CniClmPrveVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.vo.PreventionCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.vo.PreventionInfoVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.vo.PreventionVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.basic.SettlementClaimBC;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.basic.SettlementClaimBCImpl;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.event.CpsCni0014Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.CniSettlementVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.GwApproveStatusVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.SettlementVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * CNICommon Business Logic ServiceCommand
 * Container Cargo Claim 관리
 * 
 * @author 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * @see ClaimMainDBDAO
 * @since J2EE 1.4
 */

public class ContainerCargoClaimSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	
	// 레포트 파일 구분자
	private final String SP = "|&&|";	
	private final String EOR = "//EOR//";

	/**
	 * CNICommon system 선처리 작업<br>
	 * 객체 생성
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
			
			// 사용자 Role정보 
			String roles = CniUtil.getRoles(account);	
			
			if (StringUtils.isEmpty(roles)) {
				CniCommonBC cmd = new CniCommonBCImpl();				
				CniUtil.setRoles(account, 
						cmd.searchUserRoleList(account.getUsr_id()));
				
			}		
			
			// 사용자 Area정보 취득 
			String area = CniUtil.getAreaInfo(account);	
			
			if (StringUtils.isEmpty(area)) {
				CniCommonBC cmd = new CniCommonBCImpl();				
				CniUtil.setAreaInfo(account, 
						cmd.searchUserArea(account.getOfc_cd()));				
			}		
			
			
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}
	}

	/**
	 * CNICommon system 후처리 작업<br>
	 */
	public void doEnd() {
		log.debug("ContainerCargoClaimSC 종료");
	}

	// ************************************************************************************************
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * CNICommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		// 이벤트 정보
		//2011-12-08 사용하지 않는 지역 변수를 점검한다.
		//EventResponse eventResponse = null;
		// 이벤트 명 취득
		String eventName = e.getEventName();
		//String eventName = "CpsCni9999Event";
		// Command 명 취득
		FormCommand cmd = e.getFormCommand();
        
		
		// ===========================================================================
		// 진윤오
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0001] Client Default Setup
		// ---------------------------------------------------------------------------	

		if ("CpsCni0001Event".equalsIgnoreCase(eventName)) {							
			// [Open]
			if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchClientDefaultSetupOpen(e);
			// [Save]
			} else if (cmd.isCommand(FormCommand.MULTI)) {
				return manageAreaOfc(e);
			} 
		}
		
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0016] Insurance Recovery by VVD
		// ---------------------------------------------------------------------------
		else if ("CpsCni0016Event".equalsIgnoreCase(eventName)) {							
			// [Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchInsuranceRecoveryByVvdList(e);
			// [Save]
			} else if (cmd.isCommand(FormCommand.MULTI)) {
				return manageInsuranceRecoveryByVvd(e);
		    // [Print]				
			} else if (cmd.isCommand(FormCommand.PRINT)) {
				return printInsuranceRecoveryByVvdList(e);
			}
		}

		// ---------------------------------------------------------------------------
		// [CPS_CNI_0017] Insurance Recovery by Case
		// ---------------------------------------------------------------------------	

		else if ("CpsCni0017Event".equalsIgnoreCase(eventName)) {							
			// [Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchInsuranceRecoveryByCaseInfo(e);
			// [Save]
			} else if (cmd.isCommand(FormCommand.MULTI)) {
				return manageInsuranceRecoveryByCase(e);
			// [Recovery Cancel]
			} else if (cmd.isCommand(FormCommand.MULTI01)) {
				return manageInsuranceRecoveryByCaseCancel(e);
			// [Case Close]
			} else if (cmd.isCommand(FormCommand.MULTI02)) {
				return manageInsuranceRecoveryByCaseClose(e);
			// [Recovery Open]
			} else if (cmd.isCommand(FormCommand.MULTI03)) {
				return manageInsuranceRecoveryByCaseReopen(e);
			}   
   
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0043] Impending TB Claim
		// ---------------------------------------------------------------------------
		else if ("CpsCni0043Event".equalsIgnoreCase(eventName)) {							
			// [Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchImpendingTBClaim(e);
			// [default]
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchImpendingTBClaimOpen(e);
			} 
   
		}		
		
		
		
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0022] Prevention
		// ---------------------------------------------------------------------------	
		else if ("CpsCni0022Event".equalsIgnoreCase(eventName)) {							
			// [Retrieve]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchPreventionList(e);
			// [default]
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchPreventionOpen(e);
					
			} 
   
		}		

		// ---------------------------------------------------------------------------
		// [CPS_CNI_0023] Prevention-Register ,Prevention-View
		// ---------------------------------------------------------------------------	
		else if ("CpsCni0023Event".equalsIgnoreCase(eventName)) {							
			// [Retrieve]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchPreventionInfo(e);
			// [Retrieve View]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				return searchPreventionInfoView(e);				
			// [default]
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchPreventionRegisterOpen(e);
			// [modify]
			} else if (cmd.isCommand(FormCommand.MODIFY)) {
				return modifyPrevention(e);
			// [add]
			} else if (cmd.isCommand(FormCommand.ADD)) {
				return createPrevention(e);				
			} else if (cmd.isCommand(FormCommand.PRINT)) {
				return printPrevention(e);
			// [remove]
			} else if (cmd.isCommand(FormCommand.REMOVE)) {
				return removePrevention(e);					
			} 
   
		}
		
	

		// ===========================================================================
		// 정행룡
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0003] Claim Main
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0003Event".equalsIgnoreCase(eventName)) {
			
			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				return manageClaimMain(e);
			// [Cancel]
			} else if (cmd.isCommand(FormCommand.MULTI01)) {
				return modifyClaimCancel(e);				
			// [Retrieve]
			} else if (cmd.isCommand(FormCommand.SEARCH)) {
				return searchClaimMain(e);
			// [Retrieve Miscellaneous Code Validation]	
			} else if (cmd.isCommand(FormCommand.SEARCH11)) {
				return searchMiscCodeExist(e);
			// [Retrieve Office Code Validation]	
			} else if (cmd.isCommand(FormCommand.SEARCH12)) {
				return searchMdmOrganizationExist(e);		
			// [Retrieve Incident info]
			} else if (cmd.isCommand(FormCommand.SEARCH15)) {
				return searchIncidentExist(e);
			// [Retrieve B/L Check]
			} else if (cmd.isCommand(FormCommand.SEARCH19)) {
				return searchBlGetChk(e);	
			// [Retrieve B/L info]
			} else if (cmd.isCommand(FormCommand.SEARCH20)) {
				return searchBlGet(e);
			// [Retrieve Booking No]
			} else if (cmd.isCommand(FormCommand.SEARCH18)) {
				return searchBookingNo(e);	
			// [Open]
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchClaimMainOpen(e);
			}
		}
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0033] View Claim Main
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0033Event".equalsIgnoreCase(eventName)) {
			
			if (cmd.isCommand(FormCommand.SEARCH)) {
				return searchClaimMain(e);
				// [Open]
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchClaimMainOpen(e);
			}
		}	
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0037] Claim Reopen
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0037Event".equalsIgnoreCase(eventName)) {
		    if (cmd.isCommand(FormCommand.MULTI01)) {
			   return modifyClaimReopen(e);
		    } else if (cmd.isCommand(FormCommand.SEARCH)) {
				return searchClaimMain(e);
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchClaimMainOpen(e);
			}
		}
		// ===========================================================================
		// 양정란
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0002] Find
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0002Event".equalsIgnoreCase(eventName)) {
				
			// [Retrieve , Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchFindList(e);
			// [PRINT]
			} else if (cmd.isCommand(FormCommand.PRINT)) {
				return printFind(e);
			// [Open]
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchFindOpen(e);
			}
		}
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0012] Survey
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0012Event".equalsIgnoreCase(eventName)) {
			
			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				return manageSurvey(e);
			// [Retrieve , Open]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchSurveyInfo(e);
			// [Open]
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchSurveyOpen(e);
			}
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0013] Salvage
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0013Event".equalsIgnoreCase(eventName)) {
			
			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				return manageSalvage(e);
			// [Retrieve , Open]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchSalvageInfo(e);
			} 
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0030] Incident-Creation
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0030Event".equalsIgnoreCase(eventName)) {
			
			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				return manageIncident(e);
			// [Retrieve , Open]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchIncidentCreationInfo(e);
			// [Open]
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchIncidentOpen(e);
			} else if (cmd.isCommand(FormCommand.PRINT)) {
				return printIncident(e);
			} else if (cmd.isCommand(FormCommand.SEARCH01)) {
				return searchLocation(e);
			} else if (cmd.isCommand(FormCommand.SEARCH02)) {
				return searchVesselName(e);
			}
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0031] Incident-Inquiry
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0031Event".equalsIgnoreCase(eventName)) {
			
			// [Retrieve , Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchIncidentInquiryList(e);
			// [Open]
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchIncidentInquiryOpen(e);
			// [PRINT]
			} else if (cmd.isCommand(FormCommand.PRINT)) {
				return printIncidentInquiry(e);
			} 
		}	
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0032] Incident-Claim Inquiry
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0032Event".equalsIgnoreCase(eventName)) {
			
			// [Retrieve , Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchIncidentClaimInquiryList(e);
			// [Open]
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchIncidentClaimInquiryOpen(e);
			// [PRINT]
			} else if (cmd.isCommand(FormCommand.PRINT)) {
				return printIncidentClaimInquiry(e);
			}  
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0008] Payment
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0008Event".equalsIgnoreCase(eventName)) {
				
			// [Retrieve , Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchPaymentInfo(e);
			}
			// [Save]
			else if (cmd.isCommand(FormCommand.MULTI)) {
				return managePayment(e);
			}
		}	
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0036] Transfer
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0036Event".equalsIgnoreCase(eventName)) {
				
			// [Retrieve , Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchTransferList(e);
			// [Save]
			}else if (cmd.isCommand(FormCommand.MULTI)) {
				return manageTransfer(e);	
			// [Row Search]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				return searchTrnsOfcCd(e);
			// [Row Search]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST03)) {
				return searchTrnsUsrId(e);
			// [PRINT]
			} else if (cmd.isCommand(FormCommand.PRINT)) {
				return printTransfer(e);
			// [Open]
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchTransferOpen(e);
			}
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0009] Handling Costs
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0009Event".equalsIgnoreCase(eventName)) {
				
			// [Retrieve , Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchHandlingCostList(e);
			}else if (cmd.isCommand(FormCommand.MULTI)) {
				return manageHandlingCost(e);	
			}else if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchHandlingCostOpen(e);
			}	
		} 	
		
		// ===========================================================================
		// 박제성
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0015] Indemnity Claim LiableParty
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0015Event".equalsIgnoreCase(eventName)) {
			
			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				return manageLiableParty(e);
			} else if (cmd.isCommand(FormCommand.MULTI01)) {
				return manageLiablePartyCancel(e);	
			// [Retrieve , Open]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchLiablePartyInfo(e);
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				return searchLiablePartyBookingNoInfo(e);	
			} 
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0035] View-Indemnity Claim LiableParty
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0035Event".equalsIgnoreCase(eventName)) {
		
			// [Retrieve , Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchLiablePartyInfo(e);
			} 
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0010] Contract of Carriage
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0010Event".equalsIgnoreCase(eventName)) {
			
			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				return manageContractCarriage(e);
			} else if (cmd.isCommand(FormCommand.MULTI01)) {
					return manageContractCarriageBL(e);	
			// [Retrieve , Open]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchContractCarriageInfo(e);
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				return searchClaimContainerDetailList(e);
			} else if (cmd.isCommand(FormCommand.SEARCHLIST03)) {
				return searchContractCarriageBookingNoInfo(e);
			} else if (cmd.isCommand(FormCommand.SEARCHLIST04)) {
				return searchContractCarriageBLGet(e);		
			
			} 
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0034] View-Contract of Carriage
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0034Event".equalsIgnoreCase(eventName)) {
			
			// [Retrieve , Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchContractCarriageInfo(e);
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				return searchClaimContainerDetailList(e);	
			} 
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI-0014] Settlement Claim
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0014Event".equalsIgnoreCase(eventName)) {
			
			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				return manageSettlement(e);

			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchSettlementInfo(e);
			} else if (cmd.isCommand(FormCommand.MULTI01)) {
				return manageCancel(e);	
			} else if (cmd.isCommand(FormCommand.MULTI02)) {
				return manageApplication(e);
			} else if (cmd.isCommand(FormCommand.COMMAND03)) {
				return manageGwStatus(e);				
			// [Open]
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				return searchSettlementOpen(e);
			}
			
		}
		
		
		//return eventResponse;		2011-11-18 [소스품질 조치사항]객체에 null이 배정된 이후 객체에 대한 참조를 하지 말아야 한다.
		return null;
	}

	
	
	
	// ===========================================================================
	// 진윤오
	// ===========================================================================

	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0001] Client Default Setup
	// ---------------------------------------------------------------------------	
	/**
	 * Client Default Setup open<br>
	 * @author 진윤오
	 * @category CPS_CNI_0001
	 * @category searchClientDefaultSetupOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchClientDefaultSetupOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try{
		
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			// Area List 09
			List<MiscellaneousVO> miscCodeList = command.searchMiscellaneousList("09");
			eventResponse.setRsVoList(miscCodeList);
			
			ClaimMainBC mainBc = new ClaimMainBCImpl();
			
			CniAreaOfcVO cniAreaOfcVO = mainBc.searchAreaCd(account.getOfc_cd());
			
			
			String areaCd = "";
			
			if (cniAreaOfcVO != null) {
				areaCd = cniAreaOfcVO.getClmAreaCd();
			}
				
			
			eventResponse.setCustomData("clmAreaCd", areaCd);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	

	
	/**
	 * Area Cd 정보 수정,등록<br>
	 * @author 진윤오
	 * @category CPS_CNI_0001
	 * @category manageAreaOfc 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse manageAreaOfc(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		ClaimMainBC command = new ClaimMainBCImpl();

		CpsCni0001Event event = (CpsCni0001Event)e;
				
		try {			
			begin();
			
			CniAreaOfcVO cniAreaOfcVO = new CniAreaOfcVO();			
			// event관련 사용자정보 insert
			//사용자 설정
			cniAreaOfcVO.setCreUsrId(account.getUsr_id());
			cniAreaOfcVO.setUpdUsrId(account.getUsr_id());
			cniAreaOfcVO.setOfcCd(event.getOfcCd());
			cniAreaOfcVO.setClmAreaCd(event.getClmAreaCd());	
			
			command.manageAreaOfc(cniAreaOfcVO);
			
			// 에러메세지설정
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_CNI_0016] Insurance Recovery by VVD
	// ---------------------------------------------------------------------------	
	/**
	 * VVD InsuranceRecovery정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0016
	 * @category searchInsuranceRecoveryByVvdList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInsuranceRecoveryByVvdList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try{
		
			// BC 객체 생성
			InsuranceRecoveryBC command = new InsuranceRecoveryBCImpl();
			
			CpsCni0016Event event = (CpsCni0016Event)e;
			
			String trnkRefVvdNo = event.getTrnkRefVvdNo();
			
			List<InsuranceRecoveryByVvdVO> list =
				command.searchInsuranceRecoveryByVvdList(trnkRefVvdNo);
	
			eventResponse.setRsVoList(list);
			
			if (list == null || list.isEmpty()) {			
				return eventResponse;
			}
	
			
			// ------------------------------------------
			// deductiable 조회
			// ------------------------------------------		
			// 보험정보 조회 마지막 VVD기준
			int lastIndex = list.size() - 1;
			InsuranceRecoveryByVvdVO vo = list.get(lastIndex);
			
			// DOL(선적일자)
			String lodgDt = vo.getLodgDt();
			// DOR(접수일자)
			String rctDt = vo.getRctDt();
			
			String insurPlcyYrMmDd = "";
			if (rctDt == null || rctDt.length() < 8 ) {
				if (lodgDt == null || lodgDt.length() < 8 ) {
					//msgs["CNI00104"] = "Please input either DOR or DOL";			
					eventResponse.setUserMessage(new ErrorHandler("CNI00104").getUserMessage() + " for " + vo.getCgoClmNo());
					return eventResponse;
				}
				
				insurPlcyYrMmDd = lodgDt;
				
			} else {
				insurPlcyYrMmDd = rctDt;
			}
	
			
			String insurPlcyYr = insurPlcyYrMmDd.substring(0,4);
			String mmdd = insurPlcyYrMmDd.substring(4,8);
			// 2월 20일 기준으로 보험회계년도 취득 
			// lodgDt가 20090219이면 2008년 회계년도 
			// 20090220이면 2009년 회계년도
			if ("0220".compareTo(mmdd) > 0) {
				insurPlcyYr = (Integer.parseInt(insurPlcyYr) - 1) + "";
			}
			
			String insurClmPtyNo = vo.getInsurClmPtyNo();
			String vcdCd = trnkRefVvdNo.substring(0,4);
			
			EntryStatusVO statusVo = 
				command.searchEntryStatusInfo(vcdCd, insurClmPtyNo, insurPlcyYr);
			
			if (statusVo == null) {
				//msgs["CNI00105"] = "No Deductible. Please update Insurance Entry Status!";
				eventResponse.setUserMessage(new ErrorHandler("CNI00105").getUserMessage());
				return eventResponse;
			}
			
			//전역 변수에 저장
			CniUtil.setVvd(account, trnkRefVvdNo);
			
			eventResponse.setRsVo(statusVo);	
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
		
	}		
	
	/**
	 * VVD InsuranceRecovery정보 PRINT<br>
	 * @author 진윤오
	 * @category CPS_CNI_0094
	 * @category printInsuranceRecoveryByVvdList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printInsuranceRecoveryByVvdList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
		
			// BC 객체 생성
			InsuranceRecoveryBC command = new InsuranceRecoveryBCImpl();
			
			CpsCni0016Event event = (CpsCni0016Event)e;
			
			String trnkRefVvdNo = event.getTrnkRefVvdNo();
			
			List<InsuranceRecoveryByVvdVO> list =
				command.searchInsuranceRecoveryByVvdList(trnkRefVvdNo);
			
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
		   	    
			for (int i = 0; i < list.size(); i++) {			
				InsuranceRecoveryByVvdVO vo = list.get(i);
				pw.print(vo.getDataSeq()+SP);
				pw.print(vo.getCgoClmStsCd()+SP);
				pw.print(vo.getCgoClmNo()+SP);
				pw.print(vo.getClmtUsdAmt()+SP);
				pw.print(vo.getFmalClmRcvDt()+SP);
				pw.print(vo.getCgoClmStlUsdAmt()+SP);
				pw.print(vo.getCgoClmStlDt()+SP);
				pw.print(vo.getLablPtyRcvrUsdAmt()+SP);
				pw.print(vo.getLablPtyRcvrDt()+SP);
				pw.print(vo.getRcvrUsdAmt()+SP);
				pw.print(vo.getInsurDmndUsdAmt()+SP);
				pw.print(vo.getInsurFmalClmDt()+SP);
				pw.print(vo.getInsurRcvrUsdAmt()+SP);
				pw.println(vo.getInsurRcvrDt()+SP);
			}
			
			if ( log.isDebugEnabled() ) {
				log.debug(sw.toString());
			}
			
			eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
		
	}			
	
	/**
	 * VVD InsuranceRecovery 등록 , 수정 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0016
	 * @category manageInsuranceRecoveryByVvd
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse manageInsuranceRecoveryByVvd(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		InsuranceRecoveryBC command = new InsuranceRecoveryBCImpl();
		ClaimMainBC command1 = new ClaimMainBCImpl(); 
		CodeMgtBC command2 = new CodeMgtBCImpl(); 
		
		CpsCni0016Event event = (CpsCni0016Event)e;
				
		try {			
			begin();			
			
			CniCgoClmInsurVO[] cniCgoClmInsurVOs = event.getCniCgoClmInsurVOs();
			
			CniCgoClmInsurVO vo = cniCgoClmInsurVOs[0];
			vo.setUpdUsrId(account.getUsr_id());
			vo.setCreUsrId(account.getUsr_id());
			
			command.manageInsuranceRecoveryByVvd(cniCgoClmInsurVOs);

			// --------------------------------------------------------------
			// Status 변경
			// --------------------------------------------------------------
			for (CniCgoClmInsurVO cniCgoClmInsurVO : cniCgoClmInsurVOs) {
				
				String dof = cniCgoClmInsurVO.getInsurFmalClmDt();
				//dof 존재하는 경우 
				if (!StringUtils.isEmpty(dof)) {
					//클레임 번호 취득
					String cgoClmNo = cniCgoClmInsurVO.getCgoClmNo();
					CniCgoClmVO cniCgoClmVO = new CniCgoClmVO();
					
					cniCgoClmVO.setUpdUsrId(account.getUsr_id());
					cniCgoClmVO.setCgoClmNo(cgoClmNo);
					
					String cgoClmStsCd = "I";
					cniCgoClmVO.setCgoClmStsCd(cgoClmStsCd);
					cniCgoClmVO.setCgoClmClzCd("O");
					command1.modifyClaimStatus(cniCgoClmVO);		
					
					// ---------------------------------------------
					// 상태변경 처리후  Status History에 이력정보 설정
					// ---------------------------------------------				
					HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
					handlerHistoryVO.setCgoClmNo(cgoClmNo);
					handlerHistoryVO.setUpdUsrId(account.getUsr_id());
					handlerHistoryVO.setCreUsrId(account.getUsr_id());				
					
					handlerHistoryVO.setHdlrOfcCd(account.getOfc_cd());
					handlerHistoryVO.setHdlrUsrId(account.getUsr_id());
					
					command2.manageHandlerHistory(handlerHistoryVO, cgoClmStsCd);					
					
				} 
			}
			
			
			// 에러메세지설정
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	

	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0017] Insurance Recovery by Case
	// ---------------------------------------------------------------------------	
	/**
	 * Case InsuranceRecovery정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0017
	 * @category searchInsuranceRecoveryByCaseInfo 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInsuranceRecoveryByCaseInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			InsuranceRecoveryBC command = new InsuranceRecoveryBCImpl();
			
			CpsCni0017Event event = (CpsCni0017Event)e;
			
			String cgoClmNo = event.getCgoClmNo();
			
			InsuranceRecoveryByCaseVO vo = 
				command.searchInsuranceRecoveryByCaseInfo(cgoClmNo);
			
			//전역 변수에 저장
			if (vo != null) {
				CniUtil.setCargoClaimNo(account, cgoClmNo);
			}
			
			eventResponse.setRsVo(vo);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
		
	}		
		
	/**
	 * Case InsuranceRecovery 수정 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0017
	 * @category manageInsuranceRecoveryByCase
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse manageInsuranceRecoveryByCase(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		InsuranceRecoveryBC command = new InsuranceRecoveryBCImpl();
		ClaimMainBC command1 = new ClaimMainBCImpl(); 
		CodeMgtBC command2 = new CodeMgtBCImpl(); 
		
		
		CpsCni0017Event event = (CpsCni0017Event)e;
				
		try {			
			begin();
			CniCgoClmInsurVO vo = event.getCniCgoClmInsurVO();
			vo.setUpdUsrId(account.getUsr_id());
			vo.setCreUsrId(account.getUsr_id());
			
			command.manageInsuranceRecoveryByCase(vo);
			
			String cgoClmStlUsdAmt = event.getCgoClmStlUsdAmt();			
			String lablPtyRcvrUsdAmt = event.getLablPtyRcvrUsdAmt();
			String insurFmalClmDt = vo.getInsurFmalClmDt();
			String insurRcvrDt = vo.getInsurRcvrDt();

			if ( (!StringUtils.isEmpty(cgoClmStlUsdAmt)) &&(!"".equals(insurFmalClmDt))&&(!"".equals(insurRcvrDt )) ) {
				if (StringUtils.isEmpty(lablPtyRcvrUsdAmt)) {
					lablPtyRcvrUsdAmt = "0";
				}
				
				BigDecimal cgoClmStlUsdAmtDec = new BigDecimal(cgoClmStlUsdAmt);
				
				BigDecimal insurRcvrUsdAmtDec = new BigDecimal(vo.getInsurRcvrAmt());
				
				BigDecimal lablPtyRcvrUsdAmtDec = new BigDecimal(lablPtyRcvrUsdAmt);
				
				BigDecimal sum = insurRcvrUsdAmtDec.add(lablPtyRcvrUsdAmtDec);
				// ---------------------------------------------				
				// 보상금액 <= 구상청구금액 + 보험청구금액
				// 1. Settled Amount USD = < (INS Recovered Amount USD + LP Recovered Amount USD) 인경우 
				//       Status가 INS Recovering -> Case Closed로 바뀌면서 Save된다. 
				//       즉 한 건의 claim이 완전 종결된다.
				// 2. 상기"1."이외의 경우 Satuas INS Recovering (OI)상태로 변경 
				// 3. 상태변경 처리후  Status History에 이력정보 설정
				// ---------------------------------------------
				
				//클레임 번호 취득
				String cgoClmNo = vo.getCgoClmNo();
				CniCgoClmVO cniCgoClmVO = new CniCgoClmVO();
				
				cniCgoClmVO.setUpdUsrId(account.getUsr_id());
				cniCgoClmVO.setCgoClmNo(cgoClmNo);
				
				String cgoClmStsCd = "";
				if (cgoClmStlUsdAmtDec.compareTo(sum) <= 0) {
					cgoClmStsCd = "C";
					cniCgoClmVO.setCgoClmStsCd(cgoClmStsCd);					
					cniCgoClmVO.setCgoClmClzCd("C");
				} else {				
					cgoClmStsCd = "I";
					cniCgoClmVO.setCgoClmStsCd(cgoClmStsCd);
					cniCgoClmVO.setCgoClmClzCd("O");			
				}
				
				command1.modifyClaimStatus(cniCgoClmVO);
				
				// ---------------------------------------------
				// 상태변경 처리후  Status History에 이력정보 설정
				// ---------------------------------------------			
				InsuranceRecoveryByCaseVO insuranceVo = 
					command.searchInsuranceRecoveryByCaseInfo(cgoClmNo);				
				HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
				handlerHistoryVO.setCgoClmNo(cgoClmNo);
				handlerHistoryVO.setUpdUsrId(account.getUsr_id());
				handlerHistoryVO.setCreUsrId(account.getUsr_id());				
				
				handlerHistoryVO.setHdlrOfcCd(insuranceVo.getHdlrOfcCd());
				handlerHistoryVO.setHdlrUsrId(insuranceVo.getHdlrUsrId());
				
				command2.manageHandlerHistory(handlerHistoryVO, cgoClmStsCd);
				
				
			}

			// 에러메세지설정
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}		
	
	

	
	/**
	 * Case InsuranceRecovery Recovery Cancel <br>
	 * Status “LP Recovering”이 “Paid”변경후
	 * INS Claimed Amount, INS DOF, R.O.E, USD 삭제
	 * @author 진윤오
	 * @category CPS_CNI_0017
	 * @category manageInsuranceRecoveryByCaseCancel
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse manageInsuranceRecoveryByCaseCancel(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		InsuranceRecoveryBC command = new InsuranceRecoveryBCImpl();
		ClaimMainBC command1 = new ClaimMainBCImpl(); 
		CodeMgtBC command2 = new CodeMgtBCImpl(); 		
		
		CpsCni0017Event event = (CpsCni0017Event)e;
				
		try {			
			begin();
			String cgoClmNo = event.getCniCgoClmInsurVO().getCgoClmNo();
			
			// ---------------------------------------------
			// INS Claimed Amount, INS DOF, R.O.E, USD 삭제
			// ---------------------------------------------
			String updUsrId = account.getUsr_id();
			command.manageInsuranceRecoveryCancel(cgoClmNo, updUsrId);
			
			// ---------------------------------------------
			//  Status "P" 로 변경
			// ---------------------------------------------
			CniCgoClmVO cniCgoClmVO = new CniCgoClmVO();
			
			cniCgoClmVO.setUpdUsrId(account.getUsr_id());
			cniCgoClmVO.setCgoClmNo(cgoClmNo);
			
			cniCgoClmVO.setCgoClmStsCd("P");					
			cniCgoClmVO.setCgoClmClzCd("O");
			
			command1.modifyClaimStatus(cniCgoClmVO);
			
			// ---------------------------------------------
			// 상태변경 처리후  Status History에 이력정보 설정
			// ---------------------------------------------	
			InsuranceRecoveryByCaseVO vo = 
				command.searchInsuranceRecoveryByCaseInfo(cgoClmNo);
			
			HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
			handlerHistoryVO.setCgoClmNo(cgoClmNo);
			handlerHistoryVO.setUpdUsrId(account.getUsr_id());
			handlerHistoryVO.setCreUsrId(account.getUsr_id());			
			
			handlerHistoryVO.setHdlrOfcCd(vo.getHdlrOfcCd());
			handlerHistoryVO.setHdlrUsrId(vo.getHdlrUsrId());
			//신규 status 취득
			String status = command1.searchClaimStatus(cgoClmNo);
			command2.manageHandlerHistory(handlerHistoryVO, status);
			
			// 에러메세지설정
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}				
	
	
	
	/**
	 * Case InsuranceRecovery Case Close <br>
	 * @author 진윤오
	 * @category CPS_CNI_0017
	 * @category manageInsuranceRecoveryByCaseClose
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse manageInsuranceRecoveryByCaseClose(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성		
		ClaimMainBC command1 = new ClaimMainBCImpl(); 
		CodeMgtBC command2 = new CodeMgtBCImpl(); 		
		InsuranceRecoveryBC command = new InsuranceRecoveryBCImpl();
		
		CpsCni0017Event event = (CpsCni0017Event)e;
				
		try {			
			begin();
			CniCgoClmInsurVO vo = event.getCniCgoClmInsurVO();
			vo.setUpdUsrId(account.getUsr_id());
			vo.setCreUsrId(account.getUsr_id());
			
				
			//클레임 번호 취득
			String cgoClmNo = vo.getCgoClmNo();
			CniCgoClmVO cniCgoClmVO = new CniCgoClmVO();
			
			cniCgoClmVO.setUpdUsrId(account.getUsr_id());
			cniCgoClmVO.setCgoClmNo(cgoClmNo);
			
			String cgoClmStsCd = "C";
			cniCgoClmVO.setCgoClmStsCd(cgoClmStsCd);
			cniCgoClmVO.setCgoClmClzCd("C");
			
			command1.modifyClaimStatus(cniCgoClmVO);
			
			// ---------------------------------------------
			// 상태변경 처리후  Status History에 이력정보 설정
			// ---------------------------------------------
			InsuranceRecoveryByCaseVO insuranceVo = 
				command.searchInsuranceRecoveryByCaseInfo(cgoClmNo);
			
			HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
			handlerHistoryVO.setCgoClmNo(cgoClmNo);
			handlerHistoryVO.setUpdUsrId(account.getUsr_id());
			handlerHistoryVO.setCreUsrId(account.getUsr_id());				
			handlerHistoryVO.setCgoClmStsCd(cgoClmStsCd);
			handlerHistoryVO.setHdlrOfcCd(insuranceVo.getHdlrOfcCd());
			handlerHistoryVO.setHdlrUsrId(insuranceVo.getHdlrUsrId());
			
			command2.manageHandlerHistory(handlerHistoryVO, cgoClmStsCd);
			
			// 에러메세지설정
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}			
	
	
	/**
	 * Case InsuranceRecovery Reopen (Recovery Open) <br>
	 * Status “Case Closed”가 “Paid”로 환원된다.
	 * @author 진윤오
	 * @category CPS_CNI_0017
	 * @category manageInsuranceRecoveryByCaseReopen
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse manageInsuranceRecoveryByCaseReopen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성		
		ClaimMainBC command1 = new ClaimMainBCImpl(); 
		CodeMgtBC command2 = new CodeMgtBCImpl(); 
		InsuranceRecoveryBC command = new InsuranceRecoveryBCImpl();
		
		
		CpsCni0017Event event = (CpsCni0017Event)e;
				
		try {			
			begin();
			
			String cgoClmNo = event.getCniCgoClmInsurVO().getCgoClmNo();
			
			
			// ---------------------------------------------
			// Status 변경
			// ---------------------------------------------
			command1.modifyClaimPreStatus(cgoClmNo, account.getUsr_id());			
			
			// ---------------------------------------------
			// 상태변경 처리후  Status History에 이력정보 설정
			// ---------------------------------------------		
			InsuranceRecoveryByCaseVO insuranceVo = 
				command.searchInsuranceRecoveryByCaseInfo(cgoClmNo);			
			HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
			handlerHistoryVO.setCgoClmNo(cgoClmNo);
			handlerHistoryVO.setUpdUsrId(account.getUsr_id());
			handlerHistoryVO.setCreUsrId(account.getUsr_id());				
			
			handlerHistoryVO.setHdlrOfcCd(insuranceVo.getHdlrOfcCd());
			handlerHistoryVO.setHdlrUsrId(insuranceVo.getHdlrUsrId());
			//신규 status 취득
			String status = command1.searchClaimStatus(cgoClmNo);
			command2.manageHandlerHistory(handlerHistoryVO, status);

			// 에러메세지설정
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}				
	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0043] Impending TB Claim
	// ---------------------------------------------------------------------------	
	/**
	 * Impending TB Claim 취득<br>
	 * @author 진윤오
	 * @category CPS_CNI_0043
	 * @category searchImpendingTBClaim 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImpendingTBClaim(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
		
			// BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
			
			CpsCni0043Event event = (CpsCni0043Event)e;
			
			String condFor = event.getCondFor();
			String usrId = account.getUsr_id();
			
			eventResponse.setRsVoList(command.searchImpendingTBMainClaimList(usrId, condFor));
			eventResponse.setRsVoList(command.searchImpendingTBIndemnityClaimList(usrId, condFor));
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * Impending TB Claim<br>
	 * @author 진윤오
	 * @category CPS_CNI_0043
	 * @category searchImpendingTBClaimOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImpendingTBClaimOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			String currDt = command.searchGmtDate(account.getUsr_id());
			eventResponse.setCustomData("curr_dt", currDt);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}		
	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0022] Prevention
	// ---------------------------------------------------------------------------	
	/**
	 * Prevention open<br>
	 * @author 진윤오
	 * @category CPS_CNI_0022
	 * @category searchPreventionOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreventionOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
	
			// Prevention Class List 
			List<MiscellaneousVO> classList = command.searchMiscellaneousList("37");
			eventResponse.setRsVoList(classList);
			
			
			// Area List 09
			List<MiscellaneousVO> miscCodeList = command.searchMiscellaneousList("09");
			eventResponse.setRsVoList(miscCodeList);
			
			
			
			String cre_dt_end = command.searchGmtDate(account.getUsr_id());
			
			Calendar cal = Calendar.getInstance();
			
			String[] date = cre_dt_end.split("\\-");
			
			
			int year = Integer.parseInt(date[0]);
			int month = Integer.parseInt(date[1]) - 1;
			int dd = Integer.parseInt(date[2]);
			
			cal.set(year, month, dd);
			
			cal.add(Calendar.MONTH, -1);
			
			log.debug(cal.toString());
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd"); 
			      		
			String cre_dt_start =sdf.format(cal.getTime());
			
			
			eventResponse.setCustomData("cre_dt_start", cre_dt_start);
			eventResponse.setCustomData("cre_dt_end", cre_dt_end);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	
	/**
	 * Prevention open<br>
	 * @author 진윤오
	 * @category CPS_CNI_0022
	 * @category searchPreventionList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreventionList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try{
		
			// BC 객체 생성
			PreventionBC command = new PreventionBCImpl();
			
			CpsCni0022Event event = (CpsCni0022Event)e;
			
			PreventionCondVO condVo = event.getPreventionCondVO();
			
			//현재일 설정
			CodeMgtBC codeMgtBC = new CodeMgtBCImpl();
			String yyyymmdd = codeMgtBC.searchGmtDate(account.getUsr_id());		
			condVo.setCurDt(yyyymmdd);
			
			List<PreventionVO> listVo = command.searchPreventionList(condVo);
			
			eventResponse.setRsVoList(listVo);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}		
		
		return eventResponse;
	}	
		
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0023] Prevention-Register
	// ---------------------------------------------------------------------------	
	/**
	 * Prevention-Register open<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category searchPreventionRegisterOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreventionRegisterOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			ClaimMainBC command1 = new ClaimMainBCImpl();
			// Prevention Class List 
			List<MiscellaneousVO> classList = command.searchMiscellaneousList("37");
			
			classList.remove(0);		
			
			eventResponse.setRsVoList(classList);
			
			String effDt = command.searchGmtDate(account.getUsr_id());
			
			CniAreaOfcVO cniAreaOfcVO = command1.searchAreaCd(account.getOfc_cd());
			
			
			eventResponse.setCustomData("clm_area_cd", cniAreaOfcVO.getClmAreaCd());
			eventResponse.setCustomData("eff_dt", effDt);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	
	/**
	 * Prevention 정보 조회 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category searchPreventionInfo 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreventionInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			PreventionBC command = new PreventionBCImpl();
			
			CpsCni0023Event event = (CpsCni0023Event)e;
			String clmPrveNo =  event.getCniClmPrveVO().getClmPrveNo();		
			PreventionInfoVO vo = command.searchPreventionInfo(clmPrveNo);		
			eventResponse.setRsVo(vo);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}			

	/**
	 * Prevention 정보 조회 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category searchPreventionInfoView 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreventionInfoView(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			PreventionBC command = new PreventionBCImpl();
			
			CpsCni0023Event event = (CpsCni0023Event)e;
			String clmPrveNo =  event.getCniClmPrveVO().getClmPrveNo();		
			PreventionInfoVO vo = command.searchPreventionInfo(clmPrveNo);		
			eventResponse.setRsVo(vo);
			
			
			//파일 다운로드
			// BC 객체 생성
			FileMgtBC fileCmd = new FileMgtBCImpl();
			
			FileUploadCondVO fileUploadCondVO = new FileUploadCondVO();
			
			fileUploadCondVO.setClmFileTpCd("002301");
			fileUploadCondVO.setCgoClmRefNo(clmPrveNo);
			
			List<FileUploadVO> list = 
				fileCmd.searchFileUploadList(fileUploadCondVO);			
			
			eventResponse.setRsVoList(list);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}		
	
	/**
	 * Prevention 추가 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category searchPreventionInfo 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createPrevention(Event e) throws EventException {

		
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		PreventionBC command = new PreventionBCImpl();
		
		CpsCni0023Event event = (CpsCni0023Event)e;
		CniClmPrveVO clmPrveVO = event.getCniClmPrveVO();
		try {			
			
			begin();				
			
			String maxClmPrveNo = command.searchMaxClmPrevNo();
			
			//현재일 설정
			CodeMgtBC codeMgtBC = new CodeMgtBCImpl();
			String yyyymmdd = codeMgtBC.searchGmtDate(account.getUsr_id());
			
			String clmPrveNo = "PRV" + yyyymmdd.substring(0,4);
			
			if (StringUtils.isEmpty(maxClmPrveNo)) {
				clmPrveNo = clmPrveNo + "0001";
			} else {
				maxClmPrveNo = maxClmPrveNo.substring(7);				
				int no = Integer.parseInt(maxClmPrveNo) + 1;
				DecimalFormat formatter = new DecimalFormat("0000");
	        	clmPrveNo = clmPrveNo + formatter.format(no);
			}
			
			clmPrveVO.setClmPrveNo(clmPrveNo);			
			clmPrveVO.setCreUsrId(account.getUsr_id());
			clmPrveVO.setUpdUsrId(account.getUsr_id());
			
			command.createPrevention(clmPrveVO);
			
			commit();
			
			//생성되거나 조회된 Claim 번호를 화면으로 전송
			eventResponse.setETCData("clm_prve_no", clmPrveNo);
			
			//성공메세지 
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		
		return eventResponse;
	}			
	
	/**
	 * Prevention 수정 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category modifyPrevention 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPrevention(Event e) throws EventException {

		
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		PreventionBC command = new PreventionBCImpl();
		
		CpsCni0023Event event = (CpsCni0023Event)e;
		CniClmPrveVO clmPrveVO = event.getCniClmPrveVO();
		try {			
			
			begin();				
				
			clmPrveVO.setUpdUsrId(account.getUsr_id());
			
			command.modifyPrevention(clmPrveVO);
			
			commit();
			
			//성공메세지 
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		
		return eventResponse;
	}				
	
	/**
	 * Prevention 삭제 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category removePrevention 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removePrevention(Event e) throws EventException {

		
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		PreventionBC command = new PreventionBCImpl();
		
		CpsCni0023Event event = (CpsCni0023Event)e;
		CniClmPrveVO clmPrveVO = event.getCniClmPrveVO();
		
		try {			
			
			begin();				
				
			clmPrveVO.setUpdUsrId(account.getUsr_id());
			
			command.removePrevention(clmPrveVO.getClmPrveNo());
			
			commit();
			
			//msgs["CNI00010"] = "Data was deleted successfully.";
			//성공메세지 
			eventResponse.setUserMessage(new ErrorHandler("CNI00010").getUserMessage());
			
			
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		
		return eventResponse;
	}		
	
	
	/**
	 * Prevention 프린트<br>
	 * @author 진윤오
	 * @category CPS_CNI_0093
	 * @category printPrevention 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printPrevention(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			PreventionBC command = new PreventionBCImpl();
	
			CpsCni0023Event event = (CpsCni0023Event)e;
			
			// param	
			String clmPrveNo =  event.getCniClmPrveVO().getClmPrveNo();		
			PreventionInfoVO vo = command.searchPreventionInfo(clmPrveNo);	
			
			if (vo == null) {
				eventResponse.setCustomData(CniConst.RD, "");
				return eventResponse;
			}
			
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
		    
		    String desc = "";
			
			//------------------- 주 쿼리 생성 -------------------//
			pw.println(vo.getClmPrveNo()+SP); 
			//------------------- 1 SubPage -------------------//
			pw.print(vo.getClmPrveNo() +SP);
			pw.print(vo.getClmPrveDivCd()+SP);
			pw.print(vo.getClmPrveDivNm() +SP);
			pw.print(vo.getEffDt() +SP);
			
			
			int effYyyy = new Integer(vo.getEffDt().substring(0,4)).intValue();
			int expYyyy = new Integer(vo.getExpDt().substring(0,4)).intValue();
			
			int diff = expYyyy - effYyyy ;
			String expDtStr = "";
			if (diff == 1) {
				expDtStr = "1 year";
			} else if(diff == 3) {
				expDtStr = "3 year";
			} else if(diff == 5) {
				expDtStr = "5 year";
			} else if(diff == 10) {
				expDtStr = "10 year";
			} else {
				expDtStr = "permanent";
			}
			
			pw.print(expDtStr+SP); 
			
			pw.print(vo.getCreUsrId() +SP);
			pw.print(vo.getCreOfcCd() +SP);
			pw.print(vo.getClmPrveSubjNm() +SP);		
			pw.println(vo.getCreDt() +SP);
			pw.println(vo.getClmPrveReadKnt() +SP);
			pw.println(vo.getClmAreaCd() +SP);
			
		    desc = vo.getClmPrveDesc();   
		    if (desc != null) {
			   desc = desc.replaceAll("\r\n", "crlf");
		    } else {
			   desc = "";
		    }
		    pw.println(EOR); // SubPage 1
		    pw.println(desc +SP);// SubPage2
			
			eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}		
	
	
	// ===========================================================================
	// 정행룡
	// ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0003] Claim Main
	// ---------------------------------------------------------------------------
	/**
	 * Claim Main 정보 수정 ,입력<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category manageClaimMain 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageClaimMain(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// Claim Main BC 객체 생성
		ClaimMainBC claimMainBC = new ClaimMainBCImpl();
		
		// Incident Survey BC 객체 생성
		IncidentSurveyBC incidentSurveyBC = new IncidentSurveyBCImpl();
		
		// Insurance Recovery BC 객체생성
		InsuranceRecoveryBC insuranceRecoveryBC = new InsuranceRecoveryBCImpl();
		
		// CodeMgt BC 객체생성
		CodeMgtBC codeMgtBC = new CodeMgtBCImpl();
		
		CpsCni0003Event event = (CpsCni0003Event)e;
				
		try {			
			begin();
			
			ClaimMainCntVO claimMainCntVO = event.getClaimMainCntVO();
			
			HandlerHistoryVO handlerHistoryVO = event.getHandlerHistoryVO();
			
			CniCgoClmVO cniCgoClmVO = claimMainCntVO.getCniCgoClmVO();
			CniCgoClmSveyVO cniCgoClmSveyVO = claimMainCntVO.getCniCgoClmSveyVO();
			CniCgoClmLtgtVO cniCgoClmLtgtVO = claimMainCntVO.getCniCgoClmLtgtVO();
			CniCgoClmCtrtVO cniCgoClmCtrtVO = claimMainCntVO.getCniCgoClmCtrtVO();
			CniCgoClmBlDtlVO cniCgoClmBlDtlVO = claimMainCntVO.getCniCgoClmBlDtlVO();
			CniCgoClmInciVO cniCgoClmInciVO = claimMainCntVO.getCniCgoClmInciVO();
			CniCgoClmInsurVO cniCgoClmInsurVO = claimMainCntVO.getCniCgoClmInsurVO();
			CniCgoClmTrnsVO cniCgoClmTrnsVO = claimMainCntVO.getCniCgoClmTrnsVO();
			
			
			// 사용자 정보설정
			String usrId = account.getUsr_id();
			String ofcCd = account.getOfc_cd();
			
			// 각 VO에 사용자 정보를 셋팅
			cniCgoClmVO.setCreUsrId(usrId);
			cniCgoClmVO.setUpdUsrId(usrId);
			cniCgoClmSveyVO.setCreUsrId(usrId);
			cniCgoClmSveyVO.setUpdUsrId(usrId);
			cniCgoClmLtgtVO.setCreUsrId(usrId);
			cniCgoClmLtgtVO.setUpdUsrId(usrId);
			cniCgoClmCtrtVO.setCreUsrId(usrId);
			cniCgoClmCtrtVO.setUpdUsrId(usrId);
			cniCgoClmBlDtlVO.setCreUsrId(usrId);
			cniCgoClmBlDtlVO.setUpdUsrId(usrId);
			cniCgoClmInsurVO.setCreUsrId(usrId);
			cniCgoClmInsurVO.setUpdUsrId(usrId);
			cniCgoClmInciVO.setCreUsrId(usrId);
			cniCgoClmInciVO.setUpdUsrId(usrId);
			cniCgoClmTrnsVO.setCreUsrId(usrId);
			cniCgoClmTrnsVO.setUpdUsrId(usrId);
			cniCgoClmTrnsVO.setTrnsOfcCd(ofcCd);//Office Cd 저장
			
			handlerHistoryVO.setCreUsrId(usrId);
			handlerHistoryVO.setUpdUsrId(usrId);

			String beforeCgoClmStsCd = cniCgoClmVO.getCgoClmStsCd();
			String bfrCgoClmStsCd    = cniCgoClmVO.getBfrCgoClmStsCd();
			String prlmClmNtcDt      = cniCgoClmVO.getPrlmClmNtcDt();
			String fmalClmRcvOfcCd   = cniCgoClmVO.getFmalClmRcvOfcCd();
			String fmalClmRcvDt      = cniCgoClmVO.getFmalClmRcvDt();
			String smnsSveDt         = cniCgoClmLtgtVO.getSmnsSveDt();
			
			String cgoClmClzCd    = cniCgoClmVO.getCgoClmClzCd();
			String preCgoClmClzCd    = cniCgoClmVO.getPreCgoClmClzCd();
			
			String afterCgoClmStsCd = beforeCgoClmStsCd;
			
			log.debug("beforeCgoClmStsCd=[" + beforeCgoClmStsCd + "]" );
			log.debug("prlmClmNtcDt=[" + prlmClmNtcDt+ "]");
			log.debug("fmalClmRcvOfcCd=[" + fmalClmRcvOfcCd+ "]");
			log.debug("fmalClmRcvDt=[" + fmalClmRcvDt+ "]");
			log.debug("smnsSveDt=[" + smnsSveDt + "]");
			
			
			//상태값 처리로직 
			if ( beforeCgoClmStsCd.equals("") || beforeCgoClmStsCd.equals("N") || beforeCgoClmStsCd.equals("F")|| beforeCgoClmStsCd.equals("L")) {
			    if ((!"".equals(prlmClmNtcDt)) && (("".equals(fmalClmRcvOfcCd)) && ("".equals(fmalClmRcvDt)) && ("".equals(smnsSveDt)))) {
				   afterCgoClmStsCd = "N";
			    } else if (((!"".equals(fmalClmRcvOfcCd)) && (!"".equals(fmalClmRcvDt)))&& "".equals(smnsSveDt)) {
			    	afterCgoClmStsCd = "F";
			    } else if ((!"".equals(fmalClmRcvOfcCd)) && (!"".equals(fmalClmRcvDt)) && (!"".equals(smnsSveDt)) ) {
			    	afterCgoClmStsCd = "L";
			    }
			    preCgoClmClzCd = cniCgoClmVO.getCgoClmClzCd();
			}

			//cniCgoClmVO.setCgoClmStsCd(afterCgoClmStsCd);
			if (!beforeCgoClmStsCd.equals(afterCgoClmStsCd)){
				cniCgoClmVO.setBfrCgoClmStsCd(beforeCgoClmStsCd);
			} else {
				cniCgoClmVO.setBfrCgoClmStsCd(bfrCgoClmStsCd);
			}
			cniCgoClmVO.setCgoClmStsCd(afterCgoClmStsCd);
			cniCgoClmVO.setCgoClmClzCd(cgoClmClzCd);
			cniCgoClmVO.setPreCgoClmClzCd(preCgoClmClzCd);
			
			log.debug("afterCgoClmStsCd=[" + afterCgoClmStsCd + "]");
			// ClaimMainCntVO에 각 해당VO를 다시 셋팅함
			//====================================================
			claimMainCntVO.setCniCgoClmVO(cniCgoClmVO);
			claimMainCntVO.setCniCgoClmSveyVO(cniCgoClmSveyVO);
			claimMainCntVO.setCniCgoClmLtgtVO(cniCgoClmLtgtVO);
			claimMainCntVO.setCniCgoClmCtrtVO(cniCgoClmCtrtVO);
			claimMainCntVO.setCniCgoClmBlDtlVO(cniCgoClmBlDtlVO);
			claimMainCntVO.setCniCgoClmInsurVO(cniCgoClmInsurVO);
			claimMainCntVO.setCniCgoClmInciVO(cniCgoClmInciVO);
			claimMainCntVO.setCniCgoClmTrnsVO(cniCgoClmTrnsVO);
			//====================================================
			
			// 처리 절차 
			// 1. CNI_CGO_CLM, CNI_CGO_LTGT, CNI_CGO_CTRT, CNI_CGO_CLM_BI_DTL 등록 /수정 처리, Transfer 변경 체크 
			claimMainCntVO = claimMainBC.manageClaimMain(claimMainCntVO);
			
			// 2. 이전상태코드와 이후상태코드가 다르면 HandlerHistory에 저장			
			if (!beforeCgoClmStsCd.equals(afterCgoClmStsCd)){
				handlerHistoryVO.setCgoClmNo(claimMainCntVO.getCniCgoClmVO().getCgoClmNo());
				codeMgtBC.manageHandlerHistory(handlerHistoryVO, afterCgoClmStsCd);
			}
			
			//새로 생성시 Claim 번호를 셋팅함. 
			cniCgoClmSveyVO.setCgoClmNo(claimMainCntVO.getCniCgoClmVO().getCgoClmNo());
            // 3. CNI_CGO_CLM_SVEY 등록 or 수정처리			
			incidentSurveyBC.manageClaimMainSurvey(cniCgoClmSveyVO);
			
			// 4. CNI_CGO_CLM_INSUR(Insurance 등록 or 수정)
			//Claim 번호 셋팅 
			cniCgoClmInsurVO.setCgoClmNo(claimMainCntVO.getCniCgoClmVO().getCgoClmNo());
			insuranceRecoveryBC.manageClaimMainInsurance(cniCgoClmInsurVO);
			
			commit();
			
			//생성되거나 조회된 Claim 번호를 화면으로 전송
			eventResponse.setETCData("CGO_CLM_NO", claimMainCntVO.getCniCgoClmVO().getCgoClmNo());
			//성공메세지 
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Claim Main 정보 Cancel<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyClaimCancel 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyClaimCancel(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// Claim Main BC 객체 생성
		ClaimMainBC command = new ClaimMainBCImpl();
		
		CodeMgtBC command3 = new CodeMgtBCImpl();
		
		CpsCni0003Event event = (CpsCni0003Event)e;
				
		try {			
			begin();
			
			ClaimMainCntVO claimMainCntVO = event.getClaimMainCntVO();
			
			HandlerHistoryVO handlerHistoryVO = event.getHandlerHistoryVO();
			
			CniCgoClmVO cniCgoClmVO = claimMainCntVO.getCniCgoClmVO();
			
			// event관련 사용자정보 insert
			// 사용자 설정
			String usrId = account.getUsr_id();
			
			// [1. Handler History(CNI_CGO_CLM_HDLR_HIS)에 수정하고 추가 등록함]
			handlerHistoryVO.setCreUsrId(usrId);
			handlerHistoryVO.setUpdUsrId(usrId);
			
			//나중확인 필요
			//handlerHistoryVO.setHdlrUsrId(usrId);
			//handlerHistoryVO.setHdlrOfcCd(ofcCd);
			
			
         	handlerHistoryVO.setCgoClmHisTpCd("T");	//Transfer 상태로 변경함	
         	// Handler History 수정함
			command3.modifyHandlerHistory(handlerHistoryVO);
			//수정 후 최종 History 추가-------------------------------
			String cancelClmStsCd = "X"; //Cancel 상태코드로 변경함
			handlerHistoryVO.setCgoClmStsCd(cancelClmStsCd);
			command3.addHandlerHistory(handlerHistoryVO);
			//-----------------------------------------------------
			
			// [2. Claim Main(CNI_CGO_CLM)을 수정함]
			cniCgoClmVO.setCreUsrId(usrId);
			cniCgoClmVO.setUpdUsrId(usrId);
			cniCgoClmVO.setBfrCgoClmStsCd(cniCgoClmVO.getCgoClmStsCd());
			cniCgoClmVO.setCgoClmStsCd(cancelClmStsCd);
			cniCgoClmVO.setPreCgoClmClzCd(cniCgoClmVO.getCgoClmClzCd());
			cniCgoClmVO.setCgoClmClzCd(cancelClmStsCd);
						
			command.modifyClaimStatus(cniCgoClmVO);
	        //---------------------------------------------------------------		
			commit();
			
			//생성되거나 조회된 Claim 번호를 화면으로 전송
			eventResponse.setETCData("CGO_CLM_NO", claimMainCntVO.getCniCgoClmVO().getCgoClmNo());
			//성공 메시지
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Claim Main 정보 Reopen<br>
	 * @author 정행룡
	 * @category CPS_CNI_0037
	 * @category modifyClaimReopen
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyClaimReopen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// Claim Main BC 객체 생성
		ClaimMainBC command = new ClaimMainBCImpl();
		
		CodeMgtBC command3 = new CodeMgtBCImpl();
		
		SettlementClaimBC command4 = new SettlementClaimBCImpl();
		
		CpsCni0037Event event = (CpsCni0037Event)e;
				
		try {			
			begin();
			
			// event관련 사용자정보 insert
			// 사용자 설정
			String usrId = account.getUsr_id();
			
			HandlerHistoryVO handlerHistoryVO = event.getHandlerHistoryVO();
			
			CniCgoClmVO cniCgoClmVO = event.getCniCgoClmVO();
			cniCgoClmVO.setUpdUsrId(usrId); //사용자 정보 셋팅
			
			String cgoClmStlTpCd = event.getCgoClmStlTpCd();
			String smnsSveDt     = event.getSmnsSveDt();
			
			// [1. Handler History(CNI_CGO_CLM_HDLR_HIS)에 수정하고 추가 등록함]
			handlerHistoryVO.setCreUsrId(usrId);
			handlerHistoryVO.setUpdUsrId(usrId);
			
         	handlerHistoryVO.setCgoClmHisTpCd("T");	//Transfer 상태로 변경함	
         	// Handler History 수정함
			command3.modifyHandlerHistory(handlerHistoryVO);
			
			String beforeCgoClmStsCd = cniCgoClmVO.getCgoClmStsCd();
			String prlmClmNtcDt      = cniCgoClmVO.getPrlmClmNtcDt();
			String fmalClmRcvOfcCd   = cniCgoClmVO.getFmalClmRcvOfcCd();
			String fmalClmRcvDt      = cniCgoClmVO.getFmalClmRcvDt();
			
			String afterCgoClmStsCd = beforeCgoClmStsCd;

			//-----------------------------------------------------
			// [2. Claim Main(CNI_CGO_CLM)을 수정함]
			// Reopen 처리
			//CGO_CLM_STL_TP_CD 코드 체크 
			log.debug("cgoClmStlTpCd=" + cgoClmStlTpCd);
			if (cgoClmStlTpCd.equals("RP") || cgoClmStlTpCd.equals("TD") || cgoClmStlTpCd.equals("TB") || cgoClmStlTpCd.equals("WD") || cgoClmStlTpCd.equals("DS")) {
				if ((!"".equals(fmalClmRcvOfcCd)) && (!"".equals(fmalClmRcvDt)) && (!"".equals(smnsSveDt)) ) {
			    	afterCgoClmStsCd = "L";
				} else if (((!"".equals(fmalClmRcvOfcCd)) && (!"".equals(fmalClmRcvDt)))&& "".equals(smnsSveDt)) {
				    afterCgoClmStsCd = "F";
			    } else if ((!"".equals(prlmClmNtcDt)) && (("".equals(fmalClmRcvOfcCd)) && ("".equals(fmalClmRcvDt)) && ("".equals(smnsSveDt)))) {
				   afterCgoClmStsCd = "N";
			    } 
				handlerHistoryVO.setCgoClmStsCd(afterCgoClmStsCd);
				cniCgoClmVO.setCgoClmClzCd("O");
				cniCgoClmVO.setCgoClmStsCd(afterCgoClmStsCd); //처리 로직에 의한 상태코드 변경
				command.modifyClaimStatus(cniCgoClmVO);
				command4.modifyReOpenSettlement(cniCgoClmVO.getCgoClmNo(), usrId); //Settlement 값 처리 
			} else {
				command.modifyClaimPreStatus(cniCgoClmVO.getCgoClmNo(), usrId);	 //이전 상태로 상태코드 변경
				handlerHistoryVO.setCgoClmStsCd(cniCgoClmVO.getBfrCgoClmStsCd());//이전 상태코드로 변경함
	       	}
			//수정 후 최종 History 추가-------------------------------
			command3.addHandlerHistory(handlerHistoryVO);
			command.modifyClaimReOpen(cniCgoClmVO.getCgoClmNo(), usrId, cgoClmStlTpCd); //ReOpen 컬럼 변경		
			
			commit();
			
			//생성되거나 조회된 Claim 번호를 화면으로 전송
			eventResponse.setETCData("CGO_CLM_NO", cniCgoClmVO.getCgoClmNo());
			
			//성공 메시지
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Cargo Claim  Main 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchClaimMain 
	 * @param Event e  
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchClaimMain(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try {
			// BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
			String eventName = e.getEventName();
			
			String cgoClmNo =  "";
			
			if ("CpsCni0003Event".equalsIgnoreCase(eventName)) {
				CpsCni0003Event event = (CpsCni0003Event)e;
				cgoClmNo = event.getCgoClmNo();
			}else if ("CpsCni0033Event".equalsIgnoreCase(eventName)) {
				CpsCni0033Event event = (CpsCni0033Event)e;	
				cgoClmNo = event.getCgoClmNo();
			}else if ("CpsCni0037Event".equalsIgnoreCase(eventName)) {
				CpsCni0037Event event = (CpsCni0037Event)e;	
				cgoClmNo = event.getCgoClmNo();
			}
					
			// Claim 정보 조회
			ClaimMainVO claimMainVO = command.searchClaimMain(cgoClmNo);		
			eventResponse.setRsVo(claimMainVO);
			
			//SESSION 에 CLAIM_NO 세팅. 조회결과가 있는 경우만 세팅함.
			if(claimMainVO != null ){
				CniUtil.setCargoClaimNo(account, cgoClmNo);
				CniUtil.setVvd(account, claimMainVO.getTrnkRefVvdNo());
			}else{
				CniUtil.setCargoClaimNo(account, "");
				CniUtil.setVvd(account,"");
			}
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * B/L 정보 체크<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchBlGetChk 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlGetChk(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			// BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
			
			CpsCni0003Event event = (CpsCni0003Event)e;
			
			// B/L No 조회		
			String cgoClmRefBlNo = event.getCgoClmRefBlNo();
			
			
			// B/L 정보 조회
			String blNo = command.searchBlGetChk(cgoClmRefBlNo);	
			
			eventResponse.setETCData("CGO_CLM_REF_BL_NO", blNo);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * B/L 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchBlGet 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlGet(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			// BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
			
			CpsCni0003Event event = (CpsCni0003Event)e;
			
			// B/L No 조회		
			String cgoClmRefBlNo = event.getCgoClmRefBlNo();
			log.debug("cgo_clm_ref_bl_no=" + cgoClmRefBlNo);
			
			// B/L 정보 조회
			BlGetVO blGetVO = command.searchBlGet(cgoClmRefBlNo);	
			
			eventResponse.setRsVo(blGetVO);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Incident 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchIncidentExist 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIncidentExist(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
		
			// BC 객체 생성
			IncidentSurveyBC command = new IncidentSurveyBCImpl();
	
			CpsCni0003Event event = (CpsCni0003Event)e;
			
			String cgoClmInciNo = event.getCgoClmInciNo();
			
			// Incident 정보 취득
			List<IncidentCreationVO> list = command.searchIncidentCreationInfo(cgoClmInciNo);
			eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	/**
	 * Claim Misc Code Name 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchClaimMainOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchClaimMainOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			// BC 객체 생성
			ClaimMainBC command1 = new ClaimMainBCImpl();
			
			String eventName = e.getEventName();
			// Claim Main 일때만 코드값 가져오기 (Claim Reopen-0037/Claim View-0033일 경우  코드값 조회 제외)
			if ("CpsCni0003Event".equalsIgnoreCase(eventName)) {
				List<MiscellaneousVO> miscCodeList1 = command.searchMiscellaneousList("03");
				eventResponse.setRsVoList(miscCodeList1);
				
				List<MiscellaneousVO> miscCodeList2 = command.searchMiscellaneousList("04");
				eventResponse.setRsVoList(miscCodeList2);
				
				List<MiscellaneousVO> miscCodeList3 = command.searchMiscellaneousList("06");
				eventResponse.setRsVoList(miscCodeList3);
				
				List<MiscellaneousVO> miscCodeList4 = command.searchMiscellaneousList("22");
				eventResponse.setRsVoList(miscCodeList4);
				
				List<MiscellaneousVO> miscCodeList5 = command.searchMiscellaneousList("23");
				eventResponse.setRsVoList(miscCodeList5);
				
				List<MiscellaneousVO> miscCodeList6 = command.searchMiscellaneousList("11");
				eventResponse.setRsVoList(miscCodeList6);
				
				List<MiscellaneousVO> miscCodeList7 = command.searchMiscellaneousList("02");
				eventResponse.setRsVoList(miscCodeList7);
				
				List<MiscellaneousVO> miscCodeList8 = command.searchMiscellaneousList("39");
				eventResponse.setRsVoList(miscCodeList8);
				
				List<MiscellaneousVO> miscCodeList9 = command.searchMiscellaneousList("14");
				eventResponse.setRsVoList(miscCodeList9);
			
				// Office Cd 조회		
				String ofcCd = account.getOfc_cd();
				
				// Area Cd 정보 조회
				CniAreaOfcVO cniAreaOfcVO = command1.searchAreaCd(ofcCd);		
				eventResponse.setRsVo(cniAreaOfcVO);
			}
			//SESSION 에 CLAIM_NO조회  조회결과가 있는 경우만 세팅함.
			String cgoClmNo = CniUtil.getCargoClaimNo(account);
			eventResponse.setETCData("CGO_CLM_NO", cgoClmNo);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * Miscellaneous Code Validation 체크<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchMiscCodeExist 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMiscCodeExist(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
		
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
	        CpsCni0003Event event = (CpsCni0003Event)e;
			
			String clssClmMiscCd = event.getClssClmMiscCd();
			String clmMiscCd = event.getClmMiscCd();
			//
			String isExist = command.searchMiscCodeExist(clssClmMiscCd, clmMiscCd);
			eventResponse.setETCData("EXIST", isExist);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * Office Code Validation 체크<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchMdmOrganizationExist 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmOrganizationExist(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
	        CpsCni0003Event event = (CpsCni0003Event)e;
			
			String fmalClmRcvOfcCd = event.getFmalClmRcvOfcCd();
			
			log.debug("fmalClmRcvOfcCd=" + fmalClmRcvOfcCd);
			String isExist = command.searchMdmOrganizationExist(fmalClmRcvOfcCd);
			eventResponse.setETCData("EXIST", isExist);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * BookingNo 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchBookingNo 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingNo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
	
			CpsCni0003Event event = (CpsCni0003Event)e;
			
			String cGoClmRefBlNo = event.getCgoClmRefBlNo();
			
			BookingNoVO vo = command.searchBookingNoInfo(cGoClmRefBlNo);
			
			eventResponse.setRsVo(vo);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	// ===========================================================================
	// 양정란
	// ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0002] Find
	// ---------------------------------------------------------------------------	
	/**
	 * Find 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0002
	 * @category searchFindList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFindList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
		// BC 객체 생성
		ClaimMainBC command = new ClaimMainBCImpl();

		CpsCni0002Event event = (CpsCni0002Event)e;
		
		// param	
		
		// Find 정보 취득
		List<FindVO> list = command.searchFindList(event.getFindCondVO());
		eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Find 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0002
	 * @category searchFindOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFindOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			//Area 09
			List<MiscellaneousVO> miscCodeList1 = command.searchMiscellaneousList("09");
			eventResponse.setRsVoList(miscCodeList1);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}		

	/**
	 * Find 리스트 프린트<br>
	 * @author 양정란
	 * @category CPS_CNI_0061
	 * @category printFind 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printFind(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
		
			// BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
	
			CpsCni0002Event event = (CpsCni0002Event)e;
					
			// Find List 취득
			List<FindVO> list = command.searchFindList(event.getFindCondVO());	
			eventResponse.setRsVoList(list);		
			
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
		   	    
			for (int i = 0; i < list.size(); i++) {			
				FindVO vo = list.get(i);
				pw.print(vo.getCgoClmDivCd()+SP); 
				pw.print(vo.getCgoClmNo() +SP); 					
				pw.print(vo.getCgoClmRefBlNo()+SP);
				pw.print(vo.getCgoClmRefCntrNo()+SP);
				pw.print(vo.getTrnkRefVvdNo()+SP);			
				pw.print(vo.getClmAreaCd()+SP);
				pw.print(vo.getHdlrOfcCd()+SP);
				pw.print(vo.getHdlrUsrId()+SP);
				pw.print(vo.getStsCd()+SP);
				pw.print(vo.getFmalClmRcvDt()+SP);
				pw.print(vo.getCgoClmInciNo()+SP);
				pw.print(vo.getCrmVocNo()+SP);
				pw.print(vo.getUpdDt()+SP);
				pw.print(vo.getClmtClmTpCd()+SP);
				pw.print(vo.getClaimant()+SP);
				pw.print(vo.getClmtLoclAmt()+SP);
				pw.print(vo.getClmCurrCd()+SP);
				pw.print(vo.getClmUsdAmt()+SP);
				pw.print(vo.getCgoClmStlTpCd()+SP);
				pw.print(vo.getCgoClmStlLoclAmt()+SP);
				pw.print(vo.getCgoClmStlCurrCd()+SP);
				pw.print(vo.getCgoClmStlUsdAmt()+SP);
				pw.print(vo.getLiableParty()+SP);
				pw.print(vo.getClmPtyAbbrNm()+SP);
				pw.print(vo.getInsurRefNo()+SP);
				pw.println(vo.getPastCgoClmNo()+SP);

			}
			
			eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0012] Survey
	// ---------------------------------------------------------------------------	
	
	/**
	 * Survey 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0012
	 * @category searchSurveyOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurveyOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			//Type Of Surveyor
			List<MiscellaneousVO> miscCodeList1 = command.searchMiscellaneousList("10");
			eventResponse.setRsVoList(miscCodeList1);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}	
	/**
	 * Survey 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0012
	 * @category searchSurveyList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurveyInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
		
			// BC 객체 생성
			IncidentSurveyBC command = new IncidentSurveyBCImpl();
	
			CpsCni0012Event event = (CpsCni0012Event)e;
			
			//param 
			String cgoClmNo = event.getCgoClmNo();
			
			// Survey 정보 취득
			List<SurveyVO> list = command.searchSurveyInfo(cgoClmNo);
			eventResponse.setRsVoList(list);
			
			//SESSION 에 CLAIM_NO 세팅. 조회결과가 있는 경우만 세팅함.
			if(list.size() > 0){
				CniUtil.setCargoClaimNo(account, cgoClmNo);
			}else{
				CniUtil.setCargoClaimNo(account, "");
			}
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * Survey  수정 ,입력<br>
	 * @author 양정란
	 * @category CPS_CNI_0012
	 * @category manageSurvey 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSurvey(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		IncidentSurveyBC command = new IncidentSurveyBCImpl();

		CpsCni0012Event event = (CpsCni0012Event)e;
				
		try {			
			begin();
			
			CniCgoClmSveyVO cniCgoClmSveyVO = event.getCniCgoClmSveyVO();
			
			// event관련 사용자정보 insert
			//사용자 설정
			cniCgoClmSveyVO.setCreUsrId(account.getUsr_id());
			cniCgoClmSveyVO.setUpdUsrId(account.getUsr_id());
			
			String manageStr = command.manageSurvey(cniCgoClmSveyVO);
			
			// 에러메세지설정
			if(manageStr.equals("N")){
				eventResponse.setETCData("MANAGE_STR", "N");//CNI00102 로 변경할 예정
				//There is no Claim No to Save
				eventResponse.setUserMessage(new ErrorHandler("CNI00022").getUserMessage());	
			}else{
				eventResponse.setETCData("MANAGE_STR", "Y");
				eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());			
			}
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0013] Salvage
	// ---------------------------------------------------------------------------	
	/**
	 * Salvage 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0013
	 * @category searchSalvageInfo 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalvageInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			IncidentSurveyBC command = new IncidentSurveyBCImpl();
	
			CpsCni0013Event event = (CpsCni0013Event)e;
			
			// param	
			String cgoClmNo = event.getCgoClmNo();
			
			// Survey 정보 취득
			List<SalvageVO> list = command.searchSalvageInfo(cgoClmNo);
			eventResponse.setRsVoList(list);
			
			//SESSION 에 CLAIM_NO 세팅. 조회결과가 있는 경우만 세팅함.
			if(list.size() > 0){
				CniUtil.setCargoClaimNo(account, cgoClmNo);
			}else{
				CniUtil.setCargoClaimNo(account, "");
			}	
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * Salvage  수정 ,입력<br>
	 * @author 양정란
	 * @category CPS_CNI_0013
	 * @category manageSalvage 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSalvage(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		IncidentSurveyBC command = new IncidentSurveyBCImpl();

		CpsCni0013Event event = (CpsCni0013Event)e;
				
		try {			
			begin();
			
			CniCgoClmSlvVO cniCgoClmSlvVO = event.getCniCgoClmSlvVO();
			
			// event관련 사용자정보 insert
			//사용자 설정
			cniCgoClmSlvVO.setCreUsrId(account.getUsr_id());
			cniCgoClmSlvVO.setUpdUsrId(account.getUsr_id());
			
			String manageStr = command.manageSalvage(cniCgoClmSlvVO);
			
			// 에러메세지설정
			if(manageStr.equals("N")){
				eventResponse.setETCData("MANAGE_STR", "N");//CNI00102 로 변경할 예정
				//There is no Claim No to Save
				eventResponse.setUserMessage(new ErrorHandler("CNI00022").getUserMessage());	
			}else{
				eventResponse.setETCData("MANAGE_STR", "Y");
				eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());			
			}
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0030] Incident-Creation
	// ---------------------------------------------------------------------------
	
	/**
	 * Incident 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchIncidentOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIncidentOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			//Place Of Incident
			List<MiscellaneousVO> miscCodeList1 = command.searchMiscellaneousList("14");
			eventResponse.setRsVoList(miscCodeList1);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}		
	/**
	 * Incident-Creation 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchIncidentInfo 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIncidentCreationInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
		
			// BC 객체 생성
			IncidentSurveyBC command = new IncidentSurveyBCImpl();
	
			CpsCni0030Event event = (CpsCni0030Event)e;
			
			// param	
			String cgoClmInciNo = event.getCgoClmInciNo();
			
			// 정보 취득
			List<IncidentCreationVO> list = command.searchIncidentCreationInfo(cgoClmInciNo);
			eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Location 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchLocation 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchLocation(Event e) throws EventException {
		
		CpsCni0030Event event = (CpsCni0030Event)e;
		
		IncidentSurveyBC command = new IncidentSurveyBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			String result      = command.searchLocation(event.getSearchText());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if (result == null || result.equals("")) {
				etcData.put("errMsg",(String) new ErrorHandler("CNI00034",new String[]{"Location"}).getUserMessage());
			} else {
				etcData.put("loc_cd",result);
			}
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}	
	
	/**
	 * VVD 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchVesselName 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchVesselName(Event e) throws EventException {
		
		CpsCni0030Event event = (CpsCni0030Event)e;
		
		IncidentSurveyBC command = new IncidentSurveyBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			String result      = command.searchVesselName(event.getSearchText());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if (result == null || result.equals("")) {
				etcData.put("errMsg",(String) new ErrorHandler("CNI09014",new String[]{}).getUserMessage());
			} else {
				etcData.put("vsl_cd",result);
			}
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}	
	/**
	 * Incident-Creation 프린트<br>
	 * @author 양정란
	 * @category CPS_CNI_0088
	 * @category printIncident 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printIncident(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try{
			
			// BC 객체 생성
			IncidentSurveyBC command = new IncidentSurveyBCImpl();
	
			CpsCni0030Event event = (CpsCni0030Event)e;
			
			// param	
			String cgoClmInciNo = event.getCgoClmInciNo();
					
			// 정보 취득
			List<IncidentCreationVO> list = command.searchIncidentCreationInfo(cgoClmInciNo);
			eventResponse.setRsVoList(list);	
			
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
		    
		    String desc = "";
		   	    
			for (int i = 0; i < list.size(); i++) {			
				IncidentCreationVO vo = list.get(i);
				//------------------- 주 쿼리 생성 -------------------//
				pw.println(vo.getCgoClmInciNo()+SP); 
				//------------------- 1 SubPage -------------------//
				pw.print(vo.getCreDt() +SP);
				pw.print(vo.getCreOfcCd()+SP);
				pw.print(vo.getCreUsrId() +SP);
				pw.print(vo.getUpdDt() +SP);
				pw.print(vo.getCgoClmInciNo()+SP); 
				pw.print(vo.getInciSubjNm() +SP);
				pw.print(vo.getInciPlcTpCd() +SP);
				pw.print(vo.getInciLocCd() +SP);
				pw.print(vo.getInciRefVvdNo() +SP);
				pw.println(vo.getInciOccrDt() +SP);
				
			    desc = vo.getInciDevDesc();   
			    if (desc != null) {
				   desc = desc.replaceAll("\r\n", "crlf");
			    } else {
				   desc = "";
			    }
			    pw.println(EOR); // SubPage 1
			    pw.println(desc +SP);// SubPage2
			    
			}
			
			eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * Incident-Creation  수정 ,입력<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category manageIncident 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageIncident(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		IncidentSurveyBC command = new IncidentSurveyBCImpl();

		CpsCni0030Event event = (CpsCni0030Event)e;
				
		try {			
			begin();
			
			CniCgoClmInciVO cniCgoClmInciVO = event.getCniCgoClmInciVO();
			
			// event관련 사용자정보 insert
			//사용자 설정
			cniCgoClmInciVO.setCreUsrId(account.getUsr_id());
			cniCgoClmInciVO.setUpdUsrId(account.getUsr_id());
			cniCgoClmInciVO.setCreOfcCd(account.getOfc_cd());
			
			String etcClmInciNo = command.manageIncident(cniCgoClmInciVO);
			
			//입력후 생성된 CLM_INCI_NO 로 조회. 
			eventResponse.setETCData("ETC_CLM_INCI_NO", etcClmInciNo);
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());			
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0030] Incident-Creation
	// ---------------------------------------------------------------------------
	
	/**
	 * Incident-Inquiry 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0031
	 * @category searchIncidentInquiryOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIncidentInquiryOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			// BC 객체 생성
			ClaimMainBC command1 = new ClaimMainBCImpl();

			//Area 09
			List<MiscellaneousVO> miscCodeList1 = command.searchMiscellaneousList("09");
			eventResponse.setRsVoList(miscCodeList1);
			
			//POI 14
			List<MiscellaneousVO> miscCodeList2 = command.searchMiscellaneousList("14");
			eventResponse.setRsVoList(miscCodeList2);
			
			// Office Cd 조회		
			String ofcCd = account.getOfc_cd();
			
			// Area Cd 정보 조회
			CniAreaOfcVO cniAreaOfcVO = command1.searchAreaCd(ofcCd);		
			eventResponse.setRsVo(cniAreaOfcVO);
			
			//GMT 조회조건의 날짜
			eventResponse.setETCData("schToStr", command.searchGmtDate(account.getUsr_id()));
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}		
	/**
	 * Incident-Inquiry 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0031
	 * @category searchIncidentInquiryList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIncidentInquiryList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			IncidentSurveyBC command = new IncidentSurveyBCImpl();
	
			CpsCni0031Event event = (CpsCni0031Event)e;
			
			// param	
			
			// Survey 정보 취득
			List<IncidentInquiryVO> list = command.searchIncidentInquiryList(event.getIncidentInquiryCondVO());
			eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * IncidentInquiry 리스트 프린트<br>
	 * @author 양정란
	 * @category CPS_CNI_0086
	 * @category printIncidentInquiry 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printIncidentInquiry(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			IncidentSurveyBC command = new IncidentSurveyBCImpl();
	
			CpsCni0031Event event = (CpsCni0031Event)e;
					
			// Survey 정보 취득
			List<IncidentInquiryVO> list = command.searchIncidentInquiryList(event.getIncidentInquiryCondVO());
			eventResponse.setRsVoList(list);	
			
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
		   	    
			for (int i = 0; i < list.size(); i++) {			
				IncidentInquiryVO vo = list.get(i);
				pw.print(vo.getCgoClmInciNo()+SP); 
				pw.print(vo.getClmAreaCd() +SP); 					
				pw.print(vo.getCreOfcCd()+SP);
				pw.print(vo.getCreUsrId()+SP);
				pw.print(vo.getCreDt()+SP);			
				pw.print(vo.getInciPlcTpCd()+SP);
				pw.print(vo.getInciLocCd()+SP);
				pw.print(vo.getInciOccrDt()+SP);
				pw.print(vo.getInciRefVvdNo()+SP);
				pw.println(vo.getInciSubjNm()+SP);
			}
			
			eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Incident-Claim Inquiry 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0032
	 * @category searchIncidentClaimInquiryOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIncidentClaimInquiryOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			//GMT 조회조건의 날짜
			eventResponse.setETCData("schToStr", command.searchGmtDate(account.getUsr_id()));
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * Incident-Claim Inquiry 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0032
	 * @category searchIncidentClaimInquiryList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIncidentClaimInquiryList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			IncidentSurveyBC command = new IncidentSurveyBCImpl();
	
			CpsCni0032Event event = (CpsCni0032Event)e;
			
			// param	
			String cgoClmInciNo = event.getCgoClmInciNo();
			String pageNo = event.getPageNo();
			
			//정보 취득
			List<IncidentClaimInquiryVO> list = command.searchIncidentClaimInquiryList(cgoClmInciNo, pageNo);
			eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Incident-ClaimInquiry 프린트<br>
	 * @author 양정란
	 * @category CPS_CNI_0087
	 * @category printIncidentClaimInquiry 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printIncidentClaimInquiry(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			IncidentSurveyBC command = new IncidentSurveyBCImpl();
	
			CpsCni0032Event event = (CpsCni0032Event)e;
			
			// param	
			String cgoClmInciNo = event.getCgoClmInciNo();
			String pageNo = event.getPageNo();
					
			//정보 취득
			List<IncidentClaimInquiryVO> list = command.searchIncidentClaimInquiryList(cgoClmInciNo, pageNo);
			eventResponse.setRsVoList(list);	
			
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
	
		    for (int i = 0; i < list.size(); i++) {			
				IncidentClaimInquiryVO vo = list.get(i);
				pw.print(vo.getCgoClmDivCd()+SP); 
				pw.print(vo.getCgoClmNo() +SP); 					
				pw.print(vo.getClmAreaCd1()+SP);
				pw.print(vo.getHdlrOfcCd()+SP);
				pw.print(vo.getCgoClmStsCd()+SP);			
				pw.print(vo.getSmnsSveDt()+SP);
				pw.print(vo.getCsClzDt()+SP);
				pw.print(vo.getPrlmClmNtcDt()+SP);
				pw.print(vo.getFmalClmRcvDt()+SP);			
				pw.print(vo.getUpdDt1()+SP);
				pw.print(vo.getPtyNm1()+SP);
				pw.print(vo.getTrnkRefVvdNo()+SP);
				pw.print(vo.getCgoClmRefBlNo()+SP);
				pw.print(vo.getCgoClmRefCntrNo()+SP);
				pw.print(vo.getCrrTermCd()+SP);
				pw.print(vo.getPorCd()+SP);
				pw.print(vo.getPolCd()+SP);			
				pw.print(vo.getPodCd()+SP);
				pw.print(vo.getDelCd()+SP);
				pw.print(vo.getDeDt()+SP);
				pw.print(vo.getN1stPreRefVvdNo()+SP);
				pw.print(vo.getN1stPreTsLocCd()+SP);
				pw.print(vo.getN1stPstTsLocCd()+SP);
				pw.print(vo.getCgoQltyDesc()+SP);
				pw.print(vo.getCgoClmTpCd()+SP);
				pw.print(vo.getClmtLoclAmt()+SP);			
				pw.print(vo.getCgoClmStlTpCd()+SP);
				pw.print(vo.getCgoClmStlDt()+SP);
				pw.print(vo.getCgoClmStlUsdAmt()+SP);
				pw.print(vo.getPtyNm2()+SP);			
				pw.print(vo.getSveyInpDt()+SP);
				pw.println(vo.getSvyrFeeUsdAmt()+SP);
			}
			
			eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0008] Payment
	// ---------------------------------------------------------------------------	
	/**
	 * Payment 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0008
	 * @category searchPaymentInfo 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
	
			CpsCni0008Event event = (CpsCni0008Event)e;
			
			// param
			String cgoClmNo = event.getCgoClmNo();
			
			// Find 정보 취득
			List<PaymentVO> list = command.searchPaymentInfo(cgoClmNo);
			eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * Payment  수정 ,입력<br>
	 * @author 양정란
	 * @category CPS_CNI_0008
	 * @category managePayment
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePayment(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		ClaimMainBC command = new ClaimMainBCImpl();

		CpsCni0008Event event = (CpsCni0008Event)e;
				
		try {			
			begin();
			
			PaymentVO paymentVO = event.getPaymentVO();
			
			command.managePayment(paymentVO);
			
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0036] Transfer
	// ---------------------------------------------------------------------------
	
	/**
	 * Transfer 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category searchTransferOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransferOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			//GMT 조회조건의 날짜
			String schToDate = command.searchGmtDate(account.getUsr_id());
			String schFromDate = schToDate.replaceAll("-", "");
			schFromDate = DateTime.addMonths(schFromDate,-1);
			schFromDate = DateTime.getFormatDate(schFromDate, "yyyyMMdd", "yyyy-MM-dd");
			
			eventResponse.setETCData("schFromDate", schFromDate);
			eventResponse.setETCData("schToDate", schToDate);
			
			//STATUS Of TRANSFER
			List<MiscellaneousVO> miscCodeList1 = command.searchMiscellaneousList("32");
			eventResponse.setRsVoList(miscCodeList1);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}		
	/**
	 * Transfer 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category searchTransferList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransferList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
		
			// BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
	
			CpsCni0036Event event = (CpsCni0036Event)e;
			
			// param	
			
			// 정보 취득
			List<TransferVO> list = command.searchTransferList(event.getTransferCondVO());
			eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Transfer 리스트 프린트<br>
	 * @author 양정란
	 * @category CPS_CNI_0089
	 * @category printTransfer 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printTransfer(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
	
			CpsCni0036Event event = (CpsCni0036Event)e;
					
			// Find List 취득
			List<TransferVO> list = command.searchTransferList(event.getTransferCondVO());	
			eventResponse.setRsVoList(list);		
			
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
			log.debug("JBY==================================");
		   	    
			for (int i = 0; i < list.size(); i++) {			
				TransferVO vo = list.get(i);
				pw.print(vo.getCgoClmNo()+SP); 
				pw.print(vo.getClmAreaCd() +SP); 					
				pw.print(vo.getClmMiscNm()+SP);
				pw.print(vo.getTrnsKnt()+SP);
				pw.print(vo.getTrnsFmOfcCd()+SP);			
				pw.print(vo.getTrnsFmUsrId()+SP);
				pw.print(vo.getTrnsFmDt()+SP);
				pw.print(vo.getClmTrnsAuthNm()+SP);
				pw.print(vo.getTrnsToOfcCd()+SP);
				pw.print(vo.getTrnsToUsrId()+SP);
				pw.print(vo.getTrnsToDt()+SP);
				pw.println(vo.getTrnsRmk()+SP);
			}
			
			eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * Transfer Validation<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category searchTrnsOfcCd 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrnsOfcCd(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
		
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl(); 
	
			CpsCni0036Event event = (CpsCni0036Event)e;
			
			String[] exist = command.searchOfcCd(event.getTrnsToOfcCd());
			eventResponse.setETCData("EXIST_OFC_CD", exist[0]);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * Transfer Validation<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category searchTrnsUsrId 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrnsUsrId(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl(); 
	
			CpsCni0036Event event = (CpsCni0036Event)e;
			
			String[] exist = command.searchUsrId(event.getTrnsToOfcCd(), event.getTrnsToUsrId());
			eventResponse.setETCData("EXIST_USR_ID", exist[0]);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}		
	
	/**
	 * Transfer  수정<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category manageTransfer 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTransfer(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		ClaimMainBC command = new ClaimMainBCImpl();

		CpsCni0036Event event = (CpsCni0036Event)e;
		
		try {			
			begin();
			
			// event관련 사용자정보 insert
			TransferVO[] transferVOs =  event.getTransferVOs();
			for(int i=0; i<transferVOs.length; i++) {
				//사용자 설정
				transferVOs[i].setUpdUsrId(account.getUsr_id());
			}
			
			command.manageTransfer(transferVOs);
			
			// 에러메세지설정
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());			
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0009] Handling Costs
	// ---------------------------------------------------------------------------
	
	/**
	 * Handling Costs 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category searchHandlingCostOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHandlingCostOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			//Type Of Surveyor
			List<MiscellaneousVO> miscCodeList1 = command.searchMiscellaneousList("30");
			eventResponse.setRsVoList(miscCodeList1);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}	
	/**
	 * Handling Costs 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category searchHandlingCostList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHandlingCostList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
		// BC 객체 생성
		ClaimMainBC command = new ClaimMainBCImpl();

		CpsCni0009Event event = (CpsCni0009Event)e;
		
		//param 
		String cgoClmNo = event.getCgoClmNo();	
		
		// 정보 취득
		HandlingCostInfoVO handlingCostInfoVO = command.searchHandlingCostInfo(event.getCgoClmNo());
		eventResponse.setRsVo(handlingCostInfoVO);
		
		List<HandlingCostVO> list = command.searchHandlingCostList(event.getCgoClmNo());
		eventResponse.setRsVoList(list);
		
		
		//SESSION 에 CLAIM_NO 세팅. 조회결과가 없어도  세팅함.(다른 페이지의 세팅규칙과는 다름. 주의를 위해 주석을 삭제하지 않음.)
//		if(list.size() > 0){
			CniUtil.setCargoClaimNo(account, cgoClmNo);
//		}
//		else{
//			CniUtil.setCargoClaimNo(account, "");
//		}
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * Handling Costs  수정<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category manageHandlingCost 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHandlingCost(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		ClaimMainBC command = new ClaimMainBCImpl();

		CpsCni0009Event event = (CpsCni0009Event)e;
				
		try {			
			begin();
			
			// event관련 사용자정보 insert
			CniCgoClmCostVO[] cniCgoClmCostVOs =  event.getCniCgoClmCostVOs();
			for(int i=0; i<cniCgoClmCostVOs.length; i++) {
				//사용자 설정
				cniCgoClmCostVOs[i].setUpdUsrId(account.getUsr_id());
				cniCgoClmCostVOs[i].setCreUsrId(account.getUsr_id());
			}
			
			String errMsg  = command.manageHandlingCost(cniCgoClmCostVOs);
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if (errMsg == null || errMsg.equals("N")) {
				etcData.put("errMsg","N");//정상
				commit();
			} else {
//				etcData.put("errMsg",(String) new ErrorHandler("CNI00020",new String[]{"Survey Data"}).getUserMessage());
				etcData.put("errMsg","Y");
				rollback();
			}
			
			eventResponse.setETCData(etcData);
			

		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//CNI_CGO_CLM_SVEY 데이타 없는데 Handling Cost Type ="Survey" 입력시 에러처리.
			throw new EventException(new ErrorHandler("CNI00020",new String[]{"Survey Data"}).getMessage()); 
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}		
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0015] LiableParty
	// ---------------------------------------------------------------------------	
	/**
	 * LiableParty 정보 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category searchLiablePartyList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLiablePartyInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
		
			// BC 객체 생성
			IndemnityClaimBC command = new IndemnityClaimBCImpl();
	
			CpsCni0015Event event = (CpsCni0015Event)e;
			
			//param 
			String cgoClmNo = event.getCgoClmNo();
			
			List<LiablePartyVO> list = command.searchLiablePartyInfo(cgoClmNo);
			eventResponse.setRsVoList(list);
			
			//SESSION 에 CLAIM_NO 세팅. 조회결과가 있는 경우만 세팅함.
			if(list.size() > 0){
				CniUtil.setCargoClaimNo(account, cgoClmNo);
			}else{
				CniUtil.setCargoClaimNo(account, "");
			}
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * LiableParty BookingNo 정보 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category searchLiablePartyBookingNoInfo 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLiablePartyBookingNoInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
		
			// BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
	
			CpsCni0015Event event = (CpsCni0015Event)e;
			
			//param 
			String blNo = event.getBlNo();
			
			BookingNoVO vo = command.searchBookingNoInfo(blNo);
			eventResponse.setRsVo(vo);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * LiableParty  수정 ,입력<br>
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category manageLiableParty 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLiableParty(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		IndemnityClaimBC command = new IndemnityClaimBCImpl();
		ClaimMainBC command1 = new ClaimMainBCImpl(); 
		CodeMgtBC command2 = new CodeMgtBCImpl(); 

		CpsCni0015Event event = (CpsCni0015Event)e;
				
		try {			
			begin();
			
			CniLiablePartyVO cniLiablePartyVO = event.getCniLiablePartyVO();
			String miscCd = event.getMiscCd();
			String cgoClmStlUsdAmt = event.getCgoClmStlUsdAmt();
			
			// event관련 사용자정보 insert
			//사용자 설정
			cniLiablePartyVO.setCreUsrId(account.getUsr_id());
			cniLiablePartyVO.setUpdUsrId(account.getUsr_id());
			
			String manageStr = command.manageLiableParty(cniLiablePartyVO);
			
			boolean stsCd = false;
			String lablPtyFmalClmDt = cniLiablePartyVO.getLablPtyFmalClmDt();
			String lablPtyRcvrUsdAmt = cniLiablePartyVO.getLablPtyRcvrUsdAmt();
			String lablPtyDmndAmt = cniLiablePartyVO.getLablPtyDmndAmt();
			
			BigDecimal lablPtyRcvrUsdAmtDec = new BigDecimal(lablPtyRcvrUsdAmt);
			BigDecimal cgoClmStlUsdAmtDec = new BigDecimal(cgoClmStlUsdAmt);
			BigDecimal lablPtyDmndAmtDec = new BigDecimal(lablPtyDmndAmt);
			
			//클레임 번호 취득
			String cgoClmNo = cniLiablePartyVO.getCgoClmNo();
			CniCgoClmVO cniCgoClmVO = new CniCgoClmVO();					
			cniCgoClmVO.setCgoClmNo(cgoClmNo);
			cniCgoClmVO.setUpdUsrId(account.getUsr_id());	
			String cgoClmStsCd = "";
			
			
			//////////////////////////////////////////////////
			// Case Closed
			// 1. if((CGO_CLM_STS_CD == 'P','R','I') && (lablPtyFmalClmDt!="") && (LABL_PTY_RCVR_USD_AMT >= CGO_CLM_STL_USD_AMT)) 이면 Case Closed 처리한다.
			/////////////////////////////////////////////////
			if( (miscCd.equals("P")||miscCd.equals("R")||miscCd.equals("I"))&&!lablPtyFmalClmDt.equals("") ) {
				
				stsCd = true;				
			}			
			// Settlement 전에 구상권자로부터 미리 구상금을 받을수 있으므로, Settled Amount USD 가  0 이 아닌것 만 Case Closed 함
			if(cgoClmStlUsdAmtDec.compareTo(new BigDecimal(0))!=0) {
			
				if( stsCd && (lablPtyRcvrUsdAmtDec.compareTo(cgoClmStlUsdAmtDec)>=0) ) {
									
					cgoClmStsCd = "C";
					cniCgoClmVO.setCgoClmStsCd(cgoClmStsCd);					
					cniCgoClmVO.setCgoClmClzCd("C");
					
					command1.modifyClaimStatus(cniCgoClmVO);
					
					// ---------------------------------------------
					// 상태변경 처리후  Status History에 이력정보 설정
					// ---------------------------------------------				
					HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
					handlerHistoryVO.setCgoClmNo(cgoClmNo);
					handlerHistoryVO.setUpdUsrId(account.getUsr_id());
					handlerHistoryVO.setCreUsrId(account.getUsr_id());				
					
					handlerHistoryVO.setHdlrOfcCd(account.getOfc_cd());
					handlerHistoryVO.setHdlrUsrId(account.getUsr_id());
					
					command2.manageHandlerHistory(handlerHistoryVO, cgoClmStsCd);
					
				}
			}
			
			//////////////////////////////////////////////////
			// LP Recovering
			// 2. if((CGO_CLM_STS_CD NOT IN ('N','C','X') && (lablPtyRcvrDt!="") && (LABL_PTY_DMND_AMT > 0)) 이면 LP_Recovering 처리한다.
			// 3. if((CGO_CLM_STS_CD IN ('F','L','P') && (lablPtyRcvrDt!="") && (LABL_PTY_DMND_AMT > 0)) 이면 LP_Recovering 처리한다. -- 20100510 JBLEE 
			// 4. if((CGO_CLM_STS_CD IN ('P') && (lablPtyRcvrDt!="") && (LABL_PTY_DMND_AMT > 0)) 이면 LP_Recovering 처리한다. -- 20120118 이준범
			/////////////////////////////////////////////////
			if( (miscCd.equals("P")) && (!lablPtyFmalClmDt.equals("")) 
					&& (lablPtyDmndAmtDec.compareTo(new BigDecimal("0")) == 1) ) {
								
				cgoClmStsCd = "R";
				cniCgoClmVO.setCgoClmStsCd(cgoClmStsCd);
				cniCgoClmVO.setCgoClmClzCd("O");
				command1.modifyClaimStatus(cniCgoClmVO);
				
				// ---------------------------------------------
				// 상태변경 처리후  Status History에 이력정보 설정
				// ---------------------------------------------				
				HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
				handlerHistoryVO.setCgoClmNo(cgoClmNo);
				handlerHistoryVO.setUpdUsrId(account.getUsr_id());
				handlerHistoryVO.setCreUsrId(account.getUsr_id());				
				
				handlerHistoryVO.setHdlrOfcCd(account.getOfc_cd());
				handlerHistoryVO.setHdlrUsrId(account.getUsr_id());
				
				command2.manageHandlerHistory(handlerHistoryVO, cgoClmStsCd);
				
			}
			
			
			// 에러메세지설정
			if(manageStr.equals("N")){
				eventResponse.setETCData("MANAGE_STR", "N");//CNI00102 로 변경할 예정
				//There is no Claim No to Save
				eventResponse.setUserMessage(new ErrorHandler("CNI00022").getUserMessage());	
			}else{
				eventResponse.setETCData("MANAGE_STR", "Y");
				eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());			
			}
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * LiableParty  Cancel <br>
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category manageLiablePartyCancel 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLiablePartyCancel(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		IndemnityClaimBC command = new IndemnityClaimBCImpl();
		ClaimMainBC command1 = new ClaimMainBCImpl(); 
		CodeMgtBC command2 = new CodeMgtBCImpl(); 	

		CpsCni0015Event event = (CpsCni0015Event)e;
				
		try {			
			begin();
			
			CniLiablePartyVO cniLiablePartyVO = event.getCniLiablePartyVO();
			String miscCd = event.getMiscCd();
			String cgoClmNo = cniLiablePartyVO.getCgoClmNo();
			
			cniLiablePartyVO.setCreUsrId(account.getUsr_id());
			cniLiablePartyVO.setUpdUsrId(account.getUsr_id());			
			//String manageStr = command.manageLiableParty(cniLiablePartyVO);
						
			
			//////////////////////////////////////////////////
			// CANCEL
			/////////////////////////////////////////////////
			if( miscCd.equals("R") ) {
							
				// ---------------------------------------------
				//  Status 전상태 로 변경
				// ---------------------------------------------
				//CniCgoClmVO cniCgoClmVO = new CniCgoClmVO();				
				//cniCgoClmVO.setUpdUsrId(account.getUsr_id());
				//cniCgoClmVO.setCgoClmNo(cgoClmNo);				
				//cniCgoClmVO.setCgoClmStsCd("P");					
				//cniCgoClmVO.setCgoClmClzCd("O");
				//command1.modifyClaimStatus(cniCgoClmVO);
				
				command1.modifyClaimPreStatus(cgoClmNo,account.getUsr_id());
				
				
				// ---------------------------------------------
				// 상태변경 처리후  Status History에 이력정보 설정
				// ---------------------------------------------				
				HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
				handlerHistoryVO.setCgoClmNo(cgoClmNo);
				handlerHistoryVO.setUpdUsrId(account.getUsr_id());
				handlerHistoryVO.setCreUsrId(account.getUsr_id());			
				
				handlerHistoryVO.setHdlrOfcCd(account.getOfc_cd());
				handlerHistoryVO.setHdlrUsrId(account.getUsr_id());
				//신규 status 취득
				String status = command1.searchClaimStatus(cgoClmNo);
				command2.manageHandlerHistory(handlerHistoryVO, status);
			}
			
			// ---------------------------------------------
			// Null 처리   Liable Party, LP HOFC, LP NOPC Date, LP Claim Amount, LP Recovered Amount
			// ---------------------------------------------	
			
			cniLiablePartyVO.setClmPtyNo("");
			cniLiablePartyVO.setLablPtyRcvrLoclAmt("0");
			cniLiablePartyVO.setLablPtyRcvrDt("");
			cniLiablePartyVO.setLablPtyRcvrUsdAmt("0");
			cniLiablePartyVO.setLablPtyXchRt("0");
			cniLiablePartyVO.setLablPtyDmndUsdAmt("0");
			cniLiablePartyVO.setClmPtyNo("");
			cniLiablePartyVO.setLablPtyDmndCurrCd("");
			cniLiablePartyVO.setTmBarDt("");
			cniLiablePartyVO.setLablPtyPrlmClmNtfyDt("");
			cniLiablePartyVO.setLablPtyDmndAmt("0");
			cniLiablePartyVO.setLablPtyRcvrLoclCurrCd("");
			cniLiablePartyVO.setLablPtyFmalClmDt("");
			cniLiablePartyVO.setLablPtyRcvrLoclXchRt("0");
			cniLiablePartyVO.setHndlOfcCd("");
			
			command.manageLiableParty(cniLiablePartyVO);
			
			
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
		
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0010] Contract of Carriage
	// ---------------------------------------------------------------------------	
	/**
	 * ContractCarriage 정보 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageInfo 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractCarriageInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// Claim Main BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
	
			CpsCni0010Event event = (CpsCni0010Event)e;
			
			//param 
			String cgoClmNo = event.getCgoClmNo();
			
			ContractCarriageVO contractCarriageVO = command.searchContractCarriageInfo(cgoClmNo);
			eventResponse.setRsVo(contractCarriageVO);
			
			List<CniCgoClmBlDtlVO> list = command.searchClaimBlDetailList(cgoClmNo);
			eventResponse.setRsVoList(list);
				
			
			//SESSION 에 CLAIM_NO 세팅. 조회결과가 있는 경우만 세팅함.
			if(list.size() > 0){
				CniUtil.setCargoClaimNo(account, cgoClmNo);
			}else{
				CniUtil.setCargoClaimNo(account, "");
			}
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * ContractCarriage 정보 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageBLView 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractCarriageBLGet(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
		
			// Claim Main BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
	
			CpsCni0010Event event = (CpsCni0010Event)e;
			
			//param 
			String cgoClmNo = event.getCgoClmNo();
			String blNo = event.getBlNo();
			
			BookingNoVO vo = command.searchBookingNoInfo(blNo);
			
			String bkgNo = "" ;
			if( vo != null ) {
				bkgNo = vo.getBkgNo();
				ContractCarriageVO contractCarriageVO = command.searchContractCarriageBLGet(cgoClmNo,blNo,bkgNo);
				eventResponse.setRsVo(contractCarriageVO);
			}
						
			List<CniCgoClmCntrDtlVO> list = command.searchClaimContractBLGetDetailList(cgoClmNo,blNo,bkgNo);
			eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0010] Contract of Carriage
	// ---------------------------------------------------------------------------	
	/**
	 * ContractCarriage 정보 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchClaimContainerDetailList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchClaimContainerDetailList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// Claim Main BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
	
			CpsCni0010Event event = (CpsCni0010Event)e;
			
			//param 
			String cgoClmNo = event.getCgoClmNo();
			String cgoClmRefBlNo = event.getCgoClmRefBlNo();
							
			List<CniCgoClmCntrDtlVO> list = command.searchClaimContractDetailList(cgoClmNo,cgoClmRefBlNo);
			eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
				
		return eventResponse;
	}
	
	
	/**
	 * LiableParty  수정 ,입력<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category manageLiableParty 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContractCarriage(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		ClaimMainBC command = new ClaimMainBCImpl();

		CpsCni0010Event event = (CpsCni0010Event)e;
				
		try {			
			begin();
			
			 CniCgoClmCtrtVO cniCgoClmCtrtVO = event.getCniCgoClmCtrtVO();
			 
			 CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs = event.getCniCgoClmBlDtlVOs();
			 
			 CniCgoClmCntrDtlVO[] cniCgoClmCntrDtlVOs = event.getCniCgoClmCntrDtlVOs();
			
			// event관련 사용자정보 insert
			//사용자 설정
			 cniCgoClmCtrtVO.setCreUsrId(account.getUsr_id());
			 cniCgoClmCtrtVO.setUpdUsrId(account.getUsr_id());
			 
			 if(cniCgoClmBlDtlVOs!= null) {
				 for(int i=0; i<cniCgoClmBlDtlVOs.length; i++) {				
					 cniCgoClmBlDtlVOs[i].setCreUsrId(account.getUsr_id());
					 cniCgoClmBlDtlVOs[i].setUpdUsrId(account.getUsr_id());					
				 }
			 }
			 
			 if(cniCgoClmCntrDtlVOs!= null) {
				 for(int i=0; i<cniCgoClmCntrDtlVOs.length; i++) {				
					 cniCgoClmCntrDtlVOs[i].setCreUsrId(account.getUsr_id());
					 cniCgoClmCntrDtlVOs[i].setUpdUsrId(account.getUsr_id());					
				 }
			 }
			
			String manageStr = command.manageContractCarriage(cniCgoClmCtrtVO, cniCgoClmBlDtlVOs, cniCgoClmCntrDtlVOs);
			
			// 에러메세지설정
			if(manageStr.equals("N")){
				eventResponse.setETCData("MANAGE_STR", "N");//CNI00102 로 변경할 예정
				//There is no Claim No to Save
				eventResponse.setUserMessage(new ErrorHandler("CNI00022").getUserMessage());	
			}else{
				eventResponse.setETCData("MANAGE_STR", "Y");
				eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());			
			}
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * LiableParty  수정 ,입력<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category manageLiableParty 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContractCarriageBL(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		ClaimMainBC command = new ClaimMainBCImpl();

		CpsCni0010Event event = (CpsCni0010Event)e;
				
		try {			
			begin();
			
			String cgoClmNo = event.getCgoClmNo();
			 
			 CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs = event.getCniCgoClmBlDtlVOs();			 
				 
			 if(cniCgoClmBlDtlVOs!= null) {
				 for(int i=0; i<cniCgoClmBlDtlVOs.length; i++) {				
					 cniCgoClmBlDtlVOs[i].setCreUsrId(account.getUsr_id());
					 cniCgoClmBlDtlVOs[i].setUpdUsrId(account.getUsr_id());					
				 }
			 }
			 
			
			String manageStr = command.manageContractCarriageBL(cgoClmNo, cniCgoClmBlDtlVOs);
			
			// 에러메세지설정
			if(manageStr.equals("N")){
				eventResponse.setETCData("MANAGE_STR", "N");//CNI00102 로 변경할 예정
				//There is no Claim No to Save
				//eventResponse.setUserMessage(new ErrorHandler("CNI00022").getUserMessage());	
			}else{
				eventResponse.setETCData("MANAGE_STR", "Y");
				//eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());			
			}
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI-0014] Settlement Claim
	// ---------------------------------------------------------------------------	
	/**
	 * Settlement 정보 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0014
	 * @category searchSettlementInfo 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSettlementInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			SettlementClaimBC command = new SettlementClaimBCImpl();
	
			CpsCni0014Event event = (CpsCni0014Event)e;
			
			//param 
			String cgoClmNo = event.getCgoClmNo();
			
			List<SettlementVO> list = command.searchSettlementInfo(cgoClmNo);
			eventResponse.setRsVoList(list);
			
			//SESSION 에 CLAIM_NO 세팅. 조회결과가 있는 경우만 세팅함.
			if(list.size() > 0){
				CniUtil.setCargoClaimNo(account, cgoClmNo);
			}else{
				CniUtil.setCargoClaimNo(account, "");
			}
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * Settlement  수정 ,입력<br>
	 * @author 박제성
	 * @category CPS_CNI_0014
	 * @category manageSettlement 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSettlement(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		SettlementClaimBC command = new SettlementClaimBCImpl();
		ClaimMainBC command1 = new ClaimMainBCImpl(); 
		CodeMgtBC command2 = new CodeMgtBCImpl(); 

		CpsCni0014Event event = (CpsCni0014Event)e;
				
		try {			
			begin();
			
			CniSettlementVO cniSettlementVO = event.getCniSettlementVO();		
			String miscCd = cniSettlementVO.getClmMiscCd();
			String cgoClmStlTpCd = cniSettlementVO.getCgoClmStlTpCd();
			String clmStlAuthCd = cniSettlementVO.getClmStlAuthCd();
			
			cniSettlementVO.setUpdUsrId(account.getUsr_id());
			
			
			String manageStr = command.manageSettlement(cniSettlementVO);
			
			
			String cgoClmStlDt = cniSettlementVO.getCgoClmStlDt();
			String cgoClmStlUsdAmt = cniSettlementVO.getCgoClmStlUsdAmt();
			String lablPtyDmndUsdAmt = cniSettlementVO.getLablPtyDmndUsdAmt();
			String lablPtyRcvrUsdAmt = cniSettlementVO.getLablPtyRcvrUsdAmt();
			String insurRcvrUsdAmt = cniSettlementVO.getInsurRcvrUsdAmt();
			
			BigDecimal cgoClmStlUsdAmtDec = new BigDecimal(cgoClmStlUsdAmt);
			BigDecimal lablPtyDmndUsdAmtDec = new BigDecimal(lablPtyDmndUsdAmt);
			BigDecimal lablPtyRcvrUsdAmtDec = new BigDecimal(lablPtyRcvrUsdAmt);
			BigDecimal insurRcvrUsdAmtDec = new BigDecimal(insurRcvrUsdAmt);
			

			String cgoClmNo = cniSettlementVO.getCgoClmNo();
			CniCgoClmVO cniCgoClmVO = new CniCgoClmVO();
			cniCgoClmVO.setCgoClmNo(cgoClmNo);
			cniCgoClmVO.setUpdUsrId(account.getUsr_id());
			
			String cgoClmStsCd = "";
			
			if( (cgoClmStlDt.length()>=8) && (cgoClmStlUsdAmtDec.compareTo(new BigDecimal("0"))!=0) ) {
				
				if( miscCd.equals("V") && lablPtyDmndUsdAmtDec.compareTo(new BigDecimal("0"))==0 ) {
					
					cgoClmStsCd = "P";
					cniCgoClmVO.setCgoClmStsCd(cgoClmStsCd);					
					cniCgoClmVO.setCgoClmClzCd("O");					
					command1.modifyClaimStatus(cniCgoClmVO);
					
					// ---------------------------------------------
					// 상태변경 처리후  Status History에 이력정보 설정
					// ---------------------------------------------				
					HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
					handlerHistoryVO.setCgoClmNo(cgoClmNo);
					handlerHistoryVO.setUpdUsrId(account.getUsr_id());
					handlerHistoryVO.setCreUsrId(account.getUsr_id());				
					handlerHistoryVO.setHdlrOfcCd(account.getOfc_cd());
					handlerHistoryVO.setHdlrUsrId(account.getUsr_id());				
					command2.manageHandlerHistory(handlerHistoryVO, cgoClmStsCd);
				}
				
				if( (miscCd.equals("V")||miscCd.equals("P")) && lablPtyDmndUsdAmtDec.compareTo(new BigDecimal("0"))!=0 ) {
					
					cgoClmStsCd = "R";
					cniCgoClmVO.setCgoClmStsCd(cgoClmStsCd);					
					cniCgoClmVO.setCgoClmClzCd("O");					
					command1.modifyClaimStatus(cniCgoClmVO);	
					
					// ---------------------------------------------
					// 상태변경 처리후  Status History에 이력정보 설정
					// ---------------------------------------------				
					HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
					handlerHistoryVO.setCgoClmNo(cgoClmNo);
					handlerHistoryVO.setUpdUsrId(account.getUsr_id());
					handlerHistoryVO.setCreUsrId(account.getUsr_id());				
					handlerHistoryVO.setHdlrOfcCd(account.getOfc_cd());
					handlerHistoryVO.setHdlrUsrId(account.getUsr_id());				
					command2.manageHandlerHistory(handlerHistoryVO, cgoClmStsCd);
				}
				
				
				if( miscCd.equals("V")||miscCd.equals("P")||miscCd.equals("R") ) {
					
					if( cgoClmStlUsdAmtDec.compareTo(lablPtyRcvrUsdAmtDec.add(insurRcvrUsdAmtDec))<=0 ) {
											
						cgoClmStsCd = "C";
						cniCgoClmVO.setCgoClmStsCd(cgoClmStsCd);					
						cniCgoClmVO.setCgoClmClzCd("C");						
						command1.modifyClaimStatus(cniCgoClmVO);	
						
						// ---------------------------------------------
						// 상태변경 처리후  Status History에 이력정보 설정
						// ---------------------------------------------				
						HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
						handlerHistoryVO.setCgoClmNo(cgoClmNo);
						handlerHistoryVO.setUpdUsrId(account.getUsr_id());
						handlerHistoryVO.setCreUsrId(account.getUsr_id());				
						handlerHistoryVO.setHdlrOfcCd(account.getOfc_cd());
						handlerHistoryVO.setHdlrUsrId(account.getUsr_id());				
						command2.manageHandlerHistory(handlerHistoryVO, cgoClmStsCd);
					}
				}					
				
			}
			
						

			if( miscCd.equals("N")||miscCd.equals("F")||miscCd.equals("L")||miscCd.equals("R") ) {
				
				// cgo_clm_stl_tp_cd  가  RP, TD, TB, WD, DS 이면    CaseClose
				if( cgoClmStlTpCd.equals("RP")||cgoClmStlTpCd.equals("TD")||cgoClmStlTpCd.equals("TB")||cgoClmStlTpCd.equals("WD")||cgoClmStlTpCd.equals("DS") ) {
									
					cgoClmStsCd = "C";
					cniCgoClmVO.setCgoClmStsCd(cgoClmStsCd);					
					cniCgoClmVO.setCgoClmClzCd("C");
					command1.modifyClaimStatus(cniCgoClmVO);	
					
					// ---------------------------------------------
					// 상태변경 처리후  Status History에 이력정보 설정
					// ---------------------------------------------				
					HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
					handlerHistoryVO.setCgoClmNo(cgoClmNo);
					handlerHistoryVO.setUpdUsrId(account.getUsr_id());
					handlerHistoryVO.setCreUsrId(account.getUsr_id());				
					handlerHistoryVO.setHdlrOfcCd(account.getOfc_cd());
					handlerHistoryVO.setHdlrUsrId(account.getUsr_id());				
					command2.manageHandlerHistory(handlerHistoryVO, cgoClmStsCd);
				}
				
				//  cgo_clm_stl_tp_cd== CM, PD 이면    STS=A
				if( cgoClmStlTpCd.equals("CM")||cgoClmStlTpCd.equals("PD") ) {
					
					if(!clmStlAuthCd.equals("Y")) {
						
						cgoClmStsCd = "A";
						cniCgoClmVO.setCgoClmStsCd(cgoClmStsCd);					
						cniCgoClmVO.setCgoClmClzCd("O");					
						command1.modifyClaimStatus(cniCgoClmVO);	
						
						// ---------------------------------------------
						// 상태변경 처리후  Status History에 이력정보 설정
						// ---------------------------------------------				
						HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
						handlerHistoryVO.setCgoClmNo(cgoClmNo);
						handlerHistoryVO.setUpdUsrId(account.getUsr_id());
						handlerHistoryVO.setCreUsrId(account.getUsr_id());				
						handlerHistoryVO.setHdlrOfcCd(account.getOfc_cd());
						handlerHistoryVO.setHdlrUsrId(account.getUsr_id());				
						command2.manageHandlerHistory(handlerHistoryVO, cgoClmStsCd);
				
					}
				}
				
			}
			// Applied 처리 로직 추가 -- 2010.05.10 JBLEE 
			if( miscCd.equals("A") ) {
				
				// cgo_clm_stl_tp_cd  가  RP, TD, TB, WD, DS 이면    CaseClose
				if( cgoClmStlTpCd.equals("RP")||cgoClmStlTpCd.equals("TD")||cgoClmStlTpCd.equals("TB")||cgoClmStlTpCd.equals("WD")||cgoClmStlTpCd.equals("DS") ) {
									
					cgoClmStsCd = "C";
					cniCgoClmVO.setCgoClmStsCd(cgoClmStsCd);					
					cniCgoClmVO.setCgoClmClzCd("C");
					command1.modifyClaimStatus(cniCgoClmVO);	
					
					// ---------------------------------------------
					// 상태변경 처리후  Status History에 이력정보 설정
					// ---------------------------------------------				
					HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
					handlerHistoryVO.setCgoClmNo(cgoClmNo);
					handlerHistoryVO.setUpdUsrId(account.getUsr_id());
					handlerHistoryVO.setCreUsrId(account.getUsr_id());				
					handlerHistoryVO.setHdlrOfcCd(account.getOfc_cd());
					handlerHistoryVO.setHdlrUsrId(account.getUsr_id());				
					command2.manageHandlerHistory(handlerHistoryVO, cgoClmStsCd);
				}				
			}

			// 에러메세지설정
			if(manageStr.equals("N")){
				eventResponse.setETCData("MANAGE_STR", "N");//CNI00102 로 변경할 예정
				//There is no Claim No to Save
				eventResponse.setUserMessage(new ErrorHandler("CNI00022").getUserMessage());	
			}else{
				eventResponse.setETCData("MANAGE_STR", "Y");
				eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());			
			}
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Settlement  수정 ,입력<br>
	 * @author 박제성
	 * @category CPS_CNI_0014
	 * @category manageCancel 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCancel(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		 
		// BC 객체 생성
		SettlementClaimBC command = new SettlementClaimBCImpl();
		ClaimMainBC command1 = new ClaimMainBCImpl(); 
		CodeMgtBC command2 = new CodeMgtBCImpl(); 

		CpsCni0014Event event = (CpsCni0014Event)e;
				
		try {
			
			begin();
			
			CniSettlementVO cniSettlementVO = event.getCniSettlementVO();
			
			String miscCd = cniSettlementVO.getClmMiscCd();
			String cgoClmNo = cniSettlementVO.getCgoClmNo();
			
			//cniSettlementVO.setCreUsrId(account.getUsr_id());
			cniSettlementVO.setUpdUsrId(account.getUsr_id());	
			
			
			//////////////////////////////////////////////////
			// CANCEL
			/////////////////////////////////////////////////
			if( miscCd.equals("A") ) {
							
				// ---------------------------------------------
				//  Status 전상태 로 변경
				// ---------------------------------------------
				//CniCgoClmVO cniCgoClmVO = new CniCgoClmVO();				
				//cniCgoClmVO.setUpdUsrId(account.getUsr_id());
				//cniCgoClmVO.setCgoClmNo(cgoClmNo);				
				//cniCgoClmVO.setCgoClmStsCd("P");					
				//cniCgoClmVO.setCgoClmClzCd("O");
				//command1.modifyClaimStatus(cniCgoClmVO);
				
				command1.modifyClaimPreStatus(cgoClmNo,account.getUsr_id());
				
				
				// ---------------------------------------------
				// 상태변경 처리후  Status History에 이력정보 설정
				// ---------------------------------------------				
				HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
				handlerHistoryVO.setCgoClmNo(cgoClmNo);
				handlerHistoryVO.setUpdUsrId(account.getUsr_id());
				handlerHistoryVO.setCreUsrId(account.getUsr_id());			
				
				handlerHistoryVO.setHdlrOfcCd(account.getOfc_cd());
				handlerHistoryVO.setHdlrUsrId(account.getUsr_id());
				//신규 status 취득
				String status = command1.searchClaimStatus(cgoClmNo);
				command2.manageHandlerHistory(handlerHistoryVO, status);
			}
			
			// ---------------------------------------------
			// Null 처리   cgo_clm_stl_tp_cd, cgo_clm_stl_dt,cgo_clm_stl_locl_amt,	cgo_clm_stl_locl_curr_cd
			// 	cgo_clm_stl_xch_rt, cgo_clm_stl_usd_amt
			// ---------------------------------------------	
			
			cniSettlementVO.setCgoClmStlTpCd("");    
			cniSettlementVO.setCgoClmStlDt("");
			cniSettlementVO.setCgoClmStlLoclAmt("0");
			cniSettlementVO.setCgoClmStlLoclCurrCd("");
			cniSettlementVO.setCgoClmStlXchRt("0");
			cniSettlementVO.setCgoClmStlUsdAmt("0");
			
			command.manageSettlement(cniSettlementVO);
			
			cniSettlementVO.setClmStlApplDt("");
			cniSettlementVO.setClmStlApplUsrId("");
			cniSettlementVO.setClmStlApplOfcCd("");
			
			command.modifyClaimCancel(cniSettlementVO);	
			
			eventResponse.setUserMessage(new ErrorHandler("CNI00115").getUserMessage());
		
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Settlement Open<br>
	 * @author 박제성
	 * @category CPS_CNI_0014
	 * @category searchSettlementOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSettlementOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			//Type Of Surveyor
			List<MiscellaneousVO> miscCodeList1 = command.searchMiscellaneousList("07");
			eventResponse.setRsVoList(miscCodeList1);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * Settlement Application gw open<br>
	 * @author 진윤오
	 * @category CPS_CNI_0014
	 * @category manageApplication 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageApplication(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			
			//그룹웨어 URL주소
			String gwUrl= "";
			
			// BC 객체 생성
			SettlementClaimBC command = new SettlementClaimBCImpl();

			CpsCni0014Event event = (CpsCni0014Event)e;
			
			CniSettlementVO vo  = event.getCniSettlementVO();			
			
			//claim no 
			String cgoClmNo = vo.getCgoClmNo();
			
			String smnsSveDt = vo.getSmnsSveDt();
			smnsSveDt = CniUtil.getFmtDt(smnsSveDt);
			//소송건
			if (smnsSveDt != null && smnsSveDt.length() == 8) {				
				gwUrl = command.sendGwCargoLitigationInfo(cgoClmNo, account.getUsr_id());
			//소송건 이외
			} else {
				gwUrl = command.sendGwCargoClaimInfo(cgoClmNo,  account.getUsr_id());
			}
			
			if (gwUrl == null) {
				gwUrl = "";
			}
			
			eventResponse.setETCData("GW_URL", gwUrl);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}	
	
	
	/**
	 * Gw Status 정보 수정 EAI에서 수신<br>
	 * @author 진윤오
	 * @category COM005R001
	 * @category manageGwStatus 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGwStatus(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			
			// BC 객체 생성
			SettlementClaimBC command = new SettlementClaimBCImpl();

			CpsCni0014Event event = (CpsCni0014Event)e;
			
			GwApproveStatusVO vo  = event.getGwApproveStatusVO();			
			
			// BC 객체 생성
			ClaimMainBC command1 = new ClaimMainBCImpl(); 
			CodeMgtBC command2 = new CodeMgtBCImpl();
			
			// -------------------------------------------
			// Settlment GW Auth 상태 변경 
			// 주의 사용자 아이디는 account에서 취득 할수 없음.. 
			// -------------------------------------------
			//GMT 조회조건의 날짜
			String curDate = command2.searchGmtDate(vo.getUpdUsrId());
			curDate = CniUtil.getFmtDt(curDate);
			vo.setUpdDt(curDate);			
			command.manageGwStatus(vo);
			
			
			// -------------------------------------------
			// Claim 상태 변경 
			// -------------------------------------------			
			
			// ---------------------------------------------
			// GW 승인여부  - clmStlAuthCd
			// --------------------------------------------
			// C (CANCLE)       : EP내에서 결재 상신을 하기 전에 취소 or 삭제.
			// N (REJECT)        : 결재 상신 후 반송
			// Y (COMPLETE)  : 결재 완료.
			// P (Pending) - GW Draft Box에 저장 or 정상기안 , 최초 기안시
			
			String clmStlAuthCd = vo.getClmStlAuthCd();
			
			if ("N".equals(clmStlAuthCd) || "Y".equals(clmStlAuthCd)) {

				String cgoClmNo = vo.getCgoClmNo();
				CniCgoClmVO cniCgoClmVO = new CniCgoClmVO();			
				cniCgoClmVO.setUpdUsrId(vo.getUpdUsrId());
				cniCgoClmVO.setCgoClmNo(cgoClmNo);
				cniCgoClmVO.setCgoClmClzCd("O");	
				
				if ("N".equals(clmStlAuthCd)) {	
					// status ==> R reject
					cniCgoClmVO.setCgoClmStsCd("J");
				} else if ("Y".equals(clmStlAuthCd)) {
					// status ==> V Approve
					cniCgoClmVO.setCgoClmStsCd("V");
				}
				
				command1.modifyClaimStatus(cniCgoClmVO);
				// ---------------------------------------------
				// 상태변경 처리후  Status History에 이력정보 설정
				// ---------------------------------------------				
				HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
				handlerHistoryVO.setCgoClmNo(cgoClmNo);
				handlerHistoryVO.setUpdUsrId(vo.getUpdUsrId());
				handlerHistoryVO.setCreUsrId(vo.getUpdUsrId());			
				
				CniCgoClmVO cniClmVO = command1.searchCargoClaim(cgoClmNo);				
				String hdlrOfcCd = "";				
				if (cniCgoClmVO != null) {
					hdlrOfcCd = cniClmVO.getHdlrOfcCd();
				}
				
				handlerHistoryVO.setHdlrOfcCd(hdlrOfcCd);
				handlerHistoryVO.setHdlrUsrId(vo.getUpdUsrId());
				//신규 status 취득
				String status = command1.searchClaimStatus(cgoClmNo);
				command2.manageHandlerHistory(handlerHistoryVO, status);
				
			}
			
			eventResponse.setETCData("ERROR", "N");
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}		
	
	/**
	 * ContractCarriage BookingNo 정보 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageBookingNoInfo 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractCarriageBookingNoInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
	
			CpsCni0010Event event = (CpsCni0010Event)e;
			
			//param 
			String blNo = event.getBlNo();
			
			BookingNoVO vo = command.searchBookingNoInfo(blNo);
			eventResponse.setRsVo(vo);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
}// End of class