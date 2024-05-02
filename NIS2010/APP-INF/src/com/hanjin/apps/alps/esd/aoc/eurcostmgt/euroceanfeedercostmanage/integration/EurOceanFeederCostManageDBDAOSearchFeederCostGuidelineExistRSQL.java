/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurOceanFeederCostManageDBDAOSearchFeederCostGuidelineExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurOceanFeederCostManageDBDAOSearchFeederCostGuidelineExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFeederCostGuidelineExist
	  * </pre>
	  */
	public EurOceanFeederCostManageDBDAOSearchFeederCostGuidelineExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.integration").append("\n"); 
		query.append("FileName : EurOceanFeederCostManageDBDAOSearchFeederCostGuidelineExistRSQL").append("\n"); 
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
		query.append("SELECT  (	--Ocean Feeder Cost의 Tariff No.가 가장 최신인지 여부 확인" ).append("\n"); 
		query.append("          SELECT  CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("          FROM    AOC_EUR_FDR_TRF_HDR" ).append("\n"); 
		query.append("          WHERE   RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("          AND     COST_TRF_NO > @[cost_trf_no]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        ||','||" ).append("\n"); 
		query.append("        (	--Ocean Feeder Cost의 Guideline 존재 여부 확인" ).append("\n"); 
		query.append("          SELECT  CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("          FROM    PRI_TRF_FDR_COST_VER_MAPG" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("          AND     FDR_COST_TRF_NO = @[cost_trf_no]" ).append("\n"); 
		query.append("        ) AS EXIST_FLG" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}