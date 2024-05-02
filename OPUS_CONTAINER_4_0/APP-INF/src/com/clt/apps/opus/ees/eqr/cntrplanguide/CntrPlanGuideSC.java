/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrRepoPlanManageSC.java
*@FileTitle : Container Plan
*Open Issues :
*Change history :
*-----------------------------------------------------------------------------
*	No.    Ver.	Modifier			Modifier Date		Explanation
*-----------------------------------------------------------------------------
*				SHIN DONG IL		2013.05.27			Creation
*				YONGCHAN SHIN		2014.01.06			Guideline Recipient Set-up 신규생성(CSR ID : CHM-201328003) 
*-----------------------------------------------------------------------------
*@LastModifyDate : 2013.05.27
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.05.27 SHIN DONG IL
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.basic.CntrPlanGuidelineEmailBC;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.basic.CntrPlanGuidelineEmailBCImpl;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.event.EesEqr1030Event;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.event.EesEqr1031Event;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1030ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1030MultiVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1031ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.basic.CntrPlanGuidelineManageBC;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.basic.CntrPlanGuidelineManageBCImpl;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.event.EesEqr1008Event;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.event.EesEqr1009Event;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration.CntrPlanGuidelineManageDBDAO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1008ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1009ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.basic.CntrPlanMTRepoPlanBC;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.basic.CntrPlanMTRepoPlanBCImpl;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.event.EesEqr1013Event;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo.EesEqr1013ConditionVO;
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
 * OPUS-Repo Plan Business Logic ServiceCommand - OPUS-RepoPlanManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SHIN DONG IL
 * @see CntrPlanGuidelineManageDBDAO
 * @since J2EE 1.6
 */
public class CntrPlanGuideSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Repo Plan system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("CntrPlanSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Repo Plan system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CntrPlanSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-RepoPlan system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// EQR MTY Repo Guideline Creation [ EES_EQR_1008 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr1008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchGuidelineConfig(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkSubLocCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkMaxEqGlineSeq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkPodCd(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiGuidelineList(e);// Save
			}
		}else if (e.getEventName().equalsIgnoreCase("EesEqr1009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchAddGuidelineConfig(e);		
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAddGuidelineList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCheckVvdCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVvdCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPolCdList(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchAddGlineVvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchAddGlineEtaDt(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchAmendPortion(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = checkGline(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {  // Guideline New 에서 lane 까지 선택시 가장최근 vvd, port, eta 검색
				eventResponse = searchNewGuidelineFirstVVD(e);	
			}
			
		}else if (e.getEventName().equalsIgnoreCase("EesEqr1030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGuidelineEmailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGuidelineEmailUserInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiGuidelineEmailList(e);// Save
			}
			
		}else if (e.getEventName().equalsIgnoreCase("EesEqr1031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGuidelineEmailContents(e);  // Guideline email 수신자, 최근 저장된 GUIDELINE LANE 조회
			} 		
			
		}else if (e.getEventName().equalsIgnoreCase("EesEqr1013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchLoadingTrendByLaneDefault(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVvdResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPlnRsnHdrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPlnRsnSubList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMtyRepoPlanList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchMtyRepoRefList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMtRepoPlanInfo(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * 기본 data 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoadingTrendByLaneDefault(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1013Event event = (EesEqr1013Event)e; 
		CntrPlanMTRepoPlanBC command = new CntrPlanMTRepoPlanBCImpl();
		
		EesEqr1013ConditionVO condVO = new EesEqr1013ConditionVO();
		
		condVO = event.getEesEqr1013ConditionVO();

		condVO.setOfcCd(account.getOfc_cd());

		try{
			String[] result = command.searchLoadingTrendByLaneDefault(condVO).getResultStrArray();
			if (result!=null && result.length==CntrPlanMTRepoPlanBC.MTY_REPO_PLN_DEF_VAL_LENGTH){
				condVO.setEtaFmDt(JSPUtil.getNull(result[0]));
				condVO.setEtaToDt(JSPUtil.getNull(result[1]));
				condVO.setFmWk(JSPUtil.getNull(result[2]));
				condVO.setToWk(JSPUtil.getNull(result[3]));
				condVO.setRccCd(JSPUtil.getNull(result[4]));
				condVO.setOfcTpCd(JSPUtil.getNull(result[5]));

				String[] tmp_str = null;
				if (result[6]!=null && !result[6].trim().equals("")){
			        StringTokenizer st = new StringTokenizer(result[6], "$$");
			        int count = st.countTokens();
			        tmp_str = new String[count];
			        for (int i = 0; i < count; i++) {
			        	tmp_str[i] = st.nextToken();
			        }
					if (tmp_str!=null && tmp_str.length>0){
						log.debug("\n SC.tmp_str.length : " + tmp_str.length + "\n");
						log.debug("\n SC.tmp_str[0] : " + (tmp_str.length>0?tmp_str[0]:"") + "\n");
						log.debug("\n SC.tmp_str[1] : " + (tmp_str.length>0?tmp_str[1]:"") + "\n");
						if (tmp_str[0]!=null){
							condVO.setPlnRsnHdrCode(tmp_str[0]);
						}
						if (tmp_str[1]!=null){
							condVO.setPlnRsnHdrText(tmp_str[1]);
						}
					}
				}

				if (result[7]!=null && !result[7].trim().equals("")){
			        StringTokenizer st = new StringTokenizer(result[7], "$$");
			        int count = st.countTokens();
			        tmp_str = new String[count];
			        for (int i = 0; i < count; i++) {
			        	tmp_str[i] = st.nextToken();
			        }
					if (tmp_str!=null && tmp_str.length>0){
//						log.debug("\n SC.tmp_str.length : " + tmp_str.length + "\n");
//						log.debug("\n SC.tmp_str[0] : " + (tmp_str.length>0?tmp_str[0]:"") + "\n");
//						log.debug("\n SC.tmp_str[1] : " + (tmp_str.length>0?tmp_str[1]:"") + "\n");
						if (tmp_str[0]!=null){
							condVO.setPlnRsnSubCode(tmp_str[0]);
						}
						if (tmp_str[1]!=null){
							condVO.setPlnRsnSubText(tmp_str[1]);
						}
					}
				}
				
				condVO.setLoginOfcConticCd(JSPUtil.getNull(result[8]));
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
	 * PlnRsnHdr 조회
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPlnRsnHdrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanMTRepoPlanBC command = new CntrPlanMTRepoPlanBCImpl();
		String rtn_val = null;
		String[] tmp_str = null;
		
		try {
			rtn_val = command.searchPlnRsnHdrList();
			if (rtn_val!=null && !rtn_val.trim().equals("")){
		        StringTokenizer st = new StringTokenizer(rtn_val, "$$");
		        int count = st.countTokens();
		        tmp_str = new String[count];
		        for (int i = 0; i < count; i++) {
		        	tmp_str[i] = st.nextToken();
		        }

				if (tmp_str!=null && tmp_str.length>0){
//					log.debug("\n SC.tmp_str.length : " + tmp_str.length + "\n");
//					log.debug("\n SC.tmp_str[0] : " + (tmp_str.length>0?tmp_str[0]:"") + "\n");
//					log.debug("\n SC.tmp_str[1] : " + (tmp_str.length>0?tmp_str[1]:"") + "\n");
					if (tmp_str[0]!=null){
						eventResponse.setETCData("pln_rsn_hdr_code", tmp_str[0]);
					}
					if (tmp_str[1]!=null){
						eventResponse.setETCData("pln_rsn_hdr_text", tmp_str[1]);
					}
				}
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * PlnRsnSub 조회
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPlnRsnSubList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanMTRepoPlanBC command = new CntrPlanMTRepoPlanBCImpl();
		EesEqr1013Event event = (EesEqr1013Event)e; 
		EesEqr1013ConditionVO condVO = event.getEesEqr1013ConditionVO();
		String rtn_val = null;
		String[] tmp_str = null;
		
		try {
			rtn_val = command.searchPlnRsnSubList(condVO);
			if (rtn_val!=null && !rtn_val.trim().equals("")){
		        StringTokenizer st = new StringTokenizer(rtn_val, "$$");
		        int count = st.countTokens();
		        tmp_str = new String[count];
		        for (int i = 0; i < count; i++) {
		        	tmp_str[i] = st.nextToken();
		        }
		        
				if (tmp_str!=null && tmp_str.length>0){
					log.debug("\n SC.tmp_str.length : " + tmp_str.length + "\n");
					log.debug("\n SC.tmp_str[0] : " + (tmp_str.length>0?tmp_str[0]:"") + "\n");
					log.debug("\n SC.tmp_str[1] : " + (tmp_str.length>0?tmp_str[1]:"") + "\n");
					if (tmp_str[0]!=null){
						eventResponse.setETCData("pln_rsn_sub_code", tmp_str[0]);
					}
					if (tmp_str[1]!=null){
						eventResponse.setETCData("pln_rsn_sub_text", tmp_str[1]);
					}
				}
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * VVD data 조회
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVvdResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanMTRepoPlanBC command = new CntrPlanMTRepoPlanBCImpl();
		EesEqr1013Event event = (EesEqr1013Event)e; 
		EesEqr1013ConditionVO condVO = event.getEesEqr1013ConditionVO();
		String rtn_val = null;
		String[] tmp_vvd_rslt = null;
		
		try {
			rtn_val = command.searchVvdResult(condVO);
			if (rtn_val!=null && !rtn_val.trim().equals("")){
				tmp_vvd_rslt = rtn_val.split("##");
				if (tmp_vvd_rslt!=null && tmp_vvd_rslt.length>0){
					if (tmp_vvd_rslt[0]!=null){
						eventResponse.setETCData("vvd_cd", tmp_vvd_rslt[0]);
					}
					if (tmp_vvd_rslt[1]!=null){
						eventResponse.setETCData("vvd_rslt", tmp_vvd_rslt[1]);
					}
				}
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Mt Repo Plan data 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMtyRepoPlanList(Event e) throws EventException {
		EesEqr1013Event event = (EesEqr1013Event)e; 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanMTRepoPlanBC command = new CntrPlanMTRepoPlanBCImpl();
		EesEqr1013ConditionVO condVO = null;

		List<AbstractValueObject> rsVoList = null;
		CommonRsVO commonRsVO = null;
		CommonRsVO resultVO = null;

		
		try {
			condVO = event.getEesEqr1013ConditionVO();
			condVO.setOfcCd(account.getOfc_cd());  // SESSION OFC CODE 추가
			
			rsVoList = new ArrayList<AbstractValueObject>();
			resultVO = new CommonRsVO();
			resultVO.setConditionVO(condVO);
			
			commonRsVO =  command.searchMtyRepoPlanList(condVO);
			
			resultVO.setDbRowset(commonRsVO.getDbRowset());
			rsVoList.add(resultVO);
			eventResponse.setRsVoList(rsVoList);


		} catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Mt Repo Reference data 조회
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMtyRepoRefList(Event e) throws EventException {
		EesEqr1013Event event = (EesEqr1013Event)e; 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanMTRepoPlanBC command = new CntrPlanMTRepoPlanBCImpl();
		EesEqr1013ConditionVO condVO = null;

		List<DBRowSet> arrList = new ArrayList<DBRowSet>();
		CommonRsVO commonRsVO = null;
		
		try {
			condVO = event.getEesEqr1013ConditionVO();
			commonRsVO = command.searchMtyRepoRefList(condVO);
			arrList.add(commonRsVO.getDbRowset());
			eventResponse.setRsVoList(arrList);
		} catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Mt Repo Plan data 저장
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageMtRepoPlanInfo(Event e) throws EventException {
		
		log.debug("\n\n CntrPlanGuideSC.manageMtRepoPlanInfo ------ bbbbb \n\n");
		
		EventResponse eventResponse = new GeneralEventResponse();
		CntrPlanMTRepoPlanBC command = new CntrPlanMTRepoPlanBCImpl();
		EesEqr1013Event event = (EesEqr1013Event)e; 

		try {
			begin();
			command.manageMtRepoPlanInfo(event);
			commit();

			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		log.debug("\n\n CntrPlanGuideSC.manageMtRepoPlanInfo ------ eeeee \n\n");
		return eventResponse;
	}
	
	/**
	 * [ EES_EQR_1008 : EQR Repo Guideline Creation List ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineConfig(Event e) throws EventException {
		EesEqr1008Event event = (EesEqr1008Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		EesEqr1008ConditionVO condVO = event.getEesEqr1008ConditionVO();
		condVO.setOfcCd(event.getSignOnUserAccount().getOfc_cd());

		try{
			String[] result = command.searchGuidelineConfig(condVO).getResultStrArray();
			condVO.setLclDt(result[0]);
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
	 * [ EES_EQR_1009 : EQR Repo Guideline Add/Amend ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAddGuidelineConfig(Event e) throws EventException {
		EesEqr1009Event event = (EesEqr1009Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		EesEqr1009ConditionVO conditionVO = event.getEesEqr1009ConditionVO();

		try{
			String[] result 	= command.searchAddGuidelineConfig(conditionVO).getResultStrArray();

			conditionVO.setSVvdCd(result[0]);
			conditionVO.setSPolCd(result[1]);
			conditionVO.setSEffStDt(result[2]);
			conditionVO.setSEtaDt(result[3]);

			
			String[] pol_result = command.searchPolCdList(conditionVO).getResultStrArray();

			conditionVO.setComboPolCd(pol_result[0]);
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
	 * [ EES_EQR_1009 : Guideline Add 에서 lane 의 최초 vvd 검색 ]<br>
	 * vvd 정보와 port, eta 정보까지 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNewGuidelineFirstVVD(Event e) throws EventException {
		EesEqr1009Event event = (EesEqr1009Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		EesEqr1009ConditionVO conditionVO = event.getEesEqr1009ConditionVO();

		try{
			String[] result = command.searchAddGuidelineConfig(conditionVO).getResultStrArray();
			
			eventResponse.setETCData("vvd_cd",    result[0]);
			eventResponse.setETCData("pol_cd",    result[1]);
			eventResponse.setETCData("eff_st_dt", result[2]);
			eventResponse.setETCData("etd_dt",    result[3]);			
			
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
	 * [ EES_EQR_1009 : EQR Repo Guideline Add/Amend ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPolCdList(Event e) throws EventException {
		EesEqr1009Event event = (EesEqr1009Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		EesEqr1009ConditionVO conditionVO = event.getEesEqr1009ConditionVO();

		try{
			String[] pol_result = command.searchPolCdList(conditionVO).getResultStrArray();
			eventResponse.setETCData("pol_cd", 		pol_result[0]);
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
	 * [ EES_EQR_1008 : EQR Repo Guideline Creation List ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1008Event event = (EesEqr1008Event)e; 
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		
		EesEqr1008ConditionVO condVO = new EesEqr1008ConditionVO();
		condVO = event.getEesEqr1008ConditionVO();
		
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO commonRsVO = command.searchGuidelineList(condVO);

			CommonRsVO resultVO = new CommonRsVO();
			
			resultVO.setConditionVO(condVO);
			resultVO.setDbRowset( commonRsVO.getDbRowset() );
			
			rsVoList.add(resultVO);
			
			eventResponse.setRsVoList(rsVoList);
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
	 * [ EES_EQR_1008 : EQR Repo Guideline Creation List ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiGuidelineList(Event e) throws EventException {
		EesEqr1008Event event = (EesEqr1008Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();

		try{
			begin();
			command.multiGuidelineList(event.getEqrCtrlGlineHdrVOs(),event.getEqrCtrlLodgGlineVOs(),event.getEqrCtrlDchgGlineVOs(),event.getEqrCtrlDchgGlineValVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
			commit();
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
	 * [ EES_EQR_1009 : Guideline Creation Add ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAddGuidelineList(Event e) throws EventException {
		EesEqr1009Event event = (EesEqr1009Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		EesEqr1009ConditionVO condVO = event.getEesEqr1009ConditionVO();

		try{
			CommonRsVO commonRsVO =  command.searchAddGuidelineList(condVO);
			eventResponse.setRs(commonRsVO.getDbRowset());
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
	 * [ EES_EQR_1009 : Guideline Add/Amend  ]<br>
	 * Desc : Amend시 현 차수의  ETA와 전차수 ETA사이의 performance 구하기
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmendPortion(Event e) throws EventException {
		EesEqr1009Event event = (EesEqr1009Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		EesEqr1009ConditionVO condVO = event.getEesEqr1009ConditionVO();

		try{
			
			CommonRsVO commonRsVO = command.searchAmendPortion(condVO);
			eventResponse.setRs(commonRsVO.getDbRowset());
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
	 * [ EES_EQR_1008 : VVD CHECK ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckVvdCd(Event e) throws EventException {
		EesEqr1009Event event = (EesEqr1009Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		EesEqr1009ConditionVO conditionVO = event.getEesEqr1009ConditionVO();

		try{
			String rtn_val = command.searchCheckVvdCd(conditionVO);
			eventResponse.setETCData("vvd_check", rtn_val);
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
	 * [ EES_EQR_1008 : VVD CHECK ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdCd(Event e) throws EventException {
		EesEqr1009Event event = (EesEqr1009Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		EesEqr1009ConditionVO conditionVO = event.getEesEqr1009ConditionVO();

		try{
			String[] rtn_val = command.searchVvdCd(conditionVO).getResultStrArray();
			eventResponse.setETCData("vvd_cd", 		rtn_val[0]);
			eventResponse.setETCData("pol_cd", 		rtn_val[1]);
			eventResponse.setETCData("eff_st_dt", 	rtn_val[2]);
			eventResponse.setETCData("eta_dt", 		rtn_val[3]);
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
	 * [ EES_EQR_1008 : Guideline Add시 VVD 조회 ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAddGlineVvd(Event e) throws EventException {
		EesEqr1009Event event = (EesEqr1009Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		EesEqr1009ConditionVO conditionVO = event.getEesEqr1009ConditionVO();

		try{
			String[] rtn_val = command.searchAddGlineVvd(conditionVO).getResultStrArray();
			eventResponse.setETCData("vvd_cd", 		rtn_val[0]);
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
	 * [ EES_EQR_1008 : Guideline Add시 POL CD변경시 ETA DT 조회 ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAddGlineEtaDt(Event e) throws EventException {
		EesEqr1009Event event = (EesEqr1009Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		EesEqr1009ConditionVO conditionVO = event.getEesEqr1009ConditionVO();

		try{
			String[] rtn_val = command.searchAddGlineEtaDt(conditionVO).getResultStrArray();
			eventResponse.setETCData("eta_dt", 		rtn_val[0]);
			eventResponse.setETCData("eff_st_dt", 	rtn_val[1]);
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
	 * EES_EQR_1008<br>
	 * 입력 받은 rcc/lcc/ecc가 해당 rcc에 속하는지 체크
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSubLocCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1008Event event = (EesEqr1008Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		EesEqr1008ConditionVO condVO = event.getEesEqr1008ConditionVO();
		String check = "";
		
		check = command.checkSubLocCd(condVO);
		
		eventResponse.setETCData("check", check);
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1008<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkMaxEqGlineSeq(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1008Event event = (EesEqr1008Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		EesEqr1008ConditionVO condVO = event.getEesEqr1008ConditionVO();
		String max_gline_seq = "";
		
		max_gline_seq = command.checkMaxEqGlineSeq(condVO);
		
		eventResponse.setETCData("max_gline_seq", max_gline_seq);
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1008<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPodCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1008Event event = (EesEqr1008Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		EesEqr1008ConditionVO condVO = event.getEesEqr1008ConditionVO();
		String chk_pod_cd = "";
		
		chk_pod_cd = command.checkPodCd(condVO);
		
		eventResponse.setETCData("chk_pod_cd", chk_pod_cd);
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1009<br>
	 * Guideline Add시 Guideline 존재 유무체크
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkGline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1009Event event = (EesEqr1009Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineManageBC command = new CntrPlanGuidelineManageBCImpl();
		EesEqr1009ConditionVO conditionVO = event.getEesEqr1009ConditionVO();
		String chk_gline = "";
		
		chk_gline = command.checkGline(conditionVO);
		
		eventResponse.setETCData("chk_gline", chk_gline);
		return eventResponse;		
	}
	
	
	/**
	 * [ EES_EQR_1030 : Guideline Email Set-up ]<br>
	 * guideline email 수신자 정보 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineEmailList(Event e) throws EventException {
		EesEqr1030Event event = (EesEqr1030Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineEmailBC command = new CntrPlanGuidelineEmailBCImpl();
		EesEqr1030ConditionVO condVO = event.getEesEqr1030ConditionVO();

		try{
			CommonRsVO commonRsVO =  command.searchGuidelineEmailList(condVO);
			eventResponse.setRs(commonRsVO.getDbRowset());
			
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
	 * [ EES_EQR_1030 : Guideline Email Set-up ]<br>
	 * 입력될 이메일 수신자 ID 의 검증 및 name/office/email 정보 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineEmailUserInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1030Event event = (EesEqr1030Event)e;
		CntrPlanGuidelineEmailBC command = new CntrPlanGuidelineEmailBCImpl();
		
		try{
			String usr_id           = (String)event.getAttribute("usr_id");

			EesEqr1030MultiVO eesEqr1030MultiVO = command.searchGuidelineEmailUserInfo(usr_id);

			if(eesEqr1030MultiVO != null){
				eventResponse.setETCData(eesEqr1030MultiVO.getColumnValues());
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
	 * [ EES_EQR_1030 : Guideline Email Set-up ]<br>
	 * 이메일 수신자 정보를 입력/수정/삭제 처리
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiGuidelineEmailList(Event e) throws EventException {
		EesEqr1030Event event = (EesEqr1030Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrPlanGuidelineEmailBC command = new CntrPlanGuidelineEmailBCImpl();

		try{
			begin();
			
			command.multiGuidelineEmailList(event.getEesEqr1030MultiVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
			
			commit();
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
	 * [ EES_EQR_1031 : Guideline Emailing ]<br>
	 * Guideline email 수신자, 최근 저장된 GUIDELINE LANE 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineEmailContents(Event e) throws EventException { // 현재 개발중
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1031Event event = (EesEqr1031Event)e; // PDTO(Data Transfer Object including Parameters)		
		
		CntrPlanGuidelineEmailBC command = new CntrPlanGuidelineEmailBCImpl();
		EesEqr1031ConditionVO condVO     = event.getEesEqr1031ConditionVO();
		
		String recipient = command.searchGuidelineEmailContentsRecipient(condVO);   // Guideline email 수신자조회
		String vslLaneCd = command.searchGuidelineEmailContentsVslLaneCd(condVO);	// 최근 저장된 GUIDELINE LANE 조회	
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("recipient",   recipient);
		eventResponse.setETCData("vsl_lane_cd", vslLaneCd);
		
		return eventResponse;		
	}		
	
}