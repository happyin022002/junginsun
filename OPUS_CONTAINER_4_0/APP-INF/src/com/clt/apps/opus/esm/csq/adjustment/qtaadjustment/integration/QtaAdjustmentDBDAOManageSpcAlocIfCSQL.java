/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : QtaAdjustmentDBDAOManageSpcAlocIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOManageSpcAlocIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC ALOC 정보를 I/F.
	  * 
	  * * 2014.12.26 [CHM-201433310] SPC에서 I/F시 최초 Load를 사후에도 조회할수 있도록 ORG_LOD_QTY 컬럼 추가 
	  * </pre>
	  */
	public QtaAdjustmentDBDAOManageSpcAlocIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOManageSpcAlocIfCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_ALOC_QTA (" ).append("\n"); 
		query.append("         BSE_YR" ).append("\n"); 
		query.append("        ,BSE_MON" ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,VSL_CD" ).append("\n"); 
		query.append("        ,SKD_VOY_NO" ).append("\n"); 
		query.append("        ,SKD_DIR_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,LOD_QTY" ).append("\n"); 
		query.append("        ,ORG_LOD_QTY" ).append("\n"); 
		query.append("        ,CFM_LOD_QTY" ).append("\n"); 
		query.append("        ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT SUBSTR(A2.SLS_YRMON, 1, 4) AS YR" ).append("\n"); 
		query.append("        ,SUBSTR(A2.SLS_YRMON, 5)    AS MON" ).append("\n"); 
		query.append("        ,A2.COST_WK" ).append("\n"); 
		query.append("        ,A1.TRD_CD" ).append("\n"); 
		query.append("        ,A1.RLANE_CD" ).append("\n"); 
		query.append("        ,A2.DIR_CD" ).append("\n"); 
		query.append("        ,A1.VSL_CD" ).append("\n"); 
		query.append("        ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,NVL((SELECT N4TH_PRNT_OFC_CD FROM CSQ_ORGANIZATION_V WHERE OFC_CD =  A1.SLS_RGN_OFC_CD)," ).append("\n"); 
		query.append("             (SELECT RGN_OFC_CD FROM CSQ_QTA_OFC WHERE RGN_OFC_CD = A1.SLS_RGN_OFC_CD)) AS RGN_OFC_CD" ).append("\n"); 
		query.append("        ,A1.SLS_RHQ_CD" ).append("\n"); 
		query.append("        ,SUM(A1.ASGN_TTL_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("		,SUM(A1.ASGN_TTL_QTY) AS ORG_LOD_QTY" ).append("\n"); 
		query.append("		,0 AS CFM_LOD_QTY" ).append("\n"); 
		query.append("        ,SPC_GET_WK_VVD_BSA_FNC('VOL', A1.REP_TRD_CD, A2.RLANE_CD, A2.DIR_CD, SUBSTR(A2.SLS_YRMON,1,4)||A2.COST_WK, A2.VSL_CD||A2.SKD_VOY_NO||A2.DIR_CD) AS BSA_CAPA" ).append("\n"); 
		query.append("        ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE   AS CRE_DT" ).append("\n"); 
		query.append("        ,@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE   AS UPD_DT" ).append("\n"); 
		query.append("    FROM SPC_ALOC_POL_POD A1" ).append("\n"); 
		query.append("        ,COA_MON_VVD      A2" ).append("\n"); 
		query.append("   WHERE A1.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("     AND A1.RLANE_CD     = A2.RLANE_CD" ).append("\n"); 
		query.append("     AND A1.SUB_TRD_CD   = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("     AND A1.VSL_CD       = A2.VSL_CD" ).append("\n"); 
		query.append("     AND A1.SKD_VOY_NO   = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND A1.SKD_DIR_CD   = A2.DIR_CD" ).append("\n"); 
		query.append("     AND A2.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("     AND A1.TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("     AND A1.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("     AND A2.VSL_CD || A2.SKD_VOY_NO || A2.DIR_CD = @[vvd]" ).append("\n"); 
		query.append("     AND A1.SUB_TRD_CD  <> 'IP'" ).append("\n"); 
		query.append("     AND A1.ASGN_TTL_QTY > 0" ).append("\n"); 
		query.append("     AND NOT EXISTS ( SELECT 1" ).append("\n"); 
		query.append("                        FROM CSQ_ALOC_QTA Q" ).append("\n"); 
		query.append("                       WHERE Q.TRD_CD     = A1.TRD_CD" ).append("\n"); 
		query.append("                         AND Q.RLANE_CD   = A1.RLANE_CD" ).append("\n"); 
		query.append("                         AND Q.VSL_CD     = A1.VSL_CD" ).append("\n"); 
		query.append("                         AND Q.SKD_VOY_NO = A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                         AND Q.SKD_DIR_CD = A1.SKD_DIR_CD )" ).append("\n"); 
		query.append("GROUP BY A2.SLS_YRMON" ).append("\n"); 
		query.append("        ,A2.COST_WK" ).append("\n"); 
		query.append("        ,A1.TRD_CD" ).append("\n"); 
		query.append("        ,A1.RLANE_CD" ).append("\n"); 
		query.append("        ,A2.DIR_CD" ).append("\n"); 
		query.append("        ,A1.VSL_CD" ).append("\n"); 
		query.append("        ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,A1.SLS_RHQ_CD" ).append("\n"); 
		query.append("        ,A1.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("        ,SPC_GET_WK_VVD_BSA_FNC('VOL', A1.REP_TRD_CD, A2.RLANE_CD, A2.DIR_CD, SUBSTR(A2.SLS_YRMON,1,4)||A2.COST_WK, A2.VSL_CD||A2.SKD_VOY_NO||A2.DIR_CD)" ).append("\n"); 
		query.append("        ,A1.SUB_TRD_CD" ).append("\n"); 

	}
}