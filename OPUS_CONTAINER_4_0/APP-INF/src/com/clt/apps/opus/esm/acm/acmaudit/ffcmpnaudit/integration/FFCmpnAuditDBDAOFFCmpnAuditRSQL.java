/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FFCmpnAuditDBDAOFFCmpnAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.ffcmpnaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnAuditDBDAOFFCmpnAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FFCmpnAudit
	  * </pre>
	  */
	public FFCmpnAuditDBDAOFFCmpnAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_brog_cnt_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmaudit.ffcmpnaudit.integration").append("\n"); 
		query.append("FileName : FFCmpnAuditDBDAOFFCmpnAuditRSQL").append("\n"); 
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
		query.append("SELECT A.FF_CMPN_SEQ,	" ).append("\n"); 
		query.append("	   A.AP_OFC_CD,					 " ).append("\n"); 
		query.append("       CASE A.BKG_FF_CNT_CD						 " ).append("\n"); 
		query.append("         WHEN '' THEN ''						 " ).append("\n"); 
		query.append("         ELSE CONCAT(A.BKG_FF_CNT_CD, TO_CHAR (A.BKG_FF_SEQ, 'FM000000'))						 " ).append("\n"); 
		query.append("       END AS FRT_FWRD_CNT_SEQ,						 " ).append("\n"); 
		query.append("       TO_CHAR (A.VNDR_SEQ, 'FM000000') AS VNDR_CNT_SEQ,						 " ).append("\n"); 
		query.append("       (SELECT MAX (NVL (LTRIM (C.CUST_LGL_ENG_NM), ' '))						 " ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER C						 " ).append("\n"); 
		query.append("         WHERE C.CUST_CNT_CD(+) = A.BKG_FF_CNT_CD						 " ).append("\n"); 
		query.append("           AND C.CUST_SEQ(+) = A.BKG_FF_SEQ						 " ).append("\n"); 
		query.append("           AND C.CNTR_DIV_FLG(+) = 'Y' ) AS CUST_LGL_ENG_NM,						 " ).append("\n"); 
		query.append("       A.BKG_NO,						 " ).append("\n"); 
		query.append("       (SELECT MAX (NVL (B.BL_NO, ' '))						 " ).append("\n"); 
		query.append("          FROM ACM_AGN_BKG_INFO B						 " ).append("\n"); 
		query.append("         WHERE B.BKG_NO = A.BKG_NO ) AS BL_NO,						 " ).append("\n"); 
		query.append("       (SELECT MAX (NVL (B.BKG_STS_CD, ' '))						 " ).append("\n"); 
		query.append("          FROM BKG_BOOKING B						 " ).append("\n"); 
		query.append("         WHERE B.BKG_NO = A.BKG_NO ) AS BKG_STS_CD,						 " ).append("\n"); 
		query.append("       TO_CHAR (A.VSL_DEP_DT, 'YYYYMMDD') AS VSL_DEP_DT,						 " ).append("\n"); 
		query.append("       TO_CHAR (A.CRE_DT, 'YYYYMMDD') AS CRE_DT,						 " ).append("\n"); 
		query.append("       A.FF_VSL_CD||A.FF_SKD_VOY_NO||A.FF_SKD_DIR_CD AS COMM_VVD,						 " ).append("\n"); 
		query.append("       NVL (A.FMC_NO, ' ') AS FMC_NO,						 " ).append("\n"); 
		query.append("       NVL (A.FF_REF_NO, ' ') AS FF_REF_NO,						 " ).append("\n"); 
		query.append("       CASE						 " ).append("\n"); 
		query.append("         WHEN SUBSTR (A.FF_DIV_CD, 1, 1) = 'B' AND NVL (A.FF_BKG_RT, 0) != 0 						 " ).append("\n"); 
		query.append("         THEN DECODE(NVL(A.FF_CHG_AMT,0),0,(A.CRNT_AMT / A.FF_BKG_RT) * 100,A.FF_CHG_AMT)						 " ).append("\n"); 
		query.append("         ELSE 0						 " ).append("\n"); 
		query.append("       END AS ACT_COMM_ABLE,						 " ).append("\n"); 
		query.append("       NVL (FF_BKG_RT, 0) AS FF_BKG_RT,						 " ).append("\n"); 
		query.append("       CASE SUBSTR (A.FF_DIV_CD, 1, 1)						 " ).append("\n"); 
		query.append("         WHEN 'B' THEN A.CRNT_AMT						 " ).append("\n"); 
		query.append("         ELSE 0						 " ).append("\n"); 
		query.append("       END AS BKG_CRNT_AMT,						 " ).append("\n"); 
		query.append("       NVL (A.BKG_BX_QTY, 0) AS BKG_BX_QTY,						 " ).append("\n"); 
		query.append("       NVL (A.FF_BX_AMT, 0) AS FF_BX_AMT,						 " ).append("\n"); 
		query.append("       NVL (A.BKG_TEU_QTY, 0) AS BKG_TEU_QTY,						 " ).append("\n"); 
		query.append("       NVL (A.FF_TEU_AMT, 0) AS FF_TEU_AMT,						 " ).append("\n"); 
		query.append("       NVL (A.BKG_FEU_QTY, 0) AS BKG_FEU_QTY,						 " ).append("\n"); 
		query.append("       NVL (A.FF_FEU_AMT, 0) AS FF_FEU_AMT,						 " ).append("\n"); 
		query.append("       NVL (A.BKG_RF_QTY, 0) AS BKG_RF_QTY,						 " ).append("\n"); 
		query.append("       NVL (A.FF_RF_AMT, 0) AS FF_RF_AMT,						 " ).append("\n"); 
		query.append("       CASE SUBSTR (A.FF_DIV_CD, 1, 1)						 " ).append("\n"); 
		query.append("         WHEN 'C' THEN A.CRNT_AMT						 " ).append("\n"); 
		query.append("         ELSE 0						 " ).append("\n"); 
		query.append("       END AS CNTR_CRNT_AMT,						 " ).append("\n"); 
		query.append("       NVL (A.PPD_AMT, 0) AS PPD_AMT,						 " ).append("\n"); 
		query.append("       NVL (A.IF_AMT, 0) AS IF_AMT,						 " ).append("\n"); 
		query.append("       NVL (A.FF_CMPN_STS_CD, ' ') AS FF_CMPN_STS_CD,						 " ).append("\n"); 
		query.append("       NVL (A.FF_CMPN_RMK,(SELECT COMM_PROC_RSLT_RSN FROM ACM_AGN_BKG_INFO WHERE BKG_NO = A.BKG_NO)) AS FF_CMPN_RMK,							 " ).append("\n"); 
		query.append("       NVL (TO_CHAR (IF_DT, 'YYYYMMDD'), ' ') AS IF_DT,						 " ).append("\n"); 
		query.append("       A.FF_AGMT_SEQ						 " ).append("\n"); 
		query.append("  FROM ACM_FF_CMPN A,						 " ).append("\n"); 
		query.append("       (SELECT A.BKG_NO,						 " ).append("\n"); 
		query.append("               MAX (A.FF_CMPN_SEQ) AS FF_CMPN_SEQ						 " ).append("\n"); 
		query.append("          FROM ACM_FF_CMPN A						 " ).append("\n"); 
		query.append("         WHERE 1=1						 " ).append("\n"); 
		query.append("#if(${if_opt} == 'I')						 " ).append("\n"); 
		query.append("           AND A.FF_CMPN_STS_CD    = 'IF'						 " ).append("\n"); 
		query.append("#end						 " ).append("\n"); 
		query.append("#if(${if_opt} == 'N')						 " ).append("\n"); 
		query.append("           AND A.FF_CMPN_STS_CD   <> 'IF'						 " ).append("\n"); 
		query.append("#end						 " ).append("\n"); 
		query.append("#if(${vvd_cd} != '')						 " ).append("\n"); 
		query.append("           AND A.FF_VSL_CD || A.FF_SKD_VOY_NO || A.FF_SKD_DIR_CD" ).append("\n"); 
		query.append("            IN (${vvd_cd} )						 " ).append("\n"); 
		query.append("#end						 " ).append("\n"); 
		query.append("#if(${search_brog_cnt_cust_seq} != '')						 " ).append("\n"); 
		query.append("           AND A.BKG_FF_CNT_CD     = SUBSTR(@[search_brog_cnt_cust_seq], 1, 2)						 " ).append("\n"); 
		query.append("           AND A.BKG_FF_SEQ        = SUBSTR(@[search_brog_cnt_cust_seq], 3)						 " ).append("\n"); 
		query.append("						 " ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("#if (${bl_no} == '')		 " ).append("\n"); 
		query.append("#if(${date_option} == 'I')						 " ).append("\n"); 
		query.append("                  AND A.IF_DT						 " ).append("\n"); 
		query.append("              BETWEEN TO_DATE (NVL(REPLACE(@[date_fm],'-',''), '19000101'), 'YYYYMMDD')						 " ).append("\n"); 
		query.append("                  AND TO_DATE (NVL(REPLACE(@[date_to],'-',''), '29990101'), 'YYYYMMDD')+0.99999						 " ).append("\n"); 
		query.append("#end						 " ).append("\n"); 
		query.append("#if(${date_option} == 'E')						 " ).append("\n"); 
		query.append("                  AND A.VSL_DEP_DT						 " ).append("\n"); 
		query.append("              BETWEEN TO_DATE (NVL(REPLACE(@[date_fm],'-',''), '19000101'), 'YYYYMMDD')						 " ).append("\n"); 
		query.append("                  AND TO_DATE (NVL(REPLACE(@[date_to],'-',''), '29990101'), 'YYYYMMDD')+0.99999						 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end						 " ).append("\n"); 
		query.append("#if( ${bl_no} != '' || ${date_option} == 'C')						 " ).append("\n"); 
		query.append("           AND A.BKG_NO IN						 " ).append("\n"); 
		query.append("            (SELECT BKG_NO FROM ACM_AGN_BKG_INFO						 " ).append("\n"); 
		query.append("                 WHERE 1=1 						 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_no} != '')		" ).append("\n"); 
		query.append("   AND BL_NO IN (${bl_no})		" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#if(${date_option} == 'C')						 " ).append("\n"); 
		query.append("                    AND BKG_CRE_DT						 " ).append("\n"); 
		query.append("                     BETWEEN TO_DATE (NVL(REPLACE(@[date_fm],'-',''), '19000101'), 'YYYYMMDD')						 " ).append("\n"); 
		query.append("                        AND TO_DATE (NVL(REPLACE(@[date_to],'-',''), '29990101'), 'YYYYMMDD')+0.99999						 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end			 				 " ).append("\n"); 
		query.append("           )						 " ).append("\n"); 
		query.append("#end						 " ).append("\n"); 
		query.append("         GROUP BY A.BKG_NO ) B " ).append("\n"); 
		query.append(" WHERE A.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("   AND A.FF_CMPN_SEQ = B.FF_CMPN_SEQ" ).append("\n"); 
		query.append("#if (${f_ap_ofc_cd} != '') " ).append("\n"); 
		query.append("   AND A.AP_OFC_CD IN (${f_ap_ofc_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY CONCAT (A.BKG_FF_CNT_CD, A.BKG_FF_SEQ), " ).append("\n"); 
		query.append("       CONCAT (A.VNDR_CNT_CD, A.VNDR_SEQ), " ).append("\n"); 
		query.append("       CUST_LGL_ENG_NM, " ).append("\n"); 
		query.append("       CONCAT (A.VNDR_CNT_CD, A.VNDR_SEQ), " ).append("\n"); 
		query.append("       CUST_LGL_ENG_NM" ).append("\n"); 

	}
}