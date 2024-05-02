/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AccountDBDAOSearchRepChgCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.account.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountDBDAOSearchRepChgCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.02.21 조인영 Rep Charge Code 정보를 조회한다.
	  * </pre>
	  */
	public AccountDBDAOSearchRepChgCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.account.integration").append("\n"); 
		query.append("FileName : AccountDBDAOSearchRepChgCodeRSQL").append("\n"); 
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
		query.append("SELECT REP_CHG_CD" ).append("\n"); 
		query.append("      ,REP_CHG_NM" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,NVL(DELT_FLG, 'N') AS DELT_FLG" ).append("\n"); 
		query.append("      ,EAI_EVNT_DT" ).append("\n"); 
		query.append("      ,EAI_IF_ID" ).append("\n"); 
		query.append("  FROM MDM_REP_CHG" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${rep_chg_cd} != '')      " ).append("\n"); 
		query.append("   AND REP_CHG_CD = @[rep_chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY  REP_CHG_CD" ).append("\n"); 

	}
}