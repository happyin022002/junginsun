/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OptimumRoutePassDBDAOsearchBkgDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OptimumRoutePassDBDAOsearchBkgDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Optimum Route Detail에서 선택한 BKG 세부사항을 조회한다.
	  * </pre>
	  */
	public OptimumRoutePassDBDAOsearchBkgDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.integration").append("\n"); 
		query.append("FileName : OptimumRoutePassDBDAOsearchBkgDtlRSQL").append("\n"); 
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
		query.append("        BKG_NO, SO_NO, WO_NO" ).append("\n"); 
		query.append("        ,COP_NO, EQ_NO, EQ_TPSZ_CD, WO_CRE_OFC_CD" ).append("\n"); 
		query.append("        ,TRSP_BND_CD, TRSP_COST_DTL_MOD_CD, TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("        ,FM_NOD_CD, VIA_NOD_CD, TO_NOD_CD, DOR_NOD_CD, TRS_SO_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        A.BKG_NO" ).append("\n"); 
		query.append("        ,A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ AS SO_NO, A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("        ,A.COP_NO, A.EQ_NO, A.EQ_TPSZ_CD, DECODE(A.CRE_OFC_CD, 'SYSTEM', 'PHXSA', A.CRE_OFC_CD) AS WO_CRE_OFC_CD" ).append("\n"); 
		query.append("        ,A.TRSP_BND_CD, DECODE(A.TRSP_COST_DTL_MOD_CD, 'CY', 'CY', 'DR', 'DOOR', 'CY') AS TRSP_COST_DTL_MOD_CD, A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("        ,A.FM_NOD_CD, A.VIA_NOD_CD, A.TO_NOD_CD, A.DOR_NOD_CD" ).append("\n"); 
		query.append("        ,REPLACE(A.CNG_RSN_DESC, CHR(13)||CHR(10), ' ') AS TRS_SO_RMK" ).append("\n"); 
		query.append("    FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("        AND A.TRSP_COST_DTL_MOD_CD IN ('CY', 'DR')" ).append("\n"); 
		query.append("#if (${sel_op_tp} == 'SINGLE')" ).append("\n"); 
		query.append("        AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND A.TRSP_BND_CD = @[bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_op_tp} != 'SINGLE')" ).append("\n"); 
		query.append("			AND	(A.BKG_NO, A.TRSP_BND_CD)" ).append("\n"); 
		query.append("				IN (" ).append("\n"); 
		query.append("			  #foreach ($user_condtions IN ${condtions})" ).append("\n"); 
		query.append("				#if($velocityCount < $condtions.size())" ).append("\n"); 
		query.append("				  $user_condtions," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				  $user_condtions" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        A.BKG_NO" ).append("\n"); 
		query.append("        ,A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ AS SO_NO, A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("        ,A.COP_NO, A.EQ_NO, A.EQ_TPSZ_CD, DECODE(A.CRE_OFC_CD, 'SYSTEM', 'PHXSA', A.CRE_OFC_CD) AS WO_CRE_OFC_CD" ).append("\n"); 
		query.append("        ,A.TRSP_BND_CD, DECODE(A.TRSP_COST_DTL_MOD_CD, 'CY', 'CY', 'DR', 'DOOR', 'CY') AS TRSP_COST_DTL_MOD_CD, A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("        ,A.FM_NOD_CD, A.VIA_NOD_CD, A.TO_NOD_CD, A.DOR_NOD_CD" ).append("\n"); 
		query.append("        ,REPLACE(A.CNG_RSN_DESC, CHR(13)||CHR(10), ' ') AS TRS_SO_RMK" ).append("\n"); 
		query.append("    FROM TRS_TRSP_SVC_ORD A, TRS_TRSP_OPTM_USA_ROUT B" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("        AND A.TRSP_COST_DTL_MOD_CD IN ('LS')" ).append("\n"); 
		query.append("#if (${sel_op_tp} == 'SINGLE')" ).append("\n"); 
		query.append("        AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND A.TRSP_BND_CD = @[bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_op_tp} != 'SINGLE')" ).append("\n"); 
		query.append("			AND	(A.BKG_NO, A.TRSP_BND_CD)" ).append("\n"); 
		query.append("				IN (" ).append("\n"); 
		query.append("			  #foreach ($user_condtions IN ${condtions})" ).append("\n"); 
		query.append("				#if($velocityCount < $condtions.size())" ).append("\n"); 
		query.append("				  $user_condtions," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				  $user_condtions" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		AND B.INTER_RMK = 'LS'" ).append("\n"); 
		query.append("    UNION" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        A.BKG_NO" ).append("\n"); 
		query.append("        ,A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ AS SO_NO, '' AS WO_NO" ).append("\n"); 
		query.append("        ,A.COP_NO, A.EQ_NO, A.EQ_TPSZ_CD, DECODE(A.CRE_OFC_CD, 'SYSTEM', 'PHXSA', A.CRE_OFC_CD) AS WO_CRE_OFC_CD" ).append("\n"); 
		query.append("        ,A.TRSP_BND_CD, DECODE(A.TRSP_COST_DTL_MOD_CD, 'CY', 'CY', 'DR', 'DOOR', 'CY') AS TRSP_COST_DTL_MOD_CD, 'RD' AS TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("        ,A.FM_NOD_CD, '' AS VIA_NOD_CD, A.TO_NOD_CD AS TO_NOD_CD, '' AS DOR_NOD_CD" ).append("\n"); 
		query.append("        ,'' AS TRS_SO_RMK" ).append("\n"); 
		query.append("    FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("        AND A.TRSP_COST_DTL_MOD_CD IN ('CY', 'DR')" ).append("\n"); 
		query.append("#if (${sel_op_tp} == 'SINGLE')" ).append("\n"); 
		query.append("        AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND A.TRSP_BND_CD = @[bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_op_tp} != 'SINGLE')" ).append("\n"); 
		query.append("			AND	(A.BKG_NO, A.TRSP_BND_CD)" ).append("\n"); 
		query.append("				IN (" ).append("\n"); 
		query.append("			  #foreach ($user_condtions IN ${condtions})" ).append("\n"); 
		query.append("				#if($velocityCount < $condtions.size())" ).append("\n"); 
		query.append("				  $user_condtions," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				  $user_condtions" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}