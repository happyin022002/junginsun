/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGCommonSC.java
*@FileTitle : 공통유틸
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.15 이도형
* 1.0 Creation
* 
* History
* 2012.12.17 진마리아 [CHM-201221863-01] [VOP-SCG] Application Detail for Own BKG 에 combine, split 정보 추가
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.event.PricommonEvent;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.basic.SCGExternalFinderBC;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.basic.SCGExternalFinderBCImpl;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.event.ScgComExternalEvent;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration.SCGExternalFinderDBDAO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.BKGOutputVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.CheckLaneVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.SearchPortVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.SearchVVDVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.basic.SCGInternalFinderBC;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.basic.SCGInternalFinderBCImpl;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.event.ScgComInternalEvent;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.vo.CheckUNNumberVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.vo.SearchUNNumberVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.vo.CheckPckCdVO;
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
import com.hanjin.syscommon.common.table.MdmCarrierVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgSpclProviVO;
import com.hanjin.syscommon.common.table.ScgImdgUnNoVO;
import com.hanjin.syscommon.common.table.ScgIrrTpCdVO;

 
/**
 * ALPS-SCGCommon Business Logic ServiceCommand - ALPS-SCGCommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Dohyoung Lee
 * @see SCGExternalFinderDBDAO
 * @since J2EE 1.4
 */

public class SCGCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	 
	/**
	 * SCGCommon system 업무 시나리오 선행작업<br>
	 * SCG_COM_업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * SCGCommon system 업무 시나리오 마감작업<br>
	 * SCG_COM_ 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SCGCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SCGCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("ScgComExternalEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkCarrier(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLane(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkBKG(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkBL(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchVVD(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchCNTRTPSZ(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchCompGrp(e);		
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchClassComp(e);	
			}if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = checkPort(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchPort(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
                eventResponse = searchTargetLane(e);				
			/*************************공통 코드테이블 xml로 가져오기 ********/
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchComCodeList(e);					
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchComCodeDescList(e);		
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchCompGrpUNClass(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchOfcRso(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = checkUserRole(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchBkgHistory(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("ScgComInternalEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkUNNumber(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchUNClass(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkSpclProvi(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchIrregularType(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchUNNumber(e);				
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchImdgUnNoSeqList(e);				
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchClassSubRiskPGData(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = checkPckCd(e);
			}
			
		} 
		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * UN No.를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkUNNumber(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComInternalEvent event = (ScgComInternalEvent)e;
		SCGInternalFinderBC command = new SCGInternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CheckUNNumberVO> list = command.checkUNNumber(event.getScgImdgUnNoVO().getImdgUnNo());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"UN No."}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * Class 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUNClass(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//ScgComInternalEvent event = (ScgComInternalEvent)e;
		SCGInternalFinderBC command = new SCGInternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ScgImdgClssCdVO> list = command.searchUNClass();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Class"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * Special Provisions 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSpclProvi(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComInternalEvent event = (ScgComInternalEvent)e;
		SCGInternalFinderBC command = new SCGInternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ScgImdgSpclProviVO> list = command.checkSpclProvi(event.getScgImdgSpclProviVO().getImdgSpclProviNo());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * Carrier 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCarrier(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComExternalEvent event = (ScgComExternalEvent)e;
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<MdmCarrierVO> list = command.checkCarrier(event.getMdmCarrierVO().getCrrCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Code"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * Lane 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComExternalEvent event = (ScgComExternalEvent)e;
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<MdmVslSvcLaneVO> list = command.checkLane(event.getMdmVslSvcLaneVO().getVslSlanCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Lane Code"}).getMessage(), ex);
		}		
		return eventResponse;
	}


	/**
	 * VOP_SCG_0005 : Retrieve <br>
	 * Port 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPort(Event e) throws EventException { 
		// PDTO(Data Transfer Object including Parameters)
		ScgComExternalEvent event = (ScgComExternalEvent)e;
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String  portCodeNm = command.checkPort( (String)event.getAttribute("port_cd"));
			if( portCodeNm.equals("")){
				eventResponse.setUserMessage( new ErrorHandler("SCG50010", new String[]{"Port Code"} ).getUserMessage() );
			}      
			eventResponse.setETCData("port_cd_nm", portCodeNm);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Code"}).getMessage(), ex);
		}		
		return eventResponse;
	}
 	
	
	/**
	 * VOP_SCG_0013 : Retrieve <br>
	 * Irregular Type 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrregularType(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComInternalEvent event = (ScgComInternalEvent)e;
		SCGInternalFinderBC command = new SCGInternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ScgIrrTpCdVO> list = command.searchIrregularType(event.getScgIrrTpCdVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Irregular Type"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0013 : Retrieve <br>
	 * Booking Number 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkBKG(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComExternalEvent event = (ScgComExternalEvent)e;
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<BKGOutputVO> list = command.checkBKG(event.getBkgBookingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Booking"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0013 : Retrieve <br>
	 * B/L Number 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkBL(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComExternalEvent event = (ScgComExternalEvent)e;
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<BKGOutputVO> list = command.checkBKG(event.getBkgBookingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"BL No"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0013 : Retrieve <br>
	 * VVD Code 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComExternalEvent event = (ScgComExternalEvent)e;
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<SearchVVDVO> list = command.searchVVD(event.getVskVslSkdVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"VVD Code"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0013 : Retrieve <br>
	 * Container Type Size 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCNTRTPSZ(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComExternalEvent event = (ScgComExternalEvent)e;
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<MdmCntrTpSzVO> list = command.searchCNTRTPSZ(event.getMdmCntrTpSzVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"CNTR TPSZ"}).getMessage(), ex);
		}
		return eventResponse;
	}
	   
	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * 공통코드에 대한 코드 를 조회 합니다. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
 	private EventResponse searchComCodeDescList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PricommonEvent event = (PricommonEvent)e;
		CodeUtil cdUtil = CodeUtil.getInstance();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect(event.getRsltCdListVO().getCd(),0);
			List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
			for (int i = 0; i < cdList.size(); i++) {
				RsltCdListVO rsltcdlistvo = new RsltCdListVO() ;
				rsltcdlistvo.setCd(cdList.get(i).getCode());			
				rsltcdlistvo.setNm(cdList.get(i).getName());			
				list.add(rsltcdlistvo);
			}
			eventResponse.setRsVoList(list);

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"CNTR TPSZ"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * UN Number 를 조회 합니다. <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchUNNumber(Event e) throws EventException {
 
		ScgComInternalEvent event = (ScgComInternalEvent)e;
		SCGInternalFinderBC command = new SCGInternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<SearchUNNumberVO> list = command.searchUNNumber(event.getSearchUNNumberVO()); 
	        if(list.size()>0){
	            list.get(0).setMaxRows( Integer.parseInt( command.searchUNNumberTotalCnt( event.getSearchUNNumberVO()) ) );
	        }
			eventResponse.setRsVoList(list);
			
			/**************************************************************************************
			 * Irregular List 조회 
			 **************************************************************************************/
			String irregular_reg_yn = "N";
	        if(   event.getSearchUNNumberVO().getImdgUnNoHldFlg() != null 
	           && event.getSearchUNNumberVO().getImdgUnNoHldFlg().equals("Y")  ){
	            List<SearchUNNumberVO> irrlist = command.checkIrrUnNoList( event.getSearchUNNumberVO() );
	            if( irrlist.size() > 0 ){
	                irregular_reg_yn = "Y";
	            }
	        }
	        
			SearchUNNumberVO vo = null;
			if( list.size() == 0){
			    vo = new SearchUNNumberVO();
			}else{
			    vo = list.get(0);
			}
	        eventResponse.setETCData("irregular_reg_yn" , irregular_reg_yn        );     
	        if ( vo != null ) {
		        eventResponse.setETCData("prp_shp_nm"       , vo.getPrpShpNm()        );      
		        eventResponse.setETCData("imdg_clss_cd"     , vo.getImdgClssCd()      );                
		        eventResponse.setETCData("imdg_clss_cd_desc", vo.getImdgClssCdDesc()  );
	        } 
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG UN No"}).getMessage(), ex);
		}
		return eventResponse;
		
	}	 
	
	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * Comp Group 을 조회 합니다. <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCompGrp(Event e) throws EventException {
 
		ScgComExternalEvent event = (ScgComExternalEvent)e;
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String imdgCompGrpCd = "";
		try {
			if( e.getAttribute("GRP_CD") != null ){
				imdgCompGrpCd =  event.getAttribute("GRP_CD").toString();
			}
			List<ScgImdgCompGrpVO> list = command.searchCompGrp( imdgCompGrpCd );
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Compatibility Group"}).getMessage(), ex);
		}
		return eventResponse;
	}		
	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * Comp Group에 대한 UN Number 를 조회 합니다. <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCompGrpUNClass(Event e) throws EventException {
 		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
		SCGInternalFinderBC command2 = new SCGInternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ScgImdgCompGrpVO> list = command.searchCompGrp( "" );		
			List<ScgImdgClssCdVO> list2 = command2.searchUNClass();
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Compatibility Group / Class Code"}).getMessage(), ex);
		}
		return eventResponse;
	}		
	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * 공통코드에 대한 코드 를 조회 합니다. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
 
	private EventResponse searchComCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		ScgComExternalEvent event = (ScgComExternalEvent)e;
 		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
 		try {
			String codeinfo = command.getCodeSelect( event.getCodeInfo().getCode(), 0,"" ); 		
			eventResponse.setETCData("codeinfo", codeinfo);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"CodeInfo"}).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * Class Comp 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchClassComp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComExternalEvent event = (ScgComExternalEvent)e;
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ScgImdgCompGrpVO> list = command.searchClassComp(event.getScgImdgCompGrpVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"CompGroup"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * VVD내의 Port 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComExternalEvent event = (ScgComExternalEvent)e;
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<SearchPortVO> list = command.searchPort(event.getSearchPortVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Code"}).getMessage(), ex);
		}
		return eventResponse;
	}
    /**
     * VOP_SCG_0001 : Retrieve <br>
	 * POL과 POD 사이의 TARGET LANE CODE 를 조회 합니다. <br>
     *
     * @param e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchTargetLane(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        ScgComExternalEvent event = (ScgComExternalEvent)e;
        SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
	        List<CheckLaneVO> list = command.searchTargetLane(event.getPolSlanCd(), event.getPodSlanCd());
	        eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Target Lane"}).getMessage(), ex);
		}
        return eventResponse;
    }

	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * 공통코드에 대한 코드 를 조회 합니다. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
 	private EventResponse searchImdgUnNoSeqList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComInternalEvent event = (ScgComInternalEvent)e;
		SCGInternalFinderBC command = new SCGInternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ScgImdgUnNoVO> list = command.searchImdgUnNoSeqList(event.getScgImdgUnNoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Irregular Type"}).getMessage(), ex);
		}		
		return eventResponse;
	}
    
	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * 공통코드에 대한 코드 를 조회 합니다. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
 	private EventResponse searchClassSubRiskPGData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComInternalEvent event = (ScgComInternalEvent)e;
		SCGInternalFinderBC command = new SCGInternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<PartnerApprovalRequestVO> list = command.searchClassSubRiskPGData(event.getScgImdgUnNoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Irregular Type"}).getMessage(), ex);
		}		
		return eventResponse;
	}
    
	/**
	 * VOP_OPF_0033 : Office Rso<br>
	 * 로그인사용자의 소속오피스에 해당되는 RSO 찾기 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcRso(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// VopOpf0033Event event = (VopOpf0033Event)e;
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();

		try{
			String rso = command.searchOfcRso(account);
			eventResponse.setETCData("rso", rso);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * 로그인사용자의 USR_ROLE_CD 검색 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkUserRole(Event e) throws EventException {
        ScgComExternalEvent event = (ScgComExternalEvent)e;
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// VopOpf0033Event event = (VopOpf0033Event)e;
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();

		try{
			String userRoleCd = command.checkUserRole(event.getPgmNo(), account);
			if (userRoleCd.equals("")) {
				userRoleCd = "RET";
			}
			eventResponse.setETCData("user_role_cd", userRoleCd);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * VOP_SCG_0015, VOP_SCG_0016 open <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgHistory(Event e) throws EventException {
		ScgComExternalEvent event = (ScgComExternalEvent)e;
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
		
		try{
			String[] hisData = command.searchBkgHistory(event.getBkgNo());
			eventResponse.setETCData("bkg_combine", hisData[0]);
			eventResponse.setETCData("bkg_split", hisData[1]);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * SCG_COM_INTERNAL : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPckCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ScgComInternalEvent event = (ScgComInternalEvent)e;
		SCGInternalFinderBC command = new SCGInternalFinderBCImpl();

		try{
			List<CheckPckCdVO> list = command.checkPckCd(event.getScgPckInstrVO().getImdgPckInstrCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}	
}