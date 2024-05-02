/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGuidelineSC.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.basic.SCArbitraryChargeGuidelineBC;
import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.basic.SCArbitraryChargeGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.event.EsmPri000104Event;
import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.event.EsmPri000204Event;
import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.event.EsmPri0067Event;
import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbTypeVO;
import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbVO;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.basic.SCBasicStandardNoteGuidelineBC;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.basic.SCBasicStandardNoteGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.event.EsmPri0005Event;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.event.EsmPri0008Event;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.event.EsmPri0010Event;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.event.EsmPri0012Event;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteCtntVO;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteHdrCopyVO;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.StndNoteGlineVO;
import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.basic.SCBoilerPlateGuidelineBC;
import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.basic.SCBoilerPlateGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.event.EsmPri0007Event;
import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.event.EsmPri0011Event;
import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.vo.PriSgBlplExcelVO;
import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.vo.ScBlplGlineVO;
import com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.basic.SCContractClauseGuidelineBC;
import com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.basic.SCContractClauseGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.event.EsmPri000107Event;
import com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.event.EsmPri000207Event;
import com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.vo.CtrtCluzGlineVO;
import com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.basic.SCGOHChargeGuidelineBC;
import com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.basic.SCGOHChargeGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.event.EsmPri000105Event;
import com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.event.EsmPri000205Event;
import com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.vo.RsltPriSgGohChgVO;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.basic.SCGroupCommodityGuidelineBC;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.basic.SCGroupCommodityGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.event.EsmPri000103Event;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.event.EsmPri000203Event;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.event.EsmPri0064Event;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.vo.PriSgGrpCmdtExcelVO;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.vo.RsltPriSgGrpCmdtCustTypeVO;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.vo.RsltPriSgGrpCmdtDtlVO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.basic.SCGroupLocationGuidelineBC;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.basic.SCGroupLocationGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.event.EsmPri000102Event;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.event.EsmPri000201Event;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocDtlVO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocExcelVO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.basic.SCGuidelineMainBC;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.basic.SCGuidelineMainBCImpl;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.event.EsmPri0001Event;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.event.EsmPri0002Event;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.event.EsmPri0006Event;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.integration.SCGuidelineMainDBDAO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.RsltGlineMnVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.RsltGlineTermsCntVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.basic.SCRateGuidelineBC;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.basic.SCRateGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event.EsmPri000106Event;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event.EsmPri000206Event;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event.EsmPri0030Event;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event.EsmPri0053Event;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event.EsmPri0120Event;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtCmdtListVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtCustTpVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtListExcelVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutHdrListVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutListVO;
import com.clt.apps.opus.esm.pri.scguideline.scsalesguideline.basic.SCSalesGuidelineBC;
import com.clt.apps.opus.esm.pri.scguideline.scsalesguideline.basic.SCSalesGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.scguideline.scsalesguideline.event.EsmPri000101Event;
import com.clt.apps.opus.esm.pri.scguideline.scsalesguideline.event.EsmPri000202Event;
import com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.basic.SCNoteConversionProposalBC;
import com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.basic.SCNoteConversionProposalBCImpl;
import com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.vo.RsltNoteConvVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComUpldFileVO;
import com.clt.syscommon.common.table.PriScgGrpCmdtVO;
import com.clt.syscommon.common.table.PriSgArbVO;
import com.clt.syscommon.common.table.PriSgBlplCtntVO;
import com.clt.syscommon.common.table.PriSgBlplHdrVO;
import com.clt.syscommon.common.table.PriSgBlplVO;
import com.clt.syscommon.common.table.PriSgCtrtCluzDtlVO;
import com.clt.syscommon.common.table.PriSgCtrtCluzVO;
import com.clt.syscommon.common.table.PriSgGrpCmdtVO;
import com.clt.syscommon.common.table.PriSgMnVO;
import com.clt.syscommon.common.table.PriSgRtMqcRngVO;
import com.clt.syscommon.common.table.PriSgSlsRefVO;
import com.clt.syscommon.common.table.PriSgStndNoteCtntVO;
import com.clt.syscommon.common.table.PriSgStndNoteHdrVO;
import com.clt.syscommon.common.table.PriSgStndNoteVO;

/**
 * handling business transaction about SCGuideline Business Logic ServiceCommand - SCGuideline
 * 
 * @author Park Sungsoo
 * @see SCGuidelineMainDBDAO
 * @since J2EE 1.4
 */

public class SCGuidelineSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for  SCGuideline system  biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SCGuideline system biz scenario closing<br>
	 *  clearing related UI_PRI_0001 objects<br>
	 */
	public void doEnd() {
		log.debug("SCGuidelineSC closing");
	}

	/**
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

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
				eventResponse = initGohComboData(e);
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
				eventResponse = initArbComboData(e); 
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
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
                eventResponse = checkBoilerPlateGuidelineUse(e);
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
				eventResponse = initGohComboData(e); 
			}
		}
		// ---ESM_PRI_0002_05_end-----------------------------------------------------------
		
		// ---ESM_PRI_0021_start-----------------------------------------------------------
		if (e.getEventName().equalsIgnoreCase("EsmPri0021Event")) {
			eventResponse = initRoutePointComboData(e);
		}
		// ---ESM_PRI_0021_end-----------------------------------------------------------
		
		return eventResponse;
	}

	// SCGuidelineMain
	/**
	 * ESM_PRI_0001 : SVC_SCP_CD.Change<br>
	 * Retrieving a registered Guideline list in selected Service Scope<br>
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
	 * Retrieving Guiline by selected service scope<br>
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
	 * SC Guideline Inquiry<br>
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
	 * Retrieving wheather below tabs have datas or not<br>
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
	 * Retrieving wheather below tabs have datas or not<br>
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
	 * Handiling a transaction data of Guideline Main<br>
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
	 * Confirming Guideline<br>
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
	 * Cancelling Confirmed Guideline<br>
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
	 * Cancelling Guideline in Guideline Main<br>
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
	 * Copying Guideline Main<br>
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
	 * Retrieving Combo Data<br>
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
	 * Retrieving G.O.H Information<br>
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
	 * Saving G.O.H information<br>
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
	 * Retrieving Combo Data<br>
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
	 * Retrieving a count of S/C ArbitraryChargeGuideline Type<br>
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
	 * Retrieving S/C ArbitraryChargeGuideline data<br>
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
	 * Saving S/C ArbitraryChargeGuideline information<br>
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
	 * Retrieving S/C GuideLine Commodity Group<br>
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
	 * Retrieving S/C GuideLine Commodity Group Detail information<br>
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
	 * Saving S/C GuideLine Commodity Group information<br>
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
	 * Retrieving S/C GuideLine Commodity Group, Detail information for excel downloading<br>
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
	 * Getting count by each customer type for showing bold of cutomer type<br>
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
	 * Retrieving rate information for prohibition of datas being used to rate<br>
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
	 * Retrieving a data history of Sales Guideline<br>
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
	 * Handling CUD multi event of datas of Sales Guideline<br>
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
	 * Retrieving Guideline - GroupLocation<br>
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
	 * Retrieving Guideline - GroupLocation Detail<br>
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
	 * Checking wheather a code is used to Rate when deleting Group Location<br>
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
	 * Retrieving Group Location for Excel Download<br>
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
	 * Retrieving Combo Data<br>
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
	 * Retrieving Rate Guideline Commdity<br>
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
	 * Retrieving Rate Guideline Commdity<br>
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
	 * Retrieving Rate Guideline Route.<br>
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
	 * Retrieving Rate Guideline Route <br>
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
	 * Retrieving Rate Guideline Rate list .<br>
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
	 * Retrieving Rate Guideline Rate list<br>
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
	 * Retrieving Rate list for Rate Guideline Excel Download<br>
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
	 * Retrieving Rate list for Rate Guideline Excel Download<br>
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
	 * Retrieving customer type for showing Ratio Button<br>
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
	 * Retrieving customer type for showing Ratio Button<br>
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
	 * Handling CUD trasaction of Rate Commodity Header's datas<br>
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
	 * Handling CUD trasaction of Rate Commodity - Route's datas<br>
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
     * Retrieving Combo item in a screen of SC Guideline Rate Vertical Excel Import<br>
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

            // common Cargo Code List
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01701", 0);
            eventResponse.setCustomData("cargoTpCd", codeInfos);
            
            // common Term Origin
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02138", 0);
            eventResponse.setCustomData("termOrgCd", codeInfos);

            // common Term Destination
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02139", 0);
            eventResponse.setCustomData("termDestCd", codeInfos);

            // common  Trans. Mode
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01720", 0);
            eventResponse.setCustomData("transMdCd", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0120 : Check<br>
     * Checking a compatibility of SC Guideline Rate Vertical Excel<br>
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
     * creation rate with SC Guideline Rate Vertical Excel<br>
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
	 * SCGuideline- Basic Standard Note <br>
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
			// searchGubun 1:Header, 2:Title, 3:Body, 4:Whole, 5:Duration
			String searchGubun = event.getStndnoteglinevo().getSearchGubun();

			log.debug("*********************************************************");
			log.debug("searchGubun : " + searchGubun);
			log.debug("*********************************************************");

			// note list
			List<PriSgStndNoteHdrVO> priSgStndNoteHdr = new ArrayList<PriSgStndNoteHdrVO>();
			List<PriSgStndNoteVO> priSgStndNote = new ArrayList<PriSgStndNoteVO>();
			List<PriSgStndNoteCtntVO> priSgStndNoteCtnt = new ArrayList<PriSgStndNoteCtntVO>();

			if ("1".equals(searchGubun)) {

				cVo = command.searchBasicStandardNoteGuidelineHdrList(event.getPriSgStndNoteHdrVO());
			} else if ("5".equals(searchGubun)) {

				cVo = command.searchBasicStandardNoteGuidelineHdrDurationList(event.getPriSgStndNoteHdrVO());
			} else {
				cVo = command.searchBasicStandardNoteGuidelineList(event.getPriSgStndNoteVO(), searchGubun);
			}

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
			// Getting master and detail at the same time
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
	 * Downloading the title and body of SCGuideline- Basic Standard Note<br>
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
	 * Saving SCBasic Standard Note<br>
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
					//Setting null because of deletion of detail
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

				//delete conversion
				if ( priSgStndNoteCtntVOs[i].getIbflag().equals("D")){
					command2.removeScStndNoteConversion(priSgStndNoteCtntVO);
				}
			}

			//Modifying conversion duration in case of duration modification
			rsltPriSgStndNoteHdrCopyVO = event.getRsltPriSgStndNoteHdrCopyVO();
			//if modifying duration
			if(!rsltPriSgStndNoteHdrCopyVO.getEffDt().equals(rsltPriSgStndNoteHdrCopyVO.getEffDtHidden())
				|| !rsltPriSgStndNoteHdrCopyVO.getExpDt().equals(rsltPriSgStndNoteHdrCopyVO.getExpDtHidden())) {
				command2.modifyDurationScStndNoteConversion(rsltPriSgStndNoteHdrCopyVO, account);
			}

			//Saving standard note
			priSgStndNoteVO = command1.manageBasicStandardNoteGuideline(event.getStndnoteglinevo(), account);

			//Return key value to etc when saving
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
	 * handling multi event of Basic Standard Note'event<br>
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
	 * Cancelling a confirmation of note by user<br>
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
	 * Deleting note by user<br>
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
	 * Copying note by user<br>
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
			
			//Retreiving key value to etc when saving
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
	 * Retrieving Boiler Plate information<br>
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


			ScBlplGlineVO cVo = new ScBlplGlineVO();
			// searchGubun 1:Title, 2:Body
			String searchGubun = event.getScBlplGlineVO().getSearchGubun();

			log.debug("*********************************************************");
			log.debug("searchGubun : " + searchGubun);
			log.debug("*********************************************************");

			PriSgBlplVO priSgBlplVO = event.getScBlplGlineVO().getPriSgBlplVO();


			if ("1".equals(searchGubun)) {

				cVo = command.searchBoilerPlateGuidelineHdrList(event.getPriSgBlplHdrVO());
			} else {
				cVo = command.searchBoilerPlateGuidelineList(priSgBlplVO, searchGubun);
			}

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
	 * Saving Boiler Plate information<br>
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
	 * Confirming after creating Boiler Plate
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
	 * Canceled confirmed Boiler Plate
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
	 * Deleting BoilerPlate
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
	 * Creating copyping Boilder plate
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
	 * Retrieving contract clause information<br>
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

			CtrtCluzGlineVO cVo = new CtrtCluzGlineVO();
			// searchGubun 1:title, 2:Body
			String searchGubun = event.getCtrtCluzGlineVO().getSearchGubun();

			log.debug("*********************************************************");
			log.debug("searchGubun : " + searchGubun);
			log.debug("*********************************************************");

			PriSgCtrtCluzVO priSgCtrtCluzVO = event.getCtrtCluzGlineVO().getPriSgCtrtCluzVO();

			cVo = command.searchContractClauseGuidelineList(priSgCtrtCluzVO, searchGubun);

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
	 * check to S/C(PRI_SP_MN Table) in use<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 * @LastModifyDate : 2014.10.07
	 */
	private EventResponse checkBoilerPlateGuidelineUse(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsmPri0007Event event = (EsmPri0007Event) e;
		SCBoilerPlateGuidelineBC command = new SCBoilerPlateGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			int chkcnt = command.checkBoilerPlateGuidelineUse(event.getPriSgBlplHdrVO());
			eventResponse.setETCData("CNT", String.valueOf(chkcnt));

		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Saving contract clause <br>
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
	 * Retrieving initial data of S/C Guideline MQC<br>
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
	 * Retrieving S/C Guideline MQC list<br>
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
	 * Saving S/C Guideline MQC information<br>
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
	 * Retrieving Surcharge Group Commodity information<br>
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
	 * Creating Guideline TPW Group Commodity information<br>
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
	 * Uploading excel file<br>
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
	 * checking validation of excel file<br>
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
	 * checking wheather Guideline의 Terms exists or not<br>
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
	 * copying a seleted guideline into relative Terms<br>
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
			
			// checking guidemain eff_date validation 
			boolean isValidDate = command01.checkGuidelineEffectiveDate(priSgMnVO);
			
			if(isValidDate == false) {
				throw new EventException(new ErrorHandler("PRI08018", new String[]{}).getMessage());
			}
			
			//Saving numbered guidemain seq to varable guidemain seq
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
	 * Retreiving Standard Note Conversion's combo data when loading a screen<br>
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

     		//NOTE CONVERSION RULE CODE ( By CONVERSION TYPE)

			vo.setEtc1("S"); // Agreement type: S->S/C,  R->RFA,  T->TRI
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
	 * Retrieving Standard Note Conversion information<br>
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
	 * Pasting Standard Note Conversion information<br>
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
	 * Saving Standard Note Conversion information<br>
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
	 * Copying Standard Note Conversion information<br>
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
	 * Retrieving LOCATION GROUP CODE information<br>
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
	 * Retrieving LOCATION CODE information<br>
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
	 * Downloading LOCATION GROUP information<br>
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
	 * REtrieving SALES information<br>
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
	 * Retrieving COMMODITY GROUP information<br>
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
	 * Retrieving COMMODITY GROUP DETAIL information<br>
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
	 * Downloading COMMODITY GROUP information<br>
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
	 * Retrieving wheather COMMODITY GROUP information exists or not by customer type<br>
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
	 * Retrieving combo data when loading a screen of CONTRACT CLAUSE<br>
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
	 * Retrieving CONTRACT CLAUSE information<br>
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

			CtrtCluzGlineVO cVo = new CtrtCluzGlineVO();
			// searchGubun 1:Title, 2:Body
			String searchGubun = event.getCtrtCluzGlineVO().getSearchGubun();
			PriSgCtrtCluzVO priSgCtrtCluzVO = event.getCtrtCluzGlineVO().getPriSgCtrtCluzVO();


			cVo = command.searchContractClauseGuidelineList(priSgCtrtCluzVO, searchGubun);

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
     * Retrieving Boiler Plate Inquiry List<br>
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

		ScBlplGlineVO cVo = new ScBlplGlineVO();
		// searchGubun 1:title, 2:body
		String searchGubun = event.getScBlplGlineVO().getSearchGubun();

		PriSgBlplVO priSgBlplVO = event.getScBlplGlineVO().getPriSgBlplVO();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			if ("1".equals(searchGubun)) {

				cVo = command.searchBoilerPlateGuidelineHdrList(event.getPriSgBlplHdrVO());
			} else {
				cVo = command.searchBoilerPlateGuidelineList(priSgBlplVO, searchGubun);
			}

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
	 * Handling retrieving event<br>	 
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
	 * Handling retrieving event<br>
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
	 * Retrieving S/C Guideline GOH Charge information<br>
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
     * Retrieving Boiler Plate Header Year<br>
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
     * Retrieving Boiler Plate Header Year<br>
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
	 * Retrieving combo data when loading SCGuideline- Basic Standard Note screen<br>
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
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBasicStandardNoteGuidelineInquiryList(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsmPri0010Event event = (EsmPri0010Event) e;
		SCBasicStandardNoteGuidelineBC command = new SCBasicStandardNoteGuidelineBCImpl();

		StndNoteGlineVO cVo = new StndNoteGlineVO();
		// searchGubun 1:Header, 2:Title, 3:Body, 4:Whole, 5:Duration
		String searchGubun = event.getStndnoteglinevo().getSearchGubun();

		// note list
		List<PriSgStndNoteHdrVO> priSgStndNoteHdr = new ArrayList<PriSgStndNoteHdrVO>();
		List<PriSgStndNoteVO> priSgStndNote = new ArrayList<PriSgStndNoteVO>();
		List<PriSgStndNoteCtntVO> priSgStndNoteCtnt = new ArrayList<PriSgStndNoteCtntVO>();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			if ("1".equals(searchGubun)) {

				cVo = command.searchBasicStandardNoteGuidelineHdrList(event.getPriSgStndNoteHdrVO());
			} else if ("5".equals(searchGubun)) {

				cVo = command.searchBasicStandardNoteGuidelineHdrDurationList(event.getPriSgStndNoteHdrVO());
			} else {
				cVo = command.searchBasicStandardNoteGuidelineList(event.getPriSgStndNoteVO(), searchGubun);
			}

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
	 * Retrieving combo data when loading Standard Note Conversion Inquiry screen<br>
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
	 * Retrieving Standard Note Conversion information<br>
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
	 * Retrieving Combo Data<br>
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