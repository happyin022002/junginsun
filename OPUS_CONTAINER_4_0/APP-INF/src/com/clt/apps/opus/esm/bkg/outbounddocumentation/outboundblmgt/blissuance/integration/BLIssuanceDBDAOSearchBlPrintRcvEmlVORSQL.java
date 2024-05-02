/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBlPrintRcvEmlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchBlPrintRcvEmlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssueanceDBDAOSearchBlPrintRcvEml
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBlPrintRcvEmlVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBlPrintRcvEmlVORSQL").append("\n"); 
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
		query.append("SELECT LISTAGG(USR_EML, ';') WITHIN GROUP (ORDER BY USR_EML) AS USR_EML" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT DISTINCT GRP.BL_GRP_SEQ, GRP.BL_VW_RT_TP_CD, UI.USR_EML" ).append("\n"); 
		query.append("    FROM  BKG_BL_ISS BI" ).append("\n"); 
		query.append("          ,BKG_INET_BL_CTRL_PTY CP" ).append("\n"); 
		query.append("          ,BKG_CTRL_PTY_BL_GRP GRP" ).append("\n"); 
		query.append("          ,BKG_CTRL_BL_GRP_CUST BL" ).append("\n"); 
		query.append("          ,BKG_XTER_USR_INFO UI" ).append("\n"); 
		query.append("    WHERE BI.INET_CTRL_PTY_NM = CP.CUST_CNT_CD" ).append("\n"); 
		query.append("    AND   BI.INET_CTRL_PTY_NO = CP.CUST_SEQ" ).append("\n"); 
		query.append("    AND   CP.CTRL_PTY_SEQ = GRP.CTRL_PTY_SEQ" ).append("\n"); 
		query.append("#if (${eml_flg} == 'IAU')" ).append("\n"); 
		query.append("    AND   GRP.NTFY_PRN_FLG = 'Y'" ).append("\n"); 
		query.append("    AND   UI.RDY_FO_PRN_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${eml_flg} == 'SWM')" ).append("\n"); 
		query.append("    AND   GRP.NTFY_PRN_FLG = 'Y'" ).append("\n"); 
		query.append("    AND   UI.RDY_FO_PRN_FLG = 'Y'" ).append("\n"); 
		query.append("    AND   (GRP.NTFY_AUTO_WBL_FLG <> 'Y' OR   UI.SEA_WBL_EML_FLG <> 'Y')" ).append("\n"); 
		query.append("#elseif (${eml_flg} == 'SWA')" ).append("\n"); 
		query.append("    AND   GRP.NTFY_AUTO_WBL_FLG = 'Y'" ).append("\n"); 
		query.append("    AND   UI.SEA_WBL_EML_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND   GRP.BL_GRP_SEQ = BL.BL_GRP_SEQ" ).append("\n"); 
		query.append("    AND   UI.BL_GRP_SEQ = GRP.BL_GRP_SEQ" ).append("\n"); 
		query.append("    AND   BI.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND   UI.CUST_CNT_CD = BL.CUST_CNT_CD" ).append("\n"); 
		query.append("	AND   UI.CUST_SEQ = BL.CUST_SEQ" ).append("\n"); 
		query.append("	AND   UI.USR_STS_CD IN ('CF','CR','RU') " ).append("\n"); 
		query.append("    AND   NOT EXISTS (SELECT 'X' FROM BKG_XTER_USR_EML_SUBSC_CNT CNT WHERE UI.USR_ID = CNT.USR_ID)" ).append("\n"); 
		query.append("    AND   NOT EXISTS (SELECT 'X' FROM BKG_XTER_USR_EML_SUBSC_LOC LOC WHERE UI.USR_ID = LOC.USR_ID)" ).append("\n"); 
		query.append("    AND   EXISTS (SELECT 'X' FROM BKG_CTRL_BL_GRP_CUST BCBG " ).append("\n"); 
		query.append("                  WHERE BCBG.BL_GRP_SEQ = BL.BL_GRP_SEQ " ).append("\n"); 
		query.append("                     AND BCBG.CUST_CNT_CD||BCBG.CUST_SEQ IN (SELECT BC.CUST_CNT_CD||BC.CUST_SEQ FROM BKG_CUSTOMER BC WHERE BC.BKG_NO = @[bkg_no] AND BC.BKG_CUST_TP_CD IN ('S','C','N','F')" ).append("\n"); 
		query.append("															  UNION ALL SELECT BB.BKG_PTY_CUST_CNT_CD||BB.BKG_PTY_CUST_SEQ FROM BKG_BOOKING BB WHERE BB.BKG_NO = @[bkg_no] AND BKG_PTY_CUST_CNT_CD > ' '" ).append("\n"); 
		query.append("															)" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("    UNION " ).append("\n"); 
		query.append("    SELECT DISTINCT GRP.BL_GRP_SEQ, GRP.BL_VW_RT_TP_CD, UI.USR_EML" ).append("\n"); 
		query.append("    FROM  BKG_BL_ISS BI" ).append("\n"); 
		query.append("          ,BKG_INET_BL_CTRL_PTY CP" ).append("\n"); 
		query.append("          ,BKG_CTRL_PTY_BL_GRP GRP" ).append("\n"); 
		query.append("          ,BKG_CTRL_BL_GRP_CUST BL" ).append("\n"); 
		query.append("          ,BKG_XTER_USR_INFO UI" ).append("\n"); 
		query.append("          ,BKG_BOOKING BB" ).append("\n"); 
		query.append("    WHERE BI.INET_CTRL_PTY_NM = CP.CUST_CNT_CD" ).append("\n"); 
		query.append("    AND   BI.INET_CTRL_PTY_NO = CP.CUST_SEQ" ).append("\n"); 
		query.append("    AND   CP.CTRL_PTY_SEQ = GRP.CTRL_PTY_SEQ" ).append("\n"); 
		query.append("#if (${eml_flg} == 'IAU')" ).append("\n"); 
		query.append("    AND   GRP.NTFY_PRN_FLG = 'Y'" ).append("\n"); 
		query.append("    AND   UI.RDY_FO_PRN_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${eml_flg} == 'SWM')" ).append("\n"); 
		query.append("    AND   GRP.NTFY_PRN_FLG = 'Y'" ).append("\n"); 
		query.append("    AND   UI.RDY_FO_PRN_FLG = 'Y'" ).append("\n"); 
		query.append("    AND   (GRP.NTFY_AUTO_WBL_FLG <> 'Y' OR  UI.SEA_WBL_EML_FLG <> 'Y')" ).append("\n"); 
		query.append("#elseif (${eml_flg} == 'SWA')" ).append("\n"); 
		query.append("    AND   GRP.NTFY_AUTO_WBL_FLG = 'Y'" ).append("\n"); 
		query.append("    AND   UI.SEA_WBL_EML_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND   GRP.BL_GRP_SEQ = BL.BL_GRP_SEQ" ).append("\n"); 
		query.append("    AND   UI.BL_GRP_SEQ = GRP.BL_GRP_SEQ" ).append("\n"); 
		query.append("    AND   BI.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND   UI.USR_STS_CD IN ('CF','CR','RU') " ).append("\n"); 
		query.append("    AND   BI.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("	AND   UI.CUST_CNT_CD = BL.CUST_CNT_CD" ).append("\n"); 
		query.append("	AND   UI.CUST_SEQ = BL.CUST_SEQ" ).append("\n"); 
		query.append("    AND   (EXISTS (SELECT 'X' FROM BKG_XTER_USR_EML_SUBSC_CNT CNT WHERE UI.USR_ID = CNT.USR_ID AND CNT.CNT_CD = SUBSTR(BB.DEL_CD,1,2))" ).append("\n"); 
		query.append("    OR   EXISTS (SELECT 'X' FROM BKG_XTER_USR_EML_SUBSC_LOC LOC WHERE UI.USR_ID = LOC.USR_ID AND LOC.CUST_LOC_CD = BB.DEL_CD))" ).append("\n"); 
		query.append("    AND   EXISTS (SELECT 'X' FROM BKG_CTRL_BL_GRP_CUST BCBG " ).append("\n"); 
		query.append("                  WHERE BCBG.BL_GRP_SEQ = BL.BL_GRP_SEQ " ).append("\n"); 
		query.append("                     AND BCBG.CUST_CNT_CD||BCBG.CUST_SEQ IN (SELECT BC.CUST_CNT_CD||BC.CUST_SEQ FROM BKG_CUSTOMER BC WHERE BC.BKG_NO = @[bkg_no] AND BC.BKG_CUST_TP_CD IN ('S','C','N','F')" ).append("\n"); 
		query.append("															  UNION ALL SELECT BB.BKG_PTY_CUST_CNT_CD||BB.BKG_PTY_CUST_SEQ FROM BKG_BOOKING BB WHERE BB.BKG_NO = @[bkg_no] AND BKG_PTY_CUST_CNT_CD > ' '" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("	) T" ).append("\n"); 

	}
}