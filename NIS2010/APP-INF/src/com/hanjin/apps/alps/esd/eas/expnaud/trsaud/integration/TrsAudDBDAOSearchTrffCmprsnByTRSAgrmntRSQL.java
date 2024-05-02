/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsAudDBDAOSearchTrffCmprsnByTRSAgrmntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.04.23 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAudDBDAOSearchTrffCmprsnByTRSAgrmntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Comparison by TRS Agreement 조회
	  * </pre>
	  */
	public TrsAudDBDAOSearchTrffCmprsnByTRSAgrmntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trsp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_wo_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trsp_cost_dtl_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_so_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration").append("\n"); 
		query.append("FileName : TrsAudDBDAOSearchTrffCmprsnByTRSAgrmntRSQL").append("\n"); 
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
		query.append("SELECT	  E.WO_RHQ_CD" ).append("\n"); 
		query.append("     	, E.WO_OFC_CD" ).append("\n"); 
		query.append("     	, E.INLND_COST_YRMON" ).append("\n"); 
		query.append("     	, ( SELECT B.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL B WHERE INTG_CD_ID = 'CD00279' AND B.INTG_CD_VAL_CTNT = E.TRSP_SO_TP_CD) 			AS TRSP_SO_TP_CD" ).append("\n"); 
		query.append("		, ( SELECT B.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL B WHERE INTG_CD_ID = 'CD00594' AND B.INTG_CD_VAL_CTNT = E.TRSP_COST_DTL_MOD_CD) 	AS TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("		, E.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("		, ( SELECT B.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL B WHERE INTG_CD_ID = 'CD00591' AND B.INTG_CD_VAL_CTNT = E.TRSP_BND_CD) 			AS TRSP_BND_CD" ).append("\n"); 
		query.append("     	, E.FM_NOD_CD" ).append("\n"); 
		query.append("     	, E.VIA_NOD_CD" ).append("\n"); 
		query.append("     	, E.TO_NOD_CD" ).append("\n"); 
		query.append("     	, E.DOR_NOD_CD" ).append("\n"); 
		query.append("     	, E.VNDR_SEQ" ).append("\n"); 
		query.append("     	, ( SELECT b.VNDR_LGL_ENG_NM FROM MDM_VENDOR B WHERE B.VNDR_SEQ = E.VNDR_SEQ) AS VNDR_NM" ).append("\n"); 
		query.append("     	, E.TRSP_SO_KNT" ).append("\n"); 
		query.append("     	, E.AGMT_CURR_CD" ).append("\n"); 
		query.append("     	, E.AGMT_20FT_DRY_AMT" ).append("\n"); 
		query.append("     	, E.AGMT_40FT_DRY_AMT" ).append("\n"); 
		query.append("     	, E.AGMT_20FT_RF_AMT" ).append("\n"); 
		query.append("     	, E.AGMT_40FT_RF_AMT" ).append("\n"); 
		query.append("     	, E.AGMT_20FT_DRY_USD_AMT" ).append("\n"); 
		query.append("     	, E.AGMT_40FT_DRY_USD_AMT" ).append("\n"); 
		query.append("     	, E.AGMT_20FT_RF_USD_AMT" ).append("\n"); 
		query.append("     	, E.AGMT_40FT_RF_USD_AMT" ).append("\n"); 
		query.append("     	, E.TRSP_AVG_20FT_DRY_USD_AMT" ).append("\n"); 
		query.append("     	, E.TRSP_AVG_40FT_DRY_USD_AMT" ).append("\n"); 
		query.append("     	, E.TRSP_AVG_20FT_RF_USD_AMT" ).append("\n"); 
		query.append("     	, E.TRSP_AVG_40FT_RF_USD_AMT" ).append("\n"); 
		query.append("     	, E.SO_20FT_VOL_KNT" ).append("\n"); 
		query.append("     	, E.SO_40FT_VOL_KNT" ).append("\n"); 
		query.append("     	, E.SO_TEU_QTY" ).append("\n"); 
		query.append("     	, E.SO_BX_QTY" ).append("\n"); 
		query.append("     	, E.WO_CURR_CD" ).append("\n"); 
		query.append("     	, E.WO_20FT_DRY_AVG_AMT" ).append("\n"); 
		query.append("     	, E.WO_40FT_DRY_AVG_AMT" ).append("\n"); 
		query.append("     	, E.WO_45FT_DRY_AVG_AMT" ).append("\n"); 
		query.append("     	, E.WO_20FT_RF_AVG_AMT" ).append("\n"); 
		query.append("     	, E.WO_40FT_RF_AVG_AMT" ).append("\n"); 
		query.append("     	, E.WO_20FT_DG_AVG_AMT" ).append("\n"); 
		query.append("     	, E.WO_40FT_DG_AVG_AMT" ).append("\n"); 
		query.append("     	, E.WO_20FT_AWK_AVG_AMT" ).append("\n"); 
		query.append("     	, E.WO_40FT_AWK_AVG_AMT" ).append("\n"); 
		query.append("  FROM 	EAS_EXPN_AUD_CS_INLND_COST E" ).append("\n"); 
		query.append(" WHERE 	1=1" ).append("\n"); 
		query.append("   		AND E.WO_OFC_CD IN (	SELECT	OFC_CD" ).append("\n"); 
		query.append("                       			FROM 	MDM_ORGANIZATION" ).append("\n"); 
		query.append("                      			WHERE 	DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    			CONNECT BY 	NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                      			START WITH 	OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("                    	 	)" ).append("\n"); 
		query.append(" 	#if (${s_wo_ofc_cd} != '')" ).append("\n"); 
		query.append("		AND E.WO_OFC_CD = @[s_wo_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("   	AND INLND_COST_YRMON BETWEEN REPLACE(@[s_fm_yrmon],'-','') AND REPLACE(@[s_to_yrmon],'-','')" ).append("\n"); 
		query.append(" 	#if (${s_so_tp_cd} != '')" ).append("\n"); 
		query.append("   		AND E.TRSP_SO_TP_CD = @[s_so_tp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_trsp_cost_dtl_mod_cd} != '')" ).append("\n"); 
		query.append("   		AND E.TRSP_COST_DTL_MOD_CD = @[s_trsp_cost_dtl_mod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_trsp_crr_mod_cd} != '')" ).append("\n"); 
		query.append("   		AND E.TRSP_CRR_MOD_CD = @[s_trsp_crr_mod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_trsp_bnd_cd} != '')" ).append("\n"); 
		query.append("   		AND E.TRSP_BND_CD = @[s_trsp_bnd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_fm_nod_cd} != '')" ).append("\n"); 
		query.append("   		AND E.FM_NOD_CD   = @[s_fm_nod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_via_nod_cd} != '')" ).append("\n"); 
		query.append("   		AND E.VIA_NOD_CD  = @[s_via_nod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_to_nod_cd} != '')" ).append("\n"); 
		query.append("		AND E.TO_NOD_CD   = @[s_to_nod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_dor_nod_cd} != '')" ).append("\n"); 
		query.append("   		AND E.DOR_NOD_CD  = @[s_dor_nod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 

	}
}