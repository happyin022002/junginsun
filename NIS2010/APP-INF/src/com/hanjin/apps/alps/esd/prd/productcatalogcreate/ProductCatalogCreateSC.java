/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateSC.java
*@FileTitle : ProductCatalogCreate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.22
*@LastModifier : 정선용
*@LastVersion : 1.0 
* 2009.08.22 정선용
* 1.0 Creation
* history
* 2010.09.27 채창호 [CHM-201006116] : Mixed Term Logic 변경 요청
* 2011.02.15 채창호 [CHM-201108878] : Group VVD assign시 POD의 location 정보를 PRD로 전달시 yard 제외요청
* 2012.08.17 정선용 [CHM-201219664] [PRD] Canada 향 D7 CNTR BKG block 을 위한 Hard-coding 설정요청	
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.common.PrdConstants;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.basic.PrdCommonManageBC;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.basic.PrdCommonManageBCImpl;
import com.hanjin.apps.alps.esd.prd.common.prdcreate.basic.PrdCreateManageBC;
import com.hanjin.apps.alps.esd.prd.common.prdcreate.basic.PrdCreateManageBCImpl;
import com.hanjin.apps.alps.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.hanjin.apps.alps.esd.prd.common.productcatalogcreateverify.basic.ProductCatalogCreateVerifyBCImpl;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0082Event;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration.ProductCatalogCreateDBDAO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.ProductCatalogInternalMst_1VO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;



/**
 * ALPS-ProductCatalogCreate Business Logic ServiceCommand - ALPS-ProductCatalogCreate 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author sun yong Jung
 * @see ProductCatalogCreateDBDAO
 * @since J2EE 1.6
 */

public class ProductCatalogCreateSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ProductCatalogCreate system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ProductCatalogCreateSC 시작"); 
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}
	

	/**
	 * ProductCatalogCreate system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ProductCatalogCreateSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ProductCatalogCreate system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e)  throws EventException{
		// RDTO(Data Transfer Object including Parameters)
		e.setAttribute("account", account);
		EventResponse eventResponse = null;
		log.debug("\n[CALL] Service Command ----------------------------- " +
		          "\n EventName   : " + e.getEventName()
		          + "\n Program No.  : " + ((String) e.getAttribute("pgmNo"))
		          + "\n Command     : " + e.getFormCommand().getCommand());
		long timeTotal = 0;
		long timeSub = 0;
		DateFormat dateFormat = new SimpleDateFormat( "mm:ss.S");
		timeTotal = System.currentTimeMillis();
		String retCrud = "";
		String usr_id = "";
		if(account!=null){
			usr_id = account.getUsr_id();
		}	
		PrdCommonManageBC prdComm = new PrdCommonManageBCImpl();
		retCrud = prdComm.getPrdPgmRole(((String) e.getAttribute("pgmNo")),usr_id);
		log.debug("\n\n retCrud:["+retCrud+"] null con->["+(retCrud.equals("")? "R":retCrud) +"]");
		e.setAttribute("crud",retCrud.equals("")? "R":retCrud);	
				
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdPrd0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				// 일단 화면 로드 하고 loadPage() 함수에서 다시 한번 SEARCHLIST01 을 호출한다.
				eventResponse = new GeneralEventResponse();
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
			// Mixed Term 을 처리.
				this.checkMixedTerm(e );
			//화면을 나타내기 위해 try 로 잡음.
				eventResponse = this.createPrdCtlgFullRout(e );
			//선택화면에서 ocn route 선택 변경
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchRouteInfoByPctlNo(e );
			//선택화면에서 Empty Pick Up Date 변경
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchEqInventory(e );
			// replane 선택화면에서 select 버튼 클릭시.
			// map table 을 pc no로 업데이트, 부패턴 pc생성.(cost 필요없음)
			} else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
				eventResponse = this.processReplaneFinish(e );
			}
		//pc dtl 조회
		}else if (e.getEventName().equalsIgnoreCase("EsdPrd0081Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchPrdCtlgFullRout (e );
			} 
		//pc constraint 조회
		}else if (e.getEventName().equalsIgnoreCase("EsdPrd0082Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchPrdConstraint (e );
			} 
		// route validation check 부분
		}else if (e.getEventName().equalsIgnoreCase("EsdPrd0083Event")) {
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = this.addValCheck (e );
			} 
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분  
		}else if (e.getEventName().equalsIgnoreCase("EsdPrd0020Event")) {  //ESD_PRD_0020HTMLAction 에서 80Event 를 사용하지만 셋팅을 event.setEventName("EsdPrd0020Event"); 로 해서 분기된다. 
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		// pc생성 및 생성된 MST 조회
				eventResponse = this.createProductCatalogInquiry(e);
				//eventResponse = createProductCatalogforInternalUser2(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {  // Pre Simulation 조회
//				eventResponse = this.createProductCatalogforPreCm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  // DETAIL 조회
				eventResponse = this.searchProductCatalogInquiryDetail(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {  // Pre Simulation DETAIL 조회
//				eventResponse = this.searchProductCatalogforPreCmDetail(e);

			//Constraint Remark 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = this.searchCnstRemark(e );
			}
		}
		timeSub = System.currentTimeMillis();
		log.info("\n------------------------------------------------------------------------------" +
				 "\n  PRD Time: "+dateFormat.format(new Date(System.currentTimeMillis()-timeTotal)) +
				 "\n------------------------------------------------------------------------------");

		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 * 선택화면에서 Empty Pick Up Date 변경
	 */
	private EventResponse searchEqInventory(Event e) throws EventException  {
//		EsdPrd0080Event event = (EsdPrd0080Event)e;
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();
		
		eventResponse = productCatalogCreateBc.searchEqInventory(e);
		
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 * 선택화면에서 Constraint Remarking
	 */
	private EventResponse searchCnstRemark(Event e) throws EventException  {
//		EsdPrd0080Event event = (EsdPrd0080Event)e;
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();
		
		eventResponse = productCatalogCreateBc.searchCnstRemark(e);
		
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse processReplaneFinish(Event e) throws EventException {
		//EsdPrd0080Event event = (EsdPrd0080Event)e;
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
//		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
//		String uiId = "UI_PRD-0080";	
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();
		/*
		 * SC 의 createPrdCtlgFullRout 는 선택화면을 위한 메소드
		 * PC를 생성하고, 선택화면에 필요한 데이터를 위해 조회를 한다.
		 */		
		begin();
		int successFlg = productCatalogCreateBc.updateMainMapSeq(e);

		commit();
		
		begin();
		eventResponse = productCatalogCreateBc.processReplaneFinish(e);
		commit();
		if(successFlg == 0 ){
			eventResponse.setETCData("MAP_UPDATE", "FAIL");
		} else {
			eventResponse.setETCData("MAP_UPDATE", "SUCCESS");
		}
		return eventResponse;
		
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchPrdConstraint(Event e) throws EventException {
		EsdPrd0082Event event = (EsdPrd0082Event)e;
		PrdSearchParamVO prdSearchParamVO = (PrdSearchParamVO)event.getPrdSearchParamVO();
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();
		
		eventResponse.setRsVoList((List)productCatalogCreateBc.searchPrdCnstInfoNode(prdSearchParamVO.getPctlNo()));
		eventResponse.setRsVoList((List)productCatalogCreateBc.searchPrdCnstInfoLink(prdSearchParamVO.getPctlNo()));
		eventResponse.setRsVoList((List)productCatalogCreateBc.searchPrdCnstInfoRoute(prdSearchParamVO.getPctlNo()));
//		eventResponse.setRsVoList((List)productCatalogCreateBc.searchPrdCnstInfoIrgPolPod(prdSearchParamVO.getPctlNo()));
		eventResponse.setRsVoList((List)productCatalogCreateBc.searchPrdCnstInfoIrgPolPod(prdSearchParamVO));
		String caCnst = "N";
		caCnst = productCatalogCreateBc.searchPrdCnstInfoCanadaException(prdSearchParamVO.getPctlNo());
		eventResponse.setETCData("CA_CNST", caCnst);
		return eventResponse;
	}

	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse addValCheck(Event e) throws EventException {
//		EsdPrd0083Event event = (EsdPrd0083Event)e;
//		PrdValChkVO prdValChkVO = (PrdValChkVO)event.getPrdValChkVO();
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();

        try{
            begin();
            productCatalogCreateBc.addValCheck(e);
            eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
            commit();
        } catch(EventException ex){
            rollback();
            throw ex;
        } catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }			
		
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchPrdCtlgFullRout(Event e) throws EventException {
//		EsdPrd0081Event event = (EsdPrd0081Event)e;
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();
		
		eventResponse = productCatalogCreateBc.searchPrdCtlgFullRout(e);
		
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchRouteInfoByPctlNo(Event e) throws EventException {
//		EsdPrd0080Event event = (EsdPrd0080Event)e;
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();
		
		try{
			eventResponse = productCatalogCreateBc.searchRouteInfoByPctlNo(e);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return eventResponse;
	}

	/**
	 * bkg에서 pc선택화면을 위한 url 호출을 처리 
	 * (bkg에서 pc선택화면을 위한 처음 호출시)
	 * 이 메소드는 bkg에서 pc를 돌려 1개이상일때 호출되는거므로 
	 * pc생성후 1개인지 아닌지를 체크할 필요없음.
	 * mixed term change 처리 된 event가 옴.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createPrdCtlgFullRout(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
//		PrdCreateManageBC prdCreateBc = new PrdCreateManageBCImpl();
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
//		PrdPcCreateVO prdPcCreateVO = event.getPrdPcCreateVO();
		List<PrdPatternVO> list = null;
		PrdPcCreateVO prdPcCreateVO = null;
//		String uiId = "UI_PRD-0080";	
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();
		String cntrTpszQtyStr = "";
		try{
			/*
			 * PSEUDO VVD처리
			 * URL 을 호출할때 PSEUDO VVD가 올수 없으므로 바로 메세지 처리 한다
			 */
			
//			if(prdCreateParamVO.getTVvd()!= null &&  (prdCreateParamVO.getTVvd().contains("HJXX") ||
//					  prdCreateParamVO.getTVvd().contains("HJYY") ||
//					  prdCreateParamVO.getTVvd().contains("HJZZ"))  ){
//				log.debug("\n Pseudo vvd:" + prdCreateParamVO.getTVvd());
//				throw new EventException("PSEUDO VVD REQUEST FAIL");
//			}

			/*
			 * SC 의 createPrdCtlgFullRout 는 선택화면을 위한 메소드
			 * PC를 생성하고, 선택화면에 필요한 데이터를 위해 조회를 한다.
			 */
			begin();

			if(prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_REPLAN)){
				//          ★ cop개발후 주석 품.
				//CHM-201005548-01:[SCEM / PRD] F.H. 기능 연계한 개발요청
				//productCatalogCreateBc.checkReplan(e);
				//D4@4@BKG,D5@6@SO 형식을 타입 만들기 
				cntrTpszQtyStr = productCatalogCreateBc.getReplanCntrTpszQty(prdCreateParamVO.getBkgNo() , event.getPrdQuantityVOs());
				prdCreateParamVO.setCntrTpszQtyStr(cntrTpszQtyStr);
				productCatalogCreateBc.checkReplan(prdCreateParamVO);
				
				//패턴을 다시 만든다.맵을 만든다.
				list = productCatalogCreateBc.getReplanePatternForMultiPrd(e);
				event.setAttribute("PATTERN_LIST", list);

				if(list != null && list.size()>0){
					log.debug("\n\n list != null--------------------"+
							"\n ord= 1인 주패턴으로 pc를 생성");
					//ord= 1인 주패턴으로 pc를 생성한다.
					//부패턴은 선택화면에서 select 버튼을 클릭하면 처리한다.
					PrdPatternVO prdPatternVO = (PrdPatternVO)list.get(0);
					//				eventResponse.setETCData("map_seq", prdPatternVO.getCopMapgSeq());
					log.debug("\n\n prdPatternVO.getCopMapgSeq()"+prdPatternVO.getCopMapgSeq());
					
					//CopMapgSeq 를 prdCreateParamVO 에 저장한다.
					prdCreateParamVO.setCopMapgSeq(prdPatternVO.getCopMapgSeq());
				} else {
					// replan 대상이 없음.Could not find route pattern for replan. Please check COP status.
					throw new EventException(new ErrorHandler("PRD00062").getMessage());
				}
			}

			/*
			 * prd mst,dtl 생성
			 * qty 생성
			 * data 정리
			 * activity group dtl 생성
			 */

			//-------------★★★pc 생성 (mst,dtl,qty,act)★★★------------
			productCatalogCreateBc.createPrdCtlgFullRout(e);
			prdPcCreateVO = event.getPrdPcCreateVO();

			// pc선택화면의 cost를 위해 pc의 첫번째 것만 cost를 구하고,
			// 선택화면의 변경시 pc 생성때 보여주기 위한 cost를 그때 그때 구한다.(속도 개선)
			// ★ mas call --------------------------------------------------------------------------------------------------------


			log.debug("\npc min:"+prdPcCreateVO.getMinPctlNo());
			log.debug("\npc max:"+prdPcCreateVO.getMaxPctlNo());
			createCostAssignPrd(prdPcCreateVO.getMinPctlNo(), prdPcCreateVO.getMaxPctlNo(), account.getUsr_id());
			// mas call-------------------------------------------------------------------------------------------------------------
			commit();
		}catch(EventException ex){
			rollback();
			log.error("\n EventException err " + ex.toString(), ex);
			if(ex.getMessage().contains( (new ErrorHandler("PRD00074")).getMessage() )){
				log.debug("\n\n pc 생성 실패 (PRD00074: Failed to create PC.)");
				eventResponse = new GeneralEventResponse();
				event.setAttribute("prdPatternVO", event.getAttribute("prdPatternVO"));
				//EsdPrd0080Event event = (EsdPrd0080Event)e;
				String verifyMessage = new ProductCatalogCreateVerifyBCImpl().getPcVerify(event.getPrdCreateParamVO(), event.getPrdPcCreateVO(), (PrdPatternVO)event.getAttribute("prdPatternVO"));
				eventResponse.setUserMessage(verifyMessage);
				return eventResponse;
			}else  if(ex.getMessage().contains("PSEUDO VVD")){
				eventResponse.setUserMessage(ex.getMessage());
				return eventResponse;
				
			} //-- 통합 로그 메세지시 time out등의 예기치 않은 에러시 시스템 에러를 보이지 않게 함 2013-11-01  
//			else {
//				eventResponse.setUserMessage("Failed to create PC.(Pls check Ocn route count) ");
//				return eventResponse;
//			}
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("\n Exception err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		try{
			eventResponse = productCatalogCreateBc.selectPrdRoutUnit(e);

			String returnStr = productCatalogCreateBc.selectReturnStrToBkg(prdPcCreateVO.getMinPctlNo());
			eventResponse.setETCData("returnStr", returnStr);
			eventResponse.setETCData("map_seq", prdCreateParamVO.getCopMapgSeq());
			//patter이 없으면 map_seq가 없다.
			log.debug("\n\n @@@ map_seq: "+prdCreateParamVO.getCopMapgSeq());
			eventResponse.setETCData("ldd", prdCreateParamVO.getLdDt());

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
	 * @param minPctlNo
	 * @param maxPctlNo
	 * @param usr_id
	 * @throws EventException
	 */
	private void createCostAssignPrd(String minPctlNo, String maxPctlNo,
			String usr_id) throws EventException {
		int result = 0;
		CostAssignBC costCommand = new CostAssignBCImpl();
		try {
			result = costCommand.createCostAssignPrd(minPctlNo, maxPctlNo, usr_id);
		} catch (EventException ex) {
			// TODO Auto-generated catch block
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * 
	 * ESD_PRD_0020 : 이벤트 EsdPrd0080Event 를 사용<br>
	 * event name 은 0020을 사용.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createProductCatalogInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		if(event.getPrdCreateParamVO().getTVvd().length()==9){
			event.getPrdCreateParamVO().setInternalSkdType("V");
			
		} else{
			event.getPrdCreateParamVO().setInternalSkdType("L");
		}

		try{
			// pc 생성 ---------------------------------------------------------------------------
			productCatalogCreateBc.createPrdCtlgFullRout(event);
			// cost 생성 ---------------------------------------------------------------------------
			createCostAssignPrd(event.getPrdPcCreateVO().getMinPctlNo(),
					event.getPrdPcCreateVO().getMaxPctlNo(),
					((SignOnUserAccount)event.getAttribute("account")).getUsr_id());
			
			DBRowSet rowset = new ProductCatalogCreateBCImpl().createProductCatalogInquiry(event);
			//eventResponse.setETCData("", rowset.getString(""));
			eventResponse.setRsVoList(RowSetUtil.rowSetToVOs(rowset, ProductCatalogInternalMst_1VO.class));

		}catch(EventException ex){
			if(ex.getMessage().contains( (new ErrorHandler("PRD00074")).getMessage() )){
				PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
				PrdPcCreateVO prdPcCreateVO = event.getPrdPcCreateVO();
				if(prdCreateParamVO == null || prdPcCreateVO == null || "".equals(prdCreateParamVO.getPol()) ){
					log.debug("\n noh prdCreateParamVO is :"+(prdCreateParamVO == null));
					log.debug("\n noh prdPcCreateVO is :"+(prdPcCreateVO == null));
					if(prdCreateParamVO!=null){
					log.debug("\n noh pol is white space :"+prdCreateParamVO.getPol());
					}
					throw new EventException(ex.getMessage(), ex);
				}else{
					

				String verifyMessage = new ProductCatalogCreateVerifyBCImpl().getPcVerify(prdCreateParamVO, prdPcCreateVO, null);
				log.debug("\n noh verifyMessage \n"+verifyMessage);
				eventResponse.setUserMessage(verifyMessage);
				}
				return eventResponse;
			}else{
				throw ex;
			}
		}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

		// TODO delete noh
	}

	
	/**
	 * ProductCatalogCreateSC's createProductCatalogforPreCm
	 * CSR:N200807070007 BKG P/C Pre Simulation Inquiry 기능 추가
	 * @param e
	 * @return
	 * @throws EventException EventResponse
	 */
//	private EventResponse createProductCatalogforPreCm(Event e) throws EventException {
//
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsdPrd0080Event event = (EsdPrd0080Event)e;
//
//		try{
//			DBRowSet rowset = new ProductCatalogCreateBCImpl().createProductCatalogforPreCm(event);
//			//eventResponse.setETCData("", rowset.getString(""));
//			eventResponse.setRsVoList(RowSetUtil.rowSetToVOs(rowset, ProductCatalogInternalMst_1VO.class));
//		}catch(EventException ex){
//			if(ex.getMessage().contains("pc create fail")){
//				PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
//				PrdPcCreateVO prdPcCreateVO = event.getPrdPcCreateVO();
//				if(prdCreateParamVO == null || prdPcCreateVO == null || "".equals(prdCreateParamVO.getPol()) ){
//					log.debug("\n j prdCreateParamVO is :"+(prdCreateParamVO == null));
//					log.debug("\n j prdPcCreateVO is :"+(prdPcCreateVO == null));
//					log.debug("\n j pol is white space :"+prdCreateParamVO.getPol());
//					throw new EventException(ex.getMessage(), ex);
//				}
//
//				String verifyMessage = new ProductCatalogCreateVerifyBCImpl().getPcVerify(prdCreateParamVO, prdPcCreateVO, null);
//				log.debug("\n j verifyMessage \n"+verifyMessage);
//				eventResponse.setUserMessage(verifyMessage);
//				return eventResponse;
//			}else{
//				throw ex;
//			}
//		}catch(Exception ex){
//				throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;
//
//	}	
	
	/**
	 * ESD_PRD_0080 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchProductCatalogInquiryDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		try{
			List list = new ProductCatalogCreateBCImpl().searchProductCatalogInquiryDetail(e);
			eventResponse.setRsVoList(list);
			
			//ERD및 CCT 계산
			EsdPrd0080Event event = (EsdPrd0080Event)e;
			productCatalogCreateBc.getERD(eventResponse, event);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	 }
	
	/**
	 * ESD_PRD_0080 : [이벤트]<br>
	 * [Pre Simulation Detail 항목]을 [조회]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
//	private EventResponse searchProductCatalogforPreCmDetail(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		
//		try{
//			List list = new ProductCatalogCreateBCImpl().searchProductCatalogforPreCmDetail(e);
//			eventResponse.setRsVoList(list);
//		}catch(EventException ex){
//			throw ex;
//		}catch(Exception ex){
//			throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;
//		
//	}

	/**
	 * Mixed Term 을 처리하는 로직
	 * [R Term] 혹은 [D Term]을 [정의]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private void checkMixedTerm(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		PrdCreateManageBC pcCommand = new PrdCreateManageBCImpl();
		String rTerm = event.getPrdCreateParamVO().getRcvT();
		String dTerm = event.getPrdCreateParamVO().getDelT();
		String returnTerm ="";
		
		log.debug("\n\n checkMixedTerm rTerm:"+rTerm );
		log.debug("\n\n checkMixedTerm dTerm:"+dTerm );
		String por = event.getPrdCreateParamVO().getPor();
		String del = event.getPrdCreateParamVO().getDel();
		String bkgNo = event.getPrdCreateParamVO().getBkgNo();
		
		try {
				event.getPrdCreateParamVO().setBkgRcvT(rTerm);
				event.getPrdCreateParamVO().setRcvT(pcCommand.checkMixedRterm(bkgNo,por, rTerm));
			if (rTerm !=null && (rTerm.equals("M"))){	
				returnTerm = pcCommand.checkMixedTermYard(event.getPrdCreateParamVO().getRcvT(), event.getPrdCreateParamVO().getPorN());
				if (returnTerm.equals("N")){
					event.getPrdCreateParamVO().setPorN("");
				}
			}
				event.getPrdCreateParamVO().setBkgDelT(dTerm);
				event.getPrdCreateParamVO().setDelT(pcCommand.checkMixedDterm(bkgNo,del, dTerm));
			if (dTerm !=null && (dTerm.equals("M"))){	
				returnTerm = pcCommand.checkMixedTermYard(event.getPrdCreateParamVO().getDelT(), event.getPrdCreateParamVO().getDelN());
				if (returnTerm.equals("N")){
					event.getPrdCreateParamVO().setDelN("");
				}
			}
			
			/*****************************************************************************
			 * SRM-201113276 Group VVD assign시 POD의 location 정보를 PRD로 전달시 yard 제외요청
			 * BKG Main 에 입력한 POL/POD Node는 Route에 반영하지만
			 * Group VVD Assign, Next VVD Assign 등 VVD assign 시에는 POD Node를 반영하지 않음.
			 * 
			 * (BKG Main에 입력한 POD Node와 Route Detail 마지막 POD Node는 항상 일치)
			 *****************************************************************************/			
			if(null!=event.getPrdCreateParamVO().getPod() && !"".equals(event.getPrdCreateParamVO().getPod())
					&& event.getPrdCreateParamVO().getPod().equals(event.getPrdCreateParamVO().getPod1())){
				if( null!=event.getPrdCreateParamVO().getPodN() && !"".equals(event.getPrdCreateParamVO().getPodN())  ){
					if(!event.getPrdCreateParamVO().getPodN().equals(event.getPrdCreateParamVO().getPod1N())){
						event.getPrdCreateParamVO().setPodN("");
					}
				}
			}
			if(null!=event.getPrdCreateParamVO().getPod() && !"".equals(event.getPrdCreateParamVO().getPod())
					&& event.getPrdCreateParamVO().getPod().equals(event.getPrdCreateParamVO().getPod2())){
				if( null!=event.getPrdCreateParamVO().getPodN() && !"".equals(event.getPrdCreateParamVO().getPodN())  ){
					if(!event.getPrdCreateParamVO().getPodN().equals(event.getPrdCreateParamVO().getPod2N()))
					event.getPrdCreateParamVO().setPodN("");
				}
			}
			if(null!=event.getPrdCreateParamVO().getPod() && !"".equals(event.getPrdCreateParamVO().getPod())
					&& event.getPrdCreateParamVO().getPod().equals(event.getPrdCreateParamVO().getPod3())){
				if( null!=event.getPrdCreateParamVO().getPodN() && !"".equals(event.getPrdCreateParamVO().getPodN())  ){
					if(!event.getPrdCreateParamVO().getPodN().equals(event.getPrdCreateParamVO().getPod3N())){
						event.getPrdCreateParamVO().setPodN("");
					}
				}
			}
			if(null!=event.getPrdCreateParamVO().getPod() && !"".equals(event.getPrdCreateParamVO().getPod())
					&& event.getPrdCreateParamVO().getPod().equals(event.getPrdCreateParamVO().getPod4())){
				if( null!=event.getPrdCreateParamVO().getPodN() && !"".equals(event.getPrdCreateParamVO().getPodN())  ){
					if(!event.getPrdCreateParamVO().getPodN().equals(event.getPrdCreateParamVO().getPod4N())){
						event.getPrdCreateParamVO().setPodN("");
					}
				}
			}
			
			rTerm = event.getPrdCreateParamVO().getRcvT();
			dTerm = event.getPrdCreateParamVO().getDelT();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

}