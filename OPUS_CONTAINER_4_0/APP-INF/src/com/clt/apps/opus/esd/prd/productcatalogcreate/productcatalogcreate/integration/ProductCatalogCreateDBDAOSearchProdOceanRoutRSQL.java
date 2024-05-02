/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchProdOceanRoutRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.06 
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

public class ProductCatalogCreateDBDAOSearchProdOceanRoutRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ProductCatalogCreateDBDAOSearchProdOceanRout
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchProdOceanRoutRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("m_pu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchProdOceanRoutRSQL").append("\n"); 
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
		query.append("  count(*) cnt" ).append("\n"); 
		query.append("FROM PRD_OCN_ROUT A,MDM_VSL_SVC_LANE N1,MDM_VSL_SVC_LANE N2,MDM_VSL_SVC_LANE N3,MDM_VSL_SVC_LANE N4," ).append("\n"); 
		query.append("     (SELECT @[por] POR_POL FROM DUAL -- CHO possible POR (이 경우는 POR=POL이 같은 경우다)" ).append("\n"); 
		query.append("       UNION " ).append("\n"); 
		query.append("      SELECT EQLZ_PORT_CD " ).append("\n"); 
		query.append("        FROM BKG_EQLZ_PORT " ).append("\n"); 
		query.append("       WHERE LOC_CD = (CASE WHEN (@[pol] IS NULL OR @[pol] = @[por]) AND @[por_n] IS NULL AND @[pol_n] IS NULL AND @[m_pu] IS NULL THEN @[por] ELSE 'X' END)" ).append("\n"); 
		query.append("     ) POR," ).append("\n"); 
		query.append("     (SELECT @[del] POD_DEL FROM DUAL " ).append("\n"); 
		query.append("       UNION " ).append("\n"); 
		query.append("      SELECT EQLZ_PORT_CD " ).append("\n"); 
		query.append("        FROM BKG_EQLZ_PORT " ).append("\n"); 
		query.append("       WHERE LOC_CD = (CASE WHEN (@[pod] IS NULL OR @[pod] = @[del]) AND @[pod_n] IS NULL AND @[del_n] IS NULL THEN @[del] ELSE 'X' END)" ).append("\n"); 
		query.append("     ) DEL" ).append("\n"); 
		query.append("WHERE A.ORG_LOC_CD IN (  -- CHO " ).append("\n"); 
		query.append("					SELECT DISTINCT PORT_CD" ).append("\n"); 
		query.append("					  FROM PRD_HUB_LOC_MTCH J1" ).append("\n"); 
		query.append("					 WHERE J1.LOC_CD = POR.POR_POL)" ).append("\n"); 
		query.append("AND A.ORG_LOC_CD = DECODE(@[pol],@[por],A.ORG_LOC_CD,NVL(@[pol],A.ORG_LOC_CD))" ).append("\n"); 
		query.append("AND A.DEST_LOC_CD IN (  -- CHO " ).append("\n"); 
		query.append("                     SELECT DISTINCT PORT_CD " ).append("\n"); 
		query.append("                       FROM PRD_HUB_LOC_MTCH " ).append("\n"); 
		query.append("                      WHERE LOC_CD = DEL.POD_DEL )" ).append("\n"); 
		query.append("AND A.DEST_LOC_CD = DECODE(@[pod],@[del],A.DEST_LOC_CD,NVL(@[pod],A.DEST_LOC_CD))" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND NVL(A.UPD_IND_CD,'S') IN ('C','U','S','T','A','V','G')" ).append("\n"); 
		query.append("AND N1.VSL_SLAN_CD(+) = N1ST_LANE_CD" ).append("\n"); 
		query.append("AND N2.VSL_SLAN_CD(+) = N2ND_LANE_CD" ).append("\n"); 
		query.append("AND N3.VSL_SLAN_CD(+) = N3RD_LANE_CD" ).append("\n"); 
		query.append("AND N4.VSL_SLAN_CD(+) = N4TH_LANE_CD" ).append("\n"); 
		query.append("AND NVL(N1ST_POD_CD, 'XX') = CASE WHEN A.LNK_KNT = 1 AND NVL(@[pod], 'X') <> 'X' THEN @[pod] ELSE NVL(N1ST_POD_CD, 'XX') END " ).append("\n"); 
		query.append("AND NVL(N2ND_POD_CD, 'XX') = CASE WHEN A.LNK_KNT = 2 AND NVL(@[pod], 'X') <> 'X' THEN @[pod] ELSE NVL(N2ND_POD_CD, 'XX') END " ).append("\n"); 
		query.append("AND NVL(N3RD_POD_CD, 'XX') = CASE WHEN A.LNK_KNT = 3 AND NVL(@[pod], 'X') <> 'X' THEN @[pod] ELSE NVL(N3RD_POD_CD, 'XX') END " ).append("\n"); 
		query.append("AND NVL(N4TH_POD_CD, 'XX') = CASE WHEN A.LNK_KNT = 4 AND NVL(@[pod], 'X') <> 'X' THEN @[pod] ELSE NVL(N4TH_POD_CD, 'XX') END                      " ).append("\n"); 
		query.append("AND N1ST_LANE_CD IN ( NVL(@[lane1],N1ST_LANE_CD),(SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = @[lane1]) )" ).append("\n"); 
		query.append("AND NVL(N1ST_LANE_CD, 'X') IN ( DECODE(A.LNK_KNT, 1, NVL(NVL(@[lane2], N1ST_LANE_CD), 'X'), NVL(N1ST_LANE_CD, 'X')), DECODE(A.LNK_KNT, 1, (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD  = @[lane2]), NVL(N1ST_LANE_CD, 'X')))" ).append("\n"); 
		query.append("AND NVL(N2ND_LANE_CD, 'X') IN ( DECODE(A.LNK_KNT, 2, NVL(NVL(@[lane2], N2ND_LANE_CD), 'X'), NVL(N2ND_LANE_CD, 'X')), DECODE(A.LNK_KNT, 2, (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD  = @[lane2]), NVL(N2ND_LANE_CD, 'X')))" ).append("\n"); 
		query.append("AND NVL(N3RD_LANE_CD, 'X') IN ( DECODE(A.LNK_KNT, 3, NVL(NVL(@[lane2], N3RD_LANE_CD), 'X'), NVL(N3RD_LANE_CD, 'X')), DECODE(A.LNK_KNT, 3, (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD  = @[lane2]), NVL(N3RD_LANE_CD, 'X')))" ).append("\n"); 
		query.append("AND NVL(N4TH_LANE_CD, 'X') IN ( DECODE(A.LNK_KNT, 4, NVL(NVL(@[lane2], N4TH_LANE_CD), 'X'), NVL(N4TH_LANE_CD, 'X')), DECODE(A.LNK_KNT, 4, (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD  = @[lane2]), NVL(N4TH_LANE_CD, 'X')))                              " ).append("\n"); 
		query.append("AND NOT EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT 'X' FROM PRD_MBGO_MGMT TT" ).append("\n"); 
		query.append("   WHERE SUBSTR (A.ORG_LOC_CD, 1, 2) = TT.FM_CNT_CD" ).append("\n"); 
		query.append("   AND A.TS_IND_CD = 'D'" ).append("\n"); 
		query.append("   AND SUBSTR (A.DEST_LOC_CD, 1, 2) = TT.TO_CNT_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}