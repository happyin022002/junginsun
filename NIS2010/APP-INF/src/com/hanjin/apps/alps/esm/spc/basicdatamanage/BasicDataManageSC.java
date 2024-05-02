/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BasicDataManageSC.java
 *@FileTitle : Constraint Mastertable 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.23
 *@LastModifier : Seung-Man KIM
 *@LastVersion : 1.0
 * 2015.01.23 Seung-Man KIM
 * 1.0 Creation
 * 2015.03.18 김성욱 CHM-201533913 Compulsory Firm 기능 화면 개발 및 권한
 * 2015.07.06 [CHM-201536749]Mastertable Import기능 오류 수정 CR에 반영(Revenue Management System 추가 보완 개발 요청 선반영 포함 - CMPB 팝업 연결 추가)
 * 2015.07.27 BKG 연동 setcomfirm transaction 추가.
 * 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완 - 패키지 이동
 * 2015.08.14 김성욱, Standby BKG Report 메뉴 추가
 * 2015.08.24 이혜민 standby booking management에서 reprocess시 같은 조건으로 수행중일때 동일 reprocess 못하도록 alert 띄워줌.
 * 2016.03.17 Stand by BKG MGMT에 대한 Reprocess 정리 및 보완
 * 2016.05.12 이혜민 CHM-201640880 T/S History 개발 요청
 * 2016.07.12 [CHM-201642242] Reprocess Logic 보완 사항
=========================================================*/

package com.hanjin.apps.alps.esm.spc.basicdatamanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration.UserSetupMgtDBDAO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.basic.ConstraintMasterBC;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.basic.ConstraintMasterBCImpl;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0052Event;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0114Event;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0115Event;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0116Event;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0117Event;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0118Event;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0122Event;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0124Event;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpcS001Event;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BkgInfoListVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BkgListForCompFirmBySPCVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BookingStowageVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.CustomerControlGroupVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.EstimatedCMPBVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.GetCodeSelectVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.ReportFormVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchCompulsoryFirmVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchOfficeBKGInControlVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchSpaceAllocationLaneControlOptionVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SpcAlocMgmtVO;
import com.hanjin.apps.alps.esm.spc.common.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.spc.common.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.spc.common.common.vo.CommonCodeVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcSbBkgVO;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;

/**
 * NIS2010-BookingMaterData Business Logic ServiceCommand -
 * NIS2010-BookingMaterData 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Youngchul
 * @see UserSetupMgtDBDAO
 * @since J2EE 1.4
 */

public class BasicDataManageSC extends ServiceCommandSupport {

    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * BookingMaterData system 업무 시나리오 선행작업<br>
     * 업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
        	// 일단 comment --> 로그인 체크 부분
            account = getSignOnUserAccount();
        } catch(Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * BookingMaterData system 업무 시나리오 마감작업<br>
     * 업무 시나리오 종료시 관련 내부객체 해제<br>* BookingMaterData system 업무 시나리오 마감작업<br>
     * 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
    	log.debug("BookingMaterDataSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * NIS2010-BookingMaterData system 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
        
        /* EsmSpc0115Event */
        if(e.getEventName().equalsIgnoreCase("EsmSpc0115Event")){
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchBkgAlocMgmt(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageBkgAlocMgmt(e);
            }else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
                eventResponse = removeBkgAlocMgmt(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchComCode1215(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchBkgAlocValidationData(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchCmdtNm(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchScgGrpCmdtCdList(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = searchGrpCmdtNm(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
                eventResponse = checkOfficePfmc(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
                eventResponse = searchVVDByLane(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
                eventResponse = searchCrrCdValidationData(e);
            }
        }else if(e.getEventName().equalsIgnoreCase("EsmSpcS001Event")){
            if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
                eventResponse = searchBookingStowageList(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmSpc0116Event")){
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // Retrive
				eventResponse = searchCompulsoryFirmList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //OFC Level 찾기 
				eventResponse = searchOfcLevel(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBackEndJobVO(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkReprocessCondition(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //Branch Check box Save
				eventResponse = confirmRequest(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { //Reprocess
				eventResponse = doReprocess(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { //Stand by-> Firm
				eventResponse = setComfirm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) { 
				eventResponse = addReprocessCondition(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) { 
				eventResponse = removeReprocessCondition(e);

			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { //Monitoring
				eventResponse = searchStandbyBatchStatus(e);
			}else{
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
        } else if(e.getEventName().equalsIgnoreCase("EsmSpc0117Event")){
        	if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
                eventResponse = searchBkgInfoList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)){//
            	eventResponse = multiBkgInfoList4MasterTable(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmSpc0118Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // masert sheet info
                eventResponse = searchSetFormList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // detail sheet info
		    	eventResponse = searchSetFormList2(e);
	    	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { 
		    	eventResponse = searchSetFormList3(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)) {
            	eventResponse = searchComBoCdList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
		    	eventResponse = multiSetForm(e);
	    	}
        } else if (e.getEventName().equalsIgnoreCase("EsmSpc0122Event")) {
			eventResponse = searchEstimatedCMPB(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0124Event")) {
			eventResponse = searchSpaceContainerTypeSizeList(e);	
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0052Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSpaceAllocationControlOption(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpaceAllocationControlOption(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { //Lane Detail
				eventResponse = searchSpaceAllocationControlOptionDetail(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = multiSpaceAllocationLaneControlOptionDetail(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { //Booking Control Option
				eventResponse = searchSpaceAllocationBKGControlOfficeGetList(e);
				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { //Open Office List window at Lane Control Option, BKG Control Option
				eventResponse = searchSpaceAllocationControlOffice(e);
				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { //Booking Control Option List Insert/Update/Delete
				eventResponse = multiSpaceAllocationBkgControlOptionOfficeList(e);
			}
//			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//upload
//				eventResponse = multiSpaceAllocationLaneControlOptionDetail02(e);
//			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeSpaceAllocationLaneControlOptionDetail(e);
				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchSpaceAllocationBKGControlOfficeGetList(e);
				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) { //Customer Control Cd
				eventResponse = searchCustomerControlCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) { //입력한 SC No 유효성을 체크
				eventResponse = searchScNoValidForFixed(e);
				
			}else {
				eventResponse = searchSpaceAllocComboList(e);
			}	
			
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0114Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSpaceAllocationLaneControlOptionDetail02(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpaceAllocationLaneControlOptionDetail02(e);
			}
		} 
		/*else if (e.getEventName().equalsIgnoreCase("EsmSpc0123Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // Retrive MasterTable
				eventResponse = searchStandbyBKGMSTList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // Retrive SMP, Aloc
				eventResponse = searchStandbyBKGList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // Retrive MasterTable, SMP, Aloc
				// 신혜성 부장님 요구 사항. master table 을 기준으로 SMP, ALOC 정보를 맞춘다.(2015.08.12 15:30 메일)
				eventResponse = searchStandbyBKGAllList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //OFC Level 찾기 
				eventResponse = searchOfcLevel(e);
			}else{
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
		}*/
        
        return eventResponse;
    }
   
    
	
    
    /**
     * 조회 이벤트 처리<br>
     * Booking Allocation Master Table의 event에 대한 콤보 이벤트 처리<br>
     * 1215화면에 대한 콤보리스트 조회.<br>
     * @param e EsmSpc0115Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode1215(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();
		CommonCodeVO vo = new CommonCodeVO();
		List<CommonCodeVO> list = new ArrayList<CommonCodeVO>();
		try {
			vo.setMethod("CommonCode");
			vo.setCode("CD03428");
			list = command.searchCommonComboList(vo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
    
    /**
     * 조회 이벤트 처리<br>
     *  Booking Allocation Master Table 화면 조회.<br> 
     * 
     * @param e EsmSpc0115Event
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchBkgAlocMgmt(Event e) throws EventException {
        EsmSpc0115Event event = (EsmSpc0115Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ConstraintMasterBC command = new ConstraintMasterBCImpl();
                
        try {
            // search
        	List<SpcAlocMgmtVO> list = command.searchBkgAlocMgmt(event.getSpcAlocMgmtVO());
            // set VOs
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 저장 및 수정 이벤트 처리<br>
     *  Booking Allocation Master Table 화면 저장 및 수정.<br>
     *  
     * @param e EsmSpc0115Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageBkgAlocMgmt(Event e) throws EventException {
    	EsmSpc0115Event event = (EsmSpc0115Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ConstraintMasterBC command = new ConstraintMasterBCImpl();
        
        SpcAlocMgmtVO[] bkgAlocMgmtVOs = event.getSpcAlocMgmtVOs();

        try {
            begin();
            command.manageBkgAlocMgmt(bkgAlocMgmtVOs, account);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 삭제 이벤트 처리<br>
     *  Booking Allocation Master Table 화면 삭제.<br>
     *  
     * @param e EsmSpc0115Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse removeBkgAlocMgmt(Event e) throws EventException {
    	EsmSpc0115Event event = (EsmSpc0115Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ConstraintMasterBC command = new ConstraintMasterBCImpl();
        
        SpcAlocMgmtVO bkgAlocMgmtVO = event.getSpcAlocMgmtVO();

        try {
            begin();
            command.removeBkgAlocMgmt(bkgAlocMgmtVO);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * 팝업 내 Carrier Code 및 Carrier Name 조회<br>
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchCrrCdValidationData(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmSpc0115Event event = (EsmSpc0115Event)e;
    	ConstraintMasterBC command = null;
    	List<SpcAlocMgmtVO> list = null;
    	
		try {
			command = new ConstraintMasterBCImpl();
			list = command.searchBkgAlocValidationData(event.getSpcAlocMgmtVO());
            eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
    
    /**
     * 조회 이벤트 처리<br>
     * Booking Allocation Master Table의 event에 대한 이벤트 처리<br>
     * 1215화면에 대한 시트내용 검증용 Data 조회.<br>
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchBkgAlocValidationData(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmSpc0115Event event = (EsmSpc0115Event)e;
    	ConstraintMasterBC command = null;
    	List<SpcAlocMgmtVO> list = null;
    	
		try {
			command = new ConstraintMasterBCImpl();
			list = command.searchBkgAlocValidationData(event.getSpcAlocMgmtVO());
	    	    	
	    	eventResponse.setETCData("val_cnt",list.get(0).getValCnt());
	    	
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
    
    /**
     * 조회 이벤트 처리<br>
     *  Booking Allocation Master Table 화면에 Commodity Name을 조회<br>   
     * 
     * @param e EsmSpc0115Event
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchCmdtNm(Event e) throws EventException {
        EsmSpc0115Event event = (EsmSpc0115Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ConstraintMasterBC command = new ConstraintMasterBCImpl();
                
        try {
        	List<SpcAlocMgmtVO> list = command.searchCmdtNm(event.getSpcAlocMgmtVO());
            eventResponse.setETCData("cmdt_nm",list.get(0).getCmdtNm());
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }   
    
    /**
     * 조회 이벤트 처리<br>
     *  Booking Allocation Master Table 화면에 Commodity Name을 조회<br> 
     * 
     * @param e EsmSpc0115Event
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchGrpCmdtNm(Event e) throws EventException {
        EsmSpc0115Event event = (EsmSpc0115Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ConstraintMasterBC command = new ConstraintMasterBCImpl();
                
        try {
        	List<SpcAlocMgmtVO> list = command.searchGrpCmdtNm(event.getSpcAlocMgmtVO());
            eventResponse.setETCData("scg_grp_cmdt_desc",list.get(0).getCmdtNm());
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }   
    
    /**
     * 조회 이벤트 처리<br>
     *  Booking Allocation Master Table 화면에 Group Commodity Combo을 조회<br>   
     * 
     * @param e EsmSpc0115Event
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchScgGrpCmdtCdList(Event e) throws EventException {
    	
	GeneralEventResponse eventResponse = new GeneralEventResponse();
	CommonBC command = new CommonBCImpl();
    CommonCodeVO vo = new CommonCodeVO();
    List<CommonCodeVO> list = new ArrayList<CommonCodeVO>();

		try{
			vo.setMethod("ScgGrpCmdtCode");
			vo.setCode("TPW");
			list = command.searchCommonComboList(vo);
			eventResponse.setRsVoList(list);
			//eventResponse.setCustomData("CtrlTp", list);
			
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
    }
    

    /**
	 * ESM_SPC_0116 : retrieve <br>
	 * Compulsory Firm 대상 목록을 조회한다.<br>
	 *
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCompulsoryFirmList(Event e) throws EventException {
		try{
			EsmSpc0116Event event = (EsmSpc0116Event)e;		 
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(event.getSearchConditionVO()!=null){
				ConstraintMasterBC command = new ConstraintMasterBCImpl();
				
				List<SearchCompulsoryFirmVO> list = command.searchCompulsoryFirmList(event.getSearchConditionVO());
				eventResponse.setRsVoList(list);
			}
		
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SPC_0116 : Reprocess <br>
	 * Reprocess <br>
	 * 
	 * @author DYRYU
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse doReprocess(Event e) throws EventException {
		EsmSpc0116Event event = (EsmSpc0116Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		
		try {	
			String batStatus = "";
			//1. 배치가 돌고 있는지 Check 한다
			SearchConditionVO searchVo = event.getSearchConditionVO();
			searchVo.setFStsCd("R"); //RUNNING
			List<CommonCodeVO> list = command.searchStandbyBatchStatus(searchVo);
	
			if(!list.isEmpty()) {
				batStatus = list.get(0).getCode();
			}
			
			//2. 만약 Running 상태이면 해당 상태를 알리고 더 이상 진행하지 않는다. 
			if("R".equals(batStatus)){
				eventResponse.setETCData("BatchStatus", batStatus);
				return eventResponse;
			}

			//3. batch status를 생성한다

			/* SC 단에서 등록해야 setTimeOut을 정상적으로 사용할 수 있다.
			for (String bkgNo:bkgList) {
				
				// 1. 배치 모니터링 등록
				// - 대상 BKG들을 배치에 먼저 등록한다.
				// - SC 단에서 존재유무를 미리 판단해서 없을경우 진행됨
				Object[] startParam ={userId, bkgNo};
				logger.info("BKG NO: " +bkgNo+ " Insert Batch Status !!");
				wrapper.update("spc/ReprocessStandbyBooking", "merge_bat_status", startParam);
			}
			wrapper.commit();
			*/
			begin();
			command.addStandbyBatchStatus(event.getCompFirmBySPCVOs(), account);		
			commit();
	
			// 4. batch를 실행한다.		
			//searchVo.setFStsCd("R"); //RUNNING		
			batStatus = command.doReprocess(searchVo, account );						
			eventResponse.setETCData("BatchStatus", batStatus);
			
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12208", new String[] {""}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Standby Reprocess Batch monitoring<br>
	 * Batch status monitoring
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStandbyBatchStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		EsmSpc0116Event event = (EsmSpc0116Event)e;
		try {
			String batchStatus = "";
			//1. 배치가 돌고 있는지 Check 한다
			SearchConditionVO searchVo = event.getSearchConditionVO();
			searchVo.setFStsCd("R"); //RUNNING
			List<CommonCodeVO> list = command.searchStandbyBatchStatus(searchVo);

			if(!list.isEmpty()) {
				batchStatus = list.get(0).getCode();
			}
			
			eventResponse.setETCData("BatchStatus", batchStatus);
			
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * BackEndJob : interval <br>
	 * BackEndJob의 상태값을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBackEndJobVO(Event e) throws EventException {
	    String key = (String)e.getAttribute("KEY");
	    String[] rtnArr = null;
	    String status = null;
	    String errMsg = null;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
	    try {
	    	rtnArr = command.searchBackEndJobVO(key);
	    	status = rtnArr[0];
	    	errMsg = rtnArr[1];
	        eventResponse.setETCData("jb_sts_flg", status);
	        eventResponse.setETCData("jb_usr_err_msg", errMsg);
	    }catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
	    }
	    return eventResponse;
	}
	
	/**
	 * ESM_SPC_0116 : SEARCH03<br>
	 * Reprocess 버튼 클릭 시 수행전 현재 같은 조건으로 Reprocess되고 있는 백엔드잡이 있는지 체크합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkReprocessCondition(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0116Event event = (EsmSpc0116Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		
		try{
			boolean rtn = command.checkReprocessCondition(event.getSearchConditionVO());
	
			eventResponse.setETCData("chk", rtn==true?"Y":"N");
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0116 : MODIFY03<br>
	 * Reprocess 시작 시 해당조건을 SPC_SB_BKG_PROC_STS 테이블에 삽입합니다.<br>
	 *  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse addReprocessCondition(Event e) throws EventException {
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0116Event event = (EsmSpc0116Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
	    
	    try {
	        begin();
	        command.addReprocessCondition(event.getSearchConditionVO(), account);
	        commit();
	    } catch(EventException ex) {
	        rollback();
	        throw ex;
	    } catch(Exception ex) {
	        rollback();
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    }
	    return eventResponse;
	}
	
	/**
	 * ESM_SPC_0116 : MODIFY04<br>
	 * Reprocess 종료 시 해당조건을 SPC_SB_BKG_PROC_STS 테이블에서 삭제합니다.<br>
	 *  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeReprocessCondition(Event e) throws EventException {
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0116Event event = (EsmSpc0116Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
	    
	    try {
	        begin();
	        command.removeReprocessCondition(event.getSearchConditionVO());
	        commit();
	        eventResponse.setUserMessage("");
	    } catch(EventException ex) {
	        rollback();
	        throw ex;
	    } catch(Exception ex) {
	        rollback();
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    }
	    return eventResponse;
	}
	
	/**
	 * ESM_SPC_0116 : Branch Check box Save <br>
	 * Confirm 요청 <br>
	 * 
	 * @author Kim Sung Wook
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmRequest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0116Event event = (EsmSpc0116Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		
		try {
			begin();
			SpcSbBkgVO[]  ssbs = event.getCompFirmBySPCVOs();
			if( ssbs != null ){
				command.confirmRequest( ssbs , account  );
			}
			commit();
	    } catch(EventException ex) {
	    	rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
	    } catch(Exception ex) {
	    	rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
	//        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    }
	    return eventResponse;
	}
	
    /**
     * 조회 이벤트 처리<br>
     * Import Mastertable 화면 조회.<br>   
     * 
     * @param e EsmSpc0117Event
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchBkgInfoList(Event e) throws EventException {
    	EsmSpc0117Event event = (EsmSpc0117Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ConstraintMasterBC command = new ConstraintMasterBCImpl();
                
        try {
            // search
            List<BkgInfoListVO> list = command.searchBkgInfoList(event.getBkgInfoListVOs(), event.getSearchConditionVO());
            // set VOs
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 저장 및 수정 이벤트 처리<br>
     *  Import Mastertable 화면 저장<br>
     *  
     * @param e EsmSpc0117Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse multiBkgInfoList4MasterTable(Event e) throws EventException {
    	EsmSpc0117Event event = (EsmSpc0117Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ConstraintMasterBC command = new ConstraintMasterBCImpl();
        
       try {
            begin();
            command.multiBkgInfoList4MasterTable(event.getBkgInfoListVOs(), account);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
        
    /**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmSpc0118Event event = (EsmSpc0118Event)e;
	   	ConstraintMasterBC commonBC = new ConstraintMasterBCImpl();
	   	String pgm=event.getmReportFormVO().getPgm();
	   	
	   	try {    
	    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)){
	    		    /*Select Customized RPT Form*/
	    		    String array[][] = { {"slctItmFom",pgm,"Blank"}};
					
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array ,account);

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
    * * 1. 기능 : simulation no 콤보리스트 조회 이벤트 처리<p>
    * <p/>
    * @return EventResponse
    * @exception EventException
    */
   private EventResponse searchSetFormList(Event e) throws EventException {
	   EsmSpc0118Event event = (EsmSpc0118Event)e;
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       try{
    	   //SalesRPTBC command = new SalesRPTBCImpl();
    	   ConstraintMasterBC command = new ConstraintMasterBCImpl();
           List<ReportFormVO> list = command.searchSetFormList(event.getSearchConditionVO(), event.getmReportFormVO());
           
           String seqNo = "";
           if(event.getSearchConditionVO().getFSelgroup().equals("")){
               int listCnt = list.size();
               for(int i=0; i<listCnt; i++){
            	   seqNo = ((ReportFormVO)list.get(i)).getDpSeq();
               }        	   
           }
           eventResponse.setETCData("selGroup", seqNo);
           eventResponse.setRsVoList(list);

           return eventResponse;
       }catch(EventException ex){
           log.error("err " + ex.toString(), ex);
           throw new EventException(ex.getMessage());
       }catch(Exception ex){
           throw new EventException(ex.getMessage(), ex);
       }
   }
   
   /**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
 private EventResponse searchSetFormList2(Event e) throws EventException {
	  EsmSpc0118Event event = (EsmSpc0118Event)e;
     GeneralEventResponse eventResponse = new GeneralEventResponse();
     try{
   	  ConstraintMasterBC command = new ConstraintMasterBCImpl();
         List<ReportFormVO> list = command.searchSetFormList2(event.getSearchConditionVO(), event.getmReportFormVO(), account);
         
         String seqNo = "";
         if(event.getSearchConditionVO().getFSelgroup().equals("")){
             int listCnt = list.size();
             for(int i=0; i<listCnt; i++){
          	   seqNo = ((ReportFormVO)list.get(i)).getDpSeq();
             }        	   
         }
         eventResponse.setETCData("selGroup", seqNo);           
         eventResponse.setRsVoList(list);
         
         return eventResponse;
     }catch(EventException ex){
         log.error("err " + ex.toString(), ex);
         throw new EventException(ex.getMessage());
     }catch(Exception ex){
         throw new EventException(ex.getMessage(), ex);
     }
 }
 /**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
 private EventResponse searchSetFormList3(Event e) throws EventException {
	  EsmSpc0118Event event = (EsmSpc0118Event)e;
     GeneralEventResponse eventResponse = new GeneralEventResponse();
     
//     String userId = event.getSignOnUserAccount().getUsr_id();
     try{
    	 ConstraintMasterBC command = new ConstraintMasterBCImpl();
//         List<ReportFormVO> list = command.searchSetFormList3(event.getSearchConditionVO(), event.getmReportFormVO(), account);
//         event.getSalesRPTCommonVO().setEventName("EsmSpc0117Event");
         ReportFormVO retVo = command.searchSetFormList3(event.getSearchConditionVO(), event.getmReportFormVO(), account);
         
         eventResponse.setETCData("header", (String)retVo.getHeader());
         eventResponse.setETCData("headerNM", (String)retVo.getHeaderNM());
         
         log.debug("####################### 멀티.searchInqByCondition060List2() #############  [END]");
         return eventResponse;
//         String dpNm = "";
//         String colNm = "";
//         if(event.getSearchConditionVO().getFSelgroup().equals("")){
//             int listCnt = list.size();
//             for(int i=0; i<listCnt; i++){
//            	 
//            	 dpNm = ((ReportFormVO)list.get(i)).getDpNm();
//            	 colNm = ((ReportFormVO)list.get(i)).getColNm();
//             }        	   
//         }
//         eventResponse.setETCData("header", dpNm);       
//         eventResponse.setETCData("headerNM", colNm);       
//         eventResponse.setRsVoList(list);
         
//         return eventResponse;
     }catch(EventException ex){
    	 rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
     }catch(Exception ex){
    	 rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
     }
 }
	 /**
		 * 멀티 이벤트 처리<br>
		 * 
		 * @param e Event
		 * @return EventResponse EventResponse
		 * @exception EventException
		 */
	private EventResponse multiSetForm(Event e) throws EventException { 
		  EsmSpc0118Event event = (EsmSpc0118Event)e;
	   GeneralEventResponse eventResponse = new GeneralEventResponse();
	   try {
	       begin();
	       ConstraintMasterBC command = new ConstraintMasterBCImpl();
	       event.getSalesRPTCommonVO().setEventName("EsmSpc0118Event");
	       eventResponse = (GeneralEventResponse) command.multiSetForm(event.getSearchConditionVO(), event.getSalesRPTCommonVO(), event.getSalesRPTCommonVOs(), event.getmReportFormVOs(),event.getmReportFormVO(), account);
	       commit();
	       return eventResponse;
	   } catch (EventException de) {
	       rollback();
	       log.error("err " + de.toString(), de);
	       throw new EventException(de.getMessage());
	   }
	}
	/**
	 * 0741: EsmSpc0115Event<br>
	 * 등록된 Office code 인지 여부를 체크합니다.<br>
	 * Office code 를 체크합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	
	private EventResponse checkOfficePfmc(Event e) throws EventException {
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    EsmSpc0115Event event = (EsmSpc0115Event) e;
	    ConstraintMasterBC command = null;
	    List<SpcAlocMgmtVO> list = null;
	    String check   = null;
	    String chkHOFC = null;
	    String[] temp  = null;
	    try {
	    	command = new ConstraintMasterBCImpl();
	        list = command.checkOfficePfmc(event.getSpcAlocMgmtVO());
	        temp  = event.getSpcAlocMgmtVO().getChkOp().split(":");
	    	check = 0 < list.size() ? "Y" : "N";
	        log.debug("ofc_ty >>> " + event.getSpcAlocMgmtVO().getOfcTy());
	        log.debug("chk_op >>> " + temp[0]);
	        
	        
	        event.getSpcAlocMgmtVO().setChkOp(temp[0]);
	        //e-Service Handling Office 에서 
	        //Controlled Office 에 등록된 Office 가  H/OFC 에 등록되지 않도록 체크함
	//        if ("B".equals(temp[0]) && "3".equals(event.getBkgDocPerfOfcVO().getOfcTy())) {
	        if ("3".equals(event.getSpcAlocMgmtVO().getOfcTy())) {
	        	list = command.checkCtrlOffice(event.getSpcAlocMgmtVO());
	    		chkHOFC = 0 < list.size() ? "N" : "Y";
	        }
	        eventResponse.setETCData("check",check);
	        eventResponse.setETCData("chkOFC",chkHOFC);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	    return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_SPC_0115 : VVD에 해당하는 Lane 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchVVDByLane(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0115Event event = (EsmSpc0115Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		
		String lane = "none";
		String vvd  = event.getSpcAlocMgmtVO().getVvdSig();
		
		if (command.validateVvd(vvd.substring(0, 4), vvd.substring(4, 8), vvd.substring(8))){
			
			lane = command.searchSvcLaneByVvd(vvd);
		}
		
		eventResponse.setETCData("lane", lane);
		return eventResponse;
	}
	
	
   /**
	 * REAPPLY 이벤트 처리<br>
	 * : 전주 기준으로 duration 만큼의 대상항차 기준의 Standby BKG을 재계산 합니다.<br>
     *  
     * @return EventResponse
     * @exception EventException
     */
/*	
    private EventResponse multiReapplyConstraint() throws EventException {
//		EsmSpc0117Event event = (EsmSpc0117Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		
		try {
			begin();
			
//			command.multiReapplyConstraint();
			
//			List<ReapplyBKGListVO> list = command.searchReapplyBKGList();
//			Iterator<ReapplyBKGListVO> iterator = list.iterator();
//			
//			while (iterator.hasNext()) {
//				ReapplyBKGListVO vo = (ReapplyBKGListVO) iterator.next();
//				
//				if (vo != null){
//					//MasterTable
//					BkgBlNoVO bkgVO = new BkgBlNoVO();
//					bkgVO.setBkgNo(vo.getBkgNo());
//					AllocStsChgVO rtVo = receiptBC.manageAlocStatus(bkgVO, account, "");
//					String mstSts = rtVo.getAlocStsCd();
//					
//					SpcSbBkgVO sbVo = new SpcSbBkgVO();
//					sbVo.setBkgNo(vo.getBkgNo());
//					
//					if("S".equals(mstSts)) {
//						sbVo.setCnddtCfmFlg("0");
//						sbVo.setLstSbRsnTpCd("M");
//						sbVo.setLstSbRsn(""); //reason 세팅
//						
//						//update SPC_SB_BKG
//						command.multiSpcSbBk(sbVo);
//						
//						//Master에서 Standby에 걸리면 더이상 다음 STEP 진행 안해도 됨
//						break;
//					} else { //MasterTable Candidate Confirm
//						
//						//SMP
//						String smpSts = "";
//						//SMP CHECK로직 들어가는 곳
//						
//						
//						if("S".equals(smpSts)) {
//							
//							sbVo.setCnddtCfmFlg("0");
//							sbVo.setLstSbRsnTpCd("S");
//							sbVo.setLstSbRsn(""); //reason 세팅
//							
//							
//							
//							
//							//update SPC_SB_BKG
//							command.multiSpcSbBk(sbVo);
//							//SMP에서 Standby에 걸리면 더이상 다음 STEP 진행 안해도 됨
//							break;
//						} else { //SMP Candidate Confirm
//						
//							//Allocation
//							String alocSts = "";
//							
//							if("S".equals(alocSts)){
//								
//								sbVo.setCnddtCfmFlg("0");
//								sbVo.setLstSbRsnTpCd("A");
//								sbVo.setLstSbRsn(""); //reason 세팅
//								//update SPC_SB_BKG
//								command.multiSpcSbBk(sbVo);
//							} else { //Allocation Candidate Confirm
//								
//								//SMP CHECK로직 들어가는 곳
//								
//								
//								
//								
//								
//								//최종적으로 Candidate Confirm 대상인 경우 아래 수행함
//								sbVo.setCnddtCfmFlg("1");
//								//update SPC_SB_BKG
//								command.multiSpcSbBk(sbVo);
//							}
//						}
//					}
//
//				}
//			}
			commit();
			
			eventResponse.setUserMessage("");
		} catch(EventException ex) {
		    rollback();
		    throw ex;
		} catch(Exception ex) {
		    rollback();
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }*/
    
	/**
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationOfficeCond(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC comCommand = new CommonBCImpl();
		
		try{
			List<SearchOfficeCondVO> list = comCommand.searchOfficeCond(e, account);
			if(list.size() > 0){
				SearchOfficeCondVO searchOfficeCondVO = list.get(0);
				eventResponse.setETCData(searchOfficeCondVO.getColumnValues());
			}
			// BKG 정보를 사용하고 있는데 이 부분에 대해서 변경이 필요 (SPC에서 공통코드를 가지고 올수 있도록 변경 필요)
			BookingUtil comboUtil = new BookingUtil();
			List<BkgComboVO> allocStsCd = comboUtil.searchCombo("CD03271");
			eventResponse.setRsVoList(allocStsCd);
			
//			/* 2010.08.27 이행지 [CHM-201005552-01] Allocation Control by Main Office 화면 Remark 기능 보완
//               Remark 가능한 Office인지 체크하여 Flag값 받아오기.
//            */
//			String rmkFlg = command.searchRemarkFlagOffice(ofcCd);
//			eventResponse.setETCData("rmkFlg",rmkFlg);
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
	 * Compulsory Firm 에서 Standby 를 Firm 으로 변경시키는 동작
	 * JS에서 그리드에 있는 BKG NO 를 하나씩 뽑아서 올려줌(aloc_sts_cd, bkg_no)
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse setComfirm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0116Event event = (EsmSpc0116Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		
		try {
			BkgListForCompFirmBySPCVO[]  comfirmItem = event.getBkgListForCompFirmBySPCVOs();
			if( comfirmItem != null ){
				GeneralBookingReceiptBC gbr = new GeneralBookingReceiptBCImpl();
				for (int i = 0; i < comfirmItem.length; i++) {
					//log.debug("+++++++++++++++++++++++++++++++++++++++++"+comfirmItem[i].getCfmFlg());
					String bkgNo = comfirmItem[i].getBkgNo();
					if( bkgNo != null && !bkgNo.equals("") && comfirmItem[i].getCfmFlg().equals("1")) {   //cfm_flg

						begin();

						//log.debug("+++++++++++++++++++++++++++++++++++++++++"+comfirmItem[i].getAlocStsCd());
						
						if(comfirmItem[i].getAlocStsCd().equals("F")) {
							//BKG은 firm 이고 SPC는 Standby 상태일때
							command.setComfirm( comfirmItem[i] , account  );
						} else {

							//log.debug("++++++++++++++++++++++++++++++++++++BKG+++"+comfirmItem[i].getAlocStsCd());
							//BKG:Standby, SPC:Standby 상태
							if( gbr.modifyAllocStatusForSpc( comfirmItem[i].getBkgNo() , account ) ){
								//현재(2015.04.23 return type 이 void 임, 이후 boolean 으로 변경 될 예정) by kim sung wook
								command.setComfirm( comfirmItem[i] , account  );
							}
							
						}

						commit();
					}
				}	

				eventResponse.setETCData("isSuccess","Y");
			}
	    } catch(EventException ex) {
	    	rollback();
	        throw ex;
	    } catch(Exception ex) {
	    	rollback();
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    }
	    return eventResponse;
	}
		
	/**
	 * 0116화면 로딩시 넘어온 Office code 에 해당하는 Level 가져오기
	 * @param Event e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOfcLevel(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0116Event event = (EsmSpc0116Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		
		try{
			SearchOfficeCondVO searchOfficeCondVO = event.getSearchOfficeCondVO();
			if( searchOfficeCondVO != null ) {
				String r = command.searchOfcLevel( searchOfficeCondVO, account );
				eventResponse.setETCData("ofc_level", r);
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    }
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1183 Estimated CMPT 팝업창 띄우기를 위한 메소드<br>
	 * Estimated CMPB 팝업창 생성<br>
	 * @author DONG HUN YANG
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchEstimatedCMPB(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		EsmSpc0122Event event = (EsmSpc0122Event)e;
		List<EstimatedCMPBVO> list =command.searchEstimatedCMPB(event.getBkgNo());
		eventResponse.setRsVoList(list);
		return eventResponse;
		
	}
	
	/*============================== ESM_SPC_0052, 0114 package 변경 시작==============================*/

	
	/**
	 * ESM_SPC_0052 [저장]
	 * 노선별 Control Option을 저장한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiSpaceAllocationControlOption(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0052Event event = (EsmSpc0052Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		
		try{
			begin();
			command.multiSpaceAllocationControlOption(event.getSearchSpaceAllocationLaneControlOptionVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SPC_0052 [조회]
	 * 노선별 Control Option을 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSpaceAllocationControlOption(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0052Event event = (EsmSpc0052Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		try{
			List<SearchSpaceAllocationLaneControlOptionVO> list = command.searchSpaceAllocationControlOption(event.getConditionVO());
			eventResponse.setRsVoList(list);
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
	 * ESM_SPC_0052 [조회]
	 * 노선별 Control Option 상세정보를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSpaceAllocationControlOptionDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0052Event event = (EsmSpc0052Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		try{
			List<SearchSpaceAllocationLaneControlOptionVO> list = command.searchSpaceAllocationControlOptionDetail(event.getConditionVO());
			eventResponse.setRsVoList(list);
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
	 * ESM_SPC_0052 [저장]
	 * 노선별 Control Option을 저장한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiSpaceAllocationLaneControlOptionDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0052Event event = (EsmSpc0052Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		
		try{
			begin();
			command.multiSpaceAllocationLaneControlOptionDetail(event.getSearchSpaceAllocationLaneControlOptionVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
//	/**
//	 * ESM_SPC_0052 [UPLOAD SAVE]
//	 * 노선별 Control Option을 저장한다.
//	 * 
//	 * @param e
//	 * @return
//	 * @throws EventException
//	 */
//	private EventResponse multiSpaceAllocationLaneControlOptionDetail02(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsmSpc0052Event event = (EsmSpc0052Event)e;
//		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
//		
//		try{
//			begin();
//			command.multiSpaceAllocationLaneControlOptionDetail02(event.getSearchSpaceAllocationLaneControlOptionVOs(),account);
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
//			commit();
//		} catch(EventException ex) {
//			rollback();
//			log.error("err " + ex.toString(), ex);
//			throw ex;
//		} catch(Exception ex) {
//			rollback();
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
//		}
//		return eventResponse;
//	}
	/**
	 * ESM_SPC_0052 [저장]
	 * 노선별 Control Option을 삭제한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse removeSpaceAllocationLaneControlOptionDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0052Event event = (EsmSpc0052Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		
		try{
			begin();
			command.removeSpaceAllocationLaneControlOptionDetail(event.getSearchSpaceAllocationLaneControlOptionVO());
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0052 [저장]
	 * 선택한 trade, lane 과 연결된 bkg control option list가져오기
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSpaceAllocationBKGControlOfficeGetList( Event e ) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0052Event event = (EsmSpc0052Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		try{
			begin();
			List<SearchOfficeBKGInControlVO> list = command.searchSpaceAllocationControloffice(event.getSearchOfficeBKGInControlVO());
			
			eventResponse.setRsVoList(list);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * ESM_SPC_0052 [저장] - BKG Control Option Office LIST Insert / Update / Delete
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse multiSpaceAllocationBkgControlOptionOfficeList( Event e ) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0052Event event = (EsmSpc0052Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		try{
			begin();
			command.multiSpaceAllocationBKGControlOptionOfficeList(event.getSearchOfficeBKGInControlVOs() , account );
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SPC_0052 [저장]
	 * 선택한 Control 에 등록할 office 정보 가져오기
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSpaceAllocationControlOffice( Event e ) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0052Event event = (EsmSpc0052Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		try{
			begin();
			List<SqmQtaLaneOfcVO> list = command.searchSpaceAllocationControloffice(event.getSearchSpaceAllocationControlofficeVO());
			eventResponse.setRsVoList(list);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Customer Control Code
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCustomerControlCode( Event e ) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0052Event event = (EsmSpc0052Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		log.debug("searchCustomerControlCode sc");
		try{
			begin();
			List<CustomerControlGroupVO> list = command.searchCustomerControlCode(event.getSearchCustomerControlCodeVO());
			
			eventResponse.setRsVoList(list);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0052: 두번째 Sheet내 Control(Fixed) 선택한 후 SC NO 입력시 
	 * 입력한 SC No가 PRI에서 Filed되고 Fixed 되었는지 유효성을 체크합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScNoValidForFixed(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0052Event event = (EsmSpc0052Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		String ScNoCnt = "";

		try{
			ScNoCnt = command.searchScNoValidForFixed(event.getScNo());
			eventResponse.setETCData("ScNoCnt", ScNoCnt);
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
	 * ESM_SPC_XXXX : Open<br>
	 * Combo Data 를 공통코드에서 가져온다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocComboList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();
        CommonCodeVO vo = new CommonCodeVO();
        List<CommonCodeVO> list = new ArrayList<CommonCodeVO>();

		try{

			// aloc_ctrl_tp_cd A,B,C,E,F,G
			vo.setMethod("CommonCode");
			vo.setCode("CD03297");
			list = command.searchCommonComboList(vo);
			eventResponse.setCustomData("CtrlTp", list);
			
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0114 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationLaneControlOptionDetail02(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0114Event event = (EsmSpc0114Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();

		try{
			List<SearchSpaceAllocationLaneControlOptionVO> list = command.searchSpaceAllocationLaneControlOptionDetail02(event.getConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	/**
	 * ESM_SPC_0114 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpaceAllocationLaneControlOptionDetail02(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0114Event event = (EsmSpc0114Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();
		try{
			begin();
			command.multiSpaceAllocationLaneControlOptionDetail02(event.getSearchSpaceAllocationLaneControlOptionVOs(),account);
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
	
	/**
	 * ESM_SPC_0124 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceContainerTypeSizeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0124Event event = (EsmSpc0124Event)e;
		ConstraintMasterBC command = new ConstraintMasterBCImpl();

		try{
			List<GetCodeSelectVO> list = command.searchSpaceContainerTypeSizeList(event.getGetCodeSelectVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}	
	
    /**
     * 조회 이벤트 처리<br>
     * 팝업 내 Stowage List 조회<br>
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchBookingStowageList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSpcS001Event event = (EsmSpcS001Event)e;
        ConstraintMasterBC command = null;
        List<BookingStowageVO> list = null;
        
         
        try {
  
            command = new ConstraintMasterBCImpl();
            list = command.searchBookingStowageList(event.getSpcAlocMgmtVO());
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
	
	/*============================== ESM_SPC_0052, 0114 package 변경 종료==============================*/

	/**
	 * ESM_SPC_0123 : retrieve <br>
	 * Standby BKG Report Mastertable, SMP, ALOC 목록을 조회한다.<br>
	 *
	 * @author KimSungwook
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchStandbyBKGAllList(Event e) throws EventException {
//		try{
//			EsmSpc0123Event event = (EsmSpc0123Event)e;		 
//			GeneralEventResponse eventResponse = new GeneralEventResponse();
//			if(event.getSearchConditionVO()!=null){
//				ConstraintMasterBC command = new ConstraintMasterBCImpl();
//				
//				List<SearchStandbyBKGRPTMSTVO> list = command.searchStandbyBKGReportAllList(event.getSearchConditionVO());
//				eventResponse.setRsVoList(list);
//			}
//		
//			return eventResponse;			
//		}catch(EventException ex){
//			log.error("err"+ex.toString(),ex);
//			throw ex;
//		}catch(Exception ex){
//			log.error("err"+ex.toString(),ex);
//			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
//		}
//	}
	
	/**
	 * ESM_SPC_0123 : retrieve <br>
	 * Standby BKG Report Mastertable 목록을 조회한다.<br>
	 *
	 * @author KimSungwook
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchStandbyBKGMSTList(Event e) throws EventException {
//		try{
//			EsmSpc0123Event event = (EsmSpc0123Event)e;		 
//			GeneralEventResponse eventResponse = new GeneralEventResponse();
//			if(event.getSearchConditionVO()!=null){
//				ConstraintMasterBC command = new ConstraintMasterBCImpl();
//				
//				List<SearchStandbyBKGRPTMSTVO> list = command.searchStandbyBKGReportMSTList(event.getSearchConditionVO());
//				eventResponse.setRsVoList(list);
//			}
//		
//			return eventResponse;			
//		}catch(EventException ex){
//			log.error("err"+ex.toString(),ex);
//			throw ex;
//		}catch(Exception ex){
//			log.error("err"+ex.toString(),ex);
//			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
//		}
//	}
	
	/**
	 * ESM_SPC_0123 : retrieve <br>
	 * Standby BKG Report Aloc,SMP 목록을 조회한다.<br>
	 *
	 * @author KimSungwook
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchStandbyBKGList(Event e) throws EventException {
//		try{
//			EsmSpc0123Event event = (EsmSpc0123Event)e;		 
//			GeneralEventResponse eventResponse = new GeneralEventResponse();
//			if(event.getSearchConditionVO()!=null){
//				ConstraintMasterBC command = new ConstraintMasterBCImpl();
//				
//				List<SearchCompulsoryFirmVO> list = command.searchStandbyBKGReportList(event.getSearchConditionVO());
//				eventResponse.setRsVoList(list);
//			}
//		
//			return eventResponse;			
//		}catch(EventException ex){
//			log.error("err"+ex.toString(),ex);
//			throw ex;
//		}catch(Exception ex){
//			log.error("err"+ex.toString(),ex);
//			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
//		}
//	}
}
