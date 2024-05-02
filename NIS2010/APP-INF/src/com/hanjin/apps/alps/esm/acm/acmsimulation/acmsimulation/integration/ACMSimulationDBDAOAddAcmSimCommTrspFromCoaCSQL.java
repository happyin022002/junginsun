/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ACMSimulationDBDAOAddAcmSimCommTrspFromCoaCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOAddAcmSimCommTrspFromCoaCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA 에서 TRSP 공제 비용 조회.
	  * </pre>
	  */
	public ACMSimulationDBDAOAddAcmSimCommTrspFromCoaCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hlg_ddct_org_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdrg_ddct_org_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdrg_ddct_dest_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hlg_ddct_dest_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOAddAcmSimCommTrspFromCoaCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_SIM_COMM_TRSP" ).append("\n"); 
		query.append("SELECT @[sim_no] AS SIM_NO," ).append("\n"); 
		query.append("  A.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("  @[agn_cd] AS AGN_CD," ).append("\n"); 
		query.append("  @[io_bnd_cd] AS IO_BND_CD," ).append("\n"); 
		query.append("  @[ac_tp_cd] AS AC_TP_CD," ).append("\n"); 
		query.append("  @[max_ac_seq] AS AC_SEQ," ).append("\n"); 
		query.append("  ROW_NUMBER() OVER(PARTITION BY A.BKG_NO ORDER BY SUBSTR(A.NOD_CD, 1, 5), SUBSTR(A.TO_NOD_CD, 1, 5)) AS AC_TRSP_SEQ," ).append("\n"); 
		query.append("  DECODE(A.ROUT_TZ_MOD_CD, 'WD', 'F', 'H') AS TRSP_MOD_CD," ).append("\n"); 
		query.append("  A.COA_COST_SRC_CD AS TRSP_DDCT_CD," ).append("\n"); 
		query.append("  SUBSTR(A.NOD_CD, 1, 5) FM_LOC_CD," ).append("\n"); 
		query.append("  SUBSTR(A.TO_NOD_CD, 1, 5) TO_LOC_CD," ).append("\n"); 
		query.append("  NVL(A.CNTR_QTY, 0) * NVL(A.ESTM_USD_UC_AMT, 0) AS TRSP_DDCT_AMT," ).append("\n"); 
		query.append("  @[usr_id]," ).append("\n"); 
		query.append("  SYSDATE UPD_DT," ).append("\n"); 
		query.append("  @[usr_id]," ).append("\n"); 
		query.append("  SYSDATE CRE_DT" ).append("\n"); 
		query.append("FROM COA_BKG_COST_SRC_DTL A," ).append("\n"); 
		query.append("  (SELECT BND, LOC" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("      SELECT 'O' BND, SUBSTR(POR_CD, 1, 5) AS LOC FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("      SELECT 'O', SUBSTR(POL_CD, 1, 5) FROM BKG_VVD WHERE BKG_NO = @[bkg_no] AND VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("      SELECT 'I', SUBSTR(DEL_CD, 1, 5) FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("      SELECT 'I', SUBSTR(POD_CD, 1, 5) FROM BKG_VVD WHERE BKG_NO = @[bkg_no] AND VSL_PRE_PST_CD IN ('T', 'U')" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("   GROUP BY BND, LOC" ).append("\n"); 
		query.append("  ) B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND A.STND_COST_CD IN (SELECT STND_COST_CD  -- '51301011', '51301021', '51301031', '51301041', '51301051', '51301061', '51301081'" ).append("\n"); 
		query.append("                         FROM MAS_STND_ACCT_V" ).append("\n"); 
		query.append("                         WHERE SGRP_COST_CD = 'CVTR'" ).append("\n"); 
		query.append("                           AND MAS_COST_SRC_PRT_CD = 'CO'" ).append("\n"); 
		query.append("                           AND STND_COST_CD <> CASE WHEN EXISTS(SELECT 1" ).append("\n"); 
		query.append("                                                                FROM BKG_CHG_RT" ).append("\n"); 
		query.append("                                                                WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                                  AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                                  AND CHG_CD = 'IFC'" ).append("\n"); 
		query.append("                                                                  AND CHG_AMT <> 0" ).append("\n"); 
		query.append("                                                         )" ).append("\n"); 
		query.append("                                                           OR EXISTS(SELECT 1" ).append("\n"); 
		query.append("                                                                     FROM ACM_SIM_COMM_CHG" ).append("\n"); 
		query.append("                                                                     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                                       AND AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("                                                                       AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                                                                       AND AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("                                                                       AND AC_SEQ = @[max_ac_seq]" ).append("\n"); 
		query.append("                                                                       AND CHG_CD = 'IFC'" ).append("\n"); 
		query.append("                                                                       AND CHG_DDCT_AMT <> 0" ).append("\n"); 
		query.append("                                                              )" ).append("\n"); 
		query.append("                                                      THEN '51301091'" ).append("\n"); 
		query.append("                                                    ELSE 'XXXXXXXX'" ).append("\n"); 
		query.append("                                               END" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("  AND B.LOC IN (SUBSTR(NOD_CD, 1, 5), SUBSTR(TO_NOD_CD, 1, 5), SUBSTR(N2ND_NOD_CD, 1, 5), SUBSTR(N3RD_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("  AND A.ESTM_USD_UC_AMT <> 0" ).append("\n"); 
		query.append("  AND B.BND IN (DECODE(@[hlg_ddct_org_flg], 'Y', 'O', 'X')," ).append("\n"); 
		query.append("                DECODE(@[hlg_ddct_dest_flg], 'Y', 'I', 'X')," ).append("\n"); 
		query.append("                DECODE(@[fdrg_ddct_org_flg], 'Y', 'O', 'X')," ).append("\n"); 
		query.append("                DECODE(@[fdrg_ddct_dest_flg], 'Y', 'I', 'X')" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("  AND DECODE(A.ROUT_TZ_MOD_CD, 'WD', 'F', 'H') IN (DECODE(@[hlg_ddct_org_flg], 'Y', 'H', 'X')," ).append("\n"); 
		query.append("                                                   DECODE(@[hlg_ddct_dest_flg], 'Y', 'H', 'X')," ).append("\n"); 
		query.append("                                                   DECODE(@[fdrg_ddct_org_flg], 'Y', 'F', 'X')," ).append("\n"); 
		query.append("                                                   DECODE(@[fdrg_ddct_dest_flg], 'Y', 'F', 'X')" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("GROUP BY A.BKG_NO," ).append("\n"); 
		query.append("  A.COA_COST_SRC_CD," ).append("\n"); 
		query.append("  DECODE(A.ROUT_TZ_MOD_CD, 'WD', 'F', 'H')," ).append("\n"); 
		query.append("  SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("  SUBSTR(A.TO_NOD_CD, 1, 5)," ).append("\n"); 
		query.append("  NVL(A.CNTR_QTY, 0)," ).append("\n"); 
		query.append("  NVL(A.ESTM_USD_UC_AMT, 0)," ).append("\n"); 
		query.append("  DECODE(A.N3RD_NOD_CD, '', 'N', 'Y')," ).append("\n"); 
		query.append("  DECODE(A.N3RD_NOD_CD, '', 'N', 'Y')" ).append("\n"); 

	}
}