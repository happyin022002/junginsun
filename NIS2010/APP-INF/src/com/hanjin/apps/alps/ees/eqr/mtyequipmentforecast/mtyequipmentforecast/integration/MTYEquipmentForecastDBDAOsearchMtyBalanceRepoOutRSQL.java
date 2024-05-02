/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.24
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.05.24 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Mty Balance Report Out 조회
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutRSQL(){
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
		params.put("inp_yrwk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutRSQL").append("\n"); 
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
		query.append("SELECT LOC_GRP_CD  -- HIDDEN" ).append("\n"); 
		query.append("      ,LOC_CD      -- HIDDEN" ).append("\n"); 
		query.append("      ,INP_YRWK    -- HIDDEN" ).append("\n"); 
		query.append("      ,FCAST_YRWK  -- HIDDEN" ).append("\n"); 
		query.append("      ,CRE_SEQ     -- HIDDEN" ).append("\n"); 
		query.append("      ,TRSP_MOD_CD " ).append("\n"); 
		query.append("      ,VSL_LANE_CD" ).append("\n"); 
		query.append("      ,VSL_CD||LPAD(SKD_VOY_NO, 4, 0)||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      ,FM_YD_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(FM_ETD_DT, 'YYYY-MM-DD') FM_ETD_DT" ).append("\n"); 
		query.append("      ,TO_YD_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(TO_ETB_DT, 'YYYY-MM-DD') TO_ETB_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(NVL(D2_FCAST_QTY, 0)+NVL(D4_FCAST_QTY, 0)+NVL(D5_FCAST_QTY, 0)+NVL(D7_FCAST_QTY, 0)+NVL(R2_FCAST_QTY, 0)+NVL(R5_FCAST_QTY, 0)+NVL(R9_FCAST_QTY, 0)+NVL(O2_FCAST_QTY, 0)+NVL(S2_FCAST_QTY, 0)+NVL(O4_FCAST_QTY, 0)+NVL(S4_FCAST_QTY, 0)+NVL(F2_FCAST_QTY, 0)+NVL(A2_FCAST_QTY, 0)+NVL(F4_FCAST_QTY, 0)+NVL(A4_FCAST_QTY, 0)+NVL(F5_FCAST_QTY, 0),'9,999,999') TOTAL    " ).append("\n"); 
		query.append("      ,NVL(D2_FCAST_QTY, 0) D2_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(D4_FCAST_QTY, 0) D4_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(D5_FCAST_QTY, 0) D5_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(D7_FCAST_QTY, 0) D7_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(R2_FCAST_QTY, 0) R2_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(R5_FCAST_QTY, 0) R5_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(R9_FCAST_QTY, 0) R9_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(O2_FCAST_QTY, 0) O2_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(S2_FCAST_QTY, 0) S2_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(O4_FCAST_QTY, 0) O4_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(S4_FCAST_QTY, 0) S4_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(F2_FCAST_QTY, 0) F2_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(A2_FCAST_QTY, 0) A2_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(F4_FCAST_QTY, 0) F4_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(A4_FCAST_QTY, 0) A4_FCAST_QTY" ).append("\n"); 
		query.append("      ,NVL(F5_FCAST_QTY, 0) F5_FCAST_QTY" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append("FROM EQR_MTY_BAL_RPT_REPO_OUT" ).append("\n"); 
		query.append("WHERE LOC_GRP_CD = @[loc_grp_cd] -- L, E, S" ).append("\n"); 
		query.append("AND   LOC_CD     = @[loc_cd]     -- KRPUS, CNSHA" ).append("\n"); 
		query.append("AND   INP_YRWK   = @[inp_yrwk]   " ).append("\n"); 
		query.append("AND   FCAST_YRWK = @[fcast_yrwk]" ).append("\n"); 
		query.append("ORDER BY FM_ETD_DT" ).append("\n"); 

	}
}