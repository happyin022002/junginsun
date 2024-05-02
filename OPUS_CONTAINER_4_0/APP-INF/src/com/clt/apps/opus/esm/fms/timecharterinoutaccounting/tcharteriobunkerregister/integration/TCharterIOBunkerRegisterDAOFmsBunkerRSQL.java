/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOBunkerRegisterDAOFmsBunkerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBunkerRegisterDAOFmsBunkerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOBunkerRegisterDAOFmsBunkerRSQL
	  * </pre>
	  */
	public TCharterIOBunkerRegisterDAOFmsBunkerRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBunkerRegisterDAOFmsBunkerRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       FLET_CTRT_NO" ).append("\n"); 
		query.append("       ,BNK_SEQ" ).append("\n"); 
		query.append("       ,BNK_YRMON" ).append("\n"); 
		query.append(" 	   ,BNK_TP_CD" ).append("\n"); 
		query.append(" 	   ,FB.ACCT_CD" ).append("\n"); 
		query.append(" 	   ,FB.ACCT_ITM_SEQ" ).append("\n"); 
		query.append(" 	   ,FA.ACCT_ITM_NM" ).append("\n"); 
		query.append("       ,TO_CHAR(BNK_DT, 'YYYYMMDDHH24MI') BNK_DT" ).append("\n"); 
		query.append(" 	   ,VSL_CD" ).append("\n"); 
		query.append(" 	   ,PORT_CD" ).append("\n"); 
		query.append("	   ,FLET_MEAS_UT_CD" ).append("\n"); 
		query.append("	   ,BNK_QTY" ).append("\n"); 
		query.append("	   ,BNK_PRC_AMT" ).append("\n"); 
		query.append(" 	   ,ROUND(BNK_AMT, 2) AS BNK_AMT" ).append("\n"); 
		query.append("       ,ROUND(FB.BNK_QTY * FB.BNK_PRC_AMT, 4) TOTAL_AMT" ).append("\n"); 
		query.append("       ,FB.VSL_CD||FB.SKD_VOY_NO||FB.SKD_DIR_CD||FB.REV_DIR_CD BUNKER_VVD" ).append("\n"); 
		query.append("       ,CASE WHEN FB.SLP_TP_CD IS NOT NULL OR AR_SLP_TP_CD IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("             ELSE 'N'" ).append("\n"); 
		query.append("        END AS SLP_TP_CD" ).append("\n"); 
		query.append(" FROM FMS_BUNKER FB, FMS_ACCT_ITM FA" ).append("\n"); 
		query.append(" WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("   AND FA.ACCT_CD = FB.ACCT_CD" ).append("\n"); 
		query.append("   AND FA.ACCT_ITM_SEQ = FB.ACCT_ITM_SEQ" ).append("\n"); 
		query.append(" ORDER BY FB.BNK_TP_CD, FB.ACCT_ITM_SEQ, FB.BNK_YRMON" ).append("\n"); 

	}
}