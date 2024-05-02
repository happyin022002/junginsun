/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOMASCreateMonitorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.27
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.08.27 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOMASCreateMonitorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MAS Create Monitor 를 조회한다.
	  * </pre>
	  */
	public NetworkCostDBDAOMASCreateMonitorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_chkcost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOMASCreateMonitorRSQL").append("\n"); 
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
		query.append("SELECT  @[f_year]||@[f_fm_mon] AS COST_YRMON" ).append("\n"); 
		query.append("       ,@[f_year]||@[f_fm_wk] AS COST_WK" ).append("\n"); 
		query.append("       ,CASE WHEN SUBSTR(CM_UC_CD,1,2) IN ('CH','OS','OT') THEN" ).append("\n"); 
		query.append("             CASE WHEN CM_UC_CD != 'CHZC' THEN" ).append("\n"); 
		query.append("                  ''" ).append("\n"); 
		query.append("             ELSE" ).append("\n"); 
		query.append("                  TO_CHAR(to_DATE(@[f_year]||@[f_fm_mon],'YYYYMM'),'Q')||'Q'" ).append("\n"); 
		query.append("             END" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("             ''" ).append("\n"); 
		query.append("        END AS COST_QTR " ).append("\n"); 
		query.append("       ,MGRP_COST_CD_DESC" ).append("\n"); 
		query.append("       ,STND_COST_NM" ).append("\n"); 
		query.append("       ,COST_CRE_STS_CD" ).append("\n"); 
		query.append("       ,UPD_USR_ID " ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("       ,ACCT_DP_SEQ" ).append("\n"); 
		query.append("       ,MGRP_COST_CD" ).append("\n"); 
		query.append("  FROM (        " ).append("\n"); 
		query.append("        SELECT         " ).append("\n"); 
		query.append("                DTL.COST_YRMON      " ).append("\n"); 
		query.append("               ,SUBSTR(DTL.COST_YRMON,1,4)||DTL.COST_WK AS COST_WK" ).append("\n"); 
		query.append("			   ,DECODE(NVL(DTL.COST_WK,'00'),'',DTL.COST_WK) AS QTR" ).append("\n"); 
		query.append("               ,MST.MGRP_COST_CD_DESC AS MGRP_COST_CD_DESC" ).append("\n"); 
		query.append("               ,MST.STND_COST_NM      AS STND_COST_NM" ).append("\n"); 
		query.append("               ,DECODE(NVL(DTL.COST_CRE_STS_CD,'N'),'C','Success','E','Error','N','Not Create','P','Processing') AS COST_CRE_STS_CD" ).append("\n"); 
		query.append("               ,DTL.UPD_USR_ID " ).append("\n"); 
		query.append("               ,DTL.UPD_DT" ).append("\n"); 
		query.append("               ,LPAD(ACCT_DP_SEQ,2,'0') AS ACCT_DP_SEQ" ).append("\n"); 
		query.append("               ,MST.MGRP_COST_CD" ).append("\n"); 
		query.append("               ,MST.CM_UC_CD" ).append("\n"); 
		query.append("          FROM MAS_UT_COST_CRE_MST MST," ).append("\n"); 
		query.append("               MAS_UT_COST_CRE_STS DTL" ).append("\n"); 
		query.append("         WHERE MST.CM_UC_CD = DTL.CM_UC_CD(+)" ).append("\n"); 
		query.append("        #if(${f_chkprd} =='M') " ).append("\n"); 
		query.append("           AND (DTL.COST_YRMON(+) = @[f_year]||@[f_fm_mon])" ).append("\n"); 
		query.append("           AND SUBSTR(MST.CM_UC_CD,1,2) NOT IN ('CH','OS','OT')" ).append("\n"); 
		query.append("           AND MST.CM_UC_CD NOT IN ('OW17', 'OW07', 'OW12', 'OW09')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("           AND SUBSTR(DTL.COST_YRMON(+),1,4)||DTL.COST_WK(+) = @[f_year]||@[f_fm_wk]" ).append("\n"); 
		query.append("           AND SUBSTR(MST.CM_UC_CD,1,2) NOT IN ('AC', 'DM', 'CH', 'OS', 'OT', 'OF', 'OC', 'OV', 'OL')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if(${f_chkcost} =='NT') " ).append("\n"); 
		query.append("               AND MST.MGRP_COST_CD IN ('NT','NP')" ).append("\n"); 
		query.append("        #elseif(${f_chkcost} =='PO') " ).append("\n"); 
		query.append("               AND MST.MGRP_COST_CD IN ('PO','NP')" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("           AND MST.MGRP_COST_CD = @[f_chkcost]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("        #if(${f_chkprd} =='M') " ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            SELECT             " ).append("\n"); 
		query.append("                    DTL.COST_YRMON " ).append("\n"); 
		query.append("			       ,SUBSTR(DTL.COST_YRMON,1,4)||DTL.COST_WK AS COST_WK" ).append("\n"); 
		query.append("       			   ,DECODE(NVL(DTL.COST_WK,'00'),'',DTL.COST_WK) AS QTR" ).append("\n"); 
		query.append("                   ,MST.MGRP_COST_CD_DESC AS MENU" ).append("\n"); 
		query.append("                   ,MST.STND_COST_NM      AS STND_COST_NM" ).append("\n"); 
		query.append("                   ,DECODE(NVL(DTL.COST_CRE_STS_CD,'N'),'C','Success','E','Error','N','Not Create','P','Processing') AS COST_CRE_STS_CD" ).append("\n"); 
		query.append("                   ,DTL.UPD_USR_ID " ).append("\n"); 
		query.append("                   ,DTL.UPD_DT" ).append("\n"); 
		query.append("                   ,LPAD(ACCT_DP_SEQ,2,'0') AS ACCT_DP_SEQ" ).append("\n"); 
		query.append("                   ,MST.MGRP_COST_CD" ).append("\n"); 
		query.append("                   ,MST.CM_UC_CD" ).append("\n"); 
		query.append("              FROM MAS_UT_COST_CRE_MST MST," ).append("\n"); 
		query.append("                   MAS_UT_COST_CRE_STS DTL" ).append("\n"); 
		query.append("             WHERE MST.CM_UC_CD = DTL.CM_UC_CD(+)" ).append("\n"); 
		query.append("               AND substr(DTL.COST_YRMON(+),1,4) = @[f_year]" ).append("\n"); 
		query.append("               AND DTL.COST_WK(+) = TO_CHAR(to_DATE(@[f_year]||@[f_fm_mon],'YYYYMM'),'Q')||'Q'" ).append("\n"); 
		query.append("               AND SUBSTR(MST.CM_UC_CD,1,2) IN ('CH','OS','OT')" ).append("\n"); 
		query.append("               AND MST.CM_UC_CD NOT IN ('OW17', 'OW07', 'OW12', 'OW09')" ).append("\n"); 
		query.append("            #if(${f_chkcost} =='NT') " ).append("\n"); 
		query.append("               AND MST.MGRP_COST_CD IN ('NT','NP')" ).append("\n"); 
		query.append("            #elseif(${f_chkcost} =='PO') " ).append("\n"); 
		query.append("               AND MST.MGRP_COST_CD IN ('PO','NP')" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("               AND MST.MGRP_COST_CD = @[f_chkcost]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" ORDER BY ACCT_DP_SEQ ASC" ).append("\n"); 

	}
}