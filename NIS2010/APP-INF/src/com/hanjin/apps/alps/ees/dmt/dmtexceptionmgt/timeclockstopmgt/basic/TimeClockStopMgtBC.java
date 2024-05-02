/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TimeClockStopMgtBC.java
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.04.30 최성환
* 1.0 Creation
* 2010.10.04 김태균 [CHM-201006288-01] [EES-DMT] Session 정보 관련 수정 - 9400 서버에러로 인하여 method 명 변경(comBakEndJb -> comBackEndJb)
* 2010.11.25 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.DmtTimeClockStopVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.TimeClockStopParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.YardByOfficeVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * APLS-Dmtexceptionmgt Business Logic Command Interface<br>
 * - APLS-Dmtexceptionmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Choi Sung Hwan
 * @see Ui_dmt_2010EventResponse 참조
 * @since J2EE 1.4
 */

public interface TimeClockStopMgtBC {
	/**
	 *  Clock Stop no의 대한 해당 데이터를 조회한다.
	 * 
	 * @param TimeClockStopParmVO  timeClockStopParmVO
	 * @return List<DmtTimeClockStopVO>
	 * @exception EventException
	 */
	public List<DmtTimeClockStopVO> searchTimeClockStop(TimeClockStopParmVO  timeClockStopParmVO ) throws EventException;
	/**
	 * Clock Stop no의 대한 List 데이터를 조회한다.
	 * 
	 * @param TimeClockStopParmVO timeClockStopParmVO
	 * @return List<DmtTimeClockStopVO>
	 * @exception EventException
	 */
	public List<DmtTimeClockStopVO> searchTimeClockStopList(TimeClockStopParmVO timeClockStopParmVO ) throws EventException;
	/**
	 * Clock Stop no에 대한 주키를 가지고 해당 데이타의 상태를 변경한다.
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
//	public void cancelTimeClockStop(DmtTimeClockStopVO dmtTimeClockStopVO,SignOnUserAccount account) throws EventException;
	/**
	 * Clock Stop의 새로운 정보를 반영한다.
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @param SignOnUserAccount account
	 * @return List<DmtTimeClockStopVO>
	 * @exception EventException
	 */
//	public List<DmtTimeClockStopVO> createTimeClockStop(DmtTimeClockStopVO dmtTimeClockStopVO,SignOnUserAccount account) throws EventException;
	/**
	 * 사용자의 권한을 체크한다.
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchAuthExist(String ofcCd) throws EventException;
	
	/////////////////////////////////////////////////////////////////////////////////////
	////////// START BACK END JOB AREA //////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * EES_DMT_2010 : BACKENDJOB START.<br>
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
     * @param SignOnUserAccount account
	 * @return String
	 */
	public String doBackEndJob(DmtTimeClockStopVO dmtTimeClockStopVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * BACKENDJOB 공통. 상태를 리턴 합니다.<br>
	 * 
	 * @param String key
	 * @return String
	 */
	public String comBackEndJb(String key) throws EventException ;
	
	/**
	 * BackEndJob Read 처리<br>
	 * BackEndJob처리 결과를 조회한다<br>
	 *
	 * @param String key
	 * @return DmtTimeClockStopVO
	 * @exception EventException
	 */
	public DmtTimeClockStopVO createTimeClockStopBackEndJob(String key) throws EventException;
	
	/**
	 * EES_DMT_2010 : BACKENDJOB START.<br>
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
     * @param SignOnUserAccount account
	 * @return String
	 */
	public String doCancelBackEndJob(DmtTimeClockStopVO dmtTimeClockStopVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * BACKENDJOB 공통. 상태를 리턴 합니다.<br>
	 * 
	 * @param String key
	 * @return String
	 */
	public String comCancelBakEndJb(String key) throws EventException ;
	
	/**
	 * BackEndJob Read 처리<br>
	 * BackEndJob처리 결과를 조회한다<br>
	 *
	 * @param String key
	 * @return DmtTimeClockStopVO
	 * @exception EventException
	 */
	public DmtTimeClockStopVO cancelTimeClockStopBackEndJob(String key) throws EventException;
	
	/**
	 * Office에 대한 Yard Code를 조회한다.<br>
	 * 
	 * @param TimeClockStopParmVO timeClockStopParamVO
	 * @return List<YardByOfficeVO>
	 * @exception EventException
	 */
	public List<YardByOfficeVO> searchDMTYardByOffice(TimeClockStopParmVO timeClockStopParamVO ) throws EventException;
	
}