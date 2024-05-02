/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceEdiHitRSC.java
*@FileTitle : HIT INVOICE EDI RECEIVE, PDF FILE ATTACH  & ACK 
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-24
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2016-06-24 SHIN DONG IL
* 1.0 최초생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.basic.InvoiceEdiHitBC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.basic.InvoiceEdiHitBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.event.RcvInvEdiHitEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiAckLogVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiRcvEqVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiRcvVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiErrLogVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Business Logic ServiceCommand
 * 비지니스 트랜잭션을 처리한다.
 * 
 * @author SHIN DONG IL
 * @see 각 DBDAO 참조
 * @since J2EE 1.6
 */
public class InvoiceEdiHitRSC extends ServiceCommandSupport {
	
	// Login User Information
    private SignOnUserAccount account = null;

    /**
     * BIZCOMMON 업무 시나리오 선행작업<br>
     * Vessel업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("InvoiceEdiHitRSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * BIZCOMMON 업무 시나리오 마감작업<br>
     * Vessel업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("InvoiceEdiHitRSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * ENIS-BIZCOMMON 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;

		if(e.getEventName().equalsIgnoreCase("RcvInvEdiHitEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = receiveInvoiceEdi(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				receiveInvoiceEdiPdfFile(e);
			}
	    }
        return eventResponse;
    }
    
	/**
	 * HIT Invoice EDI F/F 받아 TRS Invoice 생성 
	 * receiveInvoiceEdi
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse receiveInvoiceEdi(Event e) throws EventException {
		log.debug("\n>>>>>>>>>>>>> InvoiceEdiHitRSC.receiveInvoiceEdi() Start <<<<<<<<<<");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceEdiHitBC command = null;
		InvEdiRcvVO invEdiRcvVO = new InvEdiRcvVO();
		InvEdiAckLogVO invEdiAckLogVO = new InvEdiAckLogVO();
		String str = "";
		String ediRcvSeq = "";

		try {
			/**
			 * EDI 전문을 위한 임시 기본 ENTITY에 맞게 분해하여 입력.
			 */
			command = new InvoiceEdiHitBCImpl();
			
			str = ((RcvInvEdiHitEvent)e).getString();
			
			List<InvEdiRcvEqVO> invEdiRcvEqVOs = null;
			
			log.error("\n>>>>>>>>>>>>> HIT INVOICE EDI F/F Start  <<<<<<<<<<\n");
			log.error(str);
			log.error("\n>>>>>>>>>>>>> HIT INVOICE EDI F/F End    <<<<<<<<<<\n");
			/** 1.수신한 F/F의 항목들을 VO에 셋팅**/
			eventResponse = (GeneralEventResponse) command.getInvoiceEdiFf(str);
			invEdiRcvVO = (InvEdiRcvVO) eventResponse.getCustomData("invEdiRcvVO");
			invEdiRcvEqVOs = eventResponse.getRsVoList();
			/** 2.VO의 데이터를 EDI 수신 테이블에 DATA INSERT**/
			begin();
			ediRcvSeq = command.saveInvoiceEdi(invEdiRcvVO,invEdiRcvEqVOs);
			commit();
			
			/** 3.EDI 수신 테이블에 INSERT한 데이터에 대한 Validation check **/
			begin();
			command.validationInvEdi(ediRcvSeq);
			commit();
			/** 4. 본 테이블에 DATA SAVE(TRS_TRSP_INV_WRK, TRS_TRSP_SVC_ORD,TRS_TRSP_SO_HIS)**/
			begin();
			invEdiRcvVO.setInvEdiRcvSeq(ediRcvSeq);
			command.saveInvoice(invEdiRcvVO,invEdiRcvEqVOs);
			commit();
			/** 5. ACK LOG SAVE & ACK F/F SAVE **/
			begin();
			invEdiAckLogVO = command.makeInvoiceEdiAckFF(invEdiRcvVO);
			commit();
			/** 6.  ACK F/F SEND **/
			begin();
			command.sendInvEdiAck(invEdiRcvVO,invEdiAckLogVO);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error(ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		log.debug("\n>>>>>>>>>>>>> InvoiceEdiHitRSC.receiveInvoiceEdi() End <<<<<<<<<<");
		return eventResponse;
	}
	
	/**
	 * HIT Invoice EDI PDF File 수신
	 * @param e
	 * @exception EventException
	 */
	public void receiveInvoiceEdiPdfFile(Event e) throws EventException {
		log.debug("\n>>>>>>>>>>>>> InvoiceEdiHitRSC.receiveInvoiceEdiPdfFile() Start <<<<<<<<<<");
//		EventResponse eventResponse = null;
		InvoiceEdiHitBC command = new InvoiceEdiHitBCImpl();

		try {
			begin();
			command.receiveInvoicePdfFile(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error(ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		log.debug("\n>>>>>>>>>>>>> InvoiceEdiHitRSC.receiveInvoiceEdiPdfFile() End  <<<<<<<<<<");
//		return eventResponse;
	}

}
