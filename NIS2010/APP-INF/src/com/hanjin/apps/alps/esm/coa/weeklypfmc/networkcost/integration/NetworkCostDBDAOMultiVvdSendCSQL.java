/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : NetworkCostDBDAOMultiVvdSendCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.02
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2012.02.02 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOMultiVvdSendCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bunker Tariff 정보를 생성한다.
	  * [CHM-201215754-01] [COA] Bunker Fee 화면 개발 건 쿼리 변경 -FCM의 Cons 정보를 COA_BNK_TRF 테이블 Cons에 MERGE 하는 쿼리.
	  * </pre>
	  */
	public NetworkCostDBDAOMultiVvdSendCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOMultiVvdSendCSQL").append("\n"); 
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
		query.append("-- YYYY-WW에서만 사용" ).append("\n"); 
		query.append(" INSERT" ).append("\n"); 
		query.append("   INTO FCM_ESTM_WK_CSM_IF" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                BSE_YRMON" ).append("\n"); 
		query.append("              , BSE_WK" ).append("\n"); 
		query.append("              , VSL_CD" ).append("\n"); 
		query.append("              , SKD_VOY_NO" ).append("\n"); 
		query.append("              , SKD_DIR_CD" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , SUB_TRD_CD" ).append("\n"); 
		query.append("              , FCM_ESTM_WRK_DT" ).append("\n"); 
		query.append("              , FCM_ESTM_WRK_SEQ" ).append("\n"); 
		query.append("              , FOIL_ESTM_CSM_WGT" ).append("\n"); 
		query.append("              , DOIL_ESTM_CSM_WGT" ).append("\n"); 
		query.append("              , CRE_USR_ID" ).append("\n"); 
		query.append("              , CRE_DT" ).append("\n"); 
		query.append("              , UPD_USR_ID" ).append("\n"); 
		query.append("              , UPD_DT" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("SELECT DISTINCT A1.SLS_YRMON         AS BSE_YRMON" ).append("\n"); 
		query.append("      , A1.COST_WK                   AS BSE_WK" ).append("\n"); 
		query.append("      , A1.VSL_CD                    AS VSL_CD" ).append("\n"); 
		query.append("      , A1.SKD_VOY_NO                AS SKD_VOY_NO" ).append("\n"); 
		query.append("      , A1.DIR_CD                    AS SKD_DIR_CD" ).append("\n"); 
		query.append("      , A1.TRD_CD                    AS TRD_CD" ).append("\n"); 
		query.append("      , A1.SUB_TRD_CD                AS SUB_TRD_CD" ).append("\n"); 
		query.append("      , TO_CHAR(SYSDATE, 'YYYYMMDD') AS FCM_ESTM_WRK_DT" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("                 SELECT NVL(MAX(FCM_ESTM_WRK_SEQ), 0) + 1" ).append("\n"); 
		query.append("                   FROM FCM_ESTM_WK_CSM_IF" ).append("\n"); 
		query.append("                  WHERE BSE_YRMON       = A1.SLS_YRMON" ).append("\n"); 
		query.append("                    AND BSE_WK          = A1.COST_WK" ).append("\n"); 
		query.append("                    AND VSL_CD          = A1.VSL_CD" ).append("\n"); 
		query.append("                    AND SKD_VOY_NO      = A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND SKD_DIR_CD      = A1.DIR_CD" ).append("\n"); 
		query.append("                    AND TRD_CD          = A1.TRD_CD" ).append("\n"); 
		query.append("                    AND SUB_TRD_CD      = A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                    AND FCM_ESTM_WRK_DT = TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("        )           AS FCM_ESTM_WRK_SEQ" ).append("\n"); 
		query.append("      , NULL        AS FOIL_ESTM_CSM_WGT" ).append("\n"); 
		query.append("      , NULL        AS DOIL_ESTM_CSM_WGT" ).append("\n"); 
		query.append("      , @[cre_usr_id] AS CRE_USR_ID   " ).append("\n"); 
		query.append("      , SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      , @[cre_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("   FROM COA_MON_VVD A1" ).append("\n"); 
		query.append("      , COA_VSL_RGST A2" ).append("\n"); 
		query.append("      , COA_LANE_RGST A3" ).append("\n"); 
		query.append("  WHERE A1.TRD_CD          = A3.TRD_CD" ).append("\n"); 
		query.append("    AND A1.RLANE_CD        = A3.RLANE_CD" ).append("\n"); 
		query.append("    AND A1.IOC_CD          = A3.IOC_CD" ).append("\n"); 
		query.append("    AND A1.DIR_CD          = A3.DIR_CD" ).append("\n"); 
		query.append("    AND A3.TRD_CD         <> 'COM'" ).append("\n"); 
		query.append("    AND A3.VSL_LANE_TP_CD IN ('JO', 'SC')" ).append("\n"); 
		query.append("    AND A1.VSL_CD          = A2.VSL_CD" ).append("\n"); 
		query.append("    AND A1.N1ST_LODG_PORT_ETD_DT BETWEEN A2.VSL_APLY_FM_DT AND A2.VSL_APLY_TO_DT" ).append("\n"); 
		query.append("    AND A2.VOP_CD = 'HJS'" ).append("\n"); 
		query.append("    AND A1.SLS_YRMON LIKE @[cost_yrmon]||'%'" ).append("\n"); 
		query.append("    AND A1.COST_WK    = @[cost_wk]" ).append("\n"); 
		query.append("    AND A1.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("    AND A1.SLAN_CD    = @[slan_cd]" ).append("\n"); 
		query.append("    AND A1.VSL_CD     = @[vsl_cd] " ).append("\n"); 
		query.append("    AND A1.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("    AND A1.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("    AND A1.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("    AND A2.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("    AND A3.DELT_FLG   = 'N'" ).append("\n"); 

	}
}