/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SceAdminManageSC.java
*@FileTitle : SCE Admin
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.sceadminmanage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.clt.apps.opus.esd.sce.common.SCEConstants;
import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.basic.SceAdminManageBC;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.basic.SceAdminManageBCImpl;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.event.EsdSce6000Event;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.integration.SceAdminManageDBDAO;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.vo.CntrDiffVO;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.vo.ManRplnRsltVO;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.vo.SceAdminObjVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SceActTmlIfVO;
import com.clt.syscommon.common.table.SceBkgOpHisVO;
import com.clt.syscommon.common.table.SceCopHdrVO;


/**
 * SceAdminManage Business Logic ServiceCommand - SceAdminManage to handle a business transaction.
 * 
 * @author 
 * @see SceAdminManageDBDAO
 * @since J2EE 1.6
 */

public class SceAdminManageSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * SceAdminManage system business scenarios Predecessors<br>
	 * Business scenarios related internal object creation during calls<br>
	 */
	public void doStart() {
		log.debug("SceAdminManageSC Start");
		try {
			//  comment --> Log in Check part
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SceAdminManage business scenarios and finishing<br>
	 * Released at the end of business scenarios related internal objects<br>
	 */
	public void doEnd() {
		log.debug("SceAdminManageSC End");
	}

	/**
	 * Perform tasks that correspond to each event scenario<br>
	 * SceAdminManage system of a quarter of all the events that occur in business processing<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// If the SC is used to handle multiple events that need to be
		if (e.getEventName().equalsIgnoreCase("EsdSce6000Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTmlChgRslt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifyActTimIfSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRplnCops(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = replanManual(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMstCopNoDiff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCntrDiff(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
			
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchActDatRcvIf(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = modifyCntrAction(e);
			}  
		}
		return eventResponse;
	}
	/**
	 * ESD_SCE_6000 : [Events]<br>
	 * [Business target]to [Act] is.<br>
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
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce6000Event event = (EsdSce6000Event) e;
		SceAdminManageBC manBC = new SceAdminManageBCImpl();

		List<ManRplnRsltVO> rsltList = new ArrayList<ManRplnRsltVO>();

		try {
			ManRplnRsltVO[] tcs = event.getManRplnRsltVOs();
			if (tcs != null && tcs.length > 0) {
				for (int i = 0; i < tcs.length; i++) {

					ManRplnRsltVO tc = tcs[i];
					if (tc.getCopNo() == null || tc.getCopNo().equals("")) {
						continue;
					} 
					SceAdminObjVO sceAdminObjVO = new SceAdminObjVO();
					sceAdminObjVO.setRplnCopNo(tc.getCopNo());
					List<SceCopHdrVO> tmpList = manBC.searchRplnCops(sceAdminObjVO);

					begin();
					rsltList.add(replanManual2(tc, tmpList));
					commit();
				}
			}
			eventResponse.setRsVoList(rsltList);
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
	 * @param ManRplnRsltVO tc
	 * @param List<SceCopHdrVO> tmpList
	 * @return ManRplnRsltVO
	 */
	private ManRplnRsltVO replanManual2(ManRplnRsltVO tc, List<SceCopHdrVO> tmpList) {
		ReplanManageBC replanManageBC = new ReplanManageBCImpl();
		ProductCatalogCreateBC prdBC = new ProductCatalogCreateBCImpl();
		SceAdminManageBC manBC = new SceAdminManageBCImpl();

		ManRplnRsltVO rowVO = new ManRplnRsltVO();
		Set<String> bkgNoSet = new HashSet<String> ();
		SceCopHdrVO tmp = new SceCopHdrVO();
		try {
			if (tmpList != null && tmpList.size() == 1) {
				tmp = tmpList.get(0);
				tc.setMstCopNo(tmp.getMstCopNo());
				tc.setBkgNo(tmp.getBkgNo());
				tc.setCntrNo(tmp.getCntrNo());
				
				SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
				String pctl_no = tc.getPctlNo(); // Default you have that subject on the screen
			
				if (tc.getRegenPc().equals("1")) { // If regen regenerate pctl_no
					if (tc.getBkgInfo().equals("1")) {
						pctl_no = prdBC.createSceSoReplanByBkgInfo(tc.getCopNo(), "T", "manRpln");
					} else {
						pctl_no = prdBC.createSceSoReplan(tc.getCopNo(), "T", "manRpln");	
					}
				} 
				
				if (!tc.getRegenPc().equals("1") && (tc.getPctlNo() == null || tc.getPctlNo().equals(""))) { // Pc_no be recreated on the screen but comes into its history replan
					// 재생성이 아니고 화면에 PC 가 입력 된 값이 없을 경우
					pctl_no = tmp.getPctlNo();
				}
				
				sceCopHdrVO.setPctlNo(pctl_no);
				sceCopHdrVO.setCopNo(tc.getCopNo());
				sceCopHdrVO.setMstCopNo(tc.getMstCopNo());
				sceCopHdrVO.setBkgNo(tc.getBkgNo());
				sceCopHdrVO.setCntrNo(tc.getCntrNo());
				
				boolean rslt = replanManageBC.replanCop(sceCopHdrVO, "MnlRplnByUI");

				ObjectCloner.build(tc, rowVO);
				rowVO.setPctlNo(pctl_no);
				rowVO.setRplnRslt(rslt ? "SUCCESS" : "FAIL");
				if (rowVO.getRplnRslt().equals("SUCCESS")) {
					bkgNoSet.add(tc.getBkgNo());
				}
			} else {
				ObjectCloner.build(tc, rowVO);
				rowVO.setRplnRslt("NOT EXIST IN COP HEADER");
			}
		
			// bkg set 에 대해서 COA 의 일배치 대상으로 insert
			if (bkgNoSet.size() >= 1)
				manBC.interfaceCoaDailyBtch(bkgNoSet);
		} catch(Exception ee) {
			rollback();
			log.error("FAIL replan : " + ee.toString(), ee);
			ObjectCloner.build(tc, rowVO);
			rowVO.setRplnRslt("FAIL");
		}
		
		return rowVO;
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
}