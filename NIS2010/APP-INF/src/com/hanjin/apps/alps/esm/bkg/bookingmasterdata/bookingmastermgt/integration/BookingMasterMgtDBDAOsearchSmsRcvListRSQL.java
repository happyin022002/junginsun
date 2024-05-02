/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingMasterMgtDBDAOsearchSmsRcvListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOsearchSmsRcvListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingMasterMgtDBDAOsearchSmsRcvListRSQL
	  * </pre>
	  */
	public BookingMasterMgtDBDAOsearchSmsRcvListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_ts_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOsearchSmsRcvListRSQL").append("\n"); 
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
		query.append("SELECT SLAN_CD" ).append("\n"); 
		query.append("     , DIR_CD" ).append("\n"); 
		query.append("     , LOCL_TS_IND_CD" ).append("\n"); 
		query.append("     , CRE_SEQ" ).append("\n"); 
		query.append("     , OFC_CD" ).append("\n"); 
		query.append("     , RCVR_USR_NM" ).append("\n"); 
		query.append("     , RCVR_USR_ID" ).append("\n"); 
		query.append("     , (SELECT USR_NM FROM COM_USER WHERE USR_ID = RCVR_USR_ID) USR_NM" ).append("\n"); 
		query.append("     , RCVR_EML" ).append("\n"); 
		query.append("     , OFC_PHN_NO" ).append("\n"); 
		query.append("     , OFC_FAX_NO" ).append("\n"); 
		query.append("     , PHN_NO" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("	 , PORT_CD" ).append("\n"); 
		query.append("     , FILE_ATCH_FLG" ).append("\n"); 
		query.append("FROM BKG_CLL_CNG_NTFY_SET" ).append("\n"); 
		query.append("WHERE SLAN_CD LIKE @[slan_cd]||'%'" ).append("\n"); 
		query.append("AND DIR_CD LIKE @[dir_cd]||'%'" ).append("\n"); 
		query.append("AND LOCL_TS_IND_CD LIKE @[locl_ts_ind_cd]||'%'" ).append("\n"); 
		query.append("AND PORT_CD LIKE @[port_cd]||'%'" ).append("\n"); 

	}
}