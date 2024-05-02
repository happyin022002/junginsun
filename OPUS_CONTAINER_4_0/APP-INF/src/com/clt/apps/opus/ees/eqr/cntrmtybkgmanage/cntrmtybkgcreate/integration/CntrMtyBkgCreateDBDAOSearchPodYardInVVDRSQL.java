/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOSearchPodYardInVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.15 
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

public class CntrMtyBkgCreateDBDAOSearchPodYardInVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특정 VVD 의 POD YAD 정보 조회
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOSearchPodYardInVVDRSQL(){
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
		query.append("FileName : CntrMtyBkgCreateDBDAOSearchPodYardInVVDRSQL").append("\n"); 
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
		query.append("SELECT YD_CD|| ' | ' || TO_CHAR(VPS_ETB_DT, 'YYYY-MM-DD HH24:MI:SS') TO_YD_CD" ).append("\n"); 
		query.append("      ,YD_CD||'%%'||TO_CHAR(VPS_ETB_DT, 'YYYY-MM-DD HH24:MI:SS')||'%%'||CLPT_SEQ||'%%'||CLPT_IND_SEQ TO_ETB_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD      = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("AND   SKD_VOY_NO  = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND   SKD_DIR_CD  = SUBSTR(@[vvd], 9, 1) " ).append("\n"); 
		query.append("AND   NVL(SKD_CNG_STS_CD, '  ') <> 'S'  -- skip 제외(하드코딩)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${flag_rob} == 'Y' )" ).append("\n"); 
		query.append("AND   TURN_PORT_FLG <> 'Y'              -- 앞배와 연결되는 TURNING PORT 제외" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ" ).append("\n"); 

	}
}