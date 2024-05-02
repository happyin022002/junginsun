/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchPrdFullRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * 1. 2011.07.04 이수진 [CHM-201111709] PRD > Network Constraint 관련 data upload 및 기능개선 요청
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
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
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
		query.append("DECODE(CNST_FLG,'','','YES') cnst," ).append("\n"); 
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
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'Y'  ) THEN 'P/ UP' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ = 1+ (SELECT  MIN(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL  " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'Y'  )  " ).append("\n"); 
		query.append("        AND (SELECT BKG_RCV_TERM_CD FROM PRD_PROD_CTL_MST WHERE PCTL_NO = @[pctl_no] )  <> 'D'   THEN 'DUMMY' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  )   " ).append("\n"); 
		query.append("           AND  PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL  " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) THEN 'POR/POL' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ > (SELECT  MIN(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) " ).append("\n"); 
		query.append("        AND PCTL_SEQ < (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) " ).append("\n"); 
		query.append("        AND NOD_LNK_DIV_CD = 'N'  THEN 'OB I/C' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  )  THEN 'POR' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'O'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) THEN 'POL' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  IN (SELECT  PCTL_SEQ  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'T'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         ) THEN 'T/S'  " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ) " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  )  " ).append("\n"); 
		query.append("        AND PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) THEN 'POD/DEL' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ > (SELECT  MIN(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) " ).append("\n"); 
		query.append("        AND PCTL_SEQ < (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) " ).append("\n"); 
		query.append("        AND NOD_LNK_DIV_CD = 'N'  THEN 'IB I/C'  " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) THEN 'POD' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'N'  ) THEN 'DEL' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ = -1+ (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL  " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'Y'  )  " ).append("\n"); 
		query.append("        AND (SELECT BKG_DE_TERM_CD FROM PRD_PROD_CTL_MST WHERE PCTL_NO = @[pctl_no] )  <> 'D'    THEN 'DUMMY' " ).append("\n"); 
		query.append("       WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)  " ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                         WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002' " ).append("\n"); 
		query.append("                         AND PCTL_IO_BND_CD = 'I'  " ).append("\n"); 
		query.append("                         AND NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("                         AND MTY_YD_FLG = 'Y'  ) THEN 'RTN CY' " ).append("\n"); 
		query.append(" END) LOC," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("case " ).append("\n"); 
		query.append("    when NOD_LNK_DIV_CD='L' and TRSP_MOD_CD='VD' then  " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("         SELECT ROUT_CNST_RMK RMK" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("				SELECT MST.PCTL_NO, R.ROUT_CNST_SEQ ROUT_CNST_SEQ, DECODE(NVL(SVC_USE_FLG, 'Y'), 'N', 'X', 'R')	ROUT_CNST_FLG" ).append("\n"); 
		query.append("				      , ROW_NUMBER() OVER (PARTITION BY MST.PCTL_NO" ).append("\n"); 
		query.append("				                           ORDER BY DECODE(R.TRNK_LANE_CD, 'ALL', 1, 0)" ).append("\n"); 
		query.append("				                                  , DECODE(R.POL_NOD_CD, 'ALL', 1, 0)" ).append("\n"); 
		query.append("				                                  , DECODE(R.POL_NOD_CD, 'ALL', 1, 0)" ).append("\n"); 
		query.append("				                                 , R.ROUT_CNST_SEQ DESC ) RN" ).append("\n"); 
		query.append("				      , ROUT_CNST_RMK" ).append("\n"); 
		query.append("				FROM PRD_ROUT_CNST R," ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT  M.PCTL_NO, POL_CD," ).append("\n"); 
		query.append("								MAX (DECODE (TS.RK, 1, TS.LANE_CD)) N1ST_LANE_CD, N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("								MAX (DECODE (TS.RK, 2, TS.LANE_CD)) N2ND_LANE_CD, N2ND_TS_PORT_CD," ).append("\n"); 
		query.append("								MAX (DECODE (TS.RK, 3, TS.LANE_CD)) N3RD_LANE_CD," ).append("\n"); 
		query.append("								POD_CD, DEL_NOD_CD," ).append("\n"); 
		query.append("								(SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("								FROM VSK_VSL_SKD V" ).append("\n"); 
		query.append("								WHERE V.VSL_CD = TRNK_VSL_CD" ).append("\n"); 
		query.append("								AND V.SKD_VOY_NO = TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("								AND V.SKD_DIR_CD = TRNK_SKD_DIR_CD ) TRNK_LANE," ).append("\n"); 
		query.append("								(SELECT /*+INDEX (D XPKPRD_PROD_CTL_ROUT_DTL) */" ).append("\n"); 
		query.append("					    				ORG_NOD_CD" ).append("\n"); 
		query.append("								FROM PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("								WHERE PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("								AND PCTL_IO_BND_CD = 'I' AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                   			AND MTY_YD_FLG = 'N'" ).append("\n"); 
		query.append("                    			AND ROWNUM = 1" ).append("\n"); 
		query.append("								) POD_NOD" ).append("\n"); 
		query.append("               				,MAX (DECODE (TS.RK, 1, ORG_NOD_CD )) N1ST_ORG_NOD_CD, MAX (DECODE (TS.RK, 1, DEST_NOD_CD )) N1ST_DEST_NOD_CD" ).append("\n"); 
		query.append("               				,MAX (DECODE (TS.RK, 2, ORG_NOD_CD )) N2ND_ORG_NOD_CD, MAX (DECODE (TS.RK, 2, DEST_NOD_CD )) N2ND_DEST_NOD_CD" ).append("\n"); 
		query.append("               				,MAX (DECODE (TS.RK, 3, ORG_NOD_CD )) N3RD_ORG_NOD_CD, MAX (DECODE (TS.RK, 3, DEST_NOD_CD )) N3RD_DEST_NOD_CD" ).append("\n"); 
		query.append("						FROM PRD_PROD_CTL_MST M," ).append("\n"); 
		query.append("							 (SELECT PCTL_NO,ORG_NOD_CD,DEST_NOD_CD," ).append("\n"); 
		query.append("									 RANK () OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) RK, VSL_SLAN_CD LANE_CD" ).append("\n"); 
		query.append("								FROM PRD_PROD_CTL_ROUT_DTL DTL, PRD_OCN_ROUT ROUT" ).append("\n"); 
		query.append("							   WHERE PCTL_NO = @[pctl_no] AND VSL_SLAN_CD IS NOT NULL" ).append("\n"); 
		query.append("								AND  DTL.ROUT_ORG_NOD_CD = ROUT.ORG_LOC_CD" ).append("\n"); 
		query.append("								AND	 DTL.ROUT_DEST_NOD_CD = ROUT.DEST_LOC_CD" ).append("\n"); 
		query.append("								AND	 DTL.ROUT_SEQ = ROUT.ROUT_SEQ" ).append("\n"); 
		query.append("							 ) TS" ).append("\n"); 
		query.append("						WHERE M.PCTL_NO = @[pctl_no] AND M.PCTL_NO = TS.PCTL_NO(+)" ).append("\n"); 
		query.append("						GROUP BY M.PCTL_NO, POL_CD," ).append("\n"); 
		query.append("								 N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("								 N2ND_TS_PORT_CD," ).append("\n"); 
		query.append("								 POD_CD," ).append("\n"); 
		query.append("								 DEL_NOD_CD," ).append("\n"); 
		query.append("								 TRNK_VSL_CD," ).append("\n"); 
		query.append("								 TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("								 TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("					 ) MST" ).append("\n"); 
		query.append("				WHERE MST.TRNK_LANE = DECODE(R.TRNK_LANE_CD, 'ALL',MST.TRNK_LANE,R.TRNK_LANE_CD)" ).append("\n"); 
		query.append("				AND MST.POL_CD LIKE DECODE(R.POL_NOD_CD, 'ALL', MST.POL_CD, SUBSTR(R.POL_NOD_CD,1,5)||'%')" ).append("\n"); 
		query.append("				AND MST.N1ST_ORG_NOD_CD LIKE DECODE(LENGTH(R.POL_NOD_CD),7,R.POL_NOD_CD, MST.N1ST_ORG_NOD_CD)" ).append("\n"); 
		query.append("				AND MST.POD_NOD LIKE DECODE(R.POD_NOD_CD, 'ALL', MST.POD_CD, R.POD_NOD_CD) ||'%'" ).append("\n"); 
		query.append("		    	AND NVL(MST.DEL_NOD_CD, R.DEL_NOD_CD) LIKE NVL(R.DEL_NOD_CD, MST.DEL_NOD_CD)||'%'" ).append("\n"); 
		query.append("	            AND NVL(MST.N1ST_TS_PORT_CD, ' ') = NVL(R.N1ST_TS_PORT_CD, NVL(MST.N1ST_TS_PORT_CD, ' '))" ).append("\n"); 
		query.append("				AND NVL(MST.N2ND_TS_PORT_CD, ' ') = NVL(R.N2ND_TS_PORT_CD, NVL(MST.N2ND_TS_PORT_CD, ' '))" ).append("\n"); 
		query.append("				AND NVL(MST.N1ST_LANE_CD, ' ') = NVL(R.N1ST_LANE_CD, NVL(MST.N1ST_LANE_CD, ' '))" ).append("\n"); 
		query.append("				AND NVL(MST.N2ND_LANE_CD, ' ') = NVL(R.N2ND_LANE_CD, NVL(MST.N2ND_LANE_CD, ' '))" ).append("\n"); 
		query.append("				AND NVL(MST.N3RD_LANE_CD, ' ') = NVL(R.N3RD_LANE_CD, NVL(MST.N3RD_LANE_CD, ' '))" ).append("\n"); 
		query.append("				AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("	    ) M" ).append("\n"); 
		query.append("	  WHERE RN = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            )   " ).append("\n"); 
		query.append("    else ''" ).append("\n"); 
		query.append("end  rout_rmk, " ).append("\n"); 
		query.append("case" ).append("\n"); 
		query.append("    when NOD_LNK_DIV_CD='N' --and   PCTL_IO_BND_CD in ('I','O') " ).append("\n"); 
		query.append("    then " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                SELECT NOD_CNST_RMK RMK --, C.SVC_USE_FLG, NOD_CD ROUT," ).append("\n"); 
		query.append("                --PCTL_CNST_ITM_NM ITEM,   C.CRE_OFC_CD, C.CRE_USR_ID" ).append("\n"); 
		query.append("                FROM  PRD_NOD_CNST_MGMT C," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    SELECT CNTR_TPSZ_CD ,CMDT_CD,M.CRE_DT " ).append("\n"); 
		query.append("                    FROM PRD_PROD_CTL_MST M , PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("                    WHERE M.PCTL_NO = @[pctl_no] --'B0909290000007060001'" ).append("\n"); 
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
		query.append("                     -- 사용자 요청으로 PC생성일 기준으로 변경" ).append("\n"); 
		query.append("		     TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= P.CRE_DT AND" ).append("\n"); 
		query.append("                     P.CRE_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                and rownum=1" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("    else ''" ).append("\n"); 
		query.append("end nod_rmk," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("case" ).append("\n"); 
		query.append("    when  NOD_LNK_DIV_CD='L' --and   PCTL_IO_BND_CD in ('I','O') " ).append("\n"); 
		query.append("    then " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                SELECT LNK_CNST_RMK RMK " ).append("\n"); 
		query.append("                FROM PRD_LNK_CNST_MGMT C," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  CNTR_TPSZ_CD,CMDT_CD,M.CRE_DT " ).append("\n"); 
		query.append("                FROM PRD_PROD_CTL_MST M ,  PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("                WHERE M.PCTL_NO = @[pctl_no]--'B0909290000007060001'" ).append("\n"); 
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
		query.append("                     -- 사용자 요청으로 PC생성일 기준으로 변경" ).append("\n"); 
		query.append("		     TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= P.CRE_DT AND" ).append("\n"); 
		query.append("                     P.CRE_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                and rownum =1     " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    else ''" ).append("\n"); 
		query.append("end lnk_rmk   " ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("WHERE ((PCTL_NO = @[pctl_no] )) " ).append("\n"); 
		query.append("ORDER BY PCTL_SEQ" ).append("\n"); 

	}
}