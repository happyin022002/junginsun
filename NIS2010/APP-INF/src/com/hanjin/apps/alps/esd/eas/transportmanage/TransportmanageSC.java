/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TransportmanageSC.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.transportmanage.basic.CHAuditTroArmanageBC;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.CHAuditTroArmanageBCImpl;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.CnlBKGCntrmanageBC;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.CnlBKGCntrmanageBCImpl;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.DOFChgColInqmanageBC;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.DOFChgColInqmanageBCImpl;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.DOFChgColPermanageBC;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.DOFChgColPermanageBCImpl;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.DOFChgTrfmanageBC;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.DOFChgTrfmanageBCImpl;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.MSCCheckmanageBC;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.MSCCheckmanageBCImpl;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.ROUTUnMatmanageBC;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.ROUTUnMatmanageBCImpl;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.SpecialSOCheckBC;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.SpecialSOCheckBCImpl;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0003Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0004Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0005Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0006Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0008Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0009Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.basic.OCPChgColmanageBC;
import com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.basic.OCPChgColmanageBCImpl;
import com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.event.EsdEas0010Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.vo.SearchOCPChgListVO;
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
 * @author yujin
 * @see ServiceCommandSupport 참조
 * @since J2EE 1.4
 */
public class TransportmanageSC extends ServiceCommandSupport {

	
    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * EAS 업무 시나리오 선행작업<br>
     * TransportmanageSC업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("TransportmanageSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * EAS 업무 시나리오 마감작업<br>
     * TransportmanageSC업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("TransportmanageSC 종료");
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

        if (e.getEventName().equalsIgnoreCase("EsdEas0004Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
                eventResponse = searchChAuditList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { 
                eventResponse = searchChAuditBKGList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { //Sub-Office
    			eventResponse = searchSubOfficeList(e);
    		} 

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0005Event")) {

        	if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
                eventResponse = searchCnlBKGCntrList(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("ESD_EAS_0903Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRoutUnMatBlInforDetail(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRoutUnMatSoInforDetail(e);
            }

        } /*else if (e.getEventName().equalsIgnoreCase("ESD_EAS_0902Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//2011.07.13 이정수 R4J소스품질 위배 및 미사용으로 인해 주석처리함   	
//                eventResponse = searchExpnAudRmk(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
//2011.07.13 이정수 R4J소스품질 위배 및 미사용으로 인해 주석처리함            	
//                eventResponse = multiExpnAudRmk(e);
            }

        }*/ else if (e.getEventName().equalsIgnoreCase("EsdEas0002Event")) {
        	//Route UnMatch List
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
                eventResponse = searchRoutUnMatList(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0007Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
                eventResponse = searchDofChgTrfList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
                eventResponse = searchEffDT(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = multiDofChgTrf(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchEUROffcd(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchDofChgDupCnt(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = verifyLocCd(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = verifyCustCd(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = verifyTpSz(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
                eventResponse = verifyCurr(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0008Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
                eventResponse = searchDofChgColList(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0009Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
                eventResponse = searchDofChgColPerList(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0006Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
                eventResponse = searchMSCList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { //Sub-Office
    			eventResponse = searchSubOfcList(e);
    		}

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0003Event")) {
        	//Special S/O of Transport
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpecialSOCheckList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOtherSOCheckList(e);
			}

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0010Event")) {
        	//Special S/O of Transport
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOcpChgList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiOcpChgList(e);
				//-------------------				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLocation(e);
				//-------------------					
			}	
			
		}else {
			eventResponse = null;
		}
        		
		return eventResponse;
	}

	/**
	 * C/H Audit 조회
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchChAuditList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0004Event event = (EsdEas0004Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	CHAuditTroArmanageBC command = new CHAuditTroArmanageBCImpl();
            eventResponse = command.searchChAuditList(event);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

	/**
	 * BKG 단위의 C/H Audit Detail 조회
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchChAuditBKGList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0004Event event = (EsdEas0004Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	CHAuditTroArmanageBC command = new CHAuditTroArmanageBCImpl();
            eventResponse = command.searchChAuditBKGList(event);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

//2011.07.13 이정수 R4J소스품질 위배 및 미사용으로 인해 주석처리함   	    
	/**
	 * Expense Audit Remark 조회
	 * @param e 
	 * @return
	 * @throws EventException
	 */
/*    private EventResponse searchExpnAudRmk(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	ROUTUnMatmanageBC command = new ROUTUnMatmanageBCImpl();
            eventResponse = command.searchExpnAudRmk(e);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }*/

//2011.07.13 이정수 R4J소스품질 위배 및 미사용으로 인해 주석처리함          
    /**
	 * Expense Audit Remark 추가/수정
	 * @param e 
	 * @return
	 * @throws EventException
	 */
/*    private EventResponse multiExpnAudRmk(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        try {
        	begin();
            
        	ROUTUnMatmanageBC command = new ROUTUnMatmanageBCImpl();
            eventResponse = command.multiExpnAudRmk(e);
            
            commit();
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }*/
    
    /**
	 * Route Unmatch List Search
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchRoutUnMatList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	ROUTUnMatmanageBC command = new ROUTUnMatmanageBCImpl();
            eventResponse = command.searchRoutUnMatList(e);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

	/**
	 * Drop off charge tariff list search
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchDofChgTrfList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
            eventResponse = command.searchDofChgTrfList(e);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * 선택된 Customer 정보로 Effect date List Search
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchEffDT(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
            eventResponse = command.searchEffDT(e);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
	 * Drop off charge collection Inquery List Search
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchDofChgColList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0008Event event = (EsdEas0008Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	DOFChgColInqmanageBC command = new DOFChgColInqmanageBCImpl();
            eventResponse = command.searchDofChgColList(event);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
	/**
	 *  Drop off charge collection preperence List Search
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchDofChgColPerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0009Event event = (EsdEas0009Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	DOFChgColPermanageBC command = new DOFChgColPermanageBCImpl();
            eventResponse = command.searchDofChgColPerList(event);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
	/**
	 * Canceled BKG Cntr List Search.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchCnlBKGCntrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0005Event event = (EsdEas0005Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;

        try {
        	CnlBKGCntrmanageBC command = new CnlBKGCntrmanageBCImpl();
            eventResponse = command.searchCnlBKGCntrList(event);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
	/**
	 * Route Unmatch BL Info 기준 Search List
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchRoutUnMatBlInforDetail(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	ROUTUnMatmanageBC command = new ROUTUnMatmanageBCImpl();
            eventResponse = command.searchRoutUnMatBlInforDetail(e);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

	/**
	 * Route Unmatch SO Info 기준 Search List
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchRoutUnMatSoInforDetail(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	ROUTUnMatmanageBC command = new ROUTUnMatmanageBCImpl();
            eventResponse = command.searchRoutUnMatSoInforDetail(e);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

	/**
	 * MSC 금액 Check List Search 
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchMSCList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0006Event event = (EsdEas0006Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
        
        try {
        	MSCCheckmanageBC command = new MSCCheckmanageBCImpl();
            eventResponse = command.searchMSCList(event);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

	/**
	 * Special SO Search List
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSpecialSOCheckList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0003Event event = (EsdEas0003Event)e;
		
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			SpecialSOCheckBC command = new SpecialSOCheckBCImpl();
			eventResponse = command.searchSpecialSOCheckList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Other SO Search List
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOtherSOCheckList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0003Event event = (EsdEas0003Event)e;
		
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			SpecialSOCheckBC command = new SpecialSOCheckBCImpl();
			eventResponse = command.searchOtherSOCheckList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * User가 선택한 Office의 모든 하위 Office를 선택하는 Function
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSubOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0004Event event = (EsdEas0004Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			CHAuditTroArmanageBC command = new CHAuditTroArmanageBCImpl();
			eventResponse = command.searchSubOfficeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}    

	/**
	 * User가 선택한 Office의 하위 Office를 선택하는 Function
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSubOfcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0006Event event = (EsdEas0006Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			MSCCheckmanageBC command = new MSCCheckmanageBCImpl();
			eventResponse = command.searchSubOfcList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}   

	/**
	 * Drop Off Charge Tariff 등록/수정/삭제시 IBLSheet에서 발생한 Event를 받아 작업을 하는 Function.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiDofChgTrf(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		
		EventResponse eventResponse = null;
		try {
			begin();
			
			DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
			eventResponse = command.multiDofChgTrf(e);

			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}   

	/**
	 * 유럽지역의 Office만을 찾아오는 Function.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchEUROffcd(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
			eventResponse = command.searchEUROffcd(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	} 
	
	/**
	 * searchDofChgDupCnt 중복 갯수 조회 기능.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchDofChgDupCnt(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
			eventResponse = command.searchDofChgDupCnt(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * verifyLocCd 입력된 loc_cd의 MDM내 존재여부 확인.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse verifyLocCd(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
			eventResponse = command.verifyLocCd(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	} 
	
	/**
	 * verifyCustCd 입력된 cust_cd의 MDM내 존재여부 확인.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse verifyCustCd(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
			eventResponse = command.verifyCustCd(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * verifyTpSz 입력된 tpsz_cd의 MDM내 존재여부 확인.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse verifyTpSz(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
			eventResponse = command.verifyTpSz(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * verifyCurr 입력된 curr_cd의 MDM내 존재여부 확인.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse verifyCurr(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
			eventResponse = command.verifyCurr(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * ocp charge collectio list 화면에 입력된 조건으로 조회.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	
	private EventResponse searchOcpChgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0010Event event = (EsdEas0010Event)e;
		OCPChgColmanageBC command = new OCPChgColmanageBCImpl();

		try{
			List<SearchOCPChgListVO> list = command.searchOcpChgList(event.getSearchOCPChgListVo());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ocp charge collectio list 화면에 입력된 조건으로 저장.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	
	private EventResponse multiOcpChgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0010Event event = (EsdEas0010Event)e;
		OCPChgColmanageBC command = new OCPChgColmanageBCImpl();
		try{
			begin();
			command.multiOcpChgList(event.getSearchOCPChgListVos(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
 
	/* 		
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
//		EsdEas0010Event event = (EsdEas0010Event)e;
		OCPChgColmanageBC command = new OCPChgColmanageBCImpl();
		
		String locLevel = (String) e.getAttribute("inquirylevel");
		String locCD = (String) e.getAttribute("location");
		String check = command.checkLocation(locLevel, locCD);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("check", check);

		eventResponse.setETCData(etcData);
		return eventResponse;
	}	
}
