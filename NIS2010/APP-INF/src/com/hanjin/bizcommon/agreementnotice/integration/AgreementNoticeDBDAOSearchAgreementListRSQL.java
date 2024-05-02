/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementNoticeDBDAOSearchAgreementListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementNoticeDBDAOSearchAgreementListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Notice popup user list 조회
	  * </pre>
	  */
	public AgreementNoticeDBDAOSearchAgreementListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.agreementnotice.integration").append("\n"); 
		query.append("FileName : AgreementNoticeDBDAOSearchAgreementListRSQL").append("\n"); 
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
		query.append("WITH USR_MGMT AS (" ).append("\n"); 
		query.append("    SELECT M.*    " ).append("\n"); 
		query.append("    FROM COM_CTRT_USR_MGMT M" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND M.ROOT_PGM_NO = @[pgm_no]" ).append("\n"); 
		query.append("    AND EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM COM_CTRT_USR_LIST L" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND L.SYS_CD = M.SYS_CD" ).append("\n"); 
		query.append("        AND L.CTRT_OFC_CD = M.CTRT_OFC_CD" ).append("\n"); 
		query.append("        AND L.AGMT_NO = M.AGMT_NO" ).append("\n"); 
		query.append("        AND L.NTC_USR_ID = @[user_id]" ).append("\n"); 
		query.append("        AND L.NTC_USR_SEQ <= COM_NTC_USR_KNT_FNC()" ).append("\n"); 
		query.append("    )   " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT C1.SYS_CD" ).append("\n"); 
		query.append("      ,C1.AGMT_NO" ).append("\n"); 
		query.append("      ,C1.VNDR_NM" ).append("\n"); 
		query.append("      ,C1.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("      ,C1.CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,C1.CTRT_CRE_USR_ID" ).append("\n"); 
		query.append("      ,C1.CTRT_CRE_USR_NM" ).append("\n"); 
		query.append("      ,C1.LIVE_FLG" ).append("\n"); 
		query.append("      ,C1.AGMT_EFF_DT" ).append("\n"); 
		query.append("      ,C1.AGMT_EXP_DT" ).append("\n"); 
		query.append("      ,C1.CTRT_UPD_DT" ).append("\n"); 
		query.append("      ,MAX(C1.CNT) OVER (PARTITION BY C1.SYS_CD) AGMT_CNT" ).append("\n"); 
		query.append(" FROM " ).append("\n"); 
		query.append("       (SELECT B1.SYS_CD" ).append("\n"); 
		query.append("              ,B1.AGMT_NO" ).append("\n"); 
		query.append("              ,B1.VNDR_NM" ).append("\n"); 
		query.append("              ,B1.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("              ,B1.CTRT_OFC_CD" ).append("\n"); 
		query.append("              ,B1.CTRT_CRE_USR_ID" ).append("\n"); 
		query.append("              ,B1.CTRT_CRE_USR_NM" ).append("\n"); 
		query.append("              ,NVL(B1.LIVE_FLG, 'N') LIVE_FLG" ).append("\n"); 
		query.append("              ,B1.AGMT_EFF_DT" ).append("\n"); 
		query.append("              ,B1.AGMT_EXP_DT" ).append("\n"); 
		query.append("              ,B1.CTRT_UPD_DT" ).append("\n"); 
		query.append("              ,DENSE_RANK() OVER (PARTITION BY B1.SYS_CD ORDER BY B1.AGMT_NO) CNT" ).append("\n"); 
		query.append("          FROM" ).append("\n"); 
		query.append("              (SELECT A1.SYS_CD" ).append("\n"); 
		query.append("                      ,CASE WHEN A1.SYS_CD = 'TRS' THEN" ).append("\n"); 
		query.append("                            	CASE WHEN INSTR(A1.AGMT_NO,'-') > 0 THEN SUBSTR(A1.AGMT_NO,1,INSTR(A1.AGMT_NO,'-',1,1)-1) ELSE A1.AGMT_NO END" ).append("\n"); 
		query.append("                            ELSE A1.AGMT_NO" ).append("\n"); 
		query.append("                       END AS AGMT_NO" ).append("\n"); 
		query.append("                      ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A1.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append("                      ,A1.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("                      ,A1.CTRT_OFC_CD" ).append("\n"); 
		query.append("                      ,A1.CTRT_CRE_USR_ID" ).append("\n"); 
		query.append("                      ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A1.CTRT_CRE_USR_ID) CTRT_CRE_USR_NM" ).append("\n"); 
		query.append("                      ,(SELECT USE_FLG FROM COM_USER WHERE USR_ID = A1.CTRT_CRE_USR_ID) LIVE_FLG" ).append("\n"); 
		query.append("                      ,TO_CHAR(A1.AGMT_EFF_DT, 'YYYY-MM-DD') AGMT_EFF_DT" ).append("\n"); 
		query.append("                      ,TO_CHAR(A1.AGMT_EXP_DT, 'YYYY-MM-DD') AGMT_EXP_DT" ).append("\n"); 
		query.append("                      ,TO_CHAR(A1.CTRT_UPD_DT, 'YYYY-MM-DD HH24:MI') CTRT_UPD_DT" ).append("\n"); 
		query.append("                      ,(SELECT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = A1.CTRT_OFC_CD) CTRT_RHQ" ).append("\n"); 
		query.append("                FROM COM_CTRT_NTC_INFO A1" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("              ,USR_MGMT B2" ).append("\n"); 
		query.append("        WHERE B1.SYS_CD = B2.SYS_CD" ).append("\n"); 
		query.append("          AND DECODE(B2.OFC_TP_CD, 'BB', B1.CTRT_OFC_CD, 'HQ', B1.CTRT_RHQ, 'HO', B2.CTRT_OFC_CD) = B2.CTRT_OFC_CD" ).append("\n"); 
		query.append("          AND B1.AGMT_NO LIKE DECODE(B2.AGMT_NO, 'ALL', B1.AGMT_NO, B2.AGMT_MAPG_NO)||'%'" ).append("\n"); 
		query.append("       ) C1" ).append("\n"); 
		query.append("ORDER BY C1.AGMT_EXP_DT, C1.AGMT_NO" ).append("\n"); 

	}
}