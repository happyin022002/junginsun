/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselOperationIrregularMgtSC.java
*@FileTitle : SPCL CGO Irregular Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.vesseloperationirregularmgt;

import java.util.List;

import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.basic.SpecialCargoIrregularMgtBC;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.basic.SpecialCargoIrregularMgtBCImpl;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event.VopScg0012Event;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event.VopScg0013Event;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event.VopScg201301Event;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.BKGOutputVO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.CNTRInfoVO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrrFileListVO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrregularVO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrregularsVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCarrierVO;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmVslCntrVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.ScgImdgClssCdVO;
import com.clt.syscommon.common.table.ScgImdgCompGrpVO;
import com.clt.syscommon.common.table.ScgImdgUnNoVO;


/**
 * OPUS-VesselOperationIrregularMgt Business Logic ServiceCommand - Handling business transactions of OPUS-VesselOperationIrregularMgt.
 * 
 * @author
 * @see SpecialCargoIrregularMgtDBDAO
 * @since J2EE 1.6
 */

public class VesselOperationIrregularMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * VesselOperationIrregularMgt system preceding process for biz scenario<br>
	 * VOP_SCG_0013 related objects creation<br>
	 */
	public void doStart() {
		log.debug("VesselOperationIrregularMgtSC start");
		try {
			// comment --> login check
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * VesselOperationIrregularMgt system biz scenario closing<br>
	 * VOP_SCG_0013 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("VesselOperationIrregularMgtSC end");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// When SC handles multiple events
		if (e.getEventName().equalsIgnoreCase("VopScg0013Event")) {
			//SPCL CGO Irregular retrieve
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIrregular(e);
			}
			//SPCL CGO Irregular multi
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageIrregular(e);
			}
			//SPCL CGO Irregular delete
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeIrregular(e);
			}
			//SPCL CGO Irregular's BKG No. related info retrieve
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBKGInfo(e);
			}
			//SPCL CGO Irregular's Container related info retrieve
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCNTRList(e);
			}
			//SPCL CGO Irregular's Container related info retrieve
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCNTRInfo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg201301Event")) {
			//SPCL CGO Irregular's File list retrieve
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIrrFileList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0012Event")) {
			//SPCL CGO Irregular List retrieve
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIrrHistList(e);
			}
			//SPCL CGO Irregular's Lane Combo retrieve
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchIrrLaneList(e);
			}
			//SPCL CGO Irregular's Vessel Combo retrieve
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchIrrVslList(e);
			}
			//SPCL CGO Irregular's VSL OPR Combo retrieve
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchIrrVslOprList(e);
			}
			//SPCL CGO Irregular's CGO OPR Combo retrieve
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchIrrCgoOprList(e);
			}
			//SPCL CGO Irregular's Class Combo retrieve
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchIrrClassList(e);
			}
			//SPCL CGO Irregular's Class Comp Combo retrieve
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchIrrClassCompList(e);
			}
			//SPCL CGO Irregular's UN No. Combo retrieve
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchIrrUnNoList(e);
			}
			//SPCL CGO Irregular's Location Combo retrieve
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchIrrPortCdList(e);
			}
			//SPCL CGO Irregular's Combo all retrieve
			else {
				eventResponse = searchIrrHistComboList(e);
			}
		}
		return eventResponse;
	}
	/**
	 * VOP_SCG_0013 : Retrieve <br>
	 * SPCL CGO Irregular retrieve <br>
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
	 * SPCL CGO Irregular save <br>
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
	 * SPCL CGO Irregular delete <br>
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
	 * SPCL CGO Irregular Booking info retrieve<br>
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
	 * SPCL CGO Irregular Container list retrieve<br>
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
	 * SPCL CGO Irregular Container list retrieve<br>
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
	 * SPCL CGO Irregular File list retrieve<br>
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
	 * SPCL CGO Irregular List retrieve <br>
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
	 * SPCL CGO Irregular List Lane retrieve <br>
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
	 * SPCL CGO Irregular List Vessel retrieve <br>
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
	 * SPCL CGO Irregular List Vessel Operator retrieve <br>
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
	 * SPCL CGO Irregular List Cargo Operator retrieve <br>
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
	 * SPCL CGO Irregular List Class retrieve <br>
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
	 * SPCL CGO Irregular List Class Comp retrieve <br>
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
	 * SPCL CGO Irregular List Un No. retrieve <br>
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
	 * SPCL CGO Irregular List Location retrieve <br>
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
	 * SPCL CGO Irregular List All Combo retrieve <br>
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