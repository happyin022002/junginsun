/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OPCostDBDAOStndUtCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPCostDBDAOStndUtCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StndUtCost
	  * 2015.03.26 컬럼 속성명 변경으로 수정()
	  * </pre>
	  */
	public OPCostDBDAOStndUtCostRSQL(){
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
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cobcost",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_qtr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.integration").append("\n"); 
		query.append("FileName : OPCostDBDAOStndUtCostRSQL").append("\n"); 
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
		query.append("  COST_YR||'-'||BSE_QTR_CD AS COST_YR_QTR" ).append("\n"); 
		query.append(", COST_YR" ).append("\n"); 
		query.append(", BSE_QTR_CD AS COST_QTR_CD" ).append("\n"); 
		query.append(", TRD_CD" ).append("\n"); 
		query.append(", SUB_TRD_CD" ).append("\n"); 
		query.append(", RLANE_CD" ).append("\n"); 
		query.append(", DIR_CD" ).append("\n"); 
		query.append(", HUL_BND_CD" ).append("\n"); 
		query.append(", TO_CHAR(TO_DATE(EFF_FM_YRMON,'YYYYMM'),'YYYY-MM')||'~'||TO_CHAR(TO_DATE(EFF_TO_YRMON,'YYYYMM'),'YYYY-MM') AS EFF_YRMON" ).append("\n"); 
		query.append(", TTL_AMT       --TTL Cost" ).append("\n"); 
		query.append(", FNL_TTL_AMT   --Final Cost" ).append("\n"); 
		query.append(", DAY_COST_AMT  --Cost/Day" ).append("\n"); 
		query.append(", TGT_LOD_QTY   --Target Load or L/F" ).append("\n"); 
		query.append(", TEU_UC_AMT    --COST / TEU" ).append("\n"); 
		query.append(", STND_COST_CD" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append("  FROM MAS_STND_UT_COST" ).append("\n"); 
		query.append(" WHERE STND_COST_CD = @[f_cobcost]" ).append("\n"); 
		query.append("   AND COST_YR = @[f_year]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD = @[f_qtr]||'Q' " ).append("\n"); 
		query.append("#if(${f_trd_cd} != '')" ).append("\n"); 
		query.append("   AND TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rlane_cd} != '')" ).append("\n"); 
		query.append("   AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_dir_cd} != '')" ).append("\n"); 
		query.append("   AND DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_hul_bnd_cd} != '')" ).append("\n"); 
		query.append("   AND HUL_BND_CD = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_avg_grp_cd} == '')" ).append("\n"); 
		query.append("   AND HUL_BND_CD != 'XX'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND HUL_BND_CD = 'XX'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY COST_YR," ).append("\n"); 
		query.append("       BSE_QTR_CD," ).append("\n"); 
		query.append("       TRD_CD," ).append("\n"); 
		query.append("       SUB_TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD," ).append("\n"); 
		query.append("       DIR_CD" ).append("\n"); 

	}
}