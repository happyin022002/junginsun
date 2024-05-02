/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TESCommonDBDAOSearchCostCodeChkFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchCostCodeChkFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 의 Manual 입력시 필수 입력 여부 조회
	  * </pre>
	  */
	public TESCommonDBDAOSearchCostCodeChkFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchCostCodeChkFlgRSQL").append("\n"); 
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
		query.append("#if (${coid} == 'vol_rt_chk_flg') " ).append("\n"); 
		query.append("	NVL(VOL_RT_CHK_FLG,'N') VOL_RT_CHK_FLG, " ).append("\n"); 
		query.append("    NVL(VOL_DUP_CHK_FLG,'N') VOL_DUP_CHK_FLG" ).append("\n"); 
		query.append("#elseif (${coid} == 'rmk_chk_flg') " ).append("\n"); 
		query.append("	NVL(RMK_CHK_FLG,'N') RMK_CHK_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM TES_TML_SO_COST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND LGS_COST_CD = @[param_lgs_cost_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}