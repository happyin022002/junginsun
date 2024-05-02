/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOCheckIdenticalEccRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.24 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOCheckIdenticalEccRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 동일 ECC 조건 확인
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOCheckIdenticalEccRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOCheckIdenticalEccRSQL").append("\n"); 
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
		query.append("COUNT(1) AS CHECKCNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND SCC_CD = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SCC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_LOCATION" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("LOC_CD = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LOC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_YARD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("YD_CD = @[fm_yd_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") A ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND SCC_CD = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SCC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_LOCATION" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("LOC_CD = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LOC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_YARD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("YD_CD = @[to_yd_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.ECC_CD = B.ECC_CD" ).append("\n"); 

	}
}