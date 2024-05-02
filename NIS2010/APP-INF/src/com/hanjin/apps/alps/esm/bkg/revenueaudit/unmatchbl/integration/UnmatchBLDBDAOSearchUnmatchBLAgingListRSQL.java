/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchUnmatchBLAgingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOSearchUnmatchBLAgingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * unmatch bl aging list를 조회한다.
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchUnmatchBLAgingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchUnmatchBLAgingListRSQL").append("\n"); 
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
		query.append("SELECT RCT_RHQ_CD" ).append("\n"); 
		query.append("      ,BKG_OFC_CD" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN ERR_BL_AGE_DYS BETWEEN 0 AND 7 THEN 1 ELSE 0 END) WITHIN_7_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN ERR_BL_AGE_DYS BETWEEN 8 AND 15 THEN 1 ELSE 0 END) WITHIN_15_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN ERR_BL_AGE_DYS BETWEEN 16 AND 30 THEN 1 ELSE 0 END) WITHIN_30_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN ERR_BL_AGE_DYS BETWEEN 31 AND 45 THEN 1 ELSE 0 END) WITHIN_45_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN ERR_BL_AGE_DYS BETWEEN 46 AND 60 THEN 1 ELSE 0 END) WITHIN_60_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN ERR_BL_AGE_DYS BETWEEN 61 AND 90 THEN 1 ELSE 0 END) WITHIN_90_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN ERR_BL_AGE_DYS > 90 THEN 1 ELSE 0 END) OVER_90_DYS" ).append("\n"); 
		query.append("      ,COUNT(1) TOTAL_CNT" ).append("\n"); 
		query.append("      ,'' BDR_FLG" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT (" ).append("\n"); 
		query.append("                SELECT A.OFC_CD" ).append("\n"); 
		query.append("                FROM   MDM_ORGANIZATION A" ).append("\n"); 
		query.append("                WHERE  A.OFC_TP_CD = 'HQ'" ).append("\n"); 
		query.append("                START  WITH A.OFC_CD = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("                CONNECT BY PRIOR A.PRNT_OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("                ) RCT_RHQ_CD  " ).append("\n"); 
		query.append("             ,BK.BKG_OFC_CD " ).append("\n"); 
		query.append("             ,DC.BDR_FLG " ).append("\n"); 
		query.append("             ,TRUNC(SYSDATE) - TRUNC(UB.N1ST_UMCH_FND_DT) ERR_BL_AGE_DYS " ).append("\n"); 
		query.append("         FROM BKG_REV_UMCH_BKG  UB" ).append("\n"); 
		query.append("             ,BKG_BOOKING       BK" ).append("\n"); 
		query.append("             ,BKG_BL_DOC        DC" ).append("\n"); 
		query.append("        WHERE BK.BKG_NO = UB.BKG_NO" ).append("\n"); 
		query.append("          AND BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("          AND EXISTS ( SELECT  'Y'" ).append("\n"); 
		query.append("                         FROM BKG_REV_UMCH_ITM ITM" ).append("\n"); 
		query.append("                         WHERE ITM.BKG_NO = UB.BKG_NO" ).append("\n"); 
		query.append("                         AND ITM.UMCH_BKG_SEQ = UB.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                         AND ITM.UMCH_BKG_SEQ = ( SELECT MAX(UMCH_BKG_SEQ) FROM BKG_REV_UMCH_ITM WHERE BKG_NO = ITM.BKG_NO ) " ).append("\n"); 
		query.append("                         AND  ROWNUM = 1" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          AND UB.REV_AUD_STS_CD = 'U'" ).append("\n"); 
		query.append("          AND BK.BKG_NO = DC.BKG_NO" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("          AND BK.BKG_OFC_CD  = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bdr_flg} != '') " ).append("\n"); 
		query.append("          AND DC.BDR_FLG = @[bdr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("  WHERE RCT_RHQ_CD IS NOT NULL" ).append("\n"); 
		query.append("#if (${rct_rhq_cd} != '') " ).append("\n"); 
		query.append("    AND RCT_RHQ_CD = @[rct_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY RCT_RHQ_CD, BKG_OFC_CD" ).append("\n"); 
		query.append("ORDER BY RCT_RHQ_CD, BKG_OFC_CD" ).append("\n"); 

	}
}