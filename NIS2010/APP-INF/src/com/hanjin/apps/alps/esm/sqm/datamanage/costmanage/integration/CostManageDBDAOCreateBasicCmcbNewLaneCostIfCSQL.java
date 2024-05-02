/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CostManageDBDAOCreateBasicCmcbNewLaneCostIfCSQL.java
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

public class CostManageDBDAOCreateBasicCmcbNewLaneCostIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선택한 노선에 대해서 "New Lane & Office CMCB" 화면에서 등록했던 정보를 I/F.
	  * </pre>
	  */
	public CostManageDBDAOCreateBasicCmcbNewLaneCostIfCSQL(){
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
		query.append("FileName : CostManageDBDAOCreateBasicCmcbNewLaneCostIfCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_QTA_LANE_OFC_COST (" ).append("\n"); 
		query.append("       BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,OFC_VW_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,RGN_OFC_CD" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,ADD_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A.BSE_YR" ).append("\n"); 
		query.append("      ,A.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,B.OFC_VW_CD" ).append("\n"); 
		query.append("      ,B.TRD_CD" ).append("\n"); 
		query.append("      ,B.RLANE_CD" ).append("\n"); 
		query.append("      ,B.DIR_CD" ).append("\n"); 
		query.append("      ,B.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,B.RHQ_CD" ).append("\n"); 
		query.append("      ,B.GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,B.GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,B.PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,B.RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,'Y' AS ADD_FLG" ).append("\n"); 
		query.append("      ,@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE       AS CRE_DT" ).append("\n"); 
		query.append("      ,@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE       AS UPD_DT" ).append("\n"); 
		query.append("  FROM SQM_QTA_NEW_LANE          A" ).append("\n"); 
		query.append("      ,SQM_QTA_NEW_LANE_OFC_COST B" ).append("\n"); 
		query.append(" WHERE A.BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND A.BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("   AND A.BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("   AND A.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("   AND A.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("   AND A.BSE_TP_CD  = B.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A.BSE_YR     = B.BSE_YR" ).append("\n"); 
		query.append("   AND A.BSE_QTR_CD = B.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("   AND A.DIR_CD     = B.DIR_CD" ).append("\n"); 

	}
}