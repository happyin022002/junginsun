/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRISimulationDBDAO.java
*@FileTitle : PRI Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPriSetParamVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.basic.PreCMSimulationBC;
import com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.basic.PreCMSimulationBCImpl;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration.PRICommonDataDBDAO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.basic.PRISimulationBC;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.basic.PRISimulationBCImpl;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.event.EsmPri6001Event;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.event.EsmPri6002Event;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.event.EsmPri6101Event;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.event.EsmPri6102Event;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtOutVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriCntrInfoVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriSimRoutInfoVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.TrfChgVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * PRI Business Logic ServiceCommand - PRI 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SHKIM
 * @see PRICommonDataDBDAO
 * @since J2EE 1.6
 */

public class PRISimulationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PRI system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("*****************************************PRISimulationSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PRI system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("*************************************PRISimulationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * PRI system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmPri6001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	//SHKIM USING 5004 inquery success
				eventResponse = createSimulationProductCatalogInquiry(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = createApplyRate(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = checkCtrtType(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = backEndJobResult(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				eventResponse = searchInfoByPctlNo(e);
			}else{
				eventResponse = initVerifyRateComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri6101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFindContractInfo(e);
			}else{
				eventResponse = initFindContractComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri6102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRevenueDetailInfo(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmPri6002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) || e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = createPreCMSimulationCostList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchBackEndJobStatus(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { 	// BackEndJob 결과 조회
                eventResponse = searchBackEndJobResult(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) { 	// sheet1조회
            	eventResponse = searchPreCMSimulationCostList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
            	eventResponse = createTariffSurcharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
            	eventResponse = backEndJobResult(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
            	eventResponse = searchChgCd(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
            	eventResponse = searchSlsOfcCd(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)){
            	eventResponse = searchFirstPreCMSimulationCostList(e);
            } else{
				eventResponse = initVerifyRateComboData(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6001 : OPEN<br>
	 * Retrieving Combo Data<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initVerifyRateComboData(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			
			ArrayList<CodeInfo> cgoTpCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01701", 0);
			List<RsltCdListVO> eqtTpCdList = command.searchCntrTpCodeList();
			List<RsltCdListVO> svcScpCdList = command.searchServiceScopeCodeList(new RsltCdListVO());
			ArrayList<CodeInfo> gohCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01708", 0);
			ArrayList<CodeInfo> trnsModCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01720", 0);
			ArrayList<CodeInfo> wgtUtCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD00775", 0);
			ArrayList<CodeInfo> measUtCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01116", 0);
			ArrayList<CodeInfo> filerList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02098", 0);
			ArrayList<CodeInfo> siCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01619", 0);
			
			eventResponse.setCustomData("cgoTpCdList", cgoTpCdList);
			eventResponse.setCustomData("eqtTpCdList", eqtTpCdList);
			eventResponse.setCustomData("svcScpCdList", svcScpCdList);
			eventResponse.setCustomData("gohCdList", gohCdList);
			eventResponse.setCustomData("trnsModCdList", trnsModCdList);
			eventResponse.setCustomData("wgtUtCdList", wgtUtCdList);
			eventResponse.setCustomData("measUtCdList", measUtCdList);
			eventResponse.setCustomData("filerList", filerList);
			eventResponse.setCustomData("siCdList", siCdList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6001 : Search<br>
	 * Creating Product Catalog and Retrieving the Data<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createSimulationProductCatalogInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRISimulationBC command = new PRISimulationBCImpl();
		ProductCatalogCreateBC productCatalogCreateBC = new ProductCatalogCreateBCImpl();
		PrdMainInfoVO prdMainInfoVO = null;
		PrdParameterVO prdParameterVO = new PrdParameterVO();
		AplyRtInVO paramVO = null;
		
		try{
			if ("EsmPri6001Event".equalsIgnoreCase(e.getEventName())) {
				EsmPri6001Event event = (EsmPri6001Event)e;
				prdMainInfoVO = event.getPrdMainInfoVO();
				paramVO = event.getAplyRtInVO();
			}
			if(prdMainInfoVO != null && paramVO != null) {
				prdMainInfoVO.setPcMode("P");//Pricing
				prdMainInfoVO.setLdDt(prdMainInfoVO.getLdDt().replaceAll("-", ""));
				prdMainInfoVO.setDgF("DG".equals(paramVO.getCgoTpCd())?"Y":null);
				prdMainInfoVO.setRfF("RF".equals(paramVO.getCgoTpCd())?"Y":null);
				prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
				// pc creation ---------------------------------------------------------------------------
				String pctlNo = productCatalogCreateBC.createPrdCtlgRout(prdParameterVO, account);
				// pc retrieve
				paramVO.setPctlNo(pctlNo);
				List<PriSimRoutInfoVO> list = command.searchProductCatalog(paramVO);
				eventResponse.setRsVoList(list);
			}
		}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6001 : Apply Rate<br>
	 * Applying rate with selected route and contract<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createApplyRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRISimulationBC command = new PRISimulationBCImpl();
//		GeneralBookingReceiptBC bkgCommand = new GeneralBookingReceiptBCImpl();
//		ProductCatalogCreateBC  productCatalogCreateBC = new ProductCatalogCreateBCImpl();
		
		EsmPri6001Event event = (EsmPri6001Event)e;
		try{
			begin();
			AplyRtInVO vo = event.getAplyRtInVO();
//			String svcScpCd = bkgCommand.searchSvcScope(vo.getSlanCd(), vo.getPor(), vo.getDel());
//			vo.setSvcScpCd(svcScpCd);
//			productCatalogCreateBC.modifyPrdProdCtlMstByPRI(getPrdUpdParam(vo));
			command.managePriSimPara(vo, account.getUsr_id());
			commit();
			
			String key = command.createApplyRateBackEndJobStart(vo, account);
			eventResponse.setETCData("BackEndJobKey", key);
			
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6001 : Contract No Change<br>
	 * Checking Contract Type. (SC,RFA,TAA)<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse checkCtrtType(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRISimulationBC command = new PRISimulationBCImpl();
		 
		EsmPri6001Event event = (EsmPri6001Event)e;
		try{
			String ctrtTp = command.checkCtrtType(event.getCtrtNo());
			eventResponse.setETCData("ctrt_tp", ctrtTp);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6002 : Search<br>
	 * Creating Product Catalog and Retrieving the Data<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createPreCMSimulationCostList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PreCMSimulationBC command2 = new PreCMSimulationBCImpl();
		ProductCatalogCreateBC productCatalogCreateBC = new ProductCatalogCreateBCImpl();
		PrdMainInfoVO prdMainInfoVO = null;
		PrdParameterVO prdParameterVO = new PrdParameterVO();
		AplyRtInVO paramVO = null;
		String mtyPkup = null;
		String mtyRtn = null;
		String agnBkgOfc  = null;
		String agnCtrtOfc = null;
		String agnFfCust  = null;
		
		try{
			EsmPri6002Event event = (EsmPri6002Event)e;
			prdMainInfoVO = event.getPrdMainInfoVO();
			
			paramVO = event.getAplyRtInVO();
			prdMainInfoVO.setPcMode("P");//Pricing
			prdMainInfoVO.setLdDt(prdMainInfoVO.getLdDt().replaceAll("-", ""));
			prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
			// pc creation ---------------------------------------------------------------------------
//			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)){
//				String pctlNo = productCatalogCreateBC.createPrdCtlgRout(prdParameterVO, account);
//				// pc retrieve
//				paramVO.setPctlNo(pctlNo);
//				eventResponse.setETCData("F_PCTL_NO", paramVO.getPctlNo());
//			}else 
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){	//pop-up 으로 pctl_no 한개를 가지고 온 경우
				paramVO.setPctlNo(paramVO.getFPctlNo());
				eventResponse.setETCData("F_PCTL_NO", paramVO.getPctlNo());
			}
			begin();
			String BackEndJobKey = "BackEndJobKey";
			StringBuffer sbBackEndJobKey = new StringBuffer();
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)){
				AplyRtInVO[] paramVOS = null;
				paramVOS = event.getAplyRtInVOs();
				int calCnt = 0;
				
				if(paramVOS.length>0){
					mtyPkup = paramVOS[0].getFMtyPkupYdCd();
					if(mtyPkup!=null && !"".equals(mtyPkup)){
						mtyPkup = mtyPkup+"00";
					}
					mtyRtn = paramVOS[0].getFMtyRtnYdCd();
					if(mtyRtn!=null && !"".equals(mtyRtn)){
						mtyRtn = mtyRtn+"00";
					}
					agnBkgOfc  = paramVOS[0].getFAgnBkgOfcCd();
					agnCtrtOfc = paramVOS[0].getFAgnCtrtOfcCd();
					agnFfCust  = paramVOS[0].getFAgnFfCust();

				}

				for(int i = 0; i < paramVOS.length; i++){
					if(!"Y".equals(paramVOS[i].getCostFlg()) && calCnt<10){
						paramVOS[i].setFMtyPkupYdCd(mtyPkup);
						paramVOS[i].setFMtyRtnYdCd(mtyRtn);
						paramVOS[i].setFAgnBkgOfcCd(agnBkgOfc);
						paramVOS[i].setFAgnCtrtOfcCd(agnCtrtOfc);
						paramVOS[i].setFAgnFfCust(agnFfCust);

//						command.modifySimRoutMst2(paramVOS[i]);
						BackEndJobKey = command2.createPreCMSimulation(paramVOS[i],account);
						sbBackEndJobKey.append(BackEndJobKey).append("$");
						calCnt = calCnt +1;
					}
				}
			}else{
				productCatalogCreateBC.modifyPrdProdCtlMstByPRI(getPrdUpdParam(paramVO));

				mtyPkup = paramVO.getFMtyPkupYdCd();
				if(mtyPkup!=null && !"".equals(mtyPkup)){
					mtyPkup = mtyPkup+"00";
				}
				mtyRtn = paramVO.getFMtyRtnYdCd();
				if(mtyRtn!=null && !"".equals(mtyRtn)){
					mtyRtn = mtyRtn+"00";
				}
				paramVO.setFMtyPkupYdCd(mtyPkup);
				paramVO.setFMtyRtnYdCd(mtyRtn);
				
				BackEndJobKey = command2.createPreCMSimulation(paramVO,account);
				sbBackEndJobKey.append(BackEndJobKey);
			}
//			eventResponse.setETCData("BackEndJobKey", BackEndJobKey);
			
			log.debug("key==>"+sbBackEndJobKey.toString());
			eventResponse.setETCData("BackEndJobKey", sbBackEndJobKey.toString());
			commit();
		}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6002 : Search<br>
	 * Creating Product Catalog and Retrieving the Data<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchFirstPreCMSimulationCostList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRISimulationBC command = new PRISimulationBCImpl();
		ProductCatalogCreateBC productCatalogCreateBC = new ProductCatalogCreateBCImpl();
		PrdMainInfoVO prdMainInfoVO = null;
		PrdParameterVO prdParameterVO = new PrdParameterVO();
		AplyRtInVO paramVO = null;
		String svcScp = null;
		
		try {
			EsmPri6002Event event = (EsmPri6002Event) e;
			paramVO = event.getAplyRtInVO();
			prdMainInfoVO = event.getPrdMainInfoVO();
			
			paramVO = event.getAplyRtInVO();
			prdMainInfoVO.setPcMode("P");//Pricing
			prdMainInfoVO.setLdDt(prdMainInfoVO.getLdDt().replaceAll("-", ""));
			prdMainInfoVO.setDgF("DG".equals(paramVO.getCgoTpCd())?"Y":null);
			prdMainInfoVO.setRfF("RF".equals(paramVO.getCgoTpCd())?"Y":null);
			//reeferdry는?
			prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
			// pc creation ---------------------------------------------------------------------------
			String pctlNo = productCatalogCreateBC.createPrdCtlgRout(prdParameterVO, account);
			// pc retrieve
			paramVO.setPctlNo(pctlNo);
			eventResponse.setETCData("F_PCTL_NO", pctlNo);
			begin();	
			productCatalogCreateBC.modifyPrdProdCtlMstByPRI(getPrdUpdParam(paramVO));
			
			List<PriSimRoutInfoVO> list = command.searchCMCost(paramVO);

        	svcScp = command.searchSvcScp(pctlNo);
        	eventResponse.setETCData("svc_scp", svcScp);
			commit();
			eventResponse.setRsVoList(list);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
    /**
     * BackEndJob : interval <br>
     * BackEndJob의 상태값을 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBackEndJobStatus(Event e) throws EventException {
        String key = (String)e.getAttribute("KEY");
        String status = null;
        PreCMSimulationBC command = new PreCMSimulationBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            status = command.searchBackEndJobStatus(key);
            eventResponse.setETCData("jb_sts_flg", status);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * BackEndJob : search <br>
     * BackEndJob 결과 리스트를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBackEndJobResult(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse(); 	
        String key = (String)e.getAttribute("KEY");
        try {            
        	AplyRtInVO vo= (AplyRtInVO)BackEndJobResult.loadFromFile(key);    
        	eventResponse.setETCData("err_cd", vo.getErrorCode());
            eventResponse.setETCData("err_msg", vo.getErrorMsg());            
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * ESM_PRI_6002 : Search<br>
	 * Creating Product Catalog and Retrieving the Data<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPreCMSimulationCostList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRISimulationBC command = new PRISimulationBCImpl();
		AplyRtInVO paramVO = null;

		try {
			EsmPri6002Event event = (EsmPri6002Event) e;
			paramVO = event.getAplyRtInVO();
			paramVO.setPctlNo(paramVO.getFPctlNo());
			List<PriSimRoutInfoVO> list = command.searchCMCost(paramVO);

			eventResponse.setRsVoList(list);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	//###############ESM_PRI_6101 START
	
	/**
	 * ESM_PRI_6101 : Load Page <br>
	 * Initializing basic Code List<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initFindContractComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        try{
            // Service Scope Code List
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            // Cargo Type => S/C CARGO TYPE CODE  ( 통합코드 : CD02202 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02202", 0);
            eventResponse.setCustomData("cargoType", codeInfos);
        	// Customer Type combo
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02687", 0);
            eventResponse.setCustomData("customerType", codeInfos);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6101 : Retrive <br>
	 * Retrive the result list for Contract Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFindContractInfo(Event e) throws EventException {
		EsmPri6101Event event = (EsmPri6101Event) e;
		PRISimulationBC command = new PRISimulationBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<PriCntrInfoVO> list = new ArrayList<PriCntrInfoVO>();

        try{
        	list = command.searchContractInfoList(event.getPriCntrSrhCondVO());
        	eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	//###############ESM_PRI_6101 END
	
	/**
	 * ESM_PRI_6101 : Retrive <br>
	 * Retrive the result list for Contract Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevenueDetailInfo(Event e) throws EventException {
		EsmPri6102Event event = (EsmPri6102Event) e;
		PRISimulationBC command = new PRISimulationBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<AplyRtOutVO> list = new ArrayList<AplyRtOutVO>();

        try{
        	list = command.searchRevenueDetailInfo(event.getAplyRtInVO());
        	eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * ESM_PRI_6001 :
	 * APLY RATE BACK-END RESULT<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		String strResult = "";

		if ("EsmPri6001Event".equalsIgnoreCase(e.getEventName())) {
			EsmPri6001Event event = (EsmPri6001Event) e;
			sKey = event.getKey();
		}
		else if ("EsmPri6002Event".equalsIgnoreCase(e.getEventName())) {
			EsmPri6002Event event = (EsmPri6002Event) e;
			sKey = event.getKey();
		}
		
		try
		{
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
			BackEndJobResult backEndJobResult = new BackEndJobResult();
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
			while(rowSet.next())
			{
				if ("2".equals(rowSet.getString("JB_STS_FLG")))
				{
					// BackEndJob 처리중
					strResult = "PROCESSING";
				}
				else if ("3".equals(rowSet.getString("JB_STS_FLG")))
				{
					// 성공메시지세팅
					if ("EsmPri6001Event".equalsIgnoreCase(e.getEventName())) {
						List<AplyRtOutVO> list = (List<AplyRtOutVO>)backEndJobResult.loadFromFile(sKey);
						if ( list.size() == 0 )
						{
							eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());
						} else {
							eventResponse.setRsVoList(list);
						}
					}
					else if ("EsmPri6002Event".equalsIgnoreCase(e.getEventName())) {
						List<TrfChgVO> list = (List<TrfChgVO>)backEndJobResult.loadFromFile(sKey);
						if ( list.size() == 0 )
						{
							eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());
						} else {
							eventResponse.setRsVoList(list);
						}
					}
					strResult = "SUCCESS";
				}
				else if ("4".equals(rowSet.getString("JB_STS_FLG")))
				{
					// 에러메시지세팅
					String errMsg = rowSet.getString("jb_usr_err_msg");
					if(errMsg==null||"".equals(errMsg)){
						eventResponse.setUserMessage(new ErrorHandler("COM12240").getUserMessage());
					}else{
						eventResponse.setETCData("err_msg", rowSet.getString("jb_usr_err_msg"));
					}

					strResult = "FAIL";
				}
			}
			eventResponse.setETCData("jb_sts_flg", strResult);
		} catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6002 : Subject To Tariff Surcharge<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createTariffSurcharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRISimulationBC command = new PRISimulationBCImpl();
//		ProductCatalogCreateBC productCatalogCreateBC = new ProductCatalogCreateBCImpl();
		EsmPri6002Event event = (EsmPri6002Event)e;

		try{
			begin();
			
			AplyRtInVO aplyRtInVO = event.getAplyRtInVO();
			PriSimRoutInfoVO[] list = event.getPriSimRoutInfoVOs();
			for (int i=0; i<list.length; i++)
			{
				AplyRtInVO vo = new AplyRtInVO();
				ObjectCloner.build(aplyRtInVO, vo);
//				vo.setSvcScpCd(list[i].getSvcScpCd()); //aplyRtInVO 의 svc scope 사용
				vo.setPctlNo(list[i].getPctlNo());
				vo.setOrgTrnsModCd(list[i].getROrgTrnsModCd());
				vo.setDestTrnsModCd(list[i].getRDestTrnsModCd());
//				productCatalogCreateBC.modifyPrdProdCtlMstByPRI(getPrdUpdParam(vo));
				command.managePriSimPara(vo, account.getUsr_id());
			}
			commit();
			
			String key = command.createTrfChgBackEndJobStart(aplyRtInVO, account);
			eventResponse.setETCData("BackEndJobKey", key);
			
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	

	/**
	 * ESM_PRI_6002 : 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChgCd(Event e) throws EventException {
		EsmPri6002Event event = (EsmPri6002Event) e;
		PRISimulationBC command = new PRISimulationBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<TrfChgVO> list = null;

        try{
        	list = command.searchChgCd(event.getAplyRtInVO().getFPctlNo());
        	eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * ESM_PRI_6002
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSlsOfcCd(Event e) throws EventException {
		EsmPri6002Event event = (EsmPri6002Event) e;
		PRISimulationBC command = new PRISimulationBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<AplyRtInVO> list = null;

        try{
        	list = command.searchSlsOfcCd(event.getAplyRtInVO().getPor().toString());
        	eventResponse.setETCData(list.get(0).getColumnValues());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	/**
	 * prd update parameter setting : 
	 * 
	 * @param AplyRtInVO param
	 * @return PrdParameterVO
	 * @exception Exception
	 */
	private PrdParameterVO getPrdUpdParam(AplyRtInVO param) throws Exception {
		PrdPriSetParamVO prdSetParamVO = new PrdPriSetParamVO();
		PrdParameterVO prdParameterVO = new PrdParameterVO(); 
		try{
			if(param!=null){
				prdSetParamVO.setCgoTpCd(param.getCgoTpCd());
				prdSetParamVO.setEqTpCd(param.getEqTpCd());
				prdSetParamVO.setSvcScpCd(param.getSvcScpCd());
				prdSetParamVO.setSocFlg(param.getSocFlg());
				prdSetParamVO.setGohCd(param.getGohCd());
				prdSetParamVO.setCmdtCd(param.getCmdtCd());
				prdSetParamVO.setCustCntCd(param.getCustCntCd());
				prdSetParamVO.setCustSeq(param.getCustSeq());
				prdSetParamVO.setCtrtTp(param.getCtrtTp());
				prdSetParamVO.setCtrtNo(param.getCtrtNo());
				prdSetParamVO.setPctlNo(param.getPctlNo());
				prdSetParamVO.setUpdUsrId(account.getUsr_id());
				prdParameterVO.setPrdPriSetParamVO(prdSetParamVO);

			}
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return prdParameterVO;
	}
	
	/**
	 * ESM_PRI_6001 : 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInfoByPctlNo(Event e) throws EventException {
		EsmPri6001Event event = (EsmPri6001Event) e;
		PRISimulationBC command = new PRISimulationBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String svcScp = null;
		String[] trnsMod = new String[2];
		
        try{
        	svcScp = command.searchSvcScp(event.getAplyRtInVO().getPctlNo());
        	trnsMod = command.searchTrnsMod(event.getAplyRtInVO().getPctlNo());
        	eventResponse.setETCData("svc_scp", svcScp);
        	eventResponse.setETCData("ob_trns_mod", trnsMod[0]);
        	eventResponse.setETCData("ib_trns_mod", trnsMod[1]);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	
}