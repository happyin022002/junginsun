/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommonDBDAOGetCodeSelectRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.05.03 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommonDBDAOGetCodeSelectRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetCodeSelect
	  * </pre>
	  */
	public AGTCommonDBDAOGetCodeSelectRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.common.integration").append("\n"); 
		query.append("FileName : AGTCommonDBDAOGetCodeSelectRSQL").append("\n"); 
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
		query.append("#if (${methodname} == 'searchRevLaneList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*revenue lane의 정보를 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT RLANE_CD NAME" ).append("\n"); 
		query.append(",RLANE_CD CODE" ).append("\n"); 
		query.append("FROM COA_LANE_RGST" ).append("\n"); 
		query.append("WHERE TRD_CD = CASE" ).append("\n"); 
		query.append("WHEN @[str_trd_cd] IS NULL AND @[str_sub_trd_cd] IS NULL" ).append("\n"); 
		query.append("THEN ''" ).append("\n"); 
		query.append("WHEN @[str_trd_cd] IS NULL AND @[str_sub_trd_cd] IS NOT NULL" ).append("\n"); 
		query.append("THEN TRD_CD" ).append("\n"); 
		query.append("ELSE @[str_trd_cd]" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND SUB_TRD_CD = NVL(@[str_sub_trd_cd],SUB_TRD_CD)" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("ORDER BY RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchTradeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Trade콤보의 목록을 가져온다*/" ).append("\n"); 
		query.append("/*TRADE 코드중 COM 이 나오지 않도록 쿼리 수정*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT TRD_CD CODE" ).append("\n"); 
		query.append(",TRD_CD NAME" ).append("\n"); 
		query.append("FROM MDM_TRADE" ).append("\n"); 
		query.append("WHERE VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("AND DELT_FLG  = 'N'" ).append("\n"); 
		query.append("AND TRD_CD    <> 'COM'" ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}