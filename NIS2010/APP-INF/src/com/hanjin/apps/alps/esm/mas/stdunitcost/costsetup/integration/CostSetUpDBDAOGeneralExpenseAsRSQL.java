/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CostSetUpDBDAOGeneralExpenseAsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.08
*@LastModifier :  최덕우
*@LastVersion : 1.0
* 2016.06.08  최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Duk-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOGeneralExpenseAsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralExpenseAs
	  * </pre>
	  */
	public CostSetUpDBDAOGeneralExpenseAsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dur",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sweek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOGeneralExpenseAsRSQL").append("\n"); 
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
		query.append("SELECT A.*" ).append("\n"); 
		query.append("     , A.OTR_EXPN_AMT * A.GEN_EXPN_RTO / 100 AS GEN_EXPN_AMT" ).append("\n"); 
		query.append("     , 'I' AS ibflag" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT REPLACE(@[f_cost_yrmon], '-','') AS COST_YRMON," ).append("\n"); 
		query.append("       RHQ_CD," ).append("\n"); 
		query.append("       OFC_VW_CD," ).append("\n"); 
		query.append("       CASE WHEN SUM_RATIO != 100 THEN" ).append("\n"); 
		query.append("            CASE WHEN RNK = 1 THEN" ).append("\n"); 
		query.append("                 RATIO + (100 - SUM_RATIO)" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 RATIO" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            RATIO" ).append("\n"); 
		query.append("       END AS GEN_EXPN_RTO," ).append("\n"); 
		query.append("       (SELECT OTR_EXPN_AMT" ).append("\n"); 
		query.append("          FROM MAS_MNL_COST_STUP" ).append("\n"); 
		query.append("         WHERE COST_YRMON =  REPLACE(@[f_cost_yrmon], '-','')" ).append("\n"); 
		query.append("           AND cost_wk    = 'XX'" ).append("\n"); 
		query.append("           AND RLANE_CD   = 'GENTT'" ).append("\n"); 
		query.append("       ) OTR_EXPN_AMT	-- 일반관리비 확정금액 (메인화면에서 입력)       " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT OFC_VW_CD," ).append("\n"); 
		query.append("               RHQ_CD," ).append("\n"); 
		query.append("               RATIO,              " ).append("\n"); 
		query.append("               DENSE_RANK() OVER(PARTITION BY OFC_VW_CD ORDER BY OFC_VW_CD, RATIO) AS RNK," ).append("\n"); 
		query.append("               SUM(RATIO) OVER(PARTITION BY OFC_VW_CD) AS SUM_RATIO" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT OFC_VW_CD," ).append("\n"); 
		query.append("                       RHQ_CD," ).append("\n"); 
		query.append("                       ROUND(RATIO_TO_REPORT(TTL_REV) OVER(PARTITION BY OFC_VW_CD) * 100,2) AS RATIO" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT OFC_VW_CD," ).append("\n"); 
		query.append("                               RHQ_CD," ).append("\n"); 
		query.append("                               NVL(SUM(REV_AMT),0) AS TTL_REV" ).append("\n"); 
		query.append("                          FROM MAS_HJSACT_RHQ_REV_IF" ).append("\n"); 
		query.append("                         WHERE COST_YRMON BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[f_sweek], '-',''),'YYYYMM'), - @[f_dur]),'YYYYMM') AND REPLACE(@[f_sweek], '-','')" ).append("\n"); 
		query.append("                           AND OFC_VW_CD = @[ofc_vw_cd]" ).append("\n"); 
		query.append("                           AND EXISTS (" ).append("\n"); 
		query.append("                                      SELECT 1 FROM MAS_OFC_LVL L" ).append("\n"); 
		query.append("                                      WHERE REPLACE(@[f_cost_yrmon], '-','') BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON " ).append("\n"); 
		query.append("                                        AND OFC_LVL <> '9'" ).append("\n"); 
		query.append("                                        AND OFC_N2ND_LVL_CD = RHQ_CD" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                         GROUP BY OFC_VW_CD, RHQ_CD  " ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("  WHERE RHQ_CD IS NOT NULL" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("ORDER BY A.RHQ_CD" ).append("\n"); 

	}
}