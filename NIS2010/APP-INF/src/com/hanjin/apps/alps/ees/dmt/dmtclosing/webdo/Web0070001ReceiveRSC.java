/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Web0070001ReceiveRSC.java
*@FileTitle : Web0070001ReceiveRSC
*Open Issues :
*Change history :
*@LastModifyDate : 2012-01-03
*@LastModifier : Kwon Min 
*@LastVersion : 1.0
* 2012-01-03 Kwon Min
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.basic.WebDoManageBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.basic.WebDoManageBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.event.WebDoLinkEvent;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.vo.IfAccountVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.vo.IfSchemaVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * Web0070001ReceiveRSC ServiceCommand<br>
 * - Web0070001ReceiveRSC 에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author	Kwon Min
 * @see 
 * @since	J2EE 1.4
 */
public class Web0070001ReceiveRSC extends ServiceCommandSupport {
	/**
	 * WebGate 업무 시나리오 선행작업<br>
	 * WebGate 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
    public void doStart() {
        try {
            //account = getSignOnUserAccount();
        }catch(Exception e) {
            log.error("WebDoLink 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * WebDoLink 업무 시나리오 마감작업<br>
     * WebDoLink 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("WebDoLink 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        EventResponse eventResponse = new GeneralEventResponse();
        
        log.debug("event : " + e);
        log.debug("\n  ★★★★★   WebDoLink Start  ★★★★★ ");
        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        if(e.getEventName().equalsIgnoreCase("WebDoLinkEvent")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
            	List<IfSchemaVO> list	= searchPrecalDRDateCharge(e);
            	IfSchemaVO resultVO		= new IfSchemaVO();
            	int size				= 0;
            	if(list != null){
            		size	= list.size();
            	}
                
            	if(size > 0){
            		resultVO	= (IfSchemaVO)list.get(0);
            	}
            	String msg = size > 0 ? "1" : "0";
                
            	Map resultMap = new HashMap();
                
                resultMap.put("msg", msg);
                resultMap.put("resultVO", resultVO);
                
                eventResponse.setETCData(resultMap);               
            }
        }
        log.debug("\n  ★★★★★   WebDoLink End  ★★★★★ ");        
        return eventResponse;
    }

    /**
     * searchPrecalDRDateCharge 이벤트 처리<br>
     * 
     * @param e Event
     * @exception EventException
     */
    private List<IfSchemaVO> searchPrecalDRDateCharge (Event e) throws EventException {
       // EventResponse eventResponse = null;
    	List<IfSchemaVO> list = null;
        try {
            //begin();
            log.debug("\n  ★★★★★   WebDoLink  multiUsDo Start  begin,commit,rollback remove  ★★★★★ ");            
            WebDoLinkEvent event			= (WebDoLinkEvent)e;
            IfSchemaVO pVo					= event.getIfSchema();
            
            // 각 Impl 생성
            ChargeCalculationBC command_1	= new ChargeCalculationBCImpl();
            WebDoManageBC command_2			= new WebDoManageBCImpl();
            
            // interface 용 accout 생성
            String usr_id	= pVo.getWebCreUsrId();
            String ofc_cd	= pVo.getOfcCd();
            
            ChargeCalculationContainerVO[] chargeCalculationContainerVOs	= new ChargeCalculationContainerVO[1];
            ChargeCalculationContainerVO chargeCalculationContainerVO		= new ChargeCalculationContainerVO();
            IfAccountVO account												= new IfAccountVO(usr_id, ofc_cd);
                      
            chargeCalculationContainerVO.setSvrId(pVo.getSysAreaGrpId());
            chargeCalculationContainerVO.setCntrNo(pVo.getCntrNo());
            chargeCalculationContainerVO.setCntrCycNo(pVo.getCntrCycNo());
            chargeCalculationContainerVO.setDmdtTrfCd(pVo.getDmdtTrfCd());
            chargeCalculationContainerVO.setDmdtChgLocDivCd(pVo.getDmdtChgLocDivCd());
            chargeCalculationContainerVO.setChgSeq(pVo.getChgSeq());
            chargeCalculationContainerVO.setFmMvmtDt(pVo.getFmMvmtDt());
            chargeCalculationContainerVO.setToMvmtDt(pVo.getToMvmtDt());
            chargeCalculationContainerVO.setActCntCd(pVo.getActCntCd());
            chargeCalculationContainerVO.setActCustSeq(pVo.getActCustSeq());
            chargeCalculationContainerVO.setBkgNo(pVo.getBkgNo());
            chargeCalculationContainerVO.setCntrTpszCd(pVo.getCntrTpszCd());
            chargeCalculationContainerVO.setCustCntCd(pVo.getCustCntCd());
            chargeCalculationContainerVO.setCustSeq(pVo.getCustSeq());
            chargeCalculationContainerVO.setFmMvmtStsCd(pVo.getFmMvmtStsCd());
            chargeCalculationContainerVO.setFmMvmtYdCd(pVo.getFmMvmtYdCd());
            chargeCalculationContainerVO.setIoBndCd(pVo.getIoBndCd());
            chargeCalculationContainerVO.setToMvmtStsCd(pVo.getToMvmtStsCd());
            chargeCalculationContainerVO.setToMvmtYdCd(pVo.getToMvmtYdCd());
            chargeCalculationContainerVO.setWebMtyDt("");
            
            chargeCalculationContainerVOs[0]	= chargeCalculationContainerVO;
            
            // precalDRDateCharge 함수 호출 : DMT_CHG_PRE_CALC 테이블에 row 생성
            command_1.precalDRDateCharge(null, chargeCalculationContainerVOs, account);
            
            // 생성된 row select 
            list	= command_2.searchPrecalOverday(pVo);

            log.debug("\n  ★★★★★   WebDoLink  searchPrecalDRDateCharge End   ★★★★★ ");            
            //commit();
        }catch(EventException de) {
            //rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return list;
    }
}
