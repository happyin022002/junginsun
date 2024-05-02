/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageDBDAOUpdateInlandRoutAddItemsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOUpdateInlandRoutAddItemsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateInlandRoutAddItems
	  * </pre>
	  */
	public InlandRouteManageDBDAOUpdateInlandRoutAddItemsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOUpdateInlandRoutAddItemsUSQL").append("\n"); 
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
		query.append("MERGE INTO PRD_INLND_ROUT_MST X" ).append("\n"); 
		query.append("  USING " ).append("\n"); 
		query.append("(SELECT  ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ,PCTL_IO_BND_CD,FULL_RTN_YD_CD,FULL_PKUP_YD_CD,HUB_NOD_CD" ).append("\n"); 
		query.append(" FROM ( " ).append("\n"); 
		query.append("      SELECT " ).append("\n"); 
		query.append("      S.ROUT_ORG_NOD_CD ," ).append("\n"); 
		query.append("      S.ROUT_DEST_NOD_CD ," ).append("\n"); 
		query.append("      S.PCTL_IO_BND_CD," ).append("\n"); 
		query.append("      S.ROUT_SEQ ," ).append("\n"); 
		query.append("      S.HUB_LOC_CD," ).append("\n"); 
		query.append("      DECODE(S.PCTL_IO_BND_CD,'O',US_O_HUB,'I',US_I_HUB) HUB_NOD_CD, " ).append("\n"); 
		query.append("      SUBSTRB( MIN( TO_CHAR(D.ROUT_DTL_SEQ, 'FM099')||D.LNK_DEST_NOD_CD ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ), 4) FIRST_LNK_DEST_NOD_CD ," ).append("\n"); 
		query.append("      (CASE WHEN S.PCTL_IO_BND_CD IN ('O','B') AND N.NOD_TP_CD != 'Z' THEN S.ROUT_ORG_NOD_CD " ).append("\n"); 
		query.append("            WHEN S.PCTL_IO_BND_CD IN ('O','B') AND N.NOD_TP_CD = 'Z' AND D.FIRST_INLND_ROUT_CMB_FLG = 'N' THEN D.FIRST_LNK_DEST_NOD_CD " ).append("\n"); 
		query.append("            WHEN S.PCTL_IO_BND_CD IN ('O','B') AND N.NOD_TP_CD = 'Z' AND D.FIRST_INLND_ROUT_CMB_FLG = 'N' THEN D.FULL_RTN_CY_CD_Y " ).append("\n"); 
		query.append("            WHEN S.PCTL_IO_BND_CD IN ('O','B') AND N.NOD_TP_CD = 'Z' AND D.INLND_ROUT_CMB_FLG = 'Y' THEN D.FULL_RTN_CY_CD_Y " ).append("\n"); 
		query.append("      END ) FULL_RTN_YD_CD ," ).append("\n"); 
		query.append("      (CASE WHEN S.PCTL_IO_BND_CD IN ('I','B') AND M.NOD_TP_CD != 'Z' THEN S.ROUT_DEST_NOD_CD " ).append("\n"); 
		query.append("            WHEN S.PCTL_IO_BND_CD IN ('I','B') AND M.NOD_TP_CD = 'Z' AND D.FIRST_INLND_ROUT_CMB_FLG = 'N' THEN D.LAST_LNK_ORG_NOD_CD " ).append("\n"); 
		query.append("            WHEN S.PCTL_IO_BND_CD IN ('I','B') AND M.NOD_TP_CD = 'Z' AND D.FIRST_INLND_ROUT_CMB_FLG = 'N' THEN D.FULL_PKUP_YD_CD_Y " ).append("\n"); 
		query.append("            WHEN S.PCTL_IO_BND_CD IN ('I','B') AND M.NOD_TP_CD = 'Z' AND D.INLND_ROUT_CMB_FLG = 'Y' THEN D.FULL_PKUP_YD_CD_Y " ).append("\n"); 
		query.append("            END ) FULL_PKUP_YD_CD" ).append("\n"); 
		query.append("    FROM PRD_INLND_ROUT_MST S ," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT D.ROUT_ORG_NOD_CD ," ).append("\n"); 
		query.append("          D.ROUT_DEST_NOD_CD ," ).append("\n"); 
		query.append("          D.ROUT_SEQ ," ).append("\n"); 
		query.append("          D.LNK_ORG_NOD_CD ," ).append("\n"); 
		query.append("          D.LNK_DEST_NOD_CD ," ).append("\n"); 
		query.append("          D.ROUT_DTL_SEQ ," ).append("\n"); 
		query.append("          D.INLND_ROUT_CMB_FLG ," ).append("\n"); 
		query.append("          D.TRSP_MOD_CD ," ).append("\n"); 
		query.append("          ROW_NUMBER( ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ" ).append("\n"); 
		query.append("            ORDER BY D.ROUT_DTL_SEQ ) ROW_POS ," ).append("\n"); 
		query.append("          SUBSTRB( MIN( TO_CHAR(D.ROUT_DTL_SEQ, 'FM099')||NVL(D.INLND_ROUT_CMB_FLG, 'N') ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ), 4) FIRST_INLND_ROUT_CMB_FLG ," ).append("\n"); 
		query.append("          SUBSTRB( MAX( TO_CHAR(D.ROUT_DTL_SEQ, 'FM099')||NVL(D.INLND_ROUT_CMB_FLG, 'N') ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ), 4) LAST_INLND_ROUT_CMB_FLG ," ).append("\n"); 
		query.append("          SUBSTRB( MIN( TO_CHAR(D.ROUT_DTL_SEQ, 'FM099')||D.LNK_DEST_NOD_CD ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ), 4) FIRST_LNK_DEST_NOD_CD ," ).append("\n"); 
		query.append("          SUBSTRB( MAX( (CASE WHEN D.INLND_ROUT_CMB_FLG = 'Y' THEN TO_CHAR(D.ROUT_DTL_SEQ, 'FM099')||D.LNK_DEST_NOD_CD END) ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ), 4) FULL_RTN_CY_CD_Y ," ).append("\n"); 
		query.append("          SUBSTRB( MAX( TO_CHAR(D.ROUT_DTL_SEQ, 'FM099')||D.LNK_ORG_NOD_CD ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ), 4) LAST_LNK_ORG_NOD_CD ," ).append("\n"); 
		query.append("          SUBSTRB( MIN( (CASE WHEN D.INLND_ROUT_CMB_FLG = 'Y' THEN TO_CHAR(D.ROUT_DTL_SEQ, 'FM099')||D.LNK_ORG_NOD_CD END) ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ), 4) FULL_PKUP_YD_CD_Y ," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          SUBSTRB( MAX( (CASE WHEN SUBSTR(D.ROUT_ORG_NOD_CD,1,2) IN  ('US','CA','MX') AND D.TRSP_MOD_CD ='RD' THEN TO_CHAR(D.ROUT_DTL_SEQ, 'FM099')||D.LNK_DEST_NOD_CD END) ) " ).append("\n"); 
		query.append("                           OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ), 4) US_I_HUB ," ).append("\n"); 
		query.append("          SUBSTRB( MIN( (CASE WHEN SUBSTR(D.ROUT_ORG_NOD_CD,1,2) IN  ('US','CA','MX') AND D.TRSP_MOD_CD ='RD' THEN TO_CHAR(D.ROUT_DTL_SEQ, 'FM099')||D.LNK_ORG_NOD_CD END) ) " ).append("\n"); 
		query.append("                           OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ), 4) US_O_HUB ," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          MIN( D.TRSP_MOD_CD ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ) MIN_TRSP_MOD_CD ," ).append("\n"); 
		query.append("          MAX( D.TRSP_MOD_CD ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ) MAX_TRSP_MOD_CD ," ).append("\n"); 
		query.append("          MAX( DECODE(D.TRSP_MOD_CD, 'TD', 'TD')) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ) TD_TRSP_MOD_CD" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("        FROM PRD_INLND_ROUT_DTL D " ).append("\n"); 
		query.append("        ) D ," ).append("\n"); 
		query.append("      PRD_NODE N ," ).append("\n"); 
		query.append("      PRD_NODE M" ).append("\n"); 
		query.append("    WHERE S.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD(+)" ).append("\n"); 
		query.append("      AND S.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD(+)" ).append("\n"); 
		query.append("      AND S.ROUT_SEQ = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("      AND S.ROUT_ORG_NOD_CD = N.NOD_CD(+)" ).append("\n"); 
		query.append("      AND S.ROUT_DEST_NOD_CD = M.NOD_CD(+)" ).append("\n"); 
		query.append("      AND D.ROW_POS(+) = 1 " ).append("\n"); 
		query.append("      AND S.ROUT_ORG_NOD_CD = @[i_rout_org_nod_cd]" ).append("\n"); 
		query.append("      AND S.ROUT_DEST_NOD_CD = @[i_rout_dest_nod_cd]" ).append("\n"); 
		query.append("      AND S.ROUT_SEQ = TO_NUMBER(@[i_rout_seq])" ).append("\n"); 
		query.append(" ) " ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("    ON (  X.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD AND  X.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD AND  X.ROUT_SEQ = B.ROUT_SEQ )" ).append("\n"); 
		query.append("   WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE SET X.FULL_RTN_YD_CD = B.FULL_RTN_YD_CD," ).append("\n"); 
		query.append("                 X.FULL_PKUP_YD_CD =B.FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("                 X.TRSP_MOD_CD     = @[trsp_mod_cd]," ).append("\n"); 
		query.append("                 X.HUB_NOD_CD = SUBSTR(TRIM(B.HUB_NOD_CD||B.FULL_RTN_YD_CD||B.FULL_PKUP_YD_CD),1,7)," ).append("\n"); 
		query.append("                 X.HUB_LOC_CD = SUBSTR(TRIM(B.HUB_NOD_CD||B.FULL_RTN_YD_CD||B.FULL_PKUP_YD_CD),1,5)" ).append("\n"); 

	}
}