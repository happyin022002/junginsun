/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBkgCustCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.09
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.03.09 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchBkgCustCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBkgCustCntrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBkgCustCntrInfoRSQL").append("\n"); 
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
		query.append("#if (${sc_no} != '') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH VALID AS (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		PROP_NO," ).append("\n"); 
		query.append("        MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("	FROM PRI_SP_MN" ).append("\n"); 
		query.append("	WHERE PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("	GROUP BY PROP_NO" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("SELECT HDR.SC_NO," ).append("\n"); 
		query.append("       CUST.PROP_NO," ).append("\n"); 
		query.append("       CUST.AMDT_SEQ," ).append("\n"); 
		query.append("       CUST.PRC_CTRT_PTY_TP_CD," ).append("\n"); 
		query.append("       CUST.CUST_CNT_CD," ).append("\n"); 
		query.append("       CUST.CUST_SEQ," ).append("\n"); 
		query.append("	   (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = NVL(CUST.CUST_CNT_CD, 'xx') AND CUST_SEQ = CUST.CUST_SEQ AND DELT_FLG = 'N') AS CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       CUST_TP.PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("FROM VALID," ).append("\n"); 
		query.append("     PRI_SP_HDR HDR, " ).append("\n"); 
		query.append("     PRI_SP_MN MN," ).append("\n"); 
		query.append("     PRI_SP_CTRT_PTY CUST," ).append("\n"); 
		query.append("     PRI_SP_CTRT_CUST_TP CUST_TP" ).append("\n"); 
		query.append("WHERE HDR.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("  AND HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("  AND MN.PROP_NO = VALID.PROP_NO" ).append("\n"); 
		query.append("  AND MN.AMDT_SEQ = VALID.AMDT_SEQ" ).append("\n"); 
		query.append("  AND MN.PROP_NO = CUST.PROP_NO" ).append("\n"); 
		query.append("  AND MN.AMDT_SEQ = CUST.AMDT_SEQ" ).append("\n"); 
		query.append("  AND CUST.PRC_CTRT_PTY_TP_CD  = 'C'" ).append("\n"); 
		query.append("  AND CUST.PROP_NO = CUST_TP.PROP_NO" ).append("\n"); 
		query.append("  AND CUST.AMDT_SEQ = CUST_TP.AMDT_SEQ" ).append("\n"); 
		query.append("  AND CUST.PRC_CTRT_PTY_TP_CD = CUST_TP.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("  AND (CUST.CUST_CNT_CD, CUST.CUST_SEQ) NOT IN (SELECT ATTR_CTNT1 AS CUST_CNT_CD,ATTR_CTNT2 AS CUST_SEQ FROM BKG_HRD_CDG_CTNT WHERE	HRD_CDG_ID = 'BKG_DMY_CUST')" ).append("\n"); 
		query.append("#elseif (${rfa_no} != '') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH VALID AS (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		PROP_NO," ).append("\n"); 
		query.append("        MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("	FROM PRI_RP_MN" ).append("\n"); 
		query.append("    WHERE PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("  	GROUP BY PROP_NO" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("SELECT HDR.RFA_NO," ).append("\n"); 
		query.append("       MN.PROP_NO," ).append("\n"); 
		query.append("       MN.AMDT_SEQ," ).append("\n"); 
		query.append("       MN.CTRT_CUST_CNT_CD AS CUST_CNT_CD," ).append("\n"); 
		query.append("       MN.CTRT_CUST_SEQ AS CUST_SEQ," ).append("\n"); 
		query.append("	   ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = NVL(MN.CTRT_CUST_CNT_CD, 'xx') AND CUST_SEQ = MN.CTRT_CUST_SEQ AND DELT_FLG = 'N') AS CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       MN.PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("FROM VALID, PRI_RP_HDR HDR, PRI_RP_MN MN" ).append("\n"); 
		query.append("WHERE HDR.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("AND HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND MN.PROP_NO = VALID.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = VALID.AMDT_SEQ" ).append("\n"); 
		query.append("AND (MN.CTRT_CUST_CNT_CD, MN.CTRT_CUST_SEQ) NOT IN (SELECT ATTR_CTNT1 AS CUST_CNT_CD,ATTR_CTNT2 AS CUST_SEQ FROM BKG_HRD_CDG_CTNT WHERE	HRD_CDG_ID = 'BKG_DMY_CUST')" ).append("\n"); 
		query.append("#elseif (${taa_no} != '') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH VALID AS (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		TAA_PROP_NO," ).append("\n"); 
		query.append("        MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("	FROM PRI_TAA_MN" ).append("\n"); 
		query.append("  	WHERE CFM_FLG = 'Y'" ).append("\n"); 
		query.append("  	GROUP BY TAA_PROP_NO" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("SELECT HDR.TAA_NO," ).append("\n"); 
		query.append("       MN.TAA_PROP_NO," ).append("\n"); 
		query.append("       MN.AMDT_SEQ," ).append("\n"); 
		query.append("       MN.CTRT_CUST_CNT_CD AS CUST_CNT_CD," ).append("\n"); 
		query.append("       MN.CTRT_CUST_SEQ AS CUST_SEQ," ).append("\n"); 
		query.append("	  (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = NVL(MN.CTRT_CUST_CNT_CD, 'xx') AND CUST_SEQ = MN.CTRT_CUST_SEQ AND DELT_FLG = 'N') AS CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       MN.PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("FROM VALID, PRI_TAA_HDR HDR, PRI_TAA_MN MN" ).append("\n"); 
		query.append("WHERE HDR.TAA_NO = @[taa_no]" ).append("\n"); 
		query.append("AND HDR.TAA_PROP_NO = MN.TAA_PROP_NO" ).append("\n"); 
		query.append("AND MN.TAA_PROP_NO = VALID.TAA_PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = VALID.AMDT_SEQ" ).append("\n"); 
		query.append("AND (MN.CTRT_CUST_CNT_CD, MN.CTRT_CUST_SEQ) NOT IN (SELECT ATTR_CTNT1 AS CUST_CNT_CD,ATTR_CTNT2 AS CUST_SEQ FROM BKG_HRD_CDG_CTNT WHERE	HRD_CDG_ID = 'BKG_DMY_CUST')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}