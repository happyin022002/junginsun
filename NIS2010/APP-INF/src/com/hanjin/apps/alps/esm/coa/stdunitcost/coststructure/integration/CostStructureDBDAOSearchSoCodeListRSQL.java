/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostStructureDBDAOSearchSoCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOSearchSoCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Register Cost Item
	  * 2012.05.08 전윤주 [CHM-201217633] Hinterland cost table 생성 시 필요한 flag 추가
	  * inlnd_expn_use_flg, inlnd_tml_expn_calc_flg, ocn_fdr_expn_use_flg 추가
	  * </pre>
	  */
	public CostStructureDBDAOSearchSoCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sgrp_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOSearchSoCodeListRSQL").append("\n"); 
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
		query.append("SELECT NVL(A.DELT_FLG,'N') DELT_FLG			" ).append("\n"); 
		query.append("    ,C.SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("    ,A.SGRP_COST_CD" ).append("\n"); 
		query.append("    ,B.STND_COST_NM" ).append("\n"); 
		query.append("    ,A.STND_COST_CD " ).append("\n"); 
		query.append("    ,A.COA_COST_SRC_PRT_CD" ).append("\n"); 
		query.append("    ,A.COST_SRC_SYS_CD" ).append("\n"); 
		query.append("    ,A.COST_SRC_MON " ).append("\n"); 
		query.append("    ,A.COA_COST_SRC_CD" ).append("\n"); 
		query.append("    ,A.COA_COST_SRC_CD_NM " ).append("\n"); 
		query.append("    ,A.COST_ASS_BSE_CD" ).append("\n"); 
		query.append("    ,A.COST_UT_AMT_CD " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #foreach($key IN ${allcols}) " ).append("\n"); 
		query.append("      ,(SELECT COST_APLY_FLG " ).append("\n"); 
		query.append("        FROM COA_ACT_GRP_COST_MAPG " ).append("\n"); 
		query.append("        WHERE COST_ACT_GRP_CD = '$key'" ).append("\n"); 
		query.append("          AND COA_COST_SRC_CD = A.COA_COST_SRC_CD" ).append("\n"); 
		query.append("      ) $key" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("				 " ).append("\n"); 
		query.append("    ,A.SPCL_CGO_DG_FLG" ).append("\n"); 
		query.append("    ,A.SPCL_CGO_RF_FLG" ).append("\n"); 
		query.append("    ,A.SPCL_CGO_AWK_FLG" ).append("\n"); 
		query.append("    ,A.SPCL_CGO_BB_FLG " ).append("\n"); 
		query.append("    ,A.COST_VOL_CD" ).append("\n"); 
		query.append("    ,A.COST_VOL_CD1" ).append("\n"); 
		query.append("    ,A.FULL_MTY_CD" ).append("\n"); 
		query.append("    ,A.BKG_FULL_SOC_CGO_FLG" ).append("\n"); 
		query.append("    ,A.BKG_REV_MCGO_FLG" ).append("\n"); 
		query.append("    ,A.BKG_MCGO_FLG" ).append("\n"); 
		query.append("    ,A.INLND_EXPN_USE_FLG" ).append("\n"); 
		query.append("    ,A.INLND_TML_EXPN_CALC_FLG" ).append("\n"); 
		query.append("    ,A.OCN_FDR_EXPN_USE_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("   COA_COST_SRC_ACCT A" ).append("\n"); 
		query.append("  ,COA_STND_ACCT B" ).append("\n"); 
		query.append("  ,COA_SUB_GRP_COST C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  #if(${f_sgrp_cost_cd}!='')   " ).append("\n"); 
		query.append("    AND C.SGRP_COST_CD =  @[f_sgrp_cost_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_stnd_cost_cd}!='')   " ).append("\n"); 
		query.append("    AND B.STND_COST_CD = @[f_stnd_cost_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("				 " ).append("\n"); 
		query.append("  AND A.STND_COST_CD = B.STND_COST_CD" ).append("\n"); 
		query.append("  AND A.SGRP_COST_CD = C.SGRP_COST_CD " ).append("\n"); 
		query.append("ORDER BY C.SGRP_COST_CD" ).append("\n"); 
		query.append("  ,A.STND_COST_CD" ).append("\n"); 
		query.append("  ,A.COA_COST_SRC_CD" ).append("\n"); 

	}
}