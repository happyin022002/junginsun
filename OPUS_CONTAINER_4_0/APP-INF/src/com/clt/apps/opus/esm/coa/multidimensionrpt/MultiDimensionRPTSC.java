/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MultiDimensionRPTSC.java
*@FileTitle : MultiDimensionRPTSC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
==========================================================  
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.apps.opus.esm.coa.common.basic.CommonBC;
import com.clt.apps.opus.esm.coa.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.GetCodeSelectVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.basic.LogisticsRPTBC;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.basic.LogisticsRPTBCImpl;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.event.EsmCoa0080Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.event.EsmCoa0081Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.event.EsmCoa0082Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.event.EsmCoa0158Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLgstConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO2;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO2;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0082ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0082ListVO2;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0158ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.basic.MultiDimensionRPTBC;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.basic.MultiDimensionRPTBCImpl;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa0072Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa0130Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa2003Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.MultiDimensionRptRtnVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.PnlRptItemVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.RepoPfmcConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchReportViewListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.basic.PreCMSimulationBC;
import com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.basic.PreCMSimulationBCImpl;
import com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.event.EsmCoa4006Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.event.EsmCoa4007Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.basic.SalesRPTBC;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.basic.SalesRPTBCImpl;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0035Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0059Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0060Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0061Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0070Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0144Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0170Event;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration.SalesRPTDBDAO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.BkgRpt0061VO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoRtnVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesRPTCommonVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchBkgRmk0170ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchSetForm059List2VO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchSetForm059ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.ShipperVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
 

/**
 * OPUS-MultiDimensionRPT Business Logic ServiceCommand 
 * 
 * @author
 * @see SalesRPTDBDAO
 * @since J2EE 1.6
 */

public class MultiDimensionRPTSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * MultiDimensionRPT system preceding process for a biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("MultiDimensionRPTSC Start");
		try {

			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * MultiDimensionRPT system biz scenario closing<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("MultiDimensionRPTSC Close");
	}

	/**
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

	    if (e.getEventName().equalsIgnoreCase("EsmCoa0035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {        // sheet1 Account Inquiry
				eventResponse = searchInqSrcDtAcct0035List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // sheet2 Type Size Inquiry
				eventResponse = searchInqSrcDtTpSz0035List(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {  // sheet1 Account excelldown
				eventResponse = excelDownInqSrcDtAcct0035List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // sheet2 Type Size excelldown
				eventResponse = excelDownInqSrcDtTpSz0035List(e);
			} else { // Load
				eventResponse = searchComBoCdList0035(e);
				//eventResponse = searchTypeSizeList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCoa0130Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReportViewList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiReportView(e);
			} else { // Load
				eventResponse = searchComBoCdList0130(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCoa0170Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchBkgRmkList(e);
			}
			
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0059Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // masert sheet info
				eventResponse = searchSetForm059List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // detail sheet info
		    	eventResponse = searchSetForm059List2(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
		    	eventResponse = multiSetForm059(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
		    	eventResponse = searchComBoCdList0059(e);
		    }				
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0060Event")) {
			log.debug("####################### multi.EsmCoa0060Event() ############# ");
			log.debug("####################### FormCommand.SEARCHLIST01 ############# ");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // sheet info
				eventResponse = searchInqByCondition060List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // header info
				eventResponse = searchInqByCondition060List2(e);
			} else{
				/*if (1==1 || e.getFormCommand().isCommand(FormCommand.INIT)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST10) 
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)) {*/
				eventResponse = searchComBoCdList0060(e);
		    }
			log.debug("####################### multi.EsmCoa0060Event() #############");
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchBKG0061List(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchBKG0061List2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchBKG0061List3(e);
			} else{	
				eventResponse = searchComBoCdList0061(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0070Event")){
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchRPTbyOfc0070List11(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchRPTbyOfc0070List12(e);
			} else {
				eventResponse = searchComBoCdList0070(e);
			}
			
		}
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0072Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchWeeklySalesByOffice3TEUBased1List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchWeeklySalesByOffice3TEUBased2List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchWeeklySalesByOffice3TEUBased3List(e);
			} else { // Load
				eventResponse = searchComBoCdList0072(e);
			}
			
		}
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0144Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchShipperList(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchLogisticsRPT0080List(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchLogisticsRPT0080List2(e);
			}else{
				eventResponse = searchComBoCdList0080(e); 
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0081Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchLogisticsRPT0081List(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchLogisticsRPT0081List2(e);
			}else{
				eventResponse = searchComBoCdList0081(e); 
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0082Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchLogisticsRPT0082List(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)){
				eventResponse = searchLogisticsRPT0082List2(e);
			}else{
				eventResponse = searchComBoCdList0082(e); 
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0158Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchLogisticsRPT0158List(e);
			}else{
				eventResponse = searchComBoCdList0158(e); 
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCoa2003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //retrieve
				eventResponse = searchPnlRptItem(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //save
				eventResponse = multiPnlRptItem(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)){ //combo
				eventResponse =  searchComBoCdList2003(e);	
			} else {
            	eventResponse = searchPnlRptItem(e);
            }
		}else if (e.getEventName().equalsIgnoreCase("EsmCoa4006Event")) {
			log.debug("\n==========================EsmCoa4006Event");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBKG4006List(e);
			}
			else {
				eventResponse = searchComBoCdList4006(e);
			}
		}
		//SJH.20150320.ADD
		else if (e.getEventName().equalsIgnoreCase("EsmCoa4007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchBkgRmkList4007(e);
			}else{
				eventResponse = searchComBoCdList4007(e);
			}
		}
		return eventResponse;
		
		
	}
	
	/**
	 * Common code Handling the inquiry event<br>
	 * MultiDimensionRPT, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0035(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0035Event event = (EsmCoa0035Event)e;
	   	CommonBC commonBC = new CommonBCImpl();
	   	SalesRPTBC salesRPTBC = new SalesRPTBCImpl();
	   	
       try {    
    	   String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
    	   String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());    	 
    		       
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"rLane",event.getSearchConditionVO().getFTrdCd(),"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);

    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)){	       		
	       		
	       		String year = JSPUtil.getNull(event.getSearchConditionVO().getFYear(),com.clt.framework.component.util.DateTime.getYear() + "");
	       		String month = "";
	       		if (event.getSearchConditionVO().getFChkprd().equalsIgnoreCase("W")){
	       			month = JSPUtil.getNull(event.getSearchConditionVO().getFSlsMon(), JSPUtil.getNull(event.getSearchConditionVO().getFFmMon(),Utils.getCurrentMon()));
	       		}else{
	       			month = JSPUtil.getNull(event.getSearchConditionVO().getFMon(), JSPUtil.getNull(event.getSearchConditionVO().getFFmMon(),Utils.getCurrentMon()));
	       		}
	       		
	       		String ofc_lvl2 = JSPUtil.getNull(event.getSearchConditionVO().getFOfcLvl());
	       		String array[][] = { {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl2+"|" + year +"|" + month,"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	   
    	   }else { 
    		      		   
		       	//SJH.20150102.MOD
		       	String prevWeek[] = commonBC.searchPrevWkPrdYW();									
		       	String fYear = prevWeek[0];
		       	String period = commonBC.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");
		       	
		        /*------------------------------------------------*/
		        DBRowSet dbRowset = null;
		        dbRowset = salesRPTBC.searchCntrTpSzList(event.getSalesOffiRepoConditionVO());
		    	//String strTpsz = "";
		    	StringBuffer sb = new StringBuffer();
		    	
	    		if (dbRowset != null) {
	    			while (dbRowset.next()) {
	    				//strTpsz = strTpsz + "|" + JSPUtil.getNull(dbRowset.getString("spcl_cntr_tpsz_cd"));
	    				sb.append("|");
	    				sb.append(JSPUtil.getNull(dbRowset.getString("spcl_cntr_tpsz_cd")));
	    				
	    			}
	    		} //end of if
		    	eventResponse.setETCData("strTpsz", sb.toString());
		    	/*------------------------------------------------*/
		    	
		       	eventResponse.setETCData("ofc_cd", ofc_cd);
		       	eventResponse.setETCData("ofc_lvl",ofc_lvl );
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);									//SJH.20150102.ADD
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);									//SJH.20150102.MOD
		       	eventResponse.setETCData("period", period);		       
		        /*-------------------------------------------------------*/
		       	String array[][] = { 
		       			 /*1. Profit View*/
		       			 {"rptAuth","CD00939|"+ofc_lvl,""}, 
		       			 /*2. Office View*/
						 {"rptAuth","CD00940|"+ofc_lvl,""},
						 /*3. Profit Level*/
						 {"rptAuth","CD00941|"+ofc_lvl,""},
						 /*4. Office Level*/
						 {"allOFCLevel",ofc_lvl,""},
						 /*5. Office*/
						 {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl+"|" + com.clt.framework.component.util.DateTime.getYear() +"|" + Utils.getCurrentMon(),"All"},
						 
						 /*6. Trade*/
						 {"trade","","All"}, 
						 /*7.Lane*/
						 {"rLane","","All"}, 
						 /*8. IOC CD*/
						 {"CD00206","000020: :All","All"}, 
						 /*9. Direction*/
						 {"CD00593","000001: :All","All"}, 
//						 /*10.Rep. Commodity*/					//20160115.MOD
//						 {"commodity","","All"},
						 /*11.usa_bkg_mod_cd*/
						 {"CD00777","000001: :All","All"},
						 /*12. Epp type : SJH.20141111.ADD : 임시 나중 수정!! */
						 {"CD01956","","All"} 
  						};
  						
			  	;
 			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
		       	
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
	 * ESM_COA_035: Account 별 Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInqSrcDtAcct0035List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0035Event event = (EsmCoa0035Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
		SalesOffiRepoRtnVO rtnVo= new SalesOffiRepoRtnVO();

		try{

			List<SalesOffiRepoRtnVO> list = new ArrayList<SalesOffiRepoRtnVO>();
			rtnVo.setRowSet( (DBRowSet)command.searchInqSrcDtAcct0035List(conVo).get(0) );
			rtnVo.setSalesOffiRepoConditionVO(conVo); 
			
			list.add( rtnVo ); 
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
	 * ESM_COA_035: Account excelldown event handling<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownInqSrcDtAcct0035List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0035Event event = (EsmCoa0035Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
		
		List<Object> oList = null;
		
		try{
			oList = command.searchInqSrcDtAcct0035List(conVo);					
			
			eventResponse.setCustomData("rowset", (DBRowSet)oList.get(0));
			eventResponse.setCustomData("title", (String[])oList.get(1));
			eventResponse.setCustomData("columns", (String[])oList.get(2));
			eventResponse.setCustomData("fileName", "ESM_COA_0035DL.xls");
			eventResponse.setCustomData("isZip", false);

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
	 * ESM_COA_035: By Type size, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInqSrcDtTpSz0035List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0035Event event = (EsmCoa0035Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
		SalesOffiRepoRtnVO rtnVo= new SalesOffiRepoRtnVO();

		try{

			List<SalesOffiRepoRtnVO> list = new ArrayList<SalesOffiRepoRtnVO>();
			rtnVo.setRowSet( (DBRowSet)command.searchInqSrcDtTpSz0035List(conVo).get(0));
			rtnVo.setSalesOffiRepoConditionVO(conVo); 
			
			list.add( rtnVo );
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
	 * ESM_COA_035: Type size excelldown event handling<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownInqSrcDtTpSz0035List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0035Event event = (EsmCoa0035Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
		
		List<Object> oList = null;
		
		try{
			oList = command.searchInqSrcDtTpSz0035List(conVo);					
			
			eventResponse.setCustomData("rowset", (DBRowSet)oList.get(0));
			eventResponse.setCustomData("title", (String[])oList.get(1));
			eventResponse.setCustomData("columns", (String[])oList.get(2));
			eventResponse.setCustomData("fileName", "ESM_COA_0035DL.xls");
			eventResponse.setCustomData("isZip", false);

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
	 * ESM_COA_0170 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgRmkList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0170Event event = (EsmCoa0170Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();

		try{
			List<SearchBkgRmk0170ListVO> list = command.searchBkgRemarkList(event.getSearchConditionVO());
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
	 * Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0130(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
		   String array[][] = { 
					 /*1. profitView*/
					 {"CD00939","000020: :",""},
					 /*2. office*/
					 {"CD00940","000020: :",""},
					 /*3. profitLvl*/
					 {"CD00941","000020: :",""}
					};
					
		  	;
		  	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
	       	
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
	 * ESM_COA_0130 <br>
	 * simulation no combo list, Handling the inquiry event<p>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportViewList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0130Event event = (EsmCoa0130Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();

		try{
			List<SearchReportViewListVO> list = command.searchReportViewList(event.getSearchReportViewListVO());
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESM_COA_0130 <br>
	 * simulation no combo list,  Handling the save event<p>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiReportView(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0130Event event = (EsmCoa0130Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		try{
			begin();
			command.multiReportView(event.getSearchReportViewListVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchInqByCondition060List(Event e) throws EventException {
        EsmCoa0060Event event = (EsmCoa0060Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        String userId = event.getSignOnUserAccount().getUsr_id();
        try{
        	SalesRPTBC command = new SalesRPTBCImpl();
            event.getSalesRPTCommonVO().setEventName("EsmCoa0060Event");
            SalesRPTCommonVO rtnVo = command.searchInqByCondition060List(event.getSearchConditionVO(), event.getSalesRPTCommonVO(), userId);
            eventResponse.setETCData("header", rtnVo.getHeader());
            eventResponse.setETCData("headerNM", rtnVo.getHeaderNM());
            eventResponse.setRsVo(rtnVo.getRowSet());
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }    
    
	/**
	 * Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchInqByCondition060List2(Event e) throws EventException {
	   log.debug("####################### 멀티.searchInqByCondition060List2() #############  [START]");
       EsmCoa0060Event event = (EsmCoa0060Event)e;
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       String userId = event.getSignOnUserAccount().getUsr_id();
       try{
       		SalesRPTBC command = new SalesRPTBCImpl();
           event.getSalesRPTCommonVO().setEventName("EsmCoa0060Event");
           SalesRPTCommonVO retVo = command.searchInqByCondition060List2(event.getSearchConditionVO(), event.getSalesRPTCommonVO(), userId);

           eventResponse.setETCData("header", (String)retVo.getHeader());
           eventResponse.setETCData("headerNM", (String)retVo.getHeaderNM());

           log.debug("####################### 멀티.searchInqByCondition060List2() #############  [END]");
           return eventResponse;
           
       }catch(EventException ex){
           log.error("err " + ex.toString(), ex);
           throw new EventException(ex.getMessage());
       }catch(Exception ex){
           throw new EventException(ex.getMessage(), ex);
       }
   } 
   /**
	 * Common code Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0060(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0060Event event = (EsmCoa0060Event)e;
	   	CommonBC commonBC = new CommonBCImpl();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
    		    String array[][] = { {"keyAcctIndvl",event.getSearchConditionVO().getFKeyAcctGroupCd(),"All"}
 									};
			 	;
			 	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
 	
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"rLane",event.getSearchConditionVO().getFTrdCd(),"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);

    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)){
    		    /*Select Customized RPT Form*/
    		    String array[][] = { {"slctItmFom",account.getUsr_id(),"Blank"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);

    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
    		    String ofc_cd = ConstantMgr.getHeadOfficeCode(); //실제 ofc Code를 사용시에는 밑에 줄 Logic을 사용한다.
    		                                                     //현재 HO와 같은 권한 부여를 위하여 지정함
	       		//String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
	       		String ofc_lvl = "1";//실제 ofc Level을 사용시에는 밑에 줄 Logic을 사용한다.
//		       	String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	       				        
	       		String ofc_lvl2 = event.getSearchConditionVO().getFRhqCd();
	       		String year = JSPUtil.getNull(event.getSearchConditionVO().getFYear(),com.clt.framework.component.util.DateTime.getYear() + "");
	       		String month = JSPUtil.getNull(event.getSearchConditionVO().getFSlsMon(), JSPUtil.getNull(event.getSearchConditionVO().getFFmMon(),Utils.getCurrentMon()));
	       		
	       		String array[][] = { {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl2+"|" + year +"|" + month,"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)){
	   		    String array[][] = { {"mltTrdIndvl",event.getSearchConditionVO().getFMltTrdGroupCd(),"All"}
					};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
					
    	   }else { 
    		   /*-------------------------------------------------------*/
		       	String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
		       	String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
		       	//SJH.20150106.MOD
		       	String prevWeek[] = commonBC.searchPrevWkPrdYW();									
		       	String fYear = prevWeek[0];
		       	String period = commonBC.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");

		       	eventResponse.setETCData("ofc_cd", ofc_cd);
		       	eventResponse.setETCData("ofc_lvl",ofc_lvl );
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);									//SJH.20150106.ADD
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);									//SJH.20150106.MOD
		       	eventResponse.setETCData("period", period);
		       	
		        /*-------------------------------------------------------*/
		       	String array[][] = { 
		       			 /*1. Profit View*/
		       			 {"rptAuth","CD00939|"+ofc_lvl,""}, 
		       			 /*2. Office View*/
						 {"rptAuth","CD00940|"+ofc_lvl,""},
						 /*3. Profit Level*/
						 {"rptAuth","CD00941|"+ofc_lvl,""},
						 /*4. Office Level*/
						 {"allOFCLevel",ofc_lvl,""},
						 /*5. Office*/
						 {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl+"|" + com.clt.framework.component.util.DateTime.getYear() +"|" + Utils.getCurrentMon(),"All"},
						 /*6. Trade*/
						 {"trade","","All"}, 
						 /*7.Lane*/
						 {"rLane","","All"}, 
						 /*8. Direction*/
						 {"CD00593","","All"}, 
						 /*9. Key Acct(Group)*/
						 {"keyAcctGroup","","All"}, 
						 /*10.Key Acct(individual)*/
						 {"keyAcctIndvl","","All"},
//						 /*11.Rep. Commodity*/				//20160115.MOD
//						 {"commodity","","All"},
						 /*12.US Mode*/
						 {"CD00777","","All"},
						 /*13.Type/Size*/
						 {"tpSz","","All"},
						 /*14. Epp type : SJH.20141112.ADD : 임시 나중 수정!! */
						 {"svcScpCd","","All"},
						 /*15.Select Customized RPT Form*/
						 {"slctItmFom",account.getUsr_id(),""},	 						
						 /*16. M/A(Group)*/
						 {"mltTrdGroup","","All"}, 
						 /*17. M/A(individual)*/
						 {"mltTrdIndvl","","All"},
						 /*18. Epp type : SJH.20141112.ADD : 임시 나중 수정!! */
						 {"CD01956","","All"}
  						};
  						
			  	;
			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
			  	log.debug("");
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
	 * Common code Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0059(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		List<GetCodeSelectVO> list = null;
		try {
			/* Select Customized RPT Form */
			list = codeUtil.getCodeSelectList("slctItmFom",account.getUsr_id());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}       	
		       	
	 /**
    * 1. Function : simulation no combo list Handling the inquiry event<p>
    * 2. Overview : <p>
    * 3. Caution : <p>
    * ===================================<br>


    * ===================================<br>
    * <p/>
    * @return EventResponse
    * @exception EventException
    */
   private EventResponse searchSetForm059List(Event e) throws EventException {
       EsmCoa0059Event event = (EsmCoa0059Event)e;
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       try{
    	   SalesRPTBC command = new SalesRPTBCImpl();
           List<SearchSetForm059ListVO> list = command.searchSetForm059List(event.getSearchConditionVO(), event.getSalesRPTCommonVO());
           
           String seqNo = "";
           if(event.getSearchConditionVO().getFSelgroup().equals("")){
               int listCnt = list.size();
               for(int i=0; i<listCnt; i++){
            	   seqNo = ((SearchSetForm059ListVO)list.get(i)).getSlctItmFomSeq();
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
	 * Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
   private EventResponse searchSetForm059List2(Event e) throws EventException {
       EsmCoa0059Event event = (EsmCoa0059Event)e;
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       try{
    	   SalesRPTBC command = new SalesRPTBCImpl();
           List<SearchSetForm059List2VO> list = command.searchSetForm059List2(event.getSearchConditionVO(), event.getSalesRPTCommonVO(), account);
           
           String seqNo = "";
           if(event.getSearchConditionVO().getFSelgroup().equals("")){
               int listCnt = list.size();
               for(int i=0; i<listCnt; i++){
            	   seqNo = ((SearchSetForm059List2VO)list.get(i)).getSlctItmFomSeq();
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
	 * Handling multi event<br>
	 * Creation the cost of sales management event, Handling multi event<br>
	 * 
	 * @param e Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
    private EventResponse multiSetForm059(Event e) throws EventException {
        EsmCoa0059Event event = (EsmCoa0059Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            SalesRPTBC command = new SalesRPTBCImpl();
            event.getSalesRPTCommonVO().setEventName("EsmCoa0059Event");
            eventResponse = (GeneralEventResponse) command.multiSetForm059(event.getSearchConditionVO(), event.getSalesRPTCommonVO(), event.getSalesRPTCommonVOs(), event.getCoaRptItmInfoMstVOs(), event.getCoaRptItmInfoDtlVOs(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }
    /**
	 * Common code Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0061(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC commonBC = new CommonBCImpl();
       try {    
		   /*-------------------------------------------------------*/
	       	String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
	       	String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	       	
	       	eventResponse.setETCData("ofc_cd", ofc_cd);
	       	eventResponse.setETCData("ofc_lvl",ofc_lvl );
	       	
	        /*-------------------------------------------------------*/
	       	String array[][] = { 
	       			 /*1. Profit View*/
	       			 {"rptAuth","CD00939|"+ofc_lvl,""}, 
					 /*2. Profit Level*/
					 {"rptAuth","CD00941|"+ofc_lvl,""},
	       			 /*3. Type/Size*/
	       			 {"tpSz","","All"}
					};
					
		  	;
		  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
	       	
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
	 * ESM_COA_0061 <br>
	 * Inquiry By BKG - 1st Sheet Inquiry<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBKG0061List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0061Event event = (EsmCoa0061Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();

		try{
			List<BkgRpt0061VO> list = command.searchBKG0061List(event.getSearchConditionVO());
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
	 * ESM_COA_0061 <br>
	 * Inquiry By BKG - 2nd Sheet Inquiry<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBKG0061List2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0061Event event = (EsmCoa0061Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		SearchConditionVO searchConditionVO = event.getSearchConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonCoaRsVO commonCoaRsVO = command.searchBKG0061List2(searchConditionVO); 
			commonCoaRsVO.setConditionVO(searchConditionVO);
			returnVOList.add(commonCoaRsVO);
			eventResponse.setRsVoList(returnVOList);
			eventResponse.setETCData("header", commonCoaRsVO.getHeader());
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
	 * ESM_COA_0061 <br>
	 * Inquiry By BKG- 3rd Sheet Inquiry<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBKG0061List3(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0061Event event = (EsmCoa0061Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonCoaRsVO commonCoaRsVO = command.searchBKG0061List3(event.getSearchConditionVO());
			returnVOList.add(commonCoaRsVO);
			eventResponse.setRsVoList(returnVOList);
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
	 * Common code Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0070(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0070Event event = (EsmCoa0070Event)e;
	   	CommonBC commonBC = new CommonBCImpl();
       try {    
    	   SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
    	  if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"rLane",conVo.getFTrdCd(),"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);

    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
    		    String ofc_cd = ConstantMgr.getHeadOfficeCode(); 
                                                                
                //String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
    		    String ofc_lvl = "1";
//		       	String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	       				        
	       		String ofc_lvl2 = conVo.getFOfcLvl1();
	       		String year = JSPUtil.getNull(conVo.getFYear(),com.clt.framework.component.util.DateTime.getYear() + "");
	       		String month = JSPUtil.getNull(conVo.getFSlsMon(), JSPUtil.getNull(conVo.getFFmMon(),Utils.getCurrentMon()));
	       		
	       		String array[][] = { {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl2+"|" + year +"|" + month,"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	  
    	   }else { 
    		   /*-------------------------------------------------------*/
		       	String ofc_cd = account.getOfc_cd();
		       	String ofc_lvl = "1";
//		       	String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
		       	//SJH.20150106.MOD
		       	String prevWeek[] = commonBC.searchPrevWkPrdYW();									
		       	String fYear = prevWeek[0];
		       	String period = commonBC.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");	       	
		        
		       	eventResponse.setETCData("ofc_cd", ofc_cd);
		       	eventResponse.setETCData("ofc_lvl",ofc_lvl );
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);									//SJH.20150106.ADD
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);									//SJH.20150106.MOD
		       	eventResponse.setETCData("period", period);
		       	
		        /*-------------------------------------------------------*/
		       	String array[][] = { 
		       			 /*1. Profit View*/
		       			 {"rptAuth","CD00939|"+ofc_lvl,""}, 
		       			 /*2. Office View*/
						 {"rptAuth","CD00940|"+ofc_lvl,""},
						 /*3. Profit Level*/
						 {"rptAuth","CD00941|"+ofc_lvl,""},
						 /*4. Office Level*/
						 {"allOFCLevel",ofc_lvl,""},
						 /*5. Office*/
						 {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl+"|" + com.clt.framework.component.util.DateTime.getYear() +"|" + Utils.getCurrentMon(),"All"},
						 /*6. Office Level2*/
						 {"allOFCLevel",Integer.parseInt(ofc_lvl)>5 ? "6":String.valueOf(Integer.parseInt(ofc_lvl)+1),""},
						 
						 /*7. Trade*/
						 {"trade","","All"}, 
						 /*8.Lane*/
						 {"rLane","","All"}, 
						 /*9. Direction*/
						 {"CD00593","","All"},
						 /*10. Report Option */
						 {"CD20024","",""}
  						};
  						
			  	;
			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
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
	 * Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    public EventResponse searchRPTbyOfc0070List11(Event e) throws EventException {
    	
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0070Event event = (EsmCoa0070Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
		SalesOffiRepoRtnVO rtnVo= new SalesOffiRepoRtnVO();
		CommonBC commonBC = new CommonBCImpl();
		try {

			conVo.setFPrevWeek( commonBC.searchPreWeek(conVo.getFYear2(), conVo.getFWk()) );
			conVo.setFCurrWeek( conVo.getFYear2() + conVo.getFWk() );
			
			List<SalesOffiRepoRtnVO> list = new ArrayList<SalesOffiRepoRtnVO>();
			rtnVo.setRowSet( command.searchRPTbyOfc0070List11(conVo));
			rtnVo.setSalesOffiRepoConditionVO(conVo); 
			rtnVo.setFPreWeek( commonBC.searchPreWeek(conVo.getFYear(), conVo.getFWk()) ); // PreWeek
			
			list.add( rtnVo );
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
     * Handling the inquiry event<br>
     * MultiDimensionRPT event list, Handling the inquiry event<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse searchRPTbyOfc0070List12(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0070Event event = (EsmCoa0070Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
		SalesOffiRepoRtnVO rtnVo= new SalesOffiRepoRtnVO();
		CommonBC commonBC = new CommonBCImpl();
		try {

			List<SalesOffiRepoRtnVO> list = new ArrayList<SalesOffiRepoRtnVO>();
			rtnVo.setRowSet( command.searchRPTbyOfc0070List12(conVo));
			rtnVo.setSalesOffiRepoConditionVO(conVo);
			rtnVo.setFPreWeek( commonBC.searchPreWeek(conVo.getFYear(), conVo.getFWk()) ); // PreWeek
			
			list.add( rtnVo );
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
	 * Common code Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0072(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0072Event event = (EsmCoa0072Event)e;
	   	MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
	   	CommonBC commonBC = new CommonBCImpl();
	   	List<MultiDimensionRptRtnVO> list = null;
	   	RepoPfmcConditionVO conVo = event.getRepoPfmcConditionVO();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"rLane",conVo.getFTrdCd(),"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);

    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){    		   
    		   
    		   String ofc_cd = ConstantMgr.getHeadOfficeCode(); 
                                                                
              //String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
    		    String ofc_lvl = "1";
//		       	String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	       				        
	       		String ofc_lvl2 = conVo.getFOfcLvl();
	       		String year = JSPUtil.getNull(conVo.getFYear(),com.clt.framework.component.util.DateTime.getYear() + "");
	       		String month = JSPUtil.getNull(conVo.getFFmMon(), JSPUtil.getNull(conVo.getFFmMon(),Utils.getCurrentMon()));
	       		
	       		String array[][] = { {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl2+"|" + year +"|" + month,"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	  
    	   }else { 
    		   /*-------------------------------------------------------*/
		       	String ofc_cd = account.getOfc_cd();
		       	String ofc_lvl = "1"; 
//		       	String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
		       	//SJH.20150106.MOD
		       	String prevWeek[] = commonBC.searchPrevWkPrdYW();									
		       	String fYear = prevWeek[0];
		       	String period = commonBC.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");
		        
		       	eventResponse.setETCData("ofc_cd", ofc_cd);
		       	eventResponse.setETCData("ofc_lvl",ofc_lvl );
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);									//SJH.20150106.ADD
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);									//SJH.20150106.MOD
		       	eventResponse.setETCData("period", period);
		       	
		       	list =  command.searchWeeklySalesByOffice3HeaderList(conVo);
		       	
		       	StringBuffer headCode1 = new StringBuffer(); //sheet1 
		    	StringBuffer headName1 = new StringBuffer();
		    	StringBuffer headCode2 = new StringBuffer(); //sheet2 
		    	StringBuffer headName2 = new StringBuffer();
		    	StringBuffer headCode3 = new StringBuffer(); //sheet3
		    	StringBuffer headName3 = new StringBuffer();
		    	
		    	if (list != null && list.size() > 0){
			    	DBRowSet[] rowSet = list.get(0).getRowSets();
			    	if (rowSet != null) {
						while (rowSet[0].next()) {
							headCode1.append("|").append(JSPUtil.getNull(rowSet[0].getString("trd_cd")));
							headName1.append("|").append(JSPUtil.getNull(rowSet[0].getString("trd_cd")));
						}
						while (rowSet[1].next()) {
							headCode2.append("|").append(JSPUtil.getNull(rowSet[1].getString("stnd_cost_cd")));
							headName2.append("|").append(JSPUtil.getNull(rowSet[1].getString("rpt_itm_desc")));
						}
						headCode3 = headCode2;
						headName3 = headName2;
					}
			    	eventResponse.setETCData("headCode1", headCode1.toString());
			    	eventResponse.setETCData("headName1", headName1.toString());
			    	eventResponse.setETCData("headCode2", headCode2.toString());
			    	eventResponse.setETCData("headName2", headName2.toString());
			    	eventResponse.setETCData("headCode3", headCode3.toString());
			    	eventResponse.setETCData("headName3", headName3.toString());
		    	}
				
		        /*-------------------------------------------------------*/
		       	String array[][] = { 
		       			 /*1. Profit View*/
		       			 {"rptAuth","CD00939|"+ofc_lvl,""}, 
		       			 /*2. Office View*/
						 {"rptAuth","CD00940|"+ofc_lvl,""},
						 /*3. Profit Level*/
						 {"rptAuth","CD00941|"+ofc_lvl,""},
						 /*4. By Object*/
						 {"CD00970","",""}, 
						 /*5. Office Level*/
						 {"allOFCLevel",ofc_lvl,""},
						 /*6. Office*/
						 {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl+"|" + com.clt.framework.component.util.DateTime.getYear() +"|" + Utils.getCurrentMon(),"All"},
						 /*7. Trade*/
						 {"trade","","All"}, 
						 /*8.Lane*/
						 {"rLane","","All"}, 
						 /*9. Direction*/
						 {"CD00593","","All"},
						 {"CD20036","","All"}
  						};
  						
			  	;
			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_COA_0072: Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklySalesByOffice3TEUBased1List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0072Event event = (EsmCoa0072Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		RepoPfmcConditionVO conVo = event.getRepoPfmcConditionVO();
		List<MultiDimensionRptRtnVO> list = null;
		
		try {
			list =  command.searchWeeklySalesByOffice3TEUBased1List(conVo);			
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
	 * ESM_COA_0072: Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklySalesByOffice3TEUBased2List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0072Event event = (EsmCoa0072Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		RepoPfmcConditionVO conVo = event.getRepoPfmcConditionVO();
		List<MultiDimensionRptRtnVO> list = null;
		
		try {
			list =  command.searchWeeklySalesByOffice3TEUBased2List(conVo);			
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
	 * ESM_COA_0072: Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklySalesByOffice3TEUBased3List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0072Event event = (EsmCoa0072Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		RepoPfmcConditionVO conVo = event.getRepoPfmcConditionVO();
		List<MultiDimensionRptRtnVO> list = null;
		
		try {
			list =  command.searchWeeklySalesByOffice3TEUBased3List(conVo);			
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
	 * Handling the inquiry event<br>
	 * About the MultiDimension 0144 popup, Handling the inquiry event<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchShipperList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0144Event event = (EsmCoa0144Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();

		try{
			List<ShipperVO> list = command.searchShipperList(event.getSearchConditionVO());
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
	 * Common code Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0080(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0080Event event = (EsmCoa0080Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
	   	SearchLgstConditionVO conVo = event.getSearchLgstConditionVO();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"rLane",conVo.getFTrdCd(),"All"}
								};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	  
    	   }else { 
		       	String array[][] = {
		       			 /*1.Report*/
						 {"CD20024","",""},
		       			 /*2. Trade*/
						 {"trade","","All"}, 
						 /*3.Lane*/
						 {"rLane","","All"}, 
						 /*4. Direction*/
						 {"CD00593","","All"},
						 /*5. Logistics KPI*/
						 {"CD01064","","All"},
						 /*6.Logistics KPI*/
						 {"lgsKPI","","All"}
  						};
		       	
		        //SJH.20150106.ADD, MOD
		       	String prevWeek[] = codeUtil.searchPrevWkPrdYW();
		       	String fYear = prevWeek[0];
		       	String period = codeUtil.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");

			  	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
		  		//SJH.20150106.ADD, MOD
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);
		       	eventResponse.setETCData("period", period);
		       	
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
	 * ESM_COA_0080 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogisticsRPT0080List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0080Event event = (EsmCoa0080Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();
		
		try{
			List<SearchLogisticsRPT0080ListVO> list = command.searchLogisticsRPT0080List(event.getSearchLgstConditionVO());
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
	 * ESM_COA_0080 <br>
	 * <br>
	 * detail
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogisticsRPT0080List2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0080Event event = (EsmCoa0080Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();
		
		try{
			List<SearchLogisticsRPT0080ListVO2> list = command.searchLogisticsRPT0080List2(event.getSearchLgstConditionVO());
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
	 * Common code Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0081(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0081Event event = (EsmCoa0081Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
	   	SearchLgstConditionVO conVo = event.getSearchLgstConditionVO();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
    		    String array[][] = { {"lgsOFC",conVo.getFRhqCd(),"All"}
								};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	  
    	   }else { 
		       	String array[][] = { 
		       			 /*1. Report*/
						 {"CD20009","",""}, 
		       			 /*2. RHQ*/
						 {"lgsRHQ","","All"}, 
						 /*3.Office*/
						 {"lgsOFC","","All"}, 
						 {"CD00591","","All"},		//SJH.20140730.MOD : CD01328->CD00591 
						 {"CD01065","","All"},
						 /*3. Logistics KPI*/
						 {"CD01064","","All"},
						 /*4.Logistics KPI*/
						 {"lgsKPI","","All"}
  						};
		       	
		        //SJH.20150106.ADD, MOD
		       	String prevWeek[] = codeUtil.searchPrevWkPrdYW();
		       	String fYear = prevWeek[0];
		       	String period = codeUtil.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");

			  	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
			  	
		  		//SJH.20150106.ADD, MOD
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);
		       	eventResponse.setETCData("period", period);
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
	 * ESM_COA_0081 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogisticsRPT0081List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0081Event event = (EsmCoa0081Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();
		
		try{
			List<SearchLogisticsRPT0081ListVO> list = command.searchLogisticsRPT0081List(event.getSearchLgstConditionVO());
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
	 * ESM_COA_0081 <br>
	 * <br>
	 * detail
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogisticsRPT0081List2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0081Event event = (EsmCoa0081Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();
		
		try{
			List<SearchLogisticsRPT0081ListVO2> list = command.searchLogisticsRPT0081List2(event.getSearchLgstConditionVO());
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
	 * Common code Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0082(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0082Event event = (EsmCoa0082Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
	   	SearchLgstConditionVO conVo = event.getSearchLgstConditionVO();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"rLane",conVo.getFTrdCd(),"All"}
								};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else if  (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
	    		    String array[][] = { {"lgsOFC",conVo.getFRhqCd(),"All"}
									};
					eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
	    	  
    	   }else { 
		       	String array[][] = { 
		       			 /*1. Trade*/
						 {"trade","","All"}, 
						 /*2.Lane*/
						 {"rLane","","All"}, 
						 /*3. Direction*/
						 {"CD00593","","All"},
						 /*4. RHQ*/
						 {"lgsRHQ","",""}, 
						 /*5.Office*/
						 {"lgsOFC","","All"}, 
						 {"CD01065","",""}, 
						 {"CD00591","","All"},		//SJH.20140730.MOD : CD01328->CD00591
						 /*6.Logistics KPI*/
						 {"lgsKPI","","All"}
  						};
		       	
		        //SJH.20150106.ADD, MOD
		       	String prevWeek[] = codeUtil.searchPrevWkPrdYW();
		       	String fYear = prevWeek[0];
		       	String period = codeUtil.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");
			  	
			  	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
		  		//SJH.20150106.ADD, MOD
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);
		       	eventResponse.setETCData("period", period);
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
	 * ESM_COA_0082 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogisticsRPT0082List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0082Event event = (EsmCoa0082Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();
		
		try{
			List<SearchLogisticsRPT0082ListVO> list = command.searchLogisticsRPT0082List(event.getSearchLgstConditionVO());
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
	 * ESM_COA_0082 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogisticsRPT0082List2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0082Event event = (EsmCoa0082Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();
		
		try{
			List<SearchLogisticsRPT0082ListVO2> list = command.searchLogisticsRPT0082List2(event.getSearchLgstConditionVO());
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
	 * Common code Handling the inquiry event<br>
	 * MultiDimensionRPT event list, Handling the 정nquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0158(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0158Event event = (EsmCoa0158Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
	   	SearchLgstConditionVO conVo = event.getSearchLgstConditionVO();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
    		    String array[][] = { {"lgsOFC",conVo.getFRhqCd(),"All"}
								};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	  
    	   }else { 
		       	String array[][] = { 
		       			 {"CD20009","",""}, 
		       			 /*1. RHQ*/
						 {"lgsRHQ","","All"}, 
						 /*2.Office*/
						 {"lgsOFC","","All"}
  						};
  						
			  	;
		        //SJH.20150106.ADD, MOD
		       	String prevWeek[] = codeUtil.searchPrevWkPrdYW();
		       	String fYear = prevWeek[0];
		       	String period = codeUtil.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");
			  	
			  	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
		  		//SJH.20150106.ADD, MOD
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);
		       	eventResponse.setETCData("period", period);
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
	 * ESM_COA_0158 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogisticsRPT0158List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0158Event event = (EsmCoa0158Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();
		
		try{
			List<SearchLogisticsRPT0158ListVO> list = command.searchLogisticsRPT0158List(event.getSearchLgstConditionVO());
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
	 * ESM_COA_2003: [P/L Report Item Management]<br>
	 * [Profit Level information, Profit View information] [retrieve]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList2003(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
	   	
	   	try{
	   		if (e.getFormCommand().isCommand(FormCommand.INIT)){
		       	String array[][] = { {"CD00205","",""}, {"CD00939","",""} };
	   			
		       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
	 	    }
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse; 

   }
	
	/**
	 * ESM_COA_2003: [P/L Report Item Management]<br>
	 * [P/L Report Item information] [retrieve]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPnlRptItem(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		try{
			List<PnlRptItemVO> list = command.searchPnlRptItem();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_2003: [P/L Report Item Management]<br>
	 * [P/L Report Item information] [create/save/delete]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiPnlRptItem(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa2003Event event = (EsmCoa2003Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		try{
			begin();
			String DupChk = command.multiPnlRptItem(event.getPnlRptItemVOS(), account);
			//command.multiPnlRptItem(event.getPnlRptItemVOS(), account);
			if(DupChk.equals("Dup")){
				rollback();
			}
			else{
				commit();
			}
			eventResponse.setETCData("dup_chk", DupChk);
					
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	
	   /**
		 * Common code Handling the inquiry event<br>
		 * MultiDimensionRPT event list, Handling the inquiry event<br>
		 * 
		 * @param e Event
		 * @return response EventResponse
		 * @exception EventException
		 * @author SJH.20150320.ADD
		 */
	   private EventResponse searchComBoCdList4006(Event e) throws EventException {
		   	//현재 안씀 혹여나 추후..
		   	GeneralEventResponse eventResponse = new GeneralEventResponse();
		   	CommonBC commonBC = new CommonBCImpl();
		   	List<GetCodeSelectVO> list = null;
	       try {    
		        /*-------------------------------------------------------*/
	    	    String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	    	    
	    	    eventResponse.setETCData("ofc_lvl",ofc_lvl );
	    	    
		       	String array[][] = { 
		       			 /*1. Type/Size*/
		       			{"rptAuth","CD00941|"+ofc_lvl,""}
						};
			  	;
			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
		       	
				//SJH.20150508.소스품질
				if(list != null) {
					eventResponse.setRsVoList(list);
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
		 * ESM_COA_4006 <br>
		 * (CMTX)Route Cost Inqiury - Prictin popup Sheet Inquiry<br>
		 * 
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 * @author SJH.20150320.ADD
		 */
		private EventResponse searchBKG4006List(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmCoa4006Event event = (EsmCoa4006Event)e;
			PreCMSimulationBC command = new PreCMSimulationBCImpl();
			List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

			try{	
				CommonCoaRsVO commonCoaRsVO = command.searchBKG4006List(event.getSearchConditionVO(), event.getTrfChgVOS());
				returnVOList.add(commonCoaRsVO);
				eventResponse.setRsVoList(returnVOList);
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
		 * Common code Handling the inquiry event<br>
		 * MultiDimensionRPT event list, Handling the inquiry event<br>
		 * 
		 * @param e Event
		 * @return response EventResponse
		 * @exception EventException
		 * @author SJH.20150320.ADD
		 */
	   private EventResponse searchComBoCdList4007(Event e) throws EventException {
		   	//현재 안씀 혹여나 추후..
		   	GeneralEventResponse eventResponse = new GeneralEventResponse();
		   	EsmCoa4007Event event = (EsmCoa4007Event)e;
		   	CommonBC commonBC = new CommonBCImpl();
		   	List<GetCodeSelectVO> list = null;
	       try {    
		        /*-------------------------------------------------------*/
	    	    String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	    	    String eq_tp_cd = event.getFEqTpCd();
	    	    
	    	    eventResponse.setETCData("ofc_lvl",ofc_lvl );
	    	    
		       	String array[][] = { 
		       			 /*1. Type/Size*/
		       			{"cntrTpszCd",eq_tp_cd,""}
						};
			  	;
			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
		       	
				//SJH.20150508.소스품질
				if(list != null) {
					eventResponse.setRsVoList(list);
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
		 * ESM_COA_4007 <br>
		 * <br>
		 * 
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchBkgRmkList4007(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmCoa4007Event event = (EsmCoa4007Event)e;
			PreCMSimulationBC command = new PreCMSimulationBCImpl();

			try{
				CommonCoaRsVO list = command.searchBkgRemarkList4007(event.getSearchConditionVO());
				eventResponse.setRsVo(list.getDbRowset());	
				return eventResponse; 
			}catch(EventException ex){
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
			}catch(Exception ex){
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
			}	
		}	

}