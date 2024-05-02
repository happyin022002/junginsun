/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ScheduleUtilityManagementSC.java
 *@FileTitle : ScheduleUtilityManagementSC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.09.29
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.09.29 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleutilitymanagement;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration.ProformaScheduleMgtDBDAO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.CoastalScheduleMgtBC;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.VesselScheduleMgtBCImpl;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdXtraHisVO;
import com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.basic.ConsortiumVoyageMgtBC;
import com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.basic.ConsortiumVoyageMgtBCImpl;
import com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.event.VopVsk5001Event;
import com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.vo.ConsortiumVoyageVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.basic.InterfaceScheduleToExternalBC;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.basic.InterfaceScheduleToExternalBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfDtlVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfMstVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.CSSMVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.basic.InterfaceScheduleToExternalScnBC;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.basic.InterfaceScheduleToExternalScnBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * SchedulePlanningOperation Business Logic ServiceCommand - Handling Business Transaction about SchedulePlanningOperation
 * 
 * @author
 * @see ProformaScheduleMgtDBDAO
 * @since J2EE 1.4
 */

public class ScheduleUtilityManagementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
 
	/**
	 * SchedulePlanningOperation system preceding process for biz scenario<br>
	 * UI_VSK-0241 related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {log.error(e.getMessage());}
	}

	/**
	 * ScheduleUtilityManagementSC system biz scenario closing<br>
	 * UI_VSK-0241 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("ScheduleUtilityManagementSC END");
	}

	/**
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("VopVsk5001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchConsortiumVoyage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyConsortiumVoyage(e);
			}
		}
		return eventResponse;
	}
		
	/**
	 * VOP_VSK_0018 : Retrieve
	 * VOP_VSK_0059 : Retrieve
	 * 
	 * Retrieving Vessel Schedule by Lane or Vessel 
	 * 
	 * @param Event e
	 * @return EventResponse 
	 * @exception EventException
	 */
	private EventResponse searchConsortiumVoyage(Event e) throws EventException {
		ConsortiumVoyageVO vo = null;
		
		if(e instanceof VopVsk5001Event){
			VopVsk5001Event event = (VopVsk5001Event)e;
			vo = event.getConsortiumVoyageVO();
		}
		
		ConsortiumVoyageMgtBC command = new ConsortiumVoyageMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		if(vo != null) {
			List<ConsortiumVoyageVO> list = command.searchConsortiumVoyage(vo);
			eventResponse.setRsVoList(list);
		}
		return eventResponse;
	}
	
	private EventResponse modifyConsortiumVoyage(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ConsortiumVoyageVO[] consortiumVoyageVOs = null;
		
		List<ConsortiumVoyageVO> listConsortiumVoyageVO = new ArrayList<ConsortiumVoyageVO>();
		List<CSSMVO> 		listCSSMVO 		= new ArrayList<CSSMVO>();	
		
		if(e instanceof VopVsk5001Event){
			VopVsk5001Event event = (VopVsk5001Event)e;
			consortiumVoyageVOs = event.getConsortiumVoyageVOs();
		}
		
		ConsortiumVoyageMgtBC 		command 	= new ConsortiumVoyageMgtBCImpl	();
		CoastalScheduleMgtBC 		command2 	= new VesselScheduleMgtBCImpl	();
		
		try{	
			
			begin();
			
			if(consortiumVoyageVOs != null) {
				
				for (int voRow = 0; voRow < consortiumVoyageVOs.length; voRow++) {
					
					if ("U".equals(consortiumVoyageVOs[voRow].getIbflag())) {	
						
						ConsortiumVoyageVO   consortiumVoyageVO  = new ConsortiumVoyageVO();
						
						consortiumVoyageVO.setVslSlanCd		(consortiumVoyageVOs[voRow].getVslSlanCd());		
						consortiumVoyageVO.setVslCd			(consortiumVoyageVOs[voRow].getVslCd());					
						consortiumVoyageVO.setSkdVoyNo		(consortiumVoyageVOs[voRow].getSkdVoyNo());					
						consortiumVoyageVO.setSkdDirCd		(consortiumVoyageVOs[voRow].getSkdDirCd());					
						consortiumVoyageVO.setVpsPortCd		(consortiumVoyageVOs[voRow].getVpsPortCd());	
						consortiumVoyageVO.setClptIndSeq	(consortiumVoyageVOs[voRow].getClptIndSeq());
						consortiumVoyageVO.setIbCssmVoyNo	(consortiumVoyageVOs[voRow].getIbCssmVoyNo());
						consortiumVoyageVO.setObCssmVoyNo	(consortiumVoyageVOs[voRow].getObCssmVoyNo());
						consortiumVoyageVO.setUpdUsrId		(account.getUsr_id());
						consortiumVoyageVO.setUpdDt			(consortiumVoyageVOs[voRow].getUpdDt());
						//Next Direction's Virtual Port Update를 위한 Flg
						consortiumVoyageVO.setVoyAllSetFlg	(consortiumVoyageVOs[voRow].getVoyAllSetFlg());
						
						listConsortiumVoyageVO.add			(consortiumVoyageVO);
						
						if(consortiumVoyageVOs[voRow].getIbCssmVoyNo() != null || consortiumVoyageVOs[voRow].getObCssmVoyNo() != null ){
							CSSMVO csm 						= new CSSMVO();
							csm.setVslCd					(consortiumVoyageVOs[voRow].getVslCd());
							csm.setSkdVoyNo					(consortiumVoyageVOs[voRow].getSkdVoyNo());
							csm.setSkdVoyNo					(consortiumVoyageVOs[voRow].getSkdVoyNo());					
							csm.setSkdDirCd					(consortiumVoyageVOs[voRow].getSkdDirCd());					
							csm.setVpsPortCd				(consortiumVoyageVOs[voRow].getVpsPortCd());	
							csm.setClptIndSeq				(consortiumVoyageVOs[voRow].getClptIndSeq());
							csm.setIbCssmVoyNo				(consortiumVoyageVOs[voRow].getIbCssmVoyNo());
							csm.setObCssmVoyNo				(consortiumVoyageVOs[voRow].getObCssmVoyNo());
							csm.setVslSlanCd				(consortiumVoyageVOs[voRow].getVslSlanCd());	
							csm.setCreUsrId					(account.getUsr_id());
							csm.setUpdUsrId					(account.getUsr_id());
							
							listCSSMVO.add					(csm);
						}
					}
					
				}
			}
			
			
			if (listConsortiumVoyageVO.size() > 0) {
				command.modifyConsortiumVoyage		(listConsortiumVoyageVO);	
			}
			
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			
			commit();
			
			
			// :: VIPS START ::
			List<VskVipsIfMstVO> vskVipsIfMstVOs	= cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList()));
			
			InterfaceScheduleToExternalBC ifCommand = new InterfaceScheduleToExternalBCImpl();
			////ifCommand.createVskVipsIf(cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList())), cnvtToIfDtl(command.getVslPortSkdList()), "U");
			ifCommand.createVskVipsIf(vskVipsIfMstVOs, cnvtToIfDtl(command.getVslPortSkdList()), "U");
			// :: VIPS END ::
			
			
			/** INTERFACE TO SAVE VESSEL SCHEDULE CHANGE HISTORY FOR INTERNAL PURPOSE ************/
			List<VslSkdXtraHisVO>	vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
			
			for(VskVipsIfMstVO tmpVO1:vskVipsIfMstVOs){
				
				VslSkdXtraHisVO			tmpVO2				= new VslSkdXtraHisVO();
				
				tmpVO2.setBfrVslCd		(tmpVO1.getVslCd		());
				tmpVO2.setBfrSkdVoyNo	(tmpVO1.getSkdVoyNo		());
				tmpVO2.setBfrSkdDirCd   (tmpVO1.getSkdDirCd		());
				tmpVO2.setUpdUsrId		(account.getUsr_id()	  );
				
				vslSkdXtraHisVOs.add	(tmpVO2);
			}
			
			command2.createVesselScheduleExtraChangeHistory(vslSkdXtraHisVOs, "CSSM_UPDATE");		
			/*************************************************************************************/
			
			/********************************************************************************
			 * Add new functionality interfaced to SCN(NYK Legacy System related with EDI)
			 * 2016-10-07
			 * 
			 ********************************************************************************/
			InterfaceScheduleToExternalScnBC scnCmd = new InterfaceScheduleToExternalScnBCImpl();
			
			List<VskVslSkdVO>	tmpVskVslSkdVOs	= command.getVskVslSkdList();
			List<VskVslSkdVO>	scnVskVslSkdVOs	= new ArrayList<VskVslSkdVO>();
			List<String>		tmpStrList		= new ArrayList<String>();
			
			for(VskVslSkdVO tmpVO2 : tmpVskVslSkdVOs){
				
				VskVslSkdVO tmpVO	= new VskVslSkdVO();
				String 		sTmpStr	= tmpVO2.getVslCd()+tmpVO2.getSkdVoyNo()+tmpVO2.getSkdDirCd();
				
				tmpVO.setVslCd		(tmpVO2.getVslCd	());
				tmpVO.setSkdVoyNo	(tmpVO2.getSkdVoyNo	());
				tmpVO.setSkdDirCd	(tmpVO2.getSkdDirCd	());
				
				if(tmpVO != null && !tmpStrList.contains(sTmpStr)){
					scnVskVslSkdVOs.add	(tmpVO);
					tmpStrList.add		(sTmpStr);
				}
			}
			
			if(scnVskVslSkdVOs != null && scnVskVslSkdVOs.size() > 0){
				scnCmd.manageScnCssmIf(scnVskVslSkdVOs);
			}
			/********************************************************************************/
			
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
//	private EventResponse modifyConsortiumVoyage(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		
//		ConsortiumVoyageVO[] 		consortiumVoyageVOs 	= null;
//		List<ConsortiumVoyageVO> 	listConsortiumVoyageVO 	= new ArrayList<ConsortiumVoyageVO>();
//		
//		if(e instanceof VopVsk5001Event){
//			VopVsk5001Event event = (VopVsk5001Event)e;
//			consortiumVoyageVOs = event.getConsortiumVoyageVOs();
//		}
//		
//		ConsortiumVoyageMgtBC command = new ConsortiumVoyageMgtBCImpl();
//		
//		try{	
//			
//			begin();
//			
//			if(consortiumVoyageVOs != null) {
//				
//				for (int voRow = 0; voRow < consortiumVoyageVOs.length; voRow++) {
//					
//					if ("U".equals(consortiumVoyageVOs[voRow].getIbflag())) {					
//						ConsortiumVoyageVO   consortiumVoyageVO  = new ConsortiumVoyageVO();
//						
//						consortiumVoyageVO.setVslSlanCd		(consortiumVoyageVOs[voRow].getVslSlanCd	());		
//						consortiumVoyageVO.setVslCd			(consortiumVoyageVOs[voRow].getVslCd		());					
//						consortiumVoyageVO.setSkdVoyNo		(consortiumVoyageVOs[voRow].getSkdVoyNo		());					
//						consortiumVoyageVO.setSkdDirCd		(consortiumVoyageVOs[voRow].getSkdDirCd		());					
//						consortiumVoyageVO.setVpsPortCd		(consortiumVoyageVOs[voRow].getVpsPortCd	());	
//						consortiumVoyageVO.setClptIndSeq	(consortiumVoyageVOs[voRow].getClptIndSeq	());
//						consortiumVoyageVO.setIbCssmVoyNo	(consortiumVoyageVOs[voRow].getIbCssmVoyNo	());
//						consortiumVoyageVO.setObCssmVoyNo	(consortiumVoyageVOs[voRow].getObCssmVoyNo	());
//						consortiumVoyageVO.setUpdUsrId		(account.getUsr_id());
//						
//						listConsortiumVoyageVO.add			(consortiumVoyageVO);
//					
//					}
//				}
//				
//				command.modifyConsortiumVoyageList			(listConsortiumVoyageVO);
//				
//				// :: VIPS START ::
//				InterfaceScheduleToExternalBC ifCommand = new InterfaceScheduleToExternalBCImpl();
//				ifCommand.createVskVipsIf(cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList())), cnvtToIfDtl(command.getVslPortSkdList()), "U");
//				// :: VIPS END ::
//			}
//				
//			commit();
//			
//		}catch(EventException ex){
//			rollback();
//			throw ex;
//		}catch(Exception ex){
//			rollback();
//			throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;
//	}
	
	
	// :: VIPS START ::
	/**
	 * VskVslSkdVO를 VskVipsIfMstVO로 변환한다.
	 * @param List<VskVslSkdVO> vskVslSkdList
	 * @return List<VskVipsIfMstVO>
	 */
	private List<VskVipsIfMstVO> cnvtToIfMst(List<VskVslSkdVO> vskVslSkdList) {
		List<VskVipsIfMstVO> vskVipsIfMstList = new ArrayList<VskVipsIfMstVO>();
		for(int i=0;i<vskVslSkdList.size();i++) {
			VskVslSkdVO vo = (VskVslSkdVO) vskVslSkdList.get(i);
			VskVipsIfMstVO vskVipsIfMstVO = new VskVipsIfMstVO();
			vskVipsIfMstVO.setSkdDirCd(vo.getSkdDirCd());
			vskVipsIfMstVO.setSkdVoyNo(vo.getSkdVoyNo());
			vskVipsIfMstVO.setVslCd(vo.getVslCd());
			vskVipsIfMstVO.setVslSlanCd(vo.getVslSlanCd());
			vskVipsIfMstVO.setPfSvcTpCd(vo.getPfSkdTpCd());
			vskVipsIfMstList.add(vskVipsIfMstVO);
		}
		return vskVipsIfMstList;
	}
	
	/**
	 * VslPortSkdVO를 VskVipsIfDtlVO로 변환한다.
	 * @param List<VslPortSkdVO> vslPortSkdList
	 * @return List<VskVipsIfDtlVO>
	 */
	private List<VskVipsIfDtlVO> cnvtToIfDtl(List<VskVslPortSkdVO> vslPortSkdList){
		List<VskVipsIfDtlVO> vskVipsIfDtlList = new ArrayList<VskVipsIfDtlVO>();

		List<String> portList = new ArrayList<String>();
		for(int i=0;i<vslPortSkdList.size();i++) {
			VskVslPortSkdVO vo = (VskVslPortSkdVO) vslPortSkdList.get(i);
			String vslPortKey = vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd() 
				      + vo.getVpsPortCd() + vo.getClptIndSeq();
			if(!portList.contains(vslPortKey)) {
				portList.add(vslPortKey);
				VskVipsIfDtlVO vskVipsIfDtlVO = setIfDtl(vo);
				vskVipsIfDtlList.add(vskVipsIfDtlVO);
			}
		}
		return vskVipsIfDtlList;
	}
	
	/**
	 * setIfDtl : VskVipsIfDtlVO common setting
	 * @param VskVslPortSkdVO vo
	 * @return VskVipsIfDtlVO
	 */
	private VskVipsIfDtlVO setIfDtl(VskVslPortSkdVO vo) {
		VskVipsIfDtlVO vskVipsIfDtlVO = new VskVipsIfDtlVO();
		vskVipsIfDtlVO.setVipsIbConsortiumVoyNo(vo.getIbCssmVoyNo());
		vskVipsIfDtlVO.setVipsObConsortiumVoyNo(vo.getObCssmVoyNo());
		vskVipsIfDtlVO.setVipsVpsEtaDt(vo.getVpsEtaDt());
		vskVipsIfDtlVO.setVipsVpsEtbDt(vo.getVpsEtbDt());
		vskVipsIfDtlVO.setVipsVpsEtdDt(vo.getVpsEtdDt());
		vskVipsIfDtlVO.setVslCd(vo.getVslCd());
		vskVipsIfDtlVO.setSkdVoyNo(vo.getSkdVoyNo());
		vskVipsIfDtlVO.setSkdDirCd(vo.getSkdDirCd());
		vskVipsIfDtlVO.setVpsPortCd(vo.getVpsPortCd());
		vskVipsIfDtlVO.setClptIndSeq(vo.getClptIndSeq());
		vskVipsIfDtlVO.setClptSeq(vo.getClptSeq());
		vskVipsIfDtlVO.setPortSkdStsCd(vo.getPortSkdStsCd());
		vskVipsIfDtlVO.setYdCd(vo.getYdCd());
		vskVipsIfDtlVO.setCallYdIndSeq(vo.getCallYdIndSeq());
		vskVipsIfDtlVO.setSkdCngStsCd(vo.getSkdCngStsCd());
		vskVipsIfDtlVO.setPfEtaDt(vo.getPfEtaDt());
		vskVipsIfDtlVO.setPfEtbDt(vo.getPfEtbDt());
		vskVipsIfDtlVO.setPfEtdDt(vo.getPfEtdDt());
		vskVipsIfDtlVO.setInitEtaDt(vo.getInitEtaDt());
		vskVipsIfDtlVO.setInitEtbDt(vo.getInitEtbDt());
		vskVipsIfDtlVO.setInitEtdDt(vo.getInitEtdDt());
		vskVipsIfDtlVO.setTurnPortFlg(vo.getTurnPortFlg());
		vskVipsIfDtlVO.setTurnPortIndCd(vo.getTurnPortIndCd());
		vskVipsIfDtlVO.setTurnSkdVoyNo(vo.getTurnSkdVoyNo());
		vskVipsIfDtlVO.setTurnSkdDirCd(vo.getTurnSkdDirCd());
		vskVipsIfDtlVO.setTurnClptIndSeq(vo.getTurnClptIndSeq());
		vskVipsIfDtlVO.setSkdUpdUsrId(vo.getUpdUsrId());
		vskVipsIfDtlVO.setSkdUpdDt(vo.getUpdDt());
		vskVipsIfDtlVO.setAddCallFlg(vo.getAddCallFlg());
		vskVipsIfDtlVO.setVtAddCallFlg(vo.getVtAddCallFlg());
		return vskVipsIfDtlVO;
	}
	
	/**
	 * makePortToVsl:port정보로 Vessel정보를 작성한다.
	 * @param List<VskVslSkdVO> vslSkdList
	 * @param List<VskVslPortSkdVO> vslPortSkdList
	 * @return List<VskVslSkdVO>
	 * @throws Exception
	 */
	private List<VskVslSkdVO> makePortToVsl(List<VskVslSkdVO> vslSkdList, List<VskVslPortSkdVO> vslPortSkdList) throws Exception {
		List<VskVslSkdVO> vskVslSkdList = new ArrayList<VskVslSkdVO>();
		List<String> vvds = new ArrayList<String>();
		for(VskVslSkdVO vo : vslSkdList) {
			// duplication check(vessel info)
			String vvd = vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd();
			if(!vvds.contains(vvd)) {
				vskVslSkdList.add(vo);
				vvds.add(vvd);
			}
		}
		// vsl정보가 없는 port의 경우 port로 vsl정보를 만든다.
		for(VskVslPortSkdVO vo : vslPortSkdList) {
			// duplication check(vessel info)
			String vvd = vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd();
			if(!vvds.contains(vvd)) {
				VskVslSkdVO vsl = new VskVslSkdVO();
				vsl.setVslCd(vo.getVslCd());
				vsl.setSkdVoyNo(vo.getSkdVoyNo());
				vsl.setSkdDirCd(vo.getSkdDirCd());
				vsl.setVslSlanCd(vo.getSlanCd());
				vskVslSkdList.add(vsl);
				vvds.add(vvd);
			}
		}
		return vskVslSkdList;
		
	}
	// :: VIPS END ::
}