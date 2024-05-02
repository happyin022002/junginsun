/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageDBDAOGetInlandRouteAddItemsRSQL.java
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

public class InlandRouteManageDBDAOGetInlandRouteAddItemsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetInlandRouteAddItems
	  * </pre>
	  */
	public InlandRouteManageDBDAOGetInlandRouteAddItemsRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOGetInlandRouteAddItemsRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("         S.ROUT_ORG_NOD_CD            , S.ROUT_DEST_NOD_CD   , S.ROUT_SEQ         , S.PRIO_SEQ                 ," ).append("\n"); 
		query.append("         S.INLND_ROUT_INV_BIL_PATT_CD , S.ROUT_PLN_CD        , S.WRS_FULL_CMDT_CD , S.WRS_MTY_CMDT_CD          ," ).append("\n"); 
		query.append("         S.MCNTR_ROUT_FLG             , S.INLND_ROUT_BKG_FLG , S.INLND_ROUT_RMK   , S.CRE_OFC_CD               ," ).append("\n"); 
		query.append("         S.PCTL_IO_BND_CD             , S.INLND_ROUT_TMP_FLG , S.DELT_FLG         , S.INLND_ROUT_INCL_STTL_FLG ," ).append("\n"); 
		query.append("         S.INLND_ROUT_N2ND_RMK        , S.HUB_LOC_CD         , S.D2_CAPA_FLG      , S.D4_CAPA_FLG              ," ).append("\n"); 
		query.append("         S.D5_CAPA_FLG                , S.D7_CAPA_FLG        , S.O2_CAPA_FLG      , S.O4_CAPA_FLG              ," ).append("\n"); 
		query.append("         S.A2_CAPA_FLG                , S.A4_CAPA_FLG        , S.R5_CAPA_FLG      , S.R2_CAPA_FLG              ," ).append("\n"); 
		query.append("         S.R4_CAPA_FLG                , S.HUB_NOD_CD         ," ).append("\n"); 
		query.append("         S.FULL_RTN_YD_CD             , S.FULL_PKUP_YD_CD    ," ).append("\n"); 
		query.append("         NVL(S.CRE_USR_ID,'MIG_USER')                   CRE_USR_ID   ," ).append("\n"); 
		query.append("         NVL(S.CRE_DT, TO_DATE('19770516','YYYYMMDD'))  CRE_DT       ," ).append("\n"); 
		query.append("         NVL(S.UPD_USR_ID,'MIG_USER')                   UPD_USR_ID   ," ).append("\n"); 
		query.append("         NVL(S.UPD_DT, TO_DATE('19770516','YYYYMMDD'))  UPD_DT       ," ).append("\n"); 
		query.append("         S.TRSP_MOD_CD" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("SELECT /*+ ORDERED USE_HASH(S D N M) DRIVING_SITE(S) */" ).append("\n"); 
		query.append("       ROWNUM         RNUM          , " ).append("\n"); 
		query.append("      N.NOD_TP_CD    ORG_NOD_TP_CD , M.NOD_TP_CD   DEST_NOD_TP_CD ," ).append("\n"); 
		query.append("       /*" ).append("\n"); 
		query.append("          S.PCTL_IO_BND_CD          , D.FIRST_INLND_ROUT_CMB_FLG, D.INLND_ROUT_CMB_FLG ," ).append("\n"); 
		query.append("          S.ROUT_DEST_NOD_CD        , D.LAST_LNK_ORG_NOD_CD     , D.FULL_PKUP_YD_CD_Y  ," ).append("\n"); 
		query.append("       */" ).append("\n"); 
		query.append("       S.ROUT_ORG_NOD_CD            , S.ROUT_DEST_NOD_CD   , S.ROUT_SEQ         , S.PRIO_SEQ                 ," ).append("\n"); 
		query.append("       S.INLND_ROUT_INV_BIL_PATT_CD , S.ROUT_PLN_CD        , S.WRS_FULL_CMDT_CD , S.WRS_MTY_CMDT_CD          ," ).append("\n"); 
		query.append("       S.MCNTR_ROUT_FLG             , S.INLND_ROUT_BKG_FLG , S.INLND_ROUT_RMK   , S.CRE_OFC_CD               ," ).append("\n"); 
		query.append("       S.PCTL_IO_BND_CD             , S.INLND_ROUT_TMP_FLG , S.DELT_FLG         , S.INLND_ROUT_INCL_STTL_FLG ," ).append("\n"); 
		query.append("       S.INLND_ROUT_N2ND_RMK        , S.HUB_LOC_CD         , S.D2_CAPA_FLG      , S.D4_CAPA_FLG              ," ).append("\n"); 
		query.append("       S.D5_CAPA_FLG                , S.D7_CAPA_FLG        , S.O2_CAPA_FLG      , S.O4_CAPA_FLG              ," ).append("\n"); 
		query.append("       S.A2_CAPA_FLG                , S.A4_CAPA_FLG        , S.R5_CAPA_FLG      , S.R2_CAPA_FLG              ," ).append("\n"); 
		query.append("       S.R4_CAPA_FLG                , S.HUB_NOD_CD         ," ).append("\n"); 
		query.append("         (CASE WHEN D.TD_TRSP_MOD_CD = D.MIN_TRSP_MOD_CD  AND D.MIN_TRSP_MOD_CD = D.MAX_TRSP_MOD_CD THEN 'TD'" ).append("\n"); 
		query.append("               WHEN D.TD_TRSP_MOD_CD = 'TD'               AND D.MIN_TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("                                                          AND D.MAX_TRSP_MOD_CD = 'TD'              THEN 'TR'" ).append("\n"); 
		query.append("               WHEN D.TD_TRSP_MOD_CD = 'TD'               AND D.MIN_TRSP_MOD_CD = 'TD'" ).append("\n"); 
		query.append("                                                          AND D.MAX_TRSP_MOD_CD = 'WD'              THEN 'TW'" ).append("\n"); 
		query.append("               WHEN D.MIN_TRSP_MOD_CD = D.MAX_TRSP_MOD_CD AND D.MIN_TRSP_MOD_CD = 'RD'              THEN 'RD'" ).append("\n"); 
		query.append("               WHEN D.MIN_TRSP_MOD_CD = D.MAX_TRSP_MOD_CD AND D.MIN_TRSP_MOD_CD = 'WD'              THEN 'WD'" ).append("\n"); 
		query.append("               WHEN D.TD_TRSP_MOD_CD IS NULL              AND D.MIN_TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("                                                          AND D.MAX_TRSP_MOD_CD = 'WD'              THEN 'RW'" ).append("\n"); 
		query.append("               ELSE 'ZZ' END )          TRSP_MOD_CD                  ," ).append("\n"); 
		query.append("          D.TD_TRSP_MOD_CD , D.MIN_TRSP_MOD_CD , D.MAX_TRSP_MOD_CD  ,    " ).append("\n"); 
		query.append("         (CASE WHEN S.PCTL_IO_BND_CD IN ('O','B')    AND  N.NOD_TP_CD != 'Z' THEN S.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("               WHEN S.PCTL_IO_BND_CD IN ('O','B')    AND  N.NOD_TP_CD  = 'Z' " ).append("\n"); 
		query.append("                AND D.FIRST_INLND_ROUT_CMB_FLG = 'N'                         THEN D.FIRST_LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("               WHEN S.PCTL_IO_BND_CD IN ('O','B')    AND  N.NOD_TP_CD  = 'Z' " ).append("\n"); 
		query.append("                AND D.FIRST_INLND_ROUT_CMB_FLG = 'N'                         THEN D.FULL_RTN_CY_CD_Y" ).append("\n"); 
		query.append("               WHEN S.PCTL_IO_BND_CD IN ('O','B')    AND  N.NOD_TP_CD  = 'Z' " ).append("\n"); 
		query.append("                AND D.INLND_ROUT_CMB_FLG = 'Y'                               THEN D.FULL_RTN_CY_CD_Y" ).append("\n"); 
		query.append("               END  )    FULL_RTN_YD_CD   ," ).append("\n"); 
		query.append("         (CASE WHEN S.PCTL_IO_BND_CD IN ('I','B')    AND  M.NOD_TP_CD != 'Z' THEN S.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("               WHEN S.PCTL_IO_BND_CD IN ('I','B')    AND  M.NOD_TP_CD  = 'Z' " ).append("\n"); 
		query.append("                AND D.FIRST_INLND_ROUT_CMB_FLG = 'N'                         THEN D.LAST_LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("               WHEN S.PCTL_IO_BND_CD IN ('I','B')    AND  M.NOD_TP_CD  = 'Z' " ).append("\n"); 
		query.append("                AND D.FIRST_INLND_ROUT_CMB_FLG = 'N'                         THEN D.FULL_PKUP_YD_CD_Y" ).append("\n"); 
		query.append("               WHEN S.PCTL_IO_BND_CD IN ('I','B')    AND  M.NOD_TP_CD  = 'Z' " ).append("\n"); 
		query.append("                AND D.INLND_ROUT_CMB_FLG = 'Y'                               THEN D.FULL_PKUP_YD_CD_Y" ).append("\n"); 
		query.append("               END  )    FULL_PKUP_YD_CD   ," ).append("\n"); 
		query.append("         S.CRE_USR_ID                 , S.CRE_DT                     , S.UPD_USR_ID                 , S.UPD_DT" ).append("\n"); 
		query.append("FROM     PRD_INLND_ROUT_MST  S ," ).append("\n"); 
		query.append("         ( " ).append("\n"); 
		query.append("            SELECT   " ).append("\n"); 
		query.append("                    D.ROUT_ORG_NOD_CD     , D.ROUT_DEST_NOD_CD   , D.ROUT_SEQ           ," ).append("\n"); 
		query.append("                    D.LNK_ORG_NOD_CD      , D.LNK_DEST_NOD_CD    , D.ROUT_DTL_SEQ       ," ).append("\n"); 
		query.append("                    D.INLND_ROUT_CMB_FLG  , D.TRSP_MOD_CD        ," ).append("\n"); 
		query.append("                    ROW_NUMBER( ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ  ORDER     BY D.ROUT_DTL_SEQ ) ROW_POS," ).append("\n"); 
		query.append("                    SUBSTRB( MIN( TO_CHAR(D.ROUT_DTL_SEQ,'FM099')||NVL(D.INLND_ROUT_CMB_FLG,'N') ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ),4)  FIRST_INLND_ROUT_CMB_FLG ," ).append("\n"); 
		query.append("                    SUBSTRB( MAX( TO_CHAR(D.ROUT_DTL_SEQ,'FM099')||NVL(D.INLND_ROUT_CMB_FLG,'N') ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ),4)  LAST_INLND_ROUT_CMB_FLG ," ).append("\n"); 
		query.append("                    SUBSTRB( MIN( TO_CHAR(D.ROUT_DTL_SEQ,'FM099')||D.LNK_DEST_NOD_CD )  OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ),4)  FIRST_LNK_DEST_NOD_CD ," ).append("\n"); 
		query.append("                    SUBSTRB( MAX( (CASE WHEN D.INLND_ROUT_CMB_FLG = 'Y' THEN TO_CHAR(D.ROUT_DTL_SEQ,'FM099')||D.LNK_DEST_NOD_CD  END) ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ),4)  FULL_RTN_CY_CD_Y ," ).append("\n"); 
		query.append("                    SUBSTRB( MAX( TO_CHAR(D.ROUT_DTL_SEQ,'FM099')||D.LNK_ORG_NOD_CD )   OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ),4)  LAST_LNK_ORG_NOD_CD ," ).append("\n"); 
		query.append("                    SUBSTRB( MIN( (CASE WHEN D.INLND_ROUT_CMB_FLG = 'Y' THEN TO_CHAR(D.ROUT_DTL_SEQ,'FM099')||D.LNK_ORG_NOD_CD  END) ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ),4)  FULL_PKUP_YD_CD_Y ," ).append("\n"); 
		query.append("                    MIN( D.TRSP_MOD_CD ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ) MIN_TRSP_MOD_CD ," ).append("\n"); 
		query.append("                    MAX( D.TRSP_MOD_CD ) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ) MAX_TRSP_MOD_CD ," ).append("\n"); 
		query.append("                    MAX( DECODE(D.TRSP_MOD_CD, 'TD','TD')) OVER ( PARTITION BY D.ROUT_ORG_NOD_CD , D.ROUT_DEST_NOD_CD , D.ROUT_SEQ ) TD_TRSP_MOD_CD                                   " ).append("\n"); 
		query.append("            FROM    PRD_INLND_ROUT_DTL   D" ).append("\n"); 
		query.append("         )                          D ," ).append("\n"); 
		query.append("         PRD_NODE           N ," ).append("\n"); 
		query.append("         PRD_NODE           M" ).append("\n"); 
		query.append("WHERE    S.ROUT_ORG_NOD_CD     = D.ROUT_ORG_NOD_CD(+)" ).append("\n"); 
		query.append("AND      S.ROUT_DEST_NOD_CD    = D.ROUT_DEST_NOD_CD(+)" ).append("\n"); 
		query.append("AND      S.ROUT_SEQ            = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND      S.ROUT_ORG_NOD_CD     = N.NOD_CD(+)" ).append("\n"); 
		query.append("AND      S.ROUT_DEST_NOD_CD    = M.NOD_CD(+)" ).append("\n"); 
		query.append("AND      D.ROW_POS(+)          = 1" ).append("\n"); 
		query.append("and      s.ROUT_ORG_NOD_CD= @[i_rout_org_nod_cd]  and s.ROUT_DEST_NOD_CD= @[i_rout_dest_nod_cd]  and s.ROUT_SEQ=	TO_NUMBER(@[i_rout_seq])" ).append("\n"); 
		query.append("         ) S" ).append("\n"); 

	}
}