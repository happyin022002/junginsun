/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanManageSC.java
*@FileTitle : Expense Plan Creation by HO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.05.21 정영훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBC;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrFileAtchVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.basic.PlanMgtBC;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.basic.PlanMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.event.EesMnr0112Event;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.event.EesMnr0152Event;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.event.EesMnr0212Event;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.event.EesMnr0216Event;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration.PlanMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrGuidelineVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrPlnDtlVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrPlnHdrVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.DisposalPlanGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.GuidelineGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.RepairExpensePlanGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.Screen0112VO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.OfficeInfoGRPVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-PlanManage Business Logic ServiceCommand - ALPS-PlanManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author chung young hun
 * @see PlanMgtDBDAO
 * @since J2EE 1.6
 */

public class PlanManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PlanManage system 업무 시나리오 선행작업<br>
	 * EES_MNR_0112업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("PlanManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PlanManage system 업무 시나리오 마감작업<br>
	 * EES_MNR_0112 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("PlanManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * alps-PlanManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesMnr0112Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairExpensePlanListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRepairExpensePlanService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0216Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {       
				eventResponse = searchGuidelineInfoListService(e);      
			}      
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageGuidelineInfoService(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0152Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {       
				eventResponse = searchDisposalPlanService(e);      
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {       
				eventResponse = checkDisposalPlanHeaderService(e);      
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDisposalPlanService(e);
			}
		 } else if(e.getEventName().equalsIgnoreCase("EesMnr0212Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeCodeListService(e);    
		    }   			
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_MNR_0112 : doIBSEARCH <br>
	 * [EES_MNR_0112]Expense Plan Creation by HO의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairExpensePlanListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0112Event event = (EesMnr0112Event)e;
		PlanMgtBC command = new PlanMgtBCImpl();

		try{
		
			RepairExpensePlanGRPVO repairExpensePlanGRPVO = command.searchRepairExpensePlanListBasic(event.getRepairExpensePlanGRPVO());
			
			List<Screen0112VO> listHdr  = doMakeSheet1VO(repairExpensePlanGRPVO.getCustomMnrPlnHdrVOLst());
			List<Screen0112VO> listDtl  = doMakeSheet2VO(repairExpensePlanGRPVO.getCustomMnrPlnDtlVOLst());
			
			 
			eventResponse.setRsVoList(listHdr);
			if(listDtl.size() > 0)
				eventResponse.setRsVoList(listDtl);
		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 조회된 hdr데이터를 반환한다.
	 * @param List<CustomMnrPlnHdrVO> customMnrPlnHdrVOs
	 * @return List<Screen0112VO>
	 */
	private List<Screen0112VO> doMakeSheet1VO(List<CustomMnrPlnHdrVO> customMnrPlnHdrVOs) throws EventException {
		try {	
			List<Screen0112VO> lstSvo = new ArrayList<Screen0112VO>();
			CustomMnrPlnHdrVO hdr = null;
			
			Screen0112VO svo = new Screen0112VO();
			for(int i = 0; i < customMnrPlnHdrVOs.size(); i++){
				
				hdr = (CustomMnrPlnHdrVO)customMnrPlnHdrVOs.get(i);
				if(i == 0)
					svo.setOffice(hdr.getCtrlOfcCd());
				if(hdr.getAcctCd().equals("511511")){
					svo.setP511511(hdr.getMnrPlnAmt());
				}
				if(hdr.getAcctCd().equals("511521")){
					svo.setP511521(hdr.getMnrPlnAmt());
				}
				if(hdr.getAcctCd().equals("511531")){
					svo.setP511531(hdr.getMnrPlnAmt());
				}
				if(hdr.getAcctCd().equals("511541")){
					svo.setP511541(hdr.getMnrPlnAmt());
				}
				if(hdr.getAcctCd().equals("511551")){
					svo.setP511551(hdr.getMnrPlnAmt());
				}
				if(hdr.getAcctCd().equals("511561")){
					svo.setP511561(hdr.getMnrPlnAmt());
				}
				
				svo.setCreDt(hdr.getCreDt());
				svo.setCreUsrId(hdr.getCreUsrId());
				svo.setMnrPlnSeq(hdr.getMnrPlnSeq());
				svo.setMnrPlnFlg(hdr.getMnrPlnFlg());
				svo.setMnrPlnOfcCd(hdr.getMnrPlnOfcCd());
				svo.setMnrPlnGrpNo(hdr.getMnrPlnGrpNo());
			}	
			lstSvo.add(svo);	
			return lstSvo;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}	
		
	/**
	 * 조회된 detail데이터를 반환한다.
	 * @param List<CustomMnrPlnDtlVO> customMnrPlnDtlVOs
	 * @return List<Screen0112VO>
	 */
	@SuppressWarnings("unchecked")
	private List<Screen0112VO> doMakeSheet2VO(List<CustomMnrPlnDtlVO> customMnrPlnDtlVOs) throws EventException {
		try {	
			List<Screen0112VO> lstSvo = new ArrayList<Screen0112VO>();
			CustomMnrPlnDtlVO hdr = null;
			HashMap<String , HashMap> svomap = new HashMap<String, HashMap>();
			
			for(int j = 0;j < customMnrPlnDtlVOs.size(); j++){
				hdr = (CustomMnrPlnDtlVO)customMnrPlnDtlVOs.get(j);
				String key = hdr.getCtrlOfcCd();
				HashMap<String , String> inmap =  null;
				if(svomap.containsKey(key)){
					inmap = svomap.get(key);
				}else{
					inmap = new HashMap<String, String>();
				}
			   for(int i = 0; i < hdr.getFieldNames().size();i++){
				    HashMap<String , String> temp = new HashMap<String, String>();
				    temp.put("mnrPlnSeq", hdr.getMnrPlnSeq());
				    temp.put("mnrPlnDtlSeq", hdr.getMnrPlnDtlSeq());
				    temp.put("mnr_pln_yr", hdr.getMnrPlnYr());
				    temp.put("mnr_pln_ofc_cd", hdr.getMnrPlnOfcCd());
				    temp.put("ofc_tp_cd", hdr.getOfcTpCd());
				    
				    temp.put("ofc_tp_hdr_cd", hdr.getOfcTpHdrCd());
				    temp.put("mnr_pln_hdr_seq", hdr.getMnrPlnHdrSeq());

					if(hdr.getAcctCd().equals("511511")){
						temp.put("511511", hdr.getMnrPlnAmt());
					}
					if(hdr.getAcctCd().equals("511521")){
						temp.put("511521", hdr.getMnrPlnAmt());
					}
					if(hdr.getAcctCd().equals("511531")){
						temp.put("511531", hdr.getMnrPlnAmt());
					}
					if(hdr.getAcctCd().equals("511541")){
						temp.put("511541", hdr.getMnrPlnAmt());
					}
					if(hdr.getAcctCd().equals("511551")){
						temp.put("511551", hdr.getMnrPlnAmt());
					}
					if(hdr.getAcctCd().equals("511561")){
						temp.put("511561", hdr.getMnrPlnAmt());
					}
			
					inmap.putAll(temp);
				}
			    svomap.put(key, inmap);
			}
				
			Iterator iter = svomap.keySet().iterator();
			while(iter.hasNext()){
				Screen0112VO svo = new Screen0112VO();
				String inKey = iter.next().toString();
				svo.setOffice(inKey);
					
				HashMap<String, String> hm = svomap.get(inKey);
				svo.setP511511(hm.get("511511"));
				svo.setP511521(hm.get("511521"));
				svo.setP511531(hm.get("511531"));
				svo.setP511541(hm.get("511541"));
				svo.setP511551(hm.get("511551"));
				svo.setP511561(hm.get("511561"));
				svo.setMnrPlnDtlSeq(hm.get("mnrPlnDtlSeq"));
				svo.setMnrPlnSeq(hm.get("mnrPlnSeq"));
				svo.setMnrPlnYr(hm.get("mnr_pln_yr"));
				svo.setMnrPlnOfcCd(hm.get("mnr_pln_ofc_cd"));
				svo.setOfcTpCd(hm.get("ofc_tp_cd"));
				svo.setOfcTpHdrCd(hm.get("ofc_tp_hdr_cd"));
				svo.setMnrPlnHdrSeq(hm.get("mnr_pln_hdr_seq"));


					
				lstSvo.add(svo);	
		    }	
			return lstSvo;	
		} catch(Exception ex){	
			throw new EventException(ex.getMessage(), ex);
		}
	}
	/**
	 * EES_MNR_0112 : doIBSAVE <br>
	 * [EES_MNR_0112]Expense Plan Creation by HO의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRepairExpensePlanService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0112Event event = (EesMnr0112Event)e;
		PlanMgtBC command = new PlanMgtBCImpl();
		try{
			begin();
			command.manageRepairExpensePlanBasic(event.getRepairExpensePlanGRPVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0216 : Retrieve <br>
	 * [EES_MNR_0216]M&R Guideline & Information의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineInfoListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0216Event event = (EesMnr0216Event)e;
		PlanMgtBC command = new PlanMgtBCImpl();
	
		try{			
			GuidelineGRPVO guidelineGRPVO = new GuidelineGRPVO();

			guidelineGRPVO = command.searchGuidelineInfoListBasic(event.getGuidelineGRPVO(), account);
			eventResponse.setRsVoList(guidelineGRPVO.getCustomMnrGuidelineLst());
			  		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * PlanMgt의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGuidelineInfoService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0216Event event = (EesMnr0216Event)e;
		PlanMgtBC command = new PlanMgtBCImpl();
		InterfaceMgtBC command2 = new  InterfaceMgtBCImpl();
		
		try{
			GuidelineGRPVO guidelineGRPVO = (GuidelineGRPVO) event.getGuidelineGRPVO();
			begin();
			command.manageGuidelineInfoListBasic(guidelineGRPVO, account);
			


			CustomMnrGuidelineVO[]  customMnrGuidelineVOs  = guidelineGRPVO.getCustomMnrGuidelineVOs();
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			String delChk=""; 
			
			CustomMnrFileAtchVO[] newCustomMnrFileAtchVOs = new CustomMnrFileAtchVO[customMnrGuidelineVOs.length];
			for ( int i=0; i< customMnrGuidelineVOs.length; i++ ) { 
				if(customMnrGuidelineVOs[i] == null)break;
				CustomMnrFileAtchVO customMnrFileAtchVO = new CustomMnrFileAtchVO();		
				if ( customMnrGuidelineVOs[i].getIbflag().equals("D")){
					customMnrFileAtchVO.setFileSeq(customMnrGuidelineVOs[i].getFileSeq());
					customMnrFileAtchVO.setFileDtlSeq(customMnrGuidelineVOs[i].getFileDtlSeq());
					delChk="Y";
				}
				newCustomMnrFileAtchVOs[i] = customMnrFileAtchVO;
			}

			if(delChk.equals("Y")){
				interfaceGRPVO.setCustomMnrFileAtchVOs(newCustomMnrFileAtchVOs);
				command2.removeFileUploadBasic(interfaceGRPVO, account);
			}

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * EES_MNR_0153 : Retrieve <br>
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalPlanService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0152Event event = (EesMnr0152Event)e;   
			PlanMgtBC command = new PlanMgtBCImpl();  
			DisposalPlanGRPVO disposalPlanGRPVO = new DisposalPlanGRPVO(); 
			
			disposalPlanGRPVO = command.searchDisposalPlanBasic(event.getDisposalPlanGRPVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse(); 
			for (int i=0; i<disposalPlanGRPVO.getListCustomMnrPlnTransVOs().size(); i++) {
				eventResponse.setRsVoList(disposalPlanGRPVO.getListCustomMnrPlnTransVOs().get(i));	
			}
			return eventResponse;
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	} 	

	/**
	 * EES_MNR_0153 : Save <br>
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDisposalPlanService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0152Event event = (EesMnr0152Event)e;
		PlanMgtBC command = new PlanMgtBCImpl();
		try{
			begin();
			command.manageDisposalPlanBasic(event.getDisposalPlanGRPVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * EES_MNR_0153 : Save <br>
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 체크 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */ 
	private EventResponse checkDisposalPlanHeaderService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0152Event event = (EesMnr0152Event)e;   
			PlanMgtBC command = new PlanMgtBCImpl();  
			DisposalPlanGRPVO disposalPlanGRPVO = new DisposalPlanGRPVO(); 
			GeneralEventResponse eventResponse = new GeneralEventResponse(); 
			
			disposalPlanGRPVO = command.checkDisposalPlanHeaderBasic(event.getDisposalPlanGRPVO());
			eventResponse.setETCData("cnt", disposalPlanGRPVO.getCnt());
			return eventResponse;		 
		} catch(EventException ex){ 
			throw ex;	 
		} catch(Exception ex){	
			throw new EventException(ex.getMessage(), ex);
		}	
	} 	
	
	/**
     * EES_MNR_0212 : Retrieve <br>
     * [EES_MNR_0212]M&R Regional Office Code Inquiry_Pop Up의 정보를 조회 합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchOfficeCodeListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0212Event event = (EesMnr0212Event)e;         
			PlanMgtBC command = new PlanMgtBCImpl(); 
			OfficeInfoGRPVO officeInfoGRPVO = event.getOfficeInfoGRPVO();
			officeInfoGRPVO = 	command.searchOfficeCodeListBasic(officeInfoGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();  
			eventResponse.setRsVoList(officeInfoGRPVO.getOfficeInfoListVOS());
			return eventResponse;	
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
}

