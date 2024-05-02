/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SceAdminManageSC.java
*@FileTitle : SCE Admin
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.02
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.12.02 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.sceadminmanage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.hanjin.apps.alps.esd.sce.common.SCEConstants;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.basic.SceAdminManageBC;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.basic.SceAdminManageBCImpl;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.event.EsdSce6000Event;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration.SceAdminManageDBDAO;
//import com.hanjin.apps.alps.esd.sce.sceadminmanage.edi315manage.basic.Edi315ManageBC;
//import com.hanjin.apps.alps.esd.sce.sceadminmanage.edi315manage.basic.Edi315ManageBCImpl;
//import com.hanjin.apps.alps.esd.sce.sceadminmanage.edi315manage.event.EsdSce9997Event;
//import com.hanjin.apps.alps.esd.sce.sceadminmanage.edi315manage.integration.Edi315ManageDBDAO;
//import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SearchLeaMonthlyWorkVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.CntrDiffVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.ManRplnRsltVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SceAdminObjVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SearchLeaMonthlyWorkVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SearchSceMnlRplnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SceActTmlIfVO;
import com.hanjin.syscommon.common.table.SceBkgOpHisVO;
import com.hanjin.syscommon.common.table.SceCopHdrVO;
import com.hanjin.framework.component.rowset.DBRowSet;


/**
 * ALPS-SceAdminManage Business Logic ServiceCommand - ALPS-SceAdminManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim In-soo
 * @see SceAdminManageDBDAO
 * @since J2EE 1.6
 */

public class SceAdminManageSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * SceAdminManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("SceAdminManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SceAdminManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SceAdminManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SceAdminManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdSce6000Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTmlChgRslt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifyActTimIfSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRplnCops(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) {
				eventResponse = addBatchManualReplan(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = replanManual(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMstCopNoDiff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCntrDiff(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
			
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchActDatRcvIf(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = modifyCntrAction(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchLeaMonthlyWorkCandidate(e); // LEA 대상 Retrieve
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = addSceMngRpln(); // MNR Replan Add
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchSceMngRpln(); // MNR Replan Retrieve
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
				eventResponse = addCandidateSceCsrMntr(e); // LEA->ALPS IF
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				addCandidateSceCsrMntr(e);
				addSceMngRpln();
				eventResponse = searchSceMngRpln();
			}
 		}
//		else if (e.getEventName().equalsIgnoreCase("EsdSce9997Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//				eventResponse = searchBkgCntrNo(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
//				eventResponse = searchBkgCopNo(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
//				eventResponse = searchBkgEdiGrpCd(e);
//			}
//		}
		
		return eventResponse;
	}
	/**
	 * ESD_SCE_6000 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTmlChgRslt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce6000Event event = (EsdSce6000Event)e;
		SceAdminManageBC command = new SceAdminManageBCImpl();

		try{
			List<SceActTmlIfVO> list = command.searchTmlChgRslt(event.getSceAdminObjVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyActTimIfSts(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce6000Event event = (EsdSce6000Event)e;
		SceAdminManageBC command = new SceAdminManageBCImpl();

		try{
			SceActTmlIfVO[] sceActTmlIfVos = event.getSceActTmlIfVOs();
			
			for (int i = 0; i < sceActTmlIfVos.length; i ++ ) {
				SceActTmlIfVO sceActTmlIfVO = sceActTmlIfVos[i];
				begin();
				command.modifyActTmlIfSts(sceActTmlIfVO);
				commit();
			}
			
//			List<SceActTmlIfVO> list = command.modifyActTimIfSts(event.getSceActTmlIfVOs());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRplnCops(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce6000Event event = (EsdSce6000Event)e;
		SceAdminManageBC command = new SceAdminManageBCImpl();

		try{
			List<SceCopHdrVO> list = command.searchRplnCops(event.getSceAdminObjVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse replanManual(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce6000Event event = (EsdSce6000Event) e;
		SceAdminManageBC manBC = new SceAdminManageBCImpl();
		ReplanManageBC replanManageBC = new ReplanManageBCImpl();
		ProductCatalogCreateBC prdBC = new ProductCatalogCreateBCImpl();

		List<ManRplnRsltVO> rsltList = new ArrayList<ManRplnRsltVO>();
		
		Set<String> bkgNoSet = new HashSet<String> ();

		ManRplnRsltVO[] tcs = event.getManRplnRsltVOs();
		boolean rslt = false;

		try {
			if (tcs != null && tcs.length > 0) {
				for (int i = 0; i < tcs.length; i++) {
					ManRplnRsltVO rowVO = new ManRplnRsltVO();
					ManRplnRsltVO tc = tcs[i];
						
						if (tc.getCopNo() == null || tc.getCopNo().equals("")) {
							continue;
						} 
						SceAdminObjVO sceAdminObjVO = new SceAdminObjVO();
						sceAdminObjVO.setRplnCopNo(tc.getCopNo());
						List<SceCopHdrVO> tmpList = manBC.searchRplnCops(sceAdminObjVO);
						SceCopHdrVO tmp = new SceCopHdrVO();
						begin();
						if (tmpList != null && tmpList.size() == 1) {
							tmp = tmpList.get(0);
							tc.setMstCopNo(tmp.getMstCopNo());
							tc.setBkgNo(tmp.getBkgNo());
							
							tc.setCntrNo(tmp.getCntrNo());
							
							SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
							String pctl_no = tc.getPctlNo(); // 화면에서 주어진게 default
							if (tc.getRegenPc().equals("1")) { // regen 하게 되면 pctl_no 재생성
								
								if (tc.getBkgInfo().equals("1")) {
									pctl_no = prdBC.createSceSoReplanByBkgInfo(tc.getCopNo(), "T", "manRpln");
								} else {
									pctl_no = prdBC.createSceSoReplan(tc.getCopNo(), "T", "manRpln");	
								}
							} 
							
							if (!tc.getRegenPc().equals("1") && (tc.getPctlNo() == null || tc.getPctlNo().equals(""))) { // 재생성이 아니고 pc_no 가 화면에서 들어오면 해당 내역으로 replan
								// 재생성이 아니고 화면에 PC 가 입력 된 값이 없을 경우
								pctl_no = tmp.getPctlNo();
							} 
												
							sceCopHdrVO.setPctlNo(pctl_no);
							sceCopHdrVO.setCopNo(tc.getCopNo());
							sceCopHdrVO.setMstCopNo(tc.getMstCopNo());
							sceCopHdrVO.setBkgNo(tc.getBkgNo());
							sceCopHdrVO.setCntrNo(tc.getCntrNo());
							
							rslt = replanManageBC.replanCop(sceCopHdrVO, "MnlRplnByUI");
							ObjectCloner.build(tc, rowVO);
							rowVO.setPctlNo(pctl_no);
						}
						// bkg set 에 대해서 COA 의 일배치 대상으로 insert
						commit();
						//if (rslt && "1".equals(tc.getCoaIfFlg())) bkgNoSet.add(tc.getBkgNo());
						if (rslt) bkgNoSet.add(tc.getBkgNo());
						
					rowVO.setRplnRslt(rslt ? "SUCCESS" : "FAIL");
					rsltList.add(rowVO);				
				}
				
				if (bkgNoSet.size() >= 1){
					begin();
					manBC.interfaceMasDailyBtch(bkgNoSet);
					commit();
				}
			}
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

		eventResponse.setRsVoList(rsltList);

		return eventResponse;
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse addBatchManualReplan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce6000Event event = (EsdSce6000Event) e;
		SceAdminManageBC command = new SceAdminManageBCImpl();
		ManRplnRsltVO[] mnlRpVOs = event.getManRplnRsltVOs();
		String rplnJobTypeCode = null;
		List<ManRplnRsltVO> rsltList = new ArrayList<ManRplnRsltVO>();
		int resultInt = 0;
		try{
			begin();
			for(int i=0; mnlRpVOs!=null && i<mnlRpVOs.length; i++){
				ManRplnRsltVO rowVO = new ManRplnRsltVO();
				ObjectCloner.build(mnlRpVOs[i], rowVO);
				
				SearchSceMnlRplnVO searchSceMnlRplnVO = new SearchSceMnlRplnVO();
				searchSceMnlRplnVO.setCopNo(mnlRpVOs[i].getCopNo());
				searchSceMnlRplnVO.setCreUsrId("SCE_ADM");
				searchSceMnlRplnVO.setIoBndCd("T");

				if("1".equals(mnlRpVOs[i].getBkgInfo())){
					rplnJobTypeCode = "B";
					searchSceMnlRplnVO.setPctlNo(mnlRpVOs[i].getPctlNo());
				}else if("1".equals(mnlRpVOs[i].getRegenPc())){
					rplnJobTypeCode = "T";
					searchSceMnlRplnVO.setPctlNo(mnlRpVOs[i].getPctlNo());
				}else{
					rplnJobTypeCode = "R";
				}
				searchSceMnlRplnVO.setRplnJbTpCd(rplnJobTypeCode);
				searchSceMnlRplnVO.setRplnScsFlg("N");

				resultInt = command.addSceMngRpln(searchSceMnlRplnVO);
				
				rowVO.setRplnRslt(resultInt>0 ? "INSERT SUCCESS" : "INSERT FAIL");
				rsltList.add(rowVO);
			}
			commit();
			
			eventResponse.setRsVoList(rsltList);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMstCopNoDiff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce6000Event event = (EsdSce6000Event) e;
		SceAdminManageBC command = new SceAdminManageBCImpl();

		try {
			List<SceCopHdrVO> list = command.searchMstCopNoDiff(event.getSceAdminObjVO().getMstFmDt(), event.getSceAdminObjVO().getMstToDt());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCntrDiff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce6000Event event = (EsdSce6000Event) e;
		SceAdminManageBC command = new SceAdminManageBCImpl();

		try {
			List<CntrDiffVO> list = command.searchCntrDiff(event.getSceAdminObjVO().getCdiffFmDt(), event
					.getSceAdminObjVO().getCdiffToDt());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchActDatRcvIf(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce6000Event event = (EsdSce6000Event) e;
		SceAdminManageBC command = new SceAdminManageBCImpl();

		try {
			List<SceActRcvIfVO> list = command.searchActDatRcvIf(event.getSceAdminObjVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	private EventResponse modifyCntrAction(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce6000Event event = (EsdSce6000Event) e;
		BkgCopManageBC command = new BkgCopManageBCImpl();

		try {
			SceBkgOpHisVO[] tcs = event.getSceBkgOpHisVOs();
			if (tcs != null && tcs.length > 0) {
				for (int i = 0; i < tcs.length; i++) {
					SceBkgOpHisVO tc = tcs[i];
					begin();
					if (tc.getBkgEvntTpCd().equals(SCEConstants.CONTAINER_ATTACH)) {
						command.attachCntr(tc.getBkgNo(), tc.getCntrNo(), "");
					} else if (tc.getBkgEvntTpCd().equals(SCEConstants.CONTAINER_DETACH)) {
						command.detachCntr(tc.getBkgNo(), tc.getCntrNo(), "");
					}
					
					command.initializeSceActRcvIf(tc.getBkgNo(), tc.getCntrNo());
					
					commit();
				}
			}

			// eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLeaMonthlyWorkCandidate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce6000Event event = (EsdSce6000Event) e;
		SceAdminManageBC command = new SceAdminManageBCImpl();

		try {

			List<SearchLeaMonthlyWorkVO> leaVo = command.searchLeaMonthlyWorkCandidate(event);
			eventResponse.setRsVoList(leaVo);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse addCandidateSceCsrMntr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce6000Event event = (EsdSce6000Event)e;
		SceAdminManageBC command = new SceAdminManageBCImpl();

		try{
			List<SearchLeaMonthlyWorkVO> leaVo = command.searchLeaMonthlyWorkCandidate(event);
			
			begin();
			command.delSceCsrMntr();
			commit();
			
			for (int i = 0; i < leaVo.size(); i ++ ) {
				SearchLeaMonthlyWorkVO searchLeaMonthlyWorkVO = leaVo.get(i);
				begin();
				command.addCandidateSceCsrMntr(searchLeaMonthlyWorkVO);
				commit();
			}

		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse addSceMngRpln() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SceAdminManageBC command = new SceAdminManageBCImpl();
		List<SearchSceMnlRplnVO> searchSceMnlRplnVOs = null;
		
		try{
			
			searchSceMnlRplnVOs = command.searchSceMngRplnCandidate();
			
			for(int i=0; i<searchSceMnlRplnVOs.size(); i++){
				SearchSceMnlRplnVO searchSceMnlRplnVO = searchSceMnlRplnVOs.get(i);
				begin();
				command.addSceMngRpln(searchSceMnlRplnVO);
				commit();
			}
			eventResponse = (GeneralEventResponse) searchSceMngRpln();
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSceMngRpln() throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		SceAdminManageBC command = new SceAdminManageBCImpl();
		DBRowSet dSet = null;
		
		try {
			dSet = command.searchSceMngRpln();
			eventResponse.setRs(dSet);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
}