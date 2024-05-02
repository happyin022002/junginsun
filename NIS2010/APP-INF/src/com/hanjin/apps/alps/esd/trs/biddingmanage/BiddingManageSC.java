/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingManageSC.java
*@FileTitle : Bidding Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-01
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 최초 생성
* 
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.basic.BiddingCandidateBC;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.basic.BiddingCandidateBCImpl;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.event.EsdTrs0940Event;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.integration.BiddingCandidateDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.basic.BiddingCandidateRegistrationBC;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.basic.BiddingCandidateRegistrationBCImpl;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.event.EsdTrs0300Event;
import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidperformancereport.basic.SpotBidPerformanceReportBC;
import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidperformancereport.basic.SpotBidPerformanceReportBCImpl;
import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidperformancereport.event.EsdTrs0092Event;
import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.basic.SpotBidWorkOrderIssueBC;
import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.basic.SpotBidWorkOrderIssueBCImpl;
import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.event.EsdTrs0091Event;
import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.vo.SpotBidWoIssueListVO;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author SHIN DONG IL
 * @see BiddingCandidateDBDAO 참조
 * @since J2EE 1.6
 */
public class BiddingManageSC extends ServiceCommandSupport {
		// Login User Information
		private SignOnUserAccount account = null;
		
		/**
		 * TRS 업무 시나리오 선행작업<br>
		 * BiddingManage업무 시나리오 호출시 관련 내부객체 생성<br>
		 */
		public void doStart() {
			try {
				account = getSignOnUserAccount();
			} catch (Exception e) {
				log.error("BiddingManageSC 선행 작업 시 오류 " + e.toString(), e);
			}
		}

		/**
		 * TRS 업무 시나리오 마감작업<br>
		 * BiddingManage 시나리오 종료시 관련 내부객체 해제<br>
		 */
		public void doEnd() {
			// command.doEnd();
			log.debug("BiddingManageSC 종료");
		}	
		
		/**
		 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
		 * ESD-TRS 업무에서 발생하는 모든 이벤트의 분기처리<br>
		 * 
		 * @param e Event
		 * @return response EventResponse
		 * @exception EventException
		 */
		public EventResponse perform(Event e) throws EventException {
			// RDTO(Data Transfer Object including Parameters)
			EventResponse eventResponse = null;
			if (e.getEventName().equalsIgnoreCase("EsdTrs0940Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchBiddingCandidateList(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchInvitationVendor(e);	
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = multiSpotBidManage(e);
				}
			}else if(e.getEventName().equalsIgnoreCase("EsdTrs0300Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchSpotBidCnddtTermList(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchSpotBidCnddtVndrList(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = addSpotBidCnddtTerm(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = delSpotBidCnddtTerm(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI11)) {
					eventResponse = addSpotBidCnddtVndr(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) {
					eventResponse = delSpotBidCnddtVndr(e);
				}
			}else if (e.getEventName().equalsIgnoreCase("EsdTrs0091Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchWorkOrderIssueList(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchWorkOrderIssueBySoNo(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					eventResponse = searchLocalCurr2UsdCurr(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
					eventResponse = searchWoIssuedSoList(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
					eventResponse = searchWorkOrderPreviewStatusCheck(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH40)) {
					eventResponse = searchMoreBidder(e);
				}
			}else if (e.getEventName().equalsIgnoreCase("EsdTrs0092Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = srchSpotBidPerfRpt(e);
				}/*else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					//eventResponse = searchSOInquiryExcelDown(e);
				}*/
			}
			return eventResponse;
		}
		
		/**
		 * 조회 이벤트 처리<br>
		 * Vendor 조회
		 * 
		 * @param e Event
		 * @return eventResponse EventResponse
		 * @exception EventException
		 */
		private EventResponse searchInvitationVendor(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			EsdTrs0940Event event = (EsdTrs0940Event)e;
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			
			try {
				BiddingCandidateBC command = new BiddingCandidateBCImpl();
				eventResponse = command.searchInvitationVendor(event);
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
		
		/**
		 * 조회 이벤트 처리<br>
		 * Bidding Candidate 조회
		 * 
		 * @param e Event
		 * @return eventResponse EventResponse
		 * @exception EventException
		 */
		private EventResponse searchBiddingCandidateList(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			EsdTrs0940Event event = (EsdTrs0940Event)e;
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			
			try {
				BiddingCandidateBC command = new BiddingCandidateBCImpl();
				eventResponse = command.searchBiddingCandidateList(event);
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
		
		/**
		 * 조회 이벤트 처리<br>
		 * ESD_TRS_0940 OK Event처리 
		 * Spot Bidding data생성 및 메일 전송
		 * 
		 * @param e Event
		 * @return eventResponse EventResponse
		 * @exception EventException
		 */
		private EventResponse multiSpotBidManage(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			EsdTrs0940Event event = (EsdTrs0940Event)e;
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			try {
				BiddingCandidateBC command = new BiddingCandidateBCImpl();
				begin();
				command.multiSpotBidManage(event,account);
				commit();
				
				begin();
				command.sendInvitationVendor(event,account);
				commit();
			} catch (EventException de) {
				rollback();
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}

		/**
		 * 조회 이벤트 처리<br>
		 * Bidding Candidate 조회
		 * 
		 * @param e Event
		 * @return eventResponse EventResponse
		 * @exception EventException
		 */
		private EventResponse searchSpotBidCnddtTermList(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			EsdTrs0300Event event = (EsdTrs0300Event)e;
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			
			try {
				BiddingCandidateRegistrationBC command = new BiddingCandidateRegistrationBCImpl();
				eventResponse = command.searchSpotBidCnddtTermList(event);
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
		
		/**
		 * 조회 이벤트 처리<br>
		 * Bidding Candidate 조회
		 * 
		 * @param e Event
		 * @return eventResponse EventResponse
		 * @exception EventException
		 */
		private EventResponse searchSpotBidCnddtVndrList(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			EsdTrs0300Event event = (EsdTrs0300Event)e;
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			
			try {
				BiddingCandidateRegistrationBC command = new BiddingCandidateRegistrationBCImpl();
				eventResponse = command.searchSpotBidCnddtVndrList(event);
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
		
		
		/**
		 * 조회 이벤트 처리<br>
		 * Bidding Candidate 조회
		 * 
		 * @param e Event
		 * @return eventResponse EventResponse
		 * @exception EventException
		 */
		private EventResponse addSpotBidCnddtTerm(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			EsdTrs0300Event event = (EsdTrs0300Event)e;
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			
			try {
				begin();
				BiddingCandidateRegistrationBC command = new BiddingCandidateRegistrationBCImpl();
				
				event.setCreOfcCd(account.getOfc_cd());
				event.setCreUsrId(account.getUsr_id());
				eventResponse = command.addSpotBidCnddtTerm(event);
				commit();
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}

		/**
		 * 조회 이벤트 처리<br>
		 * Bidding Candidate 조회
		 * 
		 * @param e Event
		 * @return eventResponse EventResponse
		 * @exception EventException
		 */
		private EventResponse delSpotBidCnddtTerm(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			EsdTrs0300Event event = (EsdTrs0300Event)e;
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			
			try {
				BiddingCandidateRegistrationBC command = new BiddingCandidateRegistrationBCImpl();
				
				event.setCreOfcCd(account.getOfc_cd());
				event.setCreUsrId(account.getUsr_id());
				eventResponse = command.delSpotBidCnddtTerm(event);
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
		
		/**
		 * 조회 이벤트 처리<br>
		 * Bidding Candidate 조회
		 * 
		 * @param e Event
		 * @return eventResponse EventResponse
		 * @exception EventException
		 */
		private EventResponse addSpotBidCnddtVndr(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			EsdTrs0300Event event = (EsdTrs0300Event)e;
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			
			try {
				begin();
				BiddingCandidateRegistrationBC command = new BiddingCandidateRegistrationBCImpl();
				
				event.setCreOfcCd(account.getOfc_cd());
				event.setCreUsrId(account.getUsr_id());
				eventResponse = command.addSpotBidCnddtVndr(event);
				commit();
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}

		/**
		 * 조회 이벤트 처리<br>
		 * Bidding Candidate 조회
		 * 
		 * @param e Event
		 * @return eventResponse EventResponse
		 * @exception EventException
		 */
		private EventResponse delSpotBidCnddtVndr(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			EsdTrs0300Event event = (EsdTrs0300Event)e;
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			
			try {
				BiddingCandidateRegistrationBC command = new BiddingCandidateRegistrationBCImpl();
				
				event.setCreOfcCd(account.getOfc_cd());
				event.setCreUsrId(account.getUsr_id());
				eventResponse = command.delSpotBidCnddtVndr(event);
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
		
		/**
		 * 조회 이벤트 처리<br>
		 * WorkOrderCCManage 화면에 대한 조회 이벤트 처리<br>
		 * 
		 * @param e Event 
		 * @return eventResponse EventResponse
		 * @exception EventException
		 */
		@SuppressWarnings("unchecked")
		private EventResponse searchWorkOrderIssueList(Event e) throws EventException {
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			EsdTrs0091Event event = (EsdTrs0091Event)e;
//			List<DBRowSet> rsList = new ArrayList<DBRowSet>();
			int i =1;
			
			try {
				SpotBidWorkOrderIssueBC command = new SpotBidWorkOrderIssueBCImpl();
				eventResponse = command.searchWorkOrderIssueList(event);
				
				// Spot Bid 는 Surcharge 가 필요 없으므로 주석처리
				/*List<SpotBidWoIssueListVO> woModel = new ArrayList<SpotBidWoIssueListVO>();

				woModel = (List) eventResponse.getRsVoList();
				if(woModel.size()>0){
				ArrayList scgArr = command.searchSurchargeList(woModel);
				if(scgArr.size()>0){
					DBRowSet scgRs = (DBRowSet) scgArr.get(0);
					@SuppressWarnings("unused")
					String[] colValue = null;
					String scgXml = null;
					StringBuffer sbScgXml = new StringBuffer();
					StringBuffer colOrder = new StringBuffer();
					
					if( scgRs != null ){
						colValue = new String[scgRs.getMetaData().getColumnCount()];
						for(int k=1; k<scgRs.getMetaData().getColumnCount()+1 ; k++) {
							colOrder.append("surcharge_"+scgRs.getMetaData().getColumnName(k).toLowerCase());
							if(k != scgRs.getMetaData().getColumnCount()) colOrder.append("|");
						}
					}
					sbScgXml.append("<SHEET>");
					sbScgXml.append("<DATA COLORDER='"+colOrder+"'>");
					
					for(int k=0; k<scgArr.size(); k++){
						scgRs = (DBRowSet) scgArr.get(k);
						while (scgRs!=null && scgRs.next()) {
							i = 1;
							sbScgXml.append("<TR>");
							for (int j = 0 ; j < scgRs.getMetaData().getColumnCount() ; j++) {
								sbScgXml.append("<TD>"+JSPUtil.getNull(scgRs.getString(i++))+"</TD>");
							}
							sbScgXml.append("</TR>");
						}
					}
					sbScgXml.append("</DATA></SHEET>");
					scgXml = sbScgXml.toString();
					
					eventResponse.setETCData("scgXml", scgXml);
					}
				}*/
				
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			} catch (Exception f){
				log.error("err " + f.toString(), f);
				throw new EventException(f.getMessage());
			}
			return eventResponse;
		}
		
		/**
		 * 조회 이벤트 처리<br>
		 * WorkOrder Issue 화면에 대한 조회 이벤트 처리<br>
		 * @param e Event
		 * @return eventResponse EventResponse
		 * @exception EventException
		 */
		private EventResponse searchMoreBidder(Event e) throws EventException {
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			EsdTrs0091Event event = (EsdTrs0091Event)e;
			
			try {
				SpotBidWorkOrderIssueBC command = new SpotBidWorkOrderIssueBCImpl();
				eventResponse = command.searchMoreBidder(event);
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
		
		/**
		 * 조회 이벤트 처리<br>
		 * WorkOrderPreview 화면의 issue 상테체크에 대한 조회 이벤트 처리<br>
		 * @param e Event
		 * @return eventResponse EventResponse
		 * @throws EventException
		 */
		private EventResponse searchWorkOrderPreviewStatusCheck(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			EsdTrs0091Event event = (EsdTrs0091Event)e;
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			try {
				SpotBidWorkOrderIssueBC command = new SpotBidWorkOrderIssueBCImpl();
				eventResponse = command.searchWorkOrderPreviewStatusCheck(event);
				
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
		
		/**
		 * 조회 이벤트 처리<br>
		 * WorkOrderCCManage 화면에 대한 조회 이벤트 처리<br>
		 * 
		 * @param e Event
		 * @return eventResponse EventResponse
		 * @exception EventException
		 */	
		private EventResponse searchWoIssuedSoList(Event e) throws EventException {
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			EsdTrs0091Event event = (EsdTrs0091Event) e;
			
			try {
				SpotBidWorkOrderIssueBC command = new SpotBidWorkOrderIssueBCImpl();
				eventResponse = command.searchWoIssuedSoList(event);
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
		
		/**
		 * 조회 이벤트 처리<br>
		 * WorkOrderCCManage 화면에 대한 조회 이벤트 처리<br>
		 * 
		 * @param e Event
		 * @return eventResponse EventResponse
		 * @exception EventException
		 */
		@SuppressWarnings("unchecked")
		private EventResponse searchWorkOrderIssueBySoNo(Event e) throws EventException {
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			EsdTrs0091Event event = (EsdTrs0091Event)e;
//			List<DBRowSet> rsList = new ArrayList<DBRowSet>();
			int i =1;
			
			try {
				SpotBidWorkOrderIssueBC command = new SpotBidWorkOrderIssueBCImpl();
				eventResponse = command.searchWorkOrderIssueBySoNo(event);
				
				// Spot Bid 는 Surcharge 가 필요 없어서 주석처리
				/*List<SpotBidWoIssueListVO> woModel = new ArrayList<SpotBidWoIssueListVO>();

				woModel = (List) eventResponse.getRsVoList();
				if(woModel.size()>0){
				ArrayList scgArr = command.searchSurchargeList(woModel);
				if(scgArr.size()>0){
					DBRowSet scgRs = (DBRowSet) scgArr.get(0);
					@SuppressWarnings("unused")
					String[] colValue = null;
					String scgXml = null;
					StringBuffer sbScgXml = new StringBuffer();
					StringBuffer colOrder = new StringBuffer();
					
					if( scgRs != null ){
						colValue = new String[scgRs.getMetaData().getColumnCount()];
						for(int k=1; k<scgRs.getMetaData().getColumnCount()+1 ; k++) {
							colOrder.append("surcharge_"+scgRs.getMetaData().getColumnName(k));
							if(k != scgRs.getMetaData().getColumnCount()) colOrder.append("|");
						}
					}
					sbScgXml.append("<SHEET>");
					sbScgXml.append("<DATA COLORDER='"+colOrder+"'>");
					
					
					for(int k=0; k<scgArr.size(); k++){
						scgRs = (DBRowSet) scgArr.get(k);
						while (scgRs!=null && scgRs.next()) {
							i = 1;
							sbScgXml.append("<TR>");
							for (int j = 0 ; j < scgRs.getMetaData().getColumnCount() ; j++) {
								sbScgXml.append("<TD>"+JSPUtil.getNull(scgRs.getString(i++))+"</TD>");
							}
							sbScgXml.append("</TR>");
						}
					}
					sbScgXml.append("</DATA></SHEET>");
					scgXml = sbScgXml.toString();
					
					eventResponse.setETCData("scgXml", scgXml);
					}
				}*/
				
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			} catch (Exception f){
				log.error("err " + f.toString(), f);
				throw new EventException(f.getMessage());
			}
			return eventResponse;
		}
		
		/**
		 * 조회 이벤트 처리<br>
		 * WorkOrderCCManage 화면에 대한 조회 이벤트 처리<br>
		 * 
		 * @param e Event 
		 * @return eventResponse EventResponse
		 * @exception EventException
		 */
		private EventResponse searchLocalCurr2UsdCurr(Event e) throws EventException {
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			EsdTrs0091Event event = (EsdTrs0091Event)e;
			
			try {
				SpotBidWorkOrderIssueBC command = new SpotBidWorkOrderIssueBCImpl();
				eventResponse = command.searchLocalCurr2UsdCurr(event);
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
		
		/**
		 * 조회 이벤트 처리<br>
		 * SpotBidPerformanceReport의 event에 대한 특정 리스트 조회 이벤트 처리<br>
		 *
		 * @param e Event
		 * @return response EventResponse
		 * @exception EventException
		 */
		private EventResponse srchSpotBidPerfRpt(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			EsdTrs0092Event event = (EsdTrs0092Event)e;
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;		
			try {			
				SpotBidPerformanceReportBC command = new SpotBidPerformanceReportBCImpl();
				eventResponse = command.srchSpotBidPerfRpt(event, account.getOfc_cd());			
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
}
