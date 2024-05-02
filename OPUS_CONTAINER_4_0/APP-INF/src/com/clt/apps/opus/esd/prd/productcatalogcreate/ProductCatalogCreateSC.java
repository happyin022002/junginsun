/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ProductCatalogCreateSC.java
 *@FileTitle : ProductCatalogCreate
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0 
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate;

import java.util.List;

import com.clt.apps.opus.esd.prd.common.PrdConstants;
import com.clt.apps.opus.esd.prd.common.prdcreate.basic.PrdCreateManageBC;
import com.clt.apps.opus.esd.prd.common.prdcreate.basic.PrdCreateManageBCImpl;
import com.clt.apps.opus.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.clt.apps.opus.esd.prd.common.productcatalogcreateverify.basic.ProductCatalogCreateVerifyBCImpl;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0082Event;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration.ProductCatalogCreateDBDAO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.ProductCatalogInternalMst_1VO;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.utility.CheckUtilities;

/**
 * ProductCatalogCreate Business Logic ServiceCommand - handling business transaction of ProductCatalogCreate
 * 
 * @author sun yong Jung
 * @see ProductCatalogCreateDBDAO
 * @since J2EE 1.6
 */

public class ProductCatalogCreateSC extends ServiceCommandSupport {
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario - ProductCatalogCreate system<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("ProductCatalogCreateSC Start");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * biz scenario closing - ProductCatalogCreate system<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("ProductCatalogCreateSC End");
	}

	/**
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		e.setAttribute("account", account);
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsdPrd0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = new GeneralEventResponse();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) || e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				this.checkMixedTerm(e);
				eventResponse = this.createPrdCtlgFullRout(e, e.getEventName());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchRouteInfoByPctlNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchEqInventory(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = this.checkEmptyPickUpYardValid(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = this.processReplaneFinish(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = this.productCatalogInquiryDtail(e);
			}
			// retrieving pc dtl
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0081Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchPrdCtlgFullRout(e);
			}
			// retrieving pc constraint
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0082Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchPrdConstraint(e);
			}
			// route validation check
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0083Event")) {
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = this.addValCheck(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // creating pc and retrieving MST
				eventResponse = this.createProductCatalogInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // retrieving DETAIL
				eventResponse = this.searchProductCatalogInquiryDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = this.searchCnstRemark(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.checkTpSz(e);
			}
		}
		return eventResponse;
	}

	/**
	 * changing Empty Pick Up Date
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchEqInventory(Event e) throws EventException {
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();

		eventResponse = productCatalogCreateBc.searchEqInventory(e);

		return eventResponse;
	}

	/**
	 * Constraint Remarking
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCnstRemark(Event e) throws EventException {
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
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		// String uiId = "UI_PRD-0080";
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();

		begin();
		int successFlg = productCatalogCreateBc.updateMainMapSeq(e);

		commit();

		begin();
		eventResponse = productCatalogCreateBc.processReplaneFinish(e);
		commit();
		if (successFlg == 0) {
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
		EsdPrd0082Event event = (EsdPrd0082Event) e;
		PrdSearchParamVO prdSearchParamVO = (PrdSearchParamVO) event.getPrdSearchParamVO();
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();

		eventResponse = productCatalogCreateBc.searchPrdConstraint(prdSearchParamVO.getPctlNo());

		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse addValCheck(Event e) throws EventException {
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			productCatalogCreateBc.addValCheck(e);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
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
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse = productCatalogCreateBc.searchRouteInfoByPctlNo(e);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return eventResponse;
	}

	/**
	 * handling url call for pc select screen of bkg. (first calling) <BR>
	 * There is no need to check the number after creation of pc because this method will be called when it has more than 1 pc.<BR>
	 * event which is handled mixed term change process
	 * 
	 * @param e
	 * @param eventName
	 * @return
	 * @throws EventException
	 */
	private EventResponse createPrdCtlgFullRout(Event e, String eventName) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		List<PrdPatternVO> list = null;
		PrdPcCreateVO prdPcCreateVO = null;
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();
		String cntrTpszQtyStr = "";
		try {
			/*
			 * creating PC and retrieving data of screen.
			 */
			begin();
			if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_REPLAN)) {
				cntrTpszQtyStr = productCatalogCreateBc.getReplanCntrTpszQty(prdCreateParamVO.getBkgNo(), event.getPrdQuantityVOs());
				prdCreateParamVO.setCntrTpszQtyStr(cntrTpszQtyStr);
				//productCatalogCreateBc.checkReplan(prdCreateParamVO);

				list = productCatalogCreateBc.getReplanePatternForMultiPrd(e);
				event.setAttribute("PATTERN_LIST", list);

				if (list != null && list.size() > 0) {
					log.debug("\n\n list != null--------------------" + "\n creating pc as prime pattern (ord= 1)");
					PrdPatternVO prdPatternVO = (PrdPatternVO) list.get(0);
					log.debug("\n\n prdPatternVO.getCopMapgSeq()" + prdPatternVO.getCopMapgSeq());
					prdCreateParamVO.setCopMapgSeq(prdPatternVO.getCopMapgSeq());
				} else {
					throw new EventException(new ErrorHandler("PRD00062").getMessage());
				}
			}
			productCatalogCreateBc.createPrdCtlgFullRout(e);
			prdPcCreateVO = event.getPrdPcCreateVO();

			log.debug("\npc min:" + prdPcCreateVO.getMinPctlNo());
			log.debug("\npc max:" + prdPcCreateVO.getMaxPctlNo());
			createCostAssignPrd(prdPcCreateVO.getMinPctlNo(), prdPcCreateVO.getMaxPctlNo(), account.getUsr_id());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("\n EventException err " + ex.toString(), ex);
			if (ex.getMessage().contains((new ErrorHandler("PRD00074")).getMessage()) && prdCreateParamVO.getMoreCnt().equals("1")) {
				eventResponse = new GeneralEventResponse();
				event.setAttribute("prdPatternVO", event.getAttribute("prdPatternVO"));
				String verifyMessage = new ErrorHandler("PRD00082").getUserMessage().replaceAll("\\\\n", "\n");
				eventResponse.setUserMessage(verifyMessage);
				return eventResponse;
			} else if (ex.getMessage().contains((new ErrorHandler("PRD00074")).getMessage()) && prdCreateParamVO.getMoreCnt().equals("2")) {
				eventResponse = new GeneralEventResponse();
				event.setAttribute("prdPatternVO", event.getAttribute("prdPatternVO"));
				String verifyMessage = new ErrorHandler("PRD00083").getUserMessage().replaceAll("\\\\n", "\n");
				eventResponse.setUserMessage(verifyMessage);
				return eventResponse;

			} else if (ex.getMessage().contains((new ErrorHandler("PRD00074")).getMessage())) {
				log.debug("\n\n pc creation fail");
				eventResponse = new GeneralEventResponse();
				event.setAttribute("prdPatternVO", event.getAttribute("prdPatternVO"));
				if (!eventName.equals("EsdPrd0080Event")) {
					String verifyMessage = new ProductCatalogCreateVerifyBCImpl().getPcVerify(event, event.getPrdCreateParamVO(), event.getPrdPcCreateVO(), (PrdPatternVO) event.getAttribute("prdPatternVO"));
					eventResponse.setUserMessage(verifyMessage);
				} else {
					eventResponse.setUserMessage(new ErrorHandler("PRD00084").getUserMessage().replaceAll("\\\\n", "\n"));
				}
				return eventResponse;
			} else if (ex.getMessage().contains("PSEUDO VVD")) {
				eventResponse.setUserMessage(ex.getMessage());
				return eventResponse;
			}
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("\n Exception err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		try {
			eventResponse = productCatalogCreateBc.selectPrdRoutUnit(e);
			String returnStr = productCatalogCreateBc.selectReturnStrToBkg(prdPcCreateVO.getMinPctlNo());
			eventResponse.setETCData("returnStr", returnStr);
			eventResponse.setETCData("map_seq", prdCreateParamVO.getCopMapgSeq());
			eventResponse.setETCData("ldd", prdCreateParamVO.getLdDt());
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
	 * @param minPctlNo
	 * @param maxPctlNo
	 * @param usr_id
	 * @throws EventException
	 */
	private void createCostAssignPrd(String minPctlNo, String maxPctlNo, String usr_id) throws EventException {
		CostAssignBC costCommand = new CostAssignBCImpl();
		try {
			costCommand.createCostAssignPrd(minPctlNo, maxPctlNo, usr_id);
		} catch (EventException ex) {
			// TODO Auto-generated catch block
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 
	 * ESD_PRD_0080 : [Event]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createProductCatalogInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();

		EsdPrd0080Event event = (EsdPrd0080Event) e;
		event.getPrdCreateParamVO().setInternalSkdType("L");
		try {
			// pc creation ---------------------------------------------------------------------------
			productCatalogCreateBc.createPrdCtlgFullRout(event);
			// cost creation ---------------------------------------------------------------------------
			createCostAssignPrd(event.getPrdPcCreateVO().getMinPctlNo(), event.getPrdPcCreateVO().getMaxPctlNo(), ((SignOnUserAccount) event.getAttribute("account")).getUsr_id());
			DBRowSet rowset = new ProductCatalogCreateBCImpl().createProductCatalogInquiry(event);
			eventResponse.setRsVoList(RowSetUtil.rowSetToVOs(rowset, ProductCatalogInternalMst_1VO.class));
		} catch (EventException ex) {
			if (ex.getMessage().contains((new ErrorHandler("PRD00074")).getMessage())) {
				PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
				PrdPcCreateVO prdPcCreateVO = event.getPrdPcCreateVO();
				if (prdCreateParamVO == null || prdPcCreateVO == null) {
					log.debug("\n noh prdCreateParamVO is :" + (prdCreateParamVO == null));
					log.debug("\n noh prdPcCreateVO is :" + (prdPcCreateVO == null));
					throw new EventException(ex.getMessage(), ex);
				} else {
					if (CheckUtilities.isInBlank(prdCreateParamVO.getPol())) {
						log.debug("\n noh pol is white space :" + prdCreateParamVO.getPol());
						throw new EventException(ex.getMessage(), ex);
					}
				}
				String verifyMessage = new ProductCatalogCreateVerifyBCImpl().getPcVerify(event, prdCreateParamVO, prdPcCreateVO, null);
				log.debug("\n noh verifyMessage \n" + verifyMessage);
				eventResponse.setUserMessage(verifyMessage);
				return eventResponse;
			} else {
				throw ex;
			}
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

		// TODO delete noh
	}

	/**
	 * ESD_PRD_0020 : [Event]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchProductCatalogInquiryDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ProductCatalogCreateBC productCatalogCreateBC = new ProductCatalogCreateBCImpl();
		try {
			eventResponse.setRsVoList(productCatalogCreateBC.searchProductCatalogInquiryDetail(e));
			// eventResponse.setETCData("in_land_cut_off", productCatalogCreateBC.searchInlandCutOffTime(e));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * handling Mixed Term defining [R Term] or [D Term]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private void checkMixedTerm(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		PrdCreateManageBC pcCommand = new PrdCreateManageBCImpl();
		String rTerm = event.getPrdCreateParamVO().getRcvT();
		String dTerm = event.getPrdCreateParamVO().getDelT();
		String returnTerm = "";

		log.debug("\n\n checkMixedTerm rTerm:" + rTerm);
		log.debug("\n\n checkMixedTerm dTerm:" + dTerm);
		String por = event.getPrdCreateParamVO().getPor();
		String del = event.getPrdCreateParamVO().getDel();
		String bkgNo = event.getPrdCreateParamVO().getBkgNo();

		try {
			event.getPrdCreateParamVO().setBkgRcvT(rTerm);
			event.getPrdCreateParamVO().setRcvT(pcCommand.checkMixedRterm(bkgNo, por, rTerm));
			if (rTerm != null && (rTerm.equals("M"))) {
				returnTerm = pcCommand.checkMixedTermYard(event.getPrdCreateParamVO().getRcvT(), event.getPrdCreateParamVO().getPorN());
				if (returnTerm.equals("N")) {
					event.getPrdCreateParamVO().setPorN("");
				}
			}
			event.getPrdCreateParamVO().setBkgDelT(dTerm);
			event.getPrdCreateParamVO().setDelT(pcCommand.checkMixedDterm(bkgNo, del, dTerm));
			if (dTerm != null && (dTerm.equals("M"))) {
				returnTerm = pcCommand.checkMixedTermYard(event.getPrdCreateParamVO().getDelT(), event.getPrdCreateParamVO().getDelN());
				if (returnTerm.equals("N")) {
					event.getPrdCreateParamVO().setDelN("");
				}
			}
			rTerm = event.getPrdCreateParamVO().getRcvT();
			dTerm = event.getPrdCreateParamVO().getDelT();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkEmptyPickUpYardValid(Event e) throws EventException {
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();
		try {
			String ydUseFlg = productCatalogCreateBc.checkEmptyPickUpYardValid(e);
			eventResponse.setETCData("yd_use_flg", ydUseFlg);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * Constraint Remarking
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkTpSz(Event e) throws EventException {
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		e.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setETCData("is_exis_flg", productCatalogCreateBc.checkTpSz(e));
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse productCatalogInquiryDtail(Event e) throws EventException {
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		EventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse = productCatalogCreateBc.selectPrdRoutUnit(e);
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