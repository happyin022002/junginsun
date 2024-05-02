/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOUnitCostPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOUnitCostPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Port Schedule Unit Cost Port list를 조회한다.
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOUnitCostPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOUnitCostPortRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       V.VPS_PORT_CD AS CODE," ).append("\n"); 
		query.append("       TO_CHAR(V.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS NAME," ).append("\n"); 
		query.append("       V.CLPT_SEQ" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.SLAN_CD      = SUBSTR(@[super_cd1],1,3)" ).append("\n"); 
		query.append("AND    V.VSL_CD       = SUBSTR(@[super_cd2],1,4)" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   = SUBSTR(@[super_cd2],5,4)" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   = SUBSTR(@[super_cd2],9,1)" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("AND    NVL(V.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("ORDER  BY V.CLPT_SEQ, 1, 2" ).append("\n"); 

	}
}