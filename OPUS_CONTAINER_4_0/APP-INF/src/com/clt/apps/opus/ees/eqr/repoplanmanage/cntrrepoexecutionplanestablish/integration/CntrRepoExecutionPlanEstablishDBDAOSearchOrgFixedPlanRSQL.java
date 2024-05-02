/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchOrgFixedPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.11.18 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOSearchOrgFixedPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOrgFixedPlan
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchOrgFixedPlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ecc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ecc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchOrgFixedPlanRSQL").append("\n"); 
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
		query.append("SELECT	 PLN.REPO_PLN_ID	AS REPO_PLN_ID" ).append("\n"); 
		query.append(",PLN.PLN_YRWK		AS PLN_YRWK" ).append("\n"); 
		query.append(",PLN.PLN_SEQ		AS PLN_SEQ" ).append("\n"); 
		query.append(",QTY.CNTR_TPSZ_CD	AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM	EQR_VSL_LODG_DCHG_PLN PLN" ).append("\n"); 
		query.append(",EQR_VSL_LODG_DCHG_PLN_QTY QTY" ).append("\n"); 
		query.append("WHERE	PLN.REPO_PLN_ID			= QTY.REPO_PLN_ID" ).append("\n"); 
		query.append("AND	PLN.PLN_YRWK			= QTY.PLN_YRWK" ).append("\n"); 
		query.append("AND	PLN.PLN_SEQ				= QTY.PLN_SEQ" ).append("\n"); 
		query.append("AND	PLN.PAST_REPO_PLN_FLG	= 'Y'" ).append("\n"); 
		query.append("AND PLN.REPO_PLN_ID IN (" ).append("\n"); 
		query.append("SELECT	REPO_PLN_ID" ).append("\n"); 
		query.append("FROM	EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("WHERE	REPO_PLN_DTRB_FLG = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND	PLN.VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("AND	PLN.SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND	PLN.SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	PLN.FM_ECC_CD	= (SELECT ECC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = @[fm_ecc])" ).append("\n"); 
		query.append("AND	PLN.TO_ECC_CD	= (SELECT ECC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = @[to_ecc])" ).append("\n"); 
		query.append("AND	QTY.CNTR_TPSZ_CD= @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("--AND	TO_YD_CD	= 'SGSINJM'" ).append("\n"); 

	}
}