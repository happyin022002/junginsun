/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanningDBDAORemoveQtaLoadRevForSectorAddFreezingDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAORemoveQtaLoadRevForSectorAddFreezingDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add-freezing시 CSQ_SCTR_CFM_QTA 삭제
	  * </pre>
	  */
	public PlanningDBDAORemoveQtaLoadRevForSectorAddFreezingDSQL(){
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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAORemoveQtaLoadRevForSectorAddFreezingDSQL").append("\n"); 
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
		query.append("DELETE " ).append("\n"); 
		query.append("FROM CSQ_SCTR_CFM_QTA " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND QTA_RLSE_VER_NO LIKE '%02'" ).append("\n"); 
		query.append("AND (BSE_TP_CD, BSE_YR, BSE_QTR_CD, TRD_CD, RLANE_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD ) " ).append("\n"); 
		query.append("IN (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("          A1.BSE_TP_CD" ).append("\n"); 
		query.append("          ,A1.BSE_YR" ).append("\n"); 
		query.append("          ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("          ,A1.TRD_CD" ).append("\n"); 
		query.append("          ,A1.RLANE_CD" ).append("\n"); 
		query.append("          ,A1.DIR_CD" ).append("\n"); 
		query.append("          ,A1.VSL_CD" ).append("\n"); 
		query.append("          ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      FROM CSQ_SCTR_ADD_TGT_VVD A1" ).append("\n"); 
		query.append("          ,CSQ_QTA_LANE_MGMT A2" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A1.BSE_TP_CD  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("       AND A1.BSE_YR     = A2.BSE_YR " ).append("\n"); 
		query.append("       AND A1.BSE_QTR_CD = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND A1.TRD_CD     = A2.TRD_CD" ).append("\n"); 
		query.append("       AND A1.RLANE_CD   = A2.RLANE_CD" ).append("\n"); 
		query.append("       AND A1.DIR_CD     = NVL(A2.LANE_DIR_CD, A1.DIR_CD)" ).append("\n"); 
		query.append("       AND A2.IAS_SCTR_FLG = 'Y'" ).append("\n"); 
		query.append("       AND A1.BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("       AND A1.BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("       AND A1.BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("       AND A1.TRD_CD  	 = @[trd_cd]" ).append("\n"); 
		query.append("       AND A1.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("       AND A1.PF_GRP_CD  = @[pf_grp_cd]" ).append("\n"); 
		query.append("       AND A1.DIR_CD     = NVL(@[dir_cd], A1.DIR_CD)" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}