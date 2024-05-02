/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeSC.java
*@FileTitle : Surcharge Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.basic.ApplicationDateRuleBC;
import com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.basic.ApplicationDateRuleBCImpl;
import com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.event.EsmPri4034Event;
import com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.vo.RoutLocCdVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.basic.SurchargeBC;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.basic.SurchargeBCImpl;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.event.EsmPri4003Event;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.event.EsmPri4011Event;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.event.EsmPri4016Event;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.CstPriScgRtVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.PriScgPrfVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.PriScgRtVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.PriScgRtValidVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.basic.SurchargeGroupCommodityBC;
import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.basic.SurchargeGroupCommodityBCImpl;
import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.event.EsmPri4008Event;
import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.event.EsmPri4019Event;
import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.vo.CommonGroupCommodityVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.vo.RsltPriComGrpCmdtExcelVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.vo.RsltPriScgGrpCmdtDtlVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.basic.SurchargeGroupLocationBC;
import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.basic.SurchargeGroupLocationBCImpl;
import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.event.EsmPri4004Event;
import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.event.EsmPri4018Event;
import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.integration.SurchargeGroupLocationDBDAO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.vo.RsltPriScgGrpLocDtlVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.vo.RsltPriScgGrpLocVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.vo.SurchargeGroupLocationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComUpldFileVO;
import com.clt.syscommon.common.table.PriScgGrpCmdtVO;

/**
 * handling business transaction about Surcharge Business Logic ServiceCommand - Surcharge 
 * 
 * @author 
 * @see SurchargeGroupLocationDBDAO
 * @since J2EE 1.4
 */

public class SurchargeSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario Surcharge system <br>
	 * ESM_PRI_4004 related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Surcharge system biz scenario closing<br>
	 * ESM_PRI_4004 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("SurchargeSC Finish");
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;		
		
		//ESM_PRI_4004 Group Location start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri4004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGroupLocation(e);
			}
		}
		//ESM_PRI_4004 Group Location end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_4008 GRI Commodity start
		//////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri4008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSurchargeGroupCommodityList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSurchargeGroupCommodityDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSurchargeGroupCommodityExcelList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSurchargeGroupCommodity(e);
			}
		}
		//ESM_PRI_4008 GRI Commodity end
		//////////////////////////////////////////////////////////////////////////////////
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri4003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboPctBseCdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSurchargePreferences(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSurcharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSurchargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkSurchargeDuplicate(e);
			} else {
				eventResponse = initSurchargeComboData(e);  
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri4016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSurchargePreferences(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSurchargeRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkSurchargeDuplicate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = checkSurchargeExcelData(e);
			} else {
				eventResponse = initSurchargeComboData(e);  
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri4019Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchSurchargeGroupCommodityList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchSurchargeGroupCommodityDetailList(e);
            }
        }
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri4011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSurchargePreferences(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAllSurchargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSurchargeListForExcel(e);
			} else {
				eventResponse = initSurchargeComboData(e);  
			}
			
			
		}
		
		//////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri4018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationList(e);
			}
		}
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_4029 Group Location Popup start
		//////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri4029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationList(e);
			}
		}
		//ESM_PRI_4029 Group Location Popup end
		//////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri4034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLocationInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchScpCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLocationInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLocationInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkLocationName(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkForScp(e);
			}
		}

		
		
		
		
		return eventResponse;
	}
	

	//ESM_PRI_4004 Group Location start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_4029 : Retrieve <br>
	 * Retrieving Surcharge Group Location List<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationList(Event e) throws EventException {
	    
	    SurchargeGroupLocationVO paramVo = new SurchargeGroupLocationVO();
	    if (e.getEventName().equalsIgnoreCase("EsmPri4004Event")) {
	        EsmPri4004Event event = (EsmPri4004Event) e;
	        paramVo = event.getSurchargeGroupLocationVO();
	    } else if (e.getEventName().equalsIgnoreCase("EsmPri4018Event")) {
            EsmPri4018Event event = (EsmPri4018Event) e;
            paramVo = event.getSurchargeGroupLocationVO();
	    }
		SurchargeGroupLocationBC command = new SurchargeGroupLocationBCImpl();
		
		SurchargeGroupLocationVO cVo = new SurchargeGroupLocationVO();
		//searchGubun 1:Group Location, 2:Group Location Detail
		String searchGubun = paramVo.getSearchGubun();
		
		log.debug("*********************************************************");
		log.debug("searchGubun : " + searchGubun);
		log.debug("*********************************************************");
		
		//Group Location List 
		List<RsltPriScgGrpLocVO> rsltpriScgGrpLocVOList 		= new ArrayList<RsltPriScgGrpLocVO>();
		List<RsltPriScgGrpLocDtlVO> rsltPriScgGrpLocDtlVOList   = new ArrayList<RsltPriScgGrpLocDtlVO>();

		cVo = command.searchGroupLocationList(paramVo);		
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		 //setting the retrieve result in container vo to response 
		if("1".equals(searchGubun)) {
			rsltpriScgGrpLocVOList  = cVo.getRsltPriScgGrpLocVOList();
			eventResponse.setRsVoList(rsltpriScgGrpLocVOList);
			//max seq setting
			eventResponse.setETCData("max_seq", cVo.getMaxSeq());
			log.debug("*********************************************************");
			log.debug("max_seq : " + eventResponse.getETCData("max_seq"));
			log.debug("*********************************************************");
		}
		else if("2".equals(searchGubun)) {
			rsltPriScgGrpLocDtlVOList 	  = cVo.getRsltPriScgGrpLocDtlVOList();
			eventResponse.setRsVoList(rsltPriScgGrpLocDtlVOList);
		}
		else if("3".equals(searchGubun)) {
			rsltpriScgGrpLocVOList  = cVo.getRsltPriScgGrpLocVOList();
			eventResponse.setRsVoList(rsltpriScgGrpLocVOList);
			
			rsltPriScgGrpLocDtlVOList 	  = cVo.getRsltPriScgGrpLocDtlVOList();
			eventResponse.setRsVoList(rsltPriScgGrpLocDtlVOList);
		}
			
		return eventResponse;
		
	}

	/**
	 * ESM_PRI_4004 : Save <br>
	 * Modifying Surcharge Group Location<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGroupLocation(Event e) throws EventException {
	    SurchargeGroupLocationVO paramVo = new SurchargeGroupLocationVO();
        if (e.getEventName().equalsIgnoreCase("EsmPri4004Event")) {
            EsmPri4004Event event = (EsmPri4004Event) e;
            paramVo = event.getSurchargeGroupLocationVO();
        }
	    // PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SurchargeGroupLocationBC command = new SurchargeGroupLocationBCImpl();
		try{
			begin();
			command.manageGroupLocation(paramVo,account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	//ESM_PRI_4004 Group Location end
	//////////////////////////////////////////////////////////////////////////////////
	
	//ESM_PRI_4008 GRI Commodity start
	//////////////////////////////////////////////////////////////////////////////////
    /**
     * ESM_PRI_4008 : Retrieve <br>
     * Retrieving GRI Commodity's Master list<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSurchargeGroupCommodityList(Event e) throws EventException {

        PriScgGrpCmdtVO paramVo = new PriScgGrpCmdtVO();
        if (e.getEventName().equalsIgnoreCase("EsmPri4008Event")) {
            // PDTO(Data Transfer Object including Parameters)
            EsmPri4008Event event = (EsmPri4008Event) e;
            paramVo = event.getPriScgGrpCmdtVO();
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri4019Event")) {
            // PDTO(Data Transfer Object including Parameters)
            EsmPri4019Event event = (EsmPri4019Event) e;
            paramVo = event.getPriScgGrpCmdtVO();
        }
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SurchargeGroupCommodityBC command = new SurchargeGroupCommodityBCImpl();

        try{
            CommonGroupCommodityVO cVo = command.searchSurchargeGroupCommodityList(paramVo);
            //Commodity List 
            List<PriScgGrpCmdtVO> priComGrpCmdtVOList = new ArrayList<PriScgGrpCmdtVO>();
            
            //setting the retrieve result in container vo to response
            priComGrpCmdtVOList  = cVo.getPriScgGrpCmdtVOList();
            eventResponse.setRsVoList(priComGrpCmdtVOList);
            
            //max seq setting
            eventResponse.setETCData("max_seq", cVo.getMaxSeq());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    
    /**
     * ESM_PRI_4008 : Retrieve <br>
     * Retrieving GRI Commodity's Detail list<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSurchargeGroupCommodityDetailList(Event e) throws EventException {

        PriScgGrpCmdtVO paramVo = new PriScgGrpCmdtVO();
        if (e.getEventName().equalsIgnoreCase("EsmPri4008Event")) {
            // PDTO(Data Transfer Object including Parameters)
            EsmPri4008Event event = (EsmPri4008Event) e;
            paramVo = event.getPriScgGrpCmdtVO();
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri4019Event")) {
            // PDTO(Data Transfer Object including Parameters)
            EsmPri4019Event event = (EsmPri4019Event) e;
            paramVo = event.getPriScgGrpCmdtVO();
        }        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SurchargeGroupCommodityBC command = new SurchargeGroupCommodityBCImpl();
        
        try{
            List<RsltPriScgGrpCmdtDtlVO> list = command.searchSurchargeGroupCommodityDetailList(paramVo);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_4008 : Down Excel <br>
     * Retrieving GRI Commodity's Download Excel list<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSurchargeGroupCommodityExcelList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri4008Event event = (EsmPri4008Event) e;
        SurchargeGroupCommodityBC command = new SurchargeGroupCommodityBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltPriComGrpCmdtExcelVO> list = command.searchSurchargeGroupCommodityExcelList(event.getPriScgGrpCmdtVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_PRI_4008 : Save<br>
	 * Saving GRI Commodity information <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSurchargeGroupCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4008Event event = (EsmPri4008Event)e;
		SurchargeGroupCommodityBC command = new SurchargeGroupCommodityBCImpl();
		try{
			begin();
			command.manageSurchargeGroupCommodity(event.getCommonGroupCommodityVO(),account);
            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	//ESM_PRI_4008 GRI Commodity end
	//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * ESM_PRI_4003 : Application Type Percentage retrieve <br>
	 * Retrieving Percentage Base Code<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComboPctBseCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4003Event event = (EsmPri4003Event)e;
		SurchargeBC command = new SurchargeBCImpl();
		try{
			List<RsltCdListVO> list = command.searchComboPctBseCdList(event.getPriScgPrfVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4003 : Retrieve <br>
	 * Retrieving Surcharge Preferences list<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargePreferences(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PriScgPrfVO paramVO = new PriScgPrfVO();
		if(e.getEventName().equalsIgnoreCase("EsmPri4003Event")) {
			EsmPri4003Event event = (EsmPri4003Event)e;
			paramVO = event.getPriScgPrfVO();
		} else if(e.getEventName().equalsIgnoreCase("EsmPri4011Event")) {
			EsmPri4011Event event = (EsmPri4011Event)e;
			paramVO = event.getPriScgPrfVO();
		} else if(e.getEventName().equalsIgnoreCase("EsmPri4016Event")) {
			EsmPri4016Event event = (EsmPri4016Event)e;
			paramVO = event.getPriScgPrfVO();
		}
		
		SurchargeBC command = new SurchargeBCImpl();
		try{
			List<PriScgPrfVO> list = command.searchSurchargePreferences(paramVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * ESM_PRI_4003, ESM_PRI_4016 : Save <br>
	 * Modifying Surcharge Preferences and Surcharge<br>
	 * Using on Surcharge and Excel Upload screen<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSurcharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PriScgPrfVO[] priScgPrfVOS = null;
		PriScgRtVO[] priScgRtVOS = null;
		
		EsmPri4003Event event = (EsmPri4003Event)e;
		priScgPrfVOS = event.getPriScgPrfVOS();
		priScgRtVOS = event.getPriScgRtVOS();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SurchargeBC command = new SurchargeBCImpl();
		
		try{
			String stsCd = priScgPrfVOS[0].getIbflag();
			String svcScpCd = priScgPrfVOS[0].getSvcScpCd();
			String chgCd = priScgPrfVOS[0].getChgCd();
			log.debug("surcharge===================1");
			begin();
			
			if("I".equals(stsCd) || "U".equals(stsCd)) {
				//main save
				command.manageSurchargePreferences(priScgPrfVOS, account);
				
				//detail save
				if(priScgRtVOS != null) {
					for(int i=0; i<priScgRtVOS.length; i++) {
						if("N".equals(priScgPrfVOS[0].getPorUseFlg())) {
							priScgRtVOS[i].setPorDefCd("");
							priScgRtVOS[i].setPorTpCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getPolUseFlg())) {
							priScgRtVOS[i].setPolDefCd("");
							priScgRtVOS[i].setPolTpCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getPodUseFlg())) {
							priScgRtVOS[i].setPodDefCd("");
							priScgRtVOS[i].setPodTpCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getDelUseFlg())) {
							priScgRtVOS[i].setDelDefCd("");
							priScgRtVOS[i].setDelTpCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getImdgClssUseFlg())) {
							priScgRtVOS[i].setScgImdgClssCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getSubTrdUseFlg())) {
							priScgRtVOS[i].setSubTrdCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getSlanUseFlg())) {
							priScgRtVOS[i].setVslSlanCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getTsPortUseFlg())) {
							priScgRtVOS[i].setTsPortCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getDirCallUseFlg())) {
							priScgRtVOS[i].setDirCallFlg("");
						}
						
						if("N".equals(priScgPrfVOS[0].getTmlUseFlg())) {
							priScgRtVOS[i].setTmlCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getTrnsModUseFlg())) {
							priScgRtVOS[i].setOrgTrspModCd("");
							priScgRtVOS[i].setDestTrspModCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getUsaSvcModUseFlg())) {
							priScgRtVOS[i].setUsaSvcModCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getRcvDeTermUseFlg())) {
							priScgRtVOS[i].setPrcRcvTermCd("");
							priScgRtVOS[i].setPrcDeTermCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getHngrBarUseFlg())) {
							priScgRtVOS[i].setPrcHngrBarTpCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getCgoWgtUseFlg())) {
							priScgRtVOS[i].setMinCgoWgt("");
							priScgRtVOS[i].setMaxCgoWgt("");
						}
						
						if("N".equals(priScgPrfVOS[0].getCmdtUseFlg())) {
							priScgRtVOS[i].setCmdtCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getGriCmdtUseFlg())) {
							priScgRtVOS[i].setScgGrpCmdtCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getSocUseFlg())) {
							priScgRtVOS[i].setSocFlg("");
						}
						
						if("N".equals(priScgPrfVOS[0].getIoGaUseFlg())) {
							priScgRtVOS[i].setIoGaCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getCnlTzFlg())) {
							priScgRtVOS[i].setCnlTzCd("");
						}
					}
					command.manageSurchargeRate(priScgRtVOS, account);
				
					//2015.05.06
					//<20150506_1>
					//소스품질결함에 의해 해당 소스를 이 부분으로 이동 priScgRtVOS는 null이 될수 없도록 if안으로 이동
					String dupIdx = command.checkSurchargeDuplicate(priScgRtVOS);
					if("".equals(dupIdx)) {
						eventResponse.setETCData("FLAG", "Y");
						eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
						commit();
						log.debug("checkSurchargeDuplicate=======================commit");
					} else {
						eventResponse.setETCData("DUP_INDEX", dupIdx);
						eventResponse.setETCData("FLAG", "N");
						rollback();
						log.debug("checkSurchargeDuplicate=======================rollback");
					}
				} else {
					//Main만 저장 시 Commit
					commit();
				}
			} else if("D".equals(stsCd)) {
				CstPriScgRtVO cstPriScgRtVO = new CstPriScgRtVO();
				cstPriScgRtVO.setSvcScpCd(svcScpCd);
				cstPriScgRtVO.setChgCd(chgCd);
				command.removeSurchargeRate(cstPriScgRtVO);
				command.removeSurchargePreferences(cstPriScgRtVO);
				
				//2015.05.06
				//<20150506_1>에 의해 commit부분이 필요 
				//삭제로직에는 수행이 성공적일 때 성공메세지만 넘김
				eventResponse.setETCData("FLAG", "Y");
				eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
				commit();
			}
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * ESM_PRI_4003, ESM_PRI_4016 : Save <br>
	 * Modifying Surcharge Preferences and Surcharge<br>
	 * Using on Surcharge and Excel Upload screen<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSurchargeRate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4016Event event = (EsmPri4016Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SurchargeBC command = new SurchargeBCImpl();
		PriScgRtVO[] priScgRtVOS = null;
		
		try{
			begin();			
			priScgRtVOS = event.getPriScgRtVOS();
			command.manageSurchargeRate(event.getPriScgRtVOS(), account);	
			commit();
			
			//2015-03-27 REMOVE (USE IN SurchargeDBDAOChkPriScgRtInfoRSQL.QUERY)
			//( SC:checkSurchargeExcelData | BC:checkSurchargeExcelData | DAO:checkSurchargeExcelData | SQL:SurchargeDBDAOChkPriScgRtInfoRSQL)
//			String dupIdx = command.checkSurchargeDuplicate(priScgRtVOS);
//			log.debug("dupIdx=================="+dupIdx);
//			
//			if("".equals(dupIdx)) {
//				eventResponse.setETCData("FLAG", "Y");
//				eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
//				commit();
//			} else {
//				eventResponse.setETCData("DUP_INDEX", dupIdx);
//				eventResponse.setETCData("FLAG", "N");
//				rollback();
//			}			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4003 : Retrieve <br>
	 * Retrieving Surcharge<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PriScgRtVO paramVO = new PriScgRtVO();
		if(e.getEventName().equalsIgnoreCase("EsmPri4003Event")) {
			EsmPri4003Event event = (EsmPri4003Event)e;
			paramVO = event.getPriScgRtVO();
		} else if(e.getEventName().equalsIgnoreCase("EsmPri4016Event")) {
			EsmPri4016Event event = (EsmPri4016Event)e;
			paramVO = event.getPriScgRtVO();
		}
		
		try{
			SurchargeBC command = new SurchargeBCImpl();
			List<PriScgRtVO> list = null;
			if(e.getEventName().equalsIgnoreCase("EsmPri4003Event")) {
				
				EsmPri4003Event event = (EsmPri4003Event)e;
				list = command.searchSurchargeList(paramVO, event.getnPage());
				//NONE-PAGING
				//list = command.searchSurchargeList(paramVO);
				if(list.size() > 0) {
					eventResponse.setETCData("TOTAL", Integer.toString( ((PriScgRtVO)list.get(0)).getMaxRows() ) );
				}
			} else if(e.getEventName().equalsIgnoreCase("EsmPri4016Event")) {
				list = command.searchSurchargeList(paramVO);
			}
			if(list != null) {
				eventResponse.setRsVoList(list);
			}
			
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	

	
	/**
	 * ESM_PRI_4016 : Save <br>
	 * Modifying Surcharge<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSurchargeDuplicate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PriScgRtVO[] priScgRtVOS = null;
		
		if(e.getEventName().equalsIgnoreCase("EsmPri4003Event")) {
			EsmPri4003Event event = (EsmPri4003Event)e;
			priScgRtVOS = event.getPriScgRtVOS();
		} else if(e.getEventName().equalsIgnoreCase("EsmPri4016Event")) {
			EsmPri4016Event event = (EsmPri4016Event)e;
			priScgRtVOS = event.getPriScgRtVOS();
		}
		
		if(priScgRtVOS != null) {
			SurchargeBC command = new SurchargeBCImpl();
			String dupIdx = command.checkSurchargeDuplicate(priScgRtVOS);
			if("".equals(dupIdx)) {
				eventResponse.setETCData("FLAG", "Y");
			} else {
				eventResponse.setETCData("DUP_INDEX", dupIdx);
				eventResponse.setETCData("FLAG", "N");
			}
		}
		return eventResponse;
	
	}
	
	/**
	 * ESM_PRI_4016 : CHECK <br>
	 * CHECK Surcharge DATA<br>
	 * 2015-03-27 CREATE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSurchargeExcelData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4016Event event = (EsmPri4016Event)e;
		PriScgRtVO[] priScgRtVOS = event.getPriScgRtVOS();
		
		if(priScgRtVOS != null && priScgRtVOS.length > 0) {		
			SurchargeBC command = new SurchargeBCImpl();			
			List<PriScgRtValidVO> list = command.checkSurchargeExcelData(priScgRtVOS);
			int validCnt = 0;
			if(list.size() > 0) {
				eventResponse.setRsVoList(list);				
				for(int i = 0; i < list.size(); i++){
					PriScgRtValidVO priScgRtValidVO =  (PriScgRtValidVO)list.get(i);
					
					if(priScgRtValidVO.getPorDefCd().equals("F") || priScgRtValidVO.getPolDefCd().equals("F") || priScgRtValidVO.getPodDefCd().equals("F") || priScgRtValidVO.getDelDefCd().equals("F") ||
					   priScgRtValidVO.getTmlCdVld().equals("F") || priScgRtValidVO.getTsPortCdVld().equals("F") || priScgRtValidVO.getCmdtCdVld().equals("F") ) {
						validCnt++;
					}
				}
			}
		}		
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_4011 : Search <br>
	 * Retrieving Surcharge total List<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAllSurchargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4011Event event = (EsmPri4011Event)e;
		SurchargeBC command = new SurchargeBCImpl();
		try{
			List<PriScgRtVO> list = command.searchAllSurchargeList(event.getCstPriScgRtVO(), event.getnPage());
			eventResponse.setRsVoList(list);
			if(list != null && list.size() > 0) {
				eventResponse.setETCData("TOTAL", Integer.toString( ((PriScgRtVO)list.get(0)).getMaxRows() ) );
			}
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4011 : Search For Excel <br>
	 * Retrieving Surcharge total List<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeListForExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4011Event event = (EsmPri4011Event)e;
		SurchargeBC command = new SurchargeBCImpl();
		
		List<Object> oList = new ArrayList<Object>();
		String fileName = "";

		try{
			oList = command.searchSurchargeListForExcel(event.getCstPriScgRtVO());
			fileName = "ESM_PRI_4011DL.xls";
			
			eventResponse.setCustomData("rowset", (DBRowSet)oList.get(0));
			eventResponse.setCustomData("title", (String[])oList.get(1));
			eventResponse.setCustomData("columns", (String[])oList.get(2));
			eventResponse.setCustomData("fileName", fileName);
			eventResponse.setCustomData("isZip", false);
			
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	//ESM_PRI_4009 E-SVC Compensation Creation start
	//////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * ESM_PRI_4003 : Load Page <br>
	 * Initializing basic Code List<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initSurchargeComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		PRICommonBC command1 = new PRICommonBCImpl();
		SurchargeBC command2 = new SurchargeBCImpl();
		
		CodeUtil cdUtil = CodeUtil.getInstance();
		
		List<RsltCdListVO> customData = null;
		List<CodeInfo> codeInfos = null;
		
		try{
			// Excel Template File Key
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("SCG_Surcharge_Templet.xls");
			String fileKey = command1.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("templateKey", fileKey);
			
			//service scope code
			customData = command1.searchServiceScopeCodeList(new RsltCdListVO());
			eventResponse.setCustomData("svcScpCd", customData);
			
			//charge code
			customData = command1.searchChargeCdList(new RsltCdListVO());
			eventResponse.setCustomData("chgCd", customData);
			
			customData = command2.searchComboPctBseCdList(new PriScgPrfVO());
			eventResponse.setCustomData("pctBseCd", customData);
			
			// Surcharge Imdge Class
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02128", 0);
		    eventResponse.setCustomData("scgImdgClssCd", codeInfos);
		    
		    // Origin Trans Mode
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01720", 0);
		    eventResponse.setCustomData("orgTrspModCd", codeInfos);
		    
		    // Dest Trans Mode
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01720", 0);
		    eventResponse.setCustomData("destTrspModCd", codeInfos);
		    
		    // Usa Service Mode Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01729", 0);
		    eventResponse.setCustomData("usaSvcModCd", codeInfos);
		    
		    // Pricing Receiving Term Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02070", 0);
		    eventResponse.setCustomData("prcRcvTermCd", codeInfos);
		    
		    // Pricing Destination Term Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02071", 0);
		    eventResponse.setCustomData("prcDeTermCd", codeInfos);
		    
		    // Pricing Hanger Bar Type Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01708", 0);
		    eventResponse.setCustomData("prcHngrBarTpCd", codeInfos);
		    
		    // Payment Term Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01713", 0);
		    eventResponse.setCustomData("payTermCd", codeInfos);
		    
		    // Rating Unit Code
		    customData = command1.searchAllPerCodeList(new RsltCdListVO());
			eventResponse.setCustomData("ratUtCd", customData);
		    
			// Cargo Type Code
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02141", 0);
		    eventResponse.setCustomData("prcCgoTpCd", codeInfos);
		    
		    // Surcharge Imdge Class Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02128", 0);
		    eventResponse.setCustomData("scgImdgClssCd", codeInfos);
		    
		    // Currency Code
		    customData = command1.searchAllCurrencyCodeList(new RsltCdListVO());
			eventResponse.setCustomData("currCd", customData);
		    
			// Direct Call Code
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00912", 0);
		    eventResponse.setCustomData("dirCallFlg", codeInfos);
		    
		    // Commercial Feeder Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00912", 0);
		    eventResponse.setCustomData("socFlg", codeInfos);
		    
		    // In/Out Gauge
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02142", 0);
		    eventResponse.setCustomData("ioGaCd", codeInfos);
		    
		    // Sub trade Code
		    customData = command1.searchSubTrdCdList(new RsltCdListVO());
			eventResponse.setCustomData("subTrdCd", customData);
			
			// Size
			customData = command1.searchMdmCntrSzCodeList(new RsltCdListVO());
			eventResponse.setCustomData("cntrSzCd", customData);
			
			// Canal Transit Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02538", 0);
		    eventResponse.setCustomData("cnlTzCd", codeInfos);
		    
		    //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02582", 0);
		    eventResponse.setCustomData("BKG_ESVC_TP_CD", codeInfos);
		    
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}



	/**
	 * Route Location conversion List select<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLocationInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4034Event event = (EsmPri4034Event)e;
		ApplicationDateRuleBC command = new ApplicationDateRuleBCImpl();

		try{
			List<RoutLocCdVO> list = command.searchLocationInfo(event.getRoutLocCdVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	/** Scope code select from Route Location conversion
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchScpCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ApplicationDateRuleBC command = new ApplicationDateRuleBCImpl();

		try{
			String[] arrport = command.searchScpCd();
			StringBuilder sb = new StringBuilder();
			
			if(arrport != null && arrport.length > 0){
				sb.append(arrport[0]);
				for (int i = 1; i < arrport.length; i++) {
					sb.append("|");
					sb.append(arrport[i]);
				}
			}else{
				sb.append("");
			}
			
			eventResponse.setETCData("scpcd", sb.toString());
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}	
    /**
     * Route Location conversion List Insert, Update, Delete.<br>
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse manageLocationInfo(Event e) throws EventException {
    	EsmPri4034Event event = (EsmPri4034Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ApplicationDateRuleBC command = new ApplicationDateRuleBCImpl();
    	
        try {
            begin();
            command.manageLocationInfo(event.getRoutLocCdVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00340",new String[]{}).getUserMessage());
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
    
	/**check if there is the same data in Route Location conversion List
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkLocationInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4034Event event = (EsmPri4034Event)e;
		ApplicationDateRuleBC command = new ApplicationDateRuleBCImpl();
		String chkScpCd = null;
		String chkOrgCd = null;
		String chkConvCd = null;
		String samecd_cnt = null;
		
		try{

			chkScpCd = event.getRoutLocCdVO().getChkScpCd();
			chkOrgCd = event.getRoutLocCdVO().getChkOrgCd();
			chkConvCd = event.getRoutLocCdVO().getChkConvCd();
			samecd_cnt = command.checkLocationInfo(chkScpCd,chkOrgCd,chkConvCd);
			eventResponse.setETCData("samecd_cnt", samecd_cnt);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	/**check if there is Location code
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkLocationName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4034Event event = (EsmPri4034Event)e;
		ApplicationDateRuleBC command = new ApplicationDateRuleBCImpl();
		String chkLocation = null;
		String check_loc = null;
		
		try{

			chkLocation = event.getRoutLocCdVO().getChkLocation();
			check_loc = command.checkLocationName(chkLocation);
			eventResponse.setETCData("check_loc", check_loc);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	/**check if there are the same data in DB
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkForScp(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4034Event event = (EsmPri4034Event)e;
		ApplicationDateRuleBC command = new ApplicationDateRuleBCImpl();
		String chkLocation = null;
		String check_flg = null;
		String chk_scp_cd = null;
		String check_scp = null;
		
		try{

			chkLocation = event.getRoutLocCdVO().getChkLocation();
			check_flg = event.getRoutLocCdVO().getChkFlg();
			chk_scp_cd = event.getRoutLocCdVO().getChkScpCd();
			check_scp = command.checkForScp(chkLocation,check_flg,chk_scp_cd);
			eventResponse.setETCData("check_scp", check_scp);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}	
}