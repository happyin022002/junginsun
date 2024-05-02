/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchAccountDivisionRSQL.java
*@FileTitle : AAAAAAA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.03 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOsearchAccountDivisionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOsearchAccountDivisionRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchAccountDivisionRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_type",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT INV_ACCT_DIV_CD ACCT_DIV_CD" ).append("\n"); 
		query.append("FROM INV_REV_ACCT_CD" ).append("\n"); 
		query.append("WHERE REV_TP_SRC_CD = @[rev_type]" ).append("\n"); 
		query.append("AND INV_SRC_CD = 'CNTR'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchAccountDivisionRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}