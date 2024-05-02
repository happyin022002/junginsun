/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRCommonSC.java
*@FileTitle : 공통유틸
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.10.15 함대성
* 1.0 Creation
*--------------------------------------------------------
*History
* 2011.01.06 김영철 [] R4J 에서 Console의 메시지를 점검한다. 
*                   ( ex.printStackTrace(); -> log.error("err"+ex.toString(),ex); )
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon;

import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse; 
import com.hanjin.framework.core.layer.event.GeneralEventResponse; 
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount; 
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBC;
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBCImpl;
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.event.CsrComExternalEvent;
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.vo.SpCsrVO;

 
/**
 * NIS2010-CSRCommonSC Business Logic ServiceCommand - NIS2010-CSRCommonSC 대한 비지니스 트랜잭션을 처리한다.
 * @author daesung ham.
 * @see SCGExternalFinderDBDAO
 * @since J2EE 1.4
 */

public class CSRCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount signOnUserAccount = null;
	 
	/**
	 * CSRCommonSC system 업무 시나리오 선행작업<br>
	 * COM_CSR_업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
 
			// 일단 comment --> 로그인 체크 부분
			signOnUserAccount = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CSRCommonSC system 업무 시나리오 마감작업<br>
	 * COM_CSR_ 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CSRCommonSCSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-CSRCommonSC system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("CsrComExternalEvent")) {
			// Service Provider Detail Information 공통필요성
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				 eventResponse = checkVendor(e);     
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				 eventResponse = getDBdate(e);     
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				 eventResponse = getMDMCntCd(e);     
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createApPayInvInfo(e);
			}
		}

		return eventResponse;
	}
	
	/**
	 * CSR_0001 : 공통<br>
	 * vendor체크 조회 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVendor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try{
			CsrComExternalEvent event = (CsrComExternalEvent)e;
			CSRExternalFinderBC command = new CSRExternalFinderBCImpl(); 
			
			SpCsrVO spCsrVO = event.getSpCsrVO();
			String vndrSeq = spCsrVO.getVndrSeq();
			
			spCsrVO = command.checkVendor(vndrSeq);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();    
			
			if(spCsrVO != null){
				Map<String, String> mapVO = spCsrVO.getColumnValues();
				eventResponse.setETCData(mapVO);
			}
			return eventResponse;
		}catch (EventException ex) {
//            ex.printStackTrace();
			log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
			log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}
	
	/**
	 * CSR_0008 : 공통<br>
	 * 권한 로케이션 날짜 조회 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getDBdate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try{
			CsrComExternalEvent event = (CsrComExternalEvent)e;
			CSRExternalFinderBC command = new CSRExternalFinderBCImpl(); 
			
			SpCsrVO spCsrVO = event.getSpCsrVO();
			String ofcCd = spCsrVO.getOfcCd();
			
			spCsrVO = command.getDBdate(ofcCd);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();    
			
			if(spCsrVO != null){
				Map<String, String> mapVO = spCsrVO.getColumnValues();
				eventResponse.setETCData(mapVO);
			}
			return eventResponse;
		}catch (EventException ex) {
//            ex.printStackTrace();
			log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
			log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}
	
	/**
	 * CSR_0002 : 공통<br>
	 * getMDMCntCd<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getMDMCntCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try{
			CsrComExternalEvent event = (CsrComExternalEvent)e;
			CSRExternalFinderBC command = new CSRExternalFinderBCImpl(); 
			
			SpCsrVO spCsrVO = event.getSpCsrVO();
			String ofcCd = spCsrVO.getOfcCd();
			
			String cntCd = command.getMDMCntCd(ofcCd);
			
			spCsrVO.setCntCd(cntCd);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();    
			
			if(spCsrVO != null){
				Map<String, String> mapVO = spCsrVO.getColumnValues();
				eventResponse.setETCData(mapVO);
			}
			return eventResponse;
		}catch (EventException ex) {
//            ex.printStackTrace();
			log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
			log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}
	
	/**
	 * AP연계 인터페이스 : 공통
	 * AP_PAY_INV 및 AP_PAY_INV_DTL 목록 저장<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createApPayInvInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CsrComExternalEvent event = (CsrComExternalEvent)e;
		CSRExternalFinderBC command = new CSRExternalFinderBCImpl();
		
		try{
			begin();
			command.createApPayInvInfo(event.getApPayInvVO(),event.getApPayInvDtlVOs(),signOnUserAccount);
			eventResponse.setUserMessage(new ErrorHandler("CSR10003").getUserMessage());
			commit();
			
			return eventResponse;
		}catch (EventException ex) {
//            ex.printStackTrace();
			log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
			log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
		
	}
 
}