/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOsearchTDRCreateListByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.30 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOsearchTDRCreateListByLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TDR Creation Inquiry 조회
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOsearchTDRCreateListByLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toDt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromDt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOsearchTDRCreateListByLaneRSQL").append("\n"); 
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
		query.append("SELECT V.SLAN_CD" ).append("\n"); 
		query.append(", V.VSL_CD" ).append("\n"); 
		query.append(", V.SKD_VOY_NO" ).append("\n"); 
		query.append(", V.SKD_DIR_CD" ).append("\n"); 
		query.append(", V.CLPT_SEQ" ).append("\n"); 
		query.append(", V.VPS_PORT_CD" ).append("\n"); 
		query.append(", V.VPS_ETD_DT" ).append("\n"); 
		query.append(", DECODE(V.SKD_CNG_STS_CD, 'A', 'Additional calling', 'C', 'Change calling', 'I', 'Phase in', 'O', 'Phase out', 'R', 'Reverse calling', 'S', 'Skip calling', NULL) SKD_CNG_STS_CD" ).append("\n"); 
		query.append(", T.UPDATE_TIME" ).append("\n"); 
		query.append(", DECODE(U.VSL_CD, NULL, 'No', 'Yes') SLOT_USED" ).append("\n"); 
		query.append(", '' FROM_DT" ).append("\n"); 
		query.append(", '' TO_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NVL2( T.VSL_CD, 'Y','N')pagerows" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V, TDR_HEADER T , TDR_UTILIZE U" ).append("\n"); 
		query.append("WHERE V.VSL_CD       = T.VSL_CD(+)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO   = T.VOY_NO(+)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD   = T.DIR_CD(+)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD  = T.PORT_CD(+)" ).append("\n"); 
		query.append("AND V.CLPT_IND_SEQ = T.CALL_IND(+)" ).append("\n"); 
		query.append("AND V.VSL_CD       = U.VSL_CD(+)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO   = U.VOY_NO(+)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD   = U.DIR_CD(+)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD  = U.PORT_CD(+)" ).append("\n"); 
		query.append("AND V.CLPT_IND_SEQ = U.CALL_IND(+)" ).append("\n"); 
		query.append("AND V.SLAN_CD LIKE @[lane]||'%'" ).append("\n"); 
		query.append("AND V.VPS_ETA_DT BETWEEN TO_DATE(@[fromDt], 'YYYYMMDD') AND TO_DATE(@[toDt], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("AND V.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("GROUP BY V.SLAN_CD, V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, V.CLPT_SEQ, V.VPS_PORT_CD, V.VPS_ETD_DT, V.SKD_CNG_STS_CD," ).append("\n"); 
		query.append("DECODE(U.VSL_CD(+), NULL, 'No', 'Yes'), V.CLPT_IND_SEQ,  T.VSL_CD, T.UPDATE_TIME" ).append("\n"); 
		query.append("ORDER BY V.SLAN_CD" ).append("\n"); 
		query.append(", V.VSL_CD" ).append("\n"); 
		query.append(", V.SKD_VOY_NO" ).append("\n"); 
		query.append(", V.SKD_DIR_CD" ).append("\n"); 

	}
}