/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESInvoiceCommonBC.java
*@FileTitle : TES Invoice Common 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-31 byungheeyoo
* 1.0 최초 생성
* 
 * 2009-05-29 [N200905280100]   : TPB I/F 누락 방지 추가
 * 2009-08-27 [PJM-200900072] : 부산신항만(180020)용 getAutoFPmode 조회 기능 추가. 
 * 2010-11-11 박재흥 [CHM-201006940-01] INV AUTO CALC CHECK
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;

/**
 * ALPS-ESD Business Logic Command Interface<br>
 * - ALPS-ESD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author byungheeyoo
 * @see TESInvoiceCommonBC 참조
 * @since J2EE 1.4
 */
public interface TESInvoiceCommonBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * TESInvoiceCommon화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e TESInvoiceCommonEvent
	 * @return EventResponse 
	 * @exception EventException
	 */
	
	final static String INV_STS_RC = "RC";	//R
	final static String INV_STS_CF = "CF";	//C
	final static String INV_STS_AR 	= "AR"; //A
	final static String INV_STS_AP 	= "AP"; //P
	final static String INV_STS_CSR = "CSR"; //A,P 둘 중 하나
	final static String INV_STS_PD = "PD"; //D
	
	/**
	 * ofc_cd에 따라 Withholding tax입력 mode를 가져온다.
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getWHTmode(Event e) throws EventException;
	
	/**
	 * (calc 계산시) agreement의 currency code를 가져온다.
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getAgmtCurrCD(Event e) throws EventException;

	/**
	 * (calc 계산시) agreement의 status를 가져온다.
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getAgmtSts(Event e) throws EventException;
	
	/**
	 * (TPB 입력시) COST CODE의 N3PTY_BIL_CS_CD를 가져온다.
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getN3ptyBilCSCD(Event e) throws EventException;
	
	/**
	 * (주어진 조건에 따라) ERR_INV_NO를 가져온다.
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse isValidErrInvNo(Event e) throws EventException;

	/**
	 * invoice의 상태를 확인
	 * 
	 * @param model
	 * @param mode
	 * @exception EventException
	 */
	public void checkInvoiceStatus(TesTmlSoHdrVO model, String mode) throws EventException;

	/**
	 * invoice의 상태를 확인
	 * 
	 * @param models
	 * @param mode
	 * @exception EventException
	 */
	public void checkInvoiceStatus(TesTmlSoHdrVO[] models, String mode) throws EventException;

	/**
	 * invoice의 상태를 확인
	 * 
	 * @param csr_no
	 * @param mode
	 * @exception EventException
	 */
	public void checkInvoiceStatus(String csr_no, String mode) throws EventException;

	/**
	 * EDI Invoice Validation
	 * 
	 * @param e
	 * @exception EventException
	 */
	public void validateEDIInvoice(Event e) throws EventException;

	/**
	 * 신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 정규 invoice에 존재 여부를 확인한다.
	 * @param hm
	 * @exception EventException
	 */
	public void checkRegularInvoiceDup(HashMap<String, Object> hm) throws EventException;
	
	/**
	 * 신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 EDI invoice에 존재 여부를 확인한다.
	 * @param hm
	 * @exception EventException
	 */
	public void checkEDIInvoiceDup(HashMap<String, String> hm) throws EventException;
	
	/**
	 * EDI 로 접수받은 Invoice 를 실제 Invoice로 전환시킴
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse convertEDIInvoice2TMLInvoice(Event e) throws EventException;

	/**
	 * TBP I/F DATA 존재 여부, SO_DTL의 FLAG 상태를 확인 ( 2009-06-03 )
	 * 
	 * @param tesTmlSoHdrVO
	 * @exception EventException
	 */
	public void checkDetailTpb(TesTmlSoHdrVO tesTmlSoHdrVO) throws EventException;
	
	
	/**
	 * 2010-11-11: [CHM-201006940-01] INV AUTO CALC CHECK 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse getMgstNos(Event e) throws EventException;
	
	/**
	 * checkInvCalcCostCD
	 * @param tesTmlSoHdrVO TesTmlSoHdrVO
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse checkInvCalcCostCD(TesTmlSoHdrVO tesTmlSoHdrVO) throws EventException;
	
	/**
	 * Invoice나 CSR이 처음 만들어진 후 3개월이 경과한 건을 조회
	 * @param e 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOldInvCsrData(Event e) throws EventException;

	/**
	 * Invoice나 CSR이 처음 만들어진 후 3개월이 경과한이 있는지 체크한다.
	 * @param String ofcCd
	 * @return EventResponse
	 * @exception EventException
	 */
	public String searchOldInvCsrChk(String ofcCd) throws EventException;
	
	/**
	 * session의 ofc_cd를 기준으로 (session이 아닌) MDM의 CONTI_CD를 조회 
	 * @param String ofc_cd
	 * @return EventResponse
	 * @exception EventException
	 */
	public String searchContiCd(String ofc_cd) throws EventException;
	
	/**
	 * SVXXJO 존재 여부 확인
	 * 
	 * @param TesTmlSoHdrVO[] tesTmlSoHdrVOs
	 * @exception EventException
	 */
	public void searchMinusInvAmtSvxxJoExist(TesTmlSoHdrVO[] tesTmlSoHdrVOs) throws EventException;
	
	/**
	 * Agreement 정보 update
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @param String fromDate
	 * @param String toDate
	 * @exception EventException
	 */
	public void updateInvoiceDetailAgmt(TesTmlSoHdrVO tesTmlSoHdrVO, String fromDate, String toDate) throws EventException;

}