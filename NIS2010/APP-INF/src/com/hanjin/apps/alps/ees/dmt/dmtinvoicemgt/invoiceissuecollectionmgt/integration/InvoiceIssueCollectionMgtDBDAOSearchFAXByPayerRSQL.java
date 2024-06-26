/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchFAXByPayerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.17 
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

public class InvoiceIssueCollectionMgtDBDAOSearchFAXByPayerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PAYER 별 FAX NO 조회
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchFAXByPayerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payer_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchFAXByPayerRSQL").append("\n"); 
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
		query.append("#if (${payer_gubun} == 'C')" ).append("\n"); 
		query.append("SELECT DISTINCT DECODE(C.CUST_CNT_CD, NULL, DECODE(B.CUST_CNT_CD, NULL, A.FAX_NO, B.FAX_NO), C.FAX_NO) AS FAX" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--MDM GENERAL" ).append("\n"); 
		query.append("SELECT A.CUST_CNT_CD" ).append("\n"); 
		query.append(",A.CUST_SEQ" ).append("\n"); 
		query.append(",B.FAX_NO" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER A, MDM_CUST_CNTC_PNT B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD 	= B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= B.CUST_SEQ" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--MDM CREDIT" ).append("\n"); 
		query.append("SELECT CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append("#if (${io_bnd_cd} == 'I')" ).append("\n"); 
		query.append(",IB_FAX_NO AS FAX_NO" ).append("\n"); 
		query.append("#elseif (${io_bnd_cd} == 'O')" ).append("\n"); 
		query.append(",OB_FAX_NO as FAX_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",DECODE(IB_FAX_NO, NULL,OB_FAX_NO, IB_FAX_NO) AS FAX_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM MDM_CR_CUST" ).append("\n"); 
		query.append("#if (${io_bnd_cd} == 'I')" ).append("\n"); 
		query.append("WHERE IB_FAX_NO IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${io_bnd_cd} == 'O')" ).append("\n"); 
		query.append("WHERE OB_FAX_NO IS NOT NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE DECODE(IB_FAX_NO, NULL,OB_FAX_NO, IB_FAX_NO) IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--DMT" ).append("\n"); 
		query.append("SELECT CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append(",PAYR_CNTC_PNT_FAX_NO AS FAX_NO" ).append("\n"); 
		query.append("FROM DMT_PAYR_CNTC_PNT" ).append("\n"); 
		query.append("WHERE SYS_AREA_GRP_ID 	= (SELECT SYS_AREA_GRP_ID FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2) FROM MDM_ORGANIZATION  WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H')" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 		= B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD 	= C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 		= C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD 	= SUBSTR(@[payer_cd],1,2)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 		= SUBSTR(@[payer_cd],3)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${payer_gubun} == 'V')" ).append("\n"); 
		query.append("SELECT DISTINCT DECODE(B.CUST_CNT_CD, NULL, A.FAX_NO, B.FAX_NO) AS FAX" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--MDM GENERAL" ).append("\n"); 
		query.append("SELECT '00' AS CUST_CNT_CD" ).append("\n"); 
		query.append(",A.VNDR_SEQ AS CUST_SEQ" ).append("\n"); 
		query.append(",B.FAX_NO" ).append("\n"); 
		query.append("FROM MDM_VENDOR A, MDM_VNDR_CNTC_PNT B" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ	= B.VNDR_SEQ(+)" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--DMT" ).append("\n"); 
		query.append("SELECT CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append(",PAYR_CNTC_PNT_FAX_NO AS FAX_NO" ).append("\n"); 
		query.append("FROM DMT_PAYR_CNTC_PNT" ).append("\n"); 
		query.append("WHERE SYS_AREA_GRP_ID 	= (SELECT SYS_AREA_GRP_ID FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2) FROM MDM_ORGANIZATION  WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H')" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 		= B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD 	= '00'" ).append("\n"); 
		query.append("AND A.CUST_SEQ 		= @[payer_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT '' AS FAX" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}