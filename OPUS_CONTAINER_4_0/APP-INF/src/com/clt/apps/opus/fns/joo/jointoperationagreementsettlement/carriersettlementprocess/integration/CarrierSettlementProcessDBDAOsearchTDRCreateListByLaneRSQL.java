/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOsearchTDRCreateListByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
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
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
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
		query.append("     , V.VSL_CD" ).append("\n"); 
		query.append("     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("     , V.SKD_DIR_CD" ).append("\n"); 
		query.append("     , V.CLPT_SEQ" ).append("\n"); 
		query.append("     , V.VPS_PORT_CD" ).append("\n"); 
		query.append("     , TO_CHAR(V.VPS_ETD_DT,'YYYYMMDDHH24MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("     , (SELECT CO.INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL CO WHERE CO.INTG_CD_ID = 'CD01825' AND CO.INTG_CD_VAL_CTNT = V.SKD_CNG_STS_CD) AS SKD_CNG_STS_CD" ).append("\n"); 
		query.append("     , TO_CHAR(T.UPDATE_TIME,'YYYYMMDDHH24MI') AS UPDATE_TIME" ).append("\n"); 
		query.append("     , DECODE(U.VSL_CD, NULL, 'No', 'Yes') SLOT_USED" ).append("\n"); 
		query.append("     , '' FROM_DT" ).append("\n"); 
		query.append("     , '' TO_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     ,NVL2( T.VSL_CD, 'Y','N')pagerows" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD V, TDR_HEADER T , TDR_UTILIZE U" ).append("\n"); 
		query.append(" WHERE V.VSL_CD       = T.VSL_CD(+)" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO   = T.VOY_NO(+) " ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD   = T.DIR_CD(+)" ).append("\n"); 
		query.append("   AND V.VPS_PORT_CD  = T.PORT_CD(+)" ).append("\n"); 
		query.append("   AND V.CLPT_IND_SEQ = T.CALL_IND(+)" ).append("\n"); 
		query.append("   AND V.VSL_CD       = U.VSL_CD(+)" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO   = U.VOY_NO(+)" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD   = U.DIR_CD(+)" ).append("\n"); 
		query.append("   AND V.VPS_PORT_CD  = U.PORT_CD(+)" ).append("\n"); 
		query.append("   AND V.CLPT_IND_SEQ = U.CALL_IND(+)" ).append("\n"); 
		query.append("   AND V.SLAN_CD LIKE @[lane]||'%'" ).append("\n"); 
		query.append("   AND V.VPS_ETA_DT BETWEEN TO_DATE(@[fromDt], 'YYYYMMDD') AND TO_DATE(@[toDt], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("   AND V.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("   AND NVL(V.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("GROUP BY V.SLAN_CD, V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, V.CLPT_SEQ, V.VPS_PORT_CD, V.VPS_ETD_DT, V.SKD_CNG_STS_CD, " ).append("\n"); 
		query.append("         DECODE(U.VSL_CD(+), NULL, 'No', 'Yes'), V.CLPT_IND_SEQ,  T.VSL_CD, T.UPDATE_TIME" ).append("\n"); 
		query.append("ORDER BY V.SLAN_CD" ).append("\n"); 
		query.append("     , V.VSL_CD" ).append("\n"); 
		query.append("     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("     , V.SKD_DIR_CD" ).append("\n"); 

	}
}