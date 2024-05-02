/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoConstraintDBDAOCreateCnstRuleIDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.17 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepoConstraintDBDAOCreateCnstRuleIDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_scnr_repo_cnst 테이블 에서 const rule id 최대값 생성
	  * </pre>
	  */
	public RepoConstraintDBDAOCreateCnstRuleIDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnstTypeCode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nationCode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.integration").append("\n"); 
		query.append("FileName : RepoConstraintDBDAOCreateCnstRuleIDRSQL").append("\n"); 
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
		query.append("NVL(MAX(TO_NUMBER(SUBSTR(cnst_rule_id,3,4)))+1,1) cnst_rule_id" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_REPO_CNST" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SUBSTR(cnst_rule_id,0,2) = @[nationCode]" ).append("\n"); 
		query.append("AND repo_cnst_tp_cd = @[cnstTypeCode]" ).append("\n"); 
		query.append("AND scnr_id = @[scnrId]" ).append("\n"); 

	}
}