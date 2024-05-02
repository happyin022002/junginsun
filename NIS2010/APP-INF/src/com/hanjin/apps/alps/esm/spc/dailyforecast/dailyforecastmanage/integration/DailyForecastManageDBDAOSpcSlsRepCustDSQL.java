/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DailyForecastManageDBDAOSpcSlsRepCustDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.07.26 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSpcSlsRepCustDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * [CHM-201325983-01] SREP 기준으로 삭제되어, 소속변경된 SREP 데이터를 삭제하지 못함 -> OFC 기준으로 변경
	  * </pre>
	  */
	public DailyForecastManageDBDAOSpcSlsRepCustDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSpcSlsRepCustDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("  FROM SPC_SLS_REP_CUST" ).append("\n"); 
		query.append(" WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND CUST_SEQ    = @[cust_seq]" ).append("\n"); 
		query.append("   AND TRD_CD      = @[trade]" ).append("\n"); 
		query.append("#if(${ui_title} == 'account_adddel')" ).append("\n"); 
		query.append("   AND SREP_CD     = @[srep_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND SLS_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                         FROM SPC_OFC_LVL O" ).append("\n"); 
		query.append("                        WHERE TO_CHAR(SYSDATE, 'YYYYWW') BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                          AND O.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                          AND N4TH_PRNT_OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}