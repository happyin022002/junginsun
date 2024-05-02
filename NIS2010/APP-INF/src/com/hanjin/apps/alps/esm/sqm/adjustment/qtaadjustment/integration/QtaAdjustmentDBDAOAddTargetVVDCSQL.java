/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAOAddTargetVVDCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.02.18 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOAddTargetVVDCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Edit Office Add Target VVD을 생성합니다.
	  * </pre>
	  */
	public QtaAdjustmentDBDAOAddTargetVVDCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOAddTargetVVDCSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_SCTR_ADD_TGT_VVD A1 USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("       @[bse_tp_cd] BSE_TP_CD " ).append("\n"); 
		query.append("      ,@[bse_yr] BSE_YR" ).append("\n"); 
		query.append("      ,@[bse_qtr_cd] BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A4.PF_GRP_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("      ,SUBSTR(A1.SLS_YRMON,5,6) AS BSE_MON" ).append("\n"); 
		query.append("      ,A1.COST_WK AS BSE_WK" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.IOC_CD" ).append("\n"); 
		query.append("      ,0 AS GRP_BSA_CAPA" ).append("\n"); 
		query.append("      ,ROUND(NVL(A2.FNL_HJS_BSA_CAPA,0)) FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,A3.PF_SKD_TP_CD AS PF_SVC_TP_CD" ).append("\n"); 
		query.append("      ,@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("      ,@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE UPD_DT" ).append("\n"); 
		query.append("  FROM MAS_MON_VVD A1" ).append("\n"); 
		query.append("      ,BSA_VVD_MST A2" ).append("\n"); 
		query.append("      ,VSK_VSL_SKD A3" ).append("\n"); 
		query.append("      ,SQM_SCTR_PF_GRP A4" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.SUB_TRD_CD   = @[sub_trd_cd]" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("   AND SUBSTR(A1.SLS_YRMON,0,4) = @[bse_yr]" ).append("\n"); 
		query.append("   AND A1.COST_WK      BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = NVL(@[dir_cd], A1.DIR_CD)  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = A4.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = A4.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = A2.TRD_CD(+)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND A1.VSL_CD       = A2.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO   = A2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = A2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.VSL_CD       = A3.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO   = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = A3.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A1.SLAN_CD      = A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("   AND A4.BSE_TP_CD    = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND A4.BSE_YR       = @[bse_yr]" ).append("\n"); 
		query.append("   AND A4.BSE_QTR_CD   = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A4.PF_SVC_TP_CD = A3.PF_SKD_TP_CD" ).append("\n"); 
		query.append("   AND A4.PF_GRP_CD    = @[pf_grp_cd]" ).append("\n"); 
		query.append("   AND A1.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ON (   A1.BSE_TP_CD 	= A2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR 		= A2.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD 	= A2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD 		= A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD 		= A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.PF_GRP_CD 	= A2.PF_GRP_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD 		= A2.DIR_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CD 		= A2.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO 	= A2.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.SKD_DIR_CD 	= A2.SKD_DIR_CD )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT 	(  " ).append("\n"); 
		query.append("       A1.BSE_TP_CD" ).append("\n"); 
		query.append("	,  A1.BSE_YR" ).append("\n"); 
		query.append("	,  A1.BSE_QTR_CD" ).append("\n"); 
		query.append("	,  A1.TRD_CD" ).append("\n"); 
		query.append("	,  A1.RLANE_CD" ).append("\n"); 
		query.append("	,  A1.PF_GRP_CD" ).append("\n"); 
		query.append("	,  A1.DIR_CD" ).append("\n"); 
		query.append("	,  A1.VSL_CD" ).append("\n"); 
		query.append("	,  A1.SKD_VOY_NO" ).append("\n"); 
		query.append("	,  A1.SKD_DIR_CD" ).append("\n"); 
		query.append("	,  A1.BSE_MON" ).append("\n"); 
		query.append("	,  A1.BSE_WK" ).append("\n"); 
		query.append("	,  A1.SUB_TRD_CD" ).append("\n"); 
		query.append("	,  A1.IOC_CD" ).append("\n"); 
		query.append("	,  A1.GRP_BSA_CAPA" ).append("\n"); 
		query.append("	,  A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("	,  A1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("	,  A1.CRE_USR_ID" ).append("\n"); 
		query.append("	,  A1.CRE_DT" ).append("\n"); 
		query.append("	,  A1.UPD_USR_ID" ).append("\n"); 
		query.append("	,  A1.UPD_DT )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("	   A2.BSE_TP_CD" ).append("\n"); 
		query.append("	,  A2.BSE_YR" ).append("\n"); 
		query.append("	,  A2.BSE_QTR_CD" ).append("\n"); 
		query.append("	,  A2.TRD_CD" ).append("\n"); 
		query.append("	,  A2.RLANE_CD" ).append("\n"); 
		query.append("	,  A2.PF_GRP_CD" ).append("\n"); 
		query.append("	,  A2.DIR_CD" ).append("\n"); 
		query.append("	,  A2.VSL_CD" ).append("\n"); 
		query.append("	,  A2.SKD_VOY_NO" ).append("\n"); 
		query.append("	,  A2.SKD_DIR_CD" ).append("\n"); 
		query.append("	,  A2.BSE_MON" ).append("\n"); 
		query.append("	,  A2.BSE_WK" ).append("\n"); 
		query.append("	,  A2.SUB_TRD_CD" ).append("\n"); 
		query.append("	,  A2.IOC_CD" ).append("\n"); 
		query.append("	,  A2.GRP_BSA_CAPA" ).append("\n"); 
		query.append("	,  A2.FNL_BSA_CAPA" ).append("\n"); 
		query.append("	,  A2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("	,  A2.CRE_USR_ID" ).append("\n"); 
		query.append("	,  A2.CRE_DT" ).append("\n"); 
		query.append("	,  A2.UPD_USR_ID" ).append("\n"); 
		query.append("	,  A2.UPD_DT )" ).append("\n"); 

	}
}