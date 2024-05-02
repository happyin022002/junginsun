/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchVLVDDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.16 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchVLVDDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VL/VD UPDATE 정보의 Free Time 시작일을 조회한다.
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchVLVDDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchVLVDDateRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR (FX_DT, 'YYYYMMDD') FIXED_CMNC" ).append("\n"); 
		query.append("FROM DMT_VSL_DT_UPD" ).append("\n"); 
		query.append("WHERE VSL_CD 		= SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO 	= SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD 	= SUBSTR(@[vvd_cd], 9)" ).append("\n"); 
		query.append("AND LOC_CD		= SUBSTR(@[yd_cd], 1, 5 )" ).append("\n"); 
		query.append("#if (${type} == 'fm')" ).append("\n"); 
		query.append("AND VL_VD_DIV_CD	= DECODE(SUBSTR(@[dmdt_trf_cd],3,1), 'I', 'VD','VL' )" ).append("\n"); 
		query.append("#elseif (${type} == 'to')" ).append("\n"); 
		query.append("AND VL_VD_DIV_CD = 'VL'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND FX_DT IS NOT NULL" ).append("\n"); 

	}
}