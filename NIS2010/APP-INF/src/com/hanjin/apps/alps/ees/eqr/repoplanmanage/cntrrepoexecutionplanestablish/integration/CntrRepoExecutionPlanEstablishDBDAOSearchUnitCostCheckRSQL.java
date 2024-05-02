/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.27 정은호
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

public class CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UNIT COST 정보를 취득합니다.
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostCheckRSQL(){
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
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostCheckRSQL").append("\n"); 
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
		query.append("COUNT(1) CHK_NUM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_ADD_PLN_COST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${trsp_mod_cd} =='V')" ).append("\n"); 
		query.append("#if(${division} =='P')  -- plan" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("FM_ECC_CD = @[fm_ecc]" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("TO_ECC_CD = @[to_ecc]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else   -- execute 혹은 internal (E, I)" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("FM_ECC_CD = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCC_CD = SUBSTR( @[fm_ecc] , 0, 5)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR TO_ECC_CD = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE SCC_CD = SUBSTR( @[to_ecc] , 0, 5)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${division} =='P')  -- plan" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("FM_ECC_CD = @[fm_ecc]" ).append("\n"); 
		query.append("AND   TO_ECC_CD = @[to_ecc]" ).append("\n"); 
		query.append("#else   -- execute 혹은 internal (E, I)" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("FM_ECC_CD = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCC_CD = SUBSTR( @[fm_ecc] , 0, 5)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND   TO_ECC_CD = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCC_CD = SUBSTR( @[to_ecc] , 0, 5)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   TRSP_MOD_CD = @[trsp_mod_cd]" ).append("\n"); 
		query.append("AND   CNTR_TPSZ_CD= @[cntr_tpsz_cd]" ).append("\n"); 

	}
}