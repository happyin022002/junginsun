/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmEdiSendDBDAOSearchEdiMsgToUsCaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmEdiSendDBDAOSearchEdiMsgToUsCaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1. 오늘시점에서 ETA-1 = 오늘인 VVD의 bkg중에 미주(US,CA) POD 인것 조회 (최초)
	  * 2. 1번 조건을 만족한 BKG - CNTR 로 F/F 에 입력할 정보를 추출
	  * </pre>
	  */
	public CgmEdiSendDBDAOSearchEdiMsgToUsCaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chz_except",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ie_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chz_except_days",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("final_ind",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration").append("\n"); 
		query.append("FileName : CgmEdiSendDBDAOSearchEdiMsgToUsCaRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT (" ).append("\n"); 
		query.append("           SELECT CASE WHEN COUNT(1) > 0 THEN 'U' " ).append("\n"); 
		query.append("                                         ELSE 'O' " ).append("\n"); 
		query.append("                  END STATUS " ).append("\n"); 
		query.append("           FROM CGM_CHSS_EXPT_EDI_HIS " ).append("\n"); 
		query.append("           WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("           AND   CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("       ) BRAC" ).append("\n"); 
		query.append("      ,A.BKG_NO BKGNBR" ).append("\n"); 
		query.append("      ,A.BL_NO  BLNBR" ).append("\n"); 
		query.append("      ,@[ie_ind]     IE_IND " ).append("\n"); 
		query.append("      ,A.RCV_TERM_CD||A.DE_TERM_CD RDTYP " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,@[chz_except]    CHZ_EXCEPT   --EDI 추출 - EXCEPTION 결정에서 추출" ).append("\n"); 
		query.append("      ,@[chz_except_days]  CHZ_EXCEPT_DAYS --EDI 추출 - FREE DAY 결정에서 추출" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,@[final_ind] FINAL_IND   " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- VVD" ).append("\n"); 
		query.append("      ,A.VSL_CD       VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO   SKD_VOY" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD   SKD_DIR" ).append("\n"); 
		query.append("      ,(SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = A.VSL_CD AND ROWNUM=1) VSL_NAME" ).append("\n"); 
		query.append("      ,(SELECT LLOYD_NO   FROM MDM_VSL_CNTR WHERE VSL_CD = A.VSL_CD AND ROWNUM=1) VSL_LLOYD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- POR " ).append("\n"); 
		query.append("      ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.POR_CD AND ROWNUM=1)     POR_NAME" ).append("\n"); 
		query.append("      ,(SELECT DECODE(LENGTH(LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ') FROM MDM_LOCATION WHERE LOC_CD = A.POR_CD AND ROWNUM=1)     POR_AMSQUAL      " ).append("\n"); 
		query.append("      ,(SELECT LOC_AMS_PORT_CD FROM MDM_LOCATION WHERE LOC_CD = A.POR_CD AND ROWNUM=1)     POR_AMSPORT" ).append("\n"); 
		query.append("      ,A.POR_CD     POR_UNLC" ).append("\n"); 
		query.append("      ,A.POR_NOD_CD POR_YDCD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- POL " ).append("\n"); 
		query.append("      ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.POL_CD AND ROWNUM=1)     POL_NAME" ).append("\n"); 
		query.append("      ,(SELECT DECODE(LENGTH(LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ') FROM MDM_LOCATION WHERE LOC_CD = A.POL_CD AND ROWNUM=1)     POL_AMSQUAL      " ).append("\n"); 
		query.append("      ,(SELECT LOC_AMS_PORT_CD FROM MDM_LOCATION WHERE LOC_CD = A.POL_CD AND ROWNUM=1)     POL_AMSPORT" ).append("\n"); 
		query.append("      ,A.POL_CD     POL_UNLC" ).append("\n"); 
		query.append("      ,A.POL_NOD_CD POL_YDCD  " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- POL " ).append("\n"); 
		query.append("      ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.POL_CD AND ROWNUM=1)     POL_NAME" ).append("\n"); 
		query.append("      ,(SELECT DECODE(LENGTH(LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ') FROM MDM_LOCATION WHERE LOC_CD = A.POL_CD AND ROWNUM=1)     POL_AMSQUAL      " ).append("\n"); 
		query.append("      ,(SELECT LOC_AMS_PORT_CD FROM MDM_LOCATION WHERE LOC_CD = A.POL_CD AND ROWNUM=1)     POL_AMSPORT" ).append("\n"); 
		query.append("      ,A.POL_CD     POL_UNLC" ).append("\n"); 
		query.append("      ,A.POL_NOD_CD POL_YDCD    " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- POD " ).append("\n"); 
		query.append("      ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.POD_CD AND ROWNUM=1)     POD_NAME" ).append("\n"); 
		query.append("      ,(SELECT DECODE(LENGTH(LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ') FROM MDM_LOCATION WHERE LOC_CD = A.POD_CD AND ROWNUM=1)     POD_AMSQUAL      " ).append("\n"); 
		query.append("      ,(SELECT LOC_AMS_PORT_CD FROM MDM_LOCATION WHERE LOC_CD = A.POD_CD AND ROWNUM=1)     POD_AMSPORT" ).append("\n"); 
		query.append("      ,A.POD_CD     POD_UNLC" ).append("\n"); 
		query.append("      ,A.POD_NOD_CD POD_YDCD   " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- DEL " ).append("\n"); 
		query.append("      ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.DEL_CD AND ROWNUM=1)     DEL_NAME" ).append("\n"); 
		query.append("      ,(SELECT DECODE(LENGTH(LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ') FROM MDM_LOCATION WHERE LOC_CD = A.DEL_CD AND ROWNUM=1)     DEL_AMSQUAL      " ).append("\n"); 
		query.append("      ,(SELECT LOC_AMS_PORT_CD FROM MDM_LOCATION WHERE LOC_CD = A.DEL_CD AND ROWNUM=1)     DEL_AMSPORT" ).append("\n"); 
		query.append("      ,A.DEL_CD     DEL_UNLC" ).append("\n"); 
		query.append("      ,A.DEL_NOD_CD DEL_YDCD   " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- TOTAL WEIGHT" ).append("\n"); 
		query.append("      ,(SELECT CNTR_MF_WGT FROM BKG_CNTR_MF_DESC WHERE BKG_NO  = @[bkg_no] AND   CNTR_NO = @[cntr_no] AND ROWNUM=1) TWGT" ).append("\n"); 
		query.append("      ,(SELECT WGT_UT_CD   FROM BKG_CNTR_MF_DESC WHERE BKG_NO  = @[bkg_no] AND   CNTR_NO = @[cntr_no] AND ROWNUM=1) TWUNIT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- INDICATOR" ).append("\n"); 
		query.append("      ,DECODE(A.BKG_CGO_TP_CD, 'F', 'F', 'P', 'M', A.BKG_CGO_TP_CD) FM_IND" ).append("\n"); 
		query.append("      ,A.RD_CGO_FLG  RF_IND" ).append("\n"); 
		query.append("      ,A.DCGO_FLG    DG_IND" ).append("\n"); 
		query.append("      ,A.AWK_CGO_FLG AK_IND" ).append("\n"); 
		query.append("      ,A.BB_CGO_FLG  BK_IND" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- CNTR INFO" ).append("\n"); 
		query.append("      ,@[cntr_no] CNTRNBR" ).append("\n"); 
		query.append("      ,(SELECT CNTR_TPSZ_CD FROM MST_CONTAINER WHERE CNTR_NO = @[cntr_no] AND ROWNUM=1) CNTRTYPE" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("			SELECT                " ).append("\n"); 
		query.append("                ROUND(TO_NUMBER(CNTR_GRS_WGT) * 2.2046,0) TARE_WGT_LBS -- LBS 환산" ).append("\n"); 
		query.append("			FROM " ).append("\n"); 
		query.append("				MST_CNTR_SPEC B, " ).append("\n"); 
		query.append("				MST_CONTAINER C " ).append("\n"); 
		query.append("			WHERE 1 = 1" ).append("\n"); 
		query.append("			AND   C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("			AND   C.CNTR_SPEC_NO = B.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("            AND   ROWNUM=1" ).append("\n"); 
		query.append("       ) CNTR_TOTAL_WGT" ).append("\n"); 
		query.append("      ,'LBS'  CNTR_TOTAL_WGT_UNIT  -- 하드코딩" ).append("\n"); 
		query.append("      -- SEAL NO" ).append("\n"); 
		query.append("      ,(SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO  = @[bkg_no] AND   CNTR_NO = @[cntr_no] AND ROWNUM=1) SEAL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_BOOKING  A" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}