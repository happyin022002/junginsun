/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationDetailBCImpl.java
*@FileTitle : SPP TRS Invoice Creation Submit Basic Command Implementation
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-02-05 sunghwan cho : submitExpenseConversion() 추가
* 2007-03-05 sunghwan cho : Invoice Surcharge 계산방법 변경
* 2007-04-04 sunghwan cho : Submit 기능을 PI eNIS모듈 호출방식으로 변경하여, 관련 루틴 삭제
* 2007-04-10 sunghwan cho : getCreateOfficeCode 추가
* 2007-04-23 sunghwan cho : Invoice Office 취득 SQL 변경
*@LastModifyDate : 2007-04-23
*@LastModifier : sunghwan cho
*@LastVersion : 1.5
=========================================================
History
2012.01.12 윤권영 [CHM-201215602][SPP] Multi invoice creation function 상에 W/O No. 유효성 여부 체크 로직 추가 요청
2012.02.15 윤권영 [CHM-201216122][SPP] Cancelled W/O 에 대한 Invoice 처리 불가 메세지 추가(1건)
2012.02.22 윤권영 [] 품질 결함 수정-메소드 주석을 기술한다:확인결과 해당사항 없음.
2012.03.02 윤권영 [] 품질 결함 수정-메소드 주석을 기술한다 : @return 에 대한 return; 를 추가적용(3건)
2012.03.13 윤권영 [] 품질 결함 수정-메소드 주석을 기술한다 : 메소드 주석 @return 삭제(3건)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.basic;

//Inquiry
import java.util.ArrayList;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.MultiInvoiceCreationDetailList;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsI02Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsU02Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration.InvoiceCreationDetailDBDAO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * Basic Command Implementation<br>
 * - SPP TRS Invoice Creation Submit Basic Command Implementation<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceCreationDetailBCImpl extends BasicCommandSupport implements InvoiceCreationDetailBC {
	private static final long serialVersionUID = 1L;
	
	//Database Access Object
	private transient InvoiceCreationDetailDBDAO dbDao=null;

	/**
	 * 생성자<br>
	 * 
	 * @param void
	 * @return void
	 * @exception 
	 */
	public InvoiceCreationDetailBCImpl(){
		dbDao = new InvoiceCreationDetailDBDAO();
	}

	/**
	 * doEnd<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
	
	/**
	 * searchInvoiceCreationDetailList<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return invoiceCreationData InvoiceCreationInquiry[]
	 * @exception EventException
	 */
	public InvoiceCreationInquiry[] searchInvoiceCreationDetailList(Event e) throws EventException {
		
		//PDTO(Data Transfer Object including Parameters)
		SppTrsI02Event event = (SppTrsI02Event)e;
		InvoiceCreationInquiry[] invoiceCreationData = null;

		try {
			invoiceCreationData = dbDao.searchInvoiceCreationDetailList(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return invoiceCreationData;
		
	}
    
    /**
	 * getParentVendorCode<br>
	 * 
	 * @param vendorCode int
	 * @return iResult int
	 * @exception EventException
	 */
	public int getParentVendorCode(int vendorCode) throws EventException {
		int iResult = 0;
		try {
			iResult = dbDao.getParentVendorCode(vendorCode);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return iResult;
	}

	/**
	 * getParentVendorCode<br>
	 * 
	 * @param officeCode String
	 * @return sResult String
	 * @exception EventException
	 */
	public String getCreateOfficeCode(String officeCode) throws EventException {
		String sResult = "";
		try {
			sResult = dbDao.getCreateOfficeCode(officeCode);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return sResult;
	}
	
	/**
	 * getReceiveDate<br>
	 * 
	 * @param officeCode String
	 * @return response String
	 * @exception EventException
	 */
	public String getReceiveDate(String officeCode) throws EventException {
		String sResult = "";
		try {
			sResult = dbDao.getReceiveDate(officeCode);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return sResult;
	}
	
	/**
	 * searchInvoiceCreationDetailList<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return invoiceCreationData InvoiceCreationInquiry[]
	 * @exception EventException
	 */
	public MultiInvoiceCreationDetailList checkMultiInvoiceValue(Event e) throws EventException {
		//PDTO(Data Transfer Object including Parameters)
		SppTrsU02Event event = (SppTrsU02Event)e;
		MultiInvoiceCreationDetailList multiInvoiceCreationData = new MultiInvoiceCreationDetailList();
		String errInvNo[] = null;
		String errWoNo[] = null;
		String errMsg 	= null;
		//String errMsg2 	= null;
		
		try {
			errInvNo = dbDao.checkMultiInvoiceNo(event);
			ArrayList tmpList = new ArrayList();
			for (int nCnt=0;nCnt<event.getMultiInvoiceCreationDetailList().length;nCnt++){
				String wo_no[] = event.getMultiInvoiceCreationDetailList()[nCnt].getWorkOrderNo();
				for (int k=0;k<wo_no.length;k++) {
					errMsg = dbDao.checkExistMultiWorkOrderNo(wo_no[k],event.getVendorCode());
					log.debug("errMsg : " +errMsg);
					if(errMsg.length() > 0){
						tmpList.add(wo_no[k]+" : " +errMsg);
					}
				}
				if(tmpList.isEmpty()) {
					for (int j=0;j<wo_no.length;j++) {
						errMsg = dbDao.checkMultiWorkOrderNo(wo_no[j],event.getVendorCode(),event.getInvCode());
						log.debug("errMsg : " +errMsg);
						if(errMsg.length() > 0){
							tmpList.add(wo_no[j]+" : " +errMsg);
						}					
					}
				}
				
			}
			if(!tmpList.isEmpty()) {
				errWoNo = (String[])tmpList.toArray(new String[0]);
			}else if(tmpList.isEmpty()){
				for (int nCnt=0;nCnt<event.getMultiInvoiceCreationDetailList().length;nCnt++){
					String wo_no[] = event.getMultiInvoiceCreationDetailList()[nCnt].getWorkOrderNo();
					for (int j=0;j<wo_no.length;j++) {
						errMsg = dbDao.checkMultiCtmMvmt(wo_no[j],event.getVendorCode());
						log.debug("errMsg : " +errMsg);
						if(errMsg.length() > 0){
							tmpList.add(wo_no[j]+" : " +errMsg);
						}						
					}
				}
				if(!tmpList.isEmpty()) {
					errWoNo = (String[])tmpList.toArray(new String[0]);
				}
			}

			multiInvoiceCreationData.setErrInvoiceNo(errInvNo);
			multiInvoiceCreationData.setErrWorkOrderNo(errWoNo);
		
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return multiInvoiceCreationData;
		
	}
	
	/**
	 * saveMultiInvoice<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return int 
	 * @exception EventException
	 */
	public int saveMultiInvoice(Event e) throws EventException {
		//PDTO(Data Transfer Object including Parameters)
		SppTrsU02Event event = (SppTrsU02Event)e;
		int rtCode = 0;
		try {
			dbDao.saveMultiInvoiceNo(event);
			dbDao.saveMultiWorkOrderNo(event);
			dbDao.saveMultiWorkOrderOpnFlgUpd(event);
			dbDao.saveMultiInvoiceLog(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return rtCode;
		
	}
	
	
	/**
	 * checkWOAmountChange<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @exception EventException
	 */
	public void checkWOAmountChange(Event e) throws EventException {
		//PDTO(Data Transfer Object including Parameters)
		SppTrsU02Event event = (SppTrsU02Event)e;
		try {		
			dbDao.checkWOAmountChange(event);
		}catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return;
	}
    
	
	/**
	 * checkContainerMovementStatus<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @exception EventException
	 */
	public void checkContainerMovementStatus(Event e) throws EventException {
		//PDTO(Data Transfer Object including Parameters)
		SppTrsU02Event event = (SppTrsU02Event)e;
		try {		
			dbDao.checkContainerMovementStatus(event);
		}catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return;
	}
	
	
	/**
	 * checkExistWorkOrderNo<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @exception EventException
	 */
	public void checkExistWorkOrderNo(Event e) throws EventException {
		//PDTO(Data Transfer Object including Parameters)
		SppTrsU02Event event = (SppTrsU02Event)e;
		try {		
			dbDao.checkExistWorkOrderNo(event);
		}catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return;
	}
	
}
