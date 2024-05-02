/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PSOCodeFinderDBDAOCheckTurnPortIndCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.10 
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

public class PSOCodeFinderDBDAOCheckTurnPortIndCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TurnPort Check
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public PSOCodeFinderDBDAOCheckTurnPortIndCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.psocommon.psocodefinder.integration").append("\n"); 
		query.append("FileName : PSOCodeFinderDBDAOCheckTurnPortIndCdRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN IO_CNT = TOT_CNT THEN 'IN'" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("       END AS IO_CASE" ).append("\n"); 
		query.append("  FROM (SELECT SUM(DECODE(TURN_PORT_IND_CD, 'D', 1 , 'V', 1, 'F', 1, 0)) AS IO_CNT -- D,V,F >> IN (READ ONLY)" ).append("\n"); 
		query.append("             , COUNT(VPS.VSL_CD||VPS.SKD_VOY_NO||VPS.SKD_DIR_CD||VPS.YD_CD) AS TOT_CNT" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND VPS.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("           AND VPS.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND VPS.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("           AND NVL(VPS.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("           AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}