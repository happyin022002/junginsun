/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Edi322ReceiveRSC
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.edi322receive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBC;
import com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl;
import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.apps.opus.esd.sce.receiveeai.edi322receive.basic.Edi322ReceiveBC;
import com.clt.apps.opus.esd.sce.receiveeai.edi322receive.basic.Edi322ReceiveBCImpl;
import com.clt.apps.opus.esd.sce.receiveeai.edi322receive.event.EsdSce0150Event;
import com.clt.apps.opus.esd.sce.receiveeai.edi322receive.vo.SearchEdi322ActDatRcvDtVO;
import com.clt.apps.opus.esd.sce.receiveeai.edi322receive.vo.SearchEdi322BkgNoVO;
import com.clt.apps.opus.esd.sce.receiveeai.edi322receive.vo.SearchEdi322CntrNoVO;
import com.clt.apps.opus.esd.sce.receiveeai.edi322receive.event.EsdSce0000Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;

/**
 * SCE EDI_322_MSG Logic ServiceCommand<br>
 * - EDI_322_MSG to SCE for the business transaction to process.<br>
 * @param 
 * @author 
 * @see 
 * @since J2EE 1.4
 */
public class Edi322ReceiveRSC extends ServiceCommandSupport {

	/**
	 * Edi322ReceiveRSC predecessor business scenarios<br>
	 * Edi322ReceiveRSC business scenarios related internal object creation during calls<br>
	 */
	public void doStart() {
		try {
			// account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("Edi322ReceiveRSC Error when the predecessor " + e.toString(), e);
		}
	}

	/**
	 * Edi322ReceiveRSC finishing business scenarios<br>
	 * At the end of business-related internal objects Edi322ReceiveRSC release scenarios<br>
	 */
	public void doEnd() {
		log.debug("Edi322ReceiveRSC End");
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
		if ( e.getEventName().equalsIgnoreCase("EsdSce0000Event") || e.getEventName().equalsIgnoreCase("EsdSce0150Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				createEDI322data(e);
			}
		}
		
		return null;
	}
	
	/**
	 * EDI322 DATA를 생성한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EventResponse createEDI322data(Event e) throws EventException {

		EventResponse eventResponse = new GeneralEventResponse();
		Edi322ReceiveBC command = null;
		String str = "";
		
		try {
			command = new Edi322ReceiveBCImpl();
			//str = ((EsdSce0150Event)e).getString();
		
			if (e.getEventName().equals("EsdSce0150Event")){				
				str = ((EsdSce0150Event)e).getString();
			} else {
				str = ((EsdSce0000Event)e).getString();
			}			
			
			/*  넘어온 전문을 HDR/CNTR/LOC로 분해한다.  */
			//eventResponse = command.getEDI322DataFormat(str);
			/*
			 str=
			 "$$$MSGSTART:NS                  COMPANY              322       UDEV:71594668       \n"+    
             "{CNTR_MAIN                                                                    \n"+ 
             "AREA:USA                                                                      \n"+ 
             "MSG_ID:322                                                                    \n"+ 
             "CNTR_NO:TRLU917699                                                            \n"+ 
             "TMNL_ID:NS                                                                    \n"+ 
             "EVENT_YARD:USSAVNS                                                            \n"+ 
             "EVENT_YARD_US:461417                                                          \n"+ 
             "EVENT_DT:201005311625                                                         \n"+ 
             "MVMT_STS:                                                                     \n"+ 
             "EVENT_STS:OA                                                                  \n"+ 
             "GATE_IO:OA                                                                    \n"+ 
             "FL_MT_IND:M                                                                   \n"+ 
             "SIGHT_CD:                                                                     \n"+ 
             "CHSS_CODE:                                                                    \n"+ 
             "VVD:                                                                          \n"+ //new
             "CALLSIGN:                                                                     \n"+ 
             "LLOYD_NO:                                                                     \n"+ 
             "BL_NO:                                                                        \n"+ 
             "POL:                                                                          \n"+ 
             "POD:                                                                          \n"+ 
             "DEST_LOC:                                                                     \n"+ 
             "TI_NO:                                                                        \n"+ //new
			 "MT_PLAN:                                                                      \n"+ //new
			 "WO_NO:                                                                        \n"+ //new
			 "EP_REPOSITION:                                                                \n"+ //new
			 "CN_NO:                                                                        \n"+ //new
			 "TRANS_NO:                                                                     \n"+ //new
             "DMG_FLAG:                                                                     \n"+ 
             "PICKUP_NO:                                                                    \n"+ 
             "MG_SET:                                                                       \n"+ 
             "SUBSTITUTION:                                                                 \n"+ 
             "CARRIER_COUNTRY:US                                                            \n"+ 
             "CARRIER_CD:GPAZ                                                               \n"+ 
             "TRANS_MODE:                                                                   \n"+ 
             "FLAT_CAR_NO:                                                                  \n"+ 
             "HANGER_TAG:                                                                   \n"+ 
             "WAY_BILL_NO:                                                                  \n"+ 
             "DEL_TAG:                                                                      \n"+ 
             "SEAL_NO:                                                                      \n"+ 
             "EVNT_CTY_NM:                                                                  \n"+ 
             "EVNT_STE_CD:                                                                  \n"+ 
             "RAIL_DEST_N1ST_ETA_DT:                                                        \n"+ 
             "{BKG_NO                                                                       \n"+ 
             "BKG_NO:                                                                       \n"+ 
             "}BKG_NO                                                                       \n"+ 
			 "}CNTR_MAIN                                                                    \n"; */


			 log.info("\n\n\n 322 Full String : \n\n\n"+str);
			 
			 ArrayList<HashMap<String, String>> totParamArrLst; 
			
			//1.parsing 
			//begin();
			totParamArrLst = command.getEDI322DataFormat(str);
			//commit();
			
			//begin();
			///*  Decomposed HDR / CNTR_LIST / LOC placed in temporary TABLE.  */
			//command.createEDI322TmpData(totParamArrLst);
			//commit();
			
			//begin();
			//2.db save
			Map<String, Object> param = new HashMap<String, Object>();
			Iterator itr =totParamArrLst.iterator();
			while(itr.hasNext()){
				param =(HashMap<String, Object>)itr.next();
				createEDI322dataLoopUnit(param, command); 
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
	private void createEDI322dataLoopUnit(Map<String, Object> param, Edi322ReceiveBC command) {
		
		SearchEdi322CntrNoVO searchEdi322CntrNoVO = new SearchEdi322CntrNoVO();
		String cntrNo=null;
		
		try{
			cntrNo= ((String)param.get("CNTR_NO")).trim();
			//CNTR_NO length of 11 or length compensation
			if(cntrNo.length()==10  && !param.get("BKG_NO").equals("EMPTY REPO")){
				log.info("\n==========    cntrNo   10================================= " +cntrNo );
				searchEdi322CntrNoVO.setCntrNo(cntrNo);
				cntrNo = searchEdi322CntrNoVOUnit(command, searchEdi322CntrNoVO);
			}else if(cntrNo.length() >11 && !param.get("BKG_NO").equals("EMPTY REPO")){
				cntrNo = cntrNo.substring(0,11);
			}
			param.put("CNTR_NO", cntrNo);     //CNTR_NO corrected assignment
			
			//EVENT_DT, CNTR_NO, EVENT_STS
			if(param.get("EVENT_DT")!=null && !param.get("EVENT_DT").equals("")
			 && param.get("CNTR_NO")!=null && !param.get("CNTR_NO").equals("")
			 && param.get("EVENT_STS")!=null && !param.get("EVENT_STS").equals("")){

				createEDI322TmpDataUnit(command, param);
				
				if(!param.get("BKG_NO").equals("EMPTY REPO") && 
				   (
				   param.get("EVENT_STS").equals("AL") || 
				   param.get("EVENT_STS").equals("RL") || 
				   param.get("EVENT_STS").equals("AR") ||
				   param.get("EVENT_STS").equals("UR") ||
				   param.get("EVENT_STS").equals("P")  
				   )){
					SearchEdi322BkgNoVO searchEdi322BkgNoVO = new SearchEdi322BkgNoVO();
					searchEdi322BkgNoVO.setCntrNo((String)param.get("CNTR_NO"));
					
					// Find the latest BKG_NO latest container
					createEDI322dataLoopUnitInnerLoopUnit(param, searchEdi322BkgNoVO, command);
				}
				
				if((param.get("EVENT_STS").equals("NT") || param.get("EVENT_STS").equals("NF") || 
						param.get("EVENT_STS").equals("FT")) && ((String)param.get("EVENT_YARD")).length()>0){
					createEDI322MsgIfUnit(command, param);
				}
			
			}
		
		}catch(Exception me){
			log.error(me.getMessage());
		}
		
	}

	/**
	 * 
	 * @param param
	 * @param searchEdi322BkgNoVO
	 * @param command
	 */
	private void createEDI322dataLoopUnitInnerLoopUnit(
			Map<String, Object> param, SearchEdi322BkgNoVO searchEdi322BkgNoVO,
			Edi322ReceiveBC command) {
		try{
			List<SearchEdi322BkgNoVO> resultSearchEdi322BkgNoVO= command.searchEdi322BkgNo(searchEdi322BkgNoVO);
			
			SceActRcvIfVO sceActRcvIfVO = new SceActRcvIfVO();
			sceActRcvIfVO.setActStsMapgCd((String)param.get("EVENT_STS")); //ACT_STS_MAPG_CD
			sceActRcvIfVO.setCntrNo((String)param.get("CNTR_NO")); //CNTR_NO
			if(param.get("EVENT_STS").equals("P")&&(((String)param.get("EVENT_YARD")).length()==0)){
				sceActRcvIfVO.setNodCd("XXXXXXX"); //NOD_CD
			}else{
				sceActRcvIfVO.setNodCd((String)param.get("EVENT_YARD")); //NOD_CD
			}	
			sceActRcvIfVO.setActDt((String)param.get("EVENT_DT")); //ACT_DT
			if(((String)param.get("SNDR_ID")).length()>6){
				sceActRcvIfVO.setActCd(((String)param.get("SNDR_ID")).substring(0, 6)); //ACT_CD
			}else if(((String)param.get("SNDR_ID")).length()==0){
				sceActRcvIfVO.setActCd("");
			}else{
				sceActRcvIfVO.setActCd((String)param.get("SNDR_ID")); //ACT_CD	
			}
			sceActRcvIfVO.setRailDestN1stEtaDt((String)param.get("RAIL_DEST_N1ST_ETA_DT")); //RAIL_DEST_N1ST_ETA_DT
			sceActRcvIfVO.setUpdUsrId((String)param.get("TMNL_ID"));
			sceActRcvIfVO.setCreUsrId((String)param.get("TMNL_ID"));
			
			// Getting ACT_DAT_RCV_DT
			SearchEdi322ActDatRcvDtVO searchEdi322ActDatRcvDtVO = new SearchEdi322ActDatRcvDtVO();
			searchEdi322ActDatRcvDtVO.setEventYard((String)param.get("EVENT_YARD"));
			List<SearchEdi322ActDatRcvDtVO> resultSearchEdi322ActDatRcvDtVO= command.searchEdi322ActDatRcvDt(searchEdi322ActDatRcvDtVO);
			log.info("\n==========    SearchEdi322ActDatRcvDtVO  ========================  "  +resultSearchEdi322ActDatRcvDtVO.size());
			if(resultSearchEdi322ActDatRcvDtVO.size()>0){
				String actDatRcvDt =resultSearchEdi322ActDatRcvDtVO.get(0).getActDatRcvDt();
				sceActRcvIfVO.setActDatRcvDt(actDatRcvDt);
				log.info("\n==========    sceActRcvIfVO.setActDatRcvDt("+actDatRcvDt+")  ========================  " );
			}
			log.info("\n==========    resultSearchEdi322BkgNoVO.size():"+resultSearchEdi322BkgNoVO.size());
			CopDetailReceiveBC commd = new CopDetailReceiveBCImpl();
			for(int i=0; i< resultSearchEdi322BkgNoVO.size();i++){
				String bkgNo= resultSearchEdi322BkgNoVO.get(i).getBkgNo();
				sceActRcvIfVO.setBkgNo(bkgNo);
				create322SceIfUnit(commd, sceActRcvIfVO,bkgNo);
			}
			
		}catch(Exception ce){
			log.error("\n"+ce.getMessage());
		}	
		
	}

	/**
	 * 
	 * @param command
	 * @param searchEdi322CntrNoVO
	 * @return
	 */
	private String searchEdi322CntrNoVOUnit(Edi322ReceiveBC command,
			SearchEdi322CntrNoVO searchEdi322CntrNoVO) {
		String cntrNo = null;
		try{
			List<SearchEdi322CntrNoVO> result =command.searchEdi322CntrNoVO(searchEdi322CntrNoVO);
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
	private void createEDI322TmpDataUnit(Edi322ReceiveBC command,
			Map<String, Object> param) {
		try{
			begin();
			command.createEDI322TmpData(param);	
			commit();
			log.debug("\n1.[createEDI322TmpData sucess]=========");
		}catch(Exception ce){
			rollback();
			log.error("\n[createEDI322TmpData err]"+ce.getMessage());
		}					
	}

	/**
	 * 
	 * @param commd
	 * @param sceActRcvIfVO
	 * @param bkgNo
	 */
	private void create322SceIfUnit(CopDetailReceiveBC commd,
			SceActRcvIfVO sceActRcvIfVO, String bkgNo) {
		try{
			begin();
			commd.create322SceIf(sceActRcvIfVO,bkgNo);
			commit();
			log.debug("\n2.[create322SceIf sucess]=========");
		}catch(Exception ce){
			rollback();
			log.error("\n[createEDI322TmpData err]"+ce.getMessage());
		}								
	}

	/**
	 * @param command
	 * @param param
	 */
	private void createEDI322MsgIfUnit(Edi322ReceiveBC command,
			Map<String, Object> param) {
		try{
			begin();
			command.createEDI322MsgIf(param);
			commit();
			log.debug("\n3.[createEDI322MsgIf sucess]=========");
		}catch(Exception ce){
			log.error("\n"+ce.getMessage());
		}							
	}
	
}
