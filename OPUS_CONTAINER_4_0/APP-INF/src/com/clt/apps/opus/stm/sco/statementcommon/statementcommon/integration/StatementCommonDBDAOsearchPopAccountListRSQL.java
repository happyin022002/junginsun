/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatementCommonDBDAOsearchPopAccountListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17 
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

public class StatementCommonDBDAOsearchPopAccountListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SCO_0054 - Account Popup
	  * </pre>
	  */
	public StatementCommonDBDAOsearchPopAccountListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_mng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnd_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOsearchPopAccountListRSQL").append("\n"); 
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
		query.append("SELECT ACCT_CD       AS ACCT_CD," ).append("\n"); 
		query.append("       ACCT_ENG_NM   AS ACCT_ENG_NM" ).append("\n"); 
		query.append(" FROM  MDM_ACCOUNT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND NVL(JNL_CRE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("#if (${acct_cd} != '')" ).append("\n"); 
		query.append("  AND ACCT_CD LIKE @[acct_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${acctg_mng_tp_cd} != '')" ).append("\n"); 
		query.append("   AND ACCTG_MNG_TP_CD  = @[acctg_mng_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pnd_tgt_flg} != '')" ).append("\n"); 
		query.append("   AND PND_TGT_FLG =@[pnd_tgt_flg] " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}