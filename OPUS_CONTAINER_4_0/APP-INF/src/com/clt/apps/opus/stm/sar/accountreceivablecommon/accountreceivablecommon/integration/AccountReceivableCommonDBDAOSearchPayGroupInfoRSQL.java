/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOSearchPayGroupInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.10 
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

public class AccountReceivableCommonDBDAOSearchPayGroupInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search pay group info
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOSearchPayGroupInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOSearchPayGroupInfoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(AP_OFC_CD, NULL, '', AP_OFC_CD || '_O/EXP') PAY_GRP_LU_CD" ).append("\n"); 
		query.append("       , 'Refund' ATTR_CATE_NM" ).append("\n"); 
		query.append("       , '' ATTR_CTNT7" ).append("\n"); 
		query.append("       , '' ATTR_CTNT2" ).append("\n"); 
		query.append("       , AP_CTR_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ap_ofc_cd]" ).append("\n"); 

	}
}