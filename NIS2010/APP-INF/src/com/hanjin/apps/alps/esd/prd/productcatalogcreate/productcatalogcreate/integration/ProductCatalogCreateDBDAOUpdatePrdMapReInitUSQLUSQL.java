/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOUpdatePrdMapReInitUSQLUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.05
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.12.05 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOUpdatePrdMapReInitUSQLUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주 지역 DOOR 다른 경우 처리를 위한 MAP DATA UPDATE
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOUpdatePrdMapReInitUSQLUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOUpdatePrdMapReInitUSQLUSQL").append("\n"); 
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
		query.append("UPDATE PRD_BKG_COP_MAP MAP " ).append("\n"); 
		query.append("SET (MAP.COP_PATT_ORD_NO,MAP.OB_ITCHG_CTNT, MAP.IB_ITCHG_CTNT, MAP.OCN_ITCHG_CTNT) = " ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       SELECT ORD,PRD_GET_COP_BND_SO_STR_FNC(COP_NO,'0'), PRD_GET_COP_BND_SO_STR_FNC(COP_NO,'I'),PRD_GET_COP_BND_SO_STR_FNC(COP_NO,'T') " ).append("\n"); 
		query.append("       FROM " ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT COP_NO,(CASE WHEN EUR_OB_FLG ='N' AND EUR_IB_FLG ='N' THEN NULL" ).append("\n"); 
		query.append("                            ELSE DENSE_RANK() OVER ( ORDER BY  FULL_RK DESC NULLS LAST , FULL_ROUT )" ).append("\n"); 
		query.append("                      END) ORD" ).append("\n"); 
		query.append("       FROM (" ).append("\n"); 
		query.append("           SELECT COP_NO,EUR_OB_FLG,EUR_IB_FLG, " ).append("\n"); 
		query.append("                  (CASE WHEN EUR_OB_FLG ='N' AND EUR_IB_FLG ='N' " ).append("\n"); 
		query.append("                         THEN NULL" ).append("\n"); 
		query.append("                         ELSE COUNT(*) OVER (PARTITION BY MTY_PKUP_YD_CD,MTY_RTN_YD_CD,EUR_OB_FLG,POL_TML_DIFF_FLG,EUR_IB_FLG,POD_TML_DIFF_FLG,OUTBOUND,INBOUND  )" ).append("\n"); 
		query.append("                   END) FULL_RK," ).append("\n"); 
		query.append("                  MTY_PKUP_YD_CD||MTY_RTN_YD_CD||EUR_OB_FLG||POL_TML_DIFF_FLG||EUR_IB_FLG||POD_TML_DIFF_FLG||OUTBOUND||INBOUND FULL_ROUT" ).append("\n"); 
		query.append("           FROM " ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("               SELECT " ).append("\n"); 
		query.append("               M.COP_NO," ).append("\n"); 
		query.append("               M2.MTY_PKUP_YD_CD,M2.MTY_RTN_YD_CD," ).append("\n"); 
		query.append("               (CASE WHEN (SELECT CONTI_CD FROM MDM_LOCATION L WHERE L.LOC_CD = SUBSTR(B.POR_NOD_CD,1,5) AND NVL(L.DELT_FLG,'N') = 'N') ='E'" ).append("\n"); 
		query.append("                           AND H.OB_TRO_FLG ='Y' AND H.POR_NOD_CD <> B.POR_NOD_CD" ).append("\n"); 
		query.append("               THEN 'Y'" ).append("\n"); 
		query.append("               ELSE 'N'" ).append("\n"); 
		query.append("               END) EUR_OB_FLG," ).append("\n"); 
		query.append("               DECODE(M3.POL_NOD_CD,M2.POL_NOD_CD,'N','Y') POL_TML_DIFF_FLG," ).append("\n"); 
		query.append("               (CASE WHEN (SELECT CONTI_CD FROM MDM_LOCATION L WHERE L.LOC_CD = SUBSTR(B.DEL_NOD_CD,1,5) AND NVL(L.DELT_FLG,'N') = 'N') ='E'" ).append("\n"); 
		query.append("                           AND H.IB_TRO_FLG ='Y' AND H.DEL_NOD_CD <> B.DEL_NOD_CD" ).append("\n"); 
		query.append("               THEN 'Y'" ).append("\n"); 
		query.append("               ELSE 'N'" ).append("\n"); 
		query.append("               END) EUR_IB_FLG," ).append("\n"); 
		query.append("               DECODE(M3.POD_NOD_CD,M2.POD_NOD_CD,'N','Y') POD_TML_DIFF_FLG," ).append("\n"); 
		query.append("               (SELECT ROUT_ORG_NOD_CD||ROUT_DEST_NOD_CD||ROUT_SEQ " ).append("\n"); 
		query.append("                 FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                 WHERE PCTL_NO =H.PCTL_NO" ).append("\n"); 
		query.append("                 AND PCTL_SEQ =1) OUTBOUND," ).append("\n"); 
		query.append("               (SELECT ROUT_ORG_NOD_CD||ROUT_DEST_NOD_CD||ROUT_SEQ " ).append("\n"); 
		query.append("                 FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                 WHERE PCTL_NO =H.PCTL_NO" ).append("\n"); 
		query.append("                 AND PCTL_IO_BND_CD ='I'" ).append("\n"); 
		query.append("                 AND ROWNUM =1) INBOUND" ).append("\n"); 
		query.append("               FROM PRD_BKG_COP_MAP M, BKG_BOOKING B, SCE_COP_HDR H, PRD_PROD_CTL_MST M2,PRD_PROD_CTL_MST M3" ).append("\n"); 
		query.append("               WHERE M.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("               AND M.COP_MAPG_SEQ =@[mapSeq]" ).append("\n"); 
		query.append("               AND M.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("               AND M.COP_NO = H.COP_NO" ).append("\n"); 
		query.append("               AND M.PCTL_NO = M3.PCTL_NO" ).append("\n"); 
		query.append("               AND H.PCTL_NO =M2.PCTL_NO" ).append("\n"); 
		query.append("           ) A" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("       )X " ).append("\n"); 
		query.append("     WHERE X.COP_NO =MAP.COP_NO" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("WHERE MAP.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("AND MAP.COP_MAPG_SEQ =@[mapSeq]" ).append("\n"); 

	}
}