/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCalculationDBDAOGetTimeClockStopToDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.06
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.12.06 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOGetTimeClockStopToDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getTimeClockStopToDt
	  * </pre>
	  */
	public DMTCalculationDBDAOGetTimeClockStopToDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftime_cmnc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtt_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetTimeClockStopToDtRSQL").append("\n"); 
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
		query.append("SELECT CLK_STOP_NO TMP_CSTOP_NO " ).append("\n"); 
		query.append("              ,TO_CHAR (CLK_STOP_TO_DT, 'YYYYMMDDHH24MI') RTN_FTIME_CMNC" ).append("\n"); 
		query.append("  FROM DMT_TM_CLK_STOP" ).append("\n"); 
		query.append(" WHERE DMDT_TRF_CD     	= @[dtt_code]" ).append("\n"); 
		query.append("   AND CLK_STOP_OFC_CD 	= @[ofc_cd]" ).append("\n"); 
		query.append("   AND TO_DATE (@[ftime_cmnc], 'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("          BETWEEN TO_DATE (TO_CHAR (CLK_STOP_FM_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                          ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("              AND TO_DATE (TO_CHAR (CLK_STOP_TO_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                          ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("   AND CXL_FLG			= 'N'" ).append("\n"); 
		query.append("   AND ALL_YD_FLG		= 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.CLK_STOP_NO TMP_CSTOP_NO " ).append("\n"); 
		query.append("              ,TO_CHAR (A.CLK_STOP_TO_DT, 'YYYYMMDDHH24MI') RTN_FTIME_CMNC" ).append("\n"); 
		query.append("  FROM DMT_TM_CLK_STOP A, DMT_TM_CLK_STOP_YD B" ).append("\n"); 
		query.append(" WHERE A.DMDT_TRF_CD     = @[dtt_code]" ).append("\n"); 
		query.append("   AND A.CLK_STOP_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND TO_DATE (@[ftime_cmnc], 'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("          BETWEEN TO_DATE (TO_CHAR (A.CLK_STOP_FM_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                          ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("              AND TO_DATE (TO_CHAR (A.CLK_STOP_TO_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                          ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("   AND A.CXL_FLG		= 'N'" ).append("\n"); 
		query.append("   AND A.ALL_YD_FLG		<> 'Y'" ).append("\n"); 
		query.append("   AND A.CLK_STOP_NO 	= B.CLK_STOP_NO" ).append("\n"); 
		query.append("   AND B.YD_CD			= @[yd_cd]" ).append("\n"); 

	}
}