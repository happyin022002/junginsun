/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Invoice210EdiBC.java
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

import java.util.ArrayList;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.TrsTrspInvEdiVO;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ENIS-Invoice210Edi Business Logic Command Interface<br>
 * - ENIS-Invoice210Edi에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author eunju son
 * @see ESD_TRS_965EventResponse 참조
 * @since J2EE 1.4
 */
public interface Invoice210EdiBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * Invoice210Edi 조회 이벤트 처리<br>
	 * 
	 * @param model
	 * @return
	 * @throws EventException
	 */
	public int searchInvCfmSO(TrsTrspInvEdiVO model) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice210Edi 조회 이벤트 처리<br>
	 * 
	 * @param model
	 * @return
	 * @throws EventException
	 */
	public DBRowSet searchNotInvSO(TrsTrspInvEdiVO model) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice210Edi 조회 이벤트 처리<br>
	 * 
	 * @param model
	 * @return
	 * @throws EventException
	 */
	public DBRowSet searchInvoiceWO(TrsTrspInvEdiVO model) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice210Edi 조회 이벤트 처리<br>
	 * 
	 * @param vndr_seq
	 * @return
	 * @throws EventException
	 */
	public String searchInvoiceVndr(String vndr_seq) throws EventException;
	
//	/**
//	 * invoice vndr check 이벤트 처리<br>
//	 * Invoice210Edi 조회 이벤트 처리<br>
//	 * 
//	 * @param vndr_seq
//	 * @return
//	 * @throws EventException
//	 */
//	public boolean  searchInvoiceVndrCheck(String vndr_seq) throws EventException;

	/**
	 * 저장  이벤트 처리<br>
	 * Invoice210Edi화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param model
	 * @param rejectFlag
	 * @param invAmt
	 * @return
	 * @throws EventException
	 */
	public boolean saveInvoice210Edi(TrsTrspSvcOrdVO model, boolean rejectFlag, String invAmt) throws EventException;
	
	/**
	 * 수정 이벤트 처리<br>
	 * Invoice210Edi  수정 이벤트 처리<br>
	 * 
	 * @param model
	 * @throws EventException
	 */
	public void modifyTrsTrspInvEdi(TrsTrspInvEdiVO model) throws EventException;
	
	/**
	 * bkg_no로 CNTR 가져오기 <br>
	 * 
	 * @param inputRs
	 * @param EQ_NO
	 * @return
	 * @throws EventException
	 */
	public String searchInvoiceImportBkgBkgCntr(DBRowSet inputRs, String EQ_NO) throws EventException;
	
//	/**
//	 * Invoice 안된 EDI data 가져오기 <br>
//	 * 
//	 * @return
//	 * @throws EventException
//	 */
//	public ArrayList searchNotInvoicedEdi()  throws EventException;

}