/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkCostDBDAOMultiDailyHireCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2011.03.04 전윤주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun-ju Jeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOMultiDailyHireCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiDailyHire INSERT
	  * </pre>
	  */
	public NetworkCostDBDAOMultiDailyHireCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chrg_dhir_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOMultiDailyHireCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_CHRG_VSL_DLY_HIR B1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT '1' FROM DUAL " ).append("\n"); 
		query.append("	  ) B2	" ).append("\n"); 
		query.append("ON (     B1.COST_YRMON = @[cost_yrmon]						" ).append("\n"); 
		query.append("	 AND B1.VSL_CD = @[vsl_cd]		   )	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("      SET  CHRG_DHIR_AMT = @[chrg_dhir_amt]" ).append("\n"); 
		query.append("          ,UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("          ,UPD_DT        = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT  (" ).append("\n"); 
		query.append("    COST_YRMON" ).append("\n"); 
		query.append("   ,VSL_CD" ).append("\n"); 
		query.append("   ,CHRG_DHIR_AMT" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("    @[cost_yrmon]" ).append("\n"); 
		query.append("   ,@[vsl_cd]" ).append("\n"); 
		query.append("   ,@[chrg_dhir_amt]" ).append("\n"); 
		query.append("   ,@[cre_usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,@[upd_usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}