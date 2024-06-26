/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchPrdCnstInfoRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.30 
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

public class ProductCatalogCreateDBDAOSearchPrdCnstInfoRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 생성된 PC의 해당되는 prd_rout_cnst를 조회한다.
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchPrdCnstInfoRouteRSQL(){
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
		query.append("FileName : ProductCatalogCreateDBDAOSearchPrdCnstInfoRouteRSQL").append("\n"); 
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
		query.append("SELECT NVL(R.SVC_USE_FLG, 'Y') SVC_USE_FLG" ).append("\n"); 
		query.append("     , R.POL_NOD_CD || ' - ' || R.POD_NOD_CD NTWK_UT_NM" ).append("\n"); 
		query.append("     , 'Others' ITM_NM" ).append("\n"); 
		query.append("     , R.DIR_CD" ).append("\n"); 
		query.append("     , R.TRNK_LANE_CD VSL_SLAN_CD" ).append("\n"); 
		query.append("     , R.VSL_CD || R.SKD_VOY_NO || R.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , R.CNTR_TP_CD" ).append("\n"); 
		query.append("     , R.CMDT_CD" ).append("\n"); 
		query.append("     , R.ROUT_CNST_RMK CNST_RMK" ).append("\n"); 
		query.append("     , R.CRE_OFC_CD" ).append("\n"); 
		query.append("     , R.CRE_USR_ID" ).append("\n"); 
		query.append(" FROM PRD_ROUT_CNST R," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT  M.PCTL_NO, POL_CD," ).append("\n"); 
		query.append("				MAX (DECODE (TS.RK, 1, TS.LANE_CD)) N1ST_LANE_CD, N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("				MAX (DECODE (TS.RK, 2, TS.LANE_CD)) N2ND_LANE_CD, N2ND_TS_PORT_CD," ).append("\n"); 
		query.append("				MAX (DECODE (TS.RK, 3, TS.LANE_CD)) N3RD_LANE_CD," ).append("\n"); 
		query.append("				POD_CD, DEL_NOD_CD," ).append("\n"); 
		query.append("				MAX (DECODE (TS.RK, 1, TS.VVD)) N1ST_VVD," ).append("\n"); 
		query.append("				MAX (DECODE (TS.RK, 2, TS.VVD)) N2ND_VVD," ).append("\n"); 
		query.append("				MAX (DECODE (TS.RK, 3, TS.VVD)) N3RD_VVD," ).append("\n"); 
		query.append("				MAX (DECODE (TS.RK, 4, TS.VVD)) N4TH_VVD," ).append("\n"); 
		query.append("				(SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("				FROM VSK_VSL_SKD V" ).append("\n"); 
		query.append("				WHERE V.VSL_CD = TRNK_VSL_CD" ).append("\n"); 
		query.append("				AND V.SKD_VOY_NO = TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("				AND V.SKD_DIR_CD = TRNK_SKD_DIR_CD ) TRNK_LANE," ).append("\n"); 
		query.append("				(SELECT DECODE(S.VSL_SVC_TP_CD, 'O', 'FDR')" ).append("\n"); 
		query.append("				FROM VSK_VSL_SKD V, MDM_VSL_SVC_LANE S" ).append("\n"); 
		query.append("				WHERE V.VSL_CD = TRNK_VSL_CD" ).append("\n"); 
		query.append("				AND V.SKD_VOY_NO = TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("				AND V.SKD_DIR_CD = TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("				AND S.VSL_SLAN_CD = V.VSL_SLAN_CD ) TRNK_FDR_LANE," ).append("\n"); 
		query.append("				(SELECT /*+INDEX (D XPKPRD_PROD_CTL_ROUT_DTL) */" ).append("\n"); 
		query.append("	    				ORG_NOD_CD" ).append("\n"); 
		query.append("				FROM PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("				WHERE PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("				AND PCTL_IO_BND_CD = 'I' AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("   			AND MTY_YD_FLG = 'N'" ).append("\n"); 
		query.append("    			AND ROWNUM = 1" ).append("\n"); 
		query.append("				) POD_NOD" ).append("\n"); 
		query.append("			,MAX (DECODE (TS.RK, 1, ORG_NOD_CD )) N1ST_ORG_NOD_CD, MAX (DECODE (TS.RK, 1, DEST_NOD_CD )) N1ST_DEST_NOD_CD" ).append("\n"); 
		query.append("			,MAX (DECODE (TS.RK, 2, ORG_NOD_CD )) N2ND_ORG_NOD_CD, MAX (DECODE (TS.RK, 2, DEST_NOD_CD )) N2ND_DEST_NOD_CD" ).append("\n"); 
		query.append("			,MAX (DECODE (TS.RK, 3, ORG_NOD_CD )) N3RD_ORG_NOD_CD, MAX (DECODE (TS.RK, 3, DEST_NOD_CD )) N3RD_DEST_NOD_CD" ).append("\n"); 
		query.append("			,MAX (M.CMDT_CD) CMDT_CD" ).append("\n"); 
		query.append("			,MAX (DECODE (TS.RK, 1, TS.FDR_LANE_CD)) N1ST_FDR_LANE_CD" ).append("\n"); 
		query.append("			,MAX (DECODE (TS.RK, 2, TS.FDR_LANE_CD)) N2ND_FDR_LANE_CD" ).append("\n"); 
		query.append("			,MAX (DECODE (TS.RK, 3, TS.FDR_LANE_CD)) N3RD_FDR_LANE_CD" ).append("\n"); 
		query.append("		FROM PRD_PROD_CTL_MST M," ).append("\n"); 
		query.append("			 (SELECT DTL.PCTL_NO,DTL.ORG_NOD_CD,DTL.DEST_NOD_CD, DTL.VSL_CD || DTL.SKD_VOY_NO || DTL.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("					 RANK () OVER (PARTITION BY DTL.PCTL_NO ORDER BY DTL.PCTL_SEQ) RK," ).append("\n"); 
		query.append("                     DTL.VSL_SLAN_CD LANE_CD, DECODE(SLAN.VSL_SVC_TP_CD, 'O', 'FDR') FDR_LANE_CD" ).append("\n"); 
		query.append("				FROM PRD_PROD_CTL_ROUT_DTL DTL, PRD_OCN_ROUT ROUT, MDM_VSL_SVC_LANE SLAN" ).append("\n"); 
		query.append("			   WHERE DTL.PCTL_NO = @[pctl_no] " ).append("\n"); 
		query.append("			    AND  DTL.VSL_SLAN_CD IS NOT NULL" ).append("\n"); 
		query.append("				AND  DTL.ROUT_ORG_NOD_CD = ROUT.ORG_LOC_CD" ).append("\n"); 
		query.append("				AND	 DTL.ROUT_DEST_NOD_CD = ROUT.DEST_LOC_CD" ).append("\n"); 
		query.append("				AND	 DTL.ROUT_SEQ = ROUT.ROUT_SEQ" ).append("\n"); 
		query.append("				AND SLAN.VSL_SLAN_CD(+) = DTL.VSL_SLAN_CD" ).append("\n"); 
		query.append("			 ) TS" ).append("\n"); 
		query.append("		WHERE M.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("		AND M.PCTL_NO = TS.PCTL_NO(+)" ).append("\n"); 
		query.append("		GROUP BY M.PCTL_NO, POL_CD," ).append("\n"); 
		query.append("				 N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("				 N2ND_TS_PORT_CD," ).append("\n"); 
		query.append("				 POD_CD," ).append("\n"); 
		query.append("				 DEL_NOD_CD," ).append("\n"); 
		query.append("				 TRNK_VSL_CD," ).append("\n"); 
		query.append("				 TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("				 TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("	 ) MST," ).append("\n"); 
		query.append("	 PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("WHERE ( MST.TRNK_LANE = DECODE(R.TRNK_LANE_CD, 'ALL',MST.TRNK_LANE,R.TRNK_LANE_CD)" ).append("\n"); 
		query.append("        OR MST.TRNK_FDR_LANE = R.TRNK_LANE_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("AND MST.POL_CD LIKE DECODE(R.POL_NOD_CD, 'ALL', MST.POL_CD, SUBSTR(R.POL_NOD_CD,1,5)||'%')" ).append("\n"); 
		query.append("AND MST.N1ST_ORG_NOD_CD LIKE DECODE(LENGTH(R.POL_NOD_CD),7,R.POL_NOD_CD, MST.N1ST_ORG_NOD_CD)" ).append("\n"); 
		query.append("AND MST.POD_NOD LIKE DECODE(R.POD_NOD_CD, 'ALL', MST.POD_CD, R.POD_NOD_CD) ||'%'" ).append("\n"); 
		query.append("AND NVL(MST.DEL_NOD_CD, R.DEL_NOD_CD) LIKE NVL(R.DEL_NOD_CD, MST.DEL_NOD_CD)||'%'" ).append("\n"); 
		query.append("AND NVL(MST.N1ST_TS_PORT_CD, ' ') = NVL(R.N1ST_TS_PORT_CD, NVL(MST.N1ST_TS_PORT_CD, ' '))" ).append("\n"); 
		query.append("AND NVL(MST.N2ND_TS_PORT_CD, ' ') = NVL(R.N2ND_TS_PORT_CD, NVL(MST.N2ND_TS_PORT_CD, ' '))" ).append("\n"); 
		query.append("AND NVL(MST.N1ST_LANE_CD, '%') || ',' || MST.N1ST_FDR_LANE_CD like '%' || R.N1ST_LANE_CD || '%' " ).append("\n"); 
		query.append("AND NVL(MST.N2ND_LANE_CD, '%') || ',' || MST.N2ND_FDR_LANE_CD like '%' || R.N2ND_LANE_CD || '%' " ).append("\n"); 
		query.append("AND NVL(MST.N3RD_LANE_CD, '%') || ',' || MST.N3RD_FDR_LANE_CD like '%' || R.N3RD_LANE_CD || '%'" ).append("\n"); 
		query.append("AND NVL(MST.CMDT_CD,'#')  = NVL(R.CMDT_CD, NVL(MST.CMDT_CD,'#')) " ).append("\n"); 
		query.append("AND (   NVL(MST.N1ST_VVD, '#') = NVL(R.VSL_CD || R.SKD_VOY_NO || R.SKD_DIR_CD, NVL(MST.N1ST_VVD, '#'))" ).append("\n"); 
		query.append("     OR NVL(MST.N2ND_VVD, '#') = NVL(R.VSL_CD || R.SKD_VOY_NO || R.SKD_DIR_CD, NVL(MST.N2ND_VVD, '#'))" ).append("\n"); 
		query.append("     OR NVL(MST.N3RD_VVD, '#') = NVL(R.VSL_CD || R.SKD_VOY_NO || R.SKD_DIR_CD, NVL(MST.N3RD_VVD, '#'))" ).append("\n"); 
		query.append("     OR NVL(MST.N4TH_VVD, '#') = NVL(R.VSL_CD || R.SKD_VOY_NO || R.SKD_DIR_CD, NVL(MST.N4TH_VVD, '#'))" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND MST.PCTL_NO = Q.PCTL_NO " ).append("\n"); 
		query.append("AND NVL(R.CNTR_TP_CD, Q.CNTR_TPSZ_CD)   " ).append("\n"); 
		query.append("	= DECODE(R.CNTR_TP_CD, NULL, Q.CNTR_TPSZ_CD, DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 1, 1), 'T', 'T', 'O', 'S', 'F', 'S',   " ).append("\n"); 
		query.append("														--'D',DECODE(Q.CNTR_TPSZ_CD, 'D5', 'D5', 'D7', 'D7', Q.CNTR_TPSZ_CD)," ).append("\n"); 
		query.append("														--'R',DECODE(Q.CNTR_TPSZ_CD, 'R2', 'R2', 'R5', 'R5', Q.CNTR_TPSZ_CD)) )" ).append("\n"); 
		query.append("														'D',Q.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("														'R',Q.CNTR_TPSZ_CD) )" ).append("\n"); 
		query.append("-- 이란 Sanciton 관련 System Block 예외 요청" ).append("\n"); 
		query.append("-- BLOCK 이 필요없을시 PRD_PGM_ROLE 테이블의 값을 'N'으로 변경하면 아래로직을 타지 않는다." ).append("\n"); 
		query.append("AND NOT EXISTS(" ).append("\n"); 
		query.append("                    SELECT 'X' FROM DUAL WHERE MST.POL_CD like 'US%' AND MST.POD_CD='IRBUZ' " ).append("\n"); 
		query.append("                                         AND R.POD_NOD_CD LIKE 'IR%' AND R.SVC_USE_FLG ='N'" ).append("\n"); 
		query.append("  					                     AND 'Y' = NVL((SELECT PCTL_PGM_ROLE_CD FROM PRD_PGM_ROLE WHERE PGM_NO='ESD_PRD_IR_EXCEPTION'),'N')    " ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT 'X' FROM DUAL WHERE MST.POL_CD like 'KR%' AND MST.POD_CD='IRBUZ' " ).append("\n"); 
		query.append("                                         AND R.POD_NOD_CD LIKE 'IR%' AND R.SVC_USE_FLG ='N'" ).append("\n"); 
		query.append("  					                     AND 'Y' = NVL((SELECT PCTL_PGM_ROLE_CD FROM PRD_PGM_ROLE WHERE PGM_NO='ESD_PRD_IR_EXCEPTION'),'N')   " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY NVL(R.SVC_USE_FLG, 'Y')" ).append("\n"); 

	}
}