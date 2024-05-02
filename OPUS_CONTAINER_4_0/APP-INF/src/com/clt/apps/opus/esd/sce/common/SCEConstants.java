/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SCEConstants.java
*@FileTitle : SCE 공통관리
*Open Issues :
*Change history :
*@LastModifyDate : 2007-05-08
*@LastModifier : Shin yong cheon
*@LastVersion : 1.0
* 2007-05-08 Shin yong cheon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.common;
 
/**
 * SCE Constant<br>
 * - SCE에서 사용하는 공통 상수 .<br>
 * 
 * @author Shin yong cheon
 * @see  
 * @since J2EE 1.4
 */
public interface SCEConstants {
	
	public static final String PSEUDO_CNTR_NO = "COMU0000000";
	
	public static final String SCE_CHG_EVENT_ERROR = "10"; //Replan event Error(S/O)
	public static final String SCE_CHG_EXCEPTION_ERROR = "20"; //Replan Exception Error(S/O)
	public static final String SCE_CHG_PC_DUP_ERROR = "30"; //Replan PC Number Duplication Error(S/O)
	public static final String SCE_CHG_PROCESS_ERROR = "40"; //Replan Process Error(S/O)
	public static final String SCE_CHG_UNMATCH_EXPT = "50"; //Replan Unmatch Error(S/O)
	public static final String SCE_CHG_SUCCESS = "99"; //Replan SUCCESS(S/O)
	public static final String SCE_GENERAL_SO_SUCCESS = "98"; //Replan SUCCESS(S/O)
	
	public static final String SCE_VNDR_CHG_SUCCESS = "97"; //Vander Change SUCCESS(S/O)
	
	public static final String SCE_NO_DATA = "96"; //Vander Change SUCCESS(S/O)
	
	public static final String SCE_CHG_SUCCESS_RESULT_CD = "00000000"; //Replan Success Result Code(S/O)
	public static final String SCE_SO_CALL_COA_TP_CD = "UC"; // COA 호출시 사용되는 TYPE CODE
	
	public static final String SCE_REPLAN_ERROR_ALL = "40"; // Replan Error(ALL Replan Error)
	public static final String SCE_REPLAN_ERROR_PART = "41"; // Replan Error(Pard Replan Error)
	public static final String SCE_REPLAN_ERROR_ALL_UNMATCH = "50"; // Replan Error(ALL Unmatch )
	public static final String SCE_REPLAN_ERROR_PART_UNMATCH = "51"; // Replan Error(part Unmatch )
	public static final String SCE_REPLAN_ERROR_MIXED = "60"; // Replan Error(part Unmatch / part Replan Error )
	public static final String SCE_REPLAN_ERROR_SUCCESS = "99"; // Replan Success(ALL)
	
	public static final String SCE_ACT_MOVEMENT_VALUE = "1"; // Actual Movement Data
	public static final String SCE_ACT_322_VALUE = "3"; // Actual 322 Data	
	
	public static final String TB_SCE_SO_IF = "1"; //
	public static final String TB_SCE_TRO_IF = "2"; //
	public static final String TB_SCE_BKG_IF = "3"; //
	public static final String TB_SCE_CLM_IF = "4"; //
	public static final String TB_SCE_VPS_IF = "5"; //
	public static final String TB_SCE_ACT_RCV_IF = "6";// actRcv (Batch Name)
	
	//master flag 이동 시 오류
	public static final int MST_CNTR_NO_ERROR = -1; 
	public static final int MST_COP_NO_ERROR = -2;
	public static final int MST_ORDINARY = 0;
	public static final int MST_SUCCESS = 1;
	public static final int MST_FAIL = -3;
	
	// PRD_BKG_COP_MAP 의 COP_OP_TP_CD
	// 
	// C CREATION
	// X CANCEL
	// N NO CHANGE
	// P PRD CHANGE
	// B BKG NO CHANGE
	public static final String CREATION_FRM_MAP = "C";
	public static final String CANCEL_FRM_MAP = "X";
	public static final String NO_CHANGE_FRM_MAP = "N";
	public static final String PRD_CHANGE_FRM_MAP = "P";
	public static final String BKG_NO_CHANGE_FRM_MAP = "B";
	public static final String PSEUDO_VVD_UPDATE_FRM_MAP = "V";
	public static final String PC_CREATE_FAIL_FRM_MAP = "F";
	public static final String SO_CANDIDATE_DELETED = "N";
	
	// BKG_EVNT_TP_CD 정의
	public static final String CONTAINER_ATTACH = "CA";
	public static final String CONTAINER_DETACH = "CD";
	
	// TRSP_SO_STS_CD 정의
	public static final String SO_CREATION = "C";
	public static final String SO_CORRECTED = "R";
	public static final String WO_ISSUED = "I";
	public static final String SO_DELETE_BY_BKG = "D";
	public static final String SO_DELETE_BY_TRS_OWN = "P";
	public static final String SO_PLANNED = "P";
	public static final String SO_FRUSTRATED = "F";
	
	// COP_STS_CD 정의
	public static final String COP_CANCELED = "X";
	public static final String COP_CREATED = "C";
	public static final String COP_IN_TRANSIT = "T";
}	

