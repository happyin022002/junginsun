/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchCheckCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.21 정은호
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

public class CntrRepoExecutionPlanEstablishDBDAOSearchCheckCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNTR_NO 중복체크.
	  * cntr 관리를 NIS에서 하므로 eqr_exe_pln_cntr를 BKG_creation 시점에 delete 하기로 함. 
	  * 따라서, 해당 repo_pln_id에 중복되는 cntr_no를 체크하기 위해 해당 repo_pln_id로 생성된 BKG_CNTR을 다 체크함. 
	  * execution시 생성되는 table , HJS BKG Creation시 생성되는 table, SEN BKG Creation시 생성되는 table 
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchCheckCntrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repoplan_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchCheckCntrInfoRSQL").append("\n"); 
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
		query.append("CNTR_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_EXE_PLN_CNTR" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("REPO_PLN_ID = @[repoplan_id]" ).append("\n"); 
		query.append("#if(${cntr_no} != '')" ).append("\n"); 
		query.append("AND CNTR_NO IN ( ${arrStrCntrNo} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT CNTR_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING BK" ).append("\n"); 
		query.append(", BKG_CONTAINER BC , --BKG_BKG_CNTR BC," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT MTY_BKG_NO" ).append("\n"); 
		query.append("--, MTY_BKG_NO_SPLIT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_VSL_LODG_DCHG_EXE_PLN" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID = @[repoplan_id]" ).append("\n"); 
		query.append(") EP" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("--AND BK.BKG_NO_SPLIT = BK.BKG_NO_SPLIT" ).append("\n"); 
		query.append("AND BC.BKG_NO = EP.MTY_BKG_NO" ).append("\n"); 
		query.append("--AND BC.BKG_NO_SPLIT = EP.MTY_BKG_NO_SPLIT" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("AND BK.BKG_CGO_TP_CD ='P'" ).append("\n"); 
		query.append("#if(${cntr_no} != '')" ).append("\n"); 
		query.append("AND CNTR_NO IN ( ${arrStrCntrNo} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT CNTR_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SEN_MTY_BKG BK" ).append("\n"); 
		query.append(", EQR_SEN_MTY_BKG_CNTR BC" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT MTY_BKG_NO" ).append("\n"); 
		query.append("--, MTY_BKG_NO_SPLIT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_VSL_LODG_DCHG_EXE_PLN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("REPO_PLN_ID = @[repoplan_id]" ).append("\n"); 
		query.append(") EP" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("--AND BK.BKG_NO_SPLIT = BK.BKG_NO_SPLIT" ).append("\n"); 
		query.append("AND BC.BKG_NO = EP.MTY_BKG_NO" ).append("\n"); 
		query.append("--AND BC.BKG_NO_SPLIT = EP.MTY_BKG_NO_SPLIT" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("AND BK.BKG_CGO_TP_CD ='P'" ).append("\n"); 
		query.append("#if(${cntr_no} != '')" ).append("\n"); 
		query.append("AND CNTR_NO IN ( ${arrStrCntrNo} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}