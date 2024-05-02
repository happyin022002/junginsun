/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GenExpenseDBDAOCoaDmdtN3rdPtyVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.11 
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

public class GenExpenseDBDAOCoaDmdtN3rdPtyVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * @ SJH.20140808.MOD : COST_YRMON -> COST_YRMON-1
	  * </pre>
	  */
	public GenExpenseDBDAOCoaDmdtN3rdPtyVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.genexpense.integration").append("\n"); 
		query.append("FileName : GenExpenseDBDAOCoaDmdtN3rdPtyVOUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_DMDT_N3RD_PTY A USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("         SELECT TO_CHAR(ADD_MONTHS(TO_DATE(@[cost_yrmon], 'YYYYMM'), -1), 'YYYYMM') COST_YRMON" ).append("\n"); 
		query.append("              , 'TEU' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , '75000000' STND_COST_CD" ).append("\n"); 
		query.append("              , @[uc_amt] UC_AMT" ).append("\n"); 
		query.append("              , @[upd_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("              , SYSDATE CRE_DT" ).append("\n"); 
		query.append("              , @[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("              , SYSDATE UPD_DT" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append(") B " ).append("\n"); 
		query.append("  ON (A.COST_YRMON = B.COST_YRMON AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD AND A.STND_COST_CD = B.STND_COST_CD )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("        COST_YRMON" ).append("\n"); 
		query.append("      , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , STND_COST_CD" ).append("\n"); 
		query.append("      , UC_AMT" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT )" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("        B.COST_YRMON" ).append("\n"); 
		query.append("      , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , B.STND_COST_CD" ).append("\n"); 
		query.append("      , B.UC_AMT" ).append("\n"); 
		query.append("      , B.CRE_USR_ID" ).append("\n"); 
		query.append("      , B.CRE_DT" ).append("\n"); 
		query.append("      , B.UPD_USR_ID" ).append("\n"); 
		query.append("      , B.UPD_DT )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("   SET A.UC_AMT     = B.UC_AMT" ).append("\n"); 
		query.append("     , A.UPD_DT     = B.UPD_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID = B.UPD_USR_ID" ).append("\n"); 

	}
}