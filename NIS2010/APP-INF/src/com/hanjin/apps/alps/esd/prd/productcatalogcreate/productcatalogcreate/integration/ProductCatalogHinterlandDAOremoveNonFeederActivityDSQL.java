/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ProductCatalogHinterlandDAOremoveNonFeederActivityDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.04 
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

public class ProductCatalogHinterlandDAOremoveNonFeederActivityDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Feeder의 경우 Feeder의 앞 뒤 Node 와 Feeder만 제외하고는 모두 삭제
	  * 2012.07.18 정선용 [CHM-201217633] 구주 Hinterland, RF 추가,990번 act grp 살림
	  * </pre>
	  */
	public ProductCatalogHinterlandDAOremoveNonFeederActivityDSQL(){
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
		query.append("FileName : ProductCatalogHinterlandDAOremoveNonFeederActivityDSQL").append("\n"); 
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
		query.append("DELETE PRD_PROD_CTL_ACT_GRP_DTL" ).append("\n"); 
		query.append("WHERE (PCTL_NO, COST_ACT_GRP_SEQ)" ).append("\n"); 
		query.append("IN (" ).append("\n"); 
		query.append("    SELECT PCTL_NO, COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT DECODE(VSL_SLAN_CD, 'FDR', 'Y', 'CAX', 'Y' --   NTST 앞, 뒤에 VESSEL A/G을 추가하여 before , after trans mode를 VD로 할 수 있도록 수정 20121204 전윤주씨 요청" ).append("\n"); 
		query.append("                    ,NVL(DECODE(LEAD(VSL_SLAN_CD) OVER (PARTITION BY PCTL_NO ORDER BY COST_ACT_GRP_SEQ), 'FDR', 'Y')" ).append("\n"); 
		query.append("                      , DECODE(LAG(VSL_SLAN_CD) OVER (PARTITION BY PCTL_NO ORDER BY COST_ACT_GRP_SEQ), 'FDR', 'Y'))" ).append("\n"); 
		query.append("                      ) AS AROUND_FDR" ).append("\n"); 
		query.append("                 , A.PCTL_NO, COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("            FROM PRD_PROD_CTL_ACT_GRP_DTL A" ).append("\n"); 
		query.append("            WHERE PCTL_NO LIKE DECODE(@[hd_pctl_no], NULL, NULL, @[hd_pctl_no] || '%')" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("      WHERE AROUND_FDR IS NULL " ).append("\n"); 
		query.append("        AND COST_ACT_GRP_SEQ <> 990" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}