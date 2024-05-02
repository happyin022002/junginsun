/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingManageBC.java
*@FileTitle : TES eBilling EDI 처리
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012-01-04 
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.basic;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;

/**
 * ALPS-ESD Business Logic Command Interface<br>
 * - ALPS-ESD에 대한 비지니스 로직에 대한 인터페이스<br> 
 *
 * @author 
 * @see TESInterfaceEventResponse 참조
 * @since J2EE 1.4
 */
public interface TESeBillingManageBC  {

	/**
	 * EDI에서 전송한 FLAT FILE에서 INVOICE정보를 MODEL별로 추출하여 Hashmap으로 추출하기
	 * @param eventResponse
	 * @throws EventException
	 */
	public void getEDIInvoiceInTESformat(EventResponse eventResponse)throws EventException;

	/**
	 * EDI 기본 정보만 우선 TMP에 넣기
	 * @param eventResponse
	 * @exception EventException
	 */
	public void createEDIInvoiceData(EventResponse eventResponse)throws EventException;

	/**
	 * EDI 추가 처리 
	 * @param eventResponse
	 * @throws EventException
	 */
	public void createEDIInvoiceData2(EventResponse eventResponse)throws EventException;
	
	/**
	 * EDI data 유효성 확인
	 * @param eventResponse
	 * @exception EventException
	 */
	public void validateEDIInvoice(EventResponse eventResponse)throws EventException;

	/**
	 * EDI 로 접수받은 Invoice 를 실제 Invoice로 전환시킴
	 * @param tesEdiSoHdrVo
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse convertEDIInvoice2TMLInvoice(TesEdiSoHdrVO  tesEdiSoHdrVo)throws EventException;	
	
}