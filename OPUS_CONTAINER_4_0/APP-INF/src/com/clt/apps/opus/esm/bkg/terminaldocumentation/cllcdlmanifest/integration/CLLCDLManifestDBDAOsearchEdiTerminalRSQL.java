/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchEdiTerminalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchEdiTerminalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiTerminal
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchEdiTerminalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchEdiTerminalRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT PRNR_SUB_LNK_CD YD_CD, RCVR_TRD_PRNR_ID EDI_RCV_ID, SNDR_TRD_PRNR_ID EDI_SND_ID, AREA_ID EDI_TML_SVR_CD, AREA_ID AREA_ID" ).append("\n"); 
		query.append("         --, DECODE(EDI_MSG_IND_CD,'8','Y','N') VVD_FLG, DECODE(EDI_MSG_IND_CD,'10','Y','N') BL_FLG" ).append("\n"); 
		query.append("      FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("           BKG_EDI_SUB_LNK_MSG MSG, " ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("              SYS_AREA_GRP_ID AREA_ID " ).append("\n"); 
		query.append("            FROM " ).append("\n"); 
		query.append("              COM_SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("            WHERE CNT_CD = @[in_cnt_cd]" ).append("\n"); 
		query.append("             AND CO_IND_CD = 'H' " ).append("\n"); 
		query.append("             AND SVR_USD_FLG = 'Y'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("       WHERE EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("         AND PRNR_SUB_LNK_CD LIKE @[in_cnt_cd]||'%'" ).append("\n"); 
		query.append("         AND EDI_MSG_TP_ID = 'COPRAR'" ).append("\n"); 
		query.append("         --AND EDI_MSG_IND_CD IN ( '8', '10' )" ).append("\n"); 
		query.append("--         AND EDI_MSG_IND_CD IN ( '8', DECODE([in_list_type], 'L', '10', '') )--2015-04-11 SETUP 통일" ).append("\n"); 
		query.append("         AND MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("    UNION-- ALL" ).append("\n"); 
		query.append("    SELECT PRNR_SUB_LNK_CD YD_CD, RCVR_TRD_PRNR_ID EDI_RCV_ID, SNDR_TRD_PRNR_ID EDI_SND_ID, AREA_ID EDI_TML_SVR_CD, AREA_ID AREA_ID" ).append("\n"); 
		query.append("         --, DECODE(EDI_MSG_IND_CD,'8','Y','N') VVD_FLG, DECODE(EDI_MSG_IND_CD,'10','Y','N') BL_FLG" ).append("\n"); 
		query.append("      FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("           BKG_EDI_SUB_LNK_MSG MSG, " ).append("\n"); 
		query.append("           MDM_VENDOR MV," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("              SYS_AREA_GRP_ID AREA_ID " ).append("\n"); 
		query.append("            FROM " ).append("\n"); 
		query.append("              COM_SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("            WHERE CNT_CD = @[in_cnt_cd]" ).append("\n"); 
		query.append("             AND CO_IND_CD = 'H' " ).append("\n"); 
		query.append("             AND SVR_USD_FLG = 'Y'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("       WHERE EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("         AND EY.PRNR_SUB_LNK_CD = TO_CHAR(MV.VNDR_SEQ)" ).append("\n"); 
		query.append("         AND MV.VNDR_CNT_CD LIKE @[in_cnt_cd]||'%'" ).append("\n"); 
		query.append("         AND EDI_MSG_TP_ID = 'COPRAR'" ).append("\n"); 
		query.append("--         AND EDI_MSG_IND_CD IN ( '8', DECODE([in_list_type], 'L', '10', '') )--2015-04-11 SETUP 통일" ).append("\n"); 
		query.append("         AND MSG_TP_DESC = '1'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY YD_CD" ).append("\n"); 

	}
}