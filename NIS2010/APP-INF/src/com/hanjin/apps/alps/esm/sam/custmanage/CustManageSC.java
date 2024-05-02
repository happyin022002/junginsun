/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : CustManageSC.java
*@FileTitle : Customer Management
*Open Issues :
*Change history :
*@LastModifyDate : 2017-07-07 
*@LastModifier : Lim Jaekwan
*@LastVersion : 1.0
* 2017-07-07 Lim Jaekwan
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BlHistVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custgroup.basic.CustGroupBC;
import com.hanjin.apps.alps.esm.sam.custmanage.custgroup.basic.CustGroupBCImpl;
import com.hanjin.apps.alps.esm.sam.custmanage.custgroup.event.EsmSam0301Event;
import com.hanjin.apps.alps.esm.sam.custmanage.custgroup.event.EsmSam0303Event;
import com.hanjin.apps.alps.esm.sam.custmanage.custgroup.event.EsmSam0306Event;
import com.hanjin.apps.alps.esm.sam.custmanage.custgroup.vo.CustomerGroupCodeVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.basic.CustMainBC;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.basic.CustMainBCImpl;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.event.EsmSam0302Event;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.event.EsmSam0304Event;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.event.EsmSam0305Event;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.BkgSalesRepVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustCoverTeamVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerAddressVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerContactVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerPerformanceVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.MdmCustomerVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custrequest.basic.CustRequestBC;
import com.hanjin.apps.alps.esm.sam.custmanage.custrequest.basic.CustRequestBCImpl;
import com.hanjin.apps.alps.esm.sam.custmanage.custrequest.event.EsmSam0309Event;
import com.hanjin.apps.alps.esm.sam.custmanage.custrequest.event.EsmSam0310Event;
import com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.basic.KeyManInfoBC;
import com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.basic.KeyManInfoBCImpl;
import com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.event.EsmSam0307Event;
import com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.event.EsmSam0308Event;
import com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.vo.SamKeyManInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * CustManageSC Business Logic ServiceCommand<br>
 * - CustManageSC에 1대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author Lim Jaekwan
 * @see COM_ENS_0A1EventResponse,VesselDBDAO 참조 
 * @since J2EE 1.4
 */
public class CustManageSC extends ServiceCommandSupport {
	// Login User Information
    private SignOnUserAccount account = null;

    /**
     * BIZCOMMON 업무 시나리오 선행작업<br> 
     * Vessel업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();  
            log.debug("CustManageSC Start");
        } catch (Exception e) {
            log.error("CustManageSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * BIZCOMMON 업무 시나리오 마감작업<br>
     * Vessel업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("CustManageSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * CustManageSC 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
        log.debug(e.getEventName());
        /*
         * BizCommonSC에 사용법
         * 1. 각각의 업무에 를 통합하는 SC로써 각 업무에 대한 로직은 아래와 같이 작성한다.
         * 2. BC에 대한 각 업무단 BC를 참조하여야 한다. 
         * */
        
        // 4. CustGroup(EsmSam0301Event)
        if (e.getEventName().equalsIgnoreCase("EsmSam0301Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCustGroupList(e);
            } 
        } 
        else if (e.getEventName().equalsIgnoreCase("EsmSam0302Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchCustCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = checkCntCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = checkLocCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				eventResponse = checkOfcCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)){
				eventResponse = checkVndrCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)){
				eventResponse = checkCurrCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)){
				eventResponse = searchLocSteCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH08)){
				eventResponse = checkIntlNo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageCustCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = manageGstCustCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)){
				eventResponse = checkCustCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)){
				eventResponse = checkSlsRepCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH11)){
				eventResponse = checkGrpCustCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)){
				eventResponse = checkStateCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH15)){	
				eventResponse = checkExistCustCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH16)){	
				eventResponse = checkTrdCode(e);
			}
        }
        else if (e.getEventName().equalsIgnoreCase("EsmSam0303Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchGroupCustomer(e);
            } 
        } 
		else if (e.getEventName().equalsIgnoreCase("EsmSam0304Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomerListByName(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSam0305Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCustomerList(e);
            } 
        }
        else if (e.getEventName().equalsIgnoreCase("EsmSam0306Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustPerfCode(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
	            eventResponse = manageCustPerfCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkOfcCode ( e );
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkSlsRepCode ( e );
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				//eventResponse = searchCustGrpId(e);				
			}
        }
       /* KeyMan List(EsmSam0307Event)*/
        else if (e.getEventName().equalsIgnoreCase("EsmSam0307Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKeyManList(e);
			} 
        }
        
        /* KeyMan 정보조회(EsmSam0308Event)*/
        else if (e.getEventName().equalsIgnoreCase("EsmSam0308Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKeyManList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
	            eventResponse = manageKeyManList(e);
			}
        }
        
        else if (e.getEventName().equalsIgnoreCase("EsmSam0309Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustRqst(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = checkCustRqst(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)){
				eventResponse = checkUserMdmAuth(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
	            eventResponse = manageCustRqst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageMdmCustRqst (e);
			}
        }
        
        else if (e.getEventName().equalsIgnoreCase("EsmSam0310Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRqstCustomer(e);
            } 
        } 

        return eventResponse;
    }
    
    /**
	 * Request No checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCustRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustRequestBC command = new CustRequestBCImpl();
		String rqstNo = new String();
		
		if(e instanceof EsmSam0309Event){
		 	EsmSam0309Event event = (EsmSam0309Event)e;
		 	rqstNo = event.getRqstNo();
		}
		try{
			String result = command.checkCustRqst(rqstNo);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
    
    /**
     * 조회 이벤트 처리<br>
     * Customer Request 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author jaekwan Lim
     * @date 2017.07.21
     */
    private EventResponse searchRqstCustomer(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSam0310Event event = (EsmSam0310Event)e;
        try {
        	CustRequestBC command = new CustRequestBCImpl();
        	// custGrpId, custGrpNm, ofcCd, iPage, include, deltFlg
            eventResponse.setRsVoList(command.searchRqstCustomer(event.getRqstNo(),event.getCustNm(),event.getOfcCd(),event.getIPage(),event.getDeltFlg(),event.getRqstFmDt(),event.getRqstToDt(),event.getCreFmDt(),event.getCreToDt()  ));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
	 * ESM_SAM_0309 : Request<br>
	 * Add and modify Customer Code.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse manageMdmCustRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0309Event event = (EsmSam0309Event)e;
		CustRequestBC command = new CustRequestBCImpl();
		
		CustomerVO customerVO = event.getCustomerVO();
		
		try {
			begin();
			log.debug("\nMULTI SC================================"+event.getCreflag());
			
			//customerVOs[0].setCreUsrId(account.getUsr_id());
			//mdmCustomerVOs.add(customerVOs[0]);
			String rqstNo = customerVO.getRqstNo();
			
			command.sendCustRqstToMdm(rqstNo, account.getUsr_id(), event.getCreflag());

			commit();
			
	        eventResponse.setETCData("rqstNo", rqstNo);
	          
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
    
    /**
	 * ESM_SAM_0309 : Save<br>
	 * Add and modify Customer Code.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse manageCustRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0309Event event = (EsmSam0309Event)e;
		CustRequestBC command = new CustRequestBCImpl();
		
		CustomerVO customerVO = event.getCustomerVO();
		
		try {
			begin();
			log.debug("\nMULTI SC================================"+account.getUsr_id());
			
			//customerVOs[0].setCreUsrId(account.getUsr_id());
			//mdmCustomerVOs.add(customerVOs[0]);
			customerVO = command.manageCustRqst(event.getCustomerVO(), account);
			
			String rqstNo = customerVO.getRqstNo();
			
			commit();
			
	        eventResponse.setETCData("rqstNo", rqstNo);
	          
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
    
    /**
	 * ESM_SAM_0309 : SEARCH<br>
	 * Customer retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0309Event event = (EsmSam0309Event)e;
		CustRequestBC command = new CustRequestBCImpl();
		
		try {
			 CustomerVO vo = command.searchCustRqst(event.getRqstNo());
			 log.debug("getCustLglEngNm================================"+vo.getCustLglEngNm());
			 
			 if (event!=null){
				 eventResponse.setRsVo(vo);
			 }
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
    
        
    	/**
    	 * common : open<br>
    	 * Combo list retrieve.<br>
    	 * 
    	 * @param Event e
    	 * @return EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchComboList(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		CustMainBC command = new CustMainBCImpl();
    		String[][] array = null;
    		
    		if (e.getEventName().equalsIgnoreCase("EsmSam0302Event")) {
    			array = new String[14][3];
    			array[0][0] = "CD00693";
    			array[0][2] = "Blank";
    			array[1][0] = "CD00697";
    			array[1][2] = "Blank";
    			array[2][0] = "CD00694";//"CD30045"; //"CD00694";
    			array[2][2] = "Blank";
    			array[3][0] = "CD00695";//"CD30046"; //"CD00695";
    			array[3][2] = "Blank";
    			array[4][0] = "CD00696";//"CD30047"; //"CD00698";
    			array[4][2] = "Blank";
    			array[5][0] = "CD00698";//"CD00692";
    			array[5][2] = "Blank";
    			array[6][0] = "CD20090";
    			array[6][2] = "Blank";
    			array[7][0] = "CD03553";
    			array[7][2] = "Blank";
    			array[8][0] = "CntrTpSz";
    			array[8][2] = "Blank";
    			array[9][0] = "Trade";
    			array[9][2] = "Blank";
    			array[10][0] = "IndState";
    			array[10][2] = "Blank";
    			array[11][0] = "CD00699";
    			array[12][0] = "IntlPhnNo";
    			array[12][2] = "Blank";
    			array[13][0] = "CD03570";
    			array[13][2] = "Blank";
    			//array[11][2] = "Blank";
    		}

    		try{
    			if(array != null){
    				eventResponse = command.searchCommonCodeList(eventResponse, array);
    			}
    		}catch(EventException ex){
    			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
    		}catch(Exception ex){
    			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
    		}	
    		return eventResponse;
    	}
    	
    	/**
    	 * common : open<br>
    	 * Combo list retrieve.<br>
    	 * 
    	 * @param Event e
    	 * @return EventResponse
    	 * @exception EventException
    	 */
    	private EventResponse searchLocSteCode(Event e) throws EventException {
    		// PDTO(Data Transfer Object including Parameters)
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		CustMainBC command = new CustMainBCImpl();
    		String locCd = new String();
    		
    		if(e instanceof EsmSam0302Event){
    			EsmSam0302Event event = (EsmSam0302Event)e;
    			locCd = event.getLocCd();
    		}
    		try{
    			CustomerVO result = command.searchLocSteCode(locCd);
    			eventResponse.setETCData("steNm", result.getSteNm());
    			eventResponse.setETCData("idaSteCd", result.getIdaSteCd());
    			eventResponse.setETCData("idaTerrDivCd", result.getIdaTerrDivCd());
    		}catch(EventException ex){
    			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
    		}catch(Exception ex){
    			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
    		}	
    		return eventResponse;
    	}
    
    /**
     * 조회 이벤트 처리<br>
     * ServiceProvider 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author jaekwan Lim
     * @date 2012.02.21
     */
    private EventResponse searchCustGroupList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSam0301Event event = (EsmSam0301Event)e;
        try {
        	CustGroupBC command = new CustGroupBCImpl();
        	// custGrpId, custGrpNm, ofcCd, iPage, include, deltFlg
            eventResponse.setRsVoList(command.searchCustGroupList(event.getCustGrpId(),event.getCustGrpNm(),event.getOfcCd(),event.getIPage(),event.getMdmYn(),event.getDeltFlg(), event.getCustGrpAbbrNm()));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
	/**
	 * ESM_SAM_0304 : Customer Dup checking<br>
	 *  queries is similar mame to the registered Customer.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchCustomerListByName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0304Event event = (EsmSam0304Event)e;
		CustMainBC command = new CustMainBCImpl();
		String custCntCd = null;
		String custNm = null;
		String locCd = null;
		String custRgstNo = null ;
		String matchRule = null ;
		List<CustomerVO> list = null;
		
		try {
			 
			custCntCd = event.getCustCntCd();
			custNm =  event.getCustNm();
			locCd = event.getLocCd();
			custRgstNo = event.getCustRgstNo();
			matchRule = event.getMatchRule();
			//log.debug("sc========ddddd==========================="+custNm);
			list = command.searchCustomerListByName(custCntCd, custNm, locCd, custRgstNo, matchRule);
		
			eventResponse.setRsVoList(list);
			
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
    }	
    
    /**
     * 조회 이벤트 처리<br>
     * ServiceProvider 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author jaekwan Lim
     * @date 2012.02.21
     */
    private EventResponse searchGroupCustomer(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSam0303Event event = (EsmSam0303Event)e;
        try {
        	CustGroupBC command = new CustGroupBCImpl();
        	// custGrpId, custGrpNm, ofcCd, iPage, include, deltFlg
            eventResponse.setRsVoList(command.searchCustGroupList(event.getCustGrpId(),event.getCustGrpNm(),event.getOfcCd(),event.getIPage(),event.getMdmYn(),event.getDeltFlg(), event.getCustGrpAbbrNm()));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * ServiceProvider 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author sungseok, choi
     * @date 2006.08.07
     */
    private EventResponse searchCustomerList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSam0305Event event = (EsmSam0305Event)e;
        try {
        	CustMainBC command = new CustMainBCImpl();
        	// custCd, custNm, ofcCd, iPage, include, cust
            eventResponse.setRsVoList(command.searchCustomerList(event.getCustCd(),event.getCustNm(),event.getOfcCd(),event.getIPage(),event.getInclude(),event.getCust(), event.getZipCd(), event.getCustGrpId(), event.getLocCd(), event.getSteCd(), event.getSrepCd(), event.getDeltFlg()));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
	/**
	 * ESM_SAM_0302 : SEARCH<br>
	 * Customer retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0302Event event = (EsmSam0302Event)e;
		CustMainBC command = new CustMainBCImpl();
		KeyManInfoBC receiptBC = new KeyManInfoBCImpl();
		
		try {
			 CustomerVO vo = command.searchCustCode(event.getCustCntCd(), event.getCustSeq());
			 /*log.debug("getCustLglEngNm================================"+vo.getCustLglEngNm());
			 log.debug("getCustCd================================"+vo.getCustCntCd());
			 log.debug("getCustDivCd================================"+vo.getCustDivCd());
			 log.debug("getIsNewYn================================"+(event!=null?JSPUtil.getNull(event.getIsNewYn()):""));*/
			 
			 log.debug("\n searchCustCode test @@@@@@@@@@@@@@@@@  \n");
			if (vo != null) {
				 if (event!=null){
					 if (event!=null){
						 eventResponse.setRsVo(vo);
						 
						 /** KEYMAN **/
						 List<SamKeyManInfoVO> list = null;
						 list = receiptBC.searchKeyManInfo(event.getCustCntCd(), event.getCustSeq());
						 eventResponse.setRsVoList(list);
						 
						 /** CUSTOMER ADDRESS **/
						 List<CustomerAddressVO> list1 = null;
						 list1 = command.searchCustAddr(event.getCustCntCd(), event.getCustSeq(), "ALL");
						 eventResponse.setRsVoList(list1);
						 
						 /** Coverage Team ADDRESS **/
						 List<CustCoverTeamVO> list2 = null;
						 list2 = command.searchCustCoverList(event.getCustCntCd(), event.getCustSeq());
						 eventResponse.setRsVoList(list2);
						 
						 /** History **/
						 List<BlHistVO> list3 = null;
						 list3 = command.searchCustHist(event.getCustCntCd(), event.getCustSeq());
						 eventResponse.setRsVoList(list3);
					 }
				 }
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0302 : Save<br>
	 * Add and modify Customer Code.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse manageCustCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0302Event event = (EsmSam0302Event)e;
		CustMainBC command = new CustMainBCImpl();
		KeyManInfoBC receiptBC = new KeyManInfoBCImpl();
		List<MdmCustomerVO> mdmCustomerVOs = new ArrayList<MdmCustomerVO>();
		
		String checkSalesRepCd = null;
		String checkCntcPnt = null;
		MdmCustomerVO[] mdmCustomerVOS = event.getMdmCustomerVOS();
		BkgSalesRepVO[] bkgSalesRepVOS = event.getBkgSalesRepVOS();
		//CustCoverTeamVO[] custCoverTeamVOS = event.getCustCoverTeamVOS();
		SamKeyManInfoVO[] samKeyManInfoVOs = event.getSamKeyManInfoVOS();
		CustomerAddressVO[] custAddrVOs = event.getCustomerAddressVOS();

		try {
			begin();
			log.debug("\nMULTI SC================================"+account.getUsr_id());
			
			//customerVOs[0].setCreUsrId(account.getUsr_id());
			//mdmCustomerVOs.add(customerVOs[0]);
			CustomerVO customerVo = command.manageCustCode(event.getCustomerIntgVO(), account);
			CustomerContactVO[] customerContractVOs = event.getCustomerContactVOS();
			String custCd = mdmCustomerVOS[0].getCustCntCd() + customerVo.getCustSeq();
			//String srepCd = mdmCustomerVOS[0].getSrepCd();
			String custCntCd = mdmCustomerVOS[0].getCustCntCd();
			String custSeq = customerVo.getCustSeq();
			String crmRowId = customerVo.getCrmRowId();
			log.debug("\nIB Flag================================"+ event.getCreflag()); 
			
			log.debug("\nAddress================================"+mdmCustomerVOS[0].getBzetAddr()); 
			
			if(!"".equals(customerVo.getFileSavId())){
				command.mergeMdmCustSezCerti(customerVo);
			}
			
			/*if("Y".equals(event.getCreflag())){
				if(!"".equals(mdmCustomerVOS[0].getSrepCd())){
					checkSalesRepCd = command.checkSalesRepCode(custCd, srepCd);
				 
					//samcommand.manageSalesRepInfo(mdmCustomerVOS, checkSalesRepCd, account );
					//if("".equals(checkSalesRepCd)){
					bkgSalesRepVOS[0].setOpCd("I");
					bkgSalesRepVOS[0].setDeltFlg("N");
					bkgSalesRepVOS[0].setCustCntCd(custCntCd);
					bkgSalesRepVOS[0].setCustSeq(custSeq);
					command.manageSalesRep(bkgSalesRepVOS, account);
					//}
				}
				
				if(!"".equals(mdmCustomerVOS[0].getBzetAddr())){
					custAddrVOs[0].setCustCntCd(custCntCd);
					custAddrVOs[0].setCustSeq(custSeq);
					custAddrVOs[0].setAddrTpCd("1");
					custAddrVOs[0].setAddrSeq("1");
					custAddrVOs[0].setPrmryChkFlg("Y");
					custAddrVOs[0].setBzetAddr(mdmCustomerVOS[0].getBzetAddr());
					command.manageCustAddrCode(custAddrVOs, account);	
				}
				
				customerContractVOs[0].setIbflag("I");
				customerContractVOs[0].setCustCntCd(custCntCd);
				customerContractVOs[0].setCustSeq(custSeq);
				//customerVo
				customerContractVOs[0].setCustEml(customerVo.getCustEml());
				customerContractVOs[0].setCustUrl(customerVo.getCustUrl());
				customerContractVOs[0].setIntlPhnNo(customerVo.getIntlPhnNo());
				customerContractVOs[0].setPhnNo(customerVo.getPhnNo());
				customerContractVOs[0].setIntlFaxNo(customerVo.getIntlFaxNo());
				customerContractVOs[0].setFaxNo(customerVo.getFaxNo());
				// Contact point
				command.manageCustCntcCode(customerContractVOs, account, event.getCreflag());
				
			} else {*/
			
				/** CUSTOMER ADDR **/
				for(int i = 0; custAddrVOs!=null && i<custAddrVOs.length; i++){
				 	custAddrVOs[i].setCustCntCd(custCntCd);
				 	custAddrVOs[i].setCustSeq(custSeq);
				 	custAddrVOs[i].setCrmRowId(crmRowId);
				 	custAddrVOs[i].setCustCd(customerVo.getCustCd());
				 	custAddrVOs[i].setCreUsrId(account.getUsr_id());
		        }
	
		        if (custAddrVOs!=null){
		        	command.manageCustAddrCode(custAddrVOs, account);	
		        }
		        
		        /** CUSTOMER KeyMan **/
				for(int i = 0; samKeyManInfoVOs!=null && i<samKeyManInfoVOs.length; i++){
					samKeyManInfoVOs[i].setCustCntCd(custCntCd);
					samKeyManInfoVOs[i].setCustSeq(custSeq);
		        }
	
		        if (samKeyManInfoVOs!=null){
		        	receiptBC.manageKeyManCust(samKeyManInfoVOs, account);	
		        }
		        
		        /** Coverage Team **/
		        for(int i = 0; bkgSalesRepVOS!=null && i<bkgSalesRepVOS.length; i++){
		        	bkgSalesRepVOS[i].setCustCntCd(custCntCd);
		        	bkgSalesRepVOS[i].setCustSeq(custSeq);
		        	
		        	if (bkgSalesRepVOS[i].getIbflag().equals("I")) {
						checkSalesRepCd = command.checkSalesRepCode(custCd, bkgSalesRepVOS[i].getSrepCd());
						if(!"".equals(checkSalesRepCd)){
							bkgSalesRepVOS[i].setIbflag("U");
						}
					}
		        }
		        
		        if (bkgSalesRepVOS!=null){
		        	command.manageSalesRep(bkgSalesRepVOS, account);
		        }
		        
				/** CUSTOMER CNTC PNT **/
		        if (customerVo.getIbflag() != null && customerVo.getIbflag().equals("U")){
					checkCntcPnt = command.checkCntcPnt(custCntCd, custSeq);
					
					if("".equals(checkCntcPnt)){
						customerContractVOs[0].setIbflag("I");
					} else {
						customerContractVOs[0].setIbflag("U");
					}
					customerContractVOs[0].setCustCntCd(custCntCd);
					customerContractVOs[0].setCustSeq(custSeq);
					//customerVo
					customerContractVOs[0].setCustEml(customerVo.getCustEml());
					customerContractVOs[0].setCustUrl(customerVo.getCustUrl());
					customerContractVOs[0].setIntlPhnNo(customerVo.getIntlPhnNo());
					customerContractVOs[0].setPhnNo(customerVo.getPhnNo());
					customerContractVOs[0].setIntlFaxNo(customerVo.getIntlFaxNo());
					customerContractVOs[0].setFaxNo(customerVo.getFaxNo());
					
					// Contact point
					command.manageCustCntcCode(customerContractVOs, account, event.getCreflag());
		        }
			//}
			
			//command.mergeBkgCustCdVal(mdmCustomerVOs);
				
/*			if (custAddrVOs!=null){
	        	command.sendCustAddrToMdm(custAddrVOs, account);	
	        }*/
			
			command.addCustHist(custCntCd, custSeq, account.getUsr_id());
			
			commit();
			
	        eventResponse.setETCData("custCntCd", custCntCd);
	        eventResponse.setETCData("custSeq", custSeq);
	          
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0302 : Save<br>
	 * Add and modify Customer Code.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse manageGstCustCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0302Event event = (EsmSam0302Event)e;
		CustMainBC command = new CustMainBCImpl();
		
		MdmCustomerVO[] mdmCustomerVOS = event.getMdmCustomerVOS();

		try {
			begin();
			log.debug("\nMULTI SC================================"+account.getUsr_id());
			
			//customerVOs[0].setCreUsrId(account.getUsr_id());
			//mdmCustomerVOs.add(customerVOs[0]);
			CustomerVO customerVo = command.manageGstCustCode(event.getCustomerIntgVO(), account);
			String custCntCd = mdmCustomerVOS[0].getCustCntCd();
			String custSeq = customerVo.getCustSeq();
			log.debug("\nIB Flag================================"+ event.getCreflag()); 
			
			if(customerVo.getFileSavId()!=null  && !"".equals(customerVo.getFileSavId())){
				command.mergeMdmCustSezCerti(customerVo);
			}
			
			if(customerVo.getIbflag() != null && customerVo.getIbflag().equals("U")){
				command.addCustHist(custCntCd, custSeq, account.getUsr_id());
			}

			commit();
			
	        eventResponse.setETCData("custCntCd", custCntCd);
	        eventResponse.setETCData("custSeq", custSeq);
	          
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	 /**
     * multi event process<br>
     * ESM_SAM_0306 On screen Code is stored as a multi<br>
     * 
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageCustPerfCode(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        CustGroupBC command = new CustGroupBCImpl();
        EsmSam0306Event event = (EsmSam0306Event) e;
        
        CustomerGroupCodeVO[] custGroupVOs = event.getCustomerGroupCodeVOS();
        
        try {
            begin();
            command.manageCustPerfCode(event.getCustomerPerformanceVO(), account);
            
            /** Customer Group **/
			for(int i = 0; custGroupVOs!=null && i<custGroupVOs.length; i++){
				custGroupVOs[i].setCustGrpId(event.getCustomerPerformanceVO().getCustGrpId());
	        }

	        if (custGroupVOs!=null){
	        	command.manageCustGroupCode(custGroupVOs, account);	
	        }
	        
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }


	/**
	 * ESM_SAM_0302 : Trade onChange<br>
	 * Trade checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkTrdCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustMainBC command = new CustMainBCImpl();
		String trdCd = new String();
		if(e instanceof EsmSam0302Event){
			EsmSam0302Event event = (EsmSam0302Event)e;
			trdCd = event.getTrdCd();
		}
		try{
			String result = command.checkTrdCode(trdCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * ESM_SAM_0302 : Country onChange<br>
	 * Country checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCntCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustMainBC command = new CustMainBCImpl();
		String cntCd = new String();
		if(e instanceof EsmSam0302Event){
			EsmSam0302Event event = (EsmSam0302Event)e;
			cntCd = event.getCustCntCd();
		}
		try{
			String result = command.checkCntCode(cntCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * ESM_SAM_0302 : International No onChange<br>
	 * International checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkIntlNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustMainBC command = new CustMainBCImpl();
		String intlNo = new String();
		if(e instanceof EsmSam0302Event){
			EsmSam0302Event event = (EsmSam0302Event)e;
			intlNo = event.getIntlNo();
		}
		try{
			String result = command.checkIntlNo(intlNo);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0302 : Location onChange<br>
	 * Location Code checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustMainBC command = new CustMainBCImpl();
		String locCd = new String();
		
		if(e instanceof EsmSam0302Event){
			EsmSam0302Event event = (EsmSam0302Event)e;
			locCd = event.getLocCd();
		}
		try{
			String result = command.checkLocCode(locCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0302 : OFC_CD onChange<br>
	 * OFC_CD checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkOfcCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustMainBC command = new CustMainBCImpl();
		String ofcCd = new String();
		
		if(e instanceof EsmSam0302Event){
			EsmSam0302Event event = (EsmSam0302Event)e;
			ofcCd = event.getOfcCd();
		}
		try{
			String result = command.checkOfcCode(ofcCd);
	
			if(result != null && !",".equals(result)){
				String[] arrResult = result.split(",");
				eventResponse.setETCData("result", arrResult[0]);
				eventResponse.setETCData("country", arrResult[1]);
			}else{
				eventResponse.setETCData("result", "");
				eventResponse.setETCData("country", "");
			}
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * ESM_SAM_0302 : Vendor onChange<br>
	 * Vendor Code checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVndrCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustMainBC command = new CustMainBCImpl();
		String vndrCd = new String();
		
		if(e instanceof EsmSam0302Event){
			EsmSam0302Event event = (EsmSam0302Event)e;
			vndrCd = event.getVndrSeq();
		}
		try{
			String result = command.checkVndrCode(vndrCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * ESM_SAM_0302 : Currency onChange<br>
	 * Currency checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCurrCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustMainBC command = new CustMainBCImpl();
		String currCd = new String();
		
		if(e instanceof EsmSam0302Event){
			EsmSam0302Event event = (EsmSam0302Event)e;
			currCd = event.getCapiCurrCd();
		}
		try{
			String result = command.checkCurrCode(currCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0302 : User Mdm Auth Check<br>
	 * Currency checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	private EventResponse checkUserMdmAuth(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustRequestBC command = new CustRequestBCImpl();
		
		try{
			String result = command.checkUserMdmAuth(account.getUsr_id());
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0302 : Group Customer Code onChange<br>
	 * Group Customer Code checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkGrpCustCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustMainBC command = new CustMainBCImpl();
		String grpCustCd = new String();
		
		if(e instanceof EsmSam0302Event){
			EsmSam0302Event event = (EsmSam0302Event)e;
			grpCustCd = event.getCustGrpId();
		}
		try{
			String result = command.checkGrpCustCode(grpCustCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * ESM_SAM_0302 : State Code onChange<br>
	 * State Code checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkStateCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustMainBC command = new CustMainBCImpl();
		String cntCd = new String();
		String steCd = new String();
		
		if(e instanceof EsmSam0302Event){
			EsmSam0302Event event = (EsmSam0302Event)e;
			cntCd = event.getCntCd();
			steCd = event.getSteCd();
		}
		try{
			String result = command.checkStateCode(steCd, cntCd);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * Customer Code checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCustCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustMainBC command = new CustMainBCImpl();
		String custCd = new String();
		
		if(e instanceof EsmSam0302Event){
		 	EsmSam0302Event event = (EsmSam0302Event)e;
			custCd = event.getCustCd();
		}
		try{
			String result = command.checkCustCode(custCd);
			if(result != null && !",,,,,,".equals(result)){
				String[] arrResult = result.split(",");
				eventResponse.setETCData("result", arrResult[0]);
				eventResponse.setETCData("srepcd", arrResult[1]);
				eventResponse.setETCData("grpidchk", arrResult[2]);
				eventResponse.setETCData("grpprmrychk", arrResult[3]);
				eventResponse.setETCData("loccd", arrResult[4]);
				eventResponse.setETCData("ofccd", arrResult[5]);
				eventResponse.setETCData("custnm", arrResult[6]);
			}else{
				eventResponse.setETCData("result", "");
				eventResponse.setETCData("srepcd", "");
				eventResponse.setETCData("grpidchk", "");
				eventResponse.setETCData("grpprmrychk", "");
				eventResponse.setETCData("loccd", "");
				eventResponse.setETCData("ofccd", "");
				eventResponse.setETCData("custnm", "");
			}
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	 /**
	 * 
	 * ESM_SAM_0302 : Sales Rep. Code Change<br>
	 * Sales Rep. Code checking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSlsRepCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustMainBC command = new CustMainBCImpl();
		String srepCd = new String();
		if(e instanceof EsmSam0302Event){
			EsmSam0302Event event = (EsmSam0302Event)e;
			srepCd = event.getSrepCd();
		}
		try{
			String result = command.checkSlsRepCode(srepCd);
			if(result != null && !",,,,".equals(result)){
				String[] arrResult = result.split(",");
				eventResponse.setETCData("result", arrResult[0]);
				eventResponse.setETCData("srep_nm", arrResult[1]);
				eventResponse.setETCData("ofc_cd", arrResult[2]);
				eventResponse.setETCData("mphn_no", arrResult[3]);
				eventResponse.setETCData("srep_eml", arrResult[4]);
			}else{
				eventResponse.setETCData("result", "");
				eventResponse.setETCData("srep_nm", "");
				eventResponse.setETCData("ofc_cd", "");
				eventResponse.setETCData("mphn_no", "");
				eventResponse.setETCData("srep_eml", "");
			}
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0302 : SEARCH<br>
	 * Customer retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkExistCustCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0302Event event = (EsmSam0302Event)e;
		CustMainBC command = new CustMainBCImpl();
		StringBuffer result = new StringBuffer("");
		try {
			List<CustomerVO> check = command.checkExistCustCode(event.getCustCntCd(), event.getCustSeq());
			
			if(check != null && check.size() > 0){
				for(int i = 0; i < check.size(); i++){
					result.append(check.get(i).getCustSeq());
					result.append(",");
				}
			}
			
			if("".equals(result.toString())){
				eventResponse.setETCData("result", "");
			}else{
				eventResponse.setETCData("result", result.toString().substring(0, result.toString().length()-1));
			}
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0306 : SEARCH<br>
	 * Customer Code retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustPerfCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0306Event event = (EsmSam0306Event)e;
		CustGroupBC command = new CustGroupBCImpl();
		
		try {
			CustomerPerformanceVO customerPerformanceVO = command.searchCustPerfCode(event.getCustomerPerformanceVO().getCustGrpId());
	        eventResponse.setRsVo(customerPerformanceVO);
	        
	        List<CustomerGroupCodeVO> list = command.searchCustGroupDetail(event.getCustomerPerformanceVO().getCustGrpId());
			eventResponse.setRsVoList(list);
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0307 : KeyMan List SEARCH<br>
	 * KeyMan List retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKeyManList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0307Event event = (EsmSam0307Event)e;
		KeyManInfoBC command = null;
		List<SamKeyManInfoVO> list = null;
		
		try {
			command = new KeyManInfoBCImpl();
	        list = command.searchKeyManList(event.getSamKeyManInfoVO());
			eventResponse.setRsVoList(list);
	          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0308 : Save<br>
	 * Add and modify Customer Code.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse manageKeyManList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0308Event event = (EsmSam0308Event)e;
		KeyManInfoBC receiptBC = new KeyManInfoBCImpl();
		SamKeyManInfoVO samKeyManInfoVO = event.getSamKeyManInfoVO();

		try {
			begin();
			log.debug("\nMULTI SC================================"+account.getUsr_id());

		        if (samKeyManInfoVO!=null){
		         receiptBC.manageKeyManList(samKeyManInfoVO, account);	
		        }
		        commit();
				eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
    
    
}