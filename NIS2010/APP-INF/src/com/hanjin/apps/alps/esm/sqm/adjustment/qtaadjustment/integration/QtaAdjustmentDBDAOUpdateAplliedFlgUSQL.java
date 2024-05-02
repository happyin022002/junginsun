/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOUpdateAplliedFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOUpdateAplliedFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Allocation = QTA Adjustment화면에서 sel체크 후 Activate시 해당 Lane-Office페어의 세팅을 Active로 업데이트(또는 insert)해주는 쿼리
	  * 2015.10.05 김용습 [CHM-201537934] [CSR 전환건] Allocation = QTA의 "SPC Alloc Apply" 로직 수정
	  * </pre>
	  */
	public QtaAdjustmentDBDAOUpdateAplliedFlgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOUpdateAplliedFlgUSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_QTA_LANE_OFC" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("         BSE_TP_CD  = 'Q'" ).append("\n"); 
		query.append("         AND BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("         AND BSE_QTR_CD = (CASE WHEN @[bse_mon] = '01' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '02' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '03' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '04' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '05' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '06' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '07' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '08' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '09' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '10' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '11' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '12' THEN '4Q'" ).append("\n"); 
		query.append("                                END)" ).append("\n"); 
		query.append("         AND OFC_VW_CD  = 'L'" ).append("\n"); 
		query.append("         AND TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("         AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("         AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("         AND DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("         AND RGN_OFC_CD = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("         AND RHQ_CD     = @[rhq_cd]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET " ).append("\n"); 
		query.append("    SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("    ,UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("    ,UPD_DT        = SYSDATE " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT" ).append("\n"); 
		query.append("    (BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, TRD_CD, RLANE_CD, DIR_CD, RGN_OFC_CD, RHQ_CD, SUB_TRD_CD, SQM_ACT_FLG, ADD_FLG, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("    VALUES" ).append("\n"); 
		query.append("    ('Q'" ).append("\n"); 
		query.append("    , @[bse_yr]" ).append("\n"); 
		query.append("    , CASE WHEN @[bse_mon] = '01' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '02' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '03' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '04' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '05' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '06' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '07' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '08' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '09' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '10' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '11' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '12' THEN '4Q'" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("    , 'L'" ).append("\n"); 
		query.append("    , @[trd_cd]" ).append("\n"); 
		query.append("    , @[rlane_cd]" ).append("\n"); 
		query.append("    , @[dir_cd]" ).append("\n"); 
		query.append("    , @[rgn_ofc_cd]" ).append("\n"); 
		query.append("    , @[rhq_cd]" ).append("\n"); 
		query.append("    , @[sub_trd_cd]" ).append("\n"); 
		query.append("    , 'Y'" ).append("\n"); 
		query.append("    , 'N'" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}