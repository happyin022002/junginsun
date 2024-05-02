/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RuLabelManagementSC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement;

import java.util.List;




import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration.ContainerSpecMgtDBDAO;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo.RuLabelListVO;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.basic.RuLabelManagementBC;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.basic.RuLabelManagementBCImpl;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.event.EesMst0050Event;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.event.EesMst0051Event;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.event.EesMst0052Event;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.event.EesMst0053Event;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.event.EesMst0054Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * EquipmentManagement Business Logic ServiceCommand 
 * handling business process about EquipmentManagement 
 * 
 * @author 
 * @see ContainerSpecMgtDBDAO
 * @since J2EE 1.4
 */

public class RuLabelManagementSC extends ServiceCommandSupport 
{
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario EquipmentManagement system <br>
	 * related objects creation<br>
	 */
	public void doStart() 
	{
		try 
		{
			account = getSignOnUserAccount();
		} catch (Exception ex) 
		{
			log.error("err " + ex.toString(), ex);
		}
	}

	/**
	 * biz scenario closing EquipmentManagement system<br>
	 * clearing related objects<br>
	 */
	public void doEnd(){
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException 
	{
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("EesMst0050Event")) 
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchRuLabelListService(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchRuLabelCheckService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = actionRuLabelListService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0051Event")) 
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchRuLabelAttachListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchRuLabelAttachCntrListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchRuLabelValueListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = checkRuLabel(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = actionRuLabelAttachListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = actionRuLabelAttachExcelCntrListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)){
				eventResponse = searchRuLabelAttachExcelListService(e);
			}

		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0052Event")) 
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchRuLabelHistoryListService(e);	
			}
			
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0053Event")) 
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchRuLabelInfoService(e);	
			}
			
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0054Event")) 
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchRuLabelConditionService(e);	
			}
			
		}
		return eventResponse;
	}
	
	
	
	/**
	 * ManufacturerList : common retrieve<br>
	 * retrieving for RU Label Value List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRuLabelValueListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		RuLabelManagementBC command = new RuLabelManagementBCImpl();
		EesMst0051Event event = (EesMst0051Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try{	
			List<RuLabelListVO> list = command.searchRuLabelValueListBasic(event.getRuLabelListVO());
			
			StringBuffer comboList = new StringBuffer("");
			 
			for(int i=0; i<list.size(); i++){
				RuLabelListVO ruLabelListVO = (RuLabelListVO)list.get(i);
							
				String rstrUsgLblNm = ruLabelListVO.getRstrUsgLblNm();
				
				rstrUsgLblNm = rstrUsgLblNm.replaceAll("\"", "");						
				comboList.append(rstrUsgLblNm);
				if(i < list.size()-1) comboList.append("@");
			}
			
			eventResponse.setRsVoList(list);	
			eventResponse.setETCData("rstr_usg_tblnm", comboList.toString());		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}
	
	
	
	private EventResponse actionRuLabelListService(Event e) throws EventException {
		try {
			//SignOnUserAccount account = getSignOnUserAccount();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			RuLabelManagementBC command = new RuLabelManagementBCImpl();
			
			EesMst0050Event event = (EesMst0050Event) e;
			RuLabelListVO[] ruLabelListVOs = event.getRuLabelListVOs();
			for (RuLabelListVO ruLabelListVO : ruLabelListVOs) {
				ruLabelListVO.setCreUsrId(account.getUsr_id());
				ruLabelListVO.setUpdUsrId(account.getUsr_id());
			}
			begin();
			command.actionRuLabelListBasic(ruLabelListVOs);
			commit();
			return eventResponse;
		}catch(EventException ex){
			throw new EventException(new ErrorHandler("MST02021").getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * EES_MST_0050 : retrieve<br>
	 * retrieving for RuLabelMaintenace<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRuLabelListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		EesMst0050Event event = (EesMst0050Event)e;
		RuLabelManagementBC command = new RuLabelManagementBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{		
			List<RuLabelListVO> list = command.searchRuLabelListBasic(event.getRuLabelInfoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
		
	}
	
	
	/**
	 * EES_MST_0050 : RU Label 중복체크<br>
	 * retrieving for RuLabelMaintenace<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRuLabelCheckService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		EesMst0050Event event = (EesMst0050Event)e;
		RuLabelManagementBC command = new RuLabelManagementBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{		
			String strRuLabelType = "";
			strRuLabelType = command.searchRuLabelDeleteCntBasic(event.getRuLabelListVO()); 
			
			eventResponse.setETCData("strRuLabelType",strRuLabelType);	
			
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
		
	}
	
	
	/**
	 * EES_MST_0051 : retrieve<br>
	 * retrieving for RuLabelAttach<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRuLabelAttachListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		EesMst0051Event event = (EesMst0051Event)e;
		RuLabelManagementBC command = new RuLabelManagementBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();				
		try{		
			
			int rtvTotal = command.searchCntrTotalRuLabelAttachListBasic(event.getRuLabelListVO());
			eventResponse.setETCData("rtv_total", String.valueOf(rtvTotal));
			List<RuLabelListVO> list = command.searchRuLabelAttachListBasic(event.getRuLabelListVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_MST_0051 : retrieve<br>
	 * retrieving for RuLabelAttach Excel<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRuLabelAttachExcelListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		EesMst0051Event event = (EesMst0051Event)e;
		RuLabelManagementBC command = new RuLabelManagementBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();				
		try{		
			event.getRuLabelListVO().setCreUsrId(account.getUsr_id());
			List<RuLabelListVO> list = command.searchRuLabelAttachExcelListBasic(event.getRuLabelListVO());
			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}		
		return eventResponse;
	}
	
	
	/** 
	 * EES_MST_0051 : Sheet onchange Retrive<br>
	 * retrieving for RuLabelAttach<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchRuLabelAttachCntrListService(Event e) throws EventException
	{			
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EesMst0051Event event = (EesMst0051Event)e;
			RuLabelManagementBC command = new RuLabelManagementBCImpl();

			try{
				List<RuLabelListVO> list = command.searchRuLabelAttachCntrListBasic(event.getRuLabelListVO());		
				
				eventResponse.setETCData("cntr_tpsz_cd", list.get(0).getCntrTpszCd());
				eventResponse.setETCData("agmt_no", list.get(0).getAgmtNo());
				eventResponse.setETCData("lstm_cd", list.get(0).getLstmCd());
				eventResponse.setETCData("lessor", list.get(0).getLessor());
				eventResponse.setETCData("lessor_nm", list.get(0).getLessorNm());
				eventResponse.setETCData("cntr_auth_no", list.get(0).getCntrAuthNo());
				
				eventResponse.setETCData("lse_ctrt_no", list.get(0).getLseCtrtNo());
				eventResponse.setETCData("crnt_yd_cd", list.get(0).getCrntYdCd());
				eventResponse.setETCData("cnmv_sts_cd", list.get(0).getCnmvStsCd());
				eventResponse.setETCData("cnmv_dt", list.get(0).getCnmvDt());
				eventResponse.setETCData("full_flg", list.get(0).getFullFlg());
				eventResponse.setETCData("cntr_sts_cd", list.get(0).getCntrStsCd());
				eventResponse.setETCData("mftr_vndr_seq", list.get(0).getMftrVndrSeq());
				eventResponse.setETCData("mftr_vndr_nm", list.get(0).getMftrVndrNm());
				eventResponse.setETCData("mft_dt", list.get(0).getMftDt());
				eventResponse.setETCData("rf_mkr_seq", list.get(0).getRfMkrSeq());
				eventResponse.setETCData("rf_mkr_nm", list.get(0).getRfMkrNm());
				eventResponse.setETCData("rf_mdl_nm", list.get(0).getRfMdlNm());
				
				eventResponse.setRsVoList(list);
				
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}		
			return eventResponse;
	}
	
	
	
	/** 
	 * EES_MST_0051 : Sheet onchange Retrive<br>
	 * retrieving for RuLabelAttach<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse actionRuLabelAttachExcelCntrListService(Event e) throws EventException
	{			
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0051Event event = (EesMst0051Event)e;
		RuLabelManagementBC command = new RuLabelManagementBCImpl();
		
		try{
			begin(); 
			
			String seqValue = command.createMstTempBasic(event.getRuLabelListVOs(), account);
			eventResponse.setETCData("seqValue", seqValue);
			
			
			commit();
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/** 
	 * EES_MST_0051 : Sheet onchange Retrive<br>
	 * retrieving for RuLabelAttach<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse actionRuLabelAttachListService(Event e) throws EventException {
		try {
			//SignOnUserAccount account = getSignOnUserAccount();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			RuLabelManagementBC command = new RuLabelManagementBCImpl();
			
			EesMst0051Event event = (EesMst0051Event) e;
			RuLabelListVO[] ruLabelListVOs = event.getRuLabelListVOs();
			for (RuLabelListVO ruLabelListVO : ruLabelListVOs) {
				ruLabelListVO.setCreUsrId(account.getUsr_id());
				ruLabelListVO.setUpdUsrId(account.getUsr_id());
				
			}
			begin();
			command.actionRuLabelAttachListBasic(ruLabelListVOs);
			commit();
			return eventResponse;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	
	
	/**
	 * EES_MST_0052 : retrieve<br>
	 * retrieving for RuLabelMaintenace History<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRuLabelHistoryListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		EesMst0052Event event = (EesMst0052Event)e;
		RuLabelManagementBC command = new RuLabelManagementBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{		
			List<RuLabelListVO> list = command.searchRuLabelHistoryListBasic(event.getRuLabelListVO());
			eventResponse.setRsVoList(list);
			
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
		
	}
	
	
	/**
	 * EES_MST_0051 : retrieve<br>
	 * checking for RuLabel<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRuLabel(Event e) throws EventException {
		
		EesMst0051Event event = (EesMst0051Event)e;
		GeneralEventResponse 	eventResponse = new GeneralEventResponse();
		RuLabelManagementBC 	command = new RuLabelManagementBCImpl();
		RuLabelListVO ruLabelListVO = null;
		ruLabelListVO = event.getRuLabelListVO();

		try {
			
			if(ruLabelListVO != null){
				String chkRuLabel = command.checkRuLabel(ruLabelListVO.getCntrNo(), ruLabelListVO.getRuLabelType());
				eventResponse.setETCData("check_rulabel_type", chkRuLabel);	
			}
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("").getMessage(), ex);
		}
	}
	
	
	/**
	 * EES_MST_0053 : retrieve<br>
	 * retrieving for RuLabel Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRuLabelInfoService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		EesMst0053Event event = (EesMst0053Event)e;
		RuLabelManagementBC command = new RuLabelManagementBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{		
			List<RuLabelListVO> list = command.searchRuLabelInfoService(event.getRuLabelListVO());
			eventResponse.setRsVoList(list);
			
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
		
	}
	
	
	/**
	 * EES_MST_0054 : retrieve<br>
	 * retrieving for RuLabel Condition<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRuLabelConditionService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		EesMst0054Event event = (EesMst0054Event)e;
		RuLabelManagementBC command = new RuLabelManagementBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{		
			List<RuLabelListVO> list = command.searchRuLabelConditionService(event.getRuLabelListVO());
			eventResponse.setRsVoList(list);
			
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
		
	}
	
}