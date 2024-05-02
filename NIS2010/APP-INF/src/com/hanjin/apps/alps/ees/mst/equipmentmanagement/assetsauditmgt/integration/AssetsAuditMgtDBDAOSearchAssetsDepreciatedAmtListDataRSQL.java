/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AssetsAuditMgtDBDAOSearchAssetsDepreciatedAmtListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetsAuditMgtDBDAOSearchAssetsDepreciatedAmtListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ALPS & FA 시스템에 Type/Size 별 대수, 잔존 가치 합, 평균값을 조회
	  * </pre>
	  */
	public AssetsAuditMgtDBDAOSearchAssetsDepreciatedAmtListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yr_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration").append("\n"); 
		query.append("FileName : AssetsAuditMgtDBDAOSearchAssetsDepreciatedAmtListDataRSQL").append("\n"); 
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
		query.append("SELECT DECODE(GRP, 1, 'G.TTL', NVL(EQ_TPSZ_CD, 'FA Olny')) AS EQ_TPSZ_CD ," ).append("\n"); 
		query.append("       ALPS_QTY," ).append("\n"); 
		query.append("       ROUND(ALPS_AMT) AS ALPS_AMT," ).append("\n"); 
		query.append("       DECODE(ALPS_QTY, 0, 0, ROUND((ALPS_AMT/ALPS_QTY), 1)) AS ALPS_AVG ," ).append("\n"); 
		query.append("       FA_QTY ," ).append("\n"); 
		query.append("       ROUND(FA_AMT ) AS FA_AMT ," ).append("\n"); 
		query.append("       DECODE(FA_QTY , 0, 0, ROUND((FA_AMT /FA_QTY ), 1)) AS FA_AVG" ).append("\n"); 
		query.append("  FROM ( " ).append("\n"); 
		query.append("#if (${eq_type} == 'U')" ).append("\n"); 
		query.append("        SELECT T1.EQ_TPSZ_CD ," ).append("\n"); 
		query.append("               SUM(DECODE(EQ_FA_AUD_RSLT_CD, 'F', 0, 1 )) AS ALPS_QTY ," ).append("\n"); 
		query.append("               SUM(DECODE(EQ_FA_AUD_RSLT_CD, 'F', 0, NVL(T3.DPC_VAL_AMT, 0))) AS ALPS_AMT ," ).append("\n"); 
		query.append("               SUM(DECODE(EQ_FA_AUD_RSLT_CD, 'M', 0, 1 )) AS FA_QTY ," ).append("\n"); 
		query.append("               SUM(DECODE(EQ_FA_AUD_RSLT_CD, 'M', 0, NVL(T4.DPC_VAL_AMT, 0))) AS FA_AMT ," ).append("\n"); 
		query.append("               GROUPING(T1.EQ_TPSZ_CD) AS GRP" ).append("\n"); 
		query.append("          FROM MST_EQ_ASET_AUD_RSLT T1," ).append("\n"); 
		query.append("               MDM_CNTR_TP_SZ T2," ).append("\n"); 
		query.append("               MST_EQ_ASET_MST T3," ).append("\n"); 
		query.append("               MST_EQ_ASET_FA T4" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND T1.EQ_TPSZ_CD = T2.CNTR_TPSZ_CD (+)" ).append("\n"); 
		query.append("           AND T1.JB_EXE_YRMON = T3.JB_EXE_YRMON (+)" ).append("\n"); 
		query.append("           AND T1.VER_NO = T3.VER_NO (+)" ).append("\n"); 
		query.append("           AND T1.EQ_KND_CD = T3.EQ_KND_CD (+)" ).append("\n"); 
		query.append("           AND T1.EQ_NO = SUBSTR(T3.EQ_NO(+), 1, 10)" ).append("\n"); 
		query.append("           AND T1.JB_EXE_YRMON = T4.JB_EXE_YRMON (+)" ).append("\n"); 
		query.append("           AND T1.VER_NO = T4.VER_NO (+)" ).append("\n"); 
		query.append("           AND T1.EQ_KND_CD = T4.EQ_KND_CD (+)" ).append("\n"); 
		query.append("           AND T1.EQ_NO = SUBSTR(T4.EQ_NO(+), 1, 10)" ).append("\n"); 
		query.append("           AND T1.JB_EXE_YRMON = REPLACE(NVL(@[yr_mon],'0'),'-','') -- :JB_EXE_YRMON" ).append("\n"); 
		query.append("           AND T1.VER_NO = @[ver_no] -- :VER_NO" ).append("\n"); 
		query.append("           AND T1.EQ_KND_CD = @[eq_type] -- :eq_type" ).append("\n"); 
		query.append("         GROUP BY GROUPING SETS((T1.EQ_TPSZ_CD," ).append("\n"); 
		query.append("                               RPT_DP_SEQ), ())" ).append("\n"); 
		query.append("         ORDER BY RPT_DP_SEQ, GRP " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        SELECT T1.EQ_TPSZ_CD ," ).append("\n"); 
		query.append("               SUM(DECODE(EQ_FA_AUD_RSLT_CD, 'F', 0, 1 )) AS ALPS_QTY ," ).append("\n"); 
		query.append("               SUM(DECODE(EQ_FA_AUD_RSLT_CD, 'F', 0, NVL(T3.DPC_VAL_AMT, 0))) AS ALPS_AMT ," ).append("\n"); 
		query.append("               SUM(DECODE(EQ_FA_AUD_RSLT_CD, 'M', 0, 1 )) AS FA_QTY ," ).append("\n"); 
		query.append("               SUM(DECODE(EQ_FA_AUD_RSLT_CD, 'M', 0, NVL(T4.DPC_VAL_AMT, 0))) AS FA_AMT ," ).append("\n"); 
		query.append("               GROUPING(T1.EQ_TPSZ_CD) AS GRP" ).append("\n"); 
		query.append("          FROM MST_EQ_ASET_AUD_RSLT T1," ).append("\n"); 
		query.append("               CGM_EQ_TP_SZ T2," ).append("\n"); 
		query.append("               MST_EQ_ASET_MST T3," ).append("\n"); 
		query.append("               MST_EQ_ASET_FA T4" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND T1.EQ_TPSZ_CD = T2.EQ_TPSZ_CD (+)" ).append("\n"); 
		query.append("           AND T1.JB_EXE_YRMON = T3.JB_EXE_YRMON (+)" ).append("\n"); 
		query.append("           AND T1.VER_NO = T3.VER_NO (+)" ).append("\n"); 
		query.append("           AND T1.EQ_KND_CD = T3.EQ_KND_CD (+)" ).append("\n"); 
		query.append("           AND T1.EQ_NO = SUBSTR(T3.EQ_NO(+), 1, 10)" ).append("\n"); 
		query.append("           AND T1.JB_EXE_YRMON = T4.JB_EXE_YRMON (+)" ).append("\n"); 
		query.append("           AND T1.VER_NO = T4.VER_NO (+)" ).append("\n"); 
		query.append("           AND T1.EQ_KND_CD = T4.EQ_KND_CD (+)" ).append("\n"); 
		query.append("           AND T1.EQ_NO = SUBSTR(T4.EQ_NO(+), 1, 10)" ).append("\n"); 
		query.append("           AND T1.JB_EXE_YRMON = REPLACE(NVL(@[yr_mon],'0'),'-','') -- :JB_EXE_YRMON" ).append("\n"); 
		query.append("           AND T1.VER_NO = @[ver_no] -- :VER_NO" ).append("\n"); 
		query.append("           AND T1.EQ_KND_CD = @[eq_type] -- :eq_type        " ).append("\n"); 
		query.append("         GROUP BY GROUPING SETS((T1.EQ_TPSZ_CD," ).append("\n"); 
		query.append("                               DP_SEQ), ())" ).append("\n"); 
		query.append("         ORDER BY DP_SEQ, GRP " ).append("\n"); 
		query.append("#end         " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}