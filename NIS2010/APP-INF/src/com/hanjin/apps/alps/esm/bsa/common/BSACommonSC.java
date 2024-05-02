/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: BSACommonSC.java
*@FileTitle 	: 
*Open Issues 	:
*Change history :
*@LastModifyDate: 2006-
*@LastModifier 	: eunju park
*@LastVersion 	: 1.0
* 2006- eunju park
* 1.0 최초 생성
=========================================================
* History :
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
* 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.common;

import com.hanjin.apps.alps.esm.bsa.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.bsa.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.bsa.common.event.CommonEvent;
import com.hanjin.apps.alps.esm.bsa.common.vo.ComboVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;


/**
 * 1. 기능 : ENIS-BSA Business Logic ServiceCommand<br> 
 * 2. 처리 개요 :<p>
 *  - ENIS-BSA에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 3. 주의사항 :<p>
 * ===================================<br>
 * 4. 작성자/작성일 : parkeunju/2006.09<br>
 * ===================================<br>
 * 5. 수정사항<p>
 * 5.1 요구사항 ID :<p>
 *  - 수정자/수정일 :<p>
 * 수정사유/내역 :<p>
 * ===================================<br>
 * <p/>
 * 
 * @author eunju park
 * @see ESM_BSA_CommonEventResponse,BSACommonDBDAO 참조
 * @since J2EE 1.4
 */
public class BSACommonSC extends ServiceCommandSupport {
    // Login User Information
    //private SignOnUserAccount account = null;

    /**
     * BSA 업무 시나리오 선행작업<br>
     * BSACommon업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            //account=getSignOnUserAccount();
            //account.getUsr_id()
        } catch (Exception e) {
            log.error("BSACommonSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * BSA 업무 시나리오 마감작업<br>
     * BSACommon업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("BSACommonSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * ENIS-BSA 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
		log.debug("################# BSACommonSC.perform() ############################[STARTaa]");
		
        EventResponse eventResponse = null;
		log.debug("\n [CALL] Service Command ------------------------------------------- " 
			    + "\n EventName : " + e.getEventName() 
			    + "\n Command   : " + e.getFormCommand().getCommand());
		if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {        // 요청시 Combo List 재조회
		    eventResponse = searchCodeList(e);
		} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // VVD 변경시  etdDt 조회
			eventResponse = searchCode(e);
		}
        return eventResponse;
    }
    
    /**
	 * ESM_BSA_029 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonEvent event = (CommonEvent)e;
		CommonBC comCommand = new CommonBCImpl();
		String code = event.getComboVO().getCode();
		try {
			if (code.equals("rLane")){
				String array[][] = { {code,event.getComboVO().getTrdCd(),"All"}};
			    eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			} else if (code.equals("carrier")){
				String array[][] = { {code,event.getComboVO().getBsaOpCd(),""}};
			    eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			}
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
    
	/**
	 * ESM_BSA_029 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonEvent event = (CommonEvent)e;
		CommonBC comCommand = new CommonBCImpl();

		String code = event.getComboVO().getCode();
		
		try {
			if(code.equals("etdDt")){	
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				vslCd = event.getComboVO().getVvdCd().substring(0,4);
				skdVoyNo = event.getComboVO().getVvdCd().substring(4,8);
				skdDirCd = event.getComboVO().getVvdCd().substring(8,9);
				 
				eventResponse.setETCData("etdDt", comCommand.searchFirstEtd(vslCd, skdVoyNo, skdDirCd));
			} else if(code.equals("locCd")){	
				String portCd = event.getComboVO().getPortCd();
				eventResponse.setETCData("locCd", comCommand.checkLocationCode(portCd)+"");
			} else if(code.equals("ibLane")){
				String trdCd = event.getComboVO().getTrdCd();
				eventResponse.setETCData("trdCd", comCommand.searchIBCodeList(trdCd));
			} else if(code.equals("period")){
				ComboVO vo = new ComboVO();
				vo.setYear(event.getComboVO().getYear());
				vo.setFmMon(event.getComboVO().getFmMon());
				vo.setToMon(event.getComboVO().getToMon());
				vo.setFmWk(event.getComboVO().getFmWk());
				vo.setToWk(event.getComboVO().getToWk());
				eventResponse.setETCData("period",comCommand.searchDatePeriod(vo));
			} else if(code.equals("vslCd")){ // 2012.03.05 SHKIM
				String vslCd = "";
				vslCd = event.getComboVO().getVvdCd();
				eventResponse.setETCData("vslCdCnt", comCommand.searchVslCd(vslCd));
			}
			log.debug("");
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
}