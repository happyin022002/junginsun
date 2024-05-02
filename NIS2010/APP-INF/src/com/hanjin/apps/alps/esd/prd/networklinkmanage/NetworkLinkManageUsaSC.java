/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkLinkManageUsaSC.java
 *@FileTitle : NetworkLinkManageUsa 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-08-306
 *@LastModifier : kim kwijin
 *@LastVersion : 1.0
 * 2006-08-30 jungsunyong
 * 1.0 최초 생성
 * 2009-08-03 kim kwijin
 * 1.1 수정
 * 2011.06.16 변종건 [CHM-201111584-01] [PRD] Inland Route Management상의 입력국가 추가 요청.
 * 2012.09.24 정선용  CHM-201220334-01: [PRD] Optimum flag 범위확대 요청
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage;

import java.util.List;

import com.hanjin.apps.alps.esd.prd.common.prdcommon.basic.PrdCommonManageBC;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.basic.PrdCommonManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageBC;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageUsaBC;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageUsaBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0057Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0058Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.lnlandRouteUSVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic ServiceCommand<br>
 * - alps-PRD에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author jungsunyong
 * @see ESD_PRD_004EventResponse,HubLocationMatchingManageDBDAO 참조
 * @since J2EE 1.4
 */
public class NetworkLinkManageUsaSC extends ServiceCommandSupport{
	// Login User Information

	private SignOnUserAccount account = null;

	/**
	 * PRD 업무 시나리오 선행작업<br>
	 * HubLocationMatchingManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	@Override
	public void doStart(){
		try{
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
			if(account.getUsr_id() == null){
				throw new RuntimeException();
			}
		}catch(Exception e){
			log.error("NetworkLinkManageUsaSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * HubLocationMatchingManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	@Override
	public void doEnd(){
		// command.doEnd();
		log.debug("NetworkLinkManageUsaSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * alps-PRD 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException{
		EventResponse eventResponse = null;

		log.debug("\n[CALL] Service Command ----------------------------- "
				+ "\n EventName   : " + e.getEventName()
				+ "\n Program No.  : " + ((String) e.getAttribute("pgmNo"))
				+ "\n Command     : " + e.getFormCommand().getCommand());
		String retCrud = "";
		String usr_id = "";
		if(account!=null){
			usr_id = account.getUsr_id();
		}
		
		PrdCommonManageBC prdComm = new PrdCommonManageBCImpl();
		retCrud = prdComm.getPrdPgmRole(((String) e.getAttribute("pgmNo")),usr_id);
		log.debug("\n\n retCrud:[" + retCrud + "] null con->[" + (retCrud.equals("") ? "R" : retCrud) + "]");
		e.setAttribute("crud", retCrud.equals("") ? "R" : retCrud);

		/***********************************************************************
		 * Coded by  Jung Sunyong
		 ************************************************************************/
		/*
		 *	Inland Route Manage
		 */
		if(e.getEventName().equalsIgnoreCase("EsdPrd0057Event")){

			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){ //mst 조회
				eventResponse = searchInlandRouteMasterUSA(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){ //detail 조회
				eventResponse = searchInlandRouteDetailUSA(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){ //Country 조회
				eventResponse = searchCntOfContiUSA(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){ // DETAIL SAVE.
				eventResponse = saveInlandRouteDetailUSA(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){ // mst 저장
				eventResponse = saveInlandRouteMasterUSA(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){ //DETAIL SAVE AS
				eventResponse = saveAsInlandRouteDetailUSA(e);
			}

		}
		/*
		 *	Priority POPUP
		 */
		if(e.getEventName().equalsIgnoreCase("EsdPRD0058Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){ //mst 조회
				eventResponse = searchInlandRouteMasterPopUSA(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = saveInlandRoutePriorityUSA(e);
			}
		}

		return eventResponse;
	}

	/**
	 * NetworkLinkManageUsaSC's saveAsInlandRouteDetailUSA
	 * @param e
	 * @return
	 * @throws EventException EventResponse
	 */
	private EventResponse saveAsInlandRouteDetailUSA(Event e) throws EventException{


		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0057Event event = (EsdPrd0057Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
		String errMsg = "";
		try{


			int retCnt = command.getInLandRouteExistCount(event.getInlandRouteMsUSVO(), event.getInlandRouteUSDetVOs());
			if(retCnt > 0){
				//리마크 부분이 변경 됐으면 리마크 업데이트

				int remRet = command.getInLandRouteRemarkCompare(event.getInlandRouteMsUSVO());
				if(remRet > 0){
					begin();
					command.updateRemark(event.getInlandRouteMsUSVO());
					commit();
				}else{

					errMsg = "Exist Inland route.";
					eventResponse.setETCData("strErrMsg", errMsg);
					return eventResponse;
				}
			}else{
				event.getInlandRouteMsUSVO().setNodTpCd2(event.getInlandRouteMsUSVO().getNodTpCd1());
				begin();
				String newRoutSeq = command.saveAsInlandRouteManage(event.getInlandRouteUSDetVOs(), event.getInlandRouteMsUSVO(), account);
				event.getInlandRouteMsUSVO().setIRoutSeq(newRoutSeq);
				eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());

				commit();

			}
			eventResponse.setRsVoList(command.rowSearchMaster(event.getInlandRouteMsUSVO()));

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * NetworkLinkManageUsaSC's saveInlandRoutePriorityUSA
	 * 
	 * 2009-08-06 kim kwijin 수정
	 * @param e
	 * @return
	 * @throws EventException  
	 */
	private EventResponse saveInlandRoutePriorityUSA(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsdPrd0058Event event = (EsdPrd0058Event) e;
		InlandRouteManageUsaBC command = new InlandRouteManageUsaBCImpl();
		try{
			begin();
			command.saveInlandRoutePriorityUSA(event.getInlandRouteUSVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
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
	 * NetworkLinkManageUsaSC's saveInlandRouteMasterUSA
	 * @param e
	 * @return
	 * @throws EventException EventResponse
	 */
	private EventResponse saveInlandRouteMasterUSA(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0057Event event = (EsdPrd0057Event) e;
		InlandRouteManageUsaBC command = new InlandRouteManageUsaBCImpl();
		try{
			begin();

			command.saveInlandRouteMasterUSA(event.getInlandRouteUSVOs(), event.getInlandRouteUSVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
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
	 * NetworkLinkManageUsaSC's saveInlandRouteDetailUSA
	 * @param e
	 * @return
	 * @throws EventException 
	 */
	private EventResponse saveInlandRouteDetailUSA(Event e) throws EventException{

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0057Event event = (EsdPrd0057Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
		String errMsg = "";
		try{


			int retCnt = command.getInLandRouteExistCount(event.getInlandRouteMsUSVO(), event.getInlandRouteUSDetVOs());
			event.getInlandRouteMsUSVO().setNodTpCd2(event.getInlandRouteMsUSVO().getNodTpCd1());
			//eventResponse.setRsVoList(list);
			if(retCnt > 0){
				int remRet = command.getInLandRouteRemarkCompare(event.getInlandRouteMsUSVO());
				if(remRet > 0){
					begin();
					command.updateRemark(event.getInlandRouteMsUSVO());
					commit();
				}else{
					errMsg = "Exist Inland route.";
					eventResponse.setETCData("strErrMsg", errMsg);
					return eventResponse;
				}

			}else{
				begin();
//				String newRoutSeq = command.multi01InlandRouteManage(event.getInlandRouteUSDetVOs(), event.getInlandRouteMsUSVO(), account);
				command.multi01InlandRouteManage(event.getInlandRouteUSDetVOs(), event.getInlandRouteMsUSVO(), account);

				eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
				commit();
			}

			eventResponse.setRsVoList(command.rowSearchMaster(event.getInlandRouteMsUSVO()));

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * NetworkLinkManageUsaSC's searchInlandRouteDetailUSA
	 * @param e
	 * @return
	 * @throws EventException  
	 * 2009-08-04 kim kwijin 수정
	 */
	private EventResponse searchInlandRouteDetailUSA(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0057Event event = (EsdPrd0057Event) e;
		InlandRouteManageUsaBC command = new InlandRouteManageUsaBCImpl();

		try{
			SearchConditionVO searchConditionVO = event.getSearchConditionVO();
			List<InlandRouteUSDetVO> list = command.searchInlandRouteDetailUSA(searchConditionVO);

			for(int i = 0; i < list.size(); i++){
				list.get(i).setVndrName(list.get(i).getVndrAbbrNm());
				list.get(i).setTztmHrs(list.get(i).getFmtTztmHrs());
				list.get(i).setRefeNo(list.get(i).getAgmtRefNo());
				list.get(i).setCombinedMd(list.get(i).getInlndRoutCmbFlg().equals("Y") ? list.get(i).getInlndRoutCmbFlg() : "");
				list.get(i).setClonTrspModCd(list.get(i).getTrspModCd());
				list.get(i).setSelRow(searchConditionVO.getISelrow());

				list.get(i).setClonVndrSeq(list.get(i).getVndrSeq());
				list.get(i).setClonAgmtNo(list.get(i).getAgmtNo());
				list.get(i).setClonCombinedMd(list.get(i).getInlndRoutCmbFlg().equals("Y") ? list.get(i).getInlndRoutCmbFlg() : "");
				list.get(i).setClonRailCrrTpCd(list.get(i).getRailCrrTpCd());
				list.get(i).setClonInlndRoutJuncNm(list.get(i).getInlndRoutJuncNm());

				if(i == 0){
					eventResponse.setETCData("i_inv", list.get(i).getInlndRoutInvBilPattCd());
					eventResponse.setETCData("i_rout_pln_cd", list.get(i).getRoutPlnCd());
					eventResponse.setETCData("i_route_rmk", list.get(i).getInlndRoutRmk());
					eventResponse.setETCData("i_wrs_fl_cd", list.get(i).getWrsFullCmdtCd());
					eventResponse.setETCData("wrs_f_chk", list.get(i).getWrsFullCmdt());
					eventResponse.setETCData("i_wrs_mt_cd", list.get(i).getWrsMtyCmdtCd());
					eventResponse.setETCData("disable_bkg_flg", list.get(i).getCc());
					eventResponse.setETCData("i_bkg_flg", list.get(i).getInlndRoutBkgFlg().equals("Y") ? list.get(i).getInlndRoutBkgFlg() : "");
					eventResponse.setETCData("i_mcntr_rout_flg", list.get(i).getMcntrRoutFlg().equals("Y") ? list.get(i).getMcntrRoutFlg() : "");
					eventResponse.setETCData("i_optm_flg", JSPUtil.getNull(
							list.get(i).getInlndRoutOptmFlg()).equals("Y") ? JSPUtil
							.getNull(list.get(i).getInlndRoutOptmFlg()) : "");


				}

			}

			if(searchConditionVO.getIHubSearchGb().equals("Y")){
				if(searchConditionVO.getIFrontGb().equals("F")){
					InlandRouteUSDetVO itmFirst = new InlandRouteUSDetVO();
					itmFirst.setIbflag("I");
					itmFirst.setLnkOrgLoc(JSPUtil.getNull(searchConditionVO.getIUndefineNod().substring(0, 5)));
					itmFirst.setLnkOrgType(JSPUtil.getNull(searchConditionVO.getIUndefineNod().substring(5)));

					itmFirst.setLnkDestLoc(JSPUtil.getNull(searchConditionVO.getIRoutOrgNodCd().substring(0, 5)));
					itmFirst.setLnkDestType(JSPUtil.getNull(searchConditionVO.getIRoutOrgNodCd().substring(5)));

					itmFirst.setRoutDtlSeq(JSPUtil.getNull(searchConditionVO.getISelrow()));

					list.add(0, itmFirst);
				}
			}

			if(searchConditionVO.getIHubSearchGb().equals("Y")){
				if(searchConditionVO.getIFrontGb().equals("B")){
					InlandRouteUSDetVO itmLast = new InlandRouteUSDetVO();
					itmLast.setIbflag("I");
					itmLast.setLnkOrgLoc(JSPUtil.getNull(searchConditionVO.getIUndefineNod().substring(0, 5)));
					itmLast.setLnkOrgType(JSPUtil.getNull(searchConditionVO.getIUndefineNod().substring(5)));

					itmLast.setLnkDestLoc(JSPUtil.getNull(searchConditionVO.getIRoutOrgNodCd().substring(0, 5)));
					itmLast.setLnkDestType(JSPUtil.getNull(searchConditionVO.getIRoutOrgNodCd().substring(5)));

					itmLast.setRoutDtlSeq(JSPUtil.getNull(searchConditionVO.getISelrow()));

					list.add(list.size(), itmLast);
				}
			}

			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;


	}

	/**
	 * NetworkLinkManageUsaSC's searchInlandRouteMasterUSA
	 * @param e
	 * @return
	 * @throws EventException 
	 * 
	 * 2009/08/03 kim kwi-jin수정
	 * 
	 */
	private EventResponse searchInlandRouteMasterUSA(Event e) throws EventException{

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0057Event event = (EsdPrd0057Event) e;
		InlandRouteManageUsaBC command = new InlandRouteManageUsaBCImpl();

		try{
			List<lnlandRouteUSVO> list = command.searchInlandRouteMasterUSA(event.getInlandRouteUSVO());
			eventResponse.setRsVoList(list);

			//ETC-DATA세팅
			String comboArg = "";
			int maxPrioSeq = 0;

			if(list.size() > 0){

				lnlandRouteUSVO itm = (lnlandRouteUSVO) list.get(0);
				maxPrioSeq = Integer.parseInt(itm.getMaxPrioSeq());

			}

			if(maxPrioSeq < list.size()){

				for(int i = 0; i <= list.size(); i++){
					comboArg = comboArg + i + "|";
				}
			}else{
				for(int i = 0; i <= maxPrioSeq; i++){
					comboArg = comboArg + i + "|";
				}
			}

			eventResponse.setETCData("prio_seq_combo", comboArg);
			eventResponse.setETCData("maxPrioSeq", maxPrioSeq + "");

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * NetworkLinkManageUsaSC's searchInlandRouteMasterPopUSA
	 * @param e
	 * @return
	 * @throws EventException 
	 * 
	 * 2009/08/06 kim kwi-jin생성
	 * 
	 */
	private EventResponse searchInlandRouteMasterPopUSA(Event e) throws EventException{

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0058Event event = (EsdPrd0058Event) e;
		InlandRouteManageUsaBC command = new InlandRouteManageUsaBCImpl();

		try{
			List<lnlandRouteUSVO> list = command.searchInlandRouteMasterUSA(event.getInlandRouteUSVO());
			eventResponse.setRsVoList(list);

			//ETC-DATA세팅
			String comboArg = "";
			int maxPrioSeq = 0;

			if(list.size() > 0){
				lnlandRouteUSVO itm = (lnlandRouteUSVO) list.get(0);
				maxPrioSeq = Integer.parseInt(itm.getMaxPrioSeq());
			}

			if(maxPrioSeq < list.size()){
				for(int i = 0; i <= list.size(); i++){
					comboArg = comboArg + i + "|";
				}
			}else{
				for(int i = 0; i <= maxPrioSeq; i++){
					comboArg = comboArg + i + "|";
				}
			}

			eventResponse.setETCData("prio_seq_combo", comboArg);
			eventResponse.setETCData("maxPrioSeq", maxPrioSeq + "");

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * NetworkLinkManageUsaSC's searchCntOfContiUSA
	 * @param e
	 * @return
	 * @throws EventException  
	 */
	public EventResponse searchCntOfContiUSA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PrdCommonManageBC command = new PrdCommonManageBCImpl();
		
		String[] cntCdArray = null;
		String cntCd = "";
		
		try{
			cntCdArray = command.searchCntOfConti("M");
			
			if(cntCdArray != null){
				for( int idx=0;idx<cntCdArray.length;idx++){
					cntCd = cntCd + cntCdArray[idx].toString() + "|";
				}
			}
			
			eventResponse.setETCData("cnt_cd", cntCd);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
}
