/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CimCommonDBDAOOscarBookingInformationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CimCommonDBDAOOscarBookingInformationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OSCAR Booking Information Inquiry 화면에서 Booking Information조회
	  * </pre>
	  */
	public CimCommonDBDAOOscarBookingInformationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CimCommonDBDAOOscarBookingInformationListRSQL").append("\n"); 
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
		query.append("SELECT	BB.APP_CD ," ).append("\n"); 
		query.append("	#if (${s_cntr_no} != '')" ).append("\n"); 
		query.append("        BC.CNMV_CYC_NO AS CNMV_CYC_NO," ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        BB.VSL_CD||BB.SKD_VOY_NO||BB.SKD_DIR_CD AS TVVD," ).append("\n"); 
		query.append("        BB.POR_CD POR_CD," ).append("\n"); 
		query.append("        BB.POL_CD POL_CD," ).append("\n"); 
		query.append("        BB.POD_CD POD_CD," ).append("\n"); 
		query.append("        BB.DEL_CD DEL_CD," ).append("\n"); 
		query.append("        BB.BKG_NO," ).append("\n"); 
		query.append("        BB.BL_NO," ).append("\n"); 
		query.append("        BB.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("		BB.SLAN_CD," ).append("\n"); 
		query.append("        BB.BKG_STS_CD," ).append("\n"); 
		query.append("        BB.RCV_TERM_CD," ).append("\n"); 
		query.append("        BB.DE_TERM_CD," ).append("\n"); 
		query.append("		NVL(TO_CHAR(BB.POL_ETD_DT, 'YYYY.MM.DD HH24:MI:SS'),'') AS POL_ETD_DT," ).append("\n"); 
		query.append("        TO_CHAR(NVL(BB.OSCA_CRE_DT, BB.CRE_DT), 'YYYY.MM.DD HH24:MI:SS') AS CRE_DT," ).append("\n"); 
		query.append("        TO_CHAR(NVL(BB.OSCAR_UPD_DT, BB.UPD_DT), 'YYYY.MM.DD HH24:MI:SS') AS UPD_DT       " ).append("\n"); 
		query.append("	FROM CIM_BOOKING_V BB" ).append("\n"); 
		query.append("	#if (${s_cntr_no} != '' && ${s_bkg_no} == '')" ).append("\n"); 
		query.append("       , CIM_BKG_CNTR_V BC" ).append("\n"); 
		query.append("	WHERE 1 = 1" ).append("\n"); 
		query.append("	AND   BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("    AND   BC.CNTR_NO = @[s_cntr_no]" ).append("\n"); 
		query.append("    #elseif (${s_cntr_no} == '' && ${s_bkg_no} != '')" ).append("\n"); 
		query.append("    WHERE  1 = 1" ).append("\n"); 
		query.append("	AND    BB.BKG_NO = @[s_bkg_no] " ).append("\n"); 
		query.append("	#elseif (${s_cntr_no} != '' && ${s_bkg_no} != '')" ).append("\n"); 
		query.append("       , CIM_BKG_CNTR_V BC" ).append("\n"); 
		query.append("	WHERE 1 = 1" ).append("\n"); 
		query.append("	AND   BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("    AND   BC.CNTR_NO = @[s_cntr_no]" ).append("\n"); 
		query.append("	AND    BB.BKG_NO = @[s_bkg_no] " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ORDER BY  TO_CHAR(NVL(BB.OSCA_CRE_DT, BB.CRE_DT), 'YYYY.MM.DD HH24:MI:SS')  DESC" ).append("\n"); 

	}
}