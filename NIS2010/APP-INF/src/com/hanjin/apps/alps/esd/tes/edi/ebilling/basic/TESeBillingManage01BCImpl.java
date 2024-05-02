/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingManage01BCImpl.java
*@FileTitle : TES eBilling EDI 처리
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012-01-04 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.basic;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingManageBizType000BC;

import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;

/**
 * ALPS-ESD Business Logic Basic Command implementation<br>
 * - ALPS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see TESeBillingManage01BCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TESeBillingManage01BCImpl extends BasicCommandSupport implements TESeBillingManageBC {

	/**
	 * TES eBilling Type Impl
	 */
	private transient TESeBillingManageBizType000BC ediDtlTypeImpl = null;
	
	
	
	/**
	 * TESeBillingManage01BCImpl default 생성자<br>
	 */
	public TESeBillingManage01BCImpl() {
	}

	/**
	 * TESeBillingManage01BCImpl TESeBillingManageDetail을 arg로 받는 생성자<br>
	 * @param ediDtlTypeImplFm
	 */
	public TESeBillingManage01BCImpl(TESeBillingManageBizType000BC ediDtlTypeImplFm) {
		ediDtlTypeImpl = ediDtlTypeImplFm;
	}
	

	/**
	 * EDI에서 전송한 FLAT FILE에서 INVOICE정보를 MODEL별로 추출하여 HashMap으로 추출하여 지정된 내부 객체에 담기
	 * 
	 * @param eventResponse
	 * @exception EventException
	 */
	public void getEDIInvoiceInTESformat(EventResponse eventResponse) throws EventException {
		log.debug("\n TESeBillingManage01BCImpl-getEDIinvoiceInTESformat~~~~~BBBB \n");

		if (ediDtlTypeImpl!=null){
			ediDtlTypeImpl.getEDIInvoiceInTESformat(eventResponse);
		}
		
		log.debug("\n TESeBillingManage01BCImpl-getEDIinvoiceInTESformat~~~~~EEEE \n");
	}
	
	/**
	 * EDI data를 임시 저장소에 저장
	 * 
	 * @param eventResponse
	 * @exception EventException
	 */
	public void createEDIInvoiceData(EventResponse eventResponse) throws EventException {
		log.debug("\n  TESeBillingManage01BCImpl-createEDInvoiceData~~~~~BBBB \n");

		if (ediDtlTypeImpl!=null){
			ediDtlTypeImpl.createEDIInvoiceData(eventResponse);	
		}
		
		log.debug("\n  TESeBillingManage01BCImpl-createEDInvoiceData~~~~~EEEE \n");
	}
	
	/**
	 * EDI data를 임시 저장소에 저장
	 * 
	 * @param eventResponse
	 * @exception EventException
	 */
	public void createEDIInvoiceData2(EventResponse eventResponse) throws EventException {
		log.debug("\n  TESeBillingManage01BCImpl-createEDIInvoiceData2~~~~~BBBB \n");
		
		if (ediDtlTypeImpl!=null){
			ediDtlTypeImpl.createEDIInvoiceData2(eventResponse);	
		}
		
		log.debug("\n  TESeBillingManage01BCImpl-createEDIInvoiceData2~~~~~EEEE \n");
	}

	/**
	 * 
	 * EDI data 유효성 확인
	 * @param eventResponse
	 * @exception EventException
	 */
	public void validateEDIInvoice(EventResponse eventResponse) throws EventException {
		log.debug("\n TESeBillingManage01BCImpl-validateEDIInvoice~~~~~BBBB \n");

		if (ediDtlTypeImpl!=null){
			ediDtlTypeImpl.validateEDIInvoice(eventResponse);	
		}
		
		log.debug("\n TESeBillingManage01BCImpl-validateEDIInvoice~~~~~EEEE \n");
	}
	

	/**
	 * EDI data를 정규 TMN invoice로 변환 작업 - 한번에 단일 Invoice만 대상으로 변환작업을 한다.
	 * @param tesEdiSoHdrVo
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse convertEDIInvoice2TMLInvoice(TesEdiSoHdrVO  tesEdiSoHdrVo) throws EventException {
		log.debug("\n TESeBillingManage01BCImpl-convertEDIInvoice2TMLInvoice~~~~~BBBB \n");

		EventResponse eventResponse = null;
		
		eventResponse = ediDtlTypeImpl!=null?ediDtlTypeImpl.convertEDIInvoice2TMLInvoice(tesEdiSoHdrVo):null;
		
		log.debug("\n TESeBillingManage01BCImpl-convertEDIInvoice2TMLInvoice~~~~~EEEE \n");

		return eventResponse;
	}
	
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * TESeBillingManage01BCImpl업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		ediDtlTypeImpl = null;
	}
}