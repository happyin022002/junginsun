/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchApGlDtListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOSearchApGlDtListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieve Outstanding Adjustment 
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchApGlDtListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchApGlDtListRSQL").append("\n"); 
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
		query.append("SELECT MAX(ADJ_GL_DT) AS AP_GL_DT" ).append("\n"); 
		query.append("FROM SAR_ADJ_HIS" ).append("\n"); 
		query.append("WHERE ADJ_NO = @[adj_no]" ).append("\n"); 
		query.append("#if(${dt_tp_cd} == 'G')" ).append("\n"); 
		query.append("	#if(${rvs_flg} == 'N')" ).append("\n"); 
		query.append("		AND ADJ_STS_CD = 'ADJUST'" ).append("\n"); 
		query.append("	#elseif(${rvs_flg} == 'Y')" ).append("\n"); 
		query.append("		AND ADJ_STS_CD = 'REVERSE'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND ADJ_STS_CD = 'ADJUST'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}