/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementImportBC.java
*@FileTitle : Agreement File Import
*Open Issues :
*Change history :
*@LastModifyDate : 2010-04-05
*@LastModifier : agreement
*@LastVersion : 1.0 
* 2010-04-05 agreement
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchAgmtHdrVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author agreement
 * @see EsdTrs0220EventResponse 참조
 * @since J2EE 1.5
 */
public interface AgreementImportBC  {

	/**
	 * Agreement Header정보 조회<br>
	 * 
	 * @param e ESD_TRS_0220Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtHdr(Event e) throws EventException;
	
	/**
	 * Agreement Child S/P정보 조회<br>
	 * 
	 * @param e ESD_TRS_0220Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtChdVndr(Event e) throws EventException;

	/**
	 * Agreement S/P명 조회<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchVenderName(Event e) throws EventException;

	/**
	 * Contract Office 존재여부 조회<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchContractOffice(Event e) throws EventException;

	/**
	 * Agreement 중복여부 체크<br>
	 * 
	 * @param searchAgmtHdrVO
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchAgmtDupChk(SearchAgmtHdrVO searchAgmtHdrVO) throws EventException;
	
	/**
	 * Agreement Header자료 생성<br>
	 * 
	 * @param searchAgmtHdrVO
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiAgmtHdr(SearchAgmtHdrVO searchAgmtHdrVO) throws EventException;
	
	/**
	 * Agreement Header자료 수정<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiAgmtHdrRmk(Event e) throws EventException;
	
	/**
	 * Agreement S/P 정보 저장<br>
	 * 
	 * @param e ESD_TRS_0220Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiAgmtHdrVndr(Event e) throws EventException;
	
	/**
	 * Sequence 생성<br>
	 * Verify시 Sequence생성<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String createAgmtVerifyNewTmpSeq() throws EventException ;
	
	/**
	 * Agreement verify를 위한 temp테이블에 Insert이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0221Event
	 * @exception EventException
	 */
	public void insertAgmtVerifyData(Event e) throws EventException; 
	
	/**
	 * AgreementPair Verify 이벤트 처리<br>
	 * AgreementPair Verify 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0221Event
	 * @return event EsdTrs0221Event
	 * @exception EventException
	 */
	public EventResponse verifyAgmtPair(Event e) throws EventException;
	
	/**
	 * AgreementDistance Verify 이벤트 처리<br>
	 * AgreementDistance Verify 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0221Event
	 * @return event EsdTrs0221Event
	 * @exception EventException
	 */
	public EventResponse verifyAgmtDistance(Event e) throws EventException;
	
	/**
	 * Agreement verify를 위한 temp테이블에 Delete이벤트 처리<br>
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void deleteAgmtVerifyData(Event e) throws EventException; 

	/**
	 * Agreement Surcharge Verify 이벤트 처리<br>
	 * Agreement Surcharge Verify 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0221Event
	 * @return event EsdTrs0221Event
	 * @exception EventException
	 */
	public EventResponse verifyAgmtSurcharge(Event e) throws EventException;

	/**
	 * Agreement Sub Office정보 조회<br>
	 * 
	 * @param e ESD_TRS_0221Event
	 * @return event EsdTrs0221Event
	 * @exception EventException
	 */
	public EventResponse searchSubOfcCd(Event e) throws EventException; 
	
	/**
	 * Agreement Rate정보 삭제 처리<br>
	 * 
	 * @param e ESD_TRS_0224Event
	 * @return event EsdTrs0224Event
	 * @exception EventException
	 */
	public EventResponse deleteCorrRateAgmt(Event e) throws EventException; 
	
	/**
	 * Agreement Rate 자료 수정<br>
	 * 
	 * @param e ESD_TRS_0221Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiCorrRateAgmt(Event e) throws EventException;
	
	/**
	 * Agreement Surcharge Rate 자료 수정<br>
	 * 
	 * @param e ESD_TRS_0221Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiCorrScgAgmt(Event e) throws EventException;
	
	/**
	 * HJS-HJL Handling Fee Management sav<br>
	 * 
	 * @param e ESD_TRS_0221Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse saveHjlHndlFee(Event e) throws EventException;
	
	/**
	 * Agreement Surcharge Rate정보 삭제 처리<br>
	 * 
	 * @param e ESD_TRS_0224Event
	 * @return event EsdTrs0224Event
	 * @exception EventException
	 */
	public EventResponse deleteCorrScgAgmt(Event e) throws EventException; 
	
	/**
	 * HJS-HJL Handling Fee Management 정보 조회<br>
	 * 
	 * @param e ESD_TRS_0240Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchHjlHndlFee(Event e) throws EventException;
	
	/**
	 * HJS-HJL Handling Fee Management 정보 History 포함 조회<br>
	 * 
	 * @param e ESD_TRS_0240Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchHjlHndlFeeHis(Event e) throws EventException;
	
	/**
	 * Agreement Contract Office 권한체크<br>
	 * 
	 * @param e ESD_TRS_0221Event
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAuthChk(Event e, SignOnUserAccount account) throws EventException;
}
