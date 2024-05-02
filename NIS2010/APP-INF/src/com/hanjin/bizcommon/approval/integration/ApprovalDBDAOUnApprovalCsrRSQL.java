/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ApprovalDBDAOUnApprovalCsrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.29
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.29 
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

public class ApprovalDBDAOUnApprovalCsrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ApprovalDBDAOUnApprovalCsrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOUnApprovalCsrRSQL").append("\n"); 
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
		query.append("SELECT  	  APRO_RQST_NO" ).append("\n"); 
		query.append("			, CRNT_APRO_SEQ" ).append("\n"); 
		query.append("			, APSTS_CD" ).append("\n"); 
		query.append("			, SUB_SYS_CD" ).append("\n"); 
		query.append("			, GL_DT" ).append("\n"); 
		query.append("			, RQST_ST_DT" ).append("\n"); 
		query.append("			, CSR_NO" ).append("\n"); 
		query.append("			, INV_DT" ).append("\n"); 
		query.append("			, INV_KNT" ).append("\n"); 
		query.append("			, VNDR_SEQ" ).append("\n"); 
		query.append("			, PAY_DUE_DT" ).append("\n"); 
		query.append("			, CURR_CD" ).append("\n"); 
		query.append("			, APRO_TTL_AMT" ).append("\n"); 
		query.append("			, ASA_AMT" ).append("\n"); 
		query.append("			, COST_OFC_CD" ).append("\n"); 
		query.append("			, APRO_OFC_CD" ).append("\n"); 
		query.append("			, APRO_USR_ID" ).append("\n"); 
		query.append("			, APRO_USR_NM" ).append("\n"); 
		query.append("			, APPYN" ).append("\n"); 
		query.append("			, APRO_RMK" ).append("\n"); 
		query.append("			, CRE_DT" ).append("\n"); 
		query.append("			, CRE_USR_ID" ).append("\n"); 
		query.append("			, USR_NM" ).append("\n"); 
		query.append("			, AR_HD_QTR_OFC_CD  " ).append("\n"); 
		query.append("			, OFC_CD" ).append("\n"); 
		query.append("			, INV_EFF_DT" ).append("\n"); 
		query.append("			, OFC_NM" ).append("\n"); 
		query.append("			, AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("			, AGMT_FILE_CFM_CD" ).append("\n"); 
		query.append("			, FILE_UPLD_FLG" ).append("\n"); 
		query.append("			, ASA_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  	T.APRO_RQST_NO" ).append("\n"); 
		query.append("			, T.CRNT_APRO_SEQ" ).append("\n"); 
		query.append("			, T.APSTS_CD" ).append("\n"); 
		query.append("			, T.SUB_SYS_CD" ).append("\n"); 
		query.append("			, T.GL_DT" ).append("\n"); 
		query.append("			, T.RQST_ST_DT" ).append("\n"); 
		query.append("			, T.CSR_NO" ).append("\n"); 
		query.append("			, T.INV_DT" ).append("\n"); 
		query.append("			, T.INV_KNT" ).append("\n"); 
		query.append("			, T.VNDR_SEQ" ).append("\n"); 
		query.append("			, T.PAY_DUE_DT" ).append("\n"); 
		query.append("			, T.CURR_CD" ).append("\n"); 
		query.append("			, T.APRO_TTL_AMT" ).append("\n"); 
		query.append("			, DECODE(T.APRO_TTL_AMT,0,T.ASA_AMT,0) ASA_AMT" ).append("\n"); 
		query.append("			, T.COST_OFC_CD" ).append("\n"); 
		query.append("			, T.APRO_OFC_CD" ).append("\n"); 
		query.append("			, T.APRO_USR_ID" ).append("\n"); 
		query.append("			, T.APRO_USR_NM" ).append("\n"); 
		query.append("			, T.APPYN" ).append("\n"); 
		query.append("			, T.APRO_RMK" ).append("\n"); 
		query.append("			, T.CRE_DT" ).append("\n"); 
		query.append("			, T.CRE_USR_ID" ).append("\n"); 
		query.append("			, T.USR_NM" ).append("\n"); 
		query.append("			, T.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("			, T.OFC_CD" ).append("\n"); 
		query.append("			, '' INV_EFF_DT" ).append("\n"); 
		query.append("			, '' OFC_NM" ).append("\n"); 
		query.append("			, T.AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("	  		, T.AGMT_FILE_CFM_CD" ).append("\n"); 
		query.append("	  		,(CASE WHEN" ).append("\n"); 
		query.append("        		NVL(( SELECT COUNT(F.ATCH_FILE_ID)" ).append("\n"); 
		query.append("        				FROM COM_AP_FILE_UPLD F" ).append("\n"); 
		query.append("        				WHERE 1=1" ).append("\n"); 
		query.append("        				AND F.AP_FILE_DIV_CD = 'C'" ).append("\n"); 
		query.append("        				AND F.CSR_NO = T.CSR_NO " ).append("\n"); 
		query.append("        				AND F.CSR_FILE_UPLD_TP_CD = 'FU'" ).append("\n"); 
		query.append("						AND NVL(F.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("        			),0) > 0 THEN 'Y'    " ).append("\n"); 
		query.append("    	  		ELSE 'N'" ).append("\n"); 
		query.append("          		END ) FILE_UPLD_FLG" ).append("\n"); 
		query.append("		   ,DECODE(T.APRO_TTL_AMT,0,T.ASA_NO,'') ASA_NO" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT --ROW_NUMBER() OVER (ORDER BY RQST_ST_DT DESC) no," ).append("\n"); 
		query.append("              A.APRO_RQST_NO" ).append("\n"); 
		query.append("	         , A.CRNT_APRO_SEQ" ).append("\n"); 
		query.append("  	         , A.APSTS_CD" ).append("\n"); 
		query.append("	         , A.SUB_SYS_CD" ).append("\n"); 
		query.append("      		 , D.GL_DT" ).append("\n"); 
		query.append("             , TO_CHAR(A.RQST_ST_DT, 'YYYY-MM-DD') RQST_ST_DT" ).append("\n"); 
		query.append("      		 , B.CSR_NO" ).append("\n"); 
		query.append("      		 , D.INV_DT" ).append("\n"); 
		query.append("	         , B.INV_KNT" ).append("\n"); 
		query.append("	         , TO_CHAR(B.VNDR_SEQ, '000000') VNDR_SEQ" ).append("\n"); 
		query.append("	         , B.PAY_DUE_DT" ).append("\n"); 
		query.append("	         , B.CURR_CD" ).append("\n"); 
		query.append("	         , B.APRO_TTL_AMT" ).append("\n"); 
		query.append("			 , CASE WHEN A.SUB_SYS_CD = 'TES' " ).append("\n"); 
		query.append("							THEN NVL((SELECT SUM(TTL_INV_AMT) AMT FROM TES_TML_SO_HDR WHERE CSR_NO = B.CSR_NO AND NVL(DELT_FLG,'N') <> 'Y'), B.APRO_TTL_AMT)" ).append("\n"); 
		query.append("					 WHEN A.SUB_SYS_CD = 'TRS' THEN" ).append("\n"); 
		query.append("							(SELECT " ).append("\n"); 
		query.append("  								SUM(NVL(INV_WRK.INV_BZC_AMT , RAIL_WRK.INV_BZC_AMT )) INV_BZC_AMT" ).append("\n"); 
		query.append("							FROM AP_INV_HDR DTRB , TRS_TRSP_INV_WRK INV_WRK , TRS_TRSP_RAIL_INV_WRK RAIL_WRK" ).append("\n"); 
		query.append("							WHERE DTRB.CSR_NO = INV_WRK.CSR_NO(+)" ).append("\n"); 
		query.append("  							AND DTRB.CSR_NO = RAIL_WRK.CSR_NO(+)" ).append("\n"); 
		query.append("  							AND DTRB.CSR_NO = B.CSR_NO)" ).append("\n"); 
		query.append("					 WHEN A.SUB_SYS_CD IN ('LSE','CHS','MGS','MNR','PSO','TLL','CNI')" ).append("\n"); 
		query.append("							THEN (SELECT SUM(NVL(T.INV_NET_AMT ,0)) TTL_INV_AMT FROM AP_PAY_INV T , AP_INV_HDR A WHERE  T.CSR_NO = A.CSR_NO AND T.CSR_NO = B.CSR_NO AND NVL(T.DELT_FLG,'N') <> 'Y')" ).append("\n"); 
		query.append("					 WHEN A.SUB_SYS_CD IN ('ACM','FMS') " ).append("\n"); 
		query.append("							THEN (SELECT SUM(INV_AMT) FROM AP_INV_DTRB WHERE CSR_NO = B.CSR_NO AND ATTR_CTNT1 IS NOT NULL AND DTRB_COA_ACCT_CD <> '954113')" ).append("\n"); 
		query.append("					 ELSE 0" ).append("\n"); 
		query.append("	           END AS ASA_AMT" ).append("\n"); 
		query.append("	         , B.COST_OFC_CD" ).append("\n"); 
		query.append("			 , C.APRO_OFC_CD" ).append("\n"); 
		query.append("			 , C.APRO_USR_ID" ).append("\n"); 
		query.append("			 , C.APRO_USR_NM" ).append("\n"); 
		query.append("	         , DECODE(NVL(C.APSTS_CD, ''), '', 'N', 'Y') APPYN" ).append("\n"); 
		query.append("	         , C.APRO_RMK" ).append("\n"); 
		query.append("			 , TO_CHAR(D.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("			 , D.CRE_USR_ID" ).append("\n"); 
		query.append("			 , (SELECT USR_NM FROM COM_USER WHERE USR_ID = D.CRE_USR_ID) AS USR_NM" ).append("\n"); 
		query.append("			 , NVL((" ).append("\n"); 
		query.append("	            SELECT DISTINCT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("	            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("	            WHERE OFC_CD IN (" ).append("\n"); 
		query.append("	                SELECT DISTINCT INV_OFC_CD" ).append("\n"); 
		query.append("	                FROM AP_PAY_INV" ).append("\n"); 
		query.append("	                WHERE CSR_NO = D.CSR_NO)), (SELECT DISTINCT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = A.RQST_OFC_CD) ) AS AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("	         , NVL((" ).append("\n"); 
		query.append("	            SELECT DISTINCT INV_OFC_CD" ).append("\n"); 
		query.append("	            FROM AP_PAY_INV" ).append("\n"); 
		query.append("	            WHERE CSR_NO = D.CSR_NO), A.RQST_OFC_CD) AS OFC_CD " ).append("\n"); 
		query.append("			 ,( CASE WHEN D.GW_AGMT_DOC_CFM_CD IS NOT NULL" ).append("\n"); 
		query.append("           		  	THEN ( CASE WHEN D.GW_AGMT_DOC_CFM_CD = 'P' THEN 'Y'" ).append("\n"); 
		query.append("                       			WHEN D.GW_AGMT_DOC_CFM_CD = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                       			ELSE 'N'" ).append("\n"); 
		query.append("                  			END )" ).append("\n"); 
		query.append("         			ELSE NVL(D.AGMT_DOC_CFM_CD,'N')" ).append("\n"); 
		query.append("    			END ) AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("			  , NVL(D.AGMT_FILE_CFM_CD,'N') AGMT_FILE_CFM_CD  --추가" ).append("\n"); 
		query.append("			  , D.ATTR_CTNT2 AS ASA_NO" ).append("\n"); 
		query.append("	      FROM COM_APRO_RQST_HDR  A" ).append("\n"); 
		query.append("	         , COM_APRO_CSR_DTL   B" ).append("\n"); 
		query.append("	         , COM_APRO_RQST_ROUT C" ).append("\n"); 
		query.append("			 , AP_INV_HDR D" ).append("\n"); 
		query.append("	     WHERE 1 = 1" ).append("\n"); 
		query.append("	       AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("           AND NVL(D.AFT_ACT_FLG,' ') NOT IN ('X','N')" ).append("\n"); 
		query.append("           AND A.SUB_SYS_CD NOT IN ('JOO')" ).append("\n"); 
		query.append("           AND NVL(D.CSR_APRO_TP_CD,'AL') = 'AL'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${sub_sys_cd} != '')" ).append("\n"); 
		query.append("           AND A.SUB_SYS_CD = @[sub_sys_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   AND A.APRO_RQST_NO = B.APRO_RQST_NO" ).append("\n"); 
		query.append("    	   AND A.APRO_RQST_NO = C.APRO_RQST_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND A.APSTS_CD = 'P'" ).append("\n"); 
		query.append("           AND A.CRNT_APRO_SEQ = C.APRO_RQST_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   AND B.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("		   #if (${csr_no} != '')" ).append("\n"); 
		query.append("		   AND B.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${inv_eff_dt} != '')" ).append("\n"); 
		query.append("           AND D.GL_DT <=  replace(@[inv_eff_dt], '-', '')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("             '' APRO_RQST_NO" ).append("\n"); 
		query.append("	         , TO_NUMBER('') CRNT_APRO_SEQ" ).append("\n"); 
		query.append("  	         , '' APSTS_CD        " ).append("\n"); 
		query.append("	         , R.SUB_SYS_ID SUB_SYS_CD" ).append("\n"); 
		query.append("      		 , D.GL_DT" ).append("\n"); 
		query.append("             , TO_CHAR(D.CSR_APRO_STEP_ASGN_RQST_DT, 'YYYY-MM-DD') RQST_ST_DT" ).append("\n"); 
		query.append("      		 , D.CSR_NO" ).append("\n"); 
		query.append("      		 , D.INV_DT" ).append("\n"); 
		query.append("	         , TO_NUMBER('') INV_KNT" ).append("\n"); 
		query.append("             , TO_CHAR(D.VNDR_NO, '000000') VNDR_SEQ" ).append("\n"); 
		query.append("	         , '' PAY_DUE_DT" ).append("\n"); 
		query.append("	         , D.CSR_CURR_CD" ).append("\n"); 
		query.append("	         , D.CSR_AMT APRO_TTL_AMT" ).append("\n"); 
		query.append("			 , CASE WHEN R.SUB_SYS_ID = 'TES' " ).append("\n"); 
		query.append("							THEN NVL((SELECT SUM(TTL_INV_AMT) AMT FROM TES_TML_SO_HDR WHERE CSR_NO = d.CSR_NO AND NVL(DELT_FLG,'N') <> 'Y'), D.CSR_AMT)" ).append("\n"); 
		query.append("					 WHEN R.SUB_SYS_ID = 'TRS' THEN" ).append("\n"); 
		query.append("							(SELECT " ).append("\n"); 
		query.append("  								SUM(NVL(INV_WRK.INV_BZC_AMT , RAIL_WRK.INV_BZC_AMT )) INV_BZC_AMT" ).append("\n"); 
		query.append("							FROM AP_INV_HDR DTRB , TRS_TRSP_INV_WRK INV_WRK , TRS_TRSP_RAIL_INV_WRK RAIL_WRK" ).append("\n"); 
		query.append("							WHERE DTRB.CSR_NO = INV_WRK.CSR_NO(+)" ).append("\n"); 
		query.append("  							AND DTRB.CSR_NO = RAIL_WRK.CSR_NO(+)" ).append("\n"); 
		query.append("  							AND DTRB.CSR_NO = D.CSR_NO)" ).append("\n"); 
		query.append("					 WHEN R.SUB_SYS_ID IN ('LSE','CHS','MGS','MNR','PSO','TLL','CNI')" ).append("\n"); 
		query.append("							THEN (SELECT SUM(NVL(T.INV_NET_AMT ,0)) TTL_INV_AMT FROM AP_PAY_INV T WHERE  T.CSR_NO = D.CSR_NO AND NVL(T.DELT_FLG,'N') <> 'Y')" ).append("\n"); 
		query.append("					 WHEN R.SUB_SYS_ID IN ('ACM','FMS') " ).append("\n"); 
		query.append("							THEN (SELECT SUM(INV_AMT) FROM AP_INV_DTRB WHERE CSR_NO = D.CSR_NO AND ATTR_CTNT1 IS NOT NULL AND DTRB_COA_ACCT_CD <> '954113')" ).append("\n"); 
		query.append("					 ELSE 0" ).append("\n"); 
		query.append("	            END AS ASA_AMT" ).append("\n"); 
		query.append("	         , '' COST_OFC_CD" ).append("\n"); 
		query.append("			 , '' APRO_OFC_CD" ).append("\n"); 
		query.append("			 , '' APRO_USR_ID" ).append("\n"); 
		query.append("			 , '' APRO_USR_NM" ).append("\n"); 
		query.append("             , 'N' APPYN" ).append("\n"); 
		query.append("	         , '' APRO_RMK" ).append("\n"); 
		query.append("			 , TO_CHAR(D.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("			 , D.CRE_USR_ID" ).append("\n"); 
		query.append("			 , (SELECT USR_NM FROM COM_USER WHERE USR_ID = D.CRE_USR_ID) AS USR_NM" ).append("\n"); 
		query.append("			 , NVL((" ).append("\n"); 
		query.append("	            SELECT DISTINCT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("	            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("	            WHERE OFC_CD IN (" ).append("\n"); 
		query.append("	                SELECT DISTINCT INV_OFC_CD" ).append("\n"); 
		query.append("	                FROM AP_PAY_INV" ).append("\n"); 
		query.append("	                WHERE CSR_NO = D.CSR_NO)), (SELECT DISTINCT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = D.TJ_OFC_CD) ) AS AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("	         , NVL((" ).append("\n"); 
		query.append("	            SELECT DISTINCT INV_OFC_CD" ).append("\n"); 
		query.append("	            FROM AP_PAY_INV" ).append("\n"); 
		query.append("	            WHERE CSR_NO = D.CSR_NO), D.TJ_OFC_CD) AS OFC_CD " ).append("\n"); 
		query.append("			 ,( CASE WHEN D.GW_AGMT_DOC_CFM_CD IS NOT NULL" ).append("\n"); 
		query.append("           		  	THEN ( CASE WHEN D.GW_AGMT_DOC_CFM_CD = 'P' THEN 'Y'" ).append("\n"); 
		query.append("                       			WHEN D.GW_AGMT_DOC_CFM_CD = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                       			ELSE 'N'" ).append("\n"); 
		query.append("                  			END )" ).append("\n"); 
		query.append("         			ELSE NVL(D.AGMT_DOC_CFM_CD,'N')" ).append("\n"); 
		query.append("    			END ) AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("			  , NVL(D.AGMT_FILE_CFM_CD,'N') AGMT_FILE_CFM_CD  --추가" ).append("\n"); 
		query.append("			  , D.ATTR_CTNT2 AS ASA_NO" ).append("\n"); 
		query.append("	      FROM AP_INV_HDR D, COM_APRO_SND_MN_RULE R" ).append("\n"); 
		query.append("	     WHERE 1 = 1" ).append("\n"); 
		query.append("           AND NVL(D.AFT_ACT_FLG,' ') NOT IN ('X','N')" ).append("\n"); 
		query.append("           AND NVL(D.CSR_APRO_TP_CD,'AL') = 'AL'" ).append("\n"); 
		query.append("           AND D.SRC_CTNT = R.SRC_CTNT(+)" ).append("\n"); 
		query.append("           AND R.SUB_SYS_ID NOT IN ('JOO')" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND NVL(D.RQST_APRO_STEP_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("           AND NOT EXISTS (" ).append("\n"); 
		query.append("                SELECT 'X'" ).append("\n"); 
		query.append("                FROM COM_APRO_CSR_DTL   B" ).append("\n"); 
		query.append("                WHERE B.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${sub_sys_cd} != '')" ).append("\n"); 
		query.append("           AND R.SUB_SYS_ID = @[sub_sys_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   #if (${csr_no} != '')" ).append("\n"); 
		query.append("		   AND D.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${inv_eff_dt} != '')" ).append("\n"); 
		query.append("           AND D.GL_DT <=  replace(@[inv_eff_dt], '-', '')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT --ROW_NUMBER() OVER (ORDER BY RQST_ST_DT DESC) no," ).append("\n"); 
		query.append("             '' APRO_RQST_NO" ).append("\n"); 
		query.append("	         , TO_NUMBER('') CRNT_APRO_SEQ" ).append("\n"); 
		query.append("  	         , '' APSTS_CD        " ).append("\n"); 
		query.append("	         , R.SUB_SYS_ID SUB_SYS_CD" ).append("\n"); 
		query.append("      		 , D.GL_DT" ).append("\n"); 
		query.append("             , TO_CHAR(D.CSR_APRO_STEP_ASGN_RQST_DT, 'YYYY-MM-DD') RQST_ST_DT" ).append("\n"); 
		query.append("      		 , D.CSR_NO" ).append("\n"); 
		query.append("      		 , D.INV_DT" ).append("\n"); 
		query.append("             , TO_NUMBER('') INV_KNT" ).append("\n"); 
		query.append("             , TO_CHAR(D.VNDR_NO, '000000') VNDR_SEQ" ).append("\n"); 
		query.append("	         , '' PAY_DUE_DT" ).append("\n"); 
		query.append("	         , D.CSR_CURR_CD CURR_CD" ).append("\n"); 
		query.append("	         , D.CSR_AMT APRO_TTL_AMT" ).append("\n"); 
		query.append("			 , 0 ASA_AMT" ).append("\n"); 
		query.append("	         , '' COST_OFC_CD" ).append("\n"); 
		query.append("			 , '' APRO_OFC_CD" ).append("\n"); 
		query.append("			 , '' APRO_USR_ID" ).append("\n"); 
		query.append("			 , '' APRO_USR_NM" ).append("\n"); 
		query.append("	         , DECODE(NVL(D.APRO_FLG, ''), '', 'N', 'Y') APPYN" ).append("\n"); 
		query.append("	         , '' APRO_RMK" ).append("\n"); 
		query.append("			 , TO_CHAR(D.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("			 , D.CRE_USR_ID" ).append("\n"); 
		query.append("			 , (SELECT USR_NM FROM COM_USER WHERE USR_ID = D.CRE_USR_ID) AS USR_NM" ).append("\n"); 
		query.append("			 , NVL((" ).append("\n"); 
		query.append("	            SELECT DISTINCT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("	            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("	            WHERE OFC_CD IN (" ).append("\n"); 
		query.append("	                SELECT DISTINCT INV_OFC_CD" ).append("\n"); 
		query.append("	                FROM AP_PAY_INV" ).append("\n"); 
		query.append("	                WHERE CSR_NO = D.CSR_NO)), (SELECT DISTINCT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = D.TJ_OFC_CD) ) AS AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("	         , NVL((" ).append("\n"); 
		query.append("	            SELECT DISTINCT INV_OFC_CD" ).append("\n"); 
		query.append("	            FROM AP_PAY_INV" ).append("\n"); 
		query.append("	            WHERE CSR_NO = D.CSR_NO), D.TJ_OFC_CD) AS OFC_CD " ).append("\n"); 
		query.append("			 ,( CASE WHEN D.GW_AGMT_DOC_CFM_CD IS NOT NULL" ).append("\n"); 
		query.append("           		  	THEN ( CASE WHEN D.GW_AGMT_DOC_CFM_CD = 'P' THEN 'Y'" ).append("\n"); 
		query.append("                       			WHEN D.GW_AGMT_DOC_CFM_CD = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                       			ELSE 'N'" ).append("\n"); 
		query.append("                  			END )" ).append("\n"); 
		query.append("         			ELSE NVL(D.AGMT_DOC_CFM_CD,'N')" ).append("\n"); 
		query.append("    			END ) AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("			  , NVL(D.AGMT_FILE_CFM_CD,'N') AGMT_FILE_CFM_CD  --추가" ).append("\n"); 
		query.append("			  , D.ATTR_CTNT2 AS ASA_NO" ).append("\n"); 
		query.append("	      FROM AP_INV_HDR D, COM_APRO_SND_MN_RULE R" ).append("\n"); 
		query.append("	     WHERE 1 = 1" ).append("\n"); 
		query.append("           AND D.SRC_CTNT = R.SRC_CTNT(+)" ).append("\n"); 
		query.append("           AND NVL(D.AFT_ACT_FLG,' ') NOT IN ('X','N')" ).append("\n"); 
		query.append("           AND R.SUB_SYS_ID NOT IN ('JOO')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${sub_sys_cd} != '')" ).append("\n"); 
		query.append("           AND R.SUB_SYS_ID = @[sub_sys_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   #if (${csr_no} != '')" ).append("\n"); 
		query.append("		   AND D.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${inv_eff_dt} != '')" ).append("\n"); 
		query.append("           AND D.GL_DT <=  replace(@[inv_eff_dt], '-', '')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND NVL(D.CSR_APRO_TP_CD,'AL') = 'GW'" ).append("\n"); 
		query.append("           AND NVL(D.RQST_APRO_STEP_FLG,'X') <> 'Y'" ).append("\n"); 
		query.append("           AND (D.CSR_APRO_CMPL_DT IS NULL AND D.CSR_CXL_DT IS NULL AND D.CSR_RJCT_DT IS NULL)   " ).append("\n"); 
		query.append("           AND D.IF_FLG IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ) T" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if ( (${ar_hd_qtr_ofc_cd} != '' && ${ar_hd_qtr_ofc_cd} != 'ALL') && (${ofc_cd} == '' || ${ofc_cd} == 'ALL'))" ).append("\n"); 
		query.append("  AND T.OFC_CD IN (" ).append("\n"); 
		query.append("        select ofc_cd" ).append("\n"); 
		query.append("        from mdm_organization" ).append("\n"); 
		query.append("        where ar_hd_qtr_ofc_cd = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("          and delt_flg = 'N'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - ofc_cd */" ).append("\n"); 
		query.append(" #if (${ofc_cd} != '' && ${ofc_cd} != 'ALL') " ).append("\n"); 
		query.append("	#foreach($key1 IN ${ofc_cd})" ).append("\n"); 
		query.append(" 	AND T.OFC_CD IN ('$key1')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sub_sys_cd} == 'JOO' || ${sub_sys_cd} == '')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/*JOO*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT '' APRO_RQST_NO ," ).append("\n"); 
		query.append("  0 CRNT_APRO_SEQ ," ).append("\n"); 
		query.append("  '' APSTS_CD ," ).append("\n"); 
		query.append("  'JOO' SUB_SYS_CD," ).append("\n"); 
		query.append("   TO_CHAR(J.EFF_DT, 'YYYY-MM-DD') GL_DT," ).append("\n"); 
		query.append("  TO_CHAR(J.RQST_DT, 'YYYY-MM-DD') RQST_ST_DT," ).append("\n"); 
		query.append("  J.SLP_TP_CD||J.SLP_FUNC_CD||J.SLP_OFC_CD||TO_CHAR(TO_DATE(J.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||J.SLP_SER_NO CSR_NO," ).append("\n"); 
		query.append("  '' INV_DT ," ).append("\n"); 
		query.append("  0 INV_KNT ," ).append("\n"); 
		query.append("  '' VNDR_SEQ ," ).append("\n"); 
		query.append("  '' PAY_DUE_DT ," ).append("\n"); 
		query.append("  J.CSR_LOCL_CURR_CD CURR_CD," ).append("\n"); 
		query.append("  J.CSR_LOCL_AMT APRO_TTL_AMT," ).append("\n"); 
		query.append("  C.ASA_AMT," ).append("\n"); 
		query.append("  '' COST_OFC_CD ," ).append("\n"); 
		query.append("  '' APRO_OFC_CD ," ).append("\n"); 
		query.append("  C.APRO_USR_ID," ).append("\n"); 
		query.append("  C.APRO_USR_NM," ).append("\n"); 
		query.append("  '' APPYN ," ).append("\n"); 
		query.append("  '' APRO_RMK," ).append("\n"); 
		query.append("  TO_CHAR(J.CRE_DT, 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("  J.CRE_USR_ID," ).append("\n"); 
		query.append("  U.USR_NM," ).append("\n"); 
		query.append("  O.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("  J.SLP_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("  '' INV_EFF_DT ," ).append("\n"); 
		query.append("  '' OFC_NM," ).append("\n"); 
		query.append("  '' AGMT_DOC_CFM_CD,  --추가" ).append("\n"); 
		query.append("  '' AGMT_FILE_CFM_CD,  --추가" ).append("\n"); 
		query.append("  '' FILE_UPLD_FLG,      --추가" ).append("\n"); 
		query.append("  C.ASA_NO" ).append("\n"); 
		query.append("FROM	JOO_CSR J," ).append("\n"); 
		query.append("		COM_USER U," ).append("\n"); 
		query.append("		MDM_ORGANIZATION O," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("	       SELECT" ).append("\n"); 
		query.append("	              B.CSR_NO," ).append("\n"); 
		query.append("	              C.APRO_USR_ID," ).append("\n"); 
		query.append("                  ( SELECT USR_NM FROM COM_USER WHERE USR_ID = C.APRO_USR_ID ) AS APRO_USR_NM," ).append("\n"); 
		query.append("				  (SELECT ATTR_CTNT2 FROM AP_INV_HDR WHERE CSR_NO = B.CSR_NO) AS ASA_NO," ).append("\n"); 
		query.append("				  (SELECT SUM(INV_AMT) FROM AP_INV_DTRB WHERE CSR_NO = B.CSR_NO AND ATTR_CTNT1 IS NOT NULL AND DTRB_COA_ACCT_CD <> '954113') AS ASA_AMT" ).append("\n"); 
		query.append("	         FROM COM_APRO_RQST_HDR  A," ).append("\n"); 
		query.append("	              COM_APRO_CSR_DTL   B," ).append("\n"); 
		query.append("	              COM_APRO_RQST_ROUT C" ).append("\n"); 
		query.append("	        WHERE NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("	          AND NVL(B.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("	          AND NVL(C.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("	          AND A.SUB_SYS_CD         = 'JOO'" ).append("\n"); 
		query.append("	          AND NVL(A.APSTS_CD,'P')  = 'P'" ).append("\n"); 
		query.append("	          AND NVL(C.APSTS_CD,'P')  = 'P'" ).append("\n"); 
		query.append("	          AND A.APRO_RQST_NO  = B.APRO_RQST_NO" ).append("\n"); 
		query.append("	          AND A.APRO_RQST_NO  = C.APRO_RQST_NO(+)" ).append("\n"); 
		query.append("	          AND A.CRNT_APRO_SEQ = C.APRO_RQST_SEQ(+)" ).append("\n"); 
		query.append("		) C" ).append("\n"); 
		query.append("WHERE J.APRO_FLG = 'N'" ).append("\n"); 
		query.append("  AND J.CXL_FLG = 'N'" ).append("\n"); 
		query.append("  AND J.CRE_USR_ID = U.USR_ID" ).append("\n"); 
		query.append("  AND J.SLP_OFC_CD = O.OFC_CD " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  AND J.SLP_TP_CD||J.SLP_FUNC_CD||J.SLP_OFC_CD||TO_CHAR(TO_DATE(J.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||J.SLP_SER_NO = C.CSR_NO" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#if (${csr_no} != '')" ).append("\n"); 
		query.append("  AND C.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( (${ar_hd_qtr_ofc_cd} != '' && ${ar_hd_qtr_ofc_cd} != 'ALL') && (${ofc_cd} == '' || ${ofc_cd} == 'ALL'))" ).append("\n"); 
		query.append("  AND J.SLP_OFC_CD IN (" ).append("\n"); 
		query.append("        select ofc_cd" ).append("\n"); 
		query.append("        from mdm_organization" ).append("\n"); 
		query.append("        where ar_hd_qtr_ofc_cd = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("          and delt_flg = 'N'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - ofc_cd */" ).append("\n"); 
		query.append(" #if (${ofc_cd} != '' && ${ofc_cd} != 'ALL') " ).append("\n"); 
		query.append("	#foreach($key1 IN ${ofc_cd})" ).append("\n"); 
		query.append(" 	AND J.SLP_OFC_CD IN ('$key1')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_eff_dt} != '')" ).append("\n"); 
		query.append("   AND J.EFF_DT <=  TO_DATE(replace(@[inv_eff_dt], '-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY AR_HD_QTR_OFC_CD, SUB_SYS_CD, OFC_CD DESC" ).append("\n"); 

	}
}