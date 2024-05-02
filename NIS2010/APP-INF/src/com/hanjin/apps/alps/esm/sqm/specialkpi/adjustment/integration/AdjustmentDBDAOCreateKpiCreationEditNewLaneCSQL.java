/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AdjustmentDBDAOCreateKpiCreationEditNewLaneCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.16 
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

public class AdjustmentDBDAOCreateKpiCreationEditNewLaneCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateKpiCreationEditNewLane
	  * 
	  * * 2014.09.17 이혜민 [CHM-201431755-01] New Lane Add시 Bound 삽입
	  * </pre>
	  */
	public AdjustmentDBDAOCreateKpiCreationEditNewLaneCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOCreateKpiCreationEditNewLaneCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SPCL_CFM_QTA(" ).append("\n"); 
		query.append("         BSE_TP_CD" ).append("\n"); 
		query.append("        ,BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,SPCL_TGT_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,VSL_CD" ).append("\n"); 
		query.append("        ,SKD_VOY_NO" ).append("\n"); 
		query.append("        ,SKD_DIR_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,AQ_CD" ).append("\n"); 
		query.append("        ,CONV_DIR_CD" ).append("\n"); 
		query.append("        ,LOD_QTY" ).append("\n"); 
		query.append("        ,GRS_RPB_REV" ).append("\n"); 
		query.append("        ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,SQM_CNG_TP_CD" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A2.SPCL_TGT_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A2.RGN_OFC_CD" ).append("\n"); 
		query.append("--MDM에서 RHQ를 찾아온 후 없으면 SQM_QTA_OFC에서 찾음" ).append("\n"); 
		query.append("      ,NVL((SELECT N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("             FROM SQM_ORGANIZATION_V V" ).append("\n"); 
		query.append("            WHERE V.OFC_CD = A2.RGN_OFC_CD" ).append("\n"); 
		query.append("         ),(SELECT RHQ_CD" ).append("\n"); 
		query.append("             FROM SQM_QTA_OFC " ).append("\n"); 
		query.append("            WHERE RGN_OFC_CD = A2.RGN_OFC_CD)) AS RHQ_CD" ).append("\n"); 
		query.append("      ,NVL((SELECT N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("          FROM SQM_ORGANIZATION_V V" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("         AND V.OFC_CD = A2.RGN_OFC_CD),'') AS AQ_CD" ).append("\n"); 
		query.append("      ,A2.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,NVL(A2.LOD_QTY, 0) AS LOD_QTY" ).append("\n"); 
		query.append("      ,NVL(A2.GRS_RPB_REV, 0) AS GRS_RPB_REV" ).append("\n"); 
		query.append("      ,A2.PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,A2.RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,'I' AS SQM_CNG_TP_CD" ).append("\n"); 
		query.append("      ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("  FROM SQM_SPCL_TGT_VVD A1" ).append("\n"); 
		query.append("      ,SQM_SPCL_NEW_LANE A2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.BSE_YR          = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD       = @[f_bse_tp_cd]    -- Q, Y 필수" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD      = @[f_bse_qtr_cd]   -- Quartely일때 필수" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A2.SPCL_TGT_CD     = @[f_spcl_tgt_cd]  -- S, R 필수" ).append("\n"); 
		query.append("   AND A1.TRD_CD          = @[f_trd_cd]       -- TRADE" ).append("\n"); 
		query.append("   AND A1.RLANE_CD        = @[f_rlane_cd]     -- NEW LANE" ).append("\n"); 
		query.append("#if(${f_dir_cd} != '')" ).append("\n"); 
		query.append("   AND A1.DIR_CD          = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD       = A2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR          = A2.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD      = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD          = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD        = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD          = A2.DIR_CD" ).append("\n"); 

	}
}