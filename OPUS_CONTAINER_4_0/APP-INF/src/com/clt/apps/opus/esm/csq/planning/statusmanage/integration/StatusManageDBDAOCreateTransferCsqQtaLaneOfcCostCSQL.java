/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusManageDBDAOCreateTransferCsqQtaLaneOfcCostCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.statusmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusManageDBDAOCreateTransferCsqQtaLaneOfcCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Transfer 시 연간 정보로 1Q CSQ_QTA_LANE_OFC_COST 생성
	  * </pre>
	  */
	public StatusManageDBDAOCreateTransferCsqQtaLaneOfcCostCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.statusmanage.integration ").append("\n"); 
		query.append("FileName : StatusManageDBDAOCreateTransferCsqQtaLaneOfcCostCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_QTA_LANE_OFC_COST (" ).append("\n"); 
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
		query.append("SELECT 'Q'    AS BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR AS BSE_YR" ).append("\n"); 
		query.append("      ,'1Q'   AS BSE_QTR_CD" ).append("\n"); 
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
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM CSQ_QTA_LANE_OFC_COST" ).append("\n"); 
		query.append(" WHERE BSE_TP_CD  = 'Y'" ).append("\n"); 
		query.append("   AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD = '00'" ).append("\n"); 

	}
}