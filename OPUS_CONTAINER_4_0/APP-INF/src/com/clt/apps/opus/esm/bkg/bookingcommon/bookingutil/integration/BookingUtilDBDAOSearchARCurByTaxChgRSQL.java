/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOSearchARCurByTaxChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchARCurByTaxChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search AR Curency (Booking, TAX Charge)
	  * </pre>
	  */
	public BookingUtilDBDAOSearchARCurByTaxChgRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchARCurByTaxChgRSQL").append("\n"); 
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
		query.append("SELECT MC.CHG_CD," ).append("\n"); 
		query.append("       CASE WHEN MC.TAX_CNT_CD IS NULL THEN P_AR_OFC.AR_CURR_CD" ).append("\n"); 
		query.append("            WHEN SUBSTR(P_AR_OFC.LOC_CD,1,2) = MC.TAX_CNT_CD THEN P_AR_OFC.AR_CURR_CD" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END PRE_CURR," ).append("\n"); 
		query.append("       CASE WHEN MC.TAX_CNT_CD IS NULL THEN C_AR_OFC.AR_CURR_CD" ).append("\n"); 
		query.append("            WHEN SUBSTR(C_AR_OFC.LOC_CD,1,2) = MC.TAX_CNT_CD THEN C_AR_OFC.AR_CURR_CD" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END COL_CURR" ).append("\n"); 
		query.append("FROM BKG_RATE R," ).append("\n"); 
		query.append("     MDM_ORGANIZATION P_OFC," ).append("\n"); 
		query.append("     MDM_ORGANIZATION P_AR_OFC," ).append("\n"); 
		query.append("     MDM_ORGANIZATION C_OFC," ).append("\n"); 
		query.append("     MDM_ORGANIZATION C_AR_OFC," ).append("\n"); 
		query.append("     MDM_CHARGE MC" ).append("\n"); 
		query.append("WHERE R.PPD_RCV_OFC_CD = P_OFC.OFC_CD" ).append("\n"); 
		query.append("AND P_OFC.AR_OFC_CD = P_AR_OFC.OFC_CD" ).append("\n"); 
		query.append("AND R.CLT_OFC_CD = C_OFC.OFC_CD" ).append("\n"); 
		query.append("AND C_OFC.AR_OFC_CD = C_AR_OFC.OFC_CD" ).append("\n"); 
		query.append("AND R.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if(${chg_cds} != '')" ).append("\n"); 
		query.append("AND MC.CHG_CD IN ( NULL" ).append("\n"); 
		query.append("       #foreach($chg_cds IN ${chg_cds})" ).append("\n"); 
		query.append("           #if ($velocityCount < $tchg_cds.size()) " ).append("\n"); 
		query.append("           , '$chg_cds'" ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("           , '$chg_cds'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND MC.TAX_FLG = 'Y'" ).append("\n"); 

	}
}