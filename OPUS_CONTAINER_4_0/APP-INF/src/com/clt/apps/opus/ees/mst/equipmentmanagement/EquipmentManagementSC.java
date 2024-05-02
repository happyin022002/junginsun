/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EquipmentManagementSC.java
*@FileTitle : ISO Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBC;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBCImpl;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireConfirmVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0014Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0016Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0017Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0019Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0024Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0025Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0028Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0038Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0044Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0046Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0047Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0055Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.Fns0260001Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.ApprovalListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrLotVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterInquiryVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrReeferUnitInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrStatusCreationVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.FACntrListInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.IFGateVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.LeasedCntrVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.LostFoundVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.LotNoListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.MstEtcVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusHistoryVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusUpdateGRPVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.FaTargetListVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.basic.ContainerSpecMgtBC;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.basic.ContainerSpecMgtBCImpl;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0001Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0002Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0004Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0005Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0013Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0021Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0022Event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration.ContainerSpecMgtDBDAO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.CntrSpecListBrieflyVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.ContainerTypeSizeCodeVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgSccVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgYardVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.LeaseTermVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.MstCntrSpecVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.TCntrStsCodeGRPVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.basic.MSTCommonBC;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.basic.MSTCommonBCImpl;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.event.MstComEvent;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MstIsoCntrTpSzVO;

/**
 * EquipmentManagement Business Logic ServiceCommand 
 * handling business process about EquipmentManagement 
 * 
 * @author 
 * @see ContainerSpecMgtDBDAO
 * @since J2EE 1.4
 */

public class EquipmentManagementSC extends ServiceCommandSupport 
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

		if (e.getEventName().equalsIgnoreCase("EesMst0001Event")) 
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchEqStatusCodeListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) 
			{
				eventResponse = manageEqStatusCodeService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0005Event")) 
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchISOCodeListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) 
			{
				eventResponse = manageISOCodeService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0013Event")) 
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchEqOrgSccListService(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) 
			{
				eventResponse = searchEqOrgYardListService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0002Event")) 
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchCntrTypeSizeCodeListService();
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyCntrTypeSizeCodeService(e);
			}			
		}		
		else if (e.getEventName().equalsIgnoreCase("EesMst0004Event")) 
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchLeaseTermCodeListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) 
			{
				eventResponse = manageLeaseTermCodeService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0016Event")) 
		{			
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) 
			{
				eventResponse = createOwnCntrService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02))
			{
				eventResponse = modifyOwnCntrService(e);				
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchLotInfoService(e);	
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH09))
			{
				eventResponse = searchValidaionSpecNoTpsz(e);	
			}
		}		
		else if (e.getEventName().equalsIgnoreCase("EesMst0038Event")) 
		{
			if(e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchLotNoListBrieflyService(e);	
			}			
		}			
		else if (e.getEventName().equalsIgnoreCase("EesMst0021Event")) 
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchCntrSpecService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) 
			{
				eventResponse = modifyCntrSpecService(e); 
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE))
			{
				eventResponse = removeCntrSpecService(e); 
			}
			else if (e.getFormCommand().isCommand(FormCommand.ADD))
			{
				eventResponse = createCntrSpecService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0022Event")) 
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchCntrSpecListBrieflyService(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchCntrSpecNoInquiryService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0019Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchCntrMasterInquiryService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0014Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchApprovalListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02))
			{
				eventResponse = searchEqTypeSizeListOfAgmt(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageLeasedCntrService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0044Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchCntrMasterInquiryService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = modifyCntrMasterService(e);
			}			
		}	
		else if (e.getEventName().equalsIgnoreCase("EesMst0025Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchLostFoundListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageLostFoundService(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0024Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchLeaseOutTargetListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageCntrStatusCreationService(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrStatusUpdateTargetService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageCntrStatusUpdateService(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01))
			{
				eventResponse = manageCntrStatusSearchService(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EesMst0046Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchCntrManufactureInfoService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01))
			{
				eventResponse = searchCntrManufactureInfoService(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyCntrManufactureInfoService(e);
			}
        }
        else if (e.getEventName().equalsIgnoreCase("EesMst0047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchCntrReeferUnitInfoService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01))
			{
				eventResponse = searchCntrReeferUnitInfoService(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyCntrReeferUnitInfoService(e);
			}
        }
        else if (e.getEventName().equalsIgnoreCase("EesMst0017Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchFATargetListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = sendToFAService (e);
			}	
		}
        else if (e.getEventName().equalsIgnoreCase("Fns0260001Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = receiveFAService(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EesMst0055Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchFACntrListInfo(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * EES_MST_0001 : retrieve<br>
	 *  retreiving for EqStatusCode<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqStatusCodeListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			TCntrStsCodeGRPVO tgrVo = command.searchEqStatusCodeListBasic();
			eventResponse.setRsVoList(tgrVo.getMstCntrStsVO());
			eventResponse.setRsVoList(tgrVo.getMstCntrPreStsVO());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}		
		return eventResponse;
	}
	
	/**
	 * EES_MST_0001 : save<br>
	 * retrieving for EqStatusCode<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEqStatusCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0001Event event = (EesMst0001Event)e;
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		TCntrStsCodeGRPVO tgrVo = new TCntrStsCodeGRPVO();
		tgrVo.setMstCntrPreStsVOS(event.getMstCntrPreStsVOs());
		tgrVo.setMstCntrStsVOS(event.getMstCntrStsVOS());

		try{
			begin();
			command.manageEqStatusCodeBasic(tgrVo,account);
			eventResponse.setUserMessage(new ErrorHandler("MST00003").getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MST_0005 : retrieve<br>
	 * retrieving for Containerspecmgt<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchISOCodeListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		//EesMst0005Event event = (EesMst0005Event)e;
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{		
			List<MstIsoCntrTpSzVO> list = command.searchISOCodeListBasic();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}
	
	/**
	 * EES_MST_0005 : save<br>
	 * saving for ISO Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageISOCodeService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0005Event event = (EesMst0005Event)e;
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		try{
			begin();
			command.manageISOCodeBasic(event.getMstIsoCntrTpSzVOS(),account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("MST00003").getMessage());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MST_0013 : retrieve<br>
	 * retrieving for EqOrgSccList Equipment Organization Chart <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqOrgSccListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{			
			List<EqOrgSccVO> list = command.searchEqOrgSccListBasic();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}				
		return eventResponse;
	}
	
	/**
	 * EES_MST_0013 : retrieve<br>
	 * retrieving for EqOrgYardList<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqOrgYardListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		EesMst0013Event event = (EesMst0013Event)e;
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{		
			List<EqOrgYardVO> list = command.searchEqOrgYardListBasic(event.getEqOrgYardVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}
	
	/**
	 * EES_MST_0004 : retrieve<br>
	 * retrieving for LeaseTermCode<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLeaseTermCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		
		try{
			List<LeaseTermVO> list = command.searchLeaseTermCodeListBasic();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * EES_MST_0004 : save<br>
	 * saving for LeaseTermCode<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLeaseTermCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0004Event event = (EesMst0004Event)e;
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		try{
			begin();
			command.manageLeaseTermCodeBasic(event.getLeaseTermVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("MST00003").getMessage());
			commit();
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * EES_MST_0002 : retrieve<br>
	 * retrieving for Container Type/Size<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrTypeSizeCodeListService() throws EventException 
	{		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		
		try{
			List<ContainerTypeSizeCodeVO> list = command.searchCntrTypeSizeCodeListBasic();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}	
	
	/**
	 * EES_MST_0002 : save<br>
	 * saving for Container Type/Size<br>
	 * It is referenced from CIM`s Container Type/Size<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCntrTypeSizeCodeService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0002Event event = (EesMst0002Event)e;
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		try{
			begin();
			command.modifyCntrTypeSizeCodeBasic(event.getContainerTypeSizeCodeVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("MST00003").getMessage());			
			commit();
		}catch(EventException ex){			
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * EES_MST_0021 : retrieve<br>
	 * retrieving for CntrSpec<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrSpecService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMst0021Event event = (EesMst0021Event)e;
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{		
			List<MstCntrSpecVO> list = new ArrayList<MstCntrSpecVO>();
			MstCntrSpecVO mstCntrSpecVO = command.searchCntrSpecBasic(event.getMstCntrSpecVO());
			list.add(mstCntrSpecVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	/**
	 * EES_MST_0021 : Save<br>
	 * saving for CntrSpec<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createCntrSpecService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0021Event event = (EesMst0021Event)e;
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		String cntrSpecNo = "";
		try{
			begin();
			cntrSpecNo = command.createCntrSpecBasic(event.getMstCntrSpecVO(),account);
			eventResponse.setETCData("cntr_spec_no", cntrSpecNo);
			commit();
			if("".equalsIgnoreCase(cntrSpecNo)==false)
				eventResponse.setUserMessage(new ErrorHandler("MST01002", new String[]{cntrSpecNo}).getMessage());
		}catch(EventException ex){
			eventResponse.setETCData("cntr_spec_no", "");
			rollback(); 
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		} 

		return eventResponse;
	}

	/**
	 * EES_MST_0021 : Save<br>
	 * saving for CntrSpec<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCntrSpecService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0021Event event = (EesMst0021Event)e;
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		try{
			begin();
			command.modifyCntrSpecBasic(event.getMstCntrSpecVO(),account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("MST00003").getMessage());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MST_0021 : Delete<br>
	 * removing for CntrSpec<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCntrSpecService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0021Event event = (EesMst0021Event)e;
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		try{
			begin();
			command.removeCntrSpecBasic(event.getMstCntrSpecVO());
			commit();
			eventResponse.setUserMessage(new ErrorHandler("MST00008").getMessage());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MST_0022 : retrieve<br>
	 * retrieving for CntrSpec<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrSpecListBrieflyService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0022Event event = (EesMst0022Event)e;
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		try{
			List<CntrSpecListBrieflyVO> list = command.searchCntrSpecListBrieflyBasic(event.getMstCntrSpecVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_MST_0022 : retrieve<br>
	 * retrieving for CntrSpec<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrSpecNoInquiryService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0022Event event = (EesMst0022Event)e;
		ContainerSpecMgtBC command = new ContainerSpecMgtBCImpl();
		try{
			List<CntrSpecListBrieflyVO> list = command.searchCntrSpecNoInquiryBasic(event.getMstCntrSpecVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/** EES_MST_0019, EES_MST_0044 : retrieve <br>
	 * retrieving for CNTR Master Information with Cntr No.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse  searchCntrMasterInquiryService(Event e) throws EventException
	{
		CntrMasterInquiryVO list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		// PDTO(Data Transfer Object including Parameters)
		try {
			if (e.getEventName().equalsIgnoreCase("EesMst0019Event")){
				EesMst0019Event event = (EesMst0019Event)e;
				ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
				list = command.searchCntrMasterInquiryBasic(event.getMstEtcVO(), account);
			} else {
				EesMst0044Event event = (EesMst0044Event)e;
				ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
				list = command.searchCntrMasterInquiryBasic(event.getMstEtcVO(), account);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		eventResponse.setRsVo(list);
		return eventResponse;
	}
	
	/**
	 * EES_MST_0016 : save<br>
	 * saving for Own Container<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createOwnCntrService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0016Event event = (EesMst0016Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		try{
			begin();		
			CntrLotVO cntrLotVO  = command.createOwnCntrBasic(event.getCntrLotVO(),account);			
			String lot_no = null;
			lot_no = cntrLotVO.getLotNo();
			
			eventResponse.setETCData("lot_no", lot_no);  		// "2008-SHA-D2-001"			
			commit();
			eventResponse.setUserMessage(new ErrorHandler("MST01023", new String[]{lot_no}).getMessage());			
		}catch(EventException ex){								
			eventResponse.setETCData("lot_no", "");  			
			rollback();			
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}		

	/**
	 * EES_MST_0016 : retrieve<br>
	 * retrieving for lot Container<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchLotInfoService(Event e) throws EventException 
	{			
		EesMst0016Event event = (EesMst0016Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();		

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<CntrLotVO> list = new ArrayList<CntrLotVO>();
			CntrLotVO cntrLotVO = command.searchLotInfoBasic(event.getCntrLotVO());			
			list.add(cntrLotVO);		
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		
		return eventResponse;			
	}
	
	/**
	 * EES_MST_0038 : retrieve<br>
	 * retrieving for Lot No<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchLotNoListBrieflyService(Event e) throws EventException 
	{	
		EesMst0038Event event = (EesMst0038Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<LotNoListVO> list = command.searchLotNoListBrieflyBasic(event.getMstEtcVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}
	
	/**
	 * EES_MST_0016 : save<br>
	 * saving for Own Container<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */		
	private EventResponse modifyOwnCntrService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0016Event event = (EesMst0016Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		try{
			begin();
			command.modifyOwnCntrBasic (event.getCntrLotVO(),account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("MST00003").getMessage());			
		}catch(EventException ex){
			rollback();			
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/** EES_MST_0014 : retrieve<br>
	 * retrieving for Leased Container<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse  searchApprovalListService(Event e) throws EventException
	{
		// PDTO(Data Transfer Object including Parameters)
		EesMst0014Event event = (EesMst0014Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<ApprovalListVO> list = command.searchApprovalListBasic(event.getMstEtcVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_MST_0014 : save<br>
	 * saving for Leased Container,CNTR Master Information required by CTM<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLeasedCntrService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0014Event event = (EesMst0014Event)e;
		List<LeasedCntrVO> retVoList = new ArrayList<LeasedCntrVO>();	
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		
		List<LeasedCntrVO> selectVoList = new ArrayList<LeasedCntrVO>();
		List<LeasedCntrVO> manageVoList = new ArrayList<LeasedCntrVO>();	
		IFGateVO[] iFGateVOs = null;
		StringBuffer strZeroList = new StringBuffer("");
		try{
			MstEtcVO mstEtcVO = event.getMstEtcVO();			
			LeasedCntrVO [] leasedCntrVOs = event.getLeasedCntrVOs();
			int intAgmtSeqLen = 0;
			String AgmtSeqZero = "";
			CntrLotVO cntrLotVO = new CntrLotVO(); 	
			
			begin();
			
			if("2".equals(mstEtcVO.getCtype())) {
				cntrLotVO.setLotPlnYr(mstEtcVO.getLotPlnYr());
				cntrLotVO.setLotLocCd(mstEtcVO.getStsEvntYdCd().substring(0,5));
				cntrLotVO.setCntrTpszCd(mstEtcVO.getEqTpszCd());
				
				cntrLotVO.setLotSeq(mstEtcVO.getLotSeq());
				cntrLotVO.setMftVndrSeq(mstEtcVO.getVndrSeq());
				cntrLotVO.setFctrySpecNo("");
				cntrLotVO.setMftDt(mstEtcVO.getMftDt());
				cntrLotVO.setLotCntrPfxCd(mstEtcVO.getCntrNo0());
				cntrLotVO.setFmSerNo(mstEtcVO.getCntrNo1());
				cntrLotVO.setToSerNo(mstEtcVO.getCntrNo2());
				intAgmtSeqLen = 6 - mstEtcVO.getAgmtSeq().length();
				for(int j=0;j<intAgmtSeqLen;j++) {
					strZeroList.append("0");
				}
				
				if(strZeroList != null) {
					AgmtSeqZero = strZeroList.toString();
				}
				cntrLotVO.setAgmtNo(mstEtcVO.getAgmtCtyCd() +AgmtSeqZero+mstEtcVO.getAgmtSeq());
				cntrLotVO.setDeYrmon(mstEtcVO.getHireDate().substring(0,7));
				
				cntrLotVO.setCertiNo("");				
				cntrLotVO.setAproCscNo("");
				cntrLotVO.setAproTirNo("");
				cntrLotVO.setAproUicNo("");
				cntrLotVO.setAproTctNo("");
				cntrLotVO.setPlstFlrFlg("");
				cntrLotVO.setCntrHngrRckCd("");
				
				cntrLotVO.setAgmtCtyCd(mstEtcVO.getAgmtCtyCd());
				cntrLotVO.setAgmtSeq(mstEtcVO.getAgmtSeq());
				cntrLotVO.setDiffRmk("");
				
				cntrLotVO.setCreUsrId(mstEtcVO.getCreUsrId());
				cntrLotVO.setUpdUsrId(mstEtcVO.getUpdUsrId());
				cntrLotVO.setCntrSpecNo(mstEtcVO.getCntrSpecNo());
				
				cntrLotVO.setUnitType(mstEtcVO.getRfTpCd());
				cntrLotVO.setRfMkrSeq("");
				cntrLotVO.setRfMdlNm("");
				cntrLotVO.setRfRfrNo("");
				
				cntrLotVO.setMinTemp("");
				cntrLotVO.setMaxTemp("");
				cntrLotVO.setRfHumidCtrlValCd(mstEtcVO.getRfHumidCtrlValCd());
				cntrLotVO.setRfCmprCtnt(mstEtcVO.getRfCmprCtnt());
				
				cntrLotVO.setLstmCd(mstEtcVO.getLstmCd());
				cntrLotVO.setVndrSeq(mstEtcVO.getVndrSeq());				
				cntrLotVO.setCntrMtrlCd(mstEtcVO.getCntrMtrlCd());
				
				cntrLotVO.setCType("2");
				
				command.createOwnCntrBasic(cntrLotVO, account);		
			}
			
			
			for (int i = 0; i < leasedCntrVOs.length; i++){
				leasedCntrVOs[i].setCtype(mstEtcVO.getCtype());
				leasedCntrVOs[i].setHireDate(mstEtcVO.getHireDate());
				leasedCntrVOs[i].setStsEvntYdCd(mstEtcVO.getStsEvntYdCd());
				leasedCntrVOs[i].setAgmtCtyCd(mstEtcVO.getAgmtCtyCd());
				leasedCntrVOs[i].setAgmtSeq(mstEtcVO.getAgmtSeq());
				leasedCntrVOs[i].setLstmCd(mstEtcVO.getLstmCd());
				leasedCntrVOs[i].setVndrSeq(mstEtcVO.getVndrSeq());
				leasedCntrVOs[i].setApprovalNo(mstEtcVO.getApprovalNo());
				leasedCntrVOs[i].setApprovalVol(mstEtcVO.getApprovalVol());
				leasedCntrVOs[i].setPickUpVol(mstEtcVO.getPickUpVol());
				leasedCntrVOs[i].setPickUpDueDate(mstEtcVO.getPickUpDueDate());
				leasedCntrVOs[i].setCntrNo0(mstEtcVO.getCntrNo0());
				leasedCntrVOs[i].setCntrNo1(mstEtcVO.getCntrNo1());
				leasedCntrVOs[i].setCntrNo2(mstEtcVO.getCntrNo2());
				leasedCntrVOs[i].setCntrNo3(mstEtcVO.getCntrNo3());
				
				if("2".equals(mstEtcVO.getCtype())){
					
					leasedCntrVOs[i].setLotPlnYn(mstEtcVO.getMftDt().substring(0, 4));
					leasedCntrVOs[i].setLotLocCd(mstEtcVO.getStsEvntYdCd().substring(0,5));
					leasedCntrVOs[i].setLotSeq(cntrLotVO.getLotSeq());
				}
				leasedCntrVOs[i].setRfTpCd(mstEtcVO.getRfTpCd());
				leasedCntrVOs[i].setRfHumidCtrlValCd(mstEtcVO.getRfHumidCtrlValCd());
				leasedCntrVOs[i].setRfCmprCtnt(mstEtcVO.getRfCmprCtnt());
			}
			
			retVoList = command.manageLeasedCntrBasic(leasedCntrVOs,account);
			boolean commitchk = true;
			for (int i = 0; i < retVoList.size(); i++)
			{
				if (retVoList.get(i).getIeflg().equals("E") ||
					retVoList.get(i).getUeflg().equals("E")){
					commitchk = false;
				}
			}
			
			if (commitchk == true){				
//------------------------------------------------------------------------------							
				// modifying CNTR Master Information required from CTM
				selectVoList = retVoList;
				
				for(int i=0; i<selectVoList.size(); i++ ){		
					
					if( !(selectVoList.get(i).getIeflg().equals("E") ||		
						  selectVoList.get(i).getUeflg().equals("E") ||
						  selectVoList.get(i).getCeflg().equals("E") ||
						  selectVoList.get(i).getEeflg().equals("E") ||
						  selectVoList.get(i).getHeflg().equals("E") )	)
					{								
						manageVoList.add(selectVoList.get(i));															
					}
				}		

				iFGateVOs = new IFGateVO[manageVoList.size()];				
				for(int k=0; k<manageVoList.size(); k++){	
					iFGateVOs[k] = new IFGateVO();
					iFGateVOs[k].setCntrNo(manageVoList.get(k).getCntrNo());					
					iFGateVOs[k].setOrgYdCd(selectVoList.get(k).getStsEvntYdCd());
					iFGateVOs[k].setCnmvEvntDt(selectVoList.get(k).getHireDate());
					iFGateVOs[k].setCntrStsCd("LSI");
					iFGateVOs[k].setMvmtStsCd("MT");
				}
				
				if(manageVoList.size() > 0){
					command.createMvmtBasic(iFGateVOs, account);								
				}							
//------------------------------------------------------------------------------				
			    commit();
			}    
			else{
				rollback();
			}
			eventResponse.setRsVoList(retVoList);
		}catch(EventException ex){
			rollback();
			throw ex;   
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ees_mst_0044 : save<br>
	 * saving for Container Master Update<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCntrMasterService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0044Event event = (EesMst0044Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		try{
			begin();
			command.modifyCntrMasterBasic(event.getMstEtcVO(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/** 
	 * EES_MST_0025 : Retrive<br>
	 * retrieving for Movement,Status of lost and found CNTR<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse  searchLostFoundListService(Event e) throws EventException
	{			
		// PDTO(Data Transfer Object including Parameters)
		EesMst0025Event event = (EesMst0025Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<LostFoundVO> list = command.searchLostFoundListBasic(event.getLostFoundVOs());		
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/** 
	 * EES_MST_0025 : Save<br>
	 * saving for Movement,Status of lost and found CNTR<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse  manageLostFoundService(Event e) throws EventException
	{			
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0025Event event = (EesMst0025Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		List<LostFoundVO> retVoList = new ArrayList<LostFoundVO>();
		
		List<LostFoundVO> selectVoList = new ArrayList<LostFoundVO>();
		List<LostFoundVO> manageVoList = new ArrayList<LostFoundVO>();	
		IFGateVO[] iFGateVOs = null;
		
		try{
			begin();
			retVoList = command.manageLostFoundBasic(event.getLostFoundVOs(),account);
			
			// modifying CNTR Master Information required from CTM
			selectVoList = retVoList;
			
			for(int i=0; i<selectVoList.size(); i++ ){													
				if( !(selectVoList.get(i).getHChk1().equals("E") ||
					selectVoList.get(i).getHChk2().equals("E") ||		
					selectVoList.get(i).getHChk3().equals("E"))	)
				{								
					if(!(selectVoList.get(i).getHChk1().equals("") &&
					     selectVoList.get(i).getHChk2().equals("") &&
					     selectVoList.get(i).getHChk2().equals("") ) ){
						manageVoList.add(selectVoList.get(i));						
					}									
				}
			}		

			iFGateVOs = new IFGateVO[manageVoList.size()];				
			for(int k=0; k<manageVoList.size(); k++){	
				iFGateVOs[k] = new IFGateVO();
				iFGateVOs[k].setCntrNo(manageVoList.get(k).getCntrNo());					
				iFGateVOs[k].setOrgYdCd(selectVoList.get(0).getHOnhYdCd());
				iFGateVOs[k].setCnmvEvntDt(selectVoList.get(0).getHCnmvEvntDt());
				iFGateVOs[k].setCntrStsCd(selectVoList.get(0).getHCntrStsCd());
				if("LST".equals(selectVoList.get(0).getHCntrStsCd())){
					iFGateVOs[k].setMvmtStsCd("XX");
				}else if("FND".equals(selectVoList.get(0).getHCntrStsCd())){
					iFGateVOs[k].setMvmtStsCd("MT");
				}else if("RPC".equals(selectVoList.get(0).getHCntrStsCd())){
					iFGateVOs[k].setOrgYdCd(manageVoList.get(0).getCrntYdCd());
					iFGateVOs[k].setMvmtStsCd("XX");					
				}
			}
			
			if(manageVoList.size() > 0){
				command.createMvmtBasic(iFGateVOs, account);				
				if("RPC".equals(selectVoList.get(0).getHCntrStsCd())){
					for(int k=0; k<manageVoList.size(); k++){
						iFGateVOs[k].setOrgYdCd(selectVoList.get(0).getHOnhYdCd());
						iFGateVOs[k].setMvmtStsCd("MT");						
					}
					command.createMvmtBasic(iFGateVOs, account);
				}				
			}						
			commit();
			eventResponse.setRsVoList(retVoList);			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}		
	
	/**
	 *  EES_MST_0024 : retrieve<br>
	 * retrieving for Status Code, AGMT No of lease out CNTR <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse  searchLeaseOutTargetListService(Event e) throws EventException
	{
		// PDTO(Data Transfer Object including Parameters)
		EesMst0024Event event = (EesMst0024Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try{		
			List<CntrStatusCreationVO> list = command.searchLeaseOutTargetListBasic(event.getCntrStatusCreationVOs());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * ees_mst_0024 : save<br>
	 * saving for CNTR master history<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse manageCntrStatusCreationService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0024Event event = (EesMst0024Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		AvailableOffHireBC command1 = new AvailableOffHireBCImpl();
		List<CntrStatusCreationVO> retVoList = new ArrayList<CntrStatusCreationVO>();
		
		List<CntrStatusCreationVO> selectVoList = new ArrayList<CntrStatusCreationVO>();
		List<CntrStatusCreationVO> manageVoList = new ArrayList<CntrStatusCreationVO>();
		List<CntrStatusCreationVO> manageVoList1 = new ArrayList<CntrStatusCreationVO>();
		IFGateVO[] iFGateVOs = null;		
		IFMnrFlagVO[] iFMnrFlagVOs = null;
		AvailableOffHireConfirmVO[] availableOffHireConfirmVOs = null;
		
		try{
			begin();
			retVoList = command.manageCntrStatusCreationBasic(event.getCntrStatusCreationVOs(),account);
			boolean commitchk = true;
			for (int i = 0; i < retVoList.size(); i++)
			{
				if (retVoList.get(i).getIeflg().equals("E") ||
					retVoList.get(i).getUeflg().equals("E")){
					commitchk = false;
				}
			}
			if (commitchk == true){
//------------------------------------------------------------------------------							
				// modifying CNTR Master Information required from CTM
				selectVoList = retVoList;
				
				for(int i=0; i<selectVoList.size(); i++ ){													
					if( !(selectVoList.get(i).getIeflg().equals("E") ||		
						  selectVoList.get(i).getUeflg().equals("E") ||
						  selectVoList.get(i).getAeflg().equals("E") ||
						  selectVoList.get(i).getBeflg().equals("E") ||
						  selectVoList.get(i).getCeflg().equals("E") ||
						  selectVoList.get(i).getDeflg().equals("E") ||
						  selectVoList.get(i).getEeflg().equals("E") ||
						  selectVoList.get(i).getFeflg().equals("E") ))
					{	// Add MNR support  
						if ( !(selectVoList.get(i).getStCd().equals("7") ||
							   selectVoList.get(i).getStCd().equals("8") ||
							   selectVoList.get(i).getStCd().equals("9") ||
							   selectVoList.get(i).getStCd().equals("10"))){
						        manageVoList.add(selectVoList.get(i));				
						}else {
							    manageVoList1.add(selectVoList.get(i));
						}
					}
				}		

				iFGateVOs = new IFGateVO[manageVoList.size()];
				//String     checkBackDateFlg = "N";
				for(int k=0; k<manageVoList.size(); k++){							
					iFGateVOs[k] = new IFGateVO();
					iFGateVOs[k].setCntrNo(manageVoList.get(k).getCntrNo());					
					iFGateVOs[k].setOrgYdCd(selectVoList.get(k).getStsEvntYdCd());
					iFGateVOs[k].setCnmvEvntDt(selectVoList.get(k).getHireDate());
					
					String hireDate    = selectVoList.get(k).getHireDate().replaceAll("-", "");
					String curMvmtDate = selectVoList.get(k).getCnmvDt().replaceAll("-", "");
					hireDate = hireDate.substring(0, 8);
					curMvmtDate = curMvmtDate.substring(0, 8); 
					
					//checkBackDateFlg = command.checkBackDatebyCntr(manageVoList.get(k).getCntrNo(), hireDate);					
					//iFGateVOs[k].setBackDateFlg(checkBackDateFlg);
					if (hireDate.compareTo(curMvmtDate) >=0 ) {
						//SBI 또는 MUI일때는 Default "N"으로 처리 합니다.
						iFGateVOs[k].setBackDateFlg("N");
					} else {
						// Hire Date가 Current Movement Date보다 작을때 Movement 생성하지 않도록 Y로 처리
						iFGateVOs[k].setBackDateFlg("Y");
					}

					if("0".equals(selectVoList.get(k).getStCd()) || "11".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("LSO");
						iFGateVOs[k].setMvmtStsCd("XX");						
					}else if("1".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("SBO");
						iFGateVOs[k].setMvmtStsCd("XX");						
					}else if("2".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("SBI");
						iFGateVOs[k].setMvmtStsCd("MT");
						iFGateVOs[k].setBackDateFlg("N");
					}else if("3".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("MUO");
						iFGateVOs[k].setMvmtStsCd("XX");						
					}else if("4".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("MUI");						
						iFGateVOs[k].setMvmtStsCd("MT");
						iFGateVOs[k].setBackDateFlg("N");
					}else if("5".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("SRO");
						iFGateVOs[k].setMvmtStsCd("XX");						
					}else if("6".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("SRI");						
						iFGateVOs[k].setMvmtStsCd("MT");						
					}						
				}
				
				if(manageVoList.size() > 0){
					command.createMvmtBasic(iFGateVOs, account);								
//------------------------------------------------------------------------------	
					// modifying CNTR Status of LSE
					
					if("0".equals(manageVoList.get(0).getStCd())){
						availableOffHireConfirmVOs = new AvailableOffHireConfirmVO[manageVoList.size()];	
						for(int k = 0; k < manageVoList.size(); k++){	
							availableOffHireConfirmVOs[k] = new AvailableOffHireConfirmVO();
							availableOffHireConfirmVOs[k].setCntrNo(manageVoList.get(k).getCntrNo());
							availableOffHireConfirmVOs[k].setOffhStsCd("L");
						}
						command1.modifyAvailableOffHireContainerStatusBasic(availableOffHireConfirmVOs, account);
					}
//------------------------------------------------------------------------------
				}
                //// Add MNR support logic
				iFMnrFlagVOs = new IFMnrFlagVO[manageVoList1.size()];				
				for(int k=0; k<manageVoList1.size(); k++){	
					iFMnrFlagVOs[k] = new IFMnrFlagVO();
					iFMnrFlagVOs[k].setEqNo(manageVoList1.get(k).getCntrNo());					
					iFMnrFlagVOs[k].setStsFlag("Y");
					iFMnrFlagVOs[k].setFlagDt(selectVoList.get(k).getHireDate().replace("-", ""));
					iFMnrFlagVOs[k].setFlagYdCd(selectVoList.get(k).getCrntYdCd());
					iFMnrFlagVOs[k].setFlagUserId(selectVoList.get(k).getUpdUsrId());
					iFMnrFlagVOs[k].setFlagOfcCd(selectVoList.get(k).getOfcCd());
					
					if("7".equals(selectVoList.get(k).getStCd())){
						iFMnrFlagVOs[k].setFlagType("DON");
					}else if("8".equals(selectVoList.get(k).getStCd())){
						iFMnrFlagVOs[k].setFlagType("SCR");					
					}else if("9".equals(selectVoList.get(k).getStCd())){
						iFMnrFlagVOs[k].setFlagType("SLD");						
					}else if("10".equals(selectVoList.get(k).getStCd())){
						iFMnrFlagVOs[k].setFlagType("TLL");	
					}
				}
				
				if(manageVoList1.size() > 0){
					command.createMNRStatusBasic(iFMnrFlagVOs, account);								
				}
			    commit();
			}  else{
				rollback();
			}
			eventResponse.setRsVoList(retVoList);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	

	/**
	 * EES_MST_0028 : retrieve<br>
	 * retrieving for Container Status Update<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */		
	private EventResponse searchCntrStatusUpdateTargetService(Event e) throws EventException
	{
		
		// PDTO(Data Transfer Object including Parameters)
		EesMst0028Event event = (EesMst0028Event)e;   
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();

		StatusUpdateGRPVO sgrVo = new StatusUpdateGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			sgrVo = command.searchCntrStatusUpdateTargetBasic(event.getMstEtcVO(), account);
			eventResponse.setRsVo(sgrVo.getCntrMstHeadVO());
			eventResponse.setRsVoList(sgrVo.getMovementVOs());
			eventResponse.setRsVoList(sgrVo.getStatusHistoryVOs());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;		
	}
	
	/**
	 * EES_MST_0028 : retrieve<br>
	 * retrieving for Container Status Search<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */		
	private EventResponse manageCntrStatusSearchService(Event e) throws EventException
	{
		
		// PDTO(Data Transfer Object including Parameters)
		EesMst0028Event event = (EesMst0028Event)e;   
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();

		StatusUpdateGRPVO sgrVo = new StatusUpdateGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			sgrVo = command.searchCntrStatusSearchTargetBasic(event.getMstEtcVO());
			eventResponse.setRsVoList(sgrVo.getStatusHistoryVOs());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;		
	}
	/**
	 * ees_mst_0028 : save<br>
	 * saving for Container Status Update, CNTR Master Information required from CTM
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */		
	private EventResponse manageCntrStatusUpdateService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0028Event event = (EesMst0028Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		AvailableOffHireBC command1 = new AvailableOffHireBCImpl();		
		StatusHistoryVO[] tmpStatusHistoryVos = new StatusHistoryVO[event.getStatusHistoryVOs().length];
		tmpStatusHistoryVos = event.getStatusHistoryVOs();
		IFGateVO[] iFGateVOs = null;
		CrossItemVO[] crossItemVOs = null;
		AvailableOffHireConfirmVO[] availableOffHireConfirmVOs = null;
		String tmpgubun = "";
		tmpgubun = tmpStatusHistoryVos[0].getGubun();
		try{
			begin(); 
			String cntrStatusChk = command.searchCntrStatusUpdateChkBasic(event.getStatusHistoryVOs() ,account);
			
			if(!"".equals(cntrStatusChk)) {
				eventResponse.setUserMessage(new ErrorHandler("MST02022", new String[]{""+cntrStatusChk}).getMessage());
			}else{
				command.manageCntrStatusUpdateBasic(event.getStatusHistoryVOs() ,account);
				//if tmpStatusHistoryVos has any error, don't do following Interfaces(see MST_0014, MST_0024)
				tmpStatusHistoryVos[0].setGubun(tmpgubun);
				if(tmpStatusHistoryVos[0].getGubun().equals("2")){
					iFGateVOs = new IFGateVO[1];				
					iFGateVOs[0] = new IFGateVO();
					iFGateVOs[0].setCntrNo(tmpStatusHistoryVos[0].getCntrNo());					
					iFGateVOs[0].setOrgYdCd(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getYdCd());
					iFGateVOs[0].setCnmvEvntDt(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getTimeLocal());
					
					if(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getIbflag().equals("D")){
						iFGateVOs[0].setIbflag("D");	
					} else {
						iFGateVOs[0].setIbflag("I");
					}				
					
					iFGateVOs[0].setCntrStsCd(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd());
					iFGateVOs[0].setMvmtStsCd("XX");
					iFGateVOs[0].setCnmvYr(tmpStatusHistoryVos[0].getCnmvYr());
					iFGateVOs[0].setCnmvIdNo(tmpStatusHistoryVos[0].getCnmvIdNo());
					
					// MASTER Update - 1
					command.createMvmtBasic(iFGateVOs, account);
					
					// MASTER Update - 2
					if (tmpStatusHistoryVos[0].getCntrNo().length() == 10){
					   tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].setCntrNo(tmpStatusHistoryVos[0].getCntrNo() + tmpStatusHistoryVos[0].getChkDgt());
					} else {
					   tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].setCntrNo(tmpStatusHistoryVos[0].getCntrNo());
					}
					
					if(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getIbflag().equals("D") && 
					   (tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("LSO") ||
					    tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("SBO") ||
					    tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("MUO") ||
					    tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("SRO") ||
					    tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("DON") ||
					    tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("SCR") ||
					    tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("SLD") ||
					    tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("TLL") ||
					    tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("LST"))){
						
						crossItemVOs = new CrossItemVO[1];				
						crossItemVOs[0] = new CrossItemVO();
						CusCtmMovementVO cusCtmMovementVO = new CusCtmMovementVO();
						crossItemVOs[0].setCusCtmMovementVO(cusCtmMovementVO);
						if(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getMstDelFlg().equals("Y")){
							crossItemVOs[0].getCusCtmMovementVO().setNewFlg("K");
						} else {
	  	                    crossItemVOs[0].getCusCtmMovementVO().setNewFlg("Z");
						}
	  	                crossItemVOs[0].getCusCtmMovementVO().setCnmvRmk(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd());
	  	                crossItemVOs[0].getCusCtmMovementVO().setUpdUsrId(account.getUsr_id());
	  	                crossItemVOs[0].getCusCtmMovementVO().setCntrNo(tmpStatusHistoryVos[0].getCntrNo());
						command.updateCntrMasterByMvmtBasic(crossItemVOs[0]);
						
					} 
					//else {
					//    command.modifyCntrMasterByUpdateBasic(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1], account);
					//}
					//--------------------------------------------------------------------------------------------------
					// alert for removing LSO
					// modifying CNTR Status of LSE
					String credt = "";
					if(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("LSO") &&
					   (tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getLstmCd().equals("ST") ||
					    tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getLstmCd().equals("LT") ||
					    tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getLstmCd().equals("OF") ||
					    tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getLstmCd().equals("SI") ||
					    tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getLstmCd().equals("MI"))){
						
						credt = tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCreDt();
						if (credt.length() >= 8){
						    credt = credt.replace("-", "").substring(0,8);
						}
						if (!credt.equals("") && 
							Integer.parseInt(credt) >=  20100405) {
							availableOffHireConfirmVOs = new AvailableOffHireConfirmVO[1];	
							availableOffHireConfirmVOs[0] = new AvailableOffHireConfirmVO();
							availableOffHireConfirmVOs[0].setCntrNo(tmpStatusHistoryVos[0].getCntrNo());
							availableOffHireConfirmVOs[0].setOffhStsCd("C");
							command1.modifyAvailableOffHireContainerStatusBasic(availableOffHireConfirmVOs, account);
						}
					}
					//--------------------------------------------------------------------------------------------------
				}
				else if(tmpStatusHistoryVos[0].getGubun().equals("3")){
					iFGateVOs = new IFGateVO[1];				
					iFGateVOs[0] = new IFGateVO();
					iFGateVOs[0].setCntrNo(tmpStatusHistoryVos[0].getCntrNo());					
					iFGateVOs[0].setOrgYdCd(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getYdCd());
					iFGateVOs[0].setCnmvEvntDt(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getTimeLocal());
					iFGateVOs[0].setCntrStsCd(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd());
					iFGateVOs[0].setMvmtStsCd("MT");
					if(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getIbflag().equals("D")){
						iFGateVOs[0].setIbflag("D");	
					} else {
						iFGateVOs[0].setIbflag("I");
					}
					iFGateVOs[0].setCnmvYr(tmpStatusHistoryVos[0].getCnmvYr());
					iFGateVOs[0].setCnmvIdNo(tmpStatusHistoryVos[0].getCnmvIdNo());
					
					// MASTER Update - 1
					command.createMvmtBasic(iFGateVOs, account);
					
					// MASTER Update - 2
					if (tmpStatusHistoryVos[0].getCntrNo().length() == 10){
					   tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].setCntrNo(tmpStatusHistoryVos[0].getCntrNo() + tmpStatusHistoryVos[0].getChkDgt());
					} else {
					   tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].setCntrNo(tmpStatusHistoryVos[0].getCntrNo());
					}
					
					if(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getIbflag().equals("D") && 
					  (tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("LSI") ||
					   tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("SBI") ||
					   tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("MUI") ||
					   tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("SRI") ||
					   tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("FND"))){
						
						crossItemVOs = new CrossItemVO[1];				
						crossItemVOs[0] = new CrossItemVO();
						CusCtmMovementVO cusCtmMovementVO = new CusCtmMovementVO();
						crossItemVOs[0].setCusCtmMovementVO(cusCtmMovementVO);
						if(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getMstDelFlg().equals("Y")){
							crossItemVOs[0].getCusCtmMovementVO().setNewFlg("K");
						} else {
	  	                    crossItemVOs[0].getCusCtmMovementVO().setNewFlg("Z");
						}
	  	                crossItemVOs[0].getCusCtmMovementVO().setCnmvRmk(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd());
	  	                crossItemVOs[0].getCusCtmMovementVO().setUpdUsrId(account.getUsr_id());
	  	                crossItemVOs[0].getCusCtmMovementVO().setCntrNo(tmpStatusHistoryVos[0].getCntrNo());
						command.updateCntrMasterByMvmtBasic(crossItemVOs[0]);
						
					} 
					//else {
					//    command.modifyCntrMasterByUpdateBasic(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1], account);
					//}				
				}
			}
			commit();
			//rollback();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}		
	
	
	/**
	 * ees_mst_0046 : retrieve<br>
	 * retrieving for Manufacture Date & Manufacturer Inquiry and Update<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */		
	private EventResponse searchCntrManufactureInfoService(Event e) throws EventException
	{
		
		// PDTO(Data Transfer Object including Parameters)
		EesMst0046Event event = (EesMst0046Event)e;   
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<CntrManufactureInfoVO> list = command.searchCntrManufactureInfoBasic(event.getCntrManufactureListVOs());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;		
	}
	
	/**
	 * ees_mst_0046 : save<br>
	 * saving for Manufacture Date & Manufacturer Inquiry and Update<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */		
	private EventResponse modifyCntrManufactureInfoService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0046Event event = (EesMst0046Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		try{
			begin();
			command.modifyCntrManufactureInfoBasic(event.getCntrManufactureInfoVOs(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ees_mst_0047 : retrieve<br>
	 * retrieving for Reefer Unit Info Inquiry and Updatebr>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */		
	private EventResponse searchCntrReeferUnitInfoService (Event e) throws EventException
	{
		
		// PDTO(Data Transfer Object including Parameters)
		EesMst0047Event event = (EesMst0047Event)e;   
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<CntrReeferUnitInfoVO> list = command.searchCntrReeferUnitInfoBasic(event.getCntrReeferUnitListVOs());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;		
	}
	
	/**
	 * ees_mst_0047 : save<br>
	 * saving for Reefer Unit Info Inquiry and Update<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */		
	private EventResponse modifyCntrReeferUnitInfoService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0047Event event = (EesMst0047Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		try{
			begin();
			command.modifyCntrReeferUnitInfoBasic(event.getCntrReeferUnitInfoVOs(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MST_0017 : retrieve<br>
	 * Own Container Interface to ERP FA를  retrive<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse  searchFATargetListService(Event e) throws EventException
	{
		// PDTO(Data Transfer Object including Parameters)
		EesMst0017Event event = (EesMst0017Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try{	
			List<FaTargetListVO> list = command.searchFATargetListBasic(event.getMstEtcVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	/**
	 * ees_mst_0017 : save<br>
	 * Own Container Interface to ERP FA를 save.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */		
	private EventResponse sendToFAService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0017Event event = (EesMst0017Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		//List<FaTargetListVO> tmpFaTargetListVOs = new ArrayList<FaTargetListVO>();
		try{
			FaTargetListVO[] faTargetListVOs = new FaTargetListVO[1];
			for (int i = 0; i < event.getFaTargetListVOs().length; i++){
				faTargetListVOs[0] = event.getFaTargetListVOs()[i];
				faTargetListVOs[0].setHidType(event.getFaTargetListVOs()[0].getHidType());
				begin();
				command.updateCntrSendToFABasic(faTargetListVOs,account);
				//tmpFaTargetListVOs = command.updateCntrSendToFABasic(faTargetListVOs,account);
				commit();
				
				//command.sendToFABasic(tmpFaTargetListVOs);
			}
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Fns0260001 : save<br>
	 * FNS026R001을 호출하여 Receive하고, ERP FA I/F  의 event에 대한 특정 리스트를 저장합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */		
	private EventResponse receiveFAService(Event e) throws EventException
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Fns0260001Event event = (Fns0260001Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		ChassisMgsetOnOffhireBC command1 = new ChassisMgsetOnOffhireBCImpl();
		
		try{
			begin();
			if (event.getCntrMasterUpdateIFVOs()[0].getCreatedBy().equals("LSE")){
				command.receiveFABasic(event.getCntrMasterUpdateIFVOs(),account);
			} else {
				// 호출
				command1.receiveFABasic(event.getCntrMasterUpdateIFVOs(),account);
			}
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_MST_0016 : SpecNoTpszretrieve<br>
	 * retrieving for lot Container<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchValidaionSpecNoTpsz(Event e) throws EventException 
	{			
		EesMst0016Event event = (EesMst0016Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();		

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<CntrLotVO> list = new ArrayList<CntrLotVO>();
			CntrLotVO cntrLotVO = command.searchValidaionSpecNoTpsz(event.getCntrLotVO());	
			list.add(cntrLotVO);		
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
	
		return eventResponse;			
	}
	
	/**
	 * retrieving for Eq Type Size List of Agreement<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqTypeSizeListOfAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		EesMst0014Event event = (EesMst0014Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try{	
			List<MstEtcVO> list = command.searchEqTypeSizeListOfAgmt(event.getMstEtcVO());
			
			StringBuffer comboList = new StringBuffer("");
			 
			for(int i=0; i<list.size(); i++){
				MstEtcVO mstEtcVO = (MstEtcVO)list.get(i);
							
				String code = mstEtcVO.getCode();
				String name	= mstEtcVO.getCodeNm();
				
				name = name.replaceAll("\"", "");						
				comboList.append(code + '|' + name);
				if(i < list.size()-1) comboList.append("@");
			}
			
			eventResponse.setRsVoList(list);	
			eventResponse.setETCData("comboList", comboList.toString());		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_MST_0055 : retrieve<br>
	 * Searching Container List Information of Interface to ERP FA <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchFACntrListInfo(Event e) throws EventException
	{
		// PDTO(Data Transfer Object including Parameters)
		EesMst0055Event event = (EesMst0055Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try{	
			List<FACntrListInfoVO> list = command.searchFACntrListInfo(event.getMstEtcVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
}