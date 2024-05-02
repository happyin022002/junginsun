/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ArrivalNoticeDBDAOmodifyArrNtcFormARGUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOmodifyArrNtcFormARGUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public ArrivalNoticeDBDAOmodifyArrNtcFormARGUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("impt_ntc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("addr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOmodifyArrNtcFormARGUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_ARR_NTC_WD A" ).append("\n"); 
		query.append("USING (SELECT  (SELECT NVL(MAX(AN_SEQ), 0) + 1 " ).append("\n"); 
		query.append("                 FROM BKG_ARR_NTC_WD " ).append("\n"); 
		query.append("                 )     AS AN_SEQ" ).append("\n"); 
		query.append("               ,'ARG'                      AS AN_TP_CD" ).append("\n"); 
		query.append("               ,@[ofc_cd]                   AS OFC_CD" ).append("\n"); 
		query.append("               ,'*'                        AS POD_CD" ).append("\n"); 
		query.append("               ,'*'                        AS CHN_AGN_CD" ).append("\n"); 
		query.append("               ,'N'                        AS LOCL_LANG_FLG" ).append("\n"); 
		query.append("               ,NULL                       AS ARR_PRV_FOM_CD" ).append("\n"); 
		query.append("               ,'N'                        AS ECLZ_BL_CPY_FLG" ).append("\n"); 
		query.append("               ,@[addr_ctnt]                AS ADDR_CTNT" ).append("\n"); 
		query.append("               ,@[impt_ntc_rmk]             AS IMPT_NTC_RMK" ).append("\n"); 
		query.append("               ,NULL                       AS BANK_IN_ACCT_CTNT" ).append("\n"); 
		query.append("               ,'N'                        AS DRFT_BL_BANK_ACCT_DP_FLG" ).append("\n"); 
		query.append("               ,@[usr_id]                  AS CRE_USR_ID" ).append("\n"); 
		query.append("               ,SYSDATE                    AS CRE_DT" ).append("\n"); 
		query.append("               ,@[usr_id]                  AS UPD_USR_ID" ).append("\n"); 
		query.append("               ,SYSDATE                    AS UPD_DT" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON ( A.AN_TP_CD = B.AN_TP_CD AND A.OFC_CD = B.OFC_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("    SET ADDR_CTNT                = B.ADDR_CTNT " ).append("\n"); 
		query.append("      , IMPT_NTC_RMK             = B.IMPT_NTC_RMK " ).append("\n"); 
		query.append("      , UPD_USR_ID               = B.UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT                   = B.UPD_DT    " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT(" ).append("\n"); 
		query.append("			AN_SEQ," ).append("\n"); 
		query.append("			AN_TP_CD," ).append("\n"); 
		query.append("			OFC_CD," ).append("\n"); 
		query.append("			POD_CD," ).append("\n"); 
		query.append("			CHN_AGN_CD," ).append("\n"); 
		query.append("			LOCL_LANG_FLG," ).append("\n"); 
		query.append("			ARR_PRV_FOM_CD," ).append("\n"); 
		query.append("			ECLZ_BL_CPY_FLG," ).append("\n"); 
		query.append("			ADDR_CTNT," ).append("\n"); 
		query.append("			IMPT_NTC_RMK," ).append("\n"); 
		query.append("			BANK_IN_ACCT_CTNT," ).append("\n"); 
		query.append("			DRFT_BL_BANK_ACCT_DP_FLG," ).append("\n"); 
		query.append("			CRE_USR_ID," ).append("\n"); 
		query.append("			CRE_DT," ).append("\n"); 
		query.append("			UPD_USR_ID," ).append("\n"); 
		query.append("			UPD_DT" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("          VALUES( B.AN_SEQ                      " ).append("\n"); 
		query.append("                 , B.AN_TP_CD                    " ).append("\n"); 
		query.append("                 , B.OFC_CD                      " ).append("\n"); 
		query.append("                 , B.POD_CD                      " ).append("\n"); 
		query.append("                 , B.CHN_AGN_CD                  " ).append("\n"); 
		query.append("                 , B.LOCL_LANG_FLG               " ).append("\n"); 
		query.append("                 , B.ARR_PRV_FOM_CD              " ).append("\n"); 
		query.append("                 , B.ECLZ_BL_CPY_FLG             " ).append("\n"); 
		query.append("                 , B.ADDR_CTNT                   " ).append("\n"); 
		query.append("                 , B.IMPT_NTC_RMK                " ).append("\n"); 
		query.append("                 , B.BANK_IN_ACCT_CTNT           " ).append("\n"); 
		query.append("                 , B.DRFT_BL_BANK_ACCT_DP_FLG    " ).append("\n"); 
		query.append("                 , B.CRE_USR_ID                  " ).append("\n"); 
		query.append("                 , B.CRE_DT                      " ).append("\n"); 
		query.append("                 , B.UPD_USR_ID                  " ).append("\n"); 
		query.append("                 , B.UPD_DT                      " ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}