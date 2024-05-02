/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RASCommonSC.java
*@FileTitle : RASCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.104.23 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.event.EsmBookingUtilEvent;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBC;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBCImpl;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.event.RASCommonEvent;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.integration.RASCommonDBDAO;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmChargeVO;

/**
 * NIS2010-RASCommon Business Logic ServiceCommand - NIS2010-RASCommon 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Seung-Jun,Lee
 * @see RASCommonDBDAO
 * @since J2EE 1.6
 */
public class RASCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * RASCommon system 업무 시나리오 선행작업<br>
	 * RASCommon업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
		    log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * RASCommon system 업무 시나리오 마감작업<br>
	 * RASCommon 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("RASCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-RASCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("RascommonEvent")) {
			// Service Scope Code List(전체) (Ras)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchServiceScopeCodeList(e);
			}
			//공통코드 코드+명칭 테이블
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchComCodeDescList(e);
			}
			//공통코드테이블 (Ras)
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchComCodeList(e);
			}
			// 조직도를 조회한다.(Ras)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchRasOrganizationList(e);
			}
			// 해당 CUR 별 US 환율을 가져와 현재 AMOUNT와 곱하여 리턴
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchUsExangeAmount(e);
			}
			// BKG_REV_UMCH_TP 테이블 조회
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchBkgRevUmchTpList(e);
			}		
			// BKG_REV_UMCH_SUB_TP 테이블 조회
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = searchBkgRevUmchSubTpList(e);
			}
			// BKG_REV_UMCH_SUB_TP 테이블 조회
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND10)) {
				eventResponse = validateInvoiceNumber(e);
			}
			// BKG_REV_UMCH_SUB_TP 테이블 조회
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {
				eventResponse = validateVVD(e);
			}
			// BKG_REV_UMCH_SUB_TP 테이블 조회
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND12)) {
				eventResponse = searchManualSettleTypeCode(e);
			}
			// 공통코드 한번에 가져오기
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND13)) {
				eventResponse = searchAllCommon(e);
			}		
			// rep charge 콤보 (Ras)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND40)) {
				eventResponse = searchRepChargeCodeList(e);
			}
			// Charge list : CHG_CD, CHG_NM, REP_CHG_CD
	        else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST09)) {
	           	eventResponse = searchChargeList(e);
	        }
		}
		return eventResponse;
	}
	/**
	 * Service Scope Code List 전체를 조회합니다.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RASCommonEvent event = (RASCommonEvent)e;
		RASCommonBC command = new RASCommonBCImpl();
		
		try {
			List<RsltCdListVO> list = command.searchServiceScopeCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }

		return eventResponse;
	}

	
	
	/**
	 * 공통코드 List 를 조회합니다.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchComCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Combo Item 에 적용할 코드리스트를 조회합니다.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCodeDescList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchComCodeDescList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Ras 대상 조직도를 조회한다.(Ras)<br>
	 * RASCommon의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRasOrganizationList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchRasOrganizationList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * 해당 CUR 별 US 환율을 가져와 현재 AMOUNT와 곱하여 리턴<br>
	 * RASCommon의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return String
	 * @exception EventException
	 */
	private EventResponse searchUsExangeAmount(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            RsltCdListVO vo = event.getRsltCdListVO();
            String cmdtNm = command.searchUsExangeAmount(vo);
            vo.setNm(cmdtNm);
            eventResponse.setRsVo(vo);
            eventResponse.setETCData("usdAmount", cmdtNm);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * BKG_REV_UMCH_TP 테이블 조회<br>
	 * RASCommon의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgRevUmchTpList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchBkgRevUmchTpList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * BKG_REV_UMCH_SUB_TP 테이블 조회<br>
	 * RASCommon의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgRevUmchSubTpList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchBkgRevUmchSubTpList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * BKG_REV_UMCH_MNL_STL_TP 테이블 조회<br>
	 * RASCommon의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManualSettleTypeCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchManualSettleTypeCode(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * 공통코드(코드,명칭)정보를 조회합니다.<br>
	 * 필요한 공통코드를 한번에 가져온다.<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchAllCommon(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        try{
            CodeUtil cdUtil = CodeUtil.getInstance();       
            String[] cd = event.getRsltCdListVO().getCd().split(":");
            
            for (int j = 0 ; j < cd.length; j=j+2){

                ArrayList<CodeInfo> codeSelect = (ArrayList<CodeInfo>)cdUtil.getCodeSelect(cd[j],0);
                ArrayList<CodeInfo> cdList =codeSelect;
                List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();            
                for (int i = 0; i < cdList.size(); i++) {
                    RsltCdListVO rsltcdlistvo = new RsltCdListVO() ;
                    rsltcdlistvo.setCd(cdList.get(i).getCode());
                    if (cd[j+1].equals("Y")){
                        rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
                    }else{
                        rsltcdlistvo.setNm(cdList.get(i).getName());
                    }
                    list.add(rsltcdlistvo);
                }           
                eventResponse.setRsVoList(list);
            }       
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}		


	/**
	 * Rep Charge 리스트 리턴<br>
	 * RASCommon의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepChargeCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchRepChargeCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}	
	
	
	/**
	 * Charge 리스트를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RASCommonEvent event = (RASCommonEvent)e;
		RASCommonBC command = new RASCommonBCImpl();
		try{
			List<MdmChargeVO> list = command.searchChargeList(event.getMdmChargeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	


	/**
	 * VVD 존재여부 판단하는 함수
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse validateVVD(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RASCommonBC command = new RASCommonBCImpl();
		RASCommonEvent event = (RASCommonEvent)e;
		try {
			String output_text = command.validateVVD(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * Invoice Number 존재여부 판단하는 함수
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse validateInvoiceNumber(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RASCommonBC command = new RASCommonBCImpl();
		RASCommonEvent event = (RASCommonEvent)e;
		try {
			String output_text = command.validateInvoiceNumber(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
}