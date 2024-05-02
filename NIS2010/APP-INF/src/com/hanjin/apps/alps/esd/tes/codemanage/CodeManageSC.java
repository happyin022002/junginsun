/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeManageSC.java
*@FileTitle : Cost Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-07
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-07 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.codemanage;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.esd.tes.codemanage.codemanage.event.EsdTes0027Event;
import com.hanjin.apps.alps.esd.tes.codemanage.codemanage.event.EsdTes9090Event;
import com.hanjin.apps.alps.esd.tes.codemanage.codemanage.event.EsdTes0028Event;
import com.hanjin.apps.alps.esd.tes.codemanage.codemanage.event.EsdTes0031Event;
import com.hanjin.apps.alps.esd.tes.codemanage.codemanage.basic.CodeManageBC;
import com.hanjin.apps.alps.esd.tes.codemanage.codemanage.basic.CodeManageBCImpl;
import com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.basic.ServiceProviderManageBC;
import com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.basic.ServiceProviderManageBCImpl;
import com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.event.EsdTes0032Event;

/**
 * ENIS-ESD Business Logic ServiceCommand<br>
 * - ENIS-ESD에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author jongbaemoon
 * @see CodeManageDBDAO 참조
 * @since J2EE 1.6
 */
public class CodeManageSC extends ServiceCommandSupport {
	// Login User Information
//	private SignOnUserAccount account = null;

	/**
	 * ESD 업무 시나리오 선행작업<br>
	 * CodeManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
	}

	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * CodeManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("CodeManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ENIS-ESD 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		log.debug("CodeManageSC :: " + e.getEventName());

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTes0027Event")) {			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCostCodeInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {				
				eventResponse = createCostCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {				
				eventResponse = modifyCostCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {				
				eventResponse = modifyCostCodeDelete(e);								
			} else {
				eventResponse = searchAcctCodeList();
			}
		}
		
		// SC가 하나의 이벤트만 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTes0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCostCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
				eventResponse = searchCostcdOption(e);
			// ESD_EAS_3020 CostCode 조회 옵션 콤보용 - 2015-02-26
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {		
				eventResponse = searchCostcdDetail(e);				
			} else {
				//eventResponse = searchCostCode(e);
			}			
			//eventResponse = searchCostCode(e);
		}		
		
		// SC가 하나의 이벤트만 처리하는 경우 사용해야 할 부분
		// Agreement User Password Check
		if (e.getEventName().equalsIgnoreCase("EsdTes9090Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = checkMandatory(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
				eventResponse = checkAgreementPassWord(e);
			}  			
		}
		
        // EsdTes0031Event 처리
        if (e.getEventName().equalsIgnoreCase("EsdTes0031Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCarrierCode(e);
//            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//                eventResponse = multiCarrierCode(e);
            } else {
            	eventResponse = searchCarrierCode(e);
            }
        }		
        
        if (e.getEventName().equalsIgnoreCase("EsdTes0032Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchMdmVendorInfo(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchMdmVendorIndiaInfo(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
        		eventResponse = modifyMdmVendorIndiaInfo(e);
        	}
        }

		return eventResponse;
	}

	
	private EventResponse searchAcctCodeList() throws EventException {	
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			CodeManageBC command = new CodeManageBCImpl();
			eventResponse = command.searchAcctCodeList();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CodeManage cost code의 event에 대한 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0028Event event = (EsdTes0028Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			CodeManageBC command = new CodeManageBCImpl();
			eventResponse = command.searchCostCode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CodeManage cost code의 event에 대한 특정 정보 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCodeInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0027Event event = (EsdTes0027Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			CodeManageBC command = new CodeManageBCImpl();
			eventResponse = command.searchCostCodeInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CodeManage user의 event에 대한 특정 정보 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkMandatory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9090Event event = (EsdTes9090Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			CodeManageBC command = new CodeManageBCImpl();
			eventResponse = command.checkMandatory(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CodeManage user의 event에 대한 특정 정보 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkAgreementPassWord(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9090Event event = (EsdTes9090Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			CodeManageBC command = new CodeManageBCImpl();
			eventResponse = command.checkAgreementPassWord(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * 추가, 수정, 삭제 이벤트 처리<br>
	 * CodeManage cost code의 event에 대한 추가, 수정, 삭제 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0027Event event = (EsdTes0027Event)e;

		try {
			begin();
			CodeManageBC command = new CodeManageBCImpl();
			command.createCostCode(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return this.searchCostCodeInfo(e);
	}	
	
	/**
	 * 추가, 수정, 삭제 이벤트 처리<br>
	 * CodeManage cost code의 event에 대한 추가, 수정, 삭제 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0027Event event = (EsdTes0027Event)e;

		try {
			begin();
			CodeManageBC command = new CodeManageBCImpl();
			command.modifyCostCode(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return this.searchCostCodeInfo(e);
	}
	
	/**
	 * 추가, 수정, 삭제 이벤트 처리<br>
	 * CodeManage cost code의 event에 대한 추가, 수정, 삭제 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCostCodeDelete(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0027Event event = (EsdTes0027Event)e;

		try {
			begin();
			CodeManageBC command = new CodeManageBCImpl();
			command.modifyCostCodeDelete(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
//		return this.searchCostCodeInfo(e);
		return null;
	}	
	
	   /**
     * 조회 이벤트 처리<br>
     * CodeManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCarrierCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsdTes0031Event event = (EsdTes0031Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
            CodeManageBC command = new CodeManageBCImpl();
            eventResponse = command.searchCarrierCode(event);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

//    /**
//     * 멀티 이벤트 처리<br>
//     * CodeManage의 event에 대한 멀티 이벤트 처리<br>
//     * 
//     * @param e Event
//     * @return response EventResponse
//     * @exception EventException
//     */
//    public EventResponse multiCarrierCode(Event e) throws EventException {
//        // PDTO(Data Transfer Object including Parameters)
//        //EsdTes031Event event = (EsdTes031Event)e;
//        //사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
//        //EventResponse eventResponse = null;
//
//        try {
//            begin();
//            CodeManageBC command = new CodeManageBCImpl();
//            command.multiCarrierCode(e);
//            commit();
//        } catch (EventException de) {
//            rollback();
//            log.error("err " + de.toString(), de);
//            throw new EventException(de.getMessage());
//        }
//        
//        return this.searchCarrierCode(e);
//    }	
    
    /**
     * 조회 이벤트 처리<br>
     * ESD_SCE_013의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCostcdOption(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsdTes0028Event event = (EsdTes0028Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	CodeManageBC command = new CodeManageBCImpl();
            eventResponse = command.searchCostcdOption(event);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * ESD_EAS_3210의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCostcdDetail(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	EsdTes0028Event event = (EsdTes0028Event)e;
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	EventResponse eventResponse = null;
    	
    	try {
    		CodeManageBC command = new CodeManageBCImpl();
    		eventResponse = command.searchCostcdDetail(event);
    	} catch (EventException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(de.getMessage());
    	}
    	return eventResponse;
    }
    
    /**
	 * MDM VENDOR INFO
	 * 
	 * @param e
	 * @return eventResponse
	 * @throws EventException
	 */
    private EventResponse searchMdmVendorInfo(Event e) throws EventException {	
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTes0032Event event = (EsdTes0032Event)e;
		
		try {
			ServiceProviderManageBC command = new ServiceProviderManageBCImpl();			
			eventResponse = command.searchMdmVendorInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
    
    /**
	 * MDM VENDOR INDIA INFO
	 * 
	 * @param e
	 * @return eventResponse
	 * @throws EventException
	 */
    private EventResponse searchMdmVendorIndiaInfo(Event e) throws EventException {	
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTes0032Event event = (EsdTes0032Event)e;
		
		try {
			ServiceProviderManageBC command = new ServiceProviderManageBCImpl();			
			eventResponse = command.searchMdmVendorIndiaInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    
    /**
	 * Modify MDM VENDOR INDIA INFO
	 * 
	 * @param e
	 * @return eventResponse
	 * @throws EventException
	 */
    private EventResponse modifyMdmVendorIndiaInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsdTes0032Event event = (EsdTes0032Event)e;

		try {
			begin();
			ServiceProviderManageBC command = new ServiceProviderManageBCImpl();			
			command.modifyMdmVendorIndiaInfo(event);
			commit();
						
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return this.searchMdmVendorIndiaInfo(event);
	}
       
}


