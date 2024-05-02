/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateWebSC.java
*@FileTitle : ProductCatalogCreate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.22
*@LastModifier : 정선용
*@LastVersion : 1.0 
* 2014.09.19 정선용
* 1.0 Creation
* history
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration.ProductCatalogCreateDBDAO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;





/**
 * ALPS-ProductCatalogCreate Business Logic ServiceCommand - ALPS-ProductCatalogCreate 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author sun yong Jung
 * @see ProductCatalogCreateDBDAO
 * @since J2EE 1.6
 */

public class ProductCatalogCreateWebSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ProductCatalogCreate system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ProductCatalogCreateWebSC 시작"); 
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
		log.debug("ProductCatalogCreateWebSC 종료");
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
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
			// Mixed Term 을 처리.
				this.checkMixedTerm(e );
			//화면을 나타내기 위해 try 로 잡음.
				eventResponse = this.createPrdCtlgFullRoutWeb(e );
			} 
		//pc dtl 조회
		}
		
		timeSub = System.currentTimeMillis();
		log.info("\n------------------------------------------------------------------------------" +
				 "\n  PRD Time: "+dateFormat.format(new Date(System.currentTimeMillis()-timeTotal)) +
				 "\n------------------------------------------------------------------------------");

		return eventResponse;
	}



	/**
	 * web bkg 에서 호풀
	 * 이 메소드는 bkg에서 pc를 돌려 1개이상일때 호출되는거므로 
	 * pc생성후 1개인지 아닌지를 체크할 필요없음.
	 * mixed term change 처리 된 event가 옴.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createPrdCtlgFullRoutWeb(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		
		PrdParameterVO prdParameterVO  = (PrdParameterVO) event.getAttribute("prdParameterVO");
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		event = (EsdPrd0080Event)prdCreateManageBc.setPrdCreateParam(prdParameterVO);
		
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
// web bkg 에선 미사용
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
			productCatalogCreateBc.createPrdCtlgFullRoutWeb(e);
			prdPcCreateVO = event.getPrdPcCreateVO();

			// pc선택화면의 cost를 위해 pc의 첫번째 것만 cost를 구하고,
			// 선택화면의 변경시 pc 생성때 보여주기 위한 cost를 그때 그때 구한다.(속도 개선)
			// ★ coa call --------------------------------------------------------------------------------------------------------


			log.debug("\npc min:"+prdPcCreateVO.getMinPctlNo());
			log.debug("\npc max:"+prdPcCreateVO.getMaxPctlNo());
			createCostAssignPrd(prdPcCreateVO.getMinPctlNo(), prdPcCreateVO.getMaxPctlNo(), account.getUsr_id());
			// coa call-------------------------------------------------------------------------------------------------------------
			
			// Web 용 pctl No를 하나 선택하여 넘겨준다.
			DBRowSet rowset = null;
			rowset = new ProductCatalogCreateDBDAO().searchProductCatalogInternalMst_1(event.getPrdPcCreateVO().getHdPctlNo());
			String returnPctlNo = "";
			String cnsfFlg = "";
			while( rowset.next()){
				returnPctlNo = rowset.getString("PCTL_NO");
				cnsfFlg = rowset.getString("REMARK");
				if( !"X".equals(cnsfFlg)) {
					eventResponse.setETCData("PCTL_NO",returnPctlNo);
					break;
				}
			}
			
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
		
//		try{
//			eventResponse = productCatalogCreateBc.selectPrdRoutUnit(e);
//
//			String returnStr = productCatalogCreateBc.selectReturnStrToBkg(prdPcCreateVO.getMinPctlNo());
//			eventResponse.setETCData("returnStr", returnStr);
			eventResponse.setETCData("map_seq", prdCreateParamVO.getCopMapgSeq());
			//patter이 없으면 map_seq가 없다.
			log.debug("\n\n @@@ map_seq: "+prdCreateParamVO.getCopMapgSeq());
//			eventResponse.setETCData("ldd", prdCreateParamVO.getLdDt());
//
//		}catch(EventException ex){
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}catch(Exception ex){
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//		
		
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