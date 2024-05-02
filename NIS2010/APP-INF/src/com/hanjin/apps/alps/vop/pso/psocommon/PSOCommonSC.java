/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSOCommonSC.java
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.20 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.psocommon;

import java.util.List;

import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.basic.PSOCodeFinderBCImpl;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.event.PsoComEvent;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.integration.PSOCodeFinderDBDAO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.hanjin.framework.component.databasedata.FileDatabaseData;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-PSOCommon Business Logic ServiceCommand - ALPS-PSOCommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Jin Ihl
 * @see PSOCodeFinderDBDAO
 * @since J2EE 1.4
 */

public class PSOCommonSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * PSOCommon system 업무 시나리오 선행작업<br>
	 * PSO_COM업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("PSOCommonSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PSOCommon system 업무 시나리오 마감작업<br>
	 * PSO_COM 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("PSOCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-PSOCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("PsoComEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAccountList(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFileExistence(e);
			}			
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0013 : Retrieve<br>
	 * 모든 Account Code 정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<CostListVO> costListVO = new PSOCodeFinderBCImpl().searchAccountList();

			StringBuilder sbCodes = new StringBuilder();
			if (costListVO != null) {
				for (CostListVO cost : costListVO) {
					sbCodes.append(cost.getAcctCd()).append(",").append(cost.getAcctEngNm()).append("|");
				}
				
				if (sbCodes.toString().endsWith("|"))
					sbCodes.deleteCharAt(sbCodes.length()-1);
			}
			eventResponse.setETCData("account", sbCodes.toString());
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * 파일존재유무판단  
	 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFileExistence(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PsoComEvent event = (PsoComEvent) e;
		
		try {
			boolean fileExist = new FileDatabaseData(event.getFileKey()).getFile().exists();
			eventResponse.setETCData("is_exists", String.valueOf(fileExist));
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}	
}