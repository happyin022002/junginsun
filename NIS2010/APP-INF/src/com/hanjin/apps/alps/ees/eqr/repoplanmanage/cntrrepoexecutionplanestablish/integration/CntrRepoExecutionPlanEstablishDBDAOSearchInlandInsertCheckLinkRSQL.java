/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchInlandInsertCheckLinkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.26 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("COUNT(*) COUN" ).append("\n"); 
		query.append("--	    	FROM EQR_SCNR_ECC_LNK" ).append("\n"); 
		query.append("--	    	WHERE SCNR_ID     =" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_LNK" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("FM_ECC_CD   = @[fm_yd_cd]" ).append("\n"); 
		query.append("AND   TO_ECC_CD	  = @[to_yd_cd]" ).append("\n"); 
		query.append("AND   TRSP_MOD_CD = @[trsp_mod_cd]" ).append("\n"); 
		query.append("-- added by shin yongchan 20070904, comfirmed by whang youngshin" ).append("\n"); 
		query.append("AND   NVL(DELT_FLG, 'N') = @[delt_flg]" ).append("\n"); 

	}
}