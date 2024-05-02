/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CostManageDBDAOCreateNewLaneOfficeCmcbCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.07
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.10.07 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOCreateNewLaneOfficeCmcbCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NewLane Offce에 CMCB정보를 생성한다.
	  * </pre>
	  */
	public CostManageDBDAOCreateNewLaneOfficeCmcbCSQL(){
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOCreateNewLaneOfficeCmcbCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_QTA_NEW_LANE_OFC_COST (" ).append("\n"); 
		query.append("     BSE_TP_CD" ).append("\n"); 
		query.append("    ,BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,OFC_VW_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,RGN_OFC_CD" ).append("\n"); 
		query.append("    ,RHQ_CD" ).append("\n"); 
		query.append("    ,GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("    ,GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("    ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("    ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT   " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("SELECT OFC.BSE_TP_CD" ).append("\n"); 
		query.append("      ,OFC.BSE_YR" ).append("\n"); 
		query.append("      ,OFC.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,OFC.OFC_VW_CD" ).append("\n"); 
		query.append("      ,OFC.TRD_CD" ).append("\n"); 
		query.append("      ,OFC.RLANE_CD" ).append("\n"); 
		query.append("      ,OFC.DIR_CD" ).append("\n"); 
		query.append("      ,OFC.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,OFC.RHQ_CD" ).append("\n"); 
		query.append("      ,NVL(PER.PA_CM_UC_AMT,0)" ).append("\n"); 
		query.append("      ,NVL(PER.RA_CM_UC_AMT,0)" ).append("\n"); 
		query.append("      ,NVL(PER.PA_CM_UC_AMT,0)" ).append("\n"); 
		query.append("      ,NVL(PER.RA_CM_UC_AMT,0)" ).append("\n"); 
		query.append("	  ,@[cre_usr_id]" ).append("\n"); 
		query.append("	  ,SYSDATE" ).append("\n"); 
		query.append("	  ,@[upd_usr_id]" ).append("\n"); 
		query.append("	  ,SYSDATE " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT OFC.BSE_TP_CD " ).append("\n"); 
		query.append("              ,OFC.BSE_YR " ).append("\n"); 
		query.append("              ,OFC.BSE_QTR_CD " ).append("\n"); 
		query.append("              ,OFC.OFC_VW_CD" ).append("\n"); 
		query.append("              ,OFC.TRD_CD " ).append("\n"); 
		query.append("              ,OFC.RLANE_CD " ).append("\n"); 
		query.append("              ,OFC.DIR_CD " ).append("\n"); 
		query.append("              ,OFC.RGN_OFC_CD " ).append("\n"); 
		query.append("              ,OFC.RHQ_CD " ).append("\n"); 
		query.append("              ,NL.SRC_TRD_CD " ).append("\n"); 
		query.append("              ,NL.SRC_RLANE_CD " ).append("\n"); 
		query.append("              ,NL.SRC_DIR_CD " ).append("\n"); 
		query.append("          FROM CSQ_QTA_NEW_LANE NL" ).append("\n"); 
		query.append("              ,CSQ_QTA_LANE_OFC OFC" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND NL.BSE_TP_CD    = @[bse_tp_cd]" ).append("\n"); 
		query.append("           AND NL.BSE_YR       = @[bse_yr]" ).append("\n"); 
		query.append("           AND NL.BSE_QTR_CD   = DECODE(@[bse_tp_cd],'Y','00',@[bse_qtr_cd])" ).append("\n"); 
		query.append("           AND NL.TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("           AND NL.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("           AND NL.DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("           AND NL.BSE_TP_CD    = OFC.BSE_TP_CD" ).append("\n"); 
		query.append("           AND NL.BSE_YR       = OFC.BSE_YR" ).append("\n"); 
		query.append("           AND NL.BSE_QTR_CD   = OFC.BSE_QTR_CD" ).append("\n"); 
		query.append("           AND NL.TRD_CD       = OFC.TRD_CD" ).append("\n"); 
		query.append("           AND NL.DIR_CD       = OFC.DIR_CD" ).append("\n"); 
		query.append("           AND NL.RLANE_CD     = OFC.RLANE_CD" ).append("\n"); 
		query.append("       ) OFC" ).append("\n"); 
		query.append("      ,CSQ_PERF_IF PER" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND OFC.BSE_TP_CD     = PER.BSE_TP_CD(+)" ).append("\n"); 
		query.append("   AND OFC.BSE_YR        = PER.BSE_YR(+)" ).append("\n"); 
		query.append("   AND OFC.BSE_QTR_CD    = PER.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("   AND OFC.OFC_VW_CD     = PER.OFC_VW_CD(+)" ).append("\n"); 
		query.append("   AND OFC.SRC_TRD_CD    = PER.TRD_CD(+)" ).append("\n"); 
		query.append("   AND OFC.SRC_RLANE_CD  = PER.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND OFC.SRC_DIR_CD    = PER.DIR_CD(+)" ).append("\n"); 
		query.append("   AND OFC.RHQ_CD        = PER.RHQ_CD(+)" ).append("\n"); 
		query.append("   AND OFC.RGN_OFC_CD    = PER.RGN_OFC_CD(+)" ).append("\n"); 
		query.append("   AND PER.QTA_TGT_CD(+) = 'D'" ).append("\n"); 
		query.append("   AND PER.CSQ_LVL_CD(+) = '2'" ).append("\n"); 

	}
}