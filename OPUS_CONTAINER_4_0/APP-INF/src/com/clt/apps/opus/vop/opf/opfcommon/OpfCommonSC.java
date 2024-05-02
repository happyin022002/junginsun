/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfCommonSC.java
*@FileTitle : OpfUtil Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.basic.OpfUtilBC;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.basic.OpfUtilBCImpl;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.event.OpfutilEvent;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration.OpfUtilDBDAO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfXterCdConvVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.RdrRgnCdVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.SearchVVDVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;


/**
 * OPUS-OpfCommon Business Logic ServiceCommand - Handling business transaction about OPUS-OpfCommon 
 * 
 * @author 
 * @see OpfUtilDBDAO
 * @since J2EE 1.4
 */

public class OpfCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * OpfCommon system preceding process for biz scenario<br>
	 * OpfUtil related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * OpfCommon system biz scenario closing<br>
	 * OpfUtil clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("OpfCommonSC 종료");
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// Part of using in case SC handles many events
		if (e.getEventName().equalsIgnoreCase("OpfutilEvent")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommonCode(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLane(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkLane(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkCarrier(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchVvdYard(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchVVD(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchContainer(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchVskVslPortList(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchCntrTpSzList();
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchComboGeneral(e);
            }
            else if(e.getFormCommand().isCommand(FormCommand.SEARCH11)) {//Vvd Port Info.
                eventResponse = searchVvdPort(e);
            }
            else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)) {//Port Valid Check
                eventResponse = searchPortInfo(e);
            }
            else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)) {//Container No Validation Check
            	eventResponse = searchCntrNoValid(e);                
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH14)) {//Region Code
				eventResponse = searchRegion(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH15)) {//Responsible Party Code
				eventResponse = searchParty(e);
			}
			

			
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve OPF Combo를 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private  EventResponse searchCommonCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfutilEvent event = (OpfutilEvent)e;
		OpfUtilBC command = new OpfUtilBCImpl();
		OpfComboVO opfComboVO = event.getOpfComboVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			String[] arrCdVal = opfComboVO.getComboCd().split(",");

			for(int cnt = 0; cnt < arrCdVal.length; cnt++){
				List<OpfComboVO> list = command.searchCombo(arrCdVal[cnt]);
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Common Code"}).getMessage(), ex);
		}		

        return eventResponse;
	}

	/**
	 * Retrieve I-Stowge Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private  EventResponse searchComboGeneral(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfutilEvent event = (OpfutilEvent)e;
		OpfUtilBC command = new OpfUtilBCImpl();
		OpfComboVO opfComboVO = event.getOpfComboVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			String[] arrCdVal = opfComboVO.getComboCd().split(",");
			
			for(int cnt = 0; cnt < arrCdVal.length; cnt++){
				List<OpfComboVO> list = command.searchComboGeneral(arrCdVal[cnt]);
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"I-Stowge Common Code"}).getMessage(), ex);
		}		
		
		return eventResponse;
	}	
	
	/**
	 * Retrieve Lane Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private  EventResponse searchLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfUtilBC command = new OpfUtilBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MdmVslSvcLaneVO condi = new MdmVslSvcLaneVO();
		try{
			List<MdmVslSvcLaneVO> list = command.searchLane(condi);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"search Lane"}).getMessage(), ex);
		}		
		
		return eventResponse;
	}
	
	/**
	 * Retrieve whether Lane Code is right  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfutilEvent event = (OpfutilEvent)e;
		OpfUtilBC command = new OpfUtilBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<OpfComboVO> list = command.checkLane(event.getMdmVslSvcLaneVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"search Lane"}).getMessage(), ex);
		}		
		
		return eventResponse;
	}
	
	/**
	 * Retrieve whether Carrier Code is right <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCarrier(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfutilEvent event = (OpfutilEvent)e;
		OpfUtilBC command = new OpfUtilBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<OpfComboVO> list = command.checkCarrier(event.getVskCarrierVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Check Carrier"}).getMessage(), ex);
		}		
		
		return eventResponse;
	}
	
	/**
	 * Retrieve Yard in VVD Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdYard(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfutilEvent event = (OpfutilEvent)e;
		OpfUtilBC command = new OpfUtilBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<OpfComboVO> list = command.searchVvdYard(event.getVskVslPortSkd());
			StringBuffer strClptIndSeq = new StringBuffer();
			
			for(int i=0;i<list.size();i++){
				if(i == 0 )
				{
					strClptIndSeq.append(((OpfComboVO)list.get(i)).getClptIndSeq());
				}
				else
				{
					strClptIndSeq.append("|" + ((OpfComboVO)list.get(i)).getClptIndSeq());
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("strClptIndSeq", strClptIndSeq.toString() );
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Search VVD Yard"}).getMessage(), ex);
		}		
		
		return eventResponse;
	}
	
	/**
	 *  Retrieve whether VVD exist. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfutilEvent event = (OpfutilEvent)e;
		OpfUtilBC command = new OpfUtilBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchVVDVO> list = command.searchVVD(event.getVskVslSkdVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Search VVD Yard"}).getMessage(), ex);
		}		
		
		return eventResponse;
	}

	/**
	 * Retrieve whether Container exist <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfutilEvent event = (OpfutilEvent)e;
		OpfUtilBC command = new OpfUtilBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<BkgContainerVO> list = command.searchContainer(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Container"}).getMessage(), ex);
		}		
		
		return eventResponse;
	}

	/**
	 * Retrieve Port by VVD <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVskVslPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfutilEvent event = (OpfutilEvent)e;
		OpfUtilBC command = new OpfUtilBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<OpfComboVO> list = command.searchVskVslPortList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
			
			TerminalDepartureReportCondVO condVo = event.getTerminalDepartureReportCondVO();
/*
			condVo.setContiCd("1");
			List<OpfComboVO> list1 = command.searchVskVslPortLoadVolList(condVo);
			eventResponse.setRsVoList(list1);
			
			condVo.setContiCd("2");
			List<OpfComboVO> list2 = command.searchVskVslPortLoadVolList(condVo);
			eventResponse.setRsVoList(list2);
*/
			condVo.setContiCd("");
			List<OpfComboVO> list3 = command.searchVskVslPortLoadVolList(condVo);
			eventResponse.setRsVoList(list3);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Search POD"}).getMessage(), ex);
		}		
		
		return eventResponse;
	}
	/**
	 * Retrieve Container Type/Size  <br>
	 * 
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	private EventResponse searchCntrTpSzList() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfUtilBC command = new OpfUtilBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<OpfComboVO> list = command.searchCntrTpSzList();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Type/Size"}).getMessage(), ex);
		}		

		return eventResponse;
	}
    /**
     * Retrieve Port in VVD Code <br>
     * 
     * @param  Event e
     * @return  EventResponse response
     * @exception EventException
     */
    private EventResponse searchVvdPort(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        OpfutilEvent event = (OpfutilEvent)e;
        OpfUtilBC command = new OpfUtilBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<OpfUtilSearchOptVO> list = command.searchVvdPort(event.getOpfUtilSearchOptVO() );
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search VVD Port"}).getMessage(), ex);
        }       
        
        return eventResponse;
    }
    
    /**
     * Retrieve Port Info <br>
     * 
     * @param  Event e
     * @return  EventResponse response
     * @exception EventException
     */
    private EventResponse searchPortInfo(Event e) throws EventException {
        OpfutilEvent event = (OpfutilEvent)e;
        OpfUtilBC command = new OpfUtilBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<OpfComboVO> list = command.searchPortInfo(event.getOpfUtilSearchOptVO() );
 
            if(list.size() == 1){
                OpfComboVO opfComboVO = list.get(0);
                eventResponse.setETCData(  opfComboVO.getColumnValues() );
            }

            eventResponse.setRsVoList(list);
            
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Info"}).getMessage(), ex);
        }       
        return eventResponse;
    }
    
	/**
	 * Retrieve checking whether validation of Container No<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrNoValid(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			OpfutilEvent event = (OpfutilEvent)e;
			OpfUtilBC command = new OpfUtilBCImpl();

			List<OpfComboVO> list = command.searchCntrNoValid(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Container No Validation Check"}).getMessage(), ex);
		}		
		
		return eventResponse;
	}
	
	/**
	 * Retrieve Region Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private  EventResponse searchRegion(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfUtilBC command = new OpfUtilBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RdrRgnCdVO condi = new RdrRgnCdVO();
		try{
			List<RdrRgnCdVO> list = command.searchRegion(condi);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"search Region"}).getMessage(), ex);
		}		
		
		return eventResponse;
	}
	
	/**
	 * Retrieve Responsible Party Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchParty(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfutilEvent event = (OpfutilEvent)e;
		OpfUtilBC command = new OpfUtilBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<OpfXterCdConvVO> list = command.searchParty(event.getVskCarrierVO());
			if(list.size() == 0){
				eventResponse.setETCData("value", "Z");	
			}else{
				eventResponse.setETCData("value", list.get(0).getInterCdCtnt());
			}
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Check Carrier"}).getMessage(), ex);
		}		
		
		return eventResponse;
	}
}