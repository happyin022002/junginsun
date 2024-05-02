/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanningDBDAOCreateQtaLoadRevForSectorAddTargetVVDCSQL.java
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

public class PlanningDBDAOCreateQtaLoadRevForSectorAddTargetVVDCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Creation 시 확정데이터가 있을 경우
	  * 해당 시점의 선택된 노선의 PF Group에 대한 COA Target VVD 정보를 Fix한다.
	  * </pre>
	  */
	public PlanningDBDAOCreateQtaLoadRevForSectorAddTargetVVDCSQL(){
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
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOCreateQtaLoadRevForSectorAddTargetVVDCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_SCTR_ADD_TGT_VVD(BSE_TP_CD, BSE_YR, BSE_QTR_CD, TRD_CD, RLANE_CD, PF_GRP_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BSE_MON, BSE_WK, SUB_TRD_CD, IOC_CD, GRP_BSA_CAPA, FNL_BSA_CAPA, PF_SVC_TP_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       @[bse_tp_cd] " ).append("\n"); 
		query.append("      ,@[bse_yr] " ).append("\n"); 
		query.append("      ,@[bse_qtr_cd]" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A4.PF_GRP_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,SUBSTR(A1.SLS_YRMON,5,6) BSE_MON" ).append("\n"); 
		query.append("      ,A1.COST_WK" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.IOC_CD" ).append("\n"); 
		query.append("      ,0 AS GRP_BSA_CAPA" ).append("\n"); 
		query.append("      ,ROUND(NVL(A2.FNL_CO_BSA_CAPA,0)) FNL_CO_BSA_CAPA" ).append("\n"); 
		query.append("      ,A3.PF_SKD_TP_CD" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("  FROM COA_MON_VVD A1" ).append("\n"); 
		query.append("      ,BSA_VVD_MST A2" ).append("\n"); 
		query.append("      ,VSK_VSL_SKD A3" ).append("\n"); 
		query.append("      ,CSQ_SCTR_PF_GRP A4" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("   AND SUBSTR(A1.SLS_YRMON,0,4) = @[bse_yr]" ).append("\n"); 
		query.append("   AND A1.COST_WK      BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = NVL(@[dir_cd], A1.DIR_CD)  " ).append("\n"); 
		query.append("   AND A1.TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = A4.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = A4.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = A2.TRD_CD(+)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND A1.VSL_CD       = A2.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO   = A2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = A2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.VSL_CD       = A3.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO   = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = A3.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A1.SLAN_CD      = A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("   AND A4.BSE_TP_CD    = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND A4.BSE_YR       = @[bse_yr]" ).append("\n"); 
		query.append("   AND A4.BSE_QTR_CD   = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A4.PF_SVC_TP_CD = A3.PF_SKD_TP_CD" ).append("\n"); 
		query.append("   AND A4.PF_GRP_CD    = @[pf_grp_cd]" ).append("\n"); 
		query.append("   AND A1.DELT_FLG     = 'N'" ).append("\n"); 

	}
}