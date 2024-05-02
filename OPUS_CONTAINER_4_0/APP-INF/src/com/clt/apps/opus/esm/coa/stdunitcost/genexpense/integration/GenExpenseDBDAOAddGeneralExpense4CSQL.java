/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GenExpenseDBDAOAddGeneralExpense4CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.genexpense.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GenExpenseDBDAOAddGeneralExpense4CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 비용계산용 PRC, PKG 실행
	  * </pre>
	  */
	public GenExpenseDBDAOAddGeneralExpense4CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dhir_amt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_capa4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.genexpense.integration").append("\n"); 
		query.append("FileName : GenExpenseDBDAOAddGeneralExpense4CSQL").append("\n"); 
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
		query.append("MERGE INTO COA_OWN_VSL_DLY_HIR B1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT '1' FROM DUAL " ).append("\n"); 
		query.append("	  ) B2	" ).append("\n"); 
		query.append("ON (     B1.COST_YRMON    = @[cost_yrmon4]   " ).append("\n"); 
		query.append("     AND B1.VSL_CD        = 'XXXX'" ).append("\n"); 
		query.append("     AND B1.VSL_CLSS_CAPA = @[vsl_clss_capa4]		" ).append("\n"); 
		query.append("	 AND B1.STND_COST_CD  = '75000000') " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE " ).append("\n"); 
		query.append("         SET DHIR_AMT    		= @[dhir_amt4]" ).append("\n"); 
		query.append("            ,UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append("            ,UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("      INSERT (COST_YRMON" ).append("\n"); 
		query.append("             ,VSL_CD" ).append("\n"); 
		query.append("             ,VSL_CLSS_CAPA" ).append("\n"); 
		query.append("             ,STND_COST_CD" ).append("\n"); 
		query.append("             ,DHIR_AMT" ).append("\n"); 
		query.append("             ,CRE_USR_ID" ).append("\n"); 
		query.append("             ,CRE_DT" ).append("\n"); 
		query.append("             ,UPD_USR_ID" ).append("\n"); 
		query.append("             ,UPD_DT" ).append("\n"); 
		query.append("             ) " ).append("\n"); 
		query.append("      VALUES (@[cost_yrmon4]" ).append("\n"); 
		query.append("             ,'XXXX'" ).append("\n"); 
		query.append("             ,@[vsl_clss_capa4]             " ).append("\n"); 
		query.append("             ,'75000000'" ).append("\n"); 
		query.append("             ,@[dhir_amt4]" ).append("\n"); 
		query.append("             ,@[cre_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE" ).append("\n"); 
		query.append("             ,@[upd_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE)" ).append("\n"); 

	}
}