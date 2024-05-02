/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LongTxContainerMovementFinderDBDAOSearchEDIResultSumListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.11 
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

public class LongTxContainerMovementFinderDBDAOSearchEDIResultSumListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public LongTxContainerMovementFinderDBDAOSearchEDIResultSumListRSQL(){
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
		params.put("gap_radio",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : LongTxContainerMovementFinderDBDAOSearchEDIResultSumListRSQL").append("\n"); 
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
		query.append("SELECT   RCC" ).append("\n"); 
		query.append("         ,CN" ).append("\n"); 
		query.append("         ,LCC" ).append("\n"); 
		query.append("         ,LOC" ).append("\n"); 
		query.append("         ,YARD" ).append("\n"); 
		query.append("         ,SUM (TTL_CNT) - SUM (INIT_OK_CNT) - SUM (INIT_IGNR_CNT) AS INT_ERR" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (TTL_CNT) = 0 THEN 0 ELSE ROUND ((SUM (TTL_CNT) - SUM (INIT_OK_CNT) - SUM (INIT_IGNR_CNT)) / SUM (TTL_CNT) * 100, 1) END AS INT_ERR_RATIO" ).append("\n"); 
		query.append("         ,SUM (INIT_IGNR_CNT) AS INT_IGNR" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (TTL_CNT) = 0 THEN 0 ELSE ROUND (SUM (INIT_IGNR_CNT) / SUM (TTL_CNT) * 100, 1) END AS INT_IGNR_RATIO" ).append("\n"); 
		query.append("         ,SUM (INIT_OK_CNT) AS INT_OK" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (TTL_CNT) = 0 THEN 0 ELSE ROUND (SUM (INIT_OK_CNT) / SUM (TTL_CNT) * 100, 1) END AS INT_OK_RATIO" ).append("\n"); 
		query.append("         ,SUM (TTL_CNT) AS INT_TTL" ).append("\n"); 
		query.append("#if (${gap_radio} == '12')" ).append("\n"); 
		query.append("         ,SUM (GAP_12) AS EDI_12H" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (INIT_OK_CNT) = 0 THEN 0 ELSE ROUND (SUM (GAP_12) / SUM (INIT_OK_CNT) * 100, 1) END AS EDI_12H_RATIO" ).append("\n"); 
		query.append("         ,(SUM (GAP_24) + SUM (GAP_48) + SUM (GAP_OVER)) AS EDI_OVER" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (INIT_OK_CNT) = 0 THEN 0 ELSE ROUND ((SUM (GAP_24) + SUM (GAP_48) + SUM (GAP_OVER)) / SUM (INIT_OK_CNT) * 100, 1) END AS EDI_OVER_RATIO" ).append("\n"); 
		query.append("#elseif (${gap_radio} == '24')" ).append("\n"); 
		query.append("         ,(SUM (GAP_12) + SUM (GAP_24)) AS EDI_24H" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (INIT_OK_CNT) = 0 THEN 0 ELSE ROUND ((SUM (GAP_12) + SUM (GAP_24)) / SUM (INIT_OK_CNT) * 100, 1) END AS EDI_24H_RATIO" ).append("\n"); 
		query.append("         ,(SUM (GAP_48) + SUM (GAP_OVER)) AS EDI_OVER" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (INIT_OK_CNT) = 0 THEN 0 ELSE ROUND ((SUM (GAP_48) + SUM (GAP_OVER)) / SUM (INIT_OK_CNT) * 100, 1) END AS EDI_OVER_RATIO" ).append("\n"); 
		query.append("#elseif (${gap_radio} == '48')" ).append("\n"); 
		query.append("         ,(SUM (GAP_12) + SUM (GAP_24) + SUM (GAP_48)) AS EDI_48H" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (INIT_OK_CNT) = 0 THEN 0 ELSE ROUND ((SUM (GAP_12) + SUM (GAP_24) + SUM (GAP_48)) / SUM (INIT_OK_CNT) * 100, 1) END AS EDI_48H_RATIO" ).append("\n"); 
		query.append("         ,SUM (GAP_OVER) AS EDI_OVER" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (INIT_OK_CNT) = 0 THEN 0 ELSE ROUND (SUM (GAP_OVER) / SUM (INIT_OK_CNT) * 100, 1) END AS EDI_OVER_RATIO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         ,SUM (GAP_12) AS EDI_12H" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (INIT_OK_CNT) = 0 THEN 0 ELSE ROUND (SUM (GAP_12) / SUM (INIT_OK_CNT) * 100, 1) END AS EDI_12H_RATIO" ).append("\n"); 
		query.append("         ,SUM (GAP_24) AS EDI_24H" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (INIT_OK_CNT) = 0 THEN 0 ELSE ROUND (SUM (GAP_24) / SUM (INIT_OK_CNT) * 100, 1) END AS EDI_24H_RATIO" ).append("\n"); 
		query.append("         ,SUM (GAP_48) AS EDI_48H" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (INIT_OK_CNT) = 0 THEN 0 ELSE ROUND (SUM (GAP_48) / SUM (INIT_OK_CNT) * 100, 1) END AS EDI_48H_RATIO" ).append("\n"); 
		query.append("         ,SUM (GAP_OVER) AS EDI_OVER" ).append("\n"); 
		query.append("         ,CASE WHEN SUM (INIT_OK_CNT) = 0 THEN 0 ELSE ROUND (SUM (GAP_OVER) / SUM (INIT_OK_CNT) * 100, 1) END AS EDI_OVER_RATIO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         ,SUM (INIT_OK_CNT) AS EDI_TTL" ).append("\n"); 
		query.append("         ,@[p_date1] AS P_DATE1" ).append("\n"); 
		query.append("         ,@[p_date2] AS P_DATE2" ).append("\n"); 
		query.append("         ,@[gap_radio] AS GAP_RADIO" ).append("\n"); 
		query.append("    FROM (SELECT /*+ ORDERED USE_NL(MSG ML ME) */" ).append("\n"); 
		query.append("                 ME.RCC_CD AS RCC" ).append("\n"); 
		query.append("                 ,SUBSTR (EVNT_YD_CD, 1, 2) AS CN" ).append("\n"); 
		query.append("                 ,ME.LCC_CD AS LCC" ).append("\n"); 
		query.append("                 ,SUBSTR (EVNT_YD_CD, 1, 5) AS LOC" ).append("\n"); 
		query.append("                 ,EVNT_YD_CD AS YARD" ).append("\n"); 
		query.append("                 ,INIT_OK_CNT" ).append("\n"); 
		query.append("                 ,INIT_IGNR_CNT" ).append("\n"); 
		query.append("                 ,TTL_CNT" ).append("\n"); 
		query.append("                 ,GAP_12" ).append("\n"); 
		query.append("                 ,GAP_24" ).append("\n"); 
		query.append("                 ,GAP_48" ).append("\n"); 
		query.append("                 ,GAP_OVER" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                  SELECT EVNT_YD_CD" ).append("\n"); 
		query.append("                     	 ,SUM(INIT_OK_CNT) AS INIT_OK_CNT" ).append("\n"); 
		query.append(" 	                     ,SUM(INIT_IGNR_CNT) AS INIT_IGNR_CNT" ).append("\n"); 
		query.append("    	                 ,SUM(TTL_CNT) AS TTL_CNT" ).append("\n"); 
		query.append("        	             ,SUM(CASE WHEN OFFSET_DT <= 0.5 THEN CNT ELSE 0 END) AS GAP_12" ).append("\n"); 
		query.append("            	         ,SUM(CASE WHEN OFFSET_DT > 0.5 AND OFFSET_DT <= 1 THEN CNT ELSE 0 END) AS GAP_24" ).append("\n"); 
		query.append("                	     ,SUM(CASE WHEN OFFSET_DT > 1 AND OFFSET_DT <= 2 THEN CNT ELSE 0 END) AS GAP_48" ).append("\n"); 
		query.append("                    	 ,SUM(CASE WHEN OFFSET_DT > 2 THEN CNT ELSE 0 END) AS GAP_OVER" ).append("\n"); 
		query.append("                	FROM " ).append("\n"); 
		query.append("                     	 --CTM_MVMT_EDI_MSG," ).append("\n"); 
		query.append("                    	 (SELECT MSG.EVNT_YD_CD" ).append("\n"); 
		query.append("                         	     ,CASE WHEN RMK.MVMT_EDI_RSLT_CD = 'Y' THEN CEIL(ROUND((MSG.CRE_LOCL_DT - MSG.EVNT_DT),2)*10)/10 END AS OFFSET_DT" ).append("\n"); 
		query.append("	                             ,COUNT(CASE WHEN RMK.MVMT_EDI_RSLT_CD = 'Y' THEN 1 END) AS INIT_OK_CNT" ).append("\n"); 
		query.append("     	                         ,COUNT(CASE WHEN RMK.MVMT_EDI_RSLT_CD IN ('X','I') THEN 1 END) AS INIT_IGNR_CNT" ).append("\n"); 
		query.append("          	                     ,COUNT(CASE WHEN (MSG.RTY_KNT = MSG.RTY_KNT) THEN 1 END) AS TTL_CNT" ).append("\n"); 
		query.append("               		             ,COUNT(*) CNT" ).append("\n"); 
		query.append("                     		FROM CTM_MVMT_EDI_MSG MSG, CTM_EDI_RSLT_RMK RMK" ).append("\n"); 
		query.append("		                   WHERE MSG.MVMT_EDI_TP_CD = RMK.MVMT_EDI_TP_CD" ).append("\n"); 
		query.append("        		             AND MSG.MVMT_EDI_MSG_TP_ID = RMK.MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                		     AND MSG.MVMT_EDI_MSG_AREA_CD = RMK.MVMT_EDI_MSG_AREA_CD" ).append("\n"); 
		query.append("                     		 AND MSG.MVMT_EDI_MSG_YRMONDY = RMK.MVMT_EDI_MSG_YRMONDY" ).append("\n"); 
		query.append("		                     AND MSG.MVMT_EDI_MSG_SEQ = RMK.MVMT_EDI_MSG_SEQ" ).append("\n"); 
		query.append("        		             AND RMK.RTY_KNT = 0" ).append("\n"); 
		query.append("                		     AND MSG.IDX_CRE_LOCL_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("#if (${rcc_cd} == '' || ${rcc_cd} == 'ALL')" ).append("\n"); 
		query.append("                     		 AND MSG.MVMT_EDI_MSG_AREA_CD IN ('USA', 'SWA', 'KOR', 'EUR', 'CHN')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		                     AND MSG.MVMT_EDI_MSG_AREA_CD = (SELECT SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("        		                                               FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                		                                      WHERE CNT_CD = SUBSTR (@[rcc_cd], 0, 2)" ).append("\n"); 
		query.append("                        		                                AND SUBSTR (SYS_AREA_GRP_ID, 0, 1) != 'D')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_yard2} != '')" ).append("\n"); 
		query.append("                     		 AND MSG.EVNT_YD_CD = @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("#elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("		                     AND MSG.EVNT_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 		   GROUP BY MSG.EVNT_YD_CD, CASE WHEN RMK.MVMT_EDI_RSLT_CD = 'Y' THEN CEIL(ROUND((MSG.CRE_LOCL_DT - MSG.EVNT_DT),2)*10)/10 END" ).append("\n"); 
		query.append("                     	 ) " ).append("\n"); 
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
		query.append("             AND ME.SCC_CD(+) = ML.SCC_CD" ).append("\n"); 
		query.append("             AND ML.LOC_CD(+) = SUBSTR (EVNT_YD_CD, 0, 5)" ).append("\n"); 
		query.append("/*             AND MVMT_EDI_RMK = DECODE (MVMT_EDI_RSLT_CD, 'Y', 'OK.PROCESSED', MVMT_EDI_RMK)*/" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("   GROUP BY RCC, CN, LCC, LOC, YARD" ).append("\n"); 
		query.append("#if (${rcc_cd} != '' && ${rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("  HAVING RCC IN @[rcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   ORDER BY RCC, CN, LCC, LOC, YARD" ).append("\n"); 

	}
}