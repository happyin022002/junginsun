/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ForecastSummaryDBDAOmanageEQForecastSummaryFilterUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.intergration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ForecastSummaryDBDAOmanageEQForecastSummaryFilterUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ Forecast Summary Filter INSERT/UPDATE
	  * </pre>
	  */
	public ForecastSummaryDBDAOmanageEQForecastSummaryFilterUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("norm_shtg_ftr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sros_spls_ftr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stk_icrz_ftr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("norm_spls_ftr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sros_shtg_ftr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_ftr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_ftr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stk_dcrz_ftr_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.intergration").append("\n"); 
		query.append("FileName : ForecastSummaryDBDAOmanageEQForecastSummaryFilterUSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_CTRL_FCAST_SMRY_FTR A" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("   ON (A.RCC_CD = @[rcc_cd] AND A.LOC_GRP_CD = @[loc_grp_cd] AND A.LOC_CD = @[loc_cd])" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE SET A.STK_ICRZ_FTR_FLG = @[stk_icrz_ftr_flg]" ).append("\n"); 
		query.append("               , A.STK_DCRZ_FTR_FLG = @[stk_dcrz_ftr_flg]" ).append("\n"); 
		query.append("               , A.SROS_SPLS_FTR_FLG = @[sros_spls_ftr_flg]" ).append("\n"); 
		query.append("               , A.NORM_SPLS_FTR_FLG = @[norm_spls_ftr_flg]" ).append("\n"); 
		query.append("               , A.BAL_FTR_FLG       = @[bal_ftr_flg]" ).append("\n"); 
		query.append("               , A.SROS_SHTG_FTR_FLG = @[sros_shtg_ftr_flg]" ).append("\n"); 
		query.append("               , A.NORM_SHTG_FTR_FLG = @[norm_shtg_ftr_flg]" ).append("\n"); 
		query.append("               , A.DELT_FTR_FLG = DECODE(@[delt_ftr_flg], 'Y', 'Y', 'N')" ).append("\n"); 
		query.append("               , A.UPD_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("               , A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("      INSERT(" ).append("\n"); 
		query.append("          RCC_CD" ).append("\n"); 
		query.append("        , LOC_GRP_CD" ).append("\n"); 
		query.append("        , LOC_CD" ).append("\n"); 
		query.append("        , HUL_BND_CD" ).append("\n"); 
		query.append("        , STK_ICRZ_FTR_FLG" ).append("\n"); 
		query.append("        , STK_DCRZ_FTR_FLG" ).append("\n"); 
		query.append("        , SROS_SPLS_FTR_FLG" ).append("\n"); 
		query.append("        , NORM_SPLS_FTR_FLG" ).append("\n"); 
		query.append("        , BAL_FTR_FLG" ).append("\n"); 
		query.append("        , SROS_SHTG_FTR_FLG" ).append("\n"); 
		query.append("        , NORM_SHTG_FTR_FLG" ).append("\n"); 
		query.append("        , DELT_FTR_FLG" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      VALUES" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("          @[rcc_cd]" ).append("\n"); 
		query.append("        , @[loc_grp_cd]" ).append("\n"); 
		query.append("        , @[loc_cd]" ).append("\n"); 
		query.append("        , @[hul_bnd_cd]" ).append("\n"); 
		query.append("        , @[stk_icrz_ftr_flg]" ).append("\n"); 
		query.append("        , @[stk_dcrz_ftr_flg]" ).append("\n"); 
		query.append("        , @[sros_spls_ftr_flg]" ).append("\n"); 
		query.append("        , @[norm_spls_ftr_flg]" ).append("\n"); 
		query.append("        , @[bal_ftr_flg]" ).append("\n"); 
		query.append("        , @[sros_shtg_ftr_flg]" ).append("\n"); 
		query.append("        , @[norm_shtg_ftr_flg]" ).append("\n"); 
		query.append("        , 'N'" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}