/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTimePerformanceMgtSC.java
*@FileTitle : Port Time Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.08 
* 1.0 Creation
* 2012.01.16 김민아 [CHM-201215697-01] Port Time Reduction관리 시스템 개발(1차)
* 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
* 2012.05.03 조경완 [CHM-201217535] [TOR] Port Time Activity Creation에 Double Call추가 외1건
* 2012.06.08 허철용 [CHM-201217512-01] PTRP 화면에 Dashboard 기능 추가 
* 2012.07.11 문동선 [CHM-201218855-01] Base line 입력화면 추가 / Dashboard에 반영
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt;

import java.util.List;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.basic.TerminalDepartureReportBC;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.basic.TerminalDepartureReportBCImpl;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MissingTDRCondVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MissingTDRVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.basic.OpfUtilBC;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.basic.OpfUtilBCImpl;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfCommonVariableVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.SearchVVDVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.basic.PortTimePerformanceMgtBC;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.basic.PortTimePerformanceMgtBCImpl;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event.VopOpf0401Event;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event.VopOpf0405Event;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event.VopOpf0406Event;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event.VopOpf0410Event;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event.VopOpf9401Event;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration.PortTimePerformanceMgtDBDAO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.GraphPerformanceListVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.GraphYtdListVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PerformanceSummaryVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortDoubleCallVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeActivityReportVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeActivityVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeKPIDetailVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimePerformanceConditionVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeVVDRemarkVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic.StevedoreDamageMgtBC;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic.StevedoreDamageMgtBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

/**
 * ALPS-PortTimePerformanceMgt Business Logic ServiceCommand - ALPS-PortTimePerformanceMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 
 * @see PortTimePerformanceMgtDBDAO
 * @since J2EE 1.6
 */

public class PortTimePerformanceMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PortTimePerformanceMgt system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("PortTimePerformanceMgtSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PortTimePerformanceMgt system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("PortTimePerformanceMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-PortTimePerformanceMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if(e.getEventName().equalsIgnoreCase("VopOpf0401Event")) {			/*Port Time Performance Report*/
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {			// Retrieve
				eventResponse = searchPortTimePerformanceSummaryList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//Port Code Key-off
            	eventResponse = searchChkPort(e);
            }else if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {	//Open
            	eventResponse = openVopOpf0401(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePortTimePerformanceVVDExceptList(e);
            }
		}else if(e.getEventName().equalsIgnoreCase("VopOpf9401Event")) {	/*Port Time Performance Dashboard Report*/
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {			// Retrieve
				eventResponse = searchGraphPerformanceList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//VVD Remark 조회
            	eventResponse = searchPortTimeVVDRemarkList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//VVD Baseline 조회
            	eventResponse = searchGraphBaselineList(e); 
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {		//VVD Remark 저장
            	eventResponse = managePortTimeVVDRemarkList(e);
            }
		}else if(e.getEventName().equalsIgnoreCase("VopOpf0405Event")) {	/*Port Time Activity Creation by VVD*/
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {			// Retrieve
				eventResponse = searchPortTimeAcitvityList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	// VSL CD Change
            	eventResponse = searchVslCd(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// SDK DIR CD Change
            	eventResponse = searchPortLaneCd(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {		// Save
            	eventResponse = managePortTimeAcitvityList(e);
            }else if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {	// Open
            	eventResponse = openVopOpf0405(e);
            }
		}else if(e.getEventName().equalsIgnoreCase("VopOpf0406Event")) {	/*Port Time Activity Report by VVD*/
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {			// Retrieve
				eventResponse = searchVVDPortTimeActivitySummaryList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//Port Code Key-off
            	eventResponse = searchChkPort(e);
            }else if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {	//Open
            	eventResponse = openVopOpf0406(e);
            } 
		}else if(e.getEventName().equalsIgnoreCase("VopOpf0410Event")) {	/*Port Time KPI Creation*/
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {			// Retrieve
				eventResponse = searchPortTimeKPIList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	// KPI Year OnChange
            	eventResponse = searchKPIYearVersionList(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// KPI Version OnChange
            	eventResponse = searchKPISvcLaneCodeList(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	// Lane OnChange
            	eventResponse = searchKPIRHQCodeList(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	// RHQ OnChange
            	eventResponse = searchKPIPortCodeList(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {	// PORT OnChange
            	eventResponse = searchChkPort(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {		// Creation
            	eventResponse = addPortTimeKPIVersionList(e);
            }else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {	// Delete
            	eventResponse = removePortTimeKPIList(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MODIFY)) {	// Save
            	eventResponse = modifyPortTimeKPIList(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) {	// Open, Year check
            	eventResponse = openVopOpf0410(e);
            }else if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {	// Open, Year check
            	eventResponse = openVopOpf0410(e);
            }	  
		}
		
		return eventResponse;
	}

	/**
	 * VOP_OPF_0401 : Retrieve<br>
	 * Port Time Performance Summary를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTimePerformanceSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0401Event event = (VopOpf0401Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();

		try{
			List<PerformanceSummaryVO> list = command.searchPortTimePerformanceSummaryList(event.getPortTimePerformanceConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0401, VOP_OPF_0406, VOP_OPF_0410 화면 : Port Code OnBlur
	 * Port Code Key-off 시 validation을 check 합니다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchChkPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String strPortCd = "";
		if("VopOpf0401Event".equals(e.getEventName())) {
			VopOpf0401Event event = (VopOpf0401Event)e;
			strPortCd = event.getPortTimePerformanceConditionVO().getPortCd();
		}else if("VopOpf0406Event".equals(e.getEventName())) {
			VopOpf0406Event event = (VopOpf0406Event)e;
			strPortCd = event.getPortTimePerformanceConditionVO().getPortCd();
		}else if("VopOpf0410Event".equals(e.getEventName())) {
			VopOpf0410Event event = (VopOpf0410Event)e;
			strPortCd = event.getPortTimePerformanceConditionVO().getPortCd();
		}
		
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
 
		try{
			MissingTDRCondVO missingTDRCondVO = new MissingTDRCondVO();
			missingTDRCondVO.setPortCd(strPortCd);
			List<MissingTDRVO> list = command.searchPortCodeNRhqOfcCdList(missingTDRCondVO);
			
			String portCd   = "";
			String rhqOfcCd = "";
			if (!list.isEmpty()){
				portCd   = list.get(0).getPortCd  ();
				rhqOfcCd = list.get(0).getRhqOfcCd();
			}
			eventResponse.setETCData("PORT_CD"   , portCd);
			eventResponse.setETCData("RHQ_OFC_CD", rhqOfcCd);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Port"}).getMessage(), ex);
		}		
		return eventResponse;		
	}
	
	/**
	 * VOP_OPF_0401 : Open <br>
	 * 화면 오픈시 필요한 코드정보를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse openVopOpf0401(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		OpfUtilBC command1 = new OpfUtilBCImpl();
		try {
			String rhqOfcCd = command1.searchRhqOfcCd(account.getOfc_cd());
			eventResponse.setETCData("RHQ_OFC_CD", rhqOfcCd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Port Time Performance Report" }).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_OPF_0401 : Save <br>
	 * Exp 정보를 저장 한다. <br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortTimePerformanceVVDExceptList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0401Event event = (VopOpf0401Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		
		try{
			begin();
			command.modifyPortTimePerformanceVVDExceptList(event.getPerformanceSummaryVOS(),account);
			// Success Message.
			eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex) {
			rollback();
			throw ex;
		}catch(Exception ex) {
			log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Time Performance Report"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_9401 : Retrieve <br>
	 * VVD Remark 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGraphPerformanceList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf9401Event event = (VopOpf9401Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		
		try {
			PortTimePerformanceConditionVO vo = (PortTimePerformanceConditionVO)event.getPortTimePerformanceConditionVO();

			List<GraphPerformanceListVO> list1 = command.searchGraphPerformanceList(vo);	//Performance
			List<GraphYtdListVO> list2 = command.searchGraphYtdList(vo);

			if(list1.size() > 0)
			{
				GraphPerformanceListVO graphPerformanceListVO = null;
				GraphPerformanceListVO orgGraphPerformanceListVO = null;
				GraphPerformanceListVO kpiGraphPerformanceListVO = new GraphPerformanceListVO();
				
				GraphYtdListVO graphYtdListVO = null;

				orgGraphPerformanceListVO = (GraphPerformanceListVO)list1.get(0);
				orgGraphPerformanceListVO = (GraphPerformanceListVO)list1.get(0);

				
				for(int i=0; i<list2.size(); i++)
				{
					graphYtdListVO = (GraphYtdListVO)list2.get(i);
					graphPerformanceListVO = new GraphPerformanceListVO();
					
					graphPerformanceListVO.setArrivalTime(graphYtdListVO.getArrivalTime());
					graphPerformanceListVO.setClptIndSeq(orgGraphPerformanceListVO.getClptIndSeq());
					graphPerformanceListVO.setDepartureTime(graphYtdListVO.getDepartureTime());
					graphPerformanceListVO.setGrossCraneProd(graphYtdListVO.getGrossCraneProd());
					graphPerformanceListVO.setOperationTimeT(graphYtdListVO.getOperationTimeT());
					graphPerformanceListVO.setPortCd(graphYtdListVO.getPortCd());
					graphPerformanceListVO.setRhq(graphYtdListVO.getRhq());
					graphPerformanceListVO.setSkdDirCd(graphYtdListVO.getSkdDirCd());
					graphPerformanceListVO.setSlanCd(graphYtdListVO.getSlanCd());
					graphPerformanceListVO.setSteamInTime(graphYtdListVO.getSteamInTime());
					graphPerformanceListVO.setVvdCd("YTD AVG");
					graphPerformanceListVO.setYdCd(orgGraphPerformanceListVO.getYdCd());
					list1.add(graphPerformanceListVO);
				}
				
				kpiGraphPerformanceListVO.setVvdCd("KPI");
				kpiGraphPerformanceListVO.setYdCd(orgGraphPerformanceListVO.getYdCd());
				kpiGraphPerformanceListVO.setRhq(orgGraphPerformanceListVO.getRhq());
				kpiGraphPerformanceListVO.setSkdDirCd(orgGraphPerformanceListVO.getSkdDirCd());
				kpiGraphPerformanceListVO.setSlanCd(orgGraphPerformanceListVO.getSlanCd());
				kpiGraphPerformanceListVO.setPortCd(orgGraphPerformanceListVO.getPortCd());
				kpiGraphPerformanceListVO.setClptIndSeq(orgGraphPerformanceListVO.getClptIndSeq());
				
				kpiGraphPerformanceListVO.setSteamInTime(orgGraphPerformanceListVO.getStmInHrs());
				kpiGraphPerformanceListVO.setOperationTimeT(orgGraphPerformanceListVO.getTmlOpHrs());
				kpiGraphPerformanceListVO.setTtlMvs(orgGraphPerformanceListVO.getTtlMvs());
				kpiGraphPerformanceListVO.setArrivalTime(orgGraphPerformanceListVO.getVslArrHrs());
				kpiGraphPerformanceListVO.setDepartureTime(orgGraphPerformanceListVO.getVslDepHrs());
				kpiGraphPerformanceListVO.setGrossCraneProd(orgGraphPerformanceListVO.getGrsCrnProdHrs());
				
				list1.add(kpiGraphPerformanceListVO);
				
				eventResponse.setRsVoList(list1);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Port Time Performance Dashboard Report" }).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_9401 : Retrieve <br>
	 * VVD Baseline 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGraphBaselineList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf9401Event event = (VopOpf9401Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		
		try {
			PortTimePerformanceConditionVO vo = (PortTimePerformanceConditionVO)event.getPortTimePerformanceConditionVO();

			List<GraphPerformanceListVO> list = command.searchGraphBaselineList(vo);
			eventResponse.setRsVoList(list);

			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Port Time Performance Dashboard Report" }).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_9401 : Retrieve <br>
	 * VVD Remark 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTimeVVDRemarkList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf9401Event event = (VopOpf9401Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		
		try {
			PortTimeVVDRemarkVO[] vos = (PortTimeVVDRemarkVO[])event.getPortTimeVVDRemarkVOs();

			if( vos != null) {
				List<PortTimeVVDRemarkVO> list = command.searchPortTimeVVDRemarkList(vos);
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Port Time Performance Dashboard Report" }).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_OPF_9401 : Save <br>
	 * VVD Remark 정보를 생성 및 변경한다. <br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortTimeVVDRemarkList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf9401Event event = (VopOpf9401Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		
		try{
			begin();
			command.managePortTimeVVDRemarkList(event.getPortTimeVVDRemarkVOs(), account);
			// Success Message.
			eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex) {
			rollback();
			throw ex;
		}catch(Exception ex) {
			log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Time Activity Creation"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0410 : Open <br>
	 * 화면 오픈시 필요한 코드정보를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse openVopOpf0410(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0410Event event = (VopOpf0410Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		StringBuffer data = new StringBuffer();
		String strData = "";

		try{
			List<PortTimeKPIDetailVO> list = command.searchKPILastYearVersion(event.getPortTimeKPIDetailVO());
			if(list != null && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					data.append(list.get(i).getKpiTgtYr()+","+list.get(i).getKpiTgtYr());
					data.append("|");
				}
				if (data.length() > 0){
					strData = data.toString();
					strData = strData.substring(0, strData.length()-1);
				}
			}
			
			eventResponse.setETCData("KPI_TGT_YR", strData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0410 : KPI Year OnChange <br>
	 * KPI Version 정보를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKPIYearVersionList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0410Event event = (VopOpf0410Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		StringBuffer data = new StringBuffer();
		String strData = "";

		try{
			List<PortTimeKPIDetailVO> list = command.searchKPIYearVersionList(event.getPortTimeKPIDetailVO());
			if(list != null && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					data.append(list.get(i).getKpiVerSeq()+","+list.get(i).getKpiVerSeq());
					data.append("|");
				}
				if (data.length() > 0){
					strData = data.toString();
					strData = strData.substring(0, strData.length()-1);
				}
			}
			
			eventResponse.setETCData("KPI_VER_SEQ", strData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0410 : KPI Version OnChange <br>
	 * KPI Lane 정보를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKPISvcLaneCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0410Event event = (VopOpf0410Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		StringBuffer data = new StringBuffer();
		String strData = "";

		try{
			List<PortTimeKPIDetailVO> list = command.searchKPISvcLaneCodeList (event.getPortTimeKPIDetailVO());
			if(list != null && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					data.append(list.get(i).getSlanCd()+","+list.get(i).getSlanCd());
					data.append("|");
				}
				if (data.length() > 0){
					strData = data.toString();
					strData = strData.substring(0, strData.length()-1);
				}
			}
			
			eventResponse.setETCData("LANE_CD", strData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0410 : Lane OnChange <br>
	 * KPI RHQ 정보를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKPIRHQCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0410Event event = (VopOpf0410Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		StringBuffer data = new StringBuffer();
		String strData = "";

		try{
			List<PortTimeKPIDetailVO> list = command.searchKPIRHQCodeList(event.getPortTimeKPIDetailVO());
			if(list != null && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					data.append(list.get(i).getRhqCd()+","+list.get(i).getRhqCd());
					data.append("|");
				}
				if (data.length() > 0){
					strData = data.toString();
					strData = strData.substring(0, strData.length()-1);
				}
			}
			
			eventResponse.setETCData("RHQ_CD", strData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0410 : KPI RHQ OnChange <br>
	 * KPI Port 정보를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKPIPortCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0410Event event = (VopOpf0410Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		StringBuffer data = new StringBuffer();
		String strData = "";

		try{
			List<PortTimeKPIDetailVO> list = command.searchKPIPortCodeList(event.getPortTimeKPIDetailVO());
			if(list != null && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					data.append(list.get(i).getVpsPortCd()+","+list.get(i).getVpsPortCd());
					data.append("|");
				}
				if (data.length() > 0){
					strData = data.toString();
					strData = strData.substring(0, strData.length()-1);
				}
			}
			
			eventResponse.setETCData("PORT_CD", strData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0410 : Retrieve <br>
	 * KPI 정보를 조회합니다. <br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTimeKPIList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0410Event event = (VopOpf0410Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		try{
			List<PortTimeKPIDetailVO> list = command.searchPortTimeKPIList(event.getPortTimeKPIDetailVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0410 : Creation <br>
	 * KPI 정보를 생성합니다. <br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse addPortTimeKPIVersionList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0410Event event = (VopOpf0410Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		
		try{
			begin();
			List<PortTimeKPIDetailVO> list = command.addPortTimeKPIVersionList(event.getPortTimeKPIDetailVOs(), account);
			eventResponse.setRsVoList(list);
			// Success Message.
			eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Time KPI Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0410 : Delete <br>
	 * KPI 정보를 삭제합니다. <br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removePortTimeKPIList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0410Event event = (VopOpf0410Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		
		try{
			begin();
			command.removePortTimeKPIList(event.getPortTimeKPIDetailVO());
			// Success Message.
			eventResponse.setUserMessage(new ErrorHandler("OPF00008",new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Time KPI Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0410 : Save <br>
	 * KPI 정보를 변경합니다. <br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPortTimeKPIList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0410Event event = (VopOpf0410Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		
		try{
			begin();
			command.modifyPortTimeKPIList(event.getPortTimeKPIDetailVOs(), account);
			// Success Message.
			eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Time KPI Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0405 : Open <br>
	 * 화면 오픈시 필요한 코드정보를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse openVopOpf0405(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		StringBuffer data = new StringBuffer();
		StringBuffer data2 = new StringBuffer();
		String strData = "";
		String strData2 = "";

		try{
			List<OpfCommonVariableVO> list = command.searchOprStopCodeList();
			if(list != null && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					data.append(list.get(i).getVal()+","+list.get(i).getName());
					data.append("|");
				}
				if (data.length() > 0){
					strData = data.toString();
					strData = strData.substring(0, strData.length()-1);
				}
			}
			eventResponse.setETCData("OPR_STOP_CD", strData);
			
			List<PortTimeActivityVO> list2 = command.searchAcitivityByPortTimeList();
			if(list2 != null && list2.size() > 0){
				for (int i = 0; i < list2.size(); i++) {
					data2.append(list2.get(i).getPortActGrpDesc()+","+list2.get(i).getPortActDesc()+","+list2.get(i).getPortActCtnt());
					data2.append("|");
				}
				if (data2.length() > 0){
					strData2 = data2.toString();
					strData2 = strData2.substring(0, strData2.length()-1);
				}
			}
			eventResponse.setETCData("INIT_DATA_CD", strData2);
			eventResponse.setRsVoList(list2);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0405 : VSL CD OnChange <br>
	 * 화면 오픈시 필요한 코드정보를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		VopOpf0405Event event = (VopOpf0405Event)e;
		String result = null;
		
		try{
			VskVslPortSkdVO vskVslPortSkdVO = event.getVskVslPortSkdVO();
			vskVslPortSkdVO.setAutoSkdCngFlg("VSL");
			result = command.checkMainCode(vskVslPortSkdVO);
			eventResponse.setETCData("VSL_CD", result);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0405 : SKD DIR CD OnChange <br>
	 * 화면 오픈시 필요한 코드정보를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortLaneCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		OpfUtilBC command = new OpfUtilBCImpl();
		PortTimePerformanceMgtBC command2 = new PortTimePerformanceMgtBCImpl();
		VopOpf0405Event event = (VopOpf0405Event)e;
		StringBuffer data = new StringBuffer();
		String strData = "";
		
		try{
			//VVD 정보 조회(SLANE)
			VskVslSkdVO vskVslSkdVO = event.getVskVslSkdVO();
			List<SearchVVDVO> list = command.searchVVD(vskVslSkdVO);
			if(list != null && list.size() > 0){
        		eventResponse.setETCData("LANE_CD", list.get(0).getVslSlanCd());
        	}else{
        		return eventResponse;
        	}	
			
			OpfUtilSearchOptVO opfUtilSearchOptVO = new OpfUtilSearchOptVO();
			opfUtilSearchOptVO.setVslCd(vskVslSkdVO.getVslCd());
			opfUtilSearchOptVO.setVoyNo(vskVslSkdVO.getSkdVoyNo());
			opfUtilSearchOptVO.setDirCd(vskVslSkdVO.getSkdDirCd());
			List<PortDoubleCallVO> list2 = command2.searchPortDoubleCallList(opfUtilSearchOptVO);
			
			if(list2 != null) {
			  if(list2.size() > 0) {
				for(int i = 0 ; i < list2.size() ; i++) {
					data.append(list2.get(i).getVal()+","+list2.get(i).getCallInd()+","+list2.get(i).getVport());
					data.append("|");
				}
				if(data.length()>0) {
					strData = data.toString();
					strData = strData.substring(0, strData.length()-1);
				}
			  }
			}
			
			eventResponse.setETCData("PORT_CD", strData);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0405 : Retrieve <br>
	 * Port Time Activity 탭페이지의 Grid에 표시할 정보를 조회 한다. <br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTimeAcitvityList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0405Event event = (VopOpf0405Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		
		try{
			//Tab1 Port Time Activity 조회
			event.getPortTimeActivityVO().setActGenCdId("CD00001");
			List<PortTimeActivityVO> list = command.searchPortTimeAcitvityList(event.getPortTimeActivityVO());
			
			//Tab2 Cargo Handling Type 조회
			event.getPortTimeActivityVO().setActGenCdId("CD00002");
			List<PortTimeActivityVO> list2 = command.searchPortTimeAcitvityList(event.getPortTimeActivityVO());
			
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Port Time Activity Creation" }).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0405 : Save <br>
	 * VVD Port별 Activity Time 정보를 생성 및 변경한다. <br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortTimeAcitvityList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0405Event event = (VopOpf0405Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		
		try{
			begin();
			command.managePortTimeAcitvityList(event.getPortTimeActivityVOs(), account);
			command.managePortTimeAcitvityList(event.getPortTimeActivityVOs2(), account);
			// Success Message.
			eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex) {
			rollback();
			throw ex;
		}catch(Exception ex) {
			log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Time Activity Creation"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0406 : Open <br>
	 * 화면 오픈시 필요한 코드정보를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse openVopOpf0406(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		OpfUtilBC command = new OpfUtilBCImpl();
		try {
			String rhqOfcCd = command.searchRhqOfcCd(account.getOfc_cd());
			eventResponse.setETCData("RHQ_OFC_CD", rhqOfcCd);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0406 : Retrieve <br>
	 * VVD별 Port Time Activity의 입력 현황 정보를 조회 한다. <br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVDPortTimeActivitySummaryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0406Event event = (VopOpf0406Event)e;
		PortTimePerformanceMgtBC command = new PortTimePerformanceMgtBCImpl();
		
		try{
			List<PortTimeActivityReportVO> list = command.searchVVDPortTimeActivitySummaryList(event.getPortTimePerformanceConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Port Time Activity Creation" }).getMessage(), ex);
		}
		return eventResponse;
	}
	
}