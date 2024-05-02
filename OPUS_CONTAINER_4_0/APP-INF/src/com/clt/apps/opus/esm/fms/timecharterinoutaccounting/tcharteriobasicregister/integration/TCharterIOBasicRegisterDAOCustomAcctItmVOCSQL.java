/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOBasicRegisterDAOCustomAcctItmVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBasicRegisterDAOCustomAcctItmVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOBasicRegisterDAOCustomAcctItmVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_cr_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_cr_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_itm_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDAOCustomAcctItmVOCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_ACCT_ITM ( " ).append("\n"); 
		query.append("        ACCT_CD" ).append("\n"); 
		query.append("      , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("      , ACCT_ITM_NM" ).append("\n"); 
		query.append("      , AP_CR_ACCT_CD" ).append("\n"); 
		query.append("      , AR_CR_ACCT_CD" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("VALUES( @[acct_cd]" ).append("\n"); 
		query.append("      , FMS_ACCT_ITM_SEQ.NEXTVAL" ).append("\n"); 
		query.append("      , @[acct_itm_nm]" ).append("\n"); 
		query.append("      , @[ap_cr_acct_cd]" ).append("\n"); 
		query.append("      , @[ar_cr_acct_cd]" ).append("\n"); 
		query.append("      , @[cre_usr_id]" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append("      , @[cre_usr_id]" ).append("\n"); 
		query.append("      , SYSDATE " ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}