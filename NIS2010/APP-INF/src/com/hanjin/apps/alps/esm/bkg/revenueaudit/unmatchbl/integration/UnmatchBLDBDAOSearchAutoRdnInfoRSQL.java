/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchAutoRdnInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * 
	  * Non-Charged RDN의 Resp. OFC 지정 로직을 보완
	  * - OFT Rating 가능한 운임이 존재하는경우 : BKG or Rating OFC(DPCS 대상인 경우)
	  * - OFT Rating 가능한 운임이 없는경우 : Contract OFC
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
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
		query.append("SELECT BL_NO, BKG_NO, ISS_OFC_CD, RCT_RHQ_CD, RCT_OFC_CD, RESPB_OFC_CD," ).append("\n"); 
		query.append("       (SELECT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = RESPB_OFC_CD) AS RESPB_RHQ_CD," ).append("\n"); 
		query.append("       UMCH_TP_CD, UMCH_SUB_TP_CD, RDN_ISS_RSN_CD, SC_RFA_NO," ).append("\n"); 
		query.append("       REV_AUD_TOOL_CD, RDN_RMK, RDN_ISS_DT, RDN_ISS_DT_WK, RDN_KND_CD" ).append("\n"); 
		query.append("FROM (   " ).append("\n"); 
		query.append("        SELECT B.BL_NO" ).append("\n"); 
		query.append("              ,B.BKG_NO" ).append("\n"); 
		query.append("              ,'PKGSA' AS ISS_OFC_CD" ).append("\n"); 
		query.append("              ,O.AR_HD_QTR_OFC_CD AS RCT_RHQ_CD" ).append("\n"); 
		query.append("              ,B.BKG_OFC_CD AS RCT_OFC_CD" ).append("\n"); 
		query.append("              ,DECODE(R.OFT_MSS_FLG, 'Y', B.CTRT_OFC_CD, " ).append("\n"); 
		query.append("                                          NVL((SELECT DPCS_OFC_CD " ).append("\n"); 
		query.append("                                               FROM BKG_SR_CRNT_RQST " ).append("\n"); 
		query.append("                                               WHERE BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("                                               AND ROWNUM = 1),B.BKG_OFC_CD)) AS RESPB_OFC_CD" ).append("\n"); 
		query.append("              ,'D' AS UMCH_TP_CD" ).append("\n"); 
		query.append("              ,'' AS UMCH_SUB_TP_CD" ).append("\n"); 
		query.append("              ,'8' AS RDN_ISS_RSN_CD" ).append("\n"); 
		query.append("              ,DECODE(R.BKG_CTRT_TP_CD, 'S', B.SC_NO" ).append("\n"); 
		query.append("                                      , 'R', B.RFA_NO" ).append("\n"); 
		query.append("                                      , 'T', B.TAA_NO) AS SC_RFA_NO" ).append("\n"); 
		query.append("              ,'1' AS REV_AUD_TOOL_CD" ).append("\n"); 
		query.append("              ,'' AS RDN_RMK" ).append("\n"); 
		query.append("              ,TO_CHAR(SYSDATE, 'YYYYMMDD') AS RDN_ISS_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(SYSDATE, 'IW') AS RDN_ISS_DT_WK" ).append("\n"); 
		query.append("              ,'C' RDN_KND_CD  -- BDR_FLG 가 Y인 BKG만 대상이기 때문에 RDN Kind는 C로 고정" ).append("\n"); 
		query.append("          FROM BKG_BOOKING B" ).append("\n"); 
		query.append("              ,BKG_BL_DOC D" ).append("\n"); 
		query.append("              ,BKG_REV_UMCH_ITM UMCH" ).append("\n"); 
		query.append("              ,BKG_RATE R" ).append("\n"); 
		query.append("              ,MDM_ORGANIZATION O" ).append("\n"); 
		query.append("         WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("           AND D.BDR_FLG = 'Y'" ).append("\n"); 
		query.append("           AND B.BKG_NO = UMCH.BKG_NO" ).append("\n"); 
		query.append("           AND UMCH.UMCH_TP_CD = 'D'" ).append("\n"); 
		query.append("           AND UMCH.UMCH_BKG_SEQ = (SELECT MAX(UMCH_BKG_SEQ) FROM BKG_REV_UMCH_ITM WHERE BKG_NO=UMCH.BKG_NO)" ).append("\n"); 
		query.append("           AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("           AND O.OFC_CD = B.BKG_OFC_CD" ).append("\n"); 
		query.append("           AND NOT EXISTS (" ).append("\n"); 
		query.append("                           SELECT RDN_NO" ).append("\n"); 
		query.append("                             FROM (" ).append("\n"); 
		query.append("                                   SELECT RDN_NO    " ).append("\n"); 
		query.append("                                         ,RDN_STS_CD" ).append("\n"); 
		query.append("                                     FROM BKG_REV_DR_NOTE A" ).append("\n"); 
		query.append("                                    WHERE BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("                                      AND NOT EXISTS  (" ).append("\n"); 
		query.append("                                                       SELECT 'X'" ).append("\n"); 
		query.append("                                                         FROM BKG_REV_DR_NOTE B" ).append("\n"); 
		query.append("                                                        WHERE B.RDN_NO    = A.RDN_NO" ).append("\n"); 
		query.append("                                                          AND B.RVIS_SEQ  > A.RVIS_SEQ" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                            WHERE RDN_STS_CD  NOT IN ( 'ST', 'CL' )" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("           --AND D.BDR_DT + 2 < GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(B.BKG_OFC_CD)" ).append("\n"); 
		query.append("           AND DECODE(B.SPLIT_FLG, 'Y', B.PORT_CLZ_DT + 2, B.PORT_CLZ_DT) < GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(B.BKG_OFC_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}