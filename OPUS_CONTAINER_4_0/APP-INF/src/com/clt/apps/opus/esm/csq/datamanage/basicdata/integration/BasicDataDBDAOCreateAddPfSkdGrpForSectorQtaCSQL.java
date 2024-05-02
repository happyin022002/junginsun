/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BasicDataDBDAOCreateAddPfSkdGrpForSectorQtaCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOCreateAddPfSkdGrpForSectorQtaCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * P/F SKD Group Mgmt for IAS Sector  Quarter 정보를 추가생성한다.
	  * </pre>
	  */
	public BasicDataDBDAOCreateAddPfSkdGrpForSectorQtaCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOCreateAddPfSkdGrpForSectorQtaCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_SCTR_PF_GRP" ).append("\n"); 
		query.append("            (BSE_TP_CD" ).append("\n"); 
		query.append("            ,BSE_YR" ).append("\n"); 
		query.append("            ,BSE_QTR_CD" ).append("\n"); 
		query.append("            ,RLANE_CD" ).append("\n"); 
		query.append("            ,PF_GRP_CD" ).append("\n"); 
		query.append("            ,PF_SVC_TP_CD" ).append("\n"); 
		query.append("            ,TRD_CD" ).append("\n"); 
		query.append("            ,SUB_TRD_CD" ).append("\n"); 
		query.append("            ,PF_ROUT_DESC" ).append("\n"); 
		query.append("            ,CSQ_ACT_FLG " ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("SELECT C1.BSE_TP_CD" ).append("\n"); 
		query.append("       ,C1.BSE_YR" ).append("\n"); 
		query.append("       ,C1.BSE_QTR_CD" ).append("\n"); 
		query.append("       ,C1.RLANE_CD" ).append("\n"); 
		query.append("       ,LPAD(NVL(C2.PF_GRP_CD, C1.PF_GRP_CD+NVL((SELECT MAX(PF_GRP_CD)" ).append("\n"); 
		query.append("                                                   FROM CSQ_SCTR_PF_GRP" ).append("\n"); 
		query.append("                                                  WHERE 1=1" ).append("\n"); 
		query.append("                                                    AND BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                                    AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                                                    AND BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("                                                    AND RLANE_CD   = @[f_rlane_cd] ),0)" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        ,3,0) AS PF_GRP_CD" ).append("\n"); 
		query.append("       ,C1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("       ,C1.TRD_CD" ).append("\n"); 
		query.append("       ,C1.SUB_TRD_CD" ).append("\n"); 
		query.append("       ,C1.PF_ROUT_DESC" ).append("\n"); 
		query.append("       ,C1.CSQ_ACT_FLG" ).append("\n"); 
		query.append("       ,C1.CRE_USR_ID" ).append("\n"); 
		query.append("       ,C1.CRE_DT" ).append("\n"); 
		query.append("       ,C1.UPD_USR_ID" ).append("\n"); 
		query.append("       ,C1.UPD_DT      " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           @[f_bse_tp_cd] BSE_TP_CD" ).append("\n"); 
		query.append("          ,@[f_bse_yr] BSE_YR" ).append("\n"); 
		query.append("          ,@[f_bse_qtr_cd] BSE_QTR_CD" ).append("\n"); 
		query.append("          ,RLANE_CD" ).append("\n"); 
		query.append("          ,LPAD(DENSE_RANK() OVER (PARTITION BY VSL_SLAN_CD  ORDER BY PF_ROUT_DESC),3,0) PF_GRP_CD" ).append("\n"); 
		query.append("          ,ROW_NUMBER() OVER(PARTITION BY VSL_SLAN_CD ORDER BY PF_SVC_TP_CD) SEQ" ).append("\n"); 
		query.append("          ,PF_SVC_TP_CD" ).append("\n"); 
		query.append("          ,TRD_CD" ).append("\n"); 
		query.append("          ,SUB_TRD_CD" ).append("\n"); 
		query.append("          ,SUBSTR(PF_ROUT_DESC,4) PF_ROUT_DESC" ).append("\n"); 
		query.append("          ,'N' CSQ_ACT_FLG" ).append("\n"); 
		query.append("          ,SLAN_STND_FLG" ).append("\n"); 
		query.append("          ,VSL_SLAN_CD" ).append("\n"); 
		query.append("          ,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("          ,CRE_DT" ).append("\n"); 
		query.append("          ,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("          ,SYSDATE UPD_DT" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("               SELECT B3.VSL_SLAN_CD" ).append("\n"); 
		query.append("                     ,B1.RLANE_CD" ).append("\n"); 
		query.append("                     ,B1.TRD_CD" ).append("\n"); 
		query.append("                     ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("                     ,B3.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                     ,B3.SKD_DIR_CD" ).append("\n"); 
		query.append("                     ,B3.PORT_CD" ).append("\n"); 
		query.append("                     ,B3.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("                     ,SYS_CONNECT_BY_PATH(B3.PORT_CD||'/'||B3.SKD_DIR_CD,' - ') PF_ROUT_DESC" ).append("\n"); 
		query.append("                     ,CONNECT_BY_ISLEAF AS IS_LEAF" ).append("\n"); 
		query.append("                     ,B2.SLAN_STND_FLG" ).append("\n"); 
		query.append("                     ,B2.CRE_DT" ).append("\n"); 
		query.append("                 FROM (" ).append("\n"); 
		query.append("                       SELECT DISTINCT " ).append("\n"); 
		query.append("                              A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("                             ,A2.TRD_CD" ).append("\n"); 
		query.append("                             ,A3.PF_SKD_TP_CD" ).append("\n"); 
		query.append("                             ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("                             ,A2.RLANE_CD" ).append("\n"); 
		query.append("                         FROM CSQ_QTA_LANE_MGMT A1" ).append("\n"); 
		query.append("                             ,COA_MON_VVD A2" ).append("\n"); 
		query.append("                             ,VSK_VSL_SKD A3" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                          AND A1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                          AND A1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("                          AND A1.BSE_QTR_CD   = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("                          AND A2.TRD_CD       = A1.TRD_CD" ).append("\n"); 
		query.append("                          AND A2.RLANE_CD     = A1.RLANE_CD" ).append("\n"); 
		query.append("                          AND A2.SUB_TRD_CD   = A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                          AND A2.DIR_CD       = NVL(A1.LANE_DIR_CD, A2.DIR_CD)" ).append("\n"); 
		query.append("                          AND A1.CSQ_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append("                          AND A2.SLAN_CD      = A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("                          AND A2.VSL_CD       = A3.VSL_CD" ).append("\n"); 
		query.append("                          AND A2.SKD_VOY_NO   = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND A2.DIR_CD       = A3.SKD_DIR_CD" ).append("\n"); 
		query.append("                          AND A2.SLS_YRMON    LIKE @[f_bse_yr]||'%' " ).append("\n"); 
		query.append("                          AND A2.COST_WK      BETWEEN @[f_fm_wk] AND @[f_to_wk] " ).append("\n"); 
		query.append("                          AND A2.DELT_FLG     = 'N'    " ).append("\n"); 
		query.append("                          AND A1.IAS_SCTR_FLG = 'Y'" ).append("\n"); 
		query.append("                          AND A1.RLANE_CD     = @[f_rlane_cd] " ).append("\n"); 
		query.append("                          AND A3.PF_SKD_TP_CD NOT IN (SELECT PF_SVC_TP_CD" ).append("\n"); 
		query.append("                                                        FROM CSQ_SCTR_PF_GRP" ).append("\n"); 
		query.append("                                                       WHERE 1=1" ).append("\n"); 
		query.append("                                                         AND BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                                         AND BSE_YR     = @[f_bse_yr] " ).append("\n"); 
		query.append("                                                         AND BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("                                                         AND RLANE_CD   = @[f_rlane_cd] )" ).append("\n"); 
		query.append("                      ORDER BY A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("                              ,A3.PF_SKD_TP_CD" ).append("\n"); 
		query.append("                      ) B1" ).append("\n"); 
		query.append("                     ,VSK_PF_SKD B2 " ).append("\n"); 
		query.append("                     ,VSK_PF_SKD_DTL B3" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND B1.VSL_SLAN_CD  = B2.VSL_SLAN_CD" ).append("\n"); 
		query.append("                  AND B1.PF_SKD_TP_CD = B2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                  AND B2.VSL_SLAN_CD  = B3.VSL_SLAN_CD" ).append("\n"); 
		query.append("                  AND B2.PF_SVC_TP_CD = B3.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                  AND B2.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("           START WITH B3.PORT_ROTN_SEQ = 1" ).append("\n"); 
		query.append("     CONNECT BY PRIOR B3.PORT_ROTN_SEQ = B3.PORT_ROTN_SEQ-1" ).append("\n"); 
		query.append("            AND PRIOR B3.VSL_SLAN_CD   = B3.VSL_SLAN_CD" ).append("\n"); 
		query.append("            AND PRIOR B3.PF_SVC_TP_CD  = B3.PF_SVC_TP_CD" ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("     AND IS_LEAF = 1" ).append("\n"); 
		query.append("    ORDER BY VSL_SLAN_CD" ).append("\n"); 
		query.append("    ) C1" ).append("\n"); 
		query.append("--   ,CSQ_SCTR_PF_GRP C2" ).append("\n"); 
		query.append("    ,(SELECT DISTINCT " ).append("\n"); 
		query.append("            BSE_TP_CD" ).append("\n"); 
		query.append("           ,BSE_YR" ).append("\n"); 
		query.append("           ,BSE_QTR_CD" ).append("\n"); 
		query.append("           ,RLANE_CD" ).append("\n"); 
		query.append("           ,PF_GRP_CD" ).append("\n"); 
		query.append("           ,TRD_CD" ).append("\n"); 
		query.append("           ,SUB_TRD_CD" ).append("\n"); 
		query.append("           ,PF_ROUT_DESC" ).append("\n"); 
		query.append("    FROM CSQ_SCTR_PF_GRP" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("    AND BSE_YR     = @[f_bse_yr] " ).append("\n"); 
		query.append("    AND BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("    AND RLANE_CD   = @[f_rlane_cd] ) C2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND C1.RLANE_CD     = C2.RLANE_CD(+)" ).append("\n"); 
		query.append("  AND C1.PF_ROUT_DESC = C2.PF_ROUT_DESC(+)" ).append("\n"); 
		query.append("  AND C1.BSE_TP_CD    = C2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("  AND C1.BSE_YR       = C2.BSE_YR(+) " ).append("\n"); 
		query.append("  AND C1.BSE_QTR_CD   = C2.BSE_QTR_CD(+)" ).append("\n"); 

	}
}