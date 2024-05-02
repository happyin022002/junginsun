/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchOfficeAttributeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.26 
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

public class BookingARCreationDBDAOSearchOfficeAttributeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchOfficeAttributeRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchOfficeAttributeRSQL").append("\n"); 
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
		query.append("SELECT a.AR_HD_QTR_OFC_CD , " ).append("\n"); 
		query.append("	   a.ar_curr_cd, " ).append("\n"); 
		query.append("       a.ar_ctr_cd,  " ).append("\n"); 
		query.append("       a.loc_cd, " ).append("\n"); 
		query.append("       b.rgn_cd," ).append("\n"); 
		query.append("       a.SO_IF_CD , " ).append("\n"); 
		query.append("       a.AR_AGN_STL_CD, " ).append("\n"); 
		query.append("       a.AR_CTRL_OFC_CD," ).append("\n"); 
		query.append("       a.REP_CUST_CNT_CD, " ).append("\n"); 
		query.append("       a.rep_cust_seq," ).append("\n"); 
		query.append("       a.sub_agn_flg" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION a, MDM_LOCATION b" ).append("\n"); 
		query.append(" WHERE a.loc_cd = b.loc_cd " ).append("\n"); 
		query.append("   AND a.OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("   AND (nvl(a.DELT_FLG,'N') ='N' " ).append("\n"); 
		query.append("        OR  (nvl(a.DELT_FLG,'N') ='Y' " ).append("\n"); 
		query.append("             AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                         FROM   INV_CUT_OFF_LANE" ).append("\n"); 
		query.append("                         WHERE  OLD_AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("                         AND    SLAN_CD = 'ALL'" ).append("\n"); 
		query.append("                         AND    PORT_CD = 'ALL'" ).append("\n"); 
		query.append("                         AND    APLY_DT <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("                         AND    ROWNUM = 1)" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}