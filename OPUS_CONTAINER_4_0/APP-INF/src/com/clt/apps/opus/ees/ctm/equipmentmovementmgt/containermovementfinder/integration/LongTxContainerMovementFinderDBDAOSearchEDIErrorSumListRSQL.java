/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : LongTxContainerMovementFinderDBDAOSearchEDIErrorSumListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongTxContainerMovementFinderDBDAOSearchEDIErrorSumListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public LongTxContainerMovementFinderDBDAOSearchEDIErrorSumListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : LongTxContainerMovementFinderDBDAOSearchEDIErrorSumListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${data_radio} == 'RCC')" ).append("\n"); 
		query.append("         RCC" ).append("\n"); 
		query.append("#elseif (${data_radio} == 'CN')" ).append("\n"); 
		query.append("         RCC" ).append("\n"); 
		query.append("         ,CN" ).append("\n"); 
		query.append("#elseif (${data_radio} == 'LCC')" ).append("\n"); 
		query.append("         RCC" ).append("\n"); 
		query.append("         ,CN" ).append("\n"); 
		query.append("         ,LCC" ).append("\n"); 
		query.append("#elseif (${data_radio} == 'LOC')" ).append("\n"); 
		query.append("         RCC" ).append("\n"); 
		query.append("         ,CN" ).append("\n"); 
		query.append("         ,LCC" ).append("\n"); 
		query.append("         ,LOC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         RCC" ).append("\n"); 
		query.append("         ,CN" ).append("\n"); 
		query.append("         ,LCC" ).append("\n"); 
		query.append("         ,LOC" ).append("\n"); 
		query.append("         ,YARD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         ,SUM (RMN_ERR_CNT) AS CORR_ERR" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (RMN_ERR_CNT) + SUM (RMN_IGNR_CNT) + SUM (RMN_OK_CNT) = 0 THEN 0 ELSE ROUND (SUM (RMN_ERR_CNT) / (SUM (RMN_ERR_CNT) + SUM (RMN_IGNR_CNT) + SUM (RMN_OK_CNT)) * 100, 1) END AS CORR_ERR_RATIO" ).append("\n"); 
		query.append("         ,SUM (RMN_IGNR_CNT) AS CORR_IGNR" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (RMN_ERR_CNT) + SUM (RMN_IGNR_CNT) + SUM (RMN_OK_CNT) = 0 THEN 0 ELSE ROUND (SUM (RMN_IGNR_CNT) / (SUM (RMN_ERR_CNT) + SUM (RMN_IGNR_CNT) + SUM (RMN_OK_CNT)) * 100, 1) END AS CORR_IGNR_RATIO" ).append("\n"); 
		query.append("         ,SUM (RMN_OK_CNT) AS CORR_OK" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (RMN_ERR_CNT) + SUM (RMN_IGNR_CNT) + SUM (RMN_OK_CNT) = 0 THEN 0 ELSE ROUND (SUM (RMN_OK_CNT) / (SUM (RMN_ERR_CNT) + SUM (RMN_IGNR_CNT) + SUM (RMN_OK_CNT)) * 100, 1) END AS CORR_OK_RATIO" ).append("\n"); 
		query.append("         ,SUM (RMN_ERR_CNT) + SUM (RMN_IGNR_CNT) + SUM (RMN_OK_CNT) AS CORR_TTL" ).append("\n"); 
		query.append("         ,SUM (SLVD_ERR_CNT) AS SLVD_ERR" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (TOTAL_CNT) - SUM (INIT_OK_CNT) - SUM (INIT_IGNR_CNT) = 0 THEN 0 ELSE ROUND (SUM (SLVD_ERR_CNT) / (SUM (TOTAL_CNT) - SUM (INIT_OK_CNT) - SUM (INIT_IGNR_CNT)) * 100, 1) END AS SLVD_ERR_RATIO" ).append("\n"); 
		query.append("         ,SUM (SLVD_IGNR_CNT) AS SLVD_IGNR" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (INIT_IGNR_CNT) = 0 THEN 0 ELSE ROUND (SUM (SLVD_IGNR_CNT) / (SUM (INIT_IGNR_CNT)) * 100, 1) END AS SLVD_IGNR_RATIO" ).append("\n"); 
		query.append("         ,SUM (SLVD_ERR_CNT) + SUM (SLVD_IGNR_CNT) AS SLVD_TTL" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (TOTAL_CNT) - SUM (INIT_OK_CNT) = 0 THEN 0 ELSE ROUND ((SUM (SLVD_ERR_CNT) + SUM (SLVD_IGNR_CNT)) / (SUM (TOTAL_CNT) - SUM (INIT_OK_CNT)) * 100, 1) END AS SLVD_TTL_RATIO" ).append("\n"); 
		query.append("         ,SUM (TOTAL_CNT) - SUM (INIT_OK_CNT) - SUM (INIT_IGNR_CNT) AS INIT_ERR" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (TOTAL_CNT) = 0 THEN 0 ELSE ROUND ((SUM (TOTAL_CNT) - SUM (INIT_OK_CNT) - SUM (INIT_IGNR_CNT)) / SUM (TOTAL_CNT) * 100, 1) END AS INIT_ERR_RATIO" ).append("\n"); 
		query.append("         ,SUM (INIT_IGNR_CNT) AS INIT_IGNR" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (TOTAL_CNT) = 0 THEN 0 ELSE ROUND (SUM (INIT_IGNR_CNT) / SUM (TOTAL_CNT) * 100, 1) END AS INIT_IGNR_RATIO" ).append("\n"); 
		query.append("         ,SUM (INIT_OK_CNT) AS INIT_OK" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (TOTAL_CNT) = 0 THEN 0 ELSE ROUND (SUM (INIT_OK_CNT) / SUM (TOTAL_CNT) * 100, 1) END AS INIT_OK_RATIO" ).append("\n"); 
		query.append("         ,SUM (TOTAL_CNT) as INIT_TTL" ).append("\n"); 
		query.append("         ,@[p_date1] AS P_DATE1" ).append("\n"); 
		query.append("         ,@[p_date2] AS P_DATE2" ).append("\n"); 
		query.append("    FROM (SELECT /*+ ORDERED USE_NL(MSG ML ME) */" ).append("\n"); 
		query.append("                 ME.RCC_CD AS RCC" ).append("\n"); 
		query.append("                 ,SUBSTR (EVNT_YD_CD, 0, 2) AS CN" ).append("\n"); 
		query.append("                 ,ME.LCC_CD AS LCC" ).append("\n"); 
		query.append("                 ,SUBSTR (EVNT_YD_CD, 0, 5) AS LOC" ).append("\n"); 
		query.append("                 ,EVNT_YD_CD AS YARD" ).append("\n"); 
		query.append("                 ,INIT_OK_CNT" ).append("\n"); 
		query.append("                 ,INIT_IGNR_CNT" ).append("\n"); 
		query.append("                 ,TOTAL_CNT" ).append("\n"); 
		query.append("                 ,SLVD_ERR_CNT" ).append("\n"); 
		query.append("                 ,SLVD_IGNR_CNT" ).append("\n"); 
		query.append("                 ,RMN_ERR_CNT" ).append("\n"); 
		query.append("                 ,RMN_IGNR_CNT" ).append("\n"); 
		query.append("                 ,RMN_OK_CNT" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                  SELECT EVNT_YD_CD" ).append("\n"); 
		query.append("                     	 ,SUM(CASE WHEN CRE_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '') THEN INIT_OK_CNT ELSE 0  END) AS INIT_OK_CNT" ).append("\n"); 
		query.append("	                     ,SUM(CASE WHEN CRE_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '') THEN INIT_IGNR_CNT ELSE 0  END) AS INIT_IGNR_CNT" ).append("\n"); 
		query.append("    	                 ,SUM(CASE WHEN CRE_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '') THEN TOTAL_CNT ELSE 0  END) AS TOTAL_CNT" ).append("\n"); 
		query.append("                     #if (${slvd_cnt_dt} == 'S')" ).append("\n"); 
		query.append("                	     ,SUM(CASE WHEN UPD_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '') THEN SLVD_ERR_CNT ELSE 0  END) AS SLVD_ERR_CNT" ).append("\n"); 
		query.append("                    	 ,SUM(CASE WHEN UPD_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '') THEN SLVD_IGNR_CNT ELSE 0  END) AS SLVD_IGNR_CNT" ).append("\n"); 
		query.append("                     #else" ).append("\n"); 
		query.append("        	             ,SUM(CASE WHEN CRE_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '') THEN SLVD_ERR_CNT ELSE 0  END) AS SLVD_ERR_CNT" ).append("\n"); 
		query.append("            	         ,SUM(CASE WHEN CRE_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '') THEN SLVD_IGNR_CNT ELSE 0  END) AS SLVD_IGNR_CNT" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("	                     ,SUM(CASE WHEN CRE_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '') THEN RMN_ERR_CNT ELSE 0  END) AS RMN_ERR_CNT" ).append("\n"); 
		query.append("    	                 ,SUM(CASE WHEN CRE_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '') THEN RMN_IGNR_CNT ELSE 0  END) AS RMN_IGNR_CNT" ).append("\n"); 
		query.append("        	             ,SUM(CASE WHEN CRE_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '') THEN RMN_OK_CNT ELSE 0  END) AS RMN_OK_CNT" ).append("\n"); 
		query.append("            	    FROM " ).append("\n"); 
		query.append("                	     (SELECT MSG.EVNT_YD_CD" ).append("\n"); 
		query.append("                            	 ,CEIL(MSG.IDX_CRE_LOCL_DT) AS CRE_DT" ).append("\n"); 
		query.append("                                 #if (${slvd_cnt_dt} == 'S')" ).append("\n"); 
		query.append("	                             ,CEIL(TO_CHAR(MSG.UPD_LOCL_DT, 'YYYYMMDD')) AS UPD_DT" ).append("\n"); 
		query.append("                                 #end" ).append("\n"); 
		query.append("    	                         ,COUNT(CASE WHEN RMK.MVMT_EDI_RSLT_CD = 'Y' THEN 1 END) AS INIT_OK_CNT" ).append("\n"); 
		query.append("          	                     ,COUNT(CASE WHEN RMK.MVMT_EDI_RSLT_CD IN ('X', 'I') THEN 1 END) AS INIT_IGNR_CNT" ).append("\n"); 
		query.append("               		             ,COUNT(CASE WHEN MSG.RTY_KNT = MSG.RTY_KNT THEN 1 END) AS TOTAL_CNT" ).append("\n"); 
		query.append("                    	         ,COUNT(CASE WHEN MSG.MVMT_EDI_RSLT_CD IN ('D', 'Y') " ).append("\n"); 
		query.append("                                              AND RMK.MVMT_EDI_RSLT_CD = 'N' THEN 1 END) AS SLVD_ERR_CNT" ).append("\n"); 
		query.append("                         		 ,COUNT(CASE WHEN MSG.MVMT_EDI_RSLT_CD IN ('D', 'Y')" ).append("\n"); 
		query.append("                                              AND RMK.MVMT_EDI_RSLT_CD IN ('X', 'I') THEN 1 END) AS SLVD_IGNR_CNT" ).append("\n"); 
		query.append("	                             ,COUNT(CASE WHEN MSG.MVMT_EDI_RSLT_CD = 'N' THEN 1 END) AS RMN_ERR_CNT" ).append("\n"); 
		query.append("     	                         ,COUNT(CASE WHEN MSG.MVMT_EDI_RSLT_CD IN ('X','I') THEN 1 END) AS RMN_IGNR_CNT" ).append("\n"); 
		query.append("          	                     ,COUNT(CASE WHEN MSG.MVMT_EDI_RSLT_CD = 'Y' THEN 1 END) AS RMN_OK_CNT" ).append("\n"); 
		query.append("                     		FROM CTM_MVMT_EDI_MSG MSG, CTM_EDI_RSLT_RMK RMK" ).append("\n"); 
		query.append("	                       WHERE MSG.MVMT_EDI_TP_CD = RMK.MVMT_EDI_TP_CD" ).append("\n"); 
		query.append("      		                 AND MSG.MVMT_EDI_MSG_TP_ID = RMK.MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("               		         AND MSG.MVMT_EDI_MSG_AREA_CD = RMK.MVMT_EDI_MSG_AREA_CD" ).append("\n"); 
		query.append(" 		                     AND MSG.MVMT_EDI_MSG_YRMONDY = RMK.MVMT_EDI_MSG_YRMONDY" ).append("\n"); 
		query.append("        		             AND MSG.MVMT_EDI_MSG_SEQ = RMK.MVMT_EDI_MSG_SEQ" ).append("\n"); 
		query.append("                		     AND RMK.RTY_KNT = 0" ).append("\n"); 
		query.append("        #if (${rcc_cd} == '' || ${rcc_cd} == 'ALL')" ).append("\n"); 
		query.append("		                     AND MSG.MVMT_EDI_MSG_AREA_CD IN ('USA', 'SWA', 'KOR', 'EUR', 'CHN')" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("        		             AND MSG.MVMT_EDI_MSG_AREA_CD = (SELECT SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("                		                                       FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                        		                              WHERE CNT_CD = SUBSTR (@[rcc_cd], 0, 2))" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                             #if (${slvd_cnt_dt} == 'S')" ).append("\n"); 
		query.append("                             AND (CEIL(MSG.IDX_CRE_LOCL_DT) BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("                                 OR CEIL(TO_CHAR(MSG.UPD_LOCL_DT, 'YYYYMMDD')) BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', ''))" ).append("\n"); 
		query.append("                             #else" ).append("\n"); 
		query.append("                             AND CEIL(MSG.IDX_CRE_LOCL_DT) BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("                             #end" ).append("\n"); 
		query.append("        #if (${p_yard2} != '')" ).append("\n"); 
		query.append("		                     AND MSG.EVNT_YD_CD = @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("        #elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("        		             AND MSG.EVNT_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                	       GROUP BY MSG.EVNT_YD_CD, CEIL(MSG.IDX_CRE_LOCL_DT)" ).append("\n"); 
		query.append("                                 #if (${slvd_cnt_dt} == 'S')" ).append("\n"); 
		query.append("                                    , CEIL(TO_CHAR(MSG.UPD_LOCL_DT, 'YYYYMMDD'))" ).append("\n"); 
		query.append("                                 #end" ).append("\n"); 
		query.append("                    	 )" ).append("\n"); 
		query.append("                   GROUP BY EVNT_YD_CD" ).append("\n"); 
		query.append("                 ) MSG" ).append("\n"); 
		query.append("                 ,MDM_LOCATION ML" ).append("\n"); 
		query.append("                 ,MDM_EQ_ORZ_CHT ME" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("#if (${rcc_cd} != '' && ${rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("             AND ME.RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lcc_cd} != '')" ).append("\n"); 
		query.append("             AND ME.LCC_CD = @[lcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             AND ML.SCC_CD = ME.SCC_CD(+)" ).append("\n"); 
		query.append("             AND SUBSTR (EVNT_YD_CD, 0, 5) = ML.LOC_CD(+)" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#if (${data_radio} == 'RCC')" ).append("\n"); 
		query.append("   GROUP BY RCC" ).append("\n"); 
		query.append("   ORDER BY RCC" ).append("\n"); 
		query.append("#elseif (${data_radio} == 'CN')" ).append("\n"); 
		query.append("   GROUP BY RCC, CN" ).append("\n"); 
		query.append("   ORDER BY RCC, CN" ).append("\n"); 
		query.append("#elseif (${data_radio} == 'LCC')" ).append("\n"); 
		query.append("   GROUP BY RCC, CN, LCC" ).append("\n"); 
		query.append("   ORDER BY RCC, CN, LCC" ).append("\n"); 
		query.append("#elseif (${data_radio} == 'LOC')" ).append("\n"); 
		query.append("   GROUP BY RCC, CN, LCC, LOC" ).append("\n"); 
		query.append("   ORDER BY RCC, CN, LCC, LOC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   GROUP BY RCC, CN, LCC, LOC, YARD" ).append("\n"); 
		query.append("   ORDER BY RCC, CN, LCC, LOC, YARD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}