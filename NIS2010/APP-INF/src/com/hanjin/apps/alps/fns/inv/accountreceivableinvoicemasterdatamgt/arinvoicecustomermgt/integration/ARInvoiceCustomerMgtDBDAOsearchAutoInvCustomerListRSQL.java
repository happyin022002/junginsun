/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOsearchAutoInvCustomerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOsearchAutoInvCustomerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOsearchAutoInvCustomerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOsearchAutoInvCustomerListRSQL").append("\n"); 
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
		query.append("SELECT  A.AR_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("        DECODE(A.IO_BND_CD, 'I', 'I/B', 'O/B') IO_BND_CD," ).append("\n"); 
		query.append("        A.CUST," ).append("\n"); 
		query.append("        A.CUST_NM," ).append("\n"); 
		query.append("        DECODE(A.HJS_CUST_SVC_PIC_TP_CD, 'G','Group E-mail','Indi. Ref')HJS_CUST_SVC_PIC_TP_CD," ).append("\n"); 
		query.append("        A.AUTO_INV_HJS_REF_NO," ).append("\n"); 
		query.append("        DECODE(A.AUTO_INV_CUST_REF_NO_FLG, 'Y', 'YES', 'NO') AUTO_INV_CUST_REF_NO_FLG," ).append("\n"); 
		query.append("        DECODE(A.AUTO_INV_LOCL_CHG_FLG, 'Y', 'YES', 'NO') AUTO_INV_LOCL_CHG_FLG," ).append("\n"); 
		query.append("        A.AUTO_INV_EML," ).append("\n"); 
		query.append("        TO_CHAR(A.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') AS UPD_DT," ).append("\n"); 
		query.append("        A.UPD_USR_ID " ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT MR.OFC_CD AR_OFC_CD," ).append("\n"); 
		query.append("               MR.IO_BND_CD IO_BND_CD," ).append("\n"); 
		query.append("               MR.CUST_CNT_CD||LPAD(MR.CUST_SEQ,6,'0') AS CUST," ).append("\n"); 
		query.append("               MC.CUST_LGL_ENG_NM AS CUST_NM," ).append("\n"); 
		query.append("               MR.HJS_CUST_SVC_PIC_TP_CD," ).append("\n"); 
		query.append("               MR.HJS_REF_NO AS AUTO_INV_HJS_REF_NO," ).append("\n"); 
		query.append("               MR.CUST_REF_NO_FLG AS AUTO_INV_CUST_REF_NO_FLG," ).append("\n"); 
		query.append("               MR.LOCL_CHG_FLG AS AUTO_INV_LOCL_CHG_FLG," ).append("\n"); 
		query.append("               MR.AUTO_INV_EML AS AUTO_INV_EML," ).append("\n"); 
		query.append("               MR.UPD_DT," ).append("\n"); 
		query.append("               MR.UPD_USR_ID" ).append("\n"); 
		query.append("        FROM   MDM_CUSTOMER MC," ).append("\n"); 
		query.append("               MDM_CUST_REP  MR," ).append("\n"); 
		query.append("               MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("        WHERE  MC.CUST_CNT_CD = MR.CUST_CNT_CD" ).append("\n"); 
		query.append("        AND    MC.CUST_SEQ = MR.CUST_SEQ" ).append("\n"); 
		query.append("        AND    MC.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("        AND    MC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        AND    MR.DELT_FLG ='N'" ).append("\n"); 
		query.append("        AND    MR.AUTO_INV_FLG = 'Y' " ).append("\n"); 
		query.append("		#if (${act_cust_cnt_cd} != '') " ).append("\n"); 
		query.append("		AND    MR.CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${act_cust_seq} != '') " ).append("\n"); 
		query.append("        AND    MR.CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${ar_ofc_cd} == 'ALL') " ).append("\n"); 
		query.append("		AND    MR.OFC_CD IN (SELECT DISTINCT AR_OFC_CD " ).append("\n"); 
		query.append("							 	FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("							 	WHERE  AR_HD_QTR_OFC_CD = (SELECT AR_HD_QTR_OFC_CD " ).append("\n"); 
		query.append("							  		                       FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("							                            	WHERE  OFC_CD = @[user_ofc_cd])" ).append("\n"); 
		query.append("							 	AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("								AND AR_OFC_CD IS NOT NULL )" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("        AND    MR.OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != 'A')" ).append("\n"); 
		query.append("AND    A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.AR_OFC_CD, A.IO_BND_CD, A.CUST" ).append("\n"); 

	}
}