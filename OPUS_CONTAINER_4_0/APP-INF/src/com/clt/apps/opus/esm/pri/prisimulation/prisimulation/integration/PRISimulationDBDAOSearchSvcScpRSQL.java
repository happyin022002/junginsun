/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRISimulationDBDAOSearchSvcScpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRISimulationDBDAOSearchSvcScpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multi scope / scope
	  * </pre>
	  */
	public PRISimulationDBDAOSearchSvcScpRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration").append("\n"); 
		query.append("FileName : PRISimulationDBDAOSearchSvcScpRSQL").append("\n"); 
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
		query.append("SELECT (" ).append("\n"); 
		query.append("    SELECT SUBSTR (MAX (SYS_CONNECT_BY_PATH (SVC_SCP_CD, '$')), 2) AS SVC_SCP_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT ROWNUM AS RID," ).append("\n"); 
		query.append("          T.*" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT DISTINCT SVC_SCP_CD" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT A.SVC_SCP_CD ||'-'||C.SVC_SCP_NM AS SVC_SCP_CD" ).append("\n"); 
		query.append("                FROM MDM_SVC_SCP_LMT A ," ).append("\n"); 
		query.append("                  MDM_SVC_SCP_LMT B ," ).append("\n"); 
		query.append("                  MDM_SVC_SCP C" ).append("\n"); 
		query.append("                WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                  AND A.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("                  AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                  AND A.ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("                  AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                  AND A.SVC_SCP_IND_FLG ='Y'" ).append("\n"); 
		query.append("                  AND A.RGN_CD IN (" ).append("\n"); 
		query.append("                    SELECT RGN_CD" ).append("\n"); 
		query.append("                    FROM MDM_LOCATION" ).append("\n"); 
		query.append("                    WHERE LOC_CD = (" ).append("\n"); 
		query.append("                        SELECT /*+ INDEX(P XPKPRD_PROD_CTL_ROUT_DTL) */SUBSTR(ROUT_ORG_NOD_CD,1,5)" ).append("\n"); 
		query.append("                        FROM PRD_PROD_CTL_ROUT_DTL P" ).append("\n"); 
		query.append("                        WHERE PCTL_NO LIKE @[pctl_no]||'%'" ).append("\n"); 
		query.append("                        AND ROWNUM = 1)) -- BKG POR_CD" ).append("\n"); 
		query.append("                  AND B.ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("                  AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                  AND B.SVC_SCP_IND_FLG ='Y'" ).append("\n"); 
		query.append("                  AND B.RGN_CD IN (" ).append("\n"); 
		query.append("                    SELECT RGN_CD" ).append("\n"); 
		query.append("                    FROM MDM_LOCATION" ).append("\n"); 
		query.append("                    WHERE LOC_CD = (" ).append("\n"); 
		query.append("                        SELECT /*+ INDEX_DESC(P XPKPRD_PROD_CTL_ROUT_DTL) */SUBSTR(ROUT_DEST_NOD_CD,1,5)" ).append("\n"); 
		query.append("                        FROM PRD_PROD_CTL_ROUT_DTL P" ).append("\n"); 
		query.append("                        WHERE PCTL_NO LIKE @[pctl_no]||'%'" ).append("\n"); 
		query.append("                        AND ROWNUM = 1)) -- BKG DEL_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("              ) T" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("    START WITH RID = 1 " ).append("\n"); 
		query.append("    CONNECT BY PRIOR RID + 1 = RID " ).append("\n"); 
		query.append(") AS SVC_SCP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}