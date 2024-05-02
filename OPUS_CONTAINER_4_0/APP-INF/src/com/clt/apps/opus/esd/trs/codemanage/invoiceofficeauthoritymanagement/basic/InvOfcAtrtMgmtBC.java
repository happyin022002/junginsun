/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvOfcAtrtMgmtBC.java
*@FileTitle : TRS Invoice Authority
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.16
*@LastModifier : 유선오
*@LastVersion :  1.1
  2011.11.09 SunOh,You
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2011.11.09 유선오 1.0 [CHM-201114273][TRS] Invoice 권한등록 프로그램 개발
* 2011.11.16 유선오 1.2 [CHM-201114273][TRS] R4J 소스 품질 조치 내역 수정 :line No 23 클래스의 주석을 기술
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.basic;
import com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.vo.InvoiceOfficeAuthorityManagementVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
 
/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoo,SunOh
 * @see EsdTrs0976EventResponse 참조
 * @since J2EE 1.6
 */
public interface InvOfcAtrtMgmtBC{

	
	/**
	 * 조회 이벤트 처리<br>
	 * form에 OFFIECODE 조회하여 리스트를 가져오는 이벤트 처리<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchInvOfcAtrtMgmtList(Event e) throws EventException;
		
	/**
	 * 조회 이벤트 처리<br>
	 * Sheet에 OFFIECODE 조회하여 OFFICE ENGLISH NAME을 가져오는 이벤트 처리<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public InvoiceOfficeAuthorityManagementVO searchOfficeCode(Event e) throws EventException ;

	/**
	 * 멀티 이벤트 처리<br>
	 * form에 OFFIECODE 조회하여 리스트를 가져오는 이벤트 처리<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiInvoiceOfficeAuthorityManagement(Event e) throws EventException;

	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_0976 화면에 대한 삭제 이벤트 처리<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse removeInvoiceOffice(Event e)throws EventException;
	



}