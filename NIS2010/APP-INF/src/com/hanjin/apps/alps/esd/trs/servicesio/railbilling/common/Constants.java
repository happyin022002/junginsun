/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Constants.java
*@FileTitle : Constants 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.RailBillingIWSProxy;

/**
 * WebService 정적변수 선언<br>
 * - RailBillingIWSProxy의 정적변수 선언<br>
 * - RailBillingIWSProxy에서 정적변수 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @version 1.0
 * @since J2EE 1.4
 */
public interface Constants {
	
	public static final String 	EMPTY 						= "";
	public static final String 	YES 						= "Y";
	public static final String 	NO 							= "N";
	public static final char 	CHAR_DATE 					= '-';
	
	public static final String 	PROC_SUCCESS 				= "SUCCESS";
	
	public static final boolean IS_LOCAL_SVR 				= false;
	
	
	// PAGE_SIZE
	public static final int 	POPUP_PAGE_SIZE				= 100;
	public static final int 	PAGE_SIZE_50    			= 50;
	public static final int 	PAGE_SIZE_100   			= 100;
    public static final int 	NORMAL_PAGE_SIZE			= 100;
    
    // Special Cargo
    public static final String 	SPEC_CARGO_BB 				= "BB";
    public static final String 	SPEC_CARGO_HD 				= "HD";
    public static final String 	SPEC_CARGO_RF 				= "RF";
    public static final String 	SPEC_CARGO_RD 				= "RD";
    public static final String 	SPEC_CARGO_DG 				= "DG";
    public static final String 	SPEC_CARGO_AK 				= "AK";
    public static final String 	SPEC_CARGO_SC 				= "SC";
    public static final String 	SPEC_CARGO_RB 				= "RB";
    
    // Cargo Type
    public static final String 	CARGO_TYPE_FULL 			= "F";
    public static final String 	CARGO_TYPE_EMPTY			= "M";
    
    // Verify Proc Mode
    public static final String 	VRFY_PROC_REQ   			= "0";
    public static final String 	VRFY_PROC_RE_REQ			= "1";
    
    // Rail Billing Verify Code
    public static final String 	VRFY_GOOD_NM   				= "GOOD"		;
    public static final String 	VRFY_NOGOOD_NM 				= "NOGOOD"		;
    public static final String 	VRFY_NOWRS_NM  				= "NOWRS"		;
    public static final String	VRFY_NOBILLING_NM			= "NOBILLING"	;	//2008.09.15 추가
        
    public static final String 	VRFY_GOOD   				= "0"			;
    public static final String 	VRFY_NOGOOD 				= "1"			;
    public static final String 	VRFY_NOWRS  				= "2"			;
    public static final String	VRFY_NOBILLING				= "3"			;	//2008.09.15 추가
    
    // Verify Error Type Code
    public static final String 	VRFY_TYPE_GOOD  			= "G";
    public static final String 	VRFY_TYPE_NOGOOD  			= "W";
    public static final String 	VRFY_TYPE_NOWRS  			= "E";
    public static final String 	VRFY_TYPE_NOBILLING  		= "I";
    
    // Booking Split Status
    public static final String 	BKG_STS_CXL    				= "X";
    public static final String 	BKG_STS_SPLIT  				= "S";
	
    // Booking Standby Status
    public static final String 	BKG_ALOC_STS_FIRM    		= "F";
    public static final String 	BKG_ALOC_STS_STBY  			= "S";
    
    // Booking No Rate Status
    public static final String 	BKG_NO_RATE_STS    			= "R";
    
	// Rail Billing Inquiry 조회구분
	public static final String 	SEARCH_REQ_DT    			= "1";
	public static final String 	SEARCH_BKG_CNTL  			= "2";
	
	// Rail Billing Inquiry Status
	public static final String 	RB_INQ_REQ         	 		= "1"; // Requested
	public static final String 	RB_INQ_REQ_CXL     	 		= "2"; // Requested Cancelled
	public static final String 	RB_INQ_BILLED      	 		= "3"; // Rail Billed
	public static final String 	RB_INQ_BILLED_CXL  	 		= "4"; // Rail Billed Cancelled
	public static final String 	RB_INQ_ACK         	 		= "5"; // Acknowledged
	public static final String 	RB_INQ_CXL_REQ     	 		= "6"; // Cancellation Requested
	public static final String 	RB_INQ_CXL_REQ_RJT 	 		= "7"; // Cancellation Request Rejected
	public static final String 	RB_INQ_EDI_ERROR   	 		= "8"; // EDI Error
	public static final String 	RB_INQ_BILLED_DLT  	 		= "9"; // Rail Billing Deleted
	public static final String 	RB_INQ_BILLED_CXL_DLT 		= "10"; // Rail Billing Cancelled & Deleted
	
	// IRG Auto Adjust 관련 
	public static final String 	PRD_MST_PCTL_IO_BND_CD_M	= "M";  // prd_inland_rout_mst.pctl_io_bnd_cd가  Empty 인 경우
	
	// almighty 계정 구분 추가
	public static final String 	USER_ROLE_ALMIGHTY 			= "1";
	
	
	// 메시지
	public static final String 	UNHANDLED_EXPT_MSG 			= "UnHandled Exception Error.";
	public static final String 	DBMS_ERROR_MSG     			= "DBMS Error Occured from Oracle";
	public static final String 	INVALID_CONTAINER_MSG   	= "Invalid Container Number, Please Check";
}
