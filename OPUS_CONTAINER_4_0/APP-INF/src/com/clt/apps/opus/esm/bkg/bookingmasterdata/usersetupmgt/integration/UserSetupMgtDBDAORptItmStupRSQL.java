/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UserSetupMgtDBDAORptItmStupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAORptItmStupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public UserSetupMgtDBDAORptItmStupRSQL(){
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
		query.append("FileName : UserSetupMgtDBDAORptItmStupRSQL").append("\n"); 
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
		query.append(",      BKG_OFC_CD" ).append("\n"); 
		query.append(",      CUST_CNT_CD||CUST_SEQ CUST_CD" ).append("\n"); 
		query.append(",      CUST_CNT_CD" ).append("\n"); 
		query.append(",      CUST_SEQ" ).append("\n"); 
		query.append(",      MTY_PKUP_YD_FLG" ).append("\n"); 
		query.append(",      FULL_RTN_YD_FLG" ).append("\n"); 
		query.append(",      PORT_COFF_FLG" ).append("\n"); 
		query.append(",      RAIL_RCV_FLG" ).append("\n"); 
		query.append(",      DOC_COFF_FLG" ).append("\n"); 
		query.append(",      CUST_COFF_FLG" ).append("\n"); 
		query.append(",      CALL_SGN_FLG" ).append("\n"); 
		query.append(",      MRN_FLG" ).append("\n"); 
		query.append(",      CRN_FLG" ).append("\n"); 
		query.append(",      XCH_RT_FLG" ).append("\n"); 
		query.append(",      DIFF_RMK" ).append("\n"); 
		query.append(",      RCT_NTC_RMK" ).append("\n"); 
		query.append(",      CRE_USR_ID" ).append("\n"); 
		query.append(",      UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_RPT_ITM_STUP" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '' && ${bkg_ofc_cd} != '  ') " ).append("\n"); 
		query.append("AND    BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cd} != '') " ).append("\n"); 
		query.append("AND    CUST_CNT_CD||CUST_SEQ = @[cust_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}