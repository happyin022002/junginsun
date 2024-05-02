/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchEurDrRePatternRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 조용인
*@LastVersion : 1.0
* 2010.03.26 조용인
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author cho yong in
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSearchEurDrRePatternRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주지역 door 재작업을 위한 pattern select
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchEurDrRePatternRSQL(){
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
		params.put("mapSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchEurDrRePatternRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("FIRST_VALUE(M.COP_NO) OVER(PARTITION BY M.COP_PATT_ORD_NO ORDER BY M.COP_PATT_ORD_NO) COP_NO," ).append("\n"); 
		query.append("M.COP_PATT_ORD_NO," ).append("\n"); 
		query.append("FIRST_VALUE(M.PCTL_NO) OVER(PARTITION BY M.COP_PATT_ORD_NO ORDER BY M.COP_PATT_ORD_NO) NEW_PCTL_NO," ).append("\n"); 
		query.append("FIRST_VALUE(H.PCTL_NO) OVER(PARTITION BY M.COP_PATT_ORD_NO ORDER BY M.COP_PATT_ORD_NO) OLD_PCTL_NO," ).append("\n"); 
		query.append("(CASE WHEN (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(B.POR_NOD_CD,1,5)) ='E'" ).append("\n"); 
		query.append("AND  H.OB_TRO_FLG ='Y' AND H.POR_NOD_CD <> B.POR_NOD_CD" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END) EUR_OB_FLG," ).append("\n"); 
		query.append("M.BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("DECODE(B.RCV_TERM_CD||B.POR_NOD_CD||B.POL_CD,M3.BKG_RCV_TERM_CD||M3.POR_NOD_CD||M3.POL_CD,'N','Y') OB_UNCONFIRM_FLG," ).append("\n"); 
		query.append("DECODE(M3.POL_NOD_CD,H.POL_NOD_CD,'N','Y') POL_TML_DIFF_FLG," ).append("\n"); 
		query.append("H.POR_NOD_CD NEW_POR," ).append("\n"); 
		query.append("(CASE WHEN SUBSTR(PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'O'),2,5) <> SUBSTR(M3.POL_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND SUBSTR(PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'O'),-8,5) = SUBSTR(M3.POL_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND SUBSTR(PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'O'),-8,7) <> M3.POL_NOD_CD" ).append("\n"); 
		query.append("AND NVL((SELECT 'Y' FROM PRD_NODE" ).append("\n"); 
		query.append("WHERE NOD_CD =SUBSTR(PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'O'),-8,7)" ).append("\n"); 
		query.append("AND NOD_TP_CD IN ('M','B')),'X') = 'Y'" ).append("\n"); 
		query.append("THEN SUBSTR(PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'O'),-8,7)" ).append("\n"); 
		query.append("END) NEW_POL," ).append("\n"); 
		query.append("M2.MTY_PKUP_YD_CD," ).append("\n"); 
		query.append("M2.FULL_RTN_YD_CD," ).append("\n"); 
		query.append("DECODE(TRO.IO_BND_CD,'O',TRO.BKG_TRSP_MZD_CD) OB_TRSP_MOD," ).append("\n"); 
		query.append("(CASE WHEN (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(B.DEL_NOD_CD,1,5)) ='E'" ).append("\n"); 
		query.append("AND H.IB_TRO_FLG ='Y' AND H.DEL_NOD_CD <> B.DEL_NOD_CD" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END) EUR_IB_FLG," ).append("\n"); 
		query.append("M.BKG_DE_TERM_CD," ).append("\n"); 
		query.append("DECODE(B.DE_TERM_CD||B.DEL_NOD_CD||B.POD_CD,M3.BKG_DE_TERM_CD||M3.DEL_NOD_CD||M3.POD_CD,'N','Y') IB_UNCONFIRM_FLG," ).append("\n"); 
		query.append("DECODE(M3.POD_NOD_CD,H.POD_NOD_CD,'N','Y') POD_TML_DIFF_FLG," ).append("\n"); 
		query.append("(CASE WHEN SUBSTR(PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'T'),-8,5) <> SUBSTR(M3.POD_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND SUBSTR(PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'I'),2,5) = SUBSTR(M3.POD_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND SUBSTR(PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'I'),2,7) <> M3.POD_NOD_CD" ).append("\n"); 
		query.append("AND NVL((SELECT 'Y' FROM PRD_NODE" ).append("\n"); 
		query.append("WHERE NOD_CD =SUBSTR(PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'I'),2,7)" ).append("\n"); 
		query.append("AND NOD_TP_CD IN ('M','B')),'X') = 'Y'" ).append("\n"); 
		query.append("THEN SUBSTR(PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'I'),2,7)" ).append("\n"); 
		query.append("END) NEW_POD," ).append("\n"); 
		query.append("H.DEL_NOD_CD NEW_DEL," ).append("\n"); 
		query.append("M2.FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("M2.MTY_RTN_YD_CD," ).append("\n"); 
		query.append("DECODE(TRO.IO_BND_CD,'I',TRO.BKG_TRSP_MZD_CD) IB_TRSP_MOD," ).append("\n"); 
		query.append("PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'O') OB_CONTENT," ).append("\n"); 
		query.append("PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'I') IB_CONTENT," ).append("\n"); 
		query.append("PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'T') OCN_CONTENT," ).append("\n"); 
		query.append("(SELECT TO_CHAR(MAX(ARR_ST_DT),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO =M.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='O') CCT ," ).append("\n"); 
		query.append("(SELECT TO_CHAR(MIN(ARR_ST_DT),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO =M.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='T') POL_T," ).append("\n"); 
		query.append("(SELECT TO_CHAR(MIN(ARR_ST_DT),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO =M.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='I') POD_T ," ).append("\n"); 
		query.append("M3.TRNK_VSL_CD||M3.TRNK_SKD_VOY_NO||M3.TRNK_SKD_DIR_CD T_VVD," ).append("\n"); 
		query.append("CLL_P.ORG_LOC_CD,CLL_P.DEST_LOC_CD,CLL_P.OCN_SEQ," ).append("\n"); 
		query.append("PRD_GET_OCN_VVD_FNC(M.PCTL_NO,1) VVD1,PRD_GET_OCN_VVD_FNC(M.PCTL_NO,2) VVD2,PRD_GET_OCN_VVD_FNC(M.PCTL_NO,3) VVD3,PRD_GET_OCN_VVD_FNC(M.PCTL_NO,4) VVD4," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLL_P.CLPT_SEQ,  INSTR(CLL_P.CLPT_SEQ,'N1_POL_SEQ')+10,1)) N1_POL_CLPT_SEQ," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLL_P.CLPT_SEQ,  INSTR(CLL_P.CLPT_SEQ,'N1_POD_SEQ')+10,1)) N1_POD_CLPT_SEQ," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLL_P.CLPT_SEQ,  INSTR(CLL_P.CLPT_SEQ,'N2_POL_SEQ')+10,1)) N2_POL_CLPT_SEQ," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLL_P.CLPT_SEQ,  INSTR(CLL_P.CLPT_SEQ,'N2_POD_SEQ')+10,1)) N2_POD_CLPT_SEQ," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLL_P.CLPT_SEQ,  INSTR(CLL_P.CLPT_SEQ,'N3_POL_SEQ')+10,1)) N3_POL_CLPT_SEQ," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLL_P.CLPT_SEQ,  INSTR(CLL_P.CLPT_SEQ,'N3_POD_SEQ')+10,1)) N3_POD_CLPT_SEQ," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLL_P.CLPT_SEQ,  INSTR(CLL_P.CLPT_SEQ,'N4_POL_SEQ')+10,1)) N4_POL_CLPT_SEQ," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLL_P.CLPT_SEQ,  INSTR(CLL_P.CLPT_SEQ,'N4_POD_SEQ')+10,1)) N4_POD_CLPT_SEQ" ).append("\n"); 
		query.append("FROM PRD_BKG_COP_MAP M, BKG_BOOKING B, SCE_COP_HDR H, PRD_PROD_CTL_MST M3, SCE_TRO_MAPG TM, BKG_EUR_TRO TRO, PRD_PROD_CTL_MST M2 ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT PCTL_NO,ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ OCN_SEQ," ).append("\n"); 
		query.append("'N1_POL_SEQ'||MAX(DECODE(R,1, ORG_CLPT_IND_SEQ,' ')) ||" ).append("\n"); 
		query.append("'N1_POD_SEQ'||MAX(DECODE(R,1, DEST_CLPT_IND_SEQ,' ')) ||" ).append("\n"); 
		query.append("'N2_POL_SEQ'||MAX(DECODE(R,2, ORG_CLPT_IND_SEQ,' ')) ||" ).append("\n"); 
		query.append("'N2_POD_SEQ'||MAX(DECODE(R,2, DEST_CLPT_IND_SEQ,' ')) ||" ).append("\n"); 
		query.append("'N3_POL_SEQ'||MAX(DECODE(R,3, ORG_CLPT_IND_SEQ,' ')) ||" ).append("\n"); 
		query.append("'N3_POD_SEQ'||MAX(DECODE(R,3, DEST_CLPT_IND_SEQ,' ')) ||" ).append("\n"); 
		query.append("'N4_POL_SEQ'||MAX(DECODE(R,4, ORG_CLPT_IND_SEQ,' ')) ||" ).append("\n"); 
		query.append("'N4_POD_SEQ'||MAX(DECODE(R,4, DEST_CLPT_IND_SEQ,' ')) CLPT_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT D.PCTL_NO,D.ORG_CLPT_IND_SEQ, D.DEST_CLPT_IND_SEQ,O.ORG_LOC_CD,O.DEST_LOC_CD,O.ROUT_SEQ, ROW_NUMBER() OVER (PARTITION BY D.PCTL_NO ORDER BY PCTL_SEQ) R" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL D, PRD_OCN_ROUT O" ).append("\n"); 
		query.append("WHERE D.PCTL_NO = (SELECT PCTL_NO FROM PRD_BKG_COP_MAP WHERE BKG_NO =@[bkg_no] AND COP_MAPG_SEQ =@[mapSeq] AND COP_PATT_ORD_NO =1 AND ROWNUM =1)" ).append("\n"); 
		query.append("AND D.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("AND D.TRSP_MOD_CD IN ('WD','VD')" ).append("\n"); 
		query.append("AND D.ROUT_ORG_NOD_CD= O.ORG_LOC_CD" ).append("\n"); 
		query.append("AND D.ROUT_DEST_NOD_CD=DEST_LOC_CD" ).append("\n"); 
		query.append("AND D.ROUT_SEQ= O.ROUT_SEQ" ).append("\n"); 
		query.append("AND D.VSL_SLAN_CD IN (O.N1ST_LANE_CD, N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY PCTL_NO,ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ" ).append("\n"); 
		query.append(") CLL_P" ).append("\n"); 
		query.append("WHERE M.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("AND M.COP_MAPG_SEQ =@[mapSeq]" ).append("\n"); 
		query.append("AND M.COP_PATT_ORD_NO IS NOT NULL" ).append("\n"); 
		query.append("AND M.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND M.COP_NO = H.COP_NO" ).append("\n"); 
		query.append("AND M.PCTL_NO = M3.PCTL_NO" ).append("\n"); 
		query.append("AND H.COP_NO =TM.COP_NO" ).append("\n"); 
		query.append("AND H.PCTL_NO = M2.PCTL_NO" ).append("\n"); 
		query.append("AND TRO.BKG_NO =B.BKG_NO" ).append("\n"); 
		query.append("AND TM.TRO_SEQ = TRO.TRO_SEQ" ).append("\n"); 
		query.append("AND TM.TRO_SUB_SEQ = TRO.RQST_SUB_SEQ" ).append("\n"); 
		query.append("AND TM.IO_BND_CD = TRO.IO_BND_CD" ).append("\n"); 

	}
}