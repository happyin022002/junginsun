/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ActualCostCSRManageDBDAOSearchActualCostCSRMonitoringListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualCostCSRManageDBDAOSearchActualCostCSRMonitoringListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    결산 전 모니터링 결과 조회
	  * </pre>
	  */
	public ActualCostCSRManageDBDAOSearchActualCostCSRMonitoringListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_opt_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_opt_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_src_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rslt_cd_not_match",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.integration").append("\n"); 
		query.append("FileName : ActualCostCSRManageDBDAOSearchActualCostCSRMonitoringListRSQL").append("\n"); 
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
		query.append("	INV_SYS_ID," ).append("\n"); 
		query.append("	INV_OFC_CD," ).append("\n"); 
		query.append("	CSR_NO, INV_NO," ).append("\n"); 
		query.append("	TO_CHAR(UPD_DT, 'YYYY-MM-DD') IF_DT," ).append("\n"); 
		query.append("	SUBSTR(GL_DT, 1, 4)||'-'||SUBSTR(GL_DT, 5, 2)||'-'||SUBSTR(GL_DT, 7, 2) GL_DT," ).append("\n"); 
		query.append("	REV_YRMON," ).append("\n"); 
		query.append("	INV_VSL_CD||INV_SKD_VOY_NO||INV_SKD_DIR_CD||INV_REV_DIR_CD INV_RVVD," ).append("\n"); 
		query.append("	ESTM_VSL_CD||ESTM_SKD_VOY_NO||ESTM_SKD_DIR_CD||ESTM_REV_DIR_CD ESTM_RVVD," ).append("\n"); 
		query.append("	BKG_NO BKG_NO, " ).append("\n"); 
		query.append("	CNTR_NO," ).append("\n"); 
		query.append("	INV_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	ESTM_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	INV_COST_ACT_GRP_CD, " ).append("\n"); 
		query.append("	ESTM_COST_ACT_GRP_CD," ).append("\n"); 
		query.append("	INV_COST_ACT_GRP_SEQ, " ).append("\n"); 
		query.append("	ESTM_COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("	INV_COA_COST_SRC_CD," ).append("\n"); 
		query.append("	ESTM_COA_COST_SRC_CD," ).append("\n"); 
		query.append("	INV_N1ST_NOD_CD," ).append("\n"); 
		query.append("	ESTM_N1ST_NOD_CD," ).append("\n"); 
		query.append("	INV_N2ND_NOD_CD," ).append("\n"); 
		query.append("	ESTM_N2ND_NOD_CD," ).append("\n"); 
		query.append("	INV_N3RD_NOD_CD," ).append("\n"); 
		query.append("	ESTM_N3RD_NOD_CD," ).append("\n"); 
		query.append("	INV_N4TH_NOD_CD," ).append("\n"); 
		query.append("	ESTM_N4TH_NOD_CD," ).append("\n"); 
		query.append("	ROUND(INV_COST_AMT,2) INV_COST_AMT ," ).append("\n"); 
		query.append("	ROUND(ESTM_COST_AMT, 2) ESTM_COST_AMT," ).append("\n"); 
		query.append("	ALOC_CNTR_QTY, " ).append("\n"); 
		query.append("	ROUND(ALOC_CNTR_AMT, 2) ALOC_CNTR_AMT," ).append("\n"); 
		query.append("	DECODE(ACT_MAPG_RSLT_CD,'MA', 'Match'," ).append("\n"); 
		query.append("							'DI', 'Div'," ).append("\n"); 
		query.append("							'ND', 'Node'," ).append("\n"); 
		query.append("							'CD', 'Cost CD'," ).append("\n"); 
		query.append("							'AG', 'A/G'," ).append("\n"); 
		query.append("							'TS', 'TP/SZ'," ).append("\n"); 
		query.append("							'VV', 'VVD'," ).append("\n"); 
		query.append("							'BK', 'No BKG'," ).append("\n"); 
		query.append("							'NE', 'No Est' ) ACT_MAPG_RSLT_CD" ).append("\n"); 
		query.append("FROM	LEA_CSR_MNTR M" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("AND		INV_OFC_CD	= DECODE(@[frm_inv_ofc_cd], NULL, INV_OFC_CD, @[frm_inv_ofc_cd])" ).append("\n"); 
		query.append("#if(${frm_src_ctnt} != 'ALL')" ).append("\n"); 
		query.append("AND		INV_SYS_ID	= @[frm_src_ctnt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${frm_csr_no} != '')" ).append("\n"); 
		query.append("AND		CSR_NO		= @[frm_csr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${frm_rslt_cd} == 'NM' && ${frm_rslt_cd_not_match} != 'ALL') " ).append("\n"); 
		query.append("AND	ACT_MAPG_RSLT_CD = @[frm_rslt_cd_not_match]" ).append("\n"); 
		query.append("#elseif(${frm_rslt_cd} == 'NM' && ${frm_rslt_cd_not_match} == 'ALL') " ).append("\n"); 
		query.append("AND	ACT_MAPG_RSLT_CD not in('MA','XX')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${frm_rslt_cd} == 'MA') " ).append("\n"); 
		query.append("AND	ACT_MAPG_RSLT_CD = 'MA'" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("#if(${frm_rslt_cd} == 'XX') " ).append("\n"); 
		query.append("AND	ACT_MAPG_RSLT_CD = 'XX'	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${frm_csr_no} == '' && ${dt_div} == 'GL')" ).append("\n"); 
		query.append("AND GL_DT BETWEEN REPLACE(@[frm_opt_st_dt], '-') AND REPLACE(@[frm_opt_end_dt], '-')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${frm_csr_no} == '' && ${dt_div} != 'GL')" ).append("\n"); 
		query.append("AND UPD_DT BETWEEN TO_DATE(@[frm_opt_st_dt], 'YYYY-MM-DD') AND TO_DATE(@[frm_opt_end_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}