/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonBC.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-11
*@LastModifier : 김원섭
*@LastVersion : 1.0
* 2006-10-11 김원섭
* 1.0 최초 생성
* 2008-12-22 서관영 CSR:N200812080001
*   - SELSC시 SUB Office 팀코드별 조정  
* 2011.05.19 최성민 [CHM-201110711-01] Inquiry by Trade 화면 보완
* - TAGLIB를 MULTICOMBO로 변경작업하기 위한 메소드 추가
* 2011.07.26 김종준 [SRM-201118467] Daily F"cast Status 화면 alloc display 보완 searchUserRoleYn 메소드 추가
* 2011.11.10 김종준 [CHM-201114445-01] f"cast history 화면 RGN Office 창 활성화 searchUserRoleYn 화면명 세팅
* 2011.11.21 김종준 [CLT-111121290-01] R4J 패치 이후 발생한 결함 건 수정(Null dereference)
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.11.13 박은주 [CHM-201432794] SMP 사용 편의기능 보완 요청(RHQ 유효성 체크)
* 2015.09.15 이혜민 [CHM-201537538] SMP 오류 수정 건 및 Sub Trade Add 기능 추가
=========================================================*/

package com.hanjin.apps.alps.esm.spc.common.common.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.spc.common.common.vo.CommonCodeVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SearchOfficeCondVO;

/**
 * alps-Common Business Logic Command Interface<br>
 * - alps-Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 김원섭
 * @see ComboxEventResponse 참조
 * @since J2EE 1.4
 */

public interface CommonBC {

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @param Boolean isRepTrade
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTradeComboList(String del, Boolean isRepTrade) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @param Boolean isRepTrade
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchSvcLaneComboList(String del, Boolean isRepTrade) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @param Boolean isRepTrade
	 * @param Boolean isAll
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubTradeComboList(String del, Boolean isRepTrade, Boolean isAll)
			throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchRLaneComboList(String del) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @param Boolean ipc
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchRLaneComboList(String del, Boolean ipc) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsmSpcCodEvent
	 * @return EventResponse ESM_SPC_CODEventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommonCodeList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String method
	 * @param String del
	 * @return EventResponse ESM_SPC_CODEventResponse
	 * @exception EventException
	 */
	public EventResponse searchCodeList(String method, String del) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String method
	 * @param String del
	 * @return EventResponse ESM_SPC_CODEventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommonCodeList(String method, String del) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchRHQComboList(String del) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String module
	 * @param String rhq
	 * @param String del
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchAQComboList(String module, String rhq, String del)
			throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String module
	 * @param String rhq
	 * @param String del
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchRgnOfcComboList(String module, String rhq, String del)
			throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String ofc
	 * @param String del
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTargetGroupComboList(String ofc, String del) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchKAMerComboList(String del) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param Event e
	 * @param SignOnUserAccount account
	 * @return List<SearchOfficeCondVO>
	 * @exception EventException 
	 */
	public List<SearchOfficeCondVO> searchOfficeCond(Event e, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESM_SAQ_116Event
	 * @return EventResponse ESM_SAQ_116EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChildOfficeList(Event e) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESM_SAQ_116Event
	 * @return EventResponse ESM_SAQ_116EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChildTeamOfficeList(Event e) throws EventException;
	
	/**
	 *  YEAR 코드 리스트를 생성한다.<br>
	 * 
	 * @return List<CommonCodeVO>
	 * @exception EventException
	 */
    public List<CommonCodeVO> searchComboBoxYearList() throws EventException;

	/**
	 *  WEEK 코드 리스트를 생성한다.<br>
	 * 
	 * @return List<CommonCodeVO>
	 * @exception EventException
	 */
    public List<CommonCodeVO> searchComboBoxWeekList() throws EventException;
    

	/**
	 * 메소드별로 콤보 리스트를 조회한다.<br>
	 * 
	 * @param CommonCodeVO commonCodeVO
	 * @return List<CommonCodeVO>
	 * @exception EventException
	 */
	public List<CommonCodeVO> searchCommonComboList(CommonCodeVO commonCodeVO) throws EventException;
	
	/**
	 *  Bound 코드 리스트를 생성한다.<br>
	 * 
	 * @param CommonCodeVO commonCodeVO
	 * @return List<CommonCodeVO>
	 * @exception EventException
	 */
    public List<CommonCodeVO> searchComboBoxBoundList(CommonCodeVO commonCodeVO) throws EventException;
    
	/**
	 * SPC01 유저 권한 체크한다.<br>
	 * 
	 * @param Event e
	 * @param SignOnUserAccount account
	 * @param String ui_name
	 * @return List<SearchOfficeCondVO>
	 * @exception EventException 
	 */
	public  List<SearchOfficeCondVO> searchUserRoleYn(Event e, SignOnUserAccount account, String ui_name) throws EventException;

	/**
	 * 입력된 VVD를 체크한다.
	 * @param vvd
	 * @return
	 * @throws EventException
	 */
	public boolean checkVvd(String vvd) throws EventException;
	
	/**
	 * 입력한 OFC가 지정된 RHQ에 해당하는지 확인합니다.
	 * @param slsRhqCd
	 * @param slsRgnOfcCd
	 * @return
	 * @throws EventException
	 */
	public boolean checkOfcRhq(String slsRhqCd, String slsRgnOfcCd) throws EventException;
	
	/**
	 * 입력한 RLANE이 지정된 Trade, Sub Trade에 해당하는지 확인합니다.
	 * @param trdCd
	 * @param subTrdCd
	 * @param rlaneCd
	 * @return
	 * @throws EventException
	 */
	public boolean checkLaneTrd(String trdCd, String subTrdCd, String rlaneCd) throws EventException;
	
	/**
	 * SMP용 role을 조회합니다.
	 * @param String usrId
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchSmpRole(String usrId) throws EventException;

	/**
	 * 입력한 RHQ의 유효성을 확인합니다.
	 * @param String slsRhqCd
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkRhq(String slsRhqCd) throws EventException;
	
	/**
	 * 입력한 Sub Trade의 유효성을 확인합니다.
	 * @param String trdCd
	 * @param String subTrdCd
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkSubTrdCd(String trdCd, String subTrdCd) throws EventException;
}
