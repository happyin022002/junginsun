/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAONYCInvoiceIssueDateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.04
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.02.04 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAONYCInvoiceIssueDateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAONYCInvoiceIssueDateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scope",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAONYCInvoiceIssueDateVORSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN INV_ISS_SND_TP_CD = 'E' THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', EML_DT, A.AR_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("           WHEN INV_ISS_SND_TP_CD = 'F' THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', FAX_DT, A.AR_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("           WHEN INV_ISS_SND_TP_CD = 'P' THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', A.CRE_DT, A.AR_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("        END                                                    AS TIME_SENT" ).append("\n"); 
		query.append("       , CASE WHEN INV_ISS_SND_TP_CD = 'E' THEN 'e-mail'" ).append("\n"); 
		query.append("            WHEN INV_ISS_SND_TP_CD = 'F' THEN 'FAX'" ).append("\n"); 
		query.append("            WHEN INV_ISS_SND_TP_CD = 'P' THEN 'Paper'" ).append("\n"); 
		query.append("			ELSE 'Unperformed'" ).append("\n"); 
		query.append("       END AS SENT_BY" ).append("\n"); 
		query.append("       ,CASE WHEN INV_ISS_SND_TP_CD = 'E' THEN" ).append("\n"); 
		query.append("             DECODE(NVL(B.EML_PROC_STS_CD, 'N'), '1', 'SENDING', '3', 'SUCCESS',                 'FAIL')" ).append("\n"); 
		query.append("            WHEN INV_ISS_SND_TP_CD = 'F' THEN DECODE(NVL(C.FAX_PROC_STS_CD, 'N'), '1', 'SENDING', '3', 'SENDING', '5', 'SUCCESS', 'FAIL')" ).append("\n"); 
		query.append("            WHEN INV_ISS_SND_TP_CD = 'P' THEN 'SUCCESS'" ).append("\n"); 
		query.append("        END AS SENT_RESULT     " ).append("\n"); 
		query.append("       ,INV_SND_CUST_NO RECEIVED_NO" ).append("\n"); 
		query.append("       ,INV_SND_DT TIME_REQUESTED" ).append("\n"); 
		query.append("       ,D.AR_OFC_CD" ).append("\n"); 
		query.append("       ,D.IO_BND_CD" ).append("\n"); 
		query.append("       ,D.REV_TP_CD||D.REV_SRC_CD REV_TYPE" ).append("\n"); 
		query.append("       ,D.BL_SRC_NO" ).append("\n"); 
		query.append("       ,D.ACT_CUST_CNT_CD||'-'||LPAD(D.ACT_CUST_SEQ,6,0) CUST_CODE" ).append("\n"); 
		query.append("       ,D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("       ,D.SAIL_ARR_DT" ).append("\n"); 
		query.append("       ,D.POL_CD" ).append("\n"); 
		query.append("       ,D.POD_CD" ).append("\n"); 
		query.append("       ,(SELECT TO_CHAR(ROUND(SUM(CHG_AMT*INV_XCH_RT), 2),'FM999,999,990.00') FROM INV_AR_MN M, INV_AR_CHG CH" ).append("\n"); 
		query.append("        WHERE M.AR_IF_NO = CH.AR_IF_NO AND M.BL_SRC_NO = A.BL_SRC_NO AND M.AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("         AND NVL(M.INV_DELT_DIV_CD, 'N') <> 'Y') TTL_AMT" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("		,TO_CHAR(INV_SND_DT,'YYYYMMDD') AS INV_SND_DT" ).append("\n"); 
		query.append("		,A.SND_SEQ" ).append("\n"); 
		query.append("  FROM INV_AR_USA_ISS_SND A" ).append("\n"); 
		query.append("       ,COM_EML_SND_INFO B" ).append("\n"); 
		query.append("       ,COM_FAX_SND_INFO C" ).append("\n"); 
		query.append("       ,INV_AR_MN D" ).append("\n"); 
		query.append(" WHERE A.INV_SND_NO = B.EML_SND_NO(+)" ).append("\n"); 
		query.append("   AND A.INV_SND_NO = C.FAX_SND_NO(+)" ).append("\n"); 
		query.append("   AND A.AR_OFC_CD = D.AR_OFC_CD" ).append("\n"); 
		query.append("   AND A.BL_SRC_NO = D.BL_SRC_NO" ).append("\n"); 
		query.append("   AND D.AR_IF_NO = (SELECT SUBSTR(MAX(DECODE(REV_TP_CD,'M','A','B')||AR_IF_NO),2,11) AR_IF_NO " ).append("\n"); 
		query.append("                       FROM INV_AR_MN " ).append("\n"); 
		query.append("                      WHERE AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                        AND BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                        AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                        AND BL_INV_CFM_DT IS NOT NULL)" ).append("\n"); 
		query.append("   --AND A.SND_SEQ = 1" ).append("\n"); 
		query.append("#if (${bl_src_no} != '')" ).append("\n"); 
		query.append("		   AND D.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${iss_fm_dt} != '') && (${iss_to_dt} != ''))" ).append("\n"); 
		query.append("		   AND TO_CHAR(A.INV_SND_DT,'YYYYMMDD') BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${office} != '')" ).append("\n"); 
		query.append("		   AND D.AR_OFC_CD = @[office] -- OFFICE" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("		   AND D.AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("		                          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                         WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("		                                                      FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                                                     WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("		                                                                        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                                                                       WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("		                           AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		   AND NVL(D.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("		   AND D.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("		   AND D.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_type} != 'A')" ).append("\n"); 
		query.append("		   AND D.REV_TP_CD = @[rev_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("		   AND D.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("		   AND D.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("		   AND D.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scope} != '')" ).append("\n"); 
		query.append("		   AND D.SVC_SCP_CD = @[scope]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != 'A')" ).append("\n"); 
		query.append("		   AND D.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("#if ((${bound} == 'I') && (${port} != ''))" ).append("\n"); 
		query.append("		   AND D.POD_CD = @[port]" ).append("\n"); 
		query.append("#elseif ((${bound} == 'O') && (${port} != ''))" ).append("\n"); 
		query.append("		   AND D.POL_CD = @[port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${port} != '')" ).append("\n"); 
		query.append("		   AND ((D.IO_BND_CD = 'I' AND D.POD_CD = @[port]) OR (D.IO_BND_CD = 'O' AND D.POL_CD = @[port]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append("		   AND A.CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY D.AR_OFC_CD, D.BL_SRC_NO, A.SND_SEQ DESC" ).append("\n"); 

	}
}