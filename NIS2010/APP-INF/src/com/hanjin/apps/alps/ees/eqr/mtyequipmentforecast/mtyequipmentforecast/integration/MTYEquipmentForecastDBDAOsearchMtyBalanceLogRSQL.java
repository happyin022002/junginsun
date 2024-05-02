/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearchMtyBalanceLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MG OP FORECAST 로그 조회
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchMtyBalanceLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceLogRSQL").append("\n"); 
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
		query.append("SELECT (SELECT /*+ INDEX_ASC(X XPKEQR_WK_PRD) */X.PLN_YR||X.PLN_WK FROM EQR_WK_PRD X WHERE X.PLN_YR||X.PLN_WK > A.INP_YRWK AND ROWNUM = 1 ) INP_YRWK" ).append("\n"); 
		query.append("      ,NVL(A.D2_FCAST_QTY,0) AS D2_FCAST_QTY               " ).append("\n"); 
		query.append("      ,NVL(A.D4_FCAST_QTY,0) AS D4_FCAST_QTY                   " ).append("\n"); 
		query.append("      ,NVL(A.D5_FCAST_QTY,0) AS D5_FCAST_QTY             " ).append("\n"); 
		query.append("      ,NVL(A.D7_FCAST_QTY,0) AS D7_FCAST_QTY             " ).append("\n"); 
		query.append("      ,NVL(A.R2_FCAST_QTY,0) AS R2_FCAST_QTY             " ).append("\n"); 
		query.append("      ,NVL(A.R5_FCAST_QTY,0) AS R5_FCAST_QTY   " ).append("\n"); 
		query.append("      ,NVL(A.R9_FCAST_QTY,0) AS R9_FCAST_QTY               " ).append("\n"); 
		query.append("      ,NVL(A.O2_FCAST_QTY,0) AS O2_FCAST_QTY             " ).append("\n"); 
		query.append("      ,NVL(A.S2_FCAST_QTY,0) AS S2_FCAST_QTY             " ).append("\n"); 
		query.append("      ,NVL(A.O4_FCAST_QTY,0) AS O4_FCAST_QTY             " ).append("\n"); 
		query.append("      ,NVL(A.S4_FCAST_QTY,0) AS S4_FCAST_QTY             " ).append("\n"); 
		query.append("      ,NVL(A.F2_FCAST_QTY,0) AS F2_FCAST_QTY             " ).append("\n"); 
		query.append("      ,NVL(A.A2_FCAST_QTY,0) AS A2_FCAST_QTY             " ).append("\n"); 
		query.append("      ,NVL(A.F4_FCAST_QTY,0) AS F4_FCAST_QTY             " ).append("\n"); 
		query.append("      ,NVL(A.A4_FCAST_QTY,0) AS A4_FCAST_QTY             " ).append("\n"); 
		query.append("      ,NVL(A.F5_FCAST_QTY,0) AS F5_FCAST_QTY             " ).append("\n"); 
		query.append("      ,NVL(A.O5_FCAST_QTY,0) AS O5_FCAST_QTY   " ).append("\n"); 
		query.append("      ,B.USR_NM" ).append("\n"); 
		query.append("      ,B.OFC_CD " ).append("\n"); 
		query.append("      ,TO_CHAR(A.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') LOCL_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT          " ).append("\n"); 
		query.append("FROM EQR_MTY_BAL_RPT_HIS A" ).append("\n"); 
		query.append("    ,COM_USER B" ).append("\n"); 
		query.append("WHERE A.CRE_USR_ID    = B.USR_ID    " ).append("\n"); 
		query.append("AND   A.LOC_GRP_CD    = @[loc_grp_cd] -- L, E, S" ).append("\n"); 
		query.append("AND   A.LOC_CD        = @[loc_cd]     -- KRPUS, CNSHA" ).append("\n"); 
		query.append("--AND   A.INP_YRWK      = inp_yrwk   " ).append("\n"); 
		query.append("AND   A.FCAST_YRWK    = @[fcast_yrwk]" ).append("\n"); 
		query.append("AND   A.MTY_BAL_TP_CD = @[tp_cd]" ).append("\n"); 
		query.append("ORDER BY A.INP_YRWK" ).append("\n"); 
		query.append("        ,A.CRE_DT" ).append("\n"); 

	}
}