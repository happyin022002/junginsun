/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoConstraintDBDAOSearchEmptyRepoConstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.06 정은호
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

public class RepoConstraintDBDAOSearchEmptyRepoConstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_scnr_repo_cnst 테이블 데이터 조회
	  * </pre>
	  */
	public RepoConstraintDBDAOSearchEmptyRepoConstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cnsttype",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.integration").append("\n"); 
		query.append("FileName : RepoConstraintDBDAOSearchEmptyRepoConstRSQL").append("\n"); 
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
		query.append("MAX(REPO_CNST_SEQ) REPO_CNST_SEQ" ).append("\n"); 
		query.append(", MAX(CNST_RULE_ID)	 CNST_RULE_ID" ).append("\n"); 
		query.append(", MAX(REPO_CNST_TP_CD) REPO_CNST_TP_CD" ).append("\n"); 
		query.append(", CASE WHEN MAX(RULE_EXPT_FLG) = 'Y' THEN 'EXCEPTION'  ELSE MAX(CNST_RULE_ID) END AS CNST_RULE_ID_2" ).append("\n"); 
		query.append(", MAX(REPO_CNST_DIR_CD) REPO_CNST_DIR_CD" ).append("\n"); 
		query.append(", CASE WHEN MAX(FM_LOC_GRP_CD) = 'N' THEN ''  ELSE MAX(FM_LOC_GRP_CD) END AS FM_LOC_GRP_CD" ).append("\n"); 
		query.append(", CASE WHEN MAX(FM_LOC_CD) = 'N/A' THEN ''  ELSE MAX(FM_LOC_CD) END AS FM_LOC_CD" ).append("\n"); 
		query.append(", CASE WHEN MAX(TO_LOC_GRP_CD) = 'N' THEN ''  ELSE MAX(TO_LOC_GRP_CD) END AS TO_LOC_GRP_CD" ).append("\n"); 
		query.append(", CASE WHEN MAX(TO_LOC_CD) = 'N/A' THEN ''  ELSE MAX(TO_LOC_CD) END AS TO_LOC_CD" ).append("\n"); 
		query.append(", CASE WHEN MAX(RULE_EXPT_FLG) = 'Y' THEN '1'  ELSE '0' END AS RULE_EXPT_FLG" ).append("\n"); 
		query.append(", MAX(EQ_TRSP_MOD_CD) EQ_TRSP_MOD_CD" ).append("\n"); 
		query.append("#foreach( ${key} in ${tpszArr})" ).append("\n"); 
		query.append(",MAX(NVL(DECODE(CNST_CNTR_TPSZ_CD,'${key}','1'),'0')) CNST_CNTR_TPSZ_CD${key}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",MAX(SCNR_ID) SCNR_ID" ).append("\n"); 
		query.append(",MAX(UPD_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append(",MAX(TO_CHAR(UPD_DT, 'YYYYMMDD')) CRE_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SCNR_ID" ).append("\n"); 
		query.append(",REPO_CNST_SEQ" ).append("\n"); 
		query.append(",CNST_RULE_ID" ).append("\n"); 
		query.append(",REPO_CNST_TP_CD" ).append("\n"); 
		query.append(",REPO_CNST_DIR_CD" ).append("\n"); 
		query.append(",FM_LOC_GRP_CD" ).append("\n"); 
		query.append(",FM_LOC_CD" ).append("\n"); 
		query.append(",TO_LOC_GRP_CD" ).append("\n"); 
		query.append(",TO_LOC_CD" ).append("\n"); 
		query.append(",RULE_EXPT_FLG" ).append("\n"); 
		query.append(",EQ_TRSP_MOD_CD" ).append("\n"); 
		query.append(",CNST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_REPO_CNST" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("REPO_CNST_TP_CD" ).append("\n"); 
		query.append(", CNST_RULE_ID" ).append("\n"); 
		query.append(", RULE_EXPT_FLG" ).append("\n"); 
		query.append(", REPO_CNST_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cnsttype} != '')  -- Constraint Type 검색조건" ).append("\n"); 
		query.append("AND  REPO_CNST_TP_CD = @[cnsttype]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("REPO_CNST_TP_CD" ).append("\n"); 
		query.append(", CNST_RULE_ID" ).append("\n"); 
		query.append(", RULE_EXPT_FLG" ).append("\n"); 
		query.append(", REPO_CNST_SEQ" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("REPO_CNST_TP_CD" ).append("\n"); 
		query.append(", CNST_RULE_ID" ).append("\n"); 
		query.append(", RULE_EXPT_FLG" ).append("\n"); 
		query.append(", REPO_CNST_SEQ" ).append("\n"); 

	}
}