/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderIWSProxyIWSProxy.java
 *@FileTitle : WorkOrder Web-Service
 *Open Issues :
 *Change history :
 * 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
 *@LastModifyDate : 2007-08-03
 *@LastModifier : Jung-Jae Kim
 *@LastVersion : 1.1
 * 2006-12-22 doomi
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder;

import org.apache.log4j.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import weblogic.jws.WLHttpTransport;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderInboxResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderInboxRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderInboxRetrive2;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailUpdate;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailResponse;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.FillInEquipmentNoRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.FillInEquipmentNoResponse;


import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetResponse;

import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.SPPComplementSC;


import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0001Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0001EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0002Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0002EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0003Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0003EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0006Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0006EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0007Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0007EventResponse;


import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderInboxExcelPrint;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailExcelPrint;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.FillInEquipmentNoExcelPrint;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailExcelUploadRetrive;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailExcelUploadResponse;

/**
 * WorkOrder 에 대한 WebService Proxy<br>
 * 
 * @author doomi
 * @see WorkOrder 참조 
 * @since J2EE 1.4
 */
@WebService(name="WorkOrderIWSProxyPortType", serviceName="WorkOrderIWSProxy",
        targetNamespace="http://www.smlines.com/integration")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/WorkOrderIWSProxy",
             portName="WorkOrderIWSProxyPort")
public class WorkOrderIWSProxy {
	/**
	 * Log
	 */
	protected transient Logger log = Logger
			.getLogger(this.getClass().getName());

	/**
	 * 서비스명 제공
	 * 
	 * @return response String
	 */
	@WebMethod()
	public String getServiceName() {
		return "WorkOrder Web-Service";
	}

	/**
	 * W/O 조회(발행일자 별 조회)<br>
	 * 
	 * @param docIn
	 *            WorkOrderInboxRetrive
	 * @return response WorkOrderInboxResponse
	 * @exception EventException
	 */
	@WebMethod()
	public WorkOrderInboxResponse searchWorkOrderPeriod(
			WorkOrderInboxRetrive docIn) {
		  if(log.isDebugEnabled())log.debug("<<<<<<<<<<<<<<WorkOrderIWSProxy searchWorkOrderPeriod");
		Event event = null;
		WorkOrderInboxRSC rsc = new WorkOrderInboxRSC();
		WorkOrderInboxResponse docOut = new WorkOrderInboxResponse();

		try {
			/**
			 * EVENT 생성 / 전송
			 */

			event = new ExpPap0001Event(
									docIn.getParentVendorCode(), 
									docIn.getVendorCode(), 
									docIn.getDisp_dt_from(), 
									docIn.getDisp_dt_to(), 
									docIn.getWo_status(), 
									docIn.getIssue_type_cd(), 
									docIn.getInvoiced_cd(),
									docIn.getTrsp_kind_cd(), 
									docIn.getTrsp_mode_cd(), 
									docIn.getTrsp_type_cd(),
									docIn.getFm_location_cd(), 
									docIn.getTo_location_cd(), 
									docIn.getVia_location_cd(), 
									docIn.getDor_location_cd(),
									docIn.getWin_cd()
					);

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

			/**
			 * EventResponse로 부터 전송 객체의 생성
			 */
			ExpPap0001EventResponse eventResponse = (ExpPap0001EventResponse) rsc
					.perform(event);

			docOut.setWorkOrderInboxList(eventResponse.getWorkOrderInboxList());
			docOut.setCount(eventResponse.getTotalCount());
			docOut.setStatus("SUCCESS");
			
			
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
			//e.printStackTrace();
		}

		return docOut;
	}

	/**
	 * W/O 조회(WO 별 조회)<br>
	 * 
	 * @param docIn
	 *            WorkOrderInboxRetrive2
	 * @return response WorkOrderInboxResponse
	 * @exception EventException
	 */
	@WebMethod()
	public WorkOrderInboxResponse searchWorkOrderNo(WorkOrderInboxRetrive2 docIn) {

		Event event = null;
		WorkOrderInboxRSC rsc = new WorkOrderInboxRSC();
		WorkOrderInboxResponse docOut = new WorkOrderInboxResponse();

		try {

			event = new ExpPap0001Event(
					docIn.getParentVendorCode(), 
					docIn.getVendorCode(), 
					docIn.getTrsp_wo_no(), 
					docIn.getEq_tp_cd(), 
					docIn.getEq_no(),
					docIn.getBkg_no(), 
					docIn.getBl_no(),
					docIn.getBid_no()
					);

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH02);
			event.setFormCommand(f);

			ExpPap0001EventResponse eventResponse = (ExpPap0001EventResponse) rsc
					.perform(event);

			docOut.setWorkOrderInboxList(eventResponse.getWorkOrderInboxList());
			docOut.setCount(eventResponse.getTotalCount());
			docOut.setStatus("SUCCESS");
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
			//e.printStackTrace();
		}

		return docOut;
	}

	/**
	 * W/O Detaail 조회<br>
	 * 
	 * @param docIn
	 *            WorkOrderDetailRetrive
	 * @return response WorkOrderInboxResponse
	 * @exception EventException
	 */
	@WebMethod()
	public WorkOrderDetailResponse searchWorkOrderDetail(
			WorkOrderDetailRetrive docIn){

		Event event = null;
		WorkOrderDetailRSC rsc = new WorkOrderDetailRSC();
		WorkOrderDetailResponse docOut = new WorkOrderDetailResponse();

		try {

			event = new ExpPap0002Event(
					docIn.getVendorCode(), 
					docIn.getParentVendorCode(), 
					docIn.getTrsp_wo_no(), 
					docIn.getTrsp_so_no()	);

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			ExpPap0002EventResponse eventResponse = (ExpPap0002EventResponse) rsc.perform(event);

			docOut.setWorkOrderDetail(eventResponse.getWorkOrderDetail());
			docOut.setWorkOrderDetailTitle(eventResponse.getWorkOrderDetailTitle());
			docOut.setWorkOrderDetailList(eventResponse.getWorkOrderDetailList()); 
			
	
			docOut.setCount(eventResponse.getTotalCount());
			docOut.setStatus("SUCCESS");
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
			//e.printStackTrace();
		}
		return docOut;
	}



	/**
	 * Fill in Equipment No 조회<br>
	 * 
	 * @param docIn
	 *            FillInEquipmentNoRetrive
	 * @return response FillInEquipmentNoResponse
	 * @exception EventException
	 */
	@WebMethod()
	public FillInEquipmentNoResponse searchFillInEquipmentNo(
			FillInEquipmentNoRetrive docIn) {

		Event event = null;
		FillInEquipmentNoRSC rsc = new FillInEquipmentNoRSC();
		FillInEquipmentNoResponse docOut = new FillInEquipmentNoResponse();

		try {

			event = new ExpPap0003Event(
					docIn.getVendorCode(), 
					docIn.getParentVendorCode(), 
					docIn.getTrsp_wo_no());

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			ExpPap0003EventResponse eventResponse = (ExpPap0003EventResponse) rsc
					.perform(event);
			docOut.setFillInEquipmentNoList(eventResponse
					.getFillInEquipmentNoList());
			docOut.setCount(eventResponse.getTotalCount());
			docOut.setStatus("SUCCESS");
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
			//e.printStackTrace();
		}

		return docOut;
	}

	/**
	 * W/O Detaail 갱신<br>
	 * 
	 * @param docIn2
	 *            WorkOrderDetailUpdate
	 * @return response WorkOrderDetailResponse
	 * @exception EventException
	 */
	@WebMethod()
	public WorkOrderDetailResponse modifyWorkOrderDetail(
			WorkOrderDetailUpdate docIn2)  {

		Event event = null;
		WorkOrderDetailRSC rsc = new WorkOrderDetailRSC();
		SPPComplementSC rsc1 = new SPPComplementSC();
		
		WorkOrderDetailResponse docOut = new WorkOrderDetailResponse();

		try {

			event = new ExpPap0002Event(
				docIn2.getUserID(), 
				docIn2.getVendorCode(), 
				docIn2.getWorkOrderNo(), 
				docIn2.getSubmitMode(), 
				docIn2.getWorkOrderDetailSubmitRejectList());

			FormCommand f = new FormCommand();
			
			if (docIn2.getSubmitMode().equals("S")) {
				f.setCommand(FormCommand.MODIFY);
			}else {
				f.setCommand(FormCommand.MULTI);
			}
			event.setFormCommand(f);

			log.info("[START]modifyWorkOrderDetail here~~~~~~~~~~~~~~~~~~~");
			
			if (docIn2.getSubmitMode().equals("S")) {
				ExpPap0002EventResponse eventResponse = (ExpPap0002EventResponse) rsc.perform(event);
				docOut.setCount(eventResponse.getCount());
				log.info("[SUBMIT]docOut.getCount::::::::::::::::::::::::::::::"+docOut.getCount());
			}else {
			
				ExpPap0002EventResponse eventResponse = (ExpPap0002EventResponse) rsc1.perform(event);
				docOut.setCount(eventResponse.getCount());
				log.info("[REJECT]docOut.getCount::::::::::::::::::::::::::::::"+docOut.getCount());
			}
			/**
			 * 전송 데이터 생성
			 */
			//docOut.setCount(eventResponse.getCount());
			docOut.setStatus("SUCCESS");
			log.info("docOut.getStatus::::::::::::::::::::::::::::::"+docOut.getStatus());

		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
			//e.printStackTrace();
		}

		return docOut;
	}

	/**
	 * WorkOrderInboxExcelPrint<br>
	 * 
	 * @param docIn
	 *            WorkOrderInboxExcelPrint
	 * @return response WorkOrderInboxResponse
	 * @exception EventException
	 */
	@WebMethod()
	public WorkOrderInboxResponse searchInboxExcelPrint(
			WorkOrderInboxExcelPrint docIn) {
      if(log.isDebugEnabled())log.debug("<<<<<<<<<<<<<<WorkOrderIWSProxy searchInboxExcelPrint");
		Event event = null;
		WorkOrderInboxRSC rsc = new WorkOrderInboxRSC();
		WorkOrderInboxResponse docOut = new WorkOrderInboxResponse();

		try {
if(log.isDebugEnabled())log.debug("   getWorkOrderNo : "+docIn	.getWorkOrderNo() + "   getVendorCode : "+docIn   .getVendorCode());
			event = new ExpPap0001Event(
				docIn	.getWorkOrderNo(),
				docIn   .getVendorCode());

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH03);
			event.setFormCommand(f);

			ExpPap0001EventResponse eventResponse = (ExpPap0001EventResponse) rsc
					.perform(event);

			docOut.setWorkOrderInboxList(eventResponse.getWorkOrderInboxList());
			docOut.setWorkorderInboxExcelHeader(eventResponse.getWorkOrderInbox());
			docOut.setCount(eventResponse.getTotalCount());
			docOut.setStatus("SUCCESS");
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
			//e.printStackTrace();
		}

		return docOut;
	}

	/**
	 * WorkOrderDetailExcelPrint<br>
	 * 
	 * @param docIn
	 *            WorkOrderDetailExcelPrint
	 * @return response WorkOrderInboxResponse
	 * @exception EventException
	 */
	@WebMethod()
	public WorkOrderDetailResponse searchDetailExcelPrint(
			WorkOrderDetailExcelPrint docIn) {

		Event event = null;
		WorkOrderDetailRSC rsc = new WorkOrderDetailRSC();
		WorkOrderDetailResponse docOut = new WorkOrderDetailResponse();

		try {

			event = new ExpPap0002Event(
				docIn	.getTrsp_so_no());

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

			ExpPap0002EventResponse eventResponse = (ExpPap0002EventResponse) rsc
					.perform(event);

			docOut.setWorkOrderDetailList(eventResponse
					.getWorkOrderDetailList());
			docOut.setCount(eventResponse.getTotalCount());
			docOut.setStatus("SUCCESS");
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
			//e.printStackTrace();
		}

		return docOut;
	}

	/**
	 * Fill in Equipment No 조회<br>
	 * 
	 * @param docIn
	 *            FillInEquipmentNoRetrive
	 * @return response FillInEquipmentNoResponse
	 * @exception EventException
	 */
	@WebMethod()
	public FillInEquipmentNoResponse searchFillInEqNoExcelPrint(FillInEquipmentNoExcelPrint docIn) {

		Event event = null;
		FillInEquipmentNoRSC rsc = new FillInEquipmentNoRSC();
		FillInEquipmentNoResponse docOut = new FillInEquipmentNoResponse();

		try {

			event = new ExpPap0003Event(
							docIn.getEq_no());

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

			ExpPap0003EventResponse eventResponse = (ExpPap0003EventResponse) rsc
					.perform(event);
			docOut.setFillInEquipmentNoList(eventResponse
					.getFillInEquipmentNoList());
			docOut.setCount(eventResponse.getTotalCount());
			docOut.setStatus("SUCCESS");
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
			//e.printStackTrace();
		}

		return docOut;
	}

	
	
	
	/**
	 * W/O Sheet 조회<br>
	 * 
	 * @param docIn
	 *            WorkOrderSheetRetrive
	 * @return response WorkOrderSheetResponse
	 * @exception EventException
	 */
	@WebMethod()
	public WorkOrderSheetResponse searchWorkOrderSheet(WorkOrderSheetRetrive docIn) {

		Event event = null;
		WorkOrderSheetRSC rsc = new WorkOrderSheetRSC();
		WorkOrderSheetResponse docOut = new WorkOrderSheetResponse();

		try {

			event = new ExpPap0006Event( 
					docIn.getVendorCode(),
					docIn.getParentVendorCode(), 
					docIn.getWorkOrderNo());
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			ExpPap0006EventResponse eventResponse = (ExpPap0006EventResponse) rsc.perform(event); 

			docOut.setWorkOrderSheetFormatType(eventResponse.getWorkOrderSheetFormatType());
			docOut.setWorkOrderSheet(eventResponse.getWorkOrderSheet());
			docOut.setWorkOrderSheetTotalQuantity(eventResponse.getWorkOrderSheetTotalQuantity());
			docOut.setWorkOrderSheetList(eventResponse.getWorkOrderSheetList());
			docOut.setWorkOrderSheetList2(eventResponse.getWorkOrderSheetList2());
			docOut.setWorkOrderSheetCargoAwkward(eventResponse.getWorkOrderSheetCargoAwkward());
			docOut.setWorkOrderSheetCargoReefer(eventResponse.getWorkOrderSheetCargoReefer());
			docOut.setWorkOrderSheetCargoDg(eventResponse.getWorkOrderSheetCargoDg());
			docOut.setWorkOrderSheetSecondList(eventResponse.getWorkOrderSheetSecondList());
			
			log.info("eventResponse.getWorkOrderSheetFormatType() = "+eventResponse.getWorkOrderSheetFormatType());
			log.info("eventResponse.getWorkOrderSheet() = "+eventResponse.getWorkOrderSheet());
			
			docOut.setCount(eventResponse.getTotalCount());
			docOut.setStatus("SUCCESS");
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
			//e.printStackTrace();
		}
		return docOut;
	}	
	
	
	
	
	/**
	 * W/O Detaail Excel Upload 조회<br>
	 * 
	 * @param docIn
	 *            WorkOrderDetailExcelUploadRetrive
	 * @return response WorkOrderDetailExcelUploadResponse
	 * @exception EventException
	 */
	@WebMethod()
	public WorkOrderDetailExcelUploadResponse searchWorkOrderExcelUpload(
			WorkOrderDetailExcelUploadRetrive docIn){

		Event event = null;
		WorkOrderDetailRSC rsc = new WorkOrderDetailRSC();
		WorkOrderDetailExcelUploadResponse docOut = new WorkOrderDetailExcelUploadResponse();

		try {

			event = new ExpPap0007Event(			
					docIn.getEq_no());

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			ExpPap0007EventResponse eventResponse = (ExpPap0007EventResponse) rsc.perform(event);
			docOut.setWorkOrderDetailExcelUploadList(eventResponse.getWorkOrderDetailExcelUploadList());
			
			docOut.setCount(eventResponse.getTotalCount());
			//docOut.setStatus("SUCCESS");
			
		
		} catch (EventException e) {
			log.error(e.getMessage(), e);
			docOut.setStatus(e.getMessage());
			//e.printStackTrace();
		}
		return docOut;
	}
	
	
 
	
}
