/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOCheckDecWHFByBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.04.27 최도순
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

public class BookingARCreationDBDAOCheckDecWHFByBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOCheckDecWHFByBLRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOCheckDecWHFByBLRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("  FROM INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_CHG CHG," ).append("\n"); 
		query.append("	   MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append(" WHERE MN.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("   AND MN.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = ORG.AR_OFC_CD" ).append("\n"); 
		query.append("   AND SUBSTR(ORG.LOC_CD, 1, 2) = 'KR'" ).append("\n"); 
		query.append("   AND CHG.CHG_CD = 'WHF' " ).append("\n"); 
		query.append("   AND MN.WHF_DECL_NO IS NOT NULL" ).append("\n"); 

	}
}