/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESInterfaceBC.java
*@FileTitle : TDR_RESTOW Data Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-07
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2006-12-07 kimjinjoo
* 1.0 최초 생성
* 2011-10-13: [CHM-201113119] [TES] HIT의 TES invoice eBilling 2단계(invoice PDF 수신) 개발 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinterface.basic;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ALPS-ESD Business Logic Command Interface<br>
 * - ALPS-ESD에 대한 비지니스 로직에 대한 인터페이스<br> 
 *
 * @author kimjinjoo
 * @see TESInterfaceEventResponse 참조
 * @since J2EE 1.4
 */
public interface TESInterfaceManageBC  {

	/**
	 * EDI eBilling을 하는 VNDR들로 여기에 반드시 등록하여 사용하여야한다.
	 */
	static final String[] VALID_TES_EDI_VNDRS 	= {"158002","114776","180020","186666"};

	/**
	 * 
	 * @param inv
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getEDIinvoiceInTESformat(String inv)throws EventException;

	/**
	 * 
	 * @param evntRs
	 * @exception EventException
	 */
	public void createEDIinvoiceTmpData(EventResponse evntRs)throws EventException;

	/**
	 * 
	 * @param evntRs
	 * @exception EventException
	 */
	public void createEDInvoiceHDRTmpData(EventResponse evntRs)throws EventException;

	/**
	 * 
	 * @param evntRs
	 * @exception EventException
	 */
	public void createEDInvoiceCNTRTmpData(EventResponse evntRs)throws EventException;

	/**
	 * 
	 * @param evntRs
	 * @exception EventException
	 */
	public void createEDInvoiceDTLTmpData(EventResponse evntRs)throws EventException;

	/**
	 * 
	 * @param evntRs
	 * @exception EventException
	 */
	public void createEDInvoiceAUTOFPTmpData(EventResponse evntRs)throws EventException;
	
	/**
	 * 
	 * @param evntRs
	 * @exception EventException
	 */
	public void createEDIinvoiceTmpData2(EventResponse evntRs)throws EventException;

}
