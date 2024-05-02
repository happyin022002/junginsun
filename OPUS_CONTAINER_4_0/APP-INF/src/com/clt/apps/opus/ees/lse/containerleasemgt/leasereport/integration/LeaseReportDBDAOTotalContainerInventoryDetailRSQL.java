/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LeaseReportDBDAOTotalContainerInventoryDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.12.29 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOTotalContainerInventoryDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선사의 관리하는 자가 및 임차장비의 상세내역을 조회합니다.
	  * </pre>
	  */
	public LeaseReportDBDAOTotalContainerInventoryDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOTotalContainerInventoryDetailRSQL").append("\n"); 
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
		query.append("SELECT  ROW_SEQ, LSTM_CD, AGMT_CTY_CD, AGMT_SEQ, REF_NO, " ).append("\n"); 
		query.append("        CNTR_TPSZ_CD, CNTR_NO, ONH_DT, ONH_YD_CD, ONH_FREE_DYS, " ).append("\n"); 
		query.append("        MIN_ONH_DYS, USED_DYS, CNMV_DT, CNTR_STS_CD, CNMV_STS_CD, CRNT_YD_CD, VNDR_SEQ, VNDR_ABBR_NM" ).append("\n"); 
		query.append("FROM   (SELECT  ROW_NUMBER() OVER (ORDER BY A.CNTR_NO) AS ROW_SEQ" ).append("\n"); 
		query.append("              , C.LSTM_CD" ).append("\n"); 
		query.append("              , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("              , A.AGMT_SEQ" ).append("\n"); 
		query.append("              , C.REF_NO" ).append("\n"); 
		query.append("              , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , A.CNTR_NO " ).append("\n"); 
		query.append("              , TO_CHAR(A.ONH_DT,'YYYYMMDD') AS ONH_DT" ).append("\n"); 
		query.append("              , A.ONH_YD_CD" ).append("\n"); 
		query.append("              , A.ONH_FREE_DYS" ).append("\n"); 
		query.append("              , A.MIN_ONH_DYS" ).append("\n"); 
		query.append("        	  , CASE WHEN C.LSTM_CD IN('OW','LP','OL') THEN ROUND(TRUNC(SYSDATE) - A.ONH_DT) + 1" ).append("\n"); 
		query.append("        			 ELSE ROUND(TRUNC(SYSDATE) - A.ONH_DT) + 1 END USED_DYS" ).append("\n"); 
		query.append("        	  , TO_CHAR(A.CNMV_DT,'YYYYMMDD') AS CNMV_DT " ).append("\n"); 
		query.append("        	  , A.CNTR_STS_CD" ).append("\n"); 
		query.append("              , A.CNMV_STS_CD" ).append("\n"); 
		query.append("              , A.CRNT_YD_CD" ).append("\n"); 
		query.append("              , C.VNDR_SEQ" ).append("\n"); 
		query.append("              , (SELECT MV.VNDR_ABBR_NM" ).append("\n"); 
		query.append("                   FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("                  WHERE MV.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("                    AND ROWNUM      = 1) AS VNDR_ABBR_NM " ).append("\n"); 
		query.append("        FROM    MST_CONTAINER A," ).append("\n"); 
		query.append("                LSE_AGREEMENT C            " ).append("\n"); 
		query.append("        WHERE   A.CNTR_STS_CD NOT IN ('LSO','DIO','DON','SCR','TLL','SLD','SRO')" ).append("\n"); 
		query.append("        AND     A.AGMT_CTY_CD = C.AGMT_CTY_CD        " ).append("\n"); 
		query.append("        AND     A.AGMT_SEQ = C.AGMT_SEQ        " ).append("\n"); 
		query.append("        AND     A.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("    #if (${agmt_seq} != '')" ).append("\n"); 
		query.append("        AND     A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("        AND     A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("		AND     C.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("	#end						" ).append("\n"); 
		query.append("    #if (${loc_tp} == 'RCC')" ).append("\n"); 
		query.append("        AND     A.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("    #elseif (${loc_tp} == 'LCC')" ).append("\n"); 
		query.append("        AND     A.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("    #elseif (${loc_tp} == 'SCC')" ).append("\n"); 
		query.append("        AND     A.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("    #end						  " ).append("\n"); 
		query.append("    #if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("        AND     A.CNMV_STS_CD IN (" ).append("\n"); 
		query.append("        #foreach($key IN ${cnmv_sts_cd_seq})" ).append("\n"); 
		query.append("            #if($velocityCount < $cnmv_sts_cd_seq.size())" ).append("\n"); 
		query.append("                '$key'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                '$key'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("        AND     C.LSTM_CD IN (" ).append("\n"); 
		query.append("        #foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("            #if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("                '$key'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                '$key'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    #if (${cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("        AND     A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("        #foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("            #if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("                '$key'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                '$key'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${startno} != '') " ).append("\n"); 
		query.append(" WHERE 	ROW_SEQ BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}