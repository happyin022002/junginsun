/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvOfcAtrtMgmtBCImpl.java
*@FileTitle : TRS Invoice Authority
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.16
*@LastModifier : 유선오
*@LastVersion :  1.2
  2011.11.09 SunOh,You
* 1.0 최초 생성
* ------------------------------------------------------------------
* History
* 2011.11.09 유선오 1.1 [CHM-201114273][TRS] Invoice 권한등록 프로그램 개발
* 2011.11.16 유선오 1.2 [CHM-201114273][TRS] R4J 소스 품질 조치 내역 수정 :line No 30 클래스의 주석을 기술
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.basic;
import java.util.List;

import com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.event.EsdTrs0976Event;
import com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.intergration.InvOfcAtrtMgmtDBDAO;
import com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.vo.InvoiceOfficeAuthorityManagementVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
    
	/**
	 * ESD-TRS Business Logic Basic Command implementation<br>
	 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
	 *
	 * @author Yoo,SunOh
	 * @see ESD_TRS_0976EventResponse,InvOfcAtrtMgmtBC 각 DAO 클래스 참조
	 * @since J2EE 1.6
	 */
    public class InvOfcAtrtMgmtBCImpl extends BasicCommandSupport implements InvOfcAtrtMgmtBC{

	       private transient InvOfcAtrtMgmtDBDAO dbDao=null;
	       public InvOfcAtrtMgmtBCImpl(){
	       dbDao = new InvOfcAtrtMgmtDBDAO();
	}
     
	 /**
	  * 조회 이벤트 처리<br>
	  * form에 OFFIECODE 조회하여 리스트를 가져오는 이벤트 처리<br>
	  * @param e
	  * @return response ESD_TRS_0976EventResponse
	  * @exception EventException
	  */
	 @Override
	 public EventResponse searchInvOfcAtrtMgmtList(Event e)throws EventException {
		 
		 EsdTrs0976Event event=(EsdTrs0976Event)e;	
		 List<InvoiceOfficeAuthorityManagementVO> vos= null;
		 GeneralEventResponse eventResponse = new GeneralEventResponse();
	     try {
			vos =dbDao.searchInvOfcAtrtMgmtList(event.getInvoiceOfficeAuthorityManagementVO());	
			//eventResponse.setRsVo(vo);
			eventResponse.setRsVoList(vos);
			return eventResponse;
	    	} catch (DAOException de){
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		 }
	 }	
	 
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceOffice화면에 대한 OFFIECODE 조회 이벤트 처리<br>
	 * @param e
	 * @return response ESD_TRS_0976EventResponse
	 * @exception EventException
	 */
	 public InvoiceOfficeAuthorityManagementVO searchOfficeCode(Event e) throws EventException {
		
		    EsdTrs0976Event event	= (EsdTrs0976Event)e;
		    FormCommand formcommand = e.getFormCommand();	
		    InvoiceOfficeAuthorityManagementVO vo=null;
		    try{
		    	vo = dbDao.searchOfficeCode(event);
		    	GeneralEventResponse eventResponse = new GeneralEventResponse();			
		    if(formcommand.isCommand(FormCommand.SEARCH19))
			    eventResponse.setETCData("ROW", event.getRow());
				event.setInvoiceOfficeAuthorityManagementVO(vo);
			return vo;						
		    } catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		    } catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		    } 
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_0976 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0976Event
	 * @return EventResponse ESD_TRS_0976EventResponse
	 * @exception EventException
	 */
	@Override
	public EventResponse multiInvoiceOfficeAuthorityManagement(Event e)throws EventException {
		
		   EsdTrs0976Event event=(EsdTrs0976Event)e;
	       GeneralEventResponse eventResponse = new GeneralEventResponse();
	       try {
	    	 dbDao.multiTRS_TRSP_INV_OFC(event);
	       } catch (DAOException de) {
	    	 log.error("err "+de.toString(),de);
			 throw new EventException(de.getMessage());
	       }
	   	  return eventResponse;
	}
    
	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_0976 화면에 대한 삭제 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0976Event
	 * @return EventResponse ESD_TRS_0976EventResponse
	 * @exception EventException
	 */
	@Override
	public EventResponse removeInvoiceOffice(Event e) throws EventException {
		
		EsdTrs0976Event event=(EsdTrs0976Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.removeInvoiceOffice(event);
		  } catch (DAOException de) {
		    log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	    }
    }

	
	
	
	
	