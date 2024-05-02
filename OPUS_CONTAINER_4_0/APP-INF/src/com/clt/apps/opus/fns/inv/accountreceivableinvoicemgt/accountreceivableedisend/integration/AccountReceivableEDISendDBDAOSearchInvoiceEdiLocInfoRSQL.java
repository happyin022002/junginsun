/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchInvoiceEdiLocInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchInvoiceEdiLocInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceEdiLocInfo
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchInvoiceEdiLocInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchInvoiceEdiLocInfoRSQL").append("\n"); 
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
		query.append("SELECT '{LOC_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'LOC_TP_CD:' ||'R'|| CHR(10) " ).append("\n"); 
		query.append("       || 'LOC_NM:' || POR.LOC_NM || CHR(10) " ).append("\n"); 
		query.append("       || 'LOC_CD:' || BK.POR_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'CITY:' || POR.STE_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'STATE:' || POR.STE_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'ZIP:' || POR.ZIP_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'CNT_CD:' || POR.CNT_CD ||CHR(10) " ).append("\n"); 
		query.append("       || '{LOC_DATE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'DATE_TP_CD:' ||'ETD'|| CHR(10) " ).append("\n"); 
		query.append("       || 'DATE:' || (SELECT MIN(TO_CHAR(B.ESTM_DT, 'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH'))" ).append("\n"); 
		query.append("                      FROM SCE_COP_HDR A," ).append("\n"); 
		query.append("                           SCE_COP_DTL B," ).append("\n"); 
		query.append("                           BKG_BOOKING C" ).append("\n"); 
		query.append("                      WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("                      AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                      AND A.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                      AND A.BKG_NO = BK.BKG_NO                      " ).append("\n"); 
		query.append("                      AND B.ACT_CD = 'FOTMAD') || CHR(10) " ).append("\n"); 
		query.append("       || '}LOC_DATE_INFO' || CHR(10) " ).append("\n"); 
		query.append("	   || '{LOC_DATE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'DATE_TP_CD:' ||'ATD'|| CHR(10) " ).append("\n"); 
		query.append("       || 'DATE:' || (SELECT MIN(TO_CHAR(B.ACT_DT, 'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH'))" ).append("\n"); 
		query.append("                      FROM SCE_COP_HDR A," ).append("\n"); 
		query.append("                           SCE_COP_DTL B," ).append("\n"); 
		query.append("                           BKG_BOOKING C" ).append("\n"); 
		query.append("                      WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("                      AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                      AND A.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                      AND A.BKG_NO = BK.BKG_NO                      " ).append("\n"); 
		query.append("                      AND B.ACT_CD = 'FOTMAD') || CHR(10) " ).append("\n"); 
		query.append("       || '}LOC_DATE_INFO' || CHR(10)" ).append("\n"); 
		query.append("       || '}LOC_INFO' || CHR(10)" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK, MDM_LOCATION POR" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.POR_CD = POR.LOC_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '{LOC_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'LOC_TP_CD:' ||'L'|| CHR(10) " ).append("\n"); 
		query.append("       || 'LOC_NM:' || POL.LOC_NM || CHR(10) " ).append("\n"); 
		query.append("       || 'LOC_CD:' || BK.POL_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'CITY:' || POL.STE_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'STATE:' || POL.STE_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'ZIP:' || POL.ZIP_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'CNT_CD:' || POL.CNT_CD ||CHR(10) " ).append("\n"); 
		query.append("       || '{LOC_DATE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'DATE_TP_CD:' ||'ETD'|| CHR(10) " ).append("\n"); 
		query.append("       || 'DATE:' || (SELECT TO_CHAR(VPS_ETD_DT ,'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') FROM VSK_VSL_PORT_SKD VSK, BKG_VVD VVD, BKG_BOOKING B" ).append("\n"); 
		query.append("							WHERE BK.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("							AND B.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("							AND B.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("							AND B.POL_NOD_CD = VVD.POL_YD_CD" ).append("\n"); 
		query.append("							AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("							AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("							AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("							AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("							AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("							AND ROWNUM =1 ) || CHR(10) " ).append("\n"); 
		query.append("       || '}LOC_DATE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '{LOC_DATE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'DATE_TP_CD:' ||'ATD'|| CHR(10) " ).append("\n"); 
		query.append("       || 'DATE:' || (SELECT TO_CHAR(VPS_ETD_DT ,'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') FROM VSK_VSL_PORT_SKD VSK, BKG_VVD VVD, BKG_BOOKING B" ).append("\n"); 
		query.append("							WHERE BK.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("							AND B.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("							AND B.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("							AND B.POL_NOD_CD = VVD.POL_YD_CD" ).append("\n"); 
		query.append("							AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("							AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("							AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("							AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("							AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                            AND VSK.ACT_INP_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND VSK.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("							AND ROWNUM =1 ) || CHR(10) " ).append("\n"); 
		query.append("       || '}LOC_DATE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '}LOC_INFO' || CHR(10)" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK, MDM_LOCATION POL" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.POL_CD = POL.LOC_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '{LOC_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'LOC_TP_CD:' ||'D'|| CHR(10) " ).append("\n"); 
		query.append("       || 'LOC_NM:' || POD.LOC_NM || CHR(10) " ).append("\n"); 
		query.append("       || 'LOC_CD:' || BK.POD_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'CITY:' || POD.STE_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'STATE:' || POD.STE_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'ZIP:' || POD.ZIP_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'CNT_CD:' || POD.CNT_CD ||CHR(10) " ).append("\n"); 
		query.append("       || '{LOC_DATE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'DATE_TP_CD:' ||'ETA'|| CHR(10) " ).append("\n"); 
		query.append("       || 'DATE:' || (SELECT TO_CHAR(VPS_ETA_DT ,'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') FROM VSK_VSL_PORT_SKD VSK, BKG_VVD VVD, BKG_BOOKING B" ).append("\n"); 
		query.append("							WHERE BK.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("							AND B.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("							AND B.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("							AND B.POD_NOD_CD = VVD.POD_YD_CD" ).append("\n"); 
		query.append("							AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("							AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("							AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("							AND VVD.POD_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("							AND VVD.POD_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("							AND ROWNUM =1 ) || CHR(10) " ).append("\n"); 
		query.append("       || '}LOC_DATE_INFO' || CHR(10)" ).append("\n"); 
		query.append("	   || '{LOC_DATE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'DATE_TP_CD:' ||'ATA'|| CHR(10) " ).append("\n"); 
		query.append("       || 'DATE:' || (SELECT TO_CHAR(VPS_ETA_DT ,'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') FROM VSK_VSL_PORT_SKD VSK, BKG_VVD VVD, BKG_BOOKING B" ).append("\n"); 
		query.append("							WHERE BK.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("							AND B.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("							AND B.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("							AND B.POD_NOD_CD = VVD.POD_YD_CD" ).append("\n"); 
		query.append("							AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("							AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("							AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("							AND VVD.POD_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("							AND VVD.POD_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                            AND VSK.ACT_INP_FLG = 'Y'" ).append("\n"); 
		query.append("							AND ROWNUM =1 ) || CHR(10) " ).append("\n"); 
		query.append("       || '}LOC_DATE_INFO' || CHR(10)  " ).append("\n"); 
		query.append("       || '}LOC_INFO' || CHR(10)" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK, MDM_LOCATION POD" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.POD_CD = POD.LOC_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '{LOC_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'LOC_TP_CD:' ||'E'|| CHR(10) " ).append("\n"); 
		query.append("       || 'LOC_NM:' || DEL.LOC_NM || CHR(10) " ).append("\n"); 
		query.append("       || 'LOC_CD:' || BK.DEL_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'CITY:' || DEL.STE_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'STATE:' || DEL.STE_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'ZIP:' || DEL.ZIP_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'CNT_CD:' || DEL.CNT_CD ||CHR(10) " ).append("\n"); 
		query.append("       || '{LOC_DATE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'DATE_TP_CD:' ||'ETA'|| CHR(10) " ).append("\n"); 
		query.append("       || 'DATE:' || (SELECT MAX(TO_CHAR(B.ESTM_DT, 'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH'))   " ).append("\n"); 
		query.append("                      FROM SCE_COP_HDR A," ).append("\n"); 
		query.append("                           SCE_COP_DTL B," ).append("\n"); 
		query.append("                           BKG_BOOKING C" ).append("\n"); 
		query.append("                      WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("                      AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                      AND A.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                      AND A.BKG_NO = BK.BKG_NO                  " ).append("\n"); 
		query.append("                      AND B.ACT_CD = DECODE(C.DE_TERM_CD, 'Y', 'FITMDO', 'FITZAD')) || CHR(10) " ).append("\n"); 
		query.append("       || '}LOC_DATE_INFO' || CHR(10) " ).append("\n"); 
		query.append("	   || '{LOC_DATE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'DATE_TP_CD:' ||'ATA'|| CHR(10) " ).append("\n"); 
		query.append("       || 'DATE:' || (SELECT MAX(TO_CHAR(B.ACT_DT, 'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH'))   " ).append("\n"); 
		query.append("                      FROM SCE_COP_HDR A," ).append("\n"); 
		query.append("                           SCE_COP_DTL B," ).append("\n"); 
		query.append("                           BKG_BOOKING C" ).append("\n"); 
		query.append("                      WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("                      AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                      AND A.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                      AND A.BKG_NO = BK.BKG_NO                  " ).append("\n"); 
		query.append("                      AND B.ACT_CD = DECODE(C.DE_TERM_CD, 'Y', 'FITMDO', 'FITZAD')) || CHR(10) " ).append("\n"); 
		query.append("       || '}LOC_DATE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '}LOC_INFO' || CHR(10)" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK, MDM_LOCATION DEL" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.DEL_CD = DEL.LOC_CD" ).append("\n"); 

	}
}