/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : commoncodeSC.java
*@FileTitle : account
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0 
*@history
*	2014-12-03 Chang Young Kim Release Test �섏젙
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode;
  
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.colatech.eai.client.framework.core.TransferType;
import com.colatech.eai.client.framework.core.send.WebLogicQueueClient;
import com.hanjin.apps.alps.bcm.ccd.ccdcommon.ccdcommon.basic.CcdCommonBC;
import com.hanjin.apps.alps.bcm.ccd.ccdcommon.ccdcommon.basic.CcdCommonBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.basic.AccountBC;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.basic.AccountBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.event.BcmCcd0001Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.event.BcmCcd0002Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.event.BcmCcd0003Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.event.BcmCcd0004Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.vo.AccountVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.vo.ChargeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.vo.CurrencyVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.vo.RepChargeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.basic.AssetBC;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.basic.AssetBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.event.BcmCcd0005Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.event.BcmCcd0006Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.event.BcmCcd0007Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.event.BcmCcd0008Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerSizeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerTypeSizeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerTypeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerVesselVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.basic.CommodityBC;
import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.basic.CommodityBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.event.BcmCcd0009Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.event.BcmCcd0010Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.event.BcmCcd0011Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.event.BcmCcd0012Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.event.BcmCcd0013Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.vo.CommodityVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.vo.CustPackageTypeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.vo.GrpCommodityVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.vo.PackageTypeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.vo.RepCommodityVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.basic.LocationBC;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.basic.LocationBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0014Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0015Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0016Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0017Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0018Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0019Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0020Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0021Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0022Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0023Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0024Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.ContinentVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.CountryVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.DaySavingTimeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.EqOrgChartVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LocationVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LseComYardVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.RegionVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.StateVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.SubContinentVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.YardVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.ZoneDtlVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.ZoneGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.basic.MstMgmtBC;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.basic.MstMgmtBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.event.BcmCcd2001Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.event.BcmCcd2002Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.event.BcmCcd2003Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.event.BcmCcd2004Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmUsrAuthVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.SearchMdmHistListVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.SearchMdmHistoryListVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.basic.OrganizationBC;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.basic.OrganizationBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.event.BcmCcd0032Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.event.BcmCcd0041Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.event.BcmCcd0042Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo.OfcAccGrpMapVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo.OfcAccGrpVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo.OfficeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.basic.PartnerBC;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.basic.PartnerBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd0034Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd0035Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd0036Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd0037Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd0038Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd0039Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd0040Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd0053Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd0054Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd1035Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd1038Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd1040Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CarrierVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CreditCustomerVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerAddressVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerContactVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerIntegrationVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerPerformanceVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.SearchSimilarVendorNameVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorClassificationVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorContactVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.basic.ReportBC;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.basic.ReportBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.event.BcmCcd0043Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.event.BcmCcd0044Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.event.BcmCcd0045Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.event.BcmCcd0046Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.event.BcmCcd0047Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.event.BcmCcd0048Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.event.BcmCcd0049Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.event.BcmCcd0050Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.event.BcmCcd0051Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.ChargeReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.CustomerReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.LocationReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.OfficeReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.SearchOfficHierarchyVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.VendorReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.VesselReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.YardReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.ZoneReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.basic.SalesRepresentativeBC;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.basic.SalesRepresentativeBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.event.BcmCcd0033Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.vo.SalesRepVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.basic.ServiceBC;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.basic.ServiceBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.event.BcmCcd0025Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.event.BcmCcd0026Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.event.BcmCcd0027Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.event.BcmCcd0028Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.event.BcmCcd0029Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.event.BcmCcd0030Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.event.BcmCcd0031Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ActivityVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.MovementStatusVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.RLaneDtlVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.RLaneGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SLaneDirVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SLaneGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ScopeGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ScopeLaneVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ScopeLimitVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SubTradeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.TradeVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CreditCustomerVO;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.basic.PrdCommonManageBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.BkgSalesRepVO;
//import com.hanjin.apps.alps.esm.sam.generalinfomanage.customerinfomanage.basic.CustomerInfoManageBC;
//import com.hanjin.apps.alps.esm.sam.generalinfomanage.customerinfomanage.basic.CustomerInfoManageBCImpl;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-commoncode Business Logic ServiceCommand 
 * OPUS-commoncode handling business transaction.
 * 
 * @author 
 * @see
 * @since 
 */

public class CommonCodeSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * commoncode system preceding process for biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("commoncodeSC begin");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * commoncode system biz scenario closing<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("commoncodeSC end");
	}

	/**
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("BcmCcd0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccountCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAccountCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = checkAcctCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					eventResponse = checkCntCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageChargeCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchChargeRqst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageChargeRqst(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepChgCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRepChgCodeChk(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRepChgCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCurrCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkCntCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCurrCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainerType(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageContainerType(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainerSize(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageContainerSize(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainerTypeSize(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageContainerTypeSize(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainerVessel(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchContainerVesselRqst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkCrrCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkCntCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkLocCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageContainerVessel(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageContainerVesselRqst(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGroupCommodity(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageGroupCommodity(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepCommodity(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRepCommodity(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCommodity(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCommodityRqst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCommodity(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCommodityRqst(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustPackageType(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkCntCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCustPackageType(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackageType(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePackageType(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContiCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageContiCode ( e );
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSubContiCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSubContiCode ( e );
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCountryCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkSubConti ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkCurrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCountryCode ( e );
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRegionCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkCntCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRegionCode ( e );
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStateCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkCntCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageStateCode ( e );
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLocCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkSubConti ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkCntCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkRgnCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkStateCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkSccCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = checkZoneCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = checkOfcCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = checkOfcCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkOfcCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = checkYardCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = checkYardCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = checkLocCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchCountryInfo ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLocCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageLocCodeRqst ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchLocCodeRqst ( e );
			}
			
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchYardCode ( e );
			}if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchYardRqst ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkVndrCodeName ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkVndrCodeName ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkVndrCodeName ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkOfcCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkOfcCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = checkZoneCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = checkLocCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = checkLseCoYdCode ( e );
//			2015.01.07 not use EQ SCC
//			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
//				eventResponse = checkSccCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = checkLocSccValidation ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageYardCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageYardRqst ( e );
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchZoneCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageZoneCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchZoneRqst ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageZoneRqst ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkYardCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = checkLocCode ( e );
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEqOrgChtList ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkSccCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkLocCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkDelValidation ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEqOrgCht ( e );
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLseCoYd ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLseCoYd ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = checkVndrCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = checkYardCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchComboList ( e );
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDyLgtSavTm ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDyLgtSavTm ( e );	
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				// 멀티저장 
				eventResponse = manageDyLgtMultiSavTm ( e );	
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkCntCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkStateCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDstCodeSeq ( e );
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchActCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageActCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0026Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMvmtStsCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageMvmtStsCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRlaneCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchRlaneCodeRqst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageRlaneCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageRlaneCodeRqst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkVslSlanCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSlaneCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSlaneCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchSlaneRqst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageSlaneRqst(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchScpCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageScpCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchScpRqst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageScpRqst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkVslSlanCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkRgnCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)){
				eventResponse = searchSubContiCode(e);
			}			
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTrdCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageTrdCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchTrdRqst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageTrdRqst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkOfcCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSubTrdCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSubTrdCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchComboList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchOfcCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkOfcCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkLocCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = checkCurrCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkCustCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
                eventResponse = checkVndrCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
                eventResponse = searchVndrCntCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
                eventResponse = checkCtrCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
                eventResponse = checkAcctCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageOfcCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlsRepCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSlsRepCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkCntCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkOfcCode(e);
			}			
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCrrCode(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCrrCode(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchCrrRqst(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageCrrRqst(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchCustCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = checkCntCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = checkLocCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				eventResponse = checkOfcCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)){
				eventResponse = checkVndrCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)){
				eventResponse = checkCurrCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)){
				eventResponse = checkRepCmdt(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageCustCodeTmp(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH08)){
				eventResponse = searchCustMaxSeq(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)){
				eventResponse = checkCustCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)){
				eventResponse = checkSlsRepCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH11)){
				eventResponse = checkGrpCustCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){	// Authority Mgmt added
				eventResponse = manageCustRqst(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)){	// Authority Mgmt added
				eventResponse = searchCustRqst(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)){	// check Legacy Code(SAP ID)
				eventResponse = isLegacyCodeUnique(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH14)){	// check Legacy Code(SAP ID)
				eventResponse = checkCntCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH15)){	
				eventResponse = checkExistCustCode(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchCustAddrCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
	                eventResponse = manageCustAddrCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkCntCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkStateCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkCustCode ( e );
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0037Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchCustCntcCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCustCntcCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkCustCode ( e );
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0038Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustPerfCode(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCustPerfCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkOfcCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkSlsRepCode ( e );
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCustGrpId(e);				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageCustPerfRqst(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchCustPerfRqst(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCrCustCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCrCustCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkOfcCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkCurrCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkCustCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkCustCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVndrCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVndrMaxSeq(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVndrCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkCntCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkLocCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkOfcCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkVndrCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = checkCurrCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageVndrRqst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchVndrRqst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) { // check state code with country code
				eventResponse = checkStateCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkRgstNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = modifyVndrRqstList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd1040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSimilarVendorName(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkCntCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfcAccGrp(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		
				eventResponse = manageOfcAccGrp(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0042Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfcAccGrpMap(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				 eventResponse = checkOfcCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOfcAccGrpMap(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchZoneReportCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				 eventResponse = searchZoneReportCount(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd1035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomerListByName(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd1038Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustGrpList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0046Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchYardReportCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				 eventResponse = searchYardReportCount(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLocationReportList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				 eventResponse = searchLocationReportCount(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0043Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomerReportList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				 eventResponse = checkCntCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				 eventResponse = checkLocCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				 eventResponse = checkOfcCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				 eventResponse = checkCustCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				 eventResponse = searchCustomerReportCnt(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVendorReportList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				 eventResponse = checkLocCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				 eventResponse = checkOfcCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				 eventResponse = checkCntCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				 eventResponse = checkVndrCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				 eventResponse = searchVendorReportCnt(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0048Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeReportList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfficeReportCount(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComboList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchComboList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfficeHierarchyList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd2001Event")) {	// MDM Authority (Authority Management)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchMdmUsrAuthList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
	                eventResponse = manageMdmUsrAuth(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd2002Event")) {	// MDM Authority (Process Status)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAuthTpCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMdmDatProcRqstNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMdmDatProc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) { // check Legacy Code(SAP ID)
				eventResponse = isLegacyCodeUnique(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchMdmDatProcList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	// Approval
				eventResponse = modifyMdmDatProcApproval(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {	// Reject
				eventResponse = modifyMdmDatProcReject(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {	// Re-Open
					eventResponse = modifyMdmDatProc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {	// Delete
				eventResponse = removeMdmDatProc(e);
			}	
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd2003Event")) {	// MDM 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //�뚯씠釉붿숴蹂�
				eventResponse = searchHisComboList(e, "TBL");
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //而щ읆肄ㅻ낫
				eventResponse = searchHisComboList(e, "COL");
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){ //MDM History List
				eventResponse = searchMdmHistoryList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselReportList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVesselReportCount(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComboList(e);	
			}
	   }else if (e.getEventName().equalsIgnoreCase("BcmCcd0050Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeReportList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchChargeReportCount(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComboList(e);	
			}		
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd2004Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){ //MDM History List
				eventResponse = searchMdmHistList(e);
			}	
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0053Event")) {
		    if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
		    	eventResponse = searchRqstVndr(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
		    	eventResponse = manageRqstVndrApro(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
		    	eventResponse = manageRqstVndrRjct(e);
		    } 
	   }else if (e.getEventName().equalsIgnoreCase("BcmCcd0054Event")) {
	   		if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	   			eventResponse = searchVndrList(e);
	   		}
	   }
		return eventResponse;
	}

	
	/**
	 * common : open<br>
	 * Combo list retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComboList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String[][] array = null;
		
		if (e.getEventName().equalsIgnoreCase("BcmCcd0001Event")) {
			array = new String[1][3];
			array[0][0] = "CD00624";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0002Event")) {
			array = new String[5][3];
			array[0][0] = "CD00628";
			array[1][0] = "CD00627";
			array[2][0] = "CD00626";
			array[3][0] = "RepChg";
			array[4][0] = "CD01344";
			//array[5][0] = "CD00631";			
		}
//		else if (e.getEventName().equalsIgnoreCase("BcmCcd0003Event")) {
//
//		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0004Event")) {
//
//		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0005Event")) {
//
//		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0006Event")) {
//
//		}
		else if (e.getEventName().equalsIgnoreCase("BcmCcd0007Event")) {
			array = new String[5][3];
			array[0][0] = "CntrType";
			array[1][0] = "CntrSize";
			array[2][0] = "PsaCode";
			array[2][2] = "Blank";
			array[3][0] = "CD00637";
			array[3][2] = "Blank";
			array[4][0] = "CD01527";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0008Event")) {
			array = new String[5][3];
			array[0][0] = "CD00649";
			array[1][0] = "CD00639";
			//array[1][2] = "Blank";
			array[2][0] = "CD00882";
			array[2][2] = "Blank";
			array[3][0] = "CD20004";
			//array[3][2] = "Blank";
			array[4][0] = "CD00653";
			//array[4][2] = "Blank";
		}
//		else if (e.getEventName().equalsIgnoreCase("BcmCcd0009Event")) {
//
//		}
		else if (e.getEventName().equalsIgnoreCase("BcmCcd0010Event")) {
			array = new String[1][3];
			array[0][0] = "GrpCmdt";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0011Event")) {
			array = new String[3][3];
			array[0][0] = "RepCmdt";	
			array[1][0] = "CD00657";
			array[1][2] = "Blank";
			array[2][0] = "GrpCmdt";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0012Event")) {
			array = new String[1][3];
			array[0][0] = "Package";
		}
//		else if (e.getEventName().equalsIgnoreCase("BcmCcd0013Event")) {
//
//		}
		else if (e.getEventName().equalsIgnoreCase("BcmCcd0015Event")) {
			array = new String[1][3];
			array[0][0] = "CONTI";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0016Event")) {
			array = new String[2][3];
			array[0][0] = "CONTI";
			array[1][0] = "CD00658";
			array[1][2] = "Blank";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0019Event")) {
			array = new String[3][3];
			array[0][0] = "CD00659";
			array[1][0] = "CD00713";
			array[2][0] = "CONTI";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0020Event")) {
			array = new String[4][3];
			array[0][0] = "CD00665";
			array[1][0] = "CD00667";
			array[2][0] = "IntlPhnNo";
			array[2][2] = "Blank";
			array[3][0] = "CD00666";
			array[3][2] = "Blank";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0021Event")) {
			array = new String[1][3];
			array[0][0] = "CD00864";
			array[0][2] = "Blank";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0022Event")) {
			array = new String[1][3];
			array[0][0] = "Rcc";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0023Event")) {
			array = new String[1][3];
			array[0][0] = "IntlPhnNo";
		}
//		else if (e.getEventName().equalsIgnoreCase("BcmCcd0024Event")) {
//
//		}
		else if (e.getEventName().equalsIgnoreCase("BcmCcd0025Event")) {
			array = new String[7][3];
			array[0][0] = "CD00140"; // activity type
			array[1][0] = "CD00136"; // full/empty
			array[1][2] = "Blank";
			
			array[2][0] = "CD30011"; // bnd / skd seq.			
			array[2][2] = "Blank";
			array[3][0] = "CD00859"; // node type
			array[3][2] = "Blank";
			

			array[4][0] = "CD00137"; // operation type
			array[4][2] = "Blank";
			
			array[5][0] = "CD00277"; // trans. mode
			array[5][2] = "Blank";
			
			array[6][0] = "CD00139"; // org/dst
			array[6][2] = "Blank";
			
//			array[7][0] = "CD01109"; // actual flag
//			array[8][0] = "CD01109"; // delt_flg
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0026Event")) {
			array = new String[1][3];
			array[0][0] = "CD00592";
			array[0][2] = "Blank";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0027Event")) {
			array = new String[9][3];
			array[0][0] = "CD00705";
			array[1][0] = "Trade";
			array[2][0] = "CD01109";
			array[3][0] = "CD00883";
			array[4][0] = "CD00206";
			array[5][0] = "Conti";
			array[6][0] = "CD01109";
			array[7][0] = "Trade";
			array[8][0] = "SubTrade";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0028Event")) {
			array = new String[8][3];
			array[0][0] = "CD00717";
			array[1][0] = "CD00705";
			array[2][0] = "CD00653";
			array[3][0] = "CD00652";
			array[4][0] = "CD01109";
			array[5][0] = "CD00883";
			array[6][0] = "CD01109";
			array[7][0] = "CD30049";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0029Event")) {
			array = new String[3][3];
			array[0][0] = "CD00714";
			array[1][0] = "CD01109";
			array[2][0] = "CD00139";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0030Event")) {
			array = new String[4][3];
			array[0][0] = "Conti";
			array[0][2] = "Blank";
			array[1][0] = "Conti";
			array[1][2] = "Blank";
			array[2][0] = "CD00705";
			array[3][0] = "CD01109";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0031Event")) {
			array = new String[2][3];
			array[0][0] = "Trade";
			array[0][2] = "Blank";
			array[1][0] = "CD01109";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0032Event")) {
			array = new String[15][3];  
			array[0][0] = "IntlPhnNo";
			array[1][0] = "CD00818";   //1.Office Type
			array[2][0] = "CD00675";   //2.Office Kind
			array[2][2] = "Blank";
			array[3][0] = "CD00673";   //3.Agent Type
			array[3][2] = "Blank"; 
			array[4][0] = "CD01109";   //4.Inactive Sales Org.
			array[5][0] = "CD01109";   //5.Subsidiary Company Flag
			array[6][0] = "CD00677";   //6.Sales Office DIV
			array[7][0] = "CD30005";   //7.Manual Booking Option
			array[7][2] = "Blank" ;
			array[8][0] = "Office" ;   //8.A/R Regional HQ
			array[8][2] = "Blank" ;
			array[9][0] = "CD30009" ;  //9.Alternate Currency
			
			array[10][0] = "CD01320";   //10.Finance Region
			array[10][2] = "Blank" ;
			
			array[11][0] = "CD30001";   //10.PrepaidParty
//			array[10][2] = "Blank" ;
			array[12][0] = "CD00912";  //11.Sub Agent
			
			array[13][0] = "CD00676";  //12.S/O Interface
			array[13][2] = "Blank"; 
			array[14][0] = "CD01109";  //13.Delete Flag
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0033Event")) {
			array = new String[1][3];
			array[0][0] = "CD00711";   //1. Gender
			array[0][2] = "Blank";
			/*array[1][0] = "CD01109";
			array[1][2] = "Blank";
			array[2][0] = "CD01109";
			array[2][2] = "Blank";
			array[3][0] = "CD01109";*/
		}
//		else if (e.getEventName().equalsIgnoreCase("BcmCcd0034Event")) {
//
//		}
		else if (e.getEventName().equalsIgnoreCase("BcmCcd0035Event")) {
			array = new String[12][3];
			array[0][0] = "CD00693";
			array[0][2] = "Blank";
			array[1][0] = "CD00697";
			array[1][2] = "Blank";
			array[2][0] = "CD30045"; //"CD00694";
			array[2][2] = "Blank";
			array[3][0] = "CD30046"; //"CD00695";
			array[3][2] = "Blank";
			//array[4][0] = "CD00696";
			//array[4][2] = "Blank";
			array[4][0] = "CD30047"; //"CD00698";
			//array[4][2] = "Blank";
			array[5][0] = "CD00692";
			array[5][2] = "Blank";
			array[6][0] = "CD20090";
			array[6][2] = "Blank";
			array[7][0] = "CD01109";
			array[8][0] = "CD30006";
			array[9][0] = "CD30007";
			array[10][0] = "CD30008";
			array[10][2] = "Blank";
			array[11][0] = "CD30044";
			array[11][2] = "Blank";

		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0036Event")) {
			array = new String[1][3];
			array[0][0] = "CD00699";
			array[0][2] = "Blank";
			

		}
//		else if (e.getEventName().equalsIgnoreCase("BcmCcd0037Event")) {
//
//		}
		else if (e.getEventName().equalsIgnoreCase("BcmCcd0038Event")) {
			array = new String[4][3];
			array[0][0] = "CD00698";
			array[0][2] = "Blank";
			array[1][0] = "CD00694";
			array[1][2] = "Blank";
			array[2][0] = "CD00695";
			array[2][2] = "Blank";
			array[3][0] = "CD00696";
			array[3][2] = "Blank";
			
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0039Event")) {
			array = new String[4][3];
			array[0][0] = "CD00684";
			array[0][2] = "Blank";
			array[1][0] = "CD00682";
			array[1][2] = "Blank";
			array[2][0] = "CD01526";
			array[2][2] = "Blank";
			array[3][0] = "CD00686";
			array[3][2] = "Blank";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0040Event")) {
			array = new String[7][3];
			array[0][0] = "CD00843";    //1. Payment Term
			array[1][0] = "CD00989";    //2. Payment Term Type
			array[2][0] = "CD00809";    //3. Payment Method
			array[3][0] = "CD00872";	//4. Bulk Classfication
			array[4][0] = "CD00831";    //5. Subsidiary Company         		
			array[5][0] = "CD00709";    //6. sheet3 Subject
			array[6][0] = "CD00708";    //7. sheet3 Kind of Service
//			array[3][0] = "CD01109";    //4. DG CGO Handling
//			array[4][0] = "CD01109";    //5. MTY R/R Order EDI Use 
//			array[5][0] = "CD01109";    //6. W/O Attach File
//			array[6][0] = "CD01109";    //7. W/O EDI Use
//			array[7][0] = "CD01109";    //8. Invoice EDI Use		
//			array[9][0] = "CD01109";    //10. Address Use Flag
//			array[10][0] = "CD01109";   //11. Delt Flag
//			array[11][0] = "CD01109";   //12. sheet2 Delete Flag
//			array[14][0] = "CD01109";   //15. sheet3 Delete Flag
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0041Event")) {
			array = new String[1][3];
			array[0][0] = "CD20013";
			array[0][2] = "Blank";
		}
//		else if (e.getEventName().equalsIgnoreCase("BcmCcd0042Event")) {
//
//		}
		else if (e.getEventName().equalsIgnoreCase("BcmCcd0048Event")) {
			array = new String[1][3];
			array[0][0] = "CD00675";
			array[0][2] = "Blank";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0049Event")) {
			array = new String[1][3];
			array[0][0] = "CD00653";
			array[0][2] = "Blank";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0050Event")) {
			array = new String[1][3];
			array[0][0] = "RepChg";
			array[0][2] = "Blank";	
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd0051Event")) {
            array = new String[1][3];
            array[0][0] = "CD00675";
            array[0][2] = "Blank";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd2001Event")) {
			array = new String[2][3];
			array[0][0] = "CD20091";
			array[0][2] = "Blank";
			array[1][0] = "CD20092";
			array[1][2] = "Blank";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd2002Event")) {
			array = new String[1][3];
			array[0][0] = "CD20091";
			array[0][2] = "Blank";
		}

		try{
			if(array != null){
				eventResponse = command.searchCommonCodeList(eventResponse, array);
			}
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	/**
	 * common : open<br>
	 * MDA Histroy Combo list retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHisComboList(Event e, String comboTP) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd2003Event event = (BcmCcd2003Event)e;
		CcdCommonBC command = new CcdCommonBCImpl();
		String[][] array = null;
		
		if (e.getEventName().equalsIgnoreCase("BcmCcd2003Event") && "TBL".equals(comboTP)) { //History Table List
			array = new String[1][3];
			array[0][0] = comboTP;
			array[0][2] = "";
		}else if (e.getEventName().equalsIgnoreCase("BcmCcd2003Event") && "COL".equals(comboTP)) { //History Column List
			array = new String[1][3];
			
			String colStr = event.getSearchMdmHistoryListVO().getTblNm();
			
			array[0][0] = comboTP+colStr;
			array[0][2] = "Blank";
		}

		try{
			if(array != null){
				eventResponse = command.searchCommonCodeList(eventResponse, array);
			}
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_2003 : Mdm Histroy Search <br>
	 * Mdm Histroy  retrieve.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd2003Event event = (BcmCcd2003Event)e;
		try{
			MstMgmtBC command = new MstMgmtBCImpl();
			SearchMdmHistoryListVO paramVO = event.getSearchMdmHistoryListVO();
			
/*			paramVO.setTblNm(event.getSearchMdmHistoryListVO().getTblNm());
			paramVO.setColNm(event.getSearchMdmHistoryListVO().getColNm());
			paramVO.setUpdDt(event.getSearchMdmHistoryListVO().getUpdDt());	//New Code���깅줉�좎쭨
*/			
			String rtvTotal = command.searchMdmHistoryCount(paramVO);
			eventResponse.setETCData("rtv_total", rtvTotal);
			List<SearchMdmHistoryListVO> list = command.searchMdmHistoryList(paramVO); 
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}	
	
	/**
	 * BCM_CCD_0001 : SEARCH<br>
	 * Account retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccountCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0001Event event = (BcmCcd0001Event)e;
		AccountBC command = new AccountBCImpl();

		try{
			List<AccountVO> vo = command.searchAccountCode(event.getAcctCd());
			eventResponse.setRsVoList(vo);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0001 : SAVE<br>
	 * Account save (add / modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAccountCode(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0001Event event = (BcmCcd0001Event)e;
		AccountBC command = new AccountBCImpl();
		
		try {
			
			AccountVO[] acctVOs = event.getAccountVOS();
			String usrId = account.getUsr_id();

			
			begin();
			command.manageAccountCode(acctVOs, usrId);
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0002 : SEARCH<br>
	 * Charge retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0002Event event = (BcmCcd0002Event)e;
		AccountBC command = new AccountBCImpl();

		try{
			List<ChargeVO> vo = command.searchChargeCode(event.getChgCd());
			eventResponse.setRsVoList(vo);
            eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0002 : SEARCH<br>
	 * Charge retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0002Event event = (BcmCcd0002Event)e;
		AccountBC command = new AccountBCImpl();

		try{
			String result = command.searchChargeRqst(event.getChgCd());
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0002 : SAVE<br>
	 * Charge save (add / modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageChargeCode(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0002Event event = (BcmCcd0002Event)e;
		AccountBC command = new AccountBCImpl();
		
		try {
			
			ChargeVO chgVO = event.getChargeVO();
			String usrId = account.getUsr_id();

			
			begin();
			command.manageChargeCode(chgVO, usrId);
			commit();
			eventResponse.setETCData("RQST_NO", "");
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0002 : SAVE<br>
	 * Charge save (add / modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageChargeRqst(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0002Event event = (BcmCcd0002Event)e;
		AccountBC command = new AccountBCImpl();
		MstMgmtBC mstCommand = new MstMgmtBCImpl();
		
		try {
			
			ChargeVO[] chgVOs = event.getChargeVOS();
			String usrId = account.getUsr_id();

			begin();
			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
            String rqstNo = mdmDatProcVO.getRqstNo();
            
            boolean isCreate = true;
			
            if(rqstNo != null && !rqstNo.equals("")) {
				isCreate = false;
			}
			
			if(isCreate) {
				// Create Request --> New RQST_NO search
				rqstNo = mstCommand.searchMdmDatProcRqstNo(mdmDatProcVO.getMstDatSubjCd());
				mdmDatProcVO.setRqstNo(rqstNo);
			}
			
			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
			
			if(isCreate) {
				// New MDM DATA PROCESS info added.
				mstCommand.addMdmDatProc(mdmDatProcVO);
			}
			command.manageChargeRqst(chgVOs, usrId, rqstNo);
			commit();
			eventResponse.setETCData("RQST_NO", rqstNo);
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * BCM_CCD_0003 : SEARCH<br>
	 * Rep Charge retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepChgCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0003Event event = (BcmCcd0003Event)e;
		AccountBC command = new AccountBCImpl();

		try{
			List<RepChargeVO> vo = command.searchRepChgCode(event.getRepChgCd());
			eventResponse.setRsVoList(vo);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0003 : SEARCH01<br>
	 * Redundancy check with Rep Charge Code<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepChgCodeChk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0003Event event = (BcmCcd0003Event)e;
		AccountBC command = new AccountBCImpl();
		
		boolean repChgCdChk = true;
		try{
			repChgCdChk = command.searchRepChgCodeChk(event.getRepChgCd());
			if (repChgCdChk){
				eventResponse.setETCData("repChgCdChk", "Y");//Does exist 
			} else {
				eventResponse.setETCData("repChgCdChk", "N");//Does not exist 
			}			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0003 : SAVE<br>
	 * Rep Charge save(add/modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRepChgCode(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0003Event event = (BcmCcd0003Event)e;
		AccountBC command = new AccountBCImpl();
		
		try {
			RepChargeVO[] repChgVOs = event.getRepChargeVOS();
			String usrId = account.getUsr_id();
			
			begin();
			command.manageRepChgCode(repChgVOs, usrId);
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0004 : SEARCH<br>
	 * Currency retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0004Event event = (BcmCcd0004Event)e;
		AccountBC command = new AccountBCImpl();

		try{
			List<CurrencyVO> vo = command.searchCurrCode(event.getCurrCd());
			eventResponse.setRsVoList(vo);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0004 : SAVE<br>
	 * Currency save(add/modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCurrCode(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0004Event event = (BcmCcd0004Event)e;
		AccountBC command = new AccountBCImpl();
		
		try {
			CurrencyVO[] currVOs = event.getCurrencyVOS();
			String usrId = account.getUsr_id();
			
			begin();
			command.manageCurrCode(currVOs, usrId);
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0005 : SEARCH<br>
	 * Container Type retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerType(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0005Event event = (BcmCcd0005Event)e;
		AssetBC command = new AssetBCImpl();

		try{
			ContainerTypeVO vo = command.searchContainerType(event.getCntrTpCd());
			if (event!=null){
				eventResponse.setRsVo(vo);
			}
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0005 : SAVE<br>
	 * Container Type save(add/modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContainerType(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0005Event event = (BcmCcd0005Event)e;
		AssetBC command = new AssetBCImpl();
		
		try {
			ContainerTypeVO containerTypeVO = event.getContainerTypeVO();
			String usrId = account.getUsr_id();
			
			begin();
			command.manageContainerType(containerTypeVO, usrId);
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0005 : Container Type onChange<br>
	 * Country checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCntrTypeCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AssetBC command = new AssetBCImpl();
		
		String cntrTpCd = new String();
		if(e instanceof BcmCcd0005Event){
			BcmCcd0005Event event = (BcmCcd0005Event)e;
			cntrTpCd = event.getCntrTpCd();
		}
		try{
			String result = command.checkCntrTpCode(cntrTpCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * BCM_CCD_0006 : SEARCH<br>
	 * Container Size retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerSize(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0006Event event = (BcmCcd0006Event)e;
		AssetBC command = new AssetBCImpl();
		
		try{
			ContainerSizeVO vo = command.searchContainerSize(event.getCntrSzCd());
			if (event!=null){
				eventResponse.setRsVo(vo);
			}
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0006 : SAVE<br>
	 * Container Size save(add/modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContainerSize(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0006Event event = (BcmCcd0006Event)e;
		AssetBC command = new AssetBCImpl();
		
		try {
			ContainerSizeVO containerSizeVO = event.getContainerSizeVO();
			String usrId = account.getUsr_id();
			
			begin();
			command.manageContainerSize(containerSizeVO, usrId);
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0006 : Container Size onChange<br>
	 * Country checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCntrSizeCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AssetBC command = new AssetBCImpl();
		
		String cntrSzCd = new String();
		if(e instanceof BcmCcd0006Event){
			BcmCcd0006Event event = (BcmCcd0006Event)e;
			cntrSzCd = event.getCntrSzCd();
		}
		try{
			String result = command.checkCntrSzCode(cntrSzCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * BCM_CCD_0007 : SEARCH<br>
	 * Container Type Size retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerTypeSize(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0007Event event = (BcmCcd0007Event)e;
		AssetBC command = new AssetBCImpl();

		try{
			ContainerTypeSizeVO vo = command.searchContainerTypeSize(event.getCntrTpSzCd());
			if (event!=null){
				eventResponse.setRsVo(vo);
			}
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0007 : SAVE<br>
	 * Container Type Size save(add/modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContainerTypeSize(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0007Event event = (BcmCcd0007Event)e;
		AssetBC command = new AssetBCImpl();
		
		try {
			ContainerTypeSizeVO ContainerTypeSizeVO = event.getContainerTypeSizeVO();
			String usrId = account.getUsr_id();
			
			begin();
			command.manageContainerTypeSize(ContainerTypeSizeVO, usrId);
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0007 : Container Size Checking<br>
	 * Country checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCntrTypeSizeCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AssetBC command = new AssetBCImpl();
		
		String cntrTpszCd = new String();
		if(e instanceof BcmCcd0007Event){
			BcmCcd0007Event event = (BcmCcd0007Event)e;
			cntrTpszCd = event.getCntrTpSzCd();
		}
		try{
			String result = command.checkCntrTpszCode(cntrTpszCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0008 : SEARCH<br>
	 * Container Vessel retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0008Event event = (BcmCcd0008Event)e;
		AssetBC command = new AssetBCImpl();

		try{
			List<ContainerVesselVO> vo = command.searchContainerVessel(event.getVslCd());
			eventResponse.setRsVoList(vo);
			eventResponse.setETCData("RQST_NO", "");
			if(vo.size() > 0){
				eventResponse.setETCData("VSL_CD", vo.get(0).getVslCd());
			}
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0008 : SEARCH<br>
	 * Container Vessel retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerVesselRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0008Event event = (BcmCcd0008Event)e;
		AssetBC command = new AssetBCImpl();

		try{
			List<ContainerVesselVO> vo = command.searchContainerVesselRqst(event.getRqstNo());
			eventResponse.setRsVoList(vo);
			eventResponse.setETCData("RQST_NO", event.getRqstNo());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0008 : SAVE<br>
	 * Container Vessel save(add/modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContainerVessel(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0008Event event = (BcmCcd0008Event)e;
		AssetBC command = new AssetBCImpl();
		
		try {
			ContainerVesselVO[] ContainerVesselVOs = event.getContainerVesselVOS();
			System.out.println("ContainerVesselVOs"+ContainerVesselVOs);
			String usrId = account.getUsr_id();
			
			begin();
			command.manageContainerVessel(ContainerVesselVOs, usrId);
			commit();
			eventResponse.setETCData("RQST_NO", "");
						
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0008 : SAVE<br>
	 * Container Vessel save(add/modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContainerVesselRqst(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0008Event event = (BcmCcd0008Event)e;
		AssetBC command = new AssetBCImpl();
		MstMgmtBC mstCommand = new MstMgmtBCImpl();
		
		try {
			ContainerVesselVO[] ContainerVesselVOs = event.getContainerVesselVOS();
			String usrId = account.getUsr_id();
			
			begin();
			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
            String rqstNo = mdmDatProcVO.getRqstNo();
            
            boolean isCreate = true;
			
            if(rqstNo != null && !rqstNo.equals("")) {
				isCreate = false;
			}
			
			if(isCreate) {
				// Create Request --> New RQST_NO search
				rqstNo = mstCommand.searchMdmDatProcRqstNo(mdmDatProcVO.getMstDatSubjCd());
				mdmDatProcVO.setRqstNo(rqstNo);
			}
			
			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
			
			if(isCreate) {
				// New MDM DATA PROCESS info added.
				mstCommand.addMdmDatProc(mdmDatProcVO);
			}
			command.manageContainerVesselRqst(ContainerVesselVOs, usrId, rqstNo);
			commit();
			eventResponse.setETCData("RQST_NO", rqstNo);
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0009 : SEARCH<br>
	 * Group Commodity retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0009Event event = (BcmCcd0009Event)e;
		CommodityBC command = new CommodityBCImpl();

		try{
			List<GrpCommodityVO> vo = command.searchGroupCommodity(event.getGrpCmdtCd());
			eventResponse.setRsVoList(vo);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0009 : SAVE<br>
	 * Group Commodity save(add/modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGroupCommodity(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0009Event event = (BcmCcd0009Event)e;
		CommodityBC command = new CommodityBCImpl();
		
		try {
			GrpCommodityVO[] GrpCommodityVOs = event.getGrpCommodityVOS();
			String usrId = account.getUsr_id();
			
			begin();
			command.manageGroupCommodity(GrpCommodityVOs, usrId);
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0010 : SEARCH<br>
	 * Rep Commodity retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0010Event event = (BcmCcd0010Event)e;
		CommodityBC command = new CommodityBCImpl();

		try{
			List<RepCommodityVO> vo = command.searchRepCommodity(event.getRepCmdtCd());
			eventResponse.setRsVoList(vo);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0010 : SAVE<br>
	 * Rep Commodity save(add/modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRepCommodity(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0010Event event = (BcmCcd0010Event)e;
		CommodityBC command = new CommodityBCImpl();
		
		try {
			RepCommodityVO[] RepCommodityVOs = event.getRepCommodityVOS();
			String usrId = account.getUsr_id();
			
			begin();
			command.manageRepCommodity(RepCommodityVOs, usrId);
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0011 : SEARCH<br>
	 * Commodity retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0011Event event = (BcmCcd0011Event)e;
		CommodityBC command = new CommodityBCImpl();

		try{
			List<CommodityVO> vo = command.searchCommodity(event.getCmdtCd());
			eventResponse.setRsVoList(vo);
			eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0011 : SEARCH<br>
	 * Commodity retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommodityRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0011Event event = (BcmCcd0011Event)e;
		CommodityBC command = new CommodityBCImpl();

		try{
			List<CommodityVO> vo = command.searchCommodityRqst(event.getRqstNo());
			eventResponse.setRsVoList(vo);
			eventResponse.setETCData("RQST_NO", event.getRqstNo());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0011 : SAVE<br>
	 * Commodity save(add/modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCommodity(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0011Event event = (BcmCcd0011Event)e;
		CommodityBC command = new CommodityBCImpl();
		
		try {
			CommodityVO[] CommodityVOs = event.getCommodityVOS();
			String usrId = account.getUsr_id();
			
			begin();
			command.manageCommodity(CommodityVOs, usrId);
			commit();
			eventResponse.setETCData("RQST_NO", "");
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0011 : SAVE<br>
	 * Commodity save(add/modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCommodityRqst(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0011Event event = (BcmCcd0011Event)e;
		CommodityBC command = new CommodityBCImpl();
		MstMgmtBC mstCommand = new MstMgmtBCImpl();
		
		try {
			CommodityVO[] CommodityVOs = event.getCommodityVOS();
			String usrId = account.getUsr_id();
			
			begin();
			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
            String rqstNo = mdmDatProcVO.getRqstNo();
            
            boolean isCreate = true;
			
            if(rqstNo != null && !rqstNo.equals("")) {
				isCreate = false;
			}
			
			if(isCreate) {
				// Create Request --> New RQST_NO search
				rqstNo = mstCommand.searchMdmDatProcRqstNo(mdmDatProcVO.getMstDatSubjCd());
				mdmDatProcVO.setRqstNo(rqstNo);
			}
			
			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
			
			if(isCreate) {
				// New MDM DATA PROCESS info added.
				mstCommand.addMdmDatProc(mdmDatProcVO);
			}
			command.manageCommodityRqst(CommodityVOs, usrId, rqstNo);
			commit();
			eventResponse.setETCData("RQST_NO", rqstNo);
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0012 : SEARCH<br>
	 * CustPackageType retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustPackageType(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0012Event event = (BcmCcd0012Event)e;
		CommodityBC command = new CommodityBCImpl();

		try{
			List<CustPackageTypeVO> vo = command.searchCustPackageType(event.getPckCd(), event.getCstmsCntCd());
			if(vo.size() > 0){
				eventResponse.setETCData("cstms_cnt_cd", vo.get(0).getCstmsCntCd());
			}
			eventResponse.setRsVoList(vo);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0012 : SAVE<br>
	 * CustPackageType save(add/modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCustPackageType(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0012Event event = (BcmCcd0012Event)e;
		CommodityBC command = new CommodityBCImpl();
		
		try {
			CustPackageTypeVO[] CustPackageTypeVOs = event.getCustPackageTypeVOS();
			String usrId = account.getUsr_id();
			
			begin();
			command.manageCustPackageType(CustPackageTypeVOs, usrId);
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0013 : SEARCH<br>
	 * Package Type retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPackageType(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0013Event event = (BcmCcd0013Event)e;
		CommodityBC command = new CommodityBCImpl();

		try{
			List<PackageTypeVO> vo = command.searchPackageType(event.getPckCd());
			if(vo.size() > 0){
				eventResponse.setETCData("pck_cd", vo.get(0).getPckCd());
			}
			eventResponse.setRsVoList(vo);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0013 : SAVE<br>
	 * Package Type save(add/modify)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse managePackageType(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0013Event event = (BcmCcd0013Event)e;
		CommodityBC command = new CommodityBCImpl();
		
		try {
			PackageTypeVO[] PackageTypeVOs = event.getPackageTypeVOS();
			String usrId = account.getUsr_id();
			
			begin();
			command.managePackageType(PackageTypeVOs, usrId);
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0025 : SEARCH<br>
	 * To act code to query detailed information.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0025Event event = (BcmCcd0025Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			ActivityVO vo = command.searchActCode(event.getActCd());
			eventResponse.setRsVo(vo);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0025 : SAVE<br>
	 * The new act code generation, and looked up the details of the act code to modify.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageActCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0025Event event = (BcmCcd0025Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			begin();
			command.manageActCode(event.getActivityVO());
			commit();
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0026 : SEARCH<br>
	 * To  mvmt sts code to query detailed information.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMvmtStsCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0026Event event = (BcmCcd0026Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			MovementStatusVO vo = command.searchMvmtStsCode(event.getMvmtStsCd());
			eventResponse.setRsVo(vo);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0026 : SAVE<br>
	 * The new  mvmt sts code generation, and looked up the details of the  mvmt sts code to modify.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMvmtStsCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0026Event event = (BcmCcd0026Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			begin();
			command.manageMvmtStsCode(event.getMvmtStsVO(), account);
			commit();
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0014 : RETRIEVE<br>
	 * Continent retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContiCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0014Event event = (BcmCcd0014Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			ContinentVO continentVO = command.searchContiCode(event.getContiCd());
			eventResponse.setRsVo(continentVO);
			if(continentVO != null){
				eventResponse.setETCData("conti_nm", continentVO.getContiNm());
				eventResponse.setETCData("delt_flg", continentVO.getDeltFlg());
			}
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0014 : SAVE<br>
	 * Continent save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContiCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0014Event event = (BcmCcd0014Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			begin();
			ContinentVO continentVO = event.getContinentVO();
			continentVO.setUsrId(account.getUsr_id());
			command.manageContiCode(continentVO);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0015 : RETRIEVE<br>
	 * Sub Continent retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubContiCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		//BcmCcd0015Event event = (BcmCcd0015Event)e;
		String contiCd = new String();
		
		if(e instanceof BcmCcd0015Event){
			BcmCcd0015Event event = (BcmCcd0015Event)e;
			contiCd = event.getScontiCd();
		} else if(e instanceof BcmCcd0029Event){
			BcmCcd0029Event event = (BcmCcd0029Event)e;
			contiCd = event.getSconti();
		}
		
		LocationBC command = new LocationBCImpl();


		try{
			//SubContinentVO subContinentVO = command.searchSubContiCode(event.getScontiCd());
			SubContinentVO subContinentVO = command.searchSubContiCode(contiCd);
			eventResponse.setRsVo(subContinentVO);
			if(subContinentVO != null){
				eventResponse.setETCData("conti_cd", subContinentVO.getContiCd());
				eventResponse.setETCData("sconti_nm", subContinentVO.getScontiNm());
				eventResponse.setETCData("delt_flg", subContinentVO.getDeltFlg());
			} 
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0015 : SAVE<br>
	 * Sub Continent save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSubContiCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0015Event event = (BcmCcd0015Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			begin();
			SubContinentVO subContinentVO = event.getSubContinentVO();
			subContinentVO.setUsrId(account.getUsr_id());
			command.manageSubContiCode(subContinentVO);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	
	/**
	 * BCM_CCD_0016 : RETRIEVE<br>
	 * Country retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCountryCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0016Event event = (BcmCcd0016Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			CountryVO countryVO = command.searchCountryCode(event.getCntCd());
			eventResponse.setRsVo(countryVO);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0016 : SAVE<br>
	 * Country save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCountryCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0016Event event = (BcmCcd0016Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			begin();
			CountryVO countryVO = event.getCountryVO();
			countryVO.setUsrId(account.getUsr_id());
			command.manageCountryCode(countryVO);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0017 : RETRIEVE<br>
	 * Region retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRegionCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0017Event event = (BcmCcd0017Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			RegionVO regionVO = command.searchRegionCode(event.getRgnCd());
			eventResponse.setRsVo(regionVO);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0017 : SAVE<br>
	 * Region save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRegionCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0017Event event = (BcmCcd0017Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			begin();
			RegionVO rgnVO = event.getRegionVO();
			rgnVO.setUsrId(account.getUsr_id());
			command.manageRegionCode(rgnVO);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0018 : RETRIEVE<br>
	 * State retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStateCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0018Event event = (BcmCcd0018Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			StateVO stateVO = command.searchStateCode(event.getSteCd(), event.getCntCd());
			eventResponse.setRsVo(stateVO);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0018 : SAVE<br>
	 * State save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageStateCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0018Event event = (BcmCcd0018Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			begin();
			StateVO steVO = event.getStateVO();
			steVO.setUsrId(account.getUsr_id());
			command.manageStateCode(steVO);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
		/**
	* BCM_CCD_0002 : Account onChange<br>
	* BCM_CCD_0032 : Account onChange<br>
	* Account ckeck.<br>
	* 
	* @param Event e
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse checkAcctCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String acctCd = new String();
		if(e instanceof BcmCcd0002Event){
			BcmCcd0002Event event = (BcmCcd0002Event)e;
			acctCd = event.getAcctCd();
		}else if(e instanceof BcmCcd0032Event){
			BcmCcd0032Event event = (BcmCcd0032Event)e;
			acctCd = event.getHiddenAcctCd();
		}
		try{
			String result = command.checkAcctCode(acctCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
		

	
	/**
	 * BCM_CCD_0008 : Carrier onChange<br>
	 * Carrier checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCrrCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String crrCd = new String();
		if(e instanceof BcmCcd0008Event){
			BcmCcd0008Event event = (BcmCcd0008Event)e;
			crrCd = event.getCrrCd();
		}
		try{
			String result = command.checkCrrCode(crrCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0004 : Country onChange<br>
	 * BCM_CCD_0008 : Country onChange<br>
	 * BCM_CCD_0012 : Country onChange<br>
	 * BCM_CCD_0017 : Country onChange<br>
	 * BCM_CCD_0018 : Country onChange<br>
	 * BCM_CCD_0035 : Country onChange<br>
	 * BCM_CCD_0036 : Country onChange<br>
	 * BCM_CCD_0019 : Country onChange<br>
	 * BCM_CCD_0024 : Country onChange<br>
	 * Country checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCntCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String cntCd = new String();
		if(e instanceof BcmCcd0002Event){
			BcmCcd0002Event event = (BcmCcd0002Event)e;
			cntCd = event.getTaxCntCd();
		}else if(e instanceof BcmCcd0004Event){
			BcmCcd0004Event event = (BcmCcd0004Event)e;
			cntCd = event.getCntCd();
		}else if(e instanceof BcmCcd0008Event){
			BcmCcd0008Event event = (BcmCcd0008Event)e;
			cntCd = event.getVslRgstCntCd();
		}else if(e instanceof BcmCcd0012Event){
			BcmCcd0012Event event = (BcmCcd0012Event)e;
			cntCd = event.getCstmsCntCd();
		}else if(e instanceof BcmCcd0017Event){
			BcmCcd0017Event event = (BcmCcd0017Event)e;
			cntCd = event.getCntCd();
		}else if(e instanceof BcmCcd0018Event){
			BcmCcd0018Event event = (BcmCcd0018Event)e;
			cntCd = event.getCntCd();
		}else if(e instanceof BcmCcd0036Event){
			BcmCcd0036Event event = (BcmCcd0036Event)e;
			cntCd = event.getCntCd();
		}else if(e instanceof BcmCcd0019Event){
			BcmCcd0019Event event = (BcmCcd0019Event)e;
			cntCd = event.getCntCd();
		}else if(e instanceof BcmCcd0024Event){
			BcmCcd0024Event event = (BcmCcd0024Event)e;
			cntCd = event.getDstCntCd();
		}else if(e instanceof BcmCcd0033Event){
			BcmCcd0033Event event = (BcmCcd0033Event)e;
			cntCd = event.getCntCd();
		}else if(e instanceof BcmCcd0035Event){
			BcmCcd0035Event event = (BcmCcd0035Event)e;
			cntCd = event.getCustCntCd();
		}else if(e instanceof BcmCcd0040Event){
			BcmCcd0040Event event = (BcmCcd0040Event)e;
			cntCd = event.getCheckCd();
		}else if(e instanceof BcmCcd0043Event){
			BcmCcd0043Event event = (BcmCcd0043Event)e;
			cntCd = event.getCustomerReportVO().getCustCntCd();
		}else if(e instanceof BcmCcd0044Event){
			BcmCcd0044Event event = (BcmCcd0044Event)e;
			cntCd = event.getVendorReportVO().getVndrCntCd();
		}else if(e instanceof BcmCcd1040Event){
			BcmCcd1040Event event = (BcmCcd1040Event)e;
			cntCd = event.getVndrCntCd();
		}	
		try{
			String result = command.checkCntCode(cntCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0035 : Rep. Commodity onChange<br>
	 * Commodity checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRepCmdt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String cmdtCd = new String();
		if(e instanceof BcmCcd0035Event){
			BcmCcd0035Event event = (BcmCcd0035Event)e;
			cmdtCd = event.getPrfRepCmdtCd();
		}
		try{
			String result = command.checkRepCmdt(cmdtCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0016 : Sub Continent onChange<br>
	 * BCM_CCD_0019 : Sub Continent onChange<br>
	 * Sub Continent checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSubConti(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String scontiCd = new String();
		if(e instanceof BcmCcd0016Event){
			BcmCcd0016Event event = (BcmCcd0016Event)e;
			scontiCd = event.getScontiCd();
		}else if(e instanceof BcmCcd0019Event){
			BcmCcd0019Event event = (BcmCcd0019Event)e;
			scontiCd = event.getScontiCd();
		}
		try{
			String result = command.checkSubConti(scontiCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0016 : Currency onChange<br>
	 * BCM_CCD_0032 : Currency onChange<br>
	 * BCM_CCD_0035 : Currency onChange<br>
	 * BCM_CCD_0039 : Currency onChange<br>
	 * BCM_CCD_0040 : Currency onChange<br>
	 * Currency checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCurrCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String currCd = new String();
		
		if(e instanceof BcmCcd0016Event){
			BcmCcd0016Event event = (BcmCcd0016Event)e;
			currCd = event.getCurrCd();
		}else if(e instanceof BcmCcd0032Event){
			BcmCcd0032Event event = (BcmCcd0032Event)e;
			currCd = event.getHiddenOfcCd();
		}else if(e instanceof BcmCcd0035Event){
			BcmCcd0035Event event = (BcmCcd0035Event)e;
			currCd = event.getCapiCurrCd();
		}else if(e instanceof BcmCcd0039Event){
			BcmCcd0039Event event = (BcmCcd0039Event)e;
			currCd = event.getCrCurrCd();
		}else if(e instanceof BcmCcd0040Event){
			BcmCcd0040Event event = (BcmCcd0040Event)e;
			currCd = event.getCheckCd();
		}
		try{
			String result = command.checkCurrCode(currCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	/**
	 * BCM_CCD_0035 : Group Customer Code onChange<br>
	 * Group Customer Code checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkGrpCustCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String grpCustCd = new String();
		
		if(e instanceof BcmCcd0035Event){
			BcmCcd0035Event event = (BcmCcd0035Event)e;
			grpCustCd = event.getCustGrpId();
		}
		try{
			String result = command.checkGrpCustCode(grpCustCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	

	/**
	 * BCM_CCD_0019 : RETRIEVE<br>
	 * Location retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0019Event event = (BcmCcd0019Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			LocationVO locVO = command.searchLocCode(event.getLocCd());
			eventResponse.setRsVo(locVO);
			eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0019 : RETRIEVE<br>
	 * Location retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocCodeRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0019Event event = (BcmCcd0019Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			LocationVO locVO = command.searchLocCodeRqst(event.getRqstNo());
			eventResponse.setRsVo(locVO);
			eventResponse.setETCData("RQST_NO", event.getRqstNo());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0019 : SAVE<br>
	 * Location save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLocCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0019Event event = (BcmCcd0019Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			begin();
			LocationVO locVO = event.getLocVO();
			locVO.setUsrId(account.getUsr_id());
			command.manageLocCode(locVO);
			commit();
			eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0019 : SAVE<br>
	 * Location save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLocCodeRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0019Event event = (BcmCcd0019Event)e;
		LocationBC command = new LocationBCImpl();
		MstMgmtBC mstCommand = new MstMgmtBCImpl();

		try{
			begin();
			
			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
            String rqstNo = mdmDatProcVO.getRqstNo();
            
            boolean isCreate = true;
			
            if(rqstNo != null && !rqstNo.equals("")) {
				isCreate = false;
			}
			
			if(isCreate) {
				// Create Request --> New RQST_NO search
				rqstNo = mstCommand.searchMdmDatProcRqstNo(mdmDatProcVO.getMstDatSubjCd());
				mdmDatProcVO.setRqstNo(rqstNo);
			}
			
			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
			
			if(isCreate) {
				// New MDM DATA PROCESS info added.
				mstCommand.addMdmDatProc(mdmDatProcVO);
			}
			
			LocationVO locVO = event.getLocVO();
			locVO.setUsrId(account.getUsr_id());
			locVO.setRqstNo(rqstNo);
			command.manageLocCodeRqst(locVO);
			commit();
			eventResponse.setETCData("RQST_NO", rqstNo);
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0019 : Region onChange<br>
	 * Region checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRgnCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String rgnCd = new String();
		
		if (e instanceof BcmCcd0019Event) {
			BcmCcd0019Event event = (BcmCcd0019Event)e;
			rgnCd = event.getRgnCd();
		}else if (e instanceof BcmCcd0029Event) {
			BcmCcd0029Event event = (BcmCcd0029Event)e;
			rgnCd = event.getRgnCd();
		}
		try{
			String result = command.checkRgnCode(rgnCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0019 : State onChange<br>
	 * BCM_CCD_0036 : State onChange<br>
	 * BCM_CCD_0024 : State onChange<br>
	 * State checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkStateCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String steCd = new String();
		String cntCd = new String();
		if(e instanceof BcmCcd0019Event){
			BcmCcd0019Event event = (BcmCcd0019Event)e;
			steCd = event.getSteCd();
		}else if(e instanceof BcmCcd0036Event){
			BcmCcd0036Event event = (BcmCcd0036Event)e;
			steCd = event.getSteCd();
		}else if(e instanceof BcmCcd0024Event){
			BcmCcd0024Event event = (BcmCcd0024Event)e;
			steCd = event.getDstNotAplySteCd();
		}else if(e instanceof BcmCcd0040Event){
			BcmCcd0040Event event = (BcmCcd0040Event)e;
			steCd = event.getCheckCd();
			cntCd = event.getCheckDeCntCd();
		}
		try{
			String result_ = command.checkStateCode(steCd, cntCd);
			if(result_.equals("")) {
				eventResponse.setETCData("result", "");
				eventResponse.setETCData("cnt_cd", "");
			} else {
				String result[] = result_.split(",");
				eventResponse.setETCData("result", result[1]);
				eventResponse.setETCData("cnt_cd", result[0]);
			}
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0019 : Rep.Zone onChange<br>
	 * BCM_CCD_0020 : Rep.Zone onChange<br>
	 * Zone checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkZoneCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String zoneCd = new String();
		if(e instanceof BcmCcd0019Event){
			BcmCcd0019Event event = (BcmCcd0019Event)e;
			zoneCd = event.getRepZnCd();
		}else if(e instanceof BcmCcd0020Event){
			BcmCcd0020Event event = (BcmCcd0020Event)e;
			zoneCd = event.getRepZnCd();
		}
		try{
			String result = command.checkZoneCode(zoneCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0019 : mty_pkup_yd_cd, eq_rtn_yd_cd onChange<br>
	 * BCM_CCD_0021 : rep_yd_cd onChange<br>
	 * BCM_CCD_0023 : Leasing Company Yard onChange<br>
	 * yard checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkYardCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String nodCd = new String();
		
		if(e instanceof BcmCcd0019Event){
			BcmCcd0019Event event = (BcmCcd0019Event)e;
			if(e.getFormCommand().isCommand(FormCommand.SEARCH11)){
				nodCd = event.getMtyPkupYdCd();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)){
				nodCd = event.getEqRtnYdCd();
			}
		}else if(e instanceof BcmCcd0021Event){
			BcmCcd0021Event event = (BcmCcd0021Event)e;
			nodCd = event.getRepYdCd();
		}else if(e instanceof BcmCcd0023Event){
			BcmCcd0023Event event = (BcmCcd0023Event)e;
			nodCd = event.getLseCoYdCd();
		}
		
		try{
			String result = command.checkYardCode(nodCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
		
	/**
	 * BCM_CCD_0008 : Location onChange<br>
	 * BCM_CCD_0032 : Location onChange<br>
	 * BCM_CCD_0019 : SCC onChange, Hub Loc onChange<br>
	 * BCM_CCD_0022 : SCC onChange<br>
	 * BCM_CCD_0035 : Location onChange<br>
	 * BCM_CCD_0040 : Location onChange<br>
	 * BCM_CCD_0020 : Yard Code onChange<br>
	 * Location Code checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String locCd = new String();
		
		if(e instanceof BcmCcd0032Event){
			BcmCcd0032Event event = (BcmCcd0032Event)e;
			locCd = event.getHiddenOfcCd();
		}else if(e instanceof BcmCcd0008Event){
			BcmCcd0008Event event = (BcmCcd0008Event)e;
			locCd = event.getRgstPortCd();
		}else if(e instanceof BcmCcd0035Event){
			BcmCcd0035Event event = (BcmCcd0035Event)e;
			locCd = event.getLocCd();
		}else if(e instanceof BcmCcd0019Event){
			BcmCcd0019Event event = (BcmCcd0019Event)e;
			if(e.getFormCommand().isCommand(FormCommand.SEARCH06)){
				locCd = event.getSccCd();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)){
				locCd = event.getHubLocCd();
			}
		}else if(e instanceof BcmCcd0022Event){
			BcmCcd0022Event event = (BcmCcd0022Event)e;
			if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				locCd = event.getLocCd();
			}
		}else if(e instanceof BcmCcd0040Event){
			BcmCcd0040Event event = (BcmCcd0040Event)e;
			locCd = event.getCheckCd();
		}else if(e instanceof BcmCcd0043Event){
			BcmCcd0043Event event = (BcmCcd0043Event)e;
			locCd = event.getCustomerReportVO().getLocCd();
		}else if(e instanceof BcmCcd0044Event){
			BcmCcd0044Event event = (BcmCcd0044Event)e;
			locCd = event.getVendorReportVO().getLocCd();
		}else if(e instanceof BcmCcd0020Event){
			BcmCcd0020Event event = (BcmCcd0020Event)e;
			locCd = event.getLocCd();
		}else if(e instanceof BcmCcd0021Event){
			BcmCcd0021Event event = (BcmCcd0021Event)e;
			locCd = event.getLocCd();
		}
		try{
			String result = command.checkLocCode(locCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0032 : Customer onChange<br>
	 * BCM_CCD_0039 : Customer onChange<br>
	 * BCM_CCD_0036 : Customer onChange<br>
	 * BCM_CCD_0037 : Customer onChange<br>
	 * Customer Code checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCustCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String custCd = new String();
		
		if(e instanceof BcmCcd0032Event){
			BcmCcd0032Event event = (BcmCcd0032Event)e;
			custCd = event.getHiddenOfcCd();
		}else if(e instanceof BcmCcd0039Event){
			BcmCcd0039Event event = (BcmCcd0039Event)e;
			if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				custCd = event.getActCustCd();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)){
				custCd = event.getCustCd();
			}
			
		}else if(e instanceof BcmCcd0036Event){
			BcmCcd0036Event event = (BcmCcd0036Event)e;
			custCd = event.getCustCd();
		}else if(e instanceof BcmCcd0037Event){
			BcmCcd0037Event event = (BcmCcd0037Event)e;
			custCd = event.getCustCd();
		}else if(e instanceof BcmCcd0035Event){
		 	BcmCcd0035Event event = (BcmCcd0035Event)e;
			custCd = event.getCustCd();
		}else if(e instanceof BcmCcd0043Event){
			BcmCcd0043Event event = (BcmCcd0043Event)e;
			custCd = event.getCustomerReportVO().getCustCntCd() + event.getCustomerReportVO().getCustSeq();
		}
		try{
			String result = command.checkCustCode(custCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0032 : Vendor onChange<br>
	 * BCM_CCD_0035 : Vendor onChange<br>
	 * BCM_CCD_0020 : Handling Vendor, Stevedoring Vendor, Security Vendor onChange<br>
	 * BCM_CCD_0040 : Parent Vendor onChange<br>
	 * Vendor Code checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVndrCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String vndrCd = new String();
		
		if(e instanceof BcmCcd0032Event){
			BcmCcd0032Event event = (BcmCcd0032Event)e;
			vndrCd = event.getHiddenOfcCd();
		}else if(e instanceof BcmCcd0035Event){
			BcmCcd0035Event event = (BcmCcd0035Event)e;
			vndrCd = event.getVndrSeq();
		}else if(e instanceof BcmCcd0020Event){
			BcmCcd0020Event event = (BcmCcd0020Event)e;
			if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				vndrCd = event.getN1stVndrSeq();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				vndrCd = event.getN2ndVndrSeq();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				vndrCd = event.getN3rdVndrSeq();
			}
		}else if(e instanceof BcmCcd0023Event){
			BcmCcd0023Event event = (BcmCcd0023Event)e;
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				vndrCd = event.getLseCoVndrSeq1();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				vndrCd = event.getLseCoVndrSeq2();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				vndrCd = event.getLseCoVndrSeq3();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				vndrCd = event.getLseCoVndrSeq4();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)){
				vndrCd = event.getLseCoVndrSeq5();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)){
				vndrCd = event.getLseCoVndrSeq6();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)){
				vndrCd = event.getLseCoVndrSeq7();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH08)){
				vndrCd = event.getLseCoVndrSeq8();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)){
				vndrCd = event.getLseCoVndrSeq9();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)){
				vndrCd = event.getLseCoVndrSeq10();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH11)){
				vndrCd = event.getLseCoVndrSeq11();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)){
				vndrCd = event.getLseCoVndrSeq12();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)){
				vndrCd = event.getLseCoVndrSeq13();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH14)){
				vndrCd = event.getLseCoVndrSeq14();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH15)){
				vndrCd = event.getLseCoVndrSeq15();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH16)){
				vndrCd = event.getLseCoVndrSeq16();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH17)){
				vndrCd = event.getLseCoVndrSeq17();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH18)){
				vndrCd = event.getLseCoVndrSeq18();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH19)){
				vndrCd = event.getLseCoVndrSeq19();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH20)){
				vndrCd = event.getLseCoVndrSeq20();
			}
		}else if(e instanceof BcmCcd0040Event){
			BcmCcd0040Event event = (BcmCcd0040Event)e;
			vndrCd = event.getCheckCd();
		}else if(e instanceof BcmCcd0044Event){
			BcmCcd0044Event event = (BcmCcd0044Event)e;
			vndrCd = event.getVendorReportVO().getVndrSeq();
		}
		try{
			String result = command.checkVndrCode(vndrCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0020 : Handling Vendor, Stevedoring Vendor, Security Vendor onChange<br>
	 * Vendor Code Name checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVndrCodeName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String vndrCd = new String();
		
		BcmCcd0020Event event = (BcmCcd0020Event)e;
		if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
			vndrCd = event.getN1stVndrSeq();
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
			vndrCd = event.getN2ndVndrSeq();
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){
			vndrCd = event.getN3rdVndrSeq();
		}

		try{
			String result = command.checkVndrCodeName(vndrCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0034 : SEARCH<br>
	 * Carrier Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCrrCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0034Event event = (BcmCcd0034Event)e;
		PartnerBC command = new PartnerBCImpl();
		
		try {
	          CarrierVO carriervo = command.searchCrrCode(event.getCarrierVO().getCrrCd());
	          eventResponse.setRsVo(carriervo);
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0034 : SEARCH<br>
	 * Carrier Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCrrRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0034Event event = (BcmCcd0034Event)e;
		PartnerBC command = new PartnerBCImpl();
		
		try {
	          CarrierVO carriervo = command.searchCrrRqst(event.getCarrierVO().getRqstNo());
	          eventResponse.setRsVo(carriervo);
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	

    /**
     * multi event process<br>
     * BCM_CCD_0034 Code is stored as a multi<br>
     * 
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageCrrCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PartnerBC command = new PartnerBCImpl();
        BcmCcd0034Event event = (BcmCcd0034Event) e;
        try {
        	
            begin();
            command.manageCrrCode(event.getCarrierVO(), account);
            commit();
            eventResponse.setETCData("RQST_NO", "");
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }

    /**
     * multi event process<br>
     * BCM_CCD_0034 Code is stored as a multi<br>
     * 
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageCrrRqst(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PartnerBC command = new PartnerBCImpl();
        MstMgmtBC mstCommand = new MstMgmtBCImpl();
        BcmCcd0034Event event = (BcmCcd0034Event) e;
        try {
        	
            begin();
            MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
            String rqstNo = mdmDatProcVO.getRqstNo();
            
            boolean isCreate = true;
			
            if(rqstNo != null && !rqstNo.equals("")) {
				isCreate = false;
			}
			
			if(isCreate) {
				// Create Request --> New RQST_NO search
				rqstNo = mstCommand.searchMdmDatProcRqstNo(mdmDatProcVO.getMstDatSubjCd());
				mdmDatProcVO.setRqstNo(rqstNo);
			}
			
			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
			
			if(isCreate) {
				// New MDM DATA PROCESS info added.
				mstCommand.addMdmDatProc(mdmDatProcVO);
			}
            
			command.manageCrrRqst(event.getCarrierVO(), account, rqstNo);        
			commit();
			
			eventResponse.setETCData("RQST_NO", rqstNo);
            
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
	/**
	 * BCM_CCD_0036 : SEARCH<br>
	 * Customer Address retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustAddrCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0036Event event = (BcmCcd0036Event)e;
		PartnerBC command = new PartnerBCImpl();
		String custCntCd = null;
		String custSeq = null;
		String addrTpCd = null;
		List<CustomerAddressVO> list = null;
		
		try {
			 
			custCntCd = event.getCustomerAddressVO().getCustCntCd();
			custSeq = event.getCustomerAddressVO().getCustSeq();
			addrTpCd = event.getCustomerAddressVO().getAddrTpCd();
			list = command.searchCustAddrCode(custCntCd, custSeq, addrTpCd);
			eventResponse.setRsVoList(list);
			
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	 /**
     * multi event process<br>
     * BCM_CCD_0036 Code is stored as a multi<br>
     * 
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageCustAddrCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PartnerBC command = new PartnerBCImpl();
        //ArrivalNoticeBCImpl bkgcommand = new ArrivalNoticeBCImpl();
        BcmCcd0036Event event = (BcmCcd0036Event) e;
        String custCntCd = event.getCustCntCd();
        String custSeq = event.getCustSeq();
        String addrTpCd = event.getAddrTpCd();
        try {
        	
            begin();
            
            CustomerAddressVO[] custAddrVOs = event.getCustomerAddressVOS();
            List<MdmCustomerVO> mdmCustomerVOs = new ArrayList<MdmCustomerVO>();
            MdmCustomerVO[] customerVOs = event.getMdmCustomerVOS();
            for(int i = 0; i < custAddrVOs.length; i++){
            	custAddrVOs[i].setCustCntCd(custCntCd);
            	custAddrVOs[i].setCustSeq(custSeq);
            	custAddrVOs[i].setAddrTpCd(addrTpCd);
            }

            for(int i = 0; i < custAddrVOs.length; i++){
		        if("1".equals(event.getAddrTpCd())&&"Y".equals(custAddrVOs[i].getPrmryChkFlg())){
		        	//customerVOs[0].setCreUsrId(account.getUsr_id());
		        	//customerVOs[0].setUpdUsrId(account.getUsr_id());
		        	customerVOs[0].setCustCntCd(event.getCustCntCd());
		        	customerVOs[0].setCustSeq(event.getCustSeq());
		        	customerVOs[0].setCustLglEngNm(custAddrVOs[i].getBzetNm());
		        	mdmCustomerVOs.add(customerVOs[0]);
		        }
            }
            command.manageCustAddrCode(custAddrVOs, account);      
            //bkgcommand.mergeBkgCustCdVal(mdmCustomerVOs);
            
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
	/**
	 * BCM_CCD_0037 : SEARCH<br>
	 * Customer Contact Point Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustCntcCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0037Event event = (BcmCcd0037Event)e;
		PartnerBC command = new PartnerBCImpl();
		String custCntCd = null;
		String custSeq = null;
		List<CustomerContactVO> list = null;
		
		try {
			 
			custCntCd = event.getCustomerContactVO().getCustCntCd();
			custSeq = event.getCustomerContactVO().getCustSeq();
			list = command.searchCustCntcCode(custCntCd, custSeq);
			eventResponse.setRsVoList(list);
			
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	  /**
     * multi event process<br>
     * BCM_CCD_0037 On screen Code is stored as a multi<br>
     * 
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageCustCntcCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PartnerBC command = new PartnerBCImpl();
        BcmCcd0037Event event = (BcmCcd0037Event) e;
        String custCntCd = event.getCustCntCd();
        String custSeq = event.getCustSeq();
        try {
        	
            begin();
            CustomerContactVO[] customerContractVOs = event.getCustomerContactVOS();
            for(int i = 0; i < customerContractVOs.length; i++){
            	customerContractVOs[i].setCustCntCd(custCntCd);
            	customerContractVOs[i].setCustSeq(custSeq);
            }
            command.manageCustCntcCode(customerContractVOs, account); 
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
	
	/**
	 * BCM_CCD_0038 : SEARCH<br>
	 * Customer Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustPerfCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0038Event event = (BcmCcd0038Event)e;
		PartnerBC command = new PartnerBCImpl();
		
		try {
			CustomerPerformanceVO customerPerformanceVO = command.searchCustPerfCode(event.getCustomerPerformanceVO().getCustGrpId());
	          eventResponse.setRsVo(customerPerformanceVO);
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0038 : SEARCH<br>
	 * Customer Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustPerfRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0038Event event = (BcmCcd0038Event)e;
		PartnerBC command = new PartnerBCImpl();
		
		try {
			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
			CustomerPerformanceVO customerPerformanceVO = command.searchCustPerfRqst(mdmDatProcVO.getRqstNo());
			
	        eventResponse.setRsVo(customerPerformanceVO);
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0038 : SEARCH<br>
	 * Customer Group Id retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustGrpId(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PartnerBC command = new PartnerBCImpl();
		
		try {
			CustomerPerformanceVO customerPerformanceVO = command.searchCustGrpId();
	          eventResponse.setRsVo(customerPerformanceVO);
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}	
	
   /**
     * multi event process<br>
     * BCM_CCD_0038 On screen Code is stored as a multi<br>
     * 
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageCustPerfCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PartnerBC command = new PartnerBCImpl();
        BcmCcd0038Event event = (BcmCcd0038Event) e;
        try {
            begin();
            command.manageCustPerfCode(event.getCustomerPerformanceVO(), account);
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * multi event process<br>
     * BCM_CCD_0038 On screen Code is stored as a multi<br>
     * 
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageCustPerfRqst(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        BcmCcd0038Event event = (BcmCcd0038Event) e;
        
        PartnerBC command = new PartnerBCImpl();
        MstMgmtBC mstCommand = new MstMgmtBCImpl();
        
        try {
        	
            begin();
            MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
            CustomerPerformanceVO customerPerformanceVO = event.getCustomerPerformanceVO();
            
            String rqstNo = mdmDatProcVO.getRqstNo();
            
            boolean isCreate = true;
			if(rqstNo != null && !rqstNo.equals("")) {
				isCreate = false;
				customerPerformanceVO.setIbflag("U");
			}
			
			if(isCreate) {
				// Create Request --> New RQST_NO search
				rqstNo = mstCommand.searchMdmDatProcRqstNo(mdmDatProcVO.getMstDatSubjCd());
				mdmDatProcVO.setRqstNo(rqstNo);
			}
			
			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
			
			if(isCreate) {
				// New MDM DATA PROCESS info added.
				mstCommand.addMdmDatProc(mdmDatProcVO);
			}
            
			// MDM_CUST_RQST, MDM_CUST_ADDR_RQST info added.
            command.manageCustPerfRqst(customerPerformanceVO, rqstNo, account);
            commit();
            
            eventResponse.setETCData("RQST_NO", rqstNo);
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
   
	  /**
	 * 
	 * BCM_CCD_0038 : Sales Rep. Code Change<br>
	 * BCM_CCD_0035 : Sales Rep. Code Change<br>
	 * Sales Rep. Code checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSlsRepCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String srepCd = new String();
		if(e instanceof BcmCcd0038Event){
			BcmCcd0038Event event = (BcmCcd0038Event)e;
			srepCd = event.getSrepCd();
		}else if(e instanceof BcmCcd0035Event){
			BcmCcd0035Event event = (BcmCcd0035Event)e;
			srepCd = event.getSrepCd();
		}
		try{
			String result = command.checkSlsRepCode(srepCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}


    
	/**
	 * BCM_CCD_0027 : SEARCH<br>
	 * Retrieve the details information with Revenue lane code.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRlaneCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0027Event event = (BcmCcd0027Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			RLaneGroupVO list = command.searchRlaneCode(event.getRLaneCd());
			eventResponse.setETCData("RQST_NO", "");
			eventResponse.setRsVo(list.getRLaneVO());
			eventResponse.setRsVoList(list.getRLaneDtlVOS());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0027 : SEARCH<br>
	 * Retrieve the details information with Revenue lane code.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRlaneCodeRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0027Event event = (BcmCcd0027Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			RLaneGroupVO list = command.searchRlaneCodeRqst(event.getRqstNo());
			eventResponse.setRsVo(list.getRLaneVO());
			eventResponse.setRsVoList(list.getRLaneDtlVOS());
			eventResponse.setETCData("RQST_NO", event.getRqstNo());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0027 : SAVE<br>
	 * Revenue lane code on the new generation, and ROS Revenue lane code to modify the details of information.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRlaneCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0027Event event = (BcmCcd0027Event)e;
		ServiceBC command = new ServiceBCImpl();
		try{
			begin();
			command.manageRlaneCode(event.getRLaneGroupVO());
			commit();
			eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0027 : SAVE<br>
	 * Revenue lane code on the new generation, and ROS Revenue lane code to modify the details of information.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRlaneCodeRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0027Event event = (BcmCcd0027Event)e;
		ServiceBC command = new ServiceBCImpl();
		MstMgmtBC mstCommand = new MstMgmtBCImpl();
		try{
			begin();
			
			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
			
            //String rqstNo = mdmDatProcVO.getRqstNo();
			String rqstNo = "";
            
            boolean isCreate = true;
			
            if(rqstNo != null && !rqstNo.equals("")) {
				isCreate = false;
			}
			
			if(isCreate) {
				// Create Request --> New RQST_NO search
				//rqstNo = mstCommand.searchMdmDatProcRqstNo(mdmDatProcVO.getMstDatSubjCd());
				//mdmDatProcVO.setRqstNo(rqstNo);
			}
			
			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
			
			if(isCreate) {
				// New MDM DATA PROCESS info added.
				//mstCommand.addMdmDatProc(mdmDatProcVO);
			}
			command.manageRlaneCodeRqst(event.getRLaneGroupVO(), rqstNo);
			commit();
			eventResponse.setETCData("RQST_NO", rqstNo);
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0027, 0029 : Vessel Service Lane onChange<br>
	 * Vessel Service Lane checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVslSlanCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String slanCd = new String();
		
		if (e instanceof BcmCcd0027Event) {
			BcmCcd0027Event event = (BcmCcd0027Event)e;
			slanCd = event.getSlanCd();
		}else if (e instanceof BcmCcd0029Event) {
			BcmCcd0029Event event = (BcmCcd0029Event)e;
			slanCd = event.getSlanCd();
		}
		try{
			String result = command.checkVslSlanCode(slanCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
    
	/**
	 * BCM_CCD_0041 : SEARCH<br>
	 * Carrier Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcAccGrp(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0041Event event = (BcmCcd0041Event)e;
		OrganizationBC command = new OrganizationBCImpl();
		
		try {
			List<OfcAccGrpVO> list = command.searchOfcAccGrp(event.getSybSysCd(), event.getAccGrpId());			
			eventResponse.setRsVoList(list);
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0041 : Save<br>
	 * Carrier Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOfcAccGrp(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0041Event event = (BcmCcd0041Event)e;
		OrganizationBC command = new OrganizationBCImpl();
		
		try {
			begin();
			command.manageOfcAccGrp(event.getOfcAccGrpVOs(), account);
			commit();
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0042 : SEARCH<br>
	 * Carrier Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcAccGrpMap(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0042Event event = (BcmCcd0042Event)e;
		OrganizationBC command = new OrganizationBCImpl();
		
		try {
			List<OfcAccGrpMapVO> list = command.searchOfcAccGrpMap(event.getSybSysCd(), event.getOfcGrpId());			
			eventResponse.setRsVoList(list);	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0042 : Save<br>
	 * Carrier Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse manageOfcAccGrpMap(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0042Event event = (BcmCcd0042Event)e;
		OrganizationBC command = new OrganizationBCImpl();
		
		try {
			begin();
			command.manageOfcAccGrpMap(event.getOfcAccGrpMapVOs(), account);
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0028 : SEARCH<br>
	 * VSL lane code details to be viewed .<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSlaneCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0028Event event = (BcmCcd0028Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			SLaneGroupVO list = command.searchSlaneCode(event.getSlaneCd());
			eventResponse.setRsVo(list.getSLaneVO());
			eventResponse.setRsVoList(list.getSLaneDirVOS());
			eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0028 : SEARCH<br>
	 * VSL lane code details to be viewed .<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSlaneRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0028Event event = (BcmCcd0028Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			SLaneGroupVO list = command.searchSlaneRqst(event.getRqstNo());
			eventResponse.setRsVo(list.getSLaneVO());
			eventResponse.setRsVoList(list.getSLaneDirVOS());
			eventResponse.setETCData("RQST_NO", event.getRqstNo());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0028 : SAVE<br>
	 * VSL lane code on the new generation, and VSL lane code to modify the details of information<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSlaneCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0028Event event = (BcmCcd0028Event)e;
		ServiceBC command = new ServiceBCImpl();
		try{
			begin();
			event.getSLaneGroupVO().getSLaneVO().setIbflag("U");
			log.debug("event.getSLaneGroupVO().getSLaneVO().getAddFlg() : " + event.getSLaneGroupVO().getSLaneVO().getAddFlg());
			log.debug("event.getSLaneGroupVO().getSLaneVO().getIbflag() : " + event.getSLaneGroupVO().getSLaneVO().getIbflag());
			command.manageSlaneCode(event.getSLaneGroupVO());
			commit();
			eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0028 : SAVE<br>
	 * VSL lane code on the new generation, and VSL lane code to modify the details of information<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSlaneRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0028Event event = (BcmCcd0028Event)e;
		ServiceBC command = new ServiceBCImpl();
		MstMgmtBC mstCommand = new MstMgmtBCImpl();
		try{
			begin();
			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
            String rqstNo = mdmDatProcVO.getRqstNo();
            
            boolean isCreate = true;
			
            if(rqstNo != null && !rqstNo.equals("")) {
				isCreate = false;
			}
			
			if(isCreate) {
				// Create Request --> New RQST_NO search
				//rqstNo = mstCommand.searchMdmDatProcRqstNo(mdmDatProcVO.getMstDatSubjCd());
				rqstNo = "";
				mdmDatProcVO.setRqstNo(rqstNo);
			}
			
			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
			
			if(isCreate) {
				// New MDM DATA PROCESS info added.
				//mstCommand.addMdmDatProc(mdmDatProcVO);
			}
			command.manageSlaneRqst(event.getSLaneGroupVO(), rqstNo);
			commit();
			eventResponse.setETCData("RQST_NO", rqstNo);
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
		
	/**
	 * BCM_CCD_0032 : SEARCH<br>
	 * Organization information retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0032Event event = (BcmCcd0032Event)e;
		OrganizationBC command = new OrganizationBCImpl();
		
		try {
			List<OfficeVO> list = command.searchOfcCode(event.getOfficeVO().getOfcCd());
			
			if(list.size() > 0){
	        	eventResponse.setETCData("input_flg","N"); 
				eventResponse.setETCData("ofc_tp_cd",list.get(0).getOfcTpCd());
				eventResponse.setETCData("ofc_knd_cd",list.get(0).getOfcKndCd());
				eventResponse.setETCData("agn_knd_cd",list.get(0).getAgnKndCd());
				
				eventResponse.setETCData("ofc_sls_delt_flg",list.get(0).getOfcSlsDeltFlg()); 
				
				eventResponse.setETCData("doc_rcvr_hide_flg",list.get(0).getDocRcvrHideFlg());  
				eventResponse.setETCData("finc_hide_flg",list.get(0).getFincHideFlg());
				eventResponse.setETCData("subs_co_flg",list.get(0).getSubsCoFlg());
				eventResponse.setETCData("sls_ofc_div_cd",list.get(0).getSlsOfcDivCd());
				
				eventResponse.setETCData("ofc_rfa_sc_use_flg",list.get(0).getOfcRfaScUseFlg());
				
				eventResponse.setETCData("sub_agn_flg",list.get(0).getSubAgnFlg());
				
				eventResponse.setETCData("ap_euro_curr_use_flg",list.get(0).getApEuroCurrUseFlg());
				eventResponse.setETCData("so_if_cd",list.get(0).getSoIfCd());
				
				eventResponse.setETCData("delt_flg",list.get(0).getDeltFlg());
				eventResponse.setETCData("ar_hd_qtr_ofc_cd",list.get(0).getArHdQtrOfcCd());
				eventResponse.setETCData("ppd_pty_tp_cd",list.get(0).getPpdPtyTpCd());
				eventResponse.setETCData("mnl_bkg_no_opt_cd",list.get(0).getMnlBkgNoOptCd());
				eventResponse.setETCData("altn_curr_div_cd",list.get(0).getAltnCurrDivCd());
				eventResponse.setETCData("finc_rgn_cd",list.get(0).getFincRgnCd());
				eventResponse.setETCData("modi_ofc_cd",list.get(0).getModiOfcCd());
				eventResponse.setETCData("modi_cost_ctr_cd",list.get(0).getModiCostCtrCd());
				eventResponse.setETCData("modi_agn_cd",list.get(0).getModiAgnCd());
				eventResponse.setETCData("finc_psdo_ofc_flg",list.get(0).getFincPsdoOfcFlg());
				eventResponse.setETCData("intl_phn_no",list.get(0).getIntlPhnNo());
				eventResponse.setETCData("intl_fax_no",list.get(0).getIntlFaxNo());
				eventResponse.setETCData("comm_if_ind_cd",list.get(0).getCommIfIndCd());
				eventResponse.setETCData("ar_agn_stl_cd",list.get(0).getArAgnStlCd());
				eventResponse.setETCData("OFC_CD",list.get(0).getOfcCd());
			}
			
			eventResponse.setRsVoList(list);          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0032 : Save<br>
	 * Add and modify Organization information.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse manageOfcCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0032Event event = (BcmCcd0032Event)e;
		OrganizationBC command = new OrganizationBCImpl();
		
		try {
			begin();
			command.manageOfcCode(event.getOfficeVO(), account);
			commit();
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0030 : OFC_CD onChange<br>
	 * BCM_CCD_0032 : OFC_CD onChange<br>
	 * BCM_CCD_0035 : OFC_CD onChange<br>
	 * BCM_CCD_0038 : OFC_CD onChange<br>
	 * BCM_CCD_0039 : OFC_CD onChange<br>
	 * BCM_CCD_0042 : OFC_CD onChange<br>
	 * BCM_CCD_0040 : OFC_CD onChange<br>
	 * BCM_CCD_0019 : sls_ofc_cd, eq_ctrl_ofc_cd, finc_ctrl_ofc_cd onChange<br>
	 * BCM_CCD_0020 : Control Office, DEM/DET Office onChange<br>
	 * OFC_CD checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkOfcCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String ofcCd = new String();
		
		if(e instanceof BcmCcd0032Event){
			BcmCcd0032Event event = (BcmCcd0032Event)e;
			ofcCd = event.getHiddenOfcCd();
		}else if(e instanceof BcmCcd0035Event){
			BcmCcd0035Event event = (BcmCcd0035Event)e;
			ofcCd = event.getOfcCd();
		}else if(e instanceof BcmCcd0038Event){
			BcmCcd0038Event event = (BcmCcd0038Event)e;
			ofcCd = event.getOfcCd();
		}else if(e instanceof BcmCcd0039Event){
			BcmCcd0039Event event = (BcmCcd0039Event)e;
			ofcCd = event.getCrCltOfcCd();
		}else if(e instanceof BcmCcd0042Event){
			BcmCcd0042Event event = (BcmCcd0042Event)e;
			ofcCd = event.getHiddenOfcCd();
		}else if(e instanceof BcmCcd0019Event){
			BcmCcd0019Event event = (BcmCcd0019Event)e;
			if(e.getFormCommand().isCommand(FormCommand.SEARCH08)){
				ofcCd = event.getSlsOfcCd();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)){
				ofcCd = event.getEqCtrlOfcCd();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)){
				ofcCd = event.getFincCtrlOfcCd();
			}
		}else if(e instanceof BcmCcd0020Event){
			BcmCcd0020Event event = (BcmCcd0020Event)e;
			if(e.getFormCommand().isCommand(FormCommand.SEARCH05)){
				ofcCd = event.getOfcCd();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)){
				ofcCd = event.getDmdtOfcCd();
			}
		}else if(e instanceof BcmCcd0030Event){
			BcmCcd0030Event event = (BcmCcd0030Event)e;
			ofcCd = event.getOfcCd();
		}else if(e instanceof BcmCcd0033Event){
			BcmCcd0033Event event = (BcmCcd0033Event)e;
			ofcCd = event.getOfcCd();
		}else if(e instanceof BcmCcd0040Event){
			BcmCcd0040Event event = (BcmCcd0040Event)e;
			ofcCd = event.getCheckCd();
		}else if(e instanceof BcmCcd0043Event){
			BcmCcd0043Event event = (BcmCcd0043Event)e;
			ofcCd = event.getCustomerReportVO().getOfcCd();
		}else if(e instanceof BcmCcd0044Event){
			BcmCcd0044Event event = (BcmCcd0044Event)e;
			ofcCd = event.getVendorReportVO().getOfcCd();
		}
		try{
			String result = command.checkOfcCode(ofcCd);
	
			if(result != null && !",".equals(result)){
				String[] arrResult = result.split(",");
				eventResponse.setETCData("result", arrResult[0]);
				eventResponse.setETCData("country", arrResult[1]);
			}else{
				eventResponse.setETCData("result", "");
				eventResponse.setETCData("country", "");
			}
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0020 : RETRIEVE<br>
	 * Yard retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0020Event event = (BcmCcd0020Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			YardVO ydVO = command.searchYardCode(event.getYdCd());
			eventResponse.setRsVo(ydVO);
			eventResponse.setETCData("CHK_NOD", command.searchPrdNod(event.getYdCd()));
			eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0020 : RETRIEVE<br>
	 * Yard retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0020Event event = (BcmCcd0020Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			YardVO ydVO = command.searchYardRqst(event.getRqstNo());
			eventResponse.setRsVo(ydVO);
			eventResponse.setETCData("RQST_NO", event.getRqstNo());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0020 : SAVE<br>
	 * Yard save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageYardCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0020Event event = (BcmCcd0020Event)e;
		LocationBC command = new LocationBCImpl();
		PrdCommonManageBCImpl prdcommand = new PrdCommonManageBCImpl();

		try{
			begin();
			YardVO ydVO = event.getYdVO();
			ydVO.setUsrId(account.getUsr_id());
			command.manageYardCode(ydVO);
			//prdcommand.multiPrdNodeByYard(ydVO);
			commit();
			eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0020 : SAVE<br>
	 * Yard save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageYardRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0020Event event = (BcmCcd0020Event)e;
		LocationBC command = new LocationBCImpl();
		//PrdCommonManageBCImpl prdcommand = new PrdCommonManageBCImpl();
		MstMgmtBC mstCommand = new MstMgmtBCImpl();
		
		try{
			begin();
			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
            String rqstNo = mdmDatProcVO.getRqstNo();
            
            boolean isCreate = true;
			
            if(rqstNo != null && !rqstNo.equals("")) {
				isCreate = false;
			}
			
			if(isCreate) {
				// Create Request --> New RQST_NO search
				rqstNo = mstCommand.searchMdmDatProcRqstNo(mdmDatProcVO.getMstDatSubjCd());
				mdmDatProcVO.setRqstNo(rqstNo);
			}
			
			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
			
			if(isCreate) {
				// New MDM DATA PROCESS info added.
				mstCommand.addMdmDatProc(mdmDatProcVO);
			}
			
			YardVO ydVO = event.getYdVO();
			ydVO.setRqstNo(rqstNo);
			ydVO.setUsrId(account.getUsr_id());
			command.manageYardRqst(ydVO);
			//prdcommand.multiPrdNodeByYard(ydVO);
			commit();
			eventResponse.setETCData("RQST_NO", rqstNo);
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
			
	/**
	 * BCM_CCD_0029 : SEARCH<br>
	 * Scope code details to be viewed .<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScpCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0029Event event = (BcmCcd0029Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			ScopeGroupVO list = command.searchScpCode(event.getScpCd());
			
			eventResponse.setRsVo(list.getScopeVO());
			eventResponse.setRsVoList(list.getScopeLaneVOS());
			eventResponse.setRsVoList(list.getScopeLimitVOS());
			eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0029 : SEARCH<br>
	 * Scope code details to be viewed .<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScpRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0029Event event = (BcmCcd0029Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			ScopeGroupVO list = command.searchScpRqst(event.getRqstNo());
			
			eventResponse.setRsVo(list.getScopeVO());
			eventResponse.setRsVoList(list.getScopeLaneVOS());
			eventResponse.setRsVoList(list.getScopeLimitVOS());
			eventResponse.setETCData("RQST_NO", event.getRqstNo());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0029 : SAVE<br>
	 * Scope code on the new generation, and Scope code to modify the details of information<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageScpCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0029Event event = (BcmCcd0029Event)e;
		ServiceBC command = new ServiceBCImpl();
		try{
			begin();
			command.manageScpCode(event.getScopeGroupVO());
			commit();
			eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0029 : SAVE<br>
	 * Scope code on the new generation, and Scope code to modify the details of information<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageScpRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0029Event event = (BcmCcd0029Event)e;
		ServiceBC command = new ServiceBCImpl();
		MstMgmtBC mstCommand = new MstMgmtBCImpl();
		try{
			begin();
			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
            String rqstNo = mdmDatProcVO.getRqstNo();
            
            boolean isCreate = true;
			
            if(rqstNo != null && !rqstNo.equals("")) {
				isCreate = false;
			}
			
			if(isCreate) {
				// Create Request --> New RQST_NO search
				rqstNo = mstCommand.searchMdmDatProcRqstNo(mdmDatProcVO.getMstDatSubjCd());
				mdmDatProcVO.setRqstNo(rqstNo);
			}
			
			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
			
			if(isCreate) {
				// New MDM DATA PROCESS info added.
				mstCommand.addMdmDatProc(mdmDatProcVO);
			}
			
			command.manageScpRqst(event.getScopeGroupVO(), rqstNo);
			commit();
			eventResponse.setETCData("RQST_NO", rqstNo);
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0022 : RETRIEVE<br>
	 * Equipment ORG Chart retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqOrgChtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0022Event event = (BcmCcd0022Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			List<EqOrgChartVO> eqOrgVO = command.searchEqOrgChtList(event.getLocType(), event.getLocation(), event.getDeltFlg());
			eventResponse.setRsVoList(eqOrgVO);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0022 : EQ ORZ CHT Del Validation<br>
	 * EQ ORZ CHT Del Validation.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDelValidation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0022Event event = (BcmCcd0022Event)e;
		LocationBC command = new LocationBCImpl();
		
		try{
			String result = command.checkDelValidation(event.getLocCd());
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0022 : SAVE<br>
	 * Equipment ORG Chart save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEqOrgCht(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0022Event event = (BcmCcd0022Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			begin();
			List<EqOrgChartVO> vos = command.manageEqOrgCht(event.getEqOrgChartVOs(), account);
			commit();
			
/*			if("P".equals(vos.get(0).getEtcStr()) || "S".equals(vos.get(0).getEtcStr())) {
				//Call EQR_CREATE_LOC_LVL_PRC Procedure 
				command.callEqrLocLvl(account.getUsr_id());
			}*/
			
			eventResponse.setETCData("msgKey", vos.get(0).getEtcStr());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	/**
	 * BCM_CCD_0039 : SEARCH<br>
	 * Credit Customer Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCrCustCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0039Event event = (BcmCcd0039Event)e;
		PartnerBC command = new PartnerBCImpl();
		String custCntCd = null;
		String custSeq = null;
		CreditCustomerVO list = new CreditCustomerVO();
		
		try {
			 
			custCntCd = event.getCreditCustomerVO().getCustCntCd();
			custSeq = event.getCreditCustomerVO().getCustSeq();
			list = command.searchCrCustCode(custCntCd, custSeq);
			if(list != null){
	        	eventResponse.setETCData("input_flg","N"); 
				eventResponse.setETCData("riss_inv_flg",list.getRissInvFlg());
				eventResponse.setETCData("cust_rlse_ctrl_flg",list.getCustRlseCtrlFlg());
				eventResponse.setETCData("cr_flg",list.getCrFlg());
				eventResponse.setETCData("xch_rt_div_cd",list.getXchRtDivCd()); 
				eventResponse.setETCData("cng_indiv_cd",list.getCngIndivCd());  
				eventResponse.setETCData("inv_iss_curr_tp_cd",list.getInvIssCurrTpCd());
				eventResponse.setETCData("pay_div_cd",list.getPayDivCd());
				eventResponse.setETCData("delt_flg",list.getDeltFlg());
				eventResponse.setRsVo(list);
			}
			
			
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0039 : Save<br>
	 * Add and modify Credit Customer Code.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse manageCrCustCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0039Event event = (BcmCcd0039Event)e;
		PartnerBC command = new PartnerBCImpl();
		
		try {
			begin();
		
			command.manageCrCustCode(event.getCreditCustomerVOS(), account);
			
			commit();
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0023 : RETRIEVE<br>
	 * Leasing Company Yard retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLseCoYd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0023Event event = (BcmCcd0023Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			LseComYardVO lseCoYdVO = command.searchLseCoYd(event.getLseCoYdCd());
			eventResponse.setRsVo(lseCoYdVO);
			if(lseCoYdVO !=null){
				eventResponse.setETCData("LSE_CO_YD_CD", lseCoYdVO.getLseCoYdCd());
				eventResponse.setETCData("intl_phn_no", lseCoYdVO.getIntlPhnNo());
			}
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0023 : SAVE<br>
	 * Leasing Company Yard save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLseCoYd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0023Event event = (BcmCcd0023Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			begin();
			LseComYardVO lseCoYdVO = event.getLseCoYdVO();
			lseCoYdVO.setUsrId(account.getUsr_id());
			command.manageLseCoYd(lseCoYdVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0030 : SEARCH<br>
	 * trd code details to be viewed.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrdCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0030Event event = (BcmCcd0030Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			TradeVO vo = command.searchTrdCode(event.getTradeCd());
			eventResponse.setRsVo(vo);
			eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0030 : SEARCH<br>
	 * trd code details to be viewed.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrdRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0030Event event = (BcmCcd0030Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			TradeVO vo = command.searchTrdRqst(event.getRqstNo());
			eventResponse.setRsVo(vo);
			eventResponse.setETCData("RQST_NO", event.getRqstNo());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0030 : SAVE<br>
	 * TRD code on the new generation, and TRD code to modify the details of information<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTrdCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0030Event event = (BcmCcd0030Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			begin();
			command.manageTrdCode(event.getTradeVO());
			commit();
			eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0030 : SAVE<br>
	 * TRD code on the new generation, and TRD code to modify the details of information<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTrdRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0030Event event = (BcmCcd0030Event)e;
		ServiceBC command = new ServiceBCImpl();
		MstMgmtBC mstCommand = new MstMgmtBCImpl();

		try{
			begin();
			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
            String rqstNo = mdmDatProcVO.getRqstNo();
            
            boolean isCreate = true;
			
            if(rqstNo != null && !rqstNo.equals("")) {
				isCreate = false;
			}
			
			if(isCreate) {
				// Create Request --> New RQST_NO search
				rqstNo = mstCommand.searchMdmDatProcRqstNo(mdmDatProcVO.getMstDatSubjCd());
				mdmDatProcVO.setRqstNo(rqstNo);
			}
			
			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
			
			if(isCreate) {
				// New MDM DATA PROCESS info added.
				mstCommand.addMdmDatProc(mdmDatProcVO);
			}
			event.getTradeVO().setRqstNo(rqstNo);
			command.manageTrdRqst(event.getTradeVO());
			commit();
			eventResponse.setETCData("RQST_NO", rqstNo);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0031 : SEARCH<br>
	 * sub trd code details to be viewed.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubTrdCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0031Event event = (BcmCcd0031Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			SubTradeVO vo = command.searchSubTrdCode(event.getSubTradeCd());
			eventResponse.setRsVo(vo);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0031 : SAVE<br>
	 * Sub trd code on the new generation, and Sub trd code to modify the details of information<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSubTrdCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0031Event event = (BcmCcd0031Event)e;
		ServiceBC command = new ServiceBCImpl();

		try{
			begin();
			command.manageSubTrdCode(event.getSubTradeVO());
			commit();
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0024 : RETRIEVE<br>
	 * DayLight Saving Time retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDyLgtSavTm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0024Event event = (BcmCcd0024Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			DaySavingTimeVO dystVO = command.searchDyLgtSavTm(event.getDstId());
			eventResponse.setRsVo(dystVO);
			if(dystVO != null){
				eventResponse.setETCData("DST_CD", dystVO.getDstId());
			}
			
	
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0024 : SAVE<br>
	 * DayLight Saving Time save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDyLgtSavTm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0024Event event = (BcmCcd0024Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			begin();
			DaySavingTimeVO dystVO = event.getDystVO();
			dystVO.setUsrId(account.getUsr_id());
			command.manageDyLgtSavTm(dystVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0033 : SEARCH<br>
	 * sls rep code details to be viewed.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSlsRepCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0033Event event = (BcmCcd0033Event)e;
		SalesRepresentativeBC command = new SalesRepresentativeBCImpl();

		try{
			SalesRepVO vo = command.searchSlsRepCode(event.getSrepCd());
			if (event!=null){
				eventResponse.setRsVo(vo);
			}
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0033 : SAVE<br>
	 *  sls rep code on the new generation, and  sls rep code to modify the details of information<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSlsRepCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0033Event event = (BcmCcd0033Event)e;
		SalesRepresentativeBC command = new SalesRepresentativeBCImpl();
		String result = "";

		try{
			begin();
				if (event.getSalesRepVO().getIbflag().equals("I")){
					result = command.searchSlsRepMaxSeq(event.getSalesRepVO().getCntCd(), account);
					event.getSalesRepVO().setSrepCd(result);
				}
				command.manageSlsRepCode(event.getSalesRepVO());
				
				if (event.getSalesRepVO().getIbflag().equals("I")){
					command.sendSrepCdToMdm(event.getSalesRepVO().getSrepCd(), account.getUsr_id(), "C");
				}else if (event.getSalesRepVO().getIbflag().equals("U")){
					command.sendSrepCdToMdm(event.getSalesRepVO().getSrepCd(), account.getUsr_id(), "U");
				}
				
			commit();
			eventResponse.setETCData("SREP_CD", event.getSalesRepVO().getSrepCd());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0033 : SAVE<br>
	 *  sls rep code on the new generation, and  sls rep code to modify the details of information<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSlsRepRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0033Event event = (BcmCcd0033Event)e;
		SalesRepresentativeBC command = new SalesRepresentativeBCImpl();
		MstMgmtBC mstCommand = new MstMgmtBCImpl();

		try{
			begin();
			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
            String rqstNo = mdmDatProcVO.getRqstNo();
            
            boolean isCreate = true;
			
            if(rqstNo != null && !rqstNo.equals("")) {
				isCreate = false;
			}
			
			if(isCreate) {
				// Create Request --> New RQST_NO search
				rqstNo = mstCommand.searchMdmDatProcRqstNo(mdmDatProcVO.getMstDatSubjCd());
				mdmDatProcVO.setRqstNo(rqstNo);
			}
			
			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
			
			if(isCreate) {
				// New MDM DATA PROCESS info added.
				mstCommand.addMdmDatProc(mdmDatProcVO);
			}
			event.getSalesRepVO().setRqstNo(rqstNo);
			command.manageSlsRepRqst(event.getSalesRepVO());
			commit();
			eventResponse.setETCData("RQST_NO", rqstNo);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0033 : SEARCH<br>
	 * sls rep code to query the last seq .<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSlsRepMaxSeq(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0033Event event = (BcmCcd0033Event)e;
		SalesRepresentativeBC command = new SalesRepresentativeBCImpl();

		try{
			String result = command.searchSlsRepMaxSeq(event.getCntCd(), account);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0035 : SEARCH<br>
	 * Customer retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0035Event event = (BcmCcd0035Event)e;
		PartnerBC command = new PartnerBCImpl();
		
		try {
			 CustomerVO vo = command.searchCustCode(event.getCustCntCd(), event.getCustSeq());
			 log.debug("getCustLglEngNm================================"+vo.getCustLglEngNm());
			 log.debug("getCustCd================================"+vo.getCustCntCd());
			 log.debug("getCustDivCd================================"+vo.getCustDivCd());
			 log.debug("getIsNewYn================================"+(event!=null?JSPUtil.getNull(event.getIsNewYn()):""));
			 
				log.debug("\n searchCustCode test @@@@@@@@@@@@@@@@@  \n");

			 if (event!=null){
				 if (event.getIsNewYn()==null || event.getIsNewYn().trim().equals("") || !event.getIsNewYn().trim().equals("Y")){
					 // 0035
					 eventResponse.setRsVo(vo);
				 } else {
					 // 0052 -- ?袁⑸뻻
					if (vo!=null){
						/** CUSTOMER MAIN **/
						List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
						rsVoList.add(vo);
						eventResponse.setRsVoList(rsVoList);
					
						
						/** CUSTOMER ADDRESS **/
						List<CustomerAddressVO> list = null;
						list = command.searchCustAddrCode(event.getCustCntCd(), event.getCustSeq(), "ALL");
						eventResponse.setRsVoList(list);
						
						
						/** CUSTOMER CONTACT POINT **/
						List<CustomerContactVO> list2 = null;
						list2 = command.searchCustCntcCode(event.getCustCntCd(), event.getCustSeq());
						eventResponse.setRsVoList(list2);
					}
				 }
			 }
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0035 : SEARCH08<br>
	 * Customer retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustMaxSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0035Event event = (BcmCcd0035Event)e;
		PartnerBC command = new PartnerBCImpl();
		
		try {
			 String result = command.searchCustMaxSeq(event.getCustCntCd());
			 eventResponse.setETCData("result", result);
			
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0035 : Save<br>
	 * Add and modify Customer Code.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse manageCustCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0035Event event = (BcmCcd0035Event)e;
		PartnerBC command = new PartnerBCImpl();
		ArrivalNoticeBCImpl bkgArCommand = new ArrivalNoticeBCImpl();
		List<MdmCustomerVO> mdmCustomerVOs = new ArrayList<MdmCustomerVO>();
		MdmCustomerVO[] customerVOs = event.getMdmCustomerVOS();
		
		
		BookingMasterMgtBC bkgMgtCommand = new BookingMasterMgtBCImpl();
		String checkSalesRepCd = null;
		MdmCustomerVO[] mdmCustomerVOS = event.getMdmCustomerVOS();
		//BkgSalesRepVO[] bkgSalesRepVOS = event.getBkgSalesRepVOS();
		

		//CustomerInfoManageBC samcommand = new CustomerInfoManageBCImpl();
		
		
		try {
			begin();
			//customerVOs[0].setUpdUsrId(account.getUsr_id());
			mdmCustomerVOs.add(customerVOs[0]);
			 command.manageCustCode(event.getCustomerIntgVO(), account);
			 String custCd = mdmCustomerVOS[0].getCustCntCd() + mdmCustomerVOS[0].getCustSeq();
			 String srepCd = mdmCustomerVOS[0].getSrepCd();
			 
			 if(!"".equals(mdmCustomerVOS[0].getSrepCd())){
				 //checkSalesRepCd = samcommand.checkSalesRepCode(custCd, srepCd);
			 
				 //samcommand.manageSalesRepInfo(mdmCustomerVOS, checkSalesRepCd, account );
				 if("".equals(checkSalesRepCd)){
					 //bkgSalesRepVOS[0].setOpCd("I");
					 //bkgSalesRepVOS[0].setDeltFlg("N");
					 //bkgMgtCommand.manageSalesRep(bkgSalesRepVOS, account);
				 }
			 }
			 //bkgArCommand.mergeBkgCustCdVal(mdmCustomerVOs);
			commit();
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * BCM_CCD_0035 : Save<br>
	 * Add and modify Customer Code.<br>
	
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse manageCustCodeTmp(Event e) throws EventException {
		EventResponse eventResponse = null;
		BcmCcd0035Event event = (BcmCcd0035Event)e;
		if (event.getIsNewYn()==null || event.getIsNewYn().trim().equals("") || !event.getIsNewYn().trim().equals("Y")){
			log.debug("\n\n  manageCustCode() ================== \n\n");
			eventResponse = manageCustCode(e);
		} else {
			log.debug("\n\n  manageCustCode2() ================== \n\n");
			eventResponse = manageCustCode2(e);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0035 : Save<br>
	 * Add and modify Customer Code.<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse manageCustCode2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0035Event event = (BcmCcd0035Event)e;
		PartnerBC command = new PartnerBCImpl();
		ArrivalNoticeBCImpl bkgArCommand = new ArrivalNoticeBCImpl();
		List<MdmCustomerVO> mdmCustomerVOs = new ArrayList<MdmCustomerVO>();
		MdmCustomerVO[] customerVOs = event.getMdmCustomerVOS();
		
		BookingMasterMgtBC bkgMgtCommand = new BookingMasterMgtBCImpl();
		String checkSalesRepCd = null;
		//BkgSalesRepVO[] bkgSalesRepVOS = event.getBkgSalesRepVOS();
		//CustomerInfoManageBC samCommand = new CustomerInfoManageBCImpl();
		
		try {
			begin();
			
			/** CUSTOMER MAIN **/
			//customerVOs[0].setUpdUsrId(account.getUsr_id());
			mdmCustomerVOs.add(customerVOs[0]);
			command.manageCustCode(event.getCustomerIntgVO(), account);
			
			 String custCd = customerVOs[0].getCustCntCd() + customerVOs[0].getCustSeq();
			 String srepCd = customerVOs[0].getSrepCd();
			 
			 if(!"".equals(customerVOs[0].getSrepCd())){
				 //checkSalesRepCd = samCommand.checkSalesRepCode(custCd, srepCd);
			 
				 //samCommand.manageSalesRepInfo(customerVOs, checkSalesRepCd, account );
				 if("".equals(checkSalesRepCd)){
					 //bkgSalesRepVOS[0].setOpCd("I");
					 //bkgSalesRepVOS[0].setDeltFlg("N");
					 //bkgMgtCommand.manageSalesRep(bkgSalesRepVOS, account);
				 }
			 }
			 
			//bkgArCommand.mergeBkgCustCdVal(mdmCustomerVOs);
			/** CUSTOMER ADDR **/
//			ArrivalNoticeBCImpl bkgcommand = new ArrivalNoticeBCImpl();
			String custCntCd = event.getCustCntCd();
			String custSeq = event.getCustSeq();
			 
			CustomerAddressVO[] custAddrVOs = event.getCustomerAddressVOS();
//			List<MdmCustomerVO> mdmCustomerVOs2 = new ArrayList<MdmCustomerVO>();
//			MdmCustomerVO[] customerVOs2 = event.getMdmCustomerVOS2();
			for(int i = 0; custAddrVOs!=null && i<custAddrVOs.length; i++){
			 	custAddrVOs[i].setCustCntCd(custCntCd);
			 	custAddrVOs[i].setCustSeq(custSeq);
	        }

//	        for(int i = 0; custAddrVOs!=null && i<custAddrVOs.length; i++){
//	           	if("1".equals(custAddrVOs[i].getAddrTpCd())&&"Y".equals(custAddrVOs[i].getPrmryChkFlg())){            	
//			       	customerVOs2[0].setCreUsrId(account.getUsr_id());
//			       	customerVOs2[0].setUpdUsrId(account.getUsr_id());
//			       	customerVOs2[0].setCustCntCd(event.getCustCntCd());
//			       	customerVOs2[0].setCustSeq(event.getCustSeq());
//			       	customerVOs2[0].setCustLglEngNm(custAddrVOs[i].getBzetNm());
//			       	mdmCustomerVOs2.add(customerVOs2[0]);
//	           	}
//	        }
	        if (custAddrVOs!=null){
	        	command.manageCustAddrCode(custAddrVOs, account);	
	        }
//	        if (mdmCustomerVOs2!=null){
//	        	bkgcommand.mergeBkgCustCdVal(mdmCustomerVOs2);	
//	        }
			/** CUSTOMER CNTC PNT **/
			CustomerContactVO[] customerContractVOs = event.getCustomerContactVOS();
			for(int i = 0; customerContractVOs!=null && i<customerContractVOs.length; i++){
				customerContractVOs[i].setCustCntCd(custCntCd);
				customerContractVOs[i].setCustSeq(custSeq);
			}
			if (customerContractVOs!=null){
				command.manageCustCntcCode(customerContractVOs, account);	
			}
						
			commit();	        
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
		return eventResponse;
	}

	/**
	 * BCM_CCD_0021 : RETRIEVE<br>
	 * Zone retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchZoneCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0021Event event = (BcmCcd0021Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			ZoneGroupVO list = command.searchZoneCode(event.getZnCd());
			eventResponse.setRsVo(list.getZoneVO());
			eventResponse.setRsVoList(list.getZoneDtlVOS());
			eventResponse.setETCData("CHK_NOD", list.getNodCd());
			eventResponse.setETCData("LSE_YD_NM", list.getLseYdNm());
			eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0021 : RETRIEVE<br>
	 * Zone retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchZoneRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0021Event event = (BcmCcd0021Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			ZoneGroupVO list = command.searchZoneRqst(event.getRqstNo());
			eventResponse.setRsVo(list.getZoneVO());
			eventResponse.setRsVoList(list.getZoneDtlVOS());
			eventResponse.setETCData("RQST_NO", event.getRqstNo());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0021 : SAVE<br>
	 * Zone save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageZoneCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0021Event event = (BcmCcd0021Event)e;
		LocationBC command = new LocationBCImpl();
		PrdCommonManageBCImpl prdcommand = new PrdCommonManageBCImpl();

		try{
			begin();
			ZoneGroupVO zoneGroupVO = event.getZoneGroupVO();
			zoneGroupVO.setUsrId(account.getUsr_id());
			command.manageZoneCode(zoneGroupVO);
			//prdcommand.multiPrdNodeByZone(zoneGroupVO.getZoneVO());
			commit();
			eventResponse.setETCData("RQST_NO", "");
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0021 : SAVE<br>
	 * Zone save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageZoneRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0021Event event = (BcmCcd0021Event)e;
		LocationBC command = new LocationBCImpl();
//		PrdCommonManageBCImpl prdcommand = new PrdCommonManageBCImpl();
		MstMgmtBC mstCommand = new MstMgmtBCImpl();
		try{
			begin();
			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
            String rqstNo = mdmDatProcVO.getRqstNo();
            
            boolean isCreate = true;
			
            if(rqstNo != null && !rqstNo.equals("")) {
				isCreate = false;
			}
			
			if(isCreate) {
				// Create Request --> New RQST_NO search
				rqstNo = mstCommand.searchMdmDatProcRqstNo(mdmDatProcVO.getMstDatSubjCd());
				mdmDatProcVO.setRqstNo(rqstNo);
			}
			
			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
			
			if(isCreate) {
				// New MDM DATA PROCESS info added.
				mstCommand.addMdmDatProc(mdmDatProcVO);
			}
			ZoneGroupVO zoneGroupVO = event.getZoneGroupVO();
			zoneGroupVO.setUsrId(account.getUsr_id());
			command.manageZoneRqst(zoneGroupVO, rqstNo);
//			prdcommand.multiPrdNodeByZone(zoneGroupVO.getZoneVO());
			commit();
			eventResponse.setETCData("RQST_NO", rqstNo);
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	/**
	 * BCM_CCD_0040 : Retrieve<br>
	 * Vendor retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVndrCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0040Event event = (BcmCcd0040Event)e;
		PartnerBC command = new PartnerBCImpl();
		
		try {
			VendorGroupVO list = command.searchVndrCode(event.getVndrSeq());
			if(list.getVendorVO() !=null){
				eventResponse.setETCData("input_flg","N"); 
			}else{
				eventResponse.setETCData("input_flg","Y"); 
			}
			eventResponse.setRsVo(list.getVendorVO());
			eventResponse.setRsVoList(list.getVendorPhnContactVOS());
			eventResponse.setRsVoList(list.getVendorEmailContactVOS());
			eventResponse.setRsVoList(list.getVendorClassificationVOS());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0040 : Retrieve<br>
	 * Vendor retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVndrRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0040Event event = (BcmCcd0040Event)e;
		PartnerBC command = new PartnerBCImpl();
		
		try {
			VendorGroupVO list = command.searchVndrRqst(event.getRqstNo());
		
			if(list.getVendorVO() !=null){
				eventResponse.setETCData("input_flg","N"); 
			}else{
				eventResponse.setETCData("input_flg","Y"); 
			}
			eventResponse.setRsVo(list.getVendorVO());
			eventResponse.setRsVoList(list.getVendorContactVOS());	
			eventResponse.setRsVoList(list.getVendorClassificationVOS());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0040 : Code Creation<br>
	 * Vendor Seq + 1 information retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVndrMaxSeq(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PartnerBC command = new PartnerBCImpl();

		try{
			String max_vndr_seq = command.searchVndrMaxSeq();
			eventResponse.setETCData("result", max_vndr_seq);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0040 : Save<br>
	 * Vendor informatin save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVndrCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0040Event event = (BcmCcd0040Event)e;
		PartnerBC command = new PartnerBCImpl();
		try{
			begin();
			command.manageVndrCode(event.getVendorGroupVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0040 : Save<br>
	 * Vendor informatin save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVndrRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0040Event event = (BcmCcd0040Event)e;
		PartnerBC command = new PartnerBCImpl();
/*		MstMgmtBC mstCommand = new MstMgmtBCImpl();
*/		try{
			begin();
/*			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
*/			VendorGroupVO vendorGroupVO = event.getVendorGroupVO();
            
            String rqstNo = vendorGroupVO.getVendorVO().getRqstNo();
            
            boolean isCreate = true;
            String ibFlag = null;
            if(rqstNo != null && !rqstNo.equals("")) {
            	ibFlag = "U";
				isCreate = false;
			}
			if(isCreate) {
				// Create Request --> New RQST_NO search
				rqstNo = command.searchVndrRqstSeq();
/*				mdmDatProcVO.setRqstNo(rqstNo);
*/			
			}
			
/*			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
*/			
/*			if(isCreate) {
				// New MDM DATA PROCESS info added.
				mstCommand.addMdmDatProc(mdmDatProcVO);
			}
*/            
			// MDM_CUST_RQST, MDM_CUST_ADDR_RQST info added.
			command.manageVndrRqst(vendorGroupVO, rqstNo, ibFlag, account);
			commit();
			eventResponse.setETCData("RQST_NO", rqstNo);
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	/**
	 * BCM_CCD_1040 : Retrieve<br>
	 * Query to similar Vendor information <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSimilarVendorName(Event e) throws EventException {
 		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			BcmCcd1040Event event = (BcmCcd1040Event)e;
			PartnerBC command = new PartnerBCImpl();
			List<SearchSimilarVendorNameVO> list = command.searchSimilarVendorName(event.getSearchSimilarVendorNameVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0032 : Vendor onChange<br>
	 *  Vender Country Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVndrCntCode(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CcdCommonBC command = new CcdCommonBCImpl();
			String vndrCd = new String();
			
			if(e instanceof BcmCcd0032Event){
				BcmCcd0032Event event = (BcmCcd0032Event)e;
				vndrCd = event.getHiddenOfcCd();
			}
			try{
				String result = command.searchVndrCntCode(vndrCd);
				eventResponse.setETCData("result", result);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
			return eventResponse;
		}
	
	/**
	 * BCM_CCD_1035 : Customer Dup checking<br>
	 *  queries is similar mame to the registered Customer.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchCustomerListByName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd1035Event event = (BcmCcd1035Event)e;
		PartnerBC command = new PartnerBCImpl();
		String custCntCd = null;
		String custNm = null;
		String locCd = null;
		String custRgstNo = null ;
		String matchRule = null ;
		List<CustomerVO> list = null;
		
		try {
			 
			custCntCd = event.getCustCntCd();
			custNm =  event.getCustNm();
			locCd = event.getLocCd();
			custRgstNo = event.getCustRgstNo();
			matchRule = event.getMatchRule();
			//log.debug("sc========ddddd==========================="+custNm);
			list = command.searchCustomerListByName(custCntCd, custNm, locCd, custRgstNo, matchRule);
		
			eventResponse.setRsVoList(list);
			
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
    }	
	
	
	/**
	 * BCM_CCD_1038 : SEARCH<br>
	 * Customer Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustGrpList(Event e) throws EventException {		
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
			List<CustomerPerformanceVO> list = new ArrayList<CustomerPerformanceVO>();
			CustomerPerformanceVO   vo = new CustomerPerformanceVO();
			BcmCcd1038Event event = null;
			if(e.getEventName().equalsIgnoreCase("BcmCcd1038Event")){
				event = (BcmCcd1038Event)e; 
				vo = event.getCustomerPerformanceVO();
			}
        	
			PartnerBC command = new PartnerBCImpl();
            list = command.searchCustGrpList(vo);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;		
	}	
	
	/**
	 * BCM_CCD_0047 : Zone Code SEARCH<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchZoneReportCount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0047Event event = (BcmCcd0047Event)e;
		ReportBC command = new ReportBCImpl();
		String znCd = event.getZnCd();
		String znNm =  event.getZnNm();
		String locCd = event.getLocCd();
		String repYdCd = event.getRepYdCd();
		String status = event.getStatus();


		try{
			String cnt  = command.searchZoneReportCount(znCd,znNm,locCd,repYdCd,status);
			eventResponse.setETCData("cnt", cnt);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0047 : Zone Code SEARCH<br>
	 * Zone Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchZoneReportCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0047Event event = (BcmCcd0047Event)e;
		ReportBC command = new ReportBCImpl();
		
		String znCd = event.getZnCd();
		String znNm =  event.getZnNm();
		String locCd = event.getLocCd();
		String repYdCd = event.getRepYdCd();
		String status = event.getStatus();

		try{
			List<ZoneReportVO> ZoneReportVos = command.searchZoneReportCode(znCd,znNm,locCd,repYdCd,status);
			eventResponse.setRsVoList(ZoneReportVos);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0046 : Yard Code Creation<br>
	 * Yard Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardReportCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0046Event event = (BcmCcd0046Event)e;
		ReportBC command = new ReportBCImpl();
		
		String ydCd = event.getYdCd();
		String ydNm =  event.getYdNm();
		String locCd = event.getLocCd();
		String ofcCd = event.getOfcCd();
		String dmdtOfcCd = event.getDmdtOfcCd();
		String status = event.getStatus();

		try{
			List<YardReportVO> YardReportVos = command.searchYardReportCode(ydCd,ydNm,locCd,ofcCd,dmdtOfcCd,status);
			eventResponse.setRsVoList(YardReportVos);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	/**
	 * BCM_CCD_0046 : Yard Code Creation<br>
	 * Yard Code Report information Count retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardReportCount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0046Event event = (BcmCcd0046Event)e;
		ReportBC command = new ReportBCImpl();

		String ydCd = event.getYdCd();
		String ydNm =  event.getYdNm();
		String locCd = event.getLocCd();
		String ofcCd = event.getOfcCd();
		String dmdtOfcCd = event.getDmdtOfcCd();
		String status = event.getStatus();
		
		try{
			String cnt = command.searchYardReportCount(ydCd,ydNm,locCd,ofcCd,dmdtOfcCd,status);
			eventResponse.setETCData("cnt", cnt);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0045 : Location Report<br>
	 * Location Report information Count retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationReportCount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0045Event event = (BcmCcd0045Event)e;
		ReportBC command = new ReportBCImpl();

		try{
			String cnt = command.searchLocationReportCount(event.getLocationReportConditionVO());
			eventResponse.setETCData("cnt", cnt);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0045 : Location Report<br>
	 * Location Report retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0045Event event = (BcmCcd0045Event)e;
		ReportBC command = new ReportBCImpl();

		try{
			List<LocationReportVO> list = command.searchLocationReportList(event.getLocationReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0043 : Customer Report<br>
	 * Customer Report information Count retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerReportCnt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0043Event event = (BcmCcd0043Event)e;
		ReportBC command = new ReportBCImpl();

		try{
			String cnt = command.searchCustomerReportCnt(event.getCustomerReportVO());
			eventResponse.setETCData("row_cnt", cnt);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0043 : Customer Report<br>
	 * Customer Report retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0043Event event = (BcmCcd0043Event)e;
		ReportBC command = new ReportBCImpl();

		try{
			// TODO 
			//List<DBRowSet> list = new ArrayList<DBRowSet>();
			//list.add(command.searchCustomerReportDBRowSet(event.getCustomerReportVO()));
			List<CustomerReportVO> list = command.searchCustomerReportList(event.getCustomerReportVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0044 : Vendor Report<br>
	 * Vendor Report information Count retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorReportCnt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0044Event event = (BcmCcd0044Event)e;
		ReportBC command = new ReportBCImpl();

		try{
			String cnt = command.searchVendorReportCnt(event.getVendorReportVO());
			eventResponse.setETCData("row_cnt", cnt);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0044 : Vendor Report<br>
	 * Vendor Report retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0044Event event = (BcmCcd0044Event)e;
		ReportBC command = new ReportBCImpl();

		try{
			List<VendorReportVO> list = command.searchVendorReportList(event.getVendorReportVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0048 : Office Report<br>
	 * Office Report information Count retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeReportCount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0048Event event = (BcmCcd0048Event)e;
		ReportBC command = new ReportBCImpl();

		String ofcCd = event.getOfcCd().trim();
		String ofcEngNm =  event.getOfcEngNm().trim();
		String locCd = event.getLocCd().trim();
		String ofcKndCd = event.getOfcKndCd().trim();
		String status = event.getStatus().trim();
		
		try{
			String cnt = command.searchOfficeReportCount(ofcCd, ofcEngNm, locCd, ofcKndCd, status);
			eventResponse.setETCData("cnt", cnt);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0051 : Office Report<br>
	 * Office Hieracy retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeHierarchyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0051Event event = (BcmCcd0051Event)e;
		ReportBC command = new ReportBCImpl();
		
//		String ofcCd = event.getOfcCd().trim();
//		String ofcEngNm =  event.getOfcEngNm().trim();
//		String locCd = event.getLocCd().trim();
//		String ofcKndCd = event.getOfcKndCd().trim();
//		String status = event.getStatus().trim();

		try{
			List<SearchOfficHierarchyVO> SearchOfficHierarchyVOs = command.searchOfficeHierarchyList(event.getSearchOfficHierarchyVO());
			eventResponse.setRsVoList(SearchOfficHierarchyVOs);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	
	/**
	 * BCM_CCD_0048 : Office Report<br>
	 * Office Report retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0048Event event = (BcmCcd0048Event)e;
		ReportBC command = new ReportBCImpl();
		
		String ofcCd = event.getOfcCd().trim();
		String ofcEngNm =  event.getOfcEngNm().trim();
		String locCd = event.getLocCd().trim();
		String ofcKndCd = event.getOfcKndCd().trim();
		String status = event.getStatus().trim();

		try{
			List<OfficeReportVO> officeReportVOs = command.searchOfficeReportList(ofcCd, ofcEngNm, locCd, ofcKndCd, status);
			eventResponse.setRsVoList(officeReportVOs);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	
	/**
	 * BCM_CCD_2001 : MdmUsrAuth <br>
	 * Master Data Authority retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmUsrAuthList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd2001Event event = (BcmCcd2001Event)e;
		MstMgmtBC command = new MstMgmtBCImpl();

		try{
			List<MdmUsrAuthVO> list = command.searchMdmUsrAuthList(event.getMdmUsrAuthVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * MDM USER AUTHORITY information add, modify,delete.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMdmUsrAuth(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd2001Event event = (BcmCcd2001Event)e;
		MstMgmtBC command = new MstMgmtBCImpl();
		
		try {
			begin();
			command.manageMdmUsrAuth(event.getMdmUsrAuthVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * MDM User Authority Type Code information retrieve.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchAuthTpCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd2002Event event = (BcmCcd2002Event)e;
		MstMgmtBC command = new MstMgmtBCImpl();

		try{
			event.getMdmDatProcVO().setRqstUsrId(account.getUsr_id());
			
			String authTpCd = command.searchAuthTpCd(event.getMdmDatProcVO());
			
			authTpCd = (authTpCd.equals("")) ? "A" : authTpCd;
			eventResponse.setETCData("AUTH_TP_CD", authTpCd);
			
			// MDAA checking
			event.getMdmDatProcVO().setMstDatSubjCd("MDAA");
			authTpCd = command.searchAuthTpCd(event.getMdmDatProcVO());
			
			String chkMDAA = (!authTpCd.equals("")) ? "Y" : "N";
			eventResponse.setETCData("MDAA_CHK", chkMDAA);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * Master Data Process's new Request No retrieve.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchMdmDatProcRqstNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd2002Event event = (BcmCcd2002Event)e;
		MstMgmtBC command = new MstMgmtBCImpl();

		try{
			String rqstNo = command.searchMdmDatProcRqstNo(event.getMdmDatProcVO().getMstDatSubjCd());
			eventResponse.setETCData("RQST_NO", rqstNo);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * BCM_CCD_2001 : MdmUsrAuth <br>
	 * Master Data Authority information retrieve.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmDatProcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd2002Event event = (BcmCcd2002Event)e;
		MstMgmtBC command = new MstMgmtBCImpl();

		try{
			event.getMdmDatProcVO().setRqstUsrId(account.getUsr_id());
			event.getMdmDatProcVO().setRqstOfcCd(account.getOfc_cd());
			
			//String ofcKndCd = command.searchOfcKndCd(account.getUsr_id());
			String ofcKndCd = command.searchOfcKndCd(account.getOfc_cd());
			event.getMdmDatProcVO().setOfcKndCd(ofcKndCd);
			
			List<MdmDatProcVO> requestList = command.searchMdmDatProcRequestList(event.getMdmDatProcVO());
			List<MdmDatProcVO> completionList = command.searchMdmDatProcCompletionList(event.getMdmDatProcVO());
			
			eventResponse.setRsVoList(requestList);
			eventResponse.setRsVoList(completionList);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}

	
	/**
	 * MDM DATA PROCESS information approve.
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyMdmDatProcApproval(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd2002Event event = (BcmCcd2002Event)e;
		
		try {
			begin();
			
			MstMgmtBC mstCommand				= new MstMgmtBCImpl();
			
			PartnerBC ptnCommand				= new PartnerBCImpl();
			ArrivalNoticeBCImpl bkgArCommand	= new ArrivalNoticeBCImpl();
			BookingMasterMgtBC bkgMgtCommand	= new BookingMasterMgtBCImpl();
			//CustomerInfoManageBC samcommand		= new CustomerInfoManageBCImpl();
			
			MdmDatProcVO[] mdmDatProcVOs = event.getMdmDatProcVOS();
			StringBuffer approvedRequest = new StringBuffer();
			for(int i=0; i < mdmDatProcVOs.length; i++) {
				MdmDatProcVO mdmDatProcVO = mdmDatProcVOs[i];
				String rqstNo = mdmDatProcVO.getRqstNo();
				
				if(rqstNo != null && !rqstNo.equals("")) {
					// check Request Process Status
					MdmDatProcVO vo = mstCommand.searchMdmDatProc(rqstNo);
					if(vo.getProcTpCd().equals("A")) {
						approvedRequest.append(rqstNo);
						approvedRequest.append(",");
						continue;
					}
				}
				
				String mstDatSubjCd = mdmDatProcVO.getMstDatSubjCd();
				
				// MDM DATA PROCESS info modify. (Process Type Code: 'O' -> 'A')
				mdmDatProcVO.setAproUsrId(account.getUsr_id());
				mdmDatProcVO.setProcTpCd("A");
				mdmDatProcVO.setUpdUsrId(account.getUsr_id());
				
				mstCommand.modifyMdmDatProc(mdmDatProcVO);
				
				
				// ====================================================================
				// mstDatSubjCd: 'CUST'
				// ====================================================================
				if(mstDatSubjCd.equals("CUST")) {
					
					//CustomerVO custRqstVO = ptnCommand.searchCustRqst(rqstNo);
					CustomerIntegrationVO custIntgVO = ptnCommand.searchCustIntgRqst(rqstNo);
					custIntgVO.getCustomerVO().setEdiIfFlg("Y");
					CustomerVO custRqstVO = custIntgVO.getCustomerVO();
					
					// CustMaxSeq retrieve
					String custSeq = mstCommand.searchCustMaxSeq(custRqstVO.getCustCntCd(), account);
					custRqstVO.setCustSeq(custSeq);
					custRqstVO.setIbflag("I");
					CustomerVO[] custRqstVOs = new CustomerVO[]{custRqstVO};
					
					ptnCommand.manageCustCode(custIntgVO, account);
					
					// MDM_CUST_RQST, MDM_CUST_ADDR_RQST info modify(CUST_SEQ include)
					custRqstVOs[0].setIbflag("U");
					//ptnCommand.manageCustRqst(custRqstVOs, rqstNo, account);
					

                    List<CustomerAddressVO> customerAddressVOs = custIntgVO.getCustomerAddressVOS();
                    //CustomerAddressVO[] customerAddressVOArr = customerAddressVOs.toArray(new CustomerAddressVO[customerAddressVOs.size()]);
                    CustomerAddressVO[] customerAddressVOArr = new CustomerAddressVO[customerAddressVOs.size()];

					if (customerAddressVOs!=null){
						for(int k=0;k<customerAddressVOs.size();k++){
							customerAddressVOArr[k] = customerAddressVOs.get(k);
							customerAddressVOArr[k].setIbflag("U");
							customerAddressVOArr[k].setCustSeq(custSeq);
		                    log.debug("H-------------------------" + customerAddressVOArr[k].getPrmryChkFlg());
							if("Y".equalsIgnoreCase(customerAddressVOArr[k].getPrmryChkFlg())) {
								custRqstVOs[0].setBzetAddr(customerAddressVOArr[k].getBzetAddr());
							}
						}
					}

					ptnCommand.manageCustRqstI(custRqstVOs, rqstNo, account); //JSY
					if (customerAddressVOs!=null){
						ptnCommand.manageCustAddrRqstI(customerAddressVOArr, custRqstVOs[0].getCustCntCd(), rqstNo, account);
					}
					
					
					
					
                    // MDM_CUST_ADDR Info modify start
//                    List<CustomerAddressVO> customerAddressVOs = ptnCommand.searchCustAddrRqst(rqstNo);
                    
                    if (customerAddressVOs != null) {
	                    for(int j=0;j<customerAddressVOs.size();j++) {
	                        customerAddressVOs.get(j).setCustSeq(custSeq);
	                        customerAddressVOs.get(j).setIbflag("I");
	                    }
	
	                    ptnCommand.manageCustAddrCode(customerAddressVOArr, account);
                    }
                    // end 

                    // MDM_CUST_CNTC_PNT Info modify start
//                    List<CustomerContactVO> custCntcRqstVOs = ptnCommand.searchCustCntcRqst(rqstNo);
                    List<CustomerContactVO> custCntcRqstVOs = custIntgVO.getCustomerContactVOS();
                    CustomerContactVO[] custCntcRqstVOArr = null;

                    if (custCntcRqstVOs != null) {
                    	custCntcRqstVOArr = new CustomerContactVO[custCntcRqstVOs.size()];
	                    for(int j=0;j<custCntcRqstVOs.size();j++) {
	                    	custCntcRqstVOs.get(j).setCustSeq(custSeq);
	                    	custCntcRqstVOs.get(j).setIbflag("I");
	                    }
	                    ptnCommand.manageCustCntcCode(custCntcRqstVOs.toArray(custCntcRqstVOArr), account);
                    }

                    if (custCntcRqstVOArr != null) {
	                    for(int j=0;j<custCntcRqstVOArr.length;j++) {
	                    	custCntcRqstVOArr[j].setIbflag("U");
	                    }

	                    ptnCommand.manageCustCntcPntRqst(custCntcRqstVOArr, rqstNo, account);	
                    }
                    // end 

					
					MdmCustomerVO mdmCustomerVO = new MdmCustomerVO();
					mdmCustomerVO.setCustSeq(custSeq);
					mdmCustomerVO.setCustCntCd(custRqstVO.getCustCntCd());
					mdmCustomerVO.setBzetAddr(custRqstVO.getBzetAddr());
					mdmCustomerVO.setSrepCd(custRqstVO.getSrepCd());
					mdmCustomerVO.setCustLglEngNm(custRqstVO.getCustLglEngNm());
					mdmCustomerVO.setOfcCd(custRqstVO.getOfcCd());
					//mdmCustomerVO.setNmdCustFlg(custRqstVO.getNmdCustFlg());
					//mdmCustomerVO.setDeltFlg("N");
					//mdmCustomerVO.setUpdUsrId(account.getUsr_id());
					
					List<MdmCustomerVO> mdmCustomerVOs	= new ArrayList<MdmCustomerVO>();
					mdmCustomerVOs.add(mdmCustomerVO);
					
					MdmCustomerVO[] mdmCustomerVOS = new MdmCustomerVO[1];
					mdmCustomerVOS[0] = mdmCustomerVO;
	
					
					String checkSalesRepCd = null;
					
					BkgSalesRepVO bkgSalesRepVO = new BkgSalesRepVO();
					bkgSalesRepVO.setCustCntCd(custRqstVO.getCustCntCd());
					bkgSalesRepVO.setCustSeq(custRqstVO.getCustSeq());
					bkgSalesRepVO.setDeltFlg("N");
					bkgSalesRepVO.setSrepCd(custRqstVO.getSrepCd());
					
					BkgSalesRepVO[] bkgSalesRepVOS = new BkgSalesRepVO[1];
					bkgSalesRepVOS[0] = bkgSalesRepVO;
					
					
					String custCd = mdmCustomerVOS[0].getCustCntCd() + mdmCustomerVOS[0].getCustSeq();
					String srepCd = mdmCustomerVOS[0].getSrepCd();
					 
					if(!"".equals(mdmCustomerVOS[0].getSrepCd())) {
						//checkSalesRepCd = samcommand.checkSalesRepCode(custCd, srepCd);
					 
						//samcommand.manageSalesRepInfo(mdmCustomerVOS, checkSalesRepCd, account );
						if("".equals(checkSalesRepCd)){
							 bkgSalesRepVOS[0].setOpCd("I");
							 bkgSalesRepVOS[0].setDeltFlg("N");
							 //bkgMgtCommand.manageSalesRep(bkgSalesRepVOS, account);
						}
					}
					
					//bkgArCommand.mergeBkgCustCdVal(mdmCustomerVOs);
					
				} else if(mstDatSubjCd.equals("VNDR")) {
					PartnerBC command = new PartnerBCImpl();
					
					String max_vndr_seq = command.searchVndrMaxSeq();
					VendorGroupVO vendorGroup = command.searchVndrRqst(rqstNo);
					
					List<VendorContactVO> vendorContactVOS = vendorGroup.getVendorContactVOS();
					List<VendorClassificationVO> vendorClassificationVOS = vendorGroup.getVendorClassificationVOS();
					
					if(vendorContactVOS != null && vendorContactVOS.size() > 0){
						VendorContactVO[] vendorContactVOs = new VendorContactVO[vendorContactVOS.size()];

						for (int j = 0; j < vendorContactVOS.size(); j++) {
							vendorContactVOs[j] = vendorContactVOS.get(j);
							vendorContactVOs[j].setIbflag("I");
						}
						vendorGroup.setVendorContactVOs(vendorContactVOs);
					}
					
					if(vendorClassificationVOS != null && vendorClassificationVOS.size() > 0){
						VendorClassificationVO[] vendorClassificationVOs = new VendorClassificationVO[vendorClassificationVOS.size()];
						for (int j = 0; j < vendorClassificationVOS.size(); j++) {
							vendorClassificationVOs[j] = vendorClassificationVOS.get(j);
							vendorClassificationVOs[j].setIbflag("I");
						}
						vendorGroup.setVendorClassificationVOs(vendorClassificationVOs);
					}
					vendorGroup.getVendorVO().setEdiIfFlg("Y");
					command.manageVndrRqst(vendorGroup, account, max_vndr_seq, rqstNo);
					
					/*
					 * [VENDOR] TPB Customer Code Check box 선택 시에 Customer 도 생성
					 */
					VendorVO vendorVO = vendorGroup.getVendorVO();
					
					if(vendorVO.getRfndPsdoCustCd().indexOf("TB") > -1){
						command.mergeMdmCustFrmVndr(vendorGroup); //insert MDM_CUSTOMER & erp i/f
						command.mergeMdmCustAddrFrmVndr(vendorVO); //insert  MDM_CUST_ADDR
					}
				} else if(mstDatSubjCd.equals("VESL")) {
					AssetBC command = new AssetBCImpl();
					
					List<ContainerVesselVO> vo = command.searchContainerVesselRqst(rqstNo);
					vo.get(0).setIbflag("I");
					ContainerVesselVO[] containerVesselVOs = new ContainerVesselVO[1];
					containerVesselVOs[0] = vo.get(0);
					String usrId = account.getUsr_id();
					command.manageContainerVessel(containerVesselVOs, usrId);
				} else if(mstDatSubjCd.equals("GCST")) {
					PartnerBC command = new PartnerBCImpl();
					
					//CustomerPerformanceVO custGrpIdVO = command.searchCustGrpId();
					CustomerPerformanceVO customerPerformanceVO = command.searchCustPerfRqst(rqstNo);
					//customerPerformanceVO.setCustGrpId(custGrpIdVO.getCustGrpId());
					
					customerPerformanceVO.setIbflag("U");
		            command.manageCustPerfRqst(customerPerformanceVO, rqstNo, account);
					
					customerPerformanceVO.setIbflag("I");
			        command.manageCustPerfCode(customerPerformanceVO, account);

				} else if(mstDatSubjCd.equals("CARR")) {
					PartnerBC command = new PartnerBCImpl();
					
					CarrierVO carriervo = command.searchCrrRqst(rqstNo);
					carriervo.setIbflag("I");
					command.manageCrrCode(carriervo, account);

				} else if(mstDatSubjCd.equals("CHRG")) {
					AccountBC command = new AccountBCImpl();

					/*String vo = command.searchChargeRqst(rqstNo);
					vo.get(0).setIbflag("I");
					ChargeVO[] chgVOs = new ChargeVO[1];
					chgVOs[0] = vo.get(0);
					String usrId = account.getUsr_id();*/
					//command.manageChargeCode(chgVOs, usrId);
				} else if(mstDatSubjCd.equals("CMDT")) {
					CommodityBC command = new CommodityBCImpl();
					
					List<CommodityVO> vo = command.searchCommodityRqst(rqstNo);
					vo.get(0).setIbflag("I");
					CommodityVO[] cmdtVOs = new CommodityVO[1];
					cmdtVOs[0] = vo.get(0);
					String usrId = account.getUsr_id();
					command.manageCommodity(cmdtVOs, usrId);
				} else if(mstDatSubjCd.equals("LOCA")) {
					LocationBC command = new LocationBCImpl();
					LocationVO locVO = command.searchLocCodeRqst(rqstNo);
					locVO.setIbflag("I");
					locVO.setUsrId(account.getUsr_id());
					locVO.setEdiIfFlg("I");
					command.manageLocCode(locVO);
				} else if(mstDatSubjCd.equals("REVL")) {
					ServiceBC command = new ServiceBCImpl();
					RLaneGroupVO list = command.searchRlaneCodeRqst(rqstNo);
					List<RLaneDtlVO> arrRlanevos = list.getRLaneDtlVOS();
					if(arrRlanevos != null && arrRlanevos.size() > 0){
						for (int j = 0; j < arrRlanevos.size(); j++) {
							arrRlanevos.get(j).setUserId(account.getUsr_id());
						}
					}
					list.getRLaneVO().setAddFlg("I");
					list.getRLaneVO().setUserId(account.getUsr_id());
					command.manageRlaneCode(list);
				} else if(mstDatSubjCd.equals("SCVL")) {
					ServiceBC command = new ServiceBCImpl();
					SLaneGroupVO list = command.searchSlaneRqst(rqstNo);
					List<SLaneDirVO> sLaneDirvo = list.getSLaneDirVOS();
					if(sLaneDirvo != null && sLaneDirvo.size() > 0){
						for (int j = 0; j < sLaneDirvo.size(); j++) {
							sLaneDirvo.get(j).setUserId(account.getUsr_id());
						}
					}
					list.getSLaneVO().setIbflag("U");
					list.getSLaneVO().setAddFlg("I");
					list.getSLaneVO().setUserId(account.getUsr_id());
					list.getSLaneVO().setEdiIfFlg("Y");
					command.manageSlaneCode(list);
				} else if(mstDatSubjCd.equals("TRDE")) {
					ServiceBC command = new ServiceBCImpl();

					TradeVO vo = command.searchTrdRqst(rqstNo);
					vo.setIbflag("I");
					vo.setUserId(account.getUsr_id());
					command.manageTrdCode(vo);
				} else if(mstDatSubjCd.equals("YARD")) {
					LocationBC command = new LocationBCImpl();
					PrdCommonManageBCImpl prdcommand = new PrdCommonManageBCImpl();
					YardVO ydVO = command.searchYardRqst(rqstNo);
					ydVO.setIbflag("I");
					ydVO.setUsrId(account.getUsr_id());
					ydVO.setEdiIfFlg("Y");
					command.manageYardCode(ydVO);
					//prdcommand.multiPrdNodeByYard(ydVO);
				} else if(mstDatSubjCd.equals("ZONE")) {
					LocationBC command = new LocationBCImpl();
					PrdCommonManageBCImpl prdcommand = new PrdCommonManageBCImpl();
					ZoneGroupVO list = command.searchZoneRqst(rqstNo);
					List<ZoneDtlVO> zoneDtlVOS = list.getZoneDtlVOS();
					if(zoneDtlVOS != null && zoneDtlVOS.size() > 0){
						ZoneDtlVO[] zoneDtlVOs = new ZoneDtlVO[zoneDtlVOS.size()];
						for (int j = 0; j < zoneDtlVOS.size(); j++) {
							zoneDtlVOs[j] = zoneDtlVOS.get(j);
							zoneDtlVOs[j].setIbflag("I");
						}
						list.setZoneDtlVOs(zoneDtlVOs);
					}
					list.setUsrId(account.getUsr_id());
					list.getZoneVO().setIbflag("I");
					command.manageZoneCode(list);
					//prdcommand.multiPrdNodeByZone(list.getZoneVO());
				} else if(mstDatSubjCd.equals("SVSP")) {
					ServiceBC command = new ServiceBCImpl();
					
					ScopeGroupVO list = command.searchScpRqst(rqstNo);
					
					list.getScopeVO().setIbflag("I");
					list.getScopeVO().setUserId(account.getUsr_id());
					
					List<ScopeLaneVO> scpLaneVOS = list.getScopeLaneVOS();
					List<ScopeLimitVO> scpLimitVOS = list.getScopeLimitVOS();
					
					if(scpLaneVOS != null && scpLaneVOS.size() > 0){
						ScopeLaneVO[] scpLaneVOs = new ScopeLaneVO[scpLaneVOS.size()];
						for (int j = 0; j < scpLaneVOS.size(); j++) {
							scpLaneVOs[j] = scpLaneVOS.get(j);
							scpLaneVOs[j].setIbflag("I");
							scpLaneVOs[j].setUserId(account.getUsr_id());
						}
						list.setScopeLaneVOS(scpLaneVOs);
					}
					
					if(scpLimitVOS != null && scpLimitVOS.size() > 0){
						ScopeLimitVO[] scpLimintVOs = new ScopeLimitVO[scpLimitVOS.size()];
						for (int j = 0; j < scpLimitVOS.size(); j++) {
							scpLimintVOs[j] = scpLimitVOS.get(j);
							scpLimintVOs[j].setIbflag("I");
							scpLimintVOs[j].setUserId(account.getUsr_id());
						}
						list.setScopeLimitVOS(scpLimintVOs);
					}
					
					command.manageScpCode(list);
				/*} else if(mstDatSubjCd.equals("SREP")) {
					SalesRepresentativeBC command = new SalesRepresentativeBCImpl();
					SalesRepVO vo = command.searchSlsRepRqst(rqstNo);
					String maxSeq = command.searchSlsRepMaxSeq(vo.getCntCd(), account);
					
					StringBuffer srepCd = new StringBuffer();
					
					srepCd.append(vo.getCntCd()).append(maxSeq);
					
					vo.setSrepCd(srepCd.toString());
					vo.setUserId(account.getUsr_id());
					vo.setIbflag("U");
					vo.setRqstNo(rqstNo);
					command.manageSlsRepRqst(vo);
					vo.setIbflag("I");
					command.manageSlsRepCode(vo);*/
				} 
				
			} // for - end
			
			if(approvedRequest != null && !"".equals(approvedRequest.toString())){
				String rqstNos = approvedRequest.toString();
				eventResponse.setETCData("approved_request", rqstNos.substring(0, rqstNos.length()-1));
			}
			commit();
			
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * MDM DATA PROCESS information modify.
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyMdmDatProcReject(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd2002Event event = (BcmCcd2002Event)e;
		MstMgmtBC command = new MstMgmtBCImpl();
		
		try {
			begin();
			command.modifyMdmDatProc(event.getMdmDatProcVO(), event.getMdmDatProcVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * MDM DATA PROCESS information modify.
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyMdmDatProc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd2002Event event = (BcmCcd2002Event)e;
		MstMgmtBC command = new MstMgmtBCImpl();
		
		try {
			begin();
			event.getMdmDatProcVO().setAproUsrId(account.getUsr_id());
			event.getMdmDatProcVO().setUpdUsrId(account.getUsr_id());
			
			command.modifyMdmDatProc(event.getMdmDatProcVO());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * MDM USER AUTHORITY information remove.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeMdmDatProc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd2002Event event = (BcmCcd2002Event)e;
		MstMgmtBC command = new MstMgmtBCImpl();
		
		try {
			begin();
			command.removeMdmDatProc(event.getMdmDatProcVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * BCM_CCD_0020 : Yard Code onChange<br>
	 * Lease Company Yard Code checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLseCoYdCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		BcmCcd0020Event event = (BcmCcd0020Event)e;
		String ydCd = event.getYdCd();
		try{
			String result = command.checkLseCoYdCode(ydCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0019 : EQ SCC Code onChange<br>
	 * BCM_CCD_0020 : EQ SCC Code onChange<br>
	 * EQ SCC Code checking.<br>
	 * 2015.01.07 not use EQ SCC in BCM_CCD_0020<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSccCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String sccCd = new String();
		if(e instanceof BcmCcd0019Event) {
			BcmCcd0019Event event = (BcmCcd0019Event)e;
			sccCd = event.getSccCd();
		}else if(e instanceof BcmCcd0020Event) {
			BcmCcd0020Event event = (BcmCcd0020Event)e;
			sccCd = event.getSccCd();
		}else if(e instanceof BcmCcd0022Event) {
			BcmCcd0022Event event = (BcmCcd0022Event)e;
			sccCd = event.getLocCd();
		}
		try{
			String result = command.checkSccCode(sccCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
		
	/**
	 * BCM_CCD_0049 : Vessel Report<br>
	 * Vessel  retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0049Event event = (BcmCcd0049Event)e;
		ReportBC command = new ReportBCImpl();
		
		String vslCd = event.getVslCd();
		String vslEngNm =  event.getVslEngNm();
		String crrCd = event.getCrrCd();
		String fdrDivCd = event.getFdrDivCd();
		String status = event.getStatus();

		try{
			List<VesselReportVO> mdmVslCntrVOs = command.searchVesselReportList(vslCd, vslEngNm, crrCd, fdrDivCd, status);
			eventResponse.setRsVoList(mdmVslCntrVOs);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0049 : Vessel Report<br>
	 * Vessel Report information Count retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselReportCount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0049Event event = (BcmCcd0049Event)e;
		ReportBC command = new ReportBCImpl();

		String vslCd = event.getVslCd();
		String vslEngNm =  event.getVslEngNm();
		String crrCd = event.getCrrCd();
		String fdrDivCd = event.getFdrDivCd();
		String status = event.getStatus();
		
		try{
			String cnt = command.searchVesselReportCount(vslCd, vslEngNm, crrCd, fdrDivCd, status);
			eventResponse.setETCData("cnt", cnt);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0050 : Charge Report<br>
	 * Charge  info  retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0050Event event = (BcmCcd0050Event)e;
		ReportBC command = new ReportBCImpl();
		
		String chgCd = event.getChgCd();
		String chgNm =  event.getChgNm();
		String repChgCd = event.getRepChgCd();
		String status = event.getStatus();

		try{
			List<ChargeReportVO> chargeReportVOs = command.searchChargeReportList(chgCd, chgNm, repChgCd, status);
			eventResponse.setRsVoList(chargeReportVOs);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0050 : Charge Report<br>
	 * Charge Report info Count.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeReportCount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0050Event event = (BcmCcd0050Event)e;
		ReportBC command = new ReportBCImpl();

		String chgCd = event.getChgCd();
		String chgNm =  event.getChgNm();
		String repChgCd = event.getRepChgCd();
		String status = event.getStatus();
		
		try{
			String cnt = command.searchChargeReportCount(chgCd, chgNm, repChgCd, status);
			eventResponse.setETCData("cnt", cnt);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * BCM_CCD_0019 : Set Country<br>
	 * Country, Sub Conti, Conti retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCountryInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0019Event event = (BcmCcd0019Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			LocationVO locationVO = command.searchCountryInfo(event.getRgnCd());
			if(locationVO != null){
				eventResponse.setETCData("cnt_cd", locationVO.getCntCd());
				eventResponse.setETCData("sconti_cd", locationVO.getScontiCd());
				eventResponse.setETCData("conti_cd", locationVO.getContiCd());
			}
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	
	/**
	 * BCM_CCD_0035 : Save<br>
	 * MDM Customer Request Info managed.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCustRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0035Event event = (BcmCcd0035Event)e;
		
		PartnerBC command = new PartnerBCImpl();
		MstMgmtBC mstCommand = new MstMgmtBCImpl();
		
		try {
			begin();
			
			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
			CustomerVO[] customerVOs = event.getCustomerVOS();
			
			String rqstNo = mdmDatProcVO.getRqstNo();
			
			boolean isCreate = true;
			if(rqstNo != null && !rqstNo.equals("")) {
				// check Request Process Status
				MdmDatProcVO vo = mstCommand.searchMdmDatProc(rqstNo);
				if(vo.getProcTpCd().equals("A")) {
					throw new EventException(new ErrorHandler("COM12114", new String[]{"process status, Request is approved. Request No.: " + rqstNo}).getMessage());
				}
				isCreate = false;
				customerVOs[0].setIbflag("U");
			}
			
			if(isCreate) {
				// Create Request --> New RQST_NO search
				rqstNo = mstCommand.searchMdmDatProcRqstNo(mdmDatProcVO.getMstDatSubjCd());
				mdmDatProcVO.setRqstNo(rqstNo);
			}
			
			mdmDatProcVO.setMstDatSubjCd(mdmDatProcVO.getMstDatSubjCd());
			mdmDatProcVO.setRqstUsrId(account.getUsr_id());
			mdmDatProcVO.setRqstOfcCd(account.getOfc_cd());
			
			if(isCreate) {
				// New MDM DATA PROCESS info added.
				mstCommand.addMdmDatProc(mdmDatProcVO);
			}
			
			CustomerIntegrationVO tmpVO = new CustomerIntegrationVO();
			CustomerAddressVO[] custAddrVOs = event.getCustomerAddressVOS();
			if (custAddrVOs!=null){
				for(int i=0;i<custAddrVOs.length;i++){
					if("Y".equalsIgnoreCase(custAddrVOs[i].getPrmryChkFlg())) {
						customerVOs[0].setBzetAddr(custAddrVOs[i].getBzetAddr());
					}
				}
				tmpVO.setCustomerAddressVOs(custAddrVOs);
			}

			// MDM_CUST_RQST, MDM_CUST_ADDR_RQST info added.
			//command.manageCustRqst(customerVOs, rqstNo, account);
			command.manageCustRqstI(customerVOs, rqstNo, account); //JSY

			command.manageCustAddrRqstI(tmpVO.getCustomerAddressVOs(), customerVOs[0].getCustCntCd(), rqstNo, account);

//			String saveflag = JSPUtil.getNull(event.getSaveflag());
			
			// CNTC_PNT
			CustomerContactVO[] customerContractVOs = event.getCustomerContactVOS();
			if (customerContractVOs!=null){
				for(int i=0;i<customerContractVOs.length;i++){
					customerContractVOs[i].setCustCntCd(customerVOs[0].getCustCntCd());
					customerContractVOs[i].setCustSeq("0");
//					if (saveflag==null || !saveflag.trim().equals("Y")){
//						customerContractVOs[i].setIbflag("I");	
//					}
				}
				command.manageCustCntcPntRqst(customerContractVOs, rqstNo, account);
			}

			commit();
			
			eventResponse.setETCData("RQST_NO", rqstNo);

		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * BCM_CCD_0035 : SEARCH<br>
	 * MDM Customer Request info retrieve
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0035Event event = (BcmCcd0035Event)e;
		PartnerBC command = new PartnerBCImpl();
		
		try {
			MdmDatProcVO mdmDatProcVO = event.getMdmDatProcVO();
			CustomerVO vo = command.searchCustRqst(mdmDatProcVO.getRqstNo());
			List<CustomerAddressVO> vo1 = command.searchCustAddrRqst(mdmDatProcVO.getRqstNo());
			List<CustomerContactVO> vo2 = command.searchCustCntcRqst(mdmDatProcVO.getRqstNo());
			
			eventResponse.setRsVoList(vo1);
			eventResponse.setRsVoList(vo2);
			eventResponse.setETCData(vo.getColumnValues());
			 
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * MDM DATA Process info retrieve.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchMdmDatProc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd2002Event event = (BcmCcd2002Event)e;
		MstMgmtBC command = new MstMgmtBCImpl();

		try{
			MdmDatProcVO mdmDatProcVO = command.searchMdmDatProc(event.getMdmDatProcVO().getRqstNo());
			
			//eventResponse.setETCData(mdmDatProcVO.getColumnValues());
			eventResponse.setETCData("SUBJ_CD", mdmDatProcVO.getMstDatSubjCd());
			eventResponse.setETCData("RQST_USR_ID", mdmDatProcVO.getRqstUsrId());
			eventResponse.setETCData("PROC_TP_CD", mdmDatProcVO.getProcTpCd());
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0020 : LOCATION & EQ SCC Validation<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocSccValidation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0020Event event = (BcmCcd0020Event)e;
		LocationBC command = new LocationBCImpl();
		
		try{
			String result = command.checkLocSccValidation(event.getYdCd().substring(0,5));
			eventResponse.setETCData("CHECK_RESULT", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0035 : SEARCH<br>
	 * MDM Customer Request info retrieve
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse isLegacyCodeUnique(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomerIntegrationVO custIntgVO = null;
		PartnerBC command = new PartnerBCImpl();
		
		if (e.getEventName().equalsIgnoreCase("BcmCcd0035Event")) {
			BcmCcd0035Event event = (BcmCcd0035Event)e;
			custIntgVO = event.getCustomerIntgVO();
		} else if (e.getEventName().equalsIgnoreCase("BcmCcd2002Event")) {
			BcmCcd2002Event event = (BcmCcd2002Event)e;
			MdmDatProcVO[] mdmDatProcVOs = event.getMdmDatProcVOS();
			
			for(int i=0; i < mdmDatProcVOs.length; i++) {
				MdmDatProcVO mdmDatProcVO = mdmDatProcVOs[i];
				String rqstNo = mdmDatProcVO.getRqstNo();
				String mstDatSubjCd = mdmDatProcVO.getMstDatSubjCd();
				if(mstDatSubjCd.equals("CUST")) {
					custIntgVO = command.searchCustIntgRqst(rqstNo);
					log.debug("START BcmCcd2002Event : " + custIntgVO.getCustomerVO().getCustCntCd());
					log.debug("START BcmCcd2002Event : " + custIntgVO.getCustomerVO().getCustSeq());
					break; // check only first request
				}
			}
		}
		
		
		try {
			if(custIntgVO != null) {
				command.isLegacyCodeUnique(custIntgVO);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0024 : multi SAVE<br>
	 * DayLight Saving Time save.<br>
	 * 160304추가 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDyLgtMultiSavTm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0024Event event = (BcmCcd0024Event)e;
		LocationBC command = new LocationBCImpl();

		try{
			begin();
				DaySavingTimeVO[] dystVOS = event.getDystVOS();
				for(DaySavingTimeVO daysavingtimevo : dystVOS){
					daysavingtimevo.setUsrId(account.getUsr_id());
					command.manageExcelDyLgtSavTm(daysavingtimevo);
				}
			
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0035 : SEARCH<br>
	 * Customer retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkExistCustCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0035Event event = (BcmCcd0035Event)e;
		PartnerBC command = new PartnerBCImpl();
		StringBuffer result = new StringBuffer("");
		try {
			List<CustomerVO> check = command.checkExistCustCode(event.getCustCntCd(), event.getCustSeq());
			
			if(check != null && check.size() > 0){
				for(int i = 0; i < check.size(); i++){
					result.append(check.get(i).getCustSeq());
					result.append(",");
				}
			}
			
			if("".equals(result.toString())){
				eventResponse.setETCData("result", "");
			}else{
				eventResponse.setETCData("result", result.toString().substring(0, result.toString().length()-1));
			}
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_2004 : open <br>
	 * History 팝업 Header + commbolist + B/L Data 조회<br>
	 * @author    Lim JinYoung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmHistList(Event e) throws EventException {
		BcmCcd2004Event event = (BcmCcd2004Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
				
        try {        	
        	MstMgmtBC command = new MstMgmtBCImpl();
			SearchMdmHistListVO paramVO = event.getSearchMdmHistListVO();
			
			paramVO.setTblNm(event.getSearchMdmHistListVO().getTblNm());
			paramVO.setColNm(event.getSearchMdmHistListVO().getColNm());
			paramVO.setUpdDt(event.getSearchMdmHistListVO().getUpdDt());	//New Code���깅줉�좎쭨
		
			//String rtvTotal = command.searchMdmHistoryCount(paramVO);
			//eventResponse.setETCData("rtv_total", rtvTotal);
			List<SearchMdmHistListVO> list = command.searchMdmHistList(paramVO); 
			
			eventResponse.setRsVoList(list);

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	

		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0053 : SEARCH<br>
	 * Customer retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRqstVndr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0053Event event = (BcmCcd0053Event)e;
		try {
			PartnerBC command = new PartnerBCImpl();
			eventResponse.setRsVoList(command.searchRqstVndr(event.getRqstNo(), event.getVndrNm(), event.getOfcCd(), event.getIPage(), event.getDeltFlg(), event.getRqstFmDt(), event.getRqstToDt()));

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0053 : MULTI01
	 * Vendor Request Approve
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageRqstVndrApro(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0053Event event = (BcmCcd0053Event)e;
		try {
			begin();
			PartnerBC command = new PartnerBCImpl();
			command.manageRqstVndrApro(event.getMdmVendorVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0053 : MULTI02
	 * Vendor Request Reject
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse manageRqstVndrRjct(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0053Event event = (BcmCcd0053Event)e;
		try {
			begin();
			PartnerBC command = new PartnerBCImpl();
			command.modifyRqstVndrRjct(event.getMdmVendorVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BCM_CCD_0040 : MULTI03
	 * Vendor Request
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse modifyVndrRqstList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0040Event event = (BcmCcd0040Event)e;
		try {
			begin();
			PartnerBC command = new PartnerBCImpl();
			command.modifyVndrRqstList(event.getRqstNo(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * BCM_CCD_0024 : SEARCH03
	 * Vendor Request
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchDstCodeSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0024Event event = (BcmCcd0024Event)e;
		try {
			begin();
			LocationBC command = new LocationBCImpl();
			String dstCode = command.searchNewDstCode(event.getDstId(), event.getDstNotAplySteCd());
			commit();

			eventResponse.setETCData("dstCode", dstCode);
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
		
	}
	
		/**
	* BCM_CCD_0032 : Center Code<br>
	* Center Code checking.<br>
	* 
	* @param Event e
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse checkCtrCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String ctrCd = new String();
			BcmCcd0032Event event = (BcmCcd0032Event)e;
			ctrCd = event.getHiddenctrCd();
		
		try{
			String result = command.checkCtrCode(ctrCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	* BCM_CCD_0054 : Vendor List<br>
	* Vendor 목록 조회<br>
	* 
	* @param Event e
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchVndrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0054Event event = (BcmCcd0054Event)e;
		try {
			PartnerBC command = new PartnerBCImpl();
			eventResponse.setRsVoList(command.searchVndrList(event.getMdmVendorVO(), event.getiPage()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	* BCM_CCD_0040 : Search10
	* Register No 중복 체크
	* 
	* @param e
	* @return
	* @throws EventException
	*/
	private EventResponse checkRgstNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BcmCcd0040Event event = (BcmCcd0040Event)e;
		try {
			begin();
			PartnerBC command = new PartnerBCImpl();
			eventResponse.setETCData("result", command.checkRgstNo(event.getCheckCd(), event.getVndrSeq()));
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
}
