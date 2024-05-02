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
=========================================================*/
package com.clt.apps.opus.esm.bsa.common.basic;

import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.bsa.common.vo.ComboVO;
import com.clt.apps.opus.esm.bsa.common.vo.GetCodeSelectVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * BSA Business Logic Command Interface<br>
 * - BSA에 대한 비지니스 로직에 대한 인터페이스<br>
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
	
}