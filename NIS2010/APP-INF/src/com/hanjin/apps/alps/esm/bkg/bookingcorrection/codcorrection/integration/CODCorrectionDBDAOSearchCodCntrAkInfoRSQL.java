/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CODCorrectionDBDAOSearchCodCntrAkInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.30
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.01.30 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOSearchCodCntrAkInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cod 대상 cntr의 awk 정보를 조회한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOSearchCodCntrAkInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOSearchCodCntrAkInfoRSQL").append("\n"); 
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
		query.append("SELECT COD_CNTR.CNTR_NO, " ).append("\n"); 
		query.append("      '1. Container SEQ : '|| ROWNUM || CASE WHEN ROWNUM = 1 THEN 'st'" ).append("\n"); 
		query.append("                                              WHEN ROWNUM = 2 THEN 'nd'" ).append("\n"); 
		query.append("                                              WHEN ROWNUM = 3 THEN 'rd'" ).append("\n"); 
		query.append("                                              ELSE 'th' END " ).append("\n"); 
		query.append("          || ' CNTR of '|| (SELECT COUNT(1) FROM BKG_AWK_CGO KNT WHERE AWK.BKG_NO = KNT.BKG_NO) || 'CNTR(s)' || '<BR>'" ).append("\n"); 
		query.append("    || '2. EQ Type/Size : ' || (SELECT CNTR_TPSZ_DESC FROM MDM_CNTR_TP_SZ A WHERE A.CNTR_TPSZ_CD = AWK.CNTR_TPSZ_CD) || '<BR>'" ).append("\n"); 
		query.append("    || '3. Commodity : '    || (SELECT CMDT_NM FROM MDM_COMMODITY CMDT WHERE CMDT.CMDT_CD = AWK.CMDT_CD) || '<BR>'" ).append("\n"); 
		query.append("    || '4. Gross Weight : ' || TRIM(TO_CHAR(AWK.GRS_WGT, '999,999,999,999.000')) || AWK.WGT_UT_CD || '<BR>'" ).append("\n"); 
		query.append("    || '5. Net Weight : '   || TRIM(TO_CHAR(AWK.NET_WGT, '999,999,999,999.000')) || AWK.WGT_UT_CD || '<BR>'" ).append("\n"); 
		query.append("    || '6. Overall Dimension(in cm): (Length x Width x Height) ' || '<BR>'" ).append("\n"); 
		query.append("    || '  1)Total: '   || TTL_DIM_LEN ||'X'|| TTL_DIM_WDT ||'X'|| TTL_DIM_HGT || '<BR>'" ).append("\n"); 
		query.append("    || '  2)Detail:  ' || " ).append("\n"); 
		query.append("            (SELECT BKG_JOIN_FNC(CURSOR(SELECT CHR(DIM_SEQ + 64) || '. ' " ).append("\n"); 
		query.append("                                            || DIM_LEN || 'X'|| DIM_WDT || 'X'|| DIM_HGT || ', ' || INDIV_PCK_WGT || AWK.WGT_UT_CD" ).append("\n"); 
		query.append("                                         FROM BKG_AWK_DIM DIM" ).append("\n"); 
		query.append("                                        WHERE DIM.BKG_NO = AWK.BKG_NO" ).append("\n"); 
		query.append("                                          AND DIM.AWK_CGO_SEQ = AWK.AWK_CGO_SEQ" ).append("\n"); 
		query.append("                                          AND DIM.AWK_CGO_SEQ > 1))" ).append("\n"); 
		query.append("    		  FROM DUAL) || '<BR>'" ).append("\n"); 
		query.append("    || '7. Over Dimension (in cm) : ' || '<BR>'" ).append("\n"); 
		query.append("    ||  '  1) Forward: '          || OVR_FWRD_LEN || '<BR>'" ).append("\n"); 
		query.append("    || '  2) After: '             || OVR_BKWD_LEN || '<BR>'" ).append("\n"); 
		query.append("    || '  3) Height: '            || OVR_HGT      || '<BR>'" ).append("\n"); 
		query.append("    || '  4) Left (Port Side): '  || OVR_LF_LEN   || '<BR>'" ).append("\n"); 
		query.append("    || '  5) Right (Starboard): ' || OVR_RT_LEN   || '<BR>'" ).append("\n"); 
		query.append("    || '8. Corner Post Status : ' || CASE WHEN CRN_PST_STS_CD = 'E' THEN 'Erect-No Extension'" ).append("\n"); 
		query.append("                                          WHEN CRN_PST_STS_CD = 'F' THEN 'FOLDING'" ).append("\n"); 
		query.append("                                          ELSE CRN_PST_STS_CD || ' Feet Extension' END || '<BR>'" ).append("\n"); 
		query.append("    || '9. Over Height after Extension : '  || XTD_OVR_QTY || '<BR>'" ).append("\n"); 
		query.append("    || '10. Special Stowage Requirement : ' || (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("                                                  FROM COM_INTG_CD_DTL CD, BKG_BOOKING BK" ).append("\n"); 
		query.append("                                                 WHERE INTG_CD_VAL_CTNT = BK.STWG_CD" ).append("\n"); 
		query.append("                                                   AND BK.BKG_NO = AWK.BKG_NO" ).append("\n"); 
		query.append("                                                   AND INTG_CD_ID = 'CD02146')||  '(' || STWG_RQST_DESC ||'))' || '<BR>'" ).append("\n"); 
		query.append("    || '11. Remarks : ' || DIFF_RMK" ).append("\n"); 
		query.append("	|| '<BR>'||'----------------------------------------------------------------------------------------------------------------------------'||'<BR>' AWK_INFO" ).append("\n"); 
		query.append("  FROM BKG_AWK_CGO AWK, BKG_COD_CNTR COD_CNTR" ).append("\n"); 
		query.append("WHERE AWK.BKG_NO  = COD_CNTR.BKG_NO" ).append("\n"); 
		query.append("  AND AWK.CNTR_NO = COD_CNTR.CNTR_NO" ).append("\n"); 
		query.append("  AND COD_CNTR.AWK_CGO_FLG  = 'Y'" ).append("\n"); 
		query.append("  AND COD_SLCT_FLG      	= 'Y'" ).append("\n"); 
		query.append("  AND @[bkg_no]       = cod_cntr.bkg_no" ).append("\n"); 
		query.append("  AND @[cod_rqst_seq]  = cod_cntr.cod_rqst_seq" ).append("\n"); 

	}
}