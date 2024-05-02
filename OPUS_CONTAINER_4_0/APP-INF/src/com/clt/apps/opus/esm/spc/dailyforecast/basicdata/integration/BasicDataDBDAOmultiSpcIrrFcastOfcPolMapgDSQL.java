/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BasicDataDBDAOmultiSpcIrrFcastOfcPolMapgDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOmultiSpcIrrFcastOfcPolMapgDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 불규칙한 Lane-Ofc-POL 삭제
	  * </pre>
	  */
	public BasicDataDBDAOmultiSpcIrrFcastOfcPolMapgDSQL(){
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
		params.put("ioc_ts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOmultiSpcIrrFcastOfcPolMapgDSQL").append("\n"); 
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
		query.append("DELETE " ).append("\n"); 
		query.append("  FROM SPC_IRR_FCAST_OFC_POL_MAPG" ).append("\n"); 
		query.append(" WHERE REP_TRD_CD     = @[rep_trd_cd]" ).append("\n"); 
		query.append("   AND REP_SUB_TRD_CD = @[rep_sub_trd_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD         = @[dir_cd]" ).append("\n"); 
		query.append("   AND IOC_TS_CD      = DECODE(@[ioc_ts_cd], 'OCN', 'O', 'IPC', 'I', 'T/S', 'T')" ).append("\n"); 
		query.append("   AND VSL_CD         = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO     = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD     = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("   AND SLS_OFC_CD     = @[sls_ofc_cd]" ).append("\n"); 

	}
}