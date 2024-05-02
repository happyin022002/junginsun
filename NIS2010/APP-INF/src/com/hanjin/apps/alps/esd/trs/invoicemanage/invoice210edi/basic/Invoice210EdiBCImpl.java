/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Invoice210EdiBCImpl.java
*@FileTitle : Invoice 210 EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009-05-21
*@LastModifier : eunju son
*@LastVersion : 1.0
* 2009-05-21 eunju son
* 1.0 최초 생성
* -------------------------------------------------------
* history
* 2011.07.20 김영철 [CHM-201111871] [TRS] R4J 소스 품질 조치 내역 수정
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoice210edi.basic;

import com.hanjin.apps.alps.esd.trs.invoicemanage.invoice210edi.integration.Invoice210EdiDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.TrsTrspInvEdiVO;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;


/**
 * ENIS-Invoice210Edi Business Logic Basic Command implementation<br>
 * - ENIS-Invoice210Edi에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author eunju son
 * @see ESD_TRS_965EventResponse,Invoice210EdiBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class Invoice210EdiBCImpl   extends BasicCommandSupport implements Invoice210EdiBC {

	// Database Access Object
	private transient Invoice210EdiDBDAO dbDao=null;

	/**
	 * Invoice210EdiBCImpl 객체 생성<br>
	 * Invoice210EdiDBDAO를 생성한다.<br>
	 */
	public Invoice210EdiBCImpl(){
		dbDao = new Invoice210EdiDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Invoice210Edi 조회 이벤트 처리<br>
	 * 
	 * @param model
	 * @return int
	 * @exception EventException
	 */
	public int searchInvCfmSO(TrsTrspInvEdiVO model) throws EventException{
		try {
			return dbDao.searchInvCfmSO(model);  

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Invoice210Edi 조회 이벤트 처리<br>
	 * 
	 * @param model
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchNotInvSO(TrsTrspInvEdiVO model) throws EventException{
		try {
			return dbDao.searchNotInvSO(model);  

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice210Edi 조회 이벤트 처리<br>
	 * 
	 * @param model
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchInvoiceWO(TrsTrspInvEdiVO model) throws EventException{
		try {
			return dbDao.searchInvoiceWO(model);  

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice210Edi 조회 이벤트 처리<br>
	 * 
	 * @param vndr_seq
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceVndr(String vndr_seq) throws EventException{
		try {
			return dbDao.searchInvoiceVndr(vndr_seq);  

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
//	/**
//	 * invoice vndr check 이벤트 처리<br>
//	 * Invoice210Edi 조회 이벤트 처리<br>
//	 * 
//	 * @param vndr_seq
//	 * @return boolean
//	 * @exception EventException
//	 */
//	public boolean searchInvoiceVndrCheck(String vndr_seq) throws EventException{
//		try {
//			return dbDao.searchInvoiceVndrCheck(vndr_seq);  
//
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//		
//	}

	
	/**
	 * 저장 이벤트 처리<br>
	 * Invoice210Edi 저장 이벤트 처리<br>
	 * 
	 * @param model 
	 * @param rejectFlag
	 * @param invAmt
	 * @return  boolean
	 * @exception EventException
	 */
	public boolean saveInvoice210Edi(TrsTrspSvcOrdVO model, boolean rejectFlag, String invAmt) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		try {
			return dbDao.saveInvoice210Edi(model, rejectFlag, invAmt);  

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 수정 이벤트 처리<br>
	 * Invoice210Edi  수정 이벤트 처리<br>
	 * 
	 * @param model TrsTrspInvEdiVO
	 * @exception EventException
	 */
	public void modifyTrsTrspInvEdi(TrsTrspInvEdiVO model) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		try {
			dbDao.modifyTrsTrspInvEdi(model);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * bkg_no로 CNTR 가져오기 <br>
	 * 
	 * @param inputRs
	 * @param EQ_NO
	 * @return String
	 * @throws EventException
	 */
	public String searchInvoiceImportBkgBkgCntr(DBRowSet inputRs, String EQ_NO) throws EventException {
		try {
			return dbDao.searchInvoiceImportBkgBkgCntr(inputRs, EQ_NO);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	
	}
	
//	/**
//	 * Invoice 안된 EDI data 가져오기 <br>
//	 * 
//	 * @return ArrayList
//	 * @throws EventException
//	 */
//	public ArrayList searchNotInvoicedEdi()  throws EventException{
//		try {
//
//			return dbDao.searchNotInvoicedEdi();
//
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	
//	}


	

	/**
	 * Invoice210Edi 업무 시나리오 마감작업<br>
	 * Invoice210Edi업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}