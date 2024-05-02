/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ProductCatalogHinterlandDBDAOCheckInlandCostActivityRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.12 
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

public class ProductCatalogHinterlandDBDAOCheckInlandCostActivityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inland(Hinterland) Cost Activity가 생성되었는지 점검한다.
	  * </pre>
	  */
	public ProductCatalogHinterlandDBDAOCheckInlandCostActivityRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogHinterlandDBDAOCheckInlandCostActivityRSQL").append("\n"); 
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
		query.append("SELECT DECODE(BOUND, 'O', 'Outbound', 'I', 'Inbound') " ).append("\n"); 
		query.append("                 || '[' || REGEXP_REPLACE(PRD_GET_INLND_ROUT_STR_FNC(ORIGIN, DEST, ROUT_SEQ), '-.-', '-') || ']' ERR_MSG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    select l.* , LEAD(DEST_CHK) OVER (PARTITION BY PCTL_NO, BOUND ORDER BY ACT1) nx_DEST_CHK" ).append("\n"); 
		query.append("    from (" ).append("\n"); 
		query.append("            SELECT PCTL_NO, COST_ACT_GRP_SEQ ACT1, NXT_COST_ACT_GRP_SEQ ACT2, COST_ACT_GRP_CD ACT_CD1, NXT_COST_ACT_GRP_CD ACT_CD2" ).append("\n"); 
		query.append("                , PCTL_IO_BND_CD BOUND, ROUT_ORG_NOD_CD ORIGIN, ROUT_DEST_NOD_CD DEST" ).append("\n"); 
		query.append("                , N1ST_NOD_CD N1, N2ND_NOD_CD N2, N3RD_NOD_CD N3, N4TH_NOD_CD N4 " ).append("\n"); 
		query.append("                , DECODE(ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                       , CASE WHEN SUBSTR(COST_ACT_GRP_CD,1,2) = 'OD' THEN N2ND_NOD_CD" ).append("\n"); 
		query.append("                              ELSE N1ST_NOD_CD END" ).append("\n"); 
		query.append("                       , 'Y','N') ORIGIN_CHK" ).append("\n"); 
		query.append("                , DECODE(ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                       , CASE WHEN SUBSTR(COST_ACT_GRP_CD,1,2) = 'ID' OR SUBSTR(NXT_COST_ACT_GRP_CD,1,2) = 'ID' THEN" ).append("\n"); 
		query.append("                              CASE WHEN N4TH_NOD_CD IS NOT NULL THEN N3RD_NOD_CD" ).append("\n"); 
		query.append("                                   WHEN N3RD_NOD_CD IS NOT NULL THEN N2ND_NOD_CD" ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("                             ELSE" ).append("\n"); 
		query.append("                              CASE WHEN N4TH_NOD_CD IS NOT NULL THEN N4TH_NOD_CD" ).append("\n"); 
		query.append("                                   WHEN N3RD_NOD_CD IS NOT NULL THEN N3RD_NOD_CD" ).append("\n"); 
		query.append("                                   WHEN N2ND_NOD_CD IS NOT NULL THEN N2ND_NOD_CD" ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("                       , 'Y', 'N') AS DEST_CHK" ).append("\n"); 
		query.append("                 ,ROUT_SEQ , rn" ).append("\n"); 
		query.append("                 ,nvl((select 'N' " ).append("\n"); 
		query.append("                         from prd_inlnd_rout_dtl i " ).append("\n"); 
		query.append("                        where i.ROUT_ORG_NOD_CD =a.ROUT_ORG_NOD_CD " ).append("\n"); 
		query.append("                          and  i.ROUT_DEST_NOD_CD = a.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                          and  i.ROUT_SEQ = a.rout_seq" ).append("\n"); 
		query.append("                          and  a.PCTL_IO_BND_CD in ('I','O')" ).append("\n"); 
		query.append("                          and  i.ROUT_DTL_SEQ > decode (substr(i.ROUT_ORG_NOD_CD,1,2) ,'US',5,'CA',5,'MX',5, 2 )" ).append("\n"); 
		query.append("                          and  rownum =1 " ).append("\n"); 
		query.append("                      ),'Y') optm_irg_lnk_cnt" ).append("\n"); 
		query.append("            FROM (    ----------a" ).append("\n"); 
		query.append("                select i.*, LEAD(rn) OVER (PARTITION BY PCTL_NO, PCTL_IO_BND_CD ORDER BY COST_ACT_GRP_SEQ) nx_rn" ).append("\n"); 
		query.append("                  from (" ).append("\n"); 
		query.append("                        SELECT PCTL_NO" ).append("\n"); 
		query.append("                             , COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                             , LEAD(COST_ACT_GRP_SEQ) OVER (PARTITION BY PCTL_NO, PCTL_IO_BND_CD ORDER BY COST_ACT_GRP_SEQ) NXT_COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                             , COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                             , LEAD(COST_ACT_GRP_CD) OVER (PARTITION BY PCTL_NO, PCTL_IO_BND_CD ORDER BY COST_ACT_GRP_SEQ) NXT_COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                             , PCTL_IO_BND_CD, ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                             , N1ST_NOD_CD, N2ND_NOD_CD" ).append("\n"); 
		query.append("                             , NVL(N3RD_NOD_CD" ).append("\n"); 
		query.append("                                        , DECODE(DECODE(NULL, N3RD_NOD_CD, 1, N4TH_NOD_CD, 2)" ).append("\n"); 
		query.append("                                              , 1,LEAD(N2ND_NOD_CD) OVER (PARTITION BY PCTL_NO, PCTL_IO_BND_CD ORDER BY COST_ACT_GRP_SEQ))" ).append("\n"); 
		query.append("                                  ) N3RD_NOD_CD" ).append("\n"); 
		query.append("                             , NVL(N4TH_NOD_CD" ).append("\n"); 
		query.append("                                        , DECODE(DECODE(NULL, N3RD_NOD_CD, 1, N4TH_NOD_CD, 2)" ).append("\n"); 
		query.append("                                              , 1,LEAD(N3RD_NOD_CD) OVER (PARTITION BY PCTL_NO, PCTL_IO_BND_CD ORDER BY COST_ACT_GRP_SEQ)" ).append("\n"); 
		query.append("                                              , 2,LEAD(N2ND_NOD_CD) OVER (PARTITION BY PCTL_NO, PCTL_IO_BND_CD ORDER BY COST_ACT_GRP_SEQ)) " ).append("\n"); 
		query.append("                                  ) N4TH_NOD_CD" ).append("\n"); 
		query.append("                             , ROW_NUMBER() OVER (PARTITION BY PCTL_NO, PCTL_IO_BND_CD ORDER BY COST_ACT_GRP_SEQ) RN" ).append("\n"); 
		query.append("                             , ROUT_SEQ" ).append("\n"); 
		query.append("                        FROM PRD_PROD_CTL_ACT_GRP_DTL" ).append("\n"); 
		query.append("                        WHERE SUBSTR(@[hd_pctl_no],1,1) = 'H'" ).append("\n"); 
		query.append("                        AND PCTL_NO LIKE DECODE(@[hd_pctl_no], null, null, @[hd_pctl_no] || '%')" ).append("\n"); 
		query.append("                        AND PCTL_IO_BND_CD IN ('O', 'I')" ).append("\n"); 
		query.append("                        AND COST_ACT_GRP_TP_CD = 'L'" ).append("\n"); 
		query.append("                       ) i" ).append("\n"); 
		query.append("                       where rn =1 or NXT_COST_ACT_GRP_SEQ is null" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("        --    WHERE RN = 1" ).append("\n"); 
		query.append("         ) l" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("WHERE  (ORIGIN_CHK = 'N' OR nvl(NX_DEST_CHK,DEST_CHK) = 'N'  OR optm_irg_lnk_cnt = 'N')" ).append("\n"); 
		query.append("and rn = 1" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DECODE(PCTL_IO_BND_CD, 'O', 'Outbound', 'I', 'Inbound') " ).append("\n"); 
		query.append("                 || '[' || REGEXP_REPLACE(PRD_GET_INLND_ROUT_STR_FNC(ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ), '-.-', '-') || ']' ERR_MSG" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("WHERE PCTL_NO LIKE " ).append("\n"); 
		query.append("       ( SELECT DECODE(COUNT(1), 0, @[hd_pctl_no] || '%')" ).append("\n"); 
		query.append("        FROM PRD_PROD_CTL_ACT_GRP_DTL A" ).append("\n"); 
		query.append("        WHERE SUBSTR(@[hd_pctl_no],1,1) = 'H' " ).append("\n"); 
		query.append("          AND PCTL_NO LIKE DECODE(@[hd_pctl_no], null, null, @[hd_pctl_no] || '%')" ).append("\n"); 
		query.append("          AND PCTL_IO_BND_CD IN ('O', 'I')" ).append("\n"); 
		query.append("          AND COST_ACT_GRP_TP_CD = 'L' )" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD IN ('O', 'I')" ).append("\n"); 
		query.append("AND ROUT_SEQ > 0" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}