/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConsultationSlipRequestMgtDBDAOSearchErpInterfaceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConsultationSlipRequestMgtDBDAOSearchErpInterfaceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP Interface list search
	  * </pre>
	  */
	public ConsultationSlipRequestMgtDBDAOSearchErpInterfaceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration").append("\n"); 
		query.append("FileName : ConsultationSlipRequestMgtDBDAOSearchErpInterfaceListRSQL").append("\n"); 
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
		query.append("      A.CSR_NO" ).append("\n"); 
		query.append("    , A.VNDR_NO" ).append("\n"); 
		query.append("    , (SELECT DECODE(VNDR_CNT_CD,'KR',VNDR_LOCL_LANG_NM,VNDR_LGL_ENG_NM)" ).append("\n"); 
		query.append("         FROM MDM_VENDOR" ).append("\n"); 
		query.append("        WHERE VNDR_SEQ = A.VNDR_NO" ).append("\n"); 
		query.append("     ) INV_DESC              " ).append("\n"); 
		query.append("    , TO_CHAR(A.IF_DT,'YYYY-MM-DD') IF_DT" ).append("\n"); 
		query.append("    , A.IF_ERR_RSN" ).append("\n"); 
		query.append("    , A.CSR_CURR_CD" ).append("\n"); 
		query.append("       , DECODE(A.CSR_CURR_CD, 'KRW', ROUND(NVL(A.CSR_AMT,0),0)" ).append("\n"); 
		query.append("          				  , 'JPY', ROUND(NVL(A.CSR_AMT,0),0)" ).append("\n"); 
		query.append("    					  , ROUND(NVL(A.CSR_AMT,0),2)) CSR_AMT" ).append("\n"); 
		query.append("    , A.CSR_USD_AMT" ).append("\n"); 
		query.append("    , SUBSTR(A.INV_TERM_DT, 1, 4) ||'/' ||SUBSTR(A.INV_TERM_DT, 5, 2) ||'/' ||SUBSTR(A.INV_TERM_DT, 7, 2) DUE_DT" ).append("\n"); 
		query.append("    , A.IF_FLG	   " ).append("\n"); 
		query.append("    , NVL(A.CSR_APRO_TP_CD,'AL') CSR_APRO_TP_CD" ).append("\n"); 
		query.append("     , (SELECT H.CORR_HIS_RMK" ).append("\n"); 
		query.append("        FROM COM_AP_CSR_HIS H" ).append("\n"); 
		query.append("        WHERE H.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("          AND H.COM_AP_CSR_APRO_HIS_SEQ =" ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                MAX(D.COM_AP_CSR_APRO_HIS_SEQ)" ).append("\n"); 
		query.append("                FROM COM_AP_CSR_HIS D" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND D.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        ) CORR_HIS_RMK" ).append("\n"); 
		query.append("    FROM  AP_INV_HDR A , COM_APRO_SND_MN_RULE R" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("	AND A.SRC_CTNT = R.SRC_CTNT(+)" ).append("\n"); 
		query.append("    AND A.CSR_NO LIKE @[search_csr_no]||'%'" ).append("\n"); 

	}
}