/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOSearchStandbyBKGReportListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : Kim sung wook
*@LastVersion : 1.0
* 2015.08.13 Kim sung wook
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOSearchStandbyBKGReportListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Standby BKG Report SMP, ALOC 용 리스트
	  * </pre>
	  */
	public ConstraintMasterDBDAOSearchStandbyBKGReportListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_h_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_edate",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ofc_vw",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_h_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sb_rsn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_level",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_aloc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOSearchStandbyBKGReportListRSQL").append("\n"); 
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
		query.append("#if (${f_acct_cd} != '') " ).append("\n"); 
		query.append("WITH" ).append("\n"); 
		query.append("PARAMS AS (" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("         SUBSTR(@[f_vvd_cd],1,4)     AS VSL_CD" ).append("\n"); 
		query.append("        ,SUBSTR(@[f_vvd_cd],5,4)     AS SKD_VOY_NO" ).append("\n"); 
		query.append("        ,SUBSTR(@[f_vvd_cd],-1)      AS SKD_DIR_CD" ).append("\n"); 
		query.append("        ,NVL(@[f_h_trd_cd],@[f_trd_cd])      		 AS TRD_CD" ).append("\n"); 
		query.append("        ,@[f_sub_trd_cd]    		 AS SUB_TRD_CD" ).append("\n"); 
		query.append("        ,NVL(@[f_h_rlane_cd],@[f_rlane_cd])    		 AS RLANE_CD" ).append("\n"); 
		query.append("        ,@[f_dir_cd]      			 AS DIR_CD" ).append("\n"); 
		query.append("	FROM DUAL	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", REP_VVDS AS (" ).append("\n"); 
		query.append("    SELECT V.TRD_CD     AS REP_TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD," ).append("\n"); 
		query.append("           V.DIR_CD  ," ).append("\n"); 
		query.append("           V.VSL_CD              ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO          ," ).append("\n"); 
		query.append("           V.DIR_CD SKD_DIR_CD   ," ).append("\n"); 
		query.append("           NVL(A.CTRL_ACCT_FLG, 'N')        AS CTRL_ACCOUNT," ).append("\n"); 
		query.append("           NVL(A.CTRL_FX_RT_FLG, 'N')       AS CTRL_FX_RT_FLG," ).append("\n"); 
		query.append("           V.N1ST_LODG_PORT_ETD_DT          AS FL_ETD_DT  " ).append("\n"); 
		query.append("      FROM MAS_MON_VVD V," ).append("\n"); 
		query.append("           SPC_ALOC_CTRL_OPT A," ).append("\n"); 
		query.append("           PARAMS      P" ).append("\n"); 
		query.append("     WHERE V.TRD_CD     = SPC_GET_REP_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("       AND V.SUB_TRD_CD = SPC_GET_REP_SUB_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("       AND (V.DELT_FLG IS NULL OR V.DELT_FLG = 'N' OR EXISTS ( SELECT 1" ).append("\n"); 
		query.append("                                                                 FROM MAS_MON_VVD N" ).append("\n"); 
		query.append("                                                                WHERE N.RLANE_CD   = V.RLANE_CD " ).append("\n"); 
		query.append("                                                                  AND N.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("                                                                  AND N.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                  AND N.DIR_CD     = V.DIR_CD" ).append("\n"); 
		query.append("                                                                  AND N.DELT_FLG   = 'N'))" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND A.RLANE_CD  (+) = V.RLANE_CD" ).append("\n"); 
		query.append("       AND A.DIR_CD    (+) = V.DIR_CD" ).append("\n"); 
		query.append("       AND A.VSL_CD    (+) = V.VSL_CD" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO(+) = V.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD(+) = V.DIR_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND V.TRD_CD        = NVL(P.TRD_CD, V.TRD_CD) " ).append("\n"); 
		query.append("       AND V.SUB_TRD_CD    = NVL(P.SUB_TRD_CD, V.SUB_TRD_CD) " ).append("\n"); 
		query.append("       AND V.RLANE_CD      = NVL(P.RLANE_CD, V.RLANE_CD) " ).append("\n"); 
		query.append("       AND V.DIR_CD        = NVL(P.DIR_CD, V.DIR_CD) " ).append("\n"); 
		query.append("       AND V.VSL_CD        = NVL(P.VSL_CD, V.VSL_CD) " ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO    = NVL(P.SKD_VOY_NO, V.SKD_VOY_NO) " ).append("\n"); 
		query.append("       AND V.DIR_CD        = NVL(P.SKD_DIR_CD, V.DIR_CD) " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CTRT_OPT_DTL AS (" ).append("\n"); 
		query.append("-- SPC_ALOC_LANE_CTRL_OPT_DTL 테이블의 계약 정보를 가지고 온다." ).append("\n"); 
		query.append("SELECT DISTINCT  " ).append("\n"); 
		query.append("       A2.TRD_CD" ).append("\n"); 
		query.append("      ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A2.RLANE_CD" ).append("\n"); 
		query.append("      ,A2.DIR_CD" ).append("\n"); 
		query.append("      ,A2.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("      ,A2.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("      ,A1.FL_ETD_DT" ).append("\n"); 
		query.append("  FROM REP_VVDS A1" ).append("\n"); 
		query.append("      ,SPC_ALOC_LANE_CTRL_OPT_DTL A2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.REP_TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.REP_SUB_TRD_CD   = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD         = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD           = A2.DIR_CD" ).append("\n"); 
		query.append("   AND A1.CTRL_ACCOUNT     = 'Y'" ).append("\n"); 
		query.append("   AND A1.CTRL_FX_RT_FLG   = 'Y'" ).append("\n"); 
		query.append("   AND A2.CTRL_FX_RT_FLG   = 'Y'" ).append("\n"); 
		query.append("   AND A2.ALOC_CTRL_TP_CD  = 'F'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CTRT_DTL_INFO AS (" ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("           A5.TRD_CD" ).append("\n"); 
		query.append("          ,A5.SUB_TRD_CD" ).append("\n"); 
		query.append("          ,A5.RLANE_CD" ).append("\n"); 
		query.append("          ,A5.DIR_CD" ).append("\n"); 
		query.append("          ,A5.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("          ,A5.CTRL_LOC_ACCT_CD " ).append("\n"); 
		query.append("          ,A1.PROP_NO" ).append("\n"); 
		query.append("          ,A2.AMDT_SEQ" ).append("\n"); 
		query.append("          ,A3.SVC_SCP_CD" ).append("\n"); 
		query.append("          ,A4.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("          ,A4.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("          ,A2.REAL_CUST_CNT_CD || LPAD(A2.REAL_CUST_SEQ,'6','0') CUST_CD" ).append("\n"); 
		query.append("          ,A4.FX_RT_FLG" ).append("\n"); 
		query.append("          ,A2.EFF_DT" ).append("\n"); 
		query.append("          ,A2.EXP_DT" ).append("\n"); 
		query.append("          ,A2.PROP_STS_CD" ).append("\n"); 
		query.append("      FROM CTRT_OPT_DTL A5" ).append("\n"); 
		query.append("          ,PRI_SP_HDR A1" ).append("\n"); 
		query.append("          ,PRI_SP_MN  A2" ).append("\n"); 
		query.append("          ,PRI_SP_SCP_MN A3" ).append("\n"); 
		query.append("          ,PRI_SP_SCP_RT_CMDT_HDR A4 " ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A1.SC_NO             = A5.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("       AND A1.PROP_NO           = A2.PROP_NO" ).append("\n"); 
		query.append("       AND A2.PROP_STS_CD       = 'F' -- A, F, Q" ).append("\n"); 
		query.append("       AND TRUNC(A5.FL_ETD_DT) BETWEEN A2.EFF_DT AND A2.EXP_DT" ).append("\n"); 
		query.append("       AND A2.PROP_NO           = A3.PROP_NO" ).append("\n"); 
		query.append("       AND A2.AMDT_SEQ          = A3.AMDT_SEQ" ).append("\n"); 
		query.append("       AND A3.PROP_NO           = A4.PROP_NO" ).append("\n"); 
		query.append("       AND A3.AMDT_SEQ          = A4.AMDT_SEQ" ).append("\n"); 
		query.append("       AND A3.SVC_SCP_CD        = A4.SVC_SCP_CD" ).append("\n"); 
		query.append("       AND NVL(A4.FX_RT_FLG,'N')= 'Y'" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append(", ALOC_LANE_CTRL_OPT_DTL AS (" ).append("\n"); 
		query.append("SELECT DISTINCT B1.TRD_CD" ).append("\n"); 
		query.append("      ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,B1.RLANE_CD" ).append("\n"); 
		query.append("      ,B1.DIR_CD" ).append("\n"); 
		query.append("--      ,B1.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("--      ,B3.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("      ,NVL(B3.ALOC_CTRL_TP_CD, B1.ALOC_CTRL_TP_CD) AS ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("      ,B1.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("      ,B1.SC_NO" ).append("\n"); 
		query.append("      ,B1.RFA_NO" ).append("\n"); 
		query.append("      ,NVL(B3.ALOC_CTRL_DTL_CD, B1.ALOC_CTRL_DTL_CD) AS ALOC_CTRL_DTL_CD" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       SPC_ALOC_LANE_CTRL_OPT_DTL B1" ).append("\n"); 
		query.append("      ,REP_VVDS B2" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        -- Actual Account 정보 추출" ).append("\n"); 
		query.append("        SELECT distinct" ).append("\n"); 
		query.append("               A1.TRD_CD" ).append("\n"); 
		query.append("              ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,A1.RLANE_CD" ).append("\n"); 
		query.append("              ,A1.DIR_CD" ).append("\n"); 
		query.append("              ,'B' AS ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("              ,A1.ALOC_CTRL_TP_CD AS ORG_ALOC_CTRL_TP_CD-- B : A/Acct, C : Commodity, F : Fixed" ).append("\n"); 
		query.append("              ,A1.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("              ,A1.PROP_NO" ).append("\n"); 
		query.append("              ,A1.AMDT_SEQ" ).append("\n"); 
		query.append("              ,A1.SVC_SCP_CD" ).append("\n"); 
		query.append("              ,A2.CUST_CNT_CD || LPAD(A2.CUST_SEQ,'6','0') AS ALOC_CTRL_DTL_CD" ).append("\n"); 
		query.append("          FROM CTRT_DTL_INFO A1" ).append("\n"); 
		query.append("              ,PRI_SP_SCP_RT_ACT_CUST A2" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A1.PROP_NO           = A2.PROP_NO" ).append("\n"); 
		query.append("           AND A1.AMDT_SEQ          = A2.AMDT_SEQ" ).append("\n"); 
		query.append("           AND A1.SVC_SCP_CD        = A2.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.GEN_SPCL_RT_TP_CD = A2.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("           AND A1.CMDT_HDR_SEQ      = A2.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        -- CMDT 정보 추출" ).append("\n"); 
		query.append("        SELECT distinct" ).append("\n"); 
		query.append("               A1.TRD_CD" ).append("\n"); 
		query.append("              ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,A1.RLANE_CD" ).append("\n"); 
		query.append("              ,A1.DIR_CD" ).append("\n"); 
		query.append("              ,'C' AS ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("              ,A1.ALOC_CTRL_TP_CD AS ORG_ALOC_CTRL_TP_CD -- B : A/Acct, C : Commodity, F : Fixed" ).append("\n"); 
		query.append("              ,A1.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("              ,A1.PROP_NO" ).append("\n"); 
		query.append("              ,A1.AMDT_SEQ" ).append("\n"); 
		query.append("              ,A1.SVC_SCP_CD" ).append("\n"); 
		query.append("              ,DECODE(A2.PRC_CMDT_TP_CD,'C', A2.PRC_CMDT_DEF_CD, 'G', A4.PRC_CMDT_DEF_CD) AS ALOC_CTRL_DTL_CD" ).append("\n"); 
		query.append("          FROM CTRT_DTL_INFO A1" ).append("\n"); 
		query.append("              ,PRI_SP_SCP_RT_CMDT     A2" ).append("\n"); 
		query.append("              ,PRI_SP_SCP_GRP_CMDT    A3" ).append("\n"); 
		query.append("              ,PRI_SP_SCP_GRP_CMDT_DTL A4  " ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A1.PROP_NO           = A2.PROP_NO" ).append("\n"); 
		query.append("           AND A1.AMDT_SEQ          = A2.AMDT_SEQ" ).append("\n"); 
		query.append("           AND A1.SVC_SCP_CD        = A2.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.GEN_SPCL_RT_TP_CD = A2.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("           AND A1.CMDT_HDR_SEQ      = A2.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("           AND A2.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND A2.PROP_NO           = A3.PROP_NO(+)" ).append("\n"); 
		query.append("           AND A2.AMDT_SEQ          = A3.AMDT_SEQ(+)" ).append("\n"); 
		query.append("           AND A2.SVC_SCP_CD        = A3.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("           AND A2.PRC_CMDT_DEF_CD   = A3.PRC_GRP_CMDT_CD(+)" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND A3.PROP_NO           = A4.PROP_NO(+)" ).append("\n"); 
		query.append("           AND A3.AMDT_SEQ          = A4.AMDT_SEQ(+)" ).append("\n"); 
		query.append("           AND A3.SVC_SCP_CD        = A4.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("           AND A3.GRP_CMDT_SEQ      = A4.GRP_CMDT_SEQ(+)   " ).append("\n"); 
		query.append("           AND A4.SRC_INFO_CD(+)    <> 'AD'" ).append("\n"); 
		query.append("         GROUP BY A1.TRD_CD" ).append("\n"); 
		query.append("              ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,A1.RLANE_CD" ).append("\n"); 
		query.append("              ,A1.DIR_CD" ).append("\n"); 
		query.append("              ,A1.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("              ,A1.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("              ,A1.PROP_NO" ).append("\n"); 
		query.append("              ,A1.AMDT_SEQ" ).append("\n"); 
		query.append("              ,A1.SVC_SCP_CD" ).append("\n"); 
		query.append("              ,DECODE(A2.PRC_CMDT_TP_CD,'C', A2.PRC_CMDT_DEF_CD, 'G', A4.PRC_CMDT_DEF_CD)       " ).append("\n"); 
		query.append("       ) B3" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND B2.REP_TRD_CD       = B1.TRD_CD" ).append("\n"); 
		query.append("   AND B2.REP_SUB_TRD_CD   = B1.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND B2.RLANE_CD         = B1.RLANE_CD" ).append("\n"); 
		query.append("   AND B2.DIR_CD           = B1.DIR_CD" ).append("\n"); 
		query.append("   AND B1.TRD_CD           = B3.TRD_CD(+)" ).append("\n"); 
		query.append("   AND B1.SUB_TRD_CD       = B3.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("   AND B1.RLANE_CD         = B3.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND B1.DIR_CD           = B3.DIR_CD(+)" ).append("\n"); 
		query.append("   AND B1.ALOC_CTRL_TP_CD  = B3.ORG_ALOC_CTRL_TP_CD(+)" ).append("\n"); 
		query.append("   AND B1.CTRL_LOC_ACCT_CD = B3.CTRL_LOC_ACCT_CD(+)" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("AA.BKG_NO" ).append("\n"); 
		query.append("      ,AA.BKG_STS_CD" ).append("\n"); 
		query.append("      ,AA.STANDBY_TYPE" ).append("\n"); 
		query.append("--      ,AA.STANDBY_REASON" ).append("\n"); 
		query.append("--      ,AA.ALOC_SVC_CD" ).append("\n"); 
		query.append("      ,AA.ALOC_STS_CD" ).append("\n"); 
		query.append("      ,AA.CFM_RQST_FLG" ).append("\n"); 
		query.append("      ,AA.CNDDT_CFM_FLG" ).append("\n"); 
		query.append("      ,AA.CFM_USR_ID" ).append("\n"); 
		query.append("      ,AA.CFM_DT" ).append("\n"); 
		query.append("#if($c_name.size() != 0)" ).append("\n"); 
		query.append("  #foreach(${list} in ${c_name})" ).append("\n"); 
		query.append("    #if( ${list} != 'sc_no' && ${list} != 'rfa_no' && ${list} != 'ob_sls_ofc_cd' && ${list} != 'sub_trd_cd' && ${list} != 'vvd' && ${list} != 'acct_cd' && ${list} != 'bkg_no' && ${list} != 'bkg_no' )" ).append("\n"); 
		query.append("      , ${list}" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,AA.FEU" ).append("\n"); 
		query.append("      ,AA.TEU" ).append("\n"); 
		query.append("      ,AA.CUST_CTRL_CD" ).append("\n"); 
		query.append("      ,AA.SC_NO" ).append("\n"); 
		query.append("      ,AA.RFA_NO" ).append("\n"); 
		query.append("      ,AA.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	  ,AA.TRD_CD" ).append("\n"); 
		query.append("      ,AA.SUB_TRD_CD" ).append("\n"); 
		query.append("	  ,AA.RLANE_CD" ).append("\n"); 
		query.append("	  ,AA.DIR_CD" ).append("\n"); 
		query.append("      ,AA.VVD" ).append("\n"); 
		query.append("      ,AA.ACCT_CD" ).append("\n"); 
		query.append("	  ,(SELECT MAX(RV.CMPB_AMT) KEEP (DENSE_RANK LAST ORDER BY RV.REV_COST_SEQ) FROM BKG_REV_COST RV WHERE RV.BKG_NO = AA.BKG_NO) AS CMPB" ).append("\n"); 
		query.append("FROM (      " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           A.BKG_NO" ).append("\n"); 
		query.append("          ,A.BKG_STS_CD" ).append("\n"); 
		query.append("          ,A.STANDBY_TYPE" ).append("\n"); 
		query.append("--          ,A.STANDBY_REASON" ).append("\n"); 
		query.append("--          ,A.ALOC_SVC_CD" ).append("\n"); 
		query.append("          ,A.ALOC_STS_CD" ).append("\n"); 
		query.append("          ,A.CFM_RQST_FLG" ).append("\n"); 
		query.append("          ,A.CNDDT_CFM_FLG" ).append("\n"); 
		query.append("          ,A.CFM_USR_ID" ).append("\n"); 
		query.append("          ,A.CFM_DT" ).append("\n"); 
		query.append("#if($c_name.size() != 0)" ).append("\n"); 
		query.append("#foreach(${list} in ${c_name})" ).append("\n"); 
		query.append("	#if( ${list} != 'sc_no' && ${list} != 'rfa_no' && ${list} != 'ob_sls_ofc_cd' && ${list} != 'sub_trd_cd' && ${list} != 'vvd' && ${list} != 'acct_cd' && ${list} != 'bkg_no')" ).append("\n"); 
		query.append("          , A.${list}" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          ,A.FEU" ).append("\n"); 
		query.append("          ,A.TEU" ).append("\n"); 
		query.append("          ,A.SEASON" ).append("\n"); 
		query.append("          --,AGMT_CNT_CD" ).append("\n"); 
		query.append("          --,AGMT_CUST_SEQ" ).append("\n"); 
		query.append("          ,A.SC_NO" ).append("\n"); 
		query.append("          ,A.RFA_NO" ).append("\n"); 
		query.append("		  ,A.VVD" ).append("\n"); 
		query.append("#if (${f_cust_tp} != '')" ).append("\n"); 
		query.append("           ,MCC.CUST_CTRL_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           ,'' AS CUST_CTRL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           ,A.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("		   ,A.TRD_CD" ).append("\n"); 
		query.append("		   ,A.SUB_TRD_CD" ).append("\n"); 
		query.append("		   ,A.RLANE_CD" ).append("\n"); 
		query.append("		   ,A.DIR_CD" ).append("\n"); 
		query.append("		   ,A.ACOUNT_CD ACCT_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            BK.BKG_NO" ).append("\n"); 
		query.append("            , BK.BKG_STS_CD" ).append("\n"); 
		query.append("            , SSB.CFM_USR_ID" ).append("\n"); 
		query.append("            , SSB.CFM_DT" ).append("\n"); 
		query.append("            , BK.ALOC_SVC_CD" ).append("\n"); 
		query.append("            , BK.ALOC_STS_CD" ).append("\n"); 
		query.append("            , BK.BL_NO" ).append("\n"); 
		query.append("            , BK.SLS_RHQ_CD" ).append("\n"); 
		query.append("            , BK.BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("            , COA.TRD_CD" ).append("\n"); 
		query.append("            , COA.SUB_TRD_CD" ).append("\n"); 
		query.append("            , (SELECT /*+INDEX_DESC (MST XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                         DECODE( DECODE( HH.TRD_CD, NULL, 'N','Y'), 'Y', COST_YRWK||'-'||VER_SEQ, '200001-1')" ).append("\n"); 
		query.append("                    FROM SPC_MDL_VER_MST MST" ).append("\n"); 
		query.append("                   WHERE SUBSTR(COA.COST_YRMON,1,4)||COA.COST_WK BETWEEN MST.VER_ST_YRWK AND MST.VER_END_YRWK" ).append("\n"); 
		query.append("                     AND MST.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                     AND MST.TRD_CD  = COA.TRD_CD" ).append("\n"); 
		query.append("                     AND ROWNUM    = 1) AS SEASON" ).append("\n"); 
		query.append("            , BK.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("            , BK.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("            , BK.SLAN_CD               TRNK_SLAN_CD" ).append("\n"); 
		query.append("            , BK.SKD_DIR_CD            TRNK_DIR_CD" ).append("\n"); 
		query.append("            , BK.POL_CD                TRNK_POL" ).append("\n"); 
		query.append("            , BK.POD_CD                TRNK_POD" ).append("\n"); 
		query.append("            , BK.POR_CD                POR_LOC_CD" ).append("\n"); 
		query.append("            , BK.POR_NOD_CD            POR_NOD_CD" ).append("\n"); 
		query.append("            , (SELECT SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.POR_CD) POR_SCC_CD" ).append("\n"); 
		query.append("            , BK.POL_CD                POL_LOC_CD" ).append("\n"); 
		query.append("            , BK.POL_NOD_CD            POL_NOD_CD" ).append("\n"); 
		query.append("            , NVL((SELECT WM_CONCAT( VSL_SLAN_CD ) FROM VSK_VSL_SKD SKD WHERE SKD.VSL_CD = VVD.VSL_CD AND SKD.SKD_VOY_NO = VVD.SKD_VOY_NO AND SKD.SKD_DIR_CD = VVD.SKD_DIR_CD), 'X') TS_SLAN_CD" ).append("\n"); 
		query.append("            , (SELECT WM_CONCAT( NVL(SKD_DIR_CD, 'X') ) FROM BKG_VVD WHERE BKG_NO = SSB.BKG_NO ) TS_DIR_CD" ).append("\n"); 
		query.append("            , (SELECT WM_CONCAT( NVL(POL_CD, 'X') ) FROM BKG_VVD WHERE BKG_NO = SSB.BKG_NO ) TS_POL_CD" ).append("\n"); 
		query.append("            , (SELECT WM_CONCAT( NVL(POD_CD, 'X') ) FROM BKG_VVD WHERE BKG_NO = SSB.BKG_NO ) TS_POD_CD" ).append("\n"); 
		query.append("            , BK.POD_CD                POD_LOC_CD" ).append("\n"); 
		query.append("            , BK.POD_NOD_CD            POD_NOD_CD" ).append("\n"); 
		query.append("            , BK.DEL_CD                DEL_LOC_CD" ).append("\n"); 
		query.append("            , BK.DEL_NOD_CD            DEL_NOD_CD" ).append("\n"); 
		query.append("            , (SELECT SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.DEL_CD) DEL_SCC_CD" ).append("\n"); 
		query.append("            , BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("            , DECODE(COA.IOC_CD, 'T', DECODE(OFC.N2ND_PRNT_OFC_CD, 'SINRS', OFC.N4TH_PRNT_OFC_CD, BK.SLS_RHQ_CD, OFC.N4TH_PRNT_OFC_CD, " ).append("\n"); 
		query.append("                            DECODE(COA.RLANE_CD, 'WAFIE', OFC.N4TH_PRNT_OFC_CD, OFC.N2ND_PRNT_OFC_CD)), OFC.N4TH_PRNT_OFC_CD) OB_SLS_OFC_CD" ).append("\n"); 
		query.append("            , DECODE(BK.DCGO_FLG,'Y','DG', DECODE(BK.RD_CGO_FLG, 'Y', 'RD','')) DGRD" ).append("\n"); 
		query.append("            , BK.SC_NO" ).append("\n"); 
		query.append("            , BK.RFA_NO" ).append("\n"); 
		query.append("            , BK.CTRT_CUST_CNT_CD || NVL(LPAD(BK.CTRT_CUST_SEQ,6,'0'),'') ||':' ||(SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER CC WHERE CC.CUST_CNT_CD = BK.CTRT_CUST_CNT_CD AND CC.CUST_SEQ = BK.CTRT_CUST_SEQ) AS C_CUST" ).append("\n"); 
		query.append("            , BK.AGMT_ACT_CNT_CD  || NVL(LPAD(BK.AGMT_ACT_CUST_SEQ,6,'0'),'') ||':' ||(SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER CC WHERE CC.CUST_CNT_CD = BK.AGMT_ACT_CNT_CD AND CC.CUST_SEQ = BK.AGMT_ACT_CUST_SEQ) AS A_CUST" ).append("\n"); 
		query.append("            , SHPR.CUST_CNT_CD    || NVL(LPAD(SHPR.CUST_SEQ,6,'0'),'') || ':' || (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER CC WHERE CC.CUST_CNT_CD = SHPR.CUST_CNT_CD AND CC.CUST_SEQ = SHPR.CUST_SEQ) AS SHRP" ).append("\n"); 
		query.append("            , CNEE.CUST_CNT_CD    || NVL(LPAD(CNEE.CUST_SEQ,6,'0'),'') || ':' || (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER CC WHERE CC.CUST_CNT_CD = CNEE.CUST_CNT_CD AND CC.CUST_SEQ = CNEE.CUST_SEQ) AS CNEE" ).append("\n"); 
		query.append("            , FWDR.CUST_CNT_CD    || NVL(LPAD(FWDR.CUST_SEQ,6,'0'),'') || ':' || (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER CC WHERE CC.CUST_CNT_CD = FWDR.CUST_CNT_CD AND CC.CUST_SEQ = FWDR.CUST_SEQ) AS FWDR" ).append("\n"); 
		query.append("            , BK.CMDT_CD" ).append("\n"); 
		query.append("            , (SELECT CMDT.CMDT_NM FROM MDM_COMMODITY CMDT WHERE BK.CMDT_CD = CMDT.CMDT_CD) CMDT_DESC" ).append("\n"); 
		query.append("			, (SELECT WM_CONCAT( CNTR_TPSZ_CD ) FROM BKG_QUANTITY WHERE BKG_NO = BK.BKG_NO ) AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            , (SELECT SUM( DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', OP_CNTR_QTY, 0) ) FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("#if (${tp_sz} == '1')" ).append("\n"); 
		query.append("                AND CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            ) AS TEU" ).append("\n"); 
		query.append("            , (SELECT SUM( DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 0, OP_CNTR_QTY) ) FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("#if (${tp_sz} == '1')" ).append("\n"); 
		query.append("                AND CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             ) AS FEU" ).append("\n"); 
		query.append("            , SSB.CFM_RQST_FLG" ).append("\n"); 
		query.append("            , SSB.CNDDT_CFM_FLG" ).append("\n"); 
		query.append("            , DTL.LST_SB_RSN_TP_CD AS STANDBY_TYPE" ).append("\n"); 
		query.append("            , DTL.LST_SB_RSN AS STANDBY_REASON" ).append("\n"); 
		query.append("#if (${f_sls_ofc_cd} != '')" ).append("\n"); 
		query.append("            ,@[f_sls_ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			,''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" as ofc" ).append("\n"); 
		query.append("            ,@[f_level]      as lvl" ).append("\n"); 
		query.append("-- 20150502 김성욱, CONTRACT 관련" ).append("\n"); 
		query.append("            --, BK.AGMT_ACT_CNT_CD AS AGMT_CNT_CD   --D.AGMT_CNT_CD" ).append("\n"); 
		query.append("            --, BK.AGMT_ACT_CUST_SEQ AS AGMT_CUST_SEQ --D.AGMT_CUST_SEQ" ).append("\n"); 
		query.append("#if (${f_acct_cd} != '')" ).append("\n"); 
		query.append("            , NVL((" ).append("\n"); 
		query.append("                               -- A : Individul B: Actual C: Commodity" ).append("\n"); 
		query.append("									SELECT DISTINCT(D.CTRL_LOC_ACCT_CD)" ).append("\n"); 
		query.append("									  FROM ALOC_LANE_CTRL_OPT_DTL D" ).append("\n"); 
		query.append("									  WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_h_rlane_cd} != '')" ).append("\n"); 
		query.append("									   AND @[f_h_rlane_cd]        = D.RLANE_CD" ).append("\n"); 
		query.append("									   AND SPC_GET_REP_TRD_FNC(@[f_h_rlane_cd])      = D.TRD_CD" ).append("\n"); 
		query.append("									   AND SPC_GET_REP_SUB_TRD_FNC(@[f_h_rlane_cd])  = D.SUB_TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '')" ).append("\n"); 
		query.append("									   AND @[f_rlane_cd]        = D.RLANE_CD" ).append("\n"); 
		query.append("									   AND SPC_GET_REP_TRD_FNC(@[f_rlane_cd])      = D.TRD_CD" ).append("\n"); 
		query.append("									   AND SPC_GET_REP_SUB_TRD_FNC(@[f_rlane_cd])  = D.SUB_TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("									   AND 'E'                          = D.DIR_CD " ).append("\n"); 
		query.append("									   AND D.ALOC_CTRL_TP_CD                    IN ('A','B','C') " ).append("\n"); 
		query.append("				   					   -- 2015.02.16 control office관련 setting 추가" ).append("\n"); 
		query.append("									   -- 2015.04.06 office가 입력되지 않은 case는 전체 office에 걸리도록 함." ).append("\n"); 
		query.append("								       AND (( SPC_SCR_OFC_CONV_FNC(BK.OB_SLS_OFC_CD) IN " ).append("\n"); 
		query.append("                                              (SELECT OFC.OFC_CD" ).append("\n"); 
		query.append("                                                 FROM SPC_ALOC_LANE_CTRL_OFC OFC" ).append("\n"); 
		query.append("                                                WHERE D.RLANE_CD           = OFC.RLANE_CD" ).append("\n"); 
		query.append("								                  AND D.TRD_CD             = OFC.TRD_CD" ).append("\n"); 
		query.append("								                  AND D.SUB_TRD_CD         = OFC.SUB_TRD_CD" ).append("\n"); 
		query.append("								                  AND D.DIR_CD             = OFC.DIR_CD " ).append("\n"); 
		query.append("								                  AND D.ALOC_CTRL_TP_CD    = OFC.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("                                                  AND D.CTRL_LOC_ACCT_CD   = OFC.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("                                            ))" ).append("\n"); 
		query.append("                                            OR ( NOT EXISTS " ).append("\n"); 
		query.append("                                             ( SELECT 1" ).append("\n"); 
		query.append("                                                 FROM SPC_ALOC_LANE_CTRL_OFC OFC_ALL" ).append("\n"); 
		query.append("                                                WHERE D.RLANE_CD           = OFC_ALL.RLANE_CD" ).append("\n"); 
		query.append("                                                AND D.TRD_CD             = OFC_ALL.TRD_CD" ).append("\n"); 
		query.append("                                                AND D.SUB_TRD_CD         = OFC_ALL.SUB_TRD_CD" ).append("\n"); 
		query.append("								                AND D.DIR_CD             = OFC_ALL.DIR_CD " ).append("\n"); 
		query.append("								                AND D.ALOC_CTRL_TP_CD    = OFC_ALL.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("                                                AND D.CTRL_LOC_ACCT_CD   = OFC_ALL.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                                            ))" ).append("\n"); 
		query.append("									   -- 2015.02.16 add end" ).append("\n"); 
		query.append("									   AND (D.CTRL_LOC_ACCT_CD = BK.SC_NO OR D.CTRL_LOC_ACCT_CD = BK.RFA_NO)" ).append("\n"); 
		query.append("									   AND D.ALOC_CTRL_DTL_CD  = DECODE(D.ALOC_CTRL_TP_CD, 'A', BK.CTRT_CUST_CNT_CD ||LPAD(BK.CTRT_CUST_SEQ,6,'0')," ).append("\n"); 
		query.append("                                                                                       	   'B', BK.AGMT_ACT_CNT_CD ||LPAD(BK.AGMT_ACT_CUST_SEQ,6,'0')," ).append("\n"); 
		query.append("                                                                                           'C', BK.CMDT_CD)                                     " ).append("\n"); 
		query.append("                               ),'OTHERS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	, DTL.ACCT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AS ACOUNT_CD" ).append("\n"); 
		query.append("			, COA.RLANE_CD" ).append("\n"); 
		query.append("			, COA.DIR_CD" ).append("\n"); 
		query.append("            , DECODE( HH.TRD_CD , '' , '2' , '1' ) HH_CD --값이 있으면 HH , 없으면 BH" ).append("\n"); 
		query.append("        FROM MAS_MON_VVD COA" ).append("\n"); 
		query.append("            , BKG_BOOKING BK" ).append("\n"); 
		query.append("            , BKG_VVD VVD" ).append("\n"); 
		query.append("            , BKG_QUANTITY QTY" ).append("\n"); 
		query.append("            , BKG_CUSTOMER SHPR" ).append("\n"); 
		query.append("            , BKG_CUSTOMER CNEE" ).append("\n"); 
		query.append("            , BKG_CUSTOMER FWDR" ).append("\n"); 
		query.append("        --  , BKG_BL_DOC BL --BL관련 주석" ).append("\n"); 
		query.append("            , SPC_SB_BKG SSB" ).append("\n"); 
		query.append("			, SPC_SB_BKG_DTL DTL" ).append("\n"); 
		query.append("            ,(" ).append("\n"); 
		query.append("              SELECT L.CONTI_CD AS OFC_CONTI" ).append("\n"); 
		query.append("                FROM MDM_LOCATION     L" ).append("\n"); 
		query.append("                    ,MDM_ORGANIZATION O" ).append("\n"); 
		query.append("               WHERE L.LOC_CD = O.LOC_CD" ).append("\n"); 
		query.append("#if (${f_level} != '3' && (${f_sls_ofc_cd} == 'SINRS' || ${f_sls_ofc_cd} == 'SHARC' || ${f_sls_ofc_cd} == '' ) )" ).append("\n"); 
		query.append("	             AND O.OFC_CD = DECODE(@[f_sls_ofc_cd],'SHARC','SHARC','SINRS','SINRS', 'SHARC')    --HO BASE_RHQ_CD(SINWA,SHAAS)" ).append("\n"); 
		query.append("#elseif (${f_level} != '3' && (${f_sls_ofc_cd} == 'NYCRA' || ${f_sls_ofc_cd} == 'HAMRU'))" ).append("\n"); 
		query.append("                 AND O.OFC_CD = DECODE(@[f_sls_ofc_cd], 'NYCRA', 'NYCRA', 'HAMRU', 'HAMRU', '')     --RHQ BASE_RHQ_CD(NYCNA,HAMUR)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                 AND O.OFC_CD = NVL(@[f_sls_ofc_cd],@[f_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ) CONTI" ).append("\n"); 
		query.append("            , MDM_LOCATION LOC" ).append("\n"); 
		query.append("            , SPC_OFC_LVL OFC" ).append("\n"); 
		query.append("            , SPC_HD_HUL_MST HH" ).append("\n"); 
		query.append("            , MDM_COMMODITY    K" ).append("\n"); 
		query.append("            , (SELECT REP_CMDT_CD AS REP_CMDT_CD , REP_CMDT_NM AS REP_CMDT_DESC FROM MDM_REP_CMDT  WHERE NVL(DELT_FLG,'N') = 'N' ) F" ).append("\n"); 
		query.append("            , MDM_DTL_REV_LANE L" ).append("\n"); 
		query.append("            , MDM_LOCATION PL" ).append("\n"); 
		query.append("            , MDM_LOCATION PD" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("-- 20150502 김성욱, CONTRACT 관련" ).append("\n"); 
		query.append("--            and ioc_cd = 'O' --Trunk만 보는거라 O 만 검색, 아래 두줄을 이용해서 처리." ).append("\n"); 
		query.append("            and COA.TRD_CD     = SPC_GET_REP_TRD_FNC(COA.RLANE_CD)" ).append("\n"); 
		query.append("            AND COA.SUB_TRD_CD = SPC_GET_REP_SUB_TRD_FNC(COA.RLANE_CD)" ).append("\n"); 
		query.append("            AND BK.CMDT_CD              = K.CMDT_CD(+)" ).append("\n"); 
		query.append("            AND BK.REP_CMDT_CD          = F.REP_CMDT_CD" ).append("\n"); 
		query.append("            AND BK.BL_NO_TP             IN ('M','0')" ).append("\n"); 
		query.append("            AND BK.BKG_STS_CD           IN ('F','S','W')" ).append("\n"); 
		query.append("            AND BK.BKG_CGO_TP_CD        IN ('F', 'R')" ).append("\n"); 
		query.append("            AND COA.VSL_CD     = BK.VSL_CD" ).append("\n"); 
		query.append("            AND COA.SKD_VOY_NO = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND COA.DIR_CD     = BK.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND BK.BKG_NO      = VVD.BKG_NO" ).append("\n"); 
		query.append("			AND VVD.VSL_CD     = COA.VSL_CD" ).append("\n"); 
		query.append("            AND VVD.SKD_VOY_NO = COA.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND VVD.SKD_DIR_CD = COA.DIR_CD" ).append("\n"); 
		query.append("            AND BK.BKG_NO      = QTY.BKG_NO" ).append("\n"); 
		query.append("            AND BK.BKG_NO      = CNEE.BKG_NO(+)" ).append("\n"); 
		query.append("            AND BK.BKG_NO      = SHPR.BKG_NO" ).append("\n"); 
		query.append("            AND 'S'            = SHPR.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("            AND 'C'            = CNEE.BKG_CUST_TP_CD(+) -- S: SHIPPER[물품을 보내는자(송하인)], C:CONSIGNEE[물건을 받는자(수하인)], F:FORWARDER[운송취급인.운송주선인 이라고 하며, 화물을 인수하여 수하인에게 인도할 때까지 일체의 업무를 주선하는 사람]" ).append("\n"); 
		query.append("            AND BK.BKG_NO      = FWDR.BKG_NO(+)" ).append("\n"); 
		query.append("            AND 'F'            = FWDR.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("            AND SSB.BKG_NO(+)  = BK.BKG_NO" ).append("\n"); 
		query.append("			AND BK.BKG_NO = DTL.BKG_NO(+)" ).append("\n"); 
		query.append("            AND COA.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("            AND OFC.OFC_CD      = SPC_SCR_OFC_CONV_FNC(BK.OB_SLS_OFC_CD)" ).append("\n"); 
		query.append("#if (${f_sls_ofc_cd} == ${f_ofc_vw} && ${f_sls_ofc_cd}!='')" ).append("\n"); 
		query.append("            AND OFC.OFC_CD      = @[f_sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND OFC.OFC_TP_CD   IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("            AND SUBSTR(COA.SLS_YRMON,1,4)||COA.COST_WK BETWEEN OFC.OFC_APLY_FM_YRWK AND OFC.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("            AND BK.POL_CD      = LOC.LOC_CD" ).append("\n"); 
		query.append("            AND HH.TRD_CD(+) = COA.TRD_CD" ).append("\n"); 
		query.append("            AND HH.RLANE_CD(+) = COA.RLANE_CD" ).append("\n"); 
		query.append("            AND HH.DIR_CD(+) = COA.DIR_CD" ).append("\n"); 
		query.append("#if (${f_level} != '3' && (${f_sls_ofc_cd} == 'SINRS' || ${f_sls_ofc_cd} == 'SHARC' || ${f_sls_ofc_cd} == '') )" ).append("\n"); 
		query.append("            -- HO BASE_RHQ_CD(SINWA,SHAAS)" ).append("\n"); 
		query.append("            AND (    CONTI.OFC_CONTI = (SELECT SPC_CONTI_CONV_FNC(LOC.CONTI_CD, COA.RLANE_CD, COA.DIR_CD) FROM DUAL)" ).append("\n"); 
		query.append("                  OR OFC.N2ND_PRNT_OFC_CD = DECODE(@[f_sls_ofc_cd],'SHARC','SHARC','SINRS','SINRS', 'SHARC') " ).append("\n"); 
		query.append("#if (${f_sls_ofc_cd} == '')" ).append("\n"); 
		query.append("                  OR OFC.N2ND_PRNT_OFC_CD = 'SINRS'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                  OR (OFC.N2ND_PRNT_OFC_CD = 'SINRS' AND COA.RLANE_CD = 'WAXIA')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  OR COA.RLANE_CD         = 'WAFIE' )   " ).append("\n"); 
		query.append("#elseif (${f_level} != '3' && (${f_sls_ofc_cd} == 'NYCRA' || ${f_sls_ofc_cd} == 'HAMRU'))" ).append("\n"); 
		query.append("            --RHQ BASE_RHQ_CD(NYCNA,HAMUR)" ).append("\n"); 
		query.append("            AND VVD.VSL_PRE_PST_CD = 'T' -- RHQ는 TRUNK구간만." ).append("\n"); 
		query.append("            AND (    CONTI.OFC_CONTI = (SELECT SPC_CONTI_CONV_FNC(LOC.CONTI_CD, COA.RLANE_CD, COA.DIR_CD) FROM DUAL)" ).append("\n"); 
		query.append("                  OR OFC.N2ND_PRNT_OFC_CD = DECODE(@[f_sls_ofc_cd], 'NYCRA', 'NYCRA', 'HAMRU', 'HAMRU', '')  --RHQ BASE_RHQ_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            AND (OFC.N4TH_PRNT_OFC_CD = NVL(@[f_sls_ofc_cd],@[f_ofc_cd]) OR OFC.N5TH_PRNT_OFC_CD = NVL(@[f_sls_ofc_cd],@[f_ofc_cd]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vvd_cd} != '')" ).append("\n"); 
		query.append("            AND COA.VSL_CD     = SUBSTR(@[f_vvd_cd],1,4)--'COGN0009W'" ).append("\n"); 
		query.append("            AND COA.SKD_VOY_NO = SUBSTR(@[f_vvd_cd],5,4)" ).append("\n"); 
		query.append("            AND COA.DIR_CD     = SUBSTR(@[f_vvd_cd],-1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_bkg_no} != '')" ).append("\n"); 
		query.append("			AND BK.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_aloc_sts_cd} != '')" ).append("\n"); 
		query.append("#if (${f_aloc_sts_cd} == 'S')" ).append("\n"); 
		query.append("            AND BK.ALOC_STS_CD   IN ( 'S' , 'A' )" ).append("\n"); 
		query.append("#elseif (${f_aloc_sts_cd} == 'S->F')" ).append("\n"); 
		query.append("            AND BK.ALOC_STS_CD = 'F'" ).append("\n"); 
		query.append("            AND SSB.CFM_USR_ID IS NOT NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            AND BK.ALOC_STS_CD   = @[f_aloc_sts_cd]" ).append("\n"); 
		query.append("            AND SSB.CFM_USR_ID(+) IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            AND BK.ALOC_STS_CD   IN ( 'S' , 'A' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_h_trd_cd} != '' && ${f_h_rlane_cd} != '')" ).append("\n"); 
		query.append("            --AND COA.TRD_CD       = SPC_GET_REP_TRD_FNC([f_h_rlane_cd]) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_rlane_cd} != '')" ).append("\n"); 
		query.append("            --AND COA.TRD_CD       = SPC_GET_REP_TRD_FNC([f_rlane_cd]) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '')" ).append("\n"); 
		query.append("            AND COA.SUB_TRD_CD   = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("            AND COA.DIR_CD       = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_h_rlane_cd} != '')" ).append("\n"); 
		query.append("            AND COA.RLANE_CD     = @[f_h_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '')" ).append("\n"); 
		query.append("            AND COA.RLANE_CD     = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_bkg_pol_cd} != '' && ${f_bkg_pol_cd} != '1' && ${f_bkg_pol_cd} != '0')" ).append("\n"); 
		query.append("            AND VVD.POL_YD_CD     = @[f_bkg_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_bkg_pod_cd} != '' && ${f_bkg_pod_cd} != '1' && ${f_bkg_pod_cd} != '0')" ).append("\n"); 
		query.append("            AND VVD.POD_YD_CD     = @[f_bkg_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vvd_cd} == '' && ${f_year} != '' && ${f_week} != '' && ${f_duration} != '')" ).append("\n"); 
		query.append("            AND SUBSTR(COA.SLS_YRMON,1,4)||COA.COST_WK IN" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT /*+ INDEX(XPKMAS_WK_PRD)*/ D.COST_YR||D.COST_WK" ).append("\n"); 
		query.append("                  FROM MAS_WK_PRD D" ).append("\n"); 
		query.append("                 WHERE D.COST_YR||D.COST_WK >= @[f_year]||@[f_week] " ).append("\n"); 
		query.append("                   AND ROWNUM <= TO_NUMBER(@[f_duration]) " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_sdate} != '' && ${f_edate} != '')" ).append("\n"); 
		query.append("					AND BK.CRE_DT > TO_DATE(@[f_sdate],'YYYY-MM-DD') AND BK.CRE_DT <= TO_DATE(@[f_edate],'YYYY-MM-DD')+1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND PL.LOC_CD          = VVD.POL_CD" ).append("\n"); 
		query.append("           AND PD.LOC_CD          = VVD.POD_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("           AND L.RLANE_CD         = COA.RLANE_CD" ).append("\n"); 
		query.append("           AND L.VSL_SLAN_DIR_CD  = COA.DIR_CD" ).append("\n"); 
		query.append("           AND L.IOC_CD           = COA.IOC_CD" ).append("\n"); 
		query.append("           AND L.FM_CONTI_CD      = SPC_CONTI_CONV_FNC(PL.CONTI_CD, L.RLANE_CD, L.VSL_SLAN_DIR_CD)" ).append("\n"); 
		query.append("           AND L.TO_CONTI_CD      = SPC_CONTI_CONV_FNC(PD.CONTI_CD, L.RLANE_CD, L.VSL_SLAN_DIR_CD)" ).append("\n"); 
		query.append("--           AND L.TRD_CD           = COA.TRD_CD" ).append("\n"); 
		query.append("--           AND L.SUB_TRD_CD       = COA.SUB_TRD_CD" ).append("\n"); 
		query.append("           AND L.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ) A, SPC_MDL_CUST_CTRL MCC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("            AND MCC.TRD_CD(+) = A.TRD_CD" ).append("\n"); 
		query.append("    --            AND MCC.SUB_TRD_CD(+) = A.SUB_TRD_CD" ).append("\n"); 
		query.append("            AND MCC.COST_YRWK(+) = SUBSTR(A.SEASON,1,6)" ).append("\n"); 
		query.append("            AND MCC.VER_SEQ(+) = SUBSTR(A.SEASON,8)" ).append("\n"); 
		query.append("            AND MCC.CUST_CNT_CD(+) = A.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("            AND MCC.CUST_SEQ(+) = A.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("#if (${f_cust_tp} != '' && ${f_cust_tp} != 'C' && ${f_cust_tp} != '1')" ).append("\n"); 
		query.append("            AND MCC.CUST_CTRL_CD = @[f_cust_tp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sb_rsn_tp_cd} != '')" ).append("\n"); 
		query.append("            AND NVL(STANDBY_TYPE,' ') = SUBSTR(@[f_sb_rsn_tp_cd],1,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cust_tp} != '' && ${f_cust_tp} != '1' && ${f_cust_tp} == 'C' )" ).append("\n"); 
		query.append("			AND NVL(A.SC_NO, NVL(A.RFA_NO, 'X')) = NVL(MCC.SC_NO(+), NVL(MCC.RFA_NO(+), 'X'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_ofc_vw} != '' )" ).append("\n"); 
		query.append("			--AND SPC_SCR_OFC_CONV_FNC( OB_SLS_OFC_CD ) = [f_ofc_vw] --이미위에서 걸려있는데 " ).append("\n"); 
		query.append("            AND OFC.OFC_CD = @[f_ofc_vw]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_acct_cd} != '' && ${f_acct_cd} != '1')" ).append("\n"); 
		query.append("		    AND ACOUNT_CD = @[f_acct_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != '0')" ).append("\n"); 
		query.append("			AND HH_CD = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("          A.BKG_NO" ).append("\n"); 
		query.append("          ,A.BKG_STS_CD" ).append("\n"); 
		query.append("          ,A.STANDBY_TYPE" ).append("\n"); 
		query.append("--          ,A.STANDBY_REASON" ).append("\n"); 
		query.append("--          ,A.ALOC_SVC_CD" ).append("\n"); 
		query.append("          ,A.ALOC_STS_CD" ).append("\n"); 
		query.append("          ,A.CFM_RQST_FLG" ).append("\n"); 
		query.append("          ,A.CNDDT_CFM_FLG" ).append("\n"); 
		query.append("          ,A.CFM_USR_ID" ).append("\n"); 
		query.append("          ,A.CFM_DT" ).append("\n"); 
		query.append("#if($c_name.size() != 0)" ).append("\n"); 
		query.append("#foreach(${list} in ${c_name})" ).append("\n"); 
		query.append("	#if( ${list} != 'sc_no' && ${list} != 'rfa_no' && ${list} != 'ob_sls_ofc_cd' && ${list} != 'sub_trd_cd' && ${list} != 'vvd' && ${list} != 'acct_cd' && ${list} != 'bkg_no' )" ).append("\n"); 
		query.append("          , A.${list}" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          ,A.FEU" ).append("\n"); 
		query.append("          ,A.TEU" ).append("\n"); 
		query.append("          ,A.SEASON" ).append("\n"); 
		query.append("          ,A.SC_NO" ).append("\n"); 
		query.append("          ,A.RFA_NO" ).append("\n"); 
		query.append("          ,A.VVD" ).append("\n"); 
		query.append("#if (${f_cust_tp} != '')" ).append("\n"); 
		query.append("           ,MCC.CUST_CTRL_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           ,MCC.CUST_CTRL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           ,A.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("		   ,A.TRD_CD" ).append("\n"); 
		query.append("           ,A.SUB_TRD_CD" ).append("\n"); 
		query.append("		   ,A.RLANE_CD" ).append("\n"); 
		query.append("		   ,A.DIR_CD" ).append("\n"); 
		query.append("		   ,A.ACOUNT_CD" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("--# if ($ {f_hul_bnd_cd} != '' && $ {f_hul_bnd_cd} != '0')" ).append("\n"); 
		query.append("--					and (" ).append("\n"); 
		query.append("--                      SELECT DECODE( COUNT(*) , 0, '2' , '1') AA" ).append("\n"); 
		query.append("--                      FROM SPC_HD_HUL_MST" ).append("\n"); 
		query.append("--                      WHERE 1=1" ).append("\n"); 
		query.append("--							AND TRD_CD    = TRD_CD" ).append("\n"); 
		query.append("--                            AND SUB_TRD_CD = SUB_TRD_CD" ).append("\n"); 
		query.append("--                            AND RLANE_CD  = RLANE_CD" ).append("\n"); 
		query.append("--                              AND DIR_CD  = DIR_CD" ).append("\n"); 
		query.append("--                      ) = @ [f_hul_bnd_cd]" ).append("\n"); 
		query.append("--# end" ).append("\n"); 
		query.append("#if (${f_cust_tp} == 'C')" ).append("\n"); 
		query.append("          AND NVL(CUST_CTRL_CD,'C') = @[f_cust_tp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY AA.TRD_CD, AA.SUB_TRD_CD, AA.RLANE_CD DESC" ).append("\n"); 

	}
}
