/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchGstCustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.29 
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

public class InvoiceIssueCollectionMgtDBDAOSearchGstCustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchGstCustInfoRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchGstCustInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_ida_sac_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchGstCustInfoRSQL").append("\n"); 
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
		query.append("SELECT  T1.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("       ,DECODE(NVL(T1.IDA_GST_RGST_NO, ''), '', 'UnRegistered', 'Registered') AS IDA_GST_RGST_STS_NM" ).append("\n"); 
		query.append("       ,T1.IDA_PAN_NO" ).append("\n"); 
		query.append("       ,T3.IDA_STE_CD" ).append("\n"); 
		query.append("       ,T3.STE_NM 				AS IDA_STE_NM" ).append("\n"); 
		query.append("	   ,@[cond_ida_sac_cd]		AS IDA_SAC_CD" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			SELECT  IDA_SAC_NM" ).append("\n"); 
		query.append("			  FROM  BKG_IDA_SAC_MST" ).append("\n"); 
		query.append("			 WHERE  IDA_SAC_CD = @[cond_ida_sac_cd]" ).append("\n"); 
		query.append("		)						AS IDA_SAC_NM" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  FROM  MDM_CUSTOMER	T1" ).append("\n"); 
		query.append("	   ,MDM_LOCATION 	T2 " ).append("\n"); 
		query.append("	   ,MDM_STATE 		T3" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append(" WHERE  1 = 1 " ).append("\n"); 
		query.append("   AND  T1.LOC_CD      = T2.LOC_CD " ).append("\n"); 
		query.append("   AND  T2.CNT_CD      = T3.CNT_CD " ).append("\n"); 
		query.append("   AND  T2.STE_CD      = T3.STE_CD " ).append("\n"); 
		query.append("   AND  T1.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND  T1.CUST_SEQ    = @[cust_seq]" ).append("\n"); 
		query.append("   AND  T1.DELT_FLG    = 'N' " ).append("\n"); 
		query.append("   AND  T2.DELT_FLG    = 'N' " ).append("\n"); 
		query.append("   AND  T3.DELT_FLG    = 'N'" ).append("\n"); 

	}
}