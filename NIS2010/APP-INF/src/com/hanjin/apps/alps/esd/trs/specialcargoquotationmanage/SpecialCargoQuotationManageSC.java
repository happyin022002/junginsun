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
package com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.basic.SpecialCargoQuotationManageBC;
import com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.basic.SpecialCargoQuotationManageBCImpl;
import com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.event.EsdTrs0250Event;
import com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.event.EsdTrs0251Event;
import com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.event.EsdTrs0252Event;
import com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.integration.SpecialCargoQuotationManageDBDAO;
import com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.vo.TrsAwkCgoTrfMngVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TrsAwkCgoTrfHdrVO;
import com.hanjin.syscommon.common.table.TrsAwkCgoTrfTpSzVO;


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
		if (e.getEventName().equalsIgnoreCase("EsdTrs0250Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAwkCgoShuttleTrf(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkPort(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTmlCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCurrCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = setYearMonth(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkUsdConvert(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkYdCdInputAuth(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAwkCgoShuttleTrf(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0251Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAwkCgoShuttleTrfHis(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0252Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLoadUnloadShuttleExtCost(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESD_TRS_0250<br>
	 * AWK Cargo Shuttle Tariff를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkCgoShuttleTrf(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0250Event	event = (EsdTrs0250Event)e;

		try{
			eventResponse.setRsVoList(command.searchAwkCgoShuttleTrf(event.getTrsAwkCgoTrfMngVO()));
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
	 * ESD_TRS_0250<br>
	 * AWK Cargo Shuttle Tariff를 insert, update, delete 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse manageAwkCgoShuttleTrf(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0250Event	event = (EsdTrs0250Event)e;
		TrsAwkCgoTrfMngVO[] trsAwkCgoTrfMngVOs = event.getTrsAwkCgoTrfMngVOs();

		String lg_usr_id = account.getUsr_id();
		List insUpdHdrList = new ArrayList();
		List insUpdTpszList = new ArrayList();
		List deleteHdrList = new ArrayList();
		List deleteTpszList = new ArrayList();
		
		try{
			for(int i=0; i<trsAwkCgoTrfMngVOs.length; i++){
				if(trsAwkCgoTrfMngVOs[i].getActYdOfcAuthYn().equals("Y") && trsAwkCgoTrfMngVOs[i].getChkAuthYn().equals("Y")){
					if(trsAwkCgoTrfMngVOs[i].getIbflag().equals("U")||trsAwkCgoTrfMngVOs[i].getIbflag().equals("I")){
						//Hdr VO
						TrsAwkCgoTrfHdrVO trsAwkCgoTrfHdrVO =  new TrsAwkCgoTrfHdrVO();
						trsAwkCgoTrfHdrVO.setFmLocCd(trsAwkCgoTrfMngVOs[i].getFmLocCd());
						trsAwkCgoTrfHdrVO.setFmNodYdNo(trsAwkCgoTrfMngVOs[i].getFmNodYdNo());
						trsAwkCgoTrfHdrVO.setToLocCd(trsAwkCgoTrfMngVOs[i].getToLocCd());
						trsAwkCgoTrfHdrVO.setToNodYdNo(trsAwkCgoTrfMngVOs[i].getToNodYdNo());
						trsAwkCgoTrfHdrVO.setTrspAwkCgoTrfTpCd("S");
						trsAwkCgoTrfHdrVO.setIoGaCd(trsAwkCgoTrfMngVOs[i].getIoGaCd());
						trsAwkCgoTrfHdrVO.setTrspCrrModCd(trsAwkCgoTrfMngVOs[i].getTrspCrrModCd());
						trsAwkCgoTrfHdrVO.setTrspActCostSeq(trsAwkCgoTrfMngVOs[i].getTrspActCostSeq());
						trsAwkCgoTrfHdrVO.setCondNo(trsAwkCgoTrfMngVOs[i].getCondNo());
						trsAwkCgoTrfHdrVO.setCalcRmk(trsAwkCgoTrfMngVOs[i].getCalcRmk());
						trsAwkCgoTrfHdrVO.setLstUpdUsrId(lg_usr_id);
						trsAwkCgoTrfHdrVO.setUpdUsrId(lg_usr_id);
						
						insUpdHdrList.add(trsAwkCgoTrfHdrVO);
						
						//tp_sz VO
						if(!trsAwkCgoTrfMngVOs[i].getManLoclAmt20ft().equals("")){
							TrsAwkCgoTrfTpSzVO trsAwkCgoTrfTpSzVO =  new TrsAwkCgoTrfTpSzVO();
							
							trsAwkCgoTrfTpSzVO.setFmLocCd(trsAwkCgoTrfMngVOs[i].getFmLocCd());
							trsAwkCgoTrfTpSzVO.setFmNodYdNo(trsAwkCgoTrfMngVOs[i].getFmNodYdNo());
							trsAwkCgoTrfTpSzVO.setToLocCd(trsAwkCgoTrfMngVOs[i].getToLocCd());
							trsAwkCgoTrfTpSzVO.setToNodYdNo(trsAwkCgoTrfMngVOs[i].getToNodYdNo());
							trsAwkCgoTrfTpSzVO.setCondNo(trsAwkCgoTrfMngVOs[i].getCondNo());
							trsAwkCgoTrfTpSzVO.setTrspAwkCgoTrfTpCd("S");
							trsAwkCgoTrfTpSzVO.setIoGaCd(trsAwkCgoTrfMngVOs[i].getIoGaCd());
							trsAwkCgoTrfTpSzVO.setTrspCrrModCd(trsAwkCgoTrfMngVOs[i].getTrspCrrModCd());
							
							trsAwkCgoTrfTpSzVO.setTrspAwkUcCalcTpCd("M");
							trsAwkCgoTrfTpSzVO.setCntrSzCd("2");
							trsAwkCgoTrfTpSzVO.setUsdAmt(trsAwkCgoTrfMngVOs[i].getManUsdAmt20ft());
							trsAwkCgoTrfTpSzVO.setLoclCurrCd(trsAwkCgoTrfMngVOs[i].getManLoclCurrCd());
							trsAwkCgoTrfTpSzVO.setLoclCurrAmt(trsAwkCgoTrfMngVOs[i].getManLoclAmt20ft());
							trsAwkCgoTrfTpSzVO.setUsdXchDt(trsAwkCgoTrfMngVOs[i].getUsdXchDt());
							trsAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							insUpdTpszList.add(trsAwkCgoTrfTpSzVO);
						}
						if(!trsAwkCgoTrfMngVOs[i].getManLoclAmt40ft().equals("")){
							TrsAwkCgoTrfTpSzVO trsAwkCgoTrfTpSzVO =  new TrsAwkCgoTrfTpSzVO();
							
							trsAwkCgoTrfTpSzVO.setFmLocCd(trsAwkCgoTrfMngVOs[i].getFmLocCd());
							trsAwkCgoTrfTpSzVO.setFmNodYdNo(trsAwkCgoTrfMngVOs[i].getFmNodYdNo());
							trsAwkCgoTrfTpSzVO.setToLocCd(trsAwkCgoTrfMngVOs[i].getToLocCd());
							trsAwkCgoTrfTpSzVO.setToNodYdNo(trsAwkCgoTrfMngVOs[i].getToNodYdNo());
							trsAwkCgoTrfTpSzVO.setCondNo(trsAwkCgoTrfMngVOs[i].getCondNo());
							trsAwkCgoTrfTpSzVO.setTrspAwkCgoTrfTpCd("S");
							trsAwkCgoTrfTpSzVO.setIoGaCd(trsAwkCgoTrfMngVOs[i].getIoGaCd());
							trsAwkCgoTrfTpSzVO.setTrspCrrModCd(trsAwkCgoTrfMngVOs[i].getTrspCrrModCd());
							
							trsAwkCgoTrfTpSzVO.setTrspAwkUcCalcTpCd("M");
							trsAwkCgoTrfTpSzVO.setCntrSzCd("4");
							trsAwkCgoTrfTpSzVO.setUsdAmt(trsAwkCgoTrfMngVOs[i].getManUsdAmt40ft());
							trsAwkCgoTrfTpSzVO.setLoclCurrCd(trsAwkCgoTrfMngVOs[i].getManLoclCurrCd());
							trsAwkCgoTrfTpSzVO.setLoclCurrAmt(trsAwkCgoTrfMngVOs[i].getManLoclAmt40ft());
							trsAwkCgoTrfTpSzVO.setUsdXchDt(trsAwkCgoTrfMngVOs[i].getUsdXchDt());
							trsAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							insUpdTpszList.add(trsAwkCgoTrfTpSzVO);
						}
						if(!trsAwkCgoTrfMngVOs[i].getAutoUsdAmt20ft().equals("")){
							TrsAwkCgoTrfTpSzVO trsAwkCgoTrfTpSzVO =  new TrsAwkCgoTrfTpSzVO();
							
							trsAwkCgoTrfTpSzVO.setFmLocCd(trsAwkCgoTrfMngVOs[i].getFmLocCd());
							trsAwkCgoTrfTpSzVO.setFmNodYdNo(trsAwkCgoTrfMngVOs[i].getFmNodYdNo());
							trsAwkCgoTrfTpSzVO.setToLocCd(trsAwkCgoTrfMngVOs[i].getToLocCd());
							trsAwkCgoTrfTpSzVO.setToNodYdNo(trsAwkCgoTrfMngVOs[i].getToNodYdNo());
							trsAwkCgoTrfTpSzVO.setCondNo(trsAwkCgoTrfMngVOs[i].getCondNo());
							trsAwkCgoTrfTpSzVO.setTrspAwkCgoTrfTpCd("S");
							trsAwkCgoTrfTpSzVO.setIoGaCd(trsAwkCgoTrfMngVOs[i].getIoGaCd());
							trsAwkCgoTrfTpSzVO.setTrspCrrModCd(trsAwkCgoTrfMngVOs[i].getTrspCrrModCd());
							
							trsAwkCgoTrfTpSzVO.setTrspAwkUcCalcTpCd("A");
							trsAwkCgoTrfTpSzVO.setCntrSzCd("2");
							trsAwkCgoTrfTpSzVO.setUsdAmt(trsAwkCgoTrfMngVOs[i].getAutoUsdAmt20ft());
							trsAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							insUpdTpszList.add(trsAwkCgoTrfTpSzVO);
						}
						if(!trsAwkCgoTrfMngVOs[i].getAutoUsdAmt40ft().equals("")){
							TrsAwkCgoTrfTpSzVO trsAwkCgoTrfTpSzVO =  new TrsAwkCgoTrfTpSzVO();
							
							trsAwkCgoTrfTpSzVO.setFmLocCd(trsAwkCgoTrfMngVOs[i].getFmLocCd());
							trsAwkCgoTrfTpSzVO.setFmNodYdNo(trsAwkCgoTrfMngVOs[i].getFmNodYdNo());
							trsAwkCgoTrfTpSzVO.setToLocCd(trsAwkCgoTrfMngVOs[i].getToLocCd());
							trsAwkCgoTrfTpSzVO.setToNodYdNo(trsAwkCgoTrfMngVOs[i].getToNodYdNo());
							trsAwkCgoTrfTpSzVO.setCondNo(trsAwkCgoTrfMngVOs[i].getCondNo());
							trsAwkCgoTrfTpSzVO.setTrspAwkCgoTrfTpCd("S");
							trsAwkCgoTrfTpSzVO.setIoGaCd(trsAwkCgoTrfMngVOs[i].getIoGaCd());
							trsAwkCgoTrfTpSzVO.setTrspCrrModCd(trsAwkCgoTrfMngVOs[i].getTrspCrrModCd());
							
							trsAwkCgoTrfTpSzVO.setTrspAwkUcCalcTpCd("A");
							trsAwkCgoTrfTpSzVO.setCntrSzCd("4");
							trsAwkCgoTrfTpSzVO.setUsdAmt(trsAwkCgoTrfMngVOs[i].getAutoUsdAmt40ft());
							trsAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							insUpdTpszList.add(trsAwkCgoTrfTpSzVO);
						}
						
						if(!trsAwkCgoTrfMngVOs[i].getSumUsdAmt20ft().equals("")){
							TrsAwkCgoTrfTpSzVO trsAwkCgoTrfTpSzVO =  new TrsAwkCgoTrfTpSzVO();
							
							trsAwkCgoTrfTpSzVO.setFmLocCd(trsAwkCgoTrfMngVOs[i].getFmLocCd());
							trsAwkCgoTrfTpSzVO.setFmNodYdNo(trsAwkCgoTrfMngVOs[i].getFmNodYdNo());
							trsAwkCgoTrfTpSzVO.setToLocCd(trsAwkCgoTrfMngVOs[i].getToLocCd());
							trsAwkCgoTrfTpSzVO.setToNodYdNo(trsAwkCgoTrfMngVOs[i].getToNodYdNo());
							trsAwkCgoTrfTpSzVO.setCondNo(trsAwkCgoTrfMngVOs[i].getCondNo());
							trsAwkCgoTrfTpSzVO.setTrspAwkCgoTrfTpCd("S");
							trsAwkCgoTrfTpSzVO.setIoGaCd(trsAwkCgoTrfMngVOs[i].getIoGaCd());
							trsAwkCgoTrfTpSzVO.setTrspCrrModCd(trsAwkCgoTrfMngVOs[i].getTrspCrrModCd());
							
							trsAwkCgoTrfTpSzVO.setTrspAwkUcCalcTpCd("S");
							trsAwkCgoTrfTpSzVO.setCntrSzCd("2");
							trsAwkCgoTrfTpSzVO.setUsdAmt(trsAwkCgoTrfMngVOs[i].getSumUsdAmt20ft());
							trsAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							insUpdTpszList.add(trsAwkCgoTrfTpSzVO);
						}
	
						if(!trsAwkCgoTrfMngVOs[i].getSumUsdAmt40ft().equals("")){
							TrsAwkCgoTrfTpSzVO trsAwkCgoTrfTpSzVO =  new TrsAwkCgoTrfTpSzVO();
							
							trsAwkCgoTrfTpSzVO.setFmLocCd(trsAwkCgoTrfMngVOs[i].getFmLocCd());
							trsAwkCgoTrfTpSzVO.setFmNodYdNo(trsAwkCgoTrfMngVOs[i].getFmNodYdNo());
							trsAwkCgoTrfTpSzVO.setToLocCd(trsAwkCgoTrfMngVOs[i].getToLocCd());
							trsAwkCgoTrfTpSzVO.setToNodYdNo(trsAwkCgoTrfMngVOs[i].getToNodYdNo());
							trsAwkCgoTrfTpSzVO.setCondNo(trsAwkCgoTrfMngVOs[i].getCondNo());
							trsAwkCgoTrfTpSzVO.setTrspAwkCgoTrfTpCd("S");
							trsAwkCgoTrfTpSzVO.setIoGaCd(trsAwkCgoTrfMngVOs[i].getIoGaCd());
							trsAwkCgoTrfTpSzVO.setTrspCrrModCd(trsAwkCgoTrfMngVOs[i].getTrspCrrModCd());
							
							trsAwkCgoTrfTpSzVO.setTrspAwkUcCalcTpCd("S");
							trsAwkCgoTrfTpSzVO.setCntrSzCd("4");
							trsAwkCgoTrfTpSzVO.setUsdAmt(trsAwkCgoTrfMngVOs[i].getSumUsdAmt40ft());
							trsAwkCgoTrfTpSzVO.setUpdUsrId(lg_usr_id);
							
							insUpdTpszList.add(trsAwkCgoTrfTpSzVO);
						}
						
					}else if(trsAwkCgoTrfMngVOs[i].getIbflag().equals("D")){
						//TP_SZ VO
						TrsAwkCgoTrfTpSzVO trsAwkCgoTrfTpSzVO =  new TrsAwkCgoTrfTpSzVO();
						
						trsAwkCgoTrfTpSzVO.setFmLocCd(trsAwkCgoTrfMngVOs[i].getFmLocCd());
						trsAwkCgoTrfTpSzVO.setFmNodYdNo(trsAwkCgoTrfMngVOs[i].getFmNodYdNo());
						trsAwkCgoTrfTpSzVO.setToLocCd(trsAwkCgoTrfMngVOs[i].getToLocCd());
						trsAwkCgoTrfTpSzVO.setToNodYdNo(trsAwkCgoTrfMngVOs[i].getToNodYdNo());
						trsAwkCgoTrfTpSzVO.setTrspAwkCgoTrfTpCd("S");
						trsAwkCgoTrfTpSzVO.setIoGaCd(trsAwkCgoTrfMngVOs[i].getIoGaCd());
						trsAwkCgoTrfTpSzVO.setTrspCrrModCd(trsAwkCgoTrfMngVOs[i].getTrspCrrModCd());
						trsAwkCgoTrfTpSzVO.setCondNo(trsAwkCgoTrfMngVOs[i].getCondNo());
						
						deleteTpszList.add(trsAwkCgoTrfTpSzVO);
						//Hdr VO
						TrsAwkCgoTrfHdrVO trsAwkCgoTrfHdrVO =  new TrsAwkCgoTrfHdrVO();
						trsAwkCgoTrfHdrVO.setFmLocCd(trsAwkCgoTrfMngVOs[i].getFmLocCd());
						trsAwkCgoTrfHdrVO.setFmNodYdNo(trsAwkCgoTrfMngVOs[i].getFmNodYdNo());
						trsAwkCgoTrfHdrVO.setToLocCd(trsAwkCgoTrfMngVOs[i].getToLocCd());
						trsAwkCgoTrfHdrVO.setToNodYdNo(trsAwkCgoTrfMngVOs[i].getToNodYdNo());
						trsAwkCgoTrfHdrVO.setTrspAwkCgoTrfTpCd("S");
						trsAwkCgoTrfHdrVO.setIoGaCd(trsAwkCgoTrfMngVOs[i].getIoGaCd());
						trsAwkCgoTrfHdrVO.setTrspCrrModCd(trsAwkCgoTrfMngVOs[i].getTrspCrrModCd());
						trsAwkCgoTrfHdrVO.setCondNo(trsAwkCgoTrfMngVOs[i].getCondNo());
						
						deleteHdrList.add(trsAwkCgoTrfHdrVO);	
					}
				}	
			}
			//Delete
			if(deleteTpszList.size() > 0){
				begin();
				command.removeAwkCgoShuttleTrfTpSz(deleteTpszList);
				command.removeAwkCgoShuttleTrfHdr(deleteHdrList);
				commit();
			}
			//Update, Insert
			if(insUpdHdrList.size() > 0){
				begin();
				command.modifyAwkCgoShuttleTrfHdr(insUpdHdrList);
				command.modifyAwkCgoShuttleTrfTpSz(insUpdTpszList);
				commit();
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
	 * ESD_TRS_0250<br>
	 * Port Code 존재유무를 확인한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPort(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0250Event	event = (EsdTrs0250Event)e;
		try{
			String chkPort = command.checkPort(event.getTrsAwkCgoTrfMngVO().getYdCd());

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
	 * ESD_TRS_0250<br>
	 * 해당 Port에 해당하는 Terminal을 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTmlCd(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0250Event	event = (EsdTrs0250Event)e;
		TrsAwkCgoTrfMngVO trsAwkCgoTrfMngVO = event.getTrsAwkCgoTrfMngVO();
		List<TrsAwkCgoTrfMngVO> yardList = null;
		StringBuilder sb = null;
		
		try{
			yardList = command.searchTmlCd(trsAwkCgoTrfMngVO.getYdCd());

			if(yardList != null && yardList.size()>0){
				sb = new StringBuilder();

				TrsAwkCgoTrfMngVO vo = yardList.get(0);

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
	 * ESD_TRS_0250<br>
	 * Currency Code를 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrCd(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<TrsAwkCgoTrfMngVO> currCd = null;
		StringBuilder sb = null;
		
		try{
			currCd = command.searchCurrCd();

			if(currCd != null && currCd.size()>0){
				sb = new StringBuilder();

				TrsAwkCgoTrfMngVO vo = currCd.get(0);

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
	 * ESD_TRS_0250<br>
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
	 * ESD_TRS_0251<br>
	 * AWK Cargo Shuttle Tariff History를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkCgoShuttleTrfHis(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0251Event	event = (EsdTrs0251Event)e;

		try{
			eventResponse.setRsVoList(command.searchAwkCgoShuttleTrfHis(event.getTrsAwkCgoTrfMngVO()));
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
	 * ESD_TRS_0250<br>
	 * 해당 월 환율적용하여 local amt를 usd amt로 변환한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkUsdConvert(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0250Event	event = (EsdTrs0250Event)e;
		
		try{
			String amt = command.checkUsdConvert(event.getTrsAwkCgoTrfMngVO());

			eventResponse.setETCData("usd_amt", amt);
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
	 * ESD_TRS_0250<br>
	 * Sheet에 입력한 Port+Tml Cd와 로그인 오피스를 비교하여 입력 권한을 체크한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkYdCdInputAuth(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0250Event	event = (EsdTrs0250Event)e;
		
		try{
			String chk_flg = command.checkYdCdInputAuth(event.getTrsAwkCgoTrfMngVO().getFmYdCd(), event.getTrsAwkCgoTrfMngVO().getToYdCd(),event.getTrsAwkCgoTrfMngVO().getLgOfcCd());

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
	 * ESD_TRS_0250<br>
	 * Load / Unload Shuttle Extra Cost를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoadUnloadShuttleExtCost(Event e) throws EventException {
		SpecialCargoQuotationManageBC command = new SpecialCargoQuotationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0252Event	event = (EsdTrs0252Event)e;

		try{
			eventResponse.setRsVoList(command.searchLoadUnloadShuttleExtCost(event.getAwkCgoExtraCostByRouteVO()));
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