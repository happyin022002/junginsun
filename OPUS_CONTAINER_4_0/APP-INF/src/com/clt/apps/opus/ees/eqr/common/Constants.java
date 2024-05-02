/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Constants.java
*@FileTitle : Constants
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.common;

/**
 * -EQR Business Constants<br>
 * 
 * @author 
 * @see DBDAO 
 * @since J2EE 1.4
 */
public interface Constants {
	
	
	// SCENARIO
	public static final String SCNR_WORD = "SCN";
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
	public static final String TRS_OFF_HIRE_RETURNCODE_SUCCESS = "00"; // modify success
	public static final String TRS_OFF_HIRE_RETURNCODE_FAIL_10 = "10"; // VOL outlier
	public static final String TRS_OFF_HIRE_RETURNCODE_FAIL_20 = "20"; // the data doesn't exist
	public static final String TRS_OFF_HIRE_RETURNCODE_FAIL_30 = "30"; // not OFF Hire 
	public static final String TRS_OFF_HIRE_RETURNCODE_FAIL_40 = "40"; // not matche data
	public static final String TRS_OFF_HIRE_RETURNCODE_FAIL_50 = "50"; // fm_yd_cd and to_yd_cd are different ECC
	
	

}
