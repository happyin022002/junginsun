/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UserSetupMgtDBDAORptItmStupDupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2010.02.09 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAORptItmStupDupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public UserSetupMgtDBDAORptItmStupDupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAORptItmStupDupRSQL").append("\n"); 
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
		query.append("SELECT ITM_SEQ" ).append("\n"); 
		query.append("FROM   BKG_RPT_ITM_STUP" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '' && ${bkg_ofc_cd} != '  ')" ).append("\n"); 
		query.append("AND    BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cd} != '')" ).append("\n"); 
		query.append("AND    CUST_CNT_CD||CUST_SEQ = @[cust_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    CUST_CNT_CD||CUST_SEQ is null" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}