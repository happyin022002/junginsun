/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PSOCodeFinderDBDAOSearchClptIndSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.psocommon.psocodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSOCodeFinderDBDAOSearchClptIndSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CLPT_IND_SEQ 조회
	  * </pre>
	  */
	public PSOCodeFinderDBDAOSearchClptIndSeqRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.psocommon.psocodefinder.integration").append("\n"); 
		query.append("FileName : PSOCodeFinderDBDAOSearchClptIndSeqRSQL").append("\n"); 
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
		query.append("SELECT A.YD_CD" ).append("\n"); 
		query.append("     , LISTAGG(A.CLPT_IND_SEQ,'|') WITHIN GROUP (ORDER BY A.YD_CD) AS CLPA_IND_SEQS" ).append("\n"); 
		query.append("  FROM (SELECT VP.VPS_PORT_CD" ).append("\n"); 
		query.append("             , VP.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , VP.YD_CD" ).append("\n"); 
		query.append("             , VP.CLPT_SEQ" ).append("\n"); 
		query.append("             , COUNT(*) OVER (PARTITION BY VP.YD_CD) DIVIDE_CNT" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD VP" ).append("\n"); 
		query.append("             , VSK_VSL_SKD VS" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND VS.VSL_CD        = SUBSTR(@[vvd] , 1, 4)" ).append("\n"); 
		query.append("           AND VS.SKD_VOY_NO    = SUBSTR(@[vvd] , 5, 4)" ).append("\n"); 
		query.append("           AND VS.SKD_DIR_CD    = SUBSTR(@[vvd] , 9, 1)" ).append("\n"); 
		query.append("           AND VP.VSL_CD        = VS.VSL_CD" ).append("\n"); 
		query.append("           AND VP.SKD_VOY_NO    = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VP.SKD_DIR_CD    = VS.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND VP.YD_CD         = @[yd_cd]" ).append("\n"); 
		query.append("           AND 'S'              <> NVL(VP.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("           AND 'N'              = NVL(VP.VT_ADD_CALL_FLG, 'N')" ).append("\n"); 
		query.append("           AND VP.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("         ORDER BY VP.CLPT_SEQ " ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" GROUP BY A.YD_CD" ).append("\n"); 

	}
}