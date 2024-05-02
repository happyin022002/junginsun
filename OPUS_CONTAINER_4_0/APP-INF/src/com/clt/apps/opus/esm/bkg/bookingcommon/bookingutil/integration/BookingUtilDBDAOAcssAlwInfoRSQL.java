/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOAcssAlwInfoRSQL.java
*@FileTitle : Loading Confirmation by Shipper Preview And Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.06 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOAcssAlwInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면안에서 security control
	  * </pre>
	  */
	public BookingUtilDBDAOAcssAlwInfoRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  COUNT(1) CNT" ).append("\n"); 
		query.append("FROM   BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("WHERE  HRD_CDG_ID = 'SCR_ROLE_DEF'" ).append("\n"); 
		query.append("AND    ATTR_CTNT1 = @[attr_ctnt1]" ).append("\n"); 
		query.append("AND    ATTR_CTNT2 = @[attr_ctnt2]" ).append("\n"); 
		query.append("AND    ATTR_CTNT3 = @[attr_ctnt3]" ).append("\n"); 
		query.append("AND	   ATTR_CTNT4 = 'Y'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOAcssAlwInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}