/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EmptyRepoSOManageSC.java
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-10-30 kim_sang_geun
* 1.0 최초 생성
* -------------------------------------------------------
* history
* 2011.07.20 김영철 [CHM-201111871] [TRS] R4J 소스 품질 조치 내역 수정
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.basic.SingleTransportationSOManageBC;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.basic.SingleTransportationSOManageBCImpl;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.event.EsdTrs0012Event;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.basic.BiddingCandidateBC;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.basic.BiddingCandidateBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author kim_sang_geun
 * @see ESD_TRS_012EventResponse,SingleTransportationSOManageDBDAO 참조
 * @since J2EE 1.4
 */
public class EmptyRepoSOManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	private String sofficeCd = "";

	/**
	 * TRS 업무 시나리오 선행작업<br>
	 * SingleTransportationSOManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
			sofficeCd = account.getOfc_cd();
		} catch (Exception e) {
			log.error("EmptyRepoSOManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SingleTransportationSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("EmptyRepoSOManageSC 종료");
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
		
		//log.debug("event : " + e);

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //Create Search 1
				eventResponse = searchSingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //Create Search 2
				eventResponse = search01SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //Container File Import Search
				eventResponse = search02SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { //Correction Search
				eventResponse = search03SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { //Container mvmt info check
				eventResponse = search04SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) { //Container verify
				eventResponse = search05SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) { //Off-Hire 일 경우 Node Code Search(MDM_YARD+MDM_LSE_CO_YD)
				eventResponse = searchNodCdForOffHire(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifySingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { //ESD_TRS_052
				eventResponse = modify01SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeSingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {//ESD_TRS_012 Delete
				eventResponse = removeEmptyRepoPlan(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //Create Insert
				eventResponse = multiSingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //Save (EQR_REPO_EXE_SO_IF INSERT)
				eventResponse = multi01SingleTransportationSOManage(e);	
			} else {
				eventResponse = null;
			}
		}
		
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search03SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.search03SingleTransportationSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;

	}

	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.searchSingleTransportationSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search01SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.search01SingleTransportationSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;

	}
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search02SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.search02SingleTransportationSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;

	}	

	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search04SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.search04SingleTransportationSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;

	}	

	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search05SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		 
		try {
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.search05SingleTransportationSOManage(sofficeCd,event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;

	}
	
	/**
	 * CHM-201327722 MT repo & EQ on/off-hire 메뉴 개선사항1
	 * 2013.11.21 by SHIN DONG IL
	 * ESD_TRS_0012
	 * Off-Hire일 경우 Node ComboBox 데이터 조회
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchNodCdForOffHire(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		String rtn_nod_cd ="";
		 
		try {
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			rtn_nod_cd = command.searchNodCdForOffHire(event);
			if(rtn_nod_cd.length() > 0){
				rtn_nod_cd = rtn_nod_cd.substring(0, rtn_nod_cd.length()-1);
			}
			eventResponse.setETCData("nod_cd", 	rtn_nod_cd);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;

	}

	
	/**
	 * 수정 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event)e;
		EventResponse eventResponse 	= null;
		try {
			begin();
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse=command.modifySingleTransportationSOManage(sofficeCd, event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}

	/**
	 * 수정 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modify01SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event)e;
		EventResponse eventResponse 	= null;
		try {
			begin();
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse=command.modify01SingleTransportationSOManage(sofficeCd, event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}

	/**
	 * 삭제 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 삭제 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeSingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event)e;
		EventResponse 				eventResponse 	= null;
		try {
			begin();
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse=command.removeSingleTransportationSOManage(sofficeCd, event);
			commit();
			
			//Spot Bidding Cancel Email 전송
			begin();
			SingleTransportationVO[] singleTransportationVOs = event.getSingleTransportationVOs();
			BiddingCandidateBC spotBidCommand =  new BiddingCandidateBCImpl();
			spotBidCommand.sendMailSpotBiddingCancel(singleTransportationVOs, account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @throws SQLException 
	 * @throws DAOException 
	 */
	public EventResponse multiSingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse 				eventResponse 	= null;
		DBRowSet dRs = null;
		DBRowSet dRs2 = null;

		String trs_seq = "";
		Collection<SingleTransportationVO> insModels =new ArrayList<SingleTransportationVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			begin();
			
			String cbstatus = event.getCbstatus();
			String ctrlOfcCd = event.getCtrlOfcCd();
			SingleTransportationVO[] stVos = event.getSingleTransportationVOs();
			HashMap hmSeq = new HashMap();
			
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			dRs = command.searchMultiSingleTransportationSo(e);
			if( dRs.next() ) {
				dRs.getString(1);
				throw new EventException(new ErrorHandler("TRS00100").getMessage());
				
			}
			
			if( cbstatus.equals("CF") ) { //COMBINED에 대한 처리구문.
				hmSeq = command.searchEmptyRepoCombineSeq(event);
			}
			
			for(int j=0;j<stVos.length;j++){
				if (stVos[j].getIbflag().length() > 0) {
					if (stVos[j].getIbflag().equals("I")) {

						String strOfc = "";
						if( String.valueOf(stVos[j].getTrspSoOfcCtyCd()).length() > 2 ) {
							strOfc = String.valueOf(stVos[j].getTrspSoOfcCtyCd()).substring(0,3);
						}else{
							strOfc = String.valueOf(stVos[j].getTrspSoOfcCtyCd());
						}
						stVos[j].setTrspSoOfcCtyCd(strOfc);
						dRs2 = command.searchEmptyRepoSeq();
						if(dRs2.next()) {
							trs_seq = dRs2.getString(1);
						}
						
						stVos[j].setTrspSoSeq(trs_seq);					
						if( cbstatus.equals("CF") ) {
							String cmbSeq = stVos[j].getTrspSoCmbSeq();
							stVos[j].setTrspSoCmbSeq(String.valueOf(hmSeq.get(cmbSeq.substring(0,1))));
							stVos[j].setTrspSoCmbSrtNo(cmbSeq);
						}
						insModels.add(stVos[j]);
					}
				}

			}

			param.put("cbstatus", event.getCbstatus());
			param.put("ctrl_ofc_cd", ctrlOfcCd);
			eventResponse = command.multiSingleTransportationSOManage5(insModels, param);				
			
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (SQLException se) {
			rollback();
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 * @throws SQLException 
	 * @throws DAOException 
	 */
	public EventResponse multi01SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event)e;
		
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		String rtn_ref_id ="";
		
		try {
			begin();
			
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			rtn_ref_id=command.multi01SingleTransportationSOManage(event,account);			
			
			commit();
			
			rtn_ref_id = rtn_ref_id.substring(0, rtn_ref_id.length()-1);
			eventResponse.setETCData("ref_id",rtn_ref_id);
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		
		return eventResponse;
	}
	
	/**
	 * ESD_TRS_0012: Row Delete
	 * CHM-201327803 Empty Repo & EQ On/Off Hire 개선 사항2
	 * Check된 복수개의 Row Delete
	 * 2013.11.27 by SHIN DONG IL
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 * @throws SQLException 
	 * @throws DAOException 
	 */
	public EventResponse removeEmptyRepoPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event)e;
		
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			begin();
			
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.removeEmptyRepoPlan(event);			
			
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		
		return eventResponse;
	}
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	/*
	public void emilSend(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			begin();
			ArrayList<BkgPkupNtcPkupNoVO> bkgPkupNtcNoVOS = new ArrayList();
			BkgPkupNtcPkupNoVO bpnpVo = new BkgPkupNtcPkupNoVO();
						
			bpnpVo.setBkgNo("BKKZ9240021");
			bpnpVo.setCntrNo("TCKU9044192");
			bpnpVo.setPkupYdCd("USCHIT1");
			bkgPkupNtcNoVOS.add(bpnpVo);
			BkgPkupNtcPkupNoVO bpnpVo1 = new BkgPkupNtcPkupNoVO();
			bpnpVo1.setBkgNo("BKKZ9240021");
			bpnpVo1.setCntrNo("TRLU6820452");
			bpnpVo1.setPkupYdCd("USCHIT1");
			bkgPkupNtcNoVOS.add(bpnpVo1);
			PreDispatchSentHistoryBC scommand = new PreDispatchSentHistoryBCImpl();
			scommand.searchPickupNoticeBasicManage(bkgPkupNtcNoVOS);
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		//return eventResponse;
	}
	*/
}