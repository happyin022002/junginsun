/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CostManageDBDAOCreateBasicCmcbNewLaneAvgCostCSQL.java
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

public class CostManageDBDAOCreateBasicCmcbNewLaneAvgCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신규노선에 대한 Trad-Rlane-Bound에 대한 평균 값을 생성한다.
	  * </pre>
	  */
	public CostManageDBDAOCreateBasicCmcbNewLaneAvgCostCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOCreateBasicCmcbNewLaneAvgCostCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_QTA_LANE_OFC_COST (BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, TRD_CD, RLANE_CD, DIR_CD, RGN_OFC_CD, RHQ_CD, GID_PA_CM_UC_AMT, GID_RA_CM_UC_AMT, PA_CM_UC_AMT, RA_CM_UC_AMT, ADD_FLG, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("SELECT BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,OFC_VW_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,'XXXXXX' AS RGN_OFC_CD" ).append("\n"); 
		query.append("      ,'XXXXXX' AS RHQ_CD" ).append("\n"); 
		query.append("      ,ROUND(AVG(GID_PA_CM_UC_AMT)) AS GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,ROUND(AVG(GID_RA_CM_UC_AMT)) AS GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,ROUND(AVG(PA_CM_UC_AMT))     AS PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,ROUND(AVG(RA_CM_UC_AMT))     AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,'Y' AS ADD_FLG " ).append("\n"); 
		query.append("      ,@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE       AS CRE_DT" ).append("\n"); 
		query.append("      ,@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE       AS UPD_DT" ).append("\n"); 
		query.append("  FROM SQM_QTA_LANE_OFC_COST" ).append("\n"); 
		query.append(" WHERE BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("   AND OFC_VW_CD  = 'C'" ).append("\n"); 
		query.append("   AND TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("   AND PA_CM_UC_AMT <> 0" ).append("\n"); 
		query.append("   AND RA_CM_UC_AMT <> 0" ).append("\n"); 
		query.append(" GROUP BY BSE_TP_CD" ).append("\n"); 
		query.append("         ,BSE_YR" ).append("\n"); 
		query.append("         ,BSE_QTR_CD" ).append("\n"); 
		query.append("         ,OFC_VW_CD" ).append("\n"); 
		query.append("         ,TRD_CD" ).append("\n"); 
		query.append("         ,RLANE_CD" ).append("\n"); 
		query.append("         ,DIR_CD" ).append("\n"); 

	}
}