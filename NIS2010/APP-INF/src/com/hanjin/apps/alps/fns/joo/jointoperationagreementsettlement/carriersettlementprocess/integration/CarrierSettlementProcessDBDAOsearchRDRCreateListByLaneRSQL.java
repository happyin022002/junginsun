/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOsearchRDRCreateListByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.29 장강철
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

public class CarrierSettlementProcessDBDAOsearchRDRCreateListByLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDR Upload Inquiry 조회
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOsearchRDRCreateListByLaneRSQL(){
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
		query.append("FileName : CarrierSettlementProcessDBDAOsearchRDRCreateListByLaneRSQL").append("\n"); 
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
		query.append("SELECT S.SLAN_CD,VSL_CD,VOY_NO,DIR_CD,CLPT_SEQ,PORT_CD,VPS_ETD_DT,SKD_CNG_STS_CD,REGION,H_YN  pagerows,UPDATE_TIME" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT V.SLAN_CD ," ).append("\n"); 
		query.append("V.VSL_CD ," ).append("\n"); 
		query.append("V.SKD_VOY_NO VOY_NO ," ).append("\n"); 
		query.append("V.SKD_DIR_CD DIR_CD ," ).append("\n"); 
		query.append("NVL2(R2.REGION,V.CLPT_SEQ,NULL) CLPT_SEQ," ).append("\n"); 
		query.append("NVL2(R2.REGION,V.VPS_PORT_CD,NULL) PORT_CD," ).append("\n"); 
		query.append("NVL2(R2.REGION,V.VPS_ETD_DT,NULL) VPS_ETD_DT," ).append("\n"); 
		query.append("NVL2(R2.REGION,R2.UPDATE_TIME,NULL) UPDATE_TIME," ).append("\n"); 
		query.append("DECODE( R2.REGION, NULL, NULL,  DECODE(V.SKD_CNG_STS_CD, 'A', 'Additional calling', 'C', 'Change calling', 'I', 'Phase in', 'O', 'Phase out', 'R', 'Reverse calling', 'S', 'Skip calling', NULL) ) SKD_CNG_STS_CD ," ).append("\n"); 
		query.append("R2.REGION," ).append("\n"); 
		query.append("NVL2(R2.REGION,'Y','N') H_YN" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("RDR_HEADER R2" ).append("\n"); 
		query.append("WHERE  R2.VSL_CD(+)  = V.VSL_CD" ).append("\n"); 
		query.append("AND    R2.VOY_NO(+)  = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    R2.DIR_CD(+)  = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    R2.PORT_CD(+) = V.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    R2.REGION IS  NOT NULL" ).append("\n"); 
		query.append("AND    V.VPS_ETA_DT BETWEEN TO_DATE(@[fromDt], 'YYYYMMDD') AND TO_DATE(@[toDt], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("AND    V.SLAN_CD = @[lane]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   V.SLAN_CD ," ).append("\n"); 
		query.append("V.VSL_CD ," ).append("\n"); 
		query.append("V.SKD_VOY_NO VOY_NO ," ).append("\n"); 
		query.append("V.SKD_DIR_CD DIR_CD ," ).append("\n"); 
		query.append("NULL CLPT_SEQ," ).append("\n"); 
		query.append("''PORT_CD," ).append("\n"); 
		query.append("NULL VPS_ETD_DT," ).append("\n"); 
		query.append("NULL UPDATE_TIME," ).append("\n"); 
		query.append("'' SKD_CNG_STS_CD ," ).append("\n"); 
		query.append("'' REGION," ).append("\n"); 
		query.append("'N'H_YN" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("NOT EXISTS (SELECT 'Y'  FROM RDR_HEADER R3 WHERE R3.VSL_CD= V.VSL_CD AND R3.VOY_NO  = V.SKD_VOY_NO AND R3.DIR_CD   = V.SKD_DIR_CD  )" ).append("\n"); 
		query.append("AND    V.VPS_ETA_DT BETWEEN TO_DATE(@[fromDt], 'YYYYMMDD') AND TO_DATE(@[toDt], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("AND    V.SLAN_CD = @[lane]" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("GROUP BY S.SLAN_CD,VSL_CD,VOY_NO,DIR_CD,CLPT_SEQ,PORT_CD,VPS_ETD_DT,SKD_CNG_STS_CD,REGION,H_YN,UPDATE_TIME" ).append("\n"); 
		query.append("ORDER BY S.VSL_CD,S.VOY_NO,S.DIR_CD, S.VPS_ETD_DT" ).append("\n"); 

	}
}