/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOcheckCntrMtyBkgEtbDtRSQL.java
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

public class CntrMtyBkgCreateDBDAOcheckCntrMtyBkgEtbDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard 정보를 조건으로 ETB DT 데이타 정보 추출
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOcheckCntrMtyBkgEtbDtRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOcheckCntrMtyBkgEtbDtRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(VPS_ETB_DT, 'YYYY-MM-DD HH24:MI:SS') TO_YD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD      = SUBSTR(@[vvd], 0, 4) " ).append("\n"); 
		query.append("AND   SKD_VOY_NO  = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND   SKD_DIR_CD  = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND   NVL(SKD_CNG_STS_CD, '  ') <> 'S'  -- skip 제외(하드코딩)" ).append("\n"); 
		query.append("AND   YD_CD		  = @[yd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ " ).append("\n"); 

	}
}