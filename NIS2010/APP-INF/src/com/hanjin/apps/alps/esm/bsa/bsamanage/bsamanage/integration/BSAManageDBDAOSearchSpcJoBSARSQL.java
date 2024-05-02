/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BSAManageDBDAOSearchSpcJoBSARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOSearchSpcJoBSARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSpcJoBSA SELECT
	  * </pre>
	  */
	public BSAManageDBDAOSearchSpcJoBSARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdoopjbcd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchSpcJoBSARSQL").append("\n"); 
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
		query.append("     A.BSA_SEQ" ).append("\n"); 
		query.append("    ,A.BSA_FM_DT" ).append("\n"); 
		query.append("    ,A.BSA_TO_DT" ).append("\n"); 
		query.append("    ,A.TRD_CD" ).append("\n"); 
		query.append("    ,A.RLANE_CD" ).append("\n"); 
		query.append("    ,A.DIR_CD" ).append("\n"); 
		query.append("    ,A.VOP_CD" ).append("\n"); 
		query.append("    ,A.VVD_CD" ).append("\n"); 
		query.append("    ,A.VSL_CAPA" ).append("\n"); 
		query.append("    ,A.VSL_CAPA" ).append("\n"); 
		query.append("    ,A.BSA_CAPA" ).append("\n"); 
		query.append("    ,A.OWNR_VSL_WGT" ).append("\n"); 
		query.append("    ,NVL(SUM(DECODE(B.CRR_CD, 'SML', B.SPC_CTRL_SLT_CAPA)), 0) FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("    #foreach(${keys} IN ${keysList})" ).append("\n"); 
		query.append("         ,NVL(SUM(DECODE(B.CRR_CD, '$keys', B.SPC_CTRL_SLT_CAPA)), 0) $keys" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    ,DECODE(A.SPC_OTR_SWAP_FLG, 'Y', 'Yes', '')" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    BSA_JNT_OP_BZC A, " ).append("\n"); 
		query.append("    BSA_JNT_OP_CRR_CAPA B" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("      A.BSA_SEQ   = B.BSA_SEQ" ).append("\n"); 
		query.append("  AND A.RLANE_CD  = B.RLANE_CD" ).append("\n"); 
		query.append("  AND A.DIR_CD    = B.DIR_CD" ).append("\n"); 
		query.append("  AND A.TRD_CD    = B.TRD_CD" ).append("\n"); 
		query.append("  AND A.VOP_CD    = B.VOP_CD" ).append("\n"); 
		query.append("  AND A.VSL_CAPA  = B.VSL_CAPA" ).append("\n"); 
		query.append("  AND B.BSA_OP_CD = 'J'" ).append("\n"); 
		query.append("  #if (${cobtrade} != '')" ).append("\n"); 
		query.append("    AND A.TRD_CD = @[cobtrade]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${coblane} != '')" ).append("\n"); 
		query.append("    AND A.RLANE_CD = @[coblane]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${cobdir} != '')" ).append("\n"); 
		query.append("    AND A.DIR_CD = @[cobdir]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${txtsdate} != '')" ).append("\n"); 
		query.append("    AND A.BSA_TO_DT >= @[txtsdate]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  AND B.BSA_OP_JB_CD = @[rdoopjbcd]" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("      A.BSA_SEQ, " ).append("\n"); 
		query.append("      A.BSA_FM_DT, " ).append("\n"); 
		query.append("      A.BSA_TO_DT, " ).append("\n"); 
		query.append("      A.TRD_CD, " ).append("\n"); 
		query.append("      A.RLANE_CD, " ).append("\n"); 
		query.append("      A.DIR_CD, " ).append("\n"); 
		query.append("      A.VOP_CD, " ).append("\n"); 
		query.append("      A.VVD_CD, " ).append("\n"); 
		query.append("      A.VSL_CAPA," ).append("\n"); 
		query.append("      A.BSA_CAPA, " ).append("\n"); 
		query.append("      A.OWNR_VSL_WGT, " ).append("\n"); 
		query.append("      A.FNL_HJS_BSA_CAPA," ).append("\n"); 
		query.append("      A.SPC_OTR_SWAP_FLG" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("      A.TRD_CD, " ).append("\n"); 
		query.append("      A.RLANE_CD, " ).append("\n"); 
		query.append("      A.DIR_CD, " ).append("\n"); 
		query.append("      A.VOP_CD, " ).append("\n"); 
		query.append("      A.VSL_CAPA, " ).append("\n"); 
		query.append("      A.BSA_SEQ" ).append("\n"); 

	}
}