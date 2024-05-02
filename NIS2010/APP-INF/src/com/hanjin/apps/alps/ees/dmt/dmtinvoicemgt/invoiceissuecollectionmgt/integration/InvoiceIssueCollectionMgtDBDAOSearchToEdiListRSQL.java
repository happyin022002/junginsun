/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchToEdiListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchToEdiListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchToEdiListRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchToEdiListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchToEdiListRSQL").append("\n"); 
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
		query.append("SELECT  BKG_NO" ).append("\n"); 
		query.append("       ,SVR_ID" ).append("\n"); 
		query.append("	   ,CNTR_NO" ).append("\n"); 
		query.append("	   ,CNTR_CYC_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("			SELECT  A.BKG_NO " ).append("\n"); 
		query.append("				   ,B.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("				   ,B.CNTR_NO" ).append("\n"); 
		query.append("				   ,B.CNTR_CYC_NO" ).append("\n"); 
		query.append("				   ,DECODE(LENGTH(D.FM_MVMT_YD_CD), 7, 'Y', 'N') AS CHK_1" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						SELECT  DECODE(COUNT(1), 1, 'Y', 'N')" ).append("\n"); 
		query.append("						  FROM  DMT_HRD_CDG_CTNT 		T1" ).append("\n"); 
		query.append("							   ,COM_SYS_AREA_GRP_ID		T2" ).append("\n"); 
		query.append("						 WHERE  T1.HRD_CDG_ID  = 'SEND_TO_EDI_LOC'" ).append("\n"); 
		query.append("						   AND  T1.ATTR_CTNT1  = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND  T2.CNT_CD      = SUBSTR(D.FM_MVMT_YD_CD, 1, 2)" ).append("\n"); 
		query.append("						   AND  T1.ATTR_CTNT2  = SUBSTR(D.FM_MVMT_YD_CD, 1, 5)" ).append("\n"); 
		query.append("						   AND  T2.CO_IND_CD   = 'H'" ).append("\n"); 
		query.append("						   AND  T2.SVR_USD_FLG = 'Y'" ).append("\n"); 
		query.append("					) AS CHK_2" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("			  FROM  DMT_INV_MN 			A" ).append("\n"); 
		query.append("				   ,DMT_INV_DTL 		B" ).append("\n"); 
		query.append("				   ,DMT_CHG_BKG_CNTR 	C" ).append("\n"); 
		query.append("				   ,DMT_CHG_CALC 		D" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("			 WHERE  A.DMDT_INV_NO         = B.DMDT_INV_NO" ).append("\n"); 
		query.append("			   AND  A.CRE_OFC_CD          = B.CRE_OFC_CD" ).append("\n"); 
		query.append("			   AND  B.SYS_AREA_GRP_ID     = D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   AND  B.CNTR_NO             = D.CNTR_NO" ).append("\n"); 
		query.append("			   AND  B.CNTR_CYC_NO         = D.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   AND  B.DMDT_TRF_CD         = D.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   AND  B.DMDT_CHG_LOC_DIV_CD = D.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   AND  B.CHG_SEQ             = D.CHG_SEQ" ).append("\n"); 
		query.append("			   AND  C.SYS_AREA_GRP_ID     = D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   AND  C.CNTR_NO             = D.CNTR_NO" ).append("\n"); 
		query.append("			   AND  C.CNTR_CYC_NO         = D.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   AND  A.DMDT_INV_NO 	      = @[invoice_no]" ).append("\n"); 
		query.append("			   AND  A.CRE_OFC_CD	      = @[cre_ofc_cd]" ).append("\n"); 
		query.append("			   AND  D.CHG_SEQ             = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT  /*+ INDEX_DESC (DMT_CHG_CALC XPKDMT_CHG_CALC) */" ).append("\n"); 
		query.append("								CHG_SEQ" ).append("\n"); 
		query.append("						  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("						 WHERE  SYS_AREA_GRP_ID     = D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND  CNTR_NO             = D.CNTR_NO" ).append("\n"); 
		query.append("						   AND  CNTR_CYC_NO         = D.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND  DMDT_TRF_CD         = D.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND  DMDT_CHG_LOC_DIV_CD = D.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   AND  ROWNUM = 1" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append(" WHERE  CHK_1 = 'Y'" ).append("\n"); 
		query.append("   AND  CHK_2 = 'Y'  " ).append("\n"); 

	}
}