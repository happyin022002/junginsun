/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SingleTransportationSOManageBC.java
*@FileTitle : CY & Door S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-29
*@LastModifier : z_kim_sang_geun
*@LastVersion : 1.0
* 2006-09-29 z_kim_sang_geun
* 1.0 최초 생성
* 
* 2011.11.29 민정호 [CHM-201114644] [TRS] S/O Correction 시 Delete flag 체크로직 추가요청
* 2011.12.12 민정호 [CHM-201115019] [TRS] S/O creation 시 BKG cancel 여부 체크 로직 추가요청
* 2012.01.09 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0002Event;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author z_kim_sang_geun
 * @see EsdTrs0002EventResponse 참조
 * @since J2EE 1.4
 */
public interface SingleTransportationSOManageBC  {
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @return
	 * @throws EventException
	 */
	public String searchSingleTransportationSOCandidatesListK() throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public List<SingleTransportationVO> searchSingleTransportationSOCandidatesListP(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * S/O Candidate 조회대상을 temp 테이블에 입력하는 이벤트 처리<br>
	 *
	 * @param e
	 * @param vo
	 * @param lSeq
	 * @throws EventException
	 */
	public void searchSingleTransportationSOCandidatesListC(Event e, List<SingleTransportationVO> vo, String lSeq) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Temp 테이블에 저정된 S/O Candidate 조회대상에 UPDATE하는 이벤트 처리<br>
	 *
	 * @param e
	 * @param lSeq
	 * @throws EventException
	 */
	public void searchSingleTransportationSOCandidatesListU(Event e, String lSeq) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e
	 * @param lSeq
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSingleTransportationSOCandidatesList(Event e, String lSeq) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Temp 테이블에 저정된 S/O Candidate 조회대상에 UPDATE하는 이벤트 처리<br>
	 *
	 * @param lSeq
	 * @throws EventException
	 */
	public void searchSingleTransportationSOCandidatesListD(String lSeq) throws EventException;
	
	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_002 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse modifySingleTransportationSOManage(Event e) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_0051 에 대한 추가 이벤트 처리<br>
	 * CY & DOOR S/O Correction화면의 Separate 수행
	 * @param e ESD_TRS_0051Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse modify01SingleTransportationSOManage(Event e) throws EventException;

	/**
	 * W/O Issued 수정 이벤트 처리<br>
	 * ESD_TRS_002 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse modify02SingleTransportationSOManage(Event e) throws EventException;

	/**
	 * CY&DOOR Correction S/O 삭제 이벤트 처리<br>
	 * ESD_TRS_0051 에 대한 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_0051Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse removeSingleTransportationSOManage(Event e) throws EventException;

	/**
	 * IRG가 존재여부 체크 이벤트 처리<br>
	 * ESD_TRS_002 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param singleTransportationVO
	 * @throws EventException
	 */
	public void verifySingleTransportationSOIRG(SingleTransportationVO singleTransportationVO) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_002 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e
	 * @param sRow
	 * @return
	 * @throws EventException
	 */
	public String verifySingleTransportationDupChk(Event e, int sRow) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_002 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e
	 * @param sRow
	 * @return
	 * @throws EventException
	 */
	public String multiSingleTransportationSOManage(Event e, int sRow) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSingleTransportationSOList(Event e) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_930 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_930Event
	 * @return EventResponse ESD_TRS_930EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOfficeTransportationSOManage(Event e) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_930 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_930Event
	 * @return EventResponse ESD_TRS_930EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOfficeTransportationSOManageMT(Event e) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_930 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_930Event
	 * @return EventResponse ESD_TRS_930EventResponse
	 * @exception EventException
	 */
	public EventResponse search10TransportationSOManage(Event e) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_002 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubOfficeSOManageList(Event e) throws EventException;
	
	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_002 에 대한 추가 이벤트 처리<br>
	 * Actual Customer Info Change cause from Door Location/Zone Modification
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchActualCustomerInfoSet(Event e) throws EventException;	
	
	/**
	 * SO Candidate 삭제 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return 
	 * @exception EventException
	 */
	public List<SingleTransportationVO> removeSOCandidate(Event e) throws EventException;

	/**
	 * Container 직반납을 위한 OffHireVerify check<br>
	 * ESD_TRS_0002 에 대한 추가 이벤트 처리<br>
	 * OffHireVerify check
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchOffHireVerify(Event e) throws EventException;	
	
	/**
	 * CY / Door 변경에 따른 Cost Mode 조회<br>
	 * ESD_TRS_0002 에 대한 추가 이벤트 처리<br>
	 * OffHireVerify check
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public GeneralEventResponse searchCostMode(Event e) throws EventException;	
	
	/**
	 * S/O 발행 변경사항을 Before History 테이블에 관리
	 * 
	 * @param singleTransportationVO
	 * @param replanSts
	 * @throws EventException
	 */
	public void  multiSoIssueBeforeHis(SingleTransportationVO singleTransportationVO, String replanSts) throws EventException;
	
	/**
	 * S/O 발행 변경사항을 After History 테이블에 관리
	 * 
	 * @param singleTransportationVO
	 * @param replanSts
	 * @throws EventException
	 */
	public void  multiSoIssueAfterHis(SingleTransportationVO singleTransportationVO, String replanSts) throws EventException;

	/**
	 * SEARCH09 이벤트 처리<br>
	 * ESD_TRS_0002 화면에 대한 SEARCH07 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0002Event
	 * @return EventResponse EsdTrs0002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBkgVvd(Event e) throws EventException;
		
	/**
	 * S/O Correction 시 Delete flag 체크로직<br>
	 * 
	 * @param singleTransportationVO
	 * @return String
	 * @exception EventException
	 */
	public String verifySingleTransportationDeltChk(SingleTransportationVO singleTransportationVO) throws EventException;
	
	/**
	 * SO Creation 시 SCE_TRO_MAPG 테이블에 있는지 확인 로직<br>
	 * 
	 * @param singleTransportationVO
	 * @param uiContiCd
	 * @return String
	 * @exception EventException
	 */
	public String searchSceTroMapg (SingleTransportationVO singleTransportationVO, String uiContiCd) throws EventException;
	
	/**
	 * 2012.01.09 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
	 * Trans mode 와 Route 가 동일한 내용으로 생성된 건 중복 체크 로직<br>
	 * 
	 * @param singleTransportationVO
	 * @return String
	 * @throws EventException
	 */
	/**
	 * @param singleTransportationVO
	 * @return
	 * @throws EventException
	 */
	public String searchSODupCheck(SingleTransportationVO singleTransportationVO) throws EventException;
	
	 

	/**
	 * 2012.06.18 신동일 [CHM-201217633] [TRS] 구주 Hinterland T/F 및 시스템 개발 Project
	 * Node가 변경됐을 경우 Distance를 계산한다.
	 * @param singleTransportationVO
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDistanceCalculation(SingleTransportationVO singleTransportationVO) throws EventException;
	
	/**
	 * USA CY & Door Creation의 그리드 Door Yard변경시 Door Yard Name조회
	 * 
	 * @param dorYdNm String
	 * @return String
	 * @throws EventException
	 */
	public String searchDoorYardName(String dorYdNm) throws EventException;

}
