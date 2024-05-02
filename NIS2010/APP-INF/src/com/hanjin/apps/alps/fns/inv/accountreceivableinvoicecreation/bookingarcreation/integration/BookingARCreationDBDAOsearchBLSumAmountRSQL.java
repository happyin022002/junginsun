/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchBLSumAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.05
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.07.05 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOsearchBLSumAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOsearchBLSumAmountRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchBLSumAmountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchBLSumAmountRSQL").append("\n"); 
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
		query.append("SELECT NVL(ROUND(SUM(IA.CHG_AMT/RATE.USD_LOCL_XCH_RT),2), 0) BL_SUM_AMOUNT" ).append("\n"); 
		query.append("  FROM INV_AR_CHG IA, INV_AR_MN IM, GL_MON_XCH_RT RATE" ).append("\n"); 
		query.append(" WHERE IM.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND IM.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("   AND IM.REV_SRC_CD IN ('IV','IC')" ).append("\n"); 
		query.append("   AND RATE.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("   AND RATE.CURR_CD = IA.CURR_CD" ).append("\n"); 
		query.append("   --AND RATE.ACCT_XCH_RT_YRMON = SUBSTR(IM.BL_INV_IF_DT, 1, 6)" ).append("\n"); 
		query.append("   --20100410 KHH" ).append("\n"); 
		query.append("   AND RATE.ACCT_XCH_RT_YRMON = SUBSTR(TO_CHAR(SYSDATE,'YYYYMMDD'), 1, 6)" ).append("\n"); 
		query.append("   AND IA.AR_IF_NO = IM.AR_IF_NO" ).append("\n"); 

	}
}