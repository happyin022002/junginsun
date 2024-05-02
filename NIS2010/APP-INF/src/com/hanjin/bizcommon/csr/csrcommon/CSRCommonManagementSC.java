/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CSRCommonManagementSC.java
 *@FileTitle : Approval File Upload & Comments
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.07.22
 *@LastModifier : 9014787
 *@LastVersion : 1.0
 * 2014.07.22 9014787
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
 * 
=========================================================*/

package com.hanjin.bizcommon.csr.csrcommon;

import java.util.List;

import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.basic.CSRApprovalCommonManagementBC;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.basic.CSRApprovalCommonManagementBCImpl;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.basic.CSRInvAgmtLnkBC;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.basic.CSRInvAgmtLnkBCImpl;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.event.ComCsr0016Event;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.event.ComCsr0020Event;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.event.ComCsr0023Event;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.integration.CSRApprovalCommonManagementDBDAO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.CSRApprovalCommonManagementVO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.SelComApFileVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * NIS2010-CSRCommonManagementSC Business Logic ServiceCommand - NIS2010-CSRCommonManagementSC 대한 비지니스 트랜잭션을 처리한다.
 * @author 9014787
 * @see CSRApprovalCommonManagementDBDAO
 * @see CSRFileManagementDBDAO
 * @since J2EE 1.6
 */

public class CSRCommonManagementSC extends ServiceCommandSupport {

    /**
     * CSRCommonManagement system 업무 시나리오 선행작업<br>
     * 업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
    	log.debug("CSRCommonManagementSC 시작");
    }

    /**
     * CSRCommonManagement system 업무 시나리오 마감작업<br>
     * 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        log.debug("CSRCommonManagementSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * NIS2010-CSRCommonManagement system 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
    	log.debug("[START:: CSRCommonManagementSC perform== e.getEventName() ]=========="+e.getEventName());

    	if (e.getEventName().equalsIgnoreCase("ComCsr0020Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchApprovalStepList(e);
        	}
        	
        	else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
				eventResponse = uploadDummyXterRqst(e);
			}
        }

    	// 20141029 ADD HS Jeon
    	else if (e.getEventName().equalsIgnoreCase("ComCsr0023Event")) {
			// GW Contract SEARCH
    		if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoice(e);
			}
    		
    		// Contract Search, Files Search
    		else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = search02ComApFileUpld(e);
			}

			// Contract MULTI
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiComApFileUpld(e);
			}
		}
        
    	else if (e.getEventName().equalsIgnoreCase("ComCsr0016Event")) {
			// Contract MULTI
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = saveCsrAproTpCd(e);
			}
		}
        return eventResponse;
    }
    
    
    /**
	 * COM_CSR_0020<br>
	 * Approval Step Comments List Search<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchApprovalStepList(Event e) throws EventException { //--
    	log.debug("[START:: CSRCommonManagementSC perform== e.searchApprovalStepList() ]=========="+e.getEventName());
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComCsr0020Event event = (ComCsr0020Event)e;
    	CSRApprovalCommonManagementBC command = new CSRApprovalCommonManagementBCImpl();
        try {
        	if(!"".equals(event.getApprovalComVO().getAproRqstNo())) {
	        	
        		CSRApprovalCommonManagementVO modifySiValAutoVO = event.getApprovalComVO();
				modifySiValAutoVO.setLoginUsrId(event.getSignOnUserAccount().getUsr_id());
			
        		List<CSRApprovalCommonManagementVO>  resultVOs = command.aproStepAndCmt(modifySiValAutoVO);
	        	eventResponse.setRsVoList(resultVOs);
        	} else {
        		throw new EventException("NO. does not exist for retrieval.");
        	}
        }catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval Step & Comments"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    
    /**
	 * COM_CSR_0020<br>
	 * Approval Step Comments Update<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse uploadDummyXterRqst(Event e) throws EventException {
    	log.debug("[START:: CSRCommonManagementSC perform== e.uploadDummyXterRqst() ]=========="+e.getEventName());
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		ComCsr0020Event event = (ComCsr0020Event)e;
		CSRApprovalCommonManagementBC command = new CSRApprovalCommonManagementBCImpl();

		try{
			begin();

			CSRApprovalCommonManagementVO csrAproComMgmtVO = event.getApprovalComVO();
			csrAproComMgmtVO.setLoginUsrId(event.getSignOnUserAccount().getUsr_id());
			command.commentSave(csrAproComMgmtVO) ;
			
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.toString(),ex); 
		}
		return eventResponse;
	}
    
    /**
	 * COM_CSR_0023<br>
	 * CSR Invoice Agreement Link<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchInvoice(Event e) throws EventException {

		log.debug("[START:: CSRCommonManagementSC perform== e.searchInvoice() ]=========="+e.getEventName());
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CSRInvAgmtLnkBC command = new CSRInvAgmtLnkBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		ComCsr0023Event event = (ComCsr0023Event)e;

		try{

			if(!"".equals(event.getComCsrRequestAgmtVO().getCsrNo())) {
			
				//2.로직 처리 실행
				List<ComCsrRequestAgmtVO> list = command.searchInvoice(event.getComCsrRequestAgmtVO());
	
				//3.로직 처리후 결과처리
				eventResponse.setRsVoList(list);
			
			} else {
        		throw new EventException("CSR No. does not exist for retrieval.");
        	}


		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
    
    /**
	 * COM_CSR_0023<br>
	 * CSR Invoice Agreement Link Search Contract or Files<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse search02ComApFileUpld(Event e) throws EventException {

		log.debug("[START:: CSRCommonManagementSC perform== e.search02ComApFileUpld() ]=========="+e.getEventName());
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CSRInvAgmtLnkBC command = new CSRInvAgmtLnkBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		ComCsr0023Event event = (ComCsr0023Event)e;

		try{

			if(!"".equals(event.getComCsrRequestAgmtVO().getCsrNo())) {
			
				//2.로직 처리 실행
				event.getCsrInvAgmtLnkInVO().setAccount(event.getSignOnUserAccount());
				List<SelComApFileVO> list = command.search02ComApFileUpld(event.getCsrInvAgmtLnkInVO());

				//3.로직 처리후 결과처리
				eventResponse.setRsVoList(list);
			
			} else {
        		throw new EventException("CSR No. does not exist for retrieval.");
        	}


		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
    
    /**
	 * COM_CSR_0023<br>
	 * CSR Invoice Agreement Link Multi Contract or Files<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse multiComApFileUpld(Event e) throws EventException {
    	log.debug("[START:: CSRCommonManagementSC perform== e.multiComApFileUpld() ]=========="+e.getEventName());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CSRInvAgmtLnkBC command = new CSRInvAgmtLnkBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		try{
			//2.로직 처리 실행
			begin();
			command.multiComApFileUpld(e);
			commit();

			//3.로직 처리후 결과처리
			eventResponse.setUserMessage(new ErrorHandler("CSR10003").getUserMessage());

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
    
    /**
   	 * COM_CSR_0016<br>
   	 * Save CSR Approval Type ALPS/GW<br>
   	 * @param e Event
   	 * @return response EventResponse
   	 * @exception EventException
   	 */
       private EventResponse saveCsrAproTpCd(Event e) throws EventException {
       	log.debug("[START:: CSRCommonManagementSC perform== e.saveCsrAproTpCd() ]=========="+e.getEventName());
   		GeneralEventResponse eventResponse = new GeneralEventResponse();
   		CSRApprovalCommonManagementBC command = new CSRApprovalCommonManagementBCImpl();
   		ComCsr0016Event event = (ComCsr0016Event)e;

   		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
   		try{
   			//2.로직 처리 실행
   			String csrNo = event != null?event.getCsrNo():""; 
   			String aproTpCd = event != null?event.getAproTpCd():""; 
   			
   			begin();
   			command.saveCsrAproTpCd(csrNo, aproTpCd);
   			commit();

   		}catch(EventException ex){
   			rollback();
   			throw ex;
   		}catch(Exception ex){
   			rollback();
   			throw new EventException(ex.getMessage(), ex);
   		}
   		log.debug("[END::]==========");
   		return eventResponse;
   	}
}
