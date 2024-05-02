/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralManageSC.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.11
*@LastModifier : 議곌꼍��
*@LastVersion : 1.0
* 2009.04.27 諛뺣챸��
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.11.29 源�긽��[CHM-201114696-01] ALPS > MNR > Seal management creation �붾㈃怨�inquiry �붾㈃ - Seal No��prefix留�蹂꾨룄 而щ읆�쇰줈 遺꾨━
*                                      - MNR_SEAL_PLN �뚯씠釉붿뿉 Serial Range 媛믪쓣 遺꾨━�섏뿬 ��옣, 議고쉶
*                                      - �대떦 而щ읆紐낆쓣 �ъ슜�섎뒗 js諛�荑쇰━, VO �꾨㈃�섏젙
* 2012.02.07 �좏삙��[�좎쿂由� Container Seal Inquiry 紐⑸줉 議고쉶 蹂댁셿    
* 2012.09.11 議곌꼍��[CHM-201220024-01] Container Seal Inquiry Back End Job 援ы쁽    
* 2014-02-28 Jonghee HAN Write Off Malfunction Fix                            
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage;

import java.util.List;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.basic.ApprovalStepMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.basic.ApprovalStepMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.event.EesMnr0265Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.ApprovalStepGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.CustomApprovalStepVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.basic.CEDEXCodeMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.basic.CEDEXCodeMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0002Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0003Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0004Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0142Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0193Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0225Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.integration.CEDEXCodeMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CedexOtherCodeListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CodeRelationGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.ComponentCodeListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.DamageLocationCodeListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.DivisionCodeGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.RepairCodeFindListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.basic.DVFactorMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.basic.DVFactorMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.event.EesMnr0107Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.event.EesMnr0249Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.event.EesMnr0253Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.event.EesMnr0254Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealInquiryVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealNoCreationGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealNoCreationVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.DVFactorGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.DvLeasedUnitINGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.basic.FQAResultMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.basic.FQAResultMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.event.EesMnr0029Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.event.EesMnr0222Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.event.EesMnr0223Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo.FQAResultMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo.MnrFieldQualityAuditResultVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.basic.GeneralCodeMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.basic.GeneralCodeMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.event.EesMnr0009Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.vo.GeneralCodeMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.basic.HangerInventoryMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.basic.HangerInventoryMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.event.EesMnr0110Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.event.EesMnr0113Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.event.EesMnr0224Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.basic.OfficeGeneralInfoMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.basic.OfficeGeneralInfoMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.event.EesMnr0010Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.event.EesMnr0135Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.event.EesMnr0217Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.event.EesMnr0239Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.ColleagueTreeGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.CustomMnrOfcGenInfoVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.OfficeGeneralInfoListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.basic.OnsiteInspectionResultMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.basic.OnsiteInspectionResultMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.event.EesMnr0271Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.event.EesMnr0273Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.event.EesMnr0274Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.vo.MnrOnSite2VO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.vo.MnrOnSiteVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.event.EesMnr0155Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.DisposalPartnerGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.basic.ReeferSparePartMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.basic.ReeferSparePartMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0056Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0137Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0198Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0214Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0266Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0267Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0268Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0270Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.MnrVslSprPrtInvtVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartCodeMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartInventoryMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFVessleSparePartCodeVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.basic.WarrantyMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.basic.WarrantyMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.event.EesMnr0170Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.event.EesMnr0213Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertInfoGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertListGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBC;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrFileAtchVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBC;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-GeneralManage Business Logic ServiceCommand - alps-GeneralManage ��븳 鍮꾩��덉뒪 �몃옖��뀡��泥섎━�쒕떎.
 *
 * @author park myoung sin
 * @see CEDEXCodeMgtDBDAO
 * @since J2EE 1.4
 */

public class GeneralManageSC extends ServiceCommandSupport { 
	// Login User Information
	private SignOnUserAccount account = null;
	private Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.mnr.generalmanage");

	/**
	 * GeneralManage system �낅Т �쒕굹由ъ삤 �좏뻾�묒뾽<br>
	 * EES_MNR_0003�낅Т �쒕굹由ъ삤 �몄텧��愿�젴 �대�媛앹껜 �앹꽦<br>
	 */
	public void doStart() {
		try {
			// �쇰떒 comment --> 濡쒓렇��泥댄겕 遺�텇
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}

	/**
	 * GeneralManage system �낅Т �쒕굹由ъ삤 留덇컧�묒뾽<br>
	 * EES_MNR_0003 �낅Т �쒕굹由ъ삤 醫낅즺��愿�젴 �대�媛앹껜 �댁젣<br>
	 */
	public void doEnd() {
		log.debug("GeneralManageSC 醫낅즺");
	}

	/**
	 * 媛��대깽�몄뿉 �대떦�섎뒗 �낅Т �쒕굹由ъ삤 �섑뻾<br>
	 * alps-GeneralManage system �낅Т�먯꽌 諛쒖깮�섎뒗 紐⑤뱺 �대깽�몄쓽 遺꾧린泥섎━<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC媛��щ윭 �대깽�몃� 泥섎━�섎뒗 寃쎌슦 �ъ슜�댁빞 ��遺�텇
		if (e.getEventName().equalsIgnoreCase("EesMnr0003Event")) {
			//LOCATION CODE
 			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDamageLocationCodeListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDamageLocationCodeService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0193Event")) {
			//LOCATION POPUP
 			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDamageLocationCodeListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0002Event")) {
			//硫붿씤�붾㈃ 議곌굔遺�肄ㅻ낫議고쉶,洹몃━��議고쉶
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComponentCodeListService(e);
			}
			//�앹뾽�붾㈃ 洹몃━�쒖“��
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCodeRelationListService(e);
			}
			//硫붿씤�붾㈃ 洹몃━����옣
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageComponentCodeService(e);
			}
			//�앹뾽�붾㈃ 洹몃━����옣
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCodeRelationService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0004Event")) {
			//議곌굔遺�肄ㅻ낫議고쉶,洹몃━��議고쉶
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCedexOtherCodeListService(e);
			}//議고쉶遺�洹몃━����옣
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCedexOtherCodeService(e);
			}
		//MNR Other Code
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0009Event")) {
			//議곌굔遺�肄ㅻ낫議고쉶,洹몃━��議고쉶
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGeneralCodeListService(e);
			}//議고쉶遺�洹몃━����옣
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageGeneralCodeService(e);
			}
		//FQAResultMgt
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0029Event")) {
			//議곌굔遺�肄ㅻ낫議고쉶,洹몃━��議고쉶
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFQAResultListService(e);
			}//議고쉶遺�洹몃━����옣
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFQAResultService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeFQAResultService(e);
			}
		//DV Factor
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0107Event")) {
			//議고쉶
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDVFactorListService(e);
			}//��옣
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDVFactorService(e);
			}
		//Warranty alert POP-UP
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0213Event")) {
			//議고쉶
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWarrantyAlertInfoService(e);
			}

		//OfficeGeneralInfoMgtBC
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0217Event")) {
			//議고쉶
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchColleagueTreeListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageColleagueTreeListService(e);
			}
		//Reefer Unit Warranty Period
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0170Event")) {
			//議고쉶
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWarrantyAlertListService(e);
			}//��옣
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageWarrantyAlertService(e);
			}
		//Disposal Buyer Management
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0155Event")) {
			//議고쉶
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalPartnerListService(e);
			}//��옣
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDisposalPartnerService(e);
			}//��젣
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeDisposalPartnerService(e);
			}
		//RepairCodeFindListBC - popup
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0142Event")) {
			//議고쉶
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairCodeFindListService(e);
			}
		//Repair Approval Authority
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeGeneralInfoListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageOfficeGeneralInfoListService(e);
			}
		//Equipment Repair Approval Authority Inquiry
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0135Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeGeneralInfoListService(e);
			}
		//Hanger Bar Inventory List(OLD 2015.01.28 by JeongMin Park)
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHangerInventoryListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageHangerInventoryService(e);
			}
	   // Hanger Bar Inventory List(NEW 2015.01.28 by JeongMin Park)
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0113Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNewHangerInventoryListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageNewHangerInventoryService(e);
			}
	   // Reefer Spare Parts List
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRFSparePartInventoryListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageRFSparePartInventoryService(e);
			}
	   // Reefer Spare Parts List
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0137Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRFsparePartCodeListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageRFsparePartCodeService(e);
			}
	   // Reefer Spare Parts List
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0214Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRFsparePartCodeListService(e);
			}
	   // Reefer Spare Parts List
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0198Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRFsparePartCodeListService(e);
			}
	   //Division Code Creation
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0225Event")) {
		   if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDivisionCodeListService(e);
		   } else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageDivisionCodeService(e);
		   }
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0222Event")) {
			//議곌굔遺�肄ㅻ낫議고쉶,洹몃━��議고쉶
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFQAListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0223Event")) {
			//議곌굔遺�肄ㅻ낫議고쉶,洹몃━��議고쉶
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFQAResultListService(e);
			}
		//Hanger Bar Inventory History Pop Up
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0224Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHangerInventoryDetailListService(e);
			}
		//Office Control Info
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0239Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeGeneralInfoListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageOfficeGeneralInfoListService(e);
			}
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0249Event")) {
			//議고쉶
			//DV Leased Unit
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDvLeasedUnitService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDvLeasedUnitService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0253Event")) {
			//議고쉶
			//Container Seal No-Creation
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainerSealNoCreationService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageContainerSealNoCreationService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0254Event")) {
			//議고쉶
			//Container Seal Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBackEndContainerSealInquiryService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = searchComBackEndJobStatusService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)){
				eventResponse = loadFileBackEndJobResultService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0265Event")) {
			//Write Off Approval Route Manager Selection
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchApprovalStepInquiryService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageApprovalStepCreationService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = checkOfficeService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = checkAproOfcService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				eventResponse = searchUserNameService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0266Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslSprPrtCd(((EesMnr0266Event)e).getRFVessleSparePartCodeVO());
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageVslSparePartCode(e);		
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0267Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslInventory(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchVslInventoryHeader(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageVslInventory(e);
			}else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeVslInventory(e);
			}
//			
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0268Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselSparePartInventoryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0270Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslSprPrtCd(((EesMnr0270Event)e).getRFVessleSparePartCodeVO());
			}	
			//OnSite Inspection Result Inquiry
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0271Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnsiteInspectionResultHeader(e);
			}
			//OnSite Inspection Result Creation
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0273Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnsiteInspectionResult(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = updateOnsiteInspectionResult(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = deleteOnsiteInspectionResult(e);
			}
			//OnSite Inspection Result Item Management
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0274Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnsiteInspectionResultItems(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				insertOnsiteInspectionResultItems(e);
			}
		}
		
		return eventResponse;
	}

	/**
	 * EES_MNR_0225 : Retrieve <br>
	 * [EES_MNR_0225]Division Code Creation���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDivisionCodeListService(Event e) throws EventException {
		EesMnr0225Event event = (EesMnr0225Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();
		DivisionCodeGRPVO divisionCodeGRPVO = event.getDivisionCodeGRPVO();

		divisionCodeGRPVO = command.searchDivisionCodeListBasic(divisionCodeGRPVO,account);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(divisionCodeGRPVO.getListCustomMnrCdRltVOS());

		return eventResponse;
	}

	/**
	 * EES_MNR_0225 : Save <br>
	 * [EES_MNR_0225]Division Code Creation���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDivisionCodeService(Event e) throws EventException {
		EesMnr0225Event event = (EesMnr0225Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();
		DivisionCodeGRPVO divisionCodeGRPVO = event.getDivisionCodeGRPVO();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.manageDivisionCodeBasic(divisionCodeGRPVO, account);
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
	 * EES_MNR_0010 : Save <br>
	 * [EES_MNR_0010]Repair Approval Authority���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOfficeGeneralInfoListService(Event e) throws EventException {

		OfficeGeneralInfoMgtBC command = new OfficeGeneralInfoMgtBCImpl();
		OfficeGeneralInfoListGRPVO  officeGeneralInfoListGRPVO = new OfficeGeneralInfoListGRPVO();

		if (e.getEventName().equalsIgnoreCase("EesMnr0010Event")) {
			EesMnr0010Event event = (EesMnr0010Event)e;
			officeGeneralInfoListGRPVO = event.getOfficeGeneralInfoListGRPVO();

			CustomMnrOfcGenInfoVO[] arrCustomMnrOfcGenInfoVOs = officeGeneralInfoListGRPVO.getArrCustomMnrOfcGenInfoVO();
			for ( int i = 0; i < arrCustomMnrOfcGenInfoVOs.length; i++ ) {
				arrCustomMnrOfcGenInfoVOs[i].setMnrGrpTpCd("RPR");
			}

			officeGeneralInfoListGRPVO.setArrCustomMnrOfcGenInfoVO(arrCustomMnrOfcGenInfoVOs);
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0239Event")) {
			EesMnr0239Event event = (EesMnr0239Event)e;
			officeGeneralInfoListGRPVO = event.getOfficeGeneralInfoListGRPVO();

			CustomMnrOfcGenInfoVO[] arrCustomMnrOfcGenInfoVOs = officeGeneralInfoListGRPVO.getArrCustomMnrOfcGenInfoVO();
			for ( int i = 0; i < arrCustomMnrOfcGenInfoVOs.length; i++ ) {
				arrCustomMnrOfcGenInfoVOs[i].setMnrGrpTpCd("OFC");
			}

			officeGeneralInfoListGRPVO.setArrCustomMnrOfcGenInfoVO(arrCustomMnrOfcGenInfoVOs);
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			begin();
			command.manageOfficeGeneralInfoListBasic(officeGeneralInfoListGRPVO, account);
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
	 * EES_MNR_0135 : Retrieve <br>
	 * [EES_MNR_0135]Repair Approval Authority���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeGeneralInfoListService(Event e) throws EventException {

		OfficeGeneralInfoMgtBC command = new OfficeGeneralInfoMgtBCImpl();
		OfficeGeneralInfoListGRPVO  officeGeneralInfoListGRPVO = new OfficeGeneralInfoListGRPVO();

		if(e.getEventName().equalsIgnoreCase("EesMnr0010Event"))
		{
			EesMnr0010Event event = (EesMnr0010Event)e;
			officeGeneralInfoListGRPVO = event.getOfficeGeneralInfoListGRPVO();
			officeGeneralInfoListGRPVO.getOfficeGeneralInfoMgtINVO().setMnrGrpTpCd("RPR");
		}
		else if(e.getEventName().equalsIgnoreCase("EesMnr0135Event"))
		{
			EesMnr0135Event event = (EesMnr0135Event)e;
			officeGeneralInfoListGRPVO = event.getOfficeGeneralInfoListGRPVO();
			officeGeneralInfoListGRPVO.getOfficeGeneralInfoMgtINVO().setMnrGrpTpCd("RPR");
		}
		else if(e.getEventName().equalsIgnoreCase("EesMnr0239Event"))
		{
			EesMnr0239Event event = (EesMnr0239Event)e;
			officeGeneralInfoListGRPVO = event.getOfficeGeneralInfoListGRPVO();
			officeGeneralInfoListGRPVO.getOfficeGeneralInfoMgtINVO().setMnrGrpTpCd("OFC");
		}

		officeGeneralInfoListGRPVO = command.searchOfficeGeneralInfoListBasic(officeGeneralInfoListGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(officeGeneralInfoListGRPVO.getCustomMnrOfcGenInfoVOS());

		return eventResponse;
	}

	/**
	 * EES_MNR_0142 : Retrieve <br>
	 * [EES_MNR_0142]Pop Up_Tariff Code Finding���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairCodeFindListService(Event e) throws EventException {
		EesMnr0142Event event = (EesMnr0142Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();
		RepairCodeFindListGRPVO repairCodeFindListGRPVO = event.getRepairCodeFindListGRPVO();
		repairCodeFindListGRPVO = command.searchRepairCodeFindListBasic(repairCodeFindListGRPVO);

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(repairCodeFindListGRPVO.getCustomMnrEqCmpoCdVOS());

		return eventResponse;
	}

	/**
	 * EES_MNR_0217 : Save <br>
	 * [EES_MNR_0217]M&R Colleague Tree���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageColleagueTreeListService(Event e) throws EventException {
		EesMnr0217Event event = (EesMnr0217Event)e;
		OfficeGeneralInfoMgtBC command = new OfficeGeneralInfoMgtBCImpl();
		ColleagueTreeGRPVO officeGeneralInfoMgtGRPVO = event.getColleagueTreeGRPVO();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{

			begin();
			command.manageColleagueTreeBasic(officeGeneralInfoMgtGRPVO, account);
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
	 * EES_MNR_0217 : Retrieve <br>
	 * [EES_MNR_0217]M&R Colleague Tree���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchColleagueTreeListService(Event e) throws EventException {
		EesMnr0217Event event = (EesMnr0217Event)e;
		OfficeGeneralInfoMgtBC command = new OfficeGeneralInfoMgtBCImpl();

		ColleagueTreeGRPVO officeGeneralInfoMgtGRPVO = event.getColleagueTreeGRPVO();

		officeGeneralInfoMgtGRPVO = command.searchColleagueTreeListBasic(officeGeneralInfoMgtGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(officeGeneralInfoMgtGRPVO.getCustomMnrOfcCntcPsonVOS());

		return eventResponse;
	}
	/**
	 * EES_MNR_0213 : Retrieve <br>
	 * [EES_MNR_0213]Warranty Alert_Pop Up���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWarrantyAlertInfoService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0213Event event = (EesMnr0213Event)e;
		WarrantyMgtBC command = new WarrantyMgtBCImpl();
		WarrantyAlertInfoGRPVO warrantyAlertInfoGRPVO = new WarrantyAlertInfoGRPVO();
		warrantyAlertInfoGRPVO.setWarrantyAlertInfoINVO((event.getWarrantyAlertInfoINVO()));
		warrantyAlertInfoGRPVO = command.searchWarrantyAlertInfoBasic(warrantyAlertInfoGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(warrantyAlertInfoGRPVO.getCustomMnrEqRngStsVOS());

		return eventResponse;
	}

	/**
	 * EES_MNR_0004 : Retrieve <br>
	 * [EES_MNR_0004]Damage Type���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCedexOtherCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0004Event event = (EesMnr0004Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();
		CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO = new CedexOtherCodeListGRPVO();
		cedexOtherCodeListGRPVO.setCedexOtherCodeListINVO((event.getCedexOtherCodeListINVO()));
		cedexOtherCodeListGRPVO = command.searchCedexOtherCodeListBasic(cedexOtherCodeListGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(cedexOtherCodeListGRPVO.getCustomMnrCedexOtrCdVOS());

		return eventResponse;
	}

	/**
	 * EES_MNR_0004 : Save <br>
	 * [EES_MNR_0004]Damage Type���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCedexOtherCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0004Event event = (EesMnr0004Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();

		try{
			begin();
			CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO = new CedexOtherCodeListGRPVO();
			cedexOtherCodeListGRPVO.setArrCustomMnrCedexOtrCdVOS(event.getCustomMnrCedexOtrCdVOS());
			command.manageCedexOtherCodeListBasic(cedexOtherCodeListGRPVO,account);
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
	 * EES_MNR_0003 : Save <br>
	 * [EES_MNR_0003]Damage Location���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDamageLocationCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0003Event event = (EesMnr0003Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();

		try{
			begin();
			DamageLocationCodeListGRPVO damageLocationCodeListGRPVO = new DamageLocationCodeListGRPVO();
			damageLocationCodeListGRPVO.setArrCustomMnrEqLocCdVOS(event.getCustomMnrEqLocCdVOS());
			command.manageDamageLocationCodeBasic(damageLocationCodeListGRPVO,account);
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
	 * EES_MNR_0193 : Retrieve <br>
	 * [EES_MNR_0193]Location Code Inquiry_Pop Up���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDamageLocationCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();
		DamageLocationCodeListGRPVO damageLocationCodeListGRPVO = new DamageLocationCodeListGRPVO();
		if(e.getEventName().equals("EesMnr0003Event")){
			EesMnr0003Event event = (EesMnr0003Event)e;
			damageLocationCodeListGRPVO.setDamageLocationCodeListINVO((event.getDamageLocationCodeListINVO()));
		} else {
			EesMnr0193Event event = (EesMnr0193Event)e;
			damageLocationCodeListGRPVO.setDamageLocationCodeListINVO((event.getDamageLocationCodeListINVO()));
		}

		damageLocationCodeListGRPVO = command.searchDamageLocationCodeListBasic(damageLocationCodeListGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		for (int i = 0; i < damageLocationCodeListGRPVO.getListCustomMnrEqLocCdVOS().size(); i++) {
			eventResponse.setRsVoList(damageLocationCodeListGRPVO.getListCustomMnrEqLocCdVOS().get(i));
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0002 : Retrieve <br>
	 * [EES_MNR_0002]EQ Component���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComponentCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0002Event event = (EesMnr0002Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();
		ComponentCodeListGRPVO componentCodeListGRPVO = new ComponentCodeListGRPVO();
		componentCodeListGRPVO.setComponentCodeListINVO(event.getComponentCodeListINVO());
		componentCodeListGRPVO = command.searchComponentCodeListBasic(componentCodeListGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		//�ㅼ쨷議고쉶
		for (int i = 0; i < componentCodeListGRPVO.getListCustomMnrEqCmpoCdVOS().size(); i++) {
		    eventResponse.setRsVoList(componentCodeListGRPVO.getListCustomMnrEqCmpoCdVOS().get(i));
		}
		return eventResponse;
	}
	/**
	 * EES_MNR_0002 : Save <br>
	 * [EES_MNR_0002]EQ Component���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageComponentCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0002Event event = (EesMnr0002Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();

		try{
			begin();
			ComponentCodeListGRPVO componentCodeListGRPVO = new ComponentCodeListGRPVO();
			componentCodeListGRPVO.setCustomMnrEqCmpoCdVOs(event.getCustomMnrEqCmpoCdVOS());
			command.manageComponentCodeBasic(componentCodeListGRPVO,account);
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
	 * EES_MNR_0145 : Retrieve <br>
	 * [EES_MNR_0145]EQ Component Grouping by Location & Damage Type���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeRelationListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0002Event event = (EesMnr0002Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();
		CodeRelationGRPVO codeRelationGRPVO = new CodeRelationGRPVO();
		codeRelationGRPVO.setCodeRelationINVO(event.getCodeRelationINVO());
		codeRelationGRPVO = command.searchCodeRelationListBasic(codeRelationGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		//�ㅼ쨷議고쉶
		eventResponse.setRsVoList(codeRelationGRPVO.getListCustomMnrCdRltByLocVO());
		eventResponse.setRsVoList(codeRelationGRPVO.getListCustomMnrCdRltByDmgVO());;
		eventResponse.setRsVoList(codeRelationGRPVO.getListCustomMnrCdRltByRprVO());;

		return eventResponse;
	}
	/**
	 * EES_MNR_0145 : Save <br>
	 * [EES_MNR_0145]EQ Component Grouping by Location & Damage Type���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCodeRelationService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0002Event event = (EesMnr0002Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();

		try{
			begin();
			CodeRelationGRPVO codeRelationGRPVO = new CodeRelationGRPVO();
			codeRelationGRPVO.setCustomMnrCdRltByLocVOS(event.getCustomMnrCdRltByLocVOS());
			command.manageCodeRelationBasic(codeRelationGRPVO,account);
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
	 * EES_MNR_0009 : Retrieve <br>
	 * [EES_MNR_0009]M&R Other Code���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGeneralCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0009Event event = (EesMnr0009Event)e;
		GeneralCodeMgtBC command = new GeneralCodeMgtBCImpl();
		GeneralCodeMgtGRPVO generalCodeMgtGRPVO = new GeneralCodeMgtGRPVO();
		generalCodeMgtGRPVO.setGeneralCodeMgtINVO(event.getGeneralCodeMgtINVO());

		generalCodeMgtGRPVO = command.searchGeneralCodeListBasic(generalCodeMgtGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		//�ㅼ쨷議고쉶
		for (int i = 0; i < generalCodeMgtGRPVO.getListCustomMnrGenCdVOs().size(); i++) {
		    eventResponse.setRsVoList(generalCodeMgtGRPVO.getListCustomMnrGenCdVOs().get(i));
		}

		return eventResponse;
	}
	/**
	 * EES_MNR_0009 : Save <br>
	 * [EES_MNR_0009]M&R Other Code���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGeneralCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0009Event event = (EesMnr0009Event)e;
		GeneralCodeMgtBC command = new GeneralCodeMgtBCImpl();

		try{
			begin();
			GeneralCodeMgtGRPVO generalCodeMgtGRPVO = new GeneralCodeMgtGRPVO();
			generalCodeMgtGRPVO.setArrayCustomMnrGenCdVOs(event.getCustomMnrGenCdVOs());
			command.manageGeneralCodeBasic(generalCodeMgtGRPVO,account);
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
	 * EES_MNR_0223 : Retrieve <br>
	 * [EES_MNR_0223]FQA Result Detail Pop Up���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFQAResultListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		FQAResultMgtBC command = new FQAResultMgtBCImpl();
		InterfaceMgtBC command2 = new  InterfaceMgtBCImpl();

		FQAResultMgtGRPVO fQAResultMgtGRPVO = new FQAResultMgtGRPVO();
		if (e.getEventName().equalsIgnoreCase("EesMnr0223Event")) {
			EesMnr0223Event event = (EesMnr0223Event)e;
			fQAResultMgtGRPVO.setFQAResultMgtINVO((event.getFQAResultMgtINVO()));
		}else{
			EesMnr0029Event event = (EesMnr0029Event)e;
			fQAResultMgtGRPVO.setFQAResultMgtINVO((event.getFQAResultMgtINVO()));
		}

		fQAResultMgtGRPVO = command.searchFQAResultListBasic(fQAResultMgtGRPVO);


		String fileSeq ="";
		MnrFieldQualityAuditResultVO mnrFieldQualityAuditResultVO = new MnrFieldQualityAuditResultVO();

		for (int i = 0; i < fQAResultMgtGRPVO.getMnrFieldQualityAuditResultVOS().size(); i++) {
			mnrFieldQualityAuditResultVO = (MnrFieldQualityAuditResultVO)fQAResultMgtGRPVO.getMnrFieldQualityAuditResultVOS().get(i);
			if (!mnrFieldQualityAuditResultVO.getFileSeq().equals("0")){
				fileSeq = mnrFieldQualityAuditResultVO.getFileSeq();
				break;
			}
		}
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
		interfaceGRPVO = command2.searchFileUploadBasic(fileSeq, account);

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(fQAResultMgtGRPVO.getMnrFieldQualityAuditResultVOS());
		eventResponse.setRsVoList(interfaceGRPVO.getListCustomMnrFileAtchVOs());

		return eventResponse;
	}
	/**
	 * EES_MNR_0029 : Save <br>
	 * [EES_MNR_0029]FQA Result Creation���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFQAResultService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0029Event event = (EesMnr0029Event)e;
		FQAResultMgtBC command = new FQAResultMgtBCImpl();
		InterfaceMgtBC command2 = new  InterfaceMgtBCImpl();

		try{
			begin();
			FQAResultMgtGRPVO fQAResultMgtGRPVO = new FQAResultMgtGRPVO();
			fQAResultMgtGRPVO.setFQAResultMgtINVO((event.getFQAResultMgtINVO()));
			fQAResultMgtGRPVO.setMnrFieldQualityAuditResultVOs(event.getMnrFieldQualityAuditResultVOS());
			command.manageFQAResultBasic(fQAResultMgtGRPVO, account);

			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			interfaceGRPVO.setCustomMnrFileAtchVOs(event.getCustomMnrFileAtchVOs());

			CustomMnrFileAtchVO[] customMnrFileAtchVOs = interfaceGRPVO.getCustomMnrFileAtchVOs();
			if(customMnrFileAtchVOs != null){
				String delChk="";
				CustomMnrFileAtchVO[] newCustomMnrFileAtchVOs = new CustomMnrFileAtchVO[customMnrFileAtchVOs.length];
				for ( int i=0; i<customMnrFileAtchVOs.length; i++ ) {
					CustomMnrFileAtchVO customMnrFileAtchVO = new CustomMnrFileAtchVO();
					if (customMnrFileAtchVOs[i].getIbflag().equals("D")){
						customMnrFileAtchVO.setFileSeq(customMnrFileAtchVOs[i].getFileSeq());
						customMnrFileAtchVO.setFileDtlSeq(customMnrFileAtchVOs[i].getFileDtlSeq());
						delChk="Y";
					}
					newCustomMnrFileAtchVOs[i] = customMnrFileAtchVO;
				}
				if(delChk.equals("Y")){
					interfaceGRPVO.setCustomMnrFileAtchVOs(newCustomMnrFileAtchVOs);
					command2.removeFileUploadBasic(interfaceGRPVO, account);
				}
			}

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
	 * EES_MNR_0029 : Delete <br>
	 * [EES_MNR_0029]FQA Result Creation���뺣낫瑜���젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeFQAResultService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0029Event event = (EesMnr0029Event)e;
		FQAResultMgtBC command = new FQAResultMgtBCImpl();
		InterfaceMgtBC command2 = new  InterfaceMgtBCImpl();

		try{
			begin();
			FQAResultMgtGRPVO fQAResultMgtGRPVO = new FQAResultMgtGRPVO();
			fQAResultMgtGRPVO.setMnrFieldQualityAuditResultVOs(event.getMnrFieldQualityAuditResultVOS());
			fQAResultMgtGRPVO.setFQAResultMgtINVO(event.getFQAResultMgtINVO());

			command.removeFQAResultBasic(fQAResultMgtGRPVO, account);

			String fileSeq ="";
			MnrFieldQualityAuditResultVO[] mnrFieldQualityAuditResultVO = fQAResultMgtGRPVO.getArrayMnrFieldQualityAuditResultVOs();
			if(mnrFieldQualityAuditResultVO != null){
				for ( int i=0; i<mnrFieldQualityAuditResultVO.length; i++ ) {
					if (!mnrFieldQualityAuditResultVO[i].getFileSeq().equals("0")){
						fileSeq = mnrFieldQualityAuditResultVO[i].getFileSeq();
						break;
					}
				}

			}
			command2.removeFileUploadAllBasic(fileSeq, account);
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
	 * EES_MNR_0107 : Retrieve <br>
	 * [EES_MNR_0107]DV Factor���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDVFactorListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0107Event event = (EesMnr0107Event)e;
		DVFactorMgtBC command = new DVFactorMgtBCImpl();
		DVFactorGRPVO dVFactorGRPVO = new DVFactorGRPVO();
		dVFactorGRPVO.setDVFactorINVO(event.getDVFactorINVO());
		dVFactorGRPVO = command.searchDVFactorListBasic(dVFactorGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		//�ㅼ쨷議고쉶
		for (int i = 0; i < dVFactorGRPVO.getListCustomMnrEqDpcVOs().size(); i++) {
		    eventResponse.setRsVoList(dVFactorGRPVO.getListCustomMnrEqDpcVOs().get(i));
		}

		return eventResponse;
	}
	/**
	 * EES_MNR_0107 : Save <br>
	 * [EES_MNR_0107]DV Factor���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDVFactorService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0107Event event = (EesMnr0107Event)e;
		DVFactorMgtBC command = new DVFactorMgtBCImpl();

		try{
			begin();

			DVFactorGRPVO dVFactorGRPVO = new DVFactorGRPVO();
			dVFactorGRPVO.setArrayCustomMnrEqDpcVOs(event.getCustomMnrEqDpcVOs());
			command.manageDVFactorBasic(dVFactorGRPVO,account);

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
	 * EES_MNR_0170 : Retrieve <br>
	 * [EES_MNR_0170]Reefer Unit Warranty Period���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWarrantyAlertListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0170Event event = (EesMnr0170Event)e;
		WarrantyMgtBC command = new WarrantyMgtBCImpl();
		WarrantyAlertListGRPVO warrantyAlertListGRPVO = new WarrantyAlertListGRPVO();
		warrantyAlertListGRPVO.setWarrantyAlertListINVO(event.getWarrantyAlertListINVO());
		warrantyAlertListGRPVO = command.searchWarrantyAlertListBasic(warrantyAlertListGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    eventResponse.setRsVoList(warrantyAlertListGRPVO.getCustomWarrantyAlertListVOS());

		return eventResponse;
	}

	/**
	 * EES_MNR_0170 : Save <br>
	 * [EES_MNR_0170]Reefer Unit Warranty Period���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageWarrantyAlertService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0170Event event = (EesMnr0170Event)e;
		EQFlagMgtBC command = new EQFlagMgtBCImpl();

		try{
			begin();

			WarrantyAlertListGRPVO warrantyAlertListGRPVO = new WarrantyAlertListGRPVO();
			warrantyAlertListGRPVO.setArrCustomWarrantyAlertListVOS(event.getCustomWarrantyAlertListVOs());
			command.manageWarrantyAlertBasic(warrantyAlertListGRPVO, account);

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
	 * EES_MNR_0110 : Retrieve <br>
	 * [EES_MNR_0110]Hanger Bar Inventory List���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHangerInventoryListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0110Event event = (EesMnr0110Event)e;
		HangerInventoryMgtBC command = new HangerInventoryMgtBCImpl();
		HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();

		hangerInventoryListGRPVO.setHangerInventoryListINVO(event.getHangerInventoryListINVO());


		hangerInventoryListGRPVO = command.searchHangerInventoryListBasic(hangerInventoryListGRPVO, account);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		eventResponse.setRsVoList(hangerInventoryListGRPVO.getCustomHangerInventoryListVOs());


		return eventResponse;
	}
	/**
	 * EES_MNR_0110 : Save <br>
	 * [EES_MNR_0110]Hanger Bar Inventory List���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHangerInventoryService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0110Event event = (EesMnr0110Event)e;
		HangerInventoryMgtBC command = new HangerInventoryMgtBCImpl();

		try{
			begin();
			HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();

			hangerInventoryListGRPVO.setArrCustomHangerInventoryListVOs(event.getCustomHangerInventoryListVOs());

			command.manageHangerInventoryBasic(hangerInventoryListGRPVO, account);
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
	 * EES_MNR_0113 : Retrieve <br>
	 * [EES_MNR_0113]Hanger Bar Inventory List���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNewHangerInventoryListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0113Event event = (EesMnr0113Event)e;
		HangerInventoryMgtBC command = new HangerInventoryMgtBCImpl();
		HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();

		hangerInventoryListGRPVO.setHangerInventoryListINVO(event.getHangerInventoryListINVO());


		hangerInventoryListGRPVO = command.searchNewHangerInventoryListBasic(hangerInventoryListGRPVO, account);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		eventResponse.setRsVoList(hangerInventoryListGRPVO.getCustomNewHangerInventoryListVOs());


		return eventResponse;
	}
	/**
	 * EES_MNR_0113 : Save <br>
	 * [EES_MNR_0113]Hanger Bar Inventory List���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageNewHangerInventoryService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0113Event event = (EesMnr0113Event)e;
		HangerInventoryMgtBC command = new HangerInventoryMgtBCImpl();

		try{
			begin();
			HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();

			hangerInventoryListGRPVO.setArrCustomNewHangerInventoryListVOs(event.getCustomNewHangerInventoryListVOs());

			command.manageNewHangerInventoryBasic(hangerInventoryListGRPVO, account);
			
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
	 * EES_MNR_0214 : Retrieve <br>
	 * [EES_MNR_0214]Vessel Reefer Spare Part Purchase W/O Creation���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFsparePartCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)


		ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();
		RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO = new RFSparePartCodeMgtGRPVO();

		if(e.getEventName().equalsIgnoreCase("EesMnr0137Event")){
			EesMnr0137Event event = (EesMnr0137Event)e;
			rfSparePartCodeMgtGRPVO.setRFSparePartCodeMgtINVO(event.getRFSparePartCodeMgtINVO());
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0214Event")){
			EesMnr0214Event event = (EesMnr0214Event)e;
			rfSparePartCodeMgtGRPVO.setRFSparePartCodeMgtINVO(event.getRFSparePartCodeMgtINVO());
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0198Event")){
			EesMnr0198Event event = (EesMnr0198Event)e;
			rfSparePartCodeMgtGRPVO.setRFSparePartCodeMgtINVO(event.getRFSparePartCodeMgtINVO());
		}
		rfSparePartCodeMgtGRPVO = command.searchRFsparePartCodeListBasic(rfSparePartCodeMgtGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		eventResponse.setRsVoList(rfSparePartCodeMgtGRPVO.getMnrReeferSparePartCodeVOs());


		return eventResponse;
	}
	/**
	 * EES_MNR_0137 : Save <br>
	 * [EES_MNR_0137]Standard Reefer Spare Parts List of the vsl���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRFsparePartCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0137Event event = (EesMnr0137Event)e;
		ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();

		try{
			begin();
			RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO = new RFSparePartCodeMgtGRPVO();
			rfSparePartCodeMgtGRPVO.setArrayMnrReeferSparePartCodeVOs(event.getMnrReeferSparePartCodeVOs());
			command.manageRFsparePartCodeBasic(rfSparePartCodeMgtGRPVO, account);
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
	 * EES_MNR_0056 : Retrieve <br>
	 * [EES_MNR_0056]VSL Reefer Spare part Inventory���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFSparePartInventoryListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)


		ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();
		RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO = new RFSparePartInventoryMgtGRPVO();

		EesMnr0056Event event = (EesMnr0056Event)e;
		rfSparePartInventoryMgtGRPVO.setRFSparePartInventoryMgtINVO(event.getRFSparePartInventoryMgtINVO());

		rfSparePartInventoryMgtGRPVO = command.searchRFSparePartInventoryListBasic(rfSparePartInventoryMgtGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		eventResponse.setRsVoList(rfSparePartInventoryMgtGRPVO.getRFSparePartInventoryListVOs());


		return eventResponse;
	}
	/**
	 * EES_MNR_0056 : Save <br>
	 * [EES_MNR_0056]VSL Reefer Spare part Inventory���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRFSparePartInventoryService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0056Event event = (EesMnr0056Event)e;
		ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();

		try{
			begin();
			RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO = new RFSparePartInventoryMgtGRPVO();

			rfSparePartInventoryMgtGRPVO.setArrayRFSparePartInventoryListVOs(event.getRFSparePartInventoryListVOs());

			command.manageRFSparePartInventoryBasic(rfSparePartInventoryMgtGRPVO, account);
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
	 * EES_MNR_0155 : Retrieve <br>
	 * [EES_MNR_0155]Disposal Buyer Management���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalPartnerListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PartnerMgtBC command = new PartnerMgtBCImpl();
		DisposalPartnerGRPVO disposalPartnerGRPVO = new DisposalPartnerGRPVO();

		EesMnr0155Event event = (EesMnr0155Event)e;
		disposalPartnerGRPVO.setDisposalPartnerMgtINVO(event.getDisposalPartnerMgtINVO());
		disposalPartnerGRPVO = command.searchDisposalPartnerListBasic(disposalPartnerGRPVO, account);

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(disposalPartnerGRPVO.getCustomMnrPartnerVOS());
		if(!event.getDisposalPartnerMgtINVO().getFGubuns().equalsIgnoreCase("EXIST"))
		{
			eventResponse.setRsVoList(disposalPartnerGRPVO.getCustomMnrPrnrCntcPntVOS());
		}

		return eventResponse;
	}
	/**
	 * EES_MNR_0155 : Save <br>
	 * [EES_MNR_0155]Disposal Buyer Management���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDisposalPartnerService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0155Event event = (EesMnr0155Event)e;
		PartnerMgtBC command = new PartnerMgtBCImpl();

		try{
			begin();
			DisposalPartnerGRPVO disposalPartnerGRPVO = new DisposalPartnerGRPVO();
			disposalPartnerGRPVO.setCustomMnrPartnerVO(event.getCustomMnrPartnerVO());
			disposalPartnerGRPVO.setArrayCustomMnrPartnerVOs(event.getCustomMnrPartnerVOs());
			disposalPartnerGRPVO.setArrayCustomMnrPrnrCntcPntVOs(event.getCustomMnrPrnrCntcPntVOs());

			command.manageDisposalPartnerBasic(disposalPartnerGRPVO, account);
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
	 * EES_MNR_0155 : Delete <br>
	 * [EES_MNR_0155]Disposal Buyer Management���뺣낫瑜���젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeDisposalPartnerService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0155Event event = (EesMnr0155Event)e;
		PartnerMgtBC command = new PartnerMgtBCImpl();

		try{
			begin();
			DisposalPartnerGRPVO disposalPartnerGRPVO = new DisposalPartnerGRPVO();
			disposalPartnerGRPVO.setCustomMnrPartnerVO(event.getCustomMnrPartnerVO());
			command.removeDisposalPartnerBasic(disposalPartnerGRPVO);
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
	 * EES_MNR_0222 : Retrieve <br>
	 * [EES_MNR_0222]FQA Result Inquiry���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFQAListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0222Event event = (EesMnr0222Event)e;
		FQAResultMgtBC command = new FQAResultMgtBCImpl();

		FQAResultMgtGRPVO fQAResultMgtGRPVO = new FQAResultMgtGRPVO();
		fQAResultMgtGRPVO.setFQAResultMgtINVO((event.getFQAResultMgtINVO()));
		fQAResultMgtGRPVO = command.searchFQAListBasic(fQAResultMgtGRPVO);

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(fQAResultMgtGRPVO.getMnrFieldQualityAuditResultVOS());

		return eventResponse;
	}

	/**
	 * EES_MNR_0224 : Retrieve <br>
	 * [EES_MNR_0224]Hanger Bar Inventory History Pop Up���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHangerInventoryDetailListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0224Event event = (EesMnr0224Event)e;
		HangerInventoryMgtBC command = new HangerInventoryMgtBCImpl();
		HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();

		hangerInventoryListGRPVO.setHangerInventoryListINVO(event.getHangerInventoryListINVO());

		hangerInventoryListGRPVO = command.searchHangerInventoryDetailListBasic(hangerInventoryListGRPVO, account);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		eventResponse.setRsVoList(hangerInventoryListGRPVO.getCustomHangerInventoryListVOs());

		return eventResponse;
	}

	/**
	 * EES_MNR_0249 : doActionIBSheet <br>
	 * [EES_MNR_0249]DV Leased Unit���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDvLeasedUnitService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0249Event event = (EesMnr0249Event)e;
		DVFactorMgtBC command = new DVFactorMgtBCImpl();
		DvLeasedUnitINGRPVO dvLeasedUnitINGRPVO = new DvLeasedUnitINGRPVO();

		dvLeasedUnitINGRPVO.setDvLeasedUnitINVO(event.getDvLeasedUnitINVO());
		dvLeasedUnitINGRPVO = command.searchDvLeasedUnitListBasic(dvLeasedUnitINGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//議고쉶
		eventResponse.setRsVoList(dvLeasedUnitINGRPVO.getDvLeasedUnitVOs());
		return eventResponse;
	}

	/**
	 * EES_MNR_0249 : Save <br>
	 * [EES_MNR_0249]DV Leased Unit���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDvLeasedUnitService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0249Event event = (EesMnr0249Event)e;
		DVFactorMgtBC command = new DVFactorMgtBCImpl();
		try{
			begin();
			DvLeasedUnitINGRPVO dvLeasedUnitINGRPVO = new DvLeasedUnitINGRPVO();
			dvLeasedUnitINGRPVO.setArrayDvLeasedUnitVOs(event.getDvLeasedUnitVOs());

			command.manageDvLeasedUnitListBasic(dvLeasedUnitINGRPVO, account);
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
	 * EES_MNR_0253 : doActionIBSheet <br>
	 * [EES_MNR_0253]Container Seal No-Creation���뺣낫瑜�議고쉶 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerSealNoCreationService(Event e) throws EventException {
		EesMnr0253Event event = (EesMnr0253Event)e;
		DVFactorMgtBC command = new DVFactorMgtBCImpl();

		ContainerSealNoCreationGRPVO containerSealNoCreationGRPVO = new ContainerSealNoCreationGRPVO();

		containerSealNoCreationGRPVO.setContainerSealNoCreationVO(event.getContainerSealNoCreationVO());
		containerSealNoCreationGRPVO = command.searchSealRangeCreationListBasic(containerSealNoCreationGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//議고쉶
		eventResponse.setRsVoList(containerSealNoCreationGRPVO.getContainerSealNoCreationVOs());
		return eventResponse;
	}

	/**
	 * EES_MNR_0253 : Save <br>
	 * [EES_MNR_0253]Container Seal No-Creation���뺣낫瑜�異붽�/�섏젙/��젣 �⑸땲�� <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContainerSealNoCreationService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0253Event event = (EesMnr0253Event)e;
		DVFactorMgtBC command = new DVFactorMgtBCImpl();
		try{
			begin();
			ContainerSealNoCreationGRPVO containerSealNoCreationGRPVO = new ContainerSealNoCreationGRPVO();
			containerSealNoCreationGRPVO.setArrayContainerSealNoCreationVOs(event.getContainerSealNoCreationVOs());

			List<ContainerSealNoCreationVO> list = command.manageSealRangeCreationListBasic(event.getContainerSealNoCreationVOs(),account);
			commit();
			eventResponse.setRsVoList(list);
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
	 * EES_MNR_0254 : Retrieve<br>
	 * [EES_MNR_0254] Container Seal Inquiry 紐⑸줉 議고쉶<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchContainerSealInquiry(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EesMnr0254Event event = (EesMnr0254Event) e;
//		DVFactorMgtBC command = new DVFactorMgtBCImpl();
//
//		try{
//			// Container Seal Inquiry 紐⑸줉 議고쉶
//			List<ContainerSealInquiryVO> list = command.searchContainerSealInquiryList(event.getContainerSealInquiryVO());
//			eventResponse.setRsVoList(list);
//			// Container Seal Inquiry 移댁슫��Out of Range) 議고쉶
//			String outQty = command.searchContainerSealInquiryCount(event.getContainerSealInquiryVO());
//			eventResponse.setETCData("out_qty", outQty);
//		}catch(EventException ex){
//			throw ex;
//		}catch(Exception ex){
//			throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;
//	}
	
	/**
	 * EES_MNR_0254 : Retrieve-BackEndJob <br>
	 * Container Seal Inquiry 紐⑸줉 議고쉶 <br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchBackEndContainerSealInquiryService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0254Event event = (EesMnr0254Event)e;
		DVFactorMgtBC command = new DVFactorMgtBCImpl();

		try{
			String status1 = command.searchBackEndCntrSealListBasic(event.getContainerSealInquiryVO(), account);
			String status2 = command.searchBackEndCntrSealCountBasic(event.getContainerSealInquiryVO(), account);
			
			eventResponse.setETCData("BackEndJobKey1", status1);
			eventResponse.setETCData("BackEndJobKey2", status2);

		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001",new String[]{"[M&R Expense Plan/PFMC Inquiry] searchBackEndExpensePFMCListService"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0254 : BackEndJob<br>
	 * BackEndJob���ㅽ뻾寃곌낵����븳 �곹깭媛믪쓣 議고쉶�⑸땲��<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0254Event event = (EesMnr0254Event)e;
		String key1 = event.getContainerSealInquiryVO().getBackEndJobKey1();
		String key2 = event.getContainerSealInquiryVO().getBackEndJobKey2();
		              
		try {
			DVFactorMgtBC command = new DVFactorMgtBCImpl();

			String status1 = command.searchComBackEndJobStatusBasic(key1);
			String status2 = command.searchComBackEndJobStatusBasic(key2);
			
			eventResponse.setETCData("jb_sts_flg1", status1);
			eventResponse.setETCData("jb_sts_flg2", status2);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001",new String[]{"[M&R Expense Plan/PFMC Inquiry] searchComBackEndJobStatusService"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0254 : BackEndJob<br>
	 * BackEndJob���ㅽ뻾寃곌낵濡��앹꽦���뚯씪��濡쒕뱶�⑸땲��<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadFileBackEndJobResultService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0254Event event = (EesMnr0254Event)e;
		String key1 = event.getContainerSealInquiryVO().getBackEndJobKey1();
		String key2 = event.getContainerSealInquiryVO().getBackEndJobKey2();
		List list = null;
		String outQty = "";

		try {
				list = (List<ContainerSealInquiryVO>)BackEndJobResult.loadFromFile(key1);
				outQty = (String)BackEndJobResult.loadFromFile(key2);

				eventResponse.setRsVoList(list);
				eventResponse.setETCData("out_qty", outQty);
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * EES_MNR_0265 <br>
	 * Write Off Approval Step��議고쉶�쒕떎.<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchApprovalStepInquiryService(Event e) throws EventException {
		try {	
			
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0265Event event = (EesMnr0265Event)e;			
			ApprovalStepMgtBC command = new ApprovalStepMgtBCImpl();
			ApprovalStepGRPVO approvalStepGRPVO = new ApprovalStepGRPVO();
			
			approvalStepGRPVO = command.searchApprovalStepRankBasic(event.getApprovalStepGRPVO(), account);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(approvalStepGRPVO.getListCustomMnrAproStepVO());
			
			return eventResponse;
			
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}


	/**
	 * EES_MNR_0265 <br>
	 * Write Off Approval Step���앹꽦 諛�蹂�꼍�쒕떎. .<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse manageApprovalStepCreationService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0265Event event = (EesMnr0265Event)e;
		ApprovalStepMgtBC command = new ApprovalStepMgtBCImpl();
		
		try {
			begin();
			
			command.manageApprovalStepBasic(event.getApprovalStepGRPVO(), account);
			
			commit();
		} catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0256 : Retrieve<br>
	 * Office Code 瑜�泥댄겕�⑸땲��<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkOfficeService(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		ApprovalStepMgtBC command = new ApprovalStepMgtBCImpl();
		EesMnr0265Event event = (EesMnr0265Event)e;
		try{
			boolean isCheck = command.checkOfficeBasic(event.getApprovalStepGRPVO().getApprovalStepINVO());
	
			eventResponse.setETCData("ISOFFICE", isCheck ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_MNR_0256 : Retrieve<br>
	 * Office Code 瑜�泥댄겕�⑸땲��<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkAproOfcService(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		ApprovalStepMgtBC command = new ApprovalStepMgtBCImpl();
		EesMnr0265Event event = (EesMnr0265Event)e;
		try{
			boolean isCheck = command.checkAproOfcBasic(event.getApprovalStepGRPVO().getApprovalStepINVO());
	
			eventResponse.setETCData("ISDUPOFFICE", isCheck ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_MNR_0265 <br>
	 * User Name ��議고쉶�쒕떎<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserNameService(Event e) throws EventException {
		try {	
			
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0265Event event = (EesMnr0265Event)e;			
			ApprovalStepMgtBC command = new ApprovalStepMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			List<CustomApprovalStepVO> list = command.searchUserNameBasic(event.getApprovalStepGRPVO().getApprovalStepINVO(), account);
			
			if(list != null && list.size() > 0){
				eventResponse.setETCData("USER_NAME", list.get(0).getUsrNm());
				eventResponse.setETCData("OFC_CD", list.get(0).getOfcCd());
			}else{
				eventResponse.setETCData("USER_NAME", "");
				eventResponse.setETCData("OFC_CD", "");
			}
			
			return eventResponse;
			
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}

	/**
	 * EES_MNR_0266 <br>
	 * Space Part VSL Inventory Code의 최근 버전 목록을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslSprPrtCd(RFVessleSparePartCodeVO rFVessleSparePartCodeVO) throws EventException{
		try {	
			log.debug("searchVslInventoryCode");		
			ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<RFVessleSparePartCodeVO> list = command.searchVesselSparePartCodeList(rFVessleSparePartCodeVO);
			eventResponse.setRsVoList(list);
			return eventResponse;
			
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0266 <br>
	 * Space Part VSL Inventory Code를 생성 및 변경한다. .<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse manageVslSparePartCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0266Event event = (EesMnr0266Event)e;
		ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();
		
		try {
			begin();
			log.debug("vsl save start");
			command.manageVslSprPrtCd(event.getRFVessleSparePartCodeVOs(), event.getRFVessleSparePartCodeVO(), account);
			log.debug("vsl save end");
			commit();
		} catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * VSL Inventory의 Header 조회
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchVslInventoryHeader(Event e) throws EventException{
		try {	
			EesMnr0267Event event = (EesMnr0267Event)e;			
			ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<MnrVslSprPrtInvtVO> list = command.searchVesselSparePartInventoryHeaderList(event.getMnrVslSprPrtInvtVO(), account);
			log.debug("list");
			eventResponse.setRsVoList(list);
			return eventResponse;
			
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}	
	/**
	 * EES_MNR_0267
	 * Vessel Inventory 조회
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse searchVslInventory(Event e) throws EventException{
		try {	
			EesMnr0267Event event = (EesMnr0267Event)e;			
			ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse = (GeneralEventResponse) command.searchVesselInventoryList(event);

			return eventResponse;
			
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	/**
	 * EES_MNR_0267
	 * Vessel Inventory 저장
	 * @param e
	 * @throws EventException
	 * @return EventResponse
	 */
	private EventResponse manageVslInventory(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0267Event event = (EesMnr0267Event)e;
		ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();
		try {
			begin();
			log.debug("vsl save start");
			String invtNo = command.manageVslInventoryCreation(event.getMnrVslSprPrtInvtVOs(), event.getMnrVslSprPrtInvtVO(), account);
			eventResponse.setETCData("INVENTORY_NO", invtNo);
			
			// 재조회
			//event.getMnrVslSprPrtInvtVO().setSprPrtInvtNo(invtNo);
			//eventResponse = (GeneralEventResponse) command.searchVesselInventoryList(event);
			log.debug("vsl save end");
			commit();
		} catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Vessel Inventory 삭제
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeVslInventory(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0267Event event = (EesMnr0267Event)e;
		ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();
		try {
			begin();
			log.debug("vsl save start");
			command.removeVslInventoryCreation(event.getMnrVslSprPrtInvtVOs(), account);
			eventResponse = (GeneralEventResponse) command.searchVesselInventoryList(event);
//			eventResponse.setETCData("CRE_DT", isCheck ? "Y" : "N");
//			eventResponse.setETCData("C", isCheck ? "Y" : "N");
//			eventResponse.setETCData("FILED", isCheck ? "Y" : "N");
			log.debug("vsl save end");
			commit();
		} catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_MNR_0268 <br>
	 * Space Part VSL Inventory Inquiry의 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselSparePartInventoryList(Event e) throws EventException{
		try {	
			
			EesMnr0268Event event = (EesMnr0268Event)e;			
			ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<MnrVslSprPrtInvtVO> list = command.searchVesselSparePartInventoryList(event.getMnrVslSprPrtInvtVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
			
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0273 <br>
	 * On-site Inspection Result Creation: 1. 첫 실행일 경우 초기와 후 조회 2. 첫 실행이 아닐 경우 조회기능만 작동<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchOnsiteInspectionResult(Event e) throws EventException{
		try {	
			
			EesMnr0273Event event = (EesMnr0273Event)e;			
			OnsiteInspectionResultMgtBC command = new OnsiteInspectionResultMgtBCImpl();
			InterfaceMgtBC command2 = new  InterfaceMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			List<MnrOnSiteVO> list = command.searchMnrOnsiteInspectionResultDetail(event.getMnrOnSiteVO());
			
			String fileSeq ="";
			
			fileSeq = list.get(0).getFileSeq();
			
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			interfaceGRPVO = command2.searchFileUploadBasic(fileSeq, account);

			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(interfaceGRPVO.getListCustomMnrFileAtchVOs());
			commit();
			
			return eventResponse;
			
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0273 <br>
	 * On-site Inspection Result Creation: Inspection Result 현황을 업데이트<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse updateOnsiteInspectionResult(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0273Event event = (EesMnr0273Event)e;			
		OnsiteInspectionResultMgtBC command = new OnsiteInspectionResultMgtBCImpl();
		
		try {
			begin();
			command.updateMnrOnsiteInspectionResultDetail(event.getMnrOnSiteVOs());
		    commit();
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0273 <br>
	 * On-site Inspection Result Creation: Inspection Result 를 삭제<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private GeneralEventResponse deleteOnsiteInspectionResult(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0273Event event = (EesMnr0273Event)e;			
		OnsiteInspectionResultMgtBC command = new OnsiteInspectionResultMgtBCImpl();
		
		
		try {	
			begin();
			command.deleteMnrOnsiteInspectionResultDetail(event.getMnrOnSiteVO());
			commit();
		} catch(EventException ex){
			rollback(); 
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0271 <br>
	 * On-site Inspection Result Inquiry<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchOnsiteInspectionResultHeader(Event e) throws EventException{
		try {	
			
			EesMnr0271Event event = (EesMnr0271Event)e;			
			OnsiteInspectionResultMgtBC command = new OnsiteInspectionResultMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<MnrOnSiteVO> list = command.searchMnrOnsiteInspectionResultHeader(event.getMnrOnSiteVO());
			
			List<MnrOnSite2VO> list2 = command.searchMnrOnsiteInspectionResultHeader2(event.getMnrOnSite2VO());
		    
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
			
			return eventResponse;
			
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0274 <br>
	 * On-site Inspection Result Item Management<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchOnsiteInspectionResultItems(Event e) throws EventException{
		try {	
			
			EesMnr0274Event event = (EesMnr0274Event)e;			
			OnsiteInspectionResultMgtBC command = new OnsiteInspectionResultMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<MnrOnSiteVO> list = command.searchOnsiteInspectionResultItems(event.getMnrOnSiteVO());
			

			eventResponse.setRsVoList(list);
			
			return eventResponse;
			
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0274 <br>
	 * On-site Inspection Result Item Management: 설문항목을 변경<br>
	 *
	 * @param Event e
	 * @exception EventException
	 */
	private void insertOnsiteInspectionResultItems(Event e) throws EventException{
		try {	
			
			EesMnr0274Event event = (EesMnr0274Event)e;			
			OnsiteInspectionResultMgtBC command = new OnsiteInspectionResultMgtBCImpl();
			begin();
			command.insertOnsiteInspectionResultItems(event.getMnrOnSiteVOs());
			commit();
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
	}
}
