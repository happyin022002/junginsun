/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BookingUtilDBDAOsearchMdmLocPortNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.03.07 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang HO Chae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchMdmLocPortNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port code검토
	  * </pre>
	  */
	public BookingUtilDBDAOsearchMdmLocPortNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchMdmLocPortNameRSQL").append("\n"); 
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
		query.append("SELECT LOC_CD " ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND LOC_CD =@[port_cd]" ).append("\n"); 
		query.append("AND PORT_INLND_FLG = 'Y'" ).append("\n"); 

	}
}