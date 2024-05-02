/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.12.23 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ATTN 조회
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointNameRSQL").append("\n"); 
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
		query.append("--DMT" ).append("\n"); 
		query.append("SELECT DISTINCT 'DMT' AS JOB_TP" ).append("\n"); 
		query.append(",'' AS GUBUN" ).append("\n"); 
		query.append(",DMDT_PAYR_CNTC_PNT_NM 	AS DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append("FROM DMT_PAYR_CNTC_PNT" ).append("\n"); 
		query.append("WHERE SYS_AREA_GRP_ID 	= (SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2)" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[s_ofc_cd])" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H')" ).append("\n"); 
		query.append("AND CUST_CNT_CD 		= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND CUST_SEQ 			= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("AND DMDT_PAYR_CNTC_PNT_NM IS NOT NULL" ).append("\n"); 
		query.append("-- MDM - CREDIT" ).append("\n"); 
		query.append("#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT 'MDM'" ).append("\n"); 
		query.append(",'CREDIT'" ).append("\n"); 
		query.append(",A.CNTC_PSON_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR A, MDM_VNDR_CNTC_PNT B" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ 		= B.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.VNDR_SEQ 			= @[s_cust_cd]" ).append("\n"); 
		query.append("AND A.CNTC_PSON_NM IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${s_cust_gubun} == '2')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT 'MDM'" ).append("\n"); 
		query.append(",'CREDIT'" ).append("\n"); 
		query.append(",B.CNTC_PSON_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER A, MDM_CR_CUST B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD 	= B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= B.CUST_SEQ" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD 		= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("AND B.CNTC_PSON_NM IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_pod_cnt_cd} == 'KR')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- BKG - D/O 신청" ).append("\n"); 
		query.append("SELECT DISTINCT 'BKG' AS JOB_TP" ).append("\n"); 
		query.append(",'D/O신청' AS GUBUN" ).append("\n"); 
		query.append(",BEP.PTY_CNTC_PSON_NM" ).append("\n"); 
		query.append("FROM   BKG_EDO_MST         BEM," ).append("\n"); 
		query.append("BKG_EDO_PTY_TRSP    BEP" ).append("\n"); 
		query.append("WHERE BEM.EDO_TP_CD   	= '5JN'" ).append("\n"); 
		query.append("AND BEP.EDO_PTY_CD 		= 'MS'" ).append("\n"); 
		query.append("AND BEM.BKG_NO 			= @[s_bkg_no]" ).append("\n"); 
		query.append("AND BEM.EDO_RQST_NO 	= BEP.EDO_RQST_NO" ).append("\n"); 
		query.append("AND BEM.EDO_RQST_SEQ  	= BEP.EDO_RQST_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- BKG - 자가운송 신청업체" ).append("\n"); 
		query.append("SELECT DISTINCT 'BKG' AS JOB_TP" ).append("\n"); 
		query.append(",'자가운송 신청' AS GUBUN" ).append("\n"); 
		query.append(",BEP.PTY_CNTC_PSON_NM" ).append("\n"); 
		query.append("FROM   BKG_EDO_MST         BEM," ).append("\n"); 
		query.append("BKG_EDO_PTY_TRSP    BEP" ).append("\n"); 
		query.append("WHERE BEM.EDO_TP_CD   	= '5JM'" ).append("\n"); 
		query.append("AND BEP.EDO_PTY_CD 		= 'MS'" ).append("\n"); 
		query.append("AND BEM.BKG_NO 			= @[s_bkg_no]" ).append("\n"); 
		query.append("AND BEM.EDO_RQST_NO 	= BEP.EDO_RQST_NO" ).append("\n"); 
		query.append("AND BEM.EDO_RQST_SEQ  	= BEP.EDO_RQST_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}