/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TCharterIOBunkerRegisterDAOFmsBunkerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnk_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration").append("\n"); 
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
		query.append(" 	   ,BNK_AMT" ).append("\n"); 
		query.append("       ,ROUND(FB.BNK_QTY * FB.BNK_PRC_AMT, 4) TOTAL_AMT" ).append("\n"); 
		query.append("       ,FB.VSL_CD||FB.SKD_VOY_NO||FB.SKD_DIR_CD||FB.REV_DIR_CD BUNKER_VVD" ).append("\n"); 
		query.append("       ,(SELECT U.USR_NM FROM COM_USER U WHERE U.USR_ID = FB.CRE_USR_ID) UPD_USR_ID " ).append("\n"); 
		query.append("       , FB.ATCH_FILE_FLET_LNK_ID" ).append("\n"); 
		query.append("       ,(SELECT COUNT(F.FILE_SAV_ID) CNT" ).append("\n"); 
		query.append("           FROM FMS_ATCH_FILE F" ).append("\n"); 
		query.append("          WHERE 1 = 1" ).append("\n"); 
		query.append("            AND F.ATCH_FILE_LNK_ID = FB.ATCH_FILE_FLET_LNK_ID" ).append("\n"); 
		query.append("        ) AS ATCH_FILE_LNK_CNT" ).append("\n"); 
		query.append("	   , SLP_TP_CD||SLP_FUNC_CD||SLP_OFC_CD||SLP_ISS_DT||SLP_SER_NO CSR_NO" ).append("\n"); 
		query.append(" FROM FMS_BUNKER FB, FMS_ACCT_ITM FA" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   #if(${flet_ctrt_no} != '')" ).append("\n"); 
		query.append("      AND FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND BNK_YRMON = REPLACE(@[bnk_yrmon],'-','')" ).append("\n"); 
		query.append("   AND FA.ACCT_CD = FB.ACCT_CD" ).append("\n"); 
		query.append("   AND FA.ACCT_ITM_SEQ = FB.ACCT_ITM_SEQ" ).append("\n"); 
		query.append(" ORDER BY FB.BNK_TP_CD, FB.ACCT_ITM_SEQ" ).append("\n"); 

	}
}