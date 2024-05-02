/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchCostCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchCostCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCostCodeListRsql
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchCostCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd_inv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_wrk_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_wrk_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchCostCodeListRSQL").append("\n"); 
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
		query.append("/* Cost code가져오는 쿼리 */" ).append("\n"); 
		query.append("SELECT DISTINCT DECODE(1, 0, C.LGS_COST_CD, DECODE(C.LGS_COST_CD, CD, TP, C.LGS_COST_CD)) AS COST_CODE, " ).append("\n"); 
		query.append("  CTY                             AS AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("  LPAD(SEQ,5,'0')                 AS AGMT_SEQ,  " ).append("\n"); 
		query.append("  SUBSTR(NO,1,2)||'.'||SUBSTR(NO,3,4)  AS AGMT_VER_NO, " ).append("\n"); 
		query.append("  NVL(D.TML_TRNS_MOD_CD, 'S')     AS TML_TRNS_MOD_CD ," ).append("\n"); 
		query.append("  CRE_OFC_CD," ).append("\n"); 
		query.append("  CTRT_OFC_CD,   " ).append("\n"); 
		query.append("  TO_CHAR(EFF_FM_DT,'YYYY-MM-DD') AS EFF_FM_DT," ).append("\n"); 
		query.append("  TO_CHAR(EFF_TO_DT,'YYYY-MM-DD') AS EFF_TO_DT," ).append("\n"); 
		query.append("  TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') AS CRE_DT," ).append("\n"); 
		query.append("  TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("    SELECT COUNT(T.LGS_COST_CD) CNT, " ).append("\n"); 
		query.append("      T.LGS_COST_CD TP, " ).append("\n"); 
		query.append("      T.THRP_LGS_COST_CD CD, " ).append("\n"); 
		query.append("      H.TML_AGMT_OFC_CTY_CD CTY, " ).append("\n"); 
		query.append("      H.TML_AGMT_SEQ SEQ, " ).append("\n"); 
		query.append("      LPAD(H.TML_AGMT_VER_NO,4,'0') NO," ).append("\n"); 
		query.append("	  H.CRE_OFC_CD," ).append("\n"); 
		query.append("      H.CTRT_OFC_CD," ).append("\n"); 
		query.append("	  H.EFF_FM_DT," ).append("\n"); 
		query.append("      H.EFF_TO_DT," ).append("\n"); 
		query.append("      H.CRE_DT," ).append("\n"); 
		query.append("	  H.UPD_DT" ).append("\n"); 
		query.append("    FROM TES_TML_AGMT_HDR H, " ).append("\n"); 
		query.append("      TES_TML_AGMT_THRP_COST T " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND H.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("      AND H.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("      AND H.TML_AGMT_STS_CD = 'C' " ).append("\n"); 
		query.append("      AND H.DELT_FLG = 'N' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_cd_inv_tp_cd} == 'MT') " ).append("\n"); 
		query.append("	AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[atb_dt],'-')" ).append("\n"); 
		query.append("	AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[atb_dt],'-')" ).append("\n"); 
		query.append("#elseif (${cost_cd_inv_tp_cd} == 'ON') " ).append("\n"); 
		query.append("	AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[min_wrk_dt],'-')" ).append("\n"); 
		query.append("	AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[max_wrk_dt],'-')" ).append("\n"); 
		query.append("#elseif (${cost_cd_inv_tp_cd} == 'OT') " ).append("\n"); 
		query.append("	AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[to_prd_dt],'-')" ).append("\n"); 
		query.append("	AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[to_prd_dt],'-') " ).append("\n"); 
		query.append("#elseif (${cost_cd_inv_tp_cd} == 'OS') " ).append("\n"); 
		query.append("	AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[to_prd_dt],'-')" ).append("\n"); 
		query.append("	AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[to_prd_dt],'-') " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO) " ).append("\n"); 
		query.append("                                FROM TES_TML_AGMT_HDR M " ).append("\n"); 
		query.append("                                WHERE M.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("                                  AND M.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("                                  AND M.TML_AGMT_STS_CD = 'C' " ).append("\n"); 
		query.append("                                  AND M.DELT_FLG = 'N' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_cd_inv_tp_cd} == 'MT') " ).append("\n"); 
		query.append("									AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[atb_dt],'-')" ).append("\n"); 
		query.append("									AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[atb_dt],'-')" ).append("\n"); 
		query.append("#elseif (${cost_cd_inv_tp_cd} == 'ON') " ).append("\n"); 
		query.append(" 									AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[min_wrk_dt],'-')" ).append("\n"); 
		query.append("									AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[max_wrk_dt],'-')" ).append("\n"); 
		query.append("#elseif (${cost_cd_inv_tp_cd} == 'OT') " ).append("\n"); 
		query.append("                             		AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[to_prd_dt],'-')" ).append("\n"); 
		query.append("                             		AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[to_prd_dt],'-')  " ).append("\n"); 
		query.append("#elseif (${cost_cd_inv_tp_cd} == 'OS') " ).append("\n"); 
		query.append("                             		AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[to_prd_dt],'-')" ).append("\n"); 
		query.append("                             		AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[to_prd_dt],'-')  " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                ) " ).append("\n"); 
		query.append("      AND H.TML_AGMT_OFC_CTY_CD = T.TML_AGMT_OFC_CTY_CD(+) " ).append("\n"); 
		query.append("      AND H.TML_AGMT_SEQ = T.TML_AGMT_SEQ(+) " ).append("\n"); 
		query.append("      AND H.TML_AGMT_VER_NO = T.TML_AGMT_VER_NO(+) " ).append("\n"); 
		query.append("    GROUP BY H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO, T.LGS_COST_CD, T.THRP_LGS_COST_CD, H.CRE_OFC_CD,H.CTRT_OFC_CD,H.EFF_FM_DT,H.EFF_TO_DT,H.CRE_DT,H.UPD_DT" ).append("\n"); 
		query.append("   ) A, " ).append("\n"); 
		query.append("  TES_TML_SO_COST C, " ).append("\n"); 
		query.append("  TES_TML_AGMT_DTL D " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_cd_inv_tp_cd} != 'OS')" ).append("\n"); 
		query.append("  AND C.COST_CALC_MZD_CD = 'M' " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND DECODE(@[cost_cd_inv_tp_cd],'MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG,'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'" ).append("\n"); 
		query.append("  AND C.STO_INV_FLG = 'N' " ).append("\n"); 
		query.append("  AND D.TML_AGMT_OFC_CTY_CD = A.CTY " ).append("\n"); 
		query.append("  AND D.TML_AGMT_SEQ = A.SEQ " ).append("\n"); 
		query.append("  AND D.TML_AGMT_VER_NO = A.NO " ).append("\n"); 
		query.append("  AND C.LGS_COST_CD = D.LGS_COST_CD " ).append("\n"); 
		query.append("  AND DECODE(A.CNT, 0, DECODE(SUBSTR(C.LGS_COST_CD, 1, 2), 'TP', 'N', 'Y'), 'Y') = 'Y'" ).append("\n"); 

	}
}