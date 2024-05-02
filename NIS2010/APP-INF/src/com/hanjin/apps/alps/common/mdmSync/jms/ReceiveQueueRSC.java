/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueRSC.java
 *@FileTitle : alps Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms;

import java.util.Collection;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueBC;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmAccountBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmActivityBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmCarrierBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmChargeBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmCntrSzBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmCntrTpBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmCntrTySzBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmCntrVndrClssBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmCommodityBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmContinentBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmCountryBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmCrCustBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmCstmsPckTpBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmCurrencyBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmCustAddrBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmCustPerfGrpBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmCustRepBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmCustomerBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmDaylightBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmEqOrzChtBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmGrpCmdtBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmLocationBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmLseCoYdBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmMvmtStsBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmOrganizationBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmPckTpBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmRegionBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmRejectCustBC;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmRejectCustBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmRepChgBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmRepCmdtBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmRevLaneBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmSlsRepBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmStateBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmSubTrdBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmSubcontinentBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmSvcScpBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmSvcScpGeneralBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmSvcScpLaneBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmSvcScpLmtBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmTradeBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmVendorBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmVendorCustomerGeneralBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmVendorEtcBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmVndrCntcPntBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmVslBlkBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmVslCntrBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmVslSvcLaneGeneralBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmYardBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmZnDtlBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmZnGeneralBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.basic.ReceiveQueueMdmZoneBCImpl;
import com.hanjin.apps.alps.common.mdmSync.jms.event.ReceiveQueueEvent;
import com.hanjin.apps.alps.common.mdmSync.jms.event.ReceiveQueueEventResponse;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.RejectMdmCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.basic.ARInvoiceCustomerMgtBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.basic.ARInvoiceCustomerMgtBCImpl;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.jms.event.JmsReceiveQueueEvent;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * 받은 xml을 parsing, DB 처리를 control 한다.
 * @author KJJ
 * @see 
 * @since J2EE 1.4
 */ 
public class ReceiveQueueRSC extends ServiceCommandSupport {
	private static final long serialVersionUID = 1L;

	// private SignOnUserAccount account = null;

	/**
	 * ReceiveQueueSC 선행 작업
	 */
	public void doStart() {
		try {
			// account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("ReceiveQueueSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * ReceiveQueueSC 종료
	 */
	public void doEnd() {
		// command.doEnd();
		log.error("ReceiveQueueSC 종료");
	}

	/**
	 * command를 찾아서 적합한 메서드를 호출한다.
	 * @param e
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		

		if (e.getEventName().equalsIgnoreCase("ReceiveQueueEvent")) {
			ReceiveQueueEvent re = (ReceiveQueueEvent) e;
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// 1차
				if (re.getEvent().equals("manageMdmCommodity"))
					eventResponse = manageMdmCommodity(e);
				else if (re.getEvent().equals("manageMdmGrpCmdt"))
					eventResponse = manageMdmGrpCmdt(e);
				else if (re.getEvent().equals("manageMdmRepCmdt"))
					eventResponse = manageMdmRepCmdt(e);
				else if (re.getEvent().equals("manageMdmCustomer"))
					eventResponse = manageMdmCustomer(e);
				else if (re.getEvent().equals("manageMdmCustAddr"))
					eventResponse = manageMdmCustAddr(e);
				else if (re.getEvent().equals("manageMdmRevLane"))
					eventResponse = manageMdmRevLane(e);
				else if (re.getEvent().equals("manageMdmSlsRep"))
					eventResponse = manageMdmSlsRep(e);
				else if (re.getEvent().equals("manageMdmSubTrd"))
					eventResponse = manageMdmSubTrd(e);
				else if (re.getEvent().equals("manageMdmTrade"))
					eventResponse = manageMdmTrade(e);
				// 2차
				else if (re.getEvent().equals("manageMdmAccount"))					
					eventResponse = manageMdmAccount(e);
				else if (re.getEvent().equals("manageMdmCharge"))
					eventResponse = manageMdmCharge(e);
				else if (re.getEvent().equals("manageMdmRepChg"))
					eventResponse = manageMdmRepChg(e);
				else if (re.getEvent().equals("manageMdmCountry"))
					eventResponse = manageMdmCountry(e);
				else if (re.getEvent().equals("manageMdmCurrency"))		//2009.08.27:j:
					eventResponse = manageMdmCurrency(e);
				else if (re.getEvent().equals("manageMdmCrCust"))
					eventResponse = manageMdmCrCust(e);
				else if (re.getEvent().equals("manageMdmCustRep"))
					eventResponse = manageMdmCustRep(e);
				else if (re.getEvent().equals("manageMdmCustPerfGrp"))
					eventResponse = manageMdmCustPerfGrp(e);
				else if (re.getEvent().equals("manageMdmLocation"))
					eventResponse = manageMdmLocation(e);
				else if (re.getEvent().equals("manageMdmOrganization"))
					eventResponse = manageMdmOrganization(e);
				else if (re.getEvent().equals("manageMdmCntrVndrClss"))
					eventResponse = manageMdmCntrVndrClss(e);
				else if (re.getEvent().equals("manageMdmVndrCntcPnt"))
					eventResponse = manageMdmVndrCntcPnt(e);
				else if (re.getEvent().equals("manageMdmVendorCustomerGeneral"))
					eventResponse = manageMdmVendorCustomerGeneral(e);
				else if (re.getEvent().equals("manageMdmVendor"))
					eventResponse = manageMdmVendor(e);
				else if (re.getEvent().equals("manageMdmVslCntr"))
					eventResponse = manageMdmVslCntr(e);
				else if (re.getEvent().equals("manageMdmVslSvcLaneGeneral"))
					eventResponse = manageMdmVslSvcLaneGeneral(e);
				else if (re.getEvent().equals("manageMdmYard"))
					eventResponse = manageMdmYard(e);
				// 3차
				else if (re.getEvent().equals("manageMdmActivity"))
					eventResponse = manageMdmActivity(e);
				else if (re.getEvent().equals("manageMdmCntrSz"))
					eventResponse = manageMdmCntrSz(e);
				else if (re.getEvent().equals("manageMdmCntrTp"))
					eventResponse = manageMdmCntrTp(e);
				else if (re.getEvent().equals("manageMdmCntrTySz"))
					eventResponse = manageMdmCntrTySz(e);
				else if (re.getEvent().equals("manageMdmContinent"))
					eventResponse = manageMdmContinent(e);
				else if (re.getEvent().equals("manageMdmEqOrzCht"))
					eventResponse = manageMdmEqOrzCht(e);
				else if (re.getEvent().equals("manageMdmMvmtSts"))
					eventResponse = manageMdmMvmtSts(e);
				else if (re.getEvent().equals("manageMdmCstmsPckTp"))
					eventResponse = manageMdmCstmsPckTp(e);
				else if (re.getEvent().equals("manageMdmPckTp"))
					eventResponse = manageMdmPckTp(e);
				else if (re.getEvent().equals("manageMdmRegion"))
					eventResponse = manageMdmRegion(e);
				else if (re.getEvent().equals("manageMdmSvcScp"))
					eventResponse = manageMdmSvcScp(e);
				else if (re.getEvent().equals("manageMdmSvcScpLane"))
					eventResponse = manageMdmSvcScpLane(e);
				else if (re.getEvent().equals("manageMdmSvcScpLmt"))
					eventResponse = manageMdmSvcScpLmt(e);
				else if (re.getEvent().equals("manageMdmState"))
					eventResponse = manageMdmState(e);
				else if (re.getEvent().equals("manageMdmSubcontinent"))
					eventResponse = manageMdmSubcontinent(e);
				else if (re.getEvent().equals("manageMdmLseCoYd"))
					eventResponse = manageMdmLseCoYd(e);
				else if (re.getEvent().equals("manageMdmZone"))
					eventResponse = manageMdmZone(e);
				else if (re.getEvent().equals("manageMdmZnDtl"))
					eventResponse = manageMdmZnDtl(e);
				//추가분
				else if (re.getEvent().equals("manageMdmSvcScpGeneral"))
					eventResponse = manageMdmSvcScpGeneral(e);
				else if (re.getEvent().equals("manageMdmZnGeneral"))
					eventResponse = manageMdmZnGeneral(e);
//				2008.10.22 MDM Check Mailling Address 추가
				else if (re.getEvent().equals("manageMdmVendorEtc"))
					eventResponse = manageMdmVendorEtc(e);
				//추가 VSK 2009 11 02
				else if (re.getEvent().equals("manageMdmCarrier"))
					eventResponse = manageMdmCarrier(e);
				//추가 MDM 2009 12 03
				else if (re.getEvent().equals("manageMdmDaylight"))
					eventResponse = manageMdmDaylight(e);
				//추가 MDM 2010 01 19
				else if (re.getEvent().equals("manageMdmVslBlk"))
					eventResponse = manageMdmVslBlk(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("JmsReceiveQueueEvent")){
			JmsReceiveQueueEvent re = (JmsReceiveQueueEvent) e;
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				if (re.getEvent().equals("manageMdmCrmCustomerReject"))
					eventResponse = manageRejectCustomer(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * manageRejectCustomer
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageRejectCustomer(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		JmsReceiveQueueEvent event = (JmsReceiveQueueEvent)e;
		try {
			ReceiveQueueMdmRejectCustBC command = new ReceiveQueueMdmRejectCustBCImpl();
			begin();
			log.debug("\nmanageRejectCustomer==============================="); 
			RejectMdmCustVO vo = (RejectMdmCustVO) event.getObject();
			command.removeMDMTB(vo);
			commit();
		} catch (EventException ee) {
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * manageMdmAccount
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmAccount(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmAccountBCImpl();

			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmCharge
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCharge(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmChargeBCImpl();

			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmCommodity
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCommodity(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {

			ReceiveQueueBC command = new ReceiveQueueMdmCommodityBCImpl();

			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmCountry
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCountry(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmCountryBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models 		= command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmCurrency
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCurrency(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		
		try {
			ReceiveQueueBC command 	= new ReceiveQueueMdmCurrencyBCImpl();
			
			begin();
			XmlObject xmlObject 	= ((ReceiveQueueEvent) e).getXmlObject();
			Collection models 		= command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmCustAddr
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCustAddr(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmCustAddrBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmCustPerfGrp
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCustPerfGrp(Event e)
			throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		
		/*TESTCode you will have to delete this code at the end of the test - begin */
//		String stringXml = 
//				"<MDM018-0001 xmlns:ns0='http://irep.hanjin.com/enis-esd' xmlns='http://irep.hanjin.com/enis-esd'>" +
//				"<ApplicationArea xmlns=''>"+
//					"<OpCd>C</OpCd>"+
//					"<MsgCreDt>20090904153712</MsgCreDt>"+
//				"</ApplicationArea>" +
//                "<EAIHeader xmlns=''>" + 
//                "<InstanceId>MDM018-0001J20090904153712660</InstanceId>" +
//			      "<Parameters/>" +
//			   "</EAIHeader>" +
//			   "<DataArea xmlns=''>" +
//			   	"<CustGrpId>G-BR001460</CustGrpId>" +
//			   	"<CustGrpNm>CYKLOP</CustGrpNm>" +
//			   	"<OfcCd>SAOBB</OfcCd>" +
//			   	"<SrepCd>BR001</SrepCd>" +
//			   	"<VbsClssCd>99</VbsClssCd>" +
//			   	"<NbsClssCd1>X</NbsClssCd1>" +
//			   	"<NbsClssCd2>X</NbsClssCd2>" +
//			   	"<NbsClssCd3>X</NbsClssCd3>" +
//			   	"<CreUsrId>MDM_LOAD</CreUsrId>" +
//			   	"<CreDt>20090904153712</CreDt>" +
//			   	"<UpdUsrId>MDM_LOAD</UpdUsrId>" +
//			   	"<UpdDt>20090904153712</UpdDt>" +
//			   	"<DeltFlg>N</DeltFlg>" +
//			   "</DataArea>" +
//			"</MDM018-0001>";
		
//		MDM0180001Document 	xmlObject 			= null;
		/*TESTCode you will have to delete this code at the end of the test - end*/
		
		try {
			
			// test code - have to delete this line at a later.
//			xmlObject = MDM0180001Document.Factory.parse(stringXml);	
//			((ReceiveQueueEvent) e).setXmlObject(xmlObject);
			// test code - have to delete this line at a later.
			
			ReceiveQueueBC command = new ReceiveQueueMdmCustPerfGrpBCImpl();
			begin();
			
			// remarked below line since i do it testing.. but have to unleash it at a later. 
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmCustomer
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCustomer(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmCustomerBCImpl();
			ARInvoiceCustomerMgtBC inv_cust = new ARInvoiceCustomerMgtBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
			inv_cust.manageInvBadCustHist(models, "MDM001", "N");
			log.info("ReceiveQueueRSC===MDM001 ===manageInvBadCustHist==call==");
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmEqOrzCht
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmEqOrzCht(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmEqOrzChtBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmGrpCmdt
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmGrpCmdt(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmGrpCmdtBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmLocation
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmLocation(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmLocationBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmRegion
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmRegion(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmRegionBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmRepChg
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmRepChg(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmRepChgBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmRepCmdt
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmRepCmdt(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmRepCmdtBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmRevLane
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmRevLane(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmRevLaneBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmSlsRep
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmSlsRep(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmSlsRepBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmSubTrd
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmSubTrd(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmSubTrdBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmTrade
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmTrade(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmTradeBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmVndrCntcPnt
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmVndrCntcPnt(Event e) throws EventException {
		log.info("ReceiveQueueRSC===manageMdmVndrCntcPnt1===");
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		log.info("ReceiveQueueRSC===manageMdmVndrCntcPnt2===");
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmVndrCntcPntBCImpl();
			log.info("ReceiveQueueRSC===manageMdmVndrCntcPnt3===");
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmVendor
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmVendorCustomerGeneral(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmVendorCustomerGeneralBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmVslCntr
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmVslCntr(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmVslCntrBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmVslSvcLaneGeneral
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmVslSvcLaneGeneral(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmVslSvcLaneGeneralBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmYard
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmYard(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmYardBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmCrCust
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCrCust(Event e) throws EventException {
		//log.info("ReceiveQueueRSC===manageMdmCrCust1===");
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		//log.info("ReceiveQueueRSC===manageMdmCrCust2===");
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmCrCustBCImpl();
			ARInvoiceCustomerMgtBC inv_cust = new ARInvoiceCustomerMgtBCImpl();
			
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();

			inv_cust.manageInvBadCustHist(models,"MDM017", "F");
			log.info("ReceiveQueueRSC===MDM017 ===manageInvBadCustHist==call==");
			
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmCustRep
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCustRep(Event e) throws EventException {
		//log.info("ReceiveQueueRSC===manageMdmCustRep1===");
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		//log.info("ReceiveQueueRSC===manageMdmCustRep2===");
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmCustRepBCImpl();
//			ARInvoiceCustomerMgtBC inv_cust = new ARInvoiceCustomerMgtBCImpl();
			
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();

//			inv_cust.manageInvBadCustHist(models,"MDM063", "F");
			log.info("ReceiveQueueRSC===MDM063 ===manageInvBadCustHist==call==");
			
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * manageMdmOrganization
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmOrganization(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmOrganizationBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmCntrVndrClss
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCntrVndrClss(Event e)
			throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmCntrVndrClssBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMDM_VENDOR_TOTAL
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmVendor(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmVendorBCImpl();
			begin();
			log.error("\n //--->>> Start receiveMDMTB " );
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			log.error("\n //--->>> End receiveMDMTB " );
			
			command.ctrlMDMTB(models);
			
			log.error("\n //--->>> End ctrlMDMTB " );
			
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmActivity
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmActivity(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmActivityBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmCntrSz
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCntrSz(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmCntrSzBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmCntrTp
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCntrTp(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmCntrTpBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmCntrTySz
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCntrTySz(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmCntrTySzBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmContinent
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmContinent(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmContinentBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmMvmtSts
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmMvmtSts(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmMvmtStsBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmCstmsPckTp
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCstmsPckTp(Event e)
			throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmCstmsPckTpBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmPckTp
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmPckTp(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmPckTpBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmSvcScp
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmSvcScp(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmSvcScpBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmSvcScpLane
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmSvcScpLane(Event e)
			throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmSvcScpLaneBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmSvcScpLmt
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmSvcScpLmt(Event e)
			throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmSvcScpLmtBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmState
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmState(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmStateBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmSubcontinent
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmSubcontinent(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmSubcontinentBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmLseCoYd
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmLseCoYd(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmLseCoYdBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * manageMdmZone
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmZone(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmZoneBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * manageMdmZnDtl
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmZnDtl(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmZnDtlBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmSvcScpGeneral
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmSvcScpGeneral(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmSvcScpGeneralBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * manageMdmZnGeneral
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmZnGeneral(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmZnGeneralBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * manageMdmVendorEtc
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmVendorEtc(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmVendorEtcBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * manageMdmCarrier
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmCarrier(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmCarrierBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * manageMdmDaylight
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmDaylight(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmDaylightBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageMdmVslBlk
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageMdmVslBlk(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueMdmVslBlkBCImpl();
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveMDMTB(xmlObject);
			command.ctrlMDMTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("DAOException " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}	

}