/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingCancelManageBCImpl.java
*@FileTitle : Rail Billing Cancel
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
* 2012.12.24 변종건 [CHM-201221767-01] Rail billing Cancel 로직 수정(TRS)
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.basic;

import java.util.ArrayList;

import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.event.RailBillingCancelEvent;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.event.RailBillingCancelEventResponse;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.integration.RailBillingCancelManageDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Sang-Woo
 * @see WORejectEventResponse,WORejectManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RailBillingCancelManageBCImpl   extends BasicCommandSupport implements RailBillingCancelManageBC {

	// Database Access Object
	private transient RailBillingCancelManageDBDAO dbDao=null;
	
	/**
	 * WORejectManageBCImpl 객체 생성<br>
	 * WORejectManageDBDAO를 생성한다.<br>
	 */
	public RailBillingCancelManageBCImpl(){
		dbDao = new RailBillingCancelManageDBDAO();
	}

	//2012.12.24 변종건 [CHM-201221767-01] Rail billing Cancel 로직 수정(TRS)
	//기존 처리 로직 주석 처리( SPP를 통한 기존 Cancel 처리 기능을 블럭 처리하고 동일 명칭의 메소드로 새 소스 적용 - 유저의 원복 처리 요청이 있을 것을 대비함 )
//	/**
//	 * 멀티 이벤트 처리<br>
//	 * WORejectEvent에 대한 멀티 이벤트 처리<br>
//	 * 
//	 * @param e WORejectEvent
//	 * @return EventResponse WORejectEventResponse
//	 * @exception EventException
//	 */
//	public EventResponse cancelRailBillingList(Event e) throws EventException{
//		// PDTO(Data Transfer Object including Parameters)
//		ArrayList arrSeq = null;
//		ArrayList mtModel = new ArrayList();
//		RailBillingCancelEvent event=(RailBillingCancelEvent)e;
//		String[] sTrspSoOfcCtyCd = event.getTrsp_so_ofc_cty_cd();
//		String[] sCgoTpCd = event.getCgo_tp_cd();
//		
//		EventResponse eventResponse = null;
//		EventResponse event028response = null;
//		
//		TrsTrspRailBilOrdVO[] trsTrspRailBilOrdVOS = TrsTrspRailBilOrdVO.fromRequestWrs(event, event.getTrsp_so_seq().length);
//		EsdTrs0201Event event2 = new EsdTrs0201Event();
//		event2.setTrsTrspRailBilOrdVos(trsTrspRailBilOrdVOS);
//		event2.setSctrlUserId(event.getUserID());
//		event2.setUserid(event.getUserID());
//		event2.setSctrlOfcCd(event.getOfc_cd());
//		
//		
//		TrsTrspEdiRailOrdVO[] trsTrspEdiRailOrdVOS = TrsTrspEdiRailOrdVO.fromRequestWrs(event, event.getTrsp_so_seq().length);
//		EsdTrs0028Event event3 = new EsdTrs0028Event();
//		event3.setTrsTrspEdiRailOrdVos(trsTrspEdiRailOrdVOS);
//		event3.setCtrlUserId(event.getUserID());
//		event3.setUserId(event.getUserID());
//		event3.setCtrlOfcCd(event.getOfc_cd());
//
//		try {
//			RailSoManageBC command204 = new RailSoManageBCImpl();
//			USA404EDIStatusInquiryBC command28 = new USA404EDIStatusInquiryBCImpl();
//			
//			for(int i=0; i<sTrspSoOfcCtyCd.length; i++){
//				if("F".equals(sCgoTpCd[i])){
//					arrSeq = dbDao.multiCancelRailBillingList(event, i);					
//				}else if("M".equals(sCgoTpCd[i])){
//					eventResponse = command28.multi02USA404EDIStatusInquiryForSpp(event3, i);
//					mtModel.add(eventResponse.getRsVoList());
//				}
//			}
//			
//			//COP Replan을 위해 
//			TrsTrspEdiRailOrdVO[] model = event3.getTrsTrspEdiRailOrdVOS();
//			ReplanManageBC replanManageBC = new ReplanManageBCImpl();//BC생성
//
//			for ( int i=0; i<model.length; i++ ) {
//				if (model[i].getCgoTpCd().equals("F")) {
//					model[i].setTrspSoStsCd("P");
//					
//					//COP TRS S/O Status Update
//					replanManageBC.modifySoList(model[i]);
//				}
//			}
//			
//			for(int v=0; mtModel!=null && v<mtModel.size(); v++){
//				event028response = command28.search04USA404EDIStatusSend((ArrayList)mtModel.get(v)); // EDI 404 Search
//				command28.search04SubUSA404EDIStatusSend(event028response.getRs()); // EDI 404				
//			}
//			
//			command204.removeRailSoManageForSpp(event.getOfc_cd(), event2);
//			
//			return new RailBillingCancelEventResponse(arrSeq);    
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(new ErrorHandler(de).getMessage(), de);			
//		} catch (Exception de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(new ErrorHandler(de).getMessage(), de); 
//		}
//	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * WORejectEvent에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e WORejectEvent
	 * @return EventResponse WORejectEventResponse
	 * @exception EventException
	 */
	public EventResponse cancelRailBillingList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		ArrayList arrSeq = null;
		RailBillingCancelEvent event=(RailBillingCancelEvent)e;
		String[] sTrspSoOfcCtyCd = event.getTrsp_so_ofc_cty_cd();
		
		try {
			for(int i=0; i<sTrspSoOfcCtyCd.length; i++){
				arrSeq = dbDao.multiCancelRailBillingList(event, i);
			}
			
			return new RailBillingCancelEventResponse(arrSeq);    
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de); 
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SingleTransportationSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}