/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOCheckCustomerCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOCheckCustomerCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckCustomerCd
	  * </pre>
	  */
	public BookingUtilDBDAOCheckCustomerCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOCheckCustomerCdRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append(" CASE " ).append("\n"); 
		query.append("  WHEN DELT_FLG = 'Y' --delete" ).append("\n"); 
		query.append("   THEN 'Y' " ).append("\n"); 
		query.append("  WHEN NMD_CUST_FLG = 'Y' --delete" ).append("\n"); 
		query.append("   THEN 'Y' " ).append("\n"); 
		query.append("  WHEN (" ).append("\n"); 
		query.append("      SELECT COUNT(1)" ).append("\n"); 
		query.append("      FROM BKG_HRD_CDG_CTNT HRD" ).append("\n"); 
		query.append("      WHERE HRD_CDG_ID ='BKG_DMY_CUST'" ).append("\n"); 
		query.append("      AND HRD.ATTR_CTNT1 = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("      AND HRD.ATTR_CTNT2 = CUST.CUST_SEQ) > 0 --dummy customer" ).append("\n"); 
		query.append("   THEN 'Y'" ).append("\n"); 
		query.append("  WHEN (" ).append("\n"); 
		query.append("      SELECT NVL(CUST_RLSE_CTRL_FLG, 'N')" ).append("\n"); 
		query.append("      FROM MDM_CR_CUST CR" ).append("\n"); 
		query.append("      WHERE CR.CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("      AND CR.CUST_SEQ = CUST.CUST_SEQ) = 'Y' --black" ).append("\n"); 
		query.append("   THEN 'N' " ).append("\n"); 
		query.append("  ELSE 'N'" ).append("\n"); 
		query.append(" END delt_flg" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("  AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("  AND NVL(NMD_CUST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("  AND CNTR_DIV_FLG = 'Y'" ).append("\n"); 

	}
}