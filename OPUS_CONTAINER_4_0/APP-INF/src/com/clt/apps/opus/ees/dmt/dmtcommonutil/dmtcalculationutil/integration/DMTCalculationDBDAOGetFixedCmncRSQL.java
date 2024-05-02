/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOGetFixedCmncRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.24 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOGetFixedCmncRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetFixedCmnc
	  * </pre>
	  */
	public DMTCalculationDBDAOGetFixedCmncRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voyage_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtt_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT TO_CHAR (FX_DT, 'YYYYMMDDHH24MI') FIXED_CMNC" ).append("\n"); 
		query.append("FROM DMT_VSL_DT_UPD" ).append("\n"); 
		query.append("WHERE VSL_CD 		= @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO 	= @[skd_voyage_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD 	= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND LOC_CD		= SUBSTR( @[yd_cd], 1, 5 )" ).append("\n"); 
		query.append("#if (${type} == 'fm')" ).append("\n"); 
		query.append("AND VL_VD_DIV_CD	= DECODE( SUBSTR(@[dtt_code],3,1), 'I', 'VD','VL' )" ).append("\n"); 
		query.append("#elseif (${type} == 'to')" ).append("\n"); 
		query.append("AND VL_VD_DIV_CD = 'VL'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND FX_DT IS NOT NULL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetFixedCmncRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}