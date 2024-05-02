/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselOperationIrregularMgtSC.java
*@FileTitle : SPCL CGO Irregular Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.05.29 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.basic.SpecialCargoIrregularMgtBC;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.basic.SpecialCargoIrregularMgtBCImpl;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event.VopScg0012Event;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event.VopScg0013Event;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event.VopScg201301Event;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.BKGOutputVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.CNTRInfoVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrrFileListVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrregularVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrregularsVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgUnNoVO;
import com.hanjin.syscommon.common.table.MdmCarrierVO;


/**
 * ALPS-VesselOperationIrregularMgt Business Logic ServiceCommand - ALPS-VesselOperationIrregularMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author HyunUk Kim
 * @see SpecialCargoIrregularMgtDBDAO
 * @since J2EE 1.6
 */

public class VesselOperationIrregularMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * VesselOperationIrregularMgt system 업무 시나리오 선행작업<br>
	 * VOP_SCG_0013업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("VesselOperationIrregularMgtSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * VesselOperationIrregularMgt system 업무 시나리오 마감작업<br>
	 * VOP_SCG_0013 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("VesselOperationIrregularMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-VesselOperationIrregularMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopScg0013Event")) {
			//SPCL CGO Irregular 조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIrregular(e);
			}
			//SPCL CGO Irregular 멀티
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageIrregular(e);
			}
			//SPCL CGO Irregular 삭제
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeIrregular(e);
			}
			//SPCL CGO Irregular의 BKG No. 관련정보 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBKGInfo(e);
			}
			//SPCL CGO Irregular의 Container 목록 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCNTRList(e);
			}
			//SPCL CGO Irregular의 Container 관련정보 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCNTRInfo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg201301Event")) {
			//SPCL CGO Irregular의 File 목록 조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIrrFileList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0012Event")) {
			//SPCL CGO Irregular List 조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIrrHistList(e);
			}
			//SPCL CGO Irregular의 Lane Combo 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchIrrLaneList(e);
			}
			//SPCL CGO Irregular의 Vessel Combo 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchIrrVslList(e);
			}
			//SPCL CGO Irregular의 VSL OPR Combo 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchIrrVslOprList(e);
			}
			//SPCL CGO Irregular의 CGO OPR Combo 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchIrrCgoOprList(e);
			}
			//SPCL CGO Irregular의 Class Combo 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchIrrClassList(e);
			}
			//SPCL CGO Irregular의 Class Comp Combo 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchIrrClassCompList(e);
			}
			//SPCL CGO Irregular의 UN No. Combo 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchIrrUnNoList(e);
			}
			//SPCL CGO Irregular의 Location Combo 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchIrrPortCdList(e);
			}
			//SPCL CGO Irregular의 Combo 전체 조회
			else {
				eventResponse = searchIrrHistComboList(e);
			}
		}
		return eventResponse;
	}
	/**
	 * VOP_SCG_0013 : Retrieve <br>
	 * SPCL CGO Irregular 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrregular(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0013Event event = (VopScg0013Event)e;
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			IrregularVO vo = command.searchIrregular(event.getIrregularVO());
			
			eventResponse.setETCData(vo.getColumnValues());  
			eventResponse.setRsVoList(vo.getIrrCntrVOL());
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Irregular"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * VOP_SCG_0013 : Save <br>
	 * SPCL CGO Irregular 을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageIrregular(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0013Event event = (VopScg0013Event)e;
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();
		try{
			begin();
			command.manageIrregular(event.getIrregularVO(), event.getKeys(), account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Irregular"}).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * VOP_SCG_0013 : Delete <br>
	 * SPCL CGO Irregular 을 삭제 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeIrregular(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0013Event event = (VopScg0013Event)e;
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();
		try{
			begin();
			command.removeIrregular(event.getIrregularVO());
			eventResponse.setUserMessage(new ErrorHandler("SCG00006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Irregular"}).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * VOP_SCG_0013 : Focus Out <br>
	 * SPCL CGO Irregular 의 Booking 정보 를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBKGInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0013Event event = (VopScg0013Event)e;
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			List<BKGOutputVO> list = command.searchBKGInfo(event.getBkgBookingVO());			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Booking Infomation"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0013 : Combo <br>
	 * SPCL CGO Irregular 의 Container 목록 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCNTRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0013Event event = (VopScg0013Event)e;
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			List<CNTRInfoVO> list = command.searchCNTRList(event.getBkgBookingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Container"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0013 : Focus Out <br>
	 * SPCL CGO Irregular 의 Container 정보 를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCNTRInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0013Event event = (VopScg0013Event)e;
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			List<CNTRInfoVO> list = command.searchCNTRInfo(event.getCNTRInfoInputVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Container"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0013 : Pop Up <br>
	 * SPCL CGO Irregular 의 File 목록 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrrFileList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg201301Event event = (VopScg201301Event)e;
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			List<IrrFileListVO> list = command.searchIrrFileList(event.getIrregularVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"File List"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0012 : Retrieve <br>
	 * SPCL CGO Irregular List 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrrHistList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0012Event event = (VopScg0012Event)e;
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			List<IrregularsVO> list = command.searchIrrHistList(event.getIrregularsVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Irregular"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0012 : Combo <br>
	 * SPCL CGO Irregular List 의 Lane 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrrLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			List<MdmVslSvcLaneVO> list = command.searchIrrLaneList();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Lane Code"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0012 : Combo <br>
	 * SPCL CGO Irregular List 의 Vessel 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrrVslList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			List<MdmVslCntrVO> list = command.searchIrrVslList();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Operator"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0012 : Combo <br>
	 * SPCL CGO Irregular List 의 Vessel Operator 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrrVslOprList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			List<MdmCarrierVO> list = command.searchIrrVslOprList();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Operator"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0012 : Combo <br>
	 * SPCL CGO Irregular List 의 Cargo Operator 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrrCgoOprList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			List<MdmCarrierVO> list = command.searchIrrCgoOprList();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Operator"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0012 : Combo <br>
	 * SPCL CGO Irregular List 의 Class 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrrClassList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			List<ScgImdgClssCdVO> list = command.searchIrrClassList();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Class Code"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0012 : Combo <br>
	 * SPCL CGO Irregular List 의 Class Comp 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrrClassCompList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0012Event event = (VopScg0012Event)e;
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			List<ScgImdgCompGrpVO> list = command.searchIrrClassCompList(event.getScgImdgClssCdVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Class Compatiblity"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0012 : Combo <br>
	 * SPCL CGO Irregular List 의 Un No. 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrrUnNoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			List<ScgImdgUnNoVO> list = command.searchIrrUnNoList();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"UN No."}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0012 : Combo <br>
	 * SPCL CGO Irregular List 의 Location 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrrPortCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0012Event event = (VopScg0012Event)e;
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			List<MdmLocationVO> list = command.searchIrrPortCdList(event.getMdmLocationVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Location"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0012 : All Combo <br>
	 * SPCL CGO Irregular List 의 All Combo 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrrHistComboList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoIrregularMgtBC command = new SpecialCargoIrregularMgtBCImpl();

		try{
			List<MdmVslSvcLaneVO> list0 = command.searchIrrLaneList();
			eventResponse.setCustomData("laneCombo", list0);
			
			List<MdmVslCntrVO> list1 = command.searchIrrVslList();
			eventResponse.setCustomData("vslCombo", list1);
			
			List<MdmCarrierVO> list2 = command.searchIrrVslOprList();
			eventResponse.setCustomData("vslOprCombo", list2);
			
			List<MdmCarrierVO> list3 = command.searchIrrCgoOprList();
			eventResponse.setCustomData("cgoOprCombo", list3);
			
			List<ScgImdgClssCdVO> list4 = command.searchIrrClassList();
			eventResponse.setCustomData("classCombo", list4);
			
			List<ScgImdgCompGrpVO> list5 = command.searchIrrClassCompList(null);
			eventResponse.setCustomData("clsCompCombo", list5);
			
			List<ScgImdgUnNoVO> list6 = command.searchIrrUnNoList();
			eventResponse.setCustomData("unNoCombo", list6);
			
			MdmLocationVO vo = new MdmLocationVO();
			
			vo.setLocTpCd("POR");			
			List<MdmLocationVO> list7 = command.searchIrrPortCdList(vo);
			eventResponse.setCustomData("porCombo", list7);
			
			vo.setLocTpCd("POL");
			List<MdmLocationVO> list8 = command.searchIrrPortCdList(vo);
			eventResponse.setCustomData("polCombo", list8);
			
			vo.setLocTpCd("POD");
			List<MdmLocationVO> list9 = command.searchIrrPortCdList(vo);
			eventResponse.setCustomData("podCombo", list9);
			
			vo.setLocTpCd("DEL");
			List<MdmLocationVO> list10 = command.searchIrrPortCdList(vo);
			eventResponse.setCustomData("delCombo", list10);
			
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Combo List"}).getMessage(), ex);
		}		
		return eventResponse;
	}
}