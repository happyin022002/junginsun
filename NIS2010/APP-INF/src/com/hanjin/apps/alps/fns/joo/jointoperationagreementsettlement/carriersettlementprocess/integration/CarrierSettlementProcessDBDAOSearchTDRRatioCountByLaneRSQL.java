/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchTDRRatioCountByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchTDRRatioCountByLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTDRRatioCountByLane
	  * 1. Ticket No  : CHM-201322276
	  *    개발자 : 이수진
	  *    Ticket Title : [ALPS JOO] 모델링 표준에 맞게 처리 되도록 테이블 칼럼 변경 작업 및 기능 변경
	  *    Description  :  JO_REP_CRR_CD_FLG => JO_REP_CRR_FLG으로 컬럼명 변경 작업
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchTDRRatioCountByLaneRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchTDRRatioCountByLaneRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CARRIER_CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT NVL(B.OPR_CD, 'ZZZ') OPR_CD," ).append("\n"); 
		query.append("K.SLAN_CD" ).append("\n"); 
		query.append("FROM BAY_PLAN B," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("WHERE ( (K.VPS_ETD_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') + 0.99999) OR K.VPS_ETD_DT IS NULL)" ).append("\n"); 
		query.append("AND K.VSL_CD       = B.VSL_CD" ).append("\n"); 
		query.append("AND K.SKD_VOY_NO   = B.VOY_NO" ).append("\n"); 
		query.append("AND K.SKD_DIR_CD   = B.DIR_CD" ).append("\n"); 
		query.append("AND K.VPS_PORT_CD  = B.PORT_CD" ).append("\n"); 
		query.append("AND K.CLPT_IND_SEQ = B.CALL_IND" ).append("\n"); 
		query.append("AND B.PLAN_TYPE    = 'F'" ).append("\n"); 
		query.append("AND K.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("AND K.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append(") A, JOO_TDR_RTO B" ).append("\n"); 
		query.append("WHERE A.SLAN_CD = B.RLANE_CD(+)" ).append("\n"); 
		query.append("AND A.OPR_CD = B.JO_CRR_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${opr_cd} !='')" ).append("\n"); 
		query.append("AND B.JO_CRR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NVL(B.JO_REP_CRR_FLG, 'N') = 'Y'" ).append("\n"); 

	}
}