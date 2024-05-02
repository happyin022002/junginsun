/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchUserPrintSetup2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.11.19 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOSearchUserPrintSetup2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UserSetupMgtDBDAOSearchUserPrintSetup2RSQL
	  * </pre>
	  */
	public UserSetupMgtDBDAOSearchUserPrintSetup2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOSearchUserPrintSetup2RSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",CORR_NO" ).append("\n"); 
		query.append("FROM BKG_CORRECTION" ).append("\n"); 
		query.append("WHERE CORR_NO != '0000000001'" ).append("\n"); 
		query.append("AND  BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}