/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOcheckCntrMtyBkgVvdWaterIsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOcheckCntrMtyBkgVvdWaterIsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 입력값 TURNK FEEDER 여부 확인
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOcheckCntrMtyBkgVvdWaterIsRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration ").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOcheckCntrMtyBkgVvdWaterIsRSQL").append("\n"); 
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
		query.append("SELECT DECODE(C.VSL_SVC_TP_CD, NULL, 'W', 'O', 'W', 'T') SVC_TP_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD      B" ).append("\n"); 
		query.append("    ,MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("WHERE B.VSL_SLAN_CD = C.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("AND   B.VSL_CD      = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("AND   B.SKD_VOY_NO  = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND   B.SKD_DIR_CD  = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 

	}
}