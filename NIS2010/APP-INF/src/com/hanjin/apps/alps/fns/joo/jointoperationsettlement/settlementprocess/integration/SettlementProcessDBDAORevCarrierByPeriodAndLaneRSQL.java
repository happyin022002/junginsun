/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SettlementProcessDBDAORevCarrierByPeriodAndLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.03.03 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAORevCarrierByPeriodAndLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JO Revenue Loading Information에서 사용하는 Carrier Code 조회
	  * </pre>
	  */
	public SettlementProcessDBDAORevCarrierByPeriodAndLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_fr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pre_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAORevCarrierByPeriodAndLaneRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT P.CRR_CD CODE" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD S, JOO_BAY_PLN P" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND ( (S.VPS_ETA_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                        AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') + 0.99999) OR S.VPS_ETA_DT IS NULL )" ).append("\n"); 
		query.append("AND S.SLAN_CD LIKE SUBSTR(@[rlane_cd],1,3) || '%'" ).append("\n"); 
		query.append("AND S.VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("AND S.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("AND S.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("AND S.VPS_PORT_CD = P.VPS_PORT_CD" ).append("\n"); 
		query.append("#if (${rlane_cd} == 'QIS')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" 'DYP' AS CODE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}