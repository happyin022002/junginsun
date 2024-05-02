/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchCaRsnRmkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchCaRsnRmkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchCaRsnRmkRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchCaRsnRmkRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchCaRsnRmkRSQL").append("\n"); 
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
		query.append("SELECT BC.CA_RSN_CD                      AS CA_RSN_CD," ).append("\n"); 
		query.append("       BC.BKG_CORR_RMK                   AS BKG_CORR_RMK," ).append("\n"); 
		query.append("       NVL(BC.RDN_NO,   BRDN.RDN_NO)     AS RDN_NO," ).append("\n"); 
		query.append("       NVL(BC.RVIS_SEQ, BRDN.RVIS_SEQ)   AS RVIS_SEQ," ).append("\n"); 
		query.append("       NVL(BC.RDN_ACPT_FLG, 'N')         AS RDN_ACPT_FLG,     " ).append("\n"); 
		query.append("       BRDN.UMCH_TP_CD                   AS UMCH_TP_CD,        " ).append("\n"); 
		query.append("       NVL(BC.UMCH_SUB_TP_CD, BRDN.UMCH_SUB_TP_CD) AS UMCH_SUB_TP_CD_HID,    " ).append("\n"); 
		query.append("       BC.UMCH_SUB_TP_CD                 AS UMCH_SUB_TP_CD," ).append("\n"); 
		query.append("       NVL(( SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("               FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("              WHERE INTG_CD_VAL_CTNT = NVL(BRDN.RDN_STS_CD,' ') " ).append("\n"); 
		query.append("         		AND INTG_CD_ID = 'CD01568'    " ).append("\n"); 
		query.append("                AND APLY_ST_DT  <= TO_CHAR(SYSDATE, 'YYYYMMDD') " ).append("\n"); 
		query.append("                AND APLY_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD')), 'NOT ISSUED') AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("     , BRDN.RDN_STS_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING    BKG,  " ).append("\n"); 
		query.append("       BKG_CORRECTION BC, " ).append("\n"); 
		query.append("       ( SELECT R.BKG_NO, " ).append("\n"); 
		query.append("                R.RDN_NO, " ).append("\n"); 
		query.append("                R.RVIS_SEQ, " ).append("\n"); 
		query.append("                R.RDN_STS_CD," ).append("\n"); 
		query.append("                T.UMCH_TP_DESC AS UMCH_TP_CD," ).append("\n"); 
		query.append("                R.UMCH_SUB_TP_CD" ).append("\n"); 
		query.append("           FROM BKG_REV_DR_NOTE R, BKG_REV_UMCH_TP T" ).append("\n"); 
		query.append("          WHERE R.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND R.RDN_KND_CD = 'C'" ).append("\n"); 
		query.append("            AND R.RDN_STS_CD IN ( 'RV','IS' ) " ).append("\n"); 
		query.append("            AND R.UMCH_TP_CD = T.UMCH_TP_CD) BRDN " ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO    = BRDN.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO    = BC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BC.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("   AND BKG.BKG_NO    = @[bkg_no]" ).append("\n"); 

	}
}