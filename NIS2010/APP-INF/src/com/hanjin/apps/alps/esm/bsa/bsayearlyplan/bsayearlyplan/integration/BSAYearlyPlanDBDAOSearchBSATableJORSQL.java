/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOSearchBSATableJORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAYearlyPlanDBDAOSearchBSATableJORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * History :
	  * 2011.01.17 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOSearchBSATableJORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdoopcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coblane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtsdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobdir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobtrade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration").append("\n"); 
		query.append("FileName : BSAYearlyPlanDBDAOSearchBSATableJORSQL").append("\n"); 
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
		query.append("SELECT /*+ FULL(B) */" ).append("\n"); 
		query.append("        A.BSA_GROUP" ).append("\n"); 
		query.append("      , A.BSA_SEQ" ).append("\n"); 
		query.append("      , A.TRD_CD" ).append("\n"); 
		query.append("      , C.SUB_TRD_CD" ).append("\n"); 
		query.append("      , A.RLANE_CD" ).append("\n"); 
		query.append("      , A.DIR_CD" ).append("\n"); 
		query.append("      , A.VOP_CD" ).append("\n"); 
		query.append("      , A.VSL_CAPA" ).append("\n"); 
		query.append("      , A.VVD_CD" ).append("\n"); 
		query.append("      , A.BSA_FM_DT" ).append("\n"); 
		query.append("      , A.BSA_TO_DT" ).append("\n"); 
		query.append("      , A.BSA_CAPA" ).append("\n"); 
		query.append("      , A.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      , A.HJS_BSA_BFR_SUB_CAPA" ).append("\n"); 
		query.append("      , A.JO_DESC" ).append("\n"); 
		query.append("      , A.OWNR_VSL_WGT" ).append("\n"); 
		query.append("      , A.UPD_USR_ID" ).append("\n"); 
		query.append("#set($count = 0)" ).append("\n"); 
		query.append("     	#foreach(${keys} IN ${keyList})" ).append("\n"); 
		query.append("      , SUM(CASE WHEN B.BSA_OP_JB_CD = '${keys.bsaOpJbCd}' AND B.CRR_CD = '${keys.crrCd}'" ).append("\n"); 
		query.append("           THEN B.CRR_BSA_CAPA ELSE 0 END) AS CRR_BSA_CAPA$count" ).append("\n"); 
		query.append("#set($count = $count + 1)" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (SELECT DENSE_RANK() OVER(ORDER BY TRD_CD,RLANE_CD,DIR_CD,VOP_CD,VSL_CAPA) AS BSA_GROUP" ).append("\n"); 
		query.append("              , BSA_SEQ" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , VOP_CD" ).append("\n"); 
		query.append("              , VSL_CAPA" ).append("\n"); 
		query.append("              , VVD_CD" ).append("\n"); 
		query.append("              , BSA_FM_DT" ).append("\n"); 
		query.append("              , BSA_TO_DT" ).append("\n"); 
		query.append("              , BSA_CAPA" ).append("\n"); 
		query.append("              , FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("              , HJS_BSA_BFR_SUB_CAPA" ).append("\n"); 
		query.append("              , JO_DESC" ).append("\n"); 
		query.append("              , OWNR_VSL_WGT" ).append("\n"); 
		query.append("              , UPD_USR_ID" ).append("\n"); 
		query.append("           FROM BSA_BUD_JNT_OP_BZC" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("      , BSA_BUD_JNT_OP_CRR_CAPA B" ).append("\n"); 
		query.append("      , (SELECT DISTINCT TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , IOC_CD" ).append("\n"); 
		query.append("              , A.SUB_TRD_CD" ).append("\n"); 
		query.append("              , A.SLAN_CD" ).append("\n"); 
		query.append("           FROM MAS_LANE_RGST A" ).append("\n"); 
		query.append("           FULL OUTER JOIN MAS_LANE_TP_HIS B USING (TRD_CD, RLANE_CD, DIR_CD, IOC_CD)" ).append("\n"); 
		query.append("          WHERE NVL(B.VSL_LANE_TP_CD, A.VSL_LANE_TP_CD) = 'JO'" ).append("\n"); 
		query.append("            AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append("  WHERE A.BSA_SEQ           = B.BSA_SEQ" ).append("\n"); 
		query.append("    AND A.TRD_CD            = B.TRD_CD" ).append("\n"); 
		query.append("    AND A.RLANE_CD          = B.RLANE_CD" ).append("\n"); 
		query.append("    AND A.DIR_CD            = B.DIR_CD" ).append("\n"); 
		query.append("    AND A.VOP_CD            = B.VOP_CD" ).append("\n"); 
		query.append("    AND A.VSL_CAPA          = B.VSL_CAPA" ).append("\n"); 
		query.append("    AND A.TRD_CD            = C.TRD_CD" ).append("\n"); 
		query.append("    AND A.RLANE_CD          = C.RLANE_CD" ).append("\n"); 
		query.append("    AND A.DIR_CD            = C.DIR_CD" ).append("\n"); 
		query.append("    AND A.BSA_TO_DT        >= @[txtsdate]" ).append("\n"); 
		query.append("#if (${cobtrade} != '')" ).append("\n"); 
		query.append("    AND A.TRD_CD            = @[cobtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${coblane} != '')" ).append("\n"); 
		query.append("    AND A.RLANE_CD          = @[coblane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cobdir} != '')" ).append("\n"); 
		query.append("    AND A.DIR_CD            = @[cobdir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND B.BSA_OP_CD         = @[rdoopcd]" ).append("\n"); 
		query.append("  GROUP BY A.BSA_GROUP" ).append("\n"); 
		query.append("      , A.BSA_SEQ" ).append("\n"); 
		query.append("      , A.TRD_CD" ).append("\n"); 
		query.append("      , C.SUB_TRD_CD" ).append("\n"); 
		query.append("      , A.RLANE_CD" ).append("\n"); 
		query.append("      , A.DIR_CD" ).append("\n"); 
		query.append("      , A.VOP_CD" ).append("\n"); 
		query.append("      , A.VSL_CAPA" ).append("\n"); 
		query.append("      , A.VVD_CD" ).append("\n"); 
		query.append("      , A.BSA_FM_DT" ).append("\n"); 
		query.append("      , A.BSA_TO_DT" ).append("\n"); 
		query.append("      , A.BSA_CAPA" ).append("\n"); 
		query.append("      , A.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      , A.HJS_BSA_BFR_SUB_CAPA" ).append("\n"); 
		query.append("      , A.JO_DESC" ).append("\n"); 
		query.append("      , A.OWNR_VSL_WGT" ).append("\n"); 
		query.append("      , A.UPD_USR_ID" ).append("\n"); 
		query.append("  ORDER BY A.BSA_GROUP" ).append("\n"); 
		query.append("      , A.BSA_SEQ" ).append("\n"); 

	}
}