/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AsiaInlandCostManageDBDAOVerifyInlandCostLocGrpCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AsiaInlandCostManageDBDAOVerifyInlandCostLocGrpCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.11.26 변종건 [CHM-201220395-01] TF 참여기간 이후의 후속작업
	  * </pre>
	  */
	public AsiaInlandCostManageDBDAOVerifyInlandCostLocGrpCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration ").append("\n"); 
		query.append("FileName : AsiaInlandCostManageDBDAOVerifyInlandCostLocGrpCntRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(1) CNT" ).append("\n"); 
		query.append("FROM    AOC_EUR_INLND_TRF_DTL" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append("AND     LOC_GRP_NO IS NULL" ).append("\n"); 
		query.append("AND     COST_SEL_ROUT_FLG = 'Y'" ).append("\n"); 
		query.append("AND     DELT_FLG = 'N'" ).append("\n"); 

	}
}