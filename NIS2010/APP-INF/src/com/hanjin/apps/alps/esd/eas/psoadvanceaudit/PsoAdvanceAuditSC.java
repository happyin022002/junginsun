/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : PsoAdvanceAuditSC.java
*@FileTitle : Port (Service) Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-05
*@LastModifier : Do-Hyun Kim
*@LastVersion : 1.0
* 2014-12-05 Do-Hyun Kim
* 1.0 최초 생성
* 2016.03.25 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청

=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit;

import java.util.List;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.basic.PsoAdvanceAuditBC;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.basic.PsoAdvanceAuditBCImpl;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event.EsdEas0301Event;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event.EsdEas0303Event;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditBatchVO;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditCreSetVO;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * TransportmanageSC PDTO(Data Transfer Object including Parameters)<br>
 * @author Do-Hyun Kim
 * @see ServiceCommandSupport 참조
 * @since J2EE 1.4
 */
public class PsoAdvanceAuditSC extends ServiceCommandSupport {

	
    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * EAS 업무 시나리오 선행작업<br>
     * Psoadvanceaudit업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("Psoadvanceaudit 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * EAS 업무 시나리오 마감작업<br>
     * Psoadvanceaudit업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("Psoadvanceaudit 종료");
    }

	/**
	 * 조회 이벤트 처리<br>
	 * Transportmanage event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

        EventResponse eventResponse = null;
       
        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
	    if (e.getEventName().equalsIgnoreCase("EsdEas0301Event")) {
	    	//Port (Service) Charge
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchPreAuditList2(e);
//	            eventResponse = searchPreAuditList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	            eventResponse = searchPreAuditList2(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { //EDS_EAS_0301 - Confirm
				eventResponse = modifyAutoAuditFlg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//EDS_EAS_0301 - Account Code
				eventResponse = searchAuditFlgAccount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//EDS_EAS_0301 - Cost Code
				eventResponse = searchAuditFlgCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {//EDS_EAS_0301 - S/P name
				eventResponse = searchAuditFlgSpName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {//EDS_EAS_0301 - Vessel Class
				eventResponse = searchAuditFlgVslClass(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {//EDS_EAS_0301 - Vessel
				eventResponse = searchAuditFlgVslClassVessel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {//EDS_EAS_0301 - CANAL Charge Type 
				eventResponse = searchChargeTypeComboFlag(e);
	        } else if(e.getFormCommand().isCommand(FormCommand.MODIFY03)) {//EDS_EAS_0301
				eventResponse = saveReBatchTarget(e);
			}	
	    } else if (e.getEventName().equalsIgnoreCase("EsdEas0302Event")) {
	    	//Port (Service) Charge History
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchPreAuditHistoryList(e);
	        }	
			
		} else if (e.getEventName().equalsIgnoreCase("EsdEas0303Event")) {
	    	//Port (Service) Charge History
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	            eventResponse = searchPsoConfig(e);
	        }else  if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
	        	eventResponse = multiPsoConfig(e);
	        }	
			
		}else {
			eventResponse = null;
		}
        		
		return eventResponse;
	}
    
//    /**
//	 * Port (Service) Charge 조회.
//	 * 
//	 * @param e Event
//	 * @return response EventResponse
//	 * @exception EventException
//	 */
//    private EventResponse searchPreAuditList(Event e) throws EventException {
//        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
//        EventResponse eventResponse = null;
//        try {
//        	PsoAdvanceAuditBC command = new PsoAdvanceAuditBCImpl();
//            eventResponse = command.searchPreAuditList(e);
//            
//        } catch (EventException de) {
//            log.error("err " + de.toString(), de);
//            throw new EventException(de.getMessage());
//        }
//        return eventResponse;
//    }
    
    /**
	 * Port (Service) Charge 조회.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchPreAuditList2(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        try {

        	PsoAdvanceAuditBC command = new PsoAdvanceAuditBCImpl();
            eventResponse = command.searchPreAuditList2(e);
            
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

	/**
	 * 멀티 이벤트 처리<br>
	 * Port (Service) Charge - Confirm - DB에 반영한다.(변경)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyAutoAuditFlg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0301Event event = (EsdEas0301Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			PsoAdvanceAuditBC command = new PsoAdvanceAuditBCImpl();
			command.modifyAutoAuditFlg(event, account);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    
	/**
	 * EDS_EAS_0301 : OPEN
	 * Port (Service) Charge에 관련 Account를 조회한다.
	 * @category EDS_EAS_0301_Open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAuditFlgAccount(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PsoAdvanceAuditBC command = new PsoAdvanceAuditBCImpl();

			List<PreAuditListVO> list = command.searchAuditFlgAccount(e);
			StringBuffer data = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				data.append(list.get(i).getAcctCd());
				data.append("↕");
				data.append(list.get(i).getAcctNm());

				if (i < list.size()-1){
					data.append("↔");
				}	
			}
			eventResponse.setETCData("account", data.toString());
			eventResponse.setRsVoList(list);
		} catch(EventException ex){
			throw ex;
		} catch(Exception de) {
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * EDS_EAS_0301 : OPEN
	 * Port (Service) Charge에 관련 Cost를 조회한다.
	 * @category EDS_EAS_0301_Open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAuditFlgCost(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PsoAdvanceAuditBC command = new PsoAdvanceAuditBCImpl();

			List<PreAuditListVO> list = command.searchAuditFlgCost(e);
			StringBuffer data = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				data.append(list.get(i).getCostCd());
				data.append("↕");
				data.append(list.get(i).getCostNm());

				if (i < list.size()-1){
					data.append("↔");
				}	
			}
			eventResponse.setETCData("cost", data.toString());
			eventResponse.setRsVoList(list);
		} catch(EventException ex){
			throw ex;
		} catch(Exception de) {
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**VOP_PSO_0002 : Port Code 변경시(Key-In)
	 * VOP_PSO_0002에서 Port 정보를 조회한다.
	 * @category VOP_PSO_0002_PortCode_Key-In
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAuditFlgSpName(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PsoAdvanceAuditBC command = new PsoAdvanceAuditBCImpl();
			String spname = command.searchAuditFlgSpName(e);
			eventResponse.setETCData("spname", spname);
		} catch(EventException ex){
			throw ex;
		} catch(Exception de) {
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EDS_EAS_0301 : OPEN
	 * Port (Service) Charge에 관련 VesselClass를 조회한다.
	 * @category EDS_EAS_0301_Open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAuditFlgVslClass(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PsoAdvanceAuditBC command = new PsoAdvanceAuditBCImpl();

			List<PreAuditListVO> list = command.searchAuditFlgVslClass(e);
			StringBuffer data = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				data.append(list.get(i).getCntrVslClssCapa());
				data.append("↕");
				data.append("");
//				data.append(list.get(i).getCostNm());

				if (i < list.size()-1){
					data.append("↔");
				}	
			}

			eventResponse.setETCData("vslClasss", data.toString());
			eventResponse.setRsVoList(list);
		} catch(EventException ex){
			throw ex;
		} catch(Exception de) {
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * EDS_EAS_0301 : OPEN
	 * Port (Service) Charge에 관련 VesselClass관련 Vessel를 조회한다.
	 * @category EDS_EAS_0301_Open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAuditFlgVslClassVessel(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PsoAdvanceAuditBC command = new PsoAdvanceAuditBCImpl();

			List<PreAuditListVO> list = command.searchAuditFlgVslClassVessel(e);
			StringBuffer data = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				data.append(list.get(i).getVslCd());
				data.append("↕");
				data.append(list.get(i).getVslNm());

				if (i < list.size()-1){
					data.append("↔");
				}	
			}

			eventResponse.setETCData("vslClasssVessel", data.toString());
			eventResponse.setRsVoList(list);
		} catch(EventException ex){
			throw ex;
		} catch(Exception de) {
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
    
    /**
	 * Port (Service) Charge History 조회.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchPreAuditHistoryList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        try {
        	PsoAdvanceAuditBC command = new PsoAdvanceAuditBCImpl();
            eventResponse = command.searchPreAuditHistoryList(e);
            
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * Pre-Audit Criterion setting 내역을 조회한다.
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchPsoConfig(Event e) throws EventException {
		try{
			EsdEas0303Event event = (EsdEas0303Event)e;
			PsoAdvanceAuditBC command = new PsoAdvanceAuditBCImpl();
			List<PreAuditCreSetVO> list = command.searchPsoConfig(event.getPreAuditCreSetVO(),account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchVndrCntc"}).getMessage(), ex);
		}
    }
    
    /**
     * Pre-Audit Criterion setting 내역을 저장한다.
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse multiPsoConfig(Event e) throws EventException {
		EsdEas0303Event event = (EsdEas0303Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PsoAdvanceAuditBC command = new PsoAdvanceAuditBCImpl();
		try{
			begin();
			command.multiPsoConfig(event.getPreAuditCreSetVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"multiVndrCntc"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EDS_EAS_0301 : OPEN
	 * Port (Service) Charge에 관련 CANAL Charge Type을 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchChargeTypeComboFlag(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{

			EsdEas0301Event event = (EsdEas0301Event)e;
			String portlChargeType = "";
			String serviceChargeType = "";
			String canalChargeType = "";
			String otherChargeType = "";
			PsoAdvanceAuditBC command = new PsoAdvanceAuditBCImpl();
			PreAuditCreSetVO preAuditCreSetVO = new PreAuditCreSetVO();
			preAuditCreSetVO.setSAudOfcCd(event.getRhq());
			
			event.setPreAuditCreSetVO(preAuditCreSetVO);
			List<PreAuditCreSetVO> list = command.searchPsoConfig(event.getPreAuditCreSetVO(),account);
			
			for (int i = 0; i < list.size(); i++) {
				if("PORT CHARGE".equals(list.get(i).getChgTpNm())){
					if("Y".equals(list.get(i).getLgsCostAudFlg())){
						portlChargeType = "5117";
					}
				}else if("PORT SERVICE CHARGE".equals(list.get(i).getChgTpNm())){
					if("Y".equals(list.get(i).getLgsCostAudFlg())){
						serviceChargeType = "5118";
					}
				}else if("CANAL TRANSIT FEE".equals(list.get(i).getChgTpNm())){
					if("Y".equals(list.get(i).getLgsCostAudFlg())){
						canalChargeType = "5119";
					}
				}else if("OTHER".equals(list.get(i).getChgTpNm())){
					if("Y".equals(list.get(i).getLgsCostAudFlg())){
						otherChargeType = "564611";
					}
				}
			}
			eventResponse.setETCData("portlChargeType", portlChargeType);
			eventResponse.setETCData("serviceChargeType", serviceChargeType);
			eventResponse.setETCData("canalChargeType", canalChargeType);
			eventResponse.setETCData("otherChargeType", otherChargeType);
			
		} catch(EventException ex){
			throw ex;
		} catch(Exception de) {
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * EsdEas0301Event  <br>
	 * 실시간 배치 대상을 저장한다.
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse saveReBatchTarget(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0301Event event = (EsdEas0301Event) e;
		
		PsoAdvanceAuditBC command = new PsoAdvanceAuditBCImpl();
		
		try{
			begin();
			PreAuditBatchVO[] voList = event.getPreAuditBatchVOs();
			for(int i=0;i<voList.length;i++){
				voList[i].setCreUsrId(account.getUsr_id());
				voList[i].setUpdUsrId(account.getUsr_id());
				voList[i].setCreOfcCd(account.getOfc_cd());
			}
			command.saveReBatchTarget(voList);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"saveReBatchTarget"}).getMessage(), ex);
		}
		
	}

}
