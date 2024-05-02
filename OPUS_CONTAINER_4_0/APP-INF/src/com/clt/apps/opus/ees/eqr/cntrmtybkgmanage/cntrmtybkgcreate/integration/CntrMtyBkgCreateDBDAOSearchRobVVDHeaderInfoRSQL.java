/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOSearchRobVVDHeaderInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOSearchRobVVDHeaderInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROB VVD 정보를 조회, (VL VVD ~ ROB SPLIT VVD)
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOSearchRobVVDHeaderInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_rob",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOSearchRobVVDHeaderInfoRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,ROWNUM NUM       -- 홀수, 짝수 의미 있음." ).append("\n"); 
		query.append("      ,ROWNUM-1 VSL_SEQ -- BKG_VVD 에 입력될 SEQ" ).append("\n"); 
		query.append("      ,N1ST_PORT_BRTH_DT-- DATA 확인용(사용안함)" ).append("\n"); 
		query.append("FROM       " ).append("\n"); 
		query.append("(       " ).append("\n"); 
		query.append("    SELECT A.VSL_CD" ).append("\n"); 
		query.append("          ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,A.SKD_DIR_CD " ).append("\n"); 
		query.append("          ,A.N1ST_PORT_BRTH_DT                                            " ).append("\n"); 
		query.append("    FROM VSK_VSL_SKD A" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("            -- 시작 VVD" ).append("\n"); 
		query.append("            SELECT VSL_CD" ).append("\n"); 
		query.append("                  ,SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,N1ST_PORT_BRTH_DT " ).append("\n"); 
		query.append("            FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("            WHERE VSL_CD     = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("            AND   SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("            AND   SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         ) B" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("            -- 종료 VVD" ).append("\n"); 
		query.append("            SELECT VSL_CD" ).append("\n"); 
		query.append("                  ,SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,N1ST_PORT_BRTH_DT " ).append("\n"); 
		query.append("            FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("            WHERE VSL_CD     = SUBSTR(@[vvd_rob], 0, 4)" ).append("\n"); 
		query.append("            AND   SKD_VOY_NO = SUBSTR(@[vvd_rob], 5, 4)" ).append("\n"); 
		query.append("            AND   SKD_DIR_CD = SUBSTR(@[vvd_rob], 9, 1)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         ) C   " ).append("\n"); 
		query.append("    WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("    AND   A.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("    AND   A.N1ST_PORT_BRTH_DT <= C.N1ST_PORT_BRTH_DT -- B와 C 사이의 시작 SKD" ).append("\n"); 
		query.append("    AND   A.N1ST_PORT_BRTH_DT >= B.N1ST_PORT_BRTH_DT -- B와 C 사이의 시작 SKD" ).append("\n"); 
		query.append("    ORDER BY A.N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}