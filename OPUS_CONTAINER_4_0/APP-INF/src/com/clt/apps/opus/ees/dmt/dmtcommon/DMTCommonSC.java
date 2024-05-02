/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonSC.java
*@FileTitle : DMTCommonFinder
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.04.27 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.basic.CommonFaxEmailBC;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.basic.CommonFaxEmailBCImpl;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.event.DmtComFaxEmailEvent;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBC;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBCImpl;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.event.DmtComEvent;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.ARCurrencyVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.AttentionVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.BookingNoVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CommonCodeVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.ContainerCargoVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CountryCdVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CurrencyVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.DMTCommonVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.LocationCdVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.PayerNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.SheetOptionByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.TariffNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.UserRoleVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.VendorNameVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBC;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetialVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-DMTCommon Business Logic ServiceCommand - handling business transaction for OPUS-DMTCommon
 * 
 * @author SungHoon, Lee
 * @see DMTCommonFinderDBDAO
 * @since J2EE 1.4
 */

public class DMTCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DMTCommon system preceding process for biz scenario<br>
	 * DMTCommonFinder related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * DMTCommon system biz scenario closing<br>
	 * DMTCommonFinder clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("DMTCommonSC 종료");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("DmtComEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRegionList(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCountryList(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRegionListByCountry(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRHQHierarchyByLocation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchCountryListByRHQ(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchCountryListByContinent(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchRHQHierarchyByRegion(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchContinetList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchTariffTypeAllList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchContinentHierarchyByLocation(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchContainterCargoList(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchContinentByCountry(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchHierarchyByRegion(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchYardListByLocation(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchCommonCode(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchRHQHierarchyByCountry(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchHierarchyByState(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchRegionState(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchCustomerName(e);
			}				
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchPayerName(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				eventResponse = searchRHQHierarchyByYard(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTariffTypeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchDemDetOfficeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchOfficeListByRhq(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchAttention(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchServiceProviderName(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchARCurrencyList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = searchCurrentDateByOffice(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) {
				eventResponse = searchTariffTypeContinentCountryRegionList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST08)) {
				eventResponse = searchTariffTypeContinentCountryRegionContainerCargoList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST09)) {
				eventResponse = searchTariffTypeCountryContinentList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = searchAllTariffTypeContinentCountryRegionList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {
				eventResponse = searchCurrentDateByUserOffice(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchDemDetSubOfficeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = checkBookingNo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchHierarchyByYard(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = searchCurrencyList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {
				eventResponse = searchRHQOfficeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)) {
				eventResponse = checkLocationCd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND08)) {
				eventResponse = searchDemDetOfficeListByRHQ(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				eventResponse = searchRHQByOffice(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND10)) {
				eventResponse = searchAROfficeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {
				eventResponse = checkCountryCd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND12)) {
				eventResponse = hasRoleAuth(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND13)) {
				eventResponse = hasSheetSet(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND14)) {
				eventResponse = searchSheetOptionByOffice(e);
			}
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND15)) {
                eventResponse = searchCommodityName(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND16)) {
                eventResponse = checkLocationCd2(e); // rhq
            }
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND17)) {
            	eventResponse = searchUserCntCode(); // ofc 별 국가조회
            }
			//입력된 두 날짜의 차이 일수를 구한다.
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND18)) {
            	eventResponse = searchDaysBetween(e);
            }
			//retrieve rhq_ofc_cd by ofc_cd
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND19)) {
            	eventResponse = searchRhqOfcCdByOfcCd(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND20)) { // search yard sub code combo list
            	eventResponse = searchYardSubCodeForCombo(e);
            }
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND21)) {
				eventResponse = searchAreaByOffice(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND22)) {
				eventResponse = checkTPBCustomerByVendor(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND23)) {
				eventResponse = searchRepCustSeq(e);
			}
			
		} else if ( e.getEventName().equalsIgnoreCase("DmtComFaxEmailEvent") ) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) { // FAX
                eventResponse = sendFaxInvoice(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) { // EAMIL
                eventResponse = sendEmailInvoice(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) { // EMAIL + DETAIL RD
                eventResponse = sendReportDesignerWithFiles(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) { // 4009 단체MAIL
                eventResponse = sendRDEmail2All(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) { // 4009 단체FAX
                eventResponse = sendRDFax2All(e);
            }
        }
		return eventResponse;
	}

	/**
	 * EES_DMT_1007 : Retrieve<br>
	 * Retrieving every Region Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRegionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<CoverageVO> list = command.searchRegionList(event.getCoverageVO());
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < list.size(); i++) {
					codes.append(list.get(i).getRgnCd()).append("=").append(list.get(i).getRgnNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			
			eventResponse.setETCData(CoverageVO.CVRG_REGION, codes.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_1007 : Retrieve<br>
	 * Retrieving every Country Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCountryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<CoverageVO> list = command.searchCountryList(event.getCoverageVO());
			StringBuffer codes = new StringBuffer();
			
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < list.size(); i++) {
					codes.append(list.get(i).getCntCd()).append("=").append(list.get(i).getCntNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			
			eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, codes.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_1008 : Retrieve<br>
	 * Retrieving every Country Info including Region Head Quarter<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCountryListByRHQ(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<CoverageVO> list = command.searchCountryListByRHQ(event.getCoverageVO());
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < list.size(); i++) {
					codes.append(list.get(i).getCntCd()).append("=").append(list.get(i).getCntNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			
			eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, codes.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving every Country Info including Continent<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCountryListByContinent(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<CoverageVO> list = command.searchCountryListByContinent(event.getCoverageVO());
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < list.size(); i++) {
					codes.append(list.get(i).getCntCd()).append("=").append(list.get(i).getCntNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			
			eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, codes.toString());		
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving every Region Info including Country<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRegionListByCountry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			CoverageVO coverageVO = event.getCoverageVO();
			List<CoverageVO> list = null;
			StringBuffer codes = new StringBuffer();
	
			String checkCd = ("US".equals(coverageVO.getCntCd()) || 
									"CA".equals(coverageVO.getCntCd())) ? CoverageVO.CVRG_STATE : CoverageVO.CVRG_REGION;
	
			if (CoverageVO.CVRG_REGION.equals(checkCd))
				list = command.searchRegionListByCountry(coverageVO);
			else
				list = command.searchStateListByCountry(coverageVO);
			
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
				
				for (int i = 0 ; i < list.size() ; i++) {
					if (CoverageVO.CVRG_REGION.equals(checkCd))
						codes.append(list.get(i).getRgnCd()).append("=").append(list.get(i).getRgnNm());
					else
						codes.append(list.get(i).getSteCd()).append("=").append(list.get(i).getSteNm());
	
					if (i < list.size() - 1) codes.append("|");
				}
			}
			
			eventResponse.setETCData(checkCd, codes.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
			
		return eventResponse;
	}
	
	/**
	 * EES_DMT_1008 : Retrieve<br>
	 * Retrieving every upper Region Header Quarter, Country, Region or State Info including Location<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQHierarchyByLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<CoverageVO> list = command.searchRHQHierarchyByLocation(event.getCoverageVO());
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData(CoverageVO.CVRG_RHQ, list.get(0).getSvrId() + "=" + "");
				eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, list.get(0).getCntCd() + "=" + list.get(0).getCntNm());
				
				if ("US".equals(list.get(0).getCntCd()) || "CA".equals(list.get(0).getCntCd())) {
					eventResponse.setETCData(CoverageVO.CVRG_STATE, list.get(0).getSteCd() + "=" + list.get(0).getSteNm());
				} 
				else {
					eventResponse.setETCData(CoverageVO.CVRG_REGION, list.get(0).getRgnCd() + "=" + list.get(0).getRgnNm());	
				}
			
				//Country Code로 RHQ select
				event.getCoverageVO().setCntCd(list.get(0).getCntCd());
			}
			
			String rtnStr = command.searchOfficByCountry(event.getCoverageVO());
			if (rtnStr != null && !rtnStr.equals("")) {
				eventResponse.setETCData(CoverageVO.CVRG_CONTINENT, rtnStr);
			}
		
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_1009 : Retrieve<br>
	 * Retrieving every upper Region Header Quarter, Country, Region or State, Location Info including Yard<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQHierarchyByYard(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<CoverageVO> list = command.searchRHQHierarchyByYard(event.getCoverageVO());
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData(CoverageVO.CVRG_RHQ, list.get(0).getSvrId() + "=" + "");
				eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, list.get(0).getCntCd() + "=" + list.get(0).getCntNm());
				eventResponse.setETCData(CoverageVO.CVRG_LOCATION, list.get(0).getLocCd() + "=" + list.get(0).getLocNm());
				
//				if ("US".equals(list.get(0).getCntCd()) || "CA".equals(list.get(0).getCntCd())) {
//					eventResponse.setETCData(CoverageVO.CVRG_STATE, list.get(0).getSteCd() + "=" + list.get(0).getSteNm());
//				} 
//				else {
//					eventResponse.setETCData(CoverageVO.CVRG_REGION, list.get(0).getRgnCd() + "=" + list.get(0).getRgnNm());	
//				}
			
				//Country Code로 RHQ select
				//event.getCoverageVO().setCntCd(list.get(0).getCntCd());
			}
			
//			String rtnStr = command.searchOfficByCountry(event.getCoverageVO());
//			if (rtnStr != null && !rtnStr.equals("")) {
//				eventResponse.setETCData(CoverageVO.CVRG_CONTINENT, rtnStr);
//			}
		
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving every upper Region Continent, Country, Region or State Info including Location<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContinentHierarchyByLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<CoverageVO> list = command.searchContinentHierarchyByLocation(event.getCoverageVO());
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData(CoverageVO.CVRG_CONTINENT, list.get(0).getContiCd() + "=" + list.get(0).getContiNm());
				eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, list.get(0).getCntCd() + "=" + list.get(0).getCntNm());
				if ("US".equals(list.get(0).getCntCd()) || "CA".equals(list.get(0).getCntCd())) {
					eventResponse.setETCData(CoverageVO.CVRG_STATE, list.get(0).getSteCd() + "=" + list.get(0).getSteNm());
				} 
				else {
					eventResponse.setETCData(CoverageVO.CVRG_REGION, list.get(0).getRgnCd() + "=" + list.get(0).getRgnNm());	
				}
			}
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3001 : Open<br>
	 * Retrieving Tariff Type List and Setting Tariff Type Info By User<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchTariffTypeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			DMTCommonVO dmtCommonVO = command.searchTariffTypeList(account.getOfc_cd(), account.getUsr_id());
			
			List<TariffNameVO> list = dmtCommonVO.getTariffNameVOs();
			String usrTrfTp = dmtCommonVO.getUserTariffType();
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getDmdtTrfCd()).append("=").append(list.get(i).getDmdtTrfNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			
			eventResponse.setETCData("common_tariff_cd", codes.toString());
			eventResponse.setETCData("user_tariff_type", usrTrfTp);
		
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_1006 : Open<br>
	 * Retrieving Tariff Type List Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchTariffTypeAllList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<TariffNameVO> list = command.searchTariffTypeList();
			StringBuffer codes = new StringBuffer();
			
			if (list != null && list.size() > 0) {
				//insert blank in the select box
				codes.append("All").append("=").append("All").append("|");
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getDmdtTrfCd()).append("=").append(list.get(i).getDmdtTrfNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			
			eventResponse.setETCData("all_tariff_cd", codes.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3001 : Open<br>
	 * Retrieving DemDet Office Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDemDetOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<OfficeNameVO> list = command.searchDemDetOfficeList();
			
			if (list != null && list.size() > 0) {
				
				StringBuffer ofc_cds = new StringBuffer();
				StringBuffer ofc_nms = new StringBuffer();
				
				for (int i = 0 ; i < list.size() ; i++) {
					OfficeNameVO vo = (OfficeNameVO)list.get(i);
					ofc_cds.append(vo.getOfcCd()).append("|");
					ofc_nms.append(vo.getOfcEngNm()).append("|");
				}
				
				ofc_cds.deleteCharAt(ofc_cds.length()-1);
				ofc_nms.deleteCharAt(ofc_nms.length()-1);
				
				eventResponse.setETCData("OFC_CD", ofc_cds.toString());
				eventResponse.setETCData("OFC_NM", ofc_nms.toString());
			}
		
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3101 : Check<br>
	 * Retrieving DemDet Office Info with RHQ Office Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeListByRhq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		DmtComEvent event = (DmtComEvent)e;
		
		try {
			
			String rhqOfcCd = event.getRhqOfcCodeVO().getShdRhqCd();
			
			if("".equals(rhqOfcCd))
				rhqOfcCd = account.getRhq_ofc_cd();
			
			List<OfficeNameVO> list = command.searchOfficeListByRhq(rhqOfcCd);
			
			if (list != null && list.size() > 0) {
				
				StringBuffer ofc_cds = new StringBuffer();
				StringBuffer ofc_nms = new StringBuffer();
				
				for (int i = 0 ; i < list.size() ; i++) {
					OfficeNameVO vo = (OfficeNameVO)list.get(i);
					ofc_cds.append(vo.getOfcCd()).append("|");
					ofc_nms.append(vo.getOfcEngNm()).append("|");
				}
				
				ofc_cds.deleteCharAt(ofc_cds.length()-1);
				ofc_nms.deleteCharAt(ofc_nms.length()-1);
				
				eventResponse.setETCData("OFC_CD", ofc_cds.toString());
				eventResponse.setETCData("OFC_NM", ofc_nms.toString());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3004 : Open<br>
	 * Retrieving DemDet Sub Office Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDemDetSubOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<String> list = command.searchDemDetSubOfficeList(event.getOfficeNameVO());
			
			if (list != null && list.size() > 0) {			
				StringBuffer ofc_cds = new StringBuffer();
				
				for (int i = 0 ; i < list.size() ; i++) {
					String ofcCd = (String)list.get(i);
					ofc_cds.append(ofcCd).append(",");
				}
				
				ofc_cds.deleteCharAt(ofc_cds.length()-1);
				eventResponse.setETCData("OFC_CD", ofc_cds.toString());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2008 : Retrieve<br>
	 * Retrieving Booking No. validation <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkBookingNo(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		CommonFinderBC 			command 		= new CommonFinderBCImpl();
		DmtComEvent 			event 			= (DmtComEvent)e;
		
		try {
			BookingNoVO bookingNoVO = command.checkBookingNo(event.getBookingNoVO());
	
			eventResponse.setETCData("BKG_NO", 	bookingNoVO.getBkgNo());		
			eventResponse.setETCData("BL_NO", 	bookingNoVO.getBlNo());
			eventResponse.setETCData("SC_NO", 	bookingNoVO.getScNo());
			eventResponse.setETCData("RFA_NO", 	bookingNoVO.getRfaNo());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
			
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving Location validation <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocationCd(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		CommonFinderBC			command 		= new CommonFinderBCImpl();
		DmtComEvent 			event 			= (DmtComEvent)e;
		
		try {
			LocationCdVO locationCdVO = command.checkLocationCd(event.getLocationCdVO());
	
			eventResponse.setETCData("LOC_CD",		locationCdVO.getLocCd());
			eventResponse.setETCData("LOC_RHQ_CD",	locationCdVO.getLocRhqCd());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
     * EES_DMT_2001 : Retrieve<br>
     * Retrieving Location validation <br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse checkLocationCd2(Event e) throws EventException {
        GeneralEventResponse    eventResponse   = new GeneralEventResponse();
        CommonFinderBC      	command         = new CommonFinderBCImpl();
        DmtComEvent             event           = (DmtComEvent)e;
        
        try {
	        LocationCdVO locationCdVO = command.checkLocationCd2(event.getLocationCdVO());
	        
	        eventResponse.setETCData("LOC_CD", locationCdVO.getLocCd());
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
        return eventResponse;
    }
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving Country validation <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCountryCd(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		CommonFinderBC			command 		= new CommonFinderBCImpl();
		DmtComEvent 			event 			= (DmtComEvent)e;
		
		try {
			CountryCdVO countryCdVO = command.checkCountryCd(event.getCountryCdVO());
			eventResponse.setETCData("CNT_CD", countryCdVO.getCntCd());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_1001 : Retrieve<br>
	 * Retrieving Continent, Country, Region or State Info with Yard Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHierarchyByYard(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<CoverageVO> list = command.searchHierarchyByYard(event.getCoverageVO());
	
			if (list != null && list.size() > 0) {
				eventResponse.setETCData(CoverageVO.CVRG_CONTINENT, list.get(0).getContiCd() + "=" + list.get(0).getContiNm());	//코드값만 존재함.
				eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, list.get(0).getCntCd() + "=" + list.get(0).getCntNm());
				
				if ("US".equals(list.get(0).getCntCd()) || "CA".equals(list.get(0).getCntCd())) {
					eventResponse.setETCData(CoverageVO.CVRG_STATE, list.get(0).getSteCd() + "=" + list.get(0).getSteNm());
				} 
				else {
					eventResponse.setETCData(CoverageVO.CVRG_REGION, list.get(0).getRgnCd() + "=" + list.get(0).getRgnNm());	
				}
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	
	}
	
	/**
	 * EES_DMT_4002 : Open<br>
	 * Retrieving Currency List Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrencyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<CurrencyVO> list = command.searchCurrencyList(event.getCoverageVO());
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getCurrCd()).append("=").append(list.get(i).getCurrNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			eventResponse.setETCData("CURRENCY", codes.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3101 : Open<br>
	 * Retrieving RHQ Office List Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CommonFinderBC command = new CommonFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<String> list = command.searchRHQOfficeList();
			
			if (list != null && list.size() > 0) {			
				StringBuffer ofcCds = new StringBuffer();
				
				for (int i = 0 ; i < list.size() ; i++) {
					String ofcCd = (String)list.get(i);
					ofcCds.append(ofcCd).append("|");
				}
				
				ofcCds.deleteCharAt(ofcCds.length()-1);
				eventResponse.setETCData("common_cd", ofcCds.toString());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/** searchAreaByOffice
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAreaByOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CommonFinderBC command = new CommonFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<String> list = command.searchAreaByOffice();
			
			if (list != null && list.size() > 0) {			
				StringBuffer sysAreaGrpIdSb  = new StringBuffer();
				
				for (int i = 0 ; i < list.size() ; i++) {
					String sysArea = (String)list.get(i);
					sysAreaGrpIdSb.append(sysArea).append("|");
				}
				
				sysAreaGrpIdSb.deleteCharAt(sysAreaGrpIdSb.length()-1);
				eventResponse.setETCData("common_cd", sysAreaGrpIdSb.toString());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * EES_DMT_1008 : Retrieve<br>
	 * Retrieving Continent, Country, State Info with Region Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQHierarchyByRegion(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		DmtComEvent 			event 			= (DmtComEvent)e;
		CommonFinderBC 			command 		= new CommonFinderBCImpl();
		
		try {
			List<CoverageVO> list = command.searchRHQHierarchyByRegion(event.getCoverageVO());
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData(CoverageVO.CVRG_RHQ, 		list.get(0).getContiCd() 	+ "=" + "");	//코드값만 존재함.
				eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, 	list.get(0).getCntCd() 		+ "=" + list.get(0).getCntNm());
				eventResponse.setETCData(CoverageVO.CVRG_REGION, 	list.get(0).getRgnCd() 		+ "=" + list.get(0).getRgnNm());
			
				//Country Code로 RHQ select
				event.getCoverageVO().setCntCd(list.get(0).getCntCd());
			}
			
			String rtnStr = command.searchOfficByCountry(event.getCoverageVO());
			if (rtnStr != null && !rtnStr.equals("")) {
				eventResponse.setETCData(CoverageVO.CVRG_CONTINENT, rtnStr);
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving All Continent Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContinetList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<CoverageVO> list = command.searchContinetList();
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getContiCd()).append("=").append(list.get(i).getContiNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			
			eventResponse.setETCData(CoverageVO.CVRG_CONTINENT, codes.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
			
		return eventResponse;
	}
	
	/**
	 * EES_DMT_1002 : Open<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainterCargoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		DmtComEvent event = (DmtComEvent)e;
		
		try {
			ContainerCargoVO cargoVO = event.getContainerCargoVO();
			List<ContainerCargoVO> list = command.searchContainterCargoList(cargoVO);
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				if ("Y".equals(cargoVO.getCodeAll()))
					codes.append("All").append("=").append("All").append("^").append("All").append("|");
				
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getCntrCgo()).append("=").append(list.get(i).getDmdtCgoTpNm()).append("^").append(list.get(i).getDmdtCntrTpNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			
			eventResponse.setETCData("CONTR_CGO", codes.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving Continent Info with Country Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContinentByCountry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		DmtComEvent event = (DmtComEvent)e;
		
		try {
			List<CoverageVO> list = command.searchContinentByCountry(event.getCoverageVO());
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData(CoverageVO.CVRG_CONTINENT, list.get(0).getContiCd() + "=" + list.get(0).getContiNm());
				eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, list.get(0).getCntCd() + "=" + list.get(0).getCntNm());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving Continent, Country, State Info with Region Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHierarchyByRegion(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		DmtComEvent event = (DmtComEvent)e;
		
		try {
			List<CoverageVO> list = command.searchHierarchyByRegion(event.getCoverageVO());
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData(CoverageVO.CVRG_REGION, 	list.get(0).getRgnCd() 		+ "=" + list.get(0).getRgnNm());
				eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, 	list.get(0).getCntCd() 		+ "=" + list.get(0).getCntNm());
				eventResponse.setETCData(CoverageVO.CVRG_CONTINENT, list.get(0).getContiCd() 	+ "=" + list.get(0).getContiNm());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving Continent, Country, Region Info with State Info State<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHierarchyByState(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		DmtComEvent event = (DmtComEvent)e;
		
		try {
			List<CoverageVO> list = command.searchHierarchyByState(event.getCoverageVO());
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData(CoverageVO.CVRG_CONTINENT, list.get(0).getContiCd() + "=" + list.get(0).getContiNm());
				eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, list.get(0).getCntCd() + "=" + list.get(0).getCntNm());
				eventResponse.setETCData(CoverageVO.CVRG_STATE, list.get(0).getSteCd() + "=" + list.get(0).getSteNm());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_1001 : Retrieve<br>
	 *  Retrieving Yard Info with Location Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardListByLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		DmtComEvent event = (DmtComEvent)e;
		
		try {
			List<CoverageVO> list = command.searchYardListByLocation(event.getCoverageVO());
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < list.size() ; i++) {
					//codes.append(list.get(i).getCntrCgo()).append("=").append(list.get(i).getDmdtCgoTpNm()).append("=").append(list.get(i).getDmdtCntrTpNm());
					codes.append(list.get(i).getYdCd()).append("=").append(list.get(i).getYdCd2());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			eventResponse.setETCData("YD", codes.toString());
		
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving Code List Info with Common Code ID <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		DmtComEvent event = (DmtComEvent)e;
		
		try {
			List<CommonCodeVO> list = command.searchCommonCode(event.getCommonCodeVO());
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getIntgCdValCtnt()).append("=").append(list.get(i).getIntgCdValDpDesc());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			eventResponse.setETCData(CommonCodeVO.KEY, codes.toString());
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_1008 : Retrieve<br>
	 * Retrieving RHQ Info with Country Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQHierarchyByCountry(Event e) throws EventException {	
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<CoverageVO> list = command.searchRHQHierarchyByCountry(event.getCoverageVO());
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData(CoverageVO.CVRG_RHQ, list.get(0).getSvrId() + "=" + "");	//코드값만 존재함.
				eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, list.get(0).getCntCd() + "=" + list.get(0).getCntNm());
			}
			
			//Country Code로 RHQ select
			String rtnStr = command.searchOfficByCountry(event.getCoverageVO());
			if (rtnStr != null && !rtnStr.equals("")) {
				eventResponse.setETCData(CoverageVO.CVRG_CONTINENT, rtnStr);
			}
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving All Region, State('CA','US') Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRegionState(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<CoverageVO> list = command.searchRegionStateList(event.getCoverageVO());
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < list.size(); i++) {
					codes.append(list.get(i).getRgnCd()).append("=").append(list.get(i).getRgnNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			
			eventResponse.setETCData(CoverageVO.CVRG_REGION, codes.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2014 : Retrieve<br>
	 * Retrieving Customer Name Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			String custNm = command.searchCustomerName(event.getCustomerVO());
			eventResponse.setETCData("CUST_NM", custNm);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2014 : Retrieve<br>
	 * Retrieving Payer Name Info. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPayerName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			PayerNameVO payerNameVO = new PayerNameVO();
			
			payerNameVO = command.searchPayerName(event.getPayerNameParamVO());
			eventResponse.setETCData("PAYER_CODE", JSPUtil.getNull(payerNameVO.getCustCd()));
			eventResponse.setETCData("PAYER_NM", JSPUtil.getNull(payerNameVO.getCustName()));
			eventResponse.setETCData("DELT_FLG", JSPUtil.getNull(payerNameVO.getDeltFlg()));
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
    /**
     * EES_DMT_1005 : Retrieve<br>
     * Retrieving Commondity Name Info.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCommodityName(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        DmtComEvent event = (DmtComEvent)e;
        CommonFinderBC command = new CommonFinderBCImpl();
        
        try {
	        String cmdt_cd = (String)event.getAttribute("cmdt_cd");
	        String rtnName = command.searchCommodityName(cmdt_cd);
	        Map<String,String> etcData = new HashMap<String,String>();
	        etcData.put("rtnName",rtnName);
	        eventResponse.setETCData(etcData);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
        return eventResponse;
    }
	
	/**
	 * EES_DMT_3101 : Retrieve<br>
	 * Retrieving DEM/DET Office Info By RHQ Office Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDemDetOfficeListByRHQ(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<String> list = command.searchDemDetOfficeListByRHQ(event.getOfficeNameVO());
			
			if (list != null && list.size() > 0) {			
				StringBuffer ofc_cds = new StringBuffer();
				
				for (int i = 0 ; i < list.size() ; i++) {
					String ofcCd = (String)list.get(i);
					ofc_cds.append(ofcCd).append(",");
				}
				
				ofc_cds.deleteCharAt(ofc_cds.length()-1);
				eventResponse.setETCData("OFC_CD", ofc_cds.toString());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3101 : Retrieve<br>
	 * Retrieving RHQ Office Name Info By Office. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQByOffice(Event e) throws EventException {
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String rhqCd = command.searchRHQByOffice(event.getOfficeNameVO());
			eventResponse.setETCData("RHQ_CD", rhqCd);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_4002 : Retrieve<br>
	 * Retrieving Atttention Info. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAttention(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<AttentionVO> list = command.searchAttention(event.getAttentionVO());
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size(); i++) {
					codes.append(list.get(i).getDmdtPayrCntcPntNm())
						.append("=").append(StringUtils.defaultString(list.get(i).getPayrCntcPntPhnNo()))
						.append("=").append(StringUtils.defaultString(list.get(i).getPayrCntcPntFaxNo()))
						.append("=").append(StringUtils.defaultString(list.get(i).getPayrCntcPntEml()))
						.append("=").append(list.get(i).getCustCntCd()).append("^").append(list.get(i).getCustCntcPntSeq()).append("^").append(list.get(i).getCustSeq());
					
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			
			eventResponse.setETCData("ATTENTION", codes.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_4002 : Retrieve<br>
	 * Retrieving Service Provider Name Info. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceProviderName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			VendorNameVO vendorNameVO = command.searchServiceProviderName(event.getVendorNameVO());
			eventResponse.setETCData("VNDR_CD", vendorNameVO.getVndrCd());
			eventResponse.setETCData("VNDR_NM", vendorNameVO.getVndrNm());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_4002 : Retrieve<br>
	 * Retrieving ARCurrency List Info. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARCurrencyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CommonFinderBC command = new CommonFinderBCImpl();
		DmtComEvent event = (DmtComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			//List<ARCurrencyVO> list = command.searchARCurrencyList(account.getOfc_cd());
			List<ARCurrencyVO> list = command.searchARCurrencyList(event.getOfficeNameVO().getOfcCd(), event.getOfficeNameVO().getJspno());
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getArCurrCd()).append("=").append(list.get(i).getArCurrCd());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			
			eventResponse.setETCData("AR_CURRENCY", codes.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_4002 : Open<br>
	 * Retrieving Current Date By OFC_CD. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrentDateByOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CommonFinderBC command = new CommonFinderBCImpl();
		DmtComEvent event = (DmtComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String curr_day = command.searchCurrentDateByOffice(event.getOfficeNameVO().getOfcCd());
			eventResponse.setETCData("OFC_CURR_DAY", curr_day);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * EES_DMT_4002 : Payer Code<br>
	 * Checking Vendor Code TPB Customer <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkTPBCustomerByVendor(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			PayerNameVO payerNameVO = command.checkTPBCustomerByVendor(event.getPayerNameParamVO());
			eventResponse.setETCData("CUST_SEQ", payerNameVO.getCustCd());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3001 : Open<br>
	 * Retrieving Current Date By User OFC_CD. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrentDateByUserOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CommonFinderBC command = new CommonFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String curr_day = command.searchCurrentDateByOffice(account.getOfc_cd());
			eventResponse.setETCData("OFC_CURR_DAY", curr_day);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_5001-1 : Open<br>
	 * Retrieving AR Office Info By Office Code. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAROfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CommonFinderBC command = new CommonFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<OfficeNameVO> list = command.searchAROfficeList(account.getOfc_cd(), account.getRhq_ofc_cd() );
			
			if (list != null && list.size() > 0) {
				StringBuffer ofc_cds = new StringBuffer();
				StringBuffer ofc_nms = new StringBuffer();
				
				for (int i = 0 ; i < list.size() ; i++) {
					OfficeNameVO vo = (OfficeNameVO)list.get(i);
					ofc_cds.append(vo.getOfcCd()).append("|");
					ofc_nms.append(vo.getOfcEngNm()).append("|");
				}
				
				ofc_cds.deleteCharAt(ofc_cds.length()-1);
				ofc_nms.deleteCharAt(ofc_nms.length()-1);
				
				eventResponse.setETCData("OFC_CD", ofc_cds.toString());
				eventResponse.setETCData("OFC_NM", ofc_nms.toString());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

    /*************************************zzang start *****************************************************/

    /**
     * EES_DMT_4002 : Fax Send<br>
     * DOM_FAX_EMAIL : Sending DMT FAX and Creating Log<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */

    private EventResponse sendFaxInvoice(Event e) throws EventException {
        CommonFaxEmailBC command = new CommonFaxEmailBCImpl();
        DmtComFaxEmailEvent event = (DmtComFaxEmailEvent) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
	        String tRcvr = event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlFaxNo();
	        begin();
	
	        String returnKey = command.sendFaxInvoice( event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO());
	        log.debug("####### sendFaxInvoice returnKey [" + returnKey + "]");
	        if ( !returnKey.equals("") && !returnKey.equals("null") && returnKey != null ) {
	            eventResponse.setUserMessage("Transmitted to Fax server successfully");
	            eventResponse.setCustomData("key", returnKey);
	        } else {
	            eventResponse.setUserMessage("FAIL TO CREATE FAX_SND_NO TABLE COM_FAX_SND_INFO");
	            eventResponse.setCustomData("key", "");
	            //eventResponse.setCustomData("key", returnKey);
	        }        
	
	        commit();
	        
	        log.debug("\n ####### sendFaxInvoice tRcvr [" + tRcvr + "]");
	        StringTokenizer stRcvr = new StringTokenizer( tRcvr , ";" );
	        while( stRcvr.hasMoreTokens() ){
	            String tRcvvVal = stRcvr.nextToken();
	            log.debug("\n ####### sendFaxInvoice tRcvvVal [" + tRcvvVal + "]");
	            event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFaxNo( tRcvvVal );
	            begin();
	            event.getDmtComFaxSndInfoVO().setBatFlg("F");
	            command.insertDmtFaxEmlSndHistory( returnKey , event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
	            commit();
	        }
	        log.debug("\n ###################################################### END SC sendFaxInvoice");
	        
	    } catch(EventException ex) {
	    	rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
        
        return eventResponse;
    }

    /*************************************zzang end *****************************************************/
    
    
    /*************************************zzang start *****************************************************/

    /**
     * EES_DMT_4002 : Email Send<br>
     * DOM_FAX_EMAIL : Sending DMT MAIL and Creating Log<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */

    private EventResponse sendEmailInvoice(Event e) throws EventException {
        log.debug("\n ###################################################### START SC sendEmailInvoice");
        CommonFaxEmailBC command = new CommonFaxEmailBCImpl();
        DmtComFaxEmailEvent event = (DmtComFaxEmailEvent) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
	        String tRcvr = event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlRcvrAdd();
	        String returnKey = "";
	        boolean isDigitalSign = false;
	        begin();
	        event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd( tRcvr );
	        
	        //2016.05.13 FTP 처리 부분 임시 주석 처리 Start =======================================
	        //2016.03.24 Add
    		log.debug("\n ####### SC sendEmailInvoice Before OFC_CD ["+account.getOfc_cd()+"] CNT_CD ["+account.getCnt_cd()+"]");
    		String cntCd = command.searchCountryCodeByOfcCd(account);
    		
    		if(StringUtils.isEmpty(cntCd)){
    			cntCd = account.getCnt_cd();
    		}
    		log.debug("\n ####### SC sendEmailInvoice After OFC_CD ["+account.getOfc_cd()+"] CNT_CD ["+cntCd+"]");
	        
    		//2016.03.24 Login Office Code의 Country Code : IN, Invoice Email 일 경우에만 Digital Sign FTP로 파일 전송.
    		if(cntCd.equals("IN") && event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlDocTp().equals("I")){
    			log.debug("\n ####### SC sendEmailInvoice sendDigitalSignInvoiceByFTP Call.");
    			returnKey = command.sendDigitalSignInvoiceByFTP( event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
    			isDigitalSign = true;
    		}else{
    			log.debug("\n ####### SC sendEmailInvoice sendEmailInvoice Call.");
    			returnKey = command.sendEmailInvoice( event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
    			isDigitalSign = false;
    		}
    		//2016.05.13 FTP 처리 부분 임시 주석 처리 E n d =======================================
    		
    		//2016.05.13 FTP 처리 부분 임시 주석 처리.
    		log.debug("\n ####### SC sendEmailInvoice sendEmailInvoice Call [2016.05.13 Modify].");
//			returnKey = command.sendEmailInvoice( event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
//			isDigitalSign = false;
    		
	        //returnKey = command.sendEmailInvoice( event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
	        log.debug("\n ####### SC sendEmailInvoice returnKey [" + returnKey + "]");
	        
	        if ( !returnKey.equals("") && !returnKey.equals("null") && returnKey != null ) {
	            eventResponse.setUserMessage("Transmitted to E-mail server successfully");
	            eventResponse.setCustomData("key", returnKey);
	        } else {
	            eventResponse.setUserMessage("FAIL TO CREATE EML_SND_NO TABLE COM_EML_SND_INFO");
	            eventResponse.setCustomData("key", "");
	            //eventResponse.setCustomData("key", returnKey);
	        }
	        commit();        
	        
	        if(isDigitalSign){
	        	log.debug("\n ####### SC sendEmailInvoice sendDigitalSignInvoiceByFTP History Call.");
	        	event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd("Digital Sign FTP");
	        	//event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlTitle("Digital Sign FTP");
	            begin();
	            event.getDmtComFaxSndInfoVO().setBatFlg("E");
	            command.insertDmtFaxEmlSndHistory( returnKey , event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
	            commit();
	        }else{
	        	log.debug("\n ####### SC sendEmailInvoice History Call.");
		        tRcvr = event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlRcvrAdd();
		        log.debug("\n ####### SC sendEmailInvoice tRcvr [" + tRcvr + "]");
		        StringTokenizer stRcvr = new StringTokenizer( tRcvr , ";" );
		        while( stRcvr.hasMoreTokens() ){
		            String tRcvvVal = stRcvr.nextToken();
		            log.debug("\n ####### SC sendEmailInvoice tRcvvVal [" + tRcvvVal + "]");
		            event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd( tRcvvVal );
		            begin();
		            event.getDmtComFaxSndInfoVO().setBatFlg("E");
		            command.insertDmtFaxEmlSndHistory( returnKey , event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
		            commit();
		        }
	        }
	        log.debug("\n ###################################################### END SC sendEmailInvoice");
        
        } catch(EventException ex) {
	    	rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
	        
		return eventResponse;
    }

	/**
	 * EES_DMT_2003 : Open<br>
	 * Retrieving user having authority.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse hasRoleAuth(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			UserRoleVO returnVO = command.hasRoleAuth(event.getUserRoleVO());
			eventResponse.setETCData("ROLE_PERMIT", returnVO.getIsAuthorized());
			eventResponse.setETCData("ROLE_AUTH", 	returnVO.getUsrRoleCd());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_4004 : Retrieve<br>
	 * Retrieving existing SHEET SET.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse hasSheetSet(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			boolean result = command.hasSheetSet(event.getSheetSetVO());
			eventResponse.setETCData("RESULT", result ? "Y" : "N");
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
    /*************************************zzang end *****************************************************/
	
	
    /**
     * EES_DMT_4002 : Open<br>
     * DOM_FAX_EMAIL : Sending DMT MULTI RD ATTACH MAIL and Creating Log<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */

    private EventResponse sendReportDesignerWithFiles(Event e) throws EventException {
        log.debug("\n ###################################################### START SC sendReportDesignerWithFiles");
        CommonFaxEmailBC command = new CommonFaxEmailBCImpl();
        DmtComFaxEmailEvent event = (DmtComFaxEmailEvent) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
	        String dfltEml ="";
	        dfltEml = command.searchSenderEmailByUser(account);
	        
	       if(dfltEml.equals("") || dfltEml == null){
        	    eventResponse.setUserMessage("There is no your E-mail address.\n[ HJS email sender address update advice ]\n  1st.  Your email address is required to send email.\n  2nd.  Please open : Comm > Security\n  3rd.  Pease input your email address at \"Email\" column.");
        	}else{      	
        	
        	
	        String tRcvr = event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlRcvrAdd();
	        tRcvr.replace( "||" , ";" );
	        event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd( tRcvr );
	        
	        begin();
	        String returnKey = command.sendReportDesignerWithFiles( event.getDmtComRDFaxEmailSendInfoVO() , account );
	        log.debug("\n ####### sendReportDesignerWithFiles sendEmailInvoice returnKey [" + returnKey + "]");
	        if ( !returnKey.equals("") && !returnKey.equals("null") && returnKey != null ) {
	            eventResponse.setUserMessage("Transmitted to E-mail server successfully");
	            eventResponse.setCustomData("key", returnKey);
	        } else {
	            eventResponse.setUserMessage("FAIL TO CREATE EML_SND_NO TABLE COM_EML_SND_INFO");
	           // eventResponse.setCustomData("key", returnKey);
	            eventResponse.setCustomData("key", "");
	        }
	        commit();        
	
	        tRcvr = event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlRcvrAdd();
	        StringTokenizer stRcvr = new StringTokenizer( tRcvr , ";" );
	        while( stRcvr.hasMoreTokens() ){
	            String tRcvvVal = stRcvr.nextToken();
	            log.debug("\n ####### sendReportDesignerWithFiles sendEmailInvoice tRcvvVal [" + tRcvvVal + "]");
	            event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd( tRcvvVal );
	            begin();
	            event.getDmtComFaxSndInfoVO().setBatFlg("E");
	            command.insertDmtFaxEmlSndHistory( returnKey , event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
	            commit();
	          }
            }
	        log.debug("\n ###################################################### END SC sendReportDesignerWithFiles");
        } catch(EventException ex) {
        	rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
    }

    /*************************************zzang end *****************************************************/	
    
	/**
	 * EES_DMT_4002 : Retrieve<br>
	 * Retrieving sheet Option content by office.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSheetOptionByOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			SheetOptionByOfficeVO sheetOptionByOfficeVO = new SheetOptionByOfficeVO();
			
			sheetOptionByOfficeVO = command.searchSheetOptionByOffice(event.getSheetOptionByOfficeVO());
			eventResponse.setETCData("DC_AMT_FLG",			sheetOptionByOfficeVO.getDcAmtFlg());
			eventResponse.setETCData("OFC_CD",				sheetOptionByOfficeVO.getOfcCd());
			eventResponse.setETCData("BIL_TO_LOC_DIV_CD",	sheetOptionByOfficeVO.getBilToLocDivCd());
			eventResponse.setETCData("CUST_REF_PRN_FLG",	sheetOptionByOfficeVO.getCustRefPrnFlg());
			eventResponse.setETCData("PHN_FAX_PRN_FLG",		sheetOptionByOfficeVO.getPhnFaxPrnFlg());
			eventResponse.setETCData("CUST_VAT_PRN_FLG",	sheetOptionByOfficeVO.getCustVatPrnFlg());
			eventResponse.setETCData("DFLT_TAX_RTO",		sheetOptionByOfficeVO.getDfltTaxRto());
			eventResponse.setETCData("TAX_AMT_PRN_FLG",		sheetOptionByOfficeVO.getTaxAmtPrnFlg());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
     * EES_DMT_4002 : Email Send<br>
     * DOM_FAX_EMAIL : Sending DMT MAIL and Creating Log<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse sendRDEmail2All(Event e) throws EventException {
        String remark01 = "";
        String remark02 = "";
        String address01 = "";
        String address02 = "";
        String address03 = "";
        String address04 = "";
        String telno = "";
        String faxno = "";
        String custval = "";
        String offadd01 = "";
        String offadd02 = "";
        String offadd03 = "";
        String header01 = "";
        String header02 = "";
        String header03 = "";
        String header04 = "";
        String header05 = "";
        String header06 = "";
        String header07 = "";
        String header08 = "";
        String header09 = "";
        String header10 = "";
        String leftright = "";
        String opptitle = "";
        String custref = "";
        String telfax = "";
        String custvat = "";
        
        String custname = "";
        String invoiceno = "";
        String tarifftp = "";
        String attnname = "";
        String cntrinvno = "";
        String creofccd = "";
        
        String attnMail = "";
        String rdFileNm = "";
        String sendFileName = "";
        
        DmtComFaxEmailEvent event = (DmtComFaxEmailEvent) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
	        log.debug("\n ###################################################### START SC sendRDEmail2All");
	        String paycMail = (String)e.getAttribute("paycMail");
	        StringTokenizer st01 = new StringTokenizer(paycMail, ",");
	
	        String paynMail = (String)e.getAttribute("paynMail");
	        StringTokenizer st11 = new StringTokenizer(paynMail, "|");
	
	        OtsInquiryByDetialVO otsInquiryByDetialVO01 = null;
	        
	        InvoiceIssueCollectionMgtBC command01 = new InvoiceIssueCollectionMgtBCImpl();
	        
	        cntrinvno = event.getOtsInquiryParmVO().getCntrinvno();
	        sendFileName = event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlAtchFile();
	        
	        log.debug(
	                  "\n ####### paycMail  [" + paycMail  + "]" +
	                  "\n ####### paynMail  [" + paynMail  + "]" +
	                  "\n ####### FileName  [" + sendFileName  + "]" +
	                  "\n ####### cntrinvno [" + cntrinvno + "] \n"
	                 );        
	        
	        log.debug("\n ###################################################### while (st01.hasMoreTokens()) { S T A R T ");
	        while (st01.hasMoreTokens()) {
	            
	            custname = st11.nextToken();
	            String tPayerCd = st01.nextToken();
	            event.getOtsInquiryParmVO().setPayc(tPayerCd);
	            
	            String rtnRemark = command01.searchOTSInquiryByDetailListRemark( event.getOtsInquiryParmVO() );
	            
	            if ( !StringUtils.isEmpty( StringUtils.trimToEmpty( rtnRemark ) ) ) {
	                
	                String[] arrRmk01 = StringUtils.split(rtnRemark, "|");
	                
	                log.debug("\n ####### rtnRemark [" + rtnRemark + "]"
	                        + "\n ####### arrRmk01[0] [" + StringUtils.trimToEmpty( arrRmk01[0] ) + "]"
	                        + "\n ####### arrRmk01[1] [" + StringUtils.trimToEmpty( arrRmk01[1] ) + "]"
	                        + "\n ####### arrRmk01[2] [" + StringUtils.trimToEmpty( arrRmk01[2] ) + "]"
	                        + "\n ####### arrRmk01[3] [" + StringUtils.trimToEmpty( arrRmk01[3] ) + "]"
	                        + "\n ####### arrRmk01[4] [" + StringUtils.trimToEmpty( arrRmk01[4] ) + "]"
	                        + "\n ####### arrRmk01[5] [" + StringUtils.trimToEmpty( arrRmk01[5] ) + "]"
	                        + "\n ####### arrRmk01[6] [" + StringUtils.trimToEmpty( arrRmk01[6] ) + "] \n");
	                
	                String tRmk = StringUtils.trimToEmpty( arrRmk01[0] );
	                
	                if ( !StringUtils.isEmpty( tRmk ) ) {
	                    String[] arrRmk02 = StringUtils.split(tRmk, "\n");
	                    if ( !StringUtils.isEmpty( StringUtils.trimToEmpty( arrRmk02[0] ) ) ) { remark01 = arrRmk02[0]; } else { remark01 = ""; }
	                    if ( !StringUtils.isEmpty( StringUtils.trimToEmpty( arrRmk02[1] ) ) ) { remark02 = arrRmk02[1]; } else { remark02 = ""; }
	                }
	                attnname = StringUtils.trimToEmpty( arrRmk01[1] );
	                    
	                String tAddress = StringUtils.trimToEmpty( arrRmk01[2] );
	                
	                if ( !tAddress.equals("") ) {
	                    String[] arrRmk03 = StringUtils.split(tAddress, "\n");
	                    int arr03cnt = arrRmk03.length;
	                            
	                    if ( arr03cnt >= 1 ) {
	                        address01 = arrRmk03[0].replaceAll( "'" , " " );
	                    } else {
	                        address01 = "";
	                    }
	                            
	                    if ( arr03cnt >= 2 ) {
	                        address02 = arrRmk03[1].replaceAll( "'" , " " );
	                    } else {
	                        address02 = "";
	                    }
	                            
	                    if ( arr03cnt >= 3 ) {
	                        address03 = arrRmk03[2].replaceAll( "'" , " " );
	                    } else {
	                        address03 = "";
	                    }
	                            
	                    if ( arr03cnt >= 4 ) {
	                        address04 = arrRmk03[3].replaceAll( "'" , " " );
	                    } else {
	                        address04 = "";
	                    }
	                }
	                    
	                telno    = StringUtils.trimToEmpty( arrRmk01[3] );
	                faxno    = StringUtils.trimToEmpty( arrRmk01[4] );
	                attnMail = StringUtils.trimToEmpty( arrRmk01[5] );
	                custval  = StringUtils.trimToEmpty( arrRmk01[6] );
	            
	            } else { // if ( !StringUtils.isEmpty( StringUtils.trimToEmpty( rtnRemark ) ) ) {
	                
	                remark01 = "";
	                remark02 = "";
	                attnname = "";
	                address01 = "";
	                address02 = "";
	                address03 = "";
	                address04 = "";
	                telno = "";
	                faxno = "";
	                attnMail = "";
	                custval = "";
	                log.debug("\n searchOTSInquiryByDetailListRemark no result tPayerCd [" + tPayerCd + "] "
	                        + "\n ####### rtnRemark []"
	                        + "\n ####### arrRmk01[0] []"
	                        + "\n ####### arrRmk01[1] []"
	                        + "\n ####### arrRmk01[2] []"
	                        + "\n ####### arrRmk01[3] []"
	                        + "\n ####### arrRmk01[4] []"
	                        + "\n ####### arrRmk01[5] []"
	                        + "\n ####### arrRmk01[6] [] \n");
	
	            } // if ( !StringUtils.isEmpty( StringUtils.trimToEmpty( rtnRemark ) ) ) {
	            
	            //searchFAXEmailByPayer
	            FAXEmailByPayerVO fAXEmailByPayerVO = new FAXEmailByPayerVO();
	            event.getFAXEmailByPayerVO().setPayerCd(tPayerCd);
	            event.getFAXEmailByPayerVO().setOfcCd(account.getOfc_cd());
	            event.getFAXEmailByPayerVO().setDmdtTrfCd("");
	            fAXEmailByPayerVO = command01.searchFAXEmailByPayer(event.getFAXEmailByPayerVO());
	            attnMail = fAXEmailByPayerVO.getEmailNos();
	            faxno = fAXEmailByPayerVO.getFaxNos();
	                        
	            log.debug("\n *****####### attnMail [" + attnMail + "] tPayerCd [" + tPayerCd + "]");
	            if ( !attnMail.equals("") ) {
	            
	                List<OtsInquiryByDetialVO> list01 = command01.searchOTSInquiryByDetailList ( event.getOtsInquiryParmVO() );
	                
	                OtsInquiryByDetialVO otsInquiryByDetialVOTariff = list01.get(0);
	                event.getOtsInquiryParmVO().setTftp2( otsInquiryByDetialVOTariff.getTarftp() );	//2010.02.26. 첫번째 tariff (set set 조회)
	                
	                String rtnRemark02 = command01.searchOTSInquiryByDetailListRemark2( event.getOtsInquiryParmVO() );
	                if ( !StringUtils.isEmpty( rtnRemark02) ) {
	                    String[] arrRmk04 = StringUtils.split(rtnRemark02, "|");
	                        offadd01  = StringUtils.trimToEmpty( arrRmk04[ 0] ).replaceAll( "'" , " " );
	                        offadd02  = StringUtils.trimToEmpty( arrRmk04[ 1] ).replaceAll( "'" , " " );
	                        offadd03  = StringUtils.trimToEmpty( arrRmk04[ 2] ).replaceAll( "'" , " " );
	                        header01  = StringUtils.trimToEmpty( arrRmk04[ 3] ).replaceAll( "'" , " " );
	                        header02  = StringUtils.trimToEmpty( arrRmk04[ 4] ).replaceAll( "'" , " " );
	                        header03  = StringUtils.trimToEmpty( arrRmk04[ 5] ).replaceAll( "'" , " " );
	                        header04  = StringUtils.trimToEmpty( arrRmk04[ 6] ).replaceAll( "'" , " " );
	                        header05  = StringUtils.trimToEmpty( arrRmk04[ 7] ).replaceAll( "'" , " " );
	                        header06  = StringUtils.trimToEmpty( arrRmk04[ 8] ).replaceAll( "'" , " " );
	                        header07  = StringUtils.trimToEmpty( arrRmk04[ 9] ).replaceAll( "'" , " " );
	                        header08  = StringUtils.trimToEmpty( arrRmk04[10] ).replaceAll( "'" , " " );
	                        header09  = StringUtils.trimToEmpty( arrRmk04[11] ).replaceAll( "'" , " " );
	                        header10  = StringUtils.trimToEmpty( arrRmk04[12] ).replaceAll( "'" , " " );
	                        leftright = StringUtils.trimToEmpty( arrRmk04[13] );
	                        opptitle  = StringUtils.trimToEmpty( arrRmk04[14] );
	                        custref   = StringUtils.trimToEmpty( arrRmk04[15] );
	                        telfax    = StringUtils.trimToEmpty( arrRmk04[16] );
	                        custvat   = StringUtils.trimToEmpty( arrRmk04[17] );
	                }
	
	                if ( cntrinvno.equals("0") && leftright.equals("L") ) {
	                    rdFileNm = "EES_DMT_4903.mrd";
	                } else if ( cntrinvno.equals("0") && leftright.equals("R") ) {
	                    rdFileNm = "EES_DMT_4904.mrd";
	                } else if ( cntrinvno.equals("1") && leftright.equals("L") ) {
	                    rdFileNm = "EES_DMT_4905.mrd";
	                } else if ( cntrinvno.equals("1") && leftright.equals("R") ) {
	                    rdFileNm = "EES_DMT_4906.mrd";
	                }
	                invoiceno = "";
	                tarifftp = "";
	                creofccd = "";
	                //[2015.05.28]소스품질 Modify
	                StringBuffer sb = new StringBuffer();
	                StringBuffer sb1 = new StringBuffer();
	                StringBuffer sb2 = new StringBuffer();
	                for ( int aii = 0 ; aii < list01.size() ; aii++ ) {
	                    otsInquiryByDetialVO01 = list01.get(aii);
	                    sb.append(otsInquiryByDetialVO01.getInvnoo()).append("," );
	                    sb1.append(otsInquiryByDetialVO01.getTarftp()).append("," );
	                    sb2.append(otsInquiryByDetialVO01.getIsseof()).append("," );
	                    //invoiceno = otsInquiryByDetialVO01.getInvnoo() + "," + invoiceno;
	                    //tarifftp = otsInquiryByDetialVO01.getTarftp() + "," + tarifftp;		//2010.02.26. multi tariff 조회
	                    //creofccd = otsInquiryByDetialVO01.getIsseof() + "," + creofccd;
	                }
	                invoiceno = sb.toString();
	                tarifftp = sb1.toString();
	                creofccd = sb2.toString();
	                
	                String rdParam = "/rp [" + event.getOtsInquiryParmVO().getArif()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getFrdt()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getTodt()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getIsof()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getPayc()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getPayc()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getPayc()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getPayc()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getPayc()  +"] " +
	                                     "[" + tarifftp +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getScno()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getScno()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getRfan()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getRfan()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCuno()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCuno()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCuno()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCuno()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCuno()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCutp()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCutp()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCutp()  +"] " + 
	                                     
	                                     "[*** " + opptitle            + " ***] " +
	                                     "["     + offadd01            + "] " +
	                                     "["     + offadd02            + "] " +
	                                     "["     + offadd03            + "] " +
	                                     "["     + custname            + "] " +
	                                     "["     + address01           + "] " +
	                                     "["     + address02           + "] " +
	                                     "["     + address03           + "] " +
	                                     "["     + address04           + "] " +
	                                     "["     + account.getUsr_nm() + "] " +
	                                     "["     + attnname            + "] " +
	                                     "["     + tPayerCd            + "] " +
	                                     "["     + telno               + "] " +
	                                     "["     + faxno               + "] " +
	                                     "["     + custval             + "] " +
	                                     "["     + remark01            + "] " +
	                                     "["     + remark02            + "] " +
	                                     "["     + header01            + "] " +
	                                     "["     + header02            + "] " +
	                                     "["     + header03            + "] " +
	                                     "["     + header04            + "] " +
	                                     "["     + header05            + "] " +
	                                     "["     + header06            + "] " +
	                                     "["     + header07            + "] " +
	                                     "["     + header08            + "] " +
	                                     "["     + header09            + "] " +
	                                     "["     + header10            + "] " +
	                                     "["     + custref             + "] " +
	                                     "["     + telfax              + "] " +
	                                     "["     + custvat             + "] " + 
	                                     "["     + invoiceno           + "] " +
	                                     "["     + creofccd            + "] " 
	                                     ;
	                
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlSysCd     ("DMT");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFileName  (rdFileNm);
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlBatFlg    ("N");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlTitle     ("Statement of Accounts(Custmer Code: "+tPayerCd+")");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlDocTp     ("O");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlRdParam   (rdParam);
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFaxNo     (faxno);								//event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlFaxNo     ()
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFaxSndrId ("Company");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlSndrNm ("Company");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd(attnMail);	
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlTemplt ("EES_DMT_4011_01.html");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlAtchFile(sendFileName+"_"+tPayerCd);
	                
	                log.debug("\n ##### FaxNo [ "+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlFaxNo() + "]");
	                log.debug("\n ##### EmlRcvrAdd [ "+attnMail + "]");
	                
	                log.debug(
	                          "\n ####### RdFxemlSysCd     ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlSysCd     ()+"]" +
	                          "\n ####### RdFxemlFileName  ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlFileName  ()+"]" +
	                          "\n ####### RdFxemlBatFlg    ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlBatFlg    ()+"]" +
	                          "\n ####### RdFxemlTitle     ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlTitle     ()+"]" +
	                          "\n ####### RdFxemlDocTp     ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlDocTp     ()+"]" +
	                          "\n ####### RdFxemlFaxNo     ["+faxno+"]" +
	                          "\n ####### RdFxemlFaxSndrId ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlFaxSndrId ()+"]" +
	                          "\n ####### RdFxemlEmlSndrNm ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlSndrNm ()+"]" +
	                          "\n ####### RdFxemlEmlRcvrAdd["+attnMail+"]" +
	                          "\n ####### RdFxemlEmlTemplt ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlTemplt ()+"]" +
	                          "\n ####### RdFxemlEmlAtchFile ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlAtchFile ()+"]" +
	                          "\n ####### RdFxemlRdParam   ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlRdParam   ()+"] \n"
	                         );                
	                
	                CommonFaxEmailBC command02 = new CommonFaxEmailBCImpl();
	                
	                String tRcvr = attnMail;
	                begin();
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd( tRcvr );
	                String returnKey = command02.sendEmailInvoice( event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
	                log.debug("\n ####### sendEmailInvoice returnKey [" + returnKey + "]");
	                if ( !returnKey.equals("") && !returnKey.equals("null") && returnKey != null ) {
	                    eventResponse.setUserMessage("Transmitted to E-mail server successfully");
	                    eventResponse.setCustomData("key", returnKey);
	                } else {
	                    eventResponse.setUserMessage("FAIL TO CREATE EML_SND_NO TABLE COM_EML_SND_INFO");
	                    //eventResponse.setCustomData("key", returnKey);
	                    eventResponse.setCustomData("key", "");
	                }
	                commit();        
	                
	                tRcvr = attnMail;
	                log.debug("\n ####### sendRDEmail2All tRcvr [" + tRcvr + "]");
	                StringTokenizer stRcvr = new StringTokenizer( tRcvr , ";" );
	                event.getDmtComRDFaxEmailSendInfoVO().setInvno(invoiceno);
	                event.getDmtComRDFaxEmailSendInfoVO().setPayc(tPayerCd);
	                while( stRcvr.hasMoreTokens() ){
	                    String tRcvvVal = stRcvr.nextToken();
	                    log.debug("\n ####### sendRDEmail2All tRcvvVal [" + tRcvvVal + "]");
	                    event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd( tRcvvVal );
	                    begin();
	                    event.getDmtComFaxSndInfoVO().setBatFlg("E");
	                    command02.insertDmtFaxEmlSndHistory( returnKey , event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
	                    commit();
	                }
	            
	            } else { // end of if ( !attnMail.equals("") ) {
	                eventResponse.setUserMessage("E-mail address missing! Pls input E-mail address in Payer Info ["+tPayerCd+"]");
	            } // end of if ( !attnMail.equals("") ) {
	            log.debug("\n ###################################################### while (st01.hasMoreTokens()) tPayerCd [" + tPayerCd + "] { D E E N D ");
	        } // while (st01.hasMoreTokens()) {
	
	        log.debug("\n ###################################################### END SC sendRDEmail2All");
        
        } catch(EventException ex) {
        	rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
    }
    
    
    
    /**
     * EES_DMT_4002 : Email Send<br>
     * DOM_FAX_EMAIL : Sending DMT MAIL and Creating Log<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */

    private EventResponse sendRDFax2All(Event e) throws EventException {
        
        String remark01 = "";
        String remark02 = "";
        String address01 = "";
        String address02 = "";
        String address03 = "";
        String address04 = "";
        String telno = "";
        String faxno = "";
        String custval = "";
        String offadd01 = "";
        String offadd02 = "";
        String offadd03 = "";
        String header01 = "";
        String header02 = "";
        String header03 = "";
        String header04 = "";
        String header05 = "";
        String header06 = "";
        String header07 = "";
        String header08 = "";
        String header09 = "";
        String header10 = "";
        String leftright = "";
        String opptitle = "";
        String custref = "";
        String telfax = "";
        String custvat = "";
        
        String custname = "";
        String invoiceno = "";
        String tarifftp = "";
        String attnname = "";
        String cntrinvno = "";
        String creofccd = "";
        
        String attnMail = "";
        String rdFileNm = "";
        
        DmtComFaxEmailEvent event = (DmtComFaxEmailEvent) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
	        log.debug("\n ###################################################### START SC sendRDFax2All");
	        String paycMail = (String)e.getAttribute("paycMail");
	        StringTokenizer st01 = new StringTokenizer(paycMail, ",");
	
	        String paynMail = (String)e.getAttribute("paynMail");
	        StringTokenizer st11 = new StringTokenizer(paynMail, "|");
	
	        OtsInquiryByDetialVO otsInquiryByDetialVO01 = null;
	        
	        InvoiceIssueCollectionMgtBC command01 = new InvoiceIssueCollectionMgtBCImpl();
	        
	        cntrinvno = event.getOtsInquiryParmVO().getCntrinvno();
	        
	        log.debug(
	                  "\n ####### paycMail  [" + paycMail  + "]" +
	                  "\n ####### paynMail  [" + paynMail  + "]" +
	                  "\n ####### cntrinvno [" + cntrinvno + "] \n"
	                 );        
	        
	        log.debug("\n ###################################################### while (st01.hasMoreTokens()) { S T A R T ");
	        while (st01.hasMoreTokens()) {
	            
	            custname = st11.nextToken();
	            String tPayerCd = st01.nextToken();
	            event.getOtsInquiryParmVO().setPayc(tPayerCd);
	            
	            String rtnRemark = command01.searchOTSInquiryByDetailListRemark( event.getOtsInquiryParmVO() );
	            
	            if ( !StringUtils.isEmpty( StringUtils.trimToEmpty( rtnRemark ) ) ) {
	                
	                String[] arrRmk01 = StringUtils.split(rtnRemark, "|");
	                
	                log.debug("\n ####### rtnRemark [" + rtnRemark + "]"
	                        + "\n ####### arrRmk01[0] [" + StringUtils.trimToEmpty( arrRmk01[0] ) + "]"
	                        + "\n ####### arrRmk01[1] [" + StringUtils.trimToEmpty( arrRmk01[1] ) + "]"
	                        + "\n ####### arrRmk01[2] [" + StringUtils.trimToEmpty( arrRmk01[2] ) + "]"
	                        + "\n ####### arrRmk01[3] [" + StringUtils.trimToEmpty( arrRmk01[3] ) + "]"
	                        + "\n ####### arrRmk01[4] [" + StringUtils.trimToEmpty( arrRmk01[4] ) + "]"
	                        + "\n ####### arrRmk01[5] [" + StringUtils.trimToEmpty( arrRmk01[5] ) + "]"
	                        + "\n ####### arrRmk01[6] [" + StringUtils.trimToEmpty( arrRmk01[6] ) + "] \n");
	                
	                String tRmk = StringUtils.trimToEmpty( arrRmk01[0] );
	                if ( !StringUtils.isEmpty( tRmk ) ) {
	                    String[] arrRmk02 = StringUtils.split(tRmk, "\n");
	                    if ( !StringUtils.isEmpty( StringUtils.trimToEmpty( arrRmk02[0] ) ) ) { remark01 = arrRmk02[0]; } else { remark01 = ""; }
	                    if ( !StringUtils.isEmpty( StringUtils.trimToEmpty( arrRmk02[1] ) ) ) { remark02 = arrRmk02[1]; } else { remark02 = ""; }
	                }
	                attnname = StringUtils.trimToEmpty( arrRmk01[1] );
	                    
	                String tAddress = StringUtils.trimToEmpty( arrRmk01[2] );
	                
	                if ( !tAddress.equals("") ) {
	                    String[] arrRmk03 = StringUtils.split(tAddress, "\n");
	                    int arr03cnt = arrRmk03.length;
	                            
	                    if ( arr03cnt >= 1 ) {
	                        address01 = arrRmk03[0].replaceAll( "'" , " " );
	                    } else {
	                        address01 = "";
	                    }
	                            
	                    if ( arr03cnt >= 2 ) {
	                        address02 = arrRmk03[1].replaceAll( "'" , " " );
	                    } else {
	                        address02 = "";
	                    }
	                            
	                    if ( arr03cnt >= 3 ) {
	                        address03 = arrRmk03[2].replaceAll( "'" , " " );
	                    } else {
	                        address03 = "";
	                    }
	                            
	                    if ( arr03cnt >= 4 ) {
	                        address04 = arrRmk03[3].replaceAll( "'" , " " );
	                    } else {
	                        address04 = "";
	                    }
	                }
	                    
	                telno    = StringUtils.trimToEmpty( arrRmk01[3] );
	                faxno    = StringUtils.trimToEmpty( arrRmk01[4] );
	                attnMail = StringUtils.trimToEmpty( arrRmk01[5] );
	                custval  = StringUtils.trimToEmpty( arrRmk01[6] );
	            
	            } else { // if ( !StringUtils.isEmpty( StringUtils.trimToEmpty( rtnRemark ) ) ) {
	                
	                remark01 = "";
	                remark02 = "";
	                attnname = "";
	                address01 = "";
	                address02 = "";
	                address03 = "";
	                address04 = "";
	                telno = "";
	                faxno = "";
	                attnMail = "";
	                custval = "";
	                log.debug("\n searchOTSInquiryByDetailListRemark no result tPayerCd [" + tPayerCd + "] "
	                        + "\n ####### rtnRemark []"
	                        + "\n ####### arrRmk01[0] []"
	                        + "\n ####### arrRmk01[1] []"
	                        + "\n ####### arrRmk01[2] []"
	                        + "\n ####### arrRmk01[3] []"
	                        + "\n ####### arrRmk01[4] []"
	                        + "\n ####### arrRmk01[5] []"
	                        + "\n ####### arrRmk01[6] [] \n");
	
	            } // if ( !StringUtils.isEmpty( StringUtils.trimToEmpty( rtnRemark ) ) ) {
	            
	            FAXEmailByPayerVO fAXEmailByPayerVO = new FAXEmailByPayerVO();
	            event.getFAXEmailByPayerVO().setPayerCd(tPayerCd);
	            event.getFAXEmailByPayerVO().setOfcCd(account.getOfc_cd());
	            event.getFAXEmailByPayerVO().setDmdtTrfCd("");
	            log.debug("\n *****####### setPayerCd [" + event.getFAXEmailByPayerVO().getPayerCd() + "] setOfcCd [" + event.getFAXEmailByPayerVO().getOfcCd() + "] setDmdtTrfCd [" + event.getFAXEmailByPayerVO().getDmdtTrfCd() + "]");
	            fAXEmailByPayerVO = command01.searchFAXEmailByPayer(event.getFAXEmailByPayerVO());
	            attnMail = fAXEmailByPayerVO.getEmailNos();	//실제 전송할 메일 주소
	            faxno = fAXEmailByPayerVO.getFaxNos();		//실제 전송할 fax no
	            
	            
	            log.debug("\n *****####### faxno [" + faxno + "] tPayerCd [" + tPayerCd + "] attnMail [" + attnMail + "]");
	            if ( !faxno.equals("") ) {
	            
	                List<OtsInquiryByDetialVO> list01 = command01.searchOTSInquiryByDetailList ( event.getOtsInquiryParmVO() );
	                
	                OtsInquiryByDetialVO otsInquiryByDetialVOTariff = list01.get(0);
	                event.getOtsInquiryParmVO().setTftp2( otsInquiryByDetialVOTariff.getTarftp() );	//2010.02.26. 첫번째 tariff (set set 조회)
	                
	                String rtnRemark02 = command01.searchOTSInquiryByDetailListRemark2( event.getOtsInquiryParmVO() );
	                if ( !StringUtils.isEmpty( rtnRemark02) ) {
	                    String[] arrRmk04 = StringUtils.split(rtnRemark02, "|");
	                        offadd01  = StringUtils.trimToEmpty( arrRmk04[ 0] ).replaceAll( "'" , " " );
	                        offadd02  = StringUtils.trimToEmpty( arrRmk04[ 1] ).replaceAll( "'" , " " );
	                        offadd03  = StringUtils.trimToEmpty( arrRmk04[ 2] ).replaceAll( "'" , " " );
	                        header01  = StringUtils.trimToEmpty( arrRmk04[ 3] ).replaceAll( "'" , " " );
	                        header02  = StringUtils.trimToEmpty( arrRmk04[ 4] ).replaceAll( "'" , " " );
	                        header03  = StringUtils.trimToEmpty( arrRmk04[ 5] ).replaceAll( "'" , " " );
	                        header04  = StringUtils.trimToEmpty( arrRmk04[ 6] ).replaceAll( "'" , " " );
	                        header05  = StringUtils.trimToEmpty( arrRmk04[ 7] ).replaceAll( "'" , " " );
	                        header06  = StringUtils.trimToEmpty( arrRmk04[ 8] ).replaceAll( "'" , " " );
	                        header07  = StringUtils.trimToEmpty( arrRmk04[ 9] ).replaceAll( "'" , " " );
	                        header08  = StringUtils.trimToEmpty( arrRmk04[10] ).replaceAll( "'" , " " );
	                        header09  = StringUtils.trimToEmpty( arrRmk04[11] ).replaceAll( "'" , " " );
	                        header10  = StringUtils.trimToEmpty( arrRmk04[12] ).replaceAll( "'" , " " );
	                        leftright = StringUtils.trimToEmpty( arrRmk04[13] );
	                        opptitle  = StringUtils.trimToEmpty( arrRmk04[14] );
	                        custref   = StringUtils.trimToEmpty( arrRmk04[15] );
	                        telfax    = StringUtils.trimToEmpty( arrRmk04[16] );
	                        custvat   = StringUtils.trimToEmpty( arrRmk04[17] );
	                }
	
	                if ( cntrinvno.equals("0") && leftright.equals("L") ) {
	                    rdFileNm = "EES_DMT_4903.mrd";
	                } else if ( cntrinvno.equals("0") && leftright.equals("R") ) {
	                    rdFileNm = "EES_DMT_4904.mrd";
	                } else if ( cntrinvno.equals("1") && leftright.equals("L") ) {
	                    rdFileNm = "EES_DMT_4905.mrd";
	                } else if ( cntrinvno.equals("1") && leftright.equals("R") ) {
	                    rdFileNm = "EES_DMT_4906.mrd";
	                }
	                
	                invoiceno = "";
	                tarifftp = "";
	                creofccd = "";
	                //[2015.05.28]소스품질 Modify
	                StringBuffer sb = new StringBuffer();
	                StringBuffer sb1 = new StringBuffer();
	                StringBuffer sb2 = new StringBuffer();
	                for ( int aii = 0 ; aii < list01.size() ; aii++ ) {
	                    otsInquiryByDetialVO01 = list01.get(aii);
	                    sb.append(otsInquiryByDetialVO01.getInvnoo()).append(",");
	                    sb1.append(otsInquiryByDetialVO01.getTarftp()).append(",");
	                    sb2.append(otsInquiryByDetialVO01.getIsseof()).append(",");
	                    //invoiceno = otsInquiryByDetialVO01.getInvnoo() + "," + invoiceno;
	                    //tarifftp = otsInquiryByDetialVO01.getTarftp() + "," + tarifftp;		//2010.02.26. multi tariff 조회
	                    //creofccd = otsInquiryByDetialVO01.getIsseof() + "," + creofccd;
	                }
	                invoiceno = sb.toString();
	                tarifftp = sb1.toString();
	                creofccd = sb2.toString();
	
	                String rdParam = "/rp [" + event.getOtsInquiryParmVO().getArif()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getFrdt()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getTodt()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getIsof()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getPayc()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getPayc()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getPayc()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getPayc()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getPayc()  +"] " +
	                                     "[" + tarifftp +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getScno()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getScno()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getRfan()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getRfan()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCuno()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCuno()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCuno()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCuno()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCuno()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCutp()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCutp()  +"] " +
	                                     "[" + event.getOtsInquiryParmVO().getCutp()  +"] " + 
	                                     
	                                     "[*** " + opptitle            + " ***] " +
	                                     "["     + offadd01            + "] " +
	                                     "["     + offadd02            + "] " +
	                                     "["     + offadd03            + "] " +
	                                     "["     + custname            + "] " +
	                                     "["     + address01           + "] " +
	                                     "["     + address02           + "] " +
	                                     "["     + address03           + "] " +
	                                     "["     + address04           + "] " +
	                                     "["     + account.getUsr_nm() + "] " +
	                                     "["     + attnname            + "] " +
	                                     "["     + tPayerCd            + "] " +
	                                     "["     + telno               + "] " +
	                                     "["     + faxno               + "] " +
	                                     "["     + custval             + "] " +
	                                     "["     + remark01            + "] " +
	                                     "["     + remark02            + "] " +
	                                     "["     + header01            + "] " +
	                                     "["     + header02            + "] " +
	                                     "["     + header03            + "] " +
	                                     "["     + header04            + "] " +
	                                     "["     + header05            + "] " +
	                                     "["     + header06            + "] " +
	                                     "["     + header07            + "] " +
	                                     "["     + header08            + "] " +
	                                     "["     + header09            + "] " +
	                                     "["     + header10            + "] " +
	                                     "["     + custref             + "] " +
	                                     "["     + telfax              + "] " +
	                                     "["     + custvat             + "] " + 
	                                     "["     + invoiceno           + "] " +
	                                     "["     + creofccd            + "] "
	                                     ;
	                
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlSysCd     ("DMT");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFileName  (rdFileNm);
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlBatFlg    ("N");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlTitle     ("Statement of Accounts(Custmer Code: "+tPayerCd+")"); //custname
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlDocTp     ("O");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlRdParam   (rdParam);
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFaxNo     (faxno);
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFaxSndrId ("Company");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlSndrNm ("Company"); 
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd(attnMail);
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlTemplt ("EES_DMT_4011_01.html");
	                
	                log.debug(
	                          "\n ####### RdFxemlSysCd     ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlSysCd     ()+"]" +
	                          "\n ####### RdFxemlFileName  ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlFileName  ()+"]" +
	                          "\n ####### RdFxemlBatFlg    ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlBatFlg    ()+"]" +
	                          "\n ####### RdFxemlTitle     ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlTitle     ()+"]" +
	                          "\n ####### RdFxemlDocTp     ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlDocTp     ()+"]" +
	                          "\n ####### RdFxemlFaxNo     ["+faxno+"]" +
	                          "\n ####### RdFxemlFaxSndrId ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlFaxSndrId ()+"]" +
	                          "\n ####### RdFxemlEmlSndrNm ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlSndrNm ()+"]" +
	                          "\n ####### RdFxemlEmlRcvrAdd["+attnMail+"]" +
	                          "\n ####### RdFxemlEmlTemplt ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlTemplt ()+"]" +
	                          "\n ####### RdFxemlRdParam   ["+event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlRdParam   ()+"] \n"
	                         );
	                
	                CommonFaxEmailBC command02 = new CommonFaxEmailBCImpl();
	                
	                begin();
	                
	                event.getDmtComRDFaxEmailSendInfoVO().setPayc(tPayerCd);
	                String returnKey = command02.sendFaxInvoice(event.getDmtComRDFaxEmailSendInfoVO(), event.getDmtComFaxSndInfoVO());
	                log.debug("####### sendFaxInvoice returnKey [" + returnKey + "]");
	                if ( !returnKey.equals("") && !returnKey.equals("null") && returnKey != null ) {
	                    eventResponse.setUserMessage("Transmitted to Fax server successfully");
	                    eventResponse.setCustomData("key", returnKey);
	                } else {
	                    eventResponse.setUserMessage("FAIL TO CREATE FAX_SND_NO TABLE COM_FAX_SND_INFO");
	                    //eventResponse.setCustomData("key", returnKey);
	                    eventResponse.setCustomData("key", "");
	                }
	        
	                commit();
	
	                String tRcvr = faxno;
	                log.debug("\n ####### sendRDFax2All tRcvr [" + tRcvr + "]");
	                StringTokenizer stRcvr = new StringTokenizer( tRcvr , ";" );
	                event.getDmtComRDFaxEmailSendInfoVO().setInvno(invoiceno);
	                event.getDmtComRDFaxEmailSendInfoVO().setPayc(tPayerCd);
	                while( stRcvr.hasMoreTokens() ){
	                    String tRcvvVal = stRcvr.nextToken();
	                    log.debug("\n ####### sendRDFax2All tRcvvVal [" + tRcvvVal + "]");
	                    event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFaxNo( tRcvvVal );
	                    begin();
	                    event.getDmtComFaxSndInfoVO().setBatFlg("F");
	                    command02.insertDmtFaxEmlSndHistory( returnKey , event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
	                    commit();
	                }                
	            
	            } else { // end of if ( !attnMail.equals("") ) {
	                eventResponse.setUserMessage("Fax No missing! Pls input Fax No in Payer Info ["+tPayerCd+"]");
	            } // end of if ( !attnMail.equals("") ) {
	            log.debug("\n ###################################################### while (st01.hasMoreTokens()) tPayerCd [" + tPayerCd + "] { D E E N D ");
	        } // while (st01.hasMoreTokens()) {
	
	        log.debug("\n ###################################################### END SC sendRDFax2All");
        
        } catch(EventException ex) {
        	rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		
        return eventResponse;
    }
    
    
    
    /**
     * EES_DMT_1001 : Basic Tariff Creation(1001,1005,1006,4014) <br>
     * Retrieving Basic Tariff Creation Condition (Tariff Type, Continent, Country, Region)<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTariffTypeContinentCountryRegionList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command 	= new CommonFinderBCImpl();
		DmtComEvent event 		= (DmtComEvent)e;

    	DMTCommonVO dmtCommonVO 			= new DMTCommonVO();
    	StringBuffer codes 					= new StringBuffer();
    	List<TariffNameVO> tariffNameVOs 	= null;
    	List<CoverageVO> coverageVOs 		= null;
		
		try{
			//1. Taritt Type List
			dmtCommonVO = command.searchTariffTypeList(account.getOfc_cd(), account.getUsr_id());
			tariffNameVOs = dmtCommonVO.getTariffNameVOs();
			
			codes = new StringBuffer();
			if (tariffNameVOs != null && tariffNameVOs.size() > 0) {
				for (int i = 0 ; i < tariffNameVOs.size() ; i++) {
					codes.append(tariffNameVOs.get(i).getDmdtTrfCd()).append("=").append(tariffNameVOs.get(i).getDmdtTrfNm());
					if (i < tariffNameVOs.size() - 1) codes.append("|");
				}
			}
			eventResponse.setETCData("common_tariff_cd", codes.toString());
		
			//2. Continent
			coverageVOs = command.searchContinetList();

			codes = new StringBuffer();
			if (coverageVOs != null && coverageVOs.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < coverageVOs.size() ; i++) {
					codes.append(coverageVOs.get(i).getContiCd()).append("=").append(coverageVOs.get(i).getContiNm());
					if (i < coverageVOs.size() - 1) codes.append("|");
				}
			}
			eventResponse.setETCData(CoverageVO.CVRG_CONTINENT, codes.toString());	
			
			//3. Country
			coverageVOs = command.searchCountryList(event.getCoverageVO());
			codes = new StringBuffer();
			if (coverageVOs != null && coverageVOs.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < coverageVOs.size(); i++) {
					codes.append(coverageVOs.get(i).getCntCd()).append("=").append(coverageVOs.get(i).getCntNm());
					if (i < coverageVOs.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, codes.toString());
			
			//4. Region
			coverageVOs = command.searchRegionList(event.getCoverageVO());
			codes = new StringBuffer();
			if (coverageVOs != null && coverageVOs.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < coverageVOs.size(); i++) {
					codes.append(coverageVOs.get(i).getRgnCd()).append("=").append(coverageVOs.get(i).getRgnNm());
					if (i < coverageVOs.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData(CoverageVO.CVRG_REGION, codes.toString());
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }

		return eventResponse;
    }    
    
    /**
     * EES_DMT_1001 : Basic Tariff Creation(1004,4015) <br>
     * Retrieving Basic Tariff Detail(s) Inquiry Condition (Tariff Type, Continent, Country, Region, Container & Cargo)<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTariffTypeContinentCountryRegionContainerCargoList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command 	= new CommonFinderBCImpl();
		DmtComEvent event 		= (DmtComEvent)e;

    	StringBuffer codes 					= new StringBuffer();
    	List<TariffNameVO> tariffNameVOs 	= null;
    	List<CoverageVO> coverageVOs 		= null;
		List<ContainerCargoVO> containerCargoVOs = null;
		
		try{
			//1. Taritt Type List
			tariffNameVOs = command.searchTariffTypeList();
			
			codes = new StringBuffer();
			if (tariffNameVOs != null && tariffNameVOs.size() > 0) {
				//insert blank in the select box
				codes.append("All").append("=").append("All").append("|");
				for (int i = 0 ; i < tariffNameVOs.size() ; i++) {
					codes.append(tariffNameVOs.get(i).getDmdtTrfCd()).append("=").append(tariffNameVOs.get(i).getDmdtTrfNm());
					if (i < tariffNameVOs.size() - 1) codes.append("|");
				}
			}
			eventResponse.setETCData("all_tariff_cd", codes.toString());
		
			//2. Continent
			coverageVOs = command.searchContinetList();

			codes = new StringBuffer();
			if (coverageVOs != null && coverageVOs.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < coverageVOs.size() ; i++) {
					codes.append(coverageVOs.get(i).getContiCd()).append("=").append(coverageVOs.get(i).getContiNm());
					if (i < coverageVOs.size() - 1) codes.append("|");
				}
			}
			eventResponse.setETCData(CoverageVO.CVRG_CONTINENT, codes.toString());	
			
			//3. Country
			coverageVOs = command.searchCountryList(event.getCoverageVO());
			codes = new StringBuffer();
			if (coverageVOs != null && coverageVOs.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < coverageVOs.size(); i++) {
					codes.append(coverageVOs.get(i).getCntCd()).append("=").append(coverageVOs.get(i).getCntNm());
					if (i < coverageVOs.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, codes.toString());
			
			//4. Region
			coverageVOs = command.searchRegionList(event.getCoverageVO());
			codes = new StringBuffer();
			if (coverageVOs != null && coverageVOs.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < coverageVOs.size(); i++) {
					codes.append(coverageVOs.get(i).getRgnCd()).append("=").append(coverageVOs.get(i).getRgnNm());
					if (i < coverageVOs.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData(CoverageVO.CVRG_REGION, codes.toString());
			
			//5. Container & Cargo
			ContainerCargoVO cargoVO = new ContainerCargoVO();
			cargoVO.setCode1("CD02053");
			cargoVO.setCode2("CD01963");
			
			containerCargoVOs = command.searchContainterCargoList(cargoVO);
			codes = new StringBuffer();
			
			if (containerCargoVOs != null && containerCargoVOs.size() > 0) {
				codes.append("All").append("=").append("All").append("^").append("All").append("|");
				for (int i = 0 ; i < containerCargoVOs.size() ; i++) {
					codes.append(containerCargoVOs.get(i).getCntrCgo()).append("=").append(containerCargoVOs.get(i).getDmdtCgoTpNm()).append("^").append(containerCargoVOs.get(i).getDmdtCntrTpNm());
					if (i < containerCargoVOs.size() - 1) codes.append("|");
				}
			}
			eventResponse.setETCData("CONTR_CGO", codes.toString());
			
			
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }

		return eventResponse;
    }    
    
    /**
     * EES_DMT_1003 : Basic Tariff Summary Inquiry(1003) <br>
     * Retrieving Basic Tariff Summary Inquiry Condition.(Tariff Type, Country, Continent)<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTariffTypeCountryContinentList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command 	= new CommonFinderBCImpl();
		DmtComEvent event 		= (DmtComEvent)e;

    	StringBuffer codes 					= new StringBuffer();
    	List<TariffNameVO> tariffNameVOs 	= null;
    	List<CoverageVO> coverageVOs 		= null;
		
		try{
			//1. Taritt Type List
			tariffNameVOs = command.searchTariffTypeList();
			
			codes = new StringBuffer();
			if (tariffNameVOs != null && tariffNameVOs.size() > 0) {
				//insert blank in the select box
				codes.append("All").append("=").append("All").append("|");
				for (int i = 0 ; i < tariffNameVOs.size() ; i++) {
					codes.append(tariffNameVOs.get(i).getDmdtTrfCd()).append("=").append(tariffNameVOs.get(i).getDmdtTrfNm());
					if (i < tariffNameVOs.size() - 1) codes.append("|");
				}
			}
			eventResponse.setETCData("all_tariff_cd", codes.toString());			
			
			//2. Continent
			coverageVOs = command.searchContinetList();
			codes = new StringBuffer();
			if (coverageVOs != null && coverageVOs.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < coverageVOs.size() ; i++) {
					codes.append(coverageVOs.get(i).getContiCd()).append("=").append(coverageVOs.get(i).getContiNm());
					if (i < coverageVOs.size() - 1) codes.append("|");
				}
			}
			eventResponse.setETCData(CoverageVO.CVRG_CONTINENT, codes.toString());	
			
			//3. Country
			coverageVOs = command.searchCountryList(event.getCoverageVO());
			codes = new StringBuffer();
			if (coverageVOs != null && coverageVOs.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < coverageVOs.size(); i++) {
					codes.append(coverageVOs.get(i).getCntCd()).append("=").append(coverageVOs.get(i).getCntNm());
					if (i < coverageVOs.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, codes.toString());
			
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }

		return eventResponse;
    }       
    
    /**
     * EES_DMT_1006 : Commodity Exception Tariff Inquiry <br>
     * Retrieving Commodity Exception Tariff Inquiry Condition.(All Tariff Type, Continent, Country, Region)<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchAllTariffTypeContinentCountryRegionList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command 	= new CommonFinderBCImpl();
		DmtComEvent event 		= (DmtComEvent)e;

    	StringBuffer codes 					= new StringBuffer();
    	List<TariffNameVO> tariffNameVOs 	= null;
    	List<CoverageVO> coverageVOs 		= null;
		
		try{
			//1. Taritt Type List
			tariffNameVOs = command.searchTariffTypeList();
			
			codes = new StringBuffer();
			if (tariffNameVOs != null && tariffNameVOs.size() > 0) {
				//insert blank in the select box
				codes.append("All").append("=").append("All").append("|");
				for (int i = 0 ; i < tariffNameVOs.size() ; i++) {
					codes.append(tariffNameVOs.get(i).getDmdtTrfCd()).append("=").append(tariffNameVOs.get(i).getDmdtTrfNm());
					if (i < tariffNameVOs.size() - 1) codes.append("|");
				}
			}
			eventResponse.setETCData("all_tariff_cd", codes.toString());	
		
			//2. Continent
			coverageVOs = command.searchContinetList();

			codes = new StringBuffer();
			if (coverageVOs != null && coverageVOs.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < coverageVOs.size() ; i++) {
					codes.append(coverageVOs.get(i).getContiCd()).append("=").append(coverageVOs.get(i).getContiNm());
					if (i < coverageVOs.size() - 1) codes.append("|");
				}
			}
			eventResponse.setETCData(CoverageVO.CVRG_CONTINENT, codes.toString());	
			
			//3. Country
			coverageVOs = command.searchCountryList(event.getCoverageVO());
			codes = new StringBuffer();
			if (coverageVOs != null && coverageVOs.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < coverageVOs.size(); i++) {
					codes.append(coverageVOs.get(i).getCntCd()).append("=").append(coverageVOs.get(i).getCntNm());
					if (i < coverageVOs.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData(CoverageVO.CVRG_COUNTRY, codes.toString());
			
			//4. Region
			coverageVOs = command.searchRegionList(event.getCoverageVO());
			codes = new StringBuffer();
			if (coverageVOs != null && coverageVOs.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < coverageVOs.size(); i++) {
					codes.append(coverageVOs.get(i).getRgnCd()).append("=").append(coverageVOs.get(i).getRgnNm());
					if (i < coverageVOs.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData(CoverageVO.CVRG_REGION, codes.toString());
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }

		return eventResponse;
    }        
    
	/**
	 *Retrieving Country Code by Office <br>
	 *
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUserCntCode() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			String rtnStr = command.searchUserCntCode(account.getOfc_cd());
			eventResponse.setETCData("USR_CNT_CD", rtnStr);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Retrieving difference between From Date and To Date <br>
	 *
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchDaysBetween(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command 	= new CommonFinderBCImpl();
		DmtComEvent 	event 	= (DmtComEvent)e;
		
		try {
			String ovrDys = command.searchDaysBetween(event.getDayVO());
			eventResponse.setETCData("OVR_DYS", ovrDys);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Retrieving RHQ OFC CD by OFC_CD.<br>
	 *
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchRhqOfcCdByOfcCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command 	= new CommonFinderBCImpl();
		DmtComEvent 	event 	= (DmtComEvent)e;
		
		try {
			String rhqOfcCd = command.searchRhqOfcCdByOfcCd(event.getRhqOfcCodeVO());
			eventResponse.setETCData("RHQ_OFC_CD", rhqOfcCd);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * DMT : common
	 * creating yard list in Combo by getting yard
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchYardSubCodeForCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DmtComEvent event = (DmtComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command 	= new CommonFinderBCImpl();
		try {
			String rtnStr = command.searchYardSubCodeForCombo(event.getCoverageVO());
			//String cntCd = command.searchUserCntCode(account.getOfc_cd());
			//String svrCd = command.checkSvrCode(event.getCoverageVO().getYdCd1(), cntCd);
			//eventResponse.setETCData("svrChk", svrCd);
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - searchYardSubCodeForCombo] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - searchYardSubCodeForCombo] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/** searchRepCustSeq
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRepCustSeq(Event e) throws EventException {
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String repCustSeq = command.searchRepCustSeq(event.getOfficeNameVO().getOfcCd());

			eventResponse.setETCData("REP_CUST_SEQ", repCustSeq);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
}