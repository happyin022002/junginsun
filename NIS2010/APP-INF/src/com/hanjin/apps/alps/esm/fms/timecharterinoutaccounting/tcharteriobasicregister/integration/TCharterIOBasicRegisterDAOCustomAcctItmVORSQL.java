/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterIOBasicRegisterDAOCustomAcctItmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBasicRegisterDAOCustomAcctItmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOBasicRegisterDAOCustomAcctItmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDAOCustomAcctItmVORSQL").append("\n"); 
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
		query.append("#if (${condflag} == \"checkAccount\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("acct_cd," ).append("\n"); 
		query.append("acct_eng_nm" ).append("\n"); 
		query.append("from mdm_account" ).append("\n"); 
		query.append("where not exists (select 'Y'" ).append("\n"); 
		query.append("from fms_ppt_set" ).append("\n"); 
		query.append("where ppt_nm = 'ACCT_DELETE'" ).append("\n"); 
		query.append("and ppt_ctnt = @[acct_cd])" ).append("\n"); 
		query.append("and acct_cd = @[acct_cd]" ).append("\n"); 
		query.append("and	delt_flg = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${condflag} == \"accountuse\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("acct_cd," ).append("\n"); 
		query.append("acct_itm_seq" ).append("\n"); 
		query.append("from FMS_OTR_EXPN" ).append("\n"); 
		query.append("where acct_cd = @[acct_cd]" ).append("\n"); 
		query.append("and	acct_itm_seq = @[acct_itm_seq]" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("acct_cd," ).append("\n"); 
		query.append("acct_itm_seq" ).append("\n"); 
		query.append("from FMS_INV_DTL" ).append("\n"); 
		query.append("where acct_cd = @[acct_cd]" ).append("\n"); 
		query.append("and	acct_itm_seq = @[acct_itm_seq]" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("acct_cd," ).append("\n"); 
		query.append("acct_itm_seq" ).append("\n"); 
		query.append("from FMS_BUNKER" ).append("\n"); 
		query.append("where acct_cd = @[acct_cd]" ).append("\n"); 
		query.append("and	acct_itm_seq = @[acct_itm_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("acct_cd," ).append("\n"); 
		query.append("acct_itm_seq," ).append("\n"); 
		query.append("acct_itm_nm," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append("from fms_acct_itm" ).append("\n"); 
		query.append("order by acct_itm_seq" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}