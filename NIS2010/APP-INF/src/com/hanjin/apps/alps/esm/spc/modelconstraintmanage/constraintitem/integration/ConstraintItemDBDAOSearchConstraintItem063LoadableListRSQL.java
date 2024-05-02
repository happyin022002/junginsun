/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ConstraintItemDBDAOSearchConstraintItem063LoadableListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.11.26 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintItemDBDAOSearchConstraintItem063LoadableListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Loadable Weight 조회
	  * 
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * </pre>
	  */
	public ConstraintItemDBDAOSearchConstraintItem063LoadableListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.integration").append("\n"); 
		query.append("FileName : ConstraintItemDBDAOSearchConstraintItem063LoadableListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("         SPC_GET_REP_TRD_FNC (M.RLANE_CD)                          AS REP_TRD_CD       ," ).append("\n"); 
		query.append("         SPC_GET_REP_SUB_TRD_FNC(M.RLANE_CD)                       AS REP_SUB_TRD_CD   ," ).append("\n"); 
		query.append("         M.RLANE_CD                                                AS RLANE_CD         ," ).append("\n"); 
		query.append("         SUBSTR(M.SLS_YRMON, 1, 4)||'/'||SUBSTR(M.SLS_YRMON, 5, 2) AS COST_YRMON       ," ).append("\n"); 
		query.append("         A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD                      AS VVD              ," ).append("\n"); 
		query.append("         0                                                         AS VSL_PORT_DRFT_WGT," ).append("\n"); 
		query.append("         TO_CHAR(A.PF_ETD_DT, 'YYYY-MM-DD HH24:MI')                AS PF_ETD_DT" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("         MAS_MON_VVD      M" ).append("\n"); 
		query.append("   WHERE A.VSL_CD      = M.VSL_CD" ).append("\n"); 
		query.append("     AND A.SKD_VOY_NO  = M.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD  = M.DIR_CD" ).append("\n"); 
		query.append("     AND A.VPS_PORT_CD = 'CNSHA'" ).append("\n"); 
		query.append("     AND M.SLS_YRMON BETWEEN @[year1]||@[week1] AND @[year2]||@[week2]" ).append("\n"); 
		query.append("#if (${trade} != '') " ).append("\n"); 
		query.append("     AND SPC_GET_REP_TRD_FNC (M.RLANE_CD) = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${subtrade} != '') " ).append("\n"); 
		query.append("     AND SPC_GET_REP_SUB_TRD_FNC(M.RLANE_CD) = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lane} != '') " ).append("\n"); 
		query.append("     AND M.RLANE_CD = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '') " ).append("\n"); 
		query.append("     AND M.DIR_CD = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SPC_GET_REP_TRD_FNC(M.RLANE_CD)    ," ).append("\n"); 
		query.append("         SPC_GET_REP_SUB_TRD_FNC(M.RLANE_CD)," ).append("\n"); 
		query.append("         M.RLANE_CD," ).append("\n"); 
		query.append("         SUBSTR(M.SLS_YRMON, 1, 4)||'/'||SUBSTR(M.SLS_YRMON, 5, 2)," ).append("\n"); 
		query.append("         A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD" ).append("\n"); 

	}
}
