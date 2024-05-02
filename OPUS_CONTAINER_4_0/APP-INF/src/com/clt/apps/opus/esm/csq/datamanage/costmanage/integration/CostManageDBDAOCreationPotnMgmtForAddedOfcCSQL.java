/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostManageDBDAOCreationPotnMgmtForAddedOfcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOCreationPotnMgmtForAddedOfcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ Office Mapping 에서 New Office Creation 할때 
	  * 추가된 Office에 대해서 Portion MGMT정보를 생성한다.
	  * </pre>
	  */
	public CostManageDBDAOCreationPotnMgmtForAddedOfcCSQL(){
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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOCreationPotnMgmtForAddedOfcCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_QTA_POTN_MGMT (" ).append("\n"); 
		query.append("       BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,OFC_VW_CD" ).append("\n"); 
		query.append("      ,QTA_STEP_CD" ).append("\n"); 
		query.append("      ,QTA_VER_NO" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,RGN_OFC_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,CONV_DIR_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,GID_LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,GID_REV_POTN_RTO" ).append("\n"); 
		query.append("      ,LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,REV_POTN_RTO" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("      ,DECODE(A4.OFC_VW_CD, 'L', '03', DECODE(A4.OB_DIV_CD, 'N', '04', 'O', '05')) AS QTA_STEP_CD" ).append("\n"); 
		query.append("      ,SUBSTR(A4.TEAM_CD, -3) || A4.RHQ_CD || SUBSTR(A4.BSE_YR, -2) || A4.BSE_QTR_CD || '01' AS QTA_VER_NO" ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,NVL(A3.CONV_DIR_CD, A1.DIR_CD) AS CONV_DIR_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,0 AS GID_LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,0 AS GID_REV_POTN_RTO" ).append("\n"); 
		query.append("      ,0 AS LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,0 AS REV_POTN_RTO" ).append("\n"); 
		query.append("      ,@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[cre_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM CSQ_QTA_LANE_OFC A1" ).append("\n"); 
		query.append("      ,CSQ_DIR_CONV     A3" ).append("\n"); 
		query.append("      ,CSQ_DAT_RLT      A4" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD      = A3.BSE_TP_CD  (+)" ).append("\n"); 
		query.append("   AND A1.BSE_YR         = A3.BSE_YR     (+)" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD     = A3.BSE_QTR_CD (+)" ).append("\n"); 
		query.append("   AND A1.TRD_CD         = A3.TRD_CD     (+)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD       = A3.RLANE_CD   (+)" ).append("\n"); 
		query.append("   AND A1.DIR_CD         = A3.DIR_CD     (+)" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD      = A4.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR         = A4.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD     = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.OFC_VW_CD      = A4.OFC_VW_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD         = A4.TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND NVL(A3.CONV_DIR_CD,A1.DIR_CD) = A4.CONV_DIR_CD" ).append("\n"); 
		query.append("   AND A1.RHQ_CD         = A4.RHQ_CD" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD      = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR         = @[bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD     = DECODE(@[bse_tp_cd],'Y','00',@[bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A1.RLANE_CD      <> 'RBCCO'" ).append("\n"); 
		query.append("   AND A1.RGN_OFC_CD  	 = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("   AND 1 = (" ).append("\n"); 
		query.append("              SELECT DISTINCT 1" ).append("\n"); 
		query.append("                FROM CSQ_QTA_LANE_MGMT S1" ).append("\n"); 
		query.append("              WHERE S1.TRD_CD     = A1.TRD_CD" ).append("\n"); 
		query.append("                AND S1.BSE_TP_CD  = A1.BSE_TP_CD" ).append("\n"); 
		query.append("                AND S1.BSE_YR     = A1.BSE_YR" ).append("\n"); 
		query.append("                AND S1.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                AND S1.RLANE_CD   = A1.RLANE_CD" ).append("\n"); 
		query.append("                AND S1.IAS_SCTR_FLG = 'N'" ).append("\n"); 
		query.append("             )" ).append("\n"); 

	}
}