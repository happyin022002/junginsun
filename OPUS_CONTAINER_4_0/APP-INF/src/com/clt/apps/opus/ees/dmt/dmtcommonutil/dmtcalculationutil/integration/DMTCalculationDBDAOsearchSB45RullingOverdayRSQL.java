/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCalculationDBDAOsearchSB45RullingOverdayRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOsearchSB45RullingOverdayRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSB45RullingOverday
	  * </pre>
	  */
	public DMTCalculationDBDAOsearchSB45RullingOverdayRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOsearchSB45RullingOverdayRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC( DMT_OVR_DY_EXCLU XPKDMT_OVR_DY_EXCLU) */" ).append("\n"); 
		query.append("       XCLD_SAT_FLG" ).append("\n"); 
		query.append("      ,XCLD_SUN_FLG" ).append("\n"); 
		query.append("      ,XCLD_HOL_FLG" ).append("\n"); 
		query.append("      ,TO_CHAR(EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("  FROM DMT_OVR_DY_EXCLU" ).append("\n"); 
		query.append(" WHERE    ( CNT_CD    =    @[cnt_cd]        OR    CNT_CD        =    ' ' )" ).append("\n"); 
		query.append(" AND      ( LOC_CD    =    @[loc_cd]        OR    LOC_CD        =    ' ' )" ).append("\n"); 
		query.append(" AND      ( YD_CD     =    @[yd_cd]         OR    YD_CD         =    ' ' )" ).append("\n"); 
		query.append(" AND      IO_BND_CD   =    DECODE(IO_BND_CD, 'A', 'A', @[io_bnd])" ).append("\n"); 
		query.append(" AND      DEM_DET_TP_CD =   DECODE(DEM_DET_TP_CD, 'A', 'A', @[trf_tp])" ).append("\n"); 
		query.append(" AND      (" ).append("\n"); 
		query.append("      ( EFF_DT <= TO_DATE (@[eff_dt], 'YYYYMMDD') AND EXP_DT IS NULL )" ).append("\n"); 
		query.append("      OR" ).append("\n"); 
		query.append("      ( EFF_DT <= TO_DATE (@[eff_dt], 'YYYYMMDD') AND EXP_DT > TO_DATE (@[eff_dt], 'YYYYMMDD') )" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append(" AND        ROWNUM    =    1" ).append("\n"); 

	}
}