/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAORfaSpotPricingAvailableRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAORfaSpotPricingAvailableRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RfaSpotPricingAvailable
	  * </pre>
	  */
	public BookingUtilDBDAORfaSpotPricingAvailableRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAORfaSpotPricingAvailableRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN PROP_OFC_CD IN (SELECT ATTR_CTNT1 " ).append("\n"); 
		query.append("								   FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append(" 								  WHERE HRD_CDG_ID = 'SPOT_VALID_EXPT') THEN 'Y'" ).append("\n"); 
		query.append("            ELSE DECODE(PROP_OFC_CD, OB_SLS_OFC_CD, 'Y', PRNT_OFC_CD, 'Y', 'N') END OUTPUT_TEXT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("            SELECT  MAX(PROP_OFC_CD) PROP_OFC_CD, MAX(OB_SLS_OFC_CD) OB_SLS_OFC_CD, MAX(PRNT_OFC_CD) PRNT_OFC_CD" ).append("\n"); 
		query.append("            FROM    (" ).append("\n"); 
		query.append("                      SELECT PROP_OFC_CD," ).append("\n"); 
		query.append("                             '' OB_SLS_OFC_CD," ).append("\n"); 
		query.append("                             '' PRNT_OFC_CD" ).append("\n"); 
		query.append("                      FROM   PRI_RP_HDR  HD, " ).append("\n"); 
		query.append("                             PRI_RP_MN   MN" ).append("\n"); 
		query.append("                      WHERE  1=1" ).append("\n"); 
		query.append("                      AND    HD.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("                      AND    HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                      AND    MN.PROP_STS_CD ='A'" ).append("\n"); 
		query.append("                      AND    TO_DATE(@[date],'YYYYMMDD') BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("                      AND    MN.RFA_CTRT_TP_CD = 'G'" ).append("\n"); 
		query.append("                      AND    ROWNUM =1" ).append("\n"); 
		query.append("                      UNION ALL                          " ).append("\n"); 
		query.append("                      SELECT '' PROP_OFC_CD, " ).append("\n"); 
		query.append("                             OB_SLS_OFC_CD, " ).append("\n"); 
		query.append("                             '' PRNT_OFC_CD" ).append("\n"); 
		query.append("                      FROM   BKG_BOOKING" ).append("\n"); 
		query.append("                      WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                      UNION ALL  " ).append("\n"); 
		query.append("                      SELECT '' PROP_OFC_CD," ).append("\n"); 
		query.append("                             '' OB_SLS_OFC_CD," ).append("\n"); 
		query.append("                             ORG.PRNT_OFC_CD" ).append("\n"); 
		query.append("                      FROM   BKG_BOOKING BK, MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("                      WHERE  BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                      AND    BK.OB_SLS_OFC_CD = ORG.OFC_CD" ).append("\n"); 
		query.append("                      AND    ROWNUM = 1" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}