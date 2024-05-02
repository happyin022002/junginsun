/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BasicDataDBDAOSearchBasicDataCreationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOSearchBasicDataCreationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic Data Creation 조회
	  * 2014.01.02 [CHM-201328244] IAS Sector Sales 판매시스템 개발
	  * 20160422 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public BasicDataDBDAOSearchBasicDataCreationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSearchBasicDataCreationListRSQL").append("\n"); 
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
		query.append("SELECT A1.BSE_YR" ).append("\n"); 
		query.append("        ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("        ,DECODE(A1.SQM_LVL_CD, 1, 'RHQ', 'Office')       AS OFC_LVL" ).append("\n"); 
		query.append("        ,DECODE(A1.OFC_VW_CD, 'C', 'Contract', 'Loading') AS OFC_VW_CD" ).append("\n"); 
		query.append("        ,A1.TRD_CD" ).append("\n"); 
		query.append("        ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,A1.RLANE_CD" ).append("\n"); 
		query.append("        ,A1.DIR_CD" ).append("\n"); 
		query.append("        ,A1.RHQ_CD" ).append("\n"); 
		query.append("        ,A1.RGN_OFC_CD  AS OFC_CD" ).append("\n"); 
		query.append("        ,A1.LOD_QTY     AS LOD_VOL" ).append("\n"); 
		query.append("        ,A1.GRS_TTL_REV AS GRS_REV" ).append("\n"); 
		query.append("        ,A1.VVD_KNT     AS VVD_CNT" ).append("\n"); 
		query.append("        ,A1.GRS_TTL_REV  - (A1.RA_CM_UC_AMT * A1.LOD_QTY) AS RA_CM" ).append("\n"); 
		query.append("        ,A1.GRS_TTL_REV  - (A1.PA_CM_UC_AMT * A1.LOD_QTY) AS PA_CM" ).append("\n"); 
		query.append("        ,A1.RA_CM_UC_AMT * A1.LOD_QTY AS RA_CM_COST" ).append("\n"); 
		query.append("        ,A1.PA_CM_UC_AMT * A1.LOD_QTY AS PA_CM_COST" ).append("\n"); 
		query.append("        ,A1.LOD_POTN_RTO AS VOL_RTO" ).append("\n"); 
		query.append("        ,A1.REV_POTN_RTO AS GRS_RTO" ).append("\n"); 
		query.append("        ,A1.APLY_FM_YRWK" ).append("\n"); 
		query.append("        ,A1.APLY_TO_YRWK" ).append("\n"); 
		query.append("        ,A1.DUR_WKS" ).append("\n"); 
		query.append("    FROM SQM_PERF_IF A1" ).append("\n"); 
		query.append("   WHERE A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("     AND A1.OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("     AND A1.QTA_TGT_CD  = 'D'" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("     AND A1.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("     AND A1.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND A1.SQM_LVL_CD  = @[f_ofc_lvl]" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("     AND A1.RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("     AND A1.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--     AND 1 = CASE WHEN A1.BSE_YR || A1.BSE_QTR_CD > '20142Q' " ).append("\n"); 
		query.append("--                       THEN (" ).append("\n"); 
		query.append("--                            SELECT DISTINCT 1" ).append("\n"); 
		query.append("--                              FROM SQM_QTA_LANE_MGMT S1" ).append("\n"); 
		query.append("--                             WHERE S1.TRD_CD   = A1.TRD_CD" ).append("\n"); 
		query.append("--                               AND S1.RLANE_CD = A1.RLANE_CD" ).append("\n"); 
		query.append("--                               AND S1.IAS_SCTR_FLG IS NULL" ).append("\n"); 
		query.append("--                            )" ).append("\n"); 
		query.append("--             ELSE 1" ).append("\n"); 
		query.append("--             END" ).append("\n"); 
		query.append("ORDER BY A1.TRD_CD" ).append("\n"); 
		query.append("        ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,A1.RLANE_CD" ).append("\n"); 
		query.append("        ,A1.DIR_CD" ).append("\n"); 
		query.append("        ,A1.RHQ_CD" ).append("\n"); 
		query.append("        ,A1.RGN_OFC_CD" ).append("\n"); 

	}
}