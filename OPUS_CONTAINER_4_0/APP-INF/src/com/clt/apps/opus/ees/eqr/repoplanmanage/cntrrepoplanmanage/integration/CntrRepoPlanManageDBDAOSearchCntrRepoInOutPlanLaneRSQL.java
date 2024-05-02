/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanManageDBDAOSearchCntrRepoInOutPlanLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanManageDBDAOSearchCntrRepoInOutPlanLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0052 최적화된 REPO InOut 계획 수량 조회/수정>
	  * EQR_SCNR_VSL_SKD 테이블에서 특정 LANE 의 VVD 정보 조회
	  * 
	  * <Change History>
	  * 1	2009.08.26	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrRepoPlanManageDBDAOSearchCntrRepoInOutPlanLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanManageDBDAOSearchCntrRepoInOutPlanLaneRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_VSL_SKD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID = ( SELECT SCNR_ID FROM EQR_EQ_REPO_PLN WHERE REPO_PLN_ID = @[repo_id])" ).append("\n"); 
		query.append("AND TO_CHAR(VSL_ETD_DT,'YYYYMMDD') BETWEEN (SELECT WK_ST_DT FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK =  @[vvd_yrwk] )" ).append("\n"); 
		query.append("AND (SELECT WK_END_DT  FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[vvd_yrwk] )" ).append("\n"); 
		query.append("AND VSL_SLAN_CD 	= @[vsl_lane_cd]" ).append("\n"); 
		query.append("ORDER BY VVD" ).append("\n"); 

	}
}