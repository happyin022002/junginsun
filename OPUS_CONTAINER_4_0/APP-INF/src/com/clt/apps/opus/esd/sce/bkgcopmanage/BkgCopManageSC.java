/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BkgCopManageMainSC.java
 *@FileTitle : Bkg Cop Manage Admin
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.event.EsdSce9998Event;
import com.clt.apps.opus.esd.sce.bkgcopmanage.event.EsdSce9999Event;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.BkgCopManageVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.CntrDiffVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.ManRplnRsltVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.SceActTmlRtvVO;
import com.clt.apps.opus.esd.sce.common.SCEConstants;
import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.basic.VskEmailSendBC;
import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.basic.VskEmailSendBCImpl;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PrdBkgCopMapVO;
import com.clt.syscommon.common.table.SceBkgOpHisVO;
import com.clt.syscommon.common.table.SceCopHdrVO;

/**
 * BkgCopManageMain Business Logic ServiceCommand to handle a business transaction.
 * 
 * @author 
 * @see BkgCopManageMainDBDAO
 * @since J2EE 1.6
 */

public class BkgCopManageSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	private transient ProductCatalogCreateBC prdBC = null;
	private transient ReplanManageBC replanManageBC = null;
	
	/**
	 * Preceding the business scenario of SetupManagement system<br>
	 * Creating the related objects<br>
	 */
	public void doStart() {
		log.debug("BkgCopManageMainSC Start");

		prdBC = new ProductCatalogCreateBCImpl();
		replanManageBC = new ReplanManageBCImpl();
		try {
			//  comment --> Log in Check part
			account = getSignOnUserAccount();

		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Closing the business scenario of SetupManagement system<br>
	 * Clearing the related objects<br>
	 */
	public void doEnd() {
		log.debug("BkgCopManageMainSC End");
	}

	/**
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsdSce9998Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // booking
				// creation
				eventResponse = createBkg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // booking
				// update
				// (booking
				// replan)
				eventResponse = updateBkg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // booking
				// split
				eventResponse = splitBkg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { // booking
				// combine
				eventResponse = combineBkg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) { // booking
				// cancel
				eventResponse = cancelBkg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) { // tro
				// confirm
				eventResponse = confirmTro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) { // tro
				// unconfirm
				eventResponse = unconfirmTro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI08)) { // confirm
				// container
				eventResponse = confirmCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI09)) { // attach
				// container
				eventResponse = attachCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI10)) { // detach
				// container
				eventResponse = detachCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI11)) { // move
				// container
				eventResponse = moveCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) { // replan
				eventResponse = updateBkg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI13)) { // tro
				// confirm
				eventResponse = confirmTro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI14)) { // tro
				// unconfirm
				eventResponse = unconfirmTro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI15)) { // tro
				// unconfirm
				eventResponse = confirmCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI16)) { // S/O
				VskEmailSendBC tmpBc = new VskEmailSendBCImpl();
				begin();
				tmpBc.sendVslSkdEmail("VSK_LANE_PORT");
				commit();
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdSce9999Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // booking
				// creation
				eventResponse = searchActTmlIfDtl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // CopReplan
				// Fail
				 eventResponse = updateBkg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // MST_COP_NO
				// Diff
				eventResponse = searchMstCopNoDiff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { // Cntr_diff
				eventResponse = searchCntrDiff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) { // booking
				// cancel
				eventResponse = cancelBkg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) { // container
				// attach
				// /
				// detach
				eventResponse = modifyCntrAction(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) { // terminal
				// change
				eventResponse = replanTerminalChange(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI08)) { // manual
				// replan
				eventResponse = replanManual(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI09)) { // preset
				eventResponse = presetBfReplan(e);
			}
		}
		return eventResponse;
	}

	/**
	 * Booking replan generates to manual.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse updateBkg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9998Event event = (EsdSce9998Event) e;
		BkgCopManageBC command = new BkgCopManageBCImpl();

		try {
			BkgCopManageVO bkgCopManageVO = event.getBkgCopManageVO();
			PrdBkgCopMapVO prdBkgCopMapVO = new PrdBkgCopMapVO();

			String bkg_no = bkgCopManageVO.getBkgNo();
			String cntr_no = bkgCopManageVO.getCntrNo();
			String pctl_no = bkgCopManageVO.getPctlNo();
			String cop_no = bkgCopManageVO.getCopNo();

			prdBkgCopMapVO.setBkgNo(bkg_no);
			prdBkgCopMapVO.setCntrNo(cntr_no);
			prdBkgCopMapVO.setPctlNo(pctl_no);
			prdBkgCopMapVO.setCopNo(cop_no);
			prdBkgCopMapVO.setCntrTpszCd(bkgCopManageVO.getCntrTpszCd());

			command.updateBkg(prdBkgCopMapVO);
			// eventResponse.setRsVoList(list);
			// }catch(EventException ex){
			// log.error("err " + ex.toString(), ex);
			// throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * Caused by a manual booking split
	 * @param e 
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse splitBkg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9998Event event = (EsdSce9998Event) e;
		BkgCopManageBC command = new BkgCopManageBCImpl();

		try {
			BkgCopManageVO bkgCopManageVO = event.getBkgCopManageVO();
			command.splitBkg(bkgCopManageVO.getBkgNo(), transStrToArray(bkgCopManageVO.getTgtBkgNos(), ","));
			// eventResponse.setRsVoList(list);
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
	 * booking combine to create a manual
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse combineBkg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsdSce9998Event event = (EsdSce9998Event) e;
//		BkgCopManageBC command = new BkgCopManageBCImpl();

		// try{
//		BkgCopManageVO bkgCopManageVO = event.getBkgCopManageVO();
		// command.combineBkg(transStrToArray(bkgCopManageVO.getTgtBkgNos(),
		// ","), bkgCopManageVO.getBkgNo());
		// eventResponse.setRsVoList(list);
		// }catch(EventException ex){
		// log.error("err " + ex.toString(), ex);
		// throw new EventException(new ErrorHandler(ex).getMessage());
		// }catch(Exception ex){
		// log.error("err " + ex.toString(), ex);
		// throw new EventException(new ErrorHandler(ex).getMessage());
		// }
		return eventResponse;
	}

	/**
	 * Caused Container move to manual
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse moveCntr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9998Event event = (EsdSce9998Event) e;
		BkgCopManageBC command = new BkgCopManageBCImpl();

		try {
			BkgCopManageVO bkgCopManageVO = event.getBkgCopManageVO();
			command.moveCntr(bkgCopManageVO.getBkgNo(), transStrToArray(bkgCopManageVO.getTgtBkgNos(), ","),
					bkgCopManageVO.getCntrNo());
			// eventResponse.setRsVoList(list);
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
	 * Caused by manual container detach
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse detachCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9998Event event = (EsdSce9998Event) e;
		BkgCopManageBC command = new BkgCopManageBCImpl();

		try {
			BkgCopManageVO bkgCopManageVO = event.getBkgCopManageVO();
			command.detachCntr(bkgCopManageVO.getBkgNo(), bkgCopManageVO.getCntrNo(), bkgCopManageVO.getFlgPartial());
			// eventResponse.setRsVoList(list);
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
	 * Caused container attach to manual
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse attachCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9998Event event = (EsdSce9998Event) e;
		BkgCopManageBC command = new BkgCopManageBCImpl();

		try {
			BkgCopManageVO bkgCopManageVO = event.getBkgCopManageVO();
			command.attachCntr(bkgCopManageVO.getBkgNo(), bkgCopManageVO.getCntrNo(), bkgCopManageVO.getFlgPartial());
			// eventResponse.setRsVoList(list);
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
	 * Caused container confirm to Manual
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse confirmCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9998Event event = (EsdSce9998Event) e;
		BkgCopManageBC command = new BkgCopManageBCImpl();

		try {
			BkgCopManageVO bkgCopManageVO = event.getBkgCopManageVO();
			command.confirmCntr(bkgCopManageVO.getBkgNo());
			// eventResponse.setRsVoList(list);
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
	 * Caused by manual unconfirm TRO
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse unconfirmTro(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9998Event event = (EsdSce9998Event) e;
		BkgCopManageBC command = new BkgCopManageBCImpl();

		try {
			BkgCopManageVO bkgCopManageVO = event.getBkgCopManageVO();
			command.unconfirmTro(bkgCopManageVO.getBkgNo(), bkgCopManageVO.getTroSeq(), bkgCopManageVO.getTroSubSeq(),
					bkgCopManageVO.getTroBndCd());
			// eventResponse.setRsVoList(list);
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
	 * Caused by manual confirm TRO
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse confirmTro(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsdSce9998Event event = (EsdSce9998Event) e;
		BkgCopManageBC command = new BkgCopManageBCImpl();
		String bkg_no = "";
		String tro_seq = "";
		String tro_sub_seq = "";
		String tro_bnd_cd = "";
		String conti_cd = "";
		try {
//			BkgCopManageVO bkgCopManageVO = event.getBkgCopManageVO();
//			 command.confirmTro(bkgCopManageVO.getBkgNo(),
//			 bkgCopManageVO.getTroSeq(), bkgCopManageVO.getTroSubSeq(),
//			 bkgCopManageVO.getTroBndCd(), bkgCopManageVO.getContiCd());

			 command.confirmTro(bkg_no, tro_seq, tro_sub_seq,
			 tro_bnd_cd, "", conti_cd);

//			 eventResponse.setRsVoList(list);
			 }catch(EventException ex){
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * Caused by Manual booking create event
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9998Event event = (EsdSce9998Event) e;
		BkgCopManageBC command = new BkgCopManageBCImpl();

		try {
			BkgCopManageVO bkgCopManageVO = event.getBkgCopManageVO();
			command.createBkg(bkgCopManageVO.getBkgNo(), bkgCopManageVO.getPctlNo());
			// eventResponse.setRsVoList(list);
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
	 * Caused by a manual cancel bkg 
	 * @param Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelBkg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9998Event event = (EsdSce9998Event) e;
		BkgCopManageBC command = new BkgCopManageBCImpl();

		try {
			BkgCopManageVO bkgCopManageVO = event.getBkgCopManageVO();
			command.cancelBkg(bkgCopManageVO.getBkgNo());
			// eventResponse.setRsVoList(list);
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
	 * Query results are terminal change.
	 * @param Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActTmlIfDtl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9999Event event = (EsdSce9999Event) e;
		BkgCopManageBC command = new BkgCopManageBCImpl();

		try {
			List<SceActTmlRtvVO> list = command.searchActTmlIfDtl(event.getBkgCopManageVO().getFmDt(), event
					.getBkgCopManageVO().getToDt());
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
	 * master cop no administrative problems are viewed and see if there is data to be. 
	 * @param Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMstCopNoDiff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9999Event event = (EsdSce9999Event) e;
		BkgCopManageBC command = new BkgCopManageBCImpl();

		try {
			List<SceCopHdrVO> list = command.searchMstCopNoDiff(event.getBkgCopManageVO().getFmDt(), event
					.getBkgCopManageVO().getToDt());
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
	 * container attach / detach not performed properly diff between booking and the cop is looking to see if there is information about the query.
	 * @param Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrDiff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9999Event event = (EsdSce9999Event) e;
		BkgCopManageBC command = new BkgCopManageBCImpl();

		try {
			List<CntrDiffVO> list = command.searchCntrDiff(event.getBkgCopManageVO().getFmDt(), event
					.getBkgCopManageVO().getToDt());
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
	 * container attach / detach operations to perform batch.
	 * @param Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCntrAction(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9999Event event = (EsdSce9999Event) e;

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
	 * Terminal Change occurs as a manual.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse replanTerminalChange(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9999Event event = (EsdSce9999Event) e;

//		ReplanManageBC command = new ReplanManageBCImpl();

		try {
			SceActTmlRtvVO[] tcs = event.getSceActTmlIfDtlVOs();
			if (tcs != null && tcs.length > 0) {
				for (int i = 0; i < tcs.length; i++) {
					SceActTmlRtvVO tc = tcs[i];

					SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();

					// if
					// (tc.getBkgEvntTpCd().equals(SCEConstants.CONTAINER_ATTACH))
					// {
					// command.attachCntr(tc.getBkgNo(), tc.getCntrNo(), "");
					// } else if
					// (tc.getBkgEvntTpCd().equals(SCEConstants.CONTAINER_DETACH))
					// {
					// command.detachCntr(tc.getBkgNo(), tc.getCntrNo(), "");
					// }
					String pctl_no = prdBC.createSceSoReplan(tc.getCopNo(), "T", "manRpln");
					if (pctl_no != null && !pctl_no.equals("")) {
						sceCopHdrVO.setPctlNo(pctl_no);
						sceCopHdrVO.setBkgNo(tc.getBkgNo());
						sceCopHdrVO.setCntrNo(tc.getCntrNo());
						sceCopHdrVO.setCopNo(tc.getCopNo());

						replanManageBC.replanCop(sceCopHdrVO, "MnlTmlChg");
					}
				}
			}
			// eventResponse.setRsVoList(list);
			// }catch(EventException ex){
			// log.error("err " + ex.toString(), ex);
			// throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESD_SCE_9999 on the screen caused by manual handling should replan.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse replanManual(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9999Event event = (EsdSce9999Event) e;
		BkgCopManageBC manBC = new BkgCopManageBCImpl();
		// ReplanManageBC command = new ReplanManageBCImpl();

		List<ManRplnRsltVO> rsltList = new ArrayList<ManRplnRsltVO>();
		
		Set<String> bkgNoSet = new HashSet<String> ();

		try {
			ManRplnRsltVO[] tcs = event.getManRplnRsltVOs();
			if (tcs != null && tcs.length > 0) {
				for (int i = 0; i < tcs.length; i++) {
					ManRplnRsltVO rowVO = new ManRplnRsltVO();

					ManRplnRsltVO tc = tcs[i];
					if (tc.getCopNo() == null || tc.getCopNo().equals("")) {
						continue;
					} 
					ManRplnRsltVO tmp = manBC.searchPresetBfRpln(tc.getCopNo());
//						tc.setPctlNo(tmp.getPctlNo());
					tc.setMstCopNo(tmp.getMstCopNo());
					tc.setBkgNo(tmp.getBkgNo());
					
					tc.setCntrNo(tmp.getCntrNo());
					
					SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
					String pctl_no = tc.getPctlNo(); // Default sore subject on the screen

					if (tc.getRegenPc().equals("1")) { // If regen regenerate pctl_no
//						pctl_no = prdBC.createSceSoReplan(tc.getCopNo(), "T", "manRpln");
						
						if (tc.getBkgInfo().equals("1")) {
							pctl_no = prdBC.createSceSoReplanByBkgInfo(tc.getCopNo(), "T", "manRpln");
						} else {
							pctl_no = prdBC.createSceSoReplan(tc.getCopNo(), "T", "manRpln");	
						}
					} 
					
					if (!tc.getRegenPc().equals("1") && (tc.getPctlNo() == null || tc.getPctlNo().equals(""))) { // 재생성이 아니고 pc_no 가 화면에서 들어오면 해당 내역으로 replan
						// To be recreated on the screen but the PC if no value is entered
						pctl_no = tmp.getPctlNo();
					} 
					
//					if (tc.getPctlNo() == null || tc.getPctlNo().equals("")) {
//						continue;
//					}
					
					sceCopHdrVO.setPctlNo(pctl_no);
					sceCopHdrVO.setCopNo(tc.getCopNo());
					sceCopHdrVO.setMstCopNo(tc.getMstCopNo());
					sceCopHdrVO.setBkgNo(tc.getBkgNo());
					sceCopHdrVO.setCntrNo(tc.getCntrNo());
					
					boolean rslt = replanManageBC.replanCop(sceCopHdrVO, "MnlRplnByUI");

					ObjectCloner.build(tc, rowVO);

					rowVO.setPctlNo(pctl_no);

					rowVO.setRplnRslt(rslt ? "SUCCESS" : "FAIL");
					
					if (rowVO.getRplnRslt().equals("SUCCESS"))
						bkgNoSet.add(tc.getBkgNo());

					rsltList.add(rowVO);
				}
				
				// bkg set 에 대해서 COA 의 일배치 대상으로 insert
				if (bkgNoSet.size() >= 1)
					manBC.interfaceCoaDailyBtch(bkgNoSet);
				
			}
			eventResponse.setRsVoList(rsltList);
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
	 * manual replan ago pctl no, mst_cop_no, bkg_no and pre-viewed.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse presetBfReplan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce9999Event event = (EsdSce9999Event) e;
		BkgCopManageBC manBC = new BkgCopManageBCImpl();
		// ReplanManageBC command = new ReplanManageBCImpl();

		List<ManRplnRsltVO> rsltList = new ArrayList<ManRplnRsltVO>();

		try {
			ManRplnRsltVO[] tcs = event.getManRplnRsltVOs();
			if (tcs != null && tcs.length > 0) {
				for (int i = 0; i < tcs.length; i++) {
					ManRplnRsltVO tc = tcs[i];
					if (tc.getCopNo() == null || tc.getCopNo().equals("")) {
						continue;
					} else {
						ManRplnRsltVO tmp = manBC.searchPresetBfRpln(tc.getCopNo());
						tc.setPctlNo(tmp.getPctlNo());
						tc.setMstCopNo(tmp.getMstCopNo());
						tc.setBkgNo(tmp.getBkgNo());
					}

					rsltList.add(tc);
				}
			}
			eventResponse.setRsVoList(rsltList);
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
	 * str, delim separated by a split is reconfigured as a String array.
	 * @param str
	 * @param delim
	 * @return String[]
	 */
	private String[] transStrToArray(String str, String delim) {
		StringTokenizer tk = new StringTokenizer(str, delim);
		String[] rtnAry = new String[tk.countTokens()];

		int i = 0;
		while (tk.hasMoreTokens()) {
			rtnAry[i++] = (String) tk.nextToken();
		}

		return rtnAry;

	}

}