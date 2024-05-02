/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : StatusManageDBDAOCreateTransferSqmQtaRbcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.10
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.10.10 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusManageDBDAOCreateTransferSqmQtaRbcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Transfer 시 연간 정보로 1Q SQM_QTA_RBC 생성
	  * </pre>
	  */
	public StatusManageDBDAOCreateTransferSqmQtaRbcCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration").append("\n"); 
		query.append("FileName : StatusManageDBDAOCreateTransferSqmQtaRbcCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_QTA_RBC (" ).append("\n"); 
		query.append("       BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,OFC_VW_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,RGN_OFC_CD" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,GID_LOD_QTY" ).append("\n"); 
		query.append("      ,GID_GRS_REV" ).append("\n"); 
		query.append("      ,GID_PA_CM_AMT" ).append("\n"); 
		query.append("      ,GID_RA_CM_AMT" ).append("\n"); 
		query.append("      ,LOD_QTY" ).append("\n"); 
		query.append("      ,GRS_REV" ).append("\n"); 
		query.append("      ,PA_CM_AMT" ).append("\n"); 
		query.append("      ,RA_CM_AMT" ).append("\n"); 
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
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,NVL(GID_LOD_QTY, 0) AS GID_LOD_QTY" ).append("\n"); 
		query.append("      ,NVL(GID_GRS_REV, 0) AS GID_GRS_REV" ).append("\n"); 
		query.append("      ,NVL(GID_PA_CM_AMT, 0) AS GID_PA_CM_AMT" ).append("\n"); 
		query.append("      ,NVL(GID_RA_CM_AMT, 0) AS GID_RA_CM_AMT" ).append("\n"); 
		query.append("      ,NVL(LOD_QTY, 0) AS LOD_QTY" ).append("\n"); 
		query.append("      ,NVL(GRS_REV, 0) AS GRS_REV" ).append("\n"); 
		query.append("      ,NVL(PA_CM_AMT, 0) AS PA_CM_AMT" ).append("\n"); 
		query.append("      ,NVL(RA_CM_AMT, 0) AS RA_CM_AMT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM SQM_QTA_RBC" ).append("\n"); 
		query.append(" WHERE BSE_TP_CD  = 'Y'" ).append("\n"); 
		query.append("   AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD = '00'" ).append("\n"); 

	}
}