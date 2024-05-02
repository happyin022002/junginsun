/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOSearchPortTariffDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchPortTariffDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPortTariffDetailList
	  * </pre>
	  */
	public NetworkCostDBDAOSearchPortTariffDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchPortTariffDetailListRSQL").append("\n"); 
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
		query.append("--" ).append("\n"); 
		query.append("SELECT SLAN_CD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("      , SUBSTR(YD_CD, 1, 5) PORT_CD" ).append("\n"); 
		query.append("      , SUBSTR(YD_CD, 6, 2) CY_CD" ).append("\n"); 
		query.append("      , MAX(CURR_CD) CURR_CD" ).append("\n"); 
		query.append("      , MAX(PORT_USD_AMT) PORT_USD_AMT" ).append("\n"); 
		query.append("      , MAX(PORT_PSO_AMT) KEEP (DENSE_RANK FIRST ORDER BY PORT_USD_AMT DESC) PORT_PSO_AMT" ).append("\n"); 
		query.append("      --, MAX(CNL_USD_AMT) KEEP (DENSE_RANK FIRST ORDER BY PORT_USD_AMT DESC) CNL_USD_AMT" ).append("\n"); 
		query.append("      --, MAX(CNL_PSO_AMT) CNL_PSO_AMT" ).append("\n"); 
		query.append("      , MAX(CRE_DT) KEEP (DENSE_RANK FIRST ORDER BY PORT_USD_AMT DESC) CRE_DT" ).append("\n"); 
		query.append("      , MAX(CLPT_SEQ) KEEP (DENSE_RANK FIRST ORDER BY PORT_USD_AMT DESC) CLPT_SEQ" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (SELECT SLAN_CD" ).append("\n"); 
		query.append("              , VSL_CD" ).append("\n"); 
		query.append("              , SKD_VOY_NO" ).append("\n"); 
		query.append("              , DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("              , TML_CD" ).append("\n"); 
		query.append("              , YD_CD" ).append("\n"); 
		query.append("              , CURRENCY AS CURR_CD" ).append("\n"); 
		query.append("              , PORT_USD_AMT" ).append("\n"); 
		query.append("              , PSO_PORT_AMT AS PORT_PSO_AMT" ).append("\n"); 
		query.append("              --, CNL_USD_AMT" ).append("\n"); 
		query.append("              --, PSO_CNL_AMT AS CNL_PSO_AMT" ).append("\n"); 
		query.append("              , CRE_USR_ID" ).append("\n"); 
		query.append("              , WRK_DT AS CRE_DT" ).append("\n"); 
		query.append("              , CLPT_SEQ" ).append("\n"); 
		query.append("           FROM" ).append("\n"); 
		query.append("                (SELECT A1.SLAN_CD" ).append("\n"); 
		query.append("                      , A1.VSL_CD" ).append("\n"); 
		query.append("                      , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , A1.DIR_CD" ).append("\n"); 
		query.append("                      , A5.TML_CD" ).append("\n"); 
		query.append("                      , A4.YD_CD" ).append("\n"); 
		query.append("                      , 'USD' CURRENCY" ).append("\n"); 
		query.append("                      , SUM(A6.INV_USD_AMT) PSO_PORT_AMT" ).append("\n"); 
		query.append("                      , SUM(A5.PORT_USD_AMT) PORT_USD_AMT" ).append("\n"); 
		query.append("                      --, SUM((CASE WHEN SUBSTR(NVL(A4.YD_CD, A5.TML_CD), 1, 5) IN ('EGSUZ', 'PAPAC') THEN A6.INV_USD_AMT " ).append("\n"); 
		query.append("                      --            ELSE 0 END) ) PSO_CNL_AMT" ).append("\n"); 
		query.append("                      --, SUM(A5.CNL_USD_AMT) CNL_USD_AMT" ).append("\n"); 
		query.append("                      , A6.WRK_DT" ).append("\n"); 
		query.append("                      , A6.WRK_SEQ" ).append("\n"); 
		query.append("                      , MIN(A4.CLPT_SEQ) CLPT_SEQ" ).append("\n"); 
		query.append("                      , LAST_VALUE (A6.WRK_DT IGNORE NULLS) OVER (PARTITION BY A1.VSL_CD, A1.SKD_VOY_NO, A1.DIR_CD ) LST_WRK_DT" ).append("\n"); 
		query.append("                      , LAST_VALUE (A6.WRK_SEQ IGNORE NULLS) OVER (PARTITION BY A1.VSL_CD, A1.SKD_VOY_NO, A1.DIR_CD ) LST_WRK_SEQ" ).append("\n"); 
		query.append("                      , A5.CRE_USR_ID" ).append("\n"); 
		query.append("                   FROM (SELECT A1.VSL_CD, A1.SKD_VOY_NO , A1.DIR_CD, A1.SLAN_CD, MIN(N1ST_LODG_PORT_ETD_DT) N1ST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("                           FROM COA_MON_VVD A1, COA_LANE_RGST A3" ).append("\n"); 
		query.append("                          WHERE 1=1" ).append("\n"); 
		query.append("                            AND NVL(A1.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                            AND NVL(A3.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                            AND A1.VSL_CD         = @[f_vsl_cd]" ).append("\n"); 
		query.append("                            AND A1.SKD_VOY_NO     = @[f_skd_voy_no]" ).append("\n"); 
		query.append("                            AND A1.DIR_CD         = @[f_dir_cd]    " ).append("\n"); 
		query.append("                            AND A1.SLAN_CD        = @[f_slan_cd]" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("        #if (${f_yrtype} == 'W')" ).append("\n"); 
		query.append("                            AND A1.SLS_YRMON LIKE SUBSTR(@[f_yearweek],1,4) || '%' AND A1.COST_WK = SUBSTR(@[f_yearweek], 5,2)" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                            AND A1.COST_YRMON   = REPLACE(@[f_yearweek],'-')" ).append("\n"); 
		query.append("        #end   " ).append("\n"); 
		query.append("                            AND A1.TRD_CD             = A3.TRD_CD" ).append("\n"); 
		query.append("                            AND A1.RLANE_CD           = A3.RLANE_CD" ).append("\n"); 
		query.append("                            AND A1.IOC_CD             = A3.IOC_CD" ).append("\n"); 
		query.append("                            AND A1.DIR_CD             = A3.DIR_CD" ).append("\n"); 
		query.append("                            AND A3.TRD_CD            <> 'COM'" ).append("\n"); 
		query.append("                            AND A3.VSL_LANE_TP_CD    IN ('JO', 'SC')" ).append("\n"); 
		query.append("                           GROUP BY A1.VSL_CD, A1.SKD_VOY_NO , A1.DIR_CD, A1.SLAN_CD) A1" ).append("\n"); 
		query.append("                      , COA_VSL_RGST A2" ).append("\n"); 
		query.append("                      , VSK_VSL_PORT_SKD A4" ).append("\n"); 
		query.append("                      , COA_PORT_TRF A5" ).append("\n"); 
		query.append("                      , PSO_TGT_VVD_EXPN A6" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND A1.VSL_CD             = A2.VSL_CD" ).append("\n"); 
		query.append("                    --AND A2.VOP_CD             = '000'" ).append("\n"); 
		query.append("                    AND TO_CHAR(A1.N1ST_LODG_PORT_ETD_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("                        BETWEEN NVL(TO_CHAR(A2.VSL_APLY_FM_DT, 'YYYYMMDD'), '19000101') " ).append("\n"); 
		query.append("                            AND NVL(TO_CHAR(A2.VSL_APLY_TO_DT, 'YYYYMMDD'), '99991231')" ).append("\n"); 
		query.append("                    AND A1.VSL_CD                    = A4.VSL_CD" ).append("\n"); 
		query.append("                    AND A1.SKD_VOY_NO                = A4.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND A1.DIR_CD                    = A4.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND A1.SLAN_CD                   = A4.SLAN_CD" ).append("\n"); 
		query.append("--					AND A1.VPS_YD_CD                     = A4.YD_CD" ).append("\n"); 
		query.append("                    AND NVL(A4.SKD_CNG_STS_CD, 'N') <> 'S'" ).append("\n"); 
		query.append("                    AND NVL(A4.VT_ADD_CALL_FLG,'N') <> 'Y'					--20150819.ADD" ).append("\n"); 
		query.append("                    AND A4.SLAN_CD                   =DECODE(A5.SLAN_CD(+), 'PSO', A4.SLAN_CD,'COA', A4.SLAN_CD, A5.SLAN_CD(+))" ).append("\n"); 
		query.append("                    AND A4.VSL_CD                    =A5.VSL_CD(+)" ).append("\n"); 
		query.append("                    AND A4.SKD_VOY_NO                =A5.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                    AND A4.SKD_DIR_CD                =A5.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                    AND A4.YD_CD          = A5.TML_CD(+)" ).append("\n"); 
		query.append("                    AND A4.VSL_CD         = A6.VSL_CD(+)" ).append("\n"); 
		query.append("                    AND A4.SKD_VOY_NO     = A6.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                    AND A4.SKD_DIR_CD     = A6.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                    AND A4.YD_CD          =A6.YD_CD(+)                    " ).append("\n"); 
		query.append("                    AND A6.PSO_BZTP_CD(+) = '7'  " ).append("\n"); 
		query.append("               GROUP BY A1.SLAN_CD" ).append("\n"); 
		query.append("                      , A1.VSL_CD" ).append("\n"); 
		query.append("                      , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , A1.DIR_CD" ).append("\n"); 
		query.append("                      , A4.YD_CD" ).append("\n"); 
		query.append("                      , A5.TML_CD" ).append("\n"); 
		query.append("                      , A6.WRK_DT" ).append("\n"); 
		query.append("                      , A6.WRK_SEQ" ).append("\n"); 
		query.append("                      , A1.VSL_CD" ).append("\n"); 
		query.append("                      , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , A1.DIR_CD" ).append("\n"); 
		query.append("                      , A5.CRE_USR_ID" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          WHERE (WRK_DT IS NULL OR WRK_DT||WRK_SEQ = LST_WRK_DT||LST_WRK_SEQ)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("GROUP BY SLAN_CD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("      , YD_CD" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ" ).append("\n"); 

	}
}