/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UsaInlandCostManageDBDAOSearchUsaIpiPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInlandCostManageDBDAOSearchUsaIpiPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AOC_USA_IPI_PORT 조회
	  * </pre>
	  */
	public UsaInlandCostManageDBDAOSearchUsaIpiPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration").append("\n"); 
		query.append("FileName : UsaInlandCostManageDBDAOSearchUsaIpiPortRSQL").append("\n"); 
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
		query.append("SELECT  STND.INTG_CD_VAL_DP_SEQ     AS SEQ" ).append("\n"); 
		query.append("      , STND.INTG_CD_VAL_CTNT       AS SVC_MOD_CD" ).append("\n"); 
		query.append("      , STND.INTG_CD_VAL_DP_DESC    AS SVC_MOD_NM" ).append("\n"); 
		query.append("      , NVL(TGT.TTL_CNT,0)          AS TTL_CNT" ).append("\n"); 
		query.append("      , TGT.UPD_DT" ).append("\n"); 
		query.append("      , ( SELECT USR_NM FROM COM_USER WHERE USR_ID = TGT.UPD_USR_ID ) AS UPD_USR_NM" ).append("\n"); 
		query.append("      , TGT.AVG_TRK_CNT" ).append("\n"); 
		query.append("      , TGT.AVG_RAIL_CNT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("          SELECT  INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("                , INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                , INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM    COM_INTG_CD_DTL" ).append("\n"); 
		query.append("          WHERE   INTG_CD_ID = 'CD03118'" ).append("\n"); 
		query.append("          AND     APLY_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("          AND     APLY_ST_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("        ) STND" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("          SELECT  IPI.USA_COST_TRF_SVC_MOD_CD" ).append("\n"); 
		query.append("                , COUNT(1) TTL_CNT" ).append("\n"); 
		query.append("                , MAX(TO_CHAR(DTL.UPD_DT,'YYYY-MM-DD HH24:MI:SS')) UPD_DT" ).append("\n"); 
		query.append("                , MAX(DTL.UPD_USR_ID) UPD_USR_ID" ).append("\n"); 
		query.append("                , SUM(CASE WHEN TRK_40FT_BZC_COST_SRC_CD <> 'A' THEN 1 ELSE 0 END) AVG_TRK_CNT" ).append("\n"); 
		query.append("                , SUM(CASE WHEN RAIL_40FT_BZC_COST_SRC_CD <> 'A' THEN 1 ELSE 0 END) AVG_RAIL_CNT" ).append("\n"); 
		query.append("          FROM    AOC_USA_IPI_PORT IPI" ).append("\n"); 
		query.append("                , AOC_USA_INLND_TRF_DTL DTL" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("          AND     IPI.PORT_CD = SUBSTR(DTL.PORT_NOD_CD,1,5)" ).append("\n"); 
		query.append("          AND     IPI.TRSP_CRR_MOD_CD = DTL.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("          AND     DTL.COST_SEL_ROUT_FLG = 'Y'" ).append("\n"); 
		query.append("          AND     DTL.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("#if (${in_cost_trf_no} != '') " ).append("\n"); 
		query.append("          AND     DTL.COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          GROUP BY" ).append("\n"); 
		query.append("                  IPI.USA_COST_TRF_SVC_MOD_CD" ).append("\n"); 
		query.append("        ) TGT" ).append("\n"); 
		query.append("WHERE   STND.INTG_CD_VAL_CTNT = TGT.USA_COST_TRF_SVC_MOD_CD(+)" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}