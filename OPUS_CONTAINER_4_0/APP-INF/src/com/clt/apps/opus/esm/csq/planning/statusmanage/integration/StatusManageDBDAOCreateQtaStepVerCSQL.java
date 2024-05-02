/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusManageDBDAOCreateQtaStepVerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.statusmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusManageDBDAOCreateQtaStepVerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HO_L_F & G.RPB 관련 Setp Ver Data 생성
	  * [CHM-201328244] IAS Sector Sales 판매시스템 개발
	  * </pre>
	  */
	public StatusManageDBDAOCreateQtaStepVerCSQL(){
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
		params.put("f_qta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.statusmanage.integration").append("\n"); 
		query.append("FileName : StatusManageDBDAOCreateQtaStepVerCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_QTA_STEP_VER (" ).append("\n"); 
		query.append("         BSE_TP_CD" ).append("\n"); 
		query.append("        ,BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,OFC_VW_CD" ).append("\n"); 
		query.append("        ,QTA_STEP_CD" ).append("\n"); 
		query.append("        ,QTA_VER_NO" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,CONV_DIR_CD" ).append("\n"); 
		query.append("        ,CSQ_VER_STS_CD" ).append("\n"); 
		query.append("        ,CFM_GDT" ).append("\n"); 
		query.append("        ,CRE_OFC_CD" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT DISTINCT " ).append("\n"); 
		query.append("         B1.BSE_TP_CD" ).append("\n"); 
		query.append("        ,B1.BSE_YR" ).append("\n"); 
		query.append("        ,B1.BSE_QTR_CD" ).append("\n"); 
		query.append("        ,DECODE(@[f_qta_step_cd], '01', 'C', B1.OFC_VW_CD) AS OFC_VW_CD" ).append("\n"); 
		query.append("        ,DECODE(@[f_qta_step_cd], '01', '01'" ).append("\n"); 
		query.append("                                , '02', '02'" ).append("\n"); 
		query.append("                                , DECODE(B1.OFC_VW_CD, 'L', '03', DECODE(B1.OB_DIV_CD, 'N', '04', 'O', '05'))) AS QTA_STEP_CD" ).append("\n"); 
		query.append("        ,SUBSTR(B1.TEAM_CD, -3) || DECODE(@[f_qta_step_cd], '01', B1.TEAM_CD" ).append("\n"); 
		query.append("                                                          , '02', B1.TEAM_CD" ).append("\n"); 
		query.append("                                                          , B1.RHQ_CD) || SUBSTR(B1.BSE_YR, -2) || B1.BSE_QTR_CD || '01' AS QTA_VER_NO" ).append("\n"); 
		query.append("        ,B1.TRD_CD" ).append("\n"); 
		query.append("        ,B2.CONV_DIR_CD" ).append("\n"); 
		query.append("        ,'I' AS CSQ_VER_STS_CD" ).append("\n"); 
		query.append("        ,NULL AS CFM_GDT" ).append("\n"); 
		query.append("        ,DECODE(@[f_qta_step_cd], '01', B1.TEAM_CD" ).append("\n"); 
		query.append("                                , '02', B1.TEAM_CD" ).append("\n"); 
		query.append("                                , B1.RHQ_CD) AS CRE_OFC_CD" ).append("\n"); 
		query.append("        ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("        ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("    FROM CSQ_DAT_RLT B1" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("           SELECT DISTINCT" ).append("\n"); 
		query.append("                  A1.BSE_TP_CD" ).append("\n"); 
		query.append("                 ,A1.BSE_YR" ).append("\n"); 
		query.append("                 ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                 ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("                 ,A1.RHQ_CD" ).append("\n"); 
		query.append("                 ,A1.TRD_CD" ).append("\n"); 
		query.append("                 ,A1.DIR_CD" ).append("\n"); 
		query.append("                 ,NVL(A2.CONV_DIR_CD, A1.DIR_CD) AS CONV_DIR_CD" ).append("\n"); 
		query.append("             FROM CSQ_QTA_LANE_OFC A1" ).append("\n"); 
		query.append("                 ,CSQ_DIR_CONV     A2" ).append("\n"); 
		query.append("            WHERE A1.BSE_TP_CD   = A2.BSE_TP_CD  (+)" ).append("\n"); 
		query.append("              AND A1.BSE_YR      = A2.BSE_YR     (+)" ).append("\n"); 
		query.append("              AND A1.BSE_QTR_CD  = A2.BSE_QTR_CD (+)" ).append("\n"); 
		query.append("              AND A1.TRD_CD      = A2.TRD_CD     (+)" ).append("\n"); 
		query.append("              AND A1.RLANE_CD    = A2.RLANE_CD   (+)" ).append("\n"); 
		query.append("              AND A1.DIR_CD      = A2.DIR_CD     (+)" ).append("\n"); 
		query.append("              AND A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("              AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("              AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("    	      AND 1 = (" ).append("\n"); 
		query.append("                        SELECT DISTINCT 1" ).append("\n"); 
		query.append("                          FROM CSQ_QTA_LANE_MGMT S1" ).append("\n"); 
		query.append("                        WHERE S1.TRD_CD     = A1.TRD_CD" ).append("\n"); 
		query.append("                   		  AND S1.BSE_TP_CD  = A1.BSE_TP_CD" ).append("\n"); 
		query.append("                   		  AND S1.BSE_YR     = A1.BSE_YR" ).append("\n"); 
		query.append("                   		  AND S1.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                          AND S1.RLANE_CD   = A1.RLANE_CD" ).append("\n"); 
		query.append("                          AND S1.IAS_SCTR_FLG = 'N'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ) B2" ).append("\n"); 
		query.append("   WHERE B1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND B1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND B1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("     AND B1.BSE_TP_CD   = B2.BSE_TP_CD" ).append("\n"); 
		query.append("     AND B1.BSE_YR      = B2.BSE_YR" ).append("\n"); 
		query.append("     AND B1.BSE_QTR_CD  = B2.BSE_QTR_CD" ).append("\n"); 
		query.append("     AND B1.OFC_VW_CD   = B2.OFC_VW_CD" ).append("\n"); 
		query.append("     AND B1.RHQ_CD      = B2.RHQ_CD" ).append("\n"); 
		query.append("     AND B1.TRD_CD      = B2.TRD_CD" ).append("\n"); 
		query.append("     AND B1.CONV_DIR_CD = B2.CONV_DIR_CD" ).append("\n"); 
		query.append("ORDER BY B1.TRD_CD" ).append("\n"); 
		query.append("        ,B2.CONV_DIR_CD" ).append("\n"); 

	}
}