/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchDpcsOfcTmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.05 
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

public class BookingMasterMgtDBDAOSearchDpcsOfcTmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingMasterMgtDBDAOSearchDpcsOfcTmRSQL
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchDpcsOfcTmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchDpcsOfcTmRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	BKG_OFC_CD," ).append("\n"); 
		query.append("	(SELECT VNDR_CNT_CD FROM MDM_ORGANIZATION WHERE OFC_CD = TM.BKG_OFC_CD) CNT_CD," ).append("\n"); 
		query.append("	DOC_WRK_ST_HRMNT," ).append("\n"); 
		query.append("    DOC_WRK_OVN_FLG," ).append("\n"); 
		query.append("	DOC_WRK_END_HRMNT," ).append("\n"); 
		query.append("    TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('PKGSA',TO_DATE(DOC_WRK_ST_HRMNT,'HH24MI'), BKG_OFC_CD ), 'HH24MI') AS CONV_DOC_WRK_ST_HRMNT," ).append("\n"); 
		query.append("    TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('PKGSA',TO_DATE(DOC_WRK_END_HRMNT,'HH24MI'), BKG_OFC_CD ), 'HH24MI') AS CONV_DOC_WRK_END_HRMNT," ).append("\n"); 
		query.append("	DOC_WRK_OVN_FLG," ).append("\n"); 
		query.append("	DOC_WRK_TM_RMK" ).append("\n"); 
		query.append("FROM BKG_DPCS_OFC_WRK_TM TM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("AND BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}