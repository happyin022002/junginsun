/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Constants.java
*@FileTitle : 상수로 사용하는 interface
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-24
*@LastModifier : ChangHoChae
*@LastVersion : 1.0
* 2006-10-24 ChangHoChae
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common;

/**
 * ENIS-EQR Business Constants<br>
 * - ENIS-EQR에 대한 공통으로 사용되는 상수 정의.<br>
 * 
 * @author ChangHoChae
 * @see DBDAO 참조,개별 class 참조
 * @since J2EE 1.4
 */
public interface Constants {
	
	
	// SCENARIO
	public static final String SCNR_WORD = "SCEN";
	public static final String SCNR_WEEK = "W";
	
	
	// REPOPLAN
	public static final String REPO_WORD = "REPO";
	public static final String REPO_WEEK = "W";		
	
	// PAGE_SIZE
	public static final int PAGE_SIZE_50  =  50;
	public static final int PAGE_SIZE_100 = 100;
	public static final int PAGE_SIZE_300 = 300;
	public static final int PAGE_SIZE_500 = 500;
	
	// Rerun Flag
	public static final String RUN_RUOP = "Run Empty Repo Optimization";
	public static final String RUN_VESL = "Change Vessel Schedule Simulation";
	public static final String RUN_ONOF = "Oneway Offer Simulation";
	public static final String RUN_SENS = "Sensitivity";
	
	// Input Data Red Light Alert  search com_intg_cd_dtl.intg_cd_id	
	public static final String INTG_CD_ID_1 = "CD00873";
	public static final String INTG_CD_ID_2 = "CD00255";
	
	// 0081 TRS Off Hire 직반납 ReturnCode add by ChungEunHo 09.10.21
	public static final String TRS_OFF_HIRE_RETURNCODE_SUCCESS = "00"; // 변경 성공
	public static final String TRS_OFF_HIRE_RETURNCODE_FAIL_10 = "10"; // 변경 VOL 허용범위 위반
	public static final String TRS_OFF_HIRE_RETURNCODE_FAIL_20 = "20"; // 조회값에 해당하는 데이터 없음
	public static final String TRS_OFF_HIRE_RETURNCODE_FAIL_30 = "30"; // OFF Hire 아님
	public static final String TRS_OFF_HIRE_RETURNCODE_FAIL_40 = "40"; // 조회값에 해당하는 S/O 데이터카운트가 맞지 않음 , 변경할 CNTR NO 갯수와 변경할 VOL 카운트가 맞지 않음
	public static final String TRS_OFF_HIRE_RETURNCODE_FAIL_50 = "50"; // fm_yd_cd , to_yd_cd 동일 ECC 구간 아님
	
	

}
