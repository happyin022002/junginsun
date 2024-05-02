/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoQuotationManageSC.java
*@FileTitle : SpecialCargoQuotationManageSC
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.18 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBC;
import com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.basic.SpecialCargoQuotationManageBC;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.basic.SpecialCargoQuotationManageBCImpl;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event.EsdTes0051Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event.EsdTes0052Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event.EsdTes0053Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event.EsdTes0054Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event.EsdTes0055Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event.EsdTes0056Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event.EsdTes0058Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event.EsdTes9051Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event.EsdTes9052Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event.EsdTes9053Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration.SpecialCargoQuotationManageDBDAO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.BbCgoApplVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.BbCntrListVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.BkgBbCgoVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.CntrTypzQtyVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesAwkCgoTrfMngVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesBbCgoCostVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesBbCgoDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUpldFileVO;
import com.hanjin.syscommon.common.table.TesAwkCgoAdonHdrVO;
import com.hanjin.syscommon.common.table.TesAwkCgoAdonTpSzVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfDtlVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfHdrVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfTpSzVO;


/**
 * ALPS-SpecialCargoQuotationManage Business Logic ServiceCommand - ALPS-SpecialCargoQuotationManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 이혜민
 * @see SpecialCargoQuotationManageDBDAO
 * @since J2EE 1.6
 */
public class SpecialCargoQuotationManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SpecialCargoQuotationManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("SpecialCargoQuotationManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SpecialCargoQuotationManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SpecialCargoQuotationManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SpecialCargoQuotationManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		/**
		 * Guarantee Creation & Adjustment
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAwkCgoBasicTrf(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAwkCgoTsTrf(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAwkCgoAddOnTrf(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkPort(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchTmlCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchCurrCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkMnYdFlg(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = setYearMonth(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = checkYdCdInputAuth(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = checkYdCdInputAuthAddon(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAwkCgoBasicTrf(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageAwkCgoTsTrf(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageAwkCgoAddOnTrf(e);
			}else {
				eventResponse = loadExcelAwkCgo(e); // 화면 최초 호출 시 실행
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTes0052Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAwkCgoBasicTrfHis(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTes0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAwkCgoTsTrfHis(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTes0054Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAwkCgoAddOnTrfHis(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTes0055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLoadUnloadExtCost(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTes0056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLoadUnloadTsExtCost(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTes0058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBbCargoInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBbCargoCostInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBbBkgNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBbCargoCostAmount(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTes9051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = verifyAwkCgoAddOnTrf(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageAwkCgoAddOnTrf2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUSDExchange(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkYdCdInputAuthAddon2(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTes9052Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = verifyAwkCgoBasicTrf(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageAwkCgoBasicTrf2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUSDExchange(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkYdCdInputAuth2(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTes9053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = verifyAwkCgoTsTrf(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageAwkCgoTsTrf2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUSDExchange(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkYdCdInputAuth2(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESD_TES_0051<br>
	 * AWK Cargo Basic Tariff를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkCgoBasicTrf(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0051Event	event = (EsdTes0051Event)e;

		try{
			eventResponse.setRsVoList(command.searchAwkCgoBasicTrf(event.getTesAwkCgoTrfMngVO()));
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
	 * ESD_TES_0051<br>
	 * AWK Cargo T/S Tariff를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkCgoTsTrf(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0051Event	event = (EsdTes0051Event)e;

		try{
			eventResponse.setRsVoList(command.searchAwkCgoTsTrf(event.getTesAwkCgoTrfMngVO()));
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
	 * ESD_TES_0051<br>
	 * AWK Cargo Add On Tariff를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkCgoAddOnTrf(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0051Event	event = (EsdTes0051Event)e;

		try{
			eventResponse.setRsVoList(command.searchAwkCgoAddOnTrf(event.getTesAwkCgoTrfMngVO()));
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
	 * ESD_TES_0051<br>
	 * AWK Cargo Basic Tariff를 insert, update, delete 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse manageAwkCgoBasicTrf(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0051Event	event = (EsdTes0051Event)e;
		
		TesAwkCgoTrfMngVO[] tesAwkCgoTrfMngVO = event.getTesAwkCgoTrfMngVOs();

		String lg_usr_id = account.getUsr_id();
		List insUpdHdrList = new ArrayList();
		List insUpdDtlList = new ArrayList();
		List insUpdTpszList = new ArrayList();
		List deleteHdrList = new ArrayList();
		List deleteDtlList = new ArrayList();
		List deleteTpszList = new ArrayList();
		
		try{
			// Basic Tab 일 경우	
			for(int i=0; i<tesAwkCgoTrfMngVO.length; i++){
				if(tesAwkCgoTrfMngVO[i].getActYdOfcAuthYn().equals("Y") && tesAwkCgoTrfMngVO[i].getChkAuthYn().equals("Y")){
					if(tesAwkCgoTrfMngVO[i].getIbflag().equals("U")||tesAwkCgoTrfMngVO[i].getIbflag().equals("I")){
						
						//헤더 VO
						TesAwkCgoTrfHdrVO tesAwkCgoTrfHdrVO = new TesAwkCgoTrfHdrVO();
						tesAwkCgoTrfHdrVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
						tesAwkCgoTrfHdrVO.setMnYdFlg(tesAwkCgoTrfMngVO[i].getMnYdFlg());
						tesAwkCgoTrfHdrVO.setUpdUsrId(lg_usr_id);
						
						insUpdHdrList.add(tesAwkCgoTrfHdrVO);
						
						//dtl VO
						TesAwkCgoTrfDtlVO tesAwkCgoTrfDtlVO = new TesAwkCgoTrfDtlVO();
						tesAwkCgoTrfDtlVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
						tesAwkCgoTrfDtlVO.setTmlAwkCgoTrfTpCd("B");
						tesAwkCgoTrfDtlVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
						tesAwkCgoTrfDtlVO.setIoGaCd("I");
						tesAwkCgoTrfDtlVO.setTmlAwkTsCd("S");
						tesAwkCgoTrfDtlVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
						tesAwkCgoTrfDtlVO.setTmlActCostSeq(tesAwkCgoTrfMngVO[i].getTmlActCostSeq());
						tesAwkCgoTrfDtlVO.setAplyRto(tesAwkCgoTrfMngVO[i].getAplyRto());
						tesAwkCgoTrfDtlVO.setCalcRmk(tesAwkCgoTrfMngVO[i].getCalcRmk());
						tesAwkCgoTrfDtlVO.setLstUpdUsrId(lg_usr_id);
						tesAwkCgoTrfDtlVO.setUpdUsrId(lg_usr_id);
						
						insUpdDtlList.add(tesAwkCgoTrfDtlVO);
						
						//tp_sz VO
						if(!tesAwkCgoTrfMngVO[i].getManLoclAmt20ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
							tesAwkCgoTrfTpSzVO.setIoGaCd("I");
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("M");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getManLoclCurrCd());
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getManLoclAmt20ft());
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getManUsdAmt20ft() );
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if(!tesAwkCgoTrfMngVO[i].getManLoclAmt40ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
							tesAwkCgoTrfTpSzVO.setIoGaCd("I");
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("M");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getManLoclCurrCd());
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getManLoclAmt40ft());
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getManUsdAmt40ft());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if(!tesAwkCgoTrfMngVO[i].getAutoUsdAmt20ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
							tesAwkCgoTrfTpSzVO.setIoGaCd("I");
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("A");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getAutoUsdAmt20ft());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if(!tesAwkCgoTrfMngVO[i].getAutoUsdAmt40ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
							tesAwkCgoTrfTpSzVO.setIoGaCd("I");
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("A");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getAutoUsdAmt40ft());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if(!tesAwkCgoTrfMngVO[i].getTtlLoclAmt20ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
							tesAwkCgoTrfTpSzVO.setIoGaCd("I");
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("T");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getTtlLoclCurrCd() );
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getTtlLoclAmt20ft() );
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getTtlUsdAmt20ft());

							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}

						if(!tesAwkCgoTrfMngVO[i].getTtlLoclAmt40ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
							tesAwkCgoTrfTpSzVO.setIoGaCd("I");
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("T");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getTtlLoclCurrCd());
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getTtlLoclAmt40ft());
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getTtlUsdAmt40ft());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}

						if(!tesAwkCgoTrfMngVO[i].getFmlLoclAmt20ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
							tesAwkCgoTrfTpSzVO.setIoGaCd("I");
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("F");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getFmlLoclCurrCd());
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getFmlLoclAmt20ft() );
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getFmlUsdAmt20ft());

							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}

						if(!tesAwkCgoTrfMngVO[i].getFmlLoclAmt40ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
							tesAwkCgoTrfTpSzVO.setIoGaCd("I");
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("F");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getFmlLoclCurrCd());
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getFmlLoclAmt40ft() );
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getFmlUsdAmt40ft());

							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}

						if(!tesAwkCgoTrfMngVO[i].getCalcUsdAmt20ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
							tesAwkCgoTrfTpSzVO.setIoGaCd("I");
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("C");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getCalcUsdAmt20ft());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}

						if(!tesAwkCgoTrfMngVO[i].getCalcUsdAmt40ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
							tesAwkCgoTrfTpSzVO.setIoGaCd("I");
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("C");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getCalcUsdAmt40ft());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						
						if(!tesAwkCgoTrfMngVO[i].getSumUsdAmt20ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
							tesAwkCgoTrfTpSzVO.setIoGaCd("I");
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("S");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getSumUsdAmt20ft());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}

						if(!tesAwkCgoTrfMngVO[i].getSumUsdAmt40ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
							tesAwkCgoTrfTpSzVO.setIoGaCd("I");
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("S");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getSumUsdAmt40ft());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						
					//삭제	
					}else if(tesAwkCgoTrfMngVO[i].getIbflag().equals("D")){
						//TP_SZ VO
						TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
						tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
						tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
						tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
						tesAwkCgoTrfTpSzVO.setIoGaCd("I");
						tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
						tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
						deleteTpszList.add(tesAwkCgoTrfTpSzVO);
						
						//dtl VO
						TesAwkCgoTrfDtlVO tesAwkCgoTrfDtlVO = new TesAwkCgoTrfDtlVO();
						tesAwkCgoTrfDtlVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
						tesAwkCgoTrfDtlVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
						tesAwkCgoTrfDtlVO.setTmlAwkCgoTrfTpCd("B");
						tesAwkCgoTrfDtlVO.setIoGaCd("I");
						tesAwkCgoTrfDtlVO.setTmlAwkTsCd("S");
						tesAwkCgoTrfDtlVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
						deleteDtlList.add(tesAwkCgoTrfDtlVO);
						
						//HDR VO
						TesAwkCgoTrfHdrVO tesAwkCgoTrfHdrVO = new TesAwkCgoTrfHdrVO();
						tesAwkCgoTrfHdrVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
						deleteHdrList.add(tesAwkCgoTrfHdrVO);
					}
				}	
			}
			//Delete
			if(deleteTpszList.size() > 0){
				begin();
				command.removeAwkCgoBasicTrfTpSz(deleteTpszList);
				command.removeAwkCgoBasicTrfDtl(deleteDtlList);
				command.removeAwkCgoBasicTrfHdr(deleteHdrList);
				commit();
			}
			//Update, Insert
			if(insUpdHdrList.size() > 0){

				begin();
				command.modifyAwkCgoBasicTrfHdr(insUpdHdrList);
				command.modifyAwkCgoBasicTrfDtl(insUpdDtlList);
				command.modifyAwkCgoBasicTrfTpSz(insUpdTpszList);
				commit();
			}
		}catch(EventException ex){
			rollback();
			log.error("rollback err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			rollback();
			log.error("rollback err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * ESD_TES_0051<br>
	 * AWK Cargo T/S Tariff를 insert, update, delete 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse manageAwkCgoTsTrf(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0051Event	event = (EsdTes0051Event)e;
		TesAwkCgoTrfMngVO[] tesAwkCgoTrfMngVO = event.getTesAwkCgoTrfMngVOs();

		String lg_usr_id = account.getUsr_id();
		List insUpdHdrList = new ArrayList();
		List insUpdDtlList = new ArrayList();
		List insUpdTpszList = new ArrayList();
		List deleteHdrList = new ArrayList();
		List deleteDtlList = new ArrayList();
		List deleteTpszList = new ArrayList();

		try{
			// T/S Tab 일 경우	
			for(int i=0; i<tesAwkCgoTrfMngVO.length; i++){
				if(tesAwkCgoTrfMngVO[i].getActYdOfcAuthYn().equals("Y") && tesAwkCgoTrfMngVO[i].getChkAuthYn().equals("Y")){
					if(tesAwkCgoTrfMngVO[i].getIbflag().equals("U")||tesAwkCgoTrfMngVO[i].getIbflag().equals("I")){
						//헤더 VO
						TesAwkCgoTrfHdrVO tesAwkCgoTrfHdrVO = new TesAwkCgoTrfHdrVO();
						tesAwkCgoTrfHdrVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
						tesAwkCgoTrfHdrVO.setUpdUsrId(lg_usr_id);
						
						insUpdHdrList.add(tesAwkCgoTrfHdrVO);

						//dtl VO
						TesAwkCgoTrfDtlVO tesAwkCgoTrfDtlVO = new TesAwkCgoTrfDtlVO();
						tesAwkCgoTrfDtlVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
						tesAwkCgoTrfDtlVO.setTmlAwkCgoTrfTpCd("T");
						tesAwkCgoTrfDtlVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
						tesAwkCgoTrfDtlVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
						tesAwkCgoTrfDtlVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
						tesAwkCgoTrfDtlVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
						tesAwkCgoTrfDtlVO.setTmlActCostSeq(tesAwkCgoTrfMngVO[i].getTmlActCostSeq());
						tesAwkCgoTrfDtlVO.setCalcRmk(tesAwkCgoTrfMngVO[i].getCalcRmk());
						tesAwkCgoTrfDtlVO.setLstUpdUsrId(lg_usr_id);
						tesAwkCgoTrfDtlVO.setUpdUsrId(lg_usr_id);
						
						insUpdDtlList.add(tesAwkCgoTrfDtlVO);
						
						//tp_sz VO
						if(!tesAwkCgoTrfMngVO[i].getManLoclAmt20ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("T");
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("M");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getManLoclCurrCd());
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getManLoclAmt20ft());
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getManUsdAmt20ft());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if(!tesAwkCgoTrfMngVO[i].getManLoclAmt40ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("T");
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("M");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getManLoclCurrCd());
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getManLoclAmt40ft());
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getManUsdAmt40ft());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if(!tesAwkCgoTrfMngVO[i].getAutoUsdAmt20ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("T");
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("A");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getAutoUsdAmt20ft());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if(!tesAwkCgoTrfMngVO[i].getAutoUsdAmt40ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("T");
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("A");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getAutoUsdAmt40ft());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						
						if(!tesAwkCgoTrfMngVO[i].getSumUsdAmt20ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("T");
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("S");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getSumUsdAmt20ft());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}

						if(!tesAwkCgoTrfMngVO[i].getSumUsdAmt40ft().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("T");
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("S");
							tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getSumUsdAmt40ft());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						
					//삭제	
					}else if(tesAwkCgoTrfMngVO[i].getIbflag().equals("D")){
						//TP_SZ VO
						TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
						tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
						tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
						tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("T");
						tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
						tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
						tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
						
						deleteTpszList.add(tesAwkCgoTrfTpSzVO);

						//dtl VO
						TesAwkCgoTrfDtlVO tesAwkCgoTrfDtlVO = new TesAwkCgoTrfDtlVO();
						tesAwkCgoTrfDtlVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
						tesAwkCgoTrfDtlVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
						tesAwkCgoTrfDtlVO.setTmlAwkCgoTrfTpCd("T");
						tesAwkCgoTrfDtlVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
						tesAwkCgoTrfDtlVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
						tesAwkCgoTrfDtlVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
						
						deleteDtlList.add(tesAwkCgoTrfDtlVO);
						
						//HDR VO
						TesAwkCgoTrfHdrVO tesAwkCgoTrfHdrVO = new TesAwkCgoTrfHdrVO();
						tesAwkCgoTrfHdrVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
						
						deleteHdrList.add(tesAwkCgoTrfHdrVO);
					}
				}	
			}
			//Delete
			if(deleteTpszList.size() > 0){
				begin();
				command.removeAwkCgoTsTrfTpSz(deleteTpszList);
				command.removeAwkCgoTsTrfDtl(deleteDtlList);
				command.removeAwkCgoTsTrfHdr(deleteHdrList);
				commit();
			}
			//Update, Insert
			if(insUpdHdrList.size() > 0){
				begin();
				command.modifyAwkCgoTsTrfHdr(insUpdHdrList);
				command.modifyAwkCgoTsTrfDtl(insUpdDtlList);
				command.modifyAwkCgoTsTrfTpSz(insUpdTpszList);
				commit();
			}
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_TES_0051<br>
	 * AWK Cargo Add-On Tariff를 insert, update, delete 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse manageAwkCgoAddOnTrf(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0051Event	event = (EsdTes0051Event)e;
		
		TesAwkCgoTrfMngVO[] tesAwkCgoTrfMngVO = event.getTesAwkCgoTrfMngVOs();

		String lg_usr_id = account.getUsr_id();
		List insUpdHdrList = new ArrayList();
		List insUpdTpszList = new ArrayList();
		List deleteHdrList = new ArrayList();
		List deleteTpszList = new ArrayList();

		try{
			for(int i=0; i<tesAwkCgoTrfMngVO.length; i++){
				if(tesAwkCgoTrfMngVO[i].getChkAuthYn().equals("Y")){
					if(tesAwkCgoTrfMngVO[i].getIbflag().equals("U")||tesAwkCgoTrfMngVO[i].getIbflag().equals("I")){
						//헤더 VO
						TesAwkCgoAdonHdrVO tesAwkCgoAdonHdrVO =  new TesAwkCgoAdonHdrVO();
						tesAwkCgoAdonHdrVO.setFmLocCd(tesAwkCgoTrfMngVO[i].getFmLocCd());
						tesAwkCgoAdonHdrVO.setFmNodYdNo(tesAwkCgoTrfMngVO[i].getFmNodYdNo());
						tesAwkCgoAdonHdrVO.setToLocCd(tesAwkCgoTrfMngVO[i].getToLocCd());
						tesAwkCgoAdonHdrVO.setToNodYdNo(tesAwkCgoTrfMngVO[i].getToNodYdNo());
						tesAwkCgoAdonHdrVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
						tesAwkCgoAdonHdrVO.setVndrNm(tesAwkCgoTrfMngVO[i].getVndrNm());
						tesAwkCgoAdonHdrVO.setCalcRmk(tesAwkCgoTrfMngVO[i].getCalcRmk());
						tesAwkCgoAdonHdrVO.setLstUpdUsrId(lg_usr_id);
						tesAwkCgoAdonHdrVO.setUpdUsrId(lg_usr_id);
						
						insUpdHdrList.add(tesAwkCgoAdonHdrVO);
						
						//tp_sz VO
						if(!tesAwkCgoTrfMngVO[i].getManUsdAmt20ft().equals("")){
							TesAwkCgoAdonTpSzVO tesAwkCgoAdonTpSzVO =  new TesAwkCgoAdonTpSzVO();
							
							tesAwkCgoAdonTpSzVO.setFmLocCd(tesAwkCgoTrfMngVO[i].getFmLocCd());
							tesAwkCgoAdonTpSzVO.setFmNodYdNo(tesAwkCgoTrfMngVO[i].getFmNodYdNo());
							tesAwkCgoAdonTpSzVO.setToLocCd(tesAwkCgoTrfMngVO[i].getToLocCd());
							tesAwkCgoAdonTpSzVO.setToNodYdNo(tesAwkCgoTrfMngVO[i].getToNodYdNo());
							tesAwkCgoAdonTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoAdonTpSzVO.setCntrSzCd("2");
							tesAwkCgoAdonTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getManUsdAmt20ft());
							tesAwkCgoAdonTpSzVO.setUpdUsrId(lg_usr_id);
							tesAwkCgoAdonTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getManLoclCurrCd());
							tesAwkCgoAdonTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getManLoclAmt20ft());
							tesAwkCgoAdonTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							
							insUpdTpszList.add(tesAwkCgoAdonTpSzVO);
						}
						if(!tesAwkCgoTrfMngVO[i].getManUsdAmt40ft().equals("")){
							TesAwkCgoAdonTpSzVO tesAwkCgoAdonTpSzVO =  new TesAwkCgoAdonTpSzVO();
							
							tesAwkCgoAdonTpSzVO.setFmLocCd(tesAwkCgoTrfMngVO[i].getFmLocCd());
							tesAwkCgoAdonTpSzVO.setFmNodYdNo(tesAwkCgoTrfMngVO[i].getFmNodYdNo());
							tesAwkCgoAdonTpSzVO.setToLocCd(tesAwkCgoTrfMngVO[i].getToLocCd());
							tesAwkCgoAdonTpSzVO.setToNodYdNo(tesAwkCgoTrfMngVO[i].getToNodYdNo());
							tesAwkCgoAdonTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
							tesAwkCgoAdonTpSzVO.setCntrSzCd("4");
							tesAwkCgoAdonTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getManUsdAmt40ft());
							tesAwkCgoAdonTpSzVO.setUpdUsrId(lg_usr_id);
							tesAwkCgoAdonTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getManLoclCurrCd());
							tesAwkCgoAdonTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getManLoclAmt40ft());
							tesAwkCgoAdonTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
							
							insUpdTpszList.add(tesAwkCgoAdonTpSzVO);
						}
					}else if(tesAwkCgoTrfMngVO[i].getIbflag().equals("D")){
						//TP_SZ VO
						TesAwkCgoAdonTpSzVO tesAwkCgoAdonTpSzVO =  new TesAwkCgoAdonTpSzVO();
						
						tesAwkCgoAdonTpSzVO.setFmLocCd(tesAwkCgoTrfMngVO[i].getFmLocCd());
						tesAwkCgoAdonTpSzVO.setFmNodYdNo(tesAwkCgoTrfMngVO[i].getFmNodYdNo());
						tesAwkCgoAdonTpSzVO.setToLocCd(tesAwkCgoTrfMngVO[i].getToLocCd());
						tesAwkCgoAdonTpSzVO.setToNodYdNo(tesAwkCgoTrfMngVO[i].getToNodYdNo());
						tesAwkCgoAdonTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());

						deleteTpszList.add(tesAwkCgoAdonTpSzVO);
						//Hdr VO
						TesAwkCgoAdonHdrVO tesAwkCgoAdonHdrVO =  new TesAwkCgoAdonHdrVO();
						tesAwkCgoAdonHdrVO.setFmLocCd(tesAwkCgoTrfMngVO[i].getFmLocCd());
						tesAwkCgoAdonHdrVO.setFmNodYdNo(tesAwkCgoTrfMngVO[i].getFmNodYdNo());
						tesAwkCgoAdonHdrVO.setToLocCd(tesAwkCgoTrfMngVO[i].getToLocCd());
						tesAwkCgoAdonHdrVO.setToNodYdNo(tesAwkCgoTrfMngVO[i].getToNodYdNo());
						tesAwkCgoAdonHdrVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
						
						deleteHdrList.add(tesAwkCgoAdonHdrVO);	
					}
				}	
			}
			//Delete
			if(deleteTpszList.size() > 0){
				begin();
				command.removeAwkCgoAddOnTrfTpSz(deleteTpszList);
				command.removeAwkCgoAddOnTrfHdr(deleteHdrList);
				commit();
			}
			//Update, Insert
			if(insUpdHdrList.size() > 0){
				begin();
				command.modifyAwkCgoAddOnTrfHdr(insUpdHdrList);
				command.modifyAwkCgoAddOnTrfTpSz(insUpdTpszList);
				commit();
			}
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_TES_0051<br>
	 * Port Code 존재유무를 확인한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPort(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0051Event	event = (EsdTes0051Event)e;
		TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO = null;
		
		try{
			tesAwkCgoTrfMngVO = event.getTesAwkCgoTrfMngVO();
			String chkPort = command.checkPort(tesAwkCgoTrfMngVO.getYdCd());

			eventResponse.setETCData("check_port", chkPort);
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
	 * ESD_TES_0051<br>
	 * 해당 Port에 해당하는 Terminal을 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTmlCd(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0051Event	event = (EsdTes0051Event)e;
		TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO = null;
		tesAwkCgoTrfMngVO = event.getTesAwkCgoTrfMngVO();
		List<TesAwkCgoTrfMngVO> yardList = null;
		StringBuilder sb = null;
		
		try{
			yardList = command.searchTmlCd(tesAwkCgoTrfMngVO.getYdCd());

			if(yardList != null && yardList.size()>0){
				sb = new StringBuilder();

				TesAwkCgoTrfMngVO vo = yardList.get(0);

				sb.append(vo.getTmlCd());
				for (int i = 1; i < yardList.size(); i++) {
					sb.append("|");
					sb.append(yardList.get(i).getTmlCd());
				}
				eventResponse.setETCData("tml_cd", sb.toString());
			}
			
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
	 * ESD_TES_0051<br>
	 * Currency Code를 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrCd(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<TesAwkCgoTrfMngVO> currCd = null;
		StringBuilder sb = null;
		
		try{
			currCd = command.searchCurrCd();

			if(currCd != null && currCd.size()>0){
				sb = new StringBuilder();

				TesAwkCgoTrfMngVO vo = currCd.get(0);

				sb.append(vo.getManLoclCurrCd());
				for (int i = 1; i < currCd.size(); i++) {
					sb.append("|");
					sb.append(currCd.get(i).getManLoclCurrCd());
				}
				eventResponse.setETCData("curr_cd", sb.toString());
			}
			
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
	 * ESD_TES_0051<br>
	 * Main Yard 존재유무를 확인한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkMnYdFlg(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0051Event	event = (EsdTes0051Event)e;
		TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO = null;
		
		try{
			tesAwkCgoTrfMngVO = event.getTesAwkCgoTrfMngVO();
			String mnYd = command.checkMnYdFlg(tesAwkCgoTrfMngVO.getYdCd());

			eventResponse.setETCData("mn_yd", mnYd);
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
	 * ESD_TES_0051<br>
	 * 최근 Batch가 실행된 Year Month 를 가져온다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse setYearMonth(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			String ym = command.setYearMonth();

			eventResponse.setETCData("year_month", ym);
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
	 * ESD_TES_0051<br>
	 * Sheet에 입력한 Port+Tml Cd와 로그인 오피스를 비교하여 입력 권한을 체크한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkYdCdInputAuth(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0051Event	event = (EsdTes0051Event)e;
		
		try{
			String chk_flg = command.checkYdCdInputAuth(event.getTesAwkCgoTrfMngVO().getYdCd(), event.getTesAwkCgoTrfMngVO().getLgOfcCd());

			eventResponse.setETCData("chk_flg", chk_flg);
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
	 * ESD_TES_0051<br>
	 * Sheet에 입력한 Port+Tml Cd와 로그인 오피스를 비교하여 입력 권한을 체크한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkYdCdInputAuthAddon(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0051Event	event = (EsdTes0051Event)e;
		
		try{
			String chk_flg = command.checkYdCdInputAuthAddon(event.getTesAwkCgoTrfMngVO().getFmYdCd(), event.getTesAwkCgoTrfMngVO().getToYdCd(), event.getTesAwkCgoTrfMngVO().getLgOfcCd());

			eventResponse.setETCData("chk_flg", chk_flg);
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
	 * ESD_TES_0052<br>
	 * AWK Cargo Basic Tariff History를 조회한다.<br>
	 *  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkCgoBasicTrfHis(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0052Event	event = (EsdTes0052Event)e;

		try{
			eventResponse.setRsVoList(command.searchAwkCgoBasicTrfHis(event.getTesAwkCgoTrfMngVO()));
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
	 * ESD_TES_0053<br>
	 * AWK Cargo T/S Tariff History를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkCgoTsTrfHis(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0053Event	event = (EsdTes0053Event)e;

		try{
			eventResponse.setRsVoList(command.searchAwkCgoTsTrfHis(event.getTesAwkCgoTrfMngVO()));
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
	 * ESD_TES_0054<br>
	 * AWK Cargo Add-On Tariff History를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkCgoAddOnTrfHis(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0054Event	event = (EsdTes0054Event)e;

		try{
			eventResponse.setRsVoList(command.searchAwkCgoAddOnTrfHis(event.getTesAwkCgoTrfMngVO()));
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
	 * ESD_TES_0055<br>
	 * Load / Unload Extra Cost를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoadUnloadExtCost(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0055Event	event = (EsdTes0055Event)e;

		try{
			eventResponse.setRsVoList(command.searchLoadUnloadExtCost(event.getAwkCgoExtraCostByRouteVO()));
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
	 * ESD_TES_0056<br>
	 * Load / Unload T/S Extra Cost를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoadUnloadTsExtCost(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0056Event	event = (EsdTes0056Event)e;

		try{
			eventResponse.setRsVoList(command.searchLoadUnloadTsExtCost(event.getAwkCgoExtraCostByRouteVO()));
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
	 * ESD_TES_0058<br>
	 * BB Booking Information을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBbCargoInfo(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0058Event	event = (EsdTes0058Event)e;
		String bkgNo      = event.getBkgNo();

		try{
			BbCgoApplVO applVo = new BbCgoApplVO();
			BlCustomerInfoVO blCustomerInfoVO = new BlCustomerInfoVO();
			
        	applVo = command.searchBbCargoInfo(bkgNo);    
        	blCustomerInfoVO = command.searchBkgCustomer(bkgNo);    
        	
            List<BkgBbCgoVO> bkgBbCgo = applVo.getBkgBbCgoVO();
            List<BbCntrListVO> bbCntrList = applVo.getBbCntrListVO();
            List<CntrTypzQtyVO> typzQtys = applVo.getCntrTypzQty();
            eventResponse.setRsVoList(bkgBbCgo);
            eventResponse.setRsVoList(typzQtys);
            eventResponse.setRsVoList(bbCntrList);
            //eventResponse.setRsVo(blCustomerInfoVO);
            
            if(blCustomerInfoVO != null ){
     		    eventResponse.setETCData("s_cust_cnt_cd", blCustomerInfoVO.getSCustCntCd());
     		    eventResponse.setETCData("s_cust_seq", blCustomerInfoVO.getSCustSeq());
     		    eventResponse.setETCData("s_cust_nm", blCustomerInfoVO.getSCustNm());
	     	    eventResponse.setETCData("c_cust_cnt_cd", blCustomerInfoVO.getCCustCntCd());
	     		eventResponse.setETCData("c_cust_seq", blCustomerInfoVO.getCCustSeq());
	     		eventResponse.setETCData("c_cust_nm", blCustomerInfoVO.getCCustNm());
	     		eventResponse.setETCData("n_cust_cnt_cd", blCustomerInfoVO.getFCustCntCd());
	     		eventResponse.setETCData("n_cust_seq", blCustomerInfoVO.getFCustSeq());
	     		eventResponse.setETCData("n_cust_nm", blCustomerInfoVO.getFCustNm());
     	   }
            
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
	 * ESD_TES_0058<br>
	 * BB Booking Cost Information을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBbCargoCostInfo(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0058Event	event = (EsdTes0058Event)e;

		try{
			eventResponse.setRsVoList(command.searchBbCargoCostInfo(event.getTesBbCgoCostVO()));
            
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
	 * ESD_TES_0058<br>
	 * BB Booking No을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBbBkgNo(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0058Event	event = (EsdTes0058Event)e;

		try{
			eventResponse.setRsVoList(command.searchBbBkgNo(event.getTesBbCgoCostVO()));
            
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
	 * ESD_TES_0058<br>
	 * BB Cargo Amount 를 insert, update한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBbCargoCostAmount(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0058Event	event = (EsdTes0058Event)e;
		TesBbCgoCostVO[] tesBbCgoCostVOs = event.getTesBbCgoCostVOs();
		TesBbCgoDtlVO[] tesBbCgoDtlVOs = event.getTesBbCgoDtlVOs();

		try{
			command.manageBbCargoCostAmount(tesBbCgoCostVOs, tesBbCgoDtlVOs, account);
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
	 * ESD_TES_0051 : Load Page <br>
	 * 화면 로딩시 Excel template을 loading. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadExcelAwkCgo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TESCommonBC command1 = new TESCommonBCImpl();
		StringBuffer fileKey = new StringBuffer();
		
		try{
			// Excel Template File Key
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();

			comUpldFileVO.setFileUpldNm("TES_Awk_Cgo_Basic.xlsx");
			fileKey.append(command1.searchExcelTemplateFileKey(comUpldFileVO) + "@");

			comUpldFileVO.setFileUpldNm("TES_Awk_Cgo_TS.xlsx");
			fileKey.append(command1.searchExcelTemplateFileKey(comUpldFileVO)+ "@");

			comUpldFileVO.setFileUpldNm("TES_Awk_Cgo_Addon.xlsx");
			fileKey.append(command1.searchExcelTemplateFileKey(comUpldFileVO));
			
			eventResponse.setCustomData("templateKey", fileKey);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESD_TES_9051<br>
	 * AWK Cargo Add On Tariff를 Verify한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyAwkCgoAddOnTrf(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes9051Event	event = (EsdTes9051Event)e;

		try{
			String vrfy_rslt = command.verifyAwkCgoAddOnTrf(event.getTesAwkCgoTrfMngVO());
			
			eventResponse.setETCData("vrfy_rslt", vrfy_rslt);
			
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
	 * ESD_TES_9051<br>
	 * AWK Cargo Add On Tariff의 local curr를 USD로 바꾼다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("null")
	private EventResponse searchUSDExchange(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		EventResponse eventResponse = new GeneralEventResponse();
		TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO = new TesAwkCgoTrfMngVO();
		EsdTes9051Event	event = (EsdTes9051Event)e;

		try{
			tesAwkCgoTrfMngVO = command.searchUSDExchange(event.getTesAwkCgoTrfMngVO());
		   
			if(tesAwkCgoTrfMngVO != null ){
     		    eventResponse.setETCData("man_usd_amt_20ft", tesAwkCgoTrfMngVO.getManUsdAmt20ft()); 
     		    eventResponse.setETCData("man_usd_amt_40ft", tesAwkCgoTrfMngVO.getManUsdAmt40ft());
     	   	} else {
    		    eventResponse.setETCData("man_usd_amt_20ft", "");
     		    eventResponse.setETCData("man_usd_amt_40ft", "");
     	   	}
			
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
	 * ESD_TES_9052<br>
	 * AWK Cargo Basic Tariff를 Verify한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyAwkCgoBasicTrf(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes9052Event	event = (EsdTes9052Event)e;

		try{
			String vrfy_rslt = command.verifyAwkCgoBasicTrf(event.getTesAwkCgoTrfMngVO());
			
			eventResponse.setETCData("vrfy_rslt", vrfy_rslt);
			
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
	 * ESD_TES_9053<br>
	 * AWK Cargo T/S Tariff를 Verify한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyAwkCgoTsTrf(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes9053Event	event = (EsdTes9053Event)e;

		try{
			String vrfy_rslt = command.verifyAwkCgoTsTrf(event.getTesAwkCgoTrfMngVO());
			
			eventResponse.setETCData("vrfy_rslt", vrfy_rslt);
			
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
	 * ESD_TES_9051<br>
	 * AWK Cargo Add-On Tariff를 Excel upload를 이용하여 insert, update 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse manageAwkCgoAddOnTrf2(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes9051Event	event = (EsdTes9051Event)e;
		
		TesAwkCgoTrfMngVO[] tesAwkCgoTrfMngVO = event.getTesAwkCgoTrfMngVOs();

		String lg_usr_id = account.getUsr_id();
		List insUpdHdrList = new ArrayList();
		List insUpdTpszList = new ArrayList();

		try{
			for(int i=0; i<tesAwkCgoTrfMngVO.length; i++){
				//헤더 VO
				TesAwkCgoAdonHdrVO tesAwkCgoAdonHdrVO =  new TesAwkCgoAdonHdrVO();
				tesAwkCgoAdonHdrVO.setFmLocCd(tesAwkCgoTrfMngVO[i].getFmLocCd());
				tesAwkCgoAdonHdrVO.setFmNodYdNo(tesAwkCgoTrfMngVO[i].getFmNodYdNo());
				tesAwkCgoAdonHdrVO.setToLocCd(tesAwkCgoTrfMngVO[i].getToLocCd());
				tesAwkCgoAdonHdrVO.setToNodYdNo(tesAwkCgoTrfMngVO[i].getToNodYdNo());
				tesAwkCgoAdonHdrVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
				tesAwkCgoAdonHdrVO.setVndrNm(tesAwkCgoTrfMngVO[i].getVndrNm());
				tesAwkCgoAdonHdrVO.setCalcRmk(tesAwkCgoTrfMngVO[i].getCalcRmk());
				tesAwkCgoAdonHdrVO.setLstUpdUsrId(lg_usr_id);
				tesAwkCgoAdonHdrVO.setUpdUsrId(lg_usr_id);
				
				insUpdHdrList.add(tesAwkCgoAdonHdrVO);
				
				//tp_sz VO
				if(!tesAwkCgoTrfMngVO[i].getManUsdAmt20ft().equals("")){
					TesAwkCgoAdonTpSzVO tesAwkCgoAdonTpSzVO =  new TesAwkCgoAdonTpSzVO();
					
					tesAwkCgoAdonTpSzVO.setFmLocCd(tesAwkCgoTrfMngVO[i].getFmLocCd());
					tesAwkCgoAdonTpSzVO.setFmNodYdNo(tesAwkCgoTrfMngVO[i].getFmNodYdNo());
					tesAwkCgoAdonTpSzVO.setToLocCd(tesAwkCgoTrfMngVO[i].getToLocCd());
					tesAwkCgoAdonTpSzVO.setToNodYdNo(tesAwkCgoTrfMngVO[i].getToNodYdNo());
					tesAwkCgoAdonTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoAdonTpSzVO.setCntrSzCd("2");
					tesAwkCgoAdonTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getManUsdAmt20ft());
					tesAwkCgoAdonTpSzVO.setUpdUsrId(lg_usr_id);
					tesAwkCgoAdonTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getManLoclCurrCd());
					tesAwkCgoAdonTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getManLoclAmt20ft());
					tesAwkCgoAdonTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					
					insUpdTpszList.add(tesAwkCgoAdonTpSzVO);
				}
				if(!tesAwkCgoTrfMngVO[i].getManUsdAmt40ft().equals("")){
					TesAwkCgoAdonTpSzVO tesAwkCgoAdonTpSzVO =  new TesAwkCgoAdonTpSzVO();
					
					tesAwkCgoAdonTpSzVO.setFmLocCd(tesAwkCgoTrfMngVO[i].getFmLocCd());
					tesAwkCgoAdonTpSzVO.setFmNodYdNo(tesAwkCgoTrfMngVO[i].getFmNodYdNo());
					tesAwkCgoAdonTpSzVO.setToLocCd(tesAwkCgoTrfMngVO[i].getToLocCd());
					tesAwkCgoAdonTpSzVO.setToNodYdNo(tesAwkCgoTrfMngVO[i].getToNodYdNo());
					tesAwkCgoAdonTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoAdonTpSzVO.setCntrSzCd("4");
					tesAwkCgoAdonTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getManUsdAmt40ft());
					tesAwkCgoAdonTpSzVO.setUpdUsrId(lg_usr_id);
					tesAwkCgoAdonTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getManLoclCurrCd());
					tesAwkCgoAdonTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getManLoclAmt40ft());
					tesAwkCgoAdonTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					
					insUpdTpszList.add(tesAwkCgoAdonTpSzVO);
				}
			}
			
			//Update, Insert
			if(insUpdHdrList.size() > 0){
				begin();
				command.modifyAwkCgoAddOnTrfHdr(insUpdHdrList);
				command.modifyAwkCgoAddOnTrfTpSz(insUpdTpszList);
				commit();
			}
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_TES_9053<br>
	 * AWK Cargo T/S Tariff를 insert, update 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse manageAwkCgoTsTrf2(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes9053Event	event = (EsdTes9053Event)e;
		TesAwkCgoTrfMngVO[] tesAwkCgoTrfMngVO = event.getTesAwkCgoTrfMngVOs();

		String lg_usr_id    = account.getUsr_id();
		List insUpdHdrList  = new ArrayList();
		List insUpdDtlList  = new ArrayList();
		List insUpdTpszList = new ArrayList();

		try{
			// T/S Tab 일 경우	
			for(int i=0; i<tesAwkCgoTrfMngVO.length; i++){
				//헤더 VO
				TesAwkCgoTrfHdrVO tesAwkCgoTrfHdrVO = new TesAwkCgoTrfHdrVO();
				tesAwkCgoTrfHdrVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
				tesAwkCgoTrfHdrVO.setUpdUsrId(lg_usr_id);
				
				insUpdHdrList.add(tesAwkCgoTrfHdrVO);

				//dtl VO
				TesAwkCgoTrfDtlVO tesAwkCgoTrfDtlVO = new TesAwkCgoTrfDtlVO();
				tesAwkCgoTrfDtlVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
				tesAwkCgoTrfDtlVO.setTmlAwkCgoTrfTpCd("T");
				tesAwkCgoTrfDtlVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
				tesAwkCgoTrfDtlVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
				tesAwkCgoTrfDtlVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
				tesAwkCgoTrfDtlVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
				tesAwkCgoTrfDtlVO.setTmlActCostSeq(tesAwkCgoTrfMngVO[i].getTmlActCostSeq());
				tesAwkCgoTrfDtlVO.setCalcRmk(tesAwkCgoTrfMngVO[i].getCalcRmk());
				tesAwkCgoTrfDtlVO.setLstUpdUsrId(lg_usr_id);
				tesAwkCgoTrfDtlVO.setUpdUsrId(lg_usr_id);
				
				insUpdDtlList.add(tesAwkCgoTrfDtlVO);
				
				//tp_sz VO
				if(!tesAwkCgoTrfMngVO[i].getManLoclAmt20ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("T");
					tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("M");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
					tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getManLoclCurrCd());
					tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getManLoclAmt20ft());
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getManUsdAmt20ft());
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}
				if(!tesAwkCgoTrfMngVO[i].getManLoclAmt40ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("T");
					tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("M");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
					tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getManLoclCurrCd());
					tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getManLoclAmt40ft());
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getManUsdAmt40ft());
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}
				if(!tesAwkCgoTrfMngVO[i].getAutoUsdAmt20ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("T");
					tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("A");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getAutoUsdAmt20ft());
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}
				if(!tesAwkCgoTrfMngVO[i].getAutoUsdAmt40ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("T");
					tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("A");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getAutoUsdAmt40ft());
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}
				
				if(!tesAwkCgoTrfMngVO[i].getSumUsdAmt20ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("T");
					tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("S");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getSumUsdAmt20ft());
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}

				if(!tesAwkCgoTrfMngVO[i].getSumUsdAmt40ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("T");
					tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO[i].getIoGaCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO[i].getTmlAwkTsCd());
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("S");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getSumUsdAmt40ft());
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}
			}
			
			//Update, Insert
			if(insUpdHdrList.size() > 0){
				begin();
				command.modifyAwkCgoTsTrfHdr(insUpdHdrList);
				command.modifyAwkCgoTsTrfDtl(insUpdDtlList);
				command.modifyAwkCgoTsTrfTpSz(insUpdTpszList);
				commit();
			}
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_TES_9052<br>
	 * AWK Cargo Basic Tariff를 insert, update 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse manageAwkCgoBasicTrf2(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes9052Event	event = (EsdTes9052Event)e;
		
		TesAwkCgoTrfMngVO[] tesAwkCgoTrfMngVO = event.getTesAwkCgoTrfMngVOs();

		String lg_usr_id = account.getUsr_id();
		List insUpdHdrList = new ArrayList();
		List insUpdDtlList = new ArrayList();
		List insUpdTpszList = new ArrayList();
		
		try{
			// Basic Tab 일 경우	
			for(int i=0; i<tesAwkCgoTrfMngVO.length; i++){
						
				//헤더 VO
				TesAwkCgoTrfHdrVO tesAwkCgoTrfHdrVO = new TesAwkCgoTrfHdrVO();
				tesAwkCgoTrfHdrVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
				tesAwkCgoTrfHdrVO.setMnYdFlg(tesAwkCgoTrfMngVO[i].getMnYdFlg());
				tesAwkCgoTrfHdrVO.setUpdUsrId(lg_usr_id);
				
				insUpdHdrList.add(tesAwkCgoTrfHdrVO);
				
				//dtl VO
				TesAwkCgoTrfDtlVO tesAwkCgoTrfDtlVO = new TesAwkCgoTrfDtlVO();
				tesAwkCgoTrfDtlVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
				tesAwkCgoTrfDtlVO.setTmlAwkCgoTrfTpCd("B");
				tesAwkCgoTrfDtlVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
				tesAwkCgoTrfDtlVO.setIoGaCd("I");
				tesAwkCgoTrfDtlVO.setTmlAwkTsCd("S");
				tesAwkCgoTrfDtlVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
				tesAwkCgoTrfDtlVO.setTmlActCostSeq(tesAwkCgoTrfMngVO[i].getTmlActCostSeq());
				tesAwkCgoTrfDtlVO.setAplyRto(tesAwkCgoTrfMngVO[i].getAplyRto());
				tesAwkCgoTrfDtlVO.setCalcRmk(tesAwkCgoTrfMngVO[i].getCalcRmk());
				tesAwkCgoTrfDtlVO.setLstUpdUsrId(lg_usr_id);
				tesAwkCgoTrfDtlVO.setUpdUsrId(lg_usr_id);
				
				insUpdDtlList.add(tesAwkCgoTrfDtlVO);
				
				//tp_sz VO
				if(!tesAwkCgoTrfMngVO[i].getManLoclAmt20ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
					tesAwkCgoTrfTpSzVO.setIoGaCd("I");
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("M");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
					tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getManLoclCurrCd());
					tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getManLoclAmt20ft());
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getManUsdAmt20ft() );
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}
				if(!tesAwkCgoTrfMngVO[i].getManLoclAmt40ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
					tesAwkCgoTrfTpSzVO.setIoGaCd("I");
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("M");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
					tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getManLoclCurrCd());
					tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getManLoclAmt40ft());
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getManUsdAmt40ft());
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}
				if(!tesAwkCgoTrfMngVO[i].getAutoUsdAmt20ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
					tesAwkCgoTrfTpSzVO.setIoGaCd("I");
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("A");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getAutoUsdAmt20ft());
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}
				if(!tesAwkCgoTrfMngVO[i].getAutoUsdAmt40ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
					tesAwkCgoTrfTpSzVO.setIoGaCd("I");
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("A");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getAutoUsdAmt40ft());
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}
				if(!tesAwkCgoTrfMngVO[i].getTtlLoclAmt20ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
					tesAwkCgoTrfTpSzVO.setIoGaCd("I");
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("T");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
					tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getTtlLoclCurrCd() );
					tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getTtlLoclAmt20ft() );
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getTtlUsdAmt20ft());

					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}

				if(!tesAwkCgoTrfMngVO[i].getTtlLoclAmt40ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
					tesAwkCgoTrfTpSzVO.setIoGaCd("I");
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("T");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
					tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getTtlLoclCurrCd());
					tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getTtlLoclAmt40ft());
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getTtlUsdAmt40ft());
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}

				if(!tesAwkCgoTrfMngVO[i].getFmlLoclAmt20ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
					tesAwkCgoTrfTpSzVO.setIoGaCd("I");
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("F");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
					tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getFmlLoclCurrCd());
					tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getFmlLoclAmt20ft() );
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getFmlUsdAmt20ft());

					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}

				if(!tesAwkCgoTrfMngVO[i].getFmlLoclAmt40ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
					tesAwkCgoTrfTpSzVO.setIoGaCd("I");
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("F");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
					tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO[i].getFmlLoclCurrCd());
					tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO[i].getFmlLoclAmt40ft() );
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getFmlUsdAmt40ft());

					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}

				if(!tesAwkCgoTrfMngVO[i].getCalcUsdAmt20ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
					tesAwkCgoTrfTpSzVO.setIoGaCd("I");
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("C");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getCalcUsdAmt20ft());
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}

				if(!tesAwkCgoTrfMngVO[i].getCalcUsdAmt40ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
					tesAwkCgoTrfTpSzVO.setIoGaCd("I");
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("C");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getCalcUsdAmt40ft());
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}
				
				if(!tesAwkCgoTrfMngVO[i].getSumUsdAmt20ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
					tesAwkCgoTrfTpSzVO.setIoGaCd("I");
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("S");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("2");
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getSumUsdAmt20ft());
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}

				if(!tesAwkCgoTrfMngVO[i].getSumUsdAmt40ft().equals("")){
					TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
					tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO[i].getYdCd());
					tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO[i].getIoBndCd());
					tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd("B");
					tesAwkCgoTrfTpSzVO.setIoGaCd("I");
					tesAwkCgoTrfTpSzVO.setTmlAwkTsCd("S");
					tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO[i].getCondNo());
					tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO[i].getUsdXchDt());
					tesAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
					
					tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd("S");
					tesAwkCgoTrfTpSzVO.setCntrTpszCd("4");
					tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO[i].getSumUsdAmt40ft());
					insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
				}
			}			
			//Update, Insert
			if(insUpdHdrList.size() > 0){

				begin();
				command.modifyAwkCgoBasicTrfHdr(insUpdHdrList);
				command.modifyAwkCgoBasicTrfDtl(insUpdDtlList);
				command.modifyAwkCgoBasicTrfTpSz(insUpdTpszList);
				commit();
			}
		}catch(EventException ex){
			rollback();
			log.error("rollback err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			rollback();
			log.error("rollback err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_TES_9052<br>
	 * Sheet에 입력한 Port+Tml Cd와 로그인 오피스를 비교하여 입력 권한을 체크한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkYdCdInputAuth2(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes9052Event	event = (EsdTes9052Event)e;
		
		try{
			String chk_flg = command.checkYdCdInputAuth(event.getTesAwkCgoTrfMngVO().getYdCd(), event.getTesAwkCgoTrfMngVO().getLgOfcCd());

			eventResponse.setETCData("chk_flg", chk_flg);
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
	 * ESD_TES_9051<br>
	 * Sheet에 입력한 Port+Tml Cd와 로그인 오피스를 비교하여 입력 권한을 체크한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkYdCdInputAuthAddon2(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes9051Event	event = (EsdTes9051Event)e;
		
		try{
			String chk_flg = command.checkYdCdInputAuthAddon(event.getTesAwkCgoTrfMngVO().getFmYdCd(), event.getTesAwkCgoTrfMngVO().getToYdCd(), event.getTesAwkCgoTrfMngVO().getLgOfcCd());

			eventResponse.setETCData("chk_flg", chk_flg);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
}