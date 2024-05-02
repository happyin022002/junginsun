/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOaddBudCreCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOaddBudCreCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DAOCSQL
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOaddBudCreCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOaddBudCreCSQL").append("\n"); 
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
		query.append("INSERT INTO PSO_BUD_TGT_VVD (" ).append("\n"); 
		query.append("    BUD_SCNR_NO" ).append("\n"); 
		query.append("   , VSL_CD" ).append("\n"); 
		query.append("   , SKD_VOY_NO" ).append("\n"); 
		query.append("   , SKD_DIR_CD" ).append("\n"); 
		query.append("   , RLANE_CD" ).append("\n"); 
		query.append("   , CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("   , BUD_YRMON" ).append("\n"); 
		query.append("   , CRE_USR_ID" ).append("\n"); 
		query.append("   , CRE_DT" ).append("\n"); 
		query.append("   , UPD_USR_ID" ).append("\n"); 
		query.append("   , UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("   UPPER(@[scnr_no])" ).append("\n"); 
		query.append("   , UPPER(SUBSTR(@[vvd],1,4))" ).append("\n"); 
		query.append("   , UPPER(SUBSTR(@[vvd],5,4))" ).append("\n"); 
		query.append("   , UPPER(SUBSTR(@[vvd],9,1))" ).append("\n"); 
		query.append("   , UPPER(@[rlane_cd])" ).append("\n"); 
		query.append("   , @[capa]" ).append("\n"); 
		query.append("   , @[mon]" ).append("\n"); 
		query.append("   , @[cre_usr_id]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append("   , @[cre_usr_id]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}