/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FCMCommonSC
*@FileTitle : FCMCommonSC
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.fcmcommon;

import java.util.List;

import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.basic.VesselReportBC;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.basic.VesselReportBCImpl;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event.VopFcm0001Event;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRptInqVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS VesselReport ServiceCommand - VesselReport 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Hyuk Ryu
 * @see 
 * @since J2EE 1.6
 */

public class FCMCommonSC extends ServiceCommandSupport {

	// Login User Information
	protected SignOnUserAccount account = null;

	/**
	 * FCMCommonSC system 업무 시나리오 선행작업<br>
	 */
	public void doStart() {
		log.debug("FCMCommonSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * FCMCommonSC system 업무 시나리오 마감작업<br>
	 */
	public void doEnd() {
		log.debug("FCMCommonSC 종료");
	}
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS VesselReport system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	@Override
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopFcm0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslRptSkdInfo(e);
			}			
		}
		return eventResponse;
	}
	

	/**
	 * VOP_FCM_0001  : Display <br>
	 * Vessel Report에 대한 주어진 구간의 스케줄 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslRptSkdInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0001Event event = (VopFcm0001Event)e;
		VesselReportBC command = new VesselReportBCImpl();
		
		try {
				StringBuilder sb = new StringBuilder();
				List<List<VslRptInqVO>> vslDepRptList = command.searchVslRptSkdInfo(event.getVslRptInqVO());
				
				if(vslDepRptList.size()>0){
					List<VslRptInqVO> vslSlanCds = vslDepRptList.get(0);
					sb = new StringBuilder();
					for(int i=0; i<vslSlanCds.size(); i++){
						sb.append(vslSlanCds.get(i).getVslSlanCd());
						if(i<vslSlanCds.size()-1){
							sb.append(",");
						}
					}
				}
				
				eventResponse.setETCData("vsl_slan_cd", sb.toString());
				
				if(vslDepRptList.size()>1){
					List<VslRptInqVO> vslCds = vslDepRptList.get(1);
					sb = new StringBuilder();
					for(int i=0; i<vslCds.size(); i++){
						sb.append(vslCds.get(i).getVslCd());
						if(i<vslCds.size()-1){
							sb.append(",");
						}
					}
				}
				
				eventResponse.setETCData("vsl_cd", sb.toString());
				
				if(vslDepRptList.size()>2){
					List<VslRptInqVO> vpsPortCds = vslDepRptList.get(2);
					sb = new StringBuilder();
					for(int i=0; i<vpsPortCds.size(); i++){
						sb.append(vpsPortCds.get(i).getVpsPortCd());
						if(i<vpsPortCds.size()-1){
							sb.append(",");
						}
					}
				}
				
				eventResponse.setETCData("vps_port_cd", sb.toString());
						
			
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Departure Report" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
}
