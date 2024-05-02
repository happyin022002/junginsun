/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostManageDBDAOCreationSectorLaneOfficeForAddedOfcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.19 
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

public class CostManageDBDAOCreationSectorLaneOfficeForAddedOfcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ Office Mapping 에서 New Office Creation 할때 Sector Office Relation for IAS Sector에도 추가해 준다.
	  * 
	  * * History 
	  * 2014.07.03 박은주 [CHM-201430932] RHQ Office Mapping에 Office 추가시 Sector Office 반영 요청
	  * 2014.08.19 이혜민 [CHM-201431600] Office가 하나도 생성되지 않은 Lane에는 넣지 않고. Office가 이미 생성된 Lane에만 insert.
	  * </pre>
	  */
	public CostManageDBDAOCreationSectorLaneOfficeForAddedOfcCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOCreationSectorLaneOfficeForAddedOfcCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SCTR_LANE_OFC(BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, RLANE_CD, DIR_CD, PF_GRP_CD, RGN_OFC_CD, POL_CD, POD_CD, RHQ_CD, TRD_CD, SUB_TRD_CD, POL_CALL_SEQ, POD_CALL_SEQ, SQM_ACT_FLG, ADD_FLG, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("     , A1.BSE_YR" ).append("\n"); 
		query.append("     , A1.BSE_QTR_CD" ).append("\n"); 
		query.append("     , A1.OFC_VW_CD" ).append("\n"); 
		query.append("     , A1.RLANE_CD" ).append("\n"); 
		query.append("     , A1.DIR_CD" ).append("\n"); 
		query.append("     , A2.PF_GRP_CD" ).append("\n"); 
		query.append("     , A1.RGN_OFC_CD" ).append("\n"); 
		query.append("     , A2.POL_CD" ).append("\n"); 
		query.append("     , A2.POD_CD" ).append("\n"); 
		query.append("     , A1.RHQ_CD" ).append("\n"); 
		query.append("     , A1.TRD_CD" ).append("\n"); 
		query.append("     , A1.SUB_TRD_CD" ).append("\n"); 
		query.append("     , A2.POL_CALL_SEQ" ).append("\n"); 
		query.append("     , A2.POD_CALL_SEQ" ).append("\n"); 
		query.append("     , 'N' SQM_ACT_FLG" ).append("\n"); 
		query.append("     , 'N' ADD_FLG" ).append("\n"); 
		query.append("     , @[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE CRE_DT" ).append("\n"); 
		query.append("     , @[cre_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE UPD_DT " ).append("\n"); 
		query.append("  FROM SQM_QTA_LANE_OFC A1" ).append("\n"); 
		query.append("      ,SQM_SCTR_PAIR_MGMT A2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD = DECODE(@[bse_tp_cd],'Y','00',@[bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A1.TRD_CD      = 'IAS'" ).append("\n"); 
		query.append("   AND A2.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = A2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = A2.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD      = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD    = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD      = A2.DIR_CD" ).append("\n"); 
		query.append("   AND A1.RGN_OFC_CD  = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("   AND EXISTS (SELECT * " ).append("\n"); 
		query.append("           		FROM SQM_SCTR_LANE_OFC B1" ).append("\n"); 
		query.append("           		WHERE A1.BSE_TP_CD   = B1.BSE_TP_CD   " ).append("\n"); 
		query.append("            	AND  A1.BSE_YR       = B1.BSE_YR         " ).append("\n"); 
		query.append("            	AND  A1.BSE_QTR_CD   = B1.BSE_QTR_CD     " ).append("\n"); 
		query.append("            	AND  A1.OFC_VW_CD    = B1.OFC_VW_CD      " ).append("\n"); 
		query.append("            	AND  A1.TRD_CD       = B1.TRD_CD         " ).append("\n"); 
		query.append("            	AND  A1.SUB_TRD_CD   = B1.SUB_TRD_CD     " ).append("\n"); 
		query.append("            	AND  A1.RLANE_CD     = B1.RLANE_CD       " ).append("\n"); 
		query.append("            	AND  A1.DIR_CD       = B1.DIR_CD      " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("ORDER BY OFC_VW_CD,DIR_CD,PF_GRP_CD,POL_CD,POD_CD,RGN_OFC_CD" ).append("\n"); 

	}
}