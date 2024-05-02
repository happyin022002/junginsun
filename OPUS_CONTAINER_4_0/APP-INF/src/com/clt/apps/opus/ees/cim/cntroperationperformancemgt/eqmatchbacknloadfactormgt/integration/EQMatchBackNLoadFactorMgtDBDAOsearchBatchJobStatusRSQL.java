/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOsearchBatchJobStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOsearchBatchJobStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CIM Batch Job Status
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOsearchBatchJobStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toz",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOsearchBatchJobStatusRSQL").append("\n"); 
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
		query.append("        W.PLN_YR||W.PLN_WK AS WK," ).append("\n"); 
		query.append("        D.TGT_MVMT_DT AS DT," ).append("\n"); 
		query.append("NVL(MAX(DECODE(H.CNTR_PERF_BAT_JB_CD,'TP',DECODE(ACT_CMPL_CD,'Y',0,'C',1))),2) AS TP," ).append("\n"); 
		query.append("NVL(MAX(DECODE(H.CNTR_PERF_BAT_JB_CD,'TL',DECODE(ACT_CMPL_CD,'Y',0,'C',1))),2) AS TL," ).append("\n"); 
		query.append("NVL(MAX(DECODE(H.CNTR_PERF_BAT_JB_CD,'TS',DECODE(ACT_CMPL_CD,'Y',0,'C',1))),2) AS TS," ).append("\n"); 
		query.append("NVL(MAX(DECODE(H.CNTR_PERF_BAT_JB_CD,'TM',DECODE(ACT_CMPL_CD,'Y',0,'C',1))),2) AS TM," ).append("\n"); 
		query.append("NVL(MAX(DECODE(H.CNTR_PERF_BAT_JB_CD,'MP',DECODE(ACT_CMPL_CD,'Y',0,'C',1))),2) AS MP," ).append("\n"); 
		query.append("NVL(MAX(DECODE(H.CNTR_PERF_BAT_JB_CD,'ML',DECODE(ACT_CMPL_CD,'Y',0,'C',1))),2) AS ML," ).append("\n"); 
		query.append("NVL(MAX(DECODE(H.CNTR_PERF_BAT_JB_CD,'MB',DECODE(ACT_CMPL_CD,'Y',0,'C',1))),2) AS MB," ).append("\n"); 
		query.append("NVL(MAX(DECODE(H.CNTR_PERF_BAT_JB_CD,'MD',DECODE(ACT_CMPL_CD,'Y',0,'C',1))),2) AS MD," ).append("\n"); 
		query.append("NVL(MAX(DECODE(H.CNTR_PERF_BAT_JB_CD,'RP',DECODE(ACT_CMPL_CD,'Y',0,'C',1))),2) AS RP," ).append("\n"); 
		query.append("NVL(MAX(DECODE(H.CNTR_PERF_BAT_JB_CD,'RL',DECODE(ACT_CMPL_CD,'Y',0,'C',1))),2) AS RL," ).append("\n"); 
		query.append("NVL(MAX(DECODE(H.CNTR_PERF_BAT_JB_CD,'RD',DECODE(ACT_CMPL_CD,'Y',0,'C',1))),2) AS RD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                    TO_CHAR( TO_DATE(Z.WK_ST_DT,'RRRRMMDD') + LEVEL - 1 ,'YYYYMMDD' ) TGT_MVMT_DT" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                                F.WK_ST_DT," ).append("\n"); 
		query.append("                                S.WK_END_DT" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                                EQR_WK_PRD F, EQR_WK_PRD S" ).append("\n"); 
		query.append("                        WHERE   F.PLN_YR||F.PLN_WK = @[fromz]" ).append("\n"); 
		query.append("                        AND     S.PLN_YR||S.PLN_WK = @[toz]" ).append("\n"); 
		query.append("                    ) Z" ).append("\n"); 
		query.append("            START   WITH 0 = 0" ).append("\n"); 
		query.append("            CONNECT BY TO_DATE(Z.WK_ST_DT,'RRRRMMDD') + LEVEL - 1 <= TO_DATE(Z.WK_END_DT,'RRRRMMDD')" ).append("\n"); 
		query.append("        ) D," ).append("\n"); 
		query.append("        CIM_BAT_HIS H," ).append("\n"); 
		query.append("        EQR_WK_PRD W" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("        D.TGT_MVMT_DT = H.TGT_MVMT_DT(+)" ).append("\n"); 
		query.append("AND     D.TGT_MVMT_DT BETWEEN W.WK_ST_DT AND W.WK_END_DT" ).append("\n"); 
		query.append("GROUP BY W.PLN_YR||W.PLN_WK, D.TGT_MVMT_DT" ).append("\n"); 
		query.append("ORDER BY W.PLN_YR||W.PLN_WK, D.TGT_MVMT_DT" ).append("\n"); 

	}
}