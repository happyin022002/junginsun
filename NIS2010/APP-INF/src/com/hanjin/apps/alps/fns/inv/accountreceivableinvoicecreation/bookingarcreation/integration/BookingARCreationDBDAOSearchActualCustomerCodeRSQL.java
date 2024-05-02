/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchActualCustomerCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchActualCustomerCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchActualCustomerCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchActualCustomerCodeRSQL").append("\n"); 
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
		query.append("SELECT A.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("  FROM MDM_CR_CUST A," ).append("\n"); 
		query.append("       MDM_CUSTOMER B" ).append("\n"); 
		query.append(" WHERE A.CUST_CNT_CD = @[inv_cust_cnt_cd]" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = @[inv_cust_seq]" ).append("\n"); 
		query.append("   AND A.ACT_CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND A.ACT_CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("   AND NVL(B.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND NVL(B.NMD_CUST_FLG,'N') ='N' " ).append("\n"); 
		query.append("   AND NVL(B.CNTR_DIV_FLG,'N') ='Y'" ).append("\n"); 
		query.append("   AND NVL(A.SUB_SYS_NM,'MDM') <> 'ERP'" ).append("\n"); 

	}
}