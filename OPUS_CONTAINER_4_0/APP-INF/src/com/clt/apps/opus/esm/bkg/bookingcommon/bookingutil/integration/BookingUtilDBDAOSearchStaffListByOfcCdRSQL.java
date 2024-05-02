/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchStaffListByOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.05
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.09.05 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchStaffListByOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Staff조회 List
	  * </pre>
	  */
	public BookingUtilDBDAOSearchStaffListByOfcCdRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchStaffListByOfcCdRSQL").append("\n"); 
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
		query.append("SELECT	USR_ID" ).append("\n"); 
		query.append(",   REGEXP_REPLACE(USR_ID,'^0+','') DP_USER_ID" ).append("\n"); 
		query.append(",	USR_NM" ).append("\n"); 
		query.append(",	USR_PWD" ).append("\n"); 
		query.append(",	USE_FLG" ).append("\n"); 
		query.append(",	MPHN_NO" ).append("\n"); 
		query.append(",	USR_EML" ).append("\n"); 
		query.append(",	CNT_CD" ).append("\n"); 
		query.append(",	LANG_TP_CD" ).append("\n"); 
		query.append(",	GMT_TMZN_CD" ).append("\n"); 
		query.append(",	CNT_DT_FMT_CD" ).append("\n"); 
		query.append(",	CNT_NO_FMT_CD" ).append("\n"); 
		query.append(",	XTN_PHN_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	OFC_CD" ).append("\n"); 
		query.append(",	USR_LOCL_NM" ).append("\n"); 
		query.append(",	USR_AUTH_TP_CD" ).append("\n"); 
		query.append(",	JB_ENG_NM" ).append("\n"); 
		query.append(",	PSN_ENG_NM" ).append("\n"); 
		query.append(",	GRD_ENG_NM" ).append("\n"); 
		query.append(",	FAX_NO" ).append("\n"); 
		query.append(",	EP_ID" ).append("\n"); 
		query.append("FROM	COM_USER X" ).append("\n"); 
		query.append("WHERE	USE_FLG = 'Y'" ).append("\n"); 
		query.append("AND	OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("ORDER BY CASE WHEN SUBSTR(DP_USER_ID,1,1) >'9' THEN '0'||DP_USER_ID ELSE DP_USER_ID END" ).append("\n"); 

	}
}