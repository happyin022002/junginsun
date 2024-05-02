/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtSC.java
*@FileTitle : Load Reject Reason (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.04.28 이도형
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2012.01.17 서석진 [CHM-201115272] RSO 설정및 지역 본부 hard coding 로직 수정 요청
* 처리내역 :RHQ1,RHQ2 GRID 클릭시 콤보박스형태로 조회후 선택하여 저장,수정 할수있게 UI,로직 수정
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBC;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBCImpl;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.basic.CarrierRestrictionBC;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.basic.CarrierRestrictionBCImpl;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.event.VopScg0079Event;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.FileVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.basic.SpecialCargoMasterDataMgtBC;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.basic.SpecialCargoMasterDataMgtBCImpl;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0031Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0032Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0033Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0034Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0035Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0036Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0037Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0039Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0040Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0041Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0042Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0043Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0044Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0045Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0046Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0047Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0049Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0051Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0053Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0066Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0067Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0070Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0073Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0077Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0080Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0083Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0084Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0103Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg010301Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg010302Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg010303Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg010305Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg010306Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg010307Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0104Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0105Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0106Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0107Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0108Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0109Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0112Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0113Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.GetLoadingPortRsoVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.MdmVslSvcLaneListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgGuidanceVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgPckInstrVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgSpclProvisVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgUnNoOrgRactVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgMailTampletVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckCreationVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguImgVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguPkgCdVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguPkgIbcCdVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchIrregularTypeCodeListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchLoadingPortRsoVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchRsoComboListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.VopScg0070VO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.RsltCdListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgNonDgCgoKwVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgChemicalHistoryVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgChemHistoryFileVO;
import com.hanjin.syscommon.common.table.ScgCdVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0082Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ScgCntcPntPolVO;
import com.hanjin.syscommon.common.table.ScgCntcPntVO;
import com.hanjin.syscommon.common.table.ScgImdgAbbrVO;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgExptQtyVO;
import com.hanjin.syscommon.common.table.ScgImdgMrnPolutVO;
import com.hanjin.syscommon.common.table.ScgImdgPckCdVO;
import com.hanjin.syscommon.common.table.ScgImdgPckGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrSymVO;
import com.hanjin.syscommon.common.table.ScgImdgSpclProviVO;
import com.hanjin.syscommon.common.table.ScgImdgTnkTpVO;
import com.hanjin.syscommon.common.table.ScgLodRjctCdVO;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;
import com.hanjin.syscommon.common.table.ScgPckInstrVO;
import com.hanjin.syscommon.common.table.ScgPckGasReguVO;
import com.hanjin.syscommon.common.table.ScgPckPkgVO;
import com.hanjin.syscommon.common.table.ScgPckPtbTnkVO;
import com.hanjin.syscommon.common.table.ScgPckRefVO;
import com.hanjin.syscommon.common.table.ScgPckReguPkgOrgPrxVO;
import com.hanjin.syscommon.common.table.ScgPckReguVO;
import com.hanjin.syscommon.common.table.ScgSpclPckProviVO;


/**
 * ALPS-SpecialCargoMasterDataMgt Business Logic ServiceCommand - ALPS-SpecialCargoMasterDataMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Dohyoung Lee 
 * @see SpecialCargoMasterDataMgtDBDAO
 * @since J2EE 1.4
 */

public class SpecialCargoMasterDataMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SpecialCargoMasterDataMgt system 업무 시나리오 선행작업<br>
	 * VOP_SCG-0031업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * SpecialCargoMasterDataMgt system 업무 시나리오 마감작업<br>
	 * VOP_SCG-0031 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SpecialCargoMasterDataMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SpecialCargoMasterDataMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopScg0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLoadRejectReasonCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLoadRejectReasonCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRegionalShipOperatorCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRHQOfficeList();
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRegionalShipOperatorCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPartnerLineContactPointList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSpclCgoRsoList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePartnerLineContactPoint(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIrregularTypeCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageIrregularTypeCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchClassDefinitionList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageClassDefinition(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMarinePollutantCodeList(e);
			}                   
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMarinePollutantCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingGroupCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePackingGroupCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpecialProvisionList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSpecialProvision(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0043Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePackingCode(e);
			}
			//2013.05.16 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComCodeList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIMOTankTypeCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageIMOTankTypeCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDGAbbreviationCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDGAbbreviationCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0046Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNumberNSymbolCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageNumberNSymbolCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCompatibilityGroupCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCompatibilityGroupCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0063Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDGAbbreviationCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDGAbbreviationCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0067Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExceptedQuantityCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageExceptedQuantityCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0070Event")) {	//Segregation Groups (Creation)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSegregationGroupList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSegregationGroupList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSegregationGroupList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSegregationGroup(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLoadingPortRSOList(e);
			}
			/**
			 * 콤보조회
			 */
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRsoList(e);

			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				 eventResponse = manageLoadingPortRSO(e);
			}			
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				 eventResponse = searchLoadingPortRSO(e);				   
			}	
 		
 			
		}else if (e.getEventName().equalsIgnoreCase("VopScg0051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLoadingPortRSOListForInQuiry(e);
			}
			/**
			 * 콤보조회
			 */
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRsoListForInQuiry(e);
			}			
		}else if (e.getEventName().equalsIgnoreCase("VopScg0035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchApprovalTargetLaneList(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchApprovalTargetLane(e);
			}			
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageApprovalTargetLane(e);
			}		
 		
		}else if (e.getEventName().equalsIgnoreCase("VopScg0042Event")) {	//Packing Instructions/Provisions (Creation)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingInstructionList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				 eventResponse = managePackingInstruction(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("VopScg0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchApprovalTargetLaneList(e,"VopScg0053Event");
			}
	        /**********************************************************************
	         * @author JKC 
	         *********************************************************************/ 		
		}else if (e.getEventName().equalsIgnoreCase("VopScg0049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLoadRejectReasonCodeList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0066Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchOrganicPeroxideCodeList(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("VopScg0073Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchSpecialProvisionSegregationList(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchSubsidiaryRisks(e);
            }            
 
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageSpecialProvisionSegregationList(e);
            }                   
        }else if (e.getEventName().equalsIgnoreCase("VopScg0077Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSCGMailTamplet(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCGMailTamplet(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScgGuidMsg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchScgGuidDtlFile(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageScgGuidMsg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageScgGuidDtl(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0082Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScgCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageScgCode(e);
			}	
		}else if (e.getEventName().equalsIgnoreCase("VopScg0083Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScgNonDgCgoList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageScgNonDgCgoKwList(e);
			}	
		}else if (e.getEventName().equalsIgnoreCase("VopScg0084Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScgChemicalHistory(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageScgChemicalHistory(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0109Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScgChemHistoryAnswer(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageScgChemHistoryAnswer(e);
			}	
		}else if (e.getEventName().equalsIgnoreCase("VopScg0112Event")) {

    			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
    				eventResponse = searchChemFileList(e);
    			}
    			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
   				 eventResponse = manageFile(e);
   			    } 
    	    
		}else if (e.getEventName().equalsIgnoreCase("VopScg0103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePackingInstructionCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingInstructionCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = initUOMComboData(e);				
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePackingInstructionRegulationPackagingCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingInstructionRegulationPackagingCodeList(e);
			} else  if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCodeList(e);
			} else  if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = checkPkgCd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0105Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComCodeList(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPackingInstructionRegulationPackagingIbcCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
			eventResponse = searchPackingIbcCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = managePackingInstructionRegulationPackagingIbcCodeList(e);
			}	
		}else if (e.getEventName().equalsIgnoreCase("VopScg0106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePackingInstructionRegulationOrganicPeroxideList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingInstructionRegulationOrganicPeroxideList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0107Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPackingInstructionRegulationPKGMethodList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = managePackingInstructionRegulationPKGMethodList(e);
			}			
		}else if (e.getEventName().equalsIgnoreCase("VopScg0108Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				log.debug("\n VopScg0108Event SC in ");
				eventResponse = managePackingInstructionRegulationImgList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingInstructionRegulationImgList(e);
			}	
		}else if (e.getEventName().equalsIgnoreCase("VopScg010301Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePackingInstructionRegulation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingInstructionRegulation(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg010302Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePackingInstructionCombinePackaging(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingInstructionCombinePackaging(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = initPkgMtrlTpCdComboData(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkPkgCd(e);				
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg010303Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePackingInstructionSinglePackaging(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingInstructionSinglePackaging(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg010305Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePackingInstructionSpclProvi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingInstructionSpclProvi(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg010306Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePackingInstructionGasRegulation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingInstructionGasRegulation(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg010307Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePackingInstructionPortableTank(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingInstructionPortableTank(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0113Event")){
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePartnerContactPointPol(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPartnerContactPointPolList(e); 
			}
		}
		return eventResponse;
	}
	
	/**
	 * Load Reject Reason  : Retrieve <br>
	 * Load Reject Reason을 조회 합니다. <br>
	 * 
	 * @param Event e 
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchLoadRejectReasonCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		
    		List<ScgLodRjctCdVO> list = null;
    	    if ( e.getEventName().equalsIgnoreCase("VopScg0031Event")) {
    			VopScg0031Event event = (VopScg0031Event)e;
    			list = command.searchLoadRejectReasonCodeList(event.getScgLodRjctCdVO());
    	    }
    	    if ( e.getEventName().equalsIgnoreCase("VopScg0049Event")) {
    			VopScg0049Event event = (VopScg0049Event)e;	    
    			list = command.searchLoadRejectReasonCodeList(event.getScgLodRjctCdVO());			
    	    }
     	
    		
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Load Reject Reason"}).getMessage(), ex);
        }
	}
	
	/**
	 * Load Reject Reason   : Save <br>
	 * Load Reject Reason을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageLoadRejectReasonCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0031Event event = (VopScg0031Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();			
			command.manageLoadRejectReasonCode(event.getScgLodRjctCdVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Load Reject Reason"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0032  : Retrieve <br>
	 * SPCL CGO RSO을 조회 합니다. <br>
	 * 
	 * @param Event e 
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRegionalShipOperatorCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0032Event event = (VopScg0032Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgRgnShpOprCdVO> list = command.searchRegionalShipOperatorCodeList(event.getScgRgnShpOprCdVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0032  : Save <br>
	 * SPCL CGO RSO을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param Event e 
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageRegionalShipOperatorCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0032Event event = (VopScg0032Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageRegionalShipOperatorCode(event.getScgRgnShpOprCdVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
        }
        
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0034  : Retrieve <br>
	 * Partner's Contact Point for SPCL CGO 을 조회 합니다. <br>
	 * 
	 * @param Event e 
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPartnerLineContactPointList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0034Event event = (VopScg0034Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgCntcPntVO> list = command.searchPartnerLineContactPointList(event.getScgCntcPntVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner's Contact Point for SPCL CGO"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0034  : OnLoad <br>
	 * RSO을 조회 합니다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSpclCgoRsoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//VopScg0034Event event = (VopScg0034Event)e;
	    try{
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgRgnShpOprCdVO> list = command.searchSpclCgoRsoList();
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner's Contact Point for SPCL CGO"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0034  : Save <br>
	 * Partner's Contact Point for SPCL CGO 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param Event  e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse managePartnerLineContactPoint(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0034Event event = (VopScg0034Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.managePartnerLineContactPoint(event.getScgCntcPntVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Partner's Contact Point for SPCL CGO"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0036  : Retrieve <br>
	 * SPCL CGO Irregular Type 을 조회 합니다. <br>
	 * 
	 * @param Event e 
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchIrregularTypeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0036Event event = (VopScg0036Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<SearchIrregularTypeCodeListVO> list = command.searchIrregularTypeCodeList(event.getSearchIrregularTypeCodeListVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Irregular Type"}).getMessage(), ex);
        }
	}
	/**
	 * VOP_SCG_0036  : Save <br>
	 * SPCL CGO Irregular Type 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageIrregularTypeCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0036Event event = (VopScg0036Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageIrregularTypeCode(event.getSearchIrregularTypeCodeListVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Irregular Type"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0037  : Retrieve <br>
	 * Definition of Class  을 조회 합니다. <br>
	 * 
	 * @param   Event e 
	 * @return  EventResponseresponse 
	 * @exception EventException
	 */
	private EventResponse searchClassDefinitionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0037Event event = (VopScg0037Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgClssCdVO> list = command.searchClassDefinitionList(event.getScgImdgClssCdVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Definition of Class"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0037  : Save <br>
	 * Definition of Class  을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageClassDefinition(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0037Event event = (VopScg0037Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		//IMDGCodeMgtBC imdgCommand = new IMDGCodeMgtBCImpl();
		try{
			begin();
			
			command.manageClassDefinition(event.getScgImdgClssCdVOS(), account);
			//imdgCommand.sendScgImdgClssCd( Arrays.asList(event.getScgImdgClssCdVOS()), null);  //D-CUBE (EAI) I/F 사용 보류
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Definition of Class"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0039  : Retrieve <br>
	 * Marine Pollutant 을 조회 합니다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMarinePollutantCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0039Event event = (VopScg0039Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgMrnPolutVO> list = command.searchMarinePollutantCodeList(event.getScgImdgMrnPolutVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Marine Pollutant"}).getMessage(), ex);
        }
	}
	/**
	 * VOP_SCG_0039  : Save <br>
	 * Marine Pollutant 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMarinePollutantCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0039Event event = (VopScg0039Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageMarinePollutantCode(event.getScgImdgMrnPolutVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Marine Pollutant"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0040  : Retrieve <br>
	 * Packing Group 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPackingGroupCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0040Event event = (VopScg0040Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgPckGrpVO> list = command.searchPackingGroupCodeList(event.getScgImdgPckGrpVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Group"}).getMessage(), ex);
        }
	}
	/**
	 * VOP_SCG_0040  : Save <br>
	 * Packing Group 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePackingGroupCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0040Event event = (VopScg0040Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.managePackingGroupCode(event.getScgImdgPckGrpVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0041  : Retrieve <br>
	 * Special Provisions  을 조회 합니다. <br>
	 * 
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSpecialProvisionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0041Event event = (VopScg0041Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgSpclProviVO> list = command.searchSpecialProvisionList(event.getScgImdgSpclProviVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions"}).getMessage(), ex);
        }		
	}
	/**
	 * VOP_SCG_0041  : Save <br>
	 * Special Provisions  을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageSpecialProvision(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0041Event event = (VopScg0041Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageSpecialProvision(event.getScgImdgSpclProviVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Provisions"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0043  : Retrieve <br>
	 * Packaging Code 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPackingCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0043Event event = (VopScg0043Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgPckCdVO> list = command.searchPackingCodeList(event.getScgImdgPckCdVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packaging Code"}).getMessage(), ex);

        }		
	}

	/**
	 * VOP_SCG_0043  : Save <br>
	 * Packaging Code 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse managePackingCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0043Event event = (VopScg0043Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		//IMDGCodeMgtBC imdgCommand = new IMDGCodeMgtBCImpl();
		try{
			begin();
			
			command.managePackingCode(event.getScgImdgPckCdVOS(),account);
			//imdgCommand.sendScgImdgPckCd( Arrays.asList(event.getScgImdgPckCdVOS()), null);   //D-CUBE (EAI) I/F 사용 보류
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Packaging Code"}).getMessage(), ex);

        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0044  : Retrieve <br>
	 * IMO Type Portable Tanks을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIMOTankTypeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0044Event event = (VopScg0044Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgTnkTpVO> list = command.searchIMOTankTypeCodeList(event.getScgImdgTnkTpVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMO Type Portable Tanks"}).getMessage(), ex);
        }		
	}
	/**
	 * VOP_SCG_0044  : Save <br>
	 * IMO Type Portable Tanks을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageIMOTankTypeCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0044Event event = (VopScg0044Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageIMOTankTypeCode(event.getScgImdgTnkTpVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IMO Type Portable Tanks"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_SCG_0045  : Retrieve <br>
	 * DG Abbreviation을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDGAbbreviationCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0045Event event = (VopScg0045Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgAbbrVO> list = command.searchDGAbbreviationCodeList(event.getScgImdgAbbrVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG Abbreviation"}).getMessage(), ex);
        }		
	}
	/**
	 * VOP_SCG_0045  : Save <br>
	 * DG Abbreviation을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDGAbbreviationCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0045Event event = (VopScg0045Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageDGAbbreviationCode(event.getScgImdgAbbrVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"DG Abbreviation"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_SCG_0046  : Retrieve <br>
	 * No. & Symbols in SEG Table/Mixed STWG 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNumberNSymbolCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0046Event event = (VopScg0046Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgSegrSymVO> list = command.searchNumberNSymbolCodeList(event.getScgImdgSegrSymVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"No. & Symbols in SEG Table/Mixed STWG"}).getMessage(), ex);
        }		
	}
	/**
	 * VOP_SCG_0046  : Save <br>
	 * No. & Symbols in SEG Table/Mixed STWG 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param Event e 
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageNumberNSymbolCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0046Event event = (VopScg0046Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageNumberNSymbolCode(event.getScgImdgSegrSymVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"No. & Symbols in SEG Table/Mixed STWG"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_SCG_0047  : Retrieve <br>
	 * Compatibility Groups of Class 1을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCompatibilityGroupCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0047Event event = (VopScg0047Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgCompGrpVO> list = command.searchCompatibilityGroupCodeList(event.getScgImdgCompGrpVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Compatibility Groups of Class"}).getMessage(), ex);
        }		
	}
	/**
	 * VOP_SCG_0047  : Save <br>
	 * Compatibility Groups of Class 1을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageCompatibilityGroupCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0047Event event = (VopScg0047Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageCompatibilityGroupCode(event.getScgImdgCompGrpVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Compatibility Groups of Class"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_SCG_0067  : Retrieve <br>
	 * Excepted Quantities을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExceptedQuantityCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0067Event event = (VopScg0067Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgExptQtyVO> list = command.searchExceptedQuantityCodeList(event.getScgImdgExptQtyVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Excepted Quantities"}).getMessage(), ex);
        }		
	}
	/**
	 * VOP_SCG_0067  : Save <br>
	 * Excepted Quantities을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExceptedQuantityCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0067Event event = (VopScg0067Event)e;
 
		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageExceptedQuantityCode(event.getScgImdgExptQtyVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Excepted Quantities"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_SCG-0070 : Retrieve <br>
	 * Segregation Groups (Creation) 을 조회 합니다.<br>
	 * 
	 * @param     Event e 
	 * @return    EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSegregationGroupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0070Event event = (VopScg0070Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		
    		VopScg0070VO vopScg0070VO = command.searchSegregationGroupList(event.getScgImdgSegrGrpVO(), event.getScgImdgSegrGrpDtlVO(), e.getFormCommand());
    		
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		
    		if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
    			eventResponse.setRsVoList(vopScg0070VO.getScgImdgSegrGrpVOL());
    		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
    			eventResponse.setRsVoList(vopScg0070VO.getScgImdgSegrGrpDtlVOL());
    		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
    			eventResponse.setRsVoList(vopScg0070VO.getScgImdgSegrGrpDtlVOL());
    		}			
    		
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Segregation Groups"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG-0070 : Save <br>
	 * Segregation Groups (Creation) 을 저장 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSegregationGroup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0070Event event = (VopScg0070Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			VopScg0070VO vopScg0070VO = new VopScg0070VO(event.getScgImdgSegrGrpVOS(), event.getScgImdgSegrGrpDtlVOS());
			command.manageSegregationGroup(vopScg0070VO, account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Segregation Groups"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_SCG-0033: onchagne <br>
     * Loading Port for RSO 내용을 조회한다.
	 *  
	 * @param  Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */

	private EventResponse searchLoadingPortRSOList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0033Event event = (VopScg0033Event)e;  
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<SearchLoadingPortRsoVO> list       = command.searchLoadingPortRSOList( event.getSearchRsoComboListVO() );
    		
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);

    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{" Loading Port for RSO"}).getMessage(), ex);
        }
	}
	/**
	 * VOP_SCG-0051: RETRIEVE <br>
	 * Loading Port for RSO 를 조회한다. 
	 * 
	 * @param  Event e
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */

	private EventResponse searchLoadingPortRSOListForInQuiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0051Event event = (VopScg0051Event)e;  
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<SearchLoadingPortRsoVO> list       = command.searchLoadingPortRSOList( event.getSearchRsoComboListVO() );
    		
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
     
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Loading Port for RSO"}).getMessage(), ex);
        }
	}	
  	/**
     * VOP_SCG_0051 : SEARCH
	 * SpecialCargoMasterDataMgtDBDAO의 Loading Port for RSO 조회 콤보 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRsoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// VopScg0033Event event = (VopScg0033Event)e;
	    try{
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<SearchRsoComboListVO> rsolist   = command.searchRsoList( );		
    		
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		StringBuffer str = new StringBuffer();
    		for(int i=0;i<rsolist.size();i++){
    			 str.append( ((SearchRsoComboListVO)rsolist.get(i)).getRso()+"%" );
    		}
     
    		Map<String,String> etcData = new HashMap<String,String>();
    		etcData.put("cmbRso", str.toString() );
    		eventResponse.setETCData(etcData);
     
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Loading Port for RSO"}).getMessage(), ex);
        }
	}	
	 
	  	/**
		 * VOP_SCG_0051 : RETRIEVE
		 * Loading Port for RSO 조회한다.
		 * 
		 * @param  Event e 
		 * @return  EventResponse
		 * @throws EventException
		 */
		private EventResponse searchRsoListForInQuiry(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			// VopScg0051Event event = (VopScg0051Event)e;
		    try{
    			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    			List<SearchRsoComboListVO> rsolist   =  command.searchRsoList( );		
    			
    			GeneralEventResponse eventResponse = new GeneralEventResponse();
    			StringBuffer str = new StringBuffer();
    			for(int i=0;i<rsolist.size();i++){
    				 str.append( ((SearchRsoComboListVO)rsolist.get(i)).getRso()+"%" );
    			}
    	 
    			Map<String,String> etcData = new HashMap<String,String>();
    			etcData.put("cmbRso", str.toString() );
    			eventResponse.setETCData(etcData);
    	 
    			return eventResponse;
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Loading Port for RSO"}).getMessage(), ex);
            }
		}
		 
		/**
         * VOP_SCG-0033 : Save  <br>
         * Loading Port for RSO 내용을 저장.
         * 
		 * @param e Event
		 * @return response EventResponse
		 * @exception EventException
		 * @author jkc
		 */
		 private EventResponse manageLoadingPortRSO(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VopScg0033Event event = (VopScg0033Event)e;

			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
			try{
				begin();
				
				command.manageLoadingPortRSO(event.getScgRgnShpOprPortListVOs() ,account);
 
	            eventResponse.setUserMessage(  new ErrorHandler("SCG00001", new String[]{"Data"} ).getUserMessage() );
				commit();
	        } catch (EventException ex) {
	            log.error("error:"+ex.toString(), ex);
	            rollback();
	            throw new EventException(ex.getMessage(), ex);
	        } catch (Exception ex) {
	            log.error("error:"+ex.toString(), ex);
	            rollback();
	            throw new EventException(new ErrorHandler("COM12192", new String[]{"Loading Port for RSO"}).getMessage(), ex);

	        }
			return eventResponse;
		}	 
		/**
		 * VOP_SCG-0033 : retrieve <br>
         * Loading Port for RSO 내용을 조회한다.
		 * 
		 * @param     Event e
		 * @return    EventResponse response
		 * @exception EventException
		 */		
		private EventResponse searchLoadingPortRSO(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
		    try{
    			VopScg0033Event event = (VopScg0033Event)e;  
    			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    			List<GetLoadingPortRsoVO>  rso    = command.searchLoadingPortRSO((String)event.getAttribute("loc_cd"));	
    			
    			GeneralEventResponse eventResponse = new GeneralEventResponse();
    			StringBuffer str = new StringBuffer();
    			if(rso.size() > 0){
                    str.append( ((GetLoadingPortRsoVO)rso.get(0)).getLocCd()+"|"  );
                    str.append( ((GetLoadingPortRsoVO)rso.get(0)).getRgnShpOprCd()+"|");
                    str.append( ((GetLoadingPortRsoVO)rso.get(0)).getCntNm()+"|"  );
                    str.append( ((GetLoadingPortRsoVO)rso.get(0)).getLocNm()+"|"  );
                }else{
                    eventResponse.setUserMessage(new ErrorHandler("SCG50010",new  String[]{"Port Code"} ).getUserMessage());                
                }
    			Map<String,String> etcData = new HashMap<String,String>();
    			etcData.put("loc_info", str.toString() );
    			eventResponse.setETCData(etcData);
    			return eventResponse;
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Loading Port for RSO"}).getMessage(), ex);
            }

		}		
		/**
		 * VOP_SCG-0035 : RETRIEVE<br>
		 * Target Lane for SPCL CGO APVL 내용을 조회 한다.
		 * 
		 * @param  Event e
		 * @return EventResponse  
		 * @exception EventException
		 */

		private EventResponse searchApprovalTargetLaneList(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
		    try{
    			VopScg0035Event event = (VopScg0035Event)e;  
    			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    			List<MdmVslSvcLaneListVO> list       = command.searchApprovalTargetLaneList( event.getMdmVslSvcLaneListVO() );
    			
    			GeneralEventResponse eventResponse = new GeneralEventResponse();
    			eventResponse.setRsVoList(list);
//    			if(list.size()==0){
//    			    eventResponse.setUserMessage(new ErrorHandler("SCG00008").getUserMessage());
//    			    //eventResponse.setUserMessage( "데이타가 존재하지 않습니다.");			
//    			}
    			return eventResponse;
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Target Lane for SPCL CGO APVL"}).getMessage(), ex);
            }
		}	
		/**
		 * VOP_SCG-0053:RETRIEVE<br>
         * Target Lane for SPCL CGO APVL 

		 * @param e VOP_SCG-0053Event
		 * @return EventResponse VOP_SCG-0053EventResponse
		 * @exception EventException
		 */

		private EventResponse searchApprovalTargetLaneList(Event e,String gb) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
		    try{
    			VopScg0053Event event = (VopScg0053Event)e;  
    			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    			List<MdmVslSvcLaneListVO> list       = command.searchApprovalTargetLaneList( event.getMdmVslSvcLaneListVO() );
    			
    			GeneralEventResponse eventResponse = new GeneralEventResponse();
    			eventResponse.setRsVoList(list);
//    			if(list.size()==0){
//    			    eventResponse.setUserMessage(new ErrorHandler("SCG00008").getUserMessage());
//    			    //eventResponse.setUserMessage( "데이타가 존재하지 않습니다.");			
//    			}
    			return eventResponse;
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Target Lane for SPCL CGO APVL"}).getMessage(), ex);
            }
		}		
		/** 
		 * VOP_SCG-0035: ONCHANGE<br>
         * Target Lane for SPCL CGO APVL 내용을 조회한다.
         * 
		 * @param e VOP_SCG-0035Event
		 * @return EventResponse VOP_SCG-0033EventResponse
		 * @exception EventException
		 */

		private EventResponse searchApprovalTargetLane(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
		    try{
    			VopScg0035Event event = (VopScg0035Event)e;  
    			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    			List<MdmVslSvcLaneListVO> list       = command.searchApprovalTargetLaneList( event.getMdmVslSvcLaneListVO() );
    			
    			GeneralEventResponse eventResponse = new GeneralEventResponse();
    
    			StringBuffer str = new StringBuffer();
    
    			
    			for(int i=0;i<list.size();i++){
    				 str.append( ((MdmVslSvcLaneListVO)list.get(i)).getVslSlanCd()+"|" );
    				 str.append( ((MdmVslSvcLaneListVO)list.get(i)).getVslSlanNm()+"|" );
    				 str.append( ((MdmVslSvcLaneListVO)list.get(i)).getSvcTypeName()+"|" );				 
    			} 
    			
    			Map<String,String> etcData = new HashMap<String,String>();
    			etcData.put("VslSlanCd", str.toString() );
    			eventResponse.setETCData(etcData);		
                if(list.size()==0){
                    eventResponse.setUserMessage(new ErrorHandler("SCG50010",new  String[]{"Target Lane"} ).getUserMessage());         
                }
 
    			return eventResponse;
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Target Lane for SPCL CGO APVL"}).getMessage(), ex);
            }
		}		
		

		/**
		 * VOP_SCG-0035 : SAVE<br>
         * Target Lane for SPCL CGO APVL 내용을 저장 한다. 
         * 
		 * @param  Event e
		 * @return  EventResponse response
		 * @exception EventException
		 */
		private EventResponse manageApprovalTargetLane(Event e) throws EventException {
 
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VopScg0035Event event = (VopScg0035Event)e;

			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
			try{
				begin();
				
				command.manageApprovalTargetLane( event.getMdmVslSvcLaneListVOS() , account);
 
                eventResponse.setUserMessage(  new ErrorHandler("SCG00001", new String[]{"Data"} ).getUserMessage() );
				commit(); 
	        } catch (EventException ex) {
	            log.error("error:"+ex.toString(), ex);
	            rollback();
	            throw new EventException(ex.getMessage(), ex);
	        } catch (Exception ex) {
	            log.error("error:"+ex.toString(), ex);
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Target Lane for SPCL CGO APVL"}).getMessage(), ex);
	        }
			return eventResponse;
		}	
		
		/**
		 * VOP_SCG_0042 : Retrieve <br>
		 * Packing Instructions/Provisions (Creation) 을 조회 합니다. <br>
		 * 
		 * @param e Event
		 * @return response EventResponse
		 * @exception EventException
		 */
		private EventResponse searchPackingInstructionList(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
		    try{
    			VopScg0042Event event = (VopScg0042Event)e;
    			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    			
    			List<ScgImdgPckInstrVO> list = command.searchPackingInstructionList(event.getScgImdgPckInstrVO().getImdgPckInstrCd(), event.getScgImdgPckInstrVO().getImdgPckInstrSeq());
    			
    			GeneralEventResponse eventResponse = new GeneralEventResponse();
    			
    			eventResponse.setRsVoList(list);			
    			
    			return eventResponse;
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
            }
		}
		
		/**
		 * VOP_SCG_0042 : Save <br>
		 * Packing Instructions/Provisions (Creation) 을 저장 합니다. <br>
		 * 
		 * @param Event e
		 * @return response EventResponse
		 * @exception EventException
		 */
		private EventResponse managePackingInstruction(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VopScg0042Event event = (VopScg0042Event)e;

			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
			try{
				begin();
				
				command.managePackingInstruction(event.getScgImdgPckInstrVOS(), event.getKeys(), account);
				eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
				
				commit();
	        } catch (EventException ex) {
	            log.error("error:"+ex.toString(), ex);
	            rollback();
	            throw new EventException(ex.getMessage(), ex);
	        } catch (Exception ex) {
	            log.error("error:"+ex.toString(), ex);
	            rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
	        }
			return eventResponse;
		}
 
        /**
         * VOP_SCG_0066의 : retrieve<br>
         * Organic Peroxides & Self-Reactive Substances  조회 <br>
         * 
         * @param  Event e
         * @return EventResponse response 
         * @exception EventException
         * @author jkc
         */
        private EventResponse searchOrganicPeroxideCodeList(Event e) throws EventException {
            try{
                SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
                VopScg0066Event event = (VopScg0066Event)e;            
                List<ScgImdgUnNoOrgRactVO> list = command.searchOrganicPeroxideCodeList(event.getScgImdgCrrRstrVO().getImdgUnNo());
                
                GeneralEventResponse eventResponse = new GeneralEventResponse();
                eventResponse.setRsVoList(list);
                return eventResponse;
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Organic Peroxides & Self-Reactive Substances"}).getMessage(), ex);
            }
        }	
        /**
         * VOP_SCG_0073 : retrieve<br>
         * [Special Provisions for Segregation (Creation)]을 [조회 Retrieve] 합니다.<br>
         *
         * @param  Event e
         * @throws EventException
         * @return EventResponse
         * @author jang kang cheol
         */
        private EventResponse searchSpecialProvisionSegregationList(Event e) throws EventException {
            try{
                SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
                VopScg0073Event event = (VopScg0073Event)e;   
                List<ScgImdgSpclProvisVO> list     = command.searchSpecialProvisionSegregationList(event.getImdgsclprovino());
                  
                GeneralEventResponse eventResponse  = new GeneralEventResponse();
                eventResponse.setRsVoList(list);
                return eventResponse;
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
            }

        }   
        /**
         * VOP_SCG_0073 : save<br>
         * [Special Provisions for Segregation (Creation)]을 [저장 Save] 합니다.<br>
         *
         * @param  Event e
         * @throws EventException
         * @return EventResponse
         * @author jang kang cheol
         */
        private EventResponse manageSpecialProvisionSegregationList(Event e) throws EventException {
            
            IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
            VopScg0073Event event = (VopScg0073Event)e;            
 
            GeneralEventResponse eventResponse  = new GeneralEventResponse();
             
            try{
                begin();
                
                command.manageSpecialProvisionSegregationList( event.getScgImdgSpclProvisVOs(), event.getImdgsclprovino(),this.account.getUsr_id() );
                String msg = new ErrorHandler("SCG00001", new String[]{"Data"} ).getUserMessage();
                eventResponse.setUserMessage(  msg  );
                commit();
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
            }          
            return eventResponse;
        }          
        /**
         * VOP_SCG_0073 : retrieve<br>
         * [Special Provisions for Segregation (Creation)의 Subsidiary ]을 [조회 Get] 합니다.<br>
         * 
         * @param  Event e
         * @throws EventException  
         * @return EventResponse
         * @author jang kang cheol
         */
        private EventResponse searchSubsidiaryRisks(Event e) throws EventException {
            try{
                SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    
                
                VopScg0073Event event = (VopScg0073Event)e;
                GeneralEventResponse eventResponse  = new GeneralEventResponse();
      
                List<ScgImdgSpclProvisVO> list     = command.searchSubsidiaryRisks(event.getImdgunno() , event.getImdgunnoseq()  );
                
                eventResponse.setRsVoList(list);
                return eventResponse;
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
            }
        }  
        
        /**
    	 * VOP_SCG_0077 : Retrieve <br>
    	 * Setup mail contents for SPCL CGO application 을 조회 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchSCGMailTamplet(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0077Event event = (VopScg0077Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();

    		try{
    			event.getScgMailTampletVO().setEmlSndUsrId(account.getUsr_id());
    			
    			List<ScgMailTampletVO> scgMailTampletVOs = command.searchSCGMailTamplet(event.getScgMailTampletVO());

    			eventResponse.setRsVoList(scgMailTampletVOs);

    		}catch(EventException ex){
    			throw ex;
            } catch (Exception ex) {
                log.error("err " + ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Setup mail contents for SPCL CGO application"}).getMessage(), ex);
    		}		
    		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0077 : Save <br>
    	 * Setup mail contents for SPCL CGO application 를 수정 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse manageSCGMailTamplet(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();		
    		VopScg0077Event event = (VopScg0077Event)e;		
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		
    		try{
    			begin();
    			command.manageSCGMailTamplet(event.getScgMailTampletVOS(), account);
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
    			
    		}catch(EventException ex){
    			rollback();
    			throw ex;
            } catch (Exception ex) {
                log.error("err " + ex.toString(), ex);
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Setup mail contents for SPCL CGO application"}).getMessage(), ex);
    		}
    		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0032 : Retrieve <br>
    	 * SPCL CGO RSO - CREATION 에서 RgnShpOprRhqCode 를 구한다.<br>
    	 * 
    	 * @return EventResponse
    	 * @exception EventException
    	 */
    	public EventResponse searchRHQOfficeList() throws EventException {
    		
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		
    		try {
    			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    			List<String> list = command.searchRHQOfficeList();
    			
 /*   			
    			String subCd="| ";
    			
    			for (int i = 0; i < list.size(); i++) {
    				subCd = subCd + "|" + list.get(i);
    			}
    			eventResponse.setETCData("ofc_n8th_lvl_cd", subCd);	
 */   			

    			StringBuffer subCd = new StringBuffer(512);
    			subCd.append("| ");
    			
    			for (int i = 0; i < list.size(); i++) {
    				subCd.append("|" + list.get(i));
    			}
    			eventResponse.setETCData("ofc_n8th_lvl_cd", subCd.toString());	

    			
    		}catch(EventException ex){
    			throw ex;
            }catch (Exception ex) {
            	log.error("err " + ex.toString(), ex);
    			throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
    		}
    		return eventResponse;
    	}
    	

    	/**
    	 * VOP_SCG_0080  : Retrieve <br>
    	 * Special Cargo Guidance 화면의 내용을 조회 합니다. <br>
    	 * 
    	 * @param Event e 
    	 * @return  EventResponse response
    	 * @exception EventException
    	 */
    	private EventResponse searchScgGuidMsg(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	    try{
        		VopScg0080Event event = (VopScg0080Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
        		List<ScgGuidanceVO> list = command.searchScgGuidMsg(event.getScgGuidanceVO());
        		GeneralEventResponse eventResponse = new GeneralEventResponse();

        		List<ScgGuidanceVO> list2 = command.searchScgGuidDtl(event.getScgGuidanceVO());
    			eventResponse.setRsVoList(list2);

    			if (list.size() > 0) {
    				eventResponse.setETCData("msg_hdr_ctnt", list.get(0).getMsgHdrCtnt());
    			}        		
        		return eventResponse;
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner's Contact Point for SPCL CGO"}).getMessage(), ex);
            }
    	}
    	
    	/**
    	 * VOP_SCG_0083  : Retrieve <br>
    	 * Special Cargo NON DG Cargo keyword 화면의 내용을 조회 합니다. <br>
    	 * 
    	 * @param Event e 
    	 * @return  EventResponse response
    	 * @exception EventException
    	 */
    	private EventResponse searchScgNonDgCgoList(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	  
    	    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        		VopScg0083Event event = (VopScg0083Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();

        		try{
        			List<ScgNonDgCgoKwVO> list = command.searchScgNonDgCgoList(event.getScgNonDgCgoKwVO());
        			eventResponse.setRsVoList(list);
        		}catch(EventException ex){
        			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        		}catch(Exception ex){
        			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        		}	
        		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0084  : Retrieve <br>
    	 * Special Cargo Chemical History 화면의 내용을 조회 합니다. <br>
    	 * 
    	 * @param Event e 
    	 * @return  EventResponse response
    	 * @exception EventException
    	 */
    	private EventResponse searchScgChemicalHistory(Event e) throws EventException {
    	    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	    	VopScg0084Event event = (VopScg0084Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();

        		try{
        			List<ScgChemicalHistoryVO> list = command.searchScgChemicalHistory(event.getScgChemicalHistoryVO());
        			eventResponse.setRsVoList(list);
        		}catch(EventException ex){
        			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        		}catch(Exception ex){
        			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        		}	
        		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0109  : Retrieve <br>
    	 * Special Cargo Chemical History 화면의 내용을 조회 합니다.(Answer) <br>
    	 * 
    	 * @param Event e 
    	 * @return  EventResponse response
    	 * @exception EventException
    	 */
    	private EventResponse searchScgChemHistoryAnswer(Event e) throws EventException {
    	    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	    	VopScg0109Event event = (VopScg0109Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();

        		try{
        			List<ScgChemicalHistoryVO> list = command.searchScgChemHistoryAnswer(event.getScgChemicalHistoryVO());
        			eventResponse.setRsVoList(list);
        		}catch(EventException ex){
        			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        		}catch(Exception ex){
        			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        		}	
        		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0084  : SAVE <br>
    	 * Special Cargo Chemical History 화면의 내용을 저장 합니다. <br>
    	 * 
    	 * @param Event e 
    	 * @return  EventResponse response
    	 * @exception EventException
    	 */
    	private EventResponse manageScgChemicalHistory(Event e) throws EventException {
    	    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	    	VopScg0084Event event = (VopScg0084Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();

        		try{
        			begin();
        			command.manageScgChemicalHistory(event.getScgChemicalHistoryVOS(),account);
        			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
        			commit();
        		}catch(EventException ex){
        			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        		}catch(Exception ex){
        			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        		}	
        		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0109  : SAVE <br>
    	 * Special Cargo Chemical History 화면의 내용을 저장 합니다.(answer) <br>
    	 * 
    	 * @param Event e 
    	 * @return  EventResponse response
    	 * @exception EventException
    	 */
    	private EventResponse manageScgChemHistoryAnswer(Event e) throws EventException {
    	    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	    	VopScg0109Event event = (VopScg0109Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();

        		try{
        			begin();
        			command.manageScgChemHistoryAnswer(event.getScgChemicalHistoryVOS(),account);
        			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
        			commit();
        		}catch(EventException ex){
        			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        		}catch(Exception ex){
        			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        		}	
        		return eventResponse;
    	}
    	
    	
    	/**
    	 * VOP_SCG_0080  : Retrieve <br>
    	 * Special Cargo Guidance 화면의 첨부파일 내용을 조회 합니다. <br>
    	 * 
    	 * @param Event e 
    	 * @return  EventResponse response
    	 * @exception EventException
    	 */
    	private EventResponse searchScgGuidDtlFile(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	    try{
        		VopScg0080Event event = (VopScg0080Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
        		GeneralEventResponse eventResponse = new GeneralEventResponse();

        		List<ScgGuidanceVO> list = command.searchScgGuidDtlFile(event.getScgGuidanceVO());
    			eventResponse.setRsVoList(list);
        		
        		return eventResponse;
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner's Contact Point for SPCL CGO"}).getMessage(), ex);
            }
    	}
    	

        /**
    	 * VOP_SCG_0080  : save <br>
    	 * Special Cargo Guidance 화면의 최 상단 내용을을 [저장 Save] 합니다.<br>
         *
         * @param  Event e
         * @throws EventException
         * @return EventResponse
         * @author jang kang cheol
         */
        private EventResponse manageScgGuidMsg(Event e) throws EventException {
        	// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();		
    		VopScg0080Event event = (VopScg0080Event)e;		
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{

        		List<ScgGuidanceVO> list = command.searchScgGuidMsg(event.getScgGuidanceVO());
    			begin();
				//조회 후 정보가 1건이상있으면 Update 없는 경우에만 Insert
    			if (list.size() > 0) {
    				command.manageScgGuidMsg(event.getScgGuidanceVOs(), account, "U");
    			} else {
    				command.manageScgGuidMsg(event.getScgGuidanceVOs(), account, "I");
    			}
    			commit();
    			
    		}catch(EventException ex){
    			rollback();
    			throw ex;
            } catch (Exception ex) {
                log.error("err " + ex.toString(), ex);
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Cargo Guidanace"}).getMessage(), ex);
    		}
    		return eventResponse;
    	}
        
        
        /**
    	 * VOP_SCG_0080  : save <br>
    	 * Special Cargo Guidance 화면의 상세정보를 [저장 Save] 합니다.<br>
         *
         * @param  Event e
         * @throws EventException
         * @return EventResponse
         * @author jang kang cheol
         */
        private EventResponse manageScgGuidDtl(Event e) throws EventException {
        	// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();		
    		VopScg0080Event event = (VopScg0080Event)e;		
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		
    		try{
    			begin();
				command.manageScgGuidDtl(event.getScgGuidanceVOs(), event.getScgGuidanceFileVOs(), event.getStrKeys(), event.getKeys(), account);
				eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
    			
    		} catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                rollback();
                log.error("error:"+ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Excepted Quantities"}).getMessage(), ex);
            }
    		return eventResponse;
    	}
    	
    	 /**
         * VOP_SCG_0043 : Combo list <br>
         *  common code
         * 
         * @param Event e
         * @return EventResponse
         * @exception EventException
         */
        private EventResponse searchComCodeList(Event e) throws EventException {
         GeneralEventResponse eventResponse = new GeneralEventResponse();  
         SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
         List<RsltCdListVO> customData = null;
         RsltCdListVO vo = new RsltCdListVO();
         try {
          if (e.getEventName().equalsIgnoreCase("VopScg0043Event")) {
           vo.setCd("CD03216");  // PCK_KND_CD
           customData = command.searchComCodeDescList(vo);  
           eventResponse.setRsVoList(customData);
           vo.setCd("CD03215");  // PCK_MTRL_TP_CD 
           customData = command.searchComCodeDescList(vo);  
           eventResponse.setRsVoList(customData);
          }else{
           // VopScg0104, VopScg0105
           vo.setCd("CD03215");
           customData = command.searchComCodeDescList(vo);  
           eventResponse.setRsVoList(customData);
          }
         } catch (EventException ex) {
          throw ex;
         } catch (Exception ex) {
          throw new EventException(ex.getMessage(), ex);
         }
         return eventResponse;
        }     	
        
    	/**
    	 * AOM_SCG_0081 : Retrieve<br>
    	 * SCG CODE를 조회합니다.<br>
    	 * 
    	 * @param Event e
    	 * @return EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchScgCodeList(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0082Event event = (VopScg0082Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();

    		try{
    			List<ScgCdVO> list = command.searchScgCodeList(event.getScgCdVO());
    			eventResponse.setRsVoList(list);
    		}catch(EventException ex){
    			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
    		}catch(Exception ex){
    			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
    		}	
    		return eventResponse;
    	}
    	/**
    	 * AOM_SCG_0081 : Save<br>
    	 * SCG CODE를 저장합니다.<br>
    	 *
    	 * @param Event e
    	 * @return EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse manageScgCode(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0082Event event = (VopScg0082Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();
    			command.manageScgCode(event.getScgCdVOS(),account);
    			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
    			commit();
    		} catch(EventException ex) {
    			rollback();
    			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
    		} catch(Exception ex) {
    			rollback();
    			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
    		}
    		return eventResponse;
    	}        

    	/**
    	 * VOP_SCG_0083 : Save<br>
    	 * SCG NON D/G CARGO KEYWORD CODE를 저장합니다.<br>
    	 *
    	 * @param Event e
    	 * @return EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse manageScgNonDgCgoKwList(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0083Event event = (VopScg0083Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();
    			
    			command.manageScgNonDgCgoKwList(event.getScgNonDgCgoKwVOS(),account);
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
    			
    		} catch(EventException ex) {
    			if(ex.getMessage().indexOf("Duplication:") == -1) {
    				rollback();
    			    throw ex; }
    			else {
    				
    				String kwnm = ex.getMessage().substring(0,ex.getMessage().indexOf("||")-1);
    			//	log.debug("kwnm"+kwnm);
    			//	log.debug(ex.getMessage().indexOf("||"));
    		//		log.debug(ex.getMessage().substring(0,ex.getMessage().indexOf("||")));
    				rollback();
    				eventResponse.setETCData("ERROR",kwnm);
    				}
    		} catch(Exception ex) {
    			rollback();
    			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
    		}
    		return eventResponse;
    	} 
    	

    	
    	/**
    	 * VOP_SCG_0103  : Retrieve <br>
    	 * Pack.Instruct.Code 을 조회 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchPackingInstructionCode(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	    try{
        		VopScg0103Event event = (VopScg0103Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
        		List<ScgPckInstrVO> list = command.searchPackingInstructionCode(event.getScgPckInstrVO());
        		GeneralEventResponse eventResponse = new GeneralEventResponse();
        		eventResponse.setRsVoList(list);
        		return eventResponse;
            } catch (EventException ex) {
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Group"}).getMessage(), ex);
            }
    	}
        
    	/**
    	 * VOP_SCG_0103  : Save <br>
    	 * Pack.Instruct.Code 을 생성,수정,삭제 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse managePackingInstructionCode(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0103Event event = (VopScg0103Event)e;

    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();
    			
    			command.managePackingInstructionCode(event.getScgPckInstrVO(),account );
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
            } catch (EventException ex) {
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
            }
    		return eventResponse;
    	} 

    	/**
    	 * VOP_SCG_0105 : OPEN <br>
    	 * Proper IBC code
    	 * 
    	 * @param Event e
    	 * @return EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse initUOMComboData(Event e) throws EventException {
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();

    		List<RsltCdListVO> customData = null;
    		RsltCdListVO vo = new RsltCdListVO();

    		try {
    			// service scope code
    			vo.setCd("CD03211");
    			customData = command.searchComCodeDescList(vo);		
    			eventResponse.setRsVoList(customData);
    			vo.setCd("CD03216");
    			customData = command.searchComCodeDescList(vo);		
    			eventResponse.setRsVoList(customData);
    			vo.setCd("CD03215");
    			customData = command.searchComCodeDescList(vo);		
    			eventResponse.setRsVoList(customData);
    		} catch (EventException ex) {
    			throw ex;
    		} catch (Exception ex) {
    			throw new EventException(ex.getMessage(), ex);
    		}
    		return eventResponse;
    	}

    	/**
    	 * VOP_SCG_0106  : Save <br>
    	 * IBC Code for Organic peroxide 을 생성,수정,삭제 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse managePackingInstructionRegulationOrganicPeroxideList(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0106Event event = (VopScg0106Event)e;

    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();
    			
    			command.managePackingInstructionRegulationOrganicPeroxideList(event.getScgPckReguPkgOrgPrxVOS(),account );
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
            } catch (EventException ex) {
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
            }
    		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0160  : Retrieve <br>
    	 * IBC Code for Organic peroxide 을 조회 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchPackingInstructionRegulationOrganicPeroxideList(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	    try{
        		VopScg0106Event event = (VopScg0106Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
        		List<ScgPckReguPkgOrgPrxVO> list = command.searchPackingInstructionRegulationOrganicPeroxideList(event.getScgPckReguPkgOrgPrxVO());
        		GeneralEventResponse eventResponse = new GeneralEventResponse();
        		eventResponse.setRsVoList(list);
        		return eventResponse;
            } catch (EventException ex) {
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Group"}).getMessage(), ex);
            }
    	}

    /**
    	 * VOP_SCG_0108  : Retrieve <br>
    	 * Image File Registration <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchPackingInstructionRegulationImgList(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	    try{
        		VopScg0108Event event = (VopScg0108Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
        		List<ScgPckReguImgVO> list = command.searchPackingInstructionRegulationImgList(event.getScgPckReguImgVO().getImdgPckInstrCd(), event.getScgPckReguImgVO().getImdgPckInstrSeq(), event.getScgPckReguImgVO().getReguDpNo());
        		GeneralEventResponse eventResponse = new GeneralEventResponse();
        		eventResponse.setRsVoList(list);
        		return eventResponse;
            } catch (EventException ex) {
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Image List"}).getMessage(), ex);
            }
    	}
    	
    	/**
    	 * VOP_SCG_0108 : SAVE <br>
    	 * Image File Registration
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse managePackingInstructionRegulationImgList(Event e)throws EventException {
    		// PDTO(Data Transfer Object including Parameters)		
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0108Event event = (VopScg0108Event)e;

    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();
    			log.debug("\n event.getScgPckReguImgVOs()" + event.getScgPckReguImgVOs());
    			log.debug("\n event.account" + account);
    			command.managePackingInstructionRegulationImgList(event.getScgPckReguImgVOs(), account );
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
    			
            } catch (EventException ex) {
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
            }
    		return eventResponse;
    	}
    	

    	
    	
    	/**
    	 * VOP_SCG_0105 : Retrieve <br>
    	 * Proper IBC code
    	 * 
    	 * @param Event e
    	 * @return EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchPackingInstructionRegulationPackagingIbcCodeList(Event e) throws EventException {
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0105Event event = (VopScg0105Event) e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try {
    			List<ScgPckReguPkgIbcCdVO> list = command.searchPackingInstructionRegulationPackagingIbcCodeList(event.getPkgCd(), event.getPkgCdSeq(), event.getDispNo());
    			eventResponse.setRsVoList(list);
    		} catch (EventException ex) {
    			throw ex;
    		} catch (Exception ex) {
    			throw new EventException(ex.getMessage(), ex);
    		}
    		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0105 : SAVE <br>
    	 * Proper IBC code
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse managePackingInstructionRegulationPackagingIbcCodeList(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0105Event event = (VopScg0105Event) e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();			
    			command.managePackingInstructionRegulationPackagingIbcCodeList(event.getScgPckReguPkgIbcCdVOs(), account );
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
            } catch (EventException ex) {
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
            }
    		return eventResponse;
    	}   
    	    	
    	/**
    	 * VOP_SCG_0105 : OPEN <br>
    	 * Proper IBC code
    	 * 
    	 * @param Event e
    	 * @return EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse initPkgMtrlTpCdComboData(Event e) throws EventException {
    		VopScg010302Event event = (VopScg010302Event)e;
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();

    		List<RsltCdListVO> customData = null;  //getPckTpCd

    		try {
    			// service scope code
    			customData = command.searchPkgMtrlTpCdComboData(event.getScgPckPkgVO().getPckTpCd(), event.getScgPckPkgVO().getPckMtrlTpCd(), event.getScgPckPkgVO().getPckStyCd());		
    			eventResponse.setRsVoList(customData);
    		} catch (EventException ex) {
    			throw ex;
    		} catch (Exception ex) {
    			throw new EventException(ex.getMessage(), ex);
    		}
    		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0105 : IBC CODE ONCHANGE <br>
    	 * 
    	 * @param Event e
    	 * @return EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchPackingIbcCodeList(Event e) throws EventException {
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0105Event event = (VopScg0105Event) e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try {
    			List<ScgPckReguPkgIbcCdVO> list = command.searchPackingIbcCodeList(event.getScgPckReguPkgIbcCdVO());
    			if(list.size()!=0){
    				eventResponse.setETCData("PKG_TP_CD", list.get(0).getPkgTpCd());
    			}
    		} catch (EventException ex) {
    			throw ex;
    		} catch (Exception ex) {
    			throw new EventException(ex.getMessage(), ex);
    		}
    		return eventResponse;
    	}

    	/**
    	 * VOP_SCG_0107 : Retrieve <br>
    	 * Packing Instruction Creation
    	 * 
    	 * @param Event e
    	 * @return EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchPackingInstructionRegulationPKGMethodList(Event e) throws EventException {
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0107Event event = (VopScg0107Event) e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try {
    			
    			List<ScgPckCreationVO> list1 = command.searchPackingInstructionRegulationPKGMethodList(event.getScgPckCreationVO());
    			List<ScgPckCreationVO> list2 = command.searchPackingInstructionPKGMethodRefList(event.getScgPckCreationVO());

    			eventResponse.setRsVoList(list1);
    			eventResponse.setRsVoList(list2);
    		} catch (EventException ex) {
    			throw ex;
    		} catch (Exception ex) {
    			throw new EventException(ex.getMessage(), ex);
    		}
    		return eventResponse;
    	}	

    	/**
    	 * VOP_SCG_0107 : SAVE <br>
    	 * Packing Instruction Creation
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse managePackingInstructionRegulationPKGMethodList(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0107Event event = (VopScg0107Event) e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();			
    			command.managePackingInstructionRegulationPKGMethodList(event.getScgPckCreationVOS(), account );
    			command.managePackingInstructionReference(event.getScgPckRefVOS(), account );;
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
            } catch (EventException ex) {
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
            }
    		return eventResponse;
    	}	
    		
    	/**
    	 * VOP_SCG_0104  : Retrieve <br>
    	 * Packaging Code General 을 조회 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchPackingInstructionRegulationPackagingCodeList(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	    try{
        		VopScg0104Event event = (VopScg0104Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
        		List<ScgPckReguPkgCdVO> list = command.searchPackingInstructionRegulationPackagingCodeList(event.getScgPckReguPkgCdVO());
        		GeneralEventResponse eventResponse = new GeneralEventResponse();
        		eventResponse.setRsVoList(list);
        		return eventResponse;
            } catch (EventException ex) {
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Group"}).getMessage(), ex);
            }
    	}
    	/**
    	 * VOP_SCG_0104  : Save <br>
    	 * Packaging Code General 을 생성,수정,삭제 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse managePackingInstructionRegulationPackagingCodeList(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0104Event event = (VopScg0104Event)e;

    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();
    			command.managePackingInstructionRegulationPackagingCodeList(event.getScgPckReguPkgCdVOS(),account );
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
            } catch (EventException ex) {
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
            }
    		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0104 : IBC CODE ONCHANGE <br>
    	 * 
    	 * @param Event e
    	 * @return EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse checkPkgCd(Event e) throws EventException {
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgPckReguPkgCdVO> list = null;
    		try {
    			if (e.getEventName().equalsIgnoreCase("VopScg0104Event")) {
    				VopScg0104Event event = (VopScg0104Event) e;
    				list = command.checkPkgCd(event.getScgPckReguPkgCdVO().getPkgCd());
    			}else if (e.getEventName().equalsIgnoreCase("VopScg010302Event")) {
    				VopScg010302Event event = (VopScg010302Event) e;
    				list = command.checkPkgCd(event.getScgPckPkgVO().getImdgPckCd());
    			}
    			
    			//2015.08.17 Secure Coding 적용 [CWE-476] Null Dereferencing
    			if(list != null){
	    			if(list.size()!=0){
	    				eventResponse.setETCData("PKG_TP_CD", list.get(0).getPkgTpCd());
	    				eventResponse.setETCData("PKG_CD", list.get(0).getPkgCd());
	    				eventResponse.setETCData("PKG_NM", list.get(0).getPkgNm());
	    			}
    			}
    		} catch (EventException ex) {
    			throw ex;
    		} catch (Exception ex) {
    			throw new EventException(ex.getMessage(), ex);
    		}
    		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0103  : Retrieve <br>
    	 * Pack.Instruct.Code 을 조회 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchPackingInstructionRegulation(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	    try{
        		VopScg010301Event event = (VopScg010301Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
        		List<ScgPckReguVO> list = command.searchPackingInstructionRegulation(event.getScgPckReguVO());
        		GeneralEventResponse eventResponse = new GeneralEventResponse();
        		eventResponse.setRsVoList(list);
        		return eventResponse;
            } catch (EventException ex) {
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Group"}).getMessage(), ex);
            }
    	}
    	/**
    	 * VOP_SCG_0103  : Save <br>
    	 * Pack.Instruct.Code 을 생성,수정,삭제 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse managePackingInstructionRegulation(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg010301Event event = (VopScg010301Event)e;

    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();
    			
    			command.managePackingInstructionRegulation(event.getScgPckReguVOS(),account );
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
            } catch (EventException ex) {
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
            }
    		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0103  : Retrieve <br>
    	 * Pack.Instruct.Code 을 조회 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchPackingInstructionCombinePackaging(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	    try{
        		VopScg010302Event event = (VopScg010302Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
        		List<ScgPckPkgVO> list1 = command.searchPackingInstructionPackaging(event.getScgPckPkgVO(), "I");
        		List<ScgPckPkgVO> list2 = command.searchPackingInstructionPackaging(event.getScgPckPkgVO(), "M");
        		List<ScgPckPkgVO> list3 = command.searchPackingInstructionPackaging(event.getScgPckPkgVO(), "O");
        		List<ScgPckRefVO> list4 = command.searchPackingInstructionPackagingReference(event.getScgPckRefVO(), "C");
        		GeneralEventResponse eventResponse = new GeneralEventResponse();
        		eventResponse.setRsVoList(list1);
        		eventResponse.setRsVoList(list2);
        		eventResponse.setRsVoList(list3);
        		eventResponse.setRsVoList(list4);
        		return eventResponse;
            } catch (EventException ex) {
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Group"}).getMessage(), ex);
            }
    	}
    	/**
    	 * VOP_SCG_0103  : Save <br>
    	 * Pack.Instruct.Code 을 생성,수정,삭제 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse managePackingInstructionCombinePackaging(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg010302Event event = (VopScg010302Event)e;

    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();
    			
    			command.managePackingInstructionPackaging(event.getScgPckPkgVOS(),account );
    			command.managePackingInstructionPackaging(event.getScgPckPkg2VOS(),account );
    			command.managePackingInstructionPackaging(event.getScgPckPkg3VOS(),account );
    			command.managePackingInstructionReference(event.getScgPckRefVOS(),account );
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
            } catch (EventException ex) {
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
            }
    		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0103  : Retrieve <br>
    	 * Pack.Instruct.Code 을 조회 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchPackingInstructionSinglePackaging(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	    try{
        		VopScg010303Event event = (VopScg010303Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
        		List<ScgPckPkgVO> list1 = command.searchPackingInstructionPackaging(event.getScgPckPkgVO(), "S");
        		List<ScgPckRefVO> list2 = command.searchPackingInstructionPackagingReference(event.getScgPckRefVO(), "S");
        		GeneralEventResponse eventResponse = new GeneralEventResponse();
        		eventResponse.setRsVoList(list1);
        		eventResponse.setRsVoList(list2);
        		return eventResponse;
            } catch (EventException ex) {
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Group"}).getMessage(), ex);
            }
    	}
    	/**
    	 * VOP_SCG_0103  : Save <br>
    	 * Pack.Instruct.Code 을 생성,수정,삭제 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse managePackingInstructionSinglePackaging(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg010303Event event = (VopScg010303Event)e;

    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();
    			
    			command.managePackingInstructionPackaging(event.getScgPckPkgVOS(),account );
    			command.managePackingInstructionReference(event.getScgPckRefVOS(),account );
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
            } catch (EventException ex) {
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
            }
    		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0103  : Retrieve <br>
    	 * Pack.Instruct.Code 을 조회 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchPackingInstructionSpclProvi(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	    try{
        		VopScg010305Event event = (VopScg010305Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
        		List<ScgSpclPckProviVO> list = command.searchPackingInstructionSpclProvi(event.getScgSpclPckProviVO());
        		GeneralEventResponse eventResponse = new GeneralEventResponse();
        		eventResponse.setRsVoList(list);
        		return eventResponse;
            } catch (EventException ex) {
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Group"}).getMessage(), ex);
            }
    	}
    	/**
    	 * VOP_SCG_0103  : Save <br>
    	 * Pack.Instruct.Code 을 생성,수정,삭제 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse managePackingInstructionSpclProvi(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg010305Event event = (VopScg010305Event)e;

    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();
    			
    			command.managePackingInstructionSpclProvi(event.getScgSpclPckProviVOS(),account );
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
            } catch (EventException ex) {
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
            }
    		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0103  : Retrieve <br>
    	 * Pack.Instruct.Code 을 조회 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchPackingInstructionGasRegulation(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	    try{
        		VopScg010306Event event = (VopScg010306Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
        		List<ScgPckGasReguVO> list1 = command.searchPackingInstructionGasRegulation(event.getScgPckGasReguVO());
        		List<ScgPckRefVO> list2 = command.searchPackingInstructionGasRegulationReference(event.getScgPckRefVO());
        		List<ScgPckRefVO> list3 = command.searchPackingInstructionGasSpclProviReference(event.getScgPckRefVO());
        		GeneralEventResponse eventResponse = new GeneralEventResponse();
        		eventResponse.setRsVoList(list1);
        		eventResponse.setRsVoList(list2);
        		eventResponse.setRsVoList(list3);
        		return eventResponse;
            } catch (EventException ex) {
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Group"}).getMessage(), ex);
            }
    	}
    	/**
    	 * VOP_SCG_0103  : Save <br>
    	 * Pack.Instruct.Code 을 생성,수정,삭제 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse managePackingInstructionGasRegulation(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg010306Event event = (VopScg010306Event)e;

    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();
    			
    			command.managePackingInstructionGasRegulation(event.getScgPckGasReguVOS(),account );
    			command.managePackingInstructionReference(event.getScgPckRefVOS(),account );
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
            } catch (EventException ex) {
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
            }
    		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0103  : Retrieve <br>
    	 * Pack.Instruct.Code 을 조회 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchPackingInstructionPortableTank(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	    try{
        		VopScg010307Event event = (VopScg010307Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
        		List<ScgPckPtbTnkVO> list1 = command.searchPackingInstructionPortableTank(event.getScgPckPtbTnkVO(), "");
        		List<ScgPckPtbTnkVO> list2 = command.searchPackingInstructionPortableTank(event.getScgPckPtbTnkVO(), "T23");
        		List<ScgPckPtbTnkVO> list3 = command.searchPackingInstructionPortableTank(event.getScgPckPtbTnkVO(), "T50");
        		List<ScgPckRefVO> list4 = command.searchPackingInstructionPortableTankReference(event.getScgPckRefVO());
        		GeneralEventResponse eventResponse = new GeneralEventResponse();
        		eventResponse.setRsVoList(list1);
        		eventResponse.setRsVoList(list2);
        		eventResponse.setRsVoList(list3);
        		eventResponse.setRsVoList(list4);
        		return eventResponse;
            } catch (EventException ex) {
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Group"}).getMessage(), ex);
            }
    	}
    	/**
    	 * VOP_SCG_0103  : Save <br>
    	 * Pack.Instruct.Code 을 생성,수정,삭제 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse managePackingInstructionPortableTank(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg010307Event event = (VopScg010307Event)e;

    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();
    			
    			command.managePackingInstructionPortableTank(event.getScgPckPtbTnkVOS(),account );
    			command.managePackingInstructionPortableTank(event.getScgPckPtbTnk2VOS(),account );
    			command.managePackingInstructionPortableTank(event.getScgPckPtbTnk3VOS(),account );
    			command.managePackingInstructionReference(event.getScgPckRefVOS(),account );
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
            } catch (EventException ex) {
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
            }
    		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0112 : Retrieve <br>
    	 * Vessel Operator's Restriction on DG file 을 조회 합니다. <br>
    	 * 
    	 * @param e Event
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchChemFileList(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	    try{
    			VopScg0112Event event = (VopScg0112Event)e;
    			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    			
    			List<ScgChemHistoryFileVO> list = command.searchChemFileList(event.getScgChemHistoryFileVO());
    			
    			GeneralEventResponse eventResponse = new GeneralEventResponse();
    			
    			eventResponse.setRsVoList(list);			
    			
    			return eventResponse;
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Operator's Restriction on DG"}).getMessage(), ex);
            }
    	}
    	
    	/**
    	 * VOP_SCG_0112 : Save <br>
    	 * SCG Chemical History File 생성, 수정, 삭제 합니다. <br>
    	 * 
    	 * @param Event e
    	 * @return response EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse manageFile(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0112Event event = (VopScg0112Event)e;

    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    	
    		try{
    			begin();
    			
    	
    			command.manageChemFile(event.getScgChemHistoryFileVOs(), event.getKeys(), account);
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			
    			commit();
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel Operator's Restriction on DG"}).getMessage(), ex);
            }
    		return eventResponse;
    	}
    	
    	/**
    	 * VOP_SCG_0113  : Retrieve <br>
    	 * Partner's Contact Point for SPCL CGO by POL 리스트를  조회 합니다. <br>
    	 * 
    	 * @param Event e 
    	 * @return  EventResponse response
    	 * @exception EventException
    	 */
    	private EventResponse searchPartnerContactPointPolList(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    	    try{
        		VopScg0113Event event = (VopScg0113Event)e;
        		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
        		List<ScgCntcPntPolVO> list = command.searchPartnerContactPointPolList(event.getScgCntcPntPolVO());
        		GeneralEventResponse eventResponse = new GeneralEventResponse();
        		eventResponse.setRsVoList(list);
        		return eventResponse;
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner's Contact Point for SPCL CGO by POL"}).getMessage(), ex);
            }
    	}
    	
    	/**
    	 * VOP_SCG_0113  : Save <br>
    	 * Partner's Contact Point for SPCL CGO by POL 을 생성,수정,삭제 합니다. <br>
    	 * 
    	 * @param Event  e
    	 * @return  EventResponse response
    	 * @exception EventException
    	 */
    	private EventResponse managePartnerContactPointPol(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0113Event event = (VopScg0113Event)e;

    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		try{
    			begin();
    			
    			command.managePartnerContactPointPol(event.getScgCntcPntPolVOS(), account);
    			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
    			commit();
            } catch (EventException ex) {
                log.error("error:"+ex.toString(), ex);
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                log.error("error:"+ex.toString(), ex);
                rollback();
                throw new EventException(new ErrorHandler("COM12192", new String[]{"Partner's Contact Point for SPCL CGO by Pol"}).getMessage(), ex);
            }
    		return eventResponse;
    	}
        
}