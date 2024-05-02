/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedEqrRepoExeSoIfUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedEqrRepoExeSoIfUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_REPO_EXE_SO_IF UPDATE
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedEqrRepoExeSoIfUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedEqrRepoExeSoIfUSQL").append("\n"); 
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
		query.append("UPDATE EQR_REPO_EXE_SO_IF" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("#if (${wo_cxl_flg} == 'N') " ).append("\n"); 
		query.append("      WO_EXE_FLG 		= 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	  WO_EXE_FLG 		= 'N'" ).append("\n"); 
		query.append("	, TRSP_SO_STS_CD 	= 'C'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , WO_EXE_DT 		= TO_CHAR(SYSDATE, 'YYYYMMDD') " ).append("\n"); 
		query.append("    , REPO_COST_AMT 	= @[repo_cost_amt]" ).append("\n"); 
		query.append("	, UPD_DT			= SYSDATE" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("  AND PLN_YRWK = @[pln_yrwk]" ).append("\n"); 
		query.append("  AND REF_ID = @[ref_id]" ).append("\n"); 
		query.append("  AND REF_SEQ = @[ref_seq]" ).append("\n"); 

	}
}