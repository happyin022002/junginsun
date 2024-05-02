/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandRouteManageDBDAOsearchOptimumRouteCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.06.05 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOsearchOptimumRouteCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주의 등록/수정되는 구간에 Optimum IRG가 있는지 검사
	  * </pre>
	  */
	public InlandRouteManageDBDAOsearchOptimumRouteCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOsearchOptimumRouteCheckRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN @[io_bnd_cd] IN ('B', 'M') THEN 'N'" ).append("\n"); 
		query.append("            WHEN SUBSTR(@[rout_org_nod_cd], 1,5) = SUBSTR(@[rout_dest_nod_cd], 1,5) -- TERMINAL SHUTTLE DOES NOT ALLOW OPTIMUM" ).append("\n"); 
		query.append("                  AND MAX((SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = @[rout_org_nod_cd])) <> 'Z'" ).append("\n"); 
		query.append("                  AND MAX((SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = @[rout_dest_nod_cd])) <> 'Z' THEN 'N' " ).append("\n"); 
		query.append("            WHEN MAX((SELECT COUNT(1)" ).append("\n"); 
		query.append("                    FROM prd_inlnd_rout_mst rmst" ).append("\n"); 
		query.append("                    where ROUT_ORG_NOD_CD = @[rout_org_nod_cd]" ).append("\n"); 
		query.append("                      and ROUT_DEST_NOD_CD = @[rout_dest_nod_cd]" ).append("\n"); 
		query.append("                      and nvl(delt_flg,'N') = 'N'" ).append("\n"); 
		query.append("                      and inlnd_rout_optm_flg = 'Y'" ).append("\n"); 
		query.append("                      and rownum = 1)) = 1 THEN 'N'" ).append("\n"); 
		query.append("            WHEN NVL(MAX(( select 1 " ).append("\n"); 
		query.append("                    from mdm_country mcnt" ).append("\n"); 
		query.append("                       , mdm_subcontinent scnt" ).append("\n"); 
		query.append("                    where mcnt.cnt_cd = substr(@[rout_org_nod_cd], 1,2)" ).append("\n"); 
		query.append("                     and mcnt.sconti_cd = scnt.sconti_cd" ).append("\n"); 
		query.append("                     and scnt.conti_cd = 'E')), 0) " ).append("\n"); 
		query.append("                  + NVL(MAX(( select 1 " ).append("\n"); 
		query.append("                    from mdm_country mcnt" ).append("\n"); 
		query.append("                       , mdm_subcontinent scnt" ).append("\n"); 
		query.append("                    where mcnt.cnt_cd = substr(@[rout_dest_nod_cd], 1,2)" ).append("\n"); 
		query.append("                     and mcnt.sconti_cd = scnt.sconti_cd" ).append("\n"); 
		query.append("                     and scnt.conti_cd = 'E')), 0) = 2 THEN 'Y' -- 양쪽 모두 구주" ).append("\n"); 
		query.append("             ELSE 'N'" ).append("\n"); 
		query.append("        END AS OPTM_CHK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}