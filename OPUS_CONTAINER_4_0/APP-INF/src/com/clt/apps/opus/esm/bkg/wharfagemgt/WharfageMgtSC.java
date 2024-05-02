/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : WharfageMgtSC.java
 *@FileTitle : WharfageMgtSC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BlKrWhfExptVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrKrWhfExptVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.basic.WharfageDecMgtBC;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.basic.KrWharfageDecMgtBCImpl;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0122Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0123Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0124Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0125Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0416Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0548Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0549Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0555Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0556Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0557Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0560Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0699Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0733Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0738Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg1010Event;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBkgCstmsLocVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBlContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfAplyPortRtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBerthCdCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBerthCdVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlChkListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExpInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlInfoContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCfmVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfExemptInfoContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.VvdPortEtdEtaVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBerthCdVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlChkVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfChgVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExemptInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfLocCdVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfPortRtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfRateVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfVslInfoVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComBakEndJbVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgKrWhfCfmVO;
import com.clt.syscommon.common.table.BkgKrWhfVolVO;
import com.clt.syscommon.common.table.BkgUsaWhfSndHisVO;
import com.clt.syscommon.common.table.MdmYardVO;

/**
 * OPUS-WharfageMgt Business Logic ServiceCommand - OPUS- handling business transaction abound WharfageMgt.
 * 
 * @author JAE YOEB JEUNG
 * @see
 * @since J2EE 1.4
 */
public class WharfageMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * WharfageMgt system business scenario Predecessor<br>
	 * business scenarios related internal object creation during calls<br>
	 */
	public void doStart() {
		try
		{
			account = getSignOnUserAccount();
		}
		catch (Exception e)
		{
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Finishing WharfageMgt system business scenarios<br>
	 *  related internal objects release when end of business scenarios<br>
	 */
	public void doEnd() {
		log.debug("WharfageMgtSC 종료");
	}

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsmBkg0416Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfBerthCd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageWhfBerthCd(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0560Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0750Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg1042Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfPortRtList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageWhfPortRt(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0555Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfChgList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = makeWhfConfirm(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0548Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfVslEtdMrn(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01))
			{
				eventResponse = searchWhfVslInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02))
			{
				eventResponse = searchWhfBerthCd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageWhfVslInfo(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0549Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfBlList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = downloadWhfBlList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0733Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfLocCdList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageWhfLocCd(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0123Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchBl(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageWhfBl(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0124Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfRateList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0125Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfBlChkList(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmBkg1010Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfDecChkList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0556Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfCommInvList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0122Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfMrnSailDt(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01))
			{
				eventResponse = searchWhfCgoClass(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageWhfBl(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND04))
			{
				eventResponse = interfaceWhfToArInv(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND05))
			{
				eventResponse = interfaceWhfToArInv(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03))
			{
				eventResponse = backEndJobResult(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0699Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfExemptInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = modifyWhfExemptInfo(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0738Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfExceptCustList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageWhfExceptCust(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0557Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfMrnSailDt(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01))
			{
				eventResponse = searchWhfDec(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageWhfDec(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND04))
			{
				eventResponse = sendWhfDecCheck(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01))
			{
				eventResponse = sendWhfDec(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02))
			{

				EsmBkg0557Event event = (EsmBkg0557Event) e;

				KrWhfDecCondVO krWhfDecCondVO = event.getKrWhfDecCondVO();
				if(!"Y".equals(krWhfDecCondVO.getCancelFlag())){
					eventResponse = manageWhfDec(e);
				}				
				eventResponse = interfaceWhfDec(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03))
			{
				eventResponse = interfaceWhfToArInv(e);
			}
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0416 : SEARCH<BR>
	 * ESM_BKG_0548 : SEARCH02<BR>
	 * RETRIVE Wharfage port code<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfBerthCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			if (e.getEventName().equalsIgnoreCase("EsmBkg0416Event"))
			{
				EsmBkg0416Event event = (EsmBkg0416Event) e;
				List<WhfBerthCdVO> list = null;
				command = new KrWharfageDecMgtBCImpl();
				list = command.searchWhfBerthCd((KrWhfBerthCdCondVO) event.getWhfBerthCdCondVO());
				eventResponse.setRsVoList(list);
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0548Event"))
			{
				EsmBkg0548Event event = (EsmBkg0548Event) e;
				List<WhfBerthCdVO> list = null;
				command = new KrWharfageDecMgtBCImpl();
				list = command.searchWhfBerthCd((KrWhfBerthCdCondVO) event.getWhfBerthCdCondVO());
				KrWhfBerthCdVO krWhfBerthCdVO = new KrWhfBerthCdVO();
				if (list != null)
					krWhfBerthCdVO = (KrWhfBerthCdVO) list.get(0);
				eventResponse.setETCData("brth_kr_nm", krWhfBerthCdVO.getBrthKrNm());
			}
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0560 : SEARCH<BR>
	 * ESM_BKG_0750 : SEARCH<BR>
	 * ESM_BKG_1042 : SEARCH<BR>
	 *  Wharfage rates charged  by port retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfPortRtList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			if (e.getEventName().equalsIgnoreCase("EsmBkg0560Event"))
			{
				EsmBkg0560Event event = (EsmBkg0560Event) e;
				List<WhfPortRtVO> list = null;
				command = new KrWharfageDecMgtBCImpl();
				list = command.searchWhfPortRtList((KrWhfPortRtListCondVO) event.getKrWhfPortRtListCondVO());
				eventResponse.setRsVoList(list);
			}
			
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0416 : MULTI<BR>
	 * SAVE Wharfage charged port port management<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageWhfBerthCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			begin();
			EsmBkg0416Event event = (EsmBkg0416Event) e;
			command = new KrWharfageDecMgtBCImpl();
			KrWhfBerthCdVO[] list = event.getKrWhfBerthCdVOs2();
			List<WhfBerthCdVO> list2 = new ArrayList<WhfBerthCdVO>();
			for (int i = 0; i < list.length; i++)
			{
				WhfBerthCdVO whfBerthCdVO = (WhfBerthCdVO) list[i];
				list2.add(whfBerthCdVO);
			}
			command.manageWhfBerthCd(list2, account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0560 : MULTI <BR>
	 * ESM_BKG_0750 : MULTI <BR>
	 * ESM_BKG_1042 : MULTI <BR>
	 * Wharfage chaged by port Wharfage rate management (add / modify / delete)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageWhfPortRt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0560Event"))
			{
				EsmBkg0560Event event = (EsmBkg0560Event) e;
				command = new KrWharfageDecMgtBCImpl();
				KrWhfPortRtVO[] list = event.getKrWhfPortRtVOs2();
				command.manageWhfPortRt(list, account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			}
			
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0555 : SEARCH <BR>
	 * RETRIVE Wharfage  Charge list retrieve <BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfChgList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			EsmBkg0555Event event = (EsmBkg0555Event) e;
			List<WhfChgVO> list = null;
			command = new KrWharfageDecMgtBCImpl();
			list = command.searchWhfChgList((KrWhfChgListCondVO) event.getKrWhfChgListCondVO());
			if (list.size() > 0)
			{
				KrWhfChgContainerVO krWhfChgContainerVO = (KrWhfChgContainerVO) list.get(0);
				eventResponse.setRsVoList(krWhfChgContainerVO.getKrWhfChgVOs());
				eventResponse.setRsVoList(krWhfChgContainerVO.getKrWhfChgGenVOs());
				eventResponse.setRsVoList(krWhfChgContainerVO.getKrWhfChgExpSumVOs());
				KrWhfCfmVO krWhfCfmVO = krWhfChgContainerVO.getKrWhfCfmVO();
				eventResponse.setRsVo(krWhfCfmVO);
				VvdPortEtdEtaVO vvdPortEtdEtaVo = krWhfChgContainerVO.getVvdPortEtdEtaVO();
				eventResponse.setRsVo(vvdPortEtdEtaVo);
				// List<BkgKrWhfCfmVO> list2 = new ArrayList<BkgKrWhfCfmVO>();
				// list2.add(bkgKrWhfCfmVO);
				// eventResponse.setRsVoList(list2);
			}
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0548 : SEARCH <BR>
	 * RETRIVE Wharfage vessel info(ETD, MRN) retrieve <BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfVslEtdMrn(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			EsmBkg0548Event event = (EsmBkg0548Event) e;
			// List<WhfVslInfoVO> list = null;
			WhfVslInfoVO whfVslInfoVO = null;
			command = new KrWharfageDecMgtBCImpl();
			whfVslInfoVO = command.searchWhfVslEtdMrn((KrWhfVslInfoCondVO) event.getKrWhfVslInfoCondVO());
			// eventResponse.setRsVo(whfVslInfoVO);
			// eventResponse.setRsVoList(list);
			KrWhfVslInfoContainerVO krWhfVslInfoContainerVO = (KrWhfVslInfoContainerVO) whfVslInfoVO;
			KrWhfVslInfoVO krWhfVslInfoVO = krWhfVslInfoContainerVO.getKrWhfVslInfoVO();
			List<KrWhfVslInfoVO> krWhfVslInfoVOs = krWhfVslInfoContainerVO.getKrWhfVslInfoVOs();
			eventResponse.setRsVo(krWhfVslInfoVO);
			eventResponse.setRsVoList(krWhfVslInfoVOs);
			if (krWhfVslInfoVO != null)
			{
				eventResponse.setETCData("mrn_no", krWhfVslInfoVO.getMrnNo());
				eventResponse.setETCData("vps_dt", krWhfVslInfoVO.getVpsDt());
				eventResponse.setETCData("mrn_chk_no", krWhfVslInfoVO.getMrnChkNo());
				eventResponse.setETCData("tml_cd", krWhfVslInfoVO.getTmlCd());
				eventResponse.setETCData("unld_agn_cd1", krWhfVslInfoVO.getUnldAgnCd1());
				eventResponse.setETCData("unld_agn_cd2", krWhfVslInfoVO.getUnldAgnCd2());
				eventResponse.setETCData("unld_agn_cd3", krWhfVslInfoVO.getUnldAgnCd3());
				eventResponse.setETCData("whf_rt", krWhfVslInfoVO.getWhfRt());
			}
			else
			{
				eventResponse.setETCData("mrn_no", "");
				eventResponse.setETCData("vps_dt", "");
				eventResponse.setETCData("mrn_chk_no", "");
				eventResponse.setETCData("tml_cd", "");
				eventResponse.setETCData("unld_agn_cd1", "");
				eventResponse.setETCData("unld_agn_cd2", "");
				eventResponse.setETCData("unld_agn_cd3", "");
				eventResponse.setETCData("whf_rt", "");
			}
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0548 : SEARCH01 <BR>
	 * RETRIVE Wharfage vessel info retrieve<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfVslInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			EsmBkg0548Event event = (EsmBkg0548Event) e;
			// List<WhfVslInfoVO> list = null;
			WhfVslInfoVO whfVslInfoVO = null;
			command = new KrWharfageDecMgtBCImpl();
			whfVslInfoVO = command.searchWhfVslInfo((KrWhfVslInfoCondVO) event.getKrWhfVslInfoCondVO());
			eventResponse.setRsVo((KrWhfVslInfoVO) whfVslInfoVO);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0548 : MULTI <BR> 
	 * Wharfage declaration vessel info management (add / modify / delete) <BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageWhfVslInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			begin();
			EsmBkg0548Event event = (EsmBkg0548Event) e;
			command = new KrWharfageDecMgtBCImpl();
			KrWhfVslInfoVO krWhfVslInfoVO = event.getKrWhfVslInfoVO();
			command.manageWhfVslInfo(krWhfVslInfoVO, account);
			// eventResponse.setUserMessage((String) new ErrorHandler("SAQ00010",new String[]{}).getUserMessage());
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0688 : SEARCH<BR>
	 * ESM_BKG_1041 : SEARCH<BR>
	 * ESM_BKG_0549 : SEARCH<BR> 
	 * RETRIVE WHF BL list retrieve <BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfBlList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0549Event"))
			{
				EsmBkg0549Event event = (EsmBkg0549Event) e;
				List<WhfBlVO> list = null;
				command = new KrWharfageDecMgtBCImpl();
				list = command.searchWhfBlList(event.getKrWhfBlListCondVO());
				eventResponse.setRsVoList(list);
			}
	
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0733 : SEARCH <BR>
	 * RETRIVE Wharfage Location Code list retrieve <BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfLocCdList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			EsmBkg0733Event event = (EsmBkg0733Event) e;
			List<WhfLocCdVO> list = null;
			command = new KrWharfageDecMgtBCImpl();
			list = command.searchWhfLocCdList(event.getKrWhfLocCdListCondVO());
			eventResponse.setRsVoList(list);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0123 : SEARCH<BR>
	 * BL data retrieve..<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			EsmBkg0123Event event = (EsmBkg0123Event) e;
			command = new KrWharfageDecMgtBCImpl();
			KrBlContainerVO krBlContainerVO = (KrBlContainerVO) command.searchBl(event.getKrBlCondVO());
			eventResponse.setRsVoList(krBlContainerVO.getKrCntrVOs());
			eventResponse.setRsVoList(krBlContainerVO.getKrCustVOs());
			eventResponse.setRsVo(krBlContainerVO.getKrBlVO());
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0124 : SEARCH<BR>
	 *  Retrieve List that containing WHF charge code<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfRateList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			EsmBkg0124Event event = (EsmBkg0124Event) e;
			command = new KrWharfageDecMgtBCImpl();
			List<WhfRateVO> list = command.searchWhfRateList(event.getKrWhfRateListCondVO());
			eventResponse.setRsVoList(list);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0125 : SEARCH<BR>
	 * WHF declaration  omissions  retrieve in B/L been declared to Korea Customs<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfBlChkList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			EsmBkg0125Event event = (EsmBkg0125Event) e;
			command = new KrWharfageDecMgtBCImpl();
			List<WhfBlChkVO> list = command.searchWhfBlChkList((KrWhfBlChkListCondVO) event.getKrWhfBlChkListCondVO());
			eventResponse.setRsVoList(list);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0733 : MULTI<BR>
	 * Wharfage Location Code manage (add / modify / delete)<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageWhfLocCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			begin();
			EsmBkg0733Event event = (EsmBkg0733Event) e;
			command = new KrWharfageDecMgtBCImpl();
			KrBkgCstmsLocVO[] krBkgCstmsLocVOs = event.getKrBkgCstmsLocVOs2();
			List<WhfLocCdVO> whfLocCdVOS = new ArrayList<WhfLocCdVO>();
			for (int i = 0; i < krBkgCstmsLocVOs.length; i++)
			{
				KrBkgCstmsLocVO krBkgCstmsLocVO = krBkgCstmsLocVOs[i];
				whfLocCdVOS.add(krBkgCstmsLocVO);
			}
			command.manageWhfLocCd(whfLocCdVOS, account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0555 : MULTI<BR>
	 * determine Wharfage amount declared 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse makeWhfConfirm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			begin();
			EsmBkg0555Event event = (EsmBkg0555Event) e;
			command = new KrWharfageDecMgtBCImpl();
			BkgKrWhfCfmVO bkgKrWhfCfmVO = command.makeWhfConfirm(event.getKrBkgWhfCfmVO(), account);
			eventResponse.setRsVo(bkgKrWhfCfmVO);
			eventResponse.setUserMessage(new ErrorHandler("BKG06022").getUserMessage());
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * ESM_BKG_0688 : MULTI<BR>
	 * ESM_BKG_1041 : MULTI<BR>
	 * ESM_BKG_0123 : MULTI<BR>
	 * ESM_BKG_0122 : MULTI<BR>
	 * downloaded WHF BL info management<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageWhfBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			begin();
if (e.getEventName().equalsIgnoreCase("EsmBkg0123Event"))
			{
				EsmBkg0123Event event = (EsmBkg0123Event) e;
				command = new KrWharfageDecMgtBCImpl();
				KrWhfBlContainerVO[] krWhfBlContainerVOs = new KrWhfBlContainerVO[1];
				KrWhfBlContainerVO krWhfBlContainerVO = new KrWhfBlContainerVO();
				krWhfBlContainerVO.setKrWhfBkgInfoCondVO(event.getKrWhfBkgInfoCondVO());
				krWhfBlContainerVO.setKrWhfBkgKrWhfBlVOs(event.getKrWhfBkgKrWhfBlVOs());
				krWhfBlContainerVO.setBkgKrWhfCustVOs(event.getBkgKrWhfCustVOs());
				krWhfBlContainerVO.setBkgKrWhfCntrVOs(event.getBkgKrWhfCntrVOs());
				krWhfBlContainerVO.setKrWhfVslInfoCondVO(event.getKrWhfVslInfoCondVO());
				krWhfBlContainerVOs[0] = krWhfBlContainerVO;
				command.manageWhfBl(krWhfBlContainerVOs, account);
				eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0122Event"))
			{
				EsmBkg0122Event event = (EsmBkg0122Event) e;
				command = new KrWharfageDecMgtBCImpl();
				KrWhfBlContainerVO[] krWhfBlContainerVOs = new KrWhfBlContainerVO[1];
				KrWhfBlContainerVO krWhfBlContainerVO = new KrWhfBlContainerVO();
				krWhfBlContainerVO.setSvcGubunId("EsmBkg0122Event");
				krWhfBlContainerVO.setKrWhfVslInfoCondVO(event.getKrWhfVslInfoCondVO());
				krWhfBlContainerVO.setBkgKrWhfVolVO(event.getBkgKrWhfVolVO());
				krWhfBlContainerVO.setKrWhfBlInfoVOs(event.getKrWhfBlInfoVOss());
				krWhfBlContainerVOs[0] = krWhfBlContainerVO;
				command.manageWhfBl(krWhfBlContainerVOs, account);
				eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
			}
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getUserMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0549 : MULTI<BR>
	 *  WHF declaration target BL list download from BL and customs table to WHF management table <BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse downloadWhfBlList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			begin();
			EsmBkg0549Event event = (EsmBkg0549Event) e;
			command = new KrWharfageDecMgtBCImpl();
			KrWhfBlContainerVO[] krWhfBlContainerVOs = new KrWhfBlContainerVO[1];
			KrWhfBlContainerVO krWhfBlContainerVO = new KrWhfBlContainerVO();
			krWhfBlContainerVO.setKrWhfBkgKrWhfBlVO(event.getKrWhfBkgKrWhfBlVO());
			krWhfBlContainerVO.setBkgKrWhfCustVO(event.getBkgKrWhfCustVO());
			krWhfBlContainerVO.setBkgKrWhfCntrVO(event.getBkgKrWhfCntrVO());
			krWhfBlContainerVOs[0] = krWhfBlContainerVO;
			command.downloadWhfBlList(krWhfBlContainerVOs, account);
			eventResponse
					.setETCData("MESSAGE", (String) new ErrorHandler("BKG06062", new String[] {}).getUserMessage());
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getUserMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1010 : SEARCH<BR>
	 * WHF declaration status retrieve<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfDecChkList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			EsmBkg1010Event event = (EsmBkg1010Event) e;
			command = new KrWharfageDecMgtBCImpl();
			eventResponse.setRsVoList(command.searchWhfDecChkList(event.getKrWhfDecChkListCondVO()));
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getUserMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0688 : SEARCH02<BR>
	 * ESM_BKG_1041 : SEARCH02<BR>
	 * ESM_BKG_0749 : SEARCH02<BR>
	 * ESM_BKG_1040 : SEARCH02<BR>
	 * result code retrieve after BackEndJob run
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String[] msg = new String[1];
		msg[0] = "";
		try
		{
			String strKey = "";
			String strResult = "";
			if (e.getEventName().equalsIgnoreCase("EsmBkg0122Event"))
			{
				EsmBkg0122Event event = (EsmBkg0122Event) e;
				strKey = event.getKey();
			}
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(strKey);
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
			List<Object> dbRowSetlist = (List<Object>) RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
			if (dbRowSetlist.size() > 0)
			{
				ComBakEndJbVO jobVo = (ComBakEndJbVO) dbRowSetlist.get(0);
				if ("3".equals(jobVo.getJbStsFlg()))
				{
					strResult = "SUCCESS";
				}
				else if ("4".equals(jobVo.getJbStsFlg()))
				{
					// error massage setting
					eventResponse.setUserMessage(new ErrorHandler("BKG06086", msg).getUserMessage());
					strResult = "FAIL";
				}
			}
			eventResponse.setETCData("jb_sts_flg", strResult);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", msg).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0556 : SEARCH<BR>
	 * Wharfage pay cost bill retrieve<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfCommInvList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			EsmBkg0556Event event = (EsmBkg0556Event) e;
			command = new KrWharfageDecMgtBCImpl();
			eventResponse.setRsVoList(command.searchWhfCommInvList(event.getKrWhfCommInvListCondVO()));
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getUserMessage(), ex);
		}
		return eventResponse;
	}


	
	/**
	 * ESM_BKG_0122 : SEARCH<BR>
	 * ESM_BKG_0557 : SEARCH<BR>
	 * Wharfage vessel info (ETD, MRN) retrieve<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfMrnSailDt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			if (e.getEventName().equalsIgnoreCase("EsmBkg0122Event"))
			{
				EsmBkg0122Event event = (EsmBkg0122Event) e;
				command = new KrWharfageDecMgtBCImpl();
				List<WhfVslInfoVO> whfVslInfoVOs = command.searchWhfMrnSailDt(event.getKrWhfVslInfoCondVO());
				KrWhfVslInfoVO krWhfVslInfoVO = new KrWhfVslInfoVO();
				if (whfVslInfoVOs.size() > 0)
				{
					krWhfVslInfoVO = (KrWhfVslInfoVO) whfVslInfoVOs.get(0);
					eventResponse.setETCData("mf_ref_no", krWhfVslInfoVO.getMfRefNo());
					eventResponse.setETCData("sail_dt", krWhfVslInfoVO.getSailDt());
					eventResponse.setETCData("whf_decl_no", krWhfVslInfoVO.getWhfDeclNo());
				}
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0557Event"))
			{
				EsmBkg0557Event event = (EsmBkg0557Event) e;
				command = new KrWharfageDecMgtBCImpl();
				KrWhfDecCondVO krWhfDecCondVO = event.getKrWhfDecCondVO();
				KrWhfVslInfoCondVO krWhfVslInfoCondVO = new KrWhfVslInfoCondVO();
				ObjectCloner.build(krWhfDecCondVO, krWhfVslInfoCondVO);
				List<WhfVslInfoVO> whfVslInfoVOs = command.searchWhfMrnSailDt(krWhfVslInfoCondVO);
				KrWhfVslInfoVO krWhfVslInfoVO = new KrWhfVslInfoVO();
				if (whfVslInfoVOs.size() > 0)
				{
					krWhfVslInfoVO = (KrWhfVslInfoVO) whfVslInfoVOs.get(0);
					eventResponse.setETCData("mf_ref_no", krWhfVslInfoVO.getMfRefNo());
					eventResponse.setETCData("sail_dt", krWhfVslInfoVO.getSailDt());
				}
			}
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getUserMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0688 : SEARCH01<BR>
	 * Korea WHF declaration target BL sort (exception target etc.)<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfCgoClass(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			EsmBkg0122Event event = (EsmBkg0122Event) e;
			command = new KrWharfageDecMgtBCImpl();
			List<WhfBlInfoVO> whfBlInfoVOs = command.searchWhfCgoClass(event.getKrWhfCgoClassCondVO());
			List<KrWhfBlInfoVO> krWhfBlInfoVOs = null;
			List<KrWhfAplyPortRtVO> krWhfAplyPortRtVOs = null;
			List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = null;
			String krWhfCntr20ftRt = "";
			String krWhfCntr40ftRt = "";
			String krWhfCntr45ftRt = "";
			String krWhfBlkRt = "";
			if (whfBlInfoVOs.size() > 0)
			{
				KrWhfBlInfoContainerVO krWhfBlInfoContainerVO = (KrWhfBlInfoContainerVO) whfBlInfoVOs.get(0);
				krWhfAplyPortRtVOs = krWhfBlInfoContainerVO.getKrWhfAplyPortRtVOs();
				krWhfBlInfoVOs = krWhfBlInfoContainerVO.getKrWhfBlInfoVOs();
				bkgHrdCdgCtntVOs = krWhfBlInfoContainerVO.getBkgHrdCdgCtntVOs();
				if (krWhfAplyPortRtVOs.size() > 0)
				{
					KrWhfAplyPortRtVO krWhfAplyPortRtVO = krWhfAplyPortRtVOs.get(0);
					krWhfCntr20ftRt = krWhfAplyPortRtVO.getKrWhfCntr20ftRt();
					krWhfCntr40ftRt = krWhfAplyPortRtVO.getKrWhfCntr40ftRt();
					krWhfCntr45ftRt = krWhfAplyPortRtVO.getKrWhfCntr45ftRt();
					krWhfBlkRt = krWhfAplyPortRtVO.getKrWhfBlkRt();
				}
			}
			eventResponse.setRsVoList(krWhfBlInfoVOs);
			eventResponse.setRsVoList(bkgHrdCdgCtntVOs);
			eventResponse.setETCData("kr_whf_cntr_20ft_rt", krWhfCntr20ftRt);
			eventResponse.setETCData("kr_whf_cntr_40ft_rt", krWhfCntr40ftRt);
			eventResponse.setETCData("kr_whf_cntr_45ft_rt", krWhfCntr45ftRt);
			eventResponse.setETCData("kr_whf_blk_rt", krWhfBlkRt);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getUserMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0699 : SEARCH<BR>
	 * Wharfage by B/L exception info (exception reason etc.) retrieve<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfExemptInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			EsmBkg0699Event event = (EsmBkg0699Event) e;
			command = new KrWharfageDecMgtBCImpl();
			WhfExemptInfoVO whfExemptInfoVO = command.searchWhfExemptInfo(event.getKrWhfExemptInfoCondVO());
			KrWhfExemptInfoContainerVO krWhfExemptInfoContainerVO = (KrWhfExemptInfoContainerVO) whfExemptInfoVO;
			KrWhfBlExpInfoVO krWhfBlExpInfoVO = krWhfExemptInfoContainerVO.getKrWhfBlExpInfoVO();
			eventResponse.setRsVoList(krWhfExemptInfoContainerVO.getKrWhfBlExptInfoVOs());
			eventResponse.setRsVoList(krWhfExemptInfoContainerVO.getKrWhfCntrExpInfoVOs());
			if (krWhfBlExpInfoVO != null)
			{
				eventResponse.setETCData("shipper_name", krWhfBlExpInfoVO.getShipperName());
				eventResponse.setETCData("export_ref", krWhfBlExpInfoVO.getExportRef());
				eventResponse.setETCData("cstms_desc", krWhfBlExpInfoVO.getCstmsDesc());
				eventResponse.setETCData("bkg_cgo_tp_cd", krWhfBlExpInfoVO.getBkgCgoTpCd());
				eventResponse.setETCData("bkg_rt_whf_expt_cd", krWhfBlExpInfoVO.getBkgRtWhfExptCd());
				eventResponse.setETCData("whf_shpr_rgst_no", krWhfBlExpInfoVO.getWhfShprRgstNo());
				eventResponse.setETCData("bdr", krWhfBlExpInfoVO.getBdr());
				eventResponse.setETCData("ca", krWhfBlExpInfoVO.getCa());
			}
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getUserMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0738 : SEARCH<BR>
	 * Wharfage exception customer list retrieve
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfExceptCustList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = null;
		try
		{
			EsmBkg0738Event event = (EsmBkg0738Event) e;
			command = new BookingUtil();
			List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = command.searchHardCoding(event.getBkgHrdCdgCtntListCondVO());
			eventResponse.setRsVoList(bkgHrdCdgCtntVOs);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getUserMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0738 : MULTI<BR>
	 * BKG_HRD_CDG_CTNT value add, modify, delete
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageWhfExceptCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = null;
		try
		{
			begin();
			EsmBkg0738Event event = (EsmBkg0738Event) e;
			command = new BookingUtil();
			BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs = event.getBkgHrdCdgCtntVOs();
			BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs2 = event.getBkgHrdCdgCtntVOs();
			String sHrdCdgId = "";
			for (int i = 0; i < bkgHrdCdgCtntVOs.length; i++)
			{
				sHrdCdgId = bkgHrdCdgCtntVOs[0].getHrdCdgId();
				BkgHrdCdgCtntVO bkgHrdCdgCtntVO = bkgHrdCdgCtntVOs[i];
				bkgHrdCdgCtntVO.setHrdCdgId(sHrdCdgId);
				bkgHrdCdgCtntVO.setCreUsrId(account.getUsr_id());
				bkgHrdCdgCtntVO.setUpdUsrId(account.getUsr_id());
				bkgHrdCdgCtntVOs2[i] = bkgHrdCdgCtntVO;
			}
			command.manageHardCoding(bkgHrdCdgCtntVOs2);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getUserMessage(), ex);
		}
		return eventResponse;
	}

	
	

	/**
	 * ESM_BKG_0699 : MULTI<BR>
	 *  Korea Wharfage by B/L exception reason and exception customer registry info modify<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyWhfExemptInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BlRatingBC command1 = null;
		BLDocumentationCMBC command2 = null;
		try
		{
			begin();
			EsmBkg0699Event event = (EsmBkg0699Event) e;
			command1 = new BlRatingBCImpl();
			if (event.getBlKrWhfExptVOs() != null)
			{
				BlKrWhfExptVO[] blKrWhfExptVOs = event.getBlKrWhfExptVOs();
				command1.modifyBlKrWhfExpt(blKrWhfExptVOs[0], account);
			}
			command2 = new BLDocumentationCMBCImpl();
			List<CntrKrWhfExptVO> cntrKrWhfExptVOs = new ArrayList<CntrKrWhfExptVO>();
			if (event.getCntrKrWhfExptVOs() != null)
			{
				for (int i = 0; i < event.getCntrKrWhfExptVOs().length; i++)
				{
					CntrKrWhfExptVO cntrKrWhfExptVO = event.getCntrKrWhfExptVOs()[i];
					cntrKrWhfExptVO.setUpdUsrId(account.getUsr_id());
					if ("1".equals(cntrKrWhfExptVO.getCntrWfgExptFlg()) == true)
					{
						cntrKrWhfExptVO.setCntrWfgExptFlg("Y");
					}
					else
					{
						cntrKrWhfExptVO.setCntrWfgExptFlg("N");
					}
					cntrKrWhfExptVOs.add(cntrKrWhfExptVO);
				}
				if (cntrKrWhfExptVOs.size() > 0)
				{
					command2.modifyCntrKrWhfExpt(cntrKrWhfExptVOs, account);
				}
			}
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getUserMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0557 : SEARCH01<BR>
	 * Wharfage declaration target retrieve
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfDec(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			EsmBkg0557Event event = (EsmBkg0557Event) e;
			command = new KrWharfageDecMgtBCImpl();
			KrWhfDecContainerVO krWhfDecContainerVO = (KrWhfDecContainerVO) command.searchWhfDec(event
					.getKrWhfDecCondVO());
			BkgKrWhfVolVO bkgKrWhfVolVO = krWhfDecContainerVO.getBkgKrWhfVolVO();
			KrWhfDecVO krWhfDecVO = krWhfDecContainerVO.getKrWhfDecVO();
			KrWhfPortRtVO cntrKrWhfPortRtVO = krWhfDecContainerVO.getCntr_KrWhfPortRtVO();
			KrWhfPortRtVO blkKrWhfPortRtVO = krWhfDecContainerVO.getBlk_KrWhfPortRtVO();
			eventResponse.setRsVoList(krWhfDecContainerVO.getKrWhfVvdDtlVOs());
			eventResponse.setRsVoList(krWhfDecContainerVO.getKrWhfDecExptVolVOs());
			if (bkgKrWhfVolVO != null && krWhfDecVO != null)
			{
				eventResponse.setETCData("whf_ntc_dt", bkgKrWhfVolVO.getWhfNtcDt()); // 허가일자
				eventResponse.setETCData("whf_pay_dt", bkgKrWhfVolVO.getWhfPayDt()); // 납기일자
				eventResponse.setETCData("whf_usr_nm", bkgKrWhfVolVO.getWhfUsrNm()); // 담당자
				eventResponse.setETCData("whf_cust_knd_cd", bkgKrWhfVolVO.getWhfCustKndCd()); // 화주
				eventResponse.setETCData("whf_rt_amt", bkgKrWhfVolVO.getWhfRtAmt()); // Total Amount
				eventResponse.setETCData("ntc_amt", bkgKrWhfVolVO.getNtcAmt()); // 신고금액
				eventResponse.setETCData("whf_decl_no", (krWhfDecVO.getWhfDeclNo() == null) ? "" : krWhfDecVO
						.getWhfDeclNo());
				
				eventResponse.setETCData("csr_no", (krWhfDecVO.getCsrNo() == null) ? "" : krWhfDecVO.getCsrNo());
				
				eventResponse.setETCData("ibts_amt", "0"); // I/B T/S Amount  always 0
				eventResponse.setETCData("rduc_amt", bkgKrWhfVolVO.getRducAmt()); // floor
				eventResponse.setETCData("comm_amt", bkgKrWhfVolVO.getCommAmt()); // COMMITION
				eventResponse.setETCData("port_nm", bkgKrWhfVolVO.getPortNm()); // port
				// permission number
				// bkgKrWhfVolVO.get
				eventResponse.setETCData("whf_ntc_no_yr", (krWhfDecVO.getWhfNtcNoYr() == null) ? "" : krWhfDecVO
						.getWhfNtcNoYr()); // permission number 1
				eventResponse.setETCData("whf_ntc_no_mon", (krWhfDecVO.getWhfNtcNoMon() == null) ? "" : krWhfDecVO
						.getWhfNtcNoMon()); // permission number 2
				eventResponse.setETCData("whf_ntc_no_seq", (krWhfDecVO.getWhfNtcNoSeq() == null) ? "" : krWhfDecVO
						.getWhfNtcNoSeq()); // permission number 3
				// hidden value
				eventResponse.setETCData("edi_msg_snd_id", bkgKrWhfVolVO.getEdiMsgSndId());
				eventResponse.setETCData("cntr_20_ut_rt", cntrKrWhfPortRtVO.getCntr20UtRt());
				eventResponse.setETCData("cntr_40_ut_rt", cntrKrWhfPortRtVO.getCntr40UtRt());
				eventResponse.setETCData("cntr_45_ut_rt", cntrKrWhfPortRtVO.getCntr45UtRt());
				eventResponse.setETCData("blk_ut_rt", blkKrWhfPortRtVO.getBlkUtRt());
				eventResponse.setETCData("blk_rt_rto", blkKrWhfPortRtVO.getBlkRtRto());
			}
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getUserMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0557 : MULTI<BR>
	 * Wharfage declaration record management (add / modify / delete)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageWhfDec(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			begin();
			EsmBkg0557Event event = (EsmBkg0557Event) e;
			command = new KrWharfageDecMgtBCImpl();
			KrWhfDecContainerVO krWhfDecContainerVO = new KrWhfDecContainerVO();
			krWhfDecContainerVO.setKrWhfDecCondVO(event.getKrWhfDecCondVO());
			krWhfDecContainerVO.setBkgKrWhfVolVO(event.getBkgKrWhfVolVO());
			krWhfDecContainerVO.setKrWhfDecVO(event.getKrWhfDecVO());
			krWhfDecContainerVO.setKrWhfPortRtVO(event.getKrWhfPortRtVO());
			krWhfDecContainerVO.setKrWhfVvdDtlVOs2(event.getKrWhfVvdDtlVOs());
			krWhfDecContainerVO.setKrWhfDecExptVolVOs2(event.getKrWhfDecExptVolVOs());
			command.manageWhfDec(krWhfDecContainerVO, account);
			if ("BKG06103".equals(krWhfDecContainerVO.getErrMsg()))
			{
				eventResponse.setUserMessage((String) new ErrorHandler("BKG06103", new String[] {}).getUserMessage());
			}
			else
			{
				eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
			}
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getUserMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0557 : COMMAND04<BR>
	 * Wharfage declaration Check
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse sendWhfDecCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		String retVal = "";
		try
		{
			begin();
			EsmBkg0557Event event = (EsmBkg0557Event) e;
			command = new KrWharfageDecMgtBCImpl();
			KrWhfDecContainerVO krWhfDecContainerVO = new KrWhfDecContainerVO();
			krWhfDecContainerVO.setKrWhfDecCondVO(event.getKrWhfDecCondVO());
			krWhfDecContainerVO.setBkgKrWhfVolVO(event.getBkgKrWhfVolVO());
			krWhfDecContainerVO.setKrWhfDecVO(event.getKrWhfDecVO());
			krWhfDecContainerVO.setKrWhfPortRtVO(event.getKrWhfPortRtVO());
			krWhfDecContainerVO.setKrWhfVvdDtlVOs2(event.getKrWhfVvdDtlVOs());
			krWhfDecContainerVO.setKrWhfDecExptVolVOs2(event.getKrWhfDecExptVolVOs());
			
			retVal = command.searchSendCheck(event.getKrWhfDecCondVO(), account);
			String retArr[] = retVal.split(":");
			
			eventResponse.setETCData("dtCheck", retArr[0]);
			eventResponse.setETCData("etaDt", retArr[1]);
			eventResponse.setETCData("frInDt", retArr[2]);
			eventResponse.setETCData("emptyCheck", retArr[3]);
			
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06088").getUserMessage(), ex);
		}
		return eventResponse;
	}
	

	/**
	 * ESM_BKG_0557 : COMMAND01<BR>
	 * Wharfage declaration
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse sendWhfDec(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		
		try
		{
			begin();
			EsmBkg0557Event event = (EsmBkg0557Event) e;
			command = new KrWharfageDecMgtBCImpl();
			KrWhfDecContainerVO krWhfDecContainerVO = new KrWhfDecContainerVO();
			krWhfDecContainerVO.setKrWhfDecCondVO(event.getKrWhfDecCondVO());
			krWhfDecContainerVO.setBkgKrWhfVolVO(event.getBkgKrWhfVolVO());
			krWhfDecContainerVO.setKrWhfDecVO(event.getKrWhfDecVO());
			krWhfDecContainerVO.setKrWhfPortRtVO(event.getKrWhfPortRtVO());
			krWhfDecContainerVO.setKrWhfVvdDtlVOs2(event.getKrWhfVvdDtlVOs());
			krWhfDecContainerVO.setKrWhfDecExptVolVOs2(event.getKrWhfDecExptVolVOs());
			
			command.sendWhfDec(event.getKrWhfDecCondVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getUserMessage(), ex);
		}
		return eventResponse;
	}
	
	

	/**
	 * ESM_BKG_0557 : COMMAND02<BR>
	 * Wharfage Interface
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse interfaceWhfDec(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			begin();
			EsmBkg0557Event event = (EsmBkg0557Event) e;
			command = new KrWharfageDecMgtBCImpl();
			command.interfaceWhfDec(event.getKrWhfDecCondVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getUserMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0122 : COMMAND04<BR>
	 * ESM_BKG_0122 : COMMAND05<BR>
	 * ESM_BKG_0557 : COMMAND03<BR>
	 * AR interface confirmed WHF declaration cost <BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse interfaceWhfToArInv(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0557Event"))
			{
				EsmBkg0557Event event = (EsmBkg0557Event) e;
				command = new KrWharfageDecMgtBCImpl();
				command.interfaceWhfCngNo(event.getKrWhfDecCondVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0122Event"))
			{
				EsmBkg0122Event event = (EsmBkg0122Event) e;
				command = new KrWharfageDecMgtBCImpl();
				KrWhfBlContainerVO[] krWhfBlContainerVOs = new KrWhfBlContainerVO[1];
				KrWhfBlContainerVO krWhfBlContainerVO = new KrWhfBlContainerVO();
				krWhfBlContainerVO.setSvcGubunId("EsmBkg0122Event");
				krWhfBlContainerVO.setKrWhfCgoClassCondVO(event.getKrWhfCgoClassCondVO());
				krWhfBlContainerVO.setKrWhfVslInfoCondVO(event.getKrWhfVslInfoCondVO());
				krWhfBlContainerVO.setBkgKrWhfVolVO(event.getBkgKrWhfVolVO());
				krWhfBlContainerVO.setKrWhfBlInfoVOs(event.getKrWhfBlInfoVOss());
				krWhfBlContainerVOs[0] = krWhfBlContainerVO;
				command.interfaceWhfToArInv(krWhfBlContainerVOs, account);
				//eventResponse.setETCData("KEY", sKey);
				eventResponse.setUserMessage(new ErrorHandler("BKG06105").getUserMessage());
			}
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getUserMessage(), ex);
		}
		return eventResponse;
	}
	
	
}