/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOSearchApprovalTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.01
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.04.01 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOSearchApprovalTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public OwnersAccountDBDAOSearchApprovalTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cur",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOSearchApprovalTypeRSQL").append("\n"); 
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
		query.append("-- USD로 3만불 이상인지 판단 ( parameter : orgCur / orgAmt )" ).append("\n"); 
		query.append("SELECT --A.TTL_USD_AMT," ).append("\n"); 
		query.append("        CASE " ).append("\n"); 
		query.append("            WHEN A.TTL_USD_AMT >= 30000" ).append("\n"); 
		query.append("            THEN 'GW'" ).append("\n"); 
		query.append("            ELSE 'ALPS'" ).append("\n"); 
		query.append("         END APRO_TYPE" ).append("\n"); 
		query.append("  FROM ( SELECT MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), @[org_cur], 'USD', @[org_amt]) TTL_USD_AMT" ).append("\n"); 
		query.append("           FROM DUAL ) A" ).append("\n"); 

	}
}