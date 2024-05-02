/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ApprovalDBDAOSearchAuthAproInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOSearchAuthAproInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Authorization Approval 목록 조회
	  * </pre>
	  */
	public ApprovalDBDAOSearchAuthAproInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apsts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xls_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd_auth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_sys_cd_auth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sdate_auth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edate_auth",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOSearchAuthAproInquiryRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("Q.AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append(", P.SUB_SYS_CD " ).append("\n"); 
		query.append(", P.PGM_NO" ).append("\n"); 
		query.append(", C.PGM_NM" ).append("\n"); 
		query.append(", B.AUTH_APRO_TP_CD" ).append("\n"); 
		query.append(", (SELECT CD.INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("   FROM COM_INTG_CD_DTL CD " ).append("\n"); 
		query.append("   WHERE CD.INTG_CD_ID='CD03436' AND CD.INTG_CD_VAL_CTNT = B.AUTH_APRO_TP_CD AND ROWNUM=1) AUTH_APRO_TP_NM" ).append("\n"); 
		query.append(", TO_CHAR(Q.RQST_ST_DT,'YYYY-MM-DD HH24:MI') RQST_ST_DT" ).append("\n"); 
		query.append(", Q.RQST_USR_ID" ).append("\n"); 
		query.append(", (SELECT U.USR_NM FROM COM_USER U" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND Q.RQST_USR_ID = U.USR_ID" ).append("\n"); 
		query.append("    ) RQST_USR_NM" ).append("\n"); 
		query.append(", Q.RQST_OFC_CD" ).append("\n"); 
		query.append(", R.AUTH_APRO_RMK" ).append("\n"); 
		query.append(", CASE " ).append("\n"); 
		query.append("  WHEN R.AUTH_APSTS_CD = 'C'" ).append("\n"); 
		query.append("  THEN DECODE(B.AUTH_APRO_TP_CD,'AF','Confirmed','BF','Approved')" ).append("\n"); 
		query.append("  WHEN R.AUTH_APSTS_CD = 'R'" ).append("\n"); 
		query.append("  THEN 'Disapproved'" ).append("\n"); 
		query.append("  ELSE 'Requested'" ).append("\n"); 
		query.append("  END APRO_RSLT" ).append("\n"); 
		query.append(", TO_CHAR(R.AUTH_APRO_DT,'YYYY-MM-DD HH24:MI') AUTH_APRO_DT" ).append("\n"); 
		query.append(", R.AUTH_APRO_USR_ID" ).append("\n"); 
		query.append(", (SELECT U.USR_NM FROM COM_USER U" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND R.AUTH_APRO_USR_ID = U.USR_ID" ).append("\n"); 
		query.append("    ) AUTH_APRO_USR_NM" ).append("\n"); 
		query.append(", B.DTL_PGM_URL_CTNT" ).append("\n"); 
		query.append(", DECODE(B.PGM_BTN_ID, 'EXCEL_DOWN_DUMMY', 'Y', '') AS XLS_FLG" ).append("\n"); 
		query.append(", DECODE(Q.CXL_FLG,'Y','Cancelled','') CXL_FLG" ).append("\n"); 
		query.append("FROM COM_AUTH_APRO_RQST Q, COM_AUTH_PGM_BTN B, COM_AUTH_PGM P, COM_PROGRAM C, COM_AUTH_APRO_RQST_ROUT R" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(Q.CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND NVL(Q.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND Q.AUTH_PGM_BTN_SEQ = B.AUTH_PGM_BTN_SEQ" ).append("\n"); 
		query.append("AND B.AUTH_PGM_SEQ = P.AUTH_PGM_SEQ" ).append("\n"); 
		query.append("AND P.PGM_NO = C.PGM_NO" ).append("\n"); 
		query.append("AND DECODE(@[auth_apsts_cd],NULL,'ALL','','ALL','ALL','ALL',Q.AUTH_APSTS_CD) = DECODE(@[auth_apsts_cd],NULL,'ALL','','ALL','ALL','ALL',@[auth_apsts_cd]) --'P'" ).append("\n"); 
		query.append("AND DECODE(@[sub_sys_cd_auth],NULL,'ALL','','ALL','ALL','ALL',P.SUB_SYS_CD) = DECODE(@[sub_sys_cd_auth],NULL,'ALL','','ALL','ALL','ALL',@[sub_sys_cd_auth]) " ).append("\n"); 
		query.append("AND DECODE(@[pgm_no],NULL,'ALL','','ALL','ALL','ALL',P.PGM_NO) = DECODE(@[pgm_no],NULL,'ALL','','ALL','ALL','ALL',@[pgm_no]) " ).append("\n"); 
		query.append("AND DECODE(@[auth_apro_tp_cd],NULL,'ALL','','ALL','ALL','ALL',B.AUTH_APRO_TP_CD) = DECODE(@[auth_apro_tp_cd],NULL,'ALL','','ALL','ALL','ALL',@[auth_apro_tp_cd]) --'AF'" ).append("\n"); 
		query.append("AND DECODE(@[xls_flg],NULL,'ALL','','ALL','ALL','ALL',DECODE(B.PGM_BTN_ID,'EXCEL_DOWN_DUMMY','Y','N')) = DECODE(@[xls_flg],NULL,'ALL','','ALL','ALL','ALL',@[xls_flg])" ).append("\n"); 
		query.append("AND NVL(P.USE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND NVL(C.USE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND NVL(R.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND Q.AUTH_APRO_RQST_NO = R.AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append("AND Q.CRNT_AUTH_APRO_RQST_SEQ = R.AUTH_APRO_RQST_ROUT_SEQ" ).append("\n"); 
		query.append("AND Q.RQST_OFC_CD IN ( SELECT X.SUB_OFC_CD" ).append("\n"); 
		query.append("                         FROM (SELECT DISTINCT LL.OFC_CD AS SUB_OFC_CD    " ).append("\n"); 
		query.append("                                 FROM MAS_OFC_LVL LL    " ).append("\n"); 
		query.append("                                WHERE 1 = 1    " ).append("\n"); 
		query.append("                                  AND CASE (SELECT OFC_LVL    " ).append("\n"); 
		query.append("                                              FROM (SELECT L.OFC_LVL    " ).append("\n"); 
		query.append("                                                      FROM MAS_OFC_LVL L    " ).append("\n"); 
		query.append("                                                     WHERE L.OFC_N3RD_LVL_CD IS NOT NULL    " ).append("\n"); 
		query.append("                                                       AND L.OFC_N5TH_LVL_CD IS NOT NULL    " ).append("\n"); 
		query.append("                                                       AND L.OFC_CD = @[ofc_cd_auth] -- LOGIN-OFFICE CODE BINDING  " ).append("\n"); 
		query.append("                                                     ORDER BY L.OFC_APLY_TO_YRMON DESC )    " ).append("\n"); 
		query.append("                                              WHERE ROWNUM = 1 )    " ).append("\n"); 
		query.append("                                            WHEN '1' THEN 'XXXXX'    " ).append("\n"); 
		query.append("                                            WHEN '2' THEN 'XXXXX'    " ).append("\n"); 
		query.append("                                            WHEN '3' THEN 'XXXXX'    " ).append("\n"); 
		query.append("                                            WHEN '4' THEN LL.OFC_N5TH_LVL_CD    " ).append("\n"); 
		query.append("                                            WHEN '5' THEN LL.OFC_N5TH_LVL_CD    " ).append("\n"); 
		query.append("                                            WHEN '6' THEN LL.OFC_N5TH_LVL_CD    " ).append("\n"); 
		query.append("                                            WHEN '7' THEN LL.OFC_N5TH_LVL_CD    " ).append("\n"); 
		query.append("                                            WHEN '9' THEN 'XXXXX'    " ).append("\n"); 
		query.append("                                            ELSE 'XXXXX'    " ).append("\n"); 
		query.append("                                        END = @[ofc_cd_auth] -- LOGIN-OFFICE CODE BINDING     " ).append("\n"); 
		query.append("                                     OR LL.OFC_CD = @[ofc_cd_auth] --  LOGIN-OFFICE CODE BINDING     " ).append("\n"); 
		query.append("                         ) X" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#if (${sdate_auth} != '')" ).append("\n"); 
		query.append("AND TO_CHAR(Q.RQST_ST_DT, 'YYYY-MM-DD') >= @[sdate_auth]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${edate_auth} != '')" ).append("\n"); 
		query.append("AND TO_CHAR(Q.RQST_ST_DT, 'YYYY-MM-DD') <= @[edate_auth]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY Q.RQST_ST_DT DESC" ).append("\n"); 

	}
}