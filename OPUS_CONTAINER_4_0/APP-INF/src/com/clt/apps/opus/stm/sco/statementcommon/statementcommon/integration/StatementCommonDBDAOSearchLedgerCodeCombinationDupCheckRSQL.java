/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatementCommonDBDAOSearchLedgerCodeCombinationDupCheckRSQL.java
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

public class StatementCommonDBDAOSearchLedgerCodeCombinationDupCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLedgerCodeCombinationDupCheck
	  * </pre>
	  */
	public StatementCommonDBDAOSearchLedgerCodeCombinationDupCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchLedgerCodeCombinationDupCheckRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("FROM SCO_LEGR_CD_CMB" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if( ${sgm_ctnt1} != '' )" ).append("\n"); 
		query.append("AND SGM_CTNT1 = @[sgm_ctnt1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${sgm_ctnt2} != '' )" ).append("\n"); 
		query.append("AND SGM_CTNT2 = @[sgm_ctnt2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${sgm_ctnt3} != '' )" ).append("\n"); 
		query.append("AND SGM_CTNT3 = @[sgm_ctnt3]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${sgm_ctnt4} != '' )" ).append("\n"); 
		query.append("AND SGM_CTNT4 = @[sgm_ctnt4]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${sgm_ctnt5} != '' )" ).append("\n"); 
		query.append("AND SGM_CTNT5 = @[sgm_ctnt5]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${sgm_ctnt6} != '' )" ).append("\n"); 
		query.append("AND SGM_CTNT6 = @[sgm_ctnt6]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}