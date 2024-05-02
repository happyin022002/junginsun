/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : eqrcommonBC.java
*@FileTitle : Max UPD_USR_ID , UPD_DT 조회 
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1      	1.0      	채창호								2009.07.09		1.0 최초 생성
* 2		1.1		Lee Byoung Hun				2010.05.11		CSR No : CHM-201003779 - getUserInfo 메소드 추가
* 
*@LastModifyDate : 2009.07.09
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.09 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic;

import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Eqrcommon Business Logic Command Interface<br>
 * - ALPS-Eqrcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Chae Change Ho
 * @see EqrcommonEesCommonVO 참조
 * @since J2EE 1.6
 */

public interface CommonBC {

	/**
	 * @param loctype  String 
	 * @param location String 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO convertECCInfo(String loctype, String location) throws EventException;
	
	/**
	 * @param conditionVO EesCommonConditionVO 
	 * @return EesCommonVO scnridReMarkSearch
	 * @exception EventException
	 */	
	public EesCommonVO scnridReMarkSearch (EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * @param conditionVO EesCommonConditionVO 
	 * @return EesCommonVO weeklyConditionSearch
	 * @exception EventException
	 */	
	public EesCommonVO weeklyConditionSearch(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * @param loctype  String 
	 * @param location String 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */		
    public CommonVO convertECCInfoString(String loctype, String location) throws EventException;
    
	/**
	 * @param table     String 
	 * @param condition String 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */		    
	public CommonVO searchMaxInfo(String table, String condition) throws EventException;
	
	/**
	 * @param scnr_id String 
	 * @return String searchADRflg
	 * @exception EventException
	 */		    	
	public CommonVO searchADRflg(String scnr_id) throws EventException;
	
	/**
	 * @param curYear String 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */		 	
	public CommonVO minMax01(String curYear) throws EventException;
	
	/**
	 * @param curYear String 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */		 		
	public CommonVO maxMin52(String curYear) throws EventException;

	/**
	 * @param curYear String 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */		 	
	public CommonVO getMinMaxWeek(String curYear) throws EventException;

	/**
	 * @param conditionVO EesCommonConditionVO 
	 * @return EesCommonVO repoidReMarkSearch
	 * @exception EventException
	 */	
	public EesCommonVO repoidReMarkSearch (EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * @param repoId  String 
	 * @param repoRmk String 
	 * @param usrId   String 
	 * @return CommonVO isResultBoolean()
	 * @exception EventException
	 */		
	public CommonVO modifyRepoRmk(String repoId, String repoRmk, String usrId) throws EventException;
	
	/**
	 * @param year String 
	 * @return CommonVO getList()
	 * @exception EventException
	 */		
	public CommonVO searchWeek(String year) throws EventException;
	
	/**
	 * @param ecc_cd String
	 * @return CommonVO
	 * @exception EventException
	 */			
	public EesCommonVO checkEccCode(String ecc_cd) throws EventException;

	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */		
	public EesCommonVO checkLocCode(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO checkLocCodeWithMaster
	 * @exception EventException
	 */	
	public EesCommonVO checkLocCodeWithMaster(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * @param scnrId String 
	 * @param scnrRmk String 
	 * @param usrId String 
	 * @return CommonVO isResultBoolean()
	 * @exception EventException
	 */	
	public CommonVO modifyScnrRmk(String scnrId, String scnrRmk, String usrId) throws EventException;

	/**
	 * @param conStr String[] 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */	
	public CommonVO tiltelMakMonth(String[] conStr) throws EventException;
	
	/**
	 * @param conStr String[] 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */		
	public CommonVO tiltelMakWeek(String[] conStr) throws EventException;
	
	/**
	 * @param conStr String[] 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */			
	public CommonVO monthCount(String[] conStr) throws EventException;

	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchLocYardExist(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchLocYardCompanyExist(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchLocYardInfo(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardCompanyInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchLocYardCompanyInfo(EesCommonConditionVO conditionVO) throws EventException;	
	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchLocYardVesselInfo(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * @param EesCommonConditionVO conditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchLocYardInitialInfo(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchLseCoYardInfo(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardEccInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchLocYardEccInfo(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchVendorInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchVendorInfo(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchVendorInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchVendorInfoBySeq(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchVvdInfo
	 * @exception EventException
	 */				
	public EesCommonVO searchVvdInfo(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchVvdInlandInfo
	 * @exception EventException
	 */
	public EesCommonVO searchVvdInlandInfo(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchVvdInfo
	 * @exception EventException
	 */				
	public EesCommonVO searchVvdExist(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchWeekScnrId
	 * @exception EventException
	 */			
	public EesCommonVO searchWeekScnrId(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchCountryInfo
	 * @exception EventException
	 */		
	public EesCommonVO searchCountryInfo(EesCommonConditionVO conditionVO) throws EventException;

	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchCheckPeriod
	 * @exception EventException
	 */			
	public EesCommonVO searchCheckPeriod(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchCheckPeriodOpt
	 * @exception EventException
	 */			
	public EesCommonVO searchCheckPeriodOpt(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * @param yyyyww String
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */			
	public CommonVO searchWeekToDate(String yyyyww) throws EventException;	
	
	/**
	 * @param yyyyww String
	 * @param strDs String
	 * @return CommonVO getResultString()
	 * @exception EventException
	 * CSR NO :R200904090006
	 * 인수 strDs null이면 jdbc/HJSENIS으로 
	 *            null이 아니면  jdbc/xa/HJSENIS으로 DB Connect가 일어남 
	 */			
	public CommonVO searchWeekEndDate(String yyyyww ,String strDs) throws EventException;	
	
	/**
	 * @param yyyyww
	 * @param gapmonth
	 * @param strDs
	 * @return CommonVO getResultString()
	 * @exception EventException
	 * CSR NO :R200904090006
	 * 인수 strDs null이면 jdbc/HJSENIS으로 
	 *           null이 아니면  jdbc/xa/HJSENIS으로 DB Connect가 일어남  
	 */			
	public CommonVO searchWeekStartDate(String yyyyww, String gapMonth , String strDs) throws EventException;	
	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchCheckPeriodOpt
	 * @exception EventException
	 */			
	public EesCommonVO searchBetweenWeek(EesCommonConditionVO conditionVO) throws EventException;
	
	
	/**
	 * @param repo_plan_id String
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */			
	public CommonVO searchOldRepoPlantype(String repo_plan_id) throws EventException;
	 
	 /**
		 * @param scnario_id String
		 * @return CommonVO getResultString()
		 * @exception EventException
		 */			
	public CommonVO createNewScnarioId(String scnario_id) throws EventException;
	
	 /**
	 * @param repo_plan_id String
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */	
	public CommonVO  createNewRepoPlanId(String repo_plan_id) throws EventException; 
	
	 /**
	 * @param yyyyww String
	 * @param gap int
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */	
	public CommonVO  weewklyConvertMonth(String yyyyww , int gap) throws EventException;

	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchWeekDatePeriod
	 * @exception EventException
	 */			
	public EesCommonVO searchWeekDatePeriod(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO search eta date
	 * @exception EventException
	 */			
	public EesCommonVO searchEtaDate(EesCommonConditionVO conditionVO) throws EventException;	
	
	/**
	 * 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getTpszInitial() throws EventException;	
	
	/**
	 * 
	 * @param yard_code
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getYardCNTCode(String yard_code) throws EventException;		

	/**
	 * 날짜정보를 주차정보로 변경
	 *     
	 * @param date
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO convertDayWeekly(String date) throws EventException;	
	
	/**
	 * yard code의 해당 ECC를 검색하여 리턴
	 * 
	 * @param yard_code
	 * @param column_name
	 * @return
	 * @exception EventException
	 */
	public CommonVO convertYardToECC(String yard_code, String column_name) throws EventException;	
	
	/**
	 * duplicate_check의 해당 VVD 중복체크를 해서 리턴
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchDuplicatCheckPod(EesCommonConditionVO conditionVO) throws EventException;	
	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchCheckPeriod
	 * @exception EventException
	 */			
	public EesCommonVO searchBeforeCheckPeriod(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchCheckPeriod
	 * @exception EventException
	 */			
	public EesCommonVO searchVesselScheduleCheck(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchBayPort
	 * @exception EventException
	 */			
	public EesCommonVO searchBayPort(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLane
	 * @exception EventException
	 * CSR No - N200904200110 : VVD Add 추가기능으로 인한 메소드 추가
	 */			
	public EesCommonVO searchLane(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * REPO_PLN_ID, PLN_YRWK 를 기준으로 대상 테이블의 Next PLN_SEQ 를 취득한다.
	 * @param tableName String
	 * @param repoPlnId String
	 * @param plnYrwk String
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO getNextPlnSeq(String tableName, String repoPlnId, String plnYrwk) throws EventException;
	
	/**
	 * USR_ID를 기준으로 COM_USER 테이블에서 USR_NM, OFC_CD를 취득한다.
	 * 
	 * @param usrId String 
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO getUserInfo(String usrId) throws EventException;
	
	/**
	 * 현재주차 정보를 조회 
	 *     
	 * @param yyyyww
	 * @param nextNum 
	 * @param direction 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getCurrentWeek() throws EventException;
	
}
