/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchVvdInlandInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.13 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchVvdInlandInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd combo box 정보를 검색 Execute Plan Inland에서 Fixed Plan에서 Row Add 버튼 클릭시 To LOC(ECC), ETA Week 에 해당하는 정보를 검색
	  * </pre>
	  */
	public CommonDBDAOSearchVvdInlandInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchVvdInlandInfoRSQL").append("\n"); 
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
		query.append("DISTINCT A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append(",B.VSL_SLAN_CD SLAN_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.FM_ETD_DT, 'YYYYMMDD') FM_ETD_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.TO_ETA_DT, 'YYYYMMDD') TO_ETA_DT" ).append("\n"); 
		query.append(",A.FM_YD_CD" ).append("\n"); 
		query.append(",A.TO_YD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_INLND_TRSP_EXE_PLN A," ).append("\n"); 
		query.append("VSK_VSL_SKD B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND   A.VSL_CD IS NOT NULL" ).append("\n"); 
		query.append("AND   SUBSTR(A.FM_YD_CD, 0, 5) IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE ECC_CD = @[fm_loc] )" ).append("\n"); 
		query.append("AND   SUBSTR(A.TO_YD_CD, 0, 5) IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE ECC_CD = @[to_loc] )" ).append("\n"); 
		query.append("AND   TO_CHAR(A.TO_ETA_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("BETWEEN (SELECT WK_ST_DT  FROM EQR_WK_PRD WHERE PLN_YR||PLN_WK = @[eta_week] )" ).append("\n"); 
		query.append("AND     (SELECT WK_END_DT FROM EQR_WK_PRD WHERE PLN_YR||PLN_WK = @[eta_week] )" ).append("\n"); 
		query.append("-- 수동입력에서 사용함" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("' MANUAL INPUT' VVD" ).append("\n"); 
		query.append(",' ' SLAN_CD" ).append("\n"); 
		query.append(",' ' FM_ETD_DT" ).append("\n"); 
		query.append(",' ' TO_ETA_DT" ).append("\n"); 
		query.append(",' ' FM_YD_CD" ).append("\n"); 
		query.append(",' ' TO_YD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}