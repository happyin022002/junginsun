/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PrdConstants.java
*@FileTitle : PRD 공통관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-16
*@LastModifier : jungsunyoung
*@LastVersion : 1.0
* 2006-10-16 jungsunyoung
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.common;

/**
 * PRD Constant<br>
 * PRD에서 사용하는 공통 상수 .<br>
 * 
 * @author jungsunyoung
 * @see  
 * @since J2EE 1.4
 */
public interface PrdConstants  {

	//pc _mod :  B R U T
	public static final String PRD_PC_MOD_B = "B"; //bkg 
	public static final String PRD_PC_MOD_R = "R"; //replan
	public static final String PRD_PC_MOD_C = "G"; //cop change
	public static final String PRD_PC_MOD_I = "I"; //tro in
	public static final String PRD_PC_MOD_O = "O"; //tro out
	public static final String PRD_PC_MOD_P = "P"; //Pricing
	public static final String PRD_PC_MOD_T = "T"; //Internal
	public static final String PRD_PC_MOD_Q = "Q"; //QTY REPLAN
	public static final String PRD_PC_MOD_S = "S"; //BKG Split
	public static final String PRD_PC_MOD_M = "M"; //BKG Combine
	public static final String PRD_PC_MOD_N = "N"; //BKG Combine
	public static final String PRD_PC_MOD_X = "X"; //BKG Mixed
	
	public static final String PRD_REPLAN_CHK_CD_E0000 = "E0000"; //replan 가능  
	public static final String PRD_REPLAN_CHK_CD_E0006 = "E0006"; //replan CNTR QTY 체크   
	
	public static final String PRD_REPLAN_QTY_CHK_RESULT_OK = "OK"; //replan CNTR QTY 체크   OK
	public static final String PRD_REPLAN_QTY_CHK_RESULT_REJECT = "REJECT"; //replan CNTR QTY 체크   REJECT
	public static final String PRD_COMBINE_CHK_RESULT_OK = "Y"; //replan CNTR QTY 체크   OK	


	public static final String PRD_PC_MOD_BASIC = "B";
	public static final String PRD_PC_MOD_COPY_VVD_UNCHANGE = "Y";
	public static final String PRD_PC_MOD_SPLIT_VVD_UNCHANGE = "S";
	public static final String PRD_PC_MOD_REPLAN = "R";
	public static final String PRD_PC_MOD_SCE_SO_REPLAN = "G"; //cop change
	
	/*
	 * Ocean Route User Remark 관련
	 */
	public static final String PRD_USRRMK_SPACE    = "Space Shortage";
	public static final String PRD_USRRMK_CUSTOMER = "Customer Request";
	public static final String PRD_USRRMK_PORTSKIP = "Port Skip";
	public static final String PRD_USRRMK_VSLOUT   = "VSL Phase Out";
	public static final String PRD_USRRMK_CUSTOMS  = "Customs Problem";
	public static final String PRD_USRRMK_CLERICAL = "Clerical Error";
	public static final String PRD_USRRMK_OTHERS   = "The Others";
	
}
