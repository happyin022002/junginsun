/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchPrdFullRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSearchPrdFullRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchprdFullRoute
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchPrdFullRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchPrdFullRouteRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("DECODE(TRIM(cnst_flg), 'X','N',NULL,NULL,'Y') cnst," ).append("\n"); 
		query.append("CASE " ).append("\n"); 
		query.append("    WHEN NOD_LNK_DIV_CD='N' THEN " ).append("\n"); 
		query.append("        (SELECT NOD_NM FROM PRD_NODE WHERE NOD_CD =ORG_NOD_CD) " ).append("\n"); 
		query.append("    WHEN NOD_LNK_DIV_CD='L' THEN " ).append("\n"); 
		query.append("        (SELECT NOD_NM FROM PRD_NODE WHERE NOD_CD =ORG_NOD_CD) " ).append("\n"); 
		query.append("END ORG_NOD_NM,        " ).append("\n"); 
		query.append("CASE " ).append("\n"); 
		query.append("    WHEN NOD_LNK_DIV_CD='N' THEN " ).append("\n"); 
		query.append("        '' " ).append("\n"); 
		query.append("    WHEN NOD_LNK_DIV_CD='L' THEN " ).append("\n"); 
		query.append("        (SELECT NOD_NM FROM PRD_NODE WHERE NOD_CD =DEST_NOD_CD) " ).append("\n"); 
		query.append("END DEST_NOD_NM, " ).append("\n"); 
		query.append("CASE " ).append("\n"); 
		query.append("    WHEN NOD_LNK_DIV_CD='N' THEN " ).append("\n"); 
		query.append("        (SELECT NOD_NM FROM PRD_NODE WHERE NOD_CD =ORG_NOD_CD) " ).append("\n"); 
		query.append("    WHEN NOD_LNK_DIV_CD='L' THEN " ).append("\n"); 
		query.append("        (SELECT NOD_NM FROM PRD_NODE WHERE NOD_CD =ORG_NOD_CD)||'->'||(SELECT NOD_NM FROM PRD_NODE WHERE NOD_CD =DEST_NOD_CD)  " ).append("\n"); 
		query.append("END NOD_NM_TOOL_TIP,        " ).append("\n"); 
		query.append("DECODE (NOD_LNK_DIV_CD,'N',ORG_NOD_CD, ORG_NOD_CD || ' -> ' || DEST_NOD_CD) NODE_LINK, " ).append("\n"); 
		query.append("'PLANNED' TRANS_ST, " ).append("\n"); 
		query.append("DECODE(TRSP_MOD_CD,'X','',TRSP_MOD_CD) TRSP_MOD_CD, " ).append("\n"); 
		query.append("LTRIM (TO_CHAR (TRUNC (TZ_DWLL_TM_HRS / 24, 0), '00'))||'D ' ||LTRIM (TO_CHAR (MOD (TZ_DWLL_TM_HRS, 24), '00'))||'H' FMT_TZ_DWLL_TM, " ).append("\n"); 
		query.append("TO_CHAR (ARR_ST_DT, 'YYYY-MM-DD HH24:MI') ARR_TIME, " ).append("\n"); 
		query.append("TO_CHAR (DEP_FSH_DT, 'YYYY-MM-DD HH24:MI') DEP_TIME, " ).append("\n"); 
		query.append("CASE WHEN VSL_CD IS NOT NULL AND  SKD_VOY_NO IS NOT NULL AND SKD_DIR_CD IS NOT NULL THEN " ).append("\n"); 
		query.append("        VSL_CD || TRIM (TO_CHAR (SKD_VOY_NO, '0000')) || SKD_DIR_CD " ).append("\n"); 
		query.append("  ELSE 'N' " ).append("\n"); 
		query.append("END VVD, " ).append("\n"); 
		query.append("to_char(GEN_AVAL_SPC) GEN_AVAL_SPC, to_char(D7_AVAL_SPC) D7_AVAL_SPC, to_char(RF_AVAL_SPC) RF_AVAL_SPC, " ).append("\n"); 
		query.append("PCTL_NO, " ).append("\n"); 
		query.append("PCTL_SEQ, " ).append("\n"); 
		query.append("VSL_SLAN_CD,ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD , " ).append("\n"); 
		query.append("CASE " ).append("\n"); 
		query.append("    WHEN TRSP_MOD_CD IN ('WD', 'VD') AND NOD_LNK_DIV_CD = 'L' AND VSL_SLAN_CD > ' ' THEN 'T' " ).append("\n"); 
		query.append("    ELSE 'F' " ).append("\n"); 
		query.append("END AS VVD_GB, " ).append("\n"); 
		query.append("TO_CHAR (ARR_ST_DT, 'YYYYMMDDHH24MISS') ETD, " ).append("\n"); 
		query.append("TO_CHAR (DEP_FSH_DT, 'YYYYMMDDHH24MISS') ETB, " ).append("\n"); 
		query.append("ORG_NOD_CD, DEST_NOD_CD, PCTL_WTR_DIV_CD, NOD_LNK_DIV_CD, MTY_YD_FLG, " ).append("\n"); 
		query.append("CASE WHEN NOD_LNK_DIV_CD='N' AND PCTL_IO_BND_CD='O' AND ORG_NOD_TP_CD ='Z' AND DEST_NOD_TP_CD ='Z' THEN 'Y' " ).append("\n"); 
		query.append("     ELSE 'N' " ).append("\n"); 
		query.append("END AS DOOR_DT, " ).append("\n"); 
		query.append("(		" ).append("\n"); 
		query.append("		 SELECT TO_CHAR(MAX(ARR_ST_DT),'YYYYMMDDHH24MISS') FROM PRD_PROD_CTL_ROUT_DTL WHERE " ).append("\n"); 
		query.append("		 PCTL_NO = @[pctl_no]					" ).append("\n"); 
		query.append("		 AND PCTL_IO_BND_CD = 'I'	" ).append("\n"); 
		query.append("		 AND NOD_LNK_DIV_CD = 'N' 	" ).append("\n"); 
		query.append("		 AND ORG_NOD_TP_CD = 'Z'	" ).append("\n"); 
		query.append(") AS DELIVERY_DT_OLD,	" ).append("\n"); 
		query.append("(		" ).append("\n"); 
		query.append("		 SELECT TO_CHAR(MAX(ARR_ST_DT),'YYYYMMDDHH24MISS') FROM PRD_PROD_CTL_ROUT_DTL WHERE " ).append("\n"); 
		query.append("		 PCTL_NO = @[pctl_no]					" ).append("\n"); 
		query.append("		 AND PCTL_IO_BND_CD = 'I'	" ).append("\n"); 
		query.append("		 AND NOD_LNK_DIV_CD = 'N' 	" ).append("\n"); 
		query.append("		 AND MTY_YD_FLG = 'N' 		" ).append("\n"); 
		query.append(") AS DELIVERY_DT,	" ).append("\n"); 
		query.append("NVL((		                                                                                                  " ).append("\n"); 
		query.append("		SELECT SUBSTR(MAX(DECODE(TRSP_MOD_CD,'TD','T'))||MAX(DECODE(TRSP_MOD_CD,'RD','R'))||                     " ).append("\n"); 
		query.append("                  MAX(DECODE(TRSP_MOD_CD,'WD','W'))||'D',1,2)  TRSP_MODE                                     " ).append("\n"); 
		query.append("		FROM PRD_INLND_ROUT_DTL                                                                             " ).append("\n"); 
		query.append("		WHERE (ROUT_ORG_NOD_CD , ROUT_DEST_NOD_CD , ROUT_SEQ ) =                                            " ).append("\n"); 
		query.append("		       (SELECT ROUT_ORG_NOD_CD , ROUT_DEST_NOD_CD , ROUT_SEQ                                        " ).append("\n"); 
		query.append("		        FROM PRD_PROD_CTL_ROUT_DTL                                                                  " ).append("\n"); 
		query.append("		        WHERE PCTL_NO = @[pctl_no]                                                                           " ).append("\n"); 
		query.append("		         AND PCTL_IO_BND_CD ='O'                                                                     " ).append("\n"); 
		query.append("		         AND ROUT_ORG_NOD_CD IS NOT NULL                                                             " ).append("\n"); 
		query.append("		         AND ROWNUM =1                                                                               " ).append("\n"); 
		query.append("		         )                                                                                           " ).append("\n"); 
		query.append("		GROUP BY ROUT_ORG_NOD_CD , ROUT_DEST_NOD_CD , ROUT_SEQ                                                  " ).append("\n"); 
		query.append("		),'AL') O_T_MODE,                                                                                       " ).append("\n"); 
		query.append("		NVL((		                                                                                                " ).append("\n"); 
		query.append("		SELECT SUBSTR(MAX(DECODE(TRSP_MOD_CD,'TD','T'))||MAX(DECODE(TRSP_MOD_CD,'RD','R'))||                     " ).append("\n"); 
		query.append("                  MAX(DECODE(TRSP_MOD_CD,'WD','W'))||'D',1,2)  TRSP_MODE                                     " ).append("\n"); 
		query.append("		FROM PRD_INLND_ROUT_DTL                                                                             " ).append("\n"); 
		query.append("		WHERE (ROUT_ORG_NOD_CD , ROUT_DEST_NOD_CD , ROUT_SEQ ) =                                            " ).append("\n"); 
		query.append("		       (SELECT ROUT_ORG_NOD_CD , ROUT_DEST_NOD_CD , ROUT_SEQ                                        " ).append("\n"); 
		query.append("		        FROM PRD_PROD_CTL_ROUT_DTL                                                                  " ).append("\n"); 
		query.append("		        WHERE PCTL_NO = @[pctl_no]                                                                           " ).append("\n"); 
		query.append("		         AND PCTL_IO_BND_CD ='I'                                                                     " ).append("\n"); 
		query.append("		         AND ROUT_ORG_NOD_CD IS NOT NULL                                                             " ).append("\n"); 
		query.append("		         AND ROWNUM =1                                                                               " ).append("\n"); 
		query.append("		         )                                                                                           " ).append("\n"); 
		query.append("		GROUP BY ROUT_ORG_NOD_CD , ROUT_DEST_NOD_CD , ROUT_SEQ                                                  " ).append("\n"); 
		query.append("		),'AL') I_T_MODE,                                                                                       " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    MIN(PCTL_SEQ) " ).append("\n"); 
		query.append("    FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("    WHERE  PCTL_NO = @[pctl_no] " ).append("\n"); 
		query.append("    AND TRSP_MOD_CD IN ('WD','VD') " ).append("\n"); 
		query.append("    AND PCTL_IO_BND_CD = 'T' " ).append("\n"); 
		query.append(") LOAD_DT_PCTL_SEQ, " ).append("\n"); 
		query.append(" (CASE WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'Y'  ) THEN 'P/ UP' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ = 1+ (SELECT  MIN(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL  " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'Y'  )  " ).append("\n"); 
		query.append("        AND (SELECT BKG_RCV_TERM_CD FROM PRD_PROD_CTL_MST WHERE PCTL_NO = @[pctl_no] )  <> 'D'   THEN 'DUMMY' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  )   " ).append("\n"); 
		query.append("           AND  PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL  " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) THEN 'POR/POL' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ > (SELECT  MIN(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) " ).append("\n"); 
		query.append("        AND PCTL_SEQ < (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) " ).append("\n"); 
		query.append("        AND NOD_LNK_DIV_CD = 'N'  THEN 'OB I/C' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  )  THEN 'POR' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no] " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) THEN 'POL' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  IN (SELECT  PCTL_SEQ  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'T'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         ) THEN 'T/S'  " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ) " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  )  " ).append("\n"); 
		query.append("        AND PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) THEN 'POD/DEL' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ > (SELECT  MIN(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) " ).append("\n"); 
		query.append("        AND PCTL_SEQ < (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) " ).append("\n"); 
		query.append("        AND NOD_LNK_DIV_CD = 'N'  THEN 'IB I/C'  " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) THEN 'POD' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) THEN 'DEL' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ = -1+ (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL  " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'Y'  )  " ).append("\n"); 
		query.append("        AND (SELECT BKG_DE_TERM_CD FROM PRD_PROD_CTL_MST WHERE PCTL_NO = @[pctl_no] )  <> 'D'    THEN 'DUMMY' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'Y'  ) THEN 'RTN CY' " ).append("\n"); 
		query.append(" END) LOC," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("case " ).append("\n"); 
		query.append("    when NOD_LNK_DIV_CD='L' and TRSP_MOD_CD='VD' then  " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT ROUT_CNST_RMK RMK " ).append("\n"); 
		query.append("                FROM PRD_ROUT_CNST C," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT VSL_SLAN_CD,POL_CD,POL_NOD_CD,N1ST_LANE_CD," ).append("\n"); 
		query.append("							N1ST_POD_CD,N2ND_LANE_CD,N2ND_POD_CD,N3RD_LANE_CD,DEL_CD," ).append("\n"); 
		query.append("							DEL_NOD_CD,POD_NOD_CD,POD_CD, POR_CD, POR_NOD_CD" ).append("\n"); 
		query.append("                    FROM PRD_PROD_CTL_MST M , PRD_PROD_CTL_ROUT_DTL D, PRD_OCN_ROUT O" ).append("\n"); 
		query.append("                    WHERE M.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                    AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("                    AND PCTL_IO_BND_CD='T'" ).append("\n"); 
		query.append("                    AND M.TRNK_VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("                    AND M.TRNK_SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND M.TRNK_SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND O.ORG_LOC_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                    AND O.DEST_LOC_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                    AND O.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND ROWNUM = 1" ).append("\n"); 
		query.append("                ) P" ).append("\n"); 
		query.append("                WHERE  DECODE(C.TRNK_LANE_CD, 'ALL',P.VSL_SLAN_CD,C.TRNK_LANE_CD) = P.VSL_SLAN_CD" ).append("\n"); 
		query.append("				AND    NVL(C.POR_NOD_CD,'X') IN (NVL(C.POR_NOD_CD,'X'), P.POR_CD, P.POR_NOD_CD)" ).append("\n"); 
		query.append("                AND    C.POL_NOD_CD IN ( P.POL_CD, P.POL_NOD_CD)" ).append("\n"); 
		query.append("                AND    C.POD_NOD_CD IN ( P.POD_CD, P.POD_NOD_CD)" ).append("\n"); 
		query.append("                AND    NVL(C.DEL_NOD_CD,'X') IN (NVL(C.DEL_NOD_CD,'X'), P.DEL_CD, P.DEL_NOD_CD)                " ).append("\n"); 
		query.append("                AND    NVL(C.N1ST_LANE_CD,'X') = DECODE(C.N1ST_LANE_CD, NULL, 'X', P.N1ST_LANE_CD)" ).append("\n"); 
		query.append("                AND    NVL(C.N1ST_TS_PORT_CD,'X') = DECODE(C.N1ST_TS_PORT_CD,NULL, 'X', P.N1ST_POD_CD)" ).append("\n"); 
		query.append("                AND    NVL(C.N2ND_LANE_CD,'X') = DECODE(C.N2ND_LANE_CD,NULL,'X',P.N2ND_LANE_CD)" ).append("\n"); 
		query.append("                AND    NVL(C.N2ND_TS_PORT_CD,'X') = DECODE(C.N2ND_TS_PORT_CD,NULL,'X',P.N2ND_POD_CD)" ).append("\n"); 
		query.append("                AND    NVL(C.N3RD_LANE_CD,'X') = DECODE(C.N3RD_LANE_CD,NULL,'X',P.N3RD_LANE_CD)" ).append("\n"); 
		query.append("                AND    NVL(C.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                AND    ROWNUM = 1" ).append("\n"); 
		query.append("            )   " ).append("\n"); 
		query.append("    else ''" ).append("\n"); 
		query.append("end  rout_rmk, " ).append("\n"); 
		query.append("case" ).append("\n"); 
		query.append("    when NOD_LNK_DIV_CD='N'" ).append("\n"); 
		query.append("    then " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                SELECT NOD_CNST_RMK RMK " ).append("\n"); 
		query.append("                FROM  PRD_NOD_CNST_MGMT C," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    SELECT CNTR_TPSZ_CD ,CMDT_CD" ).append("\n"); 
		query.append("                    FROM PRD_PROD_CTL_MST M , PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("                    WHERE M.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                    AND M.PCTL_NO = Q.PCTL_NO" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    ) P" ).append("\n"); 
		query.append("                WHERE ORG_NOD_CD LIKE DECODE(NOD_CD,'ALL','%',NOD_CD||'%')" ).append("\n"); 
		query.append("                AND NVL(C.CMDT_CD,'X') = DECODE(C.CMDT_CD, NULL,'X',P.CMDT_CD)" ).append("\n"); 
		query.append("                AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                AND NVL(CNTR_TP_CD,CNTR_TPSZ_CD)= DECODE(C.CNTR_TP_CD, NULL, P.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                DECODE(SUBSTR(P.CNTR_TPSZ_CD, 1, 1), 'T', 'T', 'O', 'S', 'F', 'S'," ).append("\n"); 
		query.append("                'D',P.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                'R',P.CNTR_TPSZ_CD) )" ).append("\n"); 
		query.append("                AND (" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= ARR_ST_DT AND" ).append("\n"); 
		query.append("                ARR_ST_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)" ).append("\n"); 
		query.append("                ) OR" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= DEP_FSH_DT AND" ).append("\n"); 
		query.append("                DEP_FSH_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                and rownum=1" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("    else ''" ).append("\n"); 
		query.append("end nod_rmk," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("case" ).append("\n"); 
		query.append("    when  NOD_LNK_DIV_CD='L' " ).append("\n"); 
		query.append("    then " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                SELECT LNK_CNST_RMK RMK " ).append("\n"); 
		query.append("                FROM PRD_LNK_CNST_MGMT C," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  CNTR_TPSZ_CD,CMDT_CD " ).append("\n"); 
		query.append("                FROM PRD_PROD_CTL_MST M ,  PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("                WHERE M.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                AND M.PCTL_NO = Q.PCTL_NO" ).append("\n"); 
		query.append("                ) P" ).append("\n"); 
		query.append("                WHERE  ORG_NOD_CD LIKE C.LNK_ORG_NOD_CD||'%'" ).append("\n"); 
		query.append("                AND DEST_NOD_CD LIKE C.LNK_DEST_NOD_CD||'%'" ).append("\n"); 
		query.append("                AND C.TRSP_MOD_CD = TRSP_MOD_CD" ).append("\n"); 
		query.append("                AND NVL(C.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                AND NVL(C.CNTR_TP_CD, P.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                = DECODE(C.CNTR_TP_CD, NULL, P.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                DECODE(SUBSTR(P.CNTR_TPSZ_CD, 1, 1), 'T', 'T', 'O', 'S', 'F', 'S'," ).append("\n"); 
		query.append("                'D',P.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                'R',P.CNTR_TPSZ_CD) )" ).append("\n"); 
		query.append("                AND NVL(C.CMDT_CD,'X') = DECODE(C.CMDT_CD, NULL,'X',P.CMDT_CD)" ).append("\n"); 
		query.append("                AND (" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= ARR_ST_DT AND" ).append("\n"); 
		query.append("                ARR_ST_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)" ).append("\n"); 
		query.append("                ) OR" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= DEP_FSH_DT AND" ).append("\n"); 
		query.append("                DEP_FSH_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                )   " ).append("\n"); 
		query.append("                and rownum =1     " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    else ''" ).append("\n"); 
		query.append("end lnk_rmk   " ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("WHERE ((PCTL_NO = @[pctl_no] )) " ).append("\n"); 
		query.append("ORDER BY PCTL_SEQ" ).append("\n"); 

	}
}