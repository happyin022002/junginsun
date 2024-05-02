/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodSimulateDBDAOSearchCODVskDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.10.19 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodSimulateDBDAOSearchCODVskDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_VSL_SKD 에서 특정 vvd의 VSL_LOC_CD, VSL_ETD_DT 를 검색
	  * </pre>
	  */
	public CodSimulateDBDAOSearchCODVskDataRSQL(){
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.integration").append("\n"); 
		query.append("FileName : CodSimulateDBDAOSearchCODVskDataRSQL").append("\n"); 
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
		query.append("SELECT VSL_LOC_CD" ).append("\n"); 
		query.append(",TO_CHAR(VSL_ETD_DT,'YYYY-MM-DD HH24:MI:SS' ,'NLS_DATE_LANGUAGE=AMERICAN')  VSL_ETD_DT" ).append("\n"); 
		query.append("-- CSR NO : N200903060090 의거 변경" ).append("\n"); 
		query.append(",TO_CHAR(VSL_ETB_DT,'YYYY-MM-DD HH24:MI:SS','NLS_DATE_LANGUAGE=AMERICAN')  VSL_ETB_DT" ).append("\n"); 
		query.append(",YD_CD" ).append("\n"); 
		query.append(",ROWNUM" ).append("\n"); 
		query.append("FROM EQR_SCNR_VSL_SKD" ).append("\n"); 
		query.append("WHERE SCNR_ID	 = ( SELECT SCNR_ID FROM EQR_EQ_REPO_PLN WHERE REPO_PLN_ID = @[repo_pln_id])" ).append("\n"); 
		query.append("AND VSL_CD 		= @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO 	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD 	= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND VSL_SLAN_CD 	= @[vsl_lane_cd]" ).append("\n"); 
		query.append("#if (${vsl_loc_cd} != '')" ).append("\n"); 
		query.append("AND VSL_LOC_CD  = @[vsl_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${poscol} == 'fm')" ).append("\n"); 
		query.append("AND TO_CHAR(VSL_ETD_DT ,'YYYYMMDD') >= (SELECT WK_ST_DT FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[pln_yrwk] )" ).append("\n"); 
		query.append("ORDER BY  VSL_ETD_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND TO_CHAR(VSL_ETB_DT ,'YYYYMMDD') >= TO_CHAR(TO_DATE( @[pln_yrwk],'YYYY-MM-DD') ,'YYYYMMDD')" ).append("\n"); 
		query.append("ORDER BY  VSL_ETB_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}