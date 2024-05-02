/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EquipmentManagementSC.java
*@FileTitle : ISO Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.04.30 김석준
* 1.0 Creation
* ======================================================
* 2010.10.19 남궁진호 [CHM-201006507-01] EES_MST_0047 신규화면추가
*  2013.03.13 채창호    [CHM-201323498-01] ALPS Maater-Status에서 SOC 장비의 OC/OP상태에서 Movement XX 처리 로직 Upgarde  요청
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBC;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireConfirmVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.basic.AssetsAuditMgtBC;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.basic.AssetsAuditMgtBCImpl;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.event.EesMst0032Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.event.EesMst0041Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.event.EesMst0045Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.event.EesMst0048Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.event.EesMst0049Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsAuditVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsDetailVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsSmryVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqAsetAudVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqAverageUsingDayVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqMftPlanListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqMftPlanOptionVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0014Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0016Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0017Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0019Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0024Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0025Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0028Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0038Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0044Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0046Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0047Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.Fns0260001Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.ApprovalListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrLotVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureInfoVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterInquiryVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrReeferUnitInfoVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrStatusCreationVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.FaTargetListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.IFGateVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.LeasedCntrVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.LostFoundVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.LotNoListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.MstEtcVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusHistoryVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusUpdateGRPVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.basic.ContainerSpecMgtBC;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.basic.ContainerSpecMgtBCImpl;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0001Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0002Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0004Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0005Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0013Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0021Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0022Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration.ContainerSpecMgtDBDAO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.CntrSpecListBrieflyVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.ContainerTypeSizeCodeVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgSccVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgYardVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.LeaseTermVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.MstCntrSpecVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.TCntrStsCodeGRPVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MstIsoCntrTpSzVO;

/**
 * ALPS-EquipmentManagement Business Logic ServiceCommand - ALPS-EquipmentManagement 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Suk Jun Kim
 * @see ContainerSpecMgtDBDAO
 * @since J2EE 1.4
 */

public class EquipmentManagementSC extends ServiceCommandSupport 
{
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * EquipmentManagement system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() 
	{
		try 
		{
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception ex) 
		{
			log.error("err " + ex.toString(), ex);
		}
	}

	/**
	 * EquipmentManagement system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd(){
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-EquipmentManagement system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException 
	{
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
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
				eventResponse = modifyCntrSpecService(e); // 수정처리
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE))
			{
				eventResponse = removeCntrSpecService(e); // 삭제처리
			}
			else if (e.getFormCommand().isCommand(FormCommand.ADD))
			{
				eventResponse = createCntrSpecService(e); // 최초생성
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0022Event")) 
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchCntrSpecListBrieflyService(e);
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
		else if (e.getEventName().equalsIgnoreCase("EesMst0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrStatusUpdateTargetService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageCntrStatusUpdateService(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01))
			{
				eventResponse = manageCntrReSoldStatusCreationService(e);
			}	
		}
        else if (e.getEventName().equalsIgnoreCase("Fns0260001Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = receiveFAService(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EesMst0032Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchAssetsAuditVersionListService(e);
            }
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchAssetsAuditResultListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyAssetsAuditResultService(e);
			}
        }
        else if (e.getEventName().equalsIgnoreCase("EesMst0041Event")){		
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAssetsSmryListService(e);				
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01))
			{
				eventResponse = searchAssetsDetailListService(e);
			}			
		}
        else if (e.getEventName().equalsIgnoreCase("EesMst0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH))
			{
				eventResponse = searchEqAverageUsingDayService(e);
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
       
        else if (e.getEventName().equalsIgnoreCase("EesMst0048Event")){		
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEqManufacturePlanListService(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEqManufacturePlanListSerivice(e);	
			}
			
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0049Event")){		
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEqManufacturePlanListService(e);				
			}
		}
		return eventResponse;
	}
	
	/**
	 * EES_MST_0001 : retrieve<br>
	 *  EqStatusCode를 조회합니다<br>
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
			// GROUPVO로 리턴값 받음
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
	 * EqStatusCode를 저장합니다.<br>
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
		// GROUPVO 생성
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
	 * Containerspecmgt를 조회합니다<br>
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
	 * ISO Code를 저장합니다.<br>
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
	 * EqOrgSccList Equipment Organization Chart 를 조회합니다<br>
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
	 * EqOrgYardList 를 조회합니다<br>
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
	 * LeaseTermCode 등록, 수정, 삭제 데이타 조회합니다.<br>
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
	 * LeaseTermCode 등록, 수정, 삭제 데이타 처리합니다.<br>
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
	 * Container Type/Size를 조회합니다.<br>
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
	 * Container Type/Size를 수정합니다.<br>
	 * 
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
	 * CntrSpec 를 조회합니다<br>
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
	 * CntrSpec을 저장합니다<br>
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
			// cntrSpecNo 값 반환
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
	 * CntrSpec 을 수정합니다<br>
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
	 * CntrSpec 을 삭제합니다<br>
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
	 * CntrSpec 를 조회합니다<br>
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
	
	/** EES_MST_0019, EES_MST_0044 : retrieve <br>
	 * Cntr No.별 데이타를 조회합니다.<br>
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
				list = command.searchCntrMasterInquiryBasic(event.getMstEtcVO());
			} else {
				EesMst0044Event event = (EesMst0044Event)e;
				ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
				list = command.searchCntrMasterInquiryBasic(event.getMstEtcVO());
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
	 * Container 내역을 저장합니다.<br>
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
	 * Container 내역을 조회합니다.<br>
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
	 * Lot No를 조회합니다.<br>
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
	 * Container 내역을 수정합니다.<br>
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
	 * Leased Container를 조회합니다.<br>
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
	 * Leased Container를 저장하고, CTM 에서 요청한 Master 정보를 수정합니다.<br>
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
		
		try{
			MstEtcVO mstEtcVO = event.getMstEtcVO();			
			LeasedCntrVO [] leasedCntrVOs = event.getLeasedCntrVOs();
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
			}
			begin();
			retVoList = command.manageLeasedCntrBasic(leasedCntrVOs,account);
			boolean commitchk = true;
			for (int i = 0; i < retVoList.size(); i++)
			{
				if (retVoList.get(i).getIeflg().equals("E") ||
					retVoList.get(i).getUeflg().equals("E") ){
					commitchk = false;
				}
			}
					
			if (commitchk == true){				
//------------------------------------------------------------------------------							
				// CTM 에서 요청한 Master 정보를 수정한다.
				selectVoList = retVoList;
				
				for(int i=0; i<selectVoList.size(); i++ ){		
					if( !(selectVoList.get(i).getIeflg().equals("E") ||		
						  selectVoList.get(i).getUeflg().equals("E") ||
						  selectVoList.get(i).getCeflg().equals("E") ||
						  selectVoList.get(i).getEeflg().equals("E") ||
						  selectVoList.get(i).getHeflg().equals("E") ||
						  selectVoList.get(i).getCntrUpdflg().equals("E"))	)
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
	 * Container Master Update를 저장합니다.<br>
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
	 * 해당 컨테이너의 장비 상태(Movement,Status)를 조회합니다.<br>
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
	 * 해당 컨테이너의 장비 상태(Movement,Status)를 저장합니다.<br>
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
			
			// CTM 에서 요청한 Master 정보를 수정한다.
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
				}
			}
			
			if(manageVoList.size() > 0){
				command.createMvmtBasic(iFGateVOs, account);								
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
	 * (Status Code, AGMT No)등으로 조회합니다. <br>
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
	 * Cntr No.로 마스터와 History에 저장합니다.<br>
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
		IFGateVO[] iFGateVOs = null;		
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
				// CTM 에서 요청한 Master 정보를 수정한다.
				selectVoList = retVoList;
				
				for(int i=0; i<selectVoList.size(); i++ ){													
					if( !(selectVoList.get(i).getIeflg().equals("E") ||		
						  selectVoList.get(i).getUeflg().equals("E") ||
						  selectVoList.get(i).getAeflg().equals("E") ||
						  selectVoList.get(i).getBeflg().equals("E") ||
						  selectVoList.get(i).getCeflg().equals("E") ||
						  selectVoList.get(i).getDeflg().equals("E") ||
						  selectVoList.get(i).getEeflg().equals("E") ||
						  selectVoList.get(i).getTeflg().equals("E") ||
						  selectVoList.get(i).getSeflg().equals("E") ||
						  selectVoList.get(i).getFeflg().equals("E") ))
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
						
					
					
					if("0".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("LSO");
						iFGateVOs[k].setMvmtStsCd("XX");
						iFGateVOs[k].setObCntrflg("N");
					}else if("1".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("SBO");
						iFGateVOs[k].setMvmtStsCd("XX");
						iFGateVOs[k].setObCntrflg("N");
					}else if("2".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("SBI");
						iFGateVOs[k].setMvmtStsCd("MT");
						iFGateVOs[k].setObCntrflg("N");
					}else if("3".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("MUO");
						iFGateVOs[k].setMvmtStsCd("XX");
						iFGateVOs[k].setObCntrflg("N");
					}else if("4".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("MUI");						
						iFGateVOs[k].setMvmtStsCd("MT");
						iFGateVOs[k].setObCntrflg("N");
					}else if("5".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("SRO");
						iFGateVOs[k].setMvmtStsCd("XX");
						iFGateVOs[k].setObCntrflg("N");
					}else if("6".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("SRI");						
						iFGateVOs[k].setMvmtStsCd("MT");
						iFGateVOs[k].setObCntrflg("N");
					}else if("7".equals(selectVoList.get(k).getStCd())){
						iFGateVOs[k].setCntrStsCd("LSO");						
						iFGateVOs[k].setMvmtStsCd("XX");
						iFGateVOs[k].setObCntrflg("Y");
					}
				}
				
				if(manageVoList.size() > 0){
					command.createMvmtBasic(iFGateVOs, account);								
//------------------------------------------------------------------------------	
					// LSE 에서 Status 수정하기 위한 정보를 수정한다.
					
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
	 * EES_MST_0017 : retrieve<br>
	 * Own Container Interface to ERP FA를 조회합니다.<br>
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
	 * Own Container Interface to ERP FA를 저장합니다.<br>
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
		List<FaTargetListVO> tmpFaTargetListVOs = new ArrayList<FaTargetListVO>();
		try{
			FaTargetListVO[] faTargetListVOs = new FaTargetListVO[1];
			for (int i = 0; i < event.getFaTargetListVOs().length; i++){
				faTargetListVOs[0] = event.getFaTargetListVOs()[i];
				faTargetListVOs[0].setHidType(event.getFaTargetListVOs()[0].getHidType());
				begin();
				tmpFaTargetListVOs = command.updateCntrSendToFABasic(faTargetListVOs,account);
				commit();
				
				command.sendToFABasic(tmpFaTargetListVOs);
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
	 * EES_MST_0028 : retrieve<br>
	 * Container Status Update를 조회합니다.<br>
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

		// GROUPVO 생성
		StatusUpdateGRPVO sgrVo = new StatusUpdateGRPVO();
		// GROUPVO로 리턴값 받음
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			sgrVo = command.searchCntrStatusUpdateTargetBasic(event.getMstEtcVO());
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
	 * ees_mst_0028 : save<br>
	 * CTM 에서 요청한 Master 정보를 수정하고, Container Status Update를 저장합니다.<br>
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
		IFMnrFlagVO[] iFMnrFlagVOs = null;
		AvailableOffHireConfirmVO[] availableOffHireConfirmVOs = null;
		String tmpgubun = "";
		tmpgubun = tmpStatusHistoryVos[0].getGubun();
		try{
			begin();
			if(!(tmpStatusHistoryVos[0].getCntrStsCd().equals("SLD") && tmpStatusHistoryVos[0].getIbflag().equals("D"))){
				command.manageCntrStatusUpdateBasic(event.getStatusHistoryVOs() ,account);
				//위의 BC에서 return 받은 vos중에서 에러가 있다면 밑의 Interface를 수행하지 않는다.(MST_0014, MST_0024참조)
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
					// LSE Status 변경알림( LSO삭제에 대한 알림)
					// LSE 에서 Status 수정하기 위한 정보를 수정한다.
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
						
						//if(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getLstmCd().equals("SH") &&
						//   tmpStatusHistoryVos[tmpStatusHistoryVos.length-1].getCntrStsCd().equals("LSI")){
							command.removeMstContainerBasic(tmpStatusHistoryVos[0].getCntrNo());
						//}
					} 
					//else {
					//    command.modifyCntrMasterByUpdateBasic(tmpStatusHistoryVos[tmpStatusHistoryVos.length-1], account);
					//}				
				}
			}else{
				//SLD 수동 삭제 시
				iFMnrFlagVOs = new IFMnrFlagVO[1];
				iFMnrFlagVOs[0] = new IFMnrFlagVO();
				if (tmpStatusHistoryVos[0].getCntrNo().length() == 10){
					   tmpStatusHistoryVos[0].setCntrNo(tmpStatusHistoryVos[0].getCntrNo() + tmpStatusHistoryVos[0].getChkDgt());
				} else {
					   tmpStatusHistoryVos[0].setCntrNo(tmpStatusHistoryVos[0].getCntrNo());
				}
				iFMnrFlagVOs[0].setEqNo(tmpStatusHistoryVos[0].getCntrNo());
				iFMnrFlagVOs[0].setFlagType("SLD");
				iFMnrFlagVOs[0].setStsFlag("N");
				
				command.createMNRStatusBasic(iFMnrFlagVOs, account);
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
	 * EES_MST_0032 : retrieve<br>
	 * Output Alive EQ Master Data for Owned Equipment 화면에서 Month와 Eq_type에 따라 version을 조회한다.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAssetsAuditVersionListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		AssetsAuditMgtBC command = new AssetsAuditMgtBCImpl();
		EesMst0032Event event = (EesMst0032Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try{
			List<EqAsetAudVO> list = command.searchAssetsAuditVersionListBasic(event.getEqAsetAudVO());
			eventResponse.setRsVoList(list);
			
			StringBuffer sVersionNm = new StringBuffer();
			StringBuffer sVersionCd = new StringBuffer();
	
			for ( int i = 0 ; i < list.size() ; i++ ) {
				if (sVersionNm.toString().equals("") ) {
					sVersionNm.append(list.get(i).getVerNo());
					sVersionCd.append(list.get(i).getVerNo());
				} else {
					sVersionNm.append("|").append(list.get(i).getVerNo());
					sVersionCd.append("|").append(list.get(i).getVerNo());
				}
			}
				
			eventResponse.setETCData("version_nm", sVersionNm.toString());
			eventResponse.setETCData("version_cd", sVersionCd.toString());		
		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	/**
	 *  EES_MST_0032 : retrieve<br>
	 * Output Alive EQ Master Data for Owned Equipment에 대한 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */		
	private EventResponse searchAssetsAuditResultListService(Event e) throws EventException
	{
		
		// PDTO(Data Transfer Object including Parameters)
		EesMst0032Event event = (EesMst0032Event)e;   
		AssetsAuditMgtBC command = new AssetsAuditMgtBCImpl();

		// GROUPVO 생성
		AssetsAuditVO sgrVo = new AssetsAuditVO();
		// GROUPVO로 리턴값 받음
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			sgrVo = command.searchAssetsAuditResultListBasic(event.getEqAsetAudVO());
			eventResponse.setRsVo(sgrVo.getEqAsetAudVO());
			if("A".equals(event.getEqAsetAudVO().getRsltCd())){
				eventResponse.setRsVoList(sgrVo.getEqAsetDpcAmtVOs());
			}else{
				eventResponse.setRsVoList(sgrVo.getAssetsAuditDetailVOs());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;		
	}
	
	/**
	 * ees_mst_0032 : save<br>
	 * Output Alive EQ Master Data for Owned Equipment에 대한 Remark 저장합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */		
	private EventResponse modifyAssetsAuditResultService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0032Event event = (EesMst0032Event)e;
		AssetsAuditMgtBC command = new AssetsAuditMgtBCImpl();
		try{
			begin();
			command.modifyAssetsAuditResultBasic(event.getAssetsAuditDetailVOs(),account);
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
	 * EES_MST_0041 : Retrieve<br>
	 * 연도별 자산 집계현황을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */		
	private EventResponse searchAssetsSmryListService(Event e) throws EventException {		
		// PDTO(Data Transfer Object including Parameters)
		EesMst0041Event event = (EesMst0041Event)e;
		AssetsAuditMgtBC command = new AssetsAuditMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try{		
			List<AssetsSmryVO> list = command.searchAssetsSmryListBasic(event.getAssetsOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;				
	}
	
	/**
	 * EES_MST_0041 : Detail<br>
	 * 연도별 자산 현황을 장비별로 상세 조회한다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */		
	private EventResponse searchAssetsDetailListService(Event e) throws EventException {		
		// PDTO(Data Transfer Object including Parameters)
		EesMst0041Event event = (EesMst0041Event)e;
		AssetsAuditMgtBC command = new AssetsAuditMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try{		
			List<AssetsDetailVO> list = command.searchAssetsDetailListBasic(event.getAssetsOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;				
	}
	
	/**
	 * ees_mst_0045 : retrieve<br>
	 * Container Average using Day by TP/SZ에 대한 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */		
	private EventResponse searchEqAverageUsingDayService(Event e) throws EventException
	{
		
		// PDTO(Data Transfer Object including Parameters)
		EesMst0045Event event = (EesMst0045Event)e;   
		AssetsAuditMgtBC command = new AssetsAuditMgtBCImpl();

		// GROUPVO로 리턴값 받음
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<EqAverageUsingDayVO> list = command.searchEqAverageUsingDayBasic(event.getEqAverageUsingDayVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;		
	}
	
	/**
	 * ees_mst_0046 : retrieve<br>
	 * Manufacture Date & Manufacturer Inquiry and Update에 대한 조회합니다.<br>
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
	 * Manufacture Date & Manufacturer Inquiry and Update에 대한 수정을 합니다.<br>
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
	 * Reefer Unit Info Inquiry and Update에 대한 조회합니다.<br>
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
	 * Reefer Unit Info Inquiry and Update에 대한 수정을 합니다.<br>
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
	 * EES_MST_0048,EES_MST_0049 : retrieve<br>
	 * 연도별 신조장비 제작 Serial Range를 Kind if Eq별로 조회한다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */		
	private EventResponse searchEqManufacturePlanListService(Event e) throws EventException {	
		// PDTO(Data Transfer Object including Parameters)
		AssetsAuditMgtBC command = new AssetsAuditMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EqMftPlanOptionVO eqMftPlanOptionVO = new EqMftPlanOptionVO();
		
		if (e.getEventName().equalsIgnoreCase("EesMst0048Event")){	
			EesMst0048Event event = (EesMst0048Event)e;
			eqMftPlanOptionVO = event.getEqMftPlanOptionVO();
		}else{
			EesMst0049Event event = (EesMst0049Event)e;
			eqMftPlanOptionVO = event.getEqMftPlanOptionVO();
		}
	    try{
	    	List<EqMftPlanListVO> list = command.searchEqManufacturePlanListBasic(eqMftPlanOptionVO);
	    	eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;				
	}
	
	
	/**
	 * EES_MST_0048,EES_MST_0048 : save<br>
	 * 연도별 신조장비 제작 Serial Range를 Kind if Eq별로 생성,수정한다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */		
	private EventResponse manageEqManufacturePlanListSerivice(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EesMst0048Event event = (EesMst0048Event)e;
			AssetsAuditMgtBC command = new AssetsAuditMgtBCImpl();
			
			try{
				begin();			
				List<EqMftPlanListVO> list = command.manageEqManufacturePlanListBasic(event.getEqMftPlanListVOs(),account);
				commit();	
				eventResponse.setRsVoList(list);
			}catch(EventException ex){
				rollback();
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}
	
	/**
	 * ees_mst_0028 : Re-Creation<br>
	 * CTM 에서 요청한 Master 정보를 수정하고, Container Status Update를 저장합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */		
	private EventResponse manageCntrReSoldStatusCreationService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0028Event event = (EesMst0028Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		StatusHistoryVO statushistoryVO = event.getStatusHistoryVO();
		IFMnrFlagVO[] iFMnrFlagVOs = null;
		
		try{
			iFMnrFlagVOs = new IFMnrFlagVO[1];
			iFMnrFlagVOs[0] = new IFMnrFlagVO();
			if (statushistoryVO.getCntrNo().length() == 10){
				statushistoryVO.setCntrNo(statushistoryVO.getCntrNo() + statushistoryVO.getChkDgt());
			} else {
				statushistoryVO.setCntrNo(statushistoryVO.getCntrNo());
			}
			iFMnrFlagVOs[0].setEqNo(statushistoryVO.getCntrNo());
			iFMnrFlagVOs[0] = command.searchSoldStatusBasic(iFMnrFlagVOs[0]);
			iFMnrFlagVOs[0].setFlagType("SLD");
			iFMnrFlagVOs[0].setStsFlag("Y");
			
			begin();
			command.createMNRStatusBasic(iFMnrFlagVOs, account);
			commit();	
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}