/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : NetworkDistributionDBDAOSearchLaneTSCommitmentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.20
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.12.20 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOSearchLaneTSCommitmentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLaneTSCommitmentList SELECT
	  * 
	  * Ticket No : CHM-201006017-01
	  * 개발자 : 김기종
	  * 아주 노선 선복사용량에 대한 원양으로의 운항 변고정비 배부 로직(약정율) 추가 요청
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchLaneTSCommitmentListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cobtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_coblane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cobdir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cobioc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchLaneTSCommitmentListRSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON" ).append("\n"); 
		query.append("      , FM_TRD_CD" ).append("\n"); 
		query.append("      , FM_RLANE_CD" ).append("\n"); 
		query.append("      , FM_IOC_CD" ).append("\n"); 
		query.append("      , FM_DIR_CD" ).append("\n"); 
		query.append("      , FM_HUL_BND_CD" ).append("\n"); 
		query.append("      , TO_TRD_CD" ).append("\n"); 
		query.append("      , TO_HUL_BND_CD" ).append("\n"); 
		query.append("      , BSA_CMMT_AMT" ).append("\n"); 
		query.append("      , BSA_CMMT_RTO" ).append("\n"); 
		query.append("      , TO_TRD_CD_SEQ" ).append("\n"); 
		query.append("      , RANK" ).append("\n"); 
		query.append("      , DIR_RANK" ).append("\n"); 
		query.append("      , DECODE(FM_DIR_CD, 'E', BSA_CMMT_AMT) E_AMT" ).append("\n"); 
		query.append("      , DECODE(FM_DIR_CD, 'W', BSA_CMMT_AMT) W_AMT" ).append("\n"); 
		query.append("      , DECODE(FM_DIR_CD, 'E', BSA_CMMT_RTO) E_RATIO" ).append("\n"); 
		query.append("      , DECODE(FM_DIR_CD, 'W', BSA_CMMT_RTO) W_RATIO" ).append("\n"); 
		query.append("      , ROW_TYPE" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (SELECT A.COST_YRMON  AS COST_YRMON" ).append("\n"); 
		query.append("              , A.FM_TRD_CD   AS FM_TRD_CD" ).append("\n"); 
		query.append("              , A.FM_RLANE_CD AS FM_RLANE_CD" ).append("\n"); 
		query.append("              , A.FM_IOC_CD   AS FM_IOC_CD" ).append("\n"); 
		query.append("              , A.FM_DIR_CD   AS FM_DIR_CD" ).append("\n"); 
		query.append("              , A.FM_HUL_BND_CD" ).append("\n"); 
		query.append("              , A.TO_TRD_CD AS TO_TRD_CD" ).append("\n"); 
		query.append("              , DECODE(A.TO_TRD_CD, 'IAS', '', A.TO_HUL_BND_CD) TO_HUL_BND_CD" ).append("\n"); 
		query.append("              , A.BSA_CMMT_AMT AS BSA_CMMT_AMT" ).append("\n"); 
		query.append("              , A.BSA_CMMT_RTO" ).append("\n"); 
		query.append("              , DECODE(A.TO_TRD_CD, 'AES', 1, 'TPS', 2, 'EMS', 3, 'IAS', 4) TO_TRD_CD_SEQ" ).append("\n"); 
		query.append("              , DENSE_RANK() OVER( ORDER BY A.COST_YRMON, A.FM_TRD_CD, A.FM_RLANE_CD, A.FM_IOC_CD) AS RANK" ).append("\n"); 
		query.append("              , DENSE_RANK() OVER( ORDER BY A.COST_YRMON, A.FM_TRD_CD, A.FM_RLANE_CD, A.FM_IOC_CD) AS DIR_RANK" ).append("\n"); 
		query.append("              , '' ROW_TYPE" ).append("\n"); 
		query.append("           FROM COA_LANE_TS_BSA_CMMT A" ).append("\n"); 
		query.append("          WHERE A.COST_YRMON = REPLACE(@[f_yearmonth],'-','')" ).append("\n"); 
		query.append(" 	#if (${f_cobtrade} != '')" ).append("\n"); 
		query.append("            AND A.FM_TRD_CD = @[f_cobtrade]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_coblane} != '')" ).append("\n"); 
		query.append("            AND A.FM_RLANE_CD = @[f_coblane]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_cobioc} != '')" ).append("\n"); 
		query.append("            AND A.FM_IOC_CD = @[f_cobioc]" ).append("\n"); 
		query.append("	#end	" ).append("\n"); 
		query.append("    #if (${f_cobdir} != '')" ).append("\n"); 
		query.append("            AND A.FM_DIR_CD = @[f_cobdir]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("ORDER BY FM_TRD_CD" ).append("\n"); 
		query.append("      , FM_RLANE_CD" ).append("\n"); 
		query.append("      , FM_IOC_CD" ).append("\n"); 
		query.append("    --  , FM_DIR_CD" ).append("\n"); 
		query.append("      , DECODE(FM_HUL_BND_CD,'HH',1,2)" ).append("\n"); 
		query.append("      , DECODE(TO_TRD_CD, 'AES', 1, 'TPS', 2, 'EMS', 3, 'IAS', 4)" ).append("\n"); 
		query.append("      , DECODE(TO_HUL_BND_CD,'HH',1,2)" ).append("\n"); 

	}
}