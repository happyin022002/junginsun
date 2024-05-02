/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageCommonDBDAOGetSetFltFileXcldDtlRulesRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingManageCommonDBDAOGetSetFltFileXcldDtlRulesRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VNDR단위에 호출할 EXCL Dtl RULE
	  * </pre>
	  */
	public TESeBillingManageCommonDBDAOGetSetFltFileXcldDtlRulesRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tag_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration").append("\n"); 
		query.append("FileName : TESeBillingManageCommonDBDAOGetSetFltFileXcldDtlRulesRSQL").append("\n"); 
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
		query.append("X.FLT_FILE_TAG_NM, X.FLT_FILE_KEY_NM, X.QTTN_CONC_FLG, X.RPLC_VAL_FLG, X.RPLC_VAL_CTNT," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(QTTN_CONC_FLG,'N') = 'Y' AND NVL(RPLC_VAL_FLG,'N') = 'N'" ).append("\n"); 
		query.append("THEN ''''||X.DFLT_VAL_CTNT||''''" ).append("\n"); 
		query.append("ELSE X.DFLT_VAL_CTNT" ).append("\n"); 
		query.append("END DFLT_VAL_CTNT," ).append("\n"); 
		query.append("1 RK, X.SAV_SEQ SEQ" ).append("\n"); 
		query.append("FROM TES_EDI_RCV_RULE_MN M, TES_EDI_RCV_RULE_VNDR_MGMT V, TES_EDI_RCV_FLT_FILE_TAG T, TES_EDI_RCV_FLT_FILE_XCLD X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M.EDI_RCV_RULE_MN_SEQ = V.EDI_RCV_RULE_MN_SEQ" ).append("\n"); 
		query.append("AND M.SNDR_ID = @[sndr_id]" ).append("\n"); 
		query.append("AND NVL(M.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(M.CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND V.EDI_VNDR_SEQ =  @[vndr_seq]" ).append("\n"); 
		query.append("AND V.EDI_RCV_RULE_MN_SEQ = T.EDI_RCV_RULE_MN_SEQ" ).append("\n"); 
		query.append("AND V.EDI_VNDR_SEQ = T.EDI_VNDR_SEQ" ).append("\n"); 
		query.append("AND T.FLT_FILE_TAG_NM = @[tag_nm]" ).append("\n"); 
		query.append("AND T.EDI_RCV_RULE_MN_SEQ = X.EDI_RCV_RULE_MN_SEQ" ).append("\n"); 
		query.append("AND T.EDI_VNDR_SEQ = X.EDI_VNDR_SEQ" ).append("\n"); 
		query.append("AND T.FLT_FILE_TAG_NM = X.FLT_FILE_TAG_NM" ).append("\n"); 
		query.append("AND X.FLT_FILE_KEY_NM NOT IN ('CRE_USR_ID','CRE_DT','UPD_USR_ID','UPD_DT')" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[tag_nm] FLT_FILE_TAG_NM," ).append("\n"); 
		query.append("'CRE_USR_ID' FLT_FILE_KEY_NM," ).append("\n"); 
		query.append("'N' QTTN_CONC_FLG, 'N' RPLC_VAL_FLG, '' RPLC_VAL_CTNT, '''SYSTEM''' DFLT_VAL_CTNT, 2 RK, 1 SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[tag_nm] FLT_FILE_TAG_NM," ).append("\n"); 
		query.append("'CRE_DT' FLT_FILE_KEY_NM," ).append("\n"); 
		query.append("'N' QTTN_CONC_FLG, 'N' RPLC_VAL_FLG, '' RPLC_VAL_CTNT, 'SYSDATE' DFLT_VAL_CTNT, 2 RK, 2 SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[tag_nm] FLT_FILE_TAG_NM," ).append("\n"); 
		query.append("'UPD_USR_ID' FLT_FILE_KEY_NM," ).append("\n"); 
		query.append("'N' QTTN_CONC_FLG, 'N' RPLC_VAL_FLG, '' RPLC_VAL_CTNT, '''SYSTEM''' DFLT_VAL_CTNT, 2 RK, 3 SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[tag_nm] FLT_FILE_TAG_NM," ).append("\n"); 
		query.append("'UPD_DT' FLT_FILE_KEY_NM," ).append("\n"); 
		query.append("'N' QTTN_CONC_FLG, 'N' RPLC_VAL_FLG, '' RPLC_VAL_CTNT, 'SYSDATE' DFLT_VAL_CTNT, 2 RK, 4 SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("ORDER BY RK, SEQ, FLT_FILE_KEY_NM" ).append("\n"); 

	}
}