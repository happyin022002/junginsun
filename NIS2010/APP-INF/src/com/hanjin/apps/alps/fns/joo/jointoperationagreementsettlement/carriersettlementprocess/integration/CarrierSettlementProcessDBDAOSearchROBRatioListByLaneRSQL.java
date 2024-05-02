/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchROBRatioListByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.02
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.03.02 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchROBRatioListByLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROB Container List Inquiry의 Sub-Allocation and Ratio을 조회
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchROBRatioListByLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchROBRatioListByLaneRSQL").append("\n"); 
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
		query.append(" SLAN_CD 	AS rlane_cd" ).append("\n"); 
		query.append(",SKD_DIR_CD AS skd_dir_cd" ).append("\n"); 
		query.append(",JO_20FT_N1ST_RTO" ).append("\n"); 
		query.append(",JO_20FT_SUB_TEU_QTY" ).append("\n"); 
		query.append(",JO_40FT_N1ST_RTO" ).append("\n"); 
		query.append(",JO_40FT_SUB_TEU_QTY" ).append("\n"); 
		query.append(",JO_45FT_N1ST_RTO" ).append("\n"); 
		query.append(",JO_45FT_N2ND_RTO" ).append("\n"); 
		query.append(",JO_45FT_SUB_TEU_QTY" ).append("\n"); 
		query.append(",JO_BSA_TEU_QTY" ).append("\n"); 
		query.append(",CGO_TON_WGT" ).append("\n"); 
		query.append(",JO_TON_TEU_QTY" ).append("\n"); 
		query.append(",JO_RND_RULE_LVL" ).append("\n"); 
		query.append(",SLAN_CD 	AS org_rlane_cd" ).append("\n"); 
		query.append(",SKD_DIR_CD AS org_skd_dir_cd" ).append("\n"); 
		query.append("FROM JOO_ROB_RTO A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${slane_cd} !='')" ).append("\n"); 
		query.append("	AND A.SLAN_CD = @[slane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${skd_dir_cd} !='')" ).append("\n"); 
		query.append("	AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}