/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchTrunkVesselAndFeederCntrRepoPlanBKGNORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.03.18 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang HO Chae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOSearchTrunkVesselAndFeederCntrRepoPlanBKGNORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PAST PLAN SPLIT BOOKING NO 조회
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchTrunkVesselAndFeederCntrRepoPlanBKGNORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_fromecc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("currentWeek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prevWeek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchTrunkVesselAndFeederCntrRepoPlanBKGNORSQL").append("\n"); 
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
		query.append("-- Bkg No." ).append("\n"); 
		query.append("SELECT	DISTINCT BKG_NO" ).append("\n"); 
		query.append("FROM	BKG_BOOKING" ).append("\n"); 
		query.append("WHERE	BKG_NO IN (" ).append("\n"); 
		query.append("					SELECT	DISTINCT A.MTY_BKG_NO" ).append("\n"); 
		query.append("					FROM	EQR_VSL_LODG_DCHG_EXE_PLN A" ).append("\n"); 
		query.append("					-- 현재주 포함해서 7주 과거 (repo plan id)" ).append("\n"); 
		query.append("					WHERE	SUBSTR(A.REPO_PLN_ID, 5, 6) BETWEEN @[prevWeek] AND @[currentWeek]" ).append("\n"); 
		query.append("						AND	A.VSL_LANE_CD = @[search_lane]" ).append("\n"); 
		query.append("						AND	A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD = @[search_vvd]" ).append("\n"); 
		query.append("						AND	SUBSTR(A.FM_YD_CD, 0, 5) IN (" ).append("\n"); 
		query.append("														SELECT	SCC_CD" ).append("\n"); 
		query.append("														FROM	MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                                                        WHERE	ECC_CD	= @[search_fromecc]" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("						AND	A.REPO_MTY_BKG_FLG = 'Y'" ).append("\n"); 
		query.append("						AND	A.MTY_BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("						AND	A.SPLIT_REPO_PLN_FLG = 'N'" ).append("\n"); 
		query.append("					)" ).append("\n"); 

	}
}