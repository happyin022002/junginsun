/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : LaneSimulationBC.java
*@FileTitle : 항로 Simulation 마스터 및 W/F 생성/조회/변경
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : eunju park
*@LastVersion : 1.0
* 2006-08-25 eunju park
* 1.0 최초 생성
* 2009.03.26 박은주 : 품질검토결과 수정사항 반영
* 2010.06.21 이행지  - CHM-201004175 : 소스품질검토결과 적용(20100503)
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
* 2011.02.10 최성민 [CHM-201108533-01] getDatePeriod() 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.common.basic;

import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.bsa.common.vo.ComboVO;
import com.hanjin.apps.alps.esm.bsa.common.vo.GetCodeSelectVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * ENIS-COA Business Logic Command Interface<br>
 * - ENIS-COA에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author eunju park
 * @see ESM_BSA_051EventResponse 참조
 * @since J2EE 1.4
 */
public interface CommonBC  {

    /**
	 * 기간을 리턴한다.
	 * 
	 * @param ComboVO vo
	 * @return String
	 * @throws EventException
	 */
    public String searchDatePeriod(ComboVO vo) throws EventException;
    
    /**
     * 전주를 리턴한다
     * @param year
     * @param week
     * @return
     * @throws EventException
     */
    public String searchPreWeek(String year, String week) throws EventException;
    
    /**
     * Location Code 유효성 체크 
     * 
     * @param String locCd
     * @return String
     * @throws EventException
     */
    public String checkLocationCode(String locCd) throws EventException; 
    
    /**
	 * VVD에 해당하는 ETD date를 반환한다.
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return String
	 * @throws EventException
	 */
	public String searchFirstEtd(String vslCd, String skdVoyNo, String skdDirCd) throws EventException;
	
	/**
	 * VSL CD에 해당하는 결과건수를 반환한다.
	 * 
	 * @param String vslCd
	 * @return String
	 * @throws EventException
	 */
	public String searchVslCd(String vslCd) throws EventException;
	
	/**
	 * 전주를 반환한다.
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String searchPrevWkPrd() throws EventException;
	
	/**
     * 1. 기능 : default combo,ibsheet codelist를 return <p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * 
     * @param codeItem      	Where절에 들어갈 코드그룹
     * @param code      	    Where절에 들어갈 코드조건값
     * @return List<GetCodeSelectVO>
     * @throws EventException
     */
	public List<GetCodeSelectVO> getCodeSelectList(String codeItem, String code) throws EventException ;
	
	/**
     * 기능 : default combo,ibsheet codelist를 return <p>
     * 
     * @param GeneralEventResponse eventResponse
     * @param String[][] array
     * @return GeneralEventResponse
     * @throws EventException
     */
	public GeneralEventResponse getMakeCodeSelectList(GeneralEventResponse eventResponse,String[][] array) throws EventException ;
	
	/**
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String searchBSAOpt() throws EventException ;
	
	/**
	 * 
	 * @param code
	 * @return String
	 * @throws EventException
	 */
	public String searchIBCodeList(String code) throws EventException ;
	
	/**
	 * 
	 * @param code
	 * @return
	 * @throws EventException
	 */
	public HashMap<String, String> getCodeIBCombo(String code) throws EventException ;
	
	/**
	 * [년도, 시작월~종료월] 혹은 [년도, 시작주~종료주] 혹은 [년도, 월, 주]를 받아서 기간을 리턴하는 함수
	 * 
	 * @param String year		년도
	 * @param String frmDate	시작 월, 시작 주
	 * @param String toDate	종료 월, 종료 주
	 * @param String type		date의 인자에 들어오는 값이 어떤 것이 있는 지 알려준다.
	 * 							month, week, monthWeek
	 * @return	String
	 * @exception EventException
	 */
	public String getDatePeriod(String year, String frmDate, String toDate, String type) throws EventException;
		
}