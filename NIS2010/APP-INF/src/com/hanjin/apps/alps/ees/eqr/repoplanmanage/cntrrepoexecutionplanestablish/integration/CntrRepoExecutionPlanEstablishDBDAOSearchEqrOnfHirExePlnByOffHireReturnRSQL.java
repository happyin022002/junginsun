/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchEqrOnfHirExePlnByOffHireReturnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.10.22 정은호
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

public class CntrRepoExecutionPlanEstablishDBDAOSearchEqrOnfHirExePlnByOffHireReturnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS Off Hire 직반납 전 EQR_ONF_HIR_EXE_PLN 조회
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchEqrOnfHirExePlnByOffHireReturnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchEqrOnfHirExePlnByOffHireReturnRSQL").append("\n"); 
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
		query.append("A.REPO_PLN_ID" ).append("\n"); 
		query.append(",	A.PLN_YRWK" ).append("\n"); 
		query.append(",	A.PLN_SEQ" ).append("\n"); 
		query.append(",	A.REF_ID" ).append("\n"); 
		query.append(",	A.CO_CD" ).append("\n"); 
		query.append(",	A.ONF_HIR_DIV_CD" ).append("\n"); 
		query.append(",	A.VNDR_CNT_CD" ).append("\n"); 
		query.append(",	A.VNDR_SEQ" ).append("\n"); 
		query.append(",	A.VNDR_ABBR_NM" ).append("\n"); 
		query.append(",	A.FM_YD_CD" ).append("\n"); 
		query.append(",	A.FM_LOC_DT" ).append("\n"); 
		query.append(",	A.TO_YD_CD" ).append("\n"); 
		query.append(",	A.TO_LOC_DT" ).append("\n"); 
		query.append(",	A.REPO_PLN_FB_RSN_CD" ).append("\n"); 
		query.append(",	A.REPO_PLN_FB_RMK" ).append("\n"); 
		query.append(",	TO_CHAR(A.SO_RQST_DT , 'YYYYMMDDHH24MISS') SO_RQST_DT" ).append("\n"); 
		query.append(",	A.SO_ISS_FLG" ).append("\n"); 
		query.append(",	A.NON_SO_ISS_FLG" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM(CNTR_QTY)" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ONF_HIR_EXE_PLN_QTY Q" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.REPO_PLN_ID 	= Q.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.PLN_YRWK 	= Q.PLN_YRWK" ).append("\n"); 
		query.append("AND A.PLN_SEQ	= Q.PLN_SEQ" ).append("\n"); 
		query.append("AND A.REF_ID	= Q.REF_ID" ).append("\n"); 
		query.append(") ALL_TPSZ_VOL" ).append("\n"); 
		query.append("FROM EQR_ONF_HIR_EXE_PLN A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND	A.PLN_YRWK = @[pln_yrwk]" ).append("\n"); 
		query.append("AND	A.REF_ID = @[ref_id]" ).append("\n"); 

	}
}