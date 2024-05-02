/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CalculateDBDAORsltPriPrsUsdRoutCsInfoSimulationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.24 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CalculateDBDAORsltPriPrsUsdRoutCsInfoSimulationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Used Route CASE Info
	  * </pre>
	  */
	public CalculateDBDAORsltPriPrsUsdRoutCsInfoSimulationVORSQL(){
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
		query.append("FileName : CalculateDBDAORsltPriPrsUsdRoutCsInfoSimulationVORSQL").append("\n"); 
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
		query.append("		, PCTL_NO" ).append("\n"); 
		query.append("		, BKG_NO" ).append("\n"); 
		query.append("		, MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("		, POR_CD" ).append("\n"); 
		query.append("		, POR_NOD_CD" ).append("\n"); 
		query.append("		, POL_CD" ).append("\n"); 
		query.append("		, N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("		, N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("		, N3RD_TS_PORT_CD" ).append("\n"); 
		query.append("		, POD_CD" ).append("\n"); 
		query.append("		, DEL_CD" ).append("\n"); 
		query.append("		, DEL_NOD_CD" ).append("\n"); 
		query.append("		, MTY_RTN_YD_CD" ).append("\n"); 
		query.append("		, TTL_TZTM_HRS" ).append("\n"); 
		query.append("		, PROD_REV" ).append("\n"); 
		query.append("		, TTL_EXPN_AMT" ).append("\n"); 
		query.append("		, CM_AMT" ).append("\n"); 
		query.append("		, TRNK_AVAL_SPC" ).append("\n"); 
		query.append("		, BKG_SEL_FLG" ).append("\n"); 
		query.append("		, COP_CRE_FLG" ).append("\n"); 
		query.append("		, OB_ITCHG_CTNT" ).append("\n"); 
		query.append("		, IB_ITCHG_CTNT" ).append("\n"); 
		query.append("		, TRNK_VSL_CD" ).append("\n"); 
		query.append("		, TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("		, TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("		, CNST_FLG" ).append("\n"); 
		query.append("		, BKG_CGO_TP_CD" ).append("\n"); 
		query.append("		, BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("		, CMDT_CD" ).append("\n"); 
		query.append("		, BKG_DE_TERM_CD" ).append("\n"); 
		query.append("		, REP_CMDT_CD" ).append("\n"); 
		query.append("		, SHPR_CNT_CD" ).append("\n"); 
		query.append("		, SHPR_SEQ" ).append("\n"); 
		query.append("		, CNEE_CNT_CD" ).append("\n"); 
		query.append("		, CNEE_SEQ" ).append("\n"); 
		query.append("		, SC_NO" ).append("\n"); 
		query.append("		, RFA_NO" ).append("\n"); 
		query.append("		, DG_CLSS_CD" ).append("\n"); 
		query.append("		, DG_SPCL_FLG" ).append("\n"); 
		query.append("		, RF_SPCL_FLG" ).append("\n"); 
		query.append("		, SPCL_AWK_CGO_FLG" ).append("\n"); 
		query.append("		, BB_SPCL_FLG" ).append("\n"); 
		query.append("		, RD_SPCL_FLG" ).append("\n"); 
		query.append("		, HNGR_SPCL_FLG" ).append("\n"); 
		query.append("		, SOC_FLG" ).append("\n"); 
		query.append("		, EQ_SUBST_FLG" ).append("\n"); 
		query.append("		, BKG_WGT" ).append("\n"); 
		query.append("		, BKG_WGT_UT_CD" ).append("\n"); 
		query.append("		, SLS_OFC_CD" ).append("\n"); 
		query.append("		, SLS_RHQ_CD" ).append("\n"); 
		query.append("		, SLS_HO_CD" ).append("\n"); 
		query.append("		, BKG_OFC_CD" ).append("\n"); 
		query.append("		, CRE_OFC_CD" ).append("\n"); 
		query.append("		, N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("		, N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("		, N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("		, N4TH_FINC_VVD_CD" ).append("\n"); 
		query.append("		, N1ST_RLANE_CD" ).append("\n"); 
		query.append("		, N2ND_RLANE_CD" ).append("\n"); 
		query.append("		, N3RD_RLANE_CD" ).append("\n"); 
		query.append("		, N4TH_RLANE_CD" ).append("\n"); 
		query.append("		, N1ST_TRD_CD" ).append("\n"); 
		query.append("		, N2ND_TRD_CD" ).append("\n"); 
		query.append("		, N3RD_TRD_CD" ).append("\n"); 
		query.append("		, N4TH_TRD_CD" ).append("\n"); 
		query.append("		, SC_OFC_CD" ).append("\n"); 
		query.append("		, RFA_OFC_CD" ).append("\n"); 
		query.append("		, COST_ROUT_NO" ).append("\n"); 
		query.append("		, PARA_ROUT_NO" ).append("\n"); 
		query.append("		, PPD_OFC_CD" ).append("\n"); 
		query.append("		, CLT_OFC_CD" ).append("\n"); 
		query.append("	FROM PRI_PRS_USD_ROUT_CS_INFO " ).append("\n"); 
		query.append("	WHERE ROUT_CS_NO = @[rout_cs_no]" ).append("\n"); 
		query.append("		AND ROUT_CS_SRC_DT = @[rout_cs_src_dt]" ).append("\n"); 

	}
}