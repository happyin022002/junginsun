/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : USDomesticDBDAOAddEmptyRepoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.20
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2012.11.20 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Song HoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAOAddEmptyRepoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddEmptyRepo
	  * </pre>
	  */
	public USDomesticDBDAOAddEmptyRepoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cre_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cre_start_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration").append("\n"); 
		query.append("FileName : USDomesticDBDAOAddEmptyRepoCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_USA_DMST_UT_COST B1" ).append("\n"); 
		query.append("     USING " ).append("\n"); 
		query.append("         (SELECT COST_YRMON" ).append("\n"); 
		query.append("                ,ECC_CD" ).append("\n"); 
		query.append("                ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                ,SIM_TRSP_UC_AMT SIM_MTY_UC_AMT" ).append("\n"); 
		query.append("                ,SUM(IB_QTY) FCNTR_IB_VOL_QTY" ).append("\n"); 
		query.append("           FROM ( " ).append("\n"); 
		query.append("                 SELECT REPLACE(@[f_cost_yrmon], '-', '') COST_YRMON" ).append("\n"); 
		query.append("                       ,COA_LOC_FNC(A2.LOC_CD, 'ECC') ECC_CD" ).append("\n"); 
		query.append("                       ,A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       ,A1.SIM_TRSP_UC_AMT" ).append("\n"); 
		query.append("                       ,SUM(A2.IB_QTY) IB_QTY" ).append("\n"); 
		query.append("                   FROM COA_MTY_ECC_UT_COST A1, CIM_LOC_MTCH_BAK_SMRY A2" ).append("\n"); 
		query.append("                  WHERE 1 = 1" ).append("\n"); 
		query.append("                    AND A1.COST_YRMON = REPLACE(@[f_cost_yrmon], '-', '')" ).append("\n"); 
		query.append("                    AND A1.COST_LOC_GRP_CD = 'E'                    " ).append("\n"); 
		query.append("                    AND A1.CNTR_ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("                    AND A2.TGT_MVMT_DT BETWEEN TO_CHAR (REPLACE(@[f_cre_start_dt], '-', '')||'01') " ).append("\n"); 
		query.append("                                         AND TO_CHAR(LAST_DAY(TO_DATE(REPLACE(@[f_cre_end_dt], '-', ''), 'YYYYMM')), 'YYYYMMDD') --COA MT 단가 생성 시 MB IF 쿼리 조건 이용" ).append("\n"); 
		query.append("                    AND A2.SOC_FLG = 'N'" ).append("\n"); 
		query.append("                    AND A2.ENR_FLG = 'N'" ).append("\n"); 
		query.append("                    AND A2.TN_ROUT_FLG ='N'" ).append("\n"); 
		query.append("                    AND A2.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("                    AND A2.MVMT_CO_CD IN ('H', 'S') -- Domestic 물량을 MB 에서 제거" ).append("\n"); 
		query.append("                    AND A2.CNTR_TPSZ_CD IN ('D2', 'D4', 'D5', 'D7')     " ).append("\n"); 
		query.append("                    AND A2.CNTR_TPSZ_CD = A1.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("                    AND COA_LOC_FNC(A2.LOC_CD, 'ECC') = A1.ECC_CD(+)" ).append("\n"); 
		query.append("                GROUP BY A2.CNTR_TPSZ_CD, COA_LOC_FNC(A2.LOC_CD, 'ECC'), A1.SIM_TRSP_UC_AMT" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("      GROUP BY COST_YRMON, ECC_CD, CNTR_TPSZ_CD, SIM_TRSP_UC_AMT ) B2" ).append("\n"); 
		query.append("  ON (    B1.COST_YRMON        = B2.COST_YRMON" ).append("\n"); 
		query.append("      AND COA_LOC_FNC(B1.ORG_RAIL_LOC_CD, 'ECC') = B2.ECC_CD" ).append("\n"); 
		query.append("      AND B1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD ) " ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE" ).append("\n"); 
		query.append("         SET B1.INIT_SIM_MTY_UC_AMT = B2.SIM_MTY_UC_AMT" ).append("\n"); 
		query.append("            ,B1.SIM_MTY_UC_AMT = B2.SIM_MTY_UC_AMT" ).append("\n"); 
		query.append("            ,B1.FCNTR_IB_VOL_QTY = B2.FCNTR_IB_VOL_QTY" ).append("\n"); 
		query.append("            ,B1.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("            ,B1.UPD_DT = SYSDATE" ).append("\n"); 

	}
}