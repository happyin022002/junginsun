/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchInvVatChgCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.06
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.04.06 최도순
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

public class BookingARCreationDBDAOSearchInvVatChgCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchInvVatChgCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchInvVatChgCdRSQL").append("\n"); 
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
		query.append("SELECT INV_VAT_CHG_CD " ).append("\n"); 
		query.append("  FROM INV_AR_STUP_OFC " ).append("\n"); 
		query.append(" WHERE AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}