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
* 2011.09.19 변종건 [CHM-201113069-01] Ocean Route Management상의 Auto & Multi Creation 화면 관련 변경사항
* 2012.05.31 박만건 [CHM-201217633] 구주 Hinterland
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common;

/**
 * alps-PRD Constant<br>
 * - alps-PRD에서 사용하는 공통 상수 .<br>
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
	
	
	//cop_gubun : A(uto), M(enual), O(cean), H(it hub)
	public static final String PRD_COP_UPDATE_AUTO   = "A"; 
	public static final String PRD_COP_UPDATE_MENUAL = "M"; 
	public static final String PRD_COP_UPDATE_OCEAN  = "O"; 
	public static final String PRD_COP_UPDATE_IT_HUB  = "H";
	

	public static final String PRD_REPLAN_CHK_CD_E0000 = "E0000"; //replan 가능  
	public static final String PRD_REPLAN_CHK_CD_E0006 = "E0006"; //replan CNTR QTY 체크   
	
	public static final String PRD_REPLAN_QTY_CHK_RESULT_OK = "OK"; //replan CNTR QTY 체크   OK
	public static final String PRD_REPLAN_QTY_CHK_RESULT_REJECT = "REJECT"; //replan CNTR QTY 체크   REJECT
	public static final String PRD_COMBINE_CHK_RESULT_OK = "Y"; //replan CNTR QTY 체크   OK
	
	public static final String PRD_COST_CHK_RESULT_SUCCESS = "Y"; //
	public static final String PRD_COST_CHK_RESULT_FAIL = "N"; //
	public static final String PRD_COST_CHK_RESULT_TIMEOUT = "T"; //
	
	
	
	public static final String PRD_ERR018_CONTACT_SHARHQ = "SELPIA/J.H Kim"; //
	public static final String PRD_ERR018_CONTACT_HAMUR = "SELPIA/J.H Kim"; //
	public static final String PRD_ERR018_CONTACT_NYCNA = "SELPIA/J.H Kim"; //  
	
	public static final String PRD_ERR026_CONTACT_SHARHQ = "SHARCO / Shiy Wu and Lucy Yan"; //
	public static final String PRD_ERR026_CONTACT_HAMUR = "HAMRU/P.Michael Reuther & Yolanda Dubra-Bello"; //
	public static final String PRD_ERR026_CONTACT_NYCNA = "NYCRA/Heaja Chung"; //

	public static final String PRD_ERR027_CONTACT_SHARHQ = "SHARCO / Shiy Wu and Lucy Yan"; //
	public static final String PRD_ERR027_CONTACT_HAMUR = "HAMRU/P.Michael Reuther & Yolanda Dubra-Bello"; //
	public static final String PRD_ERR027_CONTACT_NYCNA = "NYCRA/Heaja Chung"; //

	public static final String PRD_ERR028_CONTACT_SHARHQ = "SELPIA/J.H Kim"; //
	public static final String PRD_ERR028_CONTACT_HAMUR = "SELPIA/J.H Kim"; //
	public static final String PRD_ERR028_CONTACT_NYCNA = "SELPIA/J.H Kim"; //
	
	public static final String PRD_ERR029_CONTACT_SHARHQ = "SELPIA/K.S Park"; //
	public static final String PRD_ERR029_CONTACT_HAMUR = "SELPIA/K.S Park"; //
	public static final String PRD_ERR029_CONTACT_NYCNA = "SELPIA/K.S Park"; //	

	public static final String PRD_ERR030_CONTACT_SHARHQ = "SHARCO/Lucy Yan and Maggie Zhang"; //
	public static final String PRD_ERR030_CONTACT_HAMUR = "HAMRU/P.Michael Reuther & Yolanda Dubra-Bello"; //
	public static final String PRD_ERR030_CONTACT_NYCNA = "NYCRA/Charles Smith"; //	
	
	public static final String PRD_ERR031_CONTACT_SHARHQ = "SHARCO/Lucy Yan and James Wang"; //
	public static final String PRD_ERR031_CONTACT_HAMUR = "HAMRU/P.Michael Reuther & Yolanda Dubra-Bello"; //
	public static final String PRD_ERR031_CONTACT_NYCNA = "NYCRA/James Kamm"; //		

	public static final String PRD_ERR032_CONTACT_SHARHQ = "SHARCO/Lucy Yan and Maggie Zhang"; //
	public static final String PRD_ERR032_CONTACT_HAMUR = "HAMRU/P.Michael Reuther & Yolanda Dubra-Bello"; //
	public static final String PRD_ERR032_CONTACT_NYCNA = "NYCRA/Charles Smith"; //
	
	public static final String PRD_ERR033_CONTACT_SHARHQ = "SHARCO/Lucy Yan and Maggie Zhang"; //
	public static final String PRD_ERR033_CONTACT_HAMUR = "HAMRU/P.Michael Reuther & Yolanda Dubra-Bello"; //
	public static final String PRD_ERR033_CONTACT_NYCNA = "NYCRA/Charles Smith"; //
	
	public static final String PRD_ERR041_CONTACT_SHARHQ = "SELPIA/K.S Park"; //
	public static final String PRD_ERR041_CONTACT_HAMUR = "SELPIA/K.S Park"; //
	public static final String PRD_ERR041_CONTACT_NYCNA = "SELPIA/K.S Park"; //
	
	public static final String PRD_ERR042_CONTACT_SHARHQ = "SHARCO/Lucy Yan and James Wang"; //
	public static final String PRD_ERR042_CONTACT_HAMUR = "HAMRU/P.Michael Reuther & Yolanda Dubra-Bello"; //
	public static final String PRD_ERR042_CONTACT_NYCNA = "NYCRA/James Kamm"; //

	/*
	 * AUTO PRD 관련 
	 */
	public static final String AUTO_PRD_1 = "1"; //
	public static final String AUTO_PRD_2 = "2"; //
	
	/*
	 * 상세 에러 메세지 관련 
	 */
	
	public static final String PRD_ERR_MSG_S01 = "The terminal and the lane was not matched or not registered on terminal matrix mamagement.\n Please check the Carrier code, Lane, Bound, Terminal on terminal matrix mamagement."; //
	public static final String PRD_ERR_MSG_S02 = "The vessel code to be inputted have 'Deleted' Flag in MDM table.\n Please contact to MDM stewards in your RHQ."; //
	public static final String PRD_ERR_MSG_S03 = "Could not connect each link's Vessel Skd based on Vessel Code on booking."; //
	public static final String PRD_ERR_MSG_S04 = "Could not connect each link's Vessel Skd based on Sailing Date on booking."; //
	public static final String PRD_ERR_MSG_S05 = "Please check Vessel Information such like Status, Use Indicatior."; //
	public static final String PRD_ERR_MSG_S06 = "Route Count Check."; //
	public static final String PRD_ERR_MSG_S07 = "Please check VVD & Route."; //
	public static final String PRD_ERR_MSG_S08 = "Please check Loc cd in VVD."; //
	public static final String PRD_ERR_MSG_S09 = "Please check T/S Lane in VVD"; //
	public static final String PRD_ERR_MSG_S10 = "Vvd not found "; //
	public static final String PRD_ERR_MSG_S11 = "There is no information for berthing weekdays in RHQ Ocn Link.";
	public static final String PRD_PC_MOD_BASIC = "B";
	public static final String PRD_PC_MOD_COPY_VVD_UNCHANGE = "Y";
	public static final String PRD_PC_MOD_SPLIT_VVD_UNCHANGE = "S";
	public static final String PRD_PC_MOD_REPLAN = "R";
	public static final String PRD_PC_MOD_SCE_SO_REPLAN = "G"; //cop change
	public static final String PRD_PC_MOD_HINTERLAND = "H"; // 구주 Hinterland를 위해 추가 (Inland)
	public static final String PRD_PC_MOD_HINTER_FDR = "F"; // 구주 Hinterland를 위해 추가 (Feeder)
	public static final String PRD_PC_MOD_WEB = "W"; // HOME Page 에서 Bkg 생성용 추가 
	
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
	public static final String PRD_USRRMK_ADDCALL   = "Add Call";
	
}
