/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchInlandInsertCheckLinkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.04.07 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOSearchInlandInsertCheckLinkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRUCK & RAIL & WATER 에서 INSERT PLAN할때 EQR_SCNR_ECC_LNK 테이블에 존재하지 않으면 입력 불가능
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchInlandInsertCheckLinkRSQL(){
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
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchInlandInsertCheckLinkRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    COUNT(*) COUN					" ).append("\n"); 
		query.append("--	    	FROM EQR_SCNR_ECC_LNK					" ).append("\n"); 
		query.append("--	    	WHERE SCNR_ID     =  					" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    EQR_ECC_LNK					    " ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    FM_ECC_CD   = NVL((SELECT EC.ECC_CD" ).append("\n"); 
		query.append("                       FROM MDM_LOCATION ML, MDM_EQ_ORZ_CHT EC" ).append("\n"); 
		query.append("                       WHERE ML.LOC_CD = @[fm_yd_cd]" ).append("\n"); 
		query.append("                       AND   ML.SCC_CD = EC.SCC_CD" ).append("\n"); 
		query.append("                       AND   ROWNUM    = 1), @[fm_yd_cd])				" ).append("\n"); 
		query.append("    AND   TO_ECC_CD	 = NVL((SELECT EC.ECC_CD" ).append("\n"); 
		query.append("                       FROM MDM_LOCATION ML, MDM_EQ_ORZ_CHT EC" ).append("\n"); 
		query.append("                       WHERE ML.LOC_CD = @[to_yd_cd]" ).append("\n"); 
		query.append("                       AND   ML.SCC_CD = EC.SCC_CD" ).append("\n"); 
		query.append("                       AND   ROWNUM    = 1), @[to_yd_cd])					" ).append("\n"); 
		query.append("    AND   TRSP_MOD_CD = @[trsp_mod_cd]				     " ).append("\n"); 
		query.append("    AND   NVL(DELT_FLG, 'N') = @[delt_flg]" ).append("\n"); 

	}
}