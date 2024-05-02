/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DangerousCargoRestrictionSC.java
*@FileTitle : DG Restriction by Port (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.26 장강철
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2012.04.20 서석진 [CHM-201216960-01] Vessl Operator내 파일첨부 기능 추가
* 처리내역 :첨부파일 팝업화면과 팝업화면에서 파일등록,삭제 기능 추가
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.basic.CarrierRestrictionBC;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.basic.CarrierRestrictionBCImpl;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.event.VopScg0009Event;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.event.VopScg0079Event;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionOptionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.FileVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.PortRestrictionOptionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.ScgImdgCrrRstrVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.VopScg0009ConditionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.basic.PortRestrictionBC;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.basic.PortRestrictionBCImpl;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg0005Event;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg0011Event;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg0076Event;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg1005Event;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration.PortRestrictionDBDAO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestriction2VO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionDtlVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictonOptionVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.basic.SCGExternalFinderBC;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.basic.SCGExternalFinderBCImpl;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.basic.SCGInternalFinderBC;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.basic.SCGInternalFinderBCImpl;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.basic.SpecialCargoMasterDataMgtBC;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.basic.SpecialCargoMasterDataMgtBCImpl;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0042Event;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgPckInstrVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;


/**
 * ALPS-DangerousCargoRestriction Business Logic ServiceCommand - ALPS-DangerousCargoRestriction 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author jang kang cheol
 * @see PortRestrictionDBDAO
 * @since J2EE 1.6
 */

public class DangerousCargoRestrictionSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DangerousCargoRestriction system 업무 시나리오 선행작업<br>
	 * VOP_SCG_0005업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("DangerousCargoRestrictionSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DangerousCargoRestriction system 업무 시나리오 마감작업<br>
	 * VOP_SCG_0005 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DangerousCargoRestrictionSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-DangerousCargoRestriction system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
	    try{
    		EventResponse eventResponse = null;
    
    		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
    		if (e.getEventName().equalsIgnoreCase("VopScg0005Event")) {
    			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
    				eventResponse = searchPortRestriction(e  );
    			}	
    			/**
    			 * Save  Button 처리
    			 */						
    			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
    				eventResponse = managePortRestriction(e);
    			}
    			/** 
    			 * Delete  Button 처리
    			 */			
    			if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
    				eventResponse = removePortRestriction(e);
    			}
     	
     
    		}
    		if (e.getEventName().equalsIgnoreCase("VopScg1005Event")) {
     
    			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
    				eventResponse =  managePortRestrictionSaveAs(e );
    			}			
    		}
     
    		/**
    		 * VSL OPR's Restriction on DG (Creation)
    		 * 
    		 */
    		if (e.getEventName().equalsIgnoreCase("VopScg0009Event")) {
    			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
    				eventResponse = searchCarrierRestriction(e );
    			}
    			/**********************콤보코드등 초기화 **************************************/
    			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
    				eventResponse = searchCompGrpUNClassComeCode(e );
    			}		
     			
    			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
    				eventResponse = manageCarrierRestriction(e );
    			}
    		} 
    		/**
    		 * Port & VSL OPR’s Restriction En-route 메인 조회
    		 * 
    		 */
    		if (e.getEventName().equalsIgnoreCase("VopScg0011Event")) {
    			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
    				eventResponse = searchPortCarrierEnRouteList(e );
    			}
    			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
    				eventResponse = searchPortRotnSeq(e );
    			}
    		} 		
            /**
             * DG Prohibition Summary by Port
             * 
             */
            if (e.getEventName().equalsIgnoreCase("VopScg0076Event")) {
                if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                    eventResponse = searchPortRestrictionSummary(e );
                } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                    eventResponse = searchPortRestrictionSummary2(e );
                }
            }
           
            if (e.getEventName().equalsIgnoreCase("VopScg0079Event")) {

    			//SPCL CGO File 목록 조회
    			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
    				eventResponse = searchFileList(e);
    			}
    			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
   				 eventResponse = manageFile(e);
   			    } 
    			
            }
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    		
	}
	/**
	 * SCG_0005 : Save 처리 <br>
	 * PortRestriction Restriction 정보 일괄 저장처리 <br>
	 * 
	 * @param     Event e
	 * @return    EventResponse response
	 * @exception EventException
	 */
	private EventResponse managePortRestriction(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0005Event event = (VopScg0005Event)e;
		PortRestrictionBC command = new PortRestrictionBCImpl();
		try{
			begin();
			
			command.removePortRestriction(  event.getVopScg004ContainVO().getCondition() );			
			String sImdgPortRstrSeq = command.managePortRestriction(  event.getVopScg004ContainVO() , account);
			String msg = new ErrorHandler("SCG00001", new String[]{"Data"} ).getUserMessage();
 		
			eventResponse.setETCData("NEW_IMDG_PORT_RSTR_SEQ", sImdgPortRstrSeq);				
			eventResponse.setUserMessage( msg ); 
 
			commit();
 
			return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Restriction"}).getMessage(), ex);
        }

	}
	/**
	 * VOP_SCG_1005 : SAVE <br>
	 * PortRestriction의 Save As 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortRestrictionSaveAs(Event e ) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg1005Event event = (VopScg1005Event)e;
		PortRestrictionBC command = new PortRestrictionBCImpl();
		try{
			begin();
			int rslt = command.managePortRestrictionSaveAs( event.getCondition(), event.getSearchScgImdgPortRstrVOs() , account); 
			
			String msg = "";
			if (rslt == -1) {
				msg = new ErrorHandler("SCG00001", new String[]{"Data"} ).getUserMessage();	
			}else{
				msg = new ErrorHandler("SCG50033", new String[]{"Data"} ).getUserMessage();					
			}
			eventResponse.setUserMessage(msg);
			
			eventResponse.setETCData("row", Integer.toString(rslt));
			
			commit();
 
			return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Restriction Save As"}).getMessage(), ex);
        }
		
	}	
	/**
	 * VOP_SCG_0005 : Delete<br>
	 * Port Restriction내용을 삭제한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse response 
	 * @exception EventException
	 */
	private EventResponse removePortRestriction(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0005Event event = (VopScg0005Event)e;
		PortRestrictionBC command = new PortRestrictionBCImpl();
		try{
			begin();
			command.removePortRestriction(event.getVopScg004ContainVO().getCondition() );
            String msg = new ErrorHandler("SCG00006", new String[]{"Data"} ).getUserMessage();
 
			eventResponse.setUserMessage(msg);
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Restriction"}).getMessage(), ex);
        }

		return eventResponse;
	}
 
    /**
     * 
     * VOP_SCG-0005 : Retrieve <br>
     * Port Restriction 에 대한 조회처리 <br>
     *
     * @author jang kang cheol
     * @category searchPortRestriction
     * @param  Event e
     * @return EventResponse
     * @throws EventException
     */
	private EventResponse  searchPortRestriction(Event e  )  throws EventException{
	    try{
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0005Event event = (  VopScg0005Event)e;
     
    		PortRestrictionBC command = new PortRestrictionBCImpl();
    		PortRestrictonOptionVO portRestrictonOptionVO = event.getVopScg004ContainVO().getCondition();	
    		String optClass = (String)e.getAttribute("optClass");		
    		List<PortRestrictionVO> list = null;
    		String msg = "";
    		/*******************class로 조회시************************/
    		if(optClass.equals("class")){
    		    portRestrictonOptionVO.setImdgUnNo("");
    		    portRestrictonOptionVO.setImdgUnNoSeq("");			
    			list = command.searchPortRestriction( portRestrictonOptionVO );
    			if(list.size() == 0){
    			    msg = new ErrorHandler("SCG00034").getUserMessage();
    			}
    		}else if(optClass.equals("unno")){
    			/*******************Un No로 조회시**************************************************
    			 * 1. Class로 조회와는 달리 UN No로 조회할경우, 
    			 *    1) 데이타가 없으면, 해당 Class Code를 찾아서 Class Code 로 조회한다.
    			 * 	 
    			 * ※ SCG00034 : No data found !  Do you want to insert new data ?
    			 *               UnNo 조회 ->Get  Class Code -> Class Code로 조회시
    			 *                 [if rs.size == 0 ] 일때,
    			 * ※ SCG00035 : This UN No./Seq. restriction is based on Class restriction.
    			 *               UnNo 조회 ->Get Class Code  -> Class Code로 조회시
    			 *                 [if rs.size > 0 ] 일때,
    			 ***********************************************************************************/
    		    portRestrictonOptionVO.setImdgClssCd("");	
    			list = command.searchPortRestriction( portRestrictonOptionVO );
    			String[] classcd = command.getImdgClssCd(  portRestrictonOptionVO.getImdgUnNo(), portRestrictonOptionVO.getImdgUnNoSeq() );
    			eventResponse.setETCData("imdg_clss_cd"     , classcd [0] );				
    			eventResponse.setETCData("imdg_clss_cd_desc", classcd [1] );
                eventResponse.setETCData("NO_DATA_MSG"      , "" );
    			if( list.size() == 0){
    
    				if( classcd[0].equals("") ){
    					eventResponse.setETCData("NO_DATA_MSG", "NO_DATA" );	 
    					msg = new ErrorHandler("SCG00034").getUserMessage();		
    					eventResponse.setUserMessage(msg);
    					return eventResponse;	
    				}else{
    					/*******************Un No로 조회해서 DATA가 존재하지 않을시 UNNO테이블에서 CLASSCD추출***************/
    				    portRestrictonOptionVO.setImdgClssCd( classcd [0] );
    				    portRestrictonOptionVO.setImdgUnNo("");
    				    portRestrictonOptionVO.setImdgUnNoSeq("");						
    					list = command.searchPortRestriction( portRestrictonOptionVO );
    					eventResponse.setETCData("imdg_clss_cd"     , classcd [0] );				
    					eventResponse.setETCData("imdg_clss_cd_desc", classcd [1] );
    					
    					if( list.size() > 0){
    						eventResponse.setETCData("NO_DATA_MSG", "USE_UNNO" );
    						msg = new ErrorHandler("SCG00035").getUserMessage();		
    						eventResponse.setUserMessage(msg);						
    					}else{
    						eventResponse.setETCData("NO_DATA_MSG", "NO_DATA" );	
    						msg = new ErrorHandler("SCG00034").getUserMessage();		
    						eventResponse.setUserMessage(msg);
    						return eventResponse;	
    					}
    				}
    			}
    		}		
     
     
    		String sImdgPortRstrSeq = "";
    		//2015.08.17 Secure Coding 적용 [CWE-476] Null Dereferencing
    		if ( list != null ) {
	    		if ( list.size()!=0 ) {
	    			sImdgPortRstrSeq = list.get(0).getImdgPortRstrSeq();
	    		}
    		}
    		portRestrictonOptionVO.setImdgPortRstrSeq( sImdgPortRstrSeq  );
    
    		
    		if( msg.equals("") ){
    			msg = "NO_DATA";
    		}
    		
    		//2015.08.17 Secure Coding 적용 [CWE-476] Null Dereferencing
    		if ( list != null ) {
	    		if( list.size() == 0 ){
	    			eventResponse.setUserMessage(msg);
	    			return eventResponse;	
	    		}
    		}else{
    			eventResponse.setUserMessage(msg);
    			return eventResponse;	
    		}
    		List<PortRestrictionDtlVO> list2 = command.searchPortRestrictionDetail( portRestrictonOptionVO );		
    		eventResponse.setRsVoList( list );
    		eventResponse.setRsVoList( list2 );
    		eventResponse.setRsVoList( list2 );
    		eventResponse.setRsVoList( list2 );
    		eventResponse.setRsVoList( list2 );		
    		return eventResponse;		
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Restriction"}).getMessage(), ex);
        }
		
	}
 
	/**
	 * VOP_SCG-0009: Retrieve <br>
	 * Carrier Retriection의 내용을 조회한다.<br>
	 * 
	 * @param ScgImdgClssCdListVO   scgImdgClssCdListVO
	 * @return List<ScgImdgClssCdListVO>
	 * @exception EventException
	 */
	private EventResponse  searchCarrierRestriction(Event e)  throws EventException{
	    try{
    		GeneralEventResponse eventResponse      = new GeneralEventResponse();
    		VopScg0009Event event                   = (VopScg0009Event)e;
    		CarrierRestrictionBC command            = new CarrierRestrictionBCImpl();
     
    		 List<CarrierRestrictionVO>  list = null;
     
    		CarrierRestrictionOptionVO  cont = event.getContainer();
    		VopScg0009ConditionVO vopScg0009ConditionVO =cont.getCondition();
     
    		list = command.searchCarrierRestriction( cont );
    		String fimename = command.searchFileName(vopScg0009ConditionVO.getCrrCd());
    		eventResponse.setRsVoList( list );
    		eventResponse.setETCData("fimename", fimename );
     
            if( cont.getMsgCode()== "COM10001" ){   
    			eventResponse.setUserMessage( new ErrorHandler( cont.getMsgCode(),new String[]{""} ).getUserMessage()  );            	
            }
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Restriction"}).getMessage(), ex);
        }
	}	
	/**
	 * VOP_SCG_0009 : OPEN
	 * Carrier Restriction Open시 MultiCombo 기본셋팅작업을위한 Group UNClass 조회 
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCompGrpUNClassComeCode(Event e) throws EventException {
	    try{
    		VopScg0009Event event = (VopScg0009Event)e;		
 
    		SCGInternalFinderBC command2 = new SCGInternalFinderBCImpl();
            SCGExternalFinderBC command = new SCGExternalFinderBCImpl();    		
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    
    		List<ScgImdgClssCdVO> list2 = command2.searchUNClass();
    		eventResponse.setRsVoList(list2);
            String exceptKey = event.getExceptKey();
            String codeinfo = command.getCodeSelect(event.getAttribute("code").toString(), 0, exceptKey );

    		eventResponse.setETCData("codeinfo",  codeinfo);
    		
    	    exceptKey="";
    	    String codeinfoAll =  command.getCodeSelect(event.getAttribute("code").toString(), 0, exceptKey );

            eventResponse.setETCData("codeinfoAll", codeinfoAll);		
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Comp Group UNClass"}).getMessage(), ex);
        }
	}
	/**
	 * VOP_SCG_0009: SAVE <br>
	 * Carrier Restiction 입력한 내용을 저장한다.
	 *  
	 * @param     Event e 
	 * @return    EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageCarrierRestriction(Event e ) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0009Event event = (VopScg0009Event)e;
		CarrierRestrictionBC command = new CarrierRestrictionBCImpl();
		CarrierRestrictionOptionVO  cont = null;
 
		try{
			begin();
			    cont = event.getContainer();
				command.manageCarrierRestriction(   cont , account);
				if( cont.getMsgCode() != null && cont.getMsgCode() != ""){
					if( cont.getMsgCode().equals( "SCG50005") ){
					   eventResponse.setUserMessage(new ErrorHandler("SCG50005",new String[]{"Data"}).getUserMessage() );
					}
				}else{ 
		            String msg = new ErrorHandler("SCG00001", new String[]{"Data"} ).getUserMessage();
		            eventResponse.setUserMessage( msg );
					eventResponse.setRsVoList(cont.getList());					
				}

 			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Carrier Restriction"}).getMessage(), ex);
        }
		return eventResponse;
	}
 
 
	/**
	 * 
     * VOP_SCG_0011 : Retrieve 
     * Port & VSL OPR’s Restriction En-route 조회 <br>
     * 
	 * @param  Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchPortCarrierEnRouteList(Event e) throws EventException {
	    try{
    		VopScg0011Event event = (VopScg0011Event)e;
    		//PortRestrictionBC 		command1 = new PortRestrictionBCImpl();
    		CarrierRestrictionBC 	command2 = new CarrierRestrictionBCImpl();
     
            List<ScgImdgCrrRstrVO> list1 = null;
            List<PortRestrictionOptionVO> list2 = null;        
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
     
     
    		PortRestrictionOptionVO portRestrictionOptionVO = event.getContition();
    					
    		list2 = command2.searchPortEnRouteList(    portRestrictionOptionVO  );
    		
    		String imdgClsscd     = portRestrictionOptionVO.getImdgClssCd();
    		portRestrictionOptionVO.setImdgClssCd("");
    		
    		list1 = command2.searchCarrierEnRouteList( portRestrictionOptionVO  );	
    		if( list1.size()  == 0){
    		    portRestrictionOptionVO.setImdgClssCd( imdgClsscd );
    		    portRestrictionOptionVO.setImdgUnNo   ("");
    		    portRestrictionOptionVO.setImdgUnNoSeq("");
    	        list1 = command2.searchCarrierEnRouteList( portRestrictionOptionVO  );    
    	        eventResponse.setETCData("SEARCH_METHOD","class");
    		}else{
    		    eventResponse.setETCData("SEARCH_METHOD","unno");
    		}
    		
    
    		eventResponse.setRsVoList(list1);
    		eventResponse.setRsVoList(list2);		
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Carrier EnRouteList"}).getMessage(), ex);
        }
	}	 

	/**
	 * 
     * VOP_SCG_0011 : Retrieve 
     * Port & VSL OPR’s Restriction En-route 조회 <br>
     * 
	 * @param  Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchPortRotnSeq(Event e) throws EventException {
	    try{
    		VopScg0011Event event = (VopScg0011Event)e;
    		CarrierRestrictionBC 	command = new CarrierRestrictionBCImpl();
     
            List<PortRestrictionOptionVO> list = null;
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
     
     
    		PortRestrictionOptionVO portRestrictionOptionVO = event.getContition();
    					
    		list = command.searchPortRotnSeq(   portRestrictionOptionVO  );
    		
    		eventResponse.setRsVoList(list);

    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Carrier EnRouteList"}).getMessage(), ex);
        }
	}	 

	/**
     * VOP_SCG_0076 : Retrieve
     * DG Prohibition Summary by Port 을 조회 합니다.<br>
     *
     * @param  Event  e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchPortRestrictionSummary(Event e) throws EventException {
        try{
            VopScg0076Event event = (VopScg0076Event)e;     
            PortRestrictionBC command = new PortRestrictionBCImpl();
     
            List<PortRestrictionVO> list1 = null;        
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            PortRestrictonOptionVO portRestrictonOptionVO = event.getPortRestrictonOptionVO();
            list1 = command.searchPortRestrictionSummary( portRestrictonOptionVO  );             
            eventResponse.setRsVoList(list1);
        
            return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG Prohibition Summary by Port"}).getMessage(), ex);
        }
    }   

	/**
     * VOP_SCG_0076 : Retrieve
     * DG Restriction Summary by Port 을 조회 합니다.<br>
     *
     * @param  Event  e
     * @throws EventException
     * @return EventResponse
     * @author
     */
	private EventResponse searchPortRestrictionSummary2(Event e) throws EventException {
        try{
            VopScg0076Event event = (VopScg0076Event)e;
            PortRestrictionBC command = new PortRestrictionBCImpl();

            List<PortRestriction2VO> list1 = null;
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            PortRestrictonOptionVO portRestrictonOptionVO = event.getPortRestrictonOptionVO();
            list1 = command.searchPortRestrictionSummary2( portRestrictonOptionVO );
            eventResponse.setRsVoList(list1);

            return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG Restriction Summary by Port"}).getMessage(), ex);
        }
    }

	/**
	 * VOP_SCG_0079 : Retrieve <br>
	 * Vessel Operator's Restriction on DG file 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFileList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
			VopScg0079Event event = (VopScg0079Event)e;
			CarrierRestrictionBC command = new CarrierRestrictionBCImpl();
			
			List<FileVO> list = command.searchFileList(event.getFileVO().getVslOprTpCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(list);			
			
			return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Operator's Restriction on DG"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0079 : Save <br>
	 * Vessel Operator's Restriction on DG file 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFile(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0079Event event = (VopScg0079Event)e;

		CarrierRestrictionBC command = new CarrierRestrictionBCImpl();
		try{
			begin();
			
			command.manageFile(event.getFileVOs(), event.getKeys(), account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel Operator's Restriction on DG"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	

}
