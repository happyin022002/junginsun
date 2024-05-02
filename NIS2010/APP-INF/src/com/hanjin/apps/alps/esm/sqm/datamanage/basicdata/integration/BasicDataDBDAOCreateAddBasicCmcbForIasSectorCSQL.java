/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BasicDataDBDAOCreateAddBasicCmcbForIasSectorCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOCreateAddBasicCmcbForIasSectorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Add Creation 하는 노선의 Pair에 대하여 Basic CMCB]을 생성합니다.
	  * </pre>
	  */
	public BasicDataDBDAOCreateAddBasicCmcbForIasSectorCSQL(){
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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOCreateAddBasicCmcbForIasSectorCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SCTR_PAIR_COST" ).append("\n"); 
		query.append("           (BSE_TP_CD" ).append("\n"); 
		query.append("           ,BSE_YR" ).append("\n"); 
		query.append("           ,BSE_QTR_CD" ).append("\n"); 
		query.append("           ,RLANE_CD" ).append("\n"); 
		query.append("           ,DIR_CD" ).append("\n"); 
		query.append("           ,POL_CD" ).append("\n"); 
		query.append("           ,POD_CD" ).append("\n"); 
		query.append("           ,TRD_CD" ).append("\n"); 
		query.append("           ,SUB_TRD_CD" ).append("\n"); 
		query.append("           ,GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("           ,GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("           ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("           ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("           ,ADD_FLG" ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,UPD_DT" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(NVL(A2.LOD_QTY,0)), 0, 0, SUM(NVL(A2.PA_CM_UC_AMT,0))/SUM(NVL(A2.LOD_QTY,0)))) AS GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(NVL(A2.LOD_QTY,0)), 0, 0, SUM(NVL(A2.RA_CM_UC_AMT,0))/SUM(NVL(A2.LOD_QTY,0)))) AS GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(NVL(A2.LOD_QTY,0)), 0, 0, SUM(NVL(A2.PA_CM_UC_AMT,0))/SUM(NVL(A2.LOD_QTY,0)))) AS PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(NVL(A2.LOD_QTY,0)), 0, 0, SUM(NVL(A2.RA_CM_UC_AMT,0))/SUM(NVL(A2.LOD_QTY,0)))) AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,'Y' AS ADD_FLG" ).append("\n"); 
		query.append("      ,@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("      ,@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT " ).append("\n"); 
		query.append("               BSE_TP_CD" ).append("\n"); 
		query.append("              ,BSE_YR" ).append("\n"); 
		query.append("              ,BSE_QTR_CD" ).append("\n"); 
		query.append("              ,RLANE_CD" ).append("\n"); 
		query.append("              ,DIR_CD" ).append("\n"); 
		query.append("              ,POL_CD" ).append("\n"); 
		query.append("              ,POD_CD" ).append("\n"); 
		query.append("              ,TRD_CD" ).append("\n"); 
		query.append("              ,SUB_TRD_CD" ).append("\n"); 
		query.append("          FROM SQM_SCTR_PAIR_MGMT" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("         AND BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("         AND BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("         AND BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("         AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("         AND DIR_CD     = NVL(@[dir_cd],DIR_CD)" ).append("\n"); 
		query.append("       )A1" ).append("\n"); 
		query.append("      ,SQM_SCTR_PERF_IF A2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = A2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = A2.BSE_YR(+)" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = A2.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD    = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND A1.DIR_CD      = A2.DIR_CD(+)" ).append("\n"); 
		query.append("   AND A1.POL_CD      = A2.POL_CD(+)" ).append("\n"); 
		query.append("   AND A1.POD_CD      = A2.POD_CD(+)" ).append("\n"); 
		query.append("   AND A2.OFC_VW_CD(+)   = 'L'" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 'X' FROM SQM_SCTR_PAIR_COST A3" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                   AND A1.BSE_TP_CD   = A3.BSE_TP_CD" ).append("\n"); 
		query.append("                   AND A1.BSE_YR      = A3.BSE_YR" ).append("\n"); 
		query.append("                   AND A1.BSE_QTR_CD  = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("                   AND A1.TRD_CD      = A3.TRD_CD" ).append("\n"); 
		query.append("                   AND A1.SUB_TRD_CD  = A3.SUB_TRD_CD" ).append("\n"); 
		query.append("                   AND A1.RLANE_CD    = A3.RLANE_CD" ).append("\n"); 
		query.append("                   AND A1.DIR_CD      = A3.DIR_CD" ).append("\n"); 
		query.append("                   AND A1.POL_CD      = A3.POL_CD" ).append("\n"); 
		query.append("                   AND A1.POD_CD      = A3.POD_CD)" ).append("\n"); 
		query.append(" GROUP BY A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 

	}
}