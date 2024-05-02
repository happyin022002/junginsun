/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGCommonSC.java
*@FileTitle : Common Utility
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.event.PricommonEvent;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.basic.SCGExternalFinderBC;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.basic.SCGExternalFinderBCImpl;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.event.ScgComExternalEvent;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.integration.SCGExternalFinderDBDAO;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo.BKGOutputVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo.CheckLaneVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo.SearchPortVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo.SearchVVDVO;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.basic.SCGInternalFinderBC;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.basic.SCGInternalFinderBCImpl;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.event.ScgComInternalEvent;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.CheckUNNumberVO;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.SearchImdgAmdtMstVO;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.SearchUNNumberVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCarrierVO;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmCntrTpVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.ScgImdgClssCdVO;
import com.clt.syscommon.common.table.ScgImdgCompGrpVO;
import com.clt.syscommon.common.table.ScgImdgSpclProviVO;
import com.clt.syscommon.common.table.ScgImdgUnNoVO;
import com.clt.syscommon.common.table.ScgIrrTpCdVO;

 
/**
 * OPUS-SCGCommon Business Logic ServiceCommand - Handling business transactions of SCGCommon.
 * 
 * @author
 * @see SCGExternalFinderDBDAO
 * @since J2EE 1.4
 */

public class SCGCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	 
	/**
	 * SCGCommon system preceding process for biz scenario<br>
	 * SCG_COM_ related objects creation<br>
	 */
	public void doStart() {
		try {
 
			// comment --> login check
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SCGCommon system biz scenario closing<br>
	 * SCG_COM_ clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("SCGCommonSC end");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// When SC handles multiple events
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
			/************* common code table retrieve by xml *************/
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchComCodeList(e);					
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchComCodeDescList(e);		
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchCompGrpUNClass(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				eventResponse = searchCNTRTP(e);
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
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchUNNo(e);				
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
            	/** Only Standard Amendment : One **/
				eventResponse = searchImdgAmdtMst(e);				
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
            	/** Only Activate Amendment : More than One **/
				eventResponse = searchImdgAmdtMstList(e);				
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchImdgAmdtNo(e);				
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchRSOforUser(e);				
            }
			
		} 
		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * UN No. retrieve <br>
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
			List<CheckUNNumberVO> list = command.checkUNNumber(event.getScgImdgUnNoVO());
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
	 * Class retrieve <br>
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
	 * Special Provisions retrieve <br>
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
	 * Carrier retrieve <br>
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
	 * Lane retrieve <br>
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
	 * Port retrieve <br>
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
	 * Irregular Type retrieve <br>
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
	 * Booking Number retrieve <br>
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
	 * B/L Number retrieve <br>
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
	 * VVD Code retrieve <br>
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
	 * Container Type Size retrieve <br>
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
	 * Codes of common code retrieve <br>
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
	 * UN Number retrieve <br>
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
			 * Irregular List retrieve 
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
	        eventResponse.setETCData("prp_shp_nm"       , vo.getPrpShpNm()        );      
	        eventResponse.setETCData("imdg_clss_cd"     , vo.getImdgClssCd()      );                
	        eventResponse.setETCData("imdg_clss_cd_desc", vo.getImdgClssCdDesc()  );       		
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
	 * Comp Group retrieve <br>
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
	 * UN Number of Comp Group retrieve <br>
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
	 * Codes of common code retrieve <br>
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
	 * Class Comp retrieve <br>
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
	 * Port inside VVD retrieve <br>
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
	 * TARGET LANE CODE between POL POD retrieve <br>
     *
     * @param e
     * @throws EventException
     * @return EventResponse
     * @author
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
	 * VOP_SCG_0021 : Retrieve <br>
	 * Container Type retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCNTRTP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComExternalEvent event = (ScgComExternalEvent)e;
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<MdmCntrTpVO> list = command.searchCNTRTP(event.getMdmCntrTpVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"CNTR TP"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0021 : Retrieve <br>
	 * UN No. Combo retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUNNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComInternalEvent event = (ScgComInternalEvent)e;
		SCGInternalFinderBC command = new SCGInternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CheckUNNumberVO> list = command.searchUNNo(event.getScgImdgUnNoVO());
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
	 * VOP_SCG_0002 : Retrieve <br>
	 * SCG_IMDG_AMDT_MST retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImdgAmdtMst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComInternalEvent event = (ScgComInternalEvent)e;
		SCGInternalFinderBC command = new SCGInternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<SearchImdgAmdtMstVO> list = command.searchImdgAmdtMst(event.getSearchImdgAmdtMstVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Imdg Amdt"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_SCG_0002 : Retrieve <br>
	 * SCG_IMDG_AMDT_MST List retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImdgAmdtMstList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComInternalEvent event = (ScgComInternalEvent)e;
		SCGInternalFinderBC command = new SCGInternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<SearchImdgAmdtMstVO> list = command.searchImdgAmdtMstList(event.getSearchImdgAmdtMstVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Imdg Amdt List"}).getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
	 * VOP_SCG_0002 : Retrieve <br>
	 * SCG_IMDG_AMDT_MST List retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImdgAmdtNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ScgComInternalEvent event = (ScgComInternalEvent)e;
		SCGInternalFinderBC command = new SCGInternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ScgImdgUnNoVO> list = command.searchImdgAmdtNo(event.getScgImdgUnNoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Imdg Amdt List"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_5011 : Retrieve <br>
	 * Login User RSO retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRSOforUser(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		SCGInternalFinderBC command = new SCGInternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String rgnShpOprCd = command.searchRSOforUser(account);
			eventResponse.setETCData("rgn_shp_opr_cd", 	rgnShpOprCd);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Login User RSO"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
}