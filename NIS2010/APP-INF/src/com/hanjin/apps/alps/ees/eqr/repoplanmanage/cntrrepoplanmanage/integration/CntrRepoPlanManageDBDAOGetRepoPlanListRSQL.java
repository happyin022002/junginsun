/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanManageDBDAOGetRepoPlanListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanManageDBDAOGetRepoPlanListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0045 컨테이너 이송 계획 목록 조회>
	  * Repo Plan Id 정보 조회
	  * 
	  * <Change History>
	  * 1	2009.08.17	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrRepoPlanManageDBDAOGetRepoPlanListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repoEYearWeek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repoSYearWeek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanManageDBDAOGetRepoPlanListRSQL").append("\n"); 
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
		query.append("SUBSTR(REPO_PLN_ID,5,4)||'-'||SUBSTR(REPO_PLN_ID,9,2) WEEK," ).append("\n"); 
		query.append("REPO_PLN_ID," ).append("\n"); 
		query.append("REPO_PLN_RMK," ).append("\n"); 
		query.append("DECODE (UPD_DT, NULL, CRE_USR_ID, UPD_USR_ID) USRID," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT,'yyyy-mm-dd')||' '||TO_CHAR(UPD_DT,'HH24:MI')UPD_DT," ).append("\n"); 
		query.append("TO_CHAR(CRE_DT,'yyyy-mm-dd')||' '||TO_CHAR(CRE_DT,'HH24:MI')CRE_DT," ).append("\n"); 
		query.append("DECODE (REPO_PLN_DTRB_FLG, 'Y', 0, 1) REPO_PLN_DTRB_FLG," ).append("\n"); 
		query.append("DECODE (REPO_PLN_AUTO_GEN_FLG, 'Y', 0, 1) AUTO," ).append("\n"); 
		query.append("DECODE (REPO_PLN_AUTO_GEN_FLG, 'N', 0, 1) MANUAL," ).append("\n"); 
		query.append("SCNR_ID" ).append("\n"); 
		query.append("FROM EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${repoWeek} != '')" ).append("\n"); 
		query.append("AND REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scnrWeek} != '')" ).append("\n"); 
		query.append("AND SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${repoSYearWeek} != '')" ).append("\n"); 
		query.append("AND SUBSTR (REPO_PLN_ID, 5, 6) BETWEEN @[repoSYearWeek] AND @[repoEYearWeek]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${status} == 'D')" ).append("\n"); 
		query.append("AND REPO_PLN_DTRB_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${status} == 'A')" ).append("\n"); 
		query.append("AND REPO_PLN_AUTO_GEN_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${status} == 'M')" ).append("\n"); 
		query.append("AND REPO_PLN_AUTO_GEN_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '')" ).append("\n"); 
		query.append("AND CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY WEEK, REPO_PLN_ID" ).append("\n"); 

	}
}