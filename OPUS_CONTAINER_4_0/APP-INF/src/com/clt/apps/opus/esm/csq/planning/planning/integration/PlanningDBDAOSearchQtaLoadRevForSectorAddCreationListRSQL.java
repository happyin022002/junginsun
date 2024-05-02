/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanningDBDAOSearchQtaLoadRevForSectorAddCreationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17 
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

public class PlanningDBDAOSearchQtaLoadRevForSectorAddCreationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Add Creation List] 를 [조회]한다.
	  * </pre>
	  */
	public PlanningDBDAOSearchQtaLoadRevForSectorAddCreationListRSQL(){
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
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchQtaLoadRevForSectorAddCreationListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT -- COA 테이블에 DIRECTION 이 있어 중복된 데이터가 조회되는 것을 막기 위해" ).append("\n"); 
		query.append("       B1.TRD_CD" ).append("\n"); 
		query.append("      ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,B1.RLANE_CD" ).append("\n"); 
		query.append("      ,B1.PF_GRP_CD" ).append("\n"); 
		query.append("      ,B1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("      ,B1.PF_ROUT_DESC" ).append("\n"); 
		query.append("      ,B1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,B1.BSE_YR" ).append("\n"); 
		query.append("      ,B1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,'' AS IB_FLAG" ).append("\n"); 
		query.append("      ,'' AS USR_ID" ).append("\n"); 
		query.append("      ,DECODE(COUNT(*) OVER(PARTITION BY B1.TRD_CD, B1.RLANE_CD, B1.PF_GRP_CD, B1.PF_SVC_TP_CD), 2, B3.LANE_DIR_CD, B2.DIR_CD) AS DIR_CD" ).append("\n"); 
		query.append("  FROM CSQ_SCTR_PF_GRP B1" ).append("\n"); 
		query.append("      ,COA_LANE_RGST B2" ).append("\n"); 
		query.append("      ,CSQ_QTA_LANE_MGMT B3" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND B1.TRD_CD     = B2.TRD_CD" ).append("\n"); 
		query.append("   AND B1.RLANE_CD   = B2.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND B1.BSE_TP_CD    = B3.BSE_TP_CD" ).append("\n"); 
		query.append("   AND B1.BSE_YR       = B3.BSE_YR " ).append("\n"); 
		query.append("   AND B1.BSE_QTR_CD   = B3.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND B1.TRD_CD       = B3.TRD_CD" ).append("\n"); 
		query.append("   AND B1.RLANE_CD     = B3.RLANE_CD" ).append("\n"); 
		query.append("   AND B1.SUB_TRD_CD   = B3.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND B2.DIR_CD       = NVL(B3.LANE_DIR_CD, B2.DIR_CD)" ).append("\n"); 
		query.append("   AND B3.CSQ_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append("   AND B3.IAS_SCTR_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND B1.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND B1.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND B1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND B1.RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND B1.SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND NOT EXISTS (" ).append("\n"); 
		query.append("                    SELECT 1" ).append("\n"); 
		query.append("                      FROM CSQ_SCTR_LOD_REV A1" ).append("\n"); 
		query.append("                     WHERE A1.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                       AND A1.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                       AND A1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                       AND A1.RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("                       AND A1.BSE_TP_CD  = B1.BSE_TP_CD" ).append("\n"); 
		query.append("                       AND A1.BSE_YR     = B1.BSE_YR" ).append("\n"); 
		query.append("                       AND A1.BSE_QTR_CD = B1.BSE_QTR_CD" ).append("\n"); 
		query.append("                       AND A1.TRD_CD     = B1.TRD_CD" ).append("\n"); 
		query.append("                       AND A1.RLANE_CD   = B1.RLANE_CD" ).append("\n"); 
		query.append("                       AND A1.PF_GRP_CD  = B1.PF_GRP_CD" ).append("\n"); 
		query.append("                       AND A1.DIR_CD     = B2.DIR_CD" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append(" ORDER BY B1.RLANE_CD, B1.PF_GRP_CD, B1.PF_SVC_TP_CD" ).append("\n"); 

	}
}