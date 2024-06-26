/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchChargeListForMaxInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.04.28 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchChargeListForMaxInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOSearchChargeListForMaxInterfaceRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchChargeListForMaxInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchChargeListForMaxInterfaceRSQL").append("\n"); 
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
		query.append("SELECT CHG_CD," ).append("\n"); 
		query.append("       CURR_CD," ).append("\n"); 
		query.append("       PER_TP_CD," ).append("\n"); 
		query.append("       TRF_RT_AMT," ).append("\n"); 
		query.append("       RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("       CHG_AMT," ).append("\n"); 
		query.append("       INV_XCH_RT," ).append("\n"); 
		query.append("       TRF_NO" ).append("\n"); 
		query.append("  FROM INV_AR_CHG" ).append("\n"); 
		query.append(" WHERE AR_IF_NO  IN ( SELECT  MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                        FROM INV_AR_MN" ).append("\n"); 
		query.append("                       WHERE BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("                         AND AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                         AND NVL(INV_DELT_DIV_CD,'N')<> 'Y'" ).append("\n"); 
		query.append("                         AND REV_TP_CD<> 'M'" ).append("\n"); 
		query.append("                         AND NVL(INV_SPLIT_CD,'N') NOT IN ('S','X','C','E') --2009.12.21 이상희과장,2009.12.24 C 다시뺌" ).append("\n"); 
		query.append("                       GROUP BY AR_OFC_CD,BL_SRC_NO )" ).append("\n"); 
		query.append("#if (${whf_chk} == 'Y')" ).append("\n"); 
		query.append("   AND CHG_CD <> 'WHF'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND NVL(CHG_AMT,0) <> 0" ).append("\n"); 
		query.append(" ORDER BY CHG_CD," ).append("\n"); 
		query.append("          CURR_CD," ).append("\n"); 
		query.append("          PER_TP_CD," ).append("\n"); 
		query.append("          TRF_RT_AMT," ).append("\n"); 
		query.append("          CHG_AMT," ).append("\n"); 
		query.append("          INV_XCH_RT," ).append("\n"); 
		query.append("          TRF_NO" ).append("\n"); 

	}
}