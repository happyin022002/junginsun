/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ForecastSummaryDBDAOsearchEQBalanceSheetListRSQL.java
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

public class ForecastSummaryDBDAOsearchEQBalanceSheetListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1. 화면명: EQ Balance Sheet Set-up
	  * 2. Display 화면에 대한 Setting 화면
	  * 3. OPEO에서만 사용
	  * </pre>
	  */
	public ForecastSummaryDBDAOsearchEQBalanceSheetListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.intergration").append("\n"); 
		query.append("FileName : ForecastSummaryDBDAOsearchEQBalanceSheetListRSQL").append("\n"); 
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
		query.append("SELECT A.RCC_CD" ).append("\n"); 
		query.append("     , A.LOC_GRP_CD" ).append("\n"); 
		query.append("     , A.LOC_CD" ).append("\n"); 
		query.append("     , A.HUL_BND_CD" ).append("\n"); 
		query.append("     , DECODE(A.STK_ICRZ_FTR_FLG, 'Y', 'Y', 'N') STK_ICRZ_FTR_FLG" ).append("\n"); 
		query.append("     , DECODE(A.STK_DCRZ_FTR_FLG, 'Y', 'Y', 'N') STK_DCRZ_FTR_FLG" ).append("\n"); 
		query.append("     , DECODE(A.SROS_SPLS_FTR_FLG, 'Y', 'Y', 'N') SROS_SPLS_FTR_FLG" ).append("\n"); 
		query.append("     , DECODE(A.NORM_SPLS_FTR_FLG, 'Y', 'Y', 'N') NORM_SPLS_FTR_FLG" ).append("\n"); 
		query.append("     , DECODE(A.SROS_SHTG_FTR_FLG, 'Y', 'Y', 'N') SROS_SHTG_FTR_FLG" ).append("\n"); 
		query.append("     , DECODE(A.NORM_SHTG_FTR_FLG, 'Y', 'Y', 'N') NORM_SHTG_FTR_FLG" ).append("\n"); 
		query.append("     , DECODE(A.BAL_FTR_FLG, 'Y', 'Y', 'N') BAL_FTR_FLG" ).append("\n"); 
		query.append("     , A.DELT_FTR_FLG" ).append("\n"); 
		query.append("     , A.UPD_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append("     , (SELECT USR_NM FROM COM_USER U WHERE U.USR_ID = A.UPD_USR_ID) CRE_USR_NM" ).append("\n"); 
		query.append("     , A.UPD_DT CRE_DT" ).append("\n"); 
		query.append("  FROM EQR_CTRL_FCAST_SMRY_FTR A" ).append("\n"); 
		query.append(" WHERE A.DELT_FTR_FLG <> 'Y'" ).append("\n"); 
		query.append("#if(${s_rcc_cd} !='')" ).append("\n"); 
		query.append("  AND A.RCC_CD = @[s_rcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_loc_cd} !='')" ).append("\n"); 
		query.append("   AND LOC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_loc_grp_cd} != '')" ).append("\n"); 
		query.append("   AND LOC_GRP_CD = @[s_loc_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_hul_bnd_cd} !='')" ).append("\n"); 
		query.append("  AND A.HUL_BND_CD = @[s_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY A.RCC_CD, A.LOC_GRP_CD, A.LOC_CD, A.HUL_BND_CD" ).append("\n"); 

	}
}