/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOSearchMtyBkgNoInVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.12
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.10.12 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOSearchMtyBkgNoInVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 에 포함된 VL BKG NO 조회
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOSearchMtyBkgNoInVVDRSQL(){
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
		query.append("FileName : CntrMtyBkgCreateDBDAOSearchMtyBkgNoInVVDRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("      ,BKG_NO_CD" ).append("\n"); 
		query.append("      ,SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(      " ).append("\n"); 
		query.append("    SELECT 'ALL' BKG_NO" ).append("\n"); 
		query.append("          ,'ALL'    BKG_NO_CD" ).append("\n"); 
		query.append("          ,1 SEQ" ).append("\n"); 
		query.append("    FROM DUAL      " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT BKG_NO " ).append("\n"); 
		query.append("          ,BKG_NO BKG_NO_CD" ).append("\n"); 
		query.append("          ,2 SEQ" ).append("\n"); 
		query.append("    FROM BKG_BOOKING" ).append("\n"); 
		query.append("    WHERE VSL_CD     = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("    AND   SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("    AND   SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("    AND   BKG_CGO_TP_CD = 'P'             -- EMPTY BKG" ).append("\n"); 
		query.append("    --AND   NVL(BKG_CRE_TP_CD, ' ') <> 'S'  -- SPLIT BKG 제외" ).append("\n"); 
		query.append("    AND   BKG_STS_CD <> 'X'               -- CANCEL 제외" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY SEQ, BKG_NO" ).append("\n"); 

	}
}