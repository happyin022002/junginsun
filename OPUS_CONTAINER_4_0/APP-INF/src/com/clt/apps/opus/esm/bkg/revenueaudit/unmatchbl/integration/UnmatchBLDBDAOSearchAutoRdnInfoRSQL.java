/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchAutoRdnInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.03.07 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author taekyoung.kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOSearchAutoRdnInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkTaaSurchargeDiscrepancyDetail
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchAutoRdnInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchAutoRdnInfoRSQL").append("\n"); 
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
		query.append("SELECT B.BL_NO" ).append("\n"); 
		query.append("      ,B.BKG_NO" ).append("\n"); 
		query.append("      ,(SELECT OFC_CD FROM MDM_OFC_GRP_MAPG" ).append("\n"); 
		query.append("		WHERE OFC_GRP_ID ='000002'" ).append("\n"); 
		query.append("		  AND SUB_SYS_CD ='BKG') AS ISS_OFC_CD" ).append("\n"); 
		query.append("      ,O.AR_HD_QTR_OFC_CD AS RCT_RHQ_CD" ).append("\n"); 
		query.append("      ,B.BKG_OFC_CD AS RCT_OFC_CD" ).append("\n"); 
		query.append("      ,O.AR_HD_QTR_OFC_CD AS RESPB_RHQ_CD" ).append("\n"); 
		query.append("      ,B.BKG_OFC_CD AS RESPB_OFC_CD" ).append("\n"); 
		query.append("      ,'D' AS UMCH_TP_CD" ).append("\n"); 
		query.append("      ,'' AS UMCH_SUB_TP_CD" ).append("\n"); 
		query.append("      ,'3' AS RDN_ISS_RSN_CD" ).append("\n"); 
		query.append("      ,DECODE(R.BKG_CTRT_TP_CD, 'S', B.SC_NO" ).append("\n"); 
		query.append("                              , 'R', B.RFA_NO" ).append("\n"); 
		query.append("                              , 'T', B.TAA_NO) AS SC_RFA_NO" ).append("\n"); 
		query.append("      ,'1' AS REV_AUD_TOOL_CD" ).append("\n"); 
		query.append("      ,'' AS RDN_RMK" ).append("\n"); 
		query.append("      ,TO_CHAR(SYSDATE, 'YYYYMMDD') AS RDN_ISS_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(SYSDATE, 'IW') AS RDN_ISS_DT_WK" ).append("\n"); 
		query.append("  FROM BKG_BOOKING B" ).append("\n"); 
		query.append("      ,BKG_BL_DOC D" ).append("\n"); 
		query.append("      ,BKG_REV_UMCH_ITM UMCH" ).append("\n"); 
		query.append("      ,BKG_RATE R" ).append("\n"); 
		query.append("      ,MDM_ORGANIZATION O" ).append("\n"); 
		query.append(" WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("   AND D.BDR_FLG = 'Y'" ).append("\n"); 
		query.append("   AND B.BKG_NO = UMCH.BKG_NO" ).append("\n"); 
		query.append("   AND UMCH.UMCH_TP_CD = 'D'" ).append("\n"); 
		query.append("   AND UMCH.UMCH_BKG_SEQ = (SELECT MAX(UMCH_BKG_SEQ) FROM BKG_REV_UMCH_ITM WHERE BKG_NO=UMCH.BKG_NO)" ).append("\n"); 
		query.append("   AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("   AND O.OFC_CD = B.BKG_OFC_CD" ).append("\n"); 
		query.append("   AND NOT EXISTS (" ).append("\n"); 
		query.append("                   SELECT RDN_NO" ).append("\n"); 
		query.append("                     FROM (" ).append("\n"); 
		query.append("                           SELECT RDN_NO    " ).append("\n"); 
		query.append("                                 ,RDN_STS_CD" ).append("\n"); 
		query.append("                             FROM BKG_REV_DR_NOTE A" ).append("\n"); 
		query.append("                            WHERE BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("                              AND NOT EXISTS  (" ).append("\n"); 
		query.append("                                               SELECT 'X'" ).append("\n"); 
		query.append("                                                 FROM BKG_REV_DR_NOTE B" ).append("\n"); 
		query.append("                                                WHERE B.RDN_NO    = A.RDN_NO" ).append("\n"); 
		query.append("                                                  AND B.RVIS_SEQ  > A.RVIS_SEQ" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                    WHERE RDN_STS_CD  NOT IN ( 'ST', 'CL' )" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("   AND D.BDR_DT + 2 < GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(B.BKG_OFC_CD)" ).append("\n"); 

	}
}