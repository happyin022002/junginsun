/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FACAuditBC.java
*@FileTitle : FAC Commission Maintenance Management
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-17
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-17 Hwang GyeongNam
* 1.0 최초 생성
* 2009-10-09 : Ho-Jin Lee Alps 전환
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.AGTFACRateInfoVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.FACCommDetailBasicbyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.FACCommDetailChargebyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.FACCommDetailHistorybyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.FACCommVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * eNIS-AGT Business Logic Command Interface<br>
 * - eNIS-AGT에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hwang GyeongNam
 * @see AGTAuditSC 참조
 * @since J2EE 1.4
 */
public interface FACAuditBC  {

	/**
	 * ESM_AGT_033 화면에서 Agreement Commission recalculate버튼 클릭시 처리 한다.<br>
	 * 
	 * @param e ESM_AGT_033Event
	 * @return EventResponse ESM_AGT_033EventResponse
	 * @exception EventException
	 */
	public EventResponse reCalcFACComm(Event e) throws EventException;


	/**
	 * ESM_AGT_033 화면에서 Agreement Commission recalculate버튼 클릭시 처리 한다.<br>
	 * 
	 * @param String bkg_no
	 * @param SignOnUserAccount account
	 * @return EventResponse ESM_AGT_033EventResponse
	 * @exception EventException
	 */
	public EventResponse recalcFACComm(String bkg_no, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_033 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param FACCommVO facCommVO
	 * @return List<FACCommVO>
	 * @exception EventException
	 */
	public List<FACCommVO> searchFACCommList(FACCommVO facCommVO) throws EventException;

    /**
     * (ESM_AGT_015) 화면-FAC Commission의 Basic 정보 조회
     * @param FACCommDetailBasicbyBLVO facCommDetailBasicbyBLVO
     * @return List<FACCommDetailBasicbyBLVO>
     * @throws EventException
     */
	public List<FACCommDetailBasicbyBLVO> searchFACCommDetailBasicbyBL(FACCommDetailBasicbyBLVO facCommDetailBasicbyBLVO) throws EventException;
	/**
	 * (ESM_AGT_015) Charge Detail 목록 조회
	 * @param FACCommDetailChargebyBLVO facCommDetailChargebyBLVO
	 * @return List<FACCommDetailChargebyBLVO> 
	 * @throws EventException
	 */
	public List<FACCommDetailChargebyBLVO> searchFACCommDetailChargebyBL(FACCommDetailChargebyBLVO facCommDetailChargebyBLVO) throws EventException;
	/**
	 * (ESM_AGT_015) FAC Commission의 History Detail 목록 조회
	 * @param FACCommDetailHistorybyBLVO facCommDetailHistorybyBLVO
	 * @return List<FACCommDetailHistorybyBLVO>
	 * @throws EventException
	 */
	public List<FACCommDetailHistorybyBLVO> searchFACCommDetailHistorybyBL(FACCommDetailHistorybyBLVO facCommDetailHistorybyBLVO) throws EventException;
	/**
	 * (ESM_AGT_015) 실제로 Commission 계산한 FAC Agreement 요율 정보 조회
	 * @param AGTFACRateInfoVO agtFacRateInfoVO
	 * @return List<AGTFACRateInfoVO>
	 * @throws EventException
	 */
	public List<AGTFACRateInfoVO> searchAGTFACRateInfo(AGTFACRateInfoVO agtFacRateInfoVO) throws EventException;
	
	
	/**
	 * ESM_AGT_034 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 *
	public EventResponse searchAPActualInterfaceMasterForFAC(Event e) throws EventException;

	/**
	 * ESM_AGT_034 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESM_AGT_034Event
	 * @return EventResponse ESM_AGT_034EventResponse
	 * @exception EventException
	 *
	public EventResponse searchAPActualInterfaceDetailForFAC(Event e) throws EventException;

	**
     * ESM_AGT_034 화면에 대한 AP Interface 이벤트 처리 : AP IF 실행하기<br>
     * 
     * @param  Event e
     * @return EventResponse 
     * @throws EventException
     *
    public EventResponse createFACActualINFtoAP(Event e) throws EventException;
    **
	 * 인쇄 이벤트 처리<br>
	 * ESM_AGT_034 화면에 대한 인쇄 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 *
	public EventResponse searchFACInfoForPrint(Event e) throws EventException;
    **
     * ESM_AGT_034 화면에 대한 AP Interface 이벤트 처리 : AP CANCEL IF 실행하기<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @throws EventException
     *
    public EventResponse createCancelFACActualINFtoAP(Event e) throws EventException;
    */
    /**
     * ESM_AGT_033 화면에서 Recalculation 시 AR Interface 처리<br>
     * 
     * @param  String[][] array
     * @throws EventException
     */
    public void reCalcEAINISFACCommInfo(String[][] array) throws EventException;
    
	
}