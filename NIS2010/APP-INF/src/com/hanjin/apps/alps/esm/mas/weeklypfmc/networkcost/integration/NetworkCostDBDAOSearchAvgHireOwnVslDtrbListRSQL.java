/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOSearchAvgHireOwnVslDtrbListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchAvgHireOwnVslDtrbListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAvgHireOwnVslDtrbList
	  * </pre>
	  */
	public NetworkCostDBDAOSearchAvgHireOwnVslDtrbListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_cobcost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchAvgHireOwnVslDtrbListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       SUBSTR(COST_YRMON,1,4)||'-'||SUBSTR(COST_YRMON,5,2) AS COST_YR" ).append("\n"); 
		query.append("     , COST_WK" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , STND_COST_CD" ).append("\n"); 
		query.append("     , VSL_AMT" ).append("\n"); 
		query.append("     , VSL_DTRB_RT*100 AS VSL_DTRB_RT" ).append("\n"); 
		query.append("     , VSL_DTRB_AMT" ).append("\n"); 
		query.append("     , DHIR_AMT" ).append("\n"); 
		query.append("     , TTL_AMT" ).append("\n"); 
		query.append("     , UPD_USR_ID " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               DISTINCT D2.COST_YRMON                             COST_YRMON," ).append("\n"); 
		query.append("               D2.COST_WK                                          COST_WK," ).append("\n"); 
		query.append("               D2.VSL_CD                                           VSL_CD,               " ).append("\n"); 
		query.append("               D1.STND_COST_CD,                D1.VSL_AMT,                     D1.VSL_DTRB_RT, " ).append("\n"); 
		query.append("               D1.VSL_DTRB_AMT," ).append("\n"); 
		query.append("               D1.DHIR_AMT," ).append("\n"); 
		query.append("               D1.TTL_AMT," ).append("\n"); 
		query.append("               D1.UPD_USR_ID" ).append("\n"); 
		query.append("          FROM MAS_OWN_VSL_DLY_HIR_DTRB D1," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                SELECT DISTINCT" ).append("\n"); 
		query.append("                       B1.COST_YRMON," ).append("\n"); 
		query.append("                       B1.COST_WK    AS COST_WK,  " ).append("\n"); 
		query.append("                       B1.VSL_CD,      " ).append("\n"); 
		query.append("                       B2.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                  FROM MAS_MON_VVD B1," ).append("\n"); 
		query.append("                       (SELECT A1.VSL_SEQ," ).append("\n"); 
		query.append("                               A1.VSL_CD," ).append("\n"); 
		query.append("                               A1.VSL_TP_CD," ).append("\n"); 
		query.append("                               A1.VSL_OSHP_CD," ).append("\n"); 
		query.append("                               A1.VOP_CD," ).append("\n"); 
		query.append("                               A1.PORT_CLSS_CAPA," ).append("\n"); 
		query.append("                               A1.VSL_CLSS_CAPA," ).append("\n"); 
		query.append("             NVL(A1.VSL_APLY_FM_DT, A1.VSL_RETN_FM_DT)  AS FM_DT,   " ).append("\n"); 
		query.append("                           NVL(A1.VSL_APLY_TO_DT , A1.VSL_RETN_TO_DT) AS TO_DT " ).append("\n"); 
		query.append("                          FROM MAS_VSL_RGST A1" ).append("\n"); 
		query.append("                         WHERE 1 = 1" ).append("\n"); 
		query.append("                           AND NVL(A1.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                       ) B2" ).append("\n"); 
		query.append("                 WHERE B1.VSL_CD = B2.VSL_CD" ).append("\n"); 
		query.append("                   AND B1.COST_YRMON LIKE @[f_year] ||'%'" ).append("\n"); 
		query.append("       AND B1.COST_WK   = @[f_fm_wk]" ).append("\n"); 
		query.append("                   AND B1.DELT_FLG            <> 'Y'" ).append("\n"); 
		query.append("                   AND B2.VSL_TP_CD           = 'C'" ).append("\n"); 
		query.append("                   AND B2.VSL_OSHP_CD         = 'OWN'" ).append("\n"); 
		query.append("                   AND B2.VOP_CD              = 'SML'" ).append("\n"); 
		query.append("                   AND TO_CHAR(B1.N1ST_LODG_PORT_ETD_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                               BETWEEN NVL(TO_CHAR(B2.FM_DT, 'YYYYMMDD'), '19000101')" ).append("\n"); 
		query.append("                               AND     NVL(TO_CHAR(B2.TO_DT, 'YYYYMMDD'), '99991231')" ).append("\n"); 
		query.append("       AND B1.SUB_TRD_CD <> 'IP'" ).append("\n"); 
		query.append("               ) D2" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND D2.COST_YRMON      = D1.COST_YRMON(+)" ).append("\n"); 
		query.append("           AND D2.VSL_CD          = D1.VSL_CD(+)" ).append("\n"); 
		query.append("           AND D1.COST_WK(+)      = '00'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append(" WHERE STND_COST_CD = @[f_cobcost]" ).append("\n"); 
		query.append(" ORDER BY COST_YRMON" ).append("\n"); 
		query.append("        , COST_WK" ).append("\n"); 
		query.append("        , VSL_CD" ).append("\n"); 

	}
}