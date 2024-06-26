/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MTCostDBDAOSearchMTCost13ListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTCostDBDAOSearchMTCost13ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_MTY_ECC_UT_COST, COA_MTY_CNTR_ROUT_PERF, COA_LOCATION_V  
	  * 테이블의 데이터 조회    - 품질향상
	  * </pre>
	  */
	public MTCostDBDAOSearchMTCost13ListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.integration").append("\n"); 
		query.append("FileName : MTCostDBDAOSearchMTCost13ListVORSQL").append("\n"); 
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
		query.append("SELECT A1.COST_YRMON " ).append("\n"); 
		query.append("      ,A1.ECC_CD RCC_CD " ).append("\n"); 
		query.append("      ,NVL(A1.CNTR_IO_VOL_STS_CD, 'X') CNTR_IO_VOL_STS_CD " ).append("\n"); 
		query.append("      ,COA_GET_CD_NM_FNC ('CD00849', NVL(A1.CNTR_IO_VOL_STS_CD, 'X')) EQ_STATUS  " ).append("\n"); 
		query.append("      ,A1.IMBAL_RTO * 100 IMBAL_RTO  " ).append("\n"); 
		query.append("      ,DECODE(A1.CNTR_ORG_DEST_CD, 'O', 'Origin(from)', 'Dest(to)') ORI_DEST " ).append("\n"); 
		query.append("      ,A1.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("      ,A1.MCNTR_QTY VOL " ).append("\n"); 
		query.append("      ,A1.MTY_STVG_UC_AMT  " ).append("\n"); 
		query.append("      ,SUM(ROUND(A2.MTY_STVG_TTL_AMT, 2)) CALCU_STEVE " ).append("\n"); 
		query.append("      ,A1.MTY_TRSP_UC_AMT " ).append("\n"); 
		query.append("      ,SUM(ROUND(A2.MTY_TRSP_TTL_AMT, 2)) CALCU_TRANS  " ).append("\n"); 
		query.append("      ,(A1.MTY_STVG_UC_AMT + A1.MTY_TRSP_UC_AMT) CALCU_TTL" ).append("\n"); 
		query.append("      ,ROUND(A1.MTY_TZ_DYS, 2) MTY_TZ_HRS " ).append("\n"); 
		query.append("      ,SUM(A2.TTL_TZ_DYS) CALCU_DAYS " ).append("\n"); 
		query.append("      ,MAX(A1.MNL_RQST_FLG) AS MNL_RQST_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'' AS P_CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("	,'' AS P_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,'' AS P_COST_YRMON" ).append("\n"); 
		query.append("	,'' AS P_FCNTR_ECC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM COA_MTY_ECC_UT_COST A1 " ).append("\n"); 
		query.append("      ,COA_MTY_CNTR_ROUT_PERF A2 " ).append("\n"); 
		query.append("      ,(SELECT DISTINCT ECC_CD,LCC_CD,RCC_CD FROM COA_LOCATION_V) F_L " ).append("\n"); 
		query.append("      ,(SELECT DISTINCT ECC_CD,LCC_CD,RCC_CD FROM COA_LOCATION_V) T_L " ).append("\n"); 
		query.append(" WHERE 1 = 1 " ).append("\n"); 
		query.append("   AND A1.COST_LOC_GRP_CD = 'R' " ).append("\n"); 
		query.append("   AND A1.COST_YRMON = @[f_cost_yrmon] " ).append("\n"); 
		query.append("   AND A1.COST_YRMON = A2.COST_YRMON " ).append("\n"); 
		query.append("   AND A1.ECC_CD = DECODE(A1.CNTR_ORG_DEST_CD, 'O',  F_L.RCC_CD, T_L.RCC_CD) " ).append("\n"); 
		query.append("   AND A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("   AND A2.ROUT_N1ST_ECC_CD = F_L.ECC_CD " ).append("\n"); 
		query.append("   AND A2.ROUT_LST_ECC_CD = T_L.ECC_CD 				" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${f_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("   AND A1.CNTR_TPSZ_CD= @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("   #if (${f_rcc_cd} != '') " ).append("\n"); 
		query.append("   AND A1.ECC_CD = @[f_rcc_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A1.COST_YRMON " ).append("\n"); 
		query.append("        ,A1.ECC_CD " ).append("\n"); 
		query.append("        ,A1.CNTR_IO_VOL_STS_CD " ).append("\n"); 
		query.append("        ,A1.IMBAL_RTO  " ).append("\n"); 
		query.append("        ,A1.CNTR_ORG_DEST_CD " ).append("\n"); 
		query.append("        ,A1.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("        ,A1.MCNTR_QTY " ).append("\n"); 
		query.append("        ,A1.MTY_STVG_UC_AMT " ).append("\n"); 
		query.append("        ,A1.MTY_TRSP_UC_AMT " ).append("\n"); 
		query.append("        ,ROUND(A1.MTY_TZ_DYS, 2) " ).append("\n"); 
		query.append("        ,A1.FULL_TZ_HRS  				" ).append("\n"); 
		query.append("ORDER BY A1.ECC_CD " ).append("\n"); 
		query.append("        ,A1.CNTR_IO_VOL_STS_CD DESC " ).append("\n"); 
		query.append("        ,A1.IMBAL_RTO " ).append("\n"); 
		query.append("        ,A1.CNTR_ORG_DEST_CD DESC " ).append("\n"); 
		query.append("        ,A1.CNTR_TPSZ_CD" ).append("\n"); 

	}
}