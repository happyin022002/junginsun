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
* 2010.11.11 김태균 [CHM-201007006-01] [EES-DMT] [DMDT] Invoice Currency 선택 기능 추가
* 2013.04.18 임창빈 [CHM-201324214] [DMT] 미주 MT Notification data display 요청
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.basic.CommonFaxEmailBC;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.basic.CommonFaxEmailBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.event.DmtComFaxEmailEvent;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComRDFaxEmailSendInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBC;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.event.DmtComEvent;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.ARCurrencyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.AttentionVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.BookingNoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CommonCodeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.ContainerCargoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CountryCdVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CurrencyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.DMTCommonVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.LocationCdVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.PayerNameParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.PayerNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.SheetOptionByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.TariffNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.UserInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.UserRoleVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.VendorNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetialVO;
import com.hanjin.framework.component.databasedata.FileDatabaseData;
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
 * NIS2010-DMTCommon Business Logic ServiceCommand - NIS2010-DMTCommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SungHoon, Lee
 * @see DMTCommonFinderDBDAO
 * @since J2EE 1.4
 */

public class DMTCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DMTCommon system 업무 시나리오 선행작업<br>
	 * DMTCommonFinder업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * DMTCommon system 업무 시나리오 마감작업<br>
	 * DMTCommonFinder 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DMTCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-DMTCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters) 
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
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
				eventResponse = searchUserInfo(e);
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
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND20)) {
                	eventResponse = checkYardCd(e);
            }
			// RHQ 산하 DMT OFC 조회
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND21)) {
            	eventResponse = searchSubOfficeListByRHQ(e);
            }
			// USER Login Office 산하 DMT OFC 조회
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND22)) {
            	eventResponse = searchSubOfficeListByUserLoginOffice(e);
            }				
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
            	eventResponse = searchYardInfo(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
            	eventResponse = searchUserOfcCd(e); // ofc 조회
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH23)) {
            	eventResponse = searchOfcLocalTime(e); 
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH24)) {
            	eventResponse = searchUserRoleCode(e); 
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH25)) {
            	eventResponse = searchUserOfcLvl(e); // user ofc level 조회
            }	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH26)) {
				eventResponse = searchFileExistence(e);
			}				
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH27)) {
				eventResponse = searchSysAreaGrpId(e);
			}				
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH28)) {
				eventResponse = checkDmtPayerInfo(e);
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
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) { // 4009 단체MAIL + DETAIL RD
                eventResponse = sendRDEmailDetailAll(e);
            }
        }
		return eventResponse;
	}

	/**
	 * EES_DMT_1007 : Retrieve<br>
	 * 모든 Region 정보를 조회 합니다. <br>
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
	 * 모든 Country 정보를 조회 합니다. <br>
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
	 * Region Head Quarter 에 포함된 모든 Country 정보를 조회 합니다. <br>
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
	 * Continent 에 포함된 모든 Country 정보를 조회 합니다. <br>
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
	 * Country 에 포함된 모든 Region 정보를 조회 합니다. <br>
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
	
			//Country 에 해당되는 Region 이나 State(CA,US 일 경우) 를 조회한다.
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
	 * Location 을 포함하는 상위 Region Header Quarter, Country, Region or State 를 모두 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQHierarchyByLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<CoverageVO> list = command.searchRHQHierarchyByLocation(event.getCoverageVO());
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData(CoverageVO.CVRG_RHQ, list.get(0).getSvrId() + "=" + "");	//코드값만 존재함.
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
	 * EES_DMT_2001 : Retrieve<br>
	 * Location 을 포함하는 상위 Continent, Country, Region or State 를 모두 조회 합니다. <br>
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
	 * EES_DMT_3001 : Open<br>
	 * Tariff Type List 정보와 User별 설정 Tariff Type 정보를 조회 합니다. <br>
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
	 * Tariff Type List 정보를 조회 합니다. <br>
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
	 * DemDet Office 정보를 조회 합니다. <br>
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
	 * RHQ Office Code 값을 이용해서 DemDet Office 정보를 조회 합니다. <br>
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
			String otsFlg = event.getRhqOfcCodeVO().getOtsFlg();
			
			if("".equals(rhqOfcCd))
				rhqOfcCd = account.getRhq_ofc_cd();
			
			List<OfficeNameVO> list = command.searchOfficeListByRhq(rhqOfcCd, otsFlg);
			
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
	 * DemDet Sub Office 정보를 조회 합니다. <br>
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
	 * 해당 Booking No.의 유효한지 조회 합니다. <br>
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
	 * Location 이 유효한지를 조회 합니다. <br>
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
     * Location 이 유효한지를 조회 합니다. <br>
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
	 * Country 이 유효한지를 조회 합니다. <br>
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
	 * Yard의 정보를 바탕으로 해당하는 대륙,국가,지역등의 정보를 조회한다. <br>
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
		/*
		
		// 아래 Logic은 실제 화면 적용시에 변경 처리 필요 : 적용 후 주석 삭제 
		StringBuffer codes = new StringBuffer();
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				codes.append(list.get(i).getContiCd()).append("=").append(list.get(i).getContiNm()).append(",")
				.append(list.get(i).getCntCd()).append("=").append(list.get(i).getCntNm()).append(",").append(list.get(i).getYdCd()).append("=").append(list.get(i).getYdNm());
				if (i < list.size() - 1) codes.append("|");
			}
		}
		eventResponse.setETCData("common_cd", codes.toString());
		return eventResponse;
		*/
	}
	
	/**
	 * EES_DMT_4002 : Open<br>
	 * Currency List 정보를 조회 합니다. <br>
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
			
			// 아래 Logic은 실제 화면 적용시에 변경 처리 필요 : 적용 후 주석 삭제 
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
	 * RHQ Office List 정보를 조회 합니다.<br>
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
			
			// 아래 Logic은 실제 화면 적용시에 변경 처리 필요 : 적용 후 주석 삭제  ==> 수정 및 적용(황효근)
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
	
	/**
	 * EES_DMT_1008 : Retrieve<br>
	 * Region의 정보를 바탕으로 해당하는 대륙,국가 정보를 조회 합니다. <br>
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
	 * 모든 Continent 정보를 조회 합니다.<br>
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
			
			// 아래 Logic은 실제 화면 적용시에 변경 처리 필요 : 적용 후 주석 삭제 
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
	 * DMTCommonFinder의 event에 대한 특정 리스트 조회 이벤트 처리<br>
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
			
			// 아래 Logic은 실제 화면 적용시에 변경 처리 필요 : 적용 후 주석 삭제 
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				//Code 값은 Key=Value 이며, Value 의 값을 구분하고자 할 경우에는 특수문자 '^' 를 사용해서 처리함.
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
	 * Country 정보로 Continent 정보를 조회 합니다. <br>
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
	 * Region의 정보를 바탕으로 해당하는 대륙,국가 정보를 조회 합니다. <br>
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
	 * State 정보를 바탕으로 해당하는 대륙,국가 정보를 조회 합니다. <br>
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
	 * Location 정보를 바탕으로 해당하는 Yard 정보를 조회 합니다. <br>
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
			
			// 아래 Logic은 실제 화면 적용시에 변경 처리 필요 : 적용 후 주석 삭제 
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
	 * Common Code ID 로 Code 목록정보를 조회 합니다. <br>
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
	 * Country 정보를 바탕으로 해당하는 상위 RHQ 정보를 조회 합니다. <br>
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
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * 모든 Region, State('CA','US') 정보를 조회 합니다.<br>
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
	 * Customer Name 정보를 조회 합니다.<br>
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
	 * Payer Name 정보를 조회 합니다.<br>
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
			eventResponse.setETCData("LGS_FLG", JSPUtil.getNull(payerNameVO.getLgsFlg()));
			eventResponse.setETCData("NMD_CUST_FLG", JSPUtil.getNull(payerNameVO.getNmdCustFlg()));
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}

    /**
     * EES_DMT_1005 : Retrieve<br>
     * Commondity Name 정보를 조회 합니다.<br>
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
	 * RHQ Office Code에 따른 DEM/DET Office 정보를 조회 합니다.<br>
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
	 * 해당 Office의 RHQ Office Name 정보를 조회 합니다. <br>
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
	 * Atttention 정보를 조회 합니다. <br>
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
	 * Service Provider Name 정보를 조회 합니다. <br>
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
	 * ARCurrency 리스트 정보를 조회 합니다. <br>
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
			
			// 아래 Logic은 실제 화면 적용시에 변경 처리 필요 : 적용 후 주석 삭제 
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
	 * OFC_CD별 현재일자를 조회 합니다. <br>
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
	 * EES_DMT_3001 : Open<br>
	 * User OFC_CD별 현재일자를 조회합니다. <br>
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
	 * Office Code에 대한 AR Office 정보를 조회 합니다.<br>
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
     * DOM_FAX_EMAIL : DMT FAX 전송 및 로그를 생성합니다<br>
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
	        //event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlSndrAdd("mjchang@hanjin.com");
	        //event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd("mjchang@hanjin.com");
	        //event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlCcrcvrAdd("mjchang@hanjin.com");        
	        String tRcvr = event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlFaxNo();
	        begin();
	
	        String returnKey = command.sendFaxInvoice( event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
	        log.debug("####### sendFaxInvoice returnKey [" + returnKey + "]");
	        if (returnKey != null && !"".equals(returnKey) && !"null".equals(returnKey)) {
	            eventResponse.setUserMessage("Transmitted to Fax server successfully");
	            eventResponse.setCustomData("key", returnKey);
	        } 
	        else {
	            eventResponse.setUserMessage("FAIL TO CREATE FAX_SND_NO TABLE COM_FAX_SND_INFO");
	          //eventResponse.setCustomData("key", returnKey);
	            eventResponse.setCustomData("key", "");
	        }        
	
	        commit();
	        
	//        begin();
	//        event.getDmtComFaxSndInfoVO().setBatFlg("F");
	//        command.insertDmtFaxEmlSndHistory( returnKey , event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
	//        commit();
	
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
     * DOM_FAX_EMAIL : DMT MAIL 전송 및 로그를 생성합니다<br>
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
	        //event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlSndrAdd("mjchang@hanjin.com");
	        //event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd("mjcsurv@nate.com;mjchang@hanjin.com");
	        //event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlCcrcvrAdd("mjchang@hanjin.com");
	        
//	        String tRcvr = event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlRcvrAdd();
//	        begin();
//	        event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd( tRcvr );
//	        String dfltEml ="";
	        
        	String dfltEml = command.searchSenderEmailByUser(account);
	        
//	       if(dfltEml.equals("") || dfltEml == null){
        	if (dfltEml == null || "".equals(dfltEml)) {
        	    eventResponse.setUserMessage("There is no your E-mail address.\n[ HJS email sender address update advice ]\n  1st.  Your email address is required to send email.\n  2nd.  Please open : Comm > Security\n  3rd.  Pease input your email address at \"Email\" column.");
        	}
        	else {
        		DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO = event.getDmtComRDFaxEmailSendInfoVO();
        		dmtComRDFaxEmailSendInfoVO.setRdFxemlEmlSndrAdd(command.searchSenderEmailByUser(account)); 
        		
	        	begin();
		        String returnKey = command.sendEmailInvoice(dmtComRDFaxEmailSendInfoVO, event.getDmtComFaxSndInfoVO(), account);
		        commit();  
		        log.debug("\n ####### sendEmailInvoice returnKey [" + returnKey + "]");
//		        if (!returnKey.equals("") && !returnKey.equals("null") && returnKey != null) {
		        if (returnKey != null && !"".equals(returnKey) && !"null".equals(returnKey)) {
		            eventResponse.setUserMessage("Transmitted to E-mail server successfully");
		            eventResponse.setCustomData("key", returnKey);
		        } 
		        else {
		            eventResponse.setUserMessage("FAIL TO CREATE EML_SND_NO TABLE COM_EML_SND_INFO");
		            //eventResponse.setCustomData("key", returnKey);
		            eventResponse.setCustomData("key", "");
		        }
		        
		        String tRcvr = event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlRcvrAdd();
		        log.debug("\n ####### sendEmailInvoice tRcvr [" + tRcvr + "]");
		        StringTokenizer stRcvr = new StringTokenizer( tRcvr , ";" );
		        while( stRcvr.hasMoreTokens() ){
		            String tRcvvVal = stRcvr.nextToken();
		            log.debug("\n ####### sendEmailInvoice tRcvvVal [" + tRcvvVal + "]");
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
	 * 사용자가 주어진 권한정보를 갖고 있는지 조회 합니다.<br>
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
			
			log.debug("\n ROLE_PERMIT ====> "+returnVO.getIsAuthorized() );
			log.debug("\n ROLE_AUTH   ====> "+returnVO.getUsrRoleCd() );
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_4004 : Retrieve<br>
	 * SHEET SET 이 존재하는지 조회 합니다.<br>
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
     * DOM_FAX_EMAIL : DMT MULTI RD ATTACH MAIL 전송 및 로그를 생성합니다<br>
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
	        //event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlSndrAdd("mjchang@hanjin.com");
	        //event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd("mjcsurv@nate.com;mjchang@hanjin.com");
	        //event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlCcrcvrAdd("mjchang@hanjin.com");        
	        
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
	        	if (returnKey != null && !"".equals(returnKey) && !"null".equals(returnKey)) {
		            eventResponse.setUserMessage("Transmitted to E-mail server successfully");
	                eventResponse.setCustomData("key", returnKey);
		        } else {
		            eventResponse.setUserMessage("FAIL TO CREATE EML_SND_NO TABLE COM_EML_SND_INFO");
		            //eventResponse.setCustomData("key", returnKey);
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
	 * office별 sheet Option 내용을 조회한다.<br>
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
     * DOM_FAX_EMAIL : DMT MAIL 전송 및 로그를 생성합니다<br>
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
        StringBuffer invoiceno = new StringBuffer();
        StringBuffer tarifftp = new StringBuffer();
        String attnname = "";
        String cntrinvno = "";
        StringBuffer creofccd = new StringBuffer();
        
        String attnMail = "";
        String rdFileNm = "";
        String sendFileName = "";
        String cngOfcCd = "";
        
        DmtComFaxEmailEvent event = (DmtComFaxEmailEvent) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
	        log.debug("\n ###################################################### START SC sendRDEmail2All");
	        String paycMail = (String)e.getAttribute("paycMail");
	        StringTokenizer st01 = new StringTokenizer(paycMail, ",");
	
	        String paynMail = (String)e.getAttribute("paynMail");
	        StringTokenizer st11 = new StringTokenizer(paynMail, "|");
	
	        OtsInquiryByDetialVO otsInquiryByDetialVO01 = null;
	//        OtsInquiryByDetial3VO otsInquiryByDetial3VO01 = null;
	        
	        InvoiceIssueCollectionMgtBC command01 = new InvoiceIssueCollectionMgtBCImpl();
	        CommonFaxEmailBC command02 = new CommonFaxEmailBCImpl();
	        CommonFinderBC command03 = new CommonFinderBCImpl();
	        
	        String dfltEml ="";
	        dfltEml = command02.searchSenderEmailByUser(account);
	        cngOfcCd = account.getOfc_cd();
	        
	       if(dfltEml.equals("") || dfltEml == null){
        	    eventResponse.setUserMessage("There is no your E-mail address.\n[ HJS email sender address update advice ]\n  1st.  Your email address is required to send email.\n  2nd.  Please open : Comm > Security\n  3rd.  Pease input your email address at \"Email\" column.");
        	}else{
	        
	        
	        
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
	            
	            // payer code 와 user office code 로 remark address telno faxno custval 구하기
	            String rtnRemark = command01.searchOTSInquiryByDetailListRemark( event.getOtsInquiryParmVO() );
	//            String[] arrRmk01 = StringUtil.split(rtnRemark, "|");
	            
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
	            event.getFAXEmailByPayerVO().setOfcCd(cngOfcCd);
	            event.getFAXEmailByPayerVO().setDmdtTrfCd("");
	            fAXEmailByPayerVO = command01.searchFAXEmailByPayer(event.getFAXEmailByPayerVO());
	            attnMail = fAXEmailByPayerVO.getEmailNos();
	            faxno = fAXEmailByPayerVO.getFaxNos();
	                        
	            log.debug("\n *****####### attnMail [" + attnMail + "] tPayerCd [" + tPayerCd + "]");
	            if ( !attnMail.equals("") ) {
	            
	                List<OtsInquiryByDetialVO> list01 = command01.searchOTSInquiryByDetailList ( event.getOtsInquiryParmVO() );
	                
	                // offadd header leftright title custrefYN telfaxYN custvalYN 구하기
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

	                invoiceno = new StringBuffer();
	                tarifftp = new StringBuffer();
	                creofccd = new StringBuffer();
	                
	                for ( int aii = 0 ; aii < list01.size() ; aii++ ) {
	                    otsInquiryByDetialVO01 = list01.get(aii);
	                    invoiceno.append( otsInquiryByDetialVO01.getInvnoo() ).append( "," );
	                    tarifftp.append ( otsInquiryByDetialVO01.getTarftp() ).append( "," );		//2010.02.26. multi tariff 조회
	                    creofccd.append ( otsInquiryByDetialVO01.getIsseof() ).append( "," );
	                }
	                
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
	//                                     "[" + event.getOtsInquiryParmVO().getTftp2() +"] " +
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
	                
	                String emlTitle="";
	                
	                if (cngOfcCd.equals("SAOSC")) {
	                	PayerNameParamVO payerNameParamVO = new PayerNameParamVO();
	                	PayerNameVO payerNameVO = new PayerNameVO();

	                	payerNameParamVO.setSCustCd(tPayerCd);
	                	payerNameParamVO.setSCustGubun("2");  // "1" : Vendor 테이블 조회, "2" : Customer 테이블 조회, 
	                	
	        			payerNameVO = command03.searchPayerName(payerNameParamVO);
	                	
	                	emlTitle = "DEM/DET Statement of Accounts (SM Line)---Payer Name : " + payerNameVO.getCustName();
	                	event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlTemplt ("EES_DMT_4011_02.html");
	                }
	                else {
	                	emlTitle = "Statement of Accounts (SM Line)---Cust. Code : "+tPayerCd;
	                	event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlTemplt ("EES_DMT_4011_01.html");
	                }
	                
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlTitle     (emlTitle);
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlDocTp     ("O");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlRdParam   (rdParam);
	                //event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFaxNo     ("DMT;3415");								//event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlFaxNo     ()
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFaxNo     (faxno);								//event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlFaxNo     ()
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFaxSndrId ("SM Line");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlSndrNm ("SM Line");
	                //event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd("mjcsurv@nate.com;mjchang@hanjin.com");	//event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlRcvrAdd()
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd(attnMail);	
	                
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlAtchFile(sendFileName+"_"+tPayerCd);
	//                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlAtchFile();sendFileName
	//                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlSndrAdd();
	//                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlTmpltParam();
	                
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
	                
	                String tRcvr = attnMail;
	                
	                DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO = event.getDmtComRDFaxEmailSendInfoVO();
	                dmtComRDFaxEmailSendInfoVO.setRdFxemlEmlRcvrAdd(tRcvr);
	                dmtComRDFaxEmailSendInfoVO.setRdFxemlEmlSndrAdd(command02.searchSenderEmailByUser(account));
	                
	                begin();
	                	String returnKey = command02.sendEmailInvoice(dmtComRDFaxEmailSendInfoVO, event.getDmtComFaxSndInfoVO() , account);
	                commit(); 
	                
	                log.debug("\n ####### sendEmailInvoice returnKey [" + returnKey + "]");
	                if (returnKey != null && !"".equals(returnKey) && !"null".equals(returnKey)) {
	                    eventResponse.setUserMessage("Transmitted to E-mail server successfully");
	                    eventResponse.setCustomData("key", returnKey);
	                } 
	                else {
	                    eventResponse.setUserMessage("FAIL TO CREATE EML_SND_NO TABLE COM_EML_SND_INFO");
	                    //eventResponse.setCustomData("key", returnKey);
	                    eventResponse.setCustomData("key", "");
	                }
	                
	                //tRcvr = event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlRcvrAdd();
	                tRcvr = attnMail;
	                log.debug("\n ####### sendRDEmail2All tRcvr [" + tRcvr + "]");
	                StringTokenizer stRcvr = new StringTokenizer( tRcvr , ";" );
	                event.getDmtComRDFaxEmailSendInfoVO().setInvno(invoiceno.toString());
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
        }
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
     * DOM_FAX_EMAIL : DMT MAIL 전송 및 로그를 생성합니다<br>
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
        StringBuffer invoiceno = new StringBuffer();
        StringBuffer tarifftp = new StringBuffer();
        String attnname = "";
        String cntrinvno = "";
        StringBuffer creofccd = new StringBuffer();
        
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
	//        OtsInquiryByDetial3VO otsInquiryByDetial3VO01 = null;
	        
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
	            
	            // payer code 와 user office code 로 remark address telno faxno custval 구하기
	            String rtnRemark = command01.searchOTSInquiryByDetailListRemark( event.getOtsInquiryParmVO() );
	//            String[] arrRmk01 = StringUtil.split(rtnRemark, "|");
	            
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
	            log.debug("\n *****####### setPayerCd [" + event.getFAXEmailByPayerVO().getPayerCd() + "] setOfcCd [" + event.getFAXEmailByPayerVO().getOfcCd() + "] setDmdtTrfCd [" + event.getFAXEmailByPayerVO().getDmdtTrfCd() + "]");
	            fAXEmailByPayerVO = command01.searchFAXEmailByPayer(event.getFAXEmailByPayerVO());
	            attnMail = fAXEmailByPayerVO.getEmailNos();	//실제 전송할 메일 주소
	            faxno = fAXEmailByPayerVO.getFaxNos();		//실제 전송할 fax no
	            
	            
	            log.debug("\n *****####### faxno [" + faxno + "] tPayerCd [" + tPayerCd + "] attnMail [" + attnMail + "]");
	            if ( !faxno.equals("") ) {
	            
	                List<OtsInquiryByDetialVO> list01 = command01.searchOTSInquiryByDetailList ( event.getOtsInquiryParmVO() );
	                
	                // offadd header leftright title custrefYN telfaxYN custvalYN 구하기
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
	                
	                invoiceno = new StringBuffer();
	                tarifftp = new StringBuffer();
	                creofccd = new StringBuffer();
	                
	                for ( int aii = 0 ; aii < list01.size() ; aii++ ) {
	                    otsInquiryByDetialVO01 = list01.get(aii);
	                    invoiceno.append( otsInquiryByDetialVO01.getInvnoo() ).append( "," );
	                    tarifftp.append ( otsInquiryByDetialVO01.getTarftp() ).append( "," );		//2010.02.26. multi tariff 조회
	                    creofccd.append ( otsInquiryByDetialVO01.getIsseof() ).append( "," );
	                }
	                
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
	//                                   "[" + event.getOtsInquiryParmVO().getTftp2() +"] " +
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
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlTitle     ("Statement of Accounts (SM Line)");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlDocTp     ("O");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlRdParam   (rdParam);
	                //event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFaxNo     ("DMT;3415");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFaxNo     (faxno);
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFaxSndrId ("SM Line");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlSndrNm ("SM Line");
	                //event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd("mjcsurv@nate.com;mjchang@hanjin.com");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd(attnMail);
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlTemplt ("EES_DMT_4011_01.html");
	//                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlAtchFile();
	//                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlSndrAdd();
	//                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlTmpltParam();
	                
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
	                String returnKey = command02.sendFaxInvoice( event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
	                log.debug("####### sendFaxInvoice returnKey [" + returnKey + "]");
	                if (returnKey != null && !"".equals(returnKey) && !"null".equals(returnKey)) {
	                    eventResponse.setUserMessage("Transmitted to Fax server successfully");
	                    eventResponse.setCustomData("key", returnKey);
	                } else {
	                    eventResponse.setUserMessage("FAIL TO CREATE FAX_SND_NO TABLE COM_FAX_SND_INFO");
	                    //eventResponse.setCustomData("key", returnKey);
	                    eventResponse.setCustomData("key", "");
	                }        
	        
	                commit();
	
	                String tRcvr = faxno;
	                //tRcvr = event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlRcvrAdd();
	                log.debug("\n ####### sendRDFax2All tRcvr [" + tRcvr + "]");
	                StringTokenizer stRcvr = new StringTokenizer( tRcvr , ";" );
	                event.getDmtComRDFaxEmailSendInfoVO().setInvno(invoiceno.toString());
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
	//                begin();
	//
	//                ////////////
	//                //String tempINVNO = (String)event.getDmtComRDFaxEmailSendInfoVO().getInvno();
	//                //String tempPAYER = (String)event.getDmtComRDFaxEmailSendInfoVO().getPayc();
	//                event.getDmtComRDFaxEmailSendInfoVO().setInvno(invoiceno);
	//                event.getDmtComRDFaxEmailSendInfoVO().setPayc(tPayerCd);
	//                
	//                log.debug(" #################### tempInVNo ###" + invoiceno);
	//                log.debug(" #################### tempPAYER ###" + tPayerCd);
	//                
	//                
	//                event.getDmtComFaxSndInfoVO().setBatFlg("F");
	//                command02.insertDmtFaxEmlSndHistory( returnKey , event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
	//                commit();
	            
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
     * Basic Tariff Creation 조회조건 전체를 불러온다.(Tariff Type, Continent, Country, Region)<br>
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
			// 아래 Logic은 실제 화면 적용시에 변경 처리 필요 : 적용 후 주석 삭제 
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
     * Basic Tariff Detail(s) Inquiry 조회조건 전체를 불러온다.(Tariff Type, Continent, Country, Region, Container & Cargo)<br>
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
			// 아래 Logic은 실제 화면 적용시에 변경 처리 필요 : 적용 후 주석 삭제 
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
     * Basic Tariff Summary Inquiry 조회조건 전체를 불러온다.(Tariff Type, Country, Continent)<br>
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
     * Commodity Exception Tariff Inquiry 조회조건 전체를 불러온다.(All Tariff Type, Continent, Country, Region)<br>
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
			// 아래 Logic은 실제 화면 적용시에 변경 처리 필요 : 적용 후 주석 삭제 
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
	 * Office코드로 국가코드를 조회<br>
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
	 * From Date, To Date 사이의 차이 일수를 조회 합니다. <br>
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
	 * OFC_CD로 RHQ_OFC_CD를 조회 합니다.<br>
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
	 * EES_DMT_3015 : Retrieve<br>
	 * Yard code  유효성 조회. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkYardCd(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		CommonFinderBC			command 		= new CommonFinderBCImpl();
		DmtComEvent 			event 			= (DmtComEvent)e;
		
        try {
	        String yd_cd = (String)event.getAttribute("yd_cd");
	        String chk_yd_cd = command.checkYardCd(yd_cd);
	        Map<String,String> etcData = new HashMap<String,String>();
	        etcData.put("chk_yd_cd",chk_yd_cd);
	        eventResponse.setETCData(etcData);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_7009 : yard code <br>
	 * Yard code  관련 정보 조회. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardInfo(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		CommonFinderBC			command 		= new CommonFinderBCImpl();
		DmtComEvent 			event 			= (DmtComEvent)e;
		
        try {
	        String yd_cd = (String)event.getAttribute("yd_cd");
	        String yd_nm =  command.searchYardInfo(yd_cd);
	        Map<String,String> etcData = new HashMap<String,String>();
	        etcData.put("yd_nm",yd_nm);
	        eventResponse.setETCData(etcData);
	        
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * User ID 소속 Office Code를 조회<br>
	 *
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUserOfcCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		try {
			String rtnStr = command.searchUserOfcCd(account.getUsr_id());
			eventResponse.setETCData("OFC_CD", rtnStr);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Office의  Local Time 조회<br>
	 *
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOfcLocalTime(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		try {
			String rtnStr = command.searchOfcLocalTime(account.getOfc_cd());
			eventResponse.setETCData("LCL_TIME", rtnStr);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3004 : Window Open<br>
	 * Log in User 정보를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			UserInfoVO userInfoVO = new UserInfoVO();
			
			userInfoVO = command.searchUserInfo(account);
			
			eventResponse.setETCData("CNG_RHQ_OFC_CD", JSPUtil.getNull(userInfoVO.getCngRhqOfcCd()));
			eventResponse.setETCData("LST_LGIN_OFC_CD", JSPUtil.getNull(userInfoVO.getLstLginOfcCd()));
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * DMT User Role 정보를 확인<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchUserRoleCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			UserRoleVO userRoleVO = new UserRoleVO();
			
			String pgmNo = "";
			if(e.getEventName().equalsIgnoreCase("EesDmt4001Event")) {
				// 어느 화면에서 호출했는지를 파라메터 VO에 담는다.
				// 4001 화면은 DMT01~02
				// 나머지 화면은 DMT01~04
				pgmNo = "EES_DMT_4001";
			}
			
			userRoleVO.setUsrId(account.getUsr_id());
			userRoleVO.setPgmNo(pgmNo);
			
			String role_auth_flag = command.searchUserRoleCode(userRoleVO);
			
			eventResponse.setETCData("ROLE_AUTH_FLAG" , role_auth_flag);
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * DMT User Office Level 정보를 확인<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchUserOfcLvl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {	
			log.debug("\n[searchUserOfcLvl] LOGIN USER ID : " + account.getUsr_id() + ", LOGIN OFFICE CD : " + account.getOfc_cd() + ", RHQ OFFICE CD : " + account.getRhq_ofc_cd());
			eventResponse.setETCData("USER_OFC_LVL" , command.searchUserOfcLvl(account.getOfc_cd()));
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
	 * EES_DMT_7017 : Retrieve<br>
	 * RHQ 산하 DMT OFC 를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubOfficeListByRHQ(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent)e;
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<OfficeNameVO> officeNameVOList = command.searchSubOfficeListByRHQ(event.getOfficeNameVO());
			
			if (officeNameVOList != null && officeNameVOList.size() > 0) {			
				StringBuffer sbOfcCd = new StringBuffer();
				
				for (OfficeNameVO officeNameVO : officeNameVOList) {
					if (sbOfcCd.length() > 0) sbOfcCd.append("|");
					sbOfcCd.append(officeNameVO.getOfcCd()).append("=").append(officeNameVO.getOfcEngNm());
				}
				
				eventResponse.setETCData("OFC_CD", sbOfcCd.toString());
			}
			else {
				eventResponse.setETCData("OFC_CD", "");	
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
	 * EES_DMT_7017 : Retrieve<br>
	 * 사용자 로그인 Office 산하 DMT Office 를 조회한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubOfficeListByUserLoginOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			List<OfficeNameVO> officeNameVOList = command.searchSubOfficeListByUserLoginOffice(account.getOfc_cd());
			
			if (officeNameVOList != null && officeNameVOList.size() > 0) {			
				StringBuffer sbOfcCd = new StringBuffer();
				
				for (OfficeNameVO officeNameVO : officeNameVOList) {
					if (sbOfcCd.length() > 0) sbOfcCd.append("|");
					sbOfcCd.append(officeNameVO.getOfcCd()).append("=").append(officeNameVO.getOfcEngNm());
				}
				
				eventResponse.setETCData("OFC_CD", sbOfcCd.toString());
			}
			else {
				eventResponse.setETCData("OFC_CD", "");	
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
	 * 파일존재유무판단  
	 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFileExistence(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtComEvent event = (DmtComEvent) e;
		
		try {
			boolean fileExist = new FileDatabaseData(event.getFileSavId()).getFile().exists();
			eventResponse.setETCData("is_exists", String.valueOf(fileExist));
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * 로그인 OFC에 해당하는 SYS_AREA_GRP_ID(SVR_ID) 를 구한다. 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSysAreaGrpId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		try {
			String ofcCd = command.searchSysAreaGrpId(account.getOfc_cd());
			eventResponse.setETCData("SVR_ID", ofcCd);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	} 
	
	/**
	 * Payer 정보가 DMT_PAYR_INFO 테이블에 존재하는지 확인한다.(Y/N) 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDmtPayerInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        DmtComEvent event = (DmtComEvent)e;
        CommonFinderBC command = new CommonFinderBCImpl();
		try {
			String svrId = (String)event.getAttribute("svr_id");
			String payrCd = (String)event.getAttribute("payer_cd");
			String flag = command.checkDmtPayerInfo(svrId, payrCd);
			eventResponse.setETCData("PAYR_FLG", flag);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	} 
	
	

    /**
     * Auto Email Send<br>
     * DOM_FAX_EMAIL : DMT MAIL 전송 및 로그를 생성합니다<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unused")
	private EventResponse sendRDEmailDetailAll(Event e) throws EventException {
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
        StringBuffer invoiceno = new StringBuffer();
        StringBuffer tarifftp = new StringBuffer();
        String attnname = "";
        String cntrinvno = "";
        StringBuffer creofccd = new StringBuffer();
        
        String attnMail = "";
        String rdFileNm = "";
        String sendFileName = "";
        String cngOfcCd = "";
        
        
        DmtComFaxEmailEvent event = (DmtComFaxEmailEvent) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
	        log.debug("\n ###################################################### START SC sendRDEmailDetailAll");
	        String paycMail = (String)e.getAttribute("paycMail");
	        StringTokenizer st01 = new StringTokenizer(paycMail, ",");
	
	        String paynMail = (String)e.getAttribute("paynMail");
	        StringTokenizer st11 = new StringTokenizer(paynMail, "|");
	        
	        String sndInvFlg = (String)e.getAttribute("sndInvFlg");
	        String sndCntrListFlg = (String)e.getAttribute("sndCntrListFlg");
	        String mailOfcCd = (String)e.getAttribute("mailOfcCd");
	        String emlSndrAdd = (String)e.getAttribute("emlSndrAdd");
	
	        OtsInquiryByDetialVO otsInquiryByDetialVO01 = null;
	        
	        InvoiceIssueCollectionMgtBC command01 = new InvoiceIssueCollectionMgtBCImpl();
	        CommonFaxEmailBC command02 = new CommonFaxEmailBCImpl();
	        CommonFinderBC command03 = new CommonFinderBCImpl();
	        
	        cntrinvno = event.getOtsInquiryParmVO().getCntrinvno();
	        sendFileName = event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlAtchFile();
	        
	          
	        log.debug(
	                  "\n ####### paycMail  [" + paycMail  + "]" +
	                  "\n ####### paynMail  [" + paynMail  + "]" +
	                  "\n ####### FileName  [" + sendFileName  + "]" +
	                  "\n ####### cntrinvno [" + cntrinvno + "]"  +
	                  "\n ####### mailOfcCd [" + mailOfcCd + "]"  +
	                  "\n ####### emlSndrAdd [" + emlSndrAdd + "] \n"
	                 );        
	        
	        log.debug("\n ###################################################### while (st01.hasMoreTokens()) { S T A R T ");
	        while (st01.hasMoreTokens()) {
	            
	            custname = st11.nextToken();
	            String tPayerCd = st01.nextToken();
	            event.getOtsInquiryParmVO().setPayc(tPayerCd);
	            
	            // payer code 와 user office code 로 remark address telno faxno custval 구하기
	            String rtnRemark = command01.searchOTSInquiryByDetailListRemark( event.getOtsInquiryParmVO() );
	//            String[] arrRmk01 = StringUtil.split(rtnRemark, "|");
	            
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
	                    int arr02cnt = arrRmk02.length;
	                    
	                    if ( arr02cnt >= 1){
		                    if ( !StringUtils.isEmpty( StringUtils.trimToEmpty( arrRmk02[0] ) ) ) { remark01 = arrRmk02[0]; } else { remark01 = ""; }
	                    } else {
	                    	remark01 = "";
	                    }  
	                    remark01 = remark01.replaceAll( "'" , " " );
	                    
	                    if ( arr02cnt >= 2){
		                    if ( !StringUtils.isEmpty( StringUtils.trimToEmpty( arrRmk02[1] ) ) ) { remark02 = arrRmk02[1]; } else { remark02 = ""; }	 
	                    } else {
	                    	remark02 = "";
	                    }
	                    remark02 = remark02.replaceAll( "'" , " " );
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
	
	            } 
	            
	            //searchFAXEmailByPayer
	            FAXEmailByPayerVO fAXEmailByPayerVO = new FAXEmailByPayerVO();
	            fAXEmailByPayerVO.setPayerCd(tPayerCd);
	            fAXEmailByPayerVO.setOfcCd(mailOfcCd);
	            fAXEmailByPayerVO.setDmdtTrfCd("");
	            attnMail = command02.searchEmailByPayer(fAXEmailByPayerVO);
	                        
	            log.debug("\n *****####### attnMail [" + attnMail + "] tPayerCd [" + tPayerCd + "]");
	            
	            if ( attnMail.equals("") ) {
	            	attnMail = emlSndrAdd;
	            }
	            
	            if ( !attnMail.equals("") ) {
	            
	                List<OtsInquiryByDetialVO> list01 = command01.searchOTSInquiryByDetailList ( event.getOtsInquiryParmVO() );
	                
	                // offadd header leftright title custrefYN telfaxYN custvalYN 구하기
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

	                invoiceno = new StringBuffer();
	                tarifftp = new StringBuffer();
	                creofccd = new StringBuffer();
	                StringBuffer invNoList = new StringBuffer();
	                
	                for ( int aii = 0 ; aii < list01.size() ; aii++ ) {
	                    otsInquiryByDetialVO01 = list01.get(aii);
	                    invoiceno.append( otsInquiryByDetialVO01.getInvnoo() ).append( "," );
	                    tarifftp.append ( otsInquiryByDetialVO01.getTarftp() ).append( "," );		
	                    creofccd.append ( otsInquiryByDetialVO01.getIsseof() ).append( "," );
	                    invNoList.append ( otsInquiryByDetialVO01.getInvnoo() ). append( "," );
	                }
	                
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
	//                                     "[" + event.getOtsInquiryParmVO().getTftp2() +"] " +
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
	                                     "["     + "DEM/DET Team" + "] " +
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
	                
	                String emlTitle="";
	                
	                if (cngOfcCd.equals("SAOSC")) {
	                	PayerNameParamVO payerNameParamVO = new PayerNameParamVO();
	                	PayerNameVO payerNameVO = new PayerNameVO();

	                	payerNameParamVO.setSCustCd(tPayerCd);
	                	payerNameParamVO.setSCustGubun("2");  // "1" : Vendor 테이블 조회, "2" : Customer 테이블 조회, 
	                	
	        			payerNameVO = command03.searchPayerName(payerNameParamVO);
	                	
	                	emlTitle = "DEM/DET Statement of Accounts (SM Line)---Payer Name : " + payerNameVO.getCustName();
	                	event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlTemplt ("EES_DMT_4011_02.html");
	                }
	                else {
	                	emlTitle = "Statement of Accounts (SM Line)---Cust. Code : "+tPayerCd;
	                	event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlTemplt ("EES_DMT_4011_01.html");
	                }
	                
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlTitle     (emlTitle);
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlDocTp     ("O");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlRdParam   (rdParam);
	                
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFaxNo     (faxno);								//event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlFaxNo     ()
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlFaxSndrId ("SM Line");
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlSndrNm ("SM Line");
	                
	                event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd(attnMail);	
	                
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
	                
	                String tRcvr = attnMail;
	                
	                DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO = event.getDmtComRDFaxEmailSendInfoVO();
	                dmtComRDFaxEmailSendInfoVO.setRdFxemlEmlRcvrAdd(tRcvr);
	                dmtComRDFaxEmailSendInfoVO.setRdFxemlEmlSndrAdd(emlSndrAdd);
	                dmtComRDFaxEmailSendInfoVO.setInvno(invNoList.toString());
	                String creOf = dmtComRDFaxEmailSendInfoVO.getCreof();
	                dmtComRDFaxEmailSendInfoVO.setCreof("");
	                dmtComRDFaxEmailSendInfoVO.setOffcd(mailOfcCd);
	                
	                if ( !StringUtils.isEmpty( rdFileNm) ) {
		                String returnKey = "";
		                //begin();
	                	returnKey = command02.sendReportDesignerWithBatchFiles(dmtComRDFaxEmailSendInfoVO, "BATCH", sndCntrListFlg, sndInvFlg );
		                //commit(); 
		                
		                log.debug("\n ####### sendEmailInvoice returnKey [" + returnKey + "]");
		                if (returnKey != null && !"".equals(returnKey) && !"null".equals(returnKey)) {
		                    eventResponse.setUserMessage("Transmitted to E-mail server successfully");
		                    eventResponse.setCustomData("key", returnKey);
		                } 
		                else {
		                    eventResponse.setUserMessage("FAIL TO CREATE EML_SND_NO TABLE COM_EML_SND_INFO");
		                    eventResponse.setCustomData("key", "");
		                }
		                
		                tRcvr = event.getDmtComRDFaxEmailSendInfoVO().getRdFxemlEmlRcvrAdd();
		                tRcvr = attnMail;
		                log.debug("\n ####### sendRDEmail2All tRcvr [" + tRcvr + "]");
		                StringTokenizer stRcvr = new StringTokenizer( tRcvr , ";" );
		                event.getDmtComRDFaxEmailSendInfoVO().setInvno(invoiceno.toString());
		                event.getDmtComRDFaxEmailSendInfoVO().setPayc(tPayerCd);
		                
		                while( stRcvr.hasMoreTokens() ){
		                    String tRcvvVal = stRcvr.nextToken();
		                    log.debug("\n ####### sendRDEmail2All tRcvvVal [" + tRcvvVal + "]");
		                    String tRcvvVal2 = "";
		                    if ( tRcvvVal.length() > 200 ){
			                    String[] eMail = StringUtils.split(tRcvvVal, ",");
			                    int eMailcnt = eMail.length;	                    
			                    tRcvvVal2 = eMail[0] + " ( Addition " + ( eMailcnt - 1 ) + " ) ";
		                    } else {
		                    	tRcvvVal2 = tRcvvVal;
		                    }
			                    
		                    event.getDmtComRDFaxEmailSendInfoVO().setRdFxemlEmlRcvrAdd( tRcvvVal2 );
		                    //begin();
		                    event.getDmtComFaxSndInfoVO().setBatFlg("E");
		                    event.getDmtComRDFaxEmailSendInfoVO().setCreof(creOf);
		                    command02.insertDmtFaxEmlSndHistory( returnKey , event.getDmtComRDFaxEmailSendInfoVO() , event.getDmtComFaxSndInfoVO() , account );
		                    //commit();
		                }
	                }
	            	
	            } else { // end of if ( !attnMail.equals("") ) {
	                eventResponse.setUserMessage("E-mail address missing! Pls input E-mail address in Payer Info ["+tPayerCd+"]");
	            } // end of if ( !attnMail.equals("") ) {
	            log.debug("\n ###################################################### while (st01.hasMoreTokens()) tPayerCd [" + tPayerCd + "] { D E E N D ");
	        } // while (st01.hasMoreTokens()) {
//        }
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
}