/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfStowageMgtSC.java
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.03
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.06.03 김도현
* 1.0 Creation
*=========================================================
* History
*=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfstowagemgt;


import java.util.List;
import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.event.Fns012R001Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ERPIfReturnVO;
import com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.basic.OpfStowageMgtBC;
import com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.basic.OpfStowageMgtBCImpl;
import com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.event.VopOpf9501Event;
import com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.integration.OpfStowageMgtDBDAO;
import com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.vo.OpfStowageBayPlanListVO;
import com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.vo.BayPlanCntrDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-OpfStowageMgt Business Logic ServiceCommand - ALPS-OpfStowageMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Jong Ock
 * @see OpfStowageMgtDBDAO
 * @since J2EE 1.6
 */

public class OpfStowageMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * OpfStowageMgt system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("OpfStowageMgtSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * OpfStowageMgt system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("OpfStowageMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-OpfStowageMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopOpf9501Event")) {			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {		  // Retrieve	
				eventResponse = searchBayPlanList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {// VVD / PORT Combo List 조회
				eventResponse= searchBayPlanCntrVvdPortList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {// BayIdx 조회
				eventResponse= searchBayPlanCntrBayIdx(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {// BayList Combo List 조회
				eventResponse= searchBayPlanCntrBayList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {// BayList Container 정보 조회
				eventResponse= searchBayPlanCntrDtl(e);
			}
		}
		
		return eventResponse;
	}

	/**
	 * VOP_OPF_9501 : Bay Plan<br>
	 * Bay Plan을 조회 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBayPlanList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf9501Event event = (VopOpf9501Event)e;
		OpfStowageMgtBC command = new OpfStowageMgtBCImpl();
		
		try{
			//Bay Plan 해당Container의 Bay Index정보 조회			
			if("".equals(event.getOpfStowageBayPlanListVO().getColumnValues().get("bay_idx")) || event.getOpfStowageBayPlanListVO().getColumnValues().get("bay_idx") == null){
				// Bay Plan에서 조회조건 Container의 Bay 위치정보를 조회.
				List<OpfStowageBayPlanListVO> list = command.searchBayPlanCntrPositionList(event.getOpfStowageBayPlanListVO());
	
				if(list != null && list.size() > 0){
					event.getOpfStowageBayPlanListVO().setBayIdx(list.get(0).getBayIdx());
				}
			}			
			
			//Bay Plan On 정보 조회
			event.getOpfStowageBayPlanListVO().setDhTp("D");
			List<OpfStowageBayPlanListVO> list1 = command.searchBayPlanList(event.getOpfStowageBayPlanListVO());
			
			//Bay Plan Hach Cover 정보 조회
			List<OpfStowageBayPlanListVO> list2 = command.searchBayPlanHtchCvrList(event.getOpfStowageBayPlanListVO());

			//Bay Plan Under 정보 조회
			event.getOpfStowageBayPlanListVO().setDhTp("H");
			List<OpfStowageBayPlanListVO> list3 = command.searchBayPlanList(event.getOpfStowageBayPlanListVO());
			
			//Bay Plan Port별 Color 정보 조회
			List<OpfStowageBayPlanListVO> list4 = command.searchPortColorList(event.getOpfStowageBayPlanListVO());
			
			//Bay Plan의 Contailner 상세정보 조회
			List<BayPlanCntrDtlVO> list5 = command.searchBayPlanCntrDtl(event.getOpfStowageBayPlanListVO());
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			eventResponse.setRsVoList(list3);
			eventResponse.setRsVoList(list4);
			eventResponse.setRsVoList(list5);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Bay Plan Retrieve" }).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_OPF_9501 : Bay Plan<br>
	 * Bay Plan의 Contailner 정보를 조회 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBayPlanCntrDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf9501Event event = (VopOpf9501Event)e;
		OpfStowageMgtBC command = new OpfStowageMgtBCImpl();
		
		try{
			List<BayPlanCntrDtlVO> list = command.searchBayPlanCntrDtl(event.getOpfStowageBayPlanListVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Bay Plan Retrieve" }).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_9501 : Bay Plan<br>
	 * Bay Plan에서 해당Container의 Bay Index정보를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBayPlanCntrBayIdx(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf9501Event event = (VopOpf9501Event)e;		
		OpfStowageMgtBC command = new OpfStowageMgtBCImpl();

		try{
			List<OpfStowageBayPlanListVO> list = command.searchBayPlanCntrBayIdx(event.getOpfStowageBayPlanListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_9501 : Bay Plan<br>
	 * Bay Plan의 Container에 해당되는 Bay List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBayPlanCntrBayList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf9501Event event = (VopOpf9501Event)e;		
		OpfStowageMgtBC command = new OpfStowageMgtBCImpl();

		try{
			List<OpfStowageBayPlanListVO> list = command.searchBayPlanCntrBayList(event.getOpfStowageBayPlanListVO());
			
			if(list.size() == 0){
				// 타선사 Container 조회시 VESSEL정보가 없는경우 관련테이블에 데이터를 생성하기 위해 STO_TPL_CRE_PRC 호출
				command.addBBayPlanVslCd(event.getOpfStowageBayPlanListVO().getVslCd());
				list = command.searchBayPlanCntrBayList(event.getOpfStowageBayPlanListVO());
			}
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_9501 : Bay Plan<br>
	 * Bay Plan의 Container에 해당되는 VVD 및 Port를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBayPlanCntrVvdPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf9501Event event = (VopOpf9501Event)e;		
		OpfStowageMgtBC command = new OpfStowageMgtBCImpl();

		try{
			List<OpfStowageBayPlanListVO> list = command.searchBayPlanCntrVvdPortList(event.getOpfStowageBayPlanListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
}
