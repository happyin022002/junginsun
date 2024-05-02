/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : USDomesticDBDAOSearchUSDomesticCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAOSearchUSDomesticCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchUSDomesticCost
	  * </pre>
	  */
	public USDomesticDBDAOSearchUSDomesticCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration").append("\n"); 
		query.append("FileName : USDomesticDBDAOSearchUSDomesticCostRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(B2.COST_YRMON, 0, 4) || '-' || SUBSTR(B2.COST_YRMON, 5, 2)		AS COST_YRMON" ).append("\n"); 
		query.append("      ,B2.ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("      ,BKG_JOIN_FNC ( CURSOR ( SELECT ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("                                FROM COA_USA_DMST_UT_COST B1" ).append("\n"); 
		query.append("                               WHERE B1.COST_YRMON = B2.COST_YRMON" ).append("\n"); 
		query.append("                                 AND B1.COST_LOC_GRP_CD = 'C' " ).append("\n"); 
		query.append("                                 AND B1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                 AND B2.ORG_RAIL_LOC_CD = COA_LOC_FNC ( B1.ORG_RAIL_LOC_CD, 'ECC' ) " ).append("\n"); 
		query.append("                               ORDER BY B1.ORG_RAIL_LOC_CD ), ',' )  AS RAIL_HUB" ).append("\n"); 
		query.append("      ,B2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,B2.DMST_VOL_QTY" ).append("\n"); 
		query.append("      ,B2.RAILG_AMT" ).append("\n"); 
		query.append("      ,B2.EQ_RNTL_SCG_AMT" ).append("\n"); 
		query.append("      ,B2.FUEL_SCG_AMT" ).append("\n"); 
		query.append("      ,B2.HZD_MTRL_SCG_AMT" ).append("\n"); 
		query.append("      ,B2.DMST_TTL_FRT_REV_AMT" ).append("\n"); 
		query.append("      ,B2.DMST_TTL_FRT_REV_AMT / B2.DMST_VOL_QTY                                AS DOM_REV_UC_AMT" ).append("\n"); 
		query.append("      ,B2.RAIL_SO_VOL_QTY" ).append("\n"); 
		query.append("      ,B2.RAIL_AGMT_AMT" ).append("\n"); 
		query.append("      ,B2.RAIL_AGMT_AMT / B2.RAIL_SO_VOL_QTY                                    AS RAIL_UC_AMT" ).append("\n"); 
		query.append("      ,B2.USA_DMST_UC_AMT * B2.RAIL_SO_VOL_QTY                                     AS USA_DMST_COST_AMT" ).append("\n"); 
		query.append("      ,B2.USA_DMST_UC_AMT         " ).append("\n"); 
		query.append("      ,B2.SIM_MTY_UC_AMT * B2.RAIL_SO_VOL_QTY                                   AS SIM_MTY_COST_AMT" ).append("\n"); 
		query.append("      ,B2.INIT_SIM_MTY_UC_AMT" ).append("\n"); 
		query.append("      ,B2.SIM_MTY_UC_AMT" ).append("\n"); 
		query.append("      ,B2.FCNTR_IB_VOL_QTY" ).append("\n"); 
		query.append("      ,B2.SIM_MTY_UC_AMT * B2.RAIL_SO_VOL_QTY - B2.USA_DMST_UC_AMT * B2.RAIL_SO_VOL_QTY AS USA_DMST_SAV_COST_AMT" ).append("\n"); 
		query.append("      ,B2.INIT_USA_DMST_SAV_UT_AMT" ).append("\n"); 
		query.append("      ,B2.USA_DMST_SAV_UT_AMT" ).append("\n"); 
		query.append("      ,B2.EQ_OFFH_QTY          " ).append("\n"); 
		query.append("      ,B2.SUB_LSE_OUT_QTY      " ).append("\n"); 
		query.append("      ,B2.DISP_QTY             " ).append("\n"); 
		query.append("      ,B2.CND_DMST_QTY         " ).append("\n"); 
		query.append("      ,B2.OFFH_TTL_QTY         " ).append("\n"); 
		query.append("      ,B2.SIM_MTY_UC_AMT * B2.OFFH_TTL_QTY AS OFFH_SIM_MTY_COST_AMT    " ).append("\n"); 
		query.append("      ,B2.EQ_OFFH_SAV_AMT " ).append("\n"); 
		query.append("      ,B2.EQ_OFFH_SAV_UC_AMT   " ).append("\n"); 
		query.append("      ,B2.EQ_OFFH_SAV_UC_INIT_AMT     " ).append("\n"); 
		query.append("      ,B2.DMST_RAIL_INV_AMT" ).append("\n"); 
		query.append("      ,DECODE(B2.FCNTR_IB_VOL_QTY, 0, 0, B2.DMST_RAIL_INV_AMT / B2.FCNTR_IB_VOL_QTY) AS EQ_OFFH_UC_AMT" ).append("\n"); 
		query.append("      ,B2.EQ_OFFH_FNL_UC_AMT" ).append("\n"); 
		query.append("      ,B2.EQ_OFFH_FNL_UC_INIT_AMT " ).append("\n"); 
		query.append("      ,B2.TRP_QTY              " ).append("\n"); 
		query.append("      ,B2.TRP_AMT              " ).append("\n"); 
		query.append("      ,B2.TRP_UC_AMT           " ).append("\n"); 
		query.append("      ,B2.SIM_MTY_UC_AMT * B2.TRP_QTY AS TRP_SIM_MTY_COST_AMT      " ).append("\n"); 
		query.append("      ,B2.TRP_SAV_AMT  " ).append("\n"); 
		query.append("      ,B2.TRP_CR_UC_AMT" ).append("\n"); 
		query.append("      ,B2.TRP_CR_UC_INIT_AMT " ).append("\n"); 
		query.append("      ,ROW_NUMBER () OVER (ORDER BY B2.ORG_RAIL_LOC_CD, B2.CNTR_TPSZ_CD) AS ROW_NUM" ).append("\n"); 
		query.append("	  ,TO_CHAR ( B2.CRE_DT, 'YYYY-MM-DD' ) AS CRE_DT" ).append("\n"); 
		query.append("      ,B2.CRE_USR_ID" ).append("\n"); 
		query.append("FROM COA_USA_DMST_UT_COST B2" ).append("\n"); 
		query.append("WHERE B2.COST_YRMON = REPLACE(@[f_cost_yrmon],'-','')" ).append("\n"); 
		query.append("  AND B2.COST_LOC_GRP_CD = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_ecc_cd} != '') " ).append("\n"); 
		query.append("   AND B2.ORG_RAIL_LOC_CD = @[f_ecc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("   AND B2.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("ORDER BY B2.ORG_RAIL_LOC_CD, B2.CNTR_TPSZ_CD" ).append("\n"); 

	}
}