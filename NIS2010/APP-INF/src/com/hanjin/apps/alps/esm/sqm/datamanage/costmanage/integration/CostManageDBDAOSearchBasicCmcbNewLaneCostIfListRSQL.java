/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CostManageDBDAOSearchBasicCmcbNewLaneCostIfListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOSearchBasicCmcbNewLaneCostIfListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * "New Lane & Office CMCB" 화면에서 등록했던 정보 조회
	  * </pre>
	  */
	public CostManageDBDAOSearchBasicCmcbNewLaneCostIfListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOSearchBasicCmcbNewLaneCostIfListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("         A.TRD_CD" ).append("\n"); 
		query.append("        ,A.RLANE_CD" ).append("\n"); 
		query.append("		,A.DIR_CD" ).append("\n"); 
		query.append("        ,NVL(C.ADD_FLG, 'N') AS ADD_FLG" ).append("\n"); 
		query.append("    FROM SQM_QTA_NEW_LANE          A" ).append("\n"); 
		query.append("        ,SQM_QTA_NEW_LANE_OFC_COST B" ).append("\n"); 
		query.append("        ,SQM_QTA_LANE_OFC_COST     C" ).append("\n"); 
		query.append("   WHERE A.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND A.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND A.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("     AND A.BSE_TP_CD  = B.BSE_TP_CD" ).append("\n"); 
		query.append("     AND A.BSE_YR     = B.BSE_YR" ).append("\n"); 
		query.append("     AND A.BSE_QTR_CD = B.BSE_QTR_CD" ).append("\n"); 
		query.append("     AND A.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("     AND A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("     AND A.DIR_CD     = B.DIR_CD" ).append("\n"); 
		query.append("     AND A.BSE_TP_CD  = C.BSE_TP_CD  (+)" ).append("\n"); 
		query.append("     AND A.BSE_YR     = C.BSE_YR     (+)" ).append("\n"); 
		query.append("     AND A.BSE_QTR_CD = C.BSE_QTR_CD (+)" ).append("\n"); 
		query.append("     AND A.TRD_CD     = C.TRD_CD     (+)" ).append("\n"); 
		query.append("     AND A.RLANE_CD   = C.RLANE_CD   (+)" ).append("\n"); 
		query.append("     AND A.DIR_CD     = C.DIR_CD     (+)" ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 

	}
}