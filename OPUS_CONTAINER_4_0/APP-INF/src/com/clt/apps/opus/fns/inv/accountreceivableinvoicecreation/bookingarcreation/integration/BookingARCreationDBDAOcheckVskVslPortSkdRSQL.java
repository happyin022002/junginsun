/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOcheckVskVslPortSkdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOcheckVskVslPortSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOcheckVskVslPortSkdRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOcheckVskVslPortSkdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOcheckVskVslPortSkdRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append(" WHERE VSL_CD = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 

	}
}