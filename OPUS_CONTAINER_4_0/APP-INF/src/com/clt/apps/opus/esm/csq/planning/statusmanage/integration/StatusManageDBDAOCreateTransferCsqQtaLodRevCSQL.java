/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusManageDBDAOCreateTransferCsqQtaLodRevCSQL.java
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

public class StatusManageDBDAOCreateTransferCsqQtaLodRevCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Transfer 시 연간 정보로 1Q CSQ_QTA_LOD_REV 생성
	  * </pre>
	  */
	public StatusManageDBDAOCreateTransferCsqQtaLodRevCSQL(){
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
		query.append("FileName : StatusManageDBDAOCreateTransferCsqQtaLodRevCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_QTA_LOD_REV (" ).append("\n"); 
		query.append("       BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,OFC_VW_CD" ).append("\n"); 
		query.append("      ,QTA_STEP_CD" ).append("\n"); 
		query.append("      ,QTA_VER_NO" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,CONV_DIR_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,LDF_RTO" ).append("\n"); 
		query.append("      ,GRS_RPB_REV" ).append("\n"); 
		query.append("      ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT 'Q'      AS BSE_TP_CD" ).append("\n"); 
		query.append("      ,L.BSE_YR AS BSE_YR" ).append("\n"); 
		query.append("      ,'1Q'     AS BSE_QTR_CD" ).append("\n"); 
		query.append("      ,L.OFC_VW_CD" ).append("\n"); 
		query.append("      ,L.QTA_STEP_CD" ).append("\n"); 
		query.append("      ,SUBSTR(L.QTA_VER_NO, 1, 11) || '1Q' || SUBSTR(L.QTA_VER_NO, -2) AS QTA_VER_NO" ).append("\n"); 
		query.append("      ,L.TRD_CD" ).append("\n"); 
		query.append("      ,L.RLANE_CD" ).append("\n"); 
		query.append("      ,L.VSL_CD" ).append("\n"); 
		query.append("      ,L.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,L.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,L.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,L.DIR_CD" ).append("\n"); 
		query.append("      ,L.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,L.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,L.LDF_RTO" ).append("\n"); 
		query.append("      ,L.GRS_RPB_REV" ).append("\n"); 
		query.append("      ,L.PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,L.RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM CSQ_QTA_TGT_VVD T" ).append("\n"); 
		query.append("      ,CSQ_QTA_LOD_REV L" ).append("\n"); 
		query.append(" WHERE T.BSE_TP_CD  = 'Y'" ).append("\n"); 
		query.append("   AND T.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND T.BSE_QTR_CD = '00'" ).append("\n"); 
		query.append("   AND T.BSE_TP_CD  = L.BSE_TP_CD" ).append("\n"); 
		query.append("   AND T.BSE_YR     = L.BSE_YR" ).append("\n"); 
		query.append("   AND T.BSE_QTR_CD = L.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND T.TRD_CD     = L.TRD_CD" ).append("\n"); 
		query.append("   AND T.RLANE_CD   = L.RLANE_CD" ).append("\n"); 
		query.append("   AND T.DIR_CD     = L.DIR_CD" ).append("\n"); 
		query.append("   AND T.VSL_CD     = L.VSL_CD " ).append("\n"); 
		query.append("   AND T.SKD_VOY_NO = L.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND T.SKD_DIR_CD = L.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND T.BSE_WK BETWEEN '00' AND '13'" ).append("\n"); 

	}
}