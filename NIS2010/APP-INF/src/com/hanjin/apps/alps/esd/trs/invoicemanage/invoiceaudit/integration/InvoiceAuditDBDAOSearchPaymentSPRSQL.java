/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchPaymentSPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchPaymentSPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WO SP의 PARENTS SP를 가져온다
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchPaymentSPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_svc_provider",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchPaymentSPRSQL").append("\n"); 
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
		query.append("SELECT A.VNDR_SEQ," ).append("\n"); 
		query.append("       A.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("       A.IDA_GST_RGST_STS_CD," ).append("\n"); 
		query.append("       A.IDA_GST_RGST_NO," ).append("\n"); 
		query.append("       (SELECT MS.IDA_STE_CD" ).append("\n"); 
		query.append("          FROM MDM_STATE MS" ).append("\n"); 
		query.append("         WHERE     MS.CNT_CD = 'IN'" ).append("\n"); 
		query.append("               AND MS.STE_CD =" ).append("\n"); 
		query.append("                      (SELECT ML.STE_CD" ).append("\n"); 
		query.append("                         FROM MDM_LOCATION ML" ).append("\n"); 
		query.append("                        WHERE     1 = 1" ).append("\n"); 
		query.append("                              AND ML.LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("                              AND NVL (A.DELT_FLG, 'N') <> 'Y'))" ).append("\n"); 
		query.append("          AS IDA_STE_CD," ).append("\n"); 
		query.append("       (SELECT MS.STE_NM" ).append("\n"); 
		query.append("          FROM MDM_STATE MS" ).append("\n"); 
		query.append("         WHERE     MS.CNT_CD = 'IN' " ).append("\n"); 
		query.append("               AND MS.STE_CD =" ).append("\n"); 
		query.append("                      (SELECT ML.STE_CD" ).append("\n"); 
		query.append("                         FROM MDM_LOCATION ML" ).append("\n"); 
		query.append("                        WHERE     1 = 1" ).append("\n"); 
		query.append("                              AND ML.LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("                              AND NVL (A.DELT_FLG, 'N') <> 'Y'))" ).append("\n"); 
		query.append("          AS IDA_STE_NM," ).append("\n"); 
		query.append("       A.PRNT_VNDR_SEQ," ).append("\n"); 
		query.append("       (SELECT B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR B" ).append("\n"); 
		query.append("         WHERE B.VNDR_SEQ = A.PRNT_VNDR_SEQ)" ).append("\n"); 
		query.append("          PRNT_VNDR_NM," ).append("\n"); 
		query.append("       (SELECT B.IDA_GST_RGST_STS_CD" ).append("\n"); 
		query.append("          FROM MDM_VENDOR B" ).append("\n"); 
		query.append("         WHERE B.VNDR_SEQ = A.PRNT_VNDR_SEQ)" ).append("\n"); 
		query.append("          AS PRNT_IDA_GST_RGST_STS_CD," ).append("\n"); 
		query.append("       (SELECT B.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("          FROM MDM_VENDOR B" ).append("\n"); 
		query.append("         WHERE B.VNDR_SEQ = A.PRNT_VNDR_SEQ)" ).append("\n"); 
		query.append("          AS PRNT_IDA_GST_RGST_NO," ).append("\n"); 
		query.append("       (SELECT MS.IDA_STE_CD" ).append("\n"); 
		query.append("          FROM MDM_STATE MS" ).append("\n"); 
		query.append("         WHERE     MS.CNT_CD = 'IN'" ).append("\n"); 
		query.append("               AND MS.STE_CD =" ).append("\n"); 
		query.append("                      (SELECT ML.STE_CD" ).append("\n"); 
		query.append("                         FROM MDM_LOCATION ML" ).append("\n"); 
		query.append("                        WHERE     1 = 1" ).append("\n"); 
		query.append("                              AND ML.LOC_CD =" ).append("\n"); 
		query.append("                                     (SELECT LOC_CD" ).append("\n"); 
		query.append("                                        FROM MDM_VENDOR B" ).append("\n"); 
		query.append("                                       WHERE B.VNDR_SEQ = A.PRNT_VNDR_SEQ)" ).append("\n"); 
		query.append("                              AND NVL (A.DELT_FLG, 'N') <> 'Y'))" ).append("\n"); 
		query.append("          AS PRNT_IDA_STE_CD," ).append("\n"); 
		query.append("       (SELECT MS.STE_NM" ).append("\n"); 
		query.append("          FROM MDM_STATE MS" ).append("\n"); 
		query.append("         WHERE     MS.CNT_CD = 'IN'" ).append("\n"); 
		query.append("               AND MS.STE_CD =" ).append("\n"); 
		query.append("                      (SELECT ML.STE_CD" ).append("\n"); 
		query.append("                         FROM MDM_LOCATION ML" ).append("\n"); 
		query.append("                        WHERE     1 = 1" ).append("\n"); 
		query.append("                              AND ML.LOC_CD =" ).append("\n"); 
		query.append("                                     (SELECT LOC_CD" ).append("\n"); 
		query.append("                                        FROM MDM_VENDOR B" ).append("\n"); 
		query.append("                                       WHERE B.VNDR_SEQ = A.PRNT_VNDR_SEQ)" ).append("\n"); 
		query.append("                              AND NVL (A.DELT_FLG, 'N') <> 'Y'))" ).append("\n"); 
		query.append("          AS PRNT_IDA_STE_NM" ).append("\n"); 
		query.append("  FROM MDM_VENDOR A" ).append("\n"); 
		query.append(" WHERE A.VNDR_SEQ = @[combo_svc_provider]" ).append("\n"); 

	}
}