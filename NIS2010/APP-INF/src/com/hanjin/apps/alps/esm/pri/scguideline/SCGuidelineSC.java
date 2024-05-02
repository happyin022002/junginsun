/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGuidelineSC.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.15
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.15 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.basic.SCArbitraryChargeGuidelineBC;
import com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.basic.SCArbitraryChargeGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.event.EsmPri000104Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.event.EsmPri000204Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.event.EsmPri0067Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbTypeVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.basic.SCBasicStandardNoteGuidelineBC;
import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.basic.SCBasicStandardNoteGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.event.EsmPri0005Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.event.EsmPri0008Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.event.EsmPri0010Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.event.EsmPri0012Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteCtntVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteHdrCopyVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.vo.StndNoteGlineVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.basic.SCBoilerPlateGuidelineBC;
import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.basic.SCBoilerPlateGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.event.EsmPri0007Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.event.EsmPri0011Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo.PriSgBlplExcelVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo.ScBlplGlineVO;
import com.hanjin.apps.alps.esm.pri.scguideline.sccontractclauseguideline.basic.SCContractClauseGuidelineBC;
import com.hanjin.apps.alps.esm.pri.scguideline.sccontractclauseguideline.basic.SCContractClauseGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.scguideline.sccontractclauseguideline.event.EsmPri000107Event;
import com.hanjin.apps.alps.esm.pri.scguideline.sccontractclauseguideline.event.EsmPri000207Event;
import com.hanjin.apps.alps.esm.pri.scguideline.sccontractclauseguideline.vo.CtrtCluzGlineVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgohchargeguideline.basic.SCGOHChargeGuidelineBC;
import com.hanjin.apps.alps.esm.pri.scguideline.scgohchargeguideline.basic.SCGOHChargeGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.scguideline.scgohchargeguideline.event.EsmPri000105Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scgohchargeguideline.event.EsmPri000205Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scgohchargeguideline.vo.RsltPriSgGohChgVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.basic.SCGroupCommodityGuidelineBC;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.basic.SCGroupCommodityGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.event.EsmPri000103Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.event.EsmPri000203Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.event.EsmPri0064Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.PriSgGrpCmdtExcelVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.RsltPriSgGrpCmdtCustTypeVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.RsltPriSgGrpCmdtDtlVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.basic.SCGroupLocationGuidelineBC;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.basic.SCGroupLocationGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.event.EsmPri000102Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.event.EsmPri000201Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocExcelVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.basic.SCGuidelineMainBC;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.basic.SCGuidelineMainBCImpl;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.event.EsmPri0001Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.event.EsmPri0002Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.event.EsmPri0006Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.integration.SCGuidelineMainDBDAO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineMnVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineTermsCntVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.basic.SCRateGuidelineBC;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.basic.SCRateGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.event.EsmPri000106Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.event.EsmPri000206Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.event.EsmPri0030Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.event.EsmPri0053Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.event.EsmPri0120Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtCmdtListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtCustTpVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtListExcelVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutHdrListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scsalesguideline.basic.SCSalesGuidelineBC;
import com.hanjin.apps.alps.esm.pri.scguideline.scsalesguideline.basic.SCSalesGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.scguideline.scsalesguideline.event.EsmPri000101Event;
import com.hanjin.apps.alps.esm.pri.scguideline.scsalesguideline.event.EsmPri000202Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.basic.SCNoteConversionProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.basic.SCNoteConversionProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.vo.RsltNoteConvVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUpldFileVO;
import com.hanjin.syscommon.common.table.PriScgGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSgArbVO;
import com.hanjin.syscommon.common.table.PriSgBlplCtntVO;
import com.hanjin.syscommon.common.table.PriSgBlplHdrVO;
import com.hanjin.syscommon.common.table.PriSgBlplVO;
import com.hanjin.syscommon.common.table.PriSgCtrtCluzDtlVO;
import com.hanjin.syscommon.common.table.PriSgCtrtCluzVO;
import com.hanjin.syscommon.common.table.PriSgGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSgMnVO;
import com.hanjin.syscommon.common.table.PriSgRtMqcRngVO;
import com.hanjin.syscommon.common.table.PriSgSlsRefVO;
import com.hanjin.syscommon.common.table.PriSgStndNoteCtntVO;
import com.hanjin.syscommon.common.table.PriSgStndNoteHdrVO;
import com.hanjin.syscommon.common.table.PriSgStndNoteVO;

/**
 * NIS2010-SCGuideline Business Logic ServiceCommand - NIS2010-SCGuideline 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Park Sungsoo
 * @see SCGuidelineMainDBDAO
 * @since J2EE 1.4
 */

public class SCGuidelineSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SCGuideline system 업무 시나리오 선행작업<br>
	 * UI_PRI_0001업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * SCGuideline system 업무 시나리오 마감작업<br>
	 * UI_PRI_0001 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SCGuidelineSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-SCGuideline system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmPri0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGuidelineMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGuidelineScopeEffectiveDateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchGuidelineTermsCount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGuidelineMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = confirmGuidelineMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = cancelGuidelineMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = removeGuidelineMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = copyGuidelineMain(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmPri0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGuidelineInquiryMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGuidelineScopeEffectiveDateInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchGuidelineTermsCountInquiry(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmPri000101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSalesGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSalesGuideline(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmPri000102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGroupLocationListExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkGroupLocationInUse(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGroupLocationGuideline(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmPri000106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchRateListExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchRateCustomerType(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageRateCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageRateRoute(e);
            } else {
            	eventResponse = initRateComboData(e);
            }
		}
		
        if (e.getEventName().equalsIgnoreCase("EsmPri0120Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = checkRateExcelVertical(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = uploadRateExcelVertical(e);
            } else {
                eventResponse = initRateExcelVertical(e);
            }
        }
		
		if (e.getEventName().equalsIgnoreCase("EsmPri000206Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchRateInquiryListExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchRateCustomerTypeInquiry(e);
            } else {
            	eventResponse = initRateComboData(e);
            }
		}

		// ---ESM_PRI_0001_05_start-----------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri000105Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGOHChargeGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageGOHChargeGuideline(e);
			} else {
				eventResponse = initGohComboData(e);  // 화면 최초 호출 시 실행
			}
		}
		// ---ESM_PRI_0001_05_end-----------------------------------------------------------

		// ---ESM_PRI_0001_04_start-----------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri000104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchArbitraryChargeGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageArbitraryChargeGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchArbitraryChargeTypeCountList(e);
			} else {
				eventResponse = initArbComboData(e);  // 화면 최초 호출 시 실행
			}
		}
		// ---ESM_PRI_0001_04_end-----------------------------------------------------------

		// ---ESM_PRI_0001_03_start-----------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri000103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupCommodityGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityGuidelineDtlList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGroupCommodityGuidelineExcelList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageGroupCommodityGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchGroupCommodityGuideCustTypeCount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = checkGroupCommodityInUse(e);
			}
		}
		// ---ESM_PRI_0001_03_end-----------------------------------------------------------

		// ui_pri_0005 standard note
		// ////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBasicStandardNoteGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBasicStandardNoteGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchBasicStandardNoteGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchBasicStandardNoteGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchBasicStandardNoteGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchBasicStandardNoteGuidelineExcelList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageBasicStandardNoteGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = confirmBasicStandardNoteGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = cancelBasicStandardNoteGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = removeBasicStandardNoteGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = copyBasicStandardNoteGuideline(e);
			}
		}
		// ui_pri_0005 standard note
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_0030 Start
		else if (e.getEventName().equalsIgnoreCase("EsmPri0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRateMQCRangeGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRateMQCRangeGuideline(e);
			} else {
				eventResponse = searchSvcScpNmCustTpNm(e);
			}
		}
		// ESM_PRI_0030 End

		// ---ui_pri_0001_07_start-----------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri000107Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContractClauseGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchContractClauseGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageContractClauseGuideline(e);
			}
		}
		// ---ui_pri_0001_07_end-----------------------------------------------------------

		// ---ESM_PRI_0007_start-----------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBoilerPlateGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBoilerPlateGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchBoilerPlateGuidelineList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchBoilerPlateGuidelineListExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageBoilerPlateGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = confirmBoilerPlateGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = cancelBoilerPlateGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = removeBoilerPlateGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = copyBoilerPlateGuideline(e);
			}
		}
		// ---ESM_PRI_0007_end-----------------------------------------------------------

		// ESM_PRI_0064 Start
		else if (e.getEventName().equalsIgnoreCase("EsmPri0064Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGRIGroupCommodityGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createGRIGroupCommodityGuideline(e);
			}
		}
		// ESM_PRI_0064 End

		else if (e.getEventName().equalsIgnoreCase("EsmPri0104Event")) {
			eventResponse = searchItemSurchargeCodeList(e);
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri0105Event")) {
			eventResponse = searchItemSurchargeCodeList(e);
		}

		// ESM_PRI_0067 Start
		else if (e.getEventName().equalsIgnoreCase("EsmPri0067Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = uploadArbitraryChargeGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = searchCodeCheckResult(e);
			} else {
				eventResponse = searchArbitraryChargeComboExcelList(e);
			}
		}
		// ESM_PRI_0006 End
		else if (e.getEventName().equalsIgnoreCase("EsmPri0006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGuidelineTerms(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGuidelineCopy(e);
			}
		}
		
		// ---ESM_PRI_0010_start-----------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBasicStandardNoteGuidelineInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBasicStandardNoteGuidelineInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchBasicStandardNoteGuidelineInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchBasicStandardNoteGuidelineInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchBasicStandardNoteGuidelineInquiryList(e);
			} else {
				eventResponse = searchCommonBasicStandardNoteGuidelineList(e);
			}
		}
		// ---ESM_PRI_0012_start-----------------------------------------------------------
		else if (e.getEventName().equalsIgnoreCase("EsmPri0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBasicStandardNoteConversionGuidelineInqueryList(e);
			} else {
				eventResponse = searchCommonStandardNoteConversionGuidelineInqueryList(e);
			}
		}
		
		// ---ESM_PRI_0008_start-----------------------------------------------------------
		else if (e.getEventName().equalsIgnoreCase("EsmPri0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBasicStandardNoteConversionGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBasicStandardNoteConversionTemporaryCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageBasicStandardNoteConversionGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageBasicStandardNoteConversionTemporaryCopy(e);
			} else {
				eventResponse = searchCommonStandardNoteConversionGuidelineList(e);
			}
		}
		// ---ESM_PRI_0008_end-----------------------------------------------------------
		
		// ESM_PRI_0053 Start
		else if (e.getEventName().equalsIgnoreCase("EsmPri0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRateMQCRangeGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRateMQCRangeGuideline(e);
			} else {
				eventResponse = searchSvcScpNmCustTpNm(e);
			}
		}
		
		// ---ESM_PRI_0002_01_start-------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri000201Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationDetailInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGroupLocationInquiryListExcel(e);
			}
		}		
		// ---ESM_PRI_0002_02_start-------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri000202Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSalesGuidelineInquiryList(e);
			}
		}
		// ---ESM_PRI_0002_03_start-------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri000203Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupCommodityGuidelineInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityGuidelineDtlInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGroupCommodityGuidelineExcelInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchGroupCommodityGuideInquiryCustTypeCount(e);
			}
		}
		// ---ui_pri_0002_07_start--------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri000207Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContractClauseGuidelineInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchContractClauseGuidelineInquiryList(e);
			} else {
				eventResponse = searchCommonContractClauseGuidelineInquiryList(e);
			}
		}
		// ---ESM_PRI_0011_start-----------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBoilerPlateGuidelineInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBoilerPlateGuidelineInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchBoilerPlateGuidelineInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchBoilerPlateGuidelineInquiryYear(e);
			}
			 else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchBoilerPlateGuidelineInquiryDuration(e);
			}
		}
		// ---ESM_PRI_0011_end-----------------------------------------------------------	
		
		// ---ESM_PRI_0002_04_start-----------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri000204Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchArbitraryChargeGuidelineInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchArbitraryChargeTypeCountInquiryList(e);
			}
		}
		// ---ESM_PRI_0002_04_end-----------------------------------------------------------
		
		// ---ESM_PRI_0002_05_start-----------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri000205Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGOHChargeGuidelineInquiryList(e);
			} else {
				eventResponse = initGohComboData(e);  // 화면 최초 호출 시 실행
			}
		}
		// ---ESM_PRI_0002_05_end-----------------------------------------------------------
		
		// ---ESM_PRI_0021_start-----------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri0021Event")) {
			eventResponse = initRoutePointComboData(e); // 화면 최초 호출 시 실행
		}
		// ---ESM_PRI_0021_end-----------------------------------------------------------
		
		return eventResponse;
	}

	// SCGuidelineMain
	/**
	 * ESM_PRI_0001 : SVC_SCP_CD.Change<br>
	 * 선택된 Service Scope에 등록된 Guideline 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGuidelineScopeEffectiveDateList(Event e) throws EventException {
		EsmPri0001Event event = (EsmPri0001Event) e;
		SCGuidelineMainBC command = new SCGuidelineMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGlineScpEffDtListVO> list = command.searchGuidelineScopeEffectiveDateList(event.getPriSgMnVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0002 : SVC_SCP_CD.Change<br>
	 * SC Guideline Inquiry - 선택된 Service Scope에 등록된 Guideline 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGuidelineScopeEffectiveDateInquiryList(Event e) throws EventException {
		EsmPri0002Event event = (EsmPri0002Event) e;
		SCGuidelineMainBC command = new SCGuidelineMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGlineScpEffDtListVO> list = command.searchGuidelineScopeEffectiveDateList(event.getPriSgMnVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001 : Retrieve<br>
	 * SC Guideline 메인화면을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGuidelineMain(Event e) throws EventException {
		EsmPri0001Event event = (EsmPri0001Event) e;
		SCGuidelineMainBC command = new SCGuidelineMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGlineMnVO> list = command.searchGuidelineMain(event.getPriSgMnVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0002 : Retrieve<br>
	 * SC Guideline Inquiry - 메인화면을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGuidelineInquiryMain(Event e) throws EventException {
		EsmPri0002Event event = (EsmPri0002Event) e;
		SCGuidelineMainBC command = new SCGuidelineMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGlineMnVO> list = command.searchGuidelineMain(event.getPriSgMnVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001 : Retrieve<br>
	 * 하위 탭들에 데이터가 존재하는지 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGuidelineTermsCount(Event e) throws EventException {
		EsmPri0001Event event = (EsmPri0001Event) e;
		SCGuidelineMainBC command = new SCGuidelineMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGlineTermsCntVO> list = command.searchGuidelineTermsCount(event.getPriSgMnVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0002 : Retrieve<br>
	 * SC Guideline Inquiry - 하위 탭들에 데이터가 존재하는지 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGuidelineTermsCountInquiry(Event e) throws EventException {
		EsmPri0002Event event = (EsmPri0002Event) e;
		SCGuidelineMainBC command = new SCGuidelineMainBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGlineTermsCntVO> list = command.searchGuidelineTermsCount(event.getPriSgMnVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001 : Save<br>
	 * Guideline Main 트랜잭션 데이터를 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageGuidelineMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0001Event event = (EsmPri0001Event) e;
		SCGuidelineMainBC command = new SCGuidelineMainBCImpl();
		try {
			begin();
			command.manageGuidelineMain(event.getPriSgMnVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001 : Confirm<br>
	 * Guideline을 Confirm합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse confirmGuidelineMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0001Event event = (EsmPri0001Event) e;
		SCGuidelineMainBC command = new SCGuidelineMainBCImpl();
		try {
			begin();
			command.confirmGuidelineMain(event.getPriSgMnVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001 : Confirm Cancel<br>
	 * Confirm된 Guideline을 Cancel합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse cancelGuidelineMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0001Event event = (EsmPri0001Event) e;
		SCGuidelineMainBC command = new SCGuidelineMainBCImpl();
		try {
			begin();
			command.cancelGuidelineMain(event.getPriSgMnVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001 : Delete<br>
	 * Guideline Main에서 Guideline을 삭제한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse removeGuidelineMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0001Event event = (EsmPri0001Event) e;

		SCGuidelineMainBC command1 = new SCGuidelineMainBCImpl();
		SCSalesGuidelineBC command2 = new SCSalesGuidelineBCImpl();
		SCGroupLocationGuidelineBC command3 = new SCGroupLocationGuidelineBCImpl();
		SCGroupCommodityGuidelineBC command4 = new SCGroupCommodityGuidelineBCImpl();
		SCArbitraryChargeGuidelineBC command5 = new SCArbitraryChargeGuidelineBCImpl();
		SCRateGuidelineBC command6 = new SCRateGuidelineBCImpl();
		SCGOHChargeGuidelineBC command7 = new SCGOHChargeGuidelineBCImpl();
		SCContractClauseGuidelineBC command8 = new SCContractClauseGuidelineBCImpl();

		try {
			begin();
			command2.removeGuidelineMain(event.getPriSgMnVO());
			command3.removeGuidelineMain(event.getPriSgMnVO());
			command4.removeGuidelineMain(event.getPriSgMnVO());
			command5.removeGuidelineMain(event.getPriSgMnVO());
			command6.removeGuidelineMain(event.getPriSgMnVO());
			command7.removeGuidelineMain(event.getPriSgMnVO());
			command8.removeGuidelineMain(event.getPriSgMnVO());
			command1.removeGuidelineMain(event.getPriSgMnVO());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001 : Copy<br>
	 * Guideline Main을 Copy한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse copyGuidelineMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0001Event event = (EsmPri0001Event) e;
		SCGuidelineMainBC command = new SCGuidelineMainBCImpl();
		try {
			begin();
			command.copyGuidelineMain(event.getPriSgMnVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// -----------ESM_PRI_0001_05_start----------------------------------------------------------

	/**
	 * ESM_PRI_0001_05 : OPEN<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initGohComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
//		EsmPri000105Event event = (EsmPri000105Event) e;
		PRICommonBC command = new PRICommonBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RsltCdListVO> list = command.searchCurrencyCodeList(new RsltCdListVO());
			eventResponse.setCustomData("currCd", list);
			List<RsltCdListVO> list1 = command.searchPerCodeList(new RsltCdListVO());
			eventResponse.setCustomData("perCd", list1);
			CodeUtil cdUtil = CodeUtil.getInstance(); 
			ArrayList<CodeInfo> codeSelect = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01708",0);
			eventResponse.setCustomData("barCd", codeSelect);			
		}catch(EventException ex){
			throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_0001_05 : RETRIEVE<br>
	 * G.O.H 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGOHChargeGuidelineList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000105Event event = (EsmPri000105Event) e;
		SCGOHChargeGuidelineBC command = new SCGOHChargeGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RsltPriSgGohChgVO> list = command.searchGOHChargeGuidelineList(event.getPriSgGohChgVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}

	/**
     * ESM_PRI_0001_05 : Save<br>
	 * G.O.H 정보를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageGOHChargeGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri000105Event event = (EsmPri000105Event) e;
		SCGOHChargeGuidelineBC command = new SCGOHChargeGuidelineBCImpl();
		try {
			begin();
			command.manageGOHChargeGuideline(event.getPriSgGohChgVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// -----------ESM_PRI_0001_05_end----------------------------------------------------------

	// -----------ESM_PRI_0001_04_start----------------------------------------------------------

	/**
	 * ESM_PRI_0001_04 : OPEN<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initArbComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
//		EsmPri000104Event event = (EsmPri000104Event) e;
		PRICommonBC command = new PRICommonBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RsltCdListVO> list = command.searchCurrencyCodeList(new RsltCdListVO());
			eventResponse.setCustomData("currCd", list);
			List<RsltCdListVO> list1 = command.searchPerCodeList(new RsltCdListVO());
			eventResponse.setCustomData("perCd", list1);
						
			CodeUtil cdUtil = CodeUtil.getInstance(); 
			ArrayList<CodeInfo> transSelect = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01720",0);
			eventResponse.setCustomData("transCd", transSelect);	
			ArrayList<CodeInfo> termOrgSelect = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02138",0);
			eventResponse.setCustomData("termOrgCd", termOrgSelect);
			ArrayList<CodeInfo> termDesSelect = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02139",0);
			eventResponse.setCustomData("termDesCd", termDesSelect);			
			ArrayList<CodeInfo> cargoSelect = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02202",0);
			eventResponse.setCustomData("cargoCd", cargoSelect);			
		}catch(EventException ex){
			throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}		
	
	
	/**
     * ESM_PRI_0001_04 : Open<br>
	 * S/C ArbitraryChargeGuideline Type의 Count를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeTypeCountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000104Event event = (EsmPri000104Event) e;
		SCArbitraryChargeGuidelineBC command = new SCArbitraryChargeGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriSgArbTypeVO> list = command.searchArbitraryChargeTypeCountList(event.getPriSgArbVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001_04 : RETRIEVE<br>
	 * S/C ArbitraryChargeGuideline 데이터를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeGuidelineList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000104Event event = (EsmPri000104Event) e;
		SCArbitraryChargeGuidelineBC command = new SCArbitraryChargeGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RsltPriSgArbVO> list = command.searchArbitraryChargeGuidelineList(event.getPriSgArbVO());			
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
     * ESM_PRI_0001_04 : Save<br>
	 * S/C ArbitraryChargeGuideline 정보를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageArbitraryChargeGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri000104Event event = (EsmPri000104Event) e;
		SCArbitraryChargeGuidelineBC command = new SCArbitraryChargeGuidelineBCImpl();
		try {
			begin();
			command.manageArbitraryChargeGuideline(event.getPriSgArbVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// -----------ESM_PRI_0001_04_end----------------------------------------------------------
	// -----------ESM_PRI_0001_03_start----------------------------------------------------------
	/**
     * ESM_PRI_0001_03 : Retrieve<br>
	 * S/C GuideLine Commodity Group 정보를 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityGuidelineList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000103Event event = (EsmPri000103Event) e;
		SCGroupCommodityGuidelineBC command = new SCGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriSgGrpCmdtVO> list = command.searchGroupCommodityGuidelineList(event.getPriSgGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
     * ESM_PRI_0001_03 : Sheet1_Click()<br>
	 * S/C GuideLine Commodity Group Detail 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityGuidelineDtlList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000103Event event = (EsmPri000103Event) e;
		SCGroupCommodityGuidelineBC command = new SCGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriSgGrpCmdtDtlVO> list = command.searchGroupCommodityGuidelineDtlList(event.getPriSgGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
     * ESM_PRI_0001_03 : Save<br>
	 * S/C GuideLine Commodity Group 정보를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageGroupCommodityGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri000103Event event = (EsmPri000103Event) e;
		SCGroupCommodityGuidelineBC command = new SCGroupCommodityGuidelineBCImpl();
		try {
			begin();
			command.manageGroupCommodityGuideline(event.getGrpCmdtGlineVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();

		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
     * ESM_PRI_0001_03 : Down Excel<br>
	 * Excel Down Load를 위하여 S/C GuideLine Commodity Group, Detail 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityGuidelineExcelList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000103Event event = (EsmPri000103Event) e;
		SCGroupCommodityGuidelineBC command = new SCGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriSgGrpCmdtExcelVO> list = command.searchGroupCommodityGuidelineExcelList(event.getPriSgGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
     * ESM_PRI_0001_03 : Down Excel<br>
	 * Customer Type의 Bold를 표시하기 위하여 각 Customer Type별 Count를 구합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityGuideCustTypeCount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000103Event event = (EsmPri000103Event) e;
		SCGroupCommodityGuidelineBC command = new SCGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriSgGrpCmdtCustTypeVO> vos = command
			.searchGroupCommodityGuideCustTypeCount(event.getPriSgGrpCmdtVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
     * ESM_PRI_0001_03 : Save<br>
	 * rate에서 사용하는 데이터는 삭제를 금지하기 위한 rate 사용데이터를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse checkGroupCommodityInUse(Event e) throws EventException {
		EsmPri000103Event event = (EsmPri000103Event) e;
		SCGroupCommodityGuidelineBC command = new SCGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltCdListVO> vos = command.checkGroupCommodityInUse(event.getPriSgGrpCmdtVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	

	// -----------ESM_PRI_0001_03_end----------------------------------------------------------

	// SCSalesGuideline - START
	/**
	 * ESM_PRI_0001_01 : Open<br>
	 * Sales Guideline의 데이터 내역을 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSalesGuidelineList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000101Event event = (EsmPri000101Event) e;
		SCSalesGuidelineBC command = new SCSalesGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriSgSlsRefVO> list = command.searchSalesGuidelineList(event.getPriSgSlsRefVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001_01 : Save<br>
	 * Sales Guideline 데이터의 CUD 멀티 이벤트를 처리합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageSalesGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri000101Event event = (EsmPri000101Event) e;
		SCSalesGuidelineBC command = new SCSalesGuidelineBCImpl();

		try {
			begin();
			command.manageSalesGuideline(event.getPriSgSlsRefVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// SCSalesGuideline - END

	// SCGroupLocationGuideline - START
	/**
	 * ESM_PRI_0001_02 : Open<br>
	 * Guideline - GroupLocation을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000102Event event = (EsmPri000102Event) e;
		SCGroupLocationGuidelineBC command = new SCGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriSgGrpLocVO> vos = command.searchGroupLocationList(event.getPriSgGrpLocVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001_02 : Sheet1.Select<br>
	 * Guideline - GroupLocation Detail을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000102Event event = (EsmPri000102Event) e;
		SCGroupLocationGuidelineBC command = new SCGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriSgGrpLocDtlVO> vos = command.searchGroupLocationDetailList(event.getPriSgGrpLocDtlVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0001_02 : Delete<br>
	 * Group Location삭제시, Rate에서 사용하고 있는 코드인지 확인한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse checkGroupLocationInUse(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000102Event event = (EsmPri000102Event) e;
		SCGroupLocationGuidelineBC command = new SCGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<RsltCdListVO> vos = command.checkGroupLocationInUse(event.getPriSgGrpLocVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001_02 : Down Excel<br>
	 * Excel Download를 위해 Group Location을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationListExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000102Event event = (EsmPri000102Event) e;
		SCGroupLocationGuidelineBC command = new SCGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltPriSgGrpLocExcelVO> vos = command.searchGroupLocationListExcel(event.getPriSgGrpLocVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001_02 : Save<br>
	 * Group Location 데이터에 대한 CUD 이벤트를 처리합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageGroupLocationGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri000102Event event = (EsmPri000102Event) e;
		SCGroupLocationGuidelineBC command = new SCGroupLocationGuidelineBCImpl();

		try {
			begin();
			command.manageGroupLocationGuideline(event.getGrpLocGlineVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// SCGroupLocationGuideline - END

	// SCRateGuideline - START
	/**
	 * ESM_PRI_0001_06 : OPEN<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initRateComboData(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			
			ArrayList<CodeInfo> custTypeCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01714", 0);
			
			List<RsltCdListVO> ratUtCdList = command.searchPerCodeList(new RsltCdListVO());
			ArrayList<CodeInfo> prcCgoTpCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02202", 0);
			List<RsltCdListVO> currCdList = command.searchCurrencyCodeList(new RsltCdListVO());
			
			ArrayList<CodeInfo> termOrgCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02138", 0);
			ArrayList<CodeInfo> termDestCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02139", 0);
			ArrayList<CodeInfo> noteClassCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01711", 0);
			ArrayList<CodeInfo> transModeCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01720", 0);
			
			eventResponse.setCustomData("custTypeCdList", custTypeCdList);
			eventResponse.setCustomData("ratUtCdList", ratUtCdList);
			eventResponse.setCustomData("prcCgoTpCdList", prcCgoTpCdList);
			eventResponse.setCustomData("currCdList", currCdList);
			eventResponse.setCustomData("termOrgCdList", termOrgCdList);
			eventResponse.setCustomData("termDestCdList", termDestCdList);
			eventResponse.setCustomData("noteClassCdList", noteClassCdList);
			eventResponse.setCustomData("transModeCdList", transModeCdList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0001_06 : Open<br>
	 * Rate Guideline Commdity 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityList(Event e) throws EventException {
		EsmPri000106Event event = (EsmPri000106Event) e;
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			RsltRtCmdtListVO vo = command.searchRateCommodityList(event.getPriSgRtCmdtHdrVO());

			eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
			eventResponse.setRsVoList(vo.getPriSgRtCmdtVOS());
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0002_06 : Open<br>
	 * Rate Guideline Commdity 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityInquiryList(Event e) throws EventException {
		EsmPri000206Event event = (EsmPri000206Event) e;
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			RsltRtCmdtListVO vo = command.searchRateCommodityList(event.getPriSgRtCmdtHdrVO());

			eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
			eventResponse.setRsVoList(vo.getPriSgRtCmdtVOS());
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001_06 : Sheet1.Select<br>
	 * Rate Guideline Route 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRateRouteList(Event e) throws EventException {
		EsmPri000106Event event = (EsmPri000106Event) e;
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltRtRoutHdrListVO> vos = command.searchRateRouteList(event.getPriSgRtCmdtRoutVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0002_06 : Sheet1.Select<br>
	 * Rate Guideline Route 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRateRouteInquiryList(Event e) throws EventException {
		EsmPri000206Event event = (EsmPri000206Event) e;
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltRtRoutHdrListVO> vos = command.searchRateRouteList(event.getPriSgRtCmdtRoutVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001_06 : Sheet2.Select<br>
	 * Rate Guideline Rate 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRateList(Event e) throws EventException {
		EsmPri000106Event event = (EsmPri000106Event) e;
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			RsltRtRoutListVO vo = command.searchRateList(event.getPriSgRtVO());
			eventResponse.setRsVoList(vo.getRsltRtListVOS());
			eventResponse.setRsVoList(vo.getOrgRsltRtRoutPntListVOS());
			eventResponse.setRsVoList(vo.getOrgRsltRtRoutViaListVOS());
			eventResponse.setRsVoList(vo.getDestRsltRtRoutViaListVOS());
			eventResponse.setRsVoList(vo.getDestRsltRtRoutPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0002_06 : Sheet2.Select<br>
	 * Rate Guideline Rate 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRateInquiryList(Event e) throws EventException {
		EsmPri000206Event event = (EsmPri000206Event) e;
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			RsltRtRoutListVO vo = command.searchRateList(event.getPriSgRtVO());
			eventResponse.setRsVoList(vo.getRsltRtListVOS());
			eventResponse.setRsVoList(vo.getOrgRsltRtRoutPntListVOS());
			eventResponse.setRsVoList(vo.getOrgRsltRtRoutViaListVOS());
			eventResponse.setRsVoList(vo.getDestRsltRtRoutViaListVOS());
			eventResponse.setRsVoList(vo.getDestRsltRtRoutPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001_06 : Down Excel<br>
	 * Rate Guideline Excel Download를 위해 Rate 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRateListExcel(Event e) throws EventException {
		EsmPri000106Event event = (EsmPri000106Event) e;
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltRtListExcelVO> vos = command.searchRateListExcel(event.getPriSgRtCmdtHdrVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0002_06 : Down Excel<br>
	 * Rate Guideline Excel Download를 위해 Rate 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRateInquiryListExcel(Event e) throws EventException {
		EsmPri000206Event event = (EsmPri000206Event) e;
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltRtListExcelVO> vos = command.searchRateListExcel(event.getPriSgRtCmdtHdrVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001_06 : Open<br>
	 * Radio Button 표시를 위한 Customer Type을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRateCustomerType(Event e) throws EventException {
		EsmPri000106Event event = (EsmPri000106Event) e;
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltRtCustTpVO> vos = command.searchRateCustomerType(event.getPriSgRtCmdtHdrVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0002_06 : Open<br>
	 * Radio Button 표시를 위한 Customer Type을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRateCustomerTypeInquiry(Event e) throws EventException {
		EsmPri000206Event event = (EsmPri000206Event) e;
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltRtCustTpVO> vos = command.searchRateCustomerType(event.getPriSgRtCmdtHdrVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001_06 : Save<br>
	 * Rate Commodity Header 데이터의 CUD 트랜잭션 이벤트를 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageRateCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri000106Event event = (EsmPri000106Event) e;
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();

		try {
			begin();
			command.manageRateCommodity(event.getScRtGlineCmdtVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0001_06 : Save<br>
	 * Rate Commodity - Route 데이터의 CUD 트랜잭션 이벤트를 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageRateRoute(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri000106Event event = (EsmPri000106Event) e;
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();

		try {
			begin();
			command.manageRateRoute(event.getScRtGlineRoutVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
     * ESM_PRI_0120 : Open<br>
     * SC Guideline Rate Vertical Excel Import 화면의 Combo Item 들을 조회합니다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initRateExcelVertical(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        try{
            CodeUtil cdUtil = CodeUtil.getInstance();
            List<RsltCdListVO> customData = null; 
            List<CodeInfo> codeInfos = null;

            // Per Type Code List
            customData = command.searchPerCodeList(new RsltCdListVO());
            eventResponse.setCustomData("perCd", customData);

            // 공통 Cargo Code List
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01701", 0);
            eventResponse.setCustomData("cargoTpCd", codeInfos);
            
            // 공통 Term Origin
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02138", 0);
            eventResponse.setCustomData("termOrgCd", codeInfos);

            // 공통 Term Destination
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02139", 0);
            eventResponse.setCustomData("termDestCd", codeInfos);

            // 공통  Trans. Mode
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01720", 0);
            eventResponse.setCustomData("transMdCd", codeInfos);

            // Excel Template File Key
            ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
            comUpldFileVO.setFileUpldNm("SG_Rate_Templet_V.xls");
            String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
            eventResponse.setCustomData("templateKey", fileKey);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0120 : Check<br>
     * SC Guideline Rate Vertical Excel 의 정합성을 체크합니다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse checkRateExcelVertical(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0120Event event = (EsmPri0120Event) e;
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();

		try {
			List<RsltCdListVO> vos = command.checkRateExcelVertical(event.getPriSgRtCmdtHdrVO(), event.getRsltRtListExcelVOS());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
    
    /**
     * ESM_PRI_0120 : Save<br>
     * SC Guideline Rate Vertical Excel 로 RFA Guideline Rate를 생성합니다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse uploadRateExcelVertical(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0120Event event = (EsmPri0120Event) e;
        SCRateGuidelineBC command = new SCRateGuidelineBCImpl();

        try {
            begin();
            command.uploadRateExcelVertical(event.getPriSgRtCmdtHdrVO(), event.getRsltRtListExcelVOS(), account);
            //eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

	// SCRateGuideline - END

	// ESM_PRI_0005 standard note
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_0005 : Retrieve<br>
	 * SCGuideline- Basic Standard Note 타이틀 , 본문을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBasicStandardNoteGuidelineList(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsmPri0005Event event = (EsmPri0005Event) e;
		SCBasicStandardNoteGuidelineBC command = new SCBasicStandardNoteGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();


		try {
			// 컨테이너 vo
			StndNoteGlineVO cVo = new StndNoteGlineVO();
			// searchGubun 1:헤더, 2:타이틀, 3:본문, 4:전체, 5:Duration
			String searchGubun = event.getStndnoteglinevo().getSearchGubun();

			log.debug("*********************************************************");
			log.debug("searchGubun : " + searchGubun);
			log.debug("*********************************************************");

			// note list
			List<PriSgStndNoteHdrVO> priSgStndNoteHdr = new ArrayList<PriSgStndNoteHdrVO>();
			List<PriSgStndNoteVO> priSgStndNote = new ArrayList<PriSgStndNoteVO>();
			List<PriSgStndNoteCtntVO> priSgStndNoteCtnt = new ArrayList<PriSgStndNoteCtntVO>();

			if ("1".equals(searchGubun)) {
				// 컨테이너 vo로 조회 결과 리턴

				cVo = command.searchBasicStandardNoteGuidelineHdrList(event.getPriSgStndNoteHdrVO());
			} else if ("5".equals(searchGubun)) {
				// 컨테이너 vo로 조회 결과 리턴

				cVo = command.searchBasicStandardNoteGuidelineHdrDurationList(event.getPriSgStndNoteHdrVO());
			} else {
				// 컨테이너 vo로 조회 결과 리턴
				cVo = command.searchBasicStandardNoteGuidelineList(event.getPriSgStndNoteVO(), searchGubun);
			}

			// 컨테이너 vo에서 각 조회결과를 뽑아서 response에 세팅

			if ("1".equals(searchGubun)) {
				priSgStndNoteHdr = cVo.getPriSgStndNoteHdr();
				eventResponse.setRsVoList(priSgStndNoteHdr);
			} else if ("2".equals(searchGubun)) {
				priSgStndNote = cVo.getPriSgStndNote();
				eventResponse.setRsVoList(priSgStndNote);
			} else if ("3".equals(searchGubun)) {
				priSgStndNoteCtnt = cVo.getPriSgStndNoteCtnt();
				eventResponse.setRsVoList(priSgStndNoteCtnt);
			}
			// 마스터, 디테일을 동시에 받는다.
			else if ("4".equals(searchGubun)) {

				priSgStndNote = cVo.getPriSgStndNote();
				eventResponse.setRsVoList(priSgStndNote);

				priSgStndNoteCtnt = cVo.getPriSgStndNoteCtnt();
				eventResponse.setRsVoList(priSgStndNoteCtnt);
			} else if ("5".equals(searchGubun)) {
				priSgStndNoteHdr = cVo.getPriSgStndNoteHdr();
				eventResponse.setRsVoList(priSgStndNoteHdr);
			}

		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0005 : DOWNLOAD EXCEL<br>
	 * SCGuideline- Basic Standard Note 타이틀 , 본문을 다운로드한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBasicStandardNoteGuidelineExcelList(Event e) throws EventException {
		EsmPri0005Event event = (EsmPri0005Event) e;
		SCBasicStandardNoteGuidelineBC command = new SCBasicStandardNoteGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriSgStndNoteCtntVO> list = command.searchBasicStandardNoteGuidelineExcelList(event.getRsltPriSgStndNoteCtntVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0005 : Save
	 * SCBasic Standard Note를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageBasicStandardNoteGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0005Event event = (EsmPri0005Event) e;
		SCBasicStandardNoteGuidelineBC command1 = new SCBasicStandardNoteGuidelineBCImpl();
		SCNoteConversionProposalBC command2 = new SCNoteConversionProposalBCImpl();
		PriSgStndNoteVO[] 	  priSgStndNoteVOs = null;
		PriSgStndNoteCtntVO[] priSgStndNoteCtntVOs = null;
		RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO = new RsltPriSgStndNoteHdrCopyVO();

		PriSgStndNoteVO priSgStndNoteVO = new PriSgStndNoteVO();

		try {
			begin();

			//conversion delete
			priSgStndNoteVOs 		= event.getStndnoteglinevo().getPrisgstndnotevos();
			priSgStndNoteCtntVOs 	= event.getStndnoteglinevo().getPrisgstndnotectntvos();

			//standard note title
			for (int i = 0; priSgStndNoteVOs != null && i < priSgStndNoteVOs.length; i++) {

				PriSgStndNoteCtntVO priSgStndNoteCtntVO = new PriSgStndNoteCtntVO();

				priSgStndNoteCtntVO.setSvcScpCd(priSgStndNoteVOs[i].getSvcScpCd());
				priSgStndNoteCtntVO.setNoteHdrSeq(priSgStndNoteVOs[i].getNoteHdrSeq());
				priSgStndNoteCtntVO.setNoteSeq(priSgStndNoteVOs[i].getNoteSeq());

				//conversion 삭제
				if ( priSgStndNoteVOs[i].getIbflag().equals("D")){
					command2.removeScStndNoteConversion(priSgStndNoteCtntVO);
					//디테일을 이미 삭제 했으므로 널로 세팅
					priSgStndNoteCtntVOs = null;
				}
			}

			//standard note content delete
			for (int i = 0; priSgStndNoteCtntVOs != null && i < priSgStndNoteCtntVOs.length; i++) {
				PriSgStndNoteCtntVO priSgStndNoteCtntVO = new PriSgStndNoteCtntVO();
				priSgStndNoteCtntVO.setSvcScpCd(priSgStndNoteCtntVOs[i].getSvcScpCd());
				priSgStndNoteCtntVO.setNoteHdrSeq(priSgStndNoteCtntVOs[i].getNoteHdrSeq());
				priSgStndNoteCtntVO.setNoteSeq(priSgStndNoteCtntVOs[i].getNoteSeq());
				priSgStndNoteCtntVO.setNoteCtntSeq(priSgStndNoteCtntVOs[i].getNoteCtntSeq());

				//conversion 삭제
				if ( priSgStndNoteCtntVOs[i].getIbflag().equals("D")){
					command2.removeScStndNoteConversion(priSgStndNoteCtntVO);
				}
			}

			//duration 수정시 conversion duration 수정
			rsltPriSgStndNoteHdrCopyVO = event.getRsltPriSgStndNoteHdrCopyVO();
			//duration 수정되었으면
			if(!rsltPriSgStndNoteHdrCopyVO.getEffDt().equals(rsltPriSgStndNoteHdrCopyVO.getEffDtHidden())
				|| !rsltPriSgStndNoteHdrCopyVO.getExpDt().equals(rsltPriSgStndNoteHdrCopyVO.getExpDtHidden())) {
				command2.modifyDurationScStndNoteConversion(rsltPriSgStndNoteHdrCopyVO, account);
			}

			//standard note 저장
			priSgStndNoteVO = command1.manageBasicStandardNoteGuideline(event.getStndnoteglinevo(), account);

			//저장시 키값을 etc 에 리턴
			eventResponse.setETCData("note_hdr_seq", priSgStndNoteVO.getNoteHdrSeq());
//			log.debug("*********************************************************");
//			log.debug("note_hdr_seq : " + eventResponse.getETCData("note_hdr_seq"));
//			log.debug("*********************************************************");
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage()); 
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0005 : Confirm
	 * 사용자가 노트를 컨폼한다<br>
	 * Basic Standard Note 의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse confirmBasicStandardNoteGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0005Event event = (EsmPri0005Event) e;
		SCBasicStandardNoteGuidelineBC command = new SCBasicStandardNoteGuidelineBCImpl();
		try {
			begin();
			command.confirmBasicStandardNoteGuideline(event.getPriSgStndNoteHdrVO(), account);
			commit();
		}  catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0005 : Confirm Cancel
	 * 사용자가 노트를 컨폼 cancel한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse cancelBasicStandardNoteGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0005Event event = (EsmPri0005Event) e;
		SCBasicStandardNoteGuidelineBC command = new SCBasicStandardNoteGuidelineBCImpl();
		try {
			begin();
			command.cancelBasicStandardNoteGuideline(event.getPriSgStndNoteHdrVO(), account);
			commit();
		}  catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0005 : Delete
	 * 사용자가 노트를 삭제한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse removeBasicStandardNoteGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0005Event event = (EsmPri0005Event) e;
		SCBasicStandardNoteGuidelineBC command1 = new SCBasicStandardNoteGuidelineBCImpl();
		SCNoteConversionProposalBC command2	 = new SCNoteConversionProposalBCImpl();
		try {
			begin();
			//conversion delete
			PriSgStndNoteCtntVO priSgStndNoteCtntVO = new PriSgStndNoteCtntVO();
			priSgStndNoteCtntVO.setSvcScpCd(event.getPriSgStndNoteHdrVO().getSvcScpCd());
			priSgStndNoteCtntVO.setNoteHdrSeq(event.getPriSgStndNoteHdrVO().getNoteHdrSeq());
			command2.removeScStndNoteConversion(priSgStndNoteCtntVO);
			//note delete
			command1.removeBasicStandardNoteGuideline(event.getPriSgStndNoteHdrVO());
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00102", new String[] {}).getUserMessage()); 
			commit();
		}  catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0005 : Copy
	 * 사용자가 노트를 복사한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse copyBasicStandardNoteGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0005Event event = (EsmPri0005Event) e;
		SCBasicStandardNoteGuidelineBC command1 = new SCBasicStandardNoteGuidelineBCImpl();
		SCNoteConversionProposalBC command2 = new SCNoteConversionProposalBCImpl();
		
		PriSgStndNoteVO priSgStndNoteVO = new PriSgStndNoteVO();
		
		try {
			begin();
			priSgStndNoteVO = command1.copyBasicStandardNoteGuideline(event.getRsltPriSgStndNoteHdrCopyVO(), account);
			event.getRsltPriSgStndNoteHdrCopyVO().setNoteHdrSeq(priSgStndNoteVO.getNoteHdrSeq());
			command2.copyScStndNoteConversion(event.getRsltPriSgStndNoteHdrCopyVO(), account);
			
			//저장시 키값을 etc 에 리턴
			eventResponse.setETCData("note_hdr_seq", priSgStndNoteVO.getNoteHdrSeq());
//			log.debug("*********************************************************");
//			log.debug("note_hdr_seq : " + eventResponse.getETCData("note_hdr_seq"));
//			log.debug("*********************************************************");
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00110", new String[] {}).getUserMessage()); 
			commit();
		}  catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_0005 standard note
	// ////////////////////////////////////////////////////////////////////////////////

	// ESM_PRI_0007 boiler plate
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_0007 : Retrieve<br>
	 * Boiler Plate 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBoilerPlateGuidelineList(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsmPri0007Event event = (EsmPri0007Event) e;
		SCBoilerPlateGuidelineBC command = new SCBoilerPlateGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriSgBlplHdrVO> priSgBlplHdrVOList = new ArrayList<PriSgBlplHdrVO>();
			List<PriSgBlplVO> priSgBlplVOList = new ArrayList<PriSgBlplVO>();
			List<PriSgBlplCtntVO> priSgBlplCtntVOList = new ArrayList<PriSgBlplCtntVO>();

			// 컨테이너 vo
			ScBlplGlineVO cVo = new ScBlplGlineVO();
			// searchGubun 1:타이틀, 2:본문
			String searchGubun = event.getScBlplGlineVO().getSearchGubun();

			log.debug("*********************************************************");
			log.debug("searchGubun : " + searchGubun);
			log.debug("*********************************************************");

			PriSgBlplVO priSgBlplVO = event.getScBlplGlineVO().getPriSgBlplVO();

			// 컨테이너 vo로 조회 결과 리턴
			if ("1".equals(searchGubun)) {
				// 컨테이너 vo로 조회 결과 리턴

				cVo = command.searchBoilerPlateGuidelineHdrList(event.getPriSgBlplHdrVO());
			} else {
				cVo = command.searchBoilerPlateGuidelineList(priSgBlplVO, searchGubun);
			}

			// 컨테이너 vo에서 각 조회결과를 뽑아서 response에 세팅

			if ("1".equals(searchGubun)) {
				priSgBlplHdrVOList = cVo.getPriSgBlplHdrVOList();
				eventResponse.setRsVoList(priSgBlplHdrVOList);
			} else if ("2".equals(searchGubun)) {
				priSgBlplVOList = cVo.getPriSgBlplVOList();
				eventResponse.setRsVoList(priSgBlplVOList);
			} else if ("3".equals(searchGubun)) {
				priSgBlplCtntVOList = cVo.getPriSgBlplCtntVOList();
				eventResponse.setRsVoList(priSgBlplCtntVOList);
			} else if ("4".equals(searchGubun)) {

				priSgBlplVOList = cVo.getPriSgBlplVOList();
				eventResponse.setRsVoList(priSgBlplVOList);

				priSgBlplCtntVOList = cVo.getPriSgBlplCtntVOList();
				eventResponse.setRsVoList(priSgBlplCtntVOList);
			}

		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0007 : Save<br>
	 * Boiler Plate 정보를 저장합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageBoilerPlateGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0007Event event = (EsmPri0007Event) e;
		SCBoilerPlateGuidelineBC command = new SCBoilerPlateGuidelineBCImpl();
		try {
			begin();
			command.manageBoilerPlateGuideline(event.getScBlplGlineVO(), account);
			commit();
		}  catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * contract clause confirm<br>
	 * Boiler Plate 를 생성하고 나서 Confirm 한다.
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse confirmBoilerPlateGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0007Event event = (EsmPri0007Event) e;
		SCBoilerPlateGuidelineBC command = new SCBoilerPlateGuidelineBCImpl();
		try {
			begin();
			command.confirmBoilerPlateGuideline(event.getPriSgBlplHdrVO(), account);
			commit();
		}  catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * contract clause cancel<br>
	 * Confirm 했던 Boiler Plate 를 Cancel 한다
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse cancelBoilerPlateGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0007Event event = (EsmPri0007Event) e;
		SCBoilerPlateGuidelineBC command = new SCBoilerPlateGuidelineBCImpl();
		try {
			begin();
			command.cancelBoilerPlateGuideline(event.getPriSgBlplHdrVO(), account);
			commit();
		}  catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * contract clause remove<br>
	 * 작성했던 BoilerPlate 를 삭제한다.
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse removeBoilerPlateGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0007Event event = (EsmPri0007Event) e;
		SCBoilerPlateGuidelineBC command = new SCBoilerPlateGuidelineBCImpl();
		try {
			begin();
			command.removeBoilerPlateGuideline(event.getPriSgBlplHdrVO());
			commit();
		}  catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * contract clause copy<br>
	 * 대상 Boiler Plate 를 Copy 하여 신규 생성한다.
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse copyBoilerPlateGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0007Event event = (EsmPri0007Event) e;
		SCBoilerPlateGuidelineBC command = new SCBoilerPlateGuidelineBCImpl();
		try {
			begin();
			command.copyBoilerPlateGuideline(event.getRsltPriSgBlplHdrCopyVO(), account);
			commit();
		}  catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_0007 : Down Excel<br>
     * Excel 로 저장할 Boiler Plate 정보를 조회합니다.<br>
     * 
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    private EventResponse searchBoilerPlateGuidelineListExcel(Event e) throws EventException {

        // PDTO(Data Transfer Object including Parameters)
        EsmPri0007Event event = (EsmPri0007Event) e;
        SCBoilerPlateGuidelineBC command = new SCBoilerPlateGuidelineBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<PriSgBlplExcelVO> list = command.searchBoilerPlateGuidelineListExcel(event.getPriSgBlplHdrVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	// ESM_PRI_0007 boiler plate
	// ////////////////////////////////////////////////////////////////////////////////

	// ESM_PRI_0001_07 contract clause
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * contract clause 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchContractClauseGuidelineList(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsmPri000107Event event = (EsmPri000107Event) e;
		SCContractClauseGuidelineBC command = new SCContractClauseGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriSgCtrtCluzVO> priSgCtrtClusVOList = new ArrayList<PriSgCtrtCluzVO>();
			List<PriSgCtrtCluzDtlVO> priSgCtrtClusDtlVOList = new ArrayList<PriSgCtrtCluzDtlVO>();

			// 컨테이너 vo
			CtrtCluzGlineVO cVo = new CtrtCluzGlineVO();
			// searchGubun 1:타이틀, 2:본문
			String searchGubun = event.getCtrtCluzGlineVO().getSearchGubun();

			log.debug("*********************************************************");
			log.debug("searchGubun : " + searchGubun);
			log.debug("*********************************************************");

			PriSgCtrtCluzVO priSgCtrtCluzVO = event.getCtrtCluzGlineVO().getPriSgCtrtCluzVO();

			// 컨테이너 vo로 조회 결과 리턴
			cVo = command.searchContractClauseGuidelineList(priSgCtrtCluzVO, searchGubun);


			// 컨테이너 vo에서 각 조회결과를 뽑아서 response에 세팅

			if ("1".equals(searchGubun)) {
				priSgCtrtClusVOList = cVo.getPriSgCtrtClusVOList();
				eventResponse.setRsVoList(priSgCtrtClusVOList);
			} else if ("2".equals(searchGubun)) {
				priSgCtrtClusDtlVOList = cVo.getPriSgCtrtClusDtlVOList();
				eventResponse.setRsVoList(priSgCtrtClusDtlVOList);
			}
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * contract clause 를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageContractClauseGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri000107Event event = (EsmPri000107Event) e;
		SCContractClauseGuidelineBC command = new SCContractClauseGuidelineBCImpl();
		try {
			begin();
			command.manageContractClauseGuideline(event.getCtrtCluzGlineVO(), account);
			commit();
		}  catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_0001_07 contract clause
	// ////////////////////////////////////////////////////////////////////////////////

	/**
	 * ESM_PRI_0030, ESM_PRI_0053 : Open
	 * S/C Guideline MQC 화면의 초기데이터를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSvcScpNmCustTpNm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			PriSgRtMqcRngVO paramVo = new PriSgRtMqcRngVO();
			if (e.getEventName().equalsIgnoreCase("EsmPri0030Event")) {
				EsmPri0030Event event = (EsmPri0030Event) e;
				paramVo = event.getPriSgRtMqcRngVO();
			} else if (e.getEventName().equalsIgnoreCase("EsmPri0053Event")) {
				EsmPri0053Event event = (EsmPri0053Event) e;
				paramVo = event.getPriSgRtMqcRngVO();
			}
			
			String svcScpCd = null;
			String prcCustTpCd = null;

			if (paramVo != null) {
				svcScpCd = paramVo.getSvcScpCd();
				prcCustTpCd = paramVo.getPrcCustTpCd();
			} else {
				svcScpCd = "";
				prcCustTpCd = "";
			}

			// Service Scope Code Name
			String svcScpNm = command.searchServiceScopeCodeDetailName(svcScpCd);
			
			eventResponse.setCustomData("SvcScpNm", svcScpNm);

			// Customer Type Name
			CodeUtil cdUtil = CodeUtil.getInstance();
			String prcCustTpNm = cdUtil.getCodeName("CD01714", prcCustTpCd);
			eventResponse.setCustomData("PrcCustTpNm", prcCustTpNm);

		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0030, ESM_PRI_0053 : Retrieve<br>
	 * S/C Guideline MQC 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRateMQCRangeGuidelineList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			PriSgRtMqcRngVO paramVo = new PriSgRtMqcRngVO();
			if (e.getEventName().equalsIgnoreCase("EsmPri0030Event")) {
				EsmPri0030Event event = (EsmPri0030Event) e;
				paramVo = event.getPriSgRtMqcRngVO();
			} else if (e.getEventName().equalsIgnoreCase("EsmPri0053Event")) {
				EsmPri0053Event event = (EsmPri0053Event) e;
				paramVo = event.getPriSgRtMqcRngVO();
			}
			List<PriSgRtMqcRngVO> list = command.searchRateMQCRangeList(paramVo);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0030, ESM_PRI_0053 : Save
	 * S/C Guideline MQC 정보를 저장합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageRateMQCRangeGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0030Event event = (EsmPri0030Event) e;
		SCRateGuidelineBC command = new SCRateGuidelineBCImpl();
		try {
			begin();
			command.manageRateMQCRange(event.getPriSgRtMqcRngVOS(), account);
            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0064 : Open<br>
	 * Surcharge Group Commodity 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGRIGroupCommodityGuidelineList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri0064Event event = (EsmPri0064Event) e;
		SCGroupCommodityGuidelineBC command = new SCGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriScgGrpCmdtVO> list = command.searchGRIGroupCommodityGuidelineList(event.getPriScgGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0064 : OK<br>
	 * Guideline TPW Group Commodity 정보를 생성합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createGRIGroupCommodityGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0064Event event = (EsmPri0064Event) e;
		SCGroupCommodityGuidelineBC command = new SCGroupCommodityGuidelineBCImpl();
		try {
			begin();
			command.createGRIGroupCommodityGuideline(event.getPriGriGrpCmdtVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0067 : SAVE<br>
	 * 엑셀파일정보를 업로드한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse uploadArbitraryChargeGuideline(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0067Event event = (EsmPri0067Event) e;
		SCArbitraryChargeGuidelineBC command = new SCArbitraryChargeGuidelineBCImpl();
		try {
			begin();
			command.uploadArbitraryChargeGuideline(event.getPriSgArbVOS(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
        return eventResponse;
	}
	
	/**
	 * ESM_PRI_0067 : CHECK<br>
	 * 엑셀파일정보를 VALIDATION체크한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCodeCheckResult(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri0067Event event = (EsmPri0067Event) e;
		SCArbitraryChargeGuidelineBC command = new SCArbitraryChargeGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriSgArbVO> list = command.searchCodeCheckResult(event.getPriSgArbVOS());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0067 : OPEN<br>
	 * 콤보 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeComboExcelList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri0067Event event = (EsmPri0067Event) e;
		RsltCdListVO rsltCdListVO = new RsltCdListVO();
		List<RsltCdListVO> list = null;
		PRICommonBC command1 = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			//PRC_TRSP_MOD_CD
			rsltCdListVO.setCd("CD01720");
			list = command1.searchComCodeDescList(rsltCdListVO);
			eventResponse.setCustomData("PRC_TRSP_MOD_CD", list);
			
			//PRC_CGO_TP_CD
			rsltCdListVO.setCd("CD02202");
			list = command1.searchComCodeDescList(rsltCdListVO);
			eventResponse.setCustomData("PRC_CGO_TP_CD", list);
			
			//RCV_DE_TERM_CD
			if(event.getRsltPriSgArbKeyVO().getOrgDestTpCd().equals("D")) {
				rsltCdListVO.setCd("CD02139");
			} else {
				rsltCdListVO.setCd("CD02138");
			}			
			list = command1.searchComCodeDescList(rsltCdListVO);
			eventResponse.setCustomData("RCV_DE_TERM_CD", list);
						
			//RAT_UT_CD
			list = command1.searchPerCodeList(new RsltCdListVO());
			eventResponse.setCustomData("RAT_UT_CD", list);
			
			//CURR_CD
			list = command1.searchCurrencyCodeList(new RsltCdListVO());
			eventResponse.setCustomData("CURR_CD", list);
			
			//Excel Template File Key
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			if(event.getRsltPriSgArbKeyVO().getOrgDestTpCd().equals("D")) {
				comUpldFileVO.setFileUpldNm("SG_Arb_Templet_D.xls");
			} else {
				comUpldFileVO.setFileUpldNm("SG_Arb_Templet_O.xls");
			}
			String fileKey = command1.searchExcelTemplateFileKey(comUpldFileVO); 
			eventResponse.setCustomData("templateKey", fileKey);

		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0104 : Open<br>
	 * Combo 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchItemSurchargeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();


		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			List<?> cdList = (List<?>) cdUtil.getCodeSelect("CD01711", 0); // List<CodeInfo>
			
			List<RsltCdListVO> list = command.searchSurchargeCodeList(new RsltCdListVO());

			eventResponse.setCustomData("item", cdList);
			eventResponse.setCustomData("surcharge", list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0006 : Search <br>
	 * Guideline의 Terms가 존재하는지 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGuidelineTerms(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri0006Event event = (EsmPri0006Event) e;
		SCGuidelineMainBC command = new SCGuidelineMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGlineTermsCntVO> list = command.searchGuidelineTermsCount(event.getPriSgMnVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0006 : Save <br>
	 * 선택한 Guideline의 내용을 해당 Terms로 Copy 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageGuidelineCopy(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri0006Event event = (EsmPri0006Event) e;
		SCGuidelineMainBC 				command01 = new SCGuidelineMainBCImpl();
		SCGroupLocationGuidelineBC 		command02 = new SCGroupLocationGuidelineBCImpl();
		SCGroupCommodityGuidelineBC 	command03 = new SCGroupCommodityGuidelineBCImpl();
		SCArbitraryChargeGuidelineBC 	command04 = new SCArbitraryChargeGuidelineBCImpl();
		SCGOHChargeGuidelineBC 			command05 = new SCGOHChargeGuidelineBCImpl();
		SCRateGuidelineBC 				command06 = new SCRateGuidelineBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		GlineMnCpVO glineMnCpVO = event.getGlineMnCpVO();
		
		try {
			PriSgMnVO priSgMnVO = new PriSgMnVO();
			priSgMnVO.setSvcScpCd(glineMnCpVO.getTrgtSvcScpCd());
			priSgMnVO.setEffDt(glineMnCpVO.getTrgtEffDt());
			priSgMnVO.setExpDt(glineMnCpVO.getTrgtExpDt());
			
			// guidemain eff_date 유효성검사
			boolean isValidDate = command01.checkGuidelineEffectiveDate(priSgMnVO);
			
			if(isValidDate == false) {
				throw new EventException(new ErrorHandler("PRI08018", new String[]{}).getMessage());
			}
			
			// guidemain seq 채번하여 변수에 저장
			String newGlineSeq = command01.getGuidelineSeq(priSgMnVO);
			
			glineMnCpVO.setTrgtGlineSeq(newGlineSeq);
			glineMnCpVO.setCreUsrId(account.getUsr_id());
			glineMnCpVO.setUpdUsrId(account.getUsr_id());
			
			begin();
			command01.copyGuidelineMainAll(glineMnCpVO); // guidemain copy
			
			if("Y".equals(glineMnCpVO.getLocGrp())) {
				command02.copyGuidelineMain(glineMnCpVO); // group location guideline copy
			}
			if("Y".equals(glineMnCpVO.getCmdtGrp())) {
				command03.copyGuidelineMain(glineMnCpVO); // commodity guideline copy
			}
			if("Y".equals(glineMnCpVO.getOrgArb())) {
				glineMnCpVO.setOrgDestTpCd("O");
				command04.copyGuidelineMain(glineMnCpVO); // org arbitrary guideline copy
			}
			if("Y".equals(glineMnCpVO.getDestArb())) {
				glineMnCpVO.setOrgDestTpCd("D");
				command04.copyGuidelineMain(glineMnCpVO); // dest arbitrary guideline copy
			}
			if("Y".equals(glineMnCpVO.getGoh())) {
				command05.copyGuidelineMain(glineMnCpVO); // GOH guideline copy
			}
			if("Y".equals(glineMnCpVO.getRate())) {
				command06.copyGuidelineMain(glineMnCpVO); // rate guideline copy
			}
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		
		eventResponse.setRsVo(glineMnCpVO);
		return eventResponse;
	}

	/**
	 * ESM_PRI_0008 : OPEN<br>
	 * Standard Note Conversion 화면로딩시 콤보데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonStandardNoteConversionGuidelineList(Event e) throws EventException {
		EsmPri0008Event event = (EsmPri0008Event) e;
		//SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
		
		try {
 			////////////////////COMMON - START/////////////////////
        	//TYPE
            vo.setCd("CD01710");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RULE_APPL_CHG_TP_CD", list);
        	
            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);
            
            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);
            
            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);
                        
            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);
            
            //US SVC MODE
            vo.setCd("CD01729");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_USA_SVC_MOD_CD", list);
			
			//RECEIVING TERM
            vo.setCd("CD02192");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_RCV_TERM_CD", list);

			//DELIVERY TERM
            vo.setCd("CD02191");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DE_TERM_CD", list);

			//CARGO TYPE(in S/C)
            vo.setCd("CD02202");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_CGO_TP_CD", list);
            //////////////////////COMMON - END///////////////////////
                       	
        	//PER TYPE  
        	list = command.searchAllPerCodeList(vo);
        	eventResponse.setCustomData("BKG_RAT_UT_CD", list);
			        	
			//CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);
			
			//PER TYPE(in S/C)
        	list = command.searchAllPerCodeList(vo);
        	eventResponse.setCustomData("CONV_RAT_UT_CD", list);
        	
        	//GRI COMMODITY
			vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
			vo.setEtc2("");
			list = command.searchScgGrpCmdtCdList(vo);
			eventResponse.setCustomData("BKG_SCG_GRP_CMDT_CD", list);

			//NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
            //추후에 변경할것.
			vo.setEtc1("S"); // 계약 유형: S->S/C,  R->RFA,  T->TRI
			vo.setEtc2("T"); // CONVERSION TYPE CODE
			list = command.searchNoteConvRuleMapgList(vo);
			eventResponse.setCustomData("RULE_CD", list);
						
            // Scope Charge Code List
			vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
			vo.setEtc2("");
            list = command.searchScopeChargeCodeList(vo);
            eventResponse.setCustomData("CHARGE_CD", list);            
                      
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0008 : RETRIEVE<br>
	 * Standard Note Conversion 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicStandardNoteConversionGuidelineList(Event e) throws EventException {
		EsmPri0008Event event = (EsmPri0008Event) e;
		SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriScNoteConvVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0008 : PASTE<br>
	 * Standard Note Conversion 정보를 붙여넣기한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicStandardNoteConversionTemporaryCopy(Event e) throws EventException {
		EsmPri0008Event event = (EsmPri0008Event) e;
		SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionListCopy(event.getPriScNoteConvVO(), account);	        
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	
		
	/**
	 * ESM_PRI_0008 : SAVE<br>
	 * Standard Note Conversion 정보를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBasicStandardNoteConversionGuideline(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0008Event event = (EsmPri0008Event) e;
		SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
		try {
			begin();
			command.manageNoteConversion(event.getPriScNoteConvListVOs(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
        return eventResponse;
	}
	
	/**
	 * ESM_PRI_0008 : COPY<br>
	 * Standard Note Conversion 정보를 COPY한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBasicStandardNoteConversionTemporaryCopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0008Event event = (EsmPri0008Event) e;
		SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
		try {
			begin();
			command.manageNoteConversionCopy(event.getPriScNoteConvListVOs(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00110",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
        return eventResponse;
	}	
	
	/**
	 * ESM_PRI_0002_01 : TAB<br>
	 * LOCATION GROUP CODE 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000201Event event = (EsmPri000201Event) e;
		SCGroupLocationGuidelineBC command = new SCGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriSgGrpLocVO> list = command.searchGroupLocationList(event.getPriSgGrpLocVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0002_01 : SHEET1@ROWS<br>
	 * LOCATION CODE 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationDetailInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000201Event event = (EsmPri000201Event) e;
		SCGroupLocationGuidelineBC command = new SCGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriSgGrpLocDtlVO> list = command.searchGroupLocationDetailList(event.getPriSgGrpLocDtlVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0002_01 : DOWN EXCEL<br>
	 * LOCATION GROUP 정보를 다운로드한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationInquiryListExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000201Event event = (EsmPri000201Event) e;
		SCGroupLocationGuidelineBC command = new SCGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriSgGrpLocExcelVO> list = command.searchGroupLocationListExcel(event.getPriSgGrpLocVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0002_02 : TAB<br>
	 * SALES 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSalesGuidelineInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000202Event event = (EsmPri000202Event) e;
		SCSalesGuidelineBC command = new SCSalesGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriSgSlsRefVO> list = command.searchSalesGuidelineList(event.getPriSgSlsRefVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	// -----------ESM_PRI_0002_03_start----------------------------------------------------------
	/**
	 * ESM_PRI_0002_03 : TAB<br>
	 * COMMODITY GROUP 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityGuidelineInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000203Event event = (EsmPri000203Event) e;
		SCGroupCommodityGuidelineBC command = new SCGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriSgGrpCmdtVO> list = command.searchGroupCommodityGuidelineList(event.getPriSgGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0002_03 : SHEET1@ROW<br>
	 * COMMODITY GROUP DETAIL 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityGuidelineDtlInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000203Event event = (EsmPri000203Event) e;
		SCGroupCommodityGuidelineBC command = new SCGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriSgGrpCmdtDtlVO> list = command.searchGroupCommodityGuidelineDtlList(event.getPriSgGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0002_03 : DOWN EXCEL<br>
	 * COMMODITY GROUP 정보를 다운로드 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityGuidelineExcelInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000203Event event = (EsmPri000203Event) e;
		SCGroupCommodityGuidelineBC command = new SCGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriSgGrpCmdtExcelVO> list = command.searchGroupCommodityGuidelineExcelList(event.getPriSgGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0002_03 : CUSTOMER TYPE<br>
	 * COMMODITY GROUP 정보를 CUSTOMER TYPE별 데이터존재 유무를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityGuideInquiryCustTypeCount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000203Event event = (EsmPri000203Event) e;
		SCGroupCommodityGuidelineBC command = new SCGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriSgGrpCmdtCustTypeVO> vos = command
			.searchGroupCommodityGuideCustTypeCount(event.getPriSgGrpCmdtVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	// -----------ESM_PRI_0002_03_end----------------------------------------------------------
	/**
	 * ESM_PRI_0002_07 : OPEN<br>
	 * CONTRACT CLAUSE 화면로딩시 콤보데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonContractClauseGuidelineInquiryList(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
		
		try {
 			////////////////////COMMON - START/////////////////////
        	//ITEM
            vo.setCd("CD01711");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("NOTE_CLSS_CD", list);
            //////////////////////COMMON - END///////////////////////
                       	
        	//SURCHARGE
        	list = command.searchSurchargeCodeList(vo);
        	eventResponse.setCustomData("CHG_CD", list);
			        				                      
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0002_07 : TAB<br>
	 * CONTRACT CLAUSE 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchContractClauseGuidelineInquiryList(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsmPri000207Event event = (EsmPri000207Event) e;
		SCContractClauseGuidelineBC command = new SCContractClauseGuidelineBCImpl();

		List<PriSgCtrtCluzVO> priSgCtrtClusVOList = new ArrayList<PriSgCtrtCluzVO>();
		List<PriSgCtrtCluzDtlVO> priSgCtrtClusDtlVOList = new ArrayList<PriSgCtrtCluzDtlVO>();

		GeneralEventResponse eventResponse = new GeneralEventResponse();


		try {
			// 컨테이너 vo
			CtrtCluzGlineVO cVo = new CtrtCluzGlineVO();
			// searchGubun 1:타이틀, 2:본문
			String searchGubun = event.getCtrtCluzGlineVO().getSearchGubun();
			PriSgCtrtCluzVO priSgCtrtCluzVO = event.getCtrtCluzGlineVO().getPriSgCtrtCluzVO();

			// 컨테이너 vo로 조회 결과 리턴
			cVo = command.searchContractClauseGuidelineList(priSgCtrtCluzVO, searchGubun);

			// 컨테이너 vo에서 각 조회결과를 뽑아서 response에 세팅

			if ("1".equals(searchGubun)) {
				priSgCtrtClusVOList = cVo.getPriSgCtrtClusVOList();
				eventResponse.setRsVoList(priSgCtrtClusVOList);
			} else if ("2".equals(searchGubun)) {
				priSgCtrtClusDtlVOList = cVo.getPriSgCtrtClusDtlVOList();
				eventResponse.setRsVoList(priSgCtrtClusDtlVOList);
			}
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
     * ESM_PRI_0011 : Retrive<br>
     * Boiler Plate Inquiry List를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBoilerPlateGuidelineInquiryList(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsmPri0011Event event = (EsmPri0011Event) e;
		SCBoilerPlateGuidelineBC command = new SCBoilerPlateGuidelineBCImpl();

		List<PriSgBlplHdrVO> priSgBlplHdrVOList = new ArrayList<PriSgBlplHdrVO>();
		List<PriSgBlplVO> priSgBlplVOList = new ArrayList<PriSgBlplVO>();
		List<PriSgBlplCtntVO> priSgBlplCtntVOList = new ArrayList<PriSgBlplCtntVO>();

		// 컨테이너 vo
		ScBlplGlineVO cVo = new ScBlplGlineVO();
		// searchGubun 1:타이틀, 2:본문
		String searchGubun = event.getScBlplGlineVO().getSearchGubun();

		PriSgBlplVO priSgBlplVO = event.getScBlplGlineVO().getPriSgBlplVO();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// 컨테이너 vo로 조회 결과 리턴
			if ("1".equals(searchGubun)) {
				// 컨테이너 vo로 조회 결과 리턴
				cVo = command.searchBoilerPlateGuidelineHdrList(event.getPriSgBlplHdrVO());
			} else {
				cVo = command.searchBoilerPlateGuidelineList(priSgBlplVO, searchGubun);
			}

			// 컨테이너 vo에서 각 조회결과를 뽑아서 response에 세팅

			if ("1".equals(searchGubun)) {
				priSgBlplHdrVOList = cVo.getPriSgBlplHdrVOList();
				eventResponse.setRsVoList(priSgBlplHdrVOList);
			} else if ("2".equals(searchGubun)) {
				priSgBlplVOList = cVo.getPriSgBlplVOList();
				eventResponse.setRsVoList(priSgBlplVOList);
			} else if ("3".equals(searchGubun)) {
				priSgBlplCtntVOList = cVo.getPriSgBlplCtntVOList();
				eventResponse.setRsVoList(priSgBlplCtntVOList);
			} else if ("4".equals(searchGubun)) {

				priSgBlplVOList = cVo.getPriSgBlplVOList();
				eventResponse.setRsVoList(priSgBlplVOList);

				priSgBlplCtntVOList = cVo.getPriSgBlplCtntVOList();
				eventResponse.setRsVoList(priSgBlplCtntVOList);
			}
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SCArbitraryChargeGuideline Inquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeGuidelineInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000204Event event = (EsmPri000204Event) e;
		SCArbitraryChargeGuidelineBC command = new SCArbitraryChargeGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriSgArbVO> list = command.searchArbitraryChargeGuidelineList(event.getPriSgArbVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SCArbitraryChargeGuideline Inquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeTypeCountInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000204Event event = (EsmPri000204Event) e;
		SCArbitraryChargeGuidelineBC command = new SCArbitraryChargeGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriSgArbTypeVO> list = command.searchArbitraryChargeTypeCountList(event.getPriSgArbVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0002_05 : Retrieve<br>
	 * S/C Guideline GOH Charge 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchGOHChargeGuidelineInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri000205Event event = (EsmPri000205Event) e;
		SCGOHChargeGuidelineBC command = new SCGOHChargeGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriSgGohChgVO> list = command.searchGOHChargeGuidelineList(event.getPriSgGohChgVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
     * ESM_PRI_0011 : Open<br>
     * Boiler Plate Header Year를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBoilerPlateGuidelineInquiryYear(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsmPri0011Event event = (EsmPri0011Event) e;
		SCBoilerPlateGuidelineBC command = new SCBoilerPlateGuidelineBCImpl();	
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriSgBlplHdrVO> priSgBlplHdrVOList = command.searchBoilerPlateGuidelineInquiryYear(event.getPriSgBlplHdrVO());
			eventResponse.setRsVoList(priSgBlplHdrVOList);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
     * ESM_PRI_0011 : BLPL_REF_YR<br>
     * Boiler Plate Header Year를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBoilerPlateGuidelineInquiryDuration(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsmPri0011Event event = (EsmPri0011Event) e;
		SCBoilerPlateGuidelineBC command = new SCBoilerPlateGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriSgBlplHdrVO> priSgBlplHdrVOList = command.searchBoilerPlateGuidelineInquiryDuration(event.getPriSgBlplHdrVO());
			eventResponse.setRsVoList(priSgBlplHdrVOList);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * ESM_PRI_0010 : OPEN<br>
	 * SCGuideline- Basic Standard Note 화면로딩시 콤보데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonBasicStandardNoteGuidelineList(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
		
		try {
        	//CUSTOMER TYPE
            vo.setCd("CD01714");
            list = command.searchComCodeList(vo);
            eventResponse.setCustomData("PRC_CUST_TP_CD", list);
        	
            //SERVICE SCOPE
            list = command.searchServiceScopeCodeList(vo);
            eventResponse.setCustomData("SVC_SCP_CD", list);
            
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0010 : Retrieve<br>
	 * SCGuideline- Basic Standard Note 에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBasicStandardNoteGuidelineInquiryList(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsmPri0010Event event = (EsmPri0010Event) e;
		SCBasicStandardNoteGuidelineBC command = new SCBasicStandardNoteGuidelineBCImpl();

		// 컨테이너 vo
		StndNoteGlineVO cVo = new StndNoteGlineVO();
		// searchGubun 1:헤더, 2:타이틀, 3:본문, 4:전체, 5:Duration
		String searchGubun = event.getStndnoteglinevo().getSearchGubun();

		// note list
		List<PriSgStndNoteHdrVO> priSgStndNoteHdr = new ArrayList<PriSgStndNoteHdrVO>();
		List<PriSgStndNoteVO> priSgStndNote = new ArrayList<PriSgStndNoteVO>();
		List<PriSgStndNoteCtntVO> priSgStndNoteCtnt = new ArrayList<PriSgStndNoteCtntVO>();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			if ("1".equals(searchGubun)) {
				// 컨테이너 vo로 조회 결과 리턴

				cVo = command.searchBasicStandardNoteGuidelineHdrList(event.getPriSgStndNoteHdrVO());
			} else if ("5".equals(searchGubun)) {
				// 컨테이너 vo로 조회 결과 리턴

				cVo = command.searchBasicStandardNoteGuidelineHdrDurationList(event.getPriSgStndNoteHdrVO());
			} else {
				// 컨테이너 vo로 조회 결과 리턴
				cVo = command.searchBasicStandardNoteGuidelineList(event.getPriSgStndNoteVO(), searchGubun);
			}


			// 컨테이너 vo에서 각 조회결과를 뽑아서 response에 세팅

			if ("1".equals(searchGubun)) {
				priSgStndNoteHdr = cVo.getPriSgStndNoteHdr();
				eventResponse.setRsVoList(priSgStndNoteHdr);
			} else if ("2".equals(searchGubun)) {
				priSgStndNote = cVo.getPriSgStndNote();
				eventResponse.setRsVoList(priSgStndNote);
			} else if ("3".equals(searchGubun)) {
				priSgStndNoteCtnt = cVo.getPriSgStndNoteCtnt();
				eventResponse.setRsVoList(priSgStndNoteCtnt);
			}
			// 마스터, 디테일을 동시에 받는다.
			else if ("4".equals(searchGubun)) {

				priSgStndNote = cVo.getPriSgStndNote();
				eventResponse.setRsVoList(priSgStndNote);

				priSgStndNoteCtnt = cVo.getPriSgStndNoteCtnt();
				eventResponse.setRsVoList(priSgStndNoteCtnt);
			} else if ("5".equals(searchGubun)) {
				priSgStndNoteHdr = cVo.getPriSgStndNoteHdr();
				eventResponse.setRsVoList(priSgStndNoteHdr);
			}
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0012 : OPEN<br>
	 * Standard Note Conversion Inquiry 화면로딩시 콤보데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonStandardNoteConversionGuidelineInqueryList(Event e) throws EventException {
		EsmPri0012Event event = (EsmPri0012Event) e;
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
		
		try {
 			////////////////////COMMON - START/////////////////////
        	//TYPE
            vo.setCd("CD01710");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RULE_APPL_CHG_TP_CD", list);
        	
            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);
            
            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);
                        
            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);
            
            //US SVC MODE
            vo.setCd("CD01729");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_USA_SVC_MOD_CD", list);
			
			//RECEIVING TERM
            vo.setCd("CD02192");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_RCV_TERM_CD", list);

			//DELIVERY TERM
            vo.setCd("CD02191");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DE_TERM_CD", list);
            //////////////////////COMMON - END///////////////////////
                       	
        	//GRI COMMODITY
			vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
			vo.setEtc2("");
			list = command.searchScgGrpCmdtCdList(vo);
			eventResponse.setCustomData("BKG_SCG_GRP_CMDT_CD", list);

		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0012 : RETRIEVE<br>
	 * Standard Note Conversion 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicStandardNoteConversionGuidelineInqueryList(Event e) throws EventException {
		EsmPri0012Event event = (EsmPri0012Event) e;
		SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriScNoteConvVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * ESM_PRI_0021 : OPEN<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initRoutePointComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> transSelect = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01720",0);
			eventResponse.setCustomData("transCd", transSelect);	
			ArrayList<CodeInfo> termOrgSelect = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02138",0);
			eventResponse.setCustomData("termOrgCd", termOrgSelect);
			ArrayList<CodeInfo> termDesSelect = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02139",0);
			eventResponse.setCustomData("termDesCd", termDesSelect);
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}	

	
}