/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortTimePerformanceMgtDBDAOSearchGraphBaselineListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.04.28 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTimePerformanceMgtDBDAOSearchGraphBaselineListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.07.09 문동선 [CHM-201218855-01] Base line 입력화면 추가 / Dashboard에 반영
	  * 2016.04.28 Arie Im CHM-201641178 아프리카 대륙 구주지역본부/동서남아지역본부 구분 로직 추가
	  * </pre>
	  */
	public PortTimePerformanceMgtDBDAOSearchGraphBaselineListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_kpi_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kpi_tgt_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerformanceMgtDBDAOSearchGraphBaselineListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	  --BSEL_YR	        " ).append("\n"); 
		query.append("       SLAN_CD           " ).append("\n"); 
		query.append("     , VPS_PORT_CD      AS PORT_CD" ).append("\n"); 
		query.append("     --, BSEL_VER_SEQ      " ).append("\n"); 
		query.append("     --, FM_EFF_DT         " ).append("\n"); 
		query.append("     --, TO_EFF_DT         " ).append("\n"); 
		query.append("     , TTL_CNTR_MV_KNT  AS TTL_MVS" ).append("\n"); 
		query.append("     , STM_IN_HRS       " ).append("\n"); 
		query.append("     , VSL_ARR_HRS      " ).append("\n"); 
		query.append("     , TML_OP_HRS       " ).append("\n"); 
		query.append("     , VSL_DEP_HRS      " ).append("\n"); 
		query.append("     , GRS_CRN_PROD_HRS " ).append("\n"); 
		query.append("     , RHQ              " ).append("\n"); 
		query.append("     , PORT_BSEL_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("     , CLPT_IND_SEQ     " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT  BSEL_YR           , SLAN_CD           , VPS_PORT_CD        , BSEL_VER_SEQ" ).append("\n"); 
		query.append("            , FM_EFF_DT         , TO_EFF_DT         , TTL_CNTR_MV_KNT    , STM_IN_HRS" ).append("\n"); 
		query.append("            , VSL_ARR_HRS       , TML_OP_HRS        , VSL_DEP_HRS        , GRS_CRN_PROD_HRS   " ).append("\n"); 
		query.append("            , NET_CRN_PROD_HRS                             " ).append("\n"); 
		query.append("            , (" ).append("\n"); 
		query.append("              SELECT  CASE WHEN NVL(ML.DELT_FLG,'N') <> 'N' OR ML.CALL_PORT_FLG <> 'Y' THEN ''" ).append("\n"); 
		query.append("                      ELSE O.OFC_N3RD_LVL_CD " ).append("\n"); 
		query.append("--                           CASE WHEN ML.CONTI_CD  IN ('E','F') AND ML.LOC_CD NOT IN('EGAIS','ZADUR','RUVVO')               THEN 'HAMRU'" ).append("\n"); 
		query.append("--                                WHEN ML.CONTI_CD  = 'M'                                                                    THEN 'NYCRA'" ).append("\n"); 
		query.append("--                                WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF'  THEN DECODE(ML.CNT_CD,'KR','SELIB','JP','TYOIB','SHARC')" ).append("\n"); 
		query.append("--                                WHEN (ML.CONTI_CD = 'A'        AND ML.SCONTI_CD <> 'AF') OR ML.LOC_CD IN ('EGAIS','ZADUR') THEN 'SINRS'" ).append("\n"); 
		query.append("--								WHEN ML.CONTI_CD  IN ('E') AND ML.LOC_CD = 'RUVVO' THEN 'VVOIA'" ).append("\n"); 
		query.append("--                                ELSE ''" ).append("\n"); 
		query.append("--                           END" ).append("\n"); 
		query.append("                      END" ).append("\n"); 
		query.append("                FROM MDM_LOCATION  ML, MAS_OFC_LVL O" ).append("\n"); 
		query.append("               WHERE ML.LOC_CD = T.VPS_PORT_CD" ).append("\n"); 
		query.append("                	AND ML.EQ_CTRL_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("                	AND ML.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                	AND ML.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("                	AND O.OFC_APLY_TO_YRMON ='999912'" ).append("\n"); 
		query.append("                	AND O.OFC_LVL < 9" ).append("\n"); 
		query.append("               ) RHQ " ).append("\n"); 
		query.append("            , T.PORT_BSEL_DIR_CD" ).append("\n"); 
		query.append("            , T.CLPT_IND_SEQ                  " ).append("\n"); 
		query.append("        FROM OPF_PORT_TM_BSEL T" ).append("\n"); 
		query.append("       WHERE 1=1" ).append("\n"); 
		query.append("         AND SLAN_CD      = @[slan_cd]				-- 'CAX'" ).append("\n"); 
		query.append("         AND VPS_PORT_CD  = @[port_cd]				-- 'KRPUS'" ).append("\n"); 
		query.append("         AND PORT_BSEL_DIR_CD = @[port_kpi_dir_cd]	-- 'W'" ).append("\n"); 
		query.append("         AND CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("		 AND BSEL_VER_SEQ = '1'						-- '1'  					" ).append("\n"); 
		query.append("         AND BSEL_YR   = @[kpi_tgt_yr] -1	 		-- '2011'" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND RHQ    = @[rhq_ofc_cd]" ).append("\n"); 

	}
}