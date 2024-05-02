/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfCommonSC.java
*@FileTitle : OpfUtil Common
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.26 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfcommon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.basic.OpfUtilBC;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.basic.OpfUtilBCImpl;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.event.OpfutilEvent;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration.OpfUtilDBDAO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.SearchVVDVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmYardComboVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;


/**
 * NIS2010-OpfCommon Business Logic ServiceCommand - NIS2010-OpfCommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jang Suk Hyun
 * @see OpfUtilDBDAO
 * @since J2EE 1.4
 */

public class OpfCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * OpfCommon system 업무 시나리오 선행작업<br>
	 * OpfUtil업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * OpfCommon system 업무 시나리오 마감작업<br>
	 * OpfUtil 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("OpfCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-OpfCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
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
            else if(e.getFormCommand().isCommand(FormCommand.SEARCH11)) {//Vvd Port 정보.
                eventResponse = searchVvdPort(e);
            }
            else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)) {//Port Valid Check
                eventResponse = searchPortInfo(e);
            }
            else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)) {//Container No Validation Check
            	eventResponse = searchCntrNoValid(e);                
            }
			

			
		}
		return eventResponse;
	}
	
	/**
	 * OPF Combo를 조회 합니다. <br>
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
	 * I-Stowge Code를 조회 합니다. <br>
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
	 * Lane Code를 조회 합니다. <br>
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
	 * 옳바른 Lane Code 여부를 조회 합니다. <br>
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
	 * 올바른 Carrier Code 여부를 조회 합니다. <br>
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
	 * VVD코드의 Yard를 조회 합니다. <br>
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
	 * VVD코드의 여부를 조회 합니다. <br>
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
	 * Container의 여부를 조회 합니다. <br>
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
	 * VVD별 Port를 조회 합니다. <br>
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
	 * Container Type/Size 를 조회 합니다. <br>
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
     * VVD코드의 Port를 조회 합니다. <br>
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
     * Port정보 조회한다. <br>
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
	 * Container No 의 Validation여부를 조회 합니다. <br>
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
}