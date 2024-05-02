/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : WharfageMgtSC.java
 *@FileTitle : WharfageMgtSC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.21
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.07.21 정재엽
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BlKrWhfExptVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrKrWhfExptVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.basic.WharfageDecMgtBC;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.basic.KrWharfageDecMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0122Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0123Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0124Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0125Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0129Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0416Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0548Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0549Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0555Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0556Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0557Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0560Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0699Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0733Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0738Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg1010Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBkgCstmsLocVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBlContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfAplyPortRtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBerthCdCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBerthCdVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgChkListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlChkListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExpInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlInfoContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCfmVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfExemptInfoContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.basic.UsWharfageDecMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.event.EsmBkg0688Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.event.EsmBkg0748Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.event.EsmBkg0749Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.event.EsmBkg0750Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.event.EsmBkg0751Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.event.EsmBkg1040Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.event.EsmBkg1041Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.event.EsmBkg1042Event;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfSendVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.VvdPortEtdEtaVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBerthCdVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlChkVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBkgChkVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfChgVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExemptInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfLocCdVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfPortRtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfRateVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfVslInfoVO;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComBakEndJbVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgKrWhfCfmVO;
import com.hanjin.syscommon.common.table.BkgKrWhfVolVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndHisVO;
import com.hanjin.syscommon.common.table.MdmYardVO;

/**
 * ALPS-WharfageMgt Business Logic ServiceCommand - ALPS-WharfageMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author JAE YOEB JEUNG
 * @see
 * @since J2EE 1.4
 */
public class WharfageMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * WharfageMgt system 업무 시나리오 선행작업<br>
	 * 업무시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try
		{
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		}
		catch (Exception e)
		{
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * WharfageMgt system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("WharfageMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-Wharfage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
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
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0129Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfBkgChkList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageWhfBl(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0748Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfExceptCmdtList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageWhfExceptCmdt(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0688Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg1041Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.INIT))
			{
				// 콤보 Row
				GeneralEventResponse response = new GeneralEventResponse();
				BookingUtil bkgUtilBC = new BookingUtil();
				if (e.getEventName().equalsIgnoreCase("EsmBkg0688Event"))
				{
					response.setRsVoList(bkgUtilBC.searchCombo("CD02274"));
				}
				else if (e.getEventName().equalsIgnoreCase("EsmBkg1041Event"))
				{
					response.setRsVoList(bkgUtilBC.searchCombo("CD02275"));
				}
				eventResponse = response;
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01))
			{
				// Wharfage B/L 테이블에 없는 경우 Booking 테이블에서 조회 후 등록(BackEnd)
				eventResponse = downloadWhfBlCntr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02))
			{
				// BackEnd 후 조회
				eventResponse = backEndJobResult(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				// Wharfage B/L 조회
				eventResponse = searchWhfBlList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				// Wharfage B/L 수정
				eventResponse = manageWhfBl(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01))
			{
				// B/L No. 입력 후 조회
				eventResponse = searchWhfBlCntrList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0751Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchWhfEmlList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageWhfEml(e);
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
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0749Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg1040Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.INIT))
			{
				GeneralEventResponse response = new GeneralEventResponse();
				// USA_WHF_SHIP_LINE
				BookingUtil bkgUtil = new BookingUtil();
				BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
				hrdCdgVO.setHrdCdgId("USA_WHF_SHIP_LINE");
				response.setRsVoList(bkgUtil.searchHardCoding(hrdCdgVO));
				eventResponse = response;
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01))
			{
				// Wharfage B/L 테이블에 없는 경우 Booking 테이블에서 조회 후 등록(BackEnd)
				eventResponse = downloadWhfSend(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02))
			{
				// BackEnd 후 조회
				eventResponse = backEndJobResult(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				// Wharfage B/L 조회
				eventResponse = searchWhfSend(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				// Wharfage B/L 수정
				eventResponse = manageWhfSend(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01))
			{
				// Wharfage Send
				eventResponse = sendWhfDecl(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY02))
			{
				// Wharfage Send with Excpt & T/S B/Ls
				eventResponse = sendWhfExptTs(e);
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
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND05))
			{
				eventResponse = manageWhfHis(e);
			}
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0416 : SEARCH<BR>
	 * ESM_BKG_0548 : SEARCH02<BR>
	 * RETRIVE Wharfage 부과 항만 코드 조회<BR>
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
			// 이벤트별 Impl생성
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
	 * 항구 별 Wharfage 부과 요율 조회<br>
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
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0560Event"))
			{
				EsmBkg0560Event event = (EsmBkg0560Event) e;
				List<WhfPortRtVO> list = null;
				command = new KrWharfageDecMgtBCImpl();
				list = command.searchWhfPortRtList((KrWhfPortRtListCondVO) event.getKrWhfPortRtListCondVO());
				eventResponse.setRsVoList(list);
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0750Event"))
			{
				EsmBkg0750Event event = (EsmBkg0750Event) e;
				command = new UsWharfageDecMgtBCImpl();
				eventResponse.setRsVoList(command.searchWhfPortRtList(event.getUsWhfPortRtListCondVO()));
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg1042Event"))
			{
				EsmBkg1042Event event = (EsmBkg1042Event) e;
				command = new UsWharfageDecMgtBCImpl();
				eventResponse.setRsVoList(command.searchWhfPortRtList(event.getUsWhfPortRtListCondVO()));
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
	 * SAVE Wharfage 부과 항만 코드 관리<BR>
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
			// 이벤트별 Impl생성
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
	 * Wharfage 부과 항 별 Wharfage 요율 관리 (생성 / 정정 / 삭제)
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
			// 이벤트별 Impl생성
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0560Event"))
			{
				EsmBkg0560Event event = (EsmBkg0560Event) e;
				command = new KrWharfageDecMgtBCImpl();
				KrWhfPortRtVO[] list = event.getKrWhfPortRtVOs2();
				command.manageWhfPortRt(list, account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0750Event"))
			{
				EsmBkg0750Event event = (EsmBkg0750Event) e;
				command = new UsWharfageDecMgtBCImpl();
				command.manageWhfPortRt(event.getUsWhfPortRtVOs(), account);
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg1042Event"))
			{
				EsmBkg1042Event event = (EsmBkg1042Event) e;
				command = new UsWharfageDecMgtBCImpl();
				command.manageWhfPortRt(event.getUsWhfPortRtVOs(), account);
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
	 * RETRIVE Wharfage 부과 Charge 목록 조회 <BR>
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
			// 이벤트별 Impl생성
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
	 * RETRIVE Wharfage 선박 정보 (ETD, MRN) 조회 <BR>
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
			// 이벤트별 Impl생성
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
	 * RETRIVE Wharfage 선박 정보 조회 <BR>
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
			// 이벤트별 Impl생성
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
	 * Wharfage 신고 선박 정보 관리 (생성 / 정정 / 삭제) <BR>
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
			// 이벤트별 Impl생성
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
	 * RETRIVE WHF BL 목록 조회 <BR>
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
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0549Event"))
			{
				EsmBkg0549Event event = (EsmBkg0549Event) e;
				List<WhfBlVO> list = null;
				command = new KrWharfageDecMgtBCImpl();
				list = command.searchWhfBlList(event.getKrWhfBlListCondVO());
				eventResponse.setRsVoList(list);
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0688Event"))
			{
				EsmBkg0688Event event = (EsmBkg0688Event) e;
				command = new UsWharfageDecMgtBCImpl();
				event.getUsWhfBlListCondVO().setCreUsrId(account.getUsr_id());
				eventResponse.setRsVoList(command.searchWhfBlList(event.getUsWhfBlListCondVO()));
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg1041Event"))
			{
				EsmBkg1041Event event = (EsmBkg1041Event) e;
				command = new UsWharfageDecMgtBCImpl();
				event.getUsWhfBlListCondVO().setCreUsrId(account.getUsr_id());
				eventResponse.setRsVoList(command.searchWhfBlList(event.getUsWhfBlListCondVO()));
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
	 * RETRIVE Wharfage Location Code 목록 조회 <BR>
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
			// 이벤트별 Impl생성
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
	 * BL 데이터를 조회한다.<BR>
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
			// 이벤트별 Impl생성
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
	 * WHF charge code가 포함된 목록 조회<BR>
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
			// 이벤트별 Impl생성
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
	 * 한국 세관에 신고 된 B/L 중 WHF 신고 누락 분이 있는지 조회<BR>
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
			// 이벤트별 Impl생성
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
	 * ESM_BKG_0129 : SEARCH<BR>
	 * BKG 중 WHF 신고 누락 분이 있는지 조회<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfBkgChkList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			// 이벤트별 Impl생성
			EsmBkg0129Event event = (EsmBkg0129Event) e;
			command = new KrWharfageDecMgtBCImpl();
			List<WhfBkgChkVO> list = command.searchWhfBkgChkList((KrWhfBkgChkListCondVO) event.getKrWhfBkgChkListCondVO());
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
	 * Wharfage Location Code 관리 (생성 / 정정 / 삭제)<BR>
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
			// 이벤트별 Impl생성
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
	 * Wharfage 신고 금액을 확정 함
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
			// 이벤트별 Impl생성
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
	 * ESM_BKG_0748 : SEARCH<BR>
	 * Wharfage 면제 Commoidty 목록 조회<BR>
	 * 
	 * @param Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfExceptCmdtList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			// 이벤트별 Impl생성
			EsmBkg0748Event event = (EsmBkg0748Event) e;
			command = new UsWharfageDecMgtBCImpl();
			eventResponse.setRsVoList(command.searchWhfExceptCmdtList(event.getUsWhfExceptCmdtListCondVO()));
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
	 * ESM_BKG_0748 : MULTI<BR>
	 * Wharfage 면제 Commodity 관리
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageWhfExceptCmdt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			// 이벤트별 Impl생성
			begin();
			EsmBkg0748Event event = (EsmBkg0748Event) e;
			command = new UsWharfageDecMgtBCImpl();
			command.manageWhfExceptCmdt(event.getUsWhfExceptCmdtVOs(), account);
			// 성공메시지
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
	 * ESM_BKG_0688 : MULTI<BR>
	 * ESM_BKG_1041 : MULTI<BR>
	 * ESM_BKG_0123 : MULTI<BR>
	 * ESM_BKG_0122 : MULTI<BR>
	 * ESM_BKG_0129 : MULTI<BR>
	 * 다운로드 받은 WHF BL 정보 관리<BR>
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
			// 이벤트별 Impl생성
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0688Event"))
			{
				EsmBkg0688Event event = (EsmBkg0688Event) e;
				command = new UsWharfageDecMgtBCImpl();
				command.manageWhfBl(event.getUsWhfBlVOs(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg1041Event"))
			{
				EsmBkg1041Event event = (EsmBkg1041Event) e;
				command = new UsWharfageDecMgtBCImpl();
				command.manageWhfBl(event.getUsWhfBlVOs(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0123Event"))
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
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0129Event"))
			{
				EsmBkg0129Event event = (EsmBkg0129Event) e;
				command = new KrWharfageDecMgtBCImpl();
				KrWhfBlContainerVO[] krWhfBlContainerVOs = new KrWhfBlContainerVO[1];
				KrWhfBlContainerVO krWhfBlContainerVO = new KrWhfBlContainerVO();
				krWhfBlContainerVO.setKrWhfVslInfoCondVO(event.getKrWhfVslInfoCondVO());
				krWhfBlContainerVO.setKrWhfBkgChkListCondVOs(event.getKrWhfBkgChkListCondVOs());
				krWhfBlContainerVO.setBkgKrWhfVolVO(event.getBkgKrWhfVolVO());
				krWhfBlContainerVOs[0] = krWhfBlContainerVO;
				command.manageWhfBkg(krWhfBlContainerVOs, account);
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
	 * ESM_BKG_0751 : SEARCH<BR>
	 * Berth 등 부가 정보 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfEmlList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			// 이벤트별 Impl생성
			EsmBkg0751Event event = (EsmBkg0751Event) e;
			command = new UsWharfageDecMgtBCImpl();
			// 결과 Row
			eventResponse.setRsVoList(command.searchWhfEmlList(event.getUsWhfEmlListCondVO()));
			// 콤보 Row
			BookingUtil bkgUtilBC = new BookingUtil();
			MdmYardVO mdmYardVO = new MdmYardVO();
			mdmYardVO.setLocCd(event.getUsWhfEmlListCondVO().getPortCd());
			mdmYardVO.setYdFctyTpMrnTmlFlg("Y");
			eventResponse.setRsVoList(bkgUtilBC.searchYardCode(mdmYardVO));
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
	 * ESM_BKG_0751 : MULTI<BR>
	 * Berth 등 부가 정보 관리
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageWhfEml(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			begin();
			EsmBkg0751Event event = (EsmBkg0751Event) e;
			command = new UsWharfageDecMgtBCImpl();
			command.manageWhfEml(event.getUsWhfEmlVOs(), account);
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
	 * ESM_BKG_0688 : SEARCH01<BR>
	 * ESM_BKG_1041 : SEARCH01<BR>
	 * BL No. 입력후 BL, CNTR정보조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfBlCntrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0688Event"))
			{
				EsmBkg0688Event event = (EsmBkg0688Event) e;
				command = new UsWharfageDecMgtBCImpl();
				eventResponse.setRsVoList(command.searchWhfBlCntrList(event.getUsWhfBlListCondVO()));
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg1041Event"))
			{
				EsmBkg1041Event event = (EsmBkg1041Event) e;
				command = new UsWharfageDecMgtBCImpl();
				eventResponse.setRsVoList(command.searchWhfBlCntrList(event.getUsWhfBlListCondVO()));
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
	 * ESM_BKG_0549 : MULTI<BR>
	 * BL 및(또는) 세관 테이블로 부터 WHF 신고 대상 BL 목록을 WHF 관리 테이블로 다운로드 받음<BR>
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
			// 이벤트별 Impl생성
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
	 * WHF 신고 현황 조회<BR>
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
			// 이벤트별 Impl생성
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
	 * ESM_BKG_0688 : COMMAND01<BR>
	 * ESM_BKG_1041 : COMMAND01<BR>
	 * Wharfage Table Download(BackEndJob 실행)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse downloadWhfBlCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try
		{
			WharfageDecMgtBC command = null;
			if (e.getEventName().equalsIgnoreCase("EsmBkg0688Event"))
			{
				EsmBkg0688Event event = (EsmBkg0688Event) e;
				command = new UsWharfageDecMgtBCImpl();
				event.getUsWhfBlListCondVO().setCreUsrId(account.getUsr_id());
				eventResponse.setETCData("KEY", command.downloadWhfBlCntr(event.getUsWhfBlListCondVO()));
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg1041Event"))
			{
				EsmBkg1041Event event = (EsmBkg1041Event) e;
				command = new UsWharfageDecMgtBCImpl();
				event.getUsWhfBlListCondVO().setCreUsrId(account.getUsr_id());
				eventResponse.setETCData("KEY", command.downloadWhfBlCntr(event.getUsWhfBlListCondVO()));
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
	 * ESM_BKG_0688 : SEARCH02<BR>
	 * ESM_BKG_1041 : SEARCH02<BR>
	 * ESM_BKG_0749 : SEARCH02<BR>
	 * ESM_BKG_1040 : SEARCH02<BR>
	 * BackEndJob 실행 후 결과코드 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String[] msg = new String[1];
		msg[0] = "US Wharfage";
		try
		{
			String strKey = "";
			String strResult = "";
			if (e.getEventName().equalsIgnoreCase("EsmBkg0688Event"))
			{
				EsmBkg0688Event event = (EsmBkg0688Event) e;
				strKey = event.getKey();
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg1041Event"))
			{
				EsmBkg1041Event event = (EsmBkg1041Event) e;
				strKey = event.getKey();
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0749Event"))
			{
				EsmBkg0749Event event = (EsmBkg0749Event) e;
				strKey = event.getKey();
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg1040Event"))
			{
				EsmBkg1040Event event = (EsmBkg1040Event) e;
				strKey = event.getKey();
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0122Event"))
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
					// 에러메시지세팅
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
	 * 화물입항료 대납경비 청구서 조회<BR>
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
			// 이벤트별 Impl생성
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
	 * ESM_BKG_0749 : COMMAND01<BR>
	 * ESM_BKG_1040 : COMMAND01<BR>
	 * Wharfage Table Download(BackEndJob 실행)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse downloadWhfSend(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try
		{
			WharfageDecMgtBC command = null;
			if (e.getEventName().equalsIgnoreCase("EsmBkg0749Event"))
			{
				EsmBkg0749Event event = (EsmBkg0749Event) e;
				command = new UsWharfageDecMgtBCImpl();
				event.getUsWhfSendCondVO().setCreUsrId(account.getUsr_id());
				eventResponse.setETCData("KEY", command.downloadWhfSend(event.getUsWhfSendCondVO()));
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg1040Event"))
			{
				EsmBkg1040Event event = (EsmBkg1040Event) e;
				command = new UsWharfageDecMgtBCImpl();
				event.getUsWhfSendCondVO().setCreUsrId(account.getUsr_id());
				eventResponse.setETCData("KEY", command.downloadWhfSend(event.getUsWhfSendCondVO()));
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
	 * ESM_BKG_0749 : SEARCH<BR>
	 * ESM_BKG_1040 : SEARCH<BR>
	 * 전송 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWhfSend(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0749Event"))
			{
				EsmBkg0749Event event = (EsmBkg0749Event) e;
				command = new UsWharfageDecMgtBCImpl();
				UsWhfSendVO usWhfSendVO = (UsWhfSendVO) command.searchWhfSend(event.getUsWhfSendCondVO());
				eventResponse.setRsVo(usWhfSendVO.getBkgUsaWhfSndVO());
				eventResponse.setRsVoList(usWhfSendVO.getUsWhfSendQtyVOs());
				eventResponse.setRsVoList(usWhfSendVO.getUsWhfSendCntrCntVOs());
				eventResponse.setRsVoList(usWhfSendVO.getBkgUsaWhfBlkCgoVOs());
				eventResponse.setRsVoList(usWhfSendVO.getBkgUsaWhfSndHisVOs());
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg1040Event"))
			{
				EsmBkg1040Event event = (EsmBkg1040Event) e;
				command = new UsWharfageDecMgtBCImpl();
				UsWhfSendVO usWhfSendVO = (UsWhfSendVO) command.searchWhfSend(event.getUsWhfSendCondVO());
				eventResponse.setRsVo(usWhfSendVO.getBkgUsaWhfSndVO());
				eventResponse.setRsVoList(usWhfSendVO.getUsWhfSendQtyVOs());
				eventResponse.setRsVoList(usWhfSendVO.getBkgUsaWhfSndHisVOs());
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
	 * ESM_BKG_0749 : MULTI<BR>
	 * ESM_BKG_1040 : MULTI<BR>
	 * Send Data Save
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageWhfSend(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			// 이벤트별 Impl생성
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0749Event"))
			{
				EsmBkg0749Event event = (EsmBkg0749Event) e;
				command = new UsWharfageDecMgtBCImpl();
				command.manageWhfSend(event.getUsWhfSendVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg1040Event"))
			{
				EsmBkg1040Event event = (EsmBkg1040Event) e;
				command = new UsWharfageDecMgtBCImpl();
				command.manageWhfSend(event.getUsWhfSendVO(), account);
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
			throw new EventException(new ErrorHandler("BKG06087").getUserMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0122 : SEARCH<BR>
	 * ESM_BKG_0557 : SEARCH<BR>
	 * Wharfage 선박 정보 (ETD, MRN) 조회<BR>
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
			// 이벤트별 Impl생성
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
	 * 한국 WHF 신고 대상 BL을 분류 함 (면제 대상 등)<BR>
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
			// 이벤트별 Impl생성
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
	 * B/L 별 Wharfage 면제 정보 (면제 사유 등) 조회<BR>
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
			// 이벤트별 Impl생성
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
	 * Wharfage 면제 화주 목록 조회
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
			// 이벤트별 Impl생성
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
	 * BKG_HRD_CDG_CTNT 값 생성, 수정, 삭제
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
			// 이벤트별 Impl생성
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
	 * ESM_BKG_0749 : MODIFY01<BR>
	 * ESM_BKG_1040 : MODIFY01<BR>
	 * 팩스 이메일 보내기
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse sendWhfDecl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			// 이벤트별 Impl생성
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0749Event"))
			{
				command = new UsWharfageDecMgtBCImpl();
				EsmBkg0749Event event = (EsmBkg0749Event) e;
				// 수정하고
				command.manageWhfSend(event.getUsWhfSendVO(), account);
				// HISTORY
				List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs = event.getUsWhfSendVO().getBkgUsaWhfSndHisVOs();
				List<BkgUsaWhfSndHisVO> emlBkgUsaWhfSndHisVOs = new ArrayList<BkgUsaWhfSndHisVO>();
				List<BkgUsaWhfSndHisVO> faxBkgUsaWhfSndHisVOs = new ArrayList<BkgUsaWhfSndHisVO>();
				for (int i = 0; i < bkgUsaWhfSndHisVOs.size(); i++)
				{
					if (bkgUsaWhfSndHisVOs.get(i).getNtcViaCd().startsWith("M")
							&& bkgUsaWhfSndHisVOs.get(i).getCntcEml() != null
							&& !"".equals(bkgUsaWhfSndHisVOs.get(i).getCntcEml()))
					{
						emlBkgUsaWhfSndHisVOs.add(bkgUsaWhfSndHisVOs.get(i));
					}
					else if (bkgUsaWhfSndHisVOs.get(i).getNtcViaCd().startsWith("F")
							&& bkgUsaWhfSndHisVOs.get(i).getCntcFaxNo() != null
							&& !"".equals(bkgUsaWhfSndHisVOs.get(i).getCntcFaxNo()))
					{
						faxBkgUsaWhfSndHisVOs.add(bkgUsaWhfSndHisVOs.get(i));
					}
				}
				// 메일보냄
				if (emlBkgUsaWhfSndHisVOs.size() > 0)
					command.sendWhfDeclEml(emlBkgUsaWhfSndHisVOs, account);
				// 팩스보냄
				if (faxBkgUsaWhfSndHisVOs.size() > 0)
					command.sendWhfDeclFax(faxBkgUsaWhfSndHisVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
			}
			else if (e.getEventName().equalsIgnoreCase("EsmBkg1040Event"))
			{
				command = new UsWharfageDecMgtBCImpl();
				EsmBkg1040Event event = (EsmBkg1040Event) e;
				// 수정하고
				command.manageWhfSend(event.getUsWhfSendVO(), account);
				// 메일보냄
				command.sendWhfDeclEml(event.getUsWhfSendVO().getBkgUsaWhfSndHisVOs(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
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

	/**
	 * ESM_BKG_0749 : MODIFY02<BR>
	 * 팩스 이메일 보내기
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse sendWhfExptTs(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = null;
		try
		{
			// 이벤트별 Impl생성
			begin();
			command = new UsWharfageDecMgtBCImpl();
			EsmBkg0749Event event = (EsmBkg0749Event) e;
			// 수정하고
			command.manageWhfSend(event.getUsWhfSendVO(), account);
			// HISTORY
			List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs = event.getUsWhfSendVO().getBkgUsaWhfSndHisVOs();
			List<BkgUsaWhfSndHisVO> emlBkgUsaWhfSndHisVOs = new ArrayList<BkgUsaWhfSndHisVO>();
			List<BkgUsaWhfSndHisVO> faxBkgUsaWhfSndHisVOs = new ArrayList<BkgUsaWhfSndHisVO>();
			for (int i = 0; i < bkgUsaWhfSndHisVOs.size(); i++)
			{
				if (bkgUsaWhfSndHisVOs.get(i).getNtcViaCd().startsWith("M")
						&& bkgUsaWhfSndHisVOs.get(i).getCntcEml() != null
						&& !"".equals(bkgUsaWhfSndHisVOs.get(i).getCntcEml()))
				{
					emlBkgUsaWhfSndHisVOs.add(bkgUsaWhfSndHisVOs.get(i));
				}
				else if (bkgUsaWhfSndHisVOs.get(i).getNtcViaCd().startsWith("F")
						&& bkgUsaWhfSndHisVOs.get(i).getCntcFaxNo() != null
						&& !"".equals(bkgUsaWhfSndHisVOs.get(i).getCntcFaxNo()))
				{
					faxBkgUsaWhfSndHisVOs.add(bkgUsaWhfSndHisVOs.get(i));
				}
			}
			// 메일보냄
			if (emlBkgUsaWhfSndHisVOs.size() > 0)
				command.sendWhfExptTsEml(emlBkgUsaWhfSndHisVOs, account);
			// 팩스보냄
			if (faxBkgUsaWhfSndHisVOs.size() > 0)
				command.sendWhfExptTsFax(faxBkgUsaWhfSndHisVOs, account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
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
	 * ESM_BKG_0699 : MULTI<BR>
	 * B/L별 한국 Wharfage 면제 사유 및 면제 화주 등록 정보 수정<BR>
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
			// 이벤트별 Impl생성
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
	 * Wharfage 신고 대상 조회
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
			// 이벤트별 Impl생성
			EsmBkg0557Event event = (EsmBkg0557Event) e;
			KrWhfDecCondVO krWhfDecCondVO= ( KrWhfDecCondVO )event.getKrWhfDecCondVO();
			krWhfDecCondVO.setOfcCd(account.getOfc_cd());
			command = new KrWharfageDecMgtBCImpl();
			KrWhfDecContainerVO krWhfDecContainerVO = (KrWhfDecContainerVO) command.searchWhfDec(krWhfDecCondVO);
			command = new KrWharfageDecMgtBCImpl();
//			KrWhfDecContainerVO krWhfDecContainerVO = (KrWhfDecContainerVO) command.searchWhfDec(event
//					.getKrWhfDecCondVO());
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
				
				eventResponse.setETCData("ibts_amt", "0"); // I/B T/S Amount 무조건 0으로 셋
				eventResponse.setETCData("rduc_amt", bkgKrWhfVolVO.getRducAmt()); // 절사
				eventResponse.setETCData("comm_amt", bkgKrWhfVolVO.getCommAmt()); // COMMITION
				eventResponse.setETCData("port_nm", bkgKrWhfVolVO.getPortNm()); // 항만
				// 허가번호
				// bkgKrWhfVolVO.get
				eventResponse.setETCData("whf_ntc_no_yr", (krWhfDecVO.getWhfNtcNoYr() == null) ? "" : krWhfDecVO
						.getWhfNtcNoYr()); // 허가번호 1
				eventResponse.setETCData("whf_ntc_no_mon", (krWhfDecVO.getWhfNtcNoMon() == null) ? "" : krWhfDecVO
						.getWhfNtcNoMon()); // 허가번호 2
				eventResponse.setETCData("whf_ntc_no_seq", (krWhfDecVO.getWhfNtcNoSeq() == null) ? "" : krWhfDecVO
						.getWhfNtcNoSeq()); // 허가번호 3
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
	 * Wharfage 신고 내역 관리 (생성 / 정정 / 삭제)
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
			// 이벤트별 Impl생성
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
	 * Wharfage 신고 Check
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
			// 이벤트별 Impl생성
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
	 * Wharfage 신고
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
			// 이벤트별 Impl생성
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
		WharfageDecMgtBC command = new KrWharfageDecMgtBCImpl();
		
		EsmBkg0557Event event = (EsmBkg0557Event) e;
		String returnValues = "";
		String hisSeq = "";
		String actionFlg = "N";
		
		try
		{
			actionFlg = command.interfaceWhfDecChk(event.getKrWhfDecCondVO());
			if ( "Y".equals(actionFlg)){
				throw new EventException(new ErrorHandler("BKG00764",new String[]{"WHF DEC No."}).getMessage());
			}else if ( "0".equals(actionFlg)){
				throw new EventException(new ErrorHandler("BKG95010",new String[]{}).getMessage());
			}else{
				// BKG_KR_WHF_IF_HIS 테이블에 남기는 로직임.
				begin();
					hisSeq = command.interfaceWhfDecHis(event.getKrWhfDecCondVO(), returnValues, "I", hisSeq, account, "Y");
				commit();
				
				// 이벤트별 Impl생성
//				begin();
//				whfDecCondVO = command.interfaceWhfDec(event.getKrWhfDecCondVO(), account);
//				krWhfDecCondVO = (KrWhfDecCondVO)whfDecCondVO;
//				if ( "0".equals(krWhfDecCondVO.getKrWhfDecCnt())) {
//					rollback();
//					returnValues = new ErrorHandler("BKG95010",new String[]{}).getMessage();
//					throw new EventException(new ErrorHandler("BKG95010",new String[]{}).getMessage());
//				}
//				commit();	
				
				event.getKrWhfDecCondVO().setHisSeq(hisSeq);
				String key = command.startBackEndJob(account, event.getKrWhfDecCondVO(), "ESM_BKG_0557");
				eventResponse.setETCData("HISSEQ", hisSeq);
				eventResponse.setETCData("KEY", key);
			}
		}
		catch (EventException ex)
		{
			rollback();
			returnValues = ex.toString();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			returnValues = ex.toString();
			throw new EventException(new ErrorHandler("BKG06088").getUserMessage(), ex);
		} finally {
//			try {
//				if ( !"Y".equals(actionFlg)){
//					begin();
//						command.interfaceWhfDecHis(krWhfDecCondVO, returnValues, "U", hisSeq, account);
//					commit();
//				}
//			} catch (EventException ex) {
//				/******************************************************
//				 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
//				 ******************************************************/
//				rollback();
//				log.error("\n\n resultUpdb : EventException\n" + ex.toString(), ex);
//			} catch (Exception ex) {
//				/******************************************************
//				 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
//				 ******************************************************/
//				rollback();
//				log.error("\n\n resultUpdb : Exception\n" + ex.toString(), ex);
//			}
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0122 : COMMAND04<BR>
	 * ESM_BKG_0122 : COMMAND05<BR>
	 * ESM_BKG_0557 : COMMAND03<BR>
	 * 확정된 WHF 신고 금액을 AR로 인터페이스 함<BR>
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
			// 이벤트별 Impl생성
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
	

	/**
	 * ESM_BKG_0557 : COMMAND05<BR>
	 * Wharfage Interface Check
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageWhfHis(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WharfageDecMgtBC command = new KrWharfageDecMgtBCImpl();
		
		EsmBkg0557Event event = (EsmBkg0557Event) e;
		
		try
		{
			begin();
				command.interfaceWhfDecHis(event.getKrWhfDecCondVO(), event.getReturnValues(), "U", event.getHisSeq(), account, "N");
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