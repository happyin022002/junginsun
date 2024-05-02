/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchNoRateNoticeToCustomerBlockRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchNoRateNoticeToCustomerBlockRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer 에게 보내는 No Rate Notice 를 Block 하는 조건에 해당 하는 지를 조회한다
	  * - 미주발 BKG인 경우, ETB 까지 8주 이상 남았을 때는 발송하지 않음
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchNoRateNoticeToCustomerBlockRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchNoRateNoticeToCustomerBlockRSQL").append("\n"); 
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
		query.append("SELECT NTC_BLCK " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("         SELECT 'Y' NTC_BLCK -- 미주 경우 ETB 까지 8주 이상 남았으면 BLOCK" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                  SELECT VPS.VPS_ETB_DT, BK.POL_CD" ).append("\n"); 
		query.append("                    FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                       , BKG_VVD VVD" ).append("\n"); 
		query.append("                       , BKG_BOOKING BK" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                     AND VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                     AND VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     AND VVD.POL_CD = VPS.VPS_PORT_CD " ).append("\n"); 
		query.append("                     AND VVD.VSL_CD = VPS.VSL_CD " ).append("\n"); 
		query.append("                     AND VVD.SKD_VOY_NO = VPS.SKD_VOY_NO " ).append("\n"); 
		query.append("                     AND VVD.SKD_DIR_CD = VPS.SKD_DIR_CD " ).append("\n"); 
		query.append("                     AND VVD.POL_CLPT_IND_SEQ = VPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     AND VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ = (SELECT MIN(BV.VSL_PRE_PST_CD || BV.VSL_SEQ) " ).append("\n"); 
		query.append("                                                                FROM BKG_VVD BV" ).append("\n"); 
		query.append("                                                               WHERE BV.BKG_NO = VVD.BKG_NO)" ).append("\n"); 
		query.append("                     AND ROWNUM = 1" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          WHERE VPS_ETB_DT - SYSDATE > 56                " ).append("\n"); 
		query.append("            AND SUBSTR(POL_CD,1,2) IN ('US','CA')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         SELECT 'Y' NTC_BLCK -- 미주 경우 첫배 ETB NULL 이면 BLOCK" ).append("\n"); 
		query.append("           FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("          WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND SUBSTR(POL_CD,1,2) IN ('US','CA')       " ).append("\n"); 
		query.append("            AND (" ).append("\n"); 
		query.append("                  SELECT VPS.VPS_ETB_DT" ).append("\n"); 
		query.append("                    FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                       , BKG_VVD VVD" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                     AND VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                     AND VVD.POL_CD = VPS.VPS_PORT_CD " ).append("\n"); 
		query.append("                     AND VVD.VSL_CD = VPS.VSL_CD " ).append("\n"); 
		query.append("                     AND VVD.SKD_VOY_NO = VPS.SKD_VOY_NO " ).append("\n"); 
		query.append("                     AND VVD.SKD_DIR_CD = VPS.SKD_DIR_CD " ).append("\n"); 
		query.append("                     AND VVD.POL_CLPT_IND_SEQ = VPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     AND VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ = (SELECT MIN(BV.VSL_PRE_PST_CD || BV.VSL_SEQ) " ).append("\n"); 
		query.append("                                                                FROM BKG_VVD BV" ).append("\n"); 
		query.append("                                                               WHERE BV.BKG_NO = VVD.BKG_NO)" ).append("\n"); 
		query.append("                     AND ROWNUM = 1" ).append("\n"); 
		query.append("                ) IS NULL          " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         SELECT 'Y' NTC_BLCK -- NoRate 아니면 BLOCK" ).append("\n"); 
		query.append("           FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("          WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND NVL(BK.NON_RT_STS_CD,'F') <> 'R'" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         SELECT 'Y' NTC_BLCK -- 발송 된 적 있으면 BLOCK" ).append("\n"); 
		query.append("           FROM BKG_DOC_PROC_SKD PROC" ).append("\n"); 
		query.append("          WHERE PROC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND PROC.BKG_DOC_PROC_TP_CD = 'NORTNC'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         SELECT 'Y' NTC_BLCK -- 발송 된 적 있으면 BLOCK 보완 (임시)" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("          WHERE ( SELECT COUNT(1)            " ).append("\n"); 
		query.append("                    FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     AND NTC_VIA_CD = 'M'" ).append("\n"); 
		query.append("                     AND NTC_KND_CD = 'NR' ) > 1" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         SELECT 'Y' NTC_BLCK -- C/A 면 BLOCK" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("          WHERE 'Y' = NVL(@[ca_flg],'N')  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE ROWNUM = 1" ).append("\n"); 

	}
}