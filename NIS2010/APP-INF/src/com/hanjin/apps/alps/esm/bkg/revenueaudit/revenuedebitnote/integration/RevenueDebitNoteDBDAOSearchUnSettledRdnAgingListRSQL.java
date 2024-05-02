/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOSearchUnSettledRdnAgingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOSearchUnSettledRdnAgingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * unsettled rdn aging list를 조회한다.
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOSearchUnSettledRdnAgingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOSearchUnSettledRdnAgingListRSQL").append("\n"); 
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
		query.append("      ,(SELECT UMCH_TP_DESC FROM BKG_REV_UMCH_TP WHERE UMCH_TP_CD = BKG.UMCH_TP_CD) UMCH_TP_CD" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 0 AND 10 THEN 1 ELSE 0 END) WITHIN_10_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 11 AND 20 THEN 1 ELSE 0 END) WITHIN_20_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 21 AND 30 THEN 1 ELSE 0 END) WITHIN_30_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 31 AND 60 THEN 1 ELSE 0 END) WITHIN_60_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 61 AND 90 THEN 1 ELSE 0 END) WITHIN_90_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS > 90 THEN 1 ELSE 0 END) OVER_90_DYS" ).append("\n"); 
		query.append("      ,COUNT(1) TOTAL_CNT" ).append("\n"); 
		query.append("      ,'' rdn_knd_cd" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT  DR.RCT_RHQ_CD" ).append("\n"); 
		query.append("               ,DR.RCT_OFC_CD BKG_OFC_CD" ).append("\n"); 
		query.append("               ,DR.UMCH_TP_CD" ).append("\n"); 
		query.append("               ,TRUNC(SYSDATE) - TRUNC(DR.RDN_ISS_DT) RDN_AGE_DYS" ).append("\n"); 
		query.append("          FROM BKG_REV_DR_NOTE DR" ).append("\n"); 
		query.append("          WHERE ( DR.RDN_NO, DR.RVIS_SEQ )  IN  (" ).append("\n"); 
		query.append("                                                    SELECT  RDN_NO        ," ).append("\n"); 
		query.append("                                                            MAX(RVIS_SEQ)" ).append("\n"); 
		query.append("                                                    FROM    BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("                                                    GROUP BY" ).append("\n"); 
		query.append("                                                            RDN_NO" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("            AND DR.RDN_STS_CD NOT IN ('CL','CV','ST') -- UNSETTLE건만" ).append("\n"); 
		query.append("#if (${rdn_knd_cd} != '') " ).append("\n"); 
		query.append("            AND DR.RDN_KND_CD = @[rdn_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_rhq_cd} != '') " ).append("\n"); 
		query.append("            AND DR.RCT_RHQ_CD = @[rct_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("            AND DR.RCT_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) BKG" ).append("\n"); 
		query.append("WHERE RCT_RHQ_CD IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY RCT_RHQ_CD, BKG_OFC_CD, UMCH_TP_CD" ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("SELECT RCT_RHQ_CD" ).append("\n"); 
		query.append("      ,'' BKG_OFC_CD" ).append("\n"); 
		query.append("      ,(SELECT UMCH_TP_DESC FROM BKG_REV_UMCH_TP WHERE UMCH_TP_CD = BKG.UMCH_TP_CD) UMCH_TP_CD" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 0 AND 10 THEN 1 ELSE 0 END) WITHIN_10_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 11 AND 20 THEN 1 ELSE 0 END) WITHIN_20_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 21 AND 30 THEN 1 ELSE 0 END) WITHIN_30_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 31 AND 60 THEN 1 ELSE 0 END) WITHIN_60_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 61 AND 90 THEN 1 ELSE 0 END) WITHIN_90_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS > 90 THEN 1 ELSE 0 END) OVER_90_DYS" ).append("\n"); 
		query.append("      ,COUNT(1) TOTAL_CNT" ).append("\n"); 
		query.append("      ,'' rdn_knd_cd" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT  DR.RCT_RHQ_CD" ).append("\n"); 
		query.append("               ,DR.RCT_OFC_CD BKG_OFC_CD" ).append("\n"); 
		query.append("               ,DR.UMCH_TP_CD" ).append("\n"); 
		query.append("               ,TRUNC(SYSDATE) - TRUNC(DR.RDN_ISS_DT) RDN_AGE_DYS" ).append("\n"); 
		query.append("          FROM BKG_REV_DR_NOTE DR" ).append("\n"); 
		query.append("          WHERE ( DR.RDN_NO, DR.RVIS_SEQ )  IN  (" ).append("\n"); 
		query.append("                                                    SELECT  RDN_NO        ," ).append("\n"); 
		query.append("                                                            MAX(RVIS_SEQ)" ).append("\n"); 
		query.append("                                                    FROM    BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("                                                    GROUP BY" ).append("\n"); 
		query.append("                                                            RDN_NO" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("            AND DR.RDN_STS_CD NOT IN ('CL','CV','ST') -- UNSETTLE건만" ).append("\n"); 
		query.append("#if (${rdn_knd_cd} != '') " ).append("\n"); 
		query.append("            AND DR.RDN_KND_CD = @[rdn_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_rhq_cd} != '') " ).append("\n"); 
		query.append("            AND DR.RCT_RHQ_CD = @[rct_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("            AND DR.RCT_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ) BKG" ).append("\n"); 
		query.append("WHERE RCT_RHQ_CD IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY RCT_RHQ_CD, UMCH_TP_CD" ).append("\n"); 
		query.append("#if (${rct_rhq_cd} == '') " ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("SELECT '' RCT_RHQ_CD" ).append("\n"); 
		query.append("      ,'Total' BKG_OFC_CD" ).append("\n"); 
		query.append("      ,(SELECT UMCH_TP_DESC FROM BKG_REV_UMCH_TP WHERE UMCH_TP_CD = BKG.UMCH_TP_CD) UMCH_TP_CD" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 0 AND 10 THEN 1 ELSE 0 END) WITHIN_10_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 11 AND 20 THEN 1 ELSE 0 END) WITHIN_20_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 21 AND 30 THEN 1 ELSE 0 END) WITHIN_30_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 31 AND 60 THEN 1 ELSE 0 END) WITHIN_60_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS BETWEEN 61 AND 90 THEN 1 ELSE 0 END) WITHIN_90_DYS" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN RDN_AGE_DYS > 90 THEN 1 ELSE 0 END) OVER_90_DYS" ).append("\n"); 
		query.append("      ,COUNT(1) TOTAL_CNT" ).append("\n"); 
		query.append("      ,'' rdn_knd_cd" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT  DR.RCT_RHQ_CD" ).append("\n"); 
		query.append("               ,DR.RCT_OFC_CD BKG_OFC_CD" ).append("\n"); 
		query.append("               ,DR.UMCH_TP_CD" ).append("\n"); 
		query.append("               ,TRUNC(SYSDATE) - TRUNC(DR.RDN_ISS_DT) RDN_AGE_DYS" ).append("\n"); 
		query.append("          FROM BKG_REV_DR_NOTE DR" ).append("\n"); 
		query.append("          WHERE ( DR.RDN_NO, DR.RVIS_SEQ )  IN  (" ).append("\n"); 
		query.append("                                                    SELECT  RDN_NO        ," ).append("\n"); 
		query.append("                                                            MAX(RVIS_SEQ)" ).append("\n"); 
		query.append("                                                    FROM    BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("                                                    GROUP BY" ).append("\n"); 
		query.append("                                                            RDN_NO" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("            AND DR.RDN_STS_CD NOT IN ('CL','CV','ST') -- UNSETTLE건만" ).append("\n"); 
		query.append("#if (${rdn_knd_cd} != '') " ).append("\n"); 
		query.append("            AND DR.RDN_KND_CD = @[rdn_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_rhq_cd} != '') " ).append("\n"); 
		query.append("            AND DR.RCT_RHQ_CD = @[rct_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("            AND DR.RCT_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ) BKG" ).append("\n"); 
		query.append("WHERE RCT_RHQ_CD IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY UMCH_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RCT_RHQ_CD, BKG_OFC_CD, UMCH_TP_CD" ).append("\n"); 

	}
}