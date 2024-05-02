/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOBsaInformationEntryListForTargetExcelDulTrdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOBsaInformationEntryListForTargetExcelDulTrdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 동일 노선 이중 Trade인 경우
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOBsaInformationEntryListForTargetExcelDulTrdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yr_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yr_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOBsaInformationEntryListForTargetExcelDulTrdRSQL").append("\n"); 
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
		query.append("WITH BSA AS (" ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("         SUBSTR(A1.SLS_YRMON,0,4) ||'-'|| A1.COST_WK AS COST_YRWK   			" ).append("\n"); 
		query.append("        ,A3.TRD_CD " ).append("\n"); 
		query.append("        ,A3.RLANE_CD " ).append("\n"); 
		query.append("        ,A3.VSL_CD " ).append("\n"); 
		query.append("        ,A3.SKD_VOY_NO " ).append("\n"); 
		query.append("        ,A3.SKD_DIR_CD " ).append("\n"); 
		query.append("        ,A4.CRR_CD " ).append("\n"); 
		query.append("        ,A3.CRR_CD AS CRR_CD2" ).append("\n"); 
		query.append("        ,CASE   WHEN A4.BSA_OP_JB_CD IN ('001','002','004') THEN 'R'" ).append("\n"); 
		query.append("                WHEN A4.BSA_OP_JB_CD IN ('000','003','005') THEN 'E' " ).append("\n"); 
		query.append("                END AS RE_DIVR_CD" ).append("\n"); 
		query.append("		,A4.CRR_BSA_CAPA           " ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("        MAS_MON_VVD A1," ).append("\n"); 
		query.append("        MAS_LANE_RGST A2," ).append("\n"); 
		query.append("        BSA_VVD_MST A3," ).append("\n"); 
		query.append("        BSA_VVD_CRR_PERF A4," ).append("\n"); 
		query.append("        MDM_VSL_CNTR A5  " ).append("\n"); 
		query.append("    WHERE A1.TRD_CD     = A3.TRD_CD  " ).append("\n"); 
		query.append("    AND A1.RLANE_CD   = A3.RLANE_CD  " ).append("\n"); 
		query.append("    AND A1.IOC_CD     = A3.IOC_CD  " ).append("\n"); 
		query.append("    AND A1.VSL_CD     = A3.VSL_CD  " ).append("\n"); 
		query.append("    AND A1.SKD_VOY_NO = A3.SKD_VOY_NO  " ).append("\n"); 
		query.append("    AND A1.DIR_CD     = A3.SKD_DIR_CD  " ).append("\n"); 
		query.append("    AND A1.TRD_CD     = A2.TRD_CD  " ).append("\n"); 
		query.append("    AND A1.RLANE_CD   = A2.RLANE_CD  " ).append("\n"); 
		query.append("    AND A1.DIR_CD     = A2.DIR_CD  " ).append("\n"); 
		query.append("    AND A1.IOC_CD     = A2.IOC_CD  " ).append("\n"); 
		query.append("    AND A3.TRD_CD     = A4.TRD_CD(+) " ).append("\n"); 
		query.append("    AND A3.RLANE_CD   = A4.RLANE_CD(+) " ).append("\n"); 
		query.append("    AND A3.VSL_CD     = A4.VSL_CD(+) " ).append("\n"); 
		query.append("    AND A3.SKD_VOY_NO = A4.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("    AND A3.SKD_DIR_CD = A4.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("    AND A1.VSL_CD     = A5.VSL_CD(+) " ).append("\n"); 
		query.append("    AND A4.CRR_CD(+)  != 'SML' " ).append("\n"); 
		query.append("    AND A4.BSA_OP_JB_CD IN ('000','001','002','003','004','005')    " ).append("\n"); 
		query.append("    AND A1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND NVL(A2.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("    AND A4.CRR_BSA_CAPA > 0  -- ???" ).append("\n"); 
		query.append("#if (${trd_cd}!= '')" ).append("\n"); 
		query.append("    AND A3.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd}!= '')" ).append("\n"); 
		query.append("	AND A1.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd}!= '')" ).append("\n"); 
		query.append("	AND A4.CRR_CD        = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd}!= '')" ).append("\n"); 
		query.append("	AND A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD like @[vvd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("), BSA_ALL AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           A.COST_YRWK" ).append("\n"); 
		query.append("         , 'SELADG' AS OFC_CD" ).append("\n"); 
		query.append("         , A.RE_DIVR_CD" ).append("\n"); 
		query.append("         , A.TRD_CD" ).append("\n"); 
		query.append("         , A.RLANE_CD" ).append("\n"); 
		query.append("         , A.CRR_CD         " ).append("\n"); 
		query.append("         , A.VSL_CD" ).append("\n"); 
		query.append("         , A.SKD_VOY_NO" ).append("\n"); 
		query.append("         , A.SKD_DIR_CD   " ).append("\n"); 
		query.append("         , 'ALL' AS PORT_CD" ).append("\n"); 
		query.append("         , '1'   AS PORT_SEQ" ).append("\n"); 
		query.append("		 , A.CRR_BSA_CAPA        " ).append("\n"); 
		query.append("		 , '20000101000000' AS VPS_ETD_DT" ).append("\n"); 
		query.append("    FROM BSA A" ).append("\n"); 
		query.append("), BSA_ALL2 AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           A.COST_YRWK AS YRWK" ).append("\n"); 
		query.append("         , 'SELADG' AS OFC_CD" ).append("\n"); 
		query.append("         , A.RE_DIVR_CD" ).append("\n"); 
		query.append("         , A.TRD_CD" ).append("\n"); 
		query.append("         , A.RLANE_CD" ).append("\n"); 
		query.append("         , A.CRR_CD         " ).append("\n"); 
		query.append("         , A.VSL_CD" ).append("\n"); 
		query.append("         , A.SKD_VOY_NO" ).append("\n"); 
		query.append("         , A.SKD_DIR_CD" ).append("\n"); 
		query.append("         , K.VPS_PORT_CD    AS PORT_CD" ).append("\n"); 
		query.append("         , K.CLPT_IND_SEQ   AS PORT_SEQ" ).append("\n"); 
		query.append("         , K.CLPT_SEQ " ).append("\n"); 
		query.append("         , '2' AS GUBUN" ).append("\n"); 
		query.append("         , A.TRD_CD || A.RLANE_CD || A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD     " ).append("\n"); 
		query.append("		 , A.CRR_BSA_CAPA           " ).append("\n"); 
		query.append("	     , TO_CHAR(K.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS VPS_ETD_DT" ).append("\n"); 
		query.append("    FROM BSA A, VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND K.TURN_PORT_IND_CD NOT IN ('D','V','F')  " ).append("\n"); 
		query.append("    AND NVL(K.SKD_CNG_STS_CD, 'A') <>  'S' " ).append("\n"); 
		query.append("    AND A.VSL_CD = K.VSL_CD" ).append("\n"); 
		query.append("    AND A.SKD_VOY_NO = K.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND A.SKD_DIR_CD = K.SKD_DIR_CD" ).append("\n"); 
		query.append("), BSA_ALL3 AS (" ).append("\n"); 
		query.append("    SELECT T.* FROM BSA_ALL2 T, JOO_SAM_REV_LANE_DIFF_TRD J  " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND T.RLANE_CD = J.RLANE_CD " ).append("\n"); 
		query.append("    AND T.SKD_DIR_CD = J.SKD_DIR_CD " ).append("\n"); 
		query.append("    AND T.TRD_CD = J.TRD_CD " ).append("\n"); 
		query.append("    AND T.PORT_CD = J.VPS_PORT_CD " ).append("\n"); 
		query.append("), BSA_ALL4 AS (" ).append("\n"); 
		query.append("    SELECT  A.COST_YRWK AS YRWK" ).append("\n"); 
		query.append("           ,A.OFC_CD" ).append("\n"); 
		query.append("           ,A.RE_DIVR_CD" ).append("\n"); 
		query.append("           ,A.TRD_CD" ).append("\n"); 
		query.append("           ,A.RLANE_CD" ).append("\n"); 
		query.append("           ,A.CRR_CD           " ).append("\n"); 
		query.append("           ,A.VSL_CD" ).append("\n"); 
		query.append("           ,A.SKD_VOY_NO       " ).append("\n"); 
		query.append("           ,A.SKD_DIR_CD       " ).append("\n"); 
		query.append("           ,A.PORT_CD" ).append("\n"); 
		query.append("           ,A.PORT_SEQ" ).append("\n"); 
		query.append("           ,1 AS CLPT_SEQ            " ).append("\n"); 
		query.append("           ,'1' AS GUBUN            " ).append("\n"); 
		query.append("           , A.TRD_CD || A.RLANE_CD || A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("		   , A.CRR_BSA_CAPA		" ).append("\n"); 
		query.append("		   , A.VPS_ETD_DT" ).append("\n"); 
		query.append("    FROM BSA_ALL A" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT  A.YRWK" ).append("\n"); 
		query.append("           ,A.OFC_CD" ).append("\n"); 
		query.append("           ,A.RE_DIVR_CD" ).append("\n"); 
		query.append("           ,A.TRD_CD" ).append("\n"); 
		query.append("           ,A.RLANE_CD" ).append("\n"); 
		query.append("           ,A.CRR_CD           " ).append("\n"); 
		query.append("           ,A.VSL_CD" ).append("\n"); 
		query.append("           ,A.SKD_VOY_NO       " ).append("\n"); 
		query.append("           ,A.SKD_DIR_CD       " ).append("\n"); 
		query.append("           ,A.PORT_CD" ).append("\n"); 
		query.append("           ,A.PORT_SEQ" ).append("\n"); 
		query.append("           ,1 AS CLPT_SEQ            " ).append("\n"); 
		query.append("           ,'2' AS GUBUN            " ).append("\n"); 
		query.append("           ,A.VVD" ).append("\n"); 
		query.append("		   ,A.CRR_BSA_CAPA" ).append("\n"); 
		query.append("		   ,A.VPS_ETD_DT" ).append("\n"); 
		query.append("    FROM BSA_ALL3 A    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       A.YRWK" ).append("\n"); 
		query.append("     , A.OFC_CD" ).append("\n"); 
		query.append("     , DECODE(A.RE_DIVR_CD,'R','Rev','Exp') RE_DIVR_CD" ).append("\n"); 
		query.append("     , A.TRD_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.PORT_CD" ).append("\n"); 
		query.append("     , A.PORT_SEQ" ).append("\n"); 
		query.append("     , A.CRR_CD             AS JO_CRR_CD" ).append("\n"); 
		query.append("	 , DECODE(J.JO_BSA_TEU_QTY,NULL,A.CRR_BSA_CAPA,J.JO_BSA_TEU_QTY) AS JO_BSA_TEU_QTY          -- 20150911 ???" ).append("\n"); 
		query.append("     , J.JO_BSA_ADD_TEU_QTY" ).append("\n"); 
		query.append("     , J.JO_ADD_BSA_CRR_FLG" ).append("\n"); 
		query.append("     , J.JO_OVR_BSA_TEU_QTY" ).append("\n"); 
		query.append("     , J.JO_TON_TEU_QTY" ).append("\n"); 
		query.append("     , J.JO_OVR_TON_WGT" ).append("\n"); 
		query.append("     , J.JO_20FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("     , J.JO_20FT_OVR_RTO" ).append("\n"); 
		query.append("     , J.JO_40FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("     , J.JO_40FT_OVR_RTO" ).append("\n"); 
		query.append("     , J.JO_45FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("     , J.JO_45FT_OVR_RTO" ).append("\n"); 
		query.append("     , J.JO_45FT_UND_RTO" ).append("\n"); 
		query.append("     , J.JO_RND_KND_FLG" ).append("\n"); 
		query.append("     , J.JO_RND_RULE_LVL" ).append("\n"); 
		query.append("     , J.JO_RF_OCN_TEU_QTY" ).append("\n"); 
		query.append("     , J.JO_RF_INTER_TEU_QTY" ).append("\n"); 
		query.append("     , J.JO_INTER_OVR_FLG" ).append("\n"); 
		query.append("     , J.JO_RDR_PORT_CD" ).append("\n"); 
		query.append("     , TO_CHAR(TO_DATE(J.REV_PORT_ETD_DT,'YYYY-MM-DD'),'YYYY-MM-DD') REV_PORT_ETD_DT" ).append("\n"); 
		query.append("     , J.JO_FSH_FLG" ).append("\n"); 
		query.append("     , J.JO_BSA_PRC" ).append("\n"); 
		query.append("     , J.JO_OVR_OCN_PRC" ).append("\n"); 
		query.append("     , J.JO_OVR_INTER_PRC" ).append("\n"); 
		query.append("     , J.JO_OVR_MT_OCN_PRC" ).append("\n"); 
		query.append("     , J.JO_OVR_MT_INTER_PRC" ).append("\n"); 
		query.append("     , J.JO_SCTR_PRC_FLG" ).append("\n"); 
		query.append("     , J.JO_RF_OCN_PRC" ).append("\n"); 
		query.append("     , J.JO_RF_INTER_PRC" ).append("\n"); 
		query.append("     , J.JO_PRC_FSH_FLG" ).append("\n"); 
		query.append("     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.PORT_CD||A.PORT_SEQ||J.JO_CRR_CD VVD_PORT" ).append("\n"); 
		query.append("     , J.JO_BSA_ENTR_RDR_RMK" ).append("\n"); 
		query.append("     , J.JO_BSA_ENTR_RMK" ).append("\n"); 
		query.append("     , TO_CHAR(J.UPD_DT, 'YYYY-MM-DD')  UPD_DT" ).append("\n"); 
		query.append("     , J.UPD_USR_ID " ).append("\n"); 
		query.append("     , U.USR_NM " ).append("\n"); 
		query.append("     , J.DELT_FLG   " ).append("\n"); 
		query.append("FROM BSA_ALL4 A, JOO_BSA_AGMT J, COM_USER U" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("	AND A.TRD_CD        = J.TRD_CD(+)" ).append("\n"); 
		query.append("	AND A.RLANE_CD      = J.RLANE_CD(+)" ).append("\n"); 
		query.append("	AND A.VSL_CD        = J.VSL_CD(+)" ).append("\n"); 
		query.append("	AND A.SKD_VOY_NO    = J.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("	AND A.SKD_DIR_CD    = J.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("	AND A.CRR_CD        = J.JO_CRR_CD(+)" ).append("\n"); 
		query.append("	AND A.PORT_CD       = J.PORT_CD(+)" ).append("\n"); 
		query.append("	AND A.PORT_SEQ      = J.PORT_SEQ(+)" ).append("\n"); 
		query.append("	AND J.UPD_USR_ID    = U.USR_ID(+)" ).append("\n"); 
		query.append("#if (${trd_cd}!= '')" ).append("\n"); 
		query.append("    AND A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd}!= '')" ).append("\n"); 
		query.append("	AND A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd}!= '')" ).append("\n"); 
		query.append("	AND A.CRR_CD        = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd}!= '')" ).append("\n"); 
		query.append("    AND A.SKD_DIR_CD    =  @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_yr_wk}!= '')" ).append("\n"); 
		query.append("    AND A.YRWK BETWEEN @[fm_yr_wk] AND @[to_yr_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd}!= '')" ).append("\n"); 
		query.append("    AND A.PORT_CD       =  @[port_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${re_divr_cd}!= '')" ).append("\n"); 
		query.append("    AND A.RE_DIVR_CD    =  @[re_divr_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_etd_dt}!= '')" ).append("\n"); 
		query.append("    AND A.REV_PORT_ETD_DT  BETWEEN  REPLACE (@[fm_etd_dt], '-', '') AND REPLACE (@[to_etd_dt], '-', '')  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd}!= '')" ).append("\n"); 
		query.append("    AND A.OFC_CD        =  @[ofc_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd}!= '')" ).append("\n"); 
		query.append("	AND A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD like @[vvd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	ORDER BY VVD, GUBUN, VPS_ETD_DT, JO_CRR_CD ASC" ).append("\n"); 

	}
}