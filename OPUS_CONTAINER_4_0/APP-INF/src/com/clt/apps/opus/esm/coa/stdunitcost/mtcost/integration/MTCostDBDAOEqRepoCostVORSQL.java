/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MTCostDBDAOEqRepoCostVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTCostDBDAOEqRepoCostVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * @SJH.20140922 : COA_MTY_REPO_UT_COST 조회
	  * </pre>
	  */
	public MTCostDBDAOEqRepoCostVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration").append("\n"); 
		query.append("FileName : MTCostDBDAOEqRepoCostVORSQL").append("\n"); 
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
		query.append("SELECT   COST_LOC_GRP_CD" ).append("\n"); 
		query.append("        ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SCC_CD" ).append("\n"); 
		query.append("        ,EFF_FM_YRMON" ).append("\n"); 
		query.append("        ,EFF_TO_YRMON" ).append("\n"); 
		query.append("        ,IB_MTY_AMT1" ).append("\n"); 
		query.append("        ,OB_MTY_AMT1" ).append("\n"); 
		query.append("        ,IB_MTY_AMT2" ).append("\n"); 
		query.append("        ,OB_MTY_AMT2" ).append("\n"); 
		query.append("        ,CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("        ,CNTR_IMBAL_RTO" ).append("\n"); 
		query.append("        ,CNTR_IB_QTY" ).append("\n"); 
		query.append("        ,CNTR_OB_QTY" ).append("\n"); 
		query.append("        ,MTY_COST_TP_NM" ).append("\n"); 
		query.append("        ,COST_SRC_FM_YRMON" ).append("\n"); 
		query.append("        ,COST_SRC_TO_YRMON  " ).append("\n"); 
		query.append("        ,BAT_FLG" ).append("\n"); 
		query.append("    FROM COA_MTY_REPO_UT_COST" ).append("\n"); 
		query.append("   WHERE 1 = 1 " ).append("\n"); 
		query.append("     AND COST_LOC_GRP_CD = NVL(@[f_cost_loc_grp_cd], COST_LOC_GRP_CD)" ).append("\n"); 
		query.append("     AND CNTR_TPSZ_CD = NVL(@[f_cntr_tpsz_cd], CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("     AND TRD_CD = NVL(@[f_trd_cd], TRD_CD)" ).append("\n"); 
		query.append("     AND SCC_CD = NVL(@[f_ecc_cd], SCC_CD)	" ).append("\n"); 
		query.append("     #if (${f_cost_yrmon} != '')" ).append("\n"); 
		query.append("     AND @[f_cost_yrmon] BETWEEN EFF_FM_YRMON AND NVL(EFF_TO_YRMON,'999912')" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("ORDER BY COST_LOC_GRP_CD" ).append("\n"); 
		query.append("		,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,TRD_CD" ).append("\n"); 
		query.append("		,SCC_CD" ).append("\n"); 
		query.append("		,EFF_FM_YRMON" ).append("\n"); 

	}
}