/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOSearchBSATableSCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.27
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.27 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAYearlyPlanDBDAOSearchBSATableSCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * History :
	  * * 2011.01.17 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOSearchBSATableSCRSQL(){
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
		query.append("FileName : BSAYearlyPlanDBDAOSearchBSATableSCRSQL").append("\n"); 
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
		query.append("SELECT /*+ USE_HASH(A B) */" ).append("\n"); 
		query.append("    A.BSA_GROUP" ).append("\n"); 
		query.append("  , A.BSA_SEQ" ).append("\n"); 
		query.append("  , A.VVD_CD" ).append("\n"); 
		query.append("  , A.BSA_FM_DT" ).append("\n"); 
		query.append("  , A.BSA_TO_DT" ).append("\n"); 
		query.append("  , A.TRD_CD" ).append("\n"); 
		query.append("  , A.RLANE_CD" ).append("\n"); 
		query.append("  , A.DIR_CD" ).append("\n"); 
		query.append("  , A.VSL_BSA_CHK_FLG" ).append("\n"); 
		query.append("  , A.VSL_SEQ" ).append("\n"); 
		query.append("  , A.VSL_CD" ).append("\n"); 
		query.append("  , A.HJS_FNL_BSA_CAPA" ).append("\n"); 
		query.append("  , A.HJS_BSA_BFR_SUB_CAPA" ).append("\n"); 
		query.append("  , A.VSL_MLT_INP_FLG" ).append("\n"); 
		query.append("  , A.UPD_USR_ID" ).append("\n"); 
		query.append("  #set($count = 0)" ).append("\n"); 
		query.append("  #foreach(${keys} IN ${keyList})" ).append("\n"); 
		query.append("     ,SUM(CASE WHEN B.BSA_OP_JB_CD = '${keys.bsaOpJbCd}' AND B.CRR_CD = '${keys.crrCd}'" ).append("\n"); 
		query.append("               THEN B.CRR_BSA_CAPA ELSE 0 END) AS CRR_BSA_CAPA$count" ).append("\n"); 
		query.append("     #set($count = $count + 1)" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  , A.SCHT_DESC" ).append("\n"); 
		query.append(" FROM    " ).append("\n"); 
		query.append("      (SELECT " ).append("\n"); 
		query.append("            DENSE_RANK() OVER(ORDER BY TRD_CD,RLANE_CD,DIR_CD) AS BSA_GROUP," ).append("\n"); 
		query.append("            BSA_SEQ," ).append("\n"); 
		query.append("            TRD_CD," ).append("\n"); 
		query.append("            RLANE_CD," ).append("\n"); 
		query.append("            DIR_CD," ).append("\n"); 
		query.append("            VSL_SEQ," ).append("\n"); 
		query.append("            VVD_CD," ).append("\n"); 
		query.append("            BSA_FM_DT," ).append("\n"); 
		query.append("            BSA_TO_DT," ).append("\n"); 
		query.append("            VSL_CD," ).append("\n"); 
		query.append("            HJS_FNL_BSA_CAPA," ).append("\n"); 
		query.append("            HJS_BSA_BFR_SUB_CAPA," ).append("\n"); 
		query.append("            VSL_BSA_CHK_FLG," ).append("\n"); 
		query.append("            SCHT_DESC," ).append("\n"); 
		query.append("            VSL_MLT_INP_FLG," ).append("\n"); 
		query.append("            UPD_USR_ID" ).append("\n"); 
		query.append("          FROM   " ).append("\n"); 
		query.append("              BSA_BUD_SLT_CHTR_BZC" ).append("\n"); 
		query.append("         ) A" ).append("\n"); 
		query.append("        ,BSA_BUD_SLT_CHTR_CRR_CAPA B" ).append("\n"); 
		query.append(" WHERE   " ).append("\n"); 
		query.append("         A.BSA_SEQ   = B.BSA_SEQ" ).append("\n"); 
		query.append(" AND     A.TRD_CD    = B.TRD_CD" ).append("\n"); 
		query.append(" AND     A.RLANE_CD  = B.RLANE_CD" ).append("\n"); 
		query.append(" AND     A.DIR_CD    = B.DIR_CD" ).append("\n"); 
		query.append(" AND     A.VSL_SEQ   = B.VSL_SEQ" ).append("\n"); 
		query.append(" AND     A.BSA_TO_DT >= @[txtsdate]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if (${cobtrade} != '')" ).append("\n"); 
		query.append(" 	  AND A.TRD_CD = @[cobtrade]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${coblane} != '')" ).append("\n"); 
		query.append("    AND A.RLANE_CD = @[coblane]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${cobdir} != '')" ).append("\n"); 
		query.append("    AND A.DIR_CD = @[cobdir]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" AND     B.BSA_OP_CD = @[rdoopcd]" ).append("\n"); 
		query.append(" GROUP BY " ).append("\n"); 
		query.append("        A.BSA_GROUP, " ).append("\n"); 
		query.append("        A.BSA_SEQ, " ).append("\n"); 
		query.append("        A.TRD_CD, " ).append("\n"); 
		query.append("        A.RLANE_CD, " ).append("\n"); 
		query.append("        A.DIR_CD," ).append("\n"); 
		query.append("        A.VSL_SEQ, " ).append("\n"); 
		query.append("        A.VSL_CD, " ).append("\n"); 
		query.append("        A.VVD_CD, " ).append("\n"); 
		query.append("        A.BSA_FM_DT, " ).append("\n"); 
		query.append("        A.BSA_TO_DT," ).append("\n"); 
		query.append("        A.HJS_FNL_BSA_CAPA, " ).append("\n"); 
		query.append("        A.HJS_BSA_BFR_SUB_CAPA, " ).append("\n"); 
		query.append("        A.VSL_BSA_CHK_FLG," ).append("\n"); 
		query.append("        A.SCHT_DESC, " ).append("\n"); 
		query.append("        A.VSL_MLT_INP_FLG," ).append("\n"); 
		query.append("        A.UPD_USR_ID" ).append("\n"); 
		query.append(" ORDER BY  " ).append("\n"); 
		query.append("        A.BSA_GROUP, " ).append("\n"); 
		query.append("        A.BSA_SEQ" ).append("\n"); 

	}
}