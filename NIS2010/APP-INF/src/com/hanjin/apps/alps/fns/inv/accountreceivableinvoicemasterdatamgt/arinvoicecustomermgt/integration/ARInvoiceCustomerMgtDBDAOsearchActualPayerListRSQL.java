/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOsearchActualPayerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.04 
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

public class ARInvoiceCustomerMgtDBDAOsearchActualPayerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOsearchActualPayerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOsearchActualPayerListRSQL").append("\n"); 
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
		query.append("SELECT MC.OFC_CD," ).append("\n"); 
		query.append("       MR.ACT_CUST_CNT_CD||LPAD(MR.ACT_CUST_SEQ,6,'0') AS ACT_CUST," ).append("\n"); 
		query.append("       MC1.CUST_LGL_ENG_NM AS ACT_CUST_NM," ).append("\n"); 
		query.append("       MR.CUST_CNT_CD||LPAD(MR.CUST_SEQ,6,'0') AS CUST," ).append("\n"); 
		query.append("       MC.CUST_LGL_ENG_NM AS CUST_NM," ).append("\n"); 
		query.append("       TO_CHAR(MR.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') AS UPD_DT," ).append("\n"); 
		query.append("       MR.UPD_USR_ID" ).append("\n"); 
		query.append("FROM   MDM_CUSTOMER MC," ).append("\n"); 
		query.append("       MDM_CR_CUST  MR," ).append("\n"); 
		query.append("       MDM_CUSTOMER MC1" ).append("\n"); 
		query.append("WHERE  MC.CUST_CNT_CD = MR.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    MC.CUST_SEQ = MR.CUST_SEQ" ).append("\n"); 
		query.append("AND    MC1.CUST_CNT_CD = MR.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("AND    MC1.CUST_SEQ = MR.ACT_CUST_SEQ" ).append("\n"); 
		query.append("AND    MR.ACT_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("AND    MR.ACT_CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("AND    MC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} == 'ALL')" ).append("\n"); 
		query.append("AND    MC.OFC_CD IN (SELECT DISTINCT OFC_CD " ).append("\n"); 
		query.append("					 FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("					 WHERE  AR_HD_QTR_OFC_CD = (SELECT AR_HD_QTR_OFC_CD " ).append("\n"); 
		query.append("							                    FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("							                    WHERE  OFC_CD = @[user_ofc_cd])" ).append("\n"); 
		query.append("					 AND    DELT_FLG = 'N')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    MC.OFC_CD = @[ar_ofc_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND    MR.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("AND    MR.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY MC.OFC_CD," ).append("\n"); 
		query.append("         MR.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("         MR.ACT_CUST_SEQ" ).append("\n"); 

	}
}