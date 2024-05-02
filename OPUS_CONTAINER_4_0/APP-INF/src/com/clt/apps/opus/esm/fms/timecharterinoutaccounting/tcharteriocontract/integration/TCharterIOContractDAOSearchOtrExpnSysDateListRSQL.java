/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOContractDAOSearchOtrExpnSysDateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOContractDAOSearchOtrExpnSysDateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOSearchOtrExpnSysDateListRSQL
	  * </pre>
	  */
	public TCharterIOContractDAOSearchOtrExpnSysDateListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharterIOContractDAOSearchOtrExpnSysDateListRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("	   FA.ACCT_ITM_NM ACCT_ITM_NM, " ).append("\n"); 
		query.append("	   TO_CHAR(FO.EFF_DT,'YYYYMMDD') EFF_DT, " ).append("\n"); 
		query.append("	   TO_CHAR(FO.EXP_DT,'YYYYMMDD') EXP_DT," ).append("\n"); 
		query.append("	   FO.CURR_CD CURR_CD, " ).append("\n"); 
		query.append("       TO_CHAR(FO.OTR_EXPN_AMT,'FM999,999,999,999,000') OTR_EXPN_AMT" ).append("\n"); 
		query.append("  FROM FMS_OTR_EXPN  FO" ).append("\n"); 
		query.append("     , FMS_ACCT_ITM FA" ).append("\n"); 
		query.append(" WHERE FO.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("   AND FO.ACCT_CD = FA.ACCT_CD" ).append("\n"); 
		query.append("   AND FO.ACCT_ITM_SEQ = FA.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("   AND FO.EFF_DT <= SYSDATE" ).append("\n"); 
		query.append("   AND FO.EXP_DT >= SYSDATE" ).append("\n"); 
		query.append(" ORDER BY FA.ACCT_ITM_NM" ).append("\n"); 

	}
}