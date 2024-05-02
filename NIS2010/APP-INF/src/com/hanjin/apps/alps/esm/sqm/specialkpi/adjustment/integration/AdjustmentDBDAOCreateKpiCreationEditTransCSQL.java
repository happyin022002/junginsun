/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AdjustmentDBDAOCreateKpiCreationEditTransCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentDBDAOCreateKpiCreationEditTransCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 연간데이터 1분기 전환(확정데이터) : CreateKpiCreationEditTrans
	  * </pre>
	  */
	public AdjustmentDBDAOCreateKpiCreationEditTransCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOCreateKpiCreationEditTransCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SPCL_CFM_QTA (" ).append("\n"); 
		query.append("            BSE_TP_CD" ).append("\n"); 
		query.append("           ,BSE_YR" ).append("\n"); 
		query.append("           ,BSE_QTR_CD" ).append("\n"); 
		query.append("           ,SPCL_TGT_CD" ).append("\n"); 
		query.append("           ,TRD_CD" ).append("\n"); 
		query.append("           ,RLANE_CD" ).append("\n"); 
		query.append("           ,DIR_CD" ).append("\n"); 
		query.append("           ,VSL_CD" ).append("\n"); 
		query.append("           ,SKD_VOY_NO" ).append("\n"); 
		query.append("           ,SKD_DIR_CD" ).append("\n"); 
		query.append("           ,RGN_OFC_CD" ).append("\n"); 
		query.append("           ,RHQ_CD" ).append("\n"); 
		query.append("           ,AQ_CD" ).append("\n"); 
		query.append("           ,CONV_DIR_CD" ).append("\n"); 
		query.append("           ,LOD_QTY" ).append("\n"); 
		query.append("           ,GRS_RPB_REV" ).append("\n"); 
		query.append("           ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("           ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("           ,SQM_CNG_TP_CD" ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,UPD_DT " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("SELECT 'Q' AS BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,SPCL_TGT_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,RGN_OFC_CD" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,AQ_CD" ).append("\n"); 
		query.append("      ,CONV_DIR_CD" ).append("\n"); 
		query.append("      ,LOD_QTY" ).append("\n"); 
		query.append("      ,GRS_RPB_REV" ).append("\n"); 
		query.append("      ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,SQM_CNG_TP_CD" ).append("\n"); 
		query.append("      ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE   AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE   ASUPD_DT" ).append("\n"); 
		query.append("  FROM SQM_SPCL_CFM_QTA" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BSE_TP_CD   = 'Y'" ).append("\n"); 
		query.append("   AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD  = '1Q'" ).append("\n"); 
		query.append("   AND SPCL_TGT_CD = @[f_spcl_tgt_cd]" ).append("\n"); 

	}
}