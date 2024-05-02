/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOSearchLocDischargeYardInitialInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchLocDischargeYardInitialInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_EQR_0059 Discharge LOC 콤보로 가져오기
	  * </pre>
	  */
	public CommonDBDAOSearchLocDischargeYardInitialInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vslCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skdVoyNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skdDirCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchLocDischargeYardInitialInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("--A.YD_CD AS YD_CD" ).append("\n"); 
		query.append("TO_CHAR(ROW_NUMBER()OVER(ORDER BY VPS_ETB_DT), '00')||'-'||A.YD_CD AS YD_CD" ).append("\n"); 
		query.append(", TO_CHAR(VPS_ETB_DT,'YYYY-MM-DD HH24:MI:SS','NLS_DATE_LANGUAGE=AMERICAN') AS VSL_ETB_DT  " ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("MDM_YARD B" ).append("\n"); 
		query.append("WHERE A.YD_CD = B.YD_CD" ).append("\n"); 
		query.append("AND   A.VSL_CD = @[vslCd]" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO = @[skdVoyNo]" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD = @[skdDirCd]" ).append("\n"); 
		query.append("AND   A.CLPT_SEQ > NVL(( SELECT MIN(SUB.CLPT_SEQ)" ).append("\n"); 
		query.append("                         FROM VSK_VSL_PORT_SKD SUB" ).append("\n"); 
		query.append("                        WHERE SUB.VSL_CD = @[vslCd]" ).append("\n"); 
		query.append("                         AND   SUB.SKD_VOY_NO = @[skdVoyNo]" ).append("\n"); 
		query.append("                         AND   SUB.SKD_DIR_CD = @[skdDirCd]" ).append("\n"); 
		query.append("                         AND   SUB.VPS_PORT_CD = SUBSTR(@[ecc] , 0, 5)" ).append("\n"); 
		query.append("                         GROUP BY SUB.VSL_CD, SUB.SKD_VOY_NO, SKD_DIR_CD), 0)" ).append("\n"); 

	}
}