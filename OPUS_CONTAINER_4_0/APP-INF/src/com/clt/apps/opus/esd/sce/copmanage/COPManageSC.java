/*=========================================================
 *Copyright(c) 20006 CyberLogitec
 *@FileName : COPManageSC.java
 *@FileTitle : COP Main Search
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage;

import java.util.List;

import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.clt.apps.opus.esd.sce.common.SCEConstants;
import com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC;
import com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.basic.COPSearchBC;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.basic.COPSearchBCImpl;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.event.EsdSce0001Event;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.event.EsdSce0006Event;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.event.EsdSce0009Event;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.event.EsdSce0118Event;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.event.EsdSce0915Event;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.BookingInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPReplanInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchCOPMainListVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchSceCopHdrInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchTargetCOPInfoListVO;
import com.clt.apps.opus.esd.sce.copmanage.copupdate.basic.COPUpdateBC;
import com.clt.apps.opus.esd.sce.copmanage.copupdate.basic.COPUpdateBCImpl;
import com.clt.apps.opus.esd.sce.copmanage.copupdate.vo.COPUpdateInfoVO;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SceCopHdrVO;

/**
 * SCE Business Logic ServiceCommand<br>
 * handling business transaction<br>
 * 
 * @author Seong-mun Kang
 * @see EsdSce0001EventResponse , COPSearchDBDAO
 * @since J2EE 1.4
 */
public class COPManageSC extends ServiceCommandSupport {
	private SignOnUserAccount account = null;
	/**
	 * preceding process for biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("Error related objects creation(COPManageSC) " + e.toString(), e);
		}
	}

	/**
	 * SCE biz scenario closing<br>
	 * COPManage - clearing related objects<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("COPManageSC Closing");
	}

	/**0
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException ...
	 */
	public EventResponse perform(Event e) throws EventException {

		EventResponse eventResponse = null;

		log.debug("\n EventName : " + e.getEventName());

		// NEW COP Inquiry + COP Main Search
		if (e.getEventName().equalsIgnoreCase("EsdSce0001Event")) {
			log.debug("\n SC..NEW COP Inquiry ");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				log.debug("\n SC..NEW COP Inquiry..SEARCHLIST ");
				eventResponse = searchCOPMainList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyCOPStatusChange(e); // Status Change
			}
		}

		// COP Detail Search
		else if (e.getEventName().equalsIgnoreCase("EsdSce0006Event")) {

			// EsdSce0006Event event = (EsdSce0006Event)e ;
			// COP Booking Search
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchBookingList(e);
			}
			// COP Detail Search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) || e.getFormCommand().isCommand(FormCommand.SEARCHLIST02) || e.getFormCommand().isCommand(FormCommand.SEARCHLIST03) || e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {

				eventResponse = searchCOPDetail(e);

			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyCOPDetailEstmActDT(e);
			} else {
				eventResponse = searchBookingList(e);
			}

		}

		// BKG Info Search
		else if (e.getEventName().equalsIgnoreCase("EsdSce0915Event")) {
			eventResponse = searchBookingDetail(e);
		}

		// searchTargetCOPInfoList Search
		else if (e.getEventName().equalsIgnoreCase("EsdSce0009Event")) {
			// 1. setting DEFAULT at 0006 or 002
			// 2. setting SEARCHLIST after 0009 loading
			// 3. setting MULTI01 in case of Click

			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {// Apply Click
				//
				log.debug("\n usr id : " + account.getUsr_id());
				eventResponse = addCOPReplan(e, account.getUsr_id());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {// 0009 Search
				eventResponse = searchTargetCOPInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {// 0009 Search
				eventResponse = searchTargetPCInfoList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0118Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSceCopHdrInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSCInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifyPCopHdr(e);

			}
		} 
		return eventResponse;
	}

	/*********************************************************************************/

	/**
	 * NEW COP Inquiry<br>
	 * retrieving COP Main Data<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCOPMainList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0001Event event = (EsdSce0001Event) e;
		List<SearchCOPMainListVO> list = null;

		try {
			COPSearchBC command = new COPSearchBCImpl();
			list = command.searchCOPMainList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving Master COP
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException ...
	 */
	public EventResponse searchSceCopHdrInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0118Event event = (EsdSce0118Event) e;
		COPSearchBC command = new COPSearchBCImpl();
		List<SearchSceCopHdrInfoVO> list = null;

		try {
			list = command.searchSceCopHdrInfo(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving Search Master S/O
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException ...
	 */
	public EventResponse searchSCInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0118Event event = (EsdSce0118Event) e;
		CodeUtilBC utilBc = new CodeUtilBCImpl();
		COPSearchBC command = new COPSearchBCImpl();
		ReplanManageBC replanCommand = new ReplanManageBCImpl();

		int retVal = SCEConstants.MST_FAIL;
		try {

			begin();
			COPInquiryVO inqVO = event.getConditionVO();
			if (inqVO.getOldCopNo() != null && inqVO.getOldCopNo().length() > 0) {

				log.debug("\n  fromCopNo:" + inqVO.getOldCopNo() + "    newCopNo:" + inqVO.getNewCopNo());
				retVal = replanCommand.moveMstFlg(inqVO.getOldCopNo(), inqVO.getNewCopNo()); // S/O Auto Change Logic
			}

			event.getConditionVO().setBkgEventTpCd("LC");
			if (SCEConstants.MST_SUCCESS == retVal) {
				String ofcCode = e.getSignOnUserAccount() == null ? "SysMan" : e.getSignOnUserAccount().getOfc_cd();
				String usr_id = e.getSignOnUserAccount() == null ? "SysMan" : e.getSignOnUserAccount().getUsr_id();
				utilBc.addSceCopHistory(inqVO.getNewCopNo(), "LC", ofcCode, usr_id, "N");
				utilBc.addSceCopHistory(inqVO.getOldCopNo(), "RC", ofcCode, usr_id, "N");
			}

			commit();

			List<SearchSceCopHdrInfoVO> resultList = command.searchSceCopHdrInfo(event.getConditionVO()); // Search Master COP Inquiry
			eventResponse.setRsVoList(resultList);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException ...
	 */
	public EventResponse modifyPCopHdr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0118Event event = (EsdSce0118Event) e;
		CodeUtilBC utilBc = new CodeUtilBCImpl();
		COPSearchBC command = new COPSearchBCImpl();

		try {
			begin();
			COPInquiryVO inqVO = event.getConditionVO();
			command.modifyPCopHdr(inqVO);

			String ofcCode = e.getSignOnUserAccount() == null ? "SysMan" : e.getSignOnUserAccount().getOfc_cd();

			utilBc.addSceCopHistory(inqVO.getNewCopNo(), "LC", ofcCode, inqVO.getUsrId(), "N");

			commit();

			List<SearchSceCopHdrInfoVO> resultList = command.searchSceCopHdrInfo(event.getConditionVO()); // Search Master COP Inquiry
			eventResponse.setRsVoList(resultList);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving BKG Info <br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchBookingDetail(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0915Event event = (EsdSce0915Event) e;

		try {
			COPSearchBC command = new COPSearchBCImpl();
			List<?> list = command.searchBookingDetail(event.getCopInquiryVO());
			DBRowSet bkgList = (DBRowSet) list.get(0);
			List<BookingInfoVO> listVVD = (List<BookingInfoVO>) list.get(1);
			eventResponse.setRs(bkgList);
			eventResponse.setRsVoList(listVVD);

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Modify COP Status
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException ...
	 */
	public EventResponse modifyCOPStatusChange(Event e) throws EventException {
		EsdSce0001Event event = (EsdSce0001Event) e;
		// 2015.04.14 Modify Critical
		// EventResponse eventResponse = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		COPSearchBC command = new COPSearchBCImpl();
		SearchCOPMainListVO[] mainListVOs = event.getMainListVOs();
		try {
			begin();
			command.modifyCOPStatusChange(mainListVOs);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving COP Detail Data <br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCOPDetail(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0006Event event = (EsdSce0006Event) e;

		try {
			COPSearchBC command = new COPSearchBCImpl();
			eventResponse = command.searchCOPDetail(event.getCOPDetailVO());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * retrieving COP Booking List<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0006Event event = (EsdSce0006Event) e;
		List<SearchSceCopHdrInfoVO> list = null;
		try {
			COPSearchBC command = new COPSearchBCImpl();
			list = command.searchBookingList(event.getCOPDetailVO());
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Manual Change
	 * 
	 * @param e
	 * @param usr_id
	 * @return
	 * @throws EventException
	 */
	// Manual Change 사용.
	private EventResponse addCOPReplan(Event e, String usr_id) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0009Event event = (EsdSce0009Event) e;

		try {

			ReplanManageBC command = new ReplanManageBCImpl();

			begin();

			COPReplanInfoVO[] inqVO = event.getCOPReplanInfoVOs();
			if (inqVO != null) {
				for (int i = 0; i < inqVO.length; i++) {

					SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
					sceCopHdrVO.setBkgNo(inqVO[i].getBkgNo());
					sceCopHdrVO.setCntrNo(inqVO[i].getCntrNo());
					sceCopHdrVO.setCopNo(inqVO[i].getCopNo());
					sceCopHdrVO.setCopStsCd(inqVO[i].getCopStsCd());
					sceCopHdrVO.setPctlNo(inqVO[i].getPctlNo());
					log.debug("\n  bkgNo:" + inqVO[i].getBkgNo() + "  cntrNo:" + inqVO[i].getCntrNo() + " copNo:" + inqVO[i].getCopNo() + "  copStsCd:" + inqVO[i].getCopStsCd() + "  pctlNo:" + inqVO[i].getPctlNo());
					command.replanCopInclPrt(sceCopHdrVO, account);
				}
			}

			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * modify COP Detail Search <br>
	 * 
	 * @param e EsdSce0006Event_U
	 * @return EventResponse EsdSce0006EventResponse_U
	 * @exception EventException
	 */
	private EventResponse modifyCOPDetailEstmActDT(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsdSce0006Event event = (EsdSce0006Event) e;
		COPUpdateInfoVO inqVO = event.getCOPUpdateInfoVO();

		try {
			begin();
			COPUpdateBC command = new COPUpdateBCImpl();

			command.modifyCOPDetailEstmActDT(inqVO);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving COP Info<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTargetCOPInfoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0009Event event = (EsdSce0009Event) e;
		try {
			COPSearchBC command = new COPSearchBCImpl();
			COPReplanInfoVO inqVO = event.getCOPReplanInfoVO();
			List<SearchTargetCOPInfoListVO> list = command.searchTargetCOPInfoList(inqVO);
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving PC Info<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTargetPCInfoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0009Event event = (EsdSce0009Event) e;

		try {

			COPSearchBC command = new COPSearchBCImpl();
			COPReplanInfoVO[] inqVOs = event.getCOPReplanInfoVOs();
			COPReplanInfoVO inqVO = event.getCOPReplanInfoVO();

			String[] frmtoNumArray = command.searchCopCurrentInfo(inqVOs, inqVO);

			String cop_no = frmtoNumArray[0];
			String io_bnd_cd = frmtoNumArray[1];
			String new_nod = frmtoNumArray[2];
			String cre_usr_id = account.getUsr_id();
			begin();

			ProductCatalogCreateBC prdCommand = new ProductCatalogCreateBCImpl();
			String pctlHdrNo = prdCommand.createSceManualReplan(cop_no, io_bnd_cd, new_nod, cre_usr_id);
			log.debug("\n call prdCommand.createSceManualReplan(" + cop_no + "," + io_bnd_cd + "," + new_nod + "," + cre_usr_id + ")" + "\n params...." + "\n copno : " + frmtoNumArray[0] + "\n ioBndCd : " + frmtoNumArray[1] + "\n newNod : " + frmtoNumArray[2] + "\n creUsrId : " + frmtoNumArray[3]
					+ "\n");

			commit();

			String[] resultArray = { pctlHdrNo, cop_no, io_bnd_cd };
			eventResponse = command.searchTargetPCInfoList(inqVOs, inqVO, resultArray);

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}
