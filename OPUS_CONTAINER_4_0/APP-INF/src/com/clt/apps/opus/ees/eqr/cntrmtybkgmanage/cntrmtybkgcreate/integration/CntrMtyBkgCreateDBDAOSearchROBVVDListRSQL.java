/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOSearchROBVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.10 
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

public class CntrMtyBkgCreateDBDAOSearchROBVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROB 의 다음 항차의 VVD 들을 조회합니다. (최대 5개)
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOSearchROBVVDListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOSearchROBVVDListRSQL").append("\n"); 
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
		query.append("SELECT A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("      ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD_NM" ).append("\n"); 
		query.append("      ,A.N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD A" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        -- 기준 VVD" ).append("\n"); 
		query.append("        SELECT VSL_CD" ).append("\n"); 
		query.append("              ,SKD_VOY_NO" ).append("\n"); 
		query.append("              ,SKD_DIR_CD" ).append("\n"); 
		query.append("              ,N1ST_PORT_BRTH_DT " ).append("\n"); 
		query.append("        FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("        WHERE VSL_CD      = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("        AND   SKD_VOY_NO  = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("        AND   SKD_DIR_CD  = SUBSTR(@[vvd], 9, 1)                " ).append("\n"); 
		query.append("     ) B" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND   A.N1ST_PORT_BRTH_DT > B.N1ST_PORT_BRTH_DT -- B보다 큰 SKD 찾기(SKD 선후관계 따짐)" ).append("\n"); 
		query.append("AND   ROWNUM <=5                                -- 5개까지 조회" ).append("\n"); 
		query.append("ORDER BY A.N1ST_PORT_BRTH_DT" ).append("\n"); 

	}
}