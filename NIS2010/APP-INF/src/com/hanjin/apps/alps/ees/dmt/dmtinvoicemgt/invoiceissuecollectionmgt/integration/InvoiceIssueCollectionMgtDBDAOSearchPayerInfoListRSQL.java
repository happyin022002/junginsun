/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchPayerInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchPayerInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Payer Info & Fax/E-mail
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchPayerInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_area_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_exist_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reg_ex",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchPayerInfoListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT *" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT P.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("     , P.CUST_CNT_CD" ).append("\n"); 
		query.append("     , P.CUST_SEQ" ).append("\n"); 
		query.append("     , CASE WHEN P.CUST_CNT_CD = '00' THEN '' ELSE P.CUST_CNT_CD END || LPAD(P.CUST_SEQ, 6, '0') PAYR_CD" ).append("\n"); 
		query.append("	 , CASE WHEN P.CUST_CNT_CD IN ('00', 'TB') THEN 'Y' ELSE 'N' END SP_YN" ).append("\n"); 
		query.append("	 , CASE WHEN P.CUST_CNT_CD IN ('00', 'TB') THEN 'S/P' ELSE 'Customer' END PAYR_TP" ).append("\n"); 
		query.append("     , NVL(P.DMDT_PAYR_NM, (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = P.CUST_CNT_CD AND CUST_SEQ = P.CUST_SEQ)) PAYR_NM" ).append("\n"); 
		query.append("     , (SELECT DECODE(COUNT(PAYR_CNTC_PNT_EML), 0, 'N', 'Y')" ).append("\n"); 
		query.append("        FROM   DMT_PAYR_CNTC_PNT" ).append("\n"); 
		query.append("        WHERE  SYS_AREA_GRP_ID = P.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        AND    CUST_CNT_CD = P.CUST_CNT_CD" ).append("\n"); 
		query.append("        AND    CUST_SEQ = P.CUST_SEQ" ).append("\n"); 
		query.append("        AND    REGEXP_LIKE(PAYR_CNTC_PNT_EML, @[reg_ex])) EML_EXIST_FLG" ).append("\n"); 
		query.append("--     , NVL(SND_CYC_CD, 'D') " ).append("\n"); 
		query.append("	 , P.SND_CYC_CD" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		WHERE  INTG_CD_ID = 'CD03506'" ).append("\n"); 
		query.append("--		AND    INTG_CD_VAL_CTNT = NVL(SND_CYC_CD, 'D')) SND_CYC_DESC" ).append("\n"); 
		query.append("		AND    INTG_CD_VAL_CTNT = P.SND_CYC_CD) SND_CYC_DESC" ).append("\n"); 
		query.append("     , NVL(P.OTS_SH_GRP_CD, 'I') OTS_SH_GRP_CD" ).append("\n"); 
		query.append("	 , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		WHERE  INTG_CD_ID = 'CD03507'" ).append("\n"); 
		query.append("		AND    INTG_CD_VAL_CTNT = NVL(P.OTS_SH_GRP_CD, 'I')) OTS_SH_GRP_DESC" ).append("\n"); 
		query.append("     , NVL(P.SND_CNTR_LIST_FLG, 'Y') SND_CNTR_LIST_FLG" ).append("\n"); 
		query.append("     , NVL(P.SND_INV_FLG, 'N') SND_INV_FLG" ).append("\n"); 
		query.append("	 , P.UPD_USR_ID" ).append("\n"); 
		query.append("	 , P.UPD_DT" ).append("\n"); 
		query.append("	 , P.UPD_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ots_email_flg} != 'N')" ).append("\n"); 
		query.append("	   ,C.CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("       ,C.DMDT_PAYR_CNTC_PNT_NM AS PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append("       ,C.PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("       ,C.PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("       ,C.PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append("	   ,NVL(C.OTS_SND_FLG, 'Y') OTS_SND_FLG" ).append("\n"); 
		query.append("	   , CASE WHEN NVL(( SELECT 'Y' FROM DMT_PAYR_CNTC_PNT" ).append("\n"); 
		query.append("	                  WHERE 1=1" ).append("\n"); 
		query.append("	                    AND P.SYS_AREA_GRP_ID = SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	                    AND P.CUST_CNT_CD = CUST_CNT_CD" ).append("\n"); 
		query.append("	                    AND P.CUST_SEQ = CUST_SEQ" ).append("\n"); 
		query.append("	                    AND P.DMDT_PAYR_CNTC_PNT_NM = DMDT_PAYR_CNTC_PNT_NM " ).append("\n"); 
		query.append("        	            AND P.DMDT_PAYR_PHN_NO = PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("        	            AND P.DMDT_PAYR_FAX_NO = PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("        	            AND P.DMDT_PAYR_N1ST_EML = PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append("        	            AND ROWNUM = 1 ),'N') = 'Y' THEN" ).append("\n"); 
		query.append("                        	      CASE WHEN P.DMDT_PAYR_CNTC_PNT_NM = C.DMDT_PAYR_CNTC_PNT_NM " ).append("\n"); 
		query.append("                        	            AND P.DMDT_PAYR_PHN_NO = C.PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("                        	            AND P.DMDT_PAYR_FAX_NO = C.PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("                        	            AND P.DMDT_PAYR_N1ST_EML = C.PAYR_CNTC_PNT_EML THEN 1" ).append("\n"); 
		query.append("                	                   ELSE 0 END" ).append("\n"); 
		query.append("	         ELSE CASE WHEN CUST_CNTC_PNT_SEQ = 1 THEN 1" ).append("\n"); 
		query.append("                       ELSE 0 END " ).append("\n"); 
		query.append("             END SHEET " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM   DMT_PAYR_INFO P" ).append("\n"); 
		query.append("#if (${ots_email_flg} != 'N')" ).append("\n"); 
		query.append("    ,  DMT_PAYR_CNTC_PNT C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE  P.SYS_AREA_GRP_ID = @[sys_area_grp_id]" ).append("\n"); 
		query.append("#if (${payr_cd} != '')" ).append("\n"); 
		query.append("	AND (CASE WHEN P.CUST_CNT_CD = '00' THEN '' ELSE P.CUST_CNT_CD END || LPAD(P.CUST_SEQ, 6, '0')) LIKE '%$payr_cd%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${send_cyc_cd_list} != '')" ).append("\n"); 
		query.append("	AND (1 = 0 " ).append("\n"); 
		query.append("	#foreach($send_cyc_cd in ${send_cyc_cd_list}) " ).append("\n"); 
		query.append("		#if($send_cyc_cd == 'N')" ).append("\n"); 
		query.append("		OR P.SND_CYC_CD IS NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("		OR P.SND_CYC_CD IN (" ).append("\n"); 
		query.append("	#foreach($send_cyc_cd in ${send_cyc_cd_list}) " ).append("\n"); 
		query.append("        #if($velocityCount < $send_cyc_cd_list.size()) '$send_cyc_cd', #else '$send_cyc_cd' #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sp_yn} != '')" ).append("\n"); 
		query.append("	AND P.CUST_CNT_CD #if(${sp_yn} == 'N') NOT #end IN ('00', 'TB')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ots_email_flg} != 'N')" ).append("\n"); 
		query.append("    AND P.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID(+)" ).append("\n"); 
		query.append("    AND P.CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("    AND P.CUST_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ots_email_flg} != 'N')" ).append("\n"); 
		query.append("ORDER BY 1, 2, 3, C.CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${eml_exist_flg} != 'A')" ).append("\n"); 
		query.append("	AND EML_EXIST_FLG = @[eml_exist_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}