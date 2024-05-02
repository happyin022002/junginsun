/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdFmYdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdFmYdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_EQR_1018
	  * VVD 에 따른 From Yard 및 ETB 조회
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdFmYdListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdFmYdListRSQL").append("\n"); 
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
		query.append("--  1.정의 " ).append("\n"); 
		query.append("--    VVD 의 yard code, etd 정보" ).append("\n"); 
		query.append("--  2.변수 : vvd         (ANGN3309E, HNAA0006E)    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT YD_CD FM_YD_CD" ).append("\n"); 
		query.append("      ,YD_CD||'%%'||TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD HH24:MI:SS')||'%%'||CLPT_SEQ||'%%'||CLPT_IND_SEQ       FM_ETD_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD      = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("AND   SKD_VOY_NO  = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND   SKD_DIR_CD  = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND   NVL(SKD_CNG_STS_CD, '  ') <> 'S'  -- skip 제외(하드코딩) " ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ" ).append("\n"); 

	}
}