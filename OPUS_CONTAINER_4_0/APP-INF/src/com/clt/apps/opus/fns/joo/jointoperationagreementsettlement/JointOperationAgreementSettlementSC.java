/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : JointOperationAgreementSettlementSC.java
*@FileTitle : Tax Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic.CarrierSettlementProcessBC;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic.CarrierSettlementProcessBCImpl;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0007Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0009Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0010Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0011Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0012Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0015Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0036Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0037Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0038Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0039Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0042Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0043Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0045Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0049Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0050Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0053Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0054Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0055Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0056Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0057Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0081Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0084Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0086Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0087Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustSettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConversionAndOptionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConversionConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrPreviousVvdPortVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrSettlementBackupReportVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrStandardFormatVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.LoadingQtyVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ManualStlVvdVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsStatusVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrByLaneVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrLoadVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SettlementRFVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SlotXchLaneVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SlotXchPartnerVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlStatusVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrByLaneVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.basic.JointOperationAccrualCreationBC;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.basic.JointOperationAccrualCreationBCImpl;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo0029Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo0030Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo0032Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo0033Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo003401Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo003402Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo0074Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.ActRsltRVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdCarVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdVvdVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.SettlementConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic.JointOperationConsultationBC;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic.JointOperationConsultationBCImpl;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0016Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0017Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0020Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0022Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0023Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0024Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0025Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0044Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0068Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0080Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration.JointOperationConsultationDBDAO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CmbConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedGrpVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrSlipVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.LostCombinedDataVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipProcessVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.TaxVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic.JointOperationMasterDataMgtBC;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic.JointOperationMasterDataMgtBCImpl;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBC;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBCImpl;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.clt.apps.opus.fns.joo.joocommonutil.BizComJooUtil;
import com.clt.apps.opus.fns.joo.joocommonutil.JooConstants;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.AccountPayableInvoiceSC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.bizcommon.util.BizComUtil;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.StringUtil;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.JooEstmClzVO;
import com.clt.syscommon.common.table.JooSettlementVO;
import com.clt.syscommon.common.table.JooStlCmbDtlVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;


/**
 * OPUS-JointOperationAgreementSettlement Business Logic ServiceCommand -
 * handling business transaction
 *
 * @author
 * @see JointOperationConsultationDBDAO
 * @since J2EE 1.4
 */

public class JointOperationAgreementSettlementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * JointOperationAgreementSettlement system : preceding process for biz scenario<br>
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
	 * JointOperationAgreementSettlement system : biz scenario closing<br>
	 */
	public void doEnd() {
		log.debug("JointOperationAgreementSettlementSC 종료");
	}

	/**
	 * 
	 * OPUS-JointOperationAgreementSettlement system <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		
		//FNS_JOO_0044 Tax Inquiry
		if (e.getEventName().equalsIgnoreCase("FnsJoo0044Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTaxList(e);
			}
			//screen Open
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0044(e);
			}
//		//FNS_JOO_0026 A/R ERP Interface
//		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0026Event")) {
//			//search
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchARERPInterfaceList(e);
//			}
//		//FNS_JOO_0027 A/P ERP Interface
//		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0027Event")) {
//			//search
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchAPERPInterfaceList(e);
//			}
		//FNS_JOO_0013 War Risk
//		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0013Event")) {
//			//search
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchSettlementWRList(e);
//			//saving afterDup Check
//			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//				eventResponse = manageSettlementWR(e);
//			//changing VVD (changing 9 digits)
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
//				FnsJoo0013Event event = (FnsJoo0013Event)e;
//				eventResponse = searchRevDirList(event.getProcSettlementVO());
//			//changing VVD
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//				eventResponse = searchStlVvdWR(e);
//			//Create
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//				eventResponse = searchAddStlWRList(e);
//				//retrieving closing status
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
//				eventResponse = searchCloseYn(e);
//			}
//			// Open시
//			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
//				eventResponse = openFnsJoo0013(e);
//			}
		//FNS_JOO_0014 Port Skip
//		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0014Event")) {
//			//search
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchSettlementPBList(e);
//			//saving afterDuplication Check
//			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//				eventResponse = manageSettlementPB(e);
//			//changing VVD (changing 9 digits)
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
//				FnsJoo0014Event event = (FnsJoo0014Event)e;
//				eventResponse = searchRevDirList(event.getProcSettlementVO());
//			//changing VVD
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//				eventResponse = searchStlVvdPB(e);
//
//			//Create
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//				eventResponse = searchAddStlPBList(e);
//				//retrieving closing status
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
//				eventResponse = searchCloseYn(e);
//			}
//			// Open
//			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
//				eventResponse = openFnsJoo0013(e);
//			}
		//FNS_JOO_0012 Other
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0012Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementOTHList(e);
			//saving
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementOTH(e);
			//changing VVD (changing 9 digits)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				FnsJoo0012Event event = (FnsJoo0012Event)e;
				eventResponse = searchRevDirList(event.getProcSettlementVO());
			//changing VVD
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlVvdOTH(e);
			//Create
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAddStlOTHList(e);
				//retrieving closing status
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			// checking BSA Type
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchBsaTypeValidationCheck(e);
			// Open시
	    	} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0012(e);
			}
		//FNS_JOO_0007 Slot Hire
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0007Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementSHList(e);
			//save
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementSH(e);
			//changing VVD(10 digits)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlVvdSH(e);
			//changing VVD (changing 9 digits)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				FnsJoo0007Event event = (FnsJoo0007Event)e;
				eventResponse = searchRevDirList(event.getProcSettlementVO());
			//deleting all data
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeSettlementSH(e);
			//Create
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAddStlSHList(e);
			//retrieving closing status
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			// Open
			} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0007(e);
			}
		//FNS_JOO_0009 Over Used RDR
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0009Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementRDRList(e);
			
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementRDR(e);
			//changing VVD (changing 9 digits)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				FnsJoo0009Event event = (FnsJoo0009Event)e;
				eventResponse = searchRevDirList(event.getProcSettlementVO());
			//changing VVD(10 digits)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlVvdRDR(e);
			
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchBsaSltPrcForOusRdr(e);
			
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchUsedSlotInfo(e);
			
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeSettlementRDR(e);
			//Create
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAddStlRDRList(e);
				//retrieving closing status
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { //2015.08.12 Add
				eventResponse = searchUsedSlotByInterList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchBsaSltPrcForInterOusRdr(e);
			
			} 
			// Open
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0009(e);
			}
		//FNS_JOO_0010 Over Used TDR
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0010Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementTDRList(e);
			
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementTDR(e);
				//changing VVD (changing 9 digits)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				FnsJoo0010Event event = (FnsJoo0010Event)e;
				eventResponse = searchRevDirList(event.getProcSettlementVO());
			
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchPriceAndPortList(e);
			
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchOusTdrUsedSlot(e);
			
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchOusTdrUsedSlotPrice(e);
			
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeSettlementTDR(e);
			//Create
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAddStlTDRList(e);
				//retrieving closing status
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			}
			// Open
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0010(e);
			}
		//FNS_JOO_0011 Reefer
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0011Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementRFList(e);
			
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementRF(e);
			//changing VVD (changing 9 digits)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				FnsJoo0011Event event = (FnsJoo0011Event)e;
				eventResponse = searchRevDirList(event.getProcSettlementVO());
			
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlVvdRF(e);
			
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchUsedReeferList(e);
			
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchRfIOChange(e);
			
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchRfRgnChange(e);
			
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeSettlementRF(e);
			//Create
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAddStlRFList(e);
				//retrieving closing status
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0011(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualClosing(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyAccrualClosing(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualListByAccount(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDetailSlipList(e);
			}
//		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0069Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchDetailSlipList(e);
//			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchConsultationList(e); 
			}if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchApprovalCsrOfcList(e); 
			}else if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0022(e); //2016.08.02 Add
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDetailConsultation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = approvalConsultation(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){
				eventResponse = searchConsultationBackEndJobStatus(e);
			}
		
		}else if (e.getEventName().equalsIgnoreCase("FnsJoo0068Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCsrDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = reverseConsultation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = rejectConsultation(e);
			}
//		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0073Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchPersonInfo(e);
//			}
//		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0018Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchAPEvidenceList(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//				eventResponse = searchCreateAPEvidenceList(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
//				eventResponse = openFnsJoo0018(e);
//			}
//		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0070Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchLetterSendList(e);
//			}
//			
//			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
//				eventResponse = openFnsJoo0070(e);
//			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSummaryOfMcsListByTrade(e);
			}
			
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0037(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualListByMAS(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlipList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCsrOfcList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0025(e);
			}
//		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0066Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchMemberInfo(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
//				eventResponse = searchPicUserIdInfo(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//				eventResponse = manageMemberInfo(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//				eventResponse = searchCustCdNm(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
//				eventResponse = searchCarrierSeq(e);
//			}
//			// Open
//			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
//				eventResponse = openFnsJoo0066(e);
//			}
//		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0067Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchCarrierMemberInfo(e);
//			}
//			// Open
//			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
//				eventResponse = openFnsJoo0067(e);
//			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSummaryOfMcsListByCarrier(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = searchTradeCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = openFnsJoo0036(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSummaryOfMcsListByCarrier(e);
			}
//		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0059Event")
//				|| e.getEventName().equalsIgnoreCase("FnsJoo0061Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchTemplate(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//				eventResponse = createTemplate(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
//				eventResponse = removeTemplate(e);
//            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//OPEN
//
//                if ( e.getEventName().equalsIgnoreCase("FnsJoo0059Event")) {
//                    eventResponse = openFnsJoo0059(e);
//                }
//
//                if ( e.getEventName().equalsIgnoreCase("FnsJoo0061Event")) {
//                    eventResponse = openFnsJoo0061(e);
//                }
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//				eventResponse = searchTempalteTextNoList(e);
//			}
//

		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0039Event")) {
			/******************* Monthly Clearance Status by Carrier & Lane: Retirieve ***********************/
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMccListByCarNLane(e);

			}
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
                eventResponse = searchMccDtlListByCarNLane(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0039(e);
            }

		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0029Event")) {
			/******************* Estimate Performance Creation ***********************/
			/* 1. Retirieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchJointOperationAccrualList(e);
			}
			/* 2. Save */
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageJointOperationAccrual(e);
			}
			/* 3. Create BackEndJob*/
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = calJointOperationAccrual(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchCond0029(e);
			}
			/* 4. I/F */
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = sendJointOperationAccrualERP(e);
			}
			/* retrieving BackEndJob status */
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchAccrualBackEndJobStatus(e);
			}
			/* retrieving BackEndJob result */
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				try{
					eventResponse = searchAccrualBackEndJobResult(e);
				}catch(BackEndJobException ex){
					throw new EventException(ex.getMessage());
				}
			}
			/* 5. Open */
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0029(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo003401Event")) {
			/******************* Estimate Code Check - Carrier ***********************/
			/* 1. Retirieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchEstdCarCheckList(e);

			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo003402Event")) {
			/******************* Estimate Code Check - VVD ***********************/
			/* 1. Retirieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchEstdVvdCheckList(e);

			}
//		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0065Event")) {
//			/******************* MCS & Invoice Letter Fax/E-mail Inquiry ***********************/
//			/* 1. Retirieve */
//			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//				eventResponse = searchLetterSendStsList(e);
//
//			}
//		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0060Event")) {
//			/******************* MCS Letter Information Creation ***********************/
//            /* 0. Open */
//		    if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//                eventResponse = openFnsJoo0060(e);
//            }
//
//			/* 2. Text No. Change*/
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
//				eventResponse = searchMcsLetter(e);
//
//			}
//			/* 3. Retrieve */
//			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//				eventResponse = searchMcsCombined(e);
//
//			}
//			/* 4. Save */
//			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
//				eventResponse = manageMcsLetter(e);
//
//			}
//			/* 5. Send */
//			if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
//				eventResponse = sendMcsLetter(e);
//
//			}
//            /* 6. Retrieve2  */
//            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
//                eventResponse = searchMcsSavedCombined(e);
//
//            }

		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0038Event")) {
			/******************* Summary of Monthly Clearance Status by VVD ***********************/

			/* 1. Retrieve */
	        if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//
	                eventResponse = searchSummaryOfMcsListByVVD(e);

            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0038(e);
            }

		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0042Event")) {
			/******************* Slot Exchange Status by Lane & Partner->Finance Lane ***********************/

			/* 1. Retrieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSlotXchStatusListByFinanceLane(e);

			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0043Event")) {
			/******************* Slot Exchange Status by Lane & Partner->Finance Partner ***********************/

			/* 1. Retrieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSlotXchStatusListByFinancePartner(e);

			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0049Event")) {
			/******************* Settlement Status for Basic Allocation ***********************/

			/* 1. Retrieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlStatusListForBSA(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0049(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
                eventResponse = openFnsJoo0049(e);
            }
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0050Event")) {
			/******************* Target Voyage vs Unsettled Status ***********************/
			/* 1. Retrieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTgtVoyVsUnstlStatusList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageTgtUnstlStsRmk(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
                eventResponse = openFnsJoo0050(e);
            }
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAdjustSlotHireStlList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAdjustSlotHireStl(e);
				//retrieving closing status
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0045(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCombinedMonthlyClearanceList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCombinedRlaneList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchCombinedMonthlyClearanceByLaneList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCombinedMonthlyClearance(e);
			}else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeCombinedMonthlyClearance(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0016(e);
			}
		/*
		 * FnsJoo0017 menu recovery 
		 */
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAPConsultation(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createAPConsultation(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAPClosYn(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0017(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchARConsultation(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createARConsultation(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchARClosYn(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0020(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0015Event")) {
            /******************* Monthly Clearance Inquiry : Retirieve ***********************/
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchMonthlyClearanceList(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchMonthlyStlCmbSeqList(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0015(e);
            }
//        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0040Event")) {
//            /******************* Slot Exchange Status by Lane & Partner->Space On Lane : Retrieve ***********************/
//            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//                eventResponse = searchSlotXchStatusListBySpaceLane(e);
//            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//                eventResponse = openFnsJoo0040 (e);
//            }
//        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0041Event")) {
//            /******************* Slot Exchange Status by Lane & Partner->Space On Lane : Retrieve ***********************/
//            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//                eventResponse = searchSlotXchStatusListBySpacePartner(e);
//            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//                eventResponse = openFnsJoo0041 (e);
//            }
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0054Event")) {
            /******************* TDR Cration Inquiry : Retrieve ***********************/
        	log.debug("::CALL::> TDR Cration Inquiry sc :::::::::      ");
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				 		 eventResponse = searchTDRCreateListByLane (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				 		 eventResponse = searchLaneCdYn (e);
			}
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0055Event")) {
            /******************* RDR Upload Inquiry : Retrieve ***********************/
        	log.debug("::CALL::> RDR Upload Inquiry sc :::::::::      ");
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				 		 eventResponse = searchRDRCreateListByLane (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				 		 eventResponse = searchLaneCdYn (e);
			}
//        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0062Event")) {
//            /******************* Invoice Letter Information Creation ***********************/
//            /* 0. Open */
//            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//                eventResponse = openFnsJoo0062(e);
//            }
//
//            /* 2. Text No. Change*/
//            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
//                eventResponse = searchInvoiceLetter(e);
//
//            }//
//            /* 3. Retrieve */
//            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//                eventResponse = searchInvoiceCombined(e);
//
//            }
//            /* 4. Save */
//            if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
//                eventResponse = createInvoiceLetter(e);
//
//            }
//            /* 5. Send */
//            if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
//                eventResponse = sendInvoiceLetter(e);
//
//            }
//            /* 6.2 Retrieve Saved Invoice by 0070 */
//            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
//                eventResponse = searchInvoiceSavedCombined(e);
//            }
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0074Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstmPerformanceList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCond(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0074(e);
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0056Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0056(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchRDRDownloadListByLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageRDRVVDCrrRmk(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0053Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchVVDOfNotExistRevMonList(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0057Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0057(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchTDRDownloadListByLane(e);
            }
//        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0075Event")) {
//            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//                eventResponse = openFnsJoo0075(e);
//            }
//            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
//                eventResponse = searchUserNm(e);
//            }
//            if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
//                eventResponse = searchTempalteSeqList(e);
//            }
//            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//                eventResponse = searchSignNBank(e);
//            }
//            if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
//                eventResponse = manageSignNBank(e);
//            }
//            if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
//                eventResponse = removeSignNBank(e);
//            }

//        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0046Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchAdjustOusListForRDR(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
//				eventResponse = openFnsJoo0046(e);
//			}
//        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0076Event")) {
//            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//                eventResponse = searchARDisabledVVD(e);
//            }
//        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0077Event")) {
//            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//                eventResponse = openFnsJoo0077(e);
//            }
//            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//                eventResponse = searchARDataInquiry(e);
//            }

//		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0078Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchApIfErrList(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//				eventResponse = rejectConsultation(e);
//			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLostCombinedDataList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlOfcList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0080(e);
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0081Event")) {
             if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchDischageForLoading(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {//EXCEL DOWN LOAD
                eventResponse = searchDischageForLoadingExcel(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0084Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // Retrieve , Scroll Retrieve
                eventResponse = searchCntrForSettlementBackupReportData(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//EXCEL DOWN LOAD Backendjob
                eventResponse = searchCntrForSettlementBackupReportDataBackEndJob(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//EXCEL DOWN LOAD Backendjob2
                eventResponse = backEndJobResult(e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//EXCEL DOWN LOAD Backendjob3
                eventResponse = searchCntrForSettlementBackupReportDataFile(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {//Standard format Retrieve
                eventResponse = searchCntrStandardFormatReportData(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//Previous Voyage and Last Port Search
                eventResponse = searchPreviousVoyageAndLastPortInfo(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {//Standard format Excel Backendjob
                eventResponse = searchCntrStandardFormatReportBackEndJob(e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND02 )) {//Standard format Excel Backendjob Data Down
                eventResponse = searchCntrStandardFormatReportDataFile(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {//Standard format Title 재귀 호출.
                eventResponse = searchStandardFormatSheetTitle(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {//Standard format Backendjob 호출.
                eventResponse = searchCntrStandardFormatReportDataBackEndJob(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {//Standard format Backendjob 의 결과 호출.
                eventResponse = searchCntrStandardFormatReportDataBackEndJobResult(e);
            }//open screen
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0084(e);				
			}
        }else if(e.getEventName().equalsIgnoreCase("FnsJoo0086Event")){
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // Retrieve , Scroll Retrieve
                eventResponse = searchCntrConversionTableData(e);
            }
        	else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCntrConversionTable(e);
            }
        	
        	//open screen
			/*else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0086(e);				
			}*/
        }else if(e.getEventName().equalsIgnoreCase("FnsJoo0087Event")){
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // Retrieve , Scroll Retrieve
                eventResponse = searchCntrOptionData(e);
            }
        	else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCntrOption(e);
            }
        }
		return eventResponse;
	}

	/**
	 * FNS_JOO_0044 : Retrieve
	 * retrieving TAX
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTaxList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		FnsJoo0044Event event = (FnsJoo0044Event) e;
    		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
    		List<TaxVO> list = command.searchTaxList(event.getTaxInvYrmonFr(), event.getTaxInvYrmonTo());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * FNS_JOO_0044 : Open
	 * retrieving common code in case of screen open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse openFnsJoo0044(Event e) throws EventException {
        try{
    		GeneralEventResponse eventResponse = new GeneralEventResponse();

    		
    		CodeUtil codeUtil = CodeUtil.getInstance();
    		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD01754", 0);

			Iterator iterator = (Iterator) codeList2.iterator();

    		StringBuilder tpCombo   = new StringBuilder();
    		StringBuilder tpNmCombo = new StringBuilder();
    		while (iterator.hasNext()) {
    			CodeInfo codeInfo = (CodeInfo)iterator.next();
    			tpCombo  .append(codeInfo.getCode() + "|");
    			tpNmCombo.append(codeInfo.getName() + "|");
    		}

    		String sTpCombo = tpCombo.toString();
    		String sTpNmCombo = tpNmCombo.toString();

    		if (sTpCombo.length() > 0) {
    			sTpCombo = sTpCombo.substring(0, sTpCombo.length() - 1);
    			sTpNmCombo = sTpNmCombo.substring(0, sTpNmCombo.length() - 1);
    		}

    		
    		Collection<CodeInfo> list = codeUtil.getCodeSelect("CD01756", 0);

    		iterator = (Iterator) list.iterator();

    		StringBuilder plCombo = new StringBuilder();
    		StringBuilder plNmCombo = new StringBuilder();
    		while (iterator.hasNext()) {
    			CodeInfo codeInfo = (CodeInfo) iterator.next();
    			plCombo.append  (codeInfo.getCode() + "|");
    			plNmCombo.append(codeInfo.getName() + "|");
    		}

    		String sPlCombo = plCombo.toString();
    		String sPlNmCombo = plNmCombo.toString();

    		if (sPlCombo.length() > 0) {
    			sPlCombo = sPlCombo.substring(0, sPlCombo.length() - 1);
    			sPlNmCombo = sPlNmCombo.substring(0, sPlNmCombo.length() - 1);
    		}

    		eventResponse.setETCData("CD01754", sTpCombo);
    		eventResponse.setETCData("CD01754NM", sTpNmCombo);
    		eventResponse.setETCData("CD01756", sPlCombo);
    		eventResponse.setETCData("CD01756NM", sPlNmCombo);
    		return eventResponse;

//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//        	throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

//	/**
//	 * FNS_JOO_0026 : Retrieve
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	private EventResponse searchARERPInterfaceList(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//	    try{
//    		FnsJoo0026Event event = (FnsJoo0026Event) e;
//    		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
//    		List<ErpIfVO> list =
//    			command.searchARERPInterfaceList(event.getErpIfFlg(), event.getDtFlg(), event.getIssDtFr(), event.getIssDtTo());
//    		GeneralEventResponse eventResponse = new GeneralEventResponse();
//    		eventResponse.setRsVoList(list);
//    		return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//	}

//	/**
//	 * FNS_JOO_0027 : Retrieve
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	private EventResponse searchAPERPInterfaceList(Event e)	throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//	    try{
//    		FnsJoo0027Event event = (FnsJoo0027Event) e;
//    		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
//    		List<ErpIfVO> list =
//    			command.searchAPERPInterfaceList(event.getErpIfFlg(), event.getDtFlg(), event.getIssDtFr(), event.getIssDtTo());
//    		GeneralEventResponse eventResponse = new GeneralEventResponse();
//    		eventResponse.setRsVoList(list);
//    		return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//	}

	/**
	 * FNS_JOO_0013 : 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse openFnsJoo0013(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//	    try{
//    		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
//    		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//    		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
//
//    		
//    		jooCodeParamVO.setOfcCd(account.getOfc_cd());
//    		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
//
//    		String crrCombo = makeComboString(list, 1);
//
//    		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
//    		procSettlementVO.setAcctYrmon(JSPUtil.getKST("yyyyMM"));
//    		procSettlementVO.setReDivrCd("R");
//    		eventResponse.setETCData("clz_yn", searchCloseYn(procSettlementVO));
//    		eventResponse.setETCData("jo_crr_cd", crrCombo);
//    		return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//	}

	/**
	 * FNS_JOO_0012
	 * retrieving Carrier Code List, Financial Direction, Settlement Item, BSA Type
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0012(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
    		GeneralEventResponse eventResponse = new GeneralEventResponse();

    		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

    		// Carrier
    		jooCodeParamVO.setOfcCd(account.getOfc_cd());
    		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

    		String crrCombo = makeComboString(list, 1);

    		// ABBR
    		//jooCodeParamVO.setSuperCd2("Y"); // Manual만
    		list = command.searchStlItemCodeList(jooCodeParamVO);

    		String abbrCombo = makeComboString(list, 1);
    		String abbrSheet = makeComboString(list, 2); // code
    		String nameSheet = makeComboString(list, 3); // name

    		// Revenue Direction
    		CodeUtil codeUtil = CodeUtil.getInstance();
//    		Collection<CodeInfo> codeList1 = codeUtil.getCodeSelect("CD02115", 0);
//    		String dirctSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList1), BizComUtil.CODE_DELIMITTER);

    		// BSA Type
    		@SuppressWarnings("unchecked")
			Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD01866", 0);
    		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);
    		String bsaTypeCd[] = (stljbSheetList[0]).split("[|]");
    		String bsaTypeNm[] = (stljbSheetList[1]).split("[|]");

    		String code = "";
    		StringBuilder bsaTypeCdTmp = new StringBuilder();
    		StringBuilder bsaTypeNmTmp = new StringBuilder();
    		for (int i=0; i<bsaTypeCd.length; i++){
    			code = bsaTypeCd[i].substring(0,1);
    			if ("1".equals(code)){
    				bsaTypeCdTmp.append(bsaTypeCd[i]+"|");
    				bsaTypeNmTmp.append(bsaTypeNm[i]+"|");
    			}
    		}

    		String bsaTpCd = bsaTypeCdTmp.toString().substring(0, bsaTypeCdTmp.toString().length()-1);
    		String bsaTpNm = bsaTypeNmTmp.toString().substring(0, bsaTypeNmTmp.toString().length()-1);

    		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
    		procSettlementVO.setAcctYrmon(JSPUtil.getKST("yyyyMM"));
    		procSettlementVO.setReDivrCd("R");
    		eventResponse.setETCData("clz_yn", searchCloseYn(procSettlementVO));

    		eventResponse.setETCData("jo_crr_cd", crrCombo);
//    		eventResponse.setETCData("fin_dir_combo", dirctSheetList[0]);
    		eventResponse.setETCData("abbrCombo", abbrCombo);
    		eventResponse.setETCData("abbrSheet", abbrSheet);
    		eventResponse.setETCData("nameSheet", nameSheet);
    //		eventResponse.setETCData("stl_jb_combo", stljbSheetList[0]);
    //		eventResponse.setETCData("stl_jb_comnm", stljbSheetList[1]);
    		eventResponse.setETCData("stl_jb_combo", bsaTpCd);
    		eventResponse.setETCData("stl_jb_comnm", bsaTpNm);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * FNS_JOO_0013 : Retrieve
	 * retrieving Settlement War Risk
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse searchSettlementWRList(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//	    try{
//    		FnsJoo0013Event event = (FnsJoo0013Event)e;
//    		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
//    		List<ProcSettlementVO> list = command.searchSettlementList(event.getProcSettlementVO());
//    		GeneralEventResponse eventResponse = new GeneralEventResponse();
//    		eventResponse.setRsVoList(list);
//    		return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//	}

	/**
	 * FNS_JOO_0014 : Retrieve
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse searchSettlementPBList(Event e) throws EventException {
//	 try{
//		// PDTO(Data Transfer Object including Parameters)
//		FnsJoo0014Event event = (FnsJoo0014Event)e;
//		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
//		List<ProcSettlementVO> list = command.searchSettlementList(event.getProcSettlementVO());
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		eventResponse.setRsVoList(list);
//		return eventResponse;
//    } catch (EventException ex) {
//        log.error("err " + ex.toString(), ex);
//        throw new EventException(ex.getMessage(), ex);
//    } catch (Exception ex) {
//        log.error("err " + ex.toString(), ex);
//        throw new EventException(ex.getMessage(), ex);
//    }
//	}

	/**
	 * FNS_JOO_0012 : Retrieve
	 * retrieving Settlement Other
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettlementOTHList(Event e) throws EventException {
	  try{
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0012Event event = (FnsJoo0012Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchSettlementList(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
    } catch (EventException ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    }
	}

	/**
	 * FNS_JOO_0007 : Retrieve
	 * retrieving Settlement Slot Hire
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettlementSHList(Event e) throws EventException {
	  try{
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0007Event event = (FnsJoo0007Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		ProcSettlementVO procSettlementVO = event.getProcSettlementVO();
		
		//2015.07.07 NYK Modify
		//OPR 추가에 따른 소스 코드 수정 : procSettlementVO.jo_stl_itm_cd=S/H,OPR, procSettlementVO.jo_mnu_nm=S/H,OPR
		List<ProcSettlementVO> rtnList = new ArrayList<ProcSettlementVO>();
		List<ProcSettlementVO> list = command.searchSettlementList(procSettlementVO);
		if(list != null && list.size() > 0){
			for(ProcSettlementVO vo : list){
				rtnList.add(vo);
			}
		}
		
		//ItemList Exist Check : OPR
		String addJoStlItmCd = procSettlementVO.getAddJoStlItmCd();
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		//jooCodeParamVO.setSuperCd1("Y"); //auto cre flg = 'Y'
		JOOFindCodeAndCheckBC command1 = new JOOFindCodeAndCheckBCImpl();		
		List<JooCodeInfoVO> itemList = command1.searchStlItemCodeList(jooCodeParamVO);
		boolean isExistItem = false;
		for(JooCodeInfoVO codeVo : itemList){
			if(codeVo.getCode().equals(addJoStlItmCd)){
				isExistItem = true;
				break;
			}
		}
		
		//2015.07.07 NYK Modify Add OPR : Port to Port 일대는 진행하지 않는다.
		if(isExistItem && StringUtils.isNotEmpty(addJoStlItmCd) && !JooConstants.KEY_SH_OPTION_PORT.equals(procSettlementVO.getSchTpCd())){
			procSettlementVO.setJoStlItmCd(procSettlementVO.getAddJoStlItmCd());
			procSettlementVO.setJoMnuNm(procSettlementVO.getAddJoMnuNm());
			
			List<ProcSettlementVO> list2 = command.searchSettlementList(procSettlementVO);
			if(list2 != null && list2.size() > 0){
				for(ProcSettlementVO vo : list2){
					rtnList.add(vo);
				}
			}
		}
		//List<ProcSettlementVO> list = command.searchSettlementList(procSettlementVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(rtnList);
		return eventResponse;
    } catch (EventException ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    }
	}

	/**
	 * FNS_JOO_0009 : Retrieve
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettlementRDRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	  try{
		FnsJoo0009Event event = (FnsJoo0009Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		ProcSettlementVO procSettlementVO = event.getProcSettlementVO();

		List<ProcSettlementVO> list = command.searchSettlementList(procSettlementVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
    } catch (EventException ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    }
	}

	/**
	 * FNS_JOO_0010 : Retrieve
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettlementTDRList(Event e) throws EventException {
	 try{
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0010Event event = (FnsJoo0010Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		ProcSettlementVO procSettlementVO = event.getProcSettlementVO();
		List<ProcSettlementVO> list = command.searchSettlementList(procSettlementVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
    } catch (EventException ex) {
        log.error("err " + ex.toString(), ex);
        throw ex;
    } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    }
	}

	/**
	 * FNS_JOO_0013 : Save
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse manageSettlementWR(Event e) throws EventException {
//
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		FnsJoo0013Event event = (FnsJoo0013Event)e;
//		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
//		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
//		try {
//			begin();
//			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
//			List<ProcSettlementVO> list = command.manageSettlement(procSettlementVOs, account);
//
//			String dupFlg = list.get(0).getDupFlg();
//			eventResponse.setETCData("RTNVAL", dupFlg);
//
//			if ("E".equals(dupFlg)){
//				eventResponse.setRsVoList(list);
//				rollback();
//			}else{
//				command1.manageTargetVVDForSettlement(procSettlementVOs, account);
//				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
//				commit();
//			}
//		} catch (EventException ex) {
//			rollback();
//			throw ex;
//		} catch (Exception ex) {
//			rollback();
//			throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;
//
//	}

	/**
	 * FNS_JOO_0014 : Save
	 * .
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse manageSettlementPB(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		FnsJoo0014Event event = (FnsJoo0014Event)e;
//		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
//		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
//		try {
//			begin();
//			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
//			List<ProcSettlementVO> list = command.manageSettlement(procSettlementVOs, account);
//
//			String dupFlg = list.get(0).getDupFlg();
//			eventResponse.setETCData("RTNVAL", dupFlg);
//
//			if ("E".equals(dupFlg)){
//				eventResponse.setRsVoList(list);
//				rollback();
//			}else{
//				command1.manageTargetVVDForSettlement(procSettlementVOs, account);
//				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
//				commit();
//			}
//		} catch (EventException ex) {
//			rollback();
//			throw ex;
//		} catch (Exception ex) {
//			rollback();
//			throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;
//	}

	/**
	 * FNS_JOO_0012 : Save
	 * checking duplication and saving Other Surcharge Settlement
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettlementOTH(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0012Event event = (FnsJoo0012Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
			List<ProcSettlementVO> list = command.manageSettlement(procSettlementVOs, account);

			String dupFlg = list.get(0).getDupFlg();
			eventResponse.setETCData("RTNVAL", dupFlg);

			if ("E".equals(dupFlg)){
				eventResponse.setRsVoList(list);
				rollback();
			}else{
				command1.manageTargetVVDForSettlement(procSettlementVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0007 : Save
	 * saving Slot Hire Surcharge Settlement
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettlementSH(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0007Event event = (FnsJoo0007Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
			ProcSettlementVO procSettlementVO = event.getProcSettlementVO();
			
			if(null != procSettlementVOs && null != procSettlementVO){
				for(int i=0; i < procSettlementVOs.length; i++){
					procSettlementVOs[i].setSchTpCd(procSettlementVO.getSchTpCd());
				}			
			
				List<ProcSettlementVO> list = command.manageSettlementSH(procSettlementVOs, account);
	
				String dupFlg = list.get(0).getDupFlg();
				eventResponse.setETCData("RTNVAL", dupFlg);
	
				if ("E".equals(dupFlg)){
					eventResponse.setRsVoList(list);
					rollback();
				}else{
					command1.manageTargetVVDForSettlement(procSettlementVOs, account);
					eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
					commit();
				}
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0009 : Save
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettlementRDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0009Event event = (FnsJoo0009Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
			//2015.08.17 Add Ocean : dep_port_cd > fm_port_cd 로 대체 한다.
			for(ProcSettlementVO vo : procSettlementVOs){
				if(vo.getIocCd().equals("O")) vo.setFmPortCd(vo.getDepPortCd());
			}
			
			List<ProcSettlementVO> list = command.manageSettlementSH(procSettlementVOs, account);

			String dupFlg = list.get(0).getDupFlg();
			eventResponse.setETCData("RTNVAL", dupFlg);

			if ("E".equals(dupFlg)){
				eventResponse.setRsVoList(list);
				rollback();
			}else{
				command1.manageTargetVVDForSettlement(procSettlementVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0010 : Save
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettlementTDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0010Event event = (FnsJoo0010Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
			List<ProcSettlementVO> list = command.manageSettlementSH(procSettlementVOs, account);

			String dupFlg = list.get(0).getDupFlg();
			eventResponse.setETCData("RTNVAL", dupFlg);

			if ("E".equals(dupFlg)){
				eventResponse.setRsVoList(list);
				rollback();
			}else{
				command1.manageTargetVVDForSettlement(procSettlementVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : Save
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettlementRF(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0011Event event = (FnsJoo0011Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
			SettlementRFVO[]   settlementRFVOs   = event.getSettlementRFVOs();

			List<SettlementRFVO> list = command.manageSettlementRF(settlementRFVOs, account);

			String dupFlg = list.get(0).getDupFlg();
			eventResponse.setETCData("RTNVAL", dupFlg);

			if ("E".equals(dupFlg)){
				eventResponse.setRsVoList(list);
				rollback();
			}else{
				command1.manageTargetVVDForSettlement(procSettlementVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0007 : Delete
	 * deleting all data in case of Slot Hire condition
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeSettlementSH(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0007Event event = (FnsJoo0007Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();

		try {
			begin();
			
			ProcSettlementVO procSettlementVO = event.getProcSettlementVO();
			
			ProcSettlementVO[] procSettlementVOs = command.removeSettlement(procSettlementVO);
			command1.manageTargetVVDForSettlement(procSettlementVOs, account);
			
			//ItemList Exist Check : OPR
			String addJoStlItmCd = procSettlementVO.getAddJoStlItmCd();
			JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
			//jooCodeParamVO.setSuperCd1("Y"); //auto cre flg = 'Y'
			JOOFindCodeAndCheckBC command2 = new JOOFindCodeAndCheckBCImpl();		
			List<JooCodeInfoVO> itemList = command2.searchStlItemCodeList(jooCodeParamVO);
			boolean isExistItem = false;
			for(JooCodeInfoVO codeVo : itemList){
				if(codeVo.getCode().equals(addJoStlItmCd)){
					isExistItem = true;
					break;
				}
			}
			
			//2015.07.07 NYK Modify Add OPR : Port to Port 일대는 진행하지 않는다.
			if(isExistItem && StringUtils.isNotEmpty(addJoStlItmCd) && !JooConstants.KEY_SH_OPTION_PORT.equals(procSettlementVO.getSchTpCd())){
				procSettlementVO.setJoStlItmCd(procSettlementVO.getAddJoStlItmCd());
				procSettlementVO.setJoMnuNm(procSettlementVO.getAddJoMnuNm());
				
				ProcSettlementVO[] addProcSettlementVOs = command.removeSettlement(procSettlementVO);
				command1.manageTargetVVDForSettlement(addProcSettlementVOs, account);				
			}
			
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0009 : Delete
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeSettlementRDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0009Event event = (FnsJoo0009Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();

		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = command.removeSettlement(event.getProcSettlementVO());
			command1.manageTargetVVDForSettlement(procSettlementVOs, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0010 : Delete
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeSettlementTDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0010Event event = (FnsJoo0010Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();

		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = command.removeSettlement(event.getProcSettlementVO());
			command1.manageTargetVVDForSettlement(procSettlementVOs, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : Delete
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeSettlementRF(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0011Event event = (FnsJoo0011Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();

		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = command.removeSettlement(event.getProcSettlementVO());
			command1.manageTargetVVDForSettlement(procSettlementVOs, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse searchStlVvdWR(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		FnsJoo0013Event event = (FnsJoo0013Event)e;
//		ProcSettlementVO vo = event.getProcSettlementVO();
//		return searchStlVvd(vo);
//	}

	/**
	 * Port Skip VVD Validation Check
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse searchStlVvdPB(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		FnsJoo0014Event event = (FnsJoo0014Event)e;
//		ProcSettlementVO vo = event.getProcSettlementVO();
//		return searchStlVvd(vo);
//	}

	/**
	 * Other VVD Validation Check
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlVvdOTH(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0012Event event = (FnsJoo0012Event)e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		// PDTO(Data Transfer Object including Parameters)
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<ProcSettlementVO> list = command.searchStlVvd(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String stlVvdSeq = "";
		String stlBzcPortCd = "";
		String etaDt = "";
		String loclCurrCd = "";
		String ucBssPortCd = "";
		String ucBssPortEtdDt = "";
		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			ProcSettlementVO voOut = list.get(0);

			stlVvdSeq = voOut.getStlVvdSeq();
			stlBzcPortCd = voOut.getStlBzcPortCd();
			etaDt = voOut.getEtaDt();
			loclCurrCd = voOut.getLoclCurrCd();
			ucBssPortCd = voOut.getUcBssPortCd();
			ucBssPortEtdDt = voOut.getUcBssPortEtdDt();

			
			if (vo.getJoMnuNm().equals("M/S")){
				String rtnVal = command.searchStlVvdOth(vo);
				eventResponse.setETCData("CHECKVVD", rtnVal);
			}
		}
		eventResponse.setETCData("stl_vvd_seq", stlVvdSeq);
		eventResponse.setETCData("stl_bzc_port_cd", stlBzcPortCd);
		eventResponse.setETCData("eta_dt", etaDt);
		eventResponse.setETCData("locl_curr_cd", loclCurrCd);
		eventResponse.setETCData("uc_bss_port_cd", ucBssPortCd);
		eventResponse.setETCData("uc_bss_port_etd_dt", ucBssPortEtdDt);

		return eventResponse;
	}

	/**
	 * Slot Hire VVD Validation Check
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlVvdSH(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0007Event event = (FnsJoo0007Event)e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		return searchStlVvd(vo);
	}

	/**
	 * FNS_JOO_0009 : VVD change
	 * Over Used RDR VVD Validation Check.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlVvdRDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0009Event event = (FnsJoo0009Event)e;
		// PDTO(Data Transfer Object including Parameters)
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<ProcSettlementVO> list = command.searchStlVvdOusRdr(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String stlVvdSeq = "";
		String stlBzcPortCd = "";
		String etaDt = "";
		String ucBssPortCd = "";
		String ucBssPortEtdDt = "";
		String fnlOwnBsaQty = "";
		String fnlBsaWgt = "";
		String bsaPerWgt = "";

		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			ProcSettlementVO voOut = list.get(0);

			stlVvdSeq      = voOut.getStlVvdSeq();
			stlBzcPortCd   = voOut.getStlBzcPortCd();
			etaDt          = voOut.getEtaDt();
			ucBssPortCd    = voOut.getUcBssPortCd();
			ucBssPortEtdDt = voOut.getUcBssPortEtdDt();
			fnlOwnBsaQty   = voOut.getFnlOwnBsaQty();
			fnlBsaWgt      = voOut.getFnlBsaWgt();
			bsaPerWgt      = voOut.getBsaPerWgt();
		}
		eventResponse.setETCData("stl_vvd_seq", stlVvdSeq);
		eventResponse.setETCData("stl_bzc_port_cd", stlBzcPortCd);
		eventResponse.setETCData("eta_dt", etaDt);
		eventResponse.setETCData("uc_bss_port_cd", ucBssPortCd);
		eventResponse.setETCData("uc_bss_port_etd_dt", ucBssPortEtdDt);
		eventResponse.setETCData("fnl_own_bsa_qty", fnlOwnBsaQty);
		eventResponse.setETCData("fnl_bsa_wgt", fnlBsaWgt);
		eventResponse.setETCData("bsa_per_wgt", bsaPerWgt);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : VVD change
	 * Reefer VVD Validation Check & Port List retrieve.

	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlVvdRF(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0011Event event = (FnsJoo0011Event)e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		GeneralEventResponse eventResponse = (GeneralEventResponse)searchStlVvd(vo);

		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();

		// parameter 
		// super_cd1 => rlane_cd
		// super_cd2 => VVD (VSL_CD,SKD_VOY_NO,SKD_DIR_CD 9자리)
		//JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchUnitCostPortList(event.getJooCodeParamVO());

		// select List 
		// CODE => PORT
		// NAME => ETD
		String portList = makeComboString(list, 2);

		eventResponse.setETCData("portList", portList);

		return eventResponse;
	}

	/**
	 * checking Validation in case of changing VVD
	 * @param ProcSettlementVO procSettlementVO
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlVvd(ProcSettlementVO procSettlementVO) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<ProcSettlementVO> list = command.searchStlVvd(procSettlementVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String stlVvdSeq = "";
		String stlBzcPortCd = "";
		String etaDt = "";
		String loclCurrCd = "";
		String ucBssPortCd = "";
		String ucBssPortEtdDt = "";
		String stDt = "";
		String endDt = "";
		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			ProcSettlementVO voOut = list.get(0);

			stlVvdSeq = voOut.getStlVvdSeq();
			stlBzcPortCd = voOut.getStlBzcPortCd();
			etaDt = voOut.getEtaDt();
			loclCurrCd = voOut.getLoclCurrCd();
			ucBssPortCd = voOut.getUcBssPortCd();
			ucBssPortEtdDt = voOut.getUcBssPortEtdDt();
			stDt = voOut.getStDt();
			endDt = voOut.getEndDt();
		}
		eventResponse.setETCData("stl_vvd_seq", stlVvdSeq);
		eventResponse.setETCData("stl_bzc_port_cd", stlBzcPortCd);
		eventResponse.setETCData("eta_dt", etaDt);
		eventResponse.setETCData("locl_curr_cd", loclCurrCd);
		eventResponse.setETCData("uc_bss_port_cd", ucBssPortCd);
		eventResponse.setETCData("uc_bss_port_etd_dt", ucBssPortEtdDt);
		eventResponse.setETCData("st_dt", stDt);
		eventResponse.setETCData("end_dt", endDt);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0013 : Create
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse searchAddStlWRList(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		FnsJoo0013Event event = (FnsJoo0013Event)e;
//		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
//		List<ProcSettlementVO> list = command.searchAddStlList(event.getProcSettlementVO());
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		eventResponse.setRsVoList(list);
//		return eventResponse;
//	}

	/**
	 * FNS_JOO_0014 : Create
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse searchAddStlPBList(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		FnsJoo0014Event event = (FnsJoo0014Event)e;
//		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
//		List<ProcSettlementVO> list = command.searchAddStlList(event.getProcSettlementVO());
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		eventResponse.setRsVoList(list);
//		return eventResponse;
//	}

	/**
	 * FNS_JOO_0012 : Create
	 * retrieving for Other Create
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddStlOTHList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0012Event event = (FnsJoo0012Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchAddStlList(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0007 : Create
	 * retrieving Slot-Hire Settlement for Creating
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddStlSHList(Event e) throws EventException {
		FnsJoo0007Event event = (FnsJoo0007Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		ProcSettlementVO procSettlementVO = event.getProcSettlementVO();
		//2015.07.07 NYK Modify
		//OPR 추가에 따른 소스 코드 수정 : procSettlementVO.jo_stl_itm_cd=S/H,OPR, procSettlementVO.jo_mnu_nm=S/H,OPR
		List<ProcSettlementVO> rtnList = new ArrayList<ProcSettlementVO>();
		List<ProcSettlementVO> list = command.searchAddStlForSlotHireList(procSettlementVO);
		if(list != null && list.size() > 0){
			for(ProcSettlementVO vo : list){
				rtnList.add(vo);
			}
		}
		
		//ItemList Exist Check : OPR
		String addJoStlItmCd = procSettlementVO.getAddJoStlItmCd();
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		//jooCodeParamVO.setSuperCd1("Y"); //auto cre flg = 'Y'
		JOOFindCodeAndCheckBC command1 = new JOOFindCodeAndCheckBCImpl();		
		List<JooCodeInfoVO> itemList = command1.searchStlItemCodeList(jooCodeParamVO);
		boolean isExistItem = false;
		for(JooCodeInfoVO codeVo : itemList){
			if(codeVo.getCode().equals(addJoStlItmCd)){
				isExistItem = true;
				break;
			}
		}
				
		//2015.07.07 NYK Modify Add OPR : Port to Port 일대는 진행하지 않는다.
		if(isExistItem && StringUtils.isNotEmpty(addJoStlItmCd) && !JooConstants.KEY_SH_OPTION_PORT.equals(procSettlementVO.getSchTpCd())){
			procSettlementVO.setJoStlItmCd(procSettlementVO.getAddJoStlItmCd());
			procSettlementVO.setJoMnuNm(procSettlementVO.getAddJoMnuNm());
			
			List<ProcSettlementVO> list2 = command.searchAddStlForSlotHireList(procSettlementVO);
			if(list2 != null && list2.size() > 0){
				for(ProcSettlementVO vo : list2){
					rtnList.add(vo);
				}
			}
		}
		
		//List<ProcSettlementVO> list = command.searchAddStlForSlotHireList(procSettlementVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(rtnList);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0009 : Create
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddStlRDRList(Event e) throws EventException {
		FnsJoo0009Event event = (FnsJoo0009Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchAddStlForOusRdrList(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0010 : Create
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddStlTDRList(Event e) throws EventException {
		FnsJoo0010Event event = (FnsJoo0010Event) e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchAddStlForOusTdrList(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : Create
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddStlRFList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0011Event event = (FnsJoo0011Event) e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<SettlementRFVO> list = command.searchAddStlForRFList(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0007 : Open
	 * retrieving Carrier Code List, Revenue Dir. BSA Type
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0007(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		// Revenue Direction
		CodeUtil codeUtil = CodeUtil.getInstance();

		//BSA Type => starting 1
		@SuppressWarnings("unchecked")
		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD01866", 0);
		String stljbSheetList[] = new String[2];
		stljbSheetList[0] = "";
		stljbSheetList[1] = "";

		@SuppressWarnings("rawtypes")
		Iterator iterator = codeList2.iterator();

		while(iterator.hasNext()){
			CodeInfo codeInfo = (CodeInfo)iterator.next();

			if ("1".equals(codeInfo.getCode().substring(0,1))){
				stljbSheetList[0] = stljbSheetList[0]+"|"+codeInfo.getCode();
				stljbSheetList[1] = stljbSheetList[1]+"|"+codeInfo.getName();
			}
		}
		if(stljbSheetList[0].length() > 0){
			stljbSheetList[0] = stljbSheetList[0].substring(1);
			stljbSheetList[1] = stljbSheetList[1].substring(1);
		}
		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
		procSettlementVO.setAcctYrmon(JSPUtil.getKST("yyyyMM"));
		procSettlementVO.setReDivrCd("R");
		eventResponse.setETCData("clz_yn", searchCloseYn(procSettlementVO));
		eventResponse.setETCData("jo_crr_cd", crrCombo);
		eventResponse.setETCData("stl_jb_combo", stljbSheetList[0]);
		eventResponse.setETCData("stl_jb_comnm", stljbSheetList[1]);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0009 : open
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0009(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		// Region Code
		CodeUtil codeUtil = CodeUtil.getInstance();
		
		StringBuffer rgnComboCd = new StringBuffer();
		StringBuffer rgnComboNm = new StringBuffer();
		JooCodeParamVO jooCodeParamVO2 = new JooCodeParamVO();
		List<JooCodeInfoVO> regionList = command.searchRegionList(jooCodeParamVO2);
		if(null != regionList && regionList.size() > 0){
			@SuppressWarnings("rawtypes")
			Iterator it = (Iterator) regionList.iterator();
			int iCnt = 0;
			while(it.hasNext()){
				JooCodeInfoVO vo = (JooCodeInfoVO)it.next();
				if(iCnt == 0){
					rgnComboCd.append(vo.getCode()); // Region Code
					rgnComboNm.append(vo.getName()); // Region Name					
				}else{
					rgnComboCd.append("|").append(vo.getCode()); // Region Code
					rgnComboNm.append("|").append(vo.getName()); // Region Name
				}
				iCnt++;
			}				
		}
		
		//@SuppressWarnings("unchecked")
		//Collection<CodeInfo> codeList1 = codeUtil.getCodeSelect("CD02169", 0);
		//String rgnSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList1), BizComUtil.CODE_DELIMITTER);
		

		// Inter or Ocean
		@SuppressWarnings("unchecked")
		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD00206", 0);
		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);

		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
		procSettlementVO.setAcctYrmon(JSPUtil.getKST("yyyyMM"));
		procSettlementVO.setReDivrCd("R");
		eventResponse.setETCData("clz_yn", searchCloseYn(procSettlementVO));
		eventResponse.setETCData("jo_crr_cd", crrCombo);
		eventResponse.setETCData("rgn_combo", rgnComboCd.toString());
		eventResponse.setETCData("rgn_combo_nm", rgnComboNm.toString());
		eventResponse.setETCData("ioc", stljbSheetList[0]);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0010 : Open
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0010(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
		procSettlementVO.setAcctYrmon(JSPUtil.getKST("yyyyMM"));
		procSettlementVO.setReDivrCd("R");
		eventResponse.setETCData("clz_yn", searchCloseYn(procSettlementVO));
		eventResponse.setETCData("jo_crr_cd", crrCombo);
		return eventResponse;
	}

	/**
	 * changing list to String for combo
	 * @param List<JooCodeInfoVO> list
	 * @param int flg
	 * @return String rtnVal
	 * @throws EventException
	 */
	private String makeComboString(List<JooCodeInfoVO> list, int flg) throws EventException {
		String rtnVal = null;
		StringBuilder sb = new StringBuilder();

		@SuppressWarnings("rawtypes")
		Iterator iterator = (Iterator) list.iterator();

		while (iterator.hasNext()) {
			JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO) iterator.next();
			
			if (flg == 0) {
				sb.append(jooCodeInfoVO.getName() + ","
						+ jooCodeInfoVO.getCode() + "|");
				// IBCombo (code, code|)
			} else if (flg == 1) {
				sb.append(jooCodeInfoVO.getCode() + ","
						+ jooCodeInfoVO.getCode() + "|");
				// IBSheet code(code|)
			} else if (flg == 2) {
				sb.append(jooCodeInfoVO.getCode() + "|");
				// IBSheet name(name|)
			} else if (flg == 3) {
				sb.append(jooCodeInfoVO.getName() + "|");
				// SuperCd
			} else if (flg == 4) {
				sb.append(jooCodeInfoVO.getSuperCd1() + ","
						+ jooCodeInfoVO.getSuperCd2() + ","
						+ jooCodeInfoVO.getCode() + "|");
			} else if (flg == 5) {
				sb.append(jooCodeInfoVO.getCode() + "\t"
						+ jooCodeInfoVO.getName() + "|");
			} else if (flg == 6) {
				sb.append(jooCodeInfoVO.getCode() + ","
						+ jooCodeInfoVO.getName() + "|");
			}
		}
		rtnVal = sb.toString();

		if (rtnVal.length() > 0) {
			rtnVal = rtnVal.substring(0, rtnVal.length() - 1);
		}

		return rtnVal;
	}

	/**
	 * changing List to String for combo
	 *
	 * @param list
	 * @param flg
	 * @return String
	 * @throws EventException
	 */
	/*private String makeComboString5(List<JooCodeInfoVO> list, int flg) throws EventException {
		String rtnVal = null;
		StringBuilder sb = new StringBuilder();
		int allChk = 1;

		Iterator iterator = (Iterator) list.iterator();

		while (iterator.hasNext()) {
			JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO) iterator.next();
			
			if (flg == 0) {
				sb.append(jooCodeInfoVO.getName() + ","
						+ jooCodeInfoVO.getCode() + "|");
				// IBCombo (code, code|)
			} else if (flg == 1) {
				if (allChk == 1) {
					sb.append("ALL,ALL|");
					allChk++;
				}
				sb.append(jooCodeInfoVO.getCode() + ","
						+ jooCodeInfoVO.getCode() + "|");
				// IBSheet code(code|)
			} else if (flg == 2) {
				sb.append(jooCodeInfoVO.getCode() + "|");
				// IBSheet name(name|)
			} else if (flg == 3) {
				sb.append(jooCodeInfoVO.getName() + "|");
				// SuperCd
			} else if (flg == 4) {
				sb.append(jooCodeInfoVO.getSuperCd1() + ","
						+ jooCodeInfoVO.getSuperCd2() + ","
						+ jooCodeInfoVO.getCode() + "|");
			} else if (flg == 5) {
				sb.append(jooCodeInfoVO.getCode() + "\t"
						+ jooCodeInfoVO.getName() + "|");
			}
		}

		rtnVal = sb.toString();

		if (rtnVal.length() > 0) {
			rtnVal = rtnVal.substring(0, rtnVal.length() - 1);
		}

		return rtnVal;
	}*/
    /**
     * FNS_JOO_0030 : Retrieve
     * D : [FnsJoo0060Event]<br>
     * retrieving monthly accrual closing information
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse searchAccrualClosing(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0030Event event = (FnsJoo0030Event) e;
		JooEstmClzVO vo = event.getJooEstmClzVO();

		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		List<JooEstmClzVO> list = command.searchAccrualClosing(vo, account);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0030 : Save
     * saving monthly accrual closing information
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse modifyAccrualClosing(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0030Event event = (FnsJoo0030Event) e;
		JooEstmClzVO[] vos = event.getJooEstmClzVOS();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();

		try {
			begin();
			command.modifyAccrualClosing(vos, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage() );
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0032 : Retrieve
	 * retrieving Estimate Report - Account<br>
	 *
	 * @param  Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author 
	 */
	private EventResponse searchAccrualListByAccount(Event e) throws EventException {
	    try{
    		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
    		FnsJoo0032Event event = (FnsJoo0032Event) e;
    		ActRsltRVO vo = event.getActRsltRVO();
    		List<ActRsltRVO> list = command.searchAccrualListByAccount(vo);
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
     * FNS_JOO_0024, FNS_JOO_0069 : Retrieve
     * retrieving CSR Approval screen - CSR Detail
     *
	 * @param  Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author 
	 */
	private EventResponse searchDetailSlipList(Event e)
			throws EventException {
	    try{
    		// PDTO(Data Transfer Object including Parameters)
    		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
    		FnsJoo0024Event event = (FnsJoo0024Event) e;
    		SlipConditionVO vo = event.getSlipConditionVO();
    		
    		List<SlipVO> list = command.searchDetailSlipList(vo);
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

    /**
     *  FNS_JOO_0022 : Open <br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse openFnsJoo0022(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
    		String authOfcCds 		= this.searchConditionComboItemByCsrAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_CSR_AUTH_OFC, null, JooConstants.KEY_SEARCH_TP_CD_CSR_APPROVAL); //2016.07.26 권한 있는 Office 조회
            eventResponse.setETCData("auth_ofc_cds" , authOfcCds);
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }

	/**
	 * FNS_JOO_0022 : Retrieve
	 * retrieving Office Code List
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchApprovalCsrOfcList(Event e) throws EventException {
		GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
        	FnsJoo0022Event event = (FnsJoo0022Event) e;
        	CsrVO csrVO = event.getCsrVO();
        	
        	SlipConditionVO vo = new SlipConditionVO();
        	vo.setSchTpCd(JooConstants.KEY_SEARCH_TP_CD_CSR_APPROVAL);
        	vo.setIfFlg(csrVO.getIfFlg());
        	vo.setSlpIssDt(csrVO.getSlpIssDt());
        	
        	String authOfcCds 		= this.searchConditionComboItemByCsrAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_CSR_AUTH_OFC, vo, JooConstants.KEY_SEARCH_TP_CD_CSR_APPROVAL); //2016.07.26 권한 있는 Office 조회
            eventResponse.setETCData("auth_ofc_cds" , authOfcCds);
            
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
	}

	/**
	 * FNS_JOO_0022 : Retrieve
	 * retrieving list for CSR Approval
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchConsultationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0022Event event = (FnsJoo0022Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		
		CsrVO csrVO = event.getCsrVO();
		
		csrVO.setSlpOfcCd(account.getOfc_cd());
		
		csrVO.setCreUsrId(account.getUsr_id());
		List<CsrVO> list = command.searchConsultationList(csrVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0023 : Retrieve
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchDetailConsultation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0023Event event = (FnsJoo0023Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();

		CsrVO csrVO = event.getCsrVO();
		csrVO.setAuthOfcCd(account.getOfc_cd()); 
		csrVO.setCreUsrId (account.getUsr_id()); 
		
		List<CsrVO> list = command.searchDetailConsultation(csrVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0023 : Approval
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse approvalConsultation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsJoo0023Event event = (FnsJoo0023Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		
		AccountPayableInvoiceSC invSC = new AccountPayableInvoiceSC();
		
		try {
			begin();
			CsrVO[] csrVOs = event.getCsrVOS();
			
			String ifNo = command.approvalConsultation(csrVOs[0], account);
			int    errCnt = 0;
			String errMsg = "";
			if ("Y".equals(csrVOs[0].getAproFlg())) {
				if (JooConstants.KEY_SLIP_TP_CD_AR_18.equals(csrVOs[0].getCsrNo().substring(0,2))) { // "18" AR
					
					AccountReceivableOutstandingBC sarOtsIfCommand = new AccountReceivableOutstandingBCImpl();
					
					//String[] strIfNo = ifNo.split("||");
					String[] strIfNo = StringUtils.split(ifNo, "||"); //2015.02.24 error로 apache utils 로 변경함.
					
					for (int row = 0; row < strIfNo.length; row++) {
						sarOtsIfCommand.createOutstandingByInterface(strIfNo[row]);
					}			
				} else {
					if (csrVOs.length > 0) {
						
						// Processing AP IF Validation...... 
						for (int row = 0; row < csrVOs.length; row++) {
							EventResponse apEventResponse = new GeneralEventResponse();					
							apEventResponse = invSC.manageSapIfValidateImportCheck("S/O_BIZ", csrVOs[row].getCsrNo(), account.getUsr_id());
							Map<String, String> mapVO = apEventResponse.getETCData();
							
							if ("FAIL".equals(mapVO.get("SUCCESS_FLG")) ) {
								errCnt++;
								errMsg = mapVO.get("RESULT_MSG");
								
								break;
							}
						}
					}
				}
			}
			
			if (errCnt > 0) {
				rollback();
				eventResponse.setUserMessage((String) new ErrorHandler("COM12217", new String[]{"["+csrVOs[0].getCsrNo()+"]" + "\n" + errMsg}).getUserMessage());
			} else {						
				commit();
				// ($s) was saved successfully.
				eventResponse.setUserMessage((String) new ErrorHandler("COM12191", new String[]{csrVOs[0].getCsrNo()}).getUserMessage());
			}
			
		} catch (EventException ex) {
			rollback();
			throw ex;
       } catch (Exception ex) {
           log.error("err " + ex.toString(), ex);
           rollback();
           throw new EventException(ex.getMessage(), ex);
       }
		return eventResponse;
	}

	/**
	 * FNS_JOO_0073 : Retrieve
     * 
     *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse searchPersonInfo(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		FnsJoo0073Event event = (FnsJoo0073Event) e;
//		JointOperationLetterBC command = new JointOperationLetterBCImpl();
//		
//		List<JooCntcMbrVO> list = command.searchPersonInfo(event.getJoCrrCd());
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		eventResponse.setRsVoList(list);
//		return eventResponse;
//	}

	/**
	 * FNS_JOO_0018 : Retrieve
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse searchAPEvidenceList(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		FnsJoo0018Event event = (FnsJoo0018Event) e;
//		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
//		
//		TaxGrpVO grpVO = command.searchAPEvidence(event.getCsrNo());
//		List<JooTaxVO> jooTaxVOs = grpVO.getJooTaxVOs();
//		List<JooTaxDtlVO> jooTaxDtlVOs = grpVO.getJooTaxDtlVOs();
//
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		eventResponse.setRsVoList(jooTaxDtlVOs);
//		eventResponse.setRsVoList(jooTaxVOs);
//		return eventResponse;
//	}

	/**
	 * FNS_JOO_0018 : Retreive
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse searchCreateAPEvidenceList(Event e)
//			throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		FnsJoo0018Event event = (FnsJoo0018Event) e;
//		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
//		
//		List<JooTaxVO> list = command.searchVendorInfo(event.getVndrSeq());
//
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		eventResponse.setRsVoList(list);
//		return eventResponse;
//	}

	/**
	 * FNS_JOO_0070:Retrieve
	 * 
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse searchLetterSendList(Event e)
//			throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		JointOperationLetterBC command = new JointOperationLetterBCImpl();
//		FnsJoo0070Event event = (FnsJoo0070Event) e;
//		InvMcsLetterVO vo = event.getLetterVO();
//		
//		List<InvMcsLetterVO> list = command.searchLetterSendList(vo);
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		eventResponse.setRsVoList(list);
//		return eventResponse;
//	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse openFnsJoo0018(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
//
//		// Carrier 
//		List<JooCodeInfoVO> list = command.searchTaxOfcList(jooCodeParamVO);
//
//		String ofcCombo = makeComboString(list, 1);
//
//		eventResponse.setETCData("ofc_list", ofcCombo);
//		return eventResponse;
//	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse openFnsJoo0070(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
//
//		// Carrier Code List
//        jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
//		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
//
//		String crrCombo = ",|" + makeComboString(list, 1);
//
//		eventResponse.setETCData("jo_crr_cd", crrCombo);
//		return eventResponse;
//	}

	/**
	 * FNS_JOO_0037 : Retrieve
     * retrieving Report by Trade
     *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSummaryOfMcsListByTrade(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0037Event event = (FnsJoo0037Event) e;
		McsStatusVO mcsStatusVO = event.getMcsStatusVO();

		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		//mcsStatusVO.setOfcCd(  this.account.getOfc_cd()  );
		List<McsStatusVO> list = command.searchSummaryOfMcsListByTrade(mcsStatusVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
    /**
     * FNS_JOO_0037 : Open
     * retrieving data by Trade
     *
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse openFnsJoo0037(Event e) throws EventException {
        try{
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

            String ofcCd = this.account.getOfc_cd();

    		//Office Code 
    		String offCombo = "";    		
    		if (OfficeCodeMgr.checkContainOfficeCode("000001","JOO",ofcCd)){
    			List<JooCodeInfoVO> list1 = command.searchAuthOfficeList(jooCodeParamVO);
    			offCombo = " ,|"+makeComboString(list1, 1);
    		}else{
    			offCombo = ofcCd+","+ofcCd;
    		}

            eventResponse.setETCData("office", offCombo);

            // Trade code  
            jooCodeParamVO.setOfcCd(  this.account.getOfc_cd() );
            List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);
            eventResponse.setRsVoList(list);
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * retrieving Carrier, Settlement Item, Dir., Status
     *
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchTradeCodeList(Event e) throws EventException {
         try{
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

            // Trade code  
            jooCodeParamVO.setOfcCd(  this.account.getOfc_cd() );
            List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);
            eventResponse.setRsVoList(list);
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * retrieving Office Code
     *
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse openFnsJoo0036(Event e) throws EventException {
         try{
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

            String ofcCd = this.account.getOfc_cd();

    		//Office Code 
    		String offCombo = "";
    		if (OfficeCodeMgr.checkContainOfficeCode("000001","COM",ofcCd)){
    			List<JooCodeInfoVO> list1 = command.searchAuthOfficeList(jooCodeParamVO);
    			offCombo = " ,|"+makeComboString(list1, 1);
    		}else{
    			offCombo = ofcCd+","+ofcCd;
    		}

            eventResponse.setETCData("office", offCombo);
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }


	/**
     * FNS_JOO_0033 : Retrieve
	 * retrieving MAS data
	 *
	 * @param EstmActRsltVO vo
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAccrualListByMAS(Event e) throws EventException {
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo0033Event event = (FnsJoo0033Event) e;
		ActRsltRVO vo = event.getActRsltRVO();
		List<ActRsltRVO> list = command.searchAccrualListByMAS(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0025 : Retrieve
	 * retrieving Slip Approval status
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSlipList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0025Event event = (FnsJoo0025Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		
		List<CsrSlipVO> list = command.searchSlipList(event.getSlipConditionVO());

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0025 : Open
	 * retrieving Office Code
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0025(Event e) throws EventException {
		GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
    		
        	String authOfcCds 		= this.searchConditionComboItemByCsrAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_CSR_AUTH_OFC, null, JooConstants.KEY_SEARCH_TP_CD_CSR_INQUIRY); //2016.07.26 권한 있는 Office 조회
            eventResponse.setETCData("auth_ofc_cds" , authOfcCds);
            
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
	}

	/**
	 * FNS_JOO_0025 : Retrieve
	 * retrieving Office Code List
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCsrOfcList(Event e) throws EventException {
		GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
        	FnsJoo0025Event event = (FnsJoo0025Event) e;
        	SlipConditionVO vo = event.getSlipConditionVO();
        	
        	String authOfcCds 		= this.searchConditionComboItemByCsrAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_CSR_AUTH_OFC, vo, JooConstants.KEY_SEARCH_TP_CD_CSR_INQUIRY); //2016.07.26 권한 있는 Office 조회
            eventResponse.setETCData("auth_ofc_cds" , authOfcCds);
            
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
	}


	/**
	 * FNS_JOO_0066 : Open
	 * retrieving Carrier, Revenue Dir., Inter/Ocean, Sub Conti
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	/*private EventResponse openFnsJoo0066(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 
		String ofcCd = this.account.getOfc_cd();
        jooCodeParamVO.setOfcCd( ofcCd );

		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
		List<JooCodeInfoVO> list1 = command.searchCarrierByLaneList(ofcCd);


		String crrCombo = makeComboString(list, 1);
		String crrSheet = makeComboString(list, 2);
		String rlaneSheet = makeComboString(list1, 0);

		eventResponse.setETCData("jo_crr_cd", crrCombo);
		eventResponse.setETCData("jo_crr_cd_sheet", crrSheet);
		eventResponse.setETCData("rlane_cd_sheet", rlaneSheet);

		return eventResponse;
	}*/

	/**
	 * FNS_JOO_0067 : Open
	 * retrieving Carrier, Revenue Dir., Inter/Ocean, Sub Conti
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	/*private EventResponse openFnsJoo0067(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 
        //jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
		List<JooCodeInfoVO> list = command
				.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);

		String crrCombo = makeComboString5(list, 1);

		eventResponse.setETCData("jo_crr_cd", crrCombo);
		return eventResponse;
	}*/


	/**
	 * FNS_JOO_0036 : Retrieve
	 * Summary of Monthly Clearance Status by Carrier Search
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSummaryOfMcsListByCarrier(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0036Event event = (FnsJoo0036Event) e;
		McsStatusVO vo = event.getMcsStatusVO();

		//vo.setOfcCd(account.getOfc_cd());
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<McsStatusVO> list = command.searchSummaryOfMcsListByCarrier(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}


	/**
	 * FNS_JOO_0059, FNS_JOO_0061 : Retrieve
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchTemplate(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		JooLtrTmpltVO jooLtrTmpltVO = null;
//		if (e.getEventName().equalsIgnoreCase("FnsJoo0059Event")) {
//			FnsJoo0059Event event = (FnsJoo0059Event) e;
//			jooLtrTmpltVO = event.getJooLtrTmpltVO();
//		} else {
//			FnsJoo0061Event event = (FnsJoo0061Event) e;
//			jooLtrTmpltVO = event.getJooLtrTmpltVO();
//		}
//
//		JointOperationLetterBC command = new JointOperationLetterBCImpl();
//
//		String joLtrTpCd = (String) jooLtrTmpltVO.getJoLtrTpCd() == null ? ""
//				: (String) jooLtrTmpltVO.getJoLtrTpCd();
//		String ofcCd = (String) jooLtrTmpltVO.getOfcCd() == null ? ""
//				: (String) jooLtrTmpltVO.getOfcCd();
//		String joTmpltNo = (String) jooLtrTmpltVO.getJoTmpltNo() == null ? ""
//				: (String) jooLtrTmpltVO.getJoTmpltNo();
//
//		jooLtrTmpltVO = command.searchTemplate(joLtrTpCd, ofcCd, joTmpltNo);
//		if(jooLtrTmpltVO != null){
//			Map<String, String> mapVO = jooLtrTmpltVO.getColumnValues();
//			eventResponse.setETCData(mapVO);
//		}
//		return eventResponse;
//	}

	/**
	 * FNS_JOO_0059, FNS_JOO_0061 : SAVE
     * 
     *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse createTemplate(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		JooLtrTmpltVO jooLtrTmpltVO = null;
//		String copy = "";
//		if (e.getEventName().equalsIgnoreCase("FnsJoo0059Event")) {
//			FnsJoo0059Event event = (FnsJoo0059Event) e;
//			jooLtrTmpltVO = event.getJooLtrTmpltVO();
//			copy = event.getCopy();
//		} else {
//			FnsJoo0061Event event = (FnsJoo0061Event) e;
//			jooLtrTmpltVO = event.getJooLtrTmpltVO();
//			copy = event.getCopy();
//		}
//
//		JointOperationLetterBC command = new JointOperationLetterBCImpl();
//
//		try {
//			begin();
//
//			/*
//			 * byte[] n1stStmtCtnt = jooLtrTmpltVO.getN1stStmtCtnt().getBytes();
//			 * byte[] n2ndStmtCtnt = jooLtrTmpltVO.getN2ndStmtCtnt().getBytes();
//			 * byte[] n3rdStmtCtnt = jooLtrTmpltVO.getN3rdStmtCtnt().getBytes();
//			 *
//			 * if (n1stStmtCtnt.length > 200) {
//			 * jooLtrTmpltVO.setN1stStmtCtnt(new String(n1stStmtCtnt, 0, 200));
//			 * } else { jooLtrTmpltVO.setN1stStmtCtnt(new String(n1stStmtCtnt,
//			 * 0, n1stStmtCtnt.length)); } if (n2ndStmtCtnt.length > 200) {
//			 * jooLtrTmpltVO.setN2ndStmtCtnt(new String(n2ndStmtCtnt, 0, 200));
//			 * } else { jooLtrTmpltVO.setN2ndStmtCtnt(new String(n2ndStmtCtnt,
//			 * 0, n2ndStmtCtnt.length)); } if (n1stStmtCtnt.length > 200) {
//			 * jooLtrTmpltVO.setN3rdStmtCtnt(new String(n3rdStmtCtnt, 0, 200));
//			 * } else { jooLtrTmpltVO.setN3rdStmtCtnt(new String(n3rdStmtCtnt,
//			 * 0, n3rdStmtCtnt.length)); }
//			 */
//			LetterVO rstVo = command.createTemplate(jooLtrTmpltVO, copy, account);
//			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
//
//	        String joLtrTpCd = jooLtrTmpltVO.getJoLtrTpCd();
//	        String ofcCd     = jooLtrTmpltVO.getOfcCd();
//	        String userId    = this.account.getUsr_id();
//
//	        List<JoTmpltNoVO> list = command.searchTempalteTextNoList(joLtrTpCd,ofcCd, userId);
//
//
//	        eventResponse.setRsVoList(list);
//            eventResponse.setETCData("NEW_JO_TMPLT_NO", rstVo.getJoTmpltNo() );
//            eventResponse.setETCData("NEW_JO_LTR_TMPLT_SEQ", rstVo.getJoLtrTmpltSeq() );
//
//			commit();
//		} catch (EventException ex) {
//			rollback();
//			throw ex;
//		} catch (Exception ex) {
//			rollback();
//			throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;
//	}

	/**
	 * FNS_JOO_0059, FNS_JOO_0061:Delete
     * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse removeTemplate(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		JooLtrTmpltVO jooLtrTmpltVO = null;
//		if (e.getEventName().equalsIgnoreCase("FnsJoo0059Event")) {
//			FnsJoo0059Event event = (FnsJoo0059Event) e;
//			jooLtrTmpltVO = event.getJooLtrTmpltVO();
//		} else {
//			FnsJoo0061Event event = (FnsJoo0061Event) e;
//			jooLtrTmpltVO = event.getJooLtrTmpltVO();
//		}
//
//		JointOperationLetterBC command = new JointOperationLetterBCImpl();
//
//		try {
//			begin();
//			String joLtrTpCd = (String) jooLtrTmpltVO.getJoLtrTpCd() == null ? ""
//					: (String) jooLtrTmpltVO.getJoLtrTpCd();
//			String ofcCd = (String) jooLtrTmpltVO.getOfcCd() == null ? ""
//					: (String) jooLtrTmpltVO.getOfcCd();
//			String joTmpltNo = (String) jooLtrTmpltVO.getJoTmpltNo() == null ? ""
//					: (String) jooLtrTmpltVO.getJoTmpltNo();
//
//			command.removeTemplate(joLtrTpCd, ofcCd, joTmpltNo);
//			eventResponse.setUserMessage(new ErrorHandler("JOO10005").getUserMessage()  );
//			commit();
//
//	        /***************************************************************************
//	         * User Nm Of TextNo  List
//	         *
//	         ***************************************************************************/
//	         joLtrTpCd = jooLtrTmpltVO.getJoLtrTpCd();
//	               ofcCd     = jooLtrTmpltVO.getOfcCd();
//	        String userId    = this.account.getUsr_id();
//
//	        List<JoTmpltNoVO> textNoList = command.searchTempalteTextNoList(joLtrTpCd,ofcCd, userId);
//	        eventResponse.setRsVoList(textNoList);
//
//		} catch (EventException ex) {
//			rollback();
//			throw ex;
//		} catch (Exception ex) {
//			rollback();
//			throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;
//	}

	/**
	 * FNS_JOO_0059, FNS_JOO_0061 USER_ID: CHANGE
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse searchTempalteTextNoList(Event e)
//			throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		JoTmpltNoVO joTmpltNoVO = null;
//		if (e.getEventName().equalsIgnoreCase("FnsJoo0059Event")) {
//			FnsJoo0059Event event = (FnsJoo0059Event) e;
//			joTmpltNoVO = event.getJoTmpltNoVO();
//		} else {
//			FnsJoo0061Event event = (FnsJoo0061Event) e;
//			joTmpltNoVO = event.getJoTmpltNoVO();
//		}
//
//		JointOperationLetterBC command = new JointOperationLetterBCImpl();
//
//		String joLtrTpCd = joTmpltNoVO.getJoLtrTpCd() == null ? ""
//				: joTmpltNoVO.getJoLtrTpCd(); // "M";
//		String ofcCd = joTmpltNoVO.getOfcCd() == null ? "" : joTmpltNoVO
//				.getOfcCd(); // account.getOfc_cd();
//		String userId = joTmpltNoVO.getUserId() == null ? "" : joTmpltNoVO
//				.getUserId();
//
//		List<JoTmpltNoVO> list = command.searchTempalteTextNoList(joLtrTpCd,ofcCd, userId);
//
//		eventResponse.setRsVoList( list );
//		return eventResponse;
//	}



	/**
	 * FNS_JOO_0039 : Retrieve
     * D : [FNS_JOO_0039] <br>
     *  retrieving Monthly Clearance Status by Carrier &amp; Lane
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMccListByCarNLane(Event e)
			throws EventException {
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0039Event event = (FnsJoo0039Event) e;
		StlConditionVO stlConditionVO = event.getStlConditionVO();

		stlConditionVO.setOfcCd(  this.account.getOfc_cd() );
		List<McsVO> list         = command.searchMcsListByCarNLane( event.getStlConditionVO()  );
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);

		return eventResponse;
	}
    /**
     * FNS_JOO_0039 : Retrieve
     * D : [FNS_JOO_0039] <br>
     *  retrieving Monthly Clearance Status by Carrier &amp; Lane
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
     */
    private EventResponse searchMccDtlListByCarNLane(Event e)
            throws EventException {
        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
        FnsJoo0039Event event = (FnsJoo0039Event) e;

        List<McsVO> list = command.searchMccDtlListByCarNLane(event.getStlConditionVO(),  event.getJooSettlementVOs() );
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);
        return eventResponse;
    }
	/**
	 * FNS_JOO_0029 : Retrieve
	 * Estimate Performance Creation - Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchJointOperationAccrualList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo0029Event event = (FnsJoo0029Event) e;

		List<EstmActRsltVO> list = null;
		//By VVD, By Month 별로 나누어야 함....
		list = command.searchJointOperationAccrualList(event.getSettlementConditionVO());
		eventResponse.setRsVoList(list);
		
		if ("1".equals(event.getSettlementConditionVO().getPageNo())){
			EstmActRsltVO estmActRsltVO = command.searchJointOperationAccrualTotal(event.getSettlementConditionVO());
			eventResponse.setETCData("estm_amt", estmActRsltVO.getEstmAmt());
			eventResponse.setETCData("act_amt" , estmActRsltVO.getActAmt ());
			eventResponse.setETCData("accl_amt", estmActRsltVO.getAcclAmt());
			eventResponse.setETCData("tot_cnt" , estmActRsltVO.getDiffAmt());
		}

		return eventResponse;
	}

	/**
	 * FNS_JOO_0029 : Save
	 * D : [FnsJoo0029Event] <br>
	 * saving [Estimate Performance Creation]<br>
	 *
	 * @param FnsJoo0029Event
	 * @return EventResponse
	 * @throws EventException
	 * @author 
	 */
	private EventResponse manageJointOperationAccrual(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo0029Event event = (FnsJoo0029Event) e;

		try {
			begin();
			String key = command.manageJointOperationAccrual(event.getEstmActRsltVOs(), event.getSettlementConditionVO(), this.account);
			eventResponse.setETCData("key", key);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_JOO_0029 : Create
	 * D : [FnsJoo0029Event]<br>
	 * creating [Estimate Performance Creation]<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @author 
	 */
	private EventResponse calJointOperationAccrual(Event e) throws EventException {
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo0029Event event = (FnsJoo0029Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			//begin();
			SettlementConditionVO settlementConditionVO = event.getSettlementConditionVO();
			String key = command.calJointOperationAccrual(settlementConditionVO, account);
			eventResponse.setETCData("key", key);
			//commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			//rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			//rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0029 : I/F
	 * D : [FnsJoo0029Event]<br>
	 * transmitting [Estimate Performance Creation]<br>
	 *
	 * @param FnsJoo0029Event
	 * @return EventResponse
	 * @throws EventException
	 * @author 
	 */
	private EventResponse sendJointOperationAccrualERP(Event e) throws EventException {
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo0029Event event = (FnsJoo0029Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			String key = command.sendJointOperationAccrualERP(event.getEstmActRsltVOs(), event.getSettlementConditionVO(), this.account);
			eventResponse.setETCData("key", key);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
            rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0009 : Inter/Ocean change
	 * retrieving unit price in case of changing Inter port / Ocean
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBsaSltPrcForOusRdr(Event e) throws EventException {
		FnsJoo0009Event event = (FnsJoo0009Event) e;

		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchBsaSltPrc(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String bsaSltPrc = "";

		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			ProcSettlementVO voOut = list.get(0);
			
			if(null != voOut) bsaSltPrc = voOut.getBsaSltPrc();
		}
		eventResponse.setETCData("bsa_slt_prc", bsaSltPrc);
		return eventResponse;
	}

	/**
	 * FNS_JOO_003401 : Retrieve
	 * D : [FnsJoo003401Event]<br>
	 * retrieving [Estimate Code Check - Carrier]<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author 
	 */
	private EventResponse searchEstdCarCheckList(Event e) throws EventException {
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo003401Event event = (FnsJoo003401Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<EstdCarVO> list = command.searchEstdCarCheckList(event.getYearMm());
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_003402 : Retrieve
	 * D : [FnsJoo003402Event]<br>
	 * retrieving [Estimate Code Check - VVD]<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author 
	 */
	private EventResponse searchEstdVvdCheckList(Event e) throws EventException {
	    try{
    		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
    		FnsJoo003402Event event = (FnsJoo003402Event) e;
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		List<EstdVvdVO> list = command.searchEstdVvdCheckList(event.getEstdVvdVO() );
    		eventResponse.setRsVoList(list);
    		return eventResponse;

        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * FNS_JOO_0065 : Retrieve
	 * D : [FnsJoo0065Event]<br>
	 * 
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author 
	 */
//	private EventResponse searchLetterSendStsList(Event e)
//			throws EventException {
//	    try{
//        		JointOperationLetterBC command = new JointOperationLetterBCImpl();
//        		FnsJoo0065Event event = (FnsJoo0065Event) e;
//        		GeneralEventResponse eventResponse = new GeneralEventResponse();
//        		List<LetterVO> list = command.searchLetterSendStsList(event.getOfccd(),
//				event.getUserid(), event.getFmdt(), event.getTodt());
//        		eventResponse.setRsVoList(list);
//        		return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw ex;
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//
//	}


	/**
	 * FNS_JOO_0060 : Get
	 * D : [FnsJoo0060Event]<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author 
	 */
//	private EventResponse searchMcsLetter(Event e) throws EventException {
//		JointOperationLetterBC command = new JointOperationLetterBCImpl();
//		FnsJoo0060Event event = (FnsJoo0060Event) e;
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		List<McsLetterVO> list     = command.searchMcsLetter( event.getLetterVO() );
//        List<McsLetterVO> carrlist = command.searchToCustList( event.getJocrrcd()  );
//		eventResponse.setRsVoList(list);
//        eventResponse.setRsVoList(carrlist);
//
//		return eventResponse;
//	}

	/**
	 * FNS_JOO_0060 : Retrieve
	 * D : [FnsJoo0060Event]<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author 
	 */
//	private EventResponse searchMcsCombined(Event e) throws EventException {
//		JointOperationLetterBC command = new JointOperationLetterBCImpl();
//		FnsJoo0060Event event = (FnsJoo0060Event) e;
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		List<McsCombinedVO> list = command.searchMcsCombined(event.getMcsCombinedVO());
//		eventResponse.setRsVoList(list);
//		return eventResponse;
//	}
    /**
     * FNS_JOO_0060 : Saved Retrieve
     * D : [FnsJoo0060Event]<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private EventResponse searchMcsSavedCombined(Event e) throws EventException {
//        JointOperationLetterBC command = new JointOperationLetterBCImpl();
//
//        FnsJoo0060Event event = (FnsJoo0060Event) e;
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        List<LetterVO> jooLetterList  = command.searchJooLetter(event.getLetterVO() );
//        List<LetterVO> jooLtrStlList  = command.searchJooLtrStl(event.getLetterVO() );
//
//        String carCd = "";
//        if(jooLetterList.size() > 0){
//            carCd = ((LetterVO)jooLetterList.get(0)).getJoCrrCd();
//        }
//
//        LetterVO letterVO = null;
//        if(jooLetterList.size() > 0){
//            letterVO = jooLetterList.get(0);
//            eventResponse.setETCData(letterVO.getColumnValues());
//        }
//        eventResponse.setRsVoList(jooLtrStlList);//Grid Dtl
//        List<McsLetterVO> carrlist    = command.searchToCustList( carCd  );  //Eng Nm
//
//        eventResponse.setRsVoList(carrlist);
//
//        return eventResponse;
//    }
    /**
     * FNS_JOO_0062 : Saved Retrieve
     * D : [FnsJoo0062Event]<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private EventResponse searchInvoiceSavedCombined(Event e) throws EventException {
//        JointOperationLetterBC command = new JointOperationLetterBCImpl();
//
//        FnsJoo0062Event event = (FnsJoo0062Event) e;
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//        List<LetterVO> jooLetterList          = command.searchJooLetter(event.getLetterVO() );
//        List<InvoiceCombinedVO> jooLtrStlList = command.searchSavedJooLtrStl(event.getInvoiceCombinedVO());
//
//
//        String jo_crr_cd = "";
//        if(jooLetterList.size() > 0){
//            jo_crr_cd = ((LetterVO)jooLetterList.get(0)).getJoCrrCd();
//        }
//
//        LetterVO letterVO = null;
//        if(jooLetterList.size() > 0){
//            letterVO = jooLetterList.get(0);
//            eventResponse.setETCData( letterVO.getColumnValues() );
//        }
//        eventResponse.setRsVoList(jooLtrStlList);
//        List<McsLetterVO> carrlist    = command.searchToCustList( jo_crr_cd  );
//
//        eventResponse.setRsVoList(carrlist);
//
//        return eventResponse;
//    }
	/**
	 * FNS_JOO_0060 : Save
	 * D : [FnsJoo0060Event]<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author 
	 */
//	private EventResponse manageMcsLetter(Event e) throws EventException {
//		JointOperationLetterBC command = new JointOperationLetterBCImpl();
//		FnsJoo0060Event event = (FnsJoo0060Event) e;
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		try {
//			begin();
//
//			LetterVO letterVo = command.manageMcsLetter(event.getLetterVO(), event.getLetterVOs(), this.account);
//			eventResponse.setETCData("jo_ltr_seq", letterVo.getJoLtrSeq());
//            eventResponse.setETCData("jo_ltr_no", letterVo.getJoLtrNo()  );
//
//            eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
//			commit();
//		} catch (EventException ex) {
//			log.error("err " + ex.toString(), ex);
//			rollback();
//			throw ex;
//		} catch (Exception ex) {
//            rollback();
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(ex.getMessage(), ex);
//		}
//
//		return eventResponse;
//	}

    /**
     * FNS_JOO_0060 : Send
     * D : [FnsJoo0060Event]<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//	private EventResponse sendMcsLetter(Event e) throws EventException {
//	    try{
//    		JointOperationLetterBC command = new JointOperationLetterBCImpl();
//    		FnsJoo0060Event event          = (FnsJoo0060Event) e;
//    		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//            begin();
//                LetterVO letterVO = event.getLetterVO();
//                letterVO.setUsrId( this.account.getUsr_id() );
//                command.sendMcsLetter(letterVO);
//                eventResponse.setCustomData(SubSystemConfigFactory.get("COM.MAIL.KEYS"), null);
//                eventResponse.setUserMessage(new ErrorHandler("JOO10006").getUserMessage());
//            commit();
//            return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            rollback();
//            throw ex;
//        } catch (Exception ex) {
//            rollback();
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPriceAndPortList(Event e) throws EventException {
		FnsJoo0010Event event = (FnsJoo0010Event) e;

		// PDTO(Data Transfer Object including Parameters)
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<ProcSettlementVO> list = command.searchOusTdrFnl(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String stlVvdSeq = "";
		String stlBzcPortCd = "";
		String etaDt = "";
		String loclCurrCd = "";
		String ucBssPortCd = "";
		String ucBssPortEtdDt = "";
		String fnlOwnBsaQty = "0";
		String fnlBsaWgt = "0";
		String bsaPerWgt = "0";

		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			@SuppressWarnings("rawtypes")
			Iterator iterator = list.iterator();
			ProcSettlementVO voOut = (ProcSettlementVO) iterator.next();

			stlVvdSeq = voOut.getStlVvdSeq();
			stlBzcPortCd = voOut.getStlBzcPortCd();
			etaDt = voOut.getEtaDt();
			loclCurrCd = voOut.getLoclCurrCd();
			ucBssPortCd = voOut.getUcBssPortCd();
			ucBssPortEtdDt = voOut.getUcBssPortEtdDt();
			fnlOwnBsaQty = voOut.getFnlOwnBsaQty();
			fnlBsaWgt = voOut.getFnlBsaWgt();
			bsaPerWgt = voOut.getBsaPerWgt();
		}
		eventResponse.setETCData("stl_vvd_seq", stlVvdSeq);
		eventResponse.setETCData("stl_bzc_port_cd", stlBzcPortCd);
		eventResponse.setETCData("eta_dt", etaDt);
		eventResponse.setETCData("locl_curr_cd", loclCurrCd);
		eventResponse.setETCData("uc_bss_port_cd", ucBssPortCd);
		eventResponse.setETCData("uc_bss_port_etd_dt", ucBssPortEtdDt);
		eventResponse.setETCData("fnl_own_bsa_qty", fnlOwnBsaQty);
		eventResponse.setETCData("fnl_bsa_wgt", fnlBsaWgt);
		eventResponse.setETCData("bsa_per_wgt", bsaPerWgt);

		
		JOOFindCodeAndCheckBC command1 = new JOOFindCodeAndCheckBCImpl();

		// parameter 
		// super_cd1 => rlane_cd
		// super_cd2 => VVD (VSL_CD,SKD_VOY_NO,SKD_DIR_CD 9자리)
		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list1 = command1.searchUnitCostPortList(jooCodeParamVO);

		// select List 
		// CODE => PORT
		// NAME => ETD
		String portList = makeComboString(list1, 2);

		eventResponse.setETCData("portList", portList);

		return eventResponse;
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOusTdrUsedSlot(Event e) throws EventException {
		FnsJoo0010Event event = (FnsJoo0010Event) e;

		// PDTO(Data Transfer Object including Parameters)
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<ProcSettlementVO> list = command.searchOusTdrUsedSlot(event.getProcSettlementVO());

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String usdSltBsaQty = "0";
		String usdSltWgt = "0";
		String fnlOwnBsaQty = "0";
		String fnlBsaWgt = "0";

		if (list.size() == 0) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			ProcSettlementVO voOut = list.get(0);

			usdSltBsaQty = voOut.getUsdSltBsaQty();
			usdSltWgt    = voOut.getUsdSltWgt();
			fnlOwnBsaQty = voOut.getFnlOwnBsaQty();
			fnlBsaWgt    = voOut.getFnlBsaWgt();
		}
		eventResponse.setETCData("usd_slt_bsa_qty", usdSltBsaQty);
		eventResponse.setETCData("usd_slt_wgt"    , usdSltWgt);
		eventResponse.setETCData("fnl_own_bsa_qty", fnlOwnBsaQty);
		eventResponse.setETCData("fnl_bsa_wgt"    , fnlBsaWgt);

		return eventResponse;
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOusTdrUsedSlotPrice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			FnsJoo0010Event event = (FnsJoo0010Event) e;

			// PDTO(Data Transfer Object including Parameters)
			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

			List<ProcSettlementVO> list = command.searchOusTdrUsedSlotPrice(event.getProcSettlementVO());


			String bsaSltPrc = "0";

			if (list.size() == 0) {
				eventResponse.setETCData("CHECKVVD", "E");
			} else if (list.size() > 1) {
				eventResponse.setETCData("CHECKVVD", "T");
			} else {
				eventResponse.setETCData("CHECKVVD", "N");

				ProcSettlementVO voOut = list.get(0);

				bsaSltPrc = voOut.getBsaSltPrc();
			}
			eventResponse.setETCData("bsa_slt_prc", bsaSltPrc);
		} catch (EventException ex){
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0038 : Retrieve
	 * D : [FnsJoo0038Event]<br>
	 * retrieving Summary of Monthly Clearance Status by VVD<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author 
	 */
	private EventResponse searchSummaryOfMcsListByVVD(Event e) throws EventException {
	    CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0038Event event = (FnsJoo0038Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		McsStatusVO mcsStatusVO = event.getMcsStatusVO();
		mcsStatusVO.setOfcCd(account.getOfc_cd());
		eventResponse.setRsVoList(command.searchSummaryOfMcsListByVVD(mcsStatusVO) );
		return eventResponse;
	}

	/**
	 * FNS_JOO_0042 : Retrieve
	 * D : [FnsJoo0042Event]<br>
	 * retrieving Slot Exchange Status by Lane & Partner->Finance Lane.<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author 
	 */
	private EventResponse searchSlotXchStatusListByFinanceLane(Event e) throws EventException {
        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0042Event event = (FnsJoo0042Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SlotXchLaneVO slotXchLaneVO= event.getSlotXchLaneVO();
		slotXchLaneVO.setOfcCd(  this.account.getOfc_cd() );
		eventResponse.setRsVoList(command.searchSlotXchStatusListByFinanceLane(  slotXchLaneVO )  );
		return eventResponse;
	}

	/**
	 * FNS_JOO_0043 : Retrieve
	 * D : [FnsJoo0043Event]<br>
	 * retrieving [ Slot Exchange Status by Lane & Partner->Finance Partner]
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author 
	 */
	private EventResponse searchSlotXchStatusListByFinancePartner(Event e) throws EventException {

	    CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0043Event event = (FnsJoo0043Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SlotXchPartnerVO  slotXchPartnerVO   = event.getSlotXchPartnerVO();
		slotXchPartnerVO.setOfcCd( this.account.getOfc_cd() );
		slotXchPartnerVO.setReDivrCd( "R" );
		eventResponse.setRsVoList(command.searchSlotXchStatusListByFinancePartner(  slotXchPartnerVO ));
        slotXchPartnerVO.setReDivrCd( "E" );
        eventResponse.setRsVoList(command.searchSlotXchStatusListByFinancePartner(  slotXchPartnerVO   ));

		return eventResponse;
	}

	/**
	 * FNS_JOO_0049 : Retrieve
	 * D : [FnsJoo0049Event]<br>
	 * retrieving [ Settlement Status for Basic Allocation]<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author 
	 */
	private EventResponse searchStlStatusListForBSA(Event e) throws EventException {
        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0049Event event = (FnsJoo0049Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StlConditionVO stlConditionVO = event.getStlConditionVO();
		//stlConditionVO.setOfcCd(this.account.getOfc_cd() );
		eventResponse.setRsVoList(command.searchStlStatusListForBSA(stlConditionVO));
		return eventResponse;
	}

	/**
	 * FNS_JOO_0050 : Retrieve
	 * D : [FnsJoo0050Event]<br>
	 * retrieving [ Target Voyage vs Unsettled Status]<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author 
	 */
	private EventResponse searchTgtVoyVsUnstlStatusList(Event e) throws EventException {
        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0050Event event = (FnsJoo0050Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(command.searchTgtVoyVsUnstlStatusList(event.getStlConditionVO()));
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : Open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0011(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		// Revenue Direction
		CodeUtil codeUtil = CodeUtil.getInstance();

		// Inter or Ocean
		@SuppressWarnings("unchecked")
		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD00206", 0);
		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);

		// R/T/U
		@SuppressWarnings("unchecked")
		Collection<CodeInfo> codeList3 = codeUtil.getCodeSelect("CD01868", 0);
		String rtuSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList3), BizComUtil.CODE_DELIMITTER);

		// RGN
		//Collection<CodeInfo> codeList4 = codeUtil.getCodeSelect("CD02169", 0);
		//String rgnSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList4), BizComUtil.CODE_DELIMITTER);
		StringBuffer rgnComboCd = new StringBuffer();
		StringBuffer rgnComboNm = new StringBuffer();
		JooCodeParamVO jooCodeParamVO2 = new JooCodeParamVO();
		List<JooCodeInfoVO> regionList = command.searchRegionList(jooCodeParamVO2);
		if(null != regionList && regionList.size() > 0){
			@SuppressWarnings("rawtypes")
			Iterator it = (Iterator) regionList.iterator();
			int iCnt = 0;
			while(it.hasNext()){
				JooCodeInfoVO vo = (JooCodeInfoVO)it.next();
				if(iCnt == 0){
					rgnComboCd.append(vo.getCode()); // Region Code
					rgnComboNm.append(vo.getName()); // Region Name					
				}else{
					rgnComboCd.append("|").append(vo.getCode()); // Region Code
					rgnComboNm.append("|").append(vo.getName()); // Region Name
				}
				iCnt++;
			}				
		}

		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
		procSettlementVO.setAcctYrmon(JSPUtil.getKST("yyyyMM"));
		procSettlementVO.setReDivrCd("R");
		eventResponse.setETCData("clz_yn", searchCloseYn(procSettlementVO));

		eventResponse.setETCData("jo_crr_cd", crrCombo);
		eventResponse.setETCData("ioc", stljbSheetList[0]);
		eventResponse.setETCData("rtu", rtuSheetList[0]);
		eventResponse.setETCData("rgn", rgnComboCd.toString());
		eventResponse.setETCData("ioc_nm", stljbSheetList[1]);
		eventResponse.setETCData("rtu_nm", rtuSheetList[1]);
		eventResponse.setETCData("rgn_nm", rgnComboNm.toString());
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettlementRFList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0011Event event = (FnsJoo0011Event) e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<SettlementRFVO> list = command.searchSettlementRFList(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : POD change
	 * cost retrieve at POD chanae of R/F Surcharge 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUsedReeferList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0011Event event = (FnsJoo0011Event) e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<SettlementRFVO> list = command.searchUsedReeferList(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String usdSltBsaQty20 = "0";
		String usdSltBsaQty40 = "0";
		String rfScgPrc20     = "0";
		String rfScgPrc40     = "0";

		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		}else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			SettlementRFVO voOut = list.get(0);

			usdSltBsaQty20 = voOut.getUsdSltBsaQty20();
			usdSltBsaQty40 = voOut.getUsdSltBsaQty40();
			rfScgPrc20     = voOut.getRfScgPrc20();
			rfScgPrc40     = voOut.getRfScgPrc40();
		}

		eventResponse.setETCData("usd_slt_bsa_qty_20",usdSltBsaQty20);
		eventResponse.setETCData("usd_slt_bsa_qty_40",usdSltBsaQty40);
		eventResponse.setETCData("rf_scg_prc_20",rfScgPrc20);
		eventResponse.setETCData("rf_scg_prc_40",rfScgPrc40);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0045 : Retrieve
	 * retrieving Adjust of Slot Hire
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAdjustSlotHireStlList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0045Event event = (FnsJoo0045Event) e;
		AdjustConditionVO adjustConditionVO = event.getAdjustConditionVO();
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		
		//2015.07.07 NYK Modify
		//OPR 추가에 따른 소스 코드 수정 : AdjustConditionVO.jo_stl_itm_cd=S/H,OPR, AdjustConditionVO.jo_mnu_nm=S/H,OPR
		List<AdjustSettlementVO> rtnList = new ArrayList<AdjustSettlementVO>();
		List<AdjustSettlementVO> list = command.searchAdjustSlotHireStlList(adjustConditionVO);
		if(list != null && list.size() > 0){
			for(AdjustSettlementVO vo : list){
				rtnList.add(vo);
			}
		}
		//ItemList Exist Check : OPR
		String addJoStlItmCd = adjustConditionVO.getAddJoStlItmCd();
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		//jooCodeParamVO.setSuperCd1("Y"); //auto cre flg = 'Y'
		JOOFindCodeAndCheckBC command1 = new JOOFindCodeAndCheckBCImpl();		
		List<JooCodeInfoVO> itemList = command1.searchStlItemCodeList(jooCodeParamVO);
		boolean isExistItem = false;
		for(JooCodeInfoVO codeVo : itemList){
			if(codeVo.getCode().equals(addJoStlItmCd)){
				isExistItem = true;
				break;
			}
		}
		
		//2015.07.07 NYK Modify Add OPR
		if(isExistItem && StringUtils.isNotEmpty(addJoStlItmCd)){
			adjustConditionVO.setJoStlItmCd(adjustConditionVO.getAddJoStlItmCd());
			adjustConditionVO.setJoMnuNm(adjustConditionVO.getAddJoMnuNm());
			
			List<AdjustSettlementVO> list2 = command.searchAdjustSlotHireStlList(adjustConditionVO);
			if(list2 != null && list2.size() > 0){
				for(AdjustSettlementVO vo : list2){
					rtnList.add(vo);
				}
			}
		}
		
		//List<AdjustSettlementVO> list = command.searchAdjustSlotHireStlList(vo);
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
		procSettlementVO.setAcctYrmon(adjustConditionVO.getAcctYrmon());
		procSettlementVO.setReDivrCd(adjustConditionVO.getReDivrCd());
		eventResponse.setRsVoList(rtnList);
		return eventResponse;
	}


	/**
	 * FNS_JOO_0045 : Open
	 * retrieving code data for combo setting
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0045(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		CodeUtil codeUtil = CodeUtil.getInstance();
		@SuppressWarnings("unchecked")
		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD01866", 0);
		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);

		eventResponse.setETCData("jo_crr_cd", crrCombo);
		eventResponse.setETCData("stl_jb_combo", stljbSheetList[0]);
		eventResponse.setETCData("stl_jb_comnm", stljbSheetList[1]);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0045 : Save
	 * saving Adjust data in S/H
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageAdjustSlotHireStl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0045Event event = (FnsJoo0045Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();

		try {
			begin();
			
			command1.manageTargetVVDForAdjustment(event.getAdjustSettlementVOS(), account);
			command.manageAdjustSlotHireStl(event.getAdjustSettlementVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0016 : Open
	 * retrieving data for combo setting
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0016(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		CodeUtil codeUtil = CodeUtil.getInstance();
		@SuppressWarnings("unchecked")
		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD01866", 0);
		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);

		eventResponse.setETCData("jo_crr_cd", crrCombo);
		eventResponse.setETCData("stl_jb_combo", stljbSheetList[0]);
		eventResponse.setETCData("stl_jb_comnm", stljbSheetList[1]);
		return eventResponse;
	}


	/**
	 * FNS_JOO_0016 : Retrieve
	 * retrieving combined data
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCombinedMonthlyClearanceList(Event e) throws EventException {
		FnsJoo0016Event event = (FnsJoo0016Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		CmbConditionVO cmbConditionVO = event.getCmbConditionVO();
		cmbConditionVO.setOfcCd(account.getOfc_cd());
		CombinedGrpVO grpVO = command.searchCombinedMonthlyClearanceList(cmbConditionVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(grpVO.getJooSettlementVOs());
		eventResponse.setRsVoList(grpVO.getCombinedVOs());
		return eventResponse;
	}

	/**
	 * FNS_JOO_0016 : Retrieve
	 * retrieving Rlane List
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCombinedRlaneList(Event e) throws EventException {
		FnsJoo0016Event event = (FnsJoo0016Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		CmbConditionVO cmbConditionVO = event.getCmbConditionVO();
		cmbConditionVO.setOfcCd(account.getOfc_cd());// Office별 Carrier-lane 권한때문에
		List<JooSettlementVO> list = command.searchCombinedRlaneList(cmbConditionVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0016 : Retrieve
	 * retrieving Adjusted data
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCombinedMonthlyClearanceByLaneList (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0016Event event = (FnsJoo0016Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		CmbConditionVO cmbConditionVO = event.getCmbConditionVO();
		cmbConditionVO.setOfcCd(account.getOfc_cd());
		List<CombinedVO> list = command.searchCombinedMonthlyClearanceByLaneList (cmbConditionVO);
		eventResponse.setRsVoList(list);
		return eventResponse;
	}


	/**
	 * FNS_JOO_0016 : Save
	 * handling Combine
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCombinedMonthlyClearance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0016Event event = (FnsJoo0016Event)e;
		JointOperationConsultationBC command  = new JointOperationConsultationBCImpl();
		CarrierSettlementProcessBC   command1 = new CarrierSettlementProcessBCImpl  ();

		try {
			begin();
			int stlCmbSeq = command.manageCombinedMonthlyClearance(event.getCmbConditionVO(), event.getCombinedVOS(), account);
			command1.manageCombinedMonthlyClearance(event.getCombinedVOS(), account);
			eventResponse.setETCData("stl_cmb_seq",stlCmbSeq+"");
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0016 : Delete
	 * canceling Combined
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeCombinedMonthlyClearance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0016Event event = (FnsJoo0016Event)e;
		JointOperationConsultationBC 	command  = new JointOperationConsultationBCImpl();
		CarrierSettlementProcessBC   	command1 = new CarrierSettlementProcessBCImpl  ();
		JOOFindCodeAndCheckBC   		command2 = new JOOFindCodeAndCheckBCImpl  ();

		try {
			begin();
			JooCodeParamVO paramVo = new JooCodeParamVO();
			paramVo.setAcctYrmon(event.getCmbConditionVO().getAcctYrmon());
			paramVo.setJoCrrCd(event.getCmbConditionVO().getJoCrrCd());
			paramVo.setStlCmbSeq(event.getCmbConditionVO().getStlCmbSeq());
			
			String csrNo = command2.searchCheckDBDAOCheckSlipByStlCmbSeq(paramVo);
			
			if(StringUtils.isNotEmpty(csrNo)){
				eventResponse.setETCData("del_flg", "F");
				eventResponse.setUserMessage("Unable to remove the data because it has a slip no ["+csrNo+"].");
				//throw new EventException("Unable to remove the data because it has a slip no ["+csrNo+"].");
			}else{	
				command .removeCombinedMonthlyClearance(event.getCmbConditionVO(), account);
				command1.removeCombinedMonthlyClearance(event.getCombinedVOS(), account);
				eventResponse.setETCData("del_flg", "S");
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0017 : Open
	 * retrieving code data for combo setting
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0017(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);
		CodeUtil codeUtil = CodeUtil.getInstance();
		
		//NYK Modify 2014.11.07
		/*
		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD01745", 0);
		String evidTp[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);
		*/
		
		JooCodeParamVO jooTaxCodeParamVO = new JooCodeParamVO();
		jooTaxCodeParamVO.setCode(JooConstants.KEY_TAX_TYPE_CODE);//AP TAX CODE
		List<JooCodeInfoVO> taxList = command.searchTaxTypeList(jooTaxCodeParamVO);
		
		//N사 2014.11.07 기준으로 AP Tax Free 만 사용함.
		List<JooCodeInfoVO> tmpTaxList = new ArrayList<JooCodeInfoVO>();
		for(JooCodeInfoVO codeVo : taxList){
			if(JooConstants.EVIDENCE_CLASS_F0.equals(codeVo.getCode())){
				tmpTaxList.add(codeVo);
			}
		}		
		String evidTp[] = StringUtil.split(BizComJooUtil.getCodeSelectString(tmpTaxList), BizComUtil.CODE_DELIMITTER);		

		@SuppressWarnings("unchecked")
		Collection<CodeInfo> codeList3 = codeUtil.getCodeSelect("CD01228", 0);
		String csrTp[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList3), BizComUtil.CODE_DELIMITTER);

		String locDateTime = command.searchLocalDateTime(account.getOfc_cd());

		eventResponse.setETCData("jo_crr_cd" , crrCombo);
		eventResponse.setETCData("evidTpCode", evidTp[0]);
		eventResponse.setETCData("evidTpName", evidTp[1]);
		eventResponse.setETCData("csrTpCode" , csrTp[0]);
		eventResponse.setETCData("csrTpName" , csrTp[1]);
		eventResponse.setETCData("localDate" , locDateTime);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0017 : Retrieve
	 * retrieving AP CSR
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAPConsultation(Event e) throws EventException {
		FnsJoo0017Event event = (FnsJoo0017Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		List<SlipProcessVO> list = command.searchAPConsultation(event.getSlipProcessVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		//AR_MSt_REV_VVD Check Add.
		String chkArMstRevVvd = "";
		if(null == list || list.size() == 0){
			chkArMstRevVvd = command.getCheckArMasterRevenueVvd(event.getSlipProcessVO());
		}
		eventResponse.setRsVoList(list);
		eventResponse.setETCData("check_vvd" , chkArMstRevVvd);//F : 존재하지 않음. S : 존재함.
		return eventResponse;
	}


	/**
	 * FNS_JOO_0017 : Save
	 * saving AP CSR
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createAPConsultation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0017Event event = (FnsJoo0017Event)e;

		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();

		try {
			begin();
			String csrNo = command.createAPConsultation(event.getSlipProcessVOS(), event.getJooTaxVOs(), event.getJooTaxDtlVOs(), account);
			eventResponse.setETCData("csr_no",csrNo);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	} 

	/**
	 * FNS_JOO_0017 : changing Eff.Date
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAPClosYn(Event e) throws EventException {
		FnsJoo0017Event event = (FnsJoo0017Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		SlipProcessVO slipProcessVO = command.searchCloseYn(event.getSlipProcessVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("clos_yn",slipProcessVO.getVvdCxlFlg());
		eventResponse.setETCData("eff_dt" ,slipProcessVO.getEffDt());
		return eventResponse;
	}

	/**
	 * FNS_JOO_0020 : changing Eff.Date
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchARClosYn(Event e) throws EventException {
		FnsJoo0020Event event = (FnsJoo0020Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		SlipProcessVO slipProcessVO = command.searchCloseYn(event.getSlipProcessVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("clos_yn",slipProcessVO.getVvdCxlFlg());
		eventResponse.setETCData("eff_dt" ,slipProcessVO.getEffDt());
		return eventResponse;
	}

	/**
	 * FNS_JOO_0020 : Open
	 * retrieving carrier information 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0020(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		String locDateTime = command.searchLocalDateTime(account.getOfc_cd());

		eventResponse.setETCData("jo_crr_cd" , crrCombo);
		eventResponse.setETCData("localDate" , locDateTime);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0020 : Retrieve
	 * retrieving AR CSR
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchARConsultation(Event e) throws EventException {
		FnsJoo0020Event event = (FnsJoo0020Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		List<SlipProcessVO> list = command.searchAPConsultation(event.getSlipProcessVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		//AR_MSt_REV_VVD Check Add.
		String chkArMstRevVvd = "";
		if(null == list || list.size() == 0){
			chkArMstRevVvd = command.getCheckArMasterRevenueVvd(event.getSlipProcessVO());
		}
		eventResponse.setRsVoList(list);
		eventResponse.setETCData("check_vvd" , chkArMstRevVvd);//F : 존재하지 않음. S : 존재함.
		return eventResponse;
	}

	/**
	 * FNS_JOO_0020 : Save
	 * saving AR CSR
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createARConsultation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0020Event event = (FnsJoo0020Event)e;

		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();

		String csrNo = "";
		try {
			begin();
			csrNo = command.createARConsultation(event.getSlipProcessVOS(), account);
			commit();
			log.debug("OPUS AR CSRNo" + csrNo);
			eventResponse.setETCData("csr_no",csrNo);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
     * FNS_JOO_0039 : Open <br>
     * retrieving carrier infomation in Monthly Clearance by Carrier & Lane.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse openFnsJoo0039(Event e) throws EventException {

        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        // Carrier 
        jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
        List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
        eventResponse.setRsVoList( list );
        return eventResponse;
    }
    /**
     * FNS_JOO_0019 :Open<br>
     * retrieving Carrier Code List<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse openFnsJoo0015(Event e) throws EventException {

        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        // Carrier 
        jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
        List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
        eventResponse.setRsVoList( list );
        return eventResponse;
    }
    /**
     * FNS_JOO_0015 : Retrieve<br>
     * retrieving carrier infomation in Monthly Clearance by Carrier & Lane.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchMonthlyClearanceList(Event e) throws EventException {

        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
        FnsJoo0015Event event = (FnsJoo0015Event)e;

        StlConditionVO stlConditionVO = event.getStlConditionVO();
        stlConditionVO.setOfcCd(   this.account.getOfc_cd() );

        List<SettlementVO> list = command.searchMonthlyClearanceList( stlConditionVO );
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);
        return eventResponse;
    }
    /**
     * FNS_JOO_0068 : Retrieve
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
	private EventResponse searchCsrDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0068Event event = (FnsJoo0068Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		
		CsrVO csrVO = event.getCsrVO();
		csrVO.setCreUsrId (account.getUsr_id());
		csrVO.setAuthOfcCd(account.getOfc_cd());
		List<CsrVO> list = command.searchCsrDetail(csrVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0068 : Reverse
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse reverseConsultation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsJoo0068Event event = (FnsJoo0068Event) e;
		JointOperationConsultationBC command  = new JointOperationConsultationBCImpl();
		CarrierSettlementProcessBC   command1 = new CarrierSettlementProcessBCImpl  ();
		try {
			begin();
			CsrVO[] csrVOs = event.getCsrVOS();
			//2010.03.22 SETTLEMENT CMB_CFM_FLG = 'N'으로 수정하는 것에서 SETTLEMENT COPY하는 것으로 변경됨
			List<JooStlCmbDtlVO> jooStlCmbDtlVOs = command.reverseConsultation(csrVOs[0], account);
			command1.createReverseSettlement (jooStlCmbDtlVOs, account);

			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage() );
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_JOO_0068 : Reject
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse rejectConsultation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsJoo0068Event event = (FnsJoo0068Event) e;
		JointOperationConsultationBC command  = new JointOperationConsultationBCImpl();
		//CarrierSettlementProcessBC   command1 = new CarrierSettlementProcessBCImpl  ();
		try {
			begin();
			CsrVO[] csrVOs = event.getCsrVOS();
			
			//기존 approval cancel bc를 콜한다.
			String ifNo = command.approvalConsultation(csrVOs[0], account);
			log.debug("rejectConsultation BackEndJobManager ifNo ["+ifNo+"]");
			
			//Combined, CSR, SLIP, TAX에 대한 UPDATE / DELTE
			//List<JooStlCmbDtlVO> jooStlCmbDtlVOs = command.rejectConsultation(csrVOs[0], account);

			//Settlement의 CMB_CFM_FLG를 N으로 UPDATE한다.
			//command1.createReverseSlip(jooStlCmbDtlVOs, account);
			
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage() );
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
    /**
     * FNS_JOO_0038:Open <br>
     * retrieving carrier information in Summary of Monthly Clearance Status by VVD<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse openFnsJoo0038(Event e) throws EventException {

        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        // Carrier 
        jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
        List<JooCodeInfoVO> carrlist = command.searchCarrierCodeList(jooCodeParamVO);
        List<JooCodeInfoVO> stlitmlist = command.searchSettlementItemCodeList(jooCodeParamVO);
        eventResponse.setRsVoList( carrlist   );
        eventResponse.setRsVoList( stlitmlist );
        return eventResponse;
    }
    /**
     * FNS_JOO_0049 : Open
     * D : [FnsJoo0049Event]<br>
     * retrieving Trd_cd<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse openFnsJoo0049(Event e) throws EventException {

        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        String ofcCd = this.account.getOfc_cd();

		//Office Code 
		String offCombo = "";
		if (OfficeCodeMgr.checkContainOfficeCode("000001","JOO",ofcCd)){
			List<JooCodeInfoVO> list1 = command.searchAuthOfficeList(jooCodeParamVO);
			offCombo = " ,|"+makeComboString(list1, 1);
		}else{
			offCombo = ofcCd+","+ofcCd;
		}

        // Trd_cd 
        //jooCodeParamVO.setOfcCd(  this.account.getOfc_cd() );
        //List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);
        
        List<JooCodeInfoVO> list = command.searchTradeCodeWithoutAuthorityList(jooCodeParamVO);
        eventResponse.setRsVoList( list  );
        eventResponse.setETCData("office", offCombo);
        return eventResponse;
    }
    /**
     * FNS_JOO_0050 : Open <br>
     *  retrieving Target Voyage vs Unsettled Status<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse openFnsJoo0050(Event e) throws EventException {

        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        String ofcCd = this.account.getOfc_cd();

		// Carrier 
        jooCodeParamVO.setOfcCd( ofcCd );
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
		String crrCombo = makeComboString(list, 1);

		// Trade 
		list = command.searchTradeCodeList(jooCodeParamVO);
		String trdCombo = makeComboString(list, 1);

		// Rlane 
		list = command.searchRlaneCodeList(jooCodeParamVO);
		String laneCombo = makeComboString(list, 1);

		// ABBR 
		list = command.searchStlItemCodeList(jooCodeParamVO);
		String abbrCombo = makeComboString(list, 1);

		//Office Code 
		String offCombo = "";
		if (OfficeCodeMgr.checkContainOfficeCode("000001","JOO",ofcCd)){
			list = command.searchAuthOfficeList(jooCodeParamVO);
			offCombo = " ,|"+makeComboString(list, 1);
		}else{
			offCombo = ofcCd+","+ofcCd;
		}

		eventResponse.setETCData("jo_crr_cd" , crrCombo);
		eventResponse.setETCData("trd_cd"    , trdCombo);
		eventResponse.setETCData("rlane_cd"  , laneCombo);
		eventResponse.setETCData("jo_stl_itm_cd", abbrCombo);
		eventResponse.setETCData("office", offCombo);
        return eventResponse;
    }
//    /**
//     * FNS_JOO_0040 :Retrieve<br>
//     *
//     * @throws EventException
//     * @return EventResponse
//     * @author 
//     */
//    private EventResponse searchSlotXchStatusListBySpaceLane(Event e) throws EventException {
//
//        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
//        FnsJoo0040Event event = (FnsJoo0040Event)e;
//        SlotXchLaneVO slotXchLaneVO = event.getSlotXchLaneVO();
//        slotXchLaneVO.setOfcCd( this.account.getOfc_cd() );
//        List<SlotXchLaneVO> list = command.searchSlotXchStatusListBySpaceLane( event.getSlotXchLaneVO()  );
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        eventResponse.setRsVoList(list);
//        return eventResponse;
//    }
//    /**
//     * FNS_JOO_0041 : Retrieve<br>
//     *
//     * @throws EventException
//     * @return EventResponse
//     * @author 
//     */
//    private EventResponse searchSlotXchStatusListBySpacePartner(Event e) throws EventException {
//        try{
//            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
//            FnsJoo0041Event event = (FnsJoo0041Event)e;
//
//            GeneralEventResponse eventResponse = new GeneralEventResponse();
//            SlotXchPartnerVO  slotXchPartnerVO   = event.getSlotXchPartnerVO();
//            slotXchPartnerVO.setOfcCd( this.account.getOfc_cd()  );
//            slotXchPartnerVO.setReDivrCd( "R" );
//            eventResponse.setRsVoList(command.searchSlotXchStatusListBySpacePartner(  slotXchPartnerVO ));
//            slotXchPartnerVO.setReDivrCd( "E" );
//            eventResponse.setRsVoList(command.searchSlotXchStatusListBySpacePartner(  slotXchPartnerVO   ));
//
//            return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//    }
    /**
     *  FNS_JOO_0060 : Open <br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private EventResponse openFnsJoo0060(Event e) throws EventException {
//        try{
//            FnsJoo0060Event event = (FnsJoo0060Event)e;
//
//            JOOFindCodeAndCheckBC    command  = new JOOFindCodeAndCheckBCImpl();
//            JointOperationLetterBC  command2  = new JointOperationLetterBCImpl();
//            GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
//
//            
//            jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
//            List<JooCodeInfoVO> carrlist   = command.searchCarrierCodeList(jooCodeParamVO);
//            List<TextNoVO> textNoList      = command2.searchMcsTextNo( event.getLetterVO() );
//
//
//            eventResponse.setRsVoList( carrlist   );
//            eventResponse.setRsVoList( textNoList );
//            return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//    }
    /**
     *  FNS_JOO_0062 : Open <br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private EventResponse openFnsJoo0062(Event e) throws EventException {
//        try{
//            FnsJoo0062Event event = (FnsJoo0062Event)e;
//
//            JOOFindCodeAndCheckBC    command  = new JOOFindCodeAndCheckBCImpl();
//            JointOperationLetterBC  command2  = new JointOperationLetterBCImpl();
//            GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
//
//            
//            jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
//            List<JooCodeInfoVO> carrlist   = command.searchCarrierCodeList(jooCodeParamVO);
//            List<TextNoVO> textNoList = command2.searchInvoiceTextNo(  event.getLetterVO() );
//            eventResponse.setRsVoList( carrlist   );
//            eventResponse.setRsVoList( textNoList );
//            return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//    }
    /**
     * FNS_JOO_0062 : Get
     * D : [FnsJoo0062Event]<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private EventResponse searchInvoiceLetter(Event e) throws EventException {
//        try{
//            JointOperationLetterBC command = new JointOperationLetterBCImpl();
//            FnsJoo0062Event event      = (FnsJoo0062Event) e;
//            GeneralEventResponse eventResponse = new GeneralEventResponse();
//            List<InvoiceCombinedVO> list     = command.searchInvoiceLetter( event.getLetterVO() );
//            List<McsLetterVO> carrlist = command.searchToCustList( event.getJocrrcd()  );
//            eventResponse.setRsVoList(list);
//            eventResponse.setRsVoList(carrlist);
//
//            return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//    }
    /**
     * FNS_JOO_0062 : Retrieve
     * D : [FnsJoo0062Event]<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private EventResponse searchInvoiceCombined(Event e) throws EventException {
//
//            JointOperationLetterBC command = new JointOperationLetterBCImpl();
//            FnsJoo0062Event event = (FnsJoo0062Event) e;
//            GeneralEventResponse eventResponse = new GeneralEventResponse();
//            List<InvoiceCombinedVO> list = command.searchInvoiceCombined(event.getInvoiceCombinedVO());
//            eventResponse.setRsVoList(list);
//            return eventResponse;
//
//    }

    /**
     * FNS_JOO_0062 : Send
     * D : [FnsJoo0062Event]<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private EventResponse sendInvoiceLetter(Event e) throws EventException {
//        try{
//            JointOperationLetterBC command = new JointOperationLetterBCImpl();
//            FnsJoo0062Event event = (FnsJoo0062Event) e;
//            GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//            begin();
//                LetterVO letterVO = event.getLetterVO();
//                letterVO.setUsrId( this.account.getUsr_id() );
//
//                command.sendInvoiceLetter( letterVO );
//                eventResponse.setCustomData(SubSystemConfigFactory.get("COM.MAIL.KEYS"), null);
//                eventResponse.setUserMessage(new ErrorHandler("JOO10006").getUserMessage());
//            commit();
//            return eventResponse;
//        } catch (EventException ex) {
//            this.rollback();
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        } catch (Exception ex) {
//            this.rollback();
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//
//    }
    /**
     * FNS_JOO_0062 : Save
     * D : [FnsJoo0062Event]<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private EventResponse createInvoiceLetter(Event e) throws EventException {
//        JointOperationLetterBC command = new JointOperationLetterBCImpl();
//        FnsJoo0062Event event = (FnsJoo0062Event) e;
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//        try {
//            begin();
//
//            LetterVO letterVo = command.manageInvoiceLetter (event.getLetterVO(), event.getLetterVOs(), this.account);
//            eventResponse.setETCData("jo_ltr_seq", letterVo.getJoLtrSeq());
//            eventResponse.setETCData("jo_ltr_no", letterVo.getJoLtrNo()  );
//
//            eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
//            commit();
//            return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            rollback();
//            throw ex;
//        } catch (Exception ex) {
//            rollback();
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//
//    }

    /**
     * FNS_JOO_0055 : Retrieve <br>
     * retrieving RDR Upload Inquiry<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author
     */
    private EventResponse searchLaneCdYn(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0054Event event54 =  null;
        FnsJoo0055Event event55 =  null;
        String lane_cd = "";
		if (e.getEventName().equalsIgnoreCase("FnsJoo0054Event")){
		    event54 = (FnsJoo0054Event)e;
		    lane_cd = event54.getTdrByLaneVO().getSlanCd();
        }
        if (e.getEventName().equalsIgnoreCase("FnsJoo0055Event")){
            event55 = (FnsJoo0055Event)e;
            lane_cd = event55.getRdrByLaneVO().getSlanCd();
        }
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		String vslSlanCd = null;
		try{
		    MdmVslSvcLaneVO mdmVslSvcLaneVO = new MdmVslSvcLaneVO();
		    mdmVslSvcLaneVO.setVslSlanCd( lane_cd );
		    mdmVslSvcLaneVO.setOfcCd(  this.account.getOfc_cd() );
			List<MdmVslSvcLaneVO> list = command.searchLaneCdYn (mdmVslSvcLaneVO);

			//eventResponse.setRsVoList(list);
			if(list.size()>0){
				vslSlanCd= list.get(0).getVslSlanCd();
			}else{
				vslSlanCd = "";
			}

			eventResponse.setETCData("vslSlanCd", vslSlanCd);


        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	}

    /**
     * FNS_JOO_0054 :  Retrieve <br>
     * retrieving TDR Cration Inquiry<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author
     */
    private EventResponse searchTDRCreateListByLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0054Event event = (FnsJoo0054Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		try{

			String fromDt = event.getTdrByLaneVO().getFromDt();
			fromDt = fromDt.substring(0, 4)+ fromDt.substring(5, 7)+ fromDt.substring(8, 10);

			String toDt = event.getTdrByLaneVO().getToDt();
			toDt = toDt.substring(0, 4)+ toDt.substring(5, 7)+ toDt.substring(8,10);

			String lane = event.getTdrByLaneVO().getSlanCd();

			List<TdrByLaneVO> list = command.searchTDRCreateListByLane (fromDt ,toDt ,lane);
			
			eventResponse.setRsVoList(list);

        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	}

    /**
     * FNS_JOO_0055: Retrieve  <br>
     * retrieving RDR Upload Inquiry<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author
     */
    private EventResponse searchRDRCreateListByLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0055Event event = (FnsJoo0055Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		try{

			String fromDt = event.getRdrByLaneVO().getFromDt();
			fromDt = fromDt.substring(0, 4)+ fromDt.substring(5, 7)+ fromDt.substring(8, 10);

			String toDt = event.getRdrByLaneVO().getToDt();
			toDt = toDt.substring(0, 4)+ toDt.substring(5, 7)+ toDt.substring(8,10);

			String lane = event.getRdrByLaneVO().getSlanCd();
			log.debug("fromDt : "+fromDt+"   toDt : "+toDt+" lane : "+lane);
			List<RdrByLaneVO> list = command.searchRDRCreateListByLane (fromDt ,toDt ,lane);
			
			eventResponse.setRsVoList(list);

        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	}

    /**
     * FNS_JOO_0029 : Open
     * retrieving Trade, Carrier, Lane Code Combo
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	@SuppressWarnings({ "rawtypes" })
	private EventResponse openFnsJoo0029(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		String exeYrmon = "";
		
		try{
			exeYrmon = DateTime.addMonths(DateTime.getFormatString("yyyyMMdd"), -1).substring(0,6);
			jooCodeParamVO.setSuperCd1(exeYrmon);
		}catch(Exception ex){
			throw new EventException(ex.toString());
		}

		JooCodeInfoVO jooCodeInfoVO = command.searchCheckEstmClz(jooCodeParamVO);

		EstmConditionVO estmConditionVO = new EstmConditionVO();

		estmConditionVO.setExeYrmon  (exeYrmon);
		estmConditionVO.setReDivrCd  ("");
		estmConditionVO.setRevYrmonFr("");
		estmConditionVO.setRevYrmonTo("");

		//Trade Code List 
		List<EstmConditionVO> list = command.searchTradeCodeListEstm(estmConditionVO);

		String trdCombo = makeEstmComboString(list, 0);

		//Rlane Code List 
		list = command.searchRlaneCodeListEstm(estmConditionVO);
		String laneCombo = makeEstmComboString(list, 1);

		//Carrier Code List 
		list = command.searchCarrierCodeListEstm(estmConditionVO);
		String crrCombo = makeEstmComboString(list, 2);

//		CodeUtil codeUtil = CodeUtil.getInstance();

//		// BSA Type - JOINT OPERATION, LEASE, ADDITIONAL, Over Used, 20FT, 40FT
//		Collection<CodeInfo> codeList = codeUtil.getCodeSelect("CD01866", 0);
//		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList), BizComUtil.CODE_DELIMITTER);

		// VVD Type - RV, PV, BV
//		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD00943", 0);
//		String vvdTpCd[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);

		//ItemList
		jooCodeParamVO.setSuperCd1("Y"); //auto cre flg = 'Y'
		jooCodeParamVO.setSuperCd2("");
		jooCodeParamVO.setCode    ("");
		jooCodeParamVO.setName    ("");
		
		List<JooCodeInfoVO> itemList = command.searchStlItemCodeList(jooCodeParamVO);
		StringBuilder sb = new StringBuilder();
		Iterator iterator = (Iterator) itemList.iterator();
		int iCnt = 0;
		while(iterator.hasNext()){
			JooCodeInfoVO itemVO = (JooCodeInfoVO)iterator.next();
			if(iCnt == 0){
				sb.append(itemVO.getCode()+","+itemVO.getName());
			}else{
				sb.append("|"+itemVO.getCode()+","+itemVO.getName());
			}
			iCnt++;
		}
				
		eventResponse.setETCData("EXE_YRMON" , exeYrmon);
		eventResponse.setETCData("jo_crr_cd" , crrCombo);
		eventResponse.setETCData("trd_cd"    , trdCombo);
		eventResponse.setETCData("rlane_cd"  , laneCombo);
//		eventResponse.setETCData("stl_jb_combo", stljbSheetList[0]);
//		eventResponse.setETCData("stl_jb_comnm", stljbSheetList[1]);
//		eventResponse.setETCData("estm_vvd_tp_cd", vvdTpCd[0]);
		eventResponse.setETCData("estm_clz_flg"  , jooCodeInfoVO.getCode());
		eventResponse.setETCData("jo_stl_item_cd"  , sb.toString());
		return eventResponse;
	}

    /**
     * FNS_JOO_0029 : Retrieve
     * retrieving Estimate Performance Creation<br>
     *
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse searchCond0029(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsJoo0029Event event = (FnsJoo0029Event)e;

		EstmConditionVO estmConditionVO = event.getEstmConditionVO();

		String estmCondFlg = estmConditionVO.getEstmCondFlg();

		List<EstmConditionVO> list = null;

		String estmClzFlg = "N";
		String trdCombo   = "";
		String laneCombo  = "";
		String crrCombo   = "";

		
		estmConditionVO.setRevYrmonFr("");
		estmConditionVO.setRevYrmonTo("");

		switch (Integer.parseInt(estmCondFlg)){
			
			case 1 :
				JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
				jooCodeParamVO.setSuperCd1(estmConditionVO.getExeYrmon());
				JooCodeInfoVO jooCodeInfoVO = command.searchCheckEstmClz(jooCodeParamVO);
				estmClzFlg = jooCodeInfoVO.getCode();
				
				list = command.searchTradeCodeListEstm(estmConditionVO);
				trdCombo = makeEstmComboString(list, 0);
				break;
			case 2 :
				//Trade Code List 
				list = command.searchTradeCodeListEstm(estmConditionVO);
				trdCombo = makeEstmComboString(list, 0);
				break;
			//trad변경된경우
			case 3 :
				//Rlane Code List 
				list = command.searchRlaneCodeListEstm(estmConditionVO);
				laneCombo = makeEstmComboString(list, 1);
				break;
			//lane변경된경우
			case 4 :
				//Carrier Code List 
				list = command.searchCarrierCodeListEstm(estmConditionVO);
				crrCombo = makeEstmComboString(list, 2);
				break;
		}

		eventResponse.setETCData("estm_clz_flg", estmClzFlg);
		eventResponse.setETCData("TRD_CD"      , trdCombo);
		eventResponse.setETCData("RLANE_CD"    , laneCombo);
		eventResponse.setETCData("JO_CRR_CD"   , crrCombo);
		return eventResponse;
	}


    /**
     * FNS_JOO_0074 : Open
     * retrieving Trade, Carrier, Lane Combo
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	@SuppressWarnings("rawtypes")
	private EventResponse openFnsJoo0074(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String exeYrmon = "";
		
		try{
			exeYrmon = DateTime.addMonths(DateTime.getFormatString("yyyyMMdd"), -1).substring(0,6);
		}catch(Exception ex){
			throw new EventException(ex.toString());
		}

		EstmConditionVO estmConditionVO = new EstmConditionVO();
		estmConditionVO.setExeYrmon(exeYrmon);

		//Revenue Month From~To
		List<EstmConditionVO> list = command.searchRevYrmonFrTo(estmConditionVO);

		String revYrmonFr = exeYrmon;
		String revYrmonTo = exeYrmon;

		if (!list.isEmpty()){
			if (list.get(0).getRevYrmonFr()!= null && !"".equals(list.get(0).getRevYrmonFr())){
				revYrmonFr = list.get(0).getRevYrmonFr();
			}

			if (list.get(0).getRevYrmonTo()!= null && !"".equals(list.get(0).getRevYrmonTo())){
				revYrmonTo = list.get(0).getRevYrmonTo();
			}
		}

		estmConditionVO.setRevYrmonFr(revYrmonFr);
		estmConditionVO.setRevYrmonTo(revYrmonTo);

		//Trade Code List 
		list = command.searchTradeCodeListEstm(estmConditionVO);

		String trdCombo = makeEstmComboString(list, 0);

		//Rlane Code List 
		list = command.searchRlaneCodeListEstm(estmConditionVO);
		String laneCombo = makeEstmComboString(list, 1);

		//Carrier Code List 
		list = command.searchCarrierCodeListEstm(estmConditionVO);
		String crrCombo = makeEstmComboString(list, 2);

		CodeUtil codeUtil = CodeUtil.getInstance();

		// BSA Type
		@SuppressWarnings("unchecked")
		Collection<CodeInfo> codeList = codeUtil.getCodeSelect("CD01866", 0);
		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList), BizComUtil.CODE_DELIMITTER);
		String bsaTypeCd[] = (stljbSheetList[0]).split("[|]");
		String bsaTypeNm[] = (stljbSheetList[1]).split("[|]");

		String code = "";
		StringBuilder bsaTypeCdTmp = new StringBuilder();
		StringBuilder bsaTypeNmTmp = new StringBuilder();
		for (int i=0; i<bsaTypeCd.length; i++){
			code = bsaTypeCd[i].substring(0,1);
			if ("1".equals(code)){
				bsaTypeCdTmp.append(bsaTypeCd[i]+"|");
				bsaTypeNmTmp.append(bsaTypeNm[i]+"|");
			}
		}

		String bsaTpCd = bsaTypeCdTmp.toString().substring(0, bsaTypeCdTmp.toString().length()-1);
		String bsaTpNm = bsaTypeNmTmp.toString().substring(0, bsaTypeNmTmp.toString().length()-1);
		
		//ItemList
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		jooCodeParamVO.setSuperCd1("Y"); //auto cre flg = 'Y'
		jooCodeParamVO.setSuperCd2("");
		jooCodeParamVO.setCode    ("");
		jooCodeParamVO.setName    ("");
		
		List<JooCodeInfoVO> itemList = command.searchStlItemCodeList(jooCodeParamVO);
		StringBuilder sb = new StringBuilder();
		Iterator iterator = (Iterator) itemList.iterator();
		int iCnt = 0;
		while(iterator.hasNext()){
			JooCodeInfoVO itemVO = (JooCodeInfoVO)iterator.next();
			if(iCnt == 0){
				sb.append(itemVO.getCode()+","+itemVO.getName());
			}else{
				sb.append("|"+itemVO.getCode()+","+itemVO.getName());
			}
			iCnt++;
		}

		eventResponse.setETCData("EXE_YRMON"   , exeYrmon);
		eventResponse.setETCData("REV_YRMON_FR", revYrmonFr);
		eventResponse.setETCData("REV_YRMON_TO", revYrmonTo);
		eventResponse.setETCData("TRD_CD"      , trdCombo);
		eventResponse.setETCData("RLANE_CD"    , laneCombo);
		eventResponse.setETCData("JO_CRR_CD"   , crrCombo);
		eventResponse.setETCData("STL_JB_COMBO", bsaTpCd);
		eventResponse.setETCData("STL_JB_COMNM", bsaTpNm);
		eventResponse.setETCData("jo_stl_item_cd"  , sb.toString());
		return eventResponse;
	}

	/**
	 * changing EstmConditionVO list to String
	 * @param List<EstmConditionVO> list
	 * @param int flg
	 * @return String
	 * @throws EventException
	 */
	private String makeEstmComboString(List<EstmConditionVO> list, int flg) throws EventException{
		String rtnVal = null;

		StringBuilder sb = new StringBuilder();

		@SuppressWarnings("rawtypes")
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
	 * FNS_JOO_0074 : Retrieve
	 * Estimate Performance Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEstmPerformanceList(Event e) throws EventException {
	    try{
    		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
    		FnsJoo0074Event event = (FnsJoo0074Event) e;

    		List<EstmActRsltVO> list = null;
    		list = command.searchEstmPerformanceList(event.getEstmConditionVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}


    /**
     * FNS_JOO_0074 : Retrieve
     * in case of changing condition
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse searchCond(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsJoo0074Event event = (FnsJoo0074Event)e;

		EstmConditionVO estmConditionVO = event.getEstmConditionVO();

		String estmCondFlg = estmConditionVO.getEstmCondFlg();

		List<EstmConditionVO> list = null;

		String revYrmonFr = "";
		String revYrmonTo = "";
		String trdCombo   = "";
		String laneCombo  = "";
		String crrCombo   = "";

		switch (Integer.parseInt(estmCondFlg)){
			
			case 1 :
				list = command.searchRevYrmonFrTo(estmConditionVO);

				list = command.searchTradeCodeListEstm(estmConditionVO);
				trdCombo = makeEstmComboString(list, 0);
				
				revYrmonFr = estmConditionVO.getExeYrmon();
				revYrmonTo = estmConditionVO.getExeYrmon();
				if (!list.isEmpty()){
					if (list.get(0).getRevYrmonFr()!= null && !"".equals(list.get(0).getRevYrmonFr())){
						revYrmonFr = list.get(0).getRevYrmonFr();
					}

					if (list.get(0).getRevYrmonTo()!= null && !"".equals(list.get(0).getRevYrmonTo())){
						revYrmonTo = list.get(0).getRevYrmonTo();
					}
				}
				//estmConditionVO.setRevYrmonFr(revYrmonFr);
				//estmConditionVO.setRevYrmonTo(revYrmonTo);
				
				break;
			case 2 :
				//Trade Code List 
				list = command.searchTradeCodeListEstm(estmConditionVO);
				trdCombo = makeEstmComboString(list, 0);
				break;
			//trad변경된경우
			case 3 :
				//Rlane Code List 
				list = command.searchRlaneCodeListEstm(estmConditionVO);
				laneCombo = makeEstmComboString(list, 1);
				break;
			//lane변경된경우
			case 4 :
				//Carrier Code List 
				list = command.searchCarrierCodeListEstm(estmConditionVO);
				crrCombo = makeEstmComboString(list, 2);
				break;
		}

		eventResponse.setETCData("REV_YRMON_FR", revYrmonFr);
		eventResponse.setETCData("REV_YRMON_TO", revYrmonTo);
		eventResponse.setETCData("TRD_CD"      , trdCombo);
		eventResponse.setETCData("RLANE_CD"    , laneCombo);
		eventResponse.setETCData("JO_CRR_CD"   , crrCombo);
		return eventResponse;
	}

    /**
     * FNS_JOO_0056 : Open
     * D : [FnsJoo0056Event]<br>
     * retrieving Region<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse openFnsJoo0056(Event e) throws EventException {
        try{
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

            //FnsJoo0056Event event = (FnsJoo0056Event)e;
            //RdrLoadVO rdrLoadVO   = event.getRdrLoadVO();
            //jooCodeParamVO.setSuperCd1( rdrLoadVO.getSuperCd1() );
            
    		List<JooCodeInfoVO> regionList = command.searchRegionList(jooCodeParamVO);
            eventResponse.setRsVoList( regionList  );
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw  ex ;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0056: Retrieve
     * D : [FnsJoo0056Event]<br>
     * retrieving RDR Load DownLoad by Lane<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchRDRDownloadListByLane(Event e) throws EventException {
        try{
            // PDTO(Data Transfer Object including Parameters)
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0056Event event = (FnsJoo0056Event)e;
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            List<RdrLoadVO> list = command.searchRDRDownloadListByLane (  event.getRdrLoadVO()  );
            eventResponse.setRsVoList(list);
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw  ex ;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0056: SAVE
     * D : [FnsJoo0056Event]<br>
     * saving JOO_RDR_VVD_CRR_RMK<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse manageRDRVVDCrrRmk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	FnsJoo0056Event event = (FnsJoo0056Event)e;
        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		try{
			begin();
			command.manageRDRVVDCrrRmk(event.getRdrLoadVOS(), account);
			commit();
		}catch(EventException ex){
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
     * FNS_JOO_0053 : Retrieve
     * retrieving Slip of VVD
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchVVDOfNotExistRevMonList(Event e) throws EventException {
        try{
            // PDTO(Data Transfer Object including Parameters)
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0053Event event = (FnsJoo0053Event)e;
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            List<ManualStlVvdVO> list = command.searchVVDOfNotExistRevMonList(event.getProcSettlementVO());
            eventResponse.setRsVoList(list);
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw  ex ;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }
    /**
     * FNS_JOO_0057 : Open
     * D : [FnsJoo0057Event]<br>
     * retrieving [RDR Download by VVD]<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse openFnsJoo0057(Event e) throws EventException {
        try{
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

            FnsJoo0057Event event = (FnsJoo0057Event)e;
            TdrLoadVO tdrLoadVO   = event.getTdrLoadVO();
            jooCodeParamVO.setSuperCd1( tdrLoadVO.getSuperCd1() );

            List<JooCodeInfoVO> list = command.searchComCodeList(jooCodeParamVO);
            eventResponse.setRsVoList( list  );
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0057: Retrieve
     * D : [FnsJoo0057Event]<br>
     * retrieving RDR Load DownLoad by VVD<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchTDRDownloadListByLane(Event e) throws EventException {
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0057Event event = (FnsJoo0057Event)e;
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            List<TdrLoadVO> list = command.searchTDRDownloadListByLane (  event.getTdrLoadVO()  );
            eventResponse.setRsVoList(list);
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }
    /**
     * FNS_JOO_0059 : Open
     * D : [FnsJoo0059Event]<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private EventResponse openFnsJoo0059(Event e) throws EventException {
//        try{
//            JointOperationLetterBC command = new JointOperationLetterBCImpl();
//            GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//            /***************************************************************************
//             * Address, n3rd_stmt_ctnt,Signature
//             *
//             ***************************************************************************/
//            JooLtrTmpltVO jooLtrTmpltVO = null;
//            FnsJoo0059Event event = (FnsJoo0059Event) e;
//            jooLtrTmpltVO = event.getJooLtrTmpltVO();
//            String ofcCd = jooLtrTmpltVO.getOfcCd() == null ? "" : jooLtrTmpltVO.getOfcCd(); // account.getOfc_cd();
//            JooLtrTmpltVO jooLtrTmpltVOReturn = command.searchTempalteAddress(ofcCd);
//            if(jooLtrTmpltVOReturn != null){
//                Map<String, String> mapVO = jooLtrTmpltVOReturn.getColumnValues();
//                eventResponse.setETCData(mapVO);
//            }
//            /***************************************************************************
//             * User Nm List
//             *
//             ***************************************************************************/
//            LetterVO letterVO = new LetterVO();
//            letterVO.setUsrId( this.account.getUsr_id()  );
//            letterVO.setOfcCd( ofcCd   );
//            letterVO.setJoLtrTpCd(jooLtrTmpltVO.getJoLtrTpCd() );
//            List<LetterVO> usrnmlist  = command.searchUserNm(letterVO);
//            eventResponse.setRsVoList( usrnmlist  );
//
//            /***************************************************************************
//             * User Nm Of TextNo  List
//             *
//             ***************************************************************************/
//            String joLtrTpCd = jooLtrTmpltVO.getJoLtrTpCd();
//                   ofcCd     = jooLtrTmpltVO.getOfcCd();
//            String userId    = this.account.getUsr_id();
//
//            List<JoTmpltNoVO> textNoList = command.searchTempalteTextNoList(joLtrTpCd,ofcCd, userId);
//            eventResponse.setRsVoList(textNoList);
//
//
//            return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw  ex ;
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//    }
    /**
     * FNS_JOO_0061 : Open
     * D : [FnsJoo0061Event]<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private EventResponse openFnsJoo0061(Event e) throws EventException {
//        try{
//            JointOperationLetterBC command = new JointOperationLetterBCImpl();
//            GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//            /***************************************************************************
//             * Address, n3rd_stmt_ctnt,Signature
//             *
//             ***************************************************************************/
//            JooLtrTmpltVO jooLtrTmpltVO = null;
//            FnsJoo0061Event event = (FnsJoo0061Event) e;
//            jooLtrTmpltVO = event.getJooLtrTmpltVO();
//            String ofcCd = jooLtrTmpltVO.getOfcCd() == null ? "" : jooLtrTmpltVO.getOfcCd(); // account.getOfc_cd();
//            JooLtrTmpltVO jooLtrTmpltVOReturn = command.searchTempalteAddress(ofcCd);
//            if(jooLtrTmpltVOReturn != null){
//                Map<String, String> mapVO = jooLtrTmpltVOReturn.getColumnValues();
//                eventResponse.setETCData(mapVO);
//            }
//            /***************************************************************************
//             * User Nm List
//             *
//             ***************************************************************************/
//            LetterVO letterVO = new LetterVO();
//            letterVO.setUsrId( this.account.getUsr_id()  );
//            letterVO.setOfcCd( ofcCd   );
//            letterVO.setJoLtrTpCd(jooLtrTmpltVO.getJoLtrTpCd() );
//            List<LetterVO> usrnmlist  = command.searchUserNm(letterVO);
//            eventResponse.setRsVoList( usrnmlist  );
//
//            /***************************************************************************
//             * User Nm Of TextNo  List
//             *
//             ***************************************************************************/
//            String joLtrTpCd = jooLtrTmpltVO.getJoLtrTpCd();
//                   ofcCd     = jooLtrTmpltVO.getOfcCd();
//            String userId    = this.account.getUsr_id();
//
//            List<JoTmpltNoVO> textNoList = command.searchTempalteTextNoList(joLtrTpCd,ofcCd, userId);
//            eventResponse.setRsVoList(textNoList);
//
//
//            return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw  ex ;
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//    }
    /**
     * FNS_JOO_0075 : Open
     * D : [FnsJoo0075Event]<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private EventResponse openFnsJoo0075(Event e) throws EventException {
//        try{
//            JointOperationLetterBC command = new JointOperationLetterBCImpl();
//            GeneralEventResponse eventResponse = new GeneralEventResponse();
//            FnsJoo0075Event event = (FnsJoo0075Event)e;
//
//            LetterVO  vo = event.getLetterVO();
//            vo.setOfcCd(this.account.getOfc_cd());
//            vo.setUsrId( this.account.getUsr_id()  );
//            List<LetterVO> offcdlist  = command.searchOfficeCd(  vo );
//            List<LetterVO> usrnmlist  = command.searchUserNm(vo);
//
//            eventResponse.setRsVoList( offcdlist  );
//            eventResponse.setRsVoList( usrnmlist  );
//
//            return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw ex;
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//    }
    /**
     * FNS_JOO_0075 : SEARCH02
     * D : [FnsJoo0075Event]<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private EventResponse searchUserNm(Event e) throws EventException {
//        try{
//
//            JointOperationLetterBC command = new JointOperationLetterBCImpl();
//            GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//            FnsJoo0075Event event = (FnsJoo0075Event)e;
//            List<LetterVO> usrnmlist = command.searchUserNm( event.getLetterVO() );
//
//            eventResponse.setRsVoList( usrnmlist  );
//
//            return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw  ex ;
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//
//    }
    /**
     * FNS_JOO_0075 : SEARCH03
     * D : [FnsJoo0075Event]<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private EventResponse searchTempalteSeqList(Event e)
//            throws EventException {
//        try{
//            GeneralEventResponse eventResponse = new GeneralEventResponse();
//            FnsJoo0075Event event = (FnsJoo0075Event)e;
//            JointOperationLetterBC command = new JointOperationLetterBCImpl();
//            LetterVO  vo  = event.getLetterVO();
//
//            List<LetterVO> list = command.searchTempalteSeqList(JSPUtil.getNull(vo.getJoLtrTpCd(), ""),
//                                                                    JSPUtil.getNull(vo.getOfcCd(), ""),
//                                                                    JSPUtil.getNull(vo.getUsrId(), ""));
//
//            eventResponse.setRsVoList( list );
//            return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw  ex ;
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//    }
    /**
     * FNS_JOO_0075 : SEARCH02
     * D : [FnsJoo0075Event]<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private EventResponse searchSignNBank(Event e) throws EventException {
//       // try{
//            JointOperationLetterBC command = new JointOperationLetterBCImpl();
//            GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//            FnsJoo0075Event event = (FnsJoo0075Event)e;
//            List<LetterVO> list   = command.searchSignNBank(event.getLetterVO());
//
//            eventResponse.setRsVoList( list  );
//
//            return eventResponse;
//
//    }
    /**
     * FNS_JOO_0075 : SAVE
     * D : [FnsJoo0075Event]<br>
     *
     * @throws EventException
     * @return EventResponse
     */
//    private   EventResponse manageSignNBank(Event e) throws EventException {
//
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        FnsJoo0075Event event = (FnsJoo0075Event) e;
//        JointOperationLetterBC command = new JointOperationLetterBCImpl();
//        try {
//            begin();
//            LetterVO vo  = event.getLetterVO();
//            vo.setCreUsrId( account.getUsr_id() );
//            vo.setOfcCd   ( account.getOfc_cd() );
//            LetterVO rstVo = command.addSignNBank(  vo );
//            commit();
//
//
//            
//            List<LetterVO> usrnmlist = command.searchUserNm( event.getLetterVO() );
//            eventResponse.setRsVoList( usrnmlist  );
//            
//            List<LetterVO> textnolist = command.searchTempalteSeqList(JSPUtil.getNull(vo.getJoLtrTpCd(), ""),
//                                                                      JSPUtil.getNull(vo.getOfcCd()    , ""),
//                                                                      JSPUtil.getNull(vo.getCreUsrId() , ""));
//            eventResponse.setRsVoList( textnolist  );
//            eventResponse.setETCData("NEW_JO_TMPLT_NO", rstVo.getJoTmpltNo() );
//            eventResponse.setETCData("NEW_JO_LTR_TMPLT_SEQ", rstVo.getJoLtrTmpltSeq() );
//
//            eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
//            return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            rollback();
//            throw  ex ;
//        } catch (Exception ex) {
//            rollback();
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//
//    }
    /**
     * FNS_JOO_0075 : REMOVE
     * D : [FnsJoo0075Event]<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
//    private   EventResponse removeSignNBank(Event e) throws EventException {
//            try{
//                GeneralEventResponse eventResponse = new GeneralEventResponse();
//                FnsJoo0075Event event = (FnsJoo0075Event) e;
//                JointOperationLetterBC command = new JointOperationLetterBCImpl();
//
//                begin();
//                LetterVO vo  = event.getLetterVO();
//                command.removeSignNBank(  vo );
//                commit();
//
//
//                
//                List<LetterVO> usrnmlist = command.searchUserNm( event.getLetterVO() );
//                eventResponse.setRsVoList( usrnmlist  );
//    //            
//                List<LetterVO> seqlist = command.searchTempalteSeqList(JSPUtil.getNull(vo.getJoLtrTpCd(), ""),
//                                                                          JSPUtil.getNull(vo.getOfcCd()    , ""),
//                                                                          JSPUtil.getNull(vo.getCreUsrId() , ""));
//                eventResponse.setRsVoList( seqlist  );
//
//                eventResponse.setUserMessage(new ErrorHandler("JOO10005").getUserMessage());
//
//                 return eventResponse;
//            } catch (EventException ex) {
//                log.error("err " + ex.toString(), ex);
//                rollback();
//                throw new EventException(ex.getMessage(), ex);
//            } catch (Exception ex) {
//                rollback();
//                log.error("err " + ex.toString(), ex);
//                throw new EventException(ex.getMessage(), ex);
//            }
//    }
	/**
	 * FNS_JOO_0046 : Open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse openFnsJoo0046(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
//
//		// Carrier 
//		jooCodeParamVO.setOfcCd(account.getOfc_cd());
//		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
//
//		String crrCombo = makeComboString(list, 1);
//
//		eventResponse.setETCData("jo_crr_cd", crrCombo);
//		return eventResponse;
//	}

	/**
	 * FNS_JOO_0046 : Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse searchAdjustOusListForRDR(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//	    try{
//    		FnsJoo0046Event event = (FnsJoo0046Event) e;
//    		AdjustConditionVO vo = event.getAdjustConditionVO();
//    		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
//    		List<AdjustOusRDRVO> list = command.searchAdjustOusListForRDR(vo);
//    		GeneralEventResponse eventResponse = new GeneralEventResponse();
//    		eventResponse.setRsVoList(list);
//    		return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw  ex ;
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//	}

//	/**
//	 * FNS_JOO_0011 : MULTI
//	 * @param ProcSettlementVO procSettlementVO
//	 * @return SettlementRFVO
//	 * @throws EventException
//	 */
//	private SettlementRFVO setSettlementRFVOUsingProcSettlementVO(ProcSettlementVO procSettlementVO) throws EventException {
//		SettlementRFVO settlementRFVO = new SettlementRFVO();
//		try{
//			settlementRFVO.setIbflag        (procSettlementVO.getIbflag        ());
//			settlementRFVO.setVslCd         (procSettlementVO.getVslCd         ());
//			settlementRFVO.setSkdVoyNo      (procSettlementVO.getSkdVoyNo      ());
//			settlementRFVO.setSkdDirCd      (procSettlementVO.getSkdDirCd      ());
//			settlementRFVO.setRevDirCd      (procSettlementVO.getRevDirCd      ());
//			settlementRFVO.setStlBzcPortCd  (procSettlementVO.getStlBzcPortCd  ());
//			settlementRFVO.setEtaDt         (procSettlementVO.getEtaDt         ());
//			settlementRFVO.setUcBssPortCd   (procSettlementVO.getUcBssPortCd   ());
//			settlementRFVO.setRfScgStlTpCd  (procSettlementVO.getRfScgStlTpCd  ());
//			settlementRFVO.setIocCd         (procSettlementVO.getIocCd         ());
//			settlementRFVO.setScontiCd      (procSettlementVO.getScontiCd      ());
//			settlementRFVO.setFmPortCd      (procSettlementVO.getFmPortCd      ());
//			settlementRFVO.setToPortCd      (procSettlementVO.getToPortCd      ());
//			settlementRFVO.setLoclCurrCd    (procSettlementVO.getLoclCurrCd    ());
//			settlementRFVO.setAcctYrmon     (procSettlementVO.getAcctYrmon     ());
//			settlementRFVO.setStlVvdSeq     (procSettlementVO.getStlVvdSeq     ());
//			settlementRFVO.setTrdCd         (procSettlementVO.getTrdCd         ());
//			settlementRFVO.setJoCrrCd       (procSettlementVO.getJoCrrCd       ());
//			settlementRFVO.setRlaneCd       (procSettlementVO.getRlaneCd       ());
//			settlementRFVO.setReDivrCd      (procSettlementVO.getReDivrCd      ());
//			settlementRFVO.setJoStlItmCd    (procSettlementVO.getJoStlItmCd    ());
//			settlementRFVO.setJoMnuNm       (procSettlementVO.getJoMnuNm       ());
//			settlementRFVO.setUcBssPortEtdDt(procSettlementVO.getUcBssPortEtdDt());
//		}catch(Exception ex){
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//		}
//		return settlementRFVO;
//	}
//    /**
//     * FNS_JOO_0040 : Open
//     * @param Event e
//     * @return EventResponse
//     * @throws EventException
//     */
//    private EventResponse openFnsJoo0040(Event e) throws EventException {
//
//        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
//        jooCodeParamVO.setOfcCd(  this.account.getOfc_cd() );
//        List<JooCodeInfoVO> trdlist = command.searchTradeCodeList(jooCodeParamVO);
//
//        jooCodeParamVO.setSuperCd1( "CD00593" );
//        List<JooCodeInfoVO> dirlist = command.searchComCodeList(jooCodeParamVO);
//
//        eventResponse.setRsVoList( trdlist  );
//        eventResponse.setRsVoList( dirlist  );
//        return eventResponse;
//    }
//    /**
//     * FNS_JOO_0041 : Open
//     * @param Event e
//     * @return EventResponse
//     * @throws EventException
//     */
//    private EventResponse openFnsJoo0041(Event e) throws EventException {
//
//        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
//        jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
//        List<JooCodeInfoVO> carrierlist = command.searchCarrierCodeList(jooCodeParamVO);
//
//        jooCodeParamVO.setSuperCd1( "CD00593" );
//        List<JooCodeInfoVO> dirlist = command.searchComCodeList(jooCodeParamVO);
//
//        eventResponse.setRsVoList( carrierlist  );
//        eventResponse.setRsVoList( dirlist  );
//        return eventResponse;
//    }

    /**
     * FNS_JOO_0029 : retrieving BackEndJob status
     * @param Event e
     * @return EventResponse
     * @throws BackEndJobException
     */
	private EventResponse searchAccrualBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		String key = (String)e.getAttribute("key");
		String status = command.searchBakEndJobStatus(key);
		eventResponse.setETCData("jb_sts_flg", status);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0029 : retrieving Create BackEndJob result
     * @param Event e
     * @return EventResponse
	 * @throws BackEndJobException
	 */
	private EventResponse searchAccrualBackEndJobResult(Event e) throws EventException, BackEndJobException {
		//String key = (String)e.getAttribute("key");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo0029Event event = (FnsJoo0029Event) e;
		//eventResponse.setRsVoList((List<EstmActRsltVO>)BackEndJobResult.loadFromFile(key));
		//[2015.03.09]재조회를 한다.
		List<EstmActRsltVO> list = null;
		//By VVD, By Month 별로 나누어야 함....
		SettlementConditionVO vo = event.getSettlementConditionVO();
		vo.setCreFlg(JooConstants.KEY_CRE_FLG_BACKEND);
		
		list = command.searchJointOperationAccrualList(vo);
		eventResponse.setRsVoList(list);
		
		//if ("1".equals(event.getSettlementConditionVO().getPageNo())){
			EstmActRsltVO estmActRsltVO = command.searchJointOperationAccrualTotal(event.getSettlementConditionVO());
			eventResponse.setETCData("estm_amt", estmActRsltVO.getEstmAmt());
			eventResponse.setETCData("act_amt" , estmActRsltVO.getActAmt ());
			eventResponse.setETCData("accl_amt", estmActRsltVO.getAcclAmt());
			eventResponse.setETCData("tot_cnt" , estmActRsltVO.getDiffAmt());
		//}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0007, FNS_JOO_0009, FNS_JOO_0010, FNS_JOO_0011, FNS_JOO_0012, FNS_JOO_0013, FNS_JOO_0014 : VVD(9 digits) change
	 * @param ProcSettlementVO procSettlementVO
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRevDirList(ProcSettlementVO procSettlementVO) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchRevDirList(procSettlementVO);

		if (list.isEmpty()){
			eventResponse.setETCData("ERR_CD", "E");
		}else{
			eventResponse.setETCData("ERR_CD", "N");
		}

		StringBuilder comboList = new StringBuilder();

		for (int i=0; i < list.size(); i++){
			if (i == list.size()-1){
				comboList.append(list.get(i).getRevDirCd());
			}else{
				comboList.append(list.get(i).getRevDirCd()+"|");
			}
		}

		eventResponse.setETCData("REV_DIR_LIST", comboList.toString());

		return eventResponse;
	}

	/**
	 * FNS_JOO_0009 : RGN change
	 * retrieve Used Slot Teu and WGT at change of Region
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUsedSlotInfo(Event e) throws EventException {
		FnsJoo0009Event event = (FnsJoo0009Event) e;

		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchUsedSlotInfo(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String fmPortCd     = "";
		String usdSltBsaQty = "";
		String usdSltWgt    = "";
		
		String fnlOwnBsaQty = "";
		String fnlBsaWgt    = "";

		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			ProcSettlementVO voOut = list.get(0);
			if(null != voOut){
				fmPortCd     = voOut.getFmPortCd();
				usdSltBsaQty = voOut.getUsdSltBsaQty();
				usdSltWgt    = voOut.getUsdSltWgt();
				fnlOwnBsaQty = voOut.getFnlOwnBsaQty();
				fnlBsaWgt    = voOut.getFnlBsaWgt();
			}
		}
		eventResponse.setETCData("dep_port_cd"     , fmPortCd);
		eventResponse.setETCData("usd_slt_bsa_qty", usdSltBsaQty);
		eventResponse.setETCData("usd_slt_wgt"    , usdSltWgt);
		eventResponse.setETCData("fnl_own_bsa_qty", fnlOwnBsaQty);
		eventResponse.setETCData("fnl_bsa_wgt"    , fnlBsaWgt);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : I/O Change
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRfIOChange(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			FnsJoo0011Event event = (FnsJoo0011Event) e;

			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
			List<SettlementRFVO> list = command.searchRfIOChange(event.getProcSettlementVO());

			StringBuilder ioc        = new StringBuilder();
			StringBuilder rfScgPrc20 = new StringBuilder();
			StringBuilder rfScgPrc40 = new StringBuilder();

			if (list.isEmpty()) {
				eventResponse.setETCData("CHECKVVD", "E");
			} else {
				eventResponse.setETCData("CHECKVVD", "N");

				SettlementRFVO voOut = null;
				for (int i=0; i < list.size(); i++){
					voOut = list.get(i);

					if (i == list.size()-1){
						ioc.append       (voOut.getIocCd     ());
						rfScgPrc20.append(voOut.getRfScgPrc20());
						rfScgPrc40.append(voOut.getRfScgPrc40());
					}else{
						ioc.append       (voOut.getIocCd     ()+"|");
						rfScgPrc20.append(voOut.getRfScgPrc20()+"|");
						rfScgPrc40.append(voOut.getRfScgPrc40()+"|");
					}
				}

			}
			eventResponse.setETCData("ioc_cd"       , ioc.toString());
			eventResponse.setETCData("rf_scg_prc_20", rfScgPrc20.toString());
			eventResponse.setETCData("rf_scg_prc_40", rfScgPrc40.toString());
		} catch (EventException ex){
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : RGN Change
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRfRgnChange(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			FnsJoo0011Event event = (FnsJoo0011Event) e;

			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
			List<SettlementRFVO> list = command.searchRfRgnChange(event.getProcSettlementVO());

			StringBuilder fmPortCd = new StringBuilder();
			StringBuilder toPortCd = new StringBuilder();
			StringBuilder usdSltBsaQty20 = new StringBuilder();
			StringBuilder usdSltBsaQty40 = new StringBuilder();

			if (list.isEmpty()) {
				eventResponse.setETCData("CHECKVVD", "E");
			} else {
				eventResponse.setETCData("CHECKVVD", "N");

				SettlementRFVO voOut = null;
				for (int i=0; i < list.size(); i++){
					voOut = list.get(i);

					if (i == list.size()-1){
						fmPortCd.append(voOut.getFmPortCd());
						toPortCd.append(voOut.getToPortCd());
						usdSltBsaQty20.append(voOut.getUsdSltBsaQty20());
						usdSltBsaQty40.append(voOut.getUsdSltBsaQty40());
					}else{
						fmPortCd.append(voOut.getFmPortCd()+"|");
						toPortCd.append(voOut.getToPortCd()+"|");
						usdSltBsaQty20.append(voOut.getUsdSltBsaQty20()+"|");
						usdSltBsaQty40.append(voOut.getUsdSltBsaQty40()+"|");
					}
				}
			}
			eventResponse.setETCData("fm_port_cd", fmPortCd.toString());
			eventResponse.setETCData("to_port_cd", toPortCd.toString());
			eventResponse.setETCData("usd_slt_bsa_qty_20", usdSltBsaQty20.toString());
			eventResponse.setETCData("usd_slt_bsa_qty_40", usdSltBsaQty40.toString());
		} catch (EventException ex){
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * FNS_JOO_0015 : Retrieve<br>
     * retrieving StlCmbSeq List of Monthly Clearance<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchMonthlyStlCmbSeqList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
	        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
	        FnsJoo0015Event event = (FnsJoo0015Event)e;
	        StlConditionVO stlConditionVO = event.getStlConditionVO();
	        stlConditionVO.setOfcCd(   this.account.getOfc_cd() );
	        List<SettlementVO> list = command.searchMonthlyStlCmbSeqList( stlConditionVO );
	        eventResponse.setRsVoList(list);
    	} catch (EventException ex) {
    		throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
    	}
        return eventResponse;
    }
//    /**
//     * FNS_JOO_0076 : Retrieve<br>
//     *
//     * @throws EventException
//     * @return EventResponse
//     * @author 
//     */
//    private EventResponse searchARDisabledVVD(Event e) throws EventException {
//
//        JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
//        FnsJoo0076Event event = (FnsJoo0076Event)e;
//
//        List<ArDisabledVVDVO> list = command.searchARDisabledVVD( event.getArDisabledVVDVO() );
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        eventResponse.setRsVoList(list);
//        return eventResponse;
//    }
//    /**
//     * FNS_JOO_0077 : Retrieve<br>
//     *
//     * @throws EventException
//     * @return EventResponse
//     * @author 
//     */
//    private EventResponse searchARDataInquiry(Event e) throws EventException {
//
//        JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
//        FnsJoo0077Event event = (FnsJoo0077Event)e;
//
//        List<ArDataInqVO> list = command.searchARDataInquiry( event.getArDataInqVO() );
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        eventResponse.setRsVoList(list);
//        return eventResponse;
//    }


    /**
     * FNS_JOO_0078 : Retrieve
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
//	private EventResponse searchApIfErrList(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		FnsJoo0078Event event = (FnsJoo0078Event) e;
//		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
//		
//		List<ApIfErrVO> list = command.searchApIfErrList(event.getCsrVO());
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		eventResponse.setRsVoList(list);
//		return eventResponse;
//	}

//	/**
//	 * FNS_JOO_0078 : Reject
//	 * @param Event e
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	private EventResponse rejectConsultation(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		FnsJoo0078Event event = (FnsJoo0078Event) e;
//		JointOperationConsultationBC command  = new JointOperationConsultationBCImpl();
//		CarrierSettlementProcessBC   command1 = new CarrierSettlementProcessBCImpl  ();
//		try {
//			begin();
//			CsrVO[] csrVOs = event.getCsrVOS();
//			//Combined, CSR, SLIP, TAX에 대한 UPDATE / DELTE
//			List<JooStlCmbDtlVO> jooStlCmbDtlVOs = command.rejectConsultation(csrVOs[0], account);
//
//			.
//			command1.createReverseSlip(jooStlCmbDtlVOs, account);
//			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage() );
//			commit();
//		} catch (EventException ex) {
//			rollback();
//			throw ex;
//		} catch (Exception ex) {
//			rollback();
//			throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;
//	}


//    /**
//     * FNS_JOO_0077 : Open
//     * @param Event e
//     * @return EventResponse
//     * @throws EventException
//     */
//    private EventResponse openFnsJoo0077(Event e) throws EventException {
//        // PDTO(Data Transfer Object including Parameters)
//        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
//
//        List<JooCodeInfoVO> carrlist = command.searchCarrierCodeListByTradeAndRlane(jooCodeParamVO);
//        eventResponse.setRsVoList( carrlist );
//
//        List<JooCodeInfoVO> officelist = command.searchOfcCdSlip(jooCodeParamVO);
//        eventResponse.setRsVoList( officelist );
//        return eventResponse;
//    }


    /**
     * FNS_JOO_0080 : Open
     * setting CarrierCode and Office Code
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
	private EventResponse openFnsJoo0080(Event e) throws EventException {
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();

		String ofcCd = account.getOfc_cd();
		String ofcCombo = "";

		if (OfficeCodeMgr.checkContainOfficeCode("000001","JOO",ofcCd)){
			SlipConditionVO vo = new SlipConditionVO();
			vo.setGubun("0");
			vo.setFrDt(JSPUtil.getKST("yyyyMMdd"));
			vo.setToDt(JSPUtil.getKST("yyyyMMdd"));

			List<SlipConditionVO> list = command.searchStlOfcList(vo);

			if (list.isEmpty()) {
				ofcCombo = ofcCd + "," + ofcCd;
			} else {
				StringBuilder sb = new StringBuilder();

				@SuppressWarnings("rawtypes")
				Iterator iterator = (Iterator) list.iterator();

				sb.append("All, |");
				while (iterator.hasNext()) {
					SlipConditionVO slipConditionVO = (SlipConditionVO) iterator
							.next();
					sb.append(slipConditionVO.getSlpOfcCd() + ","
							+ slipConditionVO.getSlpOfcCd() + "|");
				}
				ofcCombo = sb.toString();

				if (ofcCombo.length() > 0)
					ofcCombo = ofcCombo.substring(0, ofcCombo.length() - 1);
			}
		} else {
			ofcCombo = ofcCd + "," + ofcCd;
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("ofc_list", ofcCombo);
		eventResponse.setETCData("ofc_cd", ofcCd);
		return eventResponse;
	}

	/**
	 * retrieving Office Code List
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlOfcList(Event e) throws EventException {
		FnsJoo0080Event event = (FnsJoo0080Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();

		SlipConditionVO vo = event.getSlipConditionVO();

		List<SlipConditionVO> list = command.searchStlOfcList(vo);

		String ofcCd = account.getOfc_cd();
		String ofcCombo = "";

		if (list.isEmpty()) {
			ofcCombo = ofcCd + "," + ofcCd;
		} else {
			StringBuilder sb = new StringBuilder();

			@SuppressWarnings("rawtypes")
			Iterator iterator = (Iterator) list.iterator();

			sb.append("All, |");
			while (iterator.hasNext()) {
				SlipConditionVO slipConditionVO = (SlipConditionVO) iterator
						.next();
				sb.append(slipConditionVO.getSlpOfcCd() + ","
						+ slipConditionVO.getSlpOfcCd() + "|");
			}
			ofcCombo = sb.toString();

			if (ofcCombo.length() > 0)
				ofcCombo = ofcCombo.substring(0, ofcCombo.length() - 1);
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("ofc_list", ofcCombo);
		return eventResponse;
	}

	/**
     * FNS_JOO_0080 : Retrieve
     * retrieving lost combined data 
     * @param Event e
     * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLostCombinedDataList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0080Event event = (FnsJoo0080Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		
		List<LostCombinedDataVO> list = command.searchLostCombinedDataList(event.getSlipConditionVO());

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
    /**
     * FNS_JOO_0081 :Retrieve<br>
     * retrieving Discharge Port Qty by Loading Port<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchDischageForLoading(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            FnsJoo0081Event event = (FnsJoo0081Event)e;
            StringBuffer sql = new StringBuffer();

            LoadingQtyVO loadingQtyVO = event.getLoadingQtyVO() ;
            loadingQtyVO.setOfcCd( this.account.getOfc_cd() );

            DBRowSet dbRowSetHead  = command.searchDischageForLoadingHeader( loadingQtyVO );

            dbRowSetHead.next();
            for(int i=1;i<=dbRowSetHead.getRowCount(); i++ ){

                sql.append(",      '"+dbRowSetHead.getString("POL_CD")+"' POD"+i+"                                                                                                                                                                                                                                                                                              \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '2', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) AS  POD"+i+"_20_QTY                                                                                       \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '4', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, 2, 1), 1 ) AS POD"+i+"_40_QTY     \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '5', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) )), '9', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, "+loadingQtyVO.getRatehc()+", 1), 1 ) AS POD"+i+"_HC_QTY     \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '7', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, "+loadingQtyVO.getRate45()+", 1), 1 ) AS POD"+i+"_45_QTY     \n");
                
//                sql.append(",      '"+dbRowSetHead.getString("POL_CD")+"' POD"+i+"                                                                                                                                                                                                                                                                                              \n");
//                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '2', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) AS  POD"+i+"_20_QTY                                                                                       \n");
//                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '4', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, 2, 1), 1 ) AS POD"+i+"_40_QTY     \n");
//                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '5', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, "+loadingQtyVO.getRatehc()+", 1), 1 ) AS POD"+i+"_HC_QTY     \n");
//                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '7', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, "+loadingQtyVO.getRate45()+", 1), 1 ) AS POD"+i+"_45_QTY     \n");

                dbRowSetHead.next();
            }
            loadingQtyVO.setHeaderSql( sql.toString() );
            DBRowSet dbRowSet      = command.searchDischageForLoading( loadingQtyVO );


            dbRowSetHead.beforeFirst();
            eventResponse.setRsVo(dbRowSetHead);
            eventResponse.setRsVo(dbRowSet);


        } catch (EventException ex) {
            throw ex;
        } catch ( Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * FNS_JOO_0081 :Excel DownLoad<br>
     * retrieving Discharge Port Qty by Loading Port<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchDischageForLoadingExcel(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            FnsJoo0081Event event = (FnsJoo0081Event)e;
            StringBuffer sql = new StringBuffer();

            LoadingQtyVO loadingQtyVO = event.getLoadingQtyVO() ;
            loadingQtyVO.setOfcCd( this.account.getOfc_cd() );

            DBRowSet dbRowSetHead  = command.searchDischageForLoadingHeader( loadingQtyVO );

            dbRowSetHead.next();
            for(int i=1;i<=dbRowSetHead.getRowCount(); i++ ){
            	sql.append(",      '"+dbRowSetHead.getString("POL_CD")+"' POD"+i+"                                                                                                                                                                                                                                                                                              \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '2', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) AS  POD"+i+"_20_QTY                                                                                       \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '4', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, 2, 1), 1 ) AS POD"+i+"_40_QTY     \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '5', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) )), '9', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, "+loadingQtyVO.getRatehc()+", 1), 1 ) AS POD"+i+"_HC_QTY     \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '7', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, "+loadingQtyVO.getRate45()+", 1), 1 ) AS POD"+i+"_45_QTY     \n");


//            	sql.append(",      '"+dbRowSetHead.getString("POL_CD")+"' POD"+i+"                                                                                                                                                                                                                                                                                              \n");
//                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '2', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) AS  POD"+i+"_20_QTY                                                                                       \n");
//                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '4', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, 2, 1), 1 ) AS POD"+i+"_40_QTY     \n");
//                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '5', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, "+loadingQtyVO.getRatehc()+", 1), 1 ) AS POD"+i+"_HC_QTY     \n");
//                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '7', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, "+loadingQtyVO.getRate45()+", 1), 1 ) AS POD"+i+"_45_QTY     \n");


                dbRowSetHead.next();
            }
            loadingQtyVO.setHeaderSql( sql.toString() );
            DBRowSet dbRowSet      = command.searchDischageForLoading( loadingQtyVO );


            dbRowSetHead.beforeFirst();
            eventResponse.setRsVo(dbRowSetHead);
            eventResponse.setRsVo(dbRowSet);

        } catch (EventException ex) {
            throw ex;
        } catch ( Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;

    }

    /**
     * FNS_JOO_0017, FNS_JOO_0020 : retrieving BackEndJob status
     * @param Event e
     * @return EventResponse
     * @throws BackEndJobException
     */
	private EventResponse searchConsultationBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		String key = (String)e.getAttribute("key");
		String status = command.searchBakEndJobStatus(key);
		eventResponse.setETCData("jb_sts_flg", status); 
		return eventResponse;
	}

	/**
	 * returning closing status
	 * @param ProcSettlementVO procSettlementVO
	 * @return String
	 * @throws EventException
	 */
	private String searchCloseYn(ProcSettlementVO procSettlementVO) throws EventException{
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		jooCodeParamVO.setAcctYrmon(procSettlementVO.getAcctYrmon());
		jooCodeParamVO.setCode     (procSettlementVO.getReDivrCd());
		jooCodeParamVO.setOfcCd    (account.getOfc_cd());
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<JooCodeInfoVO> lst = command.searchCloseYn(jooCodeParamVO);
		String clzYn = "O";
		if (lst.isEmpty()){
			clzYn = "C";
		}else{
			clzYn = lst.get(0).getCode();
		}
		return clzYn;
	}

	/**
     * FNS_JOO_0007, FNS_JOO_0009, FNS_JOO_0010, FNS_JOO_0011, FNS_JOO_0012, FNS_JOO_0013, FNS_JOO_0014, FNS_JOO_0045 : returning closing status
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
	private EventResponse searchCloseYn(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		ProcSettlementVO procSettlementVO = null;

		if (e instanceof FnsJoo0007Event) {
			procSettlementVO = ((FnsJoo0007Event)e).getProcSettlementVO();
		}else if (e instanceof FnsJoo0009Event) {
			procSettlementVO = ((FnsJoo0009Event)e).getProcSettlementVO();
//		}else if (e instanceof FnsJoo0010Event) {
//			procSettlementVO = ((FnsJoo0010Event)e).getProcSettlementVO();
		}else if (e instanceof FnsJoo0011Event) {
			procSettlementVO = ((FnsJoo0011Event)e).getProcSettlementVO();
		}else if (e instanceof FnsJoo0012Event) {
			procSettlementVO = ((FnsJoo0012Event)e).getProcSettlementVO();
//		}else if (e instanceof FnsJoo0013Event) {
//			procSettlementVO = ((FnsJoo0013Event)e).getProcSettlementVO();
//		}else if (e instanceof FnsJoo0014Event) {
//			procSettlementVO = ((FnsJoo0014Event)e).getProcSettlementVO();
		}else if (e instanceof FnsJoo0045Event) {
			procSettlementVO = new ProcSettlementVO();
			AdjustConditionVO vo = ((FnsJoo0045Event)e).getAdjustConditionVO();
			procSettlementVO.setAcctYrmon(vo.getAcctYrmon());
			procSettlementVO.setReDivrCd (vo.getReDivrCd ());
		}

		String clzYn = "O";
		if(null != procSettlementVO){
			jooCodeParamVO.setAcctYrmon(procSettlementVO.getAcctYrmon());
			jooCodeParamVO.setCode     (procSettlementVO.getReDivrCd());
			jooCodeParamVO.setOfcCd    (account.getOfc_cd());
			JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
			List<JooCodeInfoVO> lst = command.searchCloseYn(jooCodeParamVO);
			
			if (lst.isEmpty()){
				clzYn = "C";
			}else{
				clzYn = lst.get(0).getCode();
			}
		}
		eventResponse.setETCData("clz_yn", clzYn);
		
		return eventResponse;
	}

	/**
	 * FNS_JOO_0012 : in case of changing BSA_TYPE
	 * BSA Type Validation Check
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBsaTypeValidationCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0012Event event = (FnsJoo0012Event)e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		// PDTO(Data Transfer Object including Parameters)
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<ProcSettlementVO> list = command.searchBsaTypeValidationCheck(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		if (list.isEmpty()) {
			eventResponse.setETCData("CHECK_BSA_TYPE", "E");
		} else {
			eventResponse.setETCData("CHECK_BSA_TYPE", "N");
		}

		return eventResponse;
	}
	/**
	 * FNS_JOO_0036 : Save
	 * saving Remark
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSummaryOfMcsListByCarrier(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0036Event event = (FnsJoo0036Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		try {
			begin();
			
			command.manageSummaryOfMcsListByCarrier(event.getMcsStatusVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0050 : Save
	 * saving Remark in Target VVD vs Unsettled Status
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageTgtUnstlStsRmk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0050Event event = (FnsJoo0050Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		try {
			begin();
			StlStatusVO[] stlStatusVOs = event.getStlStatusVOs();
			command.manageJooTgtUnstlStsRmk(stlStatusVOs, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	


	/**
	 * FNS_JOO_0084 : Retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCntrForSettlementBackupReportData (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			FnsJoo0084Event event = (FnsJoo0084Event)e;

			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
			List<CntrSettlementBackupReportVO > list = command.searchCntrForSettlementBackupReportData(event.getCntrSettlementBackupReportVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
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
	 * FNS_JOO_0084 : Excel Backend Job<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCntrForSettlementBackupReportDataBackEndJob (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			FnsJoo0084Event event = (FnsJoo0084Event)e;

			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
			log.debug("\nSearchCntrForSettlementBackupReportDataBackEndJob start =================================================.");
			String key = command.searchCntrForSettlementBackupReportDataBackEndJob(event.getCntrSettlementBackupReportVO(), account);			
			log.debug("\nSearchCntrForSettlementBackupReportDataBackEndJob KEY ["+key+"].");
			log.debug("\nSearchCntrForSettlementBackupReportDataBackEndJob e n d =================================================.");
			eventResponse.setETCData("KEY", key);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	

	private EventResponse backEndJobResult(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		FnsJoo0084Event event =(FnsJoo0084Event) e;
		String keys = event.getKey();
		String[] arrKey = StringUtils.split(keys, ",");
		String strResult = "";
		try {
			
			if(arrKey.length > 0){
				for(String sKey : arrKey){			
					BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
					DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
					while (rowSet.next()) {
						if ("2".equals(rowSet.getString("JB_STS_FLG"))) {
							// BackEndJob 
							strResult = "PROCESSING";
							break;
						} else if("3".equals(rowSet.getString("JB_STS_FLG"))) {
							// success
							// Data Transmitted successufully!      
							eventResponse.setUserMessage("Data Retrieved Successfully !");  //Data Retrieved Successfully !
							strResult = "SUCCESS";
							break;
						} else if("4".equals(rowSet.getString("JB_STS_FLG"))) { 
							if (!"".equals(rowSet.getString("JB_USR_ERR_MSG"))) {
								eventResponse.setUserMessage(rowSet.getString("JB_USR_ERR_MSG"));
							} else {
								eventResponse.setUserMessage("Has been failed to retrieve data.");  //Has been failed to retrieve data.
							}
							strResult = "FAIL";
							break;
						}
					}
				}
			}else{
				strResult = "FAIL";
			}
			eventResponse.setETCData("jb_sts_flg", strResult);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary by Carrier Back End Job"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * FNS_JOO_0084 구분에 따른 데이타 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchCntrForSettlementBackupReportDataFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0084Event event = (FnsJoo0084Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		try {
			
			List<CntrSettlementBackupReportVO> list = (List<CntrSettlementBackupReportVO>)command.searchCntrReportBackEndJobDataFile(event.getKey());
			//프레임워크 공통(com.clt.framework.core.controller.DownloadViewAdapter)을 사용 하였으나, 다운로드시 경고 문구가 나오는 문제로 adapter를 만들어 사용함(http://support.microsoft.com/kb/948615/ko)
			event.getCntrSettlementBackupReportVO().setGubun(JooConstants.EXCEL_TP_CD_CNTRVVD);
			eventResponse.setCustomData("param", event.getCntrSettlementBackupReportVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}		
	
		return eventResponse;
	}
	
	/**
	 * FNS_JOO_0084 : Standard Format Excel Backend Job<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCntrStandardFormatReportBackEndJob (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			FnsJoo0084Event event = (FnsJoo0084Event)e;
			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
			JOOFindCodeAndCheckBC command1 = new JOOFindCodeAndCheckBCImpl();
			log.debug("\nsearchCntrStandardFormatReportBackEndJob start =================================================.");
			
			CntrConditionVO conditionVo = event.getCntrConditionVO();
			
			JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
			jooCodeParamVO.setCode(conditionVo.getVslCd()+conditionVo.getVoyNo());
			
		    List<JooCodeInfoVO> list = command1.searchVslSlanCdInfoByVvd(jooCodeParamVO);
		    if(list != null && list.size() > 0){
		    	conditionVo.setVslSlanCd(list.get(0).getCode());
		    	conditionVo.setVslSlanNm(list.get(0).getName());
		    }
			
			String key = command.searchCntrStandardFormatReportBackEndJob(conditionVo, event.getCntrStandardFormatPreVOs(), event.getCntrStandardFormatSumVOs(), account);			
			log.debug("\nsearchCntrStandardFormatReportBackEndJob KEY ["+key+"].");
			log.debug("\nsearchCntrStandardFormatReportBackEndJob e n d =================================================.");
			eventResponse.setETCData("KEY", key);
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
	 * 조회 이벤트 처리<br>
	 * FNS_JOO_0084 Standard Format Excel Backend Job Excel file down.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchCntrStandardFormatReportDataFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0084Event event = (FnsJoo0084Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		try {
			
			Map<String, Object> map = (Map<String, Object>)command.searchCntrReportBackEndJobDataFile(event.getKey());
			//프레임워크 공통(com.clt.framework.core.controller.DownloadViewAdapter)을 사용 하였으나, 다운로드시 경고 문구가 나오는 문제로 adapter를 만들어 사용함(http://support.microsoft.com/kb/948615/ko)
			
			CntrConditionVO condVo = (CntrConditionVO)map.get("condition");
			log.debug("\nsearchCntrStandardFormatReportDataFile ConditionVO["+condVo.toString()+"]");
			
			CntrConversionConditionVO conditionVO = new CntrConversionConditionVO();
			conditionVO.setSlanCd(condVo.getSlanCd());
			
			//Laden
			conditionVO.setDftTpszGroup(JooConstants.KEY_COM_PPT_DEFAULT_LADEN);
			List<CntrConversionAndOptionVO> ladenList = command.searchDefaultCntrConverion(conditionVO);
			
			//Empty
			conditionVO.setDftTpszGroup(JooConstants.KEY_COM_PPT_DEFAULT_EMPTY);
			List<CntrConversionAndOptionVO> emptyList = command.searchDefaultCntrConverion(conditionVO);
			
			//Option
			List<CntrConversionAndOptionVO> optionList = command.searchDefaultCntrOptionList(conditionVO);
			
			eventResponse.setCustomData("condition"		, (CntrConditionVO)map.get("condition"));
			eventResponse.setCustomData("preList"		, (List<CntrStandardFormatVO>)map.get("preList"));
			eventResponse.setCustomData("sumList"		, (List<CntrStandardFormatVO>)map.get("sumList"));
			eventResponse.setCustomData("ladenTeuList"	, ladenList);
			eventResponse.setCustomData("emptyTeuList"	, emptyList);
			eventResponse.setCustomData("optionList"	, optionList);
			eventResponse.setCustomData("fileName"		, "STANDARD_FORMAT.xls");
			eventResponse.setCustomData("isZip"			, true);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}		
	
		return eventResponse;
	}	

	/**
	 * FNS_JOO_0084 : Previous Voyage and Last Port<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPreviousVoyageAndLastPortInfo (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			FnsJoo0084Event event = (FnsJoo0084Event)e;

			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
			log.debug("\nSearchPreviousVoyageAndLastPortInfo start =================================================.");
			
			List<CntrPreviousVvdPortVO > list = command.searchCntrPreviousVvdPortInfo(event.getCntrConditionVO());
			
			String pre_vsl_cd = "";
			String pre_voy_no = "";
			String pre_dir_cd = "";
			String lst_clpt_ind_seq = "";
			String lst_port = "";
			
			if (null != list &&  list.size() > 0 ) {
				pre_vsl_cd 			= list.get(0).getVslCd();
				pre_voy_no 			= list.get(0).getSkdVoyNo();
				pre_dir_cd 			= list.get(0).getSkdDirCd();
				lst_clpt_ind_seq 	= list.get(0).getClptIndSeq();
				lst_port 			= list.get(0).getVpsPortCd();
			}
			log.debug("\nSearchPreviousVoyageAndLastPortInfo e n d =================================================.");
			eventResponse.setETCData("pre_vsl_cd", pre_vsl_cd);
			eventResponse.setETCData("pre_voy_no", pre_voy_no);
			eventResponse.setETCData("pre_dir_cd", pre_dir_cd);
			eventResponse.setETCData("lst_clpt_ind_seq", lst_clpt_ind_seq);
			eventResponse.setETCData("lst_port", lst_port);
			
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
	 * FNS_JOO_0084 : Standard format Retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCntrStandardFormatReportData (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			FnsJoo0084Event event = (FnsJoo0084Event)e;

			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
			

			
			CntrConversionConditionVO conditionVO = new CntrConversionConditionVO();
			conditionVO.setPptCd(JooConstants.KEY_COM_PPT_DEFAULT_TPSZ);
			
			//Laden
			conditionVO.setDftTpszGroup(JooConstants.KEY_COM_PPT_DEFAULT_LADEN);
			List<CntrConversionAndOptionVO> ladenList = command.searchCntrConverionDefaultTpszList(conditionVO);
			
			//Empty
			conditionVO.setDftTpszGroup(JooConstants.KEY_COM_PPT_DEFAULT_EMPTY);
			List<CntrConversionAndOptionVO> emptyList = command.searchCntrConverionDefaultTpszList(conditionVO);
			
			String ladenTpsz = this.getDefaultTpszItem(ladenList);
			String emptyTpsz = this.getDefaultTpszItem(emptyList);
			/*
			JOOFindCodeAndCheckBC command1 = new JOOFindCodeAndCheckBCImpl();
			
			//JOO_COM_PPT Laden/Empty TpSz 코드를 조회한다.
			JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
			jooCodeParamVO.setCode(JooConstants.KEY_COM_PPT_TPSZ);
			
			//Laden
			List<JooComCodeVO> ladenList = command1.searchJooComCodeByLadenList(jooCodeParamVO);
			//Empty
			List<JooComCodeVO> emptyList = command1.searchJooComCodeByEmptyList(jooCodeParamVO);
			
			StringBuilder ladenSb = new StringBuilder();
			StringBuilder emptySb = new StringBuilder();

			if(null != ladenList && ladenList.size() > 0){
				@SuppressWarnings("rawtypes")
				Iterator it = (Iterator) ladenList.iterator();
				int iCnt = 0;
				while(it.hasNext()){
					JooComCodeVO vo = (JooComCodeVO)it.next();
					if(iCnt == 0){
						ladenSb.append(vo.getAttrCtnt2()); // TPSZ Code
					}else{
						ladenSb.append("|"+vo.getAttrCtnt2()); // TPSZ Code
					}
					iCnt++;
				}				
			}
			if(null != emptyList && emptyList.size() > 0){
				@SuppressWarnings("rawtypes")
				Iterator it1 = (Iterator) emptyList.iterator();
				int iCnt = 0;
				while(it1.hasNext()){
					JooComCodeVO vo = (JooComCodeVO)it1.next();
					if(iCnt == 0){
						emptySb.append(vo.getAttrCtnt4()); // TPSZ Code
					}else{
						emptySb.append("|"+vo.getAttrCtnt4()); // TPSZ Code
					}
					iCnt++;
				}				
			}*/				
				
			//Container typesize를 | 로 묶인 데이타로 넘긴다.
			event.getCntrConditionVO().setLadenTpszDatas(ladenTpsz);
			event.getCntrConditionVO().setEmptyTpszDatas(emptyTpsz);
			
			//ROB from Previous Voyage
			List<CntrStandardFormatVO > preList = command.searchCntrStandardFormatPreviousVoyageReportData(event.getCntrConditionVO());
			
			//Operation Summary Report
			List<CntrStandardFormatVO > summaryList = command.searchCntrStandardFormatReportData(event.getCntrConditionVO());
			
			//ROB to next voyage
			//List<CntrStandardFormatVO > nextList = command.searchCntrStandardFormatNextVoyageReportData(event.getCntrConditionVO());
			
			//위에서 조회된 데이타를 담는다.			
			eventResponse.setRsVoList(preList);
			eventResponse.setRsVoList(summaryList);
			//eventResponse.setRsVoList(nextList);
			
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
	 * FNS_JOO_0084 : Standard format Retrieve BackEndJob<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCntrStandardFormatReportDataBackEndJob (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			FnsJoo0084Event event = (FnsJoo0084Event)e;

			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
			

			
			CntrConversionConditionVO conditionVO = new CntrConversionConditionVO();
			conditionVO.setPptCd(JooConstants.KEY_COM_PPT_DEFAULT_TPSZ);
			
			//Laden
			conditionVO.setDftTpszGroup(JooConstants.KEY_COM_PPT_DEFAULT_LADEN);
			List<CntrConversionAndOptionVO> ladenList = command.searchCntrConverionDefaultTpszList(conditionVO);
			
			//Empty
			conditionVO.setDftTpszGroup(JooConstants.KEY_COM_PPT_DEFAULT_EMPTY);
			List<CntrConversionAndOptionVO> emptyList = command.searchCntrConverionDefaultTpszList(conditionVO);
			
			String ladenTpsz = this.getDefaultTpszItem(ladenList);
			String emptyTpsz = this.getDefaultTpszItem(emptyList);			
				
			//Container typesize를 | 로 묶인 데이타로 넘긴다.
			event.getCntrConditionVO().setLadenTpszDatas(ladenTpsz);
			event.getCntrConditionVO().setEmptyTpszDatas(emptyTpsz);
			
			
			log.debug("\n searchCntrStandardFormatReportDataBackEndJob start =================================================.");
			StringBuffer sb = new StringBuffer();
			String key = "";
			
			//ROB from Previous Voyage Backendjob
			key = command.searchCntrStandardFormatPreviousVoyageReportDataBackEndJob(event.getCntrConditionVO(), account);
			log.debug("\n searchCntrStandardFormatPreviousVoyageReportDataBackEndJob KEY ["+key+"].");
			
			sb.append(key).append(",");
			
			//Operation Summary Report Backendjob
			key = command.searchCntrStandardFormatReportDataBackEndJob(event.getCntrConditionVO(), account);
			log.debug("\n searchCntrStandardFormatReportDataBackEndJob KEY ["+key+"].");
			
			sb.append(key);
			
			log.debug("\n searchCntrStandardFormatReportDataBackEndJob e n d =================================================.");
			eventResponse.setETCData("KEY", sb.toString());
			
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
	 * 조회 이벤트 처리<br>
	 * FNS_JOO_0084 구분에 따른 데이타 조회합니다.<br>
	 * ROB from Previous Voyage , Operation Summary Report Back End Job 결과 조회.
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchCntrStandardFormatReportDataBackEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0084Event event = (FnsJoo0084Event)e;

		try {
			//ROB from Previous Voyage , Operation Summary Report Back End Job의 결과를 조회한다.
			//2개의 Key가 들어 오게 된다 순차적으로 Previous, Summary 순임. ex)20150901121212,20150901121213
			String keys = event.getKey();
			String[] arrKey = StringUtils.split(keys, ",");
			if(arrKey.length > 0){
				for(String sKey : arrKey){
					//List<CntrStandardFormatVO > list = (List<CntrStandardFormatVO >) BackEndJobResult.loadFromFile(sKey);
					eventResponse.setRsVoList((List<CntrStandardFormatVO >) BackEndJobResult.loadFromFile(sKey));
				}
			}
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}		
	
		return eventResponse;
	}
	
	/**
	 * FNS_JOO_0084  open
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0084 (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		/*
		JOOFindCodeAndCheckBC command1 = new JOOFindCodeAndCheckBCImpl();
		
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		jooCodeParamVO.setCode(JooConstants.KEY_COM_PPT_TPSZ);
		
		//Laden
		List<JooComCodeVO> ladenList = command1.searchJooComCodeByLadenList(jooCodeParamVO);
		//Empty
		List<JooComCodeVO> emptyList = command1.searchJooComCodeByEmptyList(jooCodeParamVO);

		StringBuilder ladenSb = new StringBuilder();
		StringBuilder emptySb = new StringBuilder();
		
		if(null != ladenList && ladenList.size() > 0){
			@SuppressWarnings("rawtypes")
			Iterator it = (Iterator) ladenList.iterator();
			int iCnt = 0;
			while(it.hasNext()){
				JooComCodeVO vo = (JooComCodeVO)it.next();
				if(iCnt == 0){
					ladenSb.append(vo.getAttrCtnt2()); // TPSZ Code
				}else{
					ladenSb.append("|"+vo.getAttrCtnt2()); // TPSZ Code
				}
				iCnt++;
			}				
		}
		if(null != emptyList && emptyList.size() > 0){
			@SuppressWarnings("rawtypes")
			Iterator it1 = (Iterator) emptyList.iterator();
			int iCnt = 0;
			while(it1.hasNext()){
				JooComCodeVO vo = (JooComCodeVO)it1.next();
				if(iCnt == 0){
					emptySb.append(vo.getAttrCtnt4()); // TPSZ Code
				}else{
					emptySb.append("|"+vo.getAttrCtnt4()); // TPSZ Code
				}
				iCnt++;
			}				
		}*/
		
		CntrConversionConditionVO conditionVO = new CntrConversionConditionVO();
		conditionVO.setPptCd(JooConstants.KEY_COM_PPT_DEFAULT_TPSZ);
		
		//Laden
		conditionVO.setDftTpszGroup(JooConstants.KEY_COM_PPT_DEFAULT_LADEN);
		List<CntrConversionAndOptionVO> ladenList = command.searchCntrConverionDefaultTpszList(conditionVO);
		
		//Empty
		conditionVO.setDftTpszGroup(JooConstants.KEY_COM_PPT_DEFAULT_EMPTY);
		List<CntrConversionAndOptionVO> emptyList = command.searchCntrConverionDefaultTpszList(conditionVO);
		
		String ladenTpsz = this.getDefaultTpszItem(ladenList);
		String emptyTpsz = this.getDefaultTpszItem(emptyList);

		//Container typesize를 | 로 묶인 데이타로 넘긴다.
		eventResponse.setETCData("ladenTpSzNm",ladenTpsz);
		eventResponse.setETCData("emptyTpSzNm",emptyTpsz);
		
		return eventResponse;
	}

	
	/**
	 * FNS_JOO_0084
	 * Standard Format Sheet Title 재귀 호출.
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchStandardFormatSheetTitle (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		/*
		JOOFindCodeAndCheckBC command1 = new JOOFindCodeAndCheckBCImpl();
		
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		jooCodeParamVO.setCode(JooConstants.KEY_COM_PPT_TPSZ);
		
		//Laden
		List<JooComCodeVO> ladenList = command1.searchJooComCodeByLadenList(jooCodeParamVO);
		//Empty
		List<JooComCodeVO> emptyList = command1.searchJooComCodeByEmptyList(jooCodeParamVO);

		StringBuilder ladenSb = new StringBuilder();
		StringBuilder emptySb = new StringBuilder();
		
		if(null != ladenList && ladenList.size() > 0){
			@SuppressWarnings("rawtypes")
			Iterator it = (Iterator) ladenList.iterator();
			int iCnt = 0;
			while(it.hasNext()){
				JooComCodeVO vo = (JooComCodeVO)it.next();
				if(iCnt == 0){
					ladenSb.append(vo.getAttrCtnt2()); // TPSZ Code
				}else{
					ladenSb.append("|"+vo.getAttrCtnt2()); // TPSZ Code
				}
				iCnt++;
			}				
		}
		if(null != emptyList && emptyList.size() > 0){
			@SuppressWarnings("rawtypes")
			Iterator it1 = (Iterator) emptyList.iterator();
			int iCnt = 0;
			while(it1.hasNext()){
				JooComCodeVO vo = (JooComCodeVO)it1.next();
				if(iCnt == 0){
					emptySb.append(vo.getAttrCtnt4()); // TPSZ Code
				}else{
					emptySb.append("|"+vo.getAttrCtnt4()); // TPSZ Code
				}
				iCnt++;
			}				
		}*/

		
		CntrConversionConditionVO conditionVO = new CntrConversionConditionVO();
		conditionVO.setPptCd(JooConstants.KEY_COM_PPT_DEFAULT_TPSZ);
		
		//Laden
		conditionVO.setDftTpszGroup(JooConstants.KEY_COM_PPT_DEFAULT_LADEN);
		List<CntrConversionAndOptionVO> ladenList = command.searchCntrConverionDefaultTpszList(conditionVO);
		
		//Empty
		conditionVO.setDftTpszGroup(JooConstants.KEY_COM_PPT_DEFAULT_EMPTY);
		List<CntrConversionAndOptionVO> emptyList = command.searchCntrConverionDefaultTpszList(conditionVO);
		
		String ladenTpsz = this.getDefaultTpszItem(ladenList);
		String emptyTpsz = this.getDefaultTpszItem(emptyList);

		//Container typesize를 | 로 묶인 데이타로 넘긴다.
		eventResponse.setETCData("ladenTpSzNm",ladenTpsz);
		eventResponse.setETCData("emptyTpSzNm",emptyTpsz);
		
		return eventResponse;
	}
	


	/**
	 * FNS_JOO_0086 : Conversion Table Retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCntrConversionTableData (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			FnsJoo0086Event event = (FnsJoo0086Event)e;

			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
			/*JOOFindCodeAndCheckBC command1 = new JOOFindCodeAndCheckBCImpl();
			
			//JOO_COM_PPT Laden/Empty TpSz 코드를 조회한다.
			JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
			jooCodeParamVO.setCode(JooConstants.KEY_COM_PPT_TPSZ);
			
			//Laden
			List<JooComCodeVO> ladenList = command1.searchJooComCodeByLadenList(jooCodeParamVO);
			//Empty
			List<JooComCodeVO> emptyList = command1.searchJooComCodeByEmptyList(jooCodeParamVO);
			
			StringBuilder ladenSb = new StringBuilder();
			StringBuilder emptySb = new StringBuilder();

			if(null != ladenList && ladenList.size() > 0){
				@SuppressWarnings("rawtypes")
				Iterator it = (Iterator) ladenList.iterator();
				int iCnt = 0;
				while(it.hasNext()){
					JooComCodeVO vo = (JooComCodeVO)it.next();
					if(iCnt == 0){
						ladenSb.append(vo.getAttrCtnt2()); // TPSZ Code
					}else{
						ladenSb.append("|"+vo.getAttrCtnt2()); // TPSZ Code
					}
					iCnt++;
				}				
			}
			if(null != emptyList && emptyList.size() > 0){
				@SuppressWarnings("rawtypes")
				Iterator it1 = (Iterator) emptyList.iterator();
				int iCnt = 0;
				while(it1.hasNext()){
					JooComCodeVO vo = (JooComCodeVO)it1.next();
					if(iCnt == 0){
						emptySb.append(vo.getAttrCtnt3()); // TPSZ Code
					}else{
						emptySb.append("|"+vo.getAttrCtnt3()); // TPSZ Code
					}
					iCnt++;
				}				
			}
				
				
			//Container typesize를 | 로 묶인 데이타로 넘긴다.
			event.getCntrConditionVO().setLadenTpszDatas(ladenSb.toString());
			event.getCntrConditionVO().setEmptyTpszDatas(emptySb.toString());*/
			
			//Default TP/SZ
			event.getCntrConversionConditionVO().setPptCd(JooConstants.KEY_COM_PPT_DEFAULT_TPSZ);
			List<CntrConversionAndOptionVO > defaultTpszList = command.searchCntrConverionByTpszList(event.getCntrConversionConditionVO());
			
			//Conversion TP/SZ
			event.getCntrConversionConditionVO().setPptCd(JooConstants.KEY_COM_PPT_TPSZ);
			List<CntrConversionAndOptionVO > tpszConversionList = command.searchCntrConverionByTpszList(event.getCntrConversionConditionVO());
			
			//Conversion TEU
			event.getCntrConversionConditionVO().setPptCd(JooConstants.KEY_COM_PPT_TEU);
			List<CntrConversionAndOptionVO > teuConversionList = command.searchCntrConverionByTeuList(event.getCntrConversionConditionVO());
			
			//Conversion Void
			event.getCntrConversionConditionVO().setPptCd(JooConstants.KEY_COM_PPT_VOID);
			List<CntrConversionAndOptionVO > voidConversionList = command.searchCntrConverionByVoidList(event.getCntrConversionConditionVO());
			
			//Conversion Normal TP/SZ
			event.getCntrConversionConditionVO().setPptCd(JooConstants.KEY_COM_PPT_TPSZ);
			List<CntrConversionAndOptionVO > normalTpszList = command.searchCntrNormalTpszList(event.getCntrConversionConditionVO());
			
			//위에서 조회된 데이타를 담는다.			
			eventResponse.setRsVoList(defaultTpszList);
			eventResponse.setRsVoList(tpszConversionList);
			eventResponse.setRsVoList(teuConversionList);
			eventResponse.setRsVoList(voidConversionList);
			eventResponse.setRsVoList(normalTpszList);
			
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
	 * FNS_JOO_0086 : Save
	 * saving Option
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCntrConversionTable(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0086Event event = (FnsJoo0086Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		try {
			begin();

			//Default TP/SZ Conversion Save			        
			command.manageCntrConversionByDefaultTpsz(event.getCntrDefaultTpszConversionAndOptionVOs(), account);
			
			//TP/SZ Conversion Save			        
			command.manageCntrConversionByTpsz(event.getCntrTpszConversionAndOptionVOs(), account);

			//TEU Conversion Save
			command.manageCntrConversionByTeu(event.getCntrTeuConversionAndOptionVOs(), account);

			//Void Conversion Save
			command.manageCntrConversionByVoid(event.getCntrVoidConversionAndOptionVOs(), account);
			
			
			//저장후 재조회 한다.
			//Default TP/SZ
			event.getCntrConversionConditionVO().setPptCd(JooConstants.KEY_COM_PPT_DEFAULT_TPSZ);
			List<CntrConversionAndOptionVO > defaultTpszList = command.searchCntrConverionByTpszList(event.getCntrConversionConditionVO());
			
			//Conversion TP/SZ
			event.getCntrConversionConditionVO().setPptCd(JooConstants.KEY_COM_PPT_TPSZ);
			List<CntrConversionAndOptionVO > tpszConversionList = command.searchCntrConverionByTpszList(event.getCntrConversionConditionVO());
			
			//Conversion TEU
			event.getCntrConversionConditionVO().setPptCd(JooConstants.KEY_COM_PPT_TEU);
			List<CntrConversionAndOptionVO > teuConversionList = command.searchCntrConverionByTeuList(event.getCntrConversionConditionVO());
			
			//Conversion Void
			event.getCntrConversionConditionVO().setPptCd(JooConstants.KEY_COM_PPT_VOID);
			List<CntrConversionAndOptionVO > voidConversionList = command.searchCntrConverionByVoidList(event.getCntrConversionConditionVO());
			
			//Conversion Normal TP/SZ
			event.getCntrConversionConditionVO().setPptCd(JooConstants.KEY_COM_PPT_TPSZ);
			List<CntrConversionAndOptionVO > normalTpszList = command.searchCntrNormalTpszList(event.getCntrConversionConditionVO());
			
			//위에서 조회된 데이타를 담는다.	
			eventResponse.setRsVoList(defaultTpszList);		
			eventResponse.setRsVoList(tpszConversionList);
			eventResponse.setRsVoList(teuConversionList);
			eventResponse.setRsVoList(voidConversionList);
			eventResponse.setRsVoList(normalTpszList);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0087 : Option Retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCntrOptionData (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			FnsJoo0087Event event = (FnsJoo0087Event)e;

			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
			
			//Conversion TP/SZ
			event.getCntrConversionConditionVO().setPptCd(JooConstants.KEY_COM_PPT_OPTION);
			List<CntrConversionAndOptionVO > optinList = command.searchCntrOptionList(event.getCntrConversionConditionVO());
			
			//위에서 조회된 데이타를 담는다.			
			eventResponse.setRsVoList(optinList);
			
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
	 * FNS_JOO_0087 : Save
	 * saving Option
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCntrOption(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0087Event event = (FnsJoo0087Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		try {
			begin();
			command.manageCntrOption(event.getCntrConversionAndOptionVOs(), account);
			
			//Conversion TP/SZ
			event.getCntrConversionConditionVO().setPptCd(JooConstants.KEY_COM_PPT_OPTION);
			List<CntrConversionAndOptionVO > optinList = command.searchCntrOptionList(event.getCntrConversionConditionVO());
			
			//위에서 조회된 데이타를 담는다.			
			eventResponse.setRsVoList(optinList);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * FNS_JOO_0009 : RGN change (Inter Select)
	 * 2015.08.12 Add
	 * retrieve Used Slot Teu and WGT at change of Region
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUsedSlotByInterList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			FnsJoo0009Event event = (FnsJoo0009Event)e;

			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
			

			List<ProcSettlementVO> list = command.searchUsedSlotByInterList(event.getProcSettlementVO());
			if (list.isEmpty()) {
				eventResponse.setETCData("CHECKVVD", "E");
			} else {
				eventResponse.setETCData("CHECKVVD", "N");
				//위에서 조회된 데이타를 담는다.			
				eventResponse.setRsVoList(list);
			}
			
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
	 * FNS_JOO_0009 : Inter change , From/To Port Change
	 * 2015.08.12 Add
	 * retrieving unit price in case of changing Inter port / Ocean
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBsaSltPrcForInterOusRdr(Event e) throws EventException {
		FnsJoo0009Event event = (FnsJoo0009Event) e;

		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchBsaSltPrcByInter(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String bsaSltPrc = "";

		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			ProcSettlementVO voOut = list.get(0);
			
			if(null != voOut) bsaSltPrc = voOut.getBsaSltPrc();
		}
		eventResponse.setETCData("bsa_slt_prc", bsaSltPrc);
		return eventResponse;
	}

	/**
	 * Default TP/SZ CntrConversionAndOptionVO list to String
	 * @param List<CntrConversionAndOptionVO> tpszList
	 * @return String
	 * @throws EventException
	 */
	private String getDefaultTpszItem(List<CntrConversionAndOptionVO> tpszList) throws EventException{
		StringBuilder tpszSb = new StringBuilder();
		
		if(null != tpszList && tpszList.size() > 0){
			@SuppressWarnings("rawtypes")
			Iterator it = (Iterator) tpszList.iterator();
			int iCnt = 0;
			while(it.hasNext()){
				CntrConversionAndOptionVO vo = (CntrConversionAndOptionVO)it.next();
				if(iCnt == 0){
					tpszSb.append(vo.getDftTpsz()); // TPSZ Code
				}else{
					tpszSb.append("|"+vo.getDftTpsz()); // TPSZ Code
				}
				iCnt++;
			}				
		}		

		return tpszSb.toString();
	}

    
    /**
     * JOO_CRR_AUTH에 등록된 Office 권한의 ComboItem 조회.
     * 2017.01.23 소스품질로 주석처리.
     * @param comboItemFlg
     * @return
     * @throws EventException
     */
    /*private String searchConditionComboItemByAuthOfficeCd(String comboItemFlg) throws EventException {
    	try {    
		    JOOFindCodeAndCheckBC    command    = new JOOFindCodeAndCheckBCImpl();
		    
		    String ofcCd = account.getOfc_cd();
		    boolean isContainOffice = OfficeCodeMgr.checkContainOfficeCode(JooConstants.KEY_OFFICE_GROUP_CD, JooConstants.KEY_OFFICE_SUBSYS_CD, ofcCd);
		    
		    String authOfcCd = isContainOffice ? "" : ofcCd; //등록된 Office일때는 ALL 권한, 그렇지 않으면 디폴트로 Login office
		    
		    //authDelcheckYn
		    JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		    jooCodeParamVO.setOfcCd(authOfcCd);
		    
		    String rtnCds = "";
		    
		    if(comboItemFlg.equals(JooConstants.KEY_COMBOITEM_FLG_CARRIER)){
		    	List<JooCodeInfoVO> carrlist   = command.searchCarrierCodeList(jooCodeParamVO);
		    	rtnCds = makeComboString(carrlist, 2); //IBCombo, Code만
		    }else if(comboItemFlg.equals(JooConstants.KEY_COMBOITEM_FLG_TRADE)){
		    	List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);
		    	rtnCds = makeComboString(list, 2); //IBCombo, Code만
		    }else if(comboItemFlg.equals(JooConstants.KEY_COMBOITEM_FLG_RLANE)){
		    	List<JooCodeInfoVO> rlaneList = command.searchRlaneCodeList(jooCodeParamVO);
		    	rtnCds= makeComboString(rlaneList, 2); //IBCombo, Code만
		    }else if(comboItemFlg.equals(JooConstants.KEY_COMBOITEM_FLG_AUTH_OFC)){
		    	//2016.07.26 권한 있는 Office 조회
				if (isContainOffice){
					List<JooCodeInfoVO> authOfcList = command.searchAuthOfficeList(jooCodeParamVO);
					if (authOfcList.isEmpty()) {
						rtnCds = ofcCd + "," + ofcCd;
					}else{ 
						rtnCds = "ALL,|"+makeComboString(authOfcList, 1);
					}
				}else{
					rtnCds = ofcCd+","+ofcCd;
				}
		    }else if(comboItemFlg.equals(JooConstants.KEY_COMBOITEM_FLG_CSR_AUTH_OFC)){
		    	JointOperationConsultationBC command2 = new JointOperationConsultationBCImpl();
				if (isContainOffice){
					SlipConditionVO vo = new SlipConditionVO();
					vo.setGubun("0");
					vo.setFrDt(JSPUtil.getKST("yyyyMMdd"));
					vo.setToDt(JSPUtil.getKST("yyyyMMdd"));

					List<SlipConditionVO> list = command2.searchCsrOfcList(vo);

					if (list.isEmpty()) {
						rtnCds = ofcCd + "," + ofcCd;
					} else {
						StringBuilder sb = new StringBuilder();

						@SuppressWarnings("rawtypes")
						Iterator iterator = (Iterator) list.iterator();

						sb.append("ALL,|");
						while (iterator.hasNext()) {
							SlipConditionVO slipConditionVO = (SlipConditionVO) iterator.next();
							sb.append(slipConditionVO.getSlpOfcCd()).append(",");
							sb.append(slipConditionVO.getSlpOfcCd()).append("|");
						}
						rtnCds = sb.toString();

						if (rtnCds.length() > 0)
							rtnCds = rtnCds.substring(0, rtnCds.length() - 1);
					}
				} else {
					rtnCds = ofcCd + "," + ofcCd;
				}
		    }
		    
		    return rtnCds;
    	} catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw ex;
        }
    }*/


    
    /**
     * JOO_CRR_AUTH에 등록된 Office 권한의 ComboItem 조회.
     * @param comboItemFlg
     * @return
     * @throws EventException
     */
    private String searchConditionComboItemByCsrAuthOfficeCd(String comboItemFlg, SlipConditionVO slipConditionVO, String searchTpCd) throws EventException {
    	try {
	    	JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
	    	
		    String ofcCd = account.getOfc_cd();
		    boolean isContainOffice = OfficeCodeMgr.checkContainOfficeCode(JooConstants.KEY_OFFICE_GROUP_CD, JooConstants.KEY_OFFICE_SUBSYS_CD, ofcCd);
		    
		    //String authOfcCd = isContainOffice ? "" : ofcCd; //등록된 Office일때는 ALL 권한, 그렇지 않으면 디폴트로 Login office
		    
		    String rtnCds = "";
		    
		    if(comboItemFlg.equals(JooConstants.KEY_COMBOITEM_FLG_CSR_AUTH_OFC)){
				if (isContainOffice){
					
					if(slipConditionVO == null){
						slipConditionVO = new SlipConditionVO();
						if(searchTpCd.equals(JooConstants.KEY_SEARCH_TP_CD_CSR_APPROVAL)){
							slipConditionVO.setIfFlg("0");
							slipConditionVO.setSchTpCd(searchTpCd);
							slipConditionVO.setSlpIssDt(JSPUtil.getKST("yyyyMMdd"));
						}else{
							slipConditionVO.setGubun("0");
							slipConditionVO.setSchTpCd(searchTpCd);
							slipConditionVO.setFrDt(JSPUtil.getKST("yyyyMMdd"));
							slipConditionVO.setToDt(JSPUtil.getKST("yyyyMMdd"));
						}
					}
					List<SlipConditionVO> list = command.searchCsrOfcList(slipConditionVO);

					if (list.isEmpty()) {
						rtnCds = ofcCd + "," + ofcCd;
					} else {
						StringBuilder sb = new StringBuilder();

						@SuppressWarnings("rawtypes")
						Iterator iterator = (Iterator) list.iterator();

						sb.append("ALL,|");
						while (iterator.hasNext()) {
							SlipConditionVO rtnVo = (SlipConditionVO) iterator.next();
							sb.append(rtnVo.getSlpOfcCd()).append(",");
							sb.append(rtnVo.getSlpOfcCd()).append("|");
						}
						rtnCds = sb.toString();

						if (rtnCds.length() > 0)
							rtnCds = rtnCds.substring(0, rtnCds.length() - 1);
					}
				} else {
					rtnCds = ofcCd + "," + ofcCd;
				}
		    }
		    
		    return rtnCds;
    	} catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw ex;
        }
    }
	
}