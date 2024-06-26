/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ManualRegisterDBDAOSearchEQKindRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualRegisterDBDAOSearchEQKindRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEQKindRSQL
	  * </pre>
	  */
	public ManualRegisterDBDAOSearchEQKindRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.integration").append("\n"); 
		query.append("FileName : ManualRegisterDBDAOSearchEQKindRSQL").append("\n"); 
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
		query.append("#if (${s_n3pty_expn_tp_cd} == 'PSO')    " ).append("\n"); 
		query.append("SELECT INTG_CD_VAL_CTNT, INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("	  FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("	 WHERE 1 = 1" ).append("\n"); 
		query.append("	   AND INTG_CD_ID ='CD02906'" ).append("\n"); 
		query.append("       AND INTG_CD_VAL_CTNT = 'V'" ).append("\n"); 
		query.append("	ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    SELECT INTG_CD_VAL_CTNT, INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("	  FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("	 WHERE 1 = 1" ).append("\n"); 
		query.append("	   AND INTG_CD_ID ='CD02906'" ).append("\n"); 
		query.append("       AND INTG_CD_VAL_CTNT NOT IN ('V')" ).append("\n"); 
		query.append("	ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}