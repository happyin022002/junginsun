/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EdiBLPickUpReceiveRSC
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.16
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.basic.EdiBLPickUpReceiveBC;
import com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.basic.EdiBLPickUpReceiveBCImpl;
import com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.event.EsdSceBLPickUpEvent;
import com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.event.EsdSce0000Event;
import com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.vo.SearchEdiBLPickUpCntrNoVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;

/**
 * SCE EDI_BLPICKUP_MSG Logic ServiceCommand<br>
 * - EDI_BLPICKUP_MSG to SCE for the business transaction to process.<br>
 * @param 
 * @author 
 * @see 
 * @since J2EE 1.4
 */
public class EdiBLPickUpReceiveRSC extends ServiceCommandSupport {

	/**
	 * EdiBLPickUpReceiveRSC predecessor business scenarios<br>
	 * EdiBLPickUpReceiveRSC business scenarios related internal object creation during calls<br>
	 */
	public void doStart() {
		try {
			// account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("EdiBLPickUpReceiveRSC Error when the predecessor " + e.toString(), e);
		}
	}

	/**
	 * EdiBLPickUpReceiveRSC finishing business scenarios<br>
	 * At the end of business-related internal objects EdiBLPickUpReceiveRSC release scenarios<br>
	 */
	public void doEnd() {
		log.debug("EdiBLPickUpReceiveRSC End");
	}
	
	/**
	 * Perform tasks that correspond to each event scenario<br>
	 * SCEM quarter of all the events that occur in business processing<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		if ( e.getEventName().equalsIgnoreCase("EsdSce0000Event") || e.getEventName().equalsIgnoreCase("EsdSceBLPickUpEvent")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				createEDIBLPickUpdata(e);
			}
		}
		
		return null;
	}
	
	/**
	 * EDIBLPickUp DATA를 생성한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EventResponse createEDIBLPickUpdata(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		EdiBLPickUpReceiveBC command = null;
		String str = "";
		
		try {
			command = new EdiBLPickUpReceiveBCImpl();
			
			if (e.getEventName().equals("EsdSceBLPickUpEvent")){				
				str = ((EsdSceBLPickUpEvent)e).getString();
			} else {
				str = ((EsdSce0000Event)e).getString();
			}
			/*  넘어온 전문을 HDR/CNTR/LOC로 분해한다.  */
			//eventResponse = command.getEDIBLPickUpDataFormat(str);
			/*
			 str=
			 "$$$MSGSTART:Ceres_Hal           NYKS                BLPICKUP  ubiz1:344299877 \n"+    
             "{BLPICKUP                                                                     \n"+ 
             "BL_NBR:2341945230                                                             \n"+ 
             "PICK_NBR:00138848                                                             \n"+ 
             "CNTR_NBR:NYKU713880                                                           \n"+ 
             "YARD_CD:KRPUSY1                                                               \n"+   
             "SYS_DT:20140623102430                                                         \n"+           
			 "}BLPICKUP	                                                                    \n"; */

			 log.info("\n\n\n BLPickUp Full String : \n\n\n"+str);
			 
			 ArrayList<HashMap<String, String>> totParamArrLst; 
			
			//1.parsing 
			//begin();
			totParamArrLst = command.getEDIBLPickUpDataFormat(str);
			//commit();
			
			//begin();
			///*  Decomposed HDR / CNTR_LIST / LOC placed in temporary TABLE.  */
			//command.createEDI322TmpData(totParamArrLst);
			//commit();
			
			//begin();
			//2.db save
			Map<String, String> param = new HashMap<String, String>();
			Iterator itr =totParamArrLst.iterator();
			while(itr.hasNext()){
				param =(HashMap)itr.next();
				createEDIBLPickUpdataLoopUnit(param, command); 
			}	
			//commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse; 
	}

	/**
	 * 
	 * @param param
	 * @param command
	 */
	private void createEDIBLPickUpdataLoopUnit(Map<String, String> param, EdiBLPickUpReceiveBC command) {
		SearchEdiBLPickUpCntrNoVO searchEdiBLPickUpCntrNoVO = new SearchEdiBLPickUpCntrNoVO();
		String cntrNo=null;
		
		try{
			cntrNo= ((String)param.get("CNTR_NBR")).trim();
			param.put("EVENT_STS", "NT"); 
			//CNTR_NO length of 11 or length compensation
			if(cntrNo.length()==10 ){
				log.info("\n==========    cntrNo   10================================= " +cntrNo );
				searchEdiBLPickUpCntrNoVO.setCntrNo(cntrNo);
				cntrNo = searchEdiBLPickUpCntrNoVOUnit(command, searchEdiBLPickUpCntrNoVO);
			//}else if(cntrNo.length() >11 && !param.get("BKG_NO").equals("EMPTY REPO")){
			}else if(cntrNo.length() > 11){
				cntrNo = cntrNo.substring(0,11);
			}
			param.put("CNTR_NBR", cntrNo);     //CNTR_NO corrected assignment
			
			//EVENT_DT, CNTR_NO, EVENT_STS
			if(param.get("SYS_DT")!=null && !param.get("SYS_DT").equals("")
			 && param.get("CNTR_NBR")!=null && !param.get("CNTR_NBR").equals("")){

				createEDIBLPickUpTmpDataUnit(command, param);
				
				/*if(!param.get("BKG_NO").equals("EMPTY REPO") && 
				   (
				   param.get("EVENT_STS").equals("AL") || 
				   param.get("EVENT_STS").equals("RL") || 
				   param.get("EVENT_STS").equals("AR") ||
				   param.get("EVENT_STS").equals("UR") ||
				   param.get("EVENT_STS").equals("P")  
				   )){
					SearchEdiBLPickUpBkgNoVO searchEdiBLPickUpBkgNoVO = new SearchEdiBLPickUpBkgNoVO();
					searchEdiBLPickUpBkgNoVO.setCntrNo((String)param.get("CNTR_NO"));
					
					// Find the latest BKG_NO latest container (SCE_ACT_RCV_IF 불필요)
					//createEDIBLPickUpdataLoopUnitInnerLoopUnit(param, searchEdiBLPickUpBkgNoVO, command);
				}*/
				
				if( param.get("EVENT_STS").equals("NT") && ((String)param.get("YARD_CD")).length()>0){
					createEDIBLPickUpMsgIfUnit(command, param);
				}
			
			}
		
		}catch(Exception me){
			log.error(me.getMessage());
		}
		
	}

	/**
	 * 
	 * @param command
	 * @param searchEdiBLPickUpCntrNoVO
	 * @return
	 */
	private String searchEdiBLPickUpCntrNoVOUnit(EdiBLPickUpReceiveBC command, SearchEdiBLPickUpCntrNoVO searchEdiBLPickUpCntrNoVO) {
		String cntrNo = null;
		try{
			List<SearchEdiBLPickUpCntrNoVO> result =command.searchEdiBLPickUpCntrNoVO(searchEdiBLPickUpCntrNoVO);
			if(result.size()>0){
				cntrNo =result.get(0).getCntrNo();
				log.info("\n==========    cntrNo   10  --->    corrected cntrNo ============ " +cntrNo );
			}
		}catch(Exception se){
			log.error("\n"+se.getMessage());
		}
		return cntrNo;
	}

	/**
	 * 
	 * @param command
	 * @param param
	 */
	private void createEDIBLPickUpTmpDataUnit(EdiBLPickUpReceiveBC command, Map<String, String> param) {
		try{
			begin();
			command.createEDIBLPickUpTmpData(param);	
			commit();
			log.debug("\n1.[createEDIBLPickUpTmpData sucess]=========");
		}catch(Exception ce){
			rollback();
			log.error("\n[createEDIBLPickUpTmpData err]"+ce.getMessage());
		}					
	}

	/**
	 * @param command
	 * @param param
	 */
	private void createEDIBLPickUpMsgIfUnit(EdiBLPickUpReceiveBC command, Map<String, String> param) {
		try{
			begin();
			command.createEDIBLPickUpMsgIf(param);
			commit();
			log.debug("\n3.[createEDIBLPickUpMsgIf sucess]=========");
		}catch(Exception ce){
			log.error("\n"+ce.getMessage());
		}							
	}
	
}
