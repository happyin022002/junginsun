/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOSearchLocalTimeYMDHMSRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOSearchLocalTimeYMDHMSRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLocalTimeYMDHMS
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOSearchLocalTimeYMDHMSRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("l_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration ").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOSearchLocalTimeYMDHMSRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT AR_OFC_CD                                           " ).append("\n"); 
		query.append("						   FROM MDM_ORGANIZATION                                           " ).append("\n"); 
		query.append("						   WHERE OFC_CD = @[l_ofc_cd]))," ).append("\n"); 
		query.append("       'YYYYMMDDHHMISS') LCL_TIME" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}