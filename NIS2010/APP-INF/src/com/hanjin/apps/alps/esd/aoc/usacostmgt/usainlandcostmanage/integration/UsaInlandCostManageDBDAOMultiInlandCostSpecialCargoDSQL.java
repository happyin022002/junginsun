/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaInlandCostManageDBDAOMultiInlandCostSpecialCargoDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.19
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.03.19 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInlandCostManageDBDAOMultiInlandCostSpecialCargoDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiInlandCostSpecialCargo
	  * </pre>
	  */
	public UsaInlandCostManageDBDAOMultiInlandCostSpecialCargoDSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration").append("\n"); 
		query.append("FileName : UsaInlandCostManageDBDAOMultiInlandCostSpecialCargoDSQL").append("\n"); 
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
		query.append("DELETE FROM AOC_USA_INLND_SPCL_TRF_DTL" ).append("\n"); 
		query.append(" WHERE COST_TRF_NO     = @[in_cost_trf_no]" ).append("\n"); 
		query.append("   AND DG_FX_RT = '0'" ).append("\n"); 
		query.append("   AND DG_FX_RTO = '0'" ).append("\n"); 
		query.append("   AND MIN_CGO_WGT = '0'" ).append("\n"); 
		query.append("   AND MAX_CGO_WGT = '0'" ).append("\n"); 
		query.append("   AND OVR_WGT_FX_RT = '0'" ).append("\n"); 
		query.append("   AND OVR_WGT_FX_RTO = '0'" ).append("\n"); 
		query.append("   AND DCGO_SVC_FLG = 'N'" ).append("\n"); 
		query.append("   AND OVWT_CGO_SVC_FLG = 'N'" ).append("\n"); 

	}
}