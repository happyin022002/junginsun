/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchRcvEmlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2014.12.30 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchRcvEmlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssueanceDBDAOSearchRcvEml
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchRcvEmlVORSQL(){
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
		query.append("FileName : BLIssuanceDBDAOSearchRcvEmlVORSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("    BL_GRP_SEQ" ).append("\n"); 
		query.append("    ,BL_VW_RT_TP_CD" ).append("\n"); 
		query.append("    ,CASE WHEN XTER_USR_EML IS NULL THEN EML_CUST_ADDR" ).append("\n"); 
		query.append("		  WHEN EML_CUST_ADDR IS NULL THEN XTER_USR_EML" ).append("\n"); 
		query.append("          ELSE XTER_USR_EML || ';' || EML_CUST_ADDR" ).append("\n"); 
		query.append("     END AS USR_EML" ).append("\n"); 
		query.append("	,'' AS NTFY_PRF_FLG" ).append("\n"); 
		query.append("	,'' AS NTFY_PRN_FLG" ).append("\n"); 
		query.append("	,'' AS NTFY_AUTO_WBL_FLG" ).append("\n"); 
		query.append("	,'' AS BKG_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  CBG.BL_GRP_SEQ" ).append("\n"); 
		query.append("       ,CBG.BL_VW_RT_TP_CD" ).append("\n"); 
		query.append("#if (${ntfy_prf_flg} != '')" ).append("\n"); 
		query.append("       ,CASE WHEN CBG.NTFY_PRF_FLG = 'Y' THEN  CBG.EML_CUST_ADDR" ).append("\n"); 
		query.append("             ELSE '' END " ).append("\n"); 
		query.append("		AS EML_CUST_ADDR" ).append("\n"); 
		query.append("       ,BKG_JOIN_FNC(CURSOR(SELECT BUI.USR_EML FROM BKG_XTER_USR_INFO BUI WHERE BUI.BL_GRP_SEQ = CBG.BL_GRP_SEQ AND BUI.RDY_FO_PRF_FLG = 'Y' AND TRIM(BUI.USR_EML) IS NOT NULL), ';')" ).append("\n"); 
		query.append("        AS XTER_USR_EML" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ntfy_prn_flg} != '')" ).append("\n"); 
		query.append("       ,CASE WHEN CBG.NTFY_PRN_FLG = 'Y' THEN  CBG.EML_CUST_ADDR" ).append("\n"); 
		query.append("             ELSE '' END " ).append("\n"); 
		query.append("		AS EML_CUST_ADDR" ).append("\n"); 
		query.append("       ,BKG_JOIN_FNC(CURSOR(SELECT BUI.USR_EML FROM BKG_XTER_USR_INFO BUI WHERE BUI.BL_GRP_SEQ = CBG.BL_GRP_SEQ AND BUI.RDY_FO_PRN_FLG = 'Y' AND TRIM(BUI.USR_EML) IS NOT NULL), ';')" ).append("\n"); 
		query.append("        AS XTER_USR_EML" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ntfy_auto_wbl_flg} != '')" ).append("\n"); 
		query.append("       ,CASE WHEN CBG.NTFY_AUTO_WBL_FLG = 'Y' THEN  CBG.EML_CUST_ADDR" ).append("\n"); 
		query.append("             ELSE '' END " ).append("\n"); 
		query.append("		AS EML_CUST_ADDR" ).append("\n"); 
		query.append("       ,BKG_JOIN_FNC(CURSOR(SELECT BUI.USR_EML FROM BKG_XTER_USR_INFO BUI WHERE BUI.BL_GRP_SEQ = CBG.BL_GRP_SEQ AND BUI.SEA_WBL_EML_FLG = 'Y' AND TRIM(BUI.USR_EML) IS NOT NULL), ';')" ).append("\n"); 
		query.append("        AS XTER_USR_EML" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("FROM BKG_BL_ISS BI" ).append("\n"); 
		query.append("     ,BKG_INET_BL_CTRL_PTY IBC" ).append("\n"); 
		query.append("     ,BKG_CTRL_PTY_BL_GRP CBG" ).append("\n"); 
		query.append("WHERE 0=0" ).append("\n"); 
		query.append("AND BI.INET_CTRL_PTY_NM = IBC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND BI.INET_CTRL_PTY_NO = IBC.CUST_SEQ" ).append("\n"); 
		query.append("AND IBC.CTRL_PTY_SEQ = CBG.CTRL_PTY_SEQ" ).append("\n"); 
		query.append("AND BI.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("WHERE 0=0" ).append("\n"); 
		query.append("AND (   EML_CUST_ADDR IS NOT NULL " ).append("\n"); 
		query.append("     OR XTER_USR_EML IS NOT NULL)" ).append("\n"); 
		query.append("ORDER BY BL_GRP_SEQ" ).append("\n"); 

	}
}