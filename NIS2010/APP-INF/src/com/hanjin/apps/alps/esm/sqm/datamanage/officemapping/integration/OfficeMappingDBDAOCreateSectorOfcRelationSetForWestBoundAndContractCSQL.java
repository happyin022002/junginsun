/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OfficeMappingDBDAOCreateSectorOfcRelationSetForWestBoundAndContractCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOCreateSectorOfcRelationSetForWestBoundAndContractCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sector Office Relation Setting for IAS Sector 를 생성합니다.
	  * 2015.05.12 김용습 - [CHM-201535562] [SQM] Sector-Office Relation Setting for IAS Sector
	  *  - 타임아웃 방지를 위해 OfficeMappingDBDAOCreateSectorOfcRelationSetCSQL.Query의 데이터를 나누어 생성되게 함(여기서는 W 바운드의 Contract 데이터만 생성)
	  * 2015.08.10 김용습 SQM_ACT_FLG 가져오는 서브쿼리에 A1.PF_GRP_CD  = A3.PF_GRP_CD 추가
	  * </pre>
	  */
	public OfficeMappingDBDAOCreateSectorOfcRelationSetForWestBoundAndContractCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOCreateSectorOfcRelationSetForWestBoundAndContractCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SCTR_LANE_OFC" ).append("\n"); 
		query.append("          ( BSE_TP_CD," ).append("\n"); 
		query.append("            BSE_YR," ).append("\n"); 
		query.append("            BSE_QTR_CD," ).append("\n"); 
		query.append("            OFC_VW_CD," ).append("\n"); 
		query.append("            RLANE_CD," ).append("\n"); 
		query.append("            DIR_CD," ).append("\n"); 
		query.append("            PF_GRP_CD," ).append("\n"); 
		query.append("            RGN_OFC_CD," ).append("\n"); 
		query.append("            POL_CD," ).append("\n"); 
		query.append("            POD_CD," ).append("\n"); 
		query.append("            RHQ_CD," ).append("\n"); 
		query.append("            TRD_CD," ).append("\n"); 
		query.append("            SUB_TRD_CD," ).append("\n"); 
		query.append("            POL_CALL_SEQ," ).append("\n"); 
		query.append("            POD_CALL_SEQ," ).append("\n"); 
		query.append("            SQM_ACT_FLG," ).append("\n"); 
		query.append("            ADD_FLG," ).append("\n"); 
		query.append("            CRE_USR_ID," ).append("\n"); 
		query.append("            CRE_DT," ).append("\n"); 
		query.append("            UPD_USR_ID," ).append("\n"); 
		query.append("            UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("SELECT A2.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A2.BSE_YR" ).append("\n"); 
		query.append("      ,A2.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A2.OFC_VW_CD" ).append("\n"); 
		query.append("      ,A2.RLANE_CD" ).append("\n"); 
		query.append("      ,A2.DIR_CD" ).append("\n"); 
		query.append("      ,A1.PF_GRP_CD" ).append("\n"); 
		query.append("      ,A2.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("      ,A2.RHQ_CD" ).append("\n"); 
		query.append("      ,A2.TRD_CD" ).append("\n"); 
		query.append("      ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.POL_CALL_SEQ" ).append("\n"); 
		query.append("      ,A1.POD_CALL_SEQ" ).append("\n"); 
		query.append("--      ,A2.SQM_ACT_FLG" ).append("\n"); 
		query.append("	  ,NVL((SELECT DISTINCT A3.SQM_ACT_FLG " ).append("\n"); 
		query.append("            FROM SQM_SCTR_LANE_OFC A3" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A3.BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("            AND A3.BSE_YR = DECODE(@[f_bse_tp_cd], 'Y', @[f_bse_yr]-1, DECODE(@[f_bse_qtr_cd], '1Q', @[f_bse_yr]-1, @[f_bse_yr]))" ).append("\n"); 
		query.append("            AND A3.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '4Q', DECODE(@[f_bse_qtr_cd], '1Q', '4Q', '2Q', '1Q', '3Q', '2Q', '4Q', '3Q'))" ).append("\n"); 
		query.append("            AND A2.OFC_VW_CD = A3.OFC_VW_CD" ).append("\n"); 
		query.append("            AND A2.RLANE_CD = A3.RLANE_CD" ).append("\n"); 
		query.append("            AND A2.DIR_CD = A3.DIR_CD" ).append("\n"); 
		query.append("            AND A2.RGN_OFC_CD = A3.RGN_OFC_CD" ).append("\n"); 
		query.append("            AND A1.POL_CD = A3.POL_CD" ).append("\n"); 
		query.append("            AND A1.POD_CD = A3.POD_CD" ).append("\n"); 
		query.append("            AND A2.RHQ_CD = A3.RHQ_CD" ).append("\n"); 
		query.append("            AND A2.TRD_CD = A3.TRD_CD" ).append("\n"); 
		query.append("            AND A2.SUB_TRD_CD = A3.SUB_TRD_CD" ).append("\n"); 
		query.append("			AND A1.PF_GRP_CD = A3.PF_GRP_CD" ).append("\n"); 
		query.append("          ), 'N') AS SQM_ACT_FLG" ).append("\n"); 
		query.append("      ,'N' ADD_FLG" ).append("\n"); 
		query.append("      ,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE CRE_DT     " ).append("\n"); 
		query.append("      ,@[usr_id]UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE UPD_DT " ).append("\n"); 
		query.append("  FROM SQM_SCTR_PAIR_MGMT A1" ).append("\n"); 
		query.append("      ,SQM_QTA_LANE_OFC A2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = 'W'" ).append("\n"); 
		query.append("   AND A2.OFC_VW_CD = 'C'" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR     = A2.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD     = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = A2.DIR_CD" ).append("\n"); 

	}
}