/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanningDBDAOCreateTransferCsqSctrLodRevCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOCreateTransferCsqSctrLodRevCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CSQ_SCTR_LOD_REV] 데이터를 1Q로 복사한다.
	  * </pre>
	  */
	public PlanningDBDAOCreateTransferCsqSctrLodRevCSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.csq.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOCreateTransferCsqSctrLodRevCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_SCTR_LOD_REV(BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, RLANE_CD, DIR_CD, FNL_BSA_CAPA, PF_GRP_CD, RGN_OFC_CD, POL_CD, POD_CD, TRD_CD, SUB_TRD_CD, RHQ_CD, GID_LOD_QTY, GID_GRS_RPB_REV, LOD_QTY, GRS_RPB_REV, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("SELECT 'Q' AS BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,'1Q' BSE_QTR_CD" ).append("\n"); 
		query.append("      ,OFC_VW_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,PF_GRP_CD" ).append("\n"); 
		query.append("      ,RGN_OFC_CD" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,GID_LOD_QTY" ).append("\n"); 
		query.append("      ,GID_GRS_RPB_REV" ).append("\n"); 
		query.append("      ,LOD_QTY" ).append("\n"); 
		query.append("      ,GRS_RPB_REV" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM CSQ_SCTR_LOD_REV" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BSE_TP_CD  = 'Y'" ).append("\n"); 
		query.append("   AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD = '00'" ).append("\n"); 

	}
}