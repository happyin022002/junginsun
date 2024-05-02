/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOInvRevAcctCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceMasterDataMgtDBDAOInvRevAcctCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOInvRevAcctCdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("source",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_group",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOInvRevAcctCdVORSQL").append("\n"); 
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
		query.append("SELECT INV_SRC_CD" ).append("\n"); 
		query.append("     , REV_TP_GRP_CD" ).append("\n"); 
		query.append("     , REV_TP_SRC_CD" ).append("\n"); 
		query.append("     , INV_ACCT_DIV_CD" ).append("\n"); 
		query.append("     , CHG_CD" ).append("\n"); 
		query.append("     , ACCT_CD" ).append("\n"); 
		query.append("--     , ACCT_KRN_NM" ).append("\n"); 
		query.append("     , ACCT_ENG_NM" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , TO_CHAR(UPD_DT, 'YYYYMMDDHH24MISS') UPD_DT" ).append("\n"); 
		query.append("  FROM INV_REV_ACCT_CD" ).append("\n"); 
		query.append(" WHERE INV_SRC_CD LIKE @[source]||'%' " ).append("\n"); 
		query.append("   AND REV_TP_GRP_CD LIKE @[rev_group]||'%' " ).append("\n"); 
		query.append("   AND DELT_FLG LIKE @[del]||'%'" ).append("\n"); 

	}
}