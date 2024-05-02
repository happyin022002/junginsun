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
* 2009.08.25 임옥영 checkStdCostCode DAO에 해당 메소드 없어서 Utils.java, CommonBC, CommonBCImple에서 삭제함          
* 2010.02.04 임옥영 :품질검토결과 반영
* 2010.09.01 김기종 CSR No. CHM-201004982-01 COA Architecture 위배사항 수정 (CommonSC)
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2013.01.16 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
* 2013.12.13 김수정 [CHM-201328111] [COA] EMU COST 변경 로직 Pre CM 반영 요청 - DEL Code, DEL Term 에 따른 MT Return CY 조회 추가
* 2014.04.10 최성민 [CHM-201429154] Target VVD BSA Flag 처리 후 BSA 시스템 연동 로직 변경 요청
* 2014.06.19 최덕우 [CHM-201430638] [COA] BU Other (계선/대선) 항목의 각 계정별 분리 반영 위한 CSR 
=========================================================*/
package com.hanjin.apps.alps.esm.coa.common.basic;

import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.vo.BkgSokeupVO;
import com.hanjin.apps.alps.esm.coa.common.vo.GetCodeSelectVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchSimNoDescVO;
import com.hanjin.apps.alps.esm.coa.common.vo.WeekCopyVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaUtCostCreStsVO;

/**
 * ENIS-COA Business Logic Command Interface<br>
 * - ENIS-COA에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author eunju park
 * @see ESM_COA_051EventResponse 참조
 * @since J2EE 1.4
 */
public interface CommonBC  {
    
	/**
	 * 기간을 리턴한다.
	 * 
	 * @param SearchConditionVO vo
	 * @return String
	 * @throws EventException
	 */
    public String searchDatePeriod(SearchConditionVO vo) throws EventException;
    
    /**
     * 전주를 리턴한다
     * @param year
     * @param week
     * @return
     * @throws EventException
     */
    public String searchPreWeek(String year, String week) throws EventException;
    
    /**
     * Vessel Sub Trade 목록을 조회한다.
     * 
     * @return DBRowSet
     * @throws EventException
     */
    public DBRowSet searchVSLSubTradeList() throws EventException;
    
    /**
     * Booking Number 유효성 체크
     * 
	 * @param bkg_no
     * @return
     * @throws EventException
     */
    public boolean checkBKGNo(String bkg_no) throws EventException;
    
    /**
     * Location Code 유효성 체크 
     * 
     * @param loc_cd
     * @return
     * @throws EventException
     */
    public boolean checkLocationCode(String loc_cd) throws EventException; 
    
    /**
     * Vessel code 유효성 체크 
     * 
     * @param vsl_cd String
     * @return
     * @throws EventException
     */
    public boolean checkVesselCode(String vsl_cd) throws EventException; 
    
    /**
     * VVD Code 유효성 체크
     * 
	 * @param vsl_cd
	 * @param skd_voy_no
	 * @param dir_cd
     * @return
     * @throws EventException
     */
    public boolean checkVVDCode(String vsl_cd, String skd_voy_no, String dir_cd) throws EventException;
    
    /**
     * Office Code 유효성 체크
     * 
     * @param ofc_cd
     * @return
     * @throws EventException
     */
    public boolean checkOfficeCode(String ofc_cd) throws EventException; 
    
    /**
     * Revenue Lane Code 유효성 체크
     * 
     * @param rlane_cd
     * @return
     * @throws EventException
     */
    public boolean checkRevLaneCode(String rlane_cd) throws EventException;
    
    /**
     * Service Lane code 유효성 체크
     * 
     * @param slane_cd
     * @return
     * @throws EventException
     */
    public boolean checkSLaneCode(String slane_cd) throws EventException;
    
    /**
     * Node Code 유효성 체크
     * 
     * @param node_cd
     * @return
     * @throws EventException
     */
    public boolean checkNodeCode(String node_cd) throws EventException;				// Node Code 유효성 체크


    /**
     * Simulation number의 설명을 조회한다.
     * 
     * @param vo
     * @return
     * @throws EventException
     */
	public List<SearchSimNoDescVO> searchSimNoDesc(SearchConditionVO vo) throws EventException;
	
	/**
	 * VVD에 해당하는 ETD date를 반환한다.
	 * 
	 * @param vsl_cd
	 * @param skd_voy_no
	 * @param skd_dir_cd
	 * @return
	 * @throws EventException
	 */
	public String searchFirstEtd(String vsl_cd, String skd_voy_no, String skd_dir_cd) throws EventException;

	/**
	 * 전주를 반환한다.
	 * 
	 * @return
	 * @throws EventException
	 */
	public String searchPrevWkPrd() throws EventException;
	
	/**
	 * office code에 해당하는 Level를 반환한다.
	 * 
	 * @param ofc_cd
	 * @return
	 * @throws EventException
	 */
	public String searchOFCLevel(String ofc_cd) throws EventException;

	/**
	 * 특정조건에 만족하는 경우 office code에 변경하여 반환한다.
	 * (HQ 산하의 조직이면서 Area가 아닌경우 HQ레벨의 office code를 리턴한다.)
	 * @param ofc_cd
	 * @return
	 * @throws EventException
	 */
	public String searchChgOffice(String ofc_cd) throws EventException;
	
	/**
	 * office code에 해당하는 Team Code를 반환한다.
	 * 
	 * @param ofc_cd
	 * @return team code
	 * @throws EventException
	 */
	public String searchTeamCode(String ofc_cd) throws EventException;
	
	/**
	 * 환율 변환 
	 * 
	 * @param cost_yrmon
	 * @param locl_curr_cd
	 * @param lcl_amt
	 * @return usd_amt
	 * @throws EventException
	 */
	public float getUSDAmt(String cost_yrmon, String locl_curr_cd, float lcl_amt) throws EventException;		
	
	/**
	 * 날짜에 대한 Max Simulation No를 조회한다.
	 * 
	 * @return
	 * @throws EventException
	 */
	public String searchMaxSimNo() throws EventException;
	
	/**
	 * Location Code를 이용해서 Office Code를 반환한다
	 * 
	 * @param loc_cd
	 * @return ofc_cd
	 * @throws EventException
	 */	
	public String getLocationToOffice(String loc_cd) throws EventException;
	
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
	 * IBSheet의 동적 콤보가 있을경우 Retrieve시 각각의 콤보를 세팅해 주어야 할때 사용한다.
	 * 
	 * @param tagName       Select List Box의 name
	 * @param codeItem      반환할 업무 대상
	 *                      01. Sub Trade List         	: subTrade
	 *                      02. COA Main Group          : mnGroup
	 *                      03. COA Sub Group          	: subGroup
	 *                      04. Service Lane List		: sLane2
	 *                      05. Revenue Lane List		: rLane2
	 *                      06. 점소단위의 Office List	: office2
	 *                      07. RA SubGroup 			:raSubGrp
	 *                      08. Stndard Cost Code List  : coaCode
	 *                      09. Revenue Lane List		: rLane4 (IP 제외)
	 *                      
	 * @param searchCode
	 * @param rtnType       name  : name을 리턴
	 *                      code  : code를 리턴
	 * @return
	 * @throws EventException
	 */
	public HashMap<String, String> getCodeCombo(String tagName, String codeItem, String searchCode, String rtnType) throws EventException ;
	
	/**
	 * IBSheet의 동적 콤보가 있을경우 Retrieve시 각각의 콤보를 세팅해 주어야 할때 사용한다.
	 * 
	 * @param tagName       Select List Box의 name
	 * @param codeItem      반환할 업무 대상
	 *                      01. Sub Trade List         	: subTrade
	 *                      02. COA Main Group          : mnGroup
	 *                      03. COA Sub Group          	: subGroup
	 *                      04. Service Lane List		: sLane2
	 *                      05. Revenue Lane List		: rLane2
	 *                      06. 점소단위의 Office List	: office2
	 *                      07. RA SubGroup 			:raSubGrp
	 *                      08. Stndard Cost Code List  : coaCode
	 *                      09. Revenue Lane List		: rLane4 (IP 제외)
	 *                      
	 * @param searchCode
	 * @param rtnType       name  : name을 리턴
	 *                      code  : code를 리턴
	 * @throws EventException
	 */
	public String getIbCodeCombo(String tagName, String codeItem, String searchCode, String rtnType) throws EventException;
	
	
	/**
	 * 사용자 office level을 리턴한다.(가공된)
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getUserLevel(String ofc_cd) throws EventException;
	
	
	/**
	 * 사용자 office code 을 리턴한다.(가공된)
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getUserOffice2(String ofc_cd) throws EventException;
	
	/**
	 * [년도, 월] 혹은 [년도, 주]를 받아서 기간을 리턴하는 함수
	 * 
	 * @param year		년도
	 * @param date		월(09), 주(23) 가 들어올수 있음
	 * @param type		date 인자에 들어오는 값이 어떤것인지를 알려준다.
	 * 					month
	 * 					week
	 * @return	String
	 * @exception EventException
	 */
	public String getDatePeriod(String year, String date, String type) throws EventException;
	
	/**
	 * [년도, 시작월~종료월] 혹은 [년도, 시작주~종료주] 혹은 [년도, 월, 주]를 받아서 기간을 리턴하는 함수
	 * 
	 * @param year		년도
	 * @param frmDate	시작 월, 시작 주
	 * @param toDate	종료 월, 종료 주
	 * @param type		date의 인자에 들어오는 값이 어떤 것이 있는 지 알려준다.
	 * 					month, week, monthWeek
	 * @return	String
	 * @exception EventException
	 */
	public String getDatePeriod(String year, String frmDate, String toDate, String type) throws EventException;
		
	/**
	 * [년도, 시작월~종료월, 시작주~종료주] 를 받아서 기간을 리턴하는 함수
	 * 
	 * @param year			년도
	 * @param frmMonth		시작 월
	 * @param toMonth		종료 월
	 * @param frmWeek		시작 주
	 * @param toWeek		종료 주
	 * @return String
	 * @exception EventException
	 */
	public String getDatePeriod(String year, String frmMonth, String toMonth, String frmWeek, String toWeek) throws EventException;
	
    /**
     * 전주 년도를 리턴한다
     * @return String
     * @throws EventException
     */
    public String searchPrevYearPrd() throws EventException;
    
    /**
     * ESM_COA_9000 : BKG 소급 리스트 조회<br>
	 * 
	 * @param BkgSokeupVO bkgSokeupVO
	 * @return List<BkgSokeupVO>
	 * @exception EventException
     */
	public List<BkgSokeupVO> searchBkgSokeupStatus(BkgSokeupVO bkgSokeupVO) throws EventException ;
	
	/**
	 * ESM_COA_9000 : BKG 소급<br>
	 * @param BkgSokeupVO[] bkgSokeupVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBkgSokeup(BkgSokeupVO[] bkgSokeupVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * 입력된 DEL Term, DEL Location, Node 에 따른 MT Return CY를 찾는다.
	 * 
	 * @param loc_cd
	 * @param tml_cd
	 * @param de_term
	 * @param f_pol_pod_cd
	 * @param f_spcl_cgo_cd
	 * @return String
	 * @throws EventException
	 */	
	public String getMtyReturnCY(String loc_cd, String tml_cd, String de_term, String f_pol_pod_cd, String f_spcl_cgo_cd) throws EventException;
	

	/**
	 * batch가 실행중인지를 check 한다.
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<CoaUtCostCreStsVO>
	 * @throws EventException
	 */
	public List<CoaUtCostCreStsVO> searchBatchStatus(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * BATCH status 를 생성한다. <br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void addBatchStatus(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 생성 이벤트 처리<br>
	 * Vessel Charter / Lay Up Expense를 주단가를 복사해서 생성한다.<br>
	 *
	 * @param WeekCopyVO weekCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createVslLayupWeekCopy(WeekCopyVO weekCopyVO, SignOnUserAccount account) throws EventException;
	
}