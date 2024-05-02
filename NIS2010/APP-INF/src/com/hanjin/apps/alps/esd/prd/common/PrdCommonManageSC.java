/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PrdCommonManageSC.java
 *@FileTitle : PRD 공통관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-16
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0 
 * 2006-10-16 jungsunyoung
 * 1.0 최초 생성
 * 2009.08.03 NohSeungBae alps f/w 로 구조 변경 
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.prd.common.prdcommon.basic.PrdCommonManageBC;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.basic.PrdCommonManageBCImpl;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.event.EsdPrd0026Event;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.event.PrdCommonEvent;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ContinentVO;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ServiceProviderVO;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ValidationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic ServiceCommand<br>
 * - alps-PRD에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author jungsunyoung
 * @see EventResponse,PrdCommonManageDBDAO 참조
 * @since J2EE 1.4
 */
public class PrdCommonManageSC extends ServiceCommandSupport{
	// Login User Information

	private SignOnUserAccount account = null;

	/**
	 * PRD 업무 시나리오 선행작업<br>
	 * PrdCommonManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	@Override
	public void doStart(){
		try{
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
			if(account.getUsr_id() == null){
				throw new RuntimeException((new ErrorHandler("PRD00035")).getMessage());
			}

		} catch(Exception e){
			log.error("PrdCommonManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * PrdCommonManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	@Override
	public void doEnd(){
		// command.doEnd();
		log.debug("PrdCommonManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * alps-PRD 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		if(e.getEventName().equalsIgnoreCase("PrdCommonEvent")){
			PrdCommonEvent event = (PrdCommonEvent) e;
			PrdCommonManageBC command = new PrdCommonManageBCImpl();
			List<ValidationVO> list = new ArrayList();
			List<ContinentVO>  conList = new ArrayList();
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				list = command.validationPort(event.getValidationVO());
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02) || e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				list = command.validationLocation(event.getValidationVO());
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){//★ 2009-08-14 KIM KWIJIN 수정
				list = command.validationNode(event.getValidationVO());
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)){
				list = command.validationTerminal(event.getValidationVO());
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)){
				list = command.validationCountry(event.getValidationVO());
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)){
				list = command.validationLane(event.getValidationVO());
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH08)){
				list = command.validationVendor(event.getValidationVO());
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)){
				list = command.validationFdrLane(event.getValidationVO());
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)){
				list = command.validationCallingTmlMtxLane(event.getValidationVO());
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH11)){
				list = command.validationCallingTmlMtxTmlCd(event.getValidationVO());
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)){
				list = command.validationLaneVvd(event.getValidationVO());

			// SearchContinentList
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH20)){
				conList = command.searchContinent();
			// SearchSubContinentList
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH19)){
				conList = command.searchSubContinent(event.getContinentVO());
			}
			
			if(conList !=null && conList.size()>0 && (conList.get(0) instanceof ContinentVO)){
				eventResponse.setRsVoList(conList);
			}else{
				ValidationVO vo = (ValidationVO)list.get(0);
				eventResponse.setETCData(vo.getColumnValues());
				eventResponse.setETCData("rowCount", list.size()+"");
				eventResponse.setRsVoList(list);
					String comData1 = "";
					String comData2 = "";
					boolean isDoor = false;
	    	        if( e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
	                    //while (list.next()) {
	    	        	for(int i =0;i<list.size();i++){
	                   
	    	        		comData1 = list.get(i).getVslSlanNm();
	                    }            	        	
	    	        } else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
	    	        	isDoor = command.isDoorTerminal(event.getValidationVO().getCheckData());
	    	        	for(int i =0;i<list.size();i++){
	                      	 comData1 = list.get(i).getNodeName();
	                      	 comData2 = list.get(i).getLocationCode();
	                       }            	        	
	    	        } else if(e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
	    	        	for(int i =0;i<list.size();i++){
	                      	 //comData1 =list.getString("com_data1"); //VNDR_ABBR_NM
	                      	 //comData2 = list.getString("com_data2"); //vndr_lgl_eng_nm
	    	        		 comData1 = list.get(i).getComData1();
	                      	 comData2 = list.get(i).getComData2();
	                       }            	        	
	    	        } else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
	    	        	for(int i =0;i<list.size();i++){
	    	        		comData1 = list.get(i).getCheckData();
	    	        	}            	        	
	       	        } else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
	    	        	for(int i =0;i<list.size();i++){
	    	        		comData1 = list.get(i).getCheckData();
	    	        	}            	        	
	       	        } 
	    	      
	    	        eventResponse.setETCData("comData1",comData1);
	    	        eventResponse.setETCData("comData2",comData2);
	    	        eventResponse.setETCData("isDoor",isDoor+"");
			}
			
		} else if(e.getEventName().equalsIgnoreCase("ESD_PRD_030Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){
				PrdCommonEvent event = (PrdCommonEvent) e;
				PrdCommonManageBC command = new PrdCommonManageBCImpl();
				List list = command.validationCallingTmlMtxLane(event.getValidationVO());
				eventResponse.setRsVoList(list);
			//eventResponse = searchCarrierCode(e);
			}
//		} else if(e.getEventName().equalsIgnoreCase("CopUpdateEvent")){
//
//			if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){
//				//eventResponse = createPrdCtlNoGen(e);
//			}
		} else if(e.getEventName().equalsIgnoreCase("EsdPrd0026Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchServiceProviderList(e);
			}
		}

		return eventResponse;
	}

	//TODO 로직 정리되면 아래 메소드 삭제 noh
	/**
	 * PrdCommonManageSC's searchServiceProviderList
	 *
	 * @param e
	 * @return
	 * @throws EventException
	 *             EventResponse
	 */
	private GeneralEventResponse searchServiceProviderList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0026Event event = (EsdPrd0026Event)e;
		PrdCommonManageBC command = new PrdCommonManageBCImpl();

		try{
			if(event.getServiceProviderVO().getOfcCd().equals("")){
				
				event.getServiceProviderVO().setOfcCd(account.getOfc_cd());
				
			}
			List<ServiceProviderVO> list = command.searchServiceProviderList(event.getServiceProviderVO());
			eventResponse.setETCData("ofc_cd",event.getServiceProviderVO().getOfcCd());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
}

