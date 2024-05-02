/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOSearchVendorInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOSearchVendorInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search vendor info
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOSearchVendorInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOSearchVendorInfoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(INTER_CO_FLG, 'N'), 'Y', NVL(SUBS_CO_CD,'00'), '00') INTER_CO_CD" ).append("\n"); 
		query.append("	   , GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("	   , PAY_MZD_CD AS AP_PAY_MZD_LU_CD" ).append("\n"); 
		query.append("FROM MDM_VENDOR                " ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[vndr_no]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 

	}
}