/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EQCOrgChartDBDAOEQCOrgChartListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQCOrgChartDBDAOEQCOrgChartListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQC Organization Chart 의 목록을 가져온다
	  * </pre>
	  */
	public EQCOrgChartDBDAOEQCOrgChartListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.integration").append("\n"); 
		query.append("FileName : EQCOrgChartDBDAOEQCOrgChartListRSQL").append("\n"); 
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
		query.append("SELECT A.TLEVEL" ).append("\n"); 
		query.append("     , A.UNIT" ).append("\n"); 
		query.append("     , A.LOC_CD" ).append("\n"); 
		query.append("     , A.PRNT_LOC_ID" ).append("\n"); 
		query.append("     , A.LOC_DPTH_CD" ).append("\n"); 
		query.append("     , C.CHK" ).append("\n"); 
		query.append("  FROM (      " ).append("\n"); 
		query.append("         SELECT LEVEL TLEVEL" ).append("\n"); 
		query.append("              , LOC_CD||DECODE(LOC_DPTH_CD, 'R', ' (RCC)', 'L', ' (LCC)', 'E', ' (ECC)', 'S', ' (SCC)', '') UNIT " ).append("\n"); 
		query.append("              , LOC_CD" ).append("\n"); 
		query.append("              , PRNT_LOC_ID" ).append("\n"); 
		query.append("              , LOC_DPTH_CD" ).append("\n"); 
		query.append("           FROM EQR_LOC_LVL" ).append("\n"); 
		query.append("         CONNECT BY NOCYCLE PRIOR LOC_ID = PRNT_LOC_ID" ).append("\n"); 
		query.append("         START WITH LOC_CD = 'All'" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("                   SELECT DISTINCT SCC_CD LOC_CD, 'S' LOC_DPTH_CD FROM MDM_EQ_ORZ_CHT WHERE DELT_FLG = 'N' AND RCC_CD IN ('TWTPE','HKHKG','CNSHA','JPTYO','KRSEL','SGSIN')" ).append("\n"); 
		query.append("         UNION ALL SELECT DISTINCT ECC_CD LOC_CD, 'E' LOC_DPTH_CD FROM MDM_EQ_ORZ_CHT WHERE DELT_FLG = 'N' AND RCC_CD IN ('TWTPE','HKHKG','CNSHA','JPTYO','KRSEL','SGSIN')" ).append("\n"); 
		query.append("         UNION ALL SELECT DISTINCT LCC_CD LOC_CD, 'L' LOC_DPTH_CD FROM MDM_EQ_ORZ_CHT WHERE DELT_FLG = 'N' AND RCC_CD IN ('TWTPE','HKHKG','CNSHA','JPTYO','KRSEL','SGSIN')" ).append("\n"); 
		query.append("         UNION ALL SELECT DISTINCT RCC_CD LOC_CD, 'R' LOC_DPTH_CD FROM MDM_EQ_ORZ_CHT WHERE DELT_FLG = 'N' AND RCC_CD IN ('TWTPE','HKHKG','CNSHA','JPTYO','KRSEL','SGSIN')" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("         SELECT '1' CHK, LOC_CD, LOC_DPTH_CD FROM EQR_CTRL_FCAST_LOC" ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append(" WHERE A.LOC_CD      = B.LOC_CD" ).append("\n"); 
		query.append(" AND   A.LOC_DPTH_CD = B.LOC_DPTH_CD " ).append("\n"); 
		query.append(" AND   A.LOC_CD      = C.LOC_CD(+)" ).append("\n"); 
		query.append(" AND   A.LOC_DPTH_CD = C.LOC_DPTH_CD(+)" ).append("\n"); 

	}
}