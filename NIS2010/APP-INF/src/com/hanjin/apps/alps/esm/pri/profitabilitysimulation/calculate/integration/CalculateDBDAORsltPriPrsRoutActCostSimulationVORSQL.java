/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CalculateDBDAORsltPriPrsRoutActCostSimulationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CalculateDBDAORsltPriPrsRoutActCostSimulationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Used Route CASE Info
	  * </pre>
	  */
	public CalculateDBDAORsltPriPrsRoutActCostSimulationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_src_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_clss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration").append("\n"); 
		query.append("FileName : CalculateDBDAORsltPriPrsRoutActCostSimulationVORSQL").append("\n"); 
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
		query.append("		ROUT_CS_NO" ).append("\n"); 
		query.append("		, @[rout_cs_clss_no] AS ROUT_CS_CLSS_NO" ).append("\n"); 
		query.append("		, COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("		, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, COA_COST_SRC_CD" ).append("\n"); 
		query.append("		, STND_COST_CD" ).append("\n"); 
		query.append("		, RA_ACCT_CD" ).append("\n"); 
		query.append("		, COST_UT_AMT_CD" ).append("\n"); 
		query.append("		, COST_SRC_SYS_CD" ).append("\n"); 
		query.append("		, COST_ASS_BSE_CD" ).append("\n"); 
		query.append("		, RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("		, ACT_GRP_CD     " ).append("\n"); 
		query.append("		, COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("		, VSL_SLAN_CD" ).append("\n"); 
		query.append("		, CTRL_OFC_CD" ).append("\n"); 
		query.append("		, COST_OFC_CD" ).append("\n"); 
		query.append("		, COST_IO_BND_CD" ).append("\n"); 
		query.append("		, N1ST_NOD_CD" ).append("\n"); 
		query.append("		, N1ST_NOD_TP_CD" ).append("\n"); 
		query.append("		, to_char(N1ST_ESTM_DT,'yyyymmdd hh:mi:ss') AS N1ST_ESTM_DT" ).append("\n"); 
		query.append("		, N2ND_NOD_CD" ).append("\n"); 
		query.append("		, N3RD_NOD_CD" ).append("\n"); 
		query.append("		, N4TH_NOD_CD" ).append("\n"); 
		query.append("		, ROUT_TZ_MOD_CD" ).append("\n"); 
		query.append("		, N1ST_POL_POD_DIST" ).append("\n"); 
		query.append("		, N1ST_DIST_UT_CD" ).append("\n"); 
		query.append("		, N2ND_POL_POD_DIST" ).append("\n"); 
		query.append("		, N2ND_DIST_UT_CD" ).append("\n"); 
		query.append("		, N3RD_POL_POD_DIST" ).append("\n"); 
		query.append("		, N3RD_DIST_UT_CD" ).append("\n"); 
		query.append("		, N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("		, N2ND_VNDR_SEQ" ).append("\n"); 
		query.append("		, N3RD_VNDR_SEQ" ).append("\n"); 
		query.append("		, N4TH_VNDR_SEQ" ).append("\n"); 
		query.append("		, CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("		, PRE_NOD_CD" ).append("\n"); 
		query.append("		, PST_NOD_CD" ).append("\n"); 
		query.append("		, PRE_LNK_VNDR_SEQ" ).append("\n"); 
		query.append("		, PST_LNK_VNDR_SEQ" ).append("\n"); 
		query.append("		, FCGO_TZ_DYS" ).append("\n"); 
		query.append("		, FCGO_TZ_HRS" ).append("\n"); 
		query.append("		, MCGO_TZ_DYS" ).append("\n"); 
		query.append("		, MCGO_TZ_HRS" ).append("\n"); 
		query.append("		, CNTR_QTY" ).append("\n"); 
		query.append("		, COST_CATE_CD" ).append("\n"); 
		query.append("		, ESTM_UC_AMT" ).append("\n"); 
		query.append("		, RESPB_UC_AMT" ).append("\n"); 
		query.append("		, LOCL_CURR_CD" ).append("\n"); 
		query.append("		, TRSP_SVC_OFC_CD" ).append("\n"); 
		query.append("		, COST_ASGN_CALC_FLG" ).append("\n"); 
		query.append("		, LGS_COST_CD_CHK_FLG" ).append("\n"); 
		query.append("		, THRP_RT_FLG" ).append("\n"); 
		query.append("		, ACT_GRP_TML_FLG" ).append("\n"); 
		query.append("		, LGS_COST_AUTO_CD_FLG" ).append("\n"); 
		query.append("		, IOC_CD" ).append("\n"); 
		query.append("		, BFR_TRSP_MOD_CD" ).append("\n"); 
		query.append("		, AFT_TRSP_MOD_CD" ).append("\n"); 
		query.append("		, CTRT_RTN_FLG" ).append("\n"); 
		query.append("		, APLY_VNDR_SEQ" ).append("\n"); 
		query.append("		, SCC_CD" ).append("\n"); 
		query.append("		, ECC_CD" ).append("\n"); 
		query.append("		, PARA_FM_SCC_CD" ).append("\n"); 
		query.append("		, PARA_TO_SCC_CD" ).append("\n"); 
		query.append("		, PARA_FM_ECC_CD" ).append("\n"); 
		query.append("		, PARA_TO_ECC_CD" ).append("\n"); 
		query.append("		, N1ST_RAIL_CRR_TP_CD" ).append("\n"); 
		query.append("		, N2ND_RAIL_CRR_TP_CD" ).append("\n"); 
		query.append("		, N3RD_RAIL_CRR_TP_CD" ).append("\n"); 
		query.append("		, ESTM_USD_UC_AMT" ).append("\n"); 
		query.append("		, RESPB_USD_UC_AMT" ).append("\n"); 
		query.append("		, ESTM_USD_TTL_AMT" ).append("\n"); 
		query.append("		, RESPB_USD_TTL_AMT" ).append("\n"); 
		query.append("		, WTR_DE_TERM_CD" ).append("\n"); 
		query.append("		, WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("		, INLND_ROUT_INCL_STTL_FLG" ).append("\n"); 
		query.append("		, N1ST_TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("		, N2ND_TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("		, N3RD_TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("		, N1ST_TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		, N1ST_AGMT_REF_NO" ).append("\n"); 
		query.append("		, N2ND_TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		, N2ND_AGMT_REF_NO" ).append("\n"); 
		query.append("		, N3RD_TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		, N3RD_AGMT_REF_NO" ).append("\n"); 
		query.append("		, COST_CALC_RMK	" ).append("\n"); 
		query.append("	FROM PRI_PRS_USD_ROUT_ACT_COST " ).append("\n"); 
		query.append("	WHERE ROUT_CS_NO = @[rout_cs_no]" ).append("\n"); 
		query.append("		AND ROUT_CS_SRC_DT = @[rout_cs_src_dt]" ).append("\n"); 

	}
}