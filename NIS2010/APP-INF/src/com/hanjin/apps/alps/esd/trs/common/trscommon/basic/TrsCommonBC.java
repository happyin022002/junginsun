/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrsCommonBC.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : 유선오
*@LastVersion : 1.6
* 2011.02.10 민정호
* ---------------------------------------------------------
* * History
* 1.0 최초 생성
* 1.0 2011.02.10 민정호 [CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
* 1.2 2011.02.18  손은주 [CHM-201108834-01]	[TRS] Rail performance Report 부분의 주 단위 data 조회기능 추가 요청- 월별 주차별 검색기간 추가
* 1.3 2011.03.28 손은주 [CHM-201109560-01] Split 04-Intra - Europe Business 관련 VAT 기능 개발 - 대륙코드 조회
* 1.4 2011.06.27  손은주 [CHM-201111573-01]	[TRS] S/O history function 추가 요청
* 1.5 2011.08.31  유선오 [CHM-201112874]	    [TRS] OTHER S/O Creation 화면 상 오류 수정요청
* 1.6 2011.10.19  유선오 [CHM-201112874]	     [TRS] OTHER S/O Creation 화면 상 오류 수정요청
* 2011.11.17 변종건[CHM-201114528-01] TRS 시스템 담당자용 버튼 개발
* 2012.01.06 김종호 [CHM-201109410] [TRS] CNTR No. 유효성에 대한 Validation 절차 추가요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.common.fileattach.vo.TrsFileVO;
import com.hanjin.apps.alps.esd.trs.common.trscommon.vo.TrsSOHistoryVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Common Business Logic Command Interface<br>
 * - ALPS-Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Min Jung Ho
 * @see ESD_TRS_0999EventResponse 참조
 * @since J2EE 1.6
 */

public interface TrsCommonBC {	
	
	/** 
	 * Office Change시 변경된 국가코드를 조회
	 * 
	 * @param e  ESD_TRS_0999Event
	 * @return EventResponse ESD_TRS_0999EventResponse
	 * @throws EventException
	 */
	public EventResponse searchContiCd(Event e) throws EventException;	
	
	
	/**
	 * Office Change시 변경된 국가코드를 조회
	 * N200905040013 2009-05-11: Office Change 개념의 모듈적용
	 * 
	 * @param sOfficeCd
	 * @return String
	 * @throws EventException
	 */
	public String searchContiCd(String sOfficeCd) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 월,주차 검색기간 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPeriod(Event e) throws EventException;

	/**
	 * Office의 대륙코드를 조회
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchContiCode(Event e) throws EventException;
	
	/**
	 * TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY를 입력
	 * 
	 * @param soHisVo
	 * @throws EventException
	 */
	public void multiSoHistory(TrsSOHistoryVO soHisVo) throws EventException;

	/**
	 * TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY를 입력
	 * 
	 * @param trsStsVO
	 * @throws EventException
	 */
	public void multiSceSoHistory(SingleTransportationVO trsStsVO) throws EventException;

	/**
	 * Other S/O와 관련된 Commmodity Code를 입력,찾기 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCmdtCd(Event e) throws EventException;

	/**
	 * Other S/O와 관련된 Customer Code를 입력,찾기 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCustCd(Event e)throws EventException;
	
	/**
	 * 버튼 권한 조회 이벤트 처리
	 * 
	 * @param account
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchBtnAuthority(SignOnUserAccount account)throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * 컨테이너 유효성을 검사한다<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrEqNo(Event e) throws EventException;
	
	/**
	 * RHQ Office 조회 : ESD_TRS_3004화면의 SEARCH01 이벤트 처리<br>
	 * 
	 * @param ofcCd
	 * @return
	 * @throws EventException
	 */
	public String searchRHQOfficeCode(String ofcCd) throws EventException;
	
	/**
	 * Country Code Verify<br>
	 * 
	 * @param cntCd
	 * @return
	 * @throws EventException
	 */
	public String verifyCountryCode(String cntCd) throws EventException;

	/**
	 * Agreement Number Verify<br>
	 * 
	 * @param agmt_no
	 * @return
	 * @throws EventException
	 */
	public String searchTrsAgmtNoData(String agmt_no) throws EventException;

	/**
	 * Search Local Time<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchLocalTime(Event e) throws EventException;
	
	/**
	 * Container type - Active<br>
	 * 
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchMdmCntrTpActive() throws EventException;
	
	/**
	 * 해당 오피스가 Multi More Candidate 필수 대상 인지 확인 (미국, 캐나다)
	 * 
	 * @param sOfficeCd
	 * @return String
	 * @throws EventException
	 */
	public String searchMltMorOnyFlg(String sOfficeCd) throws EventException;
	
	public List<TrsFileVO> searchTrsFile(TrsFileVO trsFileVO) throws EventException;
	public String manageTrsFile(TrsFileVO[] trsFileVOs, SignOnUserAccount account) throws EventException;
	public void removeTrsFileAll(TrsFileVO trsFileVO) throws EventException;
	
}

