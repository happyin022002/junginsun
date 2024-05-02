/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TOTCommonSC.java
*@FileTitle : TOTCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.25 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.totcommon;

import java.util.Iterator;
import java.util.List;


import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.VslVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.BackEndJobVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.basic.TOTFindCodeBC;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.basic.TOTFindCodeBCImpl;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.event.TotcommonEvent;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.MdmLaneVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeInfoVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComBakEndJbVO;
import com.hanjin.syscommon.common.table.TotStlClzVO;


/**
 * ALPS-TOTCommon Business Logic ServiceCommand - ALPS-TOTCommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jang Chang Soo
 * @see TOTFindCodeDBDAO
 * @since J2EE 1.6
 */

public class TOTCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * TOTCommon system 업무 시나리오 선행작업<br>
	 * TOTCommon업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("TOTCommonSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * TOTCommon system 업무 시나리오 마감작업<br>
	 * TOTCommon 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("TOTCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-TOTCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("TotcommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchFmsVslInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = checkSettlementClosing(e);
			}/*else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)){
				eventResponse =  searchTrdCodeByLaneList(e);
			}*/else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)){
				eventResponse =  searchLaneCheckList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)){
				log.debug("::CALL::> SC searchPortCodeList 조회> :::::::::");
				
				eventResponse =  searchPortCodeList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				log.debug("::CALL::> SC searchDetailByBackEndJobStatus back end job key 조회> :::::::::");
				
				eventResponse =  searchDetailByBackEndJobStatus(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				log.debug("::CALL::> SC searchCreationByBackEndJobStatus back end job key 조회> :::::::::");
				
				eventResponse =  searchCreationByBackEndJobStatus(e);
			}
			
		}
		return eventResponse;
	}

	/**
	 * 공통 <br>
	 * 해당 선박코드의 vessel name 과 계약일자 데이터를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFmsVslInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TotcommonEvent event = (TotcommonEvent)e;
		
		
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
        
		String vslEngNm = null;
		String effDt = null;
		String expDt = null;
		try{
			List<VslVO> list = command.searchFmsVslInfo(event.getVslVO());
			log.debug("::CALL::> FNS_TOT_0001 SC delivery 조회끝> :::::::::");
			//eventResponse.setRsVoList(list);
			if(list.size()>0){
				vslEngNm = list.get(0).getVslEngNm();
				effDt = list.get(0).getEffDt();
				expDt = list.get(0).getExpDt();
			}else{
				vslEngNm = "";
				effDt = "";
				expDt = "";
			}
			
			eventResponse.setETCData("vslEngNm", vslEngNm);
			eventResponse.setETCData("effDt", effDt);
			eventResponse.setETCData("expDt", expDt);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * 공통 <br>
	 * 해당년월의 마감여부를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSettlementClosing(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TotcommonEvent event = (TotcommonEvent)e;
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		String stlClzFlg = null;
		try{
			List<TotStlClzVO> list = command.checkSettlementClosing(event.getStlYr());
			//eventResponse.setRsVoList(list);
            
			if(list.size() > 0){
            	stlClzFlg = list.get(0).getStlClzFlg();
            }else{
            	stlClzFlg = "N";
            }
			
			eventResponse.setETCData("stlClzFlg", stlClzFlg);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * 공통 <br>
	 * lane에 해당하는 trade code를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 
	private EventResponse searchTrdCodeByLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		//TotcommonEvent event = (TotcommonEvent)e;
		
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
        
		TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
		
		try{
			begin();		
			//lane에 따른 trade code 조회
			List<TotCodeInfoVO> list = command.searchTrdCodeByLaneList(totCodeParamVO);
			
			String trdSheet = makeComboString(list, 2);//IBSheet 내 combo용
	
			eventResponse.setETCData("sheet1_trd_cd" , trdSheet);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}*/

	/**
	 * 공통 <br>
	 * 해당 lane 존재여부를 체크한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneCheckList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TotcommonEvent event = (TotcommonEvent)e;
		
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		
		String laneCd = null;

		try{
			List<MdmLaneVO> list = command.searchLaneCheckList(event.getMdmLaneVO());
			log.debug("::CALL::> FNS_TOT_0004 SC lane cd 조회끝> :::::::::");
			//eventResponse.setRsVoList(list);
			if(list.size()>0){
				laneCd = list.get(0).getVslSlanCd();

			}else{
				laneCd = "";

			}
			
			eventResponse.setETCData("laneCd", laneCd);
				
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * 공통 <br>
	 * 해당 시작일자 종료일자 lane, dir_cd 에 해당하는 port조회 <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TotcommonEvent event = (TotcommonEvent)e;
		
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		
		log.debug("::CALL::> SC slan_cd 조회2> :::::::::"+event.getVskVslPortSkdVO().getSlanCd());
		log.debug("::CALL::> SC getSkdDirCd 조회2> :::::::::"+event.getVskVslPortSkdVO().getSkdDirCd());
		log.debug("::CALL::> SC getVpsEtdDt 조회2> :::::::::"+event.getVskVslPortSkdVO().getVpsEtdDt());
			
		try{
			begin();		
			//lane에 따른 trade code 조회
			List<TotCodeInfoVO> list = command.searchPortCodeList(event.getVskVslPortSkdVO());
			
			String portCmbList = makeComboString(list, 2);//IBSheet 내 combo용
	
			eventResponse.setETCData("port_cd" , portCmbList);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	

	/**
	 * 공통함수 <br>
	 * List를 combo용 String으로 변환합니다. <br>
	 * 
	 * @param List<TotCodeInfoVO> list, int flg 
	 * @return String
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private String makeComboString(List<TotCodeInfoVO> list, int flg) throws EventException{
		String rtnVal = null;
		try{
			StringBuilder sb = new StringBuilder();
	
			Iterator iterator = (Iterator) list.iterator();
	
			while(iterator.hasNext()){
				TotCodeInfoVO totCodeInfoVO = (TotCodeInfoVO)iterator.next();
				
				//일반적인 IBCombo용(name, code|)
				if (flg==0){
					sb.append(totCodeInfoVO.getName()+","+totCodeInfoVO.getCode()+"|");
				//IBCombo (code, code|)
				}else if (flg==1){
					sb.append(totCodeInfoVO.getCode()+","+totCodeInfoVO.getCode()+"|");
				//IBSheet의 코드부분(code|)
				}else if (flg==2){
					sb.append(totCodeInfoVO.getCode()+"|");
				//IBSheet의 코드명부분(name|)
				}else if (flg==3){
					sb.append(totCodeInfoVO.getName()+"|");
				//SuperCd조회
				}else if (flg==4){
					sb.append(totCodeInfoVO.getSuperCd1()+","+totCodeInfoVO.getSuperCd2()+","+totCodeInfoVO.getCode()+"|");
				//Code, Name
				}else if (flg==5){
					sb.append(totCodeInfoVO.getCode()+"\t"+totCodeInfoVO.getName()+"|");
				}
			}
	
			rtnVal = sb.toString();
			
			if (rtnVal.length() > 0){
				rtnVal = rtnVal.substring(0,rtnVal.length()-1);
			}
		}catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return rtnVal;
	}


	/**
	 * 공통 <br>
	 * 해당 back end job의 상태를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchDetailByBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TotcommonEvent event = (TotcommonEvent)e;
    	try {    		
	    	
    		BackEndJobVO backEndJobVO = event.getBackEndJobVO();
	    	if(backEndJobVO != null) {
	    		String backEndJobKey = backEndJobVO.getBackEndJobKey();
	    		log.debug("SC :::::>>> backEndJobKey : "+backEndJobKey);
    			// Backend job이 완료되었는지 검사한다.
		    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(backEndJobKey);

		    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	log.debug(":::::>>> dbRowSetlist : "+dbRowSetlist);
		    	
		    	ComBakEndJbVO jobVo = new ComBakEndJbVO();
		    	if (dbRowSetlist.size() == 0) {
		    		// Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
		    	  jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
		        if(jobVo.getJbStsFlg().equals("3")){
		        	log.debug("SC :::::>>> getJbStsFlg : 3");
		        	eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());

		        }
	    	}	    
    	} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    	return eventResponse;
    }

	/**
	 * 공통 <br>
	 * 해당 back end job의 상태를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchCreationByBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TotcommonEvent event = (TotcommonEvent)e;
		
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		
    	try {    		
	    	
    		BackEndJobVO backEndJobVO = event.getBackEndJobVO();
	    	if(backEndJobVO != null) {
	    		String backEndJobKey = backEndJobVO.getBackEndJobKey();
	    		log.debug("SC :::::>>> backEndJobKey : "+backEndJobKey);
	    		
	    		String[] res = command.searchCreationByBackEndJobStatus(backEndJobKey);
	    	
		    	
		        if(res[0].equals("3")){
		        	log.debug("SC :::::>>> getJbStsFlg : 3");

					if(!res[1].equals("nodata")){
						eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
					}
		        }
		        eventResponse.setETCData("jb_sts_flg", res[0]);
				eventResponse.setETCData("jb_cdata", res[1]);
	    	}
    	} catch (EventException ex) {
    		throw ex;
    	} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    	return eventResponse;
    }
	
}