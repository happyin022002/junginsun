/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOCheckOrgBkgPodIsTurnPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOCheckOrgBkgPodIsTurnPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ORG BKG의 POD 가 TURNING PORT 인지 판단
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOCheckOrgBkgPodIsTurnPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vl_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration ").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOCheckOrgBkgPodIsTurnPortRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN COUNT(*) > 0 THEN 'T'" ).append("\n"); 
		query.append("                              ELSE 'F'" ).append("\n"); 
		query.append("       END TURN_RESULT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("    ,EQR_CTRL_MTY_BKG_EXE B" ).append("\n"); 
		query.append("WHERE B.MTY_BKG_NO = @[vl_bkg_no]  -- VL BKG" ).append("\n"); 
		query.append("AND A.VSL_CD       = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD   = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.YD_CD        = B.POD_YD_CD" ).append("\n"); 
		query.append("AND A.CLPT_IND_SEQ = B.POD_CLPT_IND_SEQ   " ).append("\n"); 
		query.append("AND A.TURN_PORT_IND_CD IN ('D', 'V', 'F')-- 뒷배와 연결되는 조건" ).append("\n"); 
		query.append("AND NVL(A.SKD_CNG_STS_CD, '  ') <> 'S'   -- SKIP 제외  " ).append("\n"); 
		query.append("AND ROWNUM=1       " ).append("\n"); 

	}
}