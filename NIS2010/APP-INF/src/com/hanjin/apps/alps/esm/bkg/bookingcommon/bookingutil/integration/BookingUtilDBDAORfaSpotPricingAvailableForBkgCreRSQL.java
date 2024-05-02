/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAORfaSpotPricingAvailableForBkgCreRSQL.java
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

public class BookingUtilDBDAORfaSpotPricingAvailableForBkgCreRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDBDAORfaSpotPricingAvailableRSQL 와 같은 내용이나 인자를 달리 함
	  * </pre>
	  */
	public BookingUtilDBDAORfaSpotPricingAvailableForBkgCreRSQL(){
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
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAORfaSpotPricingAvailableForBkgCreRSQL").append("\n"); 
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
		query.append("SELECT NVL(( SELECT  'Y' " ).append("\n"); 
		query.append("             FROM    (" ).append("\n"); 
		query.append("                       SELECT PROP_OFC_CD" ).append("\n"); 
		query.append("                       FROM   PRI_RP_HDR  HD, " ).append("\n"); 
		query.append("                              PRI_RP_MN   MN" ).append("\n"); 
		query.append("                       WHERE  1=1" ).append("\n"); 
		query.append("                       AND    HD.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("                       AND    HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                       AND    MN.PROP_STS_CD ='A'" ).append("\n"); 
		query.append("                       AND    ( SELECT APPL_DT" ).append("\n"); 
		query.append("                                  FROM (" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("                                            SELECT 1 RANK, RT_APLY_DT APPL_DT " ).append("\n"); 
		query.append("                                              FROM BKG_RT_HIS R" ).append("\n"); 
		query.append("                                             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                			   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                                               AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("                                			UNION ALL" ).append("\n"); 
		query.append("                                			SELECT 2 RANK, RT_APLY_DT APPL_DT --RATE APPLICABLE" ).append("\n"); 
		query.append("                                              FROM BKG_RATE R" ).append("\n"); 
		query.append("                                             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                               AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("                                            UNION ALL" ).append("\n"); 
		query.append("                                            SELECT 3 RANK, SKD.VPS_ETD_DT APPL_DT --ONBOARD DATE" ).append("\n"); 
		query.append("                                              FROM BKG_VVD_HIS VVD, VSK_VSL_PORT_SKD SKD, BKG_BKG_HIS BK" ).append("\n"); 
		query.append("                                             WHERE BK.BKG_NO          = @[bkg_no] " ).append("\n"); 
		query.append("                                			   AND BK.CORR_NO 		  = 'TMP0000001'" ).append("\n"); 
		query.append("                                			   AND VVD.CORR_NO 		  = 'TMP0000001'" ).append("\n"); 
		query.append("                                               AND BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("                                               AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("                                               AND VVD.POL_CD         = BK.POL_CD" ).append("\n"); 
		query.append("                                               AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("                                               AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                               AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                               AND VVD.POL_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                               AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                            UNION ALL" ).append("\n"); 
		query.append("                                            SELECT 4 RANK, SKD.VPS_ETD_DT APPL_DT --ONBOARD DATE" ).append("\n"); 
		query.append("                                              FROM BKG_VVD VVD, VSK_VSL_PORT_SKD SKD, BKG_BOOKING BK" ).append("\n"); 
		query.append("                                             WHERE BK.BKG_NO          = @[bkg_no] " ).append("\n"); 
		query.append("                                               AND BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("                                               AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("                                               AND VVD.POL_CD         = BK.POL_CD" ).append("\n"); 
		query.append("                                               AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("                                               AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                               AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                               AND VVD.POL_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                               AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                            UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                            SELECT 5 RANK, SYSDATE APPL_DT" ).append("\n"); 
		query.append("                                              FROM DUAL" ).append("\n"); 
		query.append("                                             ORDER BY RANK )   " ).append("\n"); 
		query.append("                                        WHERE ROWNUM = 1" ).append("\n"); 
		query.append("                                    )   BETWEEN MN.EFF_DT - 0.0001 AND MN.EXP_DT + 0.9999 " ).append("\n"); 
		query.append("                       AND    MN.RFA_CTRT_TP_CD = 'G'" ).append("\n"); 
		query.append("                     ) PRI" ).append("\n"); 
		query.append("             WHERE   ROWNUM = 1" ).append("\n"); 
		query.append("             AND     (   ( PRI.PROP_OFC_CD = (SELECT OFC_CD " ).append("\n"); 
		query.append("                                                FROM MDM_SLS_REP" ).append("\n"); 
		query.append("                                               WHERE SREP_CD = @[ob_srep_cd]) ) --PROP_OFC 와 L.OFC 동일" ).append("\n"); 
		query.append("                      OR ( PRI.PROP_OFC_CD = (SELECT ORG.PRNT_OFC_CD " ).append("\n"); 
		query.append("                                                FROM MDM_SLS_REP REP, MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("                                               WHERE REP.SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("                                                 AND REP.OFC_CD  = ORG.OFC_CD  " ).append("\n"); 
		query.append("                                                 AND ROWNUM = 1) ) -- PROP_OFC 와 L.OFC 의 PRNT_OFC 동일" ).append("\n"); 
		query.append("                      OR ( PRI.PROP_OFC_CD IN (SELECT ATTR_CTNT1 " ).append("\n"); 
		query.append("											   FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append(" 											  WHERE HRD_CDG_ID = 'SPOT_VALID_EXPT') ) --2016.09.05 한진해운 긴급 사태에 따른 Validation 완화" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("             ),'N') OUTPUT_TEXT FROM DUAL" ).append("\n"); 

	}
}