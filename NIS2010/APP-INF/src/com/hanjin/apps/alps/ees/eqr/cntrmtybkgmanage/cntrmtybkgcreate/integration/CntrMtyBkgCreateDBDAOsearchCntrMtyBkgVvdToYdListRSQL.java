/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdToYdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.23 
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

public class CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdToYdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_EQR_1018
	  * VVD 에 따른 To Yard 및 ETB 조회
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdToYdListRSQL(){
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
		query.append("FileName : CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdToYdListRSQL").append("\n"); 
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
		query.append("--    VVD 의 yard code, etB 정보 " ).append("\n"); 
		query.append("--  2.변수 : vvd         (ANGN3309E, HNAA0006E)    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT YD_CD TO_YD_CD" ).append("\n"); 
		query.append("      ,YD_CD||'%%'||TO_CHAR(VPS_ETB_DT, 'YYYY-MM-DD HH24:MI:SS')||'%%'||CLPT_SEQ||'%%'||CLPT_IND_SEQ  TO_ETB_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD      = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("AND   SKD_VOY_NO  = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND   SKD_DIR_CD  = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND   NVL(SKD_CNG_STS_CD, '  ') <> 'S'  -- skip 제외(하드코딩)" ).append("\n"); 
		query.append("-- 20160623, 유저요청으로 제거, 신용찬" ).append("\n"); 
		query.append("--AND   YD_CD <> 'OMSOHY3'  -- HJS 유저요청에 의해 수정(박해진, 20160526), OMSOHY3 는 POD 포함 안됨." ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ" ).append("\n"); 

	}
}