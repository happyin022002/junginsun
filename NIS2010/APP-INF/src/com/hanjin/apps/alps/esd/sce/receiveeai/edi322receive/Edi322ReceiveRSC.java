/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Edi322ReceiveRSC
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-01
*@LastModifier :
*@LastVersion : 1.0
* 2009-11-01 
* 1.0 최초 생성
* 2010-11-08 김진승 [소스품질보완] 중첩 try catch - private method로 모두 분리
=========================================================*/
package com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.basic.Edi322ReceiveBC;
import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.basic.Edi322ReceiveBCImpl;
import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.event.EsdSce0150Event;
import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.vo.SearchEdi322ActDatRcvDtVO;
import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.vo.SearchEdi322BkgNoVO;
import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.vo.SearchEdi322CntrNoVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * ENIS-SCE EDI_322_MSG Logic ServiceCommand<br>
 * - ENIS-SCE에 EDI_322_MSG에 대한 비지니스 트랜잭션을 처리한다.<br>
 * @param 
 * @author 
 * @see 
 * @since J2EE 1.4
 */
public class Edi322ReceiveRSC extends ServiceCommandSupport {

	/**
	 * Edi322ReceiveRSC 업무 시나리오 선행작업<br>
	 * Edi322ReceiveRSC 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("Edi322ReceiveRSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * Edi322ReceiveRSC 업무 시나리오 마감작업<br>
	 * Edi322ReceiveRSC 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("Edi322ReceiveRSC 종료");
	}
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ENIS-SCEM 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("EsdSce0150Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = createEDI322data(e);
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
	public EventResponse createEDI322data(Event e) throws EventException {

		EventResponse eventResponse = new GeneralEventResponse();
		Edi322ReceiveBC command = null;
		String str = "";
		
		try {
			command = new Edi322ReceiveBCImpl();
			str = ((EsdSce0150Event)e).getString();
			
			/*  넘어온 전문을 HDR/CNTR/LOC로 분해한다.  */
			//eventResponse = command.getEDI322DataFormat(str);
/*			
			 str=
			 "$$$MSGSTART:NS                  HANJIN              322       UDEV:71594668       \n"+    
             "{CNTR_MAIN                                                                    \n"+ 
             "AREA:USA                                                                      \n"+ 
             "MSG_ID:322                                                                    \n"+ 
             "CNTR_NO:CAIU823764                                                            \n"+ 
             "TMNL_ID:NS                                                                    \n"+ 
             "EVENT_YARD:USSAVNS                                                            \n"+ 
             "EVENT_YARD_US:461417                                                          \n"+ 
             "EVENT_DT:201305311625                                                         \n"+ 
             "MVMT_STS:                                                                     \n"+ 
             "EVENT_STS:AL                                                                  \n"+ 
             "GATE_IO:OA                                                                    \n"+ 
             "FL_MT_IND:M                                                                   \n"+ 
             "SIGHT_CD:                                                                     \n"+ 
             "CHSS_CODE:                                                                    \n"+ 
             "CALLSIGN:                                                                     \n"+ 
             "LLOYD_NO:                                                                     \n"+ 
             "BL_NO:                                                                        \n"+ 
             "POL:                                                                          \n"+ 
             "POD:                                                                          \n"+ 
             "DEST_LOC:                                                                     \n"+ 
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
             "BKG_NO:ATL219018100                                                           \n"+ 
             "}BKG_NO                                                                       \n"+ 
			 "}CNTR_MAIN                                                                    \n"; 
*/

			 log.info("\n\n\n 322 Full String : \n\n\n"+str);
			 
			 ArrayList<HashMap<String, String>> totParamArrLst; 
			
			//1.parsing 
			//begin();
			totParamArrLst = command.getEDI322DataFormat(str);
			//commit();
			
			//begin();
			///*  분해된 HDR/CNTR_LIST/LOC로 임시 TABLE에 넣는다.  */
			//command.createEDI322TmpData(totParamArrLst);
			//commit();
			
			//begin();
			//2.db저장
			Map<String, Object> param = new HashMap<String, Object>();
			Iterator itr =totParamArrLst.iterator();
			while(itr.hasNext()){
				param =(HashMap)itr.next();
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
			//CNTR_NO 보정    11자리아닌경우
			if(cntrNo.length()==10  && !param.get("BKG_NO").equals("EMPTY REPO")){
				log.info("\n==========    cntrNo   10================================= " +cntrNo );
				searchEdi322CntrNoVO.setCntrNo(cntrNo);
				cntrNo = searchEdi322CntrNoVOUnit(command, searchEdi322CntrNoVO);
			}else if(cntrNo.length() >11 && !param.get("BKG_NO").equals("EMPTY REPO")){
				cntrNo = cntrNo.substring(0,11);
			}
			param.put("CNTR_NO", cntrNo);     //보정된 CNTR_NO 넣기
			
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
				   param.get("EVENT_STS").equals("J") ||		// CHM-201324593 : Added
				   param.get("EVENT_STS").equals("R") ||		// CHM-201324593 : Added
				   param.get("EVENT_STS").equals("A") ||		// CHM-201324593 : Added
				   param.get("EVENT_STS").equals("P")  
				   )){
					SearchEdi322BkgNoVO searchEdi322BkgNoVO = new SearchEdi322BkgNoVO();
					searchEdi322BkgNoVO.setCntrNo((String)param.get("CNTR_NO"));
					searchEdi322BkgNoVO.setBkgNo((String)param.get("BKG_NO"));
					searchEdi322BkgNoVO.setBkgNo((String)param.get("BL_NO"));
					
					// 최신 컨테이너의 최신 BKG_NO 찾기
					createEDI322dataLoopUnitInnerLoopUnit(param, searchEdi322BkgNoVO, command);
				}
				
				//20100408 YARD값이 없는 경우 DIR IF SKIP!!
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
			
			// ACT_DAT_RCV_DT 구하기
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
//				log.error("\n==========    create322SceIf 호출  searchEdi322BkgNo get BkgNo bkg# ["+bkgNo+"] sceActRcvIfVO.getBkgNo(): " +sceActRcvIfVO.getBkgNo());
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
			commd.create322SceIf(sceActRcvIfVO,bkgNo);// 미작업
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
