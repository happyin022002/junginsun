/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchVvdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.31 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchVvdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD combo box 정보를 검색
	  * </pre>
	  */
	public CommonDBDAOSearchVvdInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_repoplan_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_plnyrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_searchword",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOSearchVvdInfoRSQL").append("\n"); 
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
		query.append("DISTINCT VSL_CD||SKD_VOY_NO||SKD_DIR_CD   VVD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_VSL_SKD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SCNR_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("REPO_PLN_ID = @[vvd_repoplan_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND TO_CHAR(VSL_ETD_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("BETWEEN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_ST_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR || PLN_WK =  @[vvd_plnyrwk]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND     (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_END_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR || PLN_WK = @[vvd_plnyrwk]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND VSL_SLAN_CD = @[vvd_searchword]" ).append("\n"); 
		query.append("ORDER BY VVD" ).append("\n"); 

	}
}