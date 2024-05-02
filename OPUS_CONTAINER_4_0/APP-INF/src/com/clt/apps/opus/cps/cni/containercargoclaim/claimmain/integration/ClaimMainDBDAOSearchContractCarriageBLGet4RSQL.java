/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ClaimMainDBDAOSearchContractCarriageBLGet4RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2014.12.23 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchContractCarriageBLGet4RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchContractCarriageBLGet4
	  * </pre>
	  */
	public ClaimMainDBDAOSearchContractCarriageBLGet4RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchContractCarriageBLGet4RSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(REPLACE(REPLACE(CUST_NM,CHR(13)||CHR(10),' '),CHR(12), ' '), 1, 50) AS NTFY_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BKG_NO   =  @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" AND BKG_CUST_TP_CD= 'N'" ).append("\n"); 

	}
}