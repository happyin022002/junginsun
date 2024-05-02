/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatementCommonDBDAOSearchLedgerCodeCombinationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchLedgerCodeCombinationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ledger Code Combination List Search
	  * </pre>
	  */
	public StatementCommonDBDAOSearchLedgerCodeCombinationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_company",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_region",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_inter_company",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_account",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_center",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchLedgerCodeCombinationListRSQL").append("\n"); 
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
		query.append("SELECT CD_CMB_SEQ," ).append("\n"); 
		query.append("       COA_SEQ," ).append("\n"); 
		query.append("       LEGR_ACCT_TP_CD," ).append("\n"); 
		query.append("       ENBL_FLG," ).append("\n"); 
		query.append("       SGM_CTNT1," ).append("\n"); 
		query.append("       SGM_CTNT2," ).append("\n"); 
		query.append("       SGM_CTNT3," ).append("\n"); 
		query.append("       SGM_CTNT4," ).append("\n"); 
		query.append("       SGM_CTNT5," ).append("\n"); 
		query.append("       SGM_CTNT6," ).append("\n"); 
		query.append("       SGM_CTNT7," ).append("\n"); 
		query.append("       SGM_CTNT8," ).append("\n"); 
		query.append("       SGM_CTNT9," ).append("\n"); 
		query.append("       SGM_CTNT10," ).append("\n"); 
		query.append("       SGM_CTNT11," ).append("\n"); 
		query.append("       SGM_CTNT12," ).append("\n"); 
		query.append("       SGM_CTNT13," ).append("\n"); 
		query.append("       SGM_CTNT14," ).append("\n"); 
		query.append("       SGM_CTNT15," ).append("\n"); 
		query.append("       COA_ST_DT," ).append("\n"); 
		query.append("       COA_END_DT," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT    " ).append("\n"); 
		query.append("  FROM SCO_LEGR_CD_CMB" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append(" #if(${f_company} != '')" ).append("\n"); 
		query.append("   AND SGM_CTNT1 = @[f_company]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${f_region} != '')" ).append("\n"); 
		query.append("   AND SGM_CTNT2 = @[f_region]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${f_center} != '')" ).append("\n"); 
		query.append("   AND SGM_CTNT3 = @[f_center]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${f_account} != '')" ).append("\n"); 
		query.append("   AND SGM_CTNT4 = @[f_account]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${f_inter_company} != '')" ).append("\n"); 
		query.append("   AND SGM_CTNT5 = @[f_inter_company]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${f_vvd} != '')" ).append("\n"); 
		query.append("   AND SGM_CTNT6 = @[f_vvd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("ORDER BY SGM_CTNT1, SGM_CTNT2, SGM_CTNT3, SGM_CTNT4, SGM_CTNT5, SGM_CTNT6" ).append("\n"); 

	}
}