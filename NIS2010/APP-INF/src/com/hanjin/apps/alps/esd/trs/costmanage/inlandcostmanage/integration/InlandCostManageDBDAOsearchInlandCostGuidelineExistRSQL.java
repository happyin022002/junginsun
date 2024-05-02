/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandCostManageDBDAOsearchInlandCostGuidelineExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.20
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.06.20 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandCostManageDBDAOsearchInlandCostGuidelineExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInlandCostGuidelineExist
	  * </pre>
	  */
	public InlandCostManageDBDAOsearchInlandCostGuidelineExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration").append("\n"); 
		query.append("FileName : InlandCostManageDBDAOsearchInlandCostGuidelineExistRSQL").append("\n"); 
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
		query.append("SELECT (--Inland Cost의 Tariff No.가 가장 최신인지 여부 확인" ).append("\n"); 
		query.append("SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("FROM TRS_INLND_COST_TRF_HDR" ).append("\n"); 
		query.append("WHERE CNT_CD    = SUBSTR(@[cost_trf_no], 1,2)" ).append("\n"); 
		query.append("AND IO_BND_CD = SUBSTR(@[cost_trf_no], 9,1)" ).append("\n"); 
		query.append("AND COST_TRF_NO > @[cost_trf_no]" ).append("\n"); 
		query.append(")||','||" ).append("\n"); 
		query.append("(--Inland Cost의 Guideline 존재 여부 확인" ).append("\n"); 
		query.append("SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("FROM PRI_TRF_IHC_HDR" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND COST_TRF_NO = @[cost_trf_no]" ).append("\n"); 
		query.append(") AS EXIST_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}