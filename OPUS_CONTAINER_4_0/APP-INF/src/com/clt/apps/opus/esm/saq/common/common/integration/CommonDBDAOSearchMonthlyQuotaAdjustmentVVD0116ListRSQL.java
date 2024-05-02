/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommonDBDAOSearchMonthlyQuotaAdjustmentVVD0116ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.30 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchMonthlyQuotaAdjustmentVVD0116ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Monthly Quota VVD
	  * </pre>
	  */
	public CommonDBDAOSearchMonthlyQuotaAdjustmentVVD0116ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bsa_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchMonthlyQuotaAdjustmentVVD0116ListRSQL").append("\n"); 
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
		query.append("SELECT BSE_MON, BSE_WK,						" ).append("\n"); 
		query.append("		       VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("		       FNL_BSA_CAPA AS BSA                   " ).append("\n"); 
		query.append("     #if (${tbl_gbn} == 'CONFIRMED') " ).append("\n"); 
		query.append("           FROM   SAQ_MON_CFM_TGT_VVD        " ).append("\n"); 
		query.append("     #else " ).append("\n"); 
		query.append("           FROM   SAQ_MON_TGT_VVD_ADJ    " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("		WHERE  BSE_YR = @[bse_yr]                            " ).append("\n"); 
		query.append("		AND    BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("	 #if (${gline_ver_no} != '') " ).append("\n"); 
		query.append("        AND    GLINE_VER_NO = @[gline_ver_no]      " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("		AND    TRD_CD = @[trd_cd]                            " ).append("\n"); 
		query.append("		AND    DIR_CD = @[dir_cd]                            " ).append("\n"); 
		query.append("		AND    RLANE_CD = @[rlane_cd]                          " ).append("\n"); 
		query.append("		AND    SPRT_GRP_CD = @[sprt_grp_cd]                       " ).append("\n"); 
		query.append("		AND    BSA_GRP_CD = @[bsa_grp_cd]    " ).append("\n"); 
		query.append("     #if (${bse_mon} != '') " ).append("\n"); 
		query.append("        AND    BSE_MON = @[bse_mon]       " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("		ORDER BY BSE_MON, BSE_WK, VVD" ).append("\n"); 

	}
}