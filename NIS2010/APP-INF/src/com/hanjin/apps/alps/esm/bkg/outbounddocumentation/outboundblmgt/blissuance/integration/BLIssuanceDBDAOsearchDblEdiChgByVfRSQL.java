/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiChgByVfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.05
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.04.05 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiChgByVfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOsearchDblEdiChgByVfRSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiChgByVfRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiChgByVfRSQL").append("\n"); 
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
		query.append("SELECT '{CHARGE' || CHR(10) " ).append("\n"); 
		query.append("       || 'FCTYPE:' || CHG_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'RATE:' || CHG_UT_AMT || CHR(10) " ).append("\n"); 
		query.append("       || 'RATED_AS:' || RAT_AS_QTY || CHR(10) " ).append("\n"); 
		query.append("       || 'REVENUETON:' || RAT_AS_QTY || CHR(10) " ).append("\n"); 
		query.append("       || 'DIF_AMT:' || CHR(10) " ).append("\n"); 
		query.append("       || 'PPD:' || DECODE(CHG.FRT_TERM_CD, 'P', CHG_AMT, 0.0) || CHR(10) " ).append("\n"); 
		query.append("       || 'CCT:' || DECODE(CHG.FRT_TERM_CD, 'C', CHG_AMT, 0.0) || CHR(10) " ).append("\n"); 
		query.append("       || 'CURRENCYCODE:' || CURR_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'TARIFF:' || TRF_ITM_NO || CHR(10) " ).append("\n"); 
		query.append("       || 'PERTYPE:' || RAT_UT_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'EXRATE:' ||  (SELECT DECODE(SUBSTR(TO_CHAR(USD_XCH_RT),1,1), '.', '0'||TO_CHAR(USD_XCH_RT), TO_CHAR(USD_XCH_RT))" ).append("\n"); 
		query.append("                         FROM INV_AR_MN MN" ).append("\n"); 
		query.append("                         WHERE MN.LOCL_CURR_CD = CHG.CURR_CD" ).append("\n"); 
		query.append("                           AND CHG.CURR_CD <> 'USD'" ).append("\n"); 
		query.append("                           AND MN.AR_OFC_CD = MDM.AR_OFC_CD " ).append("\n"); 
		query.append("                           AND MN.BL_SRC_NO = CHG.BKG_NO" ).append("\n"); 
		query.append("                           AND (AR_OFC_CD, AR_IF_NO) IN (SELECT AR_OFC_CD, MAX(AR_IF_NO) --DISTINCT LOCL_CURR_CD,USD_XCH_RT " ).append("\n"); 
		query.append("                                                         FROM   INV_AR_MN IMN" ).append("\n"); 
		query.append("                                                         WHERE  1=1" ).append("\n"); 
		query.append("                                                           AND  IMN.AR_OFC_CD = MN.AR_OFC_CD" ).append("\n"); 
		query.append("                                                           AND  IMN.BL_SRC_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                           AND    NVL(IMN.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                                                           AND    IMN.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                                                         GROUP BY AR_OFC_CD" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                           AND ROWNUM = 1                                                         " ).append("\n"); 
		query.append("                        ) || CHR(10)                                                        " ).append("\n"); 
		query.append("       || 'FRT_IND:' || CHG.FRT_TERM_CD || CHR(10) " ).append("\n"); 
		query.append("       || '}CHARGE' || CHR(10)" ).append("\n"); 
		query.append("FROM   BKG_CHG_RT CHG, BKG_RATE RT , MDM_ORGANIZATION MDM  " ).append("\n"); 
		query.append("WHERE  CHG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CHG.FRT_INCL_XCLD_DIV_CD= 'N'" ).append("\n"); 
		query.append("AND    CHG.BKG_NO = RT.BKG_NO                                                                                                                           " ).append("\n"); 
		query.append("AND    MDM.OFC_CD = CASE WHEN CHG.N3PTY_RCV_OFC_CD IS NOT NULL THEN N3PTY_RCV_OFC_CD                                                                    " ).append("\n"); 
		query.append("                         WHEN CHG.N3PTY_RCV_OFC_CD IS NULL AND CHG.FRT_TERM_CD ='P' THEN PPD_RCV_OFC_CD                                                 " ).append("\n"); 
		query.append("                         WHEN CHG.N3PTY_RCV_OFC_CD IS NULL AND CHG.FRT_TERM_CD ='C' THEN CLT_OFC_CD                                                     " ).append("\n"); 
		query.append("                     ELSE ''                                                                                                                            " ).append("\n"); 
		query.append("                     END " ).append("\n"); 
		query.append("ORDER BY RT_SEQ" ).append("\n"); 

	}
}