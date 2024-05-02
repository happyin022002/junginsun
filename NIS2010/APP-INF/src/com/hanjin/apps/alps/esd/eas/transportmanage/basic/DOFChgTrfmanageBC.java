/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DOFChgColPermanageBC
*@FileTitle : Drop Off Charge Collection Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-30
*@LastModifier : ho-sam lee
*@LastVersion : 1.0
* 2008-01-30 ho-sam lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.basic;

import com.hanjin.apps.alps.esd.eas.transportmanage.vo.CommEasDrffChgTrfVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EasDrffChgTrfHdrVO;

/**
 * DOFChgTrfmanageBC PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface DOFChgTrfmanageBC {

	
	/**
	 * searchDofChgTrfList 기본 조회 기능<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDofChgTrfList(Event e) throws EventException;
	
	/**
	 * searchEasDrffChgTrfHdrRSQL 기본 조회 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEasDrffChgTrfHdrRSQL(Event e) throws EventException;
	
	/**
	 * searchEasDrffChgTrfDtlRSQL 기본 조회 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEasDrffChgTrfDtlRSQL(Event e) throws EventException;
	
	/**
	 * searchEasDrffChgTrfDtlSccRSQL 기본 조회 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEasDrffChgTrfDtlSccRSQL(Event e) throws EventException;
	
	/**
	 * searchEffDT Effect 날짜 조회 기능<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEffDT(Event e) throws EventException;
	
	/**
	 * RfaNo 체크 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse checkRfaNo(Event e) throws EventException;
	
	/**
	 * RfaNo 체크 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse checkInputRfaNo(Event e) throws EventException;
	
	/**
	 * Country search 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCountryCombo(Event e) throws EventException;

	/**
	 * Curr Cd 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCurrCd(Event e) throws EventException;
	
	/**
	 * Curr Cd 리스트 목록 조회 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCurrList(Event e) throws EventException;		
	
	/**
	 * multiDofChgTrf 등록.수정,삭제
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiDofChgTrf( Event e ) throws EventException;
	
//#########################################################################################################################	
	/**
	 * multiDrffChgTrf 등록.수정,삭제
	 * @param String isSave
	 * @param EasDrffChgTrfHdrVO easDrffChgTrfHdrVO
	 * @param SignOnUserAccount account 
	 * @throws EventException
	 */
	public void multiDrffChgTrf(String isSave, EasDrffChgTrfHdrVO easDrffChgTrfHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * multiDrffChgTrfDtl 등록.수정,삭제
	 * 
	 * @param String isUpload
	 * @param EasDrffChgTrfHdrVO easDrffChgTrfHdrVO
	 * @param CommEasDrffChgTrfVO[] commEasTrfVOs
	 * @param SignOnUserAccount account 
	 * @throws EventException
	 */
	public void multiDrffChgTrfDtl(String isUpload, EasDrffChgTrfHdrVO easDrffChgTrfHdrVO, CommEasDrffChgTrfVO[] commEasTrfVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * multiDrffChgTrfDtl 삭제
	 * 
	 * @param String isUpload
	 * @param EasDrffChgTrfHdrVO easDrffChgTrfHdrVO
	 * @param CommEasDrffChgTrfVO[] commEasTrfVOs
	 * @param SignOnUserAccount account 
	 * @throws EventException
	 */
	public void multiDrffChgTrfDtlDelete(String isUpload, EasDrffChgTrfHdrVO easDrffChgTrfHdrVO, CommEasDrffChgTrfVO[] commEasTrfVOs, SignOnUserAccount account) throws EventException;	
//#########################################################################################################################	
	
	/**
	 * searchEUROffcd 유럽 Office 조회 기능<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse searchEUROffcd( Event e ) throws EventException;
	
	/**
	 * searchDofChgDupCnt 중복 갯수 조회 기능<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse searchDofChgDupCnt( Event e ) throws EventException;
	
	/**
	 * verifyLocCd 입력된 loc_cd의 MDM내 존재여부 확인<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyLocCd( Event e ) throws EventException;

	/**
	 * verifyCustCd 입력된 cust_cd의 MDM내 존재여부 확인<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyCustCd( Event e ) throws EventException;

	/**
	 * verifyTpSz 입력된 tpsz_cd의 MDM내 존재여부 확인<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyTpSz( Event e ) throws EventException;

	/**
	 * verifyCurr 입력된 curr_cd의 MDM내 존재여부 확인<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyCurr( Event e ) throws EventException;
	
	/**
	 * searchDofChgTrfNewList 기본 조회 기능<br>
	 * @param e EsdEas0011Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDofChgTrfNewList(Event e) throws EventException;
	
	/**
	 * searchDODCollectionInquiry 기본 조회 기능<br>
	 * @param e EsdEas0012Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDODCollectionInquiry(Event e) throws EventException;
		
	/**
	 * searchDODCollectionPerformance 기본 조회 기능<br>
	 * @param e EsdEas0013Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDODCollectionPerformance(Event e) throws EventException;
	
}
